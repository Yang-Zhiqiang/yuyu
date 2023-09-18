package yuyu.common.workflowcore.iwfcommon;

import jp.co.slcs.swak.core.util.ExceptionUtil;
import yuyu.infrext.RayDB2Util;

public class RayCheckExceptionImpl extends CheckExceptionImpl{

    @Override
    public boolean isExceptionShouldThrow(Exception e){
        return RayDB2Util.isDeadRockException(e) ||
            ExceptionUtil.contains(e, javax.validation.ConstraintViolationException.class);
    }
}