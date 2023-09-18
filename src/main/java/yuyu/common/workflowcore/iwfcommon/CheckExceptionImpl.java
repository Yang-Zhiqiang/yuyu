package yuyu.common.workflowcore.iwfcommon;

public class CheckExceptionImpl implements CheckException{

    @Override
    public boolean isExceptionShouldThrow(Exception e){
        return false;
    }
}