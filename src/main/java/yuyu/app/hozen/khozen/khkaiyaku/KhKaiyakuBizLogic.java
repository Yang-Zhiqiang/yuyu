package yuyu.app.hozen.khozen.khkaiyaku;

import static yuyu.app.hozen.khozen.khkaiyaku.GenKhKaiyakuConstants.*;
import static yuyu.app.hozen.khozen.khkaiyaku.KhKaiyakuConstants.*;

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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khkaiyaku.dba.KhKaiyakuDao;
import yuyu.common.base.CTIParamBean;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.CheckMeigininNmKanji;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzHanteiAgUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakusei;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceTaskStart;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.direct.dscommon.CheckDsTorihikiService;
import yuyu.common.direct.dscommon.CheckKaiyakuUketuke;
import yuyu.common.direct.dscommon.GetTrhkServiceTourokuJyoukyouBean;
import yuyu.common.hozen.khcommon.CheckFatca;
import yuyu.common.hozen.khcommon.CheckKaiyaku;
import yuyu.common.hozen.khcommon.CheckKaiyakuBean;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTblBean;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdate;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateBean;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.EditSouhuannaiParam;
import yuyu.common.hozen.khcommon.EditTtdkKanryouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiSyoriKengen;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuOutBean;
import yuyu.common.hozen.khcommon.KeisanHtyKeihi;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanSiharaibi;
import yuyu.common.hozen.khcommon.KeisanTienRisoku;
import yuyu.common.hozen.khcommon.KhCheckKouza;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenEdit;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetDattai;
import yuyu.common.hozen.setuibean.SetHaitoukin;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetHituyouSyorui;
import yuyu.common.hozen.setuibean.SetHosyou;
import yuyu.common.hozen.setuibean.SetKariukekin;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtil;
import yuyu.common.hozen.setuibean.SetKhTkshrSiharaiKouza;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetSonotaTk;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetTokusin;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_FatcatghtkekKbn;
import yuyu.def.classification.C_FiSiyouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KaiyksyorikahiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykdrDouiYouhiKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_RatesyutokukekkaKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IW_KhKaiyakuWk;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.DBAOutputReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.PdfBuilder;

import com.lowagie.text.pdf.PdfReader;

/**
 * 解約 のビジネスロジックです。
 */
public class KhKaiyakuBizLogic {

    private String functionId;

    private String userId;

    private BizDate sysDate;

    private String sysTime;

    private String sikibetuKey;

    private final KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKaiyakuUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KhKaiyakuDao khKaiyakuDao;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private OutputReport outputReport;

    @Inject
    private GetSyoruittykymd getSyoruittykymd;

    @Inject
    private CommonDispImage commonDispImage;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private HozenPreReportRenkeiBean hozenPreReportRenkeiBean;

    @Inject
    private CTIParamBean ctiParamBean;

