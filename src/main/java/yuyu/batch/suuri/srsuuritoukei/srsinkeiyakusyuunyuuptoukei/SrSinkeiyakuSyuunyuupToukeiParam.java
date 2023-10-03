package yuyu.batch.suuri.srsuuritoukei.srsinkeiyakusyuunyuuptoukei;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;


/**
 * 新契約収入Ｐ統計情報作成パラメータクラス
 */
@BatchScoped
public class SrSinkeiyakuSyuunyuupToukeiParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public SrSinkeiyakuSyuunyuupToukeiParam() {

    }

    public static final String REIGETUHONBANSOUKOU = "RGHFM000";

    public static final String KESSANKIJIZENSOUKOU2 = "RGHFM001";

    public static final String KESSANKIJIZENSOUKOU3 = "RGHFM002";

    public static final String KESSANKIHONBANSOUKOU = "RGHFM003";

    private BizDate kijyunymd;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

    private int reigetuSyoriCount;

    public int getReigetuSyoriCount() {
        return reigetuSyoriCount;
    }

    public void setReigetuSyoriCount(int pReigetuSyoriCount) {
        this.reigetuSyoriCount = pReigetuSyoriCount;
    }

    private int kessanSyoriCount;

    public int getKessanSyoriCount() {
        return kessanSyoriCount;
    }

    public void setKessanSyoriCount(int pKessanSyoriCount) {
        this.kessanSyoriCount = pKessanSyoriCount;
    }

    private int itijihozonSyoriCount;

    public int getItijihozonSyoriCount() {
        return itijihozonSyoriCount;
    }

    public void setItijihozonSyoriCount(int pItijihozonSyoriCount) {
        this.itijihozonSyoriCount = pItijihozonSyoriCount;
    }

    private int zokkouErrorSyoriCount;

    public int getZokkouErrorSyoriCount() {
        return zokkouErrorSyoriCount;
    }

    public void setZokkouErrorSyoriCount(int pZokkouErrorSyoriCount) {
        zokkouErrorSyoriCount = pZokkouErrorSyoriCount;
    }
}
