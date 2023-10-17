package yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai;

import java.io.Serializable;

/**
 * 入力差異照会 - nyuuryokuSouiList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenNyuuryokuSouiListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispnrksouikm;

    public String getDispnrksouikm() {
        return dispnrksouikm;
    }

    public void setDispnrksouikm(String pDispnrksouikm) {
        dispnrksouikm = pDispnrksouikm;
    }


    private String dispitijinrk;

    public String getDispitijinrk() {
        return dispitijinrk;
    }

    public void setDispitijinrk(String pDispitijinrk) {
        dispitijinrk = pDispitijinrk;
    }


    private String dispnijinrk;

    public String getDispnijinrk() {
        return dispnijinrk;
    }

    public void setDispnijinrk(String pDispnijinrk) {
        dispnijinrk = pDispnijinrk;
    }


    private Boolean commonCheckBox;

    public Boolean getCommonCheckBox() {
        return commonCheckBox == null ? Boolean.FALSE : commonCheckBox;
    }

    public void setCommonCheckBox(Boolean pCommonCheckBox) {
        commonCheckBox = pCommonCheckBox == null ? Boolean.FALSE : pCommonCheckBox;
    }

}
