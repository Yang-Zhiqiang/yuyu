package yuyu.app.workflow.imagekanri.imagetorikomi;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.Trim;

/**
 * イメージ取込 - syoruiInfo02 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSyoruiInfo02DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispsyoruinm;

    public String getDispsyoruinm() {
        return dispsyoruinm;
    }

    public void setDispsyoruinm(String pDispsyoruinm) {
        dispsyoruinm = pDispsyoruinm;
    }


    private String fileNm;

    public String getFileNm() {
        return fileNm;
    }

    @Trim("both")
    public void setFileNm(String pFileNm) {
        fileNm = pFileNm;
    }

}
