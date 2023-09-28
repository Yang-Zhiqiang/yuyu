package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.ContinueLockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ContinueLockProcessOutBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 工程 業務共通工程ロック継続
 */
public class BzContinueLockProcess {

    @Inject
    private GetSyoriKokouteiInfo getSyoriKokouteiInfo;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BzUnlockProcess bzUnlockProcess;

    public BzContinueLockProcess() {
        super();
    }

    public C_KouteiLockKekkaKbn exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey) {

        C_KouteiLockKekkaKbn kouteiLockKekkaKbn = null;

        ContinueLockProcessInBean continueLockProcessInBean = null;
        ContinueLockProcessOutBean continueLockProcessOutBean = null;
        String kekkaStatus = "";
        String syousaiMsgCd = "";

        if (BizUtil.isBlank(pKouteiLockKey)) {
            kouteiLockKekkaKbn = C_KouteiLockKekkaKbn.SUCCESS;
            return kouteiLockKekkaKbn;
        }

        continueLockProcessInBean = new ContinueLockProcessInBean();

        continueLockProcessInBean.setGyoumukey(pKouteiKanriId);
        continueLockProcessInBean.setFlowid(pJimuTetuzukiCd);
        continueLockProcessInBean.setLockkey(pKouteiLockKey);

        continueLockProcessOutBean = iwfKouteiClient.execContinueLockProcess(continueLockProcessInBean);

        kekkaStatus = continueLockProcessOutBean.getKekkastatus();
        syousaiMsgCd = continueLockProcessOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus) ||
            IwfMessageCd.IWF2093.toString().equals(syousaiMsgCd)) {
            kouteiLockKekkaKbn = C_KouteiLockKekkaKbn.SUCCESS;
        }
        else if (IwfMessageCd.IWF2092.toString().equals(syousaiMsgCd) ||
            IwfMessageCd.IWF4031.toString().equals(syousaiMsgCd)) {

            kouteiLockKekkaKbn = C_KouteiLockKekkaKbn.FAILURE_SELF;

            return kouteiLockKekkaKbn;
        }
        else {
            throw new BizAppException(
                MessageId.EBS0007, "業務共通工程ロック継続", "工程ロック継続", syousaiMsgCd);
        }

        List<GetSyoriKokouteiInfoOutBean> getSyoriKokouteiInfoOutBeanLst =
            getSyoriKokouteiInfo.exec(pKouteiKanriId, pJimuTetuzukiCd);

        if (getSyoriKokouteiInfoOutBeanLst.size() == 0) {
        }
        else {
            for (GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean : getSyoriKokouteiInfoOutBeanLst) {
                if (C_UmuKbn.ARI.eq(getSyoriKokouteiInfoOutBean.getDouJimutetuzukicdUmuKbn())) {
                    throw new BizAppException(MessageId.EBA0023, "同一事務手続内の処理中子工程件数");
                }
            }

            for (GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean : getSyoriKokouteiInfoOutBeanLst) {
                continueLockProcessInBean = new ContinueLockProcessInBean();

                continueLockProcessInBean.setGyoumukey(getSyoriKokouteiInfoOutBean.getSyoriKokouteikanriId());
                continueLockProcessInBean.setFlowid(getSyoriKokouteiInfoOutBean.getSyoriKokouteiJimutetuzukiCd());
                continueLockProcessInBean.setLockkey(pKouteiLockKey);

                continueLockProcessOutBean = iwfKouteiClient.execContinueLockProcess(continueLockProcessInBean);

                kekkaStatus = continueLockProcessOutBean.getKekkastatus();
                syousaiMsgCd = continueLockProcessOutBean.getSyousaimsgcd();

                if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus) ||
                    IwfMessageCd.IWF2093.toString().equals(syousaiMsgCd)) {
                }
                else if (IwfMessageCd.IWF2092.toString().equals(syousaiMsgCd)||
                    IwfMessageCd.IWF4031.toString().equals(syousaiMsgCd)) {
                    bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, pKouteiLockKey);

                    kouteiLockKekkaKbn = C_KouteiLockKekkaKbn.FAILURE_CHILD;

                    break;
                }
                else {
                    throw new BizAppException(
                        MessageId.EBS0007, "業務共通工程ロック継続", "工程ロック継続", syousaiMsgCd);
                }
            }
        }

        return kouteiLockKekkaKbn;
    }
}
