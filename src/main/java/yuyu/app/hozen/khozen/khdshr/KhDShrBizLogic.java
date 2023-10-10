package yuyu.app.hozen.khozen.khdshr;

import static yuyu.app.hozen.khozen.khdshr.GenKhDShrConstants.*;
import static yuyu.app.hozen.khozen.khdshr.KhDShrConstants.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzHanteiAgUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzFbSoukinDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksBean;
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
import yuyu.common.hozen.haitou.CheckDShrDShr;
import yuyu.common.hozen.haitou.DBAccessDCommonDShr;
import yuyu.common.hozen.haitou.KeisanDCommonDShr;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CommonSiwake;
import yuyu.common.hozen.khcommon.CommonSiwakeInBean;
import yuyu.common.hozen.khcommon.CommonSiwakeOutBean;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.EditSouhuannaiParam;
import yuyu.common.hozen.khcommon.EditTtdkKanryouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiSyoriKengen;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanSiharaibi;
import yuyu.common.hozen.khcommon.KeisanTienRisoku;
import yuyu.common.hozen.khcommon.KhCheckKouza;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenEdit;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.khcommon.TaisyouGkBean;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetHituyouSyorui;
import yuyu.common.hozen.setuibean.SetHosyou;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtil;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetSonotaTk;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyuShrgkSyoukeiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IW_KhDShrWk;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.OutputReport;

/**
 * 配当金支払 のビジネスロジックです。
 */
