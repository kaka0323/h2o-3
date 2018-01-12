import ai.h2o.ci.BuildResult

def call() {
    return new PipelineUtils()
}

class PipelineUtils {

    public static final String REPO_URL = 'https://github.com/h2oai/h2o-3'

    private static final String PIPELINE_SCRIPTS_STASH_NAME = 'pipeline_scripts'

    private static final List<String> PIPELINE_ALWAYS_RECIPIENTS = ['michalr@h2o.ai']
    private static final List<String> PIPELINE_FAILURE_RECIPIENTS = ['michalk@h2o.ai'] + PIPELINE_ALWAYS_RECIPIENTS

    String stageNameToDirName(stageName) {
        if (stageName != null) {
            return stageName.toLowerCase().replace(' ', '-')
        }
        return null
    }

    void stashScripts(final context) {
        context.stash name: PIPELINE_SCRIPTS_STASH_NAME, includes: 'h2o-3/scripts/jenkins/groovy/*', allowEmpty: false
    }

    void unstashScripts(final context) {
        context.unstash name: PIPELINE_SCRIPTS_STASH_NAME
    }

    List<String> getRelevantPipelineRecipients(final BuildResult result) {
        if (result == BuildResult.SUCCESS) {
            return PIPELINE_ALWAYS_RECIPIENTS
        }
        return PIPELINE_FAILURE_RECIPIENTS
    }

}

return this