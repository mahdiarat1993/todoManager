package ir.aratsoft.todomanager.lint


import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue

class CustomIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(
            RepositoryInViewModelDetector.ISSUE,
            ContextInViewModelDetector.ISSUE,
            MutableLiveDataExposureDetector.ISSUE,
            RememberStateInComposableDetector.ISSUE,
            UiClassNamingDetector.ISSUE
        )

    override val api: Int = com.android.tools.lint.detector.api.CURRENT_API
}