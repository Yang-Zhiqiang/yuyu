package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_YmdkeisikiKbn;

/**
 * 業務共通 共通 遅延利息期間計算Beanクラス
 */
public class SiTienRisokuKikanKeisanBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_YmdkeisikiKbn ymdkeisikiKbn;

    private String endYmd;

    private String startYmd;

    private BizNumber kikan_ddddd;

    private BizNumber kikan_yy;

    private BizNumber kikan_ddd;

    public SiTienRisokuKikanKeisanBean (){

        ymdkeisikiKbn = C_YmdkeisikiKbn.BLNK;
        endYmd = "";
        startYmd = "";
        kikan_ddddd = BizNumber.ZERO;
        kikan_yy = BizNumber.ZERO;
        kikan_ddd = BizNumber.ZERO;
    }

    public C_YmdkeisikiKbn getYmdkeisikiKbn() {
        return ymdkeisikiKbn;
    }

    public void setYmdkeisikiKbn(C_YmdkeisikiKbn pymdkeisikiKbn) {
        ymdkeisikiKbn = pymdkeisikiKbn;
    }

    public String getEndYmd() {
        return endYmd;
    }

    public void setEndYmd(String pendYmd) {
        endYmd = pendYmd;
    }

    public String getStartYmd() {
        return startYmd;
    }

    public void setStartYmd(String pstartYmd) {
        startYmd = pstartYmd;
    }

    public BizNumber getKikan_ddddd() {
        return kikan_ddddd;
    }

    public void setKikan_ddddd(BizNumber pkikan_ddddd) {
        kikan_ddddd = pkikan_ddddd;
    }

    public BizNumber getKikan_yy() {
        return kikan_yy;
    }

    public void setKikan_yy(BizNumber pkikan_yy) {
        kikan_yy = pkikan_yy;
    }

    public BizNumber getKikan_ddd() {
        return kikan_ddd;
    }

    public void setKikan_ddd(BizNumber pkikan_ddd) {
        kikan_ddd = pkikan_ddd;
    }
}
