package yuyu.app.biz.bztyouhyou.bztyouhyoukobetu;

import java.util.Map;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 帳票個別出力 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class BzTyouhyouKobetuUiBean extends GenBzTyouhyouKobetuUiBean {

    private static final long serialVersionUID = 1L;

    private boolean printOutFlg;

    private String reportKey;

    private String dispsyoruicd;

    private String dispkensakukii1;

    private String dispkensakukii2;

    private String dispkensakukii3;

    private String dispkensakukii4;

    private String dispkensakukii5;

    private Map<String,String> kensakunmMap;

    public BzTyouhyouKobetuUiBean() {
    }

    public boolean isPrintOutFlg() {
        return printOutFlg;
    }

    public void setPrintOutFlg(boolean pPrintOutFlg) {
        this.printOutFlg = pPrintOutFlg;
    }

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        this.reportKey = pReportKey;
    }

    public String getDispsyoruicd() {
        return dispsyoruicd;
    }

    public void setDispsyoruicd(String pDispsyoruicd) {
        dispsyoruicd = pDispsyoruicd;
    }

    public String getDispkensakukii1() {
        return dispkensakukii1;
    }

    public void setDispkensakukii1(String pDispkensakukii1) {
        dispkensakukii1 = pDispkensakukii1;
    }

    public String getDispkensakukii2() {
        return dispkensakukii2;
    }

    public void setDispkensakukii2(String pDispkensakukii2) {
        dispkensakukii2 = pDispkensakukii2;
    }

    public String getDispkensakukii3() {
        return dispkensakukii3;
    }

    public void setDispkensakukii3(String pDispkensakukii3) {
        dispkensakukii3 = pDispkensakukii3;
    }

    public String getDispkensakukii4() {
        return dispkensakukii4;
    }

    public void setDispkensakukii4(String pDispkensakukii4) {
        dispkensakukii4 = pDispkensakukii4;
    }

    public String getDispkensakukii5() {
        return dispkensakukii5;
    }

    public void setDispkensakukii5(String pDispkensakukii5) {
        dispkensakukii5 = pDispkensakukii5;
    }

    public Map<String, String> getKensakunmMap() {
        return kensakunmMap;
    }

    public void setKensakunmMap(Map<String, String> pKensakunmMap) {
        this.kensakunmMap = pKensakunmMap;
    }
}
