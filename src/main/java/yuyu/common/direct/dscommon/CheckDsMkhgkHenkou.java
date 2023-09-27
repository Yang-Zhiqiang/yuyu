package yuyu.common.direct.dscommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.direct.dscommon.dba4checkdsmkhgkhenkou.CheckDsMkhgkHenkouDao;
import yuyu.common.direct.dscommon.dba4checkdsmkhgkhenkou.KhHenkouUktkMkhgkHenkouInfoBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.sinkeiyaku.skcommon.ConvertChannelcd;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_CheckDsMkhgkHenkouKekkaKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_ChkTargetTkMokuhyouti;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ目標額変更共通チェック
 */
public class CheckDsMkhgkHenkou {

    private C_CheckDsMkhgkHenkouKekkaKbn checkDsMkhgkHenkouKekkaKbn;

    private C_KahiKbn mkhgkHenkoukykKahiKbn;

    @Inject
    private static Logger logger;

    @Inject
    private CheckDsMkhgkHenkouDao checkDsMkhgkHenkouDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    public CheckDsMkhgkHenkou() {
        super();
    }

    public C_CheckDsMkhgkHenkouKekkaKbn getCheckDsMkhgkHenkouKekkaKbn() {
        return checkDsMkhgkHenkouKekkaKbn;
    }

    public C_KahiKbn getMkhgkHenkoukykKahiKbn() {
        return mkhgkHenkoukykKahiKbn;
    }

