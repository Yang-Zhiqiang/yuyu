package yuyu.common.hozen.haitou;

import java.math.RoundingMode;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.BizDateUtil;
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
 * 契約保全 配当 配当共通計算（解約）
 */
public class KeisanDCommonKaiyaku extends KeisanDCommon {

    public static final BizNumber KAIYAKUSIHARAIWARIAI = BizNumber.valueOf(0.75);

    @Inject
    private static Logger logger;

    private BizCurrency dShrkn;

    private BizCurrency kariwariateDGanrikinForDShrkn;

    private NrkKmkKaiyakuNaibuBean nrkKmkKaiyakuNaibuBean;

    public C_ErrorKbn calcDShrgk(String pSyono, BizDate pCalckijyunymd, BizDate pSyoriYmd, BizDateYM pJkipjytym) {

        logger.debug("▽ 配当共通計算（解約） 配当支払金計算 開始");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        setNrkKmk(pSyono, pCalckijyunymd, pSyoriYmd, pJkipjytym);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

            C_ErrorKbn errorKbn = calcDShrgkForItijibarai(pSyono, pCalckijyunymd, pSyoriYmd);

            logger.debug("△ 配当共通計算（解約） 配当支払金計算 終了");

            return errorKbn;
        }

        C_ErrorKbn errorKbn = calcDShrgkForHeijyunbarai(pSyono, pCalckijyunymd, pSyoriYmd, pJkipjytym);

        logger.debug("△ 配当共通計算（解約） 配当支払金計算 終了");

        return errorKbn;

    }

    private C_ErrorKbn calcDShrgkForItijibarai(String pSyono, BizDate pCalckijyunymd, BizDate pSyoriYmd) {

        logger.debug("▽ 配当共通計算（解約） 配当支払金計算（一時払用） 開始");

        clear();
        dShrkn = null;
        kariwariateDGanrikinForDShrkn = null;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        BizCurrency kariwariatedGanrikin = BizCurrency.valueOf(0);

        if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null || pSyoriYmd == null) {

            errorKbn = C_ErrorKbn.ERROR;

            setErrorInfo(ERRORCODE001);

            logger.debug("△ 配当共通計算（解約） 配当支払金計算（一時払用） 終了");

            return errorKbn;
        }

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);

        BizDateY drateNendo = setKessanNensibi.exec(pCalckijyunymd).getBizDateY();
        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, drateNendo, C_UmuKbn.NONE);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            setErrorLink(naiteiKakuteiRateHantei);

            logger.debug("△ 配当共通計算（解約） 配当支払金計算（一時払用） 終了");

            return errorKbn;
        }

        C_NaiteiKakuteiKbn naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if (BizDateUtil.compareYmd(kykSyouhn.getKykymd().addYears(2).getRekijyou(),
            pCalckijyunymd) != BizDateUtil.COMPARE_GREATER) {

            errorKbn = calcKariwariateDGanrikin(pSyono, pCalckijyunymd);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                logger.debug("△ 配当共通計算（解約） 配当支払金計算（一時払用） 終了");

                return errorKbn;
            }

            if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
                if (getKhHaitouKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhHaitouKanriNaiteiKakuteiKbn())) {

                    errorKbn = C_ErrorKbn.ERROR;

                    setErrorInfo(ERRORCODE003);

                    logger.debug("△ 配当共通計算（解約） 配当支払金計算（一時払用） 終了");

                    return errorKbn;
                }
            }

            if (getKhHaitouKanriNaiteiKakuteiKbn() != null &&
                !C_NaiteiKakuteiKbn.NAITEI.eq(getKhHaitouKanriNaiteiKakuteiKbn()) &&
                getKariwariateDGanrikin().compareTo(BizCurrency.valueOf(0, getKariwariateDGanrikin().getType())) >= 0) {

                kariwariatedGanrikin = getKariwariateDGanrikin();
            }
        }

        errorKbn = calcTumitateDGanrikin(pSyono, pCalckijyunymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 配当共通計算（解約） 配当支払金計算（一時払用） 終了");

            return errorKbn;
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
            if (getKhTumitateDKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhTumitateDKanriNaiteiKakuteiKbn())) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE003);

                logger.debug("△ 配当共通計算（解約） 配当支払金計算（一時払用） 終了");

                return errorKbn;
            }
        }

        kariwariateDGanrikinForDShrkn = kariwariatedGanrikin.multiply(KAIYAKUSIHARAIWARIAI, 0, RoundingMode.DOWN);

        dShrkn = kariwariateDGanrikinForDShrkn.add(getTumitateDGanrikin());

        logger.debug("△ 配当共通計算（解約） 配当支払金計算（一時払用） 終了");

        return errorKbn;
    }

    private C_ErrorKbn calcDShrgkForHeijyunbarai(String pSyono, BizDate pCalckijyunymd, BizDate pSyoriYmd, BizDateYM pJkipjytym) {

        logger.debug("▽ 配当共通計算（解約） 配当支払金計算（平準払用） 開始");

        clear();
        dShrkn = null;
        kariwariateDGanrikinForDShrkn = null;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        BizCurrency kariwariatedGanrikin = BizCurrency.valueOf(0);

        if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null || pSyoriYmd == null || pJkipjytym == null) {

            errorKbn = C_ErrorKbn.ERROR;

            setErrorInfo(ERRORCODE001);

            logger.debug("△ 配当共通計算（解約） 配当支払金計算（平準払用） 終了");

            return errorKbn;
        }

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        BizDateY drateNendo = setKessanNensibi.exec(pCalckijyunymd).getBizDateY();
        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, drateNendo, C_UmuKbn.NONE);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            setErrorLink(naiteiKakuteiRateHantei);

            logger.debug("△ 配当共通計算（解約） 配当支払金計算（平準払用） 終了");

            return errorKbn;
        }

        C_NaiteiKakuteiKbn naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        BizDate tyouseizCalckijyunYmd = getCoordinatedCalcYmd(kykSyouhn.getKykymd(), pCalckijyunymd, pJkipjytym);

        if (BizDateUtil.compareYmd(kykSyouhn.getKykymd().addYears(2).getRekijyou(),
            tyouseizCalckijyunYmd) != BizDateUtil.COMPARE_GREATER) {

            errorKbn = calcKariwariateDGanrikin(pSyono, pCalckijyunymd, tyouseizCalckijyunYmd);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                logger.debug("△ 配当共通計算（解約） 配当支払金計算（平準払用） 終了");

                return errorKbn;
            }

            if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
                if (getKhHaitouKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhHaitouKanriNaiteiKakuteiKbn())) {

                    errorKbn = C_ErrorKbn.ERROR;

                    setErrorInfo(ERRORCODE003);

                    logger.debug("△ 配当共通計算（解約） 配当支払金計算（平準払用） 終了");

                    return errorKbn;
                }
            }

            if (getKhHaitouKanriNaiteiKakuteiKbn() != null &&
                !C_NaiteiKakuteiKbn.NAITEI.eq(getKhHaitouKanriNaiteiKakuteiKbn()) &&
                getKariwariateDGanrikin().compareTo(BizCurrency.valueOf(0, getKariwariateDGanrikin().getType())) >= 0) {

                kariwariatedGanrikin = getKariwariateDGanrikin();
            }
        }

        errorKbn = calcTumitateDGanrikin(pSyono, pCalckijyunymd, tyouseizCalckijyunYmd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 配当共通計算（解約） 配当支払金計算（平準払用） 終了");

            return errorKbn;
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
            if (getKhTumitateDKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhTumitateDKanriNaiteiKakuteiKbn())) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE003);

                logger.debug("△ 配当共通計算（解約） 配当支払金計算（平準払用） 終了");

                return errorKbn;
            }
        }

        kariwariateDGanrikinForDShrkn = kariwariatedGanrikin.multiply(KAIYAKUSIHARAIWARIAI, 0, RoundingMode.DOWN);

        dShrkn = kariwariateDGanrikinForDShrkn.add(getTumitateDGanrikin());

        logger.debug("△ 配当共通計算（解約） 配当支払金計算（平準払用） 終了");

        return errorKbn;
    }

    public BizCurrency getDShrkn() {

        return dShrkn;
    }

    public BizCurrency getKariwariateDGanrikinForDShrkn() {

        return kariwariateDGanrikinForDShrkn;
    }

    public NrkKmkKaiyakuNaibuBean getNrkKmkKaiyakuNaibuBean() {

        return nrkKmkKaiyakuNaibuBean;
    }

    private void setNrkKmk(String pSyono, BizDate pCalckijyunYmd, BizDate pSyoriYmd, BizDateYM pJkipjytYm) {

        nrkKmkKaiyakuNaibuBean = new NrkKmkKaiyakuNaibuBean();

        nrkKmkKaiyakuNaibuBean.setSyono(pSyono);
        nrkKmkKaiyakuNaibuBean.setCalckijyunymd(pCalckijyunYmd);
        nrkKmkKaiyakuNaibuBean.setSyoriymd(pSyoriYmd);
        nrkKmkKaiyakuNaibuBean.setJkipjytym(pJkipjytYm);
    }

    @Override
    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {

        if (nrkKmkKaiyakuNaibuBean == null) {

            return null;
        }

        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = super.getEditDshrTukiDKoumokuBean();

        editDshrTukiDKoumokuBean.setCalckijyunYmd(nrkKmkKaiyakuNaibuBean.getCalckijyunymd());
        editDshrTukiDKoumokuBean.setSyoriYmd2(nrkKmkKaiyakuNaibuBean.getSyoriymd());
        editDshrTukiDKoumokuBean.setJkipjytYm(nrkKmkKaiyakuNaibuBean.getJkipjytym());
        editDshrTukiDKoumokuBean.setHaitoushrKin(dShrkn);
        editDshrTukiDKoumokuBean.setKariwariatedganrikinDshr(kariwariateDGanrikinForDShrkn);

        return editDshrTukiDKoumokuBean;
    }

    class NrkKmkKaiyakuNaibuBean {

        @Getter@Setter
        private String syono;

        @Getter@Setter
        private BizDate calckijyunymd;

        @Getter@Setter
        private BizDate syoriymd;

        @Getter@Setter
        private BizDateYM jkipjytym;

        public NrkKmkKaiyakuNaibuBean() {
        }
    }
}
