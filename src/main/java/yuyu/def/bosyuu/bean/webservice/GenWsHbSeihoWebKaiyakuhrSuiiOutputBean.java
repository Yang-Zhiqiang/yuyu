package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_HugouKbn;

/**
 * （保険募集）生保Ｗｅｂ解約返戻金推移表作成出力ＢＥＡＮ データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebKaiyakuhrSuiiOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebKaiyakuhrSuiiOutputBean() {
    }

    @Column(order = 1, length = 1)
    private String iwsErrkbn;

    public String getIwsErrkbn() {
        return iwsErrkbn;
    }

    public void setIwsErrkbn(String pIwsErrkbn) {
        iwsErrkbn = pIwsErrkbn;
    }

    @Column(order = 2, length = 40)
    @MultiByte
    private String iwsSekmoserrormsg1;

    public String getIwsSekmoserrormsg1() {
        return iwsSekmoserrormsg1;
    }

    public void setIwsSekmoserrormsg1(String pIwsSekmoserrormsg1) {
        iwsSekmoserrormsg1 = pIwsSekmoserrormsg1;
    }

    @Column(order = 3, length = 40)
    @MultiByte
    private String iwsSekmoserrormsg2;

    public String getIwsSekmoserrormsg2() {
        return iwsSekmoserrormsg2;
    }

    public void setIwsSekmoserrormsg2(String pIwsSekmoserrormsg2) {
        iwsSekmoserrormsg2 = pIwsSekmoserrormsg2;
    }

    @Column(order = 4, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x1;

    public BizNumber getIwsMaitosikaiyakuhr1x1() {
        return iwsMaitosikaiyakuhr1x1;
    }

    public void setIwsMaitosikaiyakuhr1x1(BizNumber pIwsMaitosikaiyakuhr1x1) {
        iwsMaitosikaiyakuhr1x1 = pIwsMaitosikaiyakuhr1x1;
    }

    @Column(order = 5, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x2;

    public BizNumber getIwsMaitosikaiyakuhr1x2() {
        return iwsMaitosikaiyakuhr1x2;
    }

    public void setIwsMaitosikaiyakuhr1x2(BizNumber pIwsMaitosikaiyakuhr1x2) {
        iwsMaitosikaiyakuhr1x2 = pIwsMaitosikaiyakuhr1x2;
    }

    @Column(order = 6, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x3;

    public BizNumber getIwsMaitosikaiyakuhr1x3() {
        return iwsMaitosikaiyakuhr1x3;
    }

    public void setIwsMaitosikaiyakuhr1x3(BizNumber pIwsMaitosikaiyakuhr1x3) {
        iwsMaitosikaiyakuhr1x3 = pIwsMaitosikaiyakuhr1x3;
    }

    @Column(order = 7, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x4;

    public BizNumber getIwsMaitosikaiyakuhr1x4() {
        return iwsMaitosikaiyakuhr1x4;
    }

    public void setIwsMaitosikaiyakuhr1x4(BizNumber pIwsMaitosikaiyakuhr1x4) {
        iwsMaitosikaiyakuhr1x4 = pIwsMaitosikaiyakuhr1x4;
    }

    @Column(order = 8, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x5;

    public BizNumber getIwsMaitosikaiyakuhr1x5() {
        return iwsMaitosikaiyakuhr1x5;
    }

    public void setIwsMaitosikaiyakuhr1x5(BizNumber pIwsMaitosikaiyakuhr1x5) {
        iwsMaitosikaiyakuhr1x5 = pIwsMaitosikaiyakuhr1x5;
    }

    @Column(order = 9, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x6;

    public BizNumber getIwsMaitosikaiyakuhr1x6() {
        return iwsMaitosikaiyakuhr1x6;
    }

    public void setIwsMaitosikaiyakuhr1x6(BizNumber pIwsMaitosikaiyakuhr1x6) {
        iwsMaitosikaiyakuhr1x6 = pIwsMaitosikaiyakuhr1x6;
    }

    @Column(order = 10, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x7;

    public BizNumber getIwsMaitosikaiyakuhr1x7() {
        return iwsMaitosikaiyakuhr1x7;
    }

    public void setIwsMaitosikaiyakuhr1x7(BizNumber pIwsMaitosikaiyakuhr1x7) {
        iwsMaitosikaiyakuhr1x7 = pIwsMaitosikaiyakuhr1x7;
    }

    @Column(order = 11, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x8;

    public BizNumber getIwsMaitosikaiyakuhr1x8() {
        return iwsMaitosikaiyakuhr1x8;
    }

    public void setIwsMaitosikaiyakuhr1x8(BizNumber pIwsMaitosikaiyakuhr1x8) {
        iwsMaitosikaiyakuhr1x8 = pIwsMaitosikaiyakuhr1x8;
    }

    @Column(order = 12, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x9;

    public BizNumber getIwsMaitosikaiyakuhr1x9() {
        return iwsMaitosikaiyakuhr1x9;
    }

    public void setIwsMaitosikaiyakuhr1x9(BizNumber pIwsMaitosikaiyakuhr1x9) {
        iwsMaitosikaiyakuhr1x9 = pIwsMaitosikaiyakuhr1x9;
    }

    @Column(order = 13, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x10;

    public BizNumber getIwsMaitosikaiyakuhr1x10() {
        return iwsMaitosikaiyakuhr1x10;
    }

    public void setIwsMaitosikaiyakuhr1x10(BizNumber pIwsMaitosikaiyakuhr1x10) {
        iwsMaitosikaiyakuhr1x10 = pIwsMaitosikaiyakuhr1x10;
    }

    @Column(order = 14, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x11;

    public BizNumber getIwsMaitosikaiyakuhr1x11() {
        return iwsMaitosikaiyakuhr1x11;
    }

    public void setIwsMaitosikaiyakuhr1x11(BizNumber pIwsMaitosikaiyakuhr1x11) {
        iwsMaitosikaiyakuhr1x11 = pIwsMaitosikaiyakuhr1x11;
    }

    @Column(order = 15, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x12;

    public BizNumber getIwsMaitosikaiyakuhr1x12() {
        return iwsMaitosikaiyakuhr1x12;
    }

    public void setIwsMaitosikaiyakuhr1x12(BizNumber pIwsMaitosikaiyakuhr1x12) {
        iwsMaitosikaiyakuhr1x12 = pIwsMaitosikaiyakuhr1x12;
    }

    @Column(order = 16, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x13;

    public BizNumber getIwsMaitosikaiyakuhr1x13() {
        return iwsMaitosikaiyakuhr1x13;
    }

    public void setIwsMaitosikaiyakuhr1x13(BizNumber pIwsMaitosikaiyakuhr1x13) {
        iwsMaitosikaiyakuhr1x13 = pIwsMaitosikaiyakuhr1x13;
    }

    @Column(order = 17, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x14;

    public BizNumber getIwsMaitosikaiyakuhr1x14() {
        return iwsMaitosikaiyakuhr1x14;
    }

    public void setIwsMaitosikaiyakuhr1x14(BizNumber pIwsMaitosikaiyakuhr1x14) {
        iwsMaitosikaiyakuhr1x14 = pIwsMaitosikaiyakuhr1x14;
    }

    @Column(order = 18, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x15;

    public BizNumber getIwsMaitosikaiyakuhr1x15() {
        return iwsMaitosikaiyakuhr1x15;
    }

    public void setIwsMaitosikaiyakuhr1x15(BizNumber pIwsMaitosikaiyakuhr1x15) {
        iwsMaitosikaiyakuhr1x15 = pIwsMaitosikaiyakuhr1x15;
    }

    @Column(order = 19, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x16;

    public BizNumber getIwsMaitosikaiyakuhr1x16() {
        return iwsMaitosikaiyakuhr1x16;
    }

    public void setIwsMaitosikaiyakuhr1x16(BizNumber pIwsMaitosikaiyakuhr1x16) {
        iwsMaitosikaiyakuhr1x16 = pIwsMaitosikaiyakuhr1x16;
    }

    @Column(order = 20, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x17;

    public BizNumber getIwsMaitosikaiyakuhr1x17() {
        return iwsMaitosikaiyakuhr1x17;
    }

    public void setIwsMaitosikaiyakuhr1x17(BizNumber pIwsMaitosikaiyakuhr1x17) {
        iwsMaitosikaiyakuhr1x17 = pIwsMaitosikaiyakuhr1x17;
    }

    @Column(order = 21, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x18;

    public BizNumber getIwsMaitosikaiyakuhr1x18() {
        return iwsMaitosikaiyakuhr1x18;
    }

    public void setIwsMaitosikaiyakuhr1x18(BizNumber pIwsMaitosikaiyakuhr1x18) {
        iwsMaitosikaiyakuhr1x18 = pIwsMaitosikaiyakuhr1x18;
    }

    @Column(order = 22, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x19;

    public BizNumber getIwsMaitosikaiyakuhr1x19() {
        return iwsMaitosikaiyakuhr1x19;
    }

    public void setIwsMaitosikaiyakuhr1x19(BizNumber pIwsMaitosikaiyakuhr1x19) {
        iwsMaitosikaiyakuhr1x19 = pIwsMaitosikaiyakuhr1x19;
    }

    @Column(order = 23, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x20;

    public BizNumber getIwsMaitosikaiyakuhr1x20() {
        return iwsMaitosikaiyakuhr1x20;
    }

    public void setIwsMaitosikaiyakuhr1x20(BizNumber pIwsMaitosikaiyakuhr1x20) {
        iwsMaitosikaiyakuhr1x20 = pIwsMaitosikaiyakuhr1x20;
    }

    @Column(order = 24, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x21;

    public BizNumber getIwsMaitosikaiyakuhr1x21() {
        return iwsMaitosikaiyakuhr1x21;
    }

    public void setIwsMaitosikaiyakuhr1x21(BizNumber pIwsMaitosikaiyakuhr1x21) {
        iwsMaitosikaiyakuhr1x21 = pIwsMaitosikaiyakuhr1x21;
    }

    @Column(order = 25, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x22;

    public BizNumber getIwsMaitosikaiyakuhr1x22() {
        return iwsMaitosikaiyakuhr1x22;
    }

    public void setIwsMaitosikaiyakuhr1x22(BizNumber pIwsMaitosikaiyakuhr1x22) {
        iwsMaitosikaiyakuhr1x22 = pIwsMaitosikaiyakuhr1x22;
    }

    @Column(order = 26, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x23;

    public BizNumber getIwsMaitosikaiyakuhr1x23() {
        return iwsMaitosikaiyakuhr1x23;
    }

    public void setIwsMaitosikaiyakuhr1x23(BizNumber pIwsMaitosikaiyakuhr1x23) {
        iwsMaitosikaiyakuhr1x23 = pIwsMaitosikaiyakuhr1x23;
    }

    @Column(order = 27, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x24;

    public BizNumber getIwsMaitosikaiyakuhr1x24() {
        return iwsMaitosikaiyakuhr1x24;
    }

    public void setIwsMaitosikaiyakuhr1x24(BizNumber pIwsMaitosikaiyakuhr1x24) {
        iwsMaitosikaiyakuhr1x24 = pIwsMaitosikaiyakuhr1x24;
    }

    @Column(order = 28, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x25;

    public BizNumber getIwsMaitosikaiyakuhr1x25() {
        return iwsMaitosikaiyakuhr1x25;
    }

    public void setIwsMaitosikaiyakuhr1x25(BizNumber pIwsMaitosikaiyakuhr1x25) {
        iwsMaitosikaiyakuhr1x25 = pIwsMaitosikaiyakuhr1x25;
    }

    @Column(order = 29, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x26;

    public BizNumber getIwsMaitosikaiyakuhr1x26() {
        return iwsMaitosikaiyakuhr1x26;
    }

    public void setIwsMaitosikaiyakuhr1x26(BizNumber pIwsMaitosikaiyakuhr1x26) {
        iwsMaitosikaiyakuhr1x26 = pIwsMaitosikaiyakuhr1x26;
    }

    @Column(order = 30, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x27;

    public BizNumber getIwsMaitosikaiyakuhr1x27() {
        return iwsMaitosikaiyakuhr1x27;
    }

    public void setIwsMaitosikaiyakuhr1x27(BizNumber pIwsMaitosikaiyakuhr1x27) {
        iwsMaitosikaiyakuhr1x27 = pIwsMaitosikaiyakuhr1x27;
    }

    @Column(order = 31, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x28;

    public BizNumber getIwsMaitosikaiyakuhr1x28() {
        return iwsMaitosikaiyakuhr1x28;
    }

    public void setIwsMaitosikaiyakuhr1x28(BizNumber pIwsMaitosikaiyakuhr1x28) {
        iwsMaitosikaiyakuhr1x28 = pIwsMaitosikaiyakuhr1x28;
    }

    @Column(order = 32, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x29;

    public BizNumber getIwsMaitosikaiyakuhr1x29() {
        return iwsMaitosikaiyakuhr1x29;
    }

    public void setIwsMaitosikaiyakuhr1x29(BizNumber pIwsMaitosikaiyakuhr1x29) {
        iwsMaitosikaiyakuhr1x29 = pIwsMaitosikaiyakuhr1x29;
    }

    @Column(order = 33, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x30;

    public BizNumber getIwsMaitosikaiyakuhr1x30() {
        return iwsMaitosikaiyakuhr1x30;
    }

    public void setIwsMaitosikaiyakuhr1x30(BizNumber pIwsMaitosikaiyakuhr1x30) {
        iwsMaitosikaiyakuhr1x30 = pIwsMaitosikaiyakuhr1x30;
    }

    @Column(order = 34, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x31;

    public BizNumber getIwsMaitosikaiyakuhr1x31() {
        return iwsMaitosikaiyakuhr1x31;
    }

    public void setIwsMaitosikaiyakuhr1x31(BizNumber pIwsMaitosikaiyakuhr1x31) {
        iwsMaitosikaiyakuhr1x31 = pIwsMaitosikaiyakuhr1x31;
    }

    @Column(order = 35, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x32;

    public BizNumber getIwsMaitosikaiyakuhr1x32() {
        return iwsMaitosikaiyakuhr1x32;
    }

    public void setIwsMaitosikaiyakuhr1x32(BizNumber pIwsMaitosikaiyakuhr1x32) {
        iwsMaitosikaiyakuhr1x32 = pIwsMaitosikaiyakuhr1x32;
    }

    @Column(order = 36, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x33;

    public BizNumber getIwsMaitosikaiyakuhr1x33() {
        return iwsMaitosikaiyakuhr1x33;
    }

    public void setIwsMaitosikaiyakuhr1x33(BizNumber pIwsMaitosikaiyakuhr1x33) {
        iwsMaitosikaiyakuhr1x33 = pIwsMaitosikaiyakuhr1x33;
    }

    @Column(order = 37, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x34;

    public BizNumber getIwsMaitosikaiyakuhr1x34() {
        return iwsMaitosikaiyakuhr1x34;
    }

    public void setIwsMaitosikaiyakuhr1x34(BizNumber pIwsMaitosikaiyakuhr1x34) {
        iwsMaitosikaiyakuhr1x34 = pIwsMaitosikaiyakuhr1x34;
    }

    @Column(order = 38, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x35;

    public BizNumber getIwsMaitosikaiyakuhr1x35() {
        return iwsMaitosikaiyakuhr1x35;
    }

    public void setIwsMaitosikaiyakuhr1x35(BizNumber pIwsMaitosikaiyakuhr1x35) {
        iwsMaitosikaiyakuhr1x35 = pIwsMaitosikaiyakuhr1x35;
    }

    @Column(order = 39, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x36;

    public BizNumber getIwsMaitosikaiyakuhr1x36() {
        return iwsMaitosikaiyakuhr1x36;
    }

    public void setIwsMaitosikaiyakuhr1x36(BizNumber pIwsMaitosikaiyakuhr1x36) {
        iwsMaitosikaiyakuhr1x36 = pIwsMaitosikaiyakuhr1x36;
    }

    @Column(order = 40, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x37;

    public BizNumber getIwsMaitosikaiyakuhr1x37() {
        return iwsMaitosikaiyakuhr1x37;
    }

    public void setIwsMaitosikaiyakuhr1x37(BizNumber pIwsMaitosikaiyakuhr1x37) {
        iwsMaitosikaiyakuhr1x37 = pIwsMaitosikaiyakuhr1x37;
    }

    @Column(order = 41, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x38;

    public BizNumber getIwsMaitosikaiyakuhr1x38() {
        return iwsMaitosikaiyakuhr1x38;
    }

    public void setIwsMaitosikaiyakuhr1x38(BizNumber pIwsMaitosikaiyakuhr1x38) {
        iwsMaitosikaiyakuhr1x38 = pIwsMaitosikaiyakuhr1x38;
    }

    @Column(order = 42, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x39;

    public BizNumber getIwsMaitosikaiyakuhr1x39() {
        return iwsMaitosikaiyakuhr1x39;
    }

    public void setIwsMaitosikaiyakuhr1x39(BizNumber pIwsMaitosikaiyakuhr1x39) {
        iwsMaitosikaiyakuhr1x39 = pIwsMaitosikaiyakuhr1x39;
    }

    @Column(order = 43, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x40;

    public BizNumber getIwsMaitosikaiyakuhr1x40() {
        return iwsMaitosikaiyakuhr1x40;
    }

    public void setIwsMaitosikaiyakuhr1x40(BizNumber pIwsMaitosikaiyakuhr1x40) {
        iwsMaitosikaiyakuhr1x40 = pIwsMaitosikaiyakuhr1x40;
    }

    @Column(order = 44, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x41;

    public BizNumber getIwsMaitosikaiyakuhr1x41() {
        return iwsMaitosikaiyakuhr1x41;
    }

    public void setIwsMaitosikaiyakuhr1x41(BizNumber pIwsMaitosikaiyakuhr1x41) {
        iwsMaitosikaiyakuhr1x41 = pIwsMaitosikaiyakuhr1x41;
    }

    @Column(order = 45, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x42;

    public BizNumber getIwsMaitosikaiyakuhr1x42() {
        return iwsMaitosikaiyakuhr1x42;
    }

    public void setIwsMaitosikaiyakuhr1x42(BizNumber pIwsMaitosikaiyakuhr1x42) {
        iwsMaitosikaiyakuhr1x42 = pIwsMaitosikaiyakuhr1x42;
    }

    @Column(order = 46, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x43;

    public BizNumber getIwsMaitosikaiyakuhr1x43() {
        return iwsMaitosikaiyakuhr1x43;
    }

    public void setIwsMaitosikaiyakuhr1x43(BizNumber pIwsMaitosikaiyakuhr1x43) {
        iwsMaitosikaiyakuhr1x43 = pIwsMaitosikaiyakuhr1x43;
    }

    @Column(order = 47, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x44;

    public BizNumber getIwsMaitosikaiyakuhr1x44() {
        return iwsMaitosikaiyakuhr1x44;
    }

    public void setIwsMaitosikaiyakuhr1x44(BizNumber pIwsMaitosikaiyakuhr1x44) {
        iwsMaitosikaiyakuhr1x44 = pIwsMaitosikaiyakuhr1x44;
    }

    @Column(order = 48, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x45;

    public BizNumber getIwsMaitosikaiyakuhr1x45() {
        return iwsMaitosikaiyakuhr1x45;
    }

    public void setIwsMaitosikaiyakuhr1x45(BizNumber pIwsMaitosikaiyakuhr1x45) {
        iwsMaitosikaiyakuhr1x45 = pIwsMaitosikaiyakuhr1x45;
    }

    @Column(order = 49, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x46;

    public BizNumber getIwsMaitosikaiyakuhr1x46() {
        return iwsMaitosikaiyakuhr1x46;
    }

    public void setIwsMaitosikaiyakuhr1x46(BizNumber pIwsMaitosikaiyakuhr1x46) {
        iwsMaitosikaiyakuhr1x46 = pIwsMaitosikaiyakuhr1x46;
    }

    @Column(order = 50, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x47;

    public BizNumber getIwsMaitosikaiyakuhr1x47() {
        return iwsMaitosikaiyakuhr1x47;
    }

    public void setIwsMaitosikaiyakuhr1x47(BizNumber pIwsMaitosikaiyakuhr1x47) {
        iwsMaitosikaiyakuhr1x47 = pIwsMaitosikaiyakuhr1x47;
    }

    @Column(order = 51, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x48;

    public BizNumber getIwsMaitosikaiyakuhr1x48() {
        return iwsMaitosikaiyakuhr1x48;
    }

    public void setIwsMaitosikaiyakuhr1x48(BizNumber pIwsMaitosikaiyakuhr1x48) {
        iwsMaitosikaiyakuhr1x48 = pIwsMaitosikaiyakuhr1x48;
    }

    @Column(order = 52, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x49;

    public BizNumber getIwsMaitosikaiyakuhr1x49() {
        return iwsMaitosikaiyakuhr1x49;
    }

    public void setIwsMaitosikaiyakuhr1x49(BizNumber pIwsMaitosikaiyakuhr1x49) {
        iwsMaitosikaiyakuhr1x49 = pIwsMaitosikaiyakuhr1x49;
    }

    @Column(order = 53, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x50;

    public BizNumber getIwsMaitosikaiyakuhr1x50() {
        return iwsMaitosikaiyakuhr1x50;
    }

    public void setIwsMaitosikaiyakuhr1x50(BizNumber pIwsMaitosikaiyakuhr1x50) {
        iwsMaitosikaiyakuhr1x50 = pIwsMaitosikaiyakuhr1x50;
    }

    @Column(order = 54, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x51;

    public BizNumber getIwsMaitosikaiyakuhr1x51() {
        return iwsMaitosikaiyakuhr1x51;
    }

    public void setIwsMaitosikaiyakuhr1x51(BizNumber pIwsMaitosikaiyakuhr1x51) {
        iwsMaitosikaiyakuhr1x51 = pIwsMaitosikaiyakuhr1x51;
    }

    @Column(order = 55, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x52;

    public BizNumber getIwsMaitosikaiyakuhr1x52() {
        return iwsMaitosikaiyakuhr1x52;
    }

    public void setIwsMaitosikaiyakuhr1x52(BizNumber pIwsMaitosikaiyakuhr1x52) {
        iwsMaitosikaiyakuhr1x52 = pIwsMaitosikaiyakuhr1x52;
    }

    @Column(order = 56, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x53;

    public BizNumber getIwsMaitosikaiyakuhr1x53() {
        return iwsMaitosikaiyakuhr1x53;
    }

    public void setIwsMaitosikaiyakuhr1x53(BizNumber pIwsMaitosikaiyakuhr1x53) {
        iwsMaitosikaiyakuhr1x53 = pIwsMaitosikaiyakuhr1x53;
    }

    @Column(order = 57, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x54;

    public BizNumber getIwsMaitosikaiyakuhr1x54() {
        return iwsMaitosikaiyakuhr1x54;
    }

    public void setIwsMaitosikaiyakuhr1x54(BizNumber pIwsMaitosikaiyakuhr1x54) {
        iwsMaitosikaiyakuhr1x54 = pIwsMaitosikaiyakuhr1x54;
    }

    @Column(order = 58, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x55;

    public BizNumber getIwsMaitosikaiyakuhr1x55() {
        return iwsMaitosikaiyakuhr1x55;
    }

    public void setIwsMaitosikaiyakuhr1x55(BizNumber pIwsMaitosikaiyakuhr1x55) {
        iwsMaitosikaiyakuhr1x55 = pIwsMaitosikaiyakuhr1x55;
    }

    @Column(order = 59, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x56;

    public BizNumber getIwsMaitosikaiyakuhr1x56() {
        return iwsMaitosikaiyakuhr1x56;
    }

    public void setIwsMaitosikaiyakuhr1x56(BizNumber pIwsMaitosikaiyakuhr1x56) {
        iwsMaitosikaiyakuhr1x56 = pIwsMaitosikaiyakuhr1x56;
    }

    @Column(order = 60, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x57;

    public BizNumber getIwsMaitosikaiyakuhr1x57() {
        return iwsMaitosikaiyakuhr1x57;
    }

    public void setIwsMaitosikaiyakuhr1x57(BizNumber pIwsMaitosikaiyakuhr1x57) {
        iwsMaitosikaiyakuhr1x57 = pIwsMaitosikaiyakuhr1x57;
    }

    @Column(order = 61, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x58;

    public BizNumber getIwsMaitosikaiyakuhr1x58() {
        return iwsMaitosikaiyakuhr1x58;
    }

    public void setIwsMaitosikaiyakuhr1x58(BizNumber pIwsMaitosikaiyakuhr1x58) {
        iwsMaitosikaiyakuhr1x58 = pIwsMaitosikaiyakuhr1x58;
    }

    @Column(order = 62, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x59;

    public BizNumber getIwsMaitosikaiyakuhr1x59() {
        return iwsMaitosikaiyakuhr1x59;
    }

    public void setIwsMaitosikaiyakuhr1x59(BizNumber pIwsMaitosikaiyakuhr1x59) {
        iwsMaitosikaiyakuhr1x59 = pIwsMaitosikaiyakuhr1x59;
    }

    @Column(order = 63, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x60;

    public BizNumber getIwsMaitosikaiyakuhr1x60() {
        return iwsMaitosikaiyakuhr1x60;
    }

    public void setIwsMaitosikaiyakuhr1x60(BizNumber pIwsMaitosikaiyakuhr1x60) {
        iwsMaitosikaiyakuhr1x60 = pIwsMaitosikaiyakuhr1x60;
    }

    @Column(order = 64, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x61;

    public BizNumber getIwsMaitosikaiyakuhr1x61() {
        return iwsMaitosikaiyakuhr1x61;
    }

    public void setIwsMaitosikaiyakuhr1x61(BizNumber pIwsMaitosikaiyakuhr1x61) {
        iwsMaitosikaiyakuhr1x61 = pIwsMaitosikaiyakuhr1x61;
    }

    @Column(order = 65, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x62;

    public BizNumber getIwsMaitosikaiyakuhr1x62() {
        return iwsMaitosikaiyakuhr1x62;
    }

    public void setIwsMaitosikaiyakuhr1x62(BizNumber pIwsMaitosikaiyakuhr1x62) {
        iwsMaitosikaiyakuhr1x62 = pIwsMaitosikaiyakuhr1x62;
    }

    @Column(order = 66, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x63;

    public BizNumber getIwsMaitosikaiyakuhr1x63() {
        return iwsMaitosikaiyakuhr1x63;
    }

    public void setIwsMaitosikaiyakuhr1x63(BizNumber pIwsMaitosikaiyakuhr1x63) {
        iwsMaitosikaiyakuhr1x63 = pIwsMaitosikaiyakuhr1x63;
    }

    @Column(order = 67, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x64;

    public BizNumber getIwsMaitosikaiyakuhr1x64() {
        return iwsMaitosikaiyakuhr1x64;
    }

    public void setIwsMaitosikaiyakuhr1x64(BizNumber pIwsMaitosikaiyakuhr1x64) {
        iwsMaitosikaiyakuhr1x64 = pIwsMaitosikaiyakuhr1x64;
    }

    @Column(order = 68, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x65;

    public BizNumber getIwsMaitosikaiyakuhr1x65() {
        return iwsMaitosikaiyakuhr1x65;
    }

    public void setIwsMaitosikaiyakuhr1x65(BizNumber pIwsMaitosikaiyakuhr1x65) {
        iwsMaitosikaiyakuhr1x65 = pIwsMaitosikaiyakuhr1x65;
    }

    @Column(order = 69, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x66;

    public BizNumber getIwsMaitosikaiyakuhr1x66() {
        return iwsMaitosikaiyakuhr1x66;
    }

    public void setIwsMaitosikaiyakuhr1x66(BizNumber pIwsMaitosikaiyakuhr1x66) {
        iwsMaitosikaiyakuhr1x66 = pIwsMaitosikaiyakuhr1x66;
    }

    @Column(order = 70, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x67;

    public BizNumber getIwsMaitosikaiyakuhr1x67() {
        return iwsMaitosikaiyakuhr1x67;
    }

    public void setIwsMaitosikaiyakuhr1x67(BizNumber pIwsMaitosikaiyakuhr1x67) {
        iwsMaitosikaiyakuhr1x67 = pIwsMaitosikaiyakuhr1x67;
    }

    @Column(order = 71, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x68;

    public BizNumber getIwsMaitosikaiyakuhr1x68() {
        return iwsMaitosikaiyakuhr1x68;
    }

    public void setIwsMaitosikaiyakuhr1x68(BizNumber pIwsMaitosikaiyakuhr1x68) {
        iwsMaitosikaiyakuhr1x68 = pIwsMaitosikaiyakuhr1x68;
    }

    @Column(order = 72, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x69;

    public BizNumber getIwsMaitosikaiyakuhr1x69() {
        return iwsMaitosikaiyakuhr1x69;
    }

    public void setIwsMaitosikaiyakuhr1x69(BizNumber pIwsMaitosikaiyakuhr1x69) {
        iwsMaitosikaiyakuhr1x69 = pIwsMaitosikaiyakuhr1x69;
    }

    @Column(order = 73, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x70;

    public BizNumber getIwsMaitosikaiyakuhr1x70() {
        return iwsMaitosikaiyakuhr1x70;
    }

    public void setIwsMaitosikaiyakuhr1x70(BizNumber pIwsMaitosikaiyakuhr1x70) {
        iwsMaitosikaiyakuhr1x70 = pIwsMaitosikaiyakuhr1x70;
    }

    @Column(order = 74, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x71;

    public BizNumber getIwsMaitosikaiyakuhr1x71() {
        return iwsMaitosikaiyakuhr1x71;
    }

    public void setIwsMaitosikaiyakuhr1x71(BizNumber pIwsMaitosikaiyakuhr1x71) {
        iwsMaitosikaiyakuhr1x71 = pIwsMaitosikaiyakuhr1x71;
    }

    @Column(order = 75, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x72;

    public BizNumber getIwsMaitosikaiyakuhr1x72() {
        return iwsMaitosikaiyakuhr1x72;
    }

    public void setIwsMaitosikaiyakuhr1x72(BizNumber pIwsMaitosikaiyakuhr1x72) {
        iwsMaitosikaiyakuhr1x72 = pIwsMaitosikaiyakuhr1x72;
    }

    @Column(order = 76, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x73;

    public BizNumber getIwsMaitosikaiyakuhr1x73() {
        return iwsMaitosikaiyakuhr1x73;
    }

    public void setIwsMaitosikaiyakuhr1x73(BizNumber pIwsMaitosikaiyakuhr1x73) {
        iwsMaitosikaiyakuhr1x73 = pIwsMaitosikaiyakuhr1x73;
    }

    @Column(order = 77, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x74;

    public BizNumber getIwsMaitosikaiyakuhr1x74() {
        return iwsMaitosikaiyakuhr1x74;
    }

    public void setIwsMaitosikaiyakuhr1x74(BizNumber pIwsMaitosikaiyakuhr1x74) {
        iwsMaitosikaiyakuhr1x74 = pIwsMaitosikaiyakuhr1x74;
    }

    @Column(order = 78, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x75;

    public BizNumber getIwsMaitosikaiyakuhr1x75() {
        return iwsMaitosikaiyakuhr1x75;
    }

    public void setIwsMaitosikaiyakuhr1x75(BizNumber pIwsMaitosikaiyakuhr1x75) {
        iwsMaitosikaiyakuhr1x75 = pIwsMaitosikaiyakuhr1x75;
    }

    @Column(order = 79, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x76;

    public BizNumber getIwsMaitosikaiyakuhr1x76() {
        return iwsMaitosikaiyakuhr1x76;
    }

    public void setIwsMaitosikaiyakuhr1x76(BizNumber pIwsMaitosikaiyakuhr1x76) {
        iwsMaitosikaiyakuhr1x76 = pIwsMaitosikaiyakuhr1x76;
    }

    @Column(order = 80, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x77;

    public BizNumber getIwsMaitosikaiyakuhr1x77() {
        return iwsMaitosikaiyakuhr1x77;
    }

    public void setIwsMaitosikaiyakuhr1x77(BizNumber pIwsMaitosikaiyakuhr1x77) {
        iwsMaitosikaiyakuhr1x77 = pIwsMaitosikaiyakuhr1x77;
    }

    @Column(order = 81, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x78;

    public BizNumber getIwsMaitosikaiyakuhr1x78() {
        return iwsMaitosikaiyakuhr1x78;
    }

    public void setIwsMaitosikaiyakuhr1x78(BizNumber pIwsMaitosikaiyakuhr1x78) {
        iwsMaitosikaiyakuhr1x78 = pIwsMaitosikaiyakuhr1x78;
    }

    @Column(order = 82, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x79;

    public BizNumber getIwsMaitosikaiyakuhr1x79() {
        return iwsMaitosikaiyakuhr1x79;
    }

    public void setIwsMaitosikaiyakuhr1x79(BizNumber pIwsMaitosikaiyakuhr1x79) {
        iwsMaitosikaiyakuhr1x79 = pIwsMaitosikaiyakuhr1x79;
    }

    @Column(order = 83, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x80;

    public BizNumber getIwsMaitosikaiyakuhr1x80() {
        return iwsMaitosikaiyakuhr1x80;
    }

    public void setIwsMaitosikaiyakuhr1x80(BizNumber pIwsMaitosikaiyakuhr1x80) {
        iwsMaitosikaiyakuhr1x80 = pIwsMaitosikaiyakuhr1x80;
    }

    @Column(order = 84, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x81;

    public BizNumber getIwsMaitosikaiyakuhr1x81() {
        return iwsMaitosikaiyakuhr1x81;
    }

    public void setIwsMaitosikaiyakuhr1x81(BizNumber pIwsMaitosikaiyakuhr1x81) {
        iwsMaitosikaiyakuhr1x81 = pIwsMaitosikaiyakuhr1x81;
    }

    @Column(order = 85, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x82;

    public BizNumber getIwsMaitosikaiyakuhr1x82() {
        return iwsMaitosikaiyakuhr1x82;
    }

    public void setIwsMaitosikaiyakuhr1x82(BizNumber pIwsMaitosikaiyakuhr1x82) {
        iwsMaitosikaiyakuhr1x82 = pIwsMaitosikaiyakuhr1x82;
    }

    @Column(order = 86, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x83;

    public BizNumber getIwsMaitosikaiyakuhr1x83() {
        return iwsMaitosikaiyakuhr1x83;
    }

    public void setIwsMaitosikaiyakuhr1x83(BizNumber pIwsMaitosikaiyakuhr1x83) {
        iwsMaitosikaiyakuhr1x83 = pIwsMaitosikaiyakuhr1x83;
    }

    @Column(order = 87, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x84;

    public BizNumber getIwsMaitosikaiyakuhr1x84() {
        return iwsMaitosikaiyakuhr1x84;
    }

    public void setIwsMaitosikaiyakuhr1x84(BizNumber pIwsMaitosikaiyakuhr1x84) {
        iwsMaitosikaiyakuhr1x84 = pIwsMaitosikaiyakuhr1x84;
    }

    @Column(order = 88, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x85;

    public BizNumber getIwsMaitosikaiyakuhr1x85() {
        return iwsMaitosikaiyakuhr1x85;
    }

    public void setIwsMaitosikaiyakuhr1x85(BizNumber pIwsMaitosikaiyakuhr1x85) {
        iwsMaitosikaiyakuhr1x85 = pIwsMaitosikaiyakuhr1x85;
    }

    @Column(order = 89, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x86;

    public BizNumber getIwsMaitosikaiyakuhr1x86() {
        return iwsMaitosikaiyakuhr1x86;
    }

    public void setIwsMaitosikaiyakuhr1x86(BizNumber pIwsMaitosikaiyakuhr1x86) {
        iwsMaitosikaiyakuhr1x86 = pIwsMaitosikaiyakuhr1x86;
    }

    @Column(order = 90, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x87;

    public BizNumber getIwsMaitosikaiyakuhr1x87() {
        return iwsMaitosikaiyakuhr1x87;
    }

    public void setIwsMaitosikaiyakuhr1x87(BizNumber pIwsMaitosikaiyakuhr1x87) {
        iwsMaitosikaiyakuhr1x87 = pIwsMaitosikaiyakuhr1x87;
    }

    @Column(order = 91, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x88;

    public BizNumber getIwsMaitosikaiyakuhr1x88() {
        return iwsMaitosikaiyakuhr1x88;
    }

    public void setIwsMaitosikaiyakuhr1x88(BizNumber pIwsMaitosikaiyakuhr1x88) {
        iwsMaitosikaiyakuhr1x88 = pIwsMaitosikaiyakuhr1x88;
    }

    @Column(order = 92, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x89;

    public BizNumber getIwsMaitosikaiyakuhr1x89() {
        return iwsMaitosikaiyakuhr1x89;
    }

    public void setIwsMaitosikaiyakuhr1x89(BizNumber pIwsMaitosikaiyakuhr1x89) {
        iwsMaitosikaiyakuhr1x89 = pIwsMaitosikaiyakuhr1x89;
    }

    @Column(order = 93, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x90;

    public BizNumber getIwsMaitosikaiyakuhr1x90() {
        return iwsMaitosikaiyakuhr1x90;
    }

    public void setIwsMaitosikaiyakuhr1x90(BizNumber pIwsMaitosikaiyakuhr1x90) {
        iwsMaitosikaiyakuhr1x90 = pIwsMaitosikaiyakuhr1x90;
    }

    @Column(order = 94, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x91;

    public BizNumber getIwsMaitosikaiyakuhr1x91() {
        return iwsMaitosikaiyakuhr1x91;
    }

    public void setIwsMaitosikaiyakuhr1x91(BizNumber pIwsMaitosikaiyakuhr1x91) {
        iwsMaitosikaiyakuhr1x91 = pIwsMaitosikaiyakuhr1x91;
    }

    @Column(order = 95, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x92;

    public BizNumber getIwsMaitosikaiyakuhr1x92() {
        return iwsMaitosikaiyakuhr1x92;
    }

    public void setIwsMaitosikaiyakuhr1x92(BizNumber pIwsMaitosikaiyakuhr1x92) {
        iwsMaitosikaiyakuhr1x92 = pIwsMaitosikaiyakuhr1x92;
    }

    @Column(order = 96, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x93;

    public BizNumber getIwsMaitosikaiyakuhr1x93() {
        return iwsMaitosikaiyakuhr1x93;
    }

    public void setIwsMaitosikaiyakuhr1x93(BizNumber pIwsMaitosikaiyakuhr1x93) {
        iwsMaitosikaiyakuhr1x93 = pIwsMaitosikaiyakuhr1x93;
    }

    @Column(order = 97, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x94;

    public BizNumber getIwsMaitosikaiyakuhr1x94() {
        return iwsMaitosikaiyakuhr1x94;
    }

    public void setIwsMaitosikaiyakuhr1x94(BizNumber pIwsMaitosikaiyakuhr1x94) {
        iwsMaitosikaiyakuhr1x94 = pIwsMaitosikaiyakuhr1x94;
    }

    @Column(order = 98, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x95;

    public BizNumber getIwsMaitosikaiyakuhr1x95() {
        return iwsMaitosikaiyakuhr1x95;
    }

    public void setIwsMaitosikaiyakuhr1x95(BizNumber pIwsMaitosikaiyakuhr1x95) {
        iwsMaitosikaiyakuhr1x95 = pIwsMaitosikaiyakuhr1x95;
    }

    @Column(order = 99, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x96;

    public BizNumber getIwsMaitosikaiyakuhr1x96() {
        return iwsMaitosikaiyakuhr1x96;
    }

    public void setIwsMaitosikaiyakuhr1x96(BizNumber pIwsMaitosikaiyakuhr1x96) {
        iwsMaitosikaiyakuhr1x96 = pIwsMaitosikaiyakuhr1x96;
    }

    @Column(order = 100, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x97;

    public BizNumber getIwsMaitosikaiyakuhr1x97() {
        return iwsMaitosikaiyakuhr1x97;
    }

    public void setIwsMaitosikaiyakuhr1x97(BizNumber pIwsMaitosikaiyakuhr1x97) {
        iwsMaitosikaiyakuhr1x97 = pIwsMaitosikaiyakuhr1x97;
    }

    @Column(order = 101, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x98;

    public BizNumber getIwsMaitosikaiyakuhr1x98() {
        return iwsMaitosikaiyakuhr1x98;
    }

    public void setIwsMaitosikaiyakuhr1x98(BizNumber pIwsMaitosikaiyakuhr1x98) {
        iwsMaitosikaiyakuhr1x98 = pIwsMaitosikaiyakuhr1x98;
    }

    @Column(order = 102, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x99;

    public BizNumber getIwsMaitosikaiyakuhr1x99() {
        return iwsMaitosikaiyakuhr1x99;
    }

    public void setIwsMaitosikaiyakuhr1x99(BizNumber pIwsMaitosikaiyakuhr1x99) {
        iwsMaitosikaiyakuhr1x99 = pIwsMaitosikaiyakuhr1x99;
    }

    @Column(order = 103, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x1;

    public BizNumber getIwsMaitosikaiyakuhr2x1() {
        return iwsMaitosikaiyakuhr2x1;
    }

    public void setIwsMaitosikaiyakuhr2x1(BizNumber pIwsMaitosikaiyakuhr2x1) {
        iwsMaitosikaiyakuhr2x1 = pIwsMaitosikaiyakuhr2x1;
    }

    @Column(order = 104, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x2;

    public BizNumber getIwsMaitosikaiyakuhr2x2() {
        return iwsMaitosikaiyakuhr2x2;
    }

    public void setIwsMaitosikaiyakuhr2x2(BizNumber pIwsMaitosikaiyakuhr2x2) {
        iwsMaitosikaiyakuhr2x2 = pIwsMaitosikaiyakuhr2x2;
    }

    @Column(order = 105, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x3;

    public BizNumber getIwsMaitosikaiyakuhr2x3() {
        return iwsMaitosikaiyakuhr2x3;
    }

    public void setIwsMaitosikaiyakuhr2x3(BizNumber pIwsMaitosikaiyakuhr2x3) {
        iwsMaitosikaiyakuhr2x3 = pIwsMaitosikaiyakuhr2x3;
    }

    @Column(order = 106, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x4;

    public BizNumber getIwsMaitosikaiyakuhr2x4() {
        return iwsMaitosikaiyakuhr2x4;
    }

    public void setIwsMaitosikaiyakuhr2x4(BizNumber pIwsMaitosikaiyakuhr2x4) {
        iwsMaitosikaiyakuhr2x4 = pIwsMaitosikaiyakuhr2x4;
    }

    @Column(order = 107, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x5;

    public BizNumber getIwsMaitosikaiyakuhr2x5() {
        return iwsMaitosikaiyakuhr2x5;
    }

    public void setIwsMaitosikaiyakuhr2x5(BizNumber pIwsMaitosikaiyakuhr2x5) {
        iwsMaitosikaiyakuhr2x5 = pIwsMaitosikaiyakuhr2x5;
    }

    @Column(order = 108, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x6;

    public BizNumber getIwsMaitosikaiyakuhr2x6() {
        return iwsMaitosikaiyakuhr2x6;
    }

    public void setIwsMaitosikaiyakuhr2x6(BizNumber pIwsMaitosikaiyakuhr2x6) {
        iwsMaitosikaiyakuhr2x6 = pIwsMaitosikaiyakuhr2x6;
    }

    @Column(order = 109, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x7;

    public BizNumber getIwsMaitosikaiyakuhr2x7() {
        return iwsMaitosikaiyakuhr2x7;
    }

    public void setIwsMaitosikaiyakuhr2x7(BizNumber pIwsMaitosikaiyakuhr2x7) {
        iwsMaitosikaiyakuhr2x7 = pIwsMaitosikaiyakuhr2x7;
    }

    @Column(order = 110, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x8;

    public BizNumber getIwsMaitosikaiyakuhr2x8() {
        return iwsMaitosikaiyakuhr2x8;
    }

    public void setIwsMaitosikaiyakuhr2x8(BizNumber pIwsMaitosikaiyakuhr2x8) {
        iwsMaitosikaiyakuhr2x8 = pIwsMaitosikaiyakuhr2x8;
    }

    @Column(order = 111, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x9;

    public BizNumber getIwsMaitosikaiyakuhr2x9() {
        return iwsMaitosikaiyakuhr2x9;
    }

    public void setIwsMaitosikaiyakuhr2x9(BizNumber pIwsMaitosikaiyakuhr2x9) {
        iwsMaitosikaiyakuhr2x9 = pIwsMaitosikaiyakuhr2x9;
    }

    @Column(order = 112, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x10;

    public BizNumber getIwsMaitosikaiyakuhr2x10() {
        return iwsMaitosikaiyakuhr2x10;
    }

    public void setIwsMaitosikaiyakuhr2x10(BizNumber pIwsMaitosikaiyakuhr2x10) {
        iwsMaitosikaiyakuhr2x10 = pIwsMaitosikaiyakuhr2x10;
    }

    @Column(order = 113, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x11;

    public BizNumber getIwsMaitosikaiyakuhr2x11() {
        return iwsMaitosikaiyakuhr2x11;
    }

    public void setIwsMaitosikaiyakuhr2x11(BizNumber pIwsMaitosikaiyakuhr2x11) {
        iwsMaitosikaiyakuhr2x11 = pIwsMaitosikaiyakuhr2x11;
    }

    @Column(order = 114, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x12;

    public BizNumber getIwsMaitosikaiyakuhr2x12() {
        return iwsMaitosikaiyakuhr2x12;
    }

    public void setIwsMaitosikaiyakuhr2x12(BizNumber pIwsMaitosikaiyakuhr2x12) {
        iwsMaitosikaiyakuhr2x12 = pIwsMaitosikaiyakuhr2x12;
    }

    @Column(order = 115, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x13;

    public BizNumber getIwsMaitosikaiyakuhr2x13() {
        return iwsMaitosikaiyakuhr2x13;
    }

    public void setIwsMaitosikaiyakuhr2x13(BizNumber pIwsMaitosikaiyakuhr2x13) {
        iwsMaitosikaiyakuhr2x13 = pIwsMaitosikaiyakuhr2x13;
    }

    @Column(order = 116, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x14;

    public BizNumber getIwsMaitosikaiyakuhr2x14() {
        return iwsMaitosikaiyakuhr2x14;
    }

    public void setIwsMaitosikaiyakuhr2x14(BizNumber pIwsMaitosikaiyakuhr2x14) {
        iwsMaitosikaiyakuhr2x14 = pIwsMaitosikaiyakuhr2x14;
    }

    @Column(order = 117, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x15;

    public BizNumber getIwsMaitosikaiyakuhr2x15() {
        return iwsMaitosikaiyakuhr2x15;
    }

    public void setIwsMaitosikaiyakuhr2x15(BizNumber pIwsMaitosikaiyakuhr2x15) {
        iwsMaitosikaiyakuhr2x15 = pIwsMaitosikaiyakuhr2x15;
    }

    @Column(order = 118, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x16;

    public BizNumber getIwsMaitosikaiyakuhr2x16() {
        return iwsMaitosikaiyakuhr2x16;
    }

    public void setIwsMaitosikaiyakuhr2x16(BizNumber pIwsMaitosikaiyakuhr2x16) {
        iwsMaitosikaiyakuhr2x16 = pIwsMaitosikaiyakuhr2x16;
    }

    @Column(order = 119, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x17;

    public BizNumber getIwsMaitosikaiyakuhr2x17() {
        return iwsMaitosikaiyakuhr2x17;
    }

    public void setIwsMaitosikaiyakuhr2x17(BizNumber pIwsMaitosikaiyakuhr2x17) {
        iwsMaitosikaiyakuhr2x17 = pIwsMaitosikaiyakuhr2x17;
    }

    @Column(order = 120, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x18;

    public BizNumber getIwsMaitosikaiyakuhr2x18() {
        return iwsMaitosikaiyakuhr2x18;
    }

    public void setIwsMaitosikaiyakuhr2x18(BizNumber pIwsMaitosikaiyakuhr2x18) {
        iwsMaitosikaiyakuhr2x18 = pIwsMaitosikaiyakuhr2x18;
    }

    @Column(order = 121, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x19;

    public BizNumber getIwsMaitosikaiyakuhr2x19() {
        return iwsMaitosikaiyakuhr2x19;
    }

    public void setIwsMaitosikaiyakuhr2x19(BizNumber pIwsMaitosikaiyakuhr2x19) {
        iwsMaitosikaiyakuhr2x19 = pIwsMaitosikaiyakuhr2x19;
    }

    @Column(order = 122, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x20;

    public BizNumber getIwsMaitosikaiyakuhr2x20() {
        return iwsMaitosikaiyakuhr2x20;
    }

    public void setIwsMaitosikaiyakuhr2x20(BizNumber pIwsMaitosikaiyakuhr2x20) {
        iwsMaitosikaiyakuhr2x20 = pIwsMaitosikaiyakuhr2x20;
    }

    @Column(order = 123, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x21;

    public BizNumber getIwsMaitosikaiyakuhr2x21() {
        return iwsMaitosikaiyakuhr2x21;
    }

    public void setIwsMaitosikaiyakuhr2x21(BizNumber pIwsMaitosikaiyakuhr2x21) {
        iwsMaitosikaiyakuhr2x21 = pIwsMaitosikaiyakuhr2x21;
    }

    @Column(order = 124, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x22;

    public BizNumber getIwsMaitosikaiyakuhr2x22() {
        return iwsMaitosikaiyakuhr2x22;
    }

    public void setIwsMaitosikaiyakuhr2x22(BizNumber pIwsMaitosikaiyakuhr2x22) {
        iwsMaitosikaiyakuhr2x22 = pIwsMaitosikaiyakuhr2x22;
    }

    @Column(order = 125, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x23;

    public BizNumber getIwsMaitosikaiyakuhr2x23() {
        return iwsMaitosikaiyakuhr2x23;
    }

    public void setIwsMaitosikaiyakuhr2x23(BizNumber pIwsMaitosikaiyakuhr2x23) {
        iwsMaitosikaiyakuhr2x23 = pIwsMaitosikaiyakuhr2x23;
    }

    @Column(order = 126, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x24;

    public BizNumber getIwsMaitosikaiyakuhr2x24() {
        return iwsMaitosikaiyakuhr2x24;
    }

    public void setIwsMaitosikaiyakuhr2x24(BizNumber pIwsMaitosikaiyakuhr2x24) {
        iwsMaitosikaiyakuhr2x24 = pIwsMaitosikaiyakuhr2x24;
    }

    @Column(order = 127, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x25;

    public BizNumber getIwsMaitosikaiyakuhr2x25() {
        return iwsMaitosikaiyakuhr2x25;
    }

    public void setIwsMaitosikaiyakuhr2x25(BizNumber pIwsMaitosikaiyakuhr2x25) {
        iwsMaitosikaiyakuhr2x25 = pIwsMaitosikaiyakuhr2x25;
    }

    @Column(order = 128, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x26;

    public BizNumber getIwsMaitosikaiyakuhr2x26() {
        return iwsMaitosikaiyakuhr2x26;
    }

    public void setIwsMaitosikaiyakuhr2x26(BizNumber pIwsMaitosikaiyakuhr2x26) {
        iwsMaitosikaiyakuhr2x26 = pIwsMaitosikaiyakuhr2x26;
    }

    @Column(order = 129, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x27;

    public BizNumber getIwsMaitosikaiyakuhr2x27() {
        return iwsMaitosikaiyakuhr2x27;
    }

    public void setIwsMaitosikaiyakuhr2x27(BizNumber pIwsMaitosikaiyakuhr2x27) {
        iwsMaitosikaiyakuhr2x27 = pIwsMaitosikaiyakuhr2x27;
    }

    @Column(order = 130, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x28;

    public BizNumber getIwsMaitosikaiyakuhr2x28() {
        return iwsMaitosikaiyakuhr2x28;
    }

    public void setIwsMaitosikaiyakuhr2x28(BizNumber pIwsMaitosikaiyakuhr2x28) {
        iwsMaitosikaiyakuhr2x28 = pIwsMaitosikaiyakuhr2x28;
    }

    @Column(order = 131, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x29;

    public BizNumber getIwsMaitosikaiyakuhr2x29() {
        return iwsMaitosikaiyakuhr2x29;
    }

    public void setIwsMaitosikaiyakuhr2x29(BizNumber pIwsMaitosikaiyakuhr2x29) {
        iwsMaitosikaiyakuhr2x29 = pIwsMaitosikaiyakuhr2x29;
    }

    @Column(order = 132, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x30;

    public BizNumber getIwsMaitosikaiyakuhr2x30() {
        return iwsMaitosikaiyakuhr2x30;
    }

    public void setIwsMaitosikaiyakuhr2x30(BizNumber pIwsMaitosikaiyakuhr2x30) {
        iwsMaitosikaiyakuhr2x30 = pIwsMaitosikaiyakuhr2x30;
    }

    @Column(order = 133, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x31;

    public BizNumber getIwsMaitosikaiyakuhr2x31() {
        return iwsMaitosikaiyakuhr2x31;
    }

    public void setIwsMaitosikaiyakuhr2x31(BizNumber pIwsMaitosikaiyakuhr2x31) {
        iwsMaitosikaiyakuhr2x31 = pIwsMaitosikaiyakuhr2x31;
    }

    @Column(order = 134, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x32;

    public BizNumber getIwsMaitosikaiyakuhr2x32() {
        return iwsMaitosikaiyakuhr2x32;
    }

    public void setIwsMaitosikaiyakuhr2x32(BizNumber pIwsMaitosikaiyakuhr2x32) {
        iwsMaitosikaiyakuhr2x32 = pIwsMaitosikaiyakuhr2x32;
    }

    @Column(order = 135, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x33;

    public BizNumber getIwsMaitosikaiyakuhr2x33() {
        return iwsMaitosikaiyakuhr2x33;
    }

    public void setIwsMaitosikaiyakuhr2x33(BizNumber pIwsMaitosikaiyakuhr2x33) {
        iwsMaitosikaiyakuhr2x33 = pIwsMaitosikaiyakuhr2x33;
    }

    @Column(order = 136, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x34;

    public BizNumber getIwsMaitosikaiyakuhr2x34() {
        return iwsMaitosikaiyakuhr2x34;
    }

    public void setIwsMaitosikaiyakuhr2x34(BizNumber pIwsMaitosikaiyakuhr2x34) {
        iwsMaitosikaiyakuhr2x34 = pIwsMaitosikaiyakuhr2x34;
    }

    @Column(order = 137, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x35;

    public BizNumber getIwsMaitosikaiyakuhr2x35() {
        return iwsMaitosikaiyakuhr2x35;
    }

    public void setIwsMaitosikaiyakuhr2x35(BizNumber pIwsMaitosikaiyakuhr2x35) {
        iwsMaitosikaiyakuhr2x35 = pIwsMaitosikaiyakuhr2x35;
    }

    @Column(order = 138, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x36;

    public BizNumber getIwsMaitosikaiyakuhr2x36() {
        return iwsMaitosikaiyakuhr2x36;
    }

    public void setIwsMaitosikaiyakuhr2x36(BizNumber pIwsMaitosikaiyakuhr2x36) {
        iwsMaitosikaiyakuhr2x36 = pIwsMaitosikaiyakuhr2x36;
    }

    @Column(order = 139, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x37;

    public BizNumber getIwsMaitosikaiyakuhr2x37() {
        return iwsMaitosikaiyakuhr2x37;
    }

    public void setIwsMaitosikaiyakuhr2x37(BizNumber pIwsMaitosikaiyakuhr2x37) {
        iwsMaitosikaiyakuhr2x37 = pIwsMaitosikaiyakuhr2x37;
    }

    @Column(order = 140, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x38;

    public BizNumber getIwsMaitosikaiyakuhr2x38() {
        return iwsMaitosikaiyakuhr2x38;
    }

    public void setIwsMaitosikaiyakuhr2x38(BizNumber pIwsMaitosikaiyakuhr2x38) {
        iwsMaitosikaiyakuhr2x38 = pIwsMaitosikaiyakuhr2x38;
    }

    @Column(order = 141, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x39;

    public BizNumber getIwsMaitosikaiyakuhr2x39() {
        return iwsMaitosikaiyakuhr2x39;
    }

    public void setIwsMaitosikaiyakuhr2x39(BizNumber pIwsMaitosikaiyakuhr2x39) {
        iwsMaitosikaiyakuhr2x39 = pIwsMaitosikaiyakuhr2x39;
    }

    @Column(order = 142, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x40;

    public BizNumber getIwsMaitosikaiyakuhr2x40() {
        return iwsMaitosikaiyakuhr2x40;
    }

    public void setIwsMaitosikaiyakuhr2x40(BizNumber pIwsMaitosikaiyakuhr2x40) {
        iwsMaitosikaiyakuhr2x40 = pIwsMaitosikaiyakuhr2x40;
    }

    @Column(order = 143, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x41;

    public BizNumber getIwsMaitosikaiyakuhr2x41() {
        return iwsMaitosikaiyakuhr2x41;
    }

    public void setIwsMaitosikaiyakuhr2x41(BizNumber pIwsMaitosikaiyakuhr2x41) {
        iwsMaitosikaiyakuhr2x41 = pIwsMaitosikaiyakuhr2x41;
    }

    @Column(order = 144, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x42;

    public BizNumber getIwsMaitosikaiyakuhr2x42() {
        return iwsMaitosikaiyakuhr2x42;
    }

    public void setIwsMaitosikaiyakuhr2x42(BizNumber pIwsMaitosikaiyakuhr2x42) {
        iwsMaitosikaiyakuhr2x42 = pIwsMaitosikaiyakuhr2x42;
    }

    @Column(order = 145, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x43;

    public BizNumber getIwsMaitosikaiyakuhr2x43() {
        return iwsMaitosikaiyakuhr2x43;
    }

    public void setIwsMaitosikaiyakuhr2x43(BizNumber pIwsMaitosikaiyakuhr2x43) {
        iwsMaitosikaiyakuhr2x43 = pIwsMaitosikaiyakuhr2x43;
    }

    @Column(order = 146, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x44;

    public BizNumber getIwsMaitosikaiyakuhr2x44() {
        return iwsMaitosikaiyakuhr2x44;
    }

    public void setIwsMaitosikaiyakuhr2x44(BizNumber pIwsMaitosikaiyakuhr2x44) {
        iwsMaitosikaiyakuhr2x44 = pIwsMaitosikaiyakuhr2x44;
    }

    @Column(order = 147, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x45;

    public BizNumber getIwsMaitosikaiyakuhr2x45() {
        return iwsMaitosikaiyakuhr2x45;
    }

    public void setIwsMaitosikaiyakuhr2x45(BizNumber pIwsMaitosikaiyakuhr2x45) {
        iwsMaitosikaiyakuhr2x45 = pIwsMaitosikaiyakuhr2x45;
    }

    @Column(order = 148, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x46;

    public BizNumber getIwsMaitosikaiyakuhr2x46() {
        return iwsMaitosikaiyakuhr2x46;
    }

    public void setIwsMaitosikaiyakuhr2x46(BizNumber pIwsMaitosikaiyakuhr2x46) {
        iwsMaitosikaiyakuhr2x46 = pIwsMaitosikaiyakuhr2x46;
    }

    @Column(order = 149, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x47;

    public BizNumber getIwsMaitosikaiyakuhr2x47() {
        return iwsMaitosikaiyakuhr2x47;
    }

    public void setIwsMaitosikaiyakuhr2x47(BizNumber pIwsMaitosikaiyakuhr2x47) {
        iwsMaitosikaiyakuhr2x47 = pIwsMaitosikaiyakuhr2x47;
    }

    @Column(order = 150, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x48;

    public BizNumber getIwsMaitosikaiyakuhr2x48() {
        return iwsMaitosikaiyakuhr2x48;
    }

    public void setIwsMaitosikaiyakuhr2x48(BizNumber pIwsMaitosikaiyakuhr2x48) {
        iwsMaitosikaiyakuhr2x48 = pIwsMaitosikaiyakuhr2x48;
    }

    @Column(order = 151, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x49;

    public BizNumber getIwsMaitosikaiyakuhr2x49() {
        return iwsMaitosikaiyakuhr2x49;
    }

    public void setIwsMaitosikaiyakuhr2x49(BizNumber pIwsMaitosikaiyakuhr2x49) {
        iwsMaitosikaiyakuhr2x49 = pIwsMaitosikaiyakuhr2x49;
    }

    @Column(order = 152, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x50;

    public BizNumber getIwsMaitosikaiyakuhr2x50() {
        return iwsMaitosikaiyakuhr2x50;
    }

    public void setIwsMaitosikaiyakuhr2x50(BizNumber pIwsMaitosikaiyakuhr2x50) {
        iwsMaitosikaiyakuhr2x50 = pIwsMaitosikaiyakuhr2x50;
    }

    @Column(order = 153, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x51;

    public BizNumber getIwsMaitosikaiyakuhr2x51() {
        return iwsMaitosikaiyakuhr2x51;
    }

    public void setIwsMaitosikaiyakuhr2x51(BizNumber pIwsMaitosikaiyakuhr2x51) {
        iwsMaitosikaiyakuhr2x51 = pIwsMaitosikaiyakuhr2x51;
    }

    @Column(order = 154, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x52;

    public BizNumber getIwsMaitosikaiyakuhr2x52() {
        return iwsMaitosikaiyakuhr2x52;
    }

    public void setIwsMaitosikaiyakuhr2x52(BizNumber pIwsMaitosikaiyakuhr2x52) {
        iwsMaitosikaiyakuhr2x52 = pIwsMaitosikaiyakuhr2x52;
    }

    @Column(order = 155, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x53;

    public BizNumber getIwsMaitosikaiyakuhr2x53() {
        return iwsMaitosikaiyakuhr2x53;
    }

    public void setIwsMaitosikaiyakuhr2x53(BizNumber pIwsMaitosikaiyakuhr2x53) {
        iwsMaitosikaiyakuhr2x53 = pIwsMaitosikaiyakuhr2x53;
    }

    @Column(order = 156, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x54;

    public BizNumber getIwsMaitosikaiyakuhr2x54() {
        return iwsMaitosikaiyakuhr2x54;
    }

    public void setIwsMaitosikaiyakuhr2x54(BizNumber pIwsMaitosikaiyakuhr2x54) {
        iwsMaitosikaiyakuhr2x54 = pIwsMaitosikaiyakuhr2x54;
    }

    @Column(order = 157, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x55;

    public BizNumber getIwsMaitosikaiyakuhr2x55() {
        return iwsMaitosikaiyakuhr2x55;
    }

    public void setIwsMaitosikaiyakuhr2x55(BizNumber pIwsMaitosikaiyakuhr2x55) {
        iwsMaitosikaiyakuhr2x55 = pIwsMaitosikaiyakuhr2x55;
    }

    @Column(order = 158, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x56;

    public BizNumber getIwsMaitosikaiyakuhr2x56() {
        return iwsMaitosikaiyakuhr2x56;
    }

    public void setIwsMaitosikaiyakuhr2x56(BizNumber pIwsMaitosikaiyakuhr2x56) {
        iwsMaitosikaiyakuhr2x56 = pIwsMaitosikaiyakuhr2x56;
    }

    @Column(order = 159, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x57;

    public BizNumber getIwsMaitosikaiyakuhr2x57() {
        return iwsMaitosikaiyakuhr2x57;
    }

    public void setIwsMaitosikaiyakuhr2x57(BizNumber pIwsMaitosikaiyakuhr2x57) {
        iwsMaitosikaiyakuhr2x57 = pIwsMaitosikaiyakuhr2x57;
    }

    @Column(order = 160, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x58;

    public BizNumber getIwsMaitosikaiyakuhr2x58() {
        return iwsMaitosikaiyakuhr2x58;
    }

    public void setIwsMaitosikaiyakuhr2x58(BizNumber pIwsMaitosikaiyakuhr2x58) {
        iwsMaitosikaiyakuhr2x58 = pIwsMaitosikaiyakuhr2x58;
    }

    @Column(order = 161, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x59;

    public BizNumber getIwsMaitosikaiyakuhr2x59() {
        return iwsMaitosikaiyakuhr2x59;
    }

    public void setIwsMaitosikaiyakuhr2x59(BizNumber pIwsMaitosikaiyakuhr2x59) {
        iwsMaitosikaiyakuhr2x59 = pIwsMaitosikaiyakuhr2x59;
    }

    @Column(order = 162, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x60;

    public BizNumber getIwsMaitosikaiyakuhr2x60() {
        return iwsMaitosikaiyakuhr2x60;
    }

    public void setIwsMaitosikaiyakuhr2x60(BizNumber pIwsMaitosikaiyakuhr2x60) {
        iwsMaitosikaiyakuhr2x60 = pIwsMaitosikaiyakuhr2x60;
    }

    @Column(order = 163, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x61;

    public BizNumber getIwsMaitosikaiyakuhr2x61() {
        return iwsMaitosikaiyakuhr2x61;
    }

    public void setIwsMaitosikaiyakuhr2x61(BizNumber pIwsMaitosikaiyakuhr2x61) {
        iwsMaitosikaiyakuhr2x61 = pIwsMaitosikaiyakuhr2x61;
    }

    @Column(order = 164, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x62;

    public BizNumber getIwsMaitosikaiyakuhr2x62() {
        return iwsMaitosikaiyakuhr2x62;
    }

    public void setIwsMaitosikaiyakuhr2x62(BizNumber pIwsMaitosikaiyakuhr2x62) {
        iwsMaitosikaiyakuhr2x62 = pIwsMaitosikaiyakuhr2x62;
    }

    @Column(order = 165, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x63;

    public BizNumber getIwsMaitosikaiyakuhr2x63() {
        return iwsMaitosikaiyakuhr2x63;
    }

    public void setIwsMaitosikaiyakuhr2x63(BizNumber pIwsMaitosikaiyakuhr2x63) {
        iwsMaitosikaiyakuhr2x63 = pIwsMaitosikaiyakuhr2x63;
    }

    @Column(order = 166, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x64;

    public BizNumber getIwsMaitosikaiyakuhr2x64() {
        return iwsMaitosikaiyakuhr2x64;
    }

    public void setIwsMaitosikaiyakuhr2x64(BizNumber pIwsMaitosikaiyakuhr2x64) {
        iwsMaitosikaiyakuhr2x64 = pIwsMaitosikaiyakuhr2x64;
    }

    @Column(order = 167, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x65;

    public BizNumber getIwsMaitosikaiyakuhr2x65() {
        return iwsMaitosikaiyakuhr2x65;
    }

    public void setIwsMaitosikaiyakuhr2x65(BizNumber pIwsMaitosikaiyakuhr2x65) {
        iwsMaitosikaiyakuhr2x65 = pIwsMaitosikaiyakuhr2x65;
    }

    @Column(order = 168, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x66;

    public BizNumber getIwsMaitosikaiyakuhr2x66() {
        return iwsMaitosikaiyakuhr2x66;
    }

    public void setIwsMaitosikaiyakuhr2x66(BizNumber pIwsMaitosikaiyakuhr2x66) {
        iwsMaitosikaiyakuhr2x66 = pIwsMaitosikaiyakuhr2x66;
    }

    @Column(order = 169, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x67;

    public BizNumber getIwsMaitosikaiyakuhr2x67() {
        return iwsMaitosikaiyakuhr2x67;
    }

    public void setIwsMaitosikaiyakuhr2x67(BizNumber pIwsMaitosikaiyakuhr2x67) {
        iwsMaitosikaiyakuhr2x67 = pIwsMaitosikaiyakuhr2x67;
    }

    @Column(order = 170, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x68;

    public BizNumber getIwsMaitosikaiyakuhr2x68() {
        return iwsMaitosikaiyakuhr2x68;
    }

    public void setIwsMaitosikaiyakuhr2x68(BizNumber pIwsMaitosikaiyakuhr2x68) {
        iwsMaitosikaiyakuhr2x68 = pIwsMaitosikaiyakuhr2x68;
    }

    @Column(order = 171, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x69;

    public BizNumber getIwsMaitosikaiyakuhr2x69() {
        return iwsMaitosikaiyakuhr2x69;
    }

    public void setIwsMaitosikaiyakuhr2x69(BizNumber pIwsMaitosikaiyakuhr2x69) {
        iwsMaitosikaiyakuhr2x69 = pIwsMaitosikaiyakuhr2x69;
    }

    @Column(order = 172, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x70;

    public BizNumber getIwsMaitosikaiyakuhr2x70() {
        return iwsMaitosikaiyakuhr2x70;
    }

    public void setIwsMaitosikaiyakuhr2x70(BizNumber pIwsMaitosikaiyakuhr2x70) {
        iwsMaitosikaiyakuhr2x70 = pIwsMaitosikaiyakuhr2x70;
    }

    @Column(order = 173, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x71;

    public BizNumber getIwsMaitosikaiyakuhr2x71() {
        return iwsMaitosikaiyakuhr2x71;
    }

    public void setIwsMaitosikaiyakuhr2x71(BizNumber pIwsMaitosikaiyakuhr2x71) {
        iwsMaitosikaiyakuhr2x71 = pIwsMaitosikaiyakuhr2x71;
    }

    @Column(order = 174, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x72;

    public BizNumber getIwsMaitosikaiyakuhr2x72() {
        return iwsMaitosikaiyakuhr2x72;
    }

    public void setIwsMaitosikaiyakuhr2x72(BizNumber pIwsMaitosikaiyakuhr2x72) {
        iwsMaitosikaiyakuhr2x72 = pIwsMaitosikaiyakuhr2x72;
    }

    @Column(order = 175, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x73;

    public BizNumber getIwsMaitosikaiyakuhr2x73() {
        return iwsMaitosikaiyakuhr2x73;
    }

    public void setIwsMaitosikaiyakuhr2x73(BizNumber pIwsMaitosikaiyakuhr2x73) {
        iwsMaitosikaiyakuhr2x73 = pIwsMaitosikaiyakuhr2x73;
    }

    @Column(order = 176, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x74;

    public BizNumber getIwsMaitosikaiyakuhr2x74() {
        return iwsMaitosikaiyakuhr2x74;
    }

    public void setIwsMaitosikaiyakuhr2x74(BizNumber pIwsMaitosikaiyakuhr2x74) {
        iwsMaitosikaiyakuhr2x74 = pIwsMaitosikaiyakuhr2x74;
    }

    @Column(order = 177, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x75;

    public BizNumber getIwsMaitosikaiyakuhr2x75() {
        return iwsMaitosikaiyakuhr2x75;
    }

    public void setIwsMaitosikaiyakuhr2x75(BizNumber pIwsMaitosikaiyakuhr2x75) {
        iwsMaitosikaiyakuhr2x75 = pIwsMaitosikaiyakuhr2x75;
    }

    @Column(order = 178, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x76;

    public BizNumber getIwsMaitosikaiyakuhr2x76() {
        return iwsMaitosikaiyakuhr2x76;
    }

    public void setIwsMaitosikaiyakuhr2x76(BizNumber pIwsMaitosikaiyakuhr2x76) {
        iwsMaitosikaiyakuhr2x76 = pIwsMaitosikaiyakuhr2x76;
    }

    @Column(order = 179, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x77;

    public BizNumber getIwsMaitosikaiyakuhr2x77() {
        return iwsMaitosikaiyakuhr2x77;
    }

    public void setIwsMaitosikaiyakuhr2x77(BizNumber pIwsMaitosikaiyakuhr2x77) {
        iwsMaitosikaiyakuhr2x77 = pIwsMaitosikaiyakuhr2x77;
    }

    @Column(order = 180, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x78;

    public BizNumber getIwsMaitosikaiyakuhr2x78() {
        return iwsMaitosikaiyakuhr2x78;
    }

    public void setIwsMaitosikaiyakuhr2x78(BizNumber pIwsMaitosikaiyakuhr2x78) {
        iwsMaitosikaiyakuhr2x78 = pIwsMaitosikaiyakuhr2x78;
    }

    @Column(order = 181, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x79;

    public BizNumber getIwsMaitosikaiyakuhr2x79() {
        return iwsMaitosikaiyakuhr2x79;
    }

    public void setIwsMaitosikaiyakuhr2x79(BizNumber pIwsMaitosikaiyakuhr2x79) {
        iwsMaitosikaiyakuhr2x79 = pIwsMaitosikaiyakuhr2x79;
    }

    @Column(order = 182, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x80;

    public BizNumber getIwsMaitosikaiyakuhr2x80() {
        return iwsMaitosikaiyakuhr2x80;
    }

    public void setIwsMaitosikaiyakuhr2x80(BizNumber pIwsMaitosikaiyakuhr2x80) {
        iwsMaitosikaiyakuhr2x80 = pIwsMaitosikaiyakuhr2x80;
    }

    @Column(order = 183, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x81;

    public BizNumber getIwsMaitosikaiyakuhr2x81() {
        return iwsMaitosikaiyakuhr2x81;
    }

    public void setIwsMaitosikaiyakuhr2x81(BizNumber pIwsMaitosikaiyakuhr2x81) {
        iwsMaitosikaiyakuhr2x81 = pIwsMaitosikaiyakuhr2x81;
    }

    @Column(order = 184, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x82;

    public BizNumber getIwsMaitosikaiyakuhr2x82() {
        return iwsMaitosikaiyakuhr2x82;
    }

    public void setIwsMaitosikaiyakuhr2x82(BizNumber pIwsMaitosikaiyakuhr2x82) {
        iwsMaitosikaiyakuhr2x82 = pIwsMaitosikaiyakuhr2x82;
    }

    @Column(order = 185, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x83;

    public BizNumber getIwsMaitosikaiyakuhr2x83() {
        return iwsMaitosikaiyakuhr2x83;
    }

    public void setIwsMaitosikaiyakuhr2x83(BizNumber pIwsMaitosikaiyakuhr2x83) {
        iwsMaitosikaiyakuhr2x83 = pIwsMaitosikaiyakuhr2x83;
    }

    @Column(order = 186, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x84;

    public BizNumber getIwsMaitosikaiyakuhr2x84() {
        return iwsMaitosikaiyakuhr2x84;
    }

    public void setIwsMaitosikaiyakuhr2x84(BizNumber pIwsMaitosikaiyakuhr2x84) {
        iwsMaitosikaiyakuhr2x84 = pIwsMaitosikaiyakuhr2x84;
    }

    @Column(order = 187, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x85;

    public BizNumber getIwsMaitosikaiyakuhr2x85() {
        return iwsMaitosikaiyakuhr2x85;
    }

    public void setIwsMaitosikaiyakuhr2x85(BizNumber pIwsMaitosikaiyakuhr2x85) {
        iwsMaitosikaiyakuhr2x85 = pIwsMaitosikaiyakuhr2x85;
    }

    @Column(order = 188, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x86;

    public BizNumber getIwsMaitosikaiyakuhr2x86() {
        return iwsMaitosikaiyakuhr2x86;
    }

    public void setIwsMaitosikaiyakuhr2x86(BizNumber pIwsMaitosikaiyakuhr2x86) {
        iwsMaitosikaiyakuhr2x86 = pIwsMaitosikaiyakuhr2x86;
    }

    @Column(order = 189, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x87;

    public BizNumber getIwsMaitosikaiyakuhr2x87() {
        return iwsMaitosikaiyakuhr2x87;
    }

    public void setIwsMaitosikaiyakuhr2x87(BizNumber pIwsMaitosikaiyakuhr2x87) {
        iwsMaitosikaiyakuhr2x87 = pIwsMaitosikaiyakuhr2x87;
    }

    @Column(order = 190, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x88;

    public BizNumber getIwsMaitosikaiyakuhr2x88() {
        return iwsMaitosikaiyakuhr2x88;
    }

    public void setIwsMaitosikaiyakuhr2x88(BizNumber pIwsMaitosikaiyakuhr2x88) {
        iwsMaitosikaiyakuhr2x88 = pIwsMaitosikaiyakuhr2x88;
    }

    @Column(order = 191, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x89;

    public BizNumber getIwsMaitosikaiyakuhr2x89() {
        return iwsMaitosikaiyakuhr2x89;
    }

    public void setIwsMaitosikaiyakuhr2x89(BizNumber pIwsMaitosikaiyakuhr2x89) {
        iwsMaitosikaiyakuhr2x89 = pIwsMaitosikaiyakuhr2x89;
    }

    @Column(order = 192, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x90;

    public BizNumber getIwsMaitosikaiyakuhr2x90() {
        return iwsMaitosikaiyakuhr2x90;
    }

    public void setIwsMaitosikaiyakuhr2x90(BizNumber pIwsMaitosikaiyakuhr2x90) {
        iwsMaitosikaiyakuhr2x90 = pIwsMaitosikaiyakuhr2x90;
    }

    @Column(order = 193, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x91;

    public BizNumber getIwsMaitosikaiyakuhr2x91() {
        return iwsMaitosikaiyakuhr2x91;
    }

    public void setIwsMaitosikaiyakuhr2x91(BizNumber pIwsMaitosikaiyakuhr2x91) {
        iwsMaitosikaiyakuhr2x91 = pIwsMaitosikaiyakuhr2x91;
    }

    @Column(order = 194, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x92;

    public BizNumber getIwsMaitosikaiyakuhr2x92() {
        return iwsMaitosikaiyakuhr2x92;
    }

    public void setIwsMaitosikaiyakuhr2x92(BizNumber pIwsMaitosikaiyakuhr2x92) {
        iwsMaitosikaiyakuhr2x92 = pIwsMaitosikaiyakuhr2x92;
    }

    @Column(order = 195, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x93;

    public BizNumber getIwsMaitosikaiyakuhr2x93() {
        return iwsMaitosikaiyakuhr2x93;
    }

    public void setIwsMaitosikaiyakuhr2x93(BizNumber pIwsMaitosikaiyakuhr2x93) {
        iwsMaitosikaiyakuhr2x93 = pIwsMaitosikaiyakuhr2x93;
    }

    @Column(order = 196, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x94;

    public BizNumber getIwsMaitosikaiyakuhr2x94() {
        return iwsMaitosikaiyakuhr2x94;
    }

    public void setIwsMaitosikaiyakuhr2x94(BizNumber pIwsMaitosikaiyakuhr2x94) {
        iwsMaitosikaiyakuhr2x94 = pIwsMaitosikaiyakuhr2x94;
    }

    @Column(order = 197, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x95;

    public BizNumber getIwsMaitosikaiyakuhr2x95() {
        return iwsMaitosikaiyakuhr2x95;
    }

    public void setIwsMaitosikaiyakuhr2x95(BizNumber pIwsMaitosikaiyakuhr2x95) {
        iwsMaitosikaiyakuhr2x95 = pIwsMaitosikaiyakuhr2x95;
    }

    @Column(order = 198, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x96;

    public BizNumber getIwsMaitosikaiyakuhr2x96() {
        return iwsMaitosikaiyakuhr2x96;
    }

    public void setIwsMaitosikaiyakuhr2x96(BizNumber pIwsMaitosikaiyakuhr2x96) {
        iwsMaitosikaiyakuhr2x96 = pIwsMaitosikaiyakuhr2x96;
    }

    @Column(order = 199, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x97;

    public BizNumber getIwsMaitosikaiyakuhr2x97() {
        return iwsMaitosikaiyakuhr2x97;
    }

    public void setIwsMaitosikaiyakuhr2x97(BizNumber pIwsMaitosikaiyakuhr2x97) {
        iwsMaitosikaiyakuhr2x97 = pIwsMaitosikaiyakuhr2x97;
    }

    @Column(order = 200, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x98;

    public BizNumber getIwsMaitosikaiyakuhr2x98() {
        return iwsMaitosikaiyakuhr2x98;
    }

    public void setIwsMaitosikaiyakuhr2x98(BizNumber pIwsMaitosikaiyakuhr2x98) {
        iwsMaitosikaiyakuhr2x98 = pIwsMaitosikaiyakuhr2x98;
    }

    @Column(order = 201, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x99;

    public BizNumber getIwsMaitosikaiyakuhr2x99() {
        return iwsMaitosikaiyakuhr2x99;
    }

    public void setIwsMaitosikaiyakuhr2x99(BizNumber pIwsMaitosikaiyakuhr2x99) {
        iwsMaitosikaiyakuhr2x99 = pIwsMaitosikaiyakuhr2x99;
    }

    @Column(order = 202, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x1;

    public BizNumber getIwsMaitosikaiyakuhr3x1() {
        return iwsMaitosikaiyakuhr3x1;
    }

    public void setIwsMaitosikaiyakuhr3x1(BizNumber pIwsMaitosikaiyakuhr3x1) {
        iwsMaitosikaiyakuhr3x1 = pIwsMaitosikaiyakuhr3x1;
    }

    @Column(order = 203, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x2;

    public BizNumber getIwsMaitosikaiyakuhr3x2() {
        return iwsMaitosikaiyakuhr3x2;
    }

    public void setIwsMaitosikaiyakuhr3x2(BizNumber pIwsMaitosikaiyakuhr3x2) {
        iwsMaitosikaiyakuhr3x2 = pIwsMaitosikaiyakuhr3x2;
    }

    @Column(order = 204, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x3;

    public BizNumber getIwsMaitosikaiyakuhr3x3() {
        return iwsMaitosikaiyakuhr3x3;
    }

    public void setIwsMaitosikaiyakuhr3x3(BizNumber pIwsMaitosikaiyakuhr3x3) {
        iwsMaitosikaiyakuhr3x3 = pIwsMaitosikaiyakuhr3x3;
    }

    @Column(order = 205, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x4;

    public BizNumber getIwsMaitosikaiyakuhr3x4() {
        return iwsMaitosikaiyakuhr3x4;
    }

    public void setIwsMaitosikaiyakuhr3x4(BizNumber pIwsMaitosikaiyakuhr3x4) {
        iwsMaitosikaiyakuhr3x4 = pIwsMaitosikaiyakuhr3x4;
    }

    @Column(order = 206, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x5;

    public BizNumber getIwsMaitosikaiyakuhr3x5() {
        return iwsMaitosikaiyakuhr3x5;
    }

    public void setIwsMaitosikaiyakuhr3x5(BizNumber pIwsMaitosikaiyakuhr3x5) {
        iwsMaitosikaiyakuhr3x5 = pIwsMaitosikaiyakuhr3x5;
    }

    @Column(order = 207, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x6;

    public BizNumber getIwsMaitosikaiyakuhr3x6() {
        return iwsMaitosikaiyakuhr3x6;
    }

    public void setIwsMaitosikaiyakuhr3x6(BizNumber pIwsMaitosikaiyakuhr3x6) {
        iwsMaitosikaiyakuhr3x6 = pIwsMaitosikaiyakuhr3x6;
    }

    @Column(order = 208, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x7;

    public BizNumber getIwsMaitosikaiyakuhr3x7() {
        return iwsMaitosikaiyakuhr3x7;
    }

    public void setIwsMaitosikaiyakuhr3x7(BizNumber pIwsMaitosikaiyakuhr3x7) {
        iwsMaitosikaiyakuhr3x7 = pIwsMaitosikaiyakuhr3x7;
    }

    @Column(order = 209, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x8;

    public BizNumber getIwsMaitosikaiyakuhr3x8() {
        return iwsMaitosikaiyakuhr3x8;
    }

    public void setIwsMaitosikaiyakuhr3x8(BizNumber pIwsMaitosikaiyakuhr3x8) {
        iwsMaitosikaiyakuhr3x8 = pIwsMaitosikaiyakuhr3x8;
    }

    @Column(order = 210, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x9;

    public BizNumber getIwsMaitosikaiyakuhr3x9() {
        return iwsMaitosikaiyakuhr3x9;
    }

    public void setIwsMaitosikaiyakuhr3x9(BizNumber pIwsMaitosikaiyakuhr3x9) {
        iwsMaitosikaiyakuhr3x9 = pIwsMaitosikaiyakuhr3x9;
    }

    @Column(order = 211, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x10;

    public BizNumber getIwsMaitosikaiyakuhr3x10() {
        return iwsMaitosikaiyakuhr3x10;
    }

    public void setIwsMaitosikaiyakuhr3x10(BizNumber pIwsMaitosikaiyakuhr3x10) {
        iwsMaitosikaiyakuhr3x10 = pIwsMaitosikaiyakuhr3x10;
    }

    @Column(order = 212, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x11;

    public BizNumber getIwsMaitosikaiyakuhr3x11() {
        return iwsMaitosikaiyakuhr3x11;
    }

    public void setIwsMaitosikaiyakuhr3x11(BizNumber pIwsMaitosikaiyakuhr3x11) {
        iwsMaitosikaiyakuhr3x11 = pIwsMaitosikaiyakuhr3x11;
    }

    @Column(order = 213, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x12;

    public BizNumber getIwsMaitosikaiyakuhr3x12() {
        return iwsMaitosikaiyakuhr3x12;
    }

    public void setIwsMaitosikaiyakuhr3x12(BizNumber pIwsMaitosikaiyakuhr3x12) {
        iwsMaitosikaiyakuhr3x12 = pIwsMaitosikaiyakuhr3x12;
    }

    @Column(order = 214, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x13;

    public BizNumber getIwsMaitosikaiyakuhr3x13() {
        return iwsMaitosikaiyakuhr3x13;
    }

    public void setIwsMaitosikaiyakuhr3x13(BizNumber pIwsMaitosikaiyakuhr3x13) {
        iwsMaitosikaiyakuhr3x13 = pIwsMaitosikaiyakuhr3x13;
    }

    @Column(order = 215, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x14;

    public BizNumber getIwsMaitosikaiyakuhr3x14() {
        return iwsMaitosikaiyakuhr3x14;
    }

    public void setIwsMaitosikaiyakuhr3x14(BizNumber pIwsMaitosikaiyakuhr3x14) {
        iwsMaitosikaiyakuhr3x14 = pIwsMaitosikaiyakuhr3x14;
    }

    @Column(order = 216, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x15;

    public BizNumber getIwsMaitosikaiyakuhr3x15() {
        return iwsMaitosikaiyakuhr3x15;
    }

    public void setIwsMaitosikaiyakuhr3x15(BizNumber pIwsMaitosikaiyakuhr3x15) {
        iwsMaitosikaiyakuhr3x15 = pIwsMaitosikaiyakuhr3x15;
    }

    @Column(order = 217, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x16;

    public BizNumber getIwsMaitosikaiyakuhr3x16() {
        return iwsMaitosikaiyakuhr3x16;
    }

    public void setIwsMaitosikaiyakuhr3x16(BizNumber pIwsMaitosikaiyakuhr3x16) {
        iwsMaitosikaiyakuhr3x16 = pIwsMaitosikaiyakuhr3x16;
    }

    @Column(order = 218, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x17;

    public BizNumber getIwsMaitosikaiyakuhr3x17() {
        return iwsMaitosikaiyakuhr3x17;
    }

    public void setIwsMaitosikaiyakuhr3x17(BizNumber pIwsMaitosikaiyakuhr3x17) {
        iwsMaitosikaiyakuhr3x17 = pIwsMaitosikaiyakuhr3x17;
    }

    @Column(order = 219, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x18;

    public BizNumber getIwsMaitosikaiyakuhr3x18() {
        return iwsMaitosikaiyakuhr3x18;
    }

    public void setIwsMaitosikaiyakuhr3x18(BizNumber pIwsMaitosikaiyakuhr3x18) {
        iwsMaitosikaiyakuhr3x18 = pIwsMaitosikaiyakuhr3x18;
    }

    @Column(order = 220, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x19;

    public BizNumber getIwsMaitosikaiyakuhr3x19() {
        return iwsMaitosikaiyakuhr3x19;
    }

    public void setIwsMaitosikaiyakuhr3x19(BizNumber pIwsMaitosikaiyakuhr3x19) {
        iwsMaitosikaiyakuhr3x19 = pIwsMaitosikaiyakuhr3x19;
    }

    @Column(order = 221, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x20;

    public BizNumber getIwsMaitosikaiyakuhr3x20() {
        return iwsMaitosikaiyakuhr3x20;
    }

    public void setIwsMaitosikaiyakuhr3x20(BizNumber pIwsMaitosikaiyakuhr3x20) {
        iwsMaitosikaiyakuhr3x20 = pIwsMaitosikaiyakuhr3x20;
    }

    @Column(order = 222, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x21;

    public BizNumber getIwsMaitosikaiyakuhr3x21() {
        return iwsMaitosikaiyakuhr3x21;
    }

    public void setIwsMaitosikaiyakuhr3x21(BizNumber pIwsMaitosikaiyakuhr3x21) {
        iwsMaitosikaiyakuhr3x21 = pIwsMaitosikaiyakuhr3x21;
    }

    @Column(order = 223, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x22;

    public BizNumber getIwsMaitosikaiyakuhr3x22() {
        return iwsMaitosikaiyakuhr3x22;
    }

    public void setIwsMaitosikaiyakuhr3x22(BizNumber pIwsMaitosikaiyakuhr3x22) {
        iwsMaitosikaiyakuhr3x22 = pIwsMaitosikaiyakuhr3x22;
    }

    @Column(order = 224, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x23;

    public BizNumber getIwsMaitosikaiyakuhr3x23() {
        return iwsMaitosikaiyakuhr3x23;
    }

    public void setIwsMaitosikaiyakuhr3x23(BizNumber pIwsMaitosikaiyakuhr3x23) {
        iwsMaitosikaiyakuhr3x23 = pIwsMaitosikaiyakuhr3x23;
    }

    @Column(order = 225, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x24;

    public BizNumber getIwsMaitosikaiyakuhr3x24() {
        return iwsMaitosikaiyakuhr3x24;
    }

    public void setIwsMaitosikaiyakuhr3x24(BizNumber pIwsMaitosikaiyakuhr3x24) {
        iwsMaitosikaiyakuhr3x24 = pIwsMaitosikaiyakuhr3x24;
    }

    @Column(order = 226, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x25;

    public BizNumber getIwsMaitosikaiyakuhr3x25() {
        return iwsMaitosikaiyakuhr3x25;
    }

    public void setIwsMaitosikaiyakuhr3x25(BizNumber pIwsMaitosikaiyakuhr3x25) {
        iwsMaitosikaiyakuhr3x25 = pIwsMaitosikaiyakuhr3x25;
    }

    @Column(order = 227, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x26;

    public BizNumber getIwsMaitosikaiyakuhr3x26() {
        return iwsMaitosikaiyakuhr3x26;
    }

    public void setIwsMaitosikaiyakuhr3x26(BizNumber pIwsMaitosikaiyakuhr3x26) {
        iwsMaitosikaiyakuhr3x26 = pIwsMaitosikaiyakuhr3x26;
    }

    @Column(order = 228, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x27;

    public BizNumber getIwsMaitosikaiyakuhr3x27() {
        return iwsMaitosikaiyakuhr3x27;
    }

    public void setIwsMaitosikaiyakuhr3x27(BizNumber pIwsMaitosikaiyakuhr3x27) {
        iwsMaitosikaiyakuhr3x27 = pIwsMaitosikaiyakuhr3x27;
    }

    @Column(order = 229, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x28;

    public BizNumber getIwsMaitosikaiyakuhr3x28() {
        return iwsMaitosikaiyakuhr3x28;
    }

    public void setIwsMaitosikaiyakuhr3x28(BizNumber pIwsMaitosikaiyakuhr3x28) {
        iwsMaitosikaiyakuhr3x28 = pIwsMaitosikaiyakuhr3x28;
    }

    @Column(order = 230, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x29;

    public BizNumber getIwsMaitosikaiyakuhr3x29() {
        return iwsMaitosikaiyakuhr3x29;
    }

    public void setIwsMaitosikaiyakuhr3x29(BizNumber pIwsMaitosikaiyakuhr3x29) {
        iwsMaitosikaiyakuhr3x29 = pIwsMaitosikaiyakuhr3x29;
    }

    @Column(order = 231, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x30;

    public BizNumber getIwsMaitosikaiyakuhr3x30() {
        return iwsMaitosikaiyakuhr3x30;
    }

    public void setIwsMaitosikaiyakuhr3x30(BizNumber pIwsMaitosikaiyakuhr3x30) {
        iwsMaitosikaiyakuhr3x30 = pIwsMaitosikaiyakuhr3x30;
    }

    @Column(order = 232, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x31;

    public BizNumber getIwsMaitosikaiyakuhr3x31() {
        return iwsMaitosikaiyakuhr3x31;
    }

    public void setIwsMaitosikaiyakuhr3x31(BizNumber pIwsMaitosikaiyakuhr3x31) {
        iwsMaitosikaiyakuhr3x31 = pIwsMaitosikaiyakuhr3x31;
    }

    @Column(order = 233, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x32;

    public BizNumber getIwsMaitosikaiyakuhr3x32() {
        return iwsMaitosikaiyakuhr3x32;
    }

    public void setIwsMaitosikaiyakuhr3x32(BizNumber pIwsMaitosikaiyakuhr3x32) {
        iwsMaitosikaiyakuhr3x32 = pIwsMaitosikaiyakuhr3x32;
    }

    @Column(order = 234, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x33;

    public BizNumber getIwsMaitosikaiyakuhr3x33() {
        return iwsMaitosikaiyakuhr3x33;
    }

    public void setIwsMaitosikaiyakuhr3x33(BizNumber pIwsMaitosikaiyakuhr3x33) {
        iwsMaitosikaiyakuhr3x33 = pIwsMaitosikaiyakuhr3x33;
    }

    @Column(order = 235, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x34;

    public BizNumber getIwsMaitosikaiyakuhr3x34() {
        return iwsMaitosikaiyakuhr3x34;
    }

    public void setIwsMaitosikaiyakuhr3x34(BizNumber pIwsMaitosikaiyakuhr3x34) {
        iwsMaitosikaiyakuhr3x34 = pIwsMaitosikaiyakuhr3x34;
    }

    @Column(order = 236, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x35;

    public BizNumber getIwsMaitosikaiyakuhr3x35() {
        return iwsMaitosikaiyakuhr3x35;
    }

    public void setIwsMaitosikaiyakuhr3x35(BizNumber pIwsMaitosikaiyakuhr3x35) {
        iwsMaitosikaiyakuhr3x35 = pIwsMaitosikaiyakuhr3x35;
    }

    @Column(order = 237, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x36;

    public BizNumber getIwsMaitosikaiyakuhr3x36() {
        return iwsMaitosikaiyakuhr3x36;
    }

    public void setIwsMaitosikaiyakuhr3x36(BizNumber pIwsMaitosikaiyakuhr3x36) {
        iwsMaitosikaiyakuhr3x36 = pIwsMaitosikaiyakuhr3x36;
    }

    @Column(order = 238, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x37;

    public BizNumber getIwsMaitosikaiyakuhr3x37() {
        return iwsMaitosikaiyakuhr3x37;
    }

    public void setIwsMaitosikaiyakuhr3x37(BizNumber pIwsMaitosikaiyakuhr3x37) {
        iwsMaitosikaiyakuhr3x37 = pIwsMaitosikaiyakuhr3x37;
    }

    @Column(order = 239, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x38;

    public BizNumber getIwsMaitosikaiyakuhr3x38() {
        return iwsMaitosikaiyakuhr3x38;
    }

    public void setIwsMaitosikaiyakuhr3x38(BizNumber pIwsMaitosikaiyakuhr3x38) {
        iwsMaitosikaiyakuhr3x38 = pIwsMaitosikaiyakuhr3x38;
    }

    @Column(order = 240, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x39;

    public BizNumber getIwsMaitosikaiyakuhr3x39() {
        return iwsMaitosikaiyakuhr3x39;
    }

    public void setIwsMaitosikaiyakuhr3x39(BizNumber pIwsMaitosikaiyakuhr3x39) {
        iwsMaitosikaiyakuhr3x39 = pIwsMaitosikaiyakuhr3x39;
    }

    @Column(order = 241, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x40;

    public BizNumber getIwsMaitosikaiyakuhr3x40() {
        return iwsMaitosikaiyakuhr3x40;
    }

    public void setIwsMaitosikaiyakuhr3x40(BizNumber pIwsMaitosikaiyakuhr3x40) {
        iwsMaitosikaiyakuhr3x40 = pIwsMaitosikaiyakuhr3x40;
    }

    @Column(order = 242, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x41;

    public BizNumber getIwsMaitosikaiyakuhr3x41() {
        return iwsMaitosikaiyakuhr3x41;
    }

    public void setIwsMaitosikaiyakuhr3x41(BizNumber pIwsMaitosikaiyakuhr3x41) {
        iwsMaitosikaiyakuhr3x41 = pIwsMaitosikaiyakuhr3x41;
    }

    @Column(order = 243, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x42;

    public BizNumber getIwsMaitosikaiyakuhr3x42() {
        return iwsMaitosikaiyakuhr3x42;
    }

    public void setIwsMaitosikaiyakuhr3x42(BizNumber pIwsMaitosikaiyakuhr3x42) {
        iwsMaitosikaiyakuhr3x42 = pIwsMaitosikaiyakuhr3x42;
    }

    @Column(order = 244, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x43;

    public BizNumber getIwsMaitosikaiyakuhr3x43() {
        return iwsMaitosikaiyakuhr3x43;
    }

    public void setIwsMaitosikaiyakuhr3x43(BizNumber pIwsMaitosikaiyakuhr3x43) {
        iwsMaitosikaiyakuhr3x43 = pIwsMaitosikaiyakuhr3x43;
    }

    @Column(order = 245, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x44;

    public BizNumber getIwsMaitosikaiyakuhr3x44() {
        return iwsMaitosikaiyakuhr3x44;
    }

    public void setIwsMaitosikaiyakuhr3x44(BizNumber pIwsMaitosikaiyakuhr3x44) {
        iwsMaitosikaiyakuhr3x44 = pIwsMaitosikaiyakuhr3x44;
    }

    @Column(order = 246, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x45;

    public BizNumber getIwsMaitosikaiyakuhr3x45() {
        return iwsMaitosikaiyakuhr3x45;
    }

    public void setIwsMaitosikaiyakuhr3x45(BizNumber pIwsMaitosikaiyakuhr3x45) {
        iwsMaitosikaiyakuhr3x45 = pIwsMaitosikaiyakuhr3x45;
    }

    @Column(order = 247, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x46;

    public BizNumber getIwsMaitosikaiyakuhr3x46() {
        return iwsMaitosikaiyakuhr3x46;
    }

    public void setIwsMaitosikaiyakuhr3x46(BizNumber pIwsMaitosikaiyakuhr3x46) {
        iwsMaitosikaiyakuhr3x46 = pIwsMaitosikaiyakuhr3x46;
    }

    @Column(order = 248, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x47;

    public BizNumber getIwsMaitosikaiyakuhr3x47() {
        return iwsMaitosikaiyakuhr3x47;
    }

    public void setIwsMaitosikaiyakuhr3x47(BizNumber pIwsMaitosikaiyakuhr3x47) {
        iwsMaitosikaiyakuhr3x47 = pIwsMaitosikaiyakuhr3x47;
    }

    @Column(order = 249, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x48;

    public BizNumber getIwsMaitosikaiyakuhr3x48() {
        return iwsMaitosikaiyakuhr3x48;
    }

    public void setIwsMaitosikaiyakuhr3x48(BizNumber pIwsMaitosikaiyakuhr3x48) {
        iwsMaitosikaiyakuhr3x48 = pIwsMaitosikaiyakuhr3x48;
    }

    @Column(order = 250, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x49;

    public BizNumber getIwsMaitosikaiyakuhr3x49() {
        return iwsMaitosikaiyakuhr3x49;
    }

    public void setIwsMaitosikaiyakuhr3x49(BizNumber pIwsMaitosikaiyakuhr3x49) {
        iwsMaitosikaiyakuhr3x49 = pIwsMaitosikaiyakuhr3x49;
    }

    @Column(order = 251, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x50;

    public BizNumber getIwsMaitosikaiyakuhr3x50() {
        return iwsMaitosikaiyakuhr3x50;
    }

    public void setIwsMaitosikaiyakuhr3x50(BizNumber pIwsMaitosikaiyakuhr3x50) {
        iwsMaitosikaiyakuhr3x50 = pIwsMaitosikaiyakuhr3x50;
    }

    @Column(order = 252, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x51;

    public BizNumber getIwsMaitosikaiyakuhr3x51() {
        return iwsMaitosikaiyakuhr3x51;
    }

    public void setIwsMaitosikaiyakuhr3x51(BizNumber pIwsMaitosikaiyakuhr3x51) {
        iwsMaitosikaiyakuhr3x51 = pIwsMaitosikaiyakuhr3x51;
    }

    @Column(order = 253, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x52;

    public BizNumber getIwsMaitosikaiyakuhr3x52() {
        return iwsMaitosikaiyakuhr3x52;
    }

    public void setIwsMaitosikaiyakuhr3x52(BizNumber pIwsMaitosikaiyakuhr3x52) {
        iwsMaitosikaiyakuhr3x52 = pIwsMaitosikaiyakuhr3x52;
    }

    @Column(order = 254, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x53;

    public BizNumber getIwsMaitosikaiyakuhr3x53() {
        return iwsMaitosikaiyakuhr3x53;
    }

    public void setIwsMaitosikaiyakuhr3x53(BizNumber pIwsMaitosikaiyakuhr3x53) {
        iwsMaitosikaiyakuhr3x53 = pIwsMaitosikaiyakuhr3x53;
    }

    @Column(order = 255, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x54;

    public BizNumber getIwsMaitosikaiyakuhr3x54() {
        return iwsMaitosikaiyakuhr3x54;
    }

    public void setIwsMaitosikaiyakuhr3x54(BizNumber pIwsMaitosikaiyakuhr3x54) {
        iwsMaitosikaiyakuhr3x54 = pIwsMaitosikaiyakuhr3x54;
    }

    @Column(order = 256, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x55;

    public BizNumber getIwsMaitosikaiyakuhr3x55() {
        return iwsMaitosikaiyakuhr3x55;
    }

    public void setIwsMaitosikaiyakuhr3x55(BizNumber pIwsMaitosikaiyakuhr3x55) {
        iwsMaitosikaiyakuhr3x55 = pIwsMaitosikaiyakuhr3x55;
    }

    @Column(order = 257, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x56;

    public BizNumber getIwsMaitosikaiyakuhr3x56() {
        return iwsMaitosikaiyakuhr3x56;
    }

    public void setIwsMaitosikaiyakuhr3x56(BizNumber pIwsMaitosikaiyakuhr3x56) {
        iwsMaitosikaiyakuhr3x56 = pIwsMaitosikaiyakuhr3x56;
    }

    @Column(order = 258, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x57;

    public BizNumber getIwsMaitosikaiyakuhr3x57() {
        return iwsMaitosikaiyakuhr3x57;
    }

    public void setIwsMaitosikaiyakuhr3x57(BizNumber pIwsMaitosikaiyakuhr3x57) {
        iwsMaitosikaiyakuhr3x57 = pIwsMaitosikaiyakuhr3x57;
    }

    @Column(order = 259, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x58;

    public BizNumber getIwsMaitosikaiyakuhr3x58() {
        return iwsMaitosikaiyakuhr3x58;
    }

    public void setIwsMaitosikaiyakuhr3x58(BizNumber pIwsMaitosikaiyakuhr3x58) {
        iwsMaitosikaiyakuhr3x58 = pIwsMaitosikaiyakuhr3x58;
    }

    @Column(order = 260, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x59;

    public BizNumber getIwsMaitosikaiyakuhr3x59() {
        return iwsMaitosikaiyakuhr3x59;
    }

    public void setIwsMaitosikaiyakuhr3x59(BizNumber pIwsMaitosikaiyakuhr3x59) {
        iwsMaitosikaiyakuhr3x59 = pIwsMaitosikaiyakuhr3x59;
    }

    @Column(order = 261, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x60;

    public BizNumber getIwsMaitosikaiyakuhr3x60() {
        return iwsMaitosikaiyakuhr3x60;
    }

    public void setIwsMaitosikaiyakuhr3x60(BizNumber pIwsMaitosikaiyakuhr3x60) {
        iwsMaitosikaiyakuhr3x60 = pIwsMaitosikaiyakuhr3x60;
    }

    @Column(order = 262, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x61;

    public BizNumber getIwsMaitosikaiyakuhr3x61() {
        return iwsMaitosikaiyakuhr3x61;
    }

    public void setIwsMaitosikaiyakuhr3x61(BizNumber pIwsMaitosikaiyakuhr3x61) {
        iwsMaitosikaiyakuhr3x61 = pIwsMaitosikaiyakuhr3x61;
    }

    @Column(order = 263, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x62;

    public BizNumber getIwsMaitosikaiyakuhr3x62() {
        return iwsMaitosikaiyakuhr3x62;
    }

    public void setIwsMaitosikaiyakuhr3x62(BizNumber pIwsMaitosikaiyakuhr3x62) {
        iwsMaitosikaiyakuhr3x62 = pIwsMaitosikaiyakuhr3x62;
    }

    @Column(order = 264, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x63;

    public BizNumber getIwsMaitosikaiyakuhr3x63() {
        return iwsMaitosikaiyakuhr3x63;
    }

    public void setIwsMaitosikaiyakuhr3x63(BizNumber pIwsMaitosikaiyakuhr3x63) {
        iwsMaitosikaiyakuhr3x63 = pIwsMaitosikaiyakuhr3x63;
    }

    @Column(order = 265, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x64;

    public BizNumber getIwsMaitosikaiyakuhr3x64() {
        return iwsMaitosikaiyakuhr3x64;
    }

    public void setIwsMaitosikaiyakuhr3x64(BizNumber pIwsMaitosikaiyakuhr3x64) {
        iwsMaitosikaiyakuhr3x64 = pIwsMaitosikaiyakuhr3x64;
    }

    @Column(order = 266, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x65;

    public BizNumber getIwsMaitosikaiyakuhr3x65() {
        return iwsMaitosikaiyakuhr3x65;
    }

    public void setIwsMaitosikaiyakuhr3x65(BizNumber pIwsMaitosikaiyakuhr3x65) {
        iwsMaitosikaiyakuhr3x65 = pIwsMaitosikaiyakuhr3x65;
    }

    @Column(order = 267, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x66;

    public BizNumber getIwsMaitosikaiyakuhr3x66() {
        return iwsMaitosikaiyakuhr3x66;
    }

    public void setIwsMaitosikaiyakuhr3x66(BizNumber pIwsMaitosikaiyakuhr3x66) {
        iwsMaitosikaiyakuhr3x66 = pIwsMaitosikaiyakuhr3x66;
    }

    @Column(order = 268, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x67;

    public BizNumber getIwsMaitosikaiyakuhr3x67() {
        return iwsMaitosikaiyakuhr3x67;
    }

    public void setIwsMaitosikaiyakuhr3x67(BizNumber pIwsMaitosikaiyakuhr3x67) {
        iwsMaitosikaiyakuhr3x67 = pIwsMaitosikaiyakuhr3x67;
    }

    @Column(order = 269, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x68;

    public BizNumber getIwsMaitosikaiyakuhr3x68() {
        return iwsMaitosikaiyakuhr3x68;
    }

    public void setIwsMaitosikaiyakuhr3x68(BizNumber pIwsMaitosikaiyakuhr3x68) {
        iwsMaitosikaiyakuhr3x68 = pIwsMaitosikaiyakuhr3x68;
    }

    @Column(order = 270, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x69;

    public BizNumber getIwsMaitosikaiyakuhr3x69() {
        return iwsMaitosikaiyakuhr3x69;
    }

    public void setIwsMaitosikaiyakuhr3x69(BizNumber pIwsMaitosikaiyakuhr3x69) {
        iwsMaitosikaiyakuhr3x69 = pIwsMaitosikaiyakuhr3x69;
    }

    @Column(order = 271, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x70;

    public BizNumber getIwsMaitosikaiyakuhr3x70() {
        return iwsMaitosikaiyakuhr3x70;
    }

    public void setIwsMaitosikaiyakuhr3x70(BizNumber pIwsMaitosikaiyakuhr3x70) {
        iwsMaitosikaiyakuhr3x70 = pIwsMaitosikaiyakuhr3x70;
    }

    @Column(order = 272, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x71;

    public BizNumber getIwsMaitosikaiyakuhr3x71() {
        return iwsMaitosikaiyakuhr3x71;
    }

    public void setIwsMaitosikaiyakuhr3x71(BizNumber pIwsMaitosikaiyakuhr3x71) {
        iwsMaitosikaiyakuhr3x71 = pIwsMaitosikaiyakuhr3x71;
    }

    @Column(order = 273, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x72;

    public BizNumber getIwsMaitosikaiyakuhr3x72() {
        return iwsMaitosikaiyakuhr3x72;
    }

    public void setIwsMaitosikaiyakuhr3x72(BizNumber pIwsMaitosikaiyakuhr3x72) {
        iwsMaitosikaiyakuhr3x72 = pIwsMaitosikaiyakuhr3x72;
    }

    @Column(order = 274, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x73;

    public BizNumber getIwsMaitosikaiyakuhr3x73() {
        return iwsMaitosikaiyakuhr3x73;
    }

    public void setIwsMaitosikaiyakuhr3x73(BizNumber pIwsMaitosikaiyakuhr3x73) {
        iwsMaitosikaiyakuhr3x73 = pIwsMaitosikaiyakuhr3x73;
    }

    @Column(order = 275, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x74;

    public BizNumber getIwsMaitosikaiyakuhr3x74() {
        return iwsMaitosikaiyakuhr3x74;
    }

    public void setIwsMaitosikaiyakuhr3x74(BizNumber pIwsMaitosikaiyakuhr3x74) {
        iwsMaitosikaiyakuhr3x74 = pIwsMaitosikaiyakuhr3x74;
    }

    @Column(order = 276, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x75;

    public BizNumber getIwsMaitosikaiyakuhr3x75() {
        return iwsMaitosikaiyakuhr3x75;
    }

    public void setIwsMaitosikaiyakuhr3x75(BizNumber pIwsMaitosikaiyakuhr3x75) {
        iwsMaitosikaiyakuhr3x75 = pIwsMaitosikaiyakuhr3x75;
    }

    @Column(order = 277, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x76;

    public BizNumber getIwsMaitosikaiyakuhr3x76() {
        return iwsMaitosikaiyakuhr3x76;
    }

    public void setIwsMaitosikaiyakuhr3x76(BizNumber pIwsMaitosikaiyakuhr3x76) {
        iwsMaitosikaiyakuhr3x76 = pIwsMaitosikaiyakuhr3x76;
    }

    @Column(order = 278, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x77;

    public BizNumber getIwsMaitosikaiyakuhr3x77() {
        return iwsMaitosikaiyakuhr3x77;
    }

    public void setIwsMaitosikaiyakuhr3x77(BizNumber pIwsMaitosikaiyakuhr3x77) {
        iwsMaitosikaiyakuhr3x77 = pIwsMaitosikaiyakuhr3x77;
    }

    @Column(order = 279, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x78;

    public BizNumber getIwsMaitosikaiyakuhr3x78() {
        return iwsMaitosikaiyakuhr3x78;
    }

    public void setIwsMaitosikaiyakuhr3x78(BizNumber pIwsMaitosikaiyakuhr3x78) {
        iwsMaitosikaiyakuhr3x78 = pIwsMaitosikaiyakuhr3x78;
    }

    @Column(order = 280, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x79;

    public BizNumber getIwsMaitosikaiyakuhr3x79() {
        return iwsMaitosikaiyakuhr3x79;
    }

    public void setIwsMaitosikaiyakuhr3x79(BizNumber pIwsMaitosikaiyakuhr3x79) {
        iwsMaitosikaiyakuhr3x79 = pIwsMaitosikaiyakuhr3x79;
    }

    @Column(order = 281, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x80;

    public BizNumber getIwsMaitosikaiyakuhr3x80() {
        return iwsMaitosikaiyakuhr3x80;
    }

    public void setIwsMaitosikaiyakuhr3x80(BizNumber pIwsMaitosikaiyakuhr3x80) {
        iwsMaitosikaiyakuhr3x80 = pIwsMaitosikaiyakuhr3x80;
    }

    @Column(order = 282, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x81;

    public BizNumber getIwsMaitosikaiyakuhr3x81() {
        return iwsMaitosikaiyakuhr3x81;
    }

    public void setIwsMaitosikaiyakuhr3x81(BizNumber pIwsMaitosikaiyakuhr3x81) {
        iwsMaitosikaiyakuhr3x81 = pIwsMaitosikaiyakuhr3x81;
    }

    @Column(order = 283, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x82;

    public BizNumber getIwsMaitosikaiyakuhr3x82() {
        return iwsMaitosikaiyakuhr3x82;
    }

    public void setIwsMaitosikaiyakuhr3x82(BizNumber pIwsMaitosikaiyakuhr3x82) {
        iwsMaitosikaiyakuhr3x82 = pIwsMaitosikaiyakuhr3x82;
    }

    @Column(order = 284, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x83;

    public BizNumber getIwsMaitosikaiyakuhr3x83() {
        return iwsMaitosikaiyakuhr3x83;
    }

    public void setIwsMaitosikaiyakuhr3x83(BizNumber pIwsMaitosikaiyakuhr3x83) {
        iwsMaitosikaiyakuhr3x83 = pIwsMaitosikaiyakuhr3x83;
    }

    @Column(order = 285, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x84;

    public BizNumber getIwsMaitosikaiyakuhr3x84() {
        return iwsMaitosikaiyakuhr3x84;
    }

    public void setIwsMaitosikaiyakuhr3x84(BizNumber pIwsMaitosikaiyakuhr3x84) {
        iwsMaitosikaiyakuhr3x84 = pIwsMaitosikaiyakuhr3x84;
    }

    @Column(order = 286, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x85;

    public BizNumber getIwsMaitosikaiyakuhr3x85() {
        return iwsMaitosikaiyakuhr3x85;
    }

    public void setIwsMaitosikaiyakuhr3x85(BizNumber pIwsMaitosikaiyakuhr3x85) {
        iwsMaitosikaiyakuhr3x85 = pIwsMaitosikaiyakuhr3x85;
    }

    @Column(order = 287, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x86;

    public BizNumber getIwsMaitosikaiyakuhr3x86() {
        return iwsMaitosikaiyakuhr3x86;
    }

    public void setIwsMaitosikaiyakuhr3x86(BizNumber pIwsMaitosikaiyakuhr3x86) {
        iwsMaitosikaiyakuhr3x86 = pIwsMaitosikaiyakuhr3x86;
    }

    @Column(order = 288, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x87;

    public BizNumber getIwsMaitosikaiyakuhr3x87() {
        return iwsMaitosikaiyakuhr3x87;
    }

    public void setIwsMaitosikaiyakuhr3x87(BizNumber pIwsMaitosikaiyakuhr3x87) {
        iwsMaitosikaiyakuhr3x87 = pIwsMaitosikaiyakuhr3x87;
    }

    @Column(order = 289, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x88;

    public BizNumber getIwsMaitosikaiyakuhr3x88() {
        return iwsMaitosikaiyakuhr3x88;
    }

    public void setIwsMaitosikaiyakuhr3x88(BizNumber pIwsMaitosikaiyakuhr3x88) {
        iwsMaitosikaiyakuhr3x88 = pIwsMaitosikaiyakuhr3x88;
    }

    @Column(order = 290, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x89;

    public BizNumber getIwsMaitosikaiyakuhr3x89() {
        return iwsMaitosikaiyakuhr3x89;
    }

    public void setIwsMaitosikaiyakuhr3x89(BizNumber pIwsMaitosikaiyakuhr3x89) {
        iwsMaitosikaiyakuhr3x89 = pIwsMaitosikaiyakuhr3x89;
    }

    @Column(order = 291, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x90;

    public BizNumber getIwsMaitosikaiyakuhr3x90() {
        return iwsMaitosikaiyakuhr3x90;
    }

    public void setIwsMaitosikaiyakuhr3x90(BizNumber pIwsMaitosikaiyakuhr3x90) {
        iwsMaitosikaiyakuhr3x90 = pIwsMaitosikaiyakuhr3x90;
    }

    @Column(order = 292, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x91;

    public BizNumber getIwsMaitosikaiyakuhr3x91() {
        return iwsMaitosikaiyakuhr3x91;
    }

    public void setIwsMaitosikaiyakuhr3x91(BizNumber pIwsMaitosikaiyakuhr3x91) {
        iwsMaitosikaiyakuhr3x91 = pIwsMaitosikaiyakuhr3x91;
    }

    @Column(order = 293, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x92;

    public BizNumber getIwsMaitosikaiyakuhr3x92() {
        return iwsMaitosikaiyakuhr3x92;
    }

    public void setIwsMaitosikaiyakuhr3x92(BizNumber pIwsMaitosikaiyakuhr3x92) {
        iwsMaitosikaiyakuhr3x92 = pIwsMaitosikaiyakuhr3x92;
    }

    @Column(order = 294, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x93;

    public BizNumber getIwsMaitosikaiyakuhr3x93() {
        return iwsMaitosikaiyakuhr3x93;
    }

    public void setIwsMaitosikaiyakuhr3x93(BizNumber pIwsMaitosikaiyakuhr3x93) {
        iwsMaitosikaiyakuhr3x93 = pIwsMaitosikaiyakuhr3x93;
    }

    @Column(order = 295, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x94;

    public BizNumber getIwsMaitosikaiyakuhr3x94() {
        return iwsMaitosikaiyakuhr3x94;
    }

    public void setIwsMaitosikaiyakuhr3x94(BizNumber pIwsMaitosikaiyakuhr3x94) {
        iwsMaitosikaiyakuhr3x94 = pIwsMaitosikaiyakuhr3x94;
    }

    @Column(order = 296, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x95;

    public BizNumber getIwsMaitosikaiyakuhr3x95() {
        return iwsMaitosikaiyakuhr3x95;
    }

    public void setIwsMaitosikaiyakuhr3x95(BizNumber pIwsMaitosikaiyakuhr3x95) {
        iwsMaitosikaiyakuhr3x95 = pIwsMaitosikaiyakuhr3x95;
    }

    @Column(order = 297, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x96;

    public BizNumber getIwsMaitosikaiyakuhr3x96() {
        return iwsMaitosikaiyakuhr3x96;
    }

    public void setIwsMaitosikaiyakuhr3x96(BizNumber pIwsMaitosikaiyakuhr3x96) {
        iwsMaitosikaiyakuhr3x96 = pIwsMaitosikaiyakuhr3x96;
    }

    @Column(order = 298, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x97;

    public BizNumber getIwsMaitosikaiyakuhr3x97() {
        return iwsMaitosikaiyakuhr3x97;
    }

    public void setIwsMaitosikaiyakuhr3x97(BizNumber pIwsMaitosikaiyakuhr3x97) {
        iwsMaitosikaiyakuhr3x97 = pIwsMaitosikaiyakuhr3x97;
    }

    @Column(order = 299, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x98;

    public BizNumber getIwsMaitosikaiyakuhr3x98() {
        return iwsMaitosikaiyakuhr3x98;
    }

    public void setIwsMaitosikaiyakuhr3x98(BizNumber pIwsMaitosikaiyakuhr3x98) {
        iwsMaitosikaiyakuhr3x98 = pIwsMaitosikaiyakuhr3x98;
    }

    @Column(order = 300, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x99;

    public BizNumber getIwsMaitosikaiyakuhr3x99() {
        return iwsMaitosikaiyakuhr3x99;
    }

    public void setIwsMaitosikaiyakuhr3x99(BizNumber pIwsMaitosikaiyakuhr3x99) {
        iwsMaitosikaiyakuhr3x99 = pIwsMaitosikaiyakuhr3x99;
    }

    @Column(order = 301, length = 13)
    private BizNumber iwsMaitositumitatekin1x1;

    public BizNumber getIwsMaitositumitatekin1x1() {
        return iwsMaitositumitatekin1x1;
    }

    public void setIwsMaitositumitatekin1x1(BizNumber pIwsMaitositumitatekin1x1) {
        iwsMaitositumitatekin1x1 = pIwsMaitositumitatekin1x1;
    }

    @Column(order = 302, length = 13)
    private BizNumber iwsMaitositumitatekin1x2;

    public BizNumber getIwsMaitositumitatekin1x2() {
        return iwsMaitositumitatekin1x2;
    }

    public void setIwsMaitositumitatekin1x2(BizNumber pIwsMaitositumitatekin1x2) {
        iwsMaitositumitatekin1x2 = pIwsMaitositumitatekin1x2;
    }

    @Column(order = 303, length = 13)
    private BizNumber iwsMaitositumitatekin1x3;

    public BizNumber getIwsMaitositumitatekin1x3() {
        return iwsMaitositumitatekin1x3;
    }

    public void setIwsMaitositumitatekin1x3(BizNumber pIwsMaitositumitatekin1x3) {
        iwsMaitositumitatekin1x3 = pIwsMaitositumitatekin1x3;
    }

    @Column(order = 304, length = 13)
    private BizNumber iwsMaitositumitatekin1x4;

    public BizNumber getIwsMaitositumitatekin1x4() {
        return iwsMaitositumitatekin1x4;
    }

    public void setIwsMaitositumitatekin1x4(BizNumber pIwsMaitositumitatekin1x4) {
        iwsMaitositumitatekin1x4 = pIwsMaitositumitatekin1x4;
    }

    @Column(order = 305, length = 13)
    private BizNumber iwsMaitositumitatekin1x5;

    public BizNumber getIwsMaitositumitatekin1x5() {
        return iwsMaitositumitatekin1x5;
    }

    public void setIwsMaitositumitatekin1x5(BizNumber pIwsMaitositumitatekin1x5) {
        iwsMaitositumitatekin1x5 = pIwsMaitositumitatekin1x5;
    }

    @Column(order = 306, length = 13)
    private BizNumber iwsMaitositumitatekin1x6;

    public BizNumber getIwsMaitositumitatekin1x6() {
        return iwsMaitositumitatekin1x6;
    }

    public void setIwsMaitositumitatekin1x6(BizNumber pIwsMaitositumitatekin1x6) {
        iwsMaitositumitatekin1x6 = pIwsMaitositumitatekin1x6;
    }

    @Column(order = 307, length = 13)
    private BizNumber iwsMaitositumitatekin1x7;

    public BizNumber getIwsMaitositumitatekin1x7() {
        return iwsMaitositumitatekin1x7;
    }

    public void setIwsMaitositumitatekin1x7(BizNumber pIwsMaitositumitatekin1x7) {
        iwsMaitositumitatekin1x7 = pIwsMaitositumitatekin1x7;
    }

    @Column(order = 308, length = 13)
    private BizNumber iwsMaitositumitatekin1x8;

    public BizNumber getIwsMaitositumitatekin1x8() {
        return iwsMaitositumitatekin1x8;
    }

    public void setIwsMaitositumitatekin1x8(BizNumber pIwsMaitositumitatekin1x8) {
        iwsMaitositumitatekin1x8 = pIwsMaitositumitatekin1x8;
    }

    @Column(order = 309, length = 13)
    private BizNumber iwsMaitositumitatekin1x9;

    public BizNumber getIwsMaitositumitatekin1x9() {
        return iwsMaitositumitatekin1x9;
    }

    public void setIwsMaitositumitatekin1x9(BizNumber pIwsMaitositumitatekin1x9) {
        iwsMaitositumitatekin1x9 = pIwsMaitositumitatekin1x9;
    }

    @Column(order = 310, length = 13)
    private BizNumber iwsMaitositumitatekin1x10;

    public BizNumber getIwsMaitositumitatekin1x10() {
        return iwsMaitositumitatekin1x10;
    }

    public void setIwsMaitositumitatekin1x10(BizNumber pIwsMaitositumitatekin1x10) {
        iwsMaitositumitatekin1x10 = pIwsMaitositumitatekin1x10;
    }

    @Column(order = 311, length = 13)
    private BizNumber iwsMaitositumitatekin1x11;

    public BizNumber getIwsMaitositumitatekin1x11() {
        return iwsMaitositumitatekin1x11;
    }

    public void setIwsMaitositumitatekin1x11(BizNumber pIwsMaitositumitatekin1x11) {
        iwsMaitositumitatekin1x11 = pIwsMaitositumitatekin1x11;
    }

    @Column(order = 312, length = 13)
    private BizNumber iwsMaitositumitatekin1x12;

    public BizNumber getIwsMaitositumitatekin1x12() {
        return iwsMaitositumitatekin1x12;
    }

    public void setIwsMaitositumitatekin1x12(BizNumber pIwsMaitositumitatekin1x12) {
        iwsMaitositumitatekin1x12 = pIwsMaitositumitatekin1x12;
    }

    @Column(order = 313, length = 13)
    private BizNumber iwsMaitositumitatekin1x13;

    public BizNumber getIwsMaitositumitatekin1x13() {
        return iwsMaitositumitatekin1x13;
    }

    public void setIwsMaitositumitatekin1x13(BizNumber pIwsMaitositumitatekin1x13) {
        iwsMaitositumitatekin1x13 = pIwsMaitositumitatekin1x13;
    }

    @Column(order = 314, length = 13)
    private BizNumber iwsMaitositumitatekin1x14;

    public BizNumber getIwsMaitositumitatekin1x14() {
        return iwsMaitositumitatekin1x14;
    }

    public void setIwsMaitositumitatekin1x14(BizNumber pIwsMaitositumitatekin1x14) {
        iwsMaitositumitatekin1x14 = pIwsMaitositumitatekin1x14;
    }

    @Column(order = 315, length = 13)
    private BizNumber iwsMaitositumitatekin1x15;

    public BizNumber getIwsMaitositumitatekin1x15() {
        return iwsMaitositumitatekin1x15;
    }

    public void setIwsMaitositumitatekin1x15(BizNumber pIwsMaitositumitatekin1x15) {
        iwsMaitositumitatekin1x15 = pIwsMaitositumitatekin1x15;
    }

    @Column(order = 316, length = 13)
    private BizNumber iwsMaitositumitatekin1x16;

    public BizNumber getIwsMaitositumitatekin1x16() {
        return iwsMaitositumitatekin1x16;
    }

    public void setIwsMaitositumitatekin1x16(BizNumber pIwsMaitositumitatekin1x16) {
        iwsMaitositumitatekin1x16 = pIwsMaitositumitatekin1x16;
    }

    @Column(order = 317, length = 13)
    private BizNumber iwsMaitositumitatekin1x17;

    public BizNumber getIwsMaitositumitatekin1x17() {
        return iwsMaitositumitatekin1x17;
    }

    public void setIwsMaitositumitatekin1x17(BizNumber pIwsMaitositumitatekin1x17) {
        iwsMaitositumitatekin1x17 = pIwsMaitositumitatekin1x17;
    }

    @Column(order = 318, length = 13)
    private BizNumber iwsMaitositumitatekin1x18;

    public BizNumber getIwsMaitositumitatekin1x18() {
        return iwsMaitositumitatekin1x18;
    }

    public void setIwsMaitositumitatekin1x18(BizNumber pIwsMaitositumitatekin1x18) {
        iwsMaitositumitatekin1x18 = pIwsMaitositumitatekin1x18;
    }

    @Column(order = 319, length = 13)
    private BizNumber iwsMaitositumitatekin1x19;

    public BizNumber getIwsMaitositumitatekin1x19() {
        return iwsMaitositumitatekin1x19;
    }

    public void setIwsMaitositumitatekin1x19(BizNumber pIwsMaitositumitatekin1x19) {
        iwsMaitositumitatekin1x19 = pIwsMaitositumitatekin1x19;
    }

    @Column(order = 320, length = 13)
    private BizNumber iwsMaitositumitatekin1x20;

    public BizNumber getIwsMaitositumitatekin1x20() {
        return iwsMaitositumitatekin1x20;
    }

    public void setIwsMaitositumitatekin1x20(BizNumber pIwsMaitositumitatekin1x20) {
        iwsMaitositumitatekin1x20 = pIwsMaitositumitatekin1x20;
    }

    @Column(order = 321, length = 13)
    private BizNumber iwsMaitositumitatekin1x21;

    public BizNumber getIwsMaitositumitatekin1x21() {
        return iwsMaitositumitatekin1x21;
    }

    public void setIwsMaitositumitatekin1x21(BizNumber pIwsMaitositumitatekin1x21) {
        iwsMaitositumitatekin1x21 = pIwsMaitositumitatekin1x21;
    }

    @Column(order = 322, length = 13)
    private BizNumber iwsMaitositumitatekin1x22;

    public BizNumber getIwsMaitositumitatekin1x22() {
        return iwsMaitositumitatekin1x22;
    }

    public void setIwsMaitositumitatekin1x22(BizNumber pIwsMaitositumitatekin1x22) {
        iwsMaitositumitatekin1x22 = pIwsMaitositumitatekin1x22;
    }

    @Column(order = 323, length = 13)
    private BizNumber iwsMaitositumitatekin1x23;

    public BizNumber getIwsMaitositumitatekin1x23() {
        return iwsMaitositumitatekin1x23;
    }

    public void setIwsMaitositumitatekin1x23(BizNumber pIwsMaitositumitatekin1x23) {
        iwsMaitositumitatekin1x23 = pIwsMaitositumitatekin1x23;
    }

    @Column(order = 324, length = 13)
    private BizNumber iwsMaitositumitatekin1x24;

    public BizNumber getIwsMaitositumitatekin1x24() {
        return iwsMaitositumitatekin1x24;
    }

    public void setIwsMaitositumitatekin1x24(BizNumber pIwsMaitositumitatekin1x24) {
        iwsMaitositumitatekin1x24 = pIwsMaitositumitatekin1x24;
    }

    @Column(order = 325, length = 13)
    private BizNumber iwsMaitositumitatekin1x25;

    public BizNumber getIwsMaitositumitatekin1x25() {
        return iwsMaitositumitatekin1x25;
    }

    public void setIwsMaitositumitatekin1x25(BizNumber pIwsMaitositumitatekin1x25) {
        iwsMaitositumitatekin1x25 = pIwsMaitositumitatekin1x25;
    }

    @Column(order = 326, length = 13)
    private BizNumber iwsMaitositumitatekin1x26;

    public BizNumber getIwsMaitositumitatekin1x26() {
        return iwsMaitositumitatekin1x26;
    }

    public void setIwsMaitositumitatekin1x26(BizNumber pIwsMaitositumitatekin1x26) {
        iwsMaitositumitatekin1x26 = pIwsMaitositumitatekin1x26;
    }

    @Column(order = 327, length = 13)
    private BizNumber iwsMaitositumitatekin1x27;

    public BizNumber getIwsMaitositumitatekin1x27() {
        return iwsMaitositumitatekin1x27;
    }

    public void setIwsMaitositumitatekin1x27(BizNumber pIwsMaitositumitatekin1x27) {
        iwsMaitositumitatekin1x27 = pIwsMaitositumitatekin1x27;
    }

    @Column(order = 328, length = 13)
    private BizNumber iwsMaitositumitatekin1x28;

    public BizNumber getIwsMaitositumitatekin1x28() {
        return iwsMaitositumitatekin1x28;
    }

    public void setIwsMaitositumitatekin1x28(BizNumber pIwsMaitositumitatekin1x28) {
        iwsMaitositumitatekin1x28 = pIwsMaitositumitatekin1x28;
    }

    @Column(order = 329, length = 13)
    private BizNumber iwsMaitositumitatekin1x29;

    public BizNumber getIwsMaitositumitatekin1x29() {
        return iwsMaitositumitatekin1x29;
    }

    public void setIwsMaitositumitatekin1x29(BizNumber pIwsMaitositumitatekin1x29) {
        iwsMaitositumitatekin1x29 = pIwsMaitositumitatekin1x29;
    }

    @Column(order = 330, length = 13)
    private BizNumber iwsMaitositumitatekin1x30;

    public BizNumber getIwsMaitositumitatekin1x30() {
        return iwsMaitositumitatekin1x30;
    }

    public void setIwsMaitositumitatekin1x30(BizNumber pIwsMaitositumitatekin1x30) {
        iwsMaitositumitatekin1x30 = pIwsMaitositumitatekin1x30;
    }

    @Column(order = 331, length = 13)
    private BizNumber iwsMaitositumitatekin1x31;

    public BizNumber getIwsMaitositumitatekin1x31() {
        return iwsMaitositumitatekin1x31;
    }

    public void setIwsMaitositumitatekin1x31(BizNumber pIwsMaitositumitatekin1x31) {
        iwsMaitositumitatekin1x31 = pIwsMaitositumitatekin1x31;
    }

    @Column(order = 332, length = 13)
    private BizNumber iwsMaitositumitatekin1x32;

    public BizNumber getIwsMaitositumitatekin1x32() {
        return iwsMaitositumitatekin1x32;
    }

    public void setIwsMaitositumitatekin1x32(BizNumber pIwsMaitositumitatekin1x32) {
        iwsMaitositumitatekin1x32 = pIwsMaitositumitatekin1x32;
    }

    @Column(order = 333, length = 13)
    private BizNumber iwsMaitositumitatekin1x33;

    public BizNumber getIwsMaitositumitatekin1x33() {
        return iwsMaitositumitatekin1x33;
    }

    public void setIwsMaitositumitatekin1x33(BizNumber pIwsMaitositumitatekin1x33) {
        iwsMaitositumitatekin1x33 = pIwsMaitositumitatekin1x33;
    }

    @Column(order = 334, length = 13)
    private BizNumber iwsMaitositumitatekin1x34;

    public BizNumber getIwsMaitositumitatekin1x34() {
        return iwsMaitositumitatekin1x34;
    }

    public void setIwsMaitositumitatekin1x34(BizNumber pIwsMaitositumitatekin1x34) {
        iwsMaitositumitatekin1x34 = pIwsMaitositumitatekin1x34;
    }

    @Column(order = 335, length = 13)
    private BizNumber iwsMaitositumitatekin1x35;

    public BizNumber getIwsMaitositumitatekin1x35() {
        return iwsMaitositumitatekin1x35;
    }

    public void setIwsMaitositumitatekin1x35(BizNumber pIwsMaitositumitatekin1x35) {
        iwsMaitositumitatekin1x35 = pIwsMaitositumitatekin1x35;
    }

    @Column(order = 336, length = 13)
    private BizNumber iwsMaitositumitatekin1x36;

    public BizNumber getIwsMaitositumitatekin1x36() {
        return iwsMaitositumitatekin1x36;
    }

    public void setIwsMaitositumitatekin1x36(BizNumber pIwsMaitositumitatekin1x36) {
        iwsMaitositumitatekin1x36 = pIwsMaitositumitatekin1x36;
    }

    @Column(order = 337, length = 13)
    private BizNumber iwsMaitositumitatekin1x37;

    public BizNumber getIwsMaitositumitatekin1x37() {
        return iwsMaitositumitatekin1x37;
    }

    public void setIwsMaitositumitatekin1x37(BizNumber pIwsMaitositumitatekin1x37) {
        iwsMaitositumitatekin1x37 = pIwsMaitositumitatekin1x37;
    }

    @Column(order = 338, length = 13)
    private BizNumber iwsMaitositumitatekin1x38;

    public BizNumber getIwsMaitositumitatekin1x38() {
        return iwsMaitositumitatekin1x38;
    }

    public void setIwsMaitositumitatekin1x38(BizNumber pIwsMaitositumitatekin1x38) {
        iwsMaitositumitatekin1x38 = pIwsMaitositumitatekin1x38;
    }

    @Column(order = 339, length = 13)
    private BizNumber iwsMaitositumitatekin1x39;

    public BizNumber getIwsMaitositumitatekin1x39() {
        return iwsMaitositumitatekin1x39;
    }

    public void setIwsMaitositumitatekin1x39(BizNumber pIwsMaitositumitatekin1x39) {
        iwsMaitositumitatekin1x39 = pIwsMaitositumitatekin1x39;
    }

    @Column(order = 340, length = 13)
    private BizNumber iwsMaitositumitatekin1x40;

    public BizNumber getIwsMaitositumitatekin1x40() {
        return iwsMaitositumitatekin1x40;
    }

    public void setIwsMaitositumitatekin1x40(BizNumber pIwsMaitositumitatekin1x40) {
        iwsMaitositumitatekin1x40 = pIwsMaitositumitatekin1x40;
    }

    @Column(order = 341, length = 13)
    private BizNumber iwsMaitositumitatekin1x41;

    public BizNumber getIwsMaitositumitatekin1x41() {
        return iwsMaitositumitatekin1x41;
    }

    public void setIwsMaitositumitatekin1x41(BizNumber pIwsMaitositumitatekin1x41) {
        iwsMaitositumitatekin1x41 = pIwsMaitositumitatekin1x41;
    }

    @Column(order = 342, length = 13)
    private BizNumber iwsMaitositumitatekin1x42;

    public BizNumber getIwsMaitositumitatekin1x42() {
        return iwsMaitositumitatekin1x42;
    }

    public void setIwsMaitositumitatekin1x42(BizNumber pIwsMaitositumitatekin1x42) {
        iwsMaitositumitatekin1x42 = pIwsMaitositumitatekin1x42;
    }

    @Column(order = 343, length = 13)
    private BizNumber iwsMaitositumitatekin1x43;

    public BizNumber getIwsMaitositumitatekin1x43() {
        return iwsMaitositumitatekin1x43;
    }

    public void setIwsMaitositumitatekin1x43(BizNumber pIwsMaitositumitatekin1x43) {
        iwsMaitositumitatekin1x43 = pIwsMaitositumitatekin1x43;
    }

    @Column(order = 344, length = 13)
    private BizNumber iwsMaitositumitatekin1x44;

    public BizNumber getIwsMaitositumitatekin1x44() {
        return iwsMaitositumitatekin1x44;
    }

    public void setIwsMaitositumitatekin1x44(BizNumber pIwsMaitositumitatekin1x44) {
        iwsMaitositumitatekin1x44 = pIwsMaitositumitatekin1x44;
    }

    @Column(order = 345, length = 13)
    private BizNumber iwsMaitositumitatekin1x45;

    public BizNumber getIwsMaitositumitatekin1x45() {
        return iwsMaitositumitatekin1x45;
    }

    public void setIwsMaitositumitatekin1x45(BizNumber pIwsMaitositumitatekin1x45) {
        iwsMaitositumitatekin1x45 = pIwsMaitositumitatekin1x45;
    }

    @Column(order = 346, length = 13)
    private BizNumber iwsMaitositumitatekin1x46;

    public BizNumber getIwsMaitositumitatekin1x46() {
        return iwsMaitositumitatekin1x46;
    }

    public void setIwsMaitositumitatekin1x46(BizNumber pIwsMaitositumitatekin1x46) {
        iwsMaitositumitatekin1x46 = pIwsMaitositumitatekin1x46;
    }

    @Column(order = 347, length = 13)
    private BizNumber iwsMaitositumitatekin1x47;

    public BizNumber getIwsMaitositumitatekin1x47() {
        return iwsMaitositumitatekin1x47;
    }

    public void setIwsMaitositumitatekin1x47(BizNumber pIwsMaitositumitatekin1x47) {
        iwsMaitositumitatekin1x47 = pIwsMaitositumitatekin1x47;
    }

    @Column(order = 348, length = 13)
    private BizNumber iwsMaitositumitatekin1x48;

    public BizNumber getIwsMaitositumitatekin1x48() {
        return iwsMaitositumitatekin1x48;
    }

    public void setIwsMaitositumitatekin1x48(BizNumber pIwsMaitositumitatekin1x48) {
        iwsMaitositumitatekin1x48 = pIwsMaitositumitatekin1x48;
    }

    @Column(order = 349, length = 13)
    private BizNumber iwsMaitositumitatekin1x49;

    public BizNumber getIwsMaitositumitatekin1x49() {
        return iwsMaitositumitatekin1x49;
    }

    public void setIwsMaitositumitatekin1x49(BizNumber pIwsMaitositumitatekin1x49) {
        iwsMaitositumitatekin1x49 = pIwsMaitositumitatekin1x49;
    }

    @Column(order = 350, length = 13)
    private BizNumber iwsMaitositumitatekin1x50;

    public BizNumber getIwsMaitositumitatekin1x50() {
        return iwsMaitositumitatekin1x50;
    }

    public void setIwsMaitositumitatekin1x50(BizNumber pIwsMaitositumitatekin1x50) {
        iwsMaitositumitatekin1x50 = pIwsMaitositumitatekin1x50;
    }

    @Column(order = 351, length = 13)
    private BizNumber iwsMaitositumitatekin1x51;

    public BizNumber getIwsMaitositumitatekin1x51() {
        return iwsMaitositumitatekin1x51;
    }

    public void setIwsMaitositumitatekin1x51(BizNumber pIwsMaitositumitatekin1x51) {
        iwsMaitositumitatekin1x51 = pIwsMaitositumitatekin1x51;
    }

    @Column(order = 352, length = 13)
    private BizNumber iwsMaitositumitatekin1x52;

    public BizNumber getIwsMaitositumitatekin1x52() {
        return iwsMaitositumitatekin1x52;
    }

    public void setIwsMaitositumitatekin1x52(BizNumber pIwsMaitositumitatekin1x52) {
        iwsMaitositumitatekin1x52 = pIwsMaitositumitatekin1x52;
    }

    @Column(order = 353, length = 13)
    private BizNumber iwsMaitositumitatekin1x53;

    public BizNumber getIwsMaitositumitatekin1x53() {
        return iwsMaitositumitatekin1x53;
    }

    public void setIwsMaitositumitatekin1x53(BizNumber pIwsMaitositumitatekin1x53) {
        iwsMaitositumitatekin1x53 = pIwsMaitositumitatekin1x53;
    }

    @Column(order = 354, length = 13)
    private BizNumber iwsMaitositumitatekin1x54;

    public BizNumber getIwsMaitositumitatekin1x54() {
        return iwsMaitositumitatekin1x54;
    }

    public void setIwsMaitositumitatekin1x54(BizNumber pIwsMaitositumitatekin1x54) {
        iwsMaitositumitatekin1x54 = pIwsMaitositumitatekin1x54;
    }

    @Column(order = 355, length = 13)
    private BizNumber iwsMaitositumitatekin1x55;

    public BizNumber getIwsMaitositumitatekin1x55() {
        return iwsMaitositumitatekin1x55;
    }

    public void setIwsMaitositumitatekin1x55(BizNumber pIwsMaitositumitatekin1x55) {
        iwsMaitositumitatekin1x55 = pIwsMaitositumitatekin1x55;
    }

    @Column(order = 356, length = 13)
    private BizNumber iwsMaitositumitatekin1x56;

    public BizNumber getIwsMaitositumitatekin1x56() {
        return iwsMaitositumitatekin1x56;
    }

    public void setIwsMaitositumitatekin1x56(BizNumber pIwsMaitositumitatekin1x56) {
        iwsMaitositumitatekin1x56 = pIwsMaitositumitatekin1x56;
    }

    @Column(order = 357, length = 13)
    private BizNumber iwsMaitositumitatekin1x57;

    public BizNumber getIwsMaitositumitatekin1x57() {
        return iwsMaitositumitatekin1x57;
    }

    public void setIwsMaitositumitatekin1x57(BizNumber pIwsMaitositumitatekin1x57) {
        iwsMaitositumitatekin1x57 = pIwsMaitositumitatekin1x57;
    }

    @Column(order = 358, length = 13)
    private BizNumber iwsMaitositumitatekin1x58;

    public BizNumber getIwsMaitositumitatekin1x58() {
        return iwsMaitositumitatekin1x58;
    }

    public void setIwsMaitositumitatekin1x58(BizNumber pIwsMaitositumitatekin1x58) {
        iwsMaitositumitatekin1x58 = pIwsMaitositumitatekin1x58;
    }

    @Column(order = 359, length = 13)
    private BizNumber iwsMaitositumitatekin1x59;

    public BizNumber getIwsMaitositumitatekin1x59() {
        return iwsMaitositumitatekin1x59;
    }

    public void setIwsMaitositumitatekin1x59(BizNumber pIwsMaitositumitatekin1x59) {
        iwsMaitositumitatekin1x59 = pIwsMaitositumitatekin1x59;
    }

    @Column(order = 360, length = 13)
    private BizNumber iwsMaitositumitatekin1x60;

    public BizNumber getIwsMaitositumitatekin1x60() {
        return iwsMaitositumitatekin1x60;
    }

    public void setIwsMaitositumitatekin1x60(BizNumber pIwsMaitositumitatekin1x60) {
        iwsMaitositumitatekin1x60 = pIwsMaitositumitatekin1x60;
    }

    @Column(order = 361, length = 13)
    private BizNumber iwsMaitositumitatekin1x61;

    public BizNumber getIwsMaitositumitatekin1x61() {
        return iwsMaitositumitatekin1x61;
    }

    public void setIwsMaitositumitatekin1x61(BizNumber pIwsMaitositumitatekin1x61) {
        iwsMaitositumitatekin1x61 = pIwsMaitositumitatekin1x61;
    }

    @Column(order = 362, length = 13)
    private BizNumber iwsMaitositumitatekin1x62;

    public BizNumber getIwsMaitositumitatekin1x62() {
        return iwsMaitositumitatekin1x62;
    }

    public void setIwsMaitositumitatekin1x62(BizNumber pIwsMaitositumitatekin1x62) {
        iwsMaitositumitatekin1x62 = pIwsMaitositumitatekin1x62;
    }

    @Column(order = 363, length = 13)
    private BizNumber iwsMaitositumitatekin1x63;

    public BizNumber getIwsMaitositumitatekin1x63() {
        return iwsMaitositumitatekin1x63;
    }

    public void setIwsMaitositumitatekin1x63(BizNumber pIwsMaitositumitatekin1x63) {
        iwsMaitositumitatekin1x63 = pIwsMaitositumitatekin1x63;
    }

    @Column(order = 364, length = 13)
    private BizNumber iwsMaitositumitatekin1x64;

    public BizNumber getIwsMaitositumitatekin1x64() {
        return iwsMaitositumitatekin1x64;
    }

    public void setIwsMaitositumitatekin1x64(BizNumber pIwsMaitositumitatekin1x64) {
        iwsMaitositumitatekin1x64 = pIwsMaitositumitatekin1x64;
    }

    @Column(order = 365, length = 13)
    private BizNumber iwsMaitositumitatekin1x65;

    public BizNumber getIwsMaitositumitatekin1x65() {
        return iwsMaitositumitatekin1x65;
    }

    public void setIwsMaitositumitatekin1x65(BizNumber pIwsMaitositumitatekin1x65) {
        iwsMaitositumitatekin1x65 = pIwsMaitositumitatekin1x65;
    }

    @Column(order = 366, length = 13)
    private BizNumber iwsMaitositumitatekin1x66;

    public BizNumber getIwsMaitositumitatekin1x66() {
        return iwsMaitositumitatekin1x66;
    }

    public void setIwsMaitositumitatekin1x66(BizNumber pIwsMaitositumitatekin1x66) {
        iwsMaitositumitatekin1x66 = pIwsMaitositumitatekin1x66;
    }

    @Column(order = 367, length = 13)
    private BizNumber iwsMaitositumitatekin1x67;

    public BizNumber getIwsMaitositumitatekin1x67() {
        return iwsMaitositumitatekin1x67;
    }

    public void setIwsMaitositumitatekin1x67(BizNumber pIwsMaitositumitatekin1x67) {
        iwsMaitositumitatekin1x67 = pIwsMaitositumitatekin1x67;
    }

    @Column(order = 368, length = 13)
    private BizNumber iwsMaitositumitatekin1x68;

    public BizNumber getIwsMaitositumitatekin1x68() {
        return iwsMaitositumitatekin1x68;
    }

    public void setIwsMaitositumitatekin1x68(BizNumber pIwsMaitositumitatekin1x68) {
        iwsMaitositumitatekin1x68 = pIwsMaitositumitatekin1x68;
    }

    @Column(order = 369, length = 13)
    private BizNumber iwsMaitositumitatekin1x69;

    public BizNumber getIwsMaitositumitatekin1x69() {
        return iwsMaitositumitatekin1x69;
    }

    public void setIwsMaitositumitatekin1x69(BizNumber pIwsMaitositumitatekin1x69) {
        iwsMaitositumitatekin1x69 = pIwsMaitositumitatekin1x69;
    }

    @Column(order = 370, length = 13)
    private BizNumber iwsMaitositumitatekin1x70;

    public BizNumber getIwsMaitositumitatekin1x70() {
        return iwsMaitositumitatekin1x70;
    }

    public void setIwsMaitositumitatekin1x70(BizNumber pIwsMaitositumitatekin1x70) {
        iwsMaitositumitatekin1x70 = pIwsMaitositumitatekin1x70;
    }

    @Column(order = 371, length = 13)
    private BizNumber iwsMaitositumitatekin1x71;

    public BizNumber getIwsMaitositumitatekin1x71() {
        return iwsMaitositumitatekin1x71;
    }

    public void setIwsMaitositumitatekin1x71(BizNumber pIwsMaitositumitatekin1x71) {
        iwsMaitositumitatekin1x71 = pIwsMaitositumitatekin1x71;
    }

    @Column(order = 372, length = 13)
    private BizNumber iwsMaitositumitatekin1x72;

    public BizNumber getIwsMaitositumitatekin1x72() {
        return iwsMaitositumitatekin1x72;
    }

    public void setIwsMaitositumitatekin1x72(BizNumber pIwsMaitositumitatekin1x72) {
        iwsMaitositumitatekin1x72 = pIwsMaitositumitatekin1x72;
    }

    @Column(order = 373, length = 13)
    private BizNumber iwsMaitositumitatekin1x73;

    public BizNumber getIwsMaitositumitatekin1x73() {
        return iwsMaitositumitatekin1x73;
    }

    public void setIwsMaitositumitatekin1x73(BizNumber pIwsMaitositumitatekin1x73) {
        iwsMaitositumitatekin1x73 = pIwsMaitositumitatekin1x73;
    }

    @Column(order = 374, length = 13)
    private BizNumber iwsMaitositumitatekin1x74;

    public BizNumber getIwsMaitositumitatekin1x74() {
        return iwsMaitositumitatekin1x74;
    }

    public void setIwsMaitositumitatekin1x74(BizNumber pIwsMaitositumitatekin1x74) {
        iwsMaitositumitatekin1x74 = pIwsMaitositumitatekin1x74;
    }

    @Column(order = 375, length = 13)
    private BizNumber iwsMaitositumitatekin1x75;

    public BizNumber getIwsMaitositumitatekin1x75() {
        return iwsMaitositumitatekin1x75;
    }

    public void setIwsMaitositumitatekin1x75(BizNumber pIwsMaitositumitatekin1x75) {
        iwsMaitositumitatekin1x75 = pIwsMaitositumitatekin1x75;
    }

    @Column(order = 376, length = 13)
    private BizNumber iwsMaitositumitatekin1x76;

    public BizNumber getIwsMaitositumitatekin1x76() {
        return iwsMaitositumitatekin1x76;
    }

    public void setIwsMaitositumitatekin1x76(BizNumber pIwsMaitositumitatekin1x76) {
        iwsMaitositumitatekin1x76 = pIwsMaitositumitatekin1x76;
    }

    @Column(order = 377, length = 13)
    private BizNumber iwsMaitositumitatekin1x77;

    public BizNumber getIwsMaitositumitatekin1x77() {
        return iwsMaitositumitatekin1x77;
    }

    public void setIwsMaitositumitatekin1x77(BizNumber pIwsMaitositumitatekin1x77) {
        iwsMaitositumitatekin1x77 = pIwsMaitositumitatekin1x77;
    }

    @Column(order = 378, length = 13)
    private BizNumber iwsMaitositumitatekin1x78;

    public BizNumber getIwsMaitositumitatekin1x78() {
        return iwsMaitositumitatekin1x78;
    }

    public void setIwsMaitositumitatekin1x78(BizNumber pIwsMaitositumitatekin1x78) {
        iwsMaitositumitatekin1x78 = pIwsMaitositumitatekin1x78;
    }

    @Column(order = 379, length = 13)
    private BizNumber iwsMaitositumitatekin1x79;

    public BizNumber getIwsMaitositumitatekin1x79() {
        return iwsMaitositumitatekin1x79;
    }

    public void setIwsMaitositumitatekin1x79(BizNumber pIwsMaitositumitatekin1x79) {
        iwsMaitositumitatekin1x79 = pIwsMaitositumitatekin1x79;
    }

    @Column(order = 380, length = 13)
    private BizNumber iwsMaitositumitatekin1x80;

    public BizNumber getIwsMaitositumitatekin1x80() {
        return iwsMaitositumitatekin1x80;
    }

    public void setIwsMaitositumitatekin1x80(BizNumber pIwsMaitositumitatekin1x80) {
        iwsMaitositumitatekin1x80 = pIwsMaitositumitatekin1x80;
    }

    @Column(order = 381, length = 13)
    private BizNumber iwsMaitositumitatekin1x81;

    public BizNumber getIwsMaitositumitatekin1x81() {
        return iwsMaitositumitatekin1x81;
    }

    public void setIwsMaitositumitatekin1x81(BizNumber pIwsMaitositumitatekin1x81) {
        iwsMaitositumitatekin1x81 = pIwsMaitositumitatekin1x81;
    }

    @Column(order = 382, length = 13)
    private BizNumber iwsMaitositumitatekin1x82;

    public BizNumber getIwsMaitositumitatekin1x82() {
        return iwsMaitositumitatekin1x82;
    }

    public void setIwsMaitositumitatekin1x82(BizNumber pIwsMaitositumitatekin1x82) {
        iwsMaitositumitatekin1x82 = pIwsMaitositumitatekin1x82;
    }

    @Column(order = 383, length = 13)
    private BizNumber iwsMaitositumitatekin1x83;

    public BizNumber getIwsMaitositumitatekin1x83() {
        return iwsMaitositumitatekin1x83;
    }

    public void setIwsMaitositumitatekin1x83(BizNumber pIwsMaitositumitatekin1x83) {
        iwsMaitositumitatekin1x83 = pIwsMaitositumitatekin1x83;
    }

    @Column(order = 384, length = 13)
    private BizNumber iwsMaitositumitatekin1x84;

    public BizNumber getIwsMaitositumitatekin1x84() {
        return iwsMaitositumitatekin1x84;
    }

    public void setIwsMaitositumitatekin1x84(BizNumber pIwsMaitositumitatekin1x84) {
        iwsMaitositumitatekin1x84 = pIwsMaitositumitatekin1x84;
    }

    @Column(order = 385, length = 13)
    private BizNumber iwsMaitositumitatekin1x85;

    public BizNumber getIwsMaitositumitatekin1x85() {
        return iwsMaitositumitatekin1x85;
    }

    public void setIwsMaitositumitatekin1x85(BizNumber pIwsMaitositumitatekin1x85) {
        iwsMaitositumitatekin1x85 = pIwsMaitositumitatekin1x85;
    }

    @Column(order = 386, length = 13)
    private BizNumber iwsMaitositumitatekin1x86;

    public BizNumber getIwsMaitositumitatekin1x86() {
        return iwsMaitositumitatekin1x86;
    }

    public void setIwsMaitositumitatekin1x86(BizNumber pIwsMaitositumitatekin1x86) {
        iwsMaitositumitatekin1x86 = pIwsMaitositumitatekin1x86;
    }

    @Column(order = 387, length = 13)
    private BizNumber iwsMaitositumitatekin1x87;

    public BizNumber getIwsMaitositumitatekin1x87() {
        return iwsMaitositumitatekin1x87;
    }

    public void setIwsMaitositumitatekin1x87(BizNumber pIwsMaitositumitatekin1x87) {
        iwsMaitositumitatekin1x87 = pIwsMaitositumitatekin1x87;
    }

    @Column(order = 388, length = 13)
    private BizNumber iwsMaitositumitatekin1x88;

    public BizNumber getIwsMaitositumitatekin1x88() {
        return iwsMaitositumitatekin1x88;
    }

    public void setIwsMaitositumitatekin1x88(BizNumber pIwsMaitositumitatekin1x88) {
        iwsMaitositumitatekin1x88 = pIwsMaitositumitatekin1x88;
    }

    @Column(order = 389, length = 13)
    private BizNumber iwsMaitositumitatekin1x89;

    public BizNumber getIwsMaitositumitatekin1x89() {
        return iwsMaitositumitatekin1x89;
    }

    public void setIwsMaitositumitatekin1x89(BizNumber pIwsMaitositumitatekin1x89) {
        iwsMaitositumitatekin1x89 = pIwsMaitositumitatekin1x89;
    }

    @Column(order = 390, length = 13)
    private BizNumber iwsMaitositumitatekin1x90;

    public BizNumber getIwsMaitositumitatekin1x90() {
        return iwsMaitositumitatekin1x90;
    }

    public void setIwsMaitositumitatekin1x90(BizNumber pIwsMaitositumitatekin1x90) {
        iwsMaitositumitatekin1x90 = pIwsMaitositumitatekin1x90;
    }

    @Column(order = 391, length = 13)
    private BizNumber iwsMaitositumitatekin1x91;

    public BizNumber getIwsMaitositumitatekin1x91() {
        return iwsMaitositumitatekin1x91;
    }

    public void setIwsMaitositumitatekin1x91(BizNumber pIwsMaitositumitatekin1x91) {
        iwsMaitositumitatekin1x91 = pIwsMaitositumitatekin1x91;
    }

    @Column(order = 392, length = 13)
    private BizNumber iwsMaitositumitatekin1x92;

    public BizNumber getIwsMaitositumitatekin1x92() {
        return iwsMaitositumitatekin1x92;
    }

    public void setIwsMaitositumitatekin1x92(BizNumber pIwsMaitositumitatekin1x92) {
        iwsMaitositumitatekin1x92 = pIwsMaitositumitatekin1x92;
    }

    @Column(order = 393, length = 13)
    private BizNumber iwsMaitositumitatekin1x93;

    public BizNumber getIwsMaitositumitatekin1x93() {
        return iwsMaitositumitatekin1x93;
    }

    public void setIwsMaitositumitatekin1x93(BizNumber pIwsMaitositumitatekin1x93) {
        iwsMaitositumitatekin1x93 = pIwsMaitositumitatekin1x93;
    }

    @Column(order = 394, length = 13)
    private BizNumber iwsMaitositumitatekin1x94;

    public BizNumber getIwsMaitositumitatekin1x94() {
        return iwsMaitositumitatekin1x94;
    }

    public void setIwsMaitositumitatekin1x94(BizNumber pIwsMaitositumitatekin1x94) {
        iwsMaitositumitatekin1x94 = pIwsMaitositumitatekin1x94;
    }

    @Column(order = 395, length = 13)
    private BizNumber iwsMaitositumitatekin1x95;

    public BizNumber getIwsMaitositumitatekin1x95() {
        return iwsMaitositumitatekin1x95;
    }

    public void setIwsMaitositumitatekin1x95(BizNumber pIwsMaitositumitatekin1x95) {
        iwsMaitositumitatekin1x95 = pIwsMaitositumitatekin1x95;
    }

    @Column(order = 396, length = 13)
    private BizNumber iwsMaitositumitatekin1x96;

    public BizNumber getIwsMaitositumitatekin1x96() {
        return iwsMaitositumitatekin1x96;
    }

    public void setIwsMaitositumitatekin1x96(BizNumber pIwsMaitositumitatekin1x96) {
        iwsMaitositumitatekin1x96 = pIwsMaitositumitatekin1x96;
    }

    @Column(order = 397, length = 13)
    private BizNumber iwsMaitositumitatekin1x97;

    public BizNumber getIwsMaitositumitatekin1x97() {
        return iwsMaitositumitatekin1x97;
    }

    public void setIwsMaitositumitatekin1x97(BizNumber pIwsMaitositumitatekin1x97) {
        iwsMaitositumitatekin1x97 = pIwsMaitositumitatekin1x97;
    }

    @Column(order = 398, length = 13)
    private BizNumber iwsMaitositumitatekin1x98;

    public BizNumber getIwsMaitositumitatekin1x98() {
        return iwsMaitositumitatekin1x98;
    }

    public void setIwsMaitositumitatekin1x98(BizNumber pIwsMaitositumitatekin1x98) {
        iwsMaitositumitatekin1x98 = pIwsMaitositumitatekin1x98;
    }

    @Column(order = 399, length = 13)
    private BizNumber iwsMaitositumitatekin1x99;

    public BizNumber getIwsMaitositumitatekin1x99() {
        return iwsMaitositumitatekin1x99;
    }

    public void setIwsMaitositumitatekin1x99(BizNumber pIwsMaitositumitatekin1x99) {
        iwsMaitositumitatekin1x99 = pIwsMaitositumitatekin1x99;
    }

    @Column(order = 400, length = 13)
    private BizNumber iwsMaitositumitatekin2x1;

    public BizNumber getIwsMaitositumitatekin2x1() {
        return iwsMaitositumitatekin2x1;
    }

    public void setIwsMaitositumitatekin2x1(BizNumber pIwsMaitositumitatekin2x1) {
        iwsMaitositumitatekin2x1 = pIwsMaitositumitatekin2x1;
    }

    @Column(order = 401, length = 13)
    private BizNumber iwsMaitositumitatekin2x2;

    public BizNumber getIwsMaitositumitatekin2x2() {
        return iwsMaitositumitatekin2x2;
    }

    public void setIwsMaitositumitatekin2x2(BizNumber pIwsMaitositumitatekin2x2) {
        iwsMaitositumitatekin2x2 = pIwsMaitositumitatekin2x2;
    }

    @Column(order = 402, length = 13)
    private BizNumber iwsMaitositumitatekin2x3;

    public BizNumber getIwsMaitositumitatekin2x3() {
        return iwsMaitositumitatekin2x3;
    }

    public void setIwsMaitositumitatekin2x3(BizNumber pIwsMaitositumitatekin2x3) {
        iwsMaitositumitatekin2x3 = pIwsMaitositumitatekin2x3;
    }

    @Column(order = 403, length = 13)
    private BizNumber iwsMaitositumitatekin2x4;

    public BizNumber getIwsMaitositumitatekin2x4() {
        return iwsMaitositumitatekin2x4;
    }

    public void setIwsMaitositumitatekin2x4(BizNumber pIwsMaitositumitatekin2x4) {
        iwsMaitositumitatekin2x4 = pIwsMaitositumitatekin2x4;
    }

    @Column(order = 404, length = 13)
    private BizNumber iwsMaitositumitatekin2x5;

    public BizNumber getIwsMaitositumitatekin2x5() {
        return iwsMaitositumitatekin2x5;
    }

    public void setIwsMaitositumitatekin2x5(BizNumber pIwsMaitositumitatekin2x5) {
        iwsMaitositumitatekin2x5 = pIwsMaitositumitatekin2x5;
    }

    @Column(order = 405, length = 13)
    private BizNumber iwsMaitositumitatekin2x6;

    public BizNumber getIwsMaitositumitatekin2x6() {
        return iwsMaitositumitatekin2x6;
    }

    public void setIwsMaitositumitatekin2x6(BizNumber pIwsMaitositumitatekin2x6) {
        iwsMaitositumitatekin2x6 = pIwsMaitositumitatekin2x6;
    }

    @Column(order = 406, length = 13)
    private BizNumber iwsMaitositumitatekin2x7;

    public BizNumber getIwsMaitositumitatekin2x7() {
        return iwsMaitositumitatekin2x7;
    }

    public void setIwsMaitositumitatekin2x7(BizNumber pIwsMaitositumitatekin2x7) {
        iwsMaitositumitatekin2x7 = pIwsMaitositumitatekin2x7;
    }

    @Column(order = 407, length = 13)
    private BizNumber iwsMaitositumitatekin2x8;

    public BizNumber getIwsMaitositumitatekin2x8() {
        return iwsMaitositumitatekin2x8;
    }

    public void setIwsMaitositumitatekin2x8(BizNumber pIwsMaitositumitatekin2x8) {
        iwsMaitositumitatekin2x8 = pIwsMaitositumitatekin2x8;
    }

    @Column(order = 408, length = 13)
    private BizNumber iwsMaitositumitatekin2x9;

    public BizNumber getIwsMaitositumitatekin2x9() {
        return iwsMaitositumitatekin2x9;
    }

    public void setIwsMaitositumitatekin2x9(BizNumber pIwsMaitositumitatekin2x9) {
        iwsMaitositumitatekin2x9 = pIwsMaitositumitatekin2x9;
    }

    @Column(order = 409, length = 13)
    private BizNumber iwsMaitositumitatekin2x10;

    public BizNumber getIwsMaitositumitatekin2x10() {
        return iwsMaitositumitatekin2x10;
    }

    public void setIwsMaitositumitatekin2x10(BizNumber pIwsMaitositumitatekin2x10) {
        iwsMaitositumitatekin2x10 = pIwsMaitositumitatekin2x10;
    }

    @Column(order = 410, length = 13)
    private BizNumber iwsMaitositumitatekin2x11;

    public BizNumber getIwsMaitositumitatekin2x11() {
        return iwsMaitositumitatekin2x11;
    }

    public void setIwsMaitositumitatekin2x11(BizNumber pIwsMaitositumitatekin2x11) {
        iwsMaitositumitatekin2x11 = pIwsMaitositumitatekin2x11;
    }

    @Column(order = 411, length = 13)
    private BizNumber iwsMaitositumitatekin2x12;

    public BizNumber getIwsMaitositumitatekin2x12() {
        return iwsMaitositumitatekin2x12;
    }

    public void setIwsMaitositumitatekin2x12(BizNumber pIwsMaitositumitatekin2x12) {
        iwsMaitositumitatekin2x12 = pIwsMaitositumitatekin2x12;
    }

    @Column(order = 412, length = 13)
    private BizNumber iwsMaitositumitatekin2x13;

    public BizNumber getIwsMaitositumitatekin2x13() {
        return iwsMaitositumitatekin2x13;
    }

    public void setIwsMaitositumitatekin2x13(BizNumber pIwsMaitositumitatekin2x13) {
        iwsMaitositumitatekin2x13 = pIwsMaitositumitatekin2x13;
    }

    @Column(order = 413, length = 13)
    private BizNumber iwsMaitositumitatekin2x14;

    public BizNumber getIwsMaitositumitatekin2x14() {
        return iwsMaitositumitatekin2x14;
    }

    public void setIwsMaitositumitatekin2x14(BizNumber pIwsMaitositumitatekin2x14) {
        iwsMaitositumitatekin2x14 = pIwsMaitositumitatekin2x14;
    }

    @Column(order = 414, length = 13)
    private BizNumber iwsMaitositumitatekin2x15;

    public BizNumber getIwsMaitositumitatekin2x15() {
        return iwsMaitositumitatekin2x15;
    }

    public void setIwsMaitositumitatekin2x15(BizNumber pIwsMaitositumitatekin2x15) {
        iwsMaitositumitatekin2x15 = pIwsMaitositumitatekin2x15;
    }

    @Column(order = 415, length = 13)
    private BizNumber iwsMaitositumitatekin2x16;

    public BizNumber getIwsMaitositumitatekin2x16() {
        return iwsMaitositumitatekin2x16;
    }

    public void setIwsMaitositumitatekin2x16(BizNumber pIwsMaitositumitatekin2x16) {
        iwsMaitositumitatekin2x16 = pIwsMaitositumitatekin2x16;
    }

    @Column(order = 416, length = 13)
    private BizNumber iwsMaitositumitatekin2x17;

    public BizNumber getIwsMaitositumitatekin2x17() {
        return iwsMaitositumitatekin2x17;
    }

    public void setIwsMaitositumitatekin2x17(BizNumber pIwsMaitositumitatekin2x17) {
        iwsMaitositumitatekin2x17 = pIwsMaitositumitatekin2x17;
    }

    @Column(order = 417, length = 13)
    private BizNumber iwsMaitositumitatekin2x18;

    public BizNumber getIwsMaitositumitatekin2x18() {
        return iwsMaitositumitatekin2x18;
    }

    public void setIwsMaitositumitatekin2x18(BizNumber pIwsMaitositumitatekin2x18) {
        iwsMaitositumitatekin2x18 = pIwsMaitositumitatekin2x18;
    }

    @Column(order = 418, length = 13)
    private BizNumber iwsMaitositumitatekin2x19;

    public BizNumber getIwsMaitositumitatekin2x19() {
        return iwsMaitositumitatekin2x19;
    }

    public void setIwsMaitositumitatekin2x19(BizNumber pIwsMaitositumitatekin2x19) {
        iwsMaitositumitatekin2x19 = pIwsMaitositumitatekin2x19;
    }

    @Column(order = 419, length = 13)
    private BizNumber iwsMaitositumitatekin2x20;

    public BizNumber getIwsMaitositumitatekin2x20() {
        return iwsMaitositumitatekin2x20;
    }

    public void setIwsMaitositumitatekin2x20(BizNumber pIwsMaitositumitatekin2x20) {
        iwsMaitositumitatekin2x20 = pIwsMaitositumitatekin2x20;
    }

    @Column(order = 420, length = 13)
    private BizNumber iwsMaitositumitatekin2x21;

    public BizNumber getIwsMaitositumitatekin2x21() {
        return iwsMaitositumitatekin2x21;
    }

    public void setIwsMaitositumitatekin2x21(BizNumber pIwsMaitositumitatekin2x21) {
        iwsMaitositumitatekin2x21 = pIwsMaitositumitatekin2x21;
    }

    @Column(order = 421, length = 13)
    private BizNumber iwsMaitositumitatekin2x22;

    public BizNumber getIwsMaitositumitatekin2x22() {
        return iwsMaitositumitatekin2x22;
    }

    public void setIwsMaitositumitatekin2x22(BizNumber pIwsMaitositumitatekin2x22) {
        iwsMaitositumitatekin2x22 = pIwsMaitositumitatekin2x22;
    }

    @Column(order = 422, length = 13)
    private BizNumber iwsMaitositumitatekin2x23;

    public BizNumber getIwsMaitositumitatekin2x23() {
        return iwsMaitositumitatekin2x23;
    }

    public void setIwsMaitositumitatekin2x23(BizNumber pIwsMaitositumitatekin2x23) {
        iwsMaitositumitatekin2x23 = pIwsMaitositumitatekin2x23;
    }

    @Column(order = 423, length = 13)
    private BizNumber iwsMaitositumitatekin2x24;

    public BizNumber getIwsMaitositumitatekin2x24() {
        return iwsMaitositumitatekin2x24;
    }

    public void setIwsMaitositumitatekin2x24(BizNumber pIwsMaitositumitatekin2x24) {
        iwsMaitositumitatekin2x24 = pIwsMaitositumitatekin2x24;
    }

    @Column(order = 424, length = 13)
    private BizNumber iwsMaitositumitatekin2x25;

    public BizNumber getIwsMaitositumitatekin2x25() {
        return iwsMaitositumitatekin2x25;
    }

    public void setIwsMaitositumitatekin2x25(BizNumber pIwsMaitositumitatekin2x25) {
        iwsMaitositumitatekin2x25 = pIwsMaitositumitatekin2x25;
    }

    @Column(order = 425, length = 13)
    private BizNumber iwsMaitositumitatekin2x26;

    public BizNumber getIwsMaitositumitatekin2x26() {
        return iwsMaitositumitatekin2x26;
    }

    public void setIwsMaitositumitatekin2x26(BizNumber pIwsMaitositumitatekin2x26) {
        iwsMaitositumitatekin2x26 = pIwsMaitositumitatekin2x26;
    }

    @Column(order = 426, length = 13)
    private BizNumber iwsMaitositumitatekin2x27;

    public BizNumber getIwsMaitositumitatekin2x27() {
        return iwsMaitositumitatekin2x27;
    }

    public void setIwsMaitositumitatekin2x27(BizNumber pIwsMaitositumitatekin2x27) {
        iwsMaitositumitatekin2x27 = pIwsMaitositumitatekin2x27;
    }

    @Column(order = 427, length = 13)
    private BizNumber iwsMaitositumitatekin2x28;

    public BizNumber getIwsMaitositumitatekin2x28() {
        return iwsMaitositumitatekin2x28;
    }

    public void setIwsMaitositumitatekin2x28(BizNumber pIwsMaitositumitatekin2x28) {
        iwsMaitositumitatekin2x28 = pIwsMaitositumitatekin2x28;
    }

    @Column(order = 428, length = 13)
    private BizNumber iwsMaitositumitatekin2x29;

    public BizNumber getIwsMaitositumitatekin2x29() {
        return iwsMaitositumitatekin2x29;
    }

    public void setIwsMaitositumitatekin2x29(BizNumber pIwsMaitositumitatekin2x29) {
        iwsMaitositumitatekin2x29 = pIwsMaitositumitatekin2x29;
    }

    @Column(order = 429, length = 13)
    private BizNumber iwsMaitositumitatekin2x30;

    public BizNumber getIwsMaitositumitatekin2x30() {
        return iwsMaitositumitatekin2x30;
    }

    public void setIwsMaitositumitatekin2x30(BizNumber pIwsMaitositumitatekin2x30) {
        iwsMaitositumitatekin2x30 = pIwsMaitositumitatekin2x30;
    }

    @Column(order = 430, length = 13)
    private BizNumber iwsMaitositumitatekin2x31;

    public BizNumber getIwsMaitositumitatekin2x31() {
        return iwsMaitositumitatekin2x31;
    }

    public void setIwsMaitositumitatekin2x31(BizNumber pIwsMaitositumitatekin2x31) {
        iwsMaitositumitatekin2x31 = pIwsMaitositumitatekin2x31;
    }

    @Column(order = 431, length = 13)
    private BizNumber iwsMaitositumitatekin2x32;

    public BizNumber getIwsMaitositumitatekin2x32() {
        return iwsMaitositumitatekin2x32;
    }

    public void setIwsMaitositumitatekin2x32(BizNumber pIwsMaitositumitatekin2x32) {
        iwsMaitositumitatekin2x32 = pIwsMaitositumitatekin2x32;
    }

    @Column(order = 432, length = 13)
    private BizNumber iwsMaitositumitatekin2x33;

    public BizNumber getIwsMaitositumitatekin2x33() {
        return iwsMaitositumitatekin2x33;
    }

    public void setIwsMaitositumitatekin2x33(BizNumber pIwsMaitositumitatekin2x33) {
        iwsMaitositumitatekin2x33 = pIwsMaitositumitatekin2x33;
    }

    @Column(order = 433, length = 13)
    private BizNumber iwsMaitositumitatekin2x34;

    public BizNumber getIwsMaitositumitatekin2x34() {
        return iwsMaitositumitatekin2x34;
    }

    public void setIwsMaitositumitatekin2x34(BizNumber pIwsMaitositumitatekin2x34) {
        iwsMaitositumitatekin2x34 = pIwsMaitositumitatekin2x34;
    }

    @Column(order = 434, length = 13)
    private BizNumber iwsMaitositumitatekin2x35;

    public BizNumber getIwsMaitositumitatekin2x35() {
        return iwsMaitositumitatekin2x35;
    }

    public void setIwsMaitositumitatekin2x35(BizNumber pIwsMaitositumitatekin2x35) {
        iwsMaitositumitatekin2x35 = pIwsMaitositumitatekin2x35;
    }

    @Column(order = 435, length = 13)
    private BizNumber iwsMaitositumitatekin2x36;

    public BizNumber getIwsMaitositumitatekin2x36() {
        return iwsMaitositumitatekin2x36;
    }

    public void setIwsMaitositumitatekin2x36(BizNumber pIwsMaitositumitatekin2x36) {
        iwsMaitositumitatekin2x36 = pIwsMaitositumitatekin2x36;
    }

    @Column(order = 436, length = 13)
    private BizNumber iwsMaitositumitatekin2x37;

    public BizNumber getIwsMaitositumitatekin2x37() {
        return iwsMaitositumitatekin2x37;
    }

    public void setIwsMaitositumitatekin2x37(BizNumber pIwsMaitositumitatekin2x37) {
        iwsMaitositumitatekin2x37 = pIwsMaitositumitatekin2x37;
    }

    @Column(order = 437, length = 13)
    private BizNumber iwsMaitositumitatekin2x38;

    public BizNumber getIwsMaitositumitatekin2x38() {
        return iwsMaitositumitatekin2x38;
    }

    public void setIwsMaitositumitatekin2x38(BizNumber pIwsMaitositumitatekin2x38) {
        iwsMaitositumitatekin2x38 = pIwsMaitositumitatekin2x38;
    }

    @Column(order = 438, length = 13)
    private BizNumber iwsMaitositumitatekin2x39;

    public BizNumber getIwsMaitositumitatekin2x39() {
        return iwsMaitositumitatekin2x39;
    }

    public void setIwsMaitositumitatekin2x39(BizNumber pIwsMaitositumitatekin2x39) {
        iwsMaitositumitatekin2x39 = pIwsMaitositumitatekin2x39;
    }

    @Column(order = 439, length = 13)
    private BizNumber iwsMaitositumitatekin2x40;

    public BizNumber getIwsMaitositumitatekin2x40() {
        return iwsMaitositumitatekin2x40;
    }

    public void setIwsMaitositumitatekin2x40(BizNumber pIwsMaitositumitatekin2x40) {
        iwsMaitositumitatekin2x40 = pIwsMaitositumitatekin2x40;
    }

    @Column(order = 440, length = 13)
    private BizNumber iwsMaitositumitatekin2x41;

    public BizNumber getIwsMaitositumitatekin2x41() {
        return iwsMaitositumitatekin2x41;
    }

    public void setIwsMaitositumitatekin2x41(BizNumber pIwsMaitositumitatekin2x41) {
        iwsMaitositumitatekin2x41 = pIwsMaitositumitatekin2x41;
    }

    @Column(order = 441, length = 13)
    private BizNumber iwsMaitositumitatekin2x42;

    public BizNumber getIwsMaitositumitatekin2x42() {
        return iwsMaitositumitatekin2x42;
    }

    public void setIwsMaitositumitatekin2x42(BizNumber pIwsMaitositumitatekin2x42) {
        iwsMaitositumitatekin2x42 = pIwsMaitositumitatekin2x42;
    }

    @Column(order = 442, length = 13)
    private BizNumber iwsMaitositumitatekin2x43;

    public BizNumber getIwsMaitositumitatekin2x43() {
        return iwsMaitositumitatekin2x43;
    }

    public void setIwsMaitositumitatekin2x43(BizNumber pIwsMaitositumitatekin2x43) {
        iwsMaitositumitatekin2x43 = pIwsMaitositumitatekin2x43;
    }

    @Column(order = 443, length = 13)
    private BizNumber iwsMaitositumitatekin2x44;

    public BizNumber getIwsMaitositumitatekin2x44() {
        return iwsMaitositumitatekin2x44;
    }

    public void setIwsMaitositumitatekin2x44(BizNumber pIwsMaitositumitatekin2x44) {
        iwsMaitositumitatekin2x44 = pIwsMaitositumitatekin2x44;
    }

    @Column(order = 444, length = 13)
    private BizNumber iwsMaitositumitatekin2x45;

    public BizNumber getIwsMaitositumitatekin2x45() {
        return iwsMaitositumitatekin2x45;
    }

    public void setIwsMaitositumitatekin2x45(BizNumber pIwsMaitositumitatekin2x45) {
        iwsMaitositumitatekin2x45 = pIwsMaitositumitatekin2x45;
    }

    @Column(order = 445, length = 13)
    private BizNumber iwsMaitositumitatekin2x46;

    public BizNumber getIwsMaitositumitatekin2x46() {
        return iwsMaitositumitatekin2x46;
    }

    public void setIwsMaitositumitatekin2x46(BizNumber pIwsMaitositumitatekin2x46) {
        iwsMaitositumitatekin2x46 = pIwsMaitositumitatekin2x46;
    }

    @Column(order = 446, length = 13)
    private BizNumber iwsMaitositumitatekin2x47;

    public BizNumber getIwsMaitositumitatekin2x47() {
        return iwsMaitositumitatekin2x47;
    }

    public void setIwsMaitositumitatekin2x47(BizNumber pIwsMaitositumitatekin2x47) {
        iwsMaitositumitatekin2x47 = pIwsMaitositumitatekin2x47;
    }

    @Column(order = 447, length = 13)
    private BizNumber iwsMaitositumitatekin2x48;

    public BizNumber getIwsMaitositumitatekin2x48() {
        return iwsMaitositumitatekin2x48;
    }

    public void setIwsMaitositumitatekin2x48(BizNumber pIwsMaitositumitatekin2x48) {
        iwsMaitositumitatekin2x48 = pIwsMaitositumitatekin2x48;
    }

    @Column(order = 448, length = 13)
    private BizNumber iwsMaitositumitatekin2x49;

    public BizNumber getIwsMaitositumitatekin2x49() {
        return iwsMaitositumitatekin2x49;
    }

    public void setIwsMaitositumitatekin2x49(BizNumber pIwsMaitositumitatekin2x49) {
        iwsMaitositumitatekin2x49 = pIwsMaitositumitatekin2x49;
    }

    @Column(order = 449, length = 13)
    private BizNumber iwsMaitositumitatekin2x50;

    public BizNumber getIwsMaitositumitatekin2x50() {
        return iwsMaitositumitatekin2x50;
    }

    public void setIwsMaitositumitatekin2x50(BizNumber pIwsMaitositumitatekin2x50) {
        iwsMaitositumitatekin2x50 = pIwsMaitositumitatekin2x50;
    }

    @Column(order = 450, length = 13)
    private BizNumber iwsMaitositumitatekin2x51;

    public BizNumber getIwsMaitositumitatekin2x51() {
        return iwsMaitositumitatekin2x51;
    }

    public void setIwsMaitositumitatekin2x51(BizNumber pIwsMaitositumitatekin2x51) {
        iwsMaitositumitatekin2x51 = pIwsMaitositumitatekin2x51;
    }

    @Column(order = 451, length = 13)
    private BizNumber iwsMaitositumitatekin2x52;

    public BizNumber getIwsMaitositumitatekin2x52() {
        return iwsMaitositumitatekin2x52;
    }

    public void setIwsMaitositumitatekin2x52(BizNumber pIwsMaitositumitatekin2x52) {
        iwsMaitositumitatekin2x52 = pIwsMaitositumitatekin2x52;
    }

    @Column(order = 452, length = 13)
    private BizNumber iwsMaitositumitatekin2x53;

    public BizNumber getIwsMaitositumitatekin2x53() {
        return iwsMaitositumitatekin2x53;
    }

    public void setIwsMaitositumitatekin2x53(BizNumber pIwsMaitositumitatekin2x53) {
        iwsMaitositumitatekin2x53 = pIwsMaitositumitatekin2x53;
    }

    @Column(order = 453, length = 13)
    private BizNumber iwsMaitositumitatekin2x54;

    public BizNumber getIwsMaitositumitatekin2x54() {
        return iwsMaitositumitatekin2x54;
    }

    public void setIwsMaitositumitatekin2x54(BizNumber pIwsMaitositumitatekin2x54) {
        iwsMaitositumitatekin2x54 = pIwsMaitositumitatekin2x54;
    }

    @Column(order = 454, length = 13)
    private BizNumber iwsMaitositumitatekin2x55;

    public BizNumber getIwsMaitositumitatekin2x55() {
        return iwsMaitositumitatekin2x55;
    }

    public void setIwsMaitositumitatekin2x55(BizNumber pIwsMaitositumitatekin2x55) {
        iwsMaitositumitatekin2x55 = pIwsMaitositumitatekin2x55;
    }

    @Column(order = 455, length = 13)
    private BizNumber iwsMaitositumitatekin2x56;

    public BizNumber getIwsMaitositumitatekin2x56() {
        return iwsMaitositumitatekin2x56;
    }

    public void setIwsMaitositumitatekin2x56(BizNumber pIwsMaitositumitatekin2x56) {
        iwsMaitositumitatekin2x56 = pIwsMaitositumitatekin2x56;
    }

    @Column(order = 456, length = 13)
    private BizNumber iwsMaitositumitatekin2x57;

    public BizNumber getIwsMaitositumitatekin2x57() {
        return iwsMaitositumitatekin2x57;
    }

    public void setIwsMaitositumitatekin2x57(BizNumber pIwsMaitositumitatekin2x57) {
        iwsMaitositumitatekin2x57 = pIwsMaitositumitatekin2x57;
    }

    @Column(order = 457, length = 13)
    private BizNumber iwsMaitositumitatekin2x58;

    public BizNumber getIwsMaitositumitatekin2x58() {
        return iwsMaitositumitatekin2x58;
    }

    public void setIwsMaitositumitatekin2x58(BizNumber pIwsMaitositumitatekin2x58) {
        iwsMaitositumitatekin2x58 = pIwsMaitositumitatekin2x58;
    }

    @Column(order = 458, length = 13)
    private BizNumber iwsMaitositumitatekin2x59;

    public BizNumber getIwsMaitositumitatekin2x59() {
        return iwsMaitositumitatekin2x59;
    }

    public void setIwsMaitositumitatekin2x59(BizNumber pIwsMaitositumitatekin2x59) {
        iwsMaitositumitatekin2x59 = pIwsMaitositumitatekin2x59;
    }

    @Column(order = 459, length = 13)
    private BizNumber iwsMaitositumitatekin2x60;

    public BizNumber getIwsMaitositumitatekin2x60() {
        return iwsMaitositumitatekin2x60;
    }

    public void setIwsMaitositumitatekin2x60(BizNumber pIwsMaitositumitatekin2x60) {
        iwsMaitositumitatekin2x60 = pIwsMaitositumitatekin2x60;
    }

    @Column(order = 460, length = 13)
    private BizNumber iwsMaitositumitatekin2x61;

    public BizNumber getIwsMaitositumitatekin2x61() {
        return iwsMaitositumitatekin2x61;
    }

    public void setIwsMaitositumitatekin2x61(BizNumber pIwsMaitositumitatekin2x61) {
        iwsMaitositumitatekin2x61 = pIwsMaitositumitatekin2x61;
    }

    @Column(order = 461, length = 13)
    private BizNumber iwsMaitositumitatekin2x62;

    public BizNumber getIwsMaitositumitatekin2x62() {
        return iwsMaitositumitatekin2x62;
    }

    public void setIwsMaitositumitatekin2x62(BizNumber pIwsMaitositumitatekin2x62) {
        iwsMaitositumitatekin2x62 = pIwsMaitositumitatekin2x62;
    }

    @Column(order = 462, length = 13)
    private BizNumber iwsMaitositumitatekin2x63;

    public BizNumber getIwsMaitositumitatekin2x63() {
        return iwsMaitositumitatekin2x63;
    }

    public void setIwsMaitositumitatekin2x63(BizNumber pIwsMaitositumitatekin2x63) {
        iwsMaitositumitatekin2x63 = pIwsMaitositumitatekin2x63;
    }

    @Column(order = 463, length = 13)
    private BizNumber iwsMaitositumitatekin2x64;

    public BizNumber getIwsMaitositumitatekin2x64() {
        return iwsMaitositumitatekin2x64;
    }

    public void setIwsMaitositumitatekin2x64(BizNumber pIwsMaitositumitatekin2x64) {
        iwsMaitositumitatekin2x64 = pIwsMaitositumitatekin2x64;
    }

    @Column(order = 464, length = 13)
    private BizNumber iwsMaitositumitatekin2x65;

    public BizNumber getIwsMaitositumitatekin2x65() {
        return iwsMaitositumitatekin2x65;
    }

    public void setIwsMaitositumitatekin2x65(BizNumber pIwsMaitositumitatekin2x65) {
        iwsMaitositumitatekin2x65 = pIwsMaitositumitatekin2x65;
    }

    @Column(order = 465, length = 13)
    private BizNumber iwsMaitositumitatekin2x66;

    public BizNumber getIwsMaitositumitatekin2x66() {
        return iwsMaitositumitatekin2x66;
    }

    public void setIwsMaitositumitatekin2x66(BizNumber pIwsMaitositumitatekin2x66) {
        iwsMaitositumitatekin2x66 = pIwsMaitositumitatekin2x66;
    }

    @Column(order = 466, length = 13)
    private BizNumber iwsMaitositumitatekin2x67;

    public BizNumber getIwsMaitositumitatekin2x67() {
        return iwsMaitositumitatekin2x67;
    }

    public void setIwsMaitositumitatekin2x67(BizNumber pIwsMaitositumitatekin2x67) {
        iwsMaitositumitatekin2x67 = pIwsMaitositumitatekin2x67;
    }

    @Column(order = 467, length = 13)
    private BizNumber iwsMaitositumitatekin2x68;

    public BizNumber getIwsMaitositumitatekin2x68() {
        return iwsMaitositumitatekin2x68;
    }

    public void setIwsMaitositumitatekin2x68(BizNumber pIwsMaitositumitatekin2x68) {
        iwsMaitositumitatekin2x68 = pIwsMaitositumitatekin2x68;
    }

    @Column(order = 468, length = 13)
    private BizNumber iwsMaitositumitatekin2x69;

    public BizNumber getIwsMaitositumitatekin2x69() {
        return iwsMaitositumitatekin2x69;
    }

    public void setIwsMaitositumitatekin2x69(BizNumber pIwsMaitositumitatekin2x69) {
        iwsMaitositumitatekin2x69 = pIwsMaitositumitatekin2x69;
    }

    @Column(order = 469, length = 13)
    private BizNumber iwsMaitositumitatekin2x70;

    public BizNumber getIwsMaitositumitatekin2x70() {
        return iwsMaitositumitatekin2x70;
    }

    public void setIwsMaitositumitatekin2x70(BizNumber pIwsMaitositumitatekin2x70) {
        iwsMaitositumitatekin2x70 = pIwsMaitositumitatekin2x70;
    }

    @Column(order = 470, length = 13)
    private BizNumber iwsMaitositumitatekin2x71;

    public BizNumber getIwsMaitositumitatekin2x71() {
        return iwsMaitositumitatekin2x71;
    }

    public void setIwsMaitositumitatekin2x71(BizNumber pIwsMaitositumitatekin2x71) {
        iwsMaitositumitatekin2x71 = pIwsMaitositumitatekin2x71;
    }

    @Column(order = 471, length = 13)
    private BizNumber iwsMaitositumitatekin2x72;

    public BizNumber getIwsMaitositumitatekin2x72() {
        return iwsMaitositumitatekin2x72;
    }

    public void setIwsMaitositumitatekin2x72(BizNumber pIwsMaitositumitatekin2x72) {
        iwsMaitositumitatekin2x72 = pIwsMaitositumitatekin2x72;
    }

    @Column(order = 472, length = 13)
    private BizNumber iwsMaitositumitatekin2x73;

    public BizNumber getIwsMaitositumitatekin2x73() {
        return iwsMaitositumitatekin2x73;
    }

    public void setIwsMaitositumitatekin2x73(BizNumber pIwsMaitositumitatekin2x73) {
        iwsMaitositumitatekin2x73 = pIwsMaitositumitatekin2x73;
    }

    @Column(order = 473, length = 13)
    private BizNumber iwsMaitositumitatekin2x74;

    public BizNumber getIwsMaitositumitatekin2x74() {
        return iwsMaitositumitatekin2x74;
    }

    public void setIwsMaitositumitatekin2x74(BizNumber pIwsMaitositumitatekin2x74) {
        iwsMaitositumitatekin2x74 = pIwsMaitositumitatekin2x74;
    }

    @Column(order = 474, length = 13)
    private BizNumber iwsMaitositumitatekin2x75;

    public BizNumber getIwsMaitositumitatekin2x75() {
        return iwsMaitositumitatekin2x75;
    }

    public void setIwsMaitositumitatekin2x75(BizNumber pIwsMaitositumitatekin2x75) {
        iwsMaitositumitatekin2x75 = pIwsMaitositumitatekin2x75;
    }

    @Column(order = 475, length = 13)
    private BizNumber iwsMaitositumitatekin2x76;

    public BizNumber getIwsMaitositumitatekin2x76() {
        return iwsMaitositumitatekin2x76;
    }

    public void setIwsMaitositumitatekin2x76(BizNumber pIwsMaitositumitatekin2x76) {
        iwsMaitositumitatekin2x76 = pIwsMaitositumitatekin2x76;
    }

    @Column(order = 476, length = 13)
    private BizNumber iwsMaitositumitatekin2x77;

    public BizNumber getIwsMaitositumitatekin2x77() {
        return iwsMaitositumitatekin2x77;
    }

    public void setIwsMaitositumitatekin2x77(BizNumber pIwsMaitositumitatekin2x77) {
        iwsMaitositumitatekin2x77 = pIwsMaitositumitatekin2x77;
    }

    @Column(order = 477, length = 13)
    private BizNumber iwsMaitositumitatekin2x78;

    public BizNumber getIwsMaitositumitatekin2x78() {
        return iwsMaitositumitatekin2x78;
    }

    public void setIwsMaitositumitatekin2x78(BizNumber pIwsMaitositumitatekin2x78) {
        iwsMaitositumitatekin2x78 = pIwsMaitositumitatekin2x78;
    }

    @Column(order = 478, length = 13)
    private BizNumber iwsMaitositumitatekin2x79;

    public BizNumber getIwsMaitositumitatekin2x79() {
        return iwsMaitositumitatekin2x79;
    }

    public void setIwsMaitositumitatekin2x79(BizNumber pIwsMaitositumitatekin2x79) {
        iwsMaitositumitatekin2x79 = pIwsMaitositumitatekin2x79;
    }

    @Column(order = 479, length = 13)
    private BizNumber iwsMaitositumitatekin2x80;

    public BizNumber getIwsMaitositumitatekin2x80() {
        return iwsMaitositumitatekin2x80;
    }

    public void setIwsMaitositumitatekin2x80(BizNumber pIwsMaitositumitatekin2x80) {
        iwsMaitositumitatekin2x80 = pIwsMaitositumitatekin2x80;
    }

    @Column(order = 480, length = 13)
    private BizNumber iwsMaitositumitatekin2x81;

    public BizNumber getIwsMaitositumitatekin2x81() {
        return iwsMaitositumitatekin2x81;
    }

    public void setIwsMaitositumitatekin2x81(BizNumber pIwsMaitositumitatekin2x81) {
        iwsMaitositumitatekin2x81 = pIwsMaitositumitatekin2x81;
    }

    @Column(order = 481, length = 13)
    private BizNumber iwsMaitositumitatekin2x82;

    public BizNumber getIwsMaitositumitatekin2x82() {
        return iwsMaitositumitatekin2x82;
    }

    public void setIwsMaitositumitatekin2x82(BizNumber pIwsMaitositumitatekin2x82) {
        iwsMaitositumitatekin2x82 = pIwsMaitositumitatekin2x82;
    }

    @Column(order = 482, length = 13)
    private BizNumber iwsMaitositumitatekin2x83;

    public BizNumber getIwsMaitositumitatekin2x83() {
        return iwsMaitositumitatekin2x83;
    }

    public void setIwsMaitositumitatekin2x83(BizNumber pIwsMaitositumitatekin2x83) {
        iwsMaitositumitatekin2x83 = pIwsMaitositumitatekin2x83;
    }

    @Column(order = 483, length = 13)
    private BizNumber iwsMaitositumitatekin2x84;

    public BizNumber getIwsMaitositumitatekin2x84() {
        return iwsMaitositumitatekin2x84;
    }

    public void setIwsMaitositumitatekin2x84(BizNumber pIwsMaitositumitatekin2x84) {
        iwsMaitositumitatekin2x84 = pIwsMaitositumitatekin2x84;
    }

    @Column(order = 484, length = 13)
    private BizNumber iwsMaitositumitatekin2x85;

    public BizNumber getIwsMaitositumitatekin2x85() {
        return iwsMaitositumitatekin2x85;
    }

    public void setIwsMaitositumitatekin2x85(BizNumber pIwsMaitositumitatekin2x85) {
        iwsMaitositumitatekin2x85 = pIwsMaitositumitatekin2x85;
    }

    @Column(order = 485, length = 13)
    private BizNumber iwsMaitositumitatekin2x86;

    public BizNumber getIwsMaitositumitatekin2x86() {
        return iwsMaitositumitatekin2x86;
    }

    public void setIwsMaitositumitatekin2x86(BizNumber pIwsMaitositumitatekin2x86) {
        iwsMaitositumitatekin2x86 = pIwsMaitositumitatekin2x86;
    }

    @Column(order = 486, length = 13)
    private BizNumber iwsMaitositumitatekin2x87;

    public BizNumber getIwsMaitositumitatekin2x87() {
        return iwsMaitositumitatekin2x87;
    }

    public void setIwsMaitositumitatekin2x87(BizNumber pIwsMaitositumitatekin2x87) {
        iwsMaitositumitatekin2x87 = pIwsMaitositumitatekin2x87;
    }

    @Column(order = 487, length = 13)
    private BizNumber iwsMaitositumitatekin2x88;

    public BizNumber getIwsMaitositumitatekin2x88() {
        return iwsMaitositumitatekin2x88;
    }

    public void setIwsMaitositumitatekin2x88(BizNumber pIwsMaitositumitatekin2x88) {
        iwsMaitositumitatekin2x88 = pIwsMaitositumitatekin2x88;
    }

    @Column(order = 488, length = 13)
    private BizNumber iwsMaitositumitatekin2x89;

    public BizNumber getIwsMaitositumitatekin2x89() {
        return iwsMaitositumitatekin2x89;
    }

    public void setIwsMaitositumitatekin2x89(BizNumber pIwsMaitositumitatekin2x89) {
        iwsMaitositumitatekin2x89 = pIwsMaitositumitatekin2x89;
    }

    @Column(order = 489, length = 13)
    private BizNumber iwsMaitositumitatekin2x90;

    public BizNumber getIwsMaitositumitatekin2x90() {
        return iwsMaitositumitatekin2x90;
    }

    public void setIwsMaitositumitatekin2x90(BizNumber pIwsMaitositumitatekin2x90) {
        iwsMaitositumitatekin2x90 = pIwsMaitositumitatekin2x90;
    }

    @Column(order = 490, length = 13)
    private BizNumber iwsMaitositumitatekin2x91;

    public BizNumber getIwsMaitositumitatekin2x91() {
        return iwsMaitositumitatekin2x91;
    }

    public void setIwsMaitositumitatekin2x91(BizNumber pIwsMaitositumitatekin2x91) {
        iwsMaitositumitatekin2x91 = pIwsMaitositumitatekin2x91;
    }

    @Column(order = 491, length = 13)
    private BizNumber iwsMaitositumitatekin2x92;

    public BizNumber getIwsMaitositumitatekin2x92() {
        return iwsMaitositumitatekin2x92;
    }

    public void setIwsMaitositumitatekin2x92(BizNumber pIwsMaitositumitatekin2x92) {
        iwsMaitositumitatekin2x92 = pIwsMaitositumitatekin2x92;
    }

    @Column(order = 492, length = 13)
    private BizNumber iwsMaitositumitatekin2x93;

    public BizNumber getIwsMaitositumitatekin2x93() {
        return iwsMaitositumitatekin2x93;
    }

    public void setIwsMaitositumitatekin2x93(BizNumber pIwsMaitositumitatekin2x93) {
        iwsMaitositumitatekin2x93 = pIwsMaitositumitatekin2x93;
    }

    @Column(order = 493, length = 13)
    private BizNumber iwsMaitositumitatekin2x94;

    public BizNumber getIwsMaitositumitatekin2x94() {
        return iwsMaitositumitatekin2x94;
    }

    public void setIwsMaitositumitatekin2x94(BizNumber pIwsMaitositumitatekin2x94) {
        iwsMaitositumitatekin2x94 = pIwsMaitositumitatekin2x94;
    }

    @Column(order = 494, length = 13)
    private BizNumber iwsMaitositumitatekin2x95;

    public BizNumber getIwsMaitositumitatekin2x95() {
        return iwsMaitositumitatekin2x95;
    }

    public void setIwsMaitositumitatekin2x95(BizNumber pIwsMaitositumitatekin2x95) {
        iwsMaitositumitatekin2x95 = pIwsMaitositumitatekin2x95;
    }

    @Column(order = 495, length = 13)
    private BizNumber iwsMaitositumitatekin2x96;

    public BizNumber getIwsMaitositumitatekin2x96() {
        return iwsMaitositumitatekin2x96;
    }

    public void setIwsMaitositumitatekin2x96(BizNumber pIwsMaitositumitatekin2x96) {
        iwsMaitositumitatekin2x96 = pIwsMaitositumitatekin2x96;
    }

    @Column(order = 496, length = 13)
    private BizNumber iwsMaitositumitatekin2x97;

    public BizNumber getIwsMaitositumitatekin2x97() {
        return iwsMaitositumitatekin2x97;
    }

    public void setIwsMaitositumitatekin2x97(BizNumber pIwsMaitositumitatekin2x97) {
        iwsMaitositumitatekin2x97 = pIwsMaitositumitatekin2x97;
    }

    @Column(order = 497, length = 13)
    private BizNumber iwsMaitositumitatekin2x98;

    public BizNumber getIwsMaitositumitatekin2x98() {
        return iwsMaitositumitatekin2x98;
    }

    public void setIwsMaitositumitatekin2x98(BizNumber pIwsMaitositumitatekin2x98) {
        iwsMaitositumitatekin2x98 = pIwsMaitositumitatekin2x98;
    }

    @Column(order = 498, length = 13)
    private BizNumber iwsMaitositumitatekin2x99;

    public BizNumber getIwsMaitositumitatekin2x99() {
        return iwsMaitositumitatekin2x99;
    }

    public void setIwsMaitositumitatekin2x99(BizNumber pIwsMaitositumitatekin2x99) {
        iwsMaitositumitatekin2x99 = pIwsMaitositumitatekin2x99;
    }

    @Column(order = 499, length = 13)
    private BizNumber iwsMaitositumitatekin3x1;

    public BizNumber getIwsMaitositumitatekin3x1() {
        return iwsMaitositumitatekin3x1;
    }

    public void setIwsMaitositumitatekin3x1(BizNumber pIwsMaitositumitatekin3x1) {
        iwsMaitositumitatekin3x1 = pIwsMaitositumitatekin3x1;
    }

    @Column(order = 500, length = 13)
    private BizNumber iwsMaitositumitatekin3x2;

    public BizNumber getIwsMaitositumitatekin3x2() {
        return iwsMaitositumitatekin3x2;
    }

    public void setIwsMaitositumitatekin3x2(BizNumber pIwsMaitositumitatekin3x2) {
        iwsMaitositumitatekin3x2 = pIwsMaitositumitatekin3x2;
    }

    @Column(order = 501, length = 13)
    private BizNumber iwsMaitositumitatekin3x3;

    public BizNumber getIwsMaitositumitatekin3x3() {
        return iwsMaitositumitatekin3x3;
    }

    public void setIwsMaitositumitatekin3x3(BizNumber pIwsMaitositumitatekin3x3) {
        iwsMaitositumitatekin3x3 = pIwsMaitositumitatekin3x3;
    }

    @Column(order = 502, length = 13)
    private BizNumber iwsMaitositumitatekin3x4;

    public BizNumber getIwsMaitositumitatekin3x4() {
        return iwsMaitositumitatekin3x4;
    }

    public void setIwsMaitositumitatekin3x4(BizNumber pIwsMaitositumitatekin3x4) {
        iwsMaitositumitatekin3x4 = pIwsMaitositumitatekin3x4;
    }

    @Column(order = 503, length = 13)
    private BizNumber iwsMaitositumitatekin3x5;

    public BizNumber getIwsMaitositumitatekin3x5() {
        return iwsMaitositumitatekin3x5;
    }

    public void setIwsMaitositumitatekin3x5(BizNumber pIwsMaitositumitatekin3x5) {
        iwsMaitositumitatekin3x5 = pIwsMaitositumitatekin3x5;
    }

    @Column(order = 504, length = 13)
    private BizNumber iwsMaitositumitatekin3x6;

    public BizNumber getIwsMaitositumitatekin3x6() {
        return iwsMaitositumitatekin3x6;
    }

    public void setIwsMaitositumitatekin3x6(BizNumber pIwsMaitositumitatekin3x6) {
        iwsMaitositumitatekin3x6 = pIwsMaitositumitatekin3x6;
    }

    @Column(order = 505, length = 13)
    private BizNumber iwsMaitositumitatekin3x7;

    public BizNumber getIwsMaitositumitatekin3x7() {
        return iwsMaitositumitatekin3x7;
    }

    public void setIwsMaitositumitatekin3x7(BizNumber pIwsMaitositumitatekin3x7) {
        iwsMaitositumitatekin3x7 = pIwsMaitositumitatekin3x7;
    }

    @Column(order = 506, length = 13)
    private BizNumber iwsMaitositumitatekin3x8;

    public BizNumber getIwsMaitositumitatekin3x8() {
        return iwsMaitositumitatekin3x8;
    }

    public void setIwsMaitositumitatekin3x8(BizNumber pIwsMaitositumitatekin3x8) {
        iwsMaitositumitatekin3x8 = pIwsMaitositumitatekin3x8;
    }

    @Column(order = 507, length = 13)
    private BizNumber iwsMaitositumitatekin3x9;

    public BizNumber getIwsMaitositumitatekin3x9() {
        return iwsMaitositumitatekin3x9;
    }

    public void setIwsMaitositumitatekin3x9(BizNumber pIwsMaitositumitatekin3x9) {
        iwsMaitositumitatekin3x9 = pIwsMaitositumitatekin3x9;
    }

    @Column(order = 508, length = 13)
    private BizNumber iwsMaitositumitatekin3x10;

    public BizNumber getIwsMaitositumitatekin3x10() {
        return iwsMaitositumitatekin3x10;
    }

    public void setIwsMaitositumitatekin3x10(BizNumber pIwsMaitositumitatekin3x10) {
        iwsMaitositumitatekin3x10 = pIwsMaitositumitatekin3x10;
    }

    @Column(order = 509, length = 13)
    private BizNumber iwsMaitositumitatekin3x11;

    public BizNumber getIwsMaitositumitatekin3x11() {
        return iwsMaitositumitatekin3x11;
    }

    public void setIwsMaitositumitatekin3x11(BizNumber pIwsMaitositumitatekin3x11) {
        iwsMaitositumitatekin3x11 = pIwsMaitositumitatekin3x11;
    }

    @Column(order = 510, length = 13)
    private BizNumber iwsMaitositumitatekin3x12;

    public BizNumber getIwsMaitositumitatekin3x12() {
        return iwsMaitositumitatekin3x12;
    }

    public void setIwsMaitositumitatekin3x12(BizNumber pIwsMaitositumitatekin3x12) {
        iwsMaitositumitatekin3x12 = pIwsMaitositumitatekin3x12;
    }

    @Column(order = 511, length = 13)
    private BizNumber iwsMaitositumitatekin3x13;

    public BizNumber getIwsMaitositumitatekin3x13() {
        return iwsMaitositumitatekin3x13;
    }

    public void setIwsMaitositumitatekin3x13(BizNumber pIwsMaitositumitatekin3x13) {
        iwsMaitositumitatekin3x13 = pIwsMaitositumitatekin3x13;
    }

    @Column(order = 512, length = 13)
    private BizNumber iwsMaitositumitatekin3x14;

    public BizNumber getIwsMaitositumitatekin3x14() {
        return iwsMaitositumitatekin3x14;
    }

    public void setIwsMaitositumitatekin3x14(BizNumber pIwsMaitositumitatekin3x14) {
        iwsMaitositumitatekin3x14 = pIwsMaitositumitatekin3x14;
    }

    @Column(order = 513, length = 13)
    private BizNumber iwsMaitositumitatekin3x15;

    public BizNumber getIwsMaitositumitatekin3x15() {
        return iwsMaitositumitatekin3x15;
    }

    public void setIwsMaitositumitatekin3x15(BizNumber pIwsMaitositumitatekin3x15) {
        iwsMaitositumitatekin3x15 = pIwsMaitositumitatekin3x15;
    }

    @Column(order = 514, length = 13)
    private BizNumber iwsMaitositumitatekin3x16;

    public BizNumber getIwsMaitositumitatekin3x16() {
        return iwsMaitositumitatekin3x16;
    }

    public void setIwsMaitositumitatekin3x16(BizNumber pIwsMaitositumitatekin3x16) {
        iwsMaitositumitatekin3x16 = pIwsMaitositumitatekin3x16;
    }

    @Column(order = 515, length = 13)
    private BizNumber iwsMaitositumitatekin3x17;

    public BizNumber getIwsMaitositumitatekin3x17() {
        return iwsMaitositumitatekin3x17;
    }

    public void setIwsMaitositumitatekin3x17(BizNumber pIwsMaitositumitatekin3x17) {
        iwsMaitositumitatekin3x17 = pIwsMaitositumitatekin3x17;
    }

    @Column(order = 516, length = 13)
    private BizNumber iwsMaitositumitatekin3x18;

    public BizNumber getIwsMaitositumitatekin3x18() {
        return iwsMaitositumitatekin3x18;
    }

    public void setIwsMaitositumitatekin3x18(BizNumber pIwsMaitositumitatekin3x18) {
        iwsMaitositumitatekin3x18 = pIwsMaitositumitatekin3x18;
    }

    @Column(order = 517, length = 13)
    private BizNumber iwsMaitositumitatekin3x19;

    public BizNumber getIwsMaitositumitatekin3x19() {
        return iwsMaitositumitatekin3x19;
    }

    public void setIwsMaitositumitatekin3x19(BizNumber pIwsMaitositumitatekin3x19) {
        iwsMaitositumitatekin3x19 = pIwsMaitositumitatekin3x19;
    }

    @Column(order = 518, length = 13)
    private BizNumber iwsMaitositumitatekin3x20;

    public BizNumber getIwsMaitositumitatekin3x20() {
        return iwsMaitositumitatekin3x20;
    }

    public void setIwsMaitositumitatekin3x20(BizNumber pIwsMaitositumitatekin3x20) {
        iwsMaitositumitatekin3x20 = pIwsMaitositumitatekin3x20;
    }

    @Column(order = 519, length = 13)
    private BizNumber iwsMaitositumitatekin3x21;

    public BizNumber getIwsMaitositumitatekin3x21() {
        return iwsMaitositumitatekin3x21;
    }

    public void setIwsMaitositumitatekin3x21(BizNumber pIwsMaitositumitatekin3x21) {
        iwsMaitositumitatekin3x21 = pIwsMaitositumitatekin3x21;
    }

    @Column(order = 520, length = 13)
    private BizNumber iwsMaitositumitatekin3x22;

    public BizNumber getIwsMaitositumitatekin3x22() {
        return iwsMaitositumitatekin3x22;
    }

    public void setIwsMaitositumitatekin3x22(BizNumber pIwsMaitositumitatekin3x22) {
        iwsMaitositumitatekin3x22 = pIwsMaitositumitatekin3x22;
    }

    @Column(order = 521, length = 13)
    private BizNumber iwsMaitositumitatekin3x23;

    public BizNumber getIwsMaitositumitatekin3x23() {
        return iwsMaitositumitatekin3x23;
    }

    public void setIwsMaitositumitatekin3x23(BizNumber pIwsMaitositumitatekin3x23) {
        iwsMaitositumitatekin3x23 = pIwsMaitositumitatekin3x23;
    }

    @Column(order = 522, length = 13)
    private BizNumber iwsMaitositumitatekin3x24;

    public BizNumber getIwsMaitositumitatekin3x24() {
        return iwsMaitositumitatekin3x24;
    }

    public void setIwsMaitositumitatekin3x24(BizNumber pIwsMaitositumitatekin3x24) {
        iwsMaitositumitatekin3x24 = pIwsMaitositumitatekin3x24;
    }

    @Column(order = 523, length = 13)
    private BizNumber iwsMaitositumitatekin3x25;

    public BizNumber getIwsMaitositumitatekin3x25() {
        return iwsMaitositumitatekin3x25;
    }

    public void setIwsMaitositumitatekin3x25(BizNumber pIwsMaitositumitatekin3x25) {
        iwsMaitositumitatekin3x25 = pIwsMaitositumitatekin3x25;
    }

    @Column(order = 524, length = 13)
    private BizNumber iwsMaitositumitatekin3x26;

    public BizNumber getIwsMaitositumitatekin3x26() {
        return iwsMaitositumitatekin3x26;
    }

    public void setIwsMaitositumitatekin3x26(BizNumber pIwsMaitositumitatekin3x26) {
        iwsMaitositumitatekin3x26 = pIwsMaitositumitatekin3x26;
    }

    @Column(order = 525, length = 13)
    private BizNumber iwsMaitositumitatekin3x27;

    public BizNumber getIwsMaitositumitatekin3x27() {
        return iwsMaitositumitatekin3x27;
    }

    public void setIwsMaitositumitatekin3x27(BizNumber pIwsMaitositumitatekin3x27) {
        iwsMaitositumitatekin3x27 = pIwsMaitositumitatekin3x27;
    }

    @Column(order = 526, length = 13)
    private BizNumber iwsMaitositumitatekin3x28;

    public BizNumber getIwsMaitositumitatekin3x28() {
        return iwsMaitositumitatekin3x28;
    }

    public void setIwsMaitositumitatekin3x28(BizNumber pIwsMaitositumitatekin3x28) {
        iwsMaitositumitatekin3x28 = pIwsMaitositumitatekin3x28;
    }

    @Column(order = 527, length = 13)
    private BizNumber iwsMaitositumitatekin3x29;

    public BizNumber getIwsMaitositumitatekin3x29() {
        return iwsMaitositumitatekin3x29;
    }

    public void setIwsMaitositumitatekin3x29(BizNumber pIwsMaitositumitatekin3x29) {
        iwsMaitositumitatekin3x29 = pIwsMaitositumitatekin3x29;
    }

    @Column(order = 528, length = 13)
    private BizNumber iwsMaitositumitatekin3x30;

    public BizNumber getIwsMaitositumitatekin3x30() {
        return iwsMaitositumitatekin3x30;
    }

    public void setIwsMaitositumitatekin3x30(BizNumber pIwsMaitositumitatekin3x30) {
        iwsMaitositumitatekin3x30 = pIwsMaitositumitatekin3x30;
    }

    @Column(order = 529, length = 13)
    private BizNumber iwsMaitositumitatekin3x31;

    public BizNumber getIwsMaitositumitatekin3x31() {
        return iwsMaitositumitatekin3x31;
    }

    public void setIwsMaitositumitatekin3x31(BizNumber pIwsMaitositumitatekin3x31) {
        iwsMaitositumitatekin3x31 = pIwsMaitositumitatekin3x31;
    }

    @Column(order = 530, length = 13)
    private BizNumber iwsMaitositumitatekin3x32;

    public BizNumber getIwsMaitositumitatekin3x32() {
        return iwsMaitositumitatekin3x32;
    }

    public void setIwsMaitositumitatekin3x32(BizNumber pIwsMaitositumitatekin3x32) {
        iwsMaitositumitatekin3x32 = pIwsMaitositumitatekin3x32;
    }

    @Column(order = 531, length = 13)
    private BizNumber iwsMaitositumitatekin3x33;

    public BizNumber getIwsMaitositumitatekin3x33() {
        return iwsMaitositumitatekin3x33;
    }

    public void setIwsMaitositumitatekin3x33(BizNumber pIwsMaitositumitatekin3x33) {
        iwsMaitositumitatekin3x33 = pIwsMaitositumitatekin3x33;
    }

    @Column(order = 532, length = 13)
    private BizNumber iwsMaitositumitatekin3x34;

    public BizNumber getIwsMaitositumitatekin3x34() {
        return iwsMaitositumitatekin3x34;
    }

    public void setIwsMaitositumitatekin3x34(BizNumber pIwsMaitositumitatekin3x34) {
        iwsMaitositumitatekin3x34 = pIwsMaitositumitatekin3x34;
    }

    @Column(order = 533, length = 13)
    private BizNumber iwsMaitositumitatekin3x35;

    public BizNumber getIwsMaitositumitatekin3x35() {
        return iwsMaitositumitatekin3x35;
    }

    public void setIwsMaitositumitatekin3x35(BizNumber pIwsMaitositumitatekin3x35) {
        iwsMaitositumitatekin3x35 = pIwsMaitositumitatekin3x35;
    }

    @Column(order = 534, length = 13)
    private BizNumber iwsMaitositumitatekin3x36;

    public BizNumber getIwsMaitositumitatekin3x36() {
        return iwsMaitositumitatekin3x36;
    }

    public void setIwsMaitositumitatekin3x36(BizNumber pIwsMaitositumitatekin3x36) {
        iwsMaitositumitatekin3x36 = pIwsMaitositumitatekin3x36;
    }

    @Column(order = 535, length = 13)
    private BizNumber iwsMaitositumitatekin3x37;

    public BizNumber getIwsMaitositumitatekin3x37() {
        return iwsMaitositumitatekin3x37;
    }

    public void setIwsMaitositumitatekin3x37(BizNumber pIwsMaitositumitatekin3x37) {
        iwsMaitositumitatekin3x37 = pIwsMaitositumitatekin3x37;
    }

    @Column(order = 536, length = 13)
    private BizNumber iwsMaitositumitatekin3x38;

    public BizNumber getIwsMaitositumitatekin3x38() {
        return iwsMaitositumitatekin3x38;
    }

    public void setIwsMaitositumitatekin3x38(BizNumber pIwsMaitositumitatekin3x38) {
        iwsMaitositumitatekin3x38 = pIwsMaitositumitatekin3x38;
    }

    @Column(order = 537, length = 13)
    private BizNumber iwsMaitositumitatekin3x39;

    public BizNumber getIwsMaitositumitatekin3x39() {
        return iwsMaitositumitatekin3x39;
    }

    public void setIwsMaitositumitatekin3x39(BizNumber pIwsMaitositumitatekin3x39) {
        iwsMaitositumitatekin3x39 = pIwsMaitositumitatekin3x39;
    }

    @Column(order = 538, length = 13)
    private BizNumber iwsMaitositumitatekin3x40;

    public BizNumber getIwsMaitositumitatekin3x40() {
        return iwsMaitositumitatekin3x40;
    }

    public void setIwsMaitositumitatekin3x40(BizNumber pIwsMaitositumitatekin3x40) {
        iwsMaitositumitatekin3x40 = pIwsMaitositumitatekin3x40;
    }

    @Column(order = 539, length = 13)
    private BizNumber iwsMaitositumitatekin3x41;

    public BizNumber getIwsMaitositumitatekin3x41() {
        return iwsMaitositumitatekin3x41;
    }

    public void setIwsMaitositumitatekin3x41(BizNumber pIwsMaitositumitatekin3x41) {
        iwsMaitositumitatekin3x41 = pIwsMaitositumitatekin3x41;
    }

    @Column(order = 540, length = 13)
    private BizNumber iwsMaitositumitatekin3x42;

    public BizNumber getIwsMaitositumitatekin3x42() {
        return iwsMaitositumitatekin3x42;
    }

    public void setIwsMaitositumitatekin3x42(BizNumber pIwsMaitositumitatekin3x42) {
        iwsMaitositumitatekin3x42 = pIwsMaitositumitatekin3x42;
    }

    @Column(order = 541, length = 13)
    private BizNumber iwsMaitositumitatekin3x43;

    public BizNumber getIwsMaitositumitatekin3x43() {
        return iwsMaitositumitatekin3x43;
    }

    public void setIwsMaitositumitatekin3x43(BizNumber pIwsMaitositumitatekin3x43) {
        iwsMaitositumitatekin3x43 = pIwsMaitositumitatekin3x43;
    }

    @Column(order = 542, length = 13)
    private BizNumber iwsMaitositumitatekin3x44;

    public BizNumber getIwsMaitositumitatekin3x44() {
        return iwsMaitositumitatekin3x44;
    }

    public void setIwsMaitositumitatekin3x44(BizNumber pIwsMaitositumitatekin3x44) {
        iwsMaitositumitatekin3x44 = pIwsMaitositumitatekin3x44;
    }

    @Column(order = 543, length = 13)
    private BizNumber iwsMaitositumitatekin3x45;

    public BizNumber getIwsMaitositumitatekin3x45() {
        return iwsMaitositumitatekin3x45;
    }

    public void setIwsMaitositumitatekin3x45(BizNumber pIwsMaitositumitatekin3x45) {
        iwsMaitositumitatekin3x45 = pIwsMaitositumitatekin3x45;
    }

    @Column(order = 544, length = 13)
    private BizNumber iwsMaitositumitatekin3x46;

    public BizNumber getIwsMaitositumitatekin3x46() {
        return iwsMaitositumitatekin3x46;
    }

    public void setIwsMaitositumitatekin3x46(BizNumber pIwsMaitositumitatekin3x46) {
        iwsMaitositumitatekin3x46 = pIwsMaitositumitatekin3x46;
    }

    @Column(order = 545, length = 13)
    private BizNumber iwsMaitositumitatekin3x47;

    public BizNumber getIwsMaitositumitatekin3x47() {
        return iwsMaitositumitatekin3x47;
    }

    public void setIwsMaitositumitatekin3x47(BizNumber pIwsMaitositumitatekin3x47) {
        iwsMaitositumitatekin3x47 = pIwsMaitositumitatekin3x47;
    }

    @Column(order = 546, length = 13)
    private BizNumber iwsMaitositumitatekin3x48;

    public BizNumber getIwsMaitositumitatekin3x48() {
        return iwsMaitositumitatekin3x48;
    }

    public void setIwsMaitositumitatekin3x48(BizNumber pIwsMaitositumitatekin3x48) {
        iwsMaitositumitatekin3x48 = pIwsMaitositumitatekin3x48;
    }

    @Column(order = 547, length = 13)
    private BizNumber iwsMaitositumitatekin3x49;

    public BizNumber getIwsMaitositumitatekin3x49() {
        return iwsMaitositumitatekin3x49;
    }

    public void setIwsMaitositumitatekin3x49(BizNumber pIwsMaitositumitatekin3x49) {
        iwsMaitositumitatekin3x49 = pIwsMaitositumitatekin3x49;
    }

    @Column(order = 548, length = 13)
    private BizNumber iwsMaitositumitatekin3x50;

    public BizNumber getIwsMaitositumitatekin3x50() {
        return iwsMaitositumitatekin3x50;
    }

    public void setIwsMaitositumitatekin3x50(BizNumber pIwsMaitositumitatekin3x50) {
        iwsMaitositumitatekin3x50 = pIwsMaitositumitatekin3x50;
    }

    @Column(order = 549, length = 13)
    private BizNumber iwsMaitositumitatekin3x51;

    public BizNumber getIwsMaitositumitatekin3x51() {
        return iwsMaitositumitatekin3x51;
    }

    public void setIwsMaitositumitatekin3x51(BizNumber pIwsMaitositumitatekin3x51) {
        iwsMaitositumitatekin3x51 = pIwsMaitositumitatekin3x51;
    }

    @Column(order = 550, length = 13)
    private BizNumber iwsMaitositumitatekin3x52;

    public BizNumber getIwsMaitositumitatekin3x52() {
        return iwsMaitositumitatekin3x52;
    }

    public void setIwsMaitositumitatekin3x52(BizNumber pIwsMaitositumitatekin3x52) {
        iwsMaitositumitatekin3x52 = pIwsMaitositumitatekin3x52;
    }

    @Column(order = 551, length = 13)
    private BizNumber iwsMaitositumitatekin3x53;

    public BizNumber getIwsMaitositumitatekin3x53() {
        return iwsMaitositumitatekin3x53;
    }

    public void setIwsMaitositumitatekin3x53(BizNumber pIwsMaitositumitatekin3x53) {
        iwsMaitositumitatekin3x53 = pIwsMaitositumitatekin3x53;
    }

    @Column(order = 552, length = 13)
    private BizNumber iwsMaitositumitatekin3x54;

    public BizNumber getIwsMaitositumitatekin3x54() {
        return iwsMaitositumitatekin3x54;
    }

    public void setIwsMaitositumitatekin3x54(BizNumber pIwsMaitositumitatekin3x54) {
        iwsMaitositumitatekin3x54 = pIwsMaitositumitatekin3x54;
    }

    @Column(order = 553, length = 13)
    private BizNumber iwsMaitositumitatekin3x55;

    public BizNumber getIwsMaitositumitatekin3x55() {
        return iwsMaitositumitatekin3x55;
    }

    public void setIwsMaitositumitatekin3x55(BizNumber pIwsMaitositumitatekin3x55) {
        iwsMaitositumitatekin3x55 = pIwsMaitositumitatekin3x55;
    }

    @Column(order = 554, length = 13)
    private BizNumber iwsMaitositumitatekin3x56;

    public BizNumber getIwsMaitositumitatekin3x56() {
        return iwsMaitositumitatekin3x56;
    }

    public void setIwsMaitositumitatekin3x56(BizNumber pIwsMaitositumitatekin3x56) {
        iwsMaitositumitatekin3x56 = pIwsMaitositumitatekin3x56;
    }

    @Column(order = 555, length = 13)
    private BizNumber iwsMaitositumitatekin3x57;

    public BizNumber getIwsMaitositumitatekin3x57() {
        return iwsMaitositumitatekin3x57;
    }

    public void setIwsMaitositumitatekin3x57(BizNumber pIwsMaitositumitatekin3x57) {
        iwsMaitositumitatekin3x57 = pIwsMaitositumitatekin3x57;
    }

    @Column(order = 556, length = 13)
    private BizNumber iwsMaitositumitatekin3x58;

    public BizNumber getIwsMaitositumitatekin3x58() {
        return iwsMaitositumitatekin3x58;
    }

    public void setIwsMaitositumitatekin3x58(BizNumber pIwsMaitositumitatekin3x58) {
        iwsMaitositumitatekin3x58 = pIwsMaitositumitatekin3x58;
    }

    @Column(order = 557, length = 13)
    private BizNumber iwsMaitositumitatekin3x59;

    public BizNumber getIwsMaitositumitatekin3x59() {
        return iwsMaitositumitatekin3x59;
    }

    public void setIwsMaitositumitatekin3x59(BizNumber pIwsMaitositumitatekin3x59) {
        iwsMaitositumitatekin3x59 = pIwsMaitositumitatekin3x59;
    }

    @Column(order = 558, length = 13)
    private BizNumber iwsMaitositumitatekin3x60;

    public BizNumber getIwsMaitositumitatekin3x60() {
        return iwsMaitositumitatekin3x60;
    }

    public void setIwsMaitositumitatekin3x60(BizNumber pIwsMaitositumitatekin3x60) {
        iwsMaitositumitatekin3x60 = pIwsMaitositumitatekin3x60;
    }

    @Column(order = 559, length = 13)
    private BizNumber iwsMaitositumitatekin3x61;

    public BizNumber getIwsMaitositumitatekin3x61() {
        return iwsMaitositumitatekin3x61;
    }

    public void setIwsMaitositumitatekin3x61(BizNumber pIwsMaitositumitatekin3x61) {
        iwsMaitositumitatekin3x61 = pIwsMaitositumitatekin3x61;
    }

    @Column(order = 560, length = 13)
    private BizNumber iwsMaitositumitatekin3x62;

    public BizNumber getIwsMaitositumitatekin3x62() {
        return iwsMaitositumitatekin3x62;
    }

    public void setIwsMaitositumitatekin3x62(BizNumber pIwsMaitositumitatekin3x62) {
        iwsMaitositumitatekin3x62 = pIwsMaitositumitatekin3x62;
    }

    @Column(order = 561, length = 13)
    private BizNumber iwsMaitositumitatekin3x63;

    public BizNumber getIwsMaitositumitatekin3x63() {
        return iwsMaitositumitatekin3x63;
    }

    public void setIwsMaitositumitatekin3x63(BizNumber pIwsMaitositumitatekin3x63) {
        iwsMaitositumitatekin3x63 = pIwsMaitositumitatekin3x63;
    }

    @Column(order = 562, length = 13)
    private BizNumber iwsMaitositumitatekin3x64;

    public BizNumber getIwsMaitositumitatekin3x64() {
        return iwsMaitositumitatekin3x64;
    }

    public void setIwsMaitositumitatekin3x64(BizNumber pIwsMaitositumitatekin3x64) {
        iwsMaitositumitatekin3x64 = pIwsMaitositumitatekin3x64;
    }

    @Column(order = 563, length = 13)
    private BizNumber iwsMaitositumitatekin3x65;

    public BizNumber getIwsMaitositumitatekin3x65() {
        return iwsMaitositumitatekin3x65;
    }

    public void setIwsMaitositumitatekin3x65(BizNumber pIwsMaitositumitatekin3x65) {
        iwsMaitositumitatekin3x65 = pIwsMaitositumitatekin3x65;
    }

    @Column(order = 564, length = 13)
    private BizNumber iwsMaitositumitatekin3x66;

    public BizNumber getIwsMaitositumitatekin3x66() {
        return iwsMaitositumitatekin3x66;
    }

    public void setIwsMaitositumitatekin3x66(BizNumber pIwsMaitositumitatekin3x66) {
        iwsMaitositumitatekin3x66 = pIwsMaitositumitatekin3x66;
    }

    @Column(order = 565, length = 13)
    private BizNumber iwsMaitositumitatekin3x67;

    public BizNumber getIwsMaitositumitatekin3x67() {
        return iwsMaitositumitatekin3x67;
    }

    public void setIwsMaitositumitatekin3x67(BizNumber pIwsMaitositumitatekin3x67) {
        iwsMaitositumitatekin3x67 = pIwsMaitositumitatekin3x67;
    }

    @Column(order = 566, length = 13)
    private BizNumber iwsMaitositumitatekin3x68;

    public BizNumber getIwsMaitositumitatekin3x68() {
        return iwsMaitositumitatekin3x68;
    }

    public void setIwsMaitositumitatekin3x68(BizNumber pIwsMaitositumitatekin3x68) {
        iwsMaitositumitatekin3x68 = pIwsMaitositumitatekin3x68;
    }

    @Column(order = 567, length = 13)
    private BizNumber iwsMaitositumitatekin3x69;

    public BizNumber getIwsMaitositumitatekin3x69() {
        return iwsMaitositumitatekin3x69;
    }

    public void setIwsMaitositumitatekin3x69(BizNumber pIwsMaitositumitatekin3x69) {
        iwsMaitositumitatekin3x69 = pIwsMaitositumitatekin3x69;
    }

    @Column(order = 568, length = 13)
    private BizNumber iwsMaitositumitatekin3x70;

    public BizNumber getIwsMaitositumitatekin3x70() {
        return iwsMaitositumitatekin3x70;
    }

    public void setIwsMaitositumitatekin3x70(BizNumber pIwsMaitositumitatekin3x70) {
        iwsMaitositumitatekin3x70 = pIwsMaitositumitatekin3x70;
    }

    @Column(order = 569, length = 13)
    private BizNumber iwsMaitositumitatekin3x71;

    public BizNumber getIwsMaitositumitatekin3x71() {
        return iwsMaitositumitatekin3x71;
    }

    public void setIwsMaitositumitatekin3x71(BizNumber pIwsMaitositumitatekin3x71) {
        iwsMaitositumitatekin3x71 = pIwsMaitositumitatekin3x71;
    }

    @Column(order = 570, length = 13)
    private BizNumber iwsMaitositumitatekin3x72;

    public BizNumber getIwsMaitositumitatekin3x72() {
        return iwsMaitositumitatekin3x72;
    }

    public void setIwsMaitositumitatekin3x72(BizNumber pIwsMaitositumitatekin3x72) {
        iwsMaitositumitatekin3x72 = pIwsMaitositumitatekin3x72;
    }

    @Column(order = 571, length = 13)
    private BizNumber iwsMaitositumitatekin3x73;

    public BizNumber getIwsMaitositumitatekin3x73() {
        return iwsMaitositumitatekin3x73;
    }

    public void setIwsMaitositumitatekin3x73(BizNumber pIwsMaitositumitatekin3x73) {
        iwsMaitositumitatekin3x73 = pIwsMaitositumitatekin3x73;
    }

    @Column(order = 572, length = 13)
    private BizNumber iwsMaitositumitatekin3x74;

    public BizNumber getIwsMaitositumitatekin3x74() {
        return iwsMaitositumitatekin3x74;
    }

    public void setIwsMaitositumitatekin3x74(BizNumber pIwsMaitositumitatekin3x74) {
        iwsMaitositumitatekin3x74 = pIwsMaitositumitatekin3x74;
    }

    @Column(order = 573, length = 13)
    private BizNumber iwsMaitositumitatekin3x75;

    public BizNumber getIwsMaitositumitatekin3x75() {
        return iwsMaitositumitatekin3x75;
    }

    public void setIwsMaitositumitatekin3x75(BizNumber pIwsMaitositumitatekin3x75) {
        iwsMaitositumitatekin3x75 = pIwsMaitositumitatekin3x75;
    }

    @Column(order = 574, length = 13)
    private BizNumber iwsMaitositumitatekin3x76;

    public BizNumber getIwsMaitositumitatekin3x76() {
        return iwsMaitositumitatekin3x76;
    }

    public void setIwsMaitositumitatekin3x76(BizNumber pIwsMaitositumitatekin3x76) {
        iwsMaitositumitatekin3x76 = pIwsMaitositumitatekin3x76;
    }

    @Column(order = 575, length = 13)
    private BizNumber iwsMaitositumitatekin3x77;

    public BizNumber getIwsMaitositumitatekin3x77() {
        return iwsMaitositumitatekin3x77;
    }

    public void setIwsMaitositumitatekin3x77(BizNumber pIwsMaitositumitatekin3x77) {
        iwsMaitositumitatekin3x77 = pIwsMaitositumitatekin3x77;
    }

    @Column(order = 576, length = 13)
    private BizNumber iwsMaitositumitatekin3x78;

    public BizNumber getIwsMaitositumitatekin3x78() {
        return iwsMaitositumitatekin3x78;
    }

    public void setIwsMaitositumitatekin3x78(BizNumber pIwsMaitositumitatekin3x78) {
        iwsMaitositumitatekin3x78 = pIwsMaitositumitatekin3x78;
    }

    @Column(order = 577, length = 13)
    private BizNumber iwsMaitositumitatekin3x79;

    public BizNumber getIwsMaitositumitatekin3x79() {
        return iwsMaitositumitatekin3x79;
    }

    public void setIwsMaitositumitatekin3x79(BizNumber pIwsMaitositumitatekin3x79) {
        iwsMaitositumitatekin3x79 = pIwsMaitositumitatekin3x79;
    }

    @Column(order = 578, length = 13)
    private BizNumber iwsMaitositumitatekin3x80;

    public BizNumber getIwsMaitositumitatekin3x80() {
        return iwsMaitositumitatekin3x80;
    }

    public void setIwsMaitositumitatekin3x80(BizNumber pIwsMaitositumitatekin3x80) {
        iwsMaitositumitatekin3x80 = pIwsMaitositumitatekin3x80;
    }

    @Column(order = 579, length = 13)
    private BizNumber iwsMaitositumitatekin3x81;

    public BizNumber getIwsMaitositumitatekin3x81() {
        return iwsMaitositumitatekin3x81;
    }

    public void setIwsMaitositumitatekin3x81(BizNumber pIwsMaitositumitatekin3x81) {
        iwsMaitositumitatekin3x81 = pIwsMaitositumitatekin3x81;
    }

    @Column(order = 580, length = 13)
    private BizNumber iwsMaitositumitatekin3x82;

    public BizNumber getIwsMaitositumitatekin3x82() {
        return iwsMaitositumitatekin3x82;
    }

    public void setIwsMaitositumitatekin3x82(BizNumber pIwsMaitositumitatekin3x82) {
        iwsMaitositumitatekin3x82 = pIwsMaitositumitatekin3x82;
    }

    @Column(order = 581, length = 13)
    private BizNumber iwsMaitositumitatekin3x83;

    public BizNumber getIwsMaitositumitatekin3x83() {
        return iwsMaitositumitatekin3x83;
    }

    public void setIwsMaitositumitatekin3x83(BizNumber pIwsMaitositumitatekin3x83) {
        iwsMaitositumitatekin3x83 = pIwsMaitositumitatekin3x83;
    }

    @Column(order = 582, length = 13)
    private BizNumber iwsMaitositumitatekin3x84;

    public BizNumber getIwsMaitositumitatekin3x84() {
        return iwsMaitositumitatekin3x84;
    }

    public void setIwsMaitositumitatekin3x84(BizNumber pIwsMaitositumitatekin3x84) {
        iwsMaitositumitatekin3x84 = pIwsMaitositumitatekin3x84;
    }

    @Column(order = 583, length = 13)
    private BizNumber iwsMaitositumitatekin3x85;

    public BizNumber getIwsMaitositumitatekin3x85() {
        return iwsMaitositumitatekin3x85;
    }

    public void setIwsMaitositumitatekin3x85(BizNumber pIwsMaitositumitatekin3x85) {
        iwsMaitositumitatekin3x85 = pIwsMaitositumitatekin3x85;
    }

    @Column(order = 584, length = 13)
    private BizNumber iwsMaitositumitatekin3x86;

    public BizNumber getIwsMaitositumitatekin3x86() {
        return iwsMaitositumitatekin3x86;
    }

    public void setIwsMaitositumitatekin3x86(BizNumber pIwsMaitositumitatekin3x86) {
        iwsMaitositumitatekin3x86 = pIwsMaitositumitatekin3x86;
    }

    @Column(order = 585, length = 13)
    private BizNumber iwsMaitositumitatekin3x87;

    public BizNumber getIwsMaitositumitatekin3x87() {
        return iwsMaitositumitatekin3x87;
    }

    public void setIwsMaitositumitatekin3x87(BizNumber pIwsMaitositumitatekin3x87) {
        iwsMaitositumitatekin3x87 = pIwsMaitositumitatekin3x87;
    }

    @Column(order = 586, length = 13)
    private BizNumber iwsMaitositumitatekin3x88;

    public BizNumber getIwsMaitositumitatekin3x88() {
        return iwsMaitositumitatekin3x88;
    }

    public void setIwsMaitositumitatekin3x88(BizNumber pIwsMaitositumitatekin3x88) {
        iwsMaitositumitatekin3x88 = pIwsMaitositumitatekin3x88;
    }

    @Column(order = 587, length = 13)
    private BizNumber iwsMaitositumitatekin3x89;

    public BizNumber getIwsMaitositumitatekin3x89() {
        return iwsMaitositumitatekin3x89;
    }

    public void setIwsMaitositumitatekin3x89(BizNumber pIwsMaitositumitatekin3x89) {
        iwsMaitositumitatekin3x89 = pIwsMaitositumitatekin3x89;
    }

    @Column(order = 588, length = 13)
    private BizNumber iwsMaitositumitatekin3x90;

    public BizNumber getIwsMaitositumitatekin3x90() {
        return iwsMaitositumitatekin3x90;
    }

    public void setIwsMaitositumitatekin3x90(BizNumber pIwsMaitositumitatekin3x90) {
        iwsMaitositumitatekin3x90 = pIwsMaitositumitatekin3x90;
    }

    @Column(order = 589, length = 13)
    private BizNumber iwsMaitositumitatekin3x91;

    public BizNumber getIwsMaitositumitatekin3x91() {
        return iwsMaitositumitatekin3x91;
    }

    public void setIwsMaitositumitatekin3x91(BizNumber pIwsMaitositumitatekin3x91) {
        iwsMaitositumitatekin3x91 = pIwsMaitositumitatekin3x91;
    }

    @Column(order = 590, length = 13)
    private BizNumber iwsMaitositumitatekin3x92;

    public BizNumber getIwsMaitositumitatekin3x92() {
        return iwsMaitositumitatekin3x92;
    }

    public void setIwsMaitositumitatekin3x92(BizNumber pIwsMaitositumitatekin3x92) {
        iwsMaitositumitatekin3x92 = pIwsMaitositumitatekin3x92;
    }

    @Column(order = 591, length = 13)
    private BizNumber iwsMaitositumitatekin3x93;

    public BizNumber getIwsMaitositumitatekin3x93() {
        return iwsMaitositumitatekin3x93;
    }

    public void setIwsMaitositumitatekin3x93(BizNumber pIwsMaitositumitatekin3x93) {
        iwsMaitositumitatekin3x93 = pIwsMaitositumitatekin3x93;
    }

    @Column(order = 592, length = 13)
    private BizNumber iwsMaitositumitatekin3x94;

    public BizNumber getIwsMaitositumitatekin3x94() {
        return iwsMaitositumitatekin3x94;
    }

    public void setIwsMaitositumitatekin3x94(BizNumber pIwsMaitositumitatekin3x94) {
        iwsMaitositumitatekin3x94 = pIwsMaitositumitatekin3x94;
    }

    @Column(order = 593, length = 13)
    private BizNumber iwsMaitositumitatekin3x95;

    public BizNumber getIwsMaitositumitatekin3x95() {
        return iwsMaitositumitatekin3x95;
    }

    public void setIwsMaitositumitatekin3x95(BizNumber pIwsMaitositumitatekin3x95) {
        iwsMaitositumitatekin3x95 = pIwsMaitositumitatekin3x95;
    }

    @Column(order = 594, length = 13)
    private BizNumber iwsMaitositumitatekin3x96;

    public BizNumber getIwsMaitositumitatekin3x96() {
        return iwsMaitositumitatekin3x96;
    }

    public void setIwsMaitositumitatekin3x96(BizNumber pIwsMaitositumitatekin3x96) {
        iwsMaitositumitatekin3x96 = pIwsMaitositumitatekin3x96;
    }

    @Column(order = 595, length = 13)
    private BizNumber iwsMaitositumitatekin3x97;

    public BizNumber getIwsMaitositumitatekin3x97() {
        return iwsMaitositumitatekin3x97;
    }

    public void setIwsMaitositumitatekin3x97(BizNumber pIwsMaitositumitatekin3x97) {
        iwsMaitositumitatekin3x97 = pIwsMaitositumitatekin3x97;
    }

    @Column(order = 596, length = 13)
    private BizNumber iwsMaitositumitatekin3x98;

    public BizNumber getIwsMaitositumitatekin3x98() {
        return iwsMaitositumitatekin3x98;
    }

    public void setIwsMaitositumitatekin3x98(BizNumber pIwsMaitositumitatekin3x98) {
        iwsMaitositumitatekin3x98 = pIwsMaitositumitatekin3x98;
    }

    @Column(order = 597, length = 13)
    private BizNumber iwsMaitositumitatekin3x99;

    public BizNumber getIwsMaitositumitatekin3x99() {
        return iwsMaitositumitatekin3x99;
    }

    public void setIwsMaitositumitatekin3x99(BizNumber pIwsMaitositumitatekin3x99) {
        iwsMaitositumitatekin3x99 = pIwsMaitositumitatekin3x99;
    }

    @Column(order = 598, length = 13)
    private BizNumber iwsMvatkykknmnryutykgw;

    public BizNumber getIwsMvatkykknmnryutykgw() {
        return iwsMvatkykknmnryutykgw;
    }

    public void setIwsMvatkykknmnryutykgw(BizNumber pIwsMvatkykknmnryutykgw) {
        iwsMvatkykknmnryutykgw = pIwsMvatkykknmnryutykgw;
    }

    @Column(order = 599, length = 13)
    private BizNumber iwsMvatkykknmnryutykgv;

    public BizNumber getIwsMvatkykknmnryutykgv() {
        return iwsMvatkykknmnryutykgv;
    }

    public void setIwsMvatkykknmnryutykgv(BizNumber pIwsMvatkykknmnryutykgv) {
        iwsMvatkykknmnryutykgv = pIwsMvatkykknmnryutykgv;
    }

    @Column(order = 600, length = 1)
    private C_HugouKbn iwsKykjsjkkktyusirrtfgukbn1;

    public C_HugouKbn getIwsKykjsjkkktyusirrtfgukbn1() {
        return iwsKykjsjkkktyusirrtfgukbn1;
    }

    public void setIwsKykjsjkkktyusirrtfgukbn1(C_HugouKbn pIwsKykjsjkkktyusirrtfgukbn1) {
        iwsKykjsjkkktyusirrtfgukbn1 = pIwsKykjsjkkktyusirrtfgukbn1;
    }

    @Column(order = 601, length = 4)
    private BizNumber iwsKykjsjkkktyusirrt1;

    public BizNumber getIwsKykjsjkkktyusirrt1() {
        return iwsKykjsjkkktyusirrt1;
    }

    public void setIwsKykjsjkkktyusirrt1(BizNumber pIwsKykjsjkkktyusirrt1) {
        iwsKykjsjkkktyusirrt1 = pIwsKykjsjkkktyusirrt1;
    }

    @Column(order = 602, length = 1)
    private C_HugouKbn iwsKykjsjkkktyusirrtfgukbn2;

    public C_HugouKbn getIwsKykjsjkkktyusirrtfgukbn2() {
        return iwsKykjsjkkktyusirrtfgukbn2;
    }

    public void setIwsKykjsjkkktyusirrtfgukbn2(C_HugouKbn pIwsKykjsjkkktyusirrtfgukbn2) {
        iwsKykjsjkkktyusirrtfgukbn2 = pIwsKykjsjkkktyusirrtfgukbn2;
    }

    @Column(order = 603, length = 4)
    private BizNumber iwsKykjsjkkktyusirrt2;

    public BizNumber getIwsKykjsjkkktyusirrt2() {
        return iwsKykjsjkkktyusirrt2;
    }

    public void setIwsKykjsjkkktyusirrt2(BizNumber pIwsKykjsjkkktyusirrt2) {
        iwsKykjsjkkktyusirrt2 = pIwsKykjsjkkktyusirrt2;
    }

    @Column(order = 604, length = 1)
    private C_HugouKbn iwsKykjsjkkktyusirrtfgukbn3;

    public C_HugouKbn getIwsKykjsjkkktyusirrtfgukbn3() {
        return iwsKykjsjkkktyusirrtfgukbn3;
    }

    public void setIwsKykjsjkkktyusirrtfgukbn3(C_HugouKbn pIwsKykjsjkkktyusirrtfgukbn3) {
        iwsKykjsjkkktyusirrtfgukbn3 = pIwsKykjsjkkktyusirrtfgukbn3;
    }

    @Column(order = 605, length = 4)
    private BizNumber iwsKykjsjkkktyusirrt3;

    public BizNumber getIwsKykjsjkkktyusirrt3() {
        return iwsKykjsjkkktyusirrt3;
    }

    public void setIwsKykjsjkkktyusirrt3(BizNumber pIwsKykjsjkkktyusirrt3) {
        iwsKykjsjkkktyusirrt3 = pIwsKykjsjkkktyusirrt3;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
