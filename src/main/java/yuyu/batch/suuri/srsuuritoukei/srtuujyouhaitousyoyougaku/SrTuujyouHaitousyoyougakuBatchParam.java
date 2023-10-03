package yuyu.batch.suuri.srsuuritoukei.srtuujyouhaitousyoyougaku;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.suuri.srcommon.SrCommonConstants;

/**
 * （数理）通常配当所要額情報作成バッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 */
@BatchScoped
public class SrTuujyouHaitousyoyougakuBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGHIM000 = "RGHIM000";

    public static final String RGHIM001 = "RGHIM001";

    public static final String RGHIM002 = "RGHIM002";

    public static final String RGHIM003 = "RGHIM003";

    public static final String RGHIM004 = "RGHIM004";

    public static final String RGHIM005 = "RGHIM005";

    public static final String RGHIM006 = "RGHIM006";

    public static final String RGHIM008 = "RGHIM008";

    public static final String RGHIM009 = "RGHIM009";

    public static final String RGHIM010 = "RGHIM010";

    public static final String RGHIM011 = "RGHIM011";

    public static final String RGHIM012 = "RGHIM012";

    private BizDate kijyunymd;

    private BizDateYM keijyouym;

    private String haitousyoyougakukeisancd;

    private BizDateY dratenendo;

    private BizDateY keisanDnendo;

    private BizDate keisanDnendoLastDay;

    private int syorikensuuNplusZero;

    private int syorikensuuNplusOne;

    private int syorikensuuNplusTwo;

    private int syorikensuuNminusZero;

    private int syorikensuuNplusQuart;

    private int errorSyorikensuu;

    private String heisoukbn;

    public SrTuujyouHaitousyoyougakuBatchParam() {
    }

    public void setParam() {

        String wkHaitousyoyougakukeisancd = "";

        if (RGHIM000.equals(super.getIbKakutyoujobcd())
            || RGHIM003.equals(super.getIbKakutyoujobcd())
            || RGHIM008.equals(super.getIbKakutyoujobcd())) {

            wkHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO;
        }
        else if (RGHIM001.equals(super.getIbKakutyoujobcd())
            || RGHIM004.equals(super.getIbKakutyoujobcd())
            || RGHIM009.equals(super.getIbKakutyoujobcd())) {

            wkHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE;

        }
        else if (RGHIM002.equals(super.getIbKakutyoujobcd())
            || RGHIM005.equals(super.getIbKakutyoujobcd())
            || RGHIM010.equals(super.getIbKakutyoujobcd())) {

            wkHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO;
        }
        else if (RGHIM006.equals(super.getIbKakutyoujobcd())
            || RGHIM011.equals(super.getIbKakutyoujobcd())) {

            wkHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO;
        }
        else {

            wkHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART;
        }

        BizDateYM wkKeijyouym = getKijyunymd().getBizDateYM();

        BizDateY wkDratenendo = null;

        BizDateY wkKeisanDnendo = null;

        if (SrCommonConstants.MONTH_MARCH == getKijyunymd().getMonth()) {

            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY();

                wkKeisanDnendo = wkKeijyouym.getBizDateY();

            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY();

                wkKeisanDnendo = wkKeijyouym.getBizDateY().addYears(+1);
            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY();

                wkKeisanDnendo = wkKeijyouym.getBizDateY().addYears(+2);
            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY().addYears(-1);

                wkKeisanDnendo = wkKeijyouym.getBizDateY();
            }
        }
        else if (SrCommonConstants.MONTH_JANUARY == getKijyunymd().getMonth()) {
            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY().addYears(-1);

                wkKeisanDnendo = wkKeijyouym.getBizDateY();

            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY().addYears(-1);

                wkKeisanDnendo = wkKeijyouym.getBizDateY().addYears(+1);
            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY().addYears(-1);

                wkKeisanDnendo = wkKeijyouym.getBizDateY().addYears(+2);
            }
        }
        else {
            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY();

                wkKeisanDnendo = wkKeijyouym.getBizDateY().addYears(+1);

            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY();

                wkKeisanDnendo = wkKeijyouym.getBizDateY().addYears(+2);
            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY();

                wkKeisanDnendo = wkKeijyouym.getBizDateY().addYears(+3);
            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY();

                wkKeisanDnendo = wkKeijyouym.getBizDateY();
            }
        }

        BizDate wkKeisanDnendoLastDay = BizDate.valueOf(String.valueOf(wkKeisanDnendo) +
            SrCommonConstants.FIXEDDAY_NENDOKSNBI);

        setKeijyouym(wkKeijyouym);

        setHaitousyoyougakukeisancd(wkHaitousyoyougakukeisancd);

        setDratenendo(wkDratenendo);

        setKeisanDnendo(wkKeisanDnendo);

        setKeisanDnendoLastDay(wkKeisanDnendoLastDay);

    }

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        this.kijyunymd = pKijyunymd;
    }

    public BizDateYM getKeijyouym() {
        return keijyouym;
    }

    public void setKeijyouym(BizDateYM pKeijyouym) {
        keijyouym = pKeijyouym;
    }

    public String getHaitousyoyougakukeisancd() {
        return haitousyoyougakukeisancd;
    }

    public void setHaitousyoyougakukeisancd(String pHaitousyoyougakukeisancd) {
        this.haitousyoyougakukeisancd = pHaitousyoyougakukeisancd;
    }

    public BizDateY getDratenendo() {
        return dratenendo;
    }

    public void setDratenendo(BizDateY pDratenendo) {
        this.dratenendo = pDratenendo;
    }

    public BizDateY getKeisanDnendo() {
        return keisanDnendo;
    }

    public void setKeisanDnendo(BizDateY pKeisanDnendo) {
        this.keisanDnendo = pKeisanDnendo;
    }

    public BizDate getKeisanDnendoLastDay() {
        return keisanDnendoLastDay;
    }

    public void setKeisanDnendoLastDay(BizDate pKeisanDnendoLastDay) {
        this.keisanDnendoLastDay = pKeisanDnendoLastDay;
    }

    public int getSyorikensuuNplusZero() {
        return syorikensuuNplusZero;
    }

    public void setSyorikensuuNplusZero(int pSyorikensuuNplusZero) {
        this.syorikensuuNplusZero = pSyorikensuuNplusZero;
    }

    public int getSyorikensuuNplusOne() {
        return syorikensuuNplusOne;
    }

    public void setSyorikensuuNplusOne(int pSyorikensuuNplusOne) {
        this.syorikensuuNplusOne = pSyorikensuuNplusOne;
    }

    public int getSyorikensuuNplusTwo() {
        return syorikensuuNplusTwo;
    }

    public void setSyorikensuuNplusTwo(int pSyorikensuuNplusTwo) {
        this.syorikensuuNplusTwo = pSyorikensuuNplusTwo;
    }

    public int getSyorikensuuNminusZero() {
        return syorikensuuNminusZero;
    }

    public void setSyorikensuuNminusZero(int pSyorikensuuNminusZero) {
        this.syorikensuuNminusZero = pSyorikensuuNminusZero;
    }

    public int getSyorikensuuNplusQuart() {
        return syorikensuuNplusQuart;
    }

    public void setSyorikensuuNplusQuart(int pSyorikensuuNplusQuart) {
        this.syorikensuuNplusQuart = pSyorikensuuNplusQuart;
    }

    public int getErrorSyorikensuu() {
        return errorSyorikensuu;
    }

    public void setErrorSyorikensuu(int pErrorSyorikensuu) {
        this.errorSyorikensuu = pErrorSyorikensuu;
    }

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        this.heisoukbn = pHeisoukbn;
    }
}
