package yuyu.app.biz.bztyouhyou.bztyouhyouikkatu;

import java.io.Serializable;

/**
 * 帳票一括出力 - searchResultList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSearchResultListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispsyoruinm;

    public String getDispsyoruinm() {
        return dispsyoruinm;
    }

    public void setDispsyoruinm(String pDispsyoruinm) {
        dispsyoruinm = pDispsyoruinm;
    }


    private Integer dispmisyuturyokukensuu;

    public Integer getDispmisyuturyokukensuu() {
        return dispmisyuturyokukensuu;
    }

    public void setDispmisyuturyokukensuu(Integer pDispmisyuturyokukensuu) {
        dispmisyuturyokukensuu = pDispmisyuturyokukensuu;
    }


    private Integer dispsakuseisoukensuu;

    public Integer getDispsakuseisoukensuu() {
        return dispsakuseisoukensuu;
    }

    public void setDispsakuseisoukensuu(Integer pDispsakuseisoukensuu) {
        dispsakuseisoukensuu = pDispsakuseisoukensuu;
    }

}
