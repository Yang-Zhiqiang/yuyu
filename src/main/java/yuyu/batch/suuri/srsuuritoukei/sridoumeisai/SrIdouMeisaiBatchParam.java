package yuyu.batch.suuri.srsuuritoukei.sridoumeisai;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.suuri.srcommon.SrCommonConstants;

/**
 * 異動明細情報作成バッチパラメータクラス
 */
@BatchScoped
public class SrIdouMeisaiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGHBM000 = "RGHBM000";

    public static final String RGHBM004 = "RGHBM004";

    public static final String KIJYUNYMD = "20190430";

    public static final String TYSYTSTARTYMD = "20190331";

    private BizDate kijyunymd;

    private int shiKensubangou;

    private int errorSyoriKensuu;

    private int keiyakuMFkoushinCTRrenban;

    private BizDate zenkaidensimeymd;

    private BizDate konkaidensimeymd;

    private BizDate jigyounendoKsnbiymd;

    private BizDate hoseiZenZenkaidensimeymd;

    private int warningSyoriKensuu;

    public SrIdouMeisaiBatchParam() {

        setShiKensubangou(0);
        setErrorSyoriKensuu(0);
    }

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

    public int getShiKensubangou() {
        return shiKensubangou;
    }

    public void setShiKensubangou(int pShiKensubangou) {
        shiKensubangou = pShiKensubangou;
    }

    public int getErrorSyoriKensuu() {
        return errorSyoriKensuu;
    }

    public void setErrorSyoriKensuu(int pErrorSyoriKensuu) {
        errorSyoriKensuu = pErrorSyoriKensuu;
    }

    public int getKeiyakuMFkoushinCTRrenban() {
        return keiyakuMFkoushinCTRrenban;
    }

    public void setKeiyakuMFkoushinCTRrenban(int pKeiyakuMFkoushinCTRrenban) {
        keiyakuMFkoushinCTRrenban = pKeiyakuMFkoushinCTRrenban;
    }

    public BizDate getZenkaidensimeymd() {
        return zenkaidensimeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZenkaidensimeymd(BizDate pZenkaidensimeymd) {
        zenkaidensimeymd = pZenkaidensimeymd;
    }

    public BizDate getKonkaidensimeymd() {
        return konkaidensimeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKonkaidensimeymd(BizDate pKonkaidensimeymd) {
        konkaidensimeymd = pKonkaidensimeymd;
    }

    public BizDate getJigyounendoKsnbiymd() {
        return jigyounendoKsnbiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJigyounendoKsnbiymd(BizDate pJigyounendoKsnbiymd) {
        jigyounendoKsnbiymd = pJigyounendoKsnbiymd;
    }

    public BizDate getHoseiZenZenkaidensimeymd() {
        return hoseiZenZenkaidensimeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHoseiZenZenkaidensimeymd(BizDate pHoseiZenZenkaidensimeymd) {
        hoseiZenZenkaidensimeymd = pHoseiZenZenkaidensimeymd;
    }

    public int getWarningSyoriKensuu() {
        return warningSyoriKensuu;
    }

    public void setWarningSyoriKensuu(int pWarningSyoriKensuu) {
        warningSyoriKensuu = pWarningSyoriKensuu;
    }

    public void setParam() {

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

        BizDate zengetuDenSimeYMD = setDenSimebi.exec(kijyunymd);

        setZenkaidensimeymd(zengetuDenSimeYMD);

        setHoseiZenZenkaidensimeymd(zengetuDenSimeYMD);

        if (KIJYUNYMD.equals(kijyunymd.toString())) {
            zenkaidensimeymd = BizDate.valueOf(TYSYTSTARTYMD);
        }

        zengetuDenSimeYMD = setDenSimebi.exec(BizDate.valueOf(kijyunymd.getNextMonth().getBizDateYM(),1));

        setKonkaidensimeymd(zengetuDenSimeYMD);

        if (kijyunymd.getMonth() >= SrCommonConstants.MONTH_MARCH) {

            jigyounendoKsnbiymd =
                BizDate.valueOf(String.valueOf(kijyunymd.getYear()) + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }
        else {

            jigyounendoKsnbiymd =
                BizDate.valueOf(String.valueOf((kijyunymd.getYear() - 1)) + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }
    }
}
