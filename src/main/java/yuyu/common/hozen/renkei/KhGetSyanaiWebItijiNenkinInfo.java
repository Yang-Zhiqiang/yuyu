package yuyu.common.hozen.renkei;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 サブシステム連携 社内Web用保全一時払年金情報取得<br />
 */
public class KhGetSyanaiWebItijiNenkinInfo extends KhGetSyanaiWebKyoutuuInfo {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private static Logger logger;

    public KhGetSyanaiWebItijiNenkinInfo() {
        super();
    }

    @Override
    protected void getSyouhnInfo() throws Exception{

        logger.debug("▽ 社内Web用保全一時払年金情報取得を開始します。");
        String syoNo = iwssnSyanaiHozenInfoOutputBean.getIwssnSyono();
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        BizNumber sisuuWariai = BizNumber.valueOf(0);
        BizNumber teirituWari = BizNumber.valueOf(0);

        if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

            teirituWari = BizNumber.valueOf(100);
        }

        else if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

            sisuuWariai = BizNumber.valueOf(100);
        }

        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnkshrstartymd(initDate(kykSyouhn.getHknkknmanryouymd()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinsyukbn(kykSyouhn.getNksyukbn().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinsyukj(initZenkaku(kykSyouhn.getNksyukbn().getContent()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinkkn(String.valueOf(kykSyouhn.getNenkinkkn()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnTumitateriritu(initNum100(kykSyouhn.getTumitateriritu()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnSisuuwari(String.valueOf(sisuuWariai));
        iwssnSyanaiHozenInfoOutputBean.setIwssnTeirituwari(String.valueOf(teirituWari));
        iwssnSyanaiHozenInfoOutputBean.setIwssnYennknhkyenhnkymd(initDate(kykSyouhn.getYendthnkymd()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpgaika(initCurrency(kykSyouhn.getHokenryou()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpgaikatuukasyu(initCurrencyType(kykSyouhn.getHokenryou()));

        int syouhinhanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());
        if (syouhinhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnSetteibairitu(String.valueOf(kykSyouhn.getSetteibairitu()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykjiTmttknzkrtjygn(initNum100(kykSyouhn.getTmttknzoukaritujygn()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnRendouritu(null);

        }
        else if (syouhinhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnSetteibairitu(null);
            iwssnSyanaiHozenInfoOutputBean.setIwssnKykjiTmttknzkrtjygn(null);
            iwssnSyanaiHozenInfoOutputBean.setIwssnRendouritu(initNum100(kykSyouhn.getRendouritu()));

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

        IT_KykUkt kykUkt = khozenCommonParam.getNenkinUketorinin(syoNo);

        if (kykUkt != null) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnNenkinuktkbn(kykUkt.getUktkbn().getValue());
            iwssnSyanaiHozenInfoOutputBean.setIwssnNenkinuktkj(initZenkaku(kykUkt.getUktkbn().getContent(C_UktKbn.PATTERN_NKUKT)));
        }
        else {

            setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR);
        }

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        iwssnSyanaiHozenInfoOutputBean.setIwssnPstigihrktkkbn(kykSonotaTkyk.getGaikanykntkhkumu().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkkbn(kykSonotaTkyk.getTargettkkbn().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkwra(String.valueOf(kykSonotaTkyk.getTargettkmokuhyouti()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkjnkg(initCurrency(kykSonotaTkyk.getTargettkykkijyungk()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhynsysnnktkjnkgtuksy(initCurrencyType(kykSonotaTkyk.getTargettkykkijyungk()));

        if (keisanCommonKaiyakuOutBean != null) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekin(initCurrency(keisanCommonKaiyakuOutBean.getPtumitatekin()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekintuukasyu(initCurrencyType(keisanCommonKaiyakuOutBean.getPtumitatekin()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgk(initCurrency(keisanCommonKaiyakuOutBean.getKaiyakuKjgk().multiply(-1)));
            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgktuukasyu(initCurrencyType(keisanCommonKaiyakuOutBean.getKaiyakuKjgk()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukoujyoritu(initNum100(keisanCommonKaiyakuOutBean.getKaiyakuKjRitu()));

        }
        logger.debug("△ 社内Web用保全一時払年金情報取得を終了します｡");
    }

    @Override
    protected void initSub() {
        iwssnSyanaiHozenInfoOutputBean.setIwssnNenkinuktkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnNenkinuktkj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnkshrstartymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinsyukbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinsyukj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnPstigihrktkkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkwra(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinkkn(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTumitateriritu(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSetteibairitu(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykjiTmttknzkrtjygn(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSisuuwari(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnTeirituwari(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpgaika(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpyen(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhyouyensysnnktkjnkg(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekin(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnYennknhkyenhnkymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpgaikatuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpnykntuuka(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpnykntuukatuksy(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSykaipnyknratesyutkymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnMkhynsysnnktkjnkgtuksy(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgk(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukjgktuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKaiyakukoujyoritu(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnPtumitatekintuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKykjisjkkktusirrt(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyokaijikkktusirrt(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnItijibrpyentuukasyu(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyokaipnyknrate(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnRendouritu(NUMSYOKITI);
    }
}
