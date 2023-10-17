package yuyu.app.biz.bzkensaku.bzsrchginkou;

import java.io.Serializable;

/**
 * 銀行検索 - searchResults の 行データBean ベースクラスです。<br />
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


    private String dispbanknmkn;

    public String getDispbanknmkn() {
        return dispbanknmkn;
    }

    public void setDispbanknmkn(String pDispbanknmkn) {
        dispbanknmkn = pDispbanknmkn;
    }


    private String dispbanknmkj;

    public String getDispbanknmkj() {
        return dispbanknmkj;
    }

    public void setDispbanknmkj(String pDispbanknmkj) {
        dispbanknmkj = pDispbanknmkj;
    }

}
