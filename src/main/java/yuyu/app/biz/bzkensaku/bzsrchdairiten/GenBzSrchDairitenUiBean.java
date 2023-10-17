package yuyu.app.biz.bzkensaku.bzsrchdairiten;

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
 * 代理店検索 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzSrchDairitenUiBean extends AbstractUiBean {

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

    @MaxLength(max=7)
    @AlphaDigit
    private String srchdrtencd;

    public String getSrchdrtencd() {
        return srchdrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchdrtencd(String pSrchdrtencd) {
        srchdrtencd = pSrchdrtencd;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String srchdrtennm;

    public String getSrchdrtennm() {
        return srchdrtennm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSrchdrtennm(String pSrchdrtennm) {
        srchdrtennm = pSrchdrtennm;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String srchkanjidairitennm1;

    public String getSrchkanjidairitennm1() {
        return srchkanjidairitennm1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSrchkanjidairitennm1(String pSrchkanjidairitennm1) {
        srchkanjidairitennm1 = pSrchkanjidairitennm1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String srchkanjidairitennm2;

    public String getSrchkanjidairitennm2() {
        return srchkanjidairitennm2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSrchkanjidairitennm2(String pSrchkanjidairitennm2) {
        srchkanjidairitennm2 = pSrchkanjidairitennm2;
    }
}
