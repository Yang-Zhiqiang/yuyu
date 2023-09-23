package yuyu.common.siharai.chksk;

import java.io.Serializable;

import yuyu.def.classification.C_SKNaiyouChkKbn;

/**
 * 保険金給付金支払 請求内容チェック チェック結果Bean
 */
public class ChkKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msgHikisuu1;

    private String msgHikisuu2;

    private String msgHikisuu3;

    private String msgHikisuu4;

    private String msgHikisuu5;

    private C_SKNaiyouChkKbn sKNaiyouChkKbn;

    public ChkKekkaBean() {
        super();
        this.msgHikisuu1 = "";
        this.msgHikisuu2 = "";
        this.msgHikisuu3 = "";
        this.msgHikisuu4 = "";
        this.msgHikisuu5 = "";
    }

    public String getMsgHikisuu1() {
        return this.msgHikisuu1;
    }

    public void setMsgHikisuu1(String pMsgHikisuu1) {
        this.msgHikisuu1 = pMsgHikisuu1;
    }

    public String getMsgHikisuu2() {
        return this.msgHikisuu2;
    }

    public void setMsgHikisuu2(String pMsgHikisuu2) {
        this.msgHikisuu2 = pMsgHikisuu2;
    }

    public String getMsgHikisuu3() {
        return this.msgHikisuu3;
    }

    public void setMsgHikisuu3(String pMsgHikisuu3) {
        this.msgHikisuu3 = pMsgHikisuu3;
    }

    public String getMsgHikisuu4() {
        return this.msgHikisuu4;
    }

    public void setMsgHikisuu4(String pMsgHikisuu4) {
        this.msgHikisuu4 = pMsgHikisuu4;
    }

    public String getMsgHikisuu5() {
        return this.msgHikisuu5;
    }

    public void setMsgHikisuu5(String pMsgHikisuu5) {
        this.msgHikisuu5 = pMsgHikisuu5;
    }

    public C_SKNaiyouChkKbn getSKNaiyouChkKbn() {
        return this.sKNaiyouChkKbn;
    }

    public void setSKNaiyouChkKbn(C_SKNaiyouChkKbn pSKNaiyouChkKbn) {
        this.sKNaiyouChkKbn = pSKNaiyouChkKbn;
    }

}
