package yuyu.app.base.systemsyoukai.tablesyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.classification.C_TblsSearchCondition;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * テーブル照会 - inputSearchCondition の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenInputSearchConditionDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String baseSearchDdNm;

    public String getBaseSearchDdNm() {
        return baseSearchDdNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setBaseSearchDdNm(String pBaseSearchDdNm) {
        baseSearchDdNm = pBaseSearchDdNm;
    }


    private C_TblsSearchCondition baseSearchConditionKbn;

    public C_TblsSearchCondition getBaseSearchConditionKbn() {
        return baseSearchConditionKbn;
    }

    public void setBaseSearchConditionKbn(C_TblsSearchCondition pBaseSearchConditionKbn) {
        baseSearchConditionKbn = pBaseSearchConditionKbn;
    }


    @InvalidCharacter
    private String baseSearchCondition;

    public String getBaseSearchCondition() {
        return baseSearchCondition;
    }

    public void setBaseSearchCondition(String pBaseSearchCondition) {
        baseSearchCondition = pBaseSearchCondition;
    }

}
