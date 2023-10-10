package yuyu.app.biz.bzkensaku.bzsrchginkousiten;

import java.io.Serializable;

/**
 * 銀行支店検索 - searchResults の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSearchResultsDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispbankcd;

    public String getDispbankcd() {
        return dispbankcd;
    }

    public void setDispbankcd(String pDispbankcd) {
        dispbankcd = pDispbankcd;
    }


    private String dispsitencd;

    public String getDispsitencd() {
        return dispsitencd;
    }

    public void setDispsitencd(String pDispsitencd) {
        dispsitencd = pDispsitencd;
    }


    private String dispbanknmkj;

    public String getDispbanknmkj() {
        return dispbanknmkj;
    }

    public void setDispbanknmkj(String pDispbanknmkj) {
        dispbanknmkj = pDispbanknmkj;
    }


    private String dispsitennmkj;

    public String getDispsitennmkj() {
        return dispsitennmkj;
    }

    public void setDispsitennmkj(String pDispsitennmkj) {
        dispsitennmkj = pDispsitennmkj;
    }

}
