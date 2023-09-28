package yuyu.common.biz.bzcommon;

import java.io.Serializable;

/**
 * 区分値変換Bean
 * <B>区分変換結果を格納するクラス</B><BR>
 * <BR>
 */
public class KbnInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String kbnData;
    private boolean henkanFlg;


    public String getKbnData() {
        return kbnData;
    }
    public void setKbnData(String kbnData) {
        this.kbnData = kbnData;
    }
    public boolean isHenkanFlg() {
        return henkanFlg;
    }
    public void setHenkanFlg(boolean henkanFlg) {
        this.henkanFlg = henkanFlg;
    }

}
