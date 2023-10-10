package yuyu.app.biz.bzkensaku.bzsrchdairiten;

import java.io.Serializable;

/**
 * 代理店検索 - searchResults の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSearchResultsDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispdrtencd;

    public String getDispdrtencd() {
        return dispdrtencd;
    }

    public void setDispdrtencd(String pDispdrtencd) {
        dispdrtencd = pDispdrtencd;
    }


    private String dispdrtennmkn;

    public String getDispdrtennmkn() {
        return dispdrtennmkn;
    }

    public void setDispdrtennmkn(String pDispdrtennmkn) {
        dispdrtennmkn = pDispdrtennmkn;
    }


    private String dispdrtennmkj;

    public String getDispdrtennmkj() {
        return dispdrtennmkj;
    }

    public void setDispdrtennmkj(String pDispdrtennmkj) {
        dispdrtennmkj = pDispdrtennmkj;
    }

}
