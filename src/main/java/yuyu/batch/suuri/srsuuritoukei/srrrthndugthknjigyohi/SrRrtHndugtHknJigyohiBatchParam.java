package yuyu.batch.suuri.srsuuritoukei.srrrthndugthknjigyohi;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 利率変動型保険事業費情報作成パラメータクラス
 */
@BatchScoped
public class SrRrtHndugtHknJigyohiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKCM000 = "RGKCM000";

    public static final String RGKCM002 = "RGKCM002";

    public static final String RGKCM003 = "RGKCM003";

    public static final String RGKCM004 = "RGKCM004";

    public SrRrtHndugtHknJigyohiBatchParam() {

    }

    private BizDate kijyunymd;

    private int reigetuKensuu;

    private int kessanKensuu;

    private int zokkouerrsyoriKensuu;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        this.kijyunymd = pKijyunymd;
    }

    public int getReigetuKensuu() {
        return reigetuKensuu;
    }

    public void setReigetuKensuu(int pReigetuKensuu) {
        this.reigetuKensuu = pReigetuKensuu;
    }

    public int getKessanKensuu() {
        return kessanKensuu;
    }

    public void setKessanKensuu(int pKessanKensuu) {
        this.kessanKensuu = pKessanKensuu;
    }

    public int getZokkouerrsyoriKensuu() {
        return zokkouerrsyoriKensuu;
    }

    public void setZokkouerrsyoriKensuu(int pZokkouerrsyoriKensuu) {
        this.zokkouerrsyoriKensuu = pZokkouerrsyoriKensuu;
    }

}
