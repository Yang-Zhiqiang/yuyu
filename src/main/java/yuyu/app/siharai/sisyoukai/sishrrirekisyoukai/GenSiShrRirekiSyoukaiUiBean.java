package yuyu.app.siharai.sisyoukai.sishrrirekisyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.def.classification.C_NoinitSyorizumiKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SibouBasyoKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 支払履歴照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiShrRirekiSyoukaiUiBean extends AbstractUiBean {

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

    private DataSource<SiharaiRirekiDataSourceBean> siharaiRirekiDataSource = new DataSource<>();
    public DataSource<SiharaiRirekiDataSourceBean> getSiharaiRirekiDataSource() {
        return siharaiRirekiDataSource;
    }

    @Deprecated
    public List<SiharaiRirekiDataSourceBean> getSiharaiRireki() {
        return siharaiRirekiDataSource.getDatas();
    }

    public void setSiharaiRireki(List<SiharaiRirekiDataSourceBean> pSiharaiRireki) {
        siharaiRirekiDataSource.setDatas(pSiharaiRireki, 10);
    }

    private DataSource<ProgresshistoryinfoDataSourceBean> progresshistoryinfoDataSource = new DataSource<>();
    public DataSource<ProgresshistoryinfoDataSourceBean> getProgresshistoryinfoDataSource() {
        return progresshistoryinfoDataSource;
    }

    @Deprecated
    public List<ProgresshistoryinfoDataSourceBean> getProgresshistoryinfo() {
        return progresshistoryinfoDataSource.getDatas();
    }

    public void setProgresshistoryinfo(List<ProgresshistoryinfoDataSourceBean> pProgresshistoryinfo) {
        progresshistoryinfoDataSource.setDatas(pProgresshistoryinfo);
    }

    private DataSource<SyoruiInfoListDataSourceBean> syoruiInfoListDataSource = new DataSource<>();
    public DataSource<SyoruiInfoListDataSourceBean> getSyoruiInfoListDataSource() {
        return syoruiInfoListDataSource;
    }

    @Deprecated
    public List<SyoruiInfoListDataSourceBean> getSyoruiInfoList() {
        return syoruiInfoListDataSource.getDatas();
    }

    public void setSyoruiInfoList(List<SyoruiInfoListDataSourceBean> pSyoruiInfoList) {
        syoruiInfoListDataSource.setDatas(pSyoruiInfoList);
    }

    private DataSource<ViewSindansyoinfoSibouInfo1DataSourceBean> viewSindansyoinfoSibouInfo1DataSource = new DataSource<>();
    public DataSource<ViewSindansyoinfoSibouInfo1DataSourceBean> getViewSindansyoinfoSibouInfo1DataSource() {
        return viewSindansyoinfoSibouInfo1DataSource;
    }

    @Deprecated
    public List<ViewSindansyoinfoSibouInfo1DataSourceBean> getViewSindansyoinfoSibouInfo1() {
        return viewSindansyoinfoSibouInfo1DataSource.getDatas();
    }

    public void setViewSindansyoinfoSibouInfo1(List<ViewSindansyoinfoSibouInfo1DataSourceBean> pViewSindansyoinfoSibouInfo1) {
        viewSindansyoinfoSibouInfo1DataSource.setDatas(pViewSindansyoinfoSibouInfo1);
    }

    private DataSource<HktshrMeisaisInfoDataSourceBean> hktshrMeisaisInfoDataSource = new DataSource<>();
    public DataSource<HktshrMeisaisInfoDataSourceBean> getHktshrMeisaisInfoDataSource() {
        return hktshrMeisaisInfoDataSource;
    }

    @Deprecated
    public List<HktshrMeisaisInfoDataSourceBean> getHktshrMeisaisInfo() {
        return hktshrMeisaisInfoDataSource.getDatas();
    }

    public void setHktshrMeisaisInfo(List<HktshrMeisaisInfoDataSourceBean> pHktshrMeisaisInfo) {
        hktshrMeisaisInfoDataSource.setDatas(pHktshrMeisaisInfo);
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

    private String syoukaibtn;

    public String getSyoukaibtn() {
        return syoukaibtn;
    }

    public void setSyoukaibtn(String pSyoukaibtn) {
        syoukaibtn = pSyoukaibtn;
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

    private String allhyoujibtn;

    public String getAllhyoujibtn() {
        return allhyoujibtn;
    }

    public void setAllhyoujibtn(String pAllhyoujibtn) {
        allhyoujibtn = pAllhyoujibtn;
    }

    private String imageid;

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String pImageid) {
        imageid = pImageid;
    }

    private C_SeikyuusyaKbn seikyuusyakbn;

    public C_SeikyuusyaKbn getSeikyuusyakbn() {
        return seikyuusyakbn;
    }

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn) {
        seikyuusyakbn = pSeikyuusyakbn;
    }

    private C_SiHonninKakninKekkaKbn sihonninkakninkbn;

    public C_SiHonninKakninKekkaKbn getSihonninkakninkbn() {
        return sihonninkakninkbn;
    }

    public void setSihonninkakninkbn(C_SiHonninKakninKekkaKbn pSihonninkakninkbn) {
        sihonninkakninkbn = pSihonninkakninkbn;
    }

    @ValidDate
    private BizDate seikyuusyaseiymd;

    public BizDate getSeikyuusyaseiymd() {
        return seikyuusyaseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSeikyuusyaseiymd(BizDate pSeikyuusyaseiymd) {
        seikyuusyaseiymd = pSeikyuusyaseiymd;
    }

    private C_Seibetu seikyuusyasei;

    public C_Seibetu getSeikyuusyasei() {
        return seikyuusyasei;
    }

    public void setSeikyuusyasei(C_Seibetu pSeikyuusyasei) {
        seikyuusyasei = pSeikyuusyasei;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String seikyuusyanmkn;

    public String getSeikyuusyanmkn() {
        return seikyuusyanmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSeikyuusyanmkn(String pSeikyuusyanmkn) {
        seikyuusyanmkn = pSeikyuusyanmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String seikyuusyanmkj;

    public String getSeikyuusyanmkj() {
        return seikyuusyanmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSeikyuusyanmkj(String pSeikyuusyanmkj) {
        seikyuusyanmkj = pSeikyuusyanmkj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String saikennmkj;

    public String getSaikennmkj() {
        return saikennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikennmkj(String pSaikennmkj) {
        saikennmkj = pSaikennmkj;
    }

    @Length(length=7)
    @Digit
    private String saikennyno;

    public String getSaikennyno() {
        return saikennyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSaikennyno(String pSaikennyno) {
        saikennyno = pSaikennyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String saikenadr1kj;

    public String getSaikenadr1kj() {
        return saikenadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikenadr1kj(String pSaikenadr1kj) {
        saikenadr1kj = pSaikenadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String saikenadr2kj;

    public String getSaikenadr2kj() {
        return saikenadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikenadr2kj(String pSaikenadr2kj) {
        saikenadr2kj = pSaikenadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String saikenadr3kj;

    public String getSaikenadr3kj() {
        return saikenadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikenadr3kj(String pSaikenadr3kj) {
        saikenadr3kj = pSaikenadr3kj;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String skskknnmkn;

    public String getSkskknnmkn() {
        return skskknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSkskknnmkn(String pSkskknnmkn) {
        skskknnmkn = pSkskknnmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String skskknnmkj;

    public String getSkskknnmkj() {
        return skskknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSkskknnmkj(String pSkskknnmkj) {
        skskknnmkj = pSkskknnmkj;
    }

    private C_SkskknsyubetuKbn skskknsyubetu;

    public C_SkskknsyubetuKbn getSkskknsyubetu() {
        return skskknsyubetu;
    }

    public void setSkskknsyubetu(C_SkskknsyubetuKbn pSkskknsyubetu) {
        skskknsyubetu = pSkskknsyubetu;
    }

    private C_SouhusakiKbn souhusakikbn;

    public C_SouhusakiKbn getSouhusakikbn() {
        return souhusakikbn;
    }

    public void setSouhusakikbn(C_SouhusakiKbn pSouhusakikbn) {
        souhusakikbn = pSouhusakikbn;
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

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
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

    private Boolean sateikaksaigaikanousei;

    public Boolean getSateikaksaigaikanousei() {
        return (sateikaksaigaikanousei == null) ? Boolean.FALSE : sateikaksaigaikanousei;
    }

    public void setSateikaksaigaikanousei(Boolean pSateikaksaigaikanousei) {
        sateikaksaigaikanousei = (pSateikaksaigaikanousei == null) ? Boolean.FALSE : pSateikaksaigaikanousei;
    }

    private C_UmuKbn sateikaksaigaikanouseikbn;

    public C_UmuKbn getSateikaksaigaikanouseikbn() {
        return sateikaksaigaikanouseikbn;
    }

    public void setSateikaksaigaikanouseikbn(C_UmuKbn pSateikaksaigaikanouseikbn) {
        sateikaksaigaikanouseikbn = pSateikaksaigaikanouseikbn;
    }

    private Boolean sateikakkaigaisb;

    public Boolean getSateikakkaigaisb() {
        return (sateikakkaigaisb == null) ? Boolean.FALSE : sateikakkaigaisb;
    }

    public void setSateikakkaigaisb(Boolean pSateikakkaigaisb) {
        sateikakkaigaisb = (pSateikakkaigaisb == null) ? Boolean.FALSE : pSateikakkaigaisb;
    }

    private C_UmuKbn sateikakkaigaisbkbn;

    public C_UmuKbn getSateikakkaigaisbkbn() {
        return sateikakkaigaisbkbn;
    }

    public void setSateikakkaigaisbkbn(C_UmuKbn pSateikakkaigaisbkbn) {
        sateikakkaigaisbkbn = pSateikakkaigaisbkbn;
    }

    private Boolean sateikakhusyousi;

    public Boolean getSateikakhusyousi() {
        return (sateikakhusyousi == null) ? Boolean.FALSE : sateikakhusyousi;
    }

    public void setSateikakhusyousi(Boolean pSateikakhusyousi) {
        sateikakhusyousi = (pSateikakhusyousi == null) ? Boolean.FALSE : pSateikakhusyousi;
    }

    private C_UmuKbn sateikakhusyousikbn;

    public C_UmuKbn getSateikakhusyousikbn() {
        return sateikakhusyousikbn;
    }

    public void setSateikakhusyousikbn(C_UmuKbn pSateikakhusyousikbn) {
        sateikakhusyousikbn = pSateikakhusyousikbn;
    }

    private Boolean sateikakmeigihnk;

    public Boolean getSateikakmeigihnk() {
        return (sateikakmeigihnk == null) ? Boolean.FALSE : sateikakmeigihnk;
    }

    public void setSateikakmeigihnk(Boolean pSateikakmeigihnk) {
        sateikakmeigihnk = (pSateikakmeigihnk == null) ? Boolean.FALSE : pSateikakmeigihnk;
    }

    private C_YouhiKbn sateikakmeigihnkkbn;

    public C_YouhiKbn getSateikakmeigihnkkbn() {
        return sateikakmeigihnkkbn;
    }

    public void setSateikakmeigihnkkbn(C_YouhiKbn pSateikakmeigihnkkbn) {
        sateikakmeigihnkkbn = pSateikakmeigihnkkbn;
    }

    private C_SUketoriHouhouKbn suketorihouhoukbn;

    public C_SUketoriHouhouKbn getSuketorihouhoukbn() {
        return suketorihouhoukbn;
    }

    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn) {
        suketorihouhoukbn = pSuketorihouhoukbn;
    }

    private C_SiharaiTuukaKbn siharaituukakbn;

    public C_SiharaiTuukaKbn getSiharaituukakbn() {
        return siharaituukakbn;
    }

    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukakbn) {
        siharaituukakbn = pSiharaituukakbn;
    }

    private C_GeninKbn geninkbn;

    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    @ValidDate
    private BizDate sibouymd;

    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    private C_SibouBasyoKbn siboubasyokbn;

    public C_SibouBasyoKbn getSiboubasyokbn() {
        return siboubasyokbn;
    }

    public void setSiboubasyokbn(C_SibouBasyoKbn pSiboubasyokbn) {
        siboubasyokbn = pSiboubasyokbn;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String siboubasyo;

    public String getSiboubasyo() {
        return siboubasyo;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSiboubasyo(String pSiboubasyo) {
        siboubasyo = pSiboubasyo;
    }

    @Range(min="0", max="99")
    private Integer sindansyomaisuu;

    public Integer getSindansyomaisuu() {
        return sindansyomaisuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSindansyomaisuu(Integer pSindansyomaisuu) {
        sindansyomaisuu = pSindansyomaisuu;
    }

    private BizCurrency sindansyoshrgk;

    public BizCurrency getSindansyoshrgk() {
        return sindansyoshrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSindansyoshrgk(BizCurrency pSindansyoshrgk) {
        sindansyoshrgk = pSindansyoshrgk;
    }

    @ValidDate
    private BizDate tyakkinymd;

    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private C_KanryotuutioutKbn shrdtlsyooutkbn;

    public C_KanryotuutioutKbn getShrdtlsyooutkbn() {
        return shrdtlsyooutkbn;
    }

    public void setShrdtlsyooutkbn(C_KanryotuutioutKbn pShrdtlsyooutkbn) {
        shrdtlsyooutkbn = pShrdtlsyooutkbn;
    }

    private C_HassouKbn hassoukbn;

    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    @Length(length=3)
    @Digit
    private String uktmnmeigibangou;

    public String getUktmnmeigibangou() {
        return uktmnmeigibangou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktmnmeigibangou(String pUktmnmeigibangou) {
        uktmnmeigibangou = pUktmnmeigibangou;
    }

    @Length(length=3)
    @Digit
    private String kykmnmeigibangou;

    public String getKykmnmeigibangou() {
        return kykmnmeigibangou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykmnmeigibangou(String pKykmnmeigibangou) {
        kykmnmeigibangou = pKykmnmeigibangou;
    }

    private C_SiinKbn siinkbn;

    public C_SiinKbn getSiinkbn() {
        return siinkbn;
    }

    public void setSiinkbn(C_SiinKbn pSiinkbn) {
        siinkbn = pSiinkbn;
    }

    private C_Tuukasyu shrtuukasyu;

    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizDate shrkwsratekjnymd;

    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    private BizNumber shrkwsrate;

    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private BizDate gaikaknsnkwsratekjymd;

    public BizDate getGaikaknsnkwsratekjymd() {
        return gaikaknsnkwsratekjymd;
    }

    public void setGaikaknsnkwsratekjymd(BizDate pGaikaknsnkwsratekjymd) {
        gaikaknsnkwsratekjymd = pGaikaknsnkwsratekjymd;
    }

    private BizNumber gaikaknsnkwsrate;

    public BizNumber getGaikaknsnkwsrate() {
        return gaikaknsnkwsrate;
    }

    public void setGaikaknsnkwsrate(BizNumber pGaikaknsnkwsrate) {
        gaikaknsnkwsrate = pGaikaknsnkwsrate;
    }

    @ValidDate
    private BizDate dispsyoruiukeymd;

    public BizDate getDispsyoruiukeymd() {
        return dispsyoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyoruiukeymd(BizDate pDispsyoruiukeymd) {
        dispsyoruiukeymd = pDispsyoruiukeymd;
    }

    @ValidDate
    private BizDate disphubikanryouymd;

    public BizDate getDisphubikanryouymd() {
        return disphubikanryouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDisphubikanryouymd(BizDate pDisphubikanryouymd) {
        disphubikanryouymd = pDisphubikanryouymd;
    }

    @ValidDate
    private BizDate shrymd;

    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private C_SinsaGendoKknKbn dispsinsagendokknkbn;

    public C_SinsaGendoKknKbn getDispsinsagendokknkbn() {
        return dispsinsagendokknkbn;
    }

    public void setDispsinsagendokknkbn(C_SinsaGendoKknKbn pDispsinsagendokknkbn) {
        dispsinsagendokknkbn = pDispsinsagendokknkbn;
    }

    @Range(min="0", max="999")
    private Integer disprkktydnnissuu;

    public Integer getDisprkktydnnissuu() {
        return disprkktydnnissuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDisprkktydnnissuu(Integer pDisprkktydnnissuu) {
        disprkktydnnissuu = pDisprkktydnnissuu;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency shrgk;

    public BizCurrency getShrgk() {
        return shrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrgk(BizCurrency pShrgk) {
        shrgk = pShrgk;
    }

    private BizCurrency hokenkngkgoukei;

    public BizCurrency getHokenkngkgoukei() {
        return hokenkngkgoukei;
    }

    public void setHokenkngkgoukei(BizCurrency pHokenkngkgoukei) {
        hokenkngkgoukei = pHokenkngkgoukei;
    }

    private BizCurrency haitoukin;

    public BizCurrency getHaitoukin() {
        return haitoukin;
    }

    public void setHaitoukin(BizCurrency pHaitoukin) {
        haitoukin = pHaitoukin;
    }

    private BizCurrency sonotahaitoukin;

    public BizCurrency getSonotahaitoukin() {
        return sonotahaitoukin;
    }

    public void setSonotahaitoukin(BizCurrency pSonotahaitoukin) {
        sonotahaitoukin = pSonotahaitoukin;
    }

    private String mikeikapgaitoukkn;

    public String getMikeikapgaitoukkn() {
        return mikeikapgaitoukkn;
    }

    public void setMikeikapgaitoukkn(String pMikeikapgaitoukkn) {
        mikeikapgaitoukkn = pMikeikapgaitoukkn;
    }

    private BizCurrency mikeikap;

    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
    }

    private String misyuupgaitoukkn;

    public String getMisyuupgaitoukkn() {
        return misyuupgaitoukkn;
    }

    public void setMisyuupgaitoukkn(String pMisyuupgaitoukkn) {
        misyuupgaitoukkn = pMisyuupgaitoukkn;
    }

    private BizCurrency misyuup;

    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency pMisyuup) {
        misyuup = pMisyuup;
    }

    private BizCurrency zennouseisankgk;

    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    public void setZennouseisankgk(BizCurrency pZennouseisankgk) {
        zennouseisankgk = pZennouseisankgk;
    }

    private BizCurrency azukarikingk;

    public BizCurrency getAzukarikingk() {
        return azukarikingk;
    }

    public void setAzukarikingk(BizCurrency pAzukarikingk) {
        azukarikingk = pAzukarikingk;
    }

    private BizCurrency krkgk;

    public BizCurrency getKrkgk() {
        return krkgk;
    }

    public void setKrkgk(BizCurrency pKrkgk) {
        krkgk = pKrkgk;
    }

    @ValidDate
    private BizDate tienrisokukisanymd;

    public BizDate getTienrisokukisanymd() {
        return tienrisokukisanymd;
    }

    @Trim("both")
    public void setTienrisokukisanymd(BizDate pTienrisokukisanymd) {
        tienrisokukisanymd = pTienrisokukisanymd;
    }

    @Range(min="0", max="99999")
    @NaturalNumber
    private Integer tienrsknissuu;

    public Integer getTienrsknissuu() {
        return tienrsknissuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTienrsknissuu(Integer pTienrsknissuu) {
        tienrsknissuu = pTienrsknissuu;
    }

    private BizCurrency shrtienrsk;

    public BizCurrency getShrtienrsk() {
        return shrtienrsk;
    }

    public void setShrtienrsk(BizCurrency pShrtienrsk) {
        shrtienrsk = pShrtienrsk;
    }

    private BizCurrency yenshrgk;

    public BizCurrency getYenshrgk() {
        return yenshrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenshrgk(BizCurrency pYenshrgk) {
        yenshrgk = pYenshrgk;
    }

    private BizCurrency yenhkgkgoukei;

    public BizCurrency getYenhkgkgoukei() {
        return yenhkgkgoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhkgkgoukei(BizCurrency pYenhkgkgoukei) {
        yenhkgkgoukei = pYenhkgkgoukei;
    }

    private BizCurrency yenkahaitoukin;

    public BizCurrency getYenkahaitoukin() {
        return yenkahaitoukin;
    }

    public void setYenkahaitoukin(BizCurrency pYenkahaitoukin) {
        yenkahaitoukin = pYenkahaitoukin;
    }

    private BizCurrency yenkasonotahaitoukin;

    public BizCurrency getYenkasonotahaitoukin() {
        return yenkasonotahaitoukin;
    }

    public void setYenkasonotahaitoukin(BizCurrency pYenkasonotahaitoukin) {
        yenkasonotahaitoukin = pYenkasonotahaitoukin;
    }

    private String yenkamikeikapgaitoukkn;

    public String getYenkamikeikapgaitoukkn() {
        return yenkamikeikapgaitoukkn;
    }

    public void setYenkamikeikapgaitoukkn(String pYenkamikeikapgaitoukkn) {
        yenkamikeikapgaitoukkn = pYenkamikeikapgaitoukkn;
    }

    private BizCurrency yenkamikeikap;

    public BizCurrency getYenkamikeikap() {
        return yenkamikeikap;
    }

    public void setYenkamikeikap(BizCurrency pYenkamikeikap) {
        yenkamikeikap = pYenkamikeikap;
    }

    private String yenkamisyuupgaitoukkn;

    public String getYenkamisyuupgaitoukkn() {
        return yenkamisyuupgaitoukkn;
    }

    public void setYenkamisyuupgaitoukkn(String pYenkamisyuupgaitoukkn) {
        yenkamisyuupgaitoukkn = pYenkamisyuupgaitoukkn;
    }

    private BizCurrency yenkamisyuup;

    public BizCurrency getYenkamisyuup() {
        return yenkamisyuup;
    }

    public void setYenkamisyuup(BizCurrency pYenkamisyuup) {
        yenkamisyuup = pYenkamisyuup;
    }

    private BizCurrency yenkazennouseisankgk;

    public BizCurrency getYenkazennouseisankgk() {
        return yenkazennouseisankgk;
    }

    public void setYenkazennouseisankgk(BizCurrency pYenkazennouseisankgk) {
        yenkazennouseisankgk = pYenkazennouseisankgk;
    }

    private BizCurrency yenkaazukarikingk;

    public BizCurrency getYenkaazukarikingk() {
        return yenkaazukarikingk;
    }

    public void setYenkaazukarikingk(BizCurrency pYenkaazukarikingk) {
        yenkaazukarikingk = pYenkaazukarikingk;
    }

    private BizCurrency yenkakrkgk;

    public BizCurrency getYenkakrkgk() {
        return yenkakrkgk;
    }

    public void setYenkakrkgk(BizCurrency pYenkakrkgk) {
        yenkakrkgk = pYenkakrkgk;
    }

    @ValidDate
    private BizDate yentienrisokukisanymd;

    public BizDate getYentienrisokukisanymd() {
        return yentienrisokukisanymd;
    }

    @Trim("both")
    public void setYentienrisokukisanymd(BizDate pYentienrisokukisanymd) {
        yentienrisokukisanymd = pYentienrisokukisanymd;
    }

    @Range(min="0", max="99999")
    @NaturalNumber
    private Integer yentienrsknissuu;

    public Integer getYentienrsknissuu() {
        return yentienrsknissuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYentienrsknissuu(Integer pYentienrsknissuu) {
        yentienrsknissuu = pYentienrsknissuu;
    }

    private BizCurrency yenshrtienrsk;

    public BizCurrency getYenshrtienrsk() {
        return yenshrtienrsk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenshrtienrsk(BizCurrency pYenshrtienrsk) {
        yenshrtienrsk = pYenshrtienrsk;
    }

    private C_ZeitratkiKbn zeitratkikbn;

    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn) {
        zeitratkikbn = pZeitratkikbn;
    }

    private BizCurrency goukeihituyoukeihi;

    public BizCurrency getGoukeihituyoukeihi() {
        return goukeihituyoukeihi;
    }

    public void setGoukeihituyoukeihi(BizCurrency pGoukeihituyoukeihi) {
        goukeihituyoukeihi = pGoukeihituyoukeihi;
    }

    private Integer kykhnkkaisuu;

    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
    }

    private BizCurrency shrkykhtykeihi;

    public BizCurrency getShrkykhtykeihi() {
        return shrkykhtykeihi;
    }

    public void setShrkykhtykeihi(BizCurrency pShrkykhtykeihi) {
        shrkykhtykeihi = pShrkykhtykeihi;
    }

    @Pattern(regex=("([0-5])"))
    @SingleByteStrings
    private String ippanhanteitensuu1;

    public String getIppanhanteitensuu1() {
        return ippanhanteitensuu1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu1(String pIppanhanteitensuu1) {
        ippanhanteitensuu1 = pIppanhanteitensuu1;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String ippanhanteicomment1;

    public String getIppanhanteicomment1() {
        return ippanhanteicomment1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment1(String pIppanhanteicomment1) {
        ippanhanteicomment1 = pIppanhanteicomment1;
    }

    @Pattern(regex=("([0-5])"))
    @SingleByteStrings
    private String ippanhanteitensuu2;

    public String getIppanhanteitensuu2() {
        return ippanhanteitensuu2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu2(String pIppanhanteitensuu2) {
        ippanhanteitensuu2 = pIppanhanteitensuu2;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String ippanhanteicomment2;

    public String getIppanhanteicomment2() {
        return ippanhanteicomment2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment2(String pIppanhanteicomment2) {
        ippanhanteicomment2 = pIppanhanteicomment2;
    }

    @Pattern(regex=("([013])"))
    @SingleByteStrings
    private String ippanhanteitensuu3;

    public String getIppanhanteitensuu3() {
        return ippanhanteitensuu3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu3(String pIppanhanteitensuu3) {
        ippanhanteitensuu3 = pIppanhanteitensuu3;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String ippanhanteicomment3;

    public String getIppanhanteicomment3() {
        return ippanhanteicomment3;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment3(String pIppanhanteicomment3) {
        ippanhanteicomment3 = pIppanhanteicomment3;
    }

    @Pattern(regex=("([0-2])"))
    @SingleByteStrings
    private String ippanhanteitensuu4;

    public String getIppanhanteitensuu4() {
        return ippanhanteitensuu4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu4(String pIppanhanteitensuu4) {
        ippanhanteitensuu4 = pIppanhanteitensuu4;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String ippanhanteicomment4;

    public String getIppanhanteicomment4() {
        return ippanhanteicomment4;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment4(String pIppanhanteicomment4) {
        ippanhanteicomment4 = pIppanhanteicomment4;
    }

    @Pattern(regex=("([0-2])"))
    @SingleByteStrings
    private String ippanhanteitensuu5;

    public String getIppanhanteitensuu5() {
        return ippanhanteitensuu5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu5(String pIppanhanteitensuu5) {
        ippanhanteitensuu5 = pIppanhanteitensuu5;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String ippanhanteicomment5;

    public String getIppanhanteicomment5() {
        return ippanhanteicomment5;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment5(String pIppanhanteicomment5) {
        ippanhanteicomment5 = pIppanhanteicomment5;
    }

    @Pattern(regex=("([0-1])"))
    @SingleByteStrings
    private String ippanhanteitensuu6;

    public String getIppanhanteitensuu6() {
        return ippanhanteitensuu6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu6(String pIppanhanteitensuu6) {
        ippanhanteitensuu6 = pIppanhanteitensuu6;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String ippanhanteicomment6;

    public String getIppanhanteicomment6() {
        return ippanhanteicomment6;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment6(String pIppanhanteicomment6) {
        ippanhanteicomment6 = pIppanhanteicomment6;
    }

    @MaxLength(max=2)
    @Digit
    private String ippanhanteitensuugoukei;

    public String getIppanhanteitensuugoukei() {
        return ippanhanteitensuugoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuugoukei(String pIppanhanteitensuugoukei) {
        ippanhanteitensuugoukei = pIppanhanteitensuugoukei;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String ippanhanteigoukeicomment;

    public String getIppanhanteigoukeicomment() {
        return ippanhanteigoukeicomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteigoukeicomment(String pIppanhanteigoukeicomment) {
        ippanhanteigoukeicomment = pIppanhanteigoukeicomment;
    }

    private Boolean kokuhancheck1;

    public Boolean getKokuhancheck1() {
        return (kokuhancheck1 == null) ? Boolean.FALSE : kokuhancheck1;
    }

    public void setKokuhancheck1(Boolean pKokuhancheck1) {
        kokuhancheck1 = (pKokuhancheck1 == null) ? Boolean.FALSE : pKokuhancheck1;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String kokuhanchecomment1;

    public String getKokuhanchecomment1() {
        return kokuhanchecomment1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment1(String pKokuhanchecomment1) {
        kokuhanchecomment1 = pKokuhanchecomment1;
    }

    private Boolean kokuhancheck2;

    public Boolean getKokuhancheck2() {
        return (kokuhancheck2 == null) ? Boolean.FALSE : kokuhancheck2;
    }

    public void setKokuhancheck2(Boolean pKokuhancheck2) {
        kokuhancheck2 = (pKokuhancheck2 == null) ? Boolean.FALSE : pKokuhancheck2;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String kokuhanchecomment2;

    public String getKokuhanchecomment2() {
        return kokuhanchecomment2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment2(String pKokuhanchecomment2) {
        kokuhanchecomment2 = pKokuhanchecomment2;
    }

    private Boolean kokuhancheck3;

    public Boolean getKokuhancheck3() {
        return (kokuhancheck3 == null) ? Boolean.FALSE : kokuhancheck3;
    }

    public void setKokuhancheck3(Boolean pKokuhancheck3) {
        kokuhancheck3 = (pKokuhancheck3 == null) ? Boolean.FALSE : pKokuhancheck3;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String kokuhanchecomment3;

    public String getKokuhanchecomment3() {
        return kokuhanchecomment3;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment3(String pKokuhanchecomment3) {
        kokuhanchecomment3 = pKokuhanchecomment3;
    }

    private Boolean kokuhancheck4;

    public Boolean getKokuhancheck4() {
        return (kokuhancheck4 == null) ? Boolean.FALSE : kokuhancheck4;
    }

    public void setKokuhancheck4(Boolean pKokuhancheck4) {
        kokuhancheck4 = (pKokuhancheck4 == null) ? Boolean.FALSE : pKokuhancheck4;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String kokuhanchecomment4;

    public String getKokuhanchecomment4() {
        return kokuhanchecomment4;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment4(String pKokuhanchecomment4) {
        kokuhanchecomment4 = pKokuhanchecomment4;
    }

    private Boolean kokuhancheck5;

    public Boolean getKokuhancheck5() {
        return (kokuhancheck5 == null) ? Boolean.FALSE : kokuhancheck5;
    }

    public void setKokuhancheck5(Boolean pKokuhancheck5) {
        kokuhancheck5 = (pKokuhancheck5 == null) ? Boolean.FALSE : pKokuhancheck5;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String kokuhanchecomment5;

    public String getKokuhanchecomment5() {
        return kokuhanchecomment5;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment5(String pKokuhanchecomment5) {
        kokuhanchecomment5 = pKokuhanchecomment5;
    }

    private Boolean kokuhancheck6;

    public Boolean getKokuhancheck6() {
        return (kokuhancheck6 == null) ? Boolean.FALSE : kokuhancheck6;
    }

    public void setKokuhancheck6(Boolean pKokuhancheck6) {
        kokuhancheck6 = (pKokuhancheck6 == null) ? Boolean.FALSE : pKokuhancheck6;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String kokuhanchecomment6;

    public String getKokuhanchecomment6() {
        return kokuhanchecomment6;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment6(String pKokuhanchecomment6) {
        kokuhanchecomment6 = pKokuhanchecomment6;
    }

    private Boolean kokuhancheck7;

    public Boolean getKokuhancheck7() {
        return (kokuhancheck7 == null) ? Boolean.FALSE : kokuhancheck7;
    }

    public void setKokuhancheck7(Boolean pKokuhancheck7) {
        kokuhancheck7 = (pKokuhancheck7 == null) ? Boolean.FALSE : pKokuhancheck7;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String kokuhanchecomment7;

    public String getKokuhanchecomment7() {
        return kokuhanchecomment7;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment7(String pKokuhanchecomment7) {
        kokuhanchecomment7 = pKokuhanchecomment7;
    }

    private Boolean kokuhancheck8;

    public Boolean getKokuhancheck8() {
        return (kokuhancheck8 == null) ? Boolean.FALSE : kokuhancheck8;
    }

    public void setKokuhancheck8(Boolean pKokuhancheck8) {
        kokuhancheck8 = (pKokuhancheck8 == null) ? Boolean.FALSE : pKokuhancheck8;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String kokuhanchecomment8;

    public String getKokuhanchecomment8() {
        return kokuhanchecomment8;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment8(String pKokuhanchecomment8) {
        kokuhanchecomment8 = pKokuhanchecomment8;
    }

    private Boolean juukasitucheck1;

    public Boolean getJuukasitucheck1() {
        return (juukasitucheck1 == null) ? Boolean.FALSE : juukasitucheck1;
    }

    public void setJuukasitucheck1(Boolean pJuukasitucheck1) {
        juukasitucheck1 = (pJuukasitucheck1 == null) ? Boolean.FALSE : pJuukasitucheck1;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String juukasitucheckcomment1;

    public String getJuukasitucheckcomment1() {
        return juukasitucheckcomment1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setJuukasitucheckcomment1(String pJuukasitucheckcomment1) {
        juukasitucheckcomment1 = pJuukasitucheckcomment1;
    }

    private Boolean juukasitucheck2;

    public Boolean getJuukasitucheck2() {
        return (juukasitucheck2 == null) ? Boolean.FALSE : juukasitucheck2;
    }

    public void setJuukasitucheck2(Boolean pJuukasitucheck2) {
        juukasitucheck2 = (pJuukasitucheck2 == null) ? Boolean.FALSE : pJuukasitucheck2;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String juukasitucheckcomment2;

    public String getJuukasitucheckcomment2() {
        return juukasitucheckcomment2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setJuukasitucheckcomment2(String pJuukasitucheckcomment2) {
        juukasitucheckcomment2 = pJuukasitucheckcomment2;
    }

    private Boolean juukasitucheck3;

    public Boolean getJuukasitucheck3() {
        return (juukasitucheck3 == null) ? Boolean.FALSE : juukasitucheck3;
    }

    public void setJuukasitucheck3(Boolean pJuukasitucheck3) {
        juukasitucheck3 = (pJuukasitucheck3 == null) ? Boolean.FALSE : pJuukasitucheck3;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String juukasitucheckcomment3;

    public String getJuukasitucheckcomment3() {
        return juukasitucheckcomment3;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setJuukasitucheckcomment3(String pJuukasitucheckcomment3) {
        juukasitucheckcomment3 = pJuukasitucheckcomment3;
    }

    private Boolean juukasitucheck4;

    public Boolean getJuukasitucheck4() {
        return (juukasitucheck4 == null) ? Boolean.FALSE : juukasitucheck4;
    }

    public void setJuukasitucheck4(Boolean pJuukasitucheck4) {
        juukasitucheck4 = (pJuukasitucheck4 == null) ? Boolean.FALSE : pJuukasitucheck4;
    }

    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    private String juukasitucheckcomment4;

    public String getJuukasitucheckcomment4() {
        return juukasitucheckcomment4;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setJuukasitucheckcomment4(String pJuukasitucheckcomment4) {
        juukasitucheckcomment4 = pJuukasitucheckcomment4;
    }

    @ValidDate
    private BizDate kaijokigenymd;

    public BizDate getKaijokigenymd() {
        return kaijokigenymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaijokigenymd(BizDate pKaijokigenymd) {
        kaijokigenymd = pKaijokigenymd;
    }

    private C_MeihenYuukouMukouKbn meihenyuukoumukoukbn;

    public C_MeihenYuukouMukouKbn getMeihenyuukoumukoukbn() {
        return meihenyuukoumukoukbn;
    }

    public void setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn pMeihenyuukoumukoukbn) {
        meihenyuukoumukoukbn = pMeihenyuukoumukoukbn;
    }

    private C_MeihenUktKbn meihenuktkbn;

    public C_MeihenUktKbn getMeihenuktkbn() {
        return meihenuktkbn;
    }

    public void setMeihenuktkbn(C_MeihenUktKbn pMeihenuktkbn) {
        meihenuktkbn = pMeihenuktkbn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String meihenuktnm;

    public String getMeihenuktnm() {
        return meihenuktnm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setMeihenuktnm(String pMeihenuktnm) {
        meihenuktnm = pMeihenuktnm;
    }

    private C_NoinitUmuKbn tratkihuryouumukbn;

    public C_NoinitUmuKbn getTratkihuryouumukbn() {
        return tratkihuryouumukbn;
    }

    public void setTratkihuryouumukbn(C_NoinitUmuKbn pTratkihuryouumukbn) {
        tratkihuryouumukbn = pTratkihuryouumukbn;
    }

    private C_NoinitYouhiKbn gyousinkaisouyouhikbn;

    public C_NoinitYouhiKbn getGyousinkaisouyouhikbn() {
        return gyousinkaisouyouhikbn;
    }

    public void setGyousinkaisouyouhikbn(C_NoinitYouhiKbn pGyousinkaisouyouhikbn) {
        gyousinkaisouyouhikbn = pGyousinkaisouyouhikbn;
    }

    private C_NoinitSyorizumiKbn aireqdaityoukisaikbn;

    public C_NoinitSyorizumiKbn getAireqdaityoukisaikbn() {
        return aireqdaityoukisaikbn;
    }

    public void setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn pAireqdaityoukisaikbn) {
        aireqdaityoukisaikbn = pAireqdaityoukisaikbn;
    }

    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    private String tratkihuryoucomment;

    public String getTratkihuryoucomment() {
        return tratkihuryoucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTratkihuryoucomment(String pTratkihuryoucomment) {
        tratkihuryoucomment = pTratkihuryoucomment;
    }

    private C_NoinitUmuKbn bengosikenkaiumukbn;

    public C_NoinitUmuKbn getBengosikenkaiumukbn() {
        return bengosikenkaiumukbn;
    }

    public void setBengosikenkaiumukbn(C_NoinitUmuKbn pBengosikenkaiumukbn) {
        bengosikenkaiumukbn = pBengosikenkaiumukbn;
    }

    private C_NoinitUmuKbn kujyouumukbn;

    public C_NoinitUmuKbn getKujyouumukbn() {
        return kujyouumukbn;
    }

    public void setKujyouumukbn(C_NoinitUmuKbn pKujyouumukbn) {
        kujyouumukbn = pKujyouumukbn;
    }

    private C_NoinitUmuKbn jimumissumukbn;

    public C_NoinitUmuKbn getJimumissumukbn() {
        return jimumissumukbn;
    }

    public void setJimumissumukbn(C_NoinitUmuKbn pJimumissumukbn) {
        jimumissumukbn = pJimumissumukbn;
    }

    private C_NoinitYouhiKbn kyhgksitukaisouyouhikbn;

    public C_NoinitYouhiKbn getKyhgksitukaisouyouhikbn() {
        return kyhgksitukaisouyouhikbn;
    }

    public void setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn pKyhgksitukaisouyouhikbn) {
        kyhgksitukaisouyouhikbn = pKyhgksitukaisouyouhikbn;
    }

    private C_NoinitUmuKbn betusibouumukbn;

    public C_NoinitUmuKbn getBetusibouumukbn() {
        return betusibouumukbn;
    }

    public void setBetusibouumukbn(C_NoinitUmuKbn pBetusibouumukbn) {
        betusibouumukbn = pBetusibouumukbn;
    }

    @MultiByteStrings
    @MaxLength(max=40)
    @InvalidCharacter
    private String betusiboucomment;

    public String getBetusiboucomment() {
        return betusiboucomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setBetusiboucomment(String pBetusiboucomment) {
        betusiboucomment = pBetusiboucomment;
    }

    private C_NoinitUmuKbn betusoukiumukbn;

    public C_NoinitUmuKbn getBetusoukiumukbn() {
        return betusoukiumukbn;
    }

    public void setBetusoukiumukbn(C_NoinitUmuKbn pBetusoukiumukbn) {
        betusoukiumukbn = pBetusoukiumukbn;
    }

    @MultiByteStrings
    @MaxLength(max=40)
    @InvalidCharacter
    private String betusoukicomment;

    public String getBetusoukicomment() {
        return betusoukicomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setBetusoukicomment(String pBetusoukicomment) {
        betusoukicomment = pBetusoukicomment;
    }

    private C_SyorikekkaKbn syorikekkakbn;

    public C_SyorikekkaKbn getSyorikekkakbn() {
        return syorikekkakbn;
    }

    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        syorikekkakbn = pSyorikekkakbn;
    }

    private C_HushrGeninKbn hushrgeninkbn;

    public C_HushrGeninKbn getHushrgeninkbn() {
        return hushrgeninkbn;
    }

    public void setHushrgeninkbn(C_HushrGeninKbn pHushrgeninkbn) {
        hushrgeninkbn = pHushrgeninkbn;
    }

    private C_YouhiblnkKbn sessyouyhkbn;

    public C_YouhiblnkKbn getSessyouyhkbn() {
        return sessyouyhkbn;
    }

    public void setSessyouyhkbn(C_YouhiblnkKbn pSessyouyhkbn) {
        sessyouyhkbn = pSessyouyhkbn;
    }

    @Length(length=3)
    @SingleByteStrings
    private String sessyousisyacd;

    public String getSessyousisyacd() {
        return sessyousisyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSessyousisyacd(String pSessyousisyacd) {
        sessyousisyacd = pSessyousisyacd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String sisyanm;

    public String getSisyanm() {
        return sisyanm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSisyanm(String pSisyanm) {
        sisyanm = pSisyanm;
    }

    private C_BlnktkumuKbn saigaimousideumukbn;

    public C_BlnktkumuKbn getSaigaimousideumukbn() {
        return saigaimousideumukbn;
    }

    public void setSaigaimousideumukbn(C_BlnktkumuKbn pSaigaimousideumukbn) {
        saigaimousideumukbn = pSaigaimousideumukbn;
    }

    private C_SindansyoRyouShrYouhiKbn sindansyoryoushryouhikbn;

    public C_SindansyoRyouShrYouhiKbn getSindansyoryoushryouhikbn() {
        return sindansyoryoushryouhikbn;
    }

    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn) {
        sindansyoryoushryouhikbn = pSindansyoryoushryouhikbn;
    }

    @ValidDate
    private BizDate kaiketuymd;

    public BizDate getKaiketuymd() {
        return kaiketuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiketuymd(BizDate pKaiketuymd) {
        kaiketuymd = pKaiketuymd;
    }

    private String modorubtnbykensaku;

    public String getModorubtnbykensaku() {
        return modorubtnbykensaku;
    }

    public void setModorubtnbykensaku(String pModorubtnbykensaku) {
        modorubtnbykensaku = pModorubtnbykensaku;
    }
}
