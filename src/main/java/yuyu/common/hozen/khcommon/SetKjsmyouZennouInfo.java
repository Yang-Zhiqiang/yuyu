package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 控除証明用前納情報設定
 */
public class SetKjsmyouZennouInfo {

    private BizDate kjsmyouzennoukaisiymd;

    private String kjsmyouzennoukikanm;

    private BizCurrency kjsmyouzennounyuukingk;

    private BizDate kjsmyouYenknsnrateKijyunymd;

    private BizNumber kjsmyouYenknsnkawaserate;

    private BizDate yenkaknsnKijyunymd;

    private BizNumber yenknsnKawaseRate;

    @Inject
    private static Logger logger;

    public SetKjsmyouZennouInfo() {
        super();
    }

    public C_ErrorKbn exec(BizDate pZennoujijyutoukaisiymd, String pZennoujijyutoukikan, BizCurrency pZennoujipnyknkgk,
        C_Hrkkaisuu pHrkkaisuu, BizCurrency pHrkp, C_UmuKbn pZennouwrbktekiyougaipumu) {

        logger.debug("▽ 控除証明用前納情報設定 開始");

        BizCurrency zennoujipnyknkgk = pZennoujipnyknkgk;

        BizCurrency hrkp = pHrkp;

        BizNumber yenknsnrate = BizNumber.valueOf(0);

        BizDate kwsrateKjYmd = null;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu hrkpTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pHrkp.getType());

        if (!C_Tuukasyu.JPY.eq(hrkpTuukasyu)) {

            if (yenkaknsnKijyunymd == null) {

                throw new CommonBizAppException("控除証明用前納情報設定　与件エラー　円換算基準日＝" + yenkaknsnKijyunymd);
            }

            if (yenknsnKawaseRate == null || yenknsnKawaseRate.compareTo(BizNumber.ZERO) == 0) {

                throw new CommonBizAppException("控除証明用前納情報設定　与件エラー　円換算為替レート＝" + yenknsnKawaseRate);
            }

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            hrkp = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                pHrkp,
                yenknsnKawaseRate,
                C_HasuusyoriKbn.SUTE
                );

            kwsrateKjYmd = yenkaknsnKijyunymd;
            yenknsnrate = yenknsnKawaseRate;

            C_Tuukasyu zennoujipnyknkgkTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pZennoujipnyknkgk.getType());

            if (!C_Tuukasyu.JPY.eq(zennoujipnyknkgkTuukasyu)) {

                zennoujipnyknkgk = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    pZennoujipnyknkgk,
                    yenknsnKawaseRate,
                    C_HasuusyoriKbn.SUTE
                    );
            }
        }

        kjsmyouYenknsnrateKijyunymd = kwsrateKjYmd;

        kjsmyouYenknsnkawaserate = yenknsnrate;

        if (C_UmuKbn.ARI.eq(pZennouwrbktekiyougaipumu)) {

            if (!C_Hrkkaisuu.TUKI.eq(pHrkkaisuu) && !C_Hrkkaisuu.NEN.eq(pHrkkaisuu)) {

                throw new CommonBizAppException("控除証明用前納情報設定　与件エラー　払込回数＝" + pHrkkaisuu.getContent());
            }

            kjsmyouzennoukaisiymd = pZennoujijyutoukaisiymd.addMonths(Integer.parseInt(pHrkkaisuu.getValue()));

            kjsmyouzennoukikanm = String.valueOf((Integer.parseInt(pZennoujijyutoukikan) * 12)
                - (Integer.parseInt(pHrkkaisuu.getValue())));

            kjsmyouzennounyuukingk = zennoujipnyknkgk.subtract(hrkp);
        }
        else {

            kjsmyouzennoukaisiymd = pZennoujijyutoukaisiymd;

            kjsmyouzennoukikanm = String.valueOf(Integer.parseInt(pZennoujijyutoukikan) * 12);

            kjsmyouzennounyuukingk = zennoujipnyknkgk;
        }

        logger.debug("△ 控除証明用前納情報設定 終了");

        return C_ErrorKbn.OK;
    }

    public BizDate getKjsmyouzennoukaisiymd() {

        return kjsmyouzennoukaisiymd;
    }

    public String getKjsmyouzennoukikanm() {

        return kjsmyouzennoukikanm;
    }

    public BizCurrency getKjsmyouzennounyuukinkgk() {

        return kjsmyouzennounyuukingk;
    }

    public BizDate getKjsmyouenknsnkijyunymd() {

        return kjsmyouYenknsnrateKijyunymd;
    }

    public BizNumber getKjsmyouenknsnrate() {

        return kjsmyouYenknsnkawaserate;
    }

    public void setYenkaknsnKijyunymd(BizDate pYenkaknsnKijyunymd) {

        yenkaknsnKijyunymd = pYenkaknsnKijyunymd;
    }

    public void setYenknsnKawaseRate(BizNumber pYenknsnKawaseRate) {

        yenknsnKawaseRate = pYenknsnKawaseRate;
    }
}
