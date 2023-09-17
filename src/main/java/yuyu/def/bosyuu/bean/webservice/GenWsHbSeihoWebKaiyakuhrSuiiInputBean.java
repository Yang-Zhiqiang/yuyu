package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.classification.C_HugouKbn;

/**
 * （保険募集）生保Ｗｅｂ解約返戻金推移表作成入力ＢＥＡＮ データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebKaiyakuhrSuiiInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebKaiyakuhrSuiiInputBean() {
    }

    @Column(order = 1, length = 1)
    @MaxLength(max=1)
    private String iwsDrtentyouhyougyoutaikbn;

    public String getIwsDrtentyouhyougyoutaikbn() {
        return iwsDrtentyouhyougyoutaikbn;
    }

    public void setIwsDrtentyouhyougyoutaikbn(String pIwsDrtentyouhyougyoutaikbn) {
        iwsDrtentyouhyougyoutaikbn = pIwsDrtentyouhyougyoutaikbn;
    }

    @Column(order = 2, length = 8)
    @MaxLength(max=8)
    @SingleByteStrings
    private String iwsDispkykseiymd;

    public String getIwsDispkykseiymd() {
        return iwsDispkykseiymd;
    }

    public void setIwsDispkykseiymd(String pIwsDispkykseiymd) {
        iwsDispkykseiymd = pIwsDispkykseiymd;
    }

    @Column(order = 3, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsKyksyaseikbn;

    public String getIwsKyksyaseikbn() {
        return iwsKyksyaseikbn;
    }

    public void setIwsKyksyaseikbn(String pIwsKyksyaseikbn) {
        iwsKyksyaseikbn = pIwsKyksyaseikbn;
    }

    @Column(order = 4, length = 8)
    @MaxLength(max=8)
    @SingleByteStrings
    private String iwsDisphhknseiymd;

    public String getIwsDisphhknseiymd() {
        return iwsDisphhknseiymd;
    }

    public void setIwsDisphhknseiymd(String pIwsDisphhknseiymd) {
        iwsDisphhknseiymd = pIwsDisphhknseiymd;
    }

    @Column(order = 5, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHhknseikbn;

    public String getIwsHhknseikbn() {
        return iwsHhknseikbn;
    }

    public void setIwsHhknseikbn(String pIwsHhknseikbn) {
        iwsHhknseikbn = pIwsHhknseikbn;
    }

    @Column(order = 6, length = 3)
    @MaxLength(max=3)
    @SingleByteStrings
    private String iwsDisphokensyuruino;

    public String getIwsDisphokensyuruino() {
        return iwsDisphokensyuruino;
    }

    public void setIwsDisphokensyuruino(String pIwsDisphokensyuruino) {
        iwsDisphokensyuruino = pIwsDisphokensyuruino;
    }

    @Column(order = 7, length = 8)
    private BizDate iwsNrkcalckijyunymd;

    public BizDate getIwsNrkcalckijyunymd() {
        return iwsNrkcalckijyunymd;
    }

    public void setIwsNrkcalckijyunymd(BizDate pIwsNrkcalckijyunymd) {
        iwsNrkcalckijyunymd = pIwsNrkcalckijyunymd;
    }

    @Column(order = 8, length = 8)
    private BizDate iwsSeksakuseiymd;

    public BizDate getIwsSeksakuseiymd() {
        return iwsSeksakuseiymd;
    }

    public void setIwsSeksakuseiymd(BizDate pIwsSeksakuseiymd) {
        iwsSeksakuseiymd = pIwsSeksakuseiymd;
    }

    @Column(order = 9, length = 6)
    private BizDateYM iwsBosyuuym;

    public BizDateYM getIwsBosyuuym() {
        return iwsBosyuuym;
    }

    public void setIwsBosyuuym(BizDateYM pIwsBosyuuym) {
        iwsBosyuuym = pIwsBosyuuym;
    }

    @Column(order = 10, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHjkktkbn;

    public String getIwsHjkktkbn() {
        return iwsHjkktkbn;
    }

    public void setIwsHjkktkbn(String pIwsHjkktkbn) {
        iwsHjkktkbn = pIwsHjkktkbn;
    }

    @Column(order = 11, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsSdpdkbn;

    public String getIwsSdpdkbn() {
        return iwsSdpdkbn;
    }

    public void setIwsSdpdkbn(String pIwsSdpdkbn) {
        iwsSdpdkbn = pIwsSdpdkbn;
    }

    @Column(order = 12, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHaitousiharaikbn;

    public String getIwsHaitousiharaikbn() {
        return iwsHaitousiharaikbn;
    }

    public void setIwsHaitousiharaikbn(String pIwsHaitousiharaikbn) {
        iwsHaitousiharaikbn = pIwsHaitousiharaikbn;
    }

    @Column(order = 13, length = 9)
    @MaxLength(max=9)
    @SingleByteStrings
    @Digit
    private String iwsMoss;

    public String getIwsMoss() {
        return iwsMoss;
    }

    public void setIwsMoss(String pIwsMoss) {
        iwsMoss = pIwsMoss;
    }

    @Column(order = 14, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikamoss;

    public BizNumber getIwsGaikamoss() {
        return iwsGaikamoss;
    }

    public void setIwsGaikamoss(BizNumber pIwsGaikamoss) {
        iwsGaikamoss = pIwsGaikamoss;
    }

    @Column(order = 15, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsKihonp;

    public BizNumber getIwsKihonp() {
        return iwsKihonp;
    }

    public void setIwsKihonp(BizNumber pIwsKihonp) {
        iwsKihonp = pIwsKihonp;
    }

    @Column(order = 16, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikakihonp;

    public BizNumber getIwsGaikakihonp() {
        return iwsGaikakihonp;
    }

    public void setIwsGaikakihonp(BizNumber pIwsGaikakihonp) {
        iwsGaikakihonp = pIwsGaikakihonp;
    }

    @Column(order = 17, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsKyktuukakbn;

    public String getIwsKyktuukakbn() {
        return iwsKyktuukakbn;
    }

    public void setIwsKyktuukakbn(String pIwsKyktuukakbn) {
        iwsKyktuukakbn = pIwsKyktuukakbn;
    }

    @Column(order = 18, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHrktuukakbn;

    public String getIwsHrktuukakbn() {
        return iwsHrktuukakbn;
    }

    public void setIwsHrktuukakbn(String pIwsHrktuukakbn) {
        iwsHrktuukakbn = pIwsHrktuukakbn;
    }

    @Column(order = 19, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsSaimankihyj;

    public String getIwsSaimankihyj() {
        return iwsSaimankihyj;
    }

    public void setIwsSaimankihyj(String pIwsSaimankihyj) {
        iwsSaimankihyj = pIwsSaimankihyj;
    }

    @Column(order = 20, length = 2)
    @MaxLength(max=2)
    private String iwsHknkkn;

    public String getIwsHknkkn() {
        return iwsHknkkn;
    }

    public void setIwsHknkkn(String pIwsHknkkn) {
        iwsHknkkn = pIwsHknkkn;
    }

    @Column(order = 21, length = 2)
    @MaxLength(max=2)
    private String iwsPharaikomikikan;

    public String getIwsPharaikomikikan() {
        return iwsPharaikomikikan;
    }

    public void setIwsPharaikomikikan(String pIwsPharaikomikikan) {
        iwsPharaikomikikan = pIwsPharaikomikikan;
    }

    @Column(order = 22, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHaraikomikaisuukbn;

    public String getIwsHaraikomikaisuukbn() {
        return iwsHaraikomikaisuukbn;
    }

    public void setIwsHaraikomikaisuukbn(String pIwsHaraikomikaisuukbn) {
        iwsHaraikomikaisuukbn = pIwsHaraikomikaisuukbn;
    }

    @Column(order = 23, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHrkkeirokbn;

    public String getIwsHrkkeirokbn() {
        return iwsHrkkeirokbn;
    }

    public void setIwsHrkkeirokbn(String pIwsHrkkeirokbn) {
        iwsHrkkeirokbn = pIwsHrkkeirokbn;
    }

    @Column(order = 24, length = 2)
    @Length(length=2)
    private String iwsTksykmcd1;

    public String getIwsTksykmcd1() {
        return iwsTksykmcd1;
    }

    public void setIwsTksykmcd1(String pIwsTksykmcd1) {
        iwsTksykmcd1 = pIwsTksykmcd1;
    }

    @Column(order = 25, length = 2)
    @Length(length=2)
    private String iwsTksykmcd2;

    public String getIwsTksykmcd2() {
        return iwsTksykmcd2;
    }

    public void setIwsTksykmcd2(String pIwsTksykmcd2) {
        iwsTksykmcd2 = pIwsTksykmcd2;
    }

    @Column(order = 26, length = 2)
    @Length(length=2)
    private String iwsTksykmcd3;

    public String getIwsTksykmcd3() {
        return iwsTksykmcd3;
    }

    public void setIwsTksykmcd3(String pIwsTksykmcd3) {
        iwsTksykmcd3 = pIwsTksykmcd3;
    }

    @Column(order = 27, length = 2)
    @Length(length=2)
    private String iwsTksykmcd4;

    public String getIwsTksykmcd4() {
        return iwsTksykmcd4;
    }

    public void setIwsTksykmcd4(String pIwsTksykmcd4) {
        iwsTksykmcd4 = pIwsTksykmcd4;
    }

    @Column(order = 28, length = 2)
    @Length(length=2)
    private String iwsTksykmcd5;

    public String getIwsTksykmcd5() {
        return iwsTksykmcd5;
    }

    public void setIwsTksykmcd5(String pIwsTksykmcd5) {
        iwsTksykmcd5 = pIwsTksykmcd5;
    }

    @Column(order = 29, length = 1)
    @MaxLength(max=1)
    private String iwsSekmossakuseikbn;

    public String getIwsSekmossakuseikbn() {
        return iwsSekmossakuseikbn;
    }

    public void setIwsSekmossakuseikbn(String pIwsSekmossakuseikbn) {
        iwsSekmossakuseikbn = pIwsSekmossakuseikbn;
    }

    @Column(order = 30, length = 11)
    @MaxLength(max=11)
    @SingleByteStrings
    private String iwsSekno;

    public String getIwsSekno() {
        return iwsSekno;
    }

    public void setIwsSekno(String pIwsSekno) {
        iwsSekno = pIwsSekno;
    }

    @Column(order = 31, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsKykjiyoteiriritu;

    public BizNumber getIwsKykjiyoteiriritu() {
        return iwsKykjiyoteiriritu;
    }

    public void setIwsKykjiyoteiriritu(BizNumber pIwsKykjiyoteiriritu) {
        iwsKykjiyoteiriritu = pIwsKykjiyoteiriritu;
    }

    @Column(order = 32, length = 1)
    private C_HugouKbn iwsKykjisjkkktyusirrtfgu;

    public C_HugouKbn getIwsKykjisjkkktyusirrtfgu() {
        return iwsKykjisjkkktyusirrtfgu;
    }

    public void setIwsKykjisjkkktyusirrtfgu(C_HugouKbn pIwsKykjisjkkktyusirrtfgu) {
        iwsKykjisjkkktyusirrtfgu = pIwsKykjisjkkktyusirrtfgu;
    }

    @Column(order = 33, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsKykjisjkkktyusirrt;

    public BizNumber getIwsKykjisjkkktyusirrt() {
        return iwsKykjisjkkktyusirrt;
    }

    public void setIwsKykjisjkkktyusirrt(BizNumber pIwsKykjisjkkktyusirrt) {
        iwsKykjisjkkktyusirrt = pIwsKykjisjkkktyusirrt;
    }

    @Column(order = 34, length = 2)
    @MaxLength(max=2)
    @SingleByteStrings
    private String iwsHknkkn1;

    public String getIwsHknkkn1() {
        return iwsHknkkn1;
    }

    public void setIwsHknkkn1(String pIwsHknkkn1) {
        iwsHknkkn1 = pIwsHknkkn1;
    }

    @Column(order = 35, length = 1)
    @Length(length=1)
    private String iwsSyksbyensitihsyutkykhyj;

    public String getIwsSyksbyensitihsyutkykhyj() {
        return iwsSyksbyensitihsyutkykhyj;
    }

    public void setIwsSyksbyensitihsyutkykhyj(String pIwsSyksbyensitihsyutkykhyj) {
        iwsSyksbyensitihsyutkykhyj = pIwsSyksbyensitihsyutkykhyj;
    }

    @Column(order = 36, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsKykjitumitateriritu;

    public BizNumber getIwsKykjitumitateriritu() {
        return iwsKykjitumitateriritu;
    }

    public void setIwsKykjitumitateriritu(BizNumber pIwsKykjitumitateriritu) {
        iwsKykjitumitateriritu = pIwsKykjitumitateriritu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
