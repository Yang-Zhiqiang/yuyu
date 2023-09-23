package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 契約保全 案内収納共通 保険料領収通貨換算計算
 */
public class KeisanPRsTuukaKnsn {

    private KeisanPRsTuukaKnsnKekkaBean pRsTuukaKnsn;

    private List<String> errorCd;

    private String errorRiyuu;

    @Inject
    private static Logger logger;

    public KeisanPRsTuukaKnsnKekkaBean getPRsTuukaKnsn() {

        return pRsTuukaKnsn;
    }

    public List<String> getErrorCd() {

        return errorCd;
    }

    public String getErrorRiyuu() {
        return errorRiyuu;
    }

    public C_ErrorKbn exec(BizDate pKwsratekjymd, BizCurrency pHokenryou, C_Tuukasyu pKnsnmotoTuukasyu,
        C_Tuukasyu pKnsnsakiTuukasyu) {

        logger.debug("▽ 保険料領収通貨換算計算 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        errorCd = new ArrayList<String>();

        if (pKwsratekjymd == null) {

            kekkaKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 保険料領収通貨換算計算 終了");

            return kekkaKbn;
        }

        if (pHokenryou == null) {

            kekkaKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 保険料領収通貨換算計算 終了");

            return kekkaKbn;
        }

        if (C_Tuukasyu.BLNK.eq(pKnsnmotoTuukasyu)) {

            kekkaKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 保険料領収通貨換算計算 終了");

            return kekkaKbn;
        }

        if (C_Tuukasyu.BLNK.eq(pKnsnsakiTuukasyu)) {

            kekkaKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 保険料領収通貨換算計算 終了");

            return kekkaKbn;
        }

        if (pKnsnmotoTuukasyu.eq(pKnsnsakiTuukasyu)) {

            kekkaKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_TUUKASYUU_CHKERROR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_TUUKASYUU_CHKERROR);

            logger.debug("△ 保険料領収通貨換算計算 終了");

            return kekkaKbn;
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        C_ErrorKbn kwsRateKekkaKbn = getKawaseRate.exec(
            pKwsratekjymd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            pKnsnmotoTuukasyu,
            pKnsnsakiTuukasyu,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.BLNK,
            C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.ERROR.eq(kwsRateKekkaKbn)) {

            kekkaKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_KAWASERATESYUTOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_KAWASERATESYUTOKUERR);

            logger.debug("△ 保険料領収通貨換算計算 終了");

            return kekkaKbn;
        }

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        BizCurrency kanzanGaku = keisanGaikakanzan.exec(
            pKnsnsakiTuukasyu,
            pHokenryou,
            getKawaseRate.getKawaserate(),
            C_HasuusyoriKbn.SUTE);

        pRsTuukaKnsn = SWAKInjector.getInstance(KeisanPRsTuukaKnsnKekkaBean.class);
        pRsTuukaKnsn.setRstuukaknsngop(kanzanGaku);
        pRsTuukaKnsn.setRstuukaknsnkwsratekjnymd(getKawaseRate.getKwsrateKjYmd());
        pRsTuukaKnsn.setRstuukaknsnkwsrate(getKawaseRate.getKawaserate());
        pRsTuukaKnsn.setRstuukaknsngotuukasyu(pKnsnsakiTuukasyu);

        logger.debug("△ 保険料領収通貨換算計算 終了");

        return kekkaKbn;
    }
}