    void init() {
        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo()
            .getJimuTetuzukiCd());

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
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

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteikanriid);

        String syoNo = gyoumuKouteiInfo.getSyono();

        uiBean.setSyono(syoNo);

        setUiBeanOpen();

        checkKykSonzai(syoNo);

        checkYuukouJyoutai();

        checkTetudukiTyuui(syoNo);

        IW_KhKaiyakuWk khKaiyakuWk = hozenDomManager.getKhKaiyakuWk(kouteikanriid);
        if (khKaiyakuWk == null) {
            throw new CommonBizAppException(IW_KhKaiyakuWk.TABLE_NAME + " 取得エラー");
        }

        uiBean.setShnmkj(khKaiyakuWk.getShnmkj());
        uiBean.setShskyno(khKaiyakuWk.getShskyno());
        uiBean.setShsadr1kj(khKaiyakuWk.getShsadr1kj());
        uiBean.setShsadr2kj(khKaiyakuWk.getShsadr2kj());
        uiBean.setShsadr3kj(khKaiyakuWk.getShsadr3kj());
        uiBean.setKyksyaszknmkn(khKaiyakuWk.getKyksyaszknmkn());
        uiBean.setKyksyaszknmkj(khKaiyakuWk.getKyksyaszknmkj());
        uiBean.setKyksyaszkyno(khKaiyakuWk.getKyksyaszkyno());
        uiBean.setKyksyaszkadr1kj(khKaiyakuWk.getKyksyaszkadr1kj());
        uiBean.setKyksyaszkadr2kj(khKaiyakuWk.getKyksyaszkadr2kj());
        uiBean.setKyksyaszkadr3kj(khKaiyakuWk.getKyksyaszkadr3kj());
        uiBean.setSaikennmkj(khKaiyakuWk.getSaikennmkj());
        uiBean.setSaikennyno(khKaiyakuWk.getSaikennyno());
        uiBean.setSaikenadr1kj(khKaiyakuWk.getSaikenadr1kj());
        uiBean.setSaikenadr2kj(khKaiyakuWk.getSaikenadr2kj());
        uiBean.setSaikenadr3kj(khKaiyakuWk.getSaikenadr3kj());
        uiBean.setYenshrtkumu(khKaiyakuWk.getYenshrtkhkumu());
        uiBean.setInputshrhousiteikbn(khKaiyakuWk.getInputshrhousiteikbn());
        if (C_InputShrhousiteiKbn.FBSOUKIN.eq(khKaiyakuWk.getInputshrhousiteikbn())) {
            if (C_UmuKbn.ARI.eq(khKaiyakuWk.getYenshrtkhkumu())) {
                uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
            }
            else if (C_UmuKbn.NONE.eq(khKaiyakuWk.getYenshrtkhkumu())) {
                uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
            }
        }
        else {
            uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        }
        uiBean.setBankcd(khKaiyakuWk.getBankcd());
        uiBean.setSitencd(khKaiyakuWk.getSitencd());
        uiBean.setYokinkbn(khKaiyakuWk.getYokinkbn());
        uiBean.setKouzano(khKaiyakuWk.getKouzano());
        uiBean.setKzdoukbn(khKaiyakuWk.getKzdoukbn());
        uiBean.setKzmeiginmkn(khKaiyakuWk.getKzmeiginmkn());
        uiBean.setKykmnmeigibangou(khKaiyakuWk.getKykmnmeigibangou());
        uiBean.setUktmnmeigibangou(khKaiyakuWk.getUktmnmeigibangou());
        uiBean.setHonninkakninkekkakbn(khKaiyakuWk.getHonninkakninkekkakbn());
        uiBean.setKanryotuutioutkbn(khKaiyakuWk.getKanryotuutioutkbn());
        uiBean.setZenkaisyorikekkakbn(khKaiyakuWk.getZenkaisyorikekkakbn());
        uiBean.setKaiyakujiyuu(khKaiyakuWk.getKaiyakujiyuu());
        uiBean.setSkssakuseiymd(khKaiyakuWk.getSkssakuseiymd());
        uiBean.setSoukinsakikbn(khKaiyakuWk.getSoukinsakikbn());

        checkSaikensyaKaiyaku();

        checkKykSyaDairikenDouiken();

        CheckKaiyakuBean checkKaiyakuBean = SWAKInjector.getInstance(CheckKaiyakuBean.class);
        checkKaiyaku(CheckKaiyaku.GAMENBUNRUI_STARTINPUTCONTENTS, checkKaiyakuBean);

        setUiBean();

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);

        setProgressHistory.exec(uiBean);

        setSyokiKoumoku();

        hanteiYenTkTekiyoUmu();

        BizDate soruittykymd;
        if (khKaiyakuWk.getSyoruiukeymd() == null) {
            soruittykymd = getSyoruittykymd.exec(kouteikanriid, C_SyoruiCdKbn.KK_KAIYAKU_SKS);
        }
        else {
            soruittykymd = khKaiyakuWk.getSyoruiukeymd();
        }
        uiBean.setSyoruiukeymd(soruittykymd);

        if (C_InputShrhousiteiKbn.FBSOUKIN.eq(khKaiyakuWk.getInputshrhousiteikbn()) &&
            C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
            uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
        }

        checkFatcaKakuninYouhi(syoNo);

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                MessageId.WIC0001, uiBean.getZenkaisyorikekkakbn().getContent());
        }
    }

    void pushNyuuryokuBL() {

        BizPropertyInitializer.initialize(uiBean);

        String syoNo = uiBean.getVkihnsyono();
        uiBean.setSyono(syoNo);

        setUiBeanOpen();

        checkKykSonzai(syoNo);

        checkYuukouJyoutai();

        checkTetudukiTyuui(syoNo);

        checkSaikensyaKaiyaku();

        checkKykSyaDairikenDouiken();

        CheckKaiyakuBean checkKaiyakuBean = SWAKInjector.getInstance(CheckKaiyakuBean.class);
        checkKaiyaku(CheckKaiyaku.GAMENBUNRUI_INPUTKEY, checkKaiyakuBean);

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU);

        setUiBean();

        setSyokiKoumoku();

        hanteiYenTkTekiyoUmu();

        uiBean.setSyoruiukeymd(BizDate.getSysDate());

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);
        hanteiSyoriKengen.exec();

        checkFatcaKakuninYouhi(syoNo);
    }

    void pushSyoukaiBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }

        sysDate = BizDate.getSysDate();

        uiBean.setKaiykymd(uiBean.getSyoruiukeymd());

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getKyktuukasyu());
        uiBean.setSyucurrencytype(syuCurrencyType);

        C_FiSiyouKbn fiSiyouKbn  = C_FiSiyouKbn.BLNK;

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) ||
            !C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            if (uiBean.getSyoruiukeymd() == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_KAIYAKUSYORINYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EIA0037,
                    MessageUtil.getMessage(DDID_KAIYAKUSYORINYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            uiBean.setYuuyokkntyoukaumu(C_UmuKbn.NONE);
            IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(uiBean.getSyono());

            if (!C_Hrkkaisuu.ITIJI.eq(uiBean.getHrkkaisuu())) {
                boolean checkYuuyokkngaiFig = true;
                SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);
                setYuuyokknmanryobi.exec(uiBean.getSyono(), ansyuKihon.getJkipjytym());

                if (C_YuukousyoumetuKbn.SYOUMETU.eq(uiBean.getKykKihon().getKykSyouhns().get(0).getYuukousyoumetukbn())) {

                    checkYuuyokkngaiFig = false;

                    if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), setYuuyokknmanryobi.getTksnYuuyokknMnrybi()) ==
                        BizDateUtil.COMPARE_LESSER || BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(),
                            setYuuyokknmanryobi.getTksnYuuyokknMnrybi()) == BizDateUtil.COMPARE_EQUAL) {
                        throw new BizLogicException(MessageId.EIA1064);
                    }
                }
                else {
                    CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
                    checkYuuyokkngaiFig = checkYuuyokkngai.exec(uiBean.getSyono(), uiBean.getSyoruiukeymd());

                    if (!checkYuuyokkngaiFig) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, MessageId.WIA0007,
                            MessageUtil.getMessage(DDID_KAIYAKUSYORINYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
                    }
                }

                if (!checkYuuyokkngaiFig) {

                    uiBean.setKaiykymd(setYuuyokknmanryobi.getSyoumetubi());
                    uiBean.setSyoumetuymd(setYuuyokknmanryobi.getSyoumetubi());
                    uiBean.setYuuyokkntyoukaumu(C_UmuKbn.ARI);
                }
            }

            CheckKaiyakuBean checkKaiyakuBean = SWAKInjector.getInstance(CheckKaiyakuBean.class);
            checkKaiyakuBean.setSyoruiukeYmd(uiBean.getKaiykymd());
            checkKaiyakuBean.setSyukykYmd(uiBean.getSyukykymd());
            checkKaiyakuBean.setYendthnkYmd(uiBean.getYendthnkymd());
            checkKaiyakuBean.setSyoriYmd(sysDate);
            checkKaiyakuBean.setKykKihon(uiBean.getKykKihon());
            checkKaiyakuBean.setAnsyuKihon(ansyuKihon);

            checkKaiyaku(CheckKaiyaku.GAMENBUNRUI_INPUTCONTENTS, checkKaiyakuBean);

            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
                Boolean isMRFAccount = checkMrfAccount();

                if (isMRFAccount == true) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WBA1006);
                }
            }

            List<IT_KykSyaHenkouRireki> kykSyaHenkouRirekiList =
                hozenDomManager.getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(uiBean.getSyono(), C_Meigihnkjiyuu.KYK);

            if (kykSyaHenkouRirekiList.size() > 0) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, MessageId.WIA1016);
            }

            if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                C_ErrorKbn errorKbn = getKawaseRate.exec(
                    uiBean.getKaiykymd(), C_KawaserateSyuruiKbn.KOUJIKAWASERATE, uiBean.getKyktuukasyu(),
                    C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.SYUKKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.YOU);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException("為替レート取得が実行できませんでした。");
                }

                uiBean.setYenshrratetekiymd(getKawaseRate.getKwsrateKjYmd());
                uiBean.setYenshrrate(getKawaseRate.getKawaserate());
                uiBean.setShrkyktuukasyu(uiBean.getKyktuukasyu());
                uiBean.setKiykhrstousyenshrratetkymd(getKawaseRate.getKwsrateKjYmd());
                uiBean.setKiykhrstousyenshrratete(getKawaseRate.getKawaserate());
                uiBean.setKiykhrstousshrkyktuukasyu(uiBean.getKyktuukasyu());
                uiBean.setKwsratekjymd(getKawaseRate.getKwsrateKjYmd());
                uiBean.setKawaseRate(getKawaseRate.getKawaserate());

                GetKawaseRate getKawaseRateGk = SWAKInjector.getInstance(GetKawaseRate.class);

                C_ErrorKbn errorKbnGk  = getKawaseRateGk.exec(
                    uiBean.getKaiykymd(), C_KawaserateSyuruiKbn.KOUJIKAWASERATE, uiBean.getKyktuukasyu(),
                    C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.YOU);
                if (C_ErrorKbn.ERROR.eq(errorKbnGk)) {
                    throw new CommonBizAppException("為替レート取得が実行できませんでした。");
                }

                uiBean.setSntshrgkssgikshrratetekiymd(getKawaseRateGk.getKwsrateKjYmd());
                uiBean.setSntshrgkssgikshrrate(getKawaseRateGk.getKawaserate());
                uiBean.setSntshrgkssgikshrkyktuukasyu(uiBean.getKyktuukasyu());
            }

            KeisanKaiyakuBean keisanKaiyakuBean = SWAKInjector.getInstance(KeisanKaiyakuBean.class);
            KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);

            keisanKaiyakuBean.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            keisanKaiyakuBean.setKaiykymd(uiBean.getKaiykymd());
            keisanKaiyakuBean.setYenshrkwsrate(uiBean.getYenshrrate());
            keisanKaiyakuBean.setGkshrkwsrate(uiBean.getSntshrgkssgikshrrate());
            keisanKaiyakuBean.setKaiyakujiyuu(uiBean.getKaiyakujiyuu());

            C_ErrorKbn keisanKaiyakuseisankinErrorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
                KeisanCommonKaiyaku.KINOUBUNRUI_ONLINE, uiBean.getKykKihon(), sysDate, keisanKaiyakuBean);

            if (C_ErrorKbn.ERROR.eq(keisanKaiyakuseisankinErrorKbn)) {
                throw new CommonBizAppException(keisanCommonKaiyaku.getErrorMessage());
            }

            KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
            fiSiyouKbn = keisanCommonKaiyakuOutBean.getFiSiyouKbn();
            C_RatesyutokukekkaKbn ratesyutokukekkakbn = keisanCommonKaiyakuOutBean.getZeimuRatesyutokukekkaKbn();

            uiBean.setKaiyakuhr(keisanCommonKaiyakuOutBean.getKaiyakuHr());
            uiBean.setKaiyakuhryen(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen());
            uiBean.setZeimukaiyakuhryen(keisanCommonKaiyakuOutBean.getKaiyakuHrYen());
            uiBean.setShrsyousaikaiyakuhr(keisanCommonKaiyakuOutBean.getKaiyakuHr());
            if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                uiBean.setShrsyousaijpykaiyakuhr(keisanCommonKaiyakuOutBean.getKaiyakuHrYen());
            }
            else {
                uiBean.setShrsyousaijpykaiyakuhr(keisanCommonKaiyakuOutBean.getKaiyakuHr());
            }
            uiBean.setKiykhrsyousaikiykhrtogoukei(keisanCommonKaiyakuOutBean.getKaiyakuHr());
            uiBean.setKiykhrsyousaikaiyakuhr(keisanCommonKaiyakuOutBean.getKaiyakuHr());
            uiBean.setKiykhrsyousaiptumitatekin(keisanCommonKaiyakuOutBean.getPtumitatekin());
            uiBean.setKiykhrsyousaisjkkktyouseigk(keisanCommonKaiyakuOutBean.getSjkkkTyouseiGk());
            uiBean.setKiykhrsyousaisjkkktyouseirt(keisanCommonKaiyakuOutBean.getSjkkkTyouseiRitu().multiply(100));
            uiBean.setKiykhrsyousaikaiyakukjgk(keisanCommonKaiyakuOutBean.getKaiyakuKjgk().multiply(-1));
            uiBean.setKiykhrsyousaikaiyakukjritu(keisanCommonKaiyakuOutBean.getKaiyakuKjRitu().multiply(100));
            uiBean.setSjkkktyouseirt(keisanCommonKaiyakuOutBean.getSjkkkTyouseiRitu());
            uiBean.setSijyoukakakutyouseiyouriritu(keisanCommonKaiyakuOutBean.getKaiyakusjkkktyouseiriritu());
            uiBean.setKaiyakukjgk(keisanCommonKaiyakuOutBean.getKaiyakuKjgk());
            uiBean.setKaiyakukoujyoritu(keisanCommonKaiyakuOutBean.getKaiyakuKjRitu());
            uiBean.setShrgkgoukeisyoukai(keisanCommonKaiyakuOutBean.getShrgkkeigk());
            uiBean.setJpyshrgkgoukeisyoukai(keisanCommonKaiyakuOutBean.getShrgkkeiYen());
            uiBean.setKaiyakuhrgoukei(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk());
            uiBean.setYenkiykhrgoukei(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen());
            uiBean.setSonotashrgk(keisanCommonKaiyakuOutBean.getSonotashrgkgk());
            uiBean.setYensonotashrgk(keisanCommonKaiyakuOutBean.getSonotashrgkYen());
            uiBean.setMikeikap(keisanCommonKaiyakuOutBean.getMikeikapGk());
            uiBean.setYenkamikeikap(keisanCommonKaiyakuOutBean.getMikeikapYen());
            if (C_UmuKbn.ARI.eq(keisanCommonKaiyakuOutBean.getZennoumijyuutouFlg())) {
                uiBean.setZennouseisankin(BizCurrency.optional());
                uiBean.setYenkazennouseisankgk(BizCurrency.optional());
            }
            else {
                uiBean.setZennouseisankin(keisanCommonKaiyakuOutBean.getZennouseisankGk());
                uiBean.setYenkazennouseisankgk(keisanCommonKaiyakuOutBean.getZennouseisankYen());
            }
            uiBean.setYenazukarikinkykhnkmikeikap(keisanCommonKaiyakuOutBean.getAzukariGanrikinYen());
            uiBean.setYenkahaitoukin(keisanCommonKaiyakuOutBean.getHaitoukinYen());
            uiBean.setYentkbthaitoukin(keisanCommonKaiyakuOutBean.getYentkbthaitoukin());
            uiBean.setYenkakrkgk(keisanCommonKaiyakuOutBean.getKrkgkYen());
            uiBean.setSntshrgksssonotashrgk(keisanCommonKaiyakuOutBean.getSonotashrgkgk());
            uiBean.setSntshrgkssyensonotashrgk(keisanCommonKaiyakuOutBean.getSonotashrgkYen());
            uiBean.setSntshrgkssyenkamikeikap(keisanCommonKaiyakuOutBean.getMikeikapYen());
            if (C_UmuKbn.ARI.eq(keisanCommonKaiyakuOutBean.getZennoumijyuutouFlg())) {
                uiBean.setSntshrgkssyenzennousisnkgk(BizCurrency.optional(BizCurrencyTypes.YEN));
            }
            else {
                uiBean.setSntshrgkssyenzennousisnkgk(keisanCommonKaiyakuOutBean.getZennouseisankYen());
            }
            uiBean.setSntshrgkssyenazukarikin(keisanCommonKaiyakuOutBean.getAzukariGanrikinYen());
            uiBean.setSntshrgkssyenhaitoukin(keisanCommonKaiyakuOutBean.getHaitoukinYen());
            uiBean.setSntshrgkssyentkbthaitoukin(keisanCommonKaiyakuOutBean.getYentkbthaitoukin());
            uiBean.setSntshrgkssyenkakrkgk(keisanCommonKaiyakuOutBean.getKrkgkYen());
            uiBean.setKiykhrstousyenkiykhrgoukei(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen());
            uiBean.setKiykhrstouskaiyakuhrgoukei(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk());
            uiBean.setKiykhrstouskaiyakuhrkin(keisanCommonKaiyakuOutBean.getKaiyakuHr());
            uiBean.setKiykhrstousmikeikap(keisanCommonKaiyakuOutBean.getMikeikapGk());
            if (C_UmuKbn.ARI.eq(keisanCommonKaiyakuOutBean.getZennoumijyuutouFlg())) {
                uiBean.setKiykhrstouszennouseisankin(BizCurrency.optional(BizCurrencyTypes.YEN));
            }
            else {
                uiBean.setKiykhrstouszennouseisankin(keisanCommonKaiyakuOutBean.getZennouseisankGk());
            }
            uiBean.setKiykhrstouskykhnkkaiyakuhr(keisanCommonKaiyakuOutBean.getAzukariGanrikingk());
            uiBean.setAzukarikinkykhnkkaiyakuhr(keisanCommonKaiyakuOutBean.getAzukariGanrikingk());
            uiBean.setMikeikaPJyutouYM(keisanCommonKaiyakuOutBean.getMikeikaPjyutouYm());
            uiBean.setMikeikaPJyutouKaisuuY(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuY());
            uiBean.setMikeikaPJyutouKaisuuM(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuM());
            uiBean.setMiKeikaPBeans(keisanCommonKaiyakuOutBean.getMiKeikaPBeans());
            if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                uiBean.setYendthnkshrgkgoukeisyoukai(keisanCommonKaiyakuOutBean.getShrgkkeiYen());
                uiBean.setYendthnkgstszeigk(keisanCommonKaiyakuOutBean.getJpygstszeigk());
                uiBean.setDispyendthnkgstszeigk(keisanCommonKaiyakuOutBean.getJpygstszeigk().multiply(-1));
                uiBean.setYendthnkGststaisyousaeki(keisanCommonKaiyakuOutBean.getJpykaShrYenGsTsTaisyouSaeki());
            }
            else {
                uiBean.setYendthnkshrgkgoukeisyoukai(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setYendthnkgstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setDispyendthnkgstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setYendthnkGststaisyousaeki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }
            uiBean.setYendthnkmikeikap(keisanCommonKaiyakuOutBean.getMikeikapYen());
            if (C_UmuKbn.ARI.eq(keisanCommonKaiyakuOutBean.getZennoumijyuutouFlg())) {
                uiBean.setYendthnkzennouseisankin(BizCurrency.optional(BizCurrencyTypes.YEN));
            }
            else {
                uiBean.setYendthnkzennouseisankin(keisanCommonKaiyakuOutBean.getZennouseisankYen());
            }
            uiBean.setYendthnkkaiyakuhr(keisanCommonKaiyakuOutBean.getYendthnkkaiyakuhr());
            uiBean.setYendthnkhaitoukin(keisanCommonKaiyakuOutBean.getHaitoukinYen());
            uiBean.setYendthnktkbthaitoukin(keisanCommonKaiyakuOutBean.getYentkbthaitoukin());
            uiBean.setSonotaseisan(keisanCommonKaiyakuOutBean.getSonotaseisan());
            uiBean.setYendthnkkrkgk(keisanCommonKaiyakuOutBean.getKrkgkYen());
            uiBean.setSeg1cd(keisanCommonKaiyakuOutBean.getSegcdOne());
            uiBean.setSeg2cd(keisanCommonKaiyakuOutBean.getSegcdTwo());

            if (C_RatesyutokukekkaKbn.ERROR.eq(ratesyutokukekkakbn)) {
                uiBean.setDispgstszeigkcalckahimongon(KEISAN_HUNOU);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getGsbunritaisyou())) {
                if (!C_RatesyutokukekkaKbn.ERROR.eq(ratesyutokukekkakbn)) {
                    uiBean.setDispgstszeigk(keisanCommonKaiyakuOutBean.getGstszeigk().multiply(-1));
                }
                uiBean.setDispyengstszeigk(keisanCommonKaiyakuOutBean.getJpygstszeigk().multiply(-1));
            }
            else {
                uiBean.setDispgstszeigk(BizCurrency.valueOf(0,syuCurrencyType));
                uiBean.setDispyengstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }

            uiBean.setGstszeigk(keisanCommonKaiyakuOutBean.getGstszeigk());
            uiBean.setJpygstszeigk(keisanCommonKaiyakuOutBean.getJpygstszeigk());
            uiBean.setGaikaShrjiYengstszeigk(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigk());
            uiBean.setGaikaShrjiYengstszeigknationaltax(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkKokuz());
            uiBean.setJpyShrjiYengstszeigknationaltax(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkKokuz());
            uiBean.setGaikaShrjiYengstszeigklocaltax(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkTihouz());
            uiBean.setJpyShrjiYengstszeigklocaltax(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkTihouz());
            uiBean.setGaikaShrjiGsbunritaisyou(keisanCommonKaiyakuOutBean.getGaikaGsBunriTaisyouFlag());
            uiBean.setJpyShrjiGsbunritaisyou(keisanCommonKaiyakuOutBean.getJpyGsBunriTaisyouFlag());
            uiBean.setGaikaShrjiYengststaisyousaeki(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsTaisyouSaeki());
            uiBean.setJpyShrjiYengststaisyousaeki(keisanCommonKaiyakuOutBean.getJpykaShrYenGsTsTaisyouSaeki());
            uiBean.setRatesyutokukekkakbn(keisanCommonKaiyakuOutBean.getZeimuRatesyutokukekkaKbn());
            uiBean.setZeimukwsratekjnymd(keisanCommonKaiyakuOutBean.getZeimuRatesyutokuYmd());
            uiBean.setZeimukwsrate(keisanCommonKaiyakuOutBean.getZeimukwsrate());
            if (C_UmuKbn.ARI.eq(uiBean.getGaikaShrjiGsbunritaisyou())) {
                uiBean.setZeimukyktuukasyu(uiBean.getKyktuukasyu());
            }

            uiBean.setKeisanKhGensenYenW(keisanCommonKaiyakuOutBean.getGensengkYenkaiyakuhr());
            uiBean.setGaikaShrjiYenhtykeihi(keisanCommonKaiyakuOutBean.getGaikaShrYenHtyKeihi());
            uiBean.setJpyShrjiYenhtykeihi(keisanCommonKaiyakuOutBean.getJpyShrjiYenhtykeihi());
            uiBean.setPtumitatekinssptumitatekin(keisanCommonKaiyakuOutBean.getPtumitatekin());
            uiBean.setTeiritutmttkngk(keisanCommonKaiyakuOutBean.getTeiriTutmttKngk());
            uiBean.setSisuurendoutmttkngk(keisanCommonKaiyakuOutBean.getSisuuRendouTmttKngkl());
            uiBean.setDisptienrskkisanymdnissuu(MIKEISANN);
            uiBean.setDispjptienrskkisanymdnissuu(MIKEISANN);
            uiBean.setDispyendttienrskksnbinissuu(MIKEISANN);

            if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                uiBean.setKaiyksyorikahikbn(C_KaiyksyorikahiKbn.KA);
            }
            else {
                if (BizDateUtil.compareYmd(uiBean.getKwsratekjymd(), uiBean.getKaiykymd()) == BizDateUtil.COMPARE_LESSER
                    || C_FiSiyouKbn.TJTSI.eq(fiSiyouKbn)) {
                    uiBean.setKaiyksyorikahikbn(C_KaiyksyorikahiKbn.HUKA);
                }
                else {
                    uiBean.setKaiyksyorikahikbn(C_KaiyksyorikahiKbn.KA);
                }
            }
            uiBean.setLastPJyuutouYm(keisanCommonKaiyakuOutBean.getLastpjytoym());

            uiBean.setKeisanCommonKaiyakuOutBean(keisanCommonKaiyakuOutBean);

            uiBean.setHaitouKanriNaiteiKakuteiKbn(keisanCommonKaiyakuOutBean.getKhHaitouKanriNaiteiKakuteiKbn());

            uiBean.setEditDshrTukiDKoumokuBean(keisanCommonKaiyakuOutBean.getEditDshrTukiDKoumokuBean());

            int kawaserateMinasiKbn;

            int compareResult = BizDateUtil.compareYmd(uiBean.getKwsratekjymd(), uiBean.getKaiykymd());

            if (compareResult == BizDateUtil.COMPARE_LESSER) {
                kawaserateMinasiKbn = KAWASERATE_MINASI;
            }
            else {
                kawaserateMinasiKbn = KAWASERATE_SEIJYOU;
            }

            if (kawaserateMinasiKbn == KAWASERATE_MINASI && !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, MessageId.WIA1003);
            }

            Integer syoruiUkeKyoyou = YuyuHozenConfig.getInstance().getSyoruiUkeKyoyou();
            BizDate syoruiUkeKyoyouDate = uiBean.getSyoruiukeymd().addDays(syoruiUkeKyoyou);

            if (BizDateUtil.compareYmd(sysDate, syoruiUkeKyoyouDate) != BizDateUtil.COMPARE_LESSER) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3,
                    MessageId.WIF1004,
                    MessageUtil.getMessage(DDID_KAIYAKUSYORINYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()),
                    syoruiUkeKyoyou.toString() + "日");
            }

            if ((C_UmuKbn.ARI.eq(uiBean.getGaikaShrjiGsbunritaisyou()) && uiBean.getGaikaShrjiYengststaisyousaeki()
                .compareTo(BizCurrency.valueOf(0, uiBean.getGaikaShrjiYengststaisyousaeki().getType())) > 0)
                || (C_UmuKbn.ARI.eq(uiBean.getJpyShrjiGsbunritaisyou()) && uiBean.getJpyShrjiYengststaisyousaeki()
                    .compareTo(BizCurrency.valueOf(0, uiBean.getJpyShrjiYengststaisyousaeki().getType())) > 0)) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, MessageId.WIF1019);
            }

            if (C_UmuKbn.ARI.eq(keisanCommonKaiyakuOutBean.getZennoumijyuutouFlg())) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                    MessageId.WIA1018,
                    KAIYAKU);

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                    MessageId.WIA1019,
                    KAIYAKU);
            }
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(uiBean.getSyusyouhncd());
        uiBean.setSyohinHanteiKbn(syohinHanteiKbn);

        if (C_UmuKbn.NONE.eq(uiBean.getYenshrtktekiumu())) {
            uiBean.setYenshrtkumu(C_UmuKbn.NONE);
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {
            uiBean.setKaiyksyorikahikbn(C_KaiyksyorikahiKbn.KA);
        }

        C_Kaiyakujiyuu kaiyakujiyuu = uiBean.getKaiyakujiyuu();

        if (C_Kaiyakujiyuu.KYKSB.eq(kaiyakujiyuu)) {
            uiBean.setDaisennintdkumukbn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setDaisennintdkumukbn(C_UmuKbn.NONE);
        }

        SetHituyouSyorui.exec(khozenCommonParam, uiBean);

        if (C_FiSiyouKbn.TJTSI.eq(fiSiyouKbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, MessageId.WIA1002);
        }


        C_KahiKbn telttdkkahikbn = C_KahiKbn.HUKA;
        String telttdkhukariyuu = "";
        if (!C_Kaiyakujiyuu.TUUJYOU.eq(uiBean.getKaiyakujiyuu())) {
            telttdkkahikbn = C_KahiKbn.HUKA;
            telttdkhukariyuu = MessageUtil.getMessage(MessageId.WIF1026);
        }
        else if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), sysDate) != BizDateUtil.COMPARE_EQUAL) {
            telttdkkahikbn = C_KahiKbn.HUKA;
            telttdkhukariyuu = MessageUtil.getMessage(MessageId.WIF1027);
        }
        else {
            CheckKaiyakuUketuke checkKaiyakuUketuke = SWAKInjector.getInstance(CheckKaiyakuUketuke.class);

            C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk(uiBean.getSyono());

            if (C_ErrorKbn.OK.eq(errorKbn)) {
                telttdkkahikbn = C_KahiKbn.KA;
                telttdkhukariyuu = "";
            }
            else {
                telttdkkahikbn = C_KahiKbn.HUKA;
                telttdkhukariyuu = checkKaiyakuUketuke.getMessage();
            }
        }

        uiBean.setTelttdkkahikbn(telttdkkahikbn);
        uiBean.setTelttdkhukariyuu(telttdkhukariyuu);

        CheckDsTorihikiService checkDsTorihikiService = SWAKInjector.getInstance(CheckDsTorihikiService.class);

        GetTrhkServiceTourokuJyoukyouBean getTrhkServiceTourokuJyoukyouBean = checkDsTorihikiService.getTrhkServiceTourokuJyoukyou(uiBean.getSyono());

        uiBean.setTokuteitrhkkztourokujk(getTrhkServiceTourokuJyoukyouBean.getDsKaiykServiceTourokuUmu());

        checkShrkingkAddMessage();

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);

        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro())) {
            uiBean.setPatternSoukinsakikbn(C_SoukinsakiKbn.PATTERN_SELECT);
        }
        else if (C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) {
            uiBean.setPatternSoukinsakikbn(C_SoukinsakiKbn.PATTERN_SELECT_TKSHKSHRKZ);
        }
    }

    void ctiOpenBL() {
        BizPropertyInitializer.initialize(uiBean);
        uiBean.setVkihnsyono(ctiParamBean.getSyono());
    }

    void pushKakuninBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }

        C_Kaiyakujiyuu kaiyakujiyuu = uiBean.getKaiyakujiyuu();

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) ||
            ((C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {
            if (C_Kaiyakujiyuu.KYKSB.eq(kaiyakujiyuu)) {
                if (BizUtil.isBlank(uiBean.getKyksyaszknmkn())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYASZKINFO_KYKSYASZKNMKN.getErrorResourceKey()));
                }

                if (!CheckKana.isKyokaMoji(uiBean.getKyksyaszknmkn())) {
                    throw new BizLogicException(MessageId.EBC0046,
                        MessageUtil.getMessage(DDID_KYKSYASZKINFO_KYKSYASZKNMKN.getErrorResourceKey()));
                }

                if (!CheckKana.isKyoyouKetaHankaku(uiBean.getKyksyaszknmkn(), uiBean.getKananmkyoyou())) {
                    throw new BizLogicException(MessageId.EIC0006,
                        MessageUtil.getMessage(DDID_KYKSYASZKINFO_KYKSYASZKNMKN.getErrorResourceKey()),
                        uiBean.getKananmkyoyou().toString());
                }

                if (BizUtil.isBlank(uiBean.getKyksyaszknmkj())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYASZKINFO_KYKSYASZKNMKJ.getErrorResourceKey()));
                }

                if (!CheckMeigininNmKanji.isCheckOK(uiBean.getKyksyaszknmkj(), C_Kojinhjn.KOJIN)) {
                    throw new BizLogicException(MessageId.EBC0046,
                        MessageUtil.getMessage(DDID_KYKSYASZKINFO_KYKSYASZKNMKJ.getErrorResourceKey()));
                }

                if (BizUtil.isBlank(uiBean.getKyksyaszkyno())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYASZKINFO2_KYKSYASZKYNO.getErrorResourceKey()));
                }

                if (BizUtil.isBlank(uiBean.getKyksyaszkadr1kj())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKSYASZKINFO2_KYKSYASZKADR1KJ.getErrorResourceKey()));
                }

                BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);

                BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(uiBean.getKyksyaszkadr1kj(),
                    uiBean.getKyksyaszkadr2kj(), uiBean.getKyksyaszkadr3kj());

                if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {
                    throw new BizLogicException(MessageId.EBA1003,
                        MessageUtil.getMessage(DDID_KYKSYASZKINFO2_KYKSYASZKADR1KJ.getErrorResourceKey()),
                        String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                        String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
                }
            }
            else if (C_Kaiyakujiyuu.SKS.eq(kaiyakujiyuu)) {
                BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);

                BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(uiBean.getSaikenadr1kj(),
                    uiBean.getSaikenadr2kj(), uiBean.getSaikenadr3kj());

                if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {
                    throw new BizLogicException(MessageId.EBA1003,
                        MessageUtil.getMessage(DDID_SAIKENINFO2_SAIKENADR1KJ.getErrorResourceKey()),
                        String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                        String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
                }

                if (C_KanryotuutioutKbn.GAIBU.eq(uiBean.getKanryotuutioutkbn())) {
                    throw new BizLogicException(MessageId.EIF1019);
                }
            }

            if (uiBean.getShrgkgoukeisyoukai().compareTo(
                BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) {
                if (uiBean.getYenshrtkumu() == null) {
                    throw new BizLogicException(MessageId.EBF1005,
                        MessageUtil.getMessage(DDID_YENSHRTKUMUINFO_YENSHRTKUMU.getErrorResourceKey()));
                }
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    uiBean.setShrtuukasyu(C_Tuukasyu.JPY);
                }
                else {
                    uiBean.setShrtuukasyu(uiBean.getKyktuukasyu());
                }

                if (C_UmuKbn.ARI.eq(uiBean.getYuuyokkntyoukaumu()) &&
                    !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu()) && C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {

                    throw new BizLogicException(MessageId.EIF1114);
                }

                if (C_InputShrhousiteiKbn.BLNK.eq(uiBean.getInputshrhousiteikbn())) {

                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_SIHARAIHOUHOU_INPUTSHRHOUSITEIKBN.getErrorResourceKey()));
                }

                if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu()) && !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                    if (C_Kaiyakujiyuu.TUUJYOU.eq(uiBean.getKaiyakujiyuu())
                        || C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {

                        C_ErrorKbn errorKbn = getKawaseRate.exec(uiBean.getKaiykymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE, uiBean.getVhsyusyukyktuukasyu(), C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            throw new BizLogicException(MessageId.EIA1013);
                        }

                    }
                    else if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {

                        C_ErrorKbn errorKbn = getKawaseRate.exec(uiBean.getKaiykymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE, uiBean.getVhsyusyukyktuukasyu(), C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTB, C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            throw new BizLogicException(MessageId.EIA1013);
                        }
                    }
                }

                if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {
                    if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn())) {
                        if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu()) ||
                            C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {
                            throw new BizLogicException(MessageId.EIA1066, uiBean.getKaiyakujiyuu().getContent());
                        }

                        if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu()) &&
                            C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {
                            throw new BizLogicException(MessageId.EIA1033);
                        }
                    }

                    if (C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn())) {
                        if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu()) ||
                            C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {
                            throw new BizLogicException(MessageId.EIA1074, uiBean.getKaiyakujiyuu().getContent());
                        }

                        if (!C_Tuukasyu.JPY.eq(uiBean.getTeikishrkinshrtuukasyu()) &&
                            C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                            throw new BizLogicException(MessageId.EIA1072, JPY_SIHARAI_MOUSIDE_NONE);
                        }

                        if (C_Tuukasyu.JPY.eq(uiBean.getTeikishrkinshrtuukasyu()) &&
                            C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {
                            throw new BizLogicException(MessageId.EIA1072, JPY_SIHARAI_MOUSIDE_ARI);
                        }
                    }

                    if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn()) ||
                        C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn())) {
                        if (!BizUtil.isBlank(uiBean.getBankcd()) ||
                            !BizUtil.isBlank(uiBean.getSitencd()) ||
                            !C_YokinKbn.BLNK.eq(uiBean.getYokinkbn()) ||
                            !BizUtil.isBlank(uiBean.getKouzano()) ||
                            !C_Kzdou.BLNK.eq(uiBean.getKzdoukbn()) ||
                            !BizUtil.isBlank(uiBean.getKzmeiginmkn())) {
                            throw new BizLogicException(MessageId.EBA0108, "口座情報");
                        }
                    }
                }

                if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {
                    KhCheckKouza khCheckKouza = SWAKInjector.getInstance(KhCheckKouza.class);
                    khCheckKouza.chkSoukinsakiKouza(uiBean, khozenCommonParam);
                    uiBean.setBanknmkj(khCheckKouza.getGinkouName());
                    uiBean.setSitennmkj(khCheckKouza.getShitenName());

                    if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) || C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
                    }
                    else {
                        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
                    }
                }
                else {
                    uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
                }

                if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {
                    if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu()) ||
                        C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {
                        if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                            throw new BizLogicException(MessageId.EIA1065, uiBean.getKaiyakujiyuu().getContent());
                        }
                    }
                }

                if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(uiBean.getInputshrhousiteikbn()) ||
                    C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) {
                    if (!BizUtil.isBlank(uiBean.getBankcd()) ||
                        !BizUtil.isBlank(uiBean.getSitencd()) ||
                        !C_YokinKbn.BLNK.eq(uiBean.getYokinkbn()) ||
                        !BizUtil.isBlank(uiBean.getKouzano()) ||
                        !C_Kzdou.BLNK.eq(uiBean.getKzdoukbn()) ||
                        !BizUtil.isBlank(uiBean.getKzmeiginmkn())) {
                        throw new BizLogicException(MessageId.EBA0108, "口座情報");
                    }

                    if (C_KanryotuutioutKbn.GAIBU.eq(uiBean.getKanryotuutioutkbn())) {
                        throw new BizLogicException(MessageId.EIF1019);
                    }
                }
            }

            if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_HONNININFO_HONNINKAKNINKEKKAKBN.getErrorResourceKey()));
            }

            CheckKaiyakuBean checkKaiyakuBean = SWAKInjector.getInstance(CheckKaiyakuBean.class);
            checkKaiyaku(CheckKaiyaku.GAMENBUNRUI_REFERENCE, checkKaiyakuBean);

            uiBean.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.NONE);

            Long pmnysymtjKns = khKaiyakuDao.getPMinyuuSyoumetuHasseijiKazeiRirekiCountBySyono(uiBean.getSyono());

            if (pmnysymtjKns != 0) {
                uiBean.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.ARI);
            }

            KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);

            C_UmuKbn gsbunritaisyouFlg = keisanCommonKaiyaku.setGsbunrikztaisyouFlg(uiBean.getYenshrtkumu(),
                uiBean.getJpyShrjiGsbunritaisyou(), uiBean.getGaikaShrjiGsbunritaisyou(), uiBean.getKyktuukasyu());

            uiBean.setGsbunritaisyouFlg(gsbunritaisyouFlg);
            uiBean.getKeisanCommonKaiyakuOutBean().setGsbunritaisyouFlg(gsbunritaisyouFlg);

            if (C_UmuKbn.NONE.eq(uiBean.getGsbunritaisyouFlg())) {
                if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu()) && !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                    if (C_Kaiyakujiyuu.TUUJYOU.eq(uiBean.getKaiyakujiyuu())
                        || C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {

                        C_ErrorKbn errorKbn = getKawaseRate.exec(uiBean.getKaiykymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE, uiBean.getVhsyusyukyktuukasyu(), C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new CommonBizAppException("為替レート取得が実行できませんでした。");
                        }
                    }
                    else if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {

                        C_ErrorKbn errorKbn = getKawaseRate.exec(uiBean.getKaiykymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE, uiBean.getVhsyusyukyktuukasyu(), C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTB, C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new CommonBizAppException("為替レート取得が実行できませんでした。");
                        }

                    }

                    uiBean.setZeimukwsratekjnymd(getKawaseRate.getKwsrateKjYmd());
                    uiBean.setZeimukwsrate(getKawaseRate.getKawaserate());
                    uiBean.setZeimukyktuukasyu(uiBean.getKyktuukasyu());

                    uiBean.getKeisanCommonKaiyakuOutBean().setZeimuRatesyutokuYmd(getKawaseRate.getKwsrateKjYmd());
                    uiBean.getKeisanCommonKaiyakuOutBean().setZeimukwsrate(getKawaseRate.getKawaserate());

                }
            }

            KeisanKaiyakuBean keisanKaiyakuBean = SWAKInjector.getInstance(KeisanKaiyakuBean.class);
            keisanKaiyakuBean.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            keisanKaiyakuBean.setKaiykymd(uiBean.getKaiykymd());
            keisanKaiyakuBean.setYenshrkwsrate(uiBean.getYenshrrate());
            keisanKaiyakuBean.setGkshrkwsrate(uiBean.getSntshrgkssgikshrrate());

            keisanCommonKaiyaku.keisanZeimuinfo(KeisanCommonKaiyaku.KINOUBUNRUI_ONLINE, uiBean.getKykKihon(), sysDate,
                uiBean.getShrtuukasyu(), uiBean.getKaiyakujiyuu(), keisanKaiyakuBean,
                uiBean.getKeisanCommonKaiyakuOutBean());

            KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
            uiBean.setSynykngk(keisanCommonKaiyakuOutBean.getSynykngk());
            uiBean.setHtykeihi(keisanCommonKaiyakuOutBean.getHtykeihi());
            uiBean.setKykhnkkaisuu(keisanCommonKaiyakuOutBean.getKykhnkkaisuu());
            uiBean.setYenshrkykhtykeihi(keisanCommonKaiyakuOutBean.getYenShrKykHtyKeihi());
            uiBean.setYengstszeigk(keisanCommonKaiyakuOutBean.getYengstszeigk());
            uiBean.setGststaisyousaeki(keisanCommonKaiyakuOutBean.getYengststaisyousaeki());

            KeisanSiharaibi kisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);
            BizDate siharaibi = kisanSiharaibi.exec(
                BizDate.getSysDate(),
                uiBean.getInputshrhousiteikbn(),
                uiBean.getShrtuukasyu(),
                uiBean.getBankcd());
            uiBean.setShrymd(siharaibi);
            uiBean.setShrhousiteikbn(kisanSiharaibi.getShrhousiteiKbn());

            if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                BizCurrency shrtienrsk = BizCurrency.optional(BizCurrencyTypes.YEN);
                BizDate shrtienrskStartYmd = null;
                Integer shrtienNissuu = null;

                if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhousiteikbn())) {

                    KeisanTienRisoku keisanTienRisoku = SWAKInjector.getInstance(KeisanTienRisoku.class);

                    keisanTienRisoku.exec(uiBean.getSyoruiukeymd(), siharaibi, uiBean.getYendthnkshrgkgoukeisyoukai());
                    shrtienrsk = keisanTienRisoku.getKeisanTienrisokuBean().getShrtienrsk();
                    shrtienrskStartYmd = uiBean.getSyoruiukeymd();
                    shrtienNissuu = keisanTienRisoku.getKeisanTienrisokuBean().getShrtienNissuu();
                }

                String jptienrskkisanymdnissuu = KhozenEdit.editTienRkksanhi(
                    uiBean.getShrhousiteikbn(), shrtienrsk, shrtienrskStartYmd, shrtienNissuu);

                BizCurrency shrgkGoukei = uiBean.getYendthnkshrgkgoukeisyoukai().add(doKingakuHenkan(shrtienrsk));

                uiBean.setDisptienrskkisanymdnissuu(jptienrskkisanymdnissuu);
                uiBean.setDispjptienrskkisanymdnissuu(jptienrskkisanymdnissuu);
                uiBean.setDispyendttienrskksnbinissuu(jptienrskkisanymdnissuu);
                uiBean.setShrtienrsk(shrtienrsk);
                uiBean.setJpyshrtienrsk(shrtienrsk);
                uiBean.setYendthnkshrtienrsk(shrtienrsk);
                uiBean.setSiharaitienrisokukisanbi(shrtienrskStartYmd);
                uiBean.setEnkatienrisokukisanbi(shrtienrskStartYmd);
                uiBean.setYendttienrskksnbi(shrtienrskStartYmd);
                uiBean.setTienrisokuhisuu(shrtienNissuu);
                uiBean.setEnkatienrisokuhisuu(shrtienNissuu);
                uiBean.setYendthnktienrsknissuu(shrtienNissuu);
                uiBean.setShrgkgoukeikakunin(shrgkGoukei);
                uiBean.setJpyshrgkgoukeikakunin(shrgkGoukei);
                uiBean.setYendthnkshrgkgoukeikakunin(shrgkGoukei);
            }
            else {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    BizCurrency shrtienrsk = BizCurrency.optional(BizCurrencyTypes.YEN);
                    BizDate shrtienrskStartYmd = null;
                    Integer shrtienNissuu = null;

                    if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhousiteikbn())) {

                        KeisanTienRisoku keisanTienRisoku = SWAKInjector.getInstance(KeisanTienRisoku.class);

                        keisanTienRisoku.exec(uiBean.getSyoruiukeymd(), siharaibi, uiBean.getJpyshrgkgoukeisyoukai());

                        shrtienrsk = keisanTienRisoku.getKeisanTienrisokuBean().getShrtienrsk();
                        shrtienrskStartYmd = uiBean.getSyoruiukeymd();
                        shrtienNissuu = keisanTienRisoku.getKeisanTienrisokuBean().getShrtienNissuu();
                    }

                    String jptienrskkisanymdnissuu = KhozenEdit.editTienRkksanhi(
                        uiBean.getShrhousiteikbn(), shrtienrsk, shrtienrskStartYmd, shrtienNissuu);

                    uiBean.setDispjptienrskkisanymdnissuu(jptienrskkisanymdnissuu);
                    uiBean.setJpyshrtienrsk(shrtienrsk);
                    uiBean.setEnkatienrisokukisanbi(shrtienrskStartYmd);
                    uiBean.setEnkatienrisokuhisuu(shrtienNissuu);
                    uiBean.setJpyshrgkgoukeikakunin(uiBean.getJpyshrgkgoukeisyoukai().add(doKingakuHenkan(shrtienrsk)));
                }

                BizCurrency kaiyakuhr = uiBean.getKaiyakuhr();
                BizCurrency shrtienrsk = BizCurrency.optional(kaiyakuhr.getType());
                BizDate shrtienrskStartYmd = null;
                Integer shrtienNissuu = null;

                if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhousiteikbn())) {

                    KeisanTienRisoku keisanTienRisoku = SWAKInjector.getInstance(KeisanTienRisoku.class);

                    keisanTienRisoku.exec(uiBean.getSyoruiukeymd(), siharaibi, uiBean.getShrgkgoukeisyoukai());

                    shrtienrsk = keisanTienRisoku.getKeisanTienrisokuBean().getShrtienrsk();
                    shrtienrskStartYmd = uiBean.getSyoruiukeymd();
                    shrtienNissuu = keisanTienRisoku.getKeisanTienrisokuBean().getShrtienNissuu();
                }

                String jptienrskkisanymdnissuu = KhozenEdit.editTienRkksanhi(
                    uiBean.getShrhousiteikbn(), shrtienrsk, shrtienrskStartYmd, shrtienNissuu);

                uiBean.setDisptienrskkisanymdnissuu(jptienrskkisanymdnissuu);
                uiBean.setShrtienrsk(shrtienrsk);
                uiBean.setSiharaitienrisokukisanbi(shrtienrskStartYmd);
                uiBean.setTienrisokuhisuu(shrtienNissuu);
                uiBean.setShrgkgoukeikakunin(uiBean.getShrgkgoukeisyoukai().add(doKingakuHenkan(shrtienrsk)));
            }

            CheckFatca checkFatca = SWAKInjector.getInstance(CheckFatca.class);

            if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {
                C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(
                    C_FatcatgKbn.KYKSZK,
                    uiBean.getKyksyaszknmkn(),
                    null,
                    C_Kyksei.BLNK);

                if (C_FatcatghtkekKbn.TAISYOU.eq(fatcatghtkekKbn)) {
                    if (checkFatca.getMsgList() != null) {
                        String msg = "";
                        String msgId = "";
                        for (int count = 0; count < checkFatca.getMsgList().size(); count++) {
                            msg = checkFatca.getMsgList().get(count);
                            msgId = BizUtil.getGeneralMessageId(checkFatca.getMsgIdList().get(count));
                            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, msgId, msg);
                        }
                    }
                }
            }

            BizCurrency zeimuGstsGkYen;

            if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) ||
                C_Tuukasyu.JPY.eq(uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0).getKyktuukasyu())) {

                zeimuGstsGkYen= uiBean.getZeimukaiyakuhryen();
            }
            else {
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                zeimuGstsGkYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, uiBean.getKaiyakuhr(),
                    uiBean.getZeimukwsrate(), C_HasuusyoriKbn.SUTE);
            }

            if (C_UmuKbn.NONE.eq(uiBean.getGsbunritaisyouFlg()) &&
                C_YuukousyoumetuKbn.YUUKOU.eq(uiBean.getKykKihon().getKykSyouhns().get(0).getYuukousyoumetukbn())) {
                if (C_Kaiyakujiyuu.TUUJYOU.eq(uiBean.getKaiyakujiyuu())
                    || C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {
                    if (zeimuGstsGkYen.compareTo(HYAKUMANEN) > 0
                        && (uiBean.getKykhnkkaisuu() > 0 ||
                            (uiBean.getKykhnkkaisuu() == 0 && uiBean.getSynykngk().subtract(uiBean.getHtykeihi())
                            .compareTo(BizCurrency.valueOf(0, uiBean.getSynykngk().getType())) > 0))) {

                        if (BizUtil.isBlank(uiBean.getKykmnmeigibangou())) {
                            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                                MessageId.WIA1010,
                                MessageUtil.getMessage(DDID_MNMEIGINOINFO_KYKMNMEIGIBANGOU.getErrorResourceKey()));
                        }
                        uiBean.setSiharaityousyosyuruikubun(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
                    }
                }
                else if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {
                    if (zeimuGstsGkYen.compareTo(HYAKUMANEN) > 0) {

                        if (BizUtil.isBlank(uiBean.getKykmnmeigibangou())) {
                            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                                MessageId.WIA1010,
                                MessageUtil.getMessage(DDID_MNMEIGINOINFO_KYKMNMEIGIBANGOU.getErrorResourceKey()));
                        }

                        if (BizUtil.isBlank(uiBean.getUktmnmeigibangou())) {
                            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                                MessageId.WIA1010,
                                MessageUtil.getMessage(DDID_MNMEIGINOINFO_UKTMNMEIGIBANGOU.getErrorResourceKey()));
                        }
                        uiBean.setSiharaityousyosyuruikubun(C_HtsiryosyuKbn.UKTRSHRTYOUSYO);
                    }
                }
            }
            else {
                uiBean.setSiharaityousyosyuruikubun(C_HtsiryosyuKbn.BLNK);
            }

            if (C_UmuKbn.NONE.eq(uiBean.getGsbunritaisyouFlg()) &&
                C_YuukousyoumetuKbn.SYOUMETU.eq(uiBean.getKykKihon().getKykSyouhns().get(0).getYuukousyoumetukbn()) &&
                C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(uiBean.getKykKihon().getKykSyouhns().get(0).getSyoumetujiyuu())) {
                if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {
                    if (zeimuGstsGkYen.compareTo(HYAKUMANEN) > 0 && (uiBean.getKykhnkkaisuu() == 0 &&
                        uiBean.getSynykngk().subtract(uiBean.getHtykeihi()).compareTo(
                            BizCurrency.valueOf(0, uiBean.getSynykngk().getType())) <= 0)) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                            MessageId.WIF1025);
                    }
                }
            }

            if (C_UmuKbn.NONE.eq(uiBean.getGsbunritaisyouFlg()) &&
                C_YuukousyoumetuKbn.YUUKOU.eq(uiBean.getKykKihon().getKykSyouhns().get(0).getYuukousyoumetukbn())) {
                if (C_Kaiyakujiyuu.TUUJYOU.eq(uiBean.getKaiyakujiyuu())
                    || C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {
                    if (zeimuGstsGkYen.compareTo(HYAKUMANEN) <= 0
                        || (zeimuGstsGkYen.compareTo(HYAKUMANEN) > 0 &&
                            (uiBean.getKykhnkkaisuu() == 0 && uiBean.getSynykngk().subtract(uiBean.getHtykeihi())
                            .compareTo(BizCurrency.valueOf(0, uiBean.getSynykngk().getType())) <= 0))) {

                        if (!BizUtil.isBlank(uiBean.getKykmnmeigibangou())) {
                            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                                MessageId.WIA1011,
                                MessageUtil.getMessage(DDID_MNMEIGINOINFO_KYKMNMEIGIBANGOU.getErrorResourceKey()));
                        }
                    }
                }
                else if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {
                    if (zeimuGstsGkYen.compareTo(HYAKUMANEN) <= 0
                        && !BizUtil.isBlank(uiBean.getKykmnmeigibangou())) {

                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                            MessageId.WIA1011,
                            MessageUtil.getMessage(DDID_MNMEIGINOINFO_KYKMNMEIGIBANGOU.getErrorResourceKey()));
                    }

                    if (zeimuGstsGkYen.compareTo(HYAKUMANEN) <= 0
                        && !BizUtil.isBlank(uiBean.getUktmnmeigibangou())) {

                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                            MessageId.WIA1011,
                            MessageUtil.getMessage(DDID_MNMEIGINOINFO_UKTMNMEIGIBANGOU.getErrorResourceKey()));
                    }
                }
            }
            else {
                if (!BizUtil.isBlank(uiBean.getKykmnmeigibangou())) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIA1011,
                        MessageUtil.getMessage(DDID_MNMEIGINOINFO_KYKMNMEIGIBANGOU.getErrorResourceKey()));
                }

                if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {
                    if (!BizUtil.isBlank(uiBean.getUktmnmeigibangou())) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                            MessageId.WIA1011,
                            MessageUtil.getMessage(DDID_MNMEIGINOINFO_UKTMNMEIGIBANGOU.getErrorResourceKey()));
                    }
                }
            }

            Boolean isMRFAccount = checkMrfAccount();

            if (isMRFAccount == true) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WBA1007);
            }

        }

        CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);
        checkProcessKekka.exec(
            uiBean.getSyorikekkakbn(),
            uiBean.getSyanaicommentkh(),
            uiBean.getSasimodosisakikbn());

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
            C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(
                uiBean.getSyono(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                    checkProcessKaishi.getBzGetProcessSummaryOutBean();
                throw new BizLogicException(MessageId.EIA1002,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }
        }

        if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu()) &&
            BizDateUtil.compareYmd(uiBean.getYendthnkymd(), uiBean.getSkssakuseiymd()) == BizDateUtil.COMPARE_GREATER) {
            if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {
                throw new BizLogicException(MessageId.EIA1023);
            }
            else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
                C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
                throw new BizLogicException(MessageId.EIA1023);
            }
        }

        if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
            C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
            if (C_UmuKbn.ARI.eq(uiBean.getKeisanCommonKaiyakuOutBean().getZennoumijyuutouFlg())) {

                throw new BizLogicException(MessageId.EIA1063, KAIYAKU);
            }
        }

        CheckFatca checkFatca = SWAKInjector.getInstance(CheckFatca.class);
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(
            C_FatcatgKbn.KYK,
            uiBean.getVkykskyknmkn(),
            uiBean.getVkykskykseiymd(),
            uiBean.getVkykskyksei());

        if (C_FatcatghtkekKbn.TAISYOU.eq(fatcatghtkekKbn)) {
            if (checkFatca.getMsgList() != null) {
                String msg = "";
                String msgId = "";
                for (int count = 0; count < checkFatca.getMsgList().size(); count++) {
                    msg = checkFatca.getMsgList().get(count);
                    msgId = BizUtil.getGeneralMessageId(checkFatca.getMsgIdList().get(count));
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, msgId, msg);
                }
            }
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);

        if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {

            if (!uiBean.getJpyShrjiYengststaisyousaeki().isOptional() &&
                !uiBean.getGaikaShrjiYengststaisyousaeki().isOptional()) {
                if ((C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) && uiBean.getJpyShrjiYengststaisyousaeki()
                    .compareTo(BizCurrency.valueOf(0, uiBean.getJpyShrjiYengststaisyousaeki().getType())) <= 0) ||
                    (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu()) && uiBean.getGaikaShrjiYengststaisyousaeki()
                        .compareTo(BizCurrency.valueOf(0, uiBean.getGaikaShrjiYengststaisyousaeki().getType())) <= 0)) {
                    messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3,
                        MessageId.WIF1019);
                }
            }
        }

        checkShrkingkRemoveMessage();

        messageManager.addMessageId(MessageId.QBA0001);

    }

    @Transactional
    void pushKukakuteiBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }
        else {
            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
            C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(
                uiBean.getSyono(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
            if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                    checkProcessKaishi.getBzGetProcessSummaryOutBean();
                throw new BizLogicException(MessageId.EIA1002,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }

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

            bzCommonLockProcess.lockProcess(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
            bzForceTaskStart.exec(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                C_KhkinouModeIdKbn.INPUT.getValue(),
                bzCommonLockProcess.getKouteiLockKey());
        }

        String syoNo = uiBean.getSyono();
        functionId = khozenCommonParam.getFunctionId();
        userId = khozenCommonParam.getUserID();
        sysTime = BizDate.getSysDateTimeMilli();
        sysDate = BizDate.getSysDate();

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

            sikibetuKey = khozenCommonParam.getSikibetuKey(syoNo);

            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
            tableMaintenanceUtil.backUp(syoNo, sikibetuKey);

            BizCurrency mikeikapKyktuuka;
            BizCurrency zennouseisankinKyktuuka;
            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinHanteiKbn() ||
                C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                mikeikapKyktuuka = uiBean.getYenkamikeikap();
                zennouseisankinKyktuuka = uiBean.getYenkazennouseisankgk();
            }
            else {
                mikeikapKyktuuka = uiBean.getMikeikap();
                zennouseisankinKyktuuka = uiBean.getZennouseisankin();
            }

            EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector
                .getInstance(EditKaiyakuTblUpdateBean.class);
            EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);

            editKaiyakuTblUpdateBean.setSyono(uiBean.getSyono());
            editKaiyakuTblUpdateBean.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            editKaiyakuTblUpdateBean.setKaiykymd(uiBean.getKaiykymd());
            editKaiyakuTblUpdateBean.setYenshrtkumu(uiBean.getYenshrtkumu());
            editKaiyakuTblUpdateBean.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());
            editKaiyakuTblUpdateBean.setKaiyakujiyuu(uiBean.getKaiyakujiyuu());
            editKaiyakuTblUpdateBean.setKaiyakuhrgoukei(uiBean.getKaiyakuhrgoukei());
            editKaiyakuTblUpdateBean.setKaiyakuhrgoukeiyen(uiBean.getYenkiykhrgoukei());
            editKaiyakuTblUpdateBean.setKaiyakuhr(uiBean.getKaiyakuhr());
            editKaiyakuTblUpdateBean.setKaiyakuhryen(uiBean.getShrsyousaijpykaiyakuhr());
            editKaiyakuTblUpdateBean.setYenshrrate(uiBean.getYenshrrate());
            editKaiyakuTblUpdateBean.setYenshrratetekiymd(uiBean.getYenshrratetekiymd());
            editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(uiBean.getKiykhrsyousaiptumitatekin());
            editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(uiBean.getKiykhrsyousaisjkkktyouseigk());
            editKaiyakuTblUpdateBean.setKaiyakukjgk(uiBean.getKaiyakukjgk());
            editKaiyakuTblUpdateBean.setSjkkktyouseiritu(uiBean.getSjkkktyouseirt());
            editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(uiBean.getSijyoukakakutyouseiyouriritu());
            editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(uiBean.getKaiyakukoujyoritu());
            editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(uiBean.getAzukarikinkykhnkkaiyakuhr());
            editKaiyakuTblUpdateBean.setShrtienrsk(uiBean.getShrtienrsk());
            editKaiyakuTblUpdateBean.setShrtienrskkisanymd(uiBean.getSiharaitienrisokukisanbi());
            editKaiyakuTblUpdateBean.setTienrsknissuu(uiBean.getTienrisokuhisuu());
            editKaiyakuTblUpdateBean.setJpyshrtienrsk(uiBean.getJpyshrtienrsk());
            editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(uiBean.getEnkatienrisokukisanbi());
            editKaiyakuTblUpdateBean.setJpytienrsknissuu(uiBean.getEnkatienrisokuhisuu());
            editKaiyakuTblUpdateBean.setGksonotashrgk(uiBean.getSonotashrgk());
            editKaiyakuTblUpdateBean.setJpysonotashrgk(uiBean.getYensonotashrgk());
            editKaiyakuTblUpdateBean.setGkshrrate(uiBean.getSntshrgkssgikshrrate());
            editKaiyakuTblUpdateBean.setGkshrratetekiymd(uiBean.getSntshrgkssgikshrratetekiymd());
            editKaiyakuTblUpdateBean.setJpymikeikap(uiBean.getYenkamikeikap());
            editKaiyakuTblUpdateBean.setMikeikap(mikeikapKyktuuka);
            editKaiyakuTblUpdateBean.setMikeikapjyutouym(uiBean.getMikeikaPJyutouYM());
            editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuuy(uiBean.getMikeikaPJyutouKaisuuY());
            editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuum(uiBean.getMikeikaPJyutouKaisuuM());
            editKaiyakuTblUpdateBean.setMiKeikaPBeanHrt(uiBean.getMiKeikaPBeans());
            editKaiyakuTblUpdateBean.setJpyzennouseisankgk(uiBean.getYenkazennouseisankgk());
            editKaiyakuTblUpdateBean.setZennouseisankgk(zennouseisankinKyktuuka);
            editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(uiBean.getYenazukarikinkykhnkmikeikap());
            editKaiyakuTblUpdateBean.setJpykariukekin(uiBean.getYenkakrkgk());
            editKaiyakuTblUpdateBean.setJpyhaitoukin(uiBean.getYenkahaitoukin());
            editKaiyakuTblUpdateBean.setJpytkbthaitoukin(uiBean.getYentkbthaitoukin());
            if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                editKaiyakuTblUpdateBean.setYendthnkhr(uiBean.getSonotaseisan());
                editKaiyakuTblUpdateBean.setJpygstszeigk(uiBean.getYendthnkgstszeigk());
            }
            else {
                editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                editKaiyakuTblUpdateBean.setJpygstszeigk(uiBean.getYengstszeigk());
            }

            editKaiyakuTblUpdateBean.setGstszeigk(uiBean.getGstszeigk());
            if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) || C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                editKaiyakuTblUpdateBean.setYengstszeigknationaltax(uiBean.getJpyShrjiYengstszeigknationaltax());
                editKaiyakuTblUpdateBean.setYengstszeigklocaltax(uiBean.getJpyShrjiYengstszeigklocaltax());
            }
            else {
                editKaiyakuTblUpdateBean.setYengstszeigknationaltax(uiBean.getGaikaShrjiYengstszeigknationaltax());
                editKaiyakuTblUpdateBean.setYengstszeigklocaltax(uiBean.getGaikaShrjiYengstszeigklocaltax());
            }
            editKaiyakuTblUpdateBean.setGsbunritaisyouflg(uiBean.getGsbunritaisyouFlg());
            editKaiyakuTblUpdateBean.setYengststaisyousaeki(uiBean.getGststaisyousaeki());
            editKaiyakuTblUpdateBean.setTeiritutmttkngk(uiBean.getTeiritutmttkngk());
            editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(uiBean.getSisuurendoutmttkngk());
            editKaiyakuTblUpdateBean.setShrgkkei(uiBean.getShrgkgoukeikakunin());
            editKaiyakuTblUpdateBean.setJpyshrgkgoukei(uiBean.getJpyshrgkgoukeikakunin());
            editKaiyakuTblUpdateBean.setZeimukwsrate(uiBean.getZeimukwsrate());
            editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(uiBean.getZeimukwsratekjnymd());
            editKaiyakuTblUpdateBean.setSynykngk(uiBean.getSynykngk());
            editKaiyakuTblUpdateBean.setHtykeihi(uiBean.getHtykeihi());
            editKaiyakuTblUpdateBean.setKykhnkkaisuu(uiBean.getKykhnkkaisuu());
            editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(uiBean.getYenshrkykhtykeihi());
            editKaiyakuTblUpdateBean.setShrymd(uiBean.getShrymd());
            editKaiyakuTblUpdateBean.setShrtuukasyu(uiBean.getShrtuukasyu());
            editKaiyakuTblUpdateBean.setShrhousiteikbn(uiBean.getShrhousiteikbn());
            editKaiyakuTblUpdateBean.setBankcd(uiBean.getBankcd());
            editKaiyakuTblUpdateBean.setSitencd(uiBean.getSitencd());
            editKaiyakuTblUpdateBean.setYokinkbn(uiBean.getYokinkbn());
            editKaiyakuTblUpdateBean.setKouzano(uiBean.getKouzano());
            editKaiyakuTblUpdateBean.setKzmeiginmkn(uiBean.getKzmeiginmkn());
            editKaiyakuTblUpdateBean.setKzsyuruikbn(uiBean.getKzsyuruikbn());
            editKaiyakuTblUpdateBean.setKzdoukbn(uiBean.getKzdoukbn());
            editKaiyakuTblUpdateBean.setKyksyaszknmkn(uiBean.getKyksyaszknmkn());
            editKaiyakuTblUpdateBean.setKyksyaszknmkj(uiBean.getKyksyaszknmkj());
            editKaiyakuTblUpdateBean.setKyksyaszkyno(uiBean.getKyksyaszkyno());
            editKaiyakuTblUpdateBean.setKyksyaszkadr1kj(uiBean.getKyksyaszkadr1kj());
            editKaiyakuTblUpdateBean.setKyksyaszkadr2kj(uiBean.getKyksyaszkadr2kj());
            editKaiyakuTblUpdateBean.setKyksyaszkadr3kj(uiBean.getKyksyaszkadr3kj());
            editKaiyakuTblUpdateBean.setSaikennmkj(uiBean.getSaikennmkj());
            editKaiyakuTblUpdateBean.setSaikennyno(uiBean.getSaikennyno());
            editKaiyakuTblUpdateBean.setSaikenadr1kj(uiBean.getSaikenadr1kj());
            editKaiyakuTblUpdateBean.setSaikenadr2kj(uiBean.getSaikenadr2kj());
            editKaiyakuTblUpdateBean.setSaikenadr3kj(uiBean.getSaikenadr3kj());
            editKaiyakuTblUpdateBean.setKykmnmeigibangou(uiBean.getKykmnmeigibangou());
            editKaiyakuTblUpdateBean.setUktmnmeigibangou(uiBean.getUktmnmeigibangou());
            editKaiyakuTblUpdateBean.setShrtysysyuruikbn(uiBean.getSiharaityousyosyuruikubun());
            editKaiyakuTblUpdateBean.setSeg1cd(uiBean.getSeg1cd());
            editKaiyakuTblUpdateBean.setSeg2cd(uiBean.getSeg2cd());

            IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(uiBean.getSyono());
            editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);
            editKaiyakuTblUpdateBean.setLastPJyuutouYm(uiBean.getLastPJyuutouYm());
            editKaiyakuTblUpdateBean.setNaiteikakuteikbn(uiBean.getHaitouKanriNaiteiKakuteiKbn());
            editKaiyakuTblUpdateBean.setEditDshrTukiDKoumokuBean(uiBean.getEditDshrTukiDKoumokuBean());

            editKaiyakuTblUpdate.exec(khozenCommonParam,
                uiBean.getKykKihon(),
                sysDate,
                editKaiyakuTblUpdateBean,
                tableMaintenanceUtil.getBakKykKihon());

            List<IT_KhDenpyoData> khDenpyoDataList = editKaiyakuTblUpdate.getKhDenpyoDatas();

            for (IT_KhDenpyoData khDenpyoData : khDenpyoDataList) {
                hozenDomManager.insert(khDenpyoData);
            }

            IT_KhFBSoukinData khFBSoukinData = editKaiyakuTblUpdate.getKhFBSoukinData();
            if (khFBSoukinData != null) {
                hozenDomManager.insert(khFBSoukinData);
            }

            IT_KhGaikaFBSoukinData khGaikaFBSoukinData = editKaiyakuTblUpdate.getKhGaikaFBSoukinData();
            if (khGaikaFBSoukinData != null) {
                hozenDomManager.insert(khGaikaFBSoukinData);
            }

            IT_KhDshrTuki khDshrTuki = editKaiyakuTblUpdate.getKhDshrTuki();
            if (khDshrTuki != null) {
                hozenDomManager.insert(khDshrTuki);
            }

            BT_SikinIdouRireki sikinIdouRireki = editKaiyakuTblUpdate.getSikinIdouRireki();
            if (sikinIdouRireki != null) {
                BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei = SWAKInjector.getInstance(
                    BzSikinIdouRirekiTblSakusei.class);
                bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblOne(sikinIdouRireki);
            }

            makeTetudukiRireki();

            editHokenKykIdouRirekiTbl(mikeikapKyktuuka, zennouseisankinKyktuuka);

            makeTyouhyou();
            hozenDomManager.update(uiBean.getKykKihon());

            if (uiBean.getYenkazennouseisankgk().compareTo(
                BizCurrency.valueOf(0, uiBean.getYenkazennouseisankgk().getType())) > 0 ||
                uiBean.getZennouseisankin().compareTo(
                    BizCurrency.valueOf(0, uiBean.getZennouseisankin().getType())) > 0) {
                hozenDomManager.update(editKaiyakuTblUpdate.getAnsyuKihon());
            }

        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
            IW_KhKaiyakuWk khKaiyakuWk = hozenDomManager.getKhKaiyakuWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());
            hozenDomManager.delete(khKaiyakuWk);
        }
        else if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()))) {
            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                makeIW_KhKaiyakuWk(GAMENSYORIKBN_CONFIRM);
            }
            else {
                updateIW_KhKaiyakuWk();
            }
        }

        doJikouteikanri();

        if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
            !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) ||
            C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {
            uiBean.getKykKihon().detach();
        }

        messageManager.addMessageId(MessageId.IAC0009);

    }

    void pushSeikyusyoSakuseiBL() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
        C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(
            uiBean.getSyono(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();
            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        if (C_UmuKbn.ARI.eq(uiBean.getJpyShrjiGsbunritaisyou()) ||
            C_UmuKbn.ARI.eq(uiBean.getGaikaShrjiGsbunritaisyou())) {
            uiBean.setGsbunritaisyouFlg(C_UmuKbn.ARI);
        }
        else {
            uiBean.setGsbunritaisyouFlg(C_UmuKbn.NONE);
        }

        KeisanHtyKeihi keisanHtyKeihi = SWAKInjector.getInstance(KeisanHtyKeihi.class);
        keisanHtyKeihi.exec(uiBean.getSyono(), uiBean.getKyktuukasyu());

        BizCurrency yenHtyKeihi = keisanHtyKeihi.getYenHtyKeihi();

        if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
            if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {
                uiBean.setSaeki(uiBean.getYendthnkshrgkgoukeisyoukai().subtract(yenHtyKeihi));
            }
            else {
                uiBean.setSaeki(uiBean.getYendthnkshrgkgoukeisyoukai().subtract(uiBean.getSonotaseisan()).subtract(yenHtyKeihi));
            }
        }
        else {
            if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {
                uiBean.setSaeki(uiBean.getJpyshrgkgoukeisyoukai().subtract(yenHtyKeihi)
                    .add(uiBean.getJpygstszeigk()));
            }
            else {
                uiBean.setSaeki(uiBean.getJpyshrgkgoukeisyoukai().subtract(uiBean.getYenkakrkgk())
                    .subtract(yenHtyKeihi).add(uiBean.getJpygstszeigk()));
            }
        }

        uiBean.setKykhnkkaisuu(keisanHtyKeihi.getKykSyaHenkouKaisuu());
        uiBean.setMynoSinkokutaisyouFlg(C_UmuKbn.NONE);

        if (C_UmuKbn.NONE.eq(uiBean.getGsbunritaisyouFlg())) {
            if (C_Kaiyakujiyuu.TUUJYOU.eq(uiBean.getKaiyakujiyuu())
                || C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {
                if (uiBean.getZeimukaiyakuhryen().compareTo(HYAKUMANEN) > 0 &&
                    ((uiBean.getKykhnkkaisuu() > 0) || (uiBean.getKykhnkkaisuu() == 0 &&
                    uiBean.getSaeki().compareTo(BizCurrency.valueOf(0, uiBean.getSaeki().getType())) > 0))) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5, MessageId.WIA1012);

                    uiBean.setMynoSinkokutaisyouFlg(C_UmuKbn.ARI);
                }
            }
            else if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {
                if (uiBean.getZeimukaiyakuhryen().compareTo(HYAKUMANEN) > 0) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5, MessageId.WIA1012);

                    uiBean.setMynoSinkokutaisyouFlg(C_UmuKbn.ARI);
                }
            }
        }

        checkShrkingkRemoveMessage();

        messageManager.addMessageId(MessageId.QIA0004);
    }

    @Transactional
    void pushKakuteiByskConfirmBL() {

        sysTime = BizDate.getSysDateTimeMilli();
        functionId = khozenCommonParam.getFunctionId();
        userId = khozenCommonParam.getUserID();
        sysDate = BizDate.getSysDate();

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
        C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(
            uiBean.getSyono(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();
            throw new BizLogicException(MessageId.EIA0120, DefaultDateFormatter.formatYMDZeroFill(
                bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean =
            SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(uiBean.getDaisennintdkumukbn());
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        hozenPreReportRenkeiBean.setSyoNo(uiBean.getSyono());
        hozenPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());
        hozenPreReportRenkeiBean.setSyoriComment("");
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);
        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);

        if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu()) ||
            C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {
            editSouhuannaiParam.setShsnmkj(uiBean.getShnmkj());
            editSouhuannaiParam.setShsyno(uiBean.getShskyno());
            editSouhuannaiParam.setShsadr1kj(uiBean.getShsadr1kj());
            editSouhuannaiParam.setShsadr2kj(uiBean.getShsadr2kj());
            editSouhuannaiParam.setShsadr3kj(uiBean.getShsadr3kj());
            editSouhuannaiParam.setKaiyakujiyuu(uiBean.getKaiyakujiyuu());
            editSouhuannaiParam.setGsbunritaisyouumukbn(uiBean.getGsbunritaisyouFlg());
        }
        else {
            editSouhuannaiParam.setKaiyakujiyuu(uiBean.getKaiyakujiyuu());
            editSouhuannaiParam.setGsbunritaisyouumukbn(uiBean.getGsbunritaisyouFlg());
        }

        if (C_UmuKbn.ARI.eq(uiBean.getYuuyokkntyoukaumu())) {
            editSouhuannaiParam.setHaraimodosikngk(uiBean.getJpyshrgkgoukeisyoukai());
            editSouhuannaiParam.setSyoumetuymd(uiBean.getSyoumetuymd());
        }
        editSouhuannaiParam.setMynosinkokutaisyouumukbn(uiBean.getMynoSinkokutaisyouFlg());

        if (uiBean.getShrgkgoukeisyoukai().compareTo(
            BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) {
            editSeikyuusyoParam.setShrumu(C_UmuKbn.ARI);
        }

        editSeikyuusyoParam.setKaiyakujiyuu(uiBean.getKaiyakujiyuu());
        editSeikyuusyoParam.setYuuyokkntyoukaumu(uiBean.getYuuyokkntyoukaumu());

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);
        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<C_SyoruiCdKbn>();

        if(C_UmuKbn.ARI.eq(uiBean.getYuuyokkntyoukaumu())){

            syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_SHIHARAI_SOUHU);
            syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_KAIYAKU_SKS);
            if (C_UmuKbn.ARI.eq(uiBean.getDaisennintdkumukbn())) {
                syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN);
            }
        }
        else {

            syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_KAIYAKU_SKSSOUHU);
            syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_KAIYAKU_SKS);
            if (C_UmuKbn.ARI.eq(uiBean.getDaisennintdkumukbn())) {
                syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN);
            }
        }
        C_SyoruiCdKbn[] syoruiCds = syoruiCdKbnLst.toArray(new C_SyoruiCdKbn[0]);

        khozenTyouhyouCtl.createTyouhyouTBL(
            khozenCommonParam,
            uiBean.getSyono(),
            syoruiCds,
            C_YouhiKbn.YOU);

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setReportKey(khozenTyouhyouCtl.getTyouhyouKey());

        uiBean.getBzWorkflowInfo().setKouteiKanriId(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());

        makeIW_KhKaiyakuWk(GAMENSYORIKBN_SKSCONFIRM);

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);
    }

    void printOut() {
        String tyhykey = uiBean.getReportKey();

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            outputReport.outputPDFByJoinKey(tyhykey);
        }
        else {
            if (C_UmuKbn.ARI.eq(uiBean.getMynoSinkokutaisyouFlg())) {
                DBAOutputReport dBAOutputReport = SWAKInjector.getInstance(DBAOutputReport.class);

                byte[] pdfByte = dBAOutputReport.getPdfImagesByJoinKeys(new String[] { tyhykey });

                String path = "";

                if (C_Kaiyakujiyuu.TUUJYOU.eq(uiBean.getKaiyakujiyuu())
                    || C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {
                    path = SWAK.getApplicationRootPath() + YuyuHozenConfig.getInstance().getMyNumberFilePath();
                }
                else if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {
                    path = SWAK.getApplicationRootPath() + YuyuHozenConfig.getInstance().getMyNumberKyksibouFilePath();
                }

                try {
                    PdfBuilder pdfBuilder = SWAKInjector.getInstance(PdfBuilder.class);

                    pdfBuilder.append(new PdfReader(pdfByte));
                    pdfBuilder.append(new PdfReader(path));

                    outputReport.outputJoinedPDFByBinary(pdfBuilder.toByteArray(), tyhykey);
                }

                catch (IOException e) {
                    throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));
                }
            }
            else {
                outputReport.outputPDFByJoinKey(tyhykey);
            }
        }
    }

    void pushModoruByConfirmBL() {

        bzCommonLockProcess.continueLockProcess();

        uiBean.setShrymd(null);

        if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
            uiBean.setKzmeiginmkn("");
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            Boolean isMRFAccount = checkMrfAccount();

            if (isMRFAccount == true) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WBA1006);
            }
        }

        if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
            if (!uiBean.getJpyShrjiYengststaisyousaeki().isOptional() &&
                !uiBean.getGaikaShrjiYengststaisyousaeki().isOptional()) {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) && uiBean.getJpyShrjiYengststaisyousaeki()
                    .compareTo(BizCurrency.valueOf(0, uiBean.getJpyShrjiYengststaisyousaeki().getType())) <= 0) {
                    if (uiBean.getGaikaShrjiYengststaisyousaeki()
                        .compareTo(BizCurrency.valueOf(0, uiBean.getGaikaShrjiYengststaisyousaeki().getType())) > 0) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3,
                            MessageId.WIF1019);
                    }
                }

                if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu()) && uiBean.getGaikaShrjiYengststaisyousaeki()
                    .compareTo(BizCurrency.valueOf(0, uiBean.getGaikaShrjiYengststaisyousaeki().getType())) <= 0) {
                    if (uiBean.getJpyShrjiYengststaisyousaeki()
                        .compareTo(BizCurrency.valueOf(0, uiBean.getJpyShrjiYengststaisyousaeki().getType())) > 0) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3,
                            MessageId.WIF1019);
                    }
                }
            }
        }

        checkShrkingkAddMessage();

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);
    }

    void pushSainyuuryokubtnOnClickBL() {
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING3);

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);
    }

    void pushModoruBysksconfirm() {
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING5);

        checkShrkingkAddMessage();
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


    private void checkKykSonzai(String pSyono) {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);
    }

    private void checkYuukouJyoutai() {
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);
        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }
        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            if (checkYuukouJyoutai.getWarningMessageIDList().size() != 0) {
                for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {
                    String messageID = BizUtil.getGeneralMessageId(checkYuukouJyoutai.getWarningMessageIDList().get(i));
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                        messageID, checkYuukouJyoutai.getWarningMessageList().get(i));
                }
            }
        }
    }

    private void checkTetudukiTyuui(String pSyoNo) {
        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, pSyoNo);

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }
        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    private void checkSaikensyaKaiyaku() {
        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(uiBean.getSyono());
        IT_KhTtdkTyuui khTtdkTyuui = khozenCommonParam.getKkTetudukiTyuui(uiBean.getSyono());
        uiBean.setStknsetkbn(kykKihon.getStknsetkbn());

        if (C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {

            if (khTtdkTyuui == null) {
                if (!C_StknsetKbn.ARI.eq(kykKihon.getStknsetkbn())) {
                    throw new BizLogicException(MessageId.EIF1028);
                }
            }
            else {
                if (!C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn1()) &&
                    !C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn1()) &&
                    !C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn1()) &&
                    !C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn2()) &&
                    !C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn2()) &&
                    !C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn2()) &&
                    !C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn3()) &&
                    !C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn3()) &&
                    !C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn3()) &&
                    !C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn4()) &&
                    !C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn4()) &&
                    !C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn4()) &&
                    !C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn5()) &&
                    !C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn5()) &&
                    !C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn5()) &&
                    !C_StknsetKbn.ARI.eq(kykKihon.getStknsetkbn())) {
                    throw new BizLogicException(MessageId.EIF1028);
                }
            }
        }

        if (!C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu()) &&
            ((khTtdkTyuui != null &&
            (C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
                C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
                C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
                C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
                C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
                C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
                C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
                C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
                C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn5()) ||
                C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn5()) ||
                C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn5()))) ||
                C_StknsetKbn.ARI.eq(kykKihon.getStknsetkbn()))) {
            throw new BizLogicException(MessageId.EIF1027);
        }
    }

    private void checkFatcaKakuninYouhi(String pSyoNo) {
        List<IT_KykSyouhn> kykSyouhnLst = khozenCommonParam.getKeiyakuSyouhin(pSyoNo, C_SyutkKbn.SYU);

        C_UmuKbn fatcataisyouumu = kykSyouhnLst.get(0).getSyouhnZokusei().getFatcataisyouumu();

        if (C_UmuKbn.ARI.eq(fatcataisyouumu)) {
            if(!BizUtil.isBlank(uiBean.getBzWorkflowInfo().getKouteiKanriId())){
                BizDate soruittykymd = getSyoruittykymd.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    C_SyoruiCdKbn.KK_KAIYAKU_SKS);

                if (soruittykymd != null) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA0053);
                }
            }
        }
    }

    private void setUiBean() {
        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);
        SetKihon.exec(khozenCommonParam, uiBean);
        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(khozenCommonParam, uiBean);
        SetTetudukityuui.exec(khozenCommonParam, uiBean);
        SetKeiyakusya.exec(khozenCommonParam, uiBean);
        SetTuusinsaki.exec(khozenCommonParam, uiBean);
        SetHihokensya.exec(khozenCommonParam, uiBean);
        SetHosyou setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyou.exec(khozenCommonParam, uiBean);
        SetSonotaTk.exec(khozenCommonParam, uiBean);
        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(khozenCommonParam, uiBean);

        SetTokusin.exec(khozenCommonParam, uiBean);

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);
        setKariukekin.exec(khozenCommonParam, uiBean);

        SetDattai.exec(khozenCommonParam, uiBean);

        SetHaitoukin setHaitoukin = SWAKInjector.getInstance(SetHaitoukin.class);
        setHaitoukin.exec(khozenCommonParam, uiBean);

        SetTrkKazoku.exec(khozenCommonParam, uiBean);

        SetKyksyadairi.exec(khozenCommonParam, uiBean);

        SetKhTkshrSiharaiKouza setKhTkshrSiharaiKouza = SWAKInjector.getInstance(SetKhTkshrSiharaiKouza.class);
        setKhTkshrSiharaiKouza.exec(khozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList().size() > 0) {
            for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                    uiBean.getWarningMessageIdList().get(i), uiBean.getWarningMessageList().get(i));
            }
        }
    }

    private void setSyokiKoumoku() {

        IT_KykKihon kykKihon = khozenCommonParam.getKeiyakuKihon(uiBean.getSyono());

        IT_KykSyouhn kykSyouhn = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0);

        IT_KykSonotaTkyk kykSonotaTkyk = khozenCommonParam.getSonotaTokuyaku(uiBean.getSyono());

        uiBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
        uiBean.setHrkkeiro(kykKihon.getHrkkeiro());
        uiBean.setSyukykjyoutai(kykSyouhn.getKykjyoutai());
        uiBean.setSyusyouhnsdno(kykSyouhn.getSyouhnsdno());
        uiBean.setSyukykymd(kykSyouhn.getKykymd());
        uiBean.setSyusyouhncd(kykSyouhn.getSyouhncd());
        uiBean.setSyuryouritusdno(kykSyouhn.getRyouritusdno());
        uiBean.setSyuyoteiriritu(kykSyouhn.getYoteiriritu());
        uiBean.setSyuhhknnen(kykSyouhn.getHhknnen());
        uiBean.setSyuhhknsei(kykSyouhn.getHhknsei());
        uiBean.setSyuhknkknsmnkbn(kykSyouhn.getHknkknsmnkbn());
        uiBean.setSyuhknkkn(kykSyouhn.getHknkkn());
        uiBean.setSyuhrkkknsmnkbn(kykSyouhn.getHrkkknsmnkbn());
        uiBean.setSyuhrkkkn(kykSyouhn.getHrkkkn());
        uiBean.setSyukihons(kykSyouhn.getKihons());
        uiBean.setKyktuukasyu(kykSyouhn.getKyktuukasyu());
        uiBean.setSyukouryokuhasseiymd(kykSyouhn.getKouryokuhasseiymd());
        uiBean.setSyukyksyouhnrenno(kykSyouhn.getKyksyouhnrenno());
        uiBean.setKeiyakutokisijyoukakakutyouseiyouriritu(kykSyouhn.getKyksjkkktyouseiriritu());
        uiBean.setYendthnkymd(kykSyouhn.getYendthnkymd());
        uiBean.setGsbunritaisyou(kykSyouhn.getGsbunritaisyou());
        uiBean.setTeikishrkinshrtuukasyu(kykSonotaTkyk.getTeikishrkinshrtuukasyu());
        uiBean.setTeikishrtkykhukaumu(kykSonotaTkyk.getTeikishrtkykhukaumu());
    }

    private void hanteiYenTkTekiyoUmu() {

        IT_KykSyouhn kykSyouhn = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        if (syouhnZokusei != null) {
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getYenshrtktekiumu()) && !C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                uiBean.setYenshrtktekiumu(C_UmuKbn.ARI);
            }
            else {
                uiBean.setYenshrtktekiumu(C_UmuKbn.NONE);
            }
            uiBean.setMvatekiumu(syouhnZokusei.getMvatekiumu());
            uiBean.setItijibrumu(syouhnZokusei.getItijibrumu());
            uiBean.setHeijyunbaraiumu(syouhnZokusei.getHeijyunbaraiumu());
            uiBean.setKaiyakukoujyoritutekiumu(syouhnZokusei.getKaiyakukoujyoritutekiumu());
        }
    }

    private void makeIW_KhKaiyakuWk(String pSyorikbn) {
        IW_KhKaiyakuWk khKaiyakuWk = new IW_KhKaiyakuWk();

        if (GAMENSYORIKBN_CONFIRM.equals(pSyorikbn)) {
            if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
                khKaiyakuWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }
            khKaiyakuWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            khKaiyakuWk.setKyksyaszknmkn(uiBean.getKyksyaszknmkn());
            khKaiyakuWk.setKyksyaszknmkj(uiBean.getKyksyaszknmkj());
            khKaiyakuWk.setKyksyaszkyno(uiBean.getKyksyaszkyno());
            khKaiyakuWk.setKyksyaszkadr1kj(uiBean.getKyksyaszkadr1kj());
            khKaiyakuWk.setKyksyaszkadr2kj(uiBean.getKyksyaszkadr2kj());
            khKaiyakuWk.setKyksyaszkadr3kj(uiBean.getKyksyaszkadr3kj());
            khKaiyakuWk.setSaikennmkj(uiBean.getSaikennmkj());
            khKaiyakuWk.setSaikennyno(uiBean.getSaikennyno());
            khKaiyakuWk.setSaikenadr1kj(uiBean.getSaikenadr1kj());
            khKaiyakuWk.setSaikenadr2kj(uiBean.getSaikenadr2kj());
            khKaiyakuWk.setSaikenadr3kj(uiBean.getSaikenadr3kj());
            khKaiyakuWk.setYenshrtkhkumu(uiBean.getYenshrtkumu());
            khKaiyakuWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());

            if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn()) ||
                C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn())) {
                khKaiyakuWk.setBankcd("");
                khKaiyakuWk.setSitencd("");
                khKaiyakuWk.setYokinkbn(C_YokinKbn.BLNK);
                khKaiyakuWk.setKouzano("");
                khKaiyakuWk.setKzdoukbn(C_Kzdou.BLNK);
            }
            else {
                khKaiyakuWk.setBankcd(uiBean.getBankcd());
                khKaiyakuWk.setSitencd(uiBean.getSitencd());
                khKaiyakuWk.setYokinkbn(uiBean.getYokinkbn());
                khKaiyakuWk.setKouzano(uiBean.getKouzano());
                khKaiyakuWk.setKzdoukbn(uiBean.getKzdoukbn());
            }

            if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn()) ||
                C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn()) ||
                C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                khKaiyakuWk.setKzmeiginmkn("");
            }
            else {
                khKaiyakuWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
            }

            khKaiyakuWk.setKykmnmeigibangou(uiBean.getKykmnmeigibangou());
            khKaiyakuWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            khKaiyakuWk.setKanryotuutioutkbn(uiBean.getKanryotuutioutkbn());
            khKaiyakuWk.setUktmnmeigibangou(uiBean.getUktmnmeigibangou());
            khKaiyakuWk.setSoukinsakikbn(uiBean.getSoukinsakikbn());
        }

        else {
            khKaiyakuWk.setShnmkj(uiBean.getShnmkj());
            khKaiyakuWk.setShskyno(uiBean.getShskyno());
            khKaiyakuWk.setShsadr1kj(uiBean.getShsadr1kj());
            khKaiyakuWk.setShsadr2kj(uiBean.getShsadr2kj());
            khKaiyakuWk.setShsadr3kj(uiBean.getShsadr3kj());
        }

        khKaiyakuWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        khKaiyakuWk.setSyono(uiBean.getSyono());
        khKaiyakuWk.setSkssakuseiymd(sysDate);
        khKaiyakuWk.setKaiyakujiyuu(uiBean.getKaiyakujiyuu());
        khKaiyakuWk.setGyoumuKousinKinou(functionId);
        khKaiyakuWk.setGyoumuKousinsyaId(userId);
        khKaiyakuWk.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(khKaiyakuWk);

        hozenDomManager.insert(khKaiyakuWk);
    }

    private void updateIW_KhKaiyakuWk() {
        IW_KhKaiyakuWk khKaiyakuWk = hozenDomManager.getKhKaiyakuWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) &&
            !C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
            khKaiyakuWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
            (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn()))) {
            khKaiyakuWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            khKaiyakuWk.setKyksyaszknmkn(uiBean.getKyksyaszknmkn());
            khKaiyakuWk.setKyksyaszknmkj(uiBean.getKyksyaszknmkj());
            khKaiyakuWk.setKyksyaszkyno(uiBean.getKyksyaszkyno());
            khKaiyakuWk.setKyksyaszkadr1kj(uiBean.getKyksyaszkadr1kj());
            khKaiyakuWk.setKyksyaszkadr2kj(uiBean.getKyksyaszkadr2kj());
            khKaiyakuWk.setKyksyaszkadr3kj(uiBean.getKyksyaszkadr3kj());
            khKaiyakuWk.setSaikennmkj(uiBean.getSaikennmkj());
            khKaiyakuWk.setSaikennyno(uiBean.getSaikennyno());
            khKaiyakuWk.setSaikenadr1kj(uiBean.getSaikenadr1kj());
            khKaiyakuWk.setSaikenadr2kj(uiBean.getSaikenadr2kj());
            khKaiyakuWk.setSaikenadr3kj(uiBean.getSaikenadr3kj());
            khKaiyakuWk.setYenshrtkhkumu(uiBean.getYenshrtkumu());
            khKaiyakuWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());

            if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn()) ||
                C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn())) {
                khKaiyakuWk.setBankcd("");
                khKaiyakuWk.setSitencd("");
                khKaiyakuWk.setYokinkbn(C_YokinKbn.BLNK);
                khKaiyakuWk.setKouzano("");
                khKaiyakuWk.setKzdoukbn(C_Kzdou.BLNK);
            }
            else {
                khKaiyakuWk.setBankcd(uiBean.getBankcd());
                khKaiyakuWk.setSitencd(uiBean.getSitencd());
                khKaiyakuWk.setYokinkbn(uiBean.getYokinkbn());
                khKaiyakuWk.setKouzano(uiBean.getKouzano());
                khKaiyakuWk.setKzdoukbn(uiBean.getKzdoukbn());
            }
            if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn()) ||
                C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn()) ||
                C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                khKaiyakuWk.setKzmeiginmkn("");
            }
            else {
                khKaiyakuWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
            }
            khKaiyakuWk.setKykmnmeigibangou(uiBean.getKykmnmeigibangou());
            khKaiyakuWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            khKaiyakuWk.setKanryotuutioutkbn(uiBean.getKanryotuutioutkbn());
            khKaiyakuWk.setUktmnmeigibangou(uiBean.getUktmnmeigibangou());
            khKaiyakuWk.setSoukinsakikbn(uiBean.getSoukinsakikbn());
        }

        khKaiyakuWk.setGyoumuKousinKinou(functionId);
        khKaiyakuWk.setGyoumuKousinsyaId(userId);
        khKaiyakuWk.setGyoumuKousinTime(sysTime);

        hozenDomManager.update(khKaiyakuWk);
    }

    private void makeTetudukiRireki() {

        PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);
        pALKykNaiyouKousin.exec(uiBean.getKykKihon());

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.ARI);
        editTtdkRirekiTblParam.setSysTime(sysTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);
        editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());
        editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        editTtdkRirekiTblParam.setYoukyuuNo(pALKykNaiyouKousin.getYoukyuuno());
        if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.KAIYAKU_KEIYAKUSYASIBOU);
        }
        else if (C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.KAIYAKU_SAIKENSYA);
        }
        else {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.BLNK);
        }

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    private void makeTyouhyou() {

        C_YouhiKbn pdfOutYouhi = C_YouhiKbn.HUYOU;
        if (C_KanryotuutioutKbn.PDF.eq(uiBean.getKanryotuutioutkbn())) {
            pdfOutYouhi = C_YouhiKbn.YOU;
        }

        EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KAIYAKU);
        editTtdkKanryouParam.setKouryokuYMD(uiBean.getKaiykymd());

        if (C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {
            editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);
            editTtdkKanryouParam.setShsyno(uiBean.getSaikennyno());
            editTtdkKanryouParam.setShsadr1kj(uiBean.getSaikenadr1kj());
            editTtdkKanryouParam.setShsadr2kj(uiBean.getSaikenadr2kj());
            editTtdkKanryouParam.setShsadr3kj(uiBean.getSaikenadr3kj());
            editTtdkKanryouParam.setShsnmkj(uiBean.getSaikennmkj());
        }
        else if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {
            editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
            editTtdkKanryouParam.setShsyno(uiBean.getKyksyaszkyno());
            editTtdkKanryouParam.setShsadr1kj(uiBean.getKyksyaszkadr1kj());
            editTtdkKanryouParam.setShsadr2kj(uiBean.getKyksyaszkadr2kj());
            editTtdkKanryouParam.setShsadr3kj(uiBean.getKyksyaszkadr3kj());
            editTtdkKanryouParam.setShsnmkj(uiBean.getKyksyaszknmkj());
        }
        else {
            editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
        }
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(uiBean.getKaiykymd());

        if (uiBean.getShrgkgoukeikakunin().compareTo(
            BizCurrency.valueOf(0, uiBean.getShrgkgoukeikakunin().getType())) > 0) {
            editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        }
        editTtdkKanryouParam.setKaiyakuJiyuu(uiBean.getKaiyakujiyuu());
        editTtdkKanryouParam.setGsbunritaisyouFlg(uiBean.getGsbunritaisyouFlg());
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(uiBean.getYuuyokkntyoukaumu());
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(uiBean.getPminyuuSyoumetuShrtyousyoOutZumiFlg());

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

        C_SyoruiCdKbn[] syoruiCds;
        if (C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {
            syoruiCds = new C_SyoruiCdKbn[] {
                C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR,
                C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR };
        }
        else {
            syoruiCds = new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR };
        }

        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.TYOKUSOU);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(), syoruiCds, pdfOutYouhi);

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());

        uiBean.setReportKey(khozenTyouhyouCtl.getTyouhyouKey());
    }

    private void doJikouteikanri() {
        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");

        String commnet = "";

        commnet = uiBean.getSyanaicommentkh();

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);
        khProcessForward
        .exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(), bzCommonLockProcess.getKouteiLockKey(), commnet,
            khRuleBean);

        bzCommonLockProcess.unlockProcess();
    }

    private void setUiBeanOpen() {
        uiBean.setKananmkyoyou(YuyuBizConfig.getInstance().getKanaNmKyoyou());
    }

    private BizCurrency doKingakuHenkan(BizCurrency pHenkanZenGk) {

        if (pHenkanZenGk.isOptional()) {
            return BizCurrency.valueOf(0, pHenkanZenGk.getType());
        }
        return pHenkanZenGk;
    }

    private Boolean checkMrfAccount() {

        List<IT_KykDairiten> kykDairitenLst = uiBean.getKykKihon().getKykDairitens();
        Boolean isMRFAccount = false;

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        List<BzGetAgInfoBean> bzGetAgInfoBeanListA = bzGetAgInfo.exec(kykDairitenLst.get(0).getDrtencd());
        isMRFAccount = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(bzGetAgInfoBeanListA.get(1).getOyadrtenCd());

        if (kykDairitenLst.size() > 1 &&
            isMRFAccount == false) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanListB = bzGetAgInfo.exec(kykDairitenLst.get(1).getDrtencd());
            isMRFAccount = BzHanteiAgUtil
                .isAgMrfkouzatoriatukaiKeyOyadrten(bzGetAgInfoBeanListB.get(1).getOyadrtenCd());
        }

        return isMRFAccount;
    }

    private void checkKaiyaku(String pGamenBunrui, CheckKaiyakuBean pCheckKaiyakuBean) {
        CheckKaiyaku checkKaiyaku = SWAKInjector.getInstance(CheckKaiyaku.class);
        checkKaiyaku.exec(CheckKaiyaku.KINOUBUNRUI_ONLINE, pGamenBunrui, pCheckKaiyakuBean);
    }

    private void checkKykSyaDairikenDouiken() {
        IT_KhTtdkTyuui khTtdkTyuui = khozenCommonParam.getKkTetudukiTyuui(uiBean.getSyono());

        if (C_Kaiyakujiyuu.TUUJYOU.eq(uiBean.getKaiyakujiyuu())) {
            if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA1022);
            }

            else {
                if (C_KykdrDouiYouhiKbn.YOU.eq(khTtdkTyuui.getKykdrdouiyouhi())) {

                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA1023);

                }
            }
        }

        else if (C_Kaiyakujiyuu.SKS.eq(uiBean.getKaiyakujiyuu())) {

            if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA1024);

            }
        }
        else if (C_Kaiyakujiyuu.KYKSB.eq(uiBean.getKaiyakujiyuu())) {

            if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA1025);

            }
        }
    }

    private void editHokenKykIdouRirekiTbl(BizCurrency pMikeikapKyktuuka, BizCurrency pZennouseisankinKyktuuka) {

        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo(uiBean.getSyono());
        editHokenKykIdouRirekiTblBean.setSyoriYmd(sysDate);
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.BLNK);
        editHokenKykIdouRirekiTblBean.setSysDateTime(sysTime);
        editHokenKykIdouRirekiTblBean.setMikeikaP(pMikeikapKyktuuka);
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(pZennouseisankinKyktuuka);

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);
    }

    private void checkShrkingkAddMessage () {
        if (C_UmuKbn.ARI.eq(uiBean.getTokuteitrhkkztourokujk())) {
            if (!uiBean.getJpyshrgkgoukeisyoukai().isOptional()) {
                if (uiBean.getJpyshrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(29900000)) >= 0 &&
                    uiBean.getJpyshrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(30000000)) <= 0 ) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3,
                        MessageId.WIF1051, BizUtil.comma(uiBean.getJpyshrgkgoukeisyoukai().toString()));
                }
                if (uiBean.getJpyshrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(30000000)) > 0) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, MessageId.WIF1052,
                        BizUtil.comma(uiBean.getJpyshrgkgoukeisyoukai().toString()));
                }
            }
        }
    }

    private void checkShrkingkRemoveMessage () {
        if (C_UmuKbn.ARI.eq(uiBean.getTokuteitrhkkztourokujk())) {
            if (!uiBean.getJpyshrgkgoukeisyoukai().isOptional()) {
                if (uiBean.getJpyshrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(29900000)) >= 0 &&
                    uiBean.getJpyshrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(30000000)) <= 0 ) {
                    messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3,
                        MessageId.WIF1051, BizUtil.comma(uiBean.getJpyshrgkgoukeisyoukai().toString()));
                }
                if (uiBean.getJpyshrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(30000000)) > 0) {
                    messageManager.removeConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3,
                        MessageId.WIF1052, BizUtil.comma(uiBean.getJpyshrgkgoukeisyoukai().toString()));
                }
            }
        }
    }
}
