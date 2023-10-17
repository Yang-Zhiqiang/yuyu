package yuyu.app.hozen.khansyuu.khharaikatahenkou;

import static yuyu.app.hozen.khansyuu.khharaikatahenkou.GenKhHaraikataHenkouConstants.*;
import static yuyu.app.hozen.khansyuu.khharaikatahenkou.KhHaraikataHenkouConstants.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khansyuu.khharaikatahenkou.dba.KariukekinMinRyosyuymdSumKrkgkBean;
import yuyu.app.hozen.khansyuu.khharaikatahenkou.dba.KhHaraikataHenkouDao;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.BzHanteiSosikiUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakusei;
import yuyu.common.biz.kaikei.SikinIdouRirekiDataBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceTaskStart;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.ascommon.EditHrhnKanryoTuuti;
import yuyu.common.hozen.ascommon.EditHrhnKanryoTuutiParam;
import yuyu.common.hozen.ascommon.GetHrkKawaseRateKijyun;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.KeisanHrhnNewHrkp;
import yuyu.common.hozen.ascommon.KeisanPRsTuukaKnsn;
import yuyu.common.hozen.ascommon.KeisanPRsTuukaKnsnKekkaBean;
import yuyu.common.hozen.ascommon.KeisanRsgakuConstants;
import yuyu.common.hozen.ascommon.SetHrhnSyoriKbn;
import yuyu.common.hozen.khcommon.AnsyuuCommonSiwake;
import yuyu.common.hozen.khcommon.AnsyuuCommonSiwakeInBean;
import yuyu.common.hozen.khcommon.AnsyuuTaisyouGkBean;
import yuyu.common.hozen.khcommon.CheckIkktNyuknKykjyuti;
import yuyu.common.hozen.khcommon.CheckKzhuriKouza;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CommonSiwakeOutBean;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoHensyuu;
import yuyu.common.hozen.khcommon.EditDairitenTesuuryouTbl;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunou;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunouParam;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouTbl;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiSyoriKengen;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanIkkatuWaribikiKikan;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KykSyouhnCommonParam;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SaibanCreditKessaiyouNo;
import yuyu.common.hozen.khcommon.SetAnnaibi;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetDattai;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetHituyouSyorui;
import yuyu.common.hozen.setuibean.SetHosyou;
import yuyu.common.hozen.setuibean.SetKariukekin;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtil;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetTokusin;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaraikatahnkuktknaiyouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyuukouzaAnnaiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.classification.C_YykidouuktkKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_CardTourokuMati;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_HrhnCreditCardTouroku;
import yuyu.def.db.entity.IT_HrhnTtdkKan;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KyuukzAnnaimati;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_YykIdouNaiyoHrhnk;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.db.entity.IW_KhHaraikataHenkouWk;
import yuyu.def.hozen.bean.report.KhCreditcardMosBean;
import yuyu.def.hozen.bean.report.KhHrhnTtdkAnnaiBean;
import yuyu.def.hozen.bean.report.KhPHrkkaisuuHenkouMosBean;
import yuyu.def.hozen.bean.report.KhPkzhrikeIraisyoBean;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.DBAOutputReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.PdfBuilder;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;
import com.lowagie.text.pdf.PdfReader;

/**
 * 払方変更 のビジネスロジックです。
 */
public class KhHaraikataHenkouBizLogic {

    private String functionId;

    private String userId;

    private BizDate sysDate;

    private String sysTime;

    private BizDate kouryokuHasseiYmd;

    private int maxKrkNo;

    private String sikibetuKey;

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhHaraikataHenkouUiBean uiBean;

    @Inject
    private KhHaraikataHenkouDao khHaraikataHenkouDao;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    void init() {
        clear();
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo()
            .getJimuTetuzukiCd());

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        String kouteikanriid = uiBean.getBzWorkflowInfo().getKouteiKanriId();

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = khHaraikataHenkouDao.getGyoumuKouteiInfo(kouteikanriid);

        String syoNo = gyoumuKouteiInfo.getSyono();

        uiBean.setSyono(syoNo);

        uiBean.setKouteikanriid(kouteikanriid);

        checkKykSonzai();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkYuukouJyoutai(khozenCommonParam);

        checkHanteiTetuduki(khozenCommonParam);

        checkGmwarning1();

        IT_KyuukzAnnaimati kyuukzAnnaimati = hozenDomManager.getKyuukzAnnaimati(kouteikanriid);

