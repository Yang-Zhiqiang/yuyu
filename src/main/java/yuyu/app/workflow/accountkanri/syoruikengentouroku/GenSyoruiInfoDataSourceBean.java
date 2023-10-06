package yuyu.app.workflow.accountkanri.syoruikengentouroku;

import java.io.Serializable;

/**
 * 書類権限登録 - syoruiInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSyoruiInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispsubsystemnm;

    public String getDispsubsystemnm() {
        return dispsubsystemnm;
    }

    public void setDispsubsystemnm(String pDispsubsystemnm) {
        dispsubsystemnm = pDispsubsystemnm;
    }


    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }


    private String dispsyoruinm;

    public String getDispsyoruinm() {
        return dispsyoruinm;
    }

    public void setDispsyoruinm(String pDispsyoruinm) {
        dispsyoruinm = pDispsyoruinm;
    }


    private Boolean commonCheckBox;

    public Boolean getCommonCheckBox() {
        return commonCheckBox == null ? Boolean.FALSE : commonCheckBox;
    }

    public void setCommonCheckBox(Boolean pCommonCheckBox) {
        commonCheckBox = pCommonCheckBox == null ? Boolean.FALSE : pCommonCheckBox;
    }

}
