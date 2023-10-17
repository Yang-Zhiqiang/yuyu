package yuyu.app.base.systemsyoukai.tablesyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * テーブル照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenTableSyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<TableSearchResultListDataSourceBean> tableSearchResultListDataSource = new DataSource<>();
    public DataSource<TableSearchResultListDataSourceBean> getTableSearchResultListDataSource() {
        return tableSearchResultListDataSource;
    }

    @Deprecated
    public List<TableSearchResultListDataSourceBean> getTableSearchResultList() {
        return tableSearchResultListDataSource.getDatas();
    }

    public void setTableSearchResultList(List<TableSearchResultListDataSourceBean> pTableSearchResultList) {
        tableSearchResultListDataSource.setDatas(pTableSearchResultList);
    }

    private DataSource<InputSearchConditionDataSourceBean> inputSearchConditionDataSource = new DataSource<>();
    public DataSource<InputSearchConditionDataSourceBean> getInputSearchConditionDataSource() {
        return inputSearchConditionDataSource;
    }

    @Deprecated
    public List<InputSearchConditionDataSourceBean> getInputSearchCondition() {
        return inputSearchConditionDataSource.getDatas();
    }

    public void setInputSearchCondition(List<InputSearchConditionDataSourceBean> pInputSearchCondition) {
        inputSearchConditionDataSource.setDatas(pInputSearchCondition);
    }

    private DataSource<FieldsListDataSourceBean> fieldsListDataSource = new DataSource<>();
    public DataSource<FieldsListDataSourceBean> getFieldsListDataSource() {
        return fieldsListDataSource;
    }

    @Deprecated
    public List<FieldsListDataSourceBean> getFieldsList() {
        return fieldsListDataSource.getDatas();
    }

    public void setFieldsList(List<FieldsListDataSourceBean> pFieldsList) {
        fieldsListDataSource.setDatas(pFieldsList);
    }

    private DataSource<ResultsListDataSourceBean> resultsListDataSource = new DataSource<>();
    public DataSource<ResultsListDataSourceBean> getResultsListDataSource() {
        return resultsListDataSource;
    }

    @Deprecated
    public List<ResultsListDataSourceBean> getResultsList() {
        return resultsListDataSource.getDatas();
    }

    public void setResultsList(List<ResultsListDataSourceBean> pResultsList) {
        resultsListDataSource.setDatas(pResultsList);
    }

    private DataSource<ResultDetailListDataSourceBean> resultDetailListDataSource = new DataSource<>();
    public DataSource<ResultDetailListDataSourceBean> getResultDetailListDataSource() {
        return resultDetailListDataSource;
    }

    @Deprecated
    public List<ResultDetailListDataSourceBean> getResultDetailList() {
        return resultDetailListDataSource.getDatas();
    }

    public void setResultDetailList(List<ResultDetailListDataSourceBean> pResultDetailList) {
        resultDetailListDataSource.setDatas(pResultDetailList);
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

    private String baseToken;

    public String getBaseToken() {
        return baseToken;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBaseToken(String pBaseToken) {
        baseToken = pBaseToken;
    }

    private Integer baseClickRowNo;

    public Integer getBaseClickRowNo() {
        return baseClickRowNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBaseClickRowNo(Integer pBaseClickRowNo) {
        baseClickRowNo = pBaseClickRowNo;
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
