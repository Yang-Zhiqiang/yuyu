package yuyu.app.sinkeiyaku.sksyoukai.sktokuteikankeihoujin;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 特定関係法人照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkTokuteiKankeiHoujinUiBean extends AbstractUiBean {

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

    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    @MaxLength(max=4)
    @AlphaDigit
    private String srchtkhjnkinyuucd;

    public String getSrchtkhjnkinyuucd() {
        return srchtkhjnkinyuucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchtkhjnkinyuucd(String pSrchtkhjnkinyuucd) {
        srchtkhjnkinyuucd = pSrchtkhjnkinyuucd;
    }

    @MaxLength(max=40)
    @InvalidCharacter
    private String srchtkhjnkjdrtennm;

    public String getSrchtkhjnkjdrtennm() {
        return srchtkhjnkjdrtennm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSrchtkhjnkjdrtennm(String pSrchtkhjnkjdrtennm) {
        srchtkhjnkjdrtennm = pSrchtkhjnkjdrtennm;
    }

    @MaxLength(max=100)
    @InvalidCharacter
    private String srchtkhjnnmkj;

    public String getSrchtkhjnnmkj() {
        return srchtkhjnnmkj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSrchtkhjnnmkj(String pSrchtkhjnnmkj) {
        srchtkhjnnmkj = pSrchtkhjnnmkj;
    }

    private String disptkhjnkinyuucd;

    public String getDisptkhjnkinyuucd() {
        return disptkhjnkinyuucd;
    }

    public void setDisptkhjnkinyuucd(String pDisptkhjnkinyuucd) {
        disptkhjnkinyuucd = pDisptkhjnkinyuucd;
    }

    private String disptkhjnkjdrtennm;

    public String getDisptkhjnkjdrtennm() {
        return disptkhjnkjdrtennm;
    }

    public void setDisptkhjnkjdrtennm(String pDisptkhjnkjdrtennm) {
        disptkhjnkjdrtennm = pDisptkhjnkjdrtennm;
    }

    private String disptkhjnnmkj;

    public String getDisptkhjnnmkj() {
        return disptkhjnnmkj;
    }

    public void setDisptkhjnnmkj(String pDisptkhjnnmkj) {
        disptkhjnnmkj = pDisptkhjnnmkj;
    }
}
