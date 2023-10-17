package yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen;

import java.io.Serializable;

/**
 * 帳票出力権限登録 - tyouhyouList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTyouhyouListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispsubsystemnm;

    public String getDispsubsystemnm() {
        return dispsubsystemnm;
    }

    public void setDispsubsystemnm(String pDispsubsystemnm) {
        dispsubsystemnm = pDispsubsystemnm;
    }


    private String dispsyoruinm;

    public String getDispsyoruinm() {
        return dispsyoruinm;
    }

    public void setDispsyoruinm(String pDispsyoruinm) {
        dispsyoruinm = pDispsyoruinm;
    }


    private Boolean dispikkatuoutputchkbox;

    public Boolean getDispikkatuoutputchkbox() {
        return dispikkatuoutputchkbox == null ? Boolean.FALSE : dispikkatuoutputchkbox;
    }

    public void setDispikkatuoutputchkbox(Boolean pDispikkatuoutputchkbox) {
        dispikkatuoutputchkbox = pDispikkatuoutputchkbox == null ? Boolean.FALSE : pDispikkatuoutputchkbox;
    }


    private Boolean dispkobetuoutputchkbox;

    public Boolean getDispkobetuoutputchkbox() {
        return dispkobetuoutputchkbox == null ? Boolean.FALSE : dispkobetuoutputchkbox;
    }

    public void setDispkobetuoutputchkbox(Boolean pDispkobetuoutputchkbox) {
        dispkobetuoutputchkbox = pDispkobetuoutputchkbox == null ? Boolean.FALSE : pDispkobetuoutputchkbox;
    }

}
