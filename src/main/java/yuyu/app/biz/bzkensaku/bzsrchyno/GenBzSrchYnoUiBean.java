package yuyu.app.biz.bzkensaku.bzsrchyno;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 郵便番号検索 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzSrchYnoUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SearchResultDataSourceBean> searchResultDataSource = new DataSource<>();
    public DataSource<SearchResultDataSourceBean> getSearchResultDataSource() {
        return searchResultDataSource;
    }

    @Deprecated
    public List<SearchResultDataSourceBean> getSearchResult() {
        return searchResultDataSource.getDatas();
    }

    public void setSearchResult(List<SearchResultDataSourceBean> pSearchResult) {
        searchResultDataSource.setDatas(pSearchResult, 10);
    }

    @MaxLength(max=7)
    @Digit
    private String srchyno;

    public String getSrchyno() {
        return srchyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchyno(String pSrchyno) {
        srchyno = pSrchyno;
    }

    private C_TodouhukenKbn todouhukenKbn;

    public C_TodouhukenKbn getTodouhukenKbn() {
        return todouhukenKbn;
    }

    public void setTodouhukenKbn(C_TodouhukenKbn pTodouhukenKbn) {
        todouhukenKbn = pTodouhukenKbn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String srchknadr;

    public String getSrchknadr() {
        return srchknadr;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSrchknadr(String pSrchknadr) {
        srchknadr = pSrchknadr;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String srchkjadr;

    public String getSrchkjadr() {
        return srchkjadr;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSrchkjadr(String pSrchkjadr) {
        srchkjadr = pSrchkjadr;
    }
}
