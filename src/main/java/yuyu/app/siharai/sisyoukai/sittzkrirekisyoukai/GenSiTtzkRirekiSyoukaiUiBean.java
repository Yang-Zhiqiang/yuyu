package yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 手続履歴照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiTtzkRirekiSyoukaiUiBean extends AbstractUiBean {

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

    private DataSource<TtzkRrkListDataSourceBean> ttzkRrkListDataSource = new DataSource<>();
    public DataSource<TtzkRrkListDataSourceBean> getTtzkRrkListDataSource() {
        return ttzkRrkListDataSource;
    }

    @Deprecated
    public List<TtzkRrkListDataSourceBean> getTtzkRrkList() {
        return ttzkRrkListDataSource.getDatas();
    }

    public void setTtzkRrkList(List<TtzkRrkListDataSourceBean> pTtzkRrkList) {
        ttzkRrkListDataSource.setDatas(pTtzkRrkList, 20);
    }

    private String syoukaibtn;

    public String getSyoukaibtn() {
        return syoukaibtn;
    }

    public void setSyoukaibtn(String pSyoukaibtn) {
        syoukaibtn = pSyoukaibtn;
    }

    @SyoukenNo
    private String srchsyono;

    public String getSrchsyono() {
        return srchsyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchsyono(String pSrchsyono) {
        srchsyono = pSrchsyono;
    }

    @MultiByteStrings
    @MaxLength(max=18)
    @InvalidCharacter
    @HostInvalidCharacter
    private String srchhhknnmkn;

    public String getSrchhhknnmkn() {
        return srchhhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSrchhhknnmkn(String pSrchhhknnmkn) {
        srchhhknnmkn = pSrchhhknnmkn;
    }

    private C_SeikyuuSyubetu srchsksyubetu;

    public C_SeikyuuSyubetu getSrchsksyubetu() {
        return srchsksyubetu;
    }

    public void setSrchsksyubetu(C_SeikyuuSyubetu pSrchsksyubetu) {
        srchsksyubetu = pSrchsksyubetu;
    }

    @ValidDate
    private BizDate srchsyoruiukeymdfrom;

    public BizDate getSrchsyoruiukeymdfrom() {
        return srchsyoruiukeymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchsyoruiukeymdfrom(BizDate pSrchsyoruiukeymdfrom) {
        srchsyoruiukeymdfrom = pSrchsyoruiukeymdfrom;
    }

    @ValidDate
    private BizDate srchsyoruiukeymdto;

    public BizDate getSrchsyoruiukeymdto() {
        return srchsyoruiukeymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchsyoruiukeymdto(BizDate pSrchsyoruiukeymdto) {
        srchsyoruiukeymdto = pSrchsyoruiukeymdto;
    }

    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String hhknnmkn;

    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknnmkj;

    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String uktnmkn;

    public String getUktnmkn() {
        return uktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktnmkn(String pUktnmkn) {
        uktnmkn = pUktnmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String uktnmkj;

    public String getUktnmkj() {
        return uktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktnmkj(String pUktnmkj) {
        uktnmkj = pUktnmkj;
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    @ValidDate
    private BizDate syoruiukeymd;

    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    private String dispttdkrrkskbtkey;

    public String getDispttdkrrkskbtkey() {
        return dispttdkrrkskbtkey;
    }

    public void setDispttdkrrkskbtkey(String pDispttdkrrkskbtkey) {
        dispttdkrrkskbtkey = pDispttdkrrkskbtkey;
    }

    private String modorubtnbykensaku;

    public String getModorubtnbykensaku() {
        return modorubtnbykensaku;
    }

    public void setModorubtnbykensaku(String pModorubtnbykensaku) {
        modorubtnbykensaku = pModorubtnbykensaku;
    }
}
