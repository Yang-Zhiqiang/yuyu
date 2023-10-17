package yuyu.app.hozen.khozen.khseinengappiseiteisei;

import static yuyu.app.hozen.khozen.khseinengappiseiteisei.GenKhSeinengappiSeiTeiseiConstants.*;
import static yuyu.app.hozen.khozen.khseinengappiseiteisei.KhSeinengappiSeiTeiseiConstants.*;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khseinengappiseiteisei.dba.KhSeinengappiseiteiseiDao;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzFbSoukinDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSks;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakusei;
import yuyu.common.biz.kaikei.SikinIdouRirekiDataBean;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceTaskStart;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.CheckFatca;
import yuyu.common.hozen.khcommon.CheckHansyaSentakuInfo;
import yuyu.common.hozen.khcommon.CheckMaxSStani;
import yuyu.common.hozen.khcommon.CheckMinP;
import yuyu.common.hozen.khcommon.CheckMinS;
import yuyu.common.hozen.khcommon.CheckNenreiHani;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CommonSiwake;
import yuyu.common.hozen.khcommon.CommonSiwakeInBean;
import yuyu.common.hozen.khcommon.CommonSiwakeOutBean;
import yuyu.common.hozen.khcommon.EditDairitenTesuuryouTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTblBean;
import yuyu.common.hozen.khcommon.EditHokenSyoukenParam;
import yuyu.common.hozen.khcommon.EditJimuRenrakuhyouParam;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTbl;
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
import yuyu.common.hozen.khcommon.JtKaisukeisan;
import yuyu.common.hozen.khcommon.KeisanSP;
import yuyu.common.hozen.khcommon.KeisanSiharaibi;
import yuyu.common.hozen.khcommon.KeisanVHeijyun;
import yuyu.common.hozen.khcommon.KeisanVHeijyunBean;
import yuyu.common.hozen.khcommon.KhCheckKouza;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SetManryoubi;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.khcommon.TaisyouGkBean;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetDattai;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetHituyouSyorui;
import yuyu.common.hozen.setuibean.SetHosyou;
import yuyu.common.hozen.setuibean.SetKariukekin;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtil;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetKouzaInfo;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetSonotaTk;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetTokusin;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.common.sinkeiyaku.skcommon.ConvertChannelcd;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_FatcatghtkekKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HnsychkTaisyousyaKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KknsmnKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_NrhnkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyuShrgkSyoukeiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YendthnkJyoutaiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.OutputReport;

/**
 * 被保険者生年月日・性訂正 のビジネスロジックです。
 */
public class KhSeinengappiSeiTeiseiBizLogic {

    @Inject
    private OutputReport outputReport;

    private String sikibetuKey;

    private String functionId;

    private String userId;

    private BizDate sysDate;

    private String sysTime;

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhSeinengappiSeiTeiseiUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private CommonDispImage commonDispImage;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private HozenPreReportRenkeiBean hozenPreReportRenkeiBean;

