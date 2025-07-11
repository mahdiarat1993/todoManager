package ir.aratsoft.lint

import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UClass


class RepositoryInViewModelDetector : Detector(), SourceCodeScanner {

    companion object {
        val ISSUE: Issue = Issue.create(
            id = "RepositoryInViewModel",
            briefDescription = "Avoid using Repository directly in ViewModel",
            explanation = """
                ViewModel should not directly depend on Repository classes. \
                Use UseCases or interfaces instead to follow Clean Architecture principles.
            """.trimIndent(),
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.ERROR,
            implementation = Implementation(
                RepositoryInViewModelDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }

    override fun applicableSuperClasses(): List<String> = listOf("androidx.lifecycle.ViewModel")

    override fun visitClass(context: JavaContext, declaration: UClass) {
        if (!declaration.name?.endsWith("ViewModel")!!) return

        for (field in declaration.fields) {
            val typeName = field.type.canonicalText
            if (typeName.contains("Repository")) {
                context.report(
                    ISSUE,
                    field,
                    context.getLocation(field),
                    "Avoid using Repository directly in ViewModel"
                )
            }
        }
    }
}