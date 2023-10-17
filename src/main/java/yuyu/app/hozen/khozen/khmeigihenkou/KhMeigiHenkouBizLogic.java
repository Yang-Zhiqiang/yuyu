package yuyu.app.hozen.khozen.khmeigihenkou;

import static yuyu.app.hozen.khozen.khmeigihenkou.GenKhMeigiHenkouConstants.*;
import static yuyu.app.hozen.khozen.khmeigihenkou.KhMeigiHenkouConstants.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.CheckMeigininNmKanji;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceProcessForward;
import yuyu.common.biz.koutei.BzForceTaskStart;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.koutei.UpdateJimustartymd;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.CheckFatca;
import yuyu.common.hozen.khcommon.CheckHansyaSentakuInfo;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CheckZeiseiTkkkTkykHukaJyouken;
import yuyu.common.hozen.khcommon.EditHokenSyoukenParam;
import yuyu.common.hozen.khcommon.EditJimuRenrakuhyouParam;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.EditSouhuannaiParam;
import yuyu.common.hozen.khcommon.EditTtdkKanryouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiLinc;
import yuyu.common.hozen.khcommon.HanteiLincBean;
import yuyu.common.hozen.khcommon.HanteiSyoriKengen;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.HanteiTyotikuseihokenBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuOutBean;
import yuyu.common.hozen.khcommon.KeisanHtyKeihi;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhTyokusouHantei;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
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
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetHituyouSyorui;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKeizokuNkukt;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtil;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetNkukt;
import yuyu.common.hozen.setuibean.SetSbHenkanukt;
import yuyu.common.hozen.setuibean.SetSbHkukt;
import yuyu.common.hozen.setuibean.SetSiteiseikyuu;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.workflow.workflowutility.GetProcessHistoryResultBean;
import yuyu.common.workflow.workflowutility.ProcessHistoryBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AeoiHoujinSyuruiKbn;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_AeoiSyoriKbn;
import yuyu.def.classification.C_AeoiTaisyousyaKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_FatcatghtkekKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_HnsychkTaisyousyaKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_KykdrDouiYouhiKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;
import yuyu.def.classification.C_TyhysakuseiyhKbn;
import yuyu.def.classification.C_TyokusouhtkekKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktkaijyoKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_AeoiInfo;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IW_KhJyuusyoHenkouWk;
import yuyu.def.db.entity.IW_KhMeigiHenkouWk;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KykSyaHenkouRireki;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.DBAOutputReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.PdfBuilder;

import com.google.common.collect.Lists;
import com.lowagie.text.pdf.PdfReader;

/**
 * 名義変更／契約者等生年月日訂正 のビジネスロジックです。
 */
public class KhMeigiHenkouBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private KhMeigiHenkouUiBean uiBean;

    @Inject
    private KhMeigiHenkouDao khMeigiHenkouDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private GetSyoruittykymd getSyoruittykymd;

    @Inject
    private OutputReport outputReport;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private CommonDispImage commonDispImage;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private HozenPreReportRenkeiBean hozenPreReportRenkeiBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private DBAOutputReport dbaOutputReport;

    private C_Tdk kkkyktdkMenber;

    private C_UktKbn uktKbnMenber;

    private String kyknmknMenber;

    private boolean tyotkhknHyjErrorFlg;

    void init() {
    }

    void clear() {


        uiBean.setNewkyknmkn("");
        uiBean.setNewkyknmkj("");
        uiBean.setNewkyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setNewkykseiymd(null);
        uiBean.setNewkyksei(C_Kyksei.BLNK);
        uiBean.setNewkkkyktdk(C_Tdk.BLNK);

        uiBean.setNewhjndaiykkbn(C_HjndaiykKbn.BLNK);
        uiBean.setNewhjndaiyknm("");
        uiBean.setNewhjndainmkn("");
        uiBean.setNewhjndainmkj("");

        uiBean.setNewhhknnmkn("");
        uiBean.setNewhhknnmkj("");
        uiBean.setNewhhknnmkjkhukakbn(C_KjkhukaKbn.BLNK);

        uiBean.setNewnenkinuktkbn(C_UktKbn.BLNK);

        uiBean.setKzuktkaijyokbn(C_UktkaijyoKbn.BLNK);
        uiBean.setNewkzuktnmkn("");
        uiBean.setNewkzuktnmkj("");
        uiBean.setNewkzuktseiymd(null);
        uiBean.setNewkzukttdk(C_Tdk.BLNK);

        uiBean.setNewsbhenkanuktnmkn("");
        uiBean.setNewsbhenkanuktnmkj("");
        uiBean.setNewsbhenkanuktseiymd(null);
        uiBean.setNewsbhenkanukttdk(C_Tdk.BLNK);

        uiBean.setSbuktnin(null);
        uiBean.setSbuktkbn1(C_UktKbn.BLNK);

        uiBean.setSbuktnmkn1("");
        uiBean.setSbuktnmkj1("");
        uiBean.setSbuktnmkjhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setSbuktseiymd1(null);
        uiBean.setNewsbuktbnwari1(BizNumber.optional());

        uiBean.setSbuktnmkn2("");
        uiBean.setSbuktnmkj2("");
        uiBean.setSbuktnmkjhukakbn2(C_KjkhukaKbn.BLNK);
        uiBean.setSbuktseiymd2(null);
        uiBean.setNewsbuktbnwari2(BizNumber.optional());

        uiBean.setSbuktnmkn3("");
        uiBean.setSbuktnmkj3("");
        uiBean.setSbuktnmkjhukakbn3(C_KjkhukaKbn.BLNK);
        uiBean.setSbuktseiymd3(null);
        uiBean.setNewsbuktbnwari3(BizNumber.optional());

        uiBean.setSbuktnmkn4("");
        uiBean.setSbuktnmkj4("");
        uiBean.setSbuktnmkjhukakbn4(C_KjkhukaKbn.BLNK);
        uiBean.setSbuktseiymd4(null);
        uiBean.setNewsbuktbnwari4(BizNumber.optional());

        uiBean.setNewstdruktkbn(C_UktKbn.BLNK);
        uiBean.setNewstdrsknmkn("");
        uiBean.setNewstdrsknmkj("");
        uiBean.setNewstdrsknmkjhuka(false);
        uiBean.setNewstdrskseiymd(null);

        uiBean.setShsnmkj("");
        uiBean.setShskyno("");
        uiBean.setShsadr1kj("");
        uiBean.setShsadr2kj("");
        uiBean.setShsadr3kj("");

    }

    @Transactional
    void iwfOpenBL() {

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        String kouteikanriid = uiBean.getBzWorkflowInfo().getKouteiKanriId();

        String jimutetuzukicd = uiBean.getBzWorkflowInfo().getJimuTetuzukiCd();

        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo()
            .getJimuTetuzukiCd());

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(kouteikanriid, jimutetuzukicd, uiBean
            .getBzWorkflowInfo().getTaskId(),
            bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteikanriid);

        String syono = gyoumuKouteiInfo.getSyono();
        uiBean.setSyono(syono);
        uiBean.setKouteikanriid(kouteikanriid);

        IW_KhMeigiHenkouWk iwKhMeigiHenkouWk = hozenDomManager.getKhMeigiHenkouWk(kouteikanriid);

        if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()))
            && !C_SyorikekkaKbn.TORIKESI.eq(iwKhMeigiHenkouWk.getZenkaisyorikekkakbn())) {
            uiBean.setMeigihnkjiyuu(iwKhMeigiHenkouWk.getMeigihnkjiyuu());
            uiBean.setNewkyknmkn(iwKhMeigiHenkouWk.getKyknmkn());
            uiBean.setNewkyknmkj(iwKhMeigiHenkouWk.getKyknmkj());
            uiBean.setNewkyknmkjkhukakbn(iwKhMeigiHenkouWk.getKyknmkjkhukakbn());
            uiBean.setNewkykseiymd(iwKhMeigiHenkouWk.getKykseiymd());
            uiBean.setNewkyksei(iwKhMeigiHenkouWk.getKyksei());
            uiBean.setNewkkkyktdk(iwKhMeigiHenkouWk.getKkkyktdk());
            uiBean.setNewhhknnmkn(iwKhMeigiHenkouWk.getHhknnmkn());
            uiBean.setNewhhknnmkj(iwKhMeigiHenkouWk.getHhknnmkj());
            uiBean.setNewhhknnmkjkhukakbn(iwKhMeigiHenkouWk.getHhknnmkjkhukakbn());
            uiBean.setNewnenkinuktkbn(iwKhMeigiHenkouWk.getNenkinuktkbn());
            uiBean.setSbuktkaijyokbn1(iwKhMeigiHenkouWk.getSbuktkaijyokbn1());
            uiBean.setSbuktkaijyokbn2(iwKhMeigiHenkouWk.getSbuktkaijyokbn2());
            uiBean.setSbuktkaijyokbn3(iwKhMeigiHenkouWk.getSbuktkaijyokbn3());
            uiBean.setSbuktkaijyokbn4(iwKhMeigiHenkouWk.getSbuktkaijyokbn4());
            uiBean.setStdrskkaijyokbn(iwKhMeigiHenkouWk.getStdrskkaijyokbn());
            uiBean.setNewstdruktkbn(iwKhMeigiHenkouWk.getStdruktkbn());
            uiBean.setNewstdrsknmkn(iwKhMeigiHenkouWk.getStdrsknmkn());
            uiBean.setNewstdrsknmkj(iwKhMeigiHenkouWk.getStdrsknmkj());
            uiBean.setNewstdrsknmkjhukakbn(iwKhMeigiHenkouWk.getStdrsknmkjhukakbn());
            uiBean.setNewstdrskseiymd(iwKhMeigiHenkouWk.getStdrskseiymd());
            uiBean.setShsnmkj(iwKhMeigiHenkouWk.getShsnmkj());
            uiBean.setShskyno(iwKhMeigiHenkouWk.getShskyno());
            uiBean.setShsadr1kj(iwKhMeigiHenkouWk.getShsadr1kj());
            uiBean.setShsadr2kj(iwKhMeigiHenkouWk.getShsadr2kj());
            uiBean.setShsadr3kj(iwKhMeigiHenkouWk.getShsadr3kj());
            uiBean.setHonninkakninkekkakbn(iwKhMeigiHenkouWk.getHonninkakninkekkakbn());
            uiBean.setTyhysakuseiyhkbn(iwKhMeigiHenkouWk.getTyhysakuseiyhkbn());
            if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) &&
                C_TyhysakuseiyhKbn.BLNK.eq(iwKhMeigiHenkouWk.getTyhysakuseiyhkbn()) &&
                C_HassouKbn.BLNK.eq(iwKhMeigiHenkouWk.getHassoukbn())) {
                uiBean.setHassoukbn(C_HassouKbn.TYOKUSOU);
            } else {
                uiBean.setHassoukbn(iwKhMeigiHenkouWk.getHassoukbn());
            }
            uiBean.setZenkaisyorikekkakbn(iwKhMeigiHenkouWk.getZenkaisyorikekkakbn());

            if (!Integer.valueOf(0).equals(iwKhMeigiHenkouWk.getSbuktnin())) {
                uiBean.setSbuktnin(iwKhMeigiHenkouWk.getSbuktnin());
            }

            if (!C_UktKbn.BLNK.eq(iwKhMeigiHenkouWk.getSbuktkbn1())
                || !BizUtil.isBlank(iwKhMeigiHenkouWk.getSbuktnmkn1())
                || !BizUtil.isBlank(iwKhMeigiHenkouWk.getSbuktnmkj1())
                || !C_KjkhukaKbn.BLNK.eq(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn1())
                || iwKhMeigiHenkouWk.getSbuktseiymd1() != null
                || !iwKhMeigiHenkouWk.getSbuktbnwari1().isZeroOrOptional()) {
                uiBean.setSbuktkbn1(iwKhMeigiHenkouWk.getSbuktkbn1());
                uiBean.setSbuktnmkn1(iwKhMeigiHenkouWk.getSbuktnmkn1());
                uiBean.setSbuktnmkj1(iwKhMeigiHenkouWk.getSbuktnmkj1());
                uiBean.setSbuktnmkjhukakbn1(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn1());
                uiBean.setSbuktseiymd1(iwKhMeigiHenkouWk.getSbuktseiymd1());
                uiBean.setNewsbuktbnwari1(iwKhMeigiHenkouWk.getSbuktbnwari1());
            }

            if (!BizUtil.isBlank(iwKhMeigiHenkouWk.getSbuktnmkn2())
                || !BizUtil.isBlank(iwKhMeigiHenkouWk.getSbuktnmkj2())
                || !C_KjkhukaKbn.BLNK.eq(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn2())
                || iwKhMeigiHenkouWk.getSbuktseiymd2() != null
                || !iwKhMeigiHenkouWk.getSbuktbnwari2().isZeroOrOptional()) {
                uiBean.setSbuktnmkn2(iwKhMeigiHenkouWk.getSbuktnmkn2());
                uiBean.setSbuktnmkj2(iwKhMeigiHenkouWk.getSbuktnmkj2());
                uiBean.setSbuktnmkjhukakbn2(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn2());
                uiBean.setSbuktseiymd2(iwKhMeigiHenkouWk.getSbuktseiymd2());
                uiBean.setNewsbuktbnwari2(iwKhMeigiHenkouWk.getSbuktbnwari2());
            }

            if (!BizUtil.isBlank(iwKhMeigiHenkouWk.getSbuktnmkn3())
                || !BizUtil.isBlank(iwKhMeigiHenkouWk.getSbuktnmkj3())
                || !C_KjkhukaKbn.BLNK.eq(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn3())
                || iwKhMeigiHenkouWk.getSbuktseiymd3() != null
                || !iwKhMeigiHenkouWk.getSbuktbnwari3().isZeroOrOptional()) {
                uiBean.setSbuktnmkn3(iwKhMeigiHenkouWk.getSbuktnmkn3());
                uiBean.setSbuktnmkj3(iwKhMeigiHenkouWk.getSbuktnmkj3());
                uiBean.setSbuktnmkjhukakbn3(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn3());
                uiBean.setSbuktseiymd3(iwKhMeigiHenkouWk.getSbuktseiymd3());
                uiBean.setNewsbuktbnwari3(iwKhMeigiHenkouWk.getSbuktbnwari3());
            }

            if (!BizUtil.isBlank(iwKhMeigiHenkouWk.getSbuktnmkn4())
                || !BizUtil.isBlank(iwKhMeigiHenkouWk.getSbuktnmkj4())
                || !C_KjkhukaKbn.BLNK.eq(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn4())
                || iwKhMeigiHenkouWk.getSbuktseiymd4() != null
                || !iwKhMeigiHenkouWk.getSbuktbnwari4().isZeroOrOptional()) {
                uiBean.setSbuktnmkn4(iwKhMeigiHenkouWk.getSbuktnmkn4());
                uiBean.setSbuktnmkj4(iwKhMeigiHenkouWk.getSbuktnmkj4());
                uiBean.setSbuktnmkjhukakbn4(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn4());
                uiBean.setSbuktseiymd4(iwKhMeigiHenkouWk.getSbuktseiymd4());
                uiBean.setNewsbuktbnwari4(iwKhMeigiHenkouWk.getSbuktbnwari4());
            }

            if (!C_KjkhukaKbn.BLNK.eq(iwKhMeigiHenkouWk.getKyknmkjkhukakbn())) {
                uiBean.setNewkyknmkjkhuka(true);
            }

            if (!C_KjkhukaKbn.BLNK.eq(iwKhMeigiHenkouWk.getHhknnmkjkhukakbn())) {
                uiBean.setNewhhknnmkjkhuka(true);
            }

            if (!C_KjkhukaKbn.BLNK.eq(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn1())) {
                uiBean.setSbuktnmkjkhuka1(true);
            }

            if (!C_KjkhukaKbn.BLNK.eq(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn2())) {
                uiBean.setSbuktnmkjkhuka2(true);
            }

            if (!C_KjkhukaKbn.BLNK.eq(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn3())) {
                uiBean.setSbuktnmkjkhuka3(true);
            }

            if (!C_KjkhukaKbn.BLNK.eq(iwKhMeigiHenkouWk.getSbuktnmkjhukakbn4())) {
                uiBean.setSbuktnmkjkhuka4(true);
            }

            if (!C_KjkhukaKbn.BLNK.eq(iwKhMeigiHenkouWk.getStdrsknmkjhukakbn())) {
                uiBean.setNewstdrsknmkjhuka(true);
            }

            if (C_Meigihnkjiyuu.KYK.eq(iwKhMeigiHenkouWk.getMeigihnkjiyuu()) ||
                C_Meigihnkjiyuu.KYKSB.eq(iwKhMeigiHenkouWk.getMeigihnkjiyuu())) {
                uiBean.setAdrhenkouumu(iwKhMeigiHenkouWk.getAdrhenkouumu());
                uiBean.setTsinyno(iwKhMeigiHenkouWk.getTsinyno());
                uiBean.setTsinadr1kj(iwKhMeigiHenkouWk.getTsinadr1kj());
                uiBean.setTsinadr2kj(iwKhMeigiHenkouWk.getTsinadr2kj());
                uiBean.setTsinadr3kj(iwKhMeigiHenkouWk.getTsinadr3kj());
                uiBean.setTsintelno(iwKhMeigiHenkouWk.getTsintelno());
                uiBean.setDai2tsintelno(iwKhMeigiHenkouWk.getDai2tsintelno());

            }

            if (C_Meigihnkjiyuu.KYKSB.eq(iwKhMeigiHenkouWk.getMeigihnkjiyuu())) {
                BizDate syoruiUkeYmd = null;

                if (iwKhMeigiHenkouWk.getSyoruiukeymd() == null) {
                    syoruiUkeYmd = getSyoruittykymd.exec(
                        uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                        C_SyoruiCdKbn.KK_MEIGIHNK_SKS);
                }
                else {
                    syoruiUkeYmd = iwKhMeigiHenkouWk.getSyoruiukeymd();
                }

                uiBean.setOldkyksibouymd(iwKhMeigiHenkouWk.getOldkyksibouymd());
                uiBean.setSyoruiukeymd(syoruiUkeYmd);

            }

        }
        else {
            uiBean.setMeigihnkjiyuu(iwKhMeigiHenkouWk.getMeigihnkjiyuu());
            uiBean.setZenkaisyorikekkakbn(iwKhMeigiHenkouWk.getZenkaisyorikekkakbn());
        }

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);

        setProgressHistory.exec(uiBean);

        doInputKey();

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())
            && C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1
                , MessageId.WIC0001, uiBean.getZenkaisyorikekkakbn().getContent());
        }

        checkHrmbr();

        BizPropertyInitializer.initialize(uiBean);
    }

    void pushUnlockProcessBL() {

        bzCommonLockProcess.unlockProcess();
    }

    String functionNameOnClickBL() {
        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            bzCommonLockProcess.unlockProcess();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    void pushSyoukai() {

        doInputKey();

        checkHrmbr();

        uiBean.setHassoukbn(C_HassouKbn.TYOKUSOU);
        BizPropertyInitializer.initialize(uiBean);
    }

    void printHyoujiOut() {
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void pushKakunin() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            bzCommonLockProcess.continueLockProcess();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

            C_UmuKbn cUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo()
                .getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(cUmuKbn)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi
                    .getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA1002
                    , DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())
                && !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

                validate();
                validateKanji();
                setUiBeanHenkouUmu();
                checkKyk();
                checkHnkjiyuu();
                checkHhkn();
                checkNkukt();
                checkKjnnkpZeiseitkkktkykhukaSyorikahi();
                checkKjnnkpZeiseitkkktkykSyoumetu();
                checkKzukt();
                checkSbHenkanUkt();
                checkSbukt();
                checkStdrsk();

                checkHenkouUmu();

                if (!uiBean.getRstCheckYuuyokkngai()) {

                    throw new BizLogicException(MessageId.EIA1032,SYORIBI);
                }

                checkHanteiKhSisuurendoTmttknJyoutai();

                checkHonninKakunin();

                checkTyhySksYouhi();

                checkHasoKbn();

                checkSinkeiyakuTuusinsaki();

                if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {
                    checkIdoutyousyoyuuKoumoku();
                }

                checkFatca();

                checkHansya();

                checkKzkykdou();
                checkKykdairininKykhenkou();
                checkKykdairininUkthenkou();
                checkTeikishrtkykKyknmknHenkou();
                printZeiseitkkktkyktyuutohukaMsg();

                if ((C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu()) ||
                    C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu())) &&
                    C_UmuKbn.ARI.eq(uiBean.getKykhenkouumu())) {

                    if (uiBean.getAeoitaisyousyacnt() == 5) {

                        throw new BizLogicException(MessageId.EIA1017);
                    }

                    if (uiBean.getAeoirenno() != null && uiBean.getAeoirenno() == MAX_RENNO) {

                        throw new BizLogicException(MessageId.EIA1018);
                    }
                }
            }

            CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);
            checkProcessKekka.exec(uiBean.getSyorikekkakbn(), uiBean.getSyanaicommentkh()
                , uiBean.getSasimodosisakikbn());
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {

                validate();
                validateKanji();
                setUiBeanHenkouUmu();
                checkKyk();
                checkHnkjiyuu();
                checkHhkn();
                checkNkukt();
                checkKjnnkpZeiseitkkktkykhukaSyorikahi();
                checkKzukt();
                checkSbHenkanUkt();
                checkSbukt();
                checkStdrsk();

                checkHenkouUmu();

                if (!uiBean.getRstCheckYuuyokkngai()) {

                    throw new BizLogicException(MessageId.EIA1032,SYORIBI);
                }

                checkHanteiKhSisuurendoTmttknJyoutai();

                checkHonninKakunin();

                checkTyhySksYouhi();

                checkHasoKbn();

                checkSinkeiyakuTuusinsaki();

                if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {
                    checkIdoutyousyoyuuKoumoku();
                }

                checkFatca();

                checkHansya();

                checkZeiseitkkktkykhukajyouken();
                checkKzkykdou();
                checkKykdairininKykhenkou();
                checkKykdairininUkthenkou();
                checkTeikishrtkykKyknmknHenkou();
                printZeiseitkkktkyktyuutohukaMsg();

                if ((C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu()) ||
                    C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu())) &&
                    C_UmuKbn.ARI.eq(uiBean.getKykhenkouumu())) {

                    if (uiBean.getAeoitaisyousyacnt() == 5) {

                        throw new BizLogicException(MessageId.EIA1017);
                    }

                    if (uiBean.getAeoirenno() != null && uiBean.getAeoirenno() == MAX_RENNO) {

                        throw new BizLogicException(MessageId.EIA1018);
                    }
                }
            }

            CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);
            checkProcessKekka.exec(uiBean.getSyorikekkakbn(), uiBean.getSyanaicommentkh()
                , uiBean.getSasimodosisakikbn());
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_UmuKbn.ARI.eq(uiBean.getAdrhenkouumu())) {

            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
            C_UmuKbn kouteiUmu =
                checkProcessKaishi.exec(uiBean.getSyono(), IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU);

            if (C_UmuKbn.ARI.eq(kouteiUmu)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi
                    .getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA1020,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()),
                    bzGetProcessSummaryOutBean.getJimuTetuzukiNm());

            }

        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void doUpdate() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            bzCommonLockProcess.continueLockProcess();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

            C_UmuKbn cUmuKbn =
                checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(cUmuKbn)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                    checkProcessKaishi.getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA1002
                    , DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }

            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

            CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

            C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

            if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

                throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());

            }

            BzProcessCreateInBean bzProcessCreateInBean = SWAKInjector.getInstance(BzProcessCreateInBean.class);

            bzProcessCreateInBean.setSyoNo(uiBean.getSyono());
            bzProcessCreateInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);

            BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

            if (C_KouteiSakuseiKekkaKbn.FAILURE.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0008));
            }

            uiBean.getBzWorkflowInfo().setKouteiKanriId(bzProcessCreateOutBean.getKouteiKanriId());

            bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId()
                , uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);

            bzForceTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId()
                , uiBean.getBzWorkflowInfo().getJimuTetuzukiCd()
                , C_KhkinouModeIdKbn.INPUT.getValue()
                , bzCommonLockProcess.getKouteiLockKey());

        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0);

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
            && C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())
            && !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

            uiBean.getBzWorkflowInfo().setTaskId(kinouMode.getKinouMode());

            String sikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

            tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetuKey);

            updateKTKykKihon();

            IT_KykKihon itKykKihon = uiBean.getKykKihon();

            updateKTUkt();

            updateKTKykSya();

            updateKTHhknSya();

            if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())
                || C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu())) {

                if (C_UmuKbn.ARI.eq(uiBean.getVtrkkzktrkkzkumukbn1())
                    || C_UmuKbn.ARI.eq(uiBean.getVtrkkzktrkkzkumukbn2())) {

                    deleteTrkKzk(itKykKihon);

                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5, MessageId.IIF1025);
                }
                if (C_UmuKbn.ARI.eq(uiBean.getKykdrtkykhukaumu())) {

                    updateKykSonotaTkyk(itKykKihon, khozenCommonParam);

                    updateKhTtdkTyuui(itKykKihon, khozenCommonParam);

                    List<IT_KykUkt> kykUktList = itKykKihon.getKykUkts();

                    IT_KykUkt kykUkt = itKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN).get(0);

                    kykUktList.remove(kykUkt);

                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5, MessageId.IIF1026);
                }

                hozenDomManager.update(itKykKihon);
            }

            updateKouza();

            PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);

            pALKykNaiyouKousin.exec(itKykKihon);

            if (C_UmuKbn.ARI.eq(uiBean.getKykhenkouumu()) &&
                !C_NayoseJissiKekkaKbn.BLNK.eq(pALKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn())) {

                IT_KykKihon kykKihon = uiBean.getKykKihon();
                IT_KykSya kykSya = kykKihon.getKykSya();
                kykSya.setKyksakuinmeino(pALKykNaiyouKousin.getKykSakuinmeino());
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHhkhenkouumu()) &&
                !C_NayoseJissiKekkaKbn.BLNK.eq(pALKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn())) {

                IT_KykKihon kykKihon = uiBean.getKykKihon();
                IT_HhknSya hhknSya = kykKihon.getHhknSya();
                hhknSya.setHhknsakuinmeino(pALKykNaiyouKousin.getHhknSakuinmeino());
            }

            if ((C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu()) ||
                C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu())) &&
                C_UmuKbn.ARI.eq(uiBean.getKykhenkouumu())) {

                updateKTAeoiInfo();

                IT_AeoiInfo aeoiInfo = itKykKihon.createAeoiInfo();
                aeoiInfo.setSyono(uiBean.getSyono());
                aeoiInfo.setRenno(uiBean.getAeoirenno() + 1);
                aeoiInfo.setAeoisyoriymd(BizDate.getSysDate());
                aeoiInfo.setAeoisyorikbn(C_AeoiSyoriKbn.MEIGIHENKOU);
                aeoiInfo.setAeoikouryokusttymd(BizDate.getSysDate());
                aeoiInfo.setAeoisyorisosikicd(baseUserInfo.getTmSosikiCd());
                aeoiInfo.setAeoitaisyousyakbn(C_AeoiTaisyousyaKbn.KYKSYA);
                aeoiInfo.setAeoikekkakbn(C_AeoiKekkaKbn.HOUKOKUTAISYOUGAI);
                aeoiInfo.setAeoihoujinsyuruikbn(C_AeoiHoujinSyuruiKbn.BLNK);
                aeoiInfo.setAeoikouryokuendymd(null);
                aeoiInfo.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                aeoiInfo.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                aeoiInfo.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(aeoiInfo);
            }

            khLincSousinDataSyori(khozenCommonParam, BizDate.getSysDate(), tableMaintenanceUtil.getBakKykKihon());

            makeTetudukiRireki(pALKykNaiyouKousin.getYoukyuuno(), sikibetuKey);

            if ((C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()) &&
                (BizDateUtil.compareYmd(BizDate.getSysDate(), HANTEI_DATE) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(BizDate.getSysDate(), HANTEI_DATE) == BizDateUtil.COMPARE_EQUAL)) ||
                (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu()) &&
                    (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), HANTEI_DATE) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), HANTEI_DATE) == BizDateUtil.COMPARE_EQUAL))) {

                makeKykSyaHenkouRireki(sikibetuKey, BizDate.getSysDate(), BizDate.getSysDateTimeMilli(), kykSyouhn);

            }

            makeTyouhyou(khozenCommonParam);
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

                IW_KhMeigiHenkouWk iwKhMeigiHenkouWk =
                    hozenDomManager.getKhMeigiHenkouWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

                hozenDomManager.delete(iwKhMeigiHenkouWk);
            } else {
                doUpdateKTMeigiHenkouWk(BizDate.getSysDate(), BizDate.getSysDateTimeMilli());
            }
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn()))) {

            insKTMeigiHenkouWkByKakutei(BizDate.getSysDate(), BizDate.getSysDateTimeMilli());
        }

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {

            doUpdateKTMeigiHenkouWk(BizDate.getSysDate(), BizDate.getSysDateTimeMilli());
        }

        C_SyorikekkaKbn syorikekkakbn = uiBean.getSyorikekkakbn();


        if ((BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), HANTEI_DATE) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), HANTEI_DATE) == BizDateUtil.COMPARE_EQUAL) &&
            C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu()) &&
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) &&
            !C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            C_ErrorKbn errorKbn = getKawaseRate.exec(
                uiBean.getSyoruiukeymd(),
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                kykSyouhn.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTB,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                syorikekkakbn = C_SyorikekkaKbn.KANRYOU_SYOUNINMATI;
            }
        }

        doJikouteikanri(uiBean.getSyono(), syorikekkakbn);

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_UmuKbn.ARI.eq(uiBean.getAdrhenkouumu())) {
            makeKhJyuusyoHenkouWk();
        }

        messageManager.addMessageId(MessageId.IAC0009);

        if (C_SyorikekkaKbn.KANRYOU_SYOUNINMATI.eq(syorikekkakbn)) {
            messageManager.addMessageId(MessageId.IIF1010);
        }

        if (!((C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()))
            && C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF1038);
            messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF1039);
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {
            messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF1028);
        }

        if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
            !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) ||
            C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

            uiBean.getKykKihon().detach();
        }
    }

    void pushModoruBtnByConfirm() {

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);
        bzCommonLockProcess.continueLockProcess();
    }

    void printOut() {

        PdfBuilder builder = joinPdf(uiBean.getTyouhyoukey(), uiBean.getMeigihnkjiyuu());

        outputReport.outputJoinedPDFByBinary(builder.toByteArray(), uiBean.getTyouhyoukey());

    }

    void setSksMsg() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn cUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(cUmuKbn)) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120
                , DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        if(!uiBean.getRstCheckYuuyokkngai()){

            throw new BizLogicException(MessageId.EIA1032,SYORIBI);
        }

        if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {

            if (BizUtil.isBlank(uiBean.getShsnmkj())) {
                throw new BizLogicException(MessageId.EBC0043, DISP_S_SHSNMKJ);
            }
            if (BizUtil.isBlank(uiBean.getShskyno())) {
                throw new BizLogicException(MessageId.EBC0043, DISP_S_SHSYNO);
            }
            if (BizUtil.isBlank(uiBean.getShsadr1kj())) {
                throw new BizLogicException(MessageId.EBC0043, DISP_S_SHSADR1KJ);
            }

            BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);

            BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean =
                bzChkAdrKetasuu.exec(uiBean.getShsadr1kj(), uiBean.getShsadr2kj(), uiBean.getShsadr3kj());

            if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {

                throw new BizLogicException(MessageId.EBA1003, DISP_S_SHSKADRKJ
                    , String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu())
                    , String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
            }
        }

        if (C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIF1040);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getZeiseitkkktkykhukaumu())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIF1029);
        }

        String shsnmkj = uiBean.getShsnmkj();
        String shskyno = uiBean.getShskyno();
        String shsadr1kj = uiBean.getShsadr1kj();
        String shsadr2kj = uiBean.getShsadr2kj();
        String shsadr3kj = uiBean.getShsadr3kj();

        clear();

        uiBean.setShsnmkj(shsnmkj);
        uiBean.setShskyno(shskyno);
        uiBean.setShsadr1kj(shsadr1kj);
        uiBean.setShsadr2kj(shsadr2kj);
        uiBean.setShsadr3kj(shsadr3kj);

        messageManager.addMessageId(MessageId.QIA0004);
    }

    @Transactional
    void doSksConfirm() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn cUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(cUmuKbn)) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120
                , DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        doJikouteikanris();
        makeTyouhyous();
        insKTMeigiHenkouWkBySks(BizDate.getSysDate(), BizDate.getSysDateTimeMilli());

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);
    }

    private void doInputKey() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String syono = uiBean.getSyono();
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);


        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);
        List<String> warningMessageIdList = checkYuukouJyoutai.getWarningMessageIDList();
        List<String> warningMessageList = checkYuukouJyoutai.getWarningMessageList();

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }

        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {

            String warningMessage = "";
            String warningMessageId = "";

            for (int i = 0; i < warningMessageIdList.size(); i++) {

                warningMessage = warningMessageList.get(i);
                warningMessageId = warningMessageIdList.get(i);

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, warningMessageId
                    , warningMessage);
            }
        }
        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);

        C_Meigihnkjiyuu meigiHnkJiyuu = uiBean.getMeigihnkjiyuu();

        if (C_Meigihnkjiyuu.KYKSB.eq(meigiHnkJiyuu)) {

            uiBean.setDaisennintdkumukbn(C_UmuKbn.ARI);
        }
        else {

            uiBean.setDaisennintdkumukbn(C_UmuKbn.NONE);
        }

        hanteiSyoriKengen.exec();

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, syono);
        String messageId = hanteiTetuduki.getMessageID();
        String messageParam = hanteiTetuduki.getMessageParam();

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

            throw new BizLogicException(MessageId.EIA1006, messageParam);
        }
        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, messageId, messageParam);
        }

        if (C_Meigihnkjiyuu.KYKSB.eq(meigiHnkJiyuu)) {

            IT_KykSya kykSya = kykKihon.getKykSya();

            if (kykSya == null) {
                throw new CommonBizAppException(TABLE_NAME + "  取得エラー");
            }

            if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {
                throw new BizLogicException(MessageId.EIA0069);
            }
        }

        List<IT_KykSyouhn> keiyakuSyouhinLst = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);
        if (BizDateUtil.compareYmd(BizDate.getSysDate(), keiyakuSyouhinLst.get(0).getKykymd()) == BizDateUtil.COMPARE_LESSER) {

            throw new BizLogicException(MessageId.EIA0070,
                KhMeigiHenkouConstants.SYORIBI);
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU);
        }

        setUiBean();

        if (C_UmuKbn.ARI.eq(uiBean.getHjnkykumukbn())) {
            uiBean.setPatternNewkyksei(C_Kyksei.PATTERN_DEFAULT);
            uiBean.setPatternNewkkkyktdk(C_Tdk.PATTERN_KYKSYA);
        }
        else {
            uiBean.setPatternNewkyksei(C_Kyksei.PATTERN_NOHJN);
            uiBean.setPatternNewkkkyktdk(C_Tdk.PATTERN_KYK_NOHJ);
        }

        if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu()) ||
            C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu())) {

            if(C_Kykjyoutai.HRKMTYUU.eq( keiyakuSyouhinLst.get(0).getKykjyoutai()) ||
                C_Kykjyoutai.IKKATUNK.eq( keiyakuSyouhinLst.get(0).getKykjyoutai())) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA0008);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getVtrkkzktrkkzkumukbn1()) || C_UmuKbn.ARI.eq(uiBean.getVtrkkzktrkkzkumukbn2())) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF1038);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getKykdrtkykhukaumu())) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF1039);
            }
        }

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        uiBean.setRstCheckYuuyokkngai(checkYuuyokkngai.exec(uiBean.getSyono(), BizDate.getSysDate()));

        if (!uiBean.getRstCheckYuuyokkngai()) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA0011);

        }

        if ((C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu()) || C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()))) {

            List<IT_KykSyouhn> kykSyouhnList = khozenCommonParam.getKeiyakuSyouhin(syono, C_SyutkKbn.SYU);

            uiBean.setYendthnkymd(kykSyouhnList.get(0).getYendthnkymd());

            if (!BizUtil.isBlank(uiBean.getKouteikanriid())) {

                C_UmuKbn fatcaTaisyouUmu = kykSyouhnList.get(0).getSyouhnZokusei().getFatcataisyouumu();
                if (C_UmuKbn.ARI.eq(fatcaTaisyouUmu)) {

                    BizDate syoruittykymd = getSyoruittykymd.exec(
                        uiBean.getKouteikanriid(),
                        C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

                    if (syoruittykymd != null) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                            MessageId.WIA0053);
                    }
                }
            }
        }

        if ((C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu()) || C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()))) {

            if (!BizUtil.isBlank(uiBean.getKouteikanriid())) {
                List<IT_KykSyouhn> kykSyouhnLst = khozenCommonParam.getKeiyakuSyouhin(syono, C_SyutkKbn.SYU);

                C_UmuKbn aeoitaisyouumu = kykSyouhnLst.get(0).getSyouhnZokusei().getAeoitaisyouumu();
                if (C_UmuKbn.ARI.eq(aeoitaisyouumu)) {

                    BizDate syoruittykymd = getSyoruittykymd.exec(
                        uiBean.getKouteikanriid(), C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

                    if (syoruittykymd != null) {
                        messageManager.addConversationMessageId(
                            KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA1014);
                    }
                }
            }
        }
    }

    private void setUiBean() {
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);

        SetKihon.exec(khozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(khozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList().size() > 0) {

            for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1
                    , BizUtil.getGeneralMessageId(uiBean.getWarningMessageIdList().get(i)), uiBean
                    .getWarningMessageList().get(i));
            }
        }

        SetTetudukityuui.exec(khozenCommonParam, uiBean);

        List<IT_AeoiInfo> aeoiInfoLst = uiBean.getKykKihon().getAeoiInfos();

        if (aeoiInfoLst.size() == 0) {
            uiBean.setAeoitaisyousyacnt(0);
            uiBean.setAeoirenno(0);
        } else {

            for (int idx = 0; idx < aeoiInfoLst.size(); idx++) {
                if (idx == 0) {
                    uiBean.setAeoitaisyousyacnt(1);
                    uiBean.setAeoirenno(aeoiInfoLst.get(idx).getRenno());
                    uiBean.setDispaeoisyoriymd1(aeoiInfoLst.get(idx).getAeoisyoriymd());
                    uiBean.setDispaeoisyorisosikicd1(aeoiInfoLst.get(idx).getAeoisyorisosikicd());
                    uiBean.setDispaeoikekkakbn1(aeoiInfoLst.get(idx).getAeoikekkakbn());
                    uiBean.setDispaeoisyorikbn1(aeoiInfoLst.get(idx).getAeoisyorikbn());
                    uiBean.setDispaeoitaisyousyakbn1(aeoiInfoLst.get(idx).getAeoitaisyousyakbn());
                    uiBean.setDispaeoihoujinsyuruikbn1(aeoiInfoLst.get(idx).getAeoihoujinsyuruikbn());
                    uiBean.setDispaeoikouryokusttymd1(aeoiInfoLst.get(idx).getAeoikouryokusttymd());
                    uiBean.setDispaeoikouryokuendymd1(aeoiInfoLst.get(idx).getAeoikouryokuendymd());
                }
                else if (idx == 1) {
                    uiBean.setAeoitaisyousyacnt(2);
                    uiBean.setAeoirenno(aeoiInfoLst.get(idx).getRenno());
                    uiBean.setDispaeoisyoriymd2(aeoiInfoLst.get(idx).getAeoisyoriymd());
                    uiBean.setDispaeoisyorisosikicd2(aeoiInfoLst.get(idx).getAeoisyorisosikicd());
                    uiBean.setDispaeoikekkakbn2(aeoiInfoLst.get(idx).getAeoikekkakbn());
                    uiBean.setDispaeoisyorikbn2(aeoiInfoLst.get(idx).getAeoisyorikbn());
                    uiBean.setDispaeoitaisyousyakbn2(aeoiInfoLst.get(idx).getAeoitaisyousyakbn());
                    uiBean.setDispaeoihoujinsyuruikbn2(aeoiInfoLst.get(idx).getAeoihoujinsyuruikbn());
                    uiBean.setDispaeoikouryokusttymd2(aeoiInfoLst.get(idx).getAeoikouryokusttymd());
                    uiBean.setDispaeoikouryokuendymd2(aeoiInfoLst.get(idx).getAeoikouryokuendymd());
                }
                else if (idx == 2) {
                    uiBean.setAeoitaisyousyacnt(3);
                    uiBean.setAeoirenno(aeoiInfoLst.get(idx).getRenno());
                    uiBean.setDispaeoisyoriymd3(aeoiInfoLst.get(idx).getAeoisyoriymd());
                    uiBean.setDispaeoisyorisosikicd3(aeoiInfoLst.get(idx).getAeoisyorisosikicd());
                    uiBean.setDispaeoikekkakbn3(aeoiInfoLst.get(idx).getAeoikekkakbn());
                    uiBean.setDispaeoisyorikbn3(aeoiInfoLst.get(idx).getAeoisyorikbn());
                    uiBean.setDispaeoitaisyousyakbn3(aeoiInfoLst.get(idx).getAeoitaisyousyakbn());
                    uiBean.setDispaeoihoujinsyuruikbn3(aeoiInfoLst.get(idx).getAeoihoujinsyuruikbn());
                    uiBean.setDispaeoikouryokusttymd3(aeoiInfoLst.get(idx).getAeoikouryokusttymd());
                    uiBean.setDispaeoikouryokuendymd3(aeoiInfoLst.get(idx).getAeoikouryokuendymd());
                }
                else if (idx == 3) {
                    uiBean.setAeoitaisyousyacnt(4);
                    uiBean.setAeoirenno(aeoiInfoLst.get(idx).getRenno());
                    uiBean.setDispaeoisyoriymd4(aeoiInfoLst.get(idx).getAeoisyoriymd());
                    uiBean.setDispaeoisyorisosikicd4(aeoiInfoLst.get(idx).getAeoisyorisosikicd());
                    uiBean.setDispaeoikekkakbn4(aeoiInfoLst.get(idx).getAeoikekkakbn());
                    uiBean.setDispaeoisyorikbn4(aeoiInfoLst.get(idx).getAeoisyorikbn());
                    uiBean.setDispaeoitaisyousyakbn4(aeoiInfoLst.get(idx).getAeoitaisyousyakbn());
                    uiBean.setDispaeoihoujinsyuruikbn4(aeoiInfoLst.get(idx).getAeoihoujinsyuruikbn());
                    uiBean.setDispaeoikouryokusttymd4(aeoiInfoLst.get(idx).getAeoikouryokusttymd());
                    uiBean.setDispaeoikouryokuendymd4(aeoiInfoLst.get(idx).getAeoikouryokuendymd());
                }
                else if (idx == 4) {
                    uiBean.setAeoitaisyousyacnt(5);
                    uiBean.setAeoirenno(aeoiInfoLst.get(idx).getRenno());
                    uiBean.setDispaeoisyoriymd5(aeoiInfoLst.get(idx).getAeoisyoriymd());
                    uiBean.setDispaeoisyorisosikicd5(aeoiInfoLst.get(idx).getAeoisyorisosikicd());
                    uiBean.setDispaeoikekkakbn5(aeoiInfoLst.get(idx).getAeoikekkakbn());
                    uiBean.setDispaeoisyorikbn5(aeoiInfoLst.get(idx).getAeoisyorikbn());
                    uiBean.setDispaeoitaisyousyakbn5(aeoiInfoLst.get(idx).getAeoitaisyousyakbn());
                    uiBean.setDispaeoihoujinsyuruikbn5(aeoiInfoLst.get(idx).getAeoihoujinsyuruikbn());
                    uiBean.setDispaeoikouryokusttymd5(aeoiInfoLst.get(idx).getAeoikouryokusttymd());
                    uiBean.setDispaeoikouryokuendymd5(aeoiInfoLst.get(idx).getAeoikouryokuendymd());
                }
            }
        }

        SetTrkKazoku.exec(khozenCommonParam, uiBean);

        List<IT_TrkKzk> trkKzkList = khozenCommonParam.getTrkKzk(uiBean.getSyono());

        if (trkKzkList != null) {

            for (int idx = 0; idx < trkKzkList.size(); idx++) {
                if (C_TrkKzkKbn.TRKKZK1.eq(trkKzkList.get(idx).getTrkkzkkbn())) {
                    uiBean.setTrkkzktsindousiteikbn1(trkKzkList.get(idx).getTrkkzktsindousiteikbn());
                }
                else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzkList.get(idx).getTrkkzkkbn())) {
                    uiBean.setTrkkzktsindousiteikbn2(trkKzkList.get(idx).getTrkkzktsindousiteikbn());
                }
            }
        }

        SetKyksyadairi.exec(khozenCommonParam, uiBean);

        SetKeiyakusya.exec(khozenCommonParam, uiBean);

        SetHihokensya.exec(khozenCommonParam, uiBean);

        SetTuusinsaki.exec(khozenCommonParam, uiBean);

        SetNkukt.exec(khozenCommonParam, uiBean);

        SetSbHenkanukt.exec(khozenCommonParam, uiBean);

        SetSbHkukt.exec(khozenCommonParam, uiBean);

        SetKeizokuNkukt.exec(khozenCommonParam, uiBean);

        SetSiteiseikyuu.exec(khozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(khozenCommonParam, uiBean);

        SetHituyouSyorui.exec(khozenCommonParam, uiBean);

        uiBean.setStdrsktkyhkumu(C_UmuKbn.NONE);
        uiBean.setNkhknumu(C_UmuKbn.NONE);
        uiBean.setHjnkykumukbn(C_UmuKbn.NONE);
        uiBean.setVshktsbkyuuhukinuktumu(C_UmuKbn.NONE);
        uiBean.setZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
        uiBean.setKykdrtkykhukaumu(C_UmuKbn.NONE);
        uiBean.setKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);
        uiBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);

        IT_KykKihon kykKihon = uiBean.getKykKihon();
        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhns();
        for (IT_KykSyouhn kykSyouhn : kykSyouhnList) {
            BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                uiBean.setNkhknumu(C_UmuKbn.ARI);
            }
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getHjnkykumukbn())) {
                uiBean.setHjnkykumukbn(C_UmuKbn.ARI);
            }
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getSbkyuuhukinuktumu())) {
                uiBean.setVshktsbkyuuhukinuktumu(C_UmuKbn.ARI);
            }
        }

        IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());
        IT_KykSonotaTkyk itKykSonotaTkyk = itKykKihon.getKykSonotaTkyk();
        IT_KhTtdkTyuui khTtdkTyuui = itKykKihon.getKhTtdkTyuui();
        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getStdrsktkyhkumu())) {

            uiBean.setStdrsktkyhkumu(C_UmuKbn.ARI);
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getZeiseitkkktkykhukaumu())) {
            uiBean.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getKykdrtkykhukaumu())) {
            uiBean.setKykdrtkykhukaumu(C_UmuKbn.ARI);
        }

        if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {
            uiBean.setKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.SETTEI);
        }

        if (C_UmuKbn.ARI.eq(itKykSonotaTkyk.getTeikishrtkykhukaumu())) {
            uiBean.setTeikishrtkykhukaumu(C_UmuKbn.ARI);
        }

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);
        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));
        setKhKbnPatternUtil.exec(uiBean);

    }

    private void validate() {

        int nameKeta = YuyuBizConfig.getInstance().getKanaNmKyoyou();

        chkKana(uiBean.getNewkyknmkn(), nameKeta, DISP_S_NEW_KYKNMKN);
        chkKana(uiBean.getNewhjndainmkn(), nameKeta, DISP_S_NEW_HJNDAINMKN);
        chkKana(uiBean.getNewhhknnmkn(), nameKeta, DISP_S_NEW_HHKNNMKN);

        chkKana(uiBean.getNewkzuktnmkn(), nameKeta, DISP_S_NEW_KZUKTNMKN);
        chkKana(uiBean.getNewsbhenkanuktnmkn(), nameKeta, DISP_S_NEW_SBHENKANUKTNMKN);

        chkKana(uiBean.getSbuktnmkn1(), nameKeta, DISP_S_NEW_SBUKTNMKN1);
        chkKana(uiBean.getSbuktnmkn2(), nameKeta, DISP_S_NEW_SBUKTNMKN2);
        chkKana(uiBean.getSbuktnmkn3(), nameKeta, DISP_S_NEW_SBUKTNMKN3);
        chkKana(uiBean.getSbuktnmkn4(), nameKeta, DISP_S_NEW_SBUKTNMKN4);

        chkKana(uiBean.getNewstdrsknmkn(), nameKeta, DISP_S_NEW_STDRSKNMKN);
    }

    private void chkKana(String psKanaString, int piKyoyouKeta, String psDispNm) {
        if (BizUtil.isBlank(psKanaString)) {
            return;
        }

        if (!CheckKana.isKyokaMoji(psKanaString)) {
            throw new BizLogicException(MessageId.EBC0046, psDispNm);
        }

        if (!CheckKana.isKyoyouKetaHankaku(psKanaString, piKyoyouKeta)) {
            throw new BizLogicException(MessageId.EBC0004, psDispNm, Integer.toString(piKyoyouKeta));
        }
    }

    private void validateKanji() {
        boolean result = CheckMeigininNmKanji.isCheckOK(uiBean.getNewkyknmkj(), C_Kojinhjn.KOJIN);
        if (!result) {
            throw new BizLogicException(MessageId.EBC0046, DISP_S_NEW_KYKNMKJ);
        }
        result = CheckMeigininNmKanji.isCheckOK(uiBean.getNewhhknnmkj(), C_Kojinhjn.KOJIN);
        if (!result) {
            throw new BizLogicException(MessageId.EBC0046, DISP_S_NEW_HHKNNMKJ);
        }
        result = CheckMeigininNmKanji.isCheckOK(uiBean.getSbuktnmkj1(), C_Kojinhjn.KOJIN);
        if (!result) {
            throw new BizLogicException(MessageId.EBC0046, DISP_S_NEW_SBUKTNMKJ1);
        }
        result = CheckMeigininNmKanji.isCheckOK(uiBean.getSbuktnmkj2(), C_Kojinhjn.KOJIN);
        if (!result) {
            throw new BizLogicException(MessageId.EBC0046, DISP_S_NEW_SBUKTNMKJ2);
        }
        result = CheckMeigininNmKanji.isCheckOK(uiBean.getSbuktnmkj3(), C_Kojinhjn.KOJIN);
        if (!result) {
            throw new BizLogicException(MessageId.EBC0046, DISP_S_NEW_SBUKTNMKJ3);
        }
        result = CheckMeigininNmKanji.isCheckOK(uiBean.getSbuktnmkj4(), C_Kojinhjn.KOJIN);
        if (!result) {
            throw new BizLogicException(MessageId.EBC0046, DISP_S_NEW_SBUKTNMKJ4);
        }
        result = CheckMeigininNmKanji.isCheckOK(uiBean.getNewstdrsknmkj(), C_Kojinhjn.KOJIN);
        if (!result) {
            throw new BizLogicException(MessageId.EBC0046, DISP_S_NEW_STDRSKNMKJ);
        }

    }

    private void setUiBeanHenkouUmu() {

        uiBean.setKykhenkouumu(C_UmuKbn.NONE);
        uiBean.setHhkhenkouumu(C_UmuKbn.NONE);
        uiBean.setNkukthenkouumu(C_UmuKbn.NONE);
        uiBean.setKznkukthenkouumu(C_UmuKbn.NONE);
        uiBean.setSbhkknukthenkouumu(C_UmuKbn.NONE);
        uiBean.setSbukthenkouumu(C_UmuKbn.NONE);
        uiBean.setStdrskhenkouumu(C_UmuKbn.NONE);
        uiBean.setKyktdkhnkumu(C_UmuKbn.NONE);
    }

    private void checkKyk() {
        String kyknmkn;
        String kyknmkj;
        C_KjkhukaKbn kyknmkjkhukakbn;
        BizDate kykseiymd;
        C_Kyksei kyksei;
        C_Tdk kkkyktdk;
        C_HjndaiykKbn hjndaiykkbn;
        String hjndaiyknm;
        String hjndainmkn;
        String hjndainmkj;
        String hhknnmkn;
        String hhknnmkj;
        C_KjkhukaKbn hhknnmkjkhukakbn;
        BizDate hhknseiymd;
        C_Hhknsei hhknsei;

        if (BizUtil.isBlank(uiBean.getNewkyknmkn())) {
            kyknmkn = uiBean.getVkykskyknmkn();
        } else {
            kyknmkn = uiBean.getNewkyknmkn();
        }

        if (BizUtil.isBlank(uiBean.getNewkyknmkj()) &&
            C_KjkhukaKbn.BLNK.eq(uiBean.getNewkyknmkjkhukakbn())) {
            kyknmkj = uiBean.getVkykskyknmkj();
            kyknmkjkhukakbn = uiBean.getVkykskyknmkjkhukakbn();
        } else {
            kyknmkj = uiBean.getNewkyknmkj();
            kyknmkjkhukakbn = uiBean.getNewkyknmkjkhukakbn();
        }

        if (uiBean.getNewkykseiymd() == null) {
            kykseiymd = uiBean.getVkykskykseiymd();
        } else {
            kykseiymd = uiBean.getNewkykseiymd();
        }

        if (C_Kyksei.BLNK.eq(uiBean.getNewkyksei())) {
            kyksei = uiBean.getVkykskyksei();
        } else {
            kyksei = uiBean.getNewkyksei();
        }

        if (C_Tdk.BLNK.eq(uiBean.getNewkkkyktdk())) {
            kkkyktdk = uiBean.getVkykskkkyktdk();
        } else {
            kkkyktdk = uiBean.getNewkkkyktdk();

            uiBean.setKyktdkhnkumu(C_UmuKbn.ARI);
        }

        if (C_HjndaiykKbn.BLNK.eq(uiBean.getNewhjndaiykkbn()) &&
            BizUtil.isBlank(uiBean.getNewhjndaiyknm())) {
            hjndaiykkbn = uiBean.getVkykshjndaiykkbn();
            hjndaiyknm = uiBean.getVkykshjndaiyknm();
        } else {
            hjndaiykkbn = uiBean.getNewhjndaiykkbn();
            hjndaiyknm = uiBean.getNewhjndaiyknm();
        }

        if (BizUtil.isBlank(uiBean.getNewhjndainmkn())) {
            hjndainmkn = uiBean.getVkykshjndainmkn();
        } else {
            hjndainmkn = uiBean.getNewhjndainmkn();
        }

        if (BizUtil.isBlank(uiBean.getNewhjndainmkj())) {
            hjndainmkj = uiBean.getVkykshjndainmkj();
        } else {
            hjndainmkj = uiBean.getNewhjndainmkj();
        }

        if (BizUtil.isBlank(uiBean.getNewhhknnmkn())) {
            hhknnmkn = uiBean.getVhhkshhknnmkn();
        } else {
            hhknnmkn = uiBean.getNewhhknnmkn();
        }

        if (BizUtil.isBlank(uiBean.getNewhhknnmkj()) &&
            C_KjkhukaKbn.BLNK.eq(uiBean.getNewhhknnmkjkhukakbn())) {
            hhknnmkj = uiBean.getVhhkshhknnmkj();
            hhknnmkjkhukakbn = uiBean.getVhhkshhknnmkjkhukakbn();
        } else {
            hhknnmkj = uiBean.getNewhhknnmkj();
            hhknnmkjkhukakbn = uiBean.getNewhhknnmkjkhukakbn();

        }

        hhknseiymd = uiBean.getVhhkshhknseiymd();

        hhknsei = uiBean.getVhhkshhknsei();

        if (!kyknmkn.equals(uiBean.getVkykskyknmkn()) ||
            !kyknmkj.equals(uiBean.getVkykskyknmkj()) ||
            !kyknmkjkhukakbn.eq(uiBean.getVkykskyknmkjkhukakbn()) ||
            BizDateUtil.compareYmd(kykseiymd, uiBean.getVkykskykseiymd()) != BizDateUtil.COMPARE_EQUAL ||
            !kyksei.eq(uiBean.getVkykskyksei()) ||
            !kkkyktdk.eq(uiBean.getVkykskkkyktdk()) ||
            !hjndaiykkbn.eq(uiBean.getVkykshjndaiykkbn()) ||
            !hjndaiyknm.equals(uiBean.getVkykshjndaiyknm()) ||
            !hjndainmkn.equals(uiBean.getVkykshjndainmkn()) ||
            !hjndainmkj.equals(uiBean.getVkykshjndainmkj())) {

            uiBean.setKykhenkouumu(C_UmuKbn.ARI);
        }

        if (!kyknmkn.equals(uiBean.getVkykskyknmkn()) ||
            !kyknmkj.equals(uiBean.getVkykskyknmkj()) ||
            !kyknmkjkhukakbn.eq(uiBean.getVkykskyknmkjkhukakbn()) ||
            BizDateUtil.compareYmd(kykseiymd, uiBean.getVkykskykseiymd()) != BizDateUtil.COMPARE_EQUAL) {

            uiBean.setDskykmeihenkouumu(C_UmuKbn.ARI);
        }

        if (!hhknnmkn.equals(uiBean.getVhhkshhknnmkn()) ||
            !hhknnmkj.equals(uiBean.getVhhkshhknnmkj()) ||
            !hhknnmkjkhukakbn.eq(uiBean.getVhhkshhknnmkjkhukakbn())) {

            uiBean.setHhkhenkouumu(C_UmuKbn.ARI);
        }

        BizDate sysDate = BizDate.getSysDate();

        if (C_UmuKbn.ARI.eq(uiBean.getKykhenkouumu()) ||
            C_UmuKbn.ARI.eq(uiBean.getHhkhenkouumu())) {

            if (BizUtil.isBlank(kyknmkj) && (!C_KjkhukaKbn.BLNK.eq(kyknmkjkhukakbn))) {
                throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_KYKNMKJ);
            }

            if (C_Kyksei.HJNKYK.eq(kyksei)) {
                if (kykseiymd != null) {
                    throw new BizLogicException(MessageId.EBC0007, DISP_S_NEW_KYKSEIYMD);
                }

                if ((!C_Tdk.KYN.eq(kkkyktdk)) && (!C_Tdk.SONOTA.eq(kkkyktdk))) {
                    throw new BizLogicException(MessageId.EIA0068,
                        uiBean.getNewkkkyktdk().getContent());
                }

                if (C_HjndaiykKbn.SONOTA.eq(hjndaiykkbn)) {
                    if (BizUtil.isBlank(hjndaiyknm)) {
                        throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_HJNDAIYKNM);
                    }
                } else {
                    if (!BizUtil.isBlank(hjndaiyknm)) {
                        throw new BizLogicException(MessageId.EBC0007, DISP_S_NEW_HJNDAIYKNM);
                    }
                }

            } else {
                if (kykseiymd == null) {
                    throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_KYKSEIYMD);
                }

                if (BizDateUtil.compareYmd(kykseiymd, sysDate) == BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EIA0045);
                }

                if (C_Tdk.HONNIN.eq(kkkyktdk)) {
                    if (!kyknmkn.equals(hhknnmkn)) {
                        throw new BizLogicException(MessageId.EIA0057, DISP_S_NEW_KYKNMKN, DISP_S_NEW_HHKNNMKN);
                    }
                    if (!kyknmkj.equals(hhknnmkj)) {
                        throw new BizLogicException(MessageId.EIA0057, DISP_S_NEW_KYKNMKJ, DISP_S_NEW_HHKNNMKJ);
                    }
                    if (!kyknmkjkhukakbn.eq(hhknnmkjkhukakbn)) {
                        throw new BizLogicException(MessageId.EIA0057, DISP_N_NEW_KYKNMKJKHUKAKBN,
                            DISP_N_NEW_HHKNNMKJKHUKAKBN);
                    }
                    if (BizDateUtil.compareYmd(kykseiymd, hhknseiymd) != BizDateUtil.COMPARE_EQUAL) {
                        throw new BizLogicException(MessageId.EIA0057, DISP_S_NEW_KYKSEIYMD, "被保険者生年月日");
                    }
                    if (!kyksei.getValue().equals(hhknsei.getValue())) {
                        throw new BizLogicException(MessageId.EIA0057, DISP_N_NEW_KYKSEI, "被保険者性別");
                    }
                }

                if (!C_HjndaiykKbn.BLNK.eq(hjndaiykkbn)) {
                    throw new BizLogicException(MessageId.EBC0007, DISP_N_NEW_HJNDAIYKKBN);
                }
                if (!BizUtil.isBlank(hjndaiyknm)) {
                    throw new BizLogicException(MessageId.EBC0007, DISP_S_NEW_HJNDAIYKNM);
                }
                if (!BizUtil.isBlank(hjndainmkn)) {
                    throw new BizLogicException(MessageId.EBC0007, DISP_S_NEW_HJNDAINMKN);
                }
                if (!BizUtil.isBlank(hjndainmkj)) {
                    throw new BizLogicException(MessageId.EBC0007, DISP_S_NEW_HJNDAINMKJ);
                }
            }
        }

        kkkyktdkMenber = kkkyktdk;
        kyknmknMenber = kyknmkn;
    }

    private void checkHnkjiyuu() {

        if ((C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()) ||
            C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) &&
            C_UmuKbn.NONE.eq(uiBean.getKykhenkouumu())) {

            throw new BizLogicException(MessageId.EIA0044, KEIYAKUSYAJOUHOU);
        }
    }

    private void checkHhkn() {
        String hhknnmkj;
        C_KjkhukaKbn hhknnmkjkhukakbn;

        if (BizUtil.isBlank(uiBean.getNewhhknnmkj()) &&
            C_KjkhukaKbn.BLNK.eq(uiBean.getNewhhknnmkjkhukakbn())) {
            hhknnmkj = uiBean.getVhhkshhknnmkj();
            hhknnmkjkhukakbn = uiBean.getVhhkshhknnmkjkhukakbn();
        } else {
            hhknnmkj = uiBean.getNewhhknnmkj();
            hhknnmkjkhukakbn = uiBean.getNewhhknnmkjkhukakbn();

        }

        if (C_UmuKbn.ARI.eq(uiBean.getHhkhenkouumu())) {
            if (BizUtil.isBlank(hhknnmkj) && !C_KjkhukaKbn.BLNK.eq(hhknnmkjkhukakbn)) {
                throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_HHKNNMKJ);
            }
        }
    }

    private void checkNkukt() {

        C_UktKbn cUktKbn = null;

        if (C_UmuKbn.ARI.eq(uiBean.getNkhknumu())) {

            if (C_UktKbn.BLNK.eq(uiBean.getNewnenkinuktkbn())) {

                cUktKbn = uiBean.getVnkuknenkinuktkbn();
            }
            else {

                cUktKbn = uiBean.getNewnenkinuktkbn();
            }

            if (!cUktKbn.eq(uiBean.getVnkuknenkinuktkbn())) {

                uiBean.setNkukthenkouumu(C_UmuKbn.ARI);

            }

            if (C_UktKbn.BLNK.eq(uiBean.getNewnenkinuktkbn())) {

                if (C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()) ||
                    C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {

                    if (C_UktKbn.KYK.eq(uiBean.getVnkuknenkinuktkbn())) {

                        throw new BizLogicException(MessageId.EIF1129, NENKINUKT, NENKINUKT);
                    }
                }
            }
        }

        uktKbnMenber = cUktKbn;
    }

    private void checkKzukt() {
        String keizknkuktnmkn = null;
        String keizknkuktnmkj = null;
        BizDate kzuktseiymd = null;
        C_Tdk keizknkukttdk = null;

        if (C_UmuKbn.ARI.eq(uiBean.getNkhknumu())) {
            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getKzuktkaijyokbn())) {
                uiBean.setKznkukthenkouumu(C_UmuKbn.ARI);

            } else {
                if (BizUtil.isBlank(uiBean.getNewkzuktnmkn())) {
                    keizknkuktnmkn = uiBean.getKeizknkuktnmkn();
                } else {
                    keizknkuktnmkn = uiBean.getNewkzuktnmkn();
                }

                if (BizUtil.isBlank(uiBean.getNewkzuktnmkj())) {
                    keizknkuktnmkj = uiBean.getKeizknkuktnmkj();
                } else {
                    keizknkuktnmkj = uiBean.getNewkzuktnmkj();
                }

                if (uiBean.getNewkzuktseiymd() == null) {
                    kzuktseiymd = uiBean.getKeizknenkiuktseiymd();
                } else {
                    kzuktseiymd = uiBean.getNewkzuktseiymd();
                }

                if (C_Tdk.BLNK.eq(uiBean.getNewkzukttdk())) {

                    keizknkukttdk = uiBean.getKeizknenkinukttdk();
                } else {
                    keizknkukttdk = uiBean.getNewkzukttdk();
                }

                if (!keizknkuktnmkn.equals(uiBean.getKeizknkuktnmkn()) ||
                    !keizknkuktnmkj.equals(uiBean.getKeizknkuktnmkj()) ||
                    BizDateUtil.compareYmd(kzuktseiymd, uiBean.getKeizknenkiuktseiymd()) != BizDateUtil.COMPARE_EQUAL ||
                    !keizknkukttdk.eq(uiBean.getKeizknenkinukttdk())) {

                    uiBean.setKznkukthenkouumu(C_UmuKbn.ARI);
                }

                BizDate sysDate = BizDate.getSysDate();
                if (C_UmuKbn.ARI.eq(uiBean.getKznkukthenkouumu())) {

                    if (BizUtil.isBlank(keizknkuktnmkn)) {
                        throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_KZUKTNMKN);
                    }
                    if (BizUtil.isBlank(keizknkuktnmkj)) {
                        throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_KZUKTNMKJ);
                    }
                    if (kzuktseiymd == null) {
                        throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_KZUKTSEIYMD);
                    }
                    if (C_Tdk.BLNK.eq(keizknkukttdk)) {
                        throw new BizLogicException(MessageId.EBC0043, DISP_N_NEW_KZUKTTDK);
                    }

                    if (BizDateUtil.compareYmd(kzuktseiymd, sysDate) == BizDateUtil.COMPARE_GREATER) {
                        throw new BizLogicException(MessageId.EIA0037, DISP_S_NEW_KZUKTSEIYMD);
                    }
                }
            }
        }
    }

    private void checkSbHenkanUkt() {
        String sbhenkanuktnmkn = null;
        String sbhenkanuktnmkj = null;
        BizDate sbhkknuktseiymd = null;
        C_Tdk sbhenkanukttdk = null;

        if (!BizUtil.isBlank(uiBean.getSbhenkanuktnmkn())) {
            if (BizUtil.isBlank(uiBean.getNewsbhenkanuktnmkn())) {
                sbhenkanuktnmkn = uiBean.getSbhenkanuktnmkn();
            } else {
                sbhenkanuktnmkn = uiBean.getNewsbhenkanuktnmkn();
            }

            if (BizUtil.isBlank(uiBean.getNewsbhenkanuktnmkj())) {
                sbhenkanuktnmkj = uiBean.getSbhenkanuktnmkj();
            } else {
                sbhenkanuktnmkj = uiBean.getNewsbhenkanuktnmkj();
            }

            if (uiBean.getNewsbhenkanuktseiymd() == null) {
                sbhkknuktseiymd = uiBean.getSibouhenkankinuktseiymd();
            } else {
                sbhkknuktseiymd = uiBean.getNewsbhenkanuktseiymd();
            }

            if (C_Tdk.BLNK.eq(uiBean.getNewsbhenkanukttdk())) {

                sbhenkanukttdk = uiBean.getSibouhenkankinukttdk();
            } else {
                sbhenkanukttdk = uiBean.getNewsbhenkanukttdk();
            }

            if (!sbhenkanuktnmkn.equals(uiBean.getSbhenkanuktnmkn())
                ||
                !sbhenkanuktnmkj.equals(uiBean.getSbhenkanuktnmkj())
                ||
                BizDateUtil.compareYmd(sbhkknuktseiymd, uiBean.getSibouhenkankinuktseiymd()) != BizDateUtil.COMPARE_EQUAL
                ||
                !sbhenkanukttdk.eq(uiBean.getSibouhenkankinukttdk())) {

                uiBean.setSbhkknukthenkouumu(C_UmuKbn.ARI);
            }

            BizDate sysDate = BizDate.getSysDate();
            if (C_UmuKbn.ARI.eq(uiBean.getSbhkknukthenkouumu())) {

                if (BizUtil.isBlank(sbhenkanuktnmkn)) {
                    throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_SBHENKANUKTNMKN);
                }
                if (BizUtil.isBlank(sbhenkanuktnmkj)) {
                    throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_SBHENKANUKTNMKJ);
                }
                if (sbhkknuktseiymd == null) {
                    throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_SBHENKANUKTSEIYMD);
                }
                if (C_Tdk.BLNK.eq(sbhenkanukttdk)) {
                    throw new BizLogicException(MessageId.EBC0043, DISP_N_NEW_SBHENKANUKTTDK);
                }

                if (BizDateUtil.compareYmd(sbhkknuktseiymd, sysDate) == BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EIA0037, DISP_S_NEW_SBHENKANUKTSEIYMD);
                }
            }
        }
    }

    private void checkSbukt() {

        String sbuktnmkn1 = uiBean.getSbuktnmkn1();
        String sbuktnmkn2 = uiBean.getSbuktnmkn2();
        String sbuktnmkn3 = uiBean.getSbuktnmkn3();
        String sbuktnmkn4 = uiBean.getSbuktnmkn4();
        String sbuktnmkj1 = uiBean.getSbuktnmkj1();
        String sbuktnmkj2 = uiBean.getSbuktnmkj2();
        String sbuktnmkj3 = uiBean.getSbuktnmkj3();
        String sbuktnmkj4 = uiBean.getSbuktnmkj4();
        C_KjkhukaKbn sbuktnmkjhukakbn1 = uiBean.getSbuktnmkjhukakbn1();
        C_KjkhukaKbn sbuktnmkjhukakbn2 = uiBean.getSbuktnmkjhukakbn2();
        C_KjkhukaKbn sbuktnmkjhukakbn3 = uiBean.getSbuktnmkjhukakbn3();
        C_KjkhukaKbn sbuktnmkjhukakbn4 = uiBean.getSbuktnmkjhukakbn4();
        BizDate sbuktseiymd1 = uiBean.getSbuktseiymd1();
        BizDate sbuktseiymd2 = uiBean.getSbuktseiymd2();
        BizDate sbuktseiymd3 = uiBean.getSbuktseiymd3();
        BizDate sbuktseiymd4 = uiBean.getSbuktseiymd4();
        BizNumber sbuktbnwari1 = uiBean.getNewsbuktbnwari1();
        BizNumber sbuktbnwari2 = uiBean.getNewsbuktbnwari2();
        BizNumber sbuktbnwari3 = uiBean.getNewsbuktbnwari3();
        BizNumber sbuktbnwari4 = uiBean.getNewsbuktbnwari4();

        C_UktKbn newSbuktkbn1 = uiBean.getSbuktkbn1();
        String newSbuktnmkn1 = uiBean.getSbuktnmkn1();
        String newSbuktnmkn2 = uiBean.getSbuktnmkn2();
        String newSbuktnmkn3 = uiBean.getSbuktnmkn3();
        String newSbuktnmkn4 = uiBean.getSbuktnmkn4();
        String newSbuktnmkj1 = uiBean.getSbuktnmkj1();
        String newSbuktnmkj2 = uiBean.getSbuktnmkj2();
        String newSbuktnmkj3 = uiBean.getSbuktnmkj3();
        String newSbuktnmkj4 = uiBean.getSbuktnmkj4();
        C_KjkhukaKbn newSbuktnmkjhukakbn1 = uiBean.getSbuktnmkjhukakbn1();
        C_KjkhukaKbn newSbuktnmkjhukakbn2 = uiBean.getSbuktnmkjhukakbn2();
        C_KjkhukaKbn newSbuktnmkjhukakbn3 = uiBean.getSbuktnmkjhukakbn3();
        C_KjkhukaKbn newSbuktnmkjhukakbn4 = uiBean.getSbuktnmkjhukakbn4();
        BizDate newSbuktseiymd1 = uiBean.getSbuktseiymd1();
        BizDate newSbuktseiymd2 = uiBean.getSbuktseiymd2();
        BizDate newSbuktseiymd3 = uiBean.getSbuktseiymd3();
        BizDate newSbuktseiymd4 = uiBean.getSbuktseiymd4();
        BizNumber newSbuktbnwari1 = uiBean.getNewsbuktbnwari1();
        BizNumber newSbuktbnwari2 = uiBean.getNewsbuktbnwari2();
        BizNumber newSbuktbnwari3 = uiBean.getNewsbuktbnwari3();
        BizNumber newSbuktbnwari4 = uiBean.getNewsbuktbnwari4();

        C_UktKbn dispSbuktkbn1 = uiBean.getVshktdispsbuktkbn1();
        String dispsbuktnmkn1 = uiBean.getVshktdispsbuktnmkn1();
        String dispsbuktnmkn2 = uiBean.getVshktdispsbuktnmkn2();
        String dispsbuktnmkn3 = uiBean.getVshktdispsbuktnmkn3();
        String dispsbuktnmkn4 = uiBean.getVshktdispsbuktnmkn4();
        String dispsbuktnmkj1 = uiBean.getVshktdispsbuktnmkj1();
        String dispsbuktnmkj2 = uiBean.getVshktdispsbuktnmkj2();
        String dispsbuktnmkj3 = uiBean.getVshktdispsbuktnmkj3();
        String dispsbuktnmkj4 = uiBean.getVshktdispsbuktnmkj4();
        C_KjkhukaKbn dispSbuktnmkjhukakbn1 = uiBean.getVshktdispsbuktnmkjhukakbn1();
        C_KjkhukaKbn dispSbuktnmkjhukakbn2 = uiBean.getVshktdispsbuktnmkjhukakbn2();
        C_KjkhukaKbn dispSbuktnmkjhukakbn3 = uiBean.getVshktdispsbuktnmkjhukakbn3();
        C_KjkhukaKbn dispSbuktnmkjhukakbn4 = uiBean.getVshktdispsbuktnmkjhukakbn4();
        BizDate dispsbuktseiymd1 = uiBean.getVshktdispsbuktseiymd1();
        BizDate dispsbuktseiymd2 = uiBean.getVshktdispsbuktseiymd2();
        BizDate dispsbuktseiymd3 = uiBean.getVshktdispsbuktseiymd3();
        BizDate dispsbuktseiymd4 = uiBean.getVshktdispsbuktseiymd4();
        BizNumber dispsbuktbnwari1 = NullToOptional(uiBean.getVshktdispsbuktbnwari1());
        BizNumber dispsbuktbnwari2 = NullToOptional(uiBean.getVshktdispsbuktbnwari2());
        BizNumber dispsbuktbnwari3 = NullToOptional(uiBean.getVshktdispsbuktbnwari3());
        BizNumber dispsbuktbnwari4 = NullToOptional(uiBean.getVshktdispsbuktbnwari4());

        BizNumber bnwariSum = BizNumber.ZERO;
        int sbuktnin = 0;
        C_UmuKbn bnwariSetteiumukbn = C_UmuKbn.NONE;
        C_UmuKbn sbukt1henkouumu = C_UmuKbn.NONE;
        C_UmuKbn sbukt2henkouumu = C_UmuKbn.NONE;
        C_UmuKbn sbukt3henkouumu = C_UmuKbn.NONE;
        C_UmuKbn sbukt4henkouumu = C_UmuKbn.NONE;
        C_UmuKbn sbukt1inputumu = C_UmuKbn.NONE;
        C_UmuKbn sbukt2inputumu = C_UmuKbn.NONE;
        C_UmuKbn sbukt3inputumu = C_UmuKbn.NONE;
        C_UmuKbn sbukt4inputumu = C_UmuKbn.NONE;

        if (C_UktKbn.TOKUTEIMEIGI.eq(dispSbuktkbn1)) {
            if (BizUtil.isBlank(newSbuktnmkn1)) {
                sbuktnmkn1 = dispsbuktnmkn1;
            }
            if (BizUtil.isBlank(newSbuktnmkj1) && C_KjkhukaKbn.BLNK.eq(newSbuktnmkjhukakbn1)) {
                sbuktnmkj1 = dispsbuktnmkj1;
                sbuktnmkjhukakbn1 = dispSbuktnmkjhukakbn1;
            }
            if (newSbuktseiymd1 == null) {
                sbuktseiymd1 = dispsbuktseiymd1;
            }
        }

        if (newSbuktbnwari1.isOptional()) {
            if (!dispsbuktbnwari1.isOptional()) {
                sbuktbnwari1 = dispsbuktbnwari1;
            }
            if (dispsbuktbnwari1.isOptional()) {
                sbuktbnwari1 = BizNumber.ZERO;
            }
        }

        if (!BizUtil.isBlank(dispsbuktnmkn2)) {
            if (BizUtil.isBlank(newSbuktnmkn2)) {
                sbuktnmkn2 = dispsbuktnmkn2;
            }
            if (BizUtil.isBlank(newSbuktnmkj2) && C_KjkhukaKbn.BLNK.eq(newSbuktnmkjhukakbn2)) {
                sbuktnmkj2 = dispsbuktnmkj2;
                sbuktnmkjhukakbn2 = dispSbuktnmkjhukakbn2;
            }
            if (newSbuktseiymd2 == null) {
                sbuktseiymd2 = dispsbuktseiymd2;
            }

            if (newSbuktbnwari2.isOptional()) {

                if (!dispsbuktbnwari2.isOptional()) {

                    sbuktbnwari2 = dispsbuktbnwari2;
                }
                if (dispsbuktbnwari2.isOptional()) {

                    sbuktbnwari2 = BizNumber.ZERO;
                }
            }
        }

        if (BizUtil.isBlank(dispsbuktnmkn2)) {

            if (newSbuktbnwari2.isOptional()) {

                if (dispsbuktbnwari2.isOptional()) {

                    sbuktbnwari2 = BizNumber.ZERO;
                }
            }
        }

        if (!BizUtil.isBlank(dispsbuktnmkn3)) {
            if (BizUtil.isBlank(newSbuktnmkn3)) {
                sbuktnmkn3 = dispsbuktnmkn3;
            }
            if (BizUtil.isBlank(newSbuktnmkj3) && C_KjkhukaKbn.BLNK.eq(newSbuktnmkjhukakbn3)) {
                sbuktnmkj3 = dispsbuktnmkj3;
                sbuktnmkjhukakbn3 = dispSbuktnmkjhukakbn3;
            }
            if (newSbuktseiymd3 == null) {
                sbuktseiymd3 = dispsbuktseiymd3;
            }

            if (newSbuktbnwari3.isOptional()) {

                if (!dispsbuktbnwari3.isOptional()) {

                    sbuktbnwari3 = dispsbuktbnwari3;
                }
                if (dispsbuktbnwari3.isOptional()) {

                    sbuktbnwari3 = BizNumber.ZERO;
                }
            }
        }

        if (BizUtil.isBlank(dispsbuktnmkn3)) {

            if (newSbuktbnwari3.isOptional()) {

                if (dispsbuktbnwari3.isOptional()) {

                    sbuktbnwari3 = BizNumber.ZERO;
                }
            }
        }

        if (!BizUtil.isBlank(dispsbuktnmkn4)) {
            if (BizUtil.isBlank(newSbuktnmkn4)) {
                sbuktnmkn4 = dispsbuktnmkn4;
            }
            if (BizUtil.isBlank(newSbuktnmkj4) && C_KjkhukaKbn.BLNK.eq(newSbuktnmkjhukakbn4)) {
                sbuktnmkj4 = dispsbuktnmkj4;
                sbuktnmkjhukakbn4 = dispSbuktnmkjhukakbn4;
            }
            if (newSbuktseiymd4 == null) {
                sbuktseiymd4 = dispsbuktseiymd4;
            }

            if (newSbuktbnwari4.isOptional()) {

                if (!dispsbuktbnwari4.isOptional()) {

                    sbuktbnwari4 = dispsbuktbnwari4;
                }
                if (dispsbuktbnwari4.isOptional()) {

                    sbuktbnwari4 = BizNumber.ZERO;
                }
            }
        }

        if (BizUtil.isBlank(dispsbuktnmkn4)) {

            if (newSbuktbnwari4.isOptional()) {

                if (dispsbuktbnwari4.isOptional()) {

                    sbuktbnwari4 = BizNumber.ZERO;
                }
            }
        }

        if (!C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn1())) {

            if (!C_UktKbn.BLNK.eq(newSbuktkbn1)
                || !BizUtil.isBlank(sbuktnmkn1)
                || !BizUtil.isBlank(sbuktnmkj1)
                || !C_KjkhukaKbn.BLNK.eq(sbuktnmkjhukakbn1)
                || sbuktseiymd1 != null
                || !sbuktbnwari1.isZeroOrOptional()) {

                sbuktnin = sbuktnin + 1;

                if (sbuktbnwari1.isZeroOrOptional()) {

                    bnwariSetteiumukbn = C_UmuKbn.ARI;
                }
            }
            bnwariSum = sbuktbnwari1.add(bnwariSum);
        }

        if (!C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn2())) {

            if (!BizUtil.isBlank(sbuktnmkn2)
                || !BizUtil.isBlank(sbuktnmkj2)
                || !C_KjkhukaKbn.BLNK.eq(sbuktnmkjhukakbn2)
                || sbuktseiymd2 != null
                || !sbuktbnwari2.isZeroOrOptional()) {

                sbuktnin = sbuktnin + 1;

                if (sbuktbnwari2.isZeroOrOptional()) {

                    bnwariSetteiumukbn = C_UmuKbn.ARI;
                }
            }

            bnwariSum = sbuktbnwari2.add(bnwariSum);
        }

        if (!C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn3())) {

            if (!BizUtil.isBlank(sbuktnmkn3)
                || !BizUtil.isBlank(sbuktnmkj3)
                || !C_KjkhukaKbn.BLNK.eq(sbuktnmkjhukakbn3)
                || sbuktseiymd3 != null
                || !sbuktbnwari3.isZeroOrOptional()) {

                sbuktnin = sbuktnin + 1;

                if (sbuktbnwari3.isZeroOrOptional()) {

                    bnwariSetteiumukbn = C_UmuKbn.ARI;
                }
            }

            bnwariSum = sbuktbnwari3.add(bnwariSum);
        }

        if (!C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn4())) {

            if (!BizUtil.isBlank(sbuktnmkn4)
                || !BizUtil.isBlank(sbuktnmkj4)
                || !C_KjkhukaKbn.BLNK.eq(sbuktnmkjhukakbn4)
                || sbuktseiymd4 != null
                || !sbuktbnwari4.isZeroOrOptional()) {

                sbuktnin = sbuktnin + 1;

                if (sbuktbnwari4.isZeroOrOptional()) {

                    bnwariSetteiumukbn = C_UmuKbn.ARI;
                }
            }

            bnwariSum = sbuktbnwari4.add(bnwariSum);
        }

        if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn1())) {

            sbukt1henkouumu = C_UmuKbn.ARI;
        }
        else {

            if (!C_UktKbn.BLNK.eq(newSbuktkbn1)
                || !BizUtil.isBlank(newSbuktnmkn1)
                || !BizUtil.isBlank(newSbuktnmkj1)
                || !C_KjkhukaKbn.BLNK.eq(newSbuktnmkjhukakbn1)
                || newSbuktseiymd1 != null
                || !newSbuktbnwari1.isZeroOrOptional()) {

                sbukt1henkouumu = C_UmuKbn.ARI;
                sbukt1inputumu = C_UmuKbn.ARI;
                uiBean.setSbukt1inpumu(C_UmuKbn.ARI);
            }
        }

        if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn2())) {

            sbukt2henkouumu = C_UmuKbn.ARI;
        }
        else {

            if (!BizUtil.isBlank(newSbuktnmkn2)
                || !BizUtil.isBlank(newSbuktnmkj2)
                || newSbuktseiymd2 != null
                || !C_KjkhukaKbn.BLNK.eq(newSbuktnmkjhukakbn2)
                || newSbuktseiymd2 != null
                || !newSbuktbnwari2.isOptional()) {

                sbukt2henkouumu = C_UmuKbn.ARI;
                sbukt2inputumu = C_UmuKbn.ARI;
                uiBean.setSbukt2inpumu(C_UmuKbn.ARI);
            }
        }

        if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn3())) {

            sbukt3henkouumu = C_UmuKbn.ARI;
        }
        else {

            if (!BizUtil.isBlank(newSbuktnmkn3)
                || !BizUtil.isBlank(newSbuktnmkj3)
                || newSbuktseiymd3 != null
                || !C_KjkhukaKbn.BLNK.eq(newSbuktnmkjhukakbn3)
                || newSbuktseiymd3 != null
                || !newSbuktbnwari3.isOptional()) {

                sbukt3henkouumu = C_UmuKbn.ARI;
                sbukt3inputumu = C_UmuKbn.ARI;
                uiBean.setSbukt3inpumu(C_UmuKbn.ARI);
            }
        }

        if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn4())) {

            sbukt4henkouumu = C_UmuKbn.ARI;
        }
        else {

            if (!BizUtil.isBlank(newSbuktnmkn4)
                || !BizUtil.isBlank(newSbuktnmkj4)
                || newSbuktseiymd4 != null
                || !C_KjkhukaKbn.BLNK.eq(newSbuktnmkjhukakbn4)
                || newSbuktseiymd4 != null
                || !newSbuktbnwari4.isOptional()) {

                sbukt4henkouumu = C_UmuKbn.ARI;
                sbukt4inputumu = C_UmuKbn.ARI;
                uiBean.setSbukt4inpumu(C_UmuKbn.ARI);
            }
        }

        if (C_UmuKbn.ARI.eq(sbukt1henkouumu)
            || C_UmuKbn.ARI.eq(sbukt2henkouumu)
            || C_UmuKbn.ARI.eq(sbukt3henkouumu)
            || C_UmuKbn.ARI.eq(sbukt4henkouumu)
            || (uiBean.getSbuktnin() != null && uiBean.getSbuktnin().compareTo(uiBean.getVshktsbuktnin()) != 0)) {

            if (uiBean.getSbuktnin() == null) {

                throw new BizLogicException(MessageId.EBC1005);
            }

            if (Integer.valueOf(0).equals(uiBean.getSbuktnin())) {

                throw new BizLogicException(MessageId.EIC1004);
            }

            uiBean.setSbukthenkouumu(C_UmuKbn.ARI);

            if (uiBean.getSbuktnin() >= 5) {

                boolean sbuktExist = ((!C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn1()) &&
                    (!C_UktKbn.BLNK.eq(dispSbuktkbn1) ||
                        !BizUtil.isBlank(dispsbuktnmkn1) ||
                        !BizUtil.isBlank(dispsbuktnmkj1) ||
                        !C_KjkhukaKbn.BLNK.eq(dispSbuktnmkjhukakbn1) ||
                        dispsbuktseiymd1 != null ||
                        !dispsbuktbnwari1.isZeroOrOptional())) ||
                        (!C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn2()) &&
                            (!BizUtil.isBlank(dispsbuktnmkn2) ||
                                !BizUtil.isBlank(dispsbuktnmkj2) ||
                                !C_KjkhukaKbn.BLNK.eq(dispSbuktnmkjhukakbn2) ||
                                dispsbuktseiymd2 != null ||
                                !dispsbuktbnwari2.isZeroOrOptional())) ||
                                (!C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn3()) &&
                                    (!BizUtil.isBlank(dispsbuktnmkn3) ||
                                        !BizUtil.isBlank(dispsbuktnmkj3) ||
                                        !C_KjkhukaKbn.BLNK.eq(dispSbuktnmkjhukakbn3) ||
                                        dispsbuktseiymd3 != null ||
                                        !dispsbuktbnwari3.isZeroOrOptional())) ||
                                        (!C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn4()) &&
                                            (!BizUtil.isBlank(dispsbuktnmkn4) ||
                                                !BizUtil.isBlank(dispsbuktnmkj4) ||
                                                !C_KjkhukaKbn.BLNK.eq(dispSbuktnmkjhukakbn4) ||
                                                dispsbuktseiymd4 != null ||
                                                !dispsbuktbnwari4.isZeroOrOptional())));

                if (C_UmuKbn.ARI.eq(sbukt1inputumu)
                    || C_UmuKbn.ARI.eq(sbukt2inputumu)
                    || C_UmuKbn.ARI.eq(sbukt3inputumu)
                    || C_UmuKbn.ARI.eq(sbukt4inputumu)
                    || sbuktExist) {

                    throw new BizLogicException(MessageId.EIC1002);
                }
                if (sbuktnin != 0) {

                    throw new BizLogicException(MessageId.EIC1003);
                }
            }

            if (uiBean.getSbuktnin() <= 4) {

                if (uiBean.getSbuktnin().compareTo(sbuktnin) != 0) {

                    throw new BizLogicException(MessageId.EIC1003);
                }
            }

            if (C_UmuKbn.ARI.eq(sbukt1henkouumu) && !C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn1())) {

                if (C_UktKbn.BLNK.eq(newSbuktkbn1)) {

                    throw new BizLogicException(MessageId.EBC0043, DISP_N_SBUKTKBN);
                }

                if (C_UmuKbn.ARI.eq(sbukt1inputumu)) {

                    if (C_UktKbn.TOKUTEIMEIGI.eq(newSbuktkbn1)) {

                        if (BizUtil.isBlank(newSbuktnmkn1)) {

                            throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTNMKN);
                        }
                        if (BizUtil.isBlank(newSbuktnmkj1)) {

                            throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTNMKJ);
                        }
                        if (newSbuktseiymd1 == null) {

                            throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTSEIYMD);
                        }
                    }

                    else {

                        if (!BizUtil.isBlank(newSbuktnmkn1)) {

                            throw new BizLogicException(MessageId.EBC0007, DISP_S_SBUKTNMKN);
                        }
                        if (!BizUtil.isBlank(newSbuktnmkj1)) {

                            throw new BizLogicException(MessageId.EBC0007, DISP_S_SBUKTNMKJ);
                        }
                        if (!C_KjkhukaKbn.BLNK.eq(newSbuktnmkjhukakbn1)) {

                            throw new BizLogicException(MessageId.EBC0007, DISP_N_SBUKTNMKJHUKAKBN);
                        }
                        if (newSbuktseiymd1 != null) {

                            throw new BizLogicException(MessageId.EBC0007, DISP_S_SBUKTSEIYMD);
                        }
                        if (uiBean.getSbuktnin() > 1) {
                            throw new BizLogicException(MessageId.EIF1070);
                        }
                    }

                    if (newSbuktbnwari1.isOptional()) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTBNWARI);
                    }

                    if (newSbuktseiymd1 != null) {

                        BizDate sbuktseiymd = newSbuktseiymd1;

                        if (BizDateUtil.compareYmd(sbuktseiymd, BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {

                            throw new BizLogicException(MessageId.EIA0037, DISP_S_SBUKTSEIYMD);
                        }
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(sbukt2henkouumu) && !C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn2())) {

                if (C_UmuKbn.ARI.eq(sbukt2inputumu)) {

                    if (BizUtil.isBlank(newSbuktnmkn2)) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTNMKN);
                    }
                    if (BizUtil.isBlank(newSbuktnmkj2)) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTNMKJ);
                    }
                    if (newSbuktseiymd2 == null) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTSEIYMD);
                    }
                    if (newSbuktbnwari2.isOptional()) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTBNWARI);
                    }
                    if (newSbuktseiymd2 != null) {

                        BizDate sbuktseiymd = newSbuktseiymd2;

                        if (BizDateUtil.compareYmd(sbuktseiymd, BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {

                            throw new BizLogicException(MessageId.EIA0037, DISP_S_SBUKTSEIYMD);
                        }
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(sbukt3henkouumu) && !C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn3())) {

                if (C_UmuKbn.ARI.eq(sbukt3inputumu)) {

                    if (BizUtil.isBlank(newSbuktnmkn3)) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTNMKN);
                    }
                    if (BizUtil.isBlank(newSbuktnmkj3)) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTNMKJ);
                    }
                    if (newSbuktseiymd3 == null) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTSEIYMD);
                    }
                    if (newSbuktbnwari3.isOptional()) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTBNWARI);
                    }
                    if (newSbuktseiymd3 != null) {

                        BizDate sbuktseiymd = newSbuktseiymd3;

                        if (BizDateUtil.compareYmd(sbuktseiymd, BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {

                            throw new BizLogicException(MessageId.EIA0037, DISP_S_SBUKTSEIYMD);
                        }
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(sbukt4henkouumu) && !C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn4())) {

                if (C_UmuKbn.ARI.eq(sbukt4inputumu)) {

                    if (BizUtil.isBlank(newSbuktnmkn4)) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTNMKN);
                    }
                    if (BizUtil.isBlank(newSbuktnmkj4)) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTNMKJ);
                    }
                    if (newSbuktseiymd4 == null) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTSEIYMD);
                    }
                    if (newSbuktbnwari4.isOptional()) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_S_SBUKTBNWARI);
                    }
                    if (newSbuktseiymd4 != null) {

                        BizDate sbuktseiymd = newSbuktseiymd4;

                        if (BizDateUtil.compareYmd(sbuktseiymd, BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {

                            throw new BizLogicException(MessageId.EIA0037, DISP_S_SBUKTSEIYMD);
                        }
                    }
                }
            }

            C_Tdk kkkyktdk = null;

            if (C_UmuKbn.ARI.eq(uiBean.getKyktdkhnkumu())) {

                kkkyktdk = uiBean.getNewkkkyktdk();
            }
            else {
                kkkyktdk = uiBean.getVkykskkkyktdk();
            }

            if (C_UktKbn.KYK.eq(newSbuktkbn1) && C_Tdk.HONNIN.eq(kkkyktdk)) {

                throw new BizLogicException(MessageId.EBC1002);
            }
            if (C_UktKbn.HHKN.eq(newSbuktkbn1) && C_Tdk.HONNIN.eq(kkkyktdk)) {

                throw new BizLogicException(MessageId.EBC1003);
            }

            if (bnwariSum.compareTo(BizNumber.valueOf(100)) != 0 && bnwariSum.compareTo(BizNumber.valueOf(0)) != 0) {

                throw new BizLogicException(MessageId.EIA0160);
            }

            if (C_UmuKbn.ARI.eq(bnwariSetteiumukbn) && bnwariSum.compareTo(BizNumber.valueOf(100)) == 0) {

                throw new BizLogicException(MessageId.EIA0160);
            }
            if (sbuktnin == 1 && bnwariSum.compareTo(BizNumber.valueOf(100)) != 0) {

                throw new BizLogicException(MessageId.EIA0160);
            }
        }
        else {

            if (C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()) ||
                C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {

                if (C_UktKbn.KYK.eq(dispSbuktkbn1)) {

                    throw new BizLogicException(MessageId.EIF1129, SBUKTNIN, SBUKTNIN);
                }
            }

            if (uiBean.getSbuktnin() != null) {
                if (Integer.valueOf(0).equals(uiBean.getSbuktnin())) {
                    throw new BizLogicException(MessageId.EIC1004);
                }
                if (Integer.valueOf(4) >= uiBean.getSbuktnin()
                    && uiBean.getSbuktnin().compareTo(sbuktnin) != 0) {
                    throw new BizLogicException(MessageId.EIC1003);
                }
                if (!uiBean.getSbuktnin().equals(uiBean.getVshktsbuktnin())) {
                    uiBean.setSbukthenkouumu(C_UmuKbn.ARI);
                }
            }
        }
    }

    private void checkStdrsk() {

        C_UktKbn newStdrskkbn = uiBean.getNewstdruktkbn();
        String newStdrsknmkn = uiBean.getNewstdrsknmkn();
        String newStdrsknmkj = uiBean.getNewstdrsknmkj();
        C_KjkhukaKbn newStdrsknmkjhukakbn = uiBean.getNewstdrsknmkjhukakbn();
        BizDate newStdrskseiymd = uiBean.getNewstdrskseiymd();
        C_UktKbn sksiteidruktkbn = uiBean.getVstsksiteidruktkbn();

        C_UktKbn sbuktkbn = null;

        if (C_UktKbn.BLNK.eq(uiBean.getSbuktkbn1())) {

            sbuktkbn = uiBean.getVshktdispsbuktkbn1();
        }
        else {

            sbuktkbn = uiBean.getSbuktkbn1();
        }

        C_UktKbn stdruktkbn = null;
        if (C_UktKbn.BLNK.eq(newStdrskkbn)) {
            stdruktkbn = sksiteidruktkbn;
        } else {
            stdruktkbn = newStdrskkbn;
        }

        String hhknnmkn;
        if (BizUtil.isBlank(uiBean.getNewhhknnmkn())) {
            hhknnmkn = uiBean.getVhhkshhknnmkn();
        } else {
            hhknnmkn = uiBean.getNewhhknnmkn();
        }

        String hhknnmkj;
        if (BizUtil.isBlank(uiBean.getNewhhknnmkj())) {
            hhknnmkj = uiBean.getVhhkshhknnmkj();
        } else {
            hhknnmkj = uiBean.getNewhhknnmkj();
        }

        if (C_UmuKbn.ARI.eq(uiBean.getStdrsktkyhkumu())) {

            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())
                || !C_UktKbn.BLNK.eq(newStdrskkbn)
                || !BizUtil.isBlank(newStdrsknmkn)
                || !BizUtil.isBlank(newStdrsknmkj)
                || !C_KjkhukaKbn.BLNK.eq(newStdrsknmkjhukakbn)
                || newStdrskseiymd != null) {

                uiBean.setStdrskhenkouumu(C_UmuKbn.ARI);

                if (!C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())) {

                    if (C_UktKbn.BLNK.eq(newStdrskkbn)) {

                        throw new BizLogicException(MessageId.EBC0043, DISP_N_STDRSKKBN);
                    }
                    if (C_UktKbn.TOKUTEIMEIGI.eq(newStdrskkbn)) {

                        if (BizUtil.isBlank(newStdrsknmkn)) {
                            throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_STDRSKNMKN);
                        }
                        if (BizUtil.isBlank(newStdrsknmkj)) {

                            throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_STDRSKNMKJ);
                        }
                        if (newStdrskseiymd == null) {

                            throw new BizLogicException(MessageId.EBC0043, DISP_S_NEW_STDRSKSEIYMD);
                        }
                    }
                    if (!C_UktKbn.TOKUTEIMEIGI.eq(newStdrskkbn)) {

                        if (!BizUtil.isBlank(newStdrsknmkn)) {
                            throw new BizLogicException(MessageId.EBC0007, DISP_S_NEW_STDRSKNMKN);
                        }

                        if (!BizUtil.isBlank(newStdrsknmkj)) {

                            throw new BizLogicException(MessageId.EBC0007, DISP_S_NEW_STDRSKNMKJ);
                        }

                        if (!C_KjkhukaKbn.BLNK.eq(newStdrsknmkjhukakbn)) {

                            throw new BizLogicException(MessageId.EBC0007, DISP_N_STDRSKNMKJHUKAKBN);
                        }

                        if (newStdrskseiymd != null) {

                            throw new BizLogicException(MessageId.EBC0007, DISP_S_NEW_STDRSKSEIYMD);
                        }
                    }
                }

                if (C_UktKbn.TOUROKUKAZOKU1.eq(newStdrskkbn) && C_UmuKbn.NONE.eq(uiBean.getVtrkkzktrkkzkumukbn1())) {

                    throw new BizLogicException(MessageId.EIA1068, TRKKZK1);
                }

                if (C_UktKbn.TOUROKUKAZOKU2.eq(newStdrskkbn) && C_UmuKbn.NONE.eq(uiBean.getVtrkkzktrkkzkumukbn2())) {

                    throw new BizLogicException(MessageId.EIA1068, TRKKZK2);
                }

                C_Tdk kyktdkhnkumu = null;

                if (C_UmuKbn.ARI.eq(uiBean.getKyktdkhnkumu())) {

                    kyktdkhnkumu = uiBean.getNewkkkyktdk();
                }
                else {

                    kyktdkhnkumu = uiBean.getVkykskkkyktdk();
                }

                if (C_UktKbn.KYK.eq(newStdrskkbn) && C_Tdk.HONNIN.eq(kyktdkhnkumu)) {

                    throw new BizLogicException(MessageId.EBC1001);
                }

                Integer sbuktnin = 0;

                if (uiBean.getSbuktnin() == null) {

                    sbuktnin = uiBean.getVshktsbuktnin();
                }
                else {

                    sbuktnin = uiBean.getSbuktnin();
                }

                if (C_UktKbn.SBUK.eq(newStdrskkbn) && sbuktnin >= 2) {

                    throw new BizLogicException(MessageId.EBC1004);
                }

                if (C_UktKbn.SBUK.eq(newStdrskkbn) && C_UktKbn.SOUZOKUNIN.eq(sbuktkbn)) {

                    throw new BizLogicException(MessageId.EBC1006);
                }
            }
            else {
                C_Tdk kkkyktdk = null;
                if (C_UmuKbn.ARI.eq(uiBean.getKyktdkhnkumu())) {
                    kkkyktdk = uiBean.getNewkkkyktdk();
                }
                else {
                    kkkyktdk = uiBean.getVkykskkkyktdk();
                }

                if (C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()) ||
                    C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {

                    if (C_UktKbn.KYK.eq(sksiteidruktkbn)) {

                        throw new BizLogicException(MessageId.EIF1129, HHKNDAIRI, HHKNDAIRI);
                    }
                }

                if (C_UktKbn.KYK.eq(sksiteidruktkbn) && C_Tdk.HONNIN.eq(kkkyktdk)) {

                    throw new BizLogicException(MessageId.EBC1001);
                }

                Integer sbuktnin = null;
                if (uiBean.getSbuktnin() == null) {
                    sbuktnin = uiBean.getVshktsbuktnin();
                }
                else {
                    sbuktnin = uiBean.getSbuktnin();
                }

                if (C_UktKbn.SBUK.eq(sksiteidruktkbn) && sbuktnin >= 2) {

                    throw new BizLogicException(MessageId.EBC1004);
                }

                if (C_UktKbn.SBUK.eq(sksiteidruktkbn) && C_UktKbn.SOUZOKUNIN.eq(sbuktkbn)) {

                    throw new BizLogicException(MessageId.EBC1006);
                }
            }

            if (C_UktKbn.KYK.eq(sbuktkbn) &&
                C_UktKbn.SBUK.eq(stdruktkbn)) {

                throw new BizLogicException(MessageId.EIA1019, C_UktKbn.KYK.getContent(C_UktKbn.PATTERN_KHSBUK));
            }
            if (C_UktKbn.HHKN.eq(sbuktkbn) &&
                C_UktKbn.SBUK.eq(stdruktkbn)) {

                throw new BizLogicException(MessageId.EIA1019, C_UktKbn.HHKN.getContent(C_UktKbn.PATTERN_KHSBUK));
            }

            if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu()) ||
                C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu())) {

                if (!C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn()) &&
                    (C_UktKbn.TOUROKUKAZOKU1.eq(stdruktkbn) || C_UktKbn.TOUROKUKAZOKU2.eq(stdruktkbn))) {

                    throw new BizLogicException(MessageId.EIF1130);
                }
            }

            if (C_UktKbn.TOUROKUKAZOKU1.eq(stdruktkbn)) {

                if (uiBean.getVtrkkzktrkkzknmkn1().equals(hhknnmkn) &&
                    uiBean.getVtrkkzktrkkzknmkj1().equals(hhknnmkj) &&
                    BizDateUtil.compareYmd(
                        uiBean.getVtrkkzktrkkzkseiymd1(), uiBean.getVhhkshhknseiymd()) == BizDateUtil.COMPARE_EQUAL) {

                    throw new BizLogicException(MessageId.EIA1070, TRKKZK1);
                }
            }

            if (C_UktKbn.TOUROKUKAZOKU2.eq(stdruktkbn)) {

                if (uiBean.getVtrkkzktrkkzknmkn2().equals(hhknnmkn) &&
                    uiBean.getVtrkkzktrkkzknmkj2().equals(hhknnmkj) &&
                    BizDateUtil.compareYmd(
                        uiBean.getVtrkkzktrkkzkseiymd2(), uiBean.getVhhkshhknseiymd()) == BizDateUtil.COMPARE_EQUAL) {

                    throw new BizLogicException(MessageId.EIA1070, TRKKZK2);
                }
            }

        }
    }

    private void checkHenkouUmu() {

        if (C_UmuKbn.NONE.eq(uiBean.getKykhenkouumu()) &&
            C_UmuKbn.NONE.eq(uiBean.getHhkhenkouumu()) &&
            C_UmuKbn.NONE.eq(uiBean.getNkukthenkouumu()) &&
            C_UmuKbn.NONE.eq(uiBean.getSbhkknukthenkouumu()) &&
            C_UmuKbn.NONE.eq(uiBean.getSbukthenkouumu()) &&
            C_UmuKbn.NONE.eq(uiBean.getKznkukthenkouumu()) &&
            C_UmuKbn.NONE.eq(uiBean.getStdrskhenkouumu())) {
            throw new BizLogicException(MessageId.EIA0044, "名義情報");
        }
    }

    private void checkHonninKakunin() {

        if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {

            throw new BizLogicException(MessageId.EBC0043, DISP_N_HONNINKAKNINKEKKAKBN);
        }
    }

    private void checkTyhySksYouhi() {

        if (C_TyhysakuseiyhKbn.BLNK.eq(uiBean.getTyhysakuseiyhkbn())) {
            throw new BizLogicException(MessageId.EBC0043, DISP_N_TYHYSAKUSEIYHKBN);
        }

        if (C_TyhysakuseiyhKbn.YOU.eq(uiBean.getTyhysakuseiyhkbn()) && C_HassouKbn.BLNK.eq(uiBean.getHassoukbn())) {
            throw new BizLogicException(MessageId.EBC0043, DISP_N_HASSOUKBN);
        }

        if (C_TyhysakuseiyhKbn.HUYOU.eq(uiBean.getTyhysakuseiyhkbn()) && !C_HassouKbn.BLNK.eq(uiBean.getHassoukbn())) {

            throw new BizLogicException(MessageId.EBC0007, DISP_N_HASSOUKBN);
        }

    }

    private void checkHasoKbn() {

        if (C_KktyuitaKbn.DNGNMEMOARI.eq(uiBean.getVtdktkktyuitakbn())
            && C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {

            throw new BizLogicException(MessageId.EIA1007);
        }
    }

    private void checkSinkeiyakuTuusinsaki() {
        if (C_UmuKbn.ARI.eq(uiBean.getAdrhenkouumu())) {
            if (BizUtil.isBlank(uiBean.getTsinyno())) {
                throw new BizLogicException(MessageId.EBC0043, DISP_TSINYNO);
            }

            if (BizUtil.isBlank(uiBean.getTsinadr1kj())) {
                throw new BizLogicException(MessageId.EBC0043, DISP_TSINADRKJ);
            }

            if (BizUtil.isBlank(uiBean.getTsintelno())) {
                throw new BizLogicException(MessageId.EBC0043, DISP_TSINTELNO);
            }

            if (isEqualStr(uiBean.getVtssktsinyno(), uiBean.getTsinyno()) &&
                isEqualStr(uiBean.getVtssktsinadr1kj(), uiBean.getTsinadr1kj()) &&
                isEqualStr(uiBean.getVtssktsinadr2kj(), uiBean.getTsinadr2kj()) &&
                isEqualStr(uiBean.getVtssktsinadr3kj(), uiBean.getTsinadr3kj()) &&
                isEqualStr(uiBean.getVtssktsintelno(), uiBean.getTsintelno()) &&
                isEqualStr(uiBean.getVtsskdai2tsintelno(), uiBean.getDai2tsintelno())) {

                throw new BizLogicException(MessageId.EIA0044, NAIYO);
            }

            BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);
            BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(uiBean.getTsinadr1kj(),
                uiBean.getTsinadr2kj(), uiBean.getTsinadr3kj());

            if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {
                throw new BizLogicException(MessageId.EBA1003, DISP_TSINADRKJ,
                    String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                    String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
            }

            if (uiBean.getTsintelno().equals(uiBean.getDai2tsintelno())) {
                throw new BizLogicException(MessageId.EBA1001, DISP_TSINTELNO, DISP_DAI2TSINTELNO);
            }
        }
        else {
            if (!BizUtil.isBlank(uiBean.getTsinyno())) {
                throw new BizLogicException(MessageId.EBC0007, DISP_TSINYNO);
            }

            if (!BizUtil.isBlank(uiBean.getTsinadr1kj()) ||
                !BizUtil.isBlank(uiBean.getTsinadr2kj()) ||
                !BizUtil.isBlank(uiBean.getTsinadr3kj())) {
                throw new BizLogicException(MessageId.EBC0007, DISP_TSINADRKJ);
            }

            if (!BizUtil.isBlank(uiBean.getTsintelno())) {
                throw new BizLogicException(MessageId.EBC0007, DISP_TSINTELNO);
            }

            if (!BizUtil.isBlank(uiBean.getDai2tsintelno())) {
                throw new BizLogicException(MessageId.EBC0007, DISP_DAI2TSINTELNO);
            }
        }

    }

    private void checkIdoutyousyoyuuKoumoku() {
        BizDate sysDate = BizDate.getSysDate();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        BizDate syuKykymd = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0).getKykymd();

        if (uiBean.getOldkyksibouymd() != null) {
            if (BizDateUtil.compareYmd(uiBean.getOldkyksibouymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EIA0037, DISP_OLDKYKSIBOUYMD);
            }

            if (BizDateUtil.compareYmd(uiBean.getOldkyksibouymd(), syuKykymd) == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(MessageId.EIA0070, DISP_OLDKYKSIBOUYMD);
            }
        }

        if (uiBean.getSyoruiukeymd() == null) {
            throw new BizLogicException(MessageId.EBC0043, DISP_SYORUIUKEYMD);
        }

        if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EIA0037, DISP_SYORUIUKEYMD);
        }

        if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), syuKykymd) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EIA0070, DISP_SYORUIUKEYMD);
        }

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsByKouryokuhasseiymdGt(uiBean.getSyoruiukeymd());

        if (kykSyouhnList.size() > 0) {
            throw new BizLogicException(MessageId.EIA0106);
        }

        List<IT_KykSyaHenkouRireki> kykSyaHenkouRirekiList =
            hozenDomManager.getKykSyaHenkouRirekisBySyono(uiBean.getSyono());

        SortIT_KykSyaHenkouRireki sortITKykSyaHenkouRireki = SWAKInjector.getInstance(SortIT_KykSyaHenkouRireki.class);
        kykSyaHenkouRirekiList = sortITKykSyaHenkouRireki
            .OrderIT_KykSyaHenkouRirekiByKouryokuHasseiymdDesc(kykSyaHenkouRirekiList);

        if (kykSyaHenkouRirekiList.size() > 0) {
            if (BizDateUtil.compareYmd(kykSyaHenkouRirekiList.get(0).getKouryokuhasseiymd(), uiBean.getSyoruiukeymd()) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EIF1073);
            }
        }

        if (uiBean.getOldkyksibouymd() != null) {
            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), uiBean.getOldkyksibouymd()) == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(MessageId.EBA0028, DISP_SYORUIUKEYMD);
            }

            int compareResult = BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), uiBean.getYendthnkymd());
            if (compareResult == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(MessageId.EIA1022);
            }
        }
    }

    private void checkHansya() {

        C_HnsychkTaisyousyaKbn chnsychkTaisyousyaKbn = null;
        String kyknmkn = null;
        String kyknmkj = null;
        C_KjkhukaKbn kykkjkhukakbn = C_KjkhukaKbn.BLNK;
        BizDate kykseiymd = null;
        String kykyno = null;
        String hhknnmkn = null;
        String hhknnmkj = null;
        C_KjkhukaKbn hhkkjkhukakbn = C_KjkhukaKbn.BLNK;
        BizDate hhknseiymd = null;
        String hhknyno = null;

        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);
        C_ErrorKbn tyotkhknhyjsetkbn = setTyotikuseihokenhyouji.exec(uiBean.getKykKihon());
        C_UmuKbn houteityotkhknhyj = setTyotikuseihokenhyouji.getHouteityotkhknhyj();
        C_UmuKbn tyotkhknhyj = setTyotikuseihokenhyouji.getTyotkhknhyj();

        if (C_UmuKbn.ARI.eq(uiBean.getKykhenkouumu())) {

            IT_KykKihon kykKihon = uiBean.getKykKihon();
            IT_KykSya kykSya = kykKihon.getKykSya();

            if (BizUtil.isBlank(uiBean.getNewkyknmkn())) {

                kyknmkn = uiBean.getVkykskyknmkn();
            }
            else {

                kyknmkn = uiBean.getNewkyknmkn();
            }

            if (BizUtil.isBlank(uiBean.getNewkyknmkj())) {

                kyknmkj = uiBean.getVkykskyknmkj();
            }
            else {

                kyknmkj = uiBean.getNewkyknmkj();
            }

            if (BizUtil.isBlank(uiBean.getNewkyknmkj())) {

                kykkjkhukakbn = uiBean.getVkykskyknmkjkhukakbn();
            }
            else {

                kykkjkhukakbn = uiBean.getNewkyknmkjkhukakbn();
            }

            if (uiBean.getNewkykseiymd() == null) {

                kykseiymd = uiBean.getVkykskykseiymd();
            }
            else {

                kykseiymd = uiBean.getNewkykseiymd();
            }

            kykyno = kykSya.getTsinyno();

            chnsychkTaisyousyaKbn = C_HnsychkTaisyousyaKbn.KYK;

            checkHansyaExec(chnsychkTaisyousyaKbn, kyknmkn, kyknmkj, kykkjkhukakbn, kykseiymd, kykyno,
                tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);

        }

        if (C_UmuKbn.ARI.eq(uiBean.getHhkhenkouumu())) {

            IT_KykKihon kykKihon = uiBean.getKykKihon();
            IT_HhknSya hhknSya = kykKihon.getHhknSya();

            if (BizUtil.isBlank(uiBean.getNewhhknnmkn())) {

                hhknnmkn = uiBean.getVhhkshhknnmkn();
            }
            else {

                hhknnmkn = uiBean.getNewhhknnmkn();
            }

            if (BizUtil.isBlank(uiBean.getNewhhknnmkj())) {

                hhknnmkj = uiBean.getVhhkshhknnmkj();
            }
            else {

                hhknnmkj = uiBean.getNewhhknnmkj();
            }

            if (BizUtil.isBlank(uiBean.getNewhhknnmkj())) {

                hhkkjkhukakbn = uiBean.getVhhkshhknnmkjkhukakbn();
            }
            else {

                hhkkjkhukakbn = uiBean.getNewhhknnmkjkhukakbn();
            }

            hhknseiymd = uiBean.getVhhkshhknseiymd();

            hhknyno = hhknSya.getHhknyno();

            chnsychkTaisyousyaKbn = C_HnsychkTaisyousyaKbn.HHKN;

            checkHansyaExec(chnsychkTaisyousyaKbn, hhknnmkn, hhknnmkj, hhkkjkhukakbn, hhknseiymd, hhknyno,
                tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbukthenkouumu())) {

            IT_KykKihon kykKihon = uiBean.getKykKihon();
            IT_KykSya kykSya = kykKihon.getKykSya();

            if (C_UmuKbn.ARI.eq(uiBean.getVshktsbhkuktumu())) {

                chnsychkTaisyousyaKbn = C_HnsychkTaisyousyaKbn.SBSUKT;
            }

            if (C_UmuKbn.ARI.eq(uiBean.getVshktsbkyuuhukinuktumu())) {

                chnsychkTaisyousyaKbn = C_HnsychkTaisyousyaKbn.SBKYFKUKT;
            }

            kykyno = kykSya.getTsinyno();

            if (C_UmuKbn.ARI.eq(uiBean.getSbukt1inpumu())) {
                if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getSbuktkbn1())) {
                    checkHansyaExec(chnsychkTaisyousyaKbn, uiBean.getSbuktnmkn1(), uiBean.getSbuktnmkj1(),
                        uiBean.getSbuktnmkjhukakbn1(), uiBean.getSbuktseiymd1(), kykyno,
                        tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getSbukt2inpumu())) {
                checkHansyaExec(chnsychkTaisyousyaKbn, uiBean.getSbuktnmkn2(), uiBean.getSbuktnmkj2(),
                    uiBean.getSbuktnmkjhukakbn2(), uiBean.getSbuktseiymd2(), kykyno,
                    tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getSbukt3inpumu())) {
                checkHansyaExec(chnsychkTaisyousyaKbn, uiBean.getSbuktnmkn3(), uiBean.getSbuktnmkj3(),
                    uiBean.getSbuktnmkjhukakbn3(), uiBean.getSbuktseiymd3(), kykyno,
                    tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getSbukt4inpumu())) {
                checkHansyaExec(chnsychkTaisyousyaKbn, uiBean.getSbuktnmkn4(), uiBean.getSbuktnmkj4(),
                    uiBean.getSbuktnmkjhukakbn4(), uiBean.getSbuktseiymd4(), kykyno,
                    tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getStdrskhenkouumu()) && !C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())) {

            IT_KykKihon kykKihon = uiBean.getKykKihon();
            IT_KykSya kykSya = kykKihon.getKykSya();

            kykyno = kykSya.getTsinyno();

            if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getNewstdruktkbn())) {

                checkHansyaExec(C_HnsychkTaisyousyaKbn.STDRSK, uiBean.getVtrkkzktrkkzknmkn1(),
                    uiBean.getVtrkkzktrkkzknmkj1(), uiBean.getVtrkkzktrkkzknmkjkhukakbn1(),
                    uiBean.getVtrkkzktrkkzkseiymd1(), uiBean.getVtrkkzktrkkzkyno1(),
                    tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
            }

            else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getNewstdruktkbn())) {

                checkHansyaExec(C_HnsychkTaisyousyaKbn.STDRSK, uiBean.getVtrkkzktrkkzknmkn2(),
                    uiBean.getVtrkkzktrkkzknmkj2(), uiBean.getVtrkkzktrkkzknmkjkhukakbn2(),
                    uiBean.getVtrkkzktrkkzkseiymd2(), uiBean.getVtrkkzktrkkzkyno2(),
                    tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
            }

            else if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewstdruktkbn())) {

                checkHansyaExec(C_HnsychkTaisyousyaKbn.STDRSK, uiBean.getNewstdrsknmkn(),
                    uiBean.getNewstdrsknmkj(), uiBean.getNewstdrsknmkjhukakbn(), uiBean.getNewstdrskseiymd(), kykyno,
                    tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
            }
        }

        if (uiBean.getSbuktnin() != null && uiBean.getSbuktnin() >= 5) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WBA0016);
        }
    }

    private void checkHansyaExec(C_HnsychkTaisyousyaKbn pCHnsychkTaisyousyaKbn, String pTaisyouNmKn,
        String pTaisyouNmKj, C_KjkhukaKbn pKjjkhukaKbn, BizDate pTaisyouSeiYMD, String pZrnTaisyou,
        C_ErrorKbn pTyotkhknHyjSetKekkbn, C_UmuKbn pHouteiTyotkhknHyj, C_UmuKbn pTyotkhknHyj) {

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);

        Boolean waringFlg = checkHansyaSentakuInfo.exec(pCHnsychkTaisyousyaKbn, pTaisyouNmKn, pTaisyouNmKj,
            pKjjkhukaKbn, pTaisyouSeiYMD, pZrnTaisyou, pTyotkhknHyjSetKekkbn, pHouteiTyotkhknHyj, pTyotkhknHyj);

        if (waringFlg == false) {

            String waringMessage = "";
            String waringMessageId = "";

            for (int i = 0; i < checkHansyaSentakuInfo.getWarningMsgIdList().size(); i++) {

                waringMessage = checkHansyaSentakuInfo.getWarningMsgList().get(i);
                waringMessageId = checkHansyaSentakuInfo.getWarningMsgIdList().get(i);

                if ("WIA1029".equals(waringMessageId)) {
                    if (!tyotkhknHyjErrorFlg) {

                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                            BizUtil.getGeneralMessageId(waringMessageId)
                            , waringMessage);

                        tyotkhknHyjErrorFlg = true;
                    }
                }
                else {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                        BizUtil.getGeneralMessageId(waringMessageId)
                        , waringMessage);
                }
            }
        }
    }

    private void checkFatca() {

        String kyknmkn = new String();
        if (BizUtil.isBlank(uiBean.getNewkyknmkn())) {

            kyknmkn = uiBean.getVkykskyknmkn();
        } else {
            kyknmkn = uiBean.getNewkyknmkn();
        }

        BizDate kykseiymd = null;
        if (uiBean.getNewkykseiymd() == null) {

            kykseiymd = uiBean.getVkykskykseiymd();
        } else {
            kykseiymd = uiBean.getNewkykseiymd();
        }

        C_Kyksei kyksei;
        if (C_Kyksei.BLNK.eq(uiBean.getNewkyksei())) {

            kyksei = uiBean.getVkykskyksei();
        } else {
            kyksei = uiBean.getNewkyksei();
        }

        CheckFatca checkFatca = SWAKInjector.getInstance(CheckFatca.class);

        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYK, kyknmkn, kykseiymd, kyksei);

        if (C_FatcatghtkekKbn.TAISYOU.eq(fatcatghtkekKbn)) {
            if (checkFatca.getMsgIdList().size() > 0) {
                String msg = "";
                String msgId = "";
                for (int count = 0; count < checkFatca.getMsgIdList().size(); count++) {
                    msg = checkFatca.getMsgList().get(count);
                    msgId = BizUtil.getGeneralMessageId(checkFatca.getMsgIdList().get(count));
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, msgId, msg);
                }
            }
        }
    }

    private void updateKTKykKihon() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String functionId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        kykKihon.setSyhenkouymd(sysDate);
        kykKihon.setLastmeihenymd(sysDate);
        kykKihon.setGyoumuKousinKinou(functionId);
        kykKihon.setGyoumuKousinsyaId(userId);
        kykKihon.setGyoumuKousinTime(sysTime);

        if (C_TyhysakuseiyhKbn.YOU.eq(uiBean.getTyhysakuseiyhkbn())) {
            kykKihon.setLastsyosaihkymd(sysDate);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getKykhenkouumu())) {

            kykKihon.setLastkykmeighnkymd(sysDate);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbukthenkouumu())) {

            kykKihon.setLastsbukthenymd(sysDate);
            kykKihon.setSbuktnin(uiBean.getSbuktnin());
        }

        if (C_UmuKbn.ARI.eq(uiBean.getDskykmeihenkouumu())) {
            kykKihon.setLastkyknmseiymdhenkouymd(sysDate);
        }

        hozenDomManager.update(kykKihon);
    }

    private void updateKTKykSya() {

        if (C_UmuKbn.NONE.eq(uiBean.getKykhenkouumu())) {
            return;
        }
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String functionId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();

        IT_KykKihon KykKihon = uiBean.getKykKihon();
        IT_KykSya kykSya = KykKihon.getKykSya();
        IT_HhknSya hhknSya = KykKihon.getHhknSya();

        if (!BizUtil.isBlank(uiBean.getNewkyknmkn())) {
            kykSya.setKyknmkn(uiBean.getNewkyknmkn());
        }

        if (!BizUtil.isBlank(uiBean.getNewkyknmkj())) {
            kykSya.setKyknmkj(uiBean.getNewkyknmkj());
            kykSya.setKyknmkjkhukakbn(uiBean.getNewkyknmkjkhukakbn());
        }

        if (uiBean.getNewkykseiymd() != null) {
            kykSya.setKykseiymd(uiBean.getNewkykseiymd());
        }

        if (!C_Kyksei.BLNK.eq(uiBean.getNewkyksei())) {
            kykSya.setKyksei(uiBean.getNewkyksei());
        }

        if (!C_Tdk.BLNK.eq(uiBean.getNewkkkyktdk())) {
            kykSya.setKkkyktdk(uiBean.getNewkkkyktdk());
        }

        if (!C_HjndaiykKbn.BLNK.eq(uiBean.getNewhjndaiykkbn())) {
            kykSya.setHjndaiykkbn(uiBean.getNewhjndaiykkbn());
            kykSya.setHjndaiyknm(uiBean.getNewhjndaiyknm());
        }

        if (!BizUtil.isBlank(uiBean.getNewhjndainmkn())) {
            kykSya.setHjndainmkn(uiBean.getNewhjndainmkn());
        }
        if (!BizUtil.isBlank(uiBean.getNewhjndainmkj())) {
            kykSya.setHjndainmkj(uiBean.getNewhjndainmkj());
        }

        kykSya.setGyoumuKousinKinou(functionId);
        kykSya.setGyoumuKousinsyaId(userId);
        kykSya.setGyoumuKousinTime(sysTime);

        if (C_UmuKbn.ARI.eq(uiBean.getKyktdkhnkumu()) &&
            C_Tdk.HONNIN.eq(uiBean.getNewkkkyktdk())) {
            kykSya.setKyksakuinmeino(hhknSya.getHhknsakuinmeino());
        }

        hozenDomManager.update(KykKihon);
    }

    private void updateKTHhknSya() {

        if (C_UmuKbn.NONE.eq(uiBean.getHhkhenkouumu())) {
            return;
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String functionId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();

        IT_KykKihon KykKihon = uiBean.getKykKihon();
        IT_HhknSya hhknSya = KykKihon.getHhknSya();

        if (!BizUtil.isBlank(uiBean.getNewhhknnmkn())) {
            hhknSya.setHhknnmkn(uiBean.getNewhhknnmkn());
        }

        if (!BizUtil.isBlank(uiBean.getNewhhknnmkj())) {
            hhknSya.setHhknnmkj(uiBean.getNewhhknnmkj());
            hhknSya.setHhknnmkjkhukakbn(uiBean.getNewhhknnmkjkhukakbn());
        }

        hhknSya.setGyoumuKousinKinou(functionId);
        hhknSya.setGyoumuKousinsyaId(userId);
        hhknSya.setGyoumuKousinTime(sysTime);

        hozenDomManager.update(KykKihon);
    }

    private void deleteTrkKzk(IT_KykKihon pKykKihon) {

        List<IT_TrkKzk> trkKzkList = pKykKihon.getTrkKzks();

        trkKzkList.removeAll(trkKzkList);
    }

    private void updateKykSonotaTkyk(IT_KykKihon pKykKihon, KhozenCommonParam pKhozenCommonParam) {

        IT_KykSonotaTkyk kykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        kykSonotaTkyk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        kykSonotaTkyk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        kykSonotaTkyk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        kykSonotaTkyk.setKykdrtkykhukaumu(C_UmuKbn.NONE);
        kykSonotaTkyk.setKykdrtkykkaiyakuymd(BizDate.getSysDate());
    }

    private void updateKhTtdkTyuui(IT_KykKihon pKykKihon, KhozenCommonParam pKhozenCommonParam) {

        IT_KhTtdkTyuui khTtdkTyuui = pKykKihon.getKhTtdkTyuui();

        khTtdkTyuui.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        khTtdkTyuui.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        khTtdkTyuui.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        khTtdkTyuui.setKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);
        khTtdkTyuui.setKykdrdouiyouhi(C_KykdrDouiYouhiKbn.BLNK);
    }

    private void updateKTUkt() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String functionId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();

        IT_KykKihon KykKihon = uiBean.getKykKihon();
        IT_KykUkt kykUkt;

        if (C_UmuKbn.ARI.eq(uiBean.getNkukthenkouumu())) {

            kykUkt = KykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT).get(0);

            kykUkt.setKokno("");

            kykUkt.setUktkbn(uiBean.getNewnenkinuktkbn());

            kykUkt.setGyoumuKousinKinou(functionId);
            kykUkt.setGyoumuKousinsyaId(userId);
            kykUkt.setGyoumuKousinTime(sysTime);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getKznkukthenkouumu())) {

            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getKzuktkaijyokbn())) {
                List<IT_KykUkt> kykUktList = KykKihon.getKykUkts();
                kykUkt = KykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KEIZKNKUKT).get(0);
                kykUktList.remove(kykUkt);
            }
            else {
                if (!BizUtil.isBlank(uiBean.getKeizknkuktnmkn())) {

                    kykUkt = KykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KEIZKNKUKT).get(0);

                    kykUkt.setKokno("");
                    if (!BizUtil.isBlank(uiBean.getNewkzuktnmkn())) {
                        kykUkt.setUktnmkn(uiBean.getNewkzuktnmkn());
                    }

                    if (!BizUtil.isBlank(uiBean.getNewkzuktnmkj())) {
                        kykUkt.setUktnmkj(uiBean.getNewkzuktnmkj());
                    }

                    if (uiBean.getNewkzuktseiymd() != null) {
                        kykUkt.setUktseiymd(uiBean.getNewkzuktseiymd());
                    }
                    if (!C_Tdk.BLNK.eq(uiBean.getNewkzukttdk())) {
                        kykUkt.setUkttdk(uiBean.getNewkzukttdk());
                    }
                    kykUkt.setGyoumuKousinKinou(functionId);
                    kykUkt.setGyoumuKousinsyaId(userId);
                    kykUkt.setGyoumuKousinTime(sysTime);

                }
                else {

                    kykUkt = KykKihon.createKykUkt();

                    kykUkt.setSyono(uiBean.getSyono());
                    kykUkt.setUktsyukbn(C_UktsyuKbn.KEIZKNKUKT);
                    kykUkt.setUktsyurenno(1);
                    kykUkt.setUktnmkn(uiBean.getNewkzuktnmkn());
                    kykUkt.setUktnmkj(uiBean.getNewkzuktnmkj());
                    kykUkt.setUktseiymd(uiBean.getNewkzuktseiymd());
                    kykUkt.setUkttdk(uiBean.getNewkzukttdk());
                    kykUkt.setUktbnwari(BizNumber.valueOf(100));

                    kykUkt.setGyoumuKousinKinou(functionId);
                    kykUkt.setGyoumuKousinsyaId(userId);
                    kykUkt.setGyoumuKousinTime(sysTime);
                    BizPropertyInitializer.initialize(kykUkt);
                }
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbhkknukthenkouumu())) {

            kykUkt = KykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBHENKANUKT).get(0);

            kykUkt.setKokno("");
            if (!BizUtil.isBlank(uiBean.getNewsbhenkanuktnmkn())) {
                kykUkt.setUktnmkn(uiBean.getNewsbhenkanuktnmkn());
            }

            if (!BizUtil.isBlank(uiBean.getNewsbhenkanuktnmkj())) {
                kykUkt.setUktnmkj(uiBean.getNewsbhenkanuktnmkj());
            }

            if (uiBean.getNewsbhenkanuktseiymd() != null) {
                kykUkt.setUktseiymd(uiBean.getNewsbhenkanuktseiymd());
            }

            if (!C_Tdk.BLNK.eq(uiBean.getNewsbhenkanukttdk())) {
                kykUkt.setUkttdk(uiBean.getNewsbhenkanukttdk());

            }
            kykUkt.setGyoumuKousinKinou(functionId);
            kykUkt.setGyoumuKousinsyaId(userId);
            kykUkt.setGyoumuKousinTime(sysTime);

        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbukthenkouumu())) {
            int maxRenno = 0;

            if (uiBean.getVshktsbuktsyurenno4() != null && uiBean.getVshktsbuktsyurenno4() != 0) {
                maxRenno = uiBean.getVshktsbuktsyurenno4();
            }
            else if (uiBean.getVshktsbuktsyurenno3() != null && uiBean.getVshktsbuktsyurenno3() != 0) {
                maxRenno = uiBean.getVshktsbuktsyurenno3();
            }
            else if (uiBean.getVshktsbuktsyurenno2() != null && uiBean.getVshktsbuktsyurenno2() != 0) {
                maxRenno = uiBean.getVshktsbuktsyurenno2();
            }
            else if (uiBean.getVshktsbuktsyurenno1() != null && uiBean.getVshktsbuktsyurenno1() != 0) {
                maxRenno = uiBean.getVshktsbuktsyurenno1();
            }

            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn1())) {
                KykKihon.getKykUkts().remove(
                    KykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, uiBean.getVshktsbuktsyurenno1()));
            }
            else {
                if (!C_UktKbn.BLNK.eq(uiBean.getSbuktkbn1())
                    || !BizUtil.isBlank(uiBean.getSbuktnmkn1())
                    || !BizUtil.isBlank(uiBean.getSbuktnmkj1())
                    || uiBean.getSbuktseiymd1() != null
                    || (uiBean.getNewsbuktbnwari1() != null && !uiBean.getNewsbuktbnwari1().isOptional())) {
                    if (C_UktKbn.BLNK.eq(uiBean.getVshktdispsbuktkbn1())) {
                        kykUkt = KykKihon.createKykUkt();
                        kykUkt.setUktsyukbn(C_UktsyuKbn.SBUKT);
                        kykUkt.setUktsyurenno(++maxRenno);
                        kykUkt.setUktkbn(uiBean.getSbuktkbn1());
                        kykUkt.setUktnmkn(uiBean.getSbuktnmkn1());
                        kykUkt.setUktnmkj(uiBean.getSbuktnmkj1());
                        kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn1());
                        kykUkt.setUktseiymd(uiBean.getSbuktseiymd1());
                        kykUkt.setUktbnwari(uiBean.getNewsbuktbnwari1());
                        kykUkt.setGyoumuKousinKinou(functionId);
                        kykUkt.setGyoumuKousinsyaId(userId);
                        kykUkt.setGyoumuKousinTime(sysTime);
                        BizPropertyInitializer.initialize(kykUkt);

                    }
                    else {
                        kykUkt = KykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT,
                            uiBean.getVshktsbuktsyurenno1());

                        kykUkt.setKokno("");

                        kykUkt.setUktkbn(uiBean.getSbuktkbn1());
                        kykUkt.setUktnmkn(uiBean.getSbuktnmkn1());
                        kykUkt.setUktnmkj(uiBean.getSbuktnmkj1());
                        kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn1());
                        kykUkt.setUktseiymd(uiBean.getSbuktseiymd1());
                        kykUkt.setUktbnwari(uiBean.getNewsbuktbnwari1());

                        kykUkt.setGyoumuKousinKinou(functionId);
                        kykUkt.setGyoumuKousinsyaId(userId);
                        kykUkt.setGyoumuKousinTime(sysTime);
                    }
                }
            }
            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn2())) {
                KykKihon.getKykUkts().remove(
                    KykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, uiBean.getVshktsbuktsyurenno2()));
            }
            else {
                if (!BizUtil.isBlank(uiBean.getSbuktnmkn2())
                    || !BizUtil.isBlank(uiBean.getSbuktnmkj2())
                    || uiBean.getSbuktseiymd2() != null
                    || (uiBean.getNewsbuktbnwari2() != null && !uiBean.getNewsbuktbnwari2().isOptional())) {
                    if (BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn2())) {
                        kykUkt = KykKihon.createKykUkt();
                        kykUkt.setUktsyukbn(C_UktsyuKbn.SBUKT);
                        kykUkt.setUktsyurenno(++maxRenno);
                        kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                        kykUkt.setUktnmkn(uiBean.getSbuktnmkn2());
                        kykUkt.setUktnmkj(uiBean.getSbuktnmkj2());
                        kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn2());
                        kykUkt.setUktseiymd(uiBean.getSbuktseiymd2());
                        kykUkt.setUktbnwari(uiBean.getNewsbuktbnwari2());
                        kykUkt.setGyoumuKousinKinou(functionId);
                        kykUkt.setGyoumuKousinsyaId(userId);
                        kykUkt.setGyoumuKousinTime(sysTime);
                        BizPropertyInitializer.initialize(kykUkt);

                    }
                    else {
                        kykUkt = KykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT,
                            uiBean.getVshktsbuktsyurenno2());

                        kykUkt.setKokno("");
                        kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                        kykUkt.setUktnmkn(uiBean.getSbuktnmkn2());
                        kykUkt.setUktnmkj(uiBean.getSbuktnmkj2());
                        kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn2());
                        kykUkt.setUktseiymd(uiBean.getSbuktseiymd2());
                        kykUkt.setUktbnwari(uiBean.getNewsbuktbnwari2());

                        kykUkt.setGyoumuKousinKinou(functionId);
                        kykUkt.setGyoumuKousinsyaId(userId);
                        kykUkt.setGyoumuKousinTime(sysTime);

                    }
                }
            }
            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn3())) {
                KykKihon.getKykUkts().remove(
                    KykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, uiBean.getVshktsbuktsyurenno3()));
            }
            else {
                if (!BizUtil.isBlank(uiBean.getSbuktnmkn3())
                    || !BizUtil.isBlank(uiBean.getSbuktnmkj3())
                    || uiBean.getSbuktseiymd3() != null
                    || (uiBean.getNewsbuktbnwari3() != null && !uiBean.getNewsbuktbnwari3().isOptional())) {
                    if (BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn3())) {
                        kykUkt = KykKihon.createKykUkt();
                        kykUkt.setUktsyukbn(C_UktsyuKbn.SBUKT);
                        kykUkt.setUktsyurenno(++maxRenno);
                        kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                        kykUkt.setUktnmkn(uiBean.getSbuktnmkn3());
                        kykUkt.setUktnmkj(uiBean.getSbuktnmkj3());
                        kykUkt.setUktseiymd(uiBean.getSbuktseiymd3());
                        kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn3());
                        kykUkt.setUktbnwari(uiBean.getNewsbuktbnwari3());
                        kykUkt.setGyoumuKousinKinou(functionId);
                        kykUkt.setGyoumuKousinsyaId(userId);
                        kykUkt.setGyoumuKousinTime(sysTime);
                        BizPropertyInitializer.initialize(kykUkt);

                    }
                    else {
                        kykUkt = KykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT,
                            uiBean.getVshktsbuktsyurenno3());

                        kykUkt.setKokno("");
                        kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                        kykUkt.setUktnmkn(uiBean.getSbuktnmkn3());
                        kykUkt.setUktnmkj(uiBean.getSbuktnmkj3());
                        kykUkt.setUktseiymd(uiBean.getSbuktseiymd3());
                        kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn3());
                        kykUkt.setUktbnwari(uiBean.getNewsbuktbnwari3());

                        kykUkt.setGyoumuKousinKinou(functionId);
                        kykUkt.setGyoumuKousinsyaId(userId);
                        kykUkt.setGyoumuKousinTime(sysTime);

                    }
                }

            }
            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn4())) {
                KykKihon.getKykUkts().remove(
                    KykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, uiBean.getVshktsbuktsyurenno4()));
            }
            else {
                if (!BizUtil.isBlank(uiBean.getSbuktnmkn4())
                    || !BizUtil.isBlank(uiBean.getSbuktnmkn4())
                    || !BizUtil.isBlank(uiBean.getSbuktnmkj4())
                    || uiBean.getSbuktseiymd4() != null
                    || (uiBean.getNewsbuktbnwari4() != null && !uiBean.getNewsbuktbnwari4().isOptional())) {
                    if (BizUtil.isBlank(uiBean.getVshktdispsbuktnmkn4())) {
                        kykUkt = KykKihon.createKykUkt();
                        kykUkt.setUktsyukbn(C_UktsyuKbn.SBUKT);
                        kykUkt.setUktsyurenno(++maxRenno);
                        kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                        kykUkt.setUktnmkn(uiBean.getSbuktnmkn4());
                        kykUkt.setUktnmkj(uiBean.getSbuktnmkj4());
                        kykUkt.setUktseiymd(uiBean.getSbuktseiymd4());
                        kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn4());
                        kykUkt.setUktbnwari(uiBean.getNewsbuktbnwari4());
                        kykUkt.setGyoumuKousinKinou(functionId);
                        kykUkt.setGyoumuKousinsyaId(userId);
                        kykUkt.setGyoumuKousinTime(sysTime);
                        BizPropertyInitializer.initialize(kykUkt);

                    }
                    else {
                        kykUkt = KykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT,
                            uiBean.getVshktsbuktsyurenno4());

                        kykUkt.setKokno("");
                        kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                        kykUkt.setUktnmkn(uiBean.getSbuktnmkn4());
                        kykUkt.setUktnmkj(uiBean.getSbuktnmkj4());
                        kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn4());
                        kykUkt.setUktseiymd(uiBean.getSbuktseiymd4());
                        kykUkt.setUktbnwari(uiBean.getNewsbuktbnwari4());
                        kykUkt.setGyoumuKousinKinou(functionId);
                        kykUkt.setGyoumuKousinsyaId(userId);
                        kykUkt.setGyoumuKousinTime(sysTime);
                    }
                }
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getStdrskhenkouumu())) {

            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())) {


                kykUkt = KykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK).get(0);

                kykUkt.setKokno("");
                kykUkt.setUktkbn(C_UktKbn.NASI);
                kykUkt.setUktnmkn("");
                kykUkt.setUktnmkj("");
                kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                kykUkt.setUktseiymd(null);
                kykUkt.setUkttdk(C_Tdk.BLNK);
                kykUkt.setUktbnwari(BizNumber.valueOf(100));
                kykUkt.setGyoumuKousinKinou(functionId);
                kykUkt.setGyoumuKousinsyaId(userId);
                kykUkt.setGyoumuKousinTime(sysTime);

            }
            else {
                if (!C_UktKbn.BLNK.eq(uiBean.getVstsksiteidruktkbn())) {

                    kykUkt = KykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK).get(0);

                    kykUkt.setKokno("");
                    kykUkt.setUktkbn(uiBean.getNewstdruktkbn());
                    kykUkt.setUktnmkn(uiBean.getNewstdrsknmkn());
                    kykUkt.setUktnmkj(uiBean.getNewstdrsknmkj());
                    kykUkt.setUktnmkjkhukakbn(uiBean.getNewstdrsknmkjhukakbn());
                    kykUkt.setUktseiymd(uiBean.getNewstdrskseiymd());
                    kykUkt.setGyoumuKousinKinou(functionId);
                    kykUkt.setGyoumuKousinsyaId(userId);
                    kykUkt.setGyoumuKousinTime(sysTime);
                }
                else {
                    kykUkt = KykKihon.createKykUkt();

                    kykUkt.setSyono(uiBean.getSyono());
                    kykUkt.setUktsyukbn(C_UktsyuKbn.STDRSK);
                    kykUkt.setUktsyurenno(1);
                    kykUkt.setUktkbn(uiBean.getNewstdruktkbn());
                    kykUkt.setUktnmkn(uiBean.getNewstdrsknmkn());
                    kykUkt.setUktnmkj(uiBean.getNewstdrsknmkj());
                    kykUkt.setUktnmkjkhukakbn(uiBean.getNewstdrsknmkjhukakbn());
                    kykUkt.setUktseiymd(uiBean.getNewstdrskseiymd());
                    kykUkt.setUktbnwari(BizNumber.valueOf(100));
                    kykUkt.setGyoumuKousinKinou(functionId);
                    kykUkt.setGyoumuKousinsyaId(userId);
                    kykUkt.setGyoumuKousinTime(sysTime);
                    BizPropertyInitializer.initialize(kykUkt);
                }
            }
        }

        hozenDomManager.update(KykKihon);
    }

    private void insKTMeigiHenkouWkBySks(BizDate pSysDate, String pSysTime) {

        IW_KhMeigiHenkouWk iwKhMeigiHenkouWk = new IW_KhMeigiHenkouWk();

        iwKhMeigiHenkouWk.setKouteikanriid(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());
        iwKhMeigiHenkouWk.setSyono(uiBean.getSyono());
        iwKhMeigiHenkouWk.setSkssakuseiymd(pSysDate);
        iwKhMeigiHenkouWk.setMeigihnkjiyuu(uiBean.getMeigihnkjiyuu());
        iwKhMeigiHenkouWk.setShsnmkj(uiBean.getShsnmkj());
        iwKhMeigiHenkouWk.setShskyno(uiBean.getShskyno());
        iwKhMeigiHenkouWk.setShsadr1kj(uiBean.getShsadr1kj());
        iwKhMeigiHenkouWk.setShsadr2kj(uiBean.getShsadr2kj());
        iwKhMeigiHenkouWk.setShsadr3kj(uiBean.getShsadr3kj());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        iwKhMeigiHenkouWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        iwKhMeigiHenkouWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        iwKhMeigiHenkouWk.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(iwKhMeigiHenkouWk);

        hozenDomManager.insert(iwKhMeigiHenkouWk);
    }

    private void insKTMeigiHenkouWkByKakutei(BizDate pSysDate, String pSysTime) {

        IW_KhMeigiHenkouWk iwKhMeigiHenkouWk = new IW_KhMeigiHenkouWk();

        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

            iwKhMeigiHenkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        iwKhMeigiHenkouWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        iwKhMeigiHenkouWk.setSyono(uiBean.getSyono());
        iwKhMeigiHenkouWk.setMeigihnkjiyuu(uiBean.getMeigihnkjiyuu());
        iwKhMeigiHenkouWk.setKyknmkn(uiBean.getNewkyknmkn());
        iwKhMeigiHenkouWk.setKyknmkj(uiBean.getNewkyknmkj());
        iwKhMeigiHenkouWk.setKyknmkjkhukakbn(uiBean.getNewkyknmkjkhukakbn());
        iwKhMeigiHenkouWk.setKykseiymd(uiBean.getNewkykseiymd());
        iwKhMeigiHenkouWk.setKyksei(uiBean.getNewkyksei());
        iwKhMeigiHenkouWk.setKkkyktdk(uiBean.getNewkkkyktdk());
        iwKhMeigiHenkouWk.setHhknnmkn(uiBean.getNewhhknnmkn());
        iwKhMeigiHenkouWk.setHhknnmkj(uiBean.getNewhhknnmkj());
        iwKhMeigiHenkouWk.setHhknnmkjkhukakbn(uiBean.getNewhhknnmkjkhukakbn());
        iwKhMeigiHenkouWk.setNenkinuktkbn(uiBean.getNewnenkinuktkbn());
        iwKhMeigiHenkouWk.setSbuktnin(uiBean.getSbuktnin());
        iwKhMeigiHenkouWk.setSbuktkaijyokbn1(uiBean.getSbuktkaijyokbn1());
        if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn1())) {
            iwKhMeigiHenkouWk.setSbuktkbn1(C_UktKbn.BLNK);
            iwKhMeigiHenkouWk.setSbuktnmkn1("");
            iwKhMeigiHenkouWk.setSbuktnmkj1("");
            iwKhMeigiHenkouWk.setSbuktnmkjhukakbn1(C_KjkhukaKbn.BLNK);
            iwKhMeigiHenkouWk.setSbuktseiymd1(null);
            iwKhMeigiHenkouWk.setSbuktbnwari1(BizNumber.ZERO);
        } else {
            iwKhMeigiHenkouWk.setSbuktkbn1(uiBean.getSbuktkbn1());
            iwKhMeigiHenkouWk.setSbuktnmkn1(uiBean.getSbuktnmkn1());
            iwKhMeigiHenkouWk.setSbuktnmkj1(uiBean.getSbuktnmkj1());
            iwKhMeigiHenkouWk.setSbuktnmkjhukakbn1(uiBean.getSbuktnmkjhukakbn1());
            iwKhMeigiHenkouWk.setSbuktseiymd1(uiBean.getSbuktseiymd1());
            iwKhMeigiHenkouWk.setSbuktbnwari1(uiBean.getNewsbuktbnwari1());
        }
        iwKhMeigiHenkouWk.setSbuktkaijyokbn2(uiBean.getSbuktkaijyokbn2());
        if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn2())) {
            iwKhMeigiHenkouWk.setSbuktnmkn2("");
            iwKhMeigiHenkouWk.setSbuktnmkj2("");
            iwKhMeigiHenkouWk.setSbuktnmkjhukakbn2(C_KjkhukaKbn.BLNK);
            iwKhMeigiHenkouWk.setSbuktseiymd2(null);
            iwKhMeigiHenkouWk.setSbuktbnwari2(BizNumber.ZERO);
        } else {
            iwKhMeigiHenkouWk.setSbuktnmkn2(uiBean.getSbuktnmkn2());
            iwKhMeigiHenkouWk.setSbuktnmkj2(uiBean.getSbuktnmkj2());
            iwKhMeigiHenkouWk.setSbuktnmkjhukakbn2(uiBean.getSbuktnmkjhukakbn2());
            iwKhMeigiHenkouWk.setSbuktseiymd2(uiBean.getSbuktseiymd2());
            iwKhMeigiHenkouWk.setSbuktbnwari2(uiBean.getNewsbuktbnwari2());
        }
        iwKhMeigiHenkouWk.setSbuktkaijyokbn3(uiBean.getSbuktkaijyokbn3());
        if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn3())) {
            iwKhMeigiHenkouWk.setSbuktnmkn3("");
            iwKhMeigiHenkouWk.setSbuktnmkj3("");
            iwKhMeigiHenkouWk.setSbuktnmkjhukakbn3(C_KjkhukaKbn.BLNK);
            iwKhMeigiHenkouWk.setSbuktseiymd3(null);
            iwKhMeigiHenkouWk.setSbuktbnwari3(BizNumber.ZERO);
        } else {
            iwKhMeigiHenkouWk.setSbuktnmkn3(uiBean.getSbuktnmkn3());
            iwKhMeigiHenkouWk.setSbuktnmkj3(uiBean.getSbuktnmkj3());
            iwKhMeigiHenkouWk.setSbuktnmkjhukakbn3(uiBean.getSbuktnmkjhukakbn3());
            iwKhMeigiHenkouWk.setSbuktseiymd3(uiBean.getSbuktseiymd3());
            iwKhMeigiHenkouWk.setSbuktbnwari3(uiBean.getNewsbuktbnwari3());
        }
        iwKhMeigiHenkouWk.setSbuktkaijyokbn4(uiBean.getSbuktkaijyokbn4());
        if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn4())) {
            iwKhMeigiHenkouWk.setSbuktnmkn4("");
            iwKhMeigiHenkouWk.setSbuktnmkj4("");
            iwKhMeigiHenkouWk.setSbuktnmkjhukakbn4(C_KjkhukaKbn.BLNK);
            iwKhMeigiHenkouWk.setSbuktseiymd4(null);
            iwKhMeigiHenkouWk.setSbuktbnwari4(BizNumber.ZERO);
        } else {
            iwKhMeigiHenkouWk.setSbuktnmkn4(uiBean.getSbuktnmkn4());
            iwKhMeigiHenkouWk.setSbuktnmkj4(uiBean.getSbuktnmkj4());
            iwKhMeigiHenkouWk.setSbuktnmkjhukakbn4(uiBean.getSbuktnmkjhukakbn4());
            iwKhMeigiHenkouWk.setSbuktseiymd4(uiBean.getSbuktseiymd4());
            iwKhMeigiHenkouWk.setSbuktbnwari4(uiBean.getNewsbuktbnwari4());
        }
        iwKhMeigiHenkouWk.setStdrskkaijyokbn(uiBean.getStdrskkaijyokbn());
        if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())) {
            iwKhMeigiHenkouWk.setStdruktkbn(C_UktKbn.BLNK);
            iwKhMeigiHenkouWk.setStdrsknmkn("");
            iwKhMeigiHenkouWk.setStdrsknmkj("");
            iwKhMeigiHenkouWk.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
            iwKhMeigiHenkouWk.setStdrskseiymd(null);
        } else {
            iwKhMeigiHenkouWk.setStdruktkbn(uiBean.getNewstdruktkbn());
            iwKhMeigiHenkouWk.setStdrsknmkn(uiBean.getNewstdrsknmkn());
            iwKhMeigiHenkouWk.setStdrsknmkj(uiBean.getNewstdrsknmkj());
            iwKhMeigiHenkouWk.setStdrsknmkjhukakbn(uiBean.getNewstdrsknmkjhukakbn());
            iwKhMeigiHenkouWk.setStdrskseiymd(uiBean.getNewstdrskseiymd());
        }
        iwKhMeigiHenkouWk.setShsnmkj(uiBean.getShsnmkj());
        iwKhMeigiHenkouWk.setShskyno(uiBean.getShskyno());
        iwKhMeigiHenkouWk.setShsadr1kj(uiBean.getShsadr1kj());
        iwKhMeigiHenkouWk.setShsadr2kj(uiBean.getShsadr2kj());
        iwKhMeigiHenkouWk.setShsadr3kj(uiBean.getShsadr3kj());
        iwKhMeigiHenkouWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
        iwKhMeigiHenkouWk.setTyhysakuseiyhkbn(uiBean.getTyhysakuseiyhkbn());
        iwKhMeigiHenkouWk.setHassoukbn(uiBean.getHassoukbn());
        iwKhMeigiHenkouWk.setAdrhenkouumu(uiBean.getAdrhenkouumu());
        iwKhMeigiHenkouWk.setTsinyno(uiBean.getTsinyno());
        iwKhMeigiHenkouWk.setTsinadr1kj(uiBean.getTsinadr1kj());
        iwKhMeigiHenkouWk.setTsinadr2kj(uiBean.getTsinadr2kj());
        iwKhMeigiHenkouWk.setTsinadr3kj(uiBean.getTsinadr3kj());
        iwKhMeigiHenkouWk.setTsintelno(uiBean.getTsintelno());
        iwKhMeigiHenkouWk.setDai2tsintelno(uiBean.getDai2tsintelno());
        iwKhMeigiHenkouWk.setOldkyksibouymd(uiBean.getOldkyksibouymd());
        iwKhMeigiHenkouWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        iwKhMeigiHenkouWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());

        iwKhMeigiHenkouWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());

        iwKhMeigiHenkouWk.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(iwKhMeigiHenkouWk);

        hozenDomManager.insert(iwKhMeigiHenkouWk);
    }

    private void doUpdateKTMeigiHenkouWk(BizDate pSysDate, String pSysTime) {

        IW_KhMeigiHenkouWk iwKhMeigiHenkouWk =
            hozenDomManager.getKhMeigiHenkouWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

            iwKhMeigiHenkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn()) ||
            !C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn()) ||
            !C_SyorikekkaKbn.HUSYOUNIN.eq(uiBean.getSyorikekkakbn())) {
            iwKhMeigiHenkouWk.setKyknmkn(uiBean.getNewkyknmkn());
            iwKhMeigiHenkouWk.setKyknmkj(uiBean.getNewkyknmkj());
            iwKhMeigiHenkouWk.setKyknmkjkhukakbn(uiBean.getNewkyknmkjkhukakbn());
            iwKhMeigiHenkouWk.setKykseiymd(uiBean.getNewkykseiymd());
            iwKhMeigiHenkouWk.setKyksei(uiBean.getNewkyksei());
            iwKhMeigiHenkouWk.setKkkyktdk(uiBean.getNewkkkyktdk());
            iwKhMeigiHenkouWk.setHhknnmkn(uiBean.getNewhhknnmkn());
            iwKhMeigiHenkouWk.setHhknnmkj(uiBean.getNewhhknnmkj());
            iwKhMeigiHenkouWk.setHhknnmkjkhukakbn(uiBean.getNewhhknnmkjkhukakbn());
            iwKhMeigiHenkouWk.setNenkinuktkbn(uiBean.getNewnenkinuktkbn());
            iwKhMeigiHenkouWk.setSbuktnin(uiBean.getSbuktnin());
            iwKhMeigiHenkouWk.setSbuktkaijyokbn1(uiBean.getSbuktkaijyokbn1());
            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn1())) {
                iwKhMeigiHenkouWk.setSbuktkbn1(C_UktKbn.BLNK);
                iwKhMeigiHenkouWk.setSbuktnmkn1("");
                iwKhMeigiHenkouWk.setSbuktnmkj1("");
                iwKhMeigiHenkouWk.setSbuktnmkjhukakbn1(C_KjkhukaKbn.BLNK);
                iwKhMeigiHenkouWk.setSbuktseiymd1(null);
                iwKhMeigiHenkouWk.setSbuktbnwari1(BizNumber.ZERO);
            } else {
                iwKhMeigiHenkouWk.setSbuktkbn1(uiBean.getSbuktkbn1());
                iwKhMeigiHenkouWk.setSbuktnmkn1(uiBean.getSbuktnmkn1());
                iwKhMeigiHenkouWk.setSbuktnmkj1(uiBean.getSbuktnmkj1());
                iwKhMeigiHenkouWk.setSbuktnmkjhukakbn1(uiBean.getSbuktnmkjhukakbn1());
                iwKhMeigiHenkouWk.setSbuktseiymd1(uiBean.getSbuktseiymd1());
                iwKhMeigiHenkouWk.setSbuktbnwari1(uiBean.getNewsbuktbnwari1());
            }
            iwKhMeigiHenkouWk.setSbuktkaijyokbn2(uiBean.getSbuktkaijyokbn2());
            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn2())) {
                iwKhMeigiHenkouWk.setSbuktnmkn2("");
                iwKhMeigiHenkouWk.setSbuktnmkj2("");
                iwKhMeigiHenkouWk.setSbuktnmkjhukakbn2(C_KjkhukaKbn.BLNK);
                iwKhMeigiHenkouWk.setSbuktseiymd2(null);
                iwKhMeigiHenkouWk.setSbuktbnwari2(BizNumber.ZERO);
            } else {
                iwKhMeigiHenkouWk.setSbuktnmkn2(uiBean.getSbuktnmkn2());
                iwKhMeigiHenkouWk.setSbuktnmkj2(uiBean.getSbuktnmkj2());
                iwKhMeigiHenkouWk.setSbuktnmkjhukakbn2(uiBean.getSbuktnmkjhukakbn2());
                iwKhMeigiHenkouWk.setSbuktseiymd2(uiBean.getSbuktseiymd2());
                iwKhMeigiHenkouWk.setSbuktbnwari2(uiBean.getNewsbuktbnwari2());
            }
            iwKhMeigiHenkouWk.setSbuktkaijyokbn3(uiBean.getSbuktkaijyokbn3());
            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn3())) {
                iwKhMeigiHenkouWk.setSbuktnmkn3("");
                iwKhMeigiHenkouWk.setSbuktnmkj3("");
                iwKhMeigiHenkouWk.setSbuktnmkjhukakbn3(C_KjkhukaKbn.BLNK);
                iwKhMeigiHenkouWk.setSbuktseiymd3(null);
                iwKhMeigiHenkouWk.setSbuktbnwari3(BizNumber.ZERO);
            } else {
                iwKhMeigiHenkouWk.setSbuktnmkn3(uiBean.getSbuktnmkn3());
                iwKhMeigiHenkouWk.setSbuktnmkj3(uiBean.getSbuktnmkj3());
                iwKhMeigiHenkouWk.setSbuktnmkjhukakbn3(uiBean.getSbuktnmkjhukakbn3());
                iwKhMeigiHenkouWk.setSbuktseiymd3(uiBean.getSbuktseiymd3());
                iwKhMeigiHenkouWk.setSbuktbnwari3(uiBean.getNewsbuktbnwari3());
            }
            iwKhMeigiHenkouWk.setSbuktkaijyokbn4(uiBean.getSbuktkaijyokbn4());
            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getSbuktkaijyokbn4())) {
                iwKhMeigiHenkouWk.setSbuktnmkn4("");
                iwKhMeigiHenkouWk.setSbuktnmkj4("");
                iwKhMeigiHenkouWk.setSbuktnmkjhukakbn4(C_KjkhukaKbn.BLNK);
                iwKhMeigiHenkouWk.setSbuktseiymd4(null);
                iwKhMeigiHenkouWk.setSbuktbnwari4(BizNumber.ZERO);
            } else {
                iwKhMeigiHenkouWk.setSbuktnmkn4(uiBean.getSbuktnmkn4());
                iwKhMeigiHenkouWk.setSbuktnmkj4(uiBean.getSbuktnmkj4());
                iwKhMeigiHenkouWk.setSbuktnmkjhukakbn4(uiBean.getSbuktnmkjhukakbn4());
                iwKhMeigiHenkouWk.setSbuktseiymd4(uiBean.getSbuktseiymd4());
                iwKhMeigiHenkouWk.setSbuktbnwari4(uiBean.getNewsbuktbnwari4());
            }
            iwKhMeigiHenkouWk.setStdrskkaijyokbn(uiBean.getStdrskkaijyokbn());
            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())) {
                iwKhMeigiHenkouWk.setStdruktkbn(C_UktKbn.BLNK);
                iwKhMeigiHenkouWk.setStdrsknmkn("");
                iwKhMeigiHenkouWk.setStdrsknmkj("");
                iwKhMeigiHenkouWk.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
                iwKhMeigiHenkouWk.setStdrskseiymd(null);
            } else {
                iwKhMeigiHenkouWk.setStdruktkbn(uiBean.getNewstdruktkbn());
                iwKhMeigiHenkouWk.setStdrsknmkn(uiBean.getNewstdrsknmkn());
                iwKhMeigiHenkouWk.setStdrsknmkj(uiBean.getNewstdrsknmkj());
                iwKhMeigiHenkouWk.setStdrsknmkjhukakbn(uiBean.getNewstdrsknmkjhukakbn());
                iwKhMeigiHenkouWk.setStdrskseiymd(uiBean.getNewstdrskseiymd());
            }
            iwKhMeigiHenkouWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            iwKhMeigiHenkouWk.setTyhysakuseiyhkbn(uiBean.getTyhysakuseiyhkbn());
            iwKhMeigiHenkouWk.setHassoukbn(uiBean.getHassoukbn());
            iwKhMeigiHenkouWk.setAdrhenkouumu(uiBean.getAdrhenkouumu());
            iwKhMeigiHenkouWk.setTsinyno(uiBean.getTsinyno());
            iwKhMeigiHenkouWk.setTsinadr1kj(uiBean.getTsinadr1kj());
            iwKhMeigiHenkouWk.setTsinadr2kj(uiBean.getTsinadr2kj());
            iwKhMeigiHenkouWk.setTsinadr3kj(uiBean.getTsinadr3kj());
            iwKhMeigiHenkouWk.setTsintelno(uiBean.getTsintelno());
            iwKhMeigiHenkouWk.setDai2tsintelno(uiBean.getDai2tsintelno());
            iwKhMeigiHenkouWk.setOldkyksibouymd(uiBean.getOldkyksibouymd());
            iwKhMeigiHenkouWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        iwKhMeigiHenkouWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());

        iwKhMeigiHenkouWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());

        iwKhMeigiHenkouWk.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(iwKhMeigiHenkouWk);

        hozenDomManager.update(iwKhMeigiHenkouWk);
    }

    private void makeTetudukiRireki(String pYoukyuuNo, String pSikibetuKey) {

        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setSikibetuKey(pSikibetuKey);
        IT_KhTtdkRireki khTtdkRireki = uiBean.getKykKihon().createKhTtdkRireki();
        khTtdkRireki.setHenkousikibetukey(pSikibetuKey);

        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;
        if (C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu())) {
            syoriKbn = C_SyoriKbn.MEIHEN_BETUHEN;
        }
        else if (C_Meigihnkjiyuu.KAISEIKAIMEI.eq(uiBean.getMeigihnkjiyuu())) {
            syoriKbn = C_SyoriKbn.MEIHEN_KAISEIKAIMEI;
        }
        else if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {
            syoriKbn = C_SyoriKbn.MEIHEN_KYKSIBOU;
        }
        else if (C_Meigihnkjiyuu.SONOTA.eq(uiBean.getMeigihnkjiyuu())) {
            syoriKbn = C_SyoriKbn.MEIHEN_HHKKAISEIUKEHENKOU;
        }

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        editTtdkRirekiTblParam.setSysTime(sysTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());
        editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        editTtdkRirekiTblParam.setYoukyuuNo(pYoukyuuNo);
        editTtdkRirekiTblParam.setSyoriKbn(syoriKbn);

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    private void makeKykSyaHenkouRireki(String pSikibetuKey, BizDate pSysDate, String pSysTime, IT_KykSyouhn pKykSyouhn) {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String tsinyno = "";
        String tsinadr1kj = "";
        String tsinadr2kj = "";
        String tsinadr3kj = "";
        String tsintelno = "";
        String dai2tsintelno = "";

        if (C_UmuKbn.ARI.eq(uiBean.getAdrhenkouumu())) {
            tsinyno = uiBean.getTsinyno();
            tsinadr1kj = uiBean.getTsinadr1kj();
            tsinadr2kj = uiBean.getTsinadr2kj();
            tsinadr3kj = uiBean.getTsinadr3kj();
            tsintelno = uiBean.getTsintelno();
            dai2tsintelno = uiBean.getDai2tsintelno();
        }
        else {
            tsinyno = uiBean.getVtssktsinyno();
            tsinadr1kj = uiBean.getVtssktsinadr1kj();
            tsinadr2kj = uiBean.getVtssktsinadr2kj();
            tsinadr3kj = uiBean.getVtssktsinadr3kj();
            tsintelno = uiBean.getVtssktsintelno();
            dai2tsintelno = uiBean.getVtsskdai2tsintelno();
        }

        KeisanHtyKeihi keisanHtyKeihi = SWAKInjector.getInstance(KeisanHtyKeihi.class);
        keisanHtyKeihi.exec(uiBean.getSyono(), pKykSyouhn.getKyktuukasyu());
        BizCurrency yenHtyKeihi = keisanHtyKeihi.getYenHtyKeihi();

        IT_KykSyaHenkouRireki kykSyaHenkouRireki =
            uiBean.getKykKihon().getKhTtdkRirekiByHenkousikibetukey(pSikibetuKey).createKykSyaHenkouRireki();

        if (C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu())) {
            kykSyaHenkouRireki.setMeighnksyoriymd(pSysDate);
            kykSyaHenkouRireki.setMeigihnkjiyuu(uiBean.getMeigihnkjiyuu());
            kykSyaHenkouRireki.setKouryokuhasseiymd(pSysDate);
            kykSyaHenkouRireki.setOldkyknmkn(uiBean.getVkykskyknmkn());
            kykSyaHenkouRireki.setOldkyknmkj(uiBean.getVkykskyknmkj());
            kykSyaHenkouRireki.setOldkyknmkjkhukakbn(uiBean.getVkykskyknmkjkhukakbn());
            kykSyaHenkouRireki.setOldkykseiymd(uiBean.getVkykskykseiymd());
            kykSyaHenkouRireki.setOldkyksei(uiBean.getVkykskyksei());
            kykSyaHenkouRireki.setOldkkkyktdk(uiBean.getVkykskkkyktdk());
            kykSyaHenkouRireki.setOldtsinyno(uiBean.getVtssktsinyno());
            kykSyaHenkouRireki.setOldtsinadr1kj(uiBean.getVtssktsinadr1kj());
            kykSyaHenkouRireki.setOldtsinadr2kj(uiBean.getVtssktsinadr2kj());
            kykSyaHenkouRireki.setOldtsinadr3kj(uiBean.getVtssktsinadr3kj());
            kykSyaHenkouRireki.setOldtsintelno(uiBean.getVtssktsintelno());
            kykSyaHenkouRireki.setOlddai2tsintelno(uiBean.getVtsskdai2tsintelno());
            kykSyaHenkouRireki.setTsinyno(tsinyno);
            kykSyaHenkouRireki.setTsinadr1kj(tsinadr1kj);
            kykSyaHenkouRireki.setTsinadr2kj(tsinadr2kj);
            kykSyaHenkouRireki.setTsinadr3kj(tsinadr3kj);
            kykSyaHenkouRireki.setTsintelno(tsintelno);
            kykSyaHenkouRireki.setDai2tsintelno(dai2tsintelno);
            kykSyaHenkouRireki.setKihrkmpsgk(yenHtyKeihi);
            kykSyaHenkouRireki.setOldkykkihrkmp(BizCurrency.valueOf(0));
            kykSyaHenkouRireki.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            kykSyaHenkouRireki.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            kykSyaHenkouRireki.setGyoumuKousinTime(pSysTime);
        }
        else if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {
            BizCurrency yenGenKykSyaHtyKeihi = keisanHtyKeihi.getYenGenKykSyaHtyKeihi();
            BizNumber yenShrkawaserate = BizNumber.ZERO;
            BizNumber gaiKashrKawaseRate = BizNumber.ZERO;
            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            if (!C_Tuukasyu.JPY.eq(pKykSyouhn.getKyktuukasyu()) ) {

                getKawaseRate.exec(
                    uiBean.getSyoruiukeymd(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    pKykSyouhn.getKyktuukasyu(),
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                yenShrkawaserate = getKawaseRate.getKawaserate();

                getKawaseRate.exec(
                    uiBean.getSyoruiukeymd(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    pKykSyouhn.getKyktuukasyu(),
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                gaiKashrKawaseRate  = getKawaseRate.getKawaserate();
            }

            KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);
            KeisanKaiyakuBean keisanKaiyakuInBean = new KeisanKaiyakuBean();
            keisanKaiyakuInBean.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            keisanKaiyakuInBean.setKaiykymd(uiBean.getSyoruiukeymd());
            keisanKaiyakuInBean.setYenshrkwsrate(yenShrkawaserate);
            keisanKaiyakuInBean.setGkshrkwsrate(gaiKashrKawaseRate);

            C_ErrorKbn errorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
                KeisanCommonKaiyaku.KINOUBUNRUI_ONLINE,
                uiBean.getKykKihon(),
                pSysDate,
                keisanKaiyakuInBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException("解約共通計算が実行できませんでした。");
            }

            KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
            BizCurrency kaiyakuhrgoukeigk = keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk();
            BizCurrency sonotashrgkYen = keisanCommonKaiyakuOutBean.getSonotashrgkYen();
            BizCurrency shrgkkeiYen = keisanCommonKaiyakuOutBean.getShrgkkeiYen();

            BizCurrency kaiyakuhrstgk = BizCurrency.valueOf(0);
            BizCurrency kykadrHkrrsonotashrgkYen = BizCurrency.valueOf(0);
            BizCurrency yenkaiyakuhrstgk = BizCurrency.valueOf(0);
            BizNumber yenkansantkykwsrate = BizNumber.ZERO;
            BizDate yenkansantkykwsratekjymd = null;

            if (!C_Tuukasyu.JPY.eq(pKykSyouhn.getKyktuukasyu()) ) {
                getKawaseRate.exec(
                    uiBean.getSyoruiukeymd(),
                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                    pKykSyouhn.getKyktuukasyu(),
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTB,
                    C_KawasetsryKbn.JISSEIRATE,
                    C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                BizNumber zeimukwsrate = getKawaseRate.getKawaserate();
                BizDate zeimukwsratekjnymd = getKawaseRate.getKwsrateKjYmd();

                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                BizCurrency tuukgk = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    kaiyakuhrgoukeigk,
                    zeimukwsrate,
                    C_HasuusyoriKbn.SUTE);

                kaiyakuhrstgk = kaiyakuhrgoukeigk;
                kykadrHkrrsonotashrgkYen = sonotashrgkYen;
                yenkaiyakuhrstgk = tuukgk.add(kykadrHkrrsonotashrgkYen);
                yenkansantkykwsrate = zeimukwsrate;
                yenkansantkykwsratekjymd = zeimukwsratekjnymd;
            }
            else {
                kaiyakuhrstgk = shrgkkeiYen;
                yenkaiyakuhrstgk = shrgkkeiYen;
            }

            kykSyaHenkouRireki.setMeighnksyoriymd(pSysDate);
            kykSyaHenkouRireki.setMeigihnkjiyuu(uiBean.getMeigihnkjiyuu());
            kykSyaHenkouRireki.setKouryokuhasseiymd(uiBean.getSyoruiukeymd());
            kykSyaHenkouRireki.setOldkyksibouymd(uiBean.getOldkyksibouymd());
            kykSyaHenkouRireki.setOldkyknmkn(uiBean.getVkykskyknmkn());
            kykSyaHenkouRireki.setOldkyknmkj(uiBean.getVkykskyknmkj());
            kykSyaHenkouRireki.setOldkyknmkjkhukakbn(uiBean.getVkykskyknmkjkhukakbn());
            kykSyaHenkouRireki.setOldkykseiymd(uiBean.getVkykskykseiymd());
            kykSyaHenkouRireki.setOldkyksei(uiBean.getVkykskyksei());
            kykSyaHenkouRireki.setOldkkkyktdk(uiBean.getVkykskkkyktdk());
            kykSyaHenkouRireki.setOldtsinyno(uiBean.getVtssktsinyno());
            kykSyaHenkouRireki.setOldtsinadr1kj(uiBean.getVtssktsinadr1kj());
            kykSyaHenkouRireki.setOldtsinadr2kj(uiBean.getVtssktsinadr2kj());
            kykSyaHenkouRireki.setOldtsinadr3kj(uiBean.getVtssktsinadr3kj());
            kykSyaHenkouRireki.setOldtsintelno(uiBean.getVtssktsintelno());
            kykSyaHenkouRireki.setOlddai2tsintelno(uiBean.getVtsskdai2tsintelno());
            kykSyaHenkouRireki.setTsinyno(tsinyno);
            kykSyaHenkouRireki.setTsinadr1kj(tsinadr1kj);
            kykSyaHenkouRireki.setTsinadr2kj(tsinadr2kj);
            kykSyaHenkouRireki.setTsinadr3kj(tsinadr3kj);
            kykSyaHenkouRireki.setTsintelno(tsintelno);
            kykSyaHenkouRireki.setDai2tsintelno(dai2tsintelno);
            kykSyaHenkouRireki.setKyktuukasyu(pKykSyouhn.getKyktuukasyu());
            kykSyaHenkouRireki.setKaiyakuhrstgk(kaiyakuhrstgk);
            kykSyaHenkouRireki.setYenkaiyakuhrstgk(yenkaiyakuhrstgk);
            kykSyaHenkouRireki.setYenkansantkykwsrate(yenkansantkykwsrate);
            kykSyaHenkouRireki.setYenkansantkykwsrateymd(yenkansantkykwsratekjymd);
            kykSyaHenkouRireki.setKihrkmpsgk(yenHtyKeihi);
            kykSyaHenkouRireki.setOldkykkihrkmp(yenGenKykSyaHtyKeihi);
            kykSyaHenkouRireki.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            kykSyaHenkouRireki.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            kykSyaHenkouRireki.setGyoumuKousinTime(pSysTime);
            kykSyaHenkouRireki.setSonotashrkngkyen(kykadrHkrrsonotashrgkYen);
        }

        BizPropertyInitializer.initialize(kykSyaHenkouRireki);
        hozenDomManager.insert(kykSyaHenkouRireki);
    }

    private void makeTyouhyou(KhozenCommonParam pKhozenCommonParam) {

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        if (C_TyhysakuseiyhKbn.YOU.eq(uiBean.getTyhysakuseiyhkbn())) {

            C_SyoruiCdKbn syoruiCdKbn[];

            EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);

            EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
            editHokenSyoukenParam.setCalckijyunYMD(BizDate.getSysDate());

            editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MEIGIHNK);
            editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
            editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR);
            editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);

            if (C_UmuKbn.ARI.eq(uiBean.getAdrhenkouumu())) {
                editTtdkKanryouParam.setShsyno(uiBean.getTsinyno());
                editTtdkKanryouParam.setShsadr1kj(uiBean.getTsinadr1kj());
                editTtdkKanryouParam.setShsadr2kj(uiBean.getTsinadr2kj());
                editTtdkKanryouParam.setShsadr3kj(uiBean.getTsinadr3kj());
            }

            syoruiCdKbn = new C_SyoruiCdKbn[3];
            syoruiCdKbn[0] = C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR;
            syoruiCdKbn[1] = C_SyoruiCdKbn.KK_HKNSYKN;
            syoruiCdKbn[2] = C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR;

            List<IT_KhHenkouUktk> khHenkouUktkLst = hozenDomManager.getKhHenkouUktksBySyono(uiBean.getSyono());

            C_HassouKbn hassouKbn = uiBean.getHassoukbn();

            if (khHenkouUktkLst.size() > 0) {
                BizDate uktkYmd = khHenkouUktkLst.get(0).getUktkymd();

                GetProcessHistoryResultBean resultBean = WorkFlowUtility.getProcessHistory(
                    uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
                List<ProcessHistoryBean> processHistoryBeanLst = resultBean.getProcessHistoryBeanList();

                if (WorkFlowResultConstants.RESULT_WARN.equals(resultBean.getSyorikekkaStatus()) ||
                    WorkFlowResultConstants.RESULT_NG.equals(resultBean.getSyorikekkaStatus()) ||
                    WorkFlowResultConstants.RESULT_LOCK.equals(resultBean.getSyorikekkaStatus()) ||
                    WorkFlowResultConstants.RESULT_TORIKESIZUMI.equals(resultBean.getSyorikekkaStatus())) {
                    logger.error("ワークフロー呼出Utility#工程履歴取得");
                    logger.error("エラーコード：" + resultBean.getSyousaiMessageCd());
                    logger.error("エラーメッセージ：" + resultBean.getSyousaiMessage());

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EAS0037));
                }
                else if (WorkFlowResultConstants.RESULT_OK.equals(resultBean.getSyorikekkaStatus())) {
                    for (ProcessHistoryBean processHistoryBean : processHistoryBeanLst) {
                        String taskNm = processHistoryBean.getTaskNm();

                        if (IKhozenCommonConstants.NODEID_INPUT.equals(taskNm)) {
                            BizDate processYmd = BizDate
                                .valueOf(processHistoryBean.getProcessYmdTime().substring(0, 8));
                            if (BizDateUtil.compareYmdByYm(processYmd, uktkYmd) == BizDateUtil.COMPARE_EQUAL ||
                                BizDateUtil.compareYmdByYm(processYmd, uktkYmd) == BizDateUtil.COMPARE_LESSER) {
                                hassouKbn = C_HassouKbn.HONSYAKAISOU;
                                break;
                            }
                        }
                    }
                }
            }

            List<TyokusouTaisyouBean> tyokusouTaisyouLst = Lists.newArrayList();
            C_StdrsktkyhnkKbn tyokusouStdrsktkyhnkKbn = C_StdrsktkyhnkKbn.BLNK;
            C_StdrsktkyhnkKbn syoukenStdrsktkyhnkKbn = C_StdrsktkyhnkKbn.BLNK;

            if (C_UmuKbn.ARI.eq(uiBean.getStdrskhenkouumu())) {
                if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())) {
                    if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getVstsksiteidruktkbn()) ||
                        C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getVstsksiteidruktkbn())) {
                        C_TyokusouhtkekKbn tyokusouhtkekKbn = hanteiTrkkzkTyokusou(pKhozenCommonParam,
                            uiBean.getVstsksiteidruktkbn());

                        if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                            tyokusouStdrsktkyhnkKbn = C_StdrsktkyhnkKbn.KAIJYO;

                            TyokusouTaisyouBean tyokusouTaisyouBean = setTyokusouTaisyou(
                                uiBean.getVstsksiteidruktkbn(), tyokusouStdrsktkyhnkKbn);

                            tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                        }
                    }
                }
                else {
                    if (!uiBean.getVstsksiteidruktkbn().eq(uiBean.getNewstdruktkbn())) {
                        if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getNewstdruktkbn()) ||
                            C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getNewstdruktkbn())) {
                            C_TyokusouhtkekKbn tyokusouhtkekKbn = hanteiTrkkzkTyokusou(pKhozenCommonParam,
                                uiBean.getNewstdruktkbn());

                            if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {
                                tyokusouStdrsktkyhnkKbn = C_StdrsktkyhnkKbn.HENKOU;

                                TyokusouTaisyouBean tyokusouTaisyouBean = setTyokusouTaisyou(
                                    uiBean.getNewstdruktkbn(), tyokusouStdrsktkyhnkKbn);

                                tyokusouTaisyouLst.add(tyokusouTaisyouBean);
                            }
                            else {
                                syoukenStdrsktkyhnkKbn = C_StdrsktkyhnkKbn.HENKOU;
                            }
                        }
                        else {
                            syoukenStdrsktkyhnkKbn = C_StdrsktkyhnkKbn.HENKOU;
                        }
                    }
                    else if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getVstsksiteidruktkbn())) {
                        syoukenStdrsktkyhnkKbn = uketorininBrtuninHikaku(uiBean.getVstskstdrsknmkn(),
                            uiBean.getVstskstdrsknmkj(), uiBean.getVstskstdrskseiymd(), uiBean.getNewstdrsknmkn(),
                            uiBean.getNewstdrsknmkj(), uiBean.getNewstdrskseiymd());
                    }
                    else if (C_UktKbn.KYK.eq(uiBean.getVstsksiteidruktkbn())) {
                        if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu()) ||
                            C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu())) {
                            syoukenStdrsktkyhnkKbn = C_StdrsktkyhnkKbn.HENKOU;
                        }
                    }
                    else if (C_UktKbn.SBUK.eq(uiBean.getVstsksiteidruktkbn())) {
                        if (C_UmuKbn.ARI.eq(uiBean.getSbukt1inpumu())) {
                            syoukenStdrsktkyhnkKbn = uketorininBrtuninHikaku(uiBean.getVshktdispsbuktnmkn1(),
                                uiBean.getVshktdispsbuktnmkj1(), uiBean.getVshktdispsbuktseiymd1(), uiBean.getSbuktnmkn1(),
                                uiBean.getSbuktnmkj1(), uiBean.getSbuktseiymd1());
                        }
                    }
                }
            }
            else {
                if (C_UktKbn.SBUK.eq(uiBean.getVstsksiteidruktkbn())) {
                    if (C_UmuKbn.ARI.eq(uiBean.getSbukt1inpumu())) {
                        syoukenStdrsktkyhnkKbn = uketorininBrtuninHikaku(uiBean.getVshktdispsbuktnmkn1(),
                            uiBean.getVshktdispsbuktnmkj1(), uiBean.getVshktdispsbuktseiymd1(), uiBean.getSbuktnmkn1(),
                            uiBean.getSbuktnmkj1(), uiBean.getSbuktseiymd1());
                    }
                }
            }

            editHokenSyoukenParam.setStdrsktkyhnkKbn(syoukenStdrsktkyhnkKbn);
            editTtdkKanryouParam.setStdrsktkyhnkKbn(tyokusouStdrsktkyhnkKbn);
            editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouLst);

            khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
            khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);
            khozenTyouhyouCtl.setHassoukbn(hassouKbn);

            khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam, uiBean.getSyono(),
                syoruiCdKbn, C_YouhiKbn.HUYOU);
        }

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());

        if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {
            IT_KhTtdkRireki iT_KhTtdkRireki = khMeigiHenkouDao.getKhTtdkRirekisMkhgktttYendthnktorikesiBySyono(uiBean
                .getSyono());

            if (iT_KhTtdkRireki != null) {

                if (BizDateUtil.COMPARE_LESSER == BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(),
                    iT_KhTtdkRireki.getSyoriYmd())) {

                    BizDate syoriYmd = BizDate.getSysDate().getPreviousDay().getRekijyou();

                    List<String> JimurenrakuMsgList = new ArrayList<String>();

                    JimurenrakuMsgList.add("書類受付してから１日以上経過しています。");
                    JimurenrakuMsgList.add("書類受付日（" + DateFormatUtil.dateKANJINoEx(uiBean.getSyoruiukeymd())
                        + "）～処理日の前日（" + DateFormatUtil.dateKANJINoEx(syoriYmd) + "）の期間で");
                    JimurenrakuMsgList.add("目標額到達判定を実施してください。");

                    EditJimuRenrakuhyouParam editJimuRenrakuhyouParam = SWAKInjector
                        .getInstance(EditJimuRenrakuhyouParam.class);

                    editJimuRenrakuhyouParam.setJimurenrakuMsgList(JimurenrakuMsgList);

                    khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

                    khozenTyouhyouCtl.setSyoriYmd(BizDate.getSysDate());

                    khozenTyouhyouCtl.setEditJimuRenrakuhyouParam(editJimuRenrakuhyouParam);

                    khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam, uiBean.getSyono(),
                        new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_JIMURENRAKU_MEIGIHNK }, C_YouhiKbn.YOU);

                }
            }
        }
    }

    private void doJikouteikanri(String pSyono, C_SyorikekkaKbn pSyorikekkaKbn) {

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

        khRuleBean.setSyoriKekkaKbn(pSyorikekkaKbn);
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");

        String syanaiMsg = uiBean.getSyanaicommentkh();

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

        khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo()
            .getJimuTetuzukiCd(), bzCommonLockProcess.getKouteiLockKey(), syanaiMsg, khRuleBean);

        bzCommonLockProcess.unlockProcess();
    }

    private void makeKhJyuusyoHenkouWk() {
        String sysTime = BizDate.getSysDateTimeMilli();

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
        C_UmuKbn kouteiUmu = checkProcessKaishi.exec(uiBean.getSyono(),
            IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU);

        if (C_UmuKbn.ARI.eq(kouteiUmu)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA1020,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()),
                bzGetProcessSummaryOutBean.getJimuTetuzukiNm());
        }

        BzProcessCreateInBean bzProcessCreateInBean = SWAKInjector.getInstance(BzProcessCreateInBean.class);
        bzProcessCreateInBean.setSyoNo(uiBean.getSyono());
        bzProcessCreateInBean.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU);

        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

        if (C_KouteiSakuseiKekkaKbn.FAILURE.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0008));
        }

        String kouteikanriId = bzProcessCreateOutBean.getKouteiKanriId();
        uiBean.getBzWorkflowInfo().setKouteiKanriId(kouteikanriId);

        bzCommonLockProcess.lockProcess(kouteikanriId, IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU);

        BzForceProcessForward bzForceProcessForward = SWAKInjector.getInstance(BzForceProcessForward.class);
        bzForceProcessForward.exec(
            kouteikanriId,
            IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU,
            C_KhkinouModeIdKbn.SYOUNIN.getValue(),
            bzCommonLockProcess.getKouteiLockKey());

        UpdateJimustartymd updateJimustartymd = SWAKInjector.getInstance(UpdateJimustartymd.class);
        updateJimustartymd.exec(
            IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU,
            kouteikanriId,
            bzCommonLockProcess.getKouteiLockKey(),
            sysTime);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IW_KhJyuusyoHenkouWk khJyuusyoHenkouWk = new IW_KhJyuusyoHenkouWk();
        khJyuusyoHenkouWk.setKouteikanriid(kouteikanriId);
        khJyuusyoHenkouWk.setSyono(uiBean.getSyono());
        khJyuusyoHenkouWk.setTsinyno(uiBean.getTsinyno());
        khJyuusyoHenkouWk.setTsinadr1kj(uiBean.getTsinadr1kj());
        khJyuusyoHenkouWk.setTsinadr2kj(uiBean.getTsinadr2kj());
        khJyuusyoHenkouWk.setTsinadr3kj(uiBean.getTsinadr3kj());
        khJyuusyoHenkouWk.setTsintelno(uiBean.getTsintelno());
        khJyuusyoHenkouWk.setDai2tsintelno(uiBean.getDai2tsintelno());
        khJyuusyoHenkouWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
        khJyuusyoHenkouWk.setTyhysakuseiyhkbn(C_TyhysakuseiyhKbn.HUYOU);
        khJyuusyoHenkouWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        khJyuusyoHenkouWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        khJyuusyoHenkouWk.setGyoumuKousinTime(sysTime);
        khJyuusyoHenkouWk.setDoujiskkinouid(khozenCommonParam.getFunctionId());

        BizPropertyInitializer.initialize(khJyuusyoHenkouWk);
        hozenDomManager.insert(khJyuusyoHenkouWk);

        bzCommonLockProcess.unlockProcess();
    }

    private void makeTyouhyous() {

        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);

        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);

        editSouhuannaiParam.setMeigihnkjiyuu(uiBean.getMeigihnkjiyuu());

        if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {

            editSouhuannaiParam.setShsnmkj(uiBean.getShsnmkj());
            editSouhuannaiParam.setShsyno(uiBean.getShskyno());
            editSouhuannaiParam.setShsadr1kj(uiBean.getShsadr1kj());
            editSouhuannaiParam.setShsadr2kj(uiBean.getShsadr2kj());
            editSouhuannaiParam.setShsadr3kj(uiBean.getShsadr3kj());

        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        List<IT_KykSyouhn> kykSyouhnLst = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);
        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);
        hanteiTyotikuseihokenBean.setSyouhnCd(kykSyouhnLst.get(0).getSyouhncd());
        hanteiTyotikuseihokenBean.setSyouhnsdNo(kykSyouhnLst.get(0).getSyouhnsdno());
        hanteiTyotikuseihokenBean.setHrkkaisuu(uiBean.getKykKihon().getHrkkaisuu());
        hanteiTyotikuseihokenBean.setHrkkeiro(uiBean.getKykKihon().getHrkkeiro());

        setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);
        C_UmuKbn houteityotkseiumu = setTyotikuseihokenhyouji.getHouteityotkhknhyj();

        if (C_UmuKbn.ARI.eq(houteityotkseiumu) &&
            (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu()) || C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()))) {
            editSouhuannaiParam.setTrhkjikakumukbn(C_UmuKbn.ARI);
        }

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);


        if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {
            editSeikyuusyoParam.setKyksbumu(C_KyksyaSibouUmuKbn.KYKSBARI);
        }

        editSeikyuusyoParam.setMeigihnkjiyuu(uiBean.getMeigihnkjiyuu());

        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);



        List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<C_SyoruiCdKbn>();
        syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_MEIGIHNK_SOUHU);
        syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

        if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {
            syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN);
        }

        if (C_UmuKbn.ARI.eq(houteityotkseiumu)) {

            if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {

                syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK);
            }
            if (C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu())) {

                syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK);
            }
        }

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(),
            syoruiCdKbnLst.toArray(new C_SyoruiCdKbn[0]), C_YouhiKbn.YOU);

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());
    }

    private void updateKTAeoiInfo() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String functionId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();

        IT_KykKihon kykKihon = uiBean.getKykKihon();
        List<IT_AeoiInfo> aeoiInfoLst = kykKihon.getAeoiInfos();

        if (aeoiInfoLst != null && aeoiInfoLst.size() >= 1) {

            if (aeoiInfoLst.get(uiBean.getAeoitaisyousyacnt() - 1).getAeoikouryokuendymd() == null) {
                aeoiInfoLst.get(uiBean.getAeoitaisyousyacnt() - 1).setAeoikouryokuendymd(sysDate);
                aeoiInfoLst.get(uiBean.getAeoitaisyousyacnt() - 1).setGyoumuKousinKinou(functionId);
                aeoiInfoLst.get(uiBean.getAeoitaisyousyacnt() - 1).setGyoumuKousinsyaId(userId);
                aeoiInfoLst.get(uiBean.getAeoitaisyousyacnt() - 1).setGyoumuKousinTime(sysTime);
            }
        }
    }

    private void doJikouteikanris() {

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        if (C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {

            khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
            khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.ARI);
        }

        if (C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu())) {

            khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.ARI);
        }

        hozenPreReportRenkeiBean.setSyoNo(uiBean.getSyono());
        hozenPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());
        hozenPreReportRenkeiBean.setSyoriComment("");
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

    }

    private BizNumber NullToOptional(BizNumber pVal) {
        if (pVal == null) {
            return BizNumber.optional();
        }
        return pVal;
    }

    private PdfBuilder joinPdf(String key, C_Meigihnkjiyuu jiyu) {

        try {

            List<AT_TyouhyouKensaku> tyouhyouKensakuList = bizDomManager.getTyouhyouKensakusByTyouhyouJoinKey(key);

            PdfBuilder pdfBuilder = new PdfBuilder();
            String sksPath = null;
            String trhkPath = null;

            String root = SWAK.getApplicationRootPath();
            YuyuHozenConfig conf = YuyuHozenConfig.getInstance();
            if (C_Meigihnkjiyuu.KYK.eq(jiyu)) {
                if (C_UmuKbn.ARI.eq(uiBean.getNkhknumu())) {
                    sksPath = root + conf.getMeigihnkSksMihonBetsuzinNenkinFilePath();
                    trhkPath = root + conf.getMeigihnkTrhkkakSecondFilePath();
                }
                else {
                    sksPath = root + conf.getMeigihnkSksMihonBetsuzinFilePath();
                    trhkPath = root + conf.getMeigihnkTrhkkakSecondFilePath();
                }
            } else if (C_Meigihnkjiyuu.KAISEIKAIMEI.eq(jiyu)) {
                if (C_UmuKbn.ARI.eq(uiBean.getNkhknumu())) {
                    sksPath = root + conf.getMeigihnkSksMihonKaiseiNenkinFilePath();
                }
                else {
                    sksPath = root + conf.getMeigihnkSksMihonKaiseiFilePath();
                }
            } else if (C_Meigihnkjiyuu.KYKSB.eq(jiyu)) {
                if (C_UmuKbn.ARI.eq(uiBean.getNkhknumu())) {
                    sksPath = root + conf.getMeigihnkSksMihonKykSibouNenkinFilePath();
                    trhkPath = root + conf.getMeigihnkTrhkkakSecondFilePath();
                }
                else {
                    sksPath = root + conf.getMeigihnkSksMihonKykSibouFilePath();
                    trhkPath = root + conf.getMeigihnkTrhkkakSecondFilePath();
                }
            } else if (C_Meigihnkjiyuu.SONOTA.eq(jiyu)) {
                if (C_UmuKbn.ARI.eq(uiBean.getNkhknumu())) {
                    sksPath = root + conf.getMeigihnkSksMihonHhknsyaKaiseiNenkinFilePath();
                }
                else {
                    sksPath = root + conf.getMeigihnkSksMihonHhknsyaKaiseiFilePath();
                }
            }

            String souhuKey = tyouhyouKensakuList.get(0).getReportKey();
            String sksKey = tyouhyouKensakuList.get(1).getReportKey();

            byte[] sksBin = dbaOutputReport.getPdfImages(new String[] { souhuKey, sksKey });

            pdfBuilder.append(new PdfReader(sksBin));

            pdfBuilder.append(new PdfReader(sksPath));
            if (C_Meigihnkjiyuu.KYK.eq(jiyu)) {
                String trhkKey = tyouhyouKensakuList.get(2).getReportKey();

                byte[] trhkBin = dbaOutputReport.getPdfImages(new String[] { trhkKey });

                pdfBuilder.append(new PdfReader(trhkBin));
                pdfBuilder.append(new PdfReader(trhkPath));
            } else if (C_Meigihnkjiyuu.KYKSB.eq(jiyu)) {
                String daihyouKey = tyouhyouKensakuList.get(2).getReportKey();
                String trhkKey = tyouhyouKensakuList.get(3).getReportKey();

                byte[] trhkBin = dbaOutputReport.getPdfImages(new String[] { daihyouKey, trhkKey });

                pdfBuilder.append(new PdfReader(trhkBin));
                pdfBuilder.append(new PdfReader(trhkPath));

            }

            return pdfBuilder;

        } catch (IOException e) {
            throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));
        }
    }

    private boolean isEqualStr(String pNaiyou1, String pNaiyou2) {

        String value = "";
        if (!BizUtil.isBlank(pNaiyou1)) {
            value = pNaiyou1;
        }

        boolean hanteiKekka = pNaiyou2.equals(value);

        return hanteiKekka;
    }

    private void checkHrmbr() {
        Long khHenreikinYendtMbrCount = hozenDomManager.getKhHenreikinYendtMbrCountBySyono(uiBean.getSyono());
        if (khHenreikinYendtMbrCount > 0) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA1017);
        }
    }

    private void checkKjnnkpZeiseitkkktkykhukaSyorikahi() {

        if (C_UmuKbn.ARI.eq(uiBean.getZeiseitkkktkykhukaumu()) &&
            (C_UmuKbn.ARI.eq(uiBean.getKyktdkhnkumu()) || C_UmuKbn.ARI.eq(uiBean.getNkukthenkouumu()))) {

            if (!C_Tdk.HONNIN.eq(kkkyktdkMenber) && !C_UktKbn.HHKN.eq(uktKbnMenber)) {
                throw new BizLogicException(MessageId.EIF1091);
            }
        }
    }

    private void checkKjnnkpZeiseitkkktkykSyoumetu() {

        if (C_UmuKbn.ARI.eq(uiBean.getZeiseitkkktkykhukaumu())  &&
            C_UmuKbn.ARI.eq(uiBean.getKyktdkhnkumu())) {

            if (!checkZeiseiTkkkTkykHukaJk()) {
                throw new BizLogicException(MessageId.EIF1092);
            }
        }
    }

    private void checkZeiseitkkktkykhukajyouken() {

        if (C_UmuKbn.ARI.eq(uiBean.getZeiseitkkktkykhukaumu())  &&
            C_UmuKbn.ARI.eq(uiBean.getKyktdkhnkumu())) {

            if (!checkZeiseiTkkkTkykHukaJk()) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF1032);
            }
        }
    }

    private void printZeiseitkkktkyktyuutohukaMsg() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0);

        if (C_UmuKbn.ARI.eq(kykSyouhn.getSyouhnZokusei().getZeiseitekikakuumu()) &&
            C_UmuKbn.NONE.eq(uiBean.getZeiseitkkktkykhukaumu())) {

            if (C_UmuKbn.ARI.eq(uiBean.getKyktdkhnkumu()) || C_UmuKbn.ARI.eq(uiBean.getNkukthenkouumu())) {

                if (checkZeiseiTkkkTkykHukaJk()) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.IIF1015);
                }
            }
        }
    }

    private boolean checkZeiseiTkkkTkykHukaJk() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJk(
            kkkyktdkMenber,
            uktKbnMenber,
            kykSyouhn.getHhknnen(),
            kykSyouhn.getHrkkknsmnkbn(),
            kykSyouhn.getHrkkkn(),
            kykSyouhn.getHknkknsmnkbn(),
            kykSyouhn.getHknkkn(),
            kykSyouhn.getNksyukbn(),
            kykSyouhn.getNenkinkkn());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException("税制適格特約付加条件チェックが実行できませんでした。");
        }

        return checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk();
    }

    private void checkKzkykdou() {

        IT_Kouza kouza = uiBean.getKykKihon().getKouza();

        if (kouza != null) {
            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
            IT_KykSyouhn kykSyouhn = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0);

            if ((C_Kykjyoutai.HRKMTYUU.eq(kykSyouhn.getKykjyoutai()) ||
                C_Kykjyoutai.IKKATUNK.eq(kykSyouhn.getKykjyoutai())) &&
                C_KzkykdouKbn.DOUITU.eq(kouza.getKzkykdoukbn()) &&
                !kouza.getKzmeiginmkn().equals(kyknmknMenber)) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF1028);
            }
        }
    }

    private void checkKykdairininKykhenkou() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0);

        if ((C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()) ||
            C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) &&
            C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai())) {

            if (!C_Kykjyoutai.HRKMTYUU.eq(kykSyouhn.getKykjyoutai()) &&
                !C_Kykjyoutai.IKKATUNK.eq(kykSyouhn.getKykjyoutai())) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF1041);
            }
        }
    }

    private void checkKykdairininUkthenkou() {

        if ((!C_UktKbn.BLNK.eq(uiBean.getNewnenkinuktkbn()) ||
            C_UmuKbn.ARI.eq(uiBean.getSbukthenkouumu())) &&
            C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai())) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF1042);
        }
    }

    private void checkTeikishrtkykKyknmknHenkou() {

        if (C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) {
            if (!uiBean.getVkykskyknmkn().equals(kyknmknMenber)) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIA1027);
            }
        }
    }

    private void checkHanteiKhSisuurendoTmttknJyoutai() {

        String syouhncd = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0).getSyouhncd();

        int syouhnhanteiKbn = SyouhinUtil.henkouKubetuHantei(syouhncd);

        if (syouhnhanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUMAE ||
            syouhnhanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUMAE) {

            HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
            hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
            hanteiTmttknJyoutaiBean.setHanteiKijyunymd(BizDate.getSysDate());
            hanteiTmttknJyoutaiBean.setKykymd(uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0).getKykymd());

            HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

            boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

            if (!result) {
                throw new BizLogicException(MessageId.EBA1052);
            }
        }
    }

    private void updateKouza(){

        IT_Kouza kouza = uiBean.getKykKihon().getKouza();

        if (kouza != null) {
            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
            IT_KykSyouhn kykSyouhn = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0);
            String kykskyknmkn;

            if (BizUtil.isBlank(uiBean.getNewkyknmkn())) {
                kykskyknmkn = uiBean.getVkykskyknmkn();
            }
            else{
                kykskyknmkn = uiBean.getNewkyknmkn();
            }

            if ((C_Kykjyoutai.HRKMTYUU.eq(kykSyouhn.getKykjyoutai()) ||
                C_Kykjyoutai.IKKATUNK.eq(kykSyouhn.getKykjyoutai())) &&
                C_KzkykdouKbn.DOUITU.eq(kouza.getKzkykdoukbn()) &&
                !kouza.getKzmeiginmkn().equals(kykskyknmkn)){

                kouza.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
                kouza.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                kouza.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                kouza.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                hozenDomManager.update(uiBean.getKykKihon());

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5, MessageId.IIF1014);
            }
        }
    }

    private C_TyokusouhtkekKbn hanteiTrkkzkTyokusou(KhozenCommonParam pKhCParm, C_UktKbn pStdruktkbn) {

        TrkkzkTyokusouhtBean trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);
        KhTyokusouHantei khTyokusouHantei = SWAKInjector.getInstance(KhTyokusouHantei.class);
        BizDate kykseiymd = null;
        BizDate newkykseiymd = null;
        C_TsindousiteiKbn newtrkkzktsindousiteikbn = C_TsindousiteiKbn.BLNK;

        if (uiBean.getNewkykseiymd() == null) {
            kykseiymd = uiBean.getVkykskykseiymd();
        }
        else {
            kykseiymd = uiBean.getNewkykseiymd();
        }

        if (C_Meigihnkjiyuu.KYK.eq(uiBean.getMeigihnkjiyuu()) ||
            C_Meigihnkjiyuu.KYKSB.eq(uiBean.getMeigihnkjiyuu())) {
            newkykseiymd = uiBean.getVkykskykseiymd();
        }
        else {
            newkykseiymd = kykseiymd;
        }

        if (C_UktKbn.TOUROKUKAZOKU1.eq(pStdruktkbn)) {
            newtrkkzktsindousiteikbn = uiBean.getTrkkzktsindousiteikbn1();
        }
        else if (C_UktKbn.TOUROKUKAZOKU2.eq(pStdruktkbn)) {
            newtrkkzktsindousiteikbn = uiBean.getTrkkzktsindousiteikbn2();
        }

        trkkzkTyokusouhtBean.setKijyunymd(BizDate.getSysDate());
        trkkzkTyokusouhtBean.setKykseiymd(newkykseiymd);
        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(newtrkkzktsindousiteikbn);

        C_TyokusouhtkekKbn tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

        return tyokusouhtkekKbn;
    }

    private TyokusouTaisyouBean setTyokusouTaisyou(C_UktKbn pStdruktkbn, C_StdrsktkyhnkKbn pStdrsktkyhnkkbn) {

        TyokusouTaisyouBean tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);

        if (C_UktKbn.TOUROKUKAZOKU1.eq(pStdruktkbn)) {
            tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);
            tyokusouTaisyouBean.setNmkj(uiBean.getVtrkkzktrkkzknmkj1());
            tyokusouTaisyouBean.setSeiYmd(uiBean.getVtrkkzktrkkzkseiymd1());
            tyokusouTaisyouBean.setYno(uiBean.getVtrkkzktrkkzkyno1());
            tyokusouTaisyouBean.setAdr1kj(uiBean.getVtrkkzktrkkzkadr1kj1());
            tyokusouTaisyouBean.setAdr2kj(uiBean.getVtrkkzktrkkzkadr2kj1());
            tyokusouTaisyouBean.setAdr3kj(uiBean.getVtrkkzktrkkzkadr3kj1());
            tyokusouTaisyouBean.setTelno(uiBean.getVtrkkzktrkkzktelno1());
        }
        else if (C_UktKbn.TOUROKUKAZOKU2.eq(pStdruktkbn)) {
            tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
            tyokusouTaisyouBean.setNmkj(uiBean.getVtrkkzktrkkzknmkj2());
            tyokusouTaisyouBean.setSeiYmd(uiBean.getVtrkkzktrkkzkseiymd2());
            tyokusouTaisyouBean.setYno(uiBean.getVtrkkzktrkkzkyno2());
            tyokusouTaisyouBean.setAdr1kj(uiBean.getVtrkkzktrkkzkadr1kj2());
            tyokusouTaisyouBean.setAdr2kj(uiBean.getVtrkkzktrkkzkadr2kj2());
            tyokusouTaisyouBean.setAdr3kj(uiBean.getVtrkkzktrkkzkadr3kj2());
            tyokusouTaisyouBean.setTelno(uiBean.getVtrkkzktrkkzktelno2());
        }

        if (C_StdrsktkyhnkKbn.KAIJYO.eq(pStdrsktkyhnkkbn)) {
            tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDHHKNDRNIN);
        }

        return tyokusouTaisyouBean;
    }

    private C_StdrsktkyhnkKbn uketorininBrtuninHikaku(String pBfruktnmkn, String pBfruktnmkj, BizDate pBfrseiymd,
        String pNewuktnmkn, String pNewuktnmkj, BizDate pNewseiymd) {

        C_StdrsktkyhnkKbn stdrsktkyhnkKbn = C_StdrsktkyhnkKbn.BLNK;

        if (!pBfruktnmkn.equals(pNewuktnmkn) && !pBfruktnmkj.equals(pNewuktnmkj)
            && BizDateUtil.compareYmd(pBfrseiymd, pNewseiymd) != BizDateUtil.COMPARE_EQUAL) {
            stdrsktkyhnkKbn = C_StdrsktkyhnkKbn.HENKOU;
        }

        return stdrsktkyhnkKbn;
    }

    private void khLincSousinDataSyori(KhozenCommonParam pKhozenCommonParam, BizDate pSyoriYmd,
        IT_BAK_KykKihon pBAK_KykKihon) {

        IT_KhLincKihon khLincKihon = uiBean.getKykKihon().getKhLincKihon();

        Long linckanyuusyano = null;
        if (khLincKihon != null) {
            linckanyuusyano = khLincKihon.getLinckanyuusyano();
        }

        HanteiLinc hanteiLinc = SWAKInjector.getInstance(HanteiLinc.class);
        HanteiLincBean hanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);

        hanteiLincBean.setSyoriYmd(pSyoriYmd);
        hanteiLincBean.setBakKykKihon(pBAK_KykKihon);
        hanteiLincBean.setKykKihon(uiBean.getKykKihon());
        hanteiLincBean.setKanyuusyaNo(linckanyuusyano);

        hanteiLinc.exec(hanteiLincBean, pKhozenCommonParam);
    }
}
