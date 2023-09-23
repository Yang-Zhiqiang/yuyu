package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

/**
 * 契約保全 契約保全共通 通算用金額取得
 */
public class GetKhTuusanyouKngk {

    private C_Tuukasyu tsnyouTuukasyu;

    private CurrencyType tuukaType;

    @Inject
    private static Logger logger;

    public GetKhTuusanyouKngk() {
        super();
    }

    public GetKhTuusanyouKngkBean getAlltsnkngk(
        BM_SyouhnZokusei pSyouhnZokusei,
        IT_KykSyouhn pKykSyouhn,
        IT_NyknJissekiRireki pNyknJissekiRireki,
        IT_KykSonotaTkyk pKykSonotaTkyk) {

        logger.debug("▽ 通算用金額取得 通算用金額一括取得 開始");

        getTsnyouTuukasyu(pSyouhnZokusei, pKykSyouhn);

        BizCurrency tsnyouSibous = getTsnyouSibous(pSyouhnZokusei, pKykSyouhn);

        BizCurrency tsnyouItijip = getTsnyouItijip(pSyouhnZokusei, pKykSyouhn);

        BizCurrency tsnyouNkgns = getTsnyouNkgns(pSyouhnZokusei, pKykSyouhn);

        BizCurrency tsnyouYennyknkgk = getTsnyouYennyknkgk(pSyouhnZokusei, pNyknJissekiRireki, pKykSonotaTkyk);

        GetKhTuusanyouKngkBean getKhTuusanyouKngkBean = SWAKInjector.getInstance(GetKhTuusanyouKngkBean.class);

        getKhTuusanyouKngkBean.setTsnyouTuukasyu(tsnyouTuukasyu);
        getKhTuusanyouKngkBean.setTsnyouSibous(tsnyouSibous);
        getKhTuusanyouKngkBean.setTsnyouItijip(tsnyouItijip);
        getKhTuusanyouKngkBean.setTsnyouNkgns(tsnyouNkgns);
        getKhTuusanyouKngkBean.setTsnyouYennyknkgk(tsnyouYennyknkgk);

        logger.debug("△ 通算用金額取得 通算用金額一括取得 終了");

        return getKhTuusanyouKngkBean;
    }

    public C_Tuukasyu getTsnyouTuukasyu(BM_SyouhnZokusei pSyouhnZokusei, IT_KykSyouhn pKykSyouhn) {

        logger.debug("▽ 通算用金額取得 通算用通貨種類取得 開始");

        if (pSyouhnZokusei == null) {
            tsnyouTuukasyu = C_Tuukasyu.JPY;
            tuukaType = BizCurrencyTypes.YEN;

            logger.debug("△ 通算用金額取得 通算用通貨種類取得 終了");

            return C_Tuukasyu.JPY;
        }
        else if (pKykSyouhn == null) {
            tsnyouTuukasyu = C_Tuukasyu.JPY;
            tuukaType = BizCurrencyTypes.YEN;

            logger.debug("△ 通算用金額取得 通算用通貨種類取得 終了");

            return C_Tuukasyu.JPY;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokusei.getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            tsnyouTuukasyu = C_Tuukasyu.JPY;
            tuukaType = BizCurrencyTypes.YEN;

            logger.debug("△ 通算用金額取得 通算用通貨種類取得 終了");

            return C_Tuukasyu.JPY;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        tuukaType = henkanTuuka.henkanTuukaKbnToType(pKykSyouhn.getKyktuukasyu());

        tsnyouTuukasyu = pKykSyouhn.getKyktuukasyu();

        logger.debug("△ 通算用金額取得 通算用通貨種類取得 終了");

        return pKykSyouhn.getKyktuukasyu();
    }

    public BizCurrency getTsnyouSibous(BM_SyouhnZokusei pSyouhnZokusei, IT_KykSyouhn pKykSyouhn) {

        logger.debug("▽ 通算用金額取得 通算用死亡Ｓ取得 開始");

        BizCurrency tsnyouSibous = BizCurrency.valueOf(0, tuukaType);

        if (pSyouhnZokusei == null) {

            logger.debug("△ 通算用金額取得 通算用死亡Ｓ取得 終了");

            return tsnyouSibous;
        }
        else if (pKykSyouhn == null) {

            logger.debug("△ 通算用金額取得 通算用死亡Ｓ取得 終了");

            return tsnyouSibous;
        }

        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getStsnumu())) {

            logger.debug("△ 通算用金額取得 通算用死亡Ｓ取得 終了");

            return pKykSyouhn.getKihons();
        }

