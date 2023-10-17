package yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninirai;

import static yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninirai.SkKeiyakuKakuninIraiConstants.*;

import java.util.ArrayList;
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
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKeiyakuKakuninIrai;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.EditPdfKykKakuninIraisyo;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_KykkakkekKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 契約確認依頼入力 のビジネスロジックです。
 */
public class SkKeiyakuKakuninIraiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkKeiyakuKakuninIraiUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private EditPdfKykKakuninIraisyo editPdfKykKakuninIraisyo;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private ObjStorageManager objStorageManager;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    void init() {
    }

    void clear() {
    }

    void pushTourokuBL() {

        BizPropertyInitializer.initialize(uiBean);

        String mosNo = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = checkTSyoriCTL(mosNo);

        uiBean.setSyoriCTL(syoriCTL);

        String[] mosKihon = selHhknsyNmFromTMosKihon(mosNo);

        String hhknsyNm = mosKihon[0];

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosNo);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanLst.size() > 0) {
            uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(
                bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());

            bzCommonLockProcess.lockProcess(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
                ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        }

        GetMsgAitemosno getMsgAitemosno = SWAKInjector.getInstance(GetMsgAitemosno.class);

        int kekkakbn = getMsgAitemosno.exec(syoriCTL.getMosnrkumu(), mosKihon[1]);
        if (GetMsgAitemosno.KEKKAKBN_ARI == kekkakbn) {
            uiBean.setGmMsg(getMsgAitemosno.getS_gmmsg());
            uiBean.setGmMsgid(getMsgAitemosno.getS_gmmsgid());
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid()), getMsgAitemosno.getS_gmmsg());
        }

        Integer renNo = selRenNoFromTKykKakunin(mosNo);

        uiBean.setHhknnmkj(hhknsyNm);
        uiBean.setRenno(renNo);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        uiBean.setSkIdounaiyouBeforeBean(skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL));
    }

    void pushKakuninBL() {
        checkTSyoriCTL(uiBean.getMosno(), uiBean.getKykkaksyrui());

        checkKakKanYtYMD(uiBean.getKykkakkanytymd());

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);

        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1,
            MessageId.QAC0008,
            MessageUtil.getMessage(MessageId.QAC0008));
    }

    @Transactional
    void pushKakuteiBL() {

        String mosNo = uiBean.getMosno();
        C_Kykkaksyrui kykkakSyrui = uiBean.getKykkaksyrui();
        String userId = baseUserInfo.getUserId();
        BizDate sysDate = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        if (C_Kykkaksyrui.KETHORYU.eq(kykkakSyrui)) {
            syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETHORYU_KAKUNIN);
        }
        else if (C_Kykkaksyrui.SEIRITUGO.eq(kykkakSyrui)) {
            syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.SEIRITUGO_KAK_IRAISU);
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon == null) {
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }

        HT_KykKak kykKak = syoriCTL.createKykKak();
        kykKak.setRenno(uiBean.getRenno());
        kykKak.setKykkaksyrui(uiBean.getKykkaksyrui());
        kykKak.setKykkaktantcd("");
        kykKak.setKykkakkaisyacd("");
        kykKak.setKykkakiraiymd(sysDate);
        kykKak.setKykkakkanytymd(uiBean.getKykkakkanytymd());
        kykKak.setKykkakkekkbn(C_KykkakkekKbn.BLNK);
        kykKak.setKykkakkanymd(null);
        kykKak.setKykkakcomment(uiBean.getKykkakcomment());
        kykKak.setGyoumuKousinsyaId(userId);
        kykKak.setGyoumuKousinTime(sysDateTime);

        BizPropertyInitializer.initialize(kykKak);

        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setSysDate(sysDate);
        mosnaiCheckParam.setKosID(userId);
        mosnaiCheckParam.setKosTime(sysDateTime);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        if (C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {
            BT_GyoumuKouteiInfo gyoumuKouteiInfo = null;
            gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());

            if (gyoumuKouteiInfo == null) {
                throw new CommonBizAppException("申込番号 = " + mosNo);
            }

            mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

            mosnaiCheckParam.debug("<<<<申込内容チェック実行前>>>>");
            mosnaiCheck.exec(mosnaiCheckParam);
            bizDomManager.update(gyoumuKouteiInfo);

            if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
                sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
            }
        }
        else {
            syoriCTL.setGyoumuKousinsyaId(userId);
            syoriCTL.setGyoumuKousinTime(sysDateTime);
        }

        List<String> msgList = new ArrayList<>();
        if (C_Kykkaksyrui.KETHORYU.eq(kykkakSyrui)) {
            msgList.add(MessageUtil.getMessage(MessageId.WHC0011));
        }
        else if (C_Kykkaksyrui.SEIRITUGO.eq(kykkakSyrui)) {
            msgList.add(MessageUtil.getMessage(MessageId.WHC0012));
        }

        mosnaiCheckParam.setListKykKakuninMsg(msgList);

        editPdfKykKakuninIraisyo.exec(mosnaiCheckParam, kykKak);

        sinkeiyakuDomManager.update(syoriCTL);

        List<String> hubiMsgList = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo);
        skHubiMsgRenkeiInfo.setHubimsgData(hubiMsgList);
        skHubiMsgRenkeiInfo.setMosno(mosNo);
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());

        uiBean.setUniqueId(objStorageManager.save(skHubiMsgRenkeiInfo));

        uiBean.setHubimsgData(hubiMsgList.toArray(new String[0]));

        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        skProcessForwardInBean.setMosNo(mosNo);
        skProcessForwardInBean.setTskNm("契約確認依頼入力");
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("");

        SkProcessForwardKeiyakuKakuninIrai skProcessForwardKeiyakuKakuninIrai = SWAKInjector.getInstance(SkProcessForwardKeiyakuKakuninIrai.class);
        skProcessForwardKeiyakuKakuninIrai.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCTL, kouteiLockKey, null);

        StringBuffer msgOut = new StringBuffer();
        msgOut.append(MessageUtil.getMessage(MessageId.IAC0009));
        msgList = mosnaiCheckParam.getListKekkaGmnMsg();
        for (String msg : msgList) {
            msgOut.append(KAIGYOU).append(msg);
        }

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        Boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, uiBean.getSkIdounaiyouBeforeBean());

        if (result) {

            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

            if (!C_ErrorKbn.OK.eq(skIdounaiyouKekkaBean.getErrorKbn())) {

                for (String errorMsgId : skIdounaiyouKekkaBean.getErrorMsgLst()) {

                    errorMessageCollector.addMessage(errorMsgId);
                }

                errorMessageCollector.throwBizLogicException();
            }
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), msgOut.toString());
    }

    void setGmwarningId() {

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        if (!BizUtil.isBlank(uiBean.getGmMsgid())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                BizUtil.getGeneralMessageId(uiBean.getGmMsgid()), uiBean.getGmMsg());
        }
    }

    void doContinueLockProcess() {
        bzCommonLockProcess.continueLockProcess();
    }

    void doUnlockProcess() {
        bzCommonLockProcess.unlockProcess();
    }


    private HT_SyoriCTL checkTSyoriCTL(String pMosNo) {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosNo);

        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }


        if (C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu())) {
            throw new BizLogicException(MessageId.EHA0027);
        }

        C_KykkakjkKbn kykkakjKkbn = syoriCTL.getKykkakjkkbn();
        if (C_KykkakjkKbn.KETMAE_KAKUNIN.eq(kykkakjKkbn)) {
            throw new BizLogicException(MessageId.EBA0031, kykkakjKkbn.getContent());
        }

        else if (C_KykkakjkKbn.KETHORYU_KAKUNIN.eq(kykkakjKkbn)) {
            throw new BizLogicException(MessageId.EBA0031, kykkakjKkbn.getContent());
        }

        else if (C_KykkakjkKbn.SEIRITUGO_KAK_IRAISU.eq(kykkakjKkbn)) {
            throw new BizLogicException(MessageId.EBA0031, kykkakjKkbn.getContent());
        }
        return syoriCTL;
    }

    private String[] selHhknsyNmFromTMosKihon(String pMosNo) {

        HT_MosKihon mosKihon = uiBean.getSyoriCTL().getMosKihon();

        if (mosKihon != null) {

            return new String[] { mosKihon.getHhknnmkj(), mosKihon.getAitemosno() };
        }

        throw new CommonBizAppException("申込番号 = " + pMosNo);
    }

    private Integer selRenNoFromTKykKakunin(String pMosNo) {

        Integer maxRenno = sinkeiyakuDomManager.getKykKakMaxRennoByMosno(pMosNo);

        if (maxRenno != null) {
            return maxRenno + 1;
        }
        return 1;
    }

    private void checkTSyoriCTL(String pMosNo, C_Kykkaksyrui pKykkakSyrui) {

        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        if (C_Kykkaksyrui.KETHORYU.eq(pKykkakSyrui)) {

            if (!C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {
                throw new BizLogicException(MessageId.EBA0031, syoriCTL.getSeiritukbn().getContent());
            }
            if (C_KetteiKbn.KETTEI_SUMI.eq(syoriCTL.getKetteikbn())) {
                throw new BizLogicException(MessageId.EBA0031, syoriCTL.getKetteikbn().getContent());
            }
            else if (C_KetteiKbn.TKJYSYDK_MATI.eq(syoriCTL.getKetteikbn())) {
                throw new BizLogicException(MessageId.EBA0031, syoriCTL.getKetteikbn().getContent());
            }
        }
        else if (C_Kykkaksyrui.SEIRITUGO.eq(pKykkakSyrui)) {
            if (!C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {
                throw new BizLogicException(MessageId.EBA0031, syoriCTL.getSeiritukbn().getContent());
            }
        }
    }

    private void checkKakKanYtYMD(BizDate pKykkakKanYtYMD) {
        if (BizDateUtil.compareYmd(pKykkakKanYtYMD,BizDate.getSysDate()) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EBC0046, DISP_KYKKAKKANYTYMD);
        }
    }
}
