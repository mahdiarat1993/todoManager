package ir.aratsoft.lint

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.UClass

class RememberStateInComposableDetector : Detector(), SourceCodeScanner {

    companion object {
        val ISSUE = Issue.create(
            id = "RememberStateInComposable",
            briefDescription = "Avoid keeping state with remember in Composable",
            explanation = "Prefer ViewModel or rememberSaveable for state that should survive recompositions.",
            category = Category.CORRECTNESS,
            priority = 5,
            severity = Severity.WARNING,
            implementation = Implementation(
                RememberStateInComposableDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }

    override fun getApplicableMethodNames() = listOf("remember")

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        val fileName = context.file.name
        if (fileName.endsWith(".kt") && node.sourcePsi?.text?.contains("mutableStateOf") == true) {
            context.report(
                ISSUE,
                node,
                context.getLocation(node),
                "Avoid keeping state with remember; consider ViewModel or rememberSaveable"
            )
        }
    }
}