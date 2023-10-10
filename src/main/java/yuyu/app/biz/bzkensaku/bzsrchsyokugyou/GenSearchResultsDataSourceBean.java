package yuyu.app.biz.bzkensaku.bzsrchsyokugyou;

import java.io.Serializable;

/**
 * 職業検索 - searchResults の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSearchResultsDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispsyokugyoucd;

    public String getDispsyokugyoucd() {
        return dispsyokugyoucd;
    }

    public void setDispsyokugyoucd(String pDispsyokugyoucd) {
        dispsyokugyoucd = pDispsyokugyoucd;
    }


    private String dispsyokugyounm;

    public String getDispsyokugyounm() {
        return dispsyokugyounm;
    }

    public void setDispsyokugyounm(String pDispsyokugyounm) {
        dispsyokugyounm = pDispsyokugyounm;
    }

}
