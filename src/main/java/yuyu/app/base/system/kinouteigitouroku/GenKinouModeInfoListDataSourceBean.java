package yuyu.app.base.system.kinouteigitouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;

/**
 * 機能定義登録 - ● 機能一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKinouModeInfoListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subSystemNm;

    public String getSubSystemNm() {
        return subSystemNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSubSystemNm(String pSubSystemNm) {
        subSystemNm = pSubSystemNm;
    }


    private String categoryNm;

    public String getCategoryNm() {
        return categoryNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setCategoryNm(String pCategoryNm) {
        categoryNm = pCategoryNm;
    }


    private String kinouNm;

    public String getKinouNm() {
        return kinouNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKinouNm(String pKinouNm) {
        kinouNm = pKinouNm;
    }


    private String kinouModeNm;

    public String getKinouModeNm() {
        return kinouModeNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKinouModeNm(String pKinouModeNm) {
        kinouModeNm = pKinouModeNm;
    }


    private String henkouLink;

    public String getHenkouLink() {
        return henkouLink;
    }

    public void setHenkouLink(String pHenkouLink) {
        henkouLink = pHenkouLink;
    }

}
