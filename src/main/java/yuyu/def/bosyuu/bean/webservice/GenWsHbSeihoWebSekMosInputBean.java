package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.Tel;

/**
 * （保険募集）生保Ｗｅｂ設計書申込書作成入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebSekMosInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebSekMosInputBean() {
    }

    @Column(order = 1, length = 1)
    @NotNull
    @MaxLength(max=1)
    private String iwsSekmossakuseikbn;

    public String getIwsSekmossakuseikbn() {
        return iwsSekmossakuseikbn;
    }

    public void setIwsSekmossakuseikbn(String pIwsSekmossakuseikbn) {
        iwsSekmossakuseikbn = pIwsSekmossakuseikbn;
    }

    @Column(order = 2, length = 1)
    @NotNull
    @MaxLength(max=1)
    private String iwsSekmoswebsyorikbn;

    public String getIwsSekmoswebsyorikbn() {
        return iwsSekmoswebsyorikbn;
    }

    public void setIwsSekmoswebsyorikbn(String pIwsSekmoswebsyorikbn) {
        iwsSekmoswebsyorikbn = pIwsSekmoswebsyorikbn;
    }

    @Column(order = 3, length = 1)
    @NotNull
    @MaxLength(max=1)
    private String iwsDrtentyouhyougyoutaikbn;

    public String getIwsDrtentyouhyougyoutaikbn() {
        return iwsDrtentyouhyougyoutaikbn;
    }

    public void setIwsDrtentyouhyougyoutaikbn(String pIwsDrtentyouhyougyoutaikbn) {
        iwsDrtentyouhyougyoutaikbn = pIwsDrtentyouhyougyoutaikbn;
    }

    @Column(order = 4, length = 1)
    private String iwsPkakhyouji;

    public String getIwsPkakhyouji() {
        return iwsPkakhyouji;
    }

    public void setIwsPkakhyouji(String pIwsPkakhyouji) {
        iwsPkakhyouji = pIwsPkakhyouji;
    }

    @Column(order = 5, length = 1)
    @NotNull
    @MaxLength(max=1)
    private String iwsSkguidanceskshyj;

    public String getIwsSkguidanceskshyj() {
        return iwsSkguidanceskshyj;
    }

    public void setIwsSkguidanceskshyj(String pIwsSkguidanceskshyj) {
        iwsSkguidanceskshyj = pIwsSkguidanceskshyj;
    }

    @Column(order = 6, length = 6)
    @MaxLength(max=6)
    @AlphaDigit
    private String iwsAatukaikojincd;

    public String getIwsAatukaikojincd() {
        return iwsAatukaikojincd;
    }

    public void setIwsAatukaikojincd(String pIwsAatukaikojincd) {
        iwsAatukaikojincd = pIwsAatukaikojincd;
    }

    @Column(order = 7, length = 6)
    @MaxLength(max=6)
    @AlphaDigit
    private String iwsBatukaikojincd;

    public String getIwsBatukaikojincd() {
        return iwsBatukaikojincd;
    }

    public void setIwsBatukaikojincd(String pIwsBatukaikojincd) {
        iwsBatukaikojincd = pIwsBatukaikojincd;
    }

    @Column(order = 8, length = 18)
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsKyknm;

    public String getIwsKyknm() {
        return iwsKyknm;
    }

    public void setIwsKyknm(String pIwsKyknm) {
        iwsKyknm = pIwsKyknm;
    }

    @Column(order = 9, length = 11)
    @MultiByte
    @MaxLength(max=11)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKjkyknm11;

    public String getIwsKjkyknm11() {
        return iwsKjkyknm11;
    }

    public void setIwsKjkyknm11(String pIwsKjkyknm11) {
        iwsKjkyknm11 = pIwsKjkyknm11;
    }

    @Column(order = 10, length = 8)
    private BizDate iwsKyksyaseiymd;

    public BizDate getIwsKyksyaseiymd() {
        return iwsKyksyaseiymd;
    }

    public void setIwsKyksyaseiymd(BizDate pIwsKyksyaseiymd) {
        iwsKyksyaseiymd = pIwsKyksyaseiymd;
    }

    @Column(order = 11, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsKyksyaseikbn;

    public String getIwsKyksyaseikbn() {
        return iwsKyksyaseikbn;
    }

    public void setIwsKyksyaseikbn(String pIwsKyksyaseikbn) {
        iwsKyksyaseikbn = pIwsKyksyaseikbn;
    }

    @Column(order = 12, length = 1)
    private String iwsKyktdkkbn;

    public String getIwsKyktdkkbn() {
        return iwsKyktdkkbn;
    }

    public void setIwsKyktdkkbn(String pIwsKyktdkkbn) {
        iwsKyktdkkbn = pIwsKyktdkkbn;
    }

    @Column(order = 13, length = 2)
    private String iwsHjnkeitaikbn;

    public String getIwsHjnkeitaikbn() {
        return iwsHjnkeitaikbn;
    }

    public void setIwsHjnkeitaikbn(String pIwsHjnkeitaikbn) {
        iwsHjnkeitaikbn = pIwsHjnkeitaikbn;
    }

    @Column(order = 14, length = 30)
    private String iwsHjnnm;

    public String getIwsHjnnm() {
        return iwsHjnnm;
    }

    public void setIwsHjnnm(String pIwsHjnnm) {
        iwsHjnnm = pIwsHjnnm;
    }

    @Column(order = 15, length = 30)
    @MultiByte
    private String iwsKjhjnnm;

    public String getIwsKjhjnnm() {
        return iwsKjhjnnm;
    }

    public void setIwsKjhjnnm(String pIwsKjhjnnm) {
        iwsKjhjnnm = pIwsKjhjnnm;
    }

    @Column(order = 16, length = 2)
    private String iwsHjndaiykkbn;

    public String getIwsHjndaiykkbn() {
        return iwsHjndaiykkbn;
    }

    public void setIwsHjndaiykkbn(String pIwsHjndaiykkbn) {
        iwsHjndaiykkbn = pIwsHjndaiykkbn;
    }

    @Column(order = 17, length = 30)
    private String iwsHjndainm;

    public String getIwsHjndainm() {
        return iwsHjndainm;
    }

    public void setIwsHjndainm(String pIwsHjndainm) {
        iwsHjndainm = pIwsHjndainm;
    }

    @Column(order = 18, length = 30)
    @MultiByte
    private String iwsKjhjndaihyounm;

    public String getIwsKjhjndaihyounm() {
        return iwsKjhjndaihyounm;
    }

    public void setIwsKjhjndaihyounm(String pIwsKjhjndaihyounm) {
        iwsKjhjndaihyounm = pIwsKjhjndaihyounm;
    }

    @Column(order = 19, length = 14)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String iwsTsintelno;

    public String getIwsTsintelno() {
        return iwsTsintelno;
    }

    public void setIwsTsintelno(String pIwsTsintelno) {
        iwsTsintelno = pIwsTsintelno;
    }

    @Column(order = 20, length = 1)
    @Length(length=1)
    private String iwsTuusinsakijyuusyokbn;

    public String getIwsTuusinsakijyuusyokbn() {
        return iwsTuusinsakijyuusyokbn;
    }

    public void setIwsTuusinsakijyuusyokbn(String pIwsTuusinsakijyuusyokbn) {
        iwsTuusinsakijyuusyokbn = pIwsTuusinsakijyuusyokbn;
    }

    @Column(order = 21, length = 7)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String iwsTsinyno;

    public String getIwsTsinyno() {
        return iwsTsinyno;
    }

    public void setIwsTsinyno(String pIwsTsinyno) {
        iwsTsinyno = pIwsTsinyno;
    }

    @Column(order = 22, length = 62)
    @MultiByte
    @MaxLength(max=62)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKanjitsinkaiadr;

    public String getIwsKanjitsinkaiadr() {
        return iwsKanjitsinkaiadr;
    }

    public void setIwsKanjitsinkaiadr(String pIwsKanjitsinkaiadr) {
        iwsKanjitsinkaiadr = pIwsKanjitsinkaiadr;
    }

    @Column(order = 23, length = 18)
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsHhknnm;

    public String getIwsHhknnm() {
        return iwsHhknnm;
    }

    public void setIwsHhknnm(String pIwsHhknnm) {
        iwsHhknnm = pIwsHhknnm;
    }

    @Column(order = 24, length = 11)
    @MultiByte
    @MaxLength(max=11)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKjhhknnm11;

    public String getIwsKjhhknnm11() {
        return iwsKjhhknnm11;
    }

    public void setIwsKjhhknnm11(String pIwsKjhhknnm11) {
        iwsKjhhknnm11 = pIwsKjhhknnm11;
    }

    @Column(order = 25, length = 8)
    @ValidDate
    private BizDate iwsHhknseiymd;

    public BizDate getIwsHhknseiymd() {
        return iwsHhknseiymd;
    }

    public void setIwsHhknseiymd(BizDate pIwsHhknseiymd) {
        iwsHhknseiymd = pIwsHhknseiymd;
    }

    @Column(order = 26, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHhknseikbn;

    public String getIwsHhknseikbn() {
        return iwsHhknseikbn;
    }

    public void setIwsHhknseikbn(String pIwsHhknseikbn) {
        iwsHhknseikbn = pIwsHhknseikbn;
    }

    @Column(order = 27, length = 7)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String iwsHhknyno;

    public String getIwsHhknyno() {
        return iwsHhknyno;
    }

    public void setIwsHhknyno(String pIwsHhknyno) {
        iwsHhknyno = pIwsHhknyno;
    }

    @Column(order = 28, length = 62)
    @MultiByte
    @MaxLength(max=62)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsHhknkaiadr;

    public String getIwsHhknkaiadr() {
        return iwsHhknkaiadr;
    }

    public void setIwsHhknkaiadr(String pIwsHhknkaiadr) {
        iwsHhknkaiadr = pIwsHhknkaiadr;
    }

    @Column(order = 29, length = 1)
    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String iwsUktkbn1;

    public String getIwsUktkbn1() {
        return iwsUktkbn1;
    }

    public void setIwsUktkbn1(String pIwsUktkbn1) {
        iwsUktkbn1 = pIwsUktkbn1;
    }

    @Column(order = 30, length = 18)
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsUktnm1;

    public String getIwsUktnm1() {
        return iwsUktnm1;
    }

    public void setIwsUktnm1(String pIwsUktnm1) {
        iwsUktnm1 = pIwsUktnm1;
    }

    @Column(order = 31, length = 11)
    @MultiByte
    @MaxLength(max=11)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKjuktnm1;

    public String getIwsKjuktnm1() {
        return iwsKjuktnm1;
    }

    public void setIwsKjuktnm1(String pIwsKjuktnm1) {
        iwsKjuktnm1 = pIwsKjuktnm1;
    }

    @Column(order = 32, length = 1)
    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String iwsUkttdkkbn1;

    public String getIwsUkttdkkbn1() {
        return iwsUkttdkkbn1;
    }

    public void setIwsUkttdkkbn1(String pIwsUkttdkkbn1) {
        iwsUkttdkkbn1 = pIwsUkttdkkbn1;
    }

    @Column(order = 33, length = 8)
    private BizDate iwsUktseiymd1;

    public BizDate getIwsUktseiymd1() {
        return iwsUktseiymd1;
    }

    public void setIwsUktseiymd1(BizDate pIwsUktseiymd1) {
        iwsUktseiymd1 = pIwsUktseiymd1;
    }

    @Column(order = 34, length = 1)
    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String iwsUktkbn2;

    public String getIwsUktkbn2() {
        return iwsUktkbn2;
    }

    public void setIwsUktkbn2(String pIwsUktkbn2) {
        iwsUktkbn2 = pIwsUktkbn2;
    }

    @Column(order = 35, length = 18)
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsUktnm2;

    public String getIwsUktnm2() {
        return iwsUktnm2;
    }

    public void setIwsUktnm2(String pIwsUktnm2) {
        iwsUktnm2 = pIwsUktnm2;
    }

    @Column(order = 36, length = 11)
    @MultiByte
    @MaxLength(max=11)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKjuktnm2;

    public String getIwsKjuktnm2() {
        return iwsKjuktnm2;
    }

    public void setIwsKjuktnm2(String pIwsKjuktnm2) {
        iwsKjuktnm2 = pIwsKjuktnm2;
    }

    @Column(order = 37, length = 1)
    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String iwsUkttdkkbn2;

    public String getIwsUkttdkkbn2() {
        return iwsUkttdkkbn2;
    }

    public void setIwsUkttdkkbn2(String pIwsUkttdkkbn2) {
        iwsUkttdkkbn2 = pIwsUkttdkkbn2;
    }

    @Column(order = 38, length = 8)
    private BizDate iwsUktseiymd2;

    public BizDate getIwsUktseiymd2() {
        return iwsUktseiymd2;
    }

    public void setIwsUktseiymd2(BizDate pIwsUktseiymd2) {
        iwsUktseiymd2 = pIwsUktseiymd2;
    }

    @Column(order = 39, length = 1)
    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String iwsUktkbn3;

    public String getIwsUktkbn3() {
        return iwsUktkbn3;
    }

    public void setIwsUktkbn3(String pIwsUktkbn3) {
        iwsUktkbn3 = pIwsUktkbn3;
    }

    @Column(order = 40, length = 18)
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsUktnm3;

    public String getIwsUktnm3() {
        return iwsUktnm3;
    }

    public void setIwsUktnm3(String pIwsUktnm3) {
        iwsUktnm3 = pIwsUktnm3;
    }

    @Column(order = 41, length = 11)
    @MultiByte
    @MaxLength(max=11)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKjuktnm3;

    public String getIwsKjuktnm3() {
        return iwsKjuktnm3;
    }

    public void setIwsKjuktnm3(String pIwsKjuktnm3) {
        iwsKjuktnm3 = pIwsKjuktnm3;
    }

    @Column(order = 42, length = 1)
    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String iwsUkttdkkbn3;

    public String getIwsUkttdkkbn3() {
        return iwsUkttdkkbn3;
    }

    public void setIwsUkttdkkbn3(String pIwsUkttdkkbn3) {
        iwsUkttdkkbn3 = pIwsUkttdkkbn3;
    }

    @Column(order = 43, length = 8)
    private BizDate iwsUktseiymd3;

    public BizDate getIwsUktseiymd3() {
        return iwsUktseiymd3;
    }

    public void setIwsUktseiymd3(BizDate pIwsUktseiymd3) {
        iwsUktseiymd3 = pIwsUktseiymd3;
    }

    @Column(order = 44, length = 1)
    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String iwsUktkbn4;

    public String getIwsUktkbn4() {
        return iwsUktkbn4;
    }

    public void setIwsUktkbn4(String pIwsUktkbn4) {
        iwsUktkbn4 = pIwsUktkbn4;
    }

    @Column(order = 45, length = 18)
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsUktnm4;

    public String getIwsUktnm4() {
        return iwsUktnm4;
    }

    public void setIwsUktnm4(String pIwsUktnm4) {
        iwsUktnm4 = pIwsUktnm4;
    }

    @Column(order = 46, length = 11)
    @MultiByte
    @MaxLength(max=11)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKjuktnm4;

    public String getIwsKjuktnm4() {
        return iwsKjuktnm4;
    }

    public void setIwsKjuktnm4(String pIwsKjuktnm4) {
        iwsKjuktnm4 = pIwsKjuktnm4;
    }

    @Column(order = 47, length = 1)
    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String iwsUkttdkkbn4;

    public String getIwsUkttdkkbn4() {
        return iwsUkttdkkbn4;
    }

    public void setIwsUkttdkkbn4(String pIwsUkttdkkbn4) {
        iwsUkttdkkbn4 = pIwsUkttdkkbn4;
    }

    @Column(order = 48, length = 8)
    private BizDate iwsUktseiymd4;

    public BizDate getIwsUktseiymd4() {
        return iwsUktseiymd4;
    }

    public void setIwsUktseiymd4(BizDate pIwsUktseiymd4) {
        iwsUktseiymd4 = pIwsUktseiymd4;
    }

    @Column(order = 49, length = 1)
    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String iwsUktkbn5;

    public String getIwsUktkbn5() {
        return iwsUktkbn5;
    }

    public void setIwsUktkbn5(String pIwsUktkbn5) {
        iwsUktkbn5 = pIwsUktkbn5;
    }

    @Column(order = 50, length = 18)
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsUktnm5;

    public String getIwsUktnm5() {
        return iwsUktnm5;
    }

    public void setIwsUktnm5(String pIwsUktnm5) {
        iwsUktnm5 = pIwsUktnm5;
    }

    @Column(order = 51, length = 11)
    @MultiByte
    @MaxLength(max=11)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKjuktnm5;

    public String getIwsKjuktnm5() {
        return iwsKjuktnm5;
    }

    public void setIwsKjuktnm5(String pIwsKjuktnm5) {
        iwsKjuktnm5 = pIwsKjuktnm5;
    }

    @Column(order = 52, length = 1)
    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String iwsUkttdkkbn5;

    public String getIwsUkttdkkbn5() {
        return iwsUkttdkkbn5;
    }

    public void setIwsUkttdkkbn5(String pIwsUkttdkkbn5) {
        iwsUkttdkkbn5 = pIwsUkttdkkbn5;
    }

    @Column(order = 53, length = 8)
    private BizDate iwsUktseiymd5;

    public BizDate getIwsUktseiymd5() {
        return iwsUktseiymd5;
    }

    public void setIwsUktseiymd5(BizDate pIwsUktseiymd5) {
        iwsUktseiymd5 = pIwsUktseiymd5;
    }

    @Column(order = 54, length = 3)
    @Length(length=3)
    private String iwsHknsyuruino;

    public String getIwsHknsyuruino() {
        return iwsHknsyuruino;
    }

    public void setIwsHknsyuruino(String pIwsHknsyuruino) {
        iwsHknsyuruino = pIwsHknsyuruino;
    }

    @Column(order = 55, length = 2)
    @MaxLength(max=2)
    @SingleByteStrings
    private String iwsHknkkn1;

    public String getIwsHknkkn1() {
        return iwsHknkkn1;
    }

    public void setIwsHknkkn1(String pIwsHknkkn1) {
        iwsHknkkn1 = pIwsHknkkn1;
    }

    @Column(order = 56, length = 8)
    private BizDate iwsNrkcalckijyunymd;

    public BizDate getIwsNrkcalckijyunymd() {
        return iwsNrkcalckijyunymd;
    }

    public void setIwsNrkcalckijyunymd(BizDate pIwsNrkcalckijyunymd) {
        iwsNrkcalckijyunymd = pIwsNrkcalckijyunymd;
    }

    @Column(order = 57, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHjkktkbn;

    public String getIwsHjkktkbn() {
        return iwsHjkktkbn;
    }

    public void setIwsHjkktkbn(String pIwsHjkktkbn) {
        iwsHjkktkbn = pIwsHjkktkbn;
    }

    @Column(order = 58, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsSdpdkbn;

    public String getIwsSdpdkbn() {
        return iwsSdpdkbn;
    }

    public void setIwsSdpdkbn(String pIwsSdpdkbn) {
        iwsSdpdkbn = pIwsSdpdkbn;
    }

    @Column(order = 59, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHaitousiharaikbn;

    public String getIwsHaitousiharaikbn() {
        return iwsHaitousiharaikbn;
    }

    public void setIwsHaitousiharaikbn(String pIwsHaitousiharaikbn) {
        iwsHaitousiharaikbn = pIwsHaitousiharaikbn;
    }

    @Column(order = 60, length = 1)
    private String iwsHtkinuthoukbn;

    public String getIwsHtkinuthoukbn() {
        return iwsHtkinuthoukbn;
    }

    public void setIwsHtkinuthoukbn(String pIwsHtkinuthoukbn) {
        iwsHtkinuthoukbn = pIwsHtkinuthoukbn;
    }

    @Column(order = 61, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsKyktuukakbn;

    public String getIwsKyktuukakbn() {
        return iwsKyktuukakbn;
    }

    public void setIwsKyktuukakbn(String pIwsKyktuukakbn) {
        iwsKyktuukakbn = pIwsKyktuukakbn;
    }

    @Column(order = 62, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHrktuukakbn;

    public String getIwsHrktuukakbn() {
        return iwsHrktuukakbn;
    }

    public void setIwsHrktuukakbn(String pIwsHrktuukakbn) {
        iwsHrktuukakbn = pIwsHrktuukakbn;
    }

    @Column(order = 63, length = 5)
    @MaxLength(max=5)
    @SingleByteStrings
    @Digit
    private String iwsNyknkwsrateyen;

    public String getIwsNyknkwsrateyen() {
        return iwsNyknkwsrateyen;
    }

    public void setIwsNyknkwsrateyen(String pIwsNyknkwsrateyen) {
        iwsNyknkwsrateyen = pIwsNyknkwsrateyen;
    }

    @Column(order = 64, length = 5)
    @MaxLength(max=5)
    @SingleByteStrings
    @Digit
    private String iwsNyknkwsrategk;

    public String getIwsNyknkwsrategk() {
        return iwsNyknkwsrategk;
    }

    public void setIwsNyknkwsrategk(String pIwsNyknkwsrategk) {
        iwsNyknkwsrategk = pIwsNyknkwsrategk;
    }

    @Column(order = 65, length = 9)
    @MaxLength(max=9)
    @SingleByteStrings
    @Digit
    private String iwsKihonsstr;

    public String getIwsKihonsstr() {
        return iwsKihonsstr;
    }

    public void setIwsKihonsstr(String pIwsKihonsstr) {
        iwsKihonsstr = pIwsKihonsstr;
    }

    @Column(order = 66, length = 13)
    @MaxLength(max=13)
    @SingleByteStrings
    @Digit
    private String iwsGaikakihonsstr;

    public String getIwsGaikakihonsstr() {
        return iwsGaikakihonsstr;
    }

    public void setIwsGaikakihonsstr(String pIwsGaikakihonsstr) {
        iwsGaikakihonsstr = pIwsGaikakihonsstr;
    }

    @Column(order = 67, length = 10)
    @MaxLength(max=10)
    @SingleByteStrings
    @Digit
    private String iwsKihonpstr;

    public String getIwsKihonpstr() {
        return iwsKihonpstr;
    }

    public void setIwsKihonpstr(String pIwsKihonpstr) {
        iwsKihonpstr = pIwsKihonpstr;
    }

    @Column(order = 68, length = 13)
    @MaxLength(max=13)
    @SingleByteStrings
    @Digit
    private String iwsGaikakihonpstr;

    public String getIwsGaikakihonpstr() {
        return iwsGaikakihonpstr;
    }

    public void setIwsGaikakihonpstr(String pIwsGaikakihonpstr) {
        iwsGaikakihonpstr = pIwsGaikakihonpstr;
    }

    @Column(order = 69, length = 10)
    @MaxLength(max=10)
    @SingleByteStrings
    @Digit
    private String iwsHrktuukakihonp;

    public String getIwsHrktuukakihonp() {
        return iwsHrktuukakihonp;
    }

    public void setIwsHrktuukakihonp(String pIwsHrktuukakihonp) {
        iwsHrktuukakihonp = pIwsHrktuukakihonp;
    }

    @Column(order = 70, length = 13)
    @MaxLength(max=13)
    @SingleByteStrings
    @Digit
    private String iwsGaikahrktuukakihonp;

    public String getIwsGaikahrktuukakihonp() {
        return iwsGaikahrktuukakihonp;
    }

    public void setIwsGaikahrktuukakihonp(String pIwsGaikahrktuukakihonp) {
        iwsGaikahrktuukakihonp = pIwsGaikahrktuukakihonp;
    }

    @Column(order = 71, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsSaimankihyj;

    public String getIwsSaimankihyj() {
        return iwsSaimankihyj;
    }

    public void setIwsSaimankihyj(String pIwsSaimankihyj) {
        iwsSaimankihyj = pIwsSaimankihyj;
    }

    @Column(order = 72, length = 2)
    @MaxLength(max=2)
    private String iwsHknkkn;

    public String getIwsHknkkn() {
        return iwsHknkkn;
    }

    public void setIwsHknkkn(String pIwsHknkkn) {
        iwsHknkkn = pIwsHknkkn;
    }

    @Column(order = 73, length = 2)
    @MaxLength(max=2)
    private String iwsPharaikomikikan;

    public String getIwsPharaikomikikan() {
        return iwsPharaikomikikan;
    }

    public void setIwsPharaikomikikan(String pIwsPharaikomikikan) {
        iwsPharaikomikikan = pIwsPharaikomikikan;
    }

    @Column(order = 74, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHaraikomikaisuukbn;

    public String getIwsHaraikomikaisuukbn() {
        return iwsHaraikomikaisuukbn;
    }

    public void setIwsHaraikomikaisuukbn(String pIwsHaraikomikaisuukbn) {
        iwsHaraikomikaisuukbn = pIwsHaraikomikaisuukbn;
    }

    @Column(order = 75, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHrkkeirokbn;

    public String getIwsHrkkeirokbn() {
        return iwsHrkkeirokbn;
    }

    public void setIwsHrkkeirokbn(String pIwsHrkkeirokbn) {
        iwsHrkkeirokbn = pIwsHrkkeirokbn;
    }

    @Column(order = 76, length = 2)
    @MaxLength(max=2)
    private String iwsZennoukkn;

    public String getIwsZennoukkn() {
        return iwsZennoukkn;
    }

    public void setIwsZennoukkn(String pIwsZennoukkn) {
        iwsZennoukkn = pIwsZennoukkn;
    }

    @Column(order = 77, length = 1)
    @Length(length=1)
    private String iwsTargettkarihyj;

    public String getIwsTargettkarihyj() {
        return iwsTargettkarihyj;
    }

    public void setIwsTargettkarihyj(String pIwsTargettkarihyj) {
        iwsTargettkarihyj = pIwsTargettkarihyj;
    }

    @Column(order = 78, length = 1)
    @Length(length=1)
    private String iwsTargettksyuruikbn;

    public String getIwsTargettksyuruikbn() {
        return iwsTargettksyuruikbn;
    }

    public void setIwsTargettksyuruikbn(String pIwsTargettksyuruikbn) {
        iwsTargettksyuruikbn = pIwsTargettksyuruikbn;
    }

    @Column(order = 79, length = 3)
    @Length(length=3)
    private String iwsTargettkmkht;

    public String getIwsTargettkmkht() {
        return iwsTargettkmkht;
    }

    public void setIwsTargettkmkht(String pIwsTargettkmkht) {
        iwsTargettkmkht = pIwsTargettkmkht;
    }

    @Column(order = 80, length = 1)
    @Length(length=1)
    private String iwsJyudkaigomehrtkarihyj;

    public String getIwsJyudkaigomehrtkarihyj() {
        return iwsJyudkaigomehrtkarihyj;
    }

    public void setIwsJyudkaigomehrtkarihyj(String pIwsJyudkaigomehrtkarihyj) {
        iwsJyudkaigomehrtkarihyj = pIwsJyudkaigomehrtkarihyj;
    }

    @Column(order = 81, length = 1)
    @Length(length=1)
    private String iwsSyksbyensitihsyutkykhyj;

    public String getIwsSyksbyensitihsyutkykhyj() {
        return iwsSyksbyensitihsyutkykhyj;
    }

    public void setIwsSyksbyensitihsyutkykhyj(String pIwsSyksbyensitihsyutkykhyj) {
        iwsSyksbyensitihsyutkykhyj = pIwsSyksbyensitihsyutkykhyj;
    }

    @Column(order = 82, length = 1)
    private String iwsLntkkbn;

    public String getIwsLntkkbn() {
        return iwsLntkkbn;
    }

    public void setIwsLntkkbn(String pIwsLntkkbn) {
        iwsLntkkbn = pIwsLntkkbn;
    }

    @Column(order = 83, length = 2)
    @Length(length=2)
    private String iwsTksykmcd1;

    public String getIwsTksykmcd1() {
        return iwsTksykmcd1;
    }

    public void setIwsTksykmcd1(String pIwsTksykmcd1) {
        iwsTksykmcd1 = pIwsTksykmcd1;
    }

    @Column(order = 84, length = 2)
    @Length(length=2)
    private String iwsTksykmcd2;

    public String getIwsTksykmcd2() {
        return iwsTksykmcd2;
    }

    public void setIwsTksykmcd2(String pIwsTksykmcd2) {
        iwsTksykmcd2 = pIwsTksykmcd2;
    }

    @Column(order = 85, length = 2)
    @Length(length=2)
    private String iwsTksykmcd3;

    public String getIwsTksykmcd3() {
        return iwsTksykmcd3;
    }

    public void setIwsTksykmcd3(String pIwsTksykmcd3) {
        iwsTksykmcd3 = pIwsTksykmcd3;
    }

    @Column(order = 86, length = 2)
    @Length(length=2)
    private String iwsTksykmcd4;

    public String getIwsTksykmcd4() {
        return iwsTksykmcd4;
    }

    public void setIwsTksykmcd4(String pIwsTksykmcd4) {
        iwsTksykmcd4 = pIwsTksykmcd4;
    }

    @Column(order = 87, length = 2)
    @Length(length=2)
    private String iwsTksykmcd5;

    public String getIwsTksykmcd5() {
        return iwsTksykmcd5;
    }

    public void setIwsTksykmcd5(String pIwsTksykmcd5) {
        iwsTksykmcd5 = pIwsTksykmcd5;
    }

    @Column(order = 88, length = 8)
    @ValidDate
    private BizDate iwsSyoriymd;

    public BizDate getIwsSyoriymd() {
        return iwsSyoriymd;
    }

    public void setIwsSyoriymd(BizDate pIwsSyoriymd) {
        iwsSyoriymd = pIwsSyoriymd;
    }

    @Column(order = 89, length = 7)
    @AlphaDigit
    @MaxLength(max=7)
    private String iwsOyadrtencd;

    public String getIwsOyadrtencd() {
        return iwsOyadrtencd;
    }

    public void setIwsOyadrtencd(String pIwsOyadrtencd) {
        iwsOyadrtencd = pIwsOyadrtencd;
    }

    @Column(order = 90, length = 2)
    @Length(length=2)
    private String iwsSueokikkn;

    public String getIwsSueokikkn() {
        return iwsSueokikkn;
    }

    public void setIwsSueokikkn(String pIwsSueokikkn) {
        iwsSueokikkn = pIwsSueokikkn;
    }

    @Column(order = 91, length = 1)
    @Length(length=1)
    private String iwsNksyukbn;

    public String getIwsNksyukbn() {
        return iwsNksyukbn;
    }

    public void setIwsNksyukbn(String pIwsNksyukbn) {
        iwsNksyukbn = pIwsNksyukbn;
    }

    @Column(order = 92, length = 3)
    @Length(length=3)
    private String iwsSisuurendouhbnwr;

    public String getIwsSisuurendouhbnwr() {
        return iwsSisuurendouhbnwr;
    }

    public void setIwsSisuurendouhbnwr(String pIwsSisuurendouhbnwr) {
        iwsSisuurendouhbnwr = pIwsSisuurendouhbnwr;
    }

    @Column(order = 93, length = 3)
    @Length(length=3)
    private String iwsTeiritutumitatehbnwr;

    public String getIwsTeiritutumitatehbnwr() {
        return iwsTeiritutumitatehbnwr;
    }

    public void setIwsTeiritutumitatehbnwr(String pIwsTeiritutumitatehbnwr) {
        iwsTeiritutumitatehbnwr = pIwsTeiritutumitatehbnwr;
    }

    @Column(order = 94, length = 1)
    @Length(length=1)
    @SingleByteStrings
    private String iwsIkkatubaraikbn;

    public String getIwsIkkatubaraikbn() {
        return iwsIkkatubaraikbn;
    }

    public void setIwsIkkatubaraikbn(String pIwsIkkatubaraikbn) {
        iwsIkkatubaraikbn = pIwsIkkatubaraikbn;
    }

    @Column(order = 95, length = 2)
    @Length(length=2)
    @SingleByteStrings
    private String iwsIkkatubaraikaisuu;

    public String getIwsIkkatubaraikaisuu() {
        return iwsIkkatubaraikaisuu;
    }

    public void setIwsIkkatubaraikaisuu(String pIwsIkkatubaraikaisuu) {
        iwsIkkatubaraikaisuu = pIwsIkkatubaraikaisuu;
    }

    @Column(order = 96, length = 1)
    @Length(length=1)
    private String iwsZennouhyouji;

    public String getIwsZennouhyouji() {
        return iwsZennouhyouji;
    }

    public void setIwsZennouhyouji(String pIwsZennouhyouji) {
        iwsZennouhyouji = pIwsZennouhyouji;
    }

    @Column(order = 97, length = 10)
    @Length(length=10)
    @SingleByteStrings
    @Digit
    private String iwsHrksikin;

    public String getIwsHrksikin() {
        return iwsHrksikin;
    }

    public void setIwsHrksikin(String pIwsHrksikin) {
        iwsHrksikin = pIwsHrksikin;
    }

    @Column(order = 98, length = 1)
    @Length(length=1)
    private String iwsHrksikinnrkhyj;

    public String getIwsHrksikinnrkhyj() {
        return iwsHrksikinnrkhyj;
    }

    public void setIwsHrksikinnrkhyj(String pIwsHrksikinnrkhyj) {
        iwsHrksikinnrkhyj = pIwsHrksikinnrkhyj;
    }

    @Column(order = 99, length = 1)
    private String iwsKzktrkmoskbn;

    public String getIwsKzktrkmoskbn() {
        return iwsKzktrkmoskbn;
    }

    public void setIwsKzktrkmoskbn(String pIwsKzktrkmoskbn) {
        iwsKzktrkmoskbn = pIwsKzktrkmoskbn;
    }

    @Column(order = 100, length = 1)
    private String iwsKzktdkkbn1;

    public String getIwsKzktdkkbn1() {
        return iwsKzktdkkbn1;
    }

    public void setIwsKzktdkkbn1(String pIwsKzktdkkbn1) {
        iwsKzktdkkbn1 = pIwsKzktdkkbn1;
    }

    @Column(order = 101, length = 18)
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsKzkknnm1;

    public String getIwsKzkknnm1() {
        return iwsKzkknnm1;
    }

    public void setIwsKzkknnm1(String pIwsKzkknnm1) {
        iwsKzkknnm1 = pIwsKzkknnm1;
    }

    @Column(order = 102, length = 11)
    @MultiByte
    @MaxLength(max=11)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKzkkjnm1;

    public String getIwsKzkkjnm1() {
        return iwsKzkkjnm1;
    }

    public void setIwsKzkkjnm1(String pIwsKzkkjnm1) {
        iwsKzkkjnm1 = pIwsKzkkjnm1;
    }

    @Column(order = 103, length = 1)
    private String iwsKzkseikbn1;

    public String getIwsKzkseikbn1() {
        return iwsKzkseikbn1;
    }

    public void setIwsKzkseikbn1(String pIwsKzkseikbn1) {
        iwsKzkseikbn1 = pIwsKzkseikbn1;
    }

    @Column(order = 104, length = 8)
    private BizDate iwsKzkseiymd1;

    public BizDate getIwsKzkseiymd1() {
        return iwsKzkseiymd1;
    }

    public void setIwsKzkseiymd1(BizDate pIwsKzkseiymd1) {
        iwsKzkseiymd1 = pIwsKzkseiymd1;
    }

    @Column(order = 105, length = 7)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String iwsKzkyno1;

    public String getIwsKzkyno1() {
        return iwsKzkyno1;
    }

    public void setIwsKzkyno1(String pIwsKzkyno1) {
        iwsKzkyno1 = pIwsKzkyno1;
    }

    @Column(order = 106, length = 62)
    @MultiByte
    @MaxLength(max=62)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKzkadr1;

    public String getIwsKzkadr1() {
        return iwsKzkadr1;
    }

    public void setIwsKzkadr1(String pIwsKzkadr1) {
        iwsKzkadr1 = pIwsKzkadr1;
    }

    @Column(order = 107, length = 1)
    private String iwsKzktdkkbn2;

    public String getIwsKzktdkkbn2() {
        return iwsKzktdkkbn2;
    }

    public void setIwsKzktdkkbn2(String pIwsKzktdkkbn2) {
        iwsKzktdkkbn2 = pIwsKzktdkkbn2;
    }

    @Column(order = 108, length = 18)
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsKzkknnm2;

    public String getIwsKzkknnm2() {
        return iwsKzkknnm2;
    }

    public void setIwsKzkknnm2(String pIwsKzkknnm2) {
        iwsKzkknnm2 = pIwsKzkknnm2;
    }

    @Column(order = 109, length = 11)
    @MultiByte
    @MaxLength(max=11)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKzkkjnm2;

    public String getIwsKzkkjnm2() {
        return iwsKzkkjnm2;
    }

    public void setIwsKzkkjnm2(String pIwsKzkkjnm2) {
        iwsKzkkjnm2 = pIwsKzkkjnm2;
    }

    @Column(order = 110, length = 1)
    private String iwsKzkseikbn2;

    public String getIwsKzkseikbn2() {
        return iwsKzkseikbn2;
    }

    public void setIwsKzkseikbn2(String pIwsKzkseikbn2) {
        iwsKzkseikbn2 = pIwsKzkseikbn2;
    }

    @Column(order = 111, length = 8)
    private BizDate iwsKzkseiymd2;

    public BizDate getIwsKzkseiymd2() {
        return iwsKzkseiymd2;
    }

    public void setIwsKzkseiymd2(BizDate pIwsKzkseiymd2) {
        iwsKzkseiymd2 = pIwsKzkseiymd2;
    }

    @Column(order = 112, length = 7)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String iwsKzkyno2;

    public String getIwsKzkyno2() {
        return iwsKzkyno2;
    }

    public void setIwsKzkyno2(String pIwsKzkyno2) {
        iwsKzkyno2 = pIwsKzkyno2;
    }

    @Column(order = 113, length = 62)
    @MultiByte
    @MaxLength(max=62)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsKzkadr2;

    public String getIwsKzkadr2() {
        return iwsKzkadr2;
    }

    public void setIwsKzkadr2(String pIwsKzkadr2) {
        iwsKzkadr2 = pIwsKzkadr2;
    }

    @Column(order = 114, length = 1)
    private String iwsKykdrtkkanouhyj;

    public String getIwsKykdrtkkanouhyj() {
        return iwsKykdrtkkanouhyj;
    }

    public void setIwsKykdrtkkanouhyj(String pIwsKykdrtkkanouhyj) {
        iwsKykdrtkkanouhyj = pIwsKykdrtkkanouhyj;
    }

    @Column(order = 115, length = 1)
    private String iwsHhkndrtkkanouhyj;

    public String getIwsHhkndrtkkanouhyj() {
        return iwsHhkndrtkkanouhyj;
    }

    public void setIwsHhkndrtkkanouhyj(String pIwsHhkndrtkkanouhyj) {
        iwsHhkndrtkkanouhyj = pIwsHhkndrtkkanouhyj;
    }

    @Column(order = 116, length = 1)
    private String iwsDrtkkbn;

    public String getIwsDrtkkbn() {
        return iwsDrtkkbn;
    }

    public void setIwsDrtkkbn(String pIwsDrtkkbn) {
        iwsDrtkkbn = pIwsDrtkkbn;
    }

    @Column(order = 117, length = 1)
    private String iwsKykdrnrkkbn;

    public String getIwsKykdrnrkkbn() {
        return iwsKykdrnrkkbn;
    }

    public void setIwsKykdrnrkkbn(String pIwsKykdrnrkkbn) {
        iwsKykdrnrkkbn = pIwsKykdrnrkkbn;
    }

    @Column(order = 118, length = 1)
    private String iwsHhkndrnrkkbn;

    public String getIwsHhkndrnrkkbn() {
        return iwsHhkndrnrkkbn;
    }

    public void setIwsHhkndrnrkkbn(String pIwsHhkndrnrkkbn) {
        iwsHhkndrnrkkbn = pIwsHhkndrnrkkbn;
    }

    @Column(order = 119, length = 1)
    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String iwsHhkndrtdkkbn;

    public String getIwsHhkndrtdkkbn() {
        return iwsHhkndrtdkkbn;
    }

    public void setIwsHhkndrtdkkbn(String pIwsHhkndrtdkkbn) {
        iwsHhkndrtdkkbn = pIwsHhkndrtdkkbn;
    }

    @Column(order = 120, length = 18)
    @MaxLength(max=18)
    @SingleByteStrings
    @InvalidCharacter
    private String iwsHhkndrknnm;

    public String getIwsHhkndrknnm() {
        return iwsHhkndrknnm;
    }

    public void setIwsHhkndrknnm(String pIwsHhkndrknnm) {
        iwsHhkndrknnm = pIwsHhkndrknnm;
    }

    @Column(order = 121, length = 11)
    @MultiByte
    @MaxLength(max=11)
    @MultiByteStrings
    @InvalidCharacter
    private String iwsHhkndrkjnm;

    public String getIwsHhkndrkjnm() {
        return iwsHhkndrkjnm;
    }

    public void setIwsHhkndrkjnm(String pIwsHhkndrkjnm) {
        iwsHhkndrkjnm = pIwsHhkndrkjnm;
    }

    @Column(order = 122, length = 8)
    private BizDate iwsHhkndrseiymd;

    public BizDate getIwsHhkndrseiymd() {
        return iwsHhkndrseiymd;
    }

    public void setIwsHhkndrseiymd(BizDate pIwsHhkndrseiymd) {
        iwsHhkndrseiymd = pIwsHhkndrseiymd;
    }

    @Column(order = 123, length = 1)
    @Length(length=1)
    private String iwsTeikisiharaitkarihyj;

    public String getIwsTeikisiharaitkarihyj() {
        return iwsTeikisiharaitkarihyj;
    }

    public void setIwsTeikisiharaitkarihyj(String pIwsTeikisiharaitkarihyj) {
        iwsTeikisiharaitkarihyj = pIwsTeikisiharaitkarihyj;
    }

    @Column(order = 124, length = 1)
    @Length(length=1)
    private String iwsNyskaihihyj;

    public String getIwsNyskaihihyj() {
        return iwsNyskaihihyj;
    }

    public void setIwsNyskaihihyj(String pIwsNyskaihihyj) {
        iwsNyskaihihyj = pIwsNyskaihihyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
