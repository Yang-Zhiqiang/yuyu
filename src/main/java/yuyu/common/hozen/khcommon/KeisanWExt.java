package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.dba4keisanwext.KeisanWExtDao;
import yuyu.common.hozen.khcommon.dba4keisanwext.KeisanWKykInfoBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;

/**
 * 契約保全 共通 解約返戻金計算拡張情報作成クラス
 */
public class KeisanWExt {

    private KeisanWExtBean keisanWExtBean;

    @Inject
    private static Logger logger;

    @Inject
    private KeisanWExtDao keisanWExtDao;

    @Inject
    private HozenDomManager hozenDomManager;

    public KeisanWExt() {
        super();
    }

    public C_ErrorKbn exec(String pSyono, BizDate pCalcKijyunYmd) {

        logger.debug("▽ 解約返戻金計算拡張情報作成 開始");

        keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        BizNumber sjkkkTyouseiyouRiritu = BizNumber.valueOf(0);


        KeisanWKykInfoBean keisanWKykInfoBean = keisanWExtDao.getKeisanWKykInfoBean(pSyono);

        if (keisanWKykInfoBean == null) {

            logger.debug("△ 解約返戻金計算拡張情報作成 終了");
            return C_ErrorKbn.ERROR;
        }

        if (C_UmuKbn.ARI.eq(keisanWKykInfoBean.getMvaTekiumu())) {

            GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
            getSjkkktyouseiyourirituBean.setSyouhncd(keisanWKykInfoBean.getSyouhnCd());
            getSjkkktyouseiyourirituBean.setKijyunymd(pCalcKijyunYmd);
            getSjkkktyouseiyourirituBean.setHknkkn(keisanWKykInfoBean.getHknKkn());

            GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

            C_ErrorKbn sjkkkTsyRirituKekkaKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

            sjkkkTyouseiyouRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();

            if (!C_ErrorKbn.OK.eq(sjkkkTsyRirituKekkaKbn)) {

                logger.debug("△ 解約返戻金計算拡張情報作成 終了");
                return C_ErrorKbn.ERROR;
            }
        }

        SisurendoTmttknInfoBean sisurendoTmttknInfoBean =
            hozenDomManager.getSisurendoTmttknInfoBean(pSyono, pCalcKijyunYmd);

        IT_HokenryouTmttkn hokenryouTmttkn =
            hozenDomManager.getHokenryouTmttknBySyonoTmttkntaisyouym(pSyono, pCalcKijyunYmd.getBizDateYM());

        keisanWExtBean.setSyouhncd(keisanWKykInfoBean.getSyouhnCd());
        keisanWExtBean.setSyouhnsdno(keisanWKykInfoBean.getSyouhnSdNo());
        keisanWExtBean.setRyouritusdno(String.valueOf(keisanWKykInfoBean.getRyourituSdNo()));
        keisanWExtBean.setYoteiriritu(keisanWKykInfoBean.getYoteiRiritu());
        keisanWExtBean.setHrkkaisuu(keisanWKykInfoBean.getHrkKaisuu());
        keisanWExtBean.setFstpryosyuymd(keisanWKykInfoBean.getFstPNyknYmd());
        keisanWExtBean.setHknkknsmnkbn(keisanWKykInfoBean.getHknkknsmnkbn());
        keisanWExtBean.setHrkkknsmnkbn(keisanWKykInfoBean.getHrkkknsmnkbn());
        keisanWExtBean.setHrkkkn(keisanWKykInfoBean.getHrkKkn());
        keisanWExtBean.setHknkkn(keisanWKykInfoBean.getHknKkn());
        keisanWExtBean.setHhknnen(keisanWKykInfoBean.getHhkNnen());
        keisanWExtBean.setHhknsei(keisanWKykInfoBean.getHhknSei());
        keisanWExtBean.setKihons(keisanWKykInfoBean.getKihonS());
        keisanWExtBean.setHokenryou(keisanWKykInfoBean.getHokenRyou());
        keisanWExtBean.setKykymd(keisanWKykInfoBean.getKykYmd());
        keisanWExtBean.setTuukasyu(keisanWKykInfoBean.getKykTuukasyu());
        keisanWExtBean.setKyksjkkktyouseiriritu(keisanWKykInfoBean.getKyksjkKkTyouseiRiritu());
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(sjkkkTyouseiyouRiritu);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(keisanWKykInfoBean.getKykTuukasyu());

        if (sisurendoTmttknInfoBean != null) {
            keisanWExtBean.setTmttkntaisyouym(sisurendoTmttknInfoBean.getTmttknTaisyouYM());
            keisanWExtBean.setTeiritutmttkngk(sisurendoTmttknInfoBean.getTeirituTmttknGK());
            keisanWExtBean.setSisuurendoutmttkngk(sisurendoTmttknInfoBean.getSisuuRendouTmttknGK());
            keisanWExtBean.setTmttknhaneisisuu(sisurendoTmttknInfoBean.getTmttknhaneisisuu());
            keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0, currencyType));
            keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0, currencyType));
        }
        else if (hokenryouTmttkn != null) {
            keisanWExtBean.setTmttkntaisyouym(hokenryouTmttkn.getTmttkntaisyouym());
            keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(0, currencyType));
            keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(0, currencyType));
            keisanWExtBean.setTmttknhaneisisuu(null);
            keisanWExtBean.setPtmttkngk(hokenryouTmttkn.getPtmttkngk());
            keisanWExtBean.setKihrkmpstgk(hokenryouTmttkn.getKihrkmpstgk());
        }
        else {
            keisanWExtBean.setTmttkntaisyouym(null);
            keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(0, currencyType));
            keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(0, currencyType));
            keisanWExtBean.setTmttknhaneisisuu(null);
            keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0, currencyType));
            keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0, currencyType));
        }
        keisanWExtBean.setTumitateriritu(keisanWKykInfoBean.getTumitateRiritu());
        keisanWExtBean.setJkipjytym(keisanWKykInfoBean.getJkipjytYm());
        keisanWExtBean.setYoteirrthendohosyurrt(keisanWKykInfoBean.getYoteirrtHendoHosyuRrt());
        keisanWExtBean.setYendthnkymd(keisanWKykInfoBean.getYendthnkYmd());
        keisanWExtBean.setTeikishrtkykhukaumu(keisanWKykInfoBean.getTeikishrtkykhukaumu());
        keisanWExtBean.setDai1hknkkn(keisanWKykInfoBean.getDai1hknkkn());
        keisanWExtBean.setKykJyoutai(keisanWKykInfoBean.getKykjyoutai());

        logger.debug("△ 解約返戻金計算拡張情報作成 終了");

        return C_ErrorKbn.OK;
    }

    public KeisanWExtBean getKeisanWExtBean() {
        return keisanWExtBean;
    }
}
