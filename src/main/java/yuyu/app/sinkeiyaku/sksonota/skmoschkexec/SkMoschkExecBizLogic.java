package yuyu.app.sinkeiyaku.sksonota.skmoschkexec;

import static yuyu.app.sinkeiyaku.sksonota.skmoschkexec.SkMoschkExecConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgRenkeiInfo;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMoschkExec;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 申込内容チェック実行 のビジネスロジックです。
 */
public class SkMoschkExecBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkMoschkExecUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private MosnaiCheckParam chkPrm;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private AS_Category category;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Inject
    private ObjStorageManager objStorageManager;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    void init() {
    }

    void clear() {
    }

    void pushKakunin() {
        BizPropertyInitializer.initialize(uiBean);

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);
        uiBean.setBzWorkflowInfo(bzWorkflowInfo);

        String mosNo = uiBean.getMosno();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setSyoriCTL(syoriCTL);

        C_SeirituKbn seirituKbn = syoriCTL.getSeiritukbn();

        if ((C_SeirituKbn.SEIRITU.eq(seirituKbn) || C_SeirituKbn.HUSEIRITU.eq(seirituKbn))) {
            throw new BizLogicException(MessageId.EBA0031, syoriCTL.getSeiritukbn().getContent());
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        if (mosKihon != null) {

            uiBean.setHhknnmkj(mosKihon.getHhknnmkj());

            C_UmuKbn mosNrkUmu = syoriCTL.getMosnrkumu();

            int kekkaKbn = getMsgAitemosno.exec(mosNrkUmu, mosKihon.getAitemosno());

            if (GetMsgAitemosno.KEKKAKBN_ARI == kekkaKbn) {
                String messageId = BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid());

                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, messageId, getMsgAitemosno.getS_gmmsg());
            }
        }

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
            getProcessSummary(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN,
                new C_Kouteikanristatus[] { C_Kouteikanristatus.SYORITYUU }, "", mosNo);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

        lockProcess(bzGetProcessSummaryOutBean.getKouteiKanriId(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        messageManager.addMessageId(MessageId.QHA0018);
    }

    @Transactional
    void pushKakutei() {

        continueLockProcess();

        String mosNo = uiBean.getMosno();
        String userId = baseUserInfo.getUserId();
        BizDate sysDate = BizDate.getSysDate();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        String oyaKouteiKanriId = uiBean.getBzWorkflowInfo().getOyaKouteiKanriId();

        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        if(syoriCTL == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(oyaKouteiKanriId);
        if (gyoumuKouteiInfo == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        chkPrm.setCategoryID(category.getCategoryId());
        chkPrm.setKinouID(kinou.getKinouId());
        chkPrm.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        chkPrm.setSysDate(sysDate);
        chkPrm.setKosID(userId);
        chkPrm.setKosTime(sysDateTimeMilli);
        chkPrm.setDataSyoriControl(syoriCTL);
        chkPrm.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        chkPrm.debug("<<<<申込内容チェック実行前>>>>");

        mosnaiCheck.exec(chkPrm);

        sinkeiyakuDomManager.update(syoriCTL);
        bizDomManager.update(gyoumuKouteiInfo);
        HT_MosnoKanri mosnoKanri = chkPrm.getMosnoKanri();
        if (mosnoKanri != null) {
            sinkeiyakuDomManager.update(mosnoKanri);
        }

        if (chkPrm.getListSkDenpyoData().size() > 0) {
            sinkeiyakuDomManager.insert(chkPrm.getListSkDenpyoData());
        }

        List<String> hubiMsgList = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo);
        uiBean.setHubimsgData(hubiMsgList.toArray(new String[0]));
        skHubiMsgRenkeiInfo.setMosno(mosNo);
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiMsgList);

        uiBean.setUniqueId(objStorageManager.save(skHubiMsgRenkeiInfo));

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        SkProcessForwardMoschkExec skProcessForwardMoschkExec = SWAKInjector.getInstance(SkProcessForwardMoschkExec.class);

        String kouteiLockKey = getKouteiLockKey();

        skProcessForwardInBean.setMosNo(mosNo);
        skProcessForwardInBean.setTskNm(TASKNM_SKMOSCHKEXEC);
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("");
        skProcessForwardInBean.setMostenkenkekkaKbn(C_SyorikekkaKbn.BLNK);
        skProcessForwardInBean.setMostenkentnsketsyaCd("");
        skProcessForwardInBean.setKnksateikekkaKbn(C_SyorikekkaKbn.BLNK);
        skProcessForwardInBean.setKnktnsketsyaCd("");
        skProcessForwardInBean.setImusateikekkaKbn(C_SyorikekkaKbn.BLNK);
        skProcessForwardInBean.setImutnsketsyaCd("");
        skProcessForwardInBean.setHubihassintnsKbn(C_HubihassintnsKbn.BLNK);
        skProcessForwardInBean.setHnkninputTorikesiyhKbn(C_YouhiKbn.HUYOU);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.YOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCTL, kouteiLockKey, null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, uiBean.getSkIdounaiyouBeforeBean());
        if (result) {
            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {
                for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {
                    errorMessageCollector.addMessage(errorMsg);
                }

                errorMessageCollector.throwBizLogicException();
            }
        }

        unlockProcess();

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);

        StringBuffer kekkaGmnMsg = new StringBuffer();

        kekkaGmnMsg.append(MessageUtil.getMessage(MessageId.IAC0009));

        List<String> kekkaGmnMsgList = chkPrm.getListKekkaGmnMsg();

        for(String msg : kekkaGmnMsgList) {

            kekkaGmnMsg.append(KAIGYOU).append(msg);
        }
        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), kekkaGmnMsg.toString());
    }

    void pushModoru() {
        unlockProcess();
    }

    void pushToziru() {
        unlockProcess();
    }

    void onClickFunctionName() {
        unlockProcess();
    }

    void appExceptionTerminate() {
        unlockProcess();
    }

    private void lockProcess(String pKouteiKanriId, String pJimuTetuzukiCd) {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(pKouteiKanriId, pJimuTetuzukiCd);
    }

    private void continueLockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();
    }

    private void unlockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.unlockProcess();
    }

    private String getKouteiLockKey() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();
        return kouteiLockKey;
    }

    private BzGetProcessSummaryOutBean getProcessSummary(String pJimuTetuzukiCd,
        C_Kouteikanristatus[] pKouteikanriStatuss,
        String pKouteiKanriId,
        String pMosNo) {

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(pKouteikanriStatuss);
        bzGetProcessSummaryInBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessSummaryInBean.setMosNo(pMosNo);

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0);

        return bzGetProcessSummaryOutBean;
    }
}