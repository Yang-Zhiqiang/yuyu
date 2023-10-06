package yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninkekka;

import static yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninkekka.GenSkKeiyakuKakuninKekkaConstants.*;
import static yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninkekka.SkKeiyakuKakuninKekkaConstants.*;

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
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKeiyakuKakuninKekka;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HandketsijiKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_KykkakkekKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

import com.google.common.collect.Lists;

/**
 * 契約確認結果入力 のビジネスロジックです。
 */
public class SkKeiyakuKakuninKekkaBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkKeiyakuKakuninKekkaUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private BzGetProcessSummaryInBean bzGetProcessSummaryInBean;

    @Inject
    private CheckKinouModeKengen checkKinouModeKengen;

    @Inject
    private BzTaskStart bzTaskStart;

    @Inject
    private SetSyoruiInfoItiran setSyoruiInfoItiran;

    @Inject
    private ObjStorageManager objStorageManager;

    @Inject
    private SkProcessForwardKeiyakuKakuninKekka skProcessForwardKeiyakuKakuninKekka;

    @Inject
    private BizDomManager bizDomManager;

    void init() {
    }

    @Transactional
    void iwfOpenBL() {

        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        String kouteiKanriId = uiBean.getBzWorkflowInfo().getKouteiKanriId();
        String jimuTetuzukiCd = uiBean.getBzWorkflowInfo().getJimuTetuzukiCd();

        bzGetProcessSummaryInBean.setKouteiKanriId(kouteiKanriId);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(jimuTetuzukiCd);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        String mosNo = bzGetProcessSummaryOutBeanLst.get(0).getMosNo();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        checkTSyoriCTL(mosNo, syoriCTL);
        if (syoriCTL.getKykKaks().size() == 0) {
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }

        if (syoriCTL.getMosKihon() == null) {
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }

        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosNo);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanMosnoLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBeanMosnoLst.get(0).getKouteiKanriId());

        bzCommonLockProcess.lockProcess(
            uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        C_TskStartKekkaKbn tskStartKekkaKbn =
            bzTaskStart.exec(kouteiKanriId,
                jimuTetuzukiCd,
                uiBean.getBzWorkflowInfo().getTaskId(),
                bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);

        uiBean.setSyoriCTL(syoriCTL);

        setHanbaiMsg(syoriCTL);

        Integer maxNo = sinkeiyakuDomManager.getKykKakMaxRennoByMosno(mosNo);

        uiBean.setMosno(mosNo);
        uiBean.setRenno(maxNo);

        uiBean.setHhknnmkj(syoriCTL.getMosKihon().getHhknnmkj());
        uiBean.setKykkakkaisyacd(YuyuSinkeiyakuConfig.getInstance().getKykKakKaisyaCd());

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        uiBean.setSkIdounaiyouBeforeBean(skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL));
    }

    void clear() {

    }

    @Transactional
    void pushTourokuBL() {
        BizPropertyInitializer.initialize(uiBean);

        String mosNo = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        checkTSyoriCTL(mosNo, syoriCTL);

        if (syoriCTL.getKykKaks().size() == 0) {
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }

        checkTKykKakunin(mosNo);

        if (syoriCTL.getMosKihon() == null) {
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosNo);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId());

        bzCommonLockProcess.lockProcess(
            bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosNo);

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList.size() > 0) {
            uiBean.getBzWorkflowInfo().setKouteiKanriId(bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId());
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(bzGetProcessSummaryOutBeanList.get(0).getJimuTetuzukiCd());
            uiBean.getBzWorkflowInfo().setTaskId(bzGetProcessSummaryOutBeanList.get(0).getNowNodoId());

            if (ISkCommonKoumoku.NODEID_KYKKAKUNINKEKKA.equals(bzGetProcessSummaryOutBeanList.get(0).getNowNodoId())) {
                C_TskStartKekkaKbn tskStartKekkaKbn =
                    bzTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                        uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                        uiBean.getBzWorkflowInfo().getTaskId(),
                        bzCommonLockProcess.getKouteiLockKey());

                if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
                    throw new BizLogicException(MessageId.EBA0111);
                }
                else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
                    throw new BizLogicException(MessageId.EBA0112);
                }
            }
        }
        else {
            uiBean.getBzWorkflowInfo().setKouteiKanriId(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN);
            uiBean.getBzWorkflowInfo().setTaskId(ISkCommonKoumoku.NODEID_KYKKAKUNINKEKKA);
        }

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);

        uiBean.setSyoriCTL(syoriCTL);

        setHanbaiMsg(syoriCTL);

        uiBean.setHhknnmkj(syoriCTL.getMosKihon().getHhknnmkj());

        uiBean.setKykkakkaisyacd(YuyuSinkeiyakuConfig.getInstance().getKykKakKaisyaCd());

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        uiBean.setSkIdounaiyouBeforeBean(skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL));
    }

    void pushKakuNinBL() {

        String mosno = uiBean.getMosno();
        Integer renno = uiBean.getRenno();
        C_KykkakkekKbn kykkakkekKbn = uiBean.getKykkakkekkbn();
        BizDate kykkakkanymd = uiBean.getKykkakkanymd();
        String kykkakkaisyacd = uiBean.getKykkakkaisyacd();
        String kykkaktantcd = uiBean.getKykkaktantcd();
        BizDate sysDate = BizDate.getSysDate();

        BizDate kykKakIraiYMD = getKykKakIraiYMD(mosno, renno);

        if (BizDateUtil.compareYmd(kykkakkanymd, kykKakIraiYMD) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EHA0070);
        }

        if (BizDateUtil.compareYmd(kykkakkanymd, sysDate) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EHA0070);
        }

        if (C_KykkakkekKbn.KAK_TYUUSI.eq(kykkakkekKbn)) {
            if (!BizUtil.isBlank(kykkakkaisyacd)) {
                errorMessageCollector.addMessage(MessageId.EBC0007,
                    MessageUtil.getMessage(DDID_NYUURYOKUINFO_KYKKAKKAISYACD.getErrorResourceKey()));
            }

            if (!BizUtil.isBlank(kykkaktantcd)) {
                errorMessageCollector.addMessage(MessageId.EBC0007,
                    MessageUtil.getMessage(DDID_NYUURYOKUINFO_KYKKAKTANTCD.getErrorResourceKey()));
            }

            if (errorMessageCollector.exists()) {
                throw new BizLogicException(errorMessageCollector);
            }
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);

        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1,
            MessageId.QAC0008,
            MessageUtil.getMessage(MessageId.QAC0008));
    }

    String pushModoruBtnByInputcontentsBL() {
        String forwardName = "";

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            forwardName = FORWARDNAME_INIT;
        }
        else {
            forwardName = FORWARDNAME_BACKTOWORKLIST;
        }

        return forwardName;
    }

    void pushModoruBtnByConfirmBL() {

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        addConversationMessage();
    }

    @Transactional
    void pushKakuTeiBL() {
        String mosNo    = uiBean.getMosno();
        String userID   = baseUserInfo.getUserId();
        BizDate sysDate = BizDate.getSysDate();
        String kostime  = BizDate.getSysDateTimeMilli();

        HT_SyoriCTL syoriCTL = null;
        HT_MosKihon mosKihon = null;
        HT_KykKak kykKak     = null;

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);


        syoriCTL = uiBean.getSyoriCTL();

        if (syoriCTL != null) {

            syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KAKUNIN_SUMI);

            if (uiBean.getKykkakkekkbn().eq(C_KykkakkekKbn.HOUKOKUJIKOU_ARI)) {
                syoriCTL.setKetteikbn(C_KetteiKbn.NONE);

                if (C_KnkysateijyouKbn.NONE.eq(syoriCTL.getKnkysateijyoukbn())
                    || C_KnkysateijyouKbn.SATEIZUMI.eq(syoriCTL.getKnkysateijyoukbn())){

                    syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_2A);
                }

                syoriCTL.setKnkysateirrkumu(C_UmuKbn.ARI);

                HT_KnksateiRireki knksateiRireki = sinkeiyakuDomManager.getKnksateiRirekiByMosnoMaxRenno(mosNo);
                Integer knksateiRrkRenno = 0;

                if (knksateiRireki != null) {
                    knksateiRrkRenno = knksateiRireki.getRenno();
                }

                knksateiRireki = syoriCTL.createKnksateiRireki();

                knksateiRireki.setRenno(knksateiRrkRenno + 1);
                knksateiRireki.setSyoriYmd(sysDate);
                knksateiRireki.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.KYKKAKKEKKA);
                knksateiRireki.setKnksateikekkakbn(C_SyorikekkaKbn.TENSOU_KANKYOU_2A);
                knksateiRireki.setKnksateicomment(
                    EditSecurityKm.getEncodeData(mosNo, MessageUtil.getMessage(MessageId.WHC0008)));
                knksateiRireki.setGyoumuKousinsyaId(userID);
                knksateiRireki.setGyoumuKousinTime(kostime);

                BizPropertyInitializer.initialize(knksateiRireki);
            }
        }
        else {
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }

        mosKihon = syoriCTL.getMosKihon();

        if (mosKihon == null) {
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }

        kykKak = syoriCTL.getKykKakByRenno(uiBean.getRenno());

        setKykKak(kykKak);

        kykKak.setGyoumuKousinsyaId(userID);
        kykKak.setGyoumuKousinTime(kostime);

        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);

        if (uiBean.getKykkakkekkbn().eq(C_KykkakkekKbn.HOUKOKUJIKOU_ARI)) {
            mosnaiCheckParam.setKetteiSijiKbn(C_HandketsijiKbn.KYKKAK_MONDAI_ARI);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());

        if (gyoumuKouteiInfo == null) {
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }

        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setSysDate(sysDate);
        mosnaiCheckParam.setKosID(userID);
        mosnaiCheckParam.setKosTime(kostime);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        mosnaiCheckParam.debug("<<<<申込内容チェック実行前>>>>");

        mosnaiCheck.exec(mosnaiCheckParam);

        if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
            sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
        }

        sinkeiyakuDomManager.update(syoriCTL);
        bizDomManager.update(gyoumuKouteiInfo);
        HT_MosnoKanri mosnoKanri = mosnaiCheckParam.getMosnoKanri();
        if (mosnoKanri != null) {
            sinkeiyakuDomManager.update(mosnoKanri);
        }

        ArrayList<String> hubiMsgList = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo);
        uiBean.setHubimsgData(hubiMsgList.toArray(new String[0]));
        skHubiMsgRenkeiInfo.setMosno(uiBean.getMosno());
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiMsgList);

        String uniqueId = objStorageManager.save(skHubiMsgRenkeiInfo);
        uiBean.setUniqueId(uniqueId);

        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        skProcessForwardInBean.setMosNo(mosNo);
        skProcessForwardInBean.setTskNm(KOUTEIRIREKI_KINOUMEI);
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("");

        skProcessForwardKeiyakuKakuninKekka.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCTL, kouteiLockKey, null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, uiBean.getSkIdounaiyouBeforeBean());

        if (hanteiKekka) {

            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

            if (!C_ErrorKbn.OK.eq(skIdounaiyouKekkaBean.getErrorKbn())) {

                for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {

                    errorMessageCollector.addMessage(errorMsg);
                }

                errorMessageCollector.throwBizLogicException();
            }
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        StringBuffer msgOut = new StringBuffer();

        msgOut.append(MessageUtil.getMessage(MessageId.IAC0009));

        List<String> msgList = mosnaiCheckParam.getListKekkaGmnMsg();
        if (msgList != null) {
            for (int i = 0; i < msgList.size(); i++) {
                msgOut.append(MessageUtil.getMessage(MessageId.IAW0006)).append(msgList.get(i));
            }
        }

        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), msgOut.toString());
    }

    String syokigamenhebtnbyOnClickBL() {
        String forwardName = "";

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            forwardName = FORWARDNAME_INIT;
        }
        else {
            forwardName = FORWARDNAME_BACKTOWORKLIST;
        }

        return forwardName;
    }

    String functionNameOnClickBL() {
        String forwardName = "";

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            forwardName = FORWARDNAME_INIT;
        }
        else {
            forwardName = FORWARDNAME_BACKTOWORKLIST;
        }

        return forwardName;
    }

    void doContinueLockProcess() {

        bzCommonLockProcess.continueLockProcess();
    }

    void doUnlockProcess() {

        bzCommonLockProcess.unlockProcess();
    }

    void printHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImageAll(uiBean.getImageids());
    }


    private void checkTSyoriCTL(String pMosno, HT_SyoriCTL pSyoriCtl) {

        C_SeirituKbn seirituKbn = pSyoriCtl.getSeiritukbn();
        if (C_SeirituKbn.SEIRITU.eq(seirituKbn) || C_SeirituKbn.HUSEIRITU.eq(seirituKbn)) {

            throw new BizLogicException(MessageId.EBA0031, seirituKbn.getContent());
        }

        if (!C_KykkakjkKbn.KETMAE_KAKUNIN.eq(pSyoriCtl.getKykkakjkkbn())
            && !C_KykkakjkKbn.KETHORYU_KAKUNIN.eq(pSyoriCtl.getKykkakjkkbn())) {

            throw new BizLogicException(MessageId.EHA0069);
        }
    }

    private void checkTKykKakunin(String pMosno) {

        Integer renMaxNo = sinkeiyakuDomManager.getKykKakMaxRennoByMosno(pMosno);

        if (renMaxNo.compareTo(uiBean.getRenno()) != 0) {

            throw new BizLogicException(MessageId.EBC0046, MessageUtil.getMessage(DDID_BASEINFO_RENNO
                .getErrorResourceKey()));
        }
    }

    private void setHanbaiMsg(HT_SyoriCTL pSyoriCTL) {

        String aiteMosno = pSyoriCTL.getMosKihon().getAitemosno();

        int kekkaKbn = getMsgAitemosno.exec(pSyoriCTL.getMosnrkumu(), aiteMosno);

        if (GetMsgAitemosno.KEKKAKBN_ARI == kekkaKbn) {
            String messageId = BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid());

            List<String> gmwarningIdLst = Lists.newArrayList();
            List<String> gmwarningLst = Lists.newArrayList();
            gmwarningIdLst.add(messageId);
            gmwarningLst.add(getMsgAitemosno.getS_gmmsg());

            uiBean.setGmwarningIdLst(gmwarningIdLst);
            uiBean.setGmwarningLst(gmwarningLst);

            addConversationMessage();
        }
    }

    private void addConversationMessage() {

        List<String> gmwarningIdLst = uiBean.getGmwarningIdLst();
        if (gmwarningIdLst != null && gmwarningIdLst.size() > 0) {
            List<String> gmwarningLst = uiBean.getGmwarningLst();
            int index = 0;
            for (String gmwarningId : gmwarningIdLst) {
                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, gmwarningId,
                    gmwarningLst.get(index));
                index++;
            }
        }
    }

    private BizDate getKykKakIraiYMD(String pMosno, Integer pRenNo) {

        HT_KykKak kykKak = uiBean.getSyoriCTL().getKykKakByRenno(pRenNo);

        if (kykKak == null) {
            throw new CommonBizAppException("申込番号 = " + pMosno);
        }

        return kykKak.getKykkakiraiymd();
    }

    private void setKykKak(HT_KykKak pKykKak) {

        pKykKak.setKykkaktantcd(uiBean.getKykkaktantcd());
        pKykKak.setKykkakkaisyacd(uiBean.getKykkakkaisyacd());
        pKykKak.setKykkakkekkbn(uiBean.getKykkakkekkbn());
        pKykKak.setKykkakkanymd(uiBean.getKykkakkanymd());
    }

}
