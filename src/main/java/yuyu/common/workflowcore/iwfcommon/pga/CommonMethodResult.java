package yuyu.common.workflowcore.iwfcommon.pga;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.def.classification.C_ResultCdKbn;

public class CommonMethodResult implements ICommonMethodResult{

    private C_ResultCdKbn   oResultCd;
    private IwfMessageCd oMessageCd;

    public CommonMethodResult(C_ResultCdKbn oResultCd, IwfMessageCd oMessageCd) {
        this.oResultCd = oResultCd;
        this.oMessageCd = oMessageCd;
    }
    @Override
    public C_ResultCdKbn getResultCd(){
        return oResultCd;

    }
    @Override
    public IwfMessageCd getIwfMessageCd() {
        return oMessageCd;
    }

}