    public C_ErrorKbn chkMkhgkHnkSyoriKahi(String pSyono) {

        logger.debug("▽ 目標額変更処理可否チェック 開始");

        mkhgkHenkoukykKahiKbn = C_KahiKbn.KA;
        checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.BLANK;

        C_ErrorKbn chkKadouTimeErrorKbn = chkKadouTime();

        if (C_ErrorKbn.ERROR.eq(chkKadouTimeErrorKbn)) {

            logger.debug("△ 目標額変更処理可否チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        if (BizUtil.isBlank(pSyono)) {

            mkhgkHenkoukykKahiKbn = C_KahiKbn.HUKA;
            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU;

            logger.info("与件未設定エラー");
            logger.debug("△ 目標額変更処理可否チェック 終了");
            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkMfdataHuseigouErrorKbn = chkMfdataHuseigou(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkMfdataHuseigouErrorKbn)) {

            logger.debug("△ 目標額変更処理可否チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkTratkiTaisyouSyouhnErrorKbn = chkTratkiTaisyouSyouhn(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkTratkiTaisyouSyouhnErrorKbn)) {

            logger.debug("△ 目標額変更処理可否チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkKykymdMitouraiErrorKbn = chkKykymdMitourai(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkKykymdMitouraiErrorKbn)) {

            logger.debug("△ 目標額変更処理可否チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkDsDataMaintenanceErrorKbn = chkDsDataMaintenance(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkDsDataMaintenanceErrorKbn)) {

            logger.debug("△ 目標額変更処理可否チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        logger.debug("△ 目標額変更処理可否チェック 終了");

        return C_ErrorKbn.OK;
    }

    public C_ErrorKbn chkMkhgkHnkUktkNaiyou(String pSyono) {

        logger.debug("▽ 目標額変更受付内容チェック 開始");

        mkhgkHenkoukykKahiKbn = C_KahiKbn.KA;
        checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.BLANK;

        C_ErrorKbn chkKadouTimeErrorKbn = chkKadouTime();

        if (C_ErrorKbn.ERROR.eq(chkKadouTimeErrorKbn)) {

            logger.debug("△ 目標額変更受付内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        if (BizUtil.isBlank(pSyono)) {

            mkhgkHenkoukykKahiKbn = C_KahiKbn.HUKA;
            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU;

            logger.info("与件未設定エラー");
            logger.debug("△ 目標額変更受付内容チェック 終了");
            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkMfdataHuseigouErrorKbn = chkMfdataHuseigou(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkMfdataHuseigouErrorKbn)) {

            logger.debug("△ 目標額変更受付内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkTratkiTaisyouSyouhnErrorKbn = chkTratkiTaisyouSyouhn(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkTratkiTaisyouSyouhnErrorKbn)) {

            logger.debug("△ 目標額変更受付内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkKykymdMitouraiErrorKbn = chkKykymdMitourai(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkKykymdMitouraiErrorKbn)) {

            logger.debug("△ 目標額変更受付内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkDsDataMaintenanceErrorKbn = chkDsDataMaintenance(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkDsDataMaintenanceErrorKbn)) {

            logger.debug("△ 目標額変更受付内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkMkhgkHnkKanouKknErrorKbn = chkMkhgkHnkKanouKkn(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkMkhgkHnkKanouKknErrorKbn)) {

            logger.debug("△ 目標額変更受付内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkYuukouJyotaiErrorKbn = chkYuukouJyotai(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkYuukouJyotaiErrorKbn)) {

            logger.debug("△ 目標額変更受付内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkTtdkTyuuiErrorKbn = chkTtdkTyuui(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkTtdkTyuuiErrorKbn)) {

            logger.debug("△ 目標額変更受付内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        logger.debug("△ 目標額変更受付内容チェック 終了");

        return C_ErrorKbn.OK;
    }

    public C_ErrorKbn chkMkhgkHnkInputNaiyou(String pSyono, Integer pHnkgoMkhgkWari) {

        logger.debug("▽ 目標額変更入力内容チェック 開始");

        mkhgkHenkoukykKahiKbn = C_KahiKbn.KA;
        checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.BLANK;

        C_ErrorKbn chkKadouTimeErrorKbn = chkKadouTime();

        if (C_ErrorKbn.ERROR.eq(chkKadouTimeErrorKbn)) {

            logger.debug("△ 目標額変更入力内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        if (BizUtil.isBlank(pSyono) || pHnkgoMkhgkWari == null) {

            mkhgkHenkoukykKahiKbn = C_KahiKbn.HUKA;
            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU;

            logger.info("与件未設定エラー");
            logger.debug("△ 目標額変更入力内容チェック 終了");
            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkMfdataHuseigouErrorKbn = chkMfdataHuseigou(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkMfdataHuseigouErrorKbn)) {

            logger.debug("△ 目標額変更入力内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkMkhgkWariInputNaiyouErrorKbn = chkMkhgkWariInputNaiyou(pSyono, pHnkgoMkhgkWari);

        if (C_ErrorKbn.ERROR.eq(chkMkhgkWariInputNaiyouErrorKbn)) {

            logger.debug("△ 目標額変更入力内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkMkhgkWariSeigouseiErrorKbn = chkMkhgkWariSeigousei(pSyono, pHnkgoMkhgkWari);

        if (C_ErrorKbn.ERROR.eq(chkMkhgkWariSeigouseiErrorKbn)) {

            logger.debug("△ 目標額変更入力内容チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        logger.debug("△ 目標額変更入力内容チェック 終了");

        return C_ErrorKbn.OK;
    }

    public C_ErrorKbn chkMkhgkHnkUktkDataUpd(String pSyono, Integer pHnkgoMkhgkWari) {

        logger.debug("▽ 目標額変更受付データ更新チェック 開始");

        mkhgkHenkoukykKahiKbn = C_KahiKbn.KA;
        checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.BLANK;

        C_ErrorKbn chkKadouTimeErrorKbn = chkKadouTime();

        if (C_ErrorKbn.ERROR.eq(chkKadouTimeErrorKbn)) {

            logger.debug("△ 目標額変更受付データ更新チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        if (BizUtil.isBlank(pSyono) || pHnkgoMkhgkWari == null) {

            mkhgkHenkoukykKahiKbn = C_KahiKbn.HUKA;
            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU;

            logger.info("与件未設定エラー");
            logger.debug("△ 目標額変更受付データ更新チェック 終了");
            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkMfdataHuseigouErrorKbn = chkMfdataHuseigou(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkMfdataHuseigouErrorKbn)) {

            logger.debug("△ 目標額変更受付データ更新チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkTratkiTaisyouSyouhnErrorKbn = chkTratkiTaisyouSyouhn(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkTratkiTaisyouSyouhnErrorKbn)) {

            logger.debug("△ 目標額変更受付データ更新チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkKykymdMitouraiErrorKbn = chkKykymdMitourai(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkKykymdMitouraiErrorKbn)) {

            logger.debug("△ 目標額変更受付データ更新チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkDsDataMaintenanceErrorKbn = chkDsDataMaintenance(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkDsDataMaintenanceErrorKbn)) {

            logger.debug("△ 目標額変更受付データ更新チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkMkhgkHnkKanouKknErrorKbn = chkMkhgkHnkKanouKkn(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkMkhgkHnkKanouKknErrorKbn)) {

            logger.debug("△ 目標額変更受付データ更新チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkYuukouJyotaiErrorKbn = chkYuukouJyotai(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkYuukouJyotaiErrorKbn)) {

            logger.debug("△ 目標額変更受付データ更新チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkTtdkTyuuiErrorKbn = chkTtdkTyuui(pSyono);

        if (C_ErrorKbn.ERROR.eq(chkTtdkTyuuiErrorKbn)) {

            logger.debug("△ 目標額変更受付データ更新チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        C_ErrorKbn chkMkhgkWariSeigouseiErrorKbn = chkMkhgkWariSeigousei(pSyono, pHnkgoMkhgkWari);

        if (C_ErrorKbn.ERROR.eq(chkMkhgkWariSeigouseiErrorKbn)) {

            logger.debug("△ 目標額変更受付データ更新チェック 終了");

            return C_ErrorKbn.ERROR;
        }

        logger.debug("△ 目標額変更受付データ更新チェック 終了");

        return C_ErrorKbn.OK;
    }

    private C_ErrorKbn chkKadouTime() {

        BizDate sysDate = BizDate.getSysDate();

        String sysDateTime = BizDate.getSysDateTimeMilli();

        String yakanJobKadouKaisiTime = YuyuDswebConfig.getInstance().getYakanJobKadouKaisiTime();

        if (sysDate.isBusinessDay() && Integer.parseInt(sysDateTime.substring(8, sysDateTime.length())) < Integer.parseInt(yakanJobKadouKaisiTime)) {

            return C_ErrorKbn.OK;
        }

        checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI;

        return C_ErrorKbn.ERROR;
    }

    private C_ErrorKbn chkTratkiTaisyouSyouhn(String pSyono) {

        IT_KykSonotaTkyk kykSonotaTkyk = hozenDomManager.getKykKihon(pSyono).getKykSonotaTkyk();

        if (!C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {

            mkhgkHenkoukykKahiKbn = C_KahiKbn.HUKA;
            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.TARGETTKYK;

            return C_ErrorKbn.ERROR;
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTeikishrtkykhukaumu())) {

            mkhgkHenkoukykKahiKbn = C_KahiKbn.HUKA;
            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.TEIKISHIHARAITKYK;

            return C_ErrorKbn.ERROR;
        }

        return C_ErrorKbn.OK;
    }

    private C_ErrorKbn chkKykymdMitourai(String pSyono) {

        IT_KykSyouhn kykSyouhn = hozenDomManager.getKykKihon(pSyono).getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        BizDate sysDate = BizDate.getSysDate();

        if (BizDateUtil.compareYmd(sysDate, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

            mkhgkHenkoukykKahiKbn = C_KahiKbn.HUKA;
            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.KEIYAKUYMDMAE;

            return C_ErrorKbn.ERROR;
        }

        return C_ErrorKbn.OK;
    }

    private C_ErrorKbn chkDsDataMaintenance(String pSyono) {

        DsDataMaintenanceHantei dsDataMaintenanceHantei = SWAKInjector.getInstance(DsDataMaintenanceHantei.class);

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = dsDataMaintenanceHantei.exec(pSyono);

        if (C_UmuKbn.ARI.eq(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn())) {

            mkhgkHenkoukykKahiKbn = C_KahiKbn.HUKA;
            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.DSDATAMAINTENANCE;

            return C_ErrorKbn.ERROR;
        }

        return C_ErrorKbn.OK;
    }

    private C_ErrorKbn chkMkhgkHnkKanouKkn(String pSyono) {

        IT_KykSyouhn kykSyouhn = hozenDomManager.getKykKihon(pSyono).getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        BizDate mkhgkHnkUktkKigen = null;

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {

            BizDate kykymd = kykSyouhn.getKykymd().addYears(15);

            if (!kykymd.isRekijyou()) {

                mkhgkHnkUktkKigen = kykymd.getRekijyou().addDays(1);
            }
            else {
                mkhgkHnkUktkKigen = kykymd;
            }

            BizDate sysDate = BizDate.getSysDate();

            if (BizDateUtil.compareYmd(sysDate, mkhgkHnkUktkKigen) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(sysDate, mkhgkHnkUktkKigen) == BizDateUtil.COMPARE_EQUAL) {

                checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.MKHGKHNKKANOUKIKANGAI;

                return C_ErrorKbn.ERROR;
            }
        }

        return C_ErrorKbn.OK;
    }

    private C_ErrorKbn chkYuukouJyotai(String pSyono) {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(C_DsKinouidKbn.MKHGKHENKOUUKETUKE.getValue());

        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        checkYuukouJyoutaiParam.setSyono(pSyono);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.HOZENYUUKOUJYOUTAI;

            return C_ErrorKbn.ERROR;
        }

        return C_ErrorKbn.OK;
    }

    private C_ErrorKbn chkTtdkTyuui(String pSyono) {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(C_DsKinouidKbn.MKHGKHENKOUUKETUKE.getValue());

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, pSyono);

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.TETUDUKITYUUI;

            return C_ErrorKbn.ERROR;
        }

        return C_ErrorKbn.OK;
    }

    private C_ErrorKbn chkMkhgkWariInputNaiyou(String pSyono, Integer pHnkgoMkhgkWari) {

        long khHnkUktkKensuu = checkDsMkhgkHenkouDao.getKhHenkouUktkCountBySyono(pSyono);

        if (khHnkUktkKensuu == 0) {

            IT_KykSonotaTkyk kykSonotaTkyk = hozenDomManager.getKykKihon(pSyono).getKykSonotaTkyk();

            int nowTargettkmkht = kykSonotaTkyk.getTargettkmokuhyouti();

            if (nowTargettkmkht == 0) {

                nowTargettkmkht = 999;
            }

            if (pHnkgoMkhgkWari == nowTargettkmkht) {

                checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARIGENZAIHENKOUNASHI;

                return C_ErrorKbn.ERROR;
            }
        }
        else {

            KhHenkouUktkMkhgkHenkouInfoBean khHenkouUktkMkhgkHenkouInfoBean =
                checkDsMkhgkHenkouDao.getKhHenkouUktkMkhgkHenkouInfoBySyono(pSyono).get(0);

            int saisinTargettkmkht = khHenkouUktkMkhgkHenkouInfoBean.getTargettkmokuhyouti();

            if (pHnkgoMkhgkWari == saisinTargettkmkht) {

                checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARITETUDUKITYUUHENKOUNASHI;

                return C_ErrorKbn.ERROR;
            }
        }

        return C_ErrorKbn.OK;
    }

    private C_ErrorKbn chkMkhgkWariSeigousei(String pSyono, Integer pHnkgoMkhgkWari) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhncd = kykSyouhn.getSyouhncd();
        int syouhnsdno = kykSyouhn.getSyouhnsdno();

        IT_KykDairiten kykDairiten = kykKihon.getKykDairitenByDrtenrenno(1);

        ConvertChannelcd convertChannelcd = SWAKInjector.getInstance(ConvertChannelcd.class);
        C_Channelcd kiteiCheckChannelCd = convertChannelcd.exec(null, kykDairiten.getOyadrtencd());

        List<BM_ChkTargetTkMokuhyouti> chkTargetTkMokuhyoutiLst =
            bizDomManager.getChkTargetTkMokuhyoutisByPk(syouhncd, syouhnsdno, kiteiCheckChannelCd, pHnkgoMkhgkWari);

        if (chkTargetTkMokuhyoutiLst.size() == 0) {

            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARISEIGOUSEI;

            return C_ErrorKbn.ERROR;
        }

        return C_ErrorKbn.OK;
    }

    private C_ErrorKbn chkMfdataHuseigou(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        if (kykKihon == null) {

            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU;

            logger.info("契約基本テーブル取得エラー");

            return C_ErrorKbn.ERROR;

        }

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnList.size() == 0) {

            checkDsMkhgkHenkouKekkaKbn = C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU;

            logger.info("契約商品テーブル取得エラー");

            return C_ErrorKbn.ERROR;
        }

        return C_ErrorKbn.OK;
    }
}
