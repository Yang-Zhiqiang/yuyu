package yuyu.batch.suuri.srsuuritoukei.srrisanomituujyouhaitousyoyougaku;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.suuri.srcommon.SrCommonConstants;

/**
 * 利差のみ通常配当所要額情報作成パラメータクラス
 */
@BatchScoped
public class SrRisanomiTuujyouHaitousyoyougakuBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGHJM000 = "RGHJM000";

    public static final String RGHJM001 = "RGHJM001";

    public static final String RGHJM002 = "RGHJM002";

    public static final String RGHJM003 = "RGHJM003";

    public static final String RGHJM004 = "RGHJM004";

    public static final String RGHJM005 = "RGHJM005";

    public static final String RGHJM006 = "RGHJM006";

    private BizDate kijyunymd;

    private BizDateYM keijyouym;

    private BizDateY tounendo;

    private String haitousyoyougakukeisancd;

    private BizDateY dratenendo;

    private BizDateY keisanDnendo;

    private BizDate keisanDnendoZenjiJigyouLastDay;

    private BizDate keisanDnendoJigyouLastDay;

    private int syorikensuuNplusZero;

    private int syorikensuuNminusZero;

    private int syorikensuuNplusQuart;

    private int syorikensuuHtkinSikinIdouWk;

    private int zokkouerrsyorikensuu;

    private String heisoukbn;

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
        this.keijyouym = pKeijyouym;
    }

    public BizDateY getTounendo() {
        return tounendo;
    }

    public void setTounendo(BizDateY pTounendo) {
        this.tounendo = pTounendo;
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

    public BizDate getKeisanDnendoZenjiJigyouLastDay() {
        return keisanDnendoZenjiJigyouLastDay;
    }

    public void setKeisanDnendoZenjiJigyouLastDay(BizDate pKeisanDnendoZenjiJigyouLastDay) {
        this.keisanDnendoZenjiJigyouLastDay = pKeisanDnendoZenjiJigyouLastDay;
    }

    public BizDate getKeisanDnendoJigyouLastDay() {
        return keisanDnendoJigyouLastDay;
    }

    public void setKeisanDnendoJigyouLastDay(BizDate pKeisanDnendoJigyouLastDay) {
        this.keisanDnendoJigyouLastDay = pKeisanDnendoJigyouLastDay;
    }

    public int getSyorikensuuNplusZero() {
        return syorikensuuNplusZero;
    }

    public void setSyorikensuuNplusZero(int pSyorikensuuNplusZero) {
        this.syorikensuuNplusZero = pSyorikensuuNplusZero;
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

    public int getSyorikensuuHtkinSikinIdouWk() {
        return syorikensuuHtkinSikinIdouWk;
    }

    public void setSyorikensuuHtkinSikinIdouWk(int pSyorikensuuHtkinSikinIdouWk) {
        this.syorikensuuHtkinSikinIdouWk = pSyorikensuuHtkinSikinIdouWk;
    }

    public int getZokkouerrsyorikensuu() {
        return zokkouerrsyorikensuu;
    }

    public void setZokkouerrsyorikensuu(int pZokkouerrsyorikensuu) {
        this.zokkouerrsyorikensuu = pZokkouerrsyorikensuu;
    }

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        this.heisoukbn = pHeisoukbn;
    }

    public SrRisanomiTuujyouHaitousyoyougakuBatchParam() {

    }

    public void setParam() {

        String wkHaitousyoyougakukeisancd = "";

        if (RGHJM000.equals(super.getIbKakutyoujobcd())
            || RGHJM001.equals(super.getIbKakutyoujobcd())
            || RGHJM004.equals(super.getIbKakutyoujobcd())) {

            wkHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO;
        }
        else if (RGHJM002.equals(super.getIbKakutyoujobcd())
            || RGHJM005.equals(super.getIbKakutyoujobcd())) {

            wkHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART;
        }
        else {

            wkHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO;
        }
        BizDateYM wkKeijyouym = kijyunymd.getBizDateYM();

        BizDateY wkTounendo = null;

        if (SrCommonConstants.MONTH_APRIL <= wkKeijyouym.getMonth()) {
            wkTounendo = wkKeijyouym.getBizDateY();
        }
        else {
            wkTounendo = wkKeijyouym.getBizDateY().addYears(-1);
        }

        BizDateY wkDratenendo = null;

        BizDateY wkKeisanDnendo = null;

        if (SrCommonConstants.MONTH_MARCH == wkKeijyouym.getMonth()) {

            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY();

                wkKeisanDnendo = wkKeijyouym.getBizDateY();
            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY().addYears(-1);

                wkKeisanDnendo = wkKeijyouym.getBizDateY();
            }
        }
        else if (SrCommonConstants.MONTH_JANUARY == wkKeijyouym.getMonth()) {
            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY().addYears(-1);

                wkKeisanDnendo = wkKeijyouym.getBizDateY();
            }
        }
        else {
            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY();

                wkKeisanDnendo = wkKeijyouym.getBizDateY().addYears(+1);

            }
            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(wkHaitousyoyougakukeisancd)) {
                wkDratenendo = wkKeijyouym.getBizDateY();

                wkKeisanDnendo = wkKeijyouym.getBizDateY();
            }
        }
        BizDate wkKeisanDnendoLastDay = BizDate.valueOf(String.valueOf(wkKeisanDnendo)
            + SrCommonConstants.FIXEDDAY_NENDOKSNBI);

        BizDate wkKeisanDnendoJigyouLastDay = BizDate.valueOf(String.valueOf(wkKeisanDnendo.addYears(1))
            + SrCommonConstants.FIXEDDAY_NENDOKSNBI);

        setKeijyouym(wkKeijyouym);

        setTounendo(wkTounendo);

        setHaitousyoyougakukeisancd(wkHaitousyoyougakukeisancd);

        setDratenendo(wkDratenendo);

        setKeisanDnendo(wkKeisanDnendo);

        setKeisanDnendoZenjiJigyouLastDay(wkKeisanDnendoLastDay);

        setKeisanDnendoJigyouLastDay(wkKeisanDnendoJigyouLastDay);
    }
}
