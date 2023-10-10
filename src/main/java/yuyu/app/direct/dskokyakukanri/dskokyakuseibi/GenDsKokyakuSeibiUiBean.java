package yuyu.app.direct.dskokyakukanri.dskokyakuseibi;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_BaitaiKbn;
import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SeisaHuyouHyj;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 顧客整備 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenDsKokyakuSeibiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SearchResultInfoDataSourceBean> searchResultInfoDataSource = new DataSource<>();
    public DataSource<SearchResultInfoDataSourceBean> getSearchResultInfoDataSource() {
        return searchResultInfoDataSource;
    }

    @Deprecated
    public List<SearchResultInfoDataSourceBean> getSearchResultInfo() {
        return searchResultInfoDataSource.getDatas();
    }

    public void setSearchResultInfo(List<SearchResultInfoDataSourceBean> pSearchResultInfo) {
        searchResultInfoDataSource.setDatas(pSearchResultInfo, 10);
    }

    private DataSource<SrchRsltKzInfoDataSourceBean> srchRsltKzInfoDataSource = new DataSource<>();
    public DataSource<SrchRsltKzInfoDataSourceBean> getSrchRsltKzInfoDataSource() {
        return srchRsltKzInfoDataSource;
    }

    @Deprecated
    public List<SrchRsltKzInfoDataSourceBean> getSrchRsltKzInfo() {
        return srchRsltKzInfoDataSource.getDatas();
    }

    public void setSrchRsltKzInfo(List<SrchRsltKzInfoDataSourceBean> pSrchRsltKzInfo) {
        srchRsltKzInfoDataSource.setDatas(pSrchRsltKzInfo, 10);
    }

    private DataSource<DskokkykInfoDataSourceBean> dskokkykInfoDataSource = new DataSource<>();
    public DataSource<DskokkykInfoDataSourceBean> getDskokkykInfoDataSource() {
        return dskokkykInfoDataSource;
    }

    @Deprecated
    public List<DskokkykInfoDataSourceBean> getDskokkykInfo() {
        return dskokkykInfoDataSource.getDatas();
    }

    public void setDskokkykInfo(List<DskokkykInfoDataSourceBean> pDskokkykInfo) {
        dskokkykInfoDataSource.setDatas(pDskokkykInfo, 10);
    }

    @Length(length=10)
    @SingleByteStrings
    @Digit
    private String srchdskokno;

    public String getSrchdskokno() {
        return srchdskokno;
    }

    public void setSrchdskokno(String pSrchdskokno) {
        srchdskokno = pSrchdskokno;
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

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String srchdskokyakunmkj;

    public String getSrchdskokyakunmkj() {
        return srchdskokyakunmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSrchdskokyakunmkj(String pSrchdskokyakunmkj) {
        srchdskokyakunmkj = pSrchdskokyakunmkj;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String srchdskokyakunmkn;

    public String getSrchdskokyakunmkn() {
        return srchdskokyakunmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSrchdskokyakunmkn(String pSrchdskokyakunmkn) {
        srchdskokyakunmkn = pSrchdskokyakunmkn;
    }

    @ValidDate
    private BizDate srchdskokyakuseiymd;

    public BizDate getSrchdskokyakuseiymd() {
        return srchdskokyakuseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchdskokyakuseiymd(BizDate pSrchdskokyakuseiymd) {
        srchdskokyakuseiymd = pSrchdskokyakuseiymd;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String srchdskokyakuyno;

    public String getSrchdskokyakuyno() {
        return srchdskokyakuyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchdskokyakuyno(String pSrchdskokyakuyno) {
        srchdskokyakuyno = pSrchdskokyakuyno;
    }

    @ValidDate
    private BizDate syoriYmdFrom;

    public BizDate getSyoriYmdFrom() {
        return syoriYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmdFrom(BizDate pSyoriYmdFrom) {
        syoriYmdFrom = pSyoriYmdFrom;
    }

    @ValidDate
    private BizDate syoriYmdTo;

    public BizDate getSyoriYmdTo() {
        return syoriYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmdTo(BizDate pSyoriYmdTo) {
        syoriYmdTo = pSyoriYmdTo;
    }

    @Length(length=4)
    @Digit
    private String srchtktitrhkkzbankcd;

    public String getSrchtktitrhkkzbankcd() {
        return srchtktitrhkkzbankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchtktitrhkkzbankcd(String pSrchtktitrhkkzbankcd) {
        srchtktitrhkkzbankcd = pSrchtktitrhkkzbankcd;
    }

    @Length(length=3)
    @Digit
    private String srchtktitrhkkzsitencd;

    public String getSrchtktitrhkkzsitencd() {
        return srchtktitrhkkzsitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchtktitrhkkzsitencd(String pSrchtktitrhkkzsitencd) {
        srchtktitrhkkzsitencd = pSrchtktitrhkkzsitencd;
    }

    @ValidDate
    private BizDate srchhaisiymdfrom;

    public BizDate getSrchhaisiymdfrom() {
        return srchhaisiymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchhaisiymdfrom(BizDate pSrchhaisiymdfrom) {
        srchhaisiymdfrom = pSrchhaisiymdfrom;
    }

    @ValidDate
    private BizDate srchhaisiymdto;

    public BizDate getSrchhaisiymdto() {
        return srchhaisiymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchhaisiymdto(BizDate pSrchhaisiymdto) {
        srchhaisiymdto = pSrchhaisiymdto;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String kyknmkj;

    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String kyknmkn;

    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    @ValidDate
    private BizDate kykseiymd;

    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String tsinyno;

    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    private C_Kyksei kyksei;

    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr1kj;

    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr2kj;

    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr3kj;

    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String tsintelno;

    public String getTsintelno() {
        return tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String dai2tsintelno;

    public String getDai2tsintelno() {
        return dai2tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai2tsintelno(String pDai2tsintelno) {
        dai2tsintelno = pDai2tsintelno;
    }

    private String dskokyakunmkj;

    public String getDskokyakunmkj() {
        return dskokyakunmkj;
    }

    public void setDskokyakunmkj(String pDskokyakunmkj) {
        dskokyakunmkj = pDskokyakunmkj;
    }

    @HostInvalidCharacter
    private String dskokyakunmkn;

    public String getDskokyakunmkn() {
        return dskokyakunmkn;
    }

    public void setDskokyakunmkn(String pDskokyakunmkn) {
        dskokyakunmkn = pDskokyakunmkn;
    }

    private BizDate dskokyakuseiymd;

    public BizDate getDskokyakuseiymd() {
        return dskokyakuseiymd;
    }

    public void setDskokyakuseiymd(BizDate pDskokyakuseiymd) {
        dskokyakuseiymd = pDskokyakuseiymd;
    }

    private String dskokyakuyno;

    public String getDskokyakuyno() {
        return dskokyakuyno;
    }

    public void setDskokyakuyno(String pDskokyakuyno) {
        dskokyakuyno = pDskokyakuyno;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String inputdskokyakunmkj;

    public String getInputdskokyakunmkj() {
        return inputdskokyakunmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setInputdskokyakunmkj(String pInputdskokyakunmkj) {
        inputdskokyakunmkj = pInputdskokyakunmkj;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String inputdskokyakunmkn;

    public String getInputdskokyakunmkn() {
        return inputdskokyakunmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setInputdskokyakunmkn(String pInputdskokyakunmkn) {
        inputdskokyakunmkn = pInputdskokyakunmkn;
    }

    @ValidDate
    private BizDate inputdskokyakuseiymd;

    public BizDate getInputdskokyakuseiymd() {
        return inputdskokyakuseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setInputdskokyakuseiymd(BizDate pInputdskokyakuseiymd) {
        inputdskokyakuseiymd = pInputdskokyakuseiymd;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String inputdskokyakuyno;

    public String getInputdskokyakuyno() {
        return inputdskokyakuyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setInputdskokyakuyno(String pInputdskokyakuyno) {
        inputdskokyakuyno = pInputdskokyakuyno;
    }

    private String kakunindskokyakunmkj;

    public String getKakunindskokyakunmkj() {
        return kakunindskokyakunmkj;
    }

    public void setKakunindskokyakunmkj(String pKakunindskokyakunmkj) {
        kakunindskokyakunmkj = pKakunindskokyakunmkj;
    }

    @HostInvalidCharacter
    private String kakunindskokyakunmkn;

    public String getKakunindskokyakunmkn() {
        return kakunindskokyakunmkn;
    }

    public void setKakunindskokyakunmkn(String pKakunindskokyakunmkn) {
        kakunindskokyakunmkn = pKakunindskokyakunmkn;
    }

    private BizDate kakunindskokyakuseiymd;

    public BizDate getKakunindskokyakuseiymd() {
        return kakunindskokyakuseiymd;
    }

    public void setKakunindskokyakuseiymd(BizDate pKakunindskokyakuseiymd) {
        kakunindskokyakuseiymd = pKakunindskokyakuseiymd;
    }

    private String kakunindskokyakuyno;

    public String getKakunindskokyakuyno() {
        return kakunindskokyakuyno;
    }

    public void setKakunindskokyakuyno(String pKakunindskokyakuyno) {
        kakunindskokyakuyno = pKakunindskokyakuyno;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }

    private C_DsKokyakuJtKbn dskokyakujtkbn;

    public C_DsKokyakuJtKbn getDskokyakujtkbn() {
        return dskokyakujtkbn;
    }

    public void setDskokyakujtkbn(C_DsKokyakuJtKbn pDskokyakujtkbn) {
        dskokyakujtkbn = pDskokyakujtkbn;
    }

    private C_DsKokyakuJtKbn kakunindskokyakujtkbn;

    public C_DsKokyakuJtKbn getKakunindskokyakujtkbn() {
        return kakunindskokyakujtkbn;
    }

    public void setKakunindskokyakujtkbn(C_DsKokyakuJtKbn pKakunindskokyakujtkbn) {
        kakunindskokyakujtkbn = pKakunindskokyakujtkbn;
    }

    private BizDate dskokyakusakuseiymd;

    public BizDate getDskokyakusakuseiymd() {
        return dskokyakusakuseiymd;
    }

    public void setDskokyakusakuseiymd(BizDate pDskokyakusakuseiymd) {
        dskokyakusakuseiymd = pDskokyakusakuseiymd;
    }

    private C_DsTeisiRiyuuKbn dsteisiriyuukbn;

    public C_DsTeisiRiyuuKbn getDsteisiriyuukbn() {
        return dsteisiriyuukbn;
    }

    public void setDsteisiriyuukbn(C_DsTeisiRiyuuKbn pDsteisiriyuukbn) {
        dsteisiriyuukbn = pDsteisiriyuukbn;
    }

    private C_DsTeisiRiyuuKbn inputdsteisiriyuukbn;

    public C_DsTeisiRiyuuKbn getInputdsteisiriyuukbn() {
        return inputdsteisiriyuukbn;
    }

    public void setInputdsteisiriyuukbn(C_DsTeisiRiyuuKbn pInputdsteisiriyuukbn) {
        inputdsteisiriyuukbn = pInputdsteisiriyuukbn;
    }

    private C_DsTeisiRiyuuKbn kakunindsteisiriyuukbn;

    public C_DsTeisiRiyuuKbn getKakunindsteisiriyuukbn() {
        return kakunindsteisiriyuukbn;
    }

    public void setKakunindsteisiriyuukbn(C_DsTeisiRiyuuKbn pKakunindsteisiriyuukbn) {
        kakunindsteisiriyuukbn = pKakunindsteisiriyuukbn;
    }

    private BizDate dskokyakumukouymd;

    public BizDate getDskokyakumukouymd() {
        return dskokyakumukouymd;
    }

    public void setDskokyakumukouymd(BizDate pDskokyakumukouymd) {
        dskokyakumukouymd = pDskokyakumukouymd;
    }

    private BizDate kakunindskokyakumukouymd;

    public BizDate getKakunindskokyakumukouymd() {
        return kakunindskokyakumukouymd;
    }

    public void setKakunindskokyakumukouymd(BizDate pKakunindskokyakumukouymd) {
        kakunindskokyakumukouymd = pKakunindskokyakumukouymd;
    }

    private C_DsKanyuuKeiroKbn dskanyuukeirokbn;

    public C_DsKanyuuKeiroKbn getDskanyuukeirokbn() {
        return dskanyuukeirokbn;
    }

    public void setDskanyuukeirokbn(C_DsKanyuuKeiroKbn pDskanyuukeirokbn) {
        dskanyuukeirokbn = pDskanyuukeirokbn;
    }

    private C_DsKanyuuKeiroKbn inputdskanyuukeirokbn;

    public C_DsKanyuuKeiroKbn getInputdskanyuukeirokbn() {
        return inputdskanyuukeirokbn;
    }

    public void setInputdskanyuukeirokbn(C_DsKanyuuKeiroKbn pInputdskanyuukeirokbn) {
        inputdskanyuukeirokbn = pInputdskanyuukeirokbn;
    }

    private C_DsKanyuuKeiroKbn kakunindskanyuukeirokbn;

    public C_DsKanyuuKeiroKbn getKakunindskanyuukeirokbn() {
        return kakunindskanyuukeirokbn;
    }

    public void setKakunindskanyuukeirokbn(C_DsKanyuuKeiroKbn pKakunindskanyuukeirokbn) {
        kakunindskanyuukeirokbn = pKakunindskanyuukeirokbn;
    }

    private C_UmuKbn krpasswordumukbn;

    public C_UmuKbn getKrpasswordumukbn() {
        return krpasswordumukbn;
    }

    public void setKrpasswordumukbn(C_UmuKbn pKrpasswordumukbn) {
        krpasswordumukbn = pKrpasswordumukbn;
    }

    private C_UmuKbn kakuninkrpasswordumukbn;

    public C_UmuKbn getKakuninkrpasswordumukbn() {
        return kakuninkrpasswordumukbn;
    }

    public void setKakuninkrpasswordumukbn(C_UmuKbn pKakuninkrpasswordumukbn) {
        kakuninkrpasswordumukbn = pKakuninkrpasswordumukbn;
    }

    private C_DsKrHnnKakCdSetKbn dskrhnnkakcdsetkbn;

    public C_DsKrHnnKakCdSetKbn getDskrhnnkakcdsetkbn() {
        return dskrhnnkakcdsetkbn;
    }

    public void setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn pDskrhnnkakcdsetkbn) {
        dskrhnnkakcdsetkbn = pDskrhnnkakcdsetkbn;
    }

    private C_DsKrHnnKakCdSetKbn kakunindskrhnnkakcdsetkbn;

    public C_DsKrHnnKakCdSetKbn getKakunindskrhnnkakcdsetkbn() {
        return kakunindskrhnnkakcdsetkbn;
    }

    public void setKakunindskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn pKakunindskrhnnkakcdsetkbn) {
        kakunindskrhnnkakcdsetkbn = pKakunindskrhnnkakcdsetkbn;
    }

    private BizDate dskrhnnkakcdsetymd;

    public BizDate getDskrhnnkakcdsetymd() {
        return dskrhnnkakcdsetymd;
    }

    public void setDskrhnnkakcdsetymd(BizDate pDskrhnnkakcdsetymd) {
        dskrhnnkakcdsetymd = pDskrhnnkakcdsetymd;
    }

    private BizDate kakunindskrhnnkakcdsetymd;

    public BizDate getKakunindskrhnnkakcdsetymd() {
        return kakunindskrhnnkakcdsetymd;
    }

    public void setKakunindskrhnnkakcdsetymd(BizDate pKakunindskrhnnkakcdsetymd) {
        kakunindskrhnnkakcdsetymd = pKakunindskrhnnkakcdsetymd;
    }

    private BizDate dskrhnnkakcdyuukouymd;

    public BizDate getDskrhnnkakcdyuukouymd() {
        return dskrhnnkakcdyuukouymd;
    }

    public void setDskrhnnkakcdyuukouymd(BizDate pDskrhnnkakcdyuukouymd) {
        dskrhnnkakcdyuukouymd = pDskrhnnkakcdyuukouymd;
    }

    private BizDate kakunindskrhnnkakcdykymd;

    public BizDate getKakunindskrhnnkakcdykymd() {
        return kakunindskrhnnkakcdykymd;
    }

    public void setKakunindskrhnnkakcdykymd(BizDate pKakunindskrhnnkakcdykymd) {
        kakunindskrhnnkakcdykymd = pKakunindskrhnnkakcdykymd;
    }

    private BizDate dskrhnnkakcdttshjyhsymd;

    public BizDate getDskrhnnkakcdttshjyhsymd() {
        return dskrhnnkakcdttshjyhsymd;
    }

    public void setDskrhnnkakcdttshjyhsymd(BizDate pDskrhnnkakcdttshjyhsymd) {
        dskrhnnkakcdttshjyhsymd = pDskrhnnkakcdttshjyhsymd;
    }

    private BizDate kakunindskrhnnkakcdttjyymd;

    public BizDate getKakunindskrhnnkakcdttjyymd() {
        return kakunindskrhnnkakcdttjyymd;
    }

    public void setKakunindskrhnnkakcdttjyymd(BizDate pKakunindskrhnnkakcdttjyymd) {
        kakunindskrhnnkakcdttjyymd = pKakunindskrhnnkakcdttjyymd;
    }

    private C_DsKrHnnKakCdTtYhKbn dskrhnnkakcdttyhkbn;

    public C_DsKrHnnKakCdTtYhKbn getDskrhnnkakcdttyhkbn() {
        return dskrhnnkakcdttyhkbn;
    }

    public void setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn pDskrhnnkakcdttyhkbn) {
        dskrhnnkakcdttyhkbn = pDskrhnnkakcdttyhkbn;
    }

    private C_DsKrHnnKakCdTtYhKbn inputdskrhnnkakcdttyhkbn;

    public C_DsKrHnnKakCdTtYhKbn getInputdskrhnnkakcdttyhkbn() {
        return inputdskrhnnkakcdttyhkbn;
    }

    public void setInputdskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn pInputdskrhnnkakcdttyhkbn) {
        inputdskrhnnkakcdttyhkbn = pInputdskrhnnkakcdttyhkbn;
    }

    private C_DsKrHnnKakCdTtYhKbn kakunindskrhnnkakcdttyhkbn;

    public C_DsKrHnnKakCdTtYhKbn getKakunindskrhnnkakcdttyhkbn() {
        return kakunindskrhnnkakcdttyhkbn;
    }

    public void setKakunindskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn pKakunindskrhnnkakcdttyhkbn) {
        kakunindskrhnnkakcdttyhkbn = pKakunindskrhnnkakcdttyhkbn;
    }

    private C_UmuKbn honpasswordumukbn;

    public C_UmuKbn getHonpasswordumukbn() {
        return honpasswordumukbn;
    }

    public void setHonpasswordumukbn(C_UmuKbn pHonpasswordumukbn) {
        honpasswordumukbn = pHonpasswordumukbn;
    }

    private C_UmuKbn kakuninhonpasswordumukbn;

    public C_UmuKbn getKakuninhonpasswordumukbn() {
        return kakuninhonpasswordumukbn;
    }

    public void setKakuninhonpasswordumukbn(C_UmuKbn pKakuninhonpasswordumukbn) {
        kakuninhonpasswordumukbn = pKakuninhonpasswordumukbn;
    }

    private BizDate dshnnkakcdsetymd;

    public BizDate getDshnnkakcdsetymd() {
        return dshnnkakcdsetymd;
    }

    public void setDshnnkakcdsetymd(BizDate pDshnnkakcdsetymd) {
        dshnnkakcdsetymd = pDshnnkakcdsetymd;
    }

    private BizDate kakunindshnnkakcdsetymd;

    public BizDate getKakunindshnnkakcdsetymd() {
        return kakunindshnnkakcdsetymd;
    }

    public void setKakunindshnnkakcdsetymd(BizDate pKakunindshnnkakcdsetymd) {
        kakunindshnnkakcdsetymd = pKakunindshnnkakcdsetymd;
    }

    private BizDate syokailoginymd;

    public BizDate getSyokailoginymd() {
        return syokailoginymd;
    }

    public void setSyokailoginymd(BizDate pSyokailoginymd) {
        syokailoginymd = pSyokailoginymd;
    }

    private String dispsyokailogintime;

    public String getDispsyokailogintime() {
        return dispsyokailogintime;
    }

    public void setDispsyokailogintime(String pDispsyokailogintime) {
        dispsyokailogintime = pDispsyokailogintime;
    }

    private C_BaitaiKbn syokailoginbaitaikbn;

    public C_BaitaiKbn getSyokailoginbaitaikbn() {
        return syokailoginbaitaikbn;
    }

    public void setSyokailoginbaitaikbn(C_BaitaiKbn pSyokailoginbaitaikbn) {
        syokailoginbaitaikbn = pSyokailoginbaitaikbn;
    }

    private BizDate saisinloginymd;

    public BizDate getSaisinloginymd() {
        return saisinloginymd;
    }

    public void setSaisinloginymd(BizDate pSaisinloginymd) {
        saisinloginymd = pSaisinloginymd;
    }

    private String dispsaisinlogintime;

    public String getDispsaisinlogintime() {
        return dispsaisinlogintime;
    }

    public void setDispsaisinlogintime(String pDispsaisinlogintime) {
        dispsaisinlogintime = pDispsaisinlogintime;
    }

    private C_BaitaiKbn saisinloginbaitaikbn;

    public C_BaitaiKbn getSaisinloginbaitaikbn() {
        return saisinloginbaitaikbn;
    }

    public void setSaisinloginbaitaikbn(C_BaitaiKbn pSaisinloginbaitaikbn) {
        saisinloginbaitaikbn = pSaisinloginbaitaikbn;
    }

    private Integer dshnnkakcderrorkaisuu;

    public Integer getDshnnkakcderrorkaisuu() {
        return dshnnkakcderrorkaisuu;
    }

    public void setDshnnkakcderrorkaisuu(Integer pDshnnkakcderrorkaisuu) {
        dshnnkakcderrorkaisuu = pDshnnkakcderrorkaisuu;
    }

    private Integer kakunindshnnkakcderrkaisuu;

    public Integer getKakunindshnnkakcderrkaisuu() {
        return kakunindshnnkakcderrkaisuu;
    }

    public void setKakunindshnnkakcderrkaisuu(Integer pKakunindshnnkakcderrkaisuu) {
        kakunindshnnkakcderrkaisuu = pKakunindshnnkakcderrkaisuu;
    }

    private Integer dskokyakunmerrorkaisuu;

    public Integer getDskokyakunmerrorkaisuu() {
        return dskokyakunmerrorkaisuu;
    }

    public void setDskokyakunmerrorkaisuu(Integer pDskokyakunmerrorkaisuu) {
        dskokyakunmerrorkaisuu = pDskokyakunmerrorkaisuu;
    }

    private Integer kakunindskoknmerrkaisuu;

    public Integer getKakunindskoknmerrkaisuu() {
        return kakunindskoknmerrkaisuu;
    }

    public void setKakunindskoknmerrkaisuu(Integer pKakunindskoknmerrkaisuu) {
        kakunindskoknmerrkaisuu = pKakunindskoknmerrkaisuu;
    }

    private Integer dskokyakuseiymderrorkaisuu;

    public Integer getDskokyakuseiymderrorkaisuu() {
        return dskokyakuseiymderrorkaisuu;
    }

    public void setDskokyakuseiymderrorkaisuu(Integer pDskokyakuseiymderrorkaisuu) {
        dskokyakuseiymderrorkaisuu = pDskokyakuseiymderrorkaisuu;
    }

    private Integer kakunindskokseiymderrkaisuu;

    public Integer getKakunindskokseiymderrkaisuu() {
        return kakunindskokseiymderrkaisuu;
    }

    public void setKakunindskokseiymderrkaisuu(Integer pKakunindskokseiymderrkaisuu) {
        kakunindskokseiymderrkaisuu = pKakunindskokseiymderrkaisuu;
    }

    private Integer dskokyakutelnoerrorkaisuu;

    public Integer getDskokyakutelnoerrorkaisuu() {
        return dskokyakutelnoerrorkaisuu;
    }

    public void setDskokyakutelnoerrorkaisuu(Integer pDskokyakutelnoerrorkaisuu) {
        dskokyakutelnoerrorkaisuu = pDskokyakutelnoerrorkaisuu;
    }

    private Integer kakunindskoktelnoerrkaisuu;

    public Integer getKakunindskoktelnoerrkaisuu() {
        return kakunindskoktelnoerrkaisuu;
    }

    public void setKakunindskoktelnoerrkaisuu(Integer pKakunindskoktelnoerrkaisuu) {
        kakunindskoktelnoerrkaisuu = pKakunindskoktelnoerrkaisuu;
    }

    private Integer dsmailaddressrenban;

    public Integer getDsmailaddressrenban() {
        return dsmailaddressrenban;
    }

    public void setDsmailaddressrenban(Integer pDsmailaddressrenban) {
        dsmailaddressrenban = pDsmailaddressrenban;
    }

    @MaxLength(max=100)
    @SingleByteStrings
    @Pattern(message="{pattern.MailAddress.message}", regex="^[\\w!#$%&'*+/=?^_{}\\\\|~-][\\w!#$%&'*+/=?^_{}\\\\|~\\.-]{0,63}@([\\w][\\w-]*\\.)+[\\w][\\w-]*$")
    private String dsmailaddress;

    public String getDsmailaddress() {
        return dsmailaddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDsmailaddress(String pDsmailaddress) {
        dsmailaddress = pDsmailaddress;
    }

    @MaxLength(max=100)
    @Pattern(message="{pattern.MailAddress.message}", regex="^[\\w!#$%&'*+/=?^_{}\\\\|~-][\\w!#$%&'*+/=?^_{}\\\\|~\\.-]{0,63}@([\\w][\\w-]*\\.)+[\\w][\\w-]*$")
    private String inputdsmailaddress;

    public String getInputdsmailaddress() {
        return inputdsmailaddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setInputdsmailaddress(String pInputdsmailaddress) {
        inputdsmailaddress = pInputdsmailaddress;
    }

    private String kakunindsmailaddress;

    public String getKakunindsmailaddress() {
        return kakunindsmailaddress;
    }

    public void setKakunindsmailaddress(String pKakunindsmailaddress) {
        kakunindsmailaddress = pKakunindsmailaddress;
    }

    private C_DsMailSousinJyoutaiKbn dsmailsousinjyoutaikbn;

    public C_DsMailSousinJyoutaiKbn getDsmailsousinjyoutaikbn() {
        return dsmailsousinjyoutaikbn;
    }

    public void setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn pDsmailsousinjyoutaikbn) {
        dsmailsousinjyoutaikbn = pDsmailsousinjyoutaikbn;
    }

    private C_DsMailSousinJyoutaiKbn inputdsmailsousinjtkbn;

    public C_DsMailSousinJyoutaiKbn getInputdsmailsousinjtkbn() {
        return inputdsmailsousinjtkbn;
    }

    public void setInputdsmailsousinjtkbn(C_DsMailSousinJyoutaiKbn pInputdsmailsousinjtkbn) {
        inputdsmailsousinjtkbn = pInputdsmailsousinjtkbn;
    }

    private C_DsMailSousinJyoutaiKbn kakunindsmailsousinjtkbn;

    public C_DsMailSousinJyoutaiKbn getKakunindsmailsousinjtkbn() {
        return kakunindsmailsousinjtkbn;
    }

    public void setKakunindsmailsousinjtkbn(C_DsMailSousinJyoutaiKbn pKakunindsmailsousinjtkbn) {
        kakunindsmailsousinjtkbn = pKakunindsmailsousinjtkbn;
    }

    private C_DsMailSousinTeisiRiyuuKbn dsmailsousintisrykbn;

    public C_DsMailSousinTeisiRiyuuKbn getDsmailsousintisrykbn() {
        return dsmailsousintisrykbn;
    }

    public void setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn pDsmailsousintisrykbn) {
        dsmailsousintisrykbn = pDsmailsousintisrykbn;
    }

    private C_DsMailSousinTeisiRiyuuKbn inputdsmailsousintisrykbn;

    public C_DsMailSousinTeisiRiyuuKbn getInputdsmailsousintisrykbn() {
        return inputdsmailsousintisrykbn;
    }

    public void setInputdsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn pInputdsmailsousintisrykbn) {
        inputdsmailsousintisrykbn = pInputdsmailsousintisrykbn;
    }

    private C_DsMailSousinTeisiRiyuuKbn kakunindsmailsousintisrykbn;

    public C_DsMailSousinTeisiRiyuuKbn getKakunindsmailsousintisrykbn() {
        return kakunindsmailsousintisrykbn;
    }

    public void setKakunindsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn pKakunindsmailsousintisrykbn) {
        kakunindsmailsousintisrykbn = pKakunindsmailsousintisrykbn;
    }

    private String dispdskousinymdtime;

    public String getDispdskousinymdtime() {
        return dispdskousinymdtime;
    }

    public void setDispdskousinymdtime(String pDispdskousinymdtime) {
        dispdskousinymdtime = pDispdskousinymdtime;
    }

    private String kakunindskousinymdtime;

    public String getKakunindskousinymdtime() {
        return kakunindskousinymdtime;
    }

    public void setKakunindskousinymdtime(String pKakunindskousinymdtime) {
        kakunindskousinymdtime = pKakunindskousinymdtime;
    }

    private C_SeisaHuyouHyj seisahuyouhyj;

    public C_SeisaHuyouHyj getSeisahuyouhyj() {
        return seisahuyouhyj;
    }

    public void setSeisahuyouhyj(C_SeisaHuyouHyj pSeisahuyouhyj) {
        seisahuyouhyj = pSeisahuyouhyj;
    }

    private C_SeisaHuyouHyj inputseisahuyouhyj;

    public C_SeisaHuyouHyj getInputseisahuyouhyj() {
        return inputseisahuyouhyj;
    }

    public void setInputseisahuyouhyj(C_SeisaHuyouHyj pInputseisahuyouhyj) {
        inputseisahuyouhyj = pInputseisahuyouhyj;
    }

    private C_SeisaHuyouHyj kakuninseisahuyouhyj;

    public C_SeisaHuyouHyj getKakuninseisahuyouhyj() {
        return kakuninseisahuyouhyj;
    }

    public void setKakuninseisahuyouhyj(C_SeisaHuyouHyj pKakuninseisahuyouhyj) {
        kakuninseisahuyouhyj = pKakuninseisahuyouhyj;
    }

    private BizDate lastjyuuhenymd;

    public BizDate getLastjyuuhenymd() {
        return lastjyuuhenymd;
    }

    @Trim("both")
    public void setLastjyuuhenymd(BizDate pLastjyuuhenymd) {
        lastjyuuhenymd = pLastjyuuhenymd;
    }

    private BizDate lastkykmeighnkymd;

    public BizDate getLastkykmeighnkymd() {
        return lastkykmeighnkymd;
    }

    public void setLastkykmeighnkymd(BizDate pLastkykmeighnkymd) {
        lastkykmeighnkymd = pLastkykmeighnkymd;
    }

    private String kykbtdispsyono;

    public String getKykbtdispsyono() {
        return kykbtdispsyono;
    }

    public void setKykbtdispsyono(String pKykbtdispsyono) {
        kykbtdispsyono = pKykbtdispsyono;
    }

    private String kykbtdispdskokno;

    public String getKykbtdispdskokno() {
        return kykbtdispdskokno;
    }

    public void setKykbtdispdskokno(String pKykbtdispdskokno) {
        kykbtdispdskokno = pKykbtdispdskokno;
    }

    private String kykbtdispsyouhnnm;

    public String getKykbtdispsyouhnnm() {
        return kykbtdispsyouhnnm;
    }

    public void setKykbtdispsyouhnnm(String pKykbtdispsyouhnnm) {
        kykbtdispsyouhnnm = pKykbtdispsyouhnnm;
    }

    private String kykbtdispkyknmkj;

    public String getKykbtdispkyknmkj() {
        return kykbtdispkyknmkj;
    }

    public void setKykbtdispkyknmkj(String pKykbtdispkyknmkj) {
        kykbtdispkyknmkj = pKykbtdispkyknmkj;
    }

    private String kykbtdispkyknmkn;

    public String getKykbtdispkyknmkn() {
        return kykbtdispkyknmkn;
    }

    public void setKykbtdispkyknmkn(String pKykbtdispkyknmkn) {
        kykbtdispkyknmkn = pKykbtdispkyknmkn;
    }

    private BizDate kykbtdispkykseiymd;

    public BizDate getKykbtdispkykseiymd() {
        return kykbtdispkykseiymd;
    }

    public void setKykbtdispkykseiymd(BizDate pKykbtdispkykseiymd) {
        kykbtdispkykseiymd = pKykbtdispkykseiymd;
    }

    private C_DsTrhkserviceRiyoujkKbn dstrhkserviceriyoujkkbn;

    public C_DsTrhkserviceRiyoujkKbn getDstrhkserviceriyoujkkbn() {
        return dstrhkserviceriyoujkkbn;
    }

    public void setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn pDstrhkserviceriyoujkkbn) {
        dstrhkserviceriyoujkkbn = pDstrhkserviceriyoujkkbn;
    }

    private C_DsTrhkserviceRiyoujkKbn kakunindstrhkserviceryjkkbn;

    public C_DsTrhkserviceRiyoujkKbn getKakunindstrhkserviceryjkkbn() {
        return kakunindstrhkserviceryjkkbn;
    }

    public void setKakunindstrhkserviceryjkkbn(C_DsTrhkserviceRiyoujkKbn pKakunindstrhkserviceryjkkbn) {
        kakunindstrhkserviceryjkkbn = pKakunindstrhkserviceryjkkbn;
    }

    private C_DsTrhkserviceTeisiRiyuuKbn dstrhkserviceteisiriyuukbn;

    public C_DsTrhkserviceTeisiRiyuuKbn getDstrhkserviceteisiriyuukbn() {
        return dstrhkserviceteisiriyuukbn;
    }

    public void setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn pDstrhkserviceteisiriyuukbn) {
        dstrhkserviceteisiriyuukbn = pDstrhkserviceteisiriyuukbn;
    }

    private C_DsTrhkserviceTeisiRiyuuKbn inputdstrhksvctisrykbn;

    public C_DsTrhkserviceTeisiRiyuuKbn getInputdstrhksvctisrykbn() {
        return inputdstrhksvctisrykbn;
    }

    public void setInputdstrhksvctisrykbn(C_DsTrhkserviceTeisiRiyuuKbn pInputdstrhksvctisrykbn) {
        inputdstrhksvctisrykbn = pInputdstrhksvctisrykbn;
    }

    private C_DsTrhkserviceTeisiRiyuuKbn kakunindstrhksvctisrykbn;

    public C_DsTrhkserviceTeisiRiyuuKbn getKakunindstrhksvctisrykbn() {
        return kakunindstrhksvctisrykbn;
    }

    public void setKakunindstrhksvctisrykbn(C_DsTrhkserviceTeisiRiyuuKbn pKakunindstrhksvctisrykbn) {
        kakunindstrhksvctisrykbn = pKakunindstrhksvctisrykbn;
    }

    private C_DsTrhkserviceKanyukeiroKbn dstrhkservicekanyukeirokbn;

    public C_DsTrhkserviceKanyukeiroKbn getDstrhkservicekanyukeirokbn() {
        return dstrhkservicekanyukeirokbn;
    }

    public void setDstrhkservicekanyukeirokbn(C_DsTrhkserviceKanyukeiroKbn pDstrhkservicekanyukeirokbn) {
        dstrhkservicekanyukeirokbn = pDstrhkservicekanyukeirokbn;
    }

    private C_KouzasyuruiKbn kzsyuruikbn;

    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }

    @Length(length=4)
    @Digit
    private String bankcd;

    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String banknmkj;

    public String getBanknmkj() {
        return banknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBanknmkj(String pBanknmkj) {
        banknmkj = pBanknmkj;
    }

    @Length(length=3)
    @Digit
    private String sitencd;

    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String sitennmkj;

    public String getSitennmkj() {
        return sitennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSitennmkj(String pSitennmkj) {
        sitennmkj = pSitennmkj;
    }

    private C_YokinKbn yokinkbn;

    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    @MaxLength(max=12)
    @HostInvalidCharacter
    private String kouzano;

    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private C_Kzdou kzdoukbn;

    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String kzmeiginmkn;

    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private String disptokuteitrhkansyono;

    public String getDisptokuteitrhkansyono() {
        return disptokuteitrhkansyono;
    }

    public void setDisptokuteitrhkansyono(String pDisptokuteitrhkansyono) {
        disptokuteitrhkansyono = pDisptokuteitrhkansyono;
    }

    private Integer tktrhkansyonoerrorkaisuu;

    public Integer getTktrhkansyonoerrorkaisuu() {
        return tktrhkansyonoerrorkaisuu;
    }

    public void setTktrhkansyonoerrorkaisuu(Integer pTktrhkansyonoerrorkaisuu) {
        tktrhkansyonoerrorkaisuu = pTktrhkansyonoerrorkaisuu;
    }

    private BizDate tokuteitrhkansyonosetymd;

    public BizDate getTokuteitrhkansyonosetymd() {
        return tokuteitrhkansyonosetymd;
    }

    public void setTokuteitrhkansyonosetymd(BizDate pTokuteitrhkansyonosetymd) {
        tokuteitrhkansyonosetymd = pTokuteitrhkansyonosetymd;
    }

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
    }
}
