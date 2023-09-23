package yuyu.common.hozen.renkei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_HknkknBunruiKbn;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 サブシステム連携 社内Web用保全一時払終身情報取得<br />
 */
public class KhGetSyanaiWebItijiSyuusinInfo extends KhGetSyanaiWebKyoutuuInfo {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private static Logger logger;

    public KhGetSyanaiWebItijiSyuusinInfo() {
        super();
    }

    @Override
    protected void getSyouhnInfo() throws Exception {

        logger.debug("▽ 社内Web用保全一時払終身情報取得を開始します。");

        String syoNo = iwssnSyanaiHozenInfoOutputBean.getIwssnSyono();
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        iwssnSyanaiHozenInfoOutputBean.setIwssnYensysnhkyenhnkymd(initDate(kykSyouhn.getYendthnkymd()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpgaika(initCurrency(kykSyouhn.getHokenryou()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpgaikatuukasyu(initCurrencyType(kykSyouhn.getHokenryou()));

        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(kykSyouhn.getKykymd());
        hanteiHokenKikanBean.setCalcKijyunYmd(kykSyouhn.getKykymd());
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);
        hanteiHokenKikanBean.setDai1hknkkn(kykSyouhn.getDai1hknkkn());

        hanteiHokenKikan.exec(hanteiHokenKikanBean);

        C_HknkknBunruiKbn hknkknBunruiKbn = syouhnZokusei.getHknkknbunruikbn();

        if (!C_HknkknBunruiKbn.NONE.eq(hknkknBunruiKbn)) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn1from(initDate((kykSyouhn.getKykymd())));
            iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn1to(initDate(hanteiHokenKikan.getDai2HknkknStartYmd().addDays(-1)));
            iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn2from(initDate(hanteiHokenKikan.getDai2HknkknStartYmd()));

            if (C_HknkknBunruiKbn.SECOND.eq(hknkknBunruiKbn)) {

                iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn2to(null);
                iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn3(null);

            }

            if (C_HknkknBunruiKbn.THIRD.eq(hknkknBunruiKbn)) {

                iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn2to(initDate(hanteiHokenKikan.getDai3HknkknStartYmd().addDays(-1)));
                iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn3(initDate(hanteiHokenKikan.getDai3HknkknStartYmd()));

            }
        }

        int syouhinhanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());
        if (syouhinhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnYoteiriritu(initNum100(kykSyouhn.getYoteiriritu()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnTumitateriritu(null);
            iwssnSyanaiHozenInfoOutputBean.setIwssn10nentumitateriritu(null);

        }
        else if (syouhinhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnYoteiriritu(null);
            iwssnSyanaiHozenInfoOutputBean.setIwssnTumitateriritu(initNum100(kykSyouhn.getTumitateriritu()));
            iwssnSyanaiHozenInfoOutputBean.setIwssn10nentumitateriritu(initNum100(kykSyouhn.getLoadinghnkgtumitateriritu()));

        }

        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = khozenCommonParam.getNyknJissekiRirekiSk(syoNo);
        if (nyknJissekiRirekiList != null) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpnykntuuka(initCurrency(nyknJissekiRirekiList.get(0).getRsgaku()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpnykntuukatuksy(initCurrencyType(nyknJissekiRirekiList.get(0).getRsgaku()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnSyokaipnyknrate(initNum(nyknJissekiRirekiList.get(0).getRyosyukwsrate()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnSykaipnyknratesyutkymd(initDate(nyknJissekiRirekiList.get(0).getRyosyukwsratekjymd()));

        }
        else {

            setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR);
        }

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        C_UmuKbn initsbjiyensitihsyKbn = kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu();

        if (C_UmuKbn.ARI.eq(initsbjiyensitihsyKbn)) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnInitsbjyensitihsykjnkg(initCurrency(kykSonotaTkyk.getInitsbjiyenkasaiteihsygk()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnInitsbjyensykjnkgtksy(initCurrencyType(kykSonotaTkyk.getInitsbjiyenkasaiteihsygk()));

        }

        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkkbn(kykSonotaTkyk.getTargettkkbn().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkwra(String.valueOf(kykSonotaTkyk.getTargettkmokuhyouti()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkjnkg(initCurrency(kykSonotaTkyk.getTargettkykkijyungk()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhynsysnnktkjnkgtuksy(initCurrencyType(kykSonotaTkyk.getTargettkykkijyungk()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnInitsbjiyensitihsykbn(initsbjiyensitihsyKbn.getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnPstigihrktkkbn(kykSonotaTkyk.getGaikanykntkhkumu().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnJyudkaigomeharaitkkbn(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu().getValue());

        if (keisanCommonKaiyakuOutBean != null) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekin(initCurrency(keisanCommonKaiyakuOutBean.getPtumitatekin()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekintuukasyu(initCurrencyType(keisanCommonKaiyakuOutBean.getPtumitatekin()));

            if (syouhinhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
                iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgk(null);
                iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgktuukasyu(null);
                iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukoujyoritu(null);

            }
            else {
                iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgk(initCurrency(keisanCommonKaiyakuOutBean.getKaiyakuKjgk().multiply(-1)));
                iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgktuukasyu(initCurrencyType(keisanCommonKaiyakuOutBean.getKaiyakuKjgk()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukoujyoritu(initNum100(keisanCommonKaiyakuOutBean.getKaiyakuKjRitu()));
            }
        }
        logger.debug("△ 社内Web用保全一時払終身情報取得を終了します｡");

    }

    @Override
    protected void initSub() {
        iwssnSyanaiHozenInfoOutputBean.setIwssnPstigihrktkkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkwra(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnInitsbjiyensitihsykbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn1from(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn1to(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn2from(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn2to(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn3(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnYoteiriritu(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpgaika(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpyen(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkjnkg(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnInitsbjyensitihsykjnkg(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnJyudkaigomeharaitkkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekin(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnYensysnhkyenhnkymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpgaikatuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpnykntuuka(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpnykntuukatuksy(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSykaipnyknratesyutkymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgk(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgktuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukoujyoritu(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekintuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhynsysnnktkjnkgtuksy(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnInitsbjyensykjnkgtksy(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTumitateriritu(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssn10nentumitateriritu(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykjisjkkktusirrt(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyokaijikkktusirrt(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpyentuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyokaipnyknrate(NUMSYOKITI);
    }
}
