package yuyu.common.workflowcore.iwfcommon;

public interface CheckException {

    abstract boolean isExceptionShouldThrow(Exception e);
}