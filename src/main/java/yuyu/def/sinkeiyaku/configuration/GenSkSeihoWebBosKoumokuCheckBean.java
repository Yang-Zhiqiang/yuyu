package yuyu.def.sinkeiyaku.configuration;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumberBizCalcable;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.Modulus10w21;
import yuyu.infr.validation.constraints.Tel;

/**
 * （新契約）生保Ｗｅｂ募集項目チェック用BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkSeihoWebBosKoumokuCheckBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkSeihoWebBosKoumokuCheckBean() {
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


    @MaxLength(max=20)
    @AlphaDigit
    private String sekno;


    public String getSekno() {
        return sekno;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSekno(String pSekno) {
        sekno = pSekno;
    }


    @ValidDate
    private BizDate mossakuseiymd;


    public BizDate getMossakuseiymd() {
        return mossakuseiymd;
    }


    @Trim("both")
    public void setMossakuseiymd(BizDate pMossakuseiymd) {
        mossakuseiymd = pMossakuseiymd;
    }


    @ValidDate
    private BizDate pplessmosukeymd;


    public BizDate getPplessmosukeymd() {
        return pplessmosukeymd;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPplessmosukeymd(BizDate pPplessmosukeymd) {
        pplessmosukeymd = pPplessmosukeymd;
    }


    @ValidDate
    private BizDate pykkigenymd;


    public BizDate getPykkigenymd() {
        return pykkigenymd;
    }


    public void setPykkigenymd(BizDate pPykkigenymd) {
        pykkigenymd = pPykkigenymd;
    }


    @ValidDate
    private BizDate moscalckijyunymd;


    public BizDate getMoscalckijyunymd() {
        return moscalckijyunymd;
    }


    public void setMoscalckijyunymd(BizDate pMoscalckijyunymd) {
        moscalckijyunymd = pMoscalckijyunymd;
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


    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    private String kykkinmusakinm;


    public String getKykkinmusakinm() {
        return kykkinmusakinm;
    }


    public void setKykkinmusakinm(String pKykkinmusakinm) {
        kykkinmusakinm = pKykkinmusakinm;
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


    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknkinmusakinm;


    public String getHhknkinmusakinm() {
        return hhknkinmusakinm;
    }


    public void setHhknkinmusakinm(String pHhknkinmusakinm) {
        hhknkinmusakinm = pHhknkinmusakinm;
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
    private BizCurrency mossyukykp;


    public BizCurrency getMossyukykp() {
        return mossyukykp;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMossyukykp(BizCurrency pMossyukykp) {
        mossyukykp = pMossyukykp;
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


    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String nenkinuktnmkana;


    public String getNenkinuktnmkana() {
        return nenkinuktnmkana;
    }


    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNenkinuktnmkana(String pNenkinuktnmkana) {
        nenkinuktnmkana = pNenkinuktnmkana;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String nenkinuktnmkanji;


    public String getNenkinuktnmkanji() {
        return nenkinuktnmkanji;
    }


    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNenkinuktnmkanji(String pNenkinuktnmkanji) {
        nenkinuktnmkanji = pNenkinuktnmkanji;
    }


    @ValidDate
    private BizDate nenkinuktseiymd;


    public BizDate getNenkinuktseiymd() {
        return nenkinuktseiymd;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNenkinuktseiymd(BizDate pNenkinuktseiymd) {
        nenkinuktseiymd = pNenkinuktseiymd;
    }


    @Range(min="0", max="99")
    private Integer hknkkn;


    public Integer getHknkkn() {
        return hknkkn;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }


    @Range(min="0", max="99")
    private Integer hrkkkn;


    public Integer getHrkkkn() {
        return hrkkkn;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkkn(Integer pHrkkkn) {
        hrkkkn = pHrkkkn;
    }


    @Range(min="0", max="99")
    private Integer syudai1hknkkn;


    public Integer getSyudai1hknkkn() {
        return syudai1hknkkn;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyudai1hknkkn(Integer pSyudai1hknkkn) {
        syudai1hknkkn = pSyudai1hknkkn;
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
    private BizCurrency moszennoupsyokaiari;


    public BizCurrency getMoszennoupsyokaiari() {
        return moszennoupsyokaiari;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMoszennoupsyokaiari(BizCurrency pMoszennoupsyokaiari) {
        moszennoupsyokaiari = pMoszennoupsyokaiari;
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
    private String drtenjimcd1;


    public String getDrtenjimcd1() {
        return drtenjimcd1;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenjimcd1(String pDrtenjimcd1) {
        drtenjimcd1 = pDrtenjimcd1;
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


    @Length(length=4)
    @Digit
    private String dsbankcd;


    public String getDsbankcd() {
        return dsbankcd;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDsbankcd(String pDsbankcd) {
        dsbankcd = pDsbankcd;
    }


    @Length(length=3)
    @Digit
    private String dssitencd;


    public String getDssitencd() {
        return dssitencd;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDssitencd(String pDssitencd) {
        dssitencd = pDssitencd;
    }


    @MaxLength(max=12)
    @HostInvalidCharacter
    private String dskouzano;


    public String getDskouzano() {
        return dskouzano;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDskouzano(String pDskouzano) {
        dskouzano = pDskouzano;
    }


    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String dskzmeiginmkn;


    public String getDskzmeiginmkn() {
        return dskzmeiginmkn;
    }


    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDskzmeiginmkn(String pDskzmeiginmkn) {
        dskzmeiginmkn = pDskzmeiginmkn;
    }


    @Range(min="0", max="999")
    private Integer sintyou;


    public Integer getSintyou() {
        return sintyou;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSintyou(Integer pSintyou) {
        sintyou = pSintyou;
    }


    @Range(min="0", max="999")
    private Integer taijyuu;


    public Integer getTaijyuu() {
        return taijyuu;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTaijyuu(Integer pTaijyuu) {
        taijyuu = pTaijyuu;
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
    private String hhkdrnmkn;


    public String getHhkdrnmkn() {
        return hhkdrnmkn;
    }


    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhkdrnmkn(String pHhkdrnmkn) {
        hhkdrnmkn = pHhkdrnmkn;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String hhkdrnmkj;


    public String getHhkdrnmkj() {
        return hhkdrnmkj;
    }


    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhkdrnmkj(String pHhkdrnmkj) {
        hhkdrnmkj = pHhkdrnmkj;
    }


    @ValidDate
    private BizDate hhkdrseiymd;


    public BizDate getHhkdrseiymd() {
        return hhkdrseiymd;
    }


    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkdrseiymd(BizDate pHhkdrseiymd) {
        hhkdrseiymd = pHhkdrseiymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
