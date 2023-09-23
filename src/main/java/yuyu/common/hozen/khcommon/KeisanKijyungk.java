package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 契約保全 契約保全共通 基準金額計算
 * 初期死亡時円換算支払額最低保証特約、目標到達時円建終身保険変更特約の基準金額を算出する
 */
public class KeisanKijyungk {

    private BizCurrency kijyungk = null;

    private BizNumber yenkawaserate = null;

    @Inject
    private static Logger logger;

    public KeisanKijyungk() {
        super();
    }

    public C_ErrorKbn exec(
            BizDate pPryousyuuymd,
            BizCurrency pRsgaku,
            BizCurrency pHokenryou,
            C_Tuukasyu  pKyktuukasyu,
            C_Tkhukaumu pYennykntkhkkbn) {

        logger.debug("▽ 基準金額計算 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        if (C_Tkhukaumu.HUKA.eq(pYennykntkhkkbn)) {

            kijyungk = pRsgaku;
        }
        else {

            C_ErrorKbn getKawaseRateResult = getKawaseRate.exec(
                    pPryousyuuymd,
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    pKyktuukasyu,
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(getKawaseRateResult)) {

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 基準金額計算 終了");

                return errorKbn;
            }

            yenkawaserate = getKawaseRate.getKawaserate();

            kijyungk = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                    pHokenryou,
                    yenkawaserate,
                    C_HasuusyoriKbn.AGE);
        }

        logger.debug("｜ ▽ 設定値");
        logger.debug("｜ ｜ 円換算為替レート＝" + yenkawaserate);
        logger.debug("｜ ｜ 基準金額＝" + kijyungk);
        logger.debug("｜ △ ");
        logger.debug("△ 基準金額計算 終了");

        return C_ErrorKbn.OK;
    }

    public BizCurrency getKijyungk() {
        return kijyungk;
    }

    public BizNumber getYenkawaserate() {
        return yenkawaserate;
    }

}