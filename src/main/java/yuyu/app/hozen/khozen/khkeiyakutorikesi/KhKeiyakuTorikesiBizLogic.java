package yuyu.app.hozen.khozen.khkeiyakutorikesi;

import static yuyu.app.hozen.khozen.khkeiyakutorikesi.GenKhKeiyakuTorikesiConstants.*;
import static yuyu.app.hozen.khozen.khkeiyakutorikesi.KhKeiyakuTorikesiConstants.*;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khkeiyakutorikesi.dba.KhKeiyakuTorikesiDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.CheckMeigininNmKanji;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanAzukariGanrikin;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanTienrisoku;
import yuyu.common.biz.bzcommon.KeisanTienrisokuBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzFbSoukinDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSks;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakusei;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
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
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.haitou.CheckDShrKaiyaku;
import yuyu.common.hozen.haitou.KeisanDCommonKaiyaku;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CommonSiwake;
import yuyu.common.hozen.khcommon.CommonSiwakeInBean;
import yuyu.common.hozen.khcommon.CommonSiwakeOutBean;
import yuyu.common.hozen.khcommon.CommonSiwakeUtil;
import yuyu.common.hozen.khcommon.EditDairitenTesuuryouTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTblBean;
import yuyu.common.hozen.khcommon.EditJimuRenrakuhyouParam;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouTbl;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTbl;
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
import yuyu.common.hozen.khcommon.KeisanMsyMkeiP;
import yuyu.common.hozen.khcommon.KeisanSiharaibi;
import yuyu.common.hozen.khcommon.KeisanV;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.KhCheckKouza;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenEdit;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.KykHenkoujiZnnJytTrksKsn;
import yuyu.common.hozen.khcommon.KykSyouhnCommonParam;
import yuyu.common.hozen.khcommon.MiKeikaPBean;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SiwakeHanteiNyknJissekiRirekiBean;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.khcommon.TaisyouGkBean;
import yuyu.common.hozen.khcommon.ZennouKoujyogakuKeisanParam;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHaitoukin;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetHituyouSyorui;
import yuyu.common.hozen.setuibean.SetHosyou;
import yuyu.common.hozen.setuibean.SetKariukekin;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKhTkshrSiharaiKouza;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetSonotaTk;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SmbcsintyokukanriCoolingoff;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FiSiyouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HijynbrKanritukaHantKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyktrksKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SntkInfoKykTorikesiKbn;
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
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.classification.C_ZennouSeisanSyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhShrRirekiDetail;
import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.IW_KhKeiyakuTorikesiWk;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_NyknJissekiRireki;
import yuyu.def.hozen.sorter.SortIT_Zennou;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.OutputReport;

import com.google.common.collect.Lists;

/**
 * 契約取消 のビジネスロジックです。
 */
public class KhKeiyakuTorikesiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKeiyakuTorikesiUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    private final KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

    @Inject
    private KhKeiyakuTorikesiDao khKeiyakuTorikesiDao;

    void init() {
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        uiBean.setKouteiLockKey(bzCommonLockProcess.getKouteiLockKey());

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),uiBean.getBzWorkflowInfo().getTaskId(),uiBean.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(
            uiBean.getBzWorkflowInfo().getKouteiKanriId());

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());

        IW_KhKeiyakuTorikesiWk khKeiyakuTorikesiWk = hozenDomManager.getKhKeiyakuTorikesiWk(
            uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if (khKeiyakuTorikesiWk == null) {
            throw new CommonBizAppException(IW_KhKeiyakuTorikesiWk.TABLE_NAME + " 取得エラー");
        }

        uiBean.setZenkaisyorikekkakbn(khKeiyakuTorikesiWk.getZenkaisyorikekkakbn());
        uiBean.setKyktrkskbn(khKeiyakuTorikesiWk.getKyktrkskbn());

        checkKykSonzai(uiBean.getSyono());

        checkYuukouJyoutai();

        checkTetudukiTyuui(uiBean.getSyono());

        checkSbhsyukeiyaku(uiBean.getSyono());

        setUiBean();

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        setProgressHistory.exec(uiBean);

        setWarningMessage();

        uiBean.setSibouymd(khKeiyakuTorikesiWk.getSibouymd());
        uiBean.setKaijyokessaiymd(khKeiyakuTorikesiWk.getKaijyokessaiymd());
        uiBean.setKaijyotuutiymd(khKeiyakuTorikesiWk.getKaijyotuutiymd());
        uiBean.setSyoruiukeymd(khKeiyakuTorikesiWk.getSyoruiukeymd());
        uiBean.setHubikanryouymd(khKeiyakuTorikesiWk.getHubikanryouymd());
        uiBean.setSinsagendokknkbn(khKeiyakuTorikesiWk.getSinsagendokknkbn());
        uiBean.setRikoukityuutuudannissuu(khKeiyakuTorikesiWk.getRikoukityuutuudannissuu());
        uiBean.setSoukinsakisiteikbn(khKeiyakuTorikesiWk.getSoukinsakisiteikbn());
        uiBean.setSoukinsakinmkn(khKeiyakuTorikesiWk.getSoukinsakinmkn());
        uiBean.setSoukinsakinmkj(khKeiyakuTorikesiWk.getSoukinsakinmkj());
        uiBean.setSoukinsakiyno(khKeiyakuTorikesiWk.getSoukinsakiyno());
        uiBean.setSoukinsakiadr1kj(khKeiyakuTorikesiWk.getSoukinsakiadr1kj());
        uiBean.setSoukinsakiadr2kj(khKeiyakuTorikesiWk.getSoukinsakiadr2kj());
        uiBean.setSoukinsakiadr3kj(khKeiyakuTorikesiWk.getSoukinsakiadr3kj());
        uiBean.setKyksyaszknmkn(khKeiyakuTorikesiWk.getKyksyaszknmkn());
        uiBean.setKyksyaszknmkj(khKeiyakuTorikesiWk.getKyksyaszknmkj());
        uiBean.setKyksyaszkyno(khKeiyakuTorikesiWk.getKyksyaszkyno());
        uiBean.setKyksyaszkadr1kj(khKeiyakuTorikesiWk.getKyksyaszkadr1kj());
        uiBean.setKyksyaszkadr2kj(khKeiyakuTorikesiWk.getKyksyaszkadr2kj());
        uiBean.setKyksyaszkadr3kj(khKeiyakuTorikesiWk.getKyksyaszkadr3kj());
        uiBean.setYenshrtkumu(khKeiyakuTorikesiWk.getYenshrtkumu());
        uiBean.setInputshrhousiteikbn(khKeiyakuTorikesiWk.getInputshrhousiteikbn());
        uiBean.setBankcd(khKeiyakuTorikesiWk.getBankcd());
        uiBean.setSitencd(khKeiyakuTorikesiWk.getSitencd());
        uiBean.setYokinkbn(khKeiyakuTorikesiWk.getYokinkbn());
        uiBean.setKouzano(khKeiyakuTorikesiWk.getKouzano());
        uiBean.setKzdoukbn(khKeiyakuTorikesiWk.getKzdoukbn());
        uiBean.setKzmeiginmkn(khKeiyakuTorikesiWk.getKzmeiginmkn());
        uiBean.setKykmnmeigibangou(khKeiyakuTorikesiWk.getKykmnmeigibangou());
        uiBean.setUktmnmeigibangou(khKeiyakuTorikesiWk.getUktmnmeigibangou());
        uiBean.setHonninkakninkekkakbn(khKeiyakuTorikesiWk.getHonninkakninkekkakbn());
        uiBean.setSoukinsakikbn(khKeiyakuTorikesiWk.getSoukinsakikbn());

    }

    void pushNyuuryokubtnBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        checkKykSonzai(uiBean.getSyono());

        checkYuukouJyoutai();

        checkTetudukiTyuui(uiBean.getSyono());

        checkSbhsyukeiyaku(uiBean.getSyono());

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);
        hanteiSyoriKengen.exec();

        setUiBean();

        setWarningMessage();

        if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn())) {
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_COOLINGOFF);
        }

        if (C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn())) {
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI);
        }

        if (C_KyktrksKbn.MUKOU.eq(uiBean.getKyktrkskbn())) {
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MUKOU);
        }

        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIJYO);
            uiBean.setSyoruiukeymd(BizDate.getSysDate());
        }

        if (C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUKBRPARI);
        }

        if (C_KyktrksKbn.SBMUKOU_SIHARAI_NASI.eq(uiBean.getKyktrkskbn())) {
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUSHRNASI);
        }

        if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUKAIJYO);
            uiBean.setSyoruiukeymd(BizDate.getSysDate());
        }

        if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSK);
            uiBean.setSyoruiukeymd(BizDate.getSysDate());
        }

        if (C_KyktrksKbn.SBMENSEKI_SIHARAI_NASI.eq(uiBean.getKyktrkskbn())) {
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSKSHRNASI);
        }
        if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
            if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro())) {
                uiBean.setSoukinsakikbn(C_SoukinsakiKbn.PHURIKZ);
            }
            else if (C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) {
                uiBean.setSoukinsakikbn(C_SoukinsakiKbn.TKSHKSHRKZ);
            }
        }
    }


    void pushSyoukaiBL() {

        BizDate sysDate = BizDate.getSysDate();

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) ||
            C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            IT_AnsyuKihon ansyuKihon = khozenCommonParam.getAnsyuuKihon(uiBean.getSyono());

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            uiBean.setPtuukasyu(henkanTuuka.henkanTuukaTypeToKbn(uiBean.getVhsyusyup().getType()));

            uiBean.setSyohinhanteikbn(SyouhinUtil.hantei(uiBean.getSyusyouhncd()));

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinhanteikbn()) {
                uiBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
            }
            else {
                uiBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.BLNK);
            }

            if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {

                if (uiBean.getKaijyokessaiymd() == null) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_KAIJYOKESSAIYMD.getErrorResourceKey()));
                }

                if (BizDateUtil.compareYmd(uiBean.getKaijyokessaiymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EIA0037,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_KAIJYOKESSAIYMD.getErrorResourceKey()));
                }

                if (BizDateUtil.compareYmd(uiBean.getKaijyokessaiymd(), uiBean.getSyukykymd()) == BizDateUtil.COMPARE_LESSER) {
                    throw new BizLogicException(MessageId.EIA0070,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_KAIJYOKESSAIYMD.getErrorResourceKey()));
                }

                List<IT_KykSyouhn> kykSyouhnLst =  uiBean.getKykKihon().getKykSyouhnsByKouryokuhasseiymdGt(
                    uiBean.getKaijyokessaiymd());

                if (kykSyouhnLst.size() > 0) {
                    throw new BizLogicException(MessageId.EIA0106);
                }

                if (uiBean.getKaijyotuutiymd() == null ) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_KAIJYOTUUTIYMD.getErrorResourceKey()));
                }

                if (BizDateUtil.compareYmd(uiBean.getKaijyotuutiymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EIA0037,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_KAIJYOTUUTIYMD.getErrorResourceKey()));
                }

                if (BizDateUtil.compareYmd(uiBean.getKaijyotuutiymd(), uiBean.getKaijyokessaiymd()) == BizDateUtil.COMPARE_LESSER) {
                    throw new BizLogicException(MessageId.EBA0028,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_KAIJYOTUUTIYMD.getErrorResourceKey()));
                }

                if (uiBean.getSyoruiukeymd() == null) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SYORUIUKEYMD.getErrorResourceKey()));
                }

                if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EIA0037,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SYORUIUKEYMD.getErrorResourceKey()));
                }

                if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), uiBean.getKaijyokessaiymd()) == BizDateUtil.COMPARE_LESSER) {
                    throw new BizLogicException(MessageId.EBA0028,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SYORUIUKEYMD.getErrorResourceKey()));
                }

                CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
                boolean syoriResult = checkYuuyokkngai.exec(uiBean.getSyono(), uiBean.getKaijyokessaiymd());
                if (!syoriResult) {
                    throw new BizLogicException(MessageId.EIA1032,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_KAIJYOKESSAIYMD.getErrorResourceKey()));
                }

                if ((uiBean.getSyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    uiBean.getSyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
                    !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                    HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);
                    HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

                    hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
                    hanteiTmttknJyoutaiBean.setHanteiKijyunymd(uiBean.getKaijyokessaiymd());
                    hanteiTmttknJyoutaiBean.setKykymd(uiBean.getSyukykymd());

                    boolean hanteiResult = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                    if (!hanteiResult) {
                        throw new BizLogicException(MessageId.EBA1052);
                    }
                }
            }

            if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMENSEKI_SIHARAI_NASI.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMUKOU_SIHARAI_NASI.eq(uiBean.getKyktrkskbn())) {

                if (uiBean.getSibouymd() == null) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SIBOUYMD.getErrorResourceKey()));
                }

                if (BizDateUtil.compareYmd(uiBean.getSibouymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EIA0037,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SIBOUYMD.getErrorResourceKey()));
                }

                if (BizDateUtil.compareYmd(uiBean.getSibouymd(), uiBean.getSyukykymd()) == BizDateUtil.COMPARE_LESSER) {
                    throw new BizLogicException(MessageId.EIA0070,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SIBOUYMD.getErrorResourceKey()));
                }

                List<IT_KykSyouhn> kykSyouhnLst =  uiBean.getKykKihon().getKykSyouhnsByKouryokuhasseiymdGt(
                    uiBean.getSibouymd());

                if (kykSyouhnLst.size() > 0) {
                    throw new BizLogicException(MessageId.EIA0106);
                }

                CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

                boolean syoriResult = checkYuuyokkngai.exec(uiBean.getSyono(), uiBean.getSibouymd());

                if (!syoriResult) {
                    throw new BizLogicException(MessageId.EIA1032,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SIBOUYMD.getErrorResourceKey()));
                }

                if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

                    if (uiBean.getSyoruiukeymd() == null) {
                        throw new BizLogicException(MessageId.EBC0043,
                            MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SYORUIUKEYMD.getErrorResourceKey()));
                    }

                    if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                        throw new BizLogicException(MessageId.EIA0037,
                            MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SYORUIUKEYMD.getErrorResourceKey()));
                    }

                    if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), uiBean.getSibouymd()) == BizDateUtil.COMPARE_LESSER) {
                        throw new BizLogicException(MessageId.EBA0028,
                            MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SYORUIUKEYMD.getErrorResourceKey()));
                    }

                    if (uiBean.getHubikanryouymd() != null ) {

                        if (BizDateUtil.compareYmd(uiBean.getHubikanryouymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                            throw new BizLogicException(MessageId.EIA0037,
                                MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_HUBIKANRYOUYMD.getErrorResourceKey()));
                        }

                        if (BizDateUtil.compareYmd(uiBean.getHubikanryouymd(), uiBean.getSyoruiukeymd()) == BizDateUtil.COMPARE_LESSER) {
                            throw new BizLogicException(MessageId.EBA0028,
                                MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_HUBIKANRYOUYMD.getErrorResourceKey()));
                        }
                    }

                    if ((uiBean.getSyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        uiBean.getSyohinhanteikbn() == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
                        !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                        HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);
                        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

                        hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
                        hanteiTmttknJyoutaiBean.setHanteiKijyunymd(uiBean.getSibouymd());
                        hanteiTmttknJyoutaiBean.setKykymd(uiBean.getSyukykymd());

                        boolean hanteiResult = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                        if (!hanteiResult) {
                            throw new BizLogicException(MessageId.EBA1052);
                        }
                    }

                    CheckDShrKaiyaku checkDShrKaiyaku = SWAKInjector.getInstance(CheckDShrKaiyaku.class);

                    C_YouhiKbn pMinyuuCheckYouhi = null;

                    if (C_Kykjyoutai.ITIJIBARAI.eq(uiBean.getKykjyoutai())) {
                        pMinyuuCheckYouhi = C_YouhiKbn.HUYOU;
                    }
                    else if (C_Kykjyoutai.HRKMTYUU.eq(uiBean.getKykjyoutai())
                        || C_Kykjyoutai.IKKATUNK.eq(uiBean.getKykjyoutai())
                        || C_Kykjyoutai.ZENNOU.eq(uiBean.getKykjyoutai())) {
                        pMinyuuCheckYouhi = C_YouhiKbn.YOU;
                    }

                    C_ErrorKbn checkDShrErrorKbn = checkDShrKaiyaku.checkDShr(
                        uiBean.getSyono(),
                        uiBean.getSibouymd(),
                        ansyuKihon.getJkipjytym(),
                        pMinyuuCheckYouhi,
                        sysDate);

                    if (C_ErrorKbn.ERROR.eq(checkDShrErrorKbn)) {
                        throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
                    }

                    C_UmuKbn dHuseigouUmu = checkDShrKaiyaku.getDHuseigouUmu();
                    if (C_UmuKbn.ARI.eq(dHuseigouUmu)) {
                        throw new BizLogicException(MessageId.EBS1012);
                    }

                    C_UmuKbn mihaneiDUmu = checkDShrKaiyaku.getMihaneiDUmu();
                    if (C_UmuKbn.ARI.eq(mihaneiDUmu)) {
                        throw new BizLogicException(MessageId.EBA1048);
                    }

                    C_UmuKbn dShrYmdUmu = checkDShrKaiyaku.getDShrYmdUmu();
                    if (C_UmuKbn.ARI.eq(dShrYmdUmu)) {
                        throw new BizLogicException(MessageId.EBA1050,
                            MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SIBOUYMD.getErrorResourceKey()));
                    }
                }
            }
            if (C_KyktrksKbn.MUKOU.eq(uiBean.getKyktrkskbn())) {
                List<IT_KykSyouhn> kykSyouhnLst =  uiBean.getKykKihon().getKykSyouhnsByKouryokuhasseiymdGt(sysDate);

                if (kykSyouhnLst.size() > 0) {
                    throw new BizLogicException(MessageId.EIA0106);
                }
            }

            if (C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMUKOU_SIHARAI_NASI.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMENSEKI_SIHARAI_NASI.eq(uiBean.getKyktrkskbn())) {
                if (C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) {
                    messageManager.addConversationMessageId(
                        KhMessageGroupConstants.GROUP_WARNING2,
                        MessageId.WIA1026);
                }
            }
            if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

                List<IT_KykSyaHenkouRireki> kykSyaHenkouRirekiList =
                    hozenDomManager.getKykSyaHenkouRirekisBySyonoMeigihnkjiyuu(uiBean.getSyono(),C_Meigihnkjiyuu.KYK);

                if (kykSyaHenkouRirekiList.size() > 0) {
                    messageManager.addConversationMessageId(
                        KhMessageGroupConstants.GROUP_WARNING2,
                        MessageId.WIA1016);
                }

                Integer syoruiUkeKyoyou = YuyuHozenConfig.getInstance().getSyoruiUkeKyoyou();
                BizDate syoruiUkeKyoyouDate = uiBean.getSyoruiukeymd().addDays(syoruiUkeKyoyou);

                if (BizDateUtil.compareYmd(sysDate, syoruiUkeKyoyouDate) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYmd(sysDate, syoruiUkeKyoyouDate) == BizDateUtil.COMPARE_EQUAL) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIF1004,
                        MessageUtil.getMessage(DDID_KYKTRKSSYORIINPUTINFO_SYORUIUKEYMD.getErrorResourceKey()),
                        syoruiUkeKyoyou.toString() + "日");
                }

                BizDate calcKijyunYmd = null;

                if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
                    calcKijyunYmd = uiBean.getKaijyokessaiymd();
                }

                if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
                    calcKijyunYmd = uiBean.getSibouymd();
                }

                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getKyktuukasyu());
                uiBean.setSyuCurrencyType(currencyType);

                BizCurrency kaiyakuhrKyktuuka = BizCurrency.valueOf(0, currencyType);
                BizCurrency tmttkngkKyktuuka = BizCurrency.valueOf(0, currencyType);
                BizCurrency ptumitatekinKyktuuka = BizCurrency.valueOf(0, currencyType);
                BizCurrency sjkkkTyouseiGk = BizCurrency.valueOf(0, currencyType);
                BizCurrency teiriTutmttKngk = BizCurrency.valueOf(0, currencyType);
                BizCurrency sisuuRendouTmttKngk = BizCurrency.valueOf(0, currencyType);
                BizCurrency kaiyakukjgk = BizCurrency.valueOf(0, currencyType);
                BizCurrency sbkyhgkKyktuuka = BizCurrency.valueOf(0, currencyType);
                BizCurrency sbkyhgkgaikaKyktuuka = BizCurrency.valueOf(0, currencyType);
                BizCurrency azukariGanrikinKyktuuka = BizCurrency.valueOf(0, currencyType);
                BizCurrency kaiyakuhrgoukeiKyktuuka = BizCurrency.valueOf(0, currencyType);
                BizCurrency zennouseisankinKyktuuka = BizCurrency.valueOf(0, currencyType);
                BizCurrency mikeikapKyktuuka = BizCurrency.valueOf(0, currencyType);
                BizNumber kaiyakukjritu = BizNumber.valueOf(0);
                BizNumber sjkkkTyouseiRt = BizNumber.valueOf(0);
                C_FiSiyouKbn fiSiyouKbn = C_FiSiyouKbn.BLNK;
                BizCurrency sonotaseisan = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency sonotashkkeiYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency zennouseisankgkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency mikeikapYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency azukariGanrikinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency haitoukinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency tkbthaitoukinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency krkgkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizNumber kaiyakuSjkTsRitu  = BizNumber.valueOf(0);
                BizDateYM jkipjytym = null;
                BizCurrency sonotashkkeiKyktuuka = BizCurrency.valueOf(0, currencyType);
                BizCurrency kaiyakuhrgoukeiYen =  BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                int mikeikaPJyutouKaisuuY = 0;
                int mikeikaPJyutouKaisuuM = 0;
                BizDateYM mikeikaPJyutouYM = null;
                MiKeikaPBean[] miKeikaPBeans = null;
                BizDateYM lastPJyuutouYm = null;
                C_UmuKbn zennouMijyuutouFlag = C_UmuKbn.NONE;

                BizCurrency zennouseisankinKnrtuuka;
                BizCurrency mikeikapKnrtuuka;
                if (C_Tuukasyu.JPY.eq(uiBean.getPtuukasyu())) {
                    zennouseisankinKnrtuuka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    mikeikapKnrtuuka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                }
                else {
                    zennouseisankinKnrtuuka = BizCurrency.valueOf(0, currencyType);
                    mikeikapKnrtuuka = BizCurrency.valueOf(0, currencyType);
                }

                KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
                BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(uiBean.getSyukykymd(), calcKijyunYmd,
                    ansyuKihon.getJkipjytym(), uiBean.getHrkkaisuu(), uiBean.getKykjyoutai(), uiBean.getSyusyouhncd(),
                    uiBean.getYendtHnkYmd());

                KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
                C_ErrorKbn errorKbn = keisanWExt.exec(uiBean.getSyono(), calcKijyunYmd);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException("解約返戻金計算拡張情報作成が実行できませんでした。");
                }

                KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
                errorKbn = keisanW.exec(calcKijyunYmd, kaiyakuhrKisnKijyunYM, keisanWExt.getKeisanWExtBean());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException("解約返戻金計算が実行できませんでした。");
                }

                kaiyakuhrKyktuuka = keisanW.getW();
                sjkkkTyouseiGk = keisanW.getSjkkktyouseigk();
                fiSiyouKbn = keisanW.getFiSiyouKbn();
                sjkkkTyouseiRt = keisanW.getSjkkktyouseiritu();
                kaiyakuSjkTsRitu = keisanWExt.getKeisanWExtBean().getKaiyakusjkkktyouseiriritu();
                teiriTutmttKngk = keisanW.getTeirituTmttkngk();
                sisuuRendouTmttKngk = keisanW.getSisuurendouTmttkngk();
                kaiyakukjritu = keisanW.getKaiyakukjritu();
                kaiyakukjgk = keisanW.getKaiyakukjgk();
                sbkyhgkKyktuuka = keisanW.getPruikei();
                uiBean.setFiSiyouKbn(fiSiyouKbn);

                if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinhanteikbn()) {
                    KeisanV keisanV = SWAKInjector.getInstance(KeisanV.class);

                    errorKbn = keisanV.exec(
                        calcKijyunYmd,
                        kaiyakuhrKisnKijyunYM,
                        keisanWExt.getKeisanWExtBean().getKykymd(),
                        keisanWExt.getKeisanWExtBean().getSyouhncd(),
                        keisanWExt.getKeisanWExtBean().getSyouhnsdno(),
                        keisanWExt.getKeisanWExtBean().getRyouritusdno(),
                        keisanWExt.getKeisanWExtBean().getYoteiriritu(),
                        keisanWExt.getKeisanWExtBean().getHrkkaisuu(),
                        keisanWExt.getKeisanWExtBean().getHhknsei(),
                        keisanWExt.getKeisanWExtBean().getHhknnen(),
                        keisanWExt.getKeisanWExtBean().getHknkknsmnkbn(),
                        keisanWExt.getKeisanWExtBean().getHknkkn(),
                        keisanWExt.getKeisanWExtBean().getHrkkknsmnkbn(),
                        keisanWExt.getKeisanWExtBean().getHrkkkn(),
                        keisanWExt.getKeisanWExtBean().getKihons(),
                        keisanW.getKeikanensuu(),
                        keisanW.getKeikatukisuu(),
                        keisanWExt.getKeisanWExtBean().getTuukasyu(),
                        keisanWExt.getKeisanWExtBean().getHokenryou(),
                        uiBean.getTyksenhokanhouKbn(),
                        keisanWExt.getKeisanWExtBean().getKykJyoutai(),
                        keisanWExt.getKeisanWExtBean().getDai1hknkkn());

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException("保険料積立金計算が実行できませんでした。");
                    }

                    tmttkngkKyktuuka = keisanV.getV();

                    CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
                    errorKbn = calcHkShrKngk.execByKeisanWExt(uiBean.getSyono(),
                        calcKijyunYmd, C_SiinKbn.SP, C_HokenkinsyuruiKbn.SBHOKENKIN, uiBean.getVhsyusdpdkbn(),
                        uiBean.getHrkkeiro());

                    if (C_ErrorKbn.ERROR.eq(errorKbn)){
                        throw new CommonBizAppException("保険金額計算が実行できませんでした。");
                    }

                    sbkyhgkgaikaKyktuuka = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();
                }
                else {
                    tmttkngkKyktuuka = keisanW.getV();
                }

                if (C_Kykjyoutai.HRKMTYUU.eq(uiBean.getKykjyoutai()) ||
                    C_Kykjyoutai.IKKATUNK.eq(uiBean.getKykjyoutai()) ||
                    C_Kykjyoutai.ZENNOU.eq(uiBean.getKykjyoutai())) {
                    if (C_Kykjyoutai.ZENNOU.eq(uiBean.getKykjyoutai())) {
                        if (BizDateUtil.compareYmd(calcKijyunYmd,
                            BizDate.valueOf(ansyuKihon.getJkipjytym(), uiBean.getSyukykymd().getDay()).getRekijyou()) == BizDateUtil.COMPARE_LESSER) {
                            List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();
                            SortIT_Zennou sortIT_Zennou = SWAKInjector.getInstance(SortIT_Zennou.class);
                            zennouLst = sortIT_Zennou.OrderIT_ZennouByPkDesc(zennouLst);
                            IT_Zennou zennou = zennouLst.get(0);

                            uiBean.setRyosyuymd(zennou.getRyosyuymd());

                            KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);

                            C_ErrorKbn keisanZennouSeisanGkErrorKbn = keisanZennouSeisanGk2.exec(calcKijyunYmd,
                                uiBean.getSyono());

                            if (C_ErrorKbn.ERROR.eq(keisanZennouSeisanGkErrorKbn)) {
                                throw new CommonBizAppException("前納精算額計算が実行できませんでした。");
                            }

                            zennouseisankinKnrtuuka = keisanZennouSeisanGk2.getZennouSeisanGk();
                            jkipjytym = keisanZennouSeisanGk2.getLastPJyuutouYm().addYears(1);
                            lastPJyuutouYm = keisanZennouSeisanGk2.getLastPJyuutouYm();

                        }
                        else {
                            jkipjytym = ansyuKihon.getJkipjytym();
                            zennouMijyuutouFlag = C_UmuKbn.ARI;

                            messageManager.addConversationMessageId(
                                KhMessageGroupConstants.GROUP_WARNING2,
                                MessageId.WIA1018);

                            messageManager.addConversationMessageId(
                                KhMessageGroupConstants.GROUP_WARNING2,
                                MessageId.WIA1019);
                        }
                    }
                    else {
                        jkipjytym = ansyuKihon.getJkipjytym();
                    }

                    KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
                    keisanMsyMkeiP.exec(uiBean.getSyono(), calcKijyunYmd, jkipjytym, uiBean.getHokenryou(),
                        C_MisyuptsKbn.MITS);

                    mikeikapKnrtuuka = keisanMsyMkeiP.getMikeikaP();
                    mikeikaPJyutouKaisuuY = keisanMsyMkeiP.getMikeikaPJyutouKaisuuY();
                    mikeikaPJyutouKaisuuM = keisanMsyMkeiP.getMikeikaPJyutouKaisuuM();
                    mikeikaPJyutouYM = keisanMsyMkeiP.getMikeikaPJyutouYM();
                    miKeikaPBeans = keisanMsyMkeiP.getMiKeikaPBeans();
                }

                KeisanAzukariGanrikin keisanAzukariGanrikin = SWAKInjector.getInstance(KeisanAzukariGanrikin.class);

                C_ErrorKbn keisanAzukariGanrikinErrorKbn = keisanAzukariGanrikin.exec(uiBean.getSyono(), calcKijyunYmd,
                    uiBean.getKyktuukasyu());

                if (C_ErrorKbn.ERROR.eq(keisanAzukariGanrikinErrorKbn)) {
                    throw new CommonBizAppException("預り元利金計算が実行できませんでした。");
                }

                azukariGanrikinKyktuuka = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();
                azukariGanrikinYen = keisanAzukariGanrikin.getAzukariGanrikinYen();

                if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
                    KeisanDCommonKaiyaku keisanDCommonKaiyaku = SWAKInjector.getInstance(KeisanDCommonKaiyaku.class);
                    C_ErrorKbn calcDShrgkErrorKbn = keisanDCommonKaiyaku.calcDShrgk(
                        uiBean.getSyono(),
                        calcKijyunYmd,
                        sysDate,
                        ansyuKihon.getJkipjytym());

                    if (C_ErrorKbn.ERROR.eq(calcDShrgkErrorKbn)) {
                        throw new CommonBizAppException("配当共通計算（解約）が実行できませんでした。");
                    }

                    haitoukinYen = keisanDCommonKaiyaku.getDShrkn();
                    tkbthaitoukinYen = keisanDCommonKaiyaku.getTkbtD();

                    C_NaiteiKakuteiKbn naiteikakuteikbn = keisanDCommonKaiyaku.getKhHaitouKanriNaiteiKakuteiKbn();

                    if (naiteikakuteikbn != null) {

                        if (C_NaiteiKakuteiKbn.NAITEI.eq(naiteikakuteikbn)) {
                            uiBean.setShrtysyKurikosiYouhi(C_YouhiKbn.YOU);
                        }
                        else if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteikakuteikbn)) {
                            uiBean.setShrtysyKurikosiYouhi(C_YouhiKbn.HUYOU);
                        }

                    }
                    else {
                        uiBean.setShrtysyKurikosiYouhi(C_YouhiKbn.HUYOU);
                    }
                }

                Map<CurrencyType, BizCurrency> krkgkMap = uiBean.getKykKihon().getKariukekinSumKrkgkByKrkseisanzumiflg(
                    C_Krkseisanzumiflg.SUMI);

                if (krkgkMap.size() != 0) {
                    krkgkYen = krkgkMap.get(BizCurrencyTypes.YEN);
                }

                if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
                    uiBean.setSyoruiKanbiYmd(uiBean.getSyoruiukeymd());
                }
                else {
                    if (uiBean.getHubikanryouymd() != null) {
                        uiBean.setSyoruiKanbiYmd(uiBean.getHubikanryouymd());
                    }
                    else {
                        uiBean.setSyoruiKanbiYmd(uiBean.getSyoruiukeymd());
                    }
                }
                BizNumber kawaserate = BizNumber.ZERO;
                BizNumber kawaserateGaika = BizNumber.ZERO;

                if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {

                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                    getKawaseRate.exec(uiBean.getSyoruiKanbiYmd(), C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        uiBean.getKyktuukasyu(),C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.SYUKKINRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.YOU);

                    uiBean.setKwsratekjYmd(getKawaseRate.getKwsrateKjYmd());
                    uiBean.setShrkwsrate(getKawaseRate.getKawaserate());
                    uiBean.setShrkwsratekjnYmd(getKawaseRate.getKwsrateKjYmd());
                    kawaserate = getKawaseRate.getKawaserate();
                    uiBean.setShrkyktuukasyu(uiBean.getKyktuukasyu());

                    getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                    getKawaseRate.exec(uiBean.getSyoruiKanbiYmd(), C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        uiBean.getKyktuukasyu(),C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.YOU);

                    uiBean.setSntshrgkssgikshrratetekiymd(getKawaseRate.getKwsrateKjYmd());
                    uiBean.setSntshrgkssgikshrrate(getKawaseRate.getKawaserate());
                    kawaserateGaika = getKawaseRate.getKawaserate();
                    uiBean.setSntshrgkssgikshrkyktuukasyu(uiBean.getKyktuukasyu());

                    int kawaserateMinasiKbn;

                    int compareResult = BizDateUtil.compareYmd(uiBean.getKwsratekjYmd(),
                        uiBean.getSyoruiKanbiYmd());

                    if (compareResult == BizDateUtil.COMPARE_LESSER) {
                        kawaserateMinasiKbn = KAWASERATE_MINASI;
                    }
                    else {
                        kawaserateMinasiKbn = KAWASERATE_SEIJYOU;
                    }

                    uiBean.setKawaserateMinasiKbn(kawaserateMinasiKbn);

                    if (kawaserateMinasiKbn == KAWASERATE_MINASI) {

                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIA1003);
                    }
                }
                else {

                    uiBean.setKawaserateMinasiKbn(KAWASERATE_SEIJYOU);

                    uiBean.setYenshrtkumu(C_UmuKbn.NONE);
                }

                if (C_FiSiyouKbn.TJTSI.eq(fiSiyouKbn)) {

                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIA1002);
                }

                if (!C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
                    List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono(uiBean.getSyono());
                    if (khHenreikinLst.size() > 0) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIA1017);
                    }
                }

                if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {

                    BizCurrency yenkansangaku;

                    if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                        yenkansangaku = kaiyakuhrKyktuuka;
                        zennouseisankinKyktuuka = zennouseisankinKnrtuuka;
                        zennouseisankgkYen = zennouseisankinKnrtuuka;
                        mikeikapKyktuuka = mikeikapKnrtuuka;
                        mikeikapYen = mikeikapKnrtuuka;
                    }
                    else {
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        yenkansangaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY,kaiyakuhrKyktuuka,
                            kawaserate,C_HasuusyoriKbn.AGE);

                        if (C_Tuukasyu.JPY.eq(uiBean.getPtuukasyu())) {
                            zennouseisankgkYen = zennouseisankinKnrtuuka;
                            mikeikapYen = mikeikapKnrtuuka;
                        }
                        else {
                            zennouseisankinKyktuuka = zennouseisankinKnrtuuka;
                            mikeikapKyktuuka = mikeikapKnrtuuka;
                        }
                    }

                    if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
                        List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono(uiBean.getSyono());
                        if (khHenreikinLst.size() > 0) {
                            sonotaseisan = khHenreikinLst.get(0).getHenreikingk();
                        }
                    }

                    if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                        kaiyakuhrgoukeiKyktuuka = kaiyakuhrKyktuuka.add(azukariGanrikinKyktuuka).add(
                            zennouseisankinKyktuuka).add(mikeikapKyktuuka);

                        sonotashkkeiYen = zennouseisankgkYen.add(mikeikapYen).add(
                            azukariGanrikinYen).add(krkgkYen).add(haitoukinYen).add(tkbthaitoukinYen);

                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        kaiyakuhrgoukeiYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            kaiyakuhrgoukeiKyktuuka, kawaserate, C_HasuusyoriKbn.AGE);

                        keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        sonotashkkeiKyktuuka = keisanGaikakanzan.execDivide(uiBean.getKyktuukasyu(),
                            sonotashkkeiYen, kawaserateGaika, C_HasuusyoriKbn.AGE);

                        uiBean.setShrgkgoukeisyoukai(kaiyakuhrgoukeiKyktuuka.add(sonotashkkeiKyktuuka));
                        uiBean.setJpyshrgkgoukeisyoukai(kaiyakuhrgoukeiYen.add(sonotashkkeiYen));

                    }
                    else {
                        kaiyakuhrgoukeiKyktuuka = kaiyakuhrKyktuuka.add(zennouseisankinKyktuuka).add(mikeikapKyktuuka);
                        kaiyakuhrgoukeiYen = kaiyakuhrKyktuuka.add(zennouseisankinKyktuuka).add(mikeikapKyktuuka);
                        sonotashkkeiKyktuuka = sonotaseisan.add(haitoukinYen).add(tkbthaitoukinYen).add(krkgkYen);
                        sonotashkkeiYen = sonotaseisan.add(haitoukinYen).add(tkbthaitoukinYen).add(krkgkYen);

                        uiBean.setShrgkgoukeisyoukai(yenkansangaku.add(sonotaseisan).add(haitoukinYen).add(
                            tkbthaitoukinYen).add(zennouseisankinKyktuuka).add(mikeikapKyktuuka).add(krkgkYen));
                        uiBean.setJpyshrgkgoukeisyoukai(yenkansangaku.add(sonotaseisan).add(haitoukinYen).add(
                            tkbthaitoukinYen).add(zennouseisankinKyktuuka).add(mikeikapKyktuuka).add(krkgkYen));
                        uiBean.setYendthnkshrgkgoukeisyoukai(yenkansangaku.add(sonotaseisan).add(haitoukinYen).add(
                            tkbthaitoukinYen).add(zennouseisankinKyktuuka).add(mikeikapKyktuuka).add(krkgkYen));
                    }

                    uiBean.setKaiyakuhr(kaiyakuhrKyktuuka);
                    uiBean.setMikeikap(mikeikapKyktuuka);
                    if (C_UmuKbn.ARI.eq(zennouMijyuutouFlag)) {
                        uiBean.setZennouseisankgk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setZennouseisankgk(zennouseisankinKyktuuka);
                    }
                    uiBean.setAzukarikinkykhnkkaiyakuhr(azukariGanrikinKyktuuka);
                    uiBean.setSonotashrgk(sonotashkkeiKyktuuka);
                    uiBean.setDisptienrskkisanymdnissuu(MessageUtil.getMessage(MessageId.IBC1005));
                    uiBean.setSntshrgksssonotashrgk(sonotashkkeiKyktuuka);
                    uiBean.setSntshrgkssyensonotashrgk(sonotashkkeiYen);
                    uiBean.setSntshrgkssyenkamikeikap(mikeikapYen);
                    if (C_UmuKbn.ARI.eq(zennouMijyuutouFlag)) {
                        uiBean.setSntshrgkssyenzennousisnkgk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setSntshrgkssyenzennousisnkgk(zennouseisankgkYen);
                    }
                    uiBean.setSntshrgkssyenazukarikin(azukariGanrikinYen);
                    uiBean.setSntshrgkssyenhaitoukin(haitoukinYen);
                    uiBean.setSntshrgkssyentkbthaitoukin(tkbthaitoukinYen);
                    uiBean.setSntshrgkssyenkakrkgk(krkgkYen);
                    uiBean.setKaiyakuhryen(kaiyakuhrgoukeiYen);
                    uiBean.setYendthnkkaiyakuhr(kaiyakuhrKyktuuka);
                    uiBean.setSonotaseisan(sonotaseisan);
                    uiBean.setYenkamikeikap(mikeikapYen);
                    if (C_UmuKbn.ARI.eq(zennouMijyuutouFlag)) {
                        uiBean.setYenkazennouseisankgk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setYenkazennouseisankgk(zennouseisankgkYen);
                    }
                    uiBean.setYenazukarikinkykhnkmikeikap(azukariGanrikinYen);
                    uiBean.setYenkahaitoukin(haitoukinYen);
                    uiBean.setYentkbthaitoukin(tkbthaitoukinYen);
                    uiBean.setYenkakrkgk(krkgkYen);
                    uiBean.setDispjptienrskkisanymdnissuu(MessageUtil.getMessage(MessageId.IBC1005));
                    uiBean.setShrsyousaikaiyakuhr(kaiyakuhrKyktuuka);
                    uiBean.setShrsyousaijpykaiyakuhr(yenkansangaku);
                    uiBean.setYenshrratetekiymd(uiBean.getKwsratekjYmd());
                    uiBean.setYenshrrate(kawaserate);
                    uiBean.setKiykhrsyousaikaiyakuhr(kaiyakuhrKyktuuka);
                    uiBean.setKiykhrsyousaiptumitatekin(tmttkngkKyktuuka);
                    uiBean.setKiykhrsyousaisjkkktyouseirt(sjkkkTyouseiRt.multiply(100));
                    uiBean.setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRitu);
                    uiBean.setKiykhrsyousaikaiyakukjgk(kaiyakukjgk.multiply(-1));
                    uiBean.setKaiyakukjgk(kaiyakukjgk);
                    uiBean.setKiykhrsyousaikaiyakukjritu(kaiyakukjritu.multiply(100));
                    uiBean.setKaiyakukjritu(kaiyakukjritu);
                    uiBean.setKiykhrsyousaisjkkktyouseigk(sjkkkTyouseiGk);
                    uiBean.setSjkkktyouseirt(sjkkkTyouseiRt);
                    uiBean.setPtumitatekinssptumitatekin(tmttkngkKyktuuka);
                    uiBean.setTeiritutmttkngk(teiriTutmttKngk);
                    uiBean.setSisuurendoutmttkngk(sisuuRendouTmttKngk);
                    uiBean.setKaiyakuhrptumitatekingoukeiYen(kaiyakuhrgoukeiYen);
                    uiBean.setKaiyakuhrptumitatekingoukeiKyktuuka(kaiyakuhrgoukeiKyktuuka);
                    uiBean.setYenkiykhrssyenkiykhrgoukei(kaiyakuhrgoukeiYen);
                    uiBean.setYenkiykhrssyenshrratetkymd(uiBean.getKwsratekjYmd());
                    uiBean.setYenkiykhrssyenshrratete(kawaserate);
                    uiBean.setYenkiykhrssshrkyktuukasyu(uiBean.getShrkyktuukasyu());
                    uiBean.setYenkiykhrsskaiyakuhrgoukei(kaiyakuhrgoukeiKyktuuka);
                    uiBean.setYenkiykhrsskaiyakuhryen(kaiyakuhrKyktuuka);
                    uiBean.setYenkiykhrssmikeikap(mikeikapKyktuuka);
                    if (C_UmuKbn.ARI.eq(zennouMijyuutouFlag)) {
                        uiBean.setYenkiykhrsszennouseisankin(BizCurrency.optional());
                    }
                    else {
                        uiBean.setYenkiykhrsszennouseisankin(zennouseisankinKyktuuka);
                    }
                    uiBean.setYenkiykhrsskykhnkkaiyakuhr(azukariGanrikinKyktuuka);
                    uiBean.setCalcKijyunYmd(calcKijyunYmd);
                    uiBean.setZennouseisankinKnrtuuka(zennouseisankinKnrtuuka);
                    uiBean.setMikeikapKnrtuuka(mikeikapKnrtuuka);
                    uiBean.setMikeikaPJyutouKaisuuY(mikeikaPJyutouKaisuuY);
                    uiBean.setMikeikaPJyutouKaisuuM(mikeikaPJyutouKaisuuM);
                    uiBean.setMikeikaPJyutouYM(mikeikaPJyutouYM);
                    uiBean.setMiKeikaPBeans(miKeikaPBeans);
                    uiBean.setJkipjytym(ansyuKihon.getJkipjytym());
                    uiBean.setLastPJyuutouYm(lastPJyuutouYm);
                    uiBean.setZennouMijyuutouFlag(zennouMijyuutouFlag);
                    uiBean.setZeimuSyutaruShrgkKykTuuka(kaiyakuhrKyktuuka);
                }

                if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
                    if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == uiBean.getSyohinhanteikbn()) {
                        if (tmttkngkKyktuuka.compareTo(sbkyhgkKyktuuka) > 0) {
                            ptumitatekinKyktuuka = sbkyhgkKyktuuka;
                        }
                        else {
                            ptumitatekinKyktuuka = tmttkngkKyktuuka;
                        }

                    }
                    else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ==
                        uiBean.getSyohinhanteikbn()) {
                        if (tmttkngkKyktuuka.compareTo(sbkyhgkgaikaKyktuuka) > 0) {
                            ptumitatekinKyktuuka = sbkyhgkgaikaKyktuuka;
                        }
                        else {
                            ptumitatekinKyktuuka = tmttkngkKyktuuka;
                        }
                    }
                    else {
                        if (tmttkngkKyktuuka.compareTo(kaiyakuhrKyktuuka) < 0) {
                            ptumitatekinKyktuuka = kaiyakuhrKyktuuka;
                        }
                        else {
                            ptumitatekinKyktuuka = tmttkngkKyktuuka;
                        }
                    }

                    BizCurrency yenkansangaku;

                    if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                        yenkansangaku = ptumitatekinKyktuuka;
                        zennouseisankinKyktuuka = zennouseisankinKnrtuuka;
                        zennouseisankgkYen = zennouseisankinKnrtuuka;
                        mikeikapKyktuuka = mikeikapKnrtuuka;
                        mikeikapYen = mikeikapKnrtuuka;
                    }
                    else {
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        yenkansangaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY,ptumitatekinKyktuuka,
                            kawaserate,C_HasuusyoriKbn.AGE);

                        if (C_Tuukasyu.JPY.eq(uiBean.getPtuukasyu())) {
                            zennouseisankgkYen = zennouseisankinKnrtuuka;
                            mikeikapYen = mikeikapKnrtuuka;
                        }
                        else {
                            zennouseisankinKyktuuka = zennouseisankinKnrtuuka;
                            mikeikapKyktuuka = mikeikapKnrtuuka;
                        }
                    }

                    if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                        kaiyakuhrgoukeiKyktuuka = ptumitatekinKyktuuka.add(azukariGanrikinKyktuuka).
                            add(zennouseisankinKyktuuka).add(mikeikapKyktuuka);
                        sonotashkkeiYen = zennouseisankgkYen.add(mikeikapYen).add(
                            azukariGanrikinYen).add(krkgkYen).add(haitoukinYen).add(tkbthaitoukinYen);

                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        kaiyakuhrgoukeiYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            kaiyakuhrgoukeiKyktuuka, kawaserate, C_HasuusyoriKbn.AGE);

                        keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        sonotashkkeiKyktuuka = keisanGaikakanzan.execDivide(uiBean.getKyktuukasyu(),
                            sonotashkkeiYen, kawaserateGaika, C_HasuusyoriKbn.AGE);

                        uiBean.setShrgkgoukeisyoukai(kaiyakuhrgoukeiKyktuuka.add(sonotashkkeiKyktuuka));
                        uiBean.setJpyshrgkgoukeisyoukai(kaiyakuhrgoukeiYen.add(sonotashkkeiYen));
                    }
                    else {
                        kaiyakuhrgoukeiKyktuuka = ptumitatekinKyktuuka.add(zennouseisankinKyktuuka).add(mikeikapKyktuuka);
                        kaiyakuhrgoukeiYen = ptumitatekinKyktuuka.add(zennouseisankinKyktuuka).add(mikeikapKyktuuka);
                        sonotashkkeiKyktuuka = haitoukinYen.add(tkbthaitoukinYen).add(krkgkYen);
                        sonotashkkeiYen = haitoukinYen.add(tkbthaitoukinYen).add(krkgkYen);

                        uiBean.setShrgkgoukeisyoukai(yenkansangaku.add(haitoukinYen).add(tkbthaitoukinYen)
                            .add(zennouseisankinKyktuuka).add(mikeikapKyktuuka).add(krkgkYen));
                        uiBean.setJpyshrgkgoukeisyoukai(yenkansangaku.add(haitoukinYen).add(tkbthaitoukinYen)
                            .add(zennouseisankinKyktuuka).add(mikeikapKyktuuka).add(krkgkYen));
                        uiBean.setYendthnkshrgkgoukeisyoukai(yenkansangaku.add(haitoukinYen).add(tkbthaitoukinYen)
                            .add(zennouseisankinKyktuuka).add(mikeikapKyktuuka).add(krkgkYen));
                    }

                    uiBean.setPtumitatekin(ptumitatekinKyktuuka);
                    uiBean.setMikeikap(mikeikapKyktuuka);
                    if (C_UmuKbn.ARI.eq(zennouMijyuutouFlag)) {
                        uiBean.setZennouseisankgk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setZennouseisankgk(zennouseisankinKyktuuka);
                    }
                    uiBean.setAzukarikinkykhnkkaiyakuhr(azukariGanrikinKyktuuka);
                    uiBean.setSonotashrgk(sonotashkkeiKyktuuka);
                    uiBean.setDisptienrskkisanymdnissuu(MessageUtil.getMessage(MessageId.IBC1005));
                    uiBean.setSntshrgksssonotashrgk(sonotashkkeiKyktuuka);
                    uiBean.setSntshrgkssyensonotashrgk(sonotashkkeiYen);
                    uiBean.setSntshrgkssyenkamikeikap(mikeikapYen);
                    if (C_UmuKbn.ARI.eq(zennouMijyuutouFlag)) {
                        uiBean.setSntshrgkssyenzennousisnkgk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setSntshrgkssyenzennousisnkgk(zennouseisankgkYen);
                    }
                    uiBean.setSntshrgkssyenazukarikin(azukariGanrikinYen);
                    uiBean.setSntshrgkssyenhaitoukin(haitoukinYen);
                    uiBean.setSntshrgkssyentkbthaitoukin(tkbthaitoukinYen);
                    uiBean.setSntshrgkssyenkakrkgk(krkgkYen);
                    uiBean.setJpyptumitatekin(kaiyakuhrgoukeiYen);
                    uiBean.setYendthnkptumitatekin(ptumitatekinKyktuuka);
                    uiBean.setYenkamikeikap(mikeikapYen);
                    if (C_UmuKbn.ARI.eq(zennouMijyuutouFlag)) {
                        uiBean.setYenkazennouseisankgk(BizCurrency.optional());
                    }
                    else {
                        uiBean.setYenkazennouseisankgk(zennouseisankgkYen);
                    }
                    uiBean.setYenazukarikinkykhnkmikeikap(azukariGanrikinYen);
                    uiBean.setYenkahaitoukin(haitoukinYen);
                    uiBean.setYentkbthaitoukin(tkbthaitoukinYen);
                    uiBean.setYenkakrkgk(krkgkYen);
                    uiBean.setDispjptienrskkisanymdnissuu(MessageUtil.getMessage(MessageId.IBC1005));
                    uiBean.setShrsyousaiptumitatekin(ptumitatekinKyktuuka);
                    uiBean.setShrsyousaijpyptumitatekin(yenkansangaku);
                    uiBean.setYenshrratetekiymd(uiBean.getKwsratekjYmd());
                    uiBean.setYenshrrate(kawaserate);
                    uiBean.setKiykhrsyousaiptumitatekin(ptumitatekinKyktuuka);
                    uiBean.setKaiyakuhrptumitatekingoukeiYen(kaiyakuhrgoukeiYen);
                    uiBean.setKaiyakuhrptumitatekingoukeiKyktuuka(kaiyakuhrgoukeiKyktuuka);
                    uiBean.setYenptmttssyenptmttgoukei(kaiyakuhrgoukeiYen);
                    uiBean.setYenptmttssyenshrratetkymd(uiBean.getKwsratekjYmd());
                    uiBean.setYenptmttssyenshrratete(kawaserate);
                    uiBean.setYenptmttssshrkyktuukasyu(uiBean.getShrkyktuukasyu());
                    uiBean.setYenptmttssptumitategoukei(kaiyakuhrgoukeiKyktuuka);
                    uiBean.setYenptmttssptumitate(ptumitatekinKyktuuka);
                    uiBean.setYenptmttssmikeikap(mikeikapKyktuuka);
                    if (C_UmuKbn.ARI.eq(zennouMijyuutouFlag)) {
                        uiBean.setYenptmttsszennouseisankin(BizCurrency.optional());
                    }
                    else {
                        uiBean.setYenptmttsszennouseisankin(zennouseisankinKyktuuka);
                    }
                    uiBean.setYenptmttsskykhnkkaiyakuhr(azukariGanrikinKyktuuka);
                    uiBean.setCalcKijyunYmd(calcKijyunYmd);
                    uiBean.setZennouseisankinKnrtuuka(zennouseisankinKnrtuuka);
                    uiBean.setMikeikapKnrtuuka(mikeikapKnrtuuka);
                    uiBean.setMikeikaPJyutouKaisuuY(mikeikaPJyutouKaisuuY);
                    uiBean.setMikeikaPJyutouKaisuuM(mikeikaPJyutouKaisuuM);
                    uiBean.setMikeikaPJyutouYM(mikeikaPJyutouYM);
                    uiBean.setMiKeikaPBeans(miKeikaPBeans);
                    uiBean.setJkipjytym(ansyuKihon.getJkipjytym());
                    uiBean.setLastPJyuutouYm(lastPJyuutouYm);
                    uiBean.setZennouMijyuutouFlag(zennouMijyuutouFlag);
                    uiBean.setZeimuSyutaruShrgkKykTuuka(ptumitatekinKyktuuka);
                }
            }

            if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {

                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getKyktuukasyu());

                List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = uiBean.getKykKihon().getNyknJissekiRirekisByNyktrksflg(C_Nyktrksflg.TORIKESI);

                SortIT_NyknJissekiRireki sortIT_NyknJissekiRireki = SWAKInjector.getInstance(SortIT_NyknJissekiRireki.class);

                nyknJissekiRirekiLst = sortIT_NyknJissekiRireki.OrderIT_NyknJissekiRirekiByJyutoustartymAsc(nyknJissekiRirekiLst);

                CurrencyType rstuukatype = henkanTuuka.henkanTuukaKbnToType(nyknJissekiRirekiLst.get(0).getRstuukasyu());

                BizCurrency rsgakugaikaNyuukintuuka = BizCurrency.valueOf(0, rstuukatype);
                BizCurrency krkgkNyuukintuuka = BizCurrency.valueOf(0, rstuukatype);
                uiBean.setMikeikapKnrtuuka(BizCurrency.valueOf(0, rstuukatype));
                uiBean.setZennouseisankinKnrtuuka(BizCurrency.valueOf(0, rstuukatype));
                uiBean.setZennounyuukinkgk(BizCurrency.valueOf(0, currencyType));
                uiBean.setZennounyuukinkgkrstk(BizCurrency.valueOf(0, rstuukatype));
                BizCurrency krkgkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                uiBean.setYenkamikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setYenkazennouseisankgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                BizCurrency kyktuktniRsgakukei = BizCurrency.valueOf(0, currencyType);
                uiBean.setMikeikap(BizCurrency.valueOf(0, currencyType));
                uiBean.setZennouseisankgk(BizCurrency.valueOf(0, currencyType));
                uiBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(0, currencyType));
                uiBean.setYenazukarikinkykhnkmikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                uiBean.setYenkakrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

                if (C_Kykjyoutai.ITIJIBARAI.eq(uiBean.getKykjyoutai())) {
                    if (nyknJissekiRirekiLst.size() > 0) {
                        uiBean.setNykntuukashrgkgoukeisyoukai(nyknJissekiRirekiLst.get(0).getRsgaku());
                        uiBean.setKihrkmp(nyknJissekiRirekiLst.get(0).getRsgaku());
                        uiBean.setRstuukasyu(nyknJissekiRirekiLst.get(0).getRstuukasyu());
                        uiBean.setFstpryosyuymd(nyknJissekiRirekiLst.get(0).getRyosyuymd());
                        uiBean.setHrkp(nyknJissekiRirekiLst.get(0).getHrkp());
                        uiBean.setRyosyukwsrate(nyknJissekiRirekiLst.get(0).getRyosyukwsrate());
                        uiBean.setKrkgk(BizCurrency.valueOf(0, rstuukatype));
                    }
                }
                else {
                    SiwakeHanteiNyknJissekiRirekiBean[] siwakeHanteiNyknJissekiRirekiBeans = null;
                    if (C_Kykjyoutai.ZENNOU.eq(uiBean.getKykjyoutai())) {
                        List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();
                        SortIT_Zennou sortIT_Zennou = SWAKInjector.getInstance(SortIT_Zennou.class);
                        zennouLst = sortIT_Zennou.OrderIT_ZennouByPkDesc(zennouLst);
                        IT_Zennou zennou = zennouLst.get(0);

                        if (nyknJissekiRirekiLst.size() > 0) {
                            rsgakugaikaNyuukintuuka = zennou.getZennounyuukinkgkrstk().add(nyknJissekiRirekiLst.get(0).getRsgaku());
                            uiBean.setRstuukasyu(nyknJissekiRirekiLst.get(0).getRstuukasyu());
                            uiBean.setFstpryosyuymd(nyknJissekiRirekiLst.get(0).getRyosyuymd());
                            kyktuktniRsgakukei = zennou.getZennounyuukinkgk().add(nyknJissekiRirekiLst.get(0).getHrkp());

                            List<SiwakeHanteiNyknJissekiRirekiBean> siwakeHanteiNyknJissekiRirekiBeanLst = Lists.newArrayList();

                            SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean =
                                SWAKInjector.getInstance(SiwakeHanteiNyknJissekiRirekiBean.class);

                            siwakeHanteiNyknJissekiRirekiBean.setRsgaku(nyknJissekiRirekiLst.get(0).getRsgaku());
                            siwakeHanteiNyknJissekiRirekiBean.setHrkp(nyknJissekiRirekiLst.get(0).getHrkp());
                            siwakeHanteiNyknJissekiRirekiBean.setJyutoukaisuum(nyknJissekiRirekiLst.get(0).getJyutoukaisuum());
                            siwakeHanteiNyknJissekiRirekiBean.setJyutoustartym(nyknJissekiRirekiLst.get(0).getJyutoustartym());
                            siwakeHanteiNyknJissekiRirekiBean.setJyutouendym(nyknJissekiRirekiLst.get(0).getJyutouendym());

                            siwakeHanteiNyknJissekiRirekiBeanLst.add(siwakeHanteiNyknJissekiRirekiBean);

                            siwakeHanteiNyknJissekiRirekiBeans = siwakeHanteiNyknJissekiRirekiBeanLst.toArray(
                                new SiwakeHanteiNyknJissekiRirekiBean[siwakeHanteiNyknJissekiRirekiBeanLst.size()]);

                            uiBean.setSiwakeHanteiNyknJissekiRirekiBean(siwakeHanteiNyknJissekiRirekiBeans);
                            uiBean.setRyosyuymd(zennou.getRyosyuymd());
                            uiBean.setZennounyuukinkgk(zennou.getZennounyuukinkgk());
                            uiBean.setZennounyuukinkgkrstk(zennou.getZennounyuukinkgkrstk());
                        }
                    }
                    else {

                        if (nyknJissekiRirekiLst.size() > 0) {

                            List<SiwakeHanteiNyknJissekiRirekiBean> siwakeHanteiNyknJissekiRirekiBeanLst = Lists.newArrayList();

                            for (int i = 0; i < nyknJissekiRirekiLst.size(); i++) {
                                SiwakeHanteiNyknJissekiRirekiBean siwakeHanteiNyknJissekiRirekiBean =
                                    SWAKInjector.getInstance(SiwakeHanteiNyknJissekiRirekiBean.class);

                                siwakeHanteiNyknJissekiRirekiBean.setRsgaku(nyknJissekiRirekiLst.get(i).getRsgaku());
                                siwakeHanteiNyknJissekiRirekiBean.setHrkp(nyknJissekiRirekiLst.get(i).getHrkp());
                                siwakeHanteiNyknJissekiRirekiBean.setJyutoukaisuum(nyknJissekiRirekiLst.get(i).getJyutoukaisuum());
                                siwakeHanteiNyknJissekiRirekiBean.setJyutoustartym(nyknJissekiRirekiLst.get(i).getJyutoustartym());
                                siwakeHanteiNyknJissekiRirekiBean.setJyutouendym(nyknJissekiRirekiLst.get(i).getJyutouendym());
                                rsgakugaikaNyuukintuuka = rsgakugaikaNyuukintuuka.add(nyknJissekiRirekiLst.get(i).getRsgaku());
                                if (!C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI.eq(uiBean.getHijynbrKanritukaHantKbn())) {
                                    kyktuktniRsgakukei = kyktuktniRsgakukei.add(nyknJissekiRirekiLst.get(i).getHrkp());
                                }
                                siwakeHanteiNyknJissekiRirekiBeanLst.add(siwakeHanteiNyknJissekiRirekiBean);
                            }

                            siwakeHanteiNyknJissekiRirekiBeans = siwakeHanteiNyknJissekiRirekiBeanLst.toArray(
                                new SiwakeHanteiNyknJissekiRirekiBean[siwakeHanteiNyknJissekiRirekiBeanLst.size()]);
                            uiBean.setRstuukasyu(nyknJissekiRirekiLst.get(0).getRstuukasyu());
                        }
                        uiBean.setSiwakeHanteiNyknJissekiRirekiBean(siwakeHanteiNyknJissekiRirekiBeans);
                        uiBean.setJkipjytym(ansyuKihon.getJkipjytym());
                    }

                    Map<CurrencyType, BizCurrency> krkgkMap = uiBean.getKykKihon().getKariukekinSumKrkgkByKrkseisanzumiflg(
                        C_Krkseisanzumiflg.SUMI);

                    if (krkgkMap.size() != 0) {
                        krkgkYen = krkgkMap.get(BizCurrencyTypes.YEN);
                        krkgkNyuukintuuka = krkgkMap.get(BizCurrencyTypes.YEN);
                    }

                    uiBean.setNykntuukashrgkgoukeisyoukai(rsgakugaikaNyuukintuuka.add(krkgkNyuukintuuka));
                    uiBean.setKihrkmp(rsgakugaikaNyuukintuuka);
                    uiBean.setYenkakrkgk(krkgkYen);
                    uiBean.setKrkgk(krkgkNyuukintuuka);
                    uiBean.setKyktuktniRsgakukei(kyktuktniRsgakukei);
                }
            }

            if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) ) {
                if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {
                    if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {
                        if (C_Tuukasyu.JPY.eq(uiBean.getRstuukasyu())) {
                            uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
                        }
                        else {
                            uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
                        }
                    }

                    if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
                        if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu()) || C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                            uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
                        }
                        else {
                            uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
                        }
                    }
                }
                else {
                    uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
                }
            }
            else {
                if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                    C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {
                    if (C_Tuukasyu.JPY.eq(uiBean.getRstuukasyu())) {
                        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
                    }
                    else {
                        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
                    }
                }
            }

            SetHituyouSyorui.exec(khozenCommonParam, uiBean);
        }

        if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {
            uiBean.setPatternInputshrhousiteikbn(C_InputShrhousiteiKbn.PATTERN_KHOZEN);
        }
        else {
            uiBean.setPatternInputshrhousiteikbn(C_InputShrhousiteiKbn.PATTERN_DEFAULT);
        }

        if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
            if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro())) {
                uiBean.setPatternSoukinsakikbn(C_SoukinsakiKbn.PATTERN_KH);
            }
            else if (C_UmuKbn.ARI.eq(uiBean.getTeikishrtkykhukaumu())) {
                uiBean.setPatternSoukinsakikbn(C_SoukinsakiKbn.PATTERN_KH_TKSHKSHRKZ);
            }
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHINPUTKEY);
        }
        else if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())) {
            uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHINPUT);
        }
        else if (C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {
            uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHTENKEN);
        }
        else {
            uiBean.setPatternSyorikekkakbn(C_SyorikekkaKbn.PATTERN_KHSYOUNIN);
        }
    }

    void pushKakuninBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            checkProcessKaishi(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        }

        if (!C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) && !C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
            uiBean.setSinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        }

        if ((!uiBean.getShrgkgoukeisyoukai().isOptional()  && uiBean.getShrgkgoukeisyoukai().compareTo(
            BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) ||
            (!uiBean.getJpyshrgkgoukeisyoukai().isOptional() && uiBean.getJpyshrgkgoukeisyoukai().compareTo(
                BizCurrency.valueOf(0,uiBean.getJpyshrgkgoukeisyoukai().getType())) > 0)||
                (!uiBean.getYendthnkshrgkgoukeisyoukai().isOptional()  && uiBean.getYendthnkshrgkgoukeisyoukai().compareTo(
                    BizCurrency.valueOf(0, uiBean.getYendthnkshrgkgoukeisyoukai().getType())) > 0)  ||
                    (!uiBean.getNykntuukashrgkgoukeisyoukai().isOptional() && uiBean.getNykntuukashrgkgoukeisyoukai().compareTo(
                        BizCurrency.valueOf(0, uiBean.getNykntuukashrgkgoukeisyoukai().getType())) > 0 )) {

            if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())|| C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ) {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    uiBean.setShrtuukasyu(C_Tuukasyu.JPY);
                }
                else {
                    uiBean.setShrtuukasyu(uiBean.getKyktuukasyu());
                }
            }

            if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn())|| C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ) {
                uiBean.setShrtuukasyu(uiBean.getRstuukasyu());

            }
        }


        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) ||
            ((C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

                int rikoukityuutuudannissuu = 0;
                if (uiBean.getRikoukityuutuudannissuu() != null) {
                    rikoukityuutuudannissuu = uiBean.getRikoukityuutuudannissuu();
                }

                BizDate syoruiukeymd = uiBean.getSyoruiukeymd().addDays(rikoukityuutuudannissuu);
                if (BizDateUtil.compareYmd(syoruiukeymd, BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EIF1033);
                }

                if (!C_SinsaGendoKknKbn.BD5.eq(uiBean.getSinsagendokknkbn()) &&
                    uiBean.getRikoukityuutuudannissuu() == null) {
                    throw new BizLogicException(MessageId.EIF1033);
                }

            }

            if (C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

                if ((!uiBean.getShrgkgoukeisyoukai().isOptional()  && uiBean.getShrgkgoukeisyoukai().compareTo(
                    BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) ||
                    (!uiBean.getNykntuukashrgkgoukeisyoukai().isOptional() && uiBean.getNykntuukashrgkgoukeisyoukai().compareTo(
                        BizCurrency.valueOf(0, uiBean.getNykntuukashrgkgoukeisyoukai().getType())) > 0 )) {

                    if (C_SoukinsakisiteiKbn.BLNK.eq(uiBean.getSoukinsakisiteikbn())) {
                        throw new BizLogicException(MessageId.EBC0043,
                            MessageUtil.getMessage(DDID_SOUKINSAKISITEIINFO_SOUKINSAKISITEIKBN.getErrorResourceKey()));
                    }

                    if (!C_SoukinsakisiteiKbn.KYK.eq(uiBean.getSoukinsakisiteikbn())) {

                        if ((!BizUtil.isBlank(uiBean.getSoukinsakinmkn()) ||
                            !BizUtil.isBlank(uiBean.getSoukinsakinmkj()) ||
                            !BizUtil.isBlank(uiBean.getSoukinsakiyno()) ||
                            !BizUtil.isBlank(uiBean.getSoukinsakiadr1kj()) ||
                            !BizUtil.isBlank(uiBean.getSoukinsakiadr2kj()) ||
                            !BizUtil.isBlank(uiBean.getSoukinsakiadr3kj())) &&
                            (!BizUtil.isBlank(uiBean.getKyksyaszknmkn()) ||
                                !BizUtil.isBlank(uiBean.getKyksyaszknmkj()) ||
                                !BizUtil.isBlank(uiBean.getKyksyaszkyno()) ||
                                !BizUtil.isBlank(uiBean.getKyksyaszkadr1kj()) ||
                                !BizUtil.isBlank(uiBean.getKyksyaszkadr2kj()) ||
                                !BizUtil.isBlank(uiBean.getKyksyaszkadr3kj()))) {
                            throw new BizLogicException(MessageId.EBF1017);
                        }

                        if (BizUtil.isBlank(uiBean.getSoukinsakinmkn()) &&
                            BizUtil.isBlank(uiBean.getSoukinsakinmkj()) &&
                            BizUtil.isBlank(uiBean.getSoukinsakiyno())  &&
                            BizUtil.isBlank(uiBean.getSoukinsakiadr1kj())  &&
                            BizUtil.isBlank(uiBean.getSoukinsakiadr2kj())  &&
                            BizUtil.isBlank(uiBean.getSoukinsakiadr3kj()) &&
                            BizUtil.isBlank(uiBean.getKyksyaszknmkn())  &&
                            BizUtil.isBlank(uiBean.getKyksyaszknmkj())  &&
                            BizUtil.isBlank(uiBean.getKyksyaszkyno())  &&
                            BizUtil.isBlank(uiBean.getKyksyaszkadr1kj())  &&
                            BizUtil.isBlank(uiBean.getKyksyaszkadr2kj())  &&
                            BizUtil.isBlank(uiBean.getKyksyaszkadr3kj())) {
                            throw new BizLogicException(MessageId.EBF1018);
                        }

                    }
                    else {

                        if ((!BizUtil.isBlank(uiBean.getSoukinsakinmkn()) ||
                            !BizUtil.isBlank(uiBean.getSoukinsakinmkj()) ||
                            !BizUtil.isBlank(uiBean.getSoukinsakiyno()) ||
                            !BizUtil.isBlank(uiBean.getSoukinsakiadr1kj()) ||
                            !BizUtil.isBlank(uiBean.getSoukinsakiadr2kj()) ||
                            !BizUtil.isBlank(uiBean.getSoukinsakiadr3kj())) ||
                            (!BizUtil.isBlank(uiBean.getKyksyaszknmkn()) ||
                                !BizUtil.isBlank(uiBean.getKyksyaszknmkj()) ||
                                !BizUtil.isBlank(uiBean.getKyksyaszkyno()) ||
                                !BizUtil.isBlank(uiBean.getKyksyaszkadr1kj()) ||
                                !BizUtil.isBlank(uiBean.getKyksyaszkadr2kj()) ||
                                !BizUtil.isBlank(uiBean.getKyksyaszkadr3kj()))) {
                            throw new BizLogicException(MessageId.EBF1019);
                        }
                    }

                    if (C_SoukinsakisiteiKbn.SONOTA.eq(uiBean.getSoukinsakisiteikbn())) {
                        boolean kyokaMoji = CheckKana.isKyokaMoji(uiBean.getSoukinsakinmkn());
                        if (!kyokaMoji) {
                            throw new BizLogicException(MessageId.EBC0046,
                                MessageUtil.getMessage(DDID_SOUHUSAKIINFO1_SOUKINSAKINMKN.getErrorResourceKey()));
                        }

                        int kanaNmKyoyou = YuyuBizConfig.getInstance().getKanaNmKyoyou();
                        boolean kyoyouKetaHankaku = CheckKana.isKyoyouKetaHankaku(uiBean.getSoukinsakinmkn(),kanaNmKyoyou);
                        if (!kyoyouKetaHankaku) {
                            throw new BizLogicException(MessageId.EIC0006,
                                MessageUtil.getMessage(DDID_SOUHUSAKIINFO1_SOUKINSAKINMKN.getErrorResourceKey()),
                                String.valueOf(kanaNmKyoyou));
                        }

                        if (BizUtil.isBlank(uiBean.getSoukinsakinmkn())) {
                            throw new BizLogicException(MessageId.EBC0043,
                                MessageUtil.getMessage(DDID_SOUHUSAKIINFO1_SOUKINSAKINMKN.getErrorResourceKey()));
                        }

                        if (BizUtil.isBlank(uiBean.getSoukinsakinmkj())) {
                            throw new BizLogicException(MessageId.EBC0043,
                                MessageUtil.getMessage(DDID_SOUHUSAKIINFO1_SOUKINSAKINMKJ.getErrorResourceKey()));
                        }

                        if (BizUtil.isBlank(uiBean.getSoukinsakiyno())) {
                            throw new BizLogicException(MessageId.EBC0043,
                                MessageUtil.getMessage(DDID_SOUHUSAKIINFO2_SOUKINSAKIYNO.getErrorResourceKey()));
                        }

                        if (BizUtil.isBlank(uiBean.getSoukinsakiadr1kj())) {
                            throw new BizLogicException(MessageId.EBC0043,
                                MessageUtil.getMessage(DDID_SOUHUSAKIINFO2_SOUKINSAKIADR1KJ.getErrorResourceKey()));
                        }

                        BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);
                        BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(uiBean.getSoukinsakiadr1kj(),
                            uiBean.getSoukinsakiadr2kj(), uiBean.getSoukinsakiadr3kj());

                        if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {
                            throw new BizLogicException(MessageId.EBA1003,
                                MessageUtil.getMessage(DDID_SOUHUSAKIINFO2_SOUKINSAKIADR1KJ.getErrorResourceKey()),
                                String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                                String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
                        }
                    }

                    if (C_SoukinsakisiteiKbn.KYKSOUZOKUNIN.eq(uiBean.getSoukinsakisiteikbn())) {
                        boolean kyokaMoji = CheckKana.isKyokaMoji(uiBean.getKyksyaszknmkn());
                        if (!kyokaMoji) {
                            throw new BizLogicException(MessageId.EBC0046,
                                MessageUtil.getMessage(DDID_KYKSYASZKINFO1_KYKSYASZKNMKN.getErrorResourceKey()));
                        }

                        int kanaNmKyoyou = YuyuBizConfig.getInstance().getKanaNmKyoyou();
                        boolean kyoyouKetaHankaku = CheckKana.isKyoyouKetaHankaku(uiBean.getKyksyaszknmkn(),kanaNmKyoyou);
                        if (!kyoyouKetaHankaku) {
                            throw new BizLogicException(MessageId.EIC0006,
                                MessageUtil.getMessage(DDID_KYKSYASZKINFO1_KYKSYASZKNMKN.getErrorResourceKey()),
                                String.valueOf(kanaNmKyoyou));
                        }

                        if (BizUtil.isBlank(uiBean.getKyksyaszknmkn())) {
                            throw new BizLogicException(MessageId.EBC0043,
                                MessageUtil.getMessage(DDID_KYKSYASZKINFO1_KYKSYASZKNMKN.getErrorResourceKey()));
                        }

                        boolean kyksyazknmkjKyokaMoji = CheckMeigininNmKanji.isCheckOK(uiBean.getKyksyaszknmkj(), C_Kojinhjn.KOJIN);
                        if (!kyksyazknmkjKyokaMoji) {
                            throw new BizLogicException(MessageId.EBC0046,
                                MessageUtil.getMessage(DDID_KYKSYASZKINFO1_KYKSYASZKNMKJ.getErrorResourceKey()));
                        }

                        if (BizUtil.isBlank(uiBean.getKyksyaszknmkj())) {
                            throw new BizLogicException(MessageId.EBC0043,
                                MessageUtil.getMessage(DDID_KYKSYASZKINFO1_KYKSYASZKNMKJ.getErrorResourceKey()));
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
                }
            }
            if (uiBean.getYenshrtkumu() == null) {
                throw new BizLogicException(MessageId.EBF1005,
                    MessageUtil.getMessage(DDID_YENSHRTKUMUINFO_YENSHRTKUMU.getErrorResourceKey()));
            }

            C_ErrorKbn errorKbn = C_ErrorKbn. OK;
            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu()) && C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())){
                if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {

                    errorKbn = getKawaseRate.exec(
                        uiBean.getSyoruiukeymd(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                        uiBean.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.JISSEIRATE,
                        C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                        C_YouhiKbn.HUYOU);
                }
                if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

                    if (C_SoukinsakisiteiKbn.KYK.eq(uiBean.getSoukinsakisiteikbn())) {

                        errorKbn = getKawaseRate.exec(
                            uiBean.getSibouymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                            uiBean.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.JISSEIRATE,
                            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                            C_YouhiKbn.HUYOU);
                    }
                    else {
                        errorKbn = getKawaseRate.exec(
                            uiBean.getSibouymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                            uiBean.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTB,
                            C_KawasetsryKbn.JISSEIRATE,
                            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                            C_YouhiKbn.HUYOU);
                    }
                }

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizLogicException(MessageId.EIA1013);
                }

                uiBean.setZeimukwsratekjnymd(getKawaseRate.getKwsrateKjYmd());
                uiBean.setZeimukwsrate(getKawaseRate.getKawaserate());
                uiBean.setZeimukyktuukasyu(uiBean.getKyktuukasyu());
            }

            if (C_UmuKbn.ARI.eq(uiBean.getZennouMijyuutouFlag())) {
                if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                    C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                    C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {
                    throw new BizLogicException(MessageId.EIA1063, "");
                }

                if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                    !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
                    C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()))) {
                    throw new BizLogicException(MessageId.EIA1063, "");
                }
            }

            if ((!uiBean.getShrgkgoukeisyoukai().isOptional()  && uiBean.getShrgkgoukeisyoukai().compareTo(
                BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) ||
                (!uiBean.getJpyshrgkgoukeisyoukai().isOptional() && uiBean.getJpyshrgkgoukeisyoukai().compareTo(
                    BizCurrency.valueOf(0,uiBean.getJpyshrgkgoukeisyoukai().getType())) > 0)||
                    (!uiBean.getYendthnkshrgkgoukeisyoukai().isOptional()  && uiBean.getYendthnkshrgkgoukeisyoukai().compareTo(
                        BizCurrency.valueOf(0, uiBean.getYendthnkshrgkgoukeisyoukai().getType())) > 0)  ||
                        (!uiBean.getNykntuukashrgkgoukeisyoukai().isOptional() && uiBean.getNykntuukashrgkgoukeisyoukai().compareTo(
                            BizCurrency.valueOf(0, uiBean.getNykntuukashrgkgoukeisyoukai().getType())) > 0)) {

                if (C_InputShrhousiteiKbn.BLNK.eq(uiBean.getInputshrhousiteikbn())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_INPUTSHRHOUSITEIKBNINFO_INPUTSHRHOUSITEIKBN.getErrorResourceKey()));
                }

                if ((C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(uiBean.getInputshrhousiteikbn()) ||
                    C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) &&
                    (!BizUtil.isBlank(uiBean.getBankcd()) || !BizUtil.isBlank(uiBean.getSitencd()) ||
                        !C_YokinKbn.BLNK.eq(uiBean.getYokinkbn()) || !BizUtil.isBlank(uiBean.getKouzano()) ||
                        !C_Kzdou.BLNK.eq(uiBean.getKzdoukbn()) || !BizUtil.isBlank(uiBean.getKzmeiginmkn()))) {
                    throw new BizLogicException(MessageId.EBA0108,MessageUtil.getMessage(MessageId.IKW0012));
                }

                if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())){
                    if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn())) {
                        if (!C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                            throw new BizLogicException(MessageId.EIA1033);
                        }
                    }

                    if (C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn())) {
                        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
                            if (C_Tuukasyu.JPY.eq(uiBean.getTeikishrkinshrtuukasyu())) {
                                if (!C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                                    throw new BizLogicException(MessageId.EIA1072, "円貨支払申出あり");
                                }
                            }
                            else {
                                if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                                    throw new BizLogicException(MessageId.EIA1072, "円貨支払申出なし");
                                }
                            }
                        }
                        else if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) ||
                            C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn())) {
                            if (!uiBean.getTeikishrkinshrtuukasyu().eq(uiBean.getShrtuukasyu())) {
                                throw new BizLogicException(MessageId.EIA1073, "定期支払金支払口座の支払通貨種類",
                                    "契約時の入金通貨種類", MessageUtil.getMessage(MessageId.IIW3019));
                            }
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

                            throw new BizLogicException(MessageId.EBA0108, MessageUtil.getMessage(MessageId.IKW0012));
                        }
                    }

                    KhCheckKouza khCheckKouza = SWAKInjector.getInstance(KhCheckKouza.class);
                    khCheckKouza.chkSoukinsakiKouza(uiBean, khozenCommonParam);

                    uiBean.setBanknmkj(khCheckKouza.getGinkouName());
                    uiBean.setSitennmkj(khCheckKouza.getShitenName());

                    if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())|| C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ) {
                        if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu()) || C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                            uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
                        }
                        else {
                            uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
                        }
                    }
                }
                else {
                    uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
                }
            }

            if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_HONNINKAKUNININFO_HONNINKAKNINKEKKAKBN.getErrorResourceKey()));
            }
            if ((!uiBean.getShrgkgoukeisyoukai().isOptional()  && uiBean.getShrgkgoukeisyoukai().compareTo(
                BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) ||
                (!uiBean.getJpyshrgkgoukeisyoukai().isOptional() && uiBean.getJpyshrgkgoukeisyoukai().compareTo(
                    BizCurrency.valueOf(0,uiBean.getJpyshrgkgoukeisyoukai().getType())) > 0)||
                    (!uiBean.getYendthnkshrgkgoukeisyoukai().isOptional()  && uiBean.getYendthnkshrgkgoukeisyoukai().compareTo(
                        BizCurrency.valueOf(0, uiBean.getYendthnkshrgkgoukeisyoukai().getType())) > 0)  ||
                        (!uiBean.getNykntuukashrgkgoukeisyoukai().isOptional() && uiBean.getNykntuukashrgkgoukeisyoukai().compareTo(
                            BizCurrency.valueOf(0, uiBean.getNykntuukashrgkgoukeisyoukai().getType())) > 0 )) {

                KeisanSiharaibi kisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

                BizDate shrYmd = kisanSiharaibi.exec(
                    BizDate.getSysDate(),
                    uiBean.getInputshrhousiteikbn(),
                    uiBean.getShrtuukasyu(),
                    uiBean.getBankcd());

                uiBean.setShrymd(shrYmd);
                uiBean.setShrhousiteikbn(kisanSiharaibi.getShrhousiteiKbn());

                if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())|| C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                    C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ) {
                    if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhousiteikbn())) {

                        KeisanTienrisoku keisanTienrisoku = SWAKInjector.getInstance(KeisanTienrisoku.class);
                        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(
                            uiBean.getSyoruiukeymd(),
                            uiBean.getHubikanryouymd(),
                            uiBean.getShrymd(),
                            uiBean.getShrgkgoukeisyoukai(),
                            uiBean.getRikoukityuutuudannissuu(),
                            uiBean.getSinsagendokknkbn());

                        uiBean.setShrtienrsk(keisanTienrisokuBean.getShrtienrsk());
                        uiBean.setTienrisokukisanymd(keisanTienrisokuBean.getShrtienrskStartYmd());
                        uiBean.setTienrsknissuu(keisanTienrisokuBean.getShrtienNissuu());
                        uiBean.setShrgkgoukeikakunin(uiBean.getShrgkgoukeisyoukai().add(uiBean.getShrtienrsk()));

                        String disptienrskkisanymdnissuu = KhozenEdit.editTienRkksanhi(uiBean.getShrhousiteikbn(),
                            uiBean.getShrtienrsk(), uiBean.getTienrisokukisanymd(), uiBean.getTienrsknissuu());

                        uiBean.setDisptienrskkisanymdnissuu(disptienrskkisanymdnissuu);

                        if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu()) || C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {

                            KeisanTienrisoku newKeisanTienrisoku = SWAKInjector.getInstance(KeisanTienrisoku.class);
                            KeisanTienrisokuBean mewKeisanTienrisokuBean = newKeisanTienrisoku.exec(
                                uiBean.getSyoruiukeymd(),
                                uiBean.getHubikanryouymd(),
                                uiBean.getShrymd(),
                                uiBean.getJpyshrgkgoukeisyoukai(),
                                uiBean.getRikoukityuutuudannissuu(),
                                uiBean.getSinsagendokknkbn());


                            uiBean.setJpyshrtienrsk(mewKeisanTienrisokuBean.getShrtienrsk());
                            uiBean.setJpytienrisokukisanymd(mewKeisanTienrisokuBean.getShrtienrskStartYmd());
                            uiBean.setJpytienrsknissuu(mewKeisanTienrisokuBean.getShrtienNissuu());
                            uiBean.setJpyshrgkgoukeikakunin(uiBean.getJpyshrgkgoukeisyoukai().add(uiBean.getJpyshrtienrsk()));
                            uiBean.setYendthnkshrgkgoukeikakunin(uiBean.getJpyshrgkgoukeisyoukai().add(uiBean.getJpyshrtienrsk()));

                            String dispjptienrskkisanymdnissuu = KhozenEdit.editTienRkksanhi(uiBean.getShrhousiteikbn(),
                                uiBean.getJpyshrtienrsk(), uiBean.getJpytienrisokukisanymd(), uiBean.getJpytienrsknissuu());

                            uiBean.setDispjptienrskkisanymdnissuu(dispjptienrskkisanymdnissuu);

                        }
                    }
                    else {
                        uiBean.setShrgkgoukeikakunin(uiBean.getShrgkgoukeisyoukai());
                        uiBean.setYendthnkshrgkgoukeikakunin(uiBean.getYendthnkshrgkgoukeisyoukai());

                        String disptienrskkisanymdnissuu = KhozenEdit.editTienRkksanhi(uiBean.getShrhousiteikbn(),
                            BizCurrency.optional(), null, null);

                        uiBean.setDisptienrskkisanymdnissuu(disptienrskkisanymdnissuu);
                        uiBean.setDispjptienrskkisanymdnissuu(disptienrskkisanymdnissuu);

                        if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                            uiBean.setJpyshrgkgoukeikakunin(uiBean.getJpyshrgkgoukeisyoukai());
                        }
                    }
                }

                if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())|| C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                    C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ) {
                    KeisanHtyKeihi keisanHtyKeihi = SWAKInjector.getInstance(KeisanHtyKeihi.class);

                    keisanHtyKeihi.exec(
                        uiBean.getSyono(),
                        uiBean.getKyktuukasyu());

                    if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu()) && C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                        uiBean.setHtykeihi(keisanHtyKeihi.getYenHtyKeihi());

                        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ) {
                            uiBean.setSynykngk(uiBean.getKaiyakuhrptumitatekingoukeiYen().add(
                                uiBean.getSntshrgkssyensonotashrgk()).subtract(uiBean.getYenkakrkgk()));
                        }
                        else if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {
                            uiBean.setSynykngk(uiBean.getKaiyakuhrptumitatekingoukeiYen().add(
                                uiBean.getSntshrgkssyensonotashrgk()));
                        }
                        else if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
                            uiBean.setSynykngk(uiBean.getKaiyakuhrptumitatekingoukeiYen().add(
                                uiBean.getSntshrgkssyensonotashrgk()));
                        }
                    }
                    else if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu()) && C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {

                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        BizCurrency yenkansangaku = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            uiBean.getKaiyakuhrptumitatekingoukeiKyktuuka(),
                            uiBean.getZeimukwsrate(),
                            C_HasuusyoriKbn.SUTE);

                        uiBean.setHtykeihi(keisanHtyKeihi.getYenHtyKeihi());

                        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ) {
                            uiBean.setSynykngk(yenkansangaku.add(uiBean.getSntshrgkssyensonotashrgk()).subtract(
                                uiBean.getYenkakrkgk()));

                        }
                        else if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {
                            uiBean.setSynykngk(yenkansangaku.add(uiBean.getSntshrgkssyensonotashrgk()));
                        }
                        else if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
                            uiBean.setSynykngk(yenkansangaku.add(uiBean.getSntshrgkssyensonotashrgk()));
                        }
                    }
                    else if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ) {
                            uiBean.setSynykngk(uiBean.getKaiyakuhrptumitatekingoukeiYen());
                        }
                        else {
                            uiBean.setSynykngk(uiBean.getKaiyakuhrptumitatekingoukeiYen().add(
                                uiBean.getYenkahaitoukin()).add(uiBean.getYentkbthaitoukin()).add(
                                    uiBean.getYenkakrkgk()));
                        }
                        uiBean.setHtykeihi(keisanHtyKeihi.getYenHtyKeihi());
                    }

                    uiBean.setKykHnkKaisuu(keisanHtyKeihi.getKykSyaHenkouKaisuu());

                    if (keisanHtyKeihi.getKykSyaHenkouKaisuu() > 0) {
                        uiBean.setYenshrkykhtykeihi(keisanHtyKeihi.getYenGenKykSyaHtyKeihi());
                    }
                    else {
                        uiBean.setYenshrkykhtykeihi(BizCurrency.valueOf(0));
                    }
                }
                if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn())|| C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                    C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ) {
                    uiBean.setNykntuukashrgkgoukeikakunin(uiBean.getNykntuukashrgkgoukeisyoukai());
                }
            }


            uiBean.setZeimuSyutaruShrgkYen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

            if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

                if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {

                    uiBean.setZeimuSyutaruShrgkYen(uiBean.getZeimuSyutaruShrgkKykTuuka());
                }

                else {

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    BizCurrency yenkansangaku = null;

                    if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {

                        yenkansangaku = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            uiBean.getZeimuSyutaruShrgkKykTuuka(),
                            uiBean.getShrkwsrate(),
                            C_HasuusyoriKbn.SUTE);
                    }
                    else {

                        yenkansangaku = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            uiBean.getZeimuSyutaruShrgkKykTuuka(),
                            uiBean.getZeimukwsrate(),
                            C_HasuusyoriKbn.SUTE);
                    }

                    uiBean.setZeimuSyutaruShrgkYen(yenkansangaku);
                }
            }

            if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

                if (uiBean.getZeimuSyutaruShrgkYen().compareTo(BizCurrency.valueOf(1000000, uiBean.getZeimuSyutaruShrgkYen().getType())) > 0) {
                    if (BizUtil.isBlank(uiBean.getKykmnmeigibangou())) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, MessageId.WIA1010,
                            MessageUtil.getMessage(DDID_MNMEIGIBANGOUINFO_KYKMNMEIGIBANGOU.getErrorResourceKey()));
                    }

                    if (!C_SoukinsakisiteiKbn.KYK.eq(uiBean.getSoukinsakisiteikbn()) &&
                        BizUtil.isBlank(uiBean.getUktmnmeigibangou())) {
                        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, MessageId.WIA1010,
                            MessageUtil.getMessage(DDID_MNMEIGIBANGOUINFO_UKTMNMEIGIBANGOU.getErrorResourceKey()));
                    }

                    uiBean.setShrTysySyuruiKbn(C_HtsiryosyuKbn.UKTRSHRTYOUSYO);
                }
            }

            if (uiBean.getZeimuSyutaruShrgkYen().compareTo(BizCurrency.valueOf(1000000, uiBean.getZeimuSyutaruShrgkYen().getType())) <= 0) {
                if (!BizUtil.isBlank(uiBean.getKykmnmeigibangou())) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, MessageId.WIA1011,
                        MessageUtil.getMessage(DDID_MNMEIGIBANGOUINFO_KYKMNMEIGIBANGOU.getErrorResourceKey()));
                }

                if (!BizUtil.isBlank(uiBean.getUktmnmeigibangou())) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3, MessageId.WIA1011,
                        MessageUtil.getMessage(DDID_MNMEIGIBANGOUINFO_UKTMNMEIGIBANGOU.getErrorResourceKey()));
                }
            }
        }

        CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);
        checkProcessKekka.exec(
            uiBean.getSyorikekkakbn(),
            uiBean.getSyanaicommentkh(),
            uiBean.getSasimodosisakikbn());

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_COOLINGOFF);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_MUKOU);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_KAIJYO);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUKBRPARI);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUSHRNASI);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUKAIJYO);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSK);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSKSHRNASI);
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {

        BizDate sysDate = BizDate.getSysDate();

        String sysTime = BizDate.getSysDateTimeMilli();

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            checkProcessKaishi(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_COOLINGOFF);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_MUKOU);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_KAIJYO);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUKBRPARI);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUSHRNASI);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUKAIJYO);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSK);

            checkProcessKaishi(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSKSHRNASI);

            CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

            C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

            if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
            }

            BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
            bzProcessCreateInBean.setSyoNo(uiBean.getSyono());
            bzProcessCreateInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
            BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

            if (C_KouteiSakuseiKekkaKbn.FAILURE.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0008));
            }
            uiBean.getBzWorkflowInfo().setKouteiKanriId(bzProcessCreateOutBean.getKouteiKanriId());

            bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo()
                .getJimuTetuzukiCd());

            uiBean.setKouteiLockKey(bzCommonLockProcess.getKouteiLockKey());

            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
            bzForceTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),C_KhkinouModeIdKbn.INPUT.getValue(),
                uiBean.getKouteiLockKey());
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) ) {
                if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) ) {
                    BizDate syoumetuYmd = null;
                    C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;
                    C_Syoumetujiyuu syoumetujiyuu = C_Syoumetujiyuu.BLNK;
                    C_ShrsyoriKbn shrsyoriKbn = C_ShrsyoriKbn.BLNK;
                    C_TsrysyoriKbn tsrysyoriKbn = C_TsrysyoriKbn.BLNK;

                    if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) ) {
                        syoumetuYmd = uiBean.getSyukykymd();
                        syoriKbn = C_SyoriKbn.CLGOFF;
                        syoumetujiyuu = C_Syoumetujiyuu.CLGOFF;
                        shrsyoriKbn = C_ShrsyoriKbn.CLGOFF;
                        tsrysyoriKbn = C_TsrysyoriKbn.CLGOFF;
                    }

                    if (C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ) {
                        syoumetuYmd = uiBean.getSyukykymd();
                        syoriKbn = C_SyoriKbn.KYKTORIKESI;
                        syoumetujiyuu = C_Syoumetujiyuu.KYKTORIKESI;
                        shrsyoriKbn = C_ShrsyoriKbn.KYKTORIKESI;
                        tsrysyoriKbn = C_TsrysyoriKbn.KEIYAKUTORIKESI;
                    }

                    if (C_KyktrksKbn.MUKOU.eq(uiBean.getKyktrkskbn()) ) {
                        syoumetuYmd = uiBean.getSyukykymd();
                        syoriKbn = C_SyoriKbn.MUKOU;
                        syoumetujiyuu = C_Syoumetujiyuu.MUKOU;
                        tsrysyoriKbn = C_TsrysyoriKbn.MUKOU;
                    }

                    if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ) {
                        syoumetuYmd = uiBean.getKaijyotuutiymd();
                        syoriKbn = C_SyoriKbn.KAIJO;
                        syoumetujiyuu = C_Syoumetujiyuu.KAIJO;
                        shrsyoriKbn = C_ShrsyoriKbn.KAIJO;
                        tsrysyoriKbn = C_TsrysyoriKbn.KAIJO;
                    }

                    if (C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ) {
                        syoumetuYmd = uiBean.getSibouymd();
                        syoriKbn = C_SyoriKbn.SBMUKOU_KIHRKPSHR;
                        syoumetujiyuu = C_Syoumetujiyuu.SBMUKOU;
                        shrsyoriKbn =  C_ShrsyoriKbn.SBMUKOU_KIHRKPSHR;
                    }

                    if (C_KyktrksKbn.SBMUKOU_SIHARAI_NASI.eq(uiBean.getKyktrkskbn()) ) {
                        syoumetuYmd = uiBean.getSibouymd();
                        syoriKbn = C_SyoriKbn.SBMUKOU_SHRNASI;
                        syoumetujiyuu = C_Syoumetujiyuu.SBMUKOU;
                    }

                    if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ) {
                        syoumetuYmd = uiBean.getSibouymd();
                        syoriKbn = C_SyoriKbn.SBKAIJO;
                        syoumetujiyuu = C_Syoumetujiyuu.SBKAIJO;
                        shrsyoriKbn = C_ShrsyoriKbn.SBKAIJO;
                    }

                    if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ) {
                        syoumetuYmd = uiBean.getSibouymd();
                        syoriKbn = C_SyoriKbn.SBMENSEKI;
                        syoumetujiyuu = C_Syoumetujiyuu.MENSEKI;
                        shrsyoriKbn = C_ShrsyoriKbn.SBMENSEKI;
                    }

                    if (C_KyktrksKbn.SBMENSEKI_SIHARAI_NASI.eq(uiBean.getKyktrkskbn()) ) {
                        syoumetuYmd = uiBean.getSibouymd();
                        syoriKbn = C_SyoriKbn.SBMENSEKI_SHRNASI;
                        syoumetujiyuu = C_Syoumetujiyuu.MENSEKI;
                    }

                    String sikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

                    TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
                    tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetuKey);

                    updateKTKykKihon(sysDate,sysTime);
                    IT_KhTtdkRireki khTtdkRireki = uiBean.getKykKihon().createKhTtdkRireki();
                    khTtdkRireki.setHenkousikibetukey(sikibetuKey);

                    EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);
                    editKykSyhnRirekiTbl.exec(khozenCommonParam, uiBean.getSyono());

                    List<IT_KykSyouhn> kykSyouhnLst = updateKTKykSyouhn(sikibetuKey,syoumetuYmd,syoumetujiyuu,sysTime);

                    PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);
                    pALKykNaiyouKousin.exec(uiBean.getKykKihon());

                    if (C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.MUKOU.eq(uiBean.getKyktrkskbn())){
                        Integer kihrkpSeisanRrk = hozenDomManager.getKhSntkInfoTourokuMaxRennoBySyono(uiBean.getSyono());

                        if (kihrkpSeisanRrk == null || kihrkpSeisanRrk == 0) {
                            kihrkpSeisanRrk = 1;
                        }
                        else {
                            kihrkpSeisanRrk = kihrkpSeisanRrk + 1;
                        }

                        C_KankeisyaKbn kankeisyaKbn = C_KankeisyaKbn.BLNK;
                        if (C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) {
                            kankeisyaKbn = C_KankeisyaKbn.HHKN_KYKDOUITU;
                        }
                        else {
                            kankeisyaKbn = C_KankeisyaKbn.HHKN_KYKBETU;
                        }

                        C_SntkInfoKykTorikesiKbn sntkInfoKykTorikesiKbn =  C_SntkInfoKykTorikesiKbn.BLNK;
                        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
                            sntkInfoKykTorikesiKbn =  C_SntkInfoKykTorikesiKbn.KAIJYO;
                        }
                        if (C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn())) {
                            sntkInfoKykTorikesiKbn =  C_SntkInfoKykTorikesiKbn.TORIKESI;
                        }
                        if (C_KyktrksKbn.MUKOU.eq(uiBean.getKyktrkskbn())) {
                            sntkInfoKykTorikesiKbn =  C_SntkInfoKykTorikesiKbn.MUKOU;
                        }

                        insertKhSntkInfoTouroku(kihrkpSeisanRrk,kankeisyaKbn,sntkInfoKykTorikesiKbn,sysDate,sysTime);

                    }

                    if ((!uiBean.getShrgkgoukeikakunin().isOptional()  && uiBean.getShrgkgoukeikakunin().compareTo(
                        BizCurrency.valueOf(0, uiBean.getShrgkgoukeikakunin().getType())) > 0) ||
                        (!uiBean.getJpyshrgkgoukeikakunin().isOptional() && uiBean.getJpyshrgkgoukeikakunin().compareTo(
                            BizCurrency.valueOf(0,uiBean.getJpyshrgkgoukeikakunin().getType())) > 0)||
                            (!uiBean.getYendthnkshrgkgoukeikakunin().isOptional()  && uiBean.getYendthnkshrgkgoukeikakunin().compareTo(
                                BizCurrency.valueOf(0, uiBean.getYendthnkshrgkgoukeikakunin().getType())) > 0)  ||
                                (!uiBean.getNykntuukashrgkgoukeikakunin().isOptional() && uiBean.getNykntuukashrgkgoukeikakunin().compareTo(
                                    BizCurrency.valueOf(0, uiBean.getNykntuukashrgkgoukeikakunin().getType())) > 0 )) {
                        List<TaisyouGkBean> taisyouGkBeanLst = Lists.newArrayList();
                        boolean kakokawaserateshiteiflg = false;
                        BizDate kakokawaserateshiteiymd = null;
                        BizCurrency jpyshrtienrsk = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
                        BizCurrency gaikashrgk = BizCurrency.valueOf(0);
                        BizCurrency soukingk = BizCurrency.valueOf(0);
                        C_UmuKbn azukarikingkUmuKbn = C_UmuKbn.NONE;

                        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getKyktuukasyu());

                        BizCurrency shrtienrsk = BizCurrency.valueOf(0, currencyType);

                        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ||
                            C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {

                            CommonSiwakeUtil commonSiwakeUtil = SWAKInjector.getInstance(CommonSiwakeUtil.class);

                            commonSiwakeUtil.execPKanjokamokuHantei(uiBean.getShrymd(), uiBean.getSyukykymd(),
                                uiBean.getZennouseisankinKnrtuuka(), uiBean.getRyosyuymd(), uiBean.getJkipjytym(),
                                uiBean.getMikeikapKnrtuuka(), uiBean.getMikeikaPJyutouYM(), uiBean.getMiKeikaPBeans(),
                                khozenCommonParam.getFunctionId(),syoriKbn, uiBean.getKykKihon().getHrkkaisuu(),
                                uiBean.getKykKihon().getTikiktbrisyuruikbn());

                            if (uiBean.getAzukarikinkykhnkkaiyakuhr() != null &&
                                !uiBean.getAzukarikinkykhnkkaiyakuhr().isOptional()) {
                                if (uiBean.getAzukarikinkykhnkkaiyakuhr().compareTo(
                                    BizCurrency.valueOf(0, uiBean.getAzukarikinkykhnkkaiyakuhr().getType())) > 0) {
                                    azukarikingkUmuKbn = C_UmuKbn.ARI;
                                }
                            }

                            if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {

                                BizCurrency taisyouGkSyonendosyokaipKnrtuuka = BizCurrency.valueOf(0, currencyType);
                                BizCurrency taisyouGkSyonendo2kaimeikoupKnrtuuka = BizCurrency.valueOf(0, currencyType);
                                BizCurrency taisyouGkJinendoikoupKnrtuuka = BizCurrency.valueOf(0, currencyType);
                                BizCurrency taisyouGkSonotahenreikinKyktuuka = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSyonendosyokaip = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSyonendo2kaimeikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkJinendoikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSonotahenreikin = BizCurrency.valueOf(0, currencyType);

                                if (C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI.eq(uiBean.getHijynbrKanritukaHantKbn())) {
                                    taisyouGkSyonendosyokaipKnrtuuka = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                    taisyouGkSyonendo2kaimeikoupKnrtuuka = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                    taisyouGkJinendoikoupKnrtuuka = commonSiwakeUtil.getTaisyouGkJinendoikoup();

                                    if (C_UmuKbn.ARI.eq(azukarikingkUmuKbn)) {
                                        BizCurrency taisyouGkSonotahenreikinYen =
                                            commonSiwakeUtil.getTaisyouGkSonotahenreikin().add(uiBean.getYenazukarikinkykhnkmikeikap());

                                        if (taisyouGkSonotahenreikinYen.compareTo(
                                            BizCurrency.valueOf(0, taisyouGkSonotahenreikinYen.getType())) > 0) {

                                            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                                            BizCurrency kanzanGaku = keisanGaikakanzan.execDivide(uiBean.getKyktuukasyu(),
                                                taisyouGkSonotahenreikinYen, uiBean.getSntshrgkssgikshrrate(), C_HasuusyoriKbn.AGE);

                                            taisyouGkSonotahenreikinKyktuuka = kanzanGaku.add(uiBean.getAzukarikinkykhnkkaiyakuhr());
                                        }
                                        else {
                                            taisyouGkSonotahenreikinKyktuuka = uiBean.getAzukarikinkykhnkkaiyakuhr();
                                        }
                                    }
                                    else {
                                        taisyouGkSonotahenreikinKyktuuka = commonSiwakeUtil.getTaisyouGkSonotahenreikin();
                                    }
                                }
                                else {
                                    taisyouGkSyonendosyokaipKnrtuuka = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                    taisyouGkSyonendo2kaimeikoupKnrtuuka = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                    taisyouGkJinendoikoupKnrtuuka = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                                    taisyouGkSonotahenreikinKyktuuka = commonSiwakeUtil.getTaisyouGkSonotahenreikin();
                                    kyktuktngkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                    kyktuktngkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                    kyktuktngkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                                    kyktuktngkSonotahenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin();
                                }

                                if (!C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) {
                                    shrtienrsk = uiBean.getShrtienrsk();
                                }

                                TaisyouGkBean taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);
                                taisyouGkBean.setTaisyouGk(uiBean.getKaiyakuhr());
                                taisyouGkBean.setKeiyakutuukaGk(uiBean.getKaiyakuhr());
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
                                taisyouGkBean.setTaisyouGk(shrtienrsk);
                                taisyouGkBean.setKeiyakutuukaGk(shrtienrsk);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
                                taisyouGkBean.setTaisyouGk(uiBean.getShrgkgoukeikakunin());
                                taisyouGkBean.setKeiyakutuukaGk(uiBean.getShrgkgoukeikakunin());
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
                                taisyouGkBean.setTaisyouGk(uiBean.getYenkakrkgk());
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);
                                taisyouGkBean.setTaisyouGk(uiBean.getYenkahaitoukin().add(uiBean.getYentkbthaitoukin()));
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
                                taisyouGkBean.setTaisyouGk(taisyouGkSyonendosyokaipKnrtuuka);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSyonendosyokaip);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
                                taisyouGkBean.setTaisyouGk(taisyouGkSyonendo2kaimeikoupKnrtuuka);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSyonendo2kaimeikoup);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
                                taisyouGkBean.setTaisyouGk(taisyouGkJinendoikoupKnrtuuka);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkJinendoikoup);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
                                taisyouGkBean.setTaisyouGk(taisyouGkSonotahenreikinKyktuuka);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSonotahenreikin);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                                    gaikashrgk = BizCurrency.valueOf(0);
                                    soukingk = uiBean.getYendthnkshrgkgoukeikakunin();
                                    kakokawaserateshiteiflg = false;
                                }
                                else {
                                    gaikashrgk = uiBean.getShrgkgoukeikakunin();
                                    soukingk = BizCurrency.valueOf(0);
                                    kakokawaserateshiteiflg = true;
                                    kakokawaserateshiteiymd = uiBean.getSyoruiKanbiYmd();
                                }

                                if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
                                    C_Segcd seg1cd = C_Segcd.BLNK;

                                    if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                                        List<IT_KhHenreikin> khHenreikinList =
                                            hozenDomManager.getKhHenreikinYendtMbrsBySyono(uiBean.getSyono());
                                        if (khHenreikinList.size() > 0) {
                                            seg1cd = khHenreikinList.get(0).getSeg1cd();
                                        }
                                    }

                                    taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                    taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_YENDTHNKHR);
                                    taisyouGkBean.setTaisyouGk(uiBean.getSonotaseisan());
                                    taisyouGkBean.setKeiyakutuukaGk(uiBean.getSonotaseisan());
                                    taisyouGkBean.setSeg1cd(seg1cd);
                                    taisyouGkBeanLst.add(taisyouGkBean);
                                }
                            }
                            else {
                                BizCurrency taisyouGkSyonendosyokaip = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                BizCurrency taisyouGkSyonendo2kaimeikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                BizCurrency taisyouGkJinendoikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                BizCurrency taisyouGkSonotahenreikinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                BizCurrency kyktuktngkSyonendosyokaip = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSyonendo2kaimeikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkJinendoikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSonotahenreikin = BizCurrency.valueOf(0, currencyType);

                                if (C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI.eq(uiBean.getHijynbrKanritukaHantKbn())) {
                                    taisyouGkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                    taisyouGkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                    taisyouGkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();

                                    if (uiBean.getAzukarikinkykhnkkaiyakuhr().compareTo(
                                        BizCurrency.valueOf(0, uiBean.getAzukarikinkykhnkkaiyakuhr().getType())) > 0) {

                                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                                        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                            uiBean.getAzukarikinkykhnkkaiyakuhr(), uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);

                                        taisyouGkSonotahenreikinYen = kanzanGaku.add(
                                            commonSiwakeUtil.getTaisyouGkSonotahenreikin()).add(uiBean.getYenazukarikinkykhnkmikeikap());
                                    }
                                    else {
                                        taisyouGkSonotahenreikinYen = commonSiwakeUtil.getTaisyouGkSonotahenreikin().add(uiBean.getYenazukarikinkykhnkmikeikap());
                                    }
                                }
                                else {
                                    kyktuktngkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                    kyktuktngkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                    kyktuktngkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                                    kyktuktngkSonotahenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin();

                                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                                    if (kyktuktngkSyonendosyokaip.compareTo(
                                        BizCurrency.valueOf(0, kyktuktngkSyonendosyokaip.getType())) > 0) {

                                        taisyouGkSyonendosyokaip = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                            kyktuktngkSyonendosyokaip, uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                                    }

                                    if (kyktuktngkSyonendo2kaimeikoup.compareTo(
                                        BizCurrency.valueOf(0, kyktuktngkSyonendo2kaimeikoup.getType())) > 0) {

                                        taisyouGkSyonendo2kaimeikoup = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                            kyktuktngkSyonendo2kaimeikoup, uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                                    }

                                    if (kyktuktngkJinendoikoup.compareTo(
                                        BizCurrency.valueOf(0, kyktuktngkJinendoikoup.getType())) > 0) {

                                        taisyouGkJinendoikoup = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                            kyktuktngkJinendoikoup, uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                                    }

                                    if (kyktuktngkSonotahenreikin.compareTo(
                                        BizCurrency.valueOf(0, kyktuktngkSonotahenreikin.getType())) > 0) {

                                        taisyouGkSonotahenreikinYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                            kyktuktngkSonotahenreikin, uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                                    }
                                }

                                if (!C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) {
                                    jpyshrtienrsk = uiBean.getJpyshrtienrsk();
                                }

                                TaisyouGkBean taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);
                                taisyouGkBean.setTaisyouGk(uiBean.getShrsyousaijpykaiyakuhr());
                                taisyouGkBean.setKeiyakutuukaGk(uiBean.getKaiyakuhr());
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
                                taisyouGkBean.setTaisyouGk(jpyshrtienrsk);
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
                                taisyouGkBean.setTaisyouGk(uiBean.getJpyshrgkgoukeikakunin());
                                taisyouGkBean.setKeiyakutuukaGk(uiBean.getShrgkgoukeikakunin());
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
                                taisyouGkBean.setTaisyouGk(uiBean.getYenkakrkgk());
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);
                                taisyouGkBean.setTaisyouGk(uiBean.getYenkahaitoukin().add(uiBean.getYentkbthaitoukin()));
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
                                taisyouGkBean.setTaisyouGk(taisyouGkSyonendosyokaip);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSyonendosyokaip);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
                                taisyouGkBean.setTaisyouGk(taisyouGkSyonendo2kaimeikoup);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSyonendo2kaimeikoup);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
                                taisyouGkBean.setTaisyouGk(taisyouGkJinendoikoup);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkJinendoikoup);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
                                taisyouGkBean.setTaisyouGk(taisyouGkSonotahenreikinYen);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSonotahenreikin);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                soukingk = uiBean.getJpyshrgkgoukeikakunin();
                            }
                        }

                        if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) ||
                            C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn())||
                            C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {

                            if (C_Kykjyoutai.ITIJIBARAI.eq(uiBean.getKykjyoutai())) {
                                TaisyouGkBean taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
                                taisyouGkBean.setTaisyouGk(uiBean.getNykntuukashrgkgoukeikakunin());
                                taisyouGkBean.setKeiyakutuukaGk(uiBean.getKykKihon().getHrkp());
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
                                taisyouGkBean.setTaisyouGk(uiBean.getNykntuukashrgkgoukeikakunin());
                                taisyouGkBean.setKeiyakutuukaGk(uiBean.getKykKihon().getHrkp());
                                taisyouGkBeanLst.add(taisyouGkBean);

                                if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                                    soukingk = uiBean.getNykntuukashrgkgoukeikakunin();
                                }
                                else {
                                    kakokawaserateshiteiflg = true;
                                    kakokawaserateshiteiymd = uiBean.getFstpryosyuymd();
                                    gaikashrgk = uiBean.getNykntuukashrgkgoukeikakunin();
                                }
                            }
                            else {
                                CommonSiwakeUtil commonSiwakeUtil = SWAKInjector.getInstance(CommonSiwakeUtil.class);
                                commonSiwakeUtil.execKihrkmPKanjokamokuHantei(uiBean.getShrymd(),
                                    uiBean.getSyukykymd(), uiBean.getZennounyuukinkgkrstk(), uiBean.getRyosyuymd(),
                                    uiBean.getJkipjytym(), uiBean.getKihrkmp(),
                                    uiBean.getSiwakeHanteiNyknJissekiRirekiBean(),
                                    uiBean.getKykKihon().getHrkkaisuu(), uiBean.getKykKihon().getTikiktbrisyuruikbn());

                                BizCurrency taisyouGkSyonendosyokaip = BizCurrency.valueOf(0, currencyType);
                                BizCurrency taisyouGkSyonendo2kaimeikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency taisyouGkJinendoikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency taisyouGkSonotahenreikin = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSyonendosyokaip = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSyonendo2kaimeikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkJinendoikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSonotahenreikin = BizCurrency.valueOf(0, currencyType);
                                boolean keiyakutuukagkSetteiFlg = false;

                                if (C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI.eq(uiBean.getHijynbrKanritukaHantKbn())) {
                                    taisyouGkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                    taisyouGkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                    taisyouGkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                                    taisyouGkSonotahenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin();
                                }
                                else {
                                    if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu()) &&
                                        !C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                                        taisyouGkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                        taisyouGkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                        taisyouGkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                                        taisyouGkSonotahenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin();

                                        if (BizCurrency.valueOf(0, taisyouGkSyonendosyokaip.getType()).compareTo(
                                            taisyouGkSyonendosyokaip) < 0 && !keiyakutuukagkSetteiFlg) {
                                            kyktuktngkSyonendosyokaip = uiBean.getKyktuktniRsgakukei();
                                            keiyakutuukagkSetteiFlg = true;
                                        }

                                        if (BizCurrency.valueOf(0, taisyouGkSyonendo2kaimeikoup.getType()).compareTo(
                                            taisyouGkSyonendo2kaimeikoup) < 0 && !keiyakutuukagkSetteiFlg) {
                                            kyktuktngkSyonendo2kaimeikoup = uiBean.getKyktuktniRsgakukei();
                                            keiyakutuukagkSetteiFlg = true;
                                        }

                                        if (BizCurrency.valueOf(0, taisyouGkJinendoikoup.getType()).compareTo(
                                            taisyouGkJinendoikoup) < 0 && !keiyakutuukagkSetteiFlg) {
                                            kyktuktngkJinendoikoup = uiBean.getKyktuktniRsgakukei();
                                            keiyakutuukagkSetteiFlg = true;
                                        }

                                        if (BizCurrency.valueOf(0, taisyouGkSonotahenreikin.getType()).compareTo(
                                            taisyouGkSonotahenreikin) < 0 && !keiyakutuukagkSetteiFlg) {
                                            kyktuktngkSonotahenreikin = uiBean.getKyktuktniRsgakukei();
                                            keiyakutuukagkSetteiFlg = true;
                                        }
                                    }
                                    else {
                                        taisyouGkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                        taisyouGkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                        taisyouGkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                                        taisyouGkSonotahenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin();
                                        kyktuktngkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                        kyktuktngkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                        kyktuktngkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                                        kyktuktngkSonotahenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin();
                                    }
                                }

                                TaisyouGkBean taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
                                taisyouGkBean.setTaisyouGk(taisyouGkSyonendosyokaip);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSyonendosyokaip);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
                                taisyouGkBean.setTaisyouGk(taisyouGkSyonendo2kaimeikoup);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSyonendo2kaimeikoup);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
                                taisyouGkBean.setTaisyouGk(taisyouGkJinendoikoup);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkJinendoikoup);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
                                taisyouGkBean.setTaisyouGk(taisyouGkSonotahenreikin);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSonotahenreikin);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
                                taisyouGkBean.setTaisyouGk(uiBean.getYenkakrkgk());
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
                                taisyouGkBean.setTaisyouGk(uiBean.getNykntuukashrgkgoukeikakunin());
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                                    soukingk = uiBean.getNykntuukashrgkgoukeikakunin();
                                }
                                else {
                                    kakokawaserateshiteiflg = true;
                                    kakokawaserateshiteiymd = uiBean.getFstpryosyuymd();
                                    gaikashrgk = uiBean.getNykntuukashrgkgoukeikakunin();
                                }
                            }
                        }

                        if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
                            CommonSiwakeUtil commonSiwakeUtil = SWAKInjector.getInstance(CommonSiwakeUtil.class);

                            commonSiwakeUtil.execPKanjokamokuHantei(uiBean.getShrymd(), uiBean.getSyukykymd(),
                                uiBean.getZennouseisankinKnrtuuka(), uiBean.getRyosyuymd(), uiBean.getJkipjytym(),
                                uiBean.getMikeikapKnrtuuka(), uiBean.getMikeikaPJyutouYM(), uiBean.getMiKeikaPBeans(),
                                khozenCommonParam.getFunctionId(),syoriKbn, uiBean.getKykKihon().getHrkkaisuu(),
                                uiBean.getKykKihon().getTikiktbrisyuruikbn());


                            if (C_UmuKbn.NONE.eq(uiBean.getYenshrtkumu())) {

                                BizCurrency taisyouGkSyonendosyokaipKnrtuuka = BizCurrency.valueOf(0, currencyType);
                                BizCurrency taisyouGkSyonendo2kaimeikoupKnrtuuka = BizCurrency.valueOf(0, currencyType);
                                BizCurrency taisyouGkJinendoikoupKnrtuuka = BizCurrency.valueOf(0, currencyType);
                                BizCurrency taisyouGkSonotahenreikinKyktuuka = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSyonendosyokaip = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSyonendo2kaimeikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkJinendoikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSonotahenreikin = BizCurrency.valueOf(0, currencyType);

                                if (C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI.eq(uiBean.getHijynbrKanritukaHantKbn())) {
                                    taisyouGkSyonendosyokaipKnrtuuka = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                    taisyouGkSyonendo2kaimeikoupKnrtuuka = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                    taisyouGkJinendoikoupKnrtuuka = commonSiwakeUtil.getTaisyouGkJinendoikoup();

                                    BizCurrency taisyouGkSonotahenreikinYen = commonSiwakeUtil.getTaisyouGkSonotahenreikin().add(uiBean.getYenazukarikinkykhnkmikeikap());

                                    if (taisyouGkSonotahenreikinYen.compareTo(
                                        BizCurrency.valueOf(0, taisyouGkSonotahenreikinYen.getType())) > 0) {

                                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                                        BizCurrency kanzanGaku = keisanGaikakanzan.execDivide(uiBean.getKyktuukasyu(),
                                            taisyouGkSonotahenreikinYen, uiBean.getSntshrgkssgikshrrate(), C_HasuusyoriKbn.AGE);

                                        taisyouGkSonotahenreikinKyktuuka = kanzanGaku.add(uiBean.getAzukarikinkykhnkkaiyakuhr());
                                    }
                                    else {
                                        taisyouGkSonotahenreikinKyktuuka = uiBean.getAzukarikinkykhnkkaiyakuhr();
                                    }
                                }
                                else {
                                    taisyouGkSyonendosyokaipKnrtuuka = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                    taisyouGkSyonendo2kaimeikoupKnrtuuka = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                    taisyouGkJinendoikoupKnrtuuka = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                                    taisyouGkSonotahenreikinKyktuuka = commonSiwakeUtil.getTaisyouGkSonotahenreikin();
                                    kyktuktngkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                    kyktuktngkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                    kyktuktngkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                                    kyktuktngkSonotahenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin();
                                }

                                if (!C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) {
                                    shrtienrsk = uiBean.getShrtienrsk();
                                }

                                TaisyouGkBean taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_PTUMITATEKIN);
                                taisyouGkBean.setTaisyouGk(uiBean.getPtumitatekin());
                                taisyouGkBean.setKeiyakutuukaGk(uiBean.getPtumitatekin());
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
                                taisyouGkBean.setTaisyouGk(shrtienrsk);
                                taisyouGkBean.setKeiyakutuukaGk(shrtienrsk);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
                                taisyouGkBean.setTaisyouGk(uiBean.getShrgkgoukeikakunin());
                                taisyouGkBean.setKeiyakutuukaGk(uiBean.getShrgkgoukeikakunin());
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
                                taisyouGkBean.setTaisyouGk(uiBean.getYenkakrkgk());
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);
                                taisyouGkBean.setTaisyouGk(uiBean.getYenkahaitoukin().add(uiBean.getYentkbthaitoukin()));
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
                                taisyouGkBean.setTaisyouGk(taisyouGkSyonendosyokaipKnrtuuka);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSyonendosyokaip);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
                                taisyouGkBean.setTaisyouGk(taisyouGkSyonendo2kaimeikoupKnrtuuka);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSyonendo2kaimeikoup);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
                                taisyouGkBean.setTaisyouGk(taisyouGkJinendoikoupKnrtuuka);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkJinendoikoup);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
                                taisyouGkBean.setTaisyouGk(taisyouGkSonotahenreikinKyktuuka);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSonotahenreikin);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                                    gaikashrgk = BizCurrency.valueOf(0);
                                    soukingk = uiBean.getYendthnkshrgkgoukeikakunin();
                                    kakokawaserateshiteiflg = false;
                                    kakokawaserateshiteiymd = null;
                                }
                                else {
                                    gaikashrgk = uiBean.getShrgkgoukeikakunin();
                                    soukingk = BizCurrency.valueOf(0);
                                    kakokawaserateshiteiflg = true;
                                    kakokawaserateshiteiymd = uiBean.getSyoruiKanbiYmd();
                                }
                            }
                            else {

                                BizCurrency taisyouGkPtumitatekin = uiBean.getShrsyousaijpyptumitatekin();
                                BizCurrency kyktuktngkPtumitatekin = uiBean.getPtumitatekin();
                                BizCurrency taisyouGkSyonendosyokaip = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                BizCurrency taisyouGkSyonendo2kaimeikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                BizCurrency taisyouGkJinendoikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                BizCurrency taisyouGkSonotahenreikinYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                                BizCurrency kyktuktngkSyonendosyokaip = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSyonendo2kaimeikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkJinendoikoup = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSonotahenreikin = BizCurrency.valueOf(0, currencyType);
                                BizCurrency kyktuktngkSonotahenreikinPb = BizCurrency.valueOf(0, currencyType);

                                if (C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI.eq(uiBean.getHijynbrKanritukaHantKbn())) {
                                    taisyouGkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                    taisyouGkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                    taisyouGkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();

                                    if (uiBean.getAzukarikinkykhnkkaiyakuhr().compareTo(
                                        BizCurrency.valueOf(0, uiBean.getAzukarikinkykhnkkaiyakuhr().getType())) > 0) {

                                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                                        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                            uiBean.getAzukarikinkykhnkkaiyakuhr(), uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);

                                        taisyouGkSonotahenreikinYen = kanzanGaku.add(
                                            commonSiwakeUtil.getTaisyouGkSonotahenreikin()).add(uiBean.getYenazukarikinkykhnkmikeikap());
                                    }
                                    else {
                                        taisyouGkSonotahenreikinYen = commonSiwakeUtil.getTaisyouGkSonotahenreikin().add(uiBean.getYenazukarikinkykhnkmikeikap());
                                    }
                                }
                                else {
                                    kyktuktngkSyonendosyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                                    kyktuktngkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                                    kyktuktngkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                                    kyktuktngkSonotahenreikinPb = commonSiwakeUtil.getTaisyouGkSonotahenreikin();

                                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                                    if (kyktuktngkSyonendosyokaip.compareTo(
                                        BizCurrency.valueOf(0, kyktuktngkSyonendosyokaip.getType())) > 0) {

                                        taisyouGkSyonendosyokaip = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                            kyktuktngkSyonendosyokaip, uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                                    }

                                    if (kyktuktngkSyonendo2kaimeikoup.compareTo(
                                        BizCurrency.valueOf(0, kyktuktngkSyonendo2kaimeikoup.getType())) > 0) {

                                        taisyouGkSyonendo2kaimeikoup = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                            kyktuktngkSyonendo2kaimeikoup, uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                                    }

                                    if (kyktuktngkJinendoikoup.compareTo(
                                        BizCurrency.valueOf(0, kyktuktngkJinendoikoup.getType())) > 0) {

                                        taisyouGkJinendoikoup = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                            kyktuktngkJinendoikoup, uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                                    }

                                    if (kyktuktngkSonotahenreikinPb.compareTo(
                                        BizCurrency.valueOf(0, kyktuktngkSonotahenreikinPb.getType())) > 0) {

                                        BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                            kyktuktngkSonotahenreikinPb.add(uiBean.getPtumitatekin()),
                                            uiBean.getYenshrrate(), C_HasuusyoriKbn.AGE);

                                        taisyouGkPtumitatekin = kanzanGaku;
                                        kyktuktngkPtumitatekin = uiBean.getPtumitatekin().add(kyktuktngkSonotahenreikinPb);
                                    }
                                }

                                if (!C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) {
                                    jpyshrtienrsk = uiBean.getJpyshrtienrsk();
                                }

                                TaisyouGkBean taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_PTUMITATEKIN);
                                taisyouGkBean.setTaisyouGk(taisyouGkPtumitatekin);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkPtumitatekin);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
                                taisyouGkBean.setTaisyouGk(jpyshrtienrsk);
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
                                taisyouGkBean.setTaisyouGk(uiBean.getJpyshrgkgoukeikakunin());
                                taisyouGkBean.setKeiyakutuukaGk(uiBean.getShrgkgoukeikakunin());
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
                                taisyouGkBean.setTaisyouGk(uiBean.getYenkakrkgk());
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);
                                taisyouGkBean.setTaisyouGk(uiBean.getYenkahaitoukin().add(uiBean.getYentkbthaitoukin()));
                                taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0, currencyType));
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
                                taisyouGkBean.setTaisyouGk(taisyouGkSyonendosyokaip);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSyonendosyokaip);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
                                taisyouGkBean.setTaisyouGk(taisyouGkSyonendo2kaimeikoup);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSyonendo2kaimeikoup);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
                                taisyouGkBean.setTaisyouGk(taisyouGkJinendoikoup);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkJinendoikoup);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                                taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
                                taisyouGkBean.setTaisyouGk(taisyouGkSonotahenreikinYen);
                                taisyouGkBean.setKeiyakutuukaGk(kyktuktngkSonotahenreikin);
                                taisyouGkBeanLst.add(taisyouGkBean);

                                soukingk = uiBean.getJpyshrgkgoukeikakunin();
                            }
                        }

                        CommonSiwakeInBean commonSiwakeInBean = SWAKInjector.getInstance(CommonSiwakeInBean.class);
                        commonSiwakeInBean.setKinouId(kinou.getKinouId());
                        commonSiwakeInBean.setDenYmd(uiBean.getShrymd());
                        commonSiwakeInBean.setTuukasyu(uiBean.getShrtuukasyu());
                        commonSiwakeInBean.setSyoriYmd(sysDate);
                        commonSiwakeInBean.setKykYmd(uiBean.getSyukykymd());
                        commonSiwakeInBean.setSyouhnCd(uiBean.getSyusyouhncd());
                        commonSiwakeInBean.setSyouhnsdNo(uiBean.getSyusyouhnsdno());
                        commonSiwakeInBean.setSyoriKbn(syoriKbn);
                        commonSiwakeInBean.setShrhousiteiKbn(uiBean.getShrhousiteikbn());
                        commonSiwakeInBean.setKyktuukaSyu(uiBean.getKyktuukasyu());
                        commonSiwakeInBean.setTuukasyuKansanKawaserate(uiBean.getShrkwsrate());
                        commonSiwakeInBean.setAzukarikinUmuKbn(azukarikingkUmuKbn);
                        commonSiwakeInBean.setHijynbrKanritukaHantKbn(uiBean.getHijynbrKanritukaHantKbn());
                        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

                        CommonSiwake commonSiwake = SWAKInjector.getInstance(CommonSiwake.class);

                        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

                        if (!C_Kykjyoutai.ITIJIBARAI.eq(uiBean.getKykjyoutai())) {
                            CommonSiwakeUtil commonSiwakeUtil = SWAKInjector.getInstance(CommonSiwakeUtil.class);
                            List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = commonSiwakeUtil.execTaisyakuTyousei(
                                commonSiwakeOutBean.getTuukasyu(),
                                commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());

                            commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(bzSiwakeMeisaiBeanLst);
                        }

                        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);
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
                        bzDenpyouDataTourokuBean.setIbKyktuukasyu(uiBean.getKyktuukasyu());
                        bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(baseUserInfo.getUserId());
                        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(kakokawaserateshiteiflg);
                        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(kakokawaserateshiteiymd);
                        bzDenpyouDataTourokuBean.setIbShrhousiteiKbn(uiBean.getShrhousiteikbn());
                        bzDenpyouDataTourokuBean.setIbSyouhncd(uiBean.getSyusyouhncd());
                        bzDenpyouDataTourokuBean.setIbSyouhnsdno(uiBean.getSyusyouhnsdno());
                        bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());

                        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);

                        List<IT_KhDenpyoData> khDenpyoDataLst = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);

                        int fbskEdano = bzDenpyouDataSks.getEdano();

                        for (IT_KhDenpyoData khDenpyoData : khDenpyoDataLst) {
                            hozenDomManager.insert(khDenpyoData);
                        }

                        String denrenno = khDenpyoDataLst.get(0).getDenrenno();

                        if (C_ShrhousiteiKbn.FB_YOKUJITU.eq(uiBean.getShrhousiteikbn()) ||
                            C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(uiBean.getShrhousiteikbn()) ||
                            C_ShrhousiteiKbn.FB_3EIGYOUBI.eq(uiBean.getShrhousiteikbn())) {

                            if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {

                                BzFbSoukinDataSksBean bzFbSoukinDataSksBean  = SWAKInjector.getInstance(BzFbSoukinDataSksBean .class);

                                bzFbSoukinDataSksBean.setDenbyouyouDataRenbon(denrenno);
                                bzFbSoukinDataSksBean.setEdaNo(fbskEdano);
                                bzFbSoukinDataSksBean.setDenSysKbn(commonSiwakeOutBean.getDensysKbn());
                                bzFbSoukinDataSksBean.setSyoriCd(commonSiwakeOutBean.getSyoriCd());
                                bzFbSoukinDataSksBean.setSyoriSosikiCd(khozenCommonParam.getTmSosikiCd());
                                bzFbSoukinDataSksBean.setSyoriYmd(commonSiwakeOutBean.getSyoriYmd());
                                bzFbSoukinDataSksBean.setDenYmd(commonSiwakeOutBean.getDenyMd());
                                bzFbSoukinDataSksBean.setSyoNo(uiBean.getSyono());
                                bzFbSoukinDataSksBean.setShrHouSiteiKbn(uiBean.getShrhousiteikbn());
                                bzFbSoukinDataSksBean.setBankCd(uiBean.getBankcd());
                                bzFbSoukinDataSksBean.setSitenCd(uiBean.getSitencd());
                                bzFbSoukinDataSksBean.setYokinKbn(uiBean.getYokinkbn());
                                bzFbSoukinDataSksBean.setKouzaNo(uiBean.getKouzano());
                                bzFbSoukinDataSksBean.setKzMeigiNmKn(uiBean.getKzmeiginmkn());
                                bzFbSoukinDataSksBean.setSouKingk(soukingk);
                                bzFbSoukinDataSksBean.setKykTuukasyu(uiBean.getKyktuukasyu());
                                bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                                bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(0));
                                bzFbSoukinDataSksBean.setKinouId(kinou.getKinouId());
                                bzFbSoukinDataSksBean.setUserId(baseUserInfo.getUserId());
                                bzFbSoukinDataSksBean.setDengyoumuCd(khDenpyoDataLst.get(0).getDengyoumucd());

                                BzFbSoukinDataSks bzFbSoukinDataSks = SWAKInjector.getInstance(BzFbSoukinDataSks.class);
                                IT_KhFBSoukinData khFBSoukinData = bzFbSoukinDataSks.execKh(bzFbSoukinDataSksBean);

                                if (khFBSoukinData != null) {
                                    hozenDomManager.insert(khFBSoukinData);
                                }
                            }
                            else {
                                String kzmeiginmei = ConvertUtil.toHanAll(uiBean.getKzmeiginmkn(), 0, 0);

                                BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

                                BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(uiBean.getBankcd(), uiBean.getSitencd());

                                BzGkfbSoukinDataSksBean  bzGkfbSoukinDataSksBean  = SWAKInjector.getInstance(BzGkfbSoukinDataSksBean .class);
                                bzGkfbSoukinDataSksBean.setDenRenno(denrenno);
                                bzGkfbSoukinDataSksBean.setEdaNo(fbskEdano);
                                bzGkfbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.HOZEN);
                                bzGkfbSoukinDataSksBean.setSyoriCd(commonSiwakeOutBean.getSyoriCd());
                                bzGkfbSoukinDataSksBean.setSyoriSosikiCd(khozenCommonParam.getTmSosikiCd());
                                bzGkfbSoukinDataSksBean.setSyoriYmd(commonSiwakeOutBean.getSyoriYmd());
                                bzGkfbSoukinDataSksBean.setDenYmd(commonSiwakeOutBean.getDenyMd());
                                bzGkfbSoukinDataSksBean.setSyono(uiBean.getSyono());
                                bzGkfbSoukinDataSksBean.setShrHouSiteiKbn(uiBean.getShrhousiteikbn());
                                bzGkfbSoukinDataSksBean.setBankCd(uiBean.getBankcd());
                                bzGkfbSoukinDataSksBean.setBankNmEj(bzGetBankDataBean.getBankNmEj());
                                bzGkfbSoukinDataSksBean.setSitenCd(uiBean.getSitencd());
                                bzGkfbSoukinDataSksBean.setSitenNmEj(bzGetBankDataBean.getSitenNmEj());
                                bzGkfbSoukinDataSksBean.setKouzaNo(uiBean.getKouzano());
                                bzGkfbSoukinDataSksBean.setKzMeigiNmEi(kzmeiginmei);
                                bzGkfbSoukinDataSksBean.setShrTuukaSyu(uiBean.getShrtuukasyu());
                                bzGkfbSoukinDataSksBean.setGaikaShrgk(gaikashrgk);
                                bzGkfbSoukinDataSksBean.setKykTuukaSyu(uiBean.getKyktuukasyu());
                                bzGkfbSoukinDataSksBean.setCrossRateShrgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                                bzGkfbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(0));
                                bzGkfbSoukinDataSksBean.setKinouId(kinou.getKinouId());
                                bzGkfbSoukinDataSksBean.setUserId(baseUserInfo.getUserId());
                                bzGkfbSoukinDataSksBean.setDengyoumuCd(khDenpyoDataLst.get(0).getDengyoumucd());

                                BzGkfbSoukinDataSks bzGkfbSoukinDataSks = SWAKInjector.getInstance(BzGkfbSoukinDataSks.class);
                                IT_KhGaikaFBSoukinData khGaikaFBSoukinData = bzGkfbSoukinDataSks.execKh(bzGkfbSoukinDataSksBean);

                                if (khGaikaFBSoukinData != null) {
                                    hozenDomManager.insert(khGaikaFBSoukinData);
                                }
                            }
                        }

                        insertKTKhShrRrk(sikibetuKey, shrsyoriKbn, denrenno, sysDate, sysTime,jpyshrtienrsk,shrtienrsk);

                        insertKTKhShrRrkDtl(sikibetuKey,sysTime);

                        updateKhHenreikin(sysDate, sysTime);

                        updateAzukarikin(sysDate, sysTime);

                        updateKariukekin(sysTime);

                        editAnsyuKihonAndZennouAndKihrkmpSeisanRireki(khozenCommonParam, sysDate, sysTime, sikibetuKey,
                            kykSyouhnLst);

                        SikinIdouRirekiDataBean sikinIdouRirekiDataBean = SWAKInjector.getInstance(SikinIdouRirekiDataBean.class);
                        sikinIdouRirekiDataBean.setSyoriYmd(sysDate);
                        sikinIdouRirekiDataBean.setSyono(uiBean.getSyono());
                        sikinIdouRirekiDataBean.setHenkouSikibetuKey(sikibetuKey);
                        sikinIdouRirekiDataBean.setTargetKinouId(khozenCommonParam.getFunctionId());
                        sikinIdouRirekiDataBean.setNykshrKbn(C_NykshrKbn.SIHARAI);
                        sikinIdouRirekiDataBean.setSyoricd(commonSiwakeOutBean.getSyoriCd());
                        sikinIdouRirekiDataBean.setDensysKbn(commonSiwakeOutBean.getDensysKbn());
                        sikinIdouRirekiDataBean.setDenrenno(khDenpyoDataLst.get(0).getDenrenno());
                        sikinIdouRirekiDataBean.setSeg1cd(
                            commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd());
                        sikinIdouRirekiDataBean.setKykTuukasyu(uiBean.getKyktuukasyu());
                        sikinIdouRirekiDataBean.setSyutkKbn(C_SyutkKbn.SYU);
                        sikinIdouRirekiDataBean.setHrkkaisuu(uiBean.getKykKihon().getHrkkaisuu());
                        sikinIdouRirekiDataBean.setSyouhnCd(uiBean.getSyusyouhncd());
                        sikinIdouRirekiDataBean.setSyouhnSdno(uiBean.getSyusyouhnsdno());
                        sikinIdouRirekiDataBean.setKykSyouhnRenno(uiBean.getSyukyksyouhnrenno());
                        sikinIdouRirekiDataBean.setShrhousiteiKbn(uiBean.getShrhousiteikbn());
                        sikinIdouRirekiDataBean.setKykYmd(uiBean.getSyukykymd());
                        sikinIdouRirekiDataBean.setSeirituYmd(uiBean.getKykKihon().getSeirituymd());
                        sikinIdouRirekiDataBean.setSyoumetuYmd(syoumetuYmd);
                        sikinIdouRirekiDataBean.setShrsyoriKbn(shrsyoriKbn);
                        sikinIdouRirekiDataBean.setSyoumetuJiyuu(syoumetujiyuu);

                        BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei = SWAKInjector.getInstance
                            (BzSikinIdouRirekiTblSakusei.class);
                        BT_SikinIdouRireki sikinIdouRireki = bzSikinIdouRirekiTblSakusei.editSikinIdouRirekiTblEntity(
                            sikinIdouRirekiDataBean);

                        bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblOne(sikinIdouRireki);
                    }

                    Long lincKanyuusyaNo = 0L;

                    IT_KhLincKihon khLincKihon = uiBean.getKykKihon().getKhLincKihon();

                    if (khLincKihon != null) {
                        lincKanyuusyaNo = khLincKihon.getLinckanyuusyano();
                    }

                    HanteiLincBean hanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);

                    hanteiLincBean.setSyoriYmd(sysDate);
                    hanteiLincBean.setBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
                    hanteiLincBean.setKykKihon(uiBean.getKykKihon());
                    hanteiLincBean.setKanyuusyaNo(lincKanyuusyaNo);

                    HanteiLinc hanteiLinc = SWAKInjector.getInstance(HanteiLinc.class);

                    hanteiLinc.exec(hanteiLincBean, khozenCommonParam);

                    EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                    editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                    editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
                    editTtdkRirekiTblParam.setSyoriYmd(sysDate);
                    editTtdkRirekiTblParam.setSysTime(sysTime);
                    editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());
                    editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);
                    editTtdkRirekiTblParam.setYoukyuuNo(pALKykNaiyouKousin.getYoukyuuno());
                    editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                    editTtdkRirekiTblParam.setSyoriKbn(syoriKbn);
                    editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.ARI);

                    EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
                    editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                    EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(
                        EditHokenKykIdouRirekiTbl.class);
                    EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(
                        EditHokenKykIdouRirekiTblBean.class);
                    editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
                    editHokenKykIdouRirekiTblBean.setSyoNo(uiBean.getSyono());
                    editHokenKykIdouRirekiTblBean.setSyoriYmd(sysDate);
                    editHokenKykIdouRirekiTblBean.setSyoriKbn(syoriKbn);
                    editHokenKykIdouRirekiTblBean.setSysDateTime(sysTime);
                    editHokenKykIdouRirekiTblBean.setMikeikaP(uiBean.getMikeikapKnrtuuka());
                    editHokenKykIdouRirekiTblBean.setZennouseisanKin(uiBean.getZennouseisankinKnrtuuka());
                    editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

                    KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

                    EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);
                    editTtdkKanryouParam.setSyorikbn(syoriKbn);
                    editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);

                    if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn())) {
                        SmbcsintyokukanriCoolingoff SmbcsintyokukanriCoolingoff =
                            SWAKInjector.getInstance(SmbcsintyokukanriCoolingoff.class);
                        SmbcsintyokukanriCoolingoff.exec(uiBean.getSyono(), sysDate, sysDate);
                        //
                        //                        editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_CLGOFF_KYKTRKSTTDKKR);
                        //                        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
                        //
                        //                        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(),
                        //                            new C_SyoruiCdKbn[] {C_SyoruiCdKbn.KK_CLGOFF_KYKTRKSTTDKKR}, C_YouhiKbn.YOU);
                    }
                    //
                    //                    if (C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn())) {
                    //                        editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_KYKTRKS_KYKTRKSTTDKKR);
                    //
                    //                        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
                    //
                    //                        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(),
                    //                            new C_SyoruiCdKbn[] {C_SyoruiCdKbn.KK_KYKTRKS_KYKTRKSTTDKKR}, C_YouhiKbn.YOU);
                    //                    }

                    //                    if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
                    //                        editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR);
                    //
                    //                        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
                    //
                    //                        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(),
                    //                            new C_SyoruiCdKbn[] {C_SyoruiCdKbn.KK_KAIJYO_KYKTRKSTTDKKR}, C_YouhiKbn.YOU);
                    //                    }
                    if (C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {
                        editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR);
                        editTtdkKanryouParam.setSoukinsakisiteikbn(uiBean.getSoukinsakisiteikbn());

                        if (C_SoukinsakisiteiKbn.SONOTA.eq(uiBean.getSoukinsakisiteikbn())) {
                            editTtdkKanryouParam.setShsyno(uiBean.getSoukinsakiyno());
                            editTtdkKanryouParam.setShsadr1kj(uiBean.getSoukinsakiadr1kj());
                            editTtdkKanryouParam.setShsadr2kj(uiBean.getSoukinsakiadr2kj());
                            editTtdkKanryouParam.setShsadr3kj(uiBean.getSoukinsakiadr3kj());
                            editTtdkKanryouParam.setShsnmkj(uiBean.getSoukinsakinmkj());
                        }
                        else if(C_SoukinsakisiteiKbn.KYKSOUZOKUNIN.eq(uiBean.getSoukinsakisiteikbn())){
                            editTtdkKanryouParam.setShsyno(uiBean.getKyksyaszkyno());
                            editTtdkKanryouParam.setShsadr1kj(uiBean.getKyksyaszkadr1kj());
                            editTtdkKanryouParam.setShsadr2kj(uiBean.getKyksyaszkadr2kj());
                            editTtdkKanryouParam.setShsadr3kj(uiBean.getKyksyaszkadr3kj());
                            editTtdkKanryouParam.setShsnmkj(uiBean.getKyksyaszknmkj());
                        }

                        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

                        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(),
                            new C_SyoruiCdKbn[] {C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR}, C_YouhiKbn.YOU);
                    }
                    if (C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {
                        editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);
                        editTtdkKanryouParam.setSoukinsakisiteikbn(uiBean.getSoukinsakisiteikbn());
                        editTtdkKanryouParam.setCalckijyunYMD(uiBean.getSibouymd());

                        if (C_SoukinsakisiteiKbn.SONOTA.eq(uiBean.getSoukinsakisiteikbn())) {
                            editTtdkKanryouParam.setShsyno(uiBean.getSoukinsakiyno());
                            editTtdkKanryouParam.setShsadr1kj(uiBean.getSoukinsakiadr1kj());
                            editTtdkKanryouParam.setShsadr2kj(uiBean.getSoukinsakiadr2kj());
                            editTtdkKanryouParam.setShsadr3kj(uiBean.getSoukinsakiadr3kj());
                            editTtdkKanryouParam.setShsnmkj(uiBean.getSoukinsakinmkj());
                        }
                        else if(C_SoukinsakisiteiKbn.KYKSOUZOKUNIN.eq(uiBean.getSoukinsakisiteikbn())){
                            editTtdkKanryouParam.setShsyno(uiBean.getKyksyaszkyno());
                            editTtdkKanryouParam.setShsadr1kj(uiBean.getKyksyaszkadr1kj());
                            editTtdkKanryouParam.setShsadr2kj(uiBean.getKyksyaszkadr2kj());
                            editTtdkKanryouParam.setShsadr3kj(uiBean.getKyksyaszkadr3kj());
                            editTtdkKanryouParam.setShsnmkj(uiBean.getKyksyaszknmkj());
                        }

                        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

                        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(),
                            new C_SyoruiCdKbn[] {C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR}, C_YouhiKbn.YOU);
                    }

                    if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
                        editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR);
                        editTtdkKanryouParam.setSoukinsakisiteikbn(uiBean.getSoukinsakisiteikbn());
                        editTtdkKanryouParam.setCalckijyunYMD(uiBean.getSibouymd());

                        if (C_SoukinsakisiteiKbn.SONOTA.eq(uiBean.getSoukinsakisiteikbn())) {
                            editTtdkKanryouParam.setShsyno(uiBean.getSoukinsakiyno());
                            editTtdkKanryouParam.setShsadr1kj(uiBean.getSoukinsakiadr1kj());
                            editTtdkKanryouParam.setShsadr2kj(uiBean.getSoukinsakiadr2kj());
                            editTtdkKanryouParam.setShsadr3kj(uiBean.getSoukinsakiadr3kj());
                            editTtdkKanryouParam.setShsnmkj(uiBean.getSoukinsakinmkj());
                        }
                        else if(C_SoukinsakisiteiKbn.KYKSOUZOKUNIN.eq(uiBean.getSoukinsakisiteikbn())){
                            editTtdkKanryouParam.setShsyno(uiBean.getKyksyaszkyno());
                            editTtdkKanryouParam.setShsadr1kj(uiBean.getKyksyaszkadr1kj());
                            editTtdkKanryouParam.setShsadr2kj(uiBean.getKyksyaszkadr2kj());
                            editTtdkKanryouParam.setShsadr3kj(uiBean.getKyksyaszkadr3kj());
                            editTtdkKanryouParam.setShsnmkj(uiBean.getKyksyaszknmkj());
                        }

                        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

                        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(),
                            new C_SyoruiCdKbn[] {C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR}, C_YouhiKbn.YOU);
                    }

                    uiBean.setTyouhyouKey(khozenTyouhyouCtl.getTyouhyouKey());

                    if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.MUKOU.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {

                        EditDairitenTesuuryouTbl editDairitenTesuuryouTbl = SWAKInjector.getInstance(EditDairitenTesuuryouTbl.class);

                        editDairitenTesuuryouTbl.exec(khozenCommonParam, uiBean.getSyono(), tsrysyoriKbn, null,
                            0, 0,BizCurrency.valueOf(0), BizCurrency.valueOf(0), tableMaintenanceUtil.getBakKykKihon());
                    }

                    hozenDomManager.update(uiBean.getKykKihon());
                }
                else {
                    if (C_UmuKbn.ARI.eq(uiBean.getKykKihon().getKykSonotaTkyk().getTargettkhkumu())) {
                        BzGetProcessSummaryInBean inBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
                        inBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());

                        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
                        List<BzGetProcessSummaryOutBean> outBeanLst = bzGetProcessSummary.exec(inBean);
                        BizDate kouteiStartYmd = outBeanLst.get(0).getKouteiStartYmd();

                        BizDate kykOutouYmdYokujitu = uiBean.getSyukykymd().getNextYear().getRekijyou().addBusinessDays(1);

                        if (BizDateUtil.compareYmd(kouteiStartYmd, sysDate) == BizDateUtil.COMPARE_LESSER  &&
                            (BizDateUtil.compareYmd(kykOutouYmdYokujitu, sysDate) == BizDateUtil.COMPARE_LESSER ||
                            BizDateUtil.compareYmd(kykOutouYmdYokujitu, sysDate) == BizDateUtil.COMPARE_EQUAL)) {
                            BizDate syoriYmdPre = sysDate.getPreviousDay();

                            List<String> jimurenrakuMsgLst = Lists.newArrayList();
                            jimurenrakuMsgLst.add("入力処理をしてから１日以上経過しています。");
                            jimurenrakuMsgLst.add("入力処理日（" + DateFormatUtil.dateKANJISeirekiNoZero(kouteiStartYmd) +
                                "）から受付取消処理日の前日（" + DateFormatUtil.dateKANJISeirekiNoZero(syoriYmdPre) + "）の期間で");
                            jimurenrakuMsgLst.add("目標額到達の判定を実施してください。");

                            EditJimuRenrakuhyouParam editJimuRenrakuhyouParam = SWAKInjector.getInstance(EditJimuRenrakuhyouParam.class);
                            editJimuRenrakuhyouParam.setJimurenrakuMsgList(jimurenrakuMsgLst);

                            KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
                            khozenTyouhyouCtl.setSyoriYmd(sysDate);
                            khozenTyouhyouCtl.setEditJimuRenrakuhyouParam(editJimuRenrakuhyouParam);
                            khozenTyouhyouCtl.createTyouhyouTBL(
                                khozenCommonParam,
                                uiBean.getSyono(),
                                new C_SyoruiCdKbn[]{C_SyoruiCdKbn.KK_JIMURENRAKU_KYKTORIKESI},
                                C_YouhiKbn.HUYOU);
                        }
                    }
                }
            }
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {

            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                insertKhKeiyakuTorikesiWk(sysTime);
            }
            else {
                if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn()) &&
                    !C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn()) ) {

                    updateKhKeiyakuTorikesiWk(sysTime,true);
                }
                else {
                    updateKhKeiyakuTorikesiWk(sysTime,false);
                }
            }

            doJikouteikanri();
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
                IW_KhKeiyakuTorikesiWk khKeiyakuTorikesiWk = hozenDomManager.getKhKeiyakuTorikesiWk(
                    uiBean.getBzWorkflowInfo().getKouteiKanriId());

                hozenDomManager.delete(khKeiyakuTorikesiWk);
            }
            else {
                updateKhKeiyakuTorikesiWk(sysTime,false);
            }

            doJikouteikanri();

        }

        if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
            || !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())
            || C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

            uiBean.getKykKihon().detach();
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void pushModoruBtnByConfirmBL () {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) ||
            C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

                uiBean.setDisptienrskkisanymdnissuu(MessageUtil.getMessage(MessageId.IBC1005));
                uiBean.setShrtienrsk(BizCurrency.optional());
                uiBean.setDispjptienrskkisanymdnissuu(MessageUtil.getMessage(MessageId.IBC1005));
                uiBean.setJpyshrtienrsk(BizCurrency.optional());
            }

        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING3);

    }


    void pushSainyuuryokuBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcessBL();
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);
    }

    String pushSyoukainomiBL(){

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            pushUnlockProcessBL();
        }

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    void pushTojiruBL() {

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            pushUnlockProcessBL();
        }
    }

    String pushFunctionNameBL() {

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            pushUnlockProcessBL();
        }

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    String pushModoruBtnByInputContentsBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            pushUnlockProcessBL();
        }

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    String pushSyokigamenhebtnbyresultBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;

    }

    void pushUnlockProcessBL() {

        bzCommonLockProcess.unlockProcess();
    }

    void pushPrintHyoujiOutBL() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void pushPrintAllHyoujiOutBL() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void pushPrintOutBL() {
        String tyhykey = uiBean.getTyouhyouKey();

        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);

        outputReport.outputPDFByJoinKey(tyhykey);
    }


    private void checkKykSonzai(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);

        uiBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
        uiBean.setHrkkeiro(kykKihon.getHrkkeiro());
        uiBean.setTeikishrtkykhukaumu(kykKihon.getKykSonotaTkyk().getTeikishrtkykhukaumu());
        uiBean.setTeikishrkinshrtuukasyu(kykKihon.getKykSonotaTkyk().getTeikishrkinshrtuukasyu());
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

    private void checkSbhsyukeiyaku(String pSyoNo) {
        List<IT_KykSyouhn> kykSyouhnLst =  uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        if (C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.SBMUKOU_SIHARAI_NASI.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.SBMENSEKI_SIHARAI_NASI.eq(uiBean.getKyktrkskbn()) ) {

            if (C_UmuKbn.NONE.eq(syouhnZokusei.getHutuusbhsyumu()) && C_UmuKbn.NONE.eq(syouhnZokusei.getSgsbhsyumu()) &&
                C_UmuKbn.NONE.eq(syouhnZokusei.getSbkyuuhukinuktumu())) {
                throw new BizLogicException(MessageId.EIA0132, uiBean.getKyktrkskbn().getContent());
            }
        }

        checkSinkeiyakuGoIdou(kykSyouhn.getKykymd());

        uiBean.setSyusyouhnsdno(kykSyouhn.getSyouhnsdno());
        uiBean.setSyukykymd(kykSyouhn.getKykymd());
        uiBean.setSyusyouhncd(kykSyouhn.getSyouhncd());
        uiBean.setRyouritusdno(kykSyouhn.getRyouritusdno());
        uiBean.setSyuyoteiriritu(kykSyouhn.getYoteiriritu());
        uiBean.setSyuhhknnen(kykSyouhn.getHhknnen());
        uiBean.setHhknsei(kykSyouhn.getHhknsei());
        uiBean.setSyuhknkknsmnkbn(kykSyouhn.getHknkknsmnkbn());
        uiBean.setSyuhknkkn(kykSyouhn.getHknkkn());
        uiBean.setSyuhrkkknsmnkbn(kykSyouhn.getHrkkknsmnkbn());
        uiBean.setSyuhrkkkn(kykSyouhn.getHrkkkn());
        uiBean.setSyukihons(kykSyouhn.getKihons());
        uiBean.setKyktuukasyu(kykSyouhn.getKyktuukasyu());
        uiBean.setSyukyksyouhnrenno(kykSyouhn.getKyksyouhnrenno());
        uiBean.setKykjyoutai(kykSyouhn.getKykjyoutai());
        uiBean.setHokenryou(kykSyouhn.getHokenryou());
        uiBean.setYendtHnkYmd(kykSyouhn.getYendthnkymd());
        uiBean.setKaiyakukoujyoritutekiumu(syouhnZokusei.getKaiyakukoujyoritutekiumu());
        uiBean.setMvatekiumu(syouhnZokusei.getMvatekiumu());
        uiBean.setHeijyunbaraiumu(syouhnZokusei.getHeijyunbaraiumu());
        uiBean.setItijibrumu(syouhnZokusei.getItijibrumu());
        uiBean.setTyksenhokanhouKbn(syouhnZokusei.getTyksenhokanhoukbn());
    }

    private void checkSinkeiyakuGoIdou(BizDate pKykymd) {
        if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn())) {

            List<IT_KykSyouhn> kykSyouhnLst =  uiBean.getKykKihon().getKykSyouhnsByKouryokuhasseiymdGt(pKykymd);

            if (kykSyouhnLst.size() > 0) {
                throw new BizLogicException(MessageId.EIA0064);
            }
        }
    }

    private void setUiBean() {

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

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);
        setKariukekin.exec(khozenCommonParam, uiBean);

        SetHaitoukin setHaitoukin = SWAKInjector.getInstance(SetHaitoukin.class);
        setHaitoukin.exec(khozenCommonParam, uiBean);

        SetTrkKazoku.exec(khozenCommonParam, uiBean);

        SetKyksyadairi.exec(khozenCommonParam, uiBean);

        SetKhTkshrSiharaiKouza setKhTkshrSiharaiKouza = SWAKInjector.getInstance(SetKhTkshrSiharaiKouza.class);
        setKhTkshrSiharaiKouza.exec(khozenCommonParam, uiBean);
    }

    private void setWarningMessage() {

        if (uiBean.getWarningMessageIdList() != null && uiBean.getWarningMessageIdList().size() > 0) {
            for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                    uiBean.getWarningMessageIdList().get(i), uiBean.getWarningMessageList().get(i));
            }
        }

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                MessageId.WIC0001, uiBean.getZenkaisyorikekkakbn().getContent());
        }
    }


    private void updateKTKykKihon(BizDate pSysDate,String pSysTime) {

        uiBean.getKykKihon().setSyhenkouymd(pSysDate);
        uiBean.getKykKihon().setGyoumuKousinKinou(kinou.getKinouId());
        uiBean.getKykKihon().setGyoumuKousinsyaId(baseUserInfo.getUserId());
        uiBean.getKykKihon().setGyoumuKousinTime(pSysTime);
    }

    private List<IT_KykSyouhn> updateKTKykSyouhn(String pSikibetuKey, BizDate pSyoumetuYmd, C_Syoumetujiyuu pSyoumetujiyuu,String pSysTime) {

        List<IT_KykSyouhn> kykSyouhnLst = uiBean.getKykKihon().getKykSyouhns();
        for (IT_KykSyouhn kykSyouhn : kykSyouhnLst) {
            kykSyouhn.setHenkousikibetukey(pSikibetuKey);
            kykSyouhn.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
            kykSyouhn.setSyoumetujiyuu(pSyoumetujiyuu);
            kykSyouhn.setSyoumetuymd(pSyoumetuYmd);
            kykSyouhn.setGyoumuKousinKinou(kinou.getKinouId());
            kykSyouhn.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            kykSyouhn.setGyoumuKousinTime(pSysTime);
        }

        return kykSyouhnLst;
    }

    private void insertKhSntkInfoTouroku(Integer pKihrkpSeisanRrk, C_KankeisyaKbn pKankeisyaKbn,
        C_SntkInfoKykTorikesiKbn pSntkInfoKykTorikesiKbn,BizDate pSysDate,String pSysTime) {

        IT_KhSntkInfoTouroku khSntkInfoTouroku = new IT_KhSntkInfoTouroku();

        khSntkInfoTouroku.setSyono(uiBean.getSyono());
        khSntkInfoTouroku.setRenno(pKihrkpSeisanRrk);
        khSntkInfoTouroku.setSyoriYmd(pSysDate);
        khSntkInfoTouroku.setHuho2kykno(uiBean.getSyono());
        khSntkInfoTouroku.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        khSntkInfoTouroku.setSyouhncd(uiBean.getSyusyouhncd());
        khSntkInfoTouroku.setSntkinfokankeisyakbn(pKankeisyaKbn);
        khSntkInfoTouroku.setTaisyounmkn(uiBean.getVhhkshhknnmkn());
        if (C_KjkhukaKbn.KJKHUKA.eq(uiBean.getVhhkshhknnmkjkhukakbn())){
            khSntkInfoTouroku.setTaisyounmkj("");
        }
        else {
            khSntkInfoTouroku.setTaisyounmkj(uiBean.getVhhkshhknnmkj());
        }
        khSntkInfoTouroku.setTaisyouseiymd(uiBean.getVhhkshhknseiymd());
        khSntkInfoTouroku.setTaisyouseibetu(C_Seibetu.valueOf(uiBean.getVhhkshhknsei().getValue()));
        khSntkInfoTouroku.setDakuhiketnaiyouumukbn(C_BlnktkumuKbn.NONE);
        khSntkInfoTouroku.setKktnaiyouumukbn(C_BlnktkumuKbn.NONE);
        khSntkInfoTouroku.setKijinaiyouumukbn(C_BlnktkumuKbn.NONE);
        khSntkInfoTouroku.setMrumukbn(C_BlnktkumuKbn.NONE);
        khSntkInfoTouroku.setKoudosyougaiumukbn(C_BlnktkumuKbn.NONE);
        khSntkInfoTouroku.setTorikaijoumukbn(C_BlnktkumuKbn.ARI);
        khSntkInfoTouroku.setSntkinfokyktorikesikbn(pSntkInfoKykTorikesiKbn);
        khSntkInfoTouroku.setGyoumuKousinKinou(kinou.getKinouId());
        khSntkInfoTouroku.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        khSntkInfoTouroku.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(khSntkInfoTouroku);

        hozenDomManager.insert(khSntkInfoTouroku);
    }

    private void insertKTKhShrRrk(String pSikibetuKey, C_ShrsyoriKbn pShrsyoriKbn, String pDenrenno, BizDate pSysDate,
        String pSysTime,BizCurrency pJpyshrtienrsk, BizCurrency pShrtienrsk) {

        IT_KhShrRireki khShrRireki = uiBean.getKykKihon().getKhTtdkRirekiByHenkousikibetukey(pSikibetuKey)
            .createKhShrRireki();

        khShrRireki.setShrymd(uiBean.getShrymd());
        khShrRireki.setShrsyoriymd(pSysDate);
        khShrRireki.setShrsyorikbn(pShrsyoriKbn);
        khShrRireki.setSyoruiukeymd(uiBean.getSyoruiKanbiYmd());

        if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {
            khShrRireki.setKouryokuhasseiymd(uiBean.getSibouymd());
        }
        else if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ) {
            khShrRireki.setKouryokuhasseiymd(uiBean.getKaijyokessaiymd());
        }
        else {
            khShrRireki.setKouryokuhasseiymd(pSysDate);
        }

        if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {

            if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                khShrRireki.setShrtienrskkisanymd(uiBean.getTienrisokukisanymd());
                khShrRireki.setTienrsknissuu(uiBean.getTienrsknissuu());
                khShrRireki.setShrtuukashrgkgoukei(uiBean.getShrgkgoukeikakunin());
                khShrRireki.setShrtuukashrtienrsk(pShrtienrsk);
            }
            else {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    khShrRireki.setShrtienrskkisanymd(uiBean.getJpytienrisokukisanymd());
                    khShrRireki.setTienrsknissuu(uiBean.getJpytienrsknissuu());
                    khShrRireki.setShrtuukashrgkgoukei(uiBean.getJpyshrgkgoukeikakunin());
                    khShrRireki.setShrtuukashrtienrsk(pJpyshrtienrsk);
                }
                else {
                    khShrRireki.setShrtienrskkisanymd(uiBean.getTienrisokukisanymd());
                    khShrRireki.setTienrsknissuu(uiBean.getTienrsknissuu());
                    khShrRireki.setShrtuukashrgkgoukei(uiBean.getShrgkgoukeikakunin());
                    khShrRireki.setShrtuukashrtienrsk(pShrtienrsk);
                }
            }
        }
        else {
            khShrRireki.setShrtuukashrgkgoukei(uiBean.getNykntuukashrgkgoukeikakunin());
        }

        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

            if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                khShrRireki.setYenshrgkgoukei(uiBean.getShrgkgoukeikakunin());
                khShrRireki.setYenshrtienrsk(pShrtienrsk);
            }
            else {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    khShrRireki.setYenshrgkgoukei(uiBean.getJpyshrgkgoukeikakunin());
                    khShrRireki.setYenshrtienrsk(pJpyshrtienrsk);
                }
                else {
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    BizCurrency yenshrgkgoukei = keisanGaikakanzan.exec(C_Tuukasyu.JPY,uiBean.getShrgkgoukeikakunin(),
                        uiBean.getZeimukwsrate(),C_HasuusyoriKbn.SUTE);
                    khShrRireki.setYenshrgkgoukei(yenshrgkgoukei);

                    BizCurrency yenshrtienrsk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pShrtienrsk,
                        uiBean.getZeimukwsrate(),C_HasuusyoriKbn.SUTE);
                    khShrRireki.setYenshrtienrsk(yenshrtienrsk);
                }
            }
        }

        khShrRireki.setSinsagendokknkbn(uiBean.getSinsagendokknkbn());
        khShrRireki.setRikoukityuutuudannissuu(uiBean.getRikoukityuutuudannissuu());
        khShrRireki.setZeitratkikbn(C_ZeitratkiKbn.BLNK);
        khShrRireki.setYenshrtkumu(uiBean.getYenshrtkumu());
        khShrRireki.setKyktuukasyu(uiBean.getKyktuukasyu());
        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {
            khShrRireki.setSyushrgkkeisyukbn(C_SyuShrgkSyoukeiKbn.W);
            khShrRireki.setSyushrgkkei(uiBean.getKaiyakuhr());
        }
        else if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {
            khShrRireki.setSyushrgkkeisyukbn(C_SyuShrgkSyoukeiKbn.KIHARAIP);
            khShrRireki.setSyushrgkkei(uiBean.getKihrkmp());
        }
        else if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
            khShrRireki.setSyushrgkkeisyukbn(C_SyuShrgkSyoukeiKbn.V);
            khShrRireki.setSyushrgkkei(uiBean.getPtumitatekin());
        }
        if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
            khShrRireki.setMikeikap(uiBean.getMikeikap());
        }

        khShrRireki.setShrtuukasyu(uiBean.getShrtuukasyu());
        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {
            if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                khShrRireki.setShrtuukasyushrgkkei(uiBean.getShrsyousaijpykaiyakuhr());
            }
            else {
                khShrRireki.setShrtuukasyushrgkkei(uiBean.getKaiyakuhr());
            }
        }
        else if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {
            khShrRireki.setShrtuukasyushrgkkei(uiBean.getKihrkmp());
        }
        else if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
            if (C_Tuukasyu.JPY.eq(uiBean.getShrtuukasyu())) {
                khShrRireki.setShrtuukasyushrgkkei(uiBean.getShrsyousaijpyptumitatekin());
            }
            else {
                khShrRireki.setShrtuukasyushrgkkei(uiBean.getPtumitatekin());
            }
        }
        khShrRireki.setShrtuukasonotaseisangk(uiBean.getSonotaseisan());

        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {
            if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                khShrRireki.setYensyushrgkkei(uiBean.getShrsyousaijpykaiyakuhr());
            }
            else {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    khShrRireki.setYensyushrgkkei(uiBean.getShrsyousaijpykaiyakuhr());
                }
                else {
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY, uiBean.getKaiyakuhr(),
                        uiBean.getZeimukwsrate(), C_HasuusyoriKbn.SUTE);
                    khShrRireki.setYensyushrgkkei(kanzanGaku);
                }
            }
        }
        else if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
            if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                khShrRireki.setYensyushrgkkei(uiBean.getShrsyousaijpyptumitatekin());
            }
            else {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    khShrRireki.setYensyushrgkkei(uiBean.getShrsyousaijpyptumitatekin());
                }
                else {
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY, uiBean.getPtumitatekin(),
                        uiBean.getZeimukwsrate(), C_HasuusyoriKbn.SUTE);
                    khShrRireki.setYensyushrgkkei(kanzanGaku);
                }
            }
        }

        khShrRireki.setYenkansanhaitoukin(uiBean.getYenkahaitoukin());
        khShrRireki.setYenkansansonotaseisangk(uiBean.getSonotaseisan());
        khShrRireki.setYenmikeikap(uiBean.getYenkamikeikap());
        khShrRireki.setYenhtykeihi(uiBean.getHtykeihi());
        khShrRireki.setShrkwsratekjnymd(uiBean.getYenshrratetekiymd());
        khShrRireki.setShrkwsrate(uiBean.getShrkwsrate());
        khShrRireki.setZeimukwsratekjnymd(uiBean.getZeimukwsratekjnymd());
        khShrRireki.setZeimukwsrate(uiBean.getZeimukwsrate());
        khShrRireki.setSoukinsakisiteikbn(uiBean.getSoukinsakisiteikbn());
        khShrRireki.setSoukinsakinmkn(uiBean.getSoukinsakinmkn());
        khShrRireki.setSoukinsakinmkj(uiBean.getSoukinsakinmkj());
        khShrRireki.setSoukinsakiyno(uiBean.getSoukinsakiyno());
        khShrRireki.setSoukinsakiadr1kj(uiBean.getSoukinsakiadr1kj());
        khShrRireki.setSoukinsakiadr2kj(uiBean.getSoukinsakiadr2kj());
        khShrRireki.setSoukinsakiadr3kj(uiBean.getSoukinsakiadr3kj());
        khShrRireki.setKyksyaszknmkn(uiBean.getKyksyaszknmkn());
        khShrRireki.setKyksyaszknmkj(uiBean.getKyksyaszknmkj());
        khShrRireki.setKyksyaszkyno(uiBean.getKyksyaszkyno());
        khShrRireki.setKyksyaszkadr1kj(uiBean.getKyksyaszkadr1kj());
        khShrRireki.setKyksyaszkadr2kj(uiBean.getKyksyaszkadr2kj());
        khShrRireki.setKyksyaszkadr3kj(uiBean.getKyksyaszkadr3kj());
        khShrRireki.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());
        khShrRireki.setShrhousiteikbn(uiBean.getShrhousiteikbn());
        khShrRireki.setKzsyuruikbn(uiBean.getKzsyuruikbn());
        khShrRireki.setBankcd(uiBean.getBankcd());
        khShrRireki.setSitencd(uiBean.getSitencd());
        khShrRireki.setYokinkbn(uiBean.getYokinkbn());
        khShrRireki.setKouzano(uiBean.getKouzano());
        khShrRireki.setKzdoukbn(uiBean.getKzdoukbn());
        khShrRireki.setKzmeiginmkn(uiBean.getKzmeiginmkn());
        khShrRireki.setKykmnmeigibangou(uiBean.getKykmnmeigibangou());
        if (C_SoukinsakisiteiKbn.KYK.eq(uiBean.getSoukinsakisiteikbn())) {
            khShrRireki.setUktmnmeigibangou(uiBean.getKykmnmeigibangou());
        }
        else {
            khShrRireki.setUktmnmeigibangou(uiBean.getUktmnmeigibangou());
        }
        khShrRireki.setShrtysysyuruikbn(uiBean.getShrTysySyuruiKbn());
        khShrRireki.setDenrenno(pDenrenno);
        khShrRireki.setYenshrkykhtykeihi(uiBean.getYenshrkykhtykeihi());
        khShrRireki.setKykhnkkaisuu(uiBean.getKykHnkKaisuu());
        if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
            khShrRireki.setZennomikeikap(uiBean.getZennouseisankgk());
        }
        khShrRireki.setYenzennomikeikap(uiBean.getYenkazennouseisankgk());
        khShrRireki.setZitkazukarikingksiteituuka(uiBean.getAzukarikinkykhnkkaiyakuhr());
        khShrRireki.setZitkazukarikingkyen(uiBean.getYenazukarikinkykhnkmikeikap());
        khShrRireki.setYensonotahaitoukin(uiBean.getYentkbthaitoukin());
        if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {
            khShrRireki.setShrkrkgk(uiBean.getKrkgk());
        }
        khShrRireki.setYenkrkgk(uiBean.getYenkakrkgk());
        khShrRireki.setGaikashrkwsratekjnymd(uiBean.getSntshrgkssgikshrratetekiymd());
        khShrRireki.setGaikashrkwsrate(uiBean.getSntshrgkssgikshrrate());
        khShrRireki.setKaiyakuhrkngkkeisiteituuka(uiBean.getKaiyakuhrptumitatekingoukeiKyktuuka());

        if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
            khShrRireki.setShrtuukakaiyakuhrkngkkei(uiBean.getKaiyakuhrptumitatekingoukeiYen());
            khShrRireki.setShrtuukasonotashrkngk(uiBean.getSntshrgkssyensonotashrgk());
        }
        else {
            if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                khShrRireki.setShrtuukakaiyakuhrkngkkei(uiBean.getKaiyakuhrptumitatekingoukeiYen());
                khShrRireki.setShrtuukasonotashrkngk(uiBean.getSntshrgkssyensonotashrgk());
            }
            else {
                khShrRireki.setShrtuukakaiyakuhrkngkkei(uiBean.getKaiyakuhrptumitatekingoukeiKyktuuka());
                khShrRireki.setShrtuukasonotashrkngk(uiBean.getSntshrgksssonotashrgk());
            }
        }
        khShrRireki.setKaiyakuhrkngkkeiyen(uiBean.getKaiyakuhrptumitatekingoukeiYen());
        khShrRireki.setSonotashrkngksiteituuka(uiBean.getSntshrgksssonotashrgk());
        khShrRireki.setSonotashrkngkyen(uiBean.getSntshrgkssyensonotashrgk());
        khShrRireki.setYensynykngk(uiBean.getSynykngk());
        if (!C_HtsiryosyuKbn.BLNK.eq(uiBean.getShrTysySyuruiKbn())) {

            khShrRireki.setShrtysykurikosiyouhi(uiBean.getShrtysyKurikosiYouhi());
        }
        khShrRireki.setGyoumuKousinKinou(kinou.getKinouId());
        khShrRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        khShrRireki.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(khShrRireki);
    }

    private void insertKTKhShrRrkDtl(String pSikibetuKey,String pSysTime) {
        IT_KhShrRirekiDetail khShrRirekiDetail = uiBean.getKykKihon().getKhTtdkRirekiByHenkousikibetukey(pSikibetuKey)
            .getKhShrRireki().createKhShrRirekiDetail();
        khShrRirekiDetail.setSyouhncd(uiBean.getSyusyouhncd());
        khShrRirekiDetail.setSyouhnsdno(uiBean.getSyusyouhnsdno());
        khShrRirekiDetail.setKyksyouhnrenno(uiBean.getSyukyksyouhnrenno());

        if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {
            khShrRirekiDetail.setSyushrgk(uiBean.getKaiyakuhr());
        }
        else if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
            C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {
            khShrRirekiDetail.setSyushrgk(uiBean.getKihrkmp());
        }
        else if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
            khShrRirekiDetail.setSyushrgk(uiBean.getPtumitatekin());
        }
        khShrRirekiDetail.setShrtstmttkin(uiBean.getKiykhrsyousaiptumitatekin());
        khShrRirekiDetail.setSjkkktyouseigk(uiBean.getKiykhrsyousaisjkkktyouseigk());
        khShrRirekiDetail.setKaiyakusjkkktyouseiritu(uiBean.getSjkkktyouseirt());
        khShrRirekiDetail.setKaiyakusjkkktyouseiriritu(uiBean.getKaiyakusjkkktyouseiriritu());
        khShrRirekiDetail.setKaiyakukjgk(uiBean.getKaiyakukjgk());
        khShrRirekiDetail.setKaiyakukoujyoritu(uiBean.getKaiyakukjritu());
        khShrRirekiDetail.setGyoumuKousinKinou(kinou.getKinouId());
        khShrRirekiDetail.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        khShrRirekiDetail.setGyoumuKousinTime(pSysTime);
        khShrRirekiDetail.setTeiritutmttkngk(uiBean.getTeiritutmttkngk());
        khShrRirekiDetail.setSisuurendoutmttkngk(uiBean.getSisuurendoutmttkngk());

        BizPropertyInitializer.initialize(khShrRirekiDetail);
    }

    private void insertKhKeiyakuTorikesiWk (String pSysTime) {
        IW_KhKeiyakuTorikesiWk khKeiyakuTorikesiWk = new IW_KhKeiyakuTorikesiWk();
        khKeiyakuTorikesiWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        khKeiyakuTorikesiWk.setSyono(uiBean.getSyono());
        khKeiyakuTorikesiWk.setKyktrkskbn(uiBean.getKyktrkskbn());
        khKeiyakuTorikesiWk.setSibouymd(uiBean.getSibouymd());
        khKeiyakuTorikesiWk.setKaijyokessaiymd(uiBean.getKaijyokessaiymd());
        khKeiyakuTorikesiWk.setKaijyotuutiymd(uiBean.getKaijyotuutiymd());
        khKeiyakuTorikesiWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
        khKeiyakuTorikesiWk.setHubikanryouymd(uiBean.getHubikanryouymd());
        khKeiyakuTorikesiWk.setSinsagendokknkbn(uiBean.getSinsagendokknkbn());
        khKeiyakuTorikesiWk.setRikoukityuutuudannissuu(uiBean.getRikoukityuutuudannissuu());
        khKeiyakuTorikesiWk.setSoukinsakisiteikbn(uiBean.getSoukinsakisiteikbn());
        khKeiyakuTorikesiWk.setSoukinsakinmkn(uiBean.getSoukinsakinmkn());
        khKeiyakuTorikesiWk.setSoukinsakinmkj(uiBean.getSoukinsakinmkj());
        khKeiyakuTorikesiWk.setSoukinsakiyno(uiBean.getSoukinsakiyno());
        khKeiyakuTorikesiWk.setSoukinsakiadr1kj(uiBean.getSoukinsakiadr1kj());
        khKeiyakuTorikesiWk.setSoukinsakiadr2kj(uiBean.getSoukinsakiadr2kj());
        khKeiyakuTorikesiWk.setSoukinsakiadr3kj(uiBean.getSoukinsakiadr3kj());
        khKeiyakuTorikesiWk.setKyksyaszknmkn(uiBean.getKyksyaszknmkn());
        khKeiyakuTorikesiWk.setKyksyaszknmkj(uiBean.getKyksyaszknmkj());
        khKeiyakuTorikesiWk.setKyksyaszkyno(uiBean.getKyksyaszkyno());
        khKeiyakuTorikesiWk.setKyksyaszkadr1kj(uiBean.getKyksyaszkadr1kj());
        khKeiyakuTorikesiWk.setKyksyaszkadr2kj(uiBean.getKyksyaszkadr2kj());
        khKeiyakuTorikesiWk.setKyksyaszkadr3kj(uiBean.getKyksyaszkadr3kj());
        khKeiyakuTorikesiWk.setYenshrtkumu(uiBean.getYenshrtkumu());
        khKeiyakuTorikesiWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());
        if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn()) ||
            C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn())) {
            khKeiyakuTorikesiWk.setBankcd("");
            khKeiyakuTorikesiWk.setSitencd("");
            khKeiyakuTorikesiWk.setYokinkbn(C_YokinKbn.BLNK);
            khKeiyakuTorikesiWk.setKouzano("");
            khKeiyakuTorikesiWk.setKzdoukbn(C_Kzdou.BLNK);
            khKeiyakuTorikesiWk.setKzmeiginmkn("");
        }
        else {
            khKeiyakuTorikesiWk.setBankcd(uiBean.getBankcd());
            khKeiyakuTorikesiWk.setSitencd(uiBean.getSitencd());
            khKeiyakuTorikesiWk.setYokinkbn(uiBean.getYokinkbn());
            khKeiyakuTorikesiWk.setKouzano(uiBean.getKouzano());
            khKeiyakuTorikesiWk.setKzdoukbn(uiBean.getKzdoukbn());
            if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                khKeiyakuTorikesiWk.setKzmeiginmkn("");
            }
            else {
                khKeiyakuTorikesiWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
            }
        }
        khKeiyakuTorikesiWk.setKykmnmeigibangou(uiBean.getKykmnmeigibangou());
        khKeiyakuTorikesiWk.setUktmnmeigibangou(uiBean.getUktmnmeigibangou());
        khKeiyakuTorikesiWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
            khKeiyakuTorikesiWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }
        khKeiyakuTorikesiWk.setGyoumuKousinKinou(kinou.getKinouId());
        khKeiyakuTorikesiWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        khKeiyakuTorikesiWk.setGyoumuKousinTime(pSysTime);
        khKeiyakuTorikesiWk.setSoukinsakikbn(uiBean.getSoukinsakikbn());

        BizPropertyInitializer.initialize(khKeiyakuTorikesiWk);

        hozenDomManager.insert(khKeiyakuTorikesiWk);
    }

    private void updateKhKeiyakuTorikesiWk (String pSysTime,boolean pUpFLg) {

        IW_KhKeiyakuTorikesiWk khKeiyakuTorikesiWk = hozenDomManager.getKhKeiyakuTorikesiWk(
            uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if (pUpFLg) {
            khKeiyakuTorikesiWk.setSibouymd(uiBean.getSibouymd());
            khKeiyakuTorikesiWk.setKaijyokessaiymd(uiBean.getKaijyokessaiymd());
            khKeiyakuTorikesiWk.setKaijyotuutiymd(uiBean.getKaijyotuutiymd());
            khKeiyakuTorikesiWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            khKeiyakuTorikesiWk.setHubikanryouymd(uiBean.getHubikanryouymd());
            khKeiyakuTorikesiWk.setSinsagendokknkbn(uiBean.getSinsagendokknkbn());
            khKeiyakuTorikesiWk.setRikoukityuutuudannissuu(uiBean.getRikoukityuutuudannissuu());
            khKeiyakuTorikesiWk.setSoukinsakisiteikbn(uiBean.getSoukinsakisiteikbn());
            khKeiyakuTorikesiWk.setSoukinsakinmkn(uiBean.getSoukinsakinmkn());
            khKeiyakuTorikesiWk.setSoukinsakinmkj(uiBean.getSoukinsakinmkj());
            khKeiyakuTorikesiWk.setSoukinsakiyno(uiBean.getSoukinsakiyno());
            khKeiyakuTorikesiWk.setSoukinsakiadr1kj(uiBean.getSoukinsakiadr1kj());
            khKeiyakuTorikesiWk.setSoukinsakiadr2kj(uiBean.getSoukinsakiadr2kj());
            khKeiyakuTorikesiWk.setSoukinsakiadr3kj(uiBean.getSoukinsakiadr3kj());
            khKeiyakuTorikesiWk.setKyksyaszknmkn(uiBean.getKyksyaszknmkn());
            khKeiyakuTorikesiWk.setKyksyaszknmkj(uiBean.getKyksyaszknmkj());
            khKeiyakuTorikesiWk.setKyksyaszkyno(uiBean.getKyksyaszkyno());
            khKeiyakuTorikesiWk.setKyksyaszkadr1kj(uiBean.getKyksyaszkadr1kj());
            khKeiyakuTorikesiWk.setKyksyaszkadr2kj(uiBean.getKyksyaszkadr2kj());
            khKeiyakuTorikesiWk.setKyksyaszkadr3kj(uiBean.getKyksyaszkadr3kj());
            khKeiyakuTorikesiWk.setYenshrtkumu(uiBean.getYenshrtkumu());
            khKeiyakuTorikesiWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());
            if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn()) ||
                C_SoukinsakiKbn.TKSHKSHRKZ.eq(uiBean.getSoukinsakikbn())) {
                khKeiyakuTorikesiWk.setBankcd("");
                khKeiyakuTorikesiWk.setSitencd("");
                khKeiyakuTorikesiWk.setYokinkbn(C_YokinKbn.BLNK);
                khKeiyakuTorikesiWk.setKouzano("");
                khKeiyakuTorikesiWk.setKzdoukbn(C_Kzdou.BLNK);
                khKeiyakuTorikesiWk.setKzmeiginmkn("");
            }
            else {
                khKeiyakuTorikesiWk.setBankcd(uiBean.getBankcd());
                khKeiyakuTorikesiWk.setSitencd(uiBean.getSitencd());
                khKeiyakuTorikesiWk.setYokinkbn(uiBean.getYokinkbn());
                khKeiyakuTorikesiWk.setKouzano(uiBean.getKouzano());
                khKeiyakuTorikesiWk.setKzdoukbn(uiBean.getKzdoukbn());
                if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                    khKeiyakuTorikesiWk.setKzmeiginmkn("");
                }
                else {
                    khKeiyakuTorikesiWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
                }
            }
            khKeiyakuTorikesiWk.setKykmnmeigibangou(uiBean.getKykmnmeigibangou());
            khKeiyakuTorikesiWk.setUktmnmeigibangou(uiBean.getUktmnmeigibangou());
            khKeiyakuTorikesiWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            khKeiyakuTorikesiWk.setSoukinsakikbn(uiBean.getSoukinsakikbn());
        }

        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
            khKeiyakuTorikesiWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        khKeiyakuTorikesiWk.setGyoumuKousinKinou(kinou.getKinouId());
        khKeiyakuTorikesiWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        khKeiyakuTorikesiWk.setGyoumuKousinTime(pSysTime);

        hozenDomManager.update(khKeiyakuTorikesiWk);
    }

    private void updateKhHenreikin(BizDate pSysDate, String pSysTime) {

        List<IT_KhHenreikin> khHenreikinList =
            hozenDomManager.getKhHenreikinYendtMbrsBySyono(uiBean.getSyono());
        if (khHenreikinList.size() > 0) {

            IT_KhHenreikin khHenreikin = khHenreikinList.get(0);

            khHenreikin.setShrymd(uiBean.getShrymd());
            khHenreikin.setShrsyoriymd(pSysDate);
            khHenreikin.setHrsiharaijyoutaikbn(C_Siharaijyoutaikbn.SIHARAIZUMI);
            khHenreikin.setGyoumuKousinKinou(kinou.getKinouId());
            khHenreikin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            khHenreikin.setGyoumuKousinTime(pSysTime);

            hozenDomManager.update(khHenreikin);

        }
    }

    private void doJikouteikanri() {

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

        khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),uiBean.getKouteiLockKey(),
            uiBean.getSyanaicommentkh(), khRuleBean);

        pushUnlockProcessBL();
    }

    private void checkProcessKaishi (String pJimuTetuzukiCd) {
        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(),pJimuTetuzukiCd);

        if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
            BzGetProcessSummaryOutBean getProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();
            throw new BizLogicException(MessageId.EIA1002,DefaultDateFormatter.formatYMDZeroFill(getProcessSummaryOutBean.getKouteiStartYmd()));
        }
    }

    private void continueLockProcessBL() {

        bzCommonLockProcess.continueLockProcess();
    }

    private void updateAzukarikin(BizDate pSysDate, String pSysTime) {
        if (uiBean.getAzukarikinkykhnkkaiyakuhr().compareTo(
            BizCurrency.valueOf(0, uiBean.getAzukarikinkykhnkkaiyakuhr().getType())) > 0 ||
            uiBean.getYenazukarikinkykhnkmikeikap().compareTo(
                BizCurrency.valueOf(0, uiBean.getYenazukarikinkykhnkmikeikap().getType())) > 0) {

            List<IT_Azukarikin> azukarikinLst = khKeiyakuTorikesiDao.getAzukarikinsBySyono(uiBean.getKykKihon());

            if (azukarikinLst.size() > 0) {
                for (IT_Azukarikin azukarikin : azukarikinLst) {
                    azukarikin.setShrymd(uiBean.getShrymd());
                    azukarikin.setShrsyoriymd(pSysDate);
                    azukarikin.setGyoumuKousinKinou(kinou.getKinouId());
                    azukarikin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    azukarikin.setGyoumuKousinTime(pSysTime);
                }
            }
        }
    }

    private void updateKariukekin(String pSysTime) {

        if (uiBean.getYenkakrkgk().compareTo(BizCurrency.valueOf(0, uiBean.getYenkakrkgk().getType())) > 0) {

            List<IT_Kariukekin> kariukekinLst = khKeiyakuTorikesiDao.getKariukekinsBySyono(uiBean.getKykKihon());

            if (kariukekinLst.size() > 0) {

                for (IT_Kariukekin kariukekin : kariukekinLst) {
                    kariukekin.setSeisandenymd(uiBean.getShrymd());
                    kariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
                    kariukekin.setGyoumuKousinKinou(kinou.getKinouId());
                    kariukekin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    kariukekin.setGyoumuKousinTime(pSysTime);
                }
            }
        }
    }

    private void editAnsyuKihonAndZennouAndKihrkmpSeisanRireki(KhozenCommonParam pKhozenCommonParam, BizDate pSysDate,
        String pSysTime,String pHenkousikibetuKey, List<IT_KykSyouhn> pKykSyouhnLst) {

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = SWAKInjector.getInstance(ZennouKoujyogakuKeisanParam.class);
        EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);

        IT_AnsyuKihon ansyuKihon = pKhozenCommonParam.getAnsyuuKihon(uiBean.getSyono());

        if (C_Kykjyoutai.ZENNOU.eq(uiBean.getKykjyoutai())) {

            ansyuKihon.setGyoumuKousinKinou(kinou.getKinouId());
            ansyuKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            ansyuKihon.setGyoumuKousinTime(pSysTime);

            if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {
                if (BizDateUtil.compareYm(ansyuKihon.getJkipjytym(), uiBean.getLastPJyuutouYm().addYears(1)) == BizDateUtil.COMPARE_GREATER) {
                    KykHenkoujiZnnJytTrksKsn kykHenkoujiZnnJytTrksKsn = SWAKInjector.getInstance(KykHenkoujiZnnJytTrksKsn.class);
                    kykHenkoujiZnnJytTrksKsn.exec(pKhozenCommonParam, uiBean.getSyono(), pSysDate,
                        uiBean.getLastPJyuutouYm().addYears(1), C_ZennouSeisanSyoriKbn.SYOUMETU);
                }
            }
            List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();
            SortIT_Zennou sortIT_Zennou = SWAKInjector.getInstance(SortIT_Zennou.class);
            zennouLst = sortIT_Zennou.OrderIT_ZennouByPkDesc(zennouLst);

            if (zennouLst.size() > 0) {
                for (IT_Zennou zennou : zennouLst) {
                    zennou.setZennouseisankbn(C_ZennouSeisanKbn.SEISANZUMI);
                    zennou.setZennouseisansyoriymd(pSysDate);

                    if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn())) {

                        zennou.setZennouseisankgk(uiBean.getZennouseisankinKnrtuuka());
                        zennou.setZennouseisankijyunymd(uiBean.getCalcKijyunYmd());

                        if (uiBean.getZennouseisankinKnrtuuka() != null &&
                            uiBean.getZennouseisankinKnrtuuka().isOptional() == false &&
                            uiBean.getZennouseisankinKnrtuuka().compareTo(BizCurrency.valueOf(0, uiBean.getZennouseisankinKnrtuuka().getType())) > 0) {
                            zennou.setZennouseisandenymd(uiBean.getShrymd());
                        }

                    } else if (C_KyktrksKbn.CLGOFF.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.KYKTORIKESI.eq(uiBean.getKyktrkskbn()) ||
                        C_KyktrksKbn.SBMUKOU_KIHARAIP.eq(uiBean.getKyktrkskbn())) {

                        zennou.setZennouseisankgk(uiBean.getZennounyuukinkgk());
                        zennou.setZennouseisankijyunymd(uiBean.getRyosyuymd());
                        zennou.setZennouseisandenymd(uiBean.getShrymd());
                    }

                    zennou.setGyoumuKousinKinou(kinou.getKinouId());
                    zennou.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    zennou.setGyoumuKousinTime(pSysTime);
                }

                IT_Zennou zennou = zennouLst.get(0);

                zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(zennou.getKjsmyouzennoukaisiymd());
                zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm(zennou.getKjsmyouzennoukikanm());
                zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(zennou.getKjsmyouzennounyuukinkgk());
                zennouKoujyogakuKeisanParam.setHrkp(uiBean.getKykKihon().getHrkp());
                zennouKoujyogakuKeisanParam.setHrkkaisuu(uiBean.getHrkkaisuu());
                zennouKoujyogakuKeisanParam.setZennoukaisiymd(zennou.getZennoukaisiymd());
                zennouKoujyogakuKeisanParam.setZennourenno(zennou.getRenno());
                zennouKoujyogakuKeisanParam.setKjsmyouyenknsnkawaserate(zennou.getKjsmyouyenkansankwsrate());

                editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);
            }

            hozenDomManager.update(ansyuKihon);
        }

        if (uiBean.getMikeikapKnrtuuka().compareTo(BizCurrency.valueOf(0, uiBean.getMikeikapKnrtuuka().getType())) > 0) {

            Integer maxSeqNo = hozenDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono(uiBean.getSyono());

            if (maxSeqNo != null) {
                maxSeqNo = maxSeqNo + 1;
            }
            else {
                maxSeqNo = 1;
            }

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = uiBean.getKykKihon().createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki.setRenno(maxSeqNo);
            kihrkmpSeisanRireki.setHenkousikibetukey(pHenkousikibetuKey);
            if (C_KyktrksKbn.SBMENSEKI.eq(uiBean.getKyktrkskbn()) || C_KyktrksKbn.SBKAIJO.eq(uiBean.getKyktrkskbn())) {
                kihrkmpSeisanRireki.setKouryokuhasseiymd(uiBean.getSibouymd());
            }
            else if (C_KyktrksKbn.KAIJO.eq(uiBean.getKyktrkskbn())) {
                kihrkmpSeisanRireki.setKouryokuhasseiymd(uiBean.getKaijyokessaiymd());
            }
            kihrkmpSeisanRireki.setKihrkpssnaiyoukbn(C_KiharaiPseisanNaiyouKbn.SEISANP);
            kihrkmpSeisanRireki.setJyuutouym(uiBean.getMikeikaPJyutouYM());
            kihrkmpSeisanRireki.setSeijyutoukaisuum(uiBean.getMikeikaPJyutouKaisuuM());
            kihrkmpSeisanRireki.setSeijyutoukaisuuy(uiBean.getMikeikaPJyutouKaisuuY());
            kihrkmpSeisanRireki.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MIKEIKAP);
            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinhanteikbn()) {
                kihrkmpSeisanRireki.setRstuukasyu(uiBean.getKyktuukasyu());
            }
            kihrkmpSeisanRireki.setSeisanpgoukei(BizCurrency.valueOf(0));
            kihrkmpSeisanRireki.setYenkansansspgoukei(BizCurrency.valueOf(0));
            kihrkmpSeisanRireki.setHenkank(BizCurrency.valueOf(0));
            kihrkmpSeisanRireki.setYenkansanhenkankin(BizCurrency.valueOf(0));
            if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == uiBean.getSyohinhanteikbn()) {
                    if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                        kihrkmpSeisanRireki.setZeimukwsratekjnymd(uiBean.getYenshrratetekiymd());
                        kihrkmpSeisanRireki.setZeimukwsrate(uiBean.getYenshrrate());
                    }
                    else {
                        kihrkmpSeisanRireki.setZeimukwsratekjnymd(uiBean.getZeimukwsratekjnymd());
                        kihrkmpSeisanRireki.setZeimukwsrate(uiBean.getZeimukwsrate());
                    }
                }
            }
            kihrkmpSeisanRireki.setGyoumuKousinKinou(kinou.getKinouId());
            kihrkmpSeisanRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            kihrkmpSeisanRireki.setGyoumuKousinTime(pSysTime);

            BizPropertyInitializer.initialize(kihrkmpSeisanRireki);

            List<KykSyouhnCommonParam> kykSyouhnCommonParamLst =  Lists.newArrayList();
            kykSyouhnCommonParamLst.addAll(pKykSyouhnLst);

            editKoujyonaiyouTbl.setCalcKjnYmd(uiBean.getCalcKijyunYmd());
            editKoujyonaiyouTbl.setHenmaeJkipJytYm(ansyuKihon.getJkipjytym());
            editKoujyonaiyouTbl.setHenmaeHenkousikibetukey(pHenkousikibetuKey);
            editKoujyonaiyouTbl.setKihrkpSeisanRenno(maxSeqNo);
            editKoujyonaiyouTbl.setKihrkpSeisanJytYm(uiBean.getMikeikaPJyutouYM());
            editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(uiBean.getMikeikaPJyutouKaisuuY());
            editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(uiBean.getMikeikaPJyutouKaisuuM());
            editKoujyonaiyouTbl.setMkkp(uiBean.getMikeikapKnrtuuka());
            if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                if (C_UmuKbn.ARI.eq(uiBean.getYenshrtkumu())) {
                    editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(uiBean.getYenshrrate());
                }
                else {
                    editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(uiBean.getZeimukwsrate());
                }
            }
            editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamLst);

            editKoujyonaiyouTbl.exec(pKhozenCommonParam, uiBean.getSyono(),
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, pSysDate);
        }
    }
}