        logger.debug("△ 通算用金額取得 通算用死亡Ｓ取得 終了");

        return tsnyouSibous;
    }

    public BizCurrency getTsnyouItijip(BM_SyouhnZokusei pSyouhnZokusei, IT_KykSyouhn pKykSyouhn) {

        logger.debug("▽ 通算用金額取得 通算用一時払Ｐ取得 開始");

        BizCurrency tsnyouItijip = BizCurrency.valueOf(0, tuukaType);

        if (pSyouhnZokusei == null) {

            logger.debug("△ 通算用金額取得 通算用一時払Ｐ取得 終了");

            return tsnyouItijip;
        }
        else if (pKykSyouhn == null) {

            logger.debug("△ 通算用金額取得 通算用一時払Ｐ取得 終了");

            return tsnyouItijip;
        }

        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getItijibrptsnumu())) {

            logger.debug("△ 通算用金額取得 通算用一時払Ｐ取得 終了");

            return pKykSyouhn.getHokenryou();
        }

        logger.debug("△ 通算用金額取得 通算用一時払Ｐ取得 終了");

        return tsnyouItijip;
    }

    public BizCurrency getTsnyouNkgns(BM_SyouhnZokusei pSyouhnZokusei, IT_KykSyouhn pKykSyouhn) {

        logger.debug("▽ 通算用金額取得 通算用年金原資取得 開始");

        BizCurrency tsnyouNkgns = BizCurrency.valueOf(0, tuukaType);

        if (pSyouhnZokusei == null) {

            logger.debug("△ 通算用金額取得 通算用年金原資取得 終了");

            return tsnyouNkgns;
        }
        else if (pKykSyouhn == null) {

            logger.debug("△ 通算用金額取得 通算用年金原資取得 終了");

            return tsnyouNkgns;
        }

        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getNkgnstuusanumu())) {

            int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokusei.getSyouhncd());

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR  ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                logger.debug("△ 通算用金額取得 通算用年金原資取得 終了");

                return pKykSyouhn.getKihons();
            }
            else if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                logger.debug("△ 通算用金額取得 通算用年金原資取得 終了");

                return pKykSyouhn.getPharaikomisougaku();
            }
        }

        logger.debug("△ 通算用金額取得 通算用年金原資取得 終了");

        return tsnyouNkgns;
    }

    public BizCurrency getTsnyouYennyknkgk(
        BM_SyouhnZokusei pSyouhnZokusei,
        IT_NyknJissekiRireki pNyknJissekiRireki,
        IT_KykSonotaTkyk pKykSonotaTkyk) {

        logger.debug("▽ 通算用金額取得 通算用円入金額取得 開始");

        BizCurrency tsnyouYennyknkgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (pSyouhnZokusei == null) {

            logger.debug("△ 通算用金額取得 通算用円入金額取得 終了");

            return tsnyouYennyknkgk;
        }
        else if (pNyknJissekiRireki == null) {

            logger.debug("△ 通算用金額取得 通算用円入金額取得 終了");

            return tsnyouYennyknkgk;
        }
        else if (pKykSonotaTkyk == null) {

            logger.debug("△ 通算用金額取得 通算用円入金額取得 終了");

            return tsnyouYennyknkgk;
        }

        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getYenhrkgktuusansiyouumu())
            && C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

            logger.debug("△ 通算用金額取得 通算用円入金額取得 終了");

            return pNyknJissekiRireki.getRsgaku();
        }

        logger.debug("△ 通算用金額取得 通算用円入金額取得 終了");

        return tsnyouYennyknkgk;
    }
}