package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 配当 配当共通計算（死亡）
 */
public class KeisanDCommonSibou extends KeisanDCommon {

    private BizCurrency dShrkn;

    @Inject
    private static Logger logger;

    private NrkKmkSibouNaibuBean nrkKmkSibouNaibuBean;

    public C_ErrorKbn calcDShrgk(String pSyono, BizDate pCalckijyunymd, BizDate pSyoriYmd) {

        logger.debug("▽ 配当共通計算（死亡） 配当支払金計算 開始");

        clear();
        dShrkn = null;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        BizCurrency kariwariatedGanrikin = BizCurrency.valueOf(0);

        setNrkKmk(pSyono, pCalckijyunymd, pSyoriYmd);

        if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null || pSyoriYmd == null) {

            errorKbn = C_ErrorKbn.ERROR;

            setErrorInfo(ERRORCODE001);

            logger.debug("△ 配当共通計算（死亡） 配当支払金計算 終了");

            return errorKbn;
        }

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);

        BizDateY drateNendo = setKessanNensibi.exec(pCalckijyunymd).getBizDateY();
        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, drateNendo, C_UmuKbn.NONE);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            setErrorLink(naiteiKakuteiRateHantei);

            logger.debug("△ 配当共通計算（死亡） 配当支払金計算 終了");

            return errorKbn;
        }

        C_NaiteiKakuteiKbn naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        errorKbn = calcKariwariateDGanrikin(pSyono, pCalckijyunymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 配当共通計算（死亡） 配当支払金計算 終了");

            return errorKbn;
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
            if (getKhHaitouKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhHaitouKanriNaiteiKakuteiKbn())) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE003);

                logger.debug("△ 配当共通計算（死亡） 配当支払金計算 終了");

                return errorKbn;
            }
        }

        if (getKhHaitouKanriNaiteiKakuteiKbn() != null &&
            !C_NaiteiKakuteiKbn.NAITEI.eq(getKhHaitouKanriNaiteiKakuteiKbn()) &&
            getKariwariateDGanrikin().compareTo(BizCurrency.valueOf(0, getKariwariateDGanrikin().getType())) >= 0) {

            kariwariatedGanrikin = getKariwariateDGanrikin();
        }

        errorKbn = calcTumitateDGanrikin(pSyono, pCalckijyunymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 配当共通計算（死亡） 配当支払金計算 終了");

            return errorKbn;
        }

        if (C_NaiteiKakuteiKbn.KAKUTEI.eq(naiteiKakuteiKbn)) {
            if (getKhTumitateDKanriNaiteiKakuteiKbn() != null && C_NaiteiKakuteiKbn.NAITEI.eq(getKhTumitateDKanriNaiteiKakuteiKbn())) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE003);

                logger.debug("△ 配当共通計算（死亡） 配当支払金計算 終了");

                return errorKbn;
            }
        }

        dShrkn = kariwariatedGanrikin.add(getTumitateDGanrikin());

        logger.debug("△ 配当共通計算（死亡） 配当支払金計算 終了");

        return errorKbn;
    }

    public BizCurrency getDShrkn() {

        return dShrkn;
    }

    public NrkKmkSibouNaibuBean getNrkKmkSibouNaibuBean() {

        return nrkKmkSibouNaibuBean;
    }

    private void setNrkKmk(String pSyono, BizDate pCalckijyunYmd, BizDate pSyoriYmd) {

        nrkKmkSibouNaibuBean = new NrkKmkSibouNaibuBean();

        nrkKmkSibouNaibuBean.setSyono(pSyono);
        nrkKmkSibouNaibuBean.setCalckijyunymd(pCalckijyunYmd);
        nrkKmkSibouNaibuBean.setSyoriymd(pSyoriYmd);
    }

    @Override
    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {

        if (nrkKmkSibouNaibuBean == null) {

            return null;
        }

        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = super.getEditDshrTukiDKoumokuBean();

        editDshrTukiDKoumokuBean.setCalckijyunYmd(nrkKmkSibouNaibuBean.getCalckijyunymd());
        editDshrTukiDKoumokuBean.setSyoriYmd2(nrkKmkSibouNaibuBean.getSyoriymd());
        editDshrTukiDKoumokuBean.setHaitoushrKin(dShrkn);

        return editDshrTukiDKoumokuBean;
    }

    class NrkKmkSibouNaibuBean {

        @Getter@Setter
        private String syono;

        @Getter@Setter
        private BizDate calckijyunymd;

        @Getter@Setter
        private BizDate syoriymd;

        public NrkKmkSibouNaibuBean() {
        }
    }
}
