package ir.aratsoft.lint

import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UastVisibility

class MutableLiveDataExposureDetector : Detector(), SourceCodeScanner {

    companion object {
        val ISSUE = Issue.create(
            id = "MutableLiveDataExposure",
            briefDescription = "Do not expose MutableLiveData",
            explanation = "Expose LiveData instead of MutableLiveData to enforce immutability from outside ViewModel.",
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                MutableLiveDataExposureDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }

    override fun visitClass(context: JavaContext, declaration: UClass) {
        for (field in declaration.fields) {
            val type = field.type.canonicalText
            val isPublic = field.visibility == UastVisibility.PUBLIC

            if (type.contains("MutableLiveData") && isPublic) {
                context.report(
                    ISSUE,
                    field,
                    context.getLocation(field),
                    "Do not expose MutableLiveData directly. Use LiveData instead."
                )
            }
        }
    }
}