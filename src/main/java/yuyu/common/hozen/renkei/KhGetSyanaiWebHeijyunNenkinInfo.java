package yuyu.common.hozen.renkei;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 サブシステム連携 社内Web用保全平準払年金情報取得<br />
 */
public class KhGetSyanaiWebHeijyunNenkinInfo extends KhGetSyanaiWebKyoutuuInfo {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private static Logger logger;

    public KhGetSyanaiWebHeijyunNenkinInfo() {
        super();
    }

    @Override
    protected void getSyouhnInfo() throws Exception{

        logger.debug("▽ 社内Web用保全平準払年金情報取得を開始します。");

        String syoNo = iwssnSyanaiHozenInfoOutputBean.getIwssnSyono();
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        BizDate sysDate = BizDate.getSysDate();

        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnkshrstartymd(initDate(kykSyouhn.getHknkknmanryouymd()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinsyukbn(kykSyouhn.getNksyukbn().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinsyukj(initZenkaku(kykSyouhn.getNksyukbn().getContent()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnHrkkkn(String.valueOf(kykSyouhn.getHrkkkn()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinkkn(String.valueOf(kykSyouhn.getNenkinkkn()));
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhrkkknsmnkbn(kykSyouhn.getHrkkknsmnkbn().getValue());
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhrkkknsmnkbnnm(initZenkaku(kykSyouhn.getHrkkknsmnkbn().getContent()));

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        iwssnSyanaiHozenInfoOutputBean.setIwssnKjnnkpzeitekitkhukakbn(kykSonotaTkyk.getZeiseitkkktkykhukaumu().getValue());

        IT_KykUkt kykUkt = khozenCommonParam.getNenkinUketorinin(syoNo);

        if (kykUkt != null) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnNenkinuktkbn(kykUkt.getUktkbn().getValue());
            iwssnSyanaiHozenInfoOutputBean.setIwssnNenkinuktkj(initZenkaku(kykUkt.getUktkbn().getContent(C_UktKbn.PATTERN_NKUKT)));
        }
        else {

            setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR);
        }

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

        getYoteirirituBean.setSyouhncd(kykSyouhn.getSyouhncd());
        getYoteirirituBean.setKijyunymd(sysDate);
        getYoteirirituBean.setSknnkaisiymd(kykSyouhn.getSknnkaisiymd());
        getYoteirirituBean.setKykymd(kykSyouhn.getKykymd());
        getYoteirirituBean.setHknkkn(kykSyouhn.getHknkkn());
        getYoteirirituBean.setHknkknsmnkbn(kykSyouhn.getHknkknsmnkbn());
        getYoteirirituBean.setHhknnen(kykSyouhn.getHhknnen());
        getYoteirirituBean.setSitihsyuriritu(kykSyouhn.getYoteirrthendohosyurrt());

        C_ErrorKbn kekkaKbn = getYoteiriritu.exec(getYoteirirituBean);

        if (C_ErrorKbn.OK.eq(kekkaKbn)) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnYoteiriritu(initNum100(getYoteiriritu.getYoteiriritu()));
        }
        else {

            setKekkaKbn(C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR);
        }

        if (keisanCommonKaiyakuOutBean != null) {

            iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankin(initCurrency(keisanCommonKaiyakuOutBean.getZennouseisankYen()));
            iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankintuukasy(initCurrencyType(keisanCommonKaiyakuOutBean.getZennouseisankYen()));

        }

        logger.debug("△ 社内Web用保全平準払年金情報取得を終了します｡");
    }

    @Override
    protected void initSub() {
        iwssnSyanaiHozenInfoOutputBean.setIwssnNenkinuktkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnNenkinuktkj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnkshrstartymd(YMDSYOKITI_8);
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinsyukbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinsyukj(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnKjnnkpzeitekitkhukakbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnHrkkkn(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnNksyouhnnenkinkkn(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnYoteiriritu(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankin(NUMSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhrkkknsmnkbn(HANKAKUEIKANOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnSyuhrkkknsmnkbnnm(NIHONGOSYOKITI);
        iwssnSyanaiHozenInfoOutputBean.setIwssnZennouseisankintuukasy(HANKAKUEIKANOSYOKITI);
    }
}
