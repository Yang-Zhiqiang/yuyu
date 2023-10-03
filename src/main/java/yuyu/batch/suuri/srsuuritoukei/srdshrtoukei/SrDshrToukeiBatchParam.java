package yuyu.batch.suuri.srsuuritoukei.srdshrtoukei;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.suuri.srcommon.SrCommonConstants;

/**
 * 数理 数理統計 Ｄ支払統計情報作成パラメータクラス
 */
@BatchScoped
public class SrDshrToukeiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGLBM000 = "RGLBM000";

    public static final String RGLBM002 = "RGLBM002";

    public static final String RGLBM004 = "RGLBM004";

    public SrDshrToukeiBatchParam() {

        setShiKensu(0);

        setErrorCount(0);

        setKeiyakuMFkoushinCTRrenban(0);
    }

    private BizDate kijyunymd;

    private int shiKensu;

    private int errorCount;

    private int keiyakuMFkoushinCTRrenban;

    private BizDate zenkaiDensimeYmd;

    private BizDate konkaiDensimeYmd;

    private BizDate jigyouNendoKsnbiYmd;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd =pKijyunymd;
    }

    public int getShiKensu() {
        return shiKensu;
    }

    public void setShiKensu(int pShiKensu) {
        shiKensu = pShiKensu;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int pErrorCount) {
        errorCount = pErrorCount;
    }

    public int getKeiyakuMFkoushinCTRrenban() {
        return keiyakuMFkoushinCTRrenban;
    }

    public void setKeiyakuMFkoushinCTRrenban(int pKeiyakuMFkoushinCTRrenban) {
        keiyakuMFkoushinCTRrenban = pKeiyakuMFkoushinCTRrenban;
    }

    public BizDate getZenkaiDensimeYmd() {
        return zenkaiDensimeYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZenkaiDensimeYmd(BizDate pZenkaiDensimeYmd) {
        zenkaiDensimeYmd = pZenkaiDensimeYmd;
    }

    public BizDate getKonkaiDensimeYmd() {
        return konkaiDensimeYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKonkaiDensimeYmd(BizDate pKonkaiDensimeYmd) {
        konkaiDensimeYmd = pKonkaiDensimeYmd;
    }

    public BizDate getJigyouNendoKsnbiYmd() {
        return jigyouNendoKsnbiYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJigyouNendoKsnbiYmd(BizDate pJigyouNendoKsnbiYmd) {
        jigyouNendoKsnbiYmd = pJigyouNendoKsnbiYmd;
    }

    public void setParam() {

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

        zenkaiDensimeYmd = setDenSimebi.exec(kijyunymd);

        konkaiDensimeYmd = setDenSimebi.exec(BizDate.valueOf(kijyunymd.getNextMonth().getBizDateYM(),1));

        if (kijyunymd.getMonth() >= SrCommonConstants.MONTH_MARCH) {

            jigyouNendoKsnbiYmd =
                BizDate.valueOf(String.valueOf(kijyunymd.getYear()) + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }
        else {
            jigyouNendoKsnbiYmd =
                BizDate.valueOf(String.valueOf((kijyunymd.getYear() - 1)) + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }
    }
}
