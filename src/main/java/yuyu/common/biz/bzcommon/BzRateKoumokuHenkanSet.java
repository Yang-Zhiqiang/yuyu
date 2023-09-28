package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.suuri.srcommon.SrHokenSyuruiKigouSedaiConverter;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_RyourituKbn;
import yuyu.def.classification.C_Tuukasyu;

import com.google.common.base.Strings;

/**
 * 業務共通 共通 レート用項目変換設定
 */
public class BzRateKoumokuHenkanSet {

    private static final String PALKBNVAL0 = "0";

    private static final String PALKBNVAL1 = "1";

    private static final String PALKBNVAL2 = "2";

    private static final String PALKBNVAL3 = "3";

    private static final String PALKBNVAL4 = "4";

    private static final String PALKBNVAL5 = "5";

    private static final String PALKBNVAL00 = "00";

    private static final String PALKBNVAL01 = "01";

    private static final String PALKBNVAL02 = "02";

    @Inject
    private static Logger logger;

    public BzRateKoumokuHenkanSet() {
        super();
    }

    public BzRateKoumokuHenkanSetBean exec(String pSyouhncd, String pRyouritusdno, BizNumber pYoteiriritu, C_Hrkkaisuu pHrkkaisuu,
        C_Hhknsei pHhknsei, int pHhknnen, C_HknkknsmnKbn pHknkknsmnkbn, int pHknkkn, int pHrkkkn, C_Kykjyoutai pKykjyoutai,
        C_Tuukasyu pTuukasyu, int pDai1hknkkn, C_RyourituKbn pRyouritukbn, C_NaiteiKakuteiKbn pNaiteikakuteikbn) {

        logger.debug("▽ レート用項目変換設定 開始");

        BzRateKoumokuHenkanSetBean bzRateKoumokuHenkanSetBean = SWAKInjector.getInstance(BzRateKoumokuHenkanSetBean.class);
        SrHokenSyuruiKigouSedaiConverter srHokenSyuruiKigouSedaiConverter = SWAKInjector.getInstance(SrHokenSyuruiKigouSedaiConverter.class);

        if (pSyouhncd != null) {
            bzRateKoumokuHenkanSetBean.setHknsyukigou(pSyouhncd.substring(0, 2));
        }

        if (pRyouritusdno != null) {
            bzRateKoumokuHenkanSetBean.setHokensyuruikigousdicode(srHokenSyuruiKigouSedaiConverter.convert(pRyouritusdno.substring(0, 1)));
        }

        if (pYoteiriritu != null) {
            bzRateKoumokuHenkanSetBean.setYoteiriritu(Strings.padStart(String.valueOf(pYoteiriritu.multiply(10000)), 3, '0'));
        }

        if (C_Hrkkaisuu.ITIJI.eq(pHrkkaisuu)) {
            bzRateKoumokuHenkanSetBean.setHrkkaisuu(PALKBNVAL0);
        }

        if (C_Hrkkaisuu.HALFY.eq(pHrkkaisuu) ||
            C_Hrkkaisuu.NEN.eq(pHrkkaisuu) ||
            C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)) {
            bzRateKoumokuHenkanSetBean.setHrkkaisuu(PALKBNVAL3);
        }

        if (C_Hhknsei.MALE.eq(pHhknsei)) {
            bzRateKoumokuHenkanSetBean.setHhknsei(PALKBNVAL1);
        }

        if (C_Hhknsei.FEMALE.eq(pHhknsei)) {
            bzRateKoumokuHenkanSetBean.setHhknsei(PALKBNVAL2);
        }

        bzRateKoumokuHenkanSetBean.setKeiyakujihhknnen(Strings.padStart(String.valueOf(pHhknnen), 3, '0'));

        if (C_HknkknsmnKbn.SAIMANKI.eq(pHknkknsmnkbn)) {
            bzRateKoumokuHenkanSetBean.setSaimankikeiyakuhyouji(PALKBNVAL1);
        }

        if (C_HknkknsmnKbn.NENMANKI.eq(pHknkknsmnkbn)) {
            bzRateKoumokuHenkanSetBean.setSaimankikeiyakuhyouji(PALKBNVAL0);
        }

        bzRateKoumokuHenkanSetBean.setHknkkn(Strings.padStart(String.valueOf(pHknkkn), 2, '0'));

        bzRateKoumokuHenkanSetBean.setPharaikomikikan(Strings.padStart(String.valueOf(pHrkkkn), 2, '0'));

        if (C_Kykjyoutai.HRKMTYUU.eq(pKykjyoutai)) {
            bzRateKoumokuHenkanSetBean.setAnnaihuyouriyuukbn(PALKBNVAL00);
        }

        if (C_Kykjyoutai.HARAIMAN.eq(pKykjyoutai)) {
            bzRateKoumokuHenkanSetBean.setAnnaihuyouriyuukbn(PALKBNVAL02);
        }

        if (C_Kykjyoutai.ITIJIBARAI.eq(pKykjyoutai)) {
            bzRateKoumokuHenkanSetBean.setAnnaihuyouriyuukbn(PALKBNVAL01);
        }

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
            bzRateKoumokuHenkanSetBean.setTuukasyukbn(PALKBNVAL1);
        }

        if (C_Tuukasyu.USD.eq(pTuukasyu)) {
            bzRateKoumokuHenkanSetBean.setTuukasyukbn(PALKBNVAL2);
        }

        if (C_Tuukasyu.EUR.eq(pTuukasyu)) {
            bzRateKoumokuHenkanSetBean.setTuukasyukbn(PALKBNVAL3);
        }

        if (C_Tuukasyu.AUD.eq(pTuukasyu)) {
            bzRateKoumokuHenkanSetBean.setTuukasyukbn(PALKBNVAL4);
        }

        bzRateKoumokuHenkanSetBean.setDai1hknkkn(Strings.padStart(String.valueOf(pDai1hknkkn), 2, '0'));

        if (C_RyourituKbn.OTHER.eq(pRyouritukbn)) {
            bzRateKoumokuHenkanSetBean.setRyouritukbn(PALKBNVAL0);
        }

        if (C_RyourituKbn.DANTAI_A.eq(pRyouritukbn)) {
            bzRateKoumokuHenkanSetBean.setRyouritukbn(PALKBNVAL1);
        }

        if (C_RyourituKbn.DANTAI_B.eq(pRyouritukbn)) {
            bzRateKoumokuHenkanSetBean.setRyouritukbn(PALKBNVAL2);
        }

        if (C_RyourituKbn.KOUHURI.eq(pRyouritukbn)) {
            bzRateKoumokuHenkanSetBean.setRyouritukbn(PALKBNVAL3);
        }

        if (C_RyourituKbn.SYUUDAN.eq(pRyouritukbn)) {
            bzRateKoumokuHenkanSetBean.setRyouritukbn(PALKBNVAL4);
        }

        if (C_RyourituKbn.CREDIT.eq(pRyouritukbn)) {
            bzRateKoumokuHenkanSetBean.setRyouritukbn(PALKBNVAL5);
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(pNaiteikakuteikbn)) {
            bzRateKoumokuHenkanSetBean.setPaldratenaikakucode(PALKBNVAL0);
        }

        if (C_NaiteiKakuteiKbn.NAITEI.eq(pNaiteikakuteikbn)) {
            bzRateKoumokuHenkanSetBean.setPaldratenaikakucode(PALKBNVAL1);
        }

        logger.debug("△ レート用項目変換設定 終了");

        return bzRateKoumokuHenkanSetBean;
    }

}
