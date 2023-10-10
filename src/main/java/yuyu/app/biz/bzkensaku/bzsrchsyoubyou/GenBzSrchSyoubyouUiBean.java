package yuyu.app.biz.bzkensaku.bzsrchsyoubyou;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 傷病検索 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzSrchSyoubyouUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SearchResultsDataSourceBean> searchResultsDataSource = new DataSource<>();
    public DataSource<SearchResultsDataSourceBean> getSearchResultsDataSource() {
        return searchResultsDataSource;
    }

    @Deprecated
    public List<SearchResultsDataSourceBean> getSearchResults() {
        return searchResultsDataSource.getDatas();
    }

    public void setSearchResults(List<SearchResultsDataSourceBean> pSearchResults) {
        searchResultsDataSource.setDatas(pSearchResults, 10);
    }

    @MaxLength(max=6)
    @AlphaDigit
    private String srchsyoubyoucd;

    public String getSrchsyoubyoucd() {
        return srchsyoubyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchsyoubyoucd(String pSrchsyoubyoucd) {
        srchsyoubyoucd = pSrchsyoubyoucd;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String srchsyoubyounm;

    public String getSrchsyoubyounm() {
        return srchsyoubyounm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSrchsyoubyounm(String pSrchsyoubyounm) {
        srchsyoubyounm = pSrchsyoubyounm;
    }
}