    @Inject
    private KhSeinengappiseiteiseiDao khSeinengappiseiteiseiDao;

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

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),
            bzCommonLockProcess.getKouteiLockKey());
        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        String kouteikanriid = uiBean.getBzWorkflowInfo().getKouteiKanriId();

        uiBean.setKouteikanriid(kouteikanriid);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteikanriid);

        String syoNo = gyoumuKouteiInfo.getSyono();

        uiBean.setSyono(syoNo);

        checkKykSonzai();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkYuukouJyoutai(khozenCommonParam);

        checkTetudukiTyuui(khozenCommonParam);

        checkYuuyokkngai();

        getData(khozenCommonParam);

        setUiBean(khozenCommonParam);

        initNewHhknData();

        IW_KhSeinengappiSeiTeiseiWk khSeinengappiSeiTeiseiWk =
            hozenDomManager.getKhSeinengappiSeiTeiseiWk(kouteikanriid);

        if (khSeinengappiSeiTeiseiWk == null) {

            throw new CommonBizAppException(IW_KhSeinengappiSeiTeiseiWk.TABLE_NAME + "  取得エラー");
        }

        uiBean.setNewhhknseiymd(khSeinengappiSeiTeiseiWk.getNewhhknseiymd());

        uiBean.setNewhhknsei(khSeinengappiSeiTeiseiWk.getNewhhknsei());

        uiBean.setZenkaiSyoriKekkaKbn(khSeinengappiSeiTeiseiWk.getZenkaisyorikekkakbn());

        uiBean.setYenshrtkumu(khSeinengappiSeiTeiseiWk.getYenshrtkhkumu());

        uiBean.setSoukinsakikbn(khSeinengappiSeiTeiseiWk.getSoukinsakikbn());

        uiBean.setInputshrhousiteikbn(khSeinengappiSeiTeiseiWk.getInputshrhousiteikbn());

        uiBean.setBankcd(khSeinengappiSeiTeiseiWk.getBankcd());

        uiBean.setSitencd(khSeinengappiSeiTeiseiWk.getSitencd());

        uiBean.setYokinkbn(khSeinengappiSeiTeiseiWk.getYokinkbn());

        uiBean.setKouzano(khSeinengappiSeiTeiseiWk.getKouzano());

        uiBean.setKzdoukbn(khSeinengappiSeiTeiseiWk.getKzdoukbn());

        uiBean.setKzmeiginmkn(khSeinengappiSeiTeiseiWk.getKzmeiginmkn());

        uiBean.setHonninkakninkekkakbn(khSeinengappiSeiTeiseiWk.getHonninkakninkekkakbn());

        uiBean.setHassoukbn(khSeinengappiSeiTeiseiWk.getHassoukbn());

        uiBean.setSyorikbn(khSeinengappiSeiTeiseiWk.getSyorikbn());

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn()) &&
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIC0001,
                uiBean.getZenkaiSyoriKekkaKbn().getContent());
        }

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);

        setProgressHistory.exec(uiBean);
    }

    void pushNyuryokuBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        checkKykSonzai();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkYuukouJyoutai(khozenCommonParam);

        checkTetudukiTyuui(khozenCommonParam);

        checkYuuyokkngai();

        if (BizDateUtil.compareYmd(BizDate.getSysDate(), uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0).getKykymd())
            == BizDateUtil.COMPARE_LESSER) {

            throw new BizLogicException(MessageId.EIA0070, SYORIBI);
        }

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SEINEGAPPISEITS);

        getData(khozenCommonParam);

        setUiBean(khozenCommonParam);

        if(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn() &&
            C_SyoriKbn.SEIBETUHENKOU.eq(uiBean.getSyorikbn())){
            throw new BizLogicException(MessageId.EIA1009,
                uiBean.getVhsyusyusyouhnnm(), uiBean.getSyorikbn().getContent());
        }

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);

        hanteiSyoriKengen.exec();

        initNewHhknData();
    }

    void pushSyoukaiInputcontentsBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) ||
            !C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            String syoNo = uiBean.getSyono();

            BizDate mosYmd = uiBean.getMosYMD();

            BizDate syuKykYmd = uiBean.getVhsyusyukykymd();

            BizDate newHhknSeiYmd = uiBean.getNewhhknseiymd();

            BizDate hhknSeiYmd = uiBean.getVhhkshhknseiymd();

            C_Hhknsei newHhknSei = uiBean.getNewhhknsei();

            C_Hhknsei hhknSei = uiBean.getVhhkshhknsei();

            Integer syuHhknNen = uiBean.getVhsyusyuhhknnen();

            if (newHhknSeiYmd == null) {

                throw new BizLogicException(MessageId.EBC0043, "被保険者生年月日");
            }

            if (C_Hhknsei.BLNK.eq(newHhknSei)) {

                throw new BizLogicException(MessageId.EBF1005, "被保険者性別");
            }

            if (BizDateUtil.compareYmd(newHhknSeiYmd, hhknSeiYmd) == BizDateUtil.COMPARE_EQUAL
                && newHhknSei.eq(hhknSei)) {
                throw new BizLogicException(MessageId.EIA0044, "内容");
            }

            if (C_SyoriKbn.SEIBETUHENKOU.eq(uiBean.getSyorikbn())
                && BizDateUtil.compareYmd(newHhknSeiYmd, hhknSeiYmd) != BizDateUtil.COMPARE_EQUAL) {
                throw new BizLogicException(MessageId.EIA1045);
            }

            if (BizDateUtil.compareYmd(newHhknSeiYmd, mosYmd) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EIA0062, DateFormatUtil.dateDOT(mosYmd));
            }

            if (BizDateUtil.compareYmd(newHhknSeiYmd, hhknSeiYmd) == BizDateUtil.COMPARE_EQUAL) {
                uiBean.setNewsyuhhknnen(syuHhknNen);
            }
            if (BizDateUtil.compareYmd(newHhknSeiYmd, hhknSeiYmd) != BizDateUtil.COMPARE_EQUAL) {

                SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

                uiBean.setNewsyuhhknnen(setNenrei.exec(syuKykYmd, newHhknSeiYmd));
            }


            if (uiBean.getNewsyuhhknnen().intValue() != uiBean.getVhsyusyuhhknnen().intValue()) {
                uiBean.setNrhnkKbn(C_NrhnkKbn.HNKARI);
            }
            if (uiBean.getNewsyuhhknnen().intValue() == uiBean.getVhsyusyuhhknnen().intValue()) {
                uiBean.setNrhnkKbn(C_NrhnkKbn.HNKNONE);
            }

            if (!newHhknSei.eq(hhknSei)) {
                uiBean.setSbhnkumu(C_UmuKbn.ARI);
            }
            if (newHhknSei.eq(hhknSei)) {
                uiBean.setSbhnkumu(C_UmuKbn.NONE);
            }

            if (BizDateUtil.compareYmd(uiBean.getNewhhknseiymd(), uiBean.getVhhkshhknseiymd()) !=
                BizDateUtil.COMPARE_EQUAL) {
                uiBean.setHhknseiymdHenkouUmu(C_UmuKbn.ARI);
            }
            else {
                uiBean.setHhknseiymdHenkouUmu(C_UmuKbn.NONE);
            }

            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn()) {
                uiBean.setHenhrkkkn(uiBean.getSyuHrkKkn() + uiBean.getNewsyuhhknnen() - uiBean.getSyuHhknNen());
            }
            else {
                uiBean.setHenhrkkkn(uiBean.getSyuHrkKkn());
            }

            if (C_HrkkknsmnKbn.SAIMANKI.eq(uiBean.getSyuHrkkknSmnKbn())
                && C_Kykjyoutai.ZENNOU.eq(uiBean.getKykJyoutai())
                && C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn())) {
                throw new BizLogicException(MessageId.EIF1108);
            }

            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn()
                && C_Kykjyoutai.ZENNOU.eq(uiBean.getKykJyoutai())
                && C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) {
                throw new BizLogicException(MessageId.EIF1166);
            }

            if ((C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn())
                || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu()))
                && C_YendthnkJyoutaiKbn.YENDTHNKZUMI.eq(uiBean.getVhsyuyendthnkjyoutaikbn())) {
                throw new BizLogicException(MessageId.EIA1021);
            }

            if ((C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn())
                || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu()))
                && !(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()
                && C_SyoriKbn.SEIBETUHENKOU.eq(uiBean.getSyorikbn()))) {

                List<IT_KykSyouhn> kykSyouhnList = uiBean.getKykKihon().getKykSyouhnsByKouryokuhasseiymdGt(syuKykYmd);

                if (kykSyouhnList.size() > 0) {
                    throw new BizLogicException(MessageId.EIA0064);
                }
            }

            if ((C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn())
                || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu()))
                && (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyohinHanteiKbn()
                || SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyohinHanteiKbn())) {

                HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                    SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

                HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean =
                    SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

                hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());

                hanteiTmttknJyoutaiBean.setHanteiKijyunymd(BizDate.getSysDate());

                hanteiTmttknJyoutaiBean.setKykymd(uiBean.getVhsyusyukykymd());

                boolean ret = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                if (!ret) {
                    throw new BizLogicException(MessageId.EBA1052);
                }
            }

            List<IT_KykSyouhn> kykSyouhnList2 = new ArrayList<>();
            C_Channelcd kiteiChkChannelCd = null;

            if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn()) || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) {
                KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

                kykSyouhnList2 = khozenCommonParam.getKeiyakuSyouhin(syoNo, C_SyutkKbn.SYU);

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
                IT_KykDairiten kykDairiten = kykKihon.getKykDairitenByDrtenrenno(1);

                ConvertChannelcd convertChannelCd = SWAKInjector.getInstance(ConvertChannelcd.class);
                kiteiChkChannelCd = convertChannelCd.exec(null, kykDairiten.getOyadrtencd());

                CheckNenreiHani checkNenreiHani = SWAKInjector.getInstance(CheckNenreiHani.class);
                boolean checkNenrei = checkNenreiHani.exec(kykSyouhnList2.get(0).getSyouhncd(), kykSyouhnList2
                    .get(0).getSyouhnsdno(), kykSyouhnList2.get(0).getKatakbn(), kykSyouhnList2.get(0).getHknkkn(),
                    kykSyouhnList2.get(0).getHknkknsmnkbn(), uiBean.getHenhrkkkn(), kykSyouhnList2.get(0)
                    .getHrkkknsmnkbn(), kykSyouhnList2.get(0).getYoteiriritu(), kykSyouhnList2.get(0)
                    .getDai1hknkkn(),kykSyouhnList2.get(0).getSyouhnZokusei(), newHhknSei,
                    uiBean.getNewsyuhhknnen(), kiteiChkChannelCd);

                if (!checkNenrei) {
                    if (checkNenreiHani.getWarningMsgList() != null
                        && checkNenreiHani.getWarningMsgList().size() > 0) {
                        String msg = "";
                        String msgId = "";
                        for (int count = 0; count < checkNenreiHani.getWarningMsgList().size(); count++) {
                            msg = checkNenreiHani.getWarningMsgList().get(count);
                            msgId = BizUtil.getGeneralMessageId(checkNenreiHani.getWarningMsgIdList().get(count));
                            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, msgId, msg);
                        }
                    }
                }
            }

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getKyktuukasyu());

            uiBean.setNewsyusyouhnnm(uiBean.getVhsyusyusyouhnnm());

            uiBean.setTuikahrkkinkyktuuka(BizCurrency.valueOf(0, syuCurrencyType));

            uiBean.setHenkankkyktuuka(BizCurrency.valueOf(0, syuCurrencyType));

            if(C_NrhnkKbn.HNKNONE.eq(uiBean.getNrhnkKbn()) && C_UmuKbn.NONE.eq(uiBean.getSbhnkumu())) {

                uiBean.setNewsyup(uiBean.getHrkp());

                uiBean.setNewsyukihons(uiBean.getVhsyusyukihons());

                uiBean.setShrgkgoukeiKyktuuka(BizCurrency.valueOf(0, syuCurrencyType));

                uiBean.setNewsyukjnkngk(uiBean.getSyukykKjnkngk());

                uiBean.setTuikahrkkinumu(C_UmuKbn.NONE);

                uiBean.setHenkankinumu(C_UmuKbn.NONE);
            }

            if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn()) || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) {

                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == uiBean.getSyohinHanteiKbn()
                    || SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == uiBean.getSyohinHanteiKbn()
                    || SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn()) {

                    KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                    C_ErrorKbn resultKbn = keisanSP.exec(uiBean.getSyusyouhncd(), uiBean.getSyuRyourituSdNo(),
                        uiBean.getSyuYoteiRiritu(), uiBean.getHrkKaisuu(), uiBean.getNewsyuhhknnen(),
                        uiBean.getNewhhknsei(), uiBean.getSyuHknKknSmnKbn(), uiBean.getSyuHknKkn(),
                        uiBean.getHenhrkkkn(), uiBean.getSdpdKbn(), uiBean.getSyuHokenKngk(),
                        uiBean.getSyuHokenRyou(), uiBean.getKykTuukaSyu(), uiBean.getKykJyoutai(),
                        uiBean.getDai1hknkkn(), uiBean.getHrkkeiro());

                    if (!C_ErrorKbn.OK.eq(resultKbn)) {

                        throw new BizLogicException(keisanSP.getMsgid());
                    }

                    if (C_Sdpd.SD.eq(uiBean.getSdpdKbn())) {

                        BizCurrency pKekka = keisanSP.getP();

                        uiBean.setNewsyup(pKekka);
                        uiBean.setNewsyukihons(uiBean.getVhsyusyukihons());
                    }

                    if (C_Sdpd.PD.eq(uiBean.getSdpdKbn())) {

                        BizCurrency hokenKngk = keisanSP.getS();

                        uiBean.setNewsyukihons(hokenKngk);
                        uiBean.setNewsyup(uiBean.getHrkp());
                    }
                }
                else {
                    uiBean.setNewsyukihons(uiBean.getVhsyusyukihons());

                    uiBean.setNewsyup(uiBean.getHrkp());

                    uiBean.setTuikahrkkinumu(C_UmuKbn.NONE);

                    uiBean.setHenkankinumu(C_UmuKbn.NONE);
                }
            }

            if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn()) || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) {

                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == uiBean.getSyohinHanteiKbn()
                    || SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == uiBean.getSyohinHanteiKbn()
                    || SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn()) {

                    CheckMaxSStani checkMaxSStani = SWAKInjector.getInstance(CheckMaxSStani.class);
                    boolean checkMaxS = checkMaxSStani.exec(kykSyouhnList2.get(0).getSyouhncd(), kykSyouhnList2
                        .get(0).getSyouhnsdno(), kykSyouhnList2.get(0).getHhknnen(), kykSyouhnList2.get(0).getKyktuukasyu(),
                        uiBean.getKykKihon().getMosymd(), kykSyouhnList2.get(0).getSyouhnZokusei(), uiBean.getNewsyukihons(),
                        uiBean.getNewsyup());

                    if (!checkMaxS) {
                        if (checkMaxSStani.getWarningMsgList() != null
                            && checkMaxSStani.getWarningMsgList().size() > 0) {
                            String msg = "";
                            String msgId = "";
                            for (int count = 0; count < checkMaxSStani.getWarningMsgList().size(); count++) {
                                msg = checkMaxSStani.getWarningMsgList().get(count);
                                msgId = BizUtil.getGeneralMessageId(checkMaxSStani.getWarningMsgIdList().get(count));
                                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, msgId, msg);
                            }
                        }
                    }
                }

                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == uiBean.getSyohinHanteiKbn()
                    || SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == uiBean.getSyohinHanteiKbn()
                    || SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinHanteiKbn()) {

                    CheckMinS checkMinS = SWAKInjector.getInstance(CheckMinS.class);
                    boolean checkMinSFlg = checkMinS.exec(kykSyouhnList2.get(0).getSyouhncd(), kykSyouhnList2
                        .get(0).getSyouhnsdno(), kykSyouhnList2.get(0).getHrkkknsmnkbn(), kykSyouhnList2.get(0).getHknkkn(),
                        kykSyouhnList2.get(0).getKyktuukasyu(), kykSyouhnList2.get(0).getSyouhnZokusei(),
                        uiBean.getNewsyukihons());

                    if (!checkMinSFlg) {
                        if (checkMinS.getWarningMsgList() != null
                            && checkMinS.getWarningMsgList().size() > 0) {
                            String msg = "";
                            String msgId = "";
                            for (int count = 0; count < checkMinS.getWarningMsgList().size(); count++) {
                                msg = checkMinS.getWarningMsgList().get(count);
                                msgId = BizUtil.getGeneralMessageId(checkMinS.getWarningMsgIdList().get(count));
                                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, msgId, msg);
                            }
                        }
                    }
                }

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()
                    && C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn())) {
                    uiBean.setNewsyukjnkngk(kykSyouhnList2.get(0).getHokenryou()
                        .multiply(kykSyouhnList2.get(0).getHrkkkn() - uiBean.getNewsyuhhknnen())
                        .multiply(12).divide(Integer.valueOf(uiBean.getHrkKaisuu().getValue()),
                            kykSyouhnList2.get(0).getHokenryou().getType().getShiftDigits(), RoundingMode.UP));
                    CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);
                    boolean checkResult = checkMinP.exec(kykSyouhnList2.get(0).getSyouhncd(),
                        kykSyouhnList2.get(0).getSyouhnsdno(), kykSyouhnList2.get(0).getHrkkkn(),
                        kykSyouhnList2.get(0).getHrkkknsmnkbn(), uiBean.getHrkp(), uiBean.getNewsyukjnkngk(),
                        uiBean.getNewsyuhhknnen(), uiBean.getHrkKaisuu(), kykSyouhnList2.get(0).getSyouhnZokusei(),
                        kiteiChkChannelCd);

                    if (!checkResult) {
                        if (checkMinP.getWarningMsgList() != null
                            && checkMinP.getWarningMsgList().size() > 0) {
                            String msg = "";
                            String msgId = "";
                            for (int count = 0; count < checkMinP.getWarningMsgList().size(); count++) {
                                msg = checkMinP.getWarningMsgList().get(count);
                                msgId = BizUtil.getGeneralMessageId(checkMinP.getWarningMsgIdList().get(count));
                                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, msgId, msg);
                            }
                        }
                    }
                }
                else {
                    uiBean.setNewsyukjnkngk(uiBean.getSyukykKjnkngk());
                }
            }

            if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn()) || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) {

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn()
                    && C_SyoriKbn.SEIBETUHENKOU.eq(uiBean.getSyorikbn())) {

                    SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
                    uiBean.setTykgoKykOutouYmd(setOutoubi.exec(C_TykzentykgoKbn.TYKGO, kykSyouhnList2.get(0).getKykymd(),
                        C_Hrkkaisuu.TUKI, BizDate.getSysDate()));
                    BizDate jkiPjytYMD = BizDate.valueOf(uiBean.getJkiPjytYm(), uiBean.getKykYmd().getDay()).getRekijyou();
                    if (BizDateUtil.compareYmd(jkiPjytYMD, uiBean.getTykgoKykOutouYmd()) == BizDateUtil.COMPARE_GREATER) {
                        uiBean.setCalcKijyunYmd(uiBean.getTykgoKykOutouYmd());
                    }
                    else {
                        uiBean.setCalcKijyunYmd(jkiPjytYMD);
                    }
                    KeisanVHeijyunBean keisanVHeijyunBean = SWAKInjector.getInstance(KeisanVHeijyunBean.class);
                    KeisanVHeijyun keisanVHeijyun = SWAKInjector.getInstance(KeisanVHeijyun.class);

                    keisanVHeijyunBean.setSyouhncd(kykSyouhnList2.get(0).getSyouhncd());
                    keisanVHeijyunBean.setRyouritusdno(kykSyouhnList2.get(0).getRyouritusdno());
                    keisanVHeijyunBean.setCalckijyunYm(uiBean.getCalcKijyunYmd().getBizDateYM());
                    keisanVHeijyunBean.setKykymd(kykSyouhnList2.get(0).getKykymd());
                    keisanVHeijyunBean.setHokenryou(uiBean.getHrkp());
                    keisanVHeijyunBean.setKyktuukasyu(kykSyouhnList2.get(0).getKyktuukasyu());
                    keisanVHeijyunBean.setHhknsei(uiBean.getSyuHhknSei());
                    keisanVHeijyunBean.setHhknnen(uiBean.getSyuHhknNen());
                    keisanVHeijyunBean.setHknkkn(kykSyouhnList2.get(0).getHknkkn());
                    keisanVHeijyunBean.setHknkknsmnkbn(kykSyouhnList2.get(0).getHknkknsmnkbn());
                    keisanVHeijyunBean.setHrkkkn(kykSyouhnList2.get(0).getHrkkkn());
                    keisanVHeijyunBean.setHrkkknsmnkbn(kykSyouhnList2.get(0).getHrkkknsmnkbn());
                    keisanVHeijyunBean.setHrkkaisuu(uiBean.getHrkKaisuu());
                    keisanVHeijyunBean.setFstpryosyu(uiBean.getFstPnyknYmd());
                    keisanVHeijyunBean.setSitihsyuriritu(uiBean.getYoteirirituMinHosyouritu());
                    keisanVHeijyunBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);

                    C_ErrorKbn errorKbn = keisanVHeijyun.exec(keisanVHeijyunBean);
                    if (!C_ErrorKbn.OK.eq(errorKbn)) {
                        throw new CommonBizAppException("平準払保険料積立金計算が実行できませんでした。");
                    }

                    uiBean.setSeibetuHenkoumaePtmttkngk(keisanVHeijyun.getV());
                    uiBean.setSbtHenkoumaeKihrkmPstgk(keisanVHeijyun.getKiharaikomiP());
                    uiBean.setTyouseimaePtmttkngk(keisanVHeijyun.getVTyouseimae());
                    uiBean.setPtumitatekinSaikeisanUmu(C_UmuKbn.ARI);
                }
            }

            BizCurrency tuikahrkkinkyktuuka = null;

            BizCurrency henkankkyktuuka = null;

            if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn()) || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) {

                BizDateYM jkiPjytYm;

                int jyutouKaisuu;

                if (C_Kykjyoutai.ITIJIBARAI.eq(uiBean.getVkihnkykjyoutai())) {
                    jkiPjytYm = uiBean.getVhsyusyukykymd().getBizDateYM();
                }
                else {
                    jkiPjytYm = uiBean.getVhrkijkipjytym();
                }

                if (null != jkiPjytYm) {

                    BizDate jkiPjytYmd = BizDate.valueOf(jkiPjytYm, 1);
                    BizDate sykykYmd = BizDate.valueOf(uiBean.getVhsyusyukykymd().getBizDateYM(), 1);
                    int keikaTukisuu = keisanKeikaTukisuu(jkiPjytYmd, sykykYmd);

                    uiBean.setSyukeikatukisuu(keikaTukisuu);

                    JtKaisukeisan jtKaisukeisan = SWAKInjector.getInstance(JtKaisukeisan.class);

                    jtKaisukeisan.exec(0, keikaTukisuu, uiBean.getVhrkihrkkaisuu());

                    jyutouKaisuu = jtKaisukeisan.getJyutoukaisuu();
                }
                else {
                    jyutouKaisuu = 1;
                }

                if (jyutouKaisuu > 0) {

                    if (uiBean.getNewsyup().compareTo(uiBean.getSyuHokenRyou()) > 0) {

                        tuikahrkkinkyktuuka =
                            uiBean.getNewsyup().subtract(uiBean.getSyuHokenRyou()).multiply(jyutouKaisuu);

                        uiBean.setTuikahrkkinumu(C_UmuKbn.ARI);

                        uiBean.setHenkankinumu(C_UmuKbn.NONE);
                    }
                    else if (uiBean.getNewsyup().compareTo(uiBean.getSyuHokenRyou()) < 0) {

                        henkankkyktuuka =
                            uiBean.getSyuHokenRyou().subtract(uiBean.getNewsyup()).multiply(jyutouKaisuu);

                        uiBean.setTuikahrkkinumu(C_UmuKbn.NONE);

                        uiBean.setHenkankinumu(C_UmuKbn.ARI);
                    }
                    else {
                        uiBean.setTuikahrkkinumu(C_UmuKbn.NONE);

                        uiBean.setHenkankinumu(C_UmuKbn.NONE);
                    }
                }
            }

            BizDate tuikahrkkinSyokairsymd = null;

            if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu())) {
                List<IT_Kariukekin> kariukekinList = khSeinengappiseiteiseiDao.
                    getKariukekinsBySyonoKrkriyuukbnNyknaiyoukbnKrkseisanzumiflg(uiBean.getSyono(),
                        C_KrkriyuuKbn.HENKOUMATI, C_NyknaiyouKbn.HOZENHENKOUYOUP, C_Krkseisanzumiflg.BLNK);

                if (kariukekinList.size() == 0) {
                    uiBean.setTuikahrkkinnyknumu(C_UmuKbn.NONE);
                }
                else {
                    uiBean.setTuikahrkkinnyknumu(C_UmuKbn.ARI);

                    tuikahrkkinSyokairsymd = kariukekinList.get(0).getRyosyuymd();
                }

                List<Integer> krknoList = new ArrayList<>();

                for (IT_Kariukekin kariukekin : kariukekinList) {
                    krknoList.add(kariukekin.getKrkno());
                }

                uiBean.setTuikahrkkinKrknoList(krknoList);

                if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinnyknumu())) {
                    uiBean.setTuikahrkkinGoukeinykngk(khSeinengappiseiteiseiDao.
                        getKariukekinSumBySyonoKrkriyuukbnNyknaiyoukbnKrkseisanzumiflg(uiBean.getSyono(),
                            C_KrkriyuuKbn.HENKOUMATI, C_NyknaiyouKbn.HOZENHENKOUYOUP, C_Krkseisanzumiflg.BLNK));
                }

                if (C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())
                    || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                    uiBean.setTuikahrkkinkyktuuka(tuikahrkkinkyktuuka);

                    uiBean.setTuikahrkkinInfoDispPattern(1);
                }
                else {
                    if (C_UmuKbn.NONE.eq(uiBean.getTuikahrkkinnyknumu())) {
                        uiBean.setTuikahrkkinkyktuuka(tuikahrkkinkyktuuka);

                        uiBean.setTuikahrkkinbfrkkt(tuikahrkkinkyktuuka);

                        uiBean.setTuikahrkkinInfoDispPattern(2);
                    }
                    else {
                        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                        getKawaseRate.exec(
                            tuikahrkkinSyokairsymd.addBusinessDays(-1),
                            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                            uiBean.getKykTuukaSyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.NYUKINRATE,
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                            C_YouhiKbn.YOU);

                        BizDate yenKwsratekjymd = getKawaseRate.getKwsrateKjYmd();

                        BizNumber yenKawaserate = getKawaseRate.getKawaserate();

                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                        BizCurrency kansangk = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            tuikahrkkinkyktuuka,
                            yenKawaserate,
                            C_HasuusyoriKbn.SUTE);

                        uiBean.setTuikahrkkinkyktuuka(tuikahrkkinkyktuuka);

                        uiBean.setTuikahrkkinaftkkt(kansangk);

                        uiBean.setTuikahrkkingaika(tuikahrkkinkyktuuka);

                        uiBean.setTkhrkkinnyknratetkyymd(yenKwsratekjymd);

                        uiBean.setTkhrkkinyennyknrate(yenKawaserate);

                        uiBean.setTkhrkkinkyktuukasyu(uiBean.getKykTuukaSyu());

                        uiBean.setTuikahrkkinInfoDispPattern(3);
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
                uiBean.setHenkankkyktuuka(henkankkyktuuka);

                if (!C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) {
                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                    C_ErrorKbn errorKbn = getKawaseRate.exec(
                        BizDate.getSysDate(),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        uiBean.getKykTuukaSyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.SYUKKINRATE,
                        C_EigyoubiHoseiKbn.BLNK,
                        C_YouhiKbn.HUYOU);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new BizLogicException(MessageId.EBC0001,
                            "為替レートの取得が実施できませんでした。平日（月～金）に再度照会してください。");
                    }

                    BizDate yenKwsratekjymd = getKawaseRate.getKwsrateKjYmd();

                    BizNumber yenKawaserate = getKawaseRate.getKawaserate();

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    BizCurrency kansangk = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        henkankkyktuuka,
                        yenKawaserate,
                        C_HasuusyoriKbn.AGE);

                    uiBean.setHenkankgaika(henkankkyktuuka);

                    uiBean.setHenkankyen(kansangk);

                    uiBean.setHenkankyenshrratetekiymd(yenKwsratekjymd);

                    uiBean.setHenkankyenshrrate(yenKawaserate);

                    uiBean.setHenkankkyktuukasyu(uiBean.getKykTuukaSyu());
                }
                else {
                    uiBean.setHenkankyen(henkankkyktuuka);
                    uiBean.setYenshrtkumu(C_UmuKbn.NONE);
                }
            }

            if(C_NrhnkKbn.HNKNONE.eq(uiBean.getNrhnkKbn()) && C_UmuKbn.NONE.eq(uiBean.getSbhnkumu())) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIA0002);
            }

            Long cnt = hozenDomManager.getKhHenreikinYendtMbrCountBySyono(uiBean.getSyono());

            if (cnt > 0) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIA1017);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHhknseiymdHenkouUmu())) {
                SetTyotikuseihokenhyouji setTyotikuseihokenhyouji =
                    SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);

                HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean =
                    SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

                CheckHansyaSentakuInfo checkHansyaSentakuInfo =
                    SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);

                hanteiTyotikuseihokenBean.setSyouhnCd(uiBean.getSyusyouhncd());
                hanteiTyotikuseihokenBean.setSyouhnsdNo(uiBean.getSyusyouhnsdno());
                hanteiTyotikuseihokenBean.setRyouritusdNo(uiBean.getSyuRyourituSdNo());
                hanteiTyotikuseihokenBean.setYoteiriritu(uiBean.getSyuYoteiRiritu());
                hanteiTyotikuseihokenBean.setHrkkaisuu(uiBean.getHrkKaisuu());
                hanteiTyotikuseihokenBean.setHknkknsmnkbn(uiBean.getSyuHknKknSmnKbn());
                hanteiTyotikuseihokenBean.setHknkkn(uiBean.getSyuHknKkn());
                hanteiTyotikuseihokenBean.setHrkkknsmnkbn(uiBean.getSyuHrkkknSmnKbn());
                hanteiTyotikuseihokenBean.setHrkkkn(uiBean.getHenhrkkkn());
                hanteiTyotikuseihokenBean.setHhknnen(uiBean.getNewsyuhhknnen());
                hanteiTyotikuseihokenBean.setHhknsei(uiBean.getNewhhknsei());
                hanteiTyotikuseihokenBean.setKihons(uiBean.getNewsyukihons());
                hanteiTyotikuseihokenBean.setHokenryou(uiBean.getNewsyup());
                hanteiTyotikuseihokenBean.setKykymd(uiBean.getKykYmd());
                hanteiTyotikuseihokenBean.setKyktuukaSyu(uiBean.getKykTuukaSyu());
                hanteiTyotikuseihokenBean.setMosymd(uiBean.getMosYMD());
                hanteiTyotikuseihokenBean.setYoteirrthendohosyurrt(uiBean.getYoteirirituMinHosyouritu());
                hanteiTyotikuseihokenBean.setHrkkeiro(uiBean.getHrkkeiro());
                hanteiTyotikuseihokenBean.setHaraimanymd(uiBean.getSyuharaimanymd());
                hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(true);
                hanteiTyotikuseihokenBean.setDai1hknkkn(uiBean.getDai1hknkkn());

                C_ErrorKbn errorKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

                boolean chkRet = checkHansyaSentakuInfo.exec(
                    C_HnsychkTaisyousyaKbn.HHKN,
                    uiBean.getVhhkshhknnmkn(),
                    uiBean.getVhhkshhknnmkj(),
                    uiBean.getVhhkshhknnmkjkhukakbn(),
                    uiBean.getNewhhknseiymd(),
                    uiBean.getHhknyno(),
                    errorKbn,
                    setTyotikuseihokenhyouji.getHouteityotkhknhyj(),
                    setTyotikuseihokenhyouji.getTyotkhknhyj());

                if (!chkRet) {
                    String msg = "";
                    String msgId = "";
                    List<String> msgList = checkHansyaSentakuInfo.getWarningMsgList();
                    List<String> msgIdList = checkHansyaSentakuInfo.getWarningMsgIdList();

                    for (int count = 0; count < msgIdList.size(); count++) {
                        msg = msgList.get(count);
                        msgId = BizUtil.getGeneralMessageId(msgIdList.get(count));
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, msgId, msg);
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu())) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_MESSAGE1, MessageId.IIF1029);

                if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinnyknumu())) {

                    if (C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) {
                        if (uiBean.getTuikahrkkinGoukeinykngk().compareTo(uiBean.getTuikahrkkinkyktuuka()) > 0) {
                            uiBean.setKajyouukeireumu(C_UmuKbn.ARI);

                            uiBean.setKajyouukeirekngk(
                                uiBean.getTuikahrkkinGoukeinykngk().subtract(uiBean.getTuikahrkkinkyktuuka()));

                            uiBean.setTuikahrkkinRyosyuymd(tuikahrkkinSyokairsymd);
                        }
                    }
                    else {
                        if (uiBean.getTuikahrkkinGoukeinykngk().compareTo(uiBean.getTuikahrkkinaftkkt()) > 0) {
                            uiBean.setKajyouukeireumu(C_UmuKbn.ARI);

                            uiBean.setKajyouukeirekngk(
                                uiBean.getTuikahrkkinGoukeinykngk().subtract(uiBean.getTuikahrkkinaftkkt()));

                            uiBean.setTuikahrkkinRyosyuymd(tuikahrkkinSyokairsymd);
                        }
                    }

                    if (C_UmuKbn.ARI.eq(uiBean.getKajyouukeireumu())) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIF1053);
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_MESSAGE1, MessageId.IIF1030);
            }

            if (uiBean.getVhsyusyukihons().compareTo(uiBean.getNewsyukihons()) < 0) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIA1030);
            }

            uiBean.setShrgkgoukeiKyktuuka(uiBean.getHenkankkyktuuka());

            if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

                if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {
                    if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) || C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) {
                        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
                    }
                    else {
                        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
                    }
                }
                else {
                    uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
                }
            }
        }

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);
    }

    void pushKakuninSyori() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

            C_UmuKbn kouteiUmu =
                checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(kouteiUmu)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                    checkProcessKaishi.getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA1002,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }
        }

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) ||
            (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            BizDate systemDate = BizDate.getSysDate();

            if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu())) {
                if (C_UmuKbn.NONE.eq(uiBean.getTuikahrkkinnyknumu())) {
                    throw new BizLogicException(MessageId.EIF1035);
                }

                if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinnyknumu())) {
                    if (C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) {
                        if (uiBean.getTuikahrkkinGoukeinykngk().compareTo(uiBean.getTuikahrkkinkyktuuka()) < 0) {
                            throw new BizLogicException(MessageId.EIF1167, uiBean.getTuikahrkkinkyktuuka().subtract(
                                uiBean.getTuikahrkkinGoukeinykngk()).toString(), C_Tuukasyu.JPY.getContent());
                        }
                    }
                    else {
                        if (uiBean.getTuikahrkkinGoukeinykngk().compareTo(uiBean.getTuikahrkkinaftkkt()) < 0) {
                            throw new BizLogicException(MessageId.EIF1167, uiBean.getTuikahrkkinaftkkt().subtract(
                                uiBean.getTuikahrkkinGoukeinykngk()).toString(), C_Tuukasyu.JPY.getContent());
                        }
                    }
                }

                if (systemDate.getMonth() == 3 || systemDate.getMonth() == 6
                    || systemDate.getMonth() == 9 || systemDate.getMonth() == 12) {
                    BizDate tuikahrkdenymd = systemDate.addDays(1).getBusinessDay(CHolidayAdjustingMode.NEXT);

                    if (BizDateUtil.compareYm(systemDate.getBizDateYM(),
                        tuikahrkdenymd.getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {
                        throw new BizLogicException(MessageId.EIA1076);
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {

                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    uiBean.setShrtuukasyu(C_Tuukasyu.JPY);
                }
                else {
                    uiBean.setShrtuukasyu(uiBean.getVhsyusyukyktuukasyu());
                }

                if (uiBean.getYenshrtkumu() == null) {
                    throw new BizLogicException(MessageId.EBF1005,
                        MessageUtil.getMessage(DDID_YENSHRTKNYUURYOKU_YENSHRTKUMU.getErrorResourceKey()));
                }

                if (C_InputShrhousiteiKbn.BLNK.eq(uiBean.getInputshrhousiteikbn())) {
                    throw new BizLogicException(MessageId.EBC0043, "支払方法");
                }

                KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

                uiBean.setShrymd(keisanSiharaibi.exec(systemDate, uiBean.getInputshrhousiteikbn(),
                    uiBean.getShrtuukasyu(), uiBean.getBankcd()));

                uiBean.setShrHouSiteiKbn(keisanSiharaibi.getShrhousiteiKbn());

                if (systemDate.getMonth() == 3 || systemDate.getMonth() == 6
                    || systemDate.getMonth() == 9 || systemDate.getMonth() == 12) {
                    if (BizDateUtil.compareYm(systemDate.getBizDateYM(),
                        uiBean.getShrymd().getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {
                        throw new BizLogicException(MessageId.EIA1075);
                    }
                }

                if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                    C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
                    !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) {
                    if (!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())
                        && C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {
                        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                        C_ErrorKbn errorKbn = getKawaseRate.exec(
                            systemDate,
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                            uiBean.getVhsyusyukyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.JISSEIRATE,
                            C_EigyoubiHoseiKbn.BLNK,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new BizLogicException(MessageId.EIA1013);
                        }

                        uiBean.setZeimukwsratekjnymd(getKawaseRate.getKwsrateKjYmd());

                        uiBean.setZeimukwsrate(getKawaseRate.getKawaserate());

                        uiBean.setZeimukyktuukasyu(uiBean.getVhsyusyukyktuukasyu());
                    }
                }

                if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {
                    if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn())) {
                        if (!C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu()) && C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {
                            throw new BizLogicException(MessageId.EIA1033);
                        }

                        if (!BizUtil.isBlank(uiBean.getBankcd()) ||
                            !BizUtil.isBlank(uiBean.getSitencd()) ||
                            !C_YokinKbn.BLNK.eq(uiBean.getYokinkbn()) ||
                            !BizUtil.isBlank(uiBean.getKouzano()) ||
                            !C_Kzdou.BLNK.eq(uiBean.getKzdoukbn()) ||
                            !BizUtil.isBlank(uiBean.getKzmeiginmkn())) {
                            throw new BizLogicException(MessageId.EBA0108, "口座情報");
                        }
                    }

                    KhCheckKouza khCheckKouza = SWAKInjector.getInstance(KhCheckKouza.class);

                    KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

                    khCheckKouza.chkSoukinsakiKouza(uiBean, khozenCommonParam);

                    uiBean.setBanknmkj(khCheckKouza.getGinkouName());

                    uiBean.setSitennmkj(khCheckKouza.getShitenName());

                    if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())
                        || C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
                    }
                    else {
                        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
                    }
                }

                if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) {

                    if (!BizUtil.isBlank(uiBean.getBankcd()) ||
                        !BizUtil.isBlank(uiBean.getSitencd()) ||
                        !C_YokinKbn.BLNK.eq(uiBean.getYokinkbn()) ||
                        !BizUtil.isBlank(uiBean.getKouzano()) ||
                        !C_Kzdou.BLNK.eq(uiBean.getKzdoukbn()) ||
                        !BizUtil.isBlank(uiBean.getKzmeiginmkn())) {

                        throw new BizLogicException(MessageId.EBA0108, "口座情報");
                    }

                    if (C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {

                        throw new BizLogicException(MessageId.EIA1008, "仮受計上（遅延利息なし）");
                    }

                    uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
                }
            }

            if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {

                throw new BizLogicException(MessageId.EBC0043, "本人確認結果区分");
            }

            if (C_KktyuitaKbn.DNGNMEMOARI.eq(uiBean.getVtdktkktyuitakbn())) {

                if (C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {

                    throw new BizLogicException(MessageId.EIA1007);
                }
            }
        }

        CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);

        checkProcessKekka.exec(uiBean.getSyorikekkakbn(), uiBean.getSyanaicommentkh(), uiBean.getSasimodosisakikbn());

        messageManager.addMessageId(MessageId.QBA0001);

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) ||
            (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            if (C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) {

                CheckFatca checkFatca = SWAKInjector.getInstance(CheckFatca.class);

                C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYK, uiBean.getVhhkshhknnmkn(),
                    uiBean.getNewhhknseiymd(), uiBean.getNewhhknsei());
                if (C_FatcatghtkekKbn.TAISYOU.eq(fatcatghtkekKbn)) {
                    if (checkFatca.getMsgIdList().size() > 0) {
                        String msg = "";
                        String msgId = "";
                        for (int count = 0; count < checkFatca.getMsgIdList().size(); count++) {
                            msg = checkFatca.getMsgList().get(count);
                            msgId = BizUtil.getGeneralMessageId(checkFatca.getMsgIdList().get(count));
                            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, msgId, msg);
                        }
                    }
                }
            }
        }
    }

    void pushSksConfirm() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn kouteiUmu =
            checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(kouteiUmu)) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIF1053);

        messageManager.addMessageId(MessageId.QIA0004);
    }

    @Transactional
    void pushKakuteiUpdate() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

            C_UmuKbn kouteiUmu =
                checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(kouteiUmu)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                    checkProcessKaishi.getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA1002,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }

            checkYuukouJyoutai(khozenCommonParam);

            BzProcessCreateInBean bzProcessCreateInBean = SWAKInjector.getInstance(BzProcessCreateInBean.class);

            bzProcessCreateInBean.setSyoNo(uiBean.getSyono());

            bzProcessCreateInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);

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

        functionId = khozenCommonParam.getFunctionId();
        userId = khozenCommonParam.getUserID();
        sysDate = BizDate.getSysDate();
        sysTime = BizDate.getSysDateTimeMilli();
        String syoNo = uiBean.getSyono();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyusyukyktuukasyu());

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) {

            sikibetuKey = khozenCommonParam.getSikibetuKey(syoNo);

            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

            tableMaintenanceUtil.backUp(syoNo, sikibetuKey);

            boolean syosaihkymdSet =
                C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn()) || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu());
            updateKTKykKihon(syosaihkymdSet);

            IT_KhTtdkRireki khTtdkRireki = uiBean.getKykKihon().createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey(sikibetuKey);

            if (C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) {
                updateKTKykSya();
            }
            updateKTHhknSya();

            editKykSyhnRirekiTbl();

            BizDate skykHaraimn = null;
            BizDate skyHknkknmn = null;

            if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn()) || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) {
                SetManryoubi setManryoubi = SWAKInjector.getInstance(SetManryoubi.class);

                if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn())) {
                    skykHaraimn = setManryoubi.exec(uiBean.getVhsyusyukykymd(), uiBean.getNewsyuhhknnen(),
                        uiBean.getHenhrkkkn(),
                        C_KknsmnKbn.valueOf(uiBean.getVhsyusyuhrkkknsmnkbn().getValue()));
                    skyHknkknmn = setManryoubi.exec(uiBean.getVhsyusyukykymd(), uiBean.getNewsyuhhknnen(),
                        uiBean.getVhsyusyuhknkkn(),
                        C_KknsmnKbn.valueOf(uiBean.getVhsyusyuhknkknsmnkbn().getValue()));
                }
            }

            updateKTKykSyouhn(skykHaraimn, skyHknkknmn);

            if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn()) || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) {

                updKTSyouhnTokujou();

                if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn())) {
                    updKTAnsyuKihon(skykHaraimn);
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getPtumitatekinSaikeisanUmu())) {
                insertHokenryouTmttkn();
            }

            CommonSiwakeOutBean commonSiwakeOutBean = SWAKInjector.getInstance(CommonSiwakeOutBean.class);

            if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu())) {
                commonSiwakeOutBean = commonSiwakeTuikahrkkin(khozenCommonParam, syuCurrencyType);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
                commonSiwakeOutBean = commonSiwakeHenkank(khozenCommonParam);
            }

            Integer edaNo = 0;
            String dengyoumuCd = "";

            if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu()) || C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
                BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);

                BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean =
                    SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);

                bzDenpyouDataTourokuBean.setIbSyono(uiBean.getSyono());
                bzDenpyouDataTourokuBean.setIbHuridenatesakicd(commonSiwakeOutBean.getHuridenatesakiCd());
                bzDenpyouDataTourokuBean.setIbTantocd(commonSiwakeOutBean.getTantoCd());
                bzDenpyouDataTourokuBean.setIbDenymd(commonSiwakeOutBean.getDenyMd());
                bzDenpyouDataTourokuBean.setIbTuukasyu(commonSiwakeOutBean.getTuukasyu());
                bzDenpyouDataTourokuBean.setIbHuridenskskbn(commonSiwakeOutBean.getHuridensksKbn());
                bzDenpyouDataTourokuBean.setIbDenhnknhoukbn(commonSiwakeOutBean.getDenhnknhouKbn());
                bzDenpyouDataTourokuBean.setIbDenshrhoukbn(commonSiwakeOutBean.getDenshrhouKbn());
                bzDenpyouDataTourokuBean.setIbSyoriymd(commonSiwakeOutBean.getSyoriYmd());
                bzDenpyouDataTourokuBean.setIbSyoricd(commonSiwakeOutBean.getSyoriCd());
                bzDenpyouDataTourokuBean.setIbSyorisosikicd(khozenCommonParam.getTmSosikiCd());
                bzDenpyouDataTourokuBean.setIbKyktuukasyu(uiBean.getVhsyusyukyktuukasyu());
                bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(khozenCommonParam.getUserID());
                bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
                bzDenpyouDataTourokuBean.setIbShrhousiteiKbn(uiBean.getShrHouSiteiKbn());
                bzDenpyouDataTourokuBean.setIbSyouhncd(uiBean.getSyusyouhncd());
                bzDenpyouDataTourokuBean.setIbSyouhnsdno(uiBean.getSyusyouhnsdno());
                bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());

                List<IT_KhDenpyoData> khDenpyoDataList = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);

                for (IT_KhDenpyoData khDenpyoData : khDenpyoDataList) {
                    hozenDomManager.insert(khDenpyoData);
                }

                uiBean.setDenrenno(khDenpyoDataList.get(0).getDenrenno());
                edaNo = bzDenpyouDataSks.getEdano();
                dengyoumuCd = khDenpyoDataList.get(0).getDengyoumucd();
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
                if (C_ShrhousiteiKbn.FB_YOKUJITU.eq(uiBean.getShrHouSiteiKbn())
                    || C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(uiBean.getShrHouSiteiKbn())
                    || C_ShrhousiteiKbn.FB_3EIGYOUBI.eq(uiBean.getShrHouSiteiKbn())) {
                    if (C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu()) || C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                        BzFbSoukinDataSks bzFbSoukinDataSks = SWAKInjector.getInstance(BzFbSoukinDataSks.class);
                        BzFbSoukinDataSksBean bzFbSoukinDataSksBean =
                            SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);

                        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon(uiBean.getDenrenno());
                        bzFbSoukinDataSksBean.setEdaNo(edaNo);
                        bzFbSoukinDataSksBean.setDenSysKbn(commonSiwakeOutBean.getDensysKbn());
                        bzFbSoukinDataSksBean.setSyoriCd(commonSiwakeOutBean.getSyoriCd());
                        bzFbSoukinDataSksBean.setSyoriSosikiCd(khozenCommonParam.getTmSosikiCd());
                        bzFbSoukinDataSksBean.setSyoriYmd(commonSiwakeOutBean.getSyoriYmd());
                        bzFbSoukinDataSksBean.setDenYmd(commonSiwakeOutBean.getDenyMd());
                        bzFbSoukinDataSksBean.setSyoNo(uiBean.getSyono());
                        bzFbSoukinDataSksBean.setShrHouSiteiKbn(uiBean.getShrHouSiteiKbn());
                        bzFbSoukinDataSksBean.setBankCd(uiBean.getBankcd());
                        bzFbSoukinDataSksBean.setSitenCd(uiBean.getSitencd());
                        bzFbSoukinDataSksBean.setYokinKbn(uiBean.getYokinkbn());
                        bzFbSoukinDataSksBean.setKouzaNo(uiBean.getKouzano());
                        bzFbSoukinDataSksBean.setKzMeigiNmKn(uiBean.getKzmeiginmkn());
                        bzFbSoukinDataSksBean.setSouKingk(uiBean.getHenkankyen());
                        bzFbSoukinDataSksBean.setKykTuukasyu(uiBean.getVhsyusyukyktuukasyu());
                        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(0, syuCurrencyType));
                        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(0));
                        bzFbSoukinDataSksBean.setKinouId(khozenCommonParam.getFunctionId());
                        bzFbSoukinDataSksBean.setUserId(khozenCommonParam.getUserID());
                        bzFbSoukinDataSksBean.setDengyoumuCd(dengyoumuCd);

                        IT_KhFBSoukinData khFBSoukinData = bzFbSoukinDataSks.execKh(bzFbSoukinDataSksBean);

                        hozenDomManager.insert(khFBSoukinData);
                    }
                    else {
                        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
                        BzGkfbSoukinDataSks bzGkfbSoukinDataSks = SWAKInjector.getInstance(BzGkfbSoukinDataSks.class);
                        BzGkfbSoukinDataSksBean bzGkfbSoukinDataSksBean =
                            SWAKInjector.getInstance(BzGkfbSoukinDataSksBean.class);

                        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(uiBean.getBankcd(), uiBean.getSitencd());

                        bzGkfbSoukinDataSksBean.setDenRenno(uiBean.getDenrenno());
                        bzGkfbSoukinDataSksBean.setEdaNo(edaNo);
                        bzGkfbSoukinDataSksBean.setDenSysKbn(commonSiwakeOutBean.getDensysKbn());
                        bzGkfbSoukinDataSksBean.setSyoriCd(commonSiwakeOutBean.getSyoriCd());
                        bzGkfbSoukinDataSksBean.setSyoriSosikiCd(khozenCommonParam.getTmSosikiCd());
                        bzGkfbSoukinDataSksBean.setSyoriYmd(commonSiwakeOutBean.getSyoriYmd());
                        bzGkfbSoukinDataSksBean.setDenYmd(commonSiwakeOutBean.getDenyMd());
                        bzGkfbSoukinDataSksBean.setSyono(uiBean.getSyono());
                        bzGkfbSoukinDataSksBean.setShrHouSiteiKbn(uiBean.getShrHouSiteiKbn());
                        bzGkfbSoukinDataSksBean.setBankCd(uiBean.getBankcd());
                        bzGkfbSoukinDataSksBean.setBankNmEj(bzGetBankDataBean.getBankNmEj());
                        bzGkfbSoukinDataSksBean.setSitenCd(uiBean.getSitencd());
                        bzGkfbSoukinDataSksBean.setSitenNmEj(bzGetBankDataBean.getSitenNmEj());
                        bzGkfbSoukinDataSksBean.setKouzaNo(uiBean.getKouzano());
                        bzGkfbSoukinDataSksBean.setKzMeigiNmEi(ConvertUtil.toHanAll(uiBean.getKzmeiginmkn(), 0, 0));
                        bzGkfbSoukinDataSksBean.setShrTuukaSyu(uiBean.getShrtuukasyu());
                        bzGkfbSoukinDataSksBean.setGaikaShrgk(uiBean.getHenkankgaika());
                        bzGkfbSoukinDataSksBean.setKykTuukaSyu(uiBean.getVhsyusyukyktuukasyu());
                        bzGkfbSoukinDataSksBean.setCrossRateShrgk(BizCurrency.valueOf(0, syuCurrencyType));
                        bzGkfbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(0));
                        bzGkfbSoukinDataSksBean.setKinouId(khozenCommonParam.getFunctionId());
                        bzGkfbSoukinDataSksBean.setUserId(khozenCommonParam.getUserID());
                        bzGkfbSoukinDataSksBean.setDengyoumuCd(dengyoumuCd);

                        IT_KhGaikaFBSoukinData khGaikaFBSoukinData = bzGkfbSoukinDataSks.execKh(bzGkfbSoukinDataSksBean);

                        hozenDomManager.insert(khGaikaFBSoukinData);
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
                setShrrrkInfo();

                insertShrrrkInfo();
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu()) || C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
                Integer maxNo = hozenDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono(uiBean.getSyono());

                Integer kihrkpssrrkrenno;

                if (maxNo != null) {
                    kihrkpssrrkrenno = maxNo + 1;
                }
                else {
                    kihrkpssrrkrenno = 1;
                }

                setKiharaikomipInfo(syuCurrencyType);

                insertKiharaikomipInfo(kihrkpssrrkrenno);
            }

            String jmrnrkKyknm = "";
            String jmrnrkRyosyugk = "";
            String jmrnrkKrkno = "";
            String jmrnrkKrkriyuukbn = "";
            String jmrnrkNykkeiro = "";
            String jmrnrkNyknaiyoukbn = "";
            String jmrnrkKrkgk = "";
            String jmrnrkRyosyuymd = "";

            if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu())) {
                BizDate krkseisandenymd = commonSiwakeOutBean.getDenyMd();

                for (Integer krkno : uiBean.getTuikahrkkinKrknoList()) {
                    List<IT_Kariukekin> kariukekinList = uiBean.getKykKihon().getKariukekins();

                    for (IT_Kariukekin kariukekin : kariukekinList) {
                        if (krkno == kariukekin.getKrkno()) {
                            updateKariukekin(kariukekin, krkseisandenymd);
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(uiBean.getKajyouukeireumu())) {
                    Integer maxKrkno = khSeinengappiseiteiseiDao.getKariukekinMaxKrknoBySyono(uiBean.getSyono());

                    Integer krkno;

                    if (maxKrkno != null) {
                        krkno = maxKrkno + 1;
                    }
                    else {
                        krkno = 1;
                    }

                    insertKariukekin(krkno, krkseisandenymd);

                    if (C_KjkhukaKbn.KJKHUKA.eq(uiBean.getVkykskyknmkjkhukakbn())) {
                        jmrnrkKyknm = uiBean.getVkykskyknmkn();
                    }
                    else {
                        jmrnrkKyknm = uiBean.getVkykskyknmkj();
                    }

                    jmrnrkRyosyugk = uiBean.getTuikahrkkinGoukeinykngk().toFormatString();
                    jmrnrkKrkno = String.valueOf(krkno);
                    jmrnrkKrkriyuukbn = C_KrkriyuuKbn.KAZYOUNYKN.getContent();
                    jmrnrkNykkeiro = C_Nykkeiro.OTHER.getContent();
                    jmrnrkNyknaiyoukbn = C_NyknaiyouKbn.HOZENHENKOUYOUP.getContent();
                    jmrnrkKrkgk = uiBean.getKajyouukeirekngk().toFormatString();
                    jmrnrkRyosyuymd = DateFormatUtil.dateKANJISeirekiNoZero(uiBean.getTuikahrkkinRyosyuymd());
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu()) || C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
                BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei =
                    SWAKInjector.getInstance(BzSikinIdouRirekiTblSakusei.class);

                SikinIdouRirekiDataBean sikinIdouRirekiDataBean =
                    SWAKInjector.getInstance(SikinIdouRirekiDataBean.class);

                sikinIdouRirekiDataBean.setSyoriYmd(sysDate);
                sikinIdouRirekiDataBean.setSyono(uiBean.getSyono());
                sikinIdouRirekiDataBean.setHenkouSikibetuKey(sikibetuKey);
                sikinIdouRirekiDataBean.setTargetKinouId(khozenCommonParam.getFunctionId());
                sikinIdouRirekiDataBean.setSkno("");
                sikinIdouRirekiDataBean.setSeikyuuRirekiNo(0);
                sikinIdouRirekiDataBean.setSyoricd(commonSiwakeOutBean.getSyoriCd());
                sikinIdouRirekiDataBean.setDensysKbn(commonSiwakeOutBean.getDensysKbn());
                sikinIdouRirekiDataBean.setDenrenno(uiBean.getDenrenno());
                sikinIdouRirekiDataBean.setSeg1cd(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd());
                sikinIdouRirekiDataBean.setKykTuukasyu(uiBean.getKykTuukaSyu());
                sikinIdouRirekiDataBean.setSyutkKbn(uiBean.getSyutkkbn());
                sikinIdouRirekiDataBean.setHrkkaisuu(uiBean.getHrkKaisuu());
                sikinIdouRirekiDataBean.setSyouhnCd(uiBean.getSyusyouhncd());
                sikinIdouRirekiDataBean.setSyouhnSdno(uiBean.getSyusyouhnsdno());
                sikinIdouRirekiDataBean.setKykSyouhnRenno(uiBean.getSyukyksyouhnrenno());
                sikinIdouRirekiDataBean.setPhendouKaisiYm(uiBean.getKykYmd().getBizDateYM());
                sikinIdouRirekiDataBean.setPhendoumaeGk(uiBean.getVhsyusyup());
                sikinIdouRirekiDataBean.setPhendougoGk(uiBean.getNewsyup());
                sikinIdouRirekiDataBean.setKykYmd(uiBean.getKykYmd());
                sikinIdouRirekiDataBean.setSeirituYmd(uiBean.getSeirituymd());
                sikinIdouRirekiDataBean.setSyoumetuYmd(null);
                sikinIdouRirekiDataBean.setMisyuupJyuutouYm(null);
                sikinIdouRirekiDataBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.BLNK);
                sikinIdouRirekiDataBean.setSyoumetuJiyuu(C_Syoumetujiyuu.BLNK);
                sikinIdouRirekiDataBean.setJkipjytYm(null);
                sikinIdouRirekiDataBean.setJyutouStartYm(null);
                sikinIdouRirekiDataBean.setJyutouEndYm(null);
                sikinIdouRirekiDataBean.setNykkeiro(C_Nykkeiro.BLNK);
                sikinIdouRirekiDataBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);
                sikinIdouRirekiDataBean.setNyktrksFlg(C_Nyktrksflg.BLNK);
                sikinIdouRirekiDataBean.setHrkp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                sikinIdouRirekiDataBean.setHokenryou(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

                if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
                    sikinIdouRirekiDataBean.setNykshrKbn(C_NykshrKbn.SIHARAI);
                    sikinIdouRirekiDataBean.setShrhousiteiKbn(uiBean.getShrHouSiteiKbn());
                    sikinIdouRirekiDataBean.setShrsyoriKbn(C_ShrsyoriKbn.SEINENGAPPISEI);
                }

                if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu())) {
                    sikinIdouRirekiDataBean.setNykshrKbn(C_NykshrKbn.NYUUKIN);
                    sikinIdouRirekiDataBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
                    sikinIdouRirekiDataBean.setShrsyoriKbn(C_ShrsyoriKbn.BLNK);
                }

                BT_SikinIdouRireki sikinIdouRireki =
                    bzSikinIdouRirekiTblSakusei.editSikinIdouRirekiTblEntity(sikinIdouRirekiDataBean);

                bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblOne(sikinIdouRireki);
            }

            IT_KhLincKihon khLincKihon = uiBean.getKykKihon().getKhLincKihon();

            Long linckanyuusyano = 0l;

            if (khLincKihon != null) {
                linckanyuusyano = khLincKihon.getLinckanyuusyano();
            }

            HanteiLinc hanteiLinc = SWAKInjector.getInstance(HanteiLinc.class);

            HanteiLincBean hanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);

            hanteiLincBean.setSyoriYmd(sysDate);
            hanteiLincBean.setBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
            hanteiLincBean.setKykKihon(uiBean.getKykKihon());
            hanteiLincBean.setKanyuusyaNo(linckanyuusyano);

            hanteiLinc.exec(hanteiLincBean, khozenCommonParam);

            PALKykNaiyouKousin palKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);

            palKykNaiyouKousin.exec(uiBean.getKykKihon());

            makeTetudukiRireki(sikibetuKey, khozenCommonParam, palKykNaiyouKousin.getYoukyuuno());

            EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl =
                SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);

            EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean =
                SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);

            editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
            editHokenKykIdouRirekiTblBean.setSyoNo(uiBean.getSyono());
            editHokenKykIdouRirekiTblBean.setSyoriYmd(sysDate);
            editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.BLNK);
            editHokenKykIdouRirekiTblBean.setSysDateTime(sysTime);
            editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.optional(syuCurrencyType));
            editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.optional(syuCurrencyType));
            editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.optional(syuCurrencyType));
            editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.optional(syuCurrencyType));

            editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

            if (!uiBean.getNewsyup().isOptional() && uiBean.getNewsyup().compareTo(uiBean.getHrkp()) != 0) {

                EditDairitenTesuuryouTbl editDairitenTesuuryouTbl =
                    SWAKInjector.getInstance(EditDairitenTesuuryouTbl.class);

                editDairitenTesuuryouTbl.exec(khozenCommonParam, uiBean.getSyono(), C_TsrysyoriKbn.SEINENGAPPISEI,
                    null, 0, 0, BizCurrency.valueOf(0, syuCurrencyType), BizCurrency.valueOf(0, syuCurrencyType),
                    tableMaintenanceUtil.getBakKykKihon());
            }

            if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn()) || C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) {

                makeTyouhyou(khozenCommonParam, jmrnrkKyknm, jmrnrkRyosyugk, jmrnrkKrkno, jmrnrkKrkriyuukbn,
                    jmrnrkNykkeiro, jmrnrkNyknaiyoukbn, jmrnrkKrkgk, jmrnrkRyosyuymd);
            }

            hozenDomManager.update(uiBean.getKykKihon());
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) {

            if (C_UmuKbn.ARI.eq(uiBean.getTargetTkhkUmu())) {

                BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
                    SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
                bzGetProcessSummaryInBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                    bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);
                BizDate jimuStartYmd = bzGetProcessSummaryOutBean.getJimuStartYmd();

                BizDate kykItinenymd = uiBean.getVhsyusyukykymd().getNextYear().getRekijyou();


                if (BizDateUtil.compareYmd(kykItinenymd, sysDate) == BizDateUtil.COMPARE_LESSER &&
                    BizDateUtil.compareYmd(jimuStartYmd, sysDate) == BizDateUtil.COMPARE_LESSER ) {

                    BizDate torikesiZenymd = sysDate.getPreviousDay();

                    EditJimuRenrakuhyouParam editJimuRenrakuhyouParam = SWAKInjector.getInstance(EditJimuRenrakuhyouParam.class);

                    List<String> jimuRenrakuhyouList = new ArrayList<>();

                    jimuRenrakuhyouList.add("被保険者生年月日・性訂正の案件取消が実施されました。");
                    jimuRenrakuhyouList.add("被保険者生年月日・性訂正の受付してから１日以上経過しています。");
                    jimuRenrakuhyouList.add("受付日（" + DateFormatUtil.dateKANJISeirekiNoZero(jimuStartYmd) +
                        "）から取消日の前日（" + DateFormatUtil.dateKANJISeirekiNoZero(torikesiZenymd) + "）の期間で");
                    jimuRenrakuhyouList.add("目標額到達の判定処理を実施してください。");

                    editJimuRenrakuhyouParam.setJimurenrakuMsgList(jimuRenrakuhyouList);

                    C_SyoruiCdKbn[] syoruiCdLst = { C_SyoruiCdKbn.KK_JIMURENRAKU_SEINENGAPPISEITEISEI };

                    KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

                    khozenTyouhyouCtl.setSyoriYmd(sysDate);
                    khozenTyouhyouCtl.setEditJimuRenrakuhyouParam(editJimuRenrakuhyouParam);

                    khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(), syoruiCdLst, C_YouhiKbn.HUYOU);

                    uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
                    uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());
                }
            }
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

                IW_KhSeinengappiSeiTeiseiWk khSeinengappiSeiTeiseiWk =
                    hozenDomManager.getKhSeinengappiSeiTeiseiWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

                hozenDomManager.delete(khSeinengappiSeiTeiseiWk);
            }
            else {
                updateIWKhSeinengappiSeiTeiseiWk();
            }
        }
        else if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {

            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

                insIWKhSeinengappiSeiTeiseiWk();
            }
            else {

                updateIWKhSeinengappiSeiTeiseiWk();
            }
        }

        doJikouteikanri();

        uiBean.getBzWorkflowInfo().setTaskId(kinouMode.getKinouMode());

        messageManager.addMessageId(MessageId.IAC0009);

        if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
            !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) ||
            C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) {
            uiBean.getKykKihon().detach();
        }
    }

    @Transactional
    void pushKakuteiBySksconfirmBL() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn kouteiUmu =
            checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(kouteiUmu)) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        hozenPreReportRenkeiBean.setSyoNo(uiBean.getSyono());
        hozenPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());
        hozenPreReportRenkeiBean.setSyoriComment("");
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        C_UmuKbn seiHnUmu = uiBean.getSbhnkumu();

        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);

        editSeikyuusyoParam.setHenkankumukbn(uiBean.getHenkankinumu());
        editSeikyuusyoParam.setHhknseiymd(uiBean.getNewhhknseiymd());
        if (C_UmuKbn.ARI.eq(uiBean.getHhknseiymdHenkouUmu())) {
            editSeikyuusyoParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        }
        editSeikyuusyoParam.setHhknsei(uiBean.getNewhhknsei());

        if (C_UmuKbn.ARI.eq(seiHnUmu)) {
            editSeikyuusyoParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        }
        editSeikyuusyoParam.setRstuukasyu(uiBean.getRsTuukaSyu());

        if (uiBean.getSyuHokenKngk().compareTo(uiBean.getNewsyukihons()) != 0) {
            editSeikyuusyoParam.setKihonshenkouumu(C_UmuKbn.ARI);
            editSeikyuusyoParam.setBfrKihonS(uiBean.getNewsyukihons());
        }

        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);

        editSouhuannaiParam.setHenkankinumuKbn(uiBean.getHenkankinumu());

        if (C_UmuKbn.ARI.eq(uiBean.getHhknseiymdHenkouUmu())) {
            editSouhuannaiParam.setHhknseiymdhenkouumu(C_UmuKbn.ARI);
        }

        if (C_UmuKbn.ARI.eq(seiHnUmu)) {
            editSouhuannaiParam.setHhknseihenkouumu(C_UmuKbn.ARI);
        }

        editSouhuannaiParam.setTuikaHrkkinUmu(uiBean.getTuikahrkkinumu());
        editSouhuannaiParam.setTuikaHrkkin(uiBean.getTuikahrkkinkyktuuka());
        editSouhuannaiParam.setCalckijyunymd(BizDate.getSysDate());

        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);

        C_SyoruiCdKbn[] syoruiCds = { C_SyoruiCdKbn.KK_SEINENGAPPISEI_SOUHU, C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS };

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(), syoruiCds, C_YouhiKbn.YOU);

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());

        insIWKhSeinengappiSeiTeiseiWk();

        uiBean.getBzWorkflowInfo().setTaskId(kinouMode.getKinouMode());

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);
    }

    void printOut() {
        String tyhykey = uiBean.getTyouhyoukey();
        outputReport.outputPDFByJoinKey(tyhykey);
    }

    void removeWarning() {
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_MESSAGE1);
    }

    void pushModoruByConfirmBL() {

        continueLockProcessBL();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyusyukyktuukasyu());

        if (!uiBean.getShrgkgoukeiKyktuuka().isOptional() && uiBean.getShrgkgoukeiKyktuuka().compareTo(
            BizCurrency.valueOf(0, syuCurrencyType)) > 0) {
            uiBean.setShrymd(null);
        }
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING3);
    }

    void pushUnlockProcessBL() {

        bzCommonLockProcess.unlockProcess();
    }

    void continueLockProcessBL() {

        bzCommonLockProcess.continueLockProcess();
    }

    void printHyoujiOut() {
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    String pushFunctionNameOnClickBL() {

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            pushUnlockProcessBL();

            return KhSeinengappiSeiTeiseiConstants.FORWARDNAME_BACKTOWORKLIST;
        }
        return KhSeinengappiSeiTeiseiConstants.FORWARDNAME_INIT;
    }

    String pushSyoukainomibtnOnClickBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            pushUnlockProcessBL();

            return KhSeinengappiSeiTeiseiConstants.FORWARDNAME_BACKTOWORKLIST;
        }
        return KhSeinengappiSeiTeiseiConstants.FORWARDNAME_INIT;
    }

    void pushModorubtnbysksconfirmBL() {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyusyukyktuukasyu());

        if (!uiBean.getShrgkgoukeiKyktuuka().isOptional() && uiBean.getShrgkgoukeiKyktuuka().compareTo(
            BizCurrency.valueOf(0, syuCurrencyType)) > 0) {
            uiBean.setShrymd(null);
            SetKouzaInfo.init(uiBean);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getKajyouukeireumu())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIF1053);
        }

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

            String msg = "";

            String msgId = "";

            List<String> msgLst = checkYuukouJyoutai.getWarningMessageList();

            List<String> msgIdLst = checkYuukouJyoutai.getWarningMessageIDList();

            for (int count = 0; count < msgIdLst.size(); count++) {

                msg = msgLst.get(count);

                msgId = msgIdLst.get(count);

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, msgId, msg);
            }
        }
    }

    private void checkTetudukiTyuui(KhozenCommonParam pKhozenCommonParam) {

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahikbn = hanteiTetuduki.exec(pKhozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahikbn)) {

            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }

        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahikbn)) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    private void checkYuuyokkngai() {

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        boolean result = checkYuuyokkngai.exec(uiBean.getSyono(), BizDate.getSysDate());
        if (!result) {
            throw new BizLogicException(MessageId.EIA0085);
        }
    }

    private void getData(KhozenCommonParam pKhozenCommonParam) {

        IT_KykKihon kykKihon = pKhozenCommonParam.getKeiyakuKihon(uiBean.getSyono());

        IT_HhknSya hhknSya = pKhozenCommonParam.getHihokensya(uiBean.getSyono());

        IT_KykSyouhn kykSyouhn = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0);

        IT_NyknJissekiRireki nyknJissekiRireki = pKhozenCommonParam.getNyknJissekiRirekiSk(uiBean.getSyono()).get(0);

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

        IT_AnsyuKihon ansyuKihon = pKhozenCommonParam.getAnsyuuKihon(uiBean.getSyono());

        uiBean.setMosYMD(kykKihon.getMosymd());

        uiBean.setSeirituymd(kykKihon.getSeirituymd());

        uiBean.setHrkKaisuu(kykKihon.getHrkkaisuu());

        uiBean.setHrkkeiro(kykKihon.getHrkkeiro());

        uiBean.setSdpdKbn(kykKihon.getSdpdkbn());

        uiBean.setHrkp(kykKihon.getHrkp());

        uiBean.setFstPnyknYmd(kykKihon.getFstpnyknymd());

        uiBean.setHhknyno(hhknSya.getHhknyno());

        uiBean.setSyutkkbn(kykSyouhn.getSyutkkbn());

        uiBean.setSyusyouhncd(kykSyouhn.getSyouhncd());

        uiBean.setSyuRyourituSdNo(kykSyouhn.getRyouritusdno());

        uiBean.setSyuYoteiRiritu(kykSyouhn.getYoteiriritu());

        uiBean.setSyuHhknNen(kykSyouhn.getHhknnen());

        uiBean.setSyuHhknSei(kykSyouhn.getHhknsei());

        uiBean.setSyuHknKknSmnKbn(kykSyouhn.getHknkknsmnkbn());

        uiBean.setSyuHknKkn(kykSyouhn.getHknkkn());

        uiBean.setSyuHrkkknSmnKbn(kykSyouhn.getHrkkknsmnkbn());

        uiBean.setSyuHrkKkn(kykSyouhn.getHrkkkn());

        uiBean.setSyuHokenKngk(kykSyouhn.getKihons());

        uiBean.setSyuHokenRyou(kykSyouhn.getHokenryou());

        uiBean.setSyuHengakuUmu(kykSyouhn.getSyouhnZokusei().getHengakuumu());

        uiBean.setSyuTeikiSiharaikinUmu(kykSyouhn.getSyouhnZokusei().getTeikisiharaikinumu());

        uiBean.setKihonsSyuruiKbn(kykSyouhn.getSyouhnZokusei().getKihonssyuruikbn());

        uiBean.setKykTuukaSyu(kykSyouhn.getKyktuukasyu());

        uiBean.setSyusyouhnsdno(kykSyouhn.getSyouhnsdno());

        uiBean.setSyukyksyouhnrenno(kykSyouhn.getKyksyouhnrenno());

        uiBean.setSyuharaimanymd(kykSyouhn.getHaraimanymd());

        uiBean.setSyuhknkknmanryouymd(kykSyouhn.getHknkknmanryouymd());

        uiBean.setSyupmnjtkkbn(kykSyouhn.getPmnjtkkbn());

        uiBean.setKykYmd(kykSyouhn.getKykymd());

        uiBean.setKykJyoutai(kykSyouhn.getKykjyoutai());

        uiBean.setSyukykKjnkngk(kykSyouhn.getPharaikomisougaku());

        uiBean.setYoteirirituMinHosyouritu(kykSyouhn.getYoteirrthendohosyurrt());

        uiBean.setDai1hknkkn(kykSyouhn.getDai1hknkkn());

        uiBean.setJkiPjytYm(ansyuKihon.getJkipjytym());

        uiBean.setRsTuukaSyu(nyknJissekiRireki.getRstuukasyu());

        uiBean.setShrtuukasyu(nyknJissekiRireki.getRstuukasyu());

        uiBean.setRyosyuKwsRateKjYMD(nyknJissekiRireki.getRyosyukwsratekjymd());

        uiBean.setRyosyuKwsRate(nyknJissekiRireki.getRyosyukwsrate());

        uiBean.setYenkansanTkyKwsRateYMD(nyknJissekiRireki.getYenkansantkykwsrateymd());

        uiBean.setYenkansanTkyKwsRate(nyknJissekiRireki.getYenkansantkykwsrate());

        uiBean.setTargetTkhkUmu(kykKihon.getKykSonotaTkyk().getTargettkhkumu());

        uiBean.setSyohinHanteiKbn(syohinHanteiKbn);
    }

    private void setUiBean(KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);

        SetKihon.exec(pKhozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);

        setBetukyk.exec(pKhozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList() != null) {
            for (int n = 0; n < uiBean.getWarningMessageIdList().size(); n++) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                    uiBean.getWarningMessageIdList().get(n), uiBean.getWarningMessageList().get(n));
            }
        }

        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);

        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);

        SetTuusinsaki.exec(pKhozenCommonParam, uiBean);

        SetHihokensya.exec(pKhozenCommonParam, uiBean);

        SetHosyou setHosyou = SWAKInjector.getInstance(SetHosyou.class);

        setHosyou.exec(pKhozenCommonParam, uiBean);

        SetSonotaTk.exec(pKhozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        setHaraikomiInfo.exec(pKhozenCommonParam, uiBean);

        SetTokusin.exec(pKhozenCommonParam, uiBean);

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);

        setKariukekin.exec(pKhozenCommonParam, uiBean);

        SetDattai.exec(pKhozenCommonParam, uiBean);

        SetTrkKazoku.exec(pKhozenCommonParam, uiBean);

        SetKyksyadairi.exec(pKhozenCommonParam, uiBean);

        SetHituyouSyorui.exec(pKhozenCommonParam, uiBean);
    }

    private void initNewHhknData() {
        uiBean.setNewhhknseiymd(uiBean.getVhhkshhknseiymd());
        uiBean.setNewhhknsei(uiBean.getVhhkshhknsei());
        uiBean.setNewhhknnmkn(uiBean.getVhhkshhknnmkn());
        uiBean.setNewhhknnmkj(uiBean.getVhhkshhknnmkj());
        uiBean.setNewhhknnmkjkhukakbn(uiBean.getVhhkshhknnmkjkhukakbn());
    }

    private int keisanKeikaTukisuu(BizDate pJkiPjytYm, BizDate pSykykYmd) {

        BizDateSpan bizDate = BizDateUtil.calcDifference(pSykykYmd, pJkiPjytYm);

        int months = Math.abs(bizDate.getYears() * 12) + Math.abs(bizDate.getMonths());

        return months;
    }

    public BizCurrency keisan1(BizCurrency pbdAtai_a, BizCurrency pbdAtai_b, int piAtai_c) {
        BizCurrency bdKekka = (pbdAtai_a.subtract(pbdAtai_b)).multiply(piAtai_c);
        return bdKekka;
    }

    private void insIWKhSeinengappiSeiTeiseiWk() {

        IW_KhSeinengappiSeiTeiseiWk khSeinengappiSeiTeiseiWk = new IW_KhSeinengappiSeiTeiseiWk();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

            khSeinengappiSeiTeiseiWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        if (uiBean.getPageNo() == KhSeinengappiSeiTeiseiConstants.PAGENO_CONFIRM) {

            khSeinengappiSeiTeiseiWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());

            khSeinengappiSeiTeiseiWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());

            if (!C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn())) {
                khSeinengappiSeiTeiseiWk.setBankcd(uiBean.getBankcd());
                khSeinengappiSeiTeiseiWk.setSitencd(uiBean.getSitencd());
                khSeinengappiSeiTeiseiWk.setYokinkbn(uiBean.getYokinkbn());
                khSeinengappiSeiTeiseiWk.setKouzano(uiBean.getKouzano());
                khSeinengappiSeiTeiseiWk.setKzdoukbn(uiBean.getKzdoukbn());

                if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                    khSeinengappiSeiTeiseiWk.setKzmeiginmkn("");
                }
                else {
                    khSeinengappiSeiTeiseiWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
                }
            }
            else {
                khSeinengappiSeiTeiseiWk.setBankcd("");
                khSeinengappiSeiTeiseiWk.setSitencd("");
                khSeinengappiSeiTeiseiWk.setYokinkbn(C_YokinKbn.BLNK);
                khSeinengappiSeiTeiseiWk.setKouzano("");
                khSeinengappiSeiTeiseiWk.setKzdoukbn(C_Kzdou.BLNK);
                khSeinengappiSeiTeiseiWk.setKzmeiginmkn("");
            }
            khSeinengappiSeiTeiseiWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());

            khSeinengappiSeiTeiseiWk.setHassoukbn(uiBean.getHassoukbn());

            khSeinengappiSeiTeiseiWk.setYenshrtkhkumu(uiBean.getYenshrtkumu());

            khSeinengappiSeiTeiseiWk.setSoukinsakikbn(uiBean.getSoukinsakikbn());

        }
        else if (uiBean.getPageNo() == KhSeinengappiSeiTeiseiConstants.PAGENO_SKSCONFIRM) {
            khSeinengappiSeiTeiseiWk.setKouteikanriid(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());
        }

        khSeinengappiSeiTeiseiWk.setSyono(uiBean.getSyono());

        khSeinengappiSeiTeiseiWk.setSkssakuseiymd(BizDate.getSysDate());

        khSeinengappiSeiTeiseiWk.setNewhhknseiymd(uiBean.getNewhhknseiymd());

        khSeinengappiSeiTeiseiWk.setNewhhknsei(uiBean.getNewhhknsei());

        khSeinengappiSeiTeiseiWk.setSyorikbn(uiBean.getSyorikbn());

        khSeinengappiSeiTeiseiWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());

        khSeinengappiSeiTeiseiWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());

        khSeinengappiSeiTeiseiWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(khSeinengappiSeiTeiseiWk);

        hozenDomManager.insert(khSeinengappiSeiTeiseiWk);
    }

    private void updateIWKhSeinengappiSeiTeiseiWk() {

        IW_KhSeinengappiSeiTeiseiWk khSeinengappiSeiTeiseiWk =
            hozenDomManager.getKhSeinengappiSeiTeiseiWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

            khSeinengappiSeiTeiseiWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
            && !C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())
            && !C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

            khSeinengappiSeiTeiseiWk.setNewhhknseiymd(uiBean.getNewhhknseiymd());

            khSeinengappiSeiTeiseiWk.setNewhhknsei(uiBean.getNewhhknsei());

            khSeinengappiSeiTeiseiWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());

            if (!C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn())) {
                khSeinengappiSeiTeiseiWk.setBankcd(uiBean.getBankcd());
                khSeinengappiSeiTeiseiWk.setSitencd(uiBean.getSitencd());
                khSeinengappiSeiTeiseiWk.setYokinkbn(uiBean.getYokinkbn());
                khSeinengappiSeiTeiseiWk.setKouzano(uiBean.getKouzano());
                khSeinengappiSeiTeiseiWk.setKzdoukbn(uiBean.getKzdoukbn());

                if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                    khSeinengappiSeiTeiseiWk.setKzmeiginmkn("");
                }
                else {
                    khSeinengappiSeiTeiseiWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
                }
            }
            else {
                khSeinengappiSeiTeiseiWk.setBankcd("");
                khSeinengappiSeiTeiseiWk.setSitencd("");
                khSeinengappiSeiTeiseiWk.setYokinkbn(C_YokinKbn.BLNK);
                khSeinengappiSeiTeiseiWk.setKouzano("");
                khSeinengappiSeiTeiseiWk.setKzdoukbn(C_Kzdou.BLNK);
                khSeinengappiSeiTeiseiWk.setKzmeiginmkn("");
            }
            khSeinengappiSeiTeiseiWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());

            khSeinengappiSeiTeiseiWk.setHassoukbn(uiBean.getHassoukbn());

            khSeinengappiSeiTeiseiWk.setYenshrtkhkumu(uiBean.getYenshrtkumu());

            khSeinengappiSeiTeiseiWk.setSoukinsakikbn(uiBean.getSoukinsakikbn());
        }

        khSeinengappiSeiTeiseiWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());

        khSeinengappiSeiTeiseiWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());

        khSeinengappiSeiTeiseiWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        hozenDomManager.update(khSeinengappiSeiTeiseiWk);
    }

    private void updateKTKykKihon(boolean syosaihkymdSet) {

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        kykKihon.setHrkp(uiBean.getNewsyup());
        kykKihon.setSyhenkouymd(sysDate);
        if (syosaihkymdSet) {
            kykKihon.setLastsyosaihkymd(sysDate);
        }
        if (C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk()) && C_UmuKbn.ARI.eq(uiBean.getHhknseiymdHenkouUmu())) {
            kykKihon.setLastkyknmseiymdhenkouymd(sysDate);
        }
        kykKihon.setGyoumuKousinKinou(functionId);
        kykKihon.setGyoumuKousinsyaId(userId);
        kykKihon.setGyoumuKousinTime(sysTime);
    }

    private void updateKTKykSya() {

        IT_KykSya kykSya = uiBean.getKykKihon().getKykSya();

        kykSya.setKykseiymd(uiBean.getNewhhknseiymd());
        kykSya.setKyksei(C_Kyksei.valueOf(uiBean.getNewhhknsei().getValue()));
        kykSya.setGyoumuKousinKinou(functionId);
        kykSya.setGyoumuKousinsyaId(userId);
        kykSya.setGyoumuKousinTime(sysTime);
    }

    private void updateKTHhknSya() {

        IT_HhknSya hhknSya = uiBean.getKykKihon().getHhknSya();

        hhknSya.setHhknseiymd(uiBean.getNewhhknseiymd());
        hhknSya.setHhknsei(uiBean.getNewhhknsei());
        hhknSya.setGyoumuKousinKinou(functionId);
        hhknSya.setGyoumuKousinsyaId(userId);
        hhknSya.setGyoumuKousinTime(sysTime);
    }

    private void editKykSyhnRirekiTbl() {

        EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        editKykSyhnRirekiTbl.exec(khozenCommonParam, uiBean.getSyono());
    }

    private void updateKTKykSyouhn(BizDate pSkykHaraimn,BizDate pSkykHknkknmn) {

        IT_KykSyouhn kykSyouhn = uiBean.getKykKihon().getKykSyouhnByPK(
            C_SyutkKbn.SYU, uiBean.getSyusyouhncd(), uiBean.getSyusyouhnsdno(), uiBean.getSyukyksyouhnrenno());

        if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn()) ||
            C_UmuKbn.ARI.eq(uiBean.getSbhnkumu())) {
            if (C_Kykjyoutai.ITIJIBARAI.eq(uiBean.getKykJyoutai())) {
                if (BizDateUtil.compareYmd(sysDate, uiBean.getKykYmd()) == BizDateUtil.COMPARE_GREATER) {
                    kykSyouhn.setKouryokuhasseiymd(sysDate);
                }
            }
            else {
                if (BizDateUtil.compareYmd(BizDate.valueOf(uiBean.getJkiPjytYm(), uiBean.getKykYmd().getDay()).getRekijyou(),
                    uiBean.getTykgoKykOutouYmd()) == BizDateUtil.COMPARE_GREATER) {

                    kykSyouhn.setKouryokuhasseiymd(sysDate);
                }
                else {
                    kykSyouhn.setKouryokuhasseiymd(uiBean.getCalcKijyunYmd());
                }
            }
        }

        if (C_NrhnkKbn.HNKARI.eq(uiBean.getNrhnkKbn())) {
            kykSyouhn.setHaraimanymd(pSkykHaraimn);
            kykSyouhn.setHknkknmanryouymd(pSkykHknkknmn);
            kykSyouhn.setPharaikomisougaku(uiBean.getNewsyukjnkngk());
        }
        kykSyouhn.setHenkousikibetukey(sikibetuKey);
        kykSyouhn.setHrkkkn(uiBean.getHenhrkkkn());
        kykSyouhn.setHhknnen(uiBean.getNewsyuhhknnen());

        kykSyouhn.setHhknseiymd(uiBean.getNewhhknseiymd());
        kykSyouhn.setHhknsei(uiBean.getNewhhknsei());
        kykSyouhn.setHokenryou(uiBean.getNewsyup());
        kykSyouhn.setKihons(uiBean.getNewsyukihons());

        kykSyouhn.setGyoumuKousinKinou(functionId);
        kykSyouhn.setGyoumuKousinsyaId(userId);
        kykSyouhn.setGyoumuKousinTime(sysTime);
    }

    private void updKTSyouhnTokujou() {
        IT_SyouhnTokujou syouhnTokujou = uiBean.getKykKihon()
            .getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                C_SyutkKbn.SYU, uiBean.getSyusyouhncd(), uiBean.getSyusyouhnsdno(), uiBean.getSyukyksyouhnrenno());

        if (syouhnTokujou != null) {
            syouhnTokujou.setHenkousikibetukey(sikibetuKey);
            syouhnTokujou.setGyoumuKousinKinou(functionId);
            syouhnTokujou.setGyoumuKousinsyaId(userId);
            syouhnTokujou.setGyoumuKousinTime(sysTime);
        }
    }

    private void updKTAnsyuKihon(BizDate pSykykHaraimn) {

        IT_AnsyuKihon asyuKihon = hozenDomManager.getAnsyuKihon(uiBean.getSyono());

        if (asyuKihon != null
            && BizDateUtil.compareYmd(asyuKihon.getSyuharaimanymd(), pSykykHaraimn) != BizDateUtil.COMPARE_EQUAL) {
            asyuKihon.setSyuharaimanymd(pSykykHaraimn);
            asyuKihon.setGyoumuKousinKinou(functionId);
            asyuKihon.setGyoumuKousinsyaId(userId);
            asyuKihon.setGyoumuKousinTime(sysTime);
            hozenDomManager.update(asyuKihon);
        }
    }

    private void insertHokenryouTmttkn() {

        Integer renNo = hozenDomManager.getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym(uiBean.getSyono(),
            uiBean.getCalcKijyunYmd().getBizDateYM());
        if (renNo != null) {
            renNo = renNo + 1;
        }
        else {
            renNo = 1;
        }

        IT_HokenryouTmttkn hokenryouTmttkn = uiBean.getKykKihon().createHokenryouTmttkn();

        hokenryouTmttkn.setTmttkntaisyouym(uiBean.getCalcKijyunYmd().getBizDateYM());
        hokenryouTmttkn.setRenno(renNo);
        hokenryouTmttkn.setPtmttkngk(uiBean.getSeibetuHenkoumaePtmttkngk());
        hokenryouTmttkn.setKihrkmpstgk(uiBean.getSbtHenkoumaeKihrkmPstgk());
        hokenryouTmttkn.setTyouseimaeptmttkngk(uiBean.getTyouseimaePtmttkngk());
        hokenryouTmttkn.setGyoumuKousinKinou(functionId);
        hokenryouTmttkn.setGyoumuKousinsyaId(userId);
        hokenryouTmttkn.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(hokenryouTmttkn);
    }

    private void makeTetudukiRireki(String pUniqueId, KhozenCommonParam pKhozenCommonParam, String pYoukyuuno) {

        EditTtdkRirekiTblParam editTtdkRirekiTblParam =
            SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(pKhozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        editTtdkRirekiTblParam.setSysTime(sysTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());
        editTtdkRirekiTblParam.setYoukyuuNo(pYoukyuuno);
        editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        editTtdkRirekiTblParam.setSyoriKbn(uiBean.getSyorikbn());

        C_UmuKbn umuKbn = C_UmuKbn.NONE;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyusyukyktuukasyu());

        if (!uiBean.getShrgkgoukeiKyktuuka().isOptional() && uiBean.getShrgkgoukeiKyktuuka().compareTo(
            BizCurrency.valueOf(0, syuCurrencyType)) > 0) {
            umuKbn = C_UmuKbn.ARI;
        }
        editTtdkRirekiTblParam.setShrSyousaiUmu(umuKbn);

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    private void makeTyouhyou(KhozenCommonParam pKhozenCommonParam, String pJmrnrkKyknm, String pJmrnrkRyosyugk,
        String pJmrnrkKrkno, String pJmrnrkKrkriyuukbn, String pJmrnrkNykkeiro, String pJmrnrkNyknaiyoukbn,
        String pJmrnrkKrkgk, String pJmrnrkRyosyuymd) {

        EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);

        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.SEINENGAPPISEI);

        editTtdkKanryouParam.setHhknseiymdHnUmu(uiBean.getHhknseiymdHenkouUmu());

        editTtdkKanryouParam.setHhknseiHnUmu(uiBean.getSbhnkumu());

        editTtdkKanryouParam.setCalckijyunYMD(sysDate);

        if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {

            editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
            editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI);
        }
        else {
            editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
            editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR);
        }

        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(sysDate);

        C_SyoruiCdKbn[] syoruiCds;

        if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
            syoruiCds = new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI, C_SyoruiCdKbn.KK_HKNSYKN };
        }
        else {
            syoruiCds = new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR, C_SyoruiCdKbn.KK_HKNSYKN };
        }

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);

        khozenTyouhyouCtl.setHassoukbn(uiBean.getHassoukbn());

        khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam, uiBean.getSyono(), syoruiCds, C_YouhiKbn.HUYOU);

        uiBean.setTyouhyoumukbn(C_UmuKbn.NONE);

        if (C_UmuKbn.ARI.eq(uiBean.getTargetTkhkUmu())) {
            BizDate kykItinenymd = uiBean.getVhsyusyukykymd().getNextYear().getRekijyou();

            if (BizDateUtil.compareYmd(kykItinenymd, sysDate) == BizDateUtil.COMPARE_LESSER) {

                BizDate syoriZenymd = sysDate.getPreviousDay();

                EditJimuRenrakuhyouParam editJimuRenrakuhyouParam = SWAKInjector.getInstance(EditJimuRenrakuhyouParam.class);

                List<String> jimuRenrakuhyouList = new ArrayList<>();

                jimuRenrakuhyouList.add("年齢又は性別が変更されました。");
                jimuRenrakuhyouList.add("契約１年後の応当日（" + DateFormatUtil.dateKANJISeirekiNoZero(kykItinenymd) +
                    "）～処理日の前日（" + DateFormatUtil.dateKANJISeirekiNoZero(syoriZenymd) + "）の期間で");
                jimuRenrakuhyouList.add("目標額到達判定を実施してください。");

                editJimuRenrakuhyouParam.setJimurenrakuMsgList(jimuRenrakuhyouList);

                C_SyoruiCdKbn[] syoruiCdLst = { C_SyoruiCdKbn.KK_JIMURENRAKU_SEINENGAPPISEITEISEI };
                khozenTyouhyouCtl.setSyoriYmd(sysDate);
                khozenTyouhyouCtl.setEditJimuRenrakuhyouParam(editJimuRenrakuhyouParam);

                khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam, uiBean.getSyono(), syoruiCdLst, C_YouhiKbn.HUYOU);

                uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
                uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getKajyouukeireumu())) {

            EditJimuRenrakuhyouParam editJimuRenrakuhyouParam = SWAKInjector.getInstance(EditJimuRenrakuhyouParam.class);

            List<String> jimuRenrakuhyouList = new ArrayList<>();

            jimuRenrakuhyouList.add("仮受金に計上しました。");
            jimuRenrakuhyouList.add("");
            jimuRenrakuhyouList.add("契約者名／" + pJmrnrkKyknm);
            jimuRenrakuhyouList.add("領収額／" + pJmrnrkRyosyugk + "円");
            jimuRenrakuhyouList.add("");
            jimuRenrakuhyouList.add("＜仮受金情報＞");
            jimuRenrakuhyouList.add("仮受番号／" + pJmrnrkKrkno);
            jimuRenrakuhyouList.add("仮受理由区分／" + pJmrnrkKrkriyuukbn);
            jimuRenrakuhyouList.add("入金経路／" + pJmrnrkNykkeiro);
            jimuRenrakuhyouList.add("入金内容区分／" + pJmrnrkNyknaiyoukbn);
            jimuRenrakuhyouList.add("仮受金額／" + pJmrnrkKrkgk + "円");
            jimuRenrakuhyouList.add("領収日／" + pJmrnrkRyosyuymd);

            editJimuRenrakuhyouParam.setJimurenrakuMsgList(jimuRenrakuhyouList);

            C_SyoruiCdKbn[] syoruiCdLst = { C_SyoruiCdKbn.KK_JIMURENRAKU_SEINENGAPPISEITEISEI };

            khozenTyouhyouCtl.setSyoriYmd(sysDate);
            khozenTyouhyouCtl.setEditJimuRenrakuhyouParam(editJimuRenrakuhyouParam);

            khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam, uiBean.getSyono(), syoruiCdLst, C_YouhiKbn.HUYOU);

            uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
            uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());
        }
    }

    private void doJikouteikanri() {

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());

        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());

        khRuleBean.setSaiwariateUserId("");

        String comment = uiBean.getSyanaicommentkh();

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

        khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            bzCommonLockProcess.getKouteiLockKey(), comment, khRuleBean);

        pushUnlockProcessBL();
    }

    private CommonSiwakeOutBean commonSiwakeTuikahrkkin(KhozenCommonParam pKhozenCommonParam,
        CurrencyType pCurrencyType) {

        List<TaisyouGkBean> taisyouGkBeanList = new ArrayList<>();
        TaisyouGkBean taisyouGkBeanRyosyugk = SWAKInjector.getInstance(TaisyouGkBean.class);
        TaisyouGkBean taisyouGkBeanTuikahrkkin = SWAKInjector.getInstance(TaisyouGkBean.class);
        TaisyouGkBean taisyouGkBeanKajyouukeirekngk = SWAKInjector.getInstance(TaisyouGkBean.class);
        CommonSiwake commonSiwake = SWAKInjector.getInstance(CommonSiwake.class);
        CommonSiwakeInBean commonSiwakeInBean = SWAKInjector.getInstance(CommonSiwakeInBean.class);

        if (C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) {
            if (C_UmuKbn.NONE.eq(uiBean.getKajyouukeireumu())) {
                taisyouGkBeanRyosyugk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_TUITYOU);
                taisyouGkBeanRyosyugk.setTaisyouGk(uiBean.getTuikahrkkinGoukeinykngk());
                taisyouGkBeanRyosyugk.setKeiyakutuukaGk(uiBean.getTuikahrkkinGoukeinykngk());

                taisyouGkBeanTuikahrkkin.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
                taisyouGkBeanTuikahrkkin.setTaisyouGk(uiBean.getTuikahrkkinkyktuuka());
                taisyouGkBeanTuikahrkkin.setKeiyakutuukaGk(uiBean.getTuikahrkkinkyktuuka());

                taisyouGkBeanList.add(taisyouGkBeanRyosyugk);
                taisyouGkBeanList.add(taisyouGkBeanTuikahrkkin);
            }
            else {
                taisyouGkBeanRyosyugk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_TUITYOU);
                taisyouGkBeanRyosyugk.setTaisyouGk(uiBean.getTuikahrkkinGoukeinykngk());
                taisyouGkBeanRyosyugk.setKeiyakutuukaGk(uiBean.getTuikahrkkinGoukeinykngk());

                taisyouGkBeanTuikahrkkin.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
                taisyouGkBeanTuikahrkkin.setTaisyouGk(uiBean.getTuikahrkkinkyktuuka());
                taisyouGkBeanTuikahrkkin.setKeiyakutuukaGk(uiBean.getTuikahrkkinkyktuuka());

                taisyouGkBeanKajyouukeirekngk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
                taisyouGkBeanKajyouukeirekngk.setTaisyouGk(uiBean.getKajyouukeirekngk());
                taisyouGkBeanKajyouukeirekngk.setKeiyakutuukaGk(BizCurrency.valueOf(0, pCurrencyType));

                taisyouGkBeanList.add(taisyouGkBeanRyosyugk);
                taisyouGkBeanList.add(taisyouGkBeanTuikahrkkin);
                taisyouGkBeanList.add(taisyouGkBeanKajyouukeirekngk);
            }
        }
        else {
            if (C_UmuKbn.NONE.eq(uiBean.getKajyouukeireumu())) {
                taisyouGkBeanRyosyugk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_TUITYOU);
                taisyouGkBeanRyosyugk.setTaisyouGk(uiBean.getTuikahrkkinGoukeinykngk());
                taisyouGkBeanRyosyugk.setKeiyakutuukaGk(uiBean.getTuikahrkkinGoukeinykngk());

                taisyouGkBeanTuikahrkkin.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
                taisyouGkBeanTuikahrkkin.setTaisyouGk(uiBean.getTuikahrkkinaftkkt());
                taisyouGkBeanTuikahrkkin.setKeiyakutuukaGk(uiBean.getTuikahrkkinkyktuuka());

                taisyouGkBeanList.add(taisyouGkBeanRyosyugk);
                taisyouGkBeanList.add(taisyouGkBeanTuikahrkkin);
            }
            else {
                taisyouGkBeanRyosyugk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_TUITYOU);
                taisyouGkBeanRyosyugk.setTaisyouGk(uiBean.getTuikahrkkinGoukeinykngk());
                taisyouGkBeanRyosyugk.setKeiyakutuukaGk(uiBean.getTuikahrkkinGoukeinykngk());

                taisyouGkBeanTuikahrkkin.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
                taisyouGkBeanTuikahrkkin.setTaisyouGk(uiBean.getTuikahrkkinaftkkt());
                taisyouGkBeanTuikahrkkin.setKeiyakutuukaGk(uiBean.getTuikahrkkinkyktuuka());

                taisyouGkBeanKajyouukeirekngk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
                taisyouGkBeanKajyouukeirekngk.setTaisyouGk(uiBean.getKajyouukeirekngk());
                taisyouGkBeanKajyouukeirekngk.setKeiyakutuukaGk(BizCurrency.valueOf(0, pCurrencyType));

                taisyouGkBeanList.add(taisyouGkBeanRyosyugk);
                taisyouGkBeanList.add(taisyouGkBeanTuikahrkkin);
                taisyouGkBeanList.add(taisyouGkBeanKajyouukeirekngk);
            }
        }

        commonSiwakeInBean.setKinouId(pKhozenCommonParam.getFunctionId());
        commonSiwakeInBean.setDenYmd(sysDate.addBusinessDays(1));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(sysDate);
        commonSiwakeInBean.setKykYmd(uiBean.getVhsyusyukykymd());
        commonSiwakeInBean.setSyouhnCd(uiBean.getSyusyouhncd());
        commonSiwakeInBean.setSyouhnsdNo(uiBean.getSyusyouhnsdno());
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        commonSiwakeInBean.setKyktuukaSyu(uiBean.getVhsyusyukyktuukasyu());
        commonSiwakeInBean.setGstszeigkUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanList);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        return commonSiwakeOutBean;
    }

    private CommonSiwakeOutBean commonSiwakeHenkank(KhozenCommonParam pKhozenCommonParam) {

        List<TaisyouGkBean> taisyouGkBeanList = new ArrayList<>();
        TaisyouGkBean taisyouGkBeanHenkank = SWAKInjector.getInstance(TaisyouGkBean.class);
        TaisyouGkBean taisyouGkBeanShrgk = SWAKInjector.getInstance(TaisyouGkBean.class);
        CommonSiwake commonSiwake = SWAKInjector.getInstance(CommonSiwake.class);
        CommonSiwakeInBean commonSiwakeInBean = SWAKInjector.getInstance(CommonSiwakeInBean.class);

        if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {
            taisyouGkBeanHenkank.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANP_HENKAN);
            taisyouGkBeanHenkank.setTaisyouGk(uiBean.getHenkankkyktuuka());
            taisyouGkBeanHenkank.setKeiyakutuukaGk(uiBean.getHenkankkyktuuka());

            taisyouGkBeanShrgk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
            taisyouGkBeanShrgk.setTaisyouGk(uiBean.getHenkankkyktuuka());
            taisyouGkBeanShrgk.setKeiyakutuukaGk(uiBean.getHenkankkyktuuka());

            taisyouGkBeanList.add(taisyouGkBeanHenkank);
            taisyouGkBeanList.add(taisyouGkBeanShrgk);
        }
        else {
            taisyouGkBeanHenkank.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANP_HENKAN);
            taisyouGkBeanHenkank.setTaisyouGk(uiBean.getHenkankyen());
            taisyouGkBeanHenkank.setKeiyakutuukaGk(uiBean.getHenkankkyktuuka());

            taisyouGkBeanShrgk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
            taisyouGkBeanShrgk.setTaisyouGk(uiBean.getHenkankyen());
            taisyouGkBeanShrgk.setKeiyakutuukaGk(uiBean.getHenkankkyktuuka());

            taisyouGkBeanList.add(taisyouGkBeanHenkank);
            taisyouGkBeanList.add(taisyouGkBeanShrgk);
        }

        commonSiwakeInBean.setKinouId(pKhozenCommonParam.getFunctionId());
        commonSiwakeInBean.setDenYmd(uiBean.getShrymd());
        commonSiwakeInBean.setTuukasyu(uiBean.getShrtuukasyu());
        commonSiwakeInBean.setSyoriYmd(sysDate);
        commonSiwakeInBean.setKykYmd(uiBean.getVhsyusyukykymd());
        commonSiwakeInBean.setSyouhnCd(uiBean.getSyusyouhncd());
        commonSiwakeInBean.setSyouhnsdNo(uiBean.getSyusyouhnsdno());
        commonSiwakeInBean.setShrhousiteiKbn(uiBean.getShrHouSiteiKbn());
        commonSiwakeInBean.setKyktuukaSyu(uiBean.getVhsyusyukyktuukasyu());
        commonSiwakeInBean.setTuukasyuKansanKawaserate(uiBean.getHenkankyenshrrate());
        commonSiwakeInBean.setGstszeigkUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanList);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        return commonSiwakeOutBean;
    }

    private void setKiharaikomipInfo(CurrencyType pCurrencyType) {

        if (C_UmuKbn.ARI.eq(uiBean.getTuikahrkkinumu())) {
            uiBean.setKihrkpssnaiyoukbn(C_KiharaiPseisanNaiyouKbn.TUITYOUKIN);
            uiBean.setKihrkpYenkansanhenkankin(BizCurrency.optional());

            if (C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) {
                uiBean.setKihrkpTuityouk(BizCurrency.valueOf(0));
                uiBean.setKihrkpYenkansantuityoukin(uiBean.getTuikahrkkinkyktuuka());
                uiBean.setKihrkpZeimukwsratekjnymd(null);
                uiBean.setKihrkpZeimukwsrate(BizNumber.valueOf(0));
            }
            else {
                uiBean.setKihrkpTuityouk(uiBean.getTuikahrkkingaika());
                uiBean.setKihrkpYenkansantuityoukin(uiBean.getTuikahrkkinaftkkt());
                uiBean.setKihrkpZeimukwsratekjnymd(uiBean.getTkhrkkinnyknratetkyymd());
                uiBean.setKihrkpZeimukwsrate(uiBean.getTkhrkkinyennyknrate());
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
            uiBean.setKihrkpssnaiyoukbn(C_KiharaiPseisanNaiyouKbn.HENKANKIN);
            uiBean.setKihrkpTuityouk(BizCurrency.optional(pCurrencyType));
            uiBean.setKihrkpYenkansantuityoukin(BizCurrency.optional());

            if (C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) {
                uiBean.setKihrkpYenkansanhenkankin(uiBean.getHenkankyen());
                uiBean.setKihrkpZeimukwsratekjnymd(null);
                uiBean.setKihrkpZeimukwsrate(BizNumber.valueOf(0));
            }
            else {
                if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                    uiBean.setKihrkpYenkansanhenkankin(uiBean.getHenkankyen());
                    uiBean.setKihrkpZeimukwsratekjnymd(uiBean.getHenkankyenshrratetekiymd());
                    uiBean.setKihrkpZeimukwsrate(uiBean.getHenkankyenshrrate());
                }
                else {
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    BizCurrency kansangk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, uiBean.getHenkankkyktuuka(),
                        uiBean.getZeimukwsrate(), C_HasuusyoriKbn.SUTE);

                    uiBean.setKihrkpYenkansanhenkankin(kansangk);
                    uiBean.setKihrkpZeimukwsratekjnymd(uiBean.getZeimukwsratekjnymd());
                    uiBean.setKihrkpZeimukwsrate(uiBean.getZeimukwsrate());
                }
            }
        }
    }

    private void setShrrrkInfo() {

        if (C_UmuKbn.ARI.eq(uiBean.getHenkankinumu())) {
            if (C_Tuukasyu.JPY.eq(uiBean.getKykTuukaSyu())) {
                uiBean.setShrtuukashrgkgoukei(uiBean.getHenkankkyktuuka());
                uiBean.setShrtuukasyushrgkkei(uiBean.getHenkankkyktuuka());
                uiBean.setYenshrgkgoukei(uiBean.getHenkankkyktuuka());
                uiBean.setYensyushrgkkei(uiBean.getHenkankkyktuuka());
                uiBean.setShrkwsratekjnymd(null);
                uiBean.setShrkwsrate(BizNumber.valueOf(0));
                uiBean.setZeimukwsratekjnymd(null);
                uiBean.setZeimukwsrate(BizNumber.valueOf(0));

            }
            else {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    uiBean.setShrtuukashrgkgoukei(uiBean.getHenkankyen());
                    uiBean.setShrtuukasyushrgkkei(uiBean.getHenkankyen());
                    uiBean.setYenshrgkgoukei(uiBean.getHenkankyen());
                    uiBean.setYensyushrgkkei(uiBean.getHenkankyen());
                    uiBean.setShrkwsratekjnymd(uiBean.getHenkankyenshrratetekiymd());
                    uiBean.setShrkwsrate(uiBean.getHenkankyenshrrate());
                    uiBean.setZeimukwsratekjnymd(null);
                    uiBean.setZeimukwsrate(BizNumber.valueOf(0));
                }
                else {
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    BizCurrency kansangk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, uiBean.getHenkankkyktuuka(),
                        uiBean.getZeimukwsrate(), C_HasuusyoriKbn.SUTE);

                    uiBean.setShrtuukashrgkgoukei(uiBean.getHenkankkyktuuka());
                    uiBean.setShrtuukasyushrgkkei(uiBean.getHenkankkyktuuka());
                    uiBean.setYenshrgkgoukei(kansangk);
                    uiBean.setYensyushrgkkei(kansangk);
                    uiBean.setShrkwsratekjnymd(null);
                    uiBean.setShrkwsrate(BizNumber.valueOf(0));
                    uiBean.setZeimukwsratekjnymd(uiBean.getZeimukwsratekjnymd());
                    uiBean.setZeimukwsrate(uiBean.getZeimukwsrate());
                }
            }
        }
    }

    private void insertShrrrkInfo() {

        IT_KhTtdkRireki khTtdkRireki = uiBean.getKykKihon().getKhTtdkRirekiByHenkousikibetukey(sikibetuKey);

        IT_KhShrRireki khShrRireki = khTtdkRireki.createKhShrRireki();

        khShrRireki.setShrymd(uiBean.getShrymd());
        khShrRireki.setShrsyoriymd(sysDate);
        khShrRireki.setShrsyorikbn(C_ShrsyoriKbn.SEINENGAPPISEI);
        khShrRireki.setKouryokuhasseiymd(sysDate);
        khShrRireki.setYenshrtkumu(uiBean.getYenshrtkumu());
        khShrRireki.setKyktuukasyu(uiBean.getKykTuukaSyu());
        khShrRireki.setSyushrgkkeisyukbn(C_SyuShrgkSyoukeiKbn.HENKANKIN);
        khShrRireki.setSyushrgkkei(uiBean.getShrgkgoukeiKyktuuka());
        khShrRireki.setShrtuukasyu(uiBean.getShrtuukasyu());
        khShrRireki.setShrtuukashrgkgoukei(uiBean.getShrtuukashrgkgoukei());
        khShrRireki.setShrtuukasyushrgkkei(uiBean.getShrtuukasyushrgkkei());
        khShrRireki.setYenshrgkgoukei(uiBean.getYenshrgkgoukei());
        khShrRireki.setYensyushrgkkei(uiBean.getYensyushrgkkei());
        khShrRireki.setShrkwsratekjnymd(uiBean.getShrkwsratekjnymd());
        khShrRireki.setShrkwsrate(uiBean.getShrkwsrate());
        khShrRireki.setZeimukwsratekjnymd(uiBean.getZeimukwsratekjnymd());
        khShrRireki.setZeimukwsrate(uiBean.getZeimukwsrate());
        khShrRireki.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        khShrRireki.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());
        khShrRireki.setShrhousiteikbn(uiBean.getShrHouSiteiKbn());
        khShrRireki.setKzsyuruikbn(uiBean.getKzsyuruikbn());
        khShrRireki.setBankcd(uiBean.getBankcd());
        khShrRireki.setSitencd(uiBean.getSitencd());
        khShrRireki.setYokinkbn(uiBean.getYokinkbn());
        khShrRireki.setKouzano(uiBean.getKouzano());
        khShrRireki.setKzdoukbn(uiBean.getKzdoukbn());
        khShrRireki.setKzmeiginmkn(uiBean.getKzmeiginmkn());
        khShrRireki.setShrtysysyuruikbn(C_HtsiryosyuKbn.BLNK);
        khShrRireki.setDenrenno(uiBean.getDenrenno());
        khShrRireki.setGyoumuKousinKinou(functionId);
        khShrRireki.setGyoumuKousinsyaId(userId);
        khShrRireki.setGyoumuKousinTime(sysTime);
        khShrRireki.setZeitekiazukarikinkjumu(C_UmuKbn.NONE);
        khShrRireki.setShrtysykurikosiyouhi(C_YouhiKbn.HUYOU);

        BizPropertyInitializer.initialize(khShrRireki);
    }

    private void insertKiharaikomipInfo(Integer pKihrkpssrrkrenno) {

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = uiBean.getKykKihon().createKihrkmpSeisanRireki();

        kihrkmpSeisanRireki.setRenno(pKihrkpssrrkrenno);
        kihrkmpSeisanRireki.setHenkousikibetukey(sikibetuKey);
        kihrkmpSeisanRireki.setKouryokuhasseiymd(sysDate);
        kihrkmpSeisanRireki.setKihrkpssnaiyoukbn(uiBean.getKihrkpssnaiyoukbn());
        kihrkmpSeisanRireki.setMisyuumikeikakbn(C_MisyuumikeikaKbn.BLNK);
        kihrkmpSeisanRireki.setRstuukasyu(C_Tuukasyu.BLNK);
        kihrkmpSeisanRireki.setYenkansanhenkankin(uiBean.getKihrkpYenkansanhenkankin());
        kihrkmpSeisanRireki.setTuityouk(uiBean.getKihrkpTuityouk());
        kihrkmpSeisanRireki.setYenkansantuityoukin(uiBean.getKihrkpYenkansantuityoukin());
        kihrkmpSeisanRireki.setZeimukwsratekjnymd(uiBean.getKihrkpZeimukwsratekjnymd());
        kihrkmpSeisanRireki.setZeimukwsrate(uiBean.getKihrkpZeimukwsrate());
        kihrkmpSeisanRireki.setGyoumuKousinKinou(functionId);
        kihrkmpSeisanRireki.setGyoumuKousinsyaId(userId);
        kihrkmpSeisanRireki.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(kihrkmpSeisanRireki);
    }

    private void updateKariukekin(IT_Kariukekin pKariukekin, BizDate pKrkseisandenymd) {

        pKariukekin.setSeisandenymd(pKrkseisandenymd);
        pKariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
        pKariukekin.setGyoumuKousinKinou(functionId);
        pKariukekin.setGyoumuKousinsyaId(userId);
        pKariukekin.setGyoumuKousinTime(sysTime);
    }

    private void insertKariukekin(Integer pKrkno, BizDate pKrkseisandenymd) {

        IT_Kariukekin kariukekin = uiBean.getKykKihon().createKariukekin();

        kariukekin.setKrkno(pKrkno);
        kariukekin.setKrkkeijyoymd(sysDate);
        kariukekin.setKrkgk(uiBean.getKajyouukeirekngk());
        kariukekin.setHasseidenymd(pKrkseisandenymd);
        kariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.BLNK);
        kariukekin.setKrkriyuukbn(C_KrkriyuuKbn.KAZYOUNYKN);
        kariukekin.setNyknaiyoukbn(C_NyknaiyouKbn.HOZENHENKOUYOUP);
        kariukekin.setNykkeiro(C_Nykkeiro.OTHER);
        kariukekin.setRyosyuymd(uiBean.getTuikahrkkinRyosyuymd());
        kariukekin.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        kariukekin.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        kariukekin.setGyoumuKousinKinou(functionId);
        kariukekin.setGyoumuKousinsyaId(userId);
        kariukekin.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(kariukekin);
    }

}
