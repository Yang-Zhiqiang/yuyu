package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import lombok.Getter;
import lombok.Setter;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 配当 配当共通計算（配当金支払）
 */
public class KeisanDCommonDShr extends KeisanDCommon {

    private static final String ERRORCODE002 = "002";

    @Inject
    private static Logger logger;

    private BizCurrency wrmdsMaeTumitated;

    private BizCurrency wrmdsAtoTumitated;

    private BizCurrency shrgk;

    private NrkKmkDshrNaibuBean nrkKmkDshrNaibuBean;

    {
        regErrorInfo(ERRORCODE002, "入力値エラー", "一部引出金額＞積立Ｄ元利金");
    }

    public C_ErrorKbn calcDShrgkAllhikidasi(String pSyono, BizDate pCalckijyunYmd, BizDate pSyoriYmd, BizDateYM pJkipjytYm) {

        logger.debug("▽ 配当共通計算（配当金支払） 配当支払金計算（全額引出）  開始");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        setNrkKmk(pSyono, pCalckijyunYmd, pSyoriYmd, null, pJkipjytYm);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

            C_ErrorKbn errorKbn = calcDShrgkAllhikidasiForItijibarai(pSyono, pCalckijyunYmd, pSyoriYmd);

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出）  終了");

            return errorKbn;
        }

        C_ErrorKbn errorKbn = calcDShrgkAllhikidasiForHeijyunbarai(pSyono, pCalckijyunYmd, pSyoriYmd, pJkipjytYm,
            kykSyouhn.getKykymd());

        logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出）  終了");

