package yuyu.app.hozen.khozen.khyendthnkhrshr;

import static yuyu.app.hozen.khozen.khyendthnkhrshr.GenKhYendtHnkHrShrConstants.*;
import static yuyu.app.hozen.khozen.khyendthnkhrshr.KhYendtHnkHrShrConstants.*;

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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import com.lowagie.text.pdf.PdfReader;

import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.CheckMeigininNmKanji;
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
import yuyu.common.hozen.khcommon.CheckFatca;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
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
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.khcommon.TaisyouGkBean;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetHihokensya;
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
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_FatcatghtkekKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyuShrgkSyoukeiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IW_KhYendtHnkHrShrWk;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.DBAOutputReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.PdfBuilder;

/**
 * 円建変更時返戻金支払 のビジネスロジックです。
 */
public class KhYendtHnkHrShrBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhYendtHnkHrShrUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private GetSyoruittykymd getSyoruittykymd;

    @Inject
    private CommonDispImage commonDispImage;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private HozenPreReportRenkeiBean hozenPreReportRenkeiBean;

    @Inject
    private OutputReport outputReport;

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

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        checkYuukouJyoutai(khozenCommonParam);

        checkTetudukiTyuui(syoNo, khozenCommonParam);

        IW_KhYendtHnkHrShrWk khYendtHnkHrShrWk = hozenDomManager.getKhYendtHnkHrShrWk(kouteikanriid);
        if (khYendtHnkHrShrWk == null) {
            throw new CommonBizAppException(IW_KhYendtHnkHrShrWk.TABLE_NAME + " 取得エラー");
        }

        uiBean.setKhhrshrjiyuu(khYendtHnkHrShrWk.getKhhrshrjiyuu());
        uiBean.setKyksyaszknmkn(khYendtHnkHrShrWk.getKyksyaszknmkn());
        uiBean.setKyksyaszknmkj(khYendtHnkHrShrWk.getKyksyaszknmkj());
        uiBean.setKyksyaszkyno(khYendtHnkHrShrWk.getKyksyaszkyno());
        uiBean.setKyksyaszkadr1kj(khYendtHnkHrShrWk.getKyksyaszkadr1kj());
        uiBean.setKyksyaszkadr2kj(khYendtHnkHrShrWk.getKyksyaszkadr2kj());
        uiBean.setKyksyaszkadr3kj(khYendtHnkHrShrWk.getKyksyaszkadr3kj());
        uiBean.setInputshrhousiteikbn(khYendtHnkHrShrWk.getInputshrhousiteikbn());
        uiBean.setBankcd(khYendtHnkHrShrWk.getBankcd());
        uiBean.setSitencd(khYendtHnkHrShrWk.getSitencd());
        uiBean.setYokinkbn(khYendtHnkHrShrWk.getYokinkbn());
        uiBean.setKouzano(khYendtHnkHrShrWk.getKouzano());
        uiBean.setKzdoukbn(khYendtHnkHrShrWk.getKzdoukbn());
        uiBean.setKzmeiginmkn(khYendtHnkHrShrWk.getKzmeiginmkn());
        uiBean.setHonninkakninkekkakbn(khYendtHnkHrShrWk.getHonninkakninkekkakbn());
        uiBean.setHassoukbn(khYendtHnkHrShrWk.getHassoukbn());
        uiBean.setZenkaisyorikekkakbn(khYendtHnkHrShrWk.getZenkaisyorikekkakbn());

        setUiBean(khozenCommonParam);

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);

        setProgressHistory.exec(uiBean);

        setSyokiKoumoku(khozenCommonParam);

        BizDate soruittykymd;
        if (khYendtHnkHrShrWk.getSyoruiukeymd() == null) {
            soruittykymd = getSyoruittykymd.exec(kouteikanriid, C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS);
        }
        else {
            soruittykymd = khYendtHnkHrShrWk.getSyoruiukeymd();
        }
        uiBean.setSyoruiukeymd(soruittykymd);

        checkFatcaKakuninYouhi(syoNo, khozenCommonParam);

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())
            && C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
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

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkYuukouJyoutai(khozenCommonParam);

        checkTetudukiTyuui(syoNo, khozenCommonParam);

        Long khHenreikinYendtMbrCnt = hozenDomManager.getKhHenreikinYendtMbrCountBySyono(syoNo);

        if (khHenreikinYendtMbrCnt == 0) {
            throw new BizLogicException(MessageId.EIF1077);
        }

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKHRSHR);

        setUiBean(khozenCommonParam);

        setSyokiKoumoku(khozenCommonParam);

        uiBean.setSyoruiukeymd(BizDate.getSysDate());

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);
        hanteiSyoriKengen.exec();

        checkFatcaKakuninYouhi(syoNo, khozenCommonParam);
    }

    void pushSyoukaiBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }

        BizDate sysDate = BizDate.getSysDate();

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) ||
            !C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()))  {
            if (uiBean.getSyoruiukeymd() == null) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SHIHARAISYORINYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EIA0037,
                    MessageUtil.getMessage(DDID_SHIHARAISYORINYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(),
                uiBean.getYendthnkymd()) == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(MessageId.EIF1078);
            }

            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
                Boolean isMRFAccount = checkMrfAccount();

                if (isMRFAccount == true) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WBA1006);
                }
            }

            List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono(uiBean.getSyono());

            if (khHenreikinLst.size() == 1) {

                uiBean.setYendthnkhr(khHenreikinLst.get(0).getHenreikingk());
                uiBean.setShrgkgoukeisyoukai(khHenreikinLst.get(0).getHenreikingk());
                uiBean.setDisptienrskkisanymdnissuu(MIKEISANN);
            }
            else {
                throw new CommonBizAppException(IT_KhHenreikin.TABLE_NAME + " 取得エラー");
            }

            Integer syoruiUkeKyoyou = YuyuHozenConfig.getInstance().getSyoruiUkeKyoyou();
            BizDate syoruiUkeKyoyouDate = uiBean.getSyoruiukeymd().addDays(syoruiUkeKyoyou);

            if (BizDateUtil.compareYmd(sysDate, syoruiUkeKyoyouDate) != BizDateUtil.COMPARE_LESSER) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING3,
                    MessageId.WIF1004,
                    MessageUtil.getMessage(DDID_SHIHARAISYORINYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()),
                    syoruiUkeKyoyou.toString() + "日");
            }
        }
        C_Khhrshrjiyuu khhrshrjiyuu = uiBean.getKhhrshrjiyuu();

        if (C_Khhrshrjiyuu.KYKSB.eq(khhrshrjiyuu)) {
            uiBean.setDaisennintdkumukbn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setDaisennintdkumukbn(C_UmuKbn.NONE);
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        SetHituyouSyorui.exec(khozenCommonParam, uiBean);

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);
    }

    void pushKakuninBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) ||
            ((C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {
            if (C_Khhrshrjiyuu.KYKSB.eq(uiBean.getKhhrshrjiyuu())) {
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
                    throw new BizLogicException(MessageId.EBC0043, KYKSYASZKINFO_KYKSYASZKADRKJ);
                }

                BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);

                BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(uiBean.getKyksyaszkadr1kj(),
                    uiBean.getKyksyaszkadr2kj(), uiBean.getKyksyaszkadr3kj());

                if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn())) {
                    throw new BizLogicException(MessageId.EBA1003,
                        KYKSYASZKINFO_KYKSYASZKADRKJ,
                        String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                        String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
                }
            }

            if (uiBean.getShrgkgoukeisyoukai().compareTo(
                BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) {
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

                    if (C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {
                        throw new BizLogicException(MessageId.EIA1008, uiBean.getInputshrhousiteikbn().getContent());
                    }
                }
            }

            if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_HONNININFO_HONNINKAKNINKEKKAKBN.getErrorResourceKey()));
            }

            KeisanSiharaibi kisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);
            BizDate siharaibi = kisanSiharaibi.exec(
                BizDate.getSysDate(),
                uiBean.getInputshrhousiteikbn(),
                uiBean.getShrtuukasyu(),
                uiBean.getBankcd());
            uiBean.setShrymd(siharaibi);
            uiBean.setShrhousiteikbn(kisanSiharaibi.getShrhousiteiKbn());


            BizCurrency shrtienrsk = BizCurrency.optional(BizCurrencyTypes.YEN);
            BizDate shrtienrskStartYmd = null;
            Integer shrtienNissuu = null;

            if (!C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(uiBean.getShrhousiteikbn())) {

                KeisanTienRisoku keisanTienRisoku = SWAKInjector.getInstance(KeisanTienRisoku.class);

                keisanTienRisoku.exec(uiBean.getSyoruiukeymd(), siharaibi, uiBean.getYendthnkhr());
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
            uiBean.setShrgkgoukeikakunin(uiBean.getYendthnkhr().add(doKingakuHenkan(shrtienrsk)));

            CheckFatca checkFatca = SWAKInjector.getInstance(CheckFatca.class);

            if (C_Khhrshrjiyuu.KYKSB.eq(uiBean.getKhhrshrjiyuu())) {
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

            if (C_Khhrshrjiyuu.KYKSB.eq(uiBean.getKhhrshrjiyuu())) {
                if (uiBean.getYendthnkhr().compareTo(HYAKUMANEN) > 0) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF1025);
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

        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

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
        String functionId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

            String sikibetuKey = khozenCommonParam.getSikibetuKey(syoNo);
            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
            tableMaintenanceUtil.backUp(syoNo, sikibetuKey);

            IT_KykKihon kykKihon = uiBean.getKykKihon();
            kykKihon.setSyhenkouymd(sysDate);
            kykKihon.setGyoumuKousinKinou(functionId);
            kykKihon.setGyoumuKousinsyaId(userId);
            kykKihon.setGyoumuKousinTime(sysTime);

            IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey(sikibetuKey);

            List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono(syoNo);

            if (khHenreikinLst.size() > 0) {

                khHenreikinLst.get(0).setShrymd(uiBean.getShrymd());
                khHenreikinLst.get(0).setShrsyoriymd(sysDate);
                khHenreikinLst.get(0).setHrsiharaijyoutaikbn(C_Siharaijyoutaikbn.SIHARAIZUMI);
                khHenreikinLst.get(0).setGyoumuKousinKinou(functionId);
                khHenreikinLst.get(0).setGyoumuKousinsyaId(userId);
                khHenreikinLst.get(0).setGyoumuKousinTime(sysTime);
            }

            if (uiBean.getShrgkgoukeisyoukai().compareTo(
                BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) {

                List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();

                TaisyouGkBean taisyouGkYendthnkhrBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                taisyouGkYendthnkhrBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_YENDTHNKHR);
                taisyouGkYendthnkhrBean.setTaisyouGk(uiBean.getYendthnkhr());
                taisyouGkYendthnkhrBean.setKeiyakutuukaGk(uiBean.getYendthnkhr());
                taisyouGkYendthnkhrBean.setSeg1cd(khHenreikinLst.get(0).getSeg1cd());
                taisyouGkYendthnkhrBean.setSeg2cd(khHenreikinLst.get(0).getSeg2cd());
                taisyouGkBeanLst.add(taisyouGkYendthnkhrBean);

                TaisyouGkBean taisyouGkShrtienrskBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                taisyouGkShrtienrskBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
                taisyouGkShrtienrskBean.setTaisyouGk(doKingakuHenkan(uiBean.getShrtienrsk()));
                taisyouGkShrtienrskBean.setKeiyakutuukaGk(doKingakuHenkan(uiBean.getShrtienrsk()));
                taisyouGkBeanLst.add(taisyouGkShrtienrskBean);

                TaisyouGkBean taisyouGkShrgkBean = SWAKInjector.getInstance(TaisyouGkBean.class);
                taisyouGkShrgkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
                taisyouGkShrgkBean.setTaisyouGk(uiBean.getShrgkgoukeikakunin());
                taisyouGkShrgkBean.setKeiyakutuukaGk(uiBean.getShrgkgoukeikakunin());
                taisyouGkBeanLst.add(taisyouGkShrgkBean);

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
                bzDenpyouDataTourokuBean.setIbSyono(syoNo);
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

                String denrenno = khDenpyoDataLst.get(0).getDenrenno();
                uiBean.setDenpyoudatarenban(denrenno);

                insertKTKhShrRrk(khozenCommonParam, sikibetuKey, sysTime, sysDate);

                if (C_ShrhousiteiKbn.FB_YOKUJITU.eq(uiBean.getShrhousiteikbn()) ||
                    C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(uiBean.getShrhousiteikbn()) ||
                    C_ShrhousiteiKbn.FB_3EIGYOUBI.eq(uiBean.getShrhousiteikbn())) {

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
            }

            makeTetudukiRireki(khozenCommonParam, sysTime, sysDate);
            makeTyouhyou(khozenCommonParam, sysDate);
            hozenDomManager.update(uiBean.getKykKihon());
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
            IW_KhYendtHnkHrShrWk khYendtHnkHrShrWk = hozenDomManager.getKhYendtHnkHrShrWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());
            hozenDomManager.delete(khYendtHnkHrShrWk);
        }
        else if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()))) {
            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                makeIW_KhYendtHnkHrShrWk(GAMENSYORIKBN_CONFIRM, khozenCommonParam, sysTime, sysDate);
            }
            else {
                updateIW_KhYendtHnkHrShrWk(khozenCommonParam, sysTime);
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

            if (!IKhozenCommonConstants.NODEID_SYORUITOUTYAKU.equals(bzGetProcessSummaryOutBean.getNowNodoId())) {
                throw new BizLogicException(MessageId.EIA0120,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }

            IW_KhYendtHnkHrShrWk khYendtHnkHrShrWk = hozenDomManager.getKhYendtHnkHrShrWk(
                bzGetProcessSummaryOutBean.getKouteiKanriId());
            if (khYendtHnkHrShrWk == null) {
                throw new CommonBizAppException(IW_KhYendtHnkHrShrWk.TABLE_NAME + " 取得エラー");
            }

            uiBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            if (!khYendtHnkHrShrWk.getKhhrshrjiyuu().eq(uiBean.getKhhrshrjiyuu())) {
                throw new BizLogicException(MessageId.EIA0120,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }
        }

        if (C_Khhrshrjiyuu.KYKSB.eq(uiBean.getKhhrshrjiyuu())) {

            if (BizUtil.isBlank(uiBean.getShnmkj())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_SHSNMINFO_SHNMKJ.getErrorResourceKey()));
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
                    SHSKADRINFO_SHSADRKJ,
                    String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                    String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
            }
        }

        if (C_Khhrshrjiyuu.KYKSB.eq(uiBean.getKhhrshrjiyuu())) {
            if (uiBean.getYendthnkhr().compareTo(HYAKUMANEN) > 0) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING5, MessageId.WIA1012);
            }
        }

        messageManager.addMessageId(MessageId.QIA0004);
    }

    @Transactional
    void pushKakuteiByskConfirmBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String sysTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
        C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(
            uiBean.getSyono(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            if (!IKhozenCommonConstants.NODEID_SYORUITOUTYAKU.equals(bzGetProcessSummaryOutBean.getNowNodoId())) {
                throw new BizLogicException(MessageId.EIA0120,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }

            IW_KhYendtHnkHrShrWk khYendtHnkHrShrWk = hozenDomManager.getKhYendtHnkHrShrWk(
                bzGetProcessSummaryOutBean.getKouteiKanriId());
            if (khYendtHnkHrShrWk == null) {
                throw new CommonBizAppException(IW_KhYendtHnkHrShrWk.TABLE_NAME + " 取得エラー");
            }

            if (!bzGetProcessSummaryOutBean.getKouteiKanriId().equals(uiBean.getKouteiKanriId())) {
                throw new BizLogicException(MessageId.EIA0120,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }

            if (!khYendtHnkHrShrWk.getKhhrshrjiyuu().eq(uiBean.getKhhrshrjiyuu())) {
                throw new BizLogicException(MessageId.EIA0120,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }
        }

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean =
            SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(uiBean.getDaisennintdkumukbn());
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        hozenPreReportRenkeiBean.setSyoNo(uiBean.getSyono());
        hozenPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());
        hozenPreReportRenkeiBean.setSyoriComment("");
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);
        if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {
            hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(checkProcessKaishi.getBzGetProcessSummaryOutBean().getKouteiKanriId());
        }

        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);
        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);

        if (C_Khhrshrjiyuu.KYKSB.eq(uiBean.getKhhrshrjiyuu())) {
            editSouhuannaiParam.setShsnmkj(uiBean.getShnmkj());
            editSouhuannaiParam.setShsyno(uiBean.getShskyno());
            editSouhuannaiParam.setShsadr1kj(uiBean.getShsadr1kj());
            editSouhuannaiParam.setShsadr2kj(uiBean.getShsadr2kj());
            editSouhuannaiParam.setShsadr3kj(uiBean.getShsadr3kj());
        }

        editSouhuannaiParam.setHrshrjiyuu(uiBean.getKhhrshrjiyuu());
        editSouhuannaiParam.setSkssakuseijiyuu(uiBean.getKhskssakuseijiyuu());
        editSouhuannaiParam.setYendthnkhrgk(uiBean.getYendthnkhr());

        if (uiBean.getShrgkgoukeisyoukai().compareTo(
            BizCurrency.valueOf(0, uiBean.getShrgkgoukeisyoukai().getType())) > 0) {
            editSeikyuusyoParam.setShrumu(C_UmuKbn.ARI);
        }

        editSeikyuusyoParam.setKhhrshrjiyuu(uiBean.getKhhrshrjiyuu());
        editSeikyuusyoParam.setKhskssakuseijiyuu(uiBean.getKhskssakuseijiyuu());

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);
        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<C_SyoruiCdKbn>();
        syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SOUHU);
        syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS);
        if (C_UmuKbn.ARI.eq(uiBean.getDaisennintdkumukbn())) {
            syoruiCdKbnLst.add(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_DAIHYOUSN);
        }
        C_SyoruiCdKbn[] syoruiCds = syoruiCdKbnLst.toArray(new C_SyoruiCdKbn[0]);

        khozenTyouhyouCtl.createTyouhyouTBL(
            khozenCommonParam,
            uiBean.getSyono(),
            syoruiCds,
            C_YouhiKbn.YOU);

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setReportKey(khozenTyouhyouCtl.getTyouhyouKey());

        if (C_UmuKbn.NONE.eq(kouteiUmuKbn)) {
            uiBean.getBzWorkflowInfo().setKouteiKanriId(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());
            makeIW_KhYendtHnkHrShrWk(GAMENSYORIKBN_SKSCONFIRM, khozenCommonParam, sysTime, sysDate);
        }
        else if(C_UmuKbn.ARI.eq(kouteiUmuKbn)){

            IW_KhYendtHnkHrShrWk khYendtHnkHrShrWk = hozenDomManager.getKhYendtHnkHrShrWk(uiBean.getKouteiKanriId());

            khYendtHnkHrShrWk.setSkssakuseiymd(sysDate);
            khYendtHnkHrShrWk.setShnmkj(uiBean.getShnmkj());
            khYendtHnkHrShrWk.setShskyno(uiBean.getShskyno());
            khYendtHnkHrShrWk.setShsadr1kj(uiBean.getShsadr1kj());
            khYendtHnkHrShrWk.setShsadr2kj(uiBean.getShsadr2kj());
            khYendtHnkHrShrWk.setShsadr3kj(uiBean.getShsadr3kj());
            khYendtHnkHrShrWk.setKhskssakuseijiyuu(uiBean.getKhskssakuseijiyuu());
            khYendtHnkHrShrWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            khYendtHnkHrShrWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            khYendtHnkHrShrWk.setGyoumuKousinTime(sysTime);

            hozenDomManager.update(khYendtHnkHrShrWk);
        }

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);
    }

    void printOut() {
        String tyhykey = uiBean.getReportKey();

        if (C_Khhrshrjiyuu.KYKSB.eq(uiBean.getKhhrshrjiyuu()) && uiBean.getYendthnkhr().compareTo(HYAKUMANEN) > 0) {
            DBAOutputReport dBAOutputReport = SWAKInjector.getInstance(DBAOutputReport.class);

            byte[] pdfByte = dBAOutputReport.getPdfImagesByJoinKeys(new String[] {tyhykey});

            String path = "";

            if (C_Khhrshrjiyuu.KYKSB.eq(uiBean.getKhhrshrjiyuu())){
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

    void pushModoruByConfirmBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            bzCommonLockProcess.continueLockProcess();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            Boolean isMRFAccount = checkMrfAccount();

            if (isMRFAccount == true) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WBA1006);
            }
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);
    }

    void pushSainyuuryokubtnOnClickBL() {
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING3);

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);
    }

    void pushModoruBysksconfirm() {
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING5);
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

    private void checkTetudukiTyuui(String pSyoNo, KhozenCommonParam pKhozenCommonParam) {

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(pKhozenCommonParam, pSyoNo);

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }
        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    private void checkFatcaKakuninYouhi(String pSyoNo, KhozenCommonParam pKhozenCommonParam) {

        List<IT_KykSyouhn> kykSyouhnLst = pKhozenCommonParam.getKeiyakuSyouhin(pSyoNo, C_SyutkKbn.SYU);

        C_UmuKbn fatcataisyouumu = kykSyouhnLst.get(0).getSyouhnZokusei().getFatcataisyouumu();

        if (C_UmuKbn.ARI.eq(fatcataisyouumu)) {
            if(!BizUtil.isBlank(uiBean.getBzWorkflowInfo().getKouteiKanriId())){
                BizDate soruittykymd = getSyoruittykymd.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS);

                if (soruittykymd != null) {
                    messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA0053);
                }
            }
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
        SetHosyou setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyou.exec(pKhozenCommonParam, uiBean);
        SetSonotaTk.exec(pKhozenCommonParam, uiBean);
        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(pKhozenCommonParam, uiBean);
        SetTrkKazoku.exec(pKhozenCommonParam, uiBean);
        SetKyksyadairi.exec(pKhozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList().size() > 0) {
            for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                    uiBean.getWarningMessageIdList().get(i), uiBean.getWarningMessageList().get(i));
            }
        }
    }

    private void setSyokiKoumoku(KhozenCommonParam pKhozenCommonParam) {

        IT_KykSyouhn kykSyouhn = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0);

        uiBean.setSyusyouhncd(kykSyouhn.getSyouhncd());
        uiBean.setSyusyouhnsdno(kykSyouhn.getSyouhnsdno());
        uiBean.setYendthnkymd(kykSyouhn.getYendthnkymd());

    }

    private Boolean checkMrfAccount() {

        List<IT_KykDairiten> kykDairitenLst = uiBean.getKykKihon().getKykDairitens();
        Boolean isMRFAccount = false;

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        List<BzGetAgInfoBean> bzGetAgInfoBeanListA = bzGetAgInfo.exec(kykDairitenLst.get(0).getDrtencd());
        isMRFAccount = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(bzGetAgInfoBeanListA.get(1).getOyadrtenCd());

        if (kykDairitenLst.size() > 1
            && isMRFAccount == false) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanListB = bzGetAgInfo.exec(kykDairitenLst.get(1).getDrtencd());
            isMRFAccount = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(bzGetAgInfoBeanListB.get(1).getOyadrtenCd());
        }

        return isMRFAccount;
    }

    private void insertKTKhShrRrk(KhozenCommonParam pKhozenCommonParam, String pSikibetuKey, String pSysTime,
        BizDate pSysDate) {

        IT_KhShrRireki khShrRireki = uiBean.getKykKihon().getKhTtdkRirekiByHenkousikibetukey(pSikibetuKey)
            .createKhShrRireki();

        khShrRireki.setShrymd(uiBean.getShrymd());
        khShrRireki.setShrsyoriymd(pSysDate);
        khShrRireki.setShrsyorikbn(C_ShrsyoriKbn.YENDTHNKHRSHR);
        khShrRireki.setSyoruiukeymd(uiBean.getSyoruiukeymd());
        khShrRireki.setKouryokuhasseiymd(uiBean.getSyoruiukeymd());
        khShrRireki.setShrtienrskkisanymd(uiBean.getSiharaitienrisokukisanbi());
        khShrRireki.setTienrsknissuu(uiBean.getTienrisokuhisuu());
        khShrRireki.setSinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        khShrRireki.setZeitratkikbn(C_ZeitratkiKbn.BLNK);
        khShrRireki.setKyktuukasyu(uiBean.getKyktuukasyu());
        khShrRireki.setSyushrgkkeisyukbn(C_SyuShrgkSyoukeiKbn.HENKANKIN);
        khShrRireki.setSyushrgkkei(uiBean.getYendthnkhr());
        khShrRireki.setShrtienrsk(uiBean.getShrtienrsk());
        khShrRireki.setShrtuukasyu(uiBean.getShrtuukasyu());
        khShrRireki.setShrtuukashrgkgoukei(uiBean.getShrgkgoukeikakunin());
        khShrRireki.setShrtuukasyushrgkkei(uiBean.getYendthnkhr());
        khShrRireki.setShrtuukashrtienrsk(uiBean.getShrtienrsk());
        khShrRireki.setYenshrgkgoukei(uiBean.getShrgkgoukeikakunin());
        khShrRireki.setYensyushrgkkei(uiBean.getYendthnkhr());
        khShrRireki.setYenshrtienrsk(uiBean.getShrtienrsk());
        khShrRireki.setYenshrtkumu(C_UmuKbn.NONE);
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
        khShrRireki.setDenrenno(uiBean.getDenpyoudatarenban());
        khShrRireki.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        khShrRireki.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        khShrRireki.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(khShrRireki);
    }

    private void makeTetudukiRireki(KhozenCommonParam pKhozenCommonParam, String pSysTime,
        BizDate pSysDate) {

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
        if (C_Khhrshrjiyuu.KYKSB.eq(uiBean.getKhhrshrjiyuu())) {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.YENDTHNKHRSHR_KEIYAKUSYASIBOU);
        }
        else {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.BLNK);
        }

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    private void makeTyouhyou(KhozenCommonParam pKhozenCommonParam, BizDate pSysDate) {

        EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.YENDTHNKHRSHR);
        editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);

        if (C_Khhrshrjiyuu.KYKSB.eq(uiBean.getKhhrshrjiyuu())) {

            editTtdkKanryouParam.setShsyno(uiBean.getKyksyaszkyno());
            editTtdkKanryouParam.setShsadr1kj(uiBean.getKyksyaszkadr1kj());
            editTtdkKanryouParam.setShsadr2kj(uiBean.getKyksyaszkadr2kj());
            editTtdkKanryouParam.setShsadr3kj(uiBean.getKyksyaszkadr3kj());
            editTtdkKanryouParam.setShsnmkj(uiBean.getKyksyaszknmkj());
        }

        if (uiBean.getShrgkgoukeikakunin().compareTo(
            BizCurrency.valueOf(0, uiBean.getShrgkgoukeikakunin().getType())) > 0) {
            editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        }

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
        khozenTyouhyouCtl.setHassoukbn(uiBean.getHassoukbn());

        C_SyoruiCdKbn[] syoruiCds = new C_SyoruiCdKbn[] {C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR};

        khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam, uiBean.getSyono(), syoruiCds, C_YouhiKbn.HUYOU);
        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setReportKey(khozenTyouhyouCtl.getTyouhyouKey());
    }

    private void makeIW_KhYendtHnkHrShrWk(String pSyorikbn, KhozenCommonParam pKhozenCommonParam, String pSysTime,
        BizDate pSysDate) {

        IW_KhYendtHnkHrShrWk khYendtHnkHrShrWk = new IW_KhYendtHnkHrShrWk();

        if (GAMENSYORIKBN_CONFIRM.equals(pSyorikbn)) {

            khYendtHnkHrShrWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            khYendtHnkHrShrWk.setKyksyaszknmkn(uiBean.getKyksyaszknmkn());
            khYendtHnkHrShrWk.setKyksyaszknmkj(uiBean.getKyksyaszknmkj());
            khYendtHnkHrShrWk.setKyksyaszkyno(uiBean.getKyksyaszkyno());
            khYendtHnkHrShrWk.setKyksyaszkadr1kj(uiBean.getKyksyaszkadr1kj());
            khYendtHnkHrShrWk.setKyksyaszkadr2kj(uiBean.getKyksyaszkadr2kj());
            khYendtHnkHrShrWk.setKyksyaszkadr3kj(uiBean.getKyksyaszkadr3kj());
            khYendtHnkHrShrWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());
            khYendtHnkHrShrWk.setBankcd(uiBean.getBankcd());
            khYendtHnkHrShrWk.setSitencd(uiBean.getSitencd());
            khYendtHnkHrShrWk.setYokinkbn(uiBean.getYokinkbn());
            khYendtHnkHrShrWk.setKouzano(uiBean.getKouzano());
            khYendtHnkHrShrWk.setKzdoukbn(uiBean.getKzdoukbn());
            if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                khYendtHnkHrShrWk.setKzmeiginmkn("");
            }
            else {
                khYendtHnkHrShrWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
            }
            khYendtHnkHrShrWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            khYendtHnkHrShrWk.setHassoukbn(uiBean.getHassoukbn());
            if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
                khYendtHnkHrShrWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }
        }
        else {
            khYendtHnkHrShrWk.setShnmkj(uiBean.getShnmkj());
            khYendtHnkHrShrWk.setShskyno(uiBean.getShskyno());
            khYendtHnkHrShrWk.setShsadr1kj(uiBean.getShsadr1kj());
            khYendtHnkHrShrWk.setShsadr2kj(uiBean.getShsadr2kj());
            khYendtHnkHrShrWk.setShsadr3kj(uiBean.getShsadr3kj());
            khYendtHnkHrShrWk.setKhskssakuseijiyuu(uiBean.getKhskssakuseijiyuu());
        }

        khYendtHnkHrShrWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        khYendtHnkHrShrWk.setSyono(uiBean.getSyono());
        khYendtHnkHrShrWk.setSkssakuseiymd(pSysDate);
        khYendtHnkHrShrWk.setKhhrshrjiyuu(uiBean.getKhhrshrjiyuu());
        khYendtHnkHrShrWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        khYendtHnkHrShrWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        khYendtHnkHrShrWk.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(khYendtHnkHrShrWk);

        hozenDomManager.insert(khYendtHnkHrShrWk);
    }

    private void updateIW_KhYendtHnkHrShrWk(KhozenCommonParam pKhozenCommonParam, String pSysTime) {

        IW_KhYendtHnkHrShrWk khYendtHnkHrShrWk = hozenDomManager.getKhYendtHnkHrShrWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) &&
            !C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
            khYendtHnkHrShrWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
            (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn()))) {
            khYendtHnkHrShrWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            khYendtHnkHrShrWk.setKyksyaszknmkn(uiBean.getKyksyaszknmkn());
            khYendtHnkHrShrWk.setKyksyaszknmkj(uiBean.getKyksyaszknmkj());
            khYendtHnkHrShrWk.setKyksyaszkyno(uiBean.getKyksyaszkyno());
            khYendtHnkHrShrWk.setKyksyaszkadr1kj(uiBean.getKyksyaszkadr1kj());
            khYendtHnkHrShrWk.setKyksyaszkadr2kj(uiBean.getKyksyaszkadr2kj());
            khYendtHnkHrShrWk.setKyksyaszkadr3kj(uiBean.getKyksyaszkadr3kj());

            khYendtHnkHrShrWk.setInputshrhousiteikbn(uiBean.getInputshrhousiteikbn());
            khYendtHnkHrShrWk.setBankcd(uiBean.getBankcd());
            khYendtHnkHrShrWk.setSitencd(uiBean.getSitencd());
            khYendtHnkHrShrWk.setYokinkbn(uiBean.getYokinkbn());
            khYendtHnkHrShrWk.setKouzano(uiBean.getKouzano());
            khYendtHnkHrShrWk.setKzdoukbn(uiBean.getKzdoukbn());
            if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
                khYendtHnkHrShrWk.setKzmeiginmkn("");
            }
            else {
                khYendtHnkHrShrWk.setKzmeiginmkn(uiBean.getKzmeiginmkn());
            }
            khYendtHnkHrShrWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            khYendtHnkHrShrWk.setHassoukbn(uiBean.getHassoukbn());
        }

        khYendtHnkHrShrWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        khYendtHnkHrShrWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        khYendtHnkHrShrWk.setGyoumuKousinTime(pSysTime);

        hozenDomManager.update(khYendtHnkHrShrWk);
    }

    private void doJikouteikanri() {
        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");

        String commnet = "";

        commnet = uiBean.getSyanaicommentkh();

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);
        khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),bzCommonLockProcess.getKouteiLockKey(), commnet, khRuleBean);

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
}
