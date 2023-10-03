package yuyu.batch.suuri.srsuuritoukei.srbikinidoumeisai;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理統計 数理統計 備金異動明細情報作成パラメータクラス
 */
@BatchScoped
public class SrBikinIdouMeisaiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGHCM001 = "RGHCM001";

    public static final String RGHCM004 = "RGHCM004";

    public static final String DAI1SHIHANKI = "1";

    public static final String HANKI = "2";

    public static final String DAI3SHIHANKI = "3";

    public static final String ZIGYOUNENDOMATU = "4";

    public SrBikinIdouMeisaiBatchParam() {

        setShiKensu(0);

        setErrorCount(0);

        setKeiyakuMFkoushinCTRrenban(0);
    }

    private BizDate kijyunymd;

    private int shiKensu;

    private int errorCount;

    private int keiyakuMFkoushinCTRrenban;

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

}