        return errorKbn;

    }

    public C_ErrorKbn calcDShrgkItibuhikidasi(String pSyono, BizDate pCalckijyunYmd, BizDate pSyoriYmd,
        BizCurrency pItibuhikidasikg, BizDateYM pJkipjytYm) {

        logger.debug("▽ 配当共通計算（配当金支払） 配当支払金計算（一部引出）  開始");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        setNrkKmk(pSyono, pCalckijyunYmd, pSyoriYmd, pItibuhikidasikg, pJkipjytYm);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

            C_ErrorKbn errorKbn = calcDShrgkItibuhikidasiForItijibarai(pSyono, pCalckijyunYmd, pSyoriYmd, pItibuhikidasikg);

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出）  終了");

            return errorKbn;
        }

        C_ErrorKbn errorKbn = calcDShrgkItibuhikidasiForHeijyunbarai(pSyono,
            pCalckijyunYmd, pSyoriYmd, pItibuhikidasikg, pJkipjytYm, kykSyouhn.getKykymd());

        logger.debug("△ 配当共通計算（配当金支払）配当支払金計算（一部引出）  終了");

        return errorKbn;

    }

    private C_ErrorKbn calcDShrgkAllhikidasiForItijibarai(String pSyono, BizDate pCalckijyunymd, BizDate pSyoriYmd) {

        logger.debug("▽ 配当共通計算（配当金支払） 配当支払金計算（全額引出_一時払商品） 開始");

        init();
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null || pSyoriYmd == null) {

            errorKbn = C_ErrorKbn.ERROR;

            setErrorInfo(ERRORCODE001);

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出_一時払商品） 終了");

            return errorKbn;
        }

        errorKbn = calcTumitateDGanrikin(pSyono, pCalckijyunymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出_一時払商品） 終了");

            return errorKbn;
        }

        C_NaiteiKakuteiKbn naiteiKakuteiKbn = getNaiteiKakuteiKbn(pCalckijyunymd, pSyoriYmd);

        if (naiteiKakuteiKbn == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出_一時払商品） 終了");

            return errorKbn;
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
            if (getKhTumitateDKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhTumitateDKanriNaiteiKakuteiKbn())) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE003);

                logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出_一時払商品） 終了");

                return errorKbn;
            }
        }

        wrmdsMaeTumitated = BizCurrency.valueOf(0);

        wrmdsAtoTumitated = BizCurrency.valueOf(0);

        shrgk = getTumitateDGanrikin();

        logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出_一時払商品） 終了");

        return errorKbn;
    }

    private C_ErrorKbn calcDShrgkAllhikidasiForHeijyunbarai(String pSyono,
        BizDate pCalckijyunYmd, BizDate pSyoriYmd, BizDateYM pJkipjytYm, BizDate pKykYmd) {

        logger.debug("▽ 配当共通計算（配当金支払） 配当支払金計算（全額引出_平準払用） 開始");

        init();
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (BizUtil.isBlank(pSyono) || pCalckijyunYmd == null || pSyoriYmd == null || pJkipjytYm == null || pKykYmd == null) {

            errorKbn = C_ErrorKbn.ERROR;

            setErrorInfo(ERRORCODE001);

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出_平準払用） 終了");

            return errorKbn;
        }

        BizDate tyouseizCalckijyunYmd = getCoordinatedCalcYmd(pKykYmd, pCalckijyunYmd, pJkipjytYm);

        errorKbn = calcTumitateDGanrikin(pSyono, pCalckijyunYmd, tyouseizCalckijyunYmd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出_平準払用） 終了");

            return errorKbn;
        }

        C_NaiteiKakuteiKbn naiteiKakuteiKbn = getNaiteiKakuteiKbn(pCalckijyunYmd, pSyoriYmd);

        if (naiteiKakuteiKbn == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出_平準払用） 終了");

            return errorKbn;
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
            if (getKhTumitateDKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhTumitateDKanriNaiteiKakuteiKbn())) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE003);

                logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出_平準払用） 終了");

                return errorKbn;
            }
        }

        wrmdsMaeTumitated = BizCurrency.valueOf(0);

        wrmdsAtoTumitated = BizCurrency.valueOf(0);

        shrgk = getTumitateDGanrikin();

        logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（全額引出_平準払用） 終了");

        return errorKbn;
    }

    private C_ErrorKbn calcDShrgkItibuhikidasiForItijibarai(String pSyono, BizDate pCalckijyunymd, BizDate pSyoriYmd,
        BizCurrency pItibuhikidasikg) {

        logger.debug("▽ 配当共通計算（配当金支払） 配当支払金計算（一部引出_一時払用） 開始");

        init();
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null || pSyoriYmd == null ||
            pItibuhikidasikg == null ||pItibuhikidasikg.isOptional()) {

            errorKbn = C_ErrorKbn.ERROR;

            setErrorInfo(ERRORCODE001);

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_一時払用） 終了");

            return errorKbn;
        }

        errorKbn = calcTumitateDGanrikin(pSyono, pCalckijyunymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_一時払用） 終了");

            return errorKbn;
        }

        C_NaiteiKakuteiKbn naiteiKakuteiKbn = getNaiteiKakuteiKbn(pCalckijyunymd, pSyoriYmd);

        if (naiteiKakuteiKbn == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_一時払用） 終了");

            return errorKbn;
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
            if (getKhTumitateDKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhTumitateDKanriNaiteiKakuteiKbn())) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE003);

                logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_一時払用） 終了");

                return errorKbn;
            }
        }

        if (getTumitateDGanrikin().compareTo(pItibuhikidasikg) < 0) {

            errorKbn = C_ErrorKbn.ERROR;

            setErrorInfo(ERRORCODE002);

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_一時払用） 終了");

            return errorKbn;
        }

        wrmdsMaeTumitated = getTumitateDGanrikin().subtract(pItibuhikidasikg);

        wrmdsAtoTumitated = calcWrmdsKngk(wrmdsMaeTumitated, getTumitateDRirituList());

        shrgk = pItibuhikidasikg;

        logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_一時払用） 終了");

        return errorKbn;
    }

    private C_ErrorKbn calcDShrgkItibuhikidasiForHeijyunbarai(String pSyono, BizDate pCalckijyunYmd, BizDate pSyoriYmd,
        BizCurrency pItibuhikidasikg, BizDateYM pJkipjytYm, BizDate pKykYmd) {

        logger.debug("▽ 配当共通計算（配当金支払） 配当支払金計算（一部引出_平準払商品） 開始");

        init();
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (BizUtil.isBlank(pSyono) || pCalckijyunYmd == null || pSyoriYmd == null ||
            pItibuhikidasikg == null ||pItibuhikidasikg.isOptional() || pJkipjytYm == null || pKykYmd == null) {

            errorKbn = C_ErrorKbn.ERROR;

            setErrorInfo(ERRORCODE001);

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_平準払商品） 終了");

            return errorKbn;
        }

        BizDate tyouseizCalckijyunYmd = getCoordinatedCalcYmd(pKykYmd, pCalckijyunYmd, pJkipjytYm);

        errorKbn = calcTumitateDGanrikin(pSyono, pCalckijyunYmd, tyouseizCalckijyunYmd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_平準払商品） 終了");

            return errorKbn;
        }

        C_NaiteiKakuteiKbn naiteiKakuteiKbn = getNaiteiKakuteiKbn(pCalckijyunYmd, pSyoriYmd);

        if (naiteiKakuteiKbn == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_平準払商品） 終了");

            return errorKbn;
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
            if (getKhTumitateDKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhTumitateDKanriNaiteiKakuteiKbn())) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE003);

                logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_平準払商品） 終了");

                return errorKbn;
            }
        }

        if (getTumitateDGanrikin().compareTo(pItibuhikidasikg) < 0) {

            errorKbn = C_ErrorKbn.ERROR;

            setErrorInfo(ERRORCODE002);

            logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_平準払商品） 終了");

            return errorKbn;
        }

        wrmdsMaeTumitated = getTumitateDGanrikin().subtract(pItibuhikidasikg);

        wrmdsAtoTumitated = calcWrmdsKngk(wrmdsMaeTumitated, getTumitateDRirituList());

        shrgk = pItibuhikidasikg;

        logger.debug("△ 配当共通計算（配当金支払） 配当支払金計算（一部引出_平準払商品） 終了");

        return errorKbn;
    }

    public BizCurrency getWrmdsMaeTumitated() {

        return wrmdsMaeTumitated;
    }

    public BizCurrency getWrmdsAtoTumitated() {

        return wrmdsAtoTumitated;
    }

    public BizCurrency getShrgk() {

        return shrgk;
    }

    private C_NaiteiKakuteiKbn getNaiteiKakuteiKbn(BizDate pCalckijyunymd, BizDate pSyoriYmd) {

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);

        BizDateY drateNendo = setKessanNensibi.exec(pCalckijyunymd).getBizDateY();
        C_ErrorKbn errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, drateNendo, C_UmuKbn.NONE);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            setErrorLink(naiteiKakuteiRateHantei);

            return null;
        }

        C_NaiteiKakuteiKbn naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        return naiteiKakuteiKbn;
    }

    private void init() {

        clear();
        wrmdsMaeTumitated = null;
        wrmdsAtoTumitated = null;
        shrgk = null;
    }

    public NrkKmkDshrNaibuBean getNrkKmkDShrNaibuBean() {

        return nrkKmkDshrNaibuBean;
    }

    private void setNrkKmk(String pSyono, BizDate pCalckijyunYmd, BizDate pSyoriYmd,
        BizCurrency pItibuhikidasikg, BizDateYM pJkipjytYm) {

        nrkKmkDshrNaibuBean = new NrkKmkDshrNaibuBean();

        nrkKmkDshrNaibuBean.setSyono(pSyono);
        nrkKmkDshrNaibuBean.setCalckijyunymd(pCalckijyunYmd);
        nrkKmkDshrNaibuBean.setSyoriymd(pSyoriYmd);
        nrkKmkDshrNaibuBean.setItibuhikidasikg(pItibuhikidasikg);
        nrkKmkDshrNaibuBean.setJkipjytym(pJkipjytYm);
    }

    @Override
    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {

        if (nrkKmkDshrNaibuBean == null) {

            return null;
        }

        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = super.getEditDshrTukiDKoumokuBean();

        editDshrTukiDKoumokuBean.setCalckijyunYmd(nrkKmkDshrNaibuBean.getCalckijyunymd());
        editDshrTukiDKoumokuBean.setSyoriYmd2(nrkKmkDshrNaibuBean.getSyoriymd());
        editDshrTukiDKoumokuBean.setJkipjytYm(nrkKmkDshrNaibuBean.getJkipjytym());
        editDshrTukiDKoumokuBean.setItibushrGk(nrkKmkDshrNaibuBean.getItibuhikidasikg());
        editDshrTukiDKoumokuBean.setHaitoushrkinGk(shrgk);
        editDshrTukiDKoumokuBean.setTumitatedModosimae(wrmdsMaeTumitated);
        editDshrTukiDKoumokuBean.setTumitatedModosigo(wrmdsAtoTumitated);

        return editDshrTukiDKoumokuBean;
    }

    class NrkKmkDshrNaibuBean {

        @Getter@Setter
        private String syono;

        @Getter@Setter
        private BizDate calckijyunymd;

        @Getter@Setter
        private BizDate syoriymd;

        @Getter@Setter
        private BizCurrency itibuhikidasikg;

        @Getter@Setter
        private BizDateYM jkipjytym;

        public NrkKmkDshrNaibuBean() {
        }
    }
}
