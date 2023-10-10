package yuyu.app.base.log.batchjyoukyousyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.classification.C_BatchResultKbn;

/**
 * バッチ状況照会 - batchJobList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBatchJobListDataSourceBean implements Serializable {

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


    private C_BatchKidouKbn batchKidouKbn;

    public C_BatchKidouKbn getBatchKidouKbn() {
        return batchKidouKbn;
    }

    public void setBatchKidouKbn(C_BatchKidouKbn pBatchKidouKbn) {
        batchKidouKbn = pBatchKidouKbn;
    }


    private String batchStartTime;

    public String getBatchStartTime() {
        return batchStartTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchStartTime(String pBatchStartTime) {
        batchStartTime = pBatchStartTime;
    }


    private String batchEndTime;

    public String getBatchEndTime() {
        return batchEndTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchEndTime(String pBatchEndTime) {
        batchEndTime = pBatchEndTime;
    }


    private C_BatchResultKbn batchResultKbn;

    public C_BatchResultKbn getBatchResultKbn() {
        return batchResultKbn;
    }

    public void setBatchResultKbn(C_BatchResultKbn pBatchResultKbn) {
        batchResultKbn = pBatchResultKbn;
    }


    private C_BatchJyoutaiKbn batchJyoutaiKbn;

    public C_BatchJyoutaiKbn getBatchJyoutaiKbn() {
        return batchJyoutaiKbn;
    }

    public void setBatchJyoutaiKbn(C_BatchJyoutaiKbn pBatchJyoutaiKbn) {
        batchJyoutaiKbn = pBatchJyoutaiKbn;
    }


    private String syousaiLink;

    public String getSyousaiLink() {
        return syousaiLink;
    }

    public void setSyousaiLink(String pSyousaiLink) {
        syousaiLink = pSyousaiLink;
    }


    private String tyouhyouSyuturyokuLink;

    public String getTyouhyouSyuturyokuLink() {
        return tyouhyouSyuturyokuLink;
    }

    public void setTyouhyouSyuturyokuLink(String pTyouhyouSyuturyokuLink) {
        tyouhyouSyuturyokuLink = pTyouhyouSyuturyokuLink;
    }

}
