package yuyu.app.hozen.khansyuu.khkariuketeisei;

import static yuyu.app.hozen.khansyuu.khkariuketeisei.GenKhKariukeTeiseiConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khansyuu.khkariuketeisei.dba.KhKariukeTeiseiDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzFbSoukinDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksBean;
import yuyu.common.hozen.ascommon.CreditHnknTuutiSks;
import yuyu.common.hozen.ascommon.CreditHnknTuutiSksParam;
import yuyu.common.hozen.ascommon.SetMinusUriagebi;
import yuyu.common.hozen.khcommon.AnsyuuCommonSiwake;
import yuyu.common.hozen.khcommon.AnsyuuCommonSiwakeInBean;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfo;
import yuyu.common.hozen.khcommon.AnsyuuTaisyouGkBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CommonSiwakeOutBean;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoHensyuu;
import yuyu.common.hozen.khcommon.CreditUriageSeikyuuDataSks;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KeisanSiharaibi;
import yuyu.common.hozen.khcommon.KhCheckKouza;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenEdit;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.khcommon.UriageSeikyuuDataSksParam;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetDattai;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetTokusin;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_KrkteiseiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KouzaHrkmTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 仮受訂正 のビジネスロジックです。
 */
public class KhKariukeTeiseiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKariukeTeiseiUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    //    @Inject
    //    private OutputReport outputReport;

    @Inject
    private KhKariukeTeiseiDao khKariukeTeiseiDao;

    void init() {
    }

    void clear() {
    }

    void pushInputBL () {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykKihon kykKihon = khKariukeTeiseiDao.getKykKihon(uiBean.getSyono());

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);

        IT_Kariukekin kariukekin = khKariukeTeiseiDao.getKariukekin(uiBean.getKykKihon(), uiBean.getKrkno());

        if (kariukekin == null) {
            throw new BizLogicException(MessageId.EIA0091);
        }

        if (C_Krkseisanzumiflg.SUMI.eq(kariukekin.getKrkseisanzumiflg())) {
            throw new BizLogicException(MessageId.EIA0092);
        }

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

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
        }

        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }

        if (C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn()) &&
            !C_Nykkeiro.CREDIT.eq(kariukekin.getNykkeiro())) {
            throw new BizLogicException(MessageId.EIF3067);
        }

        if (C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn()) &&
            BizUtil.isBlank(kariukekin.getCreditkessaiyouno())) {
            throw new BizLogicException(MessageId.EIF3068);
        }

        IT_AnsyuKihon ansyuKihon = khKariukeTeiseiDao.getAnsyuKihon(uiBean.getSyono());

        uiBean.setAnsyuKihon(ansyuKihon);

        String creditkessaiyouno = kariukekin.getCreditkessaiyouno();
        if (!Strings.isNullOrEmpty(creditkessaiyouno)) {
            CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu = SWAKInjector
                .getInstance(CreditKessaiyouNoHensyuu.class);

            creditkessaiyouno = creditKessaiyouNoHensyuu.exec(creditkessaiyouno);
        }
        uiBean.setKrkkeijyoymd(kariukekin.getKrkkeijyoymd());
        uiBean.setKrkriyuukbn(kariukekin.getKrkriyuukbn());
        uiBean.setHasseidenymd(kariukekin.getHasseidenymd());
        uiBean.setHrkkaisuu(kariukekin.getHrkkaisuu());
        uiBean.setTikiktbrisyuruikbn(kariukekin.getTikiktbrisyuruikbn());
        uiBean.setNykkeiro(kariukekin.getNykkeiro());
        uiBean.setNyknaiyoukbn(kariukekin.getNyknaiyoukbn());
        uiBean.setJyuutouym(kariukekin.getJyuutouym());
        uiBean.setJyutoukaisuuy(kariukekin.getJyutoukaisuuy());
        uiBean.setJyutoukaisuum(kariukekin.getJyutoukaisuum());
        uiBean.setRyosyuymd(kariukekin.getRyosyuymd());
        uiBean.setKrkgk(kariukekin.getKrkgk());
        uiBean.setDispcreditkessaiyouno(creditkessaiyouno);
        uiBean.setCreditkessaiyouno(kariukekin.getCreditkessaiyouno());

        setCommonUiBean(khozenCommonParam);

        if (C_KrkteiseiKbn.HANDKRK.eq(uiBean.getKrkteiseikbn())) {

            uiBean.setDenkarikanjyonoFlg(true);
        }
        else {

            uiBean.setDenkarikanjyonoFlg(false);
        }

        if (C_KrkteiseiKbn.FBHENKIN.eq(uiBean.getKrkteiseikbn())
            || C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn())) {

            uiBean.setHnknriyuukbnFlg(true);
        }
        else {

            uiBean.setHnknriyuukbnFlg(false);
        }

        String patternSoukinsakikbn = "";
        if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {

            patternSoukinsakikbn = C_SoukinsakiKbn.PATTERN_KHPHURIKZIGAI;
            uiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
        } else {

            patternSoukinsakikbn = C_SoukinsakiKbn.PATTERN_KH;
            uiBean.setSoukinsakikbn(C_SoukinsakiKbn.PHURIKZ);
        }
        uiBean.setPatternSoukinsakikbn(patternSoukinsakikbn);

        if (C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn())) {
            uiBean.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
        }
        else {
            uiBean.setHassoukbn(C_HassouKbn.TYOKUSOU);
        }

        if (C_KrkteiseiKbn.FBHENKIN.eq(uiBean.getKrkteiseikbn()) && C_Nykkeiro.CREDIT.eq(uiBean.getNykkeiro())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIF3014);
        }
    }

    void pushKakuninBL(){

        if (uiBean.getDenkarikanjyonoFlg() && BizUtil.isBlank(uiBean.getDenkarikanjyono())) {

            throw new BizLogicException(MessageId.EAC0042, DDID_KRKTEISEIINPUTINFO_DENKARIKANJYONO);
        }

        if (uiBean.getHnknriyuukbnFlg() && C_ShrriyuuKbn.BLNK.eq(uiBean.getShrriyuukbn())) {

            throw new BizLogicException(MessageId.EAC0042, DDID_HNKNRIYUUKBNINFO_SHRRIYUUKBN);
        }

        if (C_KrkteiseiKbn.FBHENKIN.eq(uiBean.getKrkteiseikbn())) {
            uiBean.setShrtuukasyu(C_Tuukasyu.JPY);

            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

            if (C_SoukinsakiKbn.PHURIKZ.eq(uiBean.getSoukinsakikbn())) {
                if (!BizUtil.isBlank(uiBean.getBankcd()) || !BizUtil.isBlank(uiBean.getSitencd())
                    || !C_YokinKbn.BLNK.eq(uiBean.getYokinkbn()) || !C_Kzdou.BLNK.eq(uiBean.getKzdoukbn())
                    || !BizUtil.isBlank(uiBean.getKouzano()) || !BizUtil.isBlank(uiBean.getKzmeiginmkn())) {
                    throw new BizLogicException(MessageId.EIA3042);
                }

                IT_Kouza kouza = khKariukeTeiseiDao.getKouza(uiBean.getKykKihon());

                if (null == kouza) {
                    throw new BizLogicException(MessageId.EIC0008);
                }
            }

            KhCheckKouza khCheckKouza = SWAKInjector.getInstance(KhCheckKouza.class);

            khCheckKouza.chkSoukinsakiKouza(uiBean, khozenCommonParam);

            uiBean.setBanknmkj(khCheckKouza.getGinkouName());
            uiBean.setSitennmkj(khCheckKouza.getShitenName());
        }

        if (C_KrkteiseiKbn.HANDKRK.eq(uiBean.getKrkteiseikbn())) {
            if (Integer.parseInt(uiBean.getDenkarikanjyono()) < Integer.parseInt("01401") ||
                Integer.parseInt(uiBean.getDenkarikanjyono()) > Integer.parseInt("01500")) {

                throw new BizLogicException(MessageId.EIF1103);
            }
        }

        messageManager.addMessageId(MessageId.QBA0001);

        if (C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn())) {
            uiBean.setDisphnknsakicreditkessaiyouno(uiBean.getDispcreditkessaiyouno());
        }
    }

    @Transactional
    void pushKakuteiBL () {

        BizDate sysDate = BizDate.getSysDate();
        String sysTime  = BizDate.getSysDateTimeMilli();
        BizDate creditHenkinUriageseikyuuYmd = null;

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);


        if (C_KrkteiseiKbn.FBHENKIN.eq(uiBean.getKrkteiseikbn())) {
            KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);

            BizDate siharaiBi = keisanSiharaibi.exec(sysDate, C_InputShrhousiteiKbn.FBSOUKIN,
                C_Tuukasyu.JPY, uiBean.getBankcd());

            uiBean.setDenYmd(siharaiBi);
            uiBean.setShrhousiteiKbn(keisanSiharaibi.getShrhousiteiKbn());

        }
        else if (C_KrkteiseiKbn.HANDKRK.eq(uiBean.getKrkteiseikbn())){
            uiBean.setDenYmd(sysDate);
            uiBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        }
        else if (C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn())){
            SetMinusUriagebi setMinusUriagebi = SWAKInjector.getInstance(SetMinusUriagebi.class);

            setMinusUriagebi.exec(sysDate);

            creditHenkinUriageseikyuuYmd = setMinusUriagebi.getUriageSeikyuuYmd();
            uiBean.setDenYmd(setMinusUriagebi.getDenpyouYmd());
            uiBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        }

        String sikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        tableMaintenanceUtil.backUp(uiBean.getSyono(), sikibetuKey);


        IT_KhTtdkRireki khTtdkRireki = khKariukeTeiseiDao.createKhTtdkRireki(uiBean.getKykKihon());
        khTtdkRireki.setHenkousikibetukey(sikibetuKey);

        updateKykKihon(sysDate,sysTime);

        updateKTKariukekin(sysTime);

        CommonSiwakeOutBean commonSiwakeOutBean = insertDenpyoData(sysDate,khozenCommonParam);

        if (C_KrkteiseiKbn.FBHENKIN.eq(uiBean.getKrkteiseikbn())) {

            insertKTSyunoHenknRrk(sysDate,sysTime);

            insertKTFBSoukinData(commonSiwakeOutBean,khozenCommonParam);
        }
        else if (C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn())) {
            UriageSeikyuuDataSksParam seikyuuDataSksParam = SWAKInjector.getInstance(UriageSeikyuuDataSksParam.class);
            CreditUriageSeikyuuDataSks seikyuuDataSks = SWAKInjector.getInstance(CreditUriageSeikyuuDataSks.class);

            seikyuuDataSksParam.setKessaiyouno(uiBean.getCreditkessaiyouno());
            seikyuuDataSksParam.setUriagenengappi(creditHenkinUriageseikyuuYmd);
            seikyuuDataSksParam.setSyoriYmd(sysDate);
            seikyuuDataSksParam.setUriagegk(uiBean.getKrkgk());
            seikyuuDataSksParam.setNyknaiyoukbn(uiBean.getNyknaiyoukbn());
            seikyuuDataSksParam.setJyuutouym(uiBean.getJyuutouym());
            seikyuuDataSksParam.setAnsyuKihonTblentity(uiBean.getAnsyuKihon());

            seikyuuDataSks.editHenkinUriageData(khozenCommonParam, seikyuuDataSksParam);

            CreditHnknTuutiSksParam creditHnknTuutiSksParam = SWAKInjector.getInstance(CreditHnknTuutiSksParam.class);
            CreditHnknTuutiSks creditHnknTuutiSks = SWAKInjector.getInstance(CreditHnknTuutiSks.class);

            creditHnknTuutiSksParam.setDenrenno(uiBean.getDenrenNo());
            creditHnknTuutiSksParam.setEdano(uiBean.getEdaNo());
            creditHnknTuutiSksParam.setDenymd(uiBean.getDenYmd());
            creditHnknTuutiSksParam.setTyouhyouymd(sysDate);
            creditHnknTuutiSksParam.setHenkousikibetukey(sikibetuKey);
            creditHnknTuutiSksParam.setHassoukbn(uiBean.getHassoukbn());
            creditHnknTuutiSksParam.setShrriyuukbn(uiBean.getShrriyuukbn());
            creditHnknTuutiSksParam.setUriageseikyuuymd(creditHenkinUriageseikyuuYmd);
            creditHnknTuutiSksParam.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE);
            creditHnknTuutiSksParam.setHnkngk(uiBean.getKrkgk());
            creditHnknTuutiSksParam.setCreditkessaiyouno(uiBean.getCreditkessaiyouno());
            creditHnknTuutiSksParam.setAnsyuKihon(uiBean.getAnsyuKihon());
            creditHnknTuutiSksParam.setKykKihon(uiBean.getKykKihon());
            creditHnknTuutiSks.exec(khozenCommonParam, creditHnknTuutiSksParam);

            khKariukeTeiseiDao.update(uiBean.getAnsyuKihon());
        }
        else {
            uiBean.getAnsyuKihon().detach();
        }

        if (C_KrkteiseiKbn.FBHENKIN.eq(uiBean.getKrkteiseikbn())) {
            addKouzaHurikomiTuuti(khozenCommonParam, sysTime);
        }

        //        if (C_KrkteiseiKbn.HANDKRK.eq(uiBean.getKrkteiseikbn())) {
        //            makeReport(sysDate, khozenCommonParam);
        //        }

        makeTetudukiRireki(sysDate,sysTime,khozenCommonParam);

        khKariukeTeiseiDao.update(uiBean.getKykKihon());

        messageManager.addMessageId(MessageId.IAC0009);
    }

    //    void printOut () {
    //
    //        String tyouhyouKey = uiBean.getTyouhyouKey();
    //
    //        outputReport.outputPDFByJoinKey(tyouhyouKey);
    //    }

    private void setCommonUiBean (KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);

        SetKihon.exec(pKhozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(pKhozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList() != null && uiBean.getWarningMessageIdList().size() > 0) {
            for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                    uiBean.getWarningMessageIdList().get(i), uiBean.getWarningMessageList().get(i));
            }
        }

        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);

        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(pKhozenCommonParam, uiBean);

        SetTokusin.exec(pKhozenCommonParam, uiBean);

        SetDattai.exec(pKhozenCommonParam, uiBean);

        SetTrkKazoku.exec(pKhozenCommonParam, uiBean);

        SetKyksyadairi.exec(pKhozenCommonParam, uiBean);
    }

    private void updateKykKihon (BizDate pSysDate , String pSysTime) {

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        kykKihon.setSyhenkouymd(pSysDate);
        kykKihon.setGyoumuKousinKinou(kinou.getKinouId());
        kykKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        kykKihon.setGyoumuKousinTime(pSysTime);
    }

    private void updateKTKariukekin (String pSysTime) {

        IT_Kariukekin kariukekin = khKariukeTeiseiDao.getKariukekin(uiBean.getKykKihon(), uiBean.getKrkno());

        kariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
        kariukekin.setSeisandenymd(uiBean.getDenYmd());
        kariukekin.setGyoumuKousinKinou(kinou.getKinouId());
        kariukekin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        kariukekin.setGyoumuKousinTime(pSysTime);
    }

    private CommonSiwakeOutBean insertDenpyoData (BizDate pSysDate,KhozenCommonParam pKhozenCommonParam) {

        IT_KykKihon kykKihon = khKariukeTeiseiDao.getKykKihon(uiBean.getSyono());
        IT_KykSyouhn kykSyouhn = khKariukeTeiseiDao.getKykSyouhn(kykKihon);

        String syouhncd = kykSyouhn.getSyouhncd();
        Integer syouhnsdno = kykSyouhn.getSyouhnsdno();

        C_KhDengkSyuruiKbn khDengkSyuruiKbn;

        if (C_KrkteiseiKbn.HANDKRK.eq(uiBean.getKrkteiseikbn())) {

            khDengkSyuruiKbn = C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK;

        }
        else if (C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn())) {
            khDengkSyuruiKbn = C_KhDengkSyuruiKbn.CREDITTORIKESIGK;

        }
        else {

            khDengkSyuruiKbn = C_KhDengkSyuruiKbn.SHRGK;
        }

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);

        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst = Lists.newArrayList();

        AnsyuuTaisyouGkBean seisankKariukegkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        seisankKariukegkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        seisankKariukegkBean.setTaisyouGk(uiBean.getKrkgk());
        seisankKariukegkBean.setKeiyakutuukaGk(uiBean.getKrkgk());
        ansyuuTaisyouGkBeanLst.add(seisankKariukegkBean);

        AnsyuuTaisyouGkBean shrgkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        shrgkBean.setKhDengkSyuruiKbn(khDengkSyuruiKbn);
        shrgkBean.setTaisyouGk(uiBean.getKrkgk());
        shrgkBean.setKeiyakutuukaGk(uiBean.getKrkgk());
        shrgkBean.setDenkarikanjyono(uiBean.getDenkarikanjyono());
        ansyuuTaisyouGkBeanLst.add(shrgkBean);

        ansyuuCommonSiwakeInBean.setKinouId(kinou.getKinouId());
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.HOZEN);
        ansyuuCommonSiwakeInBean.setSyouhinCd(syouhncd);
        ansyuuCommonSiwakeInBean.setSyouhnsdno(syouhnsdno);
        ansyuuCommonSiwakeInBean.setDenYmd(uiBean.getDenYmd());
        ansyuuCommonSiwakeInBean.setSyoriYmd(pSysDate);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(uiBean.getShrhousiteiKbn());
        ansyuuCommonSiwakeInBean.setSyono(uiBean.getSyono());
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(ansyuuTaisyouGkBeanLst);

        AnsyuuCommonSiwake ansyuuCommonSiwake = SWAKInjector.getInstance(AnsyuuCommonSiwake.class);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

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
        bzDenpyouDataTourokuBean.setIbSyorisosikicd(pKhozenCommonParam.getTmSosikiCd());
        bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(baseUserInfo.getUserId());
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(null);
        bzDenpyouDataTourokuBean.setIbKyktuukasyu(commonSiwakeOutBean.getKyktuukaSyu());
        bzDenpyouDataTourokuBean.setIbShrhousiteiKbn(uiBean.getShrhousiteiKbn());
        bzDenpyouDataTourokuBean.setIbSyouhncd(syouhncd);
        bzDenpyouDataTourokuBean.setIbSyouhnsdno(syouhnsdno);
        bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());

        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);

        List<IT_KhDenpyoData> khDenpyoDataLst = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);

        int fbskEdano = bzDenpyouDataSks.getEdano();
        int credithkEdano = bzDenpyouDataSks.getCreditHnknEdano();

        for (IT_KhDenpyoData khDenpyoData : khDenpyoDataLst) {
            khKariukeTeiseiDao.insert(khDenpyoData);
        }

        String denrenno = khDenpyoDataLst.get(0).getDenrenno();
        String dengyoumucd = khDenpyoDataLst.get(0).getDengyoumucd();

        uiBean.setDenrenNo(denrenno);

        if (C_KrkteiseiKbn.FBHENKIN.eq(uiBean.getKrkteiseikbn())) {
            uiBean.setEdaNo(fbskEdano);
        }
        else if (C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn())) {
            uiBean.setEdaNo(credithkEdano);
        }

        uiBean.setDengyoumucd(dengyoumucd);

        return commonSiwakeOutBean;
    }

    private void insertKTSyunoHenknRrk (BizDate pSysDate , String pSysTime) {

        IT_SyuunouHenknRireki syuunouHenknRireki = khKariukeTeiseiDao.createSyuunouHenknRireki(uiBean.getAnsyuKihon());

        syuunouHenknRireki.setDenrenno(uiBean.getDenrenNo());
        syuunouHenknRireki.setEdano(uiBean.getEdaNo());
        syuunouHenknRireki.setDenkihyouymd(pSysDate);
        syuunouHenknRireki.setShrymd(uiBean.getDenYmd());
        syuunouHenknRireki.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
        syuunouHenknRireki.setHnkngk(uiBean.getKrkgk());
        syuunouHenknRireki.setShrriyuukbn(uiBean.getShrriyuukbn());
        syuunouHenknRireki.setBankcd(uiBean.getBankcd());
        syuunouHenknRireki.setSitencd(uiBean.getSitencd());
        syuunouHenknRireki.setYokinkbn(uiBean.getYokinkbn());
        syuunouHenknRireki.setKouzano(uiBean.getKouzano());
        syuunouHenknRireki.setKzmeiginmkn(uiBean.getKzmeiginmkn());
        syuunouHenknRireki.setGyoumuKousinKinou(kinou.getKinouId());
        syuunouHenknRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        syuunouHenknRireki.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(syuunouHenknRireki);

        khKariukeTeiseiDao.update(uiBean.getAnsyuKihon());
    }

    private void insertKTFBSoukinData (CommonSiwakeOutBean pCommonSiwakeOutBean,KhozenCommonParam pKhozenCommonParam) {

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean  = SWAKInjector.getInstance(BzFbSoukinDataSksBean .class);

        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon(uiBean.getDenrenNo());
        bzFbSoukinDataSksBean.setEdaNo(uiBean.getEdaNo());
        bzFbSoukinDataSksBean.setDenSysKbn(pCommonSiwakeOutBean.getDensysKbn());
        bzFbSoukinDataSksBean.setSyoriCd(pCommonSiwakeOutBean.getSyoriCd());
        bzFbSoukinDataSksBean.setSyoriSosikiCd(pKhozenCommonParam.getTmSosikiCd());
        bzFbSoukinDataSksBean.setSyoriYmd(pCommonSiwakeOutBean.getSyoriYmd());
        bzFbSoukinDataSksBean.setDenYmd(pCommonSiwakeOutBean.getDenyMd());
        bzFbSoukinDataSksBean.setSyoNo(uiBean.getSyono());
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(uiBean.getShrhousiteiKbn());
        bzFbSoukinDataSksBean.setBankCd(uiBean.getBankcd());
        bzFbSoukinDataSksBean.setSitenCd(uiBean.getSitencd());
        bzFbSoukinDataSksBean.setYokinKbn(uiBean.getYokinkbn());
        bzFbSoukinDataSksBean.setKouzaNo(uiBean.getKouzano());
        bzFbSoukinDataSksBean.setKzMeigiNmKn(uiBean.getKzmeiginmkn());
        bzFbSoukinDataSksBean.setSouKingk(uiBean.getKrkgk());
        bzFbSoukinDataSksBean.setKykTuukasyu(pCommonSiwakeOutBean.getKyktuukaSyu());
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(0));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(0));
        bzFbSoukinDataSksBean.setKinouId(kinou.getKinouId());
        bzFbSoukinDataSksBean.setUserId(baseUserInfo.getUserId());
        bzFbSoukinDataSksBean.setDengyoumuCd(uiBean.getDengyoumucd());

        BzFbSoukinDataSks bzFbSoukinDataSks = SWAKInjector.getInstance(BzFbSoukinDataSks.class);
        IT_KhFBSoukinData khFBSoukinData = bzFbSoukinDataSks.execKh(bzFbSoukinDataSksBean);

        if (khFBSoukinData != null) {
            khKariukeTeiseiDao.insert(khFBSoukinData);
        }
    }

    private void addKouzaHurikomiTuuti (KhozenCommonParam pKhozenCommonParam, String pGyoumuKousinTime) {

        IT_KykSya kykSya = uiBean.getKykKihon().getKykSya();

        String updKouzaNo = ConvertUtil.toZenAll(KhozenEdit.editKouzaNo(uiBean.getBankcd(), uiBean.getKouzano()),1,1);

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(YuyuBizConfig
            .getInstance().getCallcentersosikicd());

        AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo =
            SWAKInjector.getInstance(AnsyuuSetTetudukityuuiInfo.class);
        C_HassouKbn hassouKbn = C_HassouKbn.BLNK;

        C_KktyuitaKbn kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(uiBean.getSyono());

        if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn) && C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {

            hassouKbn = C_HassouKbn.HONSYAKAISOU;
        }
        else {

            hassouKbn = uiBean.getHassoukbn();
        }

        String shriRiyuu1 = "";
        String shriRiyuu2 = "";
        String shriRiyuu3 = "";
        if (C_ShrriyuuKbn.NIZYUNYKN.eq(uiBean.getShrriyuukbn())) {

            shriRiyuu1 = "二重に、ご入金いただきました。";
        }
        else if (C_ShrriyuuKbn.KAZYOUNYKN.eq(uiBean.getShrriyuukbn())) {

            shriRiyuu1 = "ご入金額（お預り金等）を保険料等に充当しました";
            shriRiyuu2 = "ところ、過剰金が生じました。";
        }
        else if (C_ShrriyuuKbn.HARAIKOMIHUYOU.eq(uiBean.getShrriyuukbn())) {

            shriRiyuu1 = "ご契約はお払込み不要となりましたのでご返金させて";
            shriRiyuu2 = "いただきます。";
        }
        else if (C_ShrriyuuKbn.HRHNGONYKN.eq(uiBean.getShrriyuukbn())) {

            shriRiyuu1 = "お払込方法変更後にご入金いただきましたので";
            shriRiyuu2 = "一旦返金させていただきます。";
        }
        else if (C_ShrriyuuKbn.OHTHER_MOUSIDE.eq(uiBean.getShrriyuukbn())) {

            shriRiyuu1 = "お申し出により、ご返金します。";
        }
        else if (C_ShrriyuuKbn.YUYOKKNGONYKN.eq(uiBean.getShrriyuukbn())) {

            shriRiyuu1 = "猶予期間満了日後のご入金のためご返金いたします。";
        }
        else if (C_ShrriyuuKbn.OHTHER.eq(uiBean.getShrriyuukbn())) {

            shriRiyuu1 = "別途、ご案内の文書をご参照ください。";
        }

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(uiBean.getBankcd(), uiBean.getSitencd());

        String bankNmKj = bzGetBankDataBean.getBankNmKj();
        String reportSitenNm = bzGetBankDataBean.getReportSitenNm();

        String siteiKouza4 = "";
        String siteiKouza5 = "";
        siteiKouza4 = "口座名義人　" + uiBean.getKzmeiginmkn() + "　様";

        if (siteiKouza4.length() > 32) {
            siteiKouza5 = "　　　　　　" + siteiKouza4.substring(32);
            siteiKouza4 = siteiKouza4.substring(0, 32);
        }

        IT_KouzaHrkmTuuti kouzaHrkmTuuti = uiBean.getKykKihon().createKouzaHrkmTuuti();

        kouzaHrkmTuuti.setKrkno(uiBean.getKrkno());
        kouzaHrkmTuuti.setTyouhyouymd(BizDate.getSysDate());
        kouzaHrkmTuuti.setHenkousikibetukey(pKhozenCommonParam.getSikibetuKey(uiBean.getSyono()));
        kouzaHrkmTuuti.setShskyno(kykSya.getTsinyno());
        kouzaHrkmTuuti.setShsadr1kj(kykSya.getTsinadr1kj());
        kouzaHrkmTuuti.setShsadr2kj(kykSya.getTsinadr2kj());
        kouzaHrkmTuuti.setShsadr3kj(kykSya.getTsinadr3kj());
        kouzaHrkmTuuti.setShsnmkj(kykSya.getKyknmkj());
        kouzaHrkmTuuti.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
        kouzaHrkmTuuti.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());
        kouzaHrkmTuuti.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
        kouzaHrkmTuuti.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
        kouzaHrkmTuuti.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
        kouzaHrkmTuuti.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());
        kouzaHrkmTuuti.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
        kouzaHrkmTuuti.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
        kouzaHrkmTuuti.setToiawasesosikinmkj2("");
        kouzaHrkmTuuti.setToiawasetelno2("");
        kouzaHrkmTuuti.setSyoruiCd(C_SyoruiCdKbn.AS_KZHURIKOMITUUTI);
        kouzaHrkmTuuti.setHassoukbn(hassouKbn);
        kouzaHrkmTuuti.setHurikomiymd(BizDate.getSysDate().addBusinessDays(1));
        kouzaHrkmTuuti.setShrgk(uiBean.getKrkgk());
        kouzaHrkmTuuti.setShririyuu1(shriRiyuu1);
        kouzaHrkmTuuti.setShririyuu2(shriRiyuu2);
        kouzaHrkmTuuti.setShririyuu3(shriRiyuu3);
        kouzaHrkmTuuti.setSiteikouza1(bankNmKj);
        kouzaHrkmTuuti.setSiteikouza2(reportSitenNm);

        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(uiBean.getBankcd())) {
            kouzaHrkmTuuti.setSiteikouza3("通帳番号　" + updKouzaNo);
        }
        else{
            kouzaHrkmTuuti.setSiteikouza3(uiBean.getYokinkbn().getContent(C_YokinKbn.PATTERN_TYOUHYOU) + "　口座番号　" + updKouzaNo);
        }

        kouzaHrkmTuuti.setSiteikouza4(siteiKouza4);
        kouzaHrkmTuuti.setSiteikouza5(siteiKouza5);
        kouzaHrkmTuuti.setGyoumuKousinKinou(kinou.getKinouId());
        kouzaHrkmTuuti.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        kouzaHrkmTuuti.setGyoumuKousinTime(pGyoumuKousinTime);

        BizPropertyInitializer.initialize(kouzaHrkmTuuti);

    }

    private void makeTetudukiRireki (BizDate pSysDate, String pSysTime,KhozenCommonParam pKhozenCommonParam) {

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(pKhozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(pSysDate);
        editTtdkRirekiTblParam.setSysTime(pSysTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        if (C_KrkteiseiKbn.FBHENKIN.eq(uiBean.getKrkteiseikbn())) {

            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.FBHENKIN);
        }
        else if (C_KrkteiseiKbn.HANDKRK.eq(uiBean.getKrkteiseikbn())) {

            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.HNDKRKKEIJYOU);
        }
        else if (C_KrkteiseiKbn.CREDITHENKIN.eq(uiBean.getKrkteiseikbn())) {

            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.CRECAHENKIN);
        }

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    //    private void makeReport (BizDate pSysDate, KhozenCommonParam pKhozenCommonParam) {
    //
    //        String sysdateWareki = DefaultDateFormatter.formatYMDKanji(pSysDate);
    //
    //        String denkihyouymd = DefaultDateFormatter.formatYMDKanji(pSysDate);
    //
    //        String idenymd = DefaultDateFormatter.formatYMDKanji(uiBean.getDenYmd());
    //
    //        BzHandkarikanjoBean bzHandkarikanjoBean = SWAKInjector.getInstance(BzHandkarikanjoBean.class);
    //
    //        bzHandkarikanjoBean.setIrSyono(uiBean.getSyono());
    //        bzHandkarikanjoBean.setIrTyouhyousakuseiymd(sysdateWareki);
    //        bzHandkarikanjoBean.setIrDenrenno(uiBean.getDenrenNo());
    //        bzHandkarikanjoBean.setIrEdano(2);
    //        bzHandkarikanjoBean.setIrDenkihyouymd(denkihyouymd);
    //        bzHandkarikanjoBean.setIrDenymd(idenymd);
    //        bzHandkarikanjoBean.setIrTaisyakukbn(C_TaisyakuKbn.KASIKATA);
    //        bzHandkarikanjoBean.setIrKanjyoukmknm(IKhozenCommonConstants.KANJYOUKAMOKUNM_KARIUKE_SONOTA);
    //        bzHandkarikanjoBean.setIrDengk(uiBean.getKrkgk());
    //        bzHandkarikanjoBean.setIrKinounm(kinou.getKinouNm());
    //        bzHandkarikanjoBean.setIrSousasyanm(baseUserInfo.getUserNm());
    //
    //        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
    //
    //        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
    //            kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.KK_HANDKARIKANJYOU);
    //
    //        reportServicesBean.setKensakuKeys(uiBean.getSyono());
    //
    //        reportServicesBean.addParamObjects(bzHandkarikanjoBean);
    //
    //        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
    //
    //        khozenTyouhyouCtl.setReportServicesBean(reportServicesBean);
    //
    //        khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam,
    //            new C_SyoruiCdKbn[]{C_SyoruiCdKbn.KK_HANDKARIKANJYOU}, C_YouhiKbn.YOU);
    //
    //        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
    //
    //        uiBean.setTyouhyouKey(khozenTyouhyouCtl.getTyouhyouKey());
    //    }
}
