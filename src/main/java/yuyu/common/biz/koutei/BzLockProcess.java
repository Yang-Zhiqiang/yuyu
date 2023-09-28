package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessOutBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 工程 業務共通工程ロック開始
 */
public class BzLockProcess {

    @Inject
    private GetSyoriKokouteiInfo getSyoriKokouteiInfo;

    @Inject
    private BzUnlockProcess bzUnlockProcess;

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    public BzLockProcess() {
        super();
    }

    public BzLockProcessOutBean exec(String pKouteiKanriId, String pJimuTetuzukiCd) {

        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        LockProcessInBean lockProcessInBean = null;
        LockProcessOutBean lockProcessOutBean = null;
        String kekkaStatus = "";
        String syousaiMsgCd = "";

        String kouteiLockKey = uniqueKeyGenerator.generateUniqueKey();

        lockProcessInBean = new LockProcessInBean();

        lockProcessInBean.setGyoumukey(pKouteiKanriId);
        lockProcessInBean.setFlowid(pJimuTetuzukiCd);
        lockProcessInBean.setLockkey(kouteiLockKey);

        lockProcessOutBean = iwfKouteiClient.execLockProcess(lockProcessInBean);

        kekkaStatus = lockProcessOutBean.getKekkastatus();
        syousaiMsgCd = lockProcessOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus) ||
            IwfMessageCd.IWF2093.toString().equals(syousaiMsgCd)) {

            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey(kouteiLockKey);

        }
        else if (IwfMessageCd.IWF2091.toString().equals(syousaiMsgCd) ||
            IwfMessageCd.IWF2092.toString().equals(syousaiMsgCd)) {

            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
            bzLockProcessOutBean.setKouteiLockKey("");

            return bzLockProcessOutBean;
        }
        else {
            throw new BizAppException(
                MessageId.EBS0007, "業務共通工程ロック開始", "工程ロック開始", syousaiMsgCd);
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
                lockProcessInBean = new LockProcessInBean();

                lockProcessInBean.setGyoumukey(getSyoriKokouteiInfoOutBean.getSyoriKokouteikanriId());
                lockProcessInBean.setFlowid(getSyoriKokouteiInfoOutBean.getSyoriKokouteiJimutetuzukiCd());
                lockProcessInBean.setLockkey(kouteiLockKey);

                lockProcessOutBean = iwfKouteiClient.execLockProcess(lockProcessInBean);

                kekkaStatus = lockProcessOutBean.getKekkastatus();
                syousaiMsgCd = lockProcessOutBean.getSyousaimsgcd();

                if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus) ||
                    IwfMessageCd.IWF2093.toString().equals(syousaiMsgCd)) {
                }
                else if (IwfMessageCd.IWF2091.toString().equals(syousaiMsgCd) ||
                    IwfMessageCd.IWF2092.toString().equals(syousaiMsgCd)) {

                    bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, kouteiLockKey);

                    bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_CHILD);
                    bzLockProcessOutBean.setKouteiLockKey("");

                    break;
                }
                else {
                    throw new BizAppException(
                        MessageId.EBS0007, "業務共通工程ロック開始", "工程ロック開始", syousaiMsgCd);
                }
            }
        }

        return bzLockProcessOutBean;
    }

    public BzLockProcessOutBean exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey) {

        BzLockProcessOutBean bzLockProcessOutBean = new BzLockProcessOutBean();

        LockProcessInBean lockProcessInBean = null;
        LockProcessOutBean lockProcessOutBean = null;
        String kekkaStatus = "";
        String syousaiMsgCd = "";

        String kouteiLockKey = pKouteiLockKey;

        lockProcessInBean = new LockProcessInBean();

        lockProcessInBean.setGyoumukey(pKouteiKanriId);
        lockProcessInBean.setFlowid(pJimuTetuzukiCd);
        lockProcessInBean.setLockkey(kouteiLockKey);

        lockProcessOutBean = iwfKouteiClient.execLockProcess(lockProcessInBean);

        kekkaStatus = lockProcessOutBean.getKekkastatus();
        syousaiMsgCd = lockProcessOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus) ||
            IwfMessageCd.IWF2093.toString().equals(syousaiMsgCd)) {

            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.SUCCESS);
            bzLockProcessOutBean.setKouteiLockKey(kouteiLockKey);

        }
        else if (IwfMessageCd.IWF2091.toString().equals(syousaiMsgCd) ||
            IwfMessageCd.IWF2092.toString().equals(syousaiMsgCd)) {

            bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_SELF);
            bzLockProcessOutBean.setKouteiLockKey("");

            return bzLockProcessOutBean;
        }
        else {
            throw new BizAppException(
                MessageId.EBS0007, "業務共通工程ロック開始", "工程ロック開始", syousaiMsgCd);
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
                lockProcessInBean = new LockProcessInBean();

                lockProcessInBean.setGyoumukey(getSyoriKokouteiInfoOutBean.getSyoriKokouteikanriId());
                lockProcessInBean.setFlowid(getSyoriKokouteiInfoOutBean.getSyoriKokouteiJimutetuzukiCd());
                lockProcessInBean.setLockkey(kouteiLockKey);

                lockProcessOutBean = iwfKouteiClient.execLockProcess(lockProcessInBean);

                kekkaStatus = lockProcessOutBean.getKekkastatus();
                syousaiMsgCd = lockProcessOutBean.getSyousaimsgcd();

                if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus) ||
                    IwfMessageCd.IWF2093.toString().equals(syousaiMsgCd)) {
                }
                else if (IwfMessageCd.IWF2091.toString().equals(syousaiMsgCd) ||
                    IwfMessageCd.IWF2092.toString().equals(syousaiMsgCd)) {

                    bzUnlockProcess.exec(pKouteiKanriId, pJimuTetuzukiCd, kouteiLockKey);

                    bzLockProcessOutBean.setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn.FAILURE_CHILD);
                    bzLockProcessOutBean.setKouteiLockKey("");

                    break;
                }
                else {
                    throw new BizAppException(
                        MessageId.EBS0007, "業務共通工程ロック開始", "工程ロック開始", syousaiMsgCd);
                }
            }
        }

        return bzLockProcessOutBean;
    }

}
