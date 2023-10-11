package yuyu.app.biz.bzkensaku.bzsrchsyoubyou;

import java.io.Serializable;

/**
 * 傷病検索 - searchResults の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSearchResultsDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispsyoubyoucd;

    public String getDispsyoubyoucd() {
        return dispsyoubyoucd;
    }

    public void setDispsyoubyoucd(String pDispsyoubyoucd) {
        dispsyoubyoucd = pDispsyoubyoucd;
    }


    private String dispsyoubyounm;

    public String getDispsyoubyounm() {
        return dispsyoubyounm;
    }

    public void setDispsyoubyounm(String pDispsyoubyounm) {
        dispsyoubyounm = pDispsyoubyounm;
    }

}
