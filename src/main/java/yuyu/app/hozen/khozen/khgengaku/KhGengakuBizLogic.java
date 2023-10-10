package yuyu.app.hozen.khozen.khgengaku;

import static yuyu.app.hozen.khozen.khgengaku.GenKhGengakuConstants.*;
import static yuyu.app.hozen.khozen.khgengaku.KhGengakuConstants.*;

import java.io.IOException;
import java.math.RoundingMode;
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
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khgengaku.dba.KhGengakuDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.CTIParamBean;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetAdrData;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzHanteiAgUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzFbSoukinDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSks;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakusei;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.biz.kaikei.SikinIdouRirekiDataBean;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
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
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.haitou.CheckDShrGengaku;
import yuyu.common.hozen.haitou.DBAccessDCommonGengaku;
import yuyu.common.hozen.haitou.KeisanDCommonGengaku;
import yuyu.common.hozen.khcommon.CheckMinP;
import yuyu.common.hozen.khcommon.CheckMinS;
import yuyu.common.hozen.khcommon.CheckPTani;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckSTani;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CommonSiwake;
import yuyu.common.hozen.khcommon.CommonSiwakeInBean;
import yuyu.common.hozen.khcommon.CommonSiwakeOutBean;
import yuyu.common.hozen.khcommon.CommonSiwakeUtil;
import yuyu.common.hozen.khcommon.EditDairitenTesuuryouTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTblBean;
import yuyu.common.hozen.khcommon.EditHokenSyoukenParam;
import yuyu.common.hozen.khcommon.EditJimuRenrakuhyouParam;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouDTbl;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouTbl;
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
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanHtyKeihi;
import yuyu.common.hozen.khcommon.KeisanIkkatuPGk;
import yuyu.common.hozen.khcommon.KeisanIkkatuPGkBean;
import yuyu.common.hozen.khcommon.KeisanKhGensen;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KeisanMsyMkeiP;
import yuyu.common.hozen.khcommon.KeisanSP;
import yuyu.common.hozen.khcommon.KeisanSiharaibi;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttkn;
import yuyu.common.hozen.khcommon.KeisanTeikishrkin;
import yuyu.common.hozen.khcommon.KeisanTienRisoku;
import yuyu.common.hozen.khcommon.KeisanTmHntiSisuuRendouTmttkn;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.KhCheckKouza;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenEdit;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.KoujyonaiyouDTBLSksParam;
import yuyu.common.hozen.khcommon.KykHenkoujiZnnJytTrksKsn;
import yuyu.common.hozen.khcommon.KykSyouhnCommonParam;
import yuyu.common.hozen.khcommon.MiKeikaPBean;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SetKhDshrTukiKykInfo;
import yuyu.common.hozen.khcommon.SetKjsmyouZennouInfo;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.hozen.khcommon.SyouhntaniKousingoPkeisan;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.khcommon.TaisyouGkBean;
import yuyu.common.hozen.khcommon.ZennouKoujyogakuKeisanParam;
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
import yuyu.common.sinkeiyaku.skcommon.ConvertChannelcd;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.EditDshrTukiTanKoumokuBean;
import yuyu.common.suuri.srcommon.SrDshrTukiDataSks;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_AzukarikinsyuruiKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FiSiyouKbn;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HijynbrKanritukaHantKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykhnkKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_RatesyutokukekkaKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyuShrgkSyoukeiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YendthnkJyoutaiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.classification.C_ZennouSeisanSyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhShrRirekiDetail;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.IW_KhGengakuWk;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_AnsyuRireki;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.DBAOutputReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.PdfBuilder;

import com.google.common.collect.Lists;
import com.lowagie.text.pdf.PdfReader;

/**
 * 減額 のビジネスロジックです。
 */
