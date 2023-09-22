package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;

/**
 * 新契約 新契約共通 規定チェック用円換算金額取得
 */
public class GetKiteiCheckYenkansangk {

    @Inject
    private static Logger logger;

    private BizNumber kijyungkHanteiyouKawaseRate;

    private C_ErrorKbn errorKbn;

    @Inject
    private BizDomManager bizDomManager;

    public GetKiteiCheckYenkansangk() {
        super();
    }

    public BizNumber getKijyungkHanteiyouKawaseRate() {
        return kijyungkHanteiyouKawaseRate;
    }

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public BizCurrency exec(BizDate pKijyunYmd, BizCurrency pGaku, C_Tuukasyu pTuukaSyu) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 規定チェック用円換算金額取得クラス 開始");
        }

        kijyungkHanteiyouKawaseRate = BizNumber.ZERO;
        errorKbn = C_ErrorKbn.OK;

        BizCurrency yenkansanGk = BizCurrency.valueOf(0);

        if (pKijyunYmd == null || pGaku == null || pTuukaSyu == null) {

            errorKbn = C_ErrorKbn.ERROR;
            logger.error("規定チェック用円換算金額取得クラス引数エラー");
            logger.info("パラメータ　基準日＝" +  String.valueOf(pKijyunYmd));
            logger.info("パラメータ　金額＝" + String.valueOf(pGaku));
            logger.info("パラメータ　通貨種類＝" + String.valueOf(pTuukaSyu));

            return yenkansanGk;
        }

        if (C_Tuukasyu.JPY.eq(pTuukaSyu)) {

            yenkansanGk = pGaku;

            if (logger.isDebugEnabled()) {
                logger.debug(" △ 規定チェック用円換算金額取得クラス 終了");
            }

            return yenkansanGk;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTuukaSyu);
        if (pGaku.compareTo(BizCurrency.valueOf(0, currencyType)) == 0) {
            if (logger.isDebugEnabled()) {
                logger.debug(" △ 規定チェック用円換算金額取得クラス 終了");
            }
            return yenkansanGk;
        }

        SetKessanNensibi setKessanNensibi  = SWAKInjector.getInstance(SetKessanNensibi.class);
        String kijunNendo = setKessanNensibi.exec(pKijyunYmd).getBizDateY().toString();

        BM_KijyungkHanteiKawaseRate kijyungkHanteiKawaseRate =
            bizDomManager.getKijyungkHanteiKawaseRate(kijunNendo, pTuukaSyu);
        if (kijyungkHanteiKawaseRate == null) {
            errorKbn = C_ErrorKbn.ERROR;
            logger.error("基準額判定用為替レートが取得できませんでした");
            logger.info("パラメータ　基準年度＝" + kijunNendo);
            logger.info("パラメータ　通貨種類＝" + String.valueOf(pTuukaSyu));

            return yenkansanGk;
        }

        kijyungkHanteiyouKawaseRate = kijyungkHanteiKawaseRate.getKjngkhntiyukawaserate();

        KeisanGaikakanzan keisanGaikakanzan  = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        yenkansanGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pGaku, kijyungkHanteiyouKawaseRate, C_HasuusyoriKbn.SUTE);

        if (logger.isDebugEnabled()) {
            logger.debug(" △ 規定チェック用円換算金額取得クラス 終了");
        }

        return yenkansanGk;
    }
}
