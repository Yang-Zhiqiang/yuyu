package yuyu.common.workflowcore.api.exception;

/**
 * ワークフローの共通の例外クラス
 */
public class WorkflowRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public WorkflowRuntimeException(String message) {
        super(message);
    }
    public WorkflowRuntimeException(String message, Exception e) {
        super(message, e);
    }
    public WorkflowRuntimeException(Exception e) {
        super(e);
    }
}
