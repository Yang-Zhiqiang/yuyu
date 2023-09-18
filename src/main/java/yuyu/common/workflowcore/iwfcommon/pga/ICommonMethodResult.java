package yuyu.common.workflowcore.iwfcommon.pga;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.def.classification.C_ResultCdKbn;

public interface ICommonMethodResult {

    C_ResultCdKbn getResultCd();

    IwfMessageCd getIwfMessageCd();

}
