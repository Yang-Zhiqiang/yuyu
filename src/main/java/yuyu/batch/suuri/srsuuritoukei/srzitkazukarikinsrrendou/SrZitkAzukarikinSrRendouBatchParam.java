package yuyu.batch.suuri.srsuuritoukei.srzitkazukarikinsrrendou;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理統計 数理統計 税適預り金数理連動情報作成パラメータクラス
 */
@BatchScoped
public class SrZitkAzukarikinSrRendouBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKAM002 = "RGKAM002";

    public static final String RGKAM004 = "RGKAM004";

    private BizDate kijyunymd;

    private int syoriKensu;

    private int errorCount;

    public SrZitkAzukarikinSrRendouBatchParam() {

        setSyoriKensu(0);

        setErrorCount(0);
    }

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd =pKijyunymd;
    }

    public int getSyoriKensu() {
        return syoriKensu;
    }

    public void setSyoriKensu(int pSyoriKensu) {
        syoriKensu = pSyoriKensu;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int pErrorCount) {
        errorCount = pErrorCount;
    }
}
