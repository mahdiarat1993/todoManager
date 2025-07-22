package ir.aratsoft.todomanager.lint

import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UClass

class UiClassNamingDetector : Detector(), SourceCodeScanner {

    companion object {
        val ISSUE = Issue.create(
            id = "UiClassNamingConvention",
            briefDescription = "UI class name should end with Screen or View",
            explanation = "To maintain consistency, UI classes should be named with suffix 'Screen' or 'View'.",
            category = Category.CORRECTNESS,
            priority = 4,
            severity = Severity.WARNING,
            implementation = Implementation(
                UiClassNamingDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }

    override fun visitClass(context: JavaContext, declaration: UClass) {
        val name = declaration.name ?: return

        val isUiClass = context.file.path.contains("/ui/") || name.contains("Composable", ignoreCase = true)

        if (isUiClass && !name.endsWith("Screen") && !name.endsWith("View")) {
            val location = declaration.sourcePsi?.let { context.getLocation(it) }
            if (location != null) {
                context.report(
                    ISSUE,
                    declaration,
                    location,
                    "UI class name should end with 'Screen' or 'View'"
                )
            }
        }
    }

}