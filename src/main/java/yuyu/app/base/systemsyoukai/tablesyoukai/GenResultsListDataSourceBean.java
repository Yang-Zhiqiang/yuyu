package yuyu.app.base.systemsyoukai.tablesyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;

/**
 * テーブル照会 - resultsList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenResultsListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer baseRowNo;

    public Integer getBaseRowNo() {
        return baseRowNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBaseRowNo(Integer pBaseRowNo) {
        baseRowNo = pBaseRowNo;
    }


    private Integer baseColNo;

    public Integer getBaseColNo() {
        return baseColNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBaseColNo(Integer pBaseColNo) {
        baseColNo = pBaseColNo;
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
