package ir.aratsoft.todomanager.lint

import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UClass

class ContextInViewModelDetector : Detector(), SourceCodeScanner {

    companion object {
        val ISSUE = Issue.create(
            id = "ContextInViewModel",
            briefDescription = "Avoid using Context in ViewModel",
            explanation = "ViewModel should not hold a reference to Context to avoid memory leaks.",
            category = Category.CORRECTNESS,
            priority = 7,
            severity = Severity.ERROR,
            implementation = Implementation(
                ContextInViewModelDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }

    override fun applicableSuperClasses() = listOf("androidx.lifecycle.ViewModel")

    override fun visitClass(context: JavaContext, declaration: UClass) {
        for (field in declaration.fields) {
            val type = field.type.canonicalText
            if (type.contains("Context")) {
                context.report(
                    ISSUE,
                    field,
                    context.getLocation(field),
                    "Avoid using Context in ViewModel"
                )
            }
        }
    }
}