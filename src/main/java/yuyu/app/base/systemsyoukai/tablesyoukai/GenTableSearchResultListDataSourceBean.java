package yuyu.app.base.systemsyoukai.tablesyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * テーブル照会 - tableSearchResultList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTableSearchResultListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String baseSelectLink;

    public String getBaseSelectLink() {
        return baseSelectLink;
    }

    public void setBaseSelectLink(String pBaseSelectLink) {
        baseSelectLink = pBaseSelectLink;
    }


    private String subSystemNm;

    public String getSubSystemNm() {
        return subSystemNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSubSystemNm(String pSubSystemNm) {
        subSystemNm = pSubSystemNm;
    }


    @SingleByteStrings
    private String baseTableId;

    public String getBaseTableId() {
        return baseTableId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBaseTableId(String pBaseTableId) {
        baseTableId = pBaseTableId;
    }


    @InvalidCharacter
    private String baseTableNm;

    public String getBaseTableNm() {
        return baseTableNm;
    }

    @Trim("both")
    public void setBaseTableNm(String pBaseTableNm) {
        baseTableNm = pBaseTableNm;
    }


    private String baseSearchPtnNm;

    public String getBaseSearchPtnNm() {
        return baseSearchPtnNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setBaseSearchPtnNm(String pBaseSearchPtnNm) {
        baseSearchPtnNm = pBaseSearchPtnNm;
    }


    private String baseSearchDdNm;

    public String getBaseSearchDdNm() {
        return baseSearchDdNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setBaseSearchDdNm(String pBaseSearchDdNm) {
        baseSearchDdNm = pBaseSearchDdNm;
    }

}
