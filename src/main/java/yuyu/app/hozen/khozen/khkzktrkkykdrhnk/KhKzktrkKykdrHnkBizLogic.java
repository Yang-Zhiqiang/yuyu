package yuyu.app.hozen.khozen.khkzktrkkykdrhnk;

import static yuyu.app.hozen.khozen.khkzktrkkykdrhnk.GenKhKzktrkKykdrHnkConstants.*;
import static yuyu.app.hozen.khozen.khkzktrkkykdrhnk.KhKzktrkKykdrHnkConstants.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.CTIParamBean;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceTaskStart;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.CheckHansyaSentakuInfo;
import yuyu.common.hozen.khcommon.CheckKhMeigiAddr;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.DouhuuTaisyouBean;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.EditSouhuannaiParam;
import yuyu.common.hozen.khcommon.EditTtdkKanryouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.GetKhKykdrInfo;
import yuyu.common.hozen.khcommon.GetKhKykdrInfoBean;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhTyokusouHantei;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.MeigiAddrBean;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.khcommon.TrkkzkTyokusouhtBean;
import yuyu.common.hozen.khcommon.TyokusouTaisyouBean;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetHituyouSyorui;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtil;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetSiteiseikyuu;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HnsychkTaisyousyaKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_KykdrtkykttdkKbn;
import yuyu.def.classification.C_KzkTrkServicettdkKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TeiseiKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TrkKzkHnkKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TrkkzkttdkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;
import yuyu.def.classification.C_TyhysakuseiyhKbn;
import yuyu.def.classification.C_TyokusouhtkekKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IW_KhKzktrkKykDrHnkWk;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.DBAOutputReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.PdfBuilder;

import com.google.common.collect.Lists;
import com.lowagie.text.pdf.PdfReader;

/**
 * 家族登録／契約者代理特約変更 のビジネスロジックです。
 */
public class KhKzktrkKykdrHnkBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKzktrkKykdrHnkUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private CommonDispImage commonDispImage;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private OutputReport outputReport;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private HozenPreReportRenkeiBean hozenPreReportRenkeiBean;

    @Inject
    private CTIParamBean ctiParamBean;

    void init() {
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        uiBean.setKouteiLockKey(bzCommonLockProcess.getKouteiLockKey());

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(), uiBean.getBzWorkflowInfo().getTaskId(),
            bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(
            uiBean.getBzWorkflowInfo().getKouteiKanriId());

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkKykSonzai();

        checkYuukouJyoutai(khozenCommonParam);

        checkTetudukiTyuui(khozenCommonParam);

        checkKykymdIdou(khozenCommonParam);

        IW_KhKzktrkKykDrHnkWk khKzktrkKykDrHnkWk = hozenDomManager.getKhKzktrkKykDrHnkWk(
            uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if (khKzktrkKykDrHnkWk == null) {
            throw new CommonBizAppException(IW_KhKzktrkKykDrHnkWk.TABLE_NAME + " 取得エラー");
        }

        if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) &&
            !C_SyorikekkaKbn.TORIKESI.eq(khKzktrkKykDrHnkWk.getZenkaisyorikekkakbn())) {
            uiBean.setTrkkzkttdkkbn1(khKzktrkKykDrHnkWk.getTrkkzkttdkkbn1());
            uiBean.setNewtrkkzknmkn1(khKzktrkKykDrHnkWk.getTrkkzknmkn1());
            uiBean.setNewtrkkzknmkj1(khKzktrkKykDrHnkWk.getTrkkzknmkj1());
            uiBean.setNewtrkkzknmkjkhukakbn1(khKzktrkKykDrHnkWk.getTrkkzknmkjkhukakbn1());
            uiBean.setNewtrkkzkseiymd1(khKzktrkKykDrHnkWk.getTrkkzkseiymd1());
            uiBean.setNewtrkkzksei1(khKzktrkKykDrHnkWk.getTrkkzksei1());
            uiBean.setNewtrkkzkyno1(khKzktrkKykDrHnkWk.getTrkkzkyno1());
            uiBean.setNewtrkkzkadr1kj1(khKzktrkKykDrHnkWk.getTrkkzkadr1kj1());
            uiBean.setNewtrkkzkadr2kj1(khKzktrkKykDrHnkWk.getTrkkzkadr2kj1());
            uiBean.setNewtrkkzkadr3kj1(khKzktrkKykDrHnkWk.getTrkkzkadr3kj1());
            uiBean.setNewtrkkzktelno1(khKzktrkKykDrHnkWk.getTrkkzktelno1());
            uiBean.setNewtrkkzktdk1(khKzktrkKykDrHnkWk.getTrkkzktdk1());

            uiBean.setTrkkzkttdkkbn2(khKzktrkKykDrHnkWk.getTrkkzkttdkkbn2());
            uiBean.setNewtrkkzknmkn2(khKzktrkKykDrHnkWk.getTrkkzknmkn2());
            uiBean.setNewtrkkzknmkj2(khKzktrkKykDrHnkWk.getTrkkzknmkj2());
            uiBean.setNewtrkkzknmkjkhukakbn2(khKzktrkKykDrHnkWk.getTrkkzknmkjkhukakbn2());
            uiBean.setNewtrkkzkseiymd2(khKzktrkKykDrHnkWk.getTrkkzkseiymd2());
            uiBean.setNewtrkkzksei2(khKzktrkKykDrHnkWk.getTrkkzksei2());
            uiBean.setNewtrkkzktdk2(khKzktrkKykDrHnkWk.getTrkkzktdk2());
            uiBean.setNewtrkkzkyno2(khKzktrkKykDrHnkWk.getTrkkzkyno2());
            uiBean.setNewtrkkzkadr1kj2(khKzktrkKykDrHnkWk.getTrkkzkadr1kj2());
            uiBean.setNewtrkkzkadr2kj2(khKzktrkKykDrHnkWk.getTrkkzkadr2kj2());
            uiBean.setNewtrkkzkadr3kj2(khKzktrkKykDrHnkWk.getTrkkzkadr3kj2());
            uiBean.setNewtrkkzktelno2(khKzktrkKykDrHnkWk.getTrkkzktelno2());

            uiBean.setKykdrtkykttdkkbn(khKzktrkKykDrHnkWk.getKykdrtkykttdkkbn());
            uiBean.setNewkykdrkbn(khKzktrkKykDrHnkWk.getKykdrkbn());
            uiBean.setNewkykdrnmkn(khKzktrkKykDrHnkWk.getKykdairinmkn());
            uiBean.setNewkykdrnmkj(khKzktrkKykDrHnkWk.getKykdairinmkj());
            uiBean.setNewkykdrnmkjkhukakbn(khKzktrkKykDrHnkWk.getKykdrnmkjkhukakbn());
            uiBean.setNewkykdrseiymd(khKzktrkKykDrHnkWk.getKykdrseiymd());
            uiBean.setNewkykdryno(khKzktrkKykDrHnkWk.getKykdryno());
            uiBean.setNewkykdradr1kj(khKzktrkKykDrHnkWk.getKykdradr1kj());
            uiBean.setNewkykdradr2kj(khKzktrkKykDrHnkWk.getKykdradr2kj());
            uiBean.setNewkykdradr3kj(khKzktrkKykDrHnkWk.getKykdradr3kj());

            uiBean.setShsnmkj(khKzktrkKykDrHnkWk.getShsnmkj());
            uiBean.setShskyno(khKzktrkKykDrHnkWk.getShskyno());
            uiBean.setShsadr1kj(khKzktrkKykDrHnkWk.getShsadr1kj());
            uiBean.setShsadr2kj(khKzktrkKykDrHnkWk.getShsadr2kj());
            uiBean.setShsadr3kj(khKzktrkKykDrHnkWk.getShsadr3kj());
            uiBean.setHonninkakninkekkakbn(khKzktrkKykDrHnkWk.getHonninkakninkekkakbn());
            uiBean.setTyhysakuseiyhkbn(khKzktrkKykDrHnkWk.getTyhysakuseiyhkbn());
            uiBean.setNewtrkkzktsindousiteikbn1(khKzktrkKykDrHnkWk.getTrkkzktsindousiteikbn1());
            uiBean.setNewtrkkzktsindousiteikbn2(khKzktrkKykDrHnkWk.getTrkkzktsindousiteikbn2());

            if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) &&
                C_TyhysakuseiyhKbn.BLNK.eq(khKzktrkKykDrHnkWk.getTyhysakuseiyhkbn()) &&
                C_HassouKbn.BLNK.eq(khKzktrkKykDrHnkWk.getHassoukbn())) {
                uiBean.setHassoukbn(C_HassouKbn.TYOKUSOU);
            }
            else {
                uiBean.setHassoukbn(khKzktrkKykDrHnkWk.getHassoukbn());
            }
        }

        uiBean.setMousideninkbn(khKzktrkKykDrHnkWk.getMousideninkbn());
        uiBean.setTeiseikbn(C_TeiseiKbn.BLNK);
        uiBean.setZenkaisyorikekkakbn(khKzktrkKykDrHnkWk.getZenkaisyorikekkakbn());
        checkYuuyokkngai();
        setUiBean(khozenCommonParam);
        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);
        setKhKbnPatternUtil.exec(uiBean);

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            messageManager.addConversationMessageId(GROUP_WORKLIST_MESSAGE, MessageId.WIC0001,
                uiBean.getZenkaisyorikekkakbn().getContent());
        }
    }

    void pushSyoukaibtnBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        checkKykSonzai();

        if (C_TeiseiKbn.TEISEI.eq(uiBean.getTeiseikbn())) {
            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

            C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(),
                IKhozenCommonConstants.JIMUTETUZUKICD_KHKZKTRKKYKDRHNK);

            if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();
                throw new BizLogicException(MessageId.EIA1002,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkYuukouJyoutai(khozenCommonParam);

        checkTetudukiTyuui(khozenCommonParam);

        checkKykymdIdou(khozenCommonParam);

        if (C_MousideninKbn.BLNK.eq(uiBean.getMousideninkbn()) && C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) {
            throw new BizLogicException(MessageId.EIF1133);
        }

        if (!C_MousideninKbn.BLNK.eq(uiBean.getMousideninkbn()) && C_TeiseiKbn.TEISEI.eq(uiBean.getTeiseikbn())) {
            throw new BizLogicException(MessageId.EIF1134);
        }

        checkYuuyokkngai();

        setUiBean(khozenCommonParam);

        hanteiSyoriKengen();

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())) {
            if (C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) {
                uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHKZKTRKKYKDRHNK);
            }
        }

        if (C_MousideninKbn.TRKKZK1.eq(uiBean.getMousideninkbn())) {
            uiBean.setShsnmkj(uiBean.getTrkkzknmkj1());
            uiBean.setShskyno(uiBean.getTrkkzkyno1());
            uiBean.setShsadr1kj(uiBean.getTrkkzkadr1kj1());
            uiBean.setShsadr2kj(uiBean.getTrkkzkadr2kj1());
            uiBean.setShsadr3kj(uiBean.getTrkkzkadr3kj1());
        }
        else if (C_MousideninKbn.TRKKZK2.eq(uiBean.getMousideninkbn())) {
            uiBean.setShsnmkj(uiBean.getTrkkzknmkj2());
            uiBean.setShskyno(uiBean.getTrkkzkyno2());
            uiBean.setShsadr1kj(uiBean.getTrkkzkadr1kj2());
            uiBean.setShsadr2kj(uiBean.getTrkkzkadr2kj2());
            uiBean.setShsadr3kj(uiBean.getTrkkzkadr3kj2());
        }
        else if (C_MousideninKbn.HHKNHONNIN.eq(uiBean.getMousideninkbn())) {
            uiBean.setShsnmkj(uiBean.getVhhkshhknnmkj());
        }

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));
        uiBean.setHassoukbn(C_HassouKbn.TYOKUSOU);

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        setKhKbnPatternUtil.exec(uiBean);
    }

    void pushSeikyusyoSakuseiBL() {

        checkProcessKaishiAndSeikyusyoSakusei();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        BM_SyouhnZokusei syouhnZokusei = khozenCommonParam.getKeiyakuSyouhin(
            uiBean.getSyono(), C_SyutkKbn.SYU).get(0).getSyouhnZokusei();

        if (C_UmuKbn.NONE.eq(syouhnZokusei.getKzktourokuserviceumu()) &&
            C_UmuKbn.NONE.eq(syouhnZokusei.getKykdrtkykumu())) {
            throw new BizLogicException(MessageId.EIF1158);
        }

        if (C_MousideninKbn.HHKNHONNIN.eq(uiBean.getMousideninkbn())) {
            if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo1umukbn()) &&
                C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo2umukbn())) {
                throw new BizLogicException(MessageId.EIF1158);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzkInfo1umukbn()) &&
                C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo2umukbn())) {
                if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn()) ||
                    C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn())) {
                    throw new BizLogicException(MessageId.EIF1158);
                }

                uiBean.setTrkkzk1Sakujyo(C_KahiKbn.KA);
            }

            if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo1umukbn()) &&
                C_UmuKbn.ARI.eq(uiBean.getTrkkzkInfo2umukbn())) {
                if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn()) ||
                    C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn())) {
                    throw new BizLogicException(MessageId.EIF1158);
                }

                uiBean.setTrkkzk2Sakujyo(C_KahiKbn.KA);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzkInfo1umukbn()) &&
                C_UmuKbn.ARI.eq(uiBean.getTrkkzkInfo2umukbn())) {
                uiBean.setTrkkzk1Sakujyo(C_KahiKbn.KA);
                uiBean.setTrkkzk2Sakujyo(C_KahiKbn.KA);

                if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn()) ||
                    C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn())) {
                    uiBean.setTrkkzk1Sakujyo(C_KahiKbn.HUKA);
                }

                if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn()) ||
                    C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn())) {
                    uiBean.setTrkkzk2Sakujyo(C_KahiKbn.HUKA);
                }

                if (C_KahiKbn.HUKA.eq(uiBean.getTrkkzk1Sakujyo()) &&
                    C_KahiKbn.HUKA.eq(uiBean.getTrkkzk2Sakujyo())) {
                    throw new BizLogicException(MessageId.EIF1158);
                }
            }
        }
        else if (C_MousideninKbn.TRKKZK1.eq(uiBean.getMousideninkbn())) {
            if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo1umukbn())) {
                throw new BizLogicException(MessageId.EIF1158);
            }

            if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn()) ||
                C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn())) {
                throw new BizLogicException(MessageId.EIF1158);
            }
        }
        else if (C_MousideninKbn.TRKKZK2.eq(uiBean.getMousideninkbn())) {
            if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo2umukbn())) {
                throw new BizLogicException(MessageId.EIF1158);
            }

            if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn()) ||
                C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn())) {
                throw new BizLogicException(MessageId.EIF1158);
            }
        }

        if (C_MousideninKbn.HHKNHONNIN.eq(uiBean.getMousideninkbn()) ||
            C_MousideninKbn.TRKKZK1.eq(uiBean.getMousideninkbn()) ||
            C_MousideninKbn.TRKKZK2.eq(uiBean.getMousideninkbn())) {
            if (BizUtil.isBlank(uiBean.getShsnmkj())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SHSNMINFO_SHSNMKJ.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getShskyno())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SHSKADRINFO_SHSKYNO.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getShsadr1kj())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SHSKADRINFO_SHSADR1KJ.getErrorResourceKey()));
            }

            BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);

            BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(uiBean.getShsadr1kj(),
                uiBean.getShsadr2kj(), uiBean.getShsadr3kj());

            if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {
                throw new BizLogicException(MessageId.EBA1003,
                    MessageUtil.getMessage(DDID_SHSKADRINFO_SHSADR1KJ.getErrorResourceKey()),
                    String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                    String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
            }
        }

        uiBean.setTrkkzkttdkkbn1(C_TrkkzkttdkKbn.BLNK);
        uiBean.setNewtrkkzknmkn1(BLANK);
        uiBean.setNewtrkkzknmkj1(BLANK);
        uiBean.setNewtrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setNewtrkkzkseiymd1(null);
        uiBean.setNewtrkkzksei1(C_Seibetu.BLNK);
        uiBean.setNewtrkkzkyno1(BLANK);
        uiBean.setNewtrkkzkadr1kj1(BLANK);
        uiBean.setNewtrkkzkadr2kj1(BLANK);
        uiBean.setNewtrkkzkadr3kj1(BLANK);
        uiBean.setNewtrkkzktelno1(BLANK);
        uiBean.setNewtrkkzktdk1(C_Tdk.BLNK);

        uiBean.setTrkkzkttdkkbn2(C_TrkkzkttdkKbn.BLNK);
        uiBean.setNewtrkkzknmkn2(BLANK);
        uiBean.setNewtrkkzknmkj2(BLANK);
        uiBean.setNewtrkkzknmkjkhukakbn2(C_KjkhukaKbn.BLNK);
        uiBean.setNewtrkkzkseiymd2(null);
        uiBean.setNewtrkkzksei2(C_Seibetu.BLNK);
        uiBean.setNewtrkkzkyno2(BLANK);
        uiBean.setNewtrkkzkadr1kj2(BLANK);
        uiBean.setNewtrkkzkadr2kj2(BLANK);
        uiBean.setNewtrkkzkadr3kj2(BLANK);
        uiBean.setNewtrkkzktelno2(BLANK);
        uiBean.setNewtrkkzktdk2(C_Tdk.BLNK);

        uiBean.setKykdrtkykttdkkbn(C_KykdrtkykttdkKbn.BLNK);
        uiBean.setNewkykdrkbn(C_UktKbn.BLNK);
        uiBean.setNewkykdrnmkn(BLANK);
        uiBean.setNewkykdrnmkj(BLANK);
        uiBean.setNewkykdrnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setNewkykdrseiymd(null);
        uiBean.setNewkykdryno(BLANK);
        uiBean.setNewkykdradr1kj(BLANK);
        uiBean.setNewkykdradr2kj(BLANK);
        uiBean.setNewkykdradr3kj(BLANK);

        uiBean.setNewtrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setNewtrkkzktsindousiteikbn2(C_TsindousiteiKbn.BLNK);


        messageManager.addMessageId(MessageId.QIA0004);
    }

    void pushKakuninBL() {

        continueLockProcessBL();

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) ||
            ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
                (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
                    C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn()))) &&
                    C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) ||
                    (C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode()) &&
                        C_TeiseiKbn.TEISEI.eq(uiBean.getTeiseikbn())) ||
                        (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
                            C_TeiseiKbn.TEISEI.eq(uiBean.getTeiseikbn()))) {
            checkInput();

            if (C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) {
                checkHonninkaknin();
            }

            checkHansyaSentakuInfo();

            checkDairinHenkouWarning();

            checkTakyk();

            checkDairinHenkouInfo();
        }

        if ((C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);
            checkProcessKekka.exec(uiBean.getSyorikekkakbn(), uiBean.getSyanaicommentkh(),
                uiBean.getSasimodosisakikbn());
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) {
            checkProcessKaishiAndKakutei();
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        continueLockProcessBL();

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            if (C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) {

                checkProcessKaishiAndKakutei();

                CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
                }

                BzProcessCreateInBean bzProcessCreateInBean = SWAKInjector.getInstance(BzProcessCreateInBean.class);
                BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);

                bzProcessCreateInBean.setSyoNo(uiBean.getSyono());
                bzProcessCreateInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

                BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

                if (C_KouteiSakuseiKekkaKbn.FAILURE.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0008));
                }

                uiBean.getBzWorkflowInfo().setKouteiKanriId(bzProcessCreateOutBean.getKouteiKanriId());

                bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

                BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
                bzForceTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                    C_KhkinouModeIdKbn.INPUT.getValue(), bzCommonLockProcess.getKouteiLockKey());
            }
        }

        String functionId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

            doTableUpdate(khozenCommonParam, functionId, userId, sysTime, sysDate);

            if (C_TyhysakuseiyhKbn.YOU.eq(uiBean.getTyhysakuseiyhkbn())) {
                makeTyouhyou(khozenCommonParam, sysDate);
            }
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
                IW_KhKzktrkKykDrHnkWk khKzktrkKykDrHnkWk = hozenDomManager.getKhKzktrkKykDrHnkWk(
                    uiBean.getBzWorkflowInfo().getKouteiKanriId());
                hozenDomManager.delete(khKzktrkKykDrHnkWk);
            }
            else {
                updateKhKzktrkKykDrHnkWk(functionId, userId, sysTime);
            }
        }

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
                C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn()))) {
            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
                C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) {
                insertKhKzktrkKykDrHnkWk(functionId, userId, sysTime);
            }
            else {
                updateKhKzktrkKykDrHnkWk(functionId, userId, sysTime);
            }
        }

        if (C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn())) {
            doJikouteikanri();

            messageManager.addMessageId(MessageId.IAC0009);

            if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
                !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {
                uiBean.getKykKihon().detach();
            }

            return;
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode())) {
            if (C_TeiseiKbn.TEISEI.eq(uiBean.getTeiseikbn())) {
                doTableUpdate(khozenCommonParam, functionId, userId, sysTime, sysDate);

                messageManager.addMessageId(MessageId.IAC0009);

                return;
            }
        }
    }

    void pushModoruByConfirmBL() {
        messageManager.removeConversationMessage(GROUP_SYOUKAI_WARNING);

        continueLockProcessBL();
    }

    @Transactional
    void pushKakuteiByskConfirmBL() {
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String functionId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();

        checkProcessKaishiAndSeikyusyoSakusei();

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector
            .getInstance(KhHituyousyoruiHanteiInBean.class);

        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setHenkougoHrkkeiro(C_Hrkkeiro.BLNK);

        hozenPreReportRenkeiBean.setSyoNo(uiBean.getSyono());
        hozenPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());
        hozenPreReportRenkeiBean.setSyoriComment(BLANK);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);
        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);
        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        editSouhuannaiParam.setMousideninkbn(uiBean.getMousideninkbn());
        editSouhuannaiParam.setShsnmkj(uiBean.getShsnmkj());
        editSouhuannaiParam.setShsyno(uiBean.getShskyno());
        editSouhuannaiParam.setShsadr1kj(uiBean.getShsadr1kj());
        editSouhuannaiParam.setShsadr2kj(uiBean.getShsadr2kj());
        editSouhuannaiParam.setShsadr3kj(uiBean.getShsadr3kj());

        editSeikyuusyoParam.setMousideninkbn(uiBean.getMousideninkbn());
        editSeikyuusyoParam.setTrkkzksakujyokahi1(uiBean.getTrkkzk1Sakujyo());
        editSeikyuusyoParam.setTrkkzksakujyokahi2(uiBean.getTrkkzk2Sakujyo());

        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);
        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        C_SyoruiCdKbn[] syoruiCds = { C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SOUHU,
            C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS };

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(), syoruiCds, C_YouhiKbn.YOU);

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setReportKey(khozenTyouhyouCtl.getTyouhyouKey());

        IW_KhKzktrkKykDrHnkWk khKzktrkKykDrHnkWk = new IW_KhKzktrkKykDrHnkWk();
        khKzktrkKykDrHnkWk.setKouteikanriid(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());
        khKzktrkKykDrHnkWk.setSyono(uiBean.getSyono());
        khKzktrkKykDrHnkWk.setSkssakuseiymd(sysDate);
        khKzktrkKykDrHnkWk.setMousideninkbn(uiBean.getMousideninkbn());
        khKzktrkKykDrHnkWk.setTeiseikbn(uiBean.getTeiseikbn());
        khKzktrkKykDrHnkWk.setShsnmkj(uiBean.getShsnmkj());
        khKzktrkKykDrHnkWk.setShskyno(uiBean.getShskyno());
        khKzktrkKykDrHnkWk.setShsadr1kj(uiBean.getShsadr1kj());
        khKzktrkKykDrHnkWk.setShsadr2kj(uiBean.getShsadr2kj());
        khKzktrkKykDrHnkWk.setShsadr3kj(uiBean.getShsadr3kj());
        khKzktrkKykDrHnkWk.setGyoumuKousinKinou(functionId);
        khKzktrkKykDrHnkWk.setGyoumuKousinsyaId(userId);
        khKzktrkKykDrHnkWk.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(khKzktrkKykDrHnkWk);

        hozenDomManager.insert(khKzktrkKykDrHnkWk);

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);
    }

    void printOut() {

        String tyhykey = uiBean.getReportKey();

        if (C_UmuKbn.NONE.eq(uiBean.getKykdrtkykhukaumu()) && C_MousideninKbn.KYKHONNIN.eq(uiBean.getMousideninkbn())) {

            DBAOutputReport dBAOutputReport = SWAKInjector.getInstance(DBAOutputReport.class);

            byte[] pdfByte = dBAOutputReport.getPdfImagesByJoinKeys(new String[] { tyhykey });

            String kykdrtkykYakkanFilePath = SWAK.getApplicationRootPath() + YuyuHozenConfig.getInstance().getKykdrtkykYakkanFilePath();
            String kzktrkServiceKiyakuFilePath = SWAK.getApplicationRootPath() + YuyuHozenConfig.getInstance().getKzktrkServiceKiyakuFilePath();

            try {
                PdfBuilder pdfBuilder = SWAKInjector.getInstance(PdfBuilder.class);

                pdfBuilder.append(new PdfReader(pdfByte));
                pdfBuilder.append(new PdfReader(kykdrtkykYakkanFilePath));
                pdfBuilder.append(new PdfReader(kzktrkServiceKiyakuFilePath));

                outputReport.outputJoinedPDFByBinary(pdfBuilder.toByteArray(), tyhykey);

            } catch (IOException e) {
                throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));
            }
        }
        else {
            outputReport.outputPDFByJoinKey(tyhykey);
        }
    }

    void printHyoujiOut() {
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void pushUnlockProcessBL() {

        bzCommonLockProcess.unlockProcess();
    }

    void continueLockProcessBL() {

        bzCommonLockProcess.continueLockProcess();
    }


    private void checkKykSonzai() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);
    }

    private void checkYuukouJyoutai(KhozenCommonParam pKhozenCommonParam) {

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }

        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            if (checkYuukouJyoutai.getWarningMessageIDList().size() != 0) {
                for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {
                    String messageID = BizUtil.getGeneralMessageId(checkYuukouJyoutai.getWarningMessageIDList().get(i));
                    messageManager.addConversationMessageId(GROUP_WORKLIST_MESSAGE,
                        messageID, checkYuukouJyoutai.getWarningMessageList().get(i));
                }
            }
        }
    }

    private void checkTetudukiTyuui(KhozenCommonParam pKhozenCommonParam) {

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(pKhozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }

        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(GROUP_WORKLIST_MESSAGE,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    private void setUiBean(KhozenCommonParam pKhozenCommonParam) {
        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);

        SetKihon.exec(pKhozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(pKhozenCommonParam, uiBean);

        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);

        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);

        SetTuusinsaki.exec(pKhozenCommonParam, uiBean);

        SetHihokensya.exec(pKhozenCommonParam, uiBean);

        SetSiteiseikyuu.exec(pKhozenCommonParam, uiBean);

        setTrkKazoku(pKhozenCommonParam);

        setKyksyadairi(pKhozenCommonParam);

        SetHituyouSyorui.exec(pKhozenCommonParam, uiBean);

        IT_KhTtdkTyuui khTtdkTyuui = uiBean.getKykKihon().getKhTtdkTyuui();

        if (khTtdkTyuui != null) {
            uiBean.setKykdrknhatudoujyoutai(khTtdkTyuui.getKykdrknhatudoujyoutai());
        }

        IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();
        uiBean.setKykdrtkykhukaumu(kykSonotaTkyk.getKykdrtkykhukaumu());

        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
            setKouteiInfo.exec(uiBean);

            SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
            setSyoruiInfoItiran.exec(uiBean);

            SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
            setProgressHistory.exec(uiBean);
        }

        if (uiBean.getWarningMessageIdList().size() > 0) {
            for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
                messageManager.addConversationMessageId(GROUP_WORKLIST_MESSAGE,
                    uiBean.getWarningMessageIdList().get(i), uiBean.getWarningMessageList().get(i));
            }
        }
    }

    private void checkYuuyokkngai() {
        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        boolean syoriKekka = checkYuuyokkngai.exec(uiBean.getSyono(), BizDate.getSysDate());

        if (!syoriKekka) {
            messageManager.addConversationMessageId(GROUP_WORKLIST_MESSAGE, MessageId.WIA0011);
        }
    }

    private void setTrkKazoku(KhozenCommonParam pKhozenCommonParam) {
        List<IT_TrkKzk> trkKzkList = pKhozenCommonParam.getTrkKzk(uiBean.getSyono());

        if (trkKzkList != null) {

            for (IT_TrkKzk trkKzk : trkKzkList) {
                if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {
                    uiBean.setTrkkzknmkn1(trkKzk.getTrkkzknmkn());
                    uiBean.setTrkkzknmkj1(trkKzk.getTrkkzknmkj());
                    uiBean.setTrkkzknmkjkhukakbn1(trkKzk.getTrkkzknmkjkhukakbn());
                    uiBean.setTrkkzkseiymd1(trkKzk.getTrkkzkseiymd());
                    uiBean.setTrkkzksei1(trkKzk.getTrkkzksei());
                    uiBean.setTrkkzkyno1(trkKzk.getTrkkzkyno());
                    uiBean.setTrkkzkadr1kj1(trkKzk.getTrkkzkadr1kj());
                    uiBean.setTrkkzkadr2kj1(trkKzk.getTrkkzkadr2kj());
                    uiBean.setTrkkzkadr3kj1(trkKzk.getTrkkzkadr3kj());
                    uiBean.setTrkkzktelno1(trkKzk.getTrkkzktelno());
                    uiBean.setTrkkzktdk1(trkKzk.getTrkkzktdk());
                    uiBean.setTrkkzkInfo1umukbn(C_UmuKbn.ARI);
                    uiBean.setTrkkzktsindousiteikbn1(trkKzk.getTrkkzktsindousiteikbn());
                }
                else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {
                    uiBean.setTrkkzknmkn2(trkKzk.getTrkkzknmkn());
                    uiBean.setTrkkzknmkj2(trkKzk.getTrkkzknmkj());
                    uiBean.setTrkkzknmkjkhukakbn2(trkKzk.getTrkkzknmkjkhukakbn());
                    uiBean.setTrkkzkseiymd2(trkKzk.getTrkkzkseiymd());
                    uiBean.setTrkkzksei2(trkKzk.getTrkkzksei());
                    uiBean.setTrkkzkyno2(trkKzk.getTrkkzkyno());
                    uiBean.setTrkkzkadr1kj2(trkKzk.getTrkkzkadr1kj());
                    uiBean.setTrkkzkadr2kj2(trkKzk.getTrkkzkadr2kj());
                    uiBean.setTrkkzkadr3kj2(trkKzk.getTrkkzkadr3kj());
                    uiBean.setTrkkzktelno2(trkKzk.getTrkkzktelno());
                    uiBean.setTrkkzktdk2(trkKzk.getTrkkzktdk());
                    uiBean.setTrkkzkInfo2umukbn(C_UmuKbn.ARI);
                    uiBean.setTrkkzktsindousiteikbn2(trkKzk.getTrkkzktsindousiteikbn());
                }
            }
        }
    }

    private void setKyksyadairi(KhozenCommonParam pKhozenCommonParam) {

        IT_KykUkt kykUkt = pKhozenCommonParam.getKyksyaDairinin(uiBean.getSyono());

        if (kykUkt != null) {
            uiBean.setKykdrkbn(kykUkt.getUktkbn());
            uiBean.setKykdairinmkn(kykUkt.getUktnmkn());
            uiBean.setKykdairinmkj(kykUkt.getUktnmkj());
            uiBean.setKykdrnmkjkhukakbn(kykUkt.getUktnmkjkhukakbn());
            uiBean.setKykdrseiymd(kykUkt.getUktseiymd());
            uiBean.setKykdryno(kykUkt.getUktyno());
            uiBean.setKykdradr1kj(kykUkt.getUktadr1kj());
            uiBean.setKykdradr2kj(kykUkt.getUktadr2kj());
            uiBean.setKykdradr3kj(kykUkt.getUktadr3kj());
        }
    }

    private void checkProcessKaishiAndSeikyusyoSakusei() {
        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();
            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }
    }

    private void checkProcessKaishiAndKakutei() {
        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();
            throw new BizLogicException(MessageId.EIA1002,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }
    }

    private void hanteiSyoriKengen() {
        String kinMode = kinouMode.getKinouMode();

        if (kinMode == null || C_KhkinouModeIdKbn.DEFAULT.getValue().equals(kinMode)) {
            boolean inputKengenFlg = baseUserInfo.hasAuthenticatedFunctionMode(
                C_KhkinouModeIdKbn.INPUTKEY.getValue());

            if (inputKengenFlg) {
                kinouMode.setKinouMode(C_KhkinouModeIdKbn.INPUTKEY.getValue());
            }
            else {
                boolean syoukaiKengenFlg = baseUserInfo.hasAuthenticatedFunctionMode(
                    C_KhkinouModeIdKbn.SYORI.getValue());

                if (syoukaiKengenFlg) {
                    kinouMode.setKinouMode(C_KhkinouModeIdKbn.SYORI.getValue());
                }
                else {
                    throw new BizAppException(MessageId.EBS0003);
                }
            }
        }
    }

    private void checkInput() {

        KhKzktrkKykdrHnkInfoUiBean khKzktrkKykdrHnkInfoUiBean =
            SWAKInjector.getInstance(KhKzktrkKykdrHnkInfoUiBean.class);

        if (!BizUtil.isBlank(uiBean.getNewtrkkzknmkn1()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzknmkj1()) ||
            !C_KjkhukaKbn.BLNK.eq(uiBean.getNewtrkkzknmkjkhukakbn1()) ||
            uiBean.getNewtrkkzkseiymd1() != null ||
            !C_Seibetu.BLNK.eq(uiBean.getNewtrkkzksei1()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzkyno1()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj1()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzkadr2kj1()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzkadr3kj1()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzktelno1()) ||
            !C_Tdk.BLNK.eq(uiBean.getNewtrkkzktdk1()) ||
            !C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn1())) {
            uiBean.setNewTrkkzkInfo1umukbn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setNewTrkkzkInfo1umukbn(C_UmuKbn.NONE);
        }

        if (!BizUtil.isBlank(uiBean.getNewtrkkzknmkn2()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzknmkj2()) ||
            !C_KjkhukaKbn.BLNK.eq(uiBean.getNewtrkkzknmkjkhukakbn2()) ||
            uiBean.getNewtrkkzkseiymd2() != null ||
            !C_Seibetu.BLNK.eq(uiBean.getNewtrkkzksei2()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzkyno2()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj2()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzkadr2kj2()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzkadr3kj2()) ||
            !BizUtil.isBlank(uiBean.getNewtrkkzktelno2()) ||
            !C_Tdk.BLNK.eq(uiBean.getNewtrkkzktdk2()) ||
            !C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn2())) {
            uiBean.setNewTrkkzkInfo2umukbn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setNewTrkkzkInfo2umukbn(C_UmuKbn.NONE);
        }

        if (!BizUtil.isBlank(uiBean.getNewkykdrnmkn()) ||
            !BizUtil.isBlank(uiBean.getNewkykdrnmkj()) ||
            !C_KjkhukaKbn.BLNK.eq(uiBean.getNewkykdrnmkjkhukakbn()) ||
            uiBean.getNewkykdrseiymd() != null ||
            !BizUtil.isBlank(uiBean.getNewkykdryno()) ||
            !BizUtil.isBlank(uiBean.getNewkykdradr1kj()) ||
            !BizUtil.isBlank(uiBean.getNewkykdradr2kj()) ||
            !BizUtil.isBlank(uiBean.getNewkykdradr3kj())) {
            uiBean.setNewKyksyadairininumukbn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setNewKyksyadairininumukbn(C_UmuKbn.NONE);
        }

        String newtrkkzkadr1kj1 = BLANK;
        String newtrkkzkadr2kj1 = BLANK;
        String newtrkkzkadr3kj1 = BLANK;
        String newtrkkzkadr1kj2 = BLANK;
        String newtrkkzkadr2kj2 = BLANK;
        String newtrkkzkadr3kj2 = BLANK;
        String kykdradr1kj = BLANK;
        String kykdradr2kj = BLANK;
        String kykdradr3kj = BLANK;

        IT_KykSya kykSya = uiBean.getKykKihon().getKykSya();

        if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn1())) {
            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn1())) {
                newtrkkzkadr1kj1 = uiBean.getNewtrkkzkadr1kj1();
                newtrkkzkadr2kj1 = uiBean.getNewtrkkzkadr2kj1();
                newtrkkzkadr3kj1 = uiBean.getNewtrkkzkadr3kj1();
            }
            else {
                newtrkkzkadr1kj1 = kykSya.getTsinadr1kj();
                newtrkkzkadr2kj1 = kykSya.getTsinadr2kj();
                newtrkkzkadr3kj1 = kykSya.getTsinadr3kj();
            }
        }
        else if (C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn1())) {
            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn1())) {
                if (!BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj1())) {
                    newtrkkzkadr1kj1 = uiBean.getNewtrkkzkadr1kj1();
                    newtrkkzkadr2kj1 = uiBean.getNewtrkkzkadr2kj1();
                    newtrkkzkadr3kj1 = uiBean.getNewtrkkzkadr3kj1();
                }
                else {
                    newtrkkzkadr1kj1 = uiBean.getTrkkzkadr1kj1();
                    newtrkkzkadr2kj1 = uiBean.getTrkkzkadr2kj1();
                    newtrkkzkadr3kj1 = uiBean.getTrkkzkadr3kj1();
                }
            }
            else {
                newtrkkzkadr1kj1 = kykSya.getTsinadr1kj();
                newtrkkzkadr2kj1 = kykSya.getTsinadr2kj();
                newtrkkzkadr3kj1 = kykSya.getTsinadr3kj();
            }
        }

        if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn2())) {
            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn2())) {
                newtrkkzkadr1kj2 = uiBean.getNewtrkkzkadr1kj2();
                newtrkkzkadr2kj2 = uiBean.getNewtrkkzkadr2kj2();
                newtrkkzkadr3kj2 = uiBean.getNewtrkkzkadr3kj2();
            }
            else {
                newtrkkzkadr1kj2 = kykSya.getTsinadr1kj();
                newtrkkzkadr2kj2 = kykSya.getTsinadr2kj();
                newtrkkzkadr3kj2 = kykSya.getTsinadr3kj();
            }
        }
        else if (C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn2())) {
            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn2())) {
                if (!BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj2())) {
                    newtrkkzkadr1kj2 = uiBean.getNewtrkkzkadr1kj2();
                    newtrkkzkadr2kj2 = uiBean.getNewtrkkzkadr2kj2();
                    newtrkkzkadr3kj2 = uiBean.getNewtrkkzkadr3kj2();
                }
                else {
                    newtrkkzkadr1kj2 = uiBean.getTrkkzkadr1kj2();
                    newtrkkzkadr2kj2 = uiBean.getTrkkzkadr2kj2();
                    newtrkkzkadr3kj2 = uiBean.getTrkkzkadr3kj2();
                }
            }
            else {
                newtrkkzkadr1kj2 = kykSya.getTsinadr1kj();
                newtrkkzkadr2kj2 = kykSya.getTsinadr2kj();
                newtrkkzkadr3kj2 = kykSya.getTsinadr3kj();
            }
        }

        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(uiBean.getKykdrtkykttdkkbn())) {
            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewkykdrkbn())) {
                kykdradr1kj = uiBean.getNewkykdradr1kj();
                kykdradr2kj = uiBean.getNewkykdradr2kj();
                kykdradr3kj = uiBean.getNewkykdradr3kj();
            }
        }
        else if (C_KykdrtkykttdkKbn.HENKOU.eq(uiBean.getKykdrtkykttdkkbn())) {
            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewkykdrkbn())) {
                if (!BizUtil.isBlank(uiBean.getNewkykdradr1kj())) {
                    kykdradr1kj = uiBean.getNewkykdradr1kj();
                    kykdradr2kj = uiBean.getNewkykdradr2kj();
                    kykdradr3kj = uiBean.getNewkykdradr3kj();
                }
                else {
                    kykdradr1kj = uiBean.getKykdradr1kj();
                    kykdradr2kj = uiBean.getKykdradr2kj();
                    kykdradr3kj = uiBean.getKykdradr3kj();
                }
            }
        }

        khKzktrkKykdrHnkInfoUiBean.setSyono(uiBean.getSyono());
        uiBean.setKhKzktrkKykdrHnkInfoUiBean(khKzktrkKykdrHnkInfoUiBean);

        List<MeigiAddrBean> meigiAddrBeanLst = Lists.newArrayList();
        MeigiAddrBean meigiAddrBean = SWAKInjector.getInstance(MeigiAddrBean.class);
        CheckKhMeigiAddr checkKhMeigiAddr = SWAKInjector.getInstance(CheckKhMeigiAddr.class);
        if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn1()) ||
            C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn1())) {

            meigiAddrBean.setNmKnFieldNm(MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKNMKN1.getErrorResourceKey()));
            meigiAddrBean.setNmKn(uiBean.getNewtrkkzknmkn1());
            meigiAddrBean.setNmKjFieldNm(MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKNMKJ1.getErrorResourceKey()));
            meigiAddrBean.setNmKj(uiBean.getNewtrkkzknmkj1());
            meigiAddrBean.setNmKjhukaKbn(uiBean.getNewtrkkzknmkjkhukakbn1());
            meigiAddrBean.setSeiYmdFieldNm(MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKSEIYMD1.getErrorResourceKey()));
            meigiAddrBean.setSeiYmd(uiBean.getNewtrkkzkseiymd1());
            meigiAddrBean.setSyoriYmd(BizDate.getSysDate());
            meigiAddrBean.setAdrkjFieldNm(MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKADR1KJ1.getErrorResourceKey()));
            meigiAddrBean.setAdrkj1(newtrkkzkadr1kj1);
            meigiAddrBean.setAdrkj2(newtrkkzkadr2kj1);
            meigiAddrBean.setAdrkj3(newtrkkzkadr3kj1);

            meigiAddrBeanLst.add(meigiAddrBean);
        }

        if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn2()) ||
            C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn2())) {

            meigiAddrBean = SWAKInjector.getInstance(MeigiAddrBean.class);
            meigiAddrBean.setNmKnFieldNm(MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKNMKN2.getErrorResourceKey()));
            meigiAddrBean.setNmKn(uiBean.getNewtrkkzknmkn2());
            meigiAddrBean.setNmKjFieldNm(MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKNMKJ2.getErrorResourceKey()));
            meigiAddrBean.setNmKj(uiBean.getNewtrkkzknmkj2());
            meigiAddrBean.setNmKjhukaKbn(uiBean.getNewtrkkzknmkjkhukakbn2());
            meigiAddrBean.setSeiYmdFieldNm(MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKSEIYMD2.getErrorResourceKey()));
            meigiAddrBean.setSeiYmd(uiBean.getNewtrkkzkseiymd2());
            meigiAddrBean.setSyoriYmd(BizDate.getSysDate());
            meigiAddrBean.setAdrkjFieldNm(MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKADR1KJ2.getErrorResourceKey()));
            meigiAddrBean.setAdrkj1(newtrkkzkadr1kj2);
            meigiAddrBean.setAdrkj2(newtrkkzkadr2kj2);
            meigiAddrBean.setAdrkj3(newtrkkzkadr3kj2);

            meigiAddrBeanLst.add(meigiAddrBean);
        }

        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(uiBean.getKykdrtkykttdkkbn()) ||
            C_KykdrtkykttdkKbn.HENKOU.eq(uiBean.getKykdrtkykttdkkbn())) {

            meigiAddrBean = SWAKInjector.getInstance(MeigiAddrBean.class);
            meigiAddrBean.setNmKnFieldNm(MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRNMKN.getErrorResourceKey()));
            meigiAddrBean.setNmKn(uiBean.getNewkykdrnmkn());
            meigiAddrBean.setNmKjFieldNm(MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRNMKJ.getErrorResourceKey()));
            meigiAddrBean.setNmKj(uiBean.getNewkykdrnmkj());
            meigiAddrBean.setNmKjhukaKbn(uiBean.getNewkykdrnmkjkhukakbn());
            meigiAddrBean.setSeiYmdFieldNm(MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRSEIYMD
                .getErrorResourceKey()));
            meigiAddrBean.setSeiYmd(uiBean.getNewkykdrseiymd());
            meigiAddrBean.setSyoriYmd(BizDate.getSysDate());
            meigiAddrBean.setAdrkjFieldNm(MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRADR1KJ
                .getErrorResourceKey()));
            meigiAddrBean.setAdrkj1(kykdradr1kj);
            meigiAddrBean.setAdrkj2(kykdradr2kj);
            meigiAddrBean.setAdrkj3(kykdradr3kj);

            meigiAddrBeanLst.add(meigiAddrBean);
        }

        if (meigiAddrBeanLst.size() > 0) {

            checkKhMeigiAddr.exec(meigiAddrBeanLst);
        }

        if (C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn1()) &&
            C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn2()) &&
            C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn())) {
            throw new BizLogicException(MessageId.EIF1135);
        }

        if (C_TeiseiKbn.TEISEI.eq(uiBean.getTeiseikbn())) {
            if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn1()) ||
                C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn1())) {
                throw new BizLogicException(MessageId.EIF1136,
                    MessageUtil.getMessage(DDID_TRKKZKINFO1_TRKKZKTTDKKBN1.getErrorResourceKey()));
            }

            if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn2()) ||
                C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn2())) {
                throw new BizLogicException(MessageId.EIF1136,
                    MessageUtil.getMessage(DDID_TRKKZKINFO2_TRKKZKTTDKKBN2.getErrorResourceKey()));
            }

            if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(uiBean.getKykdrtkykttdkkbn()) ||
                C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(uiBean.getKykdrtkykttdkkbn())) {
                throw new BizLogicException(MessageId.EIF1136,
                    MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_KYKDRTKYKTTDKKBN.getErrorResourceKey()));
            }
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        BM_SyouhnZokusei syouhnZokusei = khozenCommonParam.getKeiyakuSyouhin(
            uiBean.getSyono(), C_SyutkKbn.SYU).get(0).getSyouhnZokusei();

        if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn1()) ||
            C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn2())) {
            if (C_UmuKbn.NONE.eq(syouhnZokusei.getKzktourokuserviceumu())) {
                throw new BizLogicException(MessageId.EIF1137);
            }

            if (!C_MousideninKbn.KYKHONNIN.eq(uiBean.getMousideninkbn())) {
                throw new BizLogicException(MessageId.EIF1139);
            }
        }

        if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn1())) {
            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzkInfo1umukbn())) {
                throw new BizLogicException(MessageId.EIF1138, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
            }

            checkTrkkzkInfo1Input();

            if (uiBean.getVstskstdrsknmkn().equals(uiBean.getNewtrkkzknmkn1()) &&
                uiBean.getVstskstdrsknmkj().equals(uiBean.getNewtrkkzknmkj1()) &&
                BizDateUtil.compareYmd(
                    uiBean.getVstskstdrskseiymd(), uiBean.getNewtrkkzkseiymd1()) == BizDateUtil.COMPARE_EQUAL) {
                uiBean.setTrkkzk1AndHihokensyamukbn(C_UmuKbn.ARI);
            }
            else {
                uiBean.setTrkkzk1AndHihokensyamukbn(C_UmuKbn.NONE);
            }

            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkkbn1(C_TrkKzkKbn.TRKKZK1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkn1(uiBean.getNewtrkkzknmkn1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkj1(uiBean.getNewtrkkzknmkj1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkjkhukakbn1(uiBean.getNewtrkkzknmkjkhukakbn1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkseiymd1(uiBean.getNewtrkkzkseiymd1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzksei1(uiBean.getNewtrkkzksei1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktdk1(uiBean.getNewtrkkzktdk1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr1kj1(newtrkkzkadr1kj1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr2kj1(newtrkkzkadr2kj1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr3kj1(newtrkkzkadr3kj1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktelno1(uiBean.getNewtrkkzktelno1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn1(uiBean.getNewtrkkzktsindousiteikbn1());
            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn1())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkyno1(uiBean.getNewtrkkzkyno1());
            }
            else {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkyno1(kykSya.getTsinyno());
            }
        }
        if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn2())) {
            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzkInfo2umukbn())) {
                throw new BizLogicException(MessageId.EIF1138, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
            }

            checkTrkkzkInfo2Input();

            if (uiBean.getVstskstdrsknmkn().equals(uiBean.getNewtrkkzknmkn2()) &&
                uiBean.getVstskstdrsknmkj().equals(uiBean.getNewtrkkzknmkj2()) &&
                BizDateUtil.compareYmd(
                    uiBean.getVstskstdrskseiymd(), uiBean.getNewtrkkzkseiymd2()) == BizDateUtil.COMPARE_EQUAL) {
                uiBean.setTrkkzk2AndHihokensyamukbn(C_UmuKbn.ARI);
            }
            else {
                uiBean.setTrkkzk2AndHihokensyamukbn(C_UmuKbn.NONE);
            }

            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkkbn2(C_TrkKzkKbn.TRKKZK2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkn2(uiBean.getNewtrkkzknmkn2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkj2(uiBean.getNewtrkkzknmkj2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkjkhukakbn2(uiBean.getNewtrkkzknmkjkhukakbn2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkseiymd2(uiBean.getNewtrkkzkseiymd2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzksei2(uiBean.getNewtrkkzksei2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktdk2(uiBean.getNewtrkkzktdk2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr1kj2(newtrkkzkadr1kj2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr2kj2(newtrkkzkadr2kj2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr3kj2(newtrkkzkadr3kj2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktelno2(uiBean.getNewtrkkzktelno2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn2(uiBean.getNewtrkkzktsindousiteikbn2());
            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn2())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkyno2(uiBean.getNewtrkkzkyno2());
            }
            else {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkyno2(kykSya.getTsinyno());
            }
        }

        if (C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn1())) {
            if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo1umukbn())) {
                throw new BizLogicException(MessageId.EIF1140, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
            }

            String newtrkkzknmkn1 = BLANK;
            String newtrkkzknmkj1 = BLANK;
            C_KjkhukaKbn newtrkkzknmkjkhukakbn1 = C_KjkhukaKbn.BLNK;
            BizDate newtrkkzkseiymd1 = null;
            C_Seibetu newtrkkzksei1 = C_Seibetu.BLNK;
            C_Tdk newtrkkzktdk1 = C_Tdk.BLNK;
            String newtrkkzkyno1 = BLANK;
            String newtrkkzktelno1 = BLANK;

            if (BizUtil.isBlank(uiBean.getNewtrkkzknmkn1())) {
                newtrkkzknmkn1 = uiBean.getTrkkzknmkn1();
            }
            else {
                newtrkkzknmkn1 = uiBean.getNewtrkkzknmkn1();
            }

            if (BizUtil.isBlank(uiBean.getNewtrkkzknmkj1())) {
                newtrkkzknmkj1 = uiBean.getTrkkzknmkj1();
            }
            else {
                newtrkkzknmkj1 = uiBean.getNewtrkkzknmkj1();
            }

            if (BizUtil.isBlank(uiBean.getNewtrkkzknmkj1()) && C_KjkhukaKbn.BLNK.eq(uiBean.getNewtrkkzknmkjkhukakbn1())) {
                newtrkkzknmkjkhukakbn1 = uiBean.getTrkkzknmkjkhukakbn1();
            }
            else {
                newtrkkzknmkjkhukakbn1 = uiBean.getNewtrkkzknmkjkhukakbn1();
            }

            if (uiBean.getNewtrkkzkseiymd1() == null) {
                newtrkkzkseiymd1 = uiBean.getTrkkzkseiymd1();
            }
            else {
                newtrkkzkseiymd1 = uiBean.getNewtrkkzkseiymd1();
            }

            if (C_Seibetu.BLNK.eq(uiBean.getNewtrkkzksei1())) {
                newtrkkzksei1 = uiBean.getTrkkzksei1();
            }
            else {
                newtrkkzksei1 = uiBean.getNewtrkkzksei1();
            }

            if (C_Tdk.BLNK.eq(uiBean.getNewtrkkzktdk1())) {
                newtrkkzktdk1 = uiBean.getTrkkzktdk1();
            }
            else {
                newtrkkzktdk1 = uiBean.getNewtrkkzktdk1();
            }

            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn1())) {
                if (BizUtil.isBlank(uiBean.getNewtrkkzkyno1())) {
                    newtrkkzkyno1 = uiBean.getTrkkzkyno1();
                }
                else {
                    newtrkkzkyno1 = uiBean.getNewtrkkzkyno1();
                }
            }
            else {
                newtrkkzkyno1 = kykSya.getTsinyno();
            }

            if (BizUtil.isBlank(uiBean.getNewtrkkzktelno1())) {
                newtrkkzktelno1 = uiBean.getTrkkzktelno1();
            }
            else {
                newtrkkzktelno1 = uiBean.getNewtrkkzktelno1();
            }

            if (!newtrkkzknmkn1.equals(uiBean.getTrkkzknmkn1()) &&
                !newtrkkzknmkj1.equals(uiBean.getTrkkzknmkj1()) &&
                BizDateUtil.compareYmd(newtrkkzkseiymd1, uiBean.getTrkkzkseiymd1()) != BizDateUtil.COMPARE_EQUAL) {
                uiBean.setTrkkzk1AndKykmukbn(C_UmuKbn.ARI);
            }
            else {
                uiBean.setTrkkzk1AndKykmukbn(C_UmuKbn.NONE);
            }

            if (uiBean.getVstskstdrsknmkn().equals(newtrkkzknmkn1) &&
                uiBean.getVstskstdrsknmkj().equals(newtrkkzknmkj1) &&
                BizDateUtil.compareYmd(
                    uiBean.getVstskstdrskseiymd(), newtrkkzkseiymd1) == BizDateUtil.COMPARE_EQUAL) {
                uiBean.setTrkkzk1AndHihokensyamukbn(C_UmuKbn.ARI);
            }
            else {
                uiBean.setTrkkzk1AndHihokensyamukbn(C_UmuKbn.NONE);
            }

            if (C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn()) &&
                !C_MousideninKbn.KYKHONNIN.eq(uiBean.getMousideninkbn()) &&
                !C_MousideninKbn.TRKKZK1.eq(uiBean.getMousideninkbn())) {
                throw new BizLogicException(MessageId.EIF1141,
                    C_MousideninKbn.getContentByValue(
                        C_MousideninKbn.PATTERN_KZKTRKKYKDRTKYKHNK,uiBean.getMousideninkbn().getValue()),
                        C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
            }

            if (C_MousideninKbn.TRKKZK1.eq(uiBean.getMousideninkbn())) {
                if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn()) ||
                    C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn())) {
                    throw new BizLogicException(MessageId.EIF1160, C_UktKbn.getContentByValue(
                        C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
                }

                if (C_UmuKbn.ARI.eq(uiBean.getTrkkzk1AndKykmukbn())) {
                    throw new BizLogicException(MessageId.EIF1156);
                }
            }

            if (C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai()) &&
                C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn()) &&
                C_UmuKbn.ARI.eq(uiBean.getTrkkzk1AndKykmukbn())) {
                throw new BizLogicException(MessageId.EIF1142);
            }

            if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn()) &&
                uiBean.getVhhkshhknnmkn().equals(newtrkkzknmkn1) &&
                uiBean.getVhhkshhknnmkj().equals(newtrkkzknmkj1) &&
                BizDateUtil.compareYmd(
                    uiBean.getVhhkshhknseiymd(), newtrkkzkseiymd1) == BizDateUtil.COMPARE_EQUAL) {
                throw new BizLogicException(MessageId.EIA1070, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
            }

            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn1())) {
                if (BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj1()) &&
                    (!BizUtil.isBlank(uiBean.getNewtrkkzkadr2kj1()) ||
                        !BizUtil.isBlank(uiBean.getNewtrkkzkadr3kj1()))) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKADR1KJ1.getErrorResourceKey()));
                }
            }
            else {
                if (!BizUtil.isBlank(uiBean.getNewtrkkzkyno1())) {
                    throw new BizLogicException(MessageId.EBC0012,
                        MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKYNO1.getErrorResourceKey()));
                }

                if (!BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj1()) ||
                    !BizUtil.isBlank(uiBean.getNewtrkkzkadr2kj1()) ||
                    !BizUtil.isBlank(uiBean.getNewtrkkzkadr3kj1())) {
                    throw new BizLogicException(MessageId.EBC0012,
                        MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKADR1KJ1.getErrorResourceKey()));
                }
            }

            if (C_UmuKbn.NONE.eq(uiBean.getNewTrkkzkInfo1umukbn())) {
                throw new BizLogicException(MessageId.EBC0043, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
            }

            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkkbn1(C_TrkKzkKbn.TRKKZK1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkn1(newtrkkzknmkn1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkj1(newtrkkzknmkj1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkjkhukakbn1(newtrkkzknmkjkhukakbn1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkseiymd1(newtrkkzkseiymd1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzksei1(newtrkkzksei1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktdk1(newtrkkzktdk1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkyno1(newtrkkzkyno1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr1kj1(newtrkkzkadr1kj1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr2kj1(newtrkkzkadr2kj1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr3kj1(newtrkkzkadr3kj1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktelno1(newtrkkzktelno1);
            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn1())) {
                if (!BizUtil.isBlank(uiBean.getNewtrkkzkyno1()) || !BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj1())) {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn1(
                        uiBean.getNewtrkkzktsindousiteikbn1());
                }
                else {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn1(
                        uiBean.getTrkkzktsindousiteikbn1());
                }
            }
            else {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn1(uiBean.getNewtrkkzktsindousiteikbn1());
            }
        }

        if (C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn2())) {
            if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo2umukbn())) {
                throw new BizLogicException(MessageId.EIF1140, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
            }

            String newtrkkzknmkn2 = BLANK;
            String newtrkkzknmkj2 = BLANK;
            C_KjkhukaKbn newtrkkzknmkjkhukakbn2 = C_KjkhukaKbn.BLNK;
            BizDate newtrkkzkseiymd2 = null;
            C_Seibetu newtrkkzksei2 = C_Seibetu.BLNK;
            C_Tdk newtrkkzktdk2 = C_Tdk.BLNK;
            String newtrkkzkyno2 = BLANK;
            String newtrkkzktelno2 = BLANK;

            if (BizUtil.isBlank(uiBean.getNewtrkkzknmkn2())) {
                newtrkkzknmkn2 = uiBean.getTrkkzknmkn2();
            }
            else {
                newtrkkzknmkn2 = uiBean.getNewtrkkzknmkn2();
            }

            if (BizUtil.isBlank(uiBean.getNewtrkkzknmkj2())) {
                newtrkkzknmkj2 = uiBean.getTrkkzknmkj2();
            }
            else {
                newtrkkzknmkj2 = uiBean.getNewtrkkzknmkj2();
            }

            if (BizUtil.isBlank(uiBean.getNewtrkkzknmkj2()) && C_KjkhukaKbn.BLNK.eq(uiBean.getNewtrkkzknmkjkhukakbn2())) {
                newtrkkzknmkjkhukakbn2 = uiBean.getTrkkzknmkjkhukakbn2();
            }
            else {
                newtrkkzknmkjkhukakbn2 = uiBean.getNewtrkkzknmkjkhukakbn2();
            }

            if (uiBean.getNewtrkkzkseiymd2() == null) {
                newtrkkzkseiymd2 = uiBean.getTrkkzkseiymd2();
            }
            else {
                newtrkkzkseiymd2 = uiBean.getNewtrkkzkseiymd2();
            }

            if (C_Seibetu.BLNK.eq(uiBean.getNewtrkkzksei2())) {
                newtrkkzksei2 = uiBean.getTrkkzksei2();
            }
            else {
                newtrkkzksei2 = uiBean.getNewtrkkzksei2();
            }

            if (C_Tdk.BLNK.eq(uiBean.getNewtrkkzktdk2())) {
                newtrkkzktdk2 = uiBean.getTrkkzktdk2();
            }
            else {
                newtrkkzktdk2 = uiBean.getNewtrkkzktdk2();
            }

            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn2())) {
                if (BizUtil.isBlank(uiBean.getNewtrkkzkyno2())) {
                    newtrkkzkyno2 = uiBean.getTrkkzkyno2();
                }
                else {
                    newtrkkzkyno2 = uiBean.getNewtrkkzkyno2();
                }
            }
            else {
                newtrkkzkyno2 = kykSya.getTsinyno();
            }

            if (BizUtil.isBlank(uiBean.getNewtrkkzktelno2())) {
                newtrkkzktelno2 = uiBean.getTrkkzktelno2();
            }
            else {
                newtrkkzktelno2 = uiBean.getNewtrkkzktelno2();
            }

            if (!newtrkkzknmkn2.equals(uiBean.getTrkkzknmkn2()) &&
                !newtrkkzknmkj2.equals(uiBean.getTrkkzknmkj2()) &&
                BizDateUtil.compareYmd(newtrkkzkseiymd2, uiBean.getTrkkzkseiymd2()) != BizDateUtil.COMPARE_EQUAL) {
                uiBean.setTrkkzk2AndKykmukbn(C_UmuKbn.ARI);
            }
            else {
                uiBean.setTrkkzk2AndKykmukbn(C_UmuKbn.NONE);
            }

            if (uiBean.getVstskstdrsknmkn().equals(newtrkkzknmkn2) &&
                uiBean.getVstskstdrsknmkj().equals(newtrkkzknmkj2) &&
                BizDateUtil.compareYmd(
                    uiBean.getVstskstdrskseiymd(), newtrkkzkseiymd2) == BizDateUtil.COMPARE_EQUAL) {
                uiBean.setTrkkzk2AndHihokensyamukbn(C_UmuKbn.ARI);
            }
            else {
                uiBean.setTrkkzk2AndHihokensyamukbn(C_UmuKbn.NONE);
            }

            if (C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn()) &&
                !C_MousideninKbn.KYKHONNIN.eq(uiBean.getMousideninkbn()) &&
                !C_MousideninKbn.TRKKZK2.eq(uiBean.getMousideninkbn())) {
                throw new BizLogicException(MessageId.EIF1141,
                    C_MousideninKbn.getContentByValue(
                        C_MousideninKbn.PATTERN_KZKTRKKYKDRTKYKHNK,uiBean.getMousideninkbn().getValue()),
                        C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
            }

            if (C_MousideninKbn.TRKKZK2.eq(uiBean.getMousideninkbn())) {
                if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn()) ||
                    C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn())) {
                    throw new BizLogicException(MessageId.EIF1160, C_UktKbn.getContentByValue(
                        C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
                }

                if (C_UmuKbn.ARI.eq(uiBean.getTrkkzk2AndKykmukbn())) {
                    throw new BizLogicException(MessageId.EIF1156);
                }
            }

            if (C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai()) &&
                C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn()) &&
                C_UmuKbn.ARI.eq(uiBean.getTrkkzk2AndKykmukbn())) {
                throw new BizLogicException(MessageId.EIF1142);
            }

            if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn()) &&
                uiBean.getVhhkshhknnmkn().equals(newtrkkzknmkn2) &&
                uiBean.getVhhkshhknnmkj().equals(newtrkkzknmkj2) &&
                BizDateUtil.compareYmd(
                    uiBean.getVhhkshhknseiymd(), newtrkkzkseiymd2) == BizDateUtil.COMPARE_EQUAL) {
                throw new BizLogicException(MessageId.EIA1070, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
            }

            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn2())) {
                if (BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj2()) &&
                    (!BizUtil.isBlank(uiBean.getNewtrkkzkadr2kj2()) ||
                        !BizUtil.isBlank(uiBean.getNewtrkkzkadr3kj2()))) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKADR1KJ2.getErrorResourceKey()));
                }
            }
            else {
                if (!BizUtil.isBlank(uiBean.getNewtrkkzkyno2())) {
                    throw new BizLogicException(MessageId.EBC0012,
                        MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKYNO2.getErrorResourceKey()));
                }

                if (!BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj2()) ||
                    !BizUtil.isBlank(uiBean.getNewtrkkzkadr2kj2()) ||
                    !BizUtil.isBlank(uiBean.getNewtrkkzkadr3kj2())) {
                    throw new BizLogicException(MessageId.EBC0012,
                        MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKADR1KJ2.getErrorResourceKey()));
                }
            }

            if (C_UmuKbn.NONE.eq(uiBean.getNewTrkkzkInfo2umukbn())) {
                throw new BizLogicException(MessageId.EBC0043, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
            }

            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkkbn2(C_TrkKzkKbn.TRKKZK2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkn2(newtrkkzknmkn2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkj2(newtrkkzknmkj2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkjkhukakbn2(newtrkkzknmkjkhukakbn2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkseiymd2(newtrkkzkseiymd2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzksei2(newtrkkzksei2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktdk2(newtrkkzktdk2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkyno2(newtrkkzkyno2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr1kj2(newtrkkzkadr1kj2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr2kj2(newtrkkzkadr2kj2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr3kj2(newtrkkzkadr3kj2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktelno2(newtrkkzktelno2);
            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn2())) {
                if (!BizUtil.isBlank(uiBean.getNewtrkkzkyno2()) || !BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj2())) {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn2(
                        uiBean.getNewtrkkzktsindousiteikbn2());
                }
                else {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn2(
                        uiBean.getTrkkzktsindousiteikbn2());
                }
            }
            else {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn2(uiBean.getNewtrkkzktsindousiteikbn2());
            }
        }

        if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn1())) {

            if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo1umukbn())) {
                throw new BizLogicException(MessageId.EIF1140, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
            }

            if (C_MousideninKbn.TRKKZK2.eq(uiBean.getMousideninkbn())) {
                throw new BizLogicException(MessageId.EIF1143,
                    C_MousideninKbn.getContentByValue(
                        C_MousideninKbn.PATTERN_KZKTRKKYKDRTKYKHNK,uiBean.getMousideninkbn().getValue()),
                        C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
            }

            if (C_UmuKbn.ARI.eq(uiBean.getNewTrkkzkInfo1umukbn())) {
                throw new BizLogicException(MessageId.EIF1145);
            }

            if (C_MousideninKbn.KYKHONNIN.eq(uiBean.getMousideninkbn()) &&
                C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn())) {
                if (!C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai()) &&
                    C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn())) {
                    throw new BizLogicException(MessageId.EIF1146, C_UktKbn.getContentByValue(
                        C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
                }

                if (C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai())) {
                    throw new BizLogicException(MessageId.EIF1148);
                }
            }

            if (C_MousideninKbn.TRKKZK1.eq(uiBean.getMousideninkbn()) ||
                C_MousideninKbn.HHKNHONNIN.eq(uiBean.getMousideninkbn())) {
                if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn()) ||
                    C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn())) {
                    throw new BizLogicException(MessageId.EIF1157, C_UktKbn.getContentByValue(
                        C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
                }
            }

            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkkbn1(C_TrkKzkKbn.TRKKZK1);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkn1(uiBean.getTrkkzknmkn1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkj1(uiBean.getTrkkzknmkj1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkjkhukakbn1(uiBean.getTrkkzknmkjkhukakbn1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkseiymd1(uiBean.getTrkkzkseiymd1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzksei1(uiBean.getTrkkzksei1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktdk1(uiBean.getTrkkzktdk1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkyno1(uiBean.getTrkkzkyno1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr1kj1(uiBean.getTrkkzkadr1kj1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr2kj1(uiBean.getTrkkzkadr2kj1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr3kj1(uiBean.getTrkkzkadr3kj1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktelno1(uiBean.getTrkkzktelno1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn1(uiBean.getTrkkzktsindousiteikbn1());
        }

        if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn2())) {
            if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo2umukbn())) {
                throw new BizLogicException(MessageId.EIF1140, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
            }

            if (C_MousideninKbn.TRKKZK1.eq(uiBean.getMousideninkbn())) {
                throw new BizLogicException(MessageId.EIF1143,
                    C_MousideninKbn.getContentByValue(
                        C_MousideninKbn.PATTERN_KZKTRKKYKDRTKYKHNK,uiBean.getMousideninkbn().getValue()),
                        C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
            }

            if (C_UmuKbn.ARI.eq(uiBean.getNewTrkkzkInfo2umukbn())) {
                throw new BizLogicException(MessageId.EIF1145);
            }

            if (C_MousideninKbn.KYKHONNIN.eq(uiBean.getMousideninkbn()) &&
                C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn())) {
                if (!C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai()) &&
                    C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn())) {
                    throw new BizLogicException(MessageId.EIF1146, C_UktKbn.getContentByValue(
                        C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
                }

                if (C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai())) {
                    throw new BizLogicException(MessageId.EIF1148);
                }
            }

            if (C_MousideninKbn.TRKKZK2.eq(uiBean.getMousideninkbn()) ||
                C_MousideninKbn.HHKNHONNIN.eq(uiBean.getMousideninkbn())) {
                if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn()) ||
                    C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn())) {
                    throw new BizLogicException(MessageId.EIF1157, C_UktKbn.getContentByValue(
                        C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
                }
            }

            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkkbn2(C_TrkKzkKbn.TRKKZK2);
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkn2(uiBean.getTrkkzknmkn2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkj2(uiBean.getTrkkzknmkj2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkjkhukakbn2(uiBean.getTrkkzknmkjkhukakbn2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkseiymd2(uiBean.getTrkkzkseiymd2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzksei2(uiBean.getTrkkzksei2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktdk2(uiBean.getTrkkzktdk2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkyno2(uiBean.getTrkkzkyno2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr1kj2(uiBean.getTrkkzkadr1kj2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr2kj2(uiBean.getTrkkzkadr2kj2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr3kj2(uiBean.getTrkkzkadr3kj2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktelno2(uiBean.getTrkkzktelno2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn2(uiBean.getTrkkzktsindousiteikbn2());
        }

        if (C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn1())) {
            if (C_UmuKbn.ARI.eq(uiBean.getNewTrkkzkInfo1umukbn())) {
                throw new BizLogicException(MessageId.EIF1159,
                    MessageUtil.getMessage(DDID_TRKKZKINFO1_TRKKZKTTDKKBN1.getErrorResourceKey()));
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzkInfo1umukbn())) {

                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkkbn1(C_TrkKzkKbn.TRKKZK1);
            }
            else {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkkbn1(C_TrkKzkKbn.BLNK);
            }
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkn1(uiBean.getTrkkzknmkn1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkj1(uiBean.getTrkkzknmkj1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkjkhukakbn1(uiBean.getTrkkzknmkjkhukakbn1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkseiymd1(uiBean.getTrkkzkseiymd1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzksei1(uiBean.getTrkkzksei1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktdk1(uiBean.getTrkkzktdk1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkyno1(uiBean.getTrkkzkyno1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr1kj1(uiBean.getTrkkzkadr1kj1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr2kj1(uiBean.getTrkkzkadr2kj1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr3kj1(uiBean.getTrkkzkadr3kj1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktelno1(uiBean.getTrkkzktelno1());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn1(uiBean.getTrkkzktsindousiteikbn1());
        }

        if (C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn2())) {
            if (C_UmuKbn.ARI.eq(uiBean.getNewTrkkzkInfo2umukbn())) {
                throw new BizLogicException(MessageId.EIF1159,
                    MessageUtil.getMessage(DDID_TRKKZKINFO2_TRKKZKTTDKKBN2.getErrorResourceKey()));
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzkInfo2umukbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkkbn2(C_TrkKzkKbn.TRKKZK2);

            }
            else {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkkbn2(C_TrkKzkKbn.BLNK);
            }
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkn2(uiBean.getTrkkzknmkn2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkj2(uiBean.getTrkkzknmkj2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzknmkjkhukakbn2(uiBean.getTrkkzknmkjkhukakbn2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkseiymd2(uiBean.getTrkkzkseiymd2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzksei2(uiBean.getTrkkzksei2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktdk2(uiBean.getTrkkzktdk2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkyno2(uiBean.getTrkkzkyno2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr1kj2(uiBean.getTrkkzkadr1kj2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr2kj2(uiBean.getTrkkzkadr2kj2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzkadr3kj2(uiBean.getTrkkzkadr3kj2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktelno2(uiBean.getTrkkzktelno2());
            uiBean.getKhKzktrkKykdrHnkInfoUiBean().setTrkkzktsindousiteikbn2(uiBean.getTrkkzktsindousiteikbn2());
        }

        if (!C_TrkKzkKbn.BLNK.eq(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1()) ||
            !C_TrkKzkKbn.BLNK.eq(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2())) {
            if (uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkn1().equals(
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkn2()) &&
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1().equals(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2()) &&
                    BizDateUtil.compareYmd(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd1(),
                        uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd2()) == BizDateUtil.COMPARE_EQUAL) {
                throw new BizLogicException(MessageId.EIF1162);
            }
        }

        if (C_TeiseiKbn.BLNK.eq(uiBean.getTeiseikbn()) &&
            !C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn()) &&
            !C_MousideninKbn.KYKHONNIN.eq(uiBean.getMousideninkbn())) {
            throw new BizLogicException(MessageId.EIF1149);
        }

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);
        GetKhKykdrInfoBean getKhKykdrInfoBean = getKhKykdrInfo.exec(uiBean.getKykKihon());

        uiBean.setKhKykdrInfoBean(getKhKykdrInfoBean);

        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(uiBean.getKykdrtkykttdkkbn())) {
            if (C_UmuKbn.NONE.eq(syouhnZokusei.getKykdrtkykumu())) {
                throw new BizLogicException(MessageId.EIF1150);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getKykdrtkykhukaumu())) {
                throw new BizLogicException(MessageId.EIF1151);
            }

            checkKyksyadairininInfoInput();

            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewkykdrkbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrkbn(uiBean.getNewkykdrkbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(uiBean.getNewkykdrnmkn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(uiBean.getNewkykdrnmkj());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(uiBean.getNewkykdrnmkjkhukakbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(uiBean.getNewkykdrseiymd());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(uiBean.getNewkykdryno());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(uiBean.getNewkykdradr1kj());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(uiBean.getNewkykdradr2kj());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(uiBean.getNewkykdradr3kj());
            }
            else if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getNewkykdrkbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrkbn(uiBean.getNewkykdrkbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkn1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkjkhukakbn1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkyno1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr1kj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr2kj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr3kj1());
            }
            else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getNewkykdrkbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrkbn(uiBean.getNewkykdrkbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkn2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkjkhukakbn2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkyno2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr1kj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr2kj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr3kj2());
            }
        }
        else if (C_KykdrtkykttdkKbn.HENKOU.eq(uiBean.getKykdrtkykttdkkbn())) {
            if (C_UmuKbn.NONE.eq(uiBean.getKykdrtkykhukaumu())) {
                throw new BizLogicException(MessageId.EIF1152);
            }

            if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn()) &&
                C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getNewkykdrkbn()) &&
                C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn1())) {
                throw new BizLogicException(MessageId.EIA0044, C_UktsyuKbn.KYKDRN.getContent());
            }

            if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn()) &&
                C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getNewkykdrkbn()) &&
                C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn2())) {
                throw new BizLogicException(MessageId.EIA0044, C_UktsyuKbn.KYKDRN.getContent());
            }

            if (C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai()) &&
                !uiBean.getKykdrkbn().eq(uiBean.getNewkykdrkbn())) {
                throw new BizLogicException(MessageId.EIF1153);
            }

            checkKyksyadairininInfoInput();

            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewkykdrkbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrkbn(uiBean.getNewkykdrkbn());
                if (BizUtil.isBlank(uiBean.getNewkykdrnmkn())) {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(uiBean.getKhKykdrInfoBean().getKkdairinmKn());
                }
                else {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(uiBean.getNewkykdrnmkn());
                }

                if (BizUtil.isBlank(uiBean.getNewkykdrnmkj())) {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(uiBean.getKhKykdrInfoBean().getKkdairinmKj());
                }
                else {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(uiBean.getNewkykdrnmkj());
                }

                if (BizUtil.isBlank(uiBean.getNewkykdrnmkj()) && C_KjkhukaKbn.BLNK.eq(uiBean.getNewkykdrnmkjkhukakbn())) {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(
                        uiBean.getKhKykdrInfoBean().getKkdairinmKjkhukaKbn());
                }
                else {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(uiBean.getNewkykdrnmkjkhukakbn());
                }

                if (uiBean.getNewkykdrseiymd() == null) {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(uiBean.getKhKykdrInfoBean().getkykdrseiymd());
                }
                else {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(uiBean.getNewkykdrseiymd());
                }

                if (BizUtil.isBlank(uiBean.getNewkykdryno())) {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(uiBean.getKhKykdrInfoBean().getKykdryNo());
                }
                else {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(uiBean.getNewkykdryno());
                }

                if (!BizUtil.isBlank(uiBean.getNewkykdradr1kj())) {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(uiBean.getNewkykdradr1kj());
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(uiBean.getNewkykdradr2kj());
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(uiBean.getNewkykdradr3kj());
                }
                else {
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(uiBean.getKhKykdrInfoBean().getKykdradr1());
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(uiBean.getKhKykdrInfoBean().getKykdradr2());
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(uiBean.getKhKykdrInfoBean().getKykdradr3());
                }
            }
            else if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getNewkykdrkbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrkbn(uiBean.getNewkykdrkbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkn1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkjkhukakbn1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkyno1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr1kj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr2kj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr3kj1());
            }
            else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getNewkykdrkbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrkbn(uiBean.getNewkykdrkbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkn2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkjkhukakbn2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkyno2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr1kj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr2kj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr3kj2());
            }
        }
        else if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(uiBean.getKykdrtkykttdkkbn())) {
            if (C_UmuKbn.NONE.eq(uiBean.getKykdrtkykhukaumu())) {
                throw new BizLogicException(MessageId.EIF1152);
            }
            if (C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai())) {
                throw new BizLogicException(MessageId.EIF1154);
            }

            if (!C_UktKbn.BLNK.eq(uiBean.getNewkykdrkbn()) ||
                C_UmuKbn.ARI.eq(uiBean.getNewKyksyadairininumukbn())) {
                throw new BizLogicException(MessageId.EIF1163);
            }

            if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrkbn(uiBean.getNewkykdrkbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(uiBean.getTrkkzknmkn1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(uiBean.getTrkkzknmkj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(uiBean.getTrkkzknmkjkhukakbn1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(uiBean.getTrkkzkseiymd1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(uiBean.getTrkkzkyno1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(uiBean.getTrkkzkadr1kj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(uiBean.getTrkkzkadr2kj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(uiBean.getTrkkzkadr3kj1());
            }

            if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrkbn(uiBean.getNewkykdrkbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(uiBean.getTrkkzknmkn2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(uiBean.getTrkkzknmkj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(uiBean.getTrkkzknmkjkhukakbn2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(uiBean.getTrkkzkseiymd2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(uiBean.getTrkkzkyno2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(uiBean.getTrkkzkadr1kj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(uiBean.getTrkkzkadr2kj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(uiBean.getTrkkzkadr3kj2());
            }
        }
        else if (C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn())) {
            if (!C_UktKbn.BLNK.eq(uiBean.getNewkykdrkbn()) ||
                C_UmuKbn.ARI.eq(uiBean.getNewKyksyadairininumukbn())) {
                throw new BizLogicException(MessageId.EIF1159,
                    MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_KYKDRTKYKTTDKKBN.getErrorResourceKey()));
            }

            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getKykdrkbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrkbn(uiBean.getKykdrkbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(uiBean.getKykdairinmkn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(uiBean.getKykdairinmkj());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(uiBean.getKykdrnmkjkhukakbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(uiBean.getKykdrseiymd());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(uiBean.getKykdryno());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(uiBean.getKykdradr1kj());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(uiBean.getKykdradr2kj());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(uiBean.getKykdradr3kj());
            }
            else if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrkbn(uiBean.getKykdrkbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkn1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkjkhukakbn1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkyno1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr1kj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr2kj1());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr3kj1());
            }
            else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn())) {
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrkbn(uiBean.getKykdrkbn());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkn2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdairinmkj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrnmkjkhukakbn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkjkhukakbn2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdrseiymd(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdryno(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkyno2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr1kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr1kj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr2kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr2kj2());
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().setKykdradr3kj(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr3kj2());
            }
        }

        if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getNewkykdrkbn())) {
            if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo1umukbn()) &&
                C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn1())) {
                throw new BizLogicException(MessageId.EIF1155, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzkInfo1umukbn()) &&
                C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn1())) {
                throw new BizLogicException(MessageId.EIF1155, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
            }
        }

        if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getNewkykdrkbn())) {
            if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo2umukbn()) &&
                C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn2())) {
                throw new BizLogicException(MessageId.EIF1155, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzkInfo2umukbn()) &&
                C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn2())) {
                throw new BizLogicException(MessageId.EIF1155, C_UktKbn.getContentByValue(
                    C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
            }
        }
    }

    private void checkHonninkaknin() {
        if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_HONNINKAKUNININFO_HONNINKAKNINKEKKAKBN.getErrorResourceKey()));
        }

        if (C_TyhysakuseiyhKbn.BLNK.eq(uiBean.getTyhysakuseiyhkbn())) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_TYHYSAKUSEIYHKBNINFO_TYHYSAKUSEIYHKBN.getErrorResourceKey()));
        }

        if (C_TyhysakuseiyhKbn.YOU.eq(uiBean.getTyhysakuseiyhkbn())) {
            if (C_HassouKbn.BLNK.eq(uiBean.getHassoukbn())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_HASSOUKBNGROUP_HASSOUKBN.getErrorResourceKey()));
            }

            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewkykdrkbn())) {
                throw new BizLogicException(MessageId.EIF1161);
            }

            if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(uiBean.getKykdrtkykttdkkbn()) &&
                C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getKykdrkbn())) {
                throw new BizLogicException(MessageId.EIF1161);
            }
        }

        if (C_TyhysakuseiyhKbn.HUYOU.eq(uiBean.getTyhysakuseiyhkbn()) &&
            !C_HassouKbn.BLNK.eq(uiBean.getHassoukbn())) {
            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_HASSOUKBNGROUP_HASSOUKBN.getErrorResourceKey()));
        }

        if (C_KktyuitaKbn.DNGNMEMOARI.eq(uiBean.getVtdktkktyuitakbn()) &&
            C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {
            throw new BizLogicException(MessageId.EIA1007);
        }
    }

    private void checkHansyaSentakuInfo() {

        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);

        C_ErrorKbn kekkaKbn = setTyotikuseihokenhyouji.exec(uiBean.getKykKihon());

        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(uiBean.getKykdrtkykttdkkbn()) ||
            C_KykdrtkykttdkKbn.HENKOU.eq(uiBean.getKykdrtkykttdkkbn())) {
            CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);

            boolean waringFlg = checkHansyaSentakuInfo.exec(C_HnsychkTaisyousyaKbn.KYKDRN,
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkn(),
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj(),
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdrnmkjkhukakbn(),
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdrseiymd(),
                uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdryno(),
                kekkaKbn,
                setTyotikuseihokenhyouji.getHouteityotkhknhyj(),
                setTyotikuseihokenhyouji.getTyotkhknhyj());

            if (!waringFlg) {
                String waringMessage = BLANK;
                String waringMessageId = BLANK;
                for (int i = 0; i < checkHansyaSentakuInfo.getWarningMsgIdList().size(); i++) {
                    waringMessage = checkHansyaSentakuInfo.getWarningMsgList().get(i);
                    waringMessageId = BizUtil.getGeneralMessageId(checkHansyaSentakuInfo.getWarningMsgIdList().get(i));

                    messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, waringMessageId, waringMessage);
                }
            }
        }
        if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn()) &&
            C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn()) &&
            C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn1())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.WIF1046);
        }

        if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn()) &&
            C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn()) &&
            C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn2())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.WIF1046);
        }

        if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn()) &&
            C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn1())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.WIF1046);
        }

        if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn()) &&
            C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn2())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.WIF1046);
        }
    }

    private void checkKykymdIdou(KhozenCommonParam pKhozenCommonParam) {

        List<IT_KykSyouhn> keiyakuSyouhinLst = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        if (BizDateUtil.compareYmd(BizDate.getSysDate(),
            keiyakuSyouhinLst.get(0).getKykymd()) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EIA0070, SYORIBI);
        }
    }

    private void checkDairinHenkouWarning() {

        if (C_UmuKbn.ARI.eq(uiBean.getTrkkzk1AndKykmukbn()) &&
            C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn()) &&
            C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.WIF1043,
                C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
        }

        if (C_UmuKbn.ARI.eq(uiBean.getTrkkzk2AndKykmukbn()) &&
            C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn()) &&
            C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.WIF1043,
                C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
        }

        if (C_UmuKbn.ARI.eq(uiBean.getTrkkzk1AndKykmukbn()) &&
            C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.WIF1044,
                C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU1.getValue()));
        }

        if (C_UmuKbn.ARI.eq(uiBean.getTrkkzk2AndKykmukbn()) &&
            C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.WIF1044,
                C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT, C_UktKbn.TOUROKUKAZOKU2.getValue()));
        }
    }

    private void checkTakyk() {
        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(uiBean.getKykdrtkykttdkkbn())) {
            C_UmuKbn rayUmukbn = C_UmuKbn.NONE;
            if (uiBean.getKikeiyakuInfoDataSource().getAllData().size() > 0) {
                for (KikeiyakuInfoDataSourceBean dataSourceBean : uiBean.getKikeiyakuInfoDataSource().getAllData()) {
                    if (C_YuukousyoumetuKbn.YUUKOU.eq(dataSourceBean.getVbtkkdispbtkykyuuksumtkbn())) {
                        rayUmukbn = C_UmuKbn.ARI;

                        break;
                    }
                }
            }

            C_UmuKbn palUmukbn = C_UmuKbn.NONE;
            if (uiBean.getPalkikeiyakuInfoDataSource().getAllData().size() > 0) {
                for (PalkikeiyakuInfoDataSourceBean dataSourceBean : uiBean.getPalkikeiyakuInfoDataSource()
                    .getAllData()) {
                    if (dataSourceBean.getVbtkkdisppalbtkyksymtymd() != null) {
                        palUmukbn = C_UmuKbn.ARI;

                        break;
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(rayUmukbn) || C_UmuKbn.ARI.eq(palUmukbn)) {
                messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.WIF1045);
            }
        }
    }

    private void checkDairinHenkouInfo() {

        if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn1()) &&
            C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.IIF1027);
        }

        if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn2()) &&
            C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.IIF1027);
        }

        if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getVstsksiteidruktkbn()) &&
            C_UmuKbn.ARI.eq(uiBean.getTrkkzk1AndHihokensyamukbn())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.IIF1028,
                C_UktKbn.getContentByValue(C_UktKbn.PATTERN_KHKYKDR, C_UktKbn.TOUROKUKAZOKU1.getValue()));
        }

        if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getVstsksiteidruktkbn()) &&
            C_UmuKbn.ARI.eq(uiBean.getTrkkzk2AndHihokensyamukbn())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.IIF1028,
                C_UktKbn.getContentByValue(C_UktKbn.PATTERN_KHKYKDR, C_UktKbn.TOUROKUKAZOKU2.getValue()));
        }

        if (!C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn()) &&
            C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewkykdrkbn())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.IIA1002);
        }

        if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(uiBean.getKykdrtkykttdkkbn()) &&
            C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getKykdrkbn())) {
            messageManager.addConversationMessageId(GROUP_SYOUKAI_WARNING, MessageId.IIA1002);
        }
    }

    private void checkTrkkzkInfo1Input() {

        if (BizUtil.isBlank(uiBean.getNewtrkkzknmkn1())) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKNMKN1.getErrorResourceKey()));
        }

        if (BizUtil.isBlank(uiBean.getNewtrkkzknmkj1())) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKNMKJ1.getErrorResourceKey()));
        }

        if (uiBean.getNewtrkkzkseiymd1() == null) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKSEIYMD1.getErrorResourceKey()));
        }

        if (C_Seibetu.BLNK.eq(uiBean.getNewtrkkzksei1())) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKSEI1.getErrorResourceKey()));
        }

        if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn1())) {
            if (BizUtil.isBlank(uiBean.getNewtrkkzkyno1())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKYNO1.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj1())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKADR1KJ1.getErrorResourceKey()));
            }
        }
        else {
            if (!BizUtil.isBlank(uiBean.getNewtrkkzkyno1())) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKYNO1.getErrorResourceKey()));
            }

            if (!BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj1()) ||
                !BizUtil.isBlank(uiBean.getNewtrkkzkadr2kj1()) ||
                !BizUtil.isBlank(uiBean.getNewtrkkzkadr3kj1())) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKADR1KJ1.getErrorResourceKey()));
            }
        }

        if (C_Tdk.BLNK.eq(uiBean.getNewtrkkzktdk1())) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_TRKKZKINFO1_NEWTRKKZKTDK1.getErrorResourceKey()));
        }
    }

    private void checkTrkkzkInfo2Input() {
        if (BizUtil.isBlank(uiBean.getNewtrkkzknmkn2())) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKNMKN2.getErrorResourceKey()));
        }

        if (BizUtil.isBlank(uiBean.getNewtrkkzknmkj2())) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKNMKJ2.getErrorResourceKey()));
        }

        if (uiBean.getNewtrkkzkseiymd2() == null) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKSEIYMD2.getErrorResourceKey()));
        }

        if (C_Seibetu.BLNK.eq(uiBean.getNewtrkkzksei2())) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKSEI2.getErrorResourceKey()));
        }

        if (C_TsindousiteiKbn.BLNK.eq(uiBean.getNewtrkkzktsindousiteikbn2())) {
            if (BizUtil.isBlank(uiBean.getNewtrkkzkyno2())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKYNO2.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj2())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKADR1KJ2.getErrorResourceKey()));
            }
        }
        else {
            if (!BizUtil.isBlank(uiBean.getNewtrkkzkyno2())) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKYNO2.getErrorResourceKey()));
            }

            if (!BizUtil.isBlank(uiBean.getNewtrkkzkadr1kj2()) ||
                !BizUtil.isBlank(uiBean.getNewtrkkzkadr2kj2()) ||
                !BizUtil.isBlank(uiBean.getNewtrkkzkadr3kj2())) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKADR1KJ2.getErrorResourceKey()));
            }
        }

        if (C_Tdk.BLNK.eq(uiBean.getNewtrkkzktdk2())) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_TRKKZKINFO2_NEWTRKKZKTDK2.getErrorResourceKey()));
        }
    }

    private void checkKyksyadairininInfoInput() {

        if (C_UktKbn.BLNK.eq(uiBean.getNewkykdrkbn())) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRKBN.getErrorResourceKey()));
        }
        else if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewkykdrkbn())) {
            if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(uiBean.getKykdrtkykttdkkbn())) {
                if (BizUtil.isBlank(uiBean.getNewkykdrnmkn())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRNMKN.getErrorResourceKey()));
                }

                if (BizUtil.isBlank(uiBean.getNewkykdrnmkj())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRNMKJ.getErrorResourceKey()));
                }

                if (uiBean.getNewkykdrseiymd() == null) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRSEIYMD.getErrorResourceKey()));
                }

                if (BizUtil.isBlank(uiBean.getNewkykdryno())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRYNO.getErrorResourceKey()));
                }

                if (BizUtil.isBlank(uiBean.getNewkykdradr1kj())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRADR1KJ.getErrorResourceKey()));
                }
            }
            else if (C_KykdrtkykttdkKbn.HENKOU.eq(uiBean.getKykdrtkykttdkkbn())) {
                if (BizUtil.isBlank(uiBean.getKykdairinmkn()) && BizUtil.isBlank(uiBean.getNewkykdrnmkn())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRNMKN.getErrorResourceKey()));
                }

                if (BizUtil.isBlank(uiBean.getKykdairinmkj()) && BizUtil.isBlank(uiBean.getNewkykdrnmkj())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRNMKJ.getErrorResourceKey()));
                }

                if (uiBean.getKykdrseiymd() == null && uiBean.getNewkykdrseiymd() == null) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRSEIYMD.getErrorResourceKey()));
                }

                if (BizUtil.isBlank(uiBean.getKykdryno()) && BizUtil.isBlank(uiBean.getNewkykdryno())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRYNO.getErrorResourceKey()));
                }

                if (BizUtil.isBlank(uiBean.getKykdradr1kj()) && BizUtil.isBlank(uiBean.getNewkykdradr1kj())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRADR1KJ.getErrorResourceKey()));
                }

                if (BizUtil.isBlank(uiBean.getNewkykdradr1kj()) &&
                    (!BizUtil.isBlank(uiBean.getNewkykdradr2kj()) ||
                        !BizUtil.isBlank(uiBean.getNewkykdradr3kj()))) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYADAIRITKINFO_NEWKYKDRADR1KJ.getErrorResourceKey()));
                }

                if (C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai()) &&
                    !uiBean.getNewkykdrnmkn().equals(uiBean.getKhKykdrInfoBean().getKkdairinmKn()) &&
                    !uiBean.getNewkykdrnmkj().equals(uiBean.getKhKykdrInfoBean().getKkdairinmKj()) &&
                    BizDateUtil.compareYmd(
                        uiBean.getNewkykdrseiymd(), uiBean.getKhKykdrInfoBean().getkykdrseiymd()) != BizDateUtil.COMPARE_EQUAL) {
                    throw new BizLogicException(MessageId.EIF1153);
                }
            }
        }
        else {
            if (C_UmuKbn.ARI.eq(uiBean.getNewKyksyadairininumukbn())) {
                throw new BizLogicException(MessageId.EIF1164);
            }
        }
    }

    private void doTableUpdate(KhozenCommonParam pKhozenCommonParam, String pFunctionId, String pUserId,
        String pSysTime, BizDate pSysDate) {

        String sikibetuKey = pKhozenCommonParam.getSikibetuKey(uiBean.getSyono());

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetuKey);

        IT_KykKihon kykKihon = uiBean.getKykKihon();
        kykKihon.setSyhenkouymd(pSysDate);
        kykKihon.setLastmeihenymd(pSysDate);
        kykKihon.setGyoumuKousinKinou(pFunctionId);
        kykKihon.setGyoumuKousinsyaId(pUserId);
        kykKihon.setGyoumuKousinTime(pSysTime);

        if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn1()) ||
            C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn1())) {
            updateTrkKzk1(pSysDate, pFunctionId, pUserId, pSysTime);

            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getVstsksiteidruktkbn()) &&
                C_UmuKbn.ARI.eq(uiBean.getTrkkzk1AndHihokensyamukbn())) {
                updateKykUkt_stdrsk(C_UktKbn.TOUROKUKAZOKU1, pFunctionId, pUserId, pSysTime);
            }
        }

        if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn2()) ||
            C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn2())) {
            updateTrkKzk2(pSysDate, pFunctionId, pUserId, pSysTime);

            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getVstsksiteidruktkbn()) &&
                C_UmuKbn.ARI.eq(uiBean.getTrkkzk2AndHihokensyamukbn())) {
                updateKykUkt_stdrsk(C_UktKbn.TOUROKUKAZOKU2, pFunctionId, pUserId, pSysTime);
            }
        }

        if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn1())) {
            deleteTrkKzk(C_TrkKzkKbn.TRKKZK1, pFunctionId, pUserId, pSysTime);
        }

        if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn2())) {
            deleteTrkKzk(C_TrkKzkKbn.TRKKZK2, pFunctionId, pUserId, pSysTime);
        }

        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(uiBean.getKykdrtkykttdkkbn())) {
            updateKykSonotaTkyk(pSysDate, pFunctionId, pUserId, pSysTime);

            updateKykUkt_kykdrn(pFunctionId, pUserId, pSysTime);
        }
        else if (C_KykdrtkykttdkKbn.HENKOU.eq(uiBean.getKykdrtkykttdkkbn())) {
            updateKykUkt_kykdrn(pFunctionId, pUserId, pSysTime);
        }
        else if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(uiBean.getKykdrtkykttdkkbn())) {
            updateKykSonotaTkyk(pSysDate, pFunctionId, pUserId, pSysTime);
            deleteKykUkt();
        }

        IT_KhTtdkRireki khTtdkRireki = uiBean.getKykKihon().createKhTtdkRireki();
        khTtdkRireki.setHenkousikibetukey(sikibetuKey);

        makeTetudukiRireki(pKhozenCommonParam, pSysTime, pSysDate);

        hozenDomManager.update(uiBean.getKykKihon());
    }

    public void ctiOpenBL() {
        BizPropertyInitializer.initialize(uiBean);
        uiBean.setVkihnsyono(ctiParamBean.getSyono());
    }

    private void makeTyouhyou(KhozenCommonParam pKhozenCommonParam,BizDate pSysDate) {

        EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);
        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        C_TrkKzkHnkKbn trkKzkHnkKbn1 = C_TrkKzkHnkKbn.BLNK;
        C_TrkKzkHnkKbn trkKzkHnkKbn2 = C_TrkKzkHnkKbn.BLNK;
        String kykdairinmkj = BLANK;
        String sakujyoTrkKzknm1 = BLANK;
        String sakujyoTrkKzknm2 = BLANK;
        String stdrskNmKj = BLANK;

        if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn1())) {
            trkKzkHnkKbn1 = C_TrkKzkHnkKbn.TOUROKU;
        }
        else if (C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn1())) {
            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzk1AndKykmukbn())) {
                trkKzkHnkKbn1 = C_TrkKzkHnkKbn.TOUROKU;
            }
            else {
                trkKzkHnkKbn1 = C_TrkKzkHnkKbn.HENKOU;
            }
        }
        else if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn1())) {
            trkKzkHnkKbn1 = C_TrkKzkHnkKbn.SAKUJYO;
        }

        if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn2())) {
            trkKzkHnkKbn2 = C_TrkKzkHnkKbn.TOUROKU;
        }
        else if (C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn2())) {
            if (C_UmuKbn.ARI.eq(uiBean.getTrkkzk2AndKykmukbn())) {
                trkKzkHnkKbn2 = C_TrkKzkHnkKbn.TOUROKU;
            }
            else {
                trkKzkHnkKbn2 = C_TrkKzkHnkKbn.HENKOU;
            }
        }
        else if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn2())) {
            trkKzkHnkKbn2 = C_TrkKzkHnkKbn.SAKUJYO;
        }

        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(uiBean.getKykdrtkykttdkkbn())) {
            if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getNewkykdrkbn())) {
                kykdairinmkj = uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1();
            }
            else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getNewkykdrkbn())) {
                kykdairinmkj = uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2();
            }
        }
        else if (C_KykdrtkykttdkKbn.HENKOU.eq(uiBean.getKykdrtkykttdkkbn())) {
            if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getNewkykdrkbn())) {
                if (!uiBean.getKhKykdrInfoBean().getKkdairinmKj().equals(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj())) {
                    kykdairinmkj = uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj();
                }
            }
            else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getNewkykdrkbn())) {
                if (!uiBean.getKhKykdrInfoBean().getKkdairinmKj().equals(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj())) {
                    kykdairinmkj = uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj();
                }
            }
        }
        else if (C_KykdrtkykttdkKbn.BLNK.eq(uiBean.getKykdrtkykttdkkbn())) {
            if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn())) {
                if (!uiBean.getKhKykdrInfoBean().getKkdairinmKj().equals(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj())) {
                    kykdairinmkj = uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj();
                }
            }
            else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn())) {
                if (!uiBean.getKhKykdrInfoBean().getKkdairinmKj().equals(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj())) {
                    kykdairinmkj = uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj();
                }
            }
        }

        if (C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn1())) {
            if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn())) {
                if (!uiBean.getTrkkzknmkj1().equals(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1())) {
                    stdrskNmKj = uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1();
                }
            }
        }

        if (C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn2())) {

            if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn())) {
                if (!uiBean.getTrkkzknmkj2().equals(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2())) {
                    stdrskNmKj = uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2();
                }
            }
        }

        C_UmuKbn trkkzkInfo1umukbn = C_UmuKbn.ARI;
        C_UmuKbn trkkzkInfo2umukbn = C_UmuKbn.ARI;
        C_KzkTrkServicettdkKbn kzkTrkServicettdkKbn = C_KzkTrkServicettdkKbn.BLNK;


        if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo1umukbn()) &&
            C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn1())) {
            trkkzkInfo1umukbn = C_UmuKbn.NONE;
        }

        if (C_UmuKbn.NONE.eq(uiBean.getTrkkzkInfo2umukbn()) &&
            C_TrkkzkttdkKbn.BLNK.eq(uiBean.getTrkkzkttdkkbn2())) {
            trkkzkInfo2umukbn = C_UmuKbn.NONE;
        }

        if (uiBean.getTrkkzkttdkkbn1().eq(uiBean.getTrkkzkttdkkbn2())) {
            kzkTrkServicettdkKbn = setKzkTrkServicettdkKbn(uiBean.getTrkkzkttdkkbn1());
        }
        else {
            if (trkkzkInfo2umukbn.eq(trkkzkInfo1umukbn)) {
                kzkTrkServicettdkKbn = C_KzkTrkServicettdkKbn.HENKOU;
            }
            else {
                if (C_UmuKbn.ARI.eq(trkkzkInfo1umukbn)) {
                    kzkTrkServicettdkKbn = setKzkTrkServicettdkKbn(uiBean.getTrkkzkttdkkbn1());
                }
                else if (C_UmuKbn.ARI.eq(trkkzkInfo2umukbn)) {
                    kzkTrkServicettdkKbn = setKzkTrkServicettdkKbn(uiBean.getTrkkzkttdkkbn2());
                }
            }
        }

        if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn1())) {
            sakujyoTrkKzknm1 = uiBean.getTrkkzknmkj1();
        }
        if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn2())) {
            sakujyoTrkKzknm2 = uiBean.getTrkkzknmkj2();
        }

        List<TyokusouTaisyouBean> tyokusouTaisyouLst = Lists.newArrayList();
        List<DouhuuTaisyouBean> douhuuTaisyouLst = Lists.newArrayList();
        boolean tyokusouhanteizimiFlg1 = false;
        boolean tyokusouhanteizimiFlg2 = false;
        boolean trkhnktyokusouhanteizimiFlg1 = false;
        boolean trkhnktyokusouhanteizimiFlg2 = false;

        if (C_MousideninKbn.HHKNHONNIN.eq(uiBean.getMousideninkbn())) {
            DouhuuTaisyouBean douhuuTaisyouBean = SWAKInjector.getInstance(DouhuuTaisyouBean.class);

            douhuuTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.HHKN);
            douhuuTaisyouBean.setTrkKzkKbn(C_TrkKzkKbn.BLNK);
            douhuuTaisyouBean.setNmkj(uiBean.getVhhkshhknnmkj());

            douhuuTaisyouLst.add(douhuuTaisyouBean);
        }
        else {

            KhTyokusouHantei khTyokusouHantei = SWAKInjector.getInstance(KhTyokusouHantei.class);
            C_TyokusouhtkekKbn tyokusouhtkekKbn = C_TyokusouhtkekKbn.BLNK;
            TrkkzkTyokusouhtBean trkkzkTyokusouhtBean = null;
            TyokusouTaisyouBean tyokusouTaisyouBean = null;
            DouhuuTaisyouBean douhuuTaisyouBean = null;

            if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn1())) {
                trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);
                trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn1());

                tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                    tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                    tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);

                    setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1(), tyokusouTaisyouBean);

                    tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                }

                if (C_KzkTrkServicettdkKbn.HENKOU.eq(kzkTrkServicettdkKbn)) {

                    trkhnktyokusouhanteizimiFlg1 = true;
                }
            }
            else if (C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn1())) {
                if (C_TrkKzkHnkKbn.HENKOU.eq(trkKzkHnkKbn1)) {
                    if (C_MousideninKbn.TRKKZK1.eq(uiBean.getMousideninkbn())) {
                        tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);

                        setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1(), tyokusouTaisyouBean);

                        tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                    }
                }
                else if (C_TrkKzkHnkKbn.TOUROKU.eq(trkKzkHnkKbn1)) {
                    trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                    trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                    trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                    trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                        uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn1());

                    tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                    if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                        tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);

                        setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1(), tyokusouTaisyouBean);

                        tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                    }

                    trkhnktyokusouhanteizimiFlg1 = true;
                }
            }
            else if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn1())) {
                if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(kzkTrkServicettdkKbn)) {
                    trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                    trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                    trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                    trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                        uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn1());

                    tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                    if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                        tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK1);

                        setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1(), tyokusouTaisyouBean);

                        tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                    }
                    else {
                        douhuuTaisyouBean = SWAKInjector.getInstance(DouhuuTaisyouBean.class);

                        douhuuTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK1);
                        douhuuTaisyouBean.setTrkKzkKbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1());
                        douhuuTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1());

                        douhuuTaisyouLst.add(douhuuTaisyouBean);
                    }

                    tyokusouhanteizimiFlg1 = true;
                }
                else if (C_KzkTrkServicettdkKbn.HENKOU.eq(kzkTrkServicettdkKbn)) {
                    if (C_MousideninKbn.TRKKZK1.eq(uiBean.getMousideninkbn())) {
                        trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                        trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                        trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                            uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn1());

                        tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                        if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                            tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                            tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK1);

                            setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1(),
                                tyokusouTaisyouBean);

                            tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                        }
                        else {
                            douhuuTaisyouBean = SWAKInjector.getInstance(DouhuuTaisyouBean.class);

                            douhuuTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK1);
                            douhuuTaisyouBean.setTrkKzkKbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1());
                            douhuuTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1());

                            douhuuTaisyouLst.add(douhuuTaisyouBean);
                        }
                    }

                    if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn()) &&
                        C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn()) &&
                        C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(uiBean.getKykdrtkykttdkkbn())) {
                        trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                        trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                        trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                            uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn1());

                        tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                        if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                            tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                            tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);

                            setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1(),
                                tyokusouTaisyouBean);

                            tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                        }
                        else {
                            douhuuTaisyouBean = SWAKInjector.getInstance(DouhuuTaisyouBean.class);

                            douhuuTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);
                            douhuuTaisyouBean.setTrkKzkKbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1());
                            douhuuTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1());

                            douhuuTaisyouLst.add(douhuuTaisyouBean);
                        }

                        tyokusouhanteizimiFlg1 = true;
                    }
                    else if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn())) {
                        trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                        trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                        trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                            uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn1());

                        tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                        if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                            tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                            tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDHHKNDRNIN);

                            setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1(),
                                tyokusouTaisyouBean);

                            tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                        }
                    }
                }
            }

            if (C_TrkkzkttdkKbn.TOUROKU.eq(uiBean.getTrkkzkttdkkbn2())) {
                trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                    uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn2());

                tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                    tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                    tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);

                    setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2(), tyokusouTaisyouBean);

                    tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                }

                if (C_KzkTrkServicettdkKbn.HENKOU.eq(kzkTrkServicettdkKbn)) {

                    trkhnktyokusouhanteizimiFlg2 = true;
                }
            }
            else if (C_TrkkzkttdkKbn.HENKOU.eq(uiBean.getTrkkzkttdkkbn2())) {
                if (C_TrkKzkHnkKbn.HENKOU.eq(trkKzkHnkKbn2)) {
                    if (C_MousideninKbn.TRKKZK2.eq(uiBean.getMousideninkbn())) {
                        tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);

                        setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2(), tyokusouTaisyouBean);

                        tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                    }
                }
                else if (C_TrkKzkHnkKbn.TOUROKU.eq(trkKzkHnkKbn2)) {
                    trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                    trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                    trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                    trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                        uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn2());

                    tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                    if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                        tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);

                        setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2(), tyokusouTaisyouBean);

                        tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                    }
                    trkhnktyokusouhanteizimiFlg2 = true;
                }
            }
            else if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn2())) {
                if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(kzkTrkServicettdkKbn)) {
                    trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                    trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                    trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                    trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                        uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn2());

                    tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                    if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                        tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK2);

                        setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2(), tyokusouTaisyouBean);

                        tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                    }
                    else {
                        douhuuTaisyouBean = SWAKInjector.getInstance(DouhuuTaisyouBean.class);

                        douhuuTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK2);
                        douhuuTaisyouBean.setTrkKzkKbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2());
                        douhuuTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2());

                        douhuuTaisyouLst.add(douhuuTaisyouBean);

                    }

                    tyokusouhanteizimiFlg2 = true;
                }
                else if (C_KzkTrkServicettdkKbn.HENKOU.eq(kzkTrkServicettdkKbn)) {
                    if (C_MousideninKbn.TRKKZK2.eq(uiBean.getMousideninkbn())) {
                        trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                        trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                        trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                            uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn2());

                        tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                        if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                            tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                            tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK2);

                            setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2(),
                                tyokusouTaisyouBean);

                            tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                        }
                        else {
                            douhuuTaisyouBean = SWAKInjector.getInstance(DouhuuTaisyouBean.class);

                            douhuuTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK2);
                            douhuuTaisyouBean.setTrkKzkKbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2());
                            douhuuTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2());

                            douhuuTaisyouLst.add(douhuuTaisyouBean);
                        }
                    }

                    if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn()) &&
                        C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn()) &&
                        C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(uiBean.getKykdrtkykttdkkbn())) {
                        trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                        trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                        trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                            uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn2());

                        tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                        if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                            tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                            tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);

                            setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2(),
                                tyokusouTaisyouBean);

                            tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                        }
                        else {
                            douhuuTaisyouBean = SWAKInjector.getInstance(DouhuuTaisyouBean.class);

                            douhuuTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);
                            douhuuTaisyouBean.setTrkKzkKbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2());
                            douhuuTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2());

                            douhuuTaisyouLst.add(douhuuTaisyouBean);
                        }

                        tyokusouhanteizimiFlg2 = true;
                    }
                    else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn())) {
                        trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                        trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                        trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                            uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn2());

                        tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                        if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                            tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                            tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDHHKNDRNIN);

                            setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2(),
                                tyokusouTaisyouBean);

                            tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                        }
                    }
                }
            }

            if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(uiBean.getKykdrtkykttdkkbn())) {
                if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn()) && !tyokusouhanteizimiFlg1) {
                    trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                    trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                    trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                    trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(uiBean.getTrkkzktsindousiteikbn1());

                    tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                    if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                        tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);

                        if (C_TrkKzkHnkKbn.TOUROKU.eq(trkKzkHnkKbn1)) {

                            tyokusouTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj());
                            tyokusouTaisyouBean.setSeiYmd(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdrseiymd());
                            tyokusouTaisyouBean.setYno(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdryno());
                            tyokusouTaisyouBean.setAdr1kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdradr1kj());
                            tyokusouTaisyouBean.setAdr2kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdradr2kj());
                            tyokusouTaisyouBean.setAdr3kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdradr3kj());
                            tyokusouTaisyouBean.setTelno(uiBean.getTrkkzktelno1());
                        }
                        else {
                            setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1(), tyokusouTaisyouBean);
                        }

                        tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                    }
                    else {
                        douhuuTaisyouBean = SWAKInjector.getInstance(DouhuuTaisyouBean.class);

                        douhuuTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);
                        douhuuTaisyouBean.setTrkKzkKbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1());

                        if (C_TrkKzkHnkKbn.TOUROKU.eq(trkKzkHnkKbn1)) {

                            douhuuTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj());
                        }
                        else {
                            douhuuTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1());
                        }

                        douhuuTaisyouLst.add(douhuuTaisyouBean);
                    }
                }

                if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn()) && !tyokusouhanteizimiFlg2) {
                    trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                    trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                    trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                    trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(uiBean.getTrkkzktsindousiteikbn2());

                    tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                    if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                        tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);

                        if (C_TrkKzkHnkKbn.TOUROKU.eq(trkKzkHnkKbn2)) {

                            tyokusouTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj());
                            tyokusouTaisyouBean.setSeiYmd(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdrseiymd());
                            tyokusouTaisyouBean.setYno(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdryno());
                            tyokusouTaisyouBean.setAdr1kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdradr1kj());
                            tyokusouTaisyouBean.setAdr2kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdradr2kj());
                            tyokusouTaisyouBean.setAdr3kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdradr3kj());
                            tyokusouTaisyouBean.setTelno(uiBean.getTrkkzktelno2());
                        }
                        else {

                            setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2(), tyokusouTaisyouBean);
                        }

                        tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                    }
                    else {
                        douhuuTaisyouBean = SWAKInjector.getInstance(DouhuuTaisyouBean.class);

                        douhuuTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);
                        douhuuTaisyouBean.setTrkKzkKbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2());
                        if (C_TrkKzkHnkKbn.TOUROKU.eq(trkKzkHnkKbn2)) {

                            douhuuTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj());
                        }
                        else {
                            douhuuTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2());
                        }

                        douhuuTaisyouLst.add(douhuuTaisyouBean);
                    }
                }
            }

            if (C_KzkTrkServicettdkKbn.BLNK.eq(kzkTrkServicettdkKbn) ||
                C_KzkTrkServicettdkKbn.HENKOU.eq(kzkTrkServicettdkKbn)) {
                if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(uiBean.getKykdrtkykttdkkbn()) ||
                    C_KykdrtkykttdkKbn.HENKOU.eq(uiBean.getKykdrtkykttdkkbn())) {
                    if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getNewkykdrkbn()) &&
                        !trkhnktyokusouhanteizimiFlg1) {
                        trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                        trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                        trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                            uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn1());

                        tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                        if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                            tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                            tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);

                            setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1(),
                                tyokusouTaisyouBean);

                            tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                        }
                    }
                    else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getNewkykdrkbn()) &&
                        !trkhnktyokusouhanteizimiFlg2) {
                        trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);

                        trkkzkTyokusouhtBean.setKijyunymd(pSysDate);
                        trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(
                            uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn2());

                        tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                        if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                            tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

                            tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);

                            setTyokusouTaisyou(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2(),
                                tyokusouTaisyouBean);

                            tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                        }
                    }
                }
            }
        }

        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(pSysDate);
        editTtdkKanryouParam.setMousideninKbn(uiBean.getMousideninkbn());
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(trkKzkHnkKbn1);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(trkKzkHnkKbn2);
        editTtdkKanryouParam.setKykdairinmkj(kykdairinmkj);
        editTtdkKanryouParam.setSakujyoTrkKzknm1(sakujyoTrkKzknm1);
        editTtdkKanryouParam.setSakujyoTrkKzknm2(sakujyoTrkKzknm2);
        editTtdkKanryouParam.setStdrsknmkj(stdrskNmKj);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(kzkTrkServicettdkKbn);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(uiBean.getKykdrtkykttdkkbn());
        editTtdkKanryouParam.setStdruktkbn(uiBean.getVstsksiteidruktkbn());
        editTtdkKanryouParam.setBfrKykdairinKbn(uiBean.getKykdrkbn());
        editTtdkKanryouParam.setAftKykdairinKbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdrkbn());
        editTtdkKanryouParam.setTrkkzkttdkKbn1(uiBean.getTrkkzkttdkkbn1());
        editTtdkKanryouParam.setTrkkzkttdkKbn2(uiBean.getTrkkzkttdkkbn2());
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouLst);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouLst);

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
        khozenTyouhyouCtl.setHassoukbn(uiBean.getHassoukbn());

        List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<C_SyoruiCdKbn>();

        if (tyokusouTaisyouLst.size() > 0) {

            syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);
            syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        }
        else {
            syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);
        }

        C_SyoruiCdKbn[] syoruiCds = syoruiCdKbnLst.toArray(new C_SyoruiCdKbn[0]);

        khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam, uiBean.getSyono(), syoruiCds, C_YouhiKbn.HUYOU);
    }

    private C_KzkTrkServicettdkKbn setKzkTrkServicettdkKbn (C_TrkkzkttdkKbn pTrkkzkttdkKbn) {

        C_KzkTrkServicettdkKbn kzkTrkServicettdkKbn = C_KzkTrkServicettdkKbn.BLNK;

        if (C_TrkkzkttdkKbn.BLNK.eq(pTrkkzkttdkKbn)) {
            kzkTrkServicettdkKbn = C_KzkTrkServicettdkKbn.BLNK;
        }
        else if (C_TrkkzkttdkKbn.TOUROKU.eq(pTrkkzkttdkKbn)) {
            kzkTrkServicettdkKbn = C_KzkTrkServicettdkKbn.TOUROKU;
        }
        else if (C_TrkkzkttdkKbn.HENKOU.eq(pTrkkzkttdkKbn)) {
            kzkTrkServicettdkKbn = C_KzkTrkServicettdkKbn.HENKOU;
        }
        else if (C_TrkkzkttdkKbn.SAKUJYO.eq(pTrkkzkttdkKbn)) {
            kzkTrkServicettdkKbn = C_KzkTrkServicettdkKbn.SYUURYOU;
        }

        return kzkTrkServicettdkKbn;
    }

    private void updateTrkKzk1(BizDate pSysDate, String pKinouId, String pUserId, String pSysTime) {

        IT_TrkKzk trkKzk = null;
        boolean tableInit = false;

        trkKzk = uiBean.getKykKihon().getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);

        if (trkKzk == null) {
            trkKzk = uiBean.getKykKihon().createTrkKzk();
            tableInit = true;
        }

        trkKzk.setTrkkzkkbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn1());
        trkKzk.setTrkkzksetteiymd(pSysDate);
        trkKzk.setTrkkzknmkn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkn1());
        trkKzk.setTrkkzknmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1());
        trkKzk.setTrkkzknmkjkhukakbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkjkhukakbn1());
        trkKzk.setTrkkzkseiymd(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd1());
        trkKzk.setTrkkzksei(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzksei1());
        trkKzk.setTrkkzktdk(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktdk1());
        trkKzk.setTrkkzkyno(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkyno1());
        trkKzk.setTrkkzkadr1kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr1kj1());
        trkKzk.setTrkkzkadr2kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr2kj1());
        trkKzk.setTrkkzkadr3kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr3kj1());
        trkKzk.setTrkkzktelno(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktelno1());
        trkKzk.setGyoumuKousinKinou(pKinouId);
        trkKzk.setGyoumuKousinsyaId(pUserId);
        trkKzk.setGyoumuKousinTime(pSysTime);
        trkKzk.setTrkkzktsindousiteikbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn1());

        if (tableInit) {
            BizPropertyInitializer.initialize(trkKzk);
        }
    }

    private void updateTrkKzk2(BizDate pSysDate, String pKinouId, String pUserId, String pSysTime) {

        IT_TrkKzk trkKzk = null;
        boolean tableInit = false;

        trkKzk = uiBean.getKykKihon().getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);

        if (trkKzk == null) {
            trkKzk = uiBean.getKykKihon().createTrkKzk();
            tableInit = true;
        }

        trkKzk.setTrkkzkkbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkkbn2());
        trkKzk.setTrkkzksetteiymd(pSysDate);
        trkKzk.setTrkkzknmkn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkn2());
        trkKzk.setTrkkzknmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2());
        trkKzk.setTrkkzknmkjkhukakbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkjkhukakbn2());
        trkKzk.setTrkkzkseiymd(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd2());
        trkKzk.setTrkkzksei(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzksei2());
        trkKzk.setTrkkzktdk(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktdk2());
        trkKzk.setTrkkzkyno(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkyno2());
        trkKzk.setTrkkzkadr1kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr1kj2());
        trkKzk.setTrkkzkadr2kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr2kj2());
        trkKzk.setTrkkzkadr3kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr3kj2());
        trkKzk.setTrkkzktelno(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktelno2());
        trkKzk.setGyoumuKousinKinou(pKinouId);
        trkKzk.setGyoumuKousinsyaId(pUserId);
        trkKzk.setGyoumuKousinTime(pSysTime);
        trkKzk.setTrkkzktsindousiteikbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktsindousiteikbn2());

        if (tableInit) {
            BizPropertyInitializer.initialize(trkKzk);
        }
    }

    private void updateKykUkt_stdrsk(C_UktKbn pUktKbn, String pKinouId, String pUserId, String pSysTime) {
        IT_KykUkt kykUkt = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        kykUkt.setUktkbn(pUktKbn);
        kykUkt.setUktnmkn(BLANK);
        kykUkt.setUktnmkj(BLANK);
        kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        kykUkt.setUktseiymd(null);
        kykUkt.setUkttdk(C_Tdk.BLNK);
        kykUkt.setGyoumuKousinKinou(pKinouId);
        kykUkt.setGyoumuKousinsyaId(pUserId);
        kykUkt.setGyoumuKousinTime(pSysTime);
        kykUkt.setUktyno(BLANK);
        kykUkt.setUktadr1kj(BLANK);
        kykUkt.setUktadr2kj(BLANK);
        kykUkt.setUktadr3kj(BLANK);
    }

    private void deleteTrkKzk(C_TrkKzkKbn pTrkKzkKbn, String pKinouId, String pUserId, String pSysTime) {

        List<IT_TrkKzk> trkKzkLst = uiBean.getKykKihon().getTrkKzks();

        IT_TrkKzk trkKzk = uiBean.getKykKihon().getTrkKzkByTrkKzkKbn(pTrkKzkKbn);
        trkKzkLst.remove(trkKzk);

        if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn1()) &&
            C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn())) {
            IT_KykUkt kykUkt = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

            kykUkt.setUktkbn(C_UktKbn.NASI);
            kykUkt.setGyoumuKousinKinou(pKinouId);
            kykUkt.setGyoumuKousinsyaId(pUserId);
            kykUkt.setGyoumuKousinTime(pSysTime);
        }

        if (C_TrkkzkttdkKbn.SAKUJYO.eq(uiBean.getTrkkzkttdkkbn2()) &&
            C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn())) {
            IT_KykUkt kykUkt = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

            kykUkt.setUktkbn(C_UktKbn.NASI);
            kykUkt.setGyoumuKousinKinou(pKinouId);
            kykUkt.setGyoumuKousinsyaId(pUserId);
            kykUkt.setGyoumuKousinTime(pSysTime);
        }
    }

    private void updateKykSonotaTkyk(BizDate pSysDate, String pKinouId, String pUserId, String pSysTime) {
        IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();

        kykSonotaTkyk.setGyoumuKousinKinou(pKinouId);
        kykSonotaTkyk.setGyoumuKousinsyaId(pUserId);
        kykSonotaTkyk.setGyoumuKousinTime(pSysTime);
        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(uiBean.getKykdrtkykttdkkbn())) {
            kykSonotaTkyk.setKykdrtkykhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setKykdrtkykhukaymd(pSysDate);
            kykSonotaTkyk.setKykdrtkykkaiyakuymd(null);
        }
        else if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(uiBean.getKykdrtkykttdkkbn())) {
            kykSonotaTkyk.setKykdrtkykhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setKykdrtkykkaiyakuymd(pSysDate);
        }
    }

    private void updateKykUkt_kykdrn(String pKinouId, String pUserId, String pSysTime) {

        IT_KykUkt kykUkt = null;
        boolean tableInit = false;

        kykUkt = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.KYKDRN, 1);

        if (kykUkt == null) {
            kykUkt = uiBean.getKykKihon().createKykUkt();
            tableInit = true;

            kykUkt.setUktsyukbn(C_UktsyuKbn.KYKDRN);
            kykUkt.setUktsyurenno(1);
            kykUkt.setUktbnwari(BizNumber.valueOf(100));
        }

        kykUkt.setUktkbn(uiBean.getNewkykdrkbn());
        kykUkt.setGyoumuKousinKinou(pKinouId);
        kykUkt.setGyoumuKousinsyaId(pUserId);
        kykUkt.setGyoumuKousinTime(pSysTime);

        if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewkykdrkbn())) {
            kykUkt.setUktnmkn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkn());
            kykUkt.setUktnmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdairinmkj());
            kykUkt.setUktnmkjkhukakbn(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdrnmkjkhukakbn());
            kykUkt.setUktseiymd(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdrseiymd());
            kykUkt.setUktyno(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdryno());
            kykUkt.setUktadr1kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdradr1kj());
            kykUkt.setUktadr2kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdradr2kj());
            kykUkt.setUktadr3kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getKykdradr3kj());
        }
        else {
            kykUkt.setUktnmkn(BLANK);
            kykUkt.setUktnmkj(BLANK);
            kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt.setUktseiymd(null);
            kykUkt.setUktyno(BLANK);
            kykUkt.setUktadr1kj(BLANK);
            kykUkt.setUktadr2kj(BLANK);
            kykUkt.setUktadr3kj(BLANK);
        }

        if (tableInit) {
            BizPropertyInitializer.initialize(kykUkt);
        }
    }

    private void deleteKykUkt() {
        List<IT_KykUkt> kykUktLst = uiBean.getKykKihon().getKykUkts();
        IT_KykUkt kykUkt = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.KYKDRN, 1);
        kykUktLst.remove(kykUkt);
    }

    private void makeTetudukiRireki(KhozenCommonParam pKhozenCommonParam, String pSysTime, BizDate pSysDate) {

        PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);
        pALKykNaiyouKousin.exec(uiBean.getKykKihon());

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTblParam.setCommonParam(pKhozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(pSysDate);
        editTtdkRirekiTblParam.setSysTime(pSysTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());
        editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        editTtdkRirekiTblParam.setYoukyuuNo(pALKykNaiyouKousin.getYoukyuuno());

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    private void updateKhKzktrkKykDrHnkWk(String pKinouId, String pUserId, String pSysTime) {
        IW_KhKzktrkKykDrHnkWk khKzktrkKykDrHnkWk = hozenDomManager.getKhKzktrkKykDrHnkWk(
            uiBean.getBzWorkflowInfo().getKouteiKanriId());

        khKzktrkKykDrHnkWk.setMousideninkbn(uiBean.getMousideninkbn());
        khKzktrkKykDrHnkWk.setTeiseikbn(uiBean.getTeiseikbn());

        khKzktrkKykDrHnkWk.setTrkkzkttdkkbn1(uiBean.getTrkkzkttdkkbn1());
        khKzktrkKykDrHnkWk.setTrkkzknmkn1(uiBean.getNewtrkkzknmkn1());
        khKzktrkKykDrHnkWk.setTrkkzknmkj1(uiBean.getNewtrkkzknmkj1());
        khKzktrkKykDrHnkWk.setTrkkzknmkjkhukakbn1(uiBean.getNewtrkkzknmkjkhukakbn1());
        khKzktrkKykDrHnkWk.setTrkkzkseiymd1(uiBean.getNewtrkkzkseiymd1());
        khKzktrkKykDrHnkWk.setTrkkzksei1(uiBean.getNewtrkkzksei1());
        khKzktrkKykDrHnkWk.setTrkkzkyno1(uiBean.getNewtrkkzkyno1());
        khKzktrkKykDrHnkWk.setTrkkzkadr1kj1(uiBean.getNewtrkkzkadr1kj1());
        khKzktrkKykDrHnkWk.setTrkkzkadr2kj1(uiBean.getNewtrkkzkadr2kj1());
        khKzktrkKykDrHnkWk.setTrkkzkadr3kj1(uiBean.getNewtrkkzkadr3kj1());
        khKzktrkKykDrHnkWk.setTrkkzktelno1(uiBean.getNewtrkkzktelno1());
        khKzktrkKykDrHnkWk.setTrkkzktdk1(uiBean.getNewtrkkzktdk1());

        khKzktrkKykDrHnkWk.setTrkkzkttdkkbn2(uiBean.getTrkkzkttdkkbn2());
        khKzktrkKykDrHnkWk.setTrkkzknmkn2(uiBean.getNewtrkkzknmkn2());
        khKzktrkKykDrHnkWk.setTrkkzknmkj2(uiBean.getNewtrkkzknmkj2());
        khKzktrkKykDrHnkWk.setTrkkzknmkjkhukakbn2(uiBean.getNewtrkkzknmkjkhukakbn2());
        khKzktrkKykDrHnkWk.setTrkkzkseiymd2(uiBean.getNewtrkkzkseiymd2());
        khKzktrkKykDrHnkWk.setTrkkzksei2(uiBean.getNewtrkkzksei2());
        khKzktrkKykDrHnkWk.setTrkkzktdk2(uiBean.getNewtrkkzktdk2());
        khKzktrkKykDrHnkWk.setTrkkzkyno2(uiBean.getNewtrkkzkyno2());
        khKzktrkKykDrHnkWk.setTrkkzkadr1kj2(uiBean.getNewtrkkzkadr1kj2());
        khKzktrkKykDrHnkWk.setTrkkzkadr2kj2(uiBean.getNewtrkkzkadr2kj2());
        khKzktrkKykDrHnkWk.setTrkkzkadr3kj2(uiBean.getNewtrkkzkadr3kj2());
        khKzktrkKykDrHnkWk.setTrkkzktelno2(uiBean.getNewtrkkzktelno2());

        khKzktrkKykDrHnkWk.setKykdrtkykttdkkbn(uiBean.getKykdrtkykttdkkbn());
        khKzktrkKykDrHnkWk.setKykdrkbn(uiBean.getNewkykdrkbn());
        khKzktrkKykDrHnkWk.setKykdairinmkn(uiBean.getNewkykdrnmkn());
        khKzktrkKykDrHnkWk.setKykdairinmkj(uiBean.getNewkykdrnmkj());
        khKzktrkKykDrHnkWk.setKykdrnmkjkhukakbn(uiBean.getNewkykdrnmkjkhukakbn());
        khKzktrkKykDrHnkWk.setKykdrseiymd(uiBean.getNewkykdrseiymd());
        khKzktrkKykDrHnkWk.setKykdryno(uiBean.getNewkykdryno());
        khKzktrkKykDrHnkWk.setKykdradr1kj(uiBean.getNewkykdradr1kj());
        khKzktrkKykDrHnkWk.setKykdradr2kj(uiBean.getNewkykdradr2kj());
        khKzktrkKykDrHnkWk.setKykdradr3kj(uiBean.getNewkykdradr3kj());

        khKzktrkKykDrHnkWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
        khKzktrkKykDrHnkWk.setTyhysakuseiyhkbn(uiBean.getTyhysakuseiyhkbn());
        khKzktrkKykDrHnkWk.setHassoukbn(uiBean.getHassoukbn());

        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
            khKzktrkKykDrHnkWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        khKzktrkKykDrHnkWk.setGyoumuKousinKinou(pKinouId);
        khKzktrkKykDrHnkWk.setGyoumuKousinsyaId(pUserId);
        khKzktrkKykDrHnkWk.setGyoumuKousinTime(pSysTime);
        khKzktrkKykDrHnkWk.setTrkkzktsindousiteikbn1(uiBean.getNewtrkkzktsindousiteikbn1());
        khKzktrkKykDrHnkWk.setTrkkzktsindousiteikbn2(uiBean.getNewtrkkzktsindousiteikbn2());

        hozenDomManager.update(khKzktrkKykDrHnkWk);
    }

    private void insertKhKzktrkKykDrHnkWk(String pKinouId, String pUserId, String pSysTime) {

        IW_KhKzktrkKykDrHnkWk khKzktrkKykDrHnkWk = new IW_KhKzktrkKykDrHnkWk();
        khKzktrkKykDrHnkWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        khKzktrkKykDrHnkWk.setSyono(uiBean.getSyono());
        khKzktrkKykDrHnkWk.setMousideninkbn(uiBean.getMousideninkbn());
        khKzktrkKykDrHnkWk.setTeiseikbn(uiBean.getTeiseikbn());

        khKzktrkKykDrHnkWk.setTrkkzkttdkkbn1(uiBean.getTrkkzkttdkkbn1());
        khKzktrkKykDrHnkWk.setTrkkzknmkn1(uiBean.getNewtrkkzknmkn1());
        khKzktrkKykDrHnkWk.setTrkkzknmkj1(uiBean.getNewtrkkzknmkj1());
        khKzktrkKykDrHnkWk.setTrkkzknmkjkhukakbn1(uiBean.getNewtrkkzknmkjkhukakbn1());
        khKzktrkKykDrHnkWk.setTrkkzkseiymd1(uiBean.getNewtrkkzkseiymd1());
        khKzktrkKykDrHnkWk.setTrkkzksei1(uiBean.getNewtrkkzksei1());
        khKzktrkKykDrHnkWk.setTrkkzkyno1(uiBean.getNewtrkkzkyno1());
        khKzktrkKykDrHnkWk.setTrkkzkadr1kj1(uiBean.getNewtrkkzkadr1kj1());
        khKzktrkKykDrHnkWk.setTrkkzkadr2kj1(uiBean.getNewtrkkzkadr2kj1());
        khKzktrkKykDrHnkWk.setTrkkzkadr3kj1(uiBean.getNewtrkkzkadr3kj1());
        khKzktrkKykDrHnkWk.setTrkkzktelno1(uiBean.getNewtrkkzktelno1());
        khKzktrkKykDrHnkWk.setTrkkzktdk1(uiBean.getNewtrkkzktdk1());

        khKzktrkKykDrHnkWk.setTrkkzkttdkkbn2(uiBean.getTrkkzkttdkkbn2());
        khKzktrkKykDrHnkWk.setTrkkzknmkn2(uiBean.getNewtrkkzknmkn2());
        khKzktrkKykDrHnkWk.setTrkkzknmkj2(uiBean.getNewtrkkzknmkj2());
        khKzktrkKykDrHnkWk.setTrkkzknmkjkhukakbn2(uiBean.getNewtrkkzknmkjkhukakbn2());
        khKzktrkKykDrHnkWk.setTrkkzkseiymd2(uiBean.getNewtrkkzkseiymd2());
        khKzktrkKykDrHnkWk.setTrkkzksei2(uiBean.getNewtrkkzksei2());
        khKzktrkKykDrHnkWk.setTrkkzktdk2(uiBean.getNewtrkkzktdk2());
        khKzktrkKykDrHnkWk.setTrkkzkyno2(uiBean.getNewtrkkzkyno2());
        khKzktrkKykDrHnkWk.setTrkkzkadr1kj2(uiBean.getNewtrkkzkadr1kj2());
        khKzktrkKykDrHnkWk.setTrkkzkadr2kj2(uiBean.getNewtrkkzkadr2kj2());
        khKzktrkKykDrHnkWk.setTrkkzkadr3kj2(uiBean.getNewtrkkzkadr3kj2());
        khKzktrkKykDrHnkWk.setTrkkzktelno2(uiBean.getNewtrkkzktelno2());

        khKzktrkKykDrHnkWk.setKykdrtkykttdkkbn(uiBean.getKykdrtkykttdkkbn());
        khKzktrkKykDrHnkWk.setKykdrkbn(uiBean.getNewkykdrkbn());
        khKzktrkKykDrHnkWk.setKykdairinmkn(uiBean.getNewkykdrnmkn());
        khKzktrkKykDrHnkWk.setKykdairinmkj(uiBean.getNewkykdrnmkj());
        khKzktrkKykDrHnkWk.setKykdrnmkjkhukakbn(uiBean.getNewkykdrnmkjkhukakbn());
        khKzktrkKykDrHnkWk.setKykdrseiymd(uiBean.getNewkykdrseiymd());
        khKzktrkKykDrHnkWk.setKykdryno(uiBean.getNewkykdryno());
        khKzktrkKykDrHnkWk.setKykdradr1kj(uiBean.getNewkykdradr1kj());
        khKzktrkKykDrHnkWk.setKykdradr2kj(uiBean.getNewkykdradr2kj());
        khKzktrkKykDrHnkWk.setKykdradr3kj(uiBean.getNewkykdradr3kj());

        khKzktrkKykDrHnkWk.setShsnmkj(uiBean.getShsnmkj());
        khKzktrkKykDrHnkWk.setShskyno(uiBean.getShskyno());
        khKzktrkKykDrHnkWk.setShsadr1kj(uiBean.getShsadr1kj());
        khKzktrkKykDrHnkWk.setShsadr2kj(uiBean.getShsadr2kj());
        khKzktrkKykDrHnkWk.setShsadr3kj(uiBean.getShsadr3kj());

        khKzktrkKykDrHnkWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
        khKzktrkKykDrHnkWk.setTyhysakuseiyhkbn(uiBean.getTyhysakuseiyhkbn());
        khKzktrkKykDrHnkWk.setHassoukbn(uiBean.getHassoukbn());
        khKzktrkKykDrHnkWk.setGyoumuKousinKinou(pKinouId);
        khKzktrkKykDrHnkWk.setGyoumuKousinsyaId(pUserId);
        khKzktrkKykDrHnkWk.setGyoumuKousinTime(pSysTime);
        khKzktrkKykDrHnkWk.setTrkkzktsindousiteikbn1(uiBean.getNewtrkkzktsindousiteikbn1());
        khKzktrkKykDrHnkWk.setTrkkzktsindousiteikbn2(uiBean.getNewtrkkzktsindousiteikbn2());

        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
            khKzktrkKykDrHnkWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        BizPropertyInitializer.initialize(khKzktrkKykDrHnkWk);

        hozenDomManager.insert(khKzktrkKykDrHnkWk);
    }

    private void doJikouteikanri() {

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);
        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId(BLANK);

        khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(), bzCommonLockProcess.getKouteiLockKey(),
            uiBean.getSyanaicommentkh(), khRuleBean);

        pushUnlockProcessBL();
    }

    private void setTyokusouTaisyou(C_TrkKzkKbn pTrkKzkKbn, TyokusouTaisyouBean pTyokusouTaisyouBean) {
        if (C_TrkKzkKbn.TRKKZK1.eq(pTrkKzkKbn)) {
            pTyokusouTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj1());
            pTyokusouTaisyouBean.setSeiYmd(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd1());
            pTyokusouTaisyouBean.setYno(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkyno1());
            pTyokusouTaisyouBean.setAdr1kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr1kj1());
            pTyokusouTaisyouBean.setAdr2kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr2kj1());
            pTyokusouTaisyouBean.setAdr3kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr3kj1());
            pTyokusouTaisyouBean.setTelno(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktelno1());
        }
        else if (C_TrkKzkKbn.TRKKZK2.eq(pTrkKzkKbn)) {
            pTyokusouTaisyouBean.setNmkj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzknmkj2());
            pTyokusouTaisyouBean.setSeiYmd(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkseiymd2());
            pTyokusouTaisyouBean.setYno(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkyno2());
            pTyokusouTaisyouBean.setAdr1kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr1kj2());
            pTyokusouTaisyouBean.setAdr2kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr2kj2());
            pTyokusouTaisyouBean.setAdr3kj(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzkadr3kj2());
            pTyokusouTaisyouBean.setTelno(uiBean.getKhKzktrkKykdrHnkInfoUiBean().getTrkkzktelno2());
        }
    }
}
