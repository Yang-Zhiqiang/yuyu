package yuyu.common.biz.prereport;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.workflow.workflowutility.GetTorikomiSyoruiMstBySyoruiCdResultBean;
import yuyu.common.workflow.workflowutility.PutExpectedArrivalNoticeResultBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;

import com.google.common.base.Strings;

/**
 * 到着予定登録処理クラスです。
 */
public class SyoruiToutyakuYoteiTouroku {

    public static void execSyoruiToutyakuYoteiTouroku(String pSyoruiCd, String pKouteiKnrId, String pQrCode) {
        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = null;
        if (!Strings.isNullOrEmpty(C_SyoruiCdKbn.getContentByValue(pSyoruiCd))) {
            BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
            torikomiSyoruiHukaInfo =  bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.valueOf(pSyoruiCd));
        }

        if (Strings.isNullOrEmpty(pKouteiKnrId) || Strings.isNullOrEmpty(pQrCode) || torikomiSyoruiHukaInfo == null || C_YouhiKbn.HUYOU.equals(torikomiSyoruiHukaInfo.getTtykknryouhi())) {
            return;
        }

        GetTorikomiSyoruiMstBySyoruiCdResultBean torikomiSyoruiBean = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(pSyoruiCd);

        if (!WorkFlowResultConstants.RESULT_OK.equals(torikomiSyoruiBean.getSyorikekkaStatus()) ||
                torikomiSyoruiBean.getTorikomiSyoruiBeanList() == null ||
                torikomiSyoruiBean.getTorikomiSyoruiBeanList().size() <= 0) {
            throw new BizAppException(MessageId.EBF0011);
        }

        PutExpectedArrivalNoticeResultBean result = WorkFlowUtility.putExpectedArrivalNotice(
                pKouteiKnrId,
                pQrCode,
                pSyoruiCd,
                torikomiSyoruiBean.getTorikomiSyoruiBeanList().get(0).getFlowid(),
                torikomiSyoruiHukaInfo.getSubSystemId());

        if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
            throw new BizAppException(MessageId.EBF0011);
        }
    }
}