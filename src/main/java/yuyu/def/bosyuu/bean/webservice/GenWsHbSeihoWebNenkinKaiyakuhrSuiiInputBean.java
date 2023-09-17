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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.def.classification.C_HugouKbn;

/**
 * （保険募集）生保Ｗｅｂ年金用解約返戻金推移表作成入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebNenkinKaiyakuhrSuiiInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebNenkinKaiyakuhrSuiiInputBean() {
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
    @ValidDate
    private BizDate iwsSyoriymd;

    public BizDate getIwsSyoriymd() {
        return iwsSyoriymd;
    }

    public void setIwsSyoriymd(BizDate pIwsSyoriymd) {
        iwsSyoriymd = pIwsSyoriymd;
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

    @Column(order = 32, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsKykjitumitateriritu;

    public BizNumber getIwsKykjitumitateriritu() {
        return iwsKykjitumitateriritu;
    }

    public void setIwsKykjitumitateriritu(BizNumber pIwsKykjitumitateriritu) {
        iwsKykjitumitateriritu = pIwsKykjitumitateriritu;
    }

    @Column(order = 33, length = 3)
    @RangeBizCalcable(min="0", max="999")
    private BizNumber iwsKykjisetteibairitu;

    public BizNumber getIwsKykjisetteibairitu() {
        return iwsKykjisetteibairitu;
    }

    public void setIwsKykjisetteibairitu(BizNumber pIwsKykjisetteibairitu) {
        iwsKykjisetteibairitu = pIwsKykjisetteibairitu;
    }

    @Column(order = 34, length = 5)
    @RangeBizCalcable(min="0", max="99999")
    private BizNumber iwsKykjiTmttknzkrtjygn;

    public BizNumber getIwsKykjiTmttknzkrtjygn() {
        return iwsKykjiTmttknzkrtjygn;
    }

    public void setIwsKykjiTmttknzkrtjygn(BizNumber pIwsKykjiTmttknzkrtjygn) {
        iwsKykjiTmttknzkrtjygn = pIwsKykjiTmttknzkrtjygn;
    }

    @Column(order = 35, length = 1)
    private C_HugouKbn iwsKykjisjkkktyusirrtfgu;

    public C_HugouKbn getIwsKykjisjkkktyusirrtfgu() {
        return iwsKykjisjkkktyusirrtfgu;
    }

    public void setIwsKykjisjkkktyusirrtfgu(C_HugouKbn pIwsKykjisjkkktyusirrtfgu) {
        iwsKykjisjkkktyusirrtfgu = pIwsKykjisjkkktyusirrtfgu;
    }

    @Column(order = 36, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsKykjisjkkktyusirrt;

    public BizNumber getIwsKykjisjkkktyusirrt() {
        return iwsKykjisjkkktyusirrt;
    }

    public void setIwsKykjisjkkktyusirrt(BizNumber pIwsKykjisjkkktyusirrt) {
        iwsKykjisjkkktyusirrt = pIwsKykjisjkkktyusirrt;
    }

    @Column(order = 37, length = 5)
    @RangeBizCalcable(min="0", max="99999")
    private BizNumber iwsKykjirendouritu;

    public BizNumber getIwsKykjirendouritu() {
        return iwsKykjirendouritu;
    }

    public void setIwsKykjirendouritu(BizNumber pIwsKykjirendouritu) {
        iwsKykjirendouritu = pIwsKykjirendouritu;
    }

    @Column(order = 38, length = 2)
    @Length(length=2)
    private String iwsSueokikkn;

    public String getIwsSueokikkn() {
        return iwsSueokikkn;
    }

    public void setIwsSueokikkn(String pIwsSueokikkn) {
        iwsSueokikkn = pIwsSueokikkn;
    }

    @Column(order = 39, length = 1)
    @Length(length=1)
    private String iwsNksyukbn;

    public String getIwsNksyukbn() {
        return iwsNksyukbn;
    }

    public void setIwsNksyukbn(String pIwsNksyukbn) {
        iwsNksyukbn = pIwsNksyukbn;
    }

    @Column(order = 40, length = 3)
    @Length(length=3)
    private String iwsSisuurendouhbnwr;

    public String getIwsSisuurendouhbnwr() {
        return iwsSisuurendouhbnwr;
    }

    public void setIwsSisuurendouhbnwr(String pIwsSisuurendouhbnwr) {
        iwsSisuurendouhbnwr = pIwsSisuurendouhbnwr;
    }

    @Column(order = 41, length = 3)
    @Length(length=3)
    private String iwsTeiritutumitatehbnwr;

    public String getIwsTeiritutumitatehbnwr() {
        return iwsTeiritutumitatehbnwr;
    }

    public void setIwsTeiritutumitatehbnwr(String pIwsTeiritutumitatehbnwr) {
        iwsTeiritutumitatehbnwr = pIwsTeiritutumitatehbnwr;
    }

    @Column(order = 42, length = 1)
    @Length(length=1)
    @SingleByteStrings
    private String iwsIkkatubaraikbn;

    public String getIwsIkkatubaraikbn() {
        return iwsIkkatubaraikbn;
    }

    public void setIwsIkkatubaraikbn(String pIwsIkkatubaraikbn) {
        iwsIkkatubaraikbn = pIwsIkkatubaraikbn;
    }

    @Column(order = 43, length = 2)
    @Length(length=2)
    @SingleByteStrings
    private String iwsIkkatubaraikaisuu;

    public String getIwsIkkatubaraikaisuu() {
        return iwsIkkatubaraikaisuu;
    }

    public void setIwsIkkatubaraikaisuu(String pIwsIkkatubaraikaisuu) {
        iwsIkkatubaraikaisuu = pIwsIkkatubaraikaisuu;
    }

    @Column(order = 44, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsikkatup;

    public BizNumber getIwsikkatup() {
        return iwsikkatup;
    }

    public void setIwsikkatup(BizNumber pIwsikkatup) {
        iwsikkatup = pIwsikkatup;
    }

    @Column(order = 45, length = 1)
    @Length(length=1)
    private String iwsZennouhyouji;

    public String getIwsZennouhyouji() {
        return iwsZennouhyouji;
    }

    public void setIwsZennouhyouji(String pIwsZennouhyouji) {
        iwsZennouhyouji = pIwsZennouhyouji;
    }

    @Column(order = 46, length = 2)
    @MaxLength(max=2)
    private String iwsZennoukkn;

    public String getIwsZennoukkn() {
        return iwsZennoukkn;
    }

    public void setIwsZennoukkn(String pIwsZennoukkn) {
        iwsZennoukkn = pIwsZennoukkn;
    }

    @Column(order = 47, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsZennoup;

    public BizNumber getIwsZennoup() {
        return iwsZennoup;
    }

    public void setIwsZennoup(BizNumber pIwsZennoup) {
        iwsZennoup = pIwsZennoup;
    }

    @Column(order = 48, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsKeisanjiyoteiriritu1;

    public BizNumber getIwsKeisanjiyoteiriritu1() {
        return iwsKeisanjiyoteiriritu1;
    }

    public void setIwsKeisanjiyoteiriritu1(BizNumber pIwsKeisanjiyoteiriritu1) {
        iwsKeisanjiyoteiriritu1 = pIwsKeisanjiyoteiriritu1;
    }

    @Column(order = 49, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsKeisanjiyoteiriritu2;

    public BizNumber getIwsKeisanjiyoteiriritu2() {
        return iwsKeisanjiyoteiriritu2;
    }

    public void setIwsKeisanjiyoteiriritu2(BizNumber pIwsKeisanjiyoteiriritu2) {
        iwsKeisanjiyoteiriritu2 = pIwsKeisanjiyoteiriritu2;
    }

    @Column(order = 50, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsKeisanjiyoteiriritu3;

    public BizNumber getIwsKeisanjiyoteiriritu3() {
        return iwsKeisanjiyoteiriritu3;
    }

    public void setIwsKeisanjiyoteiriritu3(BizNumber pIwsKeisanjiyoteiriritu3) {
        iwsKeisanjiyoteiriritu3 = pIwsKeisanjiyoteiriritu3;
    }

    @Column(order = 51, length = 5)
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

    @Column(order = 52, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsHrktuukasyukykp;

    public BizNumber getIwsHrktuukasyukykp() {
        return iwsHrktuukasyukykp;
    }

    public void setIwsHrktuukasyukykp(BizNumber pIwsHrktuukasyukykp) {
        iwsHrktuukasyukykp = pIwsHrktuukasyukykp;
    }

    @Column(order = 53, length = 1)
    @Length(length=1)
    private String iwsJiyuusekkeiyouhikbn;

    public String getIwsJiyuusekkeiyouhikbn() {
        return iwsJiyuusekkeiyouhikbn;
    }

    public void setIwsJiyuusekkeiyouhikbn(String pIwsJiyuusekkeiyouhikbn) {
        iwsJiyuusekkeiyouhikbn = pIwsJiyuusekkeiyouhikbn;
    }

    @Column(order = 54, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu1x1;

    public BizNumber getIwsJiyuuseksisuukeisuu1x1() {
        return iwsJiyuuseksisuukeisuu1x1;
    }

    public void setIwsJiyuuseksisuukeisuu1x1(BizNumber pIwsJiyuuseksisuukeisuu1x1) {
        iwsJiyuuseksisuukeisuu1x1 = pIwsJiyuuseksisuukeisuu1x1;
    }

    @Column(order = 55, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu1x2;

    public BizNumber getIwsJiyuuseksisuukeisuu1x2() {
        return iwsJiyuuseksisuukeisuu1x2;
    }

    public void setIwsJiyuuseksisuukeisuu1x2(BizNumber pIwsJiyuuseksisuukeisuu1x2) {
        iwsJiyuuseksisuukeisuu1x2 = pIwsJiyuuseksisuukeisuu1x2;
    }

    @Column(order = 56, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu1x3;

    public BizNumber getIwsJiyuuseksisuukeisuu1x3() {
        return iwsJiyuuseksisuukeisuu1x3;
    }

    public void setIwsJiyuuseksisuukeisuu1x3(BizNumber pIwsJiyuuseksisuukeisuu1x3) {
        iwsJiyuuseksisuukeisuu1x3 = pIwsJiyuuseksisuukeisuu1x3;
    }

    @Column(order = 57, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu1x4;

    public BizNumber getIwsJiyuuseksisuukeisuu1x4() {
        return iwsJiyuuseksisuukeisuu1x4;
    }

    public void setIwsJiyuuseksisuukeisuu1x4(BizNumber pIwsJiyuuseksisuukeisuu1x4) {
        iwsJiyuuseksisuukeisuu1x4 = pIwsJiyuuseksisuukeisuu1x4;
    }

    @Column(order = 58, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu1x5;

    public BizNumber getIwsJiyuuseksisuukeisuu1x5() {
        return iwsJiyuuseksisuukeisuu1x5;
    }

    public void setIwsJiyuuseksisuukeisuu1x5(BizNumber pIwsJiyuuseksisuukeisuu1x5) {
        iwsJiyuuseksisuukeisuu1x5 = pIwsJiyuuseksisuukeisuu1x5;
    }

    @Column(order = 59, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu1x6;

    public BizNumber getIwsJiyuuseksisuukeisuu1x6() {
        return iwsJiyuuseksisuukeisuu1x6;
    }

    public void setIwsJiyuuseksisuukeisuu1x6(BizNumber pIwsJiyuuseksisuukeisuu1x6) {
        iwsJiyuuseksisuukeisuu1x6 = pIwsJiyuuseksisuukeisuu1x6;
    }

    @Column(order = 60, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu1x7;

    public BizNumber getIwsJiyuuseksisuukeisuu1x7() {
        return iwsJiyuuseksisuukeisuu1x7;
    }

    public void setIwsJiyuuseksisuukeisuu1x7(BizNumber pIwsJiyuuseksisuukeisuu1x7) {
        iwsJiyuuseksisuukeisuu1x7 = pIwsJiyuuseksisuukeisuu1x7;
    }

    @Column(order = 61, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu1x8;

    public BizNumber getIwsJiyuuseksisuukeisuu1x8() {
        return iwsJiyuuseksisuukeisuu1x8;
    }

    public void setIwsJiyuuseksisuukeisuu1x8(BizNumber pIwsJiyuuseksisuukeisuu1x8) {
        iwsJiyuuseksisuukeisuu1x8 = pIwsJiyuuseksisuukeisuu1x8;
    }

    @Column(order = 62, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu1x9;

    public BizNumber getIwsJiyuuseksisuukeisuu1x9() {
        return iwsJiyuuseksisuukeisuu1x9;
    }

    public void setIwsJiyuuseksisuukeisuu1x9(BizNumber pIwsJiyuuseksisuukeisuu1x9) {
        iwsJiyuuseksisuukeisuu1x9 = pIwsJiyuuseksisuukeisuu1x9;
    }

    @Column(order = 63, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu1x10;

    public BizNumber getIwsJiyuuseksisuukeisuu1x10() {
        return iwsJiyuuseksisuukeisuu1x10;
    }

    public void setIwsJiyuuseksisuukeisuu1x10(BizNumber pIwsJiyuuseksisuukeisuu1x10) {
        iwsJiyuuseksisuukeisuu1x10 = pIwsJiyuuseksisuukeisuu1x10;
    }

    @Column(order = 64, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu2x1;

    public BizNumber getIwsJiyuuseksisuukeisuu2x1() {
        return iwsJiyuuseksisuukeisuu2x1;
    }

    public void setIwsJiyuuseksisuukeisuu2x1(BizNumber pIwsJiyuuseksisuukeisuu2x1) {
        iwsJiyuuseksisuukeisuu2x1 = pIwsJiyuuseksisuukeisuu2x1;
    }

    @Column(order = 65, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu2x2;

    public BizNumber getIwsJiyuuseksisuukeisuu2x2() {
        return iwsJiyuuseksisuukeisuu2x2;
    }

    public void setIwsJiyuuseksisuukeisuu2x2(BizNumber pIwsJiyuuseksisuukeisuu2x2) {
        iwsJiyuuseksisuukeisuu2x2 = pIwsJiyuuseksisuukeisuu2x2;
    }

    @Column(order = 66, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu2x3;

    public BizNumber getIwsJiyuuseksisuukeisuu2x3() {
        return iwsJiyuuseksisuukeisuu2x3;
    }

    public void setIwsJiyuuseksisuukeisuu2x3(BizNumber pIwsJiyuuseksisuukeisuu2x3) {
        iwsJiyuuseksisuukeisuu2x3 = pIwsJiyuuseksisuukeisuu2x3;
    }

    @Column(order = 67, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu2x4;

    public BizNumber getIwsJiyuuseksisuukeisuu2x4() {
        return iwsJiyuuseksisuukeisuu2x4;
    }

    public void setIwsJiyuuseksisuukeisuu2x4(BizNumber pIwsJiyuuseksisuukeisuu2x4) {
        iwsJiyuuseksisuukeisuu2x4 = pIwsJiyuuseksisuukeisuu2x4;
    }

    @Column(order = 68, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu2x5;

    public BizNumber getIwsJiyuuseksisuukeisuu2x5() {
        return iwsJiyuuseksisuukeisuu2x5;
    }

    public void setIwsJiyuuseksisuukeisuu2x5(BizNumber pIwsJiyuuseksisuukeisuu2x5) {
        iwsJiyuuseksisuukeisuu2x5 = pIwsJiyuuseksisuukeisuu2x5;
    }

    @Column(order = 69, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu2x6;

    public BizNumber getIwsJiyuuseksisuukeisuu2x6() {
        return iwsJiyuuseksisuukeisuu2x6;
    }

    public void setIwsJiyuuseksisuukeisuu2x6(BizNumber pIwsJiyuuseksisuukeisuu2x6) {
        iwsJiyuuseksisuukeisuu2x6 = pIwsJiyuuseksisuukeisuu2x6;
    }

    @Column(order = 70, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu2x7;

    public BizNumber getIwsJiyuuseksisuukeisuu2x7() {
        return iwsJiyuuseksisuukeisuu2x7;
    }

    public void setIwsJiyuuseksisuukeisuu2x7(BizNumber pIwsJiyuuseksisuukeisuu2x7) {
        iwsJiyuuseksisuukeisuu2x7 = pIwsJiyuuseksisuukeisuu2x7;
    }

    @Column(order = 71, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu2x8;

    public BizNumber getIwsJiyuuseksisuukeisuu2x8() {
        return iwsJiyuuseksisuukeisuu2x8;
    }

    public void setIwsJiyuuseksisuukeisuu2x8(BizNumber pIwsJiyuuseksisuukeisuu2x8) {
        iwsJiyuuseksisuukeisuu2x8 = pIwsJiyuuseksisuukeisuu2x8;
    }

    @Column(order = 72, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu2x9;

    public BizNumber getIwsJiyuuseksisuukeisuu2x9() {
        return iwsJiyuuseksisuukeisuu2x9;
    }

    public void setIwsJiyuuseksisuukeisuu2x9(BizNumber pIwsJiyuuseksisuukeisuu2x9) {
        iwsJiyuuseksisuukeisuu2x9 = pIwsJiyuuseksisuukeisuu2x9;
    }

    @Column(order = 73, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu2x10;

    public BizNumber getIwsJiyuuseksisuukeisuu2x10() {
        return iwsJiyuuseksisuukeisuu2x10;
    }

    public void setIwsJiyuuseksisuukeisuu2x10(BizNumber pIwsJiyuuseksisuukeisuu2x10) {
        iwsJiyuuseksisuukeisuu2x10 = pIwsJiyuuseksisuukeisuu2x10;
    }

    @Column(order = 74, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu3x1;

    public BizNumber getIwsJiyuuseksisuukeisuu3x1() {
        return iwsJiyuuseksisuukeisuu3x1;
    }

    public void setIwsJiyuuseksisuukeisuu3x1(BizNumber pIwsJiyuuseksisuukeisuu3x1) {
        iwsJiyuuseksisuukeisuu3x1 = pIwsJiyuuseksisuukeisuu3x1;
    }

    @Column(order = 75, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu3x2;

    public BizNumber getIwsJiyuuseksisuukeisuu3x2() {
        return iwsJiyuuseksisuukeisuu3x2;
    }

    public void setIwsJiyuuseksisuukeisuu3x2(BizNumber pIwsJiyuuseksisuukeisuu3x2) {
        iwsJiyuuseksisuukeisuu3x2 = pIwsJiyuuseksisuukeisuu3x2;
    }

    @Column(order = 76, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu3x3;

    public BizNumber getIwsJiyuuseksisuukeisuu3x3() {
        return iwsJiyuuseksisuukeisuu3x3;
    }

    public void setIwsJiyuuseksisuukeisuu3x3(BizNumber pIwsJiyuuseksisuukeisuu3x3) {
        iwsJiyuuseksisuukeisuu3x3 = pIwsJiyuuseksisuukeisuu3x3;
    }

    @Column(order = 77, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu3x4;

    public BizNumber getIwsJiyuuseksisuukeisuu3x4() {
        return iwsJiyuuseksisuukeisuu3x4;
    }

    public void setIwsJiyuuseksisuukeisuu3x4(BizNumber pIwsJiyuuseksisuukeisuu3x4) {
        iwsJiyuuseksisuukeisuu3x4 = pIwsJiyuuseksisuukeisuu3x4;
    }

    @Column(order = 78, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu3x5;

    public BizNumber getIwsJiyuuseksisuukeisuu3x5() {
        return iwsJiyuuseksisuukeisuu3x5;
    }

    public void setIwsJiyuuseksisuukeisuu3x5(BizNumber pIwsJiyuuseksisuukeisuu3x5) {
        iwsJiyuuseksisuukeisuu3x5 = pIwsJiyuuseksisuukeisuu3x5;
    }

    @Column(order = 79, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu3x6;

    public BizNumber getIwsJiyuuseksisuukeisuu3x6() {
        return iwsJiyuuseksisuukeisuu3x6;
    }

    public void setIwsJiyuuseksisuukeisuu3x6(BizNumber pIwsJiyuuseksisuukeisuu3x6) {
        iwsJiyuuseksisuukeisuu3x6 = pIwsJiyuuseksisuukeisuu3x6;
    }

    @Column(order = 80, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu3x7;

    public BizNumber getIwsJiyuuseksisuukeisuu3x7() {
        return iwsJiyuuseksisuukeisuu3x7;
    }

    public void setIwsJiyuuseksisuukeisuu3x7(BizNumber pIwsJiyuuseksisuukeisuu3x7) {
        iwsJiyuuseksisuukeisuu3x7 = pIwsJiyuuseksisuukeisuu3x7;
    }

    @Column(order = 81, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu3x8;

    public BizNumber getIwsJiyuuseksisuukeisuu3x8() {
        return iwsJiyuuseksisuukeisuu3x8;
    }

    public void setIwsJiyuuseksisuukeisuu3x8(BizNumber pIwsJiyuuseksisuukeisuu3x8) {
        iwsJiyuuseksisuukeisuu3x8 = pIwsJiyuuseksisuukeisuu3x8;
    }

    @Column(order = 82, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu3x9;

    public BizNumber getIwsJiyuuseksisuukeisuu3x9() {
        return iwsJiyuuseksisuukeisuu3x9;
    }

    public void setIwsJiyuuseksisuukeisuu3x9(BizNumber pIwsJiyuuseksisuukeisuu3x9) {
        iwsJiyuuseksisuukeisuu3x9 = pIwsJiyuuseksisuukeisuu3x9;
    }

    @Column(order = 83, length = 4)
    @RangeBizCalcable(min="0", max="9999")
    private BizNumber iwsJiyuuseksisuukeisuu3x10;

    public BizNumber getIwsJiyuuseksisuukeisuu3x10() {
        return iwsJiyuuseksisuukeisuu3x10;
    }

    public void setIwsJiyuuseksisuukeisuu3x10(BizNumber pIwsJiyuuseksisuukeisuu3x10) {
        iwsJiyuuseksisuukeisuu3x10 = pIwsJiyuuseksisuukeisuu3x10;
    }

    @Column(order = 84, length = 1)
    @Length(length=1)
    private String iwsTeikisiharaitkarihyj;

    public String getIwsTeikisiharaitkarihyj() {
        return iwsTeikisiharaitkarihyj;
    }

    public void setIwsTeikisiharaitkarihyj(String pIwsTeikisiharaitkarihyj) {
        iwsTeikisiharaitkarihyj = pIwsTeikisiharaitkarihyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
