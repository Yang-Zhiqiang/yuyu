package yuyu.app.base.log.batchjyoukyousyoukai;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * バッチ状況照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBatchJyoukyouSyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private AT_BatchJob batchJob;

    public AT_BatchJob getBatchJob() {
        return batchJob;
    }

    public void setBatchJob(AT_BatchJob pBatchJob) {
        batchJob = pBatchJob;
    }

    private DataSource<BatchJobListDataSourceBean> batchJobListDataSource = new DataSource<>();
    public DataSource<BatchJobListDataSourceBean> getBatchJobListDataSource() {
        return batchJobListDataSource;
    }

    @Deprecated
    public List<BatchJobListDataSourceBean> getBatchJobList() {
        return batchJobListDataSource.getDatas();
    }

    public void setBatchJobList(List<BatchJobListDataSourceBean> pBatchJobList) {
        batchJobListDataSource.setDatas(pBatchJobList, 15);
    }

    private DataSource<BatchLogListDataSourceBean> batchLogListDataSource = new DataSource<>();
    public DataSource<BatchLogListDataSourceBean> getBatchLogListDataSource() {
        return batchLogListDataSource;
    }

    @Deprecated
    public List<BatchLogListDataSourceBean> getBatchLogList() {
        return batchLogListDataSource.getDatas();
    }

    public void setBatchLogList(List<BatchLogListDataSourceBean> pBatchLogList) {
        batchLogListDataSource.setDatas(pBatchLogList, 10);
    }

    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    @ValidDate
    private BizDate syoriYmdFrom;

    public BizDate getSyoriYmdFrom() {
        return syoriYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmdFrom(BizDate pSyoriYmdFrom) {
        syoriYmdFrom = pSyoriYmdFrom;
    }

    @ValidDate
    private BizDate syoriYmdTo;

    public BizDate getSyoriYmdTo() {
        return syoriYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmdTo(BizDate pSyoriYmdTo) {
        syoriYmdTo = pSyoriYmdTo;
    }

    private C_BatchResultKbn[] batchResultKbn;

    public C_BatchResultKbn[] getBatchResultKbn() {
        return batchResultKbn;
    }

    public void setBatchResultKbn(C_BatchResultKbn[] pBatchResultKbn) {
        batchResultKbn = pBatchResultKbn;
    }

    private Boolean batchJyoutai;

    public Boolean getBatchJyoutai() {
        return (batchJyoutai == null) ? Boolean.FALSE : batchJyoutai;
    }

    public void setBatchJyoutai(Boolean pBatchJyoutai) {
        batchJyoutai = (pBatchJyoutai == null) ? Boolean.FALSE : pBatchJyoutai;
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

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String userNm;

    public String getUserNm() {
        return userNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUserNm(String pUserNm) {
        userNm = pUserNm;
    }

    private LoopChain<UserDefsList> subSystemIdOptionBeanList = new LoopChain<>();
    public UserDefsList getSubSystemIdOptionBeanList() {
        return subSystemIdOptionBeanList.get();
    }

    public void setSubSystemIdOptionBeanList(UserDefsList pSubSystemIdOptionBeanList) {
        clearSubSystemIdOptionBeanList();
        subSystemIdOptionBeanList.add(pSubSystemIdOptionBeanList);
    }

    public void clearSubSystemIdOptionBeanList() {
        subSystemIdOptionBeanList.clear();
    }
}
