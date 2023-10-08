package yuyu.app.hozen.khozen.khonlinekensuusyoukai;

import java.io.Serializable;

/**
 * 契約保全オンライン処理件数照会 - syoriKensuuList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSyoriKensuuListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispkinounm;

    public String getDispkinounm() {
        return dispkinounm;
    }

    public void setDispkinounm(String pDispkinounm) {
        dispkinounm = pDispkinounm;
    }


    private Integer dispkensuu;

    public Integer getDispkensuu() {
        return dispkensuu;
    }

    public void setDispkensuu(Integer pDispkensuu) {
        dispkensuu = pDispkensuu;
    }

}