public class KhDShrBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhDShrUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private HozenPreReportRenkeiBean hozenPreReportRenkeiBean;

    @Inject
    private OutputReport outputReport;

    @Inject
    private CommonDispImage commonDispImage;

    void init() {
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

        IW_KhDShrWk khDShrWk = hozenDomManager.getKhDShrWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if (khDShrWk == null) {
            throw new BizAppException(MessageId.EBS0004, IW_KhDShrWk.TABLE_NAME, IW_KhDShrWk.KOUTEIKANRIID,
                uiBean.getBzWorkflowInfo().getKouteiKanriId());
        }

        uiBean.setZenkaisyorikekkakbn(khDShrWk.getZenkaisyorikekkakbn());

        uiBean.setHaitoukinskkbn(khDShrWk.getHaitoukinskkbn());
        uiBean.setHaitoukinskkngk(khDShrWk.getHaitoukinskkngk());
        if (C_TumitateDSakuseiKbn.ITIBUHIKIDASI.eq(uiBean.getHaitoukinskkbn())) {
            uiBean.setInputhaitoukinskkngk(khDShrWk.getHaitoukinskkngk().divide(1000).toAdsoluteString());
        }
        uiBean.setInputshrhousiteikbn(khDShrWk.getInputshrhousiteikbn());
        uiBean.setBankcd(khDShrWk.getBankcd());
        uiBean.setSitencd(khDShrWk.getSitencd());
        uiBean.setYokinkbn(khDShrWk.getYokinkbn());
        uiBean.setKouzano(khDShrWk.getKouzano());
        uiBean.setKzdoukbn(khDShrWk.getKzdoukbn());
        uiBean.setKzmeiginmkn(khDShrWk.getKzmeiginmkn());
        uiBean.setHonninkakninkekkakbn(khDShrWk.getHonninkakninkekkakbn());
        uiBean.setShskyno(khDShrWk.getShskyno());
        uiBean.setShsadr1kj(khDShrWk.getShsadr1kj());
        uiBean.setShsadr2kj(khDShrWk.getShsadr2kj());
        uiBean.setShsadr3kj(khDShrWk.getShsadr3kj());

        setUiBean(khozenCommonParam);

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        setProgressHistory.exec(uiBean);

        List<IT_KykSyouhn> kykSyouhnLst = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        BizDate soruittykymd;

        if (khDShrWk.getSyoruiukeymd() == null) {
            GetSyoruittykymd getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);
            soruittykymd = getSyoruittykymd.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                C_SyoruiCdKbn.KK_DSHR_SKS);
        }
        else {
            soruittykymd = khDShrWk.getSyoruiukeymd();
        }

        uiBean.setSyoruiukeymd(soruittykymd);

        uiBean.setSyusyouhncd(kykSyouhnLst.get(0).getSyouhncd());
        uiBean.setSyusyouhnsdno(kykSyouhnLst.get(0).getSyouhnsdno());
        uiBean.setKykjyoutai(kykSyouhnLst.get(0).getKykjyoutai());
        uiBean.setYendthnkymd(kykSyouhnLst.get(0).getYendthnkymd());

        IT_AnsyuKihon ansyuKihon = khozenCommonParam.getAnsyuuKihon(uiBean.getSyono());
        uiBean.setJkipjytym(ansyuKihon.getJkipjytym());

        setWarningMessage();
    }

    void pushNyuuryokubtnBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkKykSonzai();

        checkYuukouJyoutai(khozenCommonParam);

        checkTetudukiTyuui(khozenCommonParam);

        CheckDShrDShr checkDShrDShr = SWAKInjector.getInstance(CheckDShrDShr.class);
        C_ErrorKbn checkExistsDShrTaisyouErrorKbn = checkDShrDShr.checkExistsDShrTaisyou(uiBean.getSyono());

        if (C_ErrorKbn.ERROR.eq(checkExistsDShrTaisyouErrorKbn)) {
            throw new CommonBizAppException("配当支払対象存在チェックが実行できませんでした。");
        }

        if (C_UmuKbn.NONE.eq(checkDShrDShr.getDShrTaisyouUmu())) {
            throw new BizLogicException(MessageId.EIF1093);
        }

        IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();
        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getZeiseitkkktkykhukaumu())) {
            throw new BizLogicException(MessageId.EIA1035);
        }

        setWarningMessage();

        setUiBean(khozenCommonParam);

        List<IT_KykSyouhn> kykSyouhnLst = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

        uiBean.setSyoruiukeymd(BizDate.getSysDate());

        uiBean.setSyusyouhncd(kykSyouhnLst.get(0).getSyouhncd());
        uiBean.setSyusyouhnsdno(kykSyouhnLst.get(0).getSyouhnsdno());
        uiBean.setKykjyoutai(kykSyouhnLst.get(0).getKykjyoutai());
        uiBean.setYendthnkymd(kykSyouhnLst.get(0).getYendthnkymd());

        IT_AnsyuKihon ansyuKihon = khozenCommonParam.getAnsyuuKihon(uiBean.getSyono());
        uiBean.setJkipjytym(ansyuKihon.getJkipjytym());

        uiBean.setHonninkakninkekkakbn(C_HonninKakninKekkaKbn.SUMI_HONNINKOUZA);

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);
        hanteiSyoriKengen.exec();

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHDSHR);
    }

    void pushSyoukaibtnBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        boolean syoriResult = checkYuuyokkngai.exec(uiBean.getSyono(), BizDate.getSysDate());

        if (!syoriResult) {
            throw new BizLogicException(MessageId.EIA0085);
        }

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) ||
            !C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            BizDate sysDate = BizDate.getSysDate();


            if (uiBean.getSyoruiukeymd() == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SHIHARAISYORINYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            BizDate jkipjytymd = BizDate.valueOf(uiBean.getJkipjytym(), uiBean.getVhsyusyukykymd().getDay()).getRekijyou();

            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
                CheckDShrDShr checkDShrDShr = SWAKInjector.getInstance(CheckDShrDShr.class);

                C_ErrorKbn tumitateDKanriUmuErrorKbn = checkDShrDShr.checkSakihidukeTumitateDKanriUmu(
                    uiBean.getSyono(), uiBean.getSyoruiukeymd());

                if (C_ErrorKbn.ERROR.eq(tumitateDKanriUmuErrorKbn)) {
                    throw new CommonBizAppException("先日付積立Ｄ管理情報有無チェックが実行できませんでした。");
                }

                if (C_UmuKbn.ARI.eq(checkDShrDShr.getSakihidukeTumitateDKanriUmu())) {
                    throw new BizLogicException(MessageId.EIA1044, checkDShrDShr.getTumitatedSksKbn().getContent());
                }

                BizDate calcKijyunYmd = null;

                if (C_Kykjyoutai.ITIJIBARAI.eq(uiBean.getKykjyoutai())) {
                    calcKijyunYmd = uiBean.getSyoruiukeymd();
                }
                else if (C_Kykjyoutai.HRKMTYUU.eq(uiBean.getKykjyoutai()) ||
                    C_Kykjyoutai.IKKATUNK.eq(uiBean.getKykjyoutai()) ||
                    C_Kykjyoutai.ZENNOU.eq(uiBean.getKykjyoutai())) {

                    if (BizDateUtil.compareYmd(sysDate, jkipjytymd) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(sysDate, jkipjytymd) == BizDateUtil.COMPARE_EQUAL) {
                        calcKijyunYmd = sysDate;
                    }
                    else {
                        calcKijyunYmd = jkipjytymd;
                    }
                }

                C_ErrorKbn tounendoDUmuErrorKbn =  checkDShrDShr.checkTounendoDUmu(uiBean.getSyono(), calcKijyunYmd);

                if (C_ErrorKbn.ERROR.eq(tounendoDUmuErrorKbn)) {
                    throw new CommonBizAppException("当年度配当有無チェックが実行できませんでした。");
                }

                if (C_UmuKbn.NONE.eq(checkDShrDShr.getTounendoDUmu())) {
                    throw new BizLogicException(MessageId.EIA1041);
                }
            }
            else {
                if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                    throw new BizLogicException(MessageId.EBA0026,
                        MessageUtil.getMessage(DDID_SHIHARAISYORINYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
                }
            }

            C_YouhiKbn pMinyuchkyh = null;

            if (C_Kykjyoutai.ITIJIBARAI.eq(uiBean.getKykjyoutai())) {
                pMinyuchkyh = C_YouhiKbn.HUYOU;
            }
            else if (C_Kykjyoutai.HRKMTYUU.eq(uiBean.getKykjyoutai()) ||
                C_Kykjyoutai.IKKATUNK.eq(uiBean.getKykjyoutai()) ||
                C_Kykjyoutai.ZENNOU.eq(uiBean.getKykjyoutai())) {
                pMinyuchkyh = C_YouhiKbn.YOU;
            }

            CheckDShrDShr checkDShrDShr = SWAKInjector.getInstance(CheckDShrDShr.class);

            C_ErrorKbn dShrErrorKbn = checkDShrDShr.checkDShr(uiBean.getSyono(), sysDate,
                uiBean.getJkipjytym(), pMinyuchkyh, sysDate);

            if (C_ErrorKbn.ERROR.eq(dShrErrorKbn)) {
                throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
            }

            if (C_SyorikahiKbn.SYORIHUKA.eq(checkDShrDShr.getSyorikahiKbn())) {
                if (C_UmuKbn.ARI.eq(checkDShrDShr.getDHuseigouUmu())) {
                    throw new BizLogicException(MessageId.EBS1012);
                }

                if (C_UmuKbn.ARI.eq(checkDShrDShr.getMihaneiDUmu())) {
                    throw new BizLogicException(MessageId.EBA1048);
                }

                BizDate kijyunYmd = null;
                if (uiBean.getYendthnkymd() == null) {
                    kijyunYmd = uiBean.getVhsyusyukykymd();
                }
                else {
                    kijyunYmd = uiBean.getYendthnkymd();
                }

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
                BizDate outouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, kijyunYmd, C_Hrkkaisuu.NEN, sysDate);

                if (C_UmuKbn.ARI.eq(checkDShrDShr.getDHaneiYmdUmu())) {

                    if (((C_Kykjyoutai.HRKMTYUU.eq(uiBean.getKykjyoutai()) ||
                        C_Kykjyoutai.IKKATUNK.eq(uiBean.getKykjyoutai()) ||
                        C_Kykjyoutai.ZENNOU.eq(uiBean.getKykjyoutai())) &&
                        (BizDateUtil.compareYmd(jkipjytymd, outouYmd) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYmd(jkipjytymd, outouYmd) == BizDateUtil.COMPARE_EQUAL)) ||
                        C_Kykjyoutai.ITIJIBARAI.eq(uiBean.getKykjyoutai())) {
                        throw new BizLogicException(MessageId.EIF1099);
                    }
                }

                if (C_UmuKbn.ARI.eq(checkDShrDShr.getDShrYmdUmu())) {
                    throw new BizLogicException(MessageId.EIF1100);
                }
            }

            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
                boolean isMRFAccount = checkMrfAccount();

                if (isMRFAccount) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WBA1006);
                }
            }

            Integer syoruiUkeKyoyou = YuyuHozenConfig.getInstance().getSyoruiUkeKyoyou();
            BizDate syoruiUkeKyoyouDate = uiBean.getSyoruiukeymd().addDays(syoruiUkeKyoyou);

            if (BizDateUtil.compareYmd(sysDate, syoruiUkeKyoyouDate) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(sysDate, syoruiUkeKyoyouDate) == BizDateUtil.COMPARE_GREATER) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3,
                    MessageId.WIF1004,
                    MessageUtil.getMessage(DDID_SHIHARAISYORINYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()),
                    syoruiUkeKyoyou.toString() + "日");
            }

            KeisanDCommonDShr keisanDCommonDShr = SWAKInjector.getInstance(KeisanDCommonDShr.class);

            C_ErrorKbn allhikidasiErrorKbn =  keisanDCommonDShr.calcDShrgkAllhikidasi(uiBean.getSyono(), sysDate, sysDate, uiBean.getJkipjytym());

            if (C_ErrorKbn.ERROR.eq(allhikidasiErrorKbn)) {
                throw new CommonBizAppException("配当支払金計算が実行できませんでした。");
            }

            uiBean.setTumitatehaitouganrikin(keisanDCommonDShr.getShrgk());
        }

        SetHituyouSyorui.exec(khozenCommonParam, uiBean);

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);
    }

    void pushSainyuuryokubtnOnClickBL() {

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING3);

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);
    }

    void pushSeikyusyoSakuseiBL() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), BizDate.getSysDate()) != BizDateUtil.COMPARE_EQUAL) {
            throw new BizLogicException(MessageId.EIA1042,
                MessageUtil.getMessage(DDID_SHIHARAISYORINYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
        }

        if (C_Kykjyoutai.HRKMTYUU.eq(uiBean.getKykjyoutai()) ||
            C_Kykjyoutai.IKKATUNK.eq(uiBean.getKykjyoutai()) ||
            C_Kykjyoutai.ZENNOU.eq(uiBean.getKykjyoutai())) {

            CheckDShrDShr checkDShrDShr = SWAKInjector.getInstance(CheckDShrDShr.class);

            C_ErrorKbn dShrErrorKbn = checkDShrDShr.checkDShr(uiBean.getSyono(),
                BizDate.getSysDate(), uiBean.getJkipjytym(), C_YouhiKbn.YOU, BizDate.getSysDate());

            if (C_ErrorKbn.ERROR.eq(dShrErrorKbn)) {
                throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
            }

            if (C_UmuKbn.ARI.eq(checkDShrDShr.getDHaneiYmdUmu())) {

                throw new BizLogicException(MessageId.EIA1067);
            }
        }

        messageManager.addMessageId(MessageId.QIA0004);
    }

    void pushKakuninBL() {

        BizDate sysDate = BizDate.getSysDate();

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }

        BizCurrency itibuhikidasiskkngk = BizCurrency.optional(BizCurrencyTypes.YEN);

        if (C_TumitateDSakuseiKbn.ITIBUHIKIDASI.eq(uiBean.getHaitoukinskkbn()) &&
            !BizUtil.isBlank(uiBean.getInputhaitoukinskkngk())) {
            itibuhikidasiskkngk = BizCurrency.valueOf(
                new BigDecimal(uiBean.getInputhaitoukinskkngk())).multiply(1000);
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) ||
            ((C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            C_YouhiKbn pMinyuchkyh = null;

            if (C_Kykjyoutai.ITIJIBARAI.eq(uiBean.getKykjyoutai())) {
                pMinyuchkyh = C_YouhiKbn.HUYOU;
            }
            else if (C_Kykjyoutai.HRKMTYUU.eq(uiBean.getKykjyoutai()) ||
                C_Kykjyoutai.IKKATUNK.eq(uiBean.getKykjyoutai())||
                C_Kykjyoutai.ZENNOU.eq(uiBean.getKykjyoutai())) {
                pMinyuchkyh = C_YouhiKbn.YOU;
            }

            CheckDShrDShr checkDShrDShr = SWAKInjector.getInstance(CheckDShrDShr.class);

            C_ErrorKbn dShrErrorKbn = checkDShrDShr.checkDShr(uiBean.getSyono(), sysDate, uiBean.getJkipjytym(), pMinyuchkyh, sysDate);

            if (C_ErrorKbn.ERROR.eq(dShrErrorKbn)) {
                throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
            }

            if (C_UmuKbn.ARI.eq(checkDShrDShr.getMihaneiDUmu())) {
                throw new BizLogicException(MessageId.EBA1048);
            }

            if (C_Kykjyoutai.HRKMTYUU.eq(uiBean.getKykjyoutai()) ||
                C_Kykjyoutai.IKKATUNK.eq(uiBean.getKykjyoutai()) ||
                C_Kykjyoutai.ZENNOU.eq(uiBean.getKykjyoutai())) {

                if (C_UmuKbn.ARI.eq(checkDShrDShr.getDHaneiYmdUmu())) {

                    throw new BizLogicException(MessageId.EIA1067);
                }
            }

            if (C_TumitateDSakuseiKbn.BLNK.eq(uiBean.getHaitoukinskkbn())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SKNAIYOUINFO_HAITOUKINSKKBN.getErrorResourceKey()));
            }

            if (C_TumitateDSakuseiKbn.ZENHIKIDASI.eq(uiBean.getHaitoukinskkbn())) {
                if (!BizUtil.isBlank(uiBean.getInputhaitoukinskkngk())) {
                    throw new BizLogicException(MessageId.EBA0108,
                        MessageUtil.getMessage(DDID_SKNAIYOUINFO_INPUTHAITOUKINSKKNGK.getErrorResourceKey()));
                }
            }
            else {
                if (BizUtil.isBlank(uiBean.getInputhaitoukinskkngk())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_SKNAIYOUINFO_INPUTHAITOUKINSKKNGK.getErrorResourceKey()));
                }

                if (itibuhikidasiskkngk.compareTo(uiBean.getTumitatehaitouganrikin()) > 0) {
                    throw new BizLogicException(MessageId.EIA1043);
                }
            }

            KeisanDCommonDShr keisanDCommonDShr = SWAKInjector.getInstance(KeisanDCommonDShr.class);

            C_ErrorKbn errorKbn = C_ErrorKbn.OK;

            if (C_TumitateDSakuseiKbn.ZENHIKIDASI.eq(uiBean.getHaitoukinskkbn())) {
                errorKbn = keisanDCommonDShr.calcDShrgkAllhikidasi(uiBean.getSyono(), sysDate, sysDate, uiBean.getJkipjytym());
            }
            else {
                errorKbn = keisanDCommonDShr.calcDShrgkItibuhikidasi(uiBean.getSyono(), sysDate, sysDate,
                    itibuhikidasiskkngk, uiBean.getJkipjytym());
            }

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException("配当支払金計算が実行できませんでした。");
            }

            uiBean.setHaitoukinskkngk(keisanDCommonDShr.getShrgk());
            uiBean.setTumitatehaitouganrikin2(uiBean.getHaitoukinskkngk());
            uiBean.setShrtmtthtkinzndk(keisanDCommonDShr.getWrmdsMaeTumitated());
            uiBean.setWrmdsAtoTumitated(keisanDCommonDShr.getWrmdsAtoTumitated());
            uiBean.setKhTumitateDKanriKeyinfoBean(keisanDCommonDShr.getKeyInfoKhTumitateDKanriBean());

            if (C_InputShrhousiteiKbn.BLNK.eq(uiBean.getInputshrhousiteikbn())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SIHARAIHOUHOU_INPUTSHRHOUSITEIKBN.getErrorResourceKey()));
            }

            uiBean.setShrtuukasyu(C_Tuukasyu.JPY);

            if (C_InputShrhousiteiKbn.FBSOUKIN.eq(uiBean.getInputshrhousiteikbn())) {
                KhCheckKouza khCheckKouza = SWAKInjector.getInstance(KhCheckKouza.class);

                khCheckKouza.chkSoukinsakiKouza(uiBean, khozenCommonParam);

                uiBean.setBanknmkj(khCheckKouza.getGinkouName());
                uiBean.setSitennmkj(khCheckKouza.getShitenName());

                uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
            }

            if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(uiBean.getInputshrhousiteikbn()) ||
                C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getInputshrhousiteikbn())) {
                if (!BizUtil.isBlank(uiBean.getBankcd()) ||
                    !BizUtil.isBlank(uiBean.getSitencd()) ||
                    !C_YokinKbn.BLNK.eq(uiBean.getYokinkbn()) ||
                    !BizUtil.isBlank(uiBean.getKouzano()) ||
                    !C_Kzdou.BLNK.eq(uiBean.getKzdoukbn()) ||
                    !BizUtil.isBlank(uiBean.getKzmeiginmkn())) {
                    throw new BizLogicException(MessageId.EBA0108, KOUSAJOUHOU);
                }
            }

            KeisanSiharaibi kisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);
            BizDate siharaibi = kisanSiharaibi.exec(sysDate, uiBean.getInputshrhousiteikbn(),
                uiBean.getShrtuukasyu(), uiBean.getBankcd());

            uiBean.setCalckijyunymd(sysDate);
            uiBean.setShrymd(siharaibi);
            uiBean.setShrhousiteikbn(kisanSiharaibi.getShrhousiteiKbn());

            BizCurrency shrtienrsk = BizCurrency.optional(BizCurrencyTypes.YEN);
            BizDate shrtienrskStartYmd = null;
            Integer shrtienNissuu = null;

            if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhousiteikbn())) {
                KeisanTienRisoku keisanTienRisoku = SWAKInjector.getInstance(KeisanTienRisoku.class);

                keisanTienRisoku.exec(uiBean.getSyoruiukeymd(), siharaibi, uiBean.getTumitatehaitouganrikin2());

                shrtienrsk = keisanTienRisoku.getKeisanTienrisokuBean().getShrtienrsk();
                shrtienrskStartYmd = uiBean.getSyoruiukeymd();
                shrtienNissuu = keisanTienRisoku.getKeisanTienrisokuBean().getShrtienNissuu();
            }

            String disptienrskkisanymdnissuu = KhozenEdit.editTienRkksanhi(
                uiBean.getShrhousiteikbn(), shrtienrsk, shrtienrskStartYmd, shrtienNissuu);

            uiBean.setDisptienrskkisanymdnissuu(disptienrskkisanymdnissuu);
            uiBean.setShrtienrsk(shrtienrsk);
            uiBean.setShrgkgoukeikakunin(uiBean.getTumitatehaitouganrikin2().add(doKingakuHenkan(shrtienrsk)));
            uiBean.setSiharaitienrisokukisanbi(shrtienrskStartYmd);
            uiBean.setTienrisokuhisuu(shrtienNissuu);

            if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_HONNININFO_HONNINKAKNINKEKKAKBN.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getShskyno())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SHSNMINFO_SHSKYNO.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getShsadr1kj())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SHSNMINFO_SHSADR1KJ.getErrorResourceKey()));
            }

            BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);

            BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(uiBean.getShsadr1kj(),
                uiBean.getShsadr2kj(), uiBean.getShsadr3kj());

            if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {
                throw new BizLogicException(MessageId.EBA1003, SHSADRKJ,
                    String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                    String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
            }

            boolean isMRFAccount = checkMrfAccount();

            if (isMRFAccount) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WBA1007);
            }
        }
        else {
            if (C_TumitateDSakuseiKbn.ZENHIKIDASI.eq(uiBean.getHaitoukinskkbn())) {
                uiBean.setHaitoukinskkngk(uiBean.getTumitatehaitouganrikin());
            }
            else {
                uiBean.setHaitoukinskkngk(itibuhikidasiskkngk);
            }
        }

        CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);
        checkProcessKekka.exec(uiBean.getSyorikekkakbn(), uiBean.getSyanaicommentkh(),uiBean.getSasimodosisakikbn());

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

            C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA1002,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));

            }
        }

        messageManager.addMessageId(MessageId.QBA0001);

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);
    }

    @Transactional
    void pushKakuteiBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }
        else {

            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

            C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();
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

            bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
            bzForceTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                C_KhkinouModeIdKbn.INPUT.getValue(), bzCommonLockProcess.getKouteiLockKey());
        }

        String functionId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

            String sikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
            tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetuKey);

            IT_KykKihon kykKihon = uiBean.getKykKihon();
            kykKihon.setSyhenkouymd(sysDate);
            kykKihon.setGyoumuKousinKinou(functionId);
            kykKihon.setGyoumuKousinsyaId(userId);
            kykKihon.setGyoumuKousinTime(sysTime);

            DBAccessDCommonDShr dBAccessDCommonDShr = SWAKInjector.getInstance(DBAccessDCommonDShr.class);

            C_ErrorKbn errorKbn = dBAccessDCommonDShr.insertHaitouInfo(sysDate, uiBean.getWrmdsAtoTumitated(),
                uiBean.getKhTumitateDKanriKeyinfoBean(), uiBean.getHaitoukinskkbn(), khozenCommonParam);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException("配当情報追加が実行できませんでした。");
            }

            IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey(sikibetuKey);

            insertKihrkmpSeisanRireki(sikibetuKey, sysDate, functionId, userId, sysTime);

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType tuukasyuType = henkanTuuka.henkanTuukaKbnToType(uiBean.getKyktuukasyu());

            BizCurrency keiyakutuukaGk = BizCurrency.valueOf(0, tuukasyuType);

            List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();

            TaisyouGkBean taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
            taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);
            taisyouGkBean.setTaisyouGk(uiBean.getTumitatehaitouganrikin2());
            taisyouGkBean.setKeiyakutuukaGk(keiyakutuukaGk);
            taisyouGkBeanLst.add(taisyouGkBean);

            taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
            taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
            taisyouGkBean.setTaisyouGk(doKingakuHenkan(uiBean.getShrtienrsk()));
            taisyouGkBean.setKeiyakutuukaGk(keiyakutuukaGk);
            taisyouGkBeanLst.add(taisyouGkBean);

            taisyouGkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
            taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
            taisyouGkBean.setTaisyouGk(uiBean.getShrgkgoukeikakunin());
            taisyouGkBean.setKeiyakutuukaGk(keiyakutuukaGk);
            taisyouGkBeanLst.add(taisyouGkBean);

            CommonSiwakeInBean commonSiwakeInBean = SWAKInjector.getInstance(CommonSiwakeInBean.class);

            commonSiwakeInBean.setKinouId(functionId);
            commonSiwakeInBean.setDenYmd(uiBean.getShrymd());
            commonSiwakeInBean.setTuukasyu(uiBean.getShrtuukasyu());
            commonSiwakeInBean.setSyoriYmd(sysDate);
            commonSiwakeInBean.setKykYmd(uiBean.getVhsyusyukykymd());
            commonSiwakeInBean.setSyouhnCd(uiBean.getSyusyouhncd());
            commonSiwakeInBean.setSyouhnsdNo(uiBean.getSyusyouhnsdno());
            commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.BLNK);
            commonSiwakeInBean.setShrhousiteiKbn(uiBean.getShrhousiteikbn());
            commonSiwakeInBean.setKyktuukaSyu(uiBean.getVhsyusyukyktuukasyu());
            commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.optional());
            commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

            CommonSiwake commonSiwake = SWAKInjector.getInstance(CommonSiwake.class);
            CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

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
            bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(userId);
            bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
            bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(null);
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

            uiBean.setDenpyoudatarenban(khDenpyoDataLst.get(0).getDenrenno());

            insertKTKhShrRrk(sikibetuKey, sysDate, functionId, userId, sysTime);

            if (C_ShrhousiteiKbn.FB_YOKUJITU.eq(uiBean.getShrhousiteikbn()) ||
                C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(uiBean.getShrhousiteikbn()) ||
                C_ShrhousiteiKbn.FB_3EIGYOUBI.eq(uiBean.getShrhousiteikbn())) {

                BzFbSoukinDataSksBean bzFbSoukinDataSksBean  = SWAKInjector.getInstance(BzFbSoukinDataSksBean .class);

                bzFbSoukinDataSksBean.setDenbyouyouDataRenbon(uiBean.getDenpyoudatarenban());
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
                bzFbSoukinDataSksBean.setSouKingk(uiBean.getShrgkgoukeikakunin());
                bzFbSoukinDataSksBean.setKykTuukasyu(uiBean.getKyktuukasyu());
                bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.optional());
                bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.optional());
                bzFbSoukinDataSksBean.setKinouId(functionId);
                bzFbSoukinDataSksBean.setUserId(userId);
                bzFbSoukinDataSksBean.setDengyoumuCd(khDenpyoDataLst.get(0).getDengyoumucd());

                BzFbSoukinDataSks bzFbSoukinDataSks = SWAKInjector.getInstance(BzFbSoukinDataSks.class);
                IT_KhFBSoukinData khFBSoukinData = bzFbSoukinDataSks.execKh(bzFbSoukinDataSksBean);

                hozenDomManager.insert(khFBSoukinData);
            }

            makeTetudukiRireki(khozenCommonParam, sysTime, sysDate);

            makeTyouhyou(khozenCommonParam, sysDate);

            hozenDomManager.update(uiBean.getKykKihon());
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

            IW_KhDShrWk khDShrWk = hozenDomManager.getKhDShrWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

            hozenDomManager.delete(khDShrWk);
        }
        else if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()))) {

            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                insertKhDShrWk(GAMENSYORIKBN_CONFIRM, sysDate, functionId, userId, sysTime,khozenCommonParam);
            }
            else {
                updateKhDShrWk(functionId, userId, sysTime);
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

    void pushModoruByConfirmBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            bzCommonLockProcess.continueLockProcess();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            boolean isMRFAccount = checkMrfAccount();

            if (isMRFAccount) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WBA1006);
            }
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);
    }

    @Transactional
    void pushKakuteiByskConfirmBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String functionId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);

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


        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);
        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);

        editSouhuannaiParam.setCalckijyunymd(sysDate);
        editSouhuannaiParam.setTmtthtkinzndk(uiBean.getTumitatehaitouganrikin());

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);
        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<C_SyoruiCdKbn>();
        syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_DSHR_SOUHU);
        syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_DSHR_SKS);

        C_SyoruiCdKbn[] syoruiCds = syoruiCdKbnLst.toArray(new C_SyoruiCdKbn[0]);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(), syoruiCds, C_YouhiKbn.YOU);

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setReportKey(khozenTyouhyouCtl.getTyouhyouKey());

        uiBean.getBzWorkflowInfo().setKouteiKanriId(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());
        insertKhDShrWk(GAMENSYORIKBN_SKSCONFIRM, sysDate, functionId, userId, sysTime,khozenCommonParam);

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);
    }

    void printOut() {

        String tyhykey = uiBean.getReportKey();

        outputReport.outputPDFByJoinKey(tyhykey);
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
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
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
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    private void setUiBean(KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);

        SetKihon.exec(pKhozenCommonParam, uiBean);

        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);

        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);

        SetTuusinsaki.exec(pKhozenCommonParam, uiBean);

        SetHosyou setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyou.exec(pKhozenCommonParam, uiBean);

        SetSonotaTk.exec(pKhozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(pKhozenCommonParam, uiBean);

        SetTrkKazoku.exec(pKhozenCommonParam, uiBean);

        SetKyksyadairi.exec(pKhozenCommonParam, uiBean);
    }

    private void setWarningMessage() {

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                MessageId.WIC0001, uiBean.getZenkaisyorikekkakbn().getContent());
        }
    }

    private boolean checkMrfAccount () {

        List<IT_KykDairiten> kykDairitenLst = uiBean.getKykKihon().getKykDairitens();


        boolean isMRFAccount = false;

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        List<BzGetAgInfoBean> bzGetAgInfoBeanListA = bzGetAgInfo.exec(kykDairitenLst.get(0).getDrtencd());
        isMRFAccount = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(bzGetAgInfoBeanListA.get(1).getOyadrtenCd());

        if (kykDairitenLst.size() > 1 && !isMRFAccount) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanListB = bzGetAgInfo.exec(kykDairitenLst.get(1).getDrtencd());
            isMRFAccount = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(bzGetAgInfoBeanListB.get(1).getOyadrtenCd());
        }

        return isMRFAccount;
    }

    private void insertKihrkmpSeisanRireki(String pHenkousikibetuKey, BizDate pSysDate, String pKinouId,
        String pUserId, String pSysTime) {

        Integer maxRenno = hozenDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono(uiBean.getSyono());

        if (maxRenno != null) {
            maxRenno = maxRenno + 1;
        }
        else {
            maxRenno = 1;
        }

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = uiBean.getKykKihon().createKihrkmpSeisanRireki();
        kihrkmpSeisanRireki.setRenno(maxRenno);
        kihrkmpSeisanRireki.setHenkousikibetukey(pHenkousikibetuKey);
        kihrkmpSeisanRireki.setKouryokuhasseiymd(pSysDate);
        kihrkmpSeisanRireki.setKihrkpssnaiyoukbn(C_KiharaiPseisanNaiyouKbn.HENKANKIN);
        kihrkmpSeisanRireki.setHenkank(uiBean.getTumitatehaitouganrikin2());
        kihrkmpSeisanRireki.setYenkansanhenkankin(uiBean.getTumitatehaitouganrikin2());
        kihrkmpSeisanRireki.setGyoumuKousinKinou(pKinouId);
        kihrkmpSeisanRireki.setGyoumuKousinsyaId(pUserId);
        kihrkmpSeisanRireki.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(kihrkmpSeisanRireki);
    }

    private void insertKTKhShrRrk(String pHenkousikibetuKey, BizDate pSysDate, String pKinouId, String pUserId,
        String pSysTime) {

        IT_KhShrRireki khShrRireki =
            uiBean.getKykKihon().getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetuKey).createKhShrRireki();

        khShrRireki.setShrymd(uiBean.getShrymd());
        khShrRireki.setShrsyoriymd(pSysDate);
        khShrRireki.setShrsyorikbn(C_ShrsyoriKbn.DSHR);
        khShrRireki.setSyoruiukeymd(uiBean.getSyoruiukeymd());
        khShrRireki.setKouryokuhasseiymd(pSysDate);
        khShrRireki.setShrtienrskkisanymd(uiBean.getSiharaitienrisokukisanbi());
        khShrRireki.setTienrsknissuu(uiBean.getTienrisokuhisuu());
        khShrRireki.setKyktuukasyu(uiBean.getKyktuukasyu());
        khShrRireki.setShrgkkei(uiBean.getShrgkgoukeikakunin());
        khShrRireki.setSyushrgkkeisyukbn(C_SyuShrgkSyoukeiKbn.D);
        khShrRireki.setSyushrgkkei(uiBean.getTumitatehaitouganrikin2());
        khShrRireki.setHaitoukin(uiBean.getTumitatehaitouganrikin2());
        khShrRireki.setShrtienrsk(uiBean.getShrtienrsk());
        khShrRireki.setShrtuukasyu(uiBean.getShrtuukasyu());
        khShrRireki.setShrtuukashrgkgoukei(uiBean.getShrgkgoukeikakunin());
        khShrRireki.setShrtuukasyushrgkkei(uiBean.getTumitatehaitouganrikin2());
        khShrRireki.setShrtuukahaitoukin(uiBean.getTumitatehaitouganrikin2());
        khShrRireki.setShrtuukashrtienrsk(uiBean.getShrtienrsk());
        khShrRireki.setYenshrgkgoukei(uiBean.getShrgkgoukeikakunin());
        khShrRireki.setYensyushrgkkei(uiBean.getTumitatehaitouganrikin2());
        khShrRireki.setYenkansanhaitoukin(uiBean.getTumitatehaitouganrikin2());
        khShrRireki.setYenshrtienrsk(uiBean.getShrtienrsk());
        khShrRireki.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());
        khShrRireki.setShrhousiteikbn(uiBean.getShrhousiteikbn());
        khShrRireki.setKzsyuruikbn(uiBean.getKzsyuruikbn());
        khShrRireki.setBankcd(uiBean.getBankcd());
        khShrRireki.setSitencd(uiBean.getSitencd());
        khShrRireki.setYokinkbn(uiBean.getYokinkbn());
        khShrRireki.setKouzano(uiBean.getKouzano());
        khShrRireki.setKzdoukbn(uiBean.getKzdoukbn());
        khShrRireki.setKzmeiginmkn(uiBean.getKzmeiginmkn());
        khShrRireki.setDenrenno(uiBean.getDenpyoudatarenban());
        khShrRireki.setGyoumuKousinKinou(pKinouId);
        khShrRireki.setGyoumuKousinsyaId(pUserId);
        khShrRireki.setGyoumuKousinTime(pSysTime);
        khShrRireki.setShrtysykurikosiyouhi(C_YouhiKbn.HUYOU);

        BizPropertyInitializer.initialize(khShrRireki);
    }

    private void makeTetudukiRireki(KhozenCommonParam pKhozenCommonParam, String pSysTime, BizDate pSysDate) {

        PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);
        pALKykNaiyouKousin.exec(uiBean.getKykKihon());

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(pKhozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(pSysDate);
        editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.ARI);
        editTtdkRirekiTblParam.setSysTime(pSysTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);
        editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());
        editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        editTtdkRirekiTblParam.setYoukyuuNo(pALKykNaiyouKousin.getYoukyuuno());
        editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.BLNK);

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    private void makeTyouhyou(KhozenCommonParam pKhozenCommonParam, BizDate pSysDate) {

        EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);

        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.DSHR);
        editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_DSHR_TTDKKR);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setShsyno(uiBean.getShskyno());
        editTtdkKanryouParam.setShsadr1kj(uiBean.getShsadr1kj());
        editTtdkKanryouParam.setShsadr2kj(uiBean.getShsadr2kj());
        editTtdkKanryouParam.setShsadr3kj(uiBean.getShsadr3kj());
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setTmtthtkinzndk(uiBean.getShrtmtthtkinzndk());

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
        khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.BLNK);

        C_SyoruiCdKbn[] syoruiCds = new C_SyoruiCdKbn[] {C_SyoruiCdKbn.KK_DSHR_TTDKKR};

        khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam, uiBean.getSyono(), syoruiCds, C_YouhiKbn.YOU);
        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setReportKey(khozenTyouhyouCtl.getTyouhyouKey());
    }

    private void insertKhDShrWk(String pSyorikbn, BizDate pSysDate, String pKinouId, String pUserId, String pSysTime,
        KhozenCommonParam pKhozenCommonParam) {

        IW_KhDShrWk khDShrWk = new IW_KhDShrWk();

        khDShrWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        khDShrWk.setSyono(uiBean.getSyono());
        khDShrWk.setGyoumuKousinKinou(pKinouId);
        khDShrWk.setGyoumuKousinsyaId(pUserId);
        khDShrWk.setGyoumuKousinTime(pSysTime);

        if (GAMENSYORIKBN_CONFIRM.equals(pSyorikbn)) {
            khDShrWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            khDShrWk.setHaitoukinskkbn(uiBean.getHaitoukinskkbn());
            khDShrWk.setHaitoukinskkngk(uiBean.getHaitoukinskkngk());
            khDShrWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());
            khDShrWk.setBankcd(uiBean.getBankcd());
            khDShrWk.setSitencd(uiBean.getSitencd());
            khDShrWk.setYokinkbn(uiBean.getYokinkbn());
            khDShrWk.setKouzano(uiBean.getKouzano());
            khDShrWk.setKzdoukbn(uiBean.getKzdoukbn());
            if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                khDShrWk.setKzmeiginmkn("");
            }
            else {
                khDShrWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
            }
            khDShrWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
                khDShrWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }

            khDShrWk.setShskyno(uiBean.getShskyno());
            khDShrWk.setShsadr1kj(uiBean.getShsadr1kj());
            khDShrWk.setShsadr2kj(uiBean.getShsadr2kj());
            khDShrWk.setShsadr3kj(uiBean.getShsadr3kj());
        }
        else {
            khDShrWk.setSkssakuseiymd(pSysDate);
            khDShrWk.setHonninkakninkekkakbn(C_HonninKakninKekkaKbn.SUMI_HONNINKOUZA);

            IT_KykSya kykSya = pKhozenCommonParam.getKeiyakusya(uiBean.getSyono());

            khDShrWk.setShskyno(kykSya.getTsinyno());
            khDShrWk.setShsadr1kj(kykSya.getTsinadr1kj());
            khDShrWk.setShsadr2kj(kykSya.getTsinadr2kj());
            khDShrWk.setShsadr3kj(kykSya.getTsinadr3kj());
        }

        BizPropertyInitializer.initialize(khDShrWk);

        hozenDomManager.insert(khDShrWk);
    }

    private void updateKhDShrWk(String pKinouId, String pUserId, String pSysTime) {

        IW_KhDShrWk khDShrWk = hozenDomManager.getKhDShrWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());


        khDShrWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());

        if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
            (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn()))) {
            khDShrWk.setHaitoukinskkbn(uiBean.getHaitoukinskkbn());
            khDShrWk.setHaitoukinskkngk(uiBean.getHaitoukinskkngk());
            khDShrWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());
            khDShrWk.setBankcd(uiBean.getBankcd());
            khDShrWk.setSitencd(uiBean.getSitencd());
            khDShrWk.setYokinkbn(uiBean.getYokinkbn());
            khDShrWk.setKouzano(uiBean.getKouzano());
            khDShrWk.setKzdoukbn(uiBean.getKzdoukbn());
            if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                khDShrWk.setKzmeiginmkn("");
            }
            else {
                khDShrWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
            }
            khDShrWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            khDShrWk.setShskyno(uiBean.getShskyno());
            khDShrWk.setShsadr1kj(uiBean.getShsadr1kj());
            khDShrWk.setShsadr2kj(uiBean.getShsadr2kj());
            khDShrWk.setShsadr3kj(uiBean.getShsadr3kj());
        }

        if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) &&
            !C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
            khDShrWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        khDShrWk.setGyoumuKousinKinou(pKinouId);
        khDShrWk.setGyoumuKousinsyaId(pUserId);
        khDShrWk.setGyoumuKousinTime(pSysTime);

        hozenDomManager.update(khDShrWk);
    }

    private void doJikouteikanri() {

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);
        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

        khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(), bzCommonLockProcess.getKouteiLockKey(),
            uiBean.getSyanaicommentkh(), khRuleBean);

        bzCommonLockProcess.unlockProcess();
    }

    private BizCurrency doKingakuHenkan(BizCurrency pHenkanZenGk) {

        if (pHenkanZenGk.isOptional()) {
            return BizCurrency.valueOf(0, pHenkanZenGk.getType());
        }
        return pHenkanZenGk;
    }
}
