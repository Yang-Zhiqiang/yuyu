package yuyu.app.biz.bzkensaku.bzsrchketteisya;

import java.io.Serializable;

/**
 * 決定者検索 - searchResults の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSearchResultsDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispketsyacd;

    public String getDispketsyacd() {
        return dispketsyacd;
    }

    public void setDispketsyacd(String pDispketsyacd) {
        dispketsyacd = pDispketsyacd;
    }


    private String dispketsyanm;

    public String getDispketsyanm() {
        return dispketsyanm;
    }

    public void setDispketsyanm(String pDispketsyanm) {
        dispketsyanm = pDispketsyanm;
    }

}
