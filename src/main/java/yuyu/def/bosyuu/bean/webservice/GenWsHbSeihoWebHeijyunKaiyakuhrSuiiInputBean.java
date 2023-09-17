package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;

/**
 * （保険募集）生保Ｗｅｂ平準払終身用解約返戻金推移表作成入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean() {
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
    @MaxLength(max=8)
    @SingleByteStrings
    private String iwsNrkcalckijyunymdstr;

    public String getIwsNrkcalckijyunymdstr() {
        return iwsNrkcalckijyunymdstr;
    }

    public void setIwsNrkcalckijyunymdstr(String pIwsNrkcalckijyunymdstr) {
        iwsNrkcalckijyunymdstr = pIwsNrkcalckijyunymdstr;
    }

    @Column(order = 8, length = 8)
    @MaxLength(max=8)
    @SingleByteStrings
    private String iwsSyoriymdstr;

    public String getIwsSyoriymdstr() {
        return iwsSyoriymdstr;
    }

    public void setIwsSyoriymdstr(String pIwsSyoriymdstr) {
        iwsSyoriymdstr = pIwsSyoriymdstr;
    }

    @Column(order = 9, length = 6)
    private String iwsBosyuuymstr;

    public String getIwsBosyuuymstr() {
        return iwsBosyuuymstr;
    }

    public void setIwsBosyuuymstr(String pIwsBosyuuymstr) {
        iwsBosyuuymstr = pIwsBosyuuymstr;
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
    private String iwsKihonsstr;

    public String getIwsKihonsstr() {
        return iwsKihonsstr;
    }

    public void setIwsKihonsstr(String pIwsKihonsstr) {
        iwsKihonsstr = pIwsKihonsstr;
    }

    @Column(order = 14, length = 13)
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

    @Column(order = 15, length = 10)
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

    @Column(order = 16, length = 13)
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
    private String iwsSaimankihyj;

    public String getIwsSaimankihyj() {
        return iwsSaimankihyj;
    }

    public void setIwsSaimankihyj(String pIwsSaimankihyj) {
        iwsSaimankihyj = pIwsSaimankihyj;
    }

    @Column(order = 19, length = 2)
    @MaxLength(max=2)
    private String iwsHknkkn;

    public String getIwsHknkkn() {
        return iwsHknkkn;
    }

    public void setIwsHknkkn(String pIwsHknkkn) {
        iwsHknkkn = pIwsHknkkn;
    }

    @Column(order = 20, length = 2)
    @MaxLength(max=2)
    @SingleByteStrings
    private String iwsHknkkn1;

    public String getIwsHknkkn1() {
        return iwsHknkkn1;
    }

    public void setIwsHknkkn1(String pIwsHknkkn1) {
        iwsHknkkn1 = pIwsHknkkn1;
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

    @Column(order = 24, length = 4)
    @MaxLength(max=4)
    @SingleByteStrings
    @Digit
    private String iwsKykjiyoteiriritustr;

    public String getIwsKykjiyoteiriritustr() {
        return iwsKykjiyoteiriritustr;
    }

    public void setIwsKykjiyoteiriritustr(String pIwsKykjiyoteiriritustr) {
        iwsKykjiyoteiriritustr = pIwsKykjiyoteiriritustr;
    }

    @Column(order = 25, length = 1)
    @Length(length=1)
    @SingleByteStrings
    private String iwsIkkatubaraikbn;

    public String getIwsIkkatubaraikbn() {
        return iwsIkkatubaraikbn;
    }

    public void setIwsIkkatubaraikbn(String pIwsIkkatubaraikbn) {
        iwsIkkatubaraikbn = pIwsIkkatubaraikbn;
    }

    @Column(order = 26, length = 2)
    @Length(length=2)
    @SingleByteStrings
    private String iwsIkkatubaraikaisuu;

    public String getIwsIkkatubaraikaisuu() {
        return iwsIkkatubaraikaisuu;
    }

    public void setIwsIkkatubaraikaisuu(String pIwsIkkatubaraikaisuu) {
        iwsIkkatubaraikaisuu = pIwsIkkatubaraikaisuu;
    }

    @Column(order = 27, length = 10)
    @MaxLength(max=10)
    @SingleByteStrings
    @Digit
    private String iwsIkkatupstr;

    public String getIwsIkkatupstr() {
        return iwsIkkatupstr;
    }

    public void setIwsIkkatupstr(String pIwsIkkatupstr) {
        iwsIkkatupstr = pIwsIkkatupstr;
    }

    @Column(order = 28, length = 1)
    @Length(length=1)
    private String iwsZennouhyouji;

    public String getIwsZennouhyouji() {
        return iwsZennouhyouji;
    }

    public void setIwsZennouhyouji(String pIwsZennouhyouji) {
        iwsZennouhyouji = pIwsZennouhyouji;
    }

    @Column(order = 29, length = 2)
    @MaxLength(max=2)
    private String iwsZennoukkn;

    public String getIwsZennoukkn() {
        return iwsZennoukkn;
    }

    public void setIwsZennoukkn(String pIwsZennoukkn) {
        iwsZennoukkn = pIwsZennoukkn;
    }

    @Column(order = 30, length = 10)
    @MaxLength(max=10)
    @SingleByteStrings
    @Digit
    private String iwsZennoupstr;

    public String getIwsZennoupstr() {
        return iwsZennoupstr;
    }

    public void setIwsZennoupstr(String pIwsZennoupstr) {
        iwsZennoupstr = pIwsZennoupstr;
    }

    @Column(order = 31, length = 13)
    @MaxLength(max=13)
    @SingleByteStrings
    @Digit
    private String iwsGaikazennoupstr;

    public String getIwsGaikazennoupstr() {
        return iwsGaikazennoupstr;
    }

    public void setIwsGaikazennoupstr(String pIwsGaikazennoupstr) {
        iwsGaikazennoupstr = pIwsGaikazennoupstr;
    }

    @Column(order = 32, length = 2)
    @Length(length=2)
    private String iwsTksykmcd1;

    public String getIwsTksykmcd1() {
        return iwsTksykmcd1;
    }

    public void setIwsTksykmcd1(String pIwsTksykmcd1) {
        iwsTksykmcd1 = pIwsTksykmcd1;
    }

    @Column(order = 33, length = 2)
    @Length(length=2)
    private String iwsTksykmcd2;

    public String getIwsTksykmcd2() {
        return iwsTksykmcd2;
    }

    public void setIwsTksykmcd2(String pIwsTksykmcd2) {
        iwsTksykmcd2 = pIwsTksykmcd2;
    }

    @Column(order = 34, length = 2)
    @Length(length=2)
    private String iwsTksykmcd3;

    public String getIwsTksykmcd3() {
        return iwsTksykmcd3;
    }

    public void setIwsTksykmcd3(String pIwsTksykmcd3) {
        iwsTksykmcd3 = pIwsTksykmcd3;
    }

    @Column(order = 35, length = 2)
    @Length(length=2)
    private String iwsTksykmcd4;

    public String getIwsTksykmcd4() {
        return iwsTksykmcd4;
    }

    public void setIwsTksykmcd4(String pIwsTksykmcd4) {
        iwsTksykmcd4 = pIwsTksykmcd4;
    }

    @Column(order = 36, length = 2)
    @Length(length=2)
    private String iwsTksykmcd5;

    public String getIwsTksykmcd5() {
        return iwsTksykmcd5;
    }

    public void setIwsTksykmcd5(String pIwsTksykmcd5) {
        iwsTksykmcd5 = pIwsTksykmcd5;
    }

    @Column(order = 37, length = 1)
    @MaxLength(max=1)
    private String iwsSekmossakuseikbn;

    public String getIwsSekmossakuseikbn() {
        return iwsSekmossakuseikbn;
    }

    public void setIwsSekmossakuseikbn(String pIwsSekmossakuseikbn) {
        iwsSekmossakuseikbn = pIwsSekmossakuseikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
