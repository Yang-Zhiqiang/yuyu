package yuyu.app.siharai.simouside.simousideuketuke;

import java.util.List;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_UketorininSibouUmuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 申出受付 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiMousideUketukeUiBean extends AbstractUiBean {

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

    private DataSource<BetukykInfoDataSourceBean> betukykInfoDataSource = new DataSource<>();
    public DataSource<BetukykInfoDataSourceBean> getBetukykInfoDataSource() {
        return betukykInfoDataSource;
    }

    @Deprecated
    public List<BetukykInfoDataSourceBean> getBetukykInfo() {
        return betukykInfoDataSource.getDatas();
    }

    public void setBetukykInfo(List<BetukykInfoDataSourceBean> pBetukykInfo) {
        betukykInfoDataSource.setDatas(pBetukykInfo);
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

    private String mskmjskjkyknen;

    public String getMskmjskjkyknen() {
        return mskmjskjkyknen;
    }

    public void setMskmjskjkyknen(String pMskmjskjkyknen) {
        mskmjskjkyknen = pMskmjskjkyknen;
    }

    private C_Kyksei kyksei;

    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private String tdkdtsinyno;

    public String getTdkdtsinyno() {
        return tdkdtsinyno;
    }

    public void setTdkdtsinyno(String pTdkdtsinyno) {
        tdkdtsinyno = pTdkdtsinyno;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    private String tdkdtsintelno;

    public String getTdkdtsintelno() {
        return tdkdtsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTdkdtsintelno(String pTdkdtsintelno) {
        tdkdtsintelno = pTdkdtsintelno;
    }

    private String tdkdtsinadr1kj;

    public String getTdkdtsinadr1kj() {
        return tdkdtsinadr1kj;
    }

    public void setTdkdtsinadr1kj(String pTdkdtsinadr1kj) {
        tdkdtsinadr1kj = pTdkdtsinadr1kj;
    }

    private String tdkdtsinadr2kj;

    public String getTdkdtsinadr2kj() {
        return tdkdtsinadr2kj;
    }

    public void setTdkdtsinadr2kj(String pTdkdtsinadr2kj) {
        tdkdtsinadr2kj = pTdkdtsinadr2kj;
    }

    private String tdkdtsinadr3kj;

    public String getTdkdtsinadr3kj() {
        return tdkdtsinadr3kj;
    }

    public void setTdkdtsinadr3kj(String pTdkdtsinadr3kj) {
        tdkdtsinadr3kj = pTdkdtsinadr3kj;
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

    private String mskmjskjhknnen;

    public String getMskmjskjhknnen() {
        return mskmjskjhknnen;
    }

    public void setMskmjskjhknnen(String pMskmjskjhknnen) {
        mskmjskjhknnen = pMskmjskjhknnen;
    }

    private C_Hhknsei hhknsei;

    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
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

    private C_UktKbn dispsbuktkbn1;

    public C_UktKbn getDispsbuktkbn1() {
        return dispsbuktkbn1;
    }

    public void setDispsbuktkbn1(C_UktKbn pDispsbuktkbn1) {
        dispsbuktkbn1 = pDispsbuktkbn1;
    }

    private String dispsbuktnmkn1;

    public String getDispsbuktnmkn1() {
        return dispsbuktnmkn1;
    }

    public void setDispsbuktnmkn1(String pDispsbuktnmkn1) {
        dispsbuktnmkn1 = pDispsbuktnmkn1;
    }

    private String dispsbuktnmkj1;

    public String getDispsbuktnmkj1() {
        return dispsbuktnmkj1;
    }

    public void setDispsbuktnmkj1(String pDispsbuktnmkj1) {
        dispsbuktnmkj1 = pDispsbuktnmkj1;
    }

    private BizDate dispsbuktseiymd1;

    public BizDate getDispsbuktseiymd1() {
        return dispsbuktseiymd1;
    }

    public void setDispsbuktseiymd1(BizDate pDispsbuktseiymd1) {
        dispsbuktseiymd1 = pDispsbuktseiymd1;
    }

    private String dispmskmjskjuktnen1;

    public String getDispmskmjskjuktnen1() {
        return dispmskmjskjuktnen1;
    }

    public void setDispmskmjskjuktnen1(String pDispmskmjskjuktnen1) {
        dispmskmjskjuktnen1 = pDispmskmjskjuktnen1;
    }

    private BizNumber dispsbuktbnwari1;

    public BizNumber getDispsbuktbnwari1() {
        return dispsbuktbnwari1;
    }

    public void setDispsbuktbnwari1(BizNumber pDispsbuktbnwari1) {
        dispsbuktbnwari1 = pDispsbuktbnwari1;
    }

    private C_UktKbn dispsbuktkbn2;

    public C_UktKbn getDispsbuktkbn2() {
        return dispsbuktkbn2;
    }

    public void setDispsbuktkbn2(C_UktKbn pDispsbuktkbn2) {
        dispsbuktkbn2 = pDispsbuktkbn2;
    }

    private String dispsbuktnmkn2;

    public String getDispsbuktnmkn2() {
        return dispsbuktnmkn2;
    }

    public void setDispsbuktnmkn2(String pDispsbuktnmkn2) {
        dispsbuktnmkn2 = pDispsbuktnmkn2;
    }

    private String dispsbuktnmkj2;

    public String getDispsbuktnmkj2() {
        return dispsbuktnmkj2;
    }

    public void setDispsbuktnmkj2(String pDispsbuktnmkj2) {
        dispsbuktnmkj2 = pDispsbuktnmkj2;
    }

    private BizDate dispsbuktseiymd2;

    public BizDate getDispsbuktseiymd2() {
        return dispsbuktseiymd2;
    }

    public void setDispsbuktseiymd2(BizDate pDispsbuktseiymd2) {
        dispsbuktseiymd2 = pDispsbuktseiymd2;
    }

    private String dispmskmjskjuktnen2;

    public String getDispmskmjskjuktnen2() {
        return dispmskmjskjuktnen2;
    }

    public void setDispmskmjskjuktnen2(String pDispmskmjskjuktnen2) {
        dispmskmjskjuktnen2 = pDispmskmjskjuktnen2;
    }

    private BizNumber dispsbuktbnwari2;

    public BizNumber getDispsbuktbnwari2() {
        return dispsbuktbnwari2;
    }

    public void setDispsbuktbnwari2(BizNumber pDispsbuktbnwari2) {
        dispsbuktbnwari2 = pDispsbuktbnwari2;
    }

    private C_UktKbn dispsbuktkbn3;

    public C_UktKbn getDispsbuktkbn3() {
        return dispsbuktkbn3;
    }

    public void setDispsbuktkbn3(C_UktKbn pDispsbuktkbn3) {
        dispsbuktkbn3 = pDispsbuktkbn3;
    }

    private String dispsbuktnmkn3;

    public String getDispsbuktnmkn3() {
        return dispsbuktnmkn3;
    }

    public void setDispsbuktnmkn3(String pDispsbuktnmkn3) {
        dispsbuktnmkn3 = pDispsbuktnmkn3;
    }

    private String dispsbuktnmkj3;

    public String getDispsbuktnmkj3() {
        return dispsbuktnmkj3;
    }

    public void setDispsbuktnmkj3(String pDispsbuktnmkj3) {
        dispsbuktnmkj3 = pDispsbuktnmkj3;
    }

    private BizDate dispsbuktseiymd3;

    public BizDate getDispsbuktseiymd3() {
        return dispsbuktseiymd3;
    }

    public void setDispsbuktseiymd3(BizDate pDispsbuktseiymd3) {
        dispsbuktseiymd3 = pDispsbuktseiymd3;
    }

    private String dispmskmjskjuktnen3;

    public String getDispmskmjskjuktnen3() {
        return dispmskmjskjuktnen3;
    }

    public void setDispmskmjskjuktnen3(String pDispmskmjskjuktnen3) {
        dispmskmjskjuktnen3 = pDispmskmjskjuktnen3;
    }

    private BizNumber dispsbuktbnwari3;

    public BizNumber getDispsbuktbnwari3() {
        return dispsbuktbnwari3;
    }

    public void setDispsbuktbnwari3(BizNumber pDispsbuktbnwari3) {
        dispsbuktbnwari3 = pDispsbuktbnwari3;
    }

    private C_UktKbn dispsbuktkbn4;

    public C_UktKbn getDispsbuktkbn4() {
        return dispsbuktkbn4;
    }

    public void setDispsbuktkbn4(C_UktKbn pDispsbuktkbn4) {
        dispsbuktkbn4 = pDispsbuktkbn4;
    }

    private String dispsbuktnmkn4;

    public String getDispsbuktnmkn4() {
        return dispsbuktnmkn4;
    }

    public void setDispsbuktnmkn4(String pDispsbuktnmkn4) {
        dispsbuktnmkn4 = pDispsbuktnmkn4;
    }

    private String dispsbuktnmkj4;

    public String getDispsbuktnmkj4() {
        return dispsbuktnmkj4;
    }

    public void setDispsbuktnmkj4(String pDispsbuktnmkj4) {
        dispsbuktnmkj4 = pDispsbuktnmkj4;
    }

    private BizDate dispsbuktseiymd4;

    public BizDate getDispsbuktseiymd4() {
        return dispsbuktseiymd4;
    }

    public void setDispsbuktseiymd4(BizDate pDispsbuktseiymd4) {
        dispsbuktseiymd4 = pDispsbuktseiymd4;
    }

    private String dispmskmjskjuktnen4;

    public String getDispmskmjskjuktnen4() {
        return dispmskmjskjuktnen4;
    }

    public void setDispmskmjskjuktnen4(String pDispmskmjskjuktnen4) {
        dispmskmjskjuktnen4 = pDispmskmjskjuktnen4;
    }

    private BizNumber dispsbuktbnwari4;

    public BizNumber getDispsbuktbnwari4() {
        return dispsbuktbnwari4;
    }

    public void setDispsbuktbnwari4(BizNumber pDispsbuktbnwari4) {
        dispsbuktbnwari4 = pDispsbuktbnwari4;
    }

    private C_MousideninKbn mousideninkbn;

    public C_MousideninKbn getMousideninkbn() {
        return mousideninkbn;
    }

    public void setMousideninkbn(C_MousideninKbn pMousideninkbn) {
        mousideninkbn = pMousideninkbn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String mousideninnmkj;

    public String getMousideninnmkj() {
        return mousideninnmkj;
    }

    @Trim("right")
    public void setMousideninnmkj(String pMousideninnmkj) {
        mousideninnmkj = pMousideninnmkj;
    }

    private Boolean uketorininsibouumu;

    public Boolean getUketorininsibouumu() {
        return (uketorininsibouumu == null) ? Boolean.FALSE : uketorininsibouumu;
    }

    public void setUketorininsibouumu(Boolean pUketorininsibouumu) {
        uketorininsibouumu = (pUketorininsibouumu == null) ? Boolean.FALSE : pUketorininsibouumu;
    }

    private C_UketorininSibouUmuKbn uketorininsibouumukbn;

    public C_UketorininSibouUmuKbn getUketorininsibouumukbn() {
        return uketorininsibouumukbn;
    }

    public void setUketorininsibouumukbn(C_UketorininSibouUmuKbn pUketorininsibouumukbn) {
        uketorininsibouumukbn = pUketorininsibouumukbn;
    }

    private Boolean kyksyasibouumu;

    public Boolean getKyksyasibouumu() {
        return (kyksyasibouumu == null) ? Boolean.FALSE : kyksyasibouumu;
    }

    public void setKyksyasibouumu(Boolean pKyksyasibouumu) {
        kyksyasibouumu = (pKyksyasibouumu == null) ? Boolean.FALSE : pKyksyasibouumu;
    }

    private C_KyksyaSibouUmuKbn kyksyasibouumukbn;

    public C_KyksyaSibouUmuKbn getKyksyasibouumukbn() {
        return kyksyasibouumukbn;
    }

    public void setKyksyasibouumukbn(C_KyksyaSibouUmuKbn pKyksyasibouumukbn) {
        kyksyasibouumukbn = pKyksyasibouumukbn;
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

    private C_SeikyuuSyubetu seikyuusyubetu;

    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
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

    private String byoumeitourokuno;

    public String getByoumeitourokuno() {
        return byoumeitourokuno;
    }

    public void setByoumeitourokuno(String pByoumeitourokuno) {
        byoumeitourokuno = pByoumeitourokuno;
    }

    @MaxLength(max=100)
    @MultiByteStrings
    @InvalidCharacter
    private String byoumeikj;

    public String getByoumeikj() {
        return byoumeikj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setByoumeikj(String pByoumeikj) {
        byoumeikj = pByoumeikj;
    }

    @Length(length=4)
    @AlphaDigit
    private String byoumeicd;

    public String getByoumeicd() {
        return byoumeicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setByoumeicd(String pByoumeicd) {
        byoumeicd = pByoumeicd;
    }

    @MaxLength(max=60)
    @MultiByteStrings
    @InvalidCharacter
    private String byoumeikn;

    public String getByoumeikn() {
        return byoumeikn;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setByoumeikn(String pByoumeikn) {
        byoumeikn = pByoumeikn;
    }

    @MaxLength(max=1500)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String syanaicomment;

    public String getSyanaicomment() {
        return syanaicomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyanaicomment(String pSyanaicomment) {
        syanaicomment = pSyanaicomment;
    }
}
