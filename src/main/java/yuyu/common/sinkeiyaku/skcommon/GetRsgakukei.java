package yuyu.common.sinkeiyaku.skcommon;

import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 新契約共通 領収金額合計取得
 */
public class GetRsgakukei {

    private BizCurrency rsgakukei = BizCurrency.valueOf(0);

    private C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;

    @Inject
    private static Logger logger;

    public GetRsgakukei() {
        super();
    }

    public BizCurrency getRsgakukei() {

        return rsgakukei;
    }

    public C_Tuukasyu getTuukasyu() {

        return tuukasyu;
    }

    public void getPkakinsumiRsgaku(HT_SyoriCTL pSyoriCTL) {

        logger.debug("▽ 領収金額合計取得（Ｐ過金計上済） 開始");

        Map<CurrencyType, BizCurrency> ryosyuMp = pSyoriCTL.getNyuukinSumRyosyugk();

        Map<CurrencyType, BizCurrency> henkinMp = pSyoriCTL.getHenkinSumHnkngk();

        calcSagaku(ryosyuMp, henkinMp);

        logger.debug("△ 領収金額合計取得（Ｐ過金計上済） 終了");
    }

    public void getPkakinsumiRsgaku(HT_SyoriCTL pSyoriCTL, C_Tuukasyu pTuukasyu) {

        logger.debug("▽ 領収金額合計取得（Ｐ過金計上済） 開始");

        Map<CurrencyType, BizCurrency> ryosyuMp = pSyoriCTL.getNyuukinSumRsgakuByRstuukasyu(pTuukasyu);

        Map<CurrencyType, BizCurrency> henkinMp = pSyoriCTL.getHenkinSumHnkngkByHnkntuukasyu(pTuukasyu);

        calcSagaku(ryosyuMp, henkinMp);

        logger.debug("△ 領収金額合計取得（Ｐ過金計上済） 終了");
    }

    public void getPkakinsumiRsgaku(HT_SyoriCTL pSyoriCTL, BizDate pKijyunYmd) {

        logger.debug("▽ 領収金額合計取得（Ｐ過金計上済）（基準日指定） 開始");

        Map<CurrencyType, BizCurrency> ryosyuMp = pSyoriCTL.getNyuukinSumRsgakuByNyksyoriymd(pKijyunYmd);

        Map<CurrencyType, BizCurrency> henkinMp = pSyoriCTL.getHenkinSumHnkngkByPkakinsyoriymd(pKijyunYmd);

        calcSagaku(ryosyuMp, henkinMp);

        logger.debug("△ 領収金額合計取得（Ｐ過金計上済）（基準日指定） 終了");
    }

    public void getPkakinsumiRsgaku(HT_SyoriCTL pSyoriCTL, C_Tuukasyu pTuukasyu, BizDate pKijyunYmd) {

        logger.debug("▽ 領収金額合計取得（Ｐ過金計上済）（基準日指定） 開始");

        Map<CurrencyType, BizCurrency> ryosyuMp = pSyoriCTL.getNyuukinSumRsgakuByRstuukasyuNyksyoriymd(pTuukasyu, pKijyunYmd);

        Map<CurrencyType, BizCurrency> henkinMp = pSyoriCTL.getHenkinSumHnkngkByHnkntuukasyuPkakinsyoriymd(pTuukasyu, pKijyunYmd);

        calcSagaku(ryosyuMp, henkinMp);

        logger.debug("△ 領収金額合計取得（Ｐ過金計上済）（基準日指定） 終了");
    }

    public void getPkakinsumiRsgaku(HT_SyoriCTL pSyoriCTL, BizDate pRyosyuymd, BizDate pPkakinsyoriymd) {

        logger.debug("▽ 領収金額合計取得（Ｐ過金計上済）（領収日・Ｐ過金処理日指定） 開始");

        Map<CurrencyType, BizCurrency> ryosyuMp = pSyoriCTL.getNyuukinSumRsgakuByRyosyuymd(pRyosyuymd);

        BizDate kijyunymd = pPkakinsyoriymd.addDays(-1);

        Map<CurrencyType, BizCurrency> henkinMp = pSyoriCTL.getHenkinSumHnkngkByPkakinsyoriymd(kijyunymd);

        calcSagaku(ryosyuMp, henkinMp);

        logger.debug("▽ 領収金額合計取得（Ｐ過金計上済）（領収日・Ｐ過金処理日指定） 終了");
    }

