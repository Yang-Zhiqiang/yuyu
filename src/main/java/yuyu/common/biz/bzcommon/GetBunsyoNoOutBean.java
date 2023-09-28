package yuyu.common.biz.bzcommon;

import java.io.Serializable;

/**
 * 業務共通 共通 約款文書番号取得出力Bean
 */
public class GetBunsyoNoOutBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private String yakkanbunsyoNo;

    private String sioriNo;

    public GetBunsyoNoOutBean() {

        super();
        this.yakkanbunsyoNo = "";
        this.sioriNo = "";

    }

    public String getYakkanbunsyoNo() {
        return yakkanbunsyoNo;
    }

    public void setYakkanbunsyoNo(String pYakkanbunsyoNo) {
        this.yakkanbunsyoNo = pYakkanbunsyoNo;
    }

    public String getSioriNo() {
        return sioriNo;
    }

    public void setSioriNo(String pSioriNo) {
        this.sioriNo = pSioriNo;
    }
}
