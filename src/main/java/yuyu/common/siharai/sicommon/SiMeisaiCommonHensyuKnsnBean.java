package yuyu.common.siharai.sicommon;

import java.io.Serializable;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払明細換算情報編集用Bean
 */
public class SiMeisaiCommonHensyuKnsnBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String knsnInfo;

    private String bikouOutputInfo;

    private String knsnInfoHugo;

    private boolean zennouSeisankGkUmuFlg;

    public SiMeisaiCommonHensyuKnsnBean() {
        super();
    }

    public String getKnsnInfo() {
        return knsnInfo;
    }

    public void setKnsnInfo(String pKnsnInfo) {
        knsnInfo = pKnsnInfo;
    }

    public String getBikouOutputInfo() {
        return bikouOutputInfo;
    }

    public void setBikouOutputInfo(String pBikouOutputInfo) {
        bikouOutputInfo = pBikouOutputInfo;
    }

    public String getKnsnInfoHugo() {
        return knsnInfoHugo;
    }

    public void setKnsnInfoHugo(String pKnsnInfoHugo) {
        knsnInfoHugo = pKnsnInfoHugo;
    }

    public boolean getZennouSeisankGkUmuFlg() {
        return zennouSeisankGkUmuFlg;
    }

    public void setZennouSeisankGkUmuFlg(boolean pZennouSeisankGkUmuFlg) {
        zennouSeisankGkUmuFlg = pZennouSeisankGkUmuFlg;
    }


}