        if (kyuukzAnnaimati != null) {
            C_Syorizumiflg syorizumiflg = kyuukzAnnaimati.getSyorizumiflg();

            if (C_Syorizumiflg.SYORIZUMI.eq(syorizumiflg)) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,MessageId.WIF3007);
            }
        }

        setKariukekinData();

        setUiBean(khozenCommonParam);

        IW_KhHaraikataHenkouWk khHaraikataHenkouWk = khHaraikataHenkouDao.getKhHaraikataHenkouWk(kouteikanriid);
        uiBean.setKhHaraikataHenkouWk(khHaraikataHenkouWk);

        if (C_SyorikekkaKbn.TORIKESI.eq(khHaraikataHenkouWk.getZenkaisyorikekkakbn()) &&
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIC0001,
                khHaraikataHenkouWk.getZenkaisyorikekkakbn().getContent());
        }

        String dispsaibancreditkessaiyouno = "";

        if (!BizUtil.isBlank(khHaraikataHenkouWk.getCreditkessaiyouno())) {

            CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu = SWAKInjector.getInstance(CreditKessaiyouNoHensyuu.class);

            dispsaibancreditkessaiyouno = creditKessaiyouNoHensyuu.exec(khHaraikataHenkouWk.getCreditkessaiyouno());

        }

        uiBean.setNewhrkkeiro(khHaraikataHenkouWk.getNewhrkkeiro());
        uiBean.setNewhrkkaisuu(khHaraikataHenkouWk.getNewhrkkaisuu());
        uiBean.setNewtikiktbrisyuruikbn(khHaraikataHenkouWk.getNewtikiktbrisyuruikbn());
        uiBean.setHenkouyoteiym(khHaraikataHenkouWk.getHenkouyoteiym());
        uiBean.setBankcd(khHaraikataHenkouWk.getBankcd());
        uiBean.setSitencd(khHaraikataHenkouWk.getSitencd());
        uiBean.setYokinkbn(khHaraikataHenkouWk.getYokinkbn());
        uiBean.setKouzano(khHaraikataHenkouWk.getKouzano());
        uiBean.setKzkykdoukbn(khHaraikataHenkouWk.getKzkykdoukbn());
        uiBean.setKzmeiginmkn(khHaraikataHenkouWk.getKzmeiginmkn());
        uiBean.setYykidouuktkkbn(khHaraikataHenkouWk.getYykidouuktkkbn());

        uiBean.setKyuukouzaannaikbn(khHaraikataHenkouWk.getKyuukouzaannaikbn());

        uiBean.setKanryotuutioutkbn(khHaraikataHenkouWk.getKanryotuutioutkbn());
        uiBean.setZenkaiSyoriKekka(khHaraikataHenkouWk.getZenkaisyorikekkakbn());

        uiBean.setKyuukouzahurikaeymd(khHaraikataHenkouWk.getKyuukouzahurikaeymd());
        uiBean.setSaibanCreditKessaiyouNo(khHaraikataHenkouWk.getCreditkessaiyouno());
        uiBean.setDispsaibancreditkessaiyouno(dispsaibancreditkessaiyouno);

        if (!BizUtil.isBlank(khHaraikataHenkouWk.getCreditkessaiyouno())) {

            IT_HrhnCreditCardTouroku hrhnCreditCardTouroku = hozenDomManager
                .getHrhnCreditCardTouroku(khHaraikataHenkouWk.getCreditkessaiyouno());

            if (hrhnCreditCardTouroku != null) {

                if (C_AuthorijkKbn.IRAITYUU.eq(hrhnCreditCardTouroku.getAuthorijkkbn())) {

                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF3010);
                }
                else if (C_AuthorijkKbn.OK.eq(hrhnCreditCardTouroku.getAuthorijkkbn())) {

                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIF3011);
                }

                uiBean.setAuthorijkKbn(hrhnCreditCardTouroku.getAuthorijkkbn());
                uiBean.setCardBrandKbn(hrhnCreditCardTouroku.getCardbrandkbn());
                uiBean.setCreditKaiinnoSimo4keta(hrhnCreditCardTouroku.getCreditkaiinnosimo4keta());
            }
        }

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        setProgressHistory.exec(uiBean);

    }

    void pushNyuuryokuBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        checkKykSonzai();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkYuukouJyoutai(khozenCommonParam);

        checkHanteiTetuduki(khozenCommonParam);

        checkGmwarning1();

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);

        hanteiSyoriKengen.exec();

        setKariukekinData();

        setUiBean(khozenCommonParam);

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU);

        uiBean.setHenkouyoteiym(uiBean.getVhrkijkipjytym());

    }

    String pushModoruNaiyouNyuryoku() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    void pushSyoukaiBL() {

        if(!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())){
            continueLockProcessBL();
        }

        String syoNo = uiBean.getSyono();

        BizDateYM jkipjytym = uiBean.getVhrkijkipjytym();

        BizDateYM henkouyoteiym = uiBean.getHenkouyoteiym();

        if((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) ||
            !C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ){

            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
            List<IT_KykSyouhn> kykSyouhnSyuLst = khozenCommonParam.getKeiyakuSyouhin(syoNo, C_SyutkKbn.SYU);
            IT_KykSyouhn kykSyouhnSyu = kykSyouhnSyuLst.get(0);

            BizDate syuKykYmd = kykSyouhnSyu.getKykymd();
            BizDate syuKykHaraimanYmd = kykSyouhnSyu.getHaraimanymd();

            List<IT_KykSyouhn> kykSyouhnTkLst = khozenCommonParam.getKeiyakuSyouhin(syoNo, C_SyutkKbn.TK);

            GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);

            C_ErrorKbn asPRsTuukaErrorKbn = getasPRsTuuka.exec(uiBean.getSyono());

            if (C_ErrorKbn.ERROR.eq(asPRsTuukaErrorKbn)) {
                throw new CommonBizAppException("保険料領収通貨取得エラー");
            }

            C_Tuukasyu rstuukasyu = getasPRsTuuka.getRstuukasyu();

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            C_Tuukasyu hokenryoutuukasyu = henkanTuuka.henkanTuukaTypeToKbn(kykSyouhnSyu.getHokenryou().getType());

            uiBean.setRstuukasyu(rstuukasyu);
            uiBean.setPtuukasyu(hokenryoutuukasyu);
            if (!rstuukasyu.eq(hokenryoutuukasyu)) {
                uiBean.setHrhnkyoupKnsnYouhiKbn(C_YouhiKbn.YOU);
            }
            else {
                uiBean.setHrhnkyoupKnsnYouhiKbn(C_YouhiKbn.HUYOU);
            }
            uiBean.setHrhnkyoupKnsnUmu(C_UmuKbn.NONE);

            BizDate systemDate = BizDate.getSysDate();

            C_UmuKbn hrkkeirohnkumuHantei = C_UmuKbn.NONE;
            C_AnnaijkKbn annaityuuHanteiKbn = C_AnnaijkKbn.BLNK;
            Long annaityuuKensuu = 0L;
            CurrencyType hokenryouType = kykSyouhnSyu.getHokenryou().getType();

            uiBean.setHrhnkyoup(BizCurrency.valueOf(0,hokenryouType));
            uiBean.setDisphrhnkyoup(BizCurrency.valueOf(0,hokenryouType));
            uiBean.setYenkahrhnkyoup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            uiBean.setYenTukiHokenryou(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            uiBean.setHrhnkyoupzytm(0);
            uiBean.setHrhnkyoupzytym(null);
            uiBean.setIktwaribikikGk(BizCurrency.valueOf(0,hokenryouType));
            uiBean.setHennyuYm(jkipjytym);
            uiBean.setNewhrkp(uiBean.getVhrkihrkp());
            uiBean.setHrhnkyoupHukaRiyuu(HRHNKYOUP_HUKARIYUU_NONE);
            uiBean.setNewSdpdkbn(uiBean.getVhsyusdpdkbn());

            if(!C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk())){
                KeisanHrhnNewHrkp keisanHrhnNewHrkp = SWAKInjector.getInstance(KeisanHrhnNewHrkp.class);

                C_ErrorKbn errorKbn = keisanHrhnNewHrkp.exec(uiBean.getKykKihon(),uiBean.getVhrkitikiktbrijk());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizLogicException(MessageId.EIA3054);
                }

                uiBean.setNewtikiktbrihrkp(keisanHrhnNewHrkp.getNewHrkp());
                uiBean.setOldTikiktbrihrkp(keisanHrhnNewHrkp.getNewHrkp());
                uiBean.setIktwaribikikGk(keisanHrhnNewHrkp.getIktwaribikikgk());
            }

            if (C_Hrkkeiro.BLNK.eq(uiBean.getNewhrkkeiro())) {
                uiBean.setHrkkeirohnkumu(C_UmuKbn.NONE);
            }
            else {
                uiBean.setHrkkeirohnkumu(C_UmuKbn.ARI);
            }

            C_Hrkkeiro syoriGoHrkkeiro = C_Hrkkeiro.BLNK;

            if (C_UmuKbn.ARI.eq(uiBean.getHrkkeirohnkumu())) {

                syoriGoHrkkeiro = uiBean.getNewhrkkeiro();
            }
            else {
                syoriGoHrkkeiro = uiBean.getVhrkihrkkeiro();
            }

            if (!C_Hrkkeiro.BLNK.eq(uiBean.getNewhrkkeiro()) &&
                !uiBean.getNewhrkkeiro().eq(uiBean.getVhrkihrkkeiro())) {
                hrkkeirohnkumuHantei = C_UmuKbn.ARI;
            }

            C_Hrkkaisuu syoriGoHrkkaisuu = C_Hrkkaisuu.BLNK;

            C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.BLNK;

            if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk())) {
                if (C_Hrkkaisuu.BLNK.eq(uiBean.getNewhrkkaisuu()) ||
                    uiBean.getNewhrkkaisuu().eq(uiBean.getVhrkihrkkaisuu())) {
                    uiBean.setHrkkaisuuhnkumu(C_UmuKbn.NONE);
                }
                else {
                    uiBean.setHrkkaisuuhnkumu(C_UmuKbn.ARI);
                }

                uiBean.setTikiktbrisyuruihnkumu(C_UmuKbn.NONE);

                if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu())) {

                    syoriGoHrkkaisuu = uiBean.getNewhrkkaisuu();
                }
                else {
                    syoriGoHrkkaisuu = uiBean.getVhrkihrkkaisuu();
                }
            }
            else {
                if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getNewtikiktbrisyuruikbn()) ||
                    uiBean.getNewtikiktbrisyuruikbn().eq(uiBean.getVhrkitikiktbrijk())) {
                    uiBean.setTikiktbrisyuruihnkumu(C_UmuKbn.NONE);
                }
                else {
                    uiBean.setTikiktbrisyuruihnkumu(C_UmuKbn.ARI);
                }

                uiBean.setHrkkaisuuhnkumu(C_UmuKbn.NONE);

                if (C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {
                    tkiktbrisyuruiKbn = uiBean.getNewtikiktbrisyuruikbn();
                }
                else {
                    tkiktbrisyuruiKbn = uiBean.getVhrkitikiktbrijk();
                }

                syoriGoHrkkaisuu = uiBean.getVhrkihrkkaisuu();
            }

            if (C_Hrkkeiro.BLNK.eq(uiBean.getNewhrkkeiro()) &&
                ((C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                    C_UmuKbn.NONE.eq(uiBean.getHrkkaisuuhnkumu())) ||
                    (!C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                        C_UmuKbn.NONE.eq(uiBean.getTikiktbrisyuruihnkumu())))) {
                throw new BizLogicException(MessageId.EIA0047);
            }

            if (((C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                !C_Hrkkaisuu.BLNK.eq(uiBean.getNewhrkkaisuu())) ||
                (!C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                    !C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getNewtikiktbrisyuruikbn()))) &&
                    uiBean.getHenkouyoteiym() == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_HRKHOUHOUHENKOUINFO1_HENKOUYOTEIYM.getErrorResourceKey()));
            }

            if (((C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                C_Hrkkaisuu.BLNK.eq(uiBean.getNewhrkkaisuu())) ||
                (!C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                    C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getNewtikiktbrisyuruikbn()))) &&
                    uiBean.getHenkouyoteiym() != null) {
                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_HRKHOUHOUHENKOUINFO1_HENKOUYOTEIYM.getErrorResourceKey()));
            }

            if (henkouyoteiym != null) {
                if (BizDateUtil.compareYm(henkouyoteiym, jkipjytym) == BizDateUtil.COMPARE_LESSER) {
                    throw new BizLogicException(MessageId.EIA0136);
                }

                if (BizDateUtil.compareYm(henkouyoteiym, syuKykHaraimanYmd.getBizDateYM()) == BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EIA0137);
                }

                BizDateYM jkipjytYm1YAfter = jkipjytym.addYears(1);

                if (BizDateUtil.compareYm(henkouyoteiym, jkipjytYm1YAfter) == BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EBA0028,
                        MessageUtil.getMessage(DDID_HRKHOUHOUHENKOUINFO1_HENKOUYOTEIYM.getErrorResourceKey()));
                }

                if (BizDateUtil.compareYm(henkouyoteiym, jkipjytym) != BizDateUtil.COMPARE_EQUAL) {

                    SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                    if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                        (C_Hrkkaisuu.NEN.eq(uiBean.getVhrkihrkkaisuu()) ||
                            C_Hrkkaisuu.HALFY.eq(uiBean.getVhrkihrkkaisuu()))) {

                        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, syuKykYmd,
                            uiBean.getVhrkihrkkaisuu(), henkouyoteiym.getFirstDay());

                        int hanteiHrkksTaniYmsuu = BizDateUtil.calcDifferenceMonths(henkouyoteiym, outouYmd.getBizDateYM());

                        if (hanteiHrkksTaniYmsuu % Integer.valueOf(String.valueOf(uiBean.getVhrkihrkkaisuu())) != 0) {
                            throw new BizLogicException(MessageId.EBA0028,
                                MessageUtil.getMessage(DDID_HRKHOUHOUHENKOUINFO1_HENKOUYOTEIYM.getErrorResourceKey()));
                        }
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getVhrkitikiktbrijk()) ||
                        C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getVhrkitikiktbrijk())) {
                        C_Hrkkaisuu hhrkkaisuu = C_Hrkkaisuu.BLNK;
                        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getVhrkitikiktbrijk())) {
                            hhrkkaisuu = C_Hrkkaisuu.HALFY;
                        }
                        else {
                            hhrkkaisuu = C_Hrkkaisuu.NEN;
                        }
                        BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, syuKykYmd,
                            hhrkkaisuu, henkouyoteiym.getFirstDay());

                        int hanteiHrkksTaniYmsuu = BizDateUtil.calcDifferenceMonths(henkouyoteiym, outouYmd.getBizDateYM());

                        if (hanteiHrkksTaniYmsuu % Integer.valueOf(String.valueOf(uiBean.getVhrkitikiktbrijk())) != 0) {
                            throw new BizLogicException(MessageId.EBA0028,
                                MessageUtil.getMessage(DDID_HRKHOUHOUHENKOUINFO1_HENKOUYOTEIYM.getErrorResourceKey()));
                        }
                    }

                }
            }

            if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                C_Hrkkeiro.CREDIT.eq(syoriGoHrkkeiro) && !C_Hrkkaisuu.TUKI.eq(syoriGoHrkkaisuu)) {
                throw new BizLogicException(MessageId.EIA0140);
            }

            if (!C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                C_Hrkkeiro.CREDIT.eq(syoriGoHrkkeiro) &&
                !C_TkiktbrisyuruiKbn.NONE.eq(tkiktbrisyuruiKbn)) {
                throw new BizLogicException(MessageId.EIF3045);
            }

            uiBean.setAnnaityuuhanteiKbn(C_AnnaijkKbn.BLNK);

            if ((C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) && C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu())) ||
                (!C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) && C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu()))) {

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu())) {

                    if (C_Hrkkaisuu.HALFY.eq(uiBean.getNewhrkkaisuu())) {
                        BizDate jkipjytYm6MAfter = syuKykYmd.addMonths(6);

                        if ((henkouyoteiym != null) && (henkouyoteiym.getMonth() == syuKykYmd.getMonth() ||
                            henkouyoteiym.getMonth() == jkipjytYm6MAfter.getMonth())) {

                            uiBean.setHennyuYm(henkouyoteiym);

                        }
                        else {
                            BizDate hanteiBi = BizDate.valueOf(henkouyoteiym, syuKykYmd.getDay()).getRekijyou();

                            BizDate outoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, syuKykYmd,
                                uiBean.getNewhrkkaisuu(), hanteiBi);

                            uiBean.setHennyuYm(outoubi.getBizDateYM());

                        }
                    }
                    else if (C_Hrkkaisuu.NEN.eq(uiBean.getNewhrkkaisuu())) {

                        if (henkouyoteiym != null && henkouyoteiym.getMonth() == syuKykYmd.getMonth()) {

                            uiBean.setHennyuYm(henkouyoteiym);
                        }
                        else {
                            BizDate hanteiBi = BizDate.valueOf(henkouyoteiym, syuKykYmd.getDay());

                            BizDate outoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, syuKykYmd,
                                uiBean.getNewhrkkaisuu(), hanteiBi);

                            uiBean.setHennyuYm(outoubi.getBizDateYM());
                        }
                    }
                    else {
                        uiBean.setHennyuYm(henkouyoteiym);
                    }
                }

                if (C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {

                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getNewtikiktbrisyuruikbn())) {

                        BizDate jkipjytYm6MAfter = syuKykYmd.addMonths(6);

                        if (henkouyoteiym != null && (henkouyoteiym.getMonth() == syuKykYmd.getMonth() ||
                            henkouyoteiym.getMonth() == jkipjytYm6MAfter.getMonth())) {
                            uiBean.setHennyuYm(henkouyoteiym);
                        }
                        else {
                            BizDate hanteiBi = BizDate.valueOf(henkouyoteiym, syuKykYmd.getDay()).getRekijyou();

                            BizDate outoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, syuKykYmd,
                                C_Hrkkaisuu.HALFY, hanteiBi);

                            uiBean.setHennyuYm(outoubi.getBizDateYM());
                        }

                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getNewtikiktbrisyuruikbn())) {
                        if (henkouyoteiym != null && henkouyoteiym.getMonth() == syuKykYmd.getMonth()) {
                            uiBean.setHennyuYm(henkouyoteiym);
                        }
                        else {
                            BizDate hanteiBi = BizDate.valueOf(henkouyoteiym, syuKykYmd.getDay()).getRekijyou();

                            BizDate outoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, syuKykYmd,
                                C_Hrkkaisuu.NEN, hanteiBi);

                            uiBean.setHennyuYm(outoubi.getBizDateYM());
                        }
                    }
                    else {
                        uiBean.setHennyuYm(henkouyoteiym);
                    }
                }

                if (BizDateUtil.compareYm(syuKykHaraimanYmd.getBizDateYM(), uiBean.getHennyuYm()) != BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EIA0141);
                }
            }
            else {
                if (C_UmuKbn.ARI.eq(hrkkeirohnkumuHantei) ||
                    C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {

                    annaityuuKensuu = khHaraikataHenkouDao.getAnsyuRirekiSum(uiBean.getSyono(), jkipjytym);

                    if (annaityuuKensuu == null) {
                        annaityuuKensuu = 0L;
                    }

                    if (annaityuuKensuu > 0) {

                        annaityuuHanteiKbn = C_AnnaijkKbn.ANNAI;

                        uiBean.setAnnaityuuhanteiKbn(annaityuuHanteiKbn);
                    }

                    if (C_AnnaijkKbn.ANNAI.eq(annaityuuHanteiKbn)) {

                        BizDateYM hennyouYm = jkipjytym.addMonths(Integer.parseInt(annaityuuKensuu.toString()));

                        uiBean.setHennyuYm(hennyouYm);
                    }
                    else {
                        uiBean.setHennyuYm(jkipjytym);
                    }
                }

                else {
                    uiBean.setHennyuYm(jkipjytym);
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) || C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {
                if ((C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) && C_Hrkkaisuu.TUKI.eq(uiBean.getVhrkihrkkaisuu()) &&
                    (C_Hrkkaisuu.NEN.eq(uiBean.getNewhrkkaisuu()) || C_Hrkkaisuu.HALFY.eq(uiBean.getNewhrkkaisuu()))) ||
                    (C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu()) &&
                        C_TkiktbrisyuruiKbn.NONE.eq(uiBean.getVhrkitikiktbrijk()) &&
                        (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getNewtikiktbrisyuruikbn()) ||
                            C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getNewtikiktbrisyuruikbn())))) {

                    int hrhnkyouPZYTM = BizDateUtil.calcDifferenceMonths(uiBean.getHennyuYm(), henkouyoteiym);

                    if (hrhnkyouPZYTM > 0) {
                        KeisanIkkatuWaribikiKikan ikkatuWaribikiKikan = SWAKInjector.getInstance(KeisanIkkatuWaribikiKikan.class);

                        BizDate ryosyuYmd = null;
                        if (uiBean.getRyosyuYmd() == null) {
                            ryosyuYmd = systemDate;
                        }
                        else {
                            ryosyuYmd = uiBean.getRyosyuYmd();
                        }

                        uiBean.setHrhnkyoupzytm(hrhnkyouPZYTM);
                        uiBean.setHrhnkyoupzytym(uiBean.getHenkouyoteiym());

                        ikkatuWaribikiKikan.exec(ryosyuYmd,uiBean.getHenkouyoteiym(),hrhnkyouPZYTM);

                        Integer wrbkTekikknTksu = ikkatuWaribikiKikan.getWrbkTekikknTksu();

                        if (wrbkTekikknTksu >= 3) {
                            uiBean.setDisphrhnkyoup(BizCurrency.optional(hokenryouType));
                            uiBean.setHrhnkyoupHukaRiyuu(HRHNKYOUP_HUKARIYUU_IKTWARIBIKIK_ARI);
                        }
                        else {
                            BizCurrency hrhnkyoupgk = uiBean.getVhrkihrkp().multiply(uiBean.getHrhnkyoupzytm());

                            uiBean.setHrhnkyoup(hrhnkyoupgk);
                            uiBean.setDisphrhnkyoup(hrhnkyoupgk);

                            if (C_YouhiKbn.YOU.eq(uiBean.getHrhnkyoupKnsnYouhiKbn())) {
                                GetHrkKawaseRateKijyun getHrkKawaseRateKijyun = SWAKInjector.getInstance(GetHrkKawaseRateKijyun.class);

                                C_ErrorKbn errorKbn = getHrkKawaseRateKijyun.exec(C_NyknaiyouKbn.HARAIHENYOUP,
                                    C_Nykkeiro.BANK, ryosyuYmd, uiBean.getHrhnkyoupzytym(), 0,
                                    uiBean.getHrhnkyoupzytm(), uiBean.getVhrkihrkkaisuu());

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    throw new CommonBizAppException("払込用為替レート基準日取得エラー");
                                }

                                uiBean.setHrhnkyoupkwsratekjymd(getHrkKawaseRateKijyun.getKawaseRateKijyun());
                                uiBean.setKawaseRateKijyunKbn(getHrkKawaseRateKijyun.getKawaseRateKijyunKbn());

                                if (KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_PREMLASTDAY.equals(
                                    uiBean.getKawaseRateKijyunKbn()) ||
                                    (KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_RYOSYUYMD.equals
                                        (uiBean.getKawaseRateKijyunKbn()) && uiBean.getRyosyuYmd() != null)) {

                                    KeisanPRsTuukaKnsn keisanPRsTuukaKnsn = SWAKInjector.getInstance(KeisanPRsTuukaKnsn.class);

                                    C_ErrorKbn keisanPRsTuukaKnsnErrorKbn = keisanPRsTuukaKnsn.exec(
                                        uiBean.getHrhnkyoupkwsratekjymd(), uiBean.getVhrkihrkp(),
                                        uiBean.getPtuukasyu(), uiBean.getRstuukasyu());

                                    if (C_ErrorKbn.ERROR.eq(keisanPRsTuukaKnsnErrorKbn)) {
                                        String errorRiyuu = keisanPRsTuukaKnsn.getErrorRiyuu();
                                        if (KeisanRsgakuConstants.ERRRIYUU_KAWASERATESYUTOKUERR.equals(errorRiyuu)) {
                                            throw new BizLogicException(MessageId.EIF3074);
                                        }

                                        throw new CommonBizAppException("保険料領収通貨換算計算エラー");
                                    }

                                    KeisanPRsTuukaKnsnKekkaBean tuukaKnsnKekkaBean = keisanPRsTuukaKnsn.getPRsTuukaKnsn();
                                    BizCurrency yenkahrhnkyoup =
                                        tuukaKnsnKekkaBean.getRstuukaknsngop().multiply(uiBean.getHrhnkyoupzytm());

                                    uiBean.setHrhnkyoupkwsrate(tuukaKnsnKekkaBean.getRstuukaknsnkwsrate());
                                    uiBean.setYenkahrhnkyoup(yenkahrhnkyoup);
                                    uiBean.setHrhnkyoupKnsnUmu(C_UmuKbn.ARI);
                                    uiBean.setYenTukiHokenryou(tuukaKnsnKekkaBean.getRstuukaknsngop());
                                }
                            }
                            else {
                                uiBean.setYenTukiHokenryou(uiBean.getVhrkihrkp());
                            }
                        }
                    }
                }

                if ((C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) && C_Hrkkaisuu.HALFY.eq(uiBean.getVhrkihrkkaisuu()) &&
                    C_Hrkkaisuu.NEN.eq(uiBean.getNewhrkkaisuu())) ||
                    (C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu()) &&
                        C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getVhrkitikiktbrijk()) &&
                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getNewtikiktbrisyuruikbn()))) {

                    if (BizDateUtil.compareYm(uiBean.getHennyuYm(), henkouyoteiym) != BizDateUtil.COMPARE_EQUAL) {

                        if (C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {

                            uiBean.setHrhnkyoup(uiBean.getOldTikiktbrihrkp());
                            uiBean.setDisphrhnkyoup(uiBean.getOldTikiktbrihrkp());

                        } else {
                            uiBean.setDisphrhnkyoup(BizCurrency.optional(hokenryouType));
                            uiBean.setHrhnkyoupHukaRiyuu(HRHNKYOUP_HUKARIYUU_HALFY_P);
                            if (BizDateUtil.compareYm(uiBean.getVhrkijkipjytym(),
                                systemDate.getBizDateYM()) == BizDateUtil.COMPARE_GREATER) {
                                messageManager.addConversationMessageId(
                                    KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF3022);
                            }
                            else {
                                messageManager.addConversationMessageId
                                (KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF3023);
                            }
                        }

                        uiBean.setHrhnkyoupzytm(6);
                        uiBean.setHrhnkyoupzytym(henkouyoteiym);
                    }
                }
            }

            if(C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) || C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {

                KeisanHrhnNewHrkp keisanHrhnNewHrkp = SWAKInjector.getInstance(KeisanHrhnNewHrkp.class);

                C_ErrorKbn errorKbn = C_ErrorKbn.OK;
                if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu())) {
                    if (kykSyouhnTkLst == null) {
                        kykSyouhnTkLst = Lists.newArrayList();
                    }

                    errorKbn = keisanHrhnNewHrkp.exec(kykSyouhnSyu, kykSyouhnTkLst,
                        uiBean.getVhrkihrkkaisuu(), uiBean.getNewhrkkaisuu(),syoriGoHrkkeiro);
                }

                if (C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {
                    errorKbn = keisanHrhnNewHrkp.exec(uiBean.getKykKihon(),uiBean.getNewtikiktbrisyuruikbn());
                }

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizLogicException(MessageId.EIA3054);
                }

                uiBean.setNewhrkp(keisanHrhnNewHrkp.getNewHrkp());
                uiBean.setNewtikiktbrihrkp(keisanHrhnNewHrkp.getNewHrkp());
                uiBean.setNewsyup(keisanHrhnNewHrkp.getSyuP());
                uiBean.setDispnewTkPs(keisanHrhnNewHrkp.getTkPList());
                uiBean.setDisptkSyouhnCds(keisanHrhnNewHrkp.getTkSyouhnCdList());
                uiBean.setDisptkSyouhnSdNos(keisanHrhnNewHrkp.getTkSyouhnSdnoList());
                uiBean.setDisptkKykSyouhnRenNos(keisanHrhnNewHrkp.getTkKykSyouhnRennoList());
                uiBean.setNewnextkosumu(C_UmuKbn.NONE);
                uiBean.setNewSdpdkbn(keisanHrhnNewHrkp.getSdpd());
            }

            if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {
                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
                    kykSyouhnSyu.getSyouhncd(), kykSyouhnSyu.getSyouhnsdno());

                if (C_UmuKbn.NONE.eq(syouhnZokusei.getCreditcardhrtekiumu())) {
                    throw new BizLogicException(MessageId.EIF3076);
                }
            }

            if (C_Hrkkeiro.CREDIT.eq(syoriGoHrkkeiro) &&
                (uiBean.getNewhrkp().compareTo(BizCurrency.valueOf(9999999)) > 0)) {
                throw new BizLogicException(MessageId.EIF3056);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHrkkeirohnkumu())) {

                BizDate tyouseiTaisyouYmd = BizDate.getSysDate().addMonths(uiBean.getHrhnkyoupzytm());

                if (C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())){

                    int kouHuriPmm = YuyuHozenConfig.getInstance().getTyouseiYouPTukisuuKouza();

                    tyouseiTaisyouYmd = tyouseiTaisyouYmd.addMonths(kouHuriPmm);

                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIA0006,
                        DefaultDateFormatter.formatYMZeroFill(tyouseiTaisyouYmd));

                }
                else if(C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())){

                    int creditPmm = YuyuHozenConfig.getInstance().getTyouseiYouPTukisuuCredit();

                    tyouseiTaisyouYmd = tyouseiTaisyouYmd.addMonths(creditPmm);

                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIA0006,
                        DefaultDateFormatter.formatYMZeroFill(tyouseiTaisyouYmd));
                }
            }

            if ((C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) && (C_Hrkkaisuu.HALFY.eq(uiBean.getVhrkihrkkaisuu()) ||
                C_Hrkkaisuu.NEN.eq(uiBean.getVhrkihrkkaisuu()) ||
                C_Hrkkaisuu.HALFY.eq(uiBean.getNewhrkkaisuu()) ||
                C_Hrkkaisuu.NEN.eq(uiBean.getNewhrkkaisuu()))) ||
                (C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu()) && (
                    C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getVhrkitikiktbrijk()) ||
                    C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getVhrkitikiktbrijk()) ||
                    C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getNewtikiktbrisyuruikbn()) ||
                    C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getNewtikiktbrisyuruikbn())))) {

                BizDate tukiHajimeEiGyouYMD = BizDate.valueOf(uiBean.getHennyuYm(), 1);
                if (tukiHajimeEiGyouYMD.isHoliday()) {
                    tukiHajimeEiGyouYMD = tukiHajimeEiGyouYMD.getBusinessDay(CHolidayAdjustingMode.NEXT);
                }

                if (BizDateUtil.compareYmd(tukiHajimeEiGyouYMD,systemDate) == BizDateUtil.COMPARE_LESSER ){
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIA0024);
                }
            }

            uiBean.setRsgakuHikakuYouhiKbn(C_YouhiKbn.HUYOU);
            uiBean.setHikakuHrhnkyoup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

            if (uiBean.getRsgaku().compareTo(BizCurrency.valueOf(0, (uiBean.getRsgaku().getType()))) > 0) {
                if (C_YouhiKbn.YOU.eq(uiBean.getHrhnkyoupKnsnYouhiKbn())) {
                    if (C_UmuKbn.ARI.eq(uiBean.getHrhnkyoupKnsnUmu())) {
                        uiBean.setRsgakuHikakuYouhiKbn(C_YouhiKbn.YOU);
                        uiBean.setHikakuHrhnkyoup(uiBean.getYenkahrhnkyoup());
                    }
                }
                else {
                    uiBean.setRsgakuHikakuYouhiKbn(C_YouhiKbn.YOU);
                    uiBean.setHikakuHrhnkyoup(uiBean.getHrhnkyoup());
                }
            }

            if (C_YouhiKbn.YOU.eq(uiBean.getRsgakuHikakuYouhiKbn()) &&
                uiBean.getRsgaku().compareTo(uiBean.getHikakuHrhnkyoup()) > 0) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIA0022);
            }

            if (uiBean.getHrhnkyoup().compareTo(BizCurrency.valueOf(0, uiBean.getHrhnkyoup().getType())) > 0 &&
                C_YouhiKbn.YOU.eq(uiBean.getHrhnkyoupKnsnYouhiKbn())) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF3021);

                if (KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_RYOSYUYMD.equals(uiBean.getKawaseRateKijyunKbn())) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF3019);

                    if (uiBean.getRyosyuYmd() == null) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF3020);
                    }
                }
                else if (KeisanRsgakuConstants.KWSRATEKJYMD_HANTEIKBN_PREMLASTDAY.equals(uiBean.getKawaseRateKijyunKbn())) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF3017);
                    if (uiBean.getRyosyuYmd() == null) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF3018);
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) ||
                C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {

                uiBean.setYykidouuktkdispumu(C_UmuKbn.NONE);

                if ((C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                    (C_Hrkkaisuu.TUKI.eq(uiBean.getVhrkihrkkaisuu()) ||
                        (C_Hrkkaisuu.HALFY.eq(uiBean.getVhrkihrkkaisuu()) && C_Hrkkaisuu.NEN.eq(uiBean.getNewhrkkaisuu())))
                    )
                    ||
                    (!C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                        (C_TkiktbrisyuruiKbn.NONE.eq(uiBean.getVhrkitikiktbrijk()) ||
                            (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getVhrkitikiktbrijk()) && C_TkiktbrisyuruiKbn.TEIKI_12MONTHS
                                .eq(uiBean.getNewtikiktbrisyuruikbn()))
                            )
                        )) {
                    if (BizDateUtil.compareYm(systemDate.getBizDateYM(), uiBean.getHennyuYm()) == BizDateUtil.COMPARE_LESSER) {
                        uiBean.setYykidouuktkdispumu(C_UmuKbn.ARI);
                    } else {
                        if (BizDateUtil.compareYm(uiBean.getVhrkijkipjytym(), uiBean.getHennyuYm()) == BizDateUtil.COMPARE_LESSER) {
                            uiBean.setYykidouuktkdispumu(C_UmuKbn.ARI);
                        } else {
                            uiBean.setYykidouuktkdispumu(C_UmuKbn.NONE);
                        }
                    }
                }
                if ((C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                    (C_Hrkkaisuu.NEN.eq(uiBean.getVhrkihrkkaisuu()) ||
                        (C_Hrkkaisuu.HALFY.eq(uiBean.getVhrkihrkkaisuu()) && C_Hrkkaisuu.TUKI.eq(uiBean.getNewhrkkaisuu())))
                    )
                    ||
                    (!C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                        (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getVhrkitikiktbrijk()) ||
                            (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getVhrkitikiktbrijk()) && C_TkiktbrisyuruiKbn.NONE
                                .eq(uiBean.getNewtikiktbrisyuruikbn()))
                            )
                        )) {
                    if (BizDateUtil.compareYm(systemDate.getBizDateYM(), uiBean.getHennyuYm()) == BizDateUtil.COMPARE_LESSER) {
                        uiBean.setYykidouuktkdispumu(C_UmuKbn.ARI);
                    } else {
                        uiBean.setYykidouuktkdispumu(C_UmuKbn.NONE);
                    }
                }
            }
            else if (C_UmuKbn.ARI.eq(hrkkeirohnkumuHantei) ||
                C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {

                if (C_AnnaijkKbn.ANNAI.eq(uiBean.getAnnaityuuhanteiKbn())) {

                    uiBean.setYykidouuktkdispumu(C_UmuKbn.ARI);
                }
                else {

                    uiBean.setYykidouuktkdispumu(C_UmuKbn.NONE);
                }
            }

            else {
                uiBean.setYykidouuktkdispumu(C_UmuKbn.NONE);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getYykidouuktkdispumu()) &&
                C_YykidouuktkKbn.BLNK.eq(uiBean.getYykidouuktkkbn())) {

                uiBean.setYykidouuktkkbn(C_YykidouuktkKbn.TAISYOU);
            }

            SetHituyouSyorui.exec(khozenCommonParam, uiBean);
        }

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);
        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));
        setKhKbnPatternUtil.exec(uiBean);

    }

    @Transactional
    void pushKukakuteiBL() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }
        else{
            checkProcessKaishi();
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String syoNo = uiBean.getSyono();
        functionId   = khozenCommonParam.getFunctionId();
        userId       = khozenCommonParam.getUserID();
        sysTime      = BizDate.getSysDateTimeMilli();
        sysDate      = BizDate.getSysDate();

        uiBean.getBzWorkflowInfo().setTaskId(kinouMode.getKinouMode());

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

            sikibetuKey  = khozenCommonParam.getSikibetuKey(syoNo);

            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
            tableMaintenanceUtil.backUp(syoNo, sikibetuKey);

            doUpdateTables(khozenCommonParam, tableMaintenanceUtil.getBakKykKihon());

            makeTyouhyou(khozenCommonParam);

            khHaraikataHenkouDao.update(uiBean.getKykKihon());
        }
        else{
            uiBean.getKykKihon().detach();
        }

        doJikouteikanri(khozenCommonParam);

        workTableUpdate();

        if (C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) &&
            C_KyuukouzaAnnaiKbn.KYUUKOUZAANNAI.eq(uiBean.getKyuukouzaannaikbn())) {
            IT_KyuukzAnnaimati kyuukzAnnaimati = hozenDomManager.getKyuukzAnnaimati(
                uiBean.getBzWorkflowInfo().getKouteiKanriId());

            if (kyuukzAnnaimati == null) {
                IT_KyuukzAnnaimati newKyuukzAnnaimati = new IT_KyuukzAnnaimati();
                newKyuukzAnnaimati.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                newKyuukzAnnaimati.setSyono(uiBean.getSyono());
                newKyuukzAnnaimati.setSyorizumiflg(C_Syorizumiflg.MISYORI);
                newKyuukzAnnaimati.setGyoumuKousinKinou(functionId);
                newKyuukzAnnaimati.setGyoumuKousinsyaId(userId);
                newKyuukzAnnaimati.setGyoumuKousinTime(sysTime);

                BizPropertyInitializer.initialize(newKyuukzAnnaimati);

                hozenDomManager.insert(newKyuukzAnnaimati);
            }
            else {
                kyuukzAnnaimati.setSyono(uiBean.getSyono());
                kyuukzAnnaimati.setSyorizumiflg(C_Syorizumiflg.MISYORI);
                kyuukzAnnaimati.setGyoumuKousinKinou(functionId);
                kyuukzAnnaimati.setGyoumuKousinsyaId(userId);
                kyuukzAnnaimati.setGyoumuKousinTime(sysTime);

                hozenDomManager.update(kyuukzAnnaimati);
            }
        }

        if (C_KhkinouModeIdKbn.KYUUKZANNAIMATI.getValue().equals(kinouMode.getKinouMode()) &&
            (C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn()))) {
            IT_KyuukzAnnaimati kyuukzAnnaimati = hozenDomManager.getKyuukzAnnaimati(
                uiBean.getBzWorkflowInfo().getKouteiKanriId());

            hozenDomManager.delete(kyuukzAnnaimati);

            IW_KhHaraikataHenkouWk khHaraikataHenkouWk = uiBean.getKhHaraikataHenkouWk();

            khHaraikataHenkouWk.setKyuukouzaannaikbn(C_KyuukouzaAnnaiKbn.BLNK);
            khHaraikataHenkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            khHaraikataHenkouWk.setGyoumuKousinKinou(functionId);
            khHaraikataHenkouWk.setGyoumuKousinsyaId(userId);
            khHaraikataHenkouWk.setGyoumuKousinTime(sysTime);

            hozenDomManager.update(khHaraikataHenkouWk);
        }

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) &&
            C_AuthorijkKbn.IRAITYUU.eq(uiBean.getAuthorijkKbn())) {

            IT_CardTourokuMati cardTourokuMati = hozenDomManager.getCardTourokuMati(
                uiBean.getBzWorkflowInfo().getKouteiKanriId());

            if (cardTourokuMati == null) {

                cardTourokuMati = new IT_CardTourokuMati();
                cardTourokuMati.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                cardTourokuMati.setSyono(uiBean.getSyono());
                cardTourokuMati.setCreditkessaiyouno(uiBean.getSaibanCreditKessaiyouNo());
                cardTourokuMati.setSyorizumiflg(C_Syorizumiflg.MISYORI);
                cardTourokuMati.setGyoumuKousinKinou(functionId);
                cardTourokuMati.setGyoumuKousinsyaId(userId);
                cardTourokuMati.setGyoumuKousinTime(sysTime);

                hozenDomManager.insert(cardTourokuMati);
            }
            else {
                cardTourokuMati.setSyono(uiBean.getSyono());
                cardTourokuMati.setCreditkessaiyouno(uiBean.getSaibanCreditKessaiyouNo());
                cardTourokuMati.setSyorizumiflg(C_Syorizumiflg.MISYORI);
                cardTourokuMati.setGyoumuKousinKinou(functionId);
                cardTourokuMati.setGyoumuKousinsyaId(userId);
                cardTourokuMati.setGyoumuKousinTime(sysTime);

                hozenDomManager.update(cardTourokuMati);
            }
        }

        if (C_KhkinouModeIdKbn.CARDTOUROKUMATI.getValue().equals(kinouMode.getKinouMode()) &&
            (C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn()))) {

            IT_CardTourokuMati cardTourokuMati = hozenDomManager.getCardTourokuMati(uiBean.getBzWorkflowInfo()
                .getKouteiKanriId());

            hozenDomManager.delete(cardTourokuMati);

            IW_KhHaraikataHenkouWk khHaraikataHenkouWk = uiBean.getKhHaraikataHenkouWk();
            khHaraikataHenkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            khHaraikataHenkouWk.setGyoumuKousinKinou(functionId);
            khHaraikataHenkouWk.setGyoumuKousinsyaId(userId);
            khHaraikataHenkouWk.setGyoumuKousinTime(sysTime);

            hozenDomManager.update(khHaraikataHenkouWk);
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    String pushSyokiGamenheKekka() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }


    @Transactional
    void pushKakuteiByskConfirmBL() {
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        sysDate = BizDate.getSysDate();
        sysTime = BizDate.getSysDateTimeMilli();
        functionId = khozenCommonParam.getFunctionId();
        userId = khozenCommonParam.getUserID();

        uiBean.getBzWorkflowInfo().setTaskId(kinouMode.getKinouMode());

        checkProcessKaishi();

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector
            .getInstance(KhHituyousyoruiHanteiInBean.class);
        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        khHituyousyoruiHanteiInBean.setKouteikanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(uiBean.getHrkkeirohnkumu());
        khHituyousyoruiHanteiInBean.setHenkougoHrkkeiro(uiBean.getNewhrkkeiro());

        hozenPreReportRenkeiBean.setSyoNo(uiBean.getSyono());
        hozenPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());
        hozenPreReportRenkeiBean.setSyoriComment("");
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {

            SaibanCreditKessaiyouNo saibanCreditKessaiyouNo = SWAKInjector.getInstance(SaibanCreditKessaiyouNo.class);

            uiBean.setSaibanCreditKessaiyouNo(saibanCreditKessaiyouNo.exec(C_CreditCardKeySyuruiKbn.SYONO,
                uiBean.getSyono()));

            CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu = SWAKInjector
                .getInstance(CreditKessaiyouNoHensyuu.class);

            uiBean.setDispsaibancreditkessaiyouno(creditKessaiyouNoHensyuu.exec(uiBean
                .getSaibanCreditKessaiyouNo()));

        }

        makeTyouhyouSks(khozenCommonParam);

        doUpdateTablesSks(hozenPreReportRenkeiBean);

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);
    }

    void pushModoruByConfirmBL() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING5);
    }

    String pushFunctionNameOnClickBL() {
        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.CARDTOUROKUMATI.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.KYUUKZANNAIMATI.getValue().equals(kinouMode.getKinouMode())) {
            pushUnlockProcessBL();

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    void pushSainyuuryokubtnOnClickBL() {

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);
    }

    void pushUnlockProcessBL() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.unlockProcess();
    }

    void continueLockProcessBL() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();
    }

    void pushSeikyusyoSakuseiBL() {
        checkProcessKaishi();
        messageManager.addMessageId(MessageId.QIA0004);
    }

    void pushKakuninBL(){
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }

        C_YouhiKbn authoriHeitYouyh = null;

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) ||
            ((C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            if(C_Hrkkeiro.BLNK.eq(uiBean.getNewhrkkeiro()) &&
                (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) || C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu()))){
                uiBean.setHaraikatahnkumu(C_UmuKbn.ARI);
            }
            else{
                uiBean.setHaraikatahnkumu(C_UmuKbn.NONE);
            }

            if(C_Syoumetujiyuu.SIKKOU.eq(uiBean.getVkihnsyoumetujiyuu())){
                throw new BizLogicException(MessageId.EIA0035, "失効");
            }

            CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
            boolean syoriKekka = checkYuuyokkngai.exec(uiBean.getSyono(), BizDate.getSysDate());
            if(!syoriKekka){
                throw new BizLogicException(MessageId.EIA0085);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getYykidouuktkdispumu()) && C_YykidouuktkKbn.BLNK.eq(uiBean.getYykidouuktkkbn())) {

                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_YYKIDOUUKTKINFO_YYKIDOUUKTKKBN.getErrorResourceKey()));
            }

            if (uiBean.getRsgaku().compareTo(BizCurrency.valueOf(0)) > 0 &&
                C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn())) {

                throw new BizLogicException(MessageId.EIA0153);
            }

            if (C_AnnaijkKbn.ANNAI.eq(uiBean.getAnnaityuuhanteiKbn()) &&
                C_YykidouuktkKbn.TAISYOUGAI.eq(uiBean.getYykidouuktkkbn())) {

                throw new BizLogicException(MessageId.EIA0152);
            }

            if (!HRHNKYOUP_HUKARIYUU_NONE.equals(uiBean.getHrhnkyoupHukaRiyuu()) &&
                !C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn())) {

                throw new BizLogicException(MessageId.EIF3080);
            }

            if (C_Hrkkaisuu.HALFY.eq(uiBean.getVhrkihrkkaisuu()) && C_Hrkkaisuu.NEN.eq(uiBean.getNewhrkkaisuu()) &&
                uiBean.getRsgaku().compareTo(BizCurrency.valueOf(0, uiBean.getRsgaku().getType())) > 0) {
                throw new BizLogicException(MessageId.EIF3075);
            }

            List<String> syonoList = khHaraikataHenkouDao.getSyonos(uiBean.getSyono(), BizDate.getSysDate());

            if(syonoList.size() > 0) {
                if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) || C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {
                    throw new BizLogicException(MessageId.EIA0106);
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) || C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {
                if (BizDateUtil.compareYm(uiBean.getHenkouyoteiym(), uiBean.getVhrkijkipjytym()) != BizDateUtil.COMPARE_EQUAL) {

                    throw new BizLogicException(MessageId.EIA0142);
                }
            }

            if (!C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn())
                &&(( uiBean.getHrhnkyoup().compareTo(BizCurrency.valueOf(0, (uiBean.getHrhnkyoup().getType()))) > 0
                && uiBean.getRsgaku().compareTo(BizCurrency.valueOf(0, (uiBean.getRsgaku().getType()))) == 0)
                ||( C_YouhiKbn.YOU.eq(uiBean.getRsgakuHikakuYouhiKbn())
                && uiBean.getRsgaku().compareTo(uiBean.getHikakuHrhnkyoup()) < 0))) {
                throw new BizLogicException(MessageId.EIA0143);
            }

            if (!C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn()) &&
                uiBean.getRsgaku().compareTo(BizCurrency.valueOf(0, uiBean.getRsgaku().getType())) > 0 &&
                ((C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                    C_Hrkkaisuu.TUKI.eq(uiBean.getVhrkihrkkaisuu())) ||
                    C_TkiktbrisyuruiKbn.NONE.eq(uiBean.getVhrkitikiktbrijk()))) {

                if (HRHNKYOUP_HUKARIYUU_IKTWARIBIKIK_ARI.equals(uiBean.getHrhnkyoupHukaRiyuu())) {
                    throw new BizLogicException(MessageId.EIF3044);
                }
            }

            if (C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())) {

                chkKouza(khozenCommonParam);
            }
            else if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {

                uiBean.setHaraikatahnkumu(C_UmuKbn.ARI);
            }

            BizDate tinyuuAnnaibi = BizDate.valueOf("99999999");
            BizDate systemYmd = BizDate.getSysDate();

            if (C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())) {

                SetAnnaibi setAnnaibi = SWAKInjector.getInstance(SetAnnaibi.class);

                setAnnaibi.exec(uiBean.getHennyuYm());

                tinyuuAnnaibi = setAnnaibi.getTinyuuAnnaibi();
            }
            else if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {

                SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector
                    .getInstance(SetCreditUriageSeikyuubi.class);

                setCreditUriageSeikyuubi.exec(uiBean.getHennyuYm().getNextMonth().getFirstDay());

                tinyuuAnnaibi = setCreditUriageSeikyuubi.getJikaiUrsktysytbi();
            }

            if (BizDateUtil.compareYmd(tinyuuAnnaibi,systemYmd) == BizDateUtil.COMPARE_LESSER) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5, MessageId.WIA0047);
            }


            if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()) &&
                C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
                C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro()) &&
                C_AuthorijkKbn.IRAITYUU.eq(uiBean.getAuthorijkKbn())) {

                throw new BizLogicException(MessageId.EIF3046);
            }

            if (C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn()) &&
                !C_KanryotuutioutKbn.GAIBU.eq(uiBean.getKanryotuutioutkbn())) {

                if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro()) &&
                    C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())) {
                }
                else {

                    throw new BizLogicException(MessageId.EIF3028);
                }
            }

            if (C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn()) &&
                C_UmuKbn.ARI.eq(uiBean.getVdtumukbn()) &&
                !C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro()) &&
                (BizDateUtil.compareYm(systemYmd.getBizDateYM(), uiBean.getHennyuYm()) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYm(systemYmd.getBizDateYM(), uiBean.getHennyuYm()) == BizDateUtil.COMPARE_GREATER)) {

                throw new BizLogicException(MessageId.EIF3041);
            }

            if (C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn())) {
                BizDateYM hennyuYm = uiBean.getHennyuYm();

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5, MessageId.WIA0048,
                    String.valueOf(hennyuYm.getYear()), String.valueOf(hennyuYm.getMonth()));
            }
        }

        CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);
        checkProcessKekka.exec(uiBean.getSyorikekkakbn(), uiBean.getSyanaicommentkh(),
            uiBean.getSasimodosisakikbn());

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
            C_UmuKbn umuKbn = checkProcessKaishi
                .exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(umuKbn)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi
                    .getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA1002,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    void printOut() {
        String tyhykey = uiBean.getTyouhyouKey();
        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);
        if (uiBean.getPageNo() == PAGENO_RESULT) {
            outputReport.outputPDFByJoinKey(tyhykey);
        } else if (uiBean.getPageNo() == PAGENO_SKSRESULT) {
            if (C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())) {
                try {
                    DBAOutputReport dbaOutputReport = SWAKInjector.getInstance(DBAOutputReport.class);
                    byte[] pkzhrikeIraisyo = dbaOutputReport.getPdfImagesByJoinKeys(new String[]{tyhykey});
                    String root = SWAK.getApplicationRootPath();
                    YuyuHozenConfig conf = YuyuHozenConfig.getInstance();
                    String pkzhrikeIraisyoKinyuureiFilePath = root + conf.getPkzhrikeIraisyoKinyuureiFilePath();
                    PdfBuilder imageDate = new PdfBuilder();
                    PdfReader kinyuurei = new PdfReader(pkzhrikeIraisyoKinyuureiFilePath);
                    imageDate.append(new PdfReader(pkzhrikeIraisyo));
                    imageDate.append(kinyuurei);
                    outputReport.outputJoinedPDFByBinary(imageDate.toByteArray(), tyhykey);
                } catch (IOException e) {
                    throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));
                }
            }
            else if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {

                try {
                    DBAOutputReport dbaOutputReport = SWAKInjector.getInstance(DBAOutputReport.class);
                    byte[] pkzhrikeIraisyo = dbaOutputReport.getPdfImagesByJoinKeys(new String[] { tyhykey });
                    String root = SWAK.getApplicationRootPath();
                    YuyuHozenConfig conf = YuyuHozenConfig.getInstance();
                    String pkzhrikeIraisyoKinyuureiFilePath = root + conf.getCreditcardSioriFilePath();
                    PdfBuilder imageDate = new PdfBuilder();
                    PdfReader kinyuurei = new PdfReader(pkzhrikeIraisyoKinyuureiFilePath);
                    imageDate.append(new PdfReader(pkzhrikeIraisyo));
                    imageDate.append(kinyuurei);
                    outputReport.outputJoinedPDFByBinary(imageDate.toByteArray(), tyhykey);
                } catch (IOException e) {
                    throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));
                }

            } else {
                outputReport.outputPDFByJoinKey(tyhykey);
            }
        }
    }

    void printHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    String pushSyoukaiNomi(){
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            pushUnlockProcessBL();

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;

    }


    private void checkKykSonzai() {
        IT_KykKihon kykKihon = khHaraikataHenkouDao.getKykKihon(uiBean.getSyono());

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
        else if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, checkYuukouJyoutai
                    .getWarningMessageIDList().get(i), checkYuukouJyoutai.getWarningMessageList().get(i));
            }
        }
    }

    private void checkHanteiTetuduki(KhozenCommonParam pKhozenCommonParam) {
        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(pKhozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    private void setUiBean(KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);

        SetKihon.exec(pKhozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(pKhozenCommonParam, uiBean);
        for(int i = 0; i< uiBean.getWarningMessageIdList().size(); i++){
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, BizUtil
                .getGeneralMessageId(uiBean.getWarningMessageIdList().get(i)), uiBean.getWarningMessageList().get(i));
        }

        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);

        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);

        SetTuusinsaki.exec(pKhozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(pKhozenCommonParam, uiBean);

        SetTokusin.exec(pKhozenCommonParam, uiBean);

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);
        setKariukekin.exec(pKhozenCommonParam, uiBean);

        SetDattai.exec(pKhozenCommonParam, uiBean);

        SetTrkKazoku.exec(pKhozenCommonParam, uiBean);

        SetKyksyadairi.exec(pKhozenCommonParam, uiBean);

        SetHosyou setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyou.exec(pKhozenCommonParam, uiBean);
    }

    private void checkGmwarning1(){
        List<IT_AnsyuRireki> ansyuRirekiList = khHaraikataHenkouDao.getAnsyuRirekis(uiBean.getSyono(),
            C_AnnaijkKbn.ANNAI);

        for (IT_AnsyuRireki ansyuRireki : ansyuRirekiList) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA0016,
                String.valueOf(ansyuRireki.getJyuutouym().getMonth()),
                String.valueOf(DefaultDateFormatter.formatMDZeroFill(ansyuRireki.getAnnaisakuseiymd())));
        }
    }

    private void setKariukekinData(){

        BizCurrency sumKrkGk = BizCurrency.valueOf(0);

        List<KariukekinMinRyosyuymdSumKrkgkBean> kariukekinMinRyosyuymdSumKrkgkBeanList = khHaraikataHenkouDao
            .getKariukekinMinRyosyuymdSumKrkgk(uiBean.getSyono());

        if (kariukekinMinRyosyuymdSumKrkgkBeanList.size() >0 ) {

            sumKrkGk = kariukekinMinRyosyuymdSumKrkgkBeanList.get(0).getSumKrkgk();

            if (sumKrkGk.compareTo(BizCurrency.valueOf(0)) > 0) {
                uiBean.setRyosyuYmd(kariukekinMinRyosyuymdSumKrkgkBeanList.get(0).getMinRyosyuymd());
                uiBean.setRyosyuYmdMax(kariukekinMinRyosyuymdSumKrkgkBeanList.get(0).getMaxRyosyuymd());
                uiBean.setRsgaku(kariukekinMinRyosyuymdSumKrkgkBeanList.get(0).getSumKrkgk());
                uiBean.setHasseidenYmd(kariukekinMinRyosyuymdSumKrkgkBeanList.get(0).getMaxHasseidenymd());
            }
            else {
                uiBean.setRyosyuYmd(null);
                uiBean.setRyosyuYmdMax(null);
                uiBean.setRsgaku(BizCurrency.valueOf(0));
                uiBean.setHasseidenYmd(null);
            }
        }
        else {
            uiBean.setRyosyuYmd(null);
            uiBean.setRyosyuYmdMax(null);
            uiBean.setRsgaku(BizCurrency.valueOf(0));
            uiBean.setHasseidenYmd(null);
        }
    }

    private void chkKouza(KhozenCommonParam pKhozenCommonParam) {

        CheckKzhuriKouza checkKzhuriKouza = SWAKInjector.getInstance(CheckKzhuriKouza.class);

        checkKzhuriKouza.exec(uiBean);

        IT_Kouza kouza = uiBean.getKykKihon().getKouza();

        String oldBankcd = "";
        String oldSitencd = "";
        C_YokinKbn oldYokinkbn = C_YokinKbn.BLNK;
        String oldKouzano = "";
        C_KzkykdouKbn oldKzkykdouKbn = C_KzkykdouKbn.BLNK;
        String oldKzmeiginmkn = "";

        if (kouza != null) {
            oldBankcd = kouza.getBankcd();
            oldSitencd = kouza.getSitencd();
            oldYokinkbn = kouza.getYokinkbn();
            oldKouzano = kouza.getKouzano();
            oldKzkykdouKbn = kouza.getKzkykdoukbn();
            oldKzmeiginmkn = kouza.getKzmeiginmkn();
        }

        if (uiBean.getBankcd().equals(oldBankcd) && uiBean.getSitencd().equals(oldSitencd) &&
            uiBean.getYokinkbn().eq(oldYokinkbn) && uiBean.getKouzano().equals(oldKouzano) &&
            uiBean.getKzkykdoukbn().eq(oldKzkykdouKbn) && uiBean.getKzmeiginmkn().equals(oldKzmeiginmkn)) {
            throw new BizLogicException(MessageId.EIA0044, "口座情報");

        }
        uiBean.setHaraikatahnkumu(C_UmuKbn.ARI);
    }

    private void doUpdateTablesSks(HozenPreReportRenkeiBean pHozenPreReportRenkeiBean) {

        IW_KhHaraikataHenkouWk khHaraikataHenkouWk = new IW_KhHaraikataHenkouWk();
        khHaraikataHenkouWk.setKouteikanriid(pHozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());
        khHaraikataHenkouWk.setSyono(uiBean.getSyono());
        khHaraikataHenkouWk.setSkssakuseiymd(BizDate.getSysDate());
        khHaraikataHenkouWk.setNewhrkkeiro(uiBean.getNewhrkkeiro());
        khHaraikataHenkouWk.setNewhrkkaisuu(uiBean.getNewhrkkaisuu());
        khHaraikataHenkouWk.setNewtikiktbrisyuruikbn(uiBean.getNewtikiktbrisyuruikbn());
        khHaraikataHenkouWk.setHenkouyoteiym(uiBean.getHenkouyoteiym());
        khHaraikataHenkouWk.setGyoumuKousinKinou(functionId);
        khHaraikataHenkouWk.setGyoumuKousinsyaId(userId);
        khHaraikataHenkouWk.setGyoumuKousinTime(sysTime);
        khHaraikataHenkouWk.setCreditkessaiyouno(uiBean.getSaibanCreditKessaiyouNo());

        BizPropertyInitializer.initialize(khHaraikataHenkouWk);

        khHaraikataHenkouDao.insert(khHaraikataHenkouWk);

        if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {

            IT_HrhnCreditCardTouroku hrhnCreditCardTouroku = new IT_HrhnCreditCardTouroku();

            hrhnCreditCardTouroku.setCreditkessaiyouno(uiBean.getSaibanCreditKessaiyouNo());
            hrhnCreditCardTouroku.setSyono(uiBean.getSyono());
            hrhnCreditCardTouroku.setAuthorijkkbn(C_AuthorijkKbn.IRAITYUU);
            hrhnCreditCardTouroku.setGyoumuKousinKinou(functionId);
            hrhnCreditCardTouroku.setGyoumuKousinsyaId(userId);
            hrhnCreditCardTouroku.setGyoumuKousinTime(sysTime);

            BizPropertyInitializer.initialize(hrhnCreditCardTouroku);

            hozenDomManager.insert(hrhnCreditCardTouroku);

        }
    }

    private void doUpdateTables(KhozenCommonParam pKhozenCommonParam, IT_BAK_KykKihon pIT_BAK_KykKihon) {

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        boolean dattaiKaisyouFlg = false;
        boolean kouzaHenkouFlg = false;

        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro()) &&
            C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())) {

            khHaraikataHenkouDao.setKouza(kykKihon, null);

            khHaraikataHenkouDao.flush();

            setKouzaTbl(kykKihon);

            kykKihon.setSyhenkouymd(sysDate);
            kykKihon.setGyoumuKousinKinou(functionId);
            kykKihon.setGyoumuKousinsyaId(userId);
            kykKihon.setGyoumuKousinTime(sysTime);

            dattaiKaisyouFlg = true;
            kouzaHenkouFlg = true;
        }

        String syoNo           = uiBean.getSyono();
        C_Hrkkeiro oldHrkKeiro    = uiBean.getVhrkihrkkeiro();
        C_Hrkkeiro newHrkKeiro = uiBean.getNewhrkkeiro();
        BizDateYM hennyuYm     = uiBean.getHennyuYm();

        List<IT_KykSyouhn> kykSyouhnSyuLst = pKhozenCommonParam.getKeiyakuSyouhin(syoNo, C_SyutkKbn.SYU);
        IT_KykSyouhn syukykSyouhn = kykSyouhnSyuLst.get(0);

        IT_AnsyuKihon ansyuKihon = khHaraikataHenkouDao.getAnsyuKihon(syoNo);

        String oldHkSikibetuKey = syukykSyouhn.getHenkousikibetukey();

        C_Kykjyoutai kykjyoutai = syukykSyouhn.getKykjyoutai();

        C_Kykjyoutai oldKykjyoutai = syukykSyouhn.getKykjyoutai();

        BizCurrency oldHokenryou = syukykSyouhn.getHokenryou();

        if (C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn())) {

            long yykIdouUktkKensu = khHaraikataHenkouDao.getYykIdouUktkCount(syoNo, functionId);

            if (yykIdouUktkKensu > 0) {
                List<IT_YykIdouUktk> yykIdouUktkLst = khHaraikataHenkouDao.getYykIdouUktks(
                    kykKihon,C_YykidousyoriKbn.UKE);

                for (IT_YykIdouUktk yykIdouUktk : yykIdouUktkLst) {
                    yykIdouUktk.setYykidousyorikbn(C_YykidousyoriKbn.TORIKESI);
                    yykIdouUktk.setGyoumuKousinKinou(functionId);
                    yykIdouUktk.setGyoumuKousinsyaId(userId);
                    yykIdouUktk.setGyoumuKousinTime(sysTime);
                }
            }

            IT_YykIdouUktk yykIdouUktk = khHaraikataHenkouDao.createYykIdouUktk(kykKihon);

            yykIdouUktk.setHenkousikibetukey(sikibetuKey);
            yykIdouUktk.setKinouId(functionId);
            yykIdouUktk.setYykidousyorikbn(C_YykidousyoriKbn.UKE);
            yykIdouUktk.setSyoriym(hennyuYm);
            yykIdouUktk.setUktkymd(sysDate);
            yykIdouUktk.setGyoumuKousinKinou(functionId);
            yykIdouUktk.setGyoumuKousinsyaId(userId);
            yykIdouUktk.setGyoumuKousinTime(sysTime);

            BizPropertyInitializer.initialize(yykIdouUktk);

            C_UmuKbn hrkKeiroHnkUmu  = C_UmuKbn.NONE;
            C_UmuKbn hrkKaisuuHnkUmu = C_UmuKbn.NONE;
            String bankCd = "";
            String sitenCd = "";
            C_YokinKbn yokinKbn = C_YokinKbn.BLNK;
            String kouzaNo = "";
            String kzMeiginmKn = "";
            C_SinkeizkKbn sinkeizkKbn = C_SinkeizkKbn.BLNK;
            C_KzkykdouKbn kzkykdouKbn = C_KzkykdouKbn.BLNK;
            String creditkessaiyouno = "";
            C_CardBrandKbn cardBrandKbn = C_CardBrandKbn.BLNK;
            String creditKaiinnoSimo4keta = "";
            C_Syuudaikocd syuudaikocd = C_Syuudaikocd.BLNK;

            if (C_Hrkkeiro.BLNK.eq(newHrkKeiro) ||
                (C_Hrkkeiro.KOUHURI.eq(oldHrkKeiro) &&
                    C_Hrkkeiro.KOUHURI.eq(newHrkKeiro))) {

                hrkKeiroHnkUmu = C_UmuKbn.NONE;
            }
            else {
                hrkKeiroHnkUmu = C_UmuKbn.ARI;

                if (C_Hrkkeiro.KOUHURI.eq(newHrkKeiro)) {

                    if (uiBean.getBankcd().equals(uiBean.getVhrkihrkinfobankcd()) &&
                        !C_SinkeizkKbn.SHINKI.eq(uiBean.getVhrkihrkinfosinkeizkkbn())) {

                        sinkeizkKbn = C_SinkeizkKbn.HENKOU;
                    }
                    else {

                        sinkeizkKbn = C_SinkeizkKbn.SHINKI;
                    }

                    bankCd = uiBean.getBankcd();
                    sitenCd = uiBean.getSitencd();
                    yokinKbn = uiBean.getYokinkbn();
                    kouzaNo = uiBean.getKouzano();
                    kzMeiginmKn = uiBean.getKzmeiginmkn();
                    kzkykdouKbn = uiBean.getKzkykdoukbn();
                    syuudaikocd = C_Syuudaikocd.SIS;
                }
                else if (C_Hrkkeiro.CREDIT.eq(newHrkKeiro)) {

                    creditkessaiyouno = uiBean.getSaibanCreditKessaiyouNo();
                    cardBrandKbn = uiBean.getCardBrandKbn();
                    creditKaiinnoSimo4keta = uiBean.getCreditKaiinnoSimo4keta();
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) || C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {
                hrkKaisuuHnkUmu = C_UmuKbn.ARI;
            }
            else {
                hrkKaisuuHnkUmu = C_UmuKbn.NONE;
            }

            C_HaraikatahnkuktknaiyouKbn hrkhnkUktkNaiyouKbn = C_HaraikatahnkuktknaiyouKbn.BLNK;

            if (C_UmuKbn.ARI.eq(hrkKaisuuHnkUmu)) {

                if (C_UmuKbn.ARI.eq(hrkKeiroHnkUmu)) {

                    hrkhnkUktkNaiyouKbn = C_HaraikatahnkuktknaiyouKbn.KAISUUKEIROHENKOU;
                }
                else {

                    hrkhnkUktkNaiyouKbn = C_HaraikatahnkuktknaiyouKbn.KAISUUHENKOU;
                }
            }
            else {

                if (C_UmuKbn.ARI.eq(hrkKeiroHnkUmu)) {

                    hrkhnkUktkNaiyouKbn = C_HaraikatahnkuktknaiyouKbn.KEIROHENKOU;
                }
            }

            IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk = khHaraikataHenkouDao.createYykIdouNaiyoHrhnk(kykKihon);


            yykIdouNaiyoHrhnk.setHenkousikibetukey(sikibetuKey);

            BizDate hennyuYmd = BizDate.valueOf(hennyuYm, syukykSyouhn.getKykymd().getDay());
            if (!hennyuYmd.isRekijyou()){

                hennyuYmd = hennyuYmd.getRekijyou();
            }
            yykIdouNaiyoHrhnk.setKouryokuhasseiymd(hennyuYmd);

            if(C_UmuKbn.ARI.eq(hrkKeiroHnkUmu)){
                yykIdouNaiyoHrhnk.setNewhrkkeiro(newHrkKeiro);
            }
            yykIdouNaiyoHrhnk.setNewhrkkaisuu(uiBean.getNewhrkkaisuu());
            yykIdouNaiyoHrhnk.setNewtikiktbrisyuruikbn(uiBean.getNewtikiktbrisyuruikbn());
            yykIdouNaiyoHrhnk.setHrkkeirohnkumu(hrkKeiroHnkUmu);
            yykIdouNaiyoHrhnk.setHrkkaisuuhnkumu(uiBean.getHrkkaisuuhnkumu());
            yykIdouNaiyoHrhnk.setTikiktbrisyuruihnkumu (uiBean.getTikiktbrisyuruihnkumu());
            yykIdouNaiyoHrhnk.setHaraikatahnkumu(uiBean.getHaraikatahnkumu());
            yykIdouNaiyoHrhnk.setHaraikatahnkuktknaiyoukbn(hrkhnkUktkNaiyouKbn);

            if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu())) {
                yykIdouNaiyoHrhnk.setHrkp(uiBean.getNewhrkp());
            }
            else {
                yykIdouNaiyoHrhnk.setHrkp(uiBean.getVhrkihrkp());
            }

            yykIdouNaiyoHrhnk.setBankcd(bankCd);
            yykIdouNaiyoHrhnk.setSitencd(sitenCd);
            yykIdouNaiyoHrhnk.setYokinkbn(yokinKbn);
            yykIdouNaiyoHrhnk.setKouzano(kouzaNo);
            yykIdouNaiyoHrhnk.setKzmeiginmkn(kzMeiginmKn);
            yykIdouNaiyoHrhnk.setSinkeizkkbn(sinkeizkKbn);
            yykIdouNaiyoHrhnk.setSyuudaikocd(syuudaikocd);
            yykIdouNaiyoHrhnk.setGyoumuKousinKinou(functionId);
            yykIdouNaiyoHrhnk.setGyoumuKousinsyaId(userId);
            yykIdouNaiyoHrhnk.setGyoumuKousinTime(sysTime);
            yykIdouNaiyoHrhnk.setKzkykdoukbn(kzkykdouKbn);
            yykIdouNaiyoHrhnk.setCreditkessaiyouno(creditkessaiyouno);
            yykIdouNaiyoHrhnk.setCardbrandkbn(cardBrandKbn);
            yykIdouNaiyoHrhnk.setCreditkaiinnosimo4keta(creditKaiinnoSimo4keta);

            BizPropertyInitializer.initialize(yykIdouNaiyoHrhnk);
        }
        else {
            C_Hrkkeiro hrkKeiro = C_Hrkkeiro.BLNK;
            C_Hrkkaisuu hrkKaisuu = C_Hrkkaisuu.BLNK;
            BizCurrency hrkP = BizCurrency.valueOf(0);
            C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.BLNK;
            dattaiKaisyouFlg = true;

            if (C_UmuKbn.ARI.eq(uiBean.getHrkkeirohnkumu())) {
                hrkKeiro = uiBean.getNewhrkkeiro();
            }
            else {
                hrkKeiro = uiBean.getVhrkihrkkeiro();
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu())) {
                hrkKaisuu = uiBean.getNewhrkkaisuu();
                hrkP = uiBean.getNewhrkp();
            }
            else {
                hrkKaisuu = uiBean.getVhrkihrkkaisuu();
                hrkP = uiBean.getVhrkihrkp();
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {
                tkiktbrisyuruiKbn = uiBean.getNewtikiktbrisyuruikbn();
            }
            else {
                tkiktbrisyuruiKbn = uiBean.getVhrkitikiktbrijk();
            }

            kykKihon.setHrkkeiro(hrkKeiro);
            kykKihon.setHrkkaisuu(hrkKaisuu);
            kykKihon.setSdpdkbn(uiBean.getNewSdpdkbn());
            kykKihon.setHrkp(hrkP);
            kykKihon.setTikiktbrisyuruikbn(tkiktbrisyuruiKbn);
            kykKihon.setSyhenkouymd(sysDate);
            kykKihon.setGyoumuKousinKinou(functionId);
            kykKihon.setGyoumuKousinsyaId(userId);
            kykKihon.setGyoumuKousinTime(sysTime);

            if (!uiBean.getVhrkihrkkeiro().eq(hrkKeiro) ||
                C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) ||
                C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu())) {

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);
                editKykSyhnRirekiTbl.exec(pKhozenCommonParam, syoNo);

                if (C_UmuKbn.NONE.eq(uiBean.getHrkkaisuuhnkumu()) && C_UmuKbn.NONE.eq(uiBean.getTikiktbrisyuruihnkumu())) {

                    kouryokuHasseiYmd = BizDate.valueOf(uiBean.getVhrkijkipjytym(), syukykSyouhn.getKykymd().getDay());

                    if (!kouryokuHasseiYmd.isRekijyou()){

                        kouryokuHasseiYmd = kouryokuHasseiYmd.getRekijyou();
                    }
                }
                else {

                    kouryokuHasseiYmd = BizDate.valueOf(uiBean.getHennyuYm(), syukykSyouhn.getKykymd().getDay());

                    if (!kouryokuHasseiYmd.isRekijyou()){

                        kouryokuHasseiYmd = kouryokuHasseiYmd.getRekijyou();
                    }
                }

                /*

                if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) && !C_Hrkkaisuu.TUKI.eq(uiBean.getNewhrkkaisuu())) {
                    kykYmdSiteiUmuKbn = C_UmuKbn.NONE;
                }
                else if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu())
                    && C_Hrkkaisuu.TUKI.eq(uiBean.getNewhrkkaisuu())
                    && BizDateUtil.compareYmd(syukykSyouhn.getKykymd(),syukykSyouhn.getSknnkaisiymd()) ==
                    BizDateUtil.COMPARE_EQUAL) {
                    kykYmdSiteiUmuKbn = C_UmuKbn.ARI;
                }
                else if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu())
                    && C_Hrkkaisuu.TUKI.eq(uiBean.getNewhrkkaisuu())
                    && BizDateUtil.compareYmd(syukykSyouhn.getKykymd(),syukykSyouhn.getSknnkaisiymd()) !=
                    BizDateUtil.COMPARE_EQUAL) {
                    kykYmdSiteiUmuKbn = C_UmuKbn.NONE;
                }
                else {
                    kykYmdSiteiUmuKbn = syukykSyouhn.getKykymdsiteiumukbn();
                }
                 */

                C_UmuKbn kykYmdSiteiUmuKbn = syukykSyouhn.getKykymdsiteiumukbn();

                if (uiBean.getHikakuHrhnkyoup().compareTo(
                    BizCurrency.valueOf(0, uiBean.getHikakuHrhnkyoup().getType())) > 0 &&
                    C_Hrkkaisuu.TUKI.eq(hrkKaisuu)) {
                    CheckIkktNyuknKykjyuti checkIkktNyuknKykjyuti = SWAKInjector.getInstance(CheckIkktNyuknKykjyuti.class);

                    kykjyoutai = checkIkktNyuknKykjyuti.exec(sysDate, uiBean.getHennyuYm());
                }
                else {
                    kykjyoutai = uiBean.getVkihnkykjyoutai();
                }

                List<IT_KykSyouhn> kykSyouhnLst = null;

                kykSyouhnLst = khHaraikataHenkouDao.getKykSyouhns1(kykKihon);

                for (IT_KykSyouhn kykSyouhn : kykSyouhnLst){
                    kykSyouhn.setHenkousikibetukey(sikibetuKey);
                    kykSyouhn.setKykjyoutai(kykjyoutai);
                    kykSyouhn.setKouryokuhasseiymd(kouryokuHasseiYmd);
                    kykSyouhn.setKykymdsiteiumukbn(kykYmdSiteiUmuKbn);
                    if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu())) {
                        kykSyouhn.setHokenryou(uiBean.getNewsyup());
                    }
                    kykSyouhn.setGyoumuKousinKinou(functionId);
                    kykSyouhn.setGyoumuKousinsyaId(userId);
                    kykSyouhn.setGyoumuKousinTime(sysTime);
                }

                List<String> tkSyouhnCdsLst = uiBean.getDisptkSyouhnCds();

                if (tkSyouhnCdsLst != null && tkSyouhnCdsLst.size() > 0 ) {

                    List<Integer> tkSyouhnSdNosLst = uiBean.getDisptkSyouhnSdNos();
                    List<Integer> tkKykSyouhnRenNosLst = uiBean.getDisptkKykSyouhnRenNos();
                    List<BizCurrency> newTkPsLst = uiBean.getDispnewTkPs();

                    for (int tkIndex = 0; tkIndex < tkSyouhnCdsLst.size(); tkIndex++) {

                        kykSyouhnLst = khHaraikataHenkouDao.getKykSyouhns3(
                            kykKihon,
                            tkSyouhnCdsLst.get(tkIndex),
                            tkSyouhnSdNosLst.get(tkIndex),
                            tkKykSyouhnRenNosLst.get(tkIndex));

                        for (IT_KykSyouhn kykSyouhn : kykSyouhnLst){
                            if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu())) {
                                kykSyouhn.setHokenryou(newTkPsLst.get(tkIndex));
                            }
                        }
                    }
                }

                List<IT_SyouhnTokujou> syouhnTokujouLst = khHaraikataHenkouDao.getSyouhnTokujous(kykKihon);

                for (IT_SyouhnTokujou syouhnTokujou : syouhnTokujouLst) {
                    syouhnTokujou.setHenkousikibetukey(sikibetuKey);
                    syouhnTokujou.setGyoumuKousinKinou(functionId);
                    syouhnTokujou.setGyoumuKousinsyaId(userId);
                    syouhnTokujou.setGyoumuKousinTime(sysTime);
                }
            }

            if (uiBean.getHikakuHrhnkyoup().compareTo(BizCurrency.valueOf(0,uiBean.getHikakuHrhnkyoup().getType())) > 0) {
                List<IT_Kariukekin> kariukekinLst = khHaraikataHenkouDao.getKariukekins1(kykKihon,
                    uiBean.getRyosyuYmd());

                if (kariukekinLst.size() == 0) {
                    throw new CommonBizAppException("仮受金TBLから払変要Ｐの入金経路が取得できません。証券番号＝"
                        + syoNo + "領収日＝" + uiBean.getRyosyuYmd());
                }

                IT_Kariukekin kariukekin = kariukekinLst.get(0);

                C_Nykkeiro nyKKeiro = kariukekin.getNykkeiro();

                BizDate oikomiDenYmd = null;
                SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);
                BizDate zengetumatuSimeYmd = setDenSimebi.exec(sysDate);

                BizDate hasseidenYmd = uiBean.getHasseidenYmd();

                if (BizDateUtil.compareYmd(zengetumatuSimeYmd, sysDate) != BizDateUtil.COMPARE_LESSER
                    && BizDateUtil.compareYm(hasseidenYmd.getBizDateYM(), sysDate.getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {

                    oikomiDenYmd = sysDate.addMonths(-1).getBizDateYM().getLastDay();

                    if (!oikomiDenYmd.isBusinessDay()) {
                        oikomiDenYmd = oikomiDenYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
                    }
                }
                else {
                    oikomiDenYmd = sysDate;
                }

                AnsyuuCommonSiwake ansyuuCommonSiwake = SWAKInjector.getInstance(AnsyuuCommonSiwake.class);
                AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);

                ansyuuCommonSiwakeInBean.setKinouId(functionId);
                ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.HOZEN);
                ansyuuCommonSiwakeInBean.setSyouhinCd(syukykSyouhn.getSyouhncd());
                ansyuuCommonSiwakeInBean.setSyouhnsdno(syukykSyouhn.getSyouhnsdno());
                ansyuuCommonSiwakeInBean.setDenYmd(sysDate);
                ansyuuCommonSiwakeInBean.setSyoriYmd(sysDate);
                ansyuuCommonSiwakeInBean.setKykYmd(syukykSyouhn.getKykymd());
                ansyuuCommonSiwakeInBean.setSyono(uiBean.getSyono());

                List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanList = new ArrayList<AnsyuuTaisyouGkBean>();
                AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
                AnsyuuTaisyouGkBean ansyuuTaisyouGkBean2 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
                AnsyuuTaisyouGkBean ansyuuTaisyouGkBean3 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

                ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
                ansyuuTaisyouGkBean1.setTaisyouGk(uiBean.getRsgaku());

                ansyuuTaisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
                ansyuuTaisyouGkBean2.setTaisyouGk(uiBean.getHikakuHrhnkyoup());
                ansyuuTaisyouGkBean2.setHrkkaisuu(uiBean.getVhrkihrkkaisuu());
                ansyuuTaisyouGkBean2.setJyutouStartYm(uiBean.getVhrkijkipjytym());
                ansyuuTaisyouGkBean2.setJyutouKaisuuY(0);
                ansyuuTaisyouGkBean2.setJyutouKaisuuM(uiBean.getHrhnkyoupzytm());

                ansyuuTaisyouGkBean3.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
                ansyuuTaisyouGkBean3.setTaisyouGk(uiBean.getRsgaku().subtract(uiBean.getHikakuHrhnkyoup()));

                ansyuuTaisyouGkBeanList.add(ansyuuTaisyouGkBean1);
                ansyuuTaisyouGkBeanList.add(ansyuuTaisyouGkBean2);
                ansyuuTaisyouGkBeanList.add(ansyuuTaisyouGkBean3);

                ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(ansyuuTaisyouGkBeanList);

                CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

                BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
                BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);

                bzDenpyouDataTourokuBean.setIbSyono(uiBean.getSyono());
                bzDenpyouDataTourokuBean.setIbHuridenatesakicd(commonSiwakeOutBean.getHuridenatesakiCd());
                bzDenpyouDataTourokuBean.setIbTantocd(commonSiwakeOutBean.getTantoCd());
                bzDenpyouDataTourokuBean.setIbDenymd(oikomiDenYmd);
                bzDenpyouDataTourokuBean.setIbTuukasyu(commonSiwakeOutBean.getTuukasyu());
                bzDenpyouDataTourokuBean.setIbHuridenskskbn(commonSiwakeOutBean.getHuridensksKbn());
                bzDenpyouDataTourokuBean.setIbDenhnknhoukbn(commonSiwakeOutBean.getDenhnknhouKbn());
                bzDenpyouDataTourokuBean.setIbDenshrhoukbn(commonSiwakeOutBean.getDenshrhouKbn());
                bzDenpyouDataTourokuBean.setIbSyoriymd(commonSiwakeOutBean.getSyoriYmd());
                bzDenpyouDataTourokuBean.setIbSyoricd(commonSiwakeOutBean.getSyoriCd());
                bzDenpyouDataTourokuBean.setIbSyorisosikicd(pKhozenCommonParam.getTmSosikiCd());
                bzDenpyouDataTourokuBean.setIbKyktuukasyu(commonSiwakeOutBean.getKyktuukaSyu());
                bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(userId);
                bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
                bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());
                bzDenpyouDataTourokuBean.setIbSyouhncd(syukykSyouhn.getSyouhncd());
                bzDenpyouDataTourokuBean.setIbSyouhnsdno(syukykSyouhn.getSyouhnsdno());

                List<IT_KhDenpyoData> khDenpyoDataList = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);

                for (IT_KhDenpyoData khDenpyoData : khDenpyoDataList) {
                    khHaraikataHenkouDao.insert(khDenpyoData);
                }

                BizDateYM jytYm = uiBean.getVhrkijkipjytym();
                BizDate hennyuYMD = BizDate.valueOf(uiBean.getHennyuYm(), 1).addMonths(-1);
                BizDateYM jyutouEndYM = hennyuYMD.getBizDateYM();
                List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = new ArrayList<>();
                kykSyouhnCommonParamLst.addAll(uiBean.getKykKihon().getKykSyouhns());
                List<KykSyouhnCommonParam> kykSyouhnRirekiList = new ArrayList<>();
                kykSyouhnRirekiList.addAll(hozenDomManager.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey(syoNo));

                if ((C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk()) &&
                    C_Hrkkaisuu.TUKI.eq(uiBean.getVhrkihrkkaisuu())) ||
                    C_TkiktbrisyuruiKbn.NONE.eq(uiBean.getVhrkitikiktbrijk())) {

                    if (uiBean.getIktwaribikikGk().compareTo(BizCurrency.valueOf(0,uiBean.getIktwaribikikGk().getType())) > 0) {

                        Integer maxRenNo = khHaraikataHenkouDao.getNyknJissekiRirekiMaxRenno(syoNo, jytYm);
                        int renNo = 0;

                        if (maxRenNo == null || maxRenNo == 0) {
                            renNo = 1;
                        }
                        else {
                            renNo = maxRenNo + 1;
                        }

                        IT_NyknJissekiRireki nyknJissekiRireki = khHaraikataHenkouDao.createNyknJissekiRireki(kykKihon);

                        nyknJissekiRireki.setJyutoustartym(jytYm);
                        nyknJissekiRireki.setRenno(renNo);
                        nyknJissekiRireki.setJyutouendym(jyutouEndYM);
                        nyknJissekiRireki.setRsgaku(uiBean.getHikakuHrhnkyoup());
                        nyknJissekiRireki.setRstuukasyu(uiBean.getRstuukasyu());
                        if (C_UmuKbn.ARI.eq(uiBean.getHrhnkyoupKnsnUmu())) {
                            nyknJissekiRireki.setRyosyukwsratekjymd(uiBean.getHrhnkyoupkwsratekjymd());
                            nyknJissekiRireki.setRyosyukwsrate(uiBean.getHrhnkyoupkwsrate());
                        }
                        nyknJissekiRireki.setHrkp(uiBean.getVhrkihrkp());
                        nyknJissekiRireki.setIktwaribikikgk(uiBean.getIktwaribikikGk());
                        nyknJissekiRireki.setNyksyoriymd(sysDate);
                        nyknJissekiRireki.setRyosyuymd(uiBean.getRyosyuYmd());
                        nyknJissekiRireki.setNykdenno(khDenpyoDataList.get(0).getDenrenno());
                        nyknJissekiRireki.setNykdenymd(oikomiDenYmd);
                        nyknJissekiRireki.setNykkeiro(nyKKeiro);
                        nyknJissekiRireki.setHrkkaisuu(uiBean.getVhrkihrkkaisuu());
                        nyknJissekiRireki.setJyutoukaisuum(uiBean.getHrhnkyoupzytm());
                        nyknJissekiRireki.setNyknaiyoukbn(C_NyknaiyouKbn.HARAIHENYOUP);
                        nyknJissekiRireki.setIktnyuukinnumu(C_UmuKbn.ARI);
                        nyknJissekiRireki.setHenkousikibetukey(oldHkSikibetuKey);
                        nyknJissekiRireki.setGyoumuKousinKinou(functionId);
                        nyknJissekiRireki.setGyoumuKousinsyaId(userId);
                        nyknJissekiRireki.setGyoumuKousinTime(sysTime);
                        nyknJissekiRireki.setTikiktbrisyuruikbn(uiBean.getVhrkitikiktbrijk());

                        BizPropertyInitializer.initialize(nyknJissekiRireki);

                        EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);

                        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey(oldHkSikibetuKey);
                        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(uiBean.getVhrkihrkkaisuu());
                        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
                        editKoujyonaiyouTbl.setNyknJskStartYm(jytYm);
                        editKoujyonaiyouTbl.setNyknJskEndYm(jyutouEndYM);
                        editKoujyonaiyouTbl.setNyknJskRenno(renNo);
                        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(uiBean.getRyosyuYmd());
                        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(0);
                        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(uiBean.getHrhnkyoupzytm());
                        if (C_UmuKbn.ARI.eq(uiBean.getHrhnkyoupKnsnUmu())) {
                            editKoujyonaiyouTbl.setNyknJskRysKwsrate(uiBean.getHrhnkyoupkwsrate());
                        }
                        else {
                            editKoujyonaiyouTbl.setNyknJskRysKwsrate(BizNumber.valueOf(0));
                        }
                        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamLst);
                        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(kykSyouhnRirekiList);
                        editKoujyonaiyouTbl.setYoupJytStartYm(jytYm);

                        editKoujyonaiyouTbl.exec(pKhozenCommonParam, syoNo, C_KjsymnytblhensyuusyoriKbn.YOUPHANEI, sysDate);

                        updateSikinIdouRireki(syukykSyouhn, khDenpyoDataList, nyknJissekiRireki, oldHokenryou);

                    }

                    if (uiBean.getIktwaribikikGk().compareTo(BizCurrency.valueOf(0,uiBean.getIktwaribikikGk().getType())) == 0) {

                        int hrHnkYouPZyTM = uiBean.getHrhnkyoupzytm();

                        for (int index = 0; index < hrHnkYouPZyTM; index++) {

                            Integer maxRenNo = khHaraikataHenkouDao.getNyknJissekiRirekiMaxRenno(syoNo, jytYm);

                            int renNo = 0;

                            if (maxRenNo == null || maxRenNo == 0) {
                                renNo = 1;
                            }
                            else {
                                renNo = maxRenNo + 1;
                            }

                            IT_NyknJissekiRireki nyknJissekiRireki = khHaraikataHenkouDao.createNyknJissekiRireki(kykKihon);

                            nyknJissekiRireki.setJyutoustartym(jytYm);
                            nyknJissekiRireki.setRenno(renNo);
                            nyknJissekiRireki.setJyutouendym(jytYm);
                            nyknJissekiRireki.setRsgaku(uiBean.getYenTukiHokenryou());
                            nyknJissekiRireki.setRstuukasyu(uiBean.getRstuukasyu());
                            if (C_UmuKbn.ARI.eq(uiBean.getHrhnkyoupKnsnUmu())) {
                                nyknJissekiRireki.setRyosyukwsratekjymd(uiBean.getHrhnkyoupkwsratekjymd());
                                nyknJissekiRireki.setRyosyukwsrate(uiBean.getHrhnkyoupkwsrate());
                            }
                            nyknJissekiRireki.setHrkp(uiBean.getVhrkihrkp());
                            nyknJissekiRireki.setNyksyoriymd(sysDate);
                            nyknJissekiRireki.setRyosyuymd(uiBean.getRyosyuYmd());
                            nyknJissekiRireki.setNykdenno(khDenpyoDataList.get(0).getDenrenno());
                            nyknJissekiRireki.setNykdenymd(oikomiDenYmd);
                            nyknJissekiRireki.setNykkeiro(nyKKeiro);
                            nyknJissekiRireki.setHrkkaisuu(uiBean.getVhrkihrkkaisuu());
                            nyknJissekiRireki.setJyutoukaisuum(1);
                            nyknJissekiRireki.setNyknaiyoukbn(C_NyknaiyouKbn.HARAIHENYOUP);
                            nyknJissekiRireki.setIktnyuukinnumu(C_UmuKbn.NONE);
                            nyknJissekiRireki.setHenkousikibetukey(oldHkSikibetuKey);
                            nyknJissekiRireki.setGyoumuKousinKinou(functionId);
                            nyknJissekiRireki.setGyoumuKousinsyaId(userId);
                            nyknJissekiRireki.setGyoumuKousinTime(sysTime);
                            nyknJissekiRireki.setTikiktbrisyuruikbn(uiBean.getVhrkitikiktbrijk());

                            BizPropertyInitializer.initialize(nyknJissekiRireki);

                            EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);

                            editKoujyonaiyouTbl.setHenmaeHenkousikibetukey(oldHkSikibetuKey);
                            editKoujyonaiyouTbl.setHenmaeHrkKaisuu(uiBean.getVhrkihrkkaisuu());
                            editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.NONE);
                            editKoujyonaiyouTbl.setNyknJskStartYm(jytYm);
                            editKoujyonaiyouTbl.setNyknJskEndYm(jytYm);
                            editKoujyonaiyouTbl.setNyknJskRenno(renNo);
                            editKoujyonaiyouTbl.setNyknJskRyosyuYmd(uiBean.getRyosyuYmd());
                            editKoujyonaiyouTbl.setNyknJskJytKaisuuY(0);
                            editKoujyonaiyouTbl.setNyknJskJytKaisuuM(1);
                            if (C_UmuKbn.ARI.eq(uiBean.getHrhnkyoupKnsnUmu())) {
                                editKoujyonaiyouTbl.setNyknJskRysKwsrate(uiBean.getHrhnkyoupkwsrate());
                            }
                            else {
                                editKoujyonaiyouTbl.setNyknJskRysKwsrate(BizNumber.valueOf(0));
                            }
                            editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamLst);
                            editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(kykSyouhnRirekiList);
                            editKoujyonaiyouTbl.setYoupJytStartYm(uiBean.getVhrkijkipjytym());

                            editKoujyonaiyouTbl.exec(pKhozenCommonParam, syoNo, C_KjsymnytblhensyuusyoriKbn.YOUPHANEI,
                                sysDate);

                            updateSikinIdouRireki(syukykSyouhn, khDenpyoDataList, nyknJissekiRireki, oldHokenryou);

                            jytYm = jytYm.addMonths(1);

                        }
                    }
                }
                if (C_Hrkkaisuu.HALFY.eq(uiBean.getVhrkihrkkaisuu()) ||
                    C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getVhrkitikiktbrijk())) {

                    Integer maxRenNo = khHaraikataHenkouDao.getNyknJissekiRirekiMaxRenno(syoNo,jytYm);

                    int renNo = 0;

                    if (maxRenNo == null || maxRenNo == 0) {
                        renNo = 1;
                    }
                    else {
                        renNo = maxRenNo + 1;
                    }

                    IT_NyknJissekiRireki nyknJissekiRireki = khHaraikataHenkouDao.createNyknJissekiRireki(kykKihon);

                    C_UmuKbn ikkatuNykUmu = C_UmuKbn.NONE;

                    if(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getVhrkitikiktbrijk())){
                        ikkatuNykUmu = C_UmuKbn.ARI;
                    }

                    nyknJissekiRireki.setJyutoustartym(jytYm);
                    nyknJissekiRireki.setRenno(renNo);
                    nyknJissekiRireki.setJyutouendym(jyutouEndYM);
                    nyknJissekiRireki.setRsgaku(uiBean.getHikakuHrhnkyoup());
                    nyknJissekiRireki.setRstuukasyu(uiBean.getRstuukasyu());
                    if (C_UmuKbn.ARI.eq(uiBean.getHrhnkyoupKnsnUmu())) {
                        nyknJissekiRireki.setRyosyukwsratekjymd(uiBean.getHrhnkyoupkwsratekjymd());
                        nyknJissekiRireki.setRyosyukwsrate(uiBean.getHrhnkyoupkwsrate());
                    }
                    nyknJissekiRireki.setHrkp(uiBean.getVhrkihrkp());
                    nyknJissekiRireki.setIktwaribikikgk(uiBean.getIktwaribikikGk());
                    nyknJissekiRireki.setNyksyoriymd(sysDate);
                    nyknJissekiRireki.setRyosyuymd(uiBean.getRyosyuYmd());
                    nyknJissekiRireki.setNykdenno(khDenpyoDataList.get(0).getDenrenno());
                    nyknJissekiRireki.setNykdenymd(oikomiDenYmd);
                    nyknJissekiRireki.setNykkeiro(nyKKeiro);
                    nyknJissekiRireki.setHrkkaisuu(uiBean.getVhrkihrkkaisuu());
                    nyknJissekiRireki.setJyutoukaisuum(6);
                    nyknJissekiRireki.setNyknaiyoukbn(C_NyknaiyouKbn.HARAIHENYOUP);
                    nyknJissekiRireki.setIktnyuukinnumu(ikkatuNykUmu);
                    nyknJissekiRireki.setHenkousikibetukey(oldHkSikibetuKey);
                    nyknJissekiRireki.setGyoumuKousinKinou(functionId);
                    nyknJissekiRireki.setGyoumuKousinsyaId(userId);
                    nyknJissekiRireki.setGyoumuKousinTime(sysTime);
                    nyknJissekiRireki.setTikiktbrisyuruikbn(uiBean.getVhrkitikiktbrijk());

                    BizPropertyInitializer.initialize(nyknJissekiRireki);

                    EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);

                    editKoujyonaiyouTbl.setHenmaeHenkousikibetukey(oldHkSikibetuKey);
                    editKoujyonaiyouTbl.setHenmaeHrkKaisuu(uiBean.getVhrkihrkkaisuu());
                    editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.NONE);
                    editKoujyonaiyouTbl.setNyknJskStartYm(jytYm);
                    editKoujyonaiyouTbl.setNyknJskEndYm(jyutouEndYM);
                    editKoujyonaiyouTbl.setNyknJskRenno(renNo);
                    editKoujyonaiyouTbl.setNyknJskRyosyuYmd(uiBean.getRyosyuYmd());
                    editKoujyonaiyouTbl.setNyknJskJytKaisuuY(0);
                    editKoujyonaiyouTbl.setNyknJskJytKaisuuM(6);
                    if (C_UmuKbn.ARI.eq(uiBean.getHrhnkyoupKnsnUmu())) {
                        editKoujyonaiyouTbl.setNyknJskRysKwsrate(uiBean.getHrhnkyoupkwsrate());
                    }
                    else {
                        editKoujyonaiyouTbl.setNyknJskRysKwsrate(BizNumber.valueOf(0));
                    }
                    editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamLst);
                    editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(kykSyouhnRirekiList);
                    editKoujyonaiyouTbl.setYoupJytStartYm(uiBean.getVhrkijkipjytym());

                    editKoujyonaiyouTbl.exec(pKhozenCommonParam, syoNo, C_KjsymnytblhensyuusyoriKbn.YOUPHANEI, sysDate);

                    updateSikinIdouRireki(syukykSyouhn, khDenpyoDataList, nyknJissekiRireki, oldHokenryou);
                }

                kariukekinLst = khHaraikataHenkouDao.getKariukekins2(kykKihon);

                for (IT_Kariukekin kariukekinIte : kariukekinLst) {
                    kariukekinIte.setSeisandenymd(oikomiDenYmd);
                    kariukekinIte.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
                    kariukekinIte.setGyoumuKousinKinou(functionId);
                    kariukekinIte.setGyoumuKousinsyaId(userId);
                    kariukekinIte.setGyoumuKousinTime(sysTime);
                }

                if (uiBean.getRsgaku().compareTo(uiBean.getHikakuHrhnkyoup()) > 0) {

                    maxKrkNo = khHaraikataHenkouDao.getKariukekinMaxKrkno(syoNo) + 1;

                    kariukekin = khHaraikataHenkouDao.createKariukekin(kykKihon);

                    kariukekin.setKrkno(maxKrkNo);
                    kariukekin.setKrkkeijyoymd(sysDate);
                    kariukekin.setKrkgk(uiBean.getRsgaku().subtract(uiBean.getHikakuHrhnkyoup()));
                    kariukekin.setHasseidenymd(oikomiDenYmd);
                    kariukekin.setKrkriyuukbn(C_KrkriyuuKbn.KAZYOUNYKN);
                    kariukekin.setNyknaiyoukbn(C_NyknaiyouKbn.HARAIHENYOUP);
                    kariukekin.setNykkeiro(C_Nykkeiro.OTHER);
                    kariukekin.setRyosyuymd(uiBean.getRyosyuYmd());
                    kariukekin.setHrkkaisuu(hrkKaisuu);
                    kariukekin.setTikiktbrisyuruikbn(tkiktbrisyuruiKbn);
                    kariukekin.setGyoumuKousinKinou(functionId);
                    kariukekin.setGyoumuKousinsyaId(userId);
                    kariukekin.setGyoumuKousinTime(sysTime);

                    BizPropertyInitializer.initialize(kariukekin);
                }


                ansyuKihon.setJkipjytym(uiBean.getHennyuYm());
                ansyuKihon.setGyoumuKousinKinou(functionId);
                ansyuKihon.setGyoumuKousinsyaId(userId);
                ansyuKihon.setGyoumuKousinTime(sysTime);

                makeEditDairitenTesuuryou(pKhozenCommonParam, pIT_BAK_KykKihon);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHrkkeirohnkumu())) {

                if (C_Hrkkeiro.CREDIT.eq(oldHrkKeiro)) {

                    kykKihon.setCreditCardInfo(null);

                    khHaraikataHenkouDao.flush();
                }

                if (C_Hrkkeiro.CREDIT.eq(newHrkKeiro)) {

                    SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector
                        .getInstance(SetCreditUriageSeikyuubi.class);

                    setCreditUriageSeikyuubi.exec(sysDate);

                    BizDateYM crediTyuukoukakYm = setCreditUriageSeikyuubi.getJikaiUrsktysytbi().getBizDateYM();

                    IT_CreditCardInfo creditCardInfo = kykKihon.createCreditCardInfo();

                    creditCardInfo.setCreditkessaiyouno(uiBean.getSaibanCreditKessaiyouNo());
                    creditCardInfo.setCredityuukoukakym(crediTyuukoukakYm);
                    creditCardInfo.setCredityuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
                    creditCardInfo.setGyoumuKousinKinou(functionId);
                    creditCardInfo.setGyoumuKousinsyaId(userId);
                    creditCardInfo.setGyoumuKousinTime(sysTime);

                    BizPropertyInitializer.initialize(creditCardInfo);
                }

                if (!kouzaHenkouFlg) {

                    if (C_Hrkkeiro.KOUHURI.eq(oldHrkKeiro)) {

                        khHaraikataHenkouDao.setKouza(kykKihon, null);

                        khHaraikataHenkouDao.flush();
                    }

                    if (C_Hrkkeiro.KOUHURI.eq(newHrkKeiro)) {

                        setKouzaTbl(kykKihon);
                    }

                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHrkkaisuuhnkumu()) ||
                C_UmuKbn.ARI.eq(uiBean.getTikiktbrisyuruihnkumu()) ||
                C_Hrkkeiro.CREDIT.eq(newHrkKeiro) ||
                !uiBean.getVhrkihrkkeiro().eq(hrkKeiro)) {
                long yykIdouUktkKensu = khHaraikataHenkouDao.getYykIdouUktkCount(syoNo, functionId);

                if (yykIdouUktkKensu > 0) {
                    List<IT_YykIdouUktk> yykIdouUktkLst = khHaraikataHenkouDao.getYykIdouUktks(
                        kykKihon,C_YykidousyoriKbn.UKE);

                    for (IT_YykIdouUktk yykIdouUktk : yykIdouUktkLst) {
                        yykIdouUktk.setYykidousyorikbn(C_YykidousyoriKbn.TORIKESI);
                        yykIdouUktk.setGyoumuKousinKinou(functionId);
                        yykIdouUktk.setGyoumuKousinsyaId(userId);
                        yykIdouUktk.setGyoumuKousinTime(sysTime);
                    }
                }
            }

            khHaraikataHenkouDao.update(ansyuKihon);
        }

        if (dattaiKaisyouFlg) {
            khHaraikataHenkouDao.setDattaiUktk(ansyuKihon, null);
        }

        String youkyuuno = "";

        if (kouzaHenkouFlg ||
            (!C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn()) &&
                !C_Hrkkeiro.BLNK.eq(newHrkKeiro) && !newHrkKeiro.eq(oldHrkKeiro)) ||
                !oldKykjyoutai.eq(syukykSyouhn.getKykjyoutai())) {

            PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);
            pALKykNaiyouKousin.exec(uiBean.getKykKihon());
            youkyuuno = pALKykNaiyouKousin.getYoukyuuno();
        }

        C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

        if (C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn())) {

            if (kouzaHenkouFlg) {

                syoriKbn = C_SyoriKbn.KEIROHENKOUYYKIDOUUKE;
            }
            else {

                syoriKbn = C_SyoriKbn.YYKIDOUUKE;
            }
        }
        else {

            SetHrhnSyoriKbn setHrhnSyoriKbn = SWAKInjector.getInstance(SetHrhnSyoriKbn.class);

            syoriKbn = setHrhnSyoriKbn.exec(uiBean.getHrkkaisuuhnkumu(), uiBean.getTikiktbrisyuruihnkumu(),
                oldHrkKeiro, newHrkKeiro);
        }

        IT_KhTtdkRireki khTtdkRireki = khHaraikataHenkouDao.createKhTtdkRireki(kykKihon);
        khTtdkRireki.setHenkousikibetukey(sikibetuKey);

        makeTtdkRireki(pKhozenCommonParam, syoriKbn, youkyuuno);
    }

    private void makeEditDairitenTesuuryou(KhozenCommonParam pKhozenCommonParam,
        IT_BAK_KykKihon pIT_BAK_KykKihon) {

        EditDairitenTesuuryouTbl editDairitenTesuuryouTbl = SWAKInjector.getInstance(EditDairitenTesuuryouTbl.class);

        editDairitenTesuuryouTbl.exec(pKhozenCommonParam,
            uiBean.getSyono(),
            C_TsrysyoriKbn.HRIKAIHEN,
            uiBean.getVhrkijkipjytym(),
            0,
            uiBean.getHrhnkyoupzytm(),
            BizCurrency.valueOf(0),
            uiBean.getHrhnkyoup(),
            uiBean.getRyosyuYmd(),
            pIT_BAK_KykKihon);
    }

    private void makeTtdkRireki(KhozenCommonParam pKhozenCommonParam, C_SyoriKbn pSyoriKbn, String pYoukyuuNo) {

        EditTtdkRirekiTblParam param = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        param.setCommonParam(pKhozenCommonParam);
        param.setSyoNo(uiBean.getSyono());
        param.setSyoriYmd(sysDate);
        param.setSysTime(sysTime);
        param.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        param.setSyoriKbn(pSyoriKbn);
        param.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        param.setYoukyuuNo(pYoukyuuNo);

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        editTtdkRirekiTbl.exec(param);
    }

    private void makeTyouhyouSks(KhozenCommonParam pKhozenCommonParam) {

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(
            pKhozenCommonParam.getTmSosikiCd());
        IT_KykSya kykSya = uiBean.getKykKihon().getKykSya();
        List<ReportServicesBean> reportServicesBeanlist = Lists.newArrayList();

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);
        KhHrhnTtdkAnnaiBean khHrhnTtdkAnnaiBean = SWAKInjector.getInstance(KhHrhnTtdkAnnaiBean.class);

        String[] editAdr = ViewReport.editAdrDisp(
            24, kykSya.getTsinadr1kj(), kykSya.getTsinadr2kj(), kykSya.getTsinadr3kj());

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(DefaultDateFormatter.formatYMDKanji(sysDate));
        bzKokyakuAtesakiBean.setIrShsyno(kykSya.getTsinyno());
        bzKokyakuAtesakiBean.setIrShadr1kj(editAdr[0]);
        bzKokyakuAtesakiBean.setIrShadr2kj(editAdr[1]);
        bzKokyakuAtesakiBean.setIrShadr3kj(editAdr[2]);
        bzKokyakuAtesakiBean.setIrShsnmkj(kykSya.getKyknmkj());
        bzKokyakuAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());
        bzKokyakuAtesakiBean.setIrToiawasesosiki(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
        bzKokyakuAtesakiBean.setIrToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
        bzKokyakuAtesakiBean.setIrToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
        bzKokyakuAtesakiBean.setIrToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());

        khHrhnTtdkAnnaiBean.setIrSyono(uiBean.getSyono());
        khHrhnTtdkAnnaiBean.setIrKyknmkj(kykSya.getKyknmkj());
        khHrhnTtdkAnnaiBean.setIrHrkkeiro(uiBean.getNewhrkkeiro());
        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())) {
            khHrhnTtdkAnnaiBean.setIrTeisyutusyorui("生命保険料口座振替依頼書兼自動払込利用申込書");
        }
        else if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {
            khHrhnTtdkAnnaiBean.setIrTeisyutusyorui("保険料クレジットカード扱い申込書");
        }
        else {
            khHrhnTtdkAnnaiBean.setIrTeisyutusyorui("生命保険料払込回数変更申込書");
        }

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
            pKhozenCommonParam.getCategoryId(),
            pKhozenCommonParam.getFunctionId(),
            C_SyoruiCdKbn.AS_HRHNTTDKANNAI);

        reportServicesBean.setKensakuKeys(uiBean.getSyono());
        reportServicesBean.addParamObjects(new Object[]{khHrhnTtdkAnnaiBean, bzKokyakuAtesakiBean});

        reportServicesBeanlist.add(reportServicesBean);

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;

        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())) {
            syoruiCdKbn = C_SyoruiCdKbn.AS_PKZHRIKEIRAI;
        }
        else if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {
            syoruiCdKbn = C_SyoruiCdKbn.AS_CREDITCARDMOS;
        }
        else {
            syoruiCdKbn = C_SyoruiCdKbn.AS_PHRKKAISUUHENKOUMOS;
        }

        AM_SyoruiZokusei syoruiZokusei = baseDomManager.getSyoruiZokusei(syoruiCdKbn);
        String hozonKkn = ViewReport.getHozonKknTani(syoruiZokusei);

        boolean hanteiKekka = BzHanteiSosikiUtil.isCallcenterKeySosikicd(pKhozenCommonParam.getTmSosikiCd());

        if (C_SyoruiCdKbn.AS_PKZHRIKEIRAI.eq(syoruiCdKbn)) {

            KhPkzhrikeIraisyoBean khPkzhrikeIraisyoBean = SWAKInjector.getInstance(KhPkzhrikeIraisyoBean.class);

            khPkzhrikeIraisyoBean.setIrSyono(uiBean.getSyono());
            khPkzhrikeIraisyoBean.setIrHrkkaisuu(uiBean.getNewhrkkaisuu());
            khPkzhrikeIraisyoBean.setIrTikiktbrisyuruikbn(uiBean.getNewtikiktbrisyuruikbn());
            khPkzhrikeIraisyoBean.setIrToritsugisyasyozokunm(pKhozenCommonParam.getTmSosikiNm());
            khPkzhrikeIraisyoBean.setIrTyouhyousakuseiymd(DefaultDateFormatter.formatYMDKanji(sysDate));
            khPkzhrikeIraisyoBean.setIrHozonkkn(hozonKkn);

            if (!C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk())) {
                khPkzhrikeIraisyoBean.setIrTikiktbriTaisyoukbn(C_TaisyouKbn.TAISYOU);
            }
            else {
                khPkzhrikeIraisyoBean.setIrTikiktbriTaisyoukbn(C_TaisyouKbn.HITAISYOU);
            }

            if (!hanteiKekka) {
                khPkzhrikeIraisyoBean.setIrToritsugisyakjncd(pKhozenCommonParam.getUserID());
                khPkzhrikeIraisyoBean.setIrToritsugisyanm(pKhozenCommonParam.getUserNm());

            }

            ReportServicesBean pkzhrikeiraiReportServicesBean = createReport.createNewReportServiceBean(
                IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
                pKhozenCommonParam.getCategoryId(),
                pKhozenCommonParam.getFunctionId(),
                C_SyoruiCdKbn.AS_PKZHRIKEIRAI);

            pkzhrikeiraiReportServicesBean.setKensakuKeys(uiBean.getSyono());
            pkzhrikeiraiReportServicesBean.addParamObjects(khPkzhrikeIraisyoBean);

            reportServicesBeanlist.add(pkzhrikeiraiReportServicesBean);
        }
        else if (C_SyoruiCdKbn.AS_CREDITCARDMOS.eq(syoruiCdKbn)) {

            KhCreditcardMosBean khCreditcardMosBean = SWAKInjector.getInstance(KhCreditcardMosBean.class);

            khCreditcardMosBean.setIrSyono(uiBean.getSyono());
            khCreditcardMosBean.setIrCreditkessaiyouno(uiBean.getSaibanCreditKessaiyouNo());
            khCreditcardMosBean.setIrKyksyanmkn(kykSya.getKyknmkn());
            khCreditcardMosBean.setIrKyksyatel(kykSya.getTsintelno());
            khCreditcardMosBean.setIrToritsugisyasyozokunm(pKhozenCommonParam.getTmSosikiNm());

            if (!hanteiKekka) {
                khCreditcardMosBean.setIrToritsugisyakjncd(pKhozenCommonParam.getUserID());
                khCreditcardMosBean.setIrToritsugisyanm(pKhozenCommonParam.getUserNm());
            }
            khCreditcardMosBean.setIrTyouhyousakuseiymd(DefaultDateFormatter.formatYMDKanji(sysDate));
            khCreditcardMosBean.setIrHozonkkn(hozonKkn);

            ReportServicesBean creditcardMosReportServicesBean = createReport.createNewReportServiceBean(
                IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
                pKhozenCommonParam.getCategoryId(),
                pKhozenCommonParam.getFunctionId(),
                C_SyoruiCdKbn.AS_CREDITCARDMOS);

            creditcardMosReportServicesBean.setKensakuKeys(uiBean.getSyono());
            creditcardMosReportServicesBean.addParamObjects(khCreditcardMosBean);

            reportServicesBeanlist.add(creditcardMosReportServicesBean);
        }
        else {
            KhPHrkkaisuuHenkouMosBean khPHrkkaisuuHenkouMosBean = SWAKInjector.getInstance(KhPHrkkaisuuHenkouMosBean.class);

            khPHrkkaisuuHenkouMosBean.setIrSyono(uiBean.getSyono());
            khPHrkkaisuuHenkouMosBean.setIrHrkkaisuu(uiBean.getNewhrkkaisuu());
            khPHrkkaisuuHenkouMosBean.setIrTikiktbrisyuruikbn(uiBean.getNewtikiktbrisyuruikbn());
            if (!C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk())) {
                khPHrkkaisuuHenkouMosBean.setIrTikiktbriTaisyoukbn(C_TaisyouKbn.TAISYOU);
            }
            else {
                khPHrkkaisuuHenkouMosBean.setIrTikiktbriTaisyoukbn(C_TaisyouKbn.HITAISYOU);
            }
            khPHrkkaisuuHenkouMosBean.setIrToritsugisyasyozokunm(pKhozenCommonParam.getTmSosikiNm());

            if (!hanteiKekka) {
                khPHrkkaisuuHenkouMosBean.setIrToritsugisyakjncd(pKhozenCommonParam.getUserID());
                khPHrkkaisuuHenkouMosBean.setIrToritsugisyanm(pKhozenCommonParam.getUserNm());
            }
            khPHrkkaisuuHenkouMosBean.setIrTyouhyousakuseiymd(DefaultDateFormatter.formatYMDKanji(sysDate));
            khPHrkkaisuuHenkouMosBean.setIrHozonkkn(hozonKkn);

            ReportServicesBean hrikaihenReportServicesBean = createReport.createNewReportServiceBean(
                IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
                pKhozenCommonParam.getCategoryId(),
                pKhozenCommonParam.getFunctionId(),
                C_SyoruiCdKbn.AS_PHRKKAISUUHENKOUMOS);

            hrikaihenReportServicesBean.setKensakuKeys(uiBean.getSyono());
            hrikaihenReportServicesBean.addParamObjects(khPHrkkaisuuHenkouMosBean);

            reportServicesBeanlist.add(hrikaihenReportServicesBean);
        }

        String tyouhyouJoinKey = createReport.execNoCommit(reportServicesBeanlist);

        uiBean.setTyouhyouKey(tyouhyouJoinKey);
        uiBean.setTyouhyoumukbn(C_UmuKbn.ARI);
    }

    private void makeTyouhyou(KhozenCommonParam pKhozenCommonParam) {

        List<ReportServicesBean> reportServicesBeanlist = Lists.newArrayList();

        if (!C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn()) ||
            (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro()) && C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro()))) {

            EditHrhnKanryoTuutiParam editHrhnKanryoTuutiParam = SWAKInjector.getInstance(EditHrhnKanryoTuutiParam.class);
            editHrhnKanryoTuutiParam.setHennyuym(uiBean.getHennyuYm());
            editHrhnKanryoTuutiParam.setJkipJytym(uiBean.getVhrkijkipjytym());
            editHrhnKanryoTuutiParam.setHrkkeiroHnkumu(uiBean.getHrkkeirohnkumu());
            editHrhnKanryoTuutiParam.setHrkkaisuuHnkumu(uiBean.getHrkkaisuuhnkumu());
            editHrhnKanryoTuutiParam.setTikiktbrisyuruihnkumu(uiBean.getTikiktbrisyuruihnkumu());
            if (C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn())) {
                editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.ARI);
            }
            else {
                editHrhnKanryoTuutiParam.setKaisuuhnkYoyakuUmu(C_UmuKbn.NONE);
            }

            if (C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk())) {
                if (C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn())) {
                    editHrhnKanryoTuutiParam.setHrkp(uiBean.getVhrkihrkp());
                }
                else {
                    editHrhnKanryoTuutiParam.setHrkp(uiBean.getNewhrkp());
                }
            }
            else {
                if (C_YykidouuktkKbn.TAISYOU.eq(uiBean.getYykidouuktkkbn())) {
                    editHrhnKanryoTuutiParam.setHrkp(uiBean.getOldTikiktbrihrkp());
                }
                else {
                    editHrhnKanryoTuutiParam.setHrkp(uiBean.getNewtikiktbrihrkp());
                }
            }

            editHrhnKanryoTuutiParam.setHassouKbn(C_HassouKbn.TYOKUSOU);
            editHrhnKanryoTuutiParam.setCardBrandKbn(uiBean.getCardBrandKbn());
            editHrhnKanryoTuutiParam.setCreditKaiinnoSimo4(uiBean.getCreditKaiinnoSimo4keta());
            editHrhnKanryoTuutiParam.setHrkkeiro(uiBean.getVhrkihrkkeiro());

            EditHrhnKanryoTuuti editHrhnKanryoTuuti = SWAKInjector.getInstance(EditHrhnKanryoTuuti.class);
            IT_HrhnTtdkKan newHrhnTtdkKan = editHrhnKanryoTuuti.editTBL(
                pKhozenCommonParam, uiBean.getKykKihon(), editHrhnKanryoTuutiParam, BizDate.getSysDate());

            if (C_KanryotuutioutKbn.PDF.eq(uiBean.getKanryotuutioutkbn())) {
                ReportServicesBean reportServicesBean = editHrhnKanryoTuuti.editBean(newHrhnTtdkKan, BizDate.getSysDate());
                reportServicesBeanlist.add(reportServicesBean);

                uiBean.getKykKihon().getHrhnTtdkKans().remove(newHrhnTtdkKan);

            }
        }

        if (C_YouhiKbn.YOU.eq(uiBean.getRsgakuHikakuYouhiKbn()) &&
            uiBean.getHikakuHrhnkyoup().compareTo(BizCurrency.valueOf(0,uiBean.getHikakuHrhnkyoup().getType())) > 0 &&
            uiBean.getHikakuHrhnkyoup().compareTo(uiBean.getRsgaku()) < 0) {

            List<String> jimuRenrakuhyouList = Lists.newArrayList();
            String kariUkeKin = BizUtil.comma(String.valueOf(uiBean.getRsgaku().subtract(uiBean.getHikakuHrhnkyoup())));
            String ryosyuYmd = DefaultDateFormatter.formatYMDKanji(uiBean.getRyosyuYmd());

            jimuRenrakuhyouList.add("仮受金に計上しました");
            jimuRenrakuhyouList.add("");
            jimuRenrakuhyouList.add("仮受番号／" + maxKrkNo);
            jimuRenrakuhyouList.add("仮受理由区分／" + C_KrkriyuuKbn.KAZYOUNYKN.getContent());
            jimuRenrakuhyouList.add("払込回数／" + uiBean.getKykKihon().getHrkkaisuu().getContent());
            if (!C_TkiktbrisyuruiKbn.BLNK.eq(uiBean.getVhrkitikiktbrijk())) {
                jimuRenrakuhyouList.add("定期一括払種類区分／" + uiBean.getKykKihon().getTikiktbrisyuruikbn().getContent());
            }
            jimuRenrakuhyouList.add( "入金経路／" + C_Nykkeiro.getContentByValue(C_Nykkeiro.PATTERN_DISP, C_Nykkeiro.OTHER.getValue()));
            jimuRenrakuhyouList.add("入金内容区分／" + C_NyknaiyouKbn.HARAIHENYOUP.getContent());
            jimuRenrakuhyouList.add("充当年月／");
            jimuRenrakuhyouList.add("充当回数／");
            jimuRenrakuhyouList.add( "仮受金額／" + kariUkeKin + "円");
            jimuRenrakuhyouList.add( "領収日／" + ryosyuYmd);

            EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam = SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);
            editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuRenrakuhyouList);

            EditJimuRenrakusyuunou dditJimuRenrakusyuunou = SWAKInjector.getInstance(EditJimuRenrakusyuunou.class);

            ReportServicesBean reportServicesBean = dditJimuRenrakusyuunou.exec(pKhozenCommonParam, uiBean.getSyono(),
                C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU,editJimuRenrakusyuunouParam, sysDate);

            reportServicesBeanlist.add(reportServicesBean);
        }

        if (reportServicesBeanlist.size() > 0) {
            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            String tyouhyouJoinKey = createReport.execNoCommit(reportServicesBeanlist);

            uiBean.setTyouhyouKey(tyouhyouJoinKey);
            uiBean.setTyouhyoumukbn(C_UmuKbn.ARI);
        }
    }

    private void doJikouteikanri(KhozenCommonParam pKhozenCommonParam) {

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())){

            CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

            C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhozenCommonParam, uiBean);

            if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
            }

            BzProcessCreateInBean bzProcessCreateInBean = SWAKInjector.getInstance(BzProcessCreateInBean.class);
            bzProcessCreateInBean.setSyoNo(uiBean.getSyono());
            bzProcessCreateInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
            bzProcessCreateInBean.setOyaKouteiKanriId(null);
            bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(null);

            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
            BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

            if (C_KouteiSakuseiKekkaKbn.FAILURE.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0008));
            }

            uiBean.getBzWorkflowInfo().setKouteiKanriId(bzProcessCreateOutBean.getKouteiKanriId());

            BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
            bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo()
                .getJimuTetuzukiCd());

            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
            bzForceTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo()
                .getJimuTetuzukiCd(),
                C_KhkinouModeIdKbn.INPUT.getValue(), bzCommonLockProcess.getKouteiLockKey());

            if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {
                uiBean.setAuthorijkKbn(C_AuthorijkKbn.IRAITYUU);
            }
        }

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);
        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);
        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");
        khRuleBean.setKyuukouzaAnnaiKbn(uiBean.getKyuukouzaannaikbn());
        khRuleBean.setAuthorijkKbn(uiBean.getAuthorijkKbn());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo()
            .getJimuTetuzukiCd(), bzCommonLockProcess.getKouteiLockKey(), uiBean.getSyanaicommentkh(), khRuleBean);

        bzCommonLockProcess.unlockProcess();
    }

    private void workTableUpdate() {
        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
            khHaraikataHenkouDao.delete(uiBean.getKhHaraikataHenkouWk());

            if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {

                IT_HrhnCreditCardTouroku hrhnCreditCardTouroku = hozenDomManager.getHrhnCreditCardTouroku(uiBean
                    .getSaibanCreditKessaiyouNo());

                hozenDomManager.delete(hrhnCreditCardTouroku);


                IT_CardTourokuMati cardTourokuMati = hozenDomManager.getCardTourokuMati(uiBean.getBzWorkflowInfo()
                    .getKouteiKanriId());

                if(cardTourokuMati != null){
                    hozenDomManager.delete(cardTourokuMati);
                }

            }
        }
        else{
            String wkBankcd = "";
            String wkSitencd = "";
            C_YokinKbn wkYokinkbn = C_YokinKbn.BLNK;
            String wkKouzano = "";
            C_KzkykdouKbn wkKzkykdoukbn = C_KzkykdouKbn.BLNK;
            String wkKzmeiginmkn = "";
            C_KyuukouzaAnnaiKbn wkKyuukouzaannaikbn = C_KyuukouzaAnnaiKbn.BLNK;
            C_YykidouuktkKbn wkYykidouuktkkbn = C_YykidouuktkKbn.BLNK;

            if (C_Hrkkeiro.KOUHURI.eq(uiBean.getNewhrkkeiro())) {
                wkBankcd = uiBean.getBankcd();
                wkSitencd = uiBean.getSitencd();
                wkYokinkbn = uiBean.getYokinkbn();
                wkKouzano = uiBean.getKouzano();
                wkKzkykdoukbn = uiBean.getKzkykdoukbn();
                if (C_KzkykdouKbn.DOUITU.eq(wkKzkykdoukbn)) {
                    wkKzmeiginmkn = "";
                } else {
                    wkKzmeiginmkn = uiBean.getKzmeiginmkn();
                }
                wkKyuukouzaannaikbn = uiBean.getKyuukouzaannaikbn();
            }

            if (C_UmuKbn.ARI.eq(uiBean.getYykidouuktkdispumu())) {
                wkYykidouuktkkbn = uiBean.getYykidouuktkkbn();
            }

            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

                if (C_Hrkkeiro.CREDIT.eq(uiBean.getNewhrkkeiro())) {

                    SaibanCreditKessaiyouNo saibanCreditKessaiyouNo = SWAKInjector
                        .getInstance(SaibanCreditKessaiyouNo.class);

                    uiBean.setSaibanCreditKessaiyouNo(saibanCreditKessaiyouNo.exec(C_CreditCardKeySyuruiKbn.SYONO,
                        uiBean.getSyono()));

                    CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu = SWAKInjector
                        .getInstance(CreditKessaiyouNoHensyuu.class);

                    uiBean.setDispsaibancreditkessaiyouno(creditKessaiyouNoHensyuu.exec(uiBean
                        .getSaibanCreditKessaiyouNo()));

                    IT_HrhnCreditCardTouroku hrhnCreditCardTouroku = new IT_HrhnCreditCardTouroku();

                    hrhnCreditCardTouroku.setCreditkessaiyouno(uiBean.getSaibanCreditKessaiyouNo());
                    hrhnCreditCardTouroku.setSyono(uiBean.getSyono());
                    hrhnCreditCardTouroku.setAuthorijkkbn(C_AuthorijkKbn.IRAITYUU);
                    hrhnCreditCardTouroku.setGyoumuKousinKinou(functionId);
                    hrhnCreditCardTouroku.setGyoumuKousinsyaId(userId);
                    hrhnCreditCardTouroku.setGyoumuKousinTime(sysTime);

                    BizPropertyInitializer.initialize(hrhnCreditCardTouroku);

                    hozenDomManager.insert(hrhnCreditCardTouroku);

                    IT_CardTourokuMati cardTourokuMati = new IT_CardTourokuMati();

                    cardTourokuMati.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                    cardTourokuMati.setSyono(uiBean.getSyono());
                    cardTourokuMati.setCreditkessaiyouno(uiBean.getSaibanCreditKessaiyouNo());
                    cardTourokuMati.setSyorizumiflg(C_Syorizumiflg.MISYORI);
                    cardTourokuMati.setGyoumuKousinKinou(functionId);
                    cardTourokuMati.setGyoumuKousinsyaId(userId);
                    cardTourokuMati.setGyoumuKousinTime(sysTime);

                    hozenDomManager.insert(cardTourokuMati);

                }

                IW_KhHaraikataHenkouWk khHaraikataHenkouWk = new IW_KhHaraikataHenkouWk();
                khHaraikataHenkouWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                khHaraikataHenkouWk.setSyono(uiBean.getSyono());
                khHaraikataHenkouWk.setNewhrkkeiro(uiBean.getNewhrkkeiro());
                khHaraikataHenkouWk.setNewhrkkaisuu(uiBean.getNewhrkkaisuu());
                khHaraikataHenkouWk.setNewtikiktbrisyuruikbn(uiBean.getNewtikiktbrisyuruikbn());
                khHaraikataHenkouWk.setHenkouyoteiym(uiBean.getHenkouyoteiym());
                khHaraikataHenkouWk.setBankcd(wkBankcd);
                khHaraikataHenkouWk.setSitencd(wkSitencd);
                khHaraikataHenkouWk.setYokinkbn(wkYokinkbn);
                khHaraikataHenkouWk.setKouzano(wkKouzano);
                khHaraikataHenkouWk.setKzkykdoukbn(wkKzkykdoukbn);
                khHaraikataHenkouWk.setKzmeiginmkn(wkKzmeiginmkn);
                khHaraikataHenkouWk.setYykidouuktkkbn(wkYykidouuktkkbn);
                khHaraikataHenkouWk.setKyuukouzaannaikbn(wkKyuukouzaannaikbn);
                khHaraikataHenkouWk.setKanryotuutioutkbn(uiBean.getKanryotuutioutkbn());
                if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
                    khHaraikataHenkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
                }
                khHaraikataHenkouWk.setGyoumuKousinKinou(functionId);
                khHaraikataHenkouWk.setGyoumuKousinsyaId(userId);
                khHaraikataHenkouWk.setGyoumuKousinTime(sysTime);
                khHaraikataHenkouWk.setCreditkessaiyouno(uiBean.getSaibanCreditKessaiyouNo());

                BizPropertyInitializer.initialize(khHaraikataHenkouWk);

                khHaraikataHenkouDao.insert(khHaraikataHenkouWk);

            }
            else {

                IW_KhHaraikataHenkouWk khHaraikataHenkouWk = uiBean.getKhHaraikataHenkouWk();
                khHaraikataHenkouWk.setNewhrkkeiro(uiBean.getNewhrkkeiro());
                khHaraikataHenkouWk.setNewhrkkaisuu(uiBean.getNewhrkkaisuu());
                khHaraikataHenkouWk.setNewtikiktbrisyuruikbn(uiBean.getNewtikiktbrisyuruikbn());
                khHaraikataHenkouWk.setHenkouyoteiym(uiBean.getHenkouyoteiym());
                khHaraikataHenkouWk.setBankcd(wkBankcd);
                khHaraikataHenkouWk.setSitencd(wkSitencd);
                khHaraikataHenkouWk.setYokinkbn(wkYokinkbn);
                khHaraikataHenkouWk.setKouzano(wkKouzano);
                khHaraikataHenkouWk.setKzkykdoukbn(wkKzkykdoukbn);
                khHaraikataHenkouWk.setKzmeiginmkn(wkKzmeiginmkn);
                khHaraikataHenkouWk.setYykidouuktkkbn(wkYykidouuktkkbn);
                khHaraikataHenkouWk.setKyuukouzaannaikbn(wkKyuukouzaannaikbn);
                khHaraikataHenkouWk.setKanryotuutioutkbn(uiBean.getKanryotuutioutkbn());
                if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
                    khHaraikataHenkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
                }
                if (C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {

                    SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

                    setHurikaebi.exec(sysDate);

                    BizDate kyuukouzahurikaeymd = setHurikaebi.getTyokugoHurikaebi();

                    khHaraikataHenkouWk.setKyuukouzahurikaeymd(kyuukouzahurikaeymd);
                }

                khHaraikataHenkouWk.setGyoumuKousinKinou(functionId);
                khHaraikataHenkouWk.setGyoumuKousinsyaId(userId);
                khHaraikataHenkouWk.setGyoumuKousinTime(sysTime);
                khHaraikataHenkouWk.setCreditkessaiyouno(uiBean.getSaibanCreditKessaiyouNo());

                khHaraikataHenkouDao.update(khHaraikataHenkouWk);
            }
        }
    }

    private void checkProcessKaishi() {
        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
        C_UmuKbn umuKbn = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        if (C_UmuKbn.ARI.eq(umuKbn)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }
    }

    private void setKouzaTbl(IT_KykKihon pKykKihon) {

        C_SinkeizkKbn sinkiKeizokuKbn = C_SinkeizkKbn.BLNK;

        if (uiBean.getBankcd().equals(uiBean.getVhrkihrkinfobankcd())
            && !C_SinkeizkKbn.SHINKI.eq(uiBean.getVhrkihrkinfosinkeizkkbn())) {
            sinkiKeizokuKbn = C_SinkeizkKbn.HENKOU;
        }
        else {
            sinkiKeizokuKbn = C_SinkeizkKbn.SHINKI;
        }

        IT_Kouza kouza = khHaraikataHenkouDao.createKouza(pKykKihon);
        kouza.setBankcd(uiBean.getBankcd());
        kouza.setSitencd(uiBean.getSitencd());
        kouza.setYokinkbn(uiBean.getYokinkbn());
        kouza.setKouzano(uiBean.getKouzano());
        kouza.setKzmeiginmkn(uiBean.getKzmeiginmkn());
        kouza.setSinkeizkkbn(sinkiKeizokuKbn);
        kouza.setSyuudaikocd(C_Syuudaikocd.SIS);
        kouza.setKzkykdoukbn(uiBean.getKzkykdoukbn());
        kouza.setGyoumuKousinKinou(functionId);
        kouza.setGyoumuKousinsyaId(userId);
        kouza.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(kouza);
    }

    private void updateSikinIdouRireki(IT_KykSyouhn pKykSyouhn, List<IT_KhDenpyoData> pKhDenpyoDataLst,
        IT_NyknJissekiRireki pNyknJissekiRireki, BizCurrency pOldHokenryou) {

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SikinIdouRirekiDataBean sikinIdouRirekiDataBean = SWAKInjector.getInstance(SikinIdouRirekiDataBean.class);
        BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei = SWAKInjector.getInstance(BzSikinIdouRirekiTblSakusei.class);

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(pKykSyouhn.getSyouhncd(),
            pKykSyouhn.getKyktuukasyu());

        sikinIdouRirekiDataBean.setSyoriYmd(sysDate);
        sikinIdouRirekiDataBean.setSyono(uiBean.getSyono());
        sikinIdouRirekiDataBean.setHenkouSikibetuKey(sikibetuKey);
        sikinIdouRirekiDataBean.setTargetKinouId(functionId);
        sikinIdouRirekiDataBean.setNykshrKbn(C_NykshrKbn.NYUUKIN);
        sikinIdouRirekiDataBean.setSyoricd(kinou.getSyoricd());
        sikinIdouRirekiDataBean.setDensysKbn(pKhDenpyoDataLst.get(0).getDensyskbn());
        sikinIdouRirekiDataBean.setDenrenno(pKhDenpyoDataLst.get(0).getDenrenno());
        sikinIdouRirekiDataBean.setSeg1cd(syouhinbetuSegmentBean.getSegcd1());
        sikinIdouRirekiDataBean.setKykTuukasyu(pKykSyouhn.getKyktuukasyu());
        sikinIdouRirekiDataBean.setSyutkKbn(pKykSyouhn.getSyutkkbn());
        sikinIdouRirekiDataBean.setHrkkaisuu(uiBean.getVhrkihrkkaisuu());
        sikinIdouRirekiDataBean.setSyouhnCd(pKykSyouhn.getSyouhncd());
        sikinIdouRirekiDataBean.setSyouhnSdno(pKykSyouhn.getSyouhnsdno());
        sikinIdouRirekiDataBean.setKykSyouhnRenno(pKykSyouhn.getKyksyouhnrenno());
        sikinIdouRirekiDataBean.setKykYmd(pKykSyouhn.getKykymd());
        sikinIdouRirekiDataBean.setSeirituYmd(uiBean.getKykKihon().getSeirituymd());
        sikinIdouRirekiDataBean.setJkipjytYm(uiBean.getHennyuYm());
        sikinIdouRirekiDataBean.setJyutouStartYm(pNyknJissekiRireki.getJyutoustartym());
        sikinIdouRirekiDataBean.setJyutouEndYm(pNyknJissekiRireki.getJyutouendym());
        sikinIdouRirekiDataBean.setNykkeiro(pNyknJissekiRireki.getNykkeiro());
        sikinIdouRirekiDataBean.setNyknaiyouKbn(C_NyknaiyouKbn.HARAIHENYOUP);
        sikinIdouRirekiDataBean.setNyktrksFlg(pNyknJissekiRireki.getNyktrksflg());
        sikinIdouRirekiDataBean.setHrkp(uiBean.getVhrkihrkp());
        sikinIdouRirekiDataBean.setHokenryou(pOldHokenryou);

        BT_SikinIdouRireki sikinIdouRireki = bzSikinIdouRirekiTblSakusei.editSikinIdouRirekiTblEntity(sikinIdouRirekiDataBean);

        bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblOne(sikinIdouRireki);
    }
}
