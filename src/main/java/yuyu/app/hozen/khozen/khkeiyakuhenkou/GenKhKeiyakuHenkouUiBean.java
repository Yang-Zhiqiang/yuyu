package yuyu.app.hozen.khozen.khkeiyakuhenkou;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kknenkinsyu;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_KykhnkKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YuukoukakujkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 契約変更 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhKeiyakuHenkouUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<BetukeiyakuListDataSourceBean> betukeiyakuListDataSource = new DataSource<>();
    public DataSource<BetukeiyakuListDataSourceBean> getBetukeiyakuListDataSource() {
        return betukeiyakuListDataSource;
    }

    @Deprecated
    public List<BetukeiyakuListDataSourceBean> getBetukeiyakuList() {
        return betukeiyakuListDataSource.getDatas();
    }

    public void setBetukeiyakuList(List<BetukeiyakuListDataSourceBean> pBetukeiyakuList) {
        betukeiyakuListDataSource.setDatas(pBetukeiyakuList);
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

    private DataSource<TtdktyuuikbnInfoDataSourceBean> ttdktyuuikbnInfoDataSource = new DataSource<>();
    public DataSource<TtdktyuuikbnInfoDataSourceBean> getTtdktyuuikbnInfoDataSource() {
        return ttdktyuuikbnInfoDataSource;
    }

    @Deprecated
    public List<TtdktyuuikbnInfoDataSourceBean> getTtdktyuuikbnInfo() {
        return ttdktyuuikbnInfoDataSource.getDatas();
    }

    public void setTtdktyuuikbnInfo(List<TtdktyuuikbnInfoDataSourceBean> pTtdktyuuikbnInfo) {
        ttdktyuuikbnInfoDataSource.setDatas(pTtdktyuuikbnInfo);
    }

    private DataSource<KakuninKekkaInfoDataSourceBean> kakuninKekkaInfoDataSource = new DataSource<>();
    public DataSource<KakuninKekkaInfoDataSourceBean> getKakuninKekkaInfoDataSource() {
        return kakuninKekkaInfoDataSource;
    }

    @Deprecated
    public List<KakuninKekkaInfoDataSourceBean> getKakuninKekkaInfo() {
        return kakuninKekkaInfoDataSource.getDatas();
    }

    public void setKakuninKekkaInfo(List<KakuninKekkaInfoDataSourceBean> pKakuninKekkaInfo) {
        kakuninKekkaInfoDataSource.setDatas(pKakuninKekkaInfo);
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

    private BizDate lastsyosaihkymd;

    public BizDate getLastsyosaihkymd() {
        return lastsyosaihkymd;
    }

    @Trim("both")
    public void setLastsyosaihkymd(BizDate pLastsyosaihkymd) {
        lastsyosaihkymd = pLastsyosaihkymd;
    }

    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    public C_YuukousyoumetuKbn getYuukousyoumetukbn() {
        return yuukousyoumetukbn;
    }

    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn) {
        yuukousyoumetukbn = pYuukousyoumetukbn;
    }

    private C_Kykjyoutai kykjyoutai;

    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        kykjyoutai = pKykjyoutai;
    }

    private C_Syoumetujiyuu syoumetujiyuu;

    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    private BizDate syoumetuymd;

    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
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

    @ValidDate
    private BizDate mosukeymd;

    public BizDate getMosukeymd() {
        return mosukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosukeymd(BizDate pMosukeymd) {
        mosukeymd = pMosukeymd;
    }

    private BizDate seirituymd;

    public BizDate getSeirituymd() {
        return seirituymd;
    }

    @Trim("both")
    public void setSeirituymd(BizDate pSeirituymd) {
        seirituymd = pSeirituymd;
    }

    private BizDateYM seisekiym;

    public BizDateYM getSeisekiym() {
        return seisekiym;
    }

    @Trim("both")
    public void setSeisekiym(BizDateYM pSeisekiym) {
        seisekiym = pSeisekiym;
    }

    private String allhyoujibtn;

    public String getAllhyoujibtn() {
        return allhyoujibtn;
    }

    public void setAllhyoujibtn(String pAllhyoujibtn) {
        allhyoujibtn = pAllhyoujibtn;
    }

    private C_KktyuitaKbn kktyuitakbn;

    public C_KktyuitaKbn getKktyuitakbn() {
        return kktyuitakbn;
    }

    public void setKktyuitakbn(C_KktyuitaKbn pKktyuitakbn) {
        kktyuitakbn = pKktyuitakbn;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String ttdktyuuinaiyou1;

    public String getTtdktyuuinaiyou1() {
        return ttdktyuuinaiyou1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou1(String pTtdktyuuinaiyou1) {
        ttdktyuuinaiyou1 = pTtdktyuuinaiyou1;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String ttdktyuuinaiyou2;

    public String getTtdktyuuinaiyou2() {
        return ttdktyuuinaiyou2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou2(String pTtdktyuuinaiyou2) {
        ttdktyuuinaiyou2 = pTtdktyuuinaiyou2;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String ttdktyuuinaiyou3;

    public String getTtdktyuuinaiyou3() {
        return ttdktyuuinaiyou3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou3(String pTtdktyuuinaiyou3) {
        ttdktyuuinaiyou3 = pTtdktyuuinaiyou3;
    }

    private C_StknsetKbn stknsetkbn;

    public C_StknsetKbn getStknsetkbn() {
        return stknsetkbn;
    }

    public void setStknsetkbn(C_StknsetKbn pStknsetkbn) {
        stknsetkbn = pStknsetkbn;
    }

    private C_FatcasnsiKbn dispfatcasnsikbn1;

    public C_FatcasnsiKbn getDispfatcasnsikbn1() {
        return dispfatcasnsikbn1;
    }

    public void setDispfatcasnsikbn1(C_FatcasnsiKbn pDispfatcasnsikbn1) {
        dispfatcasnsikbn1 = pDispfatcasnsikbn1;
    }

    private C_BikkjnssinfoKbn dispbikkjnssinfokbn1;

    public C_BikkjnssinfoKbn getDispbikkjnssinfokbn1() {
        return dispbikkjnssinfokbn1;
    }

    public void setDispbikkjnssinfokbn1(C_BikkjnssinfoKbn pDispbikkjnssinfokbn1) {
        dispbikkjnssinfokbn1 = pDispbikkjnssinfokbn1;
    }

    private C_FatcakekKbn dispfatcakekkbn1;

    public C_FatcakekKbn getDispfatcakekkbn1() {
        return dispfatcakekkbn1;
    }

    public void setDispfatcakekkbn1(C_FatcakekKbn pDispfatcakekkbn1) {
        dispfatcakekkbn1 = pDispfatcakekkbn1;
    }

    private C_FatcahankeiiKbn dispfatcahankeiikbn1;

    public C_FatcahankeiiKbn getDispfatcahankeiikbn1() {
        return dispfatcahankeiikbn1;
    }

    public void setDispfatcahankeiikbn1(C_FatcahankeiiKbn pDispfatcahankeiikbn1) {
        dispfatcahankeiikbn1 = pDispfatcahankeiikbn1;
    }

    @MaxLength(max=9)
    @AlphaDigit
    private String dispbikknzsyno1;

    public String getDispbikknzsyno1() {
        return dispbikknzsyno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispbikknzsyno1(String pDispbikknzsyno1) {
        dispbikknzsyno1 = pDispbikknzsyno1;
    }

    @ValidDate
    private BizDate dispsyomeiymd1;

    public BizDate getDispsyomeiymd1() {
        return dispsyomeiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyomeiymd1(BizDate pDispsyomeiymd1) {
        dispsyomeiymd1 = pDispsyomeiymd1;
    }

    private C_FatcatgKbn dispfatcatgkbn1;

    public C_FatcatgKbn getDispfatcatgkbn1() {
        return dispfatcatgkbn1;
    }

    public void setDispfatcatgkbn1(C_FatcatgKbn pDispfatcatgkbn1) {
        dispfatcatgkbn1 = pDispfatcatgkbn1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkn1;

    public String getDispnmkn1() {
        return dispnmkn1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkn1(String pDispnmkn1) {
        dispnmkn1 = pDispnmkn1;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkj1;

    public String getDispnmkj1() {
        return dispnmkj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkj1(String pDispnmkj1) {
        dispnmkj1 = pDispnmkj1;
    }

    @ValidDate
    private BizDate dispseiymd1;

    public BizDate getDispseiymd1() {
        return dispseiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispseiymd1(BizDate pDispseiymd1) {
        dispseiymd1 = pDispseiymd1;
    }

    private C_Seibetu dispsei1;

    public C_Seibetu getDispsei1() {
        return dispsei1;
    }

    public void setDispsei1(C_Seibetu pDispsei1) {
        dispsei1 = pDispsei1;
    }

    private C_FatcasnsiKbn dispfatcasnsikbn2;

    public C_FatcasnsiKbn getDispfatcasnsikbn2() {
        return dispfatcasnsikbn2;
    }

    public void setDispfatcasnsikbn2(C_FatcasnsiKbn pDispfatcasnsikbn2) {
        dispfatcasnsikbn2 = pDispfatcasnsikbn2;
    }

    private C_BikkjnssinfoKbn dispbikkjnssinfokbn2;

    public C_BikkjnssinfoKbn getDispbikkjnssinfokbn2() {
        return dispbikkjnssinfokbn2;
    }

    public void setDispbikkjnssinfokbn2(C_BikkjnssinfoKbn pDispbikkjnssinfokbn2) {
        dispbikkjnssinfokbn2 = pDispbikkjnssinfokbn2;
    }

    private C_FatcakekKbn dispfatcakekkbn2;

    public C_FatcakekKbn getDispfatcakekkbn2() {
        return dispfatcakekkbn2;
    }

    public void setDispfatcakekkbn2(C_FatcakekKbn pDispfatcakekkbn2) {
        dispfatcakekkbn2 = pDispfatcakekkbn2;
    }

    private C_FatcahankeiiKbn dispfatcahankeiikbn2;

    public C_FatcahankeiiKbn getDispfatcahankeiikbn2() {
        return dispfatcahankeiikbn2;
    }

    public void setDispfatcahankeiikbn2(C_FatcahankeiiKbn pDispfatcahankeiikbn2) {
        dispfatcahankeiikbn2 = pDispfatcahankeiikbn2;
    }

    @MaxLength(max=9)
    @AlphaDigit
    private String dispbikknzsyno2;

    public String getDispbikknzsyno2() {
        return dispbikknzsyno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispbikknzsyno2(String pDispbikknzsyno2) {
        dispbikknzsyno2 = pDispbikknzsyno2;
    }

    @ValidDate
    private BizDate dispsyomeiymd2;

    public BizDate getDispsyomeiymd2() {
        return dispsyomeiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyomeiymd2(BizDate pDispsyomeiymd2) {
        dispsyomeiymd2 = pDispsyomeiymd2;
    }

    private C_FatcatgKbn dispfatcatgkbn2;

    public C_FatcatgKbn getDispfatcatgkbn2() {
        return dispfatcatgkbn2;
    }

    public void setDispfatcatgkbn2(C_FatcatgKbn pDispfatcatgkbn2) {
        dispfatcatgkbn2 = pDispfatcatgkbn2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkn2;

    public String getDispnmkn2() {
        return dispnmkn2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkn2(String pDispnmkn2) {
        dispnmkn2 = pDispnmkn2;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkj2;

    public String getDispnmkj2() {
        return dispnmkj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkj2(String pDispnmkj2) {
        dispnmkj2 = pDispnmkj2;
    }

    @ValidDate
    private BizDate dispseiymd2;

    public BizDate getDispseiymd2() {
        return dispseiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispseiymd2(BizDate pDispseiymd2) {
        dispseiymd2 = pDispseiymd2;
    }

    private C_Seibetu dispsei2;

    public C_Seibetu getDispsei2() {
        return dispsei2;
    }

    public void setDispsei2(C_Seibetu pDispsei2) {
        dispsei2 = pDispsei2;
    }

    private C_FatcasnsiKbn dispfatcasnsikbn3;

    public C_FatcasnsiKbn getDispfatcasnsikbn3() {
        return dispfatcasnsikbn3;
    }

    public void setDispfatcasnsikbn3(C_FatcasnsiKbn pDispfatcasnsikbn3) {
        dispfatcasnsikbn3 = pDispfatcasnsikbn3;
    }

    private C_BikkjnssinfoKbn dispbikkjnssinfokbn3;

    public C_BikkjnssinfoKbn getDispbikkjnssinfokbn3() {
        return dispbikkjnssinfokbn3;
    }

    public void setDispbikkjnssinfokbn3(C_BikkjnssinfoKbn pDispbikkjnssinfokbn3) {
        dispbikkjnssinfokbn3 = pDispbikkjnssinfokbn3;
    }

    private C_FatcakekKbn dispfatcakekkbn3;

    public C_FatcakekKbn getDispfatcakekkbn3() {
        return dispfatcakekkbn3;
    }

    public void setDispfatcakekkbn3(C_FatcakekKbn pDispfatcakekkbn3) {
        dispfatcakekkbn3 = pDispfatcakekkbn3;
    }

    private C_FatcahankeiiKbn dispfatcahankeiikbn3;

    public C_FatcahankeiiKbn getDispfatcahankeiikbn3() {
        return dispfatcahankeiikbn3;
    }

    public void setDispfatcahankeiikbn3(C_FatcahankeiiKbn pDispfatcahankeiikbn3) {
        dispfatcahankeiikbn3 = pDispfatcahankeiikbn3;
    }

    @MaxLength(max=9)
    @AlphaDigit
    private String dispbikknzsyno3;

    public String getDispbikknzsyno3() {
        return dispbikknzsyno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispbikknzsyno3(String pDispbikknzsyno3) {
        dispbikknzsyno3 = pDispbikknzsyno3;
    }

    @ValidDate
    private BizDate dispsyomeiymd3;

    public BizDate getDispsyomeiymd3() {
        return dispsyomeiymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyomeiymd3(BizDate pDispsyomeiymd3) {
        dispsyomeiymd3 = pDispsyomeiymd3;
    }

    private C_FatcatgKbn dispfatcatgkbn3;

    public C_FatcatgKbn getDispfatcatgkbn3() {
        return dispfatcatgkbn3;
    }

    public void setDispfatcatgkbn3(C_FatcatgKbn pDispfatcatgkbn3) {
        dispfatcatgkbn3 = pDispfatcatgkbn3;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkn3;

    public String getDispnmkn3() {
        return dispnmkn3;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkn3(String pDispnmkn3) {
        dispnmkn3 = pDispnmkn3;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkj3;

    public String getDispnmkj3() {
        return dispnmkj3;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkj3(String pDispnmkj3) {
        dispnmkj3 = pDispnmkj3;
    }

    @ValidDate
    private BizDate dispseiymd3;

    public BizDate getDispseiymd3() {
        return dispseiymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispseiymd3(BizDate pDispseiymd3) {
        dispseiymd3 = pDispseiymd3;
    }

    private C_Seibetu dispsei3;

    public C_Seibetu getDispsei3() {
        return dispsei3;
    }

    public void setDispsei3(C_Seibetu pDispsei3) {
        dispsei3 = pDispsei3;
    }

    private C_FatcasnsiKbn dispfatcasnsikbn4;

    public C_FatcasnsiKbn getDispfatcasnsikbn4() {
        return dispfatcasnsikbn4;
    }

    public void setDispfatcasnsikbn4(C_FatcasnsiKbn pDispfatcasnsikbn4) {
        dispfatcasnsikbn4 = pDispfatcasnsikbn4;
    }

    private C_BikkjnssinfoKbn dispbikkjnssinfokbn4;

    public C_BikkjnssinfoKbn getDispbikkjnssinfokbn4() {
        return dispbikkjnssinfokbn4;
    }

    public void setDispbikkjnssinfokbn4(C_BikkjnssinfoKbn pDispbikkjnssinfokbn4) {
        dispbikkjnssinfokbn4 = pDispbikkjnssinfokbn4;
    }

    private C_FatcakekKbn dispfatcakekkbn4;

    public C_FatcakekKbn getDispfatcakekkbn4() {
        return dispfatcakekkbn4;
    }

    public void setDispfatcakekkbn4(C_FatcakekKbn pDispfatcakekkbn4) {
        dispfatcakekkbn4 = pDispfatcakekkbn4;
    }

    private C_FatcahankeiiKbn dispfatcahankeiikbn4;

    public C_FatcahankeiiKbn getDispfatcahankeiikbn4() {
        return dispfatcahankeiikbn4;
    }

    public void setDispfatcahankeiikbn4(C_FatcahankeiiKbn pDispfatcahankeiikbn4) {
        dispfatcahankeiikbn4 = pDispfatcahankeiikbn4;
    }

    @MaxLength(max=9)
    @AlphaDigit
    private String dispbikknzsyno4;

    public String getDispbikknzsyno4() {
        return dispbikknzsyno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispbikknzsyno4(String pDispbikknzsyno4) {
        dispbikknzsyno4 = pDispbikknzsyno4;
    }

    @ValidDate
    private BizDate dispsyomeiymd4;

    public BizDate getDispsyomeiymd4() {
        return dispsyomeiymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyomeiymd4(BizDate pDispsyomeiymd4) {
        dispsyomeiymd4 = pDispsyomeiymd4;
    }

    private C_FatcatgKbn dispfatcatgkbn4;

    public C_FatcatgKbn getDispfatcatgkbn4() {
        return dispfatcatgkbn4;
    }

    public void setDispfatcatgkbn4(C_FatcatgKbn pDispfatcatgkbn4) {
        dispfatcatgkbn4 = pDispfatcatgkbn4;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkn4;

    public String getDispnmkn4() {
        return dispnmkn4;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkn4(String pDispnmkn4) {
        dispnmkn4 = pDispnmkn4;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkj4;

    public String getDispnmkj4() {
        return dispnmkj4;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkj4(String pDispnmkj4) {
        dispnmkj4 = pDispnmkj4;
    }

    @ValidDate
    private BizDate dispseiymd4;

    public BizDate getDispseiymd4() {
        return dispseiymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispseiymd4(BizDate pDispseiymd4) {
        dispseiymd4 = pDispseiymd4;
    }

    private C_Seibetu dispsei4;

    public C_Seibetu getDispsei4() {
        return dispsei4;
    }

    public void setDispsei4(C_Seibetu pDispsei4) {
        dispsei4 = pDispsei4;
    }

    private C_FatcasnsiKbn dispfatcasnsikbn5;

    public C_FatcasnsiKbn getDispfatcasnsikbn5() {
        return dispfatcasnsikbn5;
    }

    public void setDispfatcasnsikbn5(C_FatcasnsiKbn pDispfatcasnsikbn5) {
        dispfatcasnsikbn5 = pDispfatcasnsikbn5;
    }

    private C_BikkjnssinfoKbn dispbikkjnssinfokbn5;

    public C_BikkjnssinfoKbn getDispbikkjnssinfokbn5() {
        return dispbikkjnssinfokbn5;
    }

    public void setDispbikkjnssinfokbn5(C_BikkjnssinfoKbn pDispbikkjnssinfokbn5) {
        dispbikkjnssinfokbn5 = pDispbikkjnssinfokbn5;
    }

    private C_FatcakekKbn dispfatcakekkbn5;

    public C_FatcakekKbn getDispfatcakekkbn5() {
        return dispfatcakekkbn5;
    }

    public void setDispfatcakekkbn5(C_FatcakekKbn pDispfatcakekkbn5) {
        dispfatcakekkbn5 = pDispfatcakekkbn5;
    }

    private C_FatcahankeiiKbn dispfatcahankeiikbn5;

    public C_FatcahankeiiKbn getDispfatcahankeiikbn5() {
        return dispfatcahankeiikbn5;
    }

    public void setDispfatcahankeiikbn5(C_FatcahankeiiKbn pDispfatcahankeiikbn5) {
        dispfatcahankeiikbn5 = pDispfatcahankeiikbn5;
    }

    @MaxLength(max=9)
    @AlphaDigit
    private String dispbikknzsyno5;

    public String getDispbikknzsyno5() {
        return dispbikknzsyno5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispbikknzsyno5(String pDispbikknzsyno5) {
        dispbikknzsyno5 = pDispbikknzsyno5;
    }

    @ValidDate
    private BizDate dispsyomeiymd5;

    public BizDate getDispsyomeiymd5() {
        return dispsyomeiymd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyomeiymd5(BizDate pDispsyomeiymd5) {
        dispsyomeiymd5 = pDispsyomeiymd5;
    }

    private C_FatcatgKbn dispfatcatgkbn5;

    public C_FatcatgKbn getDispfatcatgkbn5() {
        return dispfatcatgkbn5;
    }

    public void setDispfatcatgkbn5(C_FatcatgKbn pDispfatcatgkbn5) {
        dispfatcatgkbn5 = pDispfatcatgkbn5;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkn5;

    public String getDispnmkn5() {
        return dispnmkn5;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkn5(String pDispnmkn5) {
        dispnmkn5 = pDispnmkn5;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String dispnmkj5;

    public String getDispnmkj5() {
        return dispnmkj5;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setDispnmkj5(String pDispnmkj5) {
        dispnmkj5 = pDispnmkj5;
    }

    @ValidDate
    private BizDate dispseiymd5;

    public BizDate getDispseiymd5() {
        return dispseiymd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispseiymd5(BizDate pDispseiymd5) {
        dispseiymd5 = pDispseiymd5;
    }

    private C_Seibetu dispsei5;

    public C_Seibetu getDispsei5() {
        return dispsei5;
    }

    public void setDispsei5(C_Seibetu pDispsei5) {
        dispsei5 = pDispsei5;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
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

    private C_Tdk kkkyktdk;

    public C_Tdk getKkkyktdk() {
        return kkkyktdk;
    }

    public void setKkkyktdk(C_Tdk pKkkyktdk) {
        kkkyktdk = pKkkyktdk;
    }

    private C_HjndaiykKbn hjndaiykkbn;

    public C_HjndaiykKbn getHjndaiykkbn() {
        return hjndaiykkbn;
    }

    public void setHjndaiykkbn(C_HjndaiykKbn pHjndaiykkbn) {
        hjndaiykkbn = pHjndaiykkbn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String hjndaiyknm;

    public String getHjndaiyknm() {
        return hjndaiyknm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHjndaiyknm(String pHjndaiyknm) {
        hjndaiyknm = pHjndaiyknm;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String hjndainmkn;

    public String getHjndainmkn() {
        return hjndainmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHjndainmkn(String pHjndainmkn) {
        hjndainmkn = pHjndainmkn;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String hjndainmkj;

    public String getHjndainmkj() {
        return hjndainmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHjndainmkj(String pHjndainmkj) {
        hjndainmkj = pHjndainmkj;
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

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr4kj;

    public String getTsinadr4kj() {
        return tsinadr4kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr4kj(String pTsinadr4kj) {
        tsinadr4kj = pTsinadr4kj;
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
    private String nittyuutelno;

    public String getNittyuutelno() {
        return nittyuutelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNittyuutelno(String pNittyuutelno) {
        nittyuutelno = pNittyuutelno;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
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

    private String syusyouhnnm;

    public String getSyusyouhnnm() {
        return syusyouhnnm;
    }

    public void setSyusyouhnnm(String pSyusyouhnnm) {
        syusyouhnnm = pSyusyouhnnm;
    }

    private C_KataKbn syukatakbn;

    public C_KataKbn getSyukatakbn() {
        return syukatakbn;
    }

    public void setSyukatakbn(C_KataKbn pSyukatakbn) {
        syukatakbn = pSyukatakbn;
    }

    private C_KyhgndkataKbn syukyhgndkatakbn;

    public C_KyhgndkataKbn getSyukyhgndkatakbn() {
        return syukyhgndkatakbn;
    }

    public void setSyukyhgndkatakbn(C_KyhgndkataKbn pSyukyhgndkatakbn) {
        syukyhgndkatakbn = pSyukyhgndkatakbn;
    }

    private Integer syuhhknnen;

    public Integer getSyuhhknnen() {
        return syuhhknnen;
    }

    public void setSyuhhknnen(Integer pSyuhhknnen) {
        syuhhknnen = pSyuhhknnen;
    }

    private BizDate syukykymd;

    public BizDate getSyukykymd() {
        return syukykymd;
    }

    public void setSyukykymd(BizDate pSyukykymd) {
        syukykymd = pSyukykymd;
    }

    private BizDate syusknnkaisiymd;

    public BizDate getSyusknnkaisiymd() {
        return syusknnkaisiymd;
    }

    public void setSyusknnkaisiymd(BizDate pSyusknnkaisiymd) {
        syusknnkaisiymd = pSyusknnkaisiymd;
    }

    private BizDate syugansknnkaisiymd;

    public BizDate getSyugansknnkaisiymd() {
        return syugansknnkaisiymd;
    }

    public void setSyugansknnkaisiymd(BizDate pSyugansknnkaisiymd) {
        syugansknnkaisiymd = pSyugansknnkaisiymd;
    }

    private BizDate syufktsknnkaisiymd;

    public BizDate getSyufktsknnkaisiymd() {
        return syufktsknnkaisiymd;
    }

    public void setSyufktsknnkaisiymd(BizDate pSyufktsknnkaisiymd) {
        syufktsknnkaisiymd = pSyufktsknnkaisiymd;
    }

    private BizDate syuhkgansknnkaisiymd;

    public BizDate getSyuhkgansknnkaisiymd() {
        return syuhkgansknnkaisiymd;
    }

    public void setSyuhkgansknnkaisiymd(BizDate pSyuhkgansknnkaisiymd) {
        syuhkgansknnkaisiymd = pSyuhkgansknnkaisiymd;
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

    private C_KihonssyuruiKbn syukihonssyuruikbn;

    public C_KihonssyuruiKbn getSyukihonssyuruikbn() {
        return syukihonssyuruikbn;
    }

    public void setSyukihonssyuruikbn(C_KihonssyuruiKbn pSyukihonssyuruikbn) {
        syukihonssyuruikbn = pSyukihonssyuruikbn;
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

    private BizCurrency dispsyutsnshrgndgk;

    public BizCurrency getDispsyutsnshrgndgk() {
        return dispsyutsnshrgndgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyutsnshrgndgk(BizCurrency pDispsyutsnshrgndgk) {
        dispsyutsnshrgndgk = pDispsyutsnshrgndgk;
    }

    private BizCurrency syup;

    public BizCurrency getSyup() {
        return syup;
    }

    public void setSyup(BizCurrency pSyup) {
        syup = pSyup;
    }

    @CurrencyLenght(length=11)
    @PositiveNumberBizCalcble
    private BizCurrency syukihonkyhgk;

    public BizCurrency getSyukihonkyhgk() {
        return syukihonkyhgk;
    }

    public void setSyukihonkyhgk(BizCurrency pSyukihonkyhgk) {
        syukihonkyhgk = pSyukihonkyhgk;
    }

    private BizCurrency syunextkosgop;

    public BizCurrency getSyunextkosgop() {
        return syunextkosgop;
    }

    public void setSyunextkosgop(BizCurrency pSyunextkosgop) {
        syunextkosgop = pSyunextkosgop;
    }

    private C_SyukyhkinkataKbn syusyukyhkinkatakbn;

    public C_SyukyhkinkataKbn getSyusyukyhkinkatakbn() {
        return syusyukyhkinkatakbn;
    }

    public void setSyusyukyhkinkatakbn(C_SyukyhkinkataKbn pSyusyukyhkinkatakbn) {
        syusyukyhkinkatakbn = pSyusyukyhkinkatakbn;
    }

    private C_6daiLdKbn syurokudaildkbn;

    public C_6daiLdKbn getSyurokudaildkbn() {
        return syurokudaildkbn;
    }

    public void setSyurokudaildkbn(C_6daiLdKbn pSyurokudaildkbn) {
        syurokudaildkbn = pSyurokudaildkbn;
    }

    private BizCurrency syugannyukyhntgk;

    public BizCurrency getSyugannyukyhntgk() {
        return syugannyukyhntgk;
    }

    public void setSyugannyukyhntgk(BizCurrency pSyugannyukyhntgk) {
        syugannyukyhntgk = pSyugannyukyhntgk;
    }

    private BizDate syushrskgnstartymd;

    public BizDate getSyushrskgnstartymd() {
        return syushrskgnstartymd;
    }

    public void setSyushrskgnstartymd(BizDate pSyushrskgnstartymd) {
        syushrskgnstartymd = pSyushrskgnstartymd;
    }

    private BizDate syushrskgnendymd;

    public BizDate getSyushrskgnendymd() {
        return syushrskgnendymd;
    }

    public void setSyushrskgnendymd(BizDate pSyushrskgnendymd) {
        syushrskgnendymd = pSyushrskgnendymd;
    }

    private BizCurrency syushrskgngos;

    public BizCurrency getSyushrskgngos() {
        return syushrskgngos;
    }

    public void setSyushrskgngos(BizCurrency pSyushrskgngos) {
        syushrskgngos = pSyushrskgngos;
    }

    private Integer syukrnbkkn;

    public Integer getSyukrnbkkn() {
        return syukrnbkkn;
    }

    public void setSyukrnbkkn(Integer pSyukrnbkkn) {
        syukrnbkkn = pSyukrnbkkn;
    }

    private BizDate syunkshrstartymd;

    public BizDate getSyunkshrstartymd() {
        return syunkshrstartymd;
    }

    public void setSyunkshrstartymd(BizDate pSyunkshrstartymd) {
        syunkshrstartymd = pSyunkshrstartymd;
    }

    private C_Kknenkinsyu syunnkinsyu;

    public C_Kknenkinsyu getSyunnkinsyu() {
        return syunnkinsyu;
    }

    public void setSyunnkinsyu(C_Kknenkinsyu pSyunnkinsyu) {
        syunnkinsyu = pSyunnkinsyu;
    }

    private Integer syunenkinkkn;

    public Integer getSyunenkinkkn() {
        return syunenkinkkn;
    }

    public void setSyunenkinkkn(Integer pSyunenkinkkn) {
        syunenkinkkn = pSyunenkinkkn;
    }

    private BizCurrency syunknengk;

    public BizCurrency getSyunknengk() {
        return syunknengk;
    }

    public void setSyunknengk(BizCurrency pSyunknengk) {
        syunknengk = pSyunknengk;
    }

    private C_Bnshrkaisuu syubnshrkaisuu;

    public C_Bnshrkaisuu getSyubnshrkaisuu() {
        return syubnshrkaisuu;
    }

    public void setSyubnshrkaisuu(C_Bnshrkaisuu pSyubnshrkaisuu) {
        syubnshrkaisuu = pSyubnshrkaisuu;
    }

    private C_Tkjyskgnkkn syutkjyskgnkkn;

    public C_Tkjyskgnkkn getSyutkjyskgnkkn() {
        return syutkjyskgnkkn;
    }

    public void setSyutkjyskgnkkn(C_Tkjyskgnkkn pSyutkjyskgnkkn) {
        syutkjyskgnkkn = pSyutkjyskgnkkn;
    }

    private BizDate syutkjyskgnhknnndsymd1;

    public BizDate getSyutkjyskgnhknnndsymd1() {
        return syutkjyskgnhknnndsymd1;
    }

    public void setSyutkjyskgnhknnndsymd1(BizDate pSyutkjyskgnhknnndsymd1) {
        syutkjyskgnhknnndsymd1 = pSyutkjyskgnhknnndsymd1;
    }

    private BizDate syutkjyskgnhknnndeymd1;

    public BizDate getSyutkjyskgnhknnndeymd1() {
        return syutkjyskgnhknnndeymd1;
    }

    public void setSyutkjyskgnhknnndeymd1(BizDate pSyutkjyskgnhknnndeymd1) {
        syutkjyskgnhknnndeymd1 = pSyutkjyskgnhknnndeymd1;
    }

    private BizCurrency syutkjyskgns1;

    public BizCurrency getSyutkjyskgns1() {
        return syutkjyskgns1;
    }

    public void setSyutkjyskgns1(BizCurrency pSyutkjyskgns1) {
        syutkjyskgns1 = pSyutkjyskgns1;
    }

    private BizDate syutkjyskgnhknnndsymd2;

    public BizDate getSyutkjyskgnhknnndsymd2() {
        return syutkjyskgnhknnndsymd2;
    }

    public void setSyutkjyskgnhknnndsymd2(BizDate pSyutkjyskgnhknnndsymd2) {
        syutkjyskgnhknnndsymd2 = pSyutkjyskgnhknnndsymd2;
    }

    private BizDate syutkjyskgnhknnndeymd2;

    public BizDate getSyutkjyskgnhknnndeymd2() {
        return syutkjyskgnhknnndeymd2;
    }

    public void setSyutkjyskgnhknnndeymd2(BizDate pSyutkjyskgnhknnndeymd2) {
        syutkjyskgnhknnndeymd2 = pSyutkjyskgnhknnndeymd2;
    }

    private BizCurrency syutkjyskgns2;

    public BizCurrency getSyutkjyskgns2() {
        return syutkjyskgns2;
    }

    public void setSyutkjyskgns2(BizCurrency pSyutkjyskgns2) {
        syutkjyskgns2 = pSyutkjyskgns2;
    }

    private BizDate syutkjyskgnhknnndsymd3;

    public BizDate getSyutkjyskgnhknnndsymd3() {
        return syutkjyskgnhknnndsymd3;
    }

    public void setSyutkjyskgnhknnndsymd3(BizDate pSyutkjyskgnhknnndsymd3) {
        syutkjyskgnhknnndsymd3 = pSyutkjyskgnhknnndsymd3;
    }

    private BizDate syutkjyskgnhknnndeymd3;

    public BizDate getSyutkjyskgnhknnndeymd3() {
        return syutkjyskgnhknnndeymd3;
    }

    public void setSyutkjyskgnhknnndeymd3(BizDate pSyutkjyskgnhknnndeymd3) {
        syutkjyskgnhknnndeymd3 = pSyutkjyskgnhknnndeymd3;
    }

    private BizCurrency syutkjyskgns3;

    public BizCurrency getSyutkjyskgns3() {
        return syutkjyskgns3;
    }

    public void setSyutkjyskgns3(BizCurrency pSyutkjyskgns3) {
        syutkjyskgns3 = pSyutkjyskgns3;
    }

    private BizDate syutkjyskgnhknnndsymd4;

    public BizDate getSyutkjyskgnhknnndsymd4() {
        return syutkjyskgnhknnndsymd4;
    }

    public void setSyutkjyskgnhknnndsymd4(BizDate pSyutkjyskgnhknnndsymd4) {
        syutkjyskgnhknnndsymd4 = pSyutkjyskgnhknnndsymd4;
    }

    private BizDate syutkjyskgnhknnndeymd4;

    public BizDate getSyutkjyskgnhknnndeymd4() {
        return syutkjyskgnhknnndeymd4;
    }

    public void setSyutkjyskgnhknnndeymd4(BizDate pSyutkjyskgnhknnndeymd4) {
        syutkjyskgnhknnndeymd4 = pSyutkjyskgnhknnndeymd4;
    }

    private BizCurrency syutkjyskgns4;

    public BizCurrency getSyutkjyskgns4() {
        return syutkjyskgns4;
    }

    public void setSyutkjyskgns4(BizCurrency pSyutkjyskgns4) {
        syutkjyskgns4 = pSyutkjyskgns4;
    }

    private BizDate syutkjyskgnhknnndsymd5;

    public BizDate getSyutkjyskgnhknnndsymd5() {
        return syutkjyskgnhknnndsymd5;
    }

    public void setSyutkjyskgnhknnndsymd5(BizDate pSyutkjyskgnhknnndsymd5) {
        syutkjyskgnhknnndsymd5 = pSyutkjyskgnhknnndsymd5;
    }

    private BizDate syutkjyskgnhknnndeymd5;

    public BizDate getSyutkjyskgnhknnndeymd5() {
        return syutkjyskgnhknnndeymd5;
    }

    public void setSyutkjyskgnhknnndeymd5(BizDate pSyutkjyskgnhknnndeymd5) {
        syutkjyskgnhknnndeymd5 = pSyutkjyskgnhknnndeymd5;
    }

    private BizCurrency syutkjyskgns5;

    public BizCurrency getSyutkjyskgns5() {
        return syutkjyskgns5;
    }

    public void setSyutkjyskgns5(BizCurrency pSyutkjyskgns5) {
        syutkjyskgns5 = pSyutkjyskgns5;
    }

    private C_Tkjyhyouten syutkjyhyouten;

    public C_Tkjyhyouten getSyutkjyhyouten() {
        return syutkjyhyouten;
    }

    public void setSyutkjyhyouten(C_Tkjyhyouten pSyutkjyhyouten) {
        syutkjyhyouten = pSyutkjyhyouten;
    }

    private BizCurrency syutkjyp;

    public BizCurrency getSyutkjyp() {
        return syutkjyp;
    }

    public void setSyutkjyp(BizCurrency pSyutkjyp) {
        syutkjyp = pSyutkjyp;
    }

    private String syuhtnpbuicd1;

    public String getSyuhtnpbuicd1() {
        return syuhtnpbuicd1;
    }

    public void setSyuhtnpbuicd1(String pSyuhtnpbuicd1) {
        syuhtnpbuicd1 = pSyuhtnpbuicd1;
    }

    private String syuhtnpbuinm1;

    public String getSyuhtnpbuinm1() {
        return syuhtnpbuinm1;
    }

    public void setSyuhtnpbuinm1(String pSyuhtnpbuinm1) {
        syuhtnpbuinm1 = pSyuhtnpbuinm1;
    }

    private C_Htnpkkn syuhtnpkkn1;

    public C_Htnpkkn getSyuhtnpkkn1() {
        return syuhtnpkkn1;
    }

    public void setSyuhtnpkkn1(C_Htnpkkn pSyuhtnpkkn1) {
        syuhtnpkkn1 = pSyuhtnpkkn1;
    }

    private String syuhtnpbuicd2;

    public String getSyuhtnpbuicd2() {
        return syuhtnpbuicd2;
    }

    public void setSyuhtnpbuicd2(String pSyuhtnpbuicd2) {
        syuhtnpbuicd2 = pSyuhtnpbuicd2;
    }

    private String syuhtnpbuinm2;

    public String getSyuhtnpbuinm2() {
        return syuhtnpbuinm2;
    }

    public void setSyuhtnpbuinm2(String pSyuhtnpbuinm2) {
        syuhtnpbuinm2 = pSyuhtnpbuinm2;
    }

    private C_Htnpkkn syuhtnpkkn2;

    public C_Htnpkkn getSyuhtnpkkn2() {
        return syuhtnpkkn2;
    }

    public void setSyuhtnpkkn2(C_Htnpkkn pSyuhtnpkkn2) {
        syuhtnpkkn2 = pSyuhtnpkkn2;
    }

    private String syuhtnpbuicd3;

    public String getSyuhtnpbuicd3() {
        return syuhtnpbuicd3;
    }

    public void setSyuhtnpbuicd3(String pSyuhtnpbuicd3) {
        syuhtnpbuicd3 = pSyuhtnpbuicd3;
    }

    private String syuhtnpbuinm3;

    public String getSyuhtnpbuinm3() {
        return syuhtnpbuinm3;
    }

    public void setSyuhtnpbuinm3(String pSyuhtnpbuinm3) {
        syuhtnpbuinm3 = pSyuhtnpbuinm3;
    }

    private C_Htnpkkn syuhtnpkkn3;

    public C_Htnpkkn getSyuhtnpkkn3() {
        return syuhtnpkkn3;
    }

    public void setSyuhtnpkkn3(C_Htnpkkn pSyuhtnpkkn3) {
        syuhtnpkkn3 = pSyuhtnpkkn3;
    }

    private String syuhtnpbuicd4;

    public String getSyuhtnpbuicd4() {
        return syuhtnpbuicd4;
    }

    public void setSyuhtnpbuicd4(String pSyuhtnpbuicd4) {
        syuhtnpbuicd4 = pSyuhtnpbuicd4;
    }

    private String syuhtnpbuinm4;

    public String getSyuhtnpbuinm4() {
        return syuhtnpbuinm4;
    }

    public void setSyuhtnpbuinm4(String pSyuhtnpbuinm4) {
        syuhtnpbuinm4 = pSyuhtnpbuinm4;
    }

    private C_Htnpkkn syuhtnpkkn4;

    public C_Htnpkkn getSyuhtnpkkn4() {
        return syuhtnpkkn4;
    }

    public void setSyuhtnpkkn4(C_Htnpkkn pSyuhtnpkkn4) {
        syuhtnpkkn4 = pSyuhtnpkkn4;
    }

    private C_TokkoudosghtnpKbn syutokkoudosghtnpkbn;

    public C_TokkoudosghtnpKbn getSyutokkoudosghtnpkbn() {
        return syutokkoudosghtnpkbn;
    }

    public void setSyutokkoudosghtnpkbn(C_TokkoudosghtnpKbn pSyutokkoudosghtnpkbn) {
        syutokkoudosghtnpkbn = pSyutokkoudosghtnpkbn;
    }

    private BizDate syukouryokuhasseiymd;

    public BizDate getSyukouryokuhasseiymd() {
        return syukouryokuhasseiymd;
    }

    public void setSyukouryokuhasseiymd(BizDate pSyukouryokuhasseiymd) {
        syukouryokuhasseiymd = pSyukouryokuhasseiymd;
    }

    private String disptksyouhnnm1;

    public String getDisptksyouhnnm1() {
        return disptksyouhnnm1;
    }

    public void setDisptksyouhnnm1(String pDisptksyouhnnm1) {
        disptksyouhnnm1 = pDisptksyouhnnm1;
    }

    private C_KataKbn disptokuyakukatakbn1;

    public C_KataKbn getDisptokuyakukatakbn1() {
        return disptokuyakukatakbn1;
    }

    public void setDisptokuyakukatakbn1(C_KataKbn pDisptokuyakukatakbn1) {
        disptokuyakukatakbn1 = pDisptokuyakukatakbn1;
    }

    private C_KyhgndkataKbn disptkkyhgndkatakbn1;

    public C_KyhgndkataKbn getDisptkkyhgndkatakbn1() {
        return disptkkyhgndkatakbn1;
    }

    public void setDisptkkyhgndkatakbn1(C_KyhgndkataKbn pDisptkkyhgndkatakbn1) {
        disptkkyhgndkatakbn1 = pDisptkkyhgndkatakbn1;
    }

    private Integer disptkhhknnen1;

    public Integer getDisptkhhknnen1() {
        return disptkhhknnen1;
    }

    public void setDisptkhhknnen1(Integer pDisptkhhknnen1) {
        disptkhhknnen1 = pDisptkhhknnen1;
    }

    private BizDate disptkkykymd1;

    public BizDate getDisptkkykymd1() {
        return disptkkykymd1;
    }

    public void setDisptkkykymd1(BizDate pDisptkkykymd1) {
        disptkkykymd1 = pDisptkkykymd1;
    }

    private BizDate disptksknnkaisiymd1;

    public BizDate getDisptksknnkaisiymd1() {
        return disptksknnkaisiymd1;
    }

    public void setDisptksknnkaisiymd1(BizDate pDisptksknnkaisiymd1) {
        disptksknnkaisiymd1 = pDisptksknnkaisiymd1;
    }

    private BizDate disptkgansknnkaisiymd1;

    public BizDate getDisptkgansknnkaisiymd1() {
        return disptkgansknnkaisiymd1;
    }

    public void setDisptkgansknnkaisiymd1(BizDate pDisptkgansknnkaisiymd1) {
        disptkgansknnkaisiymd1 = pDisptkgansknnkaisiymd1;
    }

    private BizDate disptkhksknnkaisiymd1;

    public BizDate getDisptkhksknnkaisiymd1() {
        return disptkhksknnkaisiymd1;
    }

    public void setDisptkhksknnkaisiymd1(BizDate pDisptkhksknnkaisiymd1) {
        disptkhksknnkaisiymd1 = pDisptkhksknnkaisiymd1;
    }

    private BizDate disptkhkgansknnkaisiymd1;

    public BizDate getDisptkhkgansknnkaisiymd1() {
        return disptkhkgansknnkaisiymd1;
    }

    public void setDisptkhkgansknnkaisiymd1(BizDate pDisptkhkgansknnkaisiymd1) {
        disptkhkgansknnkaisiymd1 = pDisptkhkgansknnkaisiymd1;
    }

    private Integer disptkhknkkn1;

    public Integer getDisptkhknkkn1() {
        return disptkhknkkn1;
    }

    public void setDisptkhknkkn1(Integer pDisptkhknkkn1) {
        disptkhknkkn1 = pDisptkhknkkn1;
    }

    private C_HknkknsmnKbn disptkhknkknsmnkbn1;

    public C_HknkknsmnKbn getDisptkhknkknsmnkbn1() {
        return disptkhknkknsmnkbn1;
    }

    public void setDisptkhknkknsmnkbn1(C_HknkknsmnKbn pDisptkhknkknsmnkbn1) {
        disptkhknkknsmnkbn1 = pDisptkhknkknsmnkbn1;
    }

    private Integer disptkhrkkkn1;

    public Integer getDisptkhrkkkn1() {
        return disptkhrkkkn1;
    }

    public void setDisptkhrkkkn1(Integer pDisptkhrkkkn1) {
        disptkhrkkkn1 = pDisptkhrkkkn1;
    }

    private C_HrkkknsmnKbn disptkhrkkknsmnkbn1;

    public C_HrkkknsmnKbn getDisptkhrkkknsmnkbn1() {
        return disptkhrkkknsmnkbn1;
    }

    public void setDisptkhrkkknsmnkbn1(C_HrkkknsmnKbn pDisptkhrkkknsmnkbn1) {
        disptkhrkkknsmnkbn1 = pDisptkhrkkknsmnkbn1;
    }

    private C_KihonssyuruiKbn disptkkihonssyuruikbn1;

    public C_KihonssyuruiKbn getDisptkkihonssyuruikbn1() {
        return disptkkihonssyuruikbn1;
    }

    public void setDisptkkihonssyuruikbn1(C_KihonssyuruiKbn pDisptkkihonssyuruikbn1) {
        disptkkihonssyuruikbn1 = pDisptkkihonssyuruikbn1;
    }

    private BizCurrency disptkkihons1;

    public BizCurrency getDisptkkihons1() {
        return disptkkihons1;
    }

    public void setDisptkkihons1(BizCurrency pDisptkkihons1) {
        disptkkihons1 = pDisptkkihons1;
    }

    private BizCurrency disptktsnshrgndgk1;

    public BizCurrency getDisptktsnshrgndgk1() {
        return disptktsnshrgndgk1;
    }

    public void setDisptktsnshrgndgk1(BizCurrency pDisptktsnshrgndgk1) {
        disptktsnshrgndgk1 = pDisptktsnshrgndgk1;
    }

    private BizCurrency disptkp1;

    public BizCurrency getDisptkp1() {
        return disptkp1;
    }

    public void setDisptkp1(BizCurrency pDisptkp1) {
        disptkp1 = pDisptkp1;
    }

    private BizCurrency disptknextkosgop1;

    public BizCurrency getDisptknextkosgop1() {
        return disptknextkosgop1;
    }

    public void setDisptknextkosgop1(BizCurrency pDisptknextkosgop1) {
        disptknextkosgop1 = pDisptknextkosgop1;
    }

    private BizCurrency disptkgannyukyhntgk1;

    public BizCurrency getDisptkgannyukyhntgk1() {
        return disptkgannyukyhntgk1;
    }

    public void setDisptkgannyukyhntgk1(BizCurrency pDisptkgannyukyhntgk1) {
        disptkgannyukyhntgk1 = pDisptkgannyukyhntgk1;
    }

    private BizDate disptkshrskgnstartymd1;

    public BizDate getDisptkshrskgnstartymd1() {
        return disptkshrskgnstartymd1;
    }

    public void setDisptkshrskgnstartymd1(BizDate pDisptkshrskgnstartymd1) {
        disptkshrskgnstartymd1 = pDisptkshrskgnstartymd1;
    }

    private BizDate disptkshrskgnendymd1;

    public BizDate getDisptkshrskgnendymd1() {
        return disptkshrskgnendymd1;
    }

    public void setDisptkshrskgnendymd1(BizDate pDisptkshrskgnendymd1) {
        disptkshrskgnendymd1 = pDisptkshrskgnendymd1;
    }

    private BizCurrency disptkshrskgngos1;

    public BizCurrency getDisptkshrskgngos1() {
        return disptkshrskgngos1;
    }

    public void setDisptkshrskgngos1(BizCurrency pDisptkshrskgngos1) {
        disptkshrskgngos1 = pDisptkshrskgngos1;
    }

    private Integer disptkkrnbkkn1;

    public Integer getDisptkkrnbkkn1() {
        return disptkkrnbkkn1;
    }

    public void setDisptkkrnbkkn1(Integer pDisptkkrnbkkn1) {
        disptkkrnbkkn1 = pDisptkkrnbkkn1;
    }

    private BizDate disptknkshrstartymd1;

    public BizDate getDisptknkshrstartymd1() {
        return disptknkshrstartymd1;
    }

    public void setDisptknkshrstartymd1(BizDate pDisptknkshrstartymd1) {
        disptknkshrstartymd1 = pDisptknkshrstartymd1;
    }

    private C_Kknenkinsyu disptknenkinsyu1;

    public C_Kknenkinsyu getDisptknenkinsyu1() {
        return disptknenkinsyu1;
    }

    public void setDisptknenkinsyu1(C_Kknenkinsyu pDisptknenkinsyu1) {
        disptknenkinsyu1 = pDisptknenkinsyu1;
    }

    private Integer disptknenkinkkn1;

    public Integer getDisptknenkinkkn1() {
        return disptknenkinkkn1;
    }

    public void setDisptknenkinkkn1(Integer pDisptknenkinkkn1) {
        disptknenkinkkn1 = pDisptknenkinkkn1;
    }

    private BizCurrency disptknknengk1;

    public BizCurrency getDisptknknengk1() {
        return disptknknengk1;
    }

    public void setDisptknknengk1(BizCurrency pDisptknknengk1) {
        disptknknengk1 = pDisptknknengk1;
    }

    private C_Bnshrkaisuu disptkbnshrkaisuu1;

    public C_Bnshrkaisuu getDisptkbnshrkaisuu1() {
        return disptkbnshrkaisuu1;
    }

    public void setDisptkbnshrkaisuu1(C_Bnshrkaisuu pDisptkbnshrkaisuu1) {
        disptkbnshrkaisuu1 = pDisptkbnshrkaisuu1;
    }

    private C_Tkjyskgnkkn disptktkjyskgnkkn1;

    public C_Tkjyskgnkkn getDisptktkjyskgnkkn1() {
        return disptktkjyskgnkkn1;
    }

    public void setDisptktkjyskgnkkn1(C_Tkjyskgnkkn pDisptktkjyskgnkkn1) {
        disptktkjyskgnkkn1 = pDisptktkjyskgnkkn1;
    }

    private BizDate disptktkjyskgnhknnndsymd11;

    public BizDate getDisptktkjyskgnhknnndsymd11() {
        return disptktkjyskgnhknnndsymd11;
    }

    public void setDisptktkjyskgnhknnndsymd11(BizDate pDisptktkjyskgnhknnndsymd11) {
        disptktkjyskgnhknnndsymd11 = pDisptktkjyskgnhknnndsymd11;
    }

    private BizDate disptktkjyskgnhknnndeymd11;

    public BizDate getDisptktkjyskgnhknnndeymd11() {
        return disptktkjyskgnhknnndeymd11;
    }

    public void setDisptktkjyskgnhknnndeymd11(BizDate pDisptktkjyskgnhknnndeymd11) {
        disptktkjyskgnhknnndeymd11 = pDisptktkjyskgnhknnndeymd11;
    }

    private BizCurrency disptktkjyskgns11;

    public BizCurrency getDisptktkjyskgns11() {
        return disptktkjyskgns11;
    }

    public void setDisptktkjyskgns11(BizCurrency pDisptktkjyskgns11) {
        disptktkjyskgns11 = pDisptktkjyskgns11;
    }

    private BizDate disptktkjyskgnhknnndsymd21;

    public BizDate getDisptktkjyskgnhknnndsymd21() {
        return disptktkjyskgnhknnndsymd21;
    }

    public void setDisptktkjyskgnhknnndsymd21(BizDate pDisptktkjyskgnhknnndsymd21) {
        disptktkjyskgnhknnndsymd21 = pDisptktkjyskgnhknnndsymd21;
    }

    private BizDate disptktkjyskgnhknnndeymd21;

    public BizDate getDisptktkjyskgnhknnndeymd21() {
        return disptktkjyskgnhknnndeymd21;
    }

    public void setDisptktkjyskgnhknnndeymd21(BizDate pDisptktkjyskgnhknnndeymd21) {
        disptktkjyskgnhknnndeymd21 = pDisptktkjyskgnhknnndeymd21;
    }

    private BizCurrency disptktkjyskgns21;

    public BizCurrency getDisptktkjyskgns21() {
        return disptktkjyskgns21;
    }

    public void setDisptktkjyskgns21(BizCurrency pDisptktkjyskgns21) {
        disptktkjyskgns21 = pDisptktkjyskgns21;
    }

    private BizDate disptktkjyskgnhknnndsymd31;

    public BizDate getDisptktkjyskgnhknnndsymd31() {
        return disptktkjyskgnhknnndsymd31;
    }

    public void setDisptktkjyskgnhknnndsymd31(BizDate pDisptktkjyskgnhknnndsymd31) {
        disptktkjyskgnhknnndsymd31 = pDisptktkjyskgnhknnndsymd31;
    }

    private BizDate disptktkjyskgnhknnndeymd31;

    public BizDate getDisptktkjyskgnhknnndeymd31() {
        return disptktkjyskgnhknnndeymd31;
    }

    public void setDisptktkjyskgnhknnndeymd31(BizDate pDisptktkjyskgnhknnndeymd31) {
        disptktkjyskgnhknnndeymd31 = pDisptktkjyskgnhknnndeymd31;
    }

    private BizCurrency disptktkjyskgns31;

    public BizCurrency getDisptktkjyskgns31() {
        return disptktkjyskgns31;
    }

    public void setDisptktkjyskgns31(BizCurrency pDisptktkjyskgns31) {
        disptktkjyskgns31 = pDisptktkjyskgns31;
    }

    private BizDate disptktkjyskgnhknnndsymd41;

    public BizDate getDisptktkjyskgnhknnndsymd41() {
        return disptktkjyskgnhknnndsymd41;
    }

    public void setDisptktkjyskgnhknnndsymd41(BizDate pDisptktkjyskgnhknnndsymd41) {
        disptktkjyskgnhknnndsymd41 = pDisptktkjyskgnhknnndsymd41;
    }

    private BizDate disptktkjyskgnhknnndeymd41;

    public BizDate getDisptktkjyskgnhknnndeymd41() {
        return disptktkjyskgnhknnndeymd41;
    }

    public void setDisptktkjyskgnhknnndeymd41(BizDate pDisptktkjyskgnhknnndeymd41) {
        disptktkjyskgnhknnndeymd41 = pDisptktkjyskgnhknnndeymd41;
    }

    private BizCurrency disptktkjyskgns41;

    public BizCurrency getDisptktkjyskgns41() {
        return disptktkjyskgns41;
    }

    public void setDisptktkjyskgns41(BizCurrency pDisptktkjyskgns41) {
        disptktkjyskgns41 = pDisptktkjyskgns41;
    }

    private BizDate disptktkjyskgnhknnndsymd51;

    public BizDate getDisptktkjyskgnhknnndsymd51() {
        return disptktkjyskgnhknnndsymd51;
    }

    public void setDisptktkjyskgnhknnndsymd51(BizDate pDisptktkjyskgnhknnndsymd51) {
        disptktkjyskgnhknnndsymd51 = pDisptktkjyskgnhknnndsymd51;
    }

    private BizDate disptktkjyskgnhknnndeymd51;

    public BizDate getDisptktkjyskgnhknnndeymd51() {
        return disptktkjyskgnhknnndeymd51;
    }

    public void setDisptktkjyskgnhknnndeymd51(BizDate pDisptktkjyskgnhknnndeymd51) {
        disptktkjyskgnhknnndeymd51 = pDisptktkjyskgnhknnndeymd51;
    }

    private BizCurrency disptktkjyskgns51;

    public BizCurrency getDisptktkjyskgns51() {
        return disptktkjyskgns51;
    }

    public void setDisptktkjyskgns51(BizCurrency pDisptktkjyskgns51) {
        disptktkjyskgns51 = pDisptktkjyskgns51;
    }

    private C_Tkjyhyouten disptktkjyhyouten1;

    public C_Tkjyhyouten getDisptktkjyhyouten1() {
        return disptktkjyhyouten1;
    }

    public void setDisptktkjyhyouten1(C_Tkjyhyouten pDisptktkjyhyouten1) {
        disptktkjyhyouten1 = pDisptktkjyhyouten1;
    }

    private BizCurrency disptktkjyp1;

    public BizCurrency getDisptktkjyp1() {
        return disptktkjyp1;
    }

    public void setDisptktkjyp1(BizCurrency pDisptktkjyp1) {
        disptktkjyp1 = pDisptktkjyp1;
    }

    private String disptkhtnpbuicd11;

    public String getDisptkhtnpbuicd11() {
        return disptkhtnpbuicd11;
    }

    public void setDisptkhtnpbuicd11(String pDisptkhtnpbuicd11) {
        disptkhtnpbuicd11 = pDisptkhtnpbuicd11;
    }

    private String disptkhtnpbuinm11;

    public String getDisptkhtnpbuinm11() {
        return disptkhtnpbuinm11;
    }

    public void setDisptkhtnpbuinm11(String pDisptkhtnpbuinm11) {
        disptkhtnpbuinm11 = pDisptkhtnpbuinm11;
    }

    private C_Htnpkkn disptkhtnpkkn11;

    public C_Htnpkkn getDisptkhtnpkkn11() {
        return disptkhtnpkkn11;
    }

    public void setDisptkhtnpkkn11(C_Htnpkkn pDisptkhtnpkkn11) {
        disptkhtnpkkn11 = pDisptkhtnpkkn11;
    }

    private String disptkhtnpbuicd21;

    public String getDisptkhtnpbuicd21() {
        return disptkhtnpbuicd21;
    }

    public void setDisptkhtnpbuicd21(String pDisptkhtnpbuicd21) {
        disptkhtnpbuicd21 = pDisptkhtnpbuicd21;
    }

    private String disptkhtnpbuinm21;

    public String getDisptkhtnpbuinm21() {
        return disptkhtnpbuinm21;
    }

    public void setDisptkhtnpbuinm21(String pDisptkhtnpbuinm21) {
        disptkhtnpbuinm21 = pDisptkhtnpbuinm21;
    }

    private C_Htnpkkn disptkhtnpkkn21;

    public C_Htnpkkn getDisptkhtnpkkn21() {
        return disptkhtnpkkn21;
    }

    public void setDisptkhtnpkkn21(C_Htnpkkn pDisptkhtnpkkn21) {
        disptkhtnpkkn21 = pDisptkhtnpkkn21;
    }

    private String disptkhtnpbuicd31;

    public String getDisptkhtnpbuicd31() {
        return disptkhtnpbuicd31;
    }

    public void setDisptkhtnpbuicd31(String pDisptkhtnpbuicd31) {
        disptkhtnpbuicd31 = pDisptkhtnpbuicd31;
    }

    private String disptkhtnpbuinm31;

    public String getDisptkhtnpbuinm31() {
        return disptkhtnpbuinm31;
    }

    public void setDisptkhtnpbuinm31(String pDisptkhtnpbuinm31) {
        disptkhtnpbuinm31 = pDisptkhtnpbuinm31;
    }

    private C_Htnpkkn disptkhtnpkkn31;

    public C_Htnpkkn getDisptkhtnpkkn31() {
        return disptkhtnpkkn31;
    }

    public void setDisptkhtnpkkn31(C_Htnpkkn pDisptkhtnpkkn31) {
        disptkhtnpkkn31 = pDisptkhtnpkkn31;
    }

    private String disptkhtnpbuicd41;

    public String getDisptkhtnpbuicd41() {
        return disptkhtnpbuicd41;
    }

    public void setDisptkhtnpbuicd41(String pDisptkhtnpbuicd41) {
        disptkhtnpbuicd41 = pDisptkhtnpbuicd41;
    }

    private String disptkhtnpbuinm41;

    public String getDisptkhtnpbuinm41() {
        return disptkhtnpbuinm41;
    }

    public void setDisptkhtnpbuinm41(String pDisptkhtnpbuinm41) {
        disptkhtnpbuinm41 = pDisptkhtnpbuinm41;
    }

    private C_Htnpkkn disptkhtnpkkn41;

    public C_Htnpkkn getDisptkhtnpkkn41() {
        return disptkhtnpkkn41;
    }

    public void setDisptkhtnpkkn41(C_Htnpkkn pDisptkhtnpkkn41) {
        disptkhtnpkkn41 = pDisptkhtnpkkn41;
    }

    private C_TokkoudosghtnpKbn disptktokkoudosghtnpkbn1;

    public C_TokkoudosghtnpKbn getDisptktokkoudosghtnpkbn1() {
        return disptktokkoudosghtnpkbn1;
    }

    public void setDisptktokkoudosghtnpkbn1(C_TokkoudosghtnpKbn pDisptktokkoudosghtnpkbn1) {
        disptktokkoudosghtnpkbn1 = pDisptktokkoudosghtnpkbn1;
    }

    private BizDate disptkkouryokuhasseiymd1;

    public BizDate getDisptkkouryokuhasseiymd1() {
        return disptkkouryokuhasseiymd1;
    }

    public void setDisptkkouryokuhasseiymd1(BizDate pDisptkkouryokuhasseiymd1) {
        disptkkouryokuhasseiymd1 = pDisptkkouryokuhasseiymd1;
    }

    private String disptksyouhnnm2;

    public String getDisptksyouhnnm2() {
        return disptksyouhnnm2;
    }

    public void setDisptksyouhnnm2(String pDisptksyouhnnm2) {
        disptksyouhnnm2 = pDisptksyouhnnm2;
    }

    private C_KataKbn disptokuyakukatakbn2;

    public C_KataKbn getDisptokuyakukatakbn2() {
        return disptokuyakukatakbn2;
    }

    public void setDisptokuyakukatakbn2(C_KataKbn pDisptokuyakukatakbn2) {
        disptokuyakukatakbn2 = pDisptokuyakukatakbn2;
    }

    private C_KyhgndkataKbn disptkkyhgndkatakbn2;

    public C_KyhgndkataKbn getDisptkkyhgndkatakbn2() {
        return disptkkyhgndkatakbn2;
    }

    public void setDisptkkyhgndkatakbn2(C_KyhgndkataKbn pDisptkkyhgndkatakbn2) {
        disptkkyhgndkatakbn2 = pDisptkkyhgndkatakbn2;
    }

    private Integer disptkhhknnen2;

    public Integer getDisptkhhknnen2() {
        return disptkhhknnen2;
    }

    public void setDisptkhhknnen2(Integer pDisptkhhknnen2) {
        disptkhhknnen2 = pDisptkhhknnen2;
    }

    private BizDate disptkkykymd2;

    public BizDate getDisptkkykymd2() {
        return disptkkykymd2;
    }

    public void setDisptkkykymd2(BizDate pDisptkkykymd2) {
        disptkkykymd2 = pDisptkkykymd2;
    }

    private BizDate disptksknnkaisiymd2;

    public BizDate getDisptksknnkaisiymd2() {
        return disptksknnkaisiymd2;
    }

    public void setDisptksknnkaisiymd2(BizDate pDisptksknnkaisiymd2) {
        disptksknnkaisiymd2 = pDisptksknnkaisiymd2;
    }

    private BizDate disptkgansknnkaisiymd2;

    public BizDate getDisptkgansknnkaisiymd2() {
        return disptkgansknnkaisiymd2;
    }

    public void setDisptkgansknnkaisiymd2(BizDate pDisptkgansknnkaisiymd2) {
        disptkgansknnkaisiymd2 = pDisptkgansknnkaisiymd2;
    }

    private BizDate disptkhksknnkaisiymd2;

    public BizDate getDisptkhksknnkaisiymd2() {
        return disptkhksknnkaisiymd2;
    }

    public void setDisptkhksknnkaisiymd2(BizDate pDisptkhksknnkaisiymd2) {
        disptkhksknnkaisiymd2 = pDisptkhksknnkaisiymd2;
    }

    private BizDate disptkhkgansknnkaisiymd2;

    public BizDate getDisptkhkgansknnkaisiymd2() {
        return disptkhkgansknnkaisiymd2;
    }

    public void setDisptkhkgansknnkaisiymd2(BizDate pDisptkhkgansknnkaisiymd2) {
        disptkhkgansknnkaisiymd2 = pDisptkhkgansknnkaisiymd2;
    }

    private Integer disptkhknkkn2;

    public Integer getDisptkhknkkn2() {
        return disptkhknkkn2;
    }

    public void setDisptkhknkkn2(Integer pDisptkhknkkn2) {
        disptkhknkkn2 = pDisptkhknkkn2;
    }

    private C_HknkknsmnKbn disptkhknkknsmnkbn2;

    public C_HknkknsmnKbn getDisptkhknkknsmnkbn2() {
        return disptkhknkknsmnkbn2;
    }

    public void setDisptkhknkknsmnkbn2(C_HknkknsmnKbn pDisptkhknkknsmnkbn2) {
        disptkhknkknsmnkbn2 = pDisptkhknkknsmnkbn2;
    }

    private Integer disptkhrkkkn2;

    public Integer getDisptkhrkkkn2() {
        return disptkhrkkkn2;
    }

    public void setDisptkhrkkkn2(Integer pDisptkhrkkkn2) {
        disptkhrkkkn2 = pDisptkhrkkkn2;
    }

    private C_HrkkknsmnKbn disptkhrkkknsmnkbn2;

    public C_HrkkknsmnKbn getDisptkhrkkknsmnkbn2() {
        return disptkhrkkknsmnkbn2;
    }

    public void setDisptkhrkkknsmnkbn2(C_HrkkknsmnKbn pDisptkhrkkknsmnkbn2) {
        disptkhrkkknsmnkbn2 = pDisptkhrkkknsmnkbn2;
    }

    private C_KihonssyuruiKbn disptkkihonssyuruikbn2;

    public C_KihonssyuruiKbn getDisptkkihonssyuruikbn2() {
        return disptkkihonssyuruikbn2;
    }

    public void setDisptkkihonssyuruikbn2(C_KihonssyuruiKbn pDisptkkihonssyuruikbn2) {
        disptkkihonssyuruikbn2 = pDisptkkihonssyuruikbn2;
    }

    private BizCurrency disptkkihons2;

    public BizCurrency getDisptkkihons2() {
        return disptkkihons2;
    }

    public void setDisptkkihons2(BizCurrency pDisptkkihons2) {
        disptkkihons2 = pDisptkkihons2;
    }

    private BizCurrency disptktsnshrgndgk2;

    public BizCurrency getDisptktsnshrgndgk2() {
        return disptktsnshrgndgk2;
    }

    public void setDisptktsnshrgndgk2(BizCurrency pDisptktsnshrgndgk2) {
        disptktsnshrgndgk2 = pDisptktsnshrgndgk2;
    }

    private BizCurrency disptkp2;

    public BizCurrency getDisptkp2() {
        return disptkp2;
    }

    public void setDisptkp2(BizCurrency pDisptkp2) {
        disptkp2 = pDisptkp2;
    }

    private BizCurrency disptknextkosgop2;

    public BizCurrency getDisptknextkosgop2() {
        return disptknextkosgop2;
    }

    public void setDisptknextkosgop2(BizCurrency pDisptknextkosgop2) {
        disptknextkosgop2 = pDisptknextkosgop2;
    }

    private BizCurrency disptkgannyukyhntgk2;

    public BizCurrency getDisptkgannyukyhntgk2() {
        return disptkgannyukyhntgk2;
    }

    public void setDisptkgannyukyhntgk2(BizCurrency pDisptkgannyukyhntgk2) {
        disptkgannyukyhntgk2 = pDisptkgannyukyhntgk2;
    }

    private BizDate disptkshrskgnstartymd2;

    public BizDate getDisptkshrskgnstartymd2() {
        return disptkshrskgnstartymd2;
    }

    public void setDisptkshrskgnstartymd2(BizDate pDisptkshrskgnstartymd2) {
        disptkshrskgnstartymd2 = pDisptkshrskgnstartymd2;
    }

    private BizDate disptkshrskgnendymd2;

    public BizDate getDisptkshrskgnendymd2() {
        return disptkshrskgnendymd2;
    }

    public void setDisptkshrskgnendymd2(BizDate pDisptkshrskgnendymd2) {
        disptkshrskgnendymd2 = pDisptkshrskgnendymd2;
    }

    private BizCurrency disptkshrskgngos2;

    public BizCurrency getDisptkshrskgngos2() {
        return disptkshrskgngos2;
    }

    public void setDisptkshrskgngos2(BizCurrency pDisptkshrskgngos2) {
        disptkshrskgngos2 = pDisptkshrskgngos2;
    }

    private Integer disptkkrnbkkn2;

    public Integer getDisptkkrnbkkn2() {
        return disptkkrnbkkn2;
    }

    public void setDisptkkrnbkkn2(Integer pDisptkkrnbkkn2) {
        disptkkrnbkkn2 = pDisptkkrnbkkn2;
    }

    private BizDate disptknkshrstartymd2;

    public BizDate getDisptknkshrstartymd2() {
        return disptknkshrstartymd2;
    }

    public void setDisptknkshrstartymd2(BizDate pDisptknkshrstartymd2) {
        disptknkshrstartymd2 = pDisptknkshrstartymd2;
    }

    private C_Kknenkinsyu disptknenkinsyu2;

    public C_Kknenkinsyu getDisptknenkinsyu2() {
        return disptknenkinsyu2;
    }

    public void setDisptknenkinsyu2(C_Kknenkinsyu pDisptknenkinsyu2) {
        disptknenkinsyu2 = pDisptknenkinsyu2;
    }

    private Integer disptknenkinkkn2;

    public Integer getDisptknenkinkkn2() {
        return disptknenkinkkn2;
    }

    public void setDisptknenkinkkn2(Integer pDisptknenkinkkn2) {
        disptknenkinkkn2 = pDisptknenkinkkn2;
    }

    private BizCurrency disptknknengk2;

    public BizCurrency getDisptknknengk2() {
        return disptknknengk2;
    }

    public void setDisptknknengk2(BizCurrency pDisptknknengk2) {
        disptknknengk2 = pDisptknknengk2;
    }

    private C_Bnshrkaisuu disptkbnshrkaisuu2;

    public C_Bnshrkaisuu getDisptkbnshrkaisuu2() {
        return disptkbnshrkaisuu2;
    }

    public void setDisptkbnshrkaisuu2(C_Bnshrkaisuu pDisptkbnshrkaisuu2) {
        disptkbnshrkaisuu2 = pDisptkbnshrkaisuu2;
    }

    private C_Tkjyskgnkkn disptktkjyskgnkkn2;

    public C_Tkjyskgnkkn getDisptktkjyskgnkkn2() {
        return disptktkjyskgnkkn2;
    }

    public void setDisptktkjyskgnkkn2(C_Tkjyskgnkkn pDisptktkjyskgnkkn2) {
        disptktkjyskgnkkn2 = pDisptktkjyskgnkkn2;
    }

    private BizDate disptktkjyskgnhknnndsymd12;

    public BizDate getDisptktkjyskgnhknnndsymd12() {
        return disptktkjyskgnhknnndsymd12;
    }

    public void setDisptktkjyskgnhknnndsymd12(BizDate pDisptktkjyskgnhknnndsymd12) {
        disptktkjyskgnhknnndsymd12 = pDisptktkjyskgnhknnndsymd12;
    }

    private BizDate disptktkjyskgnhknnndeymd12;

    public BizDate getDisptktkjyskgnhknnndeymd12() {
        return disptktkjyskgnhknnndeymd12;
    }

    public void setDisptktkjyskgnhknnndeymd12(BizDate pDisptktkjyskgnhknnndeymd12) {
        disptktkjyskgnhknnndeymd12 = pDisptktkjyskgnhknnndeymd12;
    }

    private BizCurrency disptktkjyskgns12;

    public BizCurrency getDisptktkjyskgns12() {
        return disptktkjyskgns12;
    }

    public void setDisptktkjyskgns12(BizCurrency pDisptktkjyskgns12) {
        disptktkjyskgns12 = pDisptktkjyskgns12;
    }

    private BizDate disptktkjyskgnhknnndsymd22;

    public BizDate getDisptktkjyskgnhknnndsymd22() {
        return disptktkjyskgnhknnndsymd22;
    }

    public void setDisptktkjyskgnhknnndsymd22(BizDate pDisptktkjyskgnhknnndsymd22) {
        disptktkjyskgnhknnndsymd22 = pDisptktkjyskgnhknnndsymd22;
    }

    private BizDate disptktkjyskgnhknnndeymd22;

    public BizDate getDisptktkjyskgnhknnndeymd22() {
        return disptktkjyskgnhknnndeymd22;
    }

    public void setDisptktkjyskgnhknnndeymd22(BizDate pDisptktkjyskgnhknnndeymd22) {
        disptktkjyskgnhknnndeymd22 = pDisptktkjyskgnhknnndeymd22;
    }

    private BizCurrency disptktkjyskgns22;

    public BizCurrency getDisptktkjyskgns22() {
        return disptktkjyskgns22;
    }

    public void setDisptktkjyskgns22(BizCurrency pDisptktkjyskgns22) {
        disptktkjyskgns22 = pDisptktkjyskgns22;
    }

    private BizDate disptktkjyskgnhknnndsymd32;

    public BizDate getDisptktkjyskgnhknnndsymd32() {
        return disptktkjyskgnhknnndsymd32;
    }

    public void setDisptktkjyskgnhknnndsymd32(BizDate pDisptktkjyskgnhknnndsymd32) {
        disptktkjyskgnhknnndsymd32 = pDisptktkjyskgnhknnndsymd32;
    }

    private BizDate disptktkjyskgnhknnndeymd32;

    public BizDate getDisptktkjyskgnhknnndeymd32() {
        return disptktkjyskgnhknnndeymd32;
    }

    public void setDisptktkjyskgnhknnndeymd32(BizDate pDisptktkjyskgnhknnndeymd32) {
        disptktkjyskgnhknnndeymd32 = pDisptktkjyskgnhknnndeymd32;
    }

    private BizCurrency disptktkjyskgns32;

    public BizCurrency getDisptktkjyskgns32() {
        return disptktkjyskgns32;
    }

    public void setDisptktkjyskgns32(BizCurrency pDisptktkjyskgns32) {
        disptktkjyskgns32 = pDisptktkjyskgns32;
    }

    private BizDate disptktkjyskgnhknnndsymd42;

    public BizDate getDisptktkjyskgnhknnndsymd42() {
        return disptktkjyskgnhknnndsymd42;
    }

    public void setDisptktkjyskgnhknnndsymd42(BizDate pDisptktkjyskgnhknnndsymd42) {
        disptktkjyskgnhknnndsymd42 = pDisptktkjyskgnhknnndsymd42;
    }

    private BizDate disptktkjyskgnhknnndeymd42;

    public BizDate getDisptktkjyskgnhknnndeymd42() {
        return disptktkjyskgnhknnndeymd42;
    }

    public void setDisptktkjyskgnhknnndeymd42(BizDate pDisptktkjyskgnhknnndeymd42) {
        disptktkjyskgnhknnndeymd42 = pDisptktkjyskgnhknnndeymd42;
    }

    private BizCurrency disptktkjyskgns42;

    public BizCurrency getDisptktkjyskgns42() {
        return disptktkjyskgns42;
    }

    public void setDisptktkjyskgns42(BizCurrency pDisptktkjyskgns42) {
        disptktkjyskgns42 = pDisptktkjyskgns42;
    }

    private BizDate disptktkjyskgnhknnndsymd52;

    public BizDate getDisptktkjyskgnhknnndsymd52() {
        return disptktkjyskgnhknnndsymd52;
    }

    public void setDisptktkjyskgnhknnndsymd52(BizDate pDisptktkjyskgnhknnndsymd52) {
        disptktkjyskgnhknnndsymd52 = pDisptktkjyskgnhknnndsymd52;
    }

    private BizDate disptktkjyskgnhknnndeymd52;

    public BizDate getDisptktkjyskgnhknnndeymd52() {
        return disptktkjyskgnhknnndeymd52;
    }

    public void setDisptktkjyskgnhknnndeymd52(BizDate pDisptktkjyskgnhknnndeymd52) {
        disptktkjyskgnhknnndeymd52 = pDisptktkjyskgnhknnndeymd52;
    }

    private BizCurrency disptktkjyskgns52;

    public BizCurrency getDisptktkjyskgns52() {
        return disptktkjyskgns52;
    }

    public void setDisptktkjyskgns52(BizCurrency pDisptktkjyskgns52) {
        disptktkjyskgns52 = pDisptktkjyskgns52;
    }

    private C_Tkjyhyouten disptktkjyhyouten2;

    public C_Tkjyhyouten getDisptktkjyhyouten2() {
        return disptktkjyhyouten2;
    }

    public void setDisptktkjyhyouten2(C_Tkjyhyouten pDisptktkjyhyouten2) {
        disptktkjyhyouten2 = pDisptktkjyhyouten2;
    }

    private BizCurrency disptktkjyp2;

    public BizCurrency getDisptktkjyp2() {
        return disptktkjyp2;
    }

    public void setDisptktkjyp2(BizCurrency pDisptktkjyp2) {
        disptktkjyp2 = pDisptktkjyp2;
    }

    private String disptkhtnpbuicd12;

    public String getDisptkhtnpbuicd12() {
        return disptkhtnpbuicd12;
    }

    public void setDisptkhtnpbuicd12(String pDisptkhtnpbuicd12) {
        disptkhtnpbuicd12 = pDisptkhtnpbuicd12;
    }

    private String disptkhtnpbuinm12;

    public String getDisptkhtnpbuinm12() {
        return disptkhtnpbuinm12;
    }

    public void setDisptkhtnpbuinm12(String pDisptkhtnpbuinm12) {
        disptkhtnpbuinm12 = pDisptkhtnpbuinm12;
    }

    private C_Htnpkkn disptkhtnpkkn12;

    public C_Htnpkkn getDisptkhtnpkkn12() {
        return disptkhtnpkkn12;
    }

    public void setDisptkhtnpkkn12(C_Htnpkkn pDisptkhtnpkkn12) {
        disptkhtnpkkn12 = pDisptkhtnpkkn12;
    }

    private String disptkhtnpbuicd22;

    public String getDisptkhtnpbuicd22() {
        return disptkhtnpbuicd22;
    }

    public void setDisptkhtnpbuicd22(String pDisptkhtnpbuicd22) {
        disptkhtnpbuicd22 = pDisptkhtnpbuicd22;
    }

    private String disptkhtnpbuinm22;

    public String getDisptkhtnpbuinm22() {
        return disptkhtnpbuinm22;
    }

    public void setDisptkhtnpbuinm22(String pDisptkhtnpbuinm22) {
        disptkhtnpbuinm22 = pDisptkhtnpbuinm22;
    }

    private C_Htnpkkn disptkhtnpkkn22;

    public C_Htnpkkn getDisptkhtnpkkn22() {
        return disptkhtnpkkn22;
    }

    public void setDisptkhtnpkkn22(C_Htnpkkn pDisptkhtnpkkn22) {
        disptkhtnpkkn22 = pDisptkhtnpkkn22;
    }

    private String disptkhtnpbuicd32;

    public String getDisptkhtnpbuicd32() {
        return disptkhtnpbuicd32;
    }

    public void setDisptkhtnpbuicd32(String pDisptkhtnpbuicd32) {
        disptkhtnpbuicd32 = pDisptkhtnpbuicd32;
    }

    private String disptkhtnpbuinm32;

    public String getDisptkhtnpbuinm32() {
        return disptkhtnpbuinm32;
    }

    public void setDisptkhtnpbuinm32(String pDisptkhtnpbuinm32) {
        disptkhtnpbuinm32 = pDisptkhtnpbuinm32;
    }

    private C_Htnpkkn disptkhtnpkkn32;

    public C_Htnpkkn getDisptkhtnpkkn32() {
        return disptkhtnpkkn32;
    }

    public void setDisptkhtnpkkn32(C_Htnpkkn pDisptkhtnpkkn32) {
        disptkhtnpkkn32 = pDisptkhtnpkkn32;
    }

    private String disptkhtnpbuicd42;

    public String getDisptkhtnpbuicd42() {
        return disptkhtnpbuicd42;
    }

    public void setDisptkhtnpbuicd42(String pDisptkhtnpbuicd42) {
        disptkhtnpbuicd42 = pDisptkhtnpbuicd42;
    }

    private String disptkhtnpbuinm42;

    public String getDisptkhtnpbuinm42() {
        return disptkhtnpbuinm42;
    }

    public void setDisptkhtnpbuinm42(String pDisptkhtnpbuinm42) {
        disptkhtnpbuinm42 = pDisptkhtnpbuinm42;
    }

    private C_Htnpkkn disptkhtnpkkn42;

    public C_Htnpkkn getDisptkhtnpkkn42() {
        return disptkhtnpkkn42;
    }

    public void setDisptkhtnpkkn42(C_Htnpkkn pDisptkhtnpkkn42) {
        disptkhtnpkkn42 = pDisptkhtnpkkn42;
    }

    private C_TokkoudosghtnpKbn disptktokkoudosghtnpkbn2;

    public C_TokkoudosghtnpKbn getDisptktokkoudosghtnpkbn2() {
        return disptktokkoudosghtnpkbn2;
    }

    public void setDisptktokkoudosghtnpkbn2(C_TokkoudosghtnpKbn pDisptktokkoudosghtnpkbn2) {
        disptktokkoudosghtnpkbn2 = pDisptktokkoudosghtnpkbn2;
    }

    private BizDate disptkkouryokuhasseiymd2;

    public BizDate getDisptkkouryokuhasseiymd2() {
        return disptkkouryokuhasseiymd2;
    }

    public void setDisptkkouryokuhasseiymd2(BizDate pDisptkkouryokuhasseiymd2) {
        disptkkouryokuhasseiymd2 = pDisptkkouryokuhasseiymd2;
    }

    private String disptksyouhnnm3;

    public String getDisptksyouhnnm3() {
        return disptksyouhnnm3;
    }

    public void setDisptksyouhnnm3(String pDisptksyouhnnm3) {
        disptksyouhnnm3 = pDisptksyouhnnm3;
    }

    private C_KataKbn disptokuyakukatakbn3;

    public C_KataKbn getDisptokuyakukatakbn3() {
        return disptokuyakukatakbn3;
    }

    public void setDisptokuyakukatakbn3(C_KataKbn pDisptokuyakukatakbn3) {
        disptokuyakukatakbn3 = pDisptokuyakukatakbn3;
    }

    private C_KyhgndkataKbn disptkkyhgndkatakbn3;

    public C_KyhgndkataKbn getDisptkkyhgndkatakbn3() {
        return disptkkyhgndkatakbn3;
    }

    public void setDisptkkyhgndkatakbn3(C_KyhgndkataKbn pDisptkkyhgndkatakbn3) {
        disptkkyhgndkatakbn3 = pDisptkkyhgndkatakbn3;
    }

    private Integer disptkhhknnen3;

    public Integer getDisptkhhknnen3() {
        return disptkhhknnen3;
    }

    public void setDisptkhhknnen3(Integer pDisptkhhknnen3) {
        disptkhhknnen3 = pDisptkhhknnen3;
    }

    private BizDate disptkkykymd3;

    public BizDate getDisptkkykymd3() {
        return disptkkykymd3;
    }

    public void setDisptkkykymd3(BizDate pDisptkkykymd3) {
        disptkkykymd3 = pDisptkkykymd3;
    }

    private BizDate disptksknnkaisiymd3;

    public BizDate getDisptksknnkaisiymd3() {
        return disptksknnkaisiymd3;
    }

    public void setDisptksknnkaisiymd3(BizDate pDisptksknnkaisiymd3) {
        disptksknnkaisiymd3 = pDisptksknnkaisiymd3;
    }

    private BizDate disptkgansknnkaisiymd3;

    public BizDate getDisptkgansknnkaisiymd3() {
        return disptkgansknnkaisiymd3;
    }

    public void setDisptkgansknnkaisiymd3(BizDate pDisptkgansknnkaisiymd3) {
        disptkgansknnkaisiymd3 = pDisptkgansknnkaisiymd3;
    }

    private BizDate disptkhksknnkaisiymd3;

    public BizDate getDisptkhksknnkaisiymd3() {
        return disptkhksknnkaisiymd3;
    }

    public void setDisptkhksknnkaisiymd3(BizDate pDisptkhksknnkaisiymd3) {
        disptkhksknnkaisiymd3 = pDisptkhksknnkaisiymd3;
    }

    private BizDate disptkhkgansknnkaisiymd3;

    public BizDate getDisptkhkgansknnkaisiymd3() {
        return disptkhkgansknnkaisiymd3;
    }

    public void setDisptkhkgansknnkaisiymd3(BizDate pDisptkhkgansknnkaisiymd3) {
        disptkhkgansknnkaisiymd3 = pDisptkhkgansknnkaisiymd3;
    }

    private Integer disptkhknkkn3;

    public Integer getDisptkhknkkn3() {
        return disptkhknkkn3;
    }

    public void setDisptkhknkkn3(Integer pDisptkhknkkn3) {
        disptkhknkkn3 = pDisptkhknkkn3;
    }

    private C_HknkknsmnKbn disptkhknkknsmnkbn3;

    public C_HknkknsmnKbn getDisptkhknkknsmnkbn3() {
        return disptkhknkknsmnkbn3;
    }

    public void setDisptkhknkknsmnkbn3(C_HknkknsmnKbn pDisptkhknkknsmnkbn3) {
        disptkhknkknsmnkbn3 = pDisptkhknkknsmnkbn3;
    }

    private Integer disptkhrkkkn3;

    public Integer getDisptkhrkkkn3() {
        return disptkhrkkkn3;
    }

    public void setDisptkhrkkkn3(Integer pDisptkhrkkkn3) {
        disptkhrkkkn3 = pDisptkhrkkkn3;
    }

    private C_HrkkknsmnKbn disptkhrkkknsmnkbn3;

    public C_HrkkknsmnKbn getDisptkhrkkknsmnkbn3() {
        return disptkhrkkknsmnkbn3;
    }

    public void setDisptkhrkkknsmnkbn3(C_HrkkknsmnKbn pDisptkhrkkknsmnkbn3) {
        disptkhrkkknsmnkbn3 = pDisptkhrkkknsmnkbn3;
    }

    private C_KihonssyuruiKbn disptkkihonssyuruikbn3;

    public C_KihonssyuruiKbn getDisptkkihonssyuruikbn3() {
        return disptkkihonssyuruikbn3;
    }

    public void setDisptkkihonssyuruikbn3(C_KihonssyuruiKbn pDisptkkihonssyuruikbn3) {
        disptkkihonssyuruikbn3 = pDisptkkihonssyuruikbn3;
    }

    private BizCurrency disptkkihons3;

    public BizCurrency getDisptkkihons3() {
        return disptkkihons3;
    }

    public void setDisptkkihons3(BizCurrency pDisptkkihons3) {
        disptkkihons3 = pDisptkkihons3;
    }

    private BizCurrency disptktsnshrgndgk3;

    public BizCurrency getDisptktsnshrgndgk3() {
        return disptktsnshrgndgk3;
    }

    public void setDisptktsnshrgndgk3(BizCurrency pDisptktsnshrgndgk3) {
        disptktsnshrgndgk3 = pDisptktsnshrgndgk3;
    }

    private BizCurrency disptkp3;

    public BizCurrency getDisptkp3() {
        return disptkp3;
    }

    public void setDisptkp3(BizCurrency pDisptkp3) {
        disptkp3 = pDisptkp3;
    }

    private BizCurrency disptknextkosgop3;

    public BizCurrency getDisptknextkosgop3() {
        return disptknextkosgop3;
    }

    public void setDisptknextkosgop3(BizCurrency pDisptknextkosgop3) {
        disptknextkosgop3 = pDisptknextkosgop3;
    }

    private BizCurrency disptkgannyukyhntgk3;

    public BizCurrency getDisptkgannyukyhntgk3() {
        return disptkgannyukyhntgk3;
    }

    public void setDisptkgannyukyhntgk3(BizCurrency pDisptkgannyukyhntgk3) {
        disptkgannyukyhntgk3 = pDisptkgannyukyhntgk3;
    }

    private BizDate disptkshrskgnstartymd3;

    public BizDate getDisptkshrskgnstartymd3() {
        return disptkshrskgnstartymd3;
    }

    public void setDisptkshrskgnstartymd3(BizDate pDisptkshrskgnstartymd3) {
        disptkshrskgnstartymd3 = pDisptkshrskgnstartymd3;
    }

    private BizDate disptkshrskgnendymd3;

    public BizDate getDisptkshrskgnendymd3() {
        return disptkshrskgnendymd3;
    }

    public void setDisptkshrskgnendymd3(BizDate pDisptkshrskgnendymd3) {
        disptkshrskgnendymd3 = pDisptkshrskgnendymd3;
    }

    private BizCurrency disptkshrskgngos3;

    public BizCurrency getDisptkshrskgngos3() {
        return disptkshrskgngos3;
    }

    public void setDisptkshrskgngos3(BizCurrency pDisptkshrskgngos3) {
        disptkshrskgngos3 = pDisptkshrskgngos3;
    }

    private Integer disptkkrnbkkn3;

    public Integer getDisptkkrnbkkn3() {
        return disptkkrnbkkn3;
    }

    public void setDisptkkrnbkkn3(Integer pDisptkkrnbkkn3) {
        disptkkrnbkkn3 = pDisptkkrnbkkn3;
    }

    private BizDate disptknkshrstartymd3;

    public BizDate getDisptknkshrstartymd3() {
        return disptknkshrstartymd3;
    }

    public void setDisptknkshrstartymd3(BizDate pDisptknkshrstartymd3) {
        disptknkshrstartymd3 = pDisptknkshrstartymd3;
    }

    private C_Kknenkinsyu disptknenkinsyu3;

    public C_Kknenkinsyu getDisptknenkinsyu3() {
        return disptknenkinsyu3;
    }

    public void setDisptknenkinsyu3(C_Kknenkinsyu pDisptknenkinsyu3) {
        disptknenkinsyu3 = pDisptknenkinsyu3;
    }

    private Integer disptknenkinkkn3;

    public Integer getDisptknenkinkkn3() {
        return disptknenkinkkn3;
    }

    public void setDisptknenkinkkn3(Integer pDisptknenkinkkn3) {
        disptknenkinkkn3 = pDisptknenkinkkn3;
    }

    private BizCurrency disptknknengk3;

    public BizCurrency getDisptknknengk3() {
        return disptknknengk3;
    }

    public void setDisptknknengk3(BizCurrency pDisptknknengk3) {
        disptknknengk3 = pDisptknknengk3;
    }

    private C_Bnshrkaisuu disptkbnshrkaisuu3;

    public C_Bnshrkaisuu getDisptkbnshrkaisuu3() {
        return disptkbnshrkaisuu3;
    }

    public void setDisptkbnshrkaisuu3(C_Bnshrkaisuu pDisptkbnshrkaisuu3) {
        disptkbnshrkaisuu3 = pDisptkbnshrkaisuu3;
    }

    private C_Tkjyskgnkkn disptktkjyskgnkkn3;

    public C_Tkjyskgnkkn getDisptktkjyskgnkkn3() {
        return disptktkjyskgnkkn3;
    }

    public void setDisptktkjyskgnkkn3(C_Tkjyskgnkkn pDisptktkjyskgnkkn3) {
        disptktkjyskgnkkn3 = pDisptktkjyskgnkkn3;
    }

    private BizDate disptktkjyskgnhknnndsymd13;

    public BizDate getDisptktkjyskgnhknnndsymd13() {
        return disptktkjyskgnhknnndsymd13;
    }

    public void setDisptktkjyskgnhknnndsymd13(BizDate pDisptktkjyskgnhknnndsymd13) {
        disptktkjyskgnhknnndsymd13 = pDisptktkjyskgnhknnndsymd13;
    }

    private BizDate disptktkjyskgnhknnndeymd13;

    public BizDate getDisptktkjyskgnhknnndeymd13() {
        return disptktkjyskgnhknnndeymd13;
    }

    public void setDisptktkjyskgnhknnndeymd13(BizDate pDisptktkjyskgnhknnndeymd13) {
        disptktkjyskgnhknnndeymd13 = pDisptktkjyskgnhknnndeymd13;
    }

    private BizCurrency disptktkjyskgns13;

    public BizCurrency getDisptktkjyskgns13() {
        return disptktkjyskgns13;
    }

    public void setDisptktkjyskgns13(BizCurrency pDisptktkjyskgns13) {
        disptktkjyskgns13 = pDisptktkjyskgns13;
    }

    private BizDate disptktkjyskgnhknnndsymd23;

    public BizDate getDisptktkjyskgnhknnndsymd23() {
        return disptktkjyskgnhknnndsymd23;
    }

    public void setDisptktkjyskgnhknnndsymd23(BizDate pDisptktkjyskgnhknnndsymd23) {
        disptktkjyskgnhknnndsymd23 = pDisptktkjyskgnhknnndsymd23;
    }

    private BizDate disptktkjyskgnhknnndeymd23;

    public BizDate getDisptktkjyskgnhknnndeymd23() {
        return disptktkjyskgnhknnndeymd23;
    }

    public void setDisptktkjyskgnhknnndeymd23(BizDate pDisptktkjyskgnhknnndeymd23) {
        disptktkjyskgnhknnndeymd23 = pDisptktkjyskgnhknnndeymd23;
    }

    private BizCurrency disptktkjyskgns23;

    public BizCurrency getDisptktkjyskgns23() {
        return disptktkjyskgns23;
    }

    public void setDisptktkjyskgns23(BizCurrency pDisptktkjyskgns23) {
        disptktkjyskgns23 = pDisptktkjyskgns23;
    }

    private BizDate disptktkjyskgnhknnndsymd33;

    public BizDate getDisptktkjyskgnhknnndsymd33() {
        return disptktkjyskgnhknnndsymd33;
    }

    public void setDisptktkjyskgnhknnndsymd33(BizDate pDisptktkjyskgnhknnndsymd33) {
        disptktkjyskgnhknnndsymd33 = pDisptktkjyskgnhknnndsymd33;
    }

    private BizDate disptktkjyskgnhknnndeymd33;

    public BizDate getDisptktkjyskgnhknnndeymd33() {
        return disptktkjyskgnhknnndeymd33;
    }

    public void setDisptktkjyskgnhknnndeymd33(BizDate pDisptktkjyskgnhknnndeymd33) {
        disptktkjyskgnhknnndeymd33 = pDisptktkjyskgnhknnndeymd33;
    }

    private BizCurrency disptktkjyskgns33;

    public BizCurrency getDisptktkjyskgns33() {
        return disptktkjyskgns33;
    }

    public void setDisptktkjyskgns33(BizCurrency pDisptktkjyskgns33) {
        disptktkjyskgns33 = pDisptktkjyskgns33;
    }

    private BizDate disptktkjyskgnhknnndsymd43;

    public BizDate getDisptktkjyskgnhknnndsymd43() {
        return disptktkjyskgnhknnndsymd43;
    }

    public void setDisptktkjyskgnhknnndsymd43(BizDate pDisptktkjyskgnhknnndsymd43) {
        disptktkjyskgnhknnndsymd43 = pDisptktkjyskgnhknnndsymd43;
    }

    private BizDate disptktkjyskgnhknnndeymd43;

    public BizDate getDisptktkjyskgnhknnndeymd43() {
        return disptktkjyskgnhknnndeymd43;
    }

    public void setDisptktkjyskgnhknnndeymd43(BizDate pDisptktkjyskgnhknnndeymd43) {
        disptktkjyskgnhknnndeymd43 = pDisptktkjyskgnhknnndeymd43;
    }

    private BizCurrency disptktkjyskgns43;

    public BizCurrency getDisptktkjyskgns43() {
        return disptktkjyskgns43;
    }

    public void setDisptktkjyskgns43(BizCurrency pDisptktkjyskgns43) {
        disptktkjyskgns43 = pDisptktkjyskgns43;
    }

    private BizDate disptktkjyskgnhknnndsymd53;

    public BizDate getDisptktkjyskgnhknnndsymd53() {
        return disptktkjyskgnhknnndsymd53;
    }

    public void setDisptktkjyskgnhknnndsymd53(BizDate pDisptktkjyskgnhknnndsymd53) {
        disptktkjyskgnhknnndsymd53 = pDisptktkjyskgnhknnndsymd53;
    }

    private BizDate disptktkjyskgnhknnndeymd53;

    public BizDate getDisptktkjyskgnhknnndeymd53() {
        return disptktkjyskgnhknnndeymd53;
    }

    public void setDisptktkjyskgnhknnndeymd53(BizDate pDisptktkjyskgnhknnndeymd53) {
        disptktkjyskgnhknnndeymd53 = pDisptktkjyskgnhknnndeymd53;
    }

    private BizCurrency disptktkjyskgns53;

    public BizCurrency getDisptktkjyskgns53() {
        return disptktkjyskgns53;
    }

    public void setDisptktkjyskgns53(BizCurrency pDisptktkjyskgns53) {
        disptktkjyskgns53 = pDisptktkjyskgns53;
    }

    private C_Tkjyhyouten disptktkjyhyouten3;

    public C_Tkjyhyouten getDisptktkjyhyouten3() {
        return disptktkjyhyouten3;
    }

    public void setDisptktkjyhyouten3(C_Tkjyhyouten pDisptktkjyhyouten3) {
        disptktkjyhyouten3 = pDisptktkjyhyouten3;
    }

    private BizCurrency disptktkjyp3;

    public BizCurrency getDisptktkjyp3() {
        return disptktkjyp3;
    }

    public void setDisptktkjyp3(BizCurrency pDisptktkjyp3) {
        disptktkjyp3 = pDisptktkjyp3;
    }

    private String disptkhtnpbuicd13;

    public String getDisptkhtnpbuicd13() {
        return disptkhtnpbuicd13;
    }

    public void setDisptkhtnpbuicd13(String pDisptkhtnpbuicd13) {
        disptkhtnpbuicd13 = pDisptkhtnpbuicd13;
    }

    private String disptkhtnpbuinm13;

    public String getDisptkhtnpbuinm13() {
        return disptkhtnpbuinm13;
    }

    public void setDisptkhtnpbuinm13(String pDisptkhtnpbuinm13) {
        disptkhtnpbuinm13 = pDisptkhtnpbuinm13;
    }

    private C_Htnpkkn disptkhtnpkkn13;

    public C_Htnpkkn getDisptkhtnpkkn13() {
        return disptkhtnpkkn13;
    }

    public void setDisptkhtnpkkn13(C_Htnpkkn pDisptkhtnpkkn13) {
        disptkhtnpkkn13 = pDisptkhtnpkkn13;
    }

    private String disptkhtnpbuicd23;

    public String getDisptkhtnpbuicd23() {
        return disptkhtnpbuicd23;
    }

    public void setDisptkhtnpbuicd23(String pDisptkhtnpbuicd23) {
        disptkhtnpbuicd23 = pDisptkhtnpbuicd23;
    }

    private String disptkhtnpbuinm23;

    public String getDisptkhtnpbuinm23() {
        return disptkhtnpbuinm23;
    }

    public void setDisptkhtnpbuinm23(String pDisptkhtnpbuinm23) {
        disptkhtnpbuinm23 = pDisptkhtnpbuinm23;
    }

    private C_Htnpkkn disptkhtnpkkn23;

    public C_Htnpkkn getDisptkhtnpkkn23() {
        return disptkhtnpkkn23;
    }

    public void setDisptkhtnpkkn23(C_Htnpkkn pDisptkhtnpkkn23) {
        disptkhtnpkkn23 = pDisptkhtnpkkn23;
    }

    private String disptkhtnpbuicd33;

    public String getDisptkhtnpbuicd33() {
        return disptkhtnpbuicd33;
    }

    public void setDisptkhtnpbuicd33(String pDisptkhtnpbuicd33) {
        disptkhtnpbuicd33 = pDisptkhtnpbuicd33;
    }

    private String disptkhtnpbuinm33;

    public String getDisptkhtnpbuinm33() {
        return disptkhtnpbuinm33;
    }

    public void setDisptkhtnpbuinm33(String pDisptkhtnpbuinm33) {
        disptkhtnpbuinm33 = pDisptkhtnpbuinm33;
    }

    private C_Htnpkkn disptkhtnpkkn33;

    public C_Htnpkkn getDisptkhtnpkkn33() {
        return disptkhtnpkkn33;
    }

    public void setDisptkhtnpkkn33(C_Htnpkkn pDisptkhtnpkkn33) {
        disptkhtnpkkn33 = pDisptkhtnpkkn33;
    }

    private String disptkhtnpbuicd43;

    public String getDisptkhtnpbuicd43() {
        return disptkhtnpbuicd43;
    }

    public void setDisptkhtnpbuicd43(String pDisptkhtnpbuicd43) {
        disptkhtnpbuicd43 = pDisptkhtnpbuicd43;
    }

    private String disptkhtnpbuinm43;

    public String getDisptkhtnpbuinm43() {
        return disptkhtnpbuinm43;
    }

    public void setDisptkhtnpbuinm43(String pDisptkhtnpbuinm43) {
        disptkhtnpbuinm43 = pDisptkhtnpbuinm43;
    }

    private C_Htnpkkn disptkhtnpkkn43;

    public C_Htnpkkn getDisptkhtnpkkn43() {
        return disptkhtnpkkn43;
    }

    public void setDisptkhtnpkkn43(C_Htnpkkn pDisptkhtnpkkn43) {
        disptkhtnpkkn43 = pDisptkhtnpkkn43;
    }

    private C_TokkoudosghtnpKbn disptktokkoudosghtnpkbn3;

    public C_TokkoudosghtnpKbn getDisptktokkoudosghtnpkbn3() {
        return disptktokkoudosghtnpkbn3;
    }

    public void setDisptktokkoudosghtnpkbn3(C_TokkoudosghtnpKbn pDisptktokkoudosghtnpkbn3) {
        disptktokkoudosghtnpkbn3 = pDisptktokkoudosghtnpkbn3;
    }

    private BizDate disptkkouryokuhasseiymd3;

    public BizDate getDisptkkouryokuhasseiymd3() {
        return disptkkouryokuhasseiymd3;
    }

    public void setDisptkkouryokuhasseiymd3(BizDate pDisptkkouryokuhasseiymd3) {
        disptkkouryokuhasseiymd3 = pDisptkkouryokuhasseiymd3;
    }

    private String disptksyouhnnm4;

    public String getDisptksyouhnnm4() {
        return disptksyouhnnm4;
    }

    public void setDisptksyouhnnm4(String pDisptksyouhnnm4) {
        disptksyouhnnm4 = pDisptksyouhnnm4;
    }

    private C_KataKbn disptokuyakukatakbn4;

    public C_KataKbn getDisptokuyakukatakbn4() {
        return disptokuyakukatakbn4;
    }

    public void setDisptokuyakukatakbn4(C_KataKbn pDisptokuyakukatakbn4) {
        disptokuyakukatakbn4 = pDisptokuyakukatakbn4;
    }

    private C_KyhgndkataKbn disptkkyhgndkatakbn4;

    public C_KyhgndkataKbn getDisptkkyhgndkatakbn4() {
        return disptkkyhgndkatakbn4;
    }

    public void setDisptkkyhgndkatakbn4(C_KyhgndkataKbn pDisptkkyhgndkatakbn4) {
        disptkkyhgndkatakbn4 = pDisptkkyhgndkatakbn4;
    }

    private Integer disptkhhknnen4;

    public Integer getDisptkhhknnen4() {
        return disptkhhknnen4;
    }

    public void setDisptkhhknnen4(Integer pDisptkhhknnen4) {
        disptkhhknnen4 = pDisptkhhknnen4;
    }

    private BizDate disptkkykymd4;

    public BizDate getDisptkkykymd4() {
        return disptkkykymd4;
    }

    public void setDisptkkykymd4(BizDate pDisptkkykymd4) {
        disptkkykymd4 = pDisptkkykymd4;
    }

    private BizDate disptksknnkaisiymd4;

    public BizDate getDisptksknnkaisiymd4() {
        return disptksknnkaisiymd4;
    }

    public void setDisptksknnkaisiymd4(BizDate pDisptksknnkaisiymd4) {
        disptksknnkaisiymd4 = pDisptksknnkaisiymd4;
    }

    private BizDate disptkgansknnkaisiymd4;

    public BizDate getDisptkgansknnkaisiymd4() {
        return disptkgansknnkaisiymd4;
    }

    public void setDisptkgansknnkaisiymd4(BizDate pDisptkgansknnkaisiymd4) {
        disptkgansknnkaisiymd4 = pDisptkgansknnkaisiymd4;
    }

    private BizDate disptkhksknnkaisiymd4;

    public BizDate getDisptkhksknnkaisiymd4() {
        return disptkhksknnkaisiymd4;
    }

    public void setDisptkhksknnkaisiymd4(BizDate pDisptkhksknnkaisiymd4) {
        disptkhksknnkaisiymd4 = pDisptkhksknnkaisiymd4;
    }

    private BizDate disptkhkgansknnkaisiymd4;

    public BizDate getDisptkhkgansknnkaisiymd4() {
        return disptkhkgansknnkaisiymd4;
    }

    public void setDisptkhkgansknnkaisiymd4(BizDate pDisptkhkgansknnkaisiymd4) {
        disptkhkgansknnkaisiymd4 = pDisptkhkgansknnkaisiymd4;
    }

    private Integer disptkhknkkn4;

    public Integer getDisptkhknkkn4() {
        return disptkhknkkn4;
    }

    public void setDisptkhknkkn4(Integer pDisptkhknkkn4) {
        disptkhknkkn4 = pDisptkhknkkn4;
    }

    private C_HknkknsmnKbn disptkhknkknsmnkbn4;

    public C_HknkknsmnKbn getDisptkhknkknsmnkbn4() {
        return disptkhknkknsmnkbn4;
    }

    public void setDisptkhknkknsmnkbn4(C_HknkknsmnKbn pDisptkhknkknsmnkbn4) {
        disptkhknkknsmnkbn4 = pDisptkhknkknsmnkbn4;
    }

    private Integer disptkhrkkkn4;

    public Integer getDisptkhrkkkn4() {
        return disptkhrkkkn4;
    }

    public void setDisptkhrkkkn4(Integer pDisptkhrkkkn4) {
        disptkhrkkkn4 = pDisptkhrkkkn4;
    }

    private C_HrkkknsmnKbn disptkhrkkknsmnkbn4;

    public C_HrkkknsmnKbn getDisptkhrkkknsmnkbn4() {
        return disptkhrkkknsmnkbn4;
    }

    public void setDisptkhrkkknsmnkbn4(C_HrkkknsmnKbn pDisptkhrkkknsmnkbn4) {
        disptkhrkkknsmnkbn4 = pDisptkhrkkknsmnkbn4;
    }

    private C_KihonssyuruiKbn disptkkihonssyuruikbn4;

    public C_KihonssyuruiKbn getDisptkkihonssyuruikbn4() {
        return disptkkihonssyuruikbn4;
    }

    public void setDisptkkihonssyuruikbn4(C_KihonssyuruiKbn pDisptkkihonssyuruikbn4) {
        disptkkihonssyuruikbn4 = pDisptkkihonssyuruikbn4;
    }

    private BizCurrency disptkkihons4;

    public BizCurrency getDisptkkihons4() {
        return disptkkihons4;
    }

    public void setDisptkkihons4(BizCurrency pDisptkkihons4) {
        disptkkihons4 = pDisptkkihons4;
    }

    private BizCurrency disptktsnshrgndgk4;

    public BizCurrency getDisptktsnshrgndgk4() {
        return disptktsnshrgndgk4;
    }

    public void setDisptktsnshrgndgk4(BizCurrency pDisptktsnshrgndgk4) {
        disptktsnshrgndgk4 = pDisptktsnshrgndgk4;
    }

    private BizCurrency disptkp4;

    public BizCurrency getDisptkp4() {
        return disptkp4;
    }

    public void setDisptkp4(BizCurrency pDisptkp4) {
        disptkp4 = pDisptkp4;
    }

    private BizCurrency disptknextkosgop4;

    public BizCurrency getDisptknextkosgop4() {
        return disptknextkosgop4;
    }

    public void setDisptknextkosgop4(BizCurrency pDisptknextkosgop4) {
        disptknextkosgop4 = pDisptknextkosgop4;
    }

    private BizCurrency disptkgannyukyhntgk4;

    public BizCurrency getDisptkgannyukyhntgk4() {
        return disptkgannyukyhntgk4;
    }

    public void setDisptkgannyukyhntgk4(BizCurrency pDisptkgannyukyhntgk4) {
        disptkgannyukyhntgk4 = pDisptkgannyukyhntgk4;
    }

    private BizDate disptkshrskgnstartymd4;

    public BizDate getDisptkshrskgnstartymd4() {
        return disptkshrskgnstartymd4;
    }

    public void setDisptkshrskgnstartymd4(BizDate pDisptkshrskgnstartymd4) {
        disptkshrskgnstartymd4 = pDisptkshrskgnstartymd4;
    }

    private BizDate disptkshrskgnendymd4;

    public BizDate getDisptkshrskgnendymd4() {
        return disptkshrskgnendymd4;
    }

    public void setDisptkshrskgnendymd4(BizDate pDisptkshrskgnendymd4) {
        disptkshrskgnendymd4 = pDisptkshrskgnendymd4;
    }

    private BizCurrency disptkshrskgngos4;

    public BizCurrency getDisptkshrskgngos4() {
        return disptkshrskgngos4;
    }

    public void setDisptkshrskgngos4(BizCurrency pDisptkshrskgngos4) {
        disptkshrskgngos4 = pDisptkshrskgngos4;
    }

    private Integer disptkkrnbkkn4;

    public Integer getDisptkkrnbkkn4() {
        return disptkkrnbkkn4;
    }

    public void setDisptkkrnbkkn4(Integer pDisptkkrnbkkn4) {
        disptkkrnbkkn4 = pDisptkkrnbkkn4;
    }

    private BizDate disptknkshrstartymd4;

    public BizDate getDisptknkshrstartymd4() {
        return disptknkshrstartymd4;
    }

    public void setDisptknkshrstartymd4(BizDate pDisptknkshrstartymd4) {
        disptknkshrstartymd4 = pDisptknkshrstartymd4;
    }

    private C_Kknenkinsyu disptknenkinsyu4;

    public C_Kknenkinsyu getDisptknenkinsyu4() {
        return disptknenkinsyu4;
    }

    public void setDisptknenkinsyu4(C_Kknenkinsyu pDisptknenkinsyu4) {
        disptknenkinsyu4 = pDisptknenkinsyu4;
    }

    private Integer disptknenkinkkn4;

    public Integer getDisptknenkinkkn4() {
        return disptknenkinkkn4;
    }

    public void setDisptknenkinkkn4(Integer pDisptknenkinkkn4) {
        disptknenkinkkn4 = pDisptknenkinkkn4;
    }

    private BizCurrency disptknknengk4;

    public BizCurrency getDisptknknengk4() {
        return disptknknengk4;
    }

    public void setDisptknknengk4(BizCurrency pDisptknknengk4) {
        disptknknengk4 = pDisptknknengk4;
    }

    private C_Bnshrkaisuu disptkbnshrkaisuu4;

    public C_Bnshrkaisuu getDisptkbnshrkaisuu4() {
        return disptkbnshrkaisuu4;
    }

    public void setDisptkbnshrkaisuu4(C_Bnshrkaisuu pDisptkbnshrkaisuu4) {
        disptkbnshrkaisuu4 = pDisptkbnshrkaisuu4;
    }

    private C_Tkjyskgnkkn disptktkjyskgnkkn4;

    public C_Tkjyskgnkkn getDisptktkjyskgnkkn4() {
        return disptktkjyskgnkkn4;
    }

    public void setDisptktkjyskgnkkn4(C_Tkjyskgnkkn pDisptktkjyskgnkkn4) {
        disptktkjyskgnkkn4 = pDisptktkjyskgnkkn4;
    }

    private BizDate disptktkjyskgnhknnndsymd14;

    public BizDate getDisptktkjyskgnhknnndsymd14() {
        return disptktkjyskgnhknnndsymd14;
    }

    public void setDisptktkjyskgnhknnndsymd14(BizDate pDisptktkjyskgnhknnndsymd14) {
        disptktkjyskgnhknnndsymd14 = pDisptktkjyskgnhknnndsymd14;
    }

    private BizDate disptktkjyskgnhknnndeymd14;

    public BizDate getDisptktkjyskgnhknnndeymd14() {
        return disptktkjyskgnhknnndeymd14;
    }

    public void setDisptktkjyskgnhknnndeymd14(BizDate pDisptktkjyskgnhknnndeymd14) {
        disptktkjyskgnhknnndeymd14 = pDisptktkjyskgnhknnndeymd14;
    }

    private BizCurrency disptktkjyskgns14;

    public BizCurrency getDisptktkjyskgns14() {
        return disptktkjyskgns14;
    }

    public void setDisptktkjyskgns14(BizCurrency pDisptktkjyskgns14) {
        disptktkjyskgns14 = pDisptktkjyskgns14;
    }

    private BizDate disptktkjyskgnhknnndsymd24;

    public BizDate getDisptktkjyskgnhknnndsymd24() {
        return disptktkjyskgnhknnndsymd24;
    }

    public void setDisptktkjyskgnhknnndsymd24(BizDate pDisptktkjyskgnhknnndsymd24) {
        disptktkjyskgnhknnndsymd24 = pDisptktkjyskgnhknnndsymd24;
    }

    private BizDate disptktkjyskgnhknnndeymd24;

    public BizDate getDisptktkjyskgnhknnndeymd24() {
        return disptktkjyskgnhknnndeymd24;
    }

    public void setDisptktkjyskgnhknnndeymd24(BizDate pDisptktkjyskgnhknnndeymd24) {
        disptktkjyskgnhknnndeymd24 = pDisptktkjyskgnhknnndeymd24;
    }

    private BizCurrency disptktkjyskgns24;

    public BizCurrency getDisptktkjyskgns24() {
        return disptktkjyskgns24;
    }

    public void setDisptktkjyskgns24(BizCurrency pDisptktkjyskgns24) {
        disptktkjyskgns24 = pDisptktkjyskgns24;
    }

    private BizDate disptktkjyskgnhknnndsymd34;

    public BizDate getDisptktkjyskgnhknnndsymd34() {
        return disptktkjyskgnhknnndsymd34;
    }

    public void setDisptktkjyskgnhknnndsymd34(BizDate pDisptktkjyskgnhknnndsymd34) {
        disptktkjyskgnhknnndsymd34 = pDisptktkjyskgnhknnndsymd34;
    }

    private BizDate disptktkjyskgnhknnndeymd34;

    public BizDate getDisptktkjyskgnhknnndeymd34() {
        return disptktkjyskgnhknnndeymd34;
    }

    public void setDisptktkjyskgnhknnndeymd34(BizDate pDisptktkjyskgnhknnndeymd34) {
        disptktkjyskgnhknnndeymd34 = pDisptktkjyskgnhknnndeymd34;
    }

    private BizCurrency disptktkjyskgns34;

    public BizCurrency getDisptktkjyskgns34() {
        return disptktkjyskgns34;
    }

    public void setDisptktkjyskgns34(BizCurrency pDisptktkjyskgns34) {
        disptktkjyskgns34 = pDisptktkjyskgns34;
    }

    private BizDate disptktkjyskgnhknnndsymd44;

    public BizDate getDisptktkjyskgnhknnndsymd44() {
        return disptktkjyskgnhknnndsymd44;
    }

    public void setDisptktkjyskgnhknnndsymd44(BizDate pDisptktkjyskgnhknnndsymd44) {
        disptktkjyskgnhknnndsymd44 = pDisptktkjyskgnhknnndsymd44;
    }

    private BizDate disptktkjyskgnhknnndeymd44;

    public BizDate getDisptktkjyskgnhknnndeymd44() {
        return disptktkjyskgnhknnndeymd44;
    }

    public void setDisptktkjyskgnhknnndeymd44(BizDate pDisptktkjyskgnhknnndeymd44) {
        disptktkjyskgnhknnndeymd44 = pDisptktkjyskgnhknnndeymd44;
    }

    private BizCurrency disptktkjyskgns44;

    public BizCurrency getDisptktkjyskgns44() {
        return disptktkjyskgns44;
    }

    public void setDisptktkjyskgns44(BizCurrency pDisptktkjyskgns44) {
        disptktkjyskgns44 = pDisptktkjyskgns44;
    }

    private BizDate disptktkjyskgnhknnndsymd54;

    public BizDate getDisptktkjyskgnhknnndsymd54() {
        return disptktkjyskgnhknnndsymd54;
    }

    public void setDisptktkjyskgnhknnndsymd54(BizDate pDisptktkjyskgnhknnndsymd54) {
        disptktkjyskgnhknnndsymd54 = pDisptktkjyskgnhknnndsymd54;
    }

    private BizDate disptktkjyskgnhknnndeymd54;

    public BizDate getDisptktkjyskgnhknnndeymd54() {
        return disptktkjyskgnhknnndeymd54;
    }

    public void setDisptktkjyskgnhknnndeymd54(BizDate pDisptktkjyskgnhknnndeymd54) {
        disptktkjyskgnhknnndeymd54 = pDisptktkjyskgnhknnndeymd54;
    }

    private BizCurrency disptktkjyskgns54;

    public BizCurrency getDisptktkjyskgns54() {
        return disptktkjyskgns54;
    }

    public void setDisptktkjyskgns54(BizCurrency pDisptktkjyskgns54) {
        disptktkjyskgns54 = pDisptktkjyskgns54;
    }

    private C_Tkjyhyouten disptktkjyhyouten4;

    public C_Tkjyhyouten getDisptktkjyhyouten4() {
        return disptktkjyhyouten4;
    }

    public void setDisptktkjyhyouten4(C_Tkjyhyouten pDisptktkjyhyouten4) {
        disptktkjyhyouten4 = pDisptktkjyhyouten4;
    }

    private BizCurrency disptktkjyp4;

    public BizCurrency getDisptktkjyp4() {
        return disptktkjyp4;
    }

    public void setDisptktkjyp4(BizCurrency pDisptktkjyp4) {
        disptktkjyp4 = pDisptktkjyp4;
    }

    private String disptkhtnpbuicd14;

    public String getDisptkhtnpbuicd14() {
        return disptkhtnpbuicd14;
    }

    public void setDisptkhtnpbuicd14(String pDisptkhtnpbuicd14) {
        disptkhtnpbuicd14 = pDisptkhtnpbuicd14;
    }

    private String disptkhtnpbuinm14;

    public String getDisptkhtnpbuinm14() {
        return disptkhtnpbuinm14;
    }

    public void setDisptkhtnpbuinm14(String pDisptkhtnpbuinm14) {
        disptkhtnpbuinm14 = pDisptkhtnpbuinm14;
    }

    private C_Htnpkkn disptkhtnpkkn14;

    public C_Htnpkkn getDisptkhtnpkkn14() {
        return disptkhtnpkkn14;
    }

    public void setDisptkhtnpkkn14(C_Htnpkkn pDisptkhtnpkkn14) {
        disptkhtnpkkn14 = pDisptkhtnpkkn14;
    }

    private String disptkhtnpbuicd24;

    public String getDisptkhtnpbuicd24() {
        return disptkhtnpbuicd24;
    }

    public void setDisptkhtnpbuicd24(String pDisptkhtnpbuicd24) {
        disptkhtnpbuicd24 = pDisptkhtnpbuicd24;
    }

    private String disptkhtnpbuinm24;

    public String getDisptkhtnpbuinm24() {
        return disptkhtnpbuinm24;
    }

    public void setDisptkhtnpbuinm24(String pDisptkhtnpbuinm24) {
        disptkhtnpbuinm24 = pDisptkhtnpbuinm24;
    }

    private C_Htnpkkn disptkhtnpkkn24;

    public C_Htnpkkn getDisptkhtnpkkn24() {
        return disptkhtnpkkn24;
    }

    public void setDisptkhtnpkkn24(C_Htnpkkn pDisptkhtnpkkn24) {
        disptkhtnpkkn24 = pDisptkhtnpkkn24;
    }

    private String disptkhtnpbuicd34;

    public String getDisptkhtnpbuicd34() {
        return disptkhtnpbuicd34;
    }

    public void setDisptkhtnpbuicd34(String pDisptkhtnpbuicd34) {
        disptkhtnpbuicd34 = pDisptkhtnpbuicd34;
    }

    private String disptkhtnpbuinm34;

    public String getDisptkhtnpbuinm34() {
        return disptkhtnpbuinm34;
    }

    public void setDisptkhtnpbuinm34(String pDisptkhtnpbuinm34) {
        disptkhtnpbuinm34 = pDisptkhtnpbuinm34;
    }

    private C_Htnpkkn disptkhtnpkkn34;

    public C_Htnpkkn getDisptkhtnpkkn34() {
        return disptkhtnpkkn34;
    }

    public void setDisptkhtnpkkn34(C_Htnpkkn pDisptkhtnpkkn34) {
        disptkhtnpkkn34 = pDisptkhtnpkkn34;
    }

    private String disptkhtnpbuicd44;

    public String getDisptkhtnpbuicd44() {
        return disptkhtnpbuicd44;
    }

    public void setDisptkhtnpbuicd44(String pDisptkhtnpbuicd44) {
        disptkhtnpbuicd44 = pDisptkhtnpbuicd44;
    }

    private String disptkhtnpbuinm44;

    public String getDisptkhtnpbuinm44() {
        return disptkhtnpbuinm44;
    }

    public void setDisptkhtnpbuinm44(String pDisptkhtnpbuinm44) {
        disptkhtnpbuinm44 = pDisptkhtnpbuinm44;
    }

    private C_Htnpkkn disptkhtnpkkn44;

    public C_Htnpkkn getDisptkhtnpkkn44() {
        return disptkhtnpkkn44;
    }

    public void setDisptkhtnpkkn44(C_Htnpkkn pDisptkhtnpkkn44) {
        disptkhtnpkkn44 = pDisptkhtnpkkn44;
    }

    private C_TokkoudosghtnpKbn disptktokkoudosghtnpkbn4;

    public C_TokkoudosghtnpKbn getDisptktokkoudosghtnpkbn4() {
        return disptktokkoudosghtnpkbn4;
    }

    public void setDisptktokkoudosghtnpkbn4(C_TokkoudosghtnpKbn pDisptktokkoudosghtnpkbn4) {
        disptktokkoudosghtnpkbn4 = pDisptktokkoudosghtnpkbn4;
    }

    private BizDate disptkkouryokuhasseiymd4;

    public BizDate getDisptkkouryokuhasseiymd4() {
        return disptkkouryokuhasseiymd4;
    }

    public void setDisptkkouryokuhasseiymd4(BizDate pDisptkkouryokuhasseiymd4) {
        disptkkouryokuhasseiymd4 = pDisptkkouryokuhasseiymd4;
    }

    private String disptksyouhnnm5;

    public String getDisptksyouhnnm5() {
        return disptksyouhnnm5;
    }

    public void setDisptksyouhnnm5(String pDisptksyouhnnm5) {
        disptksyouhnnm5 = pDisptksyouhnnm5;
    }

    private C_KataKbn disptokuyakukatakbn5;

    public C_KataKbn getDisptokuyakukatakbn5() {
        return disptokuyakukatakbn5;
    }

    public void setDisptokuyakukatakbn5(C_KataKbn pDisptokuyakukatakbn5) {
        disptokuyakukatakbn5 = pDisptokuyakukatakbn5;
    }

    private C_KyhgndkataKbn disptkkyhgndkatakbn5;

    public C_KyhgndkataKbn getDisptkkyhgndkatakbn5() {
        return disptkkyhgndkatakbn5;
    }

    public void setDisptkkyhgndkatakbn5(C_KyhgndkataKbn pDisptkkyhgndkatakbn5) {
        disptkkyhgndkatakbn5 = pDisptkkyhgndkatakbn5;
    }

    private Integer disptkhhknnen5;

    public Integer getDisptkhhknnen5() {
        return disptkhhknnen5;
    }

    public void setDisptkhhknnen5(Integer pDisptkhhknnen5) {
        disptkhhknnen5 = pDisptkhhknnen5;
    }

    private BizDate disptkkykymd5;

    public BizDate getDisptkkykymd5() {
        return disptkkykymd5;
    }

    public void setDisptkkykymd5(BizDate pDisptkkykymd5) {
        disptkkykymd5 = pDisptkkykymd5;
    }

    private BizDate disptksknnkaisiymd5;

    public BizDate getDisptksknnkaisiymd5() {
        return disptksknnkaisiymd5;
    }

    public void setDisptksknnkaisiymd5(BizDate pDisptksknnkaisiymd5) {
        disptksknnkaisiymd5 = pDisptksknnkaisiymd5;
    }

    private BizDate disptkgansknnkaisiymd5;

    public BizDate getDisptkgansknnkaisiymd5() {
        return disptkgansknnkaisiymd5;
    }

    public void setDisptkgansknnkaisiymd5(BizDate pDisptkgansknnkaisiymd5) {
        disptkgansknnkaisiymd5 = pDisptkgansknnkaisiymd5;
    }

    private BizDate disptkhksknnkaisiymd5;

    public BizDate getDisptkhksknnkaisiymd5() {
        return disptkhksknnkaisiymd5;
    }

    public void setDisptkhksknnkaisiymd5(BizDate pDisptkhksknnkaisiymd5) {
        disptkhksknnkaisiymd5 = pDisptkhksknnkaisiymd5;
    }

    private BizDate disptkhkgansknnkaisiymd5;

    public BizDate getDisptkhkgansknnkaisiymd5() {
        return disptkhkgansknnkaisiymd5;
    }

    public void setDisptkhkgansknnkaisiymd5(BizDate pDisptkhkgansknnkaisiymd5) {
        disptkhkgansknnkaisiymd5 = pDisptkhkgansknnkaisiymd5;
    }

    private Integer disptkhknkkn5;

    public Integer getDisptkhknkkn5() {
        return disptkhknkkn5;
    }

    public void setDisptkhknkkn5(Integer pDisptkhknkkn5) {
        disptkhknkkn5 = pDisptkhknkkn5;
    }

    private C_HknkknsmnKbn disptkhknkknsmnkbn5;

    public C_HknkknsmnKbn getDisptkhknkknsmnkbn5() {
        return disptkhknkknsmnkbn5;
    }

    public void setDisptkhknkknsmnkbn5(C_HknkknsmnKbn pDisptkhknkknsmnkbn5) {
        disptkhknkknsmnkbn5 = pDisptkhknkknsmnkbn5;
    }

    private Integer disptkhrkkkn5;

    public Integer getDisptkhrkkkn5() {
        return disptkhrkkkn5;
    }

    public void setDisptkhrkkkn5(Integer pDisptkhrkkkn5) {
        disptkhrkkkn5 = pDisptkhrkkkn5;
    }

    private C_HrkkknsmnKbn disptkhrkkknsmnkbn5;

    public C_HrkkknsmnKbn getDisptkhrkkknsmnkbn5() {
        return disptkhrkkknsmnkbn5;
    }

    public void setDisptkhrkkknsmnkbn5(C_HrkkknsmnKbn pDisptkhrkkknsmnkbn5) {
        disptkhrkkknsmnkbn5 = pDisptkhrkkknsmnkbn5;
    }

    private C_KihonssyuruiKbn disptkkihonssyuruikbn5;

    public C_KihonssyuruiKbn getDisptkkihonssyuruikbn5() {
        return disptkkihonssyuruikbn5;
    }

    public void setDisptkkihonssyuruikbn5(C_KihonssyuruiKbn pDisptkkihonssyuruikbn5) {
        disptkkihonssyuruikbn5 = pDisptkkihonssyuruikbn5;
    }

    private BizCurrency disptkkihons5;

    public BizCurrency getDisptkkihons5() {
        return disptkkihons5;
    }

    public void setDisptkkihons5(BizCurrency pDisptkkihons5) {
        disptkkihons5 = pDisptkkihons5;
    }

    private BizCurrency disptktsnshrgndgk5;

    public BizCurrency getDisptktsnshrgndgk5() {
        return disptktsnshrgndgk5;
    }

    public void setDisptktsnshrgndgk5(BizCurrency pDisptktsnshrgndgk5) {
        disptktsnshrgndgk5 = pDisptktsnshrgndgk5;
    }

    private BizCurrency disptkp5;

    public BizCurrency getDisptkp5() {
        return disptkp5;
    }

    public void setDisptkp5(BizCurrency pDisptkp5) {
        disptkp5 = pDisptkp5;
    }

    private BizCurrency disptknextkosgop5;

    public BizCurrency getDisptknextkosgop5() {
        return disptknextkosgop5;
    }

    public void setDisptknextkosgop5(BizCurrency pDisptknextkosgop5) {
        disptknextkosgop5 = pDisptknextkosgop5;
    }

    private BizCurrency disptkgannyukyhntgk5;

    public BizCurrency getDisptkgannyukyhntgk5() {
        return disptkgannyukyhntgk5;
    }

    public void setDisptkgannyukyhntgk5(BizCurrency pDisptkgannyukyhntgk5) {
        disptkgannyukyhntgk5 = pDisptkgannyukyhntgk5;
    }

    private BizDate disptkshrskgnstartymd5;

    public BizDate getDisptkshrskgnstartymd5() {
        return disptkshrskgnstartymd5;
    }

    public void setDisptkshrskgnstartymd5(BizDate pDisptkshrskgnstartymd5) {
        disptkshrskgnstartymd5 = pDisptkshrskgnstartymd5;
    }

    private BizDate disptkshrskgnendymd5;

    public BizDate getDisptkshrskgnendymd5() {
        return disptkshrskgnendymd5;
    }

    public void setDisptkshrskgnendymd5(BizDate pDisptkshrskgnendymd5) {
        disptkshrskgnendymd5 = pDisptkshrskgnendymd5;
    }

    private BizCurrency disptkshrskgngos5;

    public BizCurrency getDisptkshrskgngos5() {
        return disptkshrskgngos5;
    }

    public void setDisptkshrskgngos5(BizCurrency pDisptkshrskgngos5) {
        disptkshrskgngos5 = pDisptkshrskgngos5;
    }

    private Integer disptkkrnbkkn5;

    public Integer getDisptkkrnbkkn5() {
        return disptkkrnbkkn5;
    }

    public void setDisptkkrnbkkn5(Integer pDisptkkrnbkkn5) {
        disptkkrnbkkn5 = pDisptkkrnbkkn5;
    }

    private BizDate disptknkshrstartymd5;

    public BizDate getDisptknkshrstartymd5() {
        return disptknkshrstartymd5;
    }

    public void setDisptknkshrstartymd5(BizDate pDisptknkshrstartymd5) {
        disptknkshrstartymd5 = pDisptknkshrstartymd5;
    }

    private C_Kknenkinsyu disptknenkinsyu5;

    public C_Kknenkinsyu getDisptknenkinsyu5() {
        return disptknenkinsyu5;
    }

    public void setDisptknenkinsyu5(C_Kknenkinsyu pDisptknenkinsyu5) {
        disptknenkinsyu5 = pDisptknenkinsyu5;
    }

    private Integer disptknenkinkkn5;

    public Integer getDisptknenkinkkn5() {
        return disptknenkinkkn5;
    }

    public void setDisptknenkinkkn5(Integer pDisptknenkinkkn5) {
        disptknenkinkkn5 = pDisptknenkinkkn5;
    }

    private BizCurrency disptknknengk5;

    public BizCurrency getDisptknknengk5() {
        return disptknknengk5;
    }

    public void setDisptknknengk5(BizCurrency pDisptknknengk5) {
        disptknknengk5 = pDisptknknengk5;
    }

    private C_Bnshrkaisuu disptkbnshrkaisuu5;

    public C_Bnshrkaisuu getDisptkbnshrkaisuu5() {
        return disptkbnshrkaisuu5;
    }

    public void setDisptkbnshrkaisuu5(C_Bnshrkaisuu pDisptkbnshrkaisuu5) {
        disptkbnshrkaisuu5 = pDisptkbnshrkaisuu5;
    }

    private C_Tkjyskgnkkn disptktkjyskgnkkn5;

    public C_Tkjyskgnkkn getDisptktkjyskgnkkn5() {
        return disptktkjyskgnkkn5;
    }

    public void setDisptktkjyskgnkkn5(C_Tkjyskgnkkn pDisptktkjyskgnkkn5) {
        disptktkjyskgnkkn5 = pDisptktkjyskgnkkn5;
    }

    private BizDate disptktkjyskgnhknnndsymd15;

    public BizDate getDisptktkjyskgnhknnndsymd15() {
        return disptktkjyskgnhknnndsymd15;
    }

    public void setDisptktkjyskgnhknnndsymd15(BizDate pDisptktkjyskgnhknnndsymd15) {
        disptktkjyskgnhknnndsymd15 = pDisptktkjyskgnhknnndsymd15;
    }

    private BizDate disptktkjyskgnhknnndeymd15;

    public BizDate getDisptktkjyskgnhknnndeymd15() {
        return disptktkjyskgnhknnndeymd15;
    }

    public void setDisptktkjyskgnhknnndeymd15(BizDate pDisptktkjyskgnhknnndeymd15) {
        disptktkjyskgnhknnndeymd15 = pDisptktkjyskgnhknnndeymd15;
    }

    private BizCurrency disptktkjyskgns15;

    public BizCurrency getDisptktkjyskgns15() {
        return disptktkjyskgns15;
    }

    public void setDisptktkjyskgns15(BizCurrency pDisptktkjyskgns15) {
        disptktkjyskgns15 = pDisptktkjyskgns15;
    }

    private BizDate disptktkjyskgnhknnndsymd25;

    public BizDate getDisptktkjyskgnhknnndsymd25() {
        return disptktkjyskgnhknnndsymd25;
    }

    public void setDisptktkjyskgnhknnndsymd25(BizDate pDisptktkjyskgnhknnndsymd25) {
        disptktkjyskgnhknnndsymd25 = pDisptktkjyskgnhknnndsymd25;
    }

    private BizDate disptktkjyskgnhknnndeymd25;

    public BizDate getDisptktkjyskgnhknnndeymd25() {
        return disptktkjyskgnhknnndeymd25;
    }

    public void setDisptktkjyskgnhknnndeymd25(BizDate pDisptktkjyskgnhknnndeymd25) {
        disptktkjyskgnhknnndeymd25 = pDisptktkjyskgnhknnndeymd25;
    }

    private BizCurrency disptktkjyskgns25;

    public BizCurrency getDisptktkjyskgns25() {
        return disptktkjyskgns25;
    }

    public void setDisptktkjyskgns25(BizCurrency pDisptktkjyskgns25) {
        disptktkjyskgns25 = pDisptktkjyskgns25;
    }

    private BizDate disptktkjyskgnhknnndsymd35;

    public BizDate getDisptktkjyskgnhknnndsymd35() {
        return disptktkjyskgnhknnndsymd35;
    }

    public void setDisptktkjyskgnhknnndsymd35(BizDate pDisptktkjyskgnhknnndsymd35) {
        disptktkjyskgnhknnndsymd35 = pDisptktkjyskgnhknnndsymd35;
    }

    private BizDate disptktkjyskgnhknnndeymd35;

    public BizDate getDisptktkjyskgnhknnndeymd35() {
        return disptktkjyskgnhknnndeymd35;
    }

    public void setDisptktkjyskgnhknnndeymd35(BizDate pDisptktkjyskgnhknnndeymd35) {
        disptktkjyskgnhknnndeymd35 = pDisptktkjyskgnhknnndeymd35;
    }

    private BizCurrency disptktkjyskgns35;

    public BizCurrency getDisptktkjyskgns35() {
        return disptktkjyskgns35;
    }

    public void setDisptktkjyskgns35(BizCurrency pDisptktkjyskgns35) {
        disptktkjyskgns35 = pDisptktkjyskgns35;
    }

    private BizDate disptktkjyskgnhknnndsymd45;

    public BizDate getDisptktkjyskgnhknnndsymd45() {
        return disptktkjyskgnhknnndsymd45;
    }

    public void setDisptktkjyskgnhknnndsymd45(BizDate pDisptktkjyskgnhknnndsymd45) {
        disptktkjyskgnhknnndsymd45 = pDisptktkjyskgnhknnndsymd45;
    }

    private BizDate disptktkjyskgnhknnndeymd45;

    public BizDate getDisptktkjyskgnhknnndeymd45() {
        return disptktkjyskgnhknnndeymd45;
    }

    public void setDisptktkjyskgnhknnndeymd45(BizDate pDisptktkjyskgnhknnndeymd45) {
        disptktkjyskgnhknnndeymd45 = pDisptktkjyskgnhknnndeymd45;
    }

    private BizCurrency disptktkjyskgns45;

    public BizCurrency getDisptktkjyskgns45() {
        return disptktkjyskgns45;
    }

    public void setDisptktkjyskgns45(BizCurrency pDisptktkjyskgns45) {
        disptktkjyskgns45 = pDisptktkjyskgns45;
    }

    private BizDate disptktkjyskgnhknnndsymd55;

    public BizDate getDisptktkjyskgnhknnndsymd55() {
        return disptktkjyskgnhknnndsymd55;
    }

    public void setDisptktkjyskgnhknnndsymd55(BizDate pDisptktkjyskgnhknnndsymd55) {
        disptktkjyskgnhknnndsymd55 = pDisptktkjyskgnhknnndsymd55;
    }

    private BizDate disptktkjyskgnhknnndeymd55;

    public BizDate getDisptktkjyskgnhknnndeymd55() {
        return disptktkjyskgnhknnndeymd55;
    }

    public void setDisptktkjyskgnhknnndeymd55(BizDate pDisptktkjyskgnhknnndeymd55) {
        disptktkjyskgnhknnndeymd55 = pDisptktkjyskgnhknnndeymd55;
    }

    private BizCurrency disptktkjyskgns55;

    public BizCurrency getDisptktkjyskgns55() {
        return disptktkjyskgns55;
    }

    public void setDisptktkjyskgns55(BizCurrency pDisptktkjyskgns55) {
        disptktkjyskgns55 = pDisptktkjyskgns55;
    }

    private C_Tkjyhyouten disptktkjyhyouten5;

    public C_Tkjyhyouten getDisptktkjyhyouten5() {
        return disptktkjyhyouten5;
    }

    public void setDisptktkjyhyouten5(C_Tkjyhyouten pDisptktkjyhyouten5) {
        disptktkjyhyouten5 = pDisptktkjyhyouten5;
    }

    private BizCurrency disptktkjyp5;

    public BizCurrency getDisptktkjyp5() {
        return disptktkjyp5;
    }

    public void setDisptktkjyp5(BizCurrency pDisptktkjyp5) {
        disptktkjyp5 = pDisptktkjyp5;
    }

    private String disptkhtnpbuicd15;

    public String getDisptkhtnpbuicd15() {
        return disptkhtnpbuicd15;
    }

    public void setDisptkhtnpbuicd15(String pDisptkhtnpbuicd15) {
        disptkhtnpbuicd15 = pDisptkhtnpbuicd15;
    }

    private String disptkhtnpbuinm15;

    public String getDisptkhtnpbuinm15() {
        return disptkhtnpbuinm15;
    }

    public void setDisptkhtnpbuinm15(String pDisptkhtnpbuinm15) {
        disptkhtnpbuinm15 = pDisptkhtnpbuinm15;
    }

    private C_Htnpkkn disptkhtnpkkn15;

    public C_Htnpkkn getDisptkhtnpkkn15() {
        return disptkhtnpkkn15;
    }

    public void setDisptkhtnpkkn15(C_Htnpkkn pDisptkhtnpkkn15) {
        disptkhtnpkkn15 = pDisptkhtnpkkn15;
    }

    private String disptkhtnpbuicd25;

    public String getDisptkhtnpbuicd25() {
        return disptkhtnpbuicd25;
    }

    public void setDisptkhtnpbuicd25(String pDisptkhtnpbuicd25) {
        disptkhtnpbuicd25 = pDisptkhtnpbuicd25;
    }

    private String disptkhtnpbuinm25;

    public String getDisptkhtnpbuinm25() {
        return disptkhtnpbuinm25;
    }

    public void setDisptkhtnpbuinm25(String pDisptkhtnpbuinm25) {
        disptkhtnpbuinm25 = pDisptkhtnpbuinm25;
    }

    private C_Htnpkkn disptkhtnpkkn25;

    public C_Htnpkkn getDisptkhtnpkkn25() {
        return disptkhtnpkkn25;
    }

    public void setDisptkhtnpkkn25(C_Htnpkkn pDisptkhtnpkkn25) {
        disptkhtnpkkn25 = pDisptkhtnpkkn25;
    }

    private String disptkhtnpbuicd35;

    public String getDisptkhtnpbuicd35() {
        return disptkhtnpbuicd35;
    }

    public void setDisptkhtnpbuicd35(String pDisptkhtnpbuicd35) {
        disptkhtnpbuicd35 = pDisptkhtnpbuicd35;
    }

    private String disptkhtnpbuinm35;

    public String getDisptkhtnpbuinm35() {
        return disptkhtnpbuinm35;
    }

    public void setDisptkhtnpbuinm35(String pDisptkhtnpbuinm35) {
        disptkhtnpbuinm35 = pDisptkhtnpbuinm35;
    }

    private C_Htnpkkn disptkhtnpkkn35;

    public C_Htnpkkn getDisptkhtnpkkn35() {
        return disptkhtnpkkn35;
    }

    public void setDisptkhtnpkkn35(C_Htnpkkn pDisptkhtnpkkn35) {
        disptkhtnpkkn35 = pDisptkhtnpkkn35;
    }

    private String disptkhtnpbuicd45;

    public String getDisptkhtnpbuicd45() {
        return disptkhtnpbuicd45;
    }

    public void setDisptkhtnpbuicd45(String pDisptkhtnpbuicd45) {
        disptkhtnpbuicd45 = pDisptkhtnpbuicd45;
    }

    private String disptkhtnpbuinm45;

    public String getDisptkhtnpbuinm45() {
        return disptkhtnpbuinm45;
    }

    public void setDisptkhtnpbuinm45(String pDisptkhtnpbuinm45) {
        disptkhtnpbuinm45 = pDisptkhtnpbuinm45;
    }

    private C_Htnpkkn disptkhtnpkkn45;

    public C_Htnpkkn getDisptkhtnpkkn45() {
        return disptkhtnpkkn45;
    }

    public void setDisptkhtnpkkn45(C_Htnpkkn pDisptkhtnpkkn45) {
        disptkhtnpkkn45 = pDisptkhtnpkkn45;
    }

    private C_TokkoudosghtnpKbn disptktokkoudosghtnpkbn5;

    public C_TokkoudosghtnpKbn getDisptktokkoudosghtnpkbn5() {
        return disptktokkoudosghtnpkbn5;
    }

    public void setDisptktokkoudosghtnpkbn5(C_TokkoudosghtnpKbn pDisptktokkoudosghtnpkbn5) {
        disptktokkoudosghtnpkbn5 = pDisptktokkoudosghtnpkbn5;
    }

    private BizDate disptkkouryokuhasseiymd5;

    public BizDate getDisptkkouryokuhasseiymd5() {
        return disptkkouryokuhasseiymd5;
    }

    public void setDisptkkouryokuhasseiymd5(BizDate pDisptkkouryokuhasseiymd5) {
        disptkkouryokuhasseiymd5 = pDisptkkouryokuhasseiymd5;
    }

    private String disptksyouhnnm6;

    public String getDisptksyouhnnm6() {
        return disptksyouhnnm6;
    }

    public void setDisptksyouhnnm6(String pDisptksyouhnnm6) {
        disptksyouhnnm6 = pDisptksyouhnnm6;
    }

    private C_KataKbn disptokuyakukatakbn6;

    public C_KataKbn getDisptokuyakukatakbn6() {
        return disptokuyakukatakbn6;
    }

    public void setDisptokuyakukatakbn6(C_KataKbn pDisptokuyakukatakbn6) {
        disptokuyakukatakbn6 = pDisptokuyakukatakbn6;
    }

    private C_KyhgndkataKbn disptkkyhgndkatakbn6;

    public C_KyhgndkataKbn getDisptkkyhgndkatakbn6() {
        return disptkkyhgndkatakbn6;
    }

    public void setDisptkkyhgndkatakbn6(C_KyhgndkataKbn pDisptkkyhgndkatakbn6) {
        disptkkyhgndkatakbn6 = pDisptkkyhgndkatakbn6;
    }

    private Integer disptkhhknnen6;

    public Integer getDisptkhhknnen6() {
        return disptkhhknnen6;
    }

    public void setDisptkhhknnen6(Integer pDisptkhhknnen6) {
        disptkhhknnen6 = pDisptkhhknnen6;
    }

    private BizDate disptkkykymd6;

    public BizDate getDisptkkykymd6() {
        return disptkkykymd6;
    }

    public void setDisptkkykymd6(BizDate pDisptkkykymd6) {
        disptkkykymd6 = pDisptkkykymd6;
    }

    private BizDate disptksknnkaisiymd6;

    public BizDate getDisptksknnkaisiymd6() {
        return disptksknnkaisiymd6;
    }

    public void setDisptksknnkaisiymd6(BizDate pDisptksknnkaisiymd6) {
        disptksknnkaisiymd6 = pDisptksknnkaisiymd6;
    }

    private BizDate disptkgansknnkaisiymd6;

    public BizDate getDisptkgansknnkaisiymd6() {
        return disptkgansknnkaisiymd6;
    }

    public void setDisptkgansknnkaisiymd6(BizDate pDisptkgansknnkaisiymd6) {
        disptkgansknnkaisiymd6 = pDisptkgansknnkaisiymd6;
    }

    private BizDate disptkhksknnkaisiymd6;

    public BizDate getDisptkhksknnkaisiymd6() {
        return disptkhksknnkaisiymd6;
    }

    public void setDisptkhksknnkaisiymd6(BizDate pDisptkhksknnkaisiymd6) {
        disptkhksknnkaisiymd6 = pDisptkhksknnkaisiymd6;
    }

    private BizDate disptkhkgansknnkaisiymd6;

    public BizDate getDisptkhkgansknnkaisiymd6() {
        return disptkhkgansknnkaisiymd6;
    }

    public void setDisptkhkgansknnkaisiymd6(BizDate pDisptkhkgansknnkaisiymd6) {
        disptkhkgansknnkaisiymd6 = pDisptkhkgansknnkaisiymd6;
    }

    private Integer disptkhknkkn6;

    public Integer getDisptkhknkkn6() {
        return disptkhknkkn6;
    }

    public void setDisptkhknkkn6(Integer pDisptkhknkkn6) {
        disptkhknkkn6 = pDisptkhknkkn6;
    }

    private C_HknkknsmnKbn disptkhknkknsmnkbn6;

    public C_HknkknsmnKbn getDisptkhknkknsmnkbn6() {
        return disptkhknkknsmnkbn6;
    }

    public void setDisptkhknkknsmnkbn6(C_HknkknsmnKbn pDisptkhknkknsmnkbn6) {
        disptkhknkknsmnkbn6 = pDisptkhknkknsmnkbn6;
    }

    private Integer disptkhrkkkn6;

    public Integer getDisptkhrkkkn6() {
        return disptkhrkkkn6;
    }

    public void setDisptkhrkkkn6(Integer pDisptkhrkkkn6) {
        disptkhrkkkn6 = pDisptkhrkkkn6;
    }

    private C_HrkkknsmnKbn disptkhrkkknsmnkbn6;

    public C_HrkkknsmnKbn getDisptkhrkkknsmnkbn6() {
        return disptkhrkkknsmnkbn6;
    }

    public void setDisptkhrkkknsmnkbn6(C_HrkkknsmnKbn pDisptkhrkkknsmnkbn6) {
        disptkhrkkknsmnkbn6 = pDisptkhrkkknsmnkbn6;
    }

    private C_KihonssyuruiKbn disptkkihonssyuruikbn6;

    public C_KihonssyuruiKbn getDisptkkihonssyuruikbn6() {
        return disptkkihonssyuruikbn6;
    }

    public void setDisptkkihonssyuruikbn6(C_KihonssyuruiKbn pDisptkkihonssyuruikbn6) {
        disptkkihonssyuruikbn6 = pDisptkkihonssyuruikbn6;
    }

    private BizCurrency disptkkihons6;

    public BizCurrency getDisptkkihons6() {
        return disptkkihons6;
    }

    public void setDisptkkihons6(BizCurrency pDisptkkihons6) {
        disptkkihons6 = pDisptkkihons6;
    }

    private BizCurrency disptktsnshrgndgk6;

    public BizCurrency getDisptktsnshrgndgk6() {
        return disptktsnshrgndgk6;
    }

    public void setDisptktsnshrgndgk6(BizCurrency pDisptktsnshrgndgk6) {
        disptktsnshrgndgk6 = pDisptktsnshrgndgk6;
    }

    private BizCurrency disptkp6;

    public BizCurrency getDisptkp6() {
        return disptkp6;
    }

    public void setDisptkp6(BizCurrency pDisptkp6) {
        disptkp6 = pDisptkp6;
    }

    private BizCurrency disptknextkosgop6;

    public BizCurrency getDisptknextkosgop6() {
        return disptknextkosgop6;
    }

    public void setDisptknextkosgop6(BizCurrency pDisptknextkosgop6) {
        disptknextkosgop6 = pDisptknextkosgop6;
    }

    private BizCurrency disptkgannyukyhntgk6;

    public BizCurrency getDisptkgannyukyhntgk6() {
        return disptkgannyukyhntgk6;
    }

    public void setDisptkgannyukyhntgk6(BizCurrency pDisptkgannyukyhntgk6) {
        disptkgannyukyhntgk6 = pDisptkgannyukyhntgk6;
    }

    private BizDate disptkshrskgnstartymd6;

    public BizDate getDisptkshrskgnstartymd6() {
        return disptkshrskgnstartymd6;
    }

    public void setDisptkshrskgnstartymd6(BizDate pDisptkshrskgnstartymd6) {
        disptkshrskgnstartymd6 = pDisptkshrskgnstartymd6;
    }

    private BizDate disptkshrskgnendymd6;

    public BizDate getDisptkshrskgnendymd6() {
        return disptkshrskgnendymd6;
    }

    public void setDisptkshrskgnendymd6(BizDate pDisptkshrskgnendymd6) {
        disptkshrskgnendymd6 = pDisptkshrskgnendymd6;
    }

    private BizCurrency disptkshrskgngos6;

    public BizCurrency getDisptkshrskgngos6() {
        return disptkshrskgngos6;
    }

    public void setDisptkshrskgngos6(BizCurrency pDisptkshrskgngos6) {
        disptkshrskgngos6 = pDisptkshrskgngos6;
    }

    private Integer disptkkrnbkkn6;

    public Integer getDisptkkrnbkkn6() {
        return disptkkrnbkkn6;
    }

    public void setDisptkkrnbkkn6(Integer pDisptkkrnbkkn6) {
        disptkkrnbkkn6 = pDisptkkrnbkkn6;
    }

    private BizDate disptknkshrstartymd6;

    public BizDate getDisptknkshrstartymd6() {
        return disptknkshrstartymd6;
    }

    public void setDisptknkshrstartymd6(BizDate pDisptknkshrstartymd6) {
        disptknkshrstartymd6 = pDisptknkshrstartymd6;
    }

    private C_Kknenkinsyu disptknenkinsyu6;

    public C_Kknenkinsyu getDisptknenkinsyu6() {
        return disptknenkinsyu6;
    }

    public void setDisptknenkinsyu6(C_Kknenkinsyu pDisptknenkinsyu6) {
        disptknenkinsyu6 = pDisptknenkinsyu6;
    }

    private Integer disptknenkinkkn6;

    public Integer getDisptknenkinkkn6() {
        return disptknenkinkkn6;
    }

    public void setDisptknenkinkkn6(Integer pDisptknenkinkkn6) {
        disptknenkinkkn6 = pDisptknenkinkkn6;
    }

    private BizCurrency disptknknengk6;

    public BizCurrency getDisptknknengk6() {
        return disptknknengk6;
    }

    public void setDisptknknengk6(BizCurrency pDisptknknengk6) {
        disptknknengk6 = pDisptknknengk6;
    }

    private C_Bnshrkaisuu disptkbnshrkaisuu6;

    public C_Bnshrkaisuu getDisptkbnshrkaisuu6() {
        return disptkbnshrkaisuu6;
    }

    public void setDisptkbnshrkaisuu6(C_Bnshrkaisuu pDisptkbnshrkaisuu6) {
        disptkbnshrkaisuu6 = pDisptkbnshrkaisuu6;
    }

    private C_Tkjyskgnkkn disptktkjyskgnkkn6;

    public C_Tkjyskgnkkn getDisptktkjyskgnkkn6() {
        return disptktkjyskgnkkn6;
    }

    public void setDisptktkjyskgnkkn6(C_Tkjyskgnkkn pDisptktkjyskgnkkn6) {
        disptktkjyskgnkkn6 = pDisptktkjyskgnkkn6;
    }

    private BizDate disptktkjyskgnhknnndsymd16;

    public BizDate getDisptktkjyskgnhknnndsymd16() {
        return disptktkjyskgnhknnndsymd16;
    }

    public void setDisptktkjyskgnhknnndsymd16(BizDate pDisptktkjyskgnhknnndsymd16) {
        disptktkjyskgnhknnndsymd16 = pDisptktkjyskgnhknnndsymd16;
    }

    private BizDate disptktkjyskgnhknnndeymd16;

    public BizDate getDisptktkjyskgnhknnndeymd16() {
        return disptktkjyskgnhknnndeymd16;
    }

    public void setDisptktkjyskgnhknnndeymd16(BizDate pDisptktkjyskgnhknnndeymd16) {
        disptktkjyskgnhknnndeymd16 = pDisptktkjyskgnhknnndeymd16;
    }

    private BizCurrency disptktkjyskgns16;

    public BizCurrency getDisptktkjyskgns16() {
        return disptktkjyskgns16;
    }

    public void setDisptktkjyskgns16(BizCurrency pDisptktkjyskgns16) {
        disptktkjyskgns16 = pDisptktkjyskgns16;
    }

    private BizDate disptktkjyskgnhknnndsymd26;

    public BizDate getDisptktkjyskgnhknnndsymd26() {
        return disptktkjyskgnhknnndsymd26;
    }

    public void setDisptktkjyskgnhknnndsymd26(BizDate pDisptktkjyskgnhknnndsymd26) {
        disptktkjyskgnhknnndsymd26 = pDisptktkjyskgnhknnndsymd26;
    }

    private BizDate disptktkjyskgnhknnndeymd26;

    public BizDate getDisptktkjyskgnhknnndeymd26() {
        return disptktkjyskgnhknnndeymd26;
    }

    public void setDisptktkjyskgnhknnndeymd26(BizDate pDisptktkjyskgnhknnndeymd26) {
        disptktkjyskgnhknnndeymd26 = pDisptktkjyskgnhknnndeymd26;
    }

    private BizCurrency disptktkjyskgns26;

    public BizCurrency getDisptktkjyskgns26() {
        return disptktkjyskgns26;
    }

    public void setDisptktkjyskgns26(BizCurrency pDisptktkjyskgns26) {
        disptktkjyskgns26 = pDisptktkjyskgns26;
    }

    private BizDate disptktkjyskgnhknnndsymd36;

    public BizDate getDisptktkjyskgnhknnndsymd36() {
        return disptktkjyskgnhknnndsymd36;
    }

    public void setDisptktkjyskgnhknnndsymd36(BizDate pDisptktkjyskgnhknnndsymd36) {
        disptktkjyskgnhknnndsymd36 = pDisptktkjyskgnhknnndsymd36;
    }

    private BizDate disptktkjyskgnhknnndeymd36;

    public BizDate getDisptktkjyskgnhknnndeymd36() {
        return disptktkjyskgnhknnndeymd36;
    }

    public void setDisptktkjyskgnhknnndeymd36(BizDate pDisptktkjyskgnhknnndeymd36) {
        disptktkjyskgnhknnndeymd36 = pDisptktkjyskgnhknnndeymd36;
    }

    private BizCurrency disptktkjyskgns36;

    public BizCurrency getDisptktkjyskgns36() {
        return disptktkjyskgns36;
    }

    public void setDisptktkjyskgns36(BizCurrency pDisptktkjyskgns36) {
        disptktkjyskgns36 = pDisptktkjyskgns36;
    }

    private BizDate disptktkjyskgnhknnndsymd46;

    public BizDate getDisptktkjyskgnhknnndsymd46() {
        return disptktkjyskgnhknnndsymd46;
    }

    public void setDisptktkjyskgnhknnndsymd46(BizDate pDisptktkjyskgnhknnndsymd46) {
        disptktkjyskgnhknnndsymd46 = pDisptktkjyskgnhknnndsymd46;
    }

    private BizDate disptktkjyskgnhknnndeymd46;

    public BizDate getDisptktkjyskgnhknnndeymd46() {
        return disptktkjyskgnhknnndeymd46;
    }

    public void setDisptktkjyskgnhknnndeymd46(BizDate pDisptktkjyskgnhknnndeymd46) {
        disptktkjyskgnhknnndeymd46 = pDisptktkjyskgnhknnndeymd46;
    }

    private BizCurrency disptktkjyskgns46;

    public BizCurrency getDisptktkjyskgns46() {
        return disptktkjyskgns46;
    }

    public void setDisptktkjyskgns46(BizCurrency pDisptktkjyskgns46) {
        disptktkjyskgns46 = pDisptktkjyskgns46;
    }

    private BizDate disptktkjyskgnhknnndsymd56;

    public BizDate getDisptktkjyskgnhknnndsymd56() {
        return disptktkjyskgnhknnndsymd56;
    }

    public void setDisptktkjyskgnhknnndsymd56(BizDate pDisptktkjyskgnhknnndsymd56) {
        disptktkjyskgnhknnndsymd56 = pDisptktkjyskgnhknnndsymd56;
    }

    private BizDate disptktkjyskgnhknnndeymd56;

    public BizDate getDisptktkjyskgnhknnndeymd56() {
        return disptktkjyskgnhknnndeymd56;
    }

    public void setDisptktkjyskgnhknnndeymd56(BizDate pDisptktkjyskgnhknnndeymd56) {
        disptktkjyskgnhknnndeymd56 = pDisptktkjyskgnhknnndeymd56;
    }

    private BizCurrency disptktkjyskgns56;

    public BizCurrency getDisptktkjyskgns56() {
        return disptktkjyskgns56;
    }

    public void setDisptktkjyskgns56(BizCurrency pDisptktkjyskgns56) {
        disptktkjyskgns56 = pDisptktkjyskgns56;
    }

    private C_Tkjyhyouten disptktkjyhyouten6;

    public C_Tkjyhyouten getDisptktkjyhyouten6() {
        return disptktkjyhyouten6;
    }

    public void setDisptktkjyhyouten6(C_Tkjyhyouten pDisptktkjyhyouten6) {
        disptktkjyhyouten6 = pDisptktkjyhyouten6;
    }

    private BizCurrency disptktkjyp6;

    public BizCurrency getDisptktkjyp6() {
        return disptktkjyp6;
    }

    public void setDisptktkjyp6(BizCurrency pDisptktkjyp6) {
        disptktkjyp6 = pDisptktkjyp6;
    }

    private String disptkhtnpbuicd16;

    public String getDisptkhtnpbuicd16() {
        return disptkhtnpbuicd16;
    }

    public void setDisptkhtnpbuicd16(String pDisptkhtnpbuicd16) {
        disptkhtnpbuicd16 = pDisptkhtnpbuicd16;
    }

    private String disptkhtnpbuinm16;

    public String getDisptkhtnpbuinm16() {
        return disptkhtnpbuinm16;
    }

    public void setDisptkhtnpbuinm16(String pDisptkhtnpbuinm16) {
        disptkhtnpbuinm16 = pDisptkhtnpbuinm16;
    }

    private C_Htnpkkn disptkhtnpkkn16;

    public C_Htnpkkn getDisptkhtnpkkn16() {
        return disptkhtnpkkn16;
    }

    public void setDisptkhtnpkkn16(C_Htnpkkn pDisptkhtnpkkn16) {
        disptkhtnpkkn16 = pDisptkhtnpkkn16;
    }

    private String disptkhtnpbuicd26;

    public String getDisptkhtnpbuicd26() {
        return disptkhtnpbuicd26;
    }

    public void setDisptkhtnpbuicd26(String pDisptkhtnpbuicd26) {
        disptkhtnpbuicd26 = pDisptkhtnpbuicd26;
    }

    private String disptkhtnpbuinm26;

    public String getDisptkhtnpbuinm26() {
        return disptkhtnpbuinm26;
    }

    public void setDisptkhtnpbuinm26(String pDisptkhtnpbuinm26) {
        disptkhtnpbuinm26 = pDisptkhtnpbuinm26;
    }

    private C_Htnpkkn disptkhtnpkkn26;

    public C_Htnpkkn getDisptkhtnpkkn26() {
        return disptkhtnpkkn26;
    }

    public void setDisptkhtnpkkn26(C_Htnpkkn pDisptkhtnpkkn26) {
        disptkhtnpkkn26 = pDisptkhtnpkkn26;
    }

    private String disptkhtnpbuicd36;

    public String getDisptkhtnpbuicd36() {
        return disptkhtnpbuicd36;
    }

    public void setDisptkhtnpbuicd36(String pDisptkhtnpbuicd36) {
        disptkhtnpbuicd36 = pDisptkhtnpbuicd36;
    }

    private String disptkhtnpbuinm36;

    public String getDisptkhtnpbuinm36() {
        return disptkhtnpbuinm36;
    }

    public void setDisptkhtnpbuinm36(String pDisptkhtnpbuinm36) {
        disptkhtnpbuinm36 = pDisptkhtnpbuinm36;
    }

    private C_Htnpkkn disptkhtnpkkn36;

    public C_Htnpkkn getDisptkhtnpkkn36() {
        return disptkhtnpkkn36;
    }

    public void setDisptkhtnpkkn36(C_Htnpkkn pDisptkhtnpkkn36) {
        disptkhtnpkkn36 = pDisptkhtnpkkn36;
    }

    private String disptkhtnpbuicd46;

    public String getDisptkhtnpbuicd46() {
        return disptkhtnpbuicd46;
    }

    public void setDisptkhtnpbuicd46(String pDisptkhtnpbuicd46) {
        disptkhtnpbuicd46 = pDisptkhtnpbuicd46;
    }

    private String disptkhtnpbuinm46;

    public String getDisptkhtnpbuinm46() {
        return disptkhtnpbuinm46;
    }

    public void setDisptkhtnpbuinm46(String pDisptkhtnpbuinm46) {
        disptkhtnpbuinm46 = pDisptkhtnpbuinm46;
    }

    private C_Htnpkkn disptkhtnpkkn46;

    public C_Htnpkkn getDisptkhtnpkkn46() {
        return disptkhtnpkkn46;
    }

    public void setDisptkhtnpkkn46(C_Htnpkkn pDisptkhtnpkkn46) {
        disptkhtnpkkn46 = pDisptkhtnpkkn46;
    }

    private C_TokkoudosghtnpKbn disptktokkoudosghtnpkbn6;

    public C_TokkoudosghtnpKbn getDisptktokkoudosghtnpkbn6() {
        return disptktokkoudosghtnpkbn6;
    }

    public void setDisptktokkoudosghtnpkbn6(C_TokkoudosghtnpKbn pDisptktokkoudosghtnpkbn6) {
        disptktokkoudosghtnpkbn6 = pDisptktokkoudosghtnpkbn6;
    }

    private BizDate disptkkouryokuhasseiymd6;

    public BizDate getDisptkkouryokuhasseiymd6() {
        return disptkkouryokuhasseiymd6;
    }

    public void setDisptkkouryokuhasseiymd6(BizDate pDisptkkouryokuhasseiymd6) {
        disptkkouryokuhasseiymd6 = pDisptkkouryokuhasseiymd6;
    }

    private String disptksyouhnnm7;

    public String getDisptksyouhnnm7() {
        return disptksyouhnnm7;
    }

    public void setDisptksyouhnnm7(String pDisptksyouhnnm7) {
        disptksyouhnnm7 = pDisptksyouhnnm7;
    }

    private C_KataKbn disptokuyakukatakbn7;

    public C_KataKbn getDisptokuyakukatakbn7() {
        return disptokuyakukatakbn7;
    }

    public void setDisptokuyakukatakbn7(C_KataKbn pDisptokuyakukatakbn7) {
        disptokuyakukatakbn7 = pDisptokuyakukatakbn7;
    }

    private C_KyhgndkataKbn disptkkyhgndkatakbn7;

    public C_KyhgndkataKbn getDisptkkyhgndkatakbn7() {
        return disptkkyhgndkatakbn7;
    }

    public void setDisptkkyhgndkatakbn7(C_KyhgndkataKbn pDisptkkyhgndkatakbn7) {
        disptkkyhgndkatakbn7 = pDisptkkyhgndkatakbn7;
    }

    private Integer disptkhhknnen7;

    public Integer getDisptkhhknnen7() {
        return disptkhhknnen7;
    }

    public void setDisptkhhknnen7(Integer pDisptkhhknnen7) {
        disptkhhknnen7 = pDisptkhhknnen7;
    }

    private BizDate disptkkykymd7;

    public BizDate getDisptkkykymd7() {
        return disptkkykymd7;
    }

    public void setDisptkkykymd7(BizDate pDisptkkykymd7) {
        disptkkykymd7 = pDisptkkykymd7;
    }

    private BizDate disptksknnkaisiymd7;

    public BizDate getDisptksknnkaisiymd7() {
        return disptksknnkaisiymd7;
    }

    public void setDisptksknnkaisiymd7(BizDate pDisptksknnkaisiymd7) {
        disptksknnkaisiymd7 = pDisptksknnkaisiymd7;
    }

    private BizDate disptkgansknnkaisiymd7;

    public BizDate getDisptkgansknnkaisiymd7() {
        return disptkgansknnkaisiymd7;
    }

    public void setDisptkgansknnkaisiymd7(BizDate pDisptkgansknnkaisiymd7) {
        disptkgansknnkaisiymd7 = pDisptkgansknnkaisiymd7;
    }

    private BizDate disptkhksknnkaisiymd7;

    public BizDate getDisptkhksknnkaisiymd7() {
        return disptkhksknnkaisiymd7;
    }

    public void setDisptkhksknnkaisiymd7(BizDate pDisptkhksknnkaisiymd7) {
        disptkhksknnkaisiymd7 = pDisptkhksknnkaisiymd7;
    }

    private BizDate disptkhkgansknnkaisiymd7;

    public BizDate getDisptkhkgansknnkaisiymd7() {
        return disptkhkgansknnkaisiymd7;
    }

    public void setDisptkhkgansknnkaisiymd7(BizDate pDisptkhkgansknnkaisiymd7) {
        disptkhkgansknnkaisiymd7 = pDisptkhkgansknnkaisiymd7;
    }

    private Integer disptkhknkkn7;

    public Integer getDisptkhknkkn7() {
        return disptkhknkkn7;
    }

    public void setDisptkhknkkn7(Integer pDisptkhknkkn7) {
        disptkhknkkn7 = pDisptkhknkkn7;
    }

    private C_HknkknsmnKbn disptkhknkknsmnkbn7;

    public C_HknkknsmnKbn getDisptkhknkknsmnkbn7() {
        return disptkhknkknsmnkbn7;
    }

    public void setDisptkhknkknsmnkbn7(C_HknkknsmnKbn pDisptkhknkknsmnkbn7) {
        disptkhknkknsmnkbn7 = pDisptkhknkknsmnkbn7;
    }

    private Integer disptkhrkkkn7;

    public Integer getDisptkhrkkkn7() {
        return disptkhrkkkn7;
    }

    public void setDisptkhrkkkn7(Integer pDisptkhrkkkn7) {
        disptkhrkkkn7 = pDisptkhrkkkn7;
    }

    private C_HrkkknsmnKbn disptkhrkkknsmnkbn7;

    public C_HrkkknsmnKbn getDisptkhrkkknsmnkbn7() {
        return disptkhrkkknsmnkbn7;
    }

    public void setDisptkhrkkknsmnkbn7(C_HrkkknsmnKbn pDisptkhrkkknsmnkbn7) {
        disptkhrkkknsmnkbn7 = pDisptkhrkkknsmnkbn7;
    }

    private C_KihonssyuruiKbn disptkkihonssyuruikbn7;

    public C_KihonssyuruiKbn getDisptkkihonssyuruikbn7() {
        return disptkkihonssyuruikbn7;
    }

    public void setDisptkkihonssyuruikbn7(C_KihonssyuruiKbn pDisptkkihonssyuruikbn7) {
        disptkkihonssyuruikbn7 = pDisptkkihonssyuruikbn7;
    }

    private BizCurrency disptkkihons7;

    public BizCurrency getDisptkkihons7() {
        return disptkkihons7;
    }

    public void setDisptkkihons7(BizCurrency pDisptkkihons7) {
        disptkkihons7 = pDisptkkihons7;
    }

    private BizCurrency disptktsnshrgndgk7;

    public BizCurrency getDisptktsnshrgndgk7() {
        return disptktsnshrgndgk7;
    }

    public void setDisptktsnshrgndgk7(BizCurrency pDisptktsnshrgndgk7) {
        disptktsnshrgndgk7 = pDisptktsnshrgndgk7;
    }

    private BizCurrency disptkp7;

    public BizCurrency getDisptkp7() {
        return disptkp7;
    }

    public void setDisptkp7(BizCurrency pDisptkp7) {
        disptkp7 = pDisptkp7;
    }

    private BizCurrency disptknextkosgop7;

    public BizCurrency getDisptknextkosgop7() {
        return disptknextkosgop7;
    }

    public void setDisptknextkosgop7(BizCurrency pDisptknextkosgop7) {
        disptknextkosgop7 = pDisptknextkosgop7;
    }

    private BizCurrency disptkgannyukyhntgk7;

    public BizCurrency getDisptkgannyukyhntgk7() {
        return disptkgannyukyhntgk7;
    }

    public void setDisptkgannyukyhntgk7(BizCurrency pDisptkgannyukyhntgk7) {
        disptkgannyukyhntgk7 = pDisptkgannyukyhntgk7;
    }

    private BizDate disptkshrskgnstartymd7;

    public BizDate getDisptkshrskgnstartymd7() {
        return disptkshrskgnstartymd7;
    }

    public void setDisptkshrskgnstartymd7(BizDate pDisptkshrskgnstartymd7) {
        disptkshrskgnstartymd7 = pDisptkshrskgnstartymd7;
    }

    private BizDate disptkshrskgnendymd7;

    public BizDate getDisptkshrskgnendymd7() {
        return disptkshrskgnendymd7;
    }

    public void setDisptkshrskgnendymd7(BizDate pDisptkshrskgnendymd7) {
        disptkshrskgnendymd7 = pDisptkshrskgnendymd7;
    }

    private BizCurrency disptkshrskgngos7;

    public BizCurrency getDisptkshrskgngos7() {
        return disptkshrskgngos7;
    }

    public void setDisptkshrskgngos7(BizCurrency pDisptkshrskgngos7) {
        disptkshrskgngos7 = pDisptkshrskgngos7;
    }

    private Integer disptkkrnbkkn7;

    public Integer getDisptkkrnbkkn7() {
        return disptkkrnbkkn7;
    }

    public void setDisptkkrnbkkn7(Integer pDisptkkrnbkkn7) {
        disptkkrnbkkn7 = pDisptkkrnbkkn7;
    }

    private BizDate disptknkshrstartymd7;

    public BizDate getDisptknkshrstartymd7() {
        return disptknkshrstartymd7;
    }

    public void setDisptknkshrstartymd7(BizDate pDisptknkshrstartymd7) {
        disptknkshrstartymd7 = pDisptknkshrstartymd7;
    }

    private C_Kknenkinsyu disptknenkinsyu7;

    public C_Kknenkinsyu getDisptknenkinsyu7() {
        return disptknenkinsyu7;
    }

    public void setDisptknenkinsyu7(C_Kknenkinsyu pDisptknenkinsyu7) {
        disptknenkinsyu7 = pDisptknenkinsyu7;
    }

    private Integer disptknenkinkkn7;

    public Integer getDisptknenkinkkn7() {
        return disptknenkinkkn7;
    }

    public void setDisptknenkinkkn7(Integer pDisptknenkinkkn7) {
        disptknenkinkkn7 = pDisptknenkinkkn7;
    }

    private BizCurrency disptknknengk7;

    public BizCurrency getDisptknknengk7() {
        return disptknknengk7;
    }

    public void setDisptknknengk7(BizCurrency pDisptknknengk7) {
        disptknknengk7 = pDisptknknengk7;
    }

    private C_Bnshrkaisuu disptkbnshrkaisuu7;

    public C_Bnshrkaisuu getDisptkbnshrkaisuu7() {
        return disptkbnshrkaisuu7;
    }

    public void setDisptkbnshrkaisuu7(C_Bnshrkaisuu pDisptkbnshrkaisuu7) {
        disptkbnshrkaisuu7 = pDisptkbnshrkaisuu7;
    }

    private C_Tkjyskgnkkn disptktkjyskgnkkn7;

    public C_Tkjyskgnkkn getDisptktkjyskgnkkn7() {
        return disptktkjyskgnkkn7;
    }

    public void setDisptktkjyskgnkkn7(C_Tkjyskgnkkn pDisptktkjyskgnkkn7) {
        disptktkjyskgnkkn7 = pDisptktkjyskgnkkn7;
    }

    private BizDate disptktkjyskgnhknnndsymd17;

    public BizDate getDisptktkjyskgnhknnndsymd17() {
        return disptktkjyskgnhknnndsymd17;
    }

    public void setDisptktkjyskgnhknnndsymd17(BizDate pDisptktkjyskgnhknnndsymd17) {
        disptktkjyskgnhknnndsymd17 = pDisptktkjyskgnhknnndsymd17;
    }

    private BizDate disptktkjyskgnhknnndeymd17;

    public BizDate getDisptktkjyskgnhknnndeymd17() {
        return disptktkjyskgnhknnndeymd17;
    }

    public void setDisptktkjyskgnhknnndeymd17(BizDate pDisptktkjyskgnhknnndeymd17) {
        disptktkjyskgnhknnndeymd17 = pDisptktkjyskgnhknnndeymd17;
    }

    private BizCurrency disptktkjyskgns17;

    public BizCurrency getDisptktkjyskgns17() {
        return disptktkjyskgns17;
    }

    public void setDisptktkjyskgns17(BizCurrency pDisptktkjyskgns17) {
        disptktkjyskgns17 = pDisptktkjyskgns17;
    }

    private BizDate disptktkjyskgnhknnndsymd27;

    public BizDate getDisptktkjyskgnhknnndsymd27() {
        return disptktkjyskgnhknnndsymd27;
    }

    public void setDisptktkjyskgnhknnndsymd27(BizDate pDisptktkjyskgnhknnndsymd27) {
        disptktkjyskgnhknnndsymd27 = pDisptktkjyskgnhknnndsymd27;
    }

    private BizDate disptktkjyskgnhknnndeymd27;

    public BizDate getDisptktkjyskgnhknnndeymd27() {
        return disptktkjyskgnhknnndeymd27;
    }

    public void setDisptktkjyskgnhknnndeymd27(BizDate pDisptktkjyskgnhknnndeymd27) {
        disptktkjyskgnhknnndeymd27 = pDisptktkjyskgnhknnndeymd27;
    }

    private BizCurrency disptktkjyskgns27;

    public BizCurrency getDisptktkjyskgns27() {
        return disptktkjyskgns27;
    }

    public void setDisptktkjyskgns27(BizCurrency pDisptktkjyskgns27) {
        disptktkjyskgns27 = pDisptktkjyskgns27;
    }

    private BizDate disptktkjyskgnhknnndsymd37;

    public BizDate getDisptktkjyskgnhknnndsymd37() {
        return disptktkjyskgnhknnndsymd37;
    }

    public void setDisptktkjyskgnhknnndsymd37(BizDate pDisptktkjyskgnhknnndsymd37) {
        disptktkjyskgnhknnndsymd37 = pDisptktkjyskgnhknnndsymd37;
    }

    private BizDate disptktkjyskgnhknnndeymd37;

    public BizDate getDisptktkjyskgnhknnndeymd37() {
        return disptktkjyskgnhknnndeymd37;
    }

    public void setDisptktkjyskgnhknnndeymd37(BizDate pDisptktkjyskgnhknnndeymd37) {
        disptktkjyskgnhknnndeymd37 = pDisptktkjyskgnhknnndeymd37;
    }

    private BizCurrency disptktkjyskgns37;

    public BizCurrency getDisptktkjyskgns37() {
        return disptktkjyskgns37;
    }

    public void setDisptktkjyskgns37(BizCurrency pDisptktkjyskgns37) {
        disptktkjyskgns37 = pDisptktkjyskgns37;
    }

    private BizDate disptktkjyskgnhknnndsymd47;

    public BizDate getDisptktkjyskgnhknnndsymd47() {
        return disptktkjyskgnhknnndsymd47;
    }

    public void setDisptktkjyskgnhknnndsymd47(BizDate pDisptktkjyskgnhknnndsymd47) {
        disptktkjyskgnhknnndsymd47 = pDisptktkjyskgnhknnndsymd47;
    }

    private BizDate disptktkjyskgnhknnndeymd47;

    public BizDate getDisptktkjyskgnhknnndeymd47() {
        return disptktkjyskgnhknnndeymd47;
    }

    public void setDisptktkjyskgnhknnndeymd47(BizDate pDisptktkjyskgnhknnndeymd47) {
        disptktkjyskgnhknnndeymd47 = pDisptktkjyskgnhknnndeymd47;
    }

    private BizCurrency disptktkjyskgns47;

    public BizCurrency getDisptktkjyskgns47() {
        return disptktkjyskgns47;
    }

    public void setDisptktkjyskgns47(BizCurrency pDisptktkjyskgns47) {
        disptktkjyskgns47 = pDisptktkjyskgns47;
    }

    private BizDate disptktkjyskgnhknnndsymd57;

    public BizDate getDisptktkjyskgnhknnndsymd57() {
        return disptktkjyskgnhknnndsymd57;
    }

    public void setDisptktkjyskgnhknnndsymd57(BizDate pDisptktkjyskgnhknnndsymd57) {
        disptktkjyskgnhknnndsymd57 = pDisptktkjyskgnhknnndsymd57;
    }

    private BizDate disptktkjyskgnhknnndeymd57;

    public BizDate getDisptktkjyskgnhknnndeymd57() {
        return disptktkjyskgnhknnndeymd57;
    }

    public void setDisptktkjyskgnhknnndeymd57(BizDate pDisptktkjyskgnhknnndeymd57) {
        disptktkjyskgnhknnndeymd57 = pDisptktkjyskgnhknnndeymd57;
    }

    private BizCurrency disptktkjyskgns57;

    public BizCurrency getDisptktkjyskgns57() {
        return disptktkjyskgns57;
    }

    public void setDisptktkjyskgns57(BizCurrency pDisptktkjyskgns57) {
        disptktkjyskgns57 = pDisptktkjyskgns57;
    }

    private C_Tkjyhyouten disptktkjyhyouten7;

    public C_Tkjyhyouten getDisptktkjyhyouten7() {
        return disptktkjyhyouten7;
    }

    public void setDisptktkjyhyouten7(C_Tkjyhyouten pDisptktkjyhyouten7) {
        disptktkjyhyouten7 = pDisptktkjyhyouten7;
    }

    private BizCurrency disptktkjyp7;

    public BizCurrency getDisptktkjyp7() {
        return disptktkjyp7;
    }

    public void setDisptktkjyp7(BizCurrency pDisptktkjyp7) {
        disptktkjyp7 = pDisptktkjyp7;
    }

    private String disptkhtnpbuicd17;

    public String getDisptkhtnpbuicd17() {
        return disptkhtnpbuicd17;
    }

    public void setDisptkhtnpbuicd17(String pDisptkhtnpbuicd17) {
        disptkhtnpbuicd17 = pDisptkhtnpbuicd17;
    }

    private String disptkhtnpbuinm17;

    public String getDisptkhtnpbuinm17() {
        return disptkhtnpbuinm17;
    }

    public void setDisptkhtnpbuinm17(String pDisptkhtnpbuinm17) {
        disptkhtnpbuinm17 = pDisptkhtnpbuinm17;
    }

    private C_Htnpkkn disptkhtnpkkn17;

    public C_Htnpkkn getDisptkhtnpkkn17() {
        return disptkhtnpkkn17;
    }

    public void setDisptkhtnpkkn17(C_Htnpkkn pDisptkhtnpkkn17) {
        disptkhtnpkkn17 = pDisptkhtnpkkn17;
    }

    private String disptkhtnpbuicd27;

    public String getDisptkhtnpbuicd27() {
        return disptkhtnpbuicd27;
    }

    public void setDisptkhtnpbuicd27(String pDisptkhtnpbuicd27) {
        disptkhtnpbuicd27 = pDisptkhtnpbuicd27;
    }

    private String disptkhtnpbuinm27;

    public String getDisptkhtnpbuinm27() {
        return disptkhtnpbuinm27;
    }

    public void setDisptkhtnpbuinm27(String pDisptkhtnpbuinm27) {
        disptkhtnpbuinm27 = pDisptkhtnpbuinm27;
    }

    private C_Htnpkkn disptkhtnpkkn27;

    public C_Htnpkkn getDisptkhtnpkkn27() {
        return disptkhtnpkkn27;
    }

    public void setDisptkhtnpkkn27(C_Htnpkkn pDisptkhtnpkkn27) {
        disptkhtnpkkn27 = pDisptkhtnpkkn27;
    }

    private String disptkhtnpbuicd37;

    public String getDisptkhtnpbuicd37() {
        return disptkhtnpbuicd37;
    }

    public void setDisptkhtnpbuicd37(String pDisptkhtnpbuicd37) {
        disptkhtnpbuicd37 = pDisptkhtnpbuicd37;
    }

    private String disptkhtnpbuinm37;

    public String getDisptkhtnpbuinm37() {
        return disptkhtnpbuinm37;
    }

    public void setDisptkhtnpbuinm37(String pDisptkhtnpbuinm37) {
        disptkhtnpbuinm37 = pDisptkhtnpbuinm37;
    }

    private C_Htnpkkn disptkhtnpkkn37;

    public C_Htnpkkn getDisptkhtnpkkn37() {
        return disptkhtnpkkn37;
    }

    public void setDisptkhtnpkkn37(C_Htnpkkn pDisptkhtnpkkn37) {
        disptkhtnpkkn37 = pDisptkhtnpkkn37;
    }

    private String disptkhtnpbuicd47;

    public String getDisptkhtnpbuicd47() {
        return disptkhtnpbuicd47;
    }

    public void setDisptkhtnpbuicd47(String pDisptkhtnpbuicd47) {
        disptkhtnpbuicd47 = pDisptkhtnpbuicd47;
    }

    private String disptkhtnpbuinm47;

    public String getDisptkhtnpbuinm47() {
        return disptkhtnpbuinm47;
    }

    public void setDisptkhtnpbuinm47(String pDisptkhtnpbuinm47) {
        disptkhtnpbuinm47 = pDisptkhtnpbuinm47;
    }

    private C_Htnpkkn disptkhtnpkkn47;

    public C_Htnpkkn getDisptkhtnpkkn47() {
        return disptkhtnpkkn47;
    }

    public void setDisptkhtnpkkn47(C_Htnpkkn pDisptkhtnpkkn47) {
        disptkhtnpkkn47 = pDisptkhtnpkkn47;
    }

    private C_TokkoudosghtnpKbn disptktokkoudosghtnpkbn7;

    public C_TokkoudosghtnpKbn getDisptktokkoudosghtnpkbn7() {
        return disptktokkoudosghtnpkbn7;
    }

    public void setDisptktokkoudosghtnpkbn7(C_TokkoudosghtnpKbn pDisptktokkoudosghtnpkbn7) {
        disptktokkoudosghtnpkbn7 = pDisptktokkoudosghtnpkbn7;
    }

    private BizDate disptkkouryokuhasseiymd7;

    public BizDate getDisptkkouryokuhasseiymd7() {
        return disptkkouryokuhasseiymd7;
    }

    public void setDisptkkouryokuhasseiymd7(BizDate pDisptkkouryokuhasseiymd7) {
        disptkkouryokuhasseiymd7 = pDisptkkouryokuhasseiymd7;
    }

    private String disptksyouhnnm8;

    public String getDisptksyouhnnm8() {
        return disptksyouhnnm8;
    }

    public void setDisptksyouhnnm8(String pDisptksyouhnnm8) {
        disptksyouhnnm8 = pDisptksyouhnnm8;
    }

    private C_KataKbn disptokuyakukatakbn8;

    public C_KataKbn getDisptokuyakukatakbn8() {
        return disptokuyakukatakbn8;
    }

    public void setDisptokuyakukatakbn8(C_KataKbn pDisptokuyakukatakbn8) {
        disptokuyakukatakbn8 = pDisptokuyakukatakbn8;
    }

    private C_KyhgndkataKbn disptkkyhgndkatakbn8;

    public C_KyhgndkataKbn getDisptkkyhgndkatakbn8() {
        return disptkkyhgndkatakbn8;
    }

    public void setDisptkkyhgndkatakbn8(C_KyhgndkataKbn pDisptkkyhgndkatakbn8) {
        disptkkyhgndkatakbn8 = pDisptkkyhgndkatakbn8;
    }

    private Integer disptkhhknnen8;

    public Integer getDisptkhhknnen8() {
        return disptkhhknnen8;
    }

    public void setDisptkhhknnen8(Integer pDisptkhhknnen8) {
        disptkhhknnen8 = pDisptkhhknnen8;
    }

    private BizDate disptkkykymd8;

    public BizDate getDisptkkykymd8() {
        return disptkkykymd8;
    }

    public void setDisptkkykymd8(BizDate pDisptkkykymd8) {
        disptkkykymd8 = pDisptkkykymd8;
    }

    private BizDate disptksknnkaisiymd8;

    public BizDate getDisptksknnkaisiymd8() {
        return disptksknnkaisiymd8;
    }

    public void setDisptksknnkaisiymd8(BizDate pDisptksknnkaisiymd8) {
        disptksknnkaisiymd8 = pDisptksknnkaisiymd8;
    }

    private BizDate disptkgansknnkaisiymd8;

    public BizDate getDisptkgansknnkaisiymd8() {
        return disptkgansknnkaisiymd8;
    }

    public void setDisptkgansknnkaisiymd8(BizDate pDisptkgansknnkaisiymd8) {
        disptkgansknnkaisiymd8 = pDisptkgansknnkaisiymd8;
    }

    private BizDate disptkhksknnkaisiymd8;

    public BizDate getDisptkhksknnkaisiymd8() {
        return disptkhksknnkaisiymd8;
    }

    public void setDisptkhksknnkaisiymd8(BizDate pDisptkhksknnkaisiymd8) {
        disptkhksknnkaisiymd8 = pDisptkhksknnkaisiymd8;
    }

    private BizDate disptkhkgansknnkaisiymd8;

    public BizDate getDisptkhkgansknnkaisiymd8() {
        return disptkhkgansknnkaisiymd8;
    }

    public void setDisptkhkgansknnkaisiymd8(BizDate pDisptkhkgansknnkaisiymd8) {
        disptkhkgansknnkaisiymd8 = pDisptkhkgansknnkaisiymd8;
    }

    private Integer disptkhknkkn8;

    public Integer getDisptkhknkkn8() {
        return disptkhknkkn8;
    }

    public void setDisptkhknkkn8(Integer pDisptkhknkkn8) {
        disptkhknkkn8 = pDisptkhknkkn8;
    }

    private C_HknkknsmnKbn disptkhknkknsmnkbn8;

    public C_HknkknsmnKbn getDisptkhknkknsmnkbn8() {
        return disptkhknkknsmnkbn8;
    }

    public void setDisptkhknkknsmnkbn8(C_HknkknsmnKbn pDisptkhknkknsmnkbn8) {
        disptkhknkknsmnkbn8 = pDisptkhknkknsmnkbn8;
    }

    private Integer disptkhrkkkn8;

    public Integer getDisptkhrkkkn8() {
        return disptkhrkkkn8;
    }

    public void setDisptkhrkkkn8(Integer pDisptkhrkkkn8) {
        disptkhrkkkn8 = pDisptkhrkkkn8;
    }

    private C_HrkkknsmnKbn disptkhrkkknsmnkbn8;

    public C_HrkkknsmnKbn getDisptkhrkkknsmnkbn8() {
        return disptkhrkkknsmnkbn8;
    }

    public void setDisptkhrkkknsmnkbn8(C_HrkkknsmnKbn pDisptkhrkkknsmnkbn8) {
        disptkhrkkknsmnkbn8 = pDisptkhrkkknsmnkbn8;
    }

    private C_KihonssyuruiKbn disptkkihonssyuruikbn8;

    public C_KihonssyuruiKbn getDisptkkihonssyuruikbn8() {
        return disptkkihonssyuruikbn8;
    }

    public void setDisptkkihonssyuruikbn8(C_KihonssyuruiKbn pDisptkkihonssyuruikbn8) {
        disptkkihonssyuruikbn8 = pDisptkkihonssyuruikbn8;
    }

    private BizCurrency disptkkihons8;

    public BizCurrency getDisptkkihons8() {
        return disptkkihons8;
    }

    public void setDisptkkihons8(BizCurrency pDisptkkihons8) {
        disptkkihons8 = pDisptkkihons8;
    }

    private BizCurrency disptktsnshrgndgk8;

    public BizCurrency getDisptktsnshrgndgk8() {
        return disptktsnshrgndgk8;
    }

    public void setDisptktsnshrgndgk8(BizCurrency pDisptktsnshrgndgk8) {
        disptktsnshrgndgk8 = pDisptktsnshrgndgk8;
    }

    private BizCurrency disptkp8;

    public BizCurrency getDisptkp8() {
        return disptkp8;
    }

    public void setDisptkp8(BizCurrency pDisptkp8) {
        disptkp8 = pDisptkp8;
    }

    private BizCurrency disptknextkosgop8;

    public BizCurrency getDisptknextkosgop8() {
        return disptknextkosgop8;
    }

    public void setDisptknextkosgop8(BizCurrency pDisptknextkosgop8) {
        disptknextkosgop8 = pDisptknextkosgop8;
    }

    private BizCurrency disptkgannyukyhntgk8;

    public BizCurrency getDisptkgannyukyhntgk8() {
        return disptkgannyukyhntgk8;
    }

    public void setDisptkgannyukyhntgk8(BizCurrency pDisptkgannyukyhntgk8) {
        disptkgannyukyhntgk8 = pDisptkgannyukyhntgk8;
    }

    private BizDate disptkshrskgnstartymd8;

    public BizDate getDisptkshrskgnstartymd8() {
        return disptkshrskgnstartymd8;
    }

    public void setDisptkshrskgnstartymd8(BizDate pDisptkshrskgnstartymd8) {
        disptkshrskgnstartymd8 = pDisptkshrskgnstartymd8;
    }

    private BizDate disptkshrskgnendymd8;

    public BizDate getDisptkshrskgnendymd8() {
        return disptkshrskgnendymd8;
    }

    public void setDisptkshrskgnendymd8(BizDate pDisptkshrskgnendymd8) {
        disptkshrskgnendymd8 = pDisptkshrskgnendymd8;
    }

    private BizCurrency disptkshrskgngos8;

    public BizCurrency getDisptkshrskgngos8() {
        return disptkshrskgngos8;
    }

    public void setDisptkshrskgngos8(BizCurrency pDisptkshrskgngos8) {
        disptkshrskgngos8 = pDisptkshrskgngos8;
    }

    private Integer disptkkrnbkkn8;

    public Integer getDisptkkrnbkkn8() {
        return disptkkrnbkkn8;
    }

    public void setDisptkkrnbkkn8(Integer pDisptkkrnbkkn8) {
        disptkkrnbkkn8 = pDisptkkrnbkkn8;
    }

    private BizDate disptknkshrstartymd8;

    public BizDate getDisptknkshrstartymd8() {
        return disptknkshrstartymd8;
    }

    public void setDisptknkshrstartymd8(BizDate pDisptknkshrstartymd8) {
        disptknkshrstartymd8 = pDisptknkshrstartymd8;
    }

    private C_Kknenkinsyu disptknenkinsyu8;

    public C_Kknenkinsyu getDisptknenkinsyu8() {
        return disptknenkinsyu8;
    }

    public void setDisptknenkinsyu8(C_Kknenkinsyu pDisptknenkinsyu8) {
        disptknenkinsyu8 = pDisptknenkinsyu8;
    }

    private Integer disptknenkinkkn8;

    public Integer getDisptknenkinkkn8() {
        return disptknenkinkkn8;
    }

    public void setDisptknenkinkkn8(Integer pDisptknenkinkkn8) {
        disptknenkinkkn8 = pDisptknenkinkkn8;
    }

    private BizCurrency disptknknengk8;

    public BizCurrency getDisptknknengk8() {
        return disptknknengk8;
    }

    public void setDisptknknengk8(BizCurrency pDisptknknengk8) {
        disptknknengk8 = pDisptknknengk8;
    }

    private C_Bnshrkaisuu disptkbnshrkaisuu8;

    public C_Bnshrkaisuu getDisptkbnshrkaisuu8() {
        return disptkbnshrkaisuu8;
    }

    public void setDisptkbnshrkaisuu8(C_Bnshrkaisuu pDisptkbnshrkaisuu8) {
        disptkbnshrkaisuu8 = pDisptkbnshrkaisuu8;
    }

    private C_Tkjyskgnkkn disptktkjyskgnkkn8;

    public C_Tkjyskgnkkn getDisptktkjyskgnkkn8() {
        return disptktkjyskgnkkn8;
    }

    public void setDisptktkjyskgnkkn8(C_Tkjyskgnkkn pDisptktkjyskgnkkn8) {
        disptktkjyskgnkkn8 = pDisptktkjyskgnkkn8;
    }

    private BizDate disptktkjyskgnhknnndsymd18;

    public BizDate getDisptktkjyskgnhknnndsymd18() {
        return disptktkjyskgnhknnndsymd18;
    }

    public void setDisptktkjyskgnhknnndsymd18(BizDate pDisptktkjyskgnhknnndsymd18) {
        disptktkjyskgnhknnndsymd18 = pDisptktkjyskgnhknnndsymd18;
    }

    private BizDate disptktkjyskgnhknnndeymd18;

    public BizDate getDisptktkjyskgnhknnndeymd18() {
        return disptktkjyskgnhknnndeymd18;
    }

    public void setDisptktkjyskgnhknnndeymd18(BizDate pDisptktkjyskgnhknnndeymd18) {
        disptktkjyskgnhknnndeymd18 = pDisptktkjyskgnhknnndeymd18;
    }

    private BizCurrency disptktkjyskgns18;

    public BizCurrency getDisptktkjyskgns18() {
        return disptktkjyskgns18;
    }

    public void setDisptktkjyskgns18(BizCurrency pDisptktkjyskgns18) {
        disptktkjyskgns18 = pDisptktkjyskgns18;
    }

    private BizDate disptktkjyskgnhknnndsymd28;

    public BizDate getDisptktkjyskgnhknnndsymd28() {
        return disptktkjyskgnhknnndsymd28;
    }

    public void setDisptktkjyskgnhknnndsymd28(BizDate pDisptktkjyskgnhknnndsymd28) {
        disptktkjyskgnhknnndsymd28 = pDisptktkjyskgnhknnndsymd28;
    }

    private BizDate disptktkjyskgnhknnndeymd28;

    public BizDate getDisptktkjyskgnhknnndeymd28() {
        return disptktkjyskgnhknnndeymd28;
    }

    public void setDisptktkjyskgnhknnndeymd28(BizDate pDisptktkjyskgnhknnndeymd28) {
        disptktkjyskgnhknnndeymd28 = pDisptktkjyskgnhknnndeymd28;
    }

    private BizCurrency disptktkjyskgns28;

    public BizCurrency getDisptktkjyskgns28() {
        return disptktkjyskgns28;
    }

    public void setDisptktkjyskgns28(BizCurrency pDisptktkjyskgns28) {
        disptktkjyskgns28 = pDisptktkjyskgns28;
    }

    private BizDate disptktkjyskgnhknnndsymd38;

    public BizDate getDisptktkjyskgnhknnndsymd38() {
        return disptktkjyskgnhknnndsymd38;
    }

    public void setDisptktkjyskgnhknnndsymd38(BizDate pDisptktkjyskgnhknnndsymd38) {
        disptktkjyskgnhknnndsymd38 = pDisptktkjyskgnhknnndsymd38;
    }

    private BizDate disptktkjyskgnhknnndeymd38;

    public BizDate getDisptktkjyskgnhknnndeymd38() {
        return disptktkjyskgnhknnndeymd38;
    }

    public void setDisptktkjyskgnhknnndeymd38(BizDate pDisptktkjyskgnhknnndeymd38) {
        disptktkjyskgnhknnndeymd38 = pDisptktkjyskgnhknnndeymd38;
    }

    private BizCurrency disptktkjyskgns38;

    public BizCurrency getDisptktkjyskgns38() {
        return disptktkjyskgns38;
    }

    public void setDisptktkjyskgns38(BizCurrency pDisptktkjyskgns38) {
        disptktkjyskgns38 = pDisptktkjyskgns38;
    }

    private BizDate disptktkjyskgnhknnndsymd48;

    public BizDate getDisptktkjyskgnhknnndsymd48() {
        return disptktkjyskgnhknnndsymd48;
    }

    public void setDisptktkjyskgnhknnndsymd48(BizDate pDisptktkjyskgnhknnndsymd48) {
        disptktkjyskgnhknnndsymd48 = pDisptktkjyskgnhknnndsymd48;
    }

    private BizDate disptktkjyskgnhknnndeymd48;

    public BizDate getDisptktkjyskgnhknnndeymd48() {
        return disptktkjyskgnhknnndeymd48;
    }

    public void setDisptktkjyskgnhknnndeymd48(BizDate pDisptktkjyskgnhknnndeymd48) {
        disptktkjyskgnhknnndeymd48 = pDisptktkjyskgnhknnndeymd48;
    }

    private BizCurrency disptktkjyskgns48;

    public BizCurrency getDisptktkjyskgns48() {
        return disptktkjyskgns48;
    }

    public void setDisptktkjyskgns48(BizCurrency pDisptktkjyskgns48) {
        disptktkjyskgns48 = pDisptktkjyskgns48;
    }

    private BizDate disptktkjyskgnhknnndsymd58;

    public BizDate getDisptktkjyskgnhknnndsymd58() {
        return disptktkjyskgnhknnndsymd58;
    }

    public void setDisptktkjyskgnhknnndsymd58(BizDate pDisptktkjyskgnhknnndsymd58) {
        disptktkjyskgnhknnndsymd58 = pDisptktkjyskgnhknnndsymd58;
    }

    private BizDate disptktkjyskgnhknnndeymd58;

    public BizDate getDisptktkjyskgnhknnndeymd58() {
        return disptktkjyskgnhknnndeymd58;
    }

    public void setDisptktkjyskgnhknnndeymd58(BizDate pDisptktkjyskgnhknnndeymd58) {
        disptktkjyskgnhknnndeymd58 = pDisptktkjyskgnhknnndeymd58;
    }

    private BizCurrency disptktkjyskgns58;

    public BizCurrency getDisptktkjyskgns58() {
        return disptktkjyskgns58;
    }

    public void setDisptktkjyskgns58(BizCurrency pDisptktkjyskgns58) {
        disptktkjyskgns58 = pDisptktkjyskgns58;
    }

    private C_Tkjyhyouten disptktkjyhyouten8;

    public C_Tkjyhyouten getDisptktkjyhyouten8() {
        return disptktkjyhyouten8;
    }

    public void setDisptktkjyhyouten8(C_Tkjyhyouten pDisptktkjyhyouten8) {
        disptktkjyhyouten8 = pDisptktkjyhyouten8;
    }

    private BizCurrency disptktkjyp8;

    public BizCurrency getDisptktkjyp8() {
        return disptktkjyp8;
    }

    public void setDisptktkjyp8(BizCurrency pDisptktkjyp8) {
        disptktkjyp8 = pDisptktkjyp8;
    }

    private String disptkhtnpbuicd18;

    public String getDisptkhtnpbuicd18() {
        return disptkhtnpbuicd18;
    }

    public void setDisptkhtnpbuicd18(String pDisptkhtnpbuicd18) {
        disptkhtnpbuicd18 = pDisptkhtnpbuicd18;
    }

    private String disptkhtnpbuinm18;

    public String getDisptkhtnpbuinm18() {
        return disptkhtnpbuinm18;
    }

    public void setDisptkhtnpbuinm18(String pDisptkhtnpbuinm18) {
        disptkhtnpbuinm18 = pDisptkhtnpbuinm18;
    }

    private C_Htnpkkn disptkhtnpkkn18;

    public C_Htnpkkn getDisptkhtnpkkn18() {
        return disptkhtnpkkn18;
    }

    public void setDisptkhtnpkkn18(C_Htnpkkn pDisptkhtnpkkn18) {
        disptkhtnpkkn18 = pDisptkhtnpkkn18;
    }

    private String disptkhtnpbuicd28;

    public String getDisptkhtnpbuicd28() {
        return disptkhtnpbuicd28;
    }

    public void setDisptkhtnpbuicd28(String pDisptkhtnpbuicd28) {
        disptkhtnpbuicd28 = pDisptkhtnpbuicd28;
    }

    private String disptkhtnpbuinm28;

    public String getDisptkhtnpbuinm28() {
        return disptkhtnpbuinm28;
    }

    public void setDisptkhtnpbuinm28(String pDisptkhtnpbuinm28) {
        disptkhtnpbuinm28 = pDisptkhtnpbuinm28;
    }

    private C_Htnpkkn disptkhtnpkkn28;

    public C_Htnpkkn getDisptkhtnpkkn28() {
        return disptkhtnpkkn28;
    }

    public void setDisptkhtnpkkn28(C_Htnpkkn pDisptkhtnpkkn28) {
        disptkhtnpkkn28 = pDisptkhtnpkkn28;
    }

    private String disptkhtnpbuicd38;

    public String getDisptkhtnpbuicd38() {
        return disptkhtnpbuicd38;
    }

    public void setDisptkhtnpbuicd38(String pDisptkhtnpbuicd38) {
        disptkhtnpbuicd38 = pDisptkhtnpbuicd38;
    }

    private String disptkhtnpbuinm38;

    public String getDisptkhtnpbuinm38() {
        return disptkhtnpbuinm38;
    }

    public void setDisptkhtnpbuinm38(String pDisptkhtnpbuinm38) {
        disptkhtnpbuinm38 = pDisptkhtnpbuinm38;
    }

    private C_Htnpkkn disptkhtnpkkn38;

    public C_Htnpkkn getDisptkhtnpkkn38() {
        return disptkhtnpkkn38;
    }

    public void setDisptkhtnpkkn38(C_Htnpkkn pDisptkhtnpkkn38) {
        disptkhtnpkkn38 = pDisptkhtnpkkn38;
    }

    private String disptkhtnpbuicd48;

    public String getDisptkhtnpbuicd48() {
        return disptkhtnpbuicd48;
    }

    public void setDisptkhtnpbuicd48(String pDisptkhtnpbuicd48) {
        disptkhtnpbuicd48 = pDisptkhtnpbuicd48;
    }

    private String disptkhtnpbuinm48;

    public String getDisptkhtnpbuinm48() {
        return disptkhtnpbuinm48;
    }

    public void setDisptkhtnpbuinm48(String pDisptkhtnpbuinm48) {
        disptkhtnpbuinm48 = pDisptkhtnpbuinm48;
    }

    private C_Htnpkkn disptkhtnpkkn48;

    public C_Htnpkkn getDisptkhtnpkkn48() {
        return disptkhtnpkkn48;
    }

    public void setDisptkhtnpkkn48(C_Htnpkkn pDisptkhtnpkkn48) {
        disptkhtnpkkn48 = pDisptkhtnpkkn48;
    }

    private C_TokkoudosghtnpKbn disptktokkoudosghtnpkbn8;

    public C_TokkoudosghtnpKbn getDisptktokkoudosghtnpkbn8() {
        return disptktokkoudosghtnpkbn8;
    }

    public void setDisptktokkoudosghtnpkbn8(C_TokkoudosghtnpKbn pDisptktokkoudosghtnpkbn8) {
        disptktokkoudosghtnpkbn8 = pDisptktokkoudosghtnpkbn8;
    }

    private BizDate disptkkouryokuhasseiymd8;

    public BizDate getDisptkkouryokuhasseiymd8() {
        return disptkkouryokuhasseiymd8;
    }

    public void setDisptkkouryokuhasseiymd8(BizDate pDisptkkouryokuhasseiymd8) {
        disptkkouryokuhasseiymd8 = pDisptkkouryokuhasseiymd8;
    }

    private String disptksyouhnnm9;

    public String getDisptksyouhnnm9() {
        return disptksyouhnnm9;
    }

    public void setDisptksyouhnnm9(String pDisptksyouhnnm9) {
        disptksyouhnnm9 = pDisptksyouhnnm9;
    }

    private C_KataKbn disptokuyakukatakbn9;

    public C_KataKbn getDisptokuyakukatakbn9() {
        return disptokuyakukatakbn9;
    }

    public void setDisptokuyakukatakbn9(C_KataKbn pDisptokuyakukatakbn9) {
        disptokuyakukatakbn9 = pDisptokuyakukatakbn9;
    }

    private C_KyhgndkataKbn disptkkyhgndkatakbn9;

    public C_KyhgndkataKbn getDisptkkyhgndkatakbn9() {
        return disptkkyhgndkatakbn9;
    }

    public void setDisptkkyhgndkatakbn9(C_KyhgndkataKbn pDisptkkyhgndkatakbn9) {
        disptkkyhgndkatakbn9 = pDisptkkyhgndkatakbn9;
    }

    private Integer disptkhhknnen9;

    public Integer getDisptkhhknnen9() {
        return disptkhhknnen9;
    }

    public void setDisptkhhknnen9(Integer pDisptkhhknnen9) {
        disptkhhknnen9 = pDisptkhhknnen9;
    }

    private BizDate disptkkykymd9;

    public BizDate getDisptkkykymd9() {
        return disptkkykymd9;
    }

    public void setDisptkkykymd9(BizDate pDisptkkykymd9) {
        disptkkykymd9 = pDisptkkykymd9;
    }

    private BizDate disptksknnkaisiymd9;

    public BizDate getDisptksknnkaisiymd9() {
        return disptksknnkaisiymd9;
    }

    public void setDisptksknnkaisiymd9(BizDate pDisptksknnkaisiymd9) {
        disptksknnkaisiymd9 = pDisptksknnkaisiymd9;
    }

    private BizDate disptkgansknnkaisiymd9;

    public BizDate getDisptkgansknnkaisiymd9() {
        return disptkgansknnkaisiymd9;
    }

    public void setDisptkgansknnkaisiymd9(BizDate pDisptkgansknnkaisiymd9) {
        disptkgansknnkaisiymd9 = pDisptkgansknnkaisiymd9;
    }

    private BizDate disptkhksknnkaisiymd9;

    public BizDate getDisptkhksknnkaisiymd9() {
        return disptkhksknnkaisiymd9;
    }

    public void setDisptkhksknnkaisiymd9(BizDate pDisptkhksknnkaisiymd9) {
        disptkhksknnkaisiymd9 = pDisptkhksknnkaisiymd9;
    }

    private BizDate disptkhkgansknnkaisiymd9;

    public BizDate getDisptkhkgansknnkaisiymd9() {
        return disptkhkgansknnkaisiymd9;
    }

    public void setDisptkhkgansknnkaisiymd9(BizDate pDisptkhkgansknnkaisiymd9) {
        disptkhkgansknnkaisiymd9 = pDisptkhkgansknnkaisiymd9;
    }

    private Integer disptkhknkkn9;

    public Integer getDisptkhknkkn9() {
        return disptkhknkkn9;
    }

    public void setDisptkhknkkn9(Integer pDisptkhknkkn9) {
        disptkhknkkn9 = pDisptkhknkkn9;
    }

    private C_HknkknsmnKbn disptkhknkknsmnkbn9;

    public C_HknkknsmnKbn getDisptkhknkknsmnkbn9() {
        return disptkhknkknsmnkbn9;
    }

    public void setDisptkhknkknsmnkbn9(C_HknkknsmnKbn pDisptkhknkknsmnkbn9) {
        disptkhknkknsmnkbn9 = pDisptkhknkknsmnkbn9;
    }

    private Integer disptkhrkkkn9;

    public Integer getDisptkhrkkkn9() {
        return disptkhrkkkn9;
    }

    public void setDisptkhrkkkn9(Integer pDisptkhrkkkn9) {
        disptkhrkkkn9 = pDisptkhrkkkn9;
    }

    private C_HrkkknsmnKbn disptkhrkkknsmnkbn9;

    public C_HrkkknsmnKbn getDisptkhrkkknsmnkbn9() {
        return disptkhrkkknsmnkbn9;
    }

    public void setDisptkhrkkknsmnkbn9(C_HrkkknsmnKbn pDisptkhrkkknsmnkbn9) {
        disptkhrkkknsmnkbn9 = pDisptkhrkkknsmnkbn9;
    }

    private C_KihonssyuruiKbn disptkkihonssyuruikbn9;

    public C_KihonssyuruiKbn getDisptkkihonssyuruikbn9() {
        return disptkkihonssyuruikbn9;
    }

    public void setDisptkkihonssyuruikbn9(C_KihonssyuruiKbn pDisptkkihonssyuruikbn9) {
        disptkkihonssyuruikbn9 = pDisptkkihonssyuruikbn9;
    }

    private BizCurrency disptkkihons9;

    public BizCurrency getDisptkkihons9() {
        return disptkkihons9;
    }

    public void setDisptkkihons9(BizCurrency pDisptkkihons9) {
        disptkkihons9 = pDisptkkihons9;
    }

    private BizCurrency disptktsnshrgndgk9;

    public BizCurrency getDisptktsnshrgndgk9() {
        return disptktsnshrgndgk9;
    }

    public void setDisptktsnshrgndgk9(BizCurrency pDisptktsnshrgndgk9) {
        disptktsnshrgndgk9 = pDisptktsnshrgndgk9;
    }

    private BizCurrency disptkp9;

    public BizCurrency getDisptkp9() {
        return disptkp9;
    }

    public void setDisptkp9(BizCurrency pDisptkp9) {
        disptkp9 = pDisptkp9;
    }

    private BizCurrency disptknextkosgop9;

    public BizCurrency getDisptknextkosgop9() {
        return disptknextkosgop9;
    }

    public void setDisptknextkosgop9(BizCurrency pDisptknextkosgop9) {
        disptknextkosgop9 = pDisptknextkosgop9;
    }

    private BizCurrency disptkgannyukyhntgk9;

    public BizCurrency getDisptkgannyukyhntgk9() {
        return disptkgannyukyhntgk9;
    }

    public void setDisptkgannyukyhntgk9(BizCurrency pDisptkgannyukyhntgk9) {
        disptkgannyukyhntgk9 = pDisptkgannyukyhntgk9;
    }

    private BizDate disptkshrskgnstartymd9;

    public BizDate getDisptkshrskgnstartymd9() {
        return disptkshrskgnstartymd9;
    }

    public void setDisptkshrskgnstartymd9(BizDate pDisptkshrskgnstartymd9) {
        disptkshrskgnstartymd9 = pDisptkshrskgnstartymd9;
    }

    private BizDate disptkshrskgnendymd9;

    public BizDate getDisptkshrskgnendymd9() {
        return disptkshrskgnendymd9;
    }

    public void setDisptkshrskgnendymd9(BizDate pDisptkshrskgnendymd9) {
        disptkshrskgnendymd9 = pDisptkshrskgnendymd9;
    }

    private BizCurrency disptkshrskgngos9;

    public BizCurrency getDisptkshrskgngos9() {
        return disptkshrskgngos9;
    }

    public void setDisptkshrskgngos9(BizCurrency pDisptkshrskgngos9) {
        disptkshrskgngos9 = pDisptkshrskgngos9;
    }

    private Integer disptkkrnbkkn9;

    public Integer getDisptkkrnbkkn9() {
        return disptkkrnbkkn9;
    }

    public void setDisptkkrnbkkn9(Integer pDisptkkrnbkkn9) {
        disptkkrnbkkn9 = pDisptkkrnbkkn9;
    }

    private BizDate disptknkshrstartymd9;

    public BizDate getDisptknkshrstartymd9() {
        return disptknkshrstartymd9;
    }

    public void setDisptknkshrstartymd9(BizDate pDisptknkshrstartymd9) {
        disptknkshrstartymd9 = pDisptknkshrstartymd9;
    }

    private C_Kknenkinsyu disptknenkinsyu9;

    public C_Kknenkinsyu getDisptknenkinsyu9() {
        return disptknenkinsyu9;
    }

    public void setDisptknenkinsyu9(C_Kknenkinsyu pDisptknenkinsyu9) {
        disptknenkinsyu9 = pDisptknenkinsyu9;
    }

    private Integer disptknenkinkkn9;

    public Integer getDisptknenkinkkn9() {
        return disptknenkinkkn9;
    }

    public void setDisptknenkinkkn9(Integer pDisptknenkinkkn9) {
        disptknenkinkkn9 = pDisptknenkinkkn9;
    }

    private BizCurrency disptknknengk9;

    public BizCurrency getDisptknknengk9() {
        return disptknknengk9;
    }

    public void setDisptknknengk9(BizCurrency pDisptknknengk9) {
        disptknknengk9 = pDisptknknengk9;
    }

    private C_Bnshrkaisuu disptkbnshrkaisuu9;

    public C_Bnshrkaisuu getDisptkbnshrkaisuu9() {
        return disptkbnshrkaisuu9;
    }

    public void setDisptkbnshrkaisuu9(C_Bnshrkaisuu pDisptkbnshrkaisuu9) {
        disptkbnshrkaisuu9 = pDisptkbnshrkaisuu9;
    }

    private C_Tkjyskgnkkn disptktkjyskgnkkn9;

    public C_Tkjyskgnkkn getDisptktkjyskgnkkn9() {
        return disptktkjyskgnkkn9;
    }

    public void setDisptktkjyskgnkkn9(C_Tkjyskgnkkn pDisptktkjyskgnkkn9) {
        disptktkjyskgnkkn9 = pDisptktkjyskgnkkn9;
    }

    private BizDate disptktkjyskgnhknnndsymd19;

    public BizDate getDisptktkjyskgnhknnndsymd19() {
        return disptktkjyskgnhknnndsymd19;
    }

    public void setDisptktkjyskgnhknnndsymd19(BizDate pDisptktkjyskgnhknnndsymd19) {
        disptktkjyskgnhknnndsymd19 = pDisptktkjyskgnhknnndsymd19;
    }

    private BizDate disptktkjyskgnhknnndeymd19;

    public BizDate getDisptktkjyskgnhknnndeymd19() {
        return disptktkjyskgnhknnndeymd19;
    }

    public void setDisptktkjyskgnhknnndeymd19(BizDate pDisptktkjyskgnhknnndeymd19) {
        disptktkjyskgnhknnndeymd19 = pDisptktkjyskgnhknnndeymd19;
    }

    private BizCurrency disptktkjyskgns19;

    public BizCurrency getDisptktkjyskgns19() {
        return disptktkjyskgns19;
    }

    public void setDisptktkjyskgns19(BizCurrency pDisptktkjyskgns19) {
        disptktkjyskgns19 = pDisptktkjyskgns19;
    }

    private BizDate disptktkjyskgnhknnndsymd29;

    public BizDate getDisptktkjyskgnhknnndsymd29() {
        return disptktkjyskgnhknnndsymd29;
    }

    public void setDisptktkjyskgnhknnndsymd29(BizDate pDisptktkjyskgnhknnndsymd29) {
        disptktkjyskgnhknnndsymd29 = pDisptktkjyskgnhknnndsymd29;
    }

    private BizDate disptktkjyskgnhknnndeymd29;

    public BizDate getDisptktkjyskgnhknnndeymd29() {
        return disptktkjyskgnhknnndeymd29;
    }

    public void setDisptktkjyskgnhknnndeymd29(BizDate pDisptktkjyskgnhknnndeymd29) {
        disptktkjyskgnhknnndeymd29 = pDisptktkjyskgnhknnndeymd29;
    }

    private BizCurrency disptktkjyskgns29;

    public BizCurrency getDisptktkjyskgns29() {
        return disptktkjyskgns29;
    }

    public void setDisptktkjyskgns29(BizCurrency pDisptktkjyskgns29) {
        disptktkjyskgns29 = pDisptktkjyskgns29;
    }

    private BizDate disptktkjyskgnhknnndsymd39;

    public BizDate getDisptktkjyskgnhknnndsymd39() {
        return disptktkjyskgnhknnndsymd39;
    }

    public void setDisptktkjyskgnhknnndsymd39(BizDate pDisptktkjyskgnhknnndsymd39) {
        disptktkjyskgnhknnndsymd39 = pDisptktkjyskgnhknnndsymd39;
    }

    private BizDate disptktkjyskgnhknnndeymd39;

    public BizDate getDisptktkjyskgnhknnndeymd39() {
        return disptktkjyskgnhknnndeymd39;
    }

    public void setDisptktkjyskgnhknnndeymd39(BizDate pDisptktkjyskgnhknnndeymd39) {
        disptktkjyskgnhknnndeymd39 = pDisptktkjyskgnhknnndeymd39;
    }

    private BizCurrency disptktkjyskgns39;

    public BizCurrency getDisptktkjyskgns39() {
        return disptktkjyskgns39;
    }

    public void setDisptktkjyskgns39(BizCurrency pDisptktkjyskgns39) {
        disptktkjyskgns39 = pDisptktkjyskgns39;
    }

    private BizDate disptktkjyskgnhknnndsymd49;

    public BizDate getDisptktkjyskgnhknnndsymd49() {
        return disptktkjyskgnhknnndsymd49;
    }

    public void setDisptktkjyskgnhknnndsymd49(BizDate pDisptktkjyskgnhknnndsymd49) {
        disptktkjyskgnhknnndsymd49 = pDisptktkjyskgnhknnndsymd49;
    }

    private BizDate disptktkjyskgnhknnndeymd49;

    public BizDate getDisptktkjyskgnhknnndeymd49() {
        return disptktkjyskgnhknnndeymd49;
    }

    public void setDisptktkjyskgnhknnndeymd49(BizDate pDisptktkjyskgnhknnndeymd49) {
        disptktkjyskgnhknnndeymd49 = pDisptktkjyskgnhknnndeymd49;
    }

    private BizCurrency disptktkjyskgns49;

    public BizCurrency getDisptktkjyskgns49() {
        return disptktkjyskgns49;
    }

    public void setDisptktkjyskgns49(BizCurrency pDisptktkjyskgns49) {
        disptktkjyskgns49 = pDisptktkjyskgns49;
    }

    private BizDate disptktkjyskgnhknnndsymd59;

    public BizDate getDisptktkjyskgnhknnndsymd59() {
        return disptktkjyskgnhknnndsymd59;
    }

    public void setDisptktkjyskgnhknnndsymd59(BizDate pDisptktkjyskgnhknnndsymd59) {
        disptktkjyskgnhknnndsymd59 = pDisptktkjyskgnhknnndsymd59;
    }

    private BizDate disptktkjyskgnhknnndeymd59;

    public BizDate getDisptktkjyskgnhknnndeymd59() {
        return disptktkjyskgnhknnndeymd59;
    }

    public void setDisptktkjyskgnhknnndeymd59(BizDate pDisptktkjyskgnhknnndeymd59) {
        disptktkjyskgnhknnndeymd59 = pDisptktkjyskgnhknnndeymd59;
    }

    private BizCurrency disptktkjyskgns59;

    public BizCurrency getDisptktkjyskgns59() {
        return disptktkjyskgns59;
    }

    public void setDisptktkjyskgns59(BizCurrency pDisptktkjyskgns59) {
        disptktkjyskgns59 = pDisptktkjyskgns59;
    }

    private C_Tkjyhyouten disptktkjyhyouten9;

    public C_Tkjyhyouten getDisptktkjyhyouten9() {
        return disptktkjyhyouten9;
    }

    public void setDisptktkjyhyouten9(C_Tkjyhyouten pDisptktkjyhyouten9) {
        disptktkjyhyouten9 = pDisptktkjyhyouten9;
    }

    private BizCurrency disptktkjyp9;

    public BizCurrency getDisptktkjyp9() {
        return disptktkjyp9;
    }

    public void setDisptktkjyp9(BizCurrency pDisptktkjyp9) {
        disptktkjyp9 = pDisptktkjyp9;
    }

    private String disptkhtnpbuicd19;

    public String getDisptkhtnpbuicd19() {
        return disptkhtnpbuicd19;
    }

    public void setDisptkhtnpbuicd19(String pDisptkhtnpbuicd19) {
        disptkhtnpbuicd19 = pDisptkhtnpbuicd19;
    }

    private String disptkhtnpbuinm19;

    public String getDisptkhtnpbuinm19() {
        return disptkhtnpbuinm19;
    }

    public void setDisptkhtnpbuinm19(String pDisptkhtnpbuinm19) {
        disptkhtnpbuinm19 = pDisptkhtnpbuinm19;
    }

    private C_Htnpkkn disptkhtnpkkn19;

    public C_Htnpkkn getDisptkhtnpkkn19() {
        return disptkhtnpkkn19;
    }

    public void setDisptkhtnpkkn19(C_Htnpkkn pDisptkhtnpkkn19) {
        disptkhtnpkkn19 = pDisptkhtnpkkn19;
    }

    private String disptkhtnpbuicd29;

    public String getDisptkhtnpbuicd29() {
        return disptkhtnpbuicd29;
    }

    public void setDisptkhtnpbuicd29(String pDisptkhtnpbuicd29) {
        disptkhtnpbuicd29 = pDisptkhtnpbuicd29;
    }

    private String disptkhtnpbuinm29;

    public String getDisptkhtnpbuinm29() {
        return disptkhtnpbuinm29;
    }

    public void setDisptkhtnpbuinm29(String pDisptkhtnpbuinm29) {
        disptkhtnpbuinm29 = pDisptkhtnpbuinm29;
    }

    private C_Htnpkkn disptkhtnpkkn29;

    public C_Htnpkkn getDisptkhtnpkkn29() {
        return disptkhtnpkkn29;
    }

    public void setDisptkhtnpkkn29(C_Htnpkkn pDisptkhtnpkkn29) {
        disptkhtnpkkn29 = pDisptkhtnpkkn29;
    }

    private String disptkhtnpbuicd39;

    public String getDisptkhtnpbuicd39() {
        return disptkhtnpbuicd39;
    }

    public void setDisptkhtnpbuicd39(String pDisptkhtnpbuicd39) {
        disptkhtnpbuicd39 = pDisptkhtnpbuicd39;
    }

    private String disptkhtnpbuinm39;

    public String getDisptkhtnpbuinm39() {
        return disptkhtnpbuinm39;
    }

    public void setDisptkhtnpbuinm39(String pDisptkhtnpbuinm39) {
        disptkhtnpbuinm39 = pDisptkhtnpbuinm39;
    }

    private C_Htnpkkn disptkhtnpkkn39;

    public C_Htnpkkn getDisptkhtnpkkn39() {
        return disptkhtnpkkn39;
    }

    public void setDisptkhtnpkkn39(C_Htnpkkn pDisptkhtnpkkn39) {
        disptkhtnpkkn39 = pDisptkhtnpkkn39;
    }

    private String disptkhtnpbuicd49;

    public String getDisptkhtnpbuicd49() {
        return disptkhtnpbuicd49;
    }

    public void setDisptkhtnpbuicd49(String pDisptkhtnpbuicd49) {
        disptkhtnpbuicd49 = pDisptkhtnpbuicd49;
    }

    private String disptkhtnpbuinm49;

    public String getDisptkhtnpbuinm49() {
        return disptkhtnpbuinm49;
    }

    public void setDisptkhtnpbuinm49(String pDisptkhtnpbuinm49) {
        disptkhtnpbuinm49 = pDisptkhtnpbuinm49;
    }

    private C_Htnpkkn disptkhtnpkkn49;

    public C_Htnpkkn getDisptkhtnpkkn49() {
        return disptkhtnpkkn49;
    }

    public void setDisptkhtnpkkn49(C_Htnpkkn pDisptkhtnpkkn49) {
        disptkhtnpkkn49 = pDisptkhtnpkkn49;
    }

    private C_TokkoudosghtnpKbn disptktokkoudosghtnpkbn9;

    public C_TokkoudosghtnpKbn getDisptktokkoudosghtnpkbn9() {
        return disptktokkoudosghtnpkbn9;
    }

    public void setDisptktokkoudosghtnpkbn9(C_TokkoudosghtnpKbn pDisptktokkoudosghtnpkbn9) {
        disptktokkoudosghtnpkbn9 = pDisptktokkoudosghtnpkbn9;
    }

    private BizDate disptkkouryokuhasseiymd9;

    public BizDate getDisptkkouryokuhasseiymd9() {
        return disptkkouryokuhasseiymd9;
    }

    public void setDisptkkouryokuhasseiymd9(BizDate pDisptkkouryokuhasseiymd9) {
        disptkkouryokuhasseiymd9 = pDisptkkouryokuhasseiymd9;
    }

    private String disptksyouhnnm10;

    public String getDisptksyouhnnm10() {
        return disptksyouhnnm10;
    }

    public void setDisptksyouhnnm10(String pDisptksyouhnnm10) {
        disptksyouhnnm10 = pDisptksyouhnnm10;
    }

    private C_KataKbn disptokuyakukatakbn10;

    public C_KataKbn getDisptokuyakukatakbn10() {
        return disptokuyakukatakbn10;
    }

    public void setDisptokuyakukatakbn10(C_KataKbn pDisptokuyakukatakbn10) {
        disptokuyakukatakbn10 = pDisptokuyakukatakbn10;
    }

    private C_KyhgndkataKbn disptkkyhgndkatakbn10;

    public C_KyhgndkataKbn getDisptkkyhgndkatakbn10() {
        return disptkkyhgndkatakbn10;
    }

    public void setDisptkkyhgndkatakbn10(C_KyhgndkataKbn pDisptkkyhgndkatakbn10) {
        disptkkyhgndkatakbn10 = pDisptkkyhgndkatakbn10;
    }

    private Integer disptkhhknnen10;

    public Integer getDisptkhhknnen10() {
        return disptkhhknnen10;
    }

    public void setDisptkhhknnen10(Integer pDisptkhhknnen10) {
        disptkhhknnen10 = pDisptkhhknnen10;
    }

    private BizDate disptkkykymd10;

    public BizDate getDisptkkykymd10() {
        return disptkkykymd10;
    }

    public void setDisptkkykymd10(BizDate pDisptkkykymd10) {
        disptkkykymd10 = pDisptkkykymd10;
    }

    private BizDate disptksknnkaisiymd10;

    public BizDate getDisptksknnkaisiymd10() {
        return disptksknnkaisiymd10;
    }

    public void setDisptksknnkaisiymd10(BizDate pDisptksknnkaisiymd10) {
        disptksknnkaisiymd10 = pDisptksknnkaisiymd10;
    }

    private BizDate disptkgansknnkaisiymd10;

    public BizDate getDisptkgansknnkaisiymd10() {
        return disptkgansknnkaisiymd10;
    }

    public void setDisptkgansknnkaisiymd10(BizDate pDisptkgansknnkaisiymd10) {
        disptkgansknnkaisiymd10 = pDisptkgansknnkaisiymd10;
    }

    private BizDate disptkhksknnkaisiymd10;

    public BizDate getDisptkhksknnkaisiymd10() {
        return disptkhksknnkaisiymd10;
    }

    public void setDisptkhksknnkaisiymd10(BizDate pDisptkhksknnkaisiymd10) {
        disptkhksknnkaisiymd10 = pDisptkhksknnkaisiymd10;
    }

    private BizDate disptkhkgansknnkaisiymd10;

    public BizDate getDisptkhkgansknnkaisiymd10() {
        return disptkhkgansknnkaisiymd10;
    }

    public void setDisptkhkgansknnkaisiymd10(BizDate pDisptkhkgansknnkaisiymd10) {
        disptkhkgansknnkaisiymd10 = pDisptkhkgansknnkaisiymd10;
    }

    private Integer disptkhknkkn10;

    public Integer getDisptkhknkkn10() {
        return disptkhknkkn10;
    }

    public void setDisptkhknkkn10(Integer pDisptkhknkkn10) {
        disptkhknkkn10 = pDisptkhknkkn10;
    }

    private C_HknkknsmnKbn disptkhknkknsmnkbn10;

    public C_HknkknsmnKbn getDisptkhknkknsmnkbn10() {
        return disptkhknkknsmnkbn10;
    }

    public void setDisptkhknkknsmnkbn10(C_HknkknsmnKbn pDisptkhknkknsmnkbn10) {
        disptkhknkknsmnkbn10 = pDisptkhknkknsmnkbn10;
    }

    private Integer disptkhrkkkn10;

    public Integer getDisptkhrkkkn10() {
        return disptkhrkkkn10;
    }

    public void setDisptkhrkkkn10(Integer pDisptkhrkkkn10) {
        disptkhrkkkn10 = pDisptkhrkkkn10;
    }

    private C_HrkkknsmnKbn disptkhrkkknsmnkbn10;

    public C_HrkkknsmnKbn getDisptkhrkkknsmnkbn10() {
        return disptkhrkkknsmnkbn10;
    }

    public void setDisptkhrkkknsmnkbn10(C_HrkkknsmnKbn pDisptkhrkkknsmnkbn10) {
        disptkhrkkknsmnkbn10 = pDisptkhrkkknsmnkbn10;
    }

    private C_KihonssyuruiKbn disptkkihonssyuruikbn10;

    public C_KihonssyuruiKbn getDisptkkihonssyuruikbn10() {
        return disptkkihonssyuruikbn10;
    }

    public void setDisptkkihonssyuruikbn10(C_KihonssyuruiKbn pDisptkkihonssyuruikbn10) {
        disptkkihonssyuruikbn10 = pDisptkkihonssyuruikbn10;
    }

    private BizCurrency disptkkihons10;

    public BizCurrency getDisptkkihons10() {
        return disptkkihons10;
    }

    public void setDisptkkihons10(BizCurrency pDisptkkihons10) {
        disptkkihons10 = pDisptkkihons10;
    }

    private BizCurrency disptktsnshrgndgk10;

    public BizCurrency getDisptktsnshrgndgk10() {
        return disptktsnshrgndgk10;
    }

    public void setDisptktsnshrgndgk10(BizCurrency pDisptktsnshrgndgk10) {
        disptktsnshrgndgk10 = pDisptktsnshrgndgk10;
    }

    private BizCurrency disptkp10;

    public BizCurrency getDisptkp10() {
        return disptkp10;
    }

    public void setDisptkp10(BizCurrency pDisptkp10) {
        disptkp10 = pDisptkp10;
    }

    private BizCurrency disptknextkosgop10;

    public BizCurrency getDisptknextkosgop10() {
        return disptknextkosgop10;
    }

    public void setDisptknextkosgop10(BizCurrency pDisptknextkosgop10) {
        disptknextkosgop10 = pDisptknextkosgop10;
    }

    private BizCurrency disptkgannyukyhntgk10;

    public BizCurrency getDisptkgannyukyhntgk10() {
        return disptkgannyukyhntgk10;
    }

    public void setDisptkgannyukyhntgk10(BizCurrency pDisptkgannyukyhntgk10) {
        disptkgannyukyhntgk10 = pDisptkgannyukyhntgk10;
    }

    private BizDate disptkshrskgnstartymd10;

    public BizDate getDisptkshrskgnstartymd10() {
        return disptkshrskgnstartymd10;
    }

    public void setDisptkshrskgnstartymd10(BizDate pDisptkshrskgnstartymd10) {
        disptkshrskgnstartymd10 = pDisptkshrskgnstartymd10;
    }

    private BizDate disptkshrskgnendymd10;

    public BizDate getDisptkshrskgnendymd10() {
        return disptkshrskgnendymd10;
    }

    public void setDisptkshrskgnendymd10(BizDate pDisptkshrskgnendymd10) {
        disptkshrskgnendymd10 = pDisptkshrskgnendymd10;
    }

    private BizCurrency disptkshrskgngos10;

    public BizCurrency getDisptkshrskgngos10() {
        return disptkshrskgngos10;
    }

    public void setDisptkshrskgngos10(BizCurrency pDisptkshrskgngos10) {
        disptkshrskgngos10 = pDisptkshrskgngos10;
    }

    private Integer disptkkrnbkkn10;

    public Integer getDisptkkrnbkkn10() {
        return disptkkrnbkkn10;
    }

    public void setDisptkkrnbkkn10(Integer pDisptkkrnbkkn10) {
        disptkkrnbkkn10 = pDisptkkrnbkkn10;
    }

    private BizDate disptknkshrstartymd10;

    public BizDate getDisptknkshrstartymd10() {
        return disptknkshrstartymd10;
    }

    public void setDisptknkshrstartymd10(BizDate pDisptknkshrstartymd10) {
        disptknkshrstartymd10 = pDisptknkshrstartymd10;
    }

    private C_Kknenkinsyu disptknenkinsyu10;

    public C_Kknenkinsyu getDisptknenkinsyu10() {
        return disptknenkinsyu10;
    }

    public void setDisptknenkinsyu10(C_Kknenkinsyu pDisptknenkinsyu10) {
        disptknenkinsyu10 = pDisptknenkinsyu10;
    }

    private Integer disptknenkinkkn10;

    public Integer getDisptknenkinkkn10() {
        return disptknenkinkkn10;
    }

    public void setDisptknenkinkkn10(Integer pDisptknenkinkkn10) {
        disptknenkinkkn10 = pDisptknenkinkkn10;
    }

    private BizCurrency disptknknengk10;

    public BizCurrency getDisptknknengk10() {
        return disptknknengk10;
    }

    public void setDisptknknengk10(BizCurrency pDisptknknengk10) {
        disptknknengk10 = pDisptknknengk10;
    }

    private C_Bnshrkaisuu disptkbnshrkaisuu10;

    public C_Bnshrkaisuu getDisptkbnshrkaisuu10() {
        return disptkbnshrkaisuu10;
    }

    public void setDisptkbnshrkaisuu10(C_Bnshrkaisuu pDisptkbnshrkaisuu10) {
        disptkbnshrkaisuu10 = pDisptkbnshrkaisuu10;
    }

    private C_Tkjyskgnkkn disptktkjyskgnkkn10;

    public C_Tkjyskgnkkn getDisptktkjyskgnkkn10() {
        return disptktkjyskgnkkn10;
    }

    public void setDisptktkjyskgnkkn10(C_Tkjyskgnkkn pDisptktkjyskgnkkn10) {
        disptktkjyskgnkkn10 = pDisptktkjyskgnkkn10;
    }

    private BizDate disptktkjyskgnhknnndsymd110;

    public BizDate getDisptktkjyskgnhknnndsymd110() {
        return disptktkjyskgnhknnndsymd110;
    }

    public void setDisptktkjyskgnhknnndsymd110(BizDate pDisptktkjyskgnhknnndsymd110) {
        disptktkjyskgnhknnndsymd110 = pDisptktkjyskgnhknnndsymd110;
    }

    private BizDate disptktkjyskgnhknnndeymd110;

    public BizDate getDisptktkjyskgnhknnndeymd110() {
        return disptktkjyskgnhknnndeymd110;
    }

    public void setDisptktkjyskgnhknnndeymd110(BizDate pDisptktkjyskgnhknnndeymd110) {
        disptktkjyskgnhknnndeymd110 = pDisptktkjyskgnhknnndeymd110;
    }

    private BizCurrency disptktkjyskgns110;

    public BizCurrency getDisptktkjyskgns110() {
        return disptktkjyskgns110;
    }

    public void setDisptktkjyskgns110(BizCurrency pDisptktkjyskgns110) {
        disptktkjyskgns110 = pDisptktkjyskgns110;
    }

    private BizDate disptktkjyskgnhknnndsymd210;

    public BizDate getDisptktkjyskgnhknnndsymd210() {
        return disptktkjyskgnhknnndsymd210;
    }

    public void setDisptktkjyskgnhknnndsymd210(BizDate pDisptktkjyskgnhknnndsymd210) {
        disptktkjyskgnhknnndsymd210 = pDisptktkjyskgnhknnndsymd210;
    }

    private BizDate disptktkjyskgnhknnndeymd210;

    public BizDate getDisptktkjyskgnhknnndeymd210() {
        return disptktkjyskgnhknnndeymd210;
    }

    public void setDisptktkjyskgnhknnndeymd210(BizDate pDisptktkjyskgnhknnndeymd210) {
        disptktkjyskgnhknnndeymd210 = pDisptktkjyskgnhknnndeymd210;
    }

    private BizCurrency disptktkjyskgns210;

    public BizCurrency getDisptktkjyskgns210() {
        return disptktkjyskgns210;
    }

    public void setDisptktkjyskgns210(BizCurrency pDisptktkjyskgns210) {
        disptktkjyskgns210 = pDisptktkjyskgns210;
    }

    private BizDate disptktkjyskgnhknnndsymd310;

    public BizDate getDisptktkjyskgnhknnndsymd310() {
        return disptktkjyskgnhknnndsymd310;
    }

    public void setDisptktkjyskgnhknnndsymd310(BizDate pDisptktkjyskgnhknnndsymd310) {
        disptktkjyskgnhknnndsymd310 = pDisptktkjyskgnhknnndsymd310;
    }

    private BizDate disptktkjyskgnhknnndeymd310;

    public BizDate getDisptktkjyskgnhknnndeymd310() {
        return disptktkjyskgnhknnndeymd310;
    }

    public void setDisptktkjyskgnhknnndeymd310(BizDate pDisptktkjyskgnhknnndeymd310) {
        disptktkjyskgnhknnndeymd310 = pDisptktkjyskgnhknnndeymd310;
    }

    private BizCurrency disptktkjyskgns310;

    public BizCurrency getDisptktkjyskgns310() {
        return disptktkjyskgns310;
    }

    public void setDisptktkjyskgns310(BizCurrency pDisptktkjyskgns310) {
        disptktkjyskgns310 = pDisptktkjyskgns310;
    }

    private BizDate disptktkjyskgnhknnndsymd410;

    public BizDate getDisptktkjyskgnhknnndsymd410() {
        return disptktkjyskgnhknnndsymd410;
    }

    public void setDisptktkjyskgnhknnndsymd410(BizDate pDisptktkjyskgnhknnndsymd410) {
        disptktkjyskgnhknnndsymd410 = pDisptktkjyskgnhknnndsymd410;
    }

    private BizDate disptktkjyskgnhknnndeymd410;

    public BizDate getDisptktkjyskgnhknnndeymd410() {
        return disptktkjyskgnhknnndeymd410;
    }

    public void setDisptktkjyskgnhknnndeymd410(BizDate pDisptktkjyskgnhknnndeymd410) {
        disptktkjyskgnhknnndeymd410 = pDisptktkjyskgnhknnndeymd410;
    }

    private BizCurrency disptktkjyskgns410;

    public BizCurrency getDisptktkjyskgns410() {
        return disptktkjyskgns410;
    }

    public void setDisptktkjyskgns410(BizCurrency pDisptktkjyskgns410) {
        disptktkjyskgns410 = pDisptktkjyskgns410;
    }

    private BizDate disptktkjyskgnhknnndsymd510;

    public BizDate getDisptktkjyskgnhknnndsymd510() {
        return disptktkjyskgnhknnndsymd510;
    }

    public void setDisptktkjyskgnhknnndsymd510(BizDate pDisptktkjyskgnhknnndsymd510) {
        disptktkjyskgnhknnndsymd510 = pDisptktkjyskgnhknnndsymd510;
    }

    private BizDate disptktkjyskgnhknnndeymd510;

    public BizDate getDisptktkjyskgnhknnndeymd510() {
        return disptktkjyskgnhknnndeymd510;
    }

    public void setDisptktkjyskgnhknnndeymd510(BizDate pDisptktkjyskgnhknnndeymd510) {
        disptktkjyskgnhknnndeymd510 = pDisptktkjyskgnhknnndeymd510;
    }

    private BizCurrency disptktkjyskgns510;

    public BizCurrency getDisptktkjyskgns510() {
        return disptktkjyskgns510;
    }

    public void setDisptktkjyskgns510(BizCurrency pDisptktkjyskgns510) {
        disptktkjyskgns510 = pDisptktkjyskgns510;
    }

    private C_Tkjyhyouten disptktkjyhyouten10;

    public C_Tkjyhyouten getDisptktkjyhyouten10() {
        return disptktkjyhyouten10;
    }

    public void setDisptktkjyhyouten10(C_Tkjyhyouten pDisptktkjyhyouten10) {
        disptktkjyhyouten10 = pDisptktkjyhyouten10;
    }

    private BizCurrency disptktkjyp10;

    public BizCurrency getDisptktkjyp10() {
        return disptktkjyp10;
    }

    public void setDisptktkjyp10(BizCurrency pDisptktkjyp10) {
        disptktkjyp10 = pDisptktkjyp10;
    }

    private String disptkhtnpbuicd110;

    public String getDisptkhtnpbuicd110() {
        return disptkhtnpbuicd110;
    }

    public void setDisptkhtnpbuicd110(String pDisptkhtnpbuicd110) {
        disptkhtnpbuicd110 = pDisptkhtnpbuicd110;
    }

    private String disptkhtnpbuinm110;

    public String getDisptkhtnpbuinm110() {
        return disptkhtnpbuinm110;
    }

    public void setDisptkhtnpbuinm110(String pDisptkhtnpbuinm110) {
        disptkhtnpbuinm110 = pDisptkhtnpbuinm110;
    }

    private C_Htnpkkn disptkhtnpkkn110;

    public C_Htnpkkn getDisptkhtnpkkn110() {
        return disptkhtnpkkn110;
    }

    public void setDisptkhtnpkkn110(C_Htnpkkn pDisptkhtnpkkn110) {
        disptkhtnpkkn110 = pDisptkhtnpkkn110;
    }

    private String disptkhtnpbuicd210;

    public String getDisptkhtnpbuicd210() {
        return disptkhtnpbuicd210;
    }

    public void setDisptkhtnpbuicd210(String pDisptkhtnpbuicd210) {
        disptkhtnpbuicd210 = pDisptkhtnpbuicd210;
    }

    private String disptkhtnpbuinm210;

    public String getDisptkhtnpbuinm210() {
        return disptkhtnpbuinm210;
    }

    public void setDisptkhtnpbuinm210(String pDisptkhtnpbuinm210) {
        disptkhtnpbuinm210 = pDisptkhtnpbuinm210;
    }

    private C_Htnpkkn disptkhtnpkkn210;

    public C_Htnpkkn getDisptkhtnpkkn210() {
        return disptkhtnpkkn210;
    }

    public void setDisptkhtnpkkn210(C_Htnpkkn pDisptkhtnpkkn210) {
        disptkhtnpkkn210 = pDisptkhtnpkkn210;
    }

    private String disptkhtnpbuicd310;

    public String getDisptkhtnpbuicd310() {
        return disptkhtnpbuicd310;
    }

    public void setDisptkhtnpbuicd310(String pDisptkhtnpbuicd310) {
        disptkhtnpbuicd310 = pDisptkhtnpbuicd310;
    }

    private String disptkhtnpbuinm310;

    public String getDisptkhtnpbuinm310() {
        return disptkhtnpbuinm310;
    }

    public void setDisptkhtnpbuinm310(String pDisptkhtnpbuinm310) {
        disptkhtnpbuinm310 = pDisptkhtnpbuinm310;
    }

    private C_Htnpkkn disptkhtnpkkn310;

    public C_Htnpkkn getDisptkhtnpkkn310() {
        return disptkhtnpkkn310;
    }

    public void setDisptkhtnpkkn310(C_Htnpkkn pDisptkhtnpkkn310) {
        disptkhtnpkkn310 = pDisptkhtnpkkn310;
    }

    private String disptkhtnpbuicd410;

    public String getDisptkhtnpbuicd410() {
        return disptkhtnpbuicd410;
    }

    public void setDisptkhtnpbuicd410(String pDisptkhtnpbuicd410) {
        disptkhtnpbuicd410 = pDisptkhtnpbuicd410;
    }

    private String disptkhtnpbuinm410;

    public String getDisptkhtnpbuinm410() {
        return disptkhtnpbuinm410;
    }

    public void setDisptkhtnpbuinm410(String pDisptkhtnpbuinm410) {
        disptkhtnpbuinm410 = pDisptkhtnpbuinm410;
    }

    private C_Htnpkkn disptkhtnpkkn410;

    public C_Htnpkkn getDisptkhtnpkkn410() {
        return disptkhtnpkkn410;
    }

    public void setDisptkhtnpkkn410(C_Htnpkkn pDisptkhtnpkkn410) {
        disptkhtnpkkn410 = pDisptkhtnpkkn410;
    }

    private C_TokkoudosghtnpKbn disptktokkoudosghtnpkbn10;

    public C_TokkoudosghtnpKbn getDisptktokkoudosghtnpkbn10() {
        return disptktokkoudosghtnpkbn10;
    }

    public void setDisptktokkoudosghtnpkbn10(C_TokkoudosghtnpKbn pDisptktokkoudosghtnpkbn10) {
        disptktokkoudosghtnpkbn10 = pDisptktokkoudosghtnpkbn10;
    }

    private BizDate disptkkouryokuhasseiymd10;

    public BizDate getDisptkkouryokuhasseiymd10() {
        return disptkkouryokuhasseiymd10;
    }

    public void setDisptkkouryokuhasseiymd10(BizDate pDisptkkouryokuhasseiymd10) {
        disptkkouryokuhasseiymd10 = pDisptkkouryokuhasseiymd10;
    }

    private C_PmnjtkKbn pmnjtkkbn;

    public C_PmnjtkKbn getPmnjtkkbn() {
        return pmnjtkkbn;
    }

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {
        pmnjtkkbn = pPmnjtkkbn;
    }

    private BizDate pmnjtkkykymd;

    public BizDate getPmnjtkkykymd() {
        return pmnjtkkykymd;
    }

    @Trim("both")
    public void setPmnjtkkykymd(BizDate pPmnjtkkykymd) {
        pmnjtkkykymd = pPmnjtkkykymd;
    }

    private BizDate pmnjtksknnkaisiymd;

    public BizDate getPmnjtksknnkaisiymd() {
        return pmnjtksknnkaisiymd;
    }

    @Trim("both")
    public void setPmnjtksknnkaisiymd(BizDate pPmnjtksknnkaisiymd) {
        pmnjtksknnkaisiymd = pPmnjtksknnkaisiymd;
    }

    private BizDate pmnjtkgansknnkaisiymd;

    public BizDate getPmnjtkgansknnkaisiymd() {
        return pmnjtkgansknnkaisiymd;
    }

    @Trim("both")
    public void setPmnjtkgansknnkaisiymd(BizDate pPmnjtkgansknnkaisiymd) {
        pmnjtkgansknnkaisiymd = pPmnjtkgansknnkaisiymd;
    }

    private BizDate pmhktsknnkaisiymd;

    public BizDate getPmhktsknnkaisiymd() {
        return pmhktsknnkaisiymd;
    }

    @Trim("both")
    public void setPmhktsknnkaisiymd(BizDate pPmhktsknnkaisiymd) {
        pmhktsknnkaisiymd = pPmhktsknnkaisiymd;
    }

    private BizDate pmnjhktgansknnkaisiymd;

    public BizDate getPmnjhktgansknnkaisiymd() {
        return pmnjhktgansknnkaisiymd;
    }

    @Trim("both")
    public void setPmnjhktgansknnkaisiymd(BizDate pPmnjhktgansknnkaisiymd) {
        pmnjhktgansknnkaisiymd = pPmnjhktgansknnkaisiymd;
    }

    private String pmnjtkhtnpbuicd1;

    public String getPmnjtkhtnpbuicd1() {
        return pmnjtkhtnpbuicd1;
    }

    public void setPmnjtkhtnpbuicd1(String pPmnjtkhtnpbuicd1) {
        pmnjtkhtnpbuicd1 = pPmnjtkhtnpbuicd1;
    }

    private String pmnjtkhtnpbuinm1;

    public String getPmnjtkhtnpbuinm1() {
        return pmnjtkhtnpbuinm1;
    }

    public void setPmnjtkhtnpbuinm1(String pPmnjtkhtnpbuinm1) {
        pmnjtkhtnpbuinm1 = pPmnjtkhtnpbuinm1;
    }

    private C_Htnpkkn pmnjtkhtnpkkn1;

    public C_Htnpkkn getPmnjtkhtnpkkn1() {
        return pmnjtkhtnpkkn1;
    }

    public void setPmnjtkhtnpkkn1(C_Htnpkkn pPmnjtkhtnpkkn1) {
        pmnjtkhtnpkkn1 = pPmnjtkhtnpkkn1;
    }

    private String pmnjtkhtnpbuicd2;

    public String getPmnjtkhtnpbuicd2() {
        return pmnjtkhtnpbuicd2;
    }

    public void setPmnjtkhtnpbuicd2(String pPmnjtkhtnpbuicd2) {
        pmnjtkhtnpbuicd2 = pPmnjtkhtnpbuicd2;
    }

    private String pmnjtkhtnpbuinm2;

    public String getPmnjtkhtnpbuinm2() {
        return pmnjtkhtnpbuinm2;
    }

    public void setPmnjtkhtnpbuinm2(String pPmnjtkhtnpbuinm2) {
        pmnjtkhtnpbuinm2 = pPmnjtkhtnpbuinm2;
    }

    private C_Htnpkkn pmnjtkhtnpkkn2;

    public C_Htnpkkn getPmnjtkhtnpkkn2() {
        return pmnjtkhtnpkkn2;
    }

    public void setPmnjtkhtnpkkn2(C_Htnpkkn pPmnjtkhtnpkkn2) {
        pmnjtkhtnpkkn2 = pPmnjtkhtnpkkn2;
    }

    private String pmnjtkhtnpbuicd3;

    public String getPmnjtkhtnpbuicd3() {
        return pmnjtkhtnpbuicd3;
    }

    public void setPmnjtkhtnpbuicd3(String pPmnjtkhtnpbuicd3) {
        pmnjtkhtnpbuicd3 = pPmnjtkhtnpbuicd3;
    }

    private String pmnjtkhtnpbuinm3;

    public String getPmnjtkhtnpbuinm3() {
        return pmnjtkhtnpbuinm3;
    }

    public void setPmnjtkhtnpbuinm3(String pPmnjtkhtnpbuinm3) {
        pmnjtkhtnpbuinm3 = pPmnjtkhtnpbuinm3;
    }

    private C_Htnpkkn pmnjtkhtnpkkn3;

    public C_Htnpkkn getPmnjtkhtnpkkn3() {
        return pmnjtkhtnpkkn3;
    }

    public void setPmnjtkhtnpkkn3(C_Htnpkkn pPmnjtkhtnpkkn3) {
        pmnjtkhtnpkkn3 = pPmnjtkhtnpkkn3;
    }

    private String pmnjtkhtnpbuicd4;

    public String getPmnjtkhtnpbuicd4() {
        return pmnjtkhtnpbuicd4;
    }

    public void setPmnjtkhtnpbuicd4(String pPmnjtkhtnpbuicd4) {
        pmnjtkhtnpbuicd4 = pPmnjtkhtnpbuicd4;
    }

    private String pmnjtkhtnpbuinm4;

    public String getPmnjtkhtnpbuinm4() {
        return pmnjtkhtnpbuinm4;
    }

    public void setPmnjtkhtnpbuinm4(String pPmnjtkhtnpbuinm4) {
        pmnjtkhtnpbuinm4 = pPmnjtkhtnpbuinm4;
    }

    private C_Htnpkkn pmnjtkhtnpkkn4;

    public C_Htnpkkn getPmnjtkhtnpkkn4() {
        return pmnjtkhtnpkkn4;
    }

    public void setPmnjtkhtnpkkn4(C_Htnpkkn pPmnjtkhtnpkkn4) {
        pmnjtkhtnpkkn4 = pPmnjtkhtnpkkn4;
    }

    private C_TokkoudosghtnpKbn pmnjtokkoudosghtnpkbn;

    public C_TokkoudosghtnpKbn getPmnjtokkoudosghtnpkbn() {
        return pmnjtokkoudosghtnpkbn;
    }

    public void setPmnjtokkoudosghtnpkbn(C_TokkoudosghtnpKbn pPmnjtokkoudosghtnpkbn) {
        pmnjtokkoudosghtnpkbn = pPmnjtokkoudosghtnpkbn;
    }

    private String disptkhukainfo;

    public String getDisptkhukainfo() {
        return disptkhukainfo;
    }

    public void setDisptkhukainfo(String pDisptkhukainfo) {
        disptkhukainfo = pDisptkhukainfo;
    }

    private C_FstphrkkeiroKbn fstphrkkeirokbn;

    public C_FstphrkkeiroKbn getFstphrkkeirokbn() {
        return fstphrkkeirokbn;
    }

    public void setFstphrkkeirokbn(C_FstphrkkeiroKbn pFstphrkkeirokbn) {
        fstphrkkeirokbn = pFstphrkkeirokbn;
    }

    private C_Hrkkaisuu hrkkaisuu;

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private String viewharaikomiinfodummy;

    public String getViewharaikomiinfodummy() {
        return viewharaikomiinfodummy;
    }

    public void setViewharaikomiinfodummy(String pViewharaikomiinfodummy) {
        viewharaikomiinfodummy = pViewharaikomiinfodummy;
    }

    @ValidDateYm
    private BizDateYM jkipjytym;

    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    @ValidDate
    private BizDate tokusinendymd;

    public BizDate getTokusinendymd() {
        return tokusinendymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTokusinendymd(BizDate pTokusinendymd) {
        tokusinendymd = pTokusinendymd;
    }

    private BizCurrency hrkp;

    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
    }

    private BizCurrency kihrkp;

    public BizCurrency getKihrkp() {
        return kihrkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihrkp(BizCurrency pKihrkp) {
        kihrkp = pKihrkp;
    }

    private BizCurrency nextkosgohrkp;

    public BizCurrency getNextkosgohrkp() {
        return nextkosgohrkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNextkosgohrkp(BizCurrency pNextkosgohrkp) {
        nextkosgohrkp = pNextkosgohrkp;
    }

    private String hrkinfobankcd;

    public String getHrkinfobankcd() {
        return hrkinfobankcd;
    }

    public void setHrkinfobankcd(String pHrkinfobankcd) {
        hrkinfobankcd = pHrkinfobankcd;
    }

    private String hrkinfobanknmkj;

    public String getHrkinfobanknmkj() {
        return hrkinfobanknmkj;
    }

    public void setHrkinfobanknmkj(String pHrkinfobanknmkj) {
        hrkinfobanknmkj = pHrkinfobanknmkj;
    }

    private String hrkinfositencd;

    public String getHrkinfositencd() {
        return hrkinfositencd;
    }

    public void setHrkinfositencd(String pHrkinfositencd) {
        hrkinfositencd = pHrkinfositencd;
    }

    private String hrkinfositennmkj;

    public String getHrkinfositennmkj() {
        return hrkinfositennmkj;
    }

    public void setHrkinfositennmkj(String pHrkinfositennmkj) {
        hrkinfositennmkj = pHrkinfositennmkj;
    }

    private C_YokinKbn hrkinfoyokinkbn;

    public C_YokinKbn getHrkinfoyokinkbn() {
        return hrkinfoyokinkbn;
    }

    public void setHrkinfoyokinkbn(C_YokinKbn pHrkinfoyokinkbn) {
        hrkinfoyokinkbn = pHrkinfoyokinkbn;
    }

    private String hrkinfokouzano;

    public String getHrkinfokouzano() {
        return hrkinfokouzano;
    }

    public void setHrkinfokouzano(String pHrkinfokouzano) {
        hrkinfokouzano = pHrkinfokouzano;
    }

    private C_SinkeizkKbn hrkinfosinkeizkkbn;

    public C_SinkeizkKbn getHrkinfosinkeizkkbn() {
        return hrkinfosinkeizkkbn;
    }

    public void setHrkinfosinkeizkkbn(C_SinkeizkKbn pHrkinfosinkeizkkbn) {
        hrkinfosinkeizkkbn = pHrkinfosinkeizkkbn;
    }

    private String hrkinfokzmeiginmkn;

    public String getHrkinfokzmeiginmkn() {
        return hrkinfokzmeiginmkn;
    }

    public void setHrkinfokzmeiginmkn(String pHrkinfokzmeiginmkn) {
        hrkinfokzmeiginmkn = pHrkinfokzmeiginmkn;
    }

    private C_Syuudaikocd hrkinfosyuudaikocd;

    public C_Syuudaikocd getHrkinfosyuudaikocd() {
        return hrkinfosyuudaikocd;
    }

    public void setHrkinfosyuudaikocd(C_Syuudaikocd pHrkinfosyuudaikocd) {
        hrkinfosyuudaikocd = pHrkinfosyuudaikocd;
    }

    private String hrkinfocreditcardno1;

    public String getHrkinfocreditcardno1() {
        return hrkinfocreditcardno1;
    }

    public void setHrkinfocreditcardno1(String pHrkinfocreditcardno1) {
        hrkinfocreditcardno1 = pHrkinfocreditcardno1;
    }

    private String hrkinfocreditcardno2;

    public String getHrkinfocreditcardno2() {
        return hrkinfocreditcardno2;
    }

    public void setHrkinfocreditcardno2(String pHrkinfocreditcardno2) {
        hrkinfocreditcardno2 = pHrkinfocreditcardno2;
    }

    private String hrkinfocreditcardno3;

    public String getHrkinfocreditcardno3() {
        return hrkinfocreditcardno3;
    }

    public void setHrkinfocreditcardno3(String pHrkinfocreditcardno3) {
        hrkinfocreditcardno3 = pHrkinfocreditcardno3;
    }

    private String hrkinfocreditcardno4;

    public String getHrkinfocreditcardno4() {
        return hrkinfocreditcardno4;
    }

    public void setHrkinfocreditcardno4(String pHrkinfocreditcardno4) {
        hrkinfocreditcardno4 = pHrkinfocreditcardno4;
    }

    private String hrkinfoykkigenmm;

    public String getHrkinfoykkigenmm() {
        return hrkinfoykkigenmm;
    }

    public void setHrkinfoykkigenmm(String pHrkinfoykkigenmm) {
        hrkinfoykkigenmm = pHrkinfoykkigenmm;
    }

    private String hrkinfoykkigenyy;

    public String getHrkinfoykkigenyy() {
        return hrkinfoykkigenyy;
    }

    public void setHrkinfoykkigenyy(String pHrkinfoykkigenyy) {
        hrkinfoykkigenyy = pHrkinfoykkigenyy;
    }

    private C_AuthorijkKbn authorijkkbn;

    public C_AuthorijkKbn getAuthorijkkbn() {
        return authorijkkbn;
    }

    public void setAuthorijkkbn(C_AuthorijkKbn pAuthorijkkbn) {
        authorijkkbn = pAuthorijkkbn;
    }

    @ValidDate
    private BizDate authorikanryoymd;

    public BizDate getAuthorikanryoymd() {
        return authorikanryoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAuthorikanryoymd(BizDate pAuthorikanryoymd) {
        authorikanryoymd = pAuthorikanryoymd;
    }

    private C_YuukoukakujkKbn yuukoukakujkkbn;

    public C_YuukoukakujkKbn getYuukoukakujkkbn() {
        return yuukoukakujkkbn;
    }

    public void setYuukoukakujkkbn(C_YuukoukakujkKbn pYuukoukakujkkbn) {
        yuukoukakujkkbn = pYuukoukakujkkbn;
    }

    private BizDate yukoukachkymd;

    public BizDate getYukoukachkymd() {
        return yukoukachkymd;
    }

    @Trim("both")
    public void setYukoukachkymd(BizDate pYukoukachkymd) {
        yukoukachkymd = pYukoukachkymd;
    }

    @ValidDate
    private BizDate kykhenkoymd;

    public BizDate getKykhenkoymd() {
        return kykhenkoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykhenkoymd(BizDate pKykhenkoymd) {
        kykhenkoymd = pKykhenkoymd;
    }

    private String dispsyusyouhnnm;

    public String getDispsyusyouhnnm() {
        return dispsyusyouhnnm;
    }

    public void setDispsyusyouhnnm(String pDispsyusyouhnnm) {
        dispsyusyouhnnm = pDispsyusyouhnnm;
    }

    private C_KykhnkKbn syuhnkkbn;

    public C_KykhnkKbn getSyuhnkkbn() {
        return syuhnkkbn;
    }

    public void setSyuhnkkbn(C_KykhnkKbn pSyuhnkkbn) {
        syuhnkkbn = pSyuhnkkbn;
    }

    private C_KihonssyuruiKbn dispsyukihonssyuruikbn;

    public C_KihonssyuruiKbn getDispsyukihonssyuruikbn() {
        return dispsyukihonssyuruikbn;
    }

    public void setDispsyukihonssyuruikbn(C_KihonssyuruiKbn pDispsyukihonssyuruikbn) {
        dispsyukihonssyuruikbn = pDispsyukihonssyuruikbn;
    }

    @CurrencyLenght(length=13)
    private BizCurrency newsyukihons;

    public BizCurrency getNewsyukihons() {
        return newsyukihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewsyukihons(BizCurrency pNewsyukihons) {
        newsyukihons = pNewsyukihons;
    }

    private BizCurrency syutsnshrgndgk;

    public BizCurrency getSyutsnshrgndgk() {
        return syutsnshrgndgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyutsnshrgndgk(BizCurrency pSyutsnshrgndgk) {
        syutsnshrgndgk = pSyutsnshrgndgk;
    }

    @CurrencyLenght(length=11)
    @PositiveNumberBizCalcble
    private BizCurrency dispsyukihonkyhgk;

    public BizCurrency getDispsyukihonkyhgk() {
        return dispsyukihonkyhgk;
    }

    public void setDispsyukihonkyhgk(BizCurrency pDispsyukihonkyhgk) {
        dispsyukihonkyhgk = pDispsyukihonkyhgk;
    }

    private BizCurrency newsyup;

    public BizCurrency getNewsyup() {
        return newsyup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewsyup(BizCurrency pNewsyup) {
        newsyup = pNewsyup;
    }

    private BizCurrency newsyunextkosgop;

    public BizCurrency getNewsyunextkosgop() {
        return newsyunextkosgop;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewsyunextkosgop(BizCurrency pNewsyunextkosgop) {
        newsyunextkosgop = pNewsyunextkosgop;
    }

    private String tokuyakusyouhnnm1;

    public String getTokuyakusyouhnnm1() {
        return tokuyakusyouhnnm1;
    }

    public void setTokuyakusyouhnnm1(String pTokuyakusyouhnnm1) {
        tokuyakusyouhnnm1 = pTokuyakusyouhnnm1;
    }

    private C_KykhnkKbn tkhnkkbn1;

    public C_KykhnkKbn getTkhnkkbn1() {
        return tkhnkkbn1;
    }

    public void setTkhnkkbn1(C_KykhnkKbn pTkhnkkbn1) {
        tkhnkkbn1 = pTkhnkkbn1;
    }

    private C_KihonssyuruiKbn tokuyakukihonssyuruikbn1;

    public C_KihonssyuruiKbn getTokuyakukihonssyuruikbn1() {
        return tokuyakukihonssyuruikbn1;
    }

    public void setTokuyakukihonssyuruikbn1(C_KihonssyuruiKbn pTokuyakukihonssyuruikbn1) {
        tokuyakukihonssyuruikbn1 = pTokuyakukihonssyuruikbn1;
    }

    @CurrencyLenght(length=13)
    private BizCurrency newtkkihons1;

    public BizCurrency getNewtkkihons1() {
        return newtkkihons1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtkkihons1(BizCurrency pNewtkkihons1) {
        newtkkihons1 = pNewtkkihons1;
    }

    private BizCurrency tktsnshrgndgk1;

    public BizCurrency getTktsnshrgndgk1() {
        return tktsnshrgndgk1;
    }

    public void setTktsnshrgndgk1(BizCurrency pTktsnshrgndgk1) {
        tktsnshrgndgk1 = pTktsnshrgndgk1;
    }

    private BizCurrency newdisptkp1;

    public BizCurrency getNewdisptkp1() {
        return newdisptkp1;
    }

    public void setNewdisptkp1(BizCurrency pNewdisptkp1) {
        newdisptkp1 = pNewdisptkp1;
    }

    private BizCurrency dispnewtknextkosgop1;

    public BizCurrency getDispnewtknextkosgop1() {
        return dispnewtknextkosgop1;
    }

    public void setDispnewtknextkosgop1(BizCurrency pDispnewtknextkosgop1) {
        dispnewtknextkosgop1 = pDispnewtknextkosgop1;
    }

    private String tokuyakusyouhnnm2;

    public String getTokuyakusyouhnnm2() {
        return tokuyakusyouhnnm2;
    }

    public void setTokuyakusyouhnnm2(String pTokuyakusyouhnnm2) {
        tokuyakusyouhnnm2 = pTokuyakusyouhnnm2;
    }

    private C_KykhnkKbn tkhnkkbn2;

    public C_KykhnkKbn getTkhnkkbn2() {
        return tkhnkkbn2;
    }

    public void setTkhnkkbn2(C_KykhnkKbn pTkhnkkbn2) {
        tkhnkkbn2 = pTkhnkkbn2;
    }

    private C_KihonssyuruiKbn tokuyakukihonssyuruikbn2;

    public C_KihonssyuruiKbn getTokuyakukihonssyuruikbn2() {
        return tokuyakukihonssyuruikbn2;
    }

    public void setTokuyakukihonssyuruikbn2(C_KihonssyuruiKbn pTokuyakukihonssyuruikbn2) {
        tokuyakukihonssyuruikbn2 = pTokuyakukihonssyuruikbn2;
    }

    @CurrencyLenght(length=13)
    private BizCurrency newtkkihons2;

    public BizCurrency getNewtkkihons2() {
        return newtkkihons2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtkkihons2(BizCurrency pNewtkkihons2) {
        newtkkihons2 = pNewtkkihons2;
    }

    private BizCurrency tktsnshrgndgk2;

    public BizCurrency getTktsnshrgndgk2() {
        return tktsnshrgndgk2;
    }

    public void setTktsnshrgndgk2(BizCurrency pTktsnshrgndgk2) {
        tktsnshrgndgk2 = pTktsnshrgndgk2;
    }

    private BizCurrency newdisptkp2;

    public BizCurrency getNewdisptkp2() {
        return newdisptkp2;
    }

    public void setNewdisptkp2(BizCurrency pNewdisptkp2) {
        newdisptkp2 = pNewdisptkp2;
    }

    private BizCurrency dispnewtknextkosgop2;

    public BizCurrency getDispnewtknextkosgop2() {
        return dispnewtknextkosgop2;
    }

    public void setDispnewtknextkosgop2(BizCurrency pDispnewtknextkosgop2) {
        dispnewtknextkosgop2 = pDispnewtknextkosgop2;
    }

    private String tokuyakusyouhnnm3;

    public String getTokuyakusyouhnnm3() {
        return tokuyakusyouhnnm3;
    }

    public void setTokuyakusyouhnnm3(String pTokuyakusyouhnnm3) {
        tokuyakusyouhnnm3 = pTokuyakusyouhnnm3;
    }

    private C_KykhnkKbn tkhnkkbn3;

    public C_KykhnkKbn getTkhnkkbn3() {
        return tkhnkkbn3;
    }

    public void setTkhnkkbn3(C_KykhnkKbn pTkhnkkbn3) {
        tkhnkkbn3 = pTkhnkkbn3;
    }

    private C_KihonssyuruiKbn tokuyakukihonssyuruikbn3;

    public C_KihonssyuruiKbn getTokuyakukihonssyuruikbn3() {
        return tokuyakukihonssyuruikbn3;
    }

    public void setTokuyakukihonssyuruikbn3(C_KihonssyuruiKbn pTokuyakukihonssyuruikbn3) {
        tokuyakukihonssyuruikbn3 = pTokuyakukihonssyuruikbn3;
    }

    @CurrencyLenght(length=13)
    private BizCurrency newtkkihons3;

    public BizCurrency getNewtkkihons3() {
        return newtkkihons3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtkkihons3(BizCurrency pNewtkkihons3) {
        newtkkihons3 = pNewtkkihons3;
    }

    private BizCurrency tktsnshrgndgk3;

    public BizCurrency getTktsnshrgndgk3() {
        return tktsnshrgndgk3;
    }

    public void setTktsnshrgndgk3(BizCurrency pTktsnshrgndgk3) {
        tktsnshrgndgk3 = pTktsnshrgndgk3;
    }

    private BizCurrency newdisptkp3;

    public BizCurrency getNewdisptkp3() {
        return newdisptkp3;
    }

    public void setNewdisptkp3(BizCurrency pNewdisptkp3) {
        newdisptkp3 = pNewdisptkp3;
    }

    private BizCurrency dispnewtknextkosgop3;

    public BizCurrency getDispnewtknextkosgop3() {
        return dispnewtknextkosgop3;
    }

    public void setDispnewtknextkosgop3(BizCurrency pDispnewtknextkosgop3) {
        dispnewtknextkosgop3 = pDispnewtknextkosgop3;
    }

    private String tokuyakusyouhnnm4;

    public String getTokuyakusyouhnnm4() {
        return tokuyakusyouhnnm4;
    }

    public void setTokuyakusyouhnnm4(String pTokuyakusyouhnnm4) {
        tokuyakusyouhnnm4 = pTokuyakusyouhnnm4;
    }

    private C_KykhnkKbn tkhnkkbn4;

    public C_KykhnkKbn getTkhnkkbn4() {
        return tkhnkkbn4;
    }

    public void setTkhnkkbn4(C_KykhnkKbn pTkhnkkbn4) {
        tkhnkkbn4 = pTkhnkkbn4;
    }

    private C_KihonssyuruiKbn tokuyakukihonssyuruikbn4;

    public C_KihonssyuruiKbn getTokuyakukihonssyuruikbn4() {
        return tokuyakukihonssyuruikbn4;
    }

    public void setTokuyakukihonssyuruikbn4(C_KihonssyuruiKbn pTokuyakukihonssyuruikbn4) {
        tokuyakukihonssyuruikbn4 = pTokuyakukihonssyuruikbn4;
    }

    @CurrencyLenght(length=13)
    private BizCurrency newtkkihons4;

    public BizCurrency getNewtkkihons4() {
        return newtkkihons4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtkkihons4(BizCurrency pNewtkkihons4) {
        newtkkihons4 = pNewtkkihons4;
    }

    private BizCurrency tktsnshrgndgk4;

    public BizCurrency getTktsnshrgndgk4() {
        return tktsnshrgndgk4;
    }

    public void setTktsnshrgndgk4(BizCurrency pTktsnshrgndgk4) {
        tktsnshrgndgk4 = pTktsnshrgndgk4;
    }

    private BizCurrency newdisptkp4;

    public BizCurrency getNewdisptkp4() {
        return newdisptkp4;
    }

    public void setNewdisptkp4(BizCurrency pNewdisptkp4) {
        newdisptkp4 = pNewdisptkp4;
    }

    private BizCurrency dispnewtknextkosgop4;

    public BizCurrency getDispnewtknextkosgop4() {
        return dispnewtknextkosgop4;
    }

    public void setDispnewtknextkosgop4(BizCurrency pDispnewtknextkosgop4) {
        dispnewtknextkosgop4 = pDispnewtknextkosgop4;
    }

    private String tokuyakusyouhnnm5;

    public String getTokuyakusyouhnnm5() {
        return tokuyakusyouhnnm5;
    }

    public void setTokuyakusyouhnnm5(String pTokuyakusyouhnnm5) {
        tokuyakusyouhnnm5 = pTokuyakusyouhnnm5;
    }

    private C_KykhnkKbn tkhnkkbn5;

    public C_KykhnkKbn getTkhnkkbn5() {
        return tkhnkkbn5;
    }

    public void setTkhnkkbn5(C_KykhnkKbn pTkhnkkbn5) {
        tkhnkkbn5 = pTkhnkkbn5;
    }

    private C_KihonssyuruiKbn tokuyakukihonssyuruikbn5;

    public C_KihonssyuruiKbn getTokuyakukihonssyuruikbn5() {
        return tokuyakukihonssyuruikbn5;
    }

    public void setTokuyakukihonssyuruikbn5(C_KihonssyuruiKbn pTokuyakukihonssyuruikbn5) {
        tokuyakukihonssyuruikbn5 = pTokuyakukihonssyuruikbn5;
    }

    @CurrencyLenght(length=13)
    private BizCurrency newtkkihons5;

    public BizCurrency getNewtkkihons5() {
        return newtkkihons5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtkkihons5(BizCurrency pNewtkkihons5) {
        newtkkihons5 = pNewtkkihons5;
    }

    private BizCurrency tktsnshrgndgk5;

    public BizCurrency getTktsnshrgndgk5() {
        return tktsnshrgndgk5;
    }

    public void setTktsnshrgndgk5(BizCurrency pTktsnshrgndgk5) {
        tktsnshrgndgk5 = pTktsnshrgndgk5;
    }

    private BizCurrency newdisptkp5;

    public BizCurrency getNewdisptkp5() {
        return newdisptkp5;
    }

    public void setNewdisptkp5(BizCurrency pNewdisptkp5) {
        newdisptkp5 = pNewdisptkp5;
    }

    private BizCurrency dispnewtknextkosgop5;

    public BizCurrency getDispnewtknextkosgop5() {
        return dispnewtknextkosgop5;
    }

    public void setDispnewtknextkosgop5(BizCurrency pDispnewtknextkosgop5) {
        dispnewtknextkosgop5 = pDispnewtknextkosgop5;
    }

    private String tokuyakusyouhnnm6;

    public String getTokuyakusyouhnnm6() {
        return tokuyakusyouhnnm6;
    }

    public void setTokuyakusyouhnnm6(String pTokuyakusyouhnnm6) {
        tokuyakusyouhnnm6 = pTokuyakusyouhnnm6;
    }

    private C_KykhnkKbn tkhnkkbn6;

    public C_KykhnkKbn getTkhnkkbn6() {
        return tkhnkkbn6;
    }

    public void setTkhnkkbn6(C_KykhnkKbn pTkhnkkbn6) {
        tkhnkkbn6 = pTkhnkkbn6;
    }

    private C_KihonssyuruiKbn tokuyakukihonssyuruikbn6;

    public C_KihonssyuruiKbn getTokuyakukihonssyuruikbn6() {
        return tokuyakukihonssyuruikbn6;
    }

    public void setTokuyakukihonssyuruikbn6(C_KihonssyuruiKbn pTokuyakukihonssyuruikbn6) {
        tokuyakukihonssyuruikbn6 = pTokuyakukihonssyuruikbn6;
    }

    @CurrencyLenght(length=13)
    private BizCurrency newtkkihons6;

    public BizCurrency getNewtkkihons6() {
        return newtkkihons6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtkkihons6(BizCurrency pNewtkkihons6) {
        newtkkihons6 = pNewtkkihons6;
    }

    private BizCurrency tktsnshrgndgk6;

    public BizCurrency getTktsnshrgndgk6() {
        return tktsnshrgndgk6;
    }

    public void setTktsnshrgndgk6(BizCurrency pTktsnshrgndgk6) {
        tktsnshrgndgk6 = pTktsnshrgndgk6;
    }

    private BizCurrency newdisptkp6;

    public BizCurrency getNewdisptkp6() {
        return newdisptkp6;
    }

    public void setNewdisptkp6(BizCurrency pNewdisptkp6) {
        newdisptkp6 = pNewdisptkp6;
    }

    private BizCurrency dispnewtknextkosgop6;

    public BizCurrency getDispnewtknextkosgop6() {
        return dispnewtknextkosgop6;
    }

    public void setDispnewtknextkosgop6(BizCurrency pDispnewtknextkosgop6) {
        dispnewtknextkosgop6 = pDispnewtknextkosgop6;
    }

    private String tokuyakusyouhnnm7;

    public String getTokuyakusyouhnnm7() {
        return tokuyakusyouhnnm7;
    }

    public void setTokuyakusyouhnnm7(String pTokuyakusyouhnnm7) {
        tokuyakusyouhnnm7 = pTokuyakusyouhnnm7;
    }

    private C_KykhnkKbn tkhnkkbn7;

    public C_KykhnkKbn getTkhnkkbn7() {
        return tkhnkkbn7;
    }

    public void setTkhnkkbn7(C_KykhnkKbn pTkhnkkbn7) {
        tkhnkkbn7 = pTkhnkkbn7;
    }

    private C_KihonssyuruiKbn tokuyakukihonssyuruikbn7;

    public C_KihonssyuruiKbn getTokuyakukihonssyuruikbn7() {
        return tokuyakukihonssyuruikbn7;
    }

    public void setTokuyakukihonssyuruikbn7(C_KihonssyuruiKbn pTokuyakukihonssyuruikbn7) {
        tokuyakukihonssyuruikbn7 = pTokuyakukihonssyuruikbn7;
    }

    @CurrencyLenght(length=13)
    private BizCurrency newtkkihons7;

    public BizCurrency getNewtkkihons7() {
        return newtkkihons7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtkkihons7(BizCurrency pNewtkkihons7) {
        newtkkihons7 = pNewtkkihons7;
    }

    private BizCurrency tktsnshrgndgk7;

    public BizCurrency getTktsnshrgndgk7() {
        return tktsnshrgndgk7;
    }

    public void setTktsnshrgndgk7(BizCurrency pTktsnshrgndgk7) {
        tktsnshrgndgk7 = pTktsnshrgndgk7;
    }

    private BizCurrency newdisptkp7;

    public BizCurrency getNewdisptkp7() {
        return newdisptkp7;
    }

    public void setNewdisptkp7(BizCurrency pNewdisptkp7) {
        newdisptkp7 = pNewdisptkp7;
    }

    private BizCurrency dispnewtknextkosgop7;

    public BizCurrency getDispnewtknextkosgop7() {
        return dispnewtknextkosgop7;
    }

    public void setDispnewtknextkosgop7(BizCurrency pDispnewtknextkosgop7) {
        dispnewtknextkosgop7 = pDispnewtknextkosgop7;
    }

    private String tokuyakusyouhnnm8;

    public String getTokuyakusyouhnnm8() {
        return tokuyakusyouhnnm8;
    }

    public void setTokuyakusyouhnnm8(String pTokuyakusyouhnnm8) {
        tokuyakusyouhnnm8 = pTokuyakusyouhnnm8;
    }

    private C_KykhnkKbn tkhnkkbn8;

    public C_KykhnkKbn getTkhnkkbn8() {
        return tkhnkkbn8;
    }

    public void setTkhnkkbn8(C_KykhnkKbn pTkhnkkbn8) {
        tkhnkkbn8 = pTkhnkkbn8;
    }

    private C_KihonssyuruiKbn tokuyakukihonssyuruikbn8;

    public C_KihonssyuruiKbn getTokuyakukihonssyuruikbn8() {
        return tokuyakukihonssyuruikbn8;
    }

    public void setTokuyakukihonssyuruikbn8(C_KihonssyuruiKbn pTokuyakukihonssyuruikbn8) {
        tokuyakukihonssyuruikbn8 = pTokuyakukihonssyuruikbn8;
    }

    @CurrencyLenght(length=13)
    private BizCurrency newtkkihons8;

    public BizCurrency getNewtkkihons8() {
        return newtkkihons8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtkkihons8(BizCurrency pNewtkkihons8) {
        newtkkihons8 = pNewtkkihons8;
    }

    private BizCurrency tktsnshrgndgk8;

    public BizCurrency getTktsnshrgndgk8() {
        return tktsnshrgndgk8;
    }

    public void setTktsnshrgndgk8(BizCurrency pTktsnshrgndgk8) {
        tktsnshrgndgk8 = pTktsnshrgndgk8;
    }

    private BizCurrency newdisptkp8;

    public BizCurrency getNewdisptkp8() {
        return newdisptkp8;
    }

    public void setNewdisptkp8(BizCurrency pNewdisptkp8) {
        newdisptkp8 = pNewdisptkp8;
    }

    private BizCurrency dispnewtknextkosgop8;

    public BizCurrency getDispnewtknextkosgop8() {
        return dispnewtknextkosgop8;
    }

    public void setDispnewtknextkosgop8(BizCurrency pDispnewtknextkosgop8) {
        dispnewtknextkosgop8 = pDispnewtknextkosgop8;
    }

    private String tokuyakusyouhnnm9;

    public String getTokuyakusyouhnnm9() {
        return tokuyakusyouhnnm9;
    }

    public void setTokuyakusyouhnnm9(String pTokuyakusyouhnnm9) {
        tokuyakusyouhnnm9 = pTokuyakusyouhnnm9;
    }

    private C_KykhnkKbn tkhnkkbn9;

    public C_KykhnkKbn getTkhnkkbn9() {
        return tkhnkkbn9;
    }

    public void setTkhnkkbn9(C_KykhnkKbn pTkhnkkbn9) {
        tkhnkkbn9 = pTkhnkkbn9;
    }

    private C_KihonssyuruiKbn tokuyakukihonssyuruikbn9;

    public C_KihonssyuruiKbn getTokuyakukihonssyuruikbn9() {
        return tokuyakukihonssyuruikbn9;
    }

    public void setTokuyakukihonssyuruikbn9(C_KihonssyuruiKbn pTokuyakukihonssyuruikbn9) {
        tokuyakukihonssyuruikbn9 = pTokuyakukihonssyuruikbn9;
    }

    @CurrencyLenght(length=13)
    private BizCurrency newtkkihons9;

    public BizCurrency getNewtkkihons9() {
        return newtkkihons9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtkkihons9(BizCurrency pNewtkkihons9) {
        newtkkihons9 = pNewtkkihons9;
    }

    private BizCurrency tktsnshrgndgk9;

    public BizCurrency getTktsnshrgndgk9() {
        return tktsnshrgndgk9;
    }

    public void setTktsnshrgndgk9(BizCurrency pTktsnshrgndgk9) {
        tktsnshrgndgk9 = pTktsnshrgndgk9;
    }

    private BizCurrency newdisptkp9;

    public BizCurrency getNewdisptkp9() {
        return newdisptkp9;
    }

    public void setNewdisptkp9(BizCurrency pNewdisptkp9) {
        newdisptkp9 = pNewdisptkp9;
    }

    private BizCurrency dispnewtknextkosgop9;

    public BizCurrency getDispnewtknextkosgop9() {
        return dispnewtknextkosgop9;
    }

    public void setDispnewtknextkosgop9(BizCurrency pDispnewtknextkosgop9) {
        dispnewtknextkosgop9 = pDispnewtknextkosgop9;
    }

    private String tokuyakusyouhnnm10;

    public String getTokuyakusyouhnnm10() {
        return tokuyakusyouhnnm10;
    }

    public void setTokuyakusyouhnnm10(String pTokuyakusyouhnnm10) {
        tokuyakusyouhnnm10 = pTokuyakusyouhnnm10;
    }

    private C_KykhnkKbn tkhnkkbn10;

    public C_KykhnkKbn getTkhnkkbn10() {
        return tkhnkkbn10;
    }

    public void setTkhnkkbn10(C_KykhnkKbn pTkhnkkbn10) {
        tkhnkkbn10 = pTkhnkkbn10;
    }

    private C_KihonssyuruiKbn tokuyakukihonssyuruikbn10;

    public C_KihonssyuruiKbn getTokuyakukihonssyuruikbn10() {
        return tokuyakukihonssyuruikbn10;
    }

    public void setTokuyakukihonssyuruikbn10(C_KihonssyuruiKbn pTokuyakukihonssyuruikbn10) {
        tokuyakukihonssyuruikbn10 = pTokuyakukihonssyuruikbn10;
    }

    @CurrencyLenght(length=13)
    private BizCurrency newtkkihons10;

    public BizCurrency getNewtkkihons10() {
        return newtkkihons10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtkkihons10(BizCurrency pNewtkkihons10) {
        newtkkihons10 = pNewtkkihons10;
    }

    private BizCurrency tktsnshrgndgk10;

    public BizCurrency getTktsnshrgndgk10() {
        return tktsnshrgndgk10;
    }

    public void setTktsnshrgndgk10(BizCurrency pTktsnshrgndgk10) {
        tktsnshrgndgk10 = pTktsnshrgndgk10;
    }

    private BizCurrency newdisptkp10;

    public BizCurrency getNewdisptkp10() {
        return newdisptkp10;
    }

    public void setNewdisptkp10(BizCurrency pNewdisptkp10) {
        newdisptkp10 = pNewdisptkp10;
    }

    private BizCurrency dispnewtknextkosgop10;

    public BizCurrency getDispnewtknextkosgop10() {
        return dispnewtknextkosgop10;
    }

    public void setDispnewtknextkosgop10(BizCurrency pDispnewtknextkosgop10) {
        dispnewtknextkosgop10 = pDispnewtknextkosgop10;
    }

    private C_PmnjtkKbn disptkpmnjtkkbn;

    public C_PmnjtkKbn getDisptkpmnjtkkbn() {
        return disptkpmnjtkkbn;
    }

    public void setDisptkpmnjtkkbn(C_PmnjtkKbn pDisptkpmnjtkkbn) {
        disptkpmnjtkkbn = pDisptkpmnjtkkbn;
    }

    private C_KykhnkKbn pmnjtkhnkkbn;

    public C_KykhnkKbn getPmnjtkhnkkbn() {
        return pmnjtkhnkkbn;
    }

    public void setPmnjtkhnkkbn(C_KykhnkKbn pPmnjtkhnkkbn) {
        pmnjtkhnkkbn = pPmnjtkhnkkbn;
    }

    private BizCurrency newhrkp;

    public BizCurrency getNewhrkp() {
        return newhrkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewhrkp(BizCurrency pNewhrkp) {
        newhrkp = pNewhrkp;
    }

    private BizCurrency newnextkosgohrkp;

    public BizCurrency getNewnextkosgohrkp() {
        return newnextkosgohrkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewnextkosgohrkp(BizCurrency pNewnextkosgohrkp) {
        newnextkosgohrkp = pNewnextkosgohrkp;
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

    private String viewharaikomiinfodummy1;

    public String getViewharaikomiinfodummy1() {
        return viewharaikomiinfodummy1;
    }

    public void setViewharaikomiinfodummy1(String pViewharaikomiinfodummy1) {
        viewharaikomiinfodummy1 = pViewharaikomiinfodummy1;
    }

    private BizCurrency shrgkkei;

    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
    }

    private BizCurrency shrgkgoukeikakunin;

    public BizCurrency getShrgkgoukeikakunin() {
        return shrgkgoukeikakunin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrgkgoukeikakunin(BizCurrency pShrgkgoukeikakunin) {
        shrgkgoukeikakunin = pShrgkgoukeikakunin;
    }

    private BizCurrency shrgkgoukeisyoukai;

    public BizCurrency getShrgkgoukeisyoukai() {
        return shrgkgoukeisyoukai;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrgkgoukeisyoukai(BizCurrency pShrgkgoukeisyoukai) {
        shrgkgoukeisyoukai = pShrgkgoukeisyoukai;
    }

    private BizCurrency ptumitatekin;

    public BizCurrency getPtumitatekin() {
        return ptumitatekin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPtumitatekin(BizCurrency pPtumitatekin) {
        ptumitatekin = pPtumitatekin;
    }

    private BizCurrency henkank;

    public BizCurrency getHenkank() {
        return henkank;
    }

    public void setHenkank(BizCurrency pHenkank) {
        henkank = pHenkank;
    }

    private BizCurrency kaiyakuhr;

    public BizCurrency getKaiyakuhr() {
        return kaiyakuhr;
    }

    public void setKaiyakuhr(BizCurrency pKaiyakuhr) {
        kaiyakuhr = pKaiyakuhr;
    }

    private BizCurrency mikeikap;

    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
    }

    private BizCurrency sonotaseisangk;

    public BizCurrency getSonotaseisangk() {
        return sonotaseisangk;
    }

    public void setSonotaseisangk(BizCurrency pSonotaseisangk) {
        sonotaseisangk = pSonotaseisangk;
    }

    private BizCurrency gensengk;

    public BizCurrency getGensengk() {
        return gensengk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGensengk(BizCurrency pGensengk) {
        gensengk = pGensengk;
    }

    private String viewsiharaidummy;

    public String getViewsiharaidummy() {
        return viewsiharaidummy;
    }

    public void setViewsiharaidummy(String pViewsiharaidummy) {
        viewsiharaidummy = pViewsiharaidummy;
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

    @ValidDate
    private BizDate dispkykhenkoymd;

    public BizDate getDispkykhenkoymd() {
        return dispkykhenkoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispkykhenkoymd(BizDate pDispkykhenkoymd) {
        dispkykhenkoymd = pDispkykhenkoymd;
    }

    private BizCurrency shrtienrsk;

    public BizCurrency getShrtienrsk() {
        return shrtienrsk;
    }

    public void setShrtienrsk(BizCurrency pShrtienrsk) {
        shrtienrsk = pShrtienrsk;
    }

    private BizCurrency dispkihrkp;

    public BizCurrency getDispkihrkp() {
        return dispkihrkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispkihrkp(BizCurrency pDispkihrkp) {
        dispkihrkp = pDispkihrkp;
    }

    private BizCurrency kaiykhmk;

    public BizCurrency getKaiykhmk() {
        return kaiykhmk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiykhmk(BizCurrency pKaiykhmk) {
        kaiykhmk = pKaiykhmk;
    }

    private BizCurrency tumitatekin;

    public BizCurrency getTumitatekin() {
        return tumitatekin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTumitatekin(BizCurrency pTumitatekin) {
        tumitatekin = pTumitatekin;
    }

    private BizCurrency sjkkktyouseigk;

    public BizCurrency getSjkkktyouseigk() {
        return sjkkktyouseigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSjkkktyouseigk(BizCurrency pSjkkktyouseigk) {
        sjkkktyouseigk = pSjkkktyouseigk;
    }

    private BizCurrency dispgensengk;

    public BizCurrency getDispgensengk() {
        return dispgensengk;
    }

    public void setDispgensengk(BizCurrency pDispgensengk) {
        dispgensengk = pDispgensengk;
    }

    private BizCurrency kztgk;

    public BizCurrency getKztgk() {
        return kztgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKztgk(BizCurrency pKztgk) {
        kztgk = pKztgk;
    }

    private BizCurrency disphtykeihi;

    public BizCurrency getDisphtykeihi() {
        return disphtykeihi;
    }

    public void setDisphtykeihi(BizCurrency pDisphtykeihi) {
        disphtykeihi = pDisphtykeihi;
    }

    private BizCurrency htykeihi;

    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtykeihi(BizCurrency pHtykeihi) {
        htykeihi = pHtykeihi;
    }

    private String disphtysyorui;

    public String getDisphtysyorui() {
        return disphtysyorui;
    }

    public void setDisphtysyorui(String pDisphtysyorui) {
        disphtysyorui = pDisphtysyorui;
    }

    private C_HonninKakninKekkaKbn honninkakninkekkakbnbyjb;

    public C_HonninKakninKekkaKbn getHonninkakninkekkakbnbyjb() {
        return honninkakninkekkakbnbyjb;
    }

    public void setHonninkakninkekkakbnbyjb(C_HonninKakninKekkaKbn pHonninkakninkekkakbnbyjb) {
        honninkakninkekkakbnbyjb = pHonninkakninkekkakbnbyjb;
    }

    @ValidTextArea(length=50, rows=10)
    @MultiByteStringsReturnable
    private String syanaimsgkkanribyjb;

    public String getSyanaimsgkkanribyjb() {
        return syanaimsgkkanribyjb;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyanaimsgkkanribyjb(String pSyanaimsgkkanribyjb) {
        syanaimsgkkanribyjb = pSyanaimsgkkanribyjb;
    }

    private String syoukainomibtn;

    public String getSyoukainomibtn() {
        return syoukainomibtn;
    }

    public void setSyoukainomibtn(String pSyoukainomibtn) {
        syoukainomibtn = pSyoukainomibtn;
    }

    private C_SoukinsakiKbn soukinsakikbn;

    public C_SoukinsakiKbn getSoukinsakikbn() {
        return soukinsakikbn;
    }

    public void setSoukinsakikbn(C_SoukinsakiKbn pSoukinsakikbn) {
        soukinsakikbn = pSoukinsakikbn;
    }

    private C_ShrhousiteiKbn shrhousiteikbn;

    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
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

    @Digit
    @MaxLength(max=10)
    private String kouzano10keta;

    public String getKouzano10keta() {
        return kouzano10keta;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano10keta(String pKouzano10keta) {
        kouzano10keta = pKouzano10keta;
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
    private String kzmeiginmkn;

    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private C_HonninKakninKekkaKbn honninkakninkekkakbnbykb;

    public C_HonninKakninKekkaKbn getHonninkakninkekkakbnbykb() {
        return honninkakninkekkakbnbykb;
    }

    public void setHonninkakninkekkakbnbykb(C_HonninKakninKekkaKbn pHonninkakninkekkakbnbykb) {
        honninkakninkekkakbnbykb = pHonninkakninkekkakbnbykb;
    }

    @ValidTextArea(length=50, rows=10)
    @MultiByteStringsReturnable
    private String syanaimsgkkanribykb;

    public String getSyanaimsgkkanribykb() {
        return syanaimsgkkanribykb;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyanaimsgkkanribykb(String pSyanaimsgkkanribykb) {
        syanaimsgkkanribykb = pSyanaimsgkkanribykb;
    }
}
