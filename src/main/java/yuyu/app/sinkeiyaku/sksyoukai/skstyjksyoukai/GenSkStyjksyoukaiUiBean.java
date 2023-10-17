package yuyu.app.sinkeiyaku.sksyoukai.skstyjksyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 進捗状況照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkStyjksyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SearchResultsTitleDataSourceBean> searchResultsTitleDataSource = new DataSource<>();
    public DataSource<SearchResultsTitleDataSourceBean> getSearchResultsTitleDataSource() {
        return searchResultsTitleDataSource;
    }

    @Deprecated
    public List<SearchResultsTitleDataSourceBean> getSearchResultsTitle() {
        return searchResultsTitleDataSource.getDatas();
    }

    public void setSearchResultsTitle(List<SearchResultsTitleDataSourceBean> pSearchResultsTitle) {
        searchResultsTitleDataSource.setDatas(pSearchResultsTitle);
    }

    private DataSource<SearchResultsDataSourceBean> searchResultsDataSource = new DataSource<>();
    public DataSource<SearchResultsDataSourceBean> getSearchResultsDataSource() {
        return searchResultsDataSource;
    }

    @Deprecated
    public List<SearchResultsDataSourceBean> getSearchResults() {
        return searchResultsDataSource.getDatas();
    }

    public void setSearchResults(List<SearchResultsDataSourceBean> pSearchResults) {
        searchResultsDataSource.setDatas(pSearchResults, 100);
    }

    @ValidDate
    private BizDate srchjimustartymdfrom;

    public BizDate getSrchjimustartymdfrom() {
        return srchjimustartymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchjimustartymdfrom(BizDate pSrchjimustartymdfrom) {
        srchjimustartymdfrom = pSrchjimustartymdfrom;
    }

    @ValidDate
    private BizDate srchjimustartymdto;

    public BizDate getSrchjimustartymdto() {
        return srchjimustartymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchjimustartymdto(BizDate pSrchjimustartymdto) {
        srchjimustartymdto = pSrchjimustartymdto;
    }

    @MousikomiNo
    private String srchmosno;

    public String getSrchmosno() {
        return srchmosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchmosno(String pSrchmosno) {
        srchmosno = pSrchmosno;
    }

    private String srchnowkinoussnm;

    public String getSrchnowkinoussnm() {
        return srchnowkinoussnm;
    }

    public void setSrchnowkinoussnm(String pSrchnowkinoussnm) {
        srchnowkinoussnm = pSrchnowkinoussnm;
    }

    private C_SeirituKbn[] srchseiritukbn;

    public C_SeirituKbn[] getSrchseiritukbn() {
        return srchseiritukbn;
    }

    public void setSrchseiritukbn(C_SeirituKbn[] pSrchseiritukbn) {
        srchseiritukbn = pSrchseiritukbn;
    }

    private C_KetteiKbn[] srchketteikbn;

    public C_KetteiKbn[] getSrchketteikbn() {
        return srchketteikbn;
    }

    public void setSrchketteikbn(C_KetteiKbn[] pSrchketteikbn) {
        srchketteikbn = pSrchketteikbn;
    }

    private Boolean srchlincjkjknumu;

    public Boolean getSrchlincjkjknumu() {
        return (srchlincjkjknumu == null) ? Boolean.FALSE : srchlincjkjknumu;
    }

    public void setSrchlincjkjknumu(Boolean pSrchlincjkjknumu) {
        srchlincjkjknumu = (pSrchlincjkjknumu == null) ? Boolean.FALSE : pSrchlincjkjknumu;
    }

    private LoopChain<UserDefsList> srchnowkinoussnmOptionBeanList = new LoopChain<>();
    public UserDefsList getSrchnowkinoussnmOptionBeanList() {
        return srchnowkinoussnmOptionBeanList.get();
    }

    public void setSrchnowkinoussnmOptionBeanList(UserDefsList pSrchnowkinoussnmOptionBeanList) {
        clearSrchnowkinoussnmOptionBeanList();
        srchnowkinoussnmOptionBeanList.add(pSrchnowkinoussnmOptionBeanList);
    }

    public void clearSrchnowkinoussnmOptionBeanList() {
        srchnowkinoussnmOptionBeanList.clear();
    }
}
