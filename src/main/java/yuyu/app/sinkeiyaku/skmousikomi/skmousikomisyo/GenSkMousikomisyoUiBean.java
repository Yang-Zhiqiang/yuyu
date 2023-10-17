package yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.NaturalNumberBizCalcable;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.def.classification.C_KoureiMndnHukusuukaiKbn;
import yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkgnsHosyourituKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.Modulus10w21;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 申込書入力 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkMousikomisyoUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

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

    private String nyuuryokusaisyoukaibtn;

    public String getNyuuryokusaisyoukaibtn() {
        return nyuuryokusaisyoukaibtn;
    }

    public void setNyuuryokusaisyoukaibtn(String pNyuuryokusaisyoukaibtn) {
        nyuuryokusaisyoukaibtn = pNyuuryokusaisyoukaibtn;
    }

    private String hubisyousaibtn;

    public String getHubisyousaibtn() {
        return hubisyousaibtn;
    }

    public void setHubisyousaibtn(String pHubisyousaibtn) {
        hubisyousaibtn = pHubisyousaibtn;
    }

    private String hubisyousaibtn2;

    public String getHubisyousaibtn2() {
        return hubisyousaibtn2;
    }

    public void setHubisyousaibtn2(String pHubisyousaibtn2) {
        hubisyousaibtn2 = pHubisyousaibtn2;
    }

    private String keiyakusyajouhoubtn;

    public String getKeiyakusyajouhoubtn() {
        return keiyakusyajouhoubtn;
    }

    public void setKeiyakusyajouhoubtn(String pKeiyakusyajouhoubtn) {
        keiyakusyajouhoubtn = pKeiyakusyajouhoubtn;
    }

    private String tusinsakijouhoubtn;

    public String getTusinsakijouhoubtn() {
        return tusinsakijouhoubtn;
    }

    public void setTusinsakijouhoubtn(String pTusinsakijouhoubtn) {
        tusinsakijouhoubtn = pTusinsakijouhoubtn;
    }

    private String hihokensyajouhoubtn;

    public String getHihokensyajouhoubtn() {
        return hihokensyajouhoubtn;
    }

    public void setHihokensyajouhoubtn(String pHihokensyajouhoubtn) {
        hihokensyajouhoubtn = pHihokensyajouhoubtn;
    }

    private String uketorininbtn;

    public String getUketorininbtn() {
        return uketorininbtn;
    }

    public void setUketorininbtn(String pUketorininbtn) {
        uketorininbtn = pUketorininbtn;
    }

    private String hosyouinfobtn;

    public String getHosyouinfobtn() {
        return hosyouinfobtn;
    }

    public void setHosyouinfobtn(String pHosyouinfobtn) {
        hosyouinfobtn = pHosyouinfobtn;
    }

    private String siteidairininbtn;

    public String getSiteidairininbtn() {
        return siteidairininbtn;
    }

    public void setSiteidairininbtn(String pSiteidairininbtn) {
        siteidairininbtn = pSiteidairininbtn;
    }

    private String dairitenjouhoubtn;

    public String getDairitenjouhoubtn() {
        return dairitenjouhoubtn;
    }

    public void setDairitenjouhoubtn(String pDairitenjouhoubtn) {
        dairitenjouhoubtn = pDairitenjouhoubtn;
    }

    private String vktifdispjimutetuzukinm;

    public String getVktifdispjimutetuzukinm() {
        return vktifdispjimutetuzukinm;
    }

    public void setVktifdispjimutetuzukinm(String pVktifdispjimutetuzukinm) {
        vktifdispjimutetuzukinm = pVktifdispjimutetuzukinm;
    }

    private String vktifdisptasknm;

    public String getVktifdisptasknm() {
        return vktifdisptasknm;
    }

    public void setVktifdisptasknm(String pVktifdisptasknm) {
        vktifdisptasknm = pVktifdisptasknm;
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

    @MousikomiNo
    private String aitemosno;

    public String getAitemosno() {
        return aitemosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAitemosno(String pAitemosno) {
        aitemosno = pAitemosno;
    }

    @SyoukenNo
    private String doujikaiyakusyono;

    public String getDoujikaiyakusyono() {
        return doujikaiyakusyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDoujikaiyakusyono(String pDoujikaiyakusyono) {
        doujikaiyakusyono = pDoujikaiyakusyono;
    }

    @ValidDate
    private BizDate mosymd;

    public BizDate getMosymd() {
        return mosymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    @Length(length=3)
    @SingleByteStrings
    @AlphaDigit
    private String jimuyoucd;

    public String getJimuyoucd() {
        return jimuyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimuyoucd(String pJimuyoucd) {
        jimuyoucd = pJimuyoucd;
    }

    private BizDate kykymd;

    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    @ValidDateYm
    private BizDateYM bosyuuym;

    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private BizDate sknnkaisiymd;

    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDateYM seisekiym;

    public BizDateYM getSeisekiym() {
        return seisekiym;
    }

    @Trim("both")
    public void setSeisekiym(BizDateYM pSeisekiym) {
        seisekiym = pSeisekiym;
    }

    private C_MosUketukeKbn mosuketukekbn;

    public C_MosUketukeKbn getMosuketukekbn() {
        return mosuketukekbn;
    }

    public void setMosuketukekbn(C_MosUketukeKbn pMosuketukekbn) {
        mosuketukekbn = pMosuketukekbn;
    }

    private String hknsyuruinomosinput;

    public String getHknsyuruinomosinput() {
        return hknsyuruinomosinput;
    }

    public void setHknsyuruinomosinput(String pHknsyuruinomosinput) {
        hknsyuruinomosinput = pHknsyuruinomosinput;
    }

    private C_AisyoumeiKbn aisyoumeikbn;

    public C_AisyoumeiKbn getAisyoumeikbn() {
        return aisyoumeikbn;
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        aisyoumeikbn = pAisyoumeikbn;
    }

    private String aisyoumei;

    public String getAisyoumei() {
        return aisyoumei;
    }

    public void setAisyoumei(String pAisyoumei) {
        aisyoumei = pAisyoumei;
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

    private C_KykKbn kykkbn;

    public C_KykKbn getKykkbn() {
        return kykkbn;
    }

    public void setKykkbn(C_KykKbn pKykkbn) {
        kykkbn = pKykkbn;
    }

    private C_YakkanJyuryouKbn yakkanjyuryouhoukbn;

    public C_YakkanJyuryouKbn getYakkanjyuryouhoukbn() {
        return yakkanjyuryouhoukbn;
    }

    public void setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn pYakkanjyuryouhoukbn) {
        yakkanjyuryouhoukbn = pYakkanjyuryouhoukbn;
    }

    private C_FatcasnsiKbn fatcasnsikbn;

    public C_FatcasnsiKbn getFatcasnsikbn() {
        return fatcasnsikbn;
    }

    public void setFatcasnsikbn(C_FatcasnsiKbn pFatcasnsikbn) {
        fatcasnsikbn = pFatcasnsikbn;
    }

    private C_BikkjnssinfoKbn bikkjnssinfokbn;

    public C_BikkjnssinfoKbn getBikkjnssinfokbn() {
        return bikkjnssinfokbn;
    }

    public void setBikkjnssinfokbn(C_BikkjnssinfoKbn pBikkjnssinfokbn) {
        bikkjnssinfokbn = pBikkjnssinfokbn;
    }

    @MaxLength(max=9)
    @SingleByteStrings
    @AlphaDigit
    private String bikknzsyno;

    public String getBikknzsyno() {
        return bikknzsyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBikknzsyno(String pBikknzsyno) {
        bikknzsyno = pBikknzsyno;
    }

    private C_AeoisnsiKbn aeoisnsikbn;

    public C_AeoisnsiKbn getAeoisnsikbn() {
        return aeoisnsikbn;
    }

    public void setAeoisnsikbn(C_AeoisnsiKbn pAeoisnsikbn) {
        aeoisnsikbn = pAeoisnsikbn;
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

    private Boolean kyknmkjkhuka;

    public Boolean getKyknmkjkhuka() {
        return (kyknmkjkhuka == null) ? Boolean.FALSE : kyknmkjkhuka;
    }

    public void setKyknmkjkhuka(Boolean pKyknmkjkhuka) {
        kyknmkjkhuka = (pKyknmkjkhuka == null) ? Boolean.FALSE : pKyknmkjkhuka;
    }

    private C_KjkhukaKbn kyknmkjkhukakbn;

    public C_KjkhukaKbn getKyknmkjkhukakbn() {
        return kyknmkjkhukakbn;
    }

    public void setKyknmkjkhukakbn(C_KjkhukaKbn pKyknmkjkhukakbn) {
        kyknmkjkhukakbn = pKyknmkjkhukakbn;
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

    private C_Kyksei kyksei;

    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private Integer kyknen;

    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    private C_Tdk kyktdk;

    public C_Tdk getKyktdk() {
        return kyktdk;
    }

    public void setKyktdk(C_Tdk pKyktdk) {
        kyktdk = pKyktdk;
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

    private Boolean hhknnmkjkhuka;

    public Boolean getHhknnmkjkhuka() {
        return (hhknnmkjkhuka == null) ? Boolean.FALSE : hhknnmkjkhuka;
    }

    public void setHhknnmkjkhuka(Boolean pHhknnmkjkhuka) {
        hhknnmkjkhuka = (pHhknnmkjkhuka == null) ? Boolean.FALSE : pHhknnmkjkhuka;
    }

    private C_KjkhukaKbn hhknnmkjkhukakbn;

    public C_KjkhukaKbn getHhknnmkjkhukakbn() {
        return hhknnmkjkhukakbn;
    }

    public void setHhknnmkjkhukakbn(C_KjkhukaKbn pHhknnmkjkhukakbn) {
        hhknnmkjkhukakbn = pHhknnmkjkhukakbn;
    }

    @ValidDate
    private BizDate hhknseiymd;

    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private C_Hhknsei hhknsei;

    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    @NaturalNumber
    private Integer hhknnen;

    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private Boolean tsindousitei;

    public Boolean getTsindousitei() {
        return (tsindousitei == null) ? Boolean.FALSE : tsindousitei;
    }

    public void setTsindousitei(Boolean pTsindousitei) {
        tsindousitei = (pTsindousitei == null) ? Boolean.FALSE : pTsindousitei;
    }

    private C_TsindousiteiKbn tsindousiteikbn;

    public C_TsindousiteiKbn getTsindousiteikbn() {
        return tsindousiteikbn;
    }

    public void setTsindousiteikbn(C_TsindousiteiKbn pTsindousiteikbn) {
        tsindousiteikbn = pTsindousiteikbn;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String hhknyno;

    public String getHhknyno() {
        return hhknyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknyno(String pHhknyno) {
        hhknyno = pHhknyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknadr1kj;

    public String getHhknadr1kj() {
        return hhknadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr1kj(String pHhknadr1kj) {
        hhknadr1kj = pHhknadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknadr2kj;

    public String getHhknadr2kj() {
        return hhknadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr2kj(String pHhknadr2kj) {
        hhknadr2kj = pHhknadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknadr3kj;

    public String getHhknadr3kj() {
        return hhknadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr3kj(String pHhknadr3kj) {
        hhknadr3kj = pHhknadr3kj;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String hhkntelno;

    public String getHhkntelno() {
        return hhkntelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntelno(String pHhkntelno) {
        hhkntelno = pHhkntelno;
    }

    @ValidDate
    private BizDate kktymd;

    public BizDate getKktymd() {
        return kktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktymd(BizDate pKktymd) {
        kktymd = pKktymd;
    }

    @MaxLength(max=3)
    @AlphaDigit
    @HostInvalidCharacter
    private String hhknsykgycd;

    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknsykgycd(String pHhknsykgycd) {
        hhknsykgycd = pHhknsykgycd;
    }

    private String hhknsykgynm;

    public String getHhknsykgynm() {
        return hhknsykgynm;
    }

    public void setHhknsykgynm(String pHhknsykgynm) {
        hhknsykgynm = pHhknsykgynm;
    }

    private C_NensyuuKbn hhknnensyuukbn;

    public C_NensyuuKbn getHhknnensyuukbn() {
        return hhknnensyuukbn;
    }

    public void setHhknnensyuukbn(C_NensyuuKbn pHhknnensyuukbn) {
        hhknnensyuukbn = pHhknnensyuukbn;
    }

    private C_UktKbn nenkinuktkbn;

    public C_UktKbn getNenkinuktkbn() {
        return nenkinuktkbn;
    }

    public void setNenkinuktkbn(C_UktKbn pNenkinuktkbn) {
        nenkinuktkbn = pNenkinuktkbn;
    }

    @Range(min="0", max="99")
    private Integer sbuktnin;

    public Integer getSbuktnin() {
        return sbuktnin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktnin(Integer pSbuktnin) {
        sbuktnin = pSbuktnin;
    }

    private C_UktKbn sbuktkbn1;

    public C_UktKbn getSbuktkbn1() {
        return sbuktkbn1;
    }

    public void setSbuktkbn1(C_UktKbn pSbuktkbn1) {
        sbuktkbn1 = pSbuktkbn1;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String sbuktnmkn1;

    public String getSbuktnmkn1() {
        return sbuktnmkn1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn1(String pSbuktnmkn1) {
        sbuktnmkn1 = pSbuktnmkn1;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String sbuktnmkj1;

    public String getSbuktnmkj1() {
        return sbuktnmkj1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj1(String pSbuktnmkj1) {
        sbuktnmkj1 = pSbuktnmkj1;
    }

    private Boolean sbuktnmkjkhuka1;

    public Boolean getSbuktnmkjkhuka1() {
        return (sbuktnmkjkhuka1 == null) ? Boolean.FALSE : sbuktnmkjkhuka1;
    }

    public void setSbuktnmkjkhuka1(Boolean pSbuktnmkjkhuka1) {
        sbuktnmkjkhuka1 = (pSbuktnmkjkhuka1 == null) ? Boolean.FALSE : pSbuktnmkjkhuka1;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn1;

    public C_KjkhukaKbn getSbuktnmkjhukakbn1() {
        return sbuktnmkjhukakbn1;
    }

    public void setSbuktnmkjhukakbn1(C_KjkhukaKbn pSbuktnmkjhukakbn1) {
        sbuktnmkjhukakbn1 = pSbuktnmkjhukakbn1;
    }

    @ValidDate
    private BizDate sbuktseiymd1;

    public BizDate getSbuktseiymd1() {
        return sbuktseiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd1(BizDate pSbuktseiymd1) {
        sbuktseiymd1 = pSbuktseiymd1;
    }

    private C_Tdk sbukttdk1;

    public C_Tdk getSbukttdk1() {
        return sbukttdk1;
    }

    public void setSbukttdk1(C_Tdk pSbukttdk1) {
        sbukttdk1 = pSbukttdk1;
    }

    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    private BizNumber sbuktbnwari1;

    public BizNumber getSbuktbnwari1() {
        return sbuktbnwari1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktbnwari1(BizNumber pSbuktbnwari1) {
        sbuktbnwari1 = pSbuktbnwari1;
    }

    private C_UktKbn sbuktkbn2;

    public C_UktKbn getSbuktkbn2() {
        return sbuktkbn2;
    }

    public void setSbuktkbn2(C_UktKbn pSbuktkbn2) {
        sbuktkbn2 = pSbuktkbn2;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String sbuktnmkn2;

    public String getSbuktnmkn2() {
        return sbuktnmkn2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn2(String pSbuktnmkn2) {
        sbuktnmkn2 = pSbuktnmkn2;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String sbuktnmkj2;

    public String getSbuktnmkj2() {
        return sbuktnmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj2(String pSbuktnmkj2) {
        sbuktnmkj2 = pSbuktnmkj2;
    }

    private Boolean sbuktnmkjkhuka2;

    public Boolean getSbuktnmkjkhuka2() {
        return (sbuktnmkjkhuka2 == null) ? Boolean.FALSE : sbuktnmkjkhuka2;
    }

    public void setSbuktnmkjkhuka2(Boolean pSbuktnmkjkhuka2) {
        sbuktnmkjkhuka2 = (pSbuktnmkjkhuka2 == null) ? Boolean.FALSE : pSbuktnmkjkhuka2;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn2;

    public C_KjkhukaKbn getSbuktnmkjhukakbn2() {
        return sbuktnmkjhukakbn2;
    }

    public void setSbuktnmkjhukakbn2(C_KjkhukaKbn pSbuktnmkjhukakbn2) {
        sbuktnmkjhukakbn2 = pSbuktnmkjhukakbn2;
    }

    @ValidDate
    private BizDate sbuktseiymd2;

    public BizDate getSbuktseiymd2() {
        return sbuktseiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd2(BizDate pSbuktseiymd2) {
        sbuktseiymd2 = pSbuktseiymd2;
    }

    private C_Tdk sbukttdk2;

    public C_Tdk getSbukttdk2() {
        return sbukttdk2;
    }

    public void setSbukttdk2(C_Tdk pSbukttdk2) {
        sbukttdk2 = pSbukttdk2;
    }

    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    private BizNumber sbuktbnwari2;

    public BizNumber getSbuktbnwari2() {
        return sbuktbnwari2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktbnwari2(BizNumber pSbuktbnwari2) {
        sbuktbnwari2 = pSbuktbnwari2;
    }

    private C_UktKbn sbuktkbn3;

    public C_UktKbn getSbuktkbn3() {
        return sbuktkbn3;
    }

    public void setSbuktkbn3(C_UktKbn pSbuktkbn3) {
        sbuktkbn3 = pSbuktkbn3;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String sbuktnmkn3;

    public String getSbuktnmkn3() {
        return sbuktnmkn3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn3(String pSbuktnmkn3) {
        sbuktnmkn3 = pSbuktnmkn3;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String sbuktnmkj3;

    public String getSbuktnmkj3() {
        return sbuktnmkj3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj3(String pSbuktnmkj3) {
        sbuktnmkj3 = pSbuktnmkj3;
    }

    private Boolean sbuktnmkjkhuka3;

    public Boolean getSbuktnmkjkhuka3() {
        return (sbuktnmkjkhuka3 == null) ? Boolean.FALSE : sbuktnmkjkhuka3;
    }

    public void setSbuktnmkjkhuka3(Boolean pSbuktnmkjkhuka3) {
        sbuktnmkjkhuka3 = (pSbuktnmkjkhuka3 == null) ? Boolean.FALSE : pSbuktnmkjkhuka3;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn3;

    public C_KjkhukaKbn getSbuktnmkjhukakbn3() {
        return sbuktnmkjhukakbn3;
    }

    public void setSbuktnmkjhukakbn3(C_KjkhukaKbn pSbuktnmkjhukakbn3) {
        sbuktnmkjhukakbn3 = pSbuktnmkjhukakbn3;
    }

    @ValidDate
    private BizDate sbuktseiymd3;

    public BizDate getSbuktseiymd3() {
        return sbuktseiymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd3(BizDate pSbuktseiymd3) {
        sbuktseiymd3 = pSbuktseiymd3;
    }

    private C_Tdk sbukttdk3;

    public C_Tdk getSbukttdk3() {
        return sbukttdk3;
    }

    public void setSbukttdk3(C_Tdk pSbukttdk3) {
        sbukttdk3 = pSbukttdk3;
    }

    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    private BizNumber sbuktbnwari3;

    public BizNumber getSbuktbnwari3() {
        return sbuktbnwari3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktbnwari3(BizNumber pSbuktbnwari3) {
        sbuktbnwari3 = pSbuktbnwari3;
    }

    private C_UktKbn sbuktkbn4;

    public C_UktKbn getSbuktkbn4() {
        return sbuktkbn4;
    }

    public void setSbuktkbn4(C_UktKbn pSbuktkbn4) {
        sbuktkbn4 = pSbuktkbn4;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String sbuktnmkn4;

    public String getSbuktnmkn4() {
        return sbuktnmkn4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn4(String pSbuktnmkn4) {
        sbuktnmkn4 = pSbuktnmkn4;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String sbuktnmkj4;

    public String getSbuktnmkj4() {
        return sbuktnmkj4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj4(String pSbuktnmkj4) {
        sbuktnmkj4 = pSbuktnmkj4;
    }

    private Boolean sbuktnmkjkhuka4;

    public Boolean getSbuktnmkjkhuka4() {
        return (sbuktnmkjkhuka4 == null) ? Boolean.FALSE : sbuktnmkjkhuka4;
    }

    public void setSbuktnmkjkhuka4(Boolean pSbuktnmkjkhuka4) {
        sbuktnmkjkhuka4 = (pSbuktnmkjkhuka4 == null) ? Boolean.FALSE : pSbuktnmkjkhuka4;
    }

    private C_KjkhukaKbn sbuktnmkjhukakbn4;

    public C_KjkhukaKbn getSbuktnmkjhukakbn4() {
        return sbuktnmkjhukakbn4;
    }

    public void setSbuktnmkjhukakbn4(C_KjkhukaKbn pSbuktnmkjhukakbn4) {
        sbuktnmkjhukakbn4 = pSbuktnmkjhukakbn4;
    }

    @ValidDate
    private BizDate sbuktseiymd4;

    public BizDate getSbuktseiymd4() {
        return sbuktseiymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktseiymd4(BizDate pSbuktseiymd4) {
        sbuktseiymd4 = pSbuktseiymd4;
    }

    private C_Tdk sbukttdk4;

    public C_Tdk getSbukttdk4() {
        return sbukttdk4;
    }

    public void setSbukttdk4(C_Tdk pSbukttdk4) {
        sbukttdk4 = pSbukttdk4;
    }

    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    private BizNumber sbuktbnwari4;

    public BizNumber getSbuktbnwari4() {
        return sbuktbnwari4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktbnwari4(BizNumber pSbuktbnwari4) {
        sbuktbnwari4 = pSbuktbnwari4;
    }

    @Range(min="0", max="99")
    private Integer syuhrkkkn;

    public Integer getSyuhrkkkn() {
        return syuhrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyuhrkkkn(Integer pSyuhrkkkn) {
        syuhrkkkn = pSyuhrkkkn;
    }

    private C_HrkkknsmnKbn syuhrkkknsmnkbn;

    public C_HrkkknsmnKbn getSyuhrkkknsmnkbn() {
        return syuhrkkknsmnkbn;
    }

    public void setSyuhrkkknsmnkbn(C_HrkkknsmnKbn pSyuhrkkknsmnkbn) {
        syuhrkkknsmnkbn = pSyuhrkkknsmnkbn;
    }

    @Range(min="0", max="99")
    private Integer syuhknkkn;

    public Integer getSyuhknkkn() {
        return syuhknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyuhknkkn(Integer pSyuhknkkn) {
        syuhknkkn = pSyuhknkkn;
    }

    private C_HknkknsmnKbn syuhknkknsmnkbn;

    public C_HknkknsmnKbn getSyuhknkknsmnkbn() {
        return syuhknkknsmnkbn;
    }

    public void setSyuhknkknsmnkbn(C_HknkknsmnKbn pSyuhknkknsmnkbn) {
        syuhknkknsmnkbn = pSyuhknkknsmnkbn;
    }

    private String syudai1hknkknmosinput;

    public String getSyudai1hknkknmosinput() {
        return syudai1hknkknmosinput;
    }

    public void setSyudai1hknkknmosinput(String pSyudai1hknkknmosinput) {
        syudai1hknkknmosinput = pSyudai1hknkknmosinput;
    }

    private C_Sdpd sdpdkbn;

    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private String nenkinsyumosinput;

    public String getNenkinsyumosinput() {
        return nenkinsyumosinput;
    }

    public void setNenkinsyumosinput(String pNenkinsyumosinput) {
        nenkinsyumosinput = pNenkinsyumosinput;
    }

    private String zenkizennouumumosinput;

    public String getZenkizennouumumosinput() {
        return zenkizennouumumosinput;
    }

    public void setZenkizennouumumosinput(String pZenkizennouumumosinput) {
        zenkizennouumumosinput = pZenkizennouumumosinput;
    }

    @Range(min="0", max="999")
    private Integer znnkai;

    public Integer getZnnkai() {
        return znnkai;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnkai(Integer pZnnkai) {
        znnkai = pZnnkai;
    }

    private String hrkkaisuumosinput;

    public String getHrkkaisuumosinput() {
        return hrkkaisuumosinput;
    }

    public void setHrkkaisuumosinput(String pHrkkaisuumosinput) {
        hrkkaisuumosinput = pHrkkaisuumosinput;
    }

    private C_Hrkkeiro hrkkeiro;

    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_FstphrkkeiroKbn fstphrkkeirokbn;

    public C_FstphrkkeiroKbn getFstphrkkeirokbn() {
        return fstphrkkeirokbn;
    }

    public void setFstphrkkeirokbn(C_FstphrkkeiroKbn pFstphrkkeirokbn) {
        fstphrkkeirokbn = pFstphrkkeirokbn;
    }

    private String ikkatubaraikaisuumosinput;

    public String getIkkatubaraikaisuumosinput() {
        return ikkatubaraikaisuumosinput;
    }

    public void setIkkatubaraikaisuumosinput(String pIkkatubaraikaisuumosinput) {
        ikkatubaraikaisuumosinput = pIkkatubaraikaisuumosinput;
    }

    private String kyktuukasyumosinput;

    public String getKyktuukasyumosinput() {
        return kyktuukasyumosinput;
    }

    public void setKyktuukasyumosinput(String pKyktuukasyumosinput) {
        kyktuukasyumosinput = pKyktuukasyumosinput;
    }

    private String hrktuukasyumosinput;

    public String getHrktuukasyumosinput() {
        return hrktuukasyumosinput;
    }

    public void setHrktuukasyumosinput(String pHrktuukasyumosinput) {
        hrktuukasyumosinput = pHrktuukasyumosinput;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency syukihons;

    public BizCurrency getSyukihons() {
        return syukihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyukihons(BizCurrency pSyukihons) {
        syukihons = pSyukihons;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency hrktuukasyukykp;

    public BizCurrency getHrktuukasyukykp() {
        return hrktuukasyukykp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrktuukasyukykp(BizCurrency pHrktuukasyukykp) {
        hrktuukasyukykp = pHrktuukasyukykp;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency mosikkatup;

    public BizCurrency getMosikkatup() {
        return mosikkatup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosikkatup(BizCurrency pMosikkatup) {
        mosikkatup = pMosikkatup;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency mossyukykp;

    public BizCurrency getMossyukykp() {
        return mossyukykp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMossyukykp(BizCurrency pMossyukykp) {
        mossyukykp = pMossyukykp;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency moszennoupsyokaiari;

    public BizCurrency getMoszennoupsyokaiari() {
        return moszennoupsyokaiari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMoszennoupsyokaiari(BizCurrency pMoszennoupsyokaiari) {
        moszennoupsyokaiari = pMoszennoupsyokaiari;
    }

    private C_TumitatekinHaibunWariKbn sisuuhaibunwarikbn;

    public C_TumitatekinHaibunWariKbn getSisuuhaibunwarikbn() {
        return sisuuhaibunwarikbn;
    }

    public void setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn pSisuuhaibunwarikbn) {
        sisuuhaibunwarikbn = pSisuuhaibunwarikbn;
    }

    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    private String sisuunm;

    public String getSisuunm() {
        return sisuunm;
    }

    @Trim("both")
    public void setSisuunm(String pSisuunm) {
        sisuunm = pSisuunm;
    }

    private C_TumitatekinHaibunWariKbn teirituhaibunwarikbn;

    public C_TumitatekinHaibunWariKbn getTeirituhaibunwarikbn() {
        return teirituhaibunwarikbn;
    }

    public void setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn pTeirituhaibunwarikbn) {
        teirituhaibunwarikbn = pTeirituhaibunwarikbn;
    }

    private String sueokikknmosinput;

    public String getSueokikknmosinput() {
        return sueokikknmosinput;
    }

    public void setSueokikknmosinput(String pSueokikknmosinput) {
        sueokikknmosinput = pSueokikknmosinput;
    }

    private C_NkgnsHosyourituKbn nkgnshosyouritukbn;

    public C_NkgnsHosyourituKbn getNkgnshosyouritukbn() {
        return nkgnshosyouritukbn;
    }

    public void setNkgnshosyouritukbn(C_NkgnsHosyourituKbn pNkgnshosyouritukbn) {
        nkgnshosyouritukbn = pNkgnshosyouritukbn;
    }

    private C_Tkhukaumu kjnnkpzeitekitkhukakbn;

    public C_Tkhukaumu getKjnnkpzeitekitkhukakbn() {
        return kjnnkpzeitekitkhukakbn;
    }

    public void setKjnnkpzeitekitkhukakbn(C_Tkhukaumu pKjnnkpzeitekitkhukakbn) {
        kjnnkpzeitekitkhukakbn = pKjnnkpzeitekitkhukakbn;
    }

    private String dispcreditkessaiyouno;

    public String getDispcreditkessaiyouno() {
        return dispcreditkessaiyouno;
    }

    public void setDispcreditkessaiyouno(String pDispcreditkessaiyouno) {
        dispcreditkessaiyouno = pDispcreditkessaiyouno;
    }

    private String kyktuukasyu2mosinput;

    public String getKyktuukasyu2mosinput() {
        return kyktuukasyu2mosinput;
    }

    public void setKyktuukasyu2mosinput(String pKyktuukasyu2mosinput) {
        kyktuukasyu2mosinput = pKyktuukasyu2mosinput;
    }

    private String hrktuukasyu2mosinput;

    public String getHrktuukasyu2mosinput() {
        return hrktuukasyu2mosinput;
    }

    public void setHrktuukasyu2mosinput(String pHrktuukasyu2mosinput) {
        hrktuukasyu2mosinput = pHrktuukasyu2mosinput;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency kihons2;

    public BizCurrency getKihons2() {
        return kihons2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons2(BizCurrency pKihons2) {
        kihons2 = pKihons2;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency hrktuukasyukykp2;

    public BizCurrency getHrktuukasyukykp2() {
        return hrktuukasyukykp2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrktuukasyukykp2(BizCurrency pHrktuukasyukykp2) {
        hrktuukasyukykp2 = pHrktuukasyukykp2;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency mosikkatup2;

    public BizCurrency getMosikkatup2() {
        return mosikkatup2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosikkatup2(BizCurrency pMosikkatup2) {
        mosikkatup2 = pMosikkatup2;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency moszennoupsyokaiari2;

    public BizCurrency getMoszennoupsyokaiari2() {
        return moszennoupsyokaiari2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMoszennoupsyokaiari2(BizCurrency pMoszennoupsyokaiari2) {
        moszennoupsyokaiari2 = pMoszennoupsyokaiari2;
    }

    private C_Tkhukaumu kjnnkpzeitekitkhukakbn2;

    public C_Tkhukaumu getKjnnkpzeitekitkhukakbn2() {
        return kjnnkpzeitekitkhukakbn2;
    }

    public void setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu pKjnnkpzeitekitkhukakbn2) {
        kjnnkpzeitekitkhukakbn2 = pKjnnkpzeitekitkhukakbn2;
    }

    private String dispcreditkessaiyouno2;

    public String getDispcreditkessaiyouno2() {
        return dispcreditkessaiyouno2;
    }

    public void setDispcreditkessaiyouno2(String pDispcreditkessaiyouno2) {
        dispcreditkessaiyouno2 = pDispcreditkessaiyouno2;
    }

    private C_Tkhukaumu teikisiharaitkykhkkbn;

    public C_Tkhukaumu getTeikisiharaitkykhkkbn() {
        return teikisiharaitkykhkkbn;
    }

    public void setTeikisiharaitkykhkkbn(C_Tkhukaumu pTeikisiharaitkykhkkbn) {
        teikisiharaitkykhkkbn = pTeikisiharaitkykhkkbn;
    }

    private Boolean shkstkzinfkzinfoinputhry;

    public Boolean getShkstkzinfkzinfoinputhry() {
        return (shkstkzinfkzinfoinputhry == null) ? Boolean.FALSE : shkstkzinfkzinfoinputhry;
    }

    public void setShkstkzinfkzinfoinputhry(Boolean pShkstkzinfkzinfoinputhry) {
        shkstkzinfkzinfoinputhry = (pShkstkzinfkzinfoinputhry == null) ? Boolean.FALSE : pShkstkzinfkzinfoinputhry;
    }

    private C_KouzaInfoInputHoryuuKbn shkstkzinfkzinfoinputhrykbn;

    public C_KouzaInfoInputHoryuuKbn getShkstkzinfkzinfoinputhrykbn() {
        return shkstkzinfkzinfoinputhrykbn;
    }

    public void setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn pShkstkzinfkzinfoinputhrykbn) {
        shkstkzinfkzinfoinputhrykbn = pShkstkzinfkzinfoinputhrykbn;
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

    private C_KzkykdouKbn kzkykdoukbn;

    public C_KzkykdouKbn getKzkykdoukbn() {
        return kzkykdoukbn;
    }

    public void setKzkykdoukbn(C_KzkykdouKbn pKzkykdoukbn) {
        kzkykdoukbn = pKzkykdoukbn;
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

    private String mkhgkwarimosinput;

    public String getMkhgkwarimosinput() {
        return mkhgkwarimosinput;
    }

    public void setMkhgkwarimosinput(String pMkhgkwarimosinput) {
        mkhgkwarimosinput = pMkhgkwarimosinput;
    }

    private C_Tkhukaumu syksbyensitihsyutkhkkbn;

    public C_Tkhukaumu getSyksbyensitihsyutkhkkbn() {
        return syksbyensitihsyutkhkkbn;
    }

    public void setSyksbyensitihsyutkhkkbn(C_Tkhukaumu pSyksbyensitihsyutkhkkbn) {
        syksbyensitihsyutkhkkbn = pSyksbyensitihsyutkhkkbn;
    }

    private C_Tkhukaumu jyudkaigomehrtkhkkbn;

    public C_Tkhukaumu getJyudkaigomehrtkhkkbn() {
        return jyudkaigomehrtkhkkbn;
    }

    public void setJyudkaigomehrtkhkkbn(C_Tkhukaumu pJyudkaigomehrtkhkkbn) {
        jyudkaigomehrtkhkkbn = pJyudkaigomehrtkhkkbn;
    }

    private C_Tkhukaumu nstkhkkbn;

    public C_Tkhukaumu getNstkhkkbn() {
        return nstkhkkbn;
    }

    public void setNstkhkkbn(C_Tkhukaumu pNstkhkkbn) {
        nstkhkkbn = pNstkhkkbn;
    }

    @Range(min="0", max="99")
    private Integer nstksbnkkn;

    public Integer getNstksbnkkn() {
        return nstksbnkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNstksbnkkn(Integer pNstksbnkkn) {
        nstksbnkkn = pNstksbnkkn;
    }

    private C_KzktourokuserviceTourokuKbn kzktourokuservicetourokukbn;

    public C_KzktourokuserviceTourokuKbn getKzktourokuservicetourokukbn() {
        return kzktourokuservicetourokukbn;
    }

    public void setKzktourokuservicetourokukbn(C_KzktourokuserviceTourokuKbn pKzktourokuservicetourokukbn) {
        kzktourokuservicetourokukbn = pKzktourokuservicetourokukbn;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String trkkzknmkn1;

    public String getTrkkzknmkn1() {
        return trkkzknmkn1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkn1(String pTrkkzknmkn1) {
        trkkzknmkn1 = pTrkkzknmkn1;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzknmkj1;

    public String getTrkkzknmkj1() {
        return trkkzknmkj1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkj1(String pTrkkzknmkj1) {
        trkkzknmkj1 = pTrkkzknmkj1;
    }

    private Boolean trkkzknmkjkhuka1;

    public Boolean getTrkkzknmkjkhuka1() {
        return (trkkzknmkjkhuka1 == null) ? Boolean.FALSE : trkkzknmkjkhuka1;
    }

    public void setTrkkzknmkjkhuka1(Boolean pTrkkzknmkjkhuka1) {
        trkkzknmkjkhuka1 = (pTrkkzknmkjkhuka1 == null) ? Boolean.FALSE : pTrkkzknmkjkhuka1;
    }

    private C_KjkhukaKbn trkkzknmkjkhukakbn1;

    public C_KjkhukaKbn getTrkkzknmkjkhukakbn1() {
        return trkkzknmkjkhukakbn1;
    }

    public void setTrkkzknmkjkhukakbn1(C_KjkhukaKbn pTrkkzknmkjkhukakbn1) {
        trkkzknmkjkhukakbn1 = pTrkkzknmkjkhukakbn1;
    }

    @ValidDate
    private BizDate trkkzkseiymd1;

    public BizDate getTrkkzkseiymd1() {
        return trkkzkseiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkseiymd1(BizDate pTrkkzkseiymd1) {
        trkkzkseiymd1 = pTrkkzkseiymd1;
    }

    private C_Seibetu trkkzksei1;

    public C_Seibetu getTrkkzksei1() {
        return trkkzksei1;
    }

    public void setTrkkzksei1(C_Seibetu pTrkkzksei1) {
        trkkzksei1 = pTrkkzksei1;
    }

    private C_Tdk trkkzktdk1;

    public C_Tdk getTrkkzktdk1() {
        return trkkzktdk1;
    }

    public void setTrkkzktdk1(C_Tdk pTrkkzktdk1) {
        trkkzktdk1 = pTrkkzktdk1;
    }

    private Boolean trkkzktsindousitei1;

    public Boolean getTrkkzktsindousitei1() {
        return (trkkzktsindousitei1 == null) ? Boolean.FALSE : trkkzktsindousitei1;
    }

    public void setTrkkzktsindousitei1(Boolean pTrkkzktsindousitei1) {
        trkkzktsindousitei1 = (pTrkkzktsindousitei1 == null) ? Boolean.FALSE : pTrkkzktsindousitei1;
    }

    private C_TsindousiteiKbn trkkzktsindousiteikbn1;

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn1() {
        return trkkzktsindousiteikbn1;
    }

    public void setTrkkzktsindousiteikbn1(C_TsindousiteiKbn pTrkkzktsindousiteikbn1) {
        trkkzktsindousiteikbn1 = pTrkkzktsindousiteikbn1;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String trkkzkyno1;

    public String getTrkkzkyno1() {
        return trkkzkyno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkyno1(String pTrkkzkyno1) {
        trkkzkyno1 = pTrkkzkyno1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr1kj1;

    public String getTrkkzkadr1kj1() {
        return trkkzkadr1kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr1kj1(String pTrkkzkadr1kj1) {
        trkkzkadr1kj1 = pTrkkzkadr1kj1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr2kj1;

    public String getTrkkzkadr2kj1() {
        return trkkzkadr2kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr2kj1(String pTrkkzkadr2kj1) {
        trkkzkadr2kj1 = pTrkkzkadr2kj1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr3kj1;

    public String getTrkkzkadr3kj1() {
        return trkkzkadr3kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr3kj1(String pTrkkzkadr3kj1) {
        trkkzkadr3kj1 = pTrkkzkadr3kj1;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String trkkzktelno1;

    public String getTrkkzktelno1() {
        return trkkzktelno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzktelno1(String pTrkkzktelno1) {
        trkkzktelno1 = pTrkkzktelno1;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String trkkzknmkn2;

    public String getTrkkzknmkn2() {
        return trkkzknmkn2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkn2(String pTrkkzknmkn2) {
        trkkzknmkn2 = pTrkkzknmkn2;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzknmkj2;

    public String getTrkkzknmkj2() {
        return trkkzknmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkj2(String pTrkkzknmkj2) {
        trkkzknmkj2 = pTrkkzknmkj2;
    }

    private Boolean trkkzknmkjkhuka2;

    public Boolean getTrkkzknmkjkhuka2() {
        return (trkkzknmkjkhuka2 == null) ? Boolean.FALSE : trkkzknmkjkhuka2;
    }

    public void setTrkkzknmkjkhuka2(Boolean pTrkkzknmkjkhuka2) {
        trkkzknmkjkhuka2 = (pTrkkzknmkjkhuka2 == null) ? Boolean.FALSE : pTrkkzknmkjkhuka2;
    }

    private C_KjkhukaKbn trkkzknmkjkhukakbn2;

    public C_KjkhukaKbn getTrkkzknmkjkhukakbn2() {
        return trkkzknmkjkhukakbn2;
    }

    public void setTrkkzknmkjkhukakbn2(C_KjkhukaKbn pTrkkzknmkjkhukakbn2) {
        trkkzknmkjkhukakbn2 = pTrkkzknmkjkhukakbn2;
    }

    @ValidDate
    private BizDate trkkzkseiymd2;

    public BizDate getTrkkzkseiymd2() {
        return trkkzkseiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkseiymd2(BizDate pTrkkzkseiymd2) {
        trkkzkseiymd2 = pTrkkzkseiymd2;
    }

    private C_Seibetu trkkzksei2;

    public C_Seibetu getTrkkzksei2() {
        return trkkzksei2;
    }

    public void setTrkkzksei2(C_Seibetu pTrkkzksei2) {
        trkkzksei2 = pTrkkzksei2;
    }

    private C_Tdk trkkzktdk2;

    public C_Tdk getTrkkzktdk2() {
        return trkkzktdk2;
    }

    public void setTrkkzktdk2(C_Tdk pTrkkzktdk2) {
        trkkzktdk2 = pTrkkzktdk2;
    }

    private Boolean trkkzktsindousitei2;

    public Boolean getTrkkzktsindousitei2() {
        return (trkkzktsindousitei2 == null) ? Boolean.FALSE : trkkzktsindousitei2;
    }

    public void setTrkkzktsindousitei2(Boolean pTrkkzktsindousitei2) {
        trkkzktsindousitei2 = (pTrkkzktsindousitei2 == null) ? Boolean.FALSE : pTrkkzktsindousitei2;
    }

    private C_TsindousiteiKbn trkkzktsindousiteikbn2;

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn2() {
        return trkkzktsindousiteikbn2;
    }

    public void setTrkkzktsindousiteikbn2(C_TsindousiteiKbn pTrkkzktsindousiteikbn2) {
        trkkzktsindousiteikbn2 = pTrkkzktsindousiteikbn2;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String trkkzkyno2;

    public String getTrkkzkyno2() {
        return trkkzkyno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkyno2(String pTrkkzkyno2) {
        trkkzkyno2 = pTrkkzkyno2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr1kj2;

    public String getTrkkzkadr1kj2() {
        return trkkzkadr1kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr1kj2(String pTrkkzkadr1kj2) {
        trkkzkadr1kj2 = pTrkkzkadr1kj2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr2kj2;

    public String getTrkkzkadr2kj2() {
        return trkkzkadr2kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr2kj2(String pTrkkzkadr2kj2) {
        trkkzkadr2kj2 = pTrkkzkadr2kj2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String trkkzkadr3kj2;

    public String getTrkkzkadr3kj2() {
        return trkkzkadr3kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr3kj2(String pTrkkzkadr3kj2) {
        trkkzkadr3kj2 = pTrkkzkadr3kj2;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String trkkzktelno2;

    public String getTrkkzktelno2() {
        return trkkzktelno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzktelno2(String pTrkkzktelno2) {
        trkkzktelno2 = pTrkkzktelno2;
    }

    private C_Tkhukaumu kykdrtkykhukakbn;

    public C_Tkhukaumu getKykdrtkykhukakbn() {
        return kykdrtkykhukakbn;
    }

    public void setKykdrtkykhukakbn(C_Tkhukaumu pKykdrtkykhukakbn) {
        kykdrtkykhukakbn = pKykdrtkykhukakbn;
    }

    private C_UktKbn kykdrkbn;

    public C_UktKbn getKykdrkbn() {
        return kykdrkbn;
    }

    public void setKykdrkbn(C_UktKbn pKykdrkbn) {
        kykdrkbn = pKykdrkbn;
    }

    private C_Tkhukaumu stdrsktkyhkkbn;

    public C_Tkhukaumu getStdrsktkyhkkbn() {
        return stdrsktkyhkkbn;
    }

    public void setStdrsktkyhkkbn(C_Tkhukaumu pStdrsktkyhkkbn) {
        stdrsktkyhkkbn = pStdrsktkyhkkbn;
    }

    private C_UktKbn stdruktkbn;

    public C_UktKbn getStdruktkbn() {
        return stdruktkbn;
    }

    public void setStdruktkbn(C_UktKbn pStdruktkbn) {
        stdruktkbn = pStdruktkbn;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String siteidruktnmkn;

    public String getSiteidruktnmkn() {
        return siteidruktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSiteidruktnmkn(String pSiteidruktnmkn) {
        siteidruktnmkn = pSiteidruktnmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String siteidruktnmkj;

    public String getSiteidruktnmkj() {
        return siteidruktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSiteidruktnmkj(String pSiteidruktnmkj) {
        siteidruktnmkj = pSiteidruktnmkj;
    }

    private Boolean stdrsknmkjkhuka;

    public Boolean getStdrsknmkjkhuka() {
        return (stdrsknmkjkhuka == null) ? Boolean.FALSE : stdrsknmkjkhuka;
    }

    public void setStdrsknmkjkhuka(Boolean pStdrsknmkjkhuka) {
        stdrsknmkjkhuka = (pStdrsknmkjkhuka == null) ? Boolean.FALSE : pStdrsknmkjkhuka;
    }

    private C_KjkhukaKbn stdrsknmkjhukakbn;

    public C_KjkhukaKbn getStdrsknmkjhukakbn() {
        return stdrsknmkjhukakbn;
    }

    public void setStdrsknmkjhukakbn(C_KjkhukaKbn pStdrsknmkjhukakbn) {
        stdrsknmkjhukakbn = pStdrsknmkjhukakbn;
    }

    @ValidDate
    private BizDate stdrskseiymd;

    public BizDate getStdrskseiymd() {
        return stdrskseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setStdrskseiymd(BizDate pStdrskseiymd) {
        stdrskseiymd = pStdrskseiymd;
    }

    private C_Tdk stdrsktdk;

    public C_Tdk getStdrsktdk() {
        return stdrsktdk;
    }

    public void setStdrsktdk(C_Tdk pStdrsktdk) {
        stdrsktdk = pStdrsktdk;
    }

    private C_DirectServiceMosKbn drctservicemoskbn;

    public C_DirectServiceMosKbn getDrctservicemoskbn() {
        return drctservicemoskbn;
    }

    public void setDrctservicemoskbn(C_DirectServiceMosKbn pDrctservicemoskbn) {
        drctservicemoskbn = pDrctservicemoskbn;
    }

    private C_YnkHrkmgkAnniTuutiKbn ynkhrkmgkannituutikbn;

    public C_YnkHrkmgkAnniTuutiKbn getYnkhrkmgkannituutikbn() {
        return ynkhrkmgkannituutikbn;
    }

    public void setYnkhrkmgkannituutikbn(C_YnkHrkmgkAnniTuutiKbn pYnkhrkmgkannituutikbn) {
        ynkhrkmgkannituutikbn = pYnkhrkmgkannituutikbn;
    }

    private C_KzhuritourokuhouKbn kzhuritourokuhoukbn;

    public C_KzhuritourokuhouKbn getKzhuritourokuhoukbn() {
        return kzhuritourokuhoukbn;
    }

    public void setKzhuritourokuhoukbn(C_KzhuritourokuhouKbn pKzhuritourokuhoukbn) {
        kzhuritourokuhoukbn = pKzhuritourokuhoukbn;
    }

    private Boolean kouzainfoinputhoryuu;

    public Boolean getKouzainfoinputhoryuu() {
        return (kouzainfoinputhoryuu == null) ? Boolean.FALSE : kouzainfoinputhoryuu;
    }

    public void setKouzainfoinputhoryuu(Boolean pKouzainfoinputhoryuu) {
        kouzainfoinputhoryuu = (pKouzainfoinputhoryuu == null) ? Boolean.FALSE : pKouzainfoinputhoryuu;
    }

    private C_KouzaInfoInputHoryuuKbn kouzainfoinputhoryuukbn;

    public C_KouzaInfoInputHoryuuKbn getKouzainfoinputhoryuukbn() {
        return kouzainfoinputhoryuukbn;
    }

    public void setKouzainfoinputhoryuukbn(C_KouzaInfoInputHoryuuKbn pKouzainfoinputhoryuukbn) {
        kouzainfoinputhoryuukbn = pKouzainfoinputhoryuukbn;
    }

    @Length(length=4)
    @Digit
    private String kouhurikouzainfobankcd;

    public String getKouhurikouzainfobankcd() {
        return kouhurikouzainfobankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouhurikouzainfobankcd(String pKouhurikouzainfobankcd) {
        kouhurikouzainfobankcd = pKouhurikouzainfobankcd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String kouhurikouzainfobanknmkj;

    public String getKouhurikouzainfobanknmkj() {
        return kouhurikouzainfobanknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKouhurikouzainfobanknmkj(String pKouhurikouzainfobanknmkj) {
        kouhurikouzainfobanknmkj = pKouhurikouzainfobanknmkj;
    }

    @Length(length=3)
    @Digit
    private String kouhurikouzainfositencd;

    public String getKouhurikouzainfositencd() {
        return kouhurikouzainfositencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouhurikouzainfositencd(String pKouhurikouzainfositencd) {
        kouhurikouzainfositencd = pKouhurikouzainfositencd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String kouhurikouzainfositennmkj;

    public String getKouhurikouzainfositennmkj() {
        return kouhurikouzainfositennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKouhurikouzainfositennmkj(String pKouhurikouzainfositennmkj) {
        kouhurikouzainfositennmkj = pKouhurikouzainfositennmkj;
    }

    private C_YokinKbn kouhurikouzainfoyokinkbn;

    public C_YokinKbn getKouhurikouzainfoyokinkbn() {
        return kouhurikouzainfoyokinkbn;
    }

    public void setKouhurikouzainfoyokinkbn(C_YokinKbn pKouhurikouzainfoyokinkbn) {
        kouhurikouzainfoyokinkbn = pKouhurikouzainfoyokinkbn;
    }

    @MaxLength(max=12)
    @HostInvalidCharacter
    private String kouhurikouzainfokouzano;

    public String getKouhurikouzainfokouzano() {
        return kouhurikouzainfokouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouhurikouzainfokouzano(String pKouhurikouzainfokouzano) {
        kouhurikouzainfokouzano = pKouhurikouzainfokouzano;
    }

    private C_KzkykdouKbn kouhurikouzainfokzdoukbn;

    public C_KzkykdouKbn getKouhurikouzainfokzdoukbn() {
        return kouhurikouzainfokzdoukbn;
    }

    public void setKouhurikouzainfokzdoukbn(C_KzkykdouKbn pKouhurikouzainfokzdoukbn) {
        kouhurikouzainfokzdoukbn = pKouhurikouzainfokzdoukbn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String kouhurikouzainfokzmeiginmkn;

    public String getKouhurikouzainfokzmeiginmkn() {
        return kouhurikouzainfokzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKouhurikouzainfokzmeiginmkn(String pKouhurikouzainfokzmeiginmkn) {
        kouhurikouzainfokzmeiginmkn = pKouhurikouzainfokzmeiginmkn;
    }

    private C_YouhiblnkKbn kouzakakuniniraikbn;

    public C_YouhiblnkKbn getKouzakakuniniraikbn() {
        return kouzakakuniniraikbn;
    }

    public void setKouzakakuniniraikbn(C_YouhiblnkKbn pKouzakakuniniraikbn) {
        kouzakakuniniraikbn = pKouzakakuniniraikbn;
    }

    private C_HonninkakuninSyoruiKbn kykhonninkakninsyoruikbn;

    public C_HonninkakuninSyoruiKbn getKykhonninkakninsyoruikbn() {
        return kykhonninkakninsyoruikbn;
    }

    public void setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pKykhonninkakninsyoruikbn) {
        kykhonninkakninsyoruikbn = pKykhonninkakninsyoruikbn;
    }

    private C_HonninkakuninSyoruiKbn skskknhonninkakninsyoruikbn;

    public C_HonninkakuninSyoruiKbn getSkskknhonninkakninsyoruikbn() {
        return skskknhonninkakninsyoruikbn;
    }

    public void setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pSkskknhonninkakninsyoruikbn) {
        skskknhonninkakninsyoruikbn = pSkskknhonninkakninsyoruikbn;
    }

    private C_KoureiKzkSetumeiHouKbn koureikzksetumeihoukbn;

    public C_KoureiKzkSetumeiHouKbn getKoureikzksetumeihoukbn() {
        return koureikzksetumeihoukbn;
    }

    public void setKoureikzksetumeihoukbn(C_KoureiKzkSetumeiHouKbn pKoureikzksetumeihoukbn) {
        koureikzksetumeihoukbn = pKoureikzksetumeihoukbn;
    }

    private C_KoureiMndnHukusuukaiKbn koureimndnhukusuukaikbn;

    public C_KoureiMndnHukusuukaiKbn getKoureimndnhukusuukaikbn() {
        return koureimndnhukusuukaikbn;
    }

    public void setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn pKoureimndnhukusuukaikbn) {
        koureimndnhukusuukaikbn = pKoureimndnhukusuukaikbn;
    }

    private C_KoureiTratkisyaIgiDskKbn koureitratkisyaigidskkbn;

    public C_KoureiTratkisyaIgiDskKbn getKoureitratkisyaigidskkbn() {
        return koureitratkisyaigidskkbn;
    }

    public void setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn pKoureitratkisyaigidskkbn) {
        koureitratkisyaigidskkbn = pKoureitratkisyaigidskkbn;
    }

    @Length(length=4)
    @SingleByteStrings
    @AlphaDigit
    @HostInvalidCharacter
    private String drtenjimcd1;

    public String getDrtenjimcd1() {
        return drtenjimcd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenjimcd1(String pDrtenjimcd1) {
        drtenjimcd1 = pDrtenjimcd1;
    }

    @Length(length=4)
    @Digit
    private String dairitenkinyuukikancd1;

    public String getDairitenkinyuukikancd1() {
        return dairitenkinyuukikancd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikancd1(String pDairitenkinyuukikancd1) {
        dairitenkinyuukikancd1 = pDairitenkinyuukikancd1;
    }

    @MaxLength(max=4)
    @Digit
    private String dairitenkinyuukikansitencd1;

    public String getDairitenkinyuukikansitencd1() {
        return dairitenkinyuukikansitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikansitencd1(String pDairitenkinyuukikansitencd1) {
        dairitenkinyuukikansitencd1 = pDairitenkinyuukikansitencd1;
    }

    @MaxLength(max=3)
    private String drtenkinyuusitencd1x3keta;

    public String getDrtenkinyuusitencd1x3keta() {
        return drtenkinyuusitencd1x3keta;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenkinyuusitencd1x3keta(String pDrtenkinyuusitencd1x3keta) {
        drtenkinyuusitencd1x3keta = pDrtenkinyuusitencd1x3keta;
    }

    @MaxLength(max=20)
    @AlphaDigit
    @HostInvalidCharacter
    private String dairitentoriatukaikouincd1;

    public String getDairitentoriatukaikouincd1() {
        return dairitentoriatukaikouincd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitentoriatukaikouincd1(String pDairitentoriatukaikouincd1) {
        dairitentoriatukaikouincd1 = pDairitentoriatukaikouincd1;
    }

    @Length(length=7)
    @Digit
    @Modulus10w21
    @HostInvalidCharacter
    private String inputbosyuucd1;

    public String getInputbosyuucd1() {
        return inputbosyuucd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setInputbosyuucd1(String pInputbosyuucd1) {
        inputbosyuucd1 = pInputbosyuucd1;
    }

    @MaxLength(max=13)
    @AlphaDigit
    @HostInvalidCharacter
    private String bosyuunintourokuno1;

    public String getBosyuunintourokuno1() {
        return bosyuunintourokuno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuunintourokuno1(String pBosyuunintourokuno1) {
        bosyuunintourokuno1 = pBosyuunintourokuno1;
    }

    @MaxLength(max=10)
    @AlphaDigit
    private String toriatukaidairitencd1;

    public String getToriatukaidairitencd1() {
        return toriatukaidairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setToriatukaidairitencd1(String pToriatukaidairitencd1) {
        toriatukaidairitencd1 = pToriatukaidairitencd1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String toriatukaidairitennm1;

    public String getToriatukaidairitennm1() {
        return toriatukaidairitennm1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setToriatukaidairitennm1(String pToriatukaidairitennm1) {
        toriatukaidairitennm1 = pToriatukaidairitennm1;
    }

    @MaxLength(max=7)
    @AlphaDigit
    private String oyadairitencd1;

    public String getOyadairitencd1() {
        return oyadairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadairitencd1(String pOyadairitencd1) {
        oyadairitencd1 = pOyadairitencd1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String oyadairitennm1;

    public String getOyadairitennm1() {
        return oyadairitennm1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setOyadairitennm1(String pOyadairitennm1) {
        oyadairitennm1 = pOyadairitennm1;
    }

    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    private String bosyuucd1;

    public String getBosyuucd1() {
        return bosyuucd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd1(String pBosyuucd1) {
        bosyuucd1 = pBosyuucd1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String bosyuuninnm1;

    public String getBosyuuninnm1() {
        return bosyuuninnm1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBosyuuninnm1(String pBosyuuninnm1) {
        bosyuuninnm1 = pBosyuuninnm1;
    }

    @Length(length=7)
    @AlphaDigit
    @HostInvalidCharacter
    private String gyskkjsakisosikicd1;

    public String getGyskkjsakisosikicd1() {
        return gyskkjsakisosikicd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGyskkjsakisosikicd1(String pGyskkjsakisosikicd1) {
        gyskkjsakisosikicd1 = pGyskkjsakisosikicd1;
    }

    private String gyskkjsakisosikinmkj1;

    public String getGyskkjsakisosikinmkj1() {
        return gyskkjsakisosikinmkj1;
    }

    public void setGyskkjsakisosikinmkj1(String pGyskkjsakisosikinmkj1) {
        gyskkjsakisosikinmkj1 = pGyskkjsakisosikinmkj1;
    }

    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    private BizNumber dairitenbuntanwariai1;

    public BizNumber getDairitenbuntanwariai1() {
        return dairitenbuntanwariai1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenbuntanwariai1(BizNumber pDairitenbuntanwariai1) {
        dairitenbuntanwariai1 = pDairitenbuntanwariai1;
    }

    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    private String cifcd;

    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    @Length(length=11)
    @AlphaDigit
    @HostInvalidCharacter
    private String uktkid;

    public String getUktkid() {
        return uktkid;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktkid(String pUktkid) {
        uktkid = pUktkid;
    }

    @Length(length=4)
    @SingleByteStrings
    @AlphaDigit
    @HostInvalidCharacter
    private String drtenjimcd2;

    public String getDrtenjimcd2() {
        return drtenjimcd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenjimcd2(String pDrtenjimcd2) {
        drtenjimcd2 = pDrtenjimcd2;
    }

    @Length(length=4)
    @Digit
    private String dairitenkinyuukikancd2;

    public String getDairitenkinyuukikancd2() {
        return dairitenkinyuukikancd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikancd2(String pDairitenkinyuukikancd2) {
        dairitenkinyuukikancd2 = pDairitenkinyuukikancd2;
    }

    @MaxLength(max=4)
    @Digit
    private String dairitenkinyuukikansitencd2;

    public String getDairitenkinyuukikansitencd2() {
        return dairitenkinyuukikansitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikansitencd2(String pDairitenkinyuukikansitencd2) {
        dairitenkinyuukikansitencd2 = pDairitenkinyuukikansitencd2;
    }

    @MaxLength(max=3)
    private String drtenkinyuusitencd2x3keta;

    public String getDrtenkinyuusitencd2x3keta() {
        return drtenkinyuusitencd2x3keta;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenkinyuusitencd2x3keta(String pDrtenkinyuusitencd2x3keta) {
        drtenkinyuusitencd2x3keta = pDrtenkinyuusitencd2x3keta;
    }

    @MaxLength(max=20)
    @AlphaDigit
    @HostInvalidCharacter
    private String dairitentoriatukaikouincd2;

    public String getDairitentoriatukaikouincd2() {
        return dairitentoriatukaikouincd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitentoriatukaikouincd2(String pDairitentoriatukaikouincd2) {
        dairitentoriatukaikouincd2 = pDairitentoriatukaikouincd2;
    }

    @Length(length=7)
    @Digit
    @Modulus10w21
    @HostInvalidCharacter
    private String inputbosyuucd2;

    public String getInputbosyuucd2() {
        return inputbosyuucd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setInputbosyuucd2(String pInputbosyuucd2) {
        inputbosyuucd2 = pInputbosyuucd2;
    }

    @MaxLength(max=13)
    @AlphaDigit
    @HostInvalidCharacter
    private String bosyuunintourokuno2;

    public String getBosyuunintourokuno2() {
        return bosyuunintourokuno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuunintourokuno2(String pBosyuunintourokuno2) {
        bosyuunintourokuno2 = pBosyuunintourokuno2;
    }

    @MaxLength(max=10)
    @AlphaDigit
    private String toriatukaidairitencd2;

    public String getToriatukaidairitencd2() {
        return toriatukaidairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setToriatukaidairitencd2(String pToriatukaidairitencd2) {
        toriatukaidairitencd2 = pToriatukaidairitencd2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String toriatukaidairitennm2;

    public String getToriatukaidairitennm2() {
        return toriatukaidairitennm2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setToriatukaidairitennm2(String pToriatukaidairitennm2) {
        toriatukaidairitennm2 = pToriatukaidairitennm2;
    }

    @MaxLength(max=7)
    @AlphaDigit
    private String oyadairitencd2;

    public String getOyadairitencd2() {
        return oyadairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadairitencd2(String pOyadairitencd2) {
        oyadairitencd2 = pOyadairitencd2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String oyadairitennm2;

    public String getOyadairitennm2() {
        return oyadairitennm2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setOyadairitennm2(String pOyadairitennm2) {
        oyadairitennm2 = pOyadairitennm2;
    }

    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    private String bosyuucd2;

    public String getBosyuucd2() {
        return bosyuucd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd2(String pBosyuucd2) {
        bosyuucd2 = pBosyuucd2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String bosyuuninnm2;

    public String getBosyuuninnm2() {
        return bosyuuninnm2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBosyuuninnm2(String pBosyuuninnm2) {
        bosyuuninnm2 = pBosyuuninnm2;
    }

    @Length(length=7)
    @AlphaDigit
    @HostInvalidCharacter
    private String gyskkjsakisosikicd2;

    public String getGyskkjsakisosikicd2() {
        return gyskkjsakisosikicd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGyskkjsakisosikicd2(String pGyskkjsakisosikicd2) {
        gyskkjsakisosikicd2 = pGyskkjsakisosikicd2;
    }

    private String gyskkjsakisosikinmkj2;

    public String getGyskkjsakisosikinmkj2() {
        return gyskkjsakisosikinmkj2;
    }

    public void setGyskkjsakisosikinmkj2(String pGyskkjsakisosikinmkj2) {
        gyskkjsakisosikinmkj2 = pGyskkjsakisosikinmkj2;
    }

    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    private BizNumber dairitenbuntanwariai2;

    public BizNumber getDairitenbuntanwariai2() {
        return dairitenbuntanwariai2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenbuntanwariai2(BizNumber pDairitenbuntanwariai2) {
        dairitenbuntanwariai2 = pDairitenbuntanwariai2;
    }

    private C_UmuKbn tsryhshrkykumukbn;

    public C_UmuKbn getTsryhshrkykumukbn() {
        return tsryhshrkykumukbn;
    }

    public void setTsryhshrkykumukbn(C_UmuKbn pTsryhshrkykumukbn) {
        tsryhshrkykumukbn = pTsryhshrkykumukbn;
    }

    private C_UmuKbn syosisyatodokeumukbn;

    public C_UmuKbn getSyosisyatodokeumukbn() {
        return syosisyatodokeumukbn;
    }

    public void setSyosisyatodokeumukbn(C_UmuKbn pSyosisyatodokeumukbn) {
        syosisyatodokeumukbn = pSyosisyatodokeumukbn;
    }

    private C_UmuKbn kakukisyouryakukbumukbn;

    public C_UmuKbn getKakukisyouryakukbumukbn() {
        return kakukisyouryakukbumukbn;
    }

    public void setKakukisyouryakukbumukbn(C_UmuKbn pKakukisyouryakukbumukbn) {
        kakukisyouryakukbumukbn = pKakukisyouryakukbumukbn;
    }

    private C_UmuKbn seiymdmosseitouumukbn;

    public C_UmuKbn getSeiymdmosseitouumukbn() {
        return seiymdmosseitouumukbn;
    }

    public void setSeiymdmosseitouumukbn(C_UmuKbn pSeiymdmosseitouumukbn) {
        seiymdmosseitouumukbn = pSeiymdmosseitouumukbn;
    }

    private Boolean tkhsyouryaku;

    public Boolean getTkhsyouryaku() {
        return (tkhsyouryaku == null) ? Boolean.FALSE : tkhsyouryaku;
    }

    public void setTkhsyouryaku(Boolean pTkhsyouryaku) {
        tkhsyouryaku = (pTkhsyouryaku == null) ? Boolean.FALSE : pTkhsyouryaku;
    }

    private C_UmuKbn tkhsyouryakuumukbn;

    public C_UmuKbn getTkhsyouryakuumukbn() {
        return tkhsyouryakuumukbn;
    }

    public void setTkhsyouryakuumukbn(C_UmuKbn pTkhsyouryakuumukbn) {
        tkhsyouryakuumukbn = pTkhsyouryakuumukbn;
    }

    @MultiByteStringsReturnable
    @InvalidCharacter
    @ValidTextArea(length=40, rows=10)
    private String khnchkcmnt;

    public String getKhnchkcmnt() {
        return khnchkcmnt;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKhnchkcmnt(String pKhnchkcmnt) {
        khnchkcmnt = pKhnchkcmnt;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

    private String uniqueid2;

    public String getUniqueid2() {
        return uniqueid2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueid2(String pUniqueid2) {
        uniqueid2 = pUniqueid2;
    }

    private LoopChain<UserDefsList> hknsyuruinomosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getHknsyuruinomosinputOptionBeanList() {
        return hknsyuruinomosinputOptionBeanList.get();
    }

    public void setHknsyuruinomosinputOptionBeanList(UserDefsList pHknsyuruinomosinputOptionBeanList) {
        clearHknsyuruinomosinputOptionBeanList();
        hknsyuruinomosinputOptionBeanList.add(pHknsyuruinomosinputOptionBeanList);
    }

    public void clearHknsyuruinomosinputOptionBeanList() {
        hknsyuruinomosinputOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> syudai1hknkknmosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getSyudai1hknkknmosinputOptionBeanList() {
        return syudai1hknkknmosinputOptionBeanList.get();
    }

    public void setSyudai1hknkknmosinputOptionBeanList(UserDefsList pSyudai1hknkknmosinputOptionBeanList) {
        clearSyudai1hknkknmosinputOptionBeanList();
        syudai1hknkknmosinputOptionBeanList.add(pSyudai1hknkknmosinputOptionBeanList);
    }

    public void clearSyudai1hknkknmosinputOptionBeanList() {
        syudai1hknkknmosinputOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> nenkinsyumosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getNenkinsyumosinputOptionBeanList() {
        return nenkinsyumosinputOptionBeanList.get();
    }

    public void setNenkinsyumosinputOptionBeanList(UserDefsList pNenkinsyumosinputOptionBeanList) {
        clearNenkinsyumosinputOptionBeanList();
        nenkinsyumosinputOptionBeanList.add(pNenkinsyumosinputOptionBeanList);
    }

    public void clearNenkinsyumosinputOptionBeanList() {
        nenkinsyumosinputOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> zenkizennouumumosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getZenkizennouumumosinputOptionBeanList() {
        return zenkizennouumumosinputOptionBeanList.get();
    }

    public void setZenkizennouumumosinputOptionBeanList(UserDefsList pZenkizennouumumosinputOptionBeanList) {
        clearZenkizennouumumosinputOptionBeanList();
        zenkizennouumumosinputOptionBeanList.add(pZenkizennouumumosinputOptionBeanList);
    }

    public void clearZenkizennouumumosinputOptionBeanList() {
        zenkizennouumumosinputOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> hrkkaisuumosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getHrkkaisuumosinputOptionBeanList() {
        return hrkkaisuumosinputOptionBeanList.get();
    }

    public void setHrkkaisuumosinputOptionBeanList(UserDefsList pHrkkaisuumosinputOptionBeanList) {
        clearHrkkaisuumosinputOptionBeanList();
        hrkkaisuumosinputOptionBeanList.add(pHrkkaisuumosinputOptionBeanList);
    }

    public void clearHrkkaisuumosinputOptionBeanList() {
        hrkkaisuumosinputOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> ikkatubaraikaisuumosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getIkkatubaraikaisuumosinputOptionBeanList() {
        return ikkatubaraikaisuumosinputOptionBeanList.get();
    }

    public void setIkkatubaraikaisuumosinputOptionBeanList(UserDefsList pIkkatubaraikaisuumosinputOptionBeanList) {
        clearIkkatubaraikaisuumosinputOptionBeanList();
        ikkatubaraikaisuumosinputOptionBeanList.add(pIkkatubaraikaisuumosinputOptionBeanList);
    }

    public void clearIkkatubaraikaisuumosinputOptionBeanList() {
        ikkatubaraikaisuumosinputOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> kyktuukasyumosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getKyktuukasyumosinputOptionBeanList() {
        return kyktuukasyumosinputOptionBeanList.get();
    }

    public void setKyktuukasyumosinputOptionBeanList(UserDefsList pKyktuukasyumosinputOptionBeanList) {
        clearKyktuukasyumosinputOptionBeanList();
        kyktuukasyumosinputOptionBeanList.add(pKyktuukasyumosinputOptionBeanList);
    }

    public void clearKyktuukasyumosinputOptionBeanList() {
        kyktuukasyumosinputOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> hrktuukasyumosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getHrktuukasyumosinputOptionBeanList() {
        return hrktuukasyumosinputOptionBeanList.get();
    }

    public void setHrktuukasyumosinputOptionBeanList(UserDefsList pHrktuukasyumosinputOptionBeanList) {
        clearHrktuukasyumosinputOptionBeanList();
        hrktuukasyumosinputOptionBeanList.add(pHrktuukasyumosinputOptionBeanList);
    }

    public void clearHrktuukasyumosinputOptionBeanList() {
        hrktuukasyumosinputOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> sueokikknmosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getSueokikknmosinputOptionBeanList() {
        return sueokikknmosinputOptionBeanList.get();
    }

    public void setSueokikknmosinputOptionBeanList(UserDefsList pSueokikknmosinputOptionBeanList) {
        clearSueokikknmosinputOptionBeanList();
        sueokikknmosinputOptionBeanList.add(pSueokikknmosinputOptionBeanList);
    }

    public void clearSueokikknmosinputOptionBeanList() {
        sueokikknmosinputOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> kyktuukasyu2mosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getKyktuukasyu2mosinputOptionBeanList() {
        return kyktuukasyu2mosinputOptionBeanList.get();
    }

    public void setKyktuukasyu2mosinputOptionBeanList(UserDefsList pKyktuukasyu2mosinputOptionBeanList) {
        clearKyktuukasyu2mosinputOptionBeanList();
        kyktuukasyu2mosinputOptionBeanList.add(pKyktuukasyu2mosinputOptionBeanList);
    }

    public void clearKyktuukasyu2mosinputOptionBeanList() {
        kyktuukasyu2mosinputOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> hrktuukasyu2mosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getHrktuukasyu2mosinputOptionBeanList() {
        return hrktuukasyu2mosinputOptionBeanList.get();
    }

    public void setHrktuukasyu2mosinputOptionBeanList(UserDefsList pHrktuukasyu2mosinputOptionBeanList) {
        clearHrktuukasyu2mosinputOptionBeanList();
        hrktuukasyu2mosinputOptionBeanList.add(pHrktuukasyu2mosinputOptionBeanList);
    }

    public void clearHrktuukasyu2mosinputOptionBeanList() {
        hrktuukasyu2mosinputOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> mkhgkwarimosinputOptionBeanList = new LoopChain<>();
    public UserDefsList getMkhgkwarimosinputOptionBeanList() {
        return mkhgkwarimosinputOptionBeanList.get();
    }

    public void setMkhgkwarimosinputOptionBeanList(UserDefsList pMkhgkwarimosinputOptionBeanList) {
        clearMkhgkwarimosinputOptionBeanList();
        mkhgkwarimosinputOptionBeanList.add(pMkhgkwarimosinputOptionBeanList);
    }

    public void clearMkhgkwarimosinputOptionBeanList() {
        mkhgkwarimosinputOptionBeanList.clear();
    }
}
