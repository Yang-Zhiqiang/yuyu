package yuyu.app.base.systemsyoukai.tablesyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.Trim;

/**
 * テーブル照会 - resultDetailList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenResultDetailListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String baseFieldNm;

    public String getBaseFieldNm() {
        return baseFieldNm;
    }

    @Trim("both")
    public void setBaseFieldNm(String pBaseFieldNm) {
        baseFieldNm = pBaseFieldNm;
    }


    private String baseFieldValue;

    public String getBaseFieldValue() {
        return baseFieldValue;
    }

    @Trim("both")
    public void setBaseFieldValue(String pBaseFieldValue) {
        baseFieldValue = pBaseFieldValue;
    }

}
