package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.hozen.khcommon.dba4keisanikkatupgk.KeisanIkkatuPGkDao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 契約保全 契約保全共通 一括払Ｐ計算
 */
public class KeisanIkkatuPGk {

    private BizCurrency ikkatuP;

    private BizCurrency iktwaribikikgk;

    @Inject
    private static Logger logger;

    @Inject
    private KeisanIkkatuPGkDao keisanIkkatuPGkDao;

    public KeisanIkkatuPGk() {
        super();
    }

    public BizCurrency getIkkatuP() {
        return ikkatuP;
    }

    public BizCurrency getIktwaribikikgk() {
        return iktwaribikikgk;
    }

    public C_ErrorKbn exec(KeisanIkkatuPGkBean pKeisanIkkatuPGkBean, boolean pIktwaribikifuyouFlg) {

        logger.debug("▽ 一括払Ｐ計算 開始");

        CurrencyType hokenryouCurrencyType = pKeisanIkkatuPGkBean.getHokenryou().getType();

        ikkatuP = BizCurrency.valueOf(0, hokenryouCurrencyType);

        iktwaribikikgk = BizCurrency.valueOf(0, hokenryouCurrencyType);

        C_ErrorKbn kekkakbn = C_ErrorKbn.OK;

        if (!(pKeisanIkkatuPGkBean.getKeikamon() > 0 && pKeisanIkkatuPGkBean.getKeikamon() < 13)) {

            logger.info("一括払Ｐ計算エラー。経過月数指定範囲外");

            kekkakbn = C_ErrorKbn.ERROR;

            return kekkakbn;
        }
        C_YouhiKbn youhiKbn = checkIkkatuWaribiki(pIktwaribikifuyouFlg, pKeisanIkkatuPGkBean.getTkiktbrisyuruiKbn(),
            pKeisanIkkatuPGkBean.getSyouhnCd(), pKeisanIkkatuPGkBean.getSyouhnsdNo(), pKeisanIkkatuPGkBean.getHrkkaisuu());

        if (C_YouhiKbn.HUYOU.eq(youhiKbn)) {

            ikkatuP = pKeisanIkkatuPGkBean.getHokenryou().multiply(pKeisanIkkatuPGkBean.getKeikamon());
            iktwaribikikgk = BizCurrency.valueOf(0, hokenryouCurrencyType);

            kekkakbn = C_ErrorKbn.OK;

            return kekkakbn;

        }

        BizCurrency ksntkbrihokenryou = BizCurrency.valueOf(0, hokenryouCurrencyType);
        if (C_Hrkkaisuu.TUKI.eq(pKeisanIkkatuPGkBean.getHrkkaisuu())) {

            ksntkbrihokenryou = pKeisanIkkatuPGkBean.getHokenryou();
        }
        else if (C_Hrkkaisuu.HALFY.eq(pKeisanIkkatuPGkBean.getHrkkaisuu()) ||
            C_Hrkkaisuu.NEN.eq(pKeisanIkkatuPGkBean.getHrkkaisuu())) {

            KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);
            keisanSP.exec(pKeisanIkkatuPGkBean.getSyouhnCd(),
                pKeisanIkkatuPGkBean.getRyouritusdNo(),
                pKeisanIkkatuPGkBean.getYoteiRiritu(),
                C_Hrkkaisuu.TUKI,
                pKeisanIkkatuPGkBean.getHhknnen(),
                pKeisanIkkatuPGkBean.getHhknsei(),
                pKeisanIkkatuPGkBean.getHknkknsmnKbn(),
                pKeisanIkkatuPGkBean.getHknkkn(),
                pKeisanIkkatuPGkBean.getHrkkkn(),
                C_Sdpd.SD,
                pKeisanIkkatuPGkBean.getHokenkngk(),
                BizCurrency.valueOf(0, hokenryouCurrencyType),
                pKeisanIkkatuPGkBean.getKykTuukasyu(),
                pKeisanIkkatuPGkBean.getKykjyoutai(),
                pKeisanIkkatuPGkBean.getDai1hknkkn(),
                pKeisanIkkatuPGkBean.getHrkkeiro());

            ksntkbrihokenryou = keisanSP.getP();
        }
        else {

            logger.info("一括払Ｐ計算エラー。払込回数に" + pKeisanIkkatuPGkBean.getHrkkaisuu().getContent() + "が指定されています。");

            kekkakbn = C_ErrorKbn.ERROR;

            return kekkakbn;
        }

        KeisanIkkatuWaribikiP keisanIkkatuWaribikikiP = SWAKInjector.getInstance(KeisanIkkatuWaribikiP.class);

        C_ErrorKbn keisanResult = keisanIkkatuWaribikikiP.exec(
            pKeisanIkkatuPGkBean.getSyouhnCd(),
            pKeisanIkkatuPGkBean.getRyouritusdNo(),
            pKeisanIkkatuPGkBean.getYoteiRiritu(),
            pKeisanIkkatuPGkBean.getKeikamon(),
            ksntkbrihokenryou);

        if (C_ErrorKbn.ERROR.eq(keisanResult)) {

            kekkakbn = C_ErrorKbn.ERROR;

            return kekkakbn;
        }

        BizCurrency waribikiHokenryou = keisanIkkatuWaribikikiP.getP();

        BizCurrency waribikikGk = keisanIkkatuWaribikikiP.getIktwaribikikgk();

        BizCurrency hrkp = ksntkbrihokenryou.multiply(pKeisanIkkatuPGkBean.getKeikamon());

        if (waribikiHokenryou.compareTo(hrkp) > 0) {
            waribikiHokenryou = hrkp;
            waribikikGk = BizCurrency.valueOf(0, hokenryouCurrencyType);
        }
        ikkatuP = waribikiHokenryou;
        iktwaribikikgk = waribikikGk;

        kekkakbn = C_ErrorKbn.OK;

        logger.debug("△ 一括払Ｐ計算 終了");

        return kekkakbn;
    }

    private C_YouhiKbn checkIkkatuWaribiki(boolean pIktwaribikifuyouFlg, C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn,
        String pSyouhncd, int pSyouhnsdNo, C_Hrkkaisuu pHrkkaisuu) {

        C_YouhiKbn youhiKbn;

        if (pIktwaribikifuyouFlg) {

            youhiKbn = C_YouhiKbn.HUYOU;

            return youhiKbn;
        }

        if (C_Hrkkaisuu.NEN.eq(pHrkkaisuu) || C_Hrkkaisuu.HALFY.eq(pHrkkaisuu)) {

            youhiKbn = C_YouhiKbn.YOU;

            return youhiKbn;
        }

        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pTkiktbrisyuruiKbn) ||
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pTkiktbrisyuruiKbn)) {

            youhiKbn = C_YouhiKbn.YOU;

            return youhiKbn;
        }

        Long ikthensyouhinCount = keisanIkkatuPGkDao.getSyouhnZokuseiCountByIkkatuUmu(pSyouhncd, pSyouhnsdNo);

        if (ikthensyouhinCount != 0) {

            youhiKbn = C_YouhiKbn.YOU;
        }
        else {

            youhiKbn = C_YouhiKbn.HUYOU;
        }
        return youhiKbn;
    }

}
