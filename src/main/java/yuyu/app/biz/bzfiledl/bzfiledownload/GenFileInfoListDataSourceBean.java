package yuyu.app.biz.bzfiledl.bzfiledownload;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;

/**
 * ファイルダウンロード - ●ファイル一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenFileInfoListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileNm;

    public String getFileNm() {
        return fileNm;
    }

    @Trim("both")
    public void setFileNm(String pFileNm) {
        fileNm = pFileNm;
    }


    private String tourokuTime;

    public String getTourokuTime() {
        return tourokuTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTourokuTime(String pTourokuTime) {
        tourokuTime = pTourokuTime;
    }


    private Integer sansyoucount;

    public Integer getSansyoucount() {
        return sansyoucount;
    }

    public void setSansyoucount(Integer pSansyoucount) {
        sansyoucount = pSansyoucount;
    }

}
