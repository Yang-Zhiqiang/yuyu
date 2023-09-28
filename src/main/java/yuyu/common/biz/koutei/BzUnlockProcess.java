package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.UnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.UnlockProcessOutBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.def.MessageId;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 工程 業務共通工程ロック解除
 */
public class BzUnlockProcess {

    @Inject
    private GetSyoriKokouteiInfo getSyoriKokouteiInfo;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    public BzUnlockProcess() {
        super();
    }

    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey) {

        UnlockProcessInBean unlockProcessInBean = null;
        UnlockProcessOutBean unlockProcessOutBean = null;
        String kekkaStatus = "";
        String syousaiMsgCd = "";

        if (BizUtil.isBlank(pKouteiLockKey)) {
            return;
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
                unlockProcessInBean = new UnlockProcessInBean();

                unlockProcessInBean.setGyoumukey(getSyoriKokouteiInfoOutBean.getSyoriKokouteikanriId());
                unlockProcessInBean.setFlowid(getSyoriKokouteiInfoOutBean.getSyoriKokouteiJimutetuzukiCd());
                unlockProcessInBean.setLockkey(pKouteiLockKey);

                unlockProcessOutBean = iwfKouteiClient.execUnlockProcess(unlockProcessInBean);

                kekkaStatus = unlockProcessOutBean.getKekkastatus();
                syousaiMsgCd = unlockProcessOutBean.getSyousaimsgcd();

                if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus) ||
                    IwfMessageCd.IWF2104.toString().equals(syousaiMsgCd) ||
                    IwfMessageCd.IWF2101.toString().equals(syousaiMsgCd) ||
                    IwfMessageCd.IWF2103.toString().equals(syousaiMsgCd) ||
                    IwfMessageCd.IWF2102.toString().equals(syousaiMsgCd)) {
                }
                else {
                    throw new BizAppException(
                        MessageId.EBS0007, "業務共通工程ロック解除", "工程ロック解除", syousaiMsgCd);
                }

            }
        }

        unlockProcessInBean = new UnlockProcessInBean();

        unlockProcessInBean.setGyoumukey(pKouteiKanriId);
        unlockProcessInBean.setFlowid(pJimuTetuzukiCd);
        unlockProcessInBean.setLockkey(pKouteiLockKey);

        unlockProcessOutBean = iwfKouteiClient.execUnlockProcess(unlockProcessInBean);

        kekkaStatus = unlockProcessOutBean.getKekkastatus();
        syousaiMsgCd = unlockProcessOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus) ||
            IwfMessageCd.IWF2104.toString().equals(syousaiMsgCd) ||
            IwfMessageCd.IWF2101.toString().equals(syousaiMsgCd) ||
            IwfMessageCd.IWF2103.toString().equals(syousaiMsgCd) ||
            IwfMessageCd.IWF2102.toString().equals(syousaiMsgCd)) {
        }
        else {
            throw new BizAppException(
                MessageId.EBS0007, "業務共通工程ロック解除", "工程ロック解除", syousaiMsgCd);
        }
    }
}
