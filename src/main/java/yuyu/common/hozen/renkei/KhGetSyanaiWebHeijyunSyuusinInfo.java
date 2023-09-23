package yuyu.common.hozen.renkei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 サブシステム連携 社内Web用保全平準払終身情報取得<br />
 */
public class KhGetSyanaiWebHeijyunSyuusinInfo extends KhGetSyanaiWebKyoutuuInfo {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private static Logger logger;

    public KhGetSyanaiWebHeijyunSyuusinInfo() {
        super();
    }

    @Override
    protected void getSyouhnInfo() throws Exception{

        logger.debug("▽ 社内Web用保全平準払終身情報取得を開始します。");

        String syoNo = iwssnSyanaiHozenInfoOutputBean.getIwssnSyono();
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        iwssnSyanaiHozenInfoOutputBean.setIwssnHrkkkn(String.valueOf(kykSyouhn.getHrkkkn()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhrkkknsmnkbn(kykSyouhn.getHrkkknsmnkbn().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhrkkknsmnkbnnm(initZenkaku(kykSyouhn.getHrkkknsmnkbn().getContent()));

        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(kykSyouhn.getKykymd());
        hanteiHokenKikanBean.setCalcKijyunYmd(kykSyouhn.getKykymd());
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);
        hanteiHokenKikanBean.setDai1hknkkn(kykSyouhn.getDai1hknkkn());

        hanteiHokenKikan.exec(hanteiHokenKikanBean);

        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn1from(initDate((kykSyouhn.getKykymd())));
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn1to(initDate(hanteiHokenKikan.getDai2HknkknStartYmd().addDays(-1)));
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn2from(initDate(hanteiHokenKikan.getDai2HknkknStartYmd()));

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

        getYoteirirituBean.setSyouhncd(kykSyouhn.getSyouhncd());
        getYoteirirituBean.setKykymd(kykSyouhn.getKykymd());
        getYoteirirituBean.setTuukasyu(kykSyouhn.getKyktuukasyu());

        C_ErrorKbn kekkaKbn = getYoteiriritu.exec(getYoteirirituBean);

        if (C_ErrorKbn.OK.eq(kekkaKbn)) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnYoteiriritu(initNum100(getYoteiriritu.getYoteiriritu()));
        }
        else {

            setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR);
        }

        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = khozenCommonParam.getNyknJissekiRirekiSk(syoNo);

        if (nyknJissekiRirekiList != null) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnSyokaipnyknrate(initNum(nyknJissekiRirekiList.get(0).getRyosyukwsrate()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnSykaipnyknratesyutkymd(initDate(nyknJissekiRirekiList.get(0).getRyosyukwsratekjymd()));

        }
        else {

            setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR);
        }

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        iwssnSyanaiHozenInfoOutputBean.setIwssnJyudkaigomeharaitkkbn(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu().getValue());

        if (keisanCommonKaiyakuOutBean != null) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekin(initCurrency(keisanCommonKaiyakuOutBean.getPtumitatekin()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekintuukasyu(initCurrencyType(keisanCommonKaiyakuOutBean.getPtumitatekin()));

            if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankin(initCurrency(keisanCommonKaiyakuOutBean.getZennouseisankGk()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankintuukasy(initCurrencyType(keisanCommonKaiyakuOutBean.getZennouseisankGk()));
            }
            else {

                iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankin(initCurrency(keisanCommonKaiyakuOutBean.getZennouseisankYen()));
                iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankintuukasy(initCurrencyType(keisanCommonKaiyakuOutBean.getZennouseisankYen()));
            }
        }

        logger.debug("△ 社内Web用保全平準払終身情報取得を終了します｡");
    }

    @Override
    protected void initSub() {
        iwssnSyanaiHozenInfoOutputBean.setIwssnHrkkkn(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhrkkknsmnkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhrkkknsmnkbnnm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn1from(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn1to(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHknkkn2from(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnYoteiriritu(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyokaipnyknrate(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSykaipnyknratesyutkymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnJyudkaigomeharaitkkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekin(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekintuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankin(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankintuukasy(HANKAKUEIKANOSYOKITI);
    }
}
