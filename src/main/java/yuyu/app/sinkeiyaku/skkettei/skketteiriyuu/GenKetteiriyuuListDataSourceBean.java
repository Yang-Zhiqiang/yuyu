package yuyu.app.sinkeiyaku.skkettei.skketteiriyuu;

import java.io.Serializable;

/**
 * 決定理由一覧 - ketteiriyuuList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKetteiriyuuListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispketteiriyuucd;

    public String getDispketteiriyuucd() {
        return dispketteiriyuucd;
    }

    public void setDispketteiriyuucd(String pDispketteiriyuucd) {
        dispketteiriyuucd = pDispketteiriyuucd;
    }


    private String dispketteiriyuunaiyou;

    public String getDispketteiriyuunaiyou() {
        return dispketteiriyuunaiyou;
    }

    public void setDispketteiriyuunaiyou(String pDispketteiriyuunaiyou) {
        dispketteiriyuunaiyou = pDispketteiriyuunaiyou;
    }

}
