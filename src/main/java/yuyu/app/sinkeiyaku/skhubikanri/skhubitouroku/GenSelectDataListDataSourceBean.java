package yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 新契約不備登録 - selectDataList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSelectDataListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }


    private BizDate dispjimustartymd;

    public BizDate getDispjimustartymd() {
        return dispjimustartymd;
    }

    public void setDispjimustartymd(BizDate pDispjimustartymd) {
        dispjimustartymd = pDispjimustartymd;
    }


    private String nyuuryokuLink;

    public String getNyuuryokuLink() {
        return nyuuryokuLink;
    }

    public void setNyuuryokuLink(String pNyuuryokuLink) {
        nyuuryokuLink = pNyuuryokuLink;
    }

}
