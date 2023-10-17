package yuyu.app.biz.bztyouhyou.bztyouhyouikkatu;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 帳票一括出力 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzTyouhyouIkkatuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SearchResultListDataSourceBean> searchResultListDataSource = new DataSource<>();
    public DataSource<SearchResultListDataSourceBean> getSearchResultListDataSource() {
        return searchResultListDataSource;
    }

    @Deprecated
    public List<SearchResultListDataSourceBean> getSearchResultList() {
        return searchResultListDataSource.getDatas();
    }

    public void setSearchResultList(List<SearchResultListDataSourceBean> pSearchResultList) {
        searchResultListDataSource.setDatas(pSearchResultList);
    }

    private DataSource<SearchKeyListDataSourceBean> searchKeyListDataSource = new DataSource<>();
    public DataSource<SearchKeyListDataSourceBean> getSearchKeyListDataSource() {
        return searchKeyListDataSource;
    }

    @Deprecated
    public List<SearchKeyListDataSourceBean> getSearchKeyList() {
        return searchKeyListDataSource.getDatas();
    }

    public void setSearchKeyList(List<SearchKeyListDataSourceBean> pSearchKeyList) {
        searchKeyListDataSource.setDatas(pSearchKeyList);
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
    private BizDate tyouhyousakuseiymd;

    public BizDate getTyouhyousakuseiymd() {
        return tyouhyousakuseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyousakuseiymd(BizDate pTyouhyousakuseiymd) {
        tyouhyousakuseiymd = pTyouhyousakuseiymd;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String syoruinm;

    public String getSyoruinm() {
        return syoruinm;
    }

    @Trim("both")
    public void setSyoruinm(String pSyoruinm) {
        syoruinm = pSyoruinm;
    }

    private Integer misyuturyokukensuu;

    public Integer getMisyuturyokukensuu() {
        return misyuturyokukensuu;
    }

    public void setMisyuturyokukensuu(Integer pMisyuturyokukensuu) {
        misyuturyokukensuu = pMisyuturyokukensuu;
    }

    private Integer sakuseisoukensuu;

    public Integer getSakuseisoukensuu() {
        return sakuseisoukensuu;
    }

    public void setSakuseisoukensuu(Integer pSakuseisoukensuu) {
        sakuseisoukensuu = pSakuseisoukensuu;
    }

    private String modorubtnbykensaku;

    public String getModorubtnbykensaku() {
        return modorubtnbykensaku;
    }

    public void setModorubtnbykensaku(String pModorubtnbykensaku) {
        modorubtnbykensaku = pModorubtnbykensaku;
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
