package yuyu.app.biz.bzkensaku.bzsrchginkou;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 銀行検索 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzSrchGinkouUiBean extends AbstractUiBean {

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

    @MaxLength(max=4)
    @Digit
    private String srchbankcd;

    public String getSrchbankcd() {
        return srchbankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchbankcd(String pSrchbankcd) {
        srchbankcd = pSrchbankcd;
    }

    @MaxLength(max=25)
    @MultiByteStrings
    @InvalidCharacter
    private String srchbanknmkn;

    public String getSrchbanknmkn() {
        return srchbanknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSrchbanknmkn(String pSrchbanknmkn) {
        srchbanknmkn = pSrchbanknmkn;
    }
}