    public void getHenkinsumiRsgaku(HT_SyoriCTL pSyoriCTL) {

        logger.debug("▽ 領収金額合計取得（返金済） 開始");

        Map<CurrencyType, BizCurrency> ryosyuMp = pSyoriCTL.getNyuukinSumRyosyugk();

        Map<CurrencyType, BizCurrency> henkinMp = pSyoriCTL.getHenkinSumHnkngkByHnknsyoriymd();

        calcSagaku(ryosyuMp, henkinMp);

        logger.debug("△ 領収金額合計取得（返金済） 終了");
    }

    public void getHenkinsumiRsgaku(HT_SyoriCTL pSyoriCTL, C_Tuukasyu pTuukasyu) {

        logger.debug("▽ 領収金額合計取得（返金済） 開始");

        Map<CurrencyType, BizCurrency> ryosyuMp = pSyoriCTL.getNyuukinSumRsgakuByRstuukasyu(pTuukasyu);

        Map<CurrencyType, BizCurrency> henkinMp = pSyoriCTL.getHenkinSumHnkngkByHnkntuukasyuHnknsyoriymd(pTuukasyu);

        calcSagaku(ryosyuMp, henkinMp);

        logger.debug("△ 領収金額合計取得（返金済） 終了");
    }

    public void getHenkinsumiRsgaku(HT_SyoriCTL pSyoriCTL, BizDate pKijyunYmd) {

        logger.debug("▽ 領収金額合計取得（返金済）（基準日指定） 開始");

        Map<CurrencyType, BizCurrency> ryosyuMp = pSyoriCTL.getNyuukinSumRsgakuByNyksyoriymd(pKijyunYmd);

        Map<CurrencyType, BizCurrency> henkinMp = pSyoriCTL.getHenkinSumHnkngkByHnknsyoriymdLe(pKijyunYmd);

        calcSagaku(ryosyuMp, henkinMp);

        logger.debug("△ 領収金額合計取得（返金済）（基準日指定） 終了");
    }

    public void getHenkinsumiRsgaku(HT_SyoriCTL pSyoriCTL, C_Tuukasyu pTuukasyu, BizDate pKijyunYmd) {

        logger.debug("▽ 領収金額合計取得（返金済）（基準日指定） 開始");

        Map<CurrencyType, BizCurrency> ryosyuMp = pSyoriCTL.getNyuukinSumRsgakuByRstuukasyuNyksyoriymd(pTuukasyu, pKijyunYmd);

        Map<CurrencyType, BizCurrency> henkinMp = pSyoriCTL.getHenkinSumHnkngkByHnkntuukasyuHnknsyoriymdLe(pTuukasyu, pKijyunYmd);

        calcSagaku(ryosyuMp, henkinMp);

        logger.debug("△ 領収金額合計取得（返金済）（基準日指定） 終了");
    }

    private void calcSagaku(Map<CurrencyType, BizCurrency> pRyosyuMp, Map<CurrencyType, BizCurrency> pHenkinMp) {

        rsgakukei = BizCurrency.valueOf(0);
        tuukasyu = C_Tuukasyu.BLNK;

        if (pRyosyuMp.size() > 0) {

            java.util.Iterator<CurrencyType> itRyosyu = pRyosyuMp.keySet().iterator();

            while (itRyosyu.hasNext()) {

                CurrencyType rstuukasyu = itRyosyu.next();
                BizCurrency ryosyukukei = pRyosyuMp.get(rstuukasyu);
                BizCurrency henkinkukei = BizCurrency.valueOf(0, rstuukasyu);

                if (pHenkinMp.size() > 0 && pHenkinMp.containsKey(rstuukasyu)) {

                    henkinkukei = pHenkinMp.get(rstuukasyu);
                }

                BizCurrency sasibiki = ryosyukukei.subtract(henkinkukei);

                if (!BizUtil.isZero(sasibiki)) {

                    HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                    rsgakukei = sasibiki;
                    tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(rstuukasyu);

                    break;
                }
            }
        }
    }

}
