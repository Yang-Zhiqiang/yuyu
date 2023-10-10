package yuyu.app.biz.bzkensaku.bzsrchsimekiribi;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;

/**
 * 締切日検索 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzSrchSimekiribiUiBean extends AbstractUiBean {

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

    @ValidDateYm
    private BizDateYM srchbosyuuym;

    public BizDateYM getSrchbosyuuym() {
        return srchbosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchbosyuuym(BizDateYM pSrchbosyuuym) {
        srchbosyuuym = pSrchbosyuuym;
    }
}