public class KhGengakuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhGengakuUiBean uiBean;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KhGengakuDao khGengakuDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private HozenPreReportRenkeiBean hozenPreReportRenkeiBean;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private DBAOutputReport dbaOutputReport;

    @Inject
    private CTIParamBean ctiParamBean;

    private String sousasyaCd;

    private BizDate systemYmd;

    private String systemTime;

    private String henkousikibetuKey;

    private String kinouId;

    void init() {
        clear();
    }

    void clear() {
    }

    void pushUnlockProcessBL() {

        bzCommonLockProcess.unlockProcess();
    }

    void continueLockProcessBL() {

        bzCommonLockProcess.continueLockProcess();
    }

    @Transactional
    void iwfOpenBL() {

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

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

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(
            uiBean.getBzWorkflowInfo().getKouteiKanriId());

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());

        checkKykSonzai();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkYuukouJyoutai(khozenCommonParam);

        hanteiTtdkTyuui(khozenCommonParam, uiBean.getSyono());

        setWarnings(khozenCommonParam);

        setUiBeanKinou(khozenCommonParam);

        IW_KhGengakuWk khGengakuWk = hozenDomManager.getKhGengakuWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        uiBean.setZenkaiSyoriKekka(khGengakuWk.getZenkaisyorikekkakbn());

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()) &&
            C_KhkinouModeIdKbn.SYOUNIN.toString().equals(kinouMode.getKinouMode())) {

            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                MessageId.WIC0001,
                C_SyorikekkaKbn.getContentByValue(C_SyorikekkaKbn.PATTERN_KHOZEN,
                    khGengakuWk.getZenkaisyorikekkakbn().toString()));
        }

        BizDate syoruittykymd = null;

        if (khGengakuWk.getSyoruiukeymd() == null) {

            GetSyoruittykymd getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);

            syoruittykymd = getSyoruittykymd.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                C_SyoruiCdKbn.KK_GENGAKU_SKS);
        }
        else {

            syoruittykymd = khGengakuWk.getSyoruiukeymd();
        }

        uiBean.setSyoruiukeymd(syoruittykymd);
        uiBean.setSyuhnkkbn(khGengakuWk.getKykhnkkbn());
        uiBean.setGengkhoukbn(khGengakuWk.getGengkhoukbn());
        uiBean.setSyukihons(khGengakuWk.getNewkihonhknkngaku());
        uiBean.setSyup(khGengakuWk.getNewhrkp());
        uiBean.setYenshrtkumu(khGengakuWk.getYenshrtkhkumu());
        uiBean.setInputshrhousiteikbn(khGengakuWk.getInputshrhousiteikbn());
        uiBean.setBankcd(khGengakuWk.getBankcd());
        uiBean.setSitencd(khGengakuWk.getSitencd());
        uiBean.setYokinkbn(khGengakuWk.getYokinkbn());
        uiBean.setKouzano(khGengakuWk.getKouzano());
        uiBean.setKzdoukbn(khGengakuWk.getKzdoukbn());
        uiBean.setKzmeiginmkn(khGengakuWk.getKzmeiginmkn());
        uiBean.setHonninkakninkekkakbn(khGengakuWk.getHonninkakninkekkakbn());
        uiBean.setHassoukbn(khGengakuWk.getHassoukbn());
        uiBean.setKykmnmeigibangou(khGengakuWk.getKykmnmeigibangou());
        uiBean.setSksSakuseiYmd(khGengakuWk.getSkssakuseiymd());
        uiBean.setSoukinsakikbn(khGengakuWk.getSoukinsakikbn());

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);

        setProgressHistory.exec(uiBean);
    }

    void pushNyuryoku() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        checkKykSonzai();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkYuukouJyoutai(khozenCommonParam);

        hanteiTtdkTyuui(khozenCommonParam, uiBean.getSyono());

        setWarnings(khozenCommonParam);

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);

        hanteiSyoriKengen.exec();

        setUiBeanKinou(khozenCommonParam);

        uiBean.setSyoruiukeymd(BizDate.getSysDate());

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU);
    }

    String modorubtnbyinputcontentsOnClickBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {

            pushUnlockProcessBL();

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    String functionNameOnClickBL() {

        String retUrl = null;

        if (C_KhkinouModeIdKbn.INPUT.toString().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.toString().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.toString().equals(kinouMode.getKinouMode())) {

            pushUnlockProcessBL();

            retUrl = FORWARDNAME_BACKTOWORKLIST;
        }
        else {

            retUrl = FORWARDNAME_INIT;
        }

        return retUrl;
    }

    void printHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void pushSaiNyuuryoku() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);


    }

    void pushSeikyuusyoSakusei() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn umuKbn = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(umuKbn)){

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        KeisanHtyKeihi keisanHtyKeihi = SWAKInjector.getInstance(KeisanHtyKeihi.class);

        keisanHtyKeihi.exec(uiBean.getSyono(), uiBean.getVhsyusyukyktuukasyu());

        uiBean.setHtykeihiYen(keisanHtyKeihi.getYenHtyKeihi());
        uiBean.setKykHnkKaisuu(keisanHtyKeihi.getKykSyaHenkouKaisuu());

        if (C_UmuKbn.ARI.eq(uiBean.getYenkaGsBunriTaisyouFlag()) ||
            C_UmuKbn.ARI.eq(uiBean.getGaikaGsBunriTaisyouFlag())) {
            uiBean.setGsBunriTaisyouFlag(C_UmuKbn.ARI);
        }
        else {
            uiBean.setGsBunriTaisyouFlag(C_UmuKbn.NONE);
        }

        uiBean.setMynoSinkokuTaisyouFlg(C_UmuKbn.NONE);

        if(C_UmuKbn.NONE.eq(uiBean.getGsBunriTaisyouFlag()) &&
            C_UmuKbn.NONE.eq(uiBean.getZeiseitkkktkykhukaumu())){

            if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {

                uiBean.setSaeki(uiBean.getYendthnkshrgkgoukeisyoukai().subtract(uiBean.getHtykeihiYen()));
            }

            else {

                uiBean.setSaeki(uiBean.getJpyshrgkgoukeisyoukai().subtract(
                    uiBean.getHtykeihiYen().add(uiBean.getJpyGsTszeigk())));
            }

            if (uiBean.getJpykaiyakuhr().compareTo(BizCurrency.valueOf(1000000)) > 0 &&
                (uiBean.getKykHnkKaisuu() > 0 ||
                    (uiBean.getKykHnkKaisuu() == 0 &&
                    uiBean.getSaeki().compareTo(BizCurrency.valueOf(0)) > 0))) {

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING6,
                    MessageId.WIA1012);

                uiBean.setMynoSinkokuTaisyouFlg(C_UmuKbn.ARI);
            }
        }

        messageManager.addMessageId(MessageId.QIA0004);
    }

    void pushSyoukai() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }

        int syoruiUkeKyoyou = YuyuHozenConfig.getInstance().getSyoruiUkeKyoyou();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        List<IT_KykSyouhn> kykSyouhnLst = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        if ((C_KhkinouModeIdKbn.SYOUNIN.toString().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) ||
            !C_KhkinouModeIdKbn.SYOUNIN.toString().equals(kinouMode.getKinouMode())) {

            BizDate sysYmd = BizDate.getSysDate();

            BizDateYM jkipjytym = khozenCommonParam.getAnsyuuKihon(uiBean.getSyono()).getJkipjytym();

            if (uiBean.getSyoruiukeymd() == null) {

                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUINFO_SYORUIUKEYMD.
                        getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), uiBean.getVhsyusyukykymd())
                == BizDateUtil.COMPARE_LESSER) {

                throw new BizLogicException(MessageId.EIA0070,
                    MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUINFO_SYORUIUKEYMD.
                        getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), sysYmd) == BizDateUtil.COMPARE_GREATER) {

                throw new BizLogicException(MessageId.EIA0037,
                    MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUINFO_SYORUIUKEYMD.
                        getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), uiBean.getYendtHnkYmd()) == BizDateUtil.COMPARE_LESSER) {

                throw new BizLogicException(MessageId.EIA1022);
            }

            List<IT_KykSyouhn> kykSyouhnList = uiBean.getKykKihon().getKykSyouhnsByKouryokuhasseiymdGt(
                uiBean.getSyoruiukeymd());


            if (kykSyouhnList.size() > 0) {

                throw new BizLogicException(MessageId.EIA0106);
            }

            uiBean.setSyouhinHanteiKbn(SyouhinUtil.hantei(uiBean.getSyusyouhncd()));

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyouhinHanteiKbn()) {
                uiBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
            }

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            C_Tuukasyu tuukasyu =  henkanTuuka.henkanTuukaTypeToKbn(uiBean.getVhsyusyup().getType());
            uiBean.setHrktuukasyu(tuukasyu);

            if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn() ||
                SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyouhinHanteiKbn()) &&
                !C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {

                BizDate syoruiUkeYmdYokunen = uiBean.getSyoruiukeymd().getNextYear().getRekijyou();

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                BizDate tykgoOutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO,
                    uiBean.getVhsyusyukykymd(),
                    C_Hrkkaisuu.NEN,
                    syoruiUkeYmdYokunen);

                Long kensuu = khGengakuDao.getSisuurendoTmttknCountBySyonoTmttkntaisyouym(uiBean.getSyono(),
                    tykgoOutouYmd.getBizDateYM());

                if (kensuu != 0) {

                    throw new BizLogicException(MessageId.EIF1076);
                }
            }

            CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

            boolean syoriResult = checkYuuyokkngai.exec(uiBean.getSyono(), uiBean.getSyoruiukeymd());

            if (!syoriResult) {
                throw new BizLogicException(MessageId.EIA1032,
                    MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            if (C_KykhnkKbn.BLNK.eq(uiBean.getSyuhnkkbn())) {

                boolean  errorflg = true;

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd1())) {

                    if (!C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn1())) {

                        errorflg = false;
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd2())) {

                    if (!C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn2())) {

                        errorflg = false;
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd3())) {

                    if (!C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn3())) {

                        errorflg = false;
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd4())) {

                    if (!C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn4())) {

                        errorflg = false;
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd5())) {

                    if (!C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn5())) {

                        errorflg = false;
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd6())) {

                    if (!C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn6())) {

                        errorflg = false;
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd7())) {

                    if (!C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn7())) {

                        errorflg = false;
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd8())) {

                    if (!C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn8())) {

                        errorflg = false;
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd9())) {

                    if (!C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn9())) {

                        errorflg = false;
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd10())) {

                    if (!C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn10())) {

                        errorflg = false;
                    }
                }

                if (errorflg) {

                    throw new BizLogicException(MessageId.EIA0044, NAIYOU);
                }
            }


            C_Tuukasyu syuKihonSTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getSyukihons().getType());

            if (C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {
                List<IT_KhTtdkRireki> khTtdkRirekiLst = khGengakuDao.getSeiteiseiKhTtdkRirekisBySyonoSyoriymd(
                    uiBean.getSyono(), sysYmd);
                if (khTtdkRirekiLst.size() != 0) {
                    throw new BizLogicException(MessageId.EIF1105);
                }
            }

            if (C_GengkhouKbn.BLNK.eq(uiBean.getGengkhoukbn())) {

                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUSYUINFO_GENGKHOUKBN.
                        getErrorResourceKey()));
            }
            else if (C_GengkhouKbn.SD.eq(uiBean.getGengkhoukbn())) {
                if (!syuKihonSTuukasyu.eq(uiBean.getVhsyusyukyktuukasyu())) {

                    throw new BizLogicException(MessageId.EIF1074);
                }

                if (uiBean.getSyukihons().equals(uiBean.getVhsyusyukihons())) {

                    throw new BizLogicException(MessageId.EIA0044,
                        MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUSYUINFO_SYUKIHONS.
                            getErrorResourceKey()));
                }

                if (uiBean.getSyukihons().isZeroOrOptional()) {

                    throw new BizLogicException(MessageId.EIF1001,
                        MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUSYUINFO_SYUKIHONS.
                            getErrorResourceKey()),
                            uiBean.getVhsyusyukyktuukasyu().getContent());
                }

                if (uiBean.getSyukihons().compareTo(uiBean.getVhsyusyukihons()) > 0) {

                    throw new BizLogicException(MessageId.EIA0098,
                        uiBean.getVhsyusyusyouhnnm(),
                        MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUSYUINFO_SYUKIHONS.
                            getErrorResourceKey()));
                }

                BizCurrency syukihons = uiBean.getVhsyusyukihons().subtract(uiBean.getSyukihons());

                CurrencyType  currencyType  = uiBean.getVhsyusyukihons().getType();
                BizCurrency hikakuSagk = BizCurrency.valueOf(1.00, currencyType);

                if (syukihons.compareTo(hikakuSagk) < 0) {
                    throw new BizLogicException(MessageId.EIF1068, uiBean.getVhsyusyukyktuukasyu().getContent());
                }

                if (C_YendthnkJyoutaiKbn.YENDTHNKZUMI.eq(uiBean.getVhsyuyendthnkjyoutaikbn()) ||
                    SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyouhinHanteiKbn()) {
                    CheckSTani checkSTani = SWAKInjector.getInstance(CheckSTani.class);

                    checkSTani.exec(kykSyouhnLst.get(0).getSyouhncd(),
                        kykSyouhnLst.get(0).getSyouhnsdno(),
                        kykSyouhnLst.get(0).getHhknnen(),
                        kykSyouhnLst.get(0).getKyktuukasyu(),
                        kykSyouhnLst.get(0).getSyouhnZokusei(),
                        uiBean.getSyukihons());
                }

                CheckMinS checkMinS = SWAKInjector.getInstance(CheckMinS.class);

                boolean checkMinSFlg = checkMinS.exec(
                    kykSyouhnLst.get(0).getSyouhncd(),
                    kykSyouhnLst.get(0).getSyouhnsdno(),
                    kykSyouhnLst.get(0).getHrkkknsmnkbn(),
                    kykSyouhnLst.get(0).getHknkkn(),
                    kykSyouhnLst.get(0).getKyktuukasyu(),
                    kykSyouhnLst.get(0).getSyouhnZokusei(),
                    uiBean.getSyukihons());

                if (!checkMinSFlg) {
                    for (int count = 0 ; count < checkMinS.getWarningMsgIdList().size(); count++) {
                        String warningMsgId = checkMinS.getWarningMsgIdList().get(count);
                        String warningMsg = checkMinS.getWarningMsgList().get(count);
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                            BizUtil.getGeneralMessageId(warningMsgId), warningMsg);
                    }
                }
            }
            else if (C_GengkhouKbn.PD.eq(uiBean.getGengkhoukbn())) {

                if (uiBean.getSyup().equals(uiBean.getVhsyusyup())) {

                    throw new BizLogicException(MessageId.EIA0044,
                        MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUSYUINFO_SYUP.
                            getErrorResourceKey()));
                }

                if (uiBean.getSyup().isZeroOrOptional()) {

                    throw new BizLogicException(MessageId.EIF1001,
                        MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUSYUINFO_SYUP.
                            getErrorResourceKey()),
                            uiBean.getVhsyusyukyktuukasyu().getContent());
                }

                if (uiBean.getSyup().compareTo(uiBean.getVhsyusyup()) > 0) {

                    throw new BizLogicException(MessageId.EIA0098,
                        uiBean.getVhsyusyusyouhnnm(),
                        MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUSYUINFO_SYUP.
                            getErrorResourceKey()));
                }

                IT_KykDairiten kykDairiten = uiBean.getKykKihon().getKykDairitenByDrtenrenno(1);
                ConvertChannelcd convertChannelCd = SWAKInjector.getInstance(ConvertChannelcd.class);
                C_Channelcd kiteiChkChannelCd = convertChannelCd.exec(null, kykDairiten.getOyadrtencd());

                uiBean.setNewsyukjnkngk(BizCurrency.valueOf(0, uiBean.getSyup().getType()));

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyouhinHanteiKbn()) {
                    uiBean.setNewsyukjnkngk(uiBean.getSyup().multiply(12).divide(
                        Integer.parseInt(uiBean.getVhrkihrkkaisuu().getValue()))
                        .multiply((kykSyouhnLst.get(0).getHrkkkn())-kykSyouhnLst.get(0).getHhknnen()));
                }

                CheckPTani checkPTani = SWAKInjector.getInstance(CheckPTani.class);
                checkPTani.exec(kykSyouhnLst.get(0).getSyouhncd(),
                    uiBean.getVhrkihrkkaisuu(),
                    kykSyouhnLst.get(0).getSyouhnsdno(),
                    kiteiChkChannelCd,
                    uiBean.getHrktuukasyu(),
                    kykSyouhnLst.get(0).getSyouhnZokusei(),
                    uiBean.getSyup());

                if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN != uiBean.getSyouhinHanteiKbn()) {
                    CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);
                    boolean checkMinPFlg = checkMinP.exec(
                        kykSyouhnLst.get(0).getSyouhncd(),
                        kykSyouhnLst.get(0).getSyouhnsdno(),
                        kykSyouhnLst.get(0).getHrkkkn(),
                        kykSyouhnLst.get(0).getHrkkknsmnkbn(),
                        uiBean.getSyup(),
                        uiBean.getNewsyukjnkngk(),
                        kykSyouhnLst.get(0).getHhknnen(),
                        uiBean.getVhrkihrkkaisuu(),
                        kykSyouhnLst.get(0).getSyouhnZokusei(),
                        kiteiChkChannelCd);

                    if (!checkMinPFlg) {
                        for (int count = 0 ; count < checkMinP.getWarningMsgIdList().size(); count++) {
                            String warningMsgId = checkMinP.getWarningMsgIdList().get(count);
                            String warningMsg = checkMinP.getWarningMsgList().get(count);
                            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                                BizUtil.getGeneralMessageId(warningMsgId), warningMsg);
                        }
                    }
                }
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd1())) {

                String disptkkihonssyuruikbn = uiBean.getVhsyudisptkkihsyuruikbn1().getContent(
                    C_KihonssyuruiKbn.PATTERN_CHECK);

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn1()) &&
                    !uiBean.getNewtkkihons1().equals(uiBean.getVhsyudisptkkihons1())) {

                    throw new BizLogicException(MessageId.EIA0096,
                        uiBean.getVhsyudisptksyouhnnm1(),
                        disptkkihonssyuruikbn);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn1())) {

                    if (uiBean.getNewtkkihons1().equals(uiBean.getVhsyudisptkkihons1())) {

                        throw new BizLogicException(MessageId.EIA0097,
                            uiBean.getVhsyudisptksyouhnnm1(),
                            disptkkihonssyuruikbn);
                    }

                    if (uiBean.getNewtkkihons1().compareTo(uiBean.getVhsyudisptkkihons1()) > 0) {

                        throw new BizLogicException(MessageId.EIA0098,
                            uiBean.getVhsyudisptksyouhnnm1(),
                            disptkkihonssyuruikbn);
                    }
                }
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd2())) {

                String disptkkihonssyuruikbn = uiBean.getVhsyudisptkkihsyuruikbn2().getContent(
                    C_KihonssyuruiKbn.PATTERN_CHECK);

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn2()) &&
                    !uiBean.getNewtkkihons2().equals(uiBean.getVhsyudisptkkihons2())) {

                    throw new BizLogicException(MessageId.EIA0096,
                        uiBean.getVhsyudisptksyouhnnm2(),
                        disptkkihonssyuruikbn);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn2())) {

                    if (uiBean.getNewtkkihons2().equals(uiBean.getVhsyudisptkkihons2())) {

                        throw new BizLogicException(MessageId.EIA0097,
                            uiBean.getVhsyudisptksyouhnnm2(),
                            disptkkihonssyuruikbn);
                    }

                    if (uiBean.getNewtkkihons2().compareTo(uiBean.getVhsyudisptkkihons2()) > 0) {

                        throw new BizLogicException(MessageId.EIA0098,
                            uiBean.getVhsyudisptksyouhnnm2(),
                            disptkkihonssyuruikbn);
                    }
                }
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd3())) {

                String disptkkihonssyuruikbn = uiBean.getVhsyudisptkkihsyuruikbn3().getContent(
                    C_KihonssyuruiKbn.PATTERN_CHECK);

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn3()) &&
                    !uiBean.getNewtkkihons3().equals(uiBean.getVhsyudisptkkihons3())) {

                    throw new BizLogicException(MessageId.EIA0096,
                        uiBean.getVhsyudisptksyouhnnm3(),
                        disptkkihonssyuruikbn);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn3())) {

                    if (uiBean.getNewtkkihons3().equals(uiBean.getVhsyudisptkkihons3())) {

                        throw new BizLogicException(MessageId.EIA0097,
                            uiBean.getVhsyudisptksyouhnnm3(),
                            disptkkihonssyuruikbn);
                    }

                    if (uiBean.getNewtkkihons3().compareTo(uiBean.getVhsyudisptkkihons3()) > 0) {

                        throw new BizLogicException(MessageId.EIA0098,
                            uiBean.getVhsyudisptksyouhnnm3(),
                            disptkkihonssyuruikbn);
                    }
                }
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd4())) {

                String disptkkihonssyuruikbn = uiBean.getVhsyudisptkkihsyuruikbn4().getContent(
                    C_KihonssyuruiKbn.PATTERN_CHECK);

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn4()) &&
                    !uiBean.getNewtkkihons4().equals(uiBean.getVhsyudisptkkihons4())) {

                    throw new BizLogicException(MessageId.EIA0096,
                        uiBean.getVhsyudisptksyouhnnm4(),
                        disptkkihonssyuruikbn);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn4())) {

                    if (uiBean.getNewtkkihons4().equals(uiBean.getVhsyudisptkkihons4())) {

                        throw new BizLogicException(MessageId.EIA0097,
                            uiBean.getVhsyudisptksyouhnnm4(),
                            disptkkihonssyuruikbn);
                    }

                    if (uiBean.getNewtkkihons4().compareTo(uiBean.getVhsyudisptkkihons4()) > 0) {

                        throw new BizLogicException(MessageId.EIA0098,
                            uiBean.getVhsyudisptksyouhnnm4(),
                            disptkkihonssyuruikbn);
                    }
                }
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd5())) {

                String disptkkihonssyuruikbn = uiBean.getVhsyudisptkkihsyuruikbn5().getContent(
                    C_KihonssyuruiKbn.PATTERN_CHECK);

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn5()) &&
                    !uiBean.getNewtkkihons5().equals(uiBean.getVhsyudisptkkihons5())) {

                    throw new BizLogicException(MessageId.EIA0096,
                        uiBean.getVhsyudisptksyouhnnm5(),
                        disptkkihonssyuruikbn);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn5())) {

                    if (uiBean.getNewtkkihons5().equals(uiBean.getVhsyudisptkkihons5())) {

                        throw new BizLogicException(MessageId.EIA0097,
                            uiBean.getVhsyudisptksyouhnnm5(),
                            disptkkihonssyuruikbn);
                    }

                    if (uiBean.getNewtkkihons5().compareTo(uiBean.getVhsyudisptkkihons5()) > 0) {

                        throw new BizLogicException(MessageId.EIA0098,
                            uiBean.getVhsyudisptksyouhnnm5(),
                            disptkkihonssyuruikbn);
                    }
                }
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd6())) {

                String disptkkihonssyuruikbn = uiBean.getVhsyudisptkkihsyuruikbn6().getContent(
                    C_KihonssyuruiKbn.PATTERN_CHECK);

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn6()) &&
                    !uiBean.getNewtkkihons6().equals(uiBean.getVhsyudisptkkihons6())) {

                    throw new BizLogicException(MessageId.EIA0096,
                        uiBean.getVhsyudisptksyouhnnm6(),
                        disptkkihonssyuruikbn);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn6())) {

                    if (uiBean.getNewtkkihons6().equals(uiBean.getVhsyudisptkkihons6())) {

                        throw new BizLogicException(MessageId.EIA0097,
                            uiBean.getVhsyudisptksyouhnnm6(),
                            disptkkihonssyuruikbn);
                    }

                    if (uiBean.getNewtkkihons6().compareTo(uiBean.getVhsyudisptkkihons6()) > 0) {

                        throw new BizLogicException(MessageId.EIA0098,
                            uiBean.getVhsyudisptksyouhnnm6(),
                            disptkkihonssyuruikbn);
                    }
                }
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd7())) {

                String disptkkihonssyuruikbn = uiBean.getVhsyudisptkkihsyuruikbn7().getContent(
                    C_KihonssyuruiKbn.PATTERN_CHECK);

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn7()) &&
                    !uiBean.getNewtkkihons7().equals(uiBean.getVhsyudisptkkihons7())) {

                    throw new BizLogicException(MessageId.EIA0096,
                        uiBean.getVhsyudisptksyouhnnm7(),
                        disptkkihonssyuruikbn);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn7())) {

                    if (uiBean.getNewtkkihons7().equals(uiBean.getVhsyudisptkkihons7())) {

                        throw new BizLogicException(MessageId.EIA0097,
                            uiBean.getVhsyudisptksyouhnnm7(),
                            disptkkihonssyuruikbn);
                    }

                    if (uiBean.getNewtkkihons7().compareTo(uiBean.getVhsyudisptkkihons7()) > 0) {

                        throw new BizLogicException(MessageId.EIA0098,
                            uiBean.getVhsyudisptksyouhnnm7(),
                            disptkkihonssyuruikbn);
                    }
                }
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd8())) {

                String disptkkihonssyuruikbn = uiBean.getVhsyudisptkkihsyuruikbn8().getContent(
                    C_KihonssyuruiKbn.PATTERN_CHECK);

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn8()) &&
                    !uiBean.getNewtkkihons8().equals(uiBean.getVhsyudisptkkihons8())) {

                    throw new BizLogicException(MessageId.EIA0096,
                        uiBean.getVhsyudisptksyouhnnm8(),
                        disptkkihonssyuruikbn);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn8())) {

                    if (uiBean.getNewtkkihons8().equals(uiBean.getVhsyudisptkkihons8())) {

                        throw new BizLogicException(MessageId.EIA0097,
                            uiBean.getVhsyudisptksyouhnnm8(),
                            disptkkihonssyuruikbn);
                    }

                    if (uiBean.getNewtkkihons8().compareTo(uiBean.getVhsyudisptkkihons8()) > 0) {

                        throw new BizLogicException(MessageId.EIA0098,
                            uiBean.getVhsyudisptksyouhnnm8(),
                            disptkkihonssyuruikbn);
                    }
                }
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd9())) {

                String disptkkihonssyuruikbn = uiBean.getVhsyudisptkkihsyuruikbn9().getContent(
                    C_KihonssyuruiKbn.PATTERN_CHECK);

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn9()) &&
                    !uiBean.getNewtkkihons9().equals(uiBean.getVhsyudisptkkihons9())) {

                    throw new BizLogicException(MessageId.EIA0096,
                        uiBean.getVhsyudisptksyouhnnm9(),
                        disptkkihonssyuruikbn);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn9())) {

                    if (uiBean.getNewtkkihons9().equals(uiBean.getVhsyudisptkkihons9())) {

                        throw new BizLogicException(MessageId.EIA0097,
                            uiBean.getVhsyudisptksyouhnnm9(),
                            disptkkihonssyuruikbn);
                    }

                    if (uiBean.getNewtkkihons9().compareTo(uiBean.getVhsyudisptkkihons9()) > 0) {

                        throw new BizLogicException(MessageId.EIA0098,
                            uiBean.getVhsyudisptksyouhnnm9(),
                            disptkkihonssyuruikbn);
                    }
                }
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd10())) {

                String disptkkihonssyuruikbn = uiBean.getVhsyudisptkkihsyuruikbn10().getContent(
                    C_KihonssyuruiKbn.PATTERN_CHECK);

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn10()) &&
                    !uiBean.getNewtkkihons10().equals(uiBean.getVhsyudisptkkihons10())) {

                    throw new BizLogicException(MessageId.EIA0096,
                        uiBean.getVhsyudisptksyouhnnm10(),
                        disptkkihonssyuruikbn);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn10())) {

                    if (uiBean.getNewtkkihons10().equals(uiBean.getVhsyudisptkkihons10())) {

                        throw new BizLogicException(MessageId.EIA0097,
                            uiBean.getVhsyudisptksyouhnnm10(),
                            disptkkihonssyuruikbn);
                    }

                    if (uiBean.getNewtkkihons10().compareTo(uiBean.getVhsyudisptkkihons10()) > 0) {

                        throw new BizLogicException(MessageId.EIA0098,
                            uiBean.getVhsyudisptksyouhnnm10(),
                            disptkkihonssyuruikbn);
                    }
                }
            }

            CheckDShrGengaku checkDShrGengaku = SWAKInjector.getInstance(CheckDShrGengaku.class);

            C_ErrorKbn dShrGengakuErrorKbn = checkDShrGengaku.checkDShr(uiBean.getSyono(),
                uiBean.getSyoruiukeymd(),
                null,
                C_YouhiKbn.HUYOU,
                sysYmd);

            if (C_ErrorKbn.ERROR.eq(dShrGengakuErrorKbn)) {
                throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
            }

            C_UmuKbn dHuseigouUmu = checkDShrGengaku.getDHuseigouUmu();
            if (C_UmuKbn.ARI.eq(dHuseigouUmu)) {
                throw new BizLogicException(MessageId.EBS1012);
            }

            C_UmuKbn dHaneiYmdUmu = checkDShrGengaku.getDHaneiYmdUmu();
            if (C_UmuKbn.ARI.eq(dHaneiYmdUmu)) {
                throw new BizLogicException(MessageId.EBA1049,
                    MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            CheckDShrGengaku checkDShrGengakuKouryokuYmd = SWAKInjector.getInstance(CheckDShrGengaku.class);

            C_YouhiKbn youhiKbn = null;
            if (C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {

                youhiKbn = C_YouhiKbn.HUYOU;
            }
            else {

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhnLst.get(0).getKykjyoutai())) {

                    youhiKbn = C_YouhiKbn.HUYOU;
                }
                else if (C_Kykjyoutai.HRKMTYUU.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
                    C_Kykjyoutai.IKKATUNK.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
                    C_Kykjyoutai.ZENNOU.eq(kykSyouhnLst.get(0).getKykjyoutai())) {

                    youhiKbn = C_YouhiKbn.YOU;
                }
            }

            C_ErrorKbn dShrGengakuKouryokuYmdErrorKbn = checkDShrGengakuKouryokuYmd.checkDShr(uiBean.getSyono(), uiBean.getSyoruiukeymd(),
                jkipjytym, youhiKbn, sysYmd);

            if (C_ErrorKbn.ERROR.eq(dShrGengakuKouryokuYmdErrorKbn)) {
                throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
            }

            uiBean.setMihaneiDUmu(checkDShrGengakuKouryokuYmd.getMihaneiDUmu());

            if (C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {
                if (C_UmuKbn.ARI.eq(uiBean.getMihaneiDUmu())) {
                    throw new BizLogicException(MessageId.EBA1048);
                }
            }

            if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn() ||
                SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyouhinHanteiKbn()) &&
                !C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {

                HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
                hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
                hanteiTmttknJyoutaiBean.setHanteiKijyunymd(uiBean.getSyoruiukeymd());
                hanteiTmttknJyoutaiBean.setKykymd(uiBean.getVhsyusyukykymd());

                HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                    SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

                boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                if (!result) {
                    throw new BizLogicException(MessageId.EBA1052);
                }
            }

            if (C_Kykjyoutai.HRKMTYUU.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
                C_Kykjyoutai.IKKATUNK.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
                C_Kykjyoutai.ZENNOU.eq(kykSyouhnLst.get(0).getKykjyoutai())) {

                BizDateYM kouryokuhasseiym = jkipjytym;
                BizDate kouryokuhasseiymd = BizDate.valueOf(
                    kouryokuhasseiym, kykSyouhnLst.get(0).getKykymd().getDay()).getRekijyou();

                if (BizDateUtil.compareYmd(kouryokuhasseiymd, uiBean.getSyoruiukeymd()) == BizDateUtil.COMPARE_LESSER) {

                    uiBean.setKouryokuHasseiYmd(kouryokuhasseiymd);
                }
                else {

                    uiBean.setKouryokuHasseiYmd(uiBean.getSyoruiukeymd());
                }
            } else {

                uiBean.setKouryokuHasseiYmd(uiBean.getSyoruiukeymd());
            }

            List<IT_KykSyouhn> tkKykSyouhnList = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.TK);

            List<IT_KykSyouhn> syuKykSyouhnViewList = new ArrayList<>(kykSyouhnLst);

            List<IT_KykSyouhn> tkKykSyouhnViewList = new ArrayList<>();

            if (tkKykSyouhnList != null && tkKykSyouhnList.size() > 0) {

                tkKykSyouhnViewList = new ArrayList<>(tkKykSyouhnList);

            }

            CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyusyukyktuukasyu());

            CurrencyType syuHrkpCurrencyType = uiBean.getKykKihon().getHrkp().getType();

            BizCurrency newhrkp = BizCurrency.valueOf(0, syuHrkpCurrencyType);

            BizCurrency newhkngk = BizCurrency.valueOf(0, syuCurrencyType);

            BizCurrency newsyup = BizCurrency.valueOf(0, syuHrkpCurrencyType);

            BizCurrency newsyupgk = BizCurrency.valueOf(0, syuCurrencyType);

            C_PmnjtkKbn calcPmnJtkHnkKbn = null;

            if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                calcPmnJtkHnkKbn = C_PmnjtkKbn.NONE;
            }

            if (C_GengkhouKbn.PD.eq(uiBean.getGengkhoukbn())) {

                newsyup = uiBean.getSyup();

                KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                C_ErrorKbn errorKbn = keisanSP.exec(uiBean.getSyusyouhncd(),
                    uiBean.getSyuryouritusdno(),
                    uiBean.getSyuyoteiriritu(),
                    uiBean.getVhrkihrkkaisuu(),
                    uiBean.getVhsyusyuhhknnen(),
                    uiBean.getVhhkshhknsei(),
                    uiBean.getVhsyusyuhknkknsmnkbn(),
                    uiBean.getVhsyusyuhknkkn(),
                    uiBean.getVhsyusyuhrkkkn(),
                    C_Sdpd.PD,
                    newsyupgk,
                    newsyup,
                    uiBean.getVhsyusyukyktuukasyu(),
                    kykSyouhnLst.get(0).getKykjyoutai(),
                    kykSyouhnLst.get(0).getDai1hknkkn(),
                    uiBean.getVhrkihrkkeiro());

                if (!C_ErrorKbn.OK.eq(errorKbn)) {

                    throw new BizLogicException(keisanSP.getMsgid());
                }

                newsyupgk = keisanSP.getS();

                if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyouhinHanteiKbn()) {
                    uiBean.setNewsyukihons(newsyupgk);
                    CheckMinS checkMinS = SWAKInjector.getInstance(CheckMinS.class);

                    boolean checkMinSFlg = checkMinS.exec(
                        kykSyouhnLst.get(0).getSyouhncd(),
                        kykSyouhnLst.get(0).getSyouhnsdno(),
                        kykSyouhnLst.get(0).getHrkkknsmnkbn(),
                        kykSyouhnLst.get(0).getHknkkn(),
                        kykSyouhnLst.get(0).getKyktuukasyu(),
                        kykSyouhnLst.get(0).getSyouhnZokusei(),
                        newsyupgk);

                    if (!checkMinSFlg) {
                        for (int count = 0 ; count < checkMinS.getWarningMsgIdList().size(); count++) {
                            String warningMsgId = checkMinS.getWarningMsgIdList().get(count);
                            String warningMsg = checkMinS.getWarningMsgList().get(count);
                            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                                BizUtil.getGeneralMessageId(warningMsgId), warningMsg);
                        }
                    }
                }
            }
            else if (C_GengkhouKbn.SD.eq(uiBean.getGengkhoukbn())) {

                KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                C_ErrorKbn errorKbn = keisanSP.exec(uiBean.getSyusyouhncd(),
                    uiBean.getSyuryouritusdno(),
                    uiBean.getSyuyoteiriritu(),
                    uiBean.getVhrkihrkkaisuu(),
                    uiBean.getVhsyusyuhhknnen(),
                    uiBean.getVhhkshhknsei(),
                    uiBean.getVhsyusyuhknkknsmnkbn(),
                    uiBean.getVhsyusyuhknkkn(),
                    uiBean.getVhsyusyuhrkkkn(),
                    C_Sdpd.SD,
                    uiBean.getSyukihons(),
                    newsyup,
                    uiBean.getVhsyusyukyktuukasyu(),
                    kykSyouhnLst.get(0).getKykjyoutai(),
                    kykSyouhnLst.get(0).getDai1hknkkn(),
                    uiBean.getVhrkihrkkeiro());

                if (!C_ErrorKbn.OK.eq(errorKbn)) {

                    throw new BizLogicException(keisanSP.getMsgid());
                }

                newsyup = keisanSP.getP();

                newsyupgk = uiBean.getSyukihons();
            }

            newhrkp = newhrkp.add(newsyup);

            newhkngk = newhkngk.add(newsyupgk);

            int hkaSyukousinCount = 0;

            C_UmuKbn hkaSyukousinUmu = C_UmuKbn.NONE;

            C_UmuKbn hkaTugikousinUmu = C_UmuKbn.NONE;

            BizCurrency hkaSyuTugikousinkp = BizCurrency.valueOf(0, syuCurrencyType);

            BizCurrency newTugikousinkp = BizCurrency.valueOf(0, syuCurrencyType);

            if (C_UmuKbn.ARI.eq(syuKykSyouhnViewList.get(0).getSyouhnZokusei().getKostratkiumu()) &&
                C_HknkknsmnKbn.NENMANKI.eq(uiBean.getVhsyusyuhknkknsmnkbn())) {

                SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan =
                    SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                syouhntaniKousingoPkeisan.setSyouhncd(uiBean.getSyusyouhncd());

                syouhntaniKousingoPkeisan.setSyouhnSdno(syuKykSyouhnViewList.get(0).getSyouhnsdno());

                syouhntaniKousingoPkeisan.setKeiyakubi(uiBean.getVhsyusyukykymd());

                syouhntaniKousingoPkeisan.setKatakbn(uiBean.getVhsyusyukatakbn());

                syouhntaniKousingoPkeisan.setKyhgndKatakbn(uiBean.getVhsyusyukyhgndkatakbn());

                syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(uiBean.getVhsyusyusyukyhkinkatakbn());

                syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(uiBean.getVhsyusyukhnkyhkgbairitukbn());

                syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(uiBean.getVhsyusyurokudaildkbn());

                syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(calcPmnJtkHnkKbn);

                syouhntaniKousingoPkeisan.setHknkknSmnkbn(uiBean.getVhsyusyuhknkknsmnkbn());

                syouhntaniKousingoPkeisan.setHknkkn(uiBean.getVhsyusyuhknkkn());

                syouhntaniKousingoPkeisan.setHrkkknSmnkbn(uiBean.getVhsyusyuhrkkknsmnkbn());

                syouhntaniKousingoPkeisan.setHrkkkn(uiBean.getVhsyusyuhrkkkn());

                syouhntaniKousingoPkeisan.setHhknNen(uiBean.getVhsyusyuhhknnen());

                syouhntaniKousingoPkeisan.setHhknSei(uiBean.getVhhkshhknsei());

                syouhntaniKousingoPkeisan.setHrkKaisuu(uiBean.getVhrkihrkkaisuu());

                syouhntaniKousingoPkeisan.setHrkKeiro(uiBean.getVhrkihrkkeiro());

                syouhntaniKousingoPkeisan.setSdPdKbn(uiBean.getVhsyusdpdkbn());

                syouhntaniKousingoPkeisan.setS(newsyupgk);

                syouhntaniKousingoPkeisan.exec();

                hkaSyukousinCount = syouhntaniKousingoPkeisan.getKoskaisu();

                if (hkaSyukousinCount > 0) {

                    hkaSyukousinUmu = C_UmuKbn.ARI;

                    hkaTugikousinUmu = C_UmuKbn.ARI;

                    hkaSyuTugikousinkp = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();

                    newTugikousinkp = hkaSyuTugikousinkp;
                }
            }

            uiBean.setSyukihons(newsyupgk);

            uiBean.setSyukihonkyhgk(newsyupgk.multiply(
                BizNumber.valueOf(Integer.valueOf(uiBean.getVhsyusyukhnkyhkgbairitukbn().getValue()))));

            uiBean.setSyup(newsyup);

            uiBean.setNewsyunextkosgop(hkaSyuTugikousinkp);

            uiBean.setNewSyunextkosUmu(hkaSyukousinUmu);

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyouhinHanteiKbn()) {
                uiBean.setGengakuWariai(uiBean.getNewsyukjnkngk().divideBizCurrency(
                    uiBean.getVhsyusyukykkjnkngk(), 10, RoundingMode.HALF_UP));
            }
            else {
                uiBean.setGengakuWariai(uiBean.getSyukihons().divideBizCurrency(uiBean.getVhsyusyukihons(), 10,
                    RoundingMode.HALF_UP));
            }

            CurrencyType tkCurrencyType1 = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyudisptkktuukasyu1());

            BizCurrency newtkpgk1 = BizCurrency.valueOf(0, tkCurrencyType1);

            BizCurrency newtkp1 = BizCurrency.valueOf(0, tkCurrencyType1);

            C_UmuKbn hkaTkkousinUmu1 = C_UmuKbn.NONE;

            BizCurrency hkaTkTugikousinkp1 = BizCurrency.valueOf(0, tkCurrencyType1);

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd1())) {

                if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                    calcPmnJtkHnkKbn = C_PmnjtkKbn.NONE;
                }

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn1())) {

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                        C_ErrorKbn errorKbn = keisanSP.exec(
                            uiBean.getVhsyudisptksyouhncd1(),
                            tkKykSyouhnViewList.get(0).getRyouritusdno(),
                            tkKykSyouhnViewList.get(0).getYoteiriritu(),
                            uiBean.getVhrkihrkkaisuu(),
                            uiBean.getVhsyudisptkhhknnen1(),
                            uiBean.getVhhkshhknsei(),
                            uiBean.getVhsyudisptkhknkknsmnkbn1(),
                            uiBean.getVhsyudisptkhknkkn1(),
                            uiBean.getVhsyudisptkhrkkkn1(),
                            C_Sdpd.SD,
                            uiBean.getVhsyudisptkkihons1(),
                            newtkp1,
                            uiBean.getVhsyudisptkktuukasyu1(),
                            kykSyouhnLst.get(0).getKykjyoutai(),
                            kykSyouhnLst.get(0).getDai1hknkkn(),
                            uiBean.getVhrkihrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new BizLogicException(keisanSP.getMsgid());
                        }

                        newtkp1 = keisanSP.getP();
                    }
                    else {

                        newtkp1 = uiBean.getVhsyudisptkp1();
                    }

                    newtkpgk1 = uiBean.getVhsyudisptkkihons1();
                }
                else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn1())) {

                    newtkp1 = BizCurrency.valueOf(0, tkCurrencyType1);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn1())) {

                    KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                    C_ErrorKbn errorKbn = keisanSP.exec(
                        uiBean.getVhsyudisptksyouhncd1(),
                        tkKykSyouhnViewList.get(0).getRyouritusdno(),
                        tkKykSyouhnViewList.get(0).getYoteiriritu(),
                        uiBean.getVhrkihrkkaisuu(),
                        uiBean.getVhsyudisptkhhknnen1(),
                        uiBean.getVhhkshhknsei(),
                        uiBean.getVhsyudisptkhknkknsmnkbn1(),
                        uiBean.getVhsyudisptkhknkkn1(),
                        uiBean.getVhsyudisptkhrkkkn1(),
                        C_Sdpd.SD,
                        uiBean.getNewtkkihons1(),
                        newtkp1,
                        uiBean.getVhsyudisptkktuukasyu1(),
                        kykSyouhnLst.get(0).getKykjyoutai(),
                        kykSyouhnLst.get(0).getDai1hknkkn(),
                        uiBean.getVhrkihrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbn)) {

                        throw new BizLogicException(keisanSP.getMsgid());
                    }

                    newtkp1 = keisanSP.getP();

                    newtkpgk1 = uiBean.getNewtkkihons1();
                }

                if (!C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn1())) {

                    if (C_UmuKbn.ARI.eq(tkKykSyouhnViewList.get(0).getSyouhnZokusei().getKostratkiumu()) &&
                        C_HknkknsmnKbn.NENMANKI.eq(uiBean.getVhsyudisptkhknkknsmnkbn1())) {

                        SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan =
                            SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                        syouhntaniKousingoPkeisan.setSyouhncd(uiBean.getVhsyudisptksyouhncd1());

                        syouhntaniKousingoPkeisan.setSyouhnSdno(tkKykSyouhnViewList.get(0).getSyouhnsdno());

                        syouhntaniKousingoPkeisan.setKeiyakubi(uiBean.getVhsyudisptkkykymd1());

                        syouhntaniKousingoPkeisan.setKatakbn(uiBean.getVhsyudisptokyakukatakbn1());

                        syouhntaniKousingoPkeisan.setKyhgndKatakbn(uiBean.getVhsyudisptkkyhgdkatakbn1());

                        syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(uiBean.getVhsyudisptksykyhkatakbn1());

                        syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(uiBean.getVhsyudisptkkgbairitukbn1());

                        syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(uiBean.getVhsyudisptk6daildkbn1());

                        syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(calcPmnJtkHnkKbn);

                        syouhntaniKousingoPkeisan.setHknkknSmnkbn(uiBean.getVhsyudisptkhknkknsmnkbn1());

                        syouhntaniKousingoPkeisan.setHknkkn(uiBean.getVhsyudisptkhknkkn1());

                        syouhntaniKousingoPkeisan.setHrkkknSmnkbn(uiBean.getVhsyudisptkhrkkknsmnkbn1());

                        syouhntaniKousingoPkeisan.setHrkkkn(uiBean.getVhsyudisptkhrkkkn1());

                        syouhntaniKousingoPkeisan.setHhknNen(uiBean.getVhsyudisptkhhknnen1());

                        syouhntaniKousingoPkeisan.setHhknSei(uiBean.getVhhkshhknsei());

                        syouhntaniKousingoPkeisan.setHrkKaisuu(uiBean.getVhrkihrkkaisuu());

                        syouhntaniKousingoPkeisan.setHrkKeiro(uiBean.getVhrkihrkkeiro());

                        syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);

                        syouhntaniKousingoPkeisan.setS(newtkpgk1);

                        syouhntaniKousingoPkeisan.exec();

                        hkaSyukousinCount = syouhntaniKousingoPkeisan.getKoskaisu();

                        if (hkaSyukousinCount > 0) {

                            hkaTkkousinUmu1 = C_UmuKbn.ARI;

                            hkaTugikousinUmu = C_UmuKbn.ARI;

                            hkaTkTugikousinkp1 = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();

                            newTugikousinkp = newTugikousinkp.add(hkaTkTugikousinkp1);
                        }
                    }

                    newhrkp = newhrkp.add(newtkp1);

                    newhkngk = newhkngk.add(newtkpgk1);

                    uiBean.setNewdisptkp1(newtkp1);

                    uiBean.setDispnewtknextkosumu1(hkaTkkousinUmu1);

                    uiBean.setDispnewtknextkosgop1(hkaTkTugikousinkp1);
                }
            }

            CurrencyType tkCurrencyType2 = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyudisptkktuukasyu2());

            BizCurrency newtkpgk2 = BizCurrency.valueOf(0, tkCurrencyType2);

            BizCurrency newtkp2 = BizCurrency.valueOf(0, tkCurrencyType2);

            C_UmuKbn hkaTkkousinUmu2 = C_UmuKbn.NONE;

            BizCurrency hkaTkTugikousinkp2 = BizCurrency.valueOf(0, tkCurrencyType2);

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd2())) {

                if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                    calcPmnJtkHnkKbn = C_PmnjtkKbn.NONE;
                }

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn2())) {

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                        C_ErrorKbn errorKbn = keisanSP.exec(
                            uiBean.getVhsyudisptksyouhncd2(),
                            tkKykSyouhnViewList.get(1).getRyouritusdno(),
                            tkKykSyouhnViewList.get(1).getYoteiriritu(),
                            uiBean.getVhrkihrkkaisuu(),
                            uiBean.getVhsyudisptkhhknnen2(),
                            uiBean.getVhhkshhknsei(),
                            uiBean.getVhsyudisptkhknkknsmnkbn2(),
                            uiBean.getVhsyudisptkhknkkn2(),
                            uiBean.getVhsyudisptkhrkkkn2(),
                            C_Sdpd.SD,
                            uiBean.getVhsyudisptkkihons2(),
                            newtkp2,
                            uiBean.getVhsyudisptkktuukasyu2(),
                            kykSyouhnLst.get(0).getKykjyoutai(),
                            kykSyouhnLst.get(0).getDai1hknkkn(),
                            uiBean.getVhrkihrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new BizLogicException(keisanSP.getMsgid());
                        }

                        newtkp2 = keisanSP.getP();
                    }
                    else {

                        newtkp2 = uiBean.getVhsyudisptkp2();
                    }

                    newtkpgk2 = uiBean.getVhsyudisptkkihons2();
                }
                else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn2())) {

                    newtkp2 = BizCurrency.valueOf(0, tkCurrencyType2);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn2())) {

                    KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                    C_ErrorKbn errorKbn = keisanSP.exec(
                        uiBean.getVhsyudisptksyouhncd2(),
                        tkKykSyouhnViewList.get(1).getRyouritusdno(),
                        tkKykSyouhnViewList.get(1).getYoteiriritu(),
                        uiBean.getVhrkihrkkaisuu(),
                        uiBean.getVhsyudisptkhhknnen2(),
                        uiBean.getVhhkshhknsei(),
                        uiBean.getVhsyudisptkhknkknsmnkbn2(),
                        uiBean.getVhsyudisptkhknkkn2(),
                        uiBean.getVhsyudisptkhrkkkn2(),
                        C_Sdpd.SD,
                        uiBean.getNewtkkihons2(),
                        newtkp2,
                        uiBean.getVhsyudisptkktuukasyu2(),
                        kykSyouhnLst.get(0).getKykjyoutai(),
                        kykSyouhnLst.get(0).getDai1hknkkn(),
                        uiBean.getVhrkihrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbn)) {

                        throw new BizLogicException(keisanSP.getMsgid());
                    }

                    newtkp2 = keisanSP.getP();

                    newtkpgk2 = uiBean.getNewtkkihons2();
                }

                if (!C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn2())) {

                    if (C_UmuKbn.ARI.eq(tkKykSyouhnViewList.get(1).getSyouhnZokusei().getKostratkiumu()) &&
                        C_HknkknsmnKbn.NENMANKI.eq(uiBean.getVhsyudisptkhknkknsmnkbn2())) {

                        SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan =
                            SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                        syouhntaniKousingoPkeisan.setSyouhncd(uiBean.getVhsyudisptksyouhncd2());

                        syouhntaniKousingoPkeisan.setSyouhnSdno(tkKykSyouhnViewList.get(1).getSyouhnsdno());

                        syouhntaniKousingoPkeisan.setKeiyakubi(uiBean.getVhsyudisptkkykymd2());

                        syouhntaniKousingoPkeisan.setKatakbn(uiBean.getVhsyudisptokyakukatakbn2());

                        syouhntaniKousingoPkeisan.setKyhgndKatakbn(uiBean.getVhsyudisptkkyhgdkatakbn2());

                        syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(uiBean.getVhsyudisptksykyhkatakbn2());

                        syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(uiBean.getVhsyudisptkkgbairitukbn2());

                        syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(uiBean.getVhsyudisptk6daildkbn2());

                        syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(calcPmnJtkHnkKbn);

                        syouhntaniKousingoPkeisan.setHknkknSmnkbn(uiBean.getVhsyudisptkhknkknsmnkbn2());

                        syouhntaniKousingoPkeisan.setHknkkn(uiBean.getVhsyudisptkhknkkn2());

                        syouhntaniKousingoPkeisan.setHrkkknSmnkbn(uiBean.getVhsyudisptkhrkkknsmnkbn2());

                        syouhntaniKousingoPkeisan.setHrkkkn(uiBean.getVhsyudisptkhrkkkn2());

                        syouhntaniKousingoPkeisan.setHhknNen(uiBean.getVhsyudisptkhhknnen2());

                        syouhntaniKousingoPkeisan.setHhknSei(uiBean.getVhhkshhknsei());

                        syouhntaniKousingoPkeisan.setHrkKaisuu(uiBean.getVhrkihrkkaisuu());

                        syouhntaniKousingoPkeisan.setHrkKeiro(uiBean.getVhrkihrkkeiro());

                        syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);

                        syouhntaniKousingoPkeisan.setS(newtkpgk2);

                        syouhntaniKousingoPkeisan.exec();

                        hkaSyukousinCount = syouhntaniKousingoPkeisan.getKoskaisu();

                        if (hkaSyukousinCount > 0) {

                            hkaTkkousinUmu2 = C_UmuKbn.ARI;

                            hkaTugikousinUmu = C_UmuKbn.ARI;

                            hkaTkTugikousinkp2 = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();

                            newTugikousinkp = newTugikousinkp.add(hkaTkTugikousinkp2);
                        }
                    }

                    newhrkp = newhrkp.add(newtkp2);

                    newhkngk = newhkngk.add(newtkpgk2);

                    uiBean.setNewdisptkp2(newtkp2);

                    uiBean.setDispnewtknextkosumu2(hkaTkkousinUmu2);

                    uiBean.setDispnewtknextkosgop2(hkaTkTugikousinkp2);
                }
            }

            CurrencyType tkCurrencyType3 = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyudisptkktuukasyu3());

            BizCurrency newtkpgk3 = BizCurrency.valueOf(0, tkCurrencyType3);

            BizCurrency newtkp3 = BizCurrency.valueOf(0, tkCurrencyType3);

            C_UmuKbn hkaTkkousinUmu3 = C_UmuKbn.NONE;

            BizCurrency hkaTkTugikousinkp3 = BizCurrency.valueOf(0, tkCurrencyType3);

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd3())) {

                if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                    calcPmnJtkHnkKbn = C_PmnjtkKbn.NONE;
                }

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn3())) {

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                        C_ErrorKbn errorKbn = keisanSP.exec(
                            uiBean.getVhsyudisptksyouhncd3(),
                            tkKykSyouhnViewList.get(2).getRyouritusdno(),
                            tkKykSyouhnViewList.get(2).getYoteiriritu(),
                            uiBean.getVhrkihrkkaisuu(),
                            uiBean.getVhsyudisptkhhknnen3(),
                            uiBean.getVhhkshhknsei(),
                            uiBean.getVhsyudisptkhknkknsmnkbn3(),
                            uiBean.getVhsyudisptkhknkkn3(),
                            uiBean.getVhsyudisptkhrkkkn3(),
                            C_Sdpd.SD,
                            uiBean.getVhsyudisptkkihons3(),
                            newtkp3,
                            uiBean.getVhsyudisptkktuukasyu3(),
                            kykSyouhnLst.get(0).getKykjyoutai(),
                            kykSyouhnLst.get(0).getDai1hknkkn(),
                            uiBean.getVhrkihrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new BizLogicException(keisanSP.getMsgid());
                        }

                        newtkp3 = keisanSP.getP();
                    }
                    else {

                        newtkp3 = uiBean.getVhsyudisptkp3();
                    }

                    newtkpgk3 = uiBean.getVhsyudisptkkihons3();
                }
                else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn3())) {

                    newtkp3 = BizCurrency.valueOf(0, tkCurrencyType3);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn3())) {

                    KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                    C_ErrorKbn errorKbn = keisanSP.exec(
                        uiBean.getVhsyudisptksyouhncd3(),
                        tkKykSyouhnViewList.get(2).getRyouritusdno(),
                        tkKykSyouhnViewList.get(2).getYoteiriritu(),
                        uiBean.getVhrkihrkkaisuu(),
                        uiBean.getVhsyudisptkhhknnen3(),
                        uiBean.getVhhkshhknsei(),
                        uiBean.getVhsyudisptkhknkknsmnkbn3(),
                        uiBean.getVhsyudisptkhknkkn3(),
                        uiBean.getVhsyudisptkhrkkkn3(),
                        C_Sdpd.SD,
                        uiBean.getNewtkkihons3(),
                        newtkp3,
                        uiBean.getVhsyudisptkktuukasyu3(),
                        kykSyouhnLst.get(0).getKykjyoutai(),
                        kykSyouhnLst.get(0).getDai1hknkkn(),
                        uiBean.getVhrkihrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbn)) {

                        throw new BizLogicException(keisanSP.getMsgid());
                    }

                    newtkp3 = keisanSP.getP();

                    newtkpgk3 = uiBean.getNewtkkihons3();
                }

                if (!C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn3())) {

                    if (C_UmuKbn.ARI.eq(tkKykSyouhnViewList.get(2).getSyouhnZokusei().getKostratkiumu()) &&
                        C_HknkknsmnKbn.NENMANKI.eq(uiBean.getVhsyudisptkhknkknsmnkbn3())) {

                        SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan =
                            SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                        syouhntaniKousingoPkeisan.setSyouhncd(uiBean.getVhsyudisptksyouhncd3());

                        syouhntaniKousingoPkeisan.setSyouhnSdno(tkKykSyouhnViewList.get(2).getSyouhnsdno());

                        syouhntaniKousingoPkeisan.setKeiyakubi(uiBean.getVhsyudisptkkykymd3());

                        syouhntaniKousingoPkeisan.setKatakbn(uiBean.getVhsyudisptokyakukatakbn3());

                        syouhntaniKousingoPkeisan.setKyhgndKatakbn(uiBean.getVhsyudisptkkyhgdkatakbn3());

                        syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(uiBean.getVhsyudisptksykyhkatakbn3());

                        syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(uiBean.getVhsyudisptkkgbairitukbn3());

                        syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(uiBean.getVhsyudisptk6daildkbn3());

                        syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(calcPmnJtkHnkKbn);

                        syouhntaniKousingoPkeisan.setHknkknSmnkbn(uiBean.getVhsyudisptkhknkknsmnkbn3());

                        syouhntaniKousingoPkeisan.setHknkkn(uiBean.getVhsyudisptkhknkkn3());

                        syouhntaniKousingoPkeisan.setHrkkknSmnkbn(uiBean.getVhsyudisptkhrkkknsmnkbn3());

                        syouhntaniKousingoPkeisan.setHrkkkn(uiBean.getVhsyudisptkhrkkkn3());

                        syouhntaniKousingoPkeisan.setHhknNen(uiBean.getVhsyudisptkhhknnen3());

                        syouhntaniKousingoPkeisan.setHhknSei(uiBean.getVhhkshhknsei());

                        syouhntaniKousingoPkeisan.setHrkKaisuu(uiBean.getVhrkihrkkaisuu());

                        syouhntaniKousingoPkeisan.setHrkKeiro(uiBean.getVhrkihrkkeiro());

                        syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);

                        syouhntaniKousingoPkeisan.setS(newtkpgk3);

                        syouhntaniKousingoPkeisan.exec();

                        hkaSyukousinCount = syouhntaniKousingoPkeisan.getKoskaisu();

                        if (hkaSyukousinCount > 0) {

                            hkaTkkousinUmu3 = C_UmuKbn.ARI;

                            hkaTugikousinUmu = C_UmuKbn.ARI;

                            hkaTkTugikousinkp3 = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();

                            newTugikousinkp = newTugikousinkp.add(hkaTkTugikousinkp3);
                        }
                    }

                    newhrkp = newhrkp.add(newtkp3);

                    newhkngk = newhkngk.add(newtkpgk3);

                    uiBean.setNewdisptkp3(newtkp3);

                    uiBean.setDispnewtknextkosumu3(hkaTkkousinUmu3);

                    uiBean.setDispnewtknextkosgop3(hkaTkTugikousinkp3);
                }
            }

            CurrencyType tkCurrencyType4 = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyudisptkktuukasyu4());

            BizCurrency newtkpgk4 = BizCurrency.valueOf(0, tkCurrencyType4);

            BizCurrency newtkp4 = BizCurrency.valueOf(0, tkCurrencyType4);

            C_UmuKbn hkaTkkousinUmu4 = C_UmuKbn.NONE;

            BizCurrency hkaTkTugikousinkp4 = BizCurrency.valueOf(0, tkCurrencyType4);

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd4())) {

                if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                    calcPmnJtkHnkKbn = C_PmnjtkKbn.NONE;
                }

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn4())) {

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                        C_ErrorKbn errorKbn = keisanSP.exec(
                            uiBean.getVhsyudisptksyouhncd4(),
                            tkKykSyouhnViewList.get(3).getRyouritusdno(),
                            tkKykSyouhnViewList.get(3).getYoteiriritu(),
                            uiBean.getVhrkihrkkaisuu(),
                            uiBean.getVhsyudisptkhhknnen4(),
                            uiBean.getVhhkshhknsei(),
                            uiBean.getVhsyudisptkhknkknsmnkbn4(),
                            uiBean.getVhsyudisptkhknkkn4(),
                            uiBean.getVhsyudisptkhrkkkn4(),
                            C_Sdpd.SD,
                            uiBean.getVhsyudisptkkihons4(),
                            newtkp4,
                            uiBean.getVhsyudisptkktuukasyu4(),
                            kykSyouhnLst.get(0).getKykjyoutai(),
                            kykSyouhnLst.get(0).getDai1hknkkn(),
                            uiBean.getVhrkihrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new BizLogicException(keisanSP.getMsgid());
                        }

                        newtkp4 = keisanSP.getP();
                    }
                    else {

                        newtkp4 = uiBean.getVhsyudisptkp4();
                    }

                    newtkpgk4 = uiBean.getVhsyudisptkkihons4();
                }
                else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn4())) {

                    newtkp4 = BizCurrency.valueOf(0, tkCurrencyType4);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn4())) {

                    KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                    C_ErrorKbn errorKbn = keisanSP.exec(
                        uiBean.getVhsyudisptksyouhncd4(),
                        tkKykSyouhnViewList.get(3).getRyouritusdno(),
                        tkKykSyouhnViewList.get(3).getYoteiriritu(),
                        uiBean.getVhrkihrkkaisuu(),
                        uiBean.getVhsyudisptkhhknnen4(),
                        uiBean.getVhhkshhknsei(),
                        uiBean.getVhsyudisptkhknkknsmnkbn4(),
                        uiBean.getVhsyudisptkhknkkn4(),
                        uiBean.getVhsyudisptkhrkkkn4(),
                        C_Sdpd.SD,
                        uiBean.getNewtkkihons4(),
                        newtkp4,
                        uiBean.getVhsyudisptkktuukasyu4(),
                        kykSyouhnLst.get(0).getKykjyoutai(),
                        kykSyouhnLst.get(0).getDai1hknkkn(),
                        uiBean.getVhrkihrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbn)) {

                        throw new BizLogicException(keisanSP.getMsgid());
                    }

                    newtkp4 = keisanSP.getP();

                    newtkpgk4 = uiBean.getNewtkkihons4();
                }

                if (!C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn4())) {

                    if (C_UmuKbn.ARI.eq(tkKykSyouhnViewList.get(3).getSyouhnZokusei().getKostratkiumu()) &&
                        C_HknkknsmnKbn.NENMANKI.eq(uiBean.getVhsyudisptkhknkknsmnkbn4())) {

                        SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan =
                            SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                        syouhntaniKousingoPkeisan.setSyouhncd(uiBean.getVhsyudisptksyouhncd4());

                        syouhntaniKousingoPkeisan.setSyouhnSdno(tkKykSyouhnViewList.get(3).getSyouhnsdno());

                        syouhntaniKousingoPkeisan.setKeiyakubi(uiBean.getVhsyudisptkkykymd4());

                        syouhntaniKousingoPkeisan.setKatakbn(uiBean.getVhsyudisptokyakukatakbn4());

                        syouhntaniKousingoPkeisan.setKyhgndKatakbn(uiBean.getVhsyudisptkkyhgdkatakbn4());

                        syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(uiBean.getVhsyudisptksykyhkatakbn4());

                        syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(uiBean.getVhsyudisptkkgbairitukbn4());

                        syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(uiBean.getVhsyudisptk6daildkbn4());

                        syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(calcPmnJtkHnkKbn);

                        syouhntaniKousingoPkeisan.setHknkknSmnkbn(uiBean.getVhsyudisptkhknkknsmnkbn4());

                        syouhntaniKousingoPkeisan.setHknkkn(uiBean.getVhsyudisptkhknkkn4());

                        syouhntaniKousingoPkeisan.setHrkkknSmnkbn(uiBean.getVhsyudisptkhrkkknsmnkbn4());

                        syouhntaniKousingoPkeisan.setHrkkkn(uiBean.getVhsyudisptkhrkkkn4());

                        syouhntaniKousingoPkeisan.setHhknNen(uiBean.getVhsyudisptkhhknnen4());

                        syouhntaniKousingoPkeisan.setHhknSei(uiBean.getVhhkshhknsei());

                        syouhntaniKousingoPkeisan.setHrkKaisuu(uiBean.getVhrkihrkkaisuu());

                        syouhntaniKousingoPkeisan.setHrkKeiro(uiBean.getVhrkihrkkeiro());

                        syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);

                        syouhntaniKousingoPkeisan.setS(newtkpgk4);

                        syouhntaniKousingoPkeisan.exec();

                        hkaSyukousinCount = syouhntaniKousingoPkeisan.getKoskaisu();

                        if (hkaSyukousinCount > 0) {

                            hkaTkkousinUmu4 = C_UmuKbn.ARI;

                            hkaTugikousinUmu = C_UmuKbn.ARI;

                            hkaTkTugikousinkp4 = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();

                            newTugikousinkp = newTugikousinkp.add(hkaTkTugikousinkp4);
                        }
                    }

                    newhrkp = newhrkp.add(newtkp4);

                    newhkngk = newhkngk.add(newtkpgk4);

                    uiBean.setNewdisptkp4(newtkp4);

                    uiBean.setDispnewtknextkosumu4(hkaTkkousinUmu4);

                    uiBean.setDispnewtknextkosgop4(hkaTkTugikousinkp4);
                }
            }

            CurrencyType tkCurrencyType5 = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyudisptkktuukasyu5());

            BizCurrency newtkpgk5 = BizCurrency.valueOf(0, tkCurrencyType5);

            BizCurrency newtkp5 = BizCurrency.valueOf(0, tkCurrencyType5);

            C_UmuKbn hkaTkkousinUmu5 = C_UmuKbn.NONE;

            BizCurrency hkaTkTugikousinkp5 = BizCurrency.valueOf(0, tkCurrencyType5);

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd5())) {

                if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                    calcPmnJtkHnkKbn = C_PmnjtkKbn.NONE;
                }

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn5())) {

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                        C_ErrorKbn errorKbn = keisanSP.exec(
                            uiBean.getVhsyudisptksyouhncd5(),
                            tkKykSyouhnViewList.get(4).getRyouritusdno(),
                            tkKykSyouhnViewList.get(4).getYoteiriritu(),
                            uiBean.getVhrkihrkkaisuu(),
                            uiBean.getVhsyudisptkhhknnen5(),
                            uiBean.getVhhkshhknsei(),
                            uiBean.getVhsyudisptkhknkknsmnkbn5(),
                            uiBean.getVhsyudisptkhknkkn5(),
                            uiBean.getVhsyudisptkhrkkkn5(),
                            C_Sdpd.SD,
                            uiBean.getVhsyudisptkkihons5(),
                            newtkp5,
                            uiBean.getVhsyudisptkktuukasyu5(),
                            kykSyouhnLst.get(0).getKykjyoutai(),
                            kykSyouhnLst.get(0).getDai1hknkkn(),
                            uiBean.getVhrkihrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new BizLogicException(keisanSP.getMsgid());
                        }

                        newtkp5 = keisanSP.getP();
                    }
                    else {

                        newtkp5 = uiBean.getVhsyudisptkp1();
                    }

                    newtkpgk5 = uiBean.getVhsyudisptkkihons5();
                }
                else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn5())) {

                    newtkp5 = BizCurrency.valueOf(0, tkCurrencyType5);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn5())) {

                    KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                    C_ErrorKbn errorKbn = keisanSP.exec(
                        uiBean.getVhsyudisptksyouhncd5(),
                        tkKykSyouhnViewList.get(4).getRyouritusdno(),
                        tkKykSyouhnViewList.get(4).getYoteiriritu(),
                        uiBean.getVhrkihrkkaisuu(),
                        uiBean.getVhsyudisptkhhknnen5(),
                        uiBean.getVhhkshhknsei(),
                        uiBean.getVhsyudisptkhknkknsmnkbn5(),
                        uiBean.getVhsyudisptkhknkkn5(),
                        uiBean.getVhsyudisptkhrkkkn5(),
                        C_Sdpd.SD,
                        uiBean.getNewtkkihons5(),
                        newtkp5,
                        uiBean.getVhsyudisptkktuukasyu5(),
                        kykSyouhnLst.get(0).getKykjyoutai(),
                        kykSyouhnLst.get(0).getDai1hknkkn(),
                        uiBean.getVhrkihrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbn)) {

                        throw new BizLogicException(keisanSP.getMsgid());
                    }

                    newtkp5 = keisanSP.getP();

                    newtkpgk5 = uiBean.getNewtkkihons5();
                }

                if (!C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn5())) {

                    if (C_UmuKbn.ARI.eq(tkKykSyouhnViewList.get(4).getSyouhnZokusei().getKostratkiumu()) &&
                        C_HknkknsmnKbn.NENMANKI.eq(uiBean.getVhsyudisptkhknkknsmnkbn5())) {

                        SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan =
                            SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                        syouhntaniKousingoPkeisan.setSyouhncd(uiBean.getVhsyudisptksyouhncd5());

                        syouhntaniKousingoPkeisan.setSyouhnSdno(tkKykSyouhnViewList.get(0).getSyouhnsdno());

                        syouhntaniKousingoPkeisan.setKeiyakubi(uiBean.getVhsyudisptkkykymd5());

                        syouhntaniKousingoPkeisan.setKatakbn(uiBean.getVhsyudisptokyakukatakbn5());

                        syouhntaniKousingoPkeisan.setKyhgndKatakbn(uiBean.getVhsyudisptkkyhgdkatakbn5());

                        syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(uiBean.getVhsyudisptksykyhkatakbn5());

                        syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(uiBean.getVhsyudisptkkgbairitukbn5());

                        syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(uiBean.getVhsyudisptk6daildkbn5());

                        syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(calcPmnJtkHnkKbn);

                        syouhntaniKousingoPkeisan.setHknkknSmnkbn(uiBean.getVhsyudisptkhknkknsmnkbn5());

                        syouhntaniKousingoPkeisan.setHknkkn(uiBean.getVhsyudisptkhknkkn5());

                        syouhntaniKousingoPkeisan.setHrkkknSmnkbn(uiBean.getVhsyudisptkhrkkknsmnkbn5());

                        syouhntaniKousingoPkeisan.setHrkkkn(uiBean.getVhsyudisptkhrkkkn5());

                        syouhntaniKousingoPkeisan.setHhknNen(uiBean.getVhsyudisptkhhknnen5());

                        syouhntaniKousingoPkeisan.setHhknSei(uiBean.getVhhkshhknsei());

                        syouhntaniKousingoPkeisan.setHrkKaisuu(uiBean.getVhrkihrkkaisuu());

                        syouhntaniKousingoPkeisan.setHrkKeiro(uiBean.getVhrkihrkkeiro());

                        syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);

                        syouhntaniKousingoPkeisan.setS(newtkpgk5);

                        syouhntaniKousingoPkeisan.exec();

                        hkaSyukousinCount = syouhntaniKousingoPkeisan.getKoskaisu();

                        if (hkaSyukousinCount > 0) {

                            hkaTkkousinUmu5 = C_UmuKbn.ARI;

                            hkaTugikousinUmu = C_UmuKbn.ARI;

                            hkaTkTugikousinkp5 = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();

                            newTugikousinkp = newTugikousinkp.add(hkaTkTugikousinkp5);
                        }
                    }

                    newhrkp = newhrkp.add(newtkp5);

                    newhkngk = newhkngk.add(newtkpgk5);

                    uiBean.setNewdisptkp5(newtkp5);

                    uiBean.setDispnewtknextkosumu5(hkaTkkousinUmu5);

                    uiBean.setDispnewtknextkosgop5(hkaTkTugikousinkp5);
                }
            }

            CurrencyType tkCurrencyType6 = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyudisptkktuukasyu6());

            BizCurrency newtkpgk6 = BizCurrency.valueOf(0, tkCurrencyType6);

            BizCurrency newtkp6 = BizCurrency.valueOf(0, tkCurrencyType6);

            C_UmuKbn hkaTkkousinUmu6 = C_UmuKbn.NONE;

            BizCurrency hkaTkTugikousinkp6 = BizCurrency.valueOf(0, tkCurrencyType6);

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd6())) {

                if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                    calcPmnJtkHnkKbn = C_PmnjtkKbn.NONE;
                }

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn6())) {

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                        C_ErrorKbn errorKbn = keisanSP.exec(
                            uiBean.getVhsyudisptksyouhncd6(),
                            tkKykSyouhnViewList.get(5).getRyouritusdno(),
                            tkKykSyouhnViewList.get(5).getYoteiriritu(),
                            uiBean.getVhrkihrkkaisuu(),
                            uiBean.getVhsyudisptkhhknnen6(),
                            uiBean.getVhhkshhknsei(),
                            uiBean.getVhsyudisptkhknkknsmnkbn6(),
                            uiBean.getVhsyudisptkhknkkn6(),
                            uiBean.getVhsyudisptkhrkkkn6(),
                            C_Sdpd.SD,
                            uiBean.getVhsyudisptkkihons6(),
                            newtkp6,
                            uiBean.getVhsyudisptkktuukasyu6(),
                            kykSyouhnLst.get(0).getKykjyoutai(),
                            kykSyouhnLst.get(0).getDai1hknkkn(),
                            uiBean.getVhrkihrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new BizLogicException(keisanSP.getMsgid());
                        }

                        newtkp6 = keisanSP.getP();
                    }
                    else {

                        newtkp6 = uiBean.getVhsyudisptkp6();
                    }

                    newtkpgk6 = uiBean.getVhsyudisptkkihons6();
                }
                else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn6())) {

                    newtkp6 = BizCurrency.valueOf(0, tkCurrencyType6);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn6())) {

                    KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                    C_ErrorKbn errorKbn = keisanSP.exec(
                        uiBean.getVhsyudisptksyouhncd6(),
                        tkKykSyouhnViewList.get(5).getRyouritusdno(),
                        tkKykSyouhnViewList.get(5).getYoteiriritu(),
                        uiBean.getVhrkihrkkaisuu(),
                        uiBean.getVhsyudisptkhhknnen6(),
                        uiBean.getVhhkshhknsei(),
                        uiBean.getVhsyudisptkhknkknsmnkbn6(),
                        uiBean.getVhsyudisptkhknkkn6(),
                        uiBean.getVhsyudisptkhrkkkn6(),
                        C_Sdpd.SD,
                        uiBean.getNewtkkihons6(),
                        newtkp6,
                        uiBean.getVhsyudisptkktuukasyu6(),
                        kykSyouhnLst.get(0).getKykjyoutai(),
                        kykSyouhnLst.get(0).getDai1hknkkn(),
                        uiBean.getVhrkihrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbn)) {

                        throw new BizLogicException(keisanSP.getMsgid());
                    }

                    newtkp6 = keisanSP.getP();

                    newtkpgk6 = uiBean.getNewtkkihons6();
                }

                if (!C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn6())) {

                    if (C_UmuKbn.ARI.eq(tkKykSyouhnViewList.get(5).getSyouhnZokusei().getKostratkiumu()) &&
                        C_HknkknsmnKbn.NENMANKI.eq(uiBean.getVhsyudisptkhknkknsmnkbn6())) {

                        SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan =
                            SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                        syouhntaniKousingoPkeisan.setSyouhncd(uiBean.getVhsyudisptksyouhncd6());

                        syouhntaniKousingoPkeisan.setSyouhnSdno(tkKykSyouhnViewList.get(5).getSyouhnsdno());

                        syouhntaniKousingoPkeisan.setKeiyakubi(uiBean.getVhsyudisptkkykymd6());

                        syouhntaniKousingoPkeisan.setKatakbn(uiBean.getVhsyudisptokyakukatakbn6());

                        syouhntaniKousingoPkeisan.setKyhgndKatakbn(uiBean.getVhsyudisptkkyhgdkatakbn6());

                        syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(uiBean.getVhsyudisptksykyhkatakbn6());

                        syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(uiBean.getVhsyudisptkkgbairitukbn6());

                        syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(uiBean.getVhsyudisptk6daildkbn6());

                        syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(calcPmnJtkHnkKbn);

                        syouhntaniKousingoPkeisan.setHknkknSmnkbn(uiBean.getVhsyudisptkhknkknsmnkbn6());

                        syouhntaniKousingoPkeisan.setHknkkn(uiBean.getVhsyudisptkhknkkn6());

                        syouhntaniKousingoPkeisan.setHrkkknSmnkbn(uiBean.getVhsyudisptkhrkkknsmnkbn6());

                        syouhntaniKousingoPkeisan.setHrkkkn(uiBean.getVhsyudisptkhrkkkn6());

                        syouhntaniKousingoPkeisan.setHhknNen(uiBean.getVhsyudisptkhhknnen6());

                        syouhntaniKousingoPkeisan.setHhknSei(uiBean.getVhhkshhknsei());

                        syouhntaniKousingoPkeisan.setHrkKaisuu(uiBean.getVhrkihrkkaisuu());

                        syouhntaniKousingoPkeisan.setHrkKeiro(uiBean.getVhrkihrkkeiro());

                        syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);

                        syouhntaniKousingoPkeisan.setS(newtkpgk6);

                        syouhntaniKousingoPkeisan.exec();

                        hkaSyukousinCount = syouhntaniKousingoPkeisan.getKoskaisu();

                        if (hkaSyukousinCount > 0) {

                            hkaTkkousinUmu6 = C_UmuKbn.ARI;

                            hkaTugikousinUmu = C_UmuKbn.ARI;

                            hkaTkTugikousinkp6 = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();

                            newTugikousinkp = newTugikousinkp.add(hkaTkTugikousinkp6);
                        }
                    }

                    newhrkp = newhrkp.add(newtkp6);

                    newhkngk = newhkngk.add(newtkpgk6);

                    uiBean.setNewdisptkp6(newtkp6);

                    uiBean.setDispnewtknextkosumu6(hkaTkkousinUmu6);

                    uiBean.setDispnewtknextkosgop6(hkaTkTugikousinkp6);
                }
            }

            CurrencyType tkCurrencyType7 = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyudisptkktuukasyu7());

            BizCurrency newtkpgk7 = BizCurrency.valueOf(0, tkCurrencyType7);

            BizCurrency newtkp7 = BizCurrency.valueOf(0, tkCurrencyType7);

            C_UmuKbn hkaTkkousinUmu7 = C_UmuKbn.NONE;

            BizCurrency hkaTkTugikousinkp7 = BizCurrency.valueOf(0, tkCurrencyType7);

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd7())) {

                if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                    calcPmnJtkHnkKbn = C_PmnjtkKbn.NONE;
                }

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn7())) {

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                        C_ErrorKbn errorKbn = keisanSP.exec(
                            uiBean.getVhsyudisptksyouhncd7(),
                            tkKykSyouhnViewList.get(6).getRyouritusdno(),
                            tkKykSyouhnViewList.get(6).getYoteiriritu(),
                            uiBean.getVhrkihrkkaisuu(),
                            uiBean.getVhsyudisptkhhknnen7(),
                            uiBean.getVhhkshhknsei(),
                            uiBean.getVhsyudisptkhknkknsmnkbn7(),
                            uiBean.getVhsyudisptkhknkkn7(),
                            uiBean.getVhsyudisptkhrkkkn7(),
                            C_Sdpd.SD,
                            uiBean.getVhsyudisptkkihons7(),
                            newtkp7,
                            uiBean.getVhsyudisptkktuukasyu7(),
                            kykSyouhnLst.get(0).getKykjyoutai(),
                            kykSyouhnLst.get(0).getDai1hknkkn(),
                            uiBean.getVhrkihrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new BizLogicException(keisanSP.getMsgid());
                        }

                        newtkp7 = keisanSP.getP();
                    }
                    else {

                        newtkp7 = uiBean.getVhsyudisptkp7();
                    }

                    newtkpgk7 = uiBean.getVhsyudisptkkihons7();
                }
                else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn7())) {

                    newtkp7 = BizCurrency.valueOf(0, tkCurrencyType7);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn7())) {

                    KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                    C_ErrorKbn errorKbn = keisanSP.exec(
                        uiBean.getVhsyudisptksyouhncd7(),
                        tkKykSyouhnViewList.get(6).getRyouritusdno(),
                        tkKykSyouhnViewList.get(6).getYoteiriritu(),
                        uiBean.getVhrkihrkkaisuu(),
                        uiBean.getVhsyudisptkhhknnen7(),
                        uiBean.getVhhkshhknsei(),
                        uiBean.getVhsyudisptkhknkknsmnkbn7(),
                        uiBean.getVhsyudisptkhknkkn7(),
                        uiBean.getVhsyudisptkhrkkkn7(),
                        C_Sdpd.SD,
                        uiBean.getNewtkkihons7(),
                        newtkp7,
                        uiBean.getVhsyudisptkktuukasyu7(),
                        kykSyouhnLst.get(0).getKykjyoutai(),
                        kykSyouhnLst.get(0).getDai1hknkkn(),
                        uiBean.getVhrkihrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbn)) {

                        throw new BizLogicException(keisanSP.getMsgid());
                    }

                    newtkp7 = keisanSP.getP();

                    newtkpgk7 = uiBean.getNewtkkihons7();
                }

                if (!C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn1())) {

                    if (C_UmuKbn.ARI.eq(tkKykSyouhnViewList.get(6).getSyouhnZokusei().getKostratkiumu()) &&
                        C_HknkknsmnKbn.NENMANKI.eq(uiBean.getVhsyudisptkhknkknsmnkbn7())) {

                        SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan =
                            SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                        syouhntaniKousingoPkeisan.setSyouhncd(uiBean.getVhsyudisptksyouhncd7());

                        syouhntaniKousingoPkeisan.setSyouhnSdno(tkKykSyouhnViewList.get(6).getSyouhnsdno());

                        syouhntaniKousingoPkeisan.setKeiyakubi(uiBean.getVhsyudisptkkykymd7());

                        syouhntaniKousingoPkeisan.setKatakbn(uiBean.getVhsyudisptokyakukatakbn7());

                        syouhntaniKousingoPkeisan.setKyhgndKatakbn(uiBean.getVhsyudisptkkyhgdkatakbn7());

                        syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(uiBean.getVhsyudisptksykyhkatakbn7());

                        syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(uiBean.getVhsyudisptkkgbairitukbn7());

                        syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(uiBean.getVhsyudisptk6daildkbn7());

                        syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(calcPmnJtkHnkKbn);

                        syouhntaniKousingoPkeisan.setHknkknSmnkbn(uiBean.getVhsyudisptkhknkknsmnkbn7());

                        syouhntaniKousingoPkeisan.setHknkkn(uiBean.getVhsyudisptkhknkkn7());

                        syouhntaniKousingoPkeisan.setHrkkknSmnkbn(uiBean.getVhsyudisptkhrkkknsmnkbn7());

                        syouhntaniKousingoPkeisan.setHrkkkn(uiBean.getVhsyudisptkhrkkkn7());

                        syouhntaniKousingoPkeisan.setHhknNen(uiBean.getVhsyudisptkhhknnen7());

                        syouhntaniKousingoPkeisan.setHhknSei(uiBean.getVhhkshhknsei());

                        syouhntaniKousingoPkeisan.setHrkKaisuu(uiBean.getVhrkihrkkaisuu());

                        syouhntaniKousingoPkeisan.setHrkKeiro(uiBean.getVhrkihrkkeiro());

                        syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);

                        syouhntaniKousingoPkeisan.setS(newtkpgk7);

                        syouhntaniKousingoPkeisan.exec();

                        hkaSyukousinCount = syouhntaniKousingoPkeisan.getKoskaisu();

                        if (hkaSyukousinCount > 0) {

                            hkaTkkousinUmu7 = C_UmuKbn.ARI;

                            hkaTugikousinUmu = C_UmuKbn.ARI;

                            hkaTkTugikousinkp7 = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();

                            newTugikousinkp = newTugikousinkp.add(hkaTkTugikousinkp7);
                        }
                    }

                    newhrkp = newhrkp.add(newtkp7);

                    newhkngk = newhkngk.add(newtkpgk7);

                    uiBean.setNewdisptkp7(newtkp7);

                    uiBean.setDispnewtknextkosumu7(hkaTkkousinUmu7);

                    uiBean.setDispnewtknextkosgop7(hkaTkTugikousinkp7);
                }
            }

            CurrencyType tkCurrencyType8 = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyudisptkktuukasyu8());

            BizCurrency newtkpgk8 = BizCurrency.valueOf(0, tkCurrencyType8);

            BizCurrency newtkp8 = BizCurrency.valueOf(0, tkCurrencyType8);

            C_UmuKbn hkaTkkousinUmu8 = C_UmuKbn.NONE;

            BizCurrency hkaTkTugikousinkp8 = BizCurrency.valueOf(0, tkCurrencyType8);

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd8())) {

                if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                    calcPmnJtkHnkKbn = C_PmnjtkKbn.NONE;
                }

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn8())) {

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                        C_ErrorKbn errorKbn = keisanSP.exec(
                            uiBean.getVhsyudisptksyouhncd8(),
                            tkKykSyouhnViewList.get(7).getRyouritusdno(),
                            tkKykSyouhnViewList.get(7).getYoteiriritu(),
                            uiBean.getVhrkihrkkaisuu(),
                            uiBean.getVhsyudisptkhhknnen8(),
                            uiBean.getVhhkshhknsei(),
                            uiBean.getVhsyudisptkhknkknsmnkbn8(),
                            uiBean.getVhsyudisptkhknkkn8(),
                            uiBean.getVhsyudisptkhrkkkn8(),
                            C_Sdpd.SD,
                            uiBean.getVhsyudisptkkihons8(),
                            newtkp8,
                            uiBean.getVhsyudisptkktuukasyu8(),
                            kykSyouhnLst.get(0).getKykjyoutai(),
                            kykSyouhnLst.get(0).getDai1hknkkn(),
                            uiBean.getVhrkihrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new BizLogicException(keisanSP.getMsgid());
                        }

                        newtkp8 = keisanSP.getP();
                    }
                    else {

                        newtkp8 = uiBean.getVhsyudisptkp8();
                    }

                    newtkpgk8 = uiBean.getVhsyudisptkkihons8();
                }
                else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn8())) {

                    newtkp8 = BizCurrency.valueOf(0, tkCurrencyType8);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn8())) {

                    KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                    C_ErrorKbn errorKbn = keisanSP.exec(
                        uiBean.getVhsyudisptksyouhncd8(),
                        tkKykSyouhnViewList.get(7).getRyouritusdno(),
                        tkKykSyouhnViewList.get(7).getYoteiriritu(),
                        uiBean.getVhrkihrkkaisuu(),
                        uiBean.getVhsyudisptkhhknnen8(),
                        uiBean.getVhhkshhknsei(),
                        uiBean.getVhsyudisptkhknkknsmnkbn8(),
                        uiBean.getVhsyudisptkhknkkn8(),
                        uiBean.getVhsyudisptkhrkkkn8(),
                        C_Sdpd.SD,
                        uiBean.getNewtkkihons8(),
                        newtkp8,
                        uiBean.getVhsyudisptkktuukasyu8(),
                        kykSyouhnLst.get(0).getKykjyoutai(),
                        kykSyouhnLst.get(0).getDai1hknkkn(),
                        uiBean.getVhrkihrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbn)) {

                        throw new BizLogicException(keisanSP.getMsgid());
                    }

                    newtkp8 = keisanSP.getP();

                    newtkpgk8 = uiBean.getNewtkkihons8();
                }

                if (!C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn8())) {

                    if (C_UmuKbn.ARI.eq(tkKykSyouhnViewList.get(0).getSyouhnZokusei().getKostratkiumu()) &&
                        C_HknkknsmnKbn.NENMANKI.eq(uiBean.getVhsyudisptkhknkknsmnkbn8())) {

                        SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan =
                            SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                        syouhntaniKousingoPkeisan.setSyouhncd(uiBean.getVhsyudisptksyouhncd8());

                        syouhntaniKousingoPkeisan.setSyouhnSdno(tkKykSyouhnViewList.get(0).getSyouhnsdno());

                        syouhntaniKousingoPkeisan.setKeiyakubi(uiBean.getVhsyudisptkkykymd8());

                        syouhntaniKousingoPkeisan.setKatakbn(uiBean.getVhsyudisptokyakukatakbn8());

                        syouhntaniKousingoPkeisan.setKyhgndKatakbn(uiBean.getVhsyudisptkkyhgdkatakbn8());

                        syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(uiBean.getVhsyudisptksykyhkatakbn8());

                        syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(uiBean.getVhsyudisptkkgbairitukbn8());

                        syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(uiBean.getVhsyudisptk6daildkbn8());

                        syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(calcPmnJtkHnkKbn);

                        syouhntaniKousingoPkeisan.setHknkknSmnkbn(uiBean.getVhsyudisptkhknkknsmnkbn8());

                        syouhntaniKousingoPkeisan.setHknkkn(uiBean.getVhsyudisptkhknkkn8());

                        syouhntaniKousingoPkeisan.setHrkkknSmnkbn(uiBean.getVhsyudisptkhrkkknsmnkbn8());

                        syouhntaniKousingoPkeisan.setHrkkkn(uiBean.getVhsyudisptkhrkkkn8());

                        syouhntaniKousingoPkeisan.setHhknNen(uiBean.getVhsyudisptkhhknnen1());

                        syouhntaniKousingoPkeisan.setHhknSei(uiBean.getVhhkshhknsei());

                        syouhntaniKousingoPkeisan.setHrkKaisuu(uiBean.getVhrkihrkkaisuu());

                        syouhntaniKousingoPkeisan.setHrkKeiro(uiBean.getVhrkihrkkeiro());

                        syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);

                        syouhntaniKousingoPkeisan.setS(newtkpgk8);

                        syouhntaniKousingoPkeisan.exec();

                        hkaSyukousinCount = syouhntaniKousingoPkeisan.getKoskaisu();

                        if (hkaSyukousinCount > 0) {

                            hkaTkkousinUmu8 = C_UmuKbn.ARI;

                            hkaTugikousinUmu = C_UmuKbn.ARI;

                            hkaTkTugikousinkp8 = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();

                            newTugikousinkp = newTugikousinkp.add(hkaTkTugikousinkp8);
                        }
                    }

                    newhrkp = newhrkp.add(newtkp8);

                    newhkngk = newhkngk.add(newtkpgk8);

                    uiBean.setNewdisptkp8(newtkp8);

                    uiBean.setDispnewtknextkosumu8(hkaTkkousinUmu8);

                    uiBean.setDispnewtknextkosgop8(hkaTkTugikousinkp8);
                }
            }

            CurrencyType tkCurrencyType9 = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyudisptkktuukasyu9());

            BizCurrency newtkpgk9 = BizCurrency.valueOf(0, tkCurrencyType9);

            BizCurrency newtkp9 = BizCurrency.valueOf(0, tkCurrencyType9);

            C_UmuKbn hkaTkkousinUmu9 = C_UmuKbn.NONE;

            BizCurrency hkaTkTugikousinkp9 = BizCurrency.valueOf(0, tkCurrencyType9);

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd9())) {

                if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                    calcPmnJtkHnkKbn = C_PmnjtkKbn.NONE;
                }

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn9())) {

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                        C_ErrorKbn errorKbn = keisanSP.exec(
                            uiBean.getVhsyudisptksyouhncd9(),
                            tkKykSyouhnViewList.get(8).getRyouritusdno(),
                            tkKykSyouhnViewList.get(8).getYoteiriritu(),
                            uiBean.getVhrkihrkkaisuu(),
                            uiBean.getVhsyudisptkhhknnen9(),
                            uiBean.getVhhkshhknsei(),
                            uiBean.getVhsyudisptkhknkknsmnkbn9(),
                            uiBean.getVhsyudisptkhknkkn9(),
                            uiBean.getVhsyudisptkhrkkkn9(),
                            C_Sdpd.SD,
                            uiBean.getVhsyudisptkkihons9(),
                            newtkp9,
                            uiBean.getVhsyudisptkktuukasyu9(),
                            kykSyouhnLst.get(0).getKykjyoutai(),
                            kykSyouhnLst.get(0).getDai1hknkkn(),
                            uiBean.getVhrkihrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new BizLogicException(keisanSP.getMsgid());
                        }

                        newtkp9 = keisanSP.getP();
                    }
                    else {

                        newtkp9 = uiBean.getVhsyudisptkp9();
                    }

                    newtkpgk9 = uiBean.getVhsyudisptkkihons9();
                }
                else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn9())) {

                    newtkp9 = BizCurrency.valueOf(0, tkCurrencyType9);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn9())) {

                    KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                    C_ErrorKbn errorKbn = keisanSP.exec(
                        uiBean.getVhsyudisptksyouhncd9(),
                        tkKykSyouhnViewList.get(8).getRyouritusdno(),
                        tkKykSyouhnViewList.get(8).getYoteiriritu(),
                        uiBean.getVhrkihrkkaisuu(),
                        uiBean.getVhsyudisptkhhknnen9(),
                        uiBean.getVhhkshhknsei(),
                        uiBean.getVhsyudisptkhknkknsmnkbn9(),
                        uiBean.getVhsyudisptkhknkkn9(),
                        uiBean.getVhsyudisptkhrkkkn9(),
                        C_Sdpd.SD,
                        uiBean.getNewtkkihons9(),
                        newtkp9,
                        uiBean.getVhsyudisptkktuukasyu9(),
                        kykSyouhnLst.get(0).getKykjyoutai(),
                        kykSyouhnLst.get(0).getDai1hknkkn(),
                        uiBean.getVhrkihrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbn)) {

                        throw new BizLogicException(keisanSP.getMsgid());
                    }

                    newtkp9 = keisanSP.getP();

                    newtkpgk9 = uiBean.getNewtkkihons9();
                }

                if (!C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn9())) {

                    if (C_UmuKbn.ARI.eq(tkKykSyouhnViewList.get(8).getSyouhnZokusei().getKostratkiumu()) &&
                        C_HknkknsmnKbn.NENMANKI.eq(uiBean.getVhsyudisptkhknkknsmnkbn9())) {

                        SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan =
                            SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                        syouhntaniKousingoPkeisan.setSyouhncd(uiBean.getVhsyudisptksyouhncd9());

                        syouhntaniKousingoPkeisan.setSyouhnSdno(tkKykSyouhnViewList.get(8).getSyouhnsdno());

                        syouhntaniKousingoPkeisan.setKeiyakubi(uiBean.getVhsyudisptkkykymd9());

                        syouhntaniKousingoPkeisan.setKatakbn(uiBean.getVhsyudisptokyakukatakbn9());

                        syouhntaniKousingoPkeisan.setKyhgndKatakbn(uiBean.getVhsyudisptkkyhgdkatakbn9());

                        syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(uiBean.getVhsyudisptksykyhkatakbn9());

                        syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(uiBean.getVhsyudisptkkgbairitukbn9());

                        syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(uiBean.getVhsyudisptk6daildkbn9());

                        syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(calcPmnJtkHnkKbn);

                        syouhntaniKousingoPkeisan.setHknkknSmnkbn(uiBean.getVhsyudisptkhknkknsmnkbn9());

                        syouhntaniKousingoPkeisan.setHknkkn(uiBean.getVhsyudisptkhknkkn9());

                        syouhntaniKousingoPkeisan.setHrkkknSmnkbn(uiBean.getVhsyudisptkhrkkknsmnkbn9());

                        syouhntaniKousingoPkeisan.setHrkkkn(uiBean.getVhsyudisptkhrkkkn9());

                        syouhntaniKousingoPkeisan.setHhknNen(uiBean.getVhsyudisptkhhknnen9());

                        syouhntaniKousingoPkeisan.setHhknSei(uiBean.getVhhkshhknsei());

                        syouhntaniKousingoPkeisan.setHrkKaisuu(uiBean.getVhrkihrkkaisuu());

                        syouhntaniKousingoPkeisan.setHrkKeiro(uiBean.getVhrkihrkkeiro());

                        syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);

                        syouhntaniKousingoPkeisan.setS(newtkpgk9);

                        syouhntaniKousingoPkeisan.exec();

                        hkaSyukousinCount = syouhntaniKousingoPkeisan.getKoskaisu();

                        if (hkaSyukousinCount > 0) {

                            hkaTkkousinUmu9 = C_UmuKbn.ARI;

                            hkaTugikousinUmu = C_UmuKbn.ARI;

                            hkaTkTugikousinkp9 = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();

                            newTugikousinkp = newTugikousinkp.add(hkaTkTugikousinkp9);
                        }
                    }

                    newhrkp = newhrkp.add(newtkp9);

                    newhkngk = newhkngk.add(newtkpgk9);

                    uiBean.setNewdisptkp9(newtkp9);

                    uiBean.setDispnewtknextkosumu9(hkaTkkousinUmu9);

                    uiBean.setDispnewtknextkosgop9(hkaTkTugikousinkp9);
                }
            }

            CurrencyType tkCurrencyType10 = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyudisptkktuukasyu10());

            BizCurrency newtkpgk10 = BizCurrency.valueOf(0, tkCurrencyType10);

            BizCurrency newtkp10 = BizCurrency.valueOf(0, tkCurrencyType10);

            C_UmuKbn hkaTkkousinUmu10 = C_UmuKbn.NONE;

            BizCurrency hkaTkTugikousinkp10 = BizCurrency.valueOf(0, tkCurrencyType10);

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd10())) {

                if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                    calcPmnJtkHnkKbn = C_PmnjtkKbn.NONE;
                }

                if (C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn10())) {

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                        C_ErrorKbn errorKbn = keisanSP.exec(
                            uiBean.getVhsyudisptksyouhncd10(),
                            tkKykSyouhnViewList.get(9).getRyouritusdno(),
                            tkKykSyouhnViewList.get(9).getYoteiriritu(),
                            uiBean.getVhrkihrkkaisuu(),
                            uiBean.getVhsyudisptkhhknnen10(),
                            uiBean.getVhhkshhknsei(),
                            uiBean.getVhsyudisptkhknkknsmnkbn10(),
                            uiBean.getVhsyudisptkhknkkn10(),
                            uiBean.getVhsyudisptkhrkkkn10(),
                            C_Sdpd.SD,
                            uiBean.getVhsyudisptkkihons10(),
                            newtkp10,
                            uiBean.getVhsyudisptkktuukasyu10(),
                            kykSyouhnLst.get(0).getKykjyoutai(),
                            kykSyouhnLst.get(0).getDai1hknkkn(),
                            uiBean.getVhrkihrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new BizLogicException(keisanSP.getMsgid());
                        }

                        newtkp10 = keisanSP.getP();
                    }
                    else {

                        newtkp10 = uiBean.getVhsyudisptkp10();
                    }

                    newtkpgk10 = uiBean.getVhsyudisptkkihons10();
                }
                else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn10())) {

                    newtkp10 = BizCurrency.valueOf(0, tkCurrencyType10);
                }
                else if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn10())) {

                    KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);

                    C_ErrorKbn errorKbn = keisanSP.exec(
                        uiBean.getVhsyudisptksyouhncd10(),
                        tkKykSyouhnViewList.get(9).getRyouritusdno(),
                        tkKykSyouhnViewList.get(9).getYoteiriritu(),
                        uiBean.getVhrkihrkkaisuu(),
                        uiBean.getVhsyudisptkhhknnen10(),
                        uiBean.getVhhkshhknsei(),
                        uiBean.getVhsyudisptkhknkknsmnkbn10(),
                        uiBean.getVhsyudisptkhknkkn10(),
                        uiBean.getVhsyudisptkhrkkkn10(),
                        C_Sdpd.SD,
                        uiBean.getNewtkkihons10(),
                        newtkp10,
                        uiBean.getVhsyudisptkktuukasyu10(),
                        kykSyouhnLst.get(0).getKykjyoutai(),
                        kykSyouhnLst.get(0).getDai1hknkkn(),
                        uiBean.getVhrkihrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbn)) {

                        throw new BizLogicException(keisanSP.getMsgid());
                    }

                    newtkp10 = keisanSP.getP();

                    newtkpgk10 = uiBean.getNewtkkihons10();
                }

                if (!C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn1())) {

                    if (C_UmuKbn.ARI.eq(tkKykSyouhnViewList.get(9).getSyouhnZokusei().getKostratkiumu()) &&
                        C_HknkknsmnKbn.NENMANKI.eq(uiBean.getVhsyudisptkhknkknsmnkbn10())) {

                        SyouhntaniKousingoPkeisan syouhntaniKousingoPkeisan =
                            SWAKInjector.getInstance(SyouhntaniKousingoPkeisan.class);

                        syouhntaniKousingoPkeisan.setSyouhncd(uiBean.getVhsyudisptksyouhncd10());

                        syouhntaniKousingoPkeisan.setSyouhnSdno(tkKykSyouhnViewList.get(9).getSyouhnsdno());

                        syouhntaniKousingoPkeisan.setKeiyakubi(uiBean.getVhsyudisptkkykymd10());

                        syouhntaniKousingoPkeisan.setKatakbn(uiBean.getVhsyudisptokyakukatakbn10());

                        syouhntaniKousingoPkeisan.setKyhgndKatakbn(uiBean.getVhsyudisptkkyhgdkatakbn10());

                        syouhntaniKousingoPkeisan.setSyukyhkinKatakbn(uiBean.getVhsyudisptksykyhkatakbn10());

                        syouhntaniKousingoPkeisan.setKhnkyhkgbairituKbn(uiBean.getVhsyudisptkkgbairitukbn10());

                        syouhntaniKousingoPkeisan.set6DaisktsyknTuikakyhKatakbn(uiBean.getVhsyudisptk6daildkbn10());

                        syouhntaniKousingoPkeisan.setPmnjtkhukaKbn(calcPmnJtkHnkKbn);

                        syouhntaniKousingoPkeisan.setHknkknSmnkbn(uiBean.getVhsyudisptkhknkknsmnkbn10());

                        syouhntaniKousingoPkeisan.setHknkkn(uiBean.getVhsyudisptkhknkkn10());

                        syouhntaniKousingoPkeisan.setHrkkknSmnkbn(uiBean.getVhsyudisptkhrkkknsmnkbn10());

                        syouhntaniKousingoPkeisan.setHrkkkn(uiBean.getVhsyudisptkhrkkkn10());

                        syouhntaniKousingoPkeisan.setHhknNen(uiBean.getVhsyudisptkhhknnen10());

                        syouhntaniKousingoPkeisan.setHhknSei(uiBean.getVhhkshhknsei());

                        syouhntaniKousingoPkeisan.setHrkKaisuu(uiBean.getVhrkihrkkaisuu());

                        syouhntaniKousingoPkeisan.setHrkKeiro(uiBean.getVhrkihrkkeiro());

                        syouhntaniKousingoPkeisan.setSdPdKbn(C_Sdpd.SD);

                        syouhntaniKousingoPkeisan.setS(newtkpgk10);

                        syouhntaniKousingoPkeisan.exec();

                        hkaSyukousinCount = syouhntaniKousingoPkeisan.getKoskaisu();

                        if (hkaSyukousinCount > 0) {

                            hkaTkkousinUmu10 = C_UmuKbn.ARI;

                            hkaTugikousinUmu = C_UmuKbn.ARI;

                            hkaTkTugikousinkp10 = syouhntaniKousingoPkeisan.getKosnaiymeiskmk()[0].getHknry();

                            newTugikousinkp = newTugikousinkp.add(hkaTkTugikousinkp10);
                        }
                    }

                    newhrkp = newhrkp.add(newtkp10);

                    newhkngk = newhkngk.add(newtkpgk10);

                    uiBean.setNewdisptkp10(newtkp10);

                    uiBean.setDispnewtknextkosumu10(hkaTkkousinUmu10);

                    uiBean.setDispnewtknextkosgop10(hkaTkTugikousinkp10);
                }
            }

            uiBean.setNewhrkp(newhrkp);

            uiBean.setNewnextkosgohrkp(newTugikousinkp);

            uiBean.setNewNextkosUmu(hkaTugikousinUmu);

            uiBean.setNewhkngk(newhkngk);



            BizCurrency kaiyakuhr = BizCurrency.valueOf(0, syuCurrencyType);
            BizCurrency oldKaiyakuhr = BizCurrency.valueOf(0, syuCurrencyType);
            BizCurrency newKaiyakuhr = BizCurrency.valueOf(0, syuCurrencyType);
            BizCurrency zennouseisankgkknrtuuka = BizCurrency.valueOf(0, uiBean.getSyup().getType());
            BizCurrency oldZennouseisankgkknrtuuka = BizCurrency.valueOf(0, uiBean.getSyup().getType());
            BizCurrency newZennouseisankgkknrtuuka = BizCurrency.valueOf(0, uiBean.getSyup().getType());
            BizCurrency mikeikapknrtuuka = BizCurrency.valueOf(0, uiBean.getSyup().getType());
            BizCurrency oldMikeikapknrtuuka = BizCurrency.valueOf(0, uiBean.getSyup().getType());
            BizCurrency newMikeikapknrtuuka = BizCurrency.valueOf(0, uiBean.getSyup().getType());
            BizCurrency haitoukin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency yensonotashrgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency syukaiyakuhr = BizCurrency.valueOf(0, syuCurrencyType);
            BizDateYM lastPJyuutouYm = null;
            MiKeikaPBean[] oldmiKeikaPBeans = null;
            MiKeikaPBean[] newmiKeikaPBeans = null;

            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            BizDateYM kaiyakuhrKeisankijyunYm = keisanWKijunYM.exec(uiBean.getVhsyusyukykymd(),
                uiBean.getSyoruiukeymd(), jkipjytym, uiBean.getVhrkihrkkaisuu(), kykSyouhnLst.get(0).getKykjyoutai(),
                uiBean.getSyusyouhncd(), uiBean.getYendtHnkYmd());

            KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);

            C_ErrorKbn errorKbn = keisanWExt.exec(uiBean.getSyono(), uiBean.getSyoruiukeymd());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("解約返戻金計算拡張情報作成が実行できませんでした。");
            }

            KeisanWExtBean keisanWExtBean = keisanWExt.getKeisanWExtBean();

            KeisanW keisanWGengakuMae = SWAKInjector.getInstance(KeisanW.class);

            C_ErrorKbn errorKbnGengakuMae = keisanWGengakuMae.exec(uiBean.getSyoruiukeymd(), kaiyakuhrKeisankijyunYm,
                keisanWExtBean);

            if (C_ErrorKbn.ERROR.eq(errorKbnGengakuMae)) {

                throw new CommonBizAppException("解約返戻金計算（減額前）が実行できませんでした。");
            }

            oldKaiyakuhr = keisanWGengakuMae.getW();

            if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn() ||
                SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyouhinHanteiKbn()) &&
                !C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {

                if (C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) {
                    uiBean.setTeirituTmttkngk(uiBean.getSyukihons());
                    uiBean.setSisuuRendouTmttkngk(BizCurrency.valueOf(0,syuCurrencyType));
                }
                else {
                    uiBean.setTeirituTmttkngk(keisanWExtBean.getTeiritutmttkngk().multiply(uiBean.getGengakuWariai()).toValidValue(RoundingMode.UP));

                    uiBean.setSisuuRendouTmttkngk(keisanWExtBean.getSisuurendoutmttkngk().multiply(uiBean.getGengakuWariai()).toValidValue(RoundingMode.UP));
                }

                keisanWExtBean.setTeiritutmttkngk(uiBean.getTeirituTmttkngk());
                keisanWExtBean.setSisuurendoutmttkngk(uiBean.getSisuuRendouTmttkngk());
                keisanWExtBean.setHokenryou(newhrkp);
            }
            else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyouhinHanteiKbn()) {
                keisanWExtBean.setHokenryou(uiBean.getSyup());
                keisanWExtBean.setTmttkntaisyouym(null);
                keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
                keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
            }
            else {
                keisanWExtBean.setKihons(uiBean.getSyukihons());
                keisanWExtBean.setHokenryou(uiBean.getSyup());
            }

            KeisanW keisanWGengakuGo = SWAKInjector.getInstance(KeisanW.class);

            C_ErrorKbn errorKbnGengakuGo = keisanWGengakuGo.exec(uiBean.getSyoruiukeymd(), kaiyakuhrKeisankijyunYm,
                keisanWExtBean);

            if (C_ErrorKbn.ERROR.eq(errorKbnGengakuGo)) {

                throw new CommonBizAppException("解約返戻金計算（減額後）が実行できませんでした。");
            }

            newKaiyakuhr = keisanWGengakuGo.getW();
            uiBean.setPtmttkngk(keisanWGengakuGo.getV());
            uiBean.setKihrkmpstgk(keisanWGengakuGo.getPruikei());
            uiBean.setPtumitatekinTyoseimae(keisanWGengakuGo.getPtumitatekinTyoseimae());
            uiBean.setTmttkntaisyouym(kaiyakuhrKeisankijyunYm);
            syukaiyakuhr = oldKaiyakuhr.subtract(newKaiyakuhr);
            kaiyakuhr = kaiyakuhr.add(syukaiyakuhr);

            uiBean.setSyuKaiyakuHr(syukaiyakuhr);

            uiBean.setShrTsTmttkin(BizCurrency.valueOf(0, syuCurrencyType));

            uiBean.setSjkkktyouseigk(BizCurrency.valueOf(0, syuCurrencyType));

            uiBean.setSjkkktyouseirt(BizNumber.ZERO);

            uiBean.setKaiyakuSjkkkTyouseiriRitu(BizNumber.valueOf(0));

            uiBean.setKaiyakuKjgk(BizCurrency.valueOf(0, syuCurrencyType));

            uiBean.setKaiyakuKoujyoritu(BizNumber.valueOf(0));

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd1())) {

                BizCurrency tkKaiyakuhr1 = BizCurrency.valueOf(0, tkCurrencyType1);

                uiBean.setDispTkKaiyakuHr1(tkKaiyakuhr1);

                kaiyakuhr = kaiyakuhr.add(tkKaiyakuhr1);
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd2())) {

                BizCurrency tkKaiyakuhr2 = BizCurrency.valueOf(0, tkCurrencyType2);

                uiBean.setDispTkKaiyakuHr2(tkKaiyakuhr2);

                kaiyakuhr = kaiyakuhr.add(tkKaiyakuhr2);
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd3())) {

                BizCurrency tkKaiyakuhr3 = BizCurrency.valueOf(0, tkCurrencyType3);

                uiBean.setDispTkKaiyakuHr3(tkKaiyakuhr3);

                kaiyakuhr = kaiyakuhr.add(tkKaiyakuhr3);
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd4())) {

                BizCurrency tkKaiyakuhr4 = BizCurrency.valueOf(0, tkCurrencyType4);

                uiBean.setDispTkKaiyakuHr4(tkKaiyakuhr4);

                kaiyakuhr = kaiyakuhr.add(tkKaiyakuhr4);
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd5())) {

                BizCurrency tkKaiyakuhr5 = BizCurrency.valueOf(0, tkCurrencyType5);

                uiBean.setDispTkKaiyakuHr5(tkKaiyakuhr5);

                kaiyakuhr = kaiyakuhr.add(tkKaiyakuhr5);
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd6())) {

                BizCurrency tkKaiyakuhr6 = BizCurrency.valueOf(0, tkCurrencyType6);

                uiBean.setDispTkKaiyakuHr6(tkKaiyakuhr6);

                kaiyakuhr = kaiyakuhr.add(tkKaiyakuhr6);
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd7())) {

                BizCurrency tkKaiyakuhr7 = BizCurrency.valueOf(0, tkCurrencyType7);

                uiBean.setDispTkKaiyakuHr7(tkKaiyakuhr7);

                kaiyakuhr = kaiyakuhr.add(tkKaiyakuhr7);
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd8())) {

                BizCurrency tkKaiyakuhr8 = BizCurrency.valueOf(0, tkCurrencyType8);

                uiBean.setDispTkKaiyakuHr8(tkKaiyakuhr8);

                kaiyakuhr = kaiyakuhr.add(tkKaiyakuhr8);
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd9())) {

                BizCurrency tkKaiyakuhr9 = BizCurrency.valueOf(0, tkCurrencyType9);

                uiBean.setDispTkKaiyakuHr9(tkKaiyakuhr9);

                kaiyakuhr = kaiyakuhr.add(tkKaiyakuhr9);
            }

            if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd10())) {

                BizCurrency tkKaiyakuhr10 = BizCurrency.valueOf(0, tkCurrencyType10);

                uiBean.setDispTkKaiyakuHr10(tkKaiyakuhr10);

                kaiyakuhr = kaiyakuhr.add(tkKaiyakuhr10);
            }

            uiBean.setKaiyakuhr(kaiyakuhr);

            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(uiBean.getVhrkitikiktbrijk()) ||
                C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(uiBean.getVhrkitikiktbrijk())) {
                KeisanIkkatuPGkBean keisanIkkatuPGkBean = SWAKInjector.getInstance(KeisanIkkatuPGkBean.class);
                KeisanIkkatuPGk keisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);

                keisanIkkatuPGkBean.setSyouhnCd(kykSyouhnLst.get(0).getSyouhncd());
                keisanIkkatuPGkBean.setSyouhnsdNo(kykSyouhnLst.get(0).getSyouhnsdno());
                keisanIkkatuPGkBean.setRyouritusdNo(kykSyouhnLst.get(0).getRyouritusdno());
                keisanIkkatuPGkBean.setHokenryou(uiBean.getSyup());
                keisanIkkatuPGkBean.setKeikamon(Integer.parseInt(uiBean.getKykKihon().getTikiktbrisyuruikbn().getValue()));
                keisanIkkatuPGkBean.setHrkkaisuu(uiBean.getVhrkihrkkaisuu());
                keisanIkkatuPGkBean.setTkiktbrisyuruiKbn(uiBean.getVhrkitikiktbrijk());

                C_ErrorKbn  keisanIkkatuPGkErrorKbn = keisanIkkatuPGk.exec(keisanIkkatuPGkBean, false);

                if (C_ErrorKbn.ERROR.eq(keisanIkkatuPGkErrorKbn)) {
                    throw new CommonBizAppException("一括払Ｐ計算（減額後）が実行できませんでした。");
                }

                uiBean.setNewZennoujihrkp(keisanIkkatuPGk.getIkkatuP());
                uiBean.setHensyuikthrip(keisanIkkatuPGk.getIkkatuP());
            }

            if (C_Kykjyoutai.ZENNOU.eq(kykSyouhnLst.get(0).getKykjyoutai())) {
                BizDate jkipjytymd = BizDate.valueOf(jkipjytym, kykSyouhnLst.get(0).getKykymd().getDay()).getRekijyou();

                if (C_Hrkkaisuu.NEN.eq(uiBean.getVhrkihrkkaisuu())) {
                    uiBean.setNewZennoujihrkp(uiBean.getSyup());
                }

                if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), jkipjytymd) == BizDateUtil.COMPARE_LESSER) {
                    KeisanZennouSeisanGk2 keisanZennouSeisanGk2Mae = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);

                    C_ErrorKbn keisanZennouSeisanGk2MaeErrorKbn = keisanZennouSeisanGk2Mae.exec(uiBean.getSyoruiukeymd(),
                        uiBean.getSyono());

                    if (C_ErrorKbn.ERROR.eq(keisanZennouSeisanGk2MaeErrorKbn)) {
                        throw new CommonBizAppException("前納精算額計算（減額前）が実行できませんでした。");
                    }

                    oldZennouseisankgkknrtuuka = keisanZennouSeisanGk2Mae.getZennouSeisanGk();

                    IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(uiBean.getSyono());
                    List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();
                    IT_Zennou zennou = zennouLst.get(0);

                    GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);
                    C_ErrorKbn getasPRsTuukaErrorKbn = getasPRsTuuka.exec(uiBean.getSyono());

                    if (C_ErrorKbn.ERROR.eq(getasPRsTuukaErrorKbn)) {
                        throw new CommonBizAppException("保険料領収通貨取得が実行できませんでした。");
                    }

                    uiBean.setRstuukasyu(getasPRsTuuka.getRstuukasyu());

                    KeisanZennouNyuukinGk2 keisanZennouNyuukinGk2 = SWAKInjector.getInstance(KeisanZennouNyuukinGk2.class);
                    C_ErrorKbn keisanZennouNyuukinGk2ErrorKbn =
                        keisanZennouNyuukinGk2.execKeisanSinkeiyakuDoujiZennouNyuukinGk(zennou.getRyosyuymd(),
                            uiBean.getNewZennoujihrkp(), Integer.valueOf(zennou.getZennoukikan()), C_Tuukasyu.BLNK,
                            BizNumber.ZERO, BizNumber.ZERO);

                    if (C_ErrorKbn.ERROR.eq(keisanZennouNyuukinGk2ErrorKbn)) {
                        throw new CommonBizAppException("前納入金額計算（減額後）が実行できませんでした。");
                    }

                    uiBean.setNewZennounyuukinkgk(keisanZennouNyuukinGk2.getZennouNyuukinGk().subtract(uiBean.getNewZennoujihrkp()));

                    KeisanZennouSeisanGk2 keisanZennouSeisanGk2Go = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);

                    C_ErrorKbn keisanZennouSeisanGkGoErrorKbn = keisanZennouSeisanGk2Go.exec(uiBean.getSyoruiukeymd(),
                        kykSyouhnLst.get(0).getKykymd(), uiBean.getNewZennoujihrkp(), zennou.getZennoukaisiymd(),
                        zennou.getRyosyuymd(), uiBean.getNewZennounyuukinkgk());

                    if (C_ErrorKbn.ERROR.eq(keisanZennouSeisanGkGoErrorKbn)) {
                        throw new CommonBizAppException("前納精算額計算（減額後）が実行できませんでした。");
                    }

                    newZennouseisankgkknrtuuka = keisanZennouSeisanGk2Go.getZennouSeisanGk();

                    zennouseisankgkknrtuuka = oldZennouseisankgkknrtuuka.subtract(newZennouseisankgkknrtuuka);
                    lastPJyuutouYm = keisanZennouSeisanGk2Go.getLastPJyuutouYm().addYears(1);

                    uiBean.setRyosyuymd(zennou.getRyosyuymd());
                    uiBean.setLastPJyuutouYm(lastPJyuutouYm);
                    if (BizDateUtil.compareYm(jkipjytym, lastPJyuutouYm) == BizDateUtil.COMPARE_GREATER) {
                        uiBean.setZennouJyutouTorikesiFlg(C_UmuKbn.ARI);
                    }
                    else {
                        uiBean.setZennouJyutouTorikesiFlg(C_UmuKbn.NONE);
                    }
                }
                else {
                    uiBean.setZennouMijyuutouFlg(C_UmuKbn.ARI);
                }
            }

            uiBean.setZennouseisankgk(zennouseisankgkknrtuuka);


            uiBean.setMikeikaP(mikeikapknrtuuka);

            if (C_Kykjyoutai.HRKMTYUU.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
                C_Kykjyoutai.IKKATUNK.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
                C_Kykjyoutai.ZENNOU.eq(kykSyouhnLst.get(0).getKykjyoutai())) {
                if (lastPJyuutouYm != null) {
                    jkipjytym = lastPJyuutouYm;
                }

                KeisanMsyMkeiP keisanMsyMkeiPMae = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
                keisanMsyMkeiPMae.exec(uiBean.getSyono(), uiBean.getSyoruiukeymd(), jkipjytym, uiBean.getVhsyusyup(),
                    C_MisyuptsKbn.MITS);

                oldMikeikapknrtuuka = keisanMsyMkeiPMae.getMikeikaP();
                oldmiKeikaPBeans = keisanMsyMkeiPMae.getMiKeikaPBeans();

                KeisanMsyMkeiP keisanMsyMkeiPGo = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
                keisanMsyMkeiPGo.execKyknaiyouSitei(uiBean.getSyono(), uiBean.getSyoruiukeymd(), jkipjytym,
                    uiBean.getSyup(), C_MisyuptsKbn.MITS, uiBean.getSyukihons(), kykSyouhnLst.get(0).getHhknnen(),
                    kykSyouhnLst.get(0).getHhknsei(), kykSyouhnLst.get(0).getHrkkkn());

                newMikeikapknrtuuka = keisanMsyMkeiPGo.getMikeikaP();
                newmiKeikaPBeans = keisanMsyMkeiPGo.getMiKeikaPBeans();

                mikeikapknrtuuka = oldMikeikapknrtuuka.subtract(newMikeikapknrtuuka);

                if (mikeikapknrtuuka.compareTo(BizCurrency.valueOf(0, mikeikapknrtuuka.getType())) > 0) {
                    uiBean.setMikeikaP(mikeikapknrtuuka);
                    uiBean.setMikeikaPJyutouKaisuuY(keisanMsyMkeiPGo.getMikeikaPJyutouKaisuuY());
                    uiBean.setMikeikaPJyutouKaisuuM(keisanMsyMkeiPGo.getMikeikaPJyutouKaisuuM());
                    uiBean.setMikeikaPjyutouYm(keisanMsyMkeiPGo.getMikeikaPJyutouYM());

                    for (int count = 0; count < newmiKeikaPBeans.length; count++) {
                        newmiKeikaPBeans[count].setMiKeikaP(oldmiKeikaPBeans[count].getMiKeikaP().subtract(newmiKeikaPBeans[count].getMiKeikaP()));
                    }

                    uiBean.setMiKeikaPBeans(newmiKeikaPBeans);
                }
            }


            if (C_UmuKbn.NONE.eq(uiBean.getMihaneiDUmu())){
                KeisanDCommonGengaku keisanDCommonGengaku = SWAKInjector.getInstance(KeisanDCommonGengaku.class);
                C_ErrorKbn calcDShrgkErrorKbn = keisanDCommonGengaku.calcDShrgk(uiBean.getSyono(),
                    uiBean.getKouryokuHasseiYmd(), uiBean.getSyoruiukeymd(), sysYmd, uiBean.getGengakuWariai());

                if (C_ErrorKbn.ERROR.eq(calcDShrgkErrorKbn)) {
                    throw new CommonBizAppException("配当金計算が実行できませんでした。");
                }

                haitoukin = keisanDCommonGengaku.getKariwariatedshrgk();

                uiBean.setKariwariatedruigk(keisanDCommonGengaku.getKariwariatedruigk());
                uiBean.setKariwariatedgngkkngk(keisanDCommonGengaku.getKariwariatedgngkkngk());
                uiBean.setKariwariatedshrgk(keisanDCommonGengaku.getKariwariatedshrgk());
                uiBean.setKhHaitouKanriKeyinfoBean(keisanDCommonGengaku.getKeyInfoKhHaitouKanriBean());
                uiBean.setEditDshrTukiDKoumokuBean(keisanDCommonGengaku.getEditDshrTukiDKoumokuBean());
            }

            BizCurrency kaiyakuhrkngkkeikkyktuuka = BizCurrency.optional();

            if (!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu()) && C_Tuukasyu.JPY.eq(uiBean.getHrktuukasyu())) {
                kaiyakuhrkngkkeikkyktuuka = kaiyakuhr;
                yensonotashrgk = zennouseisankgkknrtuuka.add(mikeikapknrtuuka).add(haitoukin);
            }
            else {
                kaiyakuhrkngkkeikkyktuuka = kaiyakuhr.add(zennouseisankgkknrtuuka).add(mikeikapknrtuuka);
                yensonotashrgk = haitoukin;
            }

            BizCurrency yenkamikeikap = BizCurrency.optional();
            BizCurrency gaikamikeikap = BizCurrency.optional();
            BizCurrency yenkazennouseisankgk = BizCurrency.optional();
            BizCurrency gaikazennouseisankgk = BizCurrency.optional();

            if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                yenkamikeikap = mikeikapknrtuuka;
                yenkazennouseisankgk = zennouseisankgkknrtuuka;
            }
            else {
                if (C_Tuukasyu.JPY.eq(uiBean.getHrktuukasyu())) {
                    yenkamikeikap = mikeikapknrtuuka;
                    gaikamikeikap = BizCurrency.valueOf(0, syuCurrencyType);
                    yenkazennouseisankgk = zennouseisankgkknrtuuka;
                    gaikazennouseisankgk = BizCurrency.valueOf(0, syuCurrencyType);
                }
                else {
                    yenkamikeikap = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
                    gaikamikeikap = mikeikapknrtuuka;
                    yenkazennouseisankgk = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
                    gaikazennouseisankgk = zennouseisankgkknrtuuka;
                }
            }

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            int kawaseRateMinasiKbn = KAWASERATEMINASIKBN_SEIJYOURATE;
            BizCurrency yenknsnkaiyakuhrgaika = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency gaikaknsnyensonotashrgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizCurrency yenkaiyakuhrkngkkei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            BizDate yenknsnkwsratekjymd = null;
            BizNumber yenknsnkawaserate = null;
            BizDate gaikaknsnkwsratekjymd = null;
            BizNumber gaikaknsnkawaserate = null;

            if (C_UmuKbn.NONE.eq(uiBean.getZeiseitkkktkykhukaumu())) {
                if (!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                    getKawaseRate.exec(
                        uiBean.getSyoruiukeymd(),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        uiBean.getVhsyusyukyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.SYUKKINRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.YOU);

                    BizDate syoruiukeymd = uiBean.getSyoruiukeymd();

                    if (syoruiukeymd.isHoliday()) {
                        syoruiukeymd = syoruiukeymd.getBusinessDay(CHolidayAdjustingMode.NEXT);
                    }

                    if (BizDateUtil.compareYmd(getKawaseRate.getKwsrateKjYmd(), syoruiukeymd) == BizDateUtil.COMPARE_LESSER) {

                        kawaseRateMinasiKbn = KAWASERATEMINASIKBN_MINASIRATE;
                    }
                    else {

                        kawaseRateMinasiKbn = KAWASERATEMINASIKBN_SEIJYOURATE;
                    }

                    yenknsnkwsratekjymd = getKawaseRate.getKwsrateKjYmd();
                    yenknsnkawaserate = getKawaseRate.getKawaserate();

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    yenknsnkaiyakuhrgaika = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY, kaiyakuhr, yenknsnkawaserate, C_HasuusyoriKbn.AGE);

                    keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    yenkaiyakuhrkngkkei = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY, kaiyakuhrkngkkeikkyktuuka, yenknsnkawaserate, C_HasuusyoriKbn.AGE);

                    getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                    getKawaseRate.exec(
                        uiBean.getSyoruiukeymd(),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        uiBean.getVhsyusyukyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.NYUKINRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.YOU);

                    gaikaknsnkwsratekjymd = getKawaseRate.getKwsrateKjYmd();
                    gaikaknsnkawaserate = getKawaseRate.getKawaserate();

                    keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    gaikaknsnyensonotashrgk = keisanGaikakanzan.execDivide(
                        uiBean.getVhsyusyukyktuukasyu(), yensonotashrgk, gaikaknsnkawaserate, C_HasuusyoriKbn.AGE);
                }

                KeisanKhGensen keisanKhGensenGaika = SWAKInjector.getInstance(KeisanKhGensen.class);

                C_ErrorKbn errorKbnGaika = keisanKhGensenGaika.exec(uiBean.getSyono(),
                    uiBean.getVhsyusyukyktuukasyu(),
                    C_UmuKbn.NONE,
                    uiBean.getKaiyakuhr(),
                    yensonotashrgk,
                    uiBean.getSyoruiukeymd());

                if (C_ErrorKbn.ERROR.eq(errorKbnGaika)) {

                    throw new CommonBizAppException("源泉徴収額計算（外貨支払時）が実行できませんでした。");
                }

                KeisanKhGensen keisanKhGensenYenka = SWAKInjector.getInstance(KeisanKhGensen.class);

                BizCurrency kaiyakuHr = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                    kaiyakuHr = uiBean.getKaiyakuhr();
                }
                else {
                    kaiyakuHr = yenknsnkaiyakuhrgaika;
                }

                C_ErrorKbn errorKbnEnka = keisanKhGensenYenka.exec(uiBean.getSyono(),
                    uiBean.getVhsyusyukyktuukasyu(),
                    C_UmuKbn.ARI,
                    kaiyakuHr,
                    yensonotashrgk,
                    uiBean.getSyoruiukeymd());

                if (C_ErrorKbn.ERROR.eq(errorKbnEnka)) {

                    throw new CommonBizAppException("源泉徴収額計算（円貨支払時）が実行できませんでした。");
                }

                uiBean.setShrgkgoukeisyoukai(
                    kaiyakuhrkngkkeikkyktuuka.add(gaikaknsnyensonotashrgk).subtract(keisanKhGensenGaika.getGensen()));

                if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {

                    uiBean.setJpyshrgkgoukeisyoukai(
                        uiBean.getKaiyakuhr().add(yensonotashrgk).subtract(keisanKhGensenYenka.getYenGensen()));

                    uiBean.setJpykaiyakuhr(uiBean.getKaiyakuhr());
                }
                else {

                    uiBean.setJpyshrgkgoukeisyoukai(
                        yenkaiyakuhrkngkkei.add(yensonotashrgk).subtract(keisanKhGensenYenka.getYenGensen()));

                    uiBean.setJpykaiyakuhr(yenknsnkaiyakuhrgaika);
                }

                uiBean.setYenkamikeikap(yenkamikeikap);
                uiBean.setGaikamikeikap(gaikamikeikap);
                uiBean.setMikeikapGengakuMae(oldMikeikapknrtuuka);
                uiBean.setMikeikapGengakuGo(newMikeikapknrtuuka);

                if (C_UmuKbn.ARI.eq(uiBean.getZennouMijyuutouFlg())) {
                    uiBean.setYenkazennouseisankgk(BizCurrency.optional());
                    uiBean.setGaikazennouseisankgk(BizCurrency.optional());
                }
                else {
                    uiBean.setYenkazennouseisankgk(yenkazennouseisankgk);
                    uiBean.setGaikazennouseisankgk(gaikazennouseisankgk);
                }

                uiBean.setZennouseisankinGengakuMae(oldZennouseisankgkknrtuuka);
                uiBean.setZennouseisankinGengakuGo(newZennouseisankgkknrtuuka);
                uiBean.setSonotashrgk(gaikaknsnyensonotashrgk);
                uiBean.setKaiyakuhrkngkkeisiteituuka(kaiyakuhrkngkkeikkyktuuka);
                uiBean.setYenkiykhrgoukei(yenkaiyakuhrkngkkei);
                uiBean.setYensonotashrgk(yensonotashrgk);
                uiBean.setSntshrgksssonotashrgk(gaikaknsnyensonotashrgk);
                uiBean.setSntshrgkssgikshrratetekiymd(gaikaknsnkwsratekjymd);
                uiBean.setSntshrgkssgikshrrate(gaikaknsnkawaserate);
                uiBean.setSntshrgkssgikshrkyktuukasyu(uiBean.getVhsyusyukyktuukasyu());
                uiBean.setSntshrgkssyensonotashrgk(yensonotashrgk);
                uiBean.setSntshrgkssyenkamikeikap(uiBean.getYenkamikeikap());
                uiBean.setSntshrgkssyenzennousisnkgk(uiBean.getYenkazennouseisankgk());
                uiBean.setSntshrgkssyenhaitoukin(haitoukin);
                uiBean.setSntshrgkssyentkbthaitoukin(BizCurrency.valueOf(0));
                uiBean.setYenkahaitoukin(haitoukin);
                uiBean.setYentkbthaitoukin(BizCurrency.valueOf(0));
                uiBean.setYenshrratetekiymd(yenknsnkwsratekjymd);
                uiBean.setYenshrrate(yenknsnkawaserate);
                uiBean.setShrkyktuukasyu(uiBean.getVhsyusyukyktuukasyu());
                uiBean.setShrsyousaikaiyakuhr(uiBean.getKaiyakuhr());
                uiBean.setShrsyousaijpykaiyakuhr(uiBean.getJpykaiyakuhr());
                uiBean.setYenkiykhrssyenkiykhrgoukei(yenkaiyakuhrkngkkei);
                uiBean.setYenkiykhrssyenshrratetkymd(yenknsnkwsratekjymd);
                uiBean.setYenkiykhrssyenshrratete(yenknsnkawaserate);
                uiBean.setYenkiykhrssshrkyktuukasyu(uiBean.getVhsyusyukyktuukasyu());
                uiBean.setYenkiykhrsskaiyakuhrgoukei(kaiyakuhrkngkkeikkyktuuka);
                uiBean.setYenkiykhrsskaiyakuhryen(uiBean.getKaiyakuhr());
                uiBean.setYenkiykhrssmikeikap(uiBean.getGaikamikeikap());
                uiBean.setYenkiykhrsszennouseisankin(uiBean.getGaikazennouseisankgk());
                uiBean.setGaikaGsBunriTaisyouFlag(keisanKhGensenGaika.getGsBunriTaisyou());
                uiBean.setYenkaGsBunriTaisyouFlag(keisanKhGensenYenka.getGsBunriTaisyou());
                if (C_RatesyutokukekkaKbn.ERROR.eq(keisanKhGensenGaika.getRateSyutokuKekkaKbn())) {
                    uiBean.setDispgstszeigkcalckahimongon(KEISANFUNOU);
                }
                uiBean.setGsTsZeigk(keisanKhGensenGaika.getGensen());
                if (C_UmuKbn.ARI.eq(uiBean.getGsBunriTaisyou())) {
                    uiBean.setDispgstszeigk(keisanKhGensenGaika.getGensen().multiply(-1));
                    uiBean.setDispyengstszeigk(keisanKhGensenYenka.getYenGensen().multiply(-1));
                }
                else {
                    uiBean.setDispgstszeigk(BizCurrency.valueOf(0, syuCurrencyType));
                    uiBean.setDispyengstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                }
                uiBean.setGaikaShrYenGsTsZeigk(keisanKhGensenGaika.getYenGensen());
                uiBean.setJpyGsTszeigk(keisanKhGensenYenka.getYenGensen());
                uiBean.setGaikaShrYenGsTsZeigkNationaltax(keisanKhGensenGaika.getYenGsTszeiGkKokuz());
                uiBean.setYenkaShrYenGsTsZeigkNationaltax(keisanKhGensenYenka.getYenGsTszeiGkKokuz());
                uiBean.setGaikaShrYenGsTsZeigkLocaltax(keisanKhGensenGaika.getYenGsTszeiGkTihouz());
                uiBean.setYenkaShrYenGsTsZeigkLocaltax(keisanKhGensenYenka.getYenGsTszeiGkTihouz());
                uiBean.setGaikaShrYenGsTsTaisyouSaeki(keisanKhGensenGaika.getYenKztGk());
                uiBean.setYenkaShrYenGsTsTaisyouSaeki(keisanKhGensenYenka.getYenKztGk());
                uiBean.setKeisanKhYenW(keisanKhGensenGaika.getYenW());
                uiBean.setGaikaShrYenHtyKeihi(keisanKhGensenGaika.getYenHtyKeihi());
                uiBean.setYenkaShrYenHtyKeihi(keisanKhGensenYenka.getYenHtyKeihi());
                uiBean.setZeimuRatesyutokukekkaKbn(keisanKhGensenGaika.getRateSyutokuKekkaKbn());
                uiBean.setZeimukwsratekjnymd(keisanKhGensenGaika.getRatesyutokuYmd());
                uiBean.setZeimukwsrate(keisanKhGensenGaika.getKawaseRate());
                uiBean.setZeimukyktuukasyu(uiBean.getVhsyusyukyktuukasyu());
                if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                    uiBean.setYendthnkshrgkgoukeisyoukai(kaiyakuhrkngkkeikkyktuuka.add(haitoukin).subtract(keisanKhGensenGaika.getGensen()));
                    uiBean.setYendthnkkaiyakuhr(uiBean.getKaiyakuhr());
                    uiBean.setYendthnkmikeikap(uiBean.getMikeikaP());

                    if (C_UmuKbn.ARI.eq(uiBean.getZennouMijyuutouFlg())) {
                        uiBean.setYendthnkzennouseisankin(BizCurrency.optional());
                    }
                    else {
                        uiBean.setYendthnkzennouseisankin(uiBean.getZennouseisankgk());
                    }
                    uiBean.setYendthnkhaitoukin(haitoukin);
                    uiBean.setYendthnkgstszeigk(keisanKhGensenGaika.getGensen());
                    uiBean.setDispyendthnkgstszeigk(keisanKhGensenGaika.getGensen().multiply(-1));
                    uiBean.setYendthnkGstsTaisyouSaeki(keisanKhGensenGaika.getYenKztGk());
                }
                else {
                    uiBean.setYendthnkshrgkgoukeisyoukai(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    uiBean.setYendthnkkaiyakuhr(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    uiBean.setYendthnkmikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    uiBean.setYendthnkzennouseisankin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    uiBean.setYendthnkhaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    uiBean.setYendthnkgstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    uiBean.setDispyendthnkgstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    uiBean.setYendthnkGstsTaisyouSaeki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                }
                uiBean.setYendthnktkbthaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

                uiBean.setAzukarigoukeigk(BizCurrency.valueOf(0, syuCurrencyType));
                uiBean.setAzukarijpygoukeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            }
            else {
                uiBean.setAzukarigoukeigk(uiBean.getKaiyakuhr());
                uiBean.setAzukariaiyakuhr(uiBean.getKaiyakuhr());
                uiBean.setAzukarijpygoukeigk(yensonotashrgk);
                uiBean.setAzukarip(mikeikapknrtuuka);
                uiBean.setAzukarizennouseisankgk(zennouseisankgkknrtuuka);
                uiBean.setAzukarihaitoukin(haitoukin);
                uiBean.setAzukartkbtihaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

                uiBean.setShrgkgoukeisyoukai(BizCurrency.valueOf(0, syuCurrencyType));
                uiBean.setJpyshrgkgoukeisyoukai(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setYendthnkshrgkgoukeisyoukai(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

                uiBean.setJpykaiyakuhr(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setSonotashrgk(BizCurrency.valueOf(0, syuCurrencyType));
                uiBean.setSntshrgkssyensonotashrgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setKeisanKhYenW(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setZeimukwsrate(BizNumber.valueOf(0));
                uiBean.setKaiyakuhrkngkkeisiteituuka(kaiyakuhrkngkkeikkyktuuka);
                uiBean.setGaikazennouseisankgk(BizCurrency.valueOf(0, syuCurrencyType));
                uiBean.setGaikamikeikap(BizCurrency.valueOf(0, syuCurrencyType));
            }

            if (C_UmuKbn.NONE.eq(uiBean.getZeiseitkkktkykhukaumu())) {
                CurrencyType  currencyType  = uiBean.getVhsyusyukihons().getType();
                BizCurrency shrgkgoukeisyoukai = BizCurrency.valueOf(0, currencyType);

                if (uiBean.getShrgkgoukeisyoukai().compareTo(shrgkgoukeisyoukai) == 0) {
                    throw new BizLogicException(MessageId.EIF1069, uiBean.getVhsyusyukyktuukasyu().getContent());
                }
            }


            if (C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {

                Boolean isMRFAccount = checkMrf();

                if(isMRFAccount == true){
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2,MessageId.WBA1006);
                }
            }

            List<IT_KykSyaHenkouRireki> kykSyaHenkouRirekiList =
                hozenDomManager.getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(uiBean.getSyono(),C_Meigihnkjiyuu.KYK);

            if (kykSyaHenkouRirekiList.size() > 0) {
                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING4,
                    MessageId.WIA1016);
            }

            if (BizDateUtil.compareYmd(BizDate.getSysDate(), uiBean.getSyoruiukeymd().addDays(syoruiUkeKyoyou))
                != BizDateUtil.COMPARE_LESSER) {

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING4,
                    MessageId.WIF1004,
                    MessageUtil.getMessage(DDID_GENGAKUNYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()),
                    String.valueOf(syoruiUkeKyoyou) + "日");
            }

            if (kawaseRateMinasiKbn == KAWASERATEMINASIKBN_MINASIRATE) {
                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING4,
                    MessageId.WIA1003);
            }


            Long khHenreikinKensuu = hozenDomManager.getKhHenreikinYendtMbrCountBySyono(uiBean.getSyono());
            if (khHenreikinKensuu > 0) {

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING4,
                    MessageId.WIA1017);
            }

            int unitGkminasiKbn = 0;

            if (C_FiSiyouKbn.TJTSI.eq(keisanWGengakuGo.getFiSiyouKbn())) {

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING4,
                    MessageId.WIA1002);

                unitGkminasiKbn = UNITGKMINASIKBN_MINASIKAKAKU;
            }
            else {

                unitGkminasiKbn = UNITGKMINASIKBN_TOUJITUKAKAKU;
            }

            if (C_UmuKbn.ARI.eq(uiBean.getZeiseitkkktkykhukaumu())) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.IIF1019);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getZennouMijyuutouFlg())) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIA1018,
                    GENGAKU);

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIA1019, "");
            }

            uiBean.setKawaseRateMinasiKbn(kawaseRateMinasiKbn);

            uiBean.setUnitGkminasiKbn(unitGkminasiKbn);

            if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                uiBean.setYenshrtkumu(C_UmuKbn.NONE);
            }

            if (C_KhkinouModeIdKbn.SYOUNIN.toString().equals(kinouMode.getKinouMode())) {

                if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {

                    if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) ||
                        C_Tuukasyu.JPY.eq(syuKihonSTuukasyu)) {

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

        if (C_Hrkkeiro.KOUHURI.eq(uiBean.getVhrkihrkkeiro())) {
            uiBean.setPatternSoukinsakikbn(C_SoukinsakiKbn.PATTERN_SELECT);
        }
        else if (C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) {
            uiBean.setPatternSoukinsakikbn(C_SoukinsakiKbn.PATTERN_SELECT_TKSHKSHRKZ);
        }
    }

    void pushKakunin() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        if ((C_KhkinouModeIdKbn.SYOUNIN.toString().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) ||
            ((C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.INPUT.toString().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.toString().equals(kinouMode.getKinouMode())) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0,
                uiBean.getShrgkgoukeisyoukai().getType())) > 0 &&
                uiBean.getYenshrtkumu() == null) {

                throw new BizLogicException(MessageId.EBF1005,
                    MessageUtil.getMessage(DDID_YENSHRTKNYUURYOKU_YENSHRTKUMU.
                        getErrorResourceKey()));
            }

            if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0,
                uiBean.getShrgkgoukeisyoukai().getType())) > 0 &&
                C_InputShrhousiteiKbn.BLNK.eq(uiBean.getInputshrhousiteikbn())) {

                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SHRHOUINFO_INPUTSHRHOUSITEIKBN.
                        getErrorResourceKey()));
            }

            if ((C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) && C_UmuKbn.ARI.eq(uiBean.getYenkaGsBunriTaisyouFlag())) ||
                (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu()) && C_UmuKbn.ARI.eq(uiBean.getGaikaGsBunriTaisyouFlag()))) {

                uiBean.setGsBunriTaisyouFlag(C_UmuKbn.ARI);
            }
            else {

                uiBean.setGsBunriTaisyouFlag(C_UmuKbn.NONE);
            }

            if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0,
                uiBean.getShrgkgoukeisyoukai().getType())) > 0) {
                if (C_UmuKbn.NONE.eq(uiBean.getGsBunriTaisyouFlag())) {
                    if (!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu()) &&
                        C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {


                        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                        C_ErrorKbn errorKbn = getKawaseRate.exec(
                            uiBean.getSyoruiukeymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                            uiBean.getVhsyusyukyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.JISSEIRATE,
                            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            throw new BizLogicException(MessageId.EIA1013);
                        }

                        uiBean.setZeimukwsratekjnymd(getKawaseRate.getKwsrateKjYmd());
                        uiBean.setZeimukwsrate(getKawaseRate.getKawaserate());
                        uiBean.setZeimukyktuukasyu(uiBean.getVhsyusyukyktuukasyu());

                    }
                }
            }

            if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0,
                uiBean.getShrgkgoukeisyoukai().getType())) > 0) {

                C_Tuukasyu  shrtuukasyu  = null;

                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {

                    shrtuukasyu = C_Tuukasyu.JPY;
                }
                else {

                    shrtuukasyu = uiBean.getVhsyusyukyktuukasyu();
                }

                uiBean.setShrtuukasyu(shrtuukasyu);

                if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {
                    if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn())) {

                        if (!C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                            throw new BizLogicException(MessageId.EIA1033);
                        }
                    }

                    if (C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn())) {
                        if (!C_Tuukasyu.JPY.eq(uiBean.getKykKihon().getKykSonotaTkyk().getTeikishrkinshrtuukasyu()) &&
                            C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                            throw new BizLogicException(MessageId.EIA1072, JPY_SIHARAI_MOUSIDE_NONE);
                        }
                        if (C_Tuukasyu.JPY.eq(uiBean.getKykKihon().getKykSonotaTkyk().getTeikishrkinshrtuukasyu()) &&
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

                            throw new BizLogicException(MessageId.EBA0108,KZJOUHOU);
                        }
                    }

                    KhCheckKouza khCheckKouza = SWAKInjector.getInstance(KhCheckKouza.class);

                    khCheckKouza.chkSoukinsakiKouza(uiBean, khozenCommonParam);

                    uiBean.setBanknmkj(khCheckKouza.getGinkouName());
                    uiBean.setSitennmkj(khCheckKouza.getShitenName());

                    if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) ||
                        C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {

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

            if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0,
                uiBean.getShrgkgoukeisyoukai().getType())) > 0 &&
                (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(uiBean.getInputshrhousiteikbn()) ||
                    C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn()))) {

                if (!BizUtil.isBlank(uiBean.getBankcd()) ||
                    !BizUtil.isBlank(uiBean.getSitencd()) ||
                    !C_YokinKbn.BLNK.eq(uiBean.getYokinkbn()) ||
                    !BizUtil.isBlank(uiBean.getKouzano()) ||
                    !C_Kzdou.BLNK.eq(uiBean.getKzdoukbn()) ||
                    !BizUtil.isBlank(uiBean.getKzmeiginmkn())) {

                    throw new BizLogicException(MessageId.EBA0108, KZJOUHOU);
                }
                else if (C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {

                    throw new BizLogicException(MessageId.EIA1008, uiBean.getInputshrhousiteikbn().getContent());
                }
            }

            BizDate shrymd = null;

            if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0,
                uiBean.getShrgkgoukeisyoukai().getType())) > 0) {

                KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

                shrymd = keisanSiharaibi.exec(BizDate.getSysDate(), uiBean.getInputshrhousiteikbn(),
                    uiBean.getShrtuukasyu(), uiBean.getBankcd());

                uiBean.setShrymd(shrymd);

                uiBean.setShrhouSiteiKbn(keisanSiharaibi.getShrhousiteiKbn());
            }

            if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {

                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_HONNININFO_HONNINKAKNINKEKKAKBN.
                        getErrorResourceKey()));
            }

            if (C_KktyuitaKbn.DNGNMEMOARI.eq(uiBean.getVtdktkktyuitakbn()) &&
                C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {

                throw new BizLogicException(MessageId.EIA1007);
            }

            if (C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {

                IT_KhTtdkTyuui khTtdkTyuui = khozenCommonParam.getKkTetudukiTyuui(uiBean.getSyono());

                if (khTtdkTyuui != null) {

                    boolean saikenGengakuSeikyuFlag = false;

                    if (C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
                        C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
                        C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
                        C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
                        C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
                        C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
                        C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
                        C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
                        C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn5()) ||
                        C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn5())) {

                        saikenGengakuSeikyuFlag = true;
                    }

                    if (saikenGengakuSeikyuFlag) {

                        throw new BizLogicException(MessageId.EIF1075);
                    }
                }
            }

            if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhouSiteiKbn())) {
                    if (uiBean.getYendthnkshrgkgoukeisyoukai().compareTo(
                        BizCurrency.valueOf(0, uiBean.getYendthnkshrgkgoukeisyoukai().getType())) > 0) {

                        KeisanTienRisoku keisanTienRisoku = SWAKInjector.getInstance(KeisanTienRisoku.class);

                        BizCurrency shrTienRsk = keisanTienRisoku.exec(uiBean.getSyoruiukeymd(),
                            uiBean.getShrymd(),
                            uiBean.getYendthnkshrgkgoukeisyoukai());

                        uiBean.setYendthnkshrtienrsk(shrTienRsk);

                        uiBean.setYendthnkshrgkgoukeikakunin(uiBean.getYendthnkshrgkgoukeisyoukai().add(shrTienRsk));

                        String tienRskKsnbiNissuu = KhozenEdit.editTienRkksanhi(uiBean.getShrhouSiteiKbn(),
                            uiBean.getYendthnkshrtienrsk(),
                            uiBean.getSyoruiukeymd(),
                            keisanTienRisoku.getKeisanTienrisokuBean().getShrtienNissuu());

                        uiBean.setDispyendttienrskksnbinissuu(tienRskKsnbiNissuu);

                        uiBean.setYendtTienRskKsnbi(uiBean.getSyoruiukeymd());

                        uiBean.setYendtTienRskNissuu(keisanTienRisoku.getKeisanTienrisokuBean().getShrtienNissuu());
                    }
                    else {
                        uiBean.setYendthnkshrtienrsk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

                        uiBean.setYendthnkshrgkgoukeikakunin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }
                }
                else {
                    if (uiBean.getYendthnkshrgkgoukeisyoukai().compareTo(
                        BizCurrency.valueOf(0, uiBean.getYendthnkshrgkgoukeisyoukai().getType())) > 0) {

                        uiBean.setYendthnkshrgkgoukeikakunin(uiBean.getYendthnkshrgkgoukeisyoukai());

                        String tienRskKsnbiNissuu = KhozenEdit.editTienRkksanhi(uiBean.getShrhouSiteiKbn(),
                            BizCurrency.valueOf(0), null, null);

                        uiBean.setDispyendttienrskksnbinissuu(tienRskKsnbiNissuu);

                    }
                    else {
                        uiBean.setYendthnkshrgkgoukeikakunin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }
                }
            }
            else {
                if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhouSiteiKbn())) {

                    if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0,
                        uiBean.getShrgkgoukeisyoukai().getType())) > 0) {

                        KeisanTienRisoku keisanTienRisoku = SWAKInjector.getInstance(KeisanTienRisoku.class);

                        BizCurrency shrtienrsk = keisanTienRisoku.exec(uiBean.getSyoruiukeymd(), shrymd,
                            uiBean.getShrgkgoukeisyoukai());

                        BizCurrency shrgkgoukeikakunin = uiBean.getShrgkgoukeisyoukai().add(shrtienrsk);

                        uiBean.setShrtienrsk(shrtienrsk);

                        uiBean.setShrgkgoukeikakunin(shrgkgoukeikakunin);

                        uiBean.setDisptienrskkisanymdnissuu(KhozenEdit.editTienRkksanhi(
                            uiBean.getShrhouSiteiKbn(),
                            uiBean.getShrtienrsk(),
                            uiBean.getSyoruiukeymd(),
                            keisanTienRisoku.getKeisanTienrisokuBean().getShrtienNissuu()));

                        uiBean.setTienrisoKukisanYmd(uiBean.getSyoruiukeymd());

                        uiBean.setTienrskNissuu(keisanTienRisoku.getKeisanTienrisokuBean().getShrtienNissuu());
                    }
                    else {

                        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                        CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyusyukyktuukasyu());

                        uiBean.setShrtienrsk(BizCurrency.valueOf(0, syuCurrencyType));

                        uiBean.setShrgkgoukeikakunin(BizCurrency.valueOf(0, syuCurrencyType));
                    }
                }
                else {
                    if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0,
                        uiBean.getShrgkgoukeisyoukai().getType())) > 0) {

                        uiBean.setShrgkgoukeikakunin(uiBean.getShrgkgoukeisyoukai());

                        uiBean.setDisptienrskkisanymdnissuu(KhozenEdit.editTienRkksanhi(
                            uiBean.getShrhouSiteiKbn(),
                            BizCurrency.valueOf(0,
                                uiBean.getShrgkgoukeisyoukai().getType()),
                                null,
                                null));
                    }
                    else {
                        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                        CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyusyukyktuukasyu());

                        uiBean.setShrgkgoukeikakunin(BizCurrency.valueOf(0, syuCurrencyType));
                    }
                }

                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {

                    if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhouSiteiKbn())) {

                        if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0,
                            uiBean.getShrgkgoukeisyoukai().getType())) > 0) {

                            KeisanTienRisoku keisanTienRisoku = SWAKInjector.getInstance(KeisanTienRisoku.class);

                            BizCurrency yenShrtienrsk = keisanTienRisoku.exec(uiBean.getSyoruiukeymd(), shrymd,
                                uiBean.getJpyshrgkgoukeisyoukai());

                            BizCurrency yenShrgkgoukeikakunin = uiBean.getJpyshrgkgoukeisyoukai().add(yenShrtienrsk);

                            uiBean.setJpyshrgkgoukeikakunin(yenShrgkgoukeikakunin);

                            uiBean.setJpyshrtienrsk(yenShrtienrsk);

                            uiBean.setDispjptienrskkisanymdnissuu(KhozenEdit.editTienRkksanhi(
                                uiBean.getShrhouSiteiKbn(),
                                uiBean.getJpyshrtienrsk(),
                                uiBean.getSyoruiukeymd(),
                                keisanTienRisoku.getKeisanTienrisokuBean().getShrtienNissuu()));

                            uiBean.setJpyTienrisoKukisanYmd(uiBean.getSyoruiukeymd());

                            uiBean.setJpyTienrskNissuu(keisanTienRisoku.getKeisanTienrisokuBean().getShrtienNissuu());
                        }
                        else {

                            uiBean.setJpykaiyakuhr(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

                            uiBean.setJpyshrgkgoukeikakunin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        }

                    }
                    else {
                        if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0,
                            uiBean.getShrgkgoukeisyoukai().getType())) > 0) {

                            uiBean.setJpyshrgkgoukeikakunin(uiBean.getJpyshrgkgoukeisyoukai());

                            uiBean.setDispjptienrskkisanymdnissuu(uiBean.getDisptienrskkisanymdnissuu());
                        }
                        else {

                            uiBean.setJpykaiyakuhr(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

                            uiBean.setJpyshrgkgoukeikakunin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        }
                    }
                }
            }

            KeisanHtyKeihi keisanHtyKeihi = SWAKInjector.getInstance(KeisanHtyKeihi.class);
            keisanHtyKeihi.exec(uiBean.getSyono(),
                uiBean.getVhsyusyukyktuukasyu());

            BizCurrency yenGenKykSyaHtyKeihi = keisanHtyKeihi.getYenGenKykSyaHtyKeihi();
            int kykHnkKaisuu = keisanHtyKeihi.getKykSyaHenkouKaisuu();

            BizCurrency synyknGk = BizCurrency.valueOf(0);

            if (C_UmuKbn.ARI.eq(uiBean.getGsBunriTaisyouFlag())) {

                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    synyknGk = uiBean.getJpykaiyakuhr().add(uiBean.getSntshrgkssyensonotashrgk());
                }
                else {
                    synyknGk = uiBean.getKeisanKhYenW().add(uiBean.getSntshrgkssyensonotashrgk());
                }
            }
            else {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    synyknGk = uiBean.getYenkiykhrgoukei().add(uiBean.getSntshrgkssyensonotashrgk());
                }
                else {
                    if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                        synyknGk = uiBean.getKaiyakuhrkngkkeisiteituuka().add(uiBean.getSntshrgkssyensonotashrgk());
                    }
                    else {
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                        synyknGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            uiBean.getKaiyakuhrkngkkeisiteituuka(),
                            uiBean.getZeimukwsrate(),
                            C_HasuusyoriKbn.SUTE).
                            add(uiBean.getSntshrgkssyensonotashrgk());
                    }
                }
            }

            BizCurrency htyKeihi = BizCurrency.valueOf(0);
            if (uiBean.getShrgkgoukeisyoukai().compareTo(
                BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) {
                if (C_UmuKbn.ARI.eq(uiBean.getGsBunriTaisyouFlag())) {
                    if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                        htyKeihi = uiBean.getYenkaShrYenHtyKeihi();
                    }
                    else {
                        htyKeihi = uiBean.getGaikaShrYenHtyKeihi();
                    }
                }
                else {
                    htyKeihi = keisanHtyKeihi.getYenHtyKeihi();
                }

                if (synyknGk.compareTo(htyKeihi) >= 0) {

                    uiBean.setHtykeihi(htyKeihi);
                }
                else {

                    uiBean.setHtykeihi(synyknGk);
                }

                BizCurrency yenShrKykHtyKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                if (kykHnkKaisuu > 0) {
                    if (synyknGk.compareTo(yenGenKykSyaHtyKeihi) >= 0) {
                        yenShrKykHtyKeihi = yenGenKykSyaHtyKeihi;
                    }
                    else {
                        yenShrKykHtyKeihi = synyknGk;
                    }
                }

                uiBean.setSynykngk(synyknGk);
                uiBean.setKykHnkKaisuu(kykHnkKaisuu);
                uiBean.setYenshrkykhtykeihi(yenShrKykHtyKeihi);
                if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyouhinHanteiKbn()) {
                    if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) ||
                        C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                        uiBean.setKihrkpssrrkyenkansanhenkankin(uiBean.getJpykaiyakuhr());
                    }
                    else {

                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        uiBean.setKihrkpssrrkyenkansanhenkankin(keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            uiBean.getKaiyakuhr(),
                            uiBean.getZeimukwsrate(),
                            C_HasuusyoriKbn.SUTE)
                            );
                    }
                }
                else {
                    if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) {
                        uiBean.setKihrkpssrrkyenkansanhenkankin(
                            uiBean.getHtykeihi().subtract(uiBean.getMikeikaP().add(uiBean.getZennouseisankgk())));
                    }
                    else {
                        uiBean.setKihrkpssrrkyenkansanhenkankin(uiBean.getHtykeihi());
                    }
                }

                if (kykHnkKaisuu > 0) {
                    BizCurrency htyKeihityouseigk = synyknGk.subtract(yenGenKykSyaHtyKeihi);

                    if (htyKeihityouseigk.compareTo(BizCurrency.valueOf(0, htyKeihityouseigk.getType())) > 0) {
                        if (uiBean.getHtykeihi().subtract(htyKeihityouseigk).compareTo(BizCurrency.valueOf(0, htyKeihityouseigk.getType())) >= 0) {

                            uiBean.setHituyoukeihiitijisytktysgk(htyKeihityouseigk);
                        }
                        else {
                            uiBean.setHituyoukeihiitijisytktysgk(uiBean.getHtykeihi());
                        }
                    }
                    else {
                        uiBean.setHituyoukeihiitijisytktysgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    }
                }
            }
            else {
                uiBean.setSynykngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setHtykeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setYenshrkykhtykeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setKihrkpssrrkyenkansanhenkankin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setKykHnkKaisuu(kykHnkKaisuu);
            }

            if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                uiBean.setZeimugstszeigk(uiBean.getYendthnkgstszeigk());
                uiBean.setGststaisyousaeki(uiBean.getYendthnkGstsTaisyouSaeki());
            }
            else {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    uiBean.setZeimugstszeigk(uiBean.getJpyGsTszeigk());
                    uiBean.setGststaisyousaeki(uiBean.getYenkaShrYenGsTsTaisyouSaeki());
                }
                else {
                    uiBean.setZeimugstszeigk(uiBean.getGaikaShrYenGsTsZeigk());
                    uiBean.setGststaisyousaeki(uiBean.getGaikaShrYenGsTsTaisyouSaeki());
                }
            }

            BizCurrency zeimukaiyakuhryen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) ||
                C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {

                zeimukaiyakuhryen = uiBean.getJpykaiyakuhr();
            }

            else {

                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                zeimukaiyakuhryen = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    uiBean.getKaiyakuhr(),
                    uiBean.getZeimukwsrate(),
                    C_HasuusyoriKbn.SUTE);
            }

            if (C_UmuKbn.NONE.eq(uiBean.getGsBunriTaisyouFlag())) {
                if (zeimukaiyakuhryen.compareTo(BizCurrency.valueOf(1000000,BizCurrencyTypes.YEN)) > 0 &&
                    (uiBean.getKykHnkKaisuu() > 0 ||
                        (uiBean.getKykHnkKaisuu() == 0 &&
                        (uiBean.getSynykngk().subtract(uiBean.getHtykeihi())).compareTo(BizCurrency.valueOf(0)) > 0))) {

                    uiBean.setShrTysySyuruiKbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);

                    if (BizUtil.isBlank(uiBean.getKykmnmeigibangou())) {

                        messageManager.addConversationMessageId(
                            KhMessageGroupConstants.GROUP_WARNING5,
                            MessageId.WIA1010,
                            MessageUtil.getMessage(DDID_MNMEIGINOINFO_KYKMNMEIGIBANGOU.
                                getErrorResourceKey()));
                    }
                }
            }

            if (C_UmuKbn.NONE.eq(uiBean.getGsBunriTaisyouFlag())) {
                if ((zeimukaiyakuhryen.compareTo(HYAKUMANEN) <= 0 ||
                    (zeimukaiyakuhryen.compareTo(HYAKUMANEN) > 0 &&
                        (uiBean.getKykHnkKaisuu() == 0 &&
                        (uiBean.getSynykngk().subtract(uiBean.getHtykeihi())).compareTo(BizCurrency.valueOf(0, uiBean
                            .getHtykeihi().getType())) <= 0))) &&
                            !BizUtil.isBlank(uiBean.getKykmnmeigibangou())) {

                    messageManager.addConversationMessageId(
                        KhMessageGroupConstants.GROUP_WARNING5,
                        MessageId.WIA1011,
                        MessageUtil.getMessage(DDID_MNMEIGINOINFO_KYKMNMEIGIBANGOU.
                            getErrorResourceKey()));
                }
            }
            else {
                if (!BizUtil.isBlank(uiBean.getKykmnmeigibangou())) {
                    messageManager.addConversationMessageId(
                        KhMessageGroupConstants.GROUP_WARNING5,
                        MessageId.WIA1011,
                        MessageUtil.getMessage(DDID_MNMEIGINOINFO_KYKMNMEIGIBANGOU.
                            getErrorResourceKey()));
                }
            }

            BizCurrency shrGk = BizCurrency.valueOf(0);

            if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                shrGk = uiBean.getYendthnkshrgkgoukeikakunin();
            }
            else {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {

                    shrGk = uiBean.getJpyshrgkgoukeikakunin();
                }
                else {

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    shrGk = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        uiBean.getShrgkgoukeikakunin(),
                        uiBean.getZeimukwsrate(),
                        C_HasuusyoriKbn.SUTE);
                }
            }

            if (shrGk.compareTo(BizCurrency.valueOf(30000000,BizCurrencyTypes.YEN)) > 0) {

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING5,
                    MessageId.WIA1013,
                    SHRGK_KIJYUN);
            }


            Boolean isMRFAccount = checkMrf();

            if(isMRFAccount == true){
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5,MessageId.WBA1007);
            }
        }

        CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);

        checkProcessKekka.exec(uiBean.getSyorikekkakbn(), uiBean.getSyanaicommentkh(),
            uiBean.getSasimodosisakikbn());

        if (C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode())) {

            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

            C_UmuKbn kouteiUmu = checkProcessKaishi.exec(uiBean.getSyono(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(kouteiUmu)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                    checkProcessKaishi.getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA1002,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }
        }

        if (C_YendthnkJyoutaiKbn.YENDTHNKZUMI.eq(uiBean.getVhsyuyendthnkjyoutaikbn()) &&
            BizDateUtil.compareYmd(uiBean.getYendtHnkYmd(), uiBean.getSksSakuseiYmd()) == BizDateUtil.COMPARE_GREATER) {
            if ((C_KhkinouModeIdKbn.INPUT.toString().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.toString().equals(kinouMode.getKinouMode())) &&
                !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn())) {

                throw new BizLogicException(MessageId.EIA1023);
            }
            else if (C_KhkinouModeIdKbn.SYOUNIN.toString().equals(kinouMode.getKinouMode()) &&
                !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()) &&
                C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

                throw new BizLogicException(MessageId.EIA1023);
            }
        }

        BizDateYM jkipjytym = khozenCommonParam.getAnsyuuKihon(uiBean.getSyono()).getJkipjytym();

        List<IT_KykSyouhn> kykSyouhnLst = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        C_YouhiKbn youhiKbn = C_YouhiKbn.HUYOU;
        if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhnLst.get(0).getKykjyoutai())) {

            youhiKbn = C_YouhiKbn.HUYOU;
        }
        else if (C_Kykjyoutai.HRKMTYUU.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
            C_Kykjyoutai.IKKATUNK.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
            C_Kykjyoutai.ZENNOU.eq(kykSyouhnLst.get(0).getKykjyoutai())) {

            youhiKbn = C_YouhiKbn.YOU;
        }

        CheckDShrGengaku checkDShrGengaku = SWAKInjector.getInstance(CheckDShrGengaku.class);
        C_ErrorKbn dShrGengakuErrorKbn = checkDShrGengaku.checkDShr(uiBean.getSyono(), uiBean.getSyoruiukeymd(),
            jkipjytym, youhiKbn, BizDate.getSysDate());

        if (C_ErrorKbn.ERROR.eq(dShrGengakuErrorKbn)) {
            throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
        }

        uiBean.setMihaneiDUmu(checkDShrGengaku.getMihaneiDUmu());

        if (((C_KhkinouModeIdKbn.INPUT.toString().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.toString().equals(kinouMode.getKinouMode())) &&
            (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn()))) ||
            (C_KhkinouModeIdKbn.SYOUNIN.toString().equals(kinouMode.getKinouMode()) &&
                !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()) &&
                C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()))) {

            if (C_UmuKbn.ARI.eq(uiBean.getMihaneiDUmu())){
                throw new BizLogicException(MessageId.EIA1040);
            }

            List<IT_KhTtdkRireki> khTtdkRirekiLst = khGengakuDao.getSeiteiseiKhTtdkRirekisBySyonoSyoriymd(
                uiBean.getSyono(), BizDate.getSysDate());
            if (khTtdkRirekiLst.size() != 0) {
                throw new BizLogicException(MessageId.EIF1105);
            }
        }

        if (C_Kykjyoutai.HRKMTYUU.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
            C_Kykjyoutai.IKKATUNK.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
            C_Kykjyoutai.ZENNOU.eq(kykSyouhnLst.get(0).getKykjyoutai())) {

            if (((C_KhkinouModeIdKbn.INPUT.toString().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.toString().equals(kinouMode.getKinouMode())) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) ||
                (C_KhkinouModeIdKbn.SYOUNIN.toString().equals(kinouMode.getKinouMode()) &&
                    !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()) &&
                    C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()))) {

                if (C_UmuKbn.ARI.eq(checkDShrGengaku.getDHaneiYmdUmu())) {
                    throw new BizLogicException(MessageId.EIF1128);
                }
            }
        }

        if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
            C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

            if (C_Kykjyoutai.ZENNOU.eq(kykSyouhnLst.get(0).getKykjyoutai())) {
                if (C_UmuKbn.ARI.eq(uiBean.getZennouMijyuutouFlg())) {
                    throw new BizLogicException(MessageId.EIA1063,GENGAKU);
                }
            }
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

            List<IT_KhTtdkRireki> khTtdkRirekiList = kykKihon.getKhTtdkRirekisBySyoriYmdGyoumuKousinKinou(
                BizDate.getSysDate(), IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);

            if (khTtdkRirekiList.size() != 0) {

                throw new BizLogicException(MessageId.EIA1069);
            }
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);

        messageManager.addMessageId(MessageId.QBA0001);
    }

    void kakuninModoru() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }


        if (C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode())) {

            Boolean isMRFAccount = checkMrf();

            if(isMRFAccount == true){
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2,MessageId.WBA1006);
            }
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING5);
    }

    @Transactional
    void doUpdate() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }
        else {

            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

            C_UmuKbn kouteiUmu = checkProcessKaishi.exec(uiBean.getSyono(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(kouteiUmu)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                    checkProcessKaishi.getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA0120,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        sousasyaCd = baseUserInfo.getUserId();

        systemYmd = BizDate.getSysDate();

        systemTime = BizDate.getSysDateTimeMilli();

        if (C_KhkinouModeIdKbn.SYOUNIN.toString().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

            kinouId = khozenCommonParam.getFunctionId();

            henkousikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

            tableMaintenanceUtil.backUp(uiBean.getSyono(), henkousikibetuKey);

            IT_KykKihon kykKihon = uiBean.getKykKihon();

            kykKihon.setHrkp(uiBean.getNewhrkp());

            kykKihon.setSyhenkouymd(systemYmd);

            kykKihon.setLastsyosaihkymd(systemYmd);

            kykKihon.setGyoumuKousinKinou(kinouId);

            kykKihon.setGyoumuKousinsyaId(sousasyaCd);

            kykKihon.setGyoumuKousinTime(systemTime);

            IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();

            khTtdkRireki.setHenkousikibetukey(henkousikibetuKey);

            updateSyouhnInfo(khozenCommonParam);

            DBAccessDCommonGengaku dBAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);
            dBAccessDCommonGengaku.insertHaitouInfo(uiBean.getKouryokuHasseiYmd(), uiBean.getKariwariatedruigk(),
                uiBean.getKariwariatedgngkkngk(), uiBean.getKariwariatedshrgk(), uiBean.getKhHaitouKanriKeyinfoBean(),
                khozenCommonParam);

            List<IT_KhDenpyoData> khDenpyoDataList = insertKTKkShrRrk(khozenCommonParam);

            insertKTKihrkpSeisanRrk();

            insertFbSoukinData(khDenpyoDataList);

            updateTumitatekinKanrenData();

            insertHokenryouTmttkn();

            editZennou(khozenCommonParam);

            editAzukarikin();

            editKoujyonaiyouTbl(khozenCommonParam);

            editKoujyonaiyouDTbl(khozenCommonParam,dBAccessDCommonGengaku.getKhHaitouKanri());

            makeDairitenTesuuryou(khozenCommonParam, tableMaintenanceUtil);

            updateKTKykSonotaTk(khozenCommonParam);

            updateKhDshrTuki(khozenCommonParam);

            insertSikinIdouRireki(khozenCommonParam, systemYmd, henkousikibetuKey);

            insertKhLincSousinData(khozenCommonParam, systemYmd, tableMaintenanceUtil.getBakKykKihon());

            makeTetudukiRireki(khozenCommonParam, kykKihon);

            editHokenKykIdouRirekiTbl(khozenCommonParam, systemYmd, systemTime);

            makeTyouhyou(khozenCommonParam);

            hozenDomManager.update(kykKihon);
        }

        doJikouteikanri();

        updateGengakuWK(khozenCommonParam);

        if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
            || C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())
            || !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

            uiBean.getKykKihon().detach();
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    String syokigamenhebtnbyresultOnClickBL() {

        String retUrl = "";

        if (C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {

            retUrl = FORWARDNAME_INIT;
        }
        else {

            retUrl = FORWARDNAME_BACKTOWORKLIST;
        }

        return retUrl;
    }

    String syoukainomibtnOnClickBL() {

        String retUrl = "";

        if (C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUKAI.toString().equals(kinouMode.getKinouMode())) {

            retUrl = FORWARDNAME_INIT;
        }
        else {

            pushUnlockProcessBL();

            retUrl = FORWARDNAME_BACKTOWORKLIST;
        }

        return retUrl;
    }

    void seikyuSyoModoru() {

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING6);
    }

    @Transactional
    void doUpdateSeikyuSyo() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn kouteiUmu = checkProcessKaishi.exec(uiBean.getSyono(),uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(kouteiUmu)) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean =
            SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);

        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        hozenPreReportRenkeiBean.setSyoNo(uiBean.getSyono());

        hozenPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());

        hozenPreReportRenkeiBean.setSyoriComment("");

        hozenPreReportRenkeiBean.setTaskNm(null);

        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        makeTyouhyouSeiKyuSyo(khozenCommonParam);

        updateGengakuWKSeikyuSyo(khozenCommonParam);

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);
    }

    void ctiOpenBL() {
        BizPropertyInitializer.initialize(uiBean);
        uiBean.setVkihnsyono(ctiParamBean.getSyono());
    }

    void printOut() {

        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);

        PdfBuilder pdfDate = new PdfBuilder();

        try {
            byte[] pdfDate1 = dbaOutputReport.getPdfImagesByJoinKeys(new String[]{uiBean.getReportKey()});

            pdfDate.append(new PdfReader(pdfDate1));

            if (C_UmuKbn.ARI.eq(uiBean.getMynoSinkokuTaisyouFlg())) {

                String fpath = SWAK.getApplicationRootPath() + YuyuHozenConfig.getInstance().getMyNumberFilePath();

                PdfReader pdfDate2 = new PdfReader(fpath);

                pdfDate.append(pdfDate2);
            }

            outputReport.outputJoinedPDFByBinary(pdfDate.toByteArray(), uiBean.getReportKey());

        } catch (IOException e) {
            throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));
        }
    }

    private void checkKykSonzai() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (kykKihon != null) {

            uiBean.setKykKihon(kykKihon);
        } else {

            throw new BizLogicException(MessageId.EBA0090);
        }
    }

    private void checkYuukouJyoutai(KhozenCommonParam pKhozenCommonParam) {

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());

        }
        else if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {

            for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING1,
                    BizUtil.getGeneralMessageId(checkYuukouJyoutai.getWarningMessageIDList().get(i)),
                    checkYuukouJyoutai.getWarningMessageList().get(i));
            }
        }
    }

    private void hanteiTtdkTyuui(KhozenCommonParam pKhozenCommonParam, String pSyono) {

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(pKhozenCommonParam, pSyono);

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());

        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {

            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(),
                hanteiTetuduki.getMessageParam());
        }
    }

    private void setWarnings(KhozenCommonParam pKhozenCommonParam) {

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(uiBean.getSyono());

        if (ansyuKihon != null) {

            SortIT_AnsyuRireki sortAnsyuRireki = SWAKInjector.getInstance(SortIT_AnsyuRireki.class);

            List<IT_AnsyuRireki> ansyuRirekiList = sortAnsyuRireki.OrderIT_AnsyuRirekiByJyuutouymDesc(
                ansyuKihon.getAnsyuRirekisByAnnaijkkbn(C_AnnaijkKbn.ANNAI));

            for (IT_AnsyuRireki ansyuRireki : ansyuRirekiList) {

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING1,
                    MessageId.WIA0016,
                    String.valueOf(ansyuRireki.getJyuutouym().getMonth()),
                    DateFormatUtil.dateMDDOT(ansyuRireki.getAnnaisakuseiymd().getBizDateMD()));
            }
        }
    }

    private void setUiBeanKinou(KhozenCommonParam pKhozenCommonParam) {

        List<IT_KykSyouhn> syuKykSyouhnList = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        if (syuKykSyouhnList.size() > 0) {

            uiBean.setSyouhinHanteiKbn(SyouhinUtil.hantei(syuKykSyouhnList.get(0).getSyouhncd()));

            GengakuKahiKbnBean gengakuKahiKbnBean = checkGengakuKahi(
                uiBean.getSyouhinHanteiKbn(),uiBean.getKykKihon().getSdpdkbn(),syuKykSyouhnList.get(0).getSyouhnZokusei());

            int syugengakukahiKbn = syuKykSyouhnList.get(0).getSyouhnZokusei().getGengakukahikbn();

            if (GENGAKUKAHIKBN_SYORIKANOU == syugengakukahiKbn) {

                uiBean.setSyuhnkkbn(C_KykhnkKbn.GENGAKU);
            }

            uiBean.setSyuGengakuKahiKbn(gengakuKahiKbnBean.getGengakukahikbn());

            uiBean.setSyukihons(syuKykSyouhnList.get(0).getKihons());

            uiBean.setSyutsnshrgndgk(syuKykSyouhnList.get(0).getSyouhnZokusei().getTsnshrgndgk());

            uiBean.setSyup(syuKykSyouhnList.get(0).getHokenryou());

            uiBean.setSyusyouhncd(syuKykSyouhnList.get(0).getSyouhncd());

            uiBean.setSyusyouhnsdno(syuKykSyouhnList.get(0).getSyouhnsdno());

            uiBean.setSyuryouritusdno(syuKykSyouhnList.get(0).getRyouritusdno());

            uiBean.setSyuyoteiriritu(syuKykSyouhnList.get(0).getYoteiriritu());

            uiBean.setSyukyksyouhnrenno(syuKykSyouhnList.get(0).getKyksyouhnrenno());

            uiBean.setSyukkyPgengakuKahiKbn(gengakuKahiKbnBean.getPgengakukahikbn());

            uiBean.setSyukkyKyksjKkkTyouseiriRitu(syuKykSyouhnList.get(0).getKyksjkkktyouseiriritu());

            uiBean.setYendtHnkYmd(syuKykSyouhnList.get(0).getYendthnkymd());

            uiBean.setGsBunriTaisyou(syuKykSyouhnList.get(0).getGsbunritaisyou());

            if (GENGAKUKAHIKBN_SYORIKANOU == uiBean.getSyuGengakuKahiKbn() &&
                C_KahiKbn.HUKA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {

                uiBean.setGengkhoukbn(C_GengkhouKbn.SD);
            }
            else if (GENGAKUKAHIKBN_SYORIKANOU  != uiBean.getSyuGengakuKahiKbn() &&
                C_KahiKbn.KA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {
                uiBean.setGengkhoukbn(C_GengkhouKbn.PD);
            }

            uiBean.setZeiseitkkktkykhukaumu(uiBean.getKykKihon().getKykSonotaTkyk().getZeiseitkkktkykhukaumu());
            uiBean.setTeikishrtkykhukaumu(uiBean.getKykKihon().getKykSonotaTkyk().getTeikishrtkykhukaumu());
            uiBean.setHeijyunbaraiumu(syuKykSyouhnList.get(0).getSyouhnZokusei().getHeijyunbaraiumu());
            uiBean.setItijibrumu(syuKykSyouhnList.get(0).getSyouhnZokusei().getItijibrumu());
        }
        else {

            throw new CommonBizAppException("契約商品テーブル取得エラー");
        }

        List<IT_KykSyouhn> tkKykSyouhnList = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.TK);

        if (tkKykSyouhnList != null && tkKykSyouhnList.size() > 0) {

            for (int i = 0; i < tkKykSyouhnList.size(); i++) {

                if (i == 0) {

                    uiBean.setTkGengakukahikbn1(tkKykSyouhnList.get(i).getSyouhnZokusei().getGengakukahikbn());

                    uiBean.setNewtkkihons1(tkKykSyouhnList.get(i).getKihons());

                    uiBean.setTktsnshrgndgk1(tkKykSyouhnList.get(i).getSyouhnZokusei().getTsnshrgndgk());

                    uiBean.setTksyouhnsdno1(tkKykSyouhnList.get(i).getSyouhnsdno());

                    uiBean.setTkkyksyouhnrenno1(tkKykSyouhnList.get(i).getKyksyouhnrenno());
                }
                else if (i == 1) {

                    uiBean.setTkGengakukahikbn2(tkKykSyouhnList.get(i).getSyouhnZokusei().getGengakukahikbn());

                    uiBean.setNewtkkihons2(tkKykSyouhnList.get(i).getKihons());

                    uiBean.setTktsnshrgndgk2(tkKykSyouhnList.get(i).getSyouhnZokusei().getTsnshrgndgk());

                    uiBean.setTksyouhnsdno2(tkKykSyouhnList.get(i).getSyouhnsdno());

                    uiBean.setTkkyksyouhnrenno2(tkKykSyouhnList.get(i).getKyksyouhnrenno());
                }
                else if (i == 2) {

                    uiBean.setTkGengakukahikbn3(tkKykSyouhnList.get(i).getSyouhnZokusei().getGengakukahikbn());

                    uiBean.setNewtkkihons3(tkKykSyouhnList.get(i).getKihons());

                    uiBean.setTktsnshrgndgk3(tkKykSyouhnList.get(i).getSyouhnZokusei().getTsnshrgndgk());

                    uiBean.setTksyouhnsdno3(tkKykSyouhnList.get(i).getSyouhnsdno());

                    uiBean.setTkkyksyouhnrenno3(tkKykSyouhnList.get(i).getKyksyouhnrenno());
                }
                else if (i == 3) {

                    uiBean.setTkGengakukahikbn4(tkKykSyouhnList.get(i).getSyouhnZokusei().getGengakukahikbn());

                    uiBean.setNewtkkihons4(tkKykSyouhnList.get(i).getKihons());

                    uiBean.setTktsnshrgndgk4(tkKykSyouhnList.get(i).getSyouhnZokusei().getTsnshrgndgk());

                    uiBean.setTksyouhnsdno4(tkKykSyouhnList.get(i).getSyouhnsdno());

                    uiBean.setTkkyksyouhnrenno4(tkKykSyouhnList.get(i).getKyksyouhnrenno());
                }
                else if (i == 4) {

                    uiBean.setTkGengakukahikbn5(tkKykSyouhnList.get(i).getSyouhnZokusei().getGengakukahikbn());

                    uiBean.setNewtkkihons5(tkKykSyouhnList.get(i).getKihons());

                    uiBean.setTktsnshrgndgk5(tkKykSyouhnList.get(i).getSyouhnZokusei().getTsnshrgndgk());

                    uiBean.setTksyouhnsdno5(tkKykSyouhnList.get(i).getSyouhnsdno());

                    uiBean.setTkkyksyouhnrenno5(tkKykSyouhnList.get(i).getKyksyouhnrenno());
                }
                else if (i == 5) {

                    uiBean.setTkGengakukahikbn6(tkKykSyouhnList.get(i).getSyouhnZokusei().getGengakukahikbn());

                    uiBean.setNewtkkihons6(tkKykSyouhnList.get(i).getKihons());

                    uiBean.setTktsnshrgndgk6(tkKykSyouhnList.get(i).getSyouhnZokusei().getTsnshrgndgk());

                    uiBean.setTksyouhnsdno6(tkKykSyouhnList.get(i).getSyouhnsdno());

                    uiBean.setTkkyksyouhnrenno6(tkKykSyouhnList.get(i).getKyksyouhnrenno());
                }
                else if (i == 6) {

                    uiBean.setTkGengakukahikbn7(tkKykSyouhnList.get(i).getSyouhnZokusei().getGengakukahikbn());

                    uiBean.setNewtkkihons7(tkKykSyouhnList.get(i).getKihons());

                    uiBean.setTktsnshrgndgk7(tkKykSyouhnList.get(i).getSyouhnZokusei().getTsnshrgndgk());

                    uiBean.setTksyouhnsdno7(tkKykSyouhnList.get(i).getSyouhnsdno());

                    uiBean.setTkkyksyouhnrenno7(tkKykSyouhnList.get(i).getKyksyouhnrenno());
                }
                else if (i == 7) {

                    uiBean.setTkGengakukahikbn8(tkKykSyouhnList.get(i).getSyouhnZokusei().getGengakukahikbn());

                    uiBean.setNewtkkihons8(tkKykSyouhnList.get(i).getKihons());

                    uiBean.setTktsnshrgndgk8(tkKykSyouhnList.get(i).getSyouhnZokusei().getTsnshrgndgk());

                    uiBean.setTksyouhnsdno8(tkKykSyouhnList.get(i).getSyouhnsdno());

                    uiBean.setTkkyksyouhnrenno8(tkKykSyouhnList.get(i).getKyksyouhnrenno());
                }
                else if (i == 8) {

                    uiBean.setTkGengakukahikbn9(tkKykSyouhnList.get(i).getSyouhnZokusei().getGengakukahikbn());

                    uiBean.setNewtkkihons9(tkKykSyouhnList.get(i).getKihons());

                    uiBean.setTktsnshrgndgk9(tkKykSyouhnList.get(i).getSyouhnZokusei().getTsnshrgndgk());

                    uiBean.setTksyouhnsdno9(tkKykSyouhnList.get(i).getSyouhnsdno());

                    uiBean.setTkkyksyouhnrenno9(tkKykSyouhnList.get(i).getKyksyouhnrenno());
                }
                else if (i == 9) {

                    uiBean.setTkGengakukahikbn10(tkKykSyouhnList.get(i).getSyouhnZokusei().getGengakukahikbn());

                    uiBean.setNewtkkihons10(tkKykSyouhnList.get(i).getKihons());

                    uiBean.setTktsnshrgndgk10(tkKykSyouhnList.get(i).getSyouhnZokusei().getTsnshrgndgk());

                    uiBean.setTksyouhnsdno10(tkKykSyouhnList.get(i).getSyouhnsdno());

                    uiBean.setTkkyksyouhnrenno10(tkKykSyouhnList.get(i).getKyksyouhnrenno());
                }
            }
        }
        else if (GENGAKUKAHIKBN_SYORIKANOU != uiBean.getSyuGengakuKahiKbn()&&
            C_KahiKbn.HUKA.eq(uiBean.getSyukkyPgengakuKahiKbn())) {

            throw new BizLogicException(MessageId.EIF1066);
        }

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);

        SetKihon.exec(pKhozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);

        setBetukyk.exec(pKhozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList().size() > 0) {

            for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING1,
                    uiBean.getWarningMessageIdList().get(i),
                    uiBean.getWarningMessageList().get(i));
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

        SetHaitoukin setHaitoukin = SWAKInjector.getInstance(SetHaitoukin.class);
        setHaitoukin.exec(pKhozenCommonParam, uiBean);

        SetTrkKazoku.exec(pKhozenCommonParam, uiBean);

        SetKyksyadairi.exec(pKhozenCommonParam, uiBean);

        SetKhTkshrSiharaiKouza setKhTkshrSiharaiKouza = SWAKInjector.getInstance(SetKhTkshrSiharaiKouza.class);
        setKhTkshrSiharaiKouza.exec(pKhozenCommonParam, uiBean);

        SetHituyouSyorui.exec(pKhozenCommonParam, uiBean);
    }

    private void updateSyouhnInfo(KhozenCommonParam pKhozenCommonParam) {

        updateSyuSyouhnInfo(pKhozenCommonParam);

        updateTkSyouhnInfo(pKhozenCommonParam);
    }

    private void updateSyuSyouhnInfo(KhozenCommonParam pKhozenCommonParam) {

        EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

        editKykSyhnRirekiTbl.exec(
            pKhozenCommonParam,
            uiBean.getSyono(),
            C_SyutkKbn.SYU,
            uiBean.getSyusyouhncd(),
            uiBean.getSyusyouhnsdno(),
            uiBean.getSyukyksyouhnrenno());

        IT_KykSyouhn kykSyouhn = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        boolean yendtHnkSyouhnFlg = C_YendthnkJyoutaiKbn.YENDTHNKZUMI.eq(uiBean.getVhsyuyendthnkjyoutaikbn());

        if (!yendtHnkSyouhnFlg && C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {
            BizCurrency gengakuoYenItijibrPstgk = null;
            C_Tkhukaumu yenNyukinTkKbn = C_Tkhukaumu.NONE;
            IT_NyknJissekiRireki nyknJissekiRireki = null;
            KeisanKijyungk keisanKijyungk = null;

            if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn() ||
                SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyouhinHanteiKbn()) {
                nyknJissekiRireki = pKhozenCommonParam.getNyknJissekiRirekiSk(uiBean.getSyono()).get(0);

                keisanKijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);

                keisanKijyungk.exec(nyknJissekiRireki.getRyosyuymd(),
                    nyknJissekiRireki.getRsgaku(), uiBean.getSyup(), kykSyouhn.getKyktuukasyu(), yenNyukinTkKbn);

                gengakuoYenItijibrPstgk = keisanKijyungk.getKijyungk();
            }
            else {
                List<IT_KhTtdkRireki> khTtdkRirekiList = uiBean.getKykKihon()
                    .getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_GENGAKU);

                if (khTtdkRirekiList.size() > 0) {
                    gengakuoYenItijibrPstgk = kykSyouhn.getGengakugoyenitijibrpstgk();
                }
                else {
                    nyknJissekiRireki = pKhozenCommonParam.getNyknJissekiRirekiSk(uiBean.getSyono()).get(0);

                    IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();

                    if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
                        yenNyukinTkKbn = C_Tkhukaumu.HUKA;
                    }

                    keisanKijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);

                    keisanKijyungk.exec(nyknJissekiRireki.getRyosyuymd(),
                        nyknJissekiRireki.getRsgaku(), nyknJissekiRireki.getHrkp(), kykSyouhn.getKyktuukasyu(), yenNyukinTkKbn);

                    gengakuoYenItijibrPstgk = keisanKijyungk.getKijyungk();
                }
                BizNumber torikuzusiWari = uiBean.getSyukihons().divideBizCurrency(uiBean.getVhsyusyukihons(),
                    10, RoundingMode.HALF_UP);

                gengakuoYenItijibrPstgk = gengakuoYenItijibrPstgk.multiply(torikuzusiWari).toValidValue(RoundingMode.UP);
            }
            kykSyouhn.setGengakugoyenitijibrpstgk(gengakuoYenItijibrPstgk);
        }

        kykSyouhn.setHenkousikibetukey(henkousikibetuKey);

        kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

        if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

            kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);
        }

        kykSyouhn.setKihons(uiBean.getSyukihons());

        kykSyouhn.setHokenryou(uiBean.getSyup());

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyouhinHanteiKbn()) {
            kykSyouhn.setPharaikomisougaku(uiBean.getNewsyukjnkngk());
        }

        kykSyouhn.setGyoumuKousinKinou(kinouId);

        kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);

        kykSyouhn.setGyoumuKousinTime(systemTime);

        IT_SyouhnTokujou syouhnTokujou =
            uiBean.getKykKihon().getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                C_SyutkKbn.SYU,
                uiBean.getSyusyouhncd(),
                uiBean.getSyusyouhnsdno(),
                uiBean.getSyukyksyouhnrenno());

        if (syouhnTokujou != null) {

            syouhnTokujou.setHenkousikibetukey(henkousikibetuKey);

            syouhnTokujou.setGyoumuKousinKinou(kinouId);

            syouhnTokujou.setGyoumuKousinsyaId(sousasyaCd);

            syouhnTokujou.setGyoumuKousinTime(systemTime);
        }
    }

    private void updateTkSyouhnInfo(KhozenCommonParam pKhozenCommonParam) {

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd1())) {

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
                C_SyutkKbn.TK,
                uiBean.getVhsyudisptksyouhncd1(),
                uiBean.getTksyouhnsdno1(),
                uiBean.getTkkyksyouhnrenno1());

            if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn1()) || C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn1())) {

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd1(),
                    uiBean.getTksyouhnsdno1(),
                    uiBean.getTkkyksyouhnrenno1());

                if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn1())) {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);
                    kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());
                    kykSyouhn.setKihons(uiBean.getNewtkkihons1());
                    kykSyouhn.setHokenryou(uiBean.getNewdisptkp1());

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }
                else {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);

                        kykSyouhn.setHokenryou(uiBean.getNewdisptkp1());
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd1(),
                    uiBean.getTksyouhnsdno1(),
                    uiBean.getTkkyksyouhnrenno1());

                if (syouhnTokujou != null) {

                    syouhnTokujou.setHenkousikibetukey(henkousikibetuKey);
                    syouhnTokujou.setGyoumuKousinKinou(kinouId);
                    syouhnTokujou.setGyoumuKousinsyaId(sousasyaCd);
                    syouhnTokujou.setGyoumuKousinTime(systemTime);
                }
            }
            else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn1())) {

                C_Syoumetujiyuu syoumetujiyu;

                if (C_Syoumetujiyuu.SIKKOU.eq(uiBean.getVkihnsyoumetujiyuu())) {

                    syoumetujiyu = C_Syoumetujiyuu.SIKKOUKAIYAKU;
                }
                else {

                    syoumetujiyu = C_Syoumetujiyuu.KAIYAKU;
                }

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd1(),
                    uiBean.getTksyouhnsdno1(),
                    uiBean.getTkkyksyouhnrenno1(),
                    syoumetujiyu,
                    systemYmd,
                    uiBean.getKouryokuHasseiYmd());

                kykKihon.getKykSyouhns().remove(kykSyouhn);

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd1(),
                    uiBean.getTksyouhnsdno1(),
                    uiBean.getTkkyksyouhnrenno1());

                kykKihon.getSyouhnTokujous().remove(syouhnTokujou);
            }
        }

        if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd2())) {

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
                C_SyutkKbn.TK,
                uiBean.getVhsyudisptksyouhncd2(),
                uiBean.getTksyouhnsdno2(),
                uiBean.getTkkyksyouhnrenno2());

            if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn2()) || C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn2())) {

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd2(),
                    uiBean.getTksyouhnsdno2(),
                    uiBean.getTkkyksyouhnrenno2());

                if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn2())) {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);
                    kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());
                    kykSyouhn.setKihons(uiBean.getNewtkkihons2());
                    kykSyouhn.setHokenryou(uiBean.getNewdisptkp2());

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }
                else {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);

                        kykSyouhn.setHokenryou(uiBean.getNewdisptkp2());
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd2(),
                    uiBean.getTksyouhnsdno2(),
                    uiBean.getTkkyksyouhnrenno2());

                if (syouhnTokujou != null) {

                    syouhnTokujou.setHenkousikibetukey(henkousikibetuKey);
                    syouhnTokujou.setGyoumuKousinKinou(kinouId);
                    syouhnTokujou.setGyoumuKousinsyaId(sousasyaCd);
                    syouhnTokujou.setGyoumuKousinTime(systemTime);
                }
            }
            else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn2())) {

                C_Syoumetujiyuu syoumetujiyu;

                if (C_Syoumetujiyuu.SIKKOU.eq(uiBean.getVkihnsyoumetujiyuu())) {

                    syoumetujiyu = C_Syoumetujiyuu.SIKKOUKAIYAKU;
                }
                else {

                    syoumetujiyu = C_Syoumetujiyuu.KAIYAKU;
                }

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd2(),
                    uiBean.getTksyouhnsdno2(),
                    uiBean.getTkkyksyouhnrenno2(),
                    syoumetujiyu,
                    systemYmd,
                    uiBean.getKouryokuHasseiYmd());

                kykKihon.getKykSyouhns().remove(kykSyouhn);

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd2(),
                    uiBean.getTksyouhnsdno2(),
                    uiBean.getTkkyksyouhnrenno2());

                kykKihon.getSyouhnTokujous().remove(syouhnTokujou);
            }
        }

        if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd3())) {

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
                C_SyutkKbn.TK,
                uiBean.getVhsyudisptksyouhncd3(),
                uiBean.getTksyouhnsdno3(),
                uiBean.getTkkyksyouhnrenno3());

            if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn3()) || C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn3())) {

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd3(),
                    uiBean.getTksyouhnsdno3(),
                    uiBean.getTkkyksyouhnrenno3());

                if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn3())) {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);
                    kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());
                    kykSyouhn.setKihons(uiBean.getNewtkkihons3());
                    kykSyouhn.setHokenryou(uiBean.getNewdisptkp3());

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }
                else {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);

                        kykSyouhn.setHokenryou(uiBean.getNewdisptkp3());
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd3(),
                    uiBean.getTksyouhnsdno3(),
                    uiBean.getTkkyksyouhnrenno3());

                if (syouhnTokujou != null) {

                    syouhnTokujou.setHenkousikibetukey(henkousikibetuKey);
                    syouhnTokujou.setGyoumuKousinKinou(kinouId);
                    syouhnTokujou.setGyoumuKousinsyaId(sousasyaCd);
                    syouhnTokujou.setGyoumuKousinTime(systemTime);
                }
            }
            else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn3())) {

                C_Syoumetujiyuu syoumetujiyu;

                if (C_Syoumetujiyuu.SIKKOU.eq(uiBean.getVkihnsyoumetujiyuu())) {

                    syoumetujiyu = C_Syoumetujiyuu.SIKKOUKAIYAKU;
                }
                else {

                    syoumetujiyu = C_Syoumetujiyuu.KAIYAKU;
                }

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd3(),
                    uiBean.getTksyouhnsdno3(),
                    uiBean.getTkkyksyouhnrenno3(),
                    syoumetujiyu,
                    systemYmd,
                    uiBean.getKouryokuHasseiYmd());

                kykKihon.getKykSyouhns().remove(kykSyouhn);

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd3(),
                    uiBean.getTksyouhnsdno3(),
                    uiBean.getTkkyksyouhnrenno3());

                kykKihon.getSyouhnTokujous().remove(syouhnTokujou);
            }
        }

        if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd4())) {

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
                C_SyutkKbn.TK,
                uiBean.getVhsyudisptksyouhncd4(),
                uiBean.getTksyouhnsdno4(),
                uiBean.getTkkyksyouhnrenno4());

            if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn4()) || C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn4())) {

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd4(),
                    uiBean.getTksyouhnsdno4(),
                    uiBean.getTkkyksyouhnrenno4());

                if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn4())) {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);
                    kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());
                    kykSyouhn.setKihons(uiBean.getNewtkkihons4());
                    kykSyouhn.setHokenryou(uiBean.getNewdisptkp4());

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }
                else {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);

                        kykSyouhn.setHokenryou(uiBean.getNewdisptkp4());
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd4(),
                    uiBean.getTksyouhnsdno4(),
                    uiBean.getTkkyksyouhnrenno4());

                if (syouhnTokujou != null) {

                    syouhnTokujou.setHenkousikibetukey(henkousikibetuKey);
                    syouhnTokujou.setGyoumuKousinKinou(kinouId);
                    syouhnTokujou.setGyoumuKousinsyaId(sousasyaCd);
                    syouhnTokujou.setGyoumuKousinTime(systemTime);
                }
            }
            else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn4())) {

                C_Syoumetujiyuu syoumetujiyu;

                if (C_Syoumetujiyuu.SIKKOU.eq(uiBean.getVkihnsyoumetujiyuu())) {

                    syoumetujiyu = C_Syoumetujiyuu.SIKKOUKAIYAKU;
                }
                else {

                    syoumetujiyu = C_Syoumetujiyuu.KAIYAKU;
                }

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd4(),
                    uiBean.getTksyouhnsdno4(),
                    uiBean.getTkkyksyouhnrenno4(),
                    syoumetujiyu,
                    systemYmd,
                    uiBean.getKouryokuHasseiYmd());

                kykKihon.getKykSyouhns().remove(kykSyouhn);

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd4(),
                    uiBean.getTksyouhnsdno4(),
                    uiBean.getTkkyksyouhnrenno4());

                kykKihon.getSyouhnTokujous().remove(syouhnTokujou);
            }
        }

        if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd5())) {

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
                C_SyutkKbn.TK,
                uiBean.getVhsyudisptksyouhncd5(),
                uiBean.getTksyouhnsdno5(),
                uiBean.getTkkyksyouhnrenno5());

            if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn5()) || C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn5())) {

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd5(),
                    uiBean.getTksyouhnsdno5(),
                    uiBean.getTkkyksyouhnrenno5());

                if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn5())) {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);
                    kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());
                    kykSyouhn.setKihons(uiBean.getNewtkkihons5());
                    kykSyouhn.setHokenryou(uiBean.getNewdisptkp5());

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }
                else {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);

                        kykSyouhn.setHokenryou(uiBean.getNewdisptkp5());
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd5(),
                    uiBean.getTksyouhnsdno5(),
                    uiBean.getTkkyksyouhnrenno5());

                if (syouhnTokujou != null) {

                    syouhnTokujou.setHenkousikibetukey(henkousikibetuKey);
                    syouhnTokujou.setGyoumuKousinKinou(kinouId);
                    syouhnTokujou.setGyoumuKousinsyaId(sousasyaCd);
                    syouhnTokujou.setGyoumuKousinTime(systemTime);
                }
            }
            else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn5())) {

                C_Syoumetujiyuu syoumetujiyu;

                if (C_Syoumetujiyuu.SIKKOU.eq(uiBean.getVkihnsyoumetujiyuu())) {

                    syoumetujiyu = C_Syoumetujiyuu.SIKKOUKAIYAKU;
                }
                else {

                    syoumetujiyu = C_Syoumetujiyuu.KAIYAKU;
                }

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd5(),
                    uiBean.getTksyouhnsdno5(),
                    uiBean.getTkkyksyouhnrenno5(),
                    syoumetujiyu,
                    systemYmd,
                    uiBean.getKouryokuHasseiYmd());

                kykKihon.getKykSyouhns().remove(kykSyouhn);

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd5(),
                    uiBean.getTksyouhnsdno5(),
                    uiBean.getTkkyksyouhnrenno5());

                kykKihon.getSyouhnTokujous().remove(syouhnTokujou);
            }
        }

        if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd6())) {

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
                C_SyutkKbn.TK,
                uiBean.getVhsyudisptksyouhncd6(),
                uiBean.getTksyouhnsdno6(),
                uiBean.getTkkyksyouhnrenno6());

            if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn6()) || C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn6())) {

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd6(),
                    uiBean.getTksyouhnsdno6(),
                    uiBean.getTkkyksyouhnrenno6());

                if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn6())) {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);
                    kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());
                    kykSyouhn.setKihons(uiBean.getNewtkkihons6());
                    kykSyouhn.setHokenryou(uiBean.getNewdisptkp6());

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }
                else {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);

                        kykSyouhn.setHokenryou(uiBean.getNewdisptkp6());
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd6(),
                    uiBean.getTksyouhnsdno6(),
                    uiBean.getTkkyksyouhnrenno6());

                if (syouhnTokujou != null) {

                    syouhnTokujou.setHenkousikibetukey(henkousikibetuKey);
                    syouhnTokujou.setGyoumuKousinKinou(kinouId);
                    syouhnTokujou.setGyoumuKousinsyaId(sousasyaCd);
                    syouhnTokujou.setGyoumuKousinTime(systemTime);
                }
            }
            else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn6())) {

                C_Syoumetujiyuu syoumetujiyu;

                if (C_Syoumetujiyuu.SIKKOU.eq(uiBean.getVkihnsyoumetujiyuu())) {

                    syoumetujiyu = C_Syoumetujiyuu.SIKKOUKAIYAKU;
                }
                else {

                    syoumetujiyu = C_Syoumetujiyuu.KAIYAKU;
                }

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd6(),
                    uiBean.getTksyouhnsdno6(),
                    uiBean.getTkkyksyouhnrenno6(),
                    syoumetujiyu,
                    systemYmd,
                    uiBean.getKouryokuHasseiYmd());

                kykKihon.getKykSyouhns().remove(kykSyouhn);

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd6(),
                    uiBean.getTksyouhnsdno6(),
                    uiBean.getTkkyksyouhnrenno6());

                kykKihon.getSyouhnTokujous().remove(syouhnTokujou);
            }
        }

        if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd7())) {

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
                C_SyutkKbn.TK,
                uiBean.getVhsyudisptksyouhncd7(),
                uiBean.getTksyouhnsdno7(),
                uiBean.getTkkyksyouhnrenno7());

            if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn7()) || C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn7())) {

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd7(),
                    uiBean.getTksyouhnsdno7(),
                    uiBean.getTkkyksyouhnrenno7());

                if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn7())) {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);
                    kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());
                    kykSyouhn.setKihons(uiBean.getNewtkkihons7());
                    kykSyouhn.setHokenryou(uiBean.getNewdisptkp7());

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }
                else {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);

                        kykSyouhn.setHokenryou(uiBean.getNewdisptkp7());
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd7(),
                    uiBean.getTksyouhnsdno7(),
                    uiBean.getTkkyksyouhnrenno7());

                if (syouhnTokujou != null) {

                    syouhnTokujou.setHenkousikibetukey(henkousikibetuKey);
                    syouhnTokujou.setGyoumuKousinKinou(kinouId);
                    syouhnTokujou.setGyoumuKousinsyaId(sousasyaCd);
                    syouhnTokujou.setGyoumuKousinTime(systemTime);
                }
            }
            else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn7())) {

                C_Syoumetujiyuu syoumetujiyu;

                if (C_Syoumetujiyuu.SIKKOU.eq(uiBean.getVkihnsyoumetujiyuu())) {

                    syoumetujiyu = C_Syoumetujiyuu.SIKKOUKAIYAKU;
                }
                else {

                    syoumetujiyu = C_Syoumetujiyuu.KAIYAKU;
                }

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd7(),
                    uiBean.getTksyouhnsdno7(),
                    uiBean.getTkkyksyouhnrenno7(),
                    syoumetujiyu,
                    systemYmd,
                    uiBean.getKouryokuHasseiYmd());

                kykKihon.getKykSyouhns().remove(kykSyouhn);

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd7(),
                    uiBean.getTksyouhnsdno7(),
                    uiBean.getTkkyksyouhnrenno7());

                kykKihon.getSyouhnTokujous().remove(syouhnTokujou);
            }
        }

        if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd8())) {

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
                C_SyutkKbn.TK,
                uiBean.getVhsyudisptksyouhncd8(),
                uiBean.getTksyouhnsdno8(),
                uiBean.getTkkyksyouhnrenno8());

            if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn8()) || C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn8())) {

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd8(),
                    uiBean.getTksyouhnsdno8(),
                    uiBean.getTkkyksyouhnrenno8());

                if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn8())) {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);
                    kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());
                    kykSyouhn.setKihons(uiBean.getNewtkkihons8());
                    kykSyouhn.setHokenryou(uiBean.getNewdisptkp8());

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }
                else {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);

                        kykSyouhn.setHokenryou(uiBean.getNewdisptkp8());
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd8(),
                    uiBean.getTksyouhnsdno8(),
                    uiBean.getTkkyksyouhnrenno8());

                if (syouhnTokujou != null) {

                    syouhnTokujou.setHenkousikibetukey(henkousikibetuKey);
                    syouhnTokujou.setGyoumuKousinKinou(kinouId);
                    syouhnTokujou.setGyoumuKousinsyaId(sousasyaCd);
                    syouhnTokujou.setGyoumuKousinTime(systemTime);
                }
            }
            else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn8())) {

                C_Syoumetujiyuu syoumetujiyu;

                if (C_Syoumetujiyuu.SIKKOU.eq(uiBean.getVkihnsyoumetujiyuu())) {

                    syoumetujiyu = C_Syoumetujiyuu.SIKKOUKAIYAKU;
                }
                else {

                    syoumetujiyu = C_Syoumetujiyuu.KAIYAKU;
                }

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd8(),
                    uiBean.getTksyouhnsdno8(),
                    uiBean.getTkkyksyouhnrenno8(),
                    syoumetujiyu,
                    systemYmd,
                    uiBean.getKouryokuHasseiYmd());

                kykKihon.getKykSyouhns().remove(kykSyouhn);

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd8(),
                    uiBean.getTksyouhnsdno8(),
                    uiBean.getTkkyksyouhnrenno8());

                kykKihon.getSyouhnTokujous().remove(syouhnTokujou);
            }
        }

        if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd9())) {

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
                C_SyutkKbn.TK,
                uiBean.getVhsyudisptksyouhncd9(),
                uiBean.getTksyouhnsdno9(),
                uiBean.getTkkyksyouhnrenno9());

            if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn9()) || C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn9())) {

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd9(),
                    uiBean.getTksyouhnsdno9(),
                    uiBean.getTkkyksyouhnrenno9());

                if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn9())) {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);
                    kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());
                    kykSyouhn.setKihons(uiBean.getNewtkkihons9());
                    kykSyouhn.setHokenryou(uiBean.getNewdisptkp9());

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }
                else {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);

                        kykSyouhn.setHokenryou(uiBean.getNewdisptkp9());
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd9(),
                    uiBean.getTksyouhnsdno9(),
                    uiBean.getTkkyksyouhnrenno9());

                if (syouhnTokujou != null) {

                    syouhnTokujou.setHenkousikibetukey(henkousikibetuKey);
                    syouhnTokujou.setGyoumuKousinKinou(kinouId);
                    syouhnTokujou.setGyoumuKousinsyaId(sousasyaCd);
                    syouhnTokujou.setGyoumuKousinTime(systemTime);
                }
            }
            else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn9())) {

                C_Syoumetujiyuu syoumetujiyu;

                if (C_Syoumetujiyuu.SIKKOU.eq(uiBean.getVkihnsyoumetujiyuu())) {

                    syoumetujiyu = C_Syoumetujiyuu.SIKKOUKAIYAKU;
                }
                else {

                    syoumetujiyu = C_Syoumetujiyuu.KAIYAKU;
                }

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd9(),
                    uiBean.getTksyouhnsdno9(),
                    uiBean.getTkkyksyouhnrenno9(),
                    syoumetujiyu,
                    systemYmd,
                    uiBean.getKouryokuHasseiYmd());

                kykKihon.getKykSyouhns().remove(kykSyouhn);

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd9(),
                    uiBean.getTksyouhnsdno9(),
                    uiBean.getTkkyksyouhnrenno9());

                kykKihon.getSyouhnTokujous().remove(syouhnTokujou);
            }
        }

        if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd10())) {

            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
                C_SyutkKbn.TK,
                uiBean.getVhsyudisptksyouhncd10(),
                uiBean.getTksyouhnsdno10(),
                uiBean.getTkkyksyouhnrenno10());

            if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn10()) || C_KykhnkKbn.BLNK.eq(uiBean.getTkhnkkbn10())) {

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd10(),
                    uiBean.getTksyouhnsdno10(),
                    uiBean.getTkkyksyouhnrenno10());

                if (C_KykhnkKbn.GENGAKU.eq(uiBean.getTkhnkkbn10())) {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);
                    kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());
                    kykSyouhn.setKihons(uiBean.getNewtkkihons10());
                    kykSyouhn.setHokenryou(uiBean.getNewdisptkp10());

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }
                else {

                    kykSyouhn.setHenkousikibetukey(henkousikibetuKey);

                    if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

                        kykSyouhn.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

                        kykSyouhn.setPmnjtkkbn(C_PmnjtkKbn.NONE);

                        kykSyouhn.setHokenryou(uiBean.getNewdisptkp10());
                    }

                    kykSyouhn.setGyoumuKousinKinou(kinouId);
                    kykSyouhn.setGyoumuKousinsyaId(sousasyaCd);
                    kykSyouhn.setGyoumuKousinTime(systemTime);
                }

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd10(),
                    uiBean.getTksyouhnsdno10(),
                    uiBean.getTkkyksyouhnrenno10());

                if (syouhnTokujou != null) {

                    syouhnTokujou.setHenkousikibetukey(henkousikibetuKey);
                    syouhnTokujou.setGyoumuKousinKinou(kinouId);
                    syouhnTokujou.setGyoumuKousinsyaId(sousasyaCd);
                    syouhnTokujou.setGyoumuKousinTime(systemTime);
                }
            }
            else if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getTkhnkkbn10())) {

                C_Syoumetujiyuu syoumetujiyu;

                if (C_Syoumetujiyuu.SIKKOU.eq(uiBean.getVkihnsyoumetujiyuu())) {

                    syoumetujiyu = C_Syoumetujiyuu.SIKKOUKAIYAKU;
                }
                else {

                    syoumetujiyu = C_Syoumetujiyuu.KAIYAKU;
                }

                EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

                editKykSyhnRirekiTbl.exec(
                    pKhozenCommonParam,
                    uiBean.getSyono(),
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd10(),
                    uiBean.getTksyouhnsdno10(),
                    uiBean.getTkkyksyouhnrenno10(),
                    syoumetujiyu,
                    systemYmd,
                    uiBean.getKouryokuHasseiYmd());

                kykKihon.getKykSyouhns().remove(kykSyouhn);

                IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.TK,
                    uiBean.getVhsyudisptksyouhncd10(),
                    uiBean.getTksyouhnsdno10(),
                    uiBean.getTkkyksyouhnrenno10());

                kykKihon.getSyouhnTokujous().remove(syouhnTokujou);
            }
        }
    }

    private List<IT_KhDenpyoData> insertKTKkShrRrk(KhozenCommonParam pKhozenCommonParam) {

        List<IT_KhDenpyoData> khDenpyoDataList = new ArrayList<IT_KhDenpyoData>();

        if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0 ||
            uiBean.getAzukarigoukeigk().compareTo(BizCurrency.valueOf(0, uiBean.getAzukarigoukeigk().getType())) > 0 ||
            uiBean.getAzukarijpygoukeigk().compareTo(BizCurrency.valueOf(0, uiBean.getAzukarijpygoukeigk().getType())) > 0) {

            IT_KhTtdkRireki khTtdkRireki = uiBean.getKykKihon().getKhTtdkRirekiByHenkousikibetukey(henkousikibetuKey);

            IT_KhShrRireki khShrRireki = khTtdkRireki.createKhShrRireki();

            BizDate shrtienrskkisanymd = null;
            Integer tienrsknissuu = 0;
            BizCurrency shrtuukashrgkgoukei = null;
            BizCurrency shrtuukasyushrgkkei = null;
            BizCurrency shrtuukagstszeigk = null;
            BizCurrency yenshrgkgoukei = null;
            BizCurrency shrtuukashrtienrsk = null;
            BizCurrency yenshrtienrsk = null;
            BizCurrency yenSyushrgkkei = null;
            BizCurrency shrtuukakaiyakuhrkngkkei = null;
            BizCurrency shrtuukasonotashrkngk = null;
            BizCurrency kaiyakuhrkngkkeiyen = null;
            BizCurrency sonotashrkngksiteituuka = null;

            if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {

                shrtienrskkisanymd = uiBean.getYendtTienRskKsnbi();

                tienrsknissuu = uiBean.getYendtTienRskNissuu();

                shrtuukashrgkgoukei = uiBean.getYendthnkshrgkgoukeikakunin();

                shrtuukasyushrgkkei = uiBean.getYendthnkkaiyakuhr();

                shrtuukagstszeigk = uiBean.getYendthnkgstszeigk();

                yenshrgkgoukei = uiBean.getYendthnkshrgkgoukeikakunin();

                shrtuukashrtienrsk = uiBean.getYendthnkshrtienrsk();

                yenshrtienrsk = uiBean.getYendthnkshrtienrsk();

                yenSyushrgkkei = uiBean.getYendthnkkaiyakuhr();

                shrtuukakaiyakuhrkngkkei = uiBean.getKaiyakuhrkngkkeisiteituuka();

                shrtuukasonotashrkngk = uiBean.getYensonotashrgk();

                kaiyakuhrkngkkeiyen = uiBean.getKaiyakuhrkngkkeisiteituuka();

                sonotashrkngksiteituuka = uiBean.getYensonotashrgk();
            }
            else {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {

                    shrtienrskkisanymd = uiBean.getJpyTienrisoKukisanYmd();

                    tienrsknissuu = uiBean.getJpyTienrskNissuu();

                    shrtuukashrgkgoukei = uiBean.getJpyshrgkgoukeikakunin();

                    shrtuukasyushrgkkei = uiBean.getJpykaiyakuhr();

                    shrtuukagstszeigk = uiBean.getJpyGsTszeigk();

                    yenshrgkgoukei = uiBean.getJpyshrgkgoukeikakunin();

                    if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhouSiteiKbn())) {

                        shrtuukashrtienrsk = uiBean.getJpyshrtienrsk();

                        yenshrtienrsk = uiBean.getJpyshrtienrsk();
                    }
                    else {

                        shrtuukashrtienrsk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                        yenshrtienrsk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    }

                    yenSyushrgkkei = uiBean.getJpykaiyakuhr();

                    shrtuukakaiyakuhrkngkkei = uiBean.getYenkiykhrgoukei();

                    shrtuukasonotashrkngk = uiBean.getYensonotashrgk();
                }
                else {

                    shrtienrskkisanymd = uiBean.getTienrisoKukisanYmd();

                    tienrsknissuu = uiBean.getTienrskNissuu();

                    shrtuukashrgkgoukei = uiBean.getShrgkgoukeikakunin();

                    shrtuukasyushrgkkei = uiBean.getKaiyakuhr();

                    shrtuukagstszeigk = uiBean.getGsTsZeigk();

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    yenshrgkgoukei = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        uiBean.getShrgkgoukeikakunin(),
                        uiBean.getZeimukwsrate(),
                        C_HasuusyoriKbn.SUTE);

                    if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhouSiteiKbn())) {

                        shrtuukashrtienrsk = uiBean.getShrtienrsk();

                        yenshrtienrsk = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            uiBean.getShrtienrsk(),
                            uiBean.getZeimukwsrate(),
                            C_HasuusyoriKbn.SUTE);
                    }
                    else {

                        shrtuukashrtienrsk = BizCurrency.valueOf(0, uiBean.getShrtienrsk().getType());

                        yenshrtienrsk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    }

                    yenSyushrgkkei = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY, uiBean.getKaiyakuhr(), uiBean.getZeimukwsrate(), C_HasuusyoriKbn.SUTE);

                    shrtuukakaiyakuhrkngkkei = uiBean.getKaiyakuhrkngkkeisiteituuka();

                    shrtuukasonotashrkngk = uiBean.getSonotashrgk();
                }

                kaiyakuhrkngkkeiyen = uiBean.getYenkiykhrgoukei();
                sonotashrkngksiteituuka = uiBean.getSntshrgksssonotashrgk();
            }

            BizCurrency yengstszeigknationaltax = null;
            BizCurrency yengstszeigklocaltax = null;

            if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {

                yengstszeigknationaltax = uiBean.getYenkaShrYenGsTsZeigkNationaltax();

                yengstszeigklocaltax = uiBean.getYenkaShrYenGsTsZeigkLocaltax();

            }
            else {

                yengstszeigknationaltax = uiBean.getGaikaShrYenGsTsZeigkNationaltax();

                yengstszeigklocaltax = uiBean.getGaikaShrYenGsTsZeigkLocaltax();
            }

            String nztodouhukencd = null;

            if (C_UmuKbn.ARI.eq(uiBean.getGsBunriTaisyouFlag())) {

                BzGetAdrData bzGetAdrData = SWAKInjector.getInstance(BzGetAdrData.class);

                bzGetAdrData.execTodouhukenCdByPostalcd(uiBean.getVtssktsinyno());

                String todouhukenCd = BizUtil.num(bzGetAdrData.getTodouhukenCd().getValue(), BizUtil.ZERO_FILL, 2);

                nztodouhukencd = todouhukenCd;
            }
            else {
                nztodouhukencd = "";
            }

            khShrRireki.setShrymd(uiBean.getShrymd());

            khShrRireki.setShrsyoriymd(systemYmd);

            khShrRireki.setShrsyorikbn(C_ShrsyoriKbn.GENGAKU);

            khShrRireki.setSyoruiukeymd(uiBean.getSyoruiukeymd());

            khShrRireki.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

            khShrRireki.setShrtienrskkisanymd(shrtienrskkisanymd);

            khShrRireki.setTienrsknissuu(tienrsknissuu);

            khShrRireki.setGsbunritaisyou(uiBean.getGsBunriTaisyouFlag());

            khShrRireki.setYenshrtkumu(uiBean.getYenshrtkumu());

            khShrRireki.setKyktuukasyu(uiBean.getShrkyktuukasyu());

            khShrRireki.setSyushrgkkeisyukbn(C_SyuShrgkSyoukeiKbn.W);

            khShrRireki.setSyushrgkkei(uiBean.getKaiyakuhr());

            khShrRireki.setMikeikap(uiBean.getGaikamikeikap());

            khShrRireki.setShrtuukashrgkgoukei(shrtuukashrgkgoukei);

            khShrRireki.setShrtuukasyushrgkkei(shrtuukasyushrgkkei);

            khShrRireki.setShrtuukagstszeigk(shrtuukagstszeigk);

            khShrRireki.setShrtuukashrtienrsk(shrtuukashrtienrsk);

            khShrRireki.setYenshrgkgoukei(yenshrgkgoukei);

            khShrRireki.setYensyushrgkkei(yenSyushrgkkei);

            if (C_UmuKbn.ARI.eq(uiBean.getZeiseitkkktkykhukaumu())) {
                khShrRireki.setYenkansanhaitoukin(uiBean.getAzukarihaitoukin());
                khShrRireki.setYenmikeikap(uiBean.getAzukarip());
            }
            else {
                khShrRireki.setYenkansanhaitoukin(uiBean.getYenkahaitoukin());
                khShrRireki.setYenmikeikap(uiBean.getYenkamikeikap());
            }

            khShrRireki.setYengstszeigk(uiBean.getZeimugstszeigk());

            khShrRireki.setYengstszeigknationaltax(yengstszeigknationaltax);

            khShrRireki.setYengstszeigklocaltax(yengstszeigklocaltax);

            khShrRireki.setNztodouhukencd(nztodouhukencd);

            khShrRireki.setYenshrtienrsk(yenshrtienrsk);

            khShrRireki.setYenhtykeihi(uiBean.getHtykeihi());

            khShrRireki.setShrtuukasyu(uiBean.getShrtuukasyu());

            khShrRireki.setYenkztgk(uiBean.getGststaisyousaeki());

            khShrRireki.setShrkwsratekjnymd(uiBean.getYenshrratetekiymd());

            khShrRireki.setShrkwsrate(uiBean.getYenshrrate());

            khShrRireki.setZeimukwsratekjnymd(uiBean.getZeimukwsratekjnymd());

            khShrRireki.setZeimukwsrate(uiBean.getZeimukwsrate());

            khShrRireki.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());

            khShrRireki.setShrhousiteikbn(uiBean.getShrhouSiteiKbn());

            khShrRireki.setKzsyuruikbn(uiBean.getKzsyuruikbn());

            khShrRireki.setBankcd(uiBean.getBankcd());

            khShrRireki.setSitencd(uiBean.getSitencd());

            khShrRireki.setYokinkbn(uiBean.getYokinkbn());

            khShrRireki.setKouzano(uiBean.getKouzano());

            khShrRireki.setKzdoukbn(uiBean.getKzdoukbn());

            khShrRireki.setKzmeiginmkn(uiBean.getKzmeiginmkn());

            khShrRireki.setKykmnmeigibangou(uiBean.getKykmnmeigibangou());

            khShrRireki.setUktmnmeigibangou(uiBean.getKykmnmeigibangou());

            khShrRireki.setShrtysysyuruikbn(uiBean.getShrTysySyuruiKbn());

            khShrRireki.setYenshrkykhtykeihi(uiBean.getYenshrkykhtykeihi());

            khShrRireki.setKykhnkkaisuu(uiBean.getKykHnkKaisuu());

            khShrRireki.setZennomikeikap(uiBean.getGaikazennouseisankgk());

            if (C_UmuKbn.ARI.eq(uiBean.getZeiseitkkktkykhukaumu())) {
                khShrRireki.setYenzennomikeikap(uiBean.getAzukarizennouseisankgk());
                khShrRireki.setZitkazukarikingksiteituuka(uiBean.getAzukarigoukeigk());
                khShrRireki.setZitkazukarikingkyen(uiBean.getAzukarijpygoukeigk());
                khShrRireki.setYensonotahaitoukin(uiBean.getAzukartkbtihaitoukin());
                khShrRireki.setZeitekiazukarikinkjumu(C_UmuKbn.ARI);
            }
            else {
                khShrRireki.setYenzennomikeikap(uiBean.getYenkazennouseisankgk());
                khShrRireki.setYensonotahaitoukin(uiBean.getYentkbthaitoukin());
                khShrRireki.setZeitekiazukarikinkjumu(C_UmuKbn.NONE);
            }

            khShrRireki.setGaikashrkwsratekjnymd(uiBean.getSntshrgkssgikshrratetekiymd());

            khShrRireki.setGaikashrkwsrate(uiBean.getSntshrgkssgikshrrate());

            khShrRireki.setKaiyakuhrkngkkeisiteituuka(uiBean.getKaiyakuhrkngkkeisiteituuka());

            khShrRireki.setShrtuukakaiyakuhrkngkkei(shrtuukakaiyakuhrkngkkei);

            khShrRireki.setKaiyakuhrkngkkeiyen(kaiyakuhrkngkkeiyen);

            khShrRireki.setSonotashrkngksiteituuka(sonotashrkngksiteituuka);

            khShrRireki.setShrtuukasonotashrkngk(shrtuukasonotashrkngk);

            khShrRireki.setSonotashrkngkyen(uiBean.getSntshrgkssyensonotashrgk());

            khShrRireki.setYensynykngk(uiBean.getSynykngk());

            khShrRireki.setShrtysykurikosiyouhi(C_YouhiKbn.HUYOU);

            khShrRireki.setGyoumuKousinKinou(kinouId);

            khShrRireki.setGyoumuKousinsyaId(sousasyaCd);

            khShrRireki.setGyoumuKousinTime(systemTime);

            BizPropertyInitializer.initialize(khShrRireki);

            if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) {

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyusyukyktuukasyu());

                IT_KykSyouhn kykSyouhn = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(),C_SyutkKbn.SYU).get(0);

                CommonSiwakeUtil commonSiwakeUtil = SWAKInjector.getInstance(CommonSiwakeUtil.class);

                commonSiwakeUtil.execPKanjokamokuHantei(uiBean.getShrymd(), kykSyouhn.getKykymd(),
                    uiBean.getZennouseisankgk(), uiBean.getRyosyuymd(),
                    pKhozenCommonParam.getAnsyuuKihon(uiBean.getSyono()).getJkipjytym(),
                    uiBean.getMikeikaP(), uiBean.getMikeikaPjyutouYm(), uiBean.getMiKeikaPBeans(),
                    pKhozenCommonParam.getFunctionId(), C_SyoriKbn.BLNK, uiBean.getVhrkihrkkaisuu(),
                    uiBean.getVhrkitikiktbrijk());

                List<TaisyouGkBean> taisyouGkBeanList = new ArrayList<>();

                if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {

                    TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean3 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean4 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean5 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean6 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean7 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean8 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean9 = SWAKInjector.getInstance(TaisyouGkBean.class);

                    taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);
                    taisyouGkBean1.setTaisyouGk(uiBean.getKaiyakuhr());
                    taisyouGkBean1.setKeiyakutuukaGk(uiBean.getKaiyakuhr());

                    taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
                    taisyouGkBean2.setTaisyouGk(doKingakuHenkan(khShrRireki.getShrtuukashrtienrsk()));
                    taisyouGkBean2.setKeiyakutuukaGk(doKingakuHenkan(khShrRireki.getShrtuukashrtienrsk()));

                    taisyouGkBean3.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);

                    if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                        taisyouGkBean3.setTaisyouGk(uiBean.getYendthnkgstszeigk());
                        taisyouGkBean3.setKeiyakutuukaGk(uiBean.getYendthnkgstszeigk());
                    }
                    else {
                        taisyouGkBean3.setTaisyouGk(uiBean.getGsTsZeigk());
                        taisyouGkBean3.setKeiyakutuukaGk(uiBean.getGsTsZeigk());
                    }

                    taisyouGkBean4.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
                    if(C_Tuukasyu.JPY.equals(uiBean.getVhsyusyukyktuukasyu())){
                        taisyouGkBean4.setTaisyouGk(uiBean.getYendthnkshrgkgoukeikakunin());
                        taisyouGkBean4.setKeiyakutuukaGk(uiBean.getYendthnkshrgkgoukeikakunin());
                    }else{
                        taisyouGkBean4.setTaisyouGk(uiBean.getShrgkgoukeikakunin());
                        taisyouGkBean4.setKeiyakutuukaGk(uiBean.getShrgkgoukeikakunin());
                    }

                    taisyouGkBean5.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);
                    taisyouGkBean5.setTaisyouGk(uiBean.getYenkahaitoukin().add(uiBean.getYentkbthaitoukin()));
                    taisyouGkBean5.setKeiyakutuukaGk(BizCurrency.valueOf(0, syuCurrencyType));

                    taisyouGkBean6.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
                    taisyouGkBean6.setTaisyouGk(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip());
                    taisyouGkBean6.setKeiyakutuukaGk(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip());

                    taisyouGkBean7.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
                    taisyouGkBean7.setTaisyouGk(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup());
                    taisyouGkBean7.setKeiyakutuukaGk(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup());

                    taisyouGkBean8.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
                    taisyouGkBean8.setTaisyouGk(commonSiwakeUtil.getTaisyouGkJinendoikoup());
                    taisyouGkBean8.setKeiyakutuukaGk(commonSiwakeUtil.getTaisyouGkJinendoikoup());

                    taisyouGkBean9.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
                    taisyouGkBean9.setTaisyouGk(commonSiwakeUtil.getTaisyouGkSonotahenreikin());
                    taisyouGkBean9.setKeiyakutuukaGk(commonSiwakeUtil.getTaisyouGkSonotahenreikin());

                    taisyouGkBeanList.add(taisyouGkBean1);
                    taisyouGkBeanList.add(taisyouGkBean2);
                    taisyouGkBeanList.add(taisyouGkBean3);
                    taisyouGkBeanList.add(taisyouGkBean4);
                    taisyouGkBeanList.add(taisyouGkBean5);
                    taisyouGkBeanList.add(taisyouGkBean6);
                    taisyouGkBeanList.add(taisyouGkBean7);
                    taisyouGkBeanList.add(taisyouGkBean8);
                    taisyouGkBeanList.add(taisyouGkBean9);
                }
                else {

                    BizCurrency yenTaisyouGkSyonendosyokaip = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    BizCurrency yenTaisyouGkSyonendo2kaimeikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    BizCurrency yenTaisyouGkJinendoikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    BizCurrency yenTaisyouGkSonotahenreikin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    BizCurrency keiyakutuukaGkSyonendosyokaip = BizCurrency.valueOf(0, syuCurrencyType);
                    BizCurrency keiyakutuukaGkSyonendo2kaimeikoup = BizCurrency.valueOf(0, syuCurrencyType);
                    BizCurrency keiyakutuukaGkJinendoikoup = BizCurrency.valueOf(0, syuCurrencyType);
                    BizCurrency keiyakutuukaGkSonotahenreikin = BizCurrency.valueOf(0, syuCurrencyType);

                    if (C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI.eq(uiBean.getHijynbrKanritukaHantKbn())) {
                        yenTaisyouGkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                        yenTaisyouGkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                        yenTaisyouGkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                        yenTaisyouGkSonotahenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin();
                    }
                    else {
                        keiyakutuukaGkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                        keiyakutuukaGkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                        keiyakutuukaGkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                        keiyakutuukaGkSonotahenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin();

                        if (keiyakutuukaGkSyonendosyokaip.compareTo(BizCurrency.valueOf(0,
                            keiyakutuukaGkSyonendosyokaip.getType())) > 0) {
                            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                            yenTaisyouGkSyonendosyokaip = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                keiyakutuukaGkSyonendosyokaip, uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                        }

                        if (keiyakutuukaGkSyonendo2kaimeikoup.compareTo(BizCurrency.valueOf(0,
                            keiyakutuukaGkSyonendo2kaimeikoup.getType())) > 0) {
                            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                            yenTaisyouGkSyonendo2kaimeikoup = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                keiyakutuukaGkSyonendo2kaimeikoup, uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                        }

                        if (keiyakutuukaGkJinendoikoup.compareTo(BizCurrency.valueOf(0,
                            keiyakutuukaGkJinendoikoup.getType())) > 0) {
                            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                            yenTaisyouGkJinendoikoup = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                keiyakutuukaGkJinendoikoup, uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                        }

                        if (keiyakutuukaGkSonotahenreikin.compareTo(BizCurrency.valueOf(0,
                            keiyakutuukaGkSonotahenreikin.getType())) > 0) {
                            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                            yenTaisyouGkSonotahenreikin = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                keiyakutuukaGkSonotahenreikin, uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                        }
                    }

                    TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean3 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean4 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean5 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean6 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean7 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean8 = SWAKInjector.getInstance(TaisyouGkBean.class);
                    TaisyouGkBean taisyouGkBean9 = SWAKInjector.getInstance(TaisyouGkBean.class);

                    taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);
                    taisyouGkBean1.setTaisyouGk(uiBean.getJpykaiyakuhr());
                    taisyouGkBean1.setKeiyakutuukaGk(uiBean.getKaiyakuhr());

                    taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
                    taisyouGkBean2.setTaisyouGk(doKingakuHenkan(khShrRireki.getShrtuukashrtienrsk()));

                    taisyouGkBean3.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
                    taisyouGkBean3.setTaisyouGk(uiBean.getJpyGsTszeigk());
                    taisyouGkBean3.setKeiyakutuukaGk(uiBean.getGsTsZeigk());

                    taisyouGkBean4.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
                    taisyouGkBean4.setTaisyouGk(uiBean.getJpyshrgkgoukeikakunin());
                    taisyouGkBean4.setKeiyakutuukaGk(uiBean.getShrgkgoukeikakunin());

                    taisyouGkBean5.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);
                    taisyouGkBean5.setTaisyouGk(uiBean.getYenkahaitoukin().add(uiBean.getYentkbthaitoukin()));
                    taisyouGkBean5.setKeiyakutuukaGk(BizCurrency.valueOf(0,syuCurrencyType));

                    taisyouGkBean6.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
                    taisyouGkBean6.setTaisyouGk(yenTaisyouGkSyonendosyokaip);
                    taisyouGkBean6.setKeiyakutuukaGk(keiyakutuukaGkSyonendosyokaip);

                    taisyouGkBean7.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
                    taisyouGkBean7.setTaisyouGk(yenTaisyouGkSyonendo2kaimeikoup);
                    taisyouGkBean7.setKeiyakutuukaGk(keiyakutuukaGkSyonendo2kaimeikoup);

                    taisyouGkBean8.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
                    taisyouGkBean8.setTaisyouGk(yenTaisyouGkJinendoikoup);
                    taisyouGkBean8.setKeiyakutuukaGk(keiyakutuukaGkJinendoikoup);

                    taisyouGkBean9.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
                    taisyouGkBean9.setTaisyouGk(yenTaisyouGkSonotahenreikin);
                    taisyouGkBean9.setKeiyakutuukaGk(keiyakutuukaGkSonotahenreikin);

                    taisyouGkBeanList.add(taisyouGkBean1);
                    taisyouGkBeanList.add(taisyouGkBean2);
                    taisyouGkBeanList.add(taisyouGkBean3);
                    taisyouGkBeanList.add(taisyouGkBean4);
                    taisyouGkBeanList.add(taisyouGkBean5);
                    taisyouGkBeanList.add(taisyouGkBean6);
                    taisyouGkBeanList.add(taisyouGkBean7);
                    taisyouGkBeanList.add(taisyouGkBean8);
                    taisyouGkBeanList.add(taisyouGkBean9);
                }

                CommonSiwakeInBean commonSiwakeInBean = SWAKInjector.getInstance(CommonSiwakeInBean.class);

                BizCurrency gensengk;

                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    gensengk = uiBean.getJpyGsTszeigk();
                }
                else {
                    gensengk = uiBean.getGsTsZeigk();
                }

                commonSiwakeInBean.setKinouId(kinouId);
                commonSiwakeInBean.setDenYmd(uiBean.getShrymd());
                commonSiwakeInBean.setTuukasyu(uiBean.getShrtuukasyu());
                commonSiwakeInBean.setSyoriYmd(systemYmd);
                commonSiwakeInBean.setKykYmd(uiBean.getVhsyusyukykymd());
                commonSiwakeInBean.setSyouhnCd(uiBean.getSyusyouhncd());
                commonSiwakeInBean.setSyouhnsdNo(uiBean.getSyusyouhnsdno());
                commonSiwakeInBean.setShrhousiteiKbn(uiBean.getShrhouSiteiKbn());
                commonSiwakeInBean.setKyktuukaSyu(uiBean.getVhsyusyukyktuukasyu());
                commonSiwakeInBean.setTuukasyuKansanKawaserate(uiBean.getYenshrrate());
                if (gensengk.compareTo(BizCurrency.valueOf(0, gensengk.getType())) > 0) {
                    commonSiwakeInBean.setGstszeigkUmuKbn(C_UmuKbn.ARI);
                }
                else {
                    commonSiwakeInBean.setGstszeigkUmuKbn(C_UmuKbn.NONE);
                }
                commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
                commonSiwakeInBean.setHijynbrKanritukaHantKbn(uiBean.getHijynbrKanritukaHantKbn());
                commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanList);

                CommonSiwake commonSiwake = SWAKInjector.getInstance(CommonSiwake.class);
                CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

                List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = Lists.newArrayList();

                if (!C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {
                    commonSiwakeUtil = SWAKInjector.getInstance(CommonSiwakeUtil.class);
                    bzSiwakeMeisaiBeanLst = commonSiwakeUtil.execTaisyakuTyousei(commonSiwakeOutBean.getTuukasyu(),
                        commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());
                }
                else {
                    bzSiwakeMeisaiBeanLst = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
                }

                String tmSosikiCd = pKhozenCommonParam.getTmSosikiCd();

                BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);

                BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);

                bzDenpyouDataTourokuBean.setIbKyktuukasyu(uiBean.getVhsyusyukyktuukasyu());

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

                bzDenpyouDataTourokuBean.setIbSyorisosikicd(tmSosikiCd);

                bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(sousasyaCd);

                bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(true);

                bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(uiBean.getSyoruiukeymd());

                bzDenpyouDataTourokuBean.setIbShrhousiteiKbn(uiBean.getShrhouSiteiKbn());

                bzDenpyouDataTourokuBean.setIbSyouhncd(kykSyouhn.getSyouhncd());

                bzDenpyouDataTourokuBean.setIbSyouhnsdno(kykSyouhn.getSyouhnsdno());

                bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(bzSiwakeMeisaiBeanLst);

                if (!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu()) &&
                    C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {
                    bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(true);

                    bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(uiBean.getSyoruiukeymd());
                }
                else {
                    bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);

                    bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(null);
                }

                khDenpyoDataList = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);

                int fbEdaBanngou = bzDenpyouDataSks.getEdano();

                for (IT_KhDenpyoData khDenpyoData : khDenpyoDataList) {

                    hozenDomManager.insert(khDenpyoData);
                }

                uiBean.setFbSoukinEdaNo(fbEdaBanngou);

                uiBean.setSosikiCd(tmSosikiCd);

                uiBean.setDenrenNo(khDenpyoDataList.get(0).getDenrenno());

                uiBean.setCommonSiwakeOutBean(commonSiwakeOutBean);

                khShrRireki.setDenrenno(khDenpyoDataList.get(0).getDenrenno());


                if (uiBean.getSyuKaiyakuHr().compareTo(BizCurrency.valueOf(0, uiBean.getSyuKaiyakuHr().getType())) > 0) {

                    IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

                    khShrRirekiDetail.setSyouhncd(uiBean.getSyusyouhncd());

                    khShrRirekiDetail.setSyouhnsdno(uiBean.getSyusyouhnsdno());

                    khShrRirekiDetail.setKyksyouhnrenno(uiBean.getSyukyksyouhnrenno());

                    khShrRirekiDetail.setSyushrgk(uiBean.getSyuKaiyakuHr());

                    khShrRirekiDetail.setShrtstmttkin(uiBean.getShrTsTmttkin());

                    khShrRirekiDetail.setSjkkktyouseigk(uiBean.getSjkkktyouseigk());

                    khShrRirekiDetail.setKaiyakusjkkktyouseiritu(uiBean.getSjkkktyouseirt());

                    khShrRirekiDetail.setKaiyakusjkkktyouseiriritu(uiBean.getKaiyakuSjkkkTyouseiriRitu());

                    khShrRirekiDetail.setKaiyakukjgk(uiBean.getKaiyakuKjgk());

                    khShrRirekiDetail.setKaiyakukoujyoritu(uiBean.getKaiyakuKoujyoritu());

                    khShrRirekiDetail.setTeiritutmttkngk(uiBean.getTeirituTmttkngk());

                    khShrRirekiDetail.setSisuurendoutmttkngk(uiBean.getSisuuRendouTmttkngk());

                    khShrRirekiDetail.setGyoumuKousinKinou(kinouId);

                    khShrRirekiDetail.setGyoumuKousinsyaId(sousasyaCd);

                    khShrRirekiDetail.setGyoumuKousinTime(systemTime);

                    BizPropertyInitializer.initialize(khShrRirekiDetail);
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd1())) {

                    if (uiBean.getDispTkKaiyakuHr1().compareTo(BizCurrency.valueOf(0, uiBean.getDispTkKaiyakuHr1().getType())) > 0) {

                        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

                        khShrRirekiDetail.setSyouhncd(uiBean.getVhsyudisptksyouhncd1());

                        khShrRirekiDetail.setSyouhnsdno(uiBean.getTksyouhnsdno1());

                        khShrRirekiDetail.setKyksyouhnrenno(uiBean.getTkkyksyouhnrenno1());

                        khShrRirekiDetail.setSyushrgk(uiBean.getDispTkKaiyakuHr1());

                        khShrRirekiDetail.setGyoumuKousinKinou(kinouId);

                        khShrRirekiDetail.setGyoumuKousinsyaId(sousasyaCd);

                        khShrRirekiDetail.setGyoumuKousinTime(systemTime);

                        BizPropertyInitializer.initialize(khShrRirekiDetail);
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd2())) {

                    if (uiBean.getDispTkKaiyakuHr2().compareTo(BizCurrency.valueOf(0, uiBean.getDispTkKaiyakuHr2().getType())) > 0) {

                        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

                        khShrRirekiDetail.setSyouhncd(uiBean.getVhsyudisptksyouhncd2());

                        khShrRirekiDetail.setSyouhnsdno(uiBean.getTksyouhnsdno2());

                        khShrRirekiDetail.setKyksyouhnrenno(uiBean.getTkkyksyouhnrenno2());

                        khShrRirekiDetail.setSyushrgk(uiBean.getDispTkKaiyakuHr2());

                        khShrRirekiDetail.setGyoumuKousinKinou(kinouId);

                        khShrRirekiDetail.setGyoumuKousinsyaId(sousasyaCd);

                        khShrRirekiDetail.setGyoumuKousinTime(systemTime);

                        BizPropertyInitializer.initialize(khShrRirekiDetail);
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd3())) {

                    if (uiBean.getDispTkKaiyakuHr3().compareTo(BizCurrency.valueOf(0, uiBean.getDispTkKaiyakuHr3().getType())) > 0) {

                        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

                        khShrRirekiDetail.setSyouhncd(uiBean.getVhsyudisptksyouhncd3());

                        khShrRirekiDetail.setSyouhnsdno(uiBean.getTksyouhnsdno3());

                        khShrRirekiDetail.setKyksyouhnrenno(uiBean.getTkkyksyouhnrenno3());

                        khShrRirekiDetail.setSyushrgk(uiBean.getDispTkKaiyakuHr3());

                        khShrRirekiDetail.setGyoumuKousinKinou(kinouId);

                        khShrRirekiDetail.setGyoumuKousinsyaId(sousasyaCd);

                        khShrRirekiDetail.setGyoumuKousinTime(systemTime);

                        BizPropertyInitializer.initialize(khShrRirekiDetail);
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd4())) {

                    if (uiBean.getDispTkKaiyakuHr4().compareTo(BizCurrency.valueOf(0, uiBean.getDispTkKaiyakuHr4().getType())) > 0) {

                        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

                        khShrRirekiDetail.setSyouhncd(uiBean.getVhsyudisptksyouhncd4());

                        khShrRirekiDetail.setSyouhnsdno(uiBean.getTksyouhnsdno4());

                        khShrRirekiDetail.setKyksyouhnrenno(uiBean.getTkkyksyouhnrenno4());

                        khShrRirekiDetail.setSyushrgk(uiBean.getDispTkKaiyakuHr4());

                        khShrRirekiDetail.setGyoumuKousinKinou(kinouId);

                        khShrRirekiDetail.setGyoumuKousinsyaId(sousasyaCd);

                        khShrRirekiDetail.setGyoumuKousinTime(systemTime);

                        BizPropertyInitializer.initialize(khShrRirekiDetail);
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd5())) {

                    if (uiBean.getDispTkKaiyakuHr5().compareTo(BizCurrency.valueOf(0, uiBean.getDispTkKaiyakuHr5().getType())) > 0) {

                        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

                        khShrRirekiDetail.setSyouhncd(uiBean.getVhsyudisptksyouhncd5());

                        khShrRirekiDetail.setSyouhnsdno(uiBean.getTksyouhnsdno5());

                        khShrRirekiDetail.setKyksyouhnrenno(uiBean.getTkkyksyouhnrenno5());

                        khShrRirekiDetail.setSyushrgk(uiBean.getDispTkKaiyakuHr5());

                        khShrRirekiDetail.setGyoumuKousinKinou(kinouId);

                        khShrRirekiDetail.setGyoumuKousinsyaId(sousasyaCd);

                        khShrRirekiDetail.setGyoumuKousinTime(systemTime);

                        BizPropertyInitializer.initialize(khShrRirekiDetail);
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd6())) {

                    if (uiBean.getDispTkKaiyakuHr6().compareTo(BizCurrency.valueOf(0, uiBean.getDispTkKaiyakuHr6().getType())) > 0) {

                        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

                        khShrRirekiDetail.setSyouhncd(uiBean.getVhsyudisptksyouhncd6());

                        khShrRirekiDetail.setSyouhnsdno(uiBean.getTksyouhnsdno6());

                        khShrRirekiDetail.setKyksyouhnrenno(uiBean.getTkkyksyouhnrenno6());

                        khShrRirekiDetail.setSyushrgk(uiBean.getDispTkKaiyakuHr6());

                        khShrRirekiDetail.setGyoumuKousinKinou(kinouId);

                        khShrRirekiDetail.setGyoumuKousinsyaId(sousasyaCd);

                        khShrRirekiDetail.setGyoumuKousinTime(systemTime);

                        BizPropertyInitializer.initialize(khShrRirekiDetail);
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd7())) {

                    if (uiBean.getDispTkKaiyakuHr7().compareTo(BizCurrency.valueOf(0, uiBean.getDispTkKaiyakuHr7().getType())) > 0) {

                        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

                        khShrRirekiDetail.setSyouhncd(uiBean.getVhsyudisptksyouhncd7());

                        khShrRirekiDetail.setSyouhnsdno(uiBean.getTksyouhnsdno7());

                        khShrRirekiDetail.setKyksyouhnrenno(uiBean.getTkkyksyouhnrenno7());

                        khShrRirekiDetail.setSyushrgk(uiBean.getDispTkKaiyakuHr7());

                        khShrRirekiDetail.setGyoumuKousinKinou(kinouId);

                        khShrRirekiDetail.setGyoumuKousinsyaId(sousasyaCd);

                        khShrRirekiDetail.setGyoumuKousinTime(systemTime);

                        BizPropertyInitializer.initialize(khShrRirekiDetail);
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd8())) {

                    if (uiBean.getDispTkKaiyakuHr8().compareTo(BizCurrency.valueOf(0, uiBean.getDispTkKaiyakuHr8().getType())) > 0) {

                        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

                        khShrRirekiDetail.setSyouhncd(uiBean.getVhsyudisptksyouhncd8());

                        khShrRirekiDetail.setSyouhnsdno(uiBean.getTksyouhnsdno8());

                        khShrRirekiDetail.setKyksyouhnrenno(uiBean.getTkkyksyouhnrenno8());

                        khShrRirekiDetail.setSyushrgk(uiBean.getDispTkKaiyakuHr8());

                        khShrRirekiDetail.setGyoumuKousinKinou(kinouId);

                        khShrRirekiDetail.setGyoumuKousinsyaId(sousasyaCd);

                        khShrRirekiDetail.setGyoumuKousinTime(systemTime);

                        BizPropertyInitializer.initialize(khShrRirekiDetail);
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd9())) {

                    if (uiBean.getDispTkKaiyakuHr9().compareTo(BizCurrency.valueOf(0, uiBean.getDispTkKaiyakuHr9().getType())) > 0) {

                        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

                        khShrRirekiDetail.setSyouhncd(uiBean.getVhsyudisptksyouhncd9());

                        khShrRirekiDetail.setSyouhnsdno(uiBean.getTksyouhnsdno9());

                        khShrRirekiDetail.setKyksyouhnrenno(uiBean.getTkkyksyouhnrenno9());

                        khShrRirekiDetail.setSyushrgk(uiBean.getDispTkKaiyakuHr9());

                        khShrRirekiDetail.setGyoumuKousinKinou(kinouId);

                        khShrRirekiDetail.setGyoumuKousinsyaId(sousasyaCd);

                        khShrRirekiDetail.setGyoumuKousinTime(systemTime);

                        BizPropertyInitializer.initialize(khShrRirekiDetail);
                    }
                }

                if (!BizUtil.isBlank(uiBean.getVhsyudisptksyouhncd10())) {

                    if (uiBean.getDispTkKaiyakuHr10().compareTo(BizCurrency.valueOf(0, uiBean.getDispTkKaiyakuHr10().getType())) > 0) {

                        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

                        khShrRirekiDetail.setSyouhncd(uiBean.getVhsyudisptksyouhncd10());

                        khShrRirekiDetail.setSyouhnsdno(uiBean.getTksyouhnsdno10());

                        khShrRirekiDetail.setKyksyouhnrenno(uiBean.getTkkyksyouhnrenno10());

                        khShrRirekiDetail.setSyushrgk(uiBean.getDispTkKaiyakuHr10());

                        khShrRirekiDetail.setGyoumuKousinKinou(kinouId);

                        khShrRirekiDetail.setGyoumuKousinsyaId(sousasyaCd);

                        khShrRirekiDetail.setGyoumuKousinTime(systemTime);

                        BizPropertyInitializer.initialize(khShrRirekiDetail);
                    }
                }
            }
        }

        return khDenpyoDataList;
    }

    private void insertKTKihrkpSeisanRrk() {

        BizDateYM jyuutouym;

        int seijyutoukaisuum;

        C_MisyuumikeikaKbn misyuumikeikakbn;

        BizCurrency seisanpgoukei;

        BizDate zeimukwsratekjnymd;

        BizNumber zeimukwsrate;

        BizCurrency henkank;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyusyukyktuukasyu());

        jyuutouym = null;

        seijyutoukaisuum = 0;

        misyuumikeikakbn = C_MisyuumikeikaKbn.BLNK;

        seisanpgoukei = BizCurrency.valueOf(0, syuCurrencyType);

        zeimukwsratekjnymd = null;

        zeimukwsrate = null;

        henkank = BizCurrency.valueOf(0, syuCurrencyType);

        Integer maxSeqNo = hozenDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono(uiBean.getSyono());

        if (maxSeqNo != null) {

            maxSeqNo = maxSeqNo + 1;
        }
        else {

            maxSeqNo = 1;
        }

        if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {

            zeimukwsratekjnymd = uiBean.getYenshrratetekiymd();

            zeimukwsrate = uiBean.getYenshrrate();
        }
        else {

            zeimukwsratekjnymd = uiBean.getZeimukwsratekjnymd();

            zeimukwsrate = uiBean.getZeimukwsrate();
        }

        if (uiBean.getKihrkpssrrkyenkansanhenkankin().compareTo(BizCurrency.valueOf(0, uiBean.getHtykeihi().getType())) > 0) {
            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = uiBean.getKykKihon().createKihrkmpSeisanRireki();

            kihrkmpSeisanRireki.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());

            kihrkmpSeisanRireki.setRenno(maxSeqNo);

            kihrkmpSeisanRireki.setHenkousikibetukey(henkousikibetuKey);

            kihrkmpSeisanRireki.setKihrkpssnaiyoukbn(C_KiharaiPseisanNaiyouKbn.HENKANKIN);

            kihrkmpSeisanRireki.setJyuutouym(jyuutouym);

            kihrkmpSeisanRireki.setSeijyutoukaisuum(seijyutoukaisuum);

            kihrkmpSeisanRireki.setMisyuumikeikakbn(misyuumikeikakbn);

            kihrkmpSeisanRireki.setSeisanpgoukei(seisanpgoukei);

            kihrkmpSeisanRireki.setHenkank(henkank);

            kihrkmpSeisanRireki.setYenkansanhenkankin(uiBean.getKihrkpssrrkyenkansanhenkankin());

            kihrkmpSeisanRireki.setZeimukwsratekjnymd(zeimukwsratekjnymd);

            kihrkmpSeisanRireki.setZeimukwsrate(zeimukwsrate);

            kihrkmpSeisanRireki.setHituyoukeihiitijisytktysgk(uiBean.getHituyoukeihiitijisytktysgk());

            kihrkmpSeisanRireki.setGyoumuKousinKinou(kinouId);

            kihrkmpSeisanRireki.setGyoumuKousinsyaId(sousasyaCd);

            kihrkmpSeisanRireki.setGyoumuKousinTime(systemTime);

            maxSeqNo++;

            BizPropertyInitializer.initialize(kihrkmpSeisanRireki);
        }

        if (uiBean.getMikeikaP().compareTo(BizCurrency.valueOf(0, uiBean.getMikeikaP().getType())) > 0 ||
            uiBean.getZennouseisankgk().compareTo(BizCurrency.valueOf(0, uiBean.getZennouseisankgk().getType())) > 0) {
            Integer kihrkmpSeisanRirekiRenno = maxSeqNo;

            IT_KihrkmpSeisanRireki newKihrkmpSeisanRireki = uiBean.getKykKihon().createKihrkmpSeisanRireki();
            newKihrkmpSeisanRireki.setRenno(kihrkmpSeisanRirekiRenno);
            newKihrkmpSeisanRireki.setHenkousikibetukey(henkousikibetuKey);
            newKihrkmpSeisanRireki.setKouryokuhasseiymd(uiBean.getKouryokuHasseiYmd());
            newKihrkmpSeisanRireki.setKihrkpssnaiyoukbn(C_KiharaiPseisanNaiyouKbn.SEISANP);
            newKihrkmpSeisanRireki.setJyuutouym(uiBean.getMikeikaPjyutouYm());
            newKihrkmpSeisanRireki.setSeijyutoukaisuum(uiBean.getMikeikaPJyutouKaisuuM());
            newKihrkmpSeisanRireki.setSeijyutoukaisuuy(uiBean.getMikeikaPJyutouKaisuuY());
            newKihrkmpSeisanRireki.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MIKEIKAP);
            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyouhinHanteiKbn()) {
                newKihrkmpSeisanRireki.setRstuukasyu(uiBean.getHrktuukasyu());
            }
            else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyouhinHanteiKbn()) {
                newKihrkmpSeisanRireki.setRstuukasyu(uiBean.getVhsyusyukyktuukasyu());
            }

            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyouhinHanteiKbn() &&
                !C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                newKihrkmpSeisanRireki.setSeisanpgoukei(uiBean.getGaikamikeikap().add(uiBean.getGaikazennouseisankgk()));
            }
            else {
                newKihrkmpSeisanRireki.setSeisanpgoukei(BizCurrency.valueOf(0));
            }

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyouhinHanteiKbn()) {
                if (C_UmuKbn.NONE.eq(uiBean.getZeiseitkkktkykhukaumu())) {
                    newKihrkmpSeisanRireki.setYenkansansspgoukei(uiBean.getMikeikaP().add(uiBean.getZennouseisankgk()));
                }
                else {
                    newKihrkmpSeisanRireki.setYenkansansspgoukei(BizCurrency.valueOf(0));
                }
            }
            else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyouhinHanteiKbn()) {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu()) ||
                    C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                    newKihrkmpSeisanRireki.setYenkansansspgoukei(uiBean.getHtykeihi().subtract(uiBean.getJpykaiyakuhr()));
                }
                else {

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    newKihrkmpSeisanRireki.setYenkansansspgoukei(uiBean.getHtykeihi().subtract(keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        uiBean.getKaiyakuhr(),
                        uiBean.getZeimukwsrate(),
                        C_HasuusyoriKbn.SUTE)
                        ));
                }
            }

            newKihrkmpSeisanRireki.setHenkank(BizCurrency.valueOf(0));
            newKihrkmpSeisanRireki.setYenkansanhenkankin(BizCurrency.valueOf(0));

            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyouhinHanteiKbn() &&
                !C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    newKihrkmpSeisanRireki.setZeimukwsratekjnymd(uiBean.getYenshrratetekiymd());
                    newKihrkmpSeisanRireki.setZeimukwsrate(uiBean.getYenshrrate());
                }
                else {
                    newKihrkmpSeisanRireki.setZeimukwsratekjnymd(uiBean.getZeimukwsratekjnymd());
                    newKihrkmpSeisanRireki.setZeimukwsrate(uiBean.getZeimukwsrate());
                }
            }

            newKihrkmpSeisanRireki.setGyoumuKousinKinou(kinouId);
            newKihrkmpSeisanRireki.setGyoumuKousinsyaId(sousasyaCd);
            newKihrkmpSeisanRireki.setGyoumuKousinTime(systemTime);
            newKihrkmpSeisanRireki.setHituyoukeihiitijisytktysgk(BizCurrency.valueOf(0));
            BizPropertyInitializer.initialize(newKihrkmpSeisanRireki);

            uiBean.setRenno(kihrkmpSeisanRirekiRenno);
        }
    }


    private void insertFbSoukinData(List<IT_KhDenpyoData> pKhDenpyoDataList) {

        if (uiBean.getShrgkgoukeisyoukai().compareTo(
            BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) {

            if (C_ShrhousiteiKbn.FB_YOKUJITU.eq(uiBean.getShrhouSiteiKbn()) ||
                C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(uiBean.getShrhouSiteiKbn()) ||
                C_ShrhousiteiKbn.FB_3EIGYOUBI.eq(uiBean.getShrhouSiteiKbn())) {

                if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu()) ||
                    C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {

                    BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);

                    bzFbSoukinDataSksBean.setDenbyouyouDataRenbon(uiBean.getDenrenNo());

                    bzFbSoukinDataSksBean.setEdaNo(uiBean.getFbSoukinEdaNo());

                    bzFbSoukinDataSksBean.setDenSysKbn(uiBean.getCommonSiwakeOutBean().getDensysKbn());

                    bzFbSoukinDataSksBean.setSyoriCd(uiBean.getCommonSiwakeOutBean().getSyoriCd());

                    bzFbSoukinDataSksBean.setSyoriSosikiCd(uiBean.getSosikiCd());

                    bzFbSoukinDataSksBean.setSyoriYmd(uiBean.getCommonSiwakeOutBean().getSyoriYmd());

                    bzFbSoukinDataSksBean.setDenYmd(uiBean.getCommonSiwakeOutBean().getDenyMd());

                    bzFbSoukinDataSksBean.setSyoNo(uiBean.getSyono());

                    bzFbSoukinDataSksBean.setShrHouSiteiKbn(uiBean.getShrhouSiteiKbn());

                    bzFbSoukinDataSksBean.setBankCd(uiBean.getBankcd());

                    bzFbSoukinDataSksBean.setSitenCd(uiBean.getSitencd());

                    bzFbSoukinDataSksBean.setYokinKbn(uiBean.getYokinkbn());

                    bzFbSoukinDataSksBean.setKouzaNo(uiBean.getKouzano());

                    bzFbSoukinDataSksBean.setKzMeigiNmKn(uiBean.getKzmeiginmkn());

                    if (C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                        bzFbSoukinDataSksBean.setSouKingk(uiBean.getYendthnkshrgkgoukeikakunin());
                    }
                    else {
                        bzFbSoukinDataSksBean.setSouKingk(uiBean.getJpyshrgkgoukeikakunin());
                    }

                    bzFbSoukinDataSksBean.setKykTuukasyu(uiBean.getVhsyusyukyktuukasyu());
                    bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
                    bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.ZERO);

                    bzFbSoukinDataSksBean.setKinouId(kinouId);

                    bzFbSoukinDataSksBean.setUserId(sousasyaCd);

                    if (pKhDenpyoDataList.size() > 0) {

                        bzFbSoukinDataSksBean.setDengyoumuCd(pKhDenpyoDataList.get(0).getDengyoumucd());
                    }

                    BzFbSoukinDataSks bzFbSoukinDataSks = SWAKInjector.getInstance(BzFbSoukinDataSks.class);

                    IT_KhFBSoukinData khFBSoukinData = bzFbSoukinDataSks.execKh(bzFbSoukinDataSksBean);

                    hozenDomManager.insert(khFBSoukinData);
                }
                else {

                    String kzmeiginmei = ConvertUtil.toHanAll(uiBean.getKzmeiginmkn(), 0, 0);

                    BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

                    BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(uiBean.getBankcd(), uiBean.getSitencd());

                    BzGkfbSoukinDataSksBean bzGkfbSoukinDataSksBean =
                        SWAKInjector.getInstance(BzGkfbSoukinDataSksBean.class);

                    bzGkfbSoukinDataSksBean.setDenRenno(uiBean.getDenrenNo());

                    bzGkfbSoukinDataSksBean.setEdaNo(uiBean.getFbSoukinEdaNo());

                    bzGkfbSoukinDataSksBean.setDenSysKbn(uiBean.getCommonSiwakeOutBean().getDensysKbn());

                    bzGkfbSoukinDataSksBean.setSyoriCd(uiBean.getCommonSiwakeOutBean().getSyoriCd());

                    bzGkfbSoukinDataSksBean.setSyoriSosikiCd(uiBean.getSosikiCd());

                    bzGkfbSoukinDataSksBean.setSyoriYmd(uiBean.getCommonSiwakeOutBean().getSyoriYmd());

                    bzGkfbSoukinDataSksBean.setDenYmd(uiBean.getCommonSiwakeOutBean().getDenyMd());

                    bzGkfbSoukinDataSksBean.setSyono(uiBean.getSyono());

                    bzGkfbSoukinDataSksBean.setShrHouSiteiKbn(uiBean.getShrhouSiteiKbn());

                    bzGkfbSoukinDataSksBean.setBankCd(uiBean.getBankcd());

                    bzGkfbSoukinDataSksBean.setBankNmEj(bzGetBankDataBean.getBankNmEj());

                    bzGkfbSoukinDataSksBean.setSitenCd(uiBean.getSitencd());

                    bzGkfbSoukinDataSksBean.setSitenNmEj(bzGetBankDataBean.getSitenNmEj());

                    bzGkfbSoukinDataSksBean.setKouzaNo(uiBean.getKouzano());

                    bzGkfbSoukinDataSksBean.setKzMeigiNmEi(kzmeiginmei);

                    bzGkfbSoukinDataSksBean.setShrTuukaSyu(uiBean.getShrtuukasyu());

                    bzGkfbSoukinDataSksBean.setGaikaShrgk(uiBean.getShrgkgoukeikakunin());

                    bzGkfbSoukinDataSksBean.setKykTuukaSyu(uiBean.getVhsyusyukyktuukasyu());

                    bzGkfbSoukinDataSksBean.setCrossRateShrgk(BizCurrency.valueOf(0));

                    bzGkfbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(0));

                    bzGkfbSoukinDataSksBean.setKinouId(kinouId);

                    bzGkfbSoukinDataSksBean.setUserId(sousasyaCd);

                    if (pKhDenpyoDataList.size() > 0) {

                        bzGkfbSoukinDataSksBean.setDengyoumuCd(pKhDenpyoDataList.get(0).getDengyoumucd());
                    }

                    BzGkfbSoukinDataSks bzGkfbSoukinDataSks = SWAKInjector.getInstance(BzGkfbSoukinDataSks.class);

                    IT_KhGaikaFBSoukinData khGaikaFBSoukinData = bzGkfbSoukinDataSks.execKh(bzGkfbSoukinDataSksBean);

                    hozenDomManager.insert(khGaikaFBSoukinData);
                }
            }
        }
    }

    private void updateTumitatekinKanrenData() {

        if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn() ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == uiBean.getSyouhinHanteiKbn()) &&
            !C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {

            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

            BizDate outouymd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN,
                uiBean.getVhsyusyukykymd(),
                C_Hrkkaisuu.NEN,
                uiBean.getSyoruiukeymd());

            BizDateYM syoruiUkeMaeYm = outouymd.getBizDateYM();

            List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList =
                khGengakuDao.getSisuurendoTmttknsBySyonoTmttkntaisyouym(uiBean.getSyono(), syoruiUkeMaeYm);

            IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = khSisuurendoTmttknList.get(0);

            IT_KhSisuurendoTmttkn khSisuurendoTmttkn = uiBean.getKykKihon().createKhSisuurendoTmttkn();

            khSisuurendoTmttkn.setTmttkntaisyouym(khSisuurendoTmttknMae.getTmttkntaisyouym());

            khSisuurendoTmttkn.setRenno(khSisuurendoTmttknMae.getRenno() + 1);

            khSisuurendoTmttkn.setTmttknkouryokukaisiymd(uiBean.getSyoruiukeymd());

            khSisuurendoTmttkn.setTeiritutmttkngk(uiBean.getTeirituTmttkngk());

            khSisuurendoTmttkn.setSisuurendoutmttkngk(uiBean.getSisuuRendouTmttkngk());

            khSisuurendoTmttkn.setSisuuupritu(khSisuurendoTmttknMae.getSisuuupritu());

            khSisuurendoTmttkn.setTmttknzoukaritu(khSisuurendoTmttknMae.getTmttknzoukaritu());

            khSisuurendoTmttkn.setTmttknhaneitmmshanteiymd(khSisuurendoTmttknMae.getTmttknhaneitmmshanteiymd());

            khSisuurendoTmttkn.setTmttknhaneisisuu(khSisuurendoTmttknMae.getTmttknhaneisisuu());

            khSisuurendoTmttkn.setGyoumuKousinKinou(kinouId);

            khSisuurendoTmttkn.setGyoumuKousinsyaId(sousasyaCd);

            khSisuurendoTmttkn.setGyoumuKousinTime(systemTime);

            BizPropertyInitializer.initialize(khSisuurendoTmttkn);

            BizDate outouymd2 = setOutoubi.exec(C_TykzentykgoKbn.TYKGO,
                uiBean.getVhsyusyukykymd(),
                C_Hrkkaisuu.NEN,
                uiBean.getSyoruiukeymd());

            BizDateYM syoruiUkeGoYm = outouymd2.getBizDateYM();

            List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList2 =
                khGengakuDao.getSisuurendoTmttknsBySyonoTmttkntaisyouym(uiBean.getSyono(), syoruiUkeGoYm);

            if (khSisuurendoTmttknList2.size() > 0) {

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyusyukyktuukasyu());

                BizCurrency teiritutmttkngk = BizCurrency.valueOf(0,syuCurrencyType);
                BizCurrency sisuurendoutmttkngk = BizCurrency.valueOf(0,syuCurrencyType);

                IT_KhSisuurendoTmttkn khSisuurendoTmttknGo = khSisuurendoTmttknList2.get(0);

                IT_KykSyouhn syuKykSyouhn = uiBean.getKykKihon().getKykSyouhns().get(0);

                if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(syuKykSyouhn.getTmttknhaibunjyoutai())
                    || C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(syuKykSyouhn.getTmttknhaibunjyoutai())) {

                    KeisanSisuuRendouNkTmttkn keisanSisuuRendouNkTmttkn = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttkn.class);

                    C_ErrorKbn errorKbn1 = keisanSisuuRendouNkTmttkn.exec(syuKykSyouhn.getKykymd(),
                        syuKykSyouhn.getHknkkn(),
                        uiBean.getTeikishrtkykhukaumu(),
                        syuKykSyouhn.getKyktuukasyu(),
                        outouymd2,
                        syoruiUkeGoYm,
                        khSisuurendoTmttknMae.getTmttkntaisyouym(),
                        syuKykSyouhn.getTumitateriritu(),
                        uiBean.getTeirituTmttkngk(),
                        uiBean.getSisuuRendouTmttkngk());

                    if (C_ErrorKbn.ERROR.eq(errorKbn1)) {

                        throw new CommonBizAppException("指数連動年金積立金計算が実行できませんでした。");
                    }

                    teiritutmttkngk =keisanSisuuRendouNkTmttkn.getTeiritutmttkngk();
                }

                if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(syuKykSyouhn.getTmttknhaibunjyoutai())
                    || C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(syuKykSyouhn.getTmttknhaibunjyoutai())) {

                    KeisanTmHntiSisuuRendouTmttkn keisanTmHntiSisuuRendouTmttkn = SWAKInjector.getInstance(KeisanTmHntiSisuuRendouTmttkn.class);

                    C_ErrorKbn errorKbn2 = keisanTmHntiSisuuRendouTmttkn.exec(syuKykSyouhn.getSyouhncd(),
                        syuKykSyouhn.getKyktuukasyu(),
                        khSisuurendoTmttknGo.getTmttknhaneisisuu(),
                        khSisuurendoTmttknMae.getTmttknhaneisisuu(),
                        syuKykSyouhn.getSetteibairitu(),
                        syuKykSyouhn.getTmttknzoukaritujygn(),
                        uiBean.getSisuuRendouTmttkngk(),
                        syuKykSyouhn.getRendouritu());

                    if (C_ErrorKbn.ERROR.eq(errorKbn2)) {
                        throw new CommonBizAppException("積増判定時指数連動積立金計算が実行できませんでした。");
                    }

                    sisuurendoutmttkngk = keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk();
                }

                khSisuurendoTmttknGo.setTeiritutmttkngk(teiritutmttkngk);

                khSisuurendoTmttknGo.setSisuurendoutmttkngk(sisuurendoutmttkngk);

                khSisuurendoTmttknGo.setGyoumuKousinKinou(kinouId);

                khSisuurendoTmttknGo.setGyoumuKousinsyaId(sousasyaCd);

                khSisuurendoTmttknGo.setGyoumuKousinTime(systemTime);
            }
        }
    }

    private void makeTetudukiRireki(KhozenCommonParam pKhozenCommonParam, IT_KykKihon pKykKihon) {

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(pKhozenCommonParam);

        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());

        editTtdkRirekiTblParam.setSyoriYmd(systemYmd);

        editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());

        if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0 ||
            uiBean.getAzukarigoukeigk().compareTo(BizCurrency.valueOf(0, uiBean.getAzukarigoukeigk().getType())) > 0 ||
            uiBean.getAzukarijpygoukeigk().compareTo(BizCurrency.valueOf(0, uiBean.getAzukarijpygoukeigk().getType())) > 0) {

            editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.ARI);
        }

        PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);

        pALKykNaiyouKousin.exec(pKykKihon);

        editTtdkRirekiTblParam.setSysTime(systemTime);

        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

        editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        editTtdkRirekiTblParam.setYoukyuuNo(pALKykNaiyouKousin.getYoukyuuno());

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    private void makeDairitenTesuuryou(KhozenCommonParam pKhozenCommonParam,
        TableMaintenanceUtil pTableMaintenanceUtil) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType syuCurrencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getVhsyusyukyktuukasyu());

        BizDateYM kouryokuhasseiym = uiBean.getKouryokuHasseiYmd().getBizDateYM();

        int nyknkaisuuy = 0;
        int nyknkaisuum = 0;
        BizCurrency mikeikap = BizCurrency.valueOf(0, syuCurrencyType);

        if (uiBean.getMikeikaP().compareTo(BizCurrency.valueOf(0, uiBean.getMikeikaP().getType())) > 0) {
            nyknkaisuuy = uiBean.getMikeikaPJyutouKaisuuY();
            nyknkaisuum = uiBean.getMikeikaPJyutouKaisuuM();
            mikeikap = uiBean.getMikeikaP();
        }

        EditDairitenTesuuryouTbl editDairitenTesuuryouTbl = SWAKInjector.getInstance(EditDairitenTesuuryouTbl.class);

        editDairitenTesuuryouTbl.exec(
            pKhozenCommonParam,
            uiBean.getSyono(),
            C_TsrysyoriKbn.GENGAKU,
            kouryokuhasseiym,
            nyknkaisuuy,
            nyknkaisuum,
            mikeikap,
            BizCurrency.valueOf(0, syuCurrencyType),
            pTableMaintenanceUtil.getBakKykKihon());
    }

    private void updateKTKykSonotaTk(KhozenCommonParam pKhozenCommonParam) {

        IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();

        if (C_KykhnkKbn.KAIYAKU.eq(uiBean.getPmnJtkHnkKbn())) {

            kykSonotaTkyk.setPmnjtkkbn(C_PmnjtkKbn.NONE);

            kykSonotaTkyk.setPmnjtkkykymd(null);

            kykSonotaTkyk.setPmnjtksknnkaisiymd(null);

            kykSonotaTkyk.setPmnjtkgansknnkaisiymd(null);

            kykSonotaTkyk.setPmhktsknnkaisiymd(null);

            kykSonotaTkyk.setPmnjhktgansknnkaisiymd(null);

            kykSonotaTkyk.setPmnjtkhtnpbuicd1("");

            kykSonotaTkyk.setPmnjtkhtnpkkn1(C_Htnpkkn.BLNK);

            kykSonotaTkyk.setPmnjtkhtnpbuicd2("");

            kykSonotaTkyk.setPmnjtkhtnpkkn2(C_Htnpkkn.BLNK);

            kykSonotaTkyk.setPmnjtkhtnpbuicd3("");

            kykSonotaTkyk.setPmnjtkhtnpkkn3(C_Htnpkkn.BLNK);

            kykSonotaTkyk.setPmnjtkhtnpbuicd4("");

            kykSonotaTkyk.setPmnjtkhtnpkkn4(C_Htnpkkn.BLNK);

            kykSonotaTkyk.setPmnjtokkoudosghtnpkbn(C_TokkoudosghtnpKbn.BLNK);

            kykSonotaTkyk.setGyoumuKousinKinou(kinouId);

            kykSonotaTkyk.setGyoumuKousinsyaId(sousasyaCd);

            kykSonotaTkyk.setGyoumuKousinTime(systemTime);
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

            BizNumber torikuzusiWari = uiBean.getSyukihons().divideBizCurrency(uiBean.getVhsyusyukihons(), 10, RoundingMode.HALF_UP);

            BizCurrency initsbjiyenkasaiteihsygk = kykSonotaTkyk.getInitsbjiyenkasaiteihsygk().multiply(torikuzusiWari).toValidValue(RoundingMode.UP);

            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(initsbjiyenkasaiteihsygk);

            kykSonotaTkyk.setGyoumuKousinKinou(kinouId);

            kykSonotaTkyk.setGyoumuKousinsyaId(sousasyaCd);

            kykSonotaTkyk.setGyoumuKousinTime(systemTime);
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {
            BizCurrency targettkykkijyungk = null;

            if(C_TargetTkKbn.SYUUSIN.eq(kykSonotaTkyk.getTargettkkbn())){
                BizNumber torikuzusiWari = uiBean.getSyukihons().divideBizCurrency(uiBean.getVhsyusyukihons(), 10, RoundingMode.HALF_UP);

                targettkykkijyungk = kykSonotaTkyk.getTargettkykkijyungk().multiply(torikuzusiWari).toValidValue(RoundingMode.UP);
            }
            else if(C_TargetTkKbn.NENKIN.eq(kykSonotaTkyk.getTargettkkbn())){

                C_Tkhukaumu yenNyukinTkKbn = C_Tkhukaumu.NONE;

                IT_NyknJissekiRireki nyknJissekiRireki = pKhozenCommonParam.getNyknJissekiRirekiSk(uiBean.getSyono()).get(0);

                KeisanKijyungk keisanKijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);

                keisanKijyungk.exec(nyknJissekiRireki.getRyosyuymd(),
                    nyknJissekiRireki.getRsgaku(), uiBean.getSyup(), uiBean.getVhsyusyukyktuukasyu(), yenNyukinTkKbn);

                targettkykkijyungk = keisanKijyungk.getKijyungk();
            }

            kykSonotaTkyk.setTargettkykkijyungk(targettkykkijyungk);

            kykSonotaTkyk.setGyoumuKousinKinou(kinouId);

            kykSonotaTkyk.setGyoumuKousinsyaId(sousasyaCd);

            kykSonotaTkyk.setGyoumuKousinTime(systemTime);
        }
    }

    private void updateKhDshrTuki(KhozenCommonParam pKhozenCommonParam) {

        SetKhDshrTukiKykInfo setKhDshrTukiKykInfo = SWAKInjector.getInstance(SetKhDshrTukiKykInfo.class);
        SrDshrTukiDataSks srDshrTukiDataSks = SWAKInjector.getInstance(SrDshrTukiDataSks.class);

        EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean = setKhDshrTukiKykInfo.exec(uiBean.getKykKihon(),
            pKhozenCommonParam, uiBean.getShrymd(), systemYmd);
        editDshrTukiTanKoumokuBean.setSiharaid(uiBean.getKariwariatedshrgk());
        editDshrTukiTanKoumokuBean.setHenkousikibetuKey(henkousikibetuKey);

        IT_KhDshrTuki khDshrTuki = srDshrTukiDataSks.execKhKsnAri(editDshrTukiTanKoumokuBean,
            uiBean.getEditDshrTukiDKoumokuBean());

        BizPropertyInitializer.initialize(khDshrTuki);

        hozenDomManager.insert(khDshrTuki);
    }

    private void updateGengakuWK(KhozenCommonParam pKhozenCommonParam) {

        if (C_KhkinouModeIdKbn.SYOUNIN.toString().equals(kinouMode.getKinouMode())) {

            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

                IW_KhGengakuWk khGengakuWk = hozenDomManager.getKhGengakuWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

                hozenDomManager.delete(khGengakuWk);
            }
            else {
                IW_KhGengakuWk khGengakuWk = hozenDomManager.getKhGengakuWk(
                    uiBean.getBzWorkflowInfo().getKouteiKanriId());

                if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
                    khGengakuWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
                }
                khGengakuWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
                khGengakuWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
                khGengakuWk.setGyoumuKousinTime(systemTime);
            }
        }
        else {

            if (C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode())) {

                IW_KhGengakuWk khGengakuWk = new IW_KhGengakuWk();

                if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

                    khGengakuWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
                }

                khGengakuWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                khGengakuWk.setSyono(uiBean.getSyono());
                khGengakuWk.setSkssakuseiymd(systemYmd);
                khGengakuWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
                khGengakuWk.setKykhnkkbn(uiBean.getSyuhnkkbn());
                khGengakuWk.setGengkhoukbn(uiBean.getGengkhoukbn());
                khGengakuWk.setNewkihonhknkngaku(uiBean.getSyukihons());
                khGengakuWk.setNewhrkp(uiBean.getNewhrkp());
                khGengakuWk.setYenshrtkhkumu(uiBean.getYenshrtkumu());
                khGengakuWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());

                if (!C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn()) &&
                    !C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn())) {
                    khGengakuWk.setBankcd(uiBean.getBankcd());
                    khGengakuWk.setSitencd(uiBean.getSitencd());
                    khGengakuWk.setYokinkbn(uiBean.getYokinkbn());
                    khGengakuWk.setKouzano(uiBean.getKouzano());
                    khGengakuWk.setKzdoukbn(uiBean.getKzdoukbn());

                    if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                        khGengakuWk.setKzmeiginmkn("");
                    }
                    else {
                        khGengakuWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
                    }
                }
                else {
                    khGengakuWk.setBankcd("");
                    khGengakuWk.setSitencd("");
                    khGengakuWk.setYokinkbn(C_YokinKbn.BLNK);
                    khGengakuWk.setKouzano("");
                    khGengakuWk.setKzdoukbn(C_Kzdou.BLNK);
                    khGengakuWk.setKzmeiginmkn("");
                }

                khGengakuWk.setSoukinsakikbn(uiBean.getSoukinsakikbn());
                khGengakuWk.setKykmnmeigibangou(uiBean.getKykmnmeigibangou());
                khGengakuWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
                khGengakuWk.setHassoukbn(uiBean.getHassoukbn());
                khGengakuWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
                khGengakuWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
                khGengakuWk.setGyoumuKousinTime(systemTime);

                BizPropertyInitializer.initialize(khGengakuWk);

                hozenDomManager.insert(khGengakuWk);
            }
            else {

                IW_KhGengakuWk khGengakuWk = hozenDomManager.getKhGengakuWk(
                    uiBean.getBzWorkflowInfo().getKouteiKanriId());

                if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

                    khGengakuWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
                }


                if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn()) &&
                    !C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn())) {

                    khGengakuWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
                    khGengakuWk.setKykhnkkbn(uiBean.getSyuhnkkbn());
                    khGengakuWk.setGengkhoukbn(uiBean.getGengkhoukbn());
                    khGengakuWk.setNewkihonhknkngaku(uiBean.getSyukihons());
                    khGengakuWk.setNewhrkp(uiBean.getNewhrkp());
                    khGengakuWk.setYenshrtkhkumu(uiBean.getYenshrtkumu());
                    khGengakuWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());

                    if (!C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn()) &&
                        !C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn())) {

                        khGengakuWk.setBankcd(uiBean.getBankcd());
                        khGengakuWk.setSitencd(uiBean.getSitencd());
                        khGengakuWk.setYokinkbn(uiBean.getYokinkbn());
                        khGengakuWk.setKouzano(uiBean.getKouzano());
                        khGengakuWk.setKzdoukbn(uiBean.getKzdoukbn());
                        if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                            khGengakuWk.setKzmeiginmkn("");
                        }
                        else {
                            khGengakuWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
                        }
                    }
                    else {
                        khGengakuWk.setBankcd("");
                        khGengakuWk.setSitencd("");
                        khGengakuWk.setYokinkbn(C_YokinKbn.BLNK);
                        khGengakuWk.setKouzano("");
                        khGengakuWk.setKzdoukbn(C_Kzdou.BLNK);
                        khGengakuWk.setKzmeiginmkn("");
                    }
                    khGengakuWk.setKykmnmeigibangou(uiBean.getKykmnmeigibangou());
                    khGengakuWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
                    khGengakuWk.setHassoukbn(uiBean.getHassoukbn());
                    khGengakuWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
                    khGengakuWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
                    khGengakuWk.setGyoumuKousinTime(systemTime);
                    khGengakuWk.setSoukinsakikbn(uiBean.getSoukinsakikbn());
                }
                else {

                    khGengakuWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
                    khGengakuWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
                    khGengakuWk.setGyoumuKousinTime(systemTime);
                }
                hozenDomManager.update(khGengakuWk);

            }
        }
    }

    private void updateGengakuWKSeikyuSyo(KhozenCommonParam pKhozenCommonParam) {

        IW_KhGengakuWk khGengakuWk = new IW_KhGengakuWk();

        khGengakuWk.setKouteikanriid(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());
        khGengakuWk.setSyono(uiBean.getSyono());
        khGengakuWk.setSkssakuseiymd(BizDate.getSysDate());
        khGengakuWk.setKykhnkkbn(uiBean.getSyuhnkkbn());
        khGengakuWk.setGengkhoukbn(uiBean.getGengkhoukbn());
        khGengakuWk.setNewkihonhknkngaku(uiBean.getSyukihons());
        khGengakuWk.setNewhrkp(uiBean.getNewhrkp());
        khGengakuWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        khGengakuWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        khGengakuWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(khGengakuWk);

        hozenDomManager.insert(khGengakuWk);
    }

    private void makeTyouhyou(KhozenCommonParam pKhozenCommonParam) {

        EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);

        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.GENGAKU);

        if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0 ||
            uiBean.getAzukarigoukeigk().compareTo(BizCurrency.valueOf(0, uiBean.getAzukarigoukeigk().getType())) > 0 ||
            uiBean.getAzukarijpygoukeigk().compareTo(BizCurrency.valueOf(0, uiBean.getAzukarijpygoukeigk().getType())) > 0) {

            editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        }
        else {

            editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        }

        if (C_UmuKbn.NONE.eq(uiBean.getZeiseitkkktkykhukaumu())) {
            editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);
        }
        else {
            editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR);
        }

        editTtdkKanryouParam.setKouryokuYMD(uiBean.getKouryokuHasseiYmd());
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setGengkhou(uiBean.getGengkhoukbn());
        editTtdkKanryouParam.setBfrP(uiBean.getVhsyusyup());
        editTtdkKanryouParam.setBfrKihons(uiBean.getVhsyusyukihons());

        editTtdkKanryouParam.setCalckijyunYMD(uiBean.getSyoruiukeymd());

        editTtdkKanryouParam.setGsbunritaisyouFlg(uiBean.getGsBunriTaisyouFlag());

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);

        editHokenSyoukenParam.setCalckijyunYMD(uiBean.getSyoruiukeymd());

        if (uiBean.getShrgkgoukeisyoukai().compareTo(
            BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0 &&
            !C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {

            editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.ARI);
        }
        else {

            editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        }

        C_SyoruiCdKbn[] syoruiCdKbn = new C_SyoruiCdKbn[2];
        if (C_UmuKbn.ARI.eq(uiBean.getZeiseitkkktkykhukaumu())) {
            syoruiCdKbn[0] = C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR;
            syoruiCdKbn[1] = C_SyoruiCdKbn.KK_HKNSYKN;
        }
        else {
            syoruiCdKbn[0] = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
            syoruiCdKbn[1] = C_SyoruiCdKbn.KK_HKNSYKN;
        }

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
        khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);
        khozenTyouhyouCtl.setHassoukbn(uiBean.getHassoukbn());

        khozenTyouhyouCtl.createTyouhyouTBL(
            pKhozenCommonParam,
            uiBean.getSyono(),
            syoruiCdKbn,
            C_YouhiKbn.HUYOU);

        uiBean.setTyouhyoumuKbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setReportKey(khozenTyouhyouCtl.getTyouhyouKey());

        IT_KhTtdkRireki khTtdkRireki = khGengakuDao.getKhTtdkRirekisMkhgktttYendthnktorikesiBySyono(uiBean.getSyono());

        if (khTtdkRireki != null) {
            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), khTtdkRireki.getSyoriYmd()) == BizDateUtil.COMPARE_LESSER) {

                BizDate syoriYmdMae = systemYmd.getPreviousDay().getRekijyou();

                List<String> jimuRenrakuMsgList = new ArrayList<String>();

                jimuRenrakuMsgList.add("書類受付してから１日以上経過しています。");


                jimuRenrakuMsgList.add("書類受付日（" + DateFormatUtil.dateKANJISeirekiNoZero(uiBean.getSyoruiukeymd()) +
                    "）～処理日の前日（" + DateFormatUtil.dateKANJISeirekiNoZero(syoriYmdMae) + "）の期間で");

                jimuRenrakuMsgList.add("目標額到達判定を実施してください。");

                EditJimuRenrakuhyouParam editJimuRenrakuhyouParam = SWAKInjector.getInstance(EditJimuRenrakuhyouParam.class);
                editJimuRenrakuhyouParam.setJimurenrakuMsgList(jimuRenrakuMsgList);

                KhozenTyouhyouCtl khozenTyouhyouCtl2 = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

                khozenTyouhyouCtl2.setSyoriYmd(systemYmd);

                khozenTyouhyouCtl2.setEditJimuRenrakuhyouParam(editJimuRenrakuhyouParam);

                khozenTyouhyouCtl2.createTyouhyouTBL(pKhozenCommonParam,
                    uiBean.getSyono(),
                    new C_SyoruiCdKbn[]{C_SyoruiCdKbn.KK_JIMURENRAKU_GENGAKU},
                    C_YouhiKbn.HUYOU);
            }
        }
    }

    private void makeTyouhyouSeiKyuSyo(KhozenCommonParam pKhozenCommonParam) {

        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);

        editSeikyuusyoParam.setBfrKihonS(uiBean.getNewhkngk());
        editSeikyuusyoParam.setBfrP(uiBean.getNewhrkp());
        editSeikyuusyoParam.setHenkougokjnkngk(uiBean.getNewsyukjnkngk());
        editSeikyuusyoParam.setGengkhouKbn(uiBean.getGengkhoukbn());
        editSeikyuusyoParam.setRstuukasyu(uiBean.getVhsyusyukyktuukasyu());

        if (C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) {
            KeisanTeikishrkin keisanTeikishrkin = SWAKInjector.getInstance(KeisanTeikishrkin.class);

            keisanTeikishrkin.exec(uiBean.getSyukihons(),
                uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0).getTeikishrritu());

            editSeikyuusyoParam.setHenkougoteikisiharaikingk(keisanTeikishrkin.getTeikishrkin());

        }

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);

        IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();

        editSouhuannaiParam.setTargetTkHkUmu(kykSonotaTkyk.getTargettkhkumu());

        editSouhuannaiParam.setGsbunritaisyouumukbn(uiBean.getGsBunriTaisyouFlag());

        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);

        C_SyoruiCdKbn[] syoruiCdKbn = new C_SyoruiCdKbn[2];

        syoruiCdKbn[0] = C_SyoruiCdKbn.KK_GENGAKU_SOUHU;
        syoruiCdKbn[1] = C_SyoruiCdKbn.KK_GENGAKU_SKS;

        khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam, uiBean.getSyono(), syoruiCdKbn, C_YouhiKbn.YOU);

        uiBean.setTyouhyoumuKbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setReportKey(khozenTyouhyouCtl.getTyouhyouKey());
    }

    private void doJikouteikanri() {

        if (C_KhkinouModeIdKbn.INPUTKEY.toString().equals(kinouMode.getKinouMode())) {

            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

            CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

            C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

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

            bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);

            bzForceTaskStart.exec(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                C_KhkinouModeIdKbn.INPUT.getValue(),
                bzCommonLockProcess.getKouteiLockKey());
        }

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");

        String comment = uiBean.getSyanaicommentkh();

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

        khProcessForward.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            bzCommonLockProcess.getKouteiLockKey(),
            comment,
            khRuleBean);

        bzCommonLockProcess.unlockProcess();
    }

    private Boolean checkMrf() {
        List<IT_KykDairiten> kykDairitenList =  uiBean.getKykKihon().getKykDairitens();

        Boolean isMRFAccount = false;

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        List<BzGetAgInfoBean> dairitenInfoA = bzGetAgInfo.exec(kykDairitenList.get(0).getDrtencd());

        isMRFAccount = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(dairitenInfoA.get(1).getOyadrtenCd());

        if(isMRFAccount == false && kykDairitenList.size() > 1){
            List<BzGetAgInfoBean> dairitenInfoB = bzGetAgInfo.exec(kykDairitenList.get(1).getDrtencd());

            isMRFAccount = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(dairitenInfoB.get(1).getOyadrtenCd());
        }
        return isMRFAccount;
    }

    private BizCurrency doKingakuHenkan(BizCurrency pHenkanZenGk) {

        if (pHenkanZenGk.isOptional()) {
            return BizCurrency.valueOf(0, pHenkanZenGk.getType());
        }
        return pHenkanZenGk;
    }

    private void insertHokenryouTmttkn() {
        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyouhinHanteiKbn()) {
            IT_HokenryouTmttkn hokenryouTmttkn = hozenDomManager.getHokenryouTmttknBySyonoTmttkntaisyouym(
                uiBean.getSyono(), uiBean.getTmttkntaisyouym());

            Integer maxRenno = null;
            if (hokenryouTmttkn != null &&
                BizDateUtil.compareYm(uiBean.getTmttkntaisyouym(), hokenryouTmttkn.getTmttkntaisyouym()) == BizDateUtil.COMPARE_EQUAL) {
                maxRenno = hokenryouTmttkn.getRenno() + 1;
            }
            else {
                maxRenno = 1;
            }

            IT_HokenryouTmttkn newHokenryouTmttkn = uiBean.getKykKihon().createHokenryouTmttkn();

            newHokenryouTmttkn.setTmttkntaisyouym(uiBean.getTmttkntaisyouym());
            newHokenryouTmttkn.setRenno(maxRenno);
            newHokenryouTmttkn.setPtmttkngk(uiBean.getPtmttkngk());
            newHokenryouTmttkn.setKihrkmpstgk(uiBean.getKihrkmpstgk());
            newHokenryouTmttkn.setTyouseimaeptmttkngk(uiBean.getPtumitatekinTyoseimae());
            newHokenryouTmttkn.setGyoumuKousinKinou(kinouId);
            newHokenryouTmttkn.setGyoumuKousinsyaId(sousasyaCd);
            newHokenryouTmttkn.setGyoumuKousinTime(systemTime);
            BizPropertyInitializer.initialize(newHokenryouTmttkn);
        }
    }

    private void editZennou(KhozenCommonParam pKhozenCommonParam) {

        List<IT_KykSyouhn> kykSyouhnLst = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);
        if (C_Kykjyoutai.ZENNOU.eq(kykSyouhnLst.get(0).getKykjyoutai())) {
            IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(uiBean.getSyono());
            List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();
            IT_Zennou zennou = zennouLst.get(0);

            Integer maxRenno = zennou.getRenno() + 1;

            zennou.setZennouseisankbn(C_ZennouSeisanKbn.SEISANZUMI);
            zennou.setZennouseisansyoriymd(systemYmd);
            zennou.setZennouseisankgk(uiBean.getZennouseisankgk());
            zennou.setZennouseisankijyunymd(uiBean.getSyoruiukeymd());
            if (uiBean.getShrgkgoukeisyoukai().compareTo(BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) {
                zennou.setZennouseisandenymd(uiBean.getShrymd());
            }
            else {
                zennou.setZennouseisandenymd(null);
            }
            zennou.setGyoumuKousinKinou(kinouId);
            zennou.setGyoumuKousinsyaId(sousasyaCd);
            zennou.setGyoumuKousinTime(systemTime);

            if (C_Tuukasyu.JPY.eq(uiBean.getRstuukasyu()) && !C_Tuukasyu.JPY.eq(uiBean.getHrktuukasyu())) {
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                BizCurrency kanzanGaku = keisanGaikakanzan.exec(uiBean.getRstuukasyu(),
                    uiBean.getNewZennounyuukinkgk(), zennou.getRyosyukwsrate(), C_HasuusyoriKbn.SUTE);
                uiBean.setZennounyuukinkgkrstk(kanzanGaku);
                uiBean.setZennounyuukinkgkryosyukwsrate(zennou.getRyosyukwsrate());
                uiBean.setZennounyuukinkgkryosyukwsratekjymd(zennou.getRyosyukwsratekjymd());
            }
            else {
                uiBean.setZennounyuukinkgkrstk(uiBean.getNewZennounyuukinkgk());
            }

            if (!C_Tuukasyu.JPY.eq(uiBean.getRstuukasyu())) {
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                    uiBean.getNewZennounyuukinkgk(), zennou.getYenkansantkykwsrate(), C_HasuusyoriKbn.SUTE);

                uiBean.setYenkansannyknkingk(kanzanGaku);
                uiBean.setYenkansannyknkingkryosyukwsrate(zennou.getYenkansantkykwsrate());
                uiBean.setYenkansannyknkingkryosyukwsratekjymd(zennou.getYenkansantkykwsrateymd());
            }
            else {
                uiBean.setYenkansannyknkingk(uiBean.getZennounyuukinkgkrstk());
                uiBean.setYenkansannyknkingkryosyukwsrate(uiBean.getZennounyuukinkgkryosyukwsrate());
                uiBean.setYenkansannyknkingkryosyukwsratekjymd(uiBean.getZennounyuukinkgkryosyukwsratekjymd());
            }

            SetKjsmyouZennouInfo setKjsmyouZennouInfo = SWAKInjector.getInstance(SetKjsmyouZennouInfo.class);

            setKjsmyouZennouInfo.setYenkaknsnKijyunymd(zennou.getKjsmyouyenkansanrateymd());
            setKjsmyouZennouInfo.setYenknsnKawaseRate(zennou.getKjsmyouyenkansankwsrate());

            setKjsmyouZennouInfo.exec(kykSyouhnLst.get(0).getKykymd(),
                String.valueOf(Integer.parseInt(zennou.getZennoukikan())+1),
                uiBean.getNewZennounyuukinkgk().add(uiBean.getNewZennoujihrkp()),
                uiBean.getVhrkihrkkaisuu(),
                uiBean.getSyup(),
                C_UmuKbn.ARI);

            IT_Zennou newZennou = ansyuKihon.createZennou();
            newZennou.setZennoukaisiymd(zennou.getZennoukaisiymd());
            newZennou.setRenno(maxRenno);
            newZennou.setZennounyuukinsyoriymd(zennou.getZennounyuukinsyoriymd());
            newZennou.setZennounyuukindenno(zennou.getZennounyuukindenno());
            newZennou.setZennounyuukindenymd(zennou.getZennounyuukindenymd());
            newZennou.setRyosyuymd(zennou.getRyosyuymd());
            newZennou.setTyakkinymd(zennou.getTyakkinymd());
            newZennou.setZennoukikan(zennou.getZennoukikan());
            newZennou.setZennounyuukinkgk(uiBean.getNewZennounyuukinkgk());
            newZennou.setZennounyuukinkgkrstk(uiBean.getZennounyuukinkgkrstk());
            newZennou.setZennoujihrkp(uiBean.getNewZennoujihrkp());
            newZennou.setRstuukasyu(uiBean.getRstuukasyu());
            newZennou.setRyosyukwsratekjymd(uiBean.getZennounyuukinkgkryosyukwsratekjymd());
            newZennou.setRyosyukwsrate(uiBean.getZennounyuukinkgkryosyukwsrate());
            newZennou.setZennouseisankbn(C_ZennouSeisanKbn.MISEISAN);
            newZennou.setAnnaisaikaiym(zennou.getAnnaisaikaiym());
            newZennou.setYenkansannyknkingk(uiBean.getYenkansannyknkingk());
            newZennou.setYenkansantkykwsrateymd(uiBean.getYenkansannyknkingkryosyukwsratekjymd());
            newZennou.setYenkansantkykwsrate(uiBean.getYenkansannyknkingkryosyukwsrate());
            newZennou.setKjsmyouzennoukaisiymd(setKjsmyouZennouInfo.getKjsmyouzennoukaisiymd());
            newZennou.setKjsmyouzennoukikanm(setKjsmyouZennouInfo.getKjsmyouzennoukikanm());
            newZennou.setKjsmyouzennounyuukinkgk(setKjsmyouZennouInfo.getKjsmyouzennounyuukinkgk());
            newZennou.setKjsmyouyenkansanrateymd(setKjsmyouZennouInfo.getKjsmyouenknsnkijyunymd());
            newZennou.setKjsmyouyenkansankwsrate(setKjsmyouZennouInfo.getKjsmyouenknsnrate());
            newZennou.setGyoumuKousinKinou(kinouId);
            newZennou.setGyoumuKousinsyaId(sousasyaCd);
            newZennou.setGyoumuKousinTime(systemTime);
            BizPropertyInitializer.initialize(newZennou);

            hozenDomManager.update(ansyuKihon);

            if (C_UmuKbn.ARI.eq(uiBean.getZennouJyutouTorikesiFlg())) {
                KykHenkoujiZnnJytTrksKsn kykHenkoujiZnnJytTrksKsn = SWAKInjector.getInstance(KykHenkoujiZnnJytTrksKsn.class);

                kykHenkoujiZnnJytTrksKsn.exec(pKhozenCommonParam, uiBean.getSyono(), systemYmd,
                    uiBean.getLastPJyuutouYm(), C_ZennouSeisanSyoriKbn.GENGAKU);
            }

            ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = SWAKInjector.getInstance(ZennouKoujyogakuKeisanParam.class);
            zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(setKjsmyouZennouInfo.getKjsmyouzennoukaisiymd());
            zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm(setKjsmyouZennouInfo.getKjsmyouzennoukikanm());
            zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(setKjsmyouZennouInfo.getKjsmyouzennounyuukinkgk());
            zennouKoujyogakuKeisanParam.setHrkp(uiBean.getSyup());
            zennouKoujyogakuKeisanParam.setHrkkaisuu(uiBean.getVhrkihrkkaisuu());
            zennouKoujyogakuKeisanParam.setZennoukaisiymd(zennou.getZennoukaisiymd());
            zennouKoujyogakuKeisanParam.setZennourenno(maxRenno);
            zennouKoujyogakuKeisanParam.setKjsmyouyenknsnkawaserate(zennou.getKjsmyouyenkansankwsrate());

            ZennouKoujyogakuKeisanParam henmaeZennouKoujyogakuKeisanParam = SWAKInjector.getInstance(ZennouKoujyogakuKeisanParam.class);
            henmaeZennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(zennou.getKjsmyouzennoukaisiymd());
            henmaeZennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm(zennou.getKjsmyouzennoukikanm());
            henmaeZennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(zennou.getKjsmyouzennounyuukinkgk());
            henmaeZennouKoujyogakuKeisanParam.setHrkp(uiBean.getVhsyusyup());
            henmaeZennouKoujyogakuKeisanParam.setHrkkaisuu(uiBean.getVhrkihrkkaisuu());
            henmaeZennouKoujyogakuKeisanParam.setZennoukaisiymd(zennou.getZennoukaisiymd());
            henmaeZennouKoujyogakuKeisanParam.setZennourenno(zennou.getRenno());

            uiBean.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);
            uiBean.setHenmaeZennouKoujyogakuKeisanParam(henmaeZennouKoujyogakuKeisanParam);
        }
    }

    private void editAzukarikin () {
        if (uiBean.getAzukarigoukeigk().compareTo(BizCurrency.valueOf(0, uiBean.getAzukarigoukeigk().getType())) > 0) {
            IT_Azukarikin azukarikin = uiBean.getKykKihon().createAzukarikin();
            azukarikin.setHenkousikibetukey(henkousikibetuKey);
            azukarikin.setTuukasyu(uiBean.getVhsyusyukyktuukasyu());
            azukarikin.setAzukarikinsyuruikbn(C_AzukarikinsyuruiKbn.ZEITEKI_AZUKARI);
            azukarikin.setAzukarikinhsiymd(uiBean.getSyoruiukeymd());
            azukarikin.setAzukarikingk(uiBean.getAzukarigoukeigk());
            azukarikin.setGyoumuKousinKinou(kinouId);
            azukarikin.setGyoumuKousinsyaId(sousasyaCd);
            azukarikin.setGyoumuKousinTime(systemTime);
            BizPropertyInitializer.initialize(azukarikin);
        }

        if (uiBean.getAzukarijpygoukeigk().compareTo(BizCurrency.valueOf(0, uiBean.getAzukarijpygoukeigk().getType())) > 0) {
            IT_Azukarikin azukarikin = uiBean.getKykKihon().createAzukarikin();
            azukarikin.setHenkousikibetukey(henkousikibetuKey);
            azukarikin.setTuukasyu(C_Tuukasyu.JPY);
            azukarikin.setAzukarikinsyuruikbn(C_AzukarikinsyuruiKbn.ZEITEKI_AZUKARI);
            azukarikin.setAzukarikinhsiymd(uiBean.getSyoruiukeymd());
            azukarikin.setAzukarikingk(uiBean.getAzukarijpygoukeigk());
            azukarikin.setGyoumuKousinKinou(kinouId);
            azukarikin.setGyoumuKousinsyaId(sousasyaCd);
            azukarikin.setGyoumuKousinTime(systemTime);
            BizPropertyInitializer.initialize(azukarikin);
        }
    }

    private void editKoujyonaiyouTbl (KhozenCommonParam pKhozenCommonParam) {
        if (uiBean.getMikeikaP().compareTo(BizCurrency.valueOf(0, uiBean.getMikeikaP().getType())) > 0 &&
            C_UmuKbn.NONE.eq(uiBean.getZeiseitkkktkykhukaumu())) {
            List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey(uiBean.getSyono());

            List<IT_KykSyouhn> kykSyouhnLst = uiBean.getKykKihon().getKykSyouhns();

            List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = Lists.newArrayList();

            List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = Lists.newArrayList();

            kykSyouhnCommonParamLst.addAll(kykSyouhnLst);
            henmaeKykSyouhnCommonParamLst.addAll(kykSyouhnRirekiLst);

            EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);

            editKoujyonaiyouTbl.setCalcKjnYmd(uiBean.getKouryokuHasseiYmd());
            editKoujyonaiyouTbl.setHenmaeJkipJytYm(pKhozenCommonParam.getAnsyuuKihon(uiBean.getSyono()).getJkipjytym());
            editKoujyonaiyouTbl.setHenmaeHenkousikibetukey(kykSyouhnRirekiLst.get(0).getHenkousikibetukey());
            editKoujyonaiyouTbl.setHenmaeHrkKaisuu(uiBean.getVhrkihrkkaisuu());
            editKoujyonaiyouTbl.setKihrkpSeisanRenno(uiBean.getRenno());
            editKoujyonaiyouTbl.setKihrkpSeisanJytYm(uiBean.getMikeikaPjyutouYm());
            editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(uiBean.getMikeikaPJyutouKaisuuM());
            editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(uiBean.getMikeikaPJyutouKaisuuY());
            editKoujyonaiyouTbl.setMkkp(uiBean.getMikeikaP());
            if (!C_Tuukasyu.JPY.eq(uiBean.getVhsyusyukyktuukasyu())) {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(uiBean.getYenshrrate());
                }
                else {
                    editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(uiBean.getZeimukwsrate());
                }
            }
            editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamLst);
            editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(uiBean.getZennouKoujyogakuKeisanParam());
            editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);
            editKoujyonaiyouTbl.setHenmaeZennouKoujyogakuKeisanParam(uiBean.getHenmaeZennouKoujyogakuKeisanParam());

            editKoujyonaiyouTbl.exec(pKhozenCommonParam, uiBean.getSyono(),
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, systemYmd);
        }
    }

    private void editKoujyonaiyouDTbl (KhozenCommonParam pKhozenCommonParam,IT_KhHaitouKanri pKhHaitouKanri) {

        List<IT_KykSyouhn> kykSyouhnLst = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        if (C_Kykjyoutai.HRKMTYUU.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
            C_Kykjyoutai.IKKATUNK.eq(kykSyouhnLst.get(0).getKykjyoutai()) ||
            C_Kykjyoutai.ZENNOU.eq(kykSyouhnLst.get(0).getKykjyoutai())) {

            if (pKhHaitouKanri != null) {

                KoujyonaiyouDTBLSksParam koujyonaiyouDTBLSksParam = SWAKInjector.getInstance(KoujyonaiyouDTBLSksParam.class);
                EditKoujyonaiyouDTbl editKoujyonaiyouDTbl = SWAKInjector.getInstance(EditKoujyonaiyouDTbl.class);

                koujyonaiyouDTBLSksParam.setZeiseiTkkktkykhukaUmu(uiBean.getZeiseitkkktkykhukaumu());
                koujyonaiyouDTBLSksParam.setKhHaitouKanri(pKhHaitouKanri);
                koujyonaiyouDTBLSksParam.setKykSyouhn(kykSyouhnLst.get(0));

                editKoujyonaiyouDTbl.editTBL(pKhozenCommonParam, koujyonaiyouDTBLSksParam);
            }
        }
    }

    private GengakuKahiKbnBean checkGengakuKahi(int pSyouhinHanteiKbn, C_Sdpd pSdpd, BM_SyouhnZokusei pSyouhnZokusei) {

        GengakuKahiKbnBean gengakuKahiKbnBean = SWAKInjector.getInstance(GengakuKahiKbnBean.class);

        if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == pSyouhinHanteiKbn) {
            if (C_Sdpd.SD.eq(pSdpd)) {
                gengakuKahiKbnBean.setGengakukahikbn(GENGAKUKAHIKBN_SYORIKANOU);
                gengakuKahiKbnBean.setPgengakukahikbn(C_KahiKbn.HUKA);
            }
            else {
                gengakuKahiKbnBean.setGengakukahikbn(GENGAKUKAHIKBN_SYORIFUKA);
                gengakuKahiKbnBean.setPgengakukahikbn(C_KahiKbn.KA);
            }
        }
        else {
            gengakuKahiKbnBean.setGengakukahikbn(pSyouhnZokusei.getGengakukahikbn());
            gengakuKahiKbnBean.setPgengakukahikbn(pSyouhnZokusei.getPgengakukahikbn());
        }

        return gengakuKahiKbnBean;
    }

    private void insertSikinIdouRireki(KhozenCommonParam pKhozenCommonParam, BizDate pSysDate, String pSikibetuKey) {
        BizDateYM phendoukaisiym = null;
        if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) {
            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

            BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, uiBean.getVhsyusyukykymd(), C_Hrkkaisuu.TUKI,
                uiBean.getSyoruiukeymd());

            BizDateYM outouYm = outouYmd.getBizDateYM();

            IT_AnsyuKihon ansyuKihon = pKhozenCommonParam.getAnsyuuKihon(uiBean.getSyono());
            BizDateYM jkipjytym = ansyuKihon.getJkipjytym();

            if (BizDateUtil.compareYm(outouYm, jkipjytym) != BizDateUtil.COMPARE_GREATER) {
                phendoukaisiym = outouYm;
            }
            else {
                phendoukaisiym = jkipjytym;
            }
        }

        List<IT_KykSyouhn> kykSyouhnSyuLst = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);
        IT_KykSyouhn syukykSyouhn = kykSyouhnSyuLst.get(0);

        SikinIdouRirekiDataBean sikinIdouRirekiDataBean = SWAKInjector.getInstance(SikinIdouRirekiDataBean.class);
        BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei =
            SWAKInjector.getInstance(BzSikinIdouRirekiTblSakusei.class);

        sikinIdouRirekiDataBean.setSyoriYmd(pSysDate);
        sikinIdouRirekiDataBean.setSyono(uiBean.getSyono());
        sikinIdouRirekiDataBean.setHenkouSikibetuKey(pSikibetuKey);
        sikinIdouRirekiDataBean.setTargetKinouId(pKhozenCommonParam.getFunctionId());
        sikinIdouRirekiDataBean.setSeikyuuRirekiNo(0);
        sikinIdouRirekiDataBean.setNykshrKbn(C_NykshrKbn.SIHARAI);
        sikinIdouRirekiDataBean.setSyoricd(kinou.getSyoricd());
        sikinIdouRirekiDataBean.setKykTuukasyu(syukykSyouhn.getKyktuukasyu());
        sikinIdouRirekiDataBean.setSyutkKbn(syukykSyouhn.getSyutkkbn());
        sikinIdouRirekiDataBean.setHrkkaisuu(uiBean.getKykKihon().getHrkkaisuu());
        sikinIdouRirekiDataBean.setSyouhnCd(syukykSyouhn.getSyouhncd());
        sikinIdouRirekiDataBean.setSyouhnSdno(syukykSyouhn.getSyouhnsdno());
        sikinIdouRirekiDataBean.setKykSyouhnRenno(syukykSyouhn.getKyksyouhnrenno());
        sikinIdouRirekiDataBean.setPhendouKaisiYm(phendoukaisiym);
        sikinIdouRirekiDataBean.setKykYmd(syukykSyouhn.getKykymd());
        sikinIdouRirekiDataBean.setSeirituYmd(uiBean.getKykKihon().getSeirituymd());
        sikinIdouRirekiDataBean.setShrsyoriKbn(C_ShrsyoriKbn.GENGAKU);
        sikinIdouRirekiDataBean.setHrkp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        sikinIdouRirekiDataBean.setHokenryou(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        if (C_UmuKbn.NONE.eq(uiBean.getZeiseitkkktkykhukaumu())) {
            sikinIdouRirekiDataBean.setSeg1cd(
                uiBean.getCommonSiwakeOutBean().getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd());
            sikinIdouRirekiDataBean.setDensysKbn(uiBean.getCommonSiwakeOutBean().getDensysKbn());
            sikinIdouRirekiDataBean.setDenrenno(uiBean.getDenrenNo());
            sikinIdouRirekiDataBean.setShrhousiteiKbn(uiBean.getShrhouSiteiKbn());
        }
        else {
            BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
            SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
                syukykSyouhn.getSyouhncd(), syukykSyouhn.getKyktuukasyu());

            sikinIdouRirekiDataBean.setSeg1cd(syouhinbetuSegmentBean.getSegcd1());
            sikinIdouRirekiDataBean.setDensysKbn(C_DensysKbn.BLNK);
            sikinIdouRirekiDataBean.setDenrenno("");
            sikinIdouRirekiDataBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getHeijyunbaraiumu())) {
            sikinIdouRirekiDataBean.setPhendoumaeGk(uiBean.getVhsyusyup());
            sikinIdouRirekiDataBean.setPhendougoGk(uiBean.getSyup());
        }
        else {
            sikinIdouRirekiDataBean.setPhendoumaeGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            sikinIdouRirekiDataBean.setPhendougoGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        }

        BT_SikinIdouRireki sikinIdouRireki =
            bzSikinIdouRirekiTblSakusei.editSikinIdouRirekiTblEntity(sikinIdouRirekiDataBean);

        bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblOne(sikinIdouRireki);
    }

    private void insertKhLincSousinData(KhozenCommonParam pKhozenCommonParam, BizDate pSyoriYmd,
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

    private void editHokenKykIdouRirekiTbl(KhozenCommonParam pKhozenCommonParam, BizDate pSysDate,String pSysDateTime) {
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(pKhozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo(uiBean.getSyono());
        editHokenKykIdouRirekiTblBean.setSyoriYmd(pSysDate);
        editHokenKykIdouRirekiTblBean.setSysDateTime(pSysDateTime);
        editHokenKykIdouRirekiTblBean.setMikeikaP(uiBean.getMikeikapGengakuGo());
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(uiBean.getZennouseisankinGengakuGo());
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(uiBean.getMikeikapGengakuMae());
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(uiBean.getZennouseisankinGengakuMae());

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);
    }
}
