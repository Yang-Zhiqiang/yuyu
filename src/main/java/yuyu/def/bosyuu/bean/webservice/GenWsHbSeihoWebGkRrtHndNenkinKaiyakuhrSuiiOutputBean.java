package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保険募集）生保Ｗｅｂ外貨利率変動年金用解約返戻金推移表作成出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebGkRrtHndNenkinKaiyakuhrSuiiOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebGkRrtHndNenkinKaiyakuhrSuiiOutputBean() {
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

    @Column(order = 4, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x1;

    public BizNumber getIwsMaitosiyentkprkgk1x1() {
        return iwsMaitosiyentkprkgk1x1;
    }

    public void setIwsMaitosiyentkprkgk1x1(BizNumber pIwsMaitosiyentkprkgk1x1) {
        iwsMaitosiyentkprkgk1x1 = pIwsMaitosiyentkprkgk1x1;
    }

    @Column(order = 5, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x2;

    public BizNumber getIwsMaitosiyentkprkgk1x2() {
        return iwsMaitosiyentkprkgk1x2;
    }

    public void setIwsMaitosiyentkprkgk1x2(BizNumber pIwsMaitosiyentkprkgk1x2) {
        iwsMaitosiyentkprkgk1x2 = pIwsMaitosiyentkprkgk1x2;
    }

    @Column(order = 6, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x3;

    public BizNumber getIwsMaitosiyentkprkgk1x3() {
        return iwsMaitosiyentkprkgk1x3;
    }

    public void setIwsMaitosiyentkprkgk1x3(BizNumber pIwsMaitosiyentkprkgk1x3) {
        iwsMaitosiyentkprkgk1x3 = pIwsMaitosiyentkprkgk1x3;
    }

    @Column(order = 7, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x4;

    public BizNumber getIwsMaitosiyentkprkgk1x4() {
        return iwsMaitosiyentkprkgk1x4;
    }

    public void setIwsMaitosiyentkprkgk1x4(BizNumber pIwsMaitosiyentkprkgk1x4) {
        iwsMaitosiyentkprkgk1x4 = pIwsMaitosiyentkprkgk1x4;
    }

    @Column(order = 8, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x5;

    public BizNumber getIwsMaitosiyentkprkgk1x5() {
        return iwsMaitosiyentkprkgk1x5;
    }

    public void setIwsMaitosiyentkprkgk1x5(BizNumber pIwsMaitosiyentkprkgk1x5) {
        iwsMaitosiyentkprkgk1x5 = pIwsMaitosiyentkprkgk1x5;
    }

    @Column(order = 9, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x6;

    public BizNumber getIwsMaitosiyentkprkgk1x6() {
        return iwsMaitosiyentkprkgk1x6;
    }

    public void setIwsMaitosiyentkprkgk1x6(BizNumber pIwsMaitosiyentkprkgk1x6) {
        iwsMaitosiyentkprkgk1x6 = pIwsMaitosiyentkprkgk1x6;
    }

    @Column(order = 10, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x7;

    public BizNumber getIwsMaitosiyentkprkgk1x7() {
        return iwsMaitosiyentkprkgk1x7;
    }

    public void setIwsMaitosiyentkprkgk1x7(BizNumber pIwsMaitosiyentkprkgk1x7) {
        iwsMaitosiyentkprkgk1x7 = pIwsMaitosiyentkprkgk1x7;
    }

    @Column(order = 11, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x8;

    public BizNumber getIwsMaitosiyentkprkgk1x8() {
        return iwsMaitosiyentkprkgk1x8;
    }

    public void setIwsMaitosiyentkprkgk1x8(BizNumber pIwsMaitosiyentkprkgk1x8) {
        iwsMaitosiyentkprkgk1x8 = pIwsMaitosiyentkprkgk1x8;
    }

    @Column(order = 12, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x9;

    public BizNumber getIwsMaitosiyentkprkgk1x9() {
        return iwsMaitosiyentkprkgk1x9;
    }

    public void setIwsMaitosiyentkprkgk1x9(BizNumber pIwsMaitosiyentkprkgk1x9) {
        iwsMaitosiyentkprkgk1x9 = pIwsMaitosiyentkprkgk1x9;
    }

    @Column(order = 13, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x10;

    public BizNumber getIwsMaitosiyentkprkgk1x10() {
        return iwsMaitosiyentkprkgk1x10;
    }

    public void setIwsMaitosiyentkprkgk1x10(BizNumber pIwsMaitosiyentkprkgk1x10) {
        iwsMaitosiyentkprkgk1x10 = pIwsMaitosiyentkprkgk1x10;
    }

    @Column(order = 14, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x11;

    public BizNumber getIwsMaitosiyentkprkgk1x11() {
        return iwsMaitosiyentkprkgk1x11;
    }

    public void setIwsMaitosiyentkprkgk1x11(BizNumber pIwsMaitosiyentkprkgk1x11) {
        iwsMaitosiyentkprkgk1x11 = pIwsMaitosiyentkprkgk1x11;
    }

    @Column(order = 15, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x12;

    public BizNumber getIwsMaitosiyentkprkgk1x12() {
        return iwsMaitosiyentkprkgk1x12;
    }

    public void setIwsMaitosiyentkprkgk1x12(BizNumber pIwsMaitosiyentkprkgk1x12) {
        iwsMaitosiyentkprkgk1x12 = pIwsMaitosiyentkprkgk1x12;
    }

    @Column(order = 16, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x13;

    public BizNumber getIwsMaitosiyentkprkgk1x13() {
        return iwsMaitosiyentkprkgk1x13;
    }

    public void setIwsMaitosiyentkprkgk1x13(BizNumber pIwsMaitosiyentkprkgk1x13) {
        iwsMaitosiyentkprkgk1x13 = pIwsMaitosiyentkprkgk1x13;
    }

    @Column(order = 17, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x14;

    public BizNumber getIwsMaitosiyentkprkgk1x14() {
        return iwsMaitosiyentkprkgk1x14;
    }

    public void setIwsMaitosiyentkprkgk1x14(BizNumber pIwsMaitosiyentkprkgk1x14) {
        iwsMaitosiyentkprkgk1x14 = pIwsMaitosiyentkprkgk1x14;
    }

    @Column(order = 18, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x15;

    public BizNumber getIwsMaitosiyentkprkgk1x15() {
        return iwsMaitosiyentkprkgk1x15;
    }

    public void setIwsMaitosiyentkprkgk1x15(BizNumber pIwsMaitosiyentkprkgk1x15) {
        iwsMaitosiyentkprkgk1x15 = pIwsMaitosiyentkprkgk1x15;
    }

    @Column(order = 19, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x16;

    public BizNumber getIwsMaitosiyentkprkgk1x16() {
        return iwsMaitosiyentkprkgk1x16;
    }

    public void setIwsMaitosiyentkprkgk1x16(BizNumber pIwsMaitosiyentkprkgk1x16) {
        iwsMaitosiyentkprkgk1x16 = pIwsMaitosiyentkprkgk1x16;
    }

    @Column(order = 20, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x17;

    public BizNumber getIwsMaitosiyentkprkgk1x17() {
        return iwsMaitosiyentkprkgk1x17;
    }

    public void setIwsMaitosiyentkprkgk1x17(BizNumber pIwsMaitosiyentkprkgk1x17) {
        iwsMaitosiyentkprkgk1x17 = pIwsMaitosiyentkprkgk1x17;
    }

    @Column(order = 21, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x18;

    public BizNumber getIwsMaitosiyentkprkgk1x18() {
        return iwsMaitosiyentkprkgk1x18;
    }

    public void setIwsMaitosiyentkprkgk1x18(BizNumber pIwsMaitosiyentkprkgk1x18) {
        iwsMaitosiyentkprkgk1x18 = pIwsMaitosiyentkprkgk1x18;
    }

    @Column(order = 22, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x19;

    public BizNumber getIwsMaitosiyentkprkgk1x19() {
        return iwsMaitosiyentkprkgk1x19;
    }

    public void setIwsMaitosiyentkprkgk1x19(BizNumber pIwsMaitosiyentkprkgk1x19) {
        iwsMaitosiyentkprkgk1x19 = pIwsMaitosiyentkprkgk1x19;
    }

    @Column(order = 23, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x20;

    public BizNumber getIwsMaitosiyentkprkgk1x20() {
        return iwsMaitosiyentkprkgk1x20;
    }

    public void setIwsMaitosiyentkprkgk1x20(BizNumber pIwsMaitosiyentkprkgk1x20) {
        iwsMaitosiyentkprkgk1x20 = pIwsMaitosiyentkprkgk1x20;
    }

    @Column(order = 24, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x21;

    public BizNumber getIwsMaitosiyentkprkgk1x21() {
        return iwsMaitosiyentkprkgk1x21;
    }

    public void setIwsMaitosiyentkprkgk1x21(BizNumber pIwsMaitosiyentkprkgk1x21) {
        iwsMaitosiyentkprkgk1x21 = pIwsMaitosiyentkprkgk1x21;
    }

    @Column(order = 25, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x22;

    public BizNumber getIwsMaitosiyentkprkgk1x22() {
        return iwsMaitosiyentkprkgk1x22;
    }

    public void setIwsMaitosiyentkprkgk1x22(BizNumber pIwsMaitosiyentkprkgk1x22) {
        iwsMaitosiyentkprkgk1x22 = pIwsMaitosiyentkprkgk1x22;
    }

    @Column(order = 26, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x23;

    public BizNumber getIwsMaitosiyentkprkgk1x23() {
        return iwsMaitosiyentkprkgk1x23;
    }

    public void setIwsMaitosiyentkprkgk1x23(BizNumber pIwsMaitosiyentkprkgk1x23) {
        iwsMaitosiyentkprkgk1x23 = pIwsMaitosiyentkprkgk1x23;
    }

    @Column(order = 27, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x24;

    public BizNumber getIwsMaitosiyentkprkgk1x24() {
        return iwsMaitosiyentkprkgk1x24;
    }

    public void setIwsMaitosiyentkprkgk1x24(BizNumber pIwsMaitosiyentkprkgk1x24) {
        iwsMaitosiyentkprkgk1x24 = pIwsMaitosiyentkprkgk1x24;
    }

    @Column(order = 28, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x25;

    public BizNumber getIwsMaitosiyentkprkgk1x25() {
        return iwsMaitosiyentkprkgk1x25;
    }

    public void setIwsMaitosiyentkprkgk1x25(BizNumber pIwsMaitosiyentkprkgk1x25) {
        iwsMaitosiyentkprkgk1x25 = pIwsMaitosiyentkprkgk1x25;
    }

    @Column(order = 29, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x26;

    public BizNumber getIwsMaitosiyentkprkgk1x26() {
        return iwsMaitosiyentkprkgk1x26;
    }

    public void setIwsMaitosiyentkprkgk1x26(BizNumber pIwsMaitosiyentkprkgk1x26) {
        iwsMaitosiyentkprkgk1x26 = pIwsMaitosiyentkprkgk1x26;
    }

    @Column(order = 30, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x27;

    public BizNumber getIwsMaitosiyentkprkgk1x27() {
        return iwsMaitosiyentkprkgk1x27;
    }

    public void setIwsMaitosiyentkprkgk1x27(BizNumber pIwsMaitosiyentkprkgk1x27) {
        iwsMaitosiyentkprkgk1x27 = pIwsMaitosiyentkprkgk1x27;
    }

    @Column(order = 31, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x28;

    public BizNumber getIwsMaitosiyentkprkgk1x28() {
        return iwsMaitosiyentkprkgk1x28;
    }

    public void setIwsMaitosiyentkprkgk1x28(BizNumber pIwsMaitosiyentkprkgk1x28) {
        iwsMaitosiyentkprkgk1x28 = pIwsMaitosiyentkprkgk1x28;
    }

    @Column(order = 32, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x29;

    public BizNumber getIwsMaitosiyentkprkgk1x29() {
        return iwsMaitosiyentkprkgk1x29;
    }

    public void setIwsMaitosiyentkprkgk1x29(BizNumber pIwsMaitosiyentkprkgk1x29) {
        iwsMaitosiyentkprkgk1x29 = pIwsMaitosiyentkprkgk1x29;
    }

    @Column(order = 33, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x30;

    public BizNumber getIwsMaitosiyentkprkgk1x30() {
        return iwsMaitosiyentkprkgk1x30;
    }

    public void setIwsMaitosiyentkprkgk1x30(BizNumber pIwsMaitosiyentkprkgk1x30) {
        iwsMaitosiyentkprkgk1x30 = pIwsMaitosiyentkprkgk1x30;
    }

    @Column(order = 34, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x31;

    public BizNumber getIwsMaitosiyentkprkgk1x31() {
        return iwsMaitosiyentkprkgk1x31;
    }

    public void setIwsMaitosiyentkprkgk1x31(BizNumber pIwsMaitosiyentkprkgk1x31) {
        iwsMaitosiyentkprkgk1x31 = pIwsMaitosiyentkprkgk1x31;
    }

    @Column(order = 35, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x32;

    public BizNumber getIwsMaitosiyentkprkgk1x32() {
        return iwsMaitosiyentkprkgk1x32;
    }

    public void setIwsMaitosiyentkprkgk1x32(BizNumber pIwsMaitosiyentkprkgk1x32) {
        iwsMaitosiyentkprkgk1x32 = pIwsMaitosiyentkprkgk1x32;
    }

    @Column(order = 36, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x33;

    public BizNumber getIwsMaitosiyentkprkgk1x33() {
        return iwsMaitosiyentkprkgk1x33;
    }

    public void setIwsMaitosiyentkprkgk1x33(BizNumber pIwsMaitosiyentkprkgk1x33) {
        iwsMaitosiyentkprkgk1x33 = pIwsMaitosiyentkprkgk1x33;
    }

    @Column(order = 37, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x34;

    public BizNumber getIwsMaitosiyentkprkgk1x34() {
        return iwsMaitosiyentkprkgk1x34;
    }

    public void setIwsMaitosiyentkprkgk1x34(BizNumber pIwsMaitosiyentkprkgk1x34) {
        iwsMaitosiyentkprkgk1x34 = pIwsMaitosiyentkprkgk1x34;
    }

    @Column(order = 38, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x35;

    public BizNumber getIwsMaitosiyentkprkgk1x35() {
        return iwsMaitosiyentkprkgk1x35;
    }

    public void setIwsMaitosiyentkprkgk1x35(BizNumber pIwsMaitosiyentkprkgk1x35) {
        iwsMaitosiyentkprkgk1x35 = pIwsMaitosiyentkprkgk1x35;
    }

    @Column(order = 39, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x36;

    public BizNumber getIwsMaitosiyentkprkgk1x36() {
        return iwsMaitosiyentkprkgk1x36;
    }

    public void setIwsMaitosiyentkprkgk1x36(BizNumber pIwsMaitosiyentkprkgk1x36) {
        iwsMaitosiyentkprkgk1x36 = pIwsMaitosiyentkprkgk1x36;
    }

    @Column(order = 40, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x37;

    public BizNumber getIwsMaitosiyentkprkgk1x37() {
        return iwsMaitosiyentkprkgk1x37;
    }

    public void setIwsMaitosiyentkprkgk1x37(BizNumber pIwsMaitosiyentkprkgk1x37) {
        iwsMaitosiyentkprkgk1x37 = pIwsMaitosiyentkprkgk1x37;
    }

    @Column(order = 41, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x38;

    public BizNumber getIwsMaitosiyentkprkgk1x38() {
        return iwsMaitosiyentkprkgk1x38;
    }

    public void setIwsMaitosiyentkprkgk1x38(BizNumber pIwsMaitosiyentkprkgk1x38) {
        iwsMaitosiyentkprkgk1x38 = pIwsMaitosiyentkprkgk1x38;
    }

    @Column(order = 42, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x39;

    public BizNumber getIwsMaitosiyentkprkgk1x39() {
        return iwsMaitosiyentkprkgk1x39;
    }

    public void setIwsMaitosiyentkprkgk1x39(BizNumber pIwsMaitosiyentkprkgk1x39) {
        iwsMaitosiyentkprkgk1x39 = pIwsMaitosiyentkprkgk1x39;
    }

    @Column(order = 43, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x40;

    public BizNumber getIwsMaitosiyentkprkgk1x40() {
        return iwsMaitosiyentkprkgk1x40;
    }

    public void setIwsMaitosiyentkprkgk1x40(BizNumber pIwsMaitosiyentkprkgk1x40) {
        iwsMaitosiyentkprkgk1x40 = pIwsMaitosiyentkprkgk1x40;
    }

    @Column(order = 44, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x41;

    public BizNumber getIwsMaitosiyentkprkgk1x41() {
        return iwsMaitosiyentkprkgk1x41;
    }

    public void setIwsMaitosiyentkprkgk1x41(BizNumber pIwsMaitosiyentkprkgk1x41) {
        iwsMaitosiyentkprkgk1x41 = pIwsMaitosiyentkprkgk1x41;
    }

    @Column(order = 45, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x42;

    public BizNumber getIwsMaitosiyentkprkgk1x42() {
        return iwsMaitosiyentkprkgk1x42;
    }

    public void setIwsMaitosiyentkprkgk1x42(BizNumber pIwsMaitosiyentkprkgk1x42) {
        iwsMaitosiyentkprkgk1x42 = pIwsMaitosiyentkprkgk1x42;
    }

    @Column(order = 46, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x43;

    public BizNumber getIwsMaitosiyentkprkgk1x43() {
        return iwsMaitosiyentkprkgk1x43;
    }

    public void setIwsMaitosiyentkprkgk1x43(BizNumber pIwsMaitosiyentkprkgk1x43) {
        iwsMaitosiyentkprkgk1x43 = pIwsMaitosiyentkprkgk1x43;
    }

    @Column(order = 47, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x44;

    public BizNumber getIwsMaitosiyentkprkgk1x44() {
        return iwsMaitosiyentkprkgk1x44;
    }

    public void setIwsMaitosiyentkprkgk1x44(BizNumber pIwsMaitosiyentkprkgk1x44) {
        iwsMaitosiyentkprkgk1x44 = pIwsMaitosiyentkprkgk1x44;
    }

    @Column(order = 48, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x45;

    public BizNumber getIwsMaitosiyentkprkgk1x45() {
        return iwsMaitosiyentkprkgk1x45;
    }

    public void setIwsMaitosiyentkprkgk1x45(BizNumber pIwsMaitosiyentkprkgk1x45) {
        iwsMaitosiyentkprkgk1x45 = pIwsMaitosiyentkprkgk1x45;
    }

    @Column(order = 49, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x46;

    public BizNumber getIwsMaitosiyentkprkgk1x46() {
        return iwsMaitosiyentkprkgk1x46;
    }

    public void setIwsMaitosiyentkprkgk1x46(BizNumber pIwsMaitosiyentkprkgk1x46) {
        iwsMaitosiyentkprkgk1x46 = pIwsMaitosiyentkprkgk1x46;
    }

    @Column(order = 50, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x47;

    public BizNumber getIwsMaitosiyentkprkgk1x47() {
        return iwsMaitosiyentkprkgk1x47;
    }

    public void setIwsMaitosiyentkprkgk1x47(BizNumber pIwsMaitosiyentkprkgk1x47) {
        iwsMaitosiyentkprkgk1x47 = pIwsMaitosiyentkprkgk1x47;
    }

    @Column(order = 51, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x48;

    public BizNumber getIwsMaitosiyentkprkgk1x48() {
        return iwsMaitosiyentkprkgk1x48;
    }

    public void setIwsMaitosiyentkprkgk1x48(BizNumber pIwsMaitosiyentkprkgk1x48) {
        iwsMaitosiyentkprkgk1x48 = pIwsMaitosiyentkprkgk1x48;
    }

    @Column(order = 52, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x49;

    public BizNumber getIwsMaitosiyentkprkgk1x49() {
        return iwsMaitosiyentkprkgk1x49;
    }

    public void setIwsMaitosiyentkprkgk1x49(BizNumber pIwsMaitosiyentkprkgk1x49) {
        iwsMaitosiyentkprkgk1x49 = pIwsMaitosiyentkprkgk1x49;
    }

    @Column(order = 53, length = 10)
    private BizNumber iwsMaitosiyentkprkgk1x50;

    public BizNumber getIwsMaitosiyentkprkgk1x50() {
        return iwsMaitosiyentkprkgk1x50;
    }

    public void setIwsMaitosiyentkprkgk1x50(BizNumber pIwsMaitosiyentkprkgk1x50) {
        iwsMaitosiyentkprkgk1x50 = pIwsMaitosiyentkprkgk1x50;
    }

    @Column(order = 54, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x1;

    public BizNumber getIwsMaitosigaikatkprkgk1x1() {
        return iwsMaitosigaikatkprkgk1x1;
    }

    public void setIwsMaitosigaikatkprkgk1x1(BizNumber pIwsMaitosigaikatkprkgk1x1) {
        iwsMaitosigaikatkprkgk1x1 = pIwsMaitosigaikatkprkgk1x1;
    }

    @Column(order = 55, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x2;

    public BizNumber getIwsMaitosigaikatkprkgk1x2() {
        return iwsMaitosigaikatkprkgk1x2;
    }

    public void setIwsMaitosigaikatkprkgk1x2(BizNumber pIwsMaitosigaikatkprkgk1x2) {
        iwsMaitosigaikatkprkgk1x2 = pIwsMaitosigaikatkprkgk1x2;
    }

    @Column(order = 56, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x3;

    public BizNumber getIwsMaitosigaikatkprkgk1x3() {
        return iwsMaitosigaikatkprkgk1x3;
    }

    public void setIwsMaitosigaikatkprkgk1x3(BizNumber pIwsMaitosigaikatkprkgk1x3) {
        iwsMaitosigaikatkprkgk1x3 = pIwsMaitosigaikatkprkgk1x3;
    }

    @Column(order = 57, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x4;

    public BizNumber getIwsMaitosigaikatkprkgk1x4() {
        return iwsMaitosigaikatkprkgk1x4;
    }

    public void setIwsMaitosigaikatkprkgk1x4(BizNumber pIwsMaitosigaikatkprkgk1x4) {
        iwsMaitosigaikatkprkgk1x4 = pIwsMaitosigaikatkprkgk1x4;
    }

    @Column(order = 58, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x5;

    public BizNumber getIwsMaitosigaikatkprkgk1x5() {
        return iwsMaitosigaikatkprkgk1x5;
    }

    public void setIwsMaitosigaikatkprkgk1x5(BizNumber pIwsMaitosigaikatkprkgk1x5) {
        iwsMaitosigaikatkprkgk1x5 = pIwsMaitosigaikatkprkgk1x5;
    }

    @Column(order = 59, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x6;

    public BizNumber getIwsMaitosigaikatkprkgk1x6() {
        return iwsMaitosigaikatkprkgk1x6;
    }

    public void setIwsMaitosigaikatkprkgk1x6(BizNumber pIwsMaitosigaikatkprkgk1x6) {
        iwsMaitosigaikatkprkgk1x6 = pIwsMaitosigaikatkprkgk1x6;
    }

    @Column(order = 60, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x7;

    public BizNumber getIwsMaitosigaikatkprkgk1x7() {
        return iwsMaitosigaikatkprkgk1x7;
    }

    public void setIwsMaitosigaikatkprkgk1x7(BizNumber pIwsMaitosigaikatkprkgk1x7) {
        iwsMaitosigaikatkprkgk1x7 = pIwsMaitosigaikatkprkgk1x7;
    }

    @Column(order = 61, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x8;

    public BizNumber getIwsMaitosigaikatkprkgk1x8() {
        return iwsMaitosigaikatkprkgk1x8;
    }

    public void setIwsMaitosigaikatkprkgk1x8(BizNumber pIwsMaitosigaikatkprkgk1x8) {
        iwsMaitosigaikatkprkgk1x8 = pIwsMaitosigaikatkprkgk1x8;
    }

    @Column(order = 62, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x9;

    public BizNumber getIwsMaitosigaikatkprkgk1x9() {
        return iwsMaitosigaikatkprkgk1x9;
    }

    public void setIwsMaitosigaikatkprkgk1x9(BizNumber pIwsMaitosigaikatkprkgk1x9) {
        iwsMaitosigaikatkprkgk1x9 = pIwsMaitosigaikatkprkgk1x9;
    }

    @Column(order = 63, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x10;

    public BizNumber getIwsMaitosigaikatkprkgk1x10() {
        return iwsMaitosigaikatkprkgk1x10;
    }

    public void setIwsMaitosigaikatkprkgk1x10(BizNumber pIwsMaitosigaikatkprkgk1x10) {
        iwsMaitosigaikatkprkgk1x10 = pIwsMaitosigaikatkprkgk1x10;
    }

    @Column(order = 64, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x11;

    public BizNumber getIwsMaitosigaikatkprkgk1x11() {
        return iwsMaitosigaikatkprkgk1x11;
    }

    public void setIwsMaitosigaikatkprkgk1x11(BizNumber pIwsMaitosigaikatkprkgk1x11) {
        iwsMaitosigaikatkprkgk1x11 = pIwsMaitosigaikatkprkgk1x11;
    }

    @Column(order = 65, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x12;

    public BizNumber getIwsMaitosigaikatkprkgk1x12() {
        return iwsMaitosigaikatkprkgk1x12;
    }

    public void setIwsMaitosigaikatkprkgk1x12(BizNumber pIwsMaitosigaikatkprkgk1x12) {
        iwsMaitosigaikatkprkgk1x12 = pIwsMaitosigaikatkprkgk1x12;
    }

    @Column(order = 66, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x13;

    public BizNumber getIwsMaitosigaikatkprkgk1x13() {
        return iwsMaitosigaikatkprkgk1x13;
    }

    public void setIwsMaitosigaikatkprkgk1x13(BizNumber pIwsMaitosigaikatkprkgk1x13) {
        iwsMaitosigaikatkprkgk1x13 = pIwsMaitosigaikatkprkgk1x13;
    }

    @Column(order = 67, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x14;

    public BizNumber getIwsMaitosigaikatkprkgk1x14() {
        return iwsMaitosigaikatkprkgk1x14;
    }

    public void setIwsMaitosigaikatkprkgk1x14(BizNumber pIwsMaitosigaikatkprkgk1x14) {
        iwsMaitosigaikatkprkgk1x14 = pIwsMaitosigaikatkprkgk1x14;
    }

    @Column(order = 68, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x15;

    public BizNumber getIwsMaitosigaikatkprkgk1x15() {
        return iwsMaitosigaikatkprkgk1x15;
    }

    public void setIwsMaitosigaikatkprkgk1x15(BizNumber pIwsMaitosigaikatkprkgk1x15) {
        iwsMaitosigaikatkprkgk1x15 = pIwsMaitosigaikatkprkgk1x15;
    }

    @Column(order = 69, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x16;

    public BizNumber getIwsMaitosigaikatkprkgk1x16() {
        return iwsMaitosigaikatkprkgk1x16;
    }

    public void setIwsMaitosigaikatkprkgk1x16(BizNumber pIwsMaitosigaikatkprkgk1x16) {
        iwsMaitosigaikatkprkgk1x16 = pIwsMaitosigaikatkprkgk1x16;
    }

    @Column(order = 70, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x17;

    public BizNumber getIwsMaitosigaikatkprkgk1x17() {
        return iwsMaitosigaikatkprkgk1x17;
    }

    public void setIwsMaitosigaikatkprkgk1x17(BizNumber pIwsMaitosigaikatkprkgk1x17) {
        iwsMaitosigaikatkprkgk1x17 = pIwsMaitosigaikatkprkgk1x17;
    }

    @Column(order = 71, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x18;

    public BizNumber getIwsMaitosigaikatkprkgk1x18() {
        return iwsMaitosigaikatkprkgk1x18;
    }

    public void setIwsMaitosigaikatkprkgk1x18(BizNumber pIwsMaitosigaikatkprkgk1x18) {
        iwsMaitosigaikatkprkgk1x18 = pIwsMaitosigaikatkprkgk1x18;
    }

    @Column(order = 72, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x19;

    public BizNumber getIwsMaitosigaikatkprkgk1x19() {
        return iwsMaitosigaikatkprkgk1x19;
    }

    public void setIwsMaitosigaikatkprkgk1x19(BizNumber pIwsMaitosigaikatkprkgk1x19) {
        iwsMaitosigaikatkprkgk1x19 = pIwsMaitosigaikatkprkgk1x19;
    }

    @Column(order = 73, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x20;

    public BizNumber getIwsMaitosigaikatkprkgk1x20() {
        return iwsMaitosigaikatkprkgk1x20;
    }

    public void setIwsMaitosigaikatkprkgk1x20(BizNumber pIwsMaitosigaikatkprkgk1x20) {
        iwsMaitosigaikatkprkgk1x20 = pIwsMaitosigaikatkprkgk1x20;
    }

    @Column(order = 74, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x21;

    public BizNumber getIwsMaitosigaikatkprkgk1x21() {
        return iwsMaitosigaikatkprkgk1x21;
    }

    public void setIwsMaitosigaikatkprkgk1x21(BizNumber pIwsMaitosigaikatkprkgk1x21) {
        iwsMaitosigaikatkprkgk1x21 = pIwsMaitosigaikatkprkgk1x21;
    }

    @Column(order = 75, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x22;

    public BizNumber getIwsMaitosigaikatkprkgk1x22() {
        return iwsMaitosigaikatkprkgk1x22;
    }

    public void setIwsMaitosigaikatkprkgk1x22(BizNumber pIwsMaitosigaikatkprkgk1x22) {
        iwsMaitosigaikatkprkgk1x22 = pIwsMaitosigaikatkprkgk1x22;
    }

    @Column(order = 76, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x23;

    public BizNumber getIwsMaitosigaikatkprkgk1x23() {
        return iwsMaitosigaikatkprkgk1x23;
    }

    public void setIwsMaitosigaikatkprkgk1x23(BizNumber pIwsMaitosigaikatkprkgk1x23) {
        iwsMaitosigaikatkprkgk1x23 = pIwsMaitosigaikatkprkgk1x23;
    }

    @Column(order = 77, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x24;

    public BizNumber getIwsMaitosigaikatkprkgk1x24() {
        return iwsMaitosigaikatkprkgk1x24;
    }

    public void setIwsMaitosigaikatkprkgk1x24(BizNumber pIwsMaitosigaikatkprkgk1x24) {
        iwsMaitosigaikatkprkgk1x24 = pIwsMaitosigaikatkprkgk1x24;
    }

    @Column(order = 78, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x25;

    public BizNumber getIwsMaitosigaikatkprkgk1x25() {
        return iwsMaitosigaikatkprkgk1x25;
    }

    public void setIwsMaitosigaikatkprkgk1x25(BizNumber pIwsMaitosigaikatkprkgk1x25) {
        iwsMaitosigaikatkprkgk1x25 = pIwsMaitosigaikatkprkgk1x25;
    }

    @Column(order = 79, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x26;

    public BizNumber getIwsMaitosigaikatkprkgk1x26() {
        return iwsMaitosigaikatkprkgk1x26;
    }

    public void setIwsMaitosigaikatkprkgk1x26(BizNumber pIwsMaitosigaikatkprkgk1x26) {
        iwsMaitosigaikatkprkgk1x26 = pIwsMaitosigaikatkprkgk1x26;
    }

    @Column(order = 80, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x27;

    public BizNumber getIwsMaitosigaikatkprkgk1x27() {
        return iwsMaitosigaikatkprkgk1x27;
    }

    public void setIwsMaitosigaikatkprkgk1x27(BizNumber pIwsMaitosigaikatkprkgk1x27) {
        iwsMaitosigaikatkprkgk1x27 = pIwsMaitosigaikatkprkgk1x27;
    }

    @Column(order = 81, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x28;

    public BizNumber getIwsMaitosigaikatkprkgk1x28() {
        return iwsMaitosigaikatkprkgk1x28;
    }

    public void setIwsMaitosigaikatkprkgk1x28(BizNumber pIwsMaitosigaikatkprkgk1x28) {
        iwsMaitosigaikatkprkgk1x28 = pIwsMaitosigaikatkprkgk1x28;
    }

    @Column(order = 82, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x29;

    public BizNumber getIwsMaitosigaikatkprkgk1x29() {
        return iwsMaitosigaikatkprkgk1x29;
    }

    public void setIwsMaitosigaikatkprkgk1x29(BizNumber pIwsMaitosigaikatkprkgk1x29) {
        iwsMaitosigaikatkprkgk1x29 = pIwsMaitosigaikatkprkgk1x29;
    }

    @Column(order = 83, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x30;

    public BizNumber getIwsMaitosigaikatkprkgk1x30() {
        return iwsMaitosigaikatkprkgk1x30;
    }

    public void setIwsMaitosigaikatkprkgk1x30(BizNumber pIwsMaitosigaikatkprkgk1x30) {
        iwsMaitosigaikatkprkgk1x30 = pIwsMaitosigaikatkprkgk1x30;
    }

    @Column(order = 84, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x31;

    public BizNumber getIwsMaitosigaikatkprkgk1x31() {
        return iwsMaitosigaikatkprkgk1x31;
    }

    public void setIwsMaitosigaikatkprkgk1x31(BizNumber pIwsMaitosigaikatkprkgk1x31) {
        iwsMaitosigaikatkprkgk1x31 = pIwsMaitosigaikatkprkgk1x31;
    }

    @Column(order = 85, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x32;

    public BizNumber getIwsMaitosigaikatkprkgk1x32() {
        return iwsMaitosigaikatkprkgk1x32;
    }

    public void setIwsMaitosigaikatkprkgk1x32(BizNumber pIwsMaitosigaikatkprkgk1x32) {
        iwsMaitosigaikatkprkgk1x32 = pIwsMaitosigaikatkprkgk1x32;
    }

    @Column(order = 86, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x33;

    public BizNumber getIwsMaitosigaikatkprkgk1x33() {
        return iwsMaitosigaikatkprkgk1x33;
    }

    public void setIwsMaitosigaikatkprkgk1x33(BizNumber pIwsMaitosigaikatkprkgk1x33) {
        iwsMaitosigaikatkprkgk1x33 = pIwsMaitosigaikatkprkgk1x33;
    }

    @Column(order = 87, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x34;

    public BizNumber getIwsMaitosigaikatkprkgk1x34() {
        return iwsMaitosigaikatkprkgk1x34;
    }

    public void setIwsMaitosigaikatkprkgk1x34(BizNumber pIwsMaitosigaikatkprkgk1x34) {
        iwsMaitosigaikatkprkgk1x34 = pIwsMaitosigaikatkprkgk1x34;
    }

    @Column(order = 88, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x35;

    public BizNumber getIwsMaitosigaikatkprkgk1x35() {
        return iwsMaitosigaikatkprkgk1x35;
    }

    public void setIwsMaitosigaikatkprkgk1x35(BizNumber pIwsMaitosigaikatkprkgk1x35) {
        iwsMaitosigaikatkprkgk1x35 = pIwsMaitosigaikatkprkgk1x35;
    }

    @Column(order = 89, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x36;

    public BizNumber getIwsMaitosigaikatkprkgk1x36() {
        return iwsMaitosigaikatkprkgk1x36;
    }

    public void setIwsMaitosigaikatkprkgk1x36(BizNumber pIwsMaitosigaikatkprkgk1x36) {
        iwsMaitosigaikatkprkgk1x36 = pIwsMaitosigaikatkprkgk1x36;
    }

    @Column(order = 90, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x37;

    public BizNumber getIwsMaitosigaikatkprkgk1x37() {
        return iwsMaitosigaikatkprkgk1x37;
    }

    public void setIwsMaitosigaikatkprkgk1x37(BizNumber pIwsMaitosigaikatkprkgk1x37) {
        iwsMaitosigaikatkprkgk1x37 = pIwsMaitosigaikatkprkgk1x37;
    }

    @Column(order = 91, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x38;

    public BizNumber getIwsMaitosigaikatkprkgk1x38() {
        return iwsMaitosigaikatkprkgk1x38;
    }

    public void setIwsMaitosigaikatkprkgk1x38(BizNumber pIwsMaitosigaikatkprkgk1x38) {
        iwsMaitosigaikatkprkgk1x38 = pIwsMaitosigaikatkprkgk1x38;
    }

    @Column(order = 92, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x39;

    public BizNumber getIwsMaitosigaikatkprkgk1x39() {
        return iwsMaitosigaikatkprkgk1x39;
    }

    public void setIwsMaitosigaikatkprkgk1x39(BizNumber pIwsMaitosigaikatkprkgk1x39) {
        iwsMaitosigaikatkprkgk1x39 = pIwsMaitosigaikatkprkgk1x39;
    }

    @Column(order = 93, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x40;

    public BizNumber getIwsMaitosigaikatkprkgk1x40() {
        return iwsMaitosigaikatkprkgk1x40;
    }

    public void setIwsMaitosigaikatkprkgk1x40(BizNumber pIwsMaitosigaikatkprkgk1x40) {
        iwsMaitosigaikatkprkgk1x40 = pIwsMaitosigaikatkprkgk1x40;
    }

    @Column(order = 94, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x41;

    public BizNumber getIwsMaitosigaikatkprkgk1x41() {
        return iwsMaitosigaikatkprkgk1x41;
    }

    public void setIwsMaitosigaikatkprkgk1x41(BizNumber pIwsMaitosigaikatkprkgk1x41) {
        iwsMaitosigaikatkprkgk1x41 = pIwsMaitosigaikatkprkgk1x41;
    }

    @Column(order = 95, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x42;

    public BizNumber getIwsMaitosigaikatkprkgk1x42() {
        return iwsMaitosigaikatkprkgk1x42;
    }

    public void setIwsMaitosigaikatkprkgk1x42(BizNumber pIwsMaitosigaikatkprkgk1x42) {
        iwsMaitosigaikatkprkgk1x42 = pIwsMaitosigaikatkprkgk1x42;
    }

    @Column(order = 96, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x43;

    public BizNumber getIwsMaitosigaikatkprkgk1x43() {
        return iwsMaitosigaikatkprkgk1x43;
    }

    public void setIwsMaitosigaikatkprkgk1x43(BizNumber pIwsMaitosigaikatkprkgk1x43) {
        iwsMaitosigaikatkprkgk1x43 = pIwsMaitosigaikatkprkgk1x43;
    }

    @Column(order = 97, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x44;

    public BizNumber getIwsMaitosigaikatkprkgk1x44() {
        return iwsMaitosigaikatkprkgk1x44;
    }

    public void setIwsMaitosigaikatkprkgk1x44(BizNumber pIwsMaitosigaikatkprkgk1x44) {
        iwsMaitosigaikatkprkgk1x44 = pIwsMaitosigaikatkprkgk1x44;
    }

    @Column(order = 98, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x45;

    public BizNumber getIwsMaitosigaikatkprkgk1x45() {
        return iwsMaitosigaikatkprkgk1x45;
    }

    public void setIwsMaitosigaikatkprkgk1x45(BizNumber pIwsMaitosigaikatkprkgk1x45) {
        iwsMaitosigaikatkprkgk1x45 = pIwsMaitosigaikatkprkgk1x45;
    }

    @Column(order = 99, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x46;

    public BizNumber getIwsMaitosigaikatkprkgk1x46() {
        return iwsMaitosigaikatkprkgk1x46;
    }

    public void setIwsMaitosigaikatkprkgk1x46(BizNumber pIwsMaitosigaikatkprkgk1x46) {
        iwsMaitosigaikatkprkgk1x46 = pIwsMaitosigaikatkprkgk1x46;
    }

    @Column(order = 100, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x47;

    public BizNumber getIwsMaitosigaikatkprkgk1x47() {
        return iwsMaitosigaikatkprkgk1x47;
    }

    public void setIwsMaitosigaikatkprkgk1x47(BizNumber pIwsMaitosigaikatkprkgk1x47) {
        iwsMaitosigaikatkprkgk1x47 = pIwsMaitosigaikatkprkgk1x47;
    }

    @Column(order = 101, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x48;

    public BizNumber getIwsMaitosigaikatkprkgk1x48() {
        return iwsMaitosigaikatkprkgk1x48;
    }

    public void setIwsMaitosigaikatkprkgk1x48(BizNumber pIwsMaitosigaikatkprkgk1x48) {
        iwsMaitosigaikatkprkgk1x48 = pIwsMaitosigaikatkprkgk1x48;
    }

    @Column(order = 102, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x49;

    public BizNumber getIwsMaitosigaikatkprkgk1x49() {
        return iwsMaitosigaikatkprkgk1x49;
    }

    public void setIwsMaitosigaikatkprkgk1x49(BizNumber pIwsMaitosigaikatkprkgk1x49) {
        iwsMaitosigaikatkprkgk1x49 = pIwsMaitosigaikatkprkgk1x49;
    }

    @Column(order = 103, length = 13)
    private BizNumber iwsMaitosigaikatkprkgk1x50;

    public BizNumber getIwsMaitosigaikatkprkgk1x50() {
        return iwsMaitosigaikatkprkgk1x50;
    }

    public void setIwsMaitosigaikatkprkgk1x50(BizNumber pIwsMaitosigaikatkprkgk1x50) {
        iwsMaitosigaikatkprkgk1x50 = pIwsMaitosigaikatkprkgk1x50;
    }

    @Column(order = 104, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x1;

    public BizNumber getIwsMaitosiyeniktprkgk1x1() {
        return iwsMaitosiyeniktprkgk1x1;
    }

    public void setIwsMaitosiyeniktprkgk1x1(BizNumber pIwsMaitosiyeniktprkgk1x1) {
        iwsMaitosiyeniktprkgk1x1 = pIwsMaitosiyeniktprkgk1x1;
    }

    @Column(order = 105, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x2;

    public BizNumber getIwsMaitosiyeniktprkgk1x2() {
        return iwsMaitosiyeniktprkgk1x2;
    }

    public void setIwsMaitosiyeniktprkgk1x2(BizNumber pIwsMaitosiyeniktprkgk1x2) {
        iwsMaitosiyeniktprkgk1x2 = pIwsMaitosiyeniktprkgk1x2;
    }

    @Column(order = 106, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x3;

    public BizNumber getIwsMaitosiyeniktprkgk1x3() {
        return iwsMaitosiyeniktprkgk1x3;
    }

    public void setIwsMaitosiyeniktprkgk1x3(BizNumber pIwsMaitosiyeniktprkgk1x3) {
        iwsMaitosiyeniktprkgk1x3 = pIwsMaitosiyeniktprkgk1x3;
    }

    @Column(order = 107, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x4;

    public BizNumber getIwsMaitosiyeniktprkgk1x4() {
        return iwsMaitosiyeniktprkgk1x4;
    }

    public void setIwsMaitosiyeniktprkgk1x4(BizNumber pIwsMaitosiyeniktprkgk1x4) {
        iwsMaitosiyeniktprkgk1x4 = pIwsMaitosiyeniktprkgk1x4;
    }

    @Column(order = 108, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x5;

    public BizNumber getIwsMaitosiyeniktprkgk1x5() {
        return iwsMaitosiyeniktprkgk1x5;
    }

    public void setIwsMaitosiyeniktprkgk1x5(BizNumber pIwsMaitosiyeniktprkgk1x5) {
        iwsMaitosiyeniktprkgk1x5 = pIwsMaitosiyeniktprkgk1x5;
    }

    @Column(order = 109, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x6;

    public BizNumber getIwsMaitosiyeniktprkgk1x6() {
        return iwsMaitosiyeniktprkgk1x6;
    }

    public void setIwsMaitosiyeniktprkgk1x6(BizNumber pIwsMaitosiyeniktprkgk1x6) {
        iwsMaitosiyeniktprkgk1x6 = pIwsMaitosiyeniktprkgk1x6;
    }

    @Column(order = 110, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x7;

    public BizNumber getIwsMaitosiyeniktprkgk1x7() {
        return iwsMaitosiyeniktprkgk1x7;
    }

    public void setIwsMaitosiyeniktprkgk1x7(BizNumber pIwsMaitosiyeniktprkgk1x7) {
        iwsMaitosiyeniktprkgk1x7 = pIwsMaitosiyeniktprkgk1x7;
    }

    @Column(order = 111, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x8;

    public BizNumber getIwsMaitosiyeniktprkgk1x8() {
        return iwsMaitosiyeniktprkgk1x8;
    }

    public void setIwsMaitosiyeniktprkgk1x8(BizNumber pIwsMaitosiyeniktprkgk1x8) {
        iwsMaitosiyeniktprkgk1x8 = pIwsMaitosiyeniktprkgk1x8;
    }

    @Column(order = 112, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x9;

    public BizNumber getIwsMaitosiyeniktprkgk1x9() {
        return iwsMaitosiyeniktprkgk1x9;
    }

    public void setIwsMaitosiyeniktprkgk1x9(BizNumber pIwsMaitosiyeniktprkgk1x9) {
        iwsMaitosiyeniktprkgk1x9 = pIwsMaitosiyeniktprkgk1x9;
    }

    @Column(order = 113, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x10;

    public BizNumber getIwsMaitosiyeniktprkgk1x10() {
        return iwsMaitosiyeniktprkgk1x10;
    }

    public void setIwsMaitosiyeniktprkgk1x10(BizNumber pIwsMaitosiyeniktprkgk1x10) {
        iwsMaitosiyeniktprkgk1x10 = pIwsMaitosiyeniktprkgk1x10;
    }

    @Column(order = 114, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x11;

    public BizNumber getIwsMaitosiyeniktprkgk1x11() {
        return iwsMaitosiyeniktprkgk1x11;
    }

    public void setIwsMaitosiyeniktprkgk1x11(BizNumber pIwsMaitosiyeniktprkgk1x11) {
        iwsMaitosiyeniktprkgk1x11 = pIwsMaitosiyeniktprkgk1x11;
    }

    @Column(order = 115, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x12;

    public BizNumber getIwsMaitosiyeniktprkgk1x12() {
        return iwsMaitosiyeniktprkgk1x12;
    }

    public void setIwsMaitosiyeniktprkgk1x12(BizNumber pIwsMaitosiyeniktprkgk1x12) {
        iwsMaitosiyeniktprkgk1x12 = pIwsMaitosiyeniktprkgk1x12;
    }

    @Column(order = 116, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x13;

    public BizNumber getIwsMaitosiyeniktprkgk1x13() {
        return iwsMaitosiyeniktprkgk1x13;
    }

    public void setIwsMaitosiyeniktprkgk1x13(BizNumber pIwsMaitosiyeniktprkgk1x13) {
        iwsMaitosiyeniktprkgk1x13 = pIwsMaitosiyeniktprkgk1x13;
    }

    @Column(order = 117, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x14;

    public BizNumber getIwsMaitosiyeniktprkgk1x14() {
        return iwsMaitosiyeniktprkgk1x14;
    }

    public void setIwsMaitosiyeniktprkgk1x14(BizNumber pIwsMaitosiyeniktprkgk1x14) {
        iwsMaitosiyeniktprkgk1x14 = pIwsMaitosiyeniktprkgk1x14;
    }

    @Column(order = 118, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x15;

    public BizNumber getIwsMaitosiyeniktprkgk1x15() {
        return iwsMaitosiyeniktprkgk1x15;
    }

    public void setIwsMaitosiyeniktprkgk1x15(BizNumber pIwsMaitosiyeniktprkgk1x15) {
        iwsMaitosiyeniktprkgk1x15 = pIwsMaitosiyeniktprkgk1x15;
    }

    @Column(order = 119, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x16;

    public BizNumber getIwsMaitosiyeniktprkgk1x16() {
        return iwsMaitosiyeniktprkgk1x16;
    }

    public void setIwsMaitosiyeniktprkgk1x16(BizNumber pIwsMaitosiyeniktprkgk1x16) {
        iwsMaitosiyeniktprkgk1x16 = pIwsMaitosiyeniktprkgk1x16;
    }

    @Column(order = 120, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x17;

    public BizNumber getIwsMaitosiyeniktprkgk1x17() {
        return iwsMaitosiyeniktprkgk1x17;
    }

    public void setIwsMaitosiyeniktprkgk1x17(BizNumber pIwsMaitosiyeniktprkgk1x17) {
        iwsMaitosiyeniktprkgk1x17 = pIwsMaitosiyeniktprkgk1x17;
    }

    @Column(order = 121, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x18;

    public BizNumber getIwsMaitosiyeniktprkgk1x18() {
        return iwsMaitosiyeniktprkgk1x18;
    }

    public void setIwsMaitosiyeniktprkgk1x18(BizNumber pIwsMaitosiyeniktprkgk1x18) {
        iwsMaitosiyeniktprkgk1x18 = pIwsMaitosiyeniktprkgk1x18;
    }

    @Column(order = 122, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x19;

    public BizNumber getIwsMaitosiyeniktprkgk1x19() {
        return iwsMaitosiyeniktprkgk1x19;
    }

    public void setIwsMaitosiyeniktprkgk1x19(BizNumber pIwsMaitosiyeniktprkgk1x19) {
        iwsMaitosiyeniktprkgk1x19 = pIwsMaitosiyeniktprkgk1x19;
    }

    @Column(order = 123, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x20;

    public BizNumber getIwsMaitosiyeniktprkgk1x20() {
        return iwsMaitosiyeniktprkgk1x20;
    }

    public void setIwsMaitosiyeniktprkgk1x20(BizNumber pIwsMaitosiyeniktprkgk1x20) {
        iwsMaitosiyeniktprkgk1x20 = pIwsMaitosiyeniktprkgk1x20;
    }

    @Column(order = 124, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x21;

    public BizNumber getIwsMaitosiyeniktprkgk1x21() {
        return iwsMaitosiyeniktprkgk1x21;
    }

    public void setIwsMaitosiyeniktprkgk1x21(BizNumber pIwsMaitosiyeniktprkgk1x21) {
        iwsMaitosiyeniktprkgk1x21 = pIwsMaitosiyeniktprkgk1x21;
    }

    @Column(order = 125, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x22;

    public BizNumber getIwsMaitosiyeniktprkgk1x22() {
        return iwsMaitosiyeniktprkgk1x22;
    }

    public void setIwsMaitosiyeniktprkgk1x22(BizNumber pIwsMaitosiyeniktprkgk1x22) {
        iwsMaitosiyeniktprkgk1x22 = pIwsMaitosiyeniktprkgk1x22;
    }

    @Column(order = 126, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x23;

    public BizNumber getIwsMaitosiyeniktprkgk1x23() {
        return iwsMaitosiyeniktprkgk1x23;
    }

    public void setIwsMaitosiyeniktprkgk1x23(BizNumber pIwsMaitosiyeniktprkgk1x23) {
        iwsMaitosiyeniktprkgk1x23 = pIwsMaitosiyeniktprkgk1x23;
    }

    @Column(order = 127, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x24;

    public BizNumber getIwsMaitosiyeniktprkgk1x24() {
        return iwsMaitosiyeniktprkgk1x24;
    }

    public void setIwsMaitosiyeniktprkgk1x24(BizNumber pIwsMaitosiyeniktprkgk1x24) {
        iwsMaitosiyeniktprkgk1x24 = pIwsMaitosiyeniktprkgk1x24;
    }

    @Column(order = 128, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x25;

    public BizNumber getIwsMaitosiyeniktprkgk1x25() {
        return iwsMaitosiyeniktprkgk1x25;
    }

    public void setIwsMaitosiyeniktprkgk1x25(BizNumber pIwsMaitosiyeniktprkgk1x25) {
        iwsMaitosiyeniktprkgk1x25 = pIwsMaitosiyeniktprkgk1x25;
    }

    @Column(order = 129, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x26;

    public BizNumber getIwsMaitosiyeniktprkgk1x26() {
        return iwsMaitosiyeniktprkgk1x26;
    }

    public void setIwsMaitosiyeniktprkgk1x26(BizNumber pIwsMaitosiyeniktprkgk1x26) {
        iwsMaitosiyeniktprkgk1x26 = pIwsMaitosiyeniktprkgk1x26;
    }

    @Column(order = 130, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x27;

    public BizNumber getIwsMaitosiyeniktprkgk1x27() {
        return iwsMaitosiyeniktprkgk1x27;
    }

    public void setIwsMaitosiyeniktprkgk1x27(BizNumber pIwsMaitosiyeniktprkgk1x27) {
        iwsMaitosiyeniktprkgk1x27 = pIwsMaitosiyeniktprkgk1x27;
    }

    @Column(order = 131, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x28;

    public BizNumber getIwsMaitosiyeniktprkgk1x28() {
        return iwsMaitosiyeniktprkgk1x28;
    }

    public void setIwsMaitosiyeniktprkgk1x28(BizNumber pIwsMaitosiyeniktprkgk1x28) {
        iwsMaitosiyeniktprkgk1x28 = pIwsMaitosiyeniktprkgk1x28;
    }

    @Column(order = 132, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x29;

    public BizNumber getIwsMaitosiyeniktprkgk1x29() {
        return iwsMaitosiyeniktprkgk1x29;
    }

    public void setIwsMaitosiyeniktprkgk1x29(BizNumber pIwsMaitosiyeniktprkgk1x29) {
        iwsMaitosiyeniktprkgk1x29 = pIwsMaitosiyeniktprkgk1x29;
    }

    @Column(order = 133, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x30;

    public BizNumber getIwsMaitosiyeniktprkgk1x30() {
        return iwsMaitosiyeniktprkgk1x30;
    }

    public void setIwsMaitosiyeniktprkgk1x30(BizNumber pIwsMaitosiyeniktprkgk1x30) {
        iwsMaitosiyeniktprkgk1x30 = pIwsMaitosiyeniktprkgk1x30;
    }

    @Column(order = 134, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x31;

    public BizNumber getIwsMaitosiyeniktprkgk1x31() {
        return iwsMaitosiyeniktprkgk1x31;
    }

    public void setIwsMaitosiyeniktprkgk1x31(BizNumber pIwsMaitosiyeniktprkgk1x31) {
        iwsMaitosiyeniktprkgk1x31 = pIwsMaitosiyeniktprkgk1x31;
    }

    @Column(order = 135, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x32;

    public BizNumber getIwsMaitosiyeniktprkgk1x32() {
        return iwsMaitosiyeniktprkgk1x32;
    }

    public void setIwsMaitosiyeniktprkgk1x32(BizNumber pIwsMaitosiyeniktprkgk1x32) {
        iwsMaitosiyeniktprkgk1x32 = pIwsMaitosiyeniktprkgk1x32;
    }

    @Column(order = 136, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x33;

    public BizNumber getIwsMaitosiyeniktprkgk1x33() {
        return iwsMaitosiyeniktprkgk1x33;
    }

    public void setIwsMaitosiyeniktprkgk1x33(BizNumber pIwsMaitosiyeniktprkgk1x33) {
        iwsMaitosiyeniktprkgk1x33 = pIwsMaitosiyeniktprkgk1x33;
    }

    @Column(order = 137, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x34;

    public BizNumber getIwsMaitosiyeniktprkgk1x34() {
        return iwsMaitosiyeniktprkgk1x34;
    }

    public void setIwsMaitosiyeniktprkgk1x34(BizNumber pIwsMaitosiyeniktprkgk1x34) {
        iwsMaitosiyeniktprkgk1x34 = pIwsMaitosiyeniktprkgk1x34;
    }

    @Column(order = 138, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x35;

    public BizNumber getIwsMaitosiyeniktprkgk1x35() {
        return iwsMaitosiyeniktprkgk1x35;
    }

    public void setIwsMaitosiyeniktprkgk1x35(BizNumber pIwsMaitosiyeniktprkgk1x35) {
        iwsMaitosiyeniktprkgk1x35 = pIwsMaitosiyeniktprkgk1x35;
    }

    @Column(order = 139, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x36;

    public BizNumber getIwsMaitosiyeniktprkgk1x36() {
        return iwsMaitosiyeniktprkgk1x36;
    }

    public void setIwsMaitosiyeniktprkgk1x36(BizNumber pIwsMaitosiyeniktprkgk1x36) {
        iwsMaitosiyeniktprkgk1x36 = pIwsMaitosiyeniktprkgk1x36;
    }

    @Column(order = 140, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x37;

    public BizNumber getIwsMaitosiyeniktprkgk1x37() {
        return iwsMaitosiyeniktprkgk1x37;
    }

    public void setIwsMaitosiyeniktprkgk1x37(BizNumber pIwsMaitosiyeniktprkgk1x37) {
        iwsMaitosiyeniktprkgk1x37 = pIwsMaitosiyeniktprkgk1x37;
    }

    @Column(order = 141, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x38;

    public BizNumber getIwsMaitosiyeniktprkgk1x38() {
        return iwsMaitosiyeniktprkgk1x38;
    }

    public void setIwsMaitosiyeniktprkgk1x38(BizNumber pIwsMaitosiyeniktprkgk1x38) {
        iwsMaitosiyeniktprkgk1x38 = pIwsMaitosiyeniktprkgk1x38;
    }

    @Column(order = 142, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x39;

    public BizNumber getIwsMaitosiyeniktprkgk1x39() {
        return iwsMaitosiyeniktprkgk1x39;
    }

    public void setIwsMaitosiyeniktprkgk1x39(BizNumber pIwsMaitosiyeniktprkgk1x39) {
        iwsMaitosiyeniktprkgk1x39 = pIwsMaitosiyeniktprkgk1x39;
    }

    @Column(order = 143, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x40;

    public BizNumber getIwsMaitosiyeniktprkgk1x40() {
        return iwsMaitosiyeniktprkgk1x40;
    }

    public void setIwsMaitosiyeniktprkgk1x40(BizNumber pIwsMaitosiyeniktprkgk1x40) {
        iwsMaitosiyeniktprkgk1x40 = pIwsMaitosiyeniktprkgk1x40;
    }

    @Column(order = 144, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x41;

    public BizNumber getIwsMaitosiyeniktprkgk1x41() {
        return iwsMaitosiyeniktprkgk1x41;
    }

    public void setIwsMaitosiyeniktprkgk1x41(BizNumber pIwsMaitosiyeniktprkgk1x41) {
        iwsMaitosiyeniktprkgk1x41 = pIwsMaitosiyeniktprkgk1x41;
    }

    @Column(order = 145, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x42;

    public BizNumber getIwsMaitosiyeniktprkgk1x42() {
        return iwsMaitosiyeniktprkgk1x42;
    }

    public void setIwsMaitosiyeniktprkgk1x42(BizNumber pIwsMaitosiyeniktprkgk1x42) {
        iwsMaitosiyeniktprkgk1x42 = pIwsMaitosiyeniktprkgk1x42;
    }

    @Column(order = 146, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x43;

    public BizNumber getIwsMaitosiyeniktprkgk1x43() {
        return iwsMaitosiyeniktprkgk1x43;
    }

    public void setIwsMaitosiyeniktprkgk1x43(BizNumber pIwsMaitosiyeniktprkgk1x43) {
        iwsMaitosiyeniktprkgk1x43 = pIwsMaitosiyeniktprkgk1x43;
    }

    @Column(order = 147, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x44;

    public BizNumber getIwsMaitosiyeniktprkgk1x44() {
        return iwsMaitosiyeniktprkgk1x44;
    }

    public void setIwsMaitosiyeniktprkgk1x44(BizNumber pIwsMaitosiyeniktprkgk1x44) {
        iwsMaitosiyeniktprkgk1x44 = pIwsMaitosiyeniktprkgk1x44;
    }

    @Column(order = 148, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x45;

    public BizNumber getIwsMaitosiyeniktprkgk1x45() {
        return iwsMaitosiyeniktprkgk1x45;
    }

    public void setIwsMaitosiyeniktprkgk1x45(BizNumber pIwsMaitosiyeniktprkgk1x45) {
        iwsMaitosiyeniktprkgk1x45 = pIwsMaitosiyeniktprkgk1x45;
    }

    @Column(order = 149, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x46;

    public BizNumber getIwsMaitosiyeniktprkgk1x46() {
        return iwsMaitosiyeniktprkgk1x46;
    }

    public void setIwsMaitosiyeniktprkgk1x46(BizNumber pIwsMaitosiyeniktprkgk1x46) {
        iwsMaitosiyeniktprkgk1x46 = pIwsMaitosiyeniktprkgk1x46;
    }

    @Column(order = 150, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x47;

    public BizNumber getIwsMaitosiyeniktprkgk1x47() {
        return iwsMaitosiyeniktprkgk1x47;
    }

    public void setIwsMaitosiyeniktprkgk1x47(BizNumber pIwsMaitosiyeniktprkgk1x47) {
        iwsMaitosiyeniktprkgk1x47 = pIwsMaitosiyeniktprkgk1x47;
    }

    @Column(order = 151, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x48;

    public BizNumber getIwsMaitosiyeniktprkgk1x48() {
        return iwsMaitosiyeniktprkgk1x48;
    }

    public void setIwsMaitosiyeniktprkgk1x48(BizNumber pIwsMaitosiyeniktprkgk1x48) {
        iwsMaitosiyeniktprkgk1x48 = pIwsMaitosiyeniktprkgk1x48;
    }

    @Column(order = 152, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x49;

    public BizNumber getIwsMaitosiyeniktprkgk1x49() {
        return iwsMaitosiyeniktprkgk1x49;
    }

    public void setIwsMaitosiyeniktprkgk1x49(BizNumber pIwsMaitosiyeniktprkgk1x49) {
        iwsMaitosiyeniktprkgk1x49 = pIwsMaitosiyeniktprkgk1x49;
    }

    @Column(order = 153, length = 10)
    private BizNumber iwsMaitosiyeniktprkgk1x50;

    public BizNumber getIwsMaitosiyeniktprkgk1x50() {
        return iwsMaitosiyeniktprkgk1x50;
    }

    public void setIwsMaitosiyeniktprkgk1x50(BizNumber pIwsMaitosiyeniktprkgk1x50) {
        iwsMaitosiyeniktprkgk1x50 = pIwsMaitosiyeniktprkgk1x50;
    }

    @Column(order = 154, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x1;

    public BizNumber getIwsMaitosikaiyakuhr1x1() {
        return iwsMaitosikaiyakuhr1x1;
    }

    public void setIwsMaitosikaiyakuhr1x1(BizNumber pIwsMaitosikaiyakuhr1x1) {
        iwsMaitosikaiyakuhr1x1 = pIwsMaitosikaiyakuhr1x1;
    }

    @Column(order = 155, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x2;

    public BizNumber getIwsMaitosikaiyakuhr1x2() {
        return iwsMaitosikaiyakuhr1x2;
    }

    public void setIwsMaitosikaiyakuhr1x2(BizNumber pIwsMaitosikaiyakuhr1x2) {
        iwsMaitosikaiyakuhr1x2 = pIwsMaitosikaiyakuhr1x2;
    }

    @Column(order = 156, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x3;

    public BizNumber getIwsMaitosikaiyakuhr1x3() {
        return iwsMaitosikaiyakuhr1x3;
    }

    public void setIwsMaitosikaiyakuhr1x3(BizNumber pIwsMaitosikaiyakuhr1x3) {
        iwsMaitosikaiyakuhr1x3 = pIwsMaitosikaiyakuhr1x3;
    }

    @Column(order = 157, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x4;

    public BizNumber getIwsMaitosikaiyakuhr1x4() {
        return iwsMaitosikaiyakuhr1x4;
    }

    public void setIwsMaitosikaiyakuhr1x4(BizNumber pIwsMaitosikaiyakuhr1x4) {
        iwsMaitosikaiyakuhr1x4 = pIwsMaitosikaiyakuhr1x4;
    }

    @Column(order = 158, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x5;

    public BizNumber getIwsMaitosikaiyakuhr1x5() {
        return iwsMaitosikaiyakuhr1x5;
    }

    public void setIwsMaitosikaiyakuhr1x5(BizNumber pIwsMaitosikaiyakuhr1x5) {
        iwsMaitosikaiyakuhr1x5 = pIwsMaitosikaiyakuhr1x5;
    }

    @Column(order = 159, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x6;

    public BizNumber getIwsMaitosikaiyakuhr1x6() {
        return iwsMaitosikaiyakuhr1x6;
    }

    public void setIwsMaitosikaiyakuhr1x6(BizNumber pIwsMaitosikaiyakuhr1x6) {
        iwsMaitosikaiyakuhr1x6 = pIwsMaitosikaiyakuhr1x6;
    }

    @Column(order = 160, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x7;

    public BizNumber getIwsMaitosikaiyakuhr1x7() {
        return iwsMaitosikaiyakuhr1x7;
    }

    public void setIwsMaitosikaiyakuhr1x7(BizNumber pIwsMaitosikaiyakuhr1x7) {
        iwsMaitosikaiyakuhr1x7 = pIwsMaitosikaiyakuhr1x7;
    }

    @Column(order = 161, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x8;

    public BizNumber getIwsMaitosikaiyakuhr1x8() {
        return iwsMaitosikaiyakuhr1x8;
    }

    public void setIwsMaitosikaiyakuhr1x8(BizNumber pIwsMaitosikaiyakuhr1x8) {
        iwsMaitosikaiyakuhr1x8 = pIwsMaitosikaiyakuhr1x8;
    }

    @Column(order = 162, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x9;

    public BizNumber getIwsMaitosikaiyakuhr1x9() {
        return iwsMaitosikaiyakuhr1x9;
    }

    public void setIwsMaitosikaiyakuhr1x9(BizNumber pIwsMaitosikaiyakuhr1x9) {
        iwsMaitosikaiyakuhr1x9 = pIwsMaitosikaiyakuhr1x9;
    }

    @Column(order = 163, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x10;

    public BizNumber getIwsMaitosikaiyakuhr1x10() {
        return iwsMaitosikaiyakuhr1x10;
    }

    public void setIwsMaitosikaiyakuhr1x10(BizNumber pIwsMaitosikaiyakuhr1x10) {
        iwsMaitosikaiyakuhr1x10 = pIwsMaitosikaiyakuhr1x10;
    }

    @Column(order = 164, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x11;

    public BizNumber getIwsMaitosikaiyakuhr1x11() {
        return iwsMaitosikaiyakuhr1x11;
    }

    public void setIwsMaitosikaiyakuhr1x11(BizNumber pIwsMaitosikaiyakuhr1x11) {
        iwsMaitosikaiyakuhr1x11 = pIwsMaitosikaiyakuhr1x11;
    }

    @Column(order = 165, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x12;

    public BizNumber getIwsMaitosikaiyakuhr1x12() {
        return iwsMaitosikaiyakuhr1x12;
    }

    public void setIwsMaitosikaiyakuhr1x12(BizNumber pIwsMaitosikaiyakuhr1x12) {
        iwsMaitosikaiyakuhr1x12 = pIwsMaitosikaiyakuhr1x12;
    }

    @Column(order = 166, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x13;

    public BizNumber getIwsMaitosikaiyakuhr1x13() {
        return iwsMaitosikaiyakuhr1x13;
    }

    public void setIwsMaitosikaiyakuhr1x13(BizNumber pIwsMaitosikaiyakuhr1x13) {
        iwsMaitosikaiyakuhr1x13 = pIwsMaitosikaiyakuhr1x13;
    }

    @Column(order = 167, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x14;

    public BizNumber getIwsMaitosikaiyakuhr1x14() {
        return iwsMaitosikaiyakuhr1x14;
    }

    public void setIwsMaitosikaiyakuhr1x14(BizNumber pIwsMaitosikaiyakuhr1x14) {
        iwsMaitosikaiyakuhr1x14 = pIwsMaitosikaiyakuhr1x14;
    }

    @Column(order = 168, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x15;

    public BizNumber getIwsMaitosikaiyakuhr1x15() {
        return iwsMaitosikaiyakuhr1x15;
    }

    public void setIwsMaitosikaiyakuhr1x15(BizNumber pIwsMaitosikaiyakuhr1x15) {
        iwsMaitosikaiyakuhr1x15 = pIwsMaitosikaiyakuhr1x15;
    }

    @Column(order = 169, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x16;

    public BizNumber getIwsMaitosikaiyakuhr1x16() {
        return iwsMaitosikaiyakuhr1x16;
    }

    public void setIwsMaitosikaiyakuhr1x16(BizNumber pIwsMaitosikaiyakuhr1x16) {
        iwsMaitosikaiyakuhr1x16 = pIwsMaitosikaiyakuhr1x16;
    }

    @Column(order = 170, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x17;

    public BizNumber getIwsMaitosikaiyakuhr1x17() {
        return iwsMaitosikaiyakuhr1x17;
    }

    public void setIwsMaitosikaiyakuhr1x17(BizNumber pIwsMaitosikaiyakuhr1x17) {
        iwsMaitosikaiyakuhr1x17 = pIwsMaitosikaiyakuhr1x17;
    }

    @Column(order = 171, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x18;

    public BizNumber getIwsMaitosikaiyakuhr1x18() {
        return iwsMaitosikaiyakuhr1x18;
    }

    public void setIwsMaitosikaiyakuhr1x18(BizNumber pIwsMaitosikaiyakuhr1x18) {
        iwsMaitosikaiyakuhr1x18 = pIwsMaitosikaiyakuhr1x18;
    }

    @Column(order = 172, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x19;

    public BizNumber getIwsMaitosikaiyakuhr1x19() {
        return iwsMaitosikaiyakuhr1x19;
    }

    public void setIwsMaitosikaiyakuhr1x19(BizNumber pIwsMaitosikaiyakuhr1x19) {
        iwsMaitosikaiyakuhr1x19 = pIwsMaitosikaiyakuhr1x19;
    }

    @Column(order = 173, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x20;

    public BizNumber getIwsMaitosikaiyakuhr1x20() {
        return iwsMaitosikaiyakuhr1x20;
    }

    public void setIwsMaitosikaiyakuhr1x20(BizNumber pIwsMaitosikaiyakuhr1x20) {
        iwsMaitosikaiyakuhr1x20 = pIwsMaitosikaiyakuhr1x20;
    }

    @Column(order = 174, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x21;

    public BizNumber getIwsMaitosikaiyakuhr1x21() {
        return iwsMaitosikaiyakuhr1x21;
    }

    public void setIwsMaitosikaiyakuhr1x21(BizNumber pIwsMaitosikaiyakuhr1x21) {
        iwsMaitosikaiyakuhr1x21 = pIwsMaitosikaiyakuhr1x21;
    }

    @Column(order = 175, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x22;

    public BizNumber getIwsMaitosikaiyakuhr1x22() {
        return iwsMaitosikaiyakuhr1x22;
    }

    public void setIwsMaitosikaiyakuhr1x22(BizNumber pIwsMaitosikaiyakuhr1x22) {
        iwsMaitosikaiyakuhr1x22 = pIwsMaitosikaiyakuhr1x22;
    }

    @Column(order = 176, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x23;

    public BizNumber getIwsMaitosikaiyakuhr1x23() {
        return iwsMaitosikaiyakuhr1x23;
    }

    public void setIwsMaitosikaiyakuhr1x23(BizNumber pIwsMaitosikaiyakuhr1x23) {
        iwsMaitosikaiyakuhr1x23 = pIwsMaitosikaiyakuhr1x23;
    }

    @Column(order = 177, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x24;

    public BizNumber getIwsMaitosikaiyakuhr1x24() {
        return iwsMaitosikaiyakuhr1x24;
    }

    public void setIwsMaitosikaiyakuhr1x24(BizNumber pIwsMaitosikaiyakuhr1x24) {
        iwsMaitosikaiyakuhr1x24 = pIwsMaitosikaiyakuhr1x24;
    }

    @Column(order = 178, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x25;

    public BizNumber getIwsMaitosikaiyakuhr1x25() {
        return iwsMaitosikaiyakuhr1x25;
    }

    public void setIwsMaitosikaiyakuhr1x25(BizNumber pIwsMaitosikaiyakuhr1x25) {
        iwsMaitosikaiyakuhr1x25 = pIwsMaitosikaiyakuhr1x25;
    }

    @Column(order = 179, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x26;

    public BizNumber getIwsMaitosikaiyakuhr1x26() {
        return iwsMaitosikaiyakuhr1x26;
    }

    public void setIwsMaitosikaiyakuhr1x26(BizNumber pIwsMaitosikaiyakuhr1x26) {
        iwsMaitosikaiyakuhr1x26 = pIwsMaitosikaiyakuhr1x26;
    }

    @Column(order = 180, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x27;

    public BizNumber getIwsMaitosikaiyakuhr1x27() {
        return iwsMaitosikaiyakuhr1x27;
    }

    public void setIwsMaitosikaiyakuhr1x27(BizNumber pIwsMaitosikaiyakuhr1x27) {
        iwsMaitosikaiyakuhr1x27 = pIwsMaitosikaiyakuhr1x27;
    }

    @Column(order = 181, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x28;

    public BizNumber getIwsMaitosikaiyakuhr1x28() {
        return iwsMaitosikaiyakuhr1x28;
    }

    public void setIwsMaitosikaiyakuhr1x28(BizNumber pIwsMaitosikaiyakuhr1x28) {
        iwsMaitosikaiyakuhr1x28 = pIwsMaitosikaiyakuhr1x28;
    }

    @Column(order = 182, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x29;

    public BizNumber getIwsMaitosikaiyakuhr1x29() {
        return iwsMaitosikaiyakuhr1x29;
    }

    public void setIwsMaitosikaiyakuhr1x29(BizNumber pIwsMaitosikaiyakuhr1x29) {
        iwsMaitosikaiyakuhr1x29 = pIwsMaitosikaiyakuhr1x29;
    }

    @Column(order = 183, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x30;

    public BizNumber getIwsMaitosikaiyakuhr1x30() {
        return iwsMaitosikaiyakuhr1x30;
    }

    public void setIwsMaitosikaiyakuhr1x30(BizNumber pIwsMaitosikaiyakuhr1x30) {
        iwsMaitosikaiyakuhr1x30 = pIwsMaitosikaiyakuhr1x30;
    }

    @Column(order = 184, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x31;

    public BizNumber getIwsMaitosikaiyakuhr1x31() {
        return iwsMaitosikaiyakuhr1x31;
    }

    public void setIwsMaitosikaiyakuhr1x31(BizNumber pIwsMaitosikaiyakuhr1x31) {
        iwsMaitosikaiyakuhr1x31 = pIwsMaitosikaiyakuhr1x31;
    }

    @Column(order = 185, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x32;

    public BizNumber getIwsMaitosikaiyakuhr1x32() {
        return iwsMaitosikaiyakuhr1x32;
    }

    public void setIwsMaitosikaiyakuhr1x32(BizNumber pIwsMaitosikaiyakuhr1x32) {
        iwsMaitosikaiyakuhr1x32 = pIwsMaitosikaiyakuhr1x32;
    }

    @Column(order = 186, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x33;

    public BizNumber getIwsMaitosikaiyakuhr1x33() {
        return iwsMaitosikaiyakuhr1x33;
    }

    public void setIwsMaitosikaiyakuhr1x33(BizNumber pIwsMaitosikaiyakuhr1x33) {
        iwsMaitosikaiyakuhr1x33 = pIwsMaitosikaiyakuhr1x33;
    }

    @Column(order = 187, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x34;

    public BizNumber getIwsMaitosikaiyakuhr1x34() {
        return iwsMaitosikaiyakuhr1x34;
    }

    public void setIwsMaitosikaiyakuhr1x34(BizNumber pIwsMaitosikaiyakuhr1x34) {
        iwsMaitosikaiyakuhr1x34 = pIwsMaitosikaiyakuhr1x34;
    }

    @Column(order = 188, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x35;

    public BizNumber getIwsMaitosikaiyakuhr1x35() {
        return iwsMaitosikaiyakuhr1x35;
    }

    public void setIwsMaitosikaiyakuhr1x35(BizNumber pIwsMaitosikaiyakuhr1x35) {
        iwsMaitosikaiyakuhr1x35 = pIwsMaitosikaiyakuhr1x35;
    }

    @Column(order = 189, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x36;

    public BizNumber getIwsMaitosikaiyakuhr1x36() {
        return iwsMaitosikaiyakuhr1x36;
    }

    public void setIwsMaitosikaiyakuhr1x36(BizNumber pIwsMaitosikaiyakuhr1x36) {
        iwsMaitosikaiyakuhr1x36 = pIwsMaitosikaiyakuhr1x36;
    }

    @Column(order = 190, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x37;

    public BizNumber getIwsMaitosikaiyakuhr1x37() {
        return iwsMaitosikaiyakuhr1x37;
    }

    public void setIwsMaitosikaiyakuhr1x37(BizNumber pIwsMaitosikaiyakuhr1x37) {
        iwsMaitosikaiyakuhr1x37 = pIwsMaitosikaiyakuhr1x37;
    }

    @Column(order = 191, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x38;

    public BizNumber getIwsMaitosikaiyakuhr1x38() {
        return iwsMaitosikaiyakuhr1x38;
    }

    public void setIwsMaitosikaiyakuhr1x38(BizNumber pIwsMaitosikaiyakuhr1x38) {
        iwsMaitosikaiyakuhr1x38 = pIwsMaitosikaiyakuhr1x38;
    }

    @Column(order = 192, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x39;

    public BizNumber getIwsMaitosikaiyakuhr1x39() {
        return iwsMaitosikaiyakuhr1x39;
    }

    public void setIwsMaitosikaiyakuhr1x39(BizNumber pIwsMaitosikaiyakuhr1x39) {
        iwsMaitosikaiyakuhr1x39 = pIwsMaitosikaiyakuhr1x39;
    }

    @Column(order = 193, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x40;

    public BizNumber getIwsMaitosikaiyakuhr1x40() {
        return iwsMaitosikaiyakuhr1x40;
    }

    public void setIwsMaitosikaiyakuhr1x40(BizNumber pIwsMaitosikaiyakuhr1x40) {
        iwsMaitosikaiyakuhr1x40 = pIwsMaitosikaiyakuhr1x40;
    }

    @Column(order = 194, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x41;

    public BizNumber getIwsMaitosikaiyakuhr1x41() {
        return iwsMaitosikaiyakuhr1x41;
    }

    public void setIwsMaitosikaiyakuhr1x41(BizNumber pIwsMaitosikaiyakuhr1x41) {
        iwsMaitosikaiyakuhr1x41 = pIwsMaitosikaiyakuhr1x41;
    }

    @Column(order = 195, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x42;

    public BizNumber getIwsMaitosikaiyakuhr1x42() {
        return iwsMaitosikaiyakuhr1x42;
    }

    public void setIwsMaitosikaiyakuhr1x42(BizNumber pIwsMaitosikaiyakuhr1x42) {
        iwsMaitosikaiyakuhr1x42 = pIwsMaitosikaiyakuhr1x42;
    }

    @Column(order = 196, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x43;

    public BizNumber getIwsMaitosikaiyakuhr1x43() {
        return iwsMaitosikaiyakuhr1x43;
    }

    public void setIwsMaitosikaiyakuhr1x43(BizNumber pIwsMaitosikaiyakuhr1x43) {
        iwsMaitosikaiyakuhr1x43 = pIwsMaitosikaiyakuhr1x43;
    }

    @Column(order = 197, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x44;

    public BizNumber getIwsMaitosikaiyakuhr1x44() {
        return iwsMaitosikaiyakuhr1x44;
    }

    public void setIwsMaitosikaiyakuhr1x44(BizNumber pIwsMaitosikaiyakuhr1x44) {
        iwsMaitosikaiyakuhr1x44 = pIwsMaitosikaiyakuhr1x44;
    }

    @Column(order = 198, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x45;

    public BizNumber getIwsMaitosikaiyakuhr1x45() {
        return iwsMaitosikaiyakuhr1x45;
    }

    public void setIwsMaitosikaiyakuhr1x45(BizNumber pIwsMaitosikaiyakuhr1x45) {
        iwsMaitosikaiyakuhr1x45 = pIwsMaitosikaiyakuhr1x45;
    }

    @Column(order = 199, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x46;

    public BizNumber getIwsMaitosikaiyakuhr1x46() {
        return iwsMaitosikaiyakuhr1x46;
    }

    public void setIwsMaitosikaiyakuhr1x46(BizNumber pIwsMaitosikaiyakuhr1x46) {
        iwsMaitosikaiyakuhr1x46 = pIwsMaitosikaiyakuhr1x46;
    }

    @Column(order = 200, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x47;

    public BizNumber getIwsMaitosikaiyakuhr1x47() {
        return iwsMaitosikaiyakuhr1x47;
    }

    public void setIwsMaitosikaiyakuhr1x47(BizNumber pIwsMaitosikaiyakuhr1x47) {
        iwsMaitosikaiyakuhr1x47 = pIwsMaitosikaiyakuhr1x47;
    }

    @Column(order = 201, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x48;

    public BizNumber getIwsMaitosikaiyakuhr1x48() {
        return iwsMaitosikaiyakuhr1x48;
    }

    public void setIwsMaitosikaiyakuhr1x48(BizNumber pIwsMaitosikaiyakuhr1x48) {
        iwsMaitosikaiyakuhr1x48 = pIwsMaitosikaiyakuhr1x48;
    }

    @Column(order = 202, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x49;

    public BizNumber getIwsMaitosikaiyakuhr1x49() {
        return iwsMaitosikaiyakuhr1x49;
    }

    public void setIwsMaitosikaiyakuhr1x49(BizNumber pIwsMaitosikaiyakuhr1x49) {
        iwsMaitosikaiyakuhr1x49 = pIwsMaitosikaiyakuhr1x49;
    }

    @Column(order = 203, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x50;

    public BizNumber getIwsMaitosikaiyakuhr1x50() {
        return iwsMaitosikaiyakuhr1x50;
    }

    public void setIwsMaitosikaiyakuhr1x50(BizNumber pIwsMaitosikaiyakuhr1x50) {
        iwsMaitosikaiyakuhr1x50 = pIwsMaitosikaiyakuhr1x50;
    }

    @Column(order = 204, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x51;

    public BizNumber getIwsMaitosikaiyakuhr1x51() {
        return iwsMaitosikaiyakuhr1x51;
    }

    public void setIwsMaitosikaiyakuhr1x51(BizNumber pIwsMaitosikaiyakuhr1x51) {
        iwsMaitosikaiyakuhr1x51 = pIwsMaitosikaiyakuhr1x51;
    }

    @Column(order = 205, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x52;

    public BizNumber getIwsMaitosikaiyakuhr1x52() {
        return iwsMaitosikaiyakuhr1x52;
    }

    public void setIwsMaitosikaiyakuhr1x52(BizNumber pIwsMaitosikaiyakuhr1x52) {
        iwsMaitosikaiyakuhr1x52 = pIwsMaitosikaiyakuhr1x52;
    }

    @Column(order = 206, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x53;

    public BizNumber getIwsMaitosikaiyakuhr1x53() {
        return iwsMaitosikaiyakuhr1x53;
    }

    public void setIwsMaitosikaiyakuhr1x53(BizNumber pIwsMaitosikaiyakuhr1x53) {
        iwsMaitosikaiyakuhr1x53 = pIwsMaitosikaiyakuhr1x53;
    }

    @Column(order = 207, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x54;

    public BizNumber getIwsMaitosikaiyakuhr1x54() {
        return iwsMaitosikaiyakuhr1x54;
    }

    public void setIwsMaitosikaiyakuhr1x54(BizNumber pIwsMaitosikaiyakuhr1x54) {
        iwsMaitosikaiyakuhr1x54 = pIwsMaitosikaiyakuhr1x54;
    }

    @Column(order = 208, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x55;

    public BizNumber getIwsMaitosikaiyakuhr1x55() {
        return iwsMaitosikaiyakuhr1x55;
    }

    public void setIwsMaitosikaiyakuhr1x55(BizNumber pIwsMaitosikaiyakuhr1x55) {
        iwsMaitosikaiyakuhr1x55 = pIwsMaitosikaiyakuhr1x55;
    }

    @Column(order = 209, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x56;

    public BizNumber getIwsMaitosikaiyakuhr1x56() {
        return iwsMaitosikaiyakuhr1x56;
    }

    public void setIwsMaitosikaiyakuhr1x56(BizNumber pIwsMaitosikaiyakuhr1x56) {
        iwsMaitosikaiyakuhr1x56 = pIwsMaitosikaiyakuhr1x56;
    }

    @Column(order = 210, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x57;

    public BizNumber getIwsMaitosikaiyakuhr1x57() {
        return iwsMaitosikaiyakuhr1x57;
    }

    public void setIwsMaitosikaiyakuhr1x57(BizNumber pIwsMaitosikaiyakuhr1x57) {
        iwsMaitosikaiyakuhr1x57 = pIwsMaitosikaiyakuhr1x57;
    }

    @Column(order = 211, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x58;

    public BizNumber getIwsMaitosikaiyakuhr1x58() {
        return iwsMaitosikaiyakuhr1x58;
    }

    public void setIwsMaitosikaiyakuhr1x58(BizNumber pIwsMaitosikaiyakuhr1x58) {
        iwsMaitosikaiyakuhr1x58 = pIwsMaitosikaiyakuhr1x58;
    }

    @Column(order = 212, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x59;

    public BizNumber getIwsMaitosikaiyakuhr1x59() {
        return iwsMaitosikaiyakuhr1x59;
    }

    public void setIwsMaitosikaiyakuhr1x59(BizNumber pIwsMaitosikaiyakuhr1x59) {
        iwsMaitosikaiyakuhr1x59 = pIwsMaitosikaiyakuhr1x59;
    }

    @Column(order = 213, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x60;

    public BizNumber getIwsMaitosikaiyakuhr1x60() {
        return iwsMaitosikaiyakuhr1x60;
    }

    public void setIwsMaitosikaiyakuhr1x60(BizNumber pIwsMaitosikaiyakuhr1x60) {
        iwsMaitosikaiyakuhr1x60 = pIwsMaitosikaiyakuhr1x60;
    }

    @Column(order = 214, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x61;

    public BizNumber getIwsMaitosikaiyakuhr1x61() {
        return iwsMaitosikaiyakuhr1x61;
    }

    public void setIwsMaitosikaiyakuhr1x61(BizNumber pIwsMaitosikaiyakuhr1x61) {
        iwsMaitosikaiyakuhr1x61 = pIwsMaitosikaiyakuhr1x61;
    }

    @Column(order = 215, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x62;

    public BizNumber getIwsMaitosikaiyakuhr1x62() {
        return iwsMaitosikaiyakuhr1x62;
    }

    public void setIwsMaitosikaiyakuhr1x62(BizNumber pIwsMaitosikaiyakuhr1x62) {
        iwsMaitosikaiyakuhr1x62 = pIwsMaitosikaiyakuhr1x62;
    }

    @Column(order = 216, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x63;

    public BizNumber getIwsMaitosikaiyakuhr1x63() {
        return iwsMaitosikaiyakuhr1x63;
    }

    public void setIwsMaitosikaiyakuhr1x63(BizNumber pIwsMaitosikaiyakuhr1x63) {
        iwsMaitosikaiyakuhr1x63 = pIwsMaitosikaiyakuhr1x63;
    }

    @Column(order = 217, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x64;

    public BizNumber getIwsMaitosikaiyakuhr1x64() {
        return iwsMaitosikaiyakuhr1x64;
    }

    public void setIwsMaitosikaiyakuhr1x64(BizNumber pIwsMaitosikaiyakuhr1x64) {
        iwsMaitosikaiyakuhr1x64 = pIwsMaitosikaiyakuhr1x64;
    }

    @Column(order = 218, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x65;

    public BizNumber getIwsMaitosikaiyakuhr1x65() {
        return iwsMaitosikaiyakuhr1x65;
    }

    public void setIwsMaitosikaiyakuhr1x65(BizNumber pIwsMaitosikaiyakuhr1x65) {
        iwsMaitosikaiyakuhr1x65 = pIwsMaitosikaiyakuhr1x65;
    }

    @Column(order = 219, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x1;

    public BizNumber getIwsMaitosikaiyakuhr2x1() {
        return iwsMaitosikaiyakuhr2x1;
    }

    public void setIwsMaitosikaiyakuhr2x1(BizNumber pIwsMaitosikaiyakuhr2x1) {
        iwsMaitosikaiyakuhr2x1 = pIwsMaitosikaiyakuhr2x1;
    }

    @Column(order = 220, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x2;

    public BizNumber getIwsMaitosikaiyakuhr2x2() {
        return iwsMaitosikaiyakuhr2x2;
    }

    public void setIwsMaitosikaiyakuhr2x2(BizNumber pIwsMaitosikaiyakuhr2x2) {
        iwsMaitosikaiyakuhr2x2 = pIwsMaitosikaiyakuhr2x2;
    }

    @Column(order = 221, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x3;

    public BizNumber getIwsMaitosikaiyakuhr2x3() {
        return iwsMaitosikaiyakuhr2x3;
    }

    public void setIwsMaitosikaiyakuhr2x3(BizNumber pIwsMaitosikaiyakuhr2x3) {
        iwsMaitosikaiyakuhr2x3 = pIwsMaitosikaiyakuhr2x3;
    }

    @Column(order = 222, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x4;

    public BizNumber getIwsMaitosikaiyakuhr2x4() {
        return iwsMaitosikaiyakuhr2x4;
    }

    public void setIwsMaitosikaiyakuhr2x4(BizNumber pIwsMaitosikaiyakuhr2x4) {
        iwsMaitosikaiyakuhr2x4 = pIwsMaitosikaiyakuhr2x4;
    }

    @Column(order = 223, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x5;

    public BizNumber getIwsMaitosikaiyakuhr2x5() {
        return iwsMaitosikaiyakuhr2x5;
    }

    public void setIwsMaitosikaiyakuhr2x5(BizNumber pIwsMaitosikaiyakuhr2x5) {
        iwsMaitosikaiyakuhr2x5 = pIwsMaitosikaiyakuhr2x5;
    }

    @Column(order = 224, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x6;

    public BizNumber getIwsMaitosikaiyakuhr2x6() {
        return iwsMaitosikaiyakuhr2x6;
    }

    public void setIwsMaitosikaiyakuhr2x6(BizNumber pIwsMaitosikaiyakuhr2x6) {
        iwsMaitosikaiyakuhr2x6 = pIwsMaitosikaiyakuhr2x6;
    }

    @Column(order = 225, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x7;

    public BizNumber getIwsMaitosikaiyakuhr2x7() {
        return iwsMaitosikaiyakuhr2x7;
    }

    public void setIwsMaitosikaiyakuhr2x7(BizNumber pIwsMaitosikaiyakuhr2x7) {
        iwsMaitosikaiyakuhr2x7 = pIwsMaitosikaiyakuhr2x7;
    }

    @Column(order = 226, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x8;

    public BizNumber getIwsMaitosikaiyakuhr2x8() {
        return iwsMaitosikaiyakuhr2x8;
    }

    public void setIwsMaitosikaiyakuhr2x8(BizNumber pIwsMaitosikaiyakuhr2x8) {
        iwsMaitosikaiyakuhr2x8 = pIwsMaitosikaiyakuhr2x8;
    }

    @Column(order = 227, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x9;

    public BizNumber getIwsMaitosikaiyakuhr2x9() {
        return iwsMaitosikaiyakuhr2x9;
    }

    public void setIwsMaitosikaiyakuhr2x9(BizNumber pIwsMaitosikaiyakuhr2x9) {
        iwsMaitosikaiyakuhr2x9 = pIwsMaitosikaiyakuhr2x9;
    }

    @Column(order = 228, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x10;

    public BizNumber getIwsMaitosikaiyakuhr2x10() {
        return iwsMaitosikaiyakuhr2x10;
    }

    public void setIwsMaitosikaiyakuhr2x10(BizNumber pIwsMaitosikaiyakuhr2x10) {
        iwsMaitosikaiyakuhr2x10 = pIwsMaitosikaiyakuhr2x10;
    }

    @Column(order = 229, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x11;

    public BizNumber getIwsMaitosikaiyakuhr2x11() {
        return iwsMaitosikaiyakuhr2x11;
    }

    public void setIwsMaitosikaiyakuhr2x11(BizNumber pIwsMaitosikaiyakuhr2x11) {
        iwsMaitosikaiyakuhr2x11 = pIwsMaitosikaiyakuhr2x11;
    }

    @Column(order = 230, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x12;

    public BizNumber getIwsMaitosikaiyakuhr2x12() {
        return iwsMaitosikaiyakuhr2x12;
    }

    public void setIwsMaitosikaiyakuhr2x12(BizNumber pIwsMaitosikaiyakuhr2x12) {
        iwsMaitosikaiyakuhr2x12 = pIwsMaitosikaiyakuhr2x12;
    }

    @Column(order = 231, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x13;

    public BizNumber getIwsMaitosikaiyakuhr2x13() {
        return iwsMaitosikaiyakuhr2x13;
    }

    public void setIwsMaitosikaiyakuhr2x13(BizNumber pIwsMaitosikaiyakuhr2x13) {
        iwsMaitosikaiyakuhr2x13 = pIwsMaitosikaiyakuhr2x13;
    }

    @Column(order = 232, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x14;

    public BizNumber getIwsMaitosikaiyakuhr2x14() {
        return iwsMaitosikaiyakuhr2x14;
    }

    public void setIwsMaitosikaiyakuhr2x14(BizNumber pIwsMaitosikaiyakuhr2x14) {
        iwsMaitosikaiyakuhr2x14 = pIwsMaitosikaiyakuhr2x14;
    }

    @Column(order = 233, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x15;

    public BizNumber getIwsMaitosikaiyakuhr2x15() {
        return iwsMaitosikaiyakuhr2x15;
    }

    public void setIwsMaitosikaiyakuhr2x15(BizNumber pIwsMaitosikaiyakuhr2x15) {
        iwsMaitosikaiyakuhr2x15 = pIwsMaitosikaiyakuhr2x15;
    }

    @Column(order = 234, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x16;

    public BizNumber getIwsMaitosikaiyakuhr2x16() {
        return iwsMaitosikaiyakuhr2x16;
    }

    public void setIwsMaitosikaiyakuhr2x16(BizNumber pIwsMaitosikaiyakuhr2x16) {
        iwsMaitosikaiyakuhr2x16 = pIwsMaitosikaiyakuhr2x16;
    }

    @Column(order = 235, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x17;

    public BizNumber getIwsMaitosikaiyakuhr2x17() {
        return iwsMaitosikaiyakuhr2x17;
    }

    public void setIwsMaitosikaiyakuhr2x17(BizNumber pIwsMaitosikaiyakuhr2x17) {
        iwsMaitosikaiyakuhr2x17 = pIwsMaitosikaiyakuhr2x17;
    }

    @Column(order = 236, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x18;

    public BizNumber getIwsMaitosikaiyakuhr2x18() {
        return iwsMaitosikaiyakuhr2x18;
    }

    public void setIwsMaitosikaiyakuhr2x18(BizNumber pIwsMaitosikaiyakuhr2x18) {
        iwsMaitosikaiyakuhr2x18 = pIwsMaitosikaiyakuhr2x18;
    }

    @Column(order = 237, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x19;

    public BizNumber getIwsMaitosikaiyakuhr2x19() {
        return iwsMaitosikaiyakuhr2x19;
    }

    public void setIwsMaitosikaiyakuhr2x19(BizNumber pIwsMaitosikaiyakuhr2x19) {
        iwsMaitosikaiyakuhr2x19 = pIwsMaitosikaiyakuhr2x19;
    }

    @Column(order = 238, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x20;

    public BizNumber getIwsMaitosikaiyakuhr2x20() {
        return iwsMaitosikaiyakuhr2x20;
    }

    public void setIwsMaitosikaiyakuhr2x20(BizNumber pIwsMaitosikaiyakuhr2x20) {
        iwsMaitosikaiyakuhr2x20 = pIwsMaitosikaiyakuhr2x20;
    }

    @Column(order = 239, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x21;

    public BizNumber getIwsMaitosikaiyakuhr2x21() {
        return iwsMaitosikaiyakuhr2x21;
    }

    public void setIwsMaitosikaiyakuhr2x21(BizNumber pIwsMaitosikaiyakuhr2x21) {
        iwsMaitosikaiyakuhr2x21 = pIwsMaitosikaiyakuhr2x21;
    }

    @Column(order = 240, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x22;

    public BizNumber getIwsMaitosikaiyakuhr2x22() {
        return iwsMaitosikaiyakuhr2x22;
    }

    public void setIwsMaitosikaiyakuhr2x22(BizNumber pIwsMaitosikaiyakuhr2x22) {
        iwsMaitosikaiyakuhr2x22 = pIwsMaitosikaiyakuhr2x22;
    }

    @Column(order = 241, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x23;

    public BizNumber getIwsMaitosikaiyakuhr2x23() {
        return iwsMaitosikaiyakuhr2x23;
    }

    public void setIwsMaitosikaiyakuhr2x23(BizNumber pIwsMaitosikaiyakuhr2x23) {
        iwsMaitosikaiyakuhr2x23 = pIwsMaitosikaiyakuhr2x23;
    }

    @Column(order = 242, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x24;

    public BizNumber getIwsMaitosikaiyakuhr2x24() {
        return iwsMaitosikaiyakuhr2x24;
    }

    public void setIwsMaitosikaiyakuhr2x24(BizNumber pIwsMaitosikaiyakuhr2x24) {
        iwsMaitosikaiyakuhr2x24 = pIwsMaitosikaiyakuhr2x24;
    }

    @Column(order = 243, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x25;

    public BizNumber getIwsMaitosikaiyakuhr2x25() {
        return iwsMaitosikaiyakuhr2x25;
    }

    public void setIwsMaitosikaiyakuhr2x25(BizNumber pIwsMaitosikaiyakuhr2x25) {
        iwsMaitosikaiyakuhr2x25 = pIwsMaitosikaiyakuhr2x25;
    }

    @Column(order = 244, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x26;

    public BizNumber getIwsMaitosikaiyakuhr2x26() {
        return iwsMaitosikaiyakuhr2x26;
    }

    public void setIwsMaitosikaiyakuhr2x26(BizNumber pIwsMaitosikaiyakuhr2x26) {
        iwsMaitosikaiyakuhr2x26 = pIwsMaitosikaiyakuhr2x26;
    }

    @Column(order = 245, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x27;

    public BizNumber getIwsMaitosikaiyakuhr2x27() {
        return iwsMaitosikaiyakuhr2x27;
    }

    public void setIwsMaitosikaiyakuhr2x27(BizNumber pIwsMaitosikaiyakuhr2x27) {
        iwsMaitosikaiyakuhr2x27 = pIwsMaitosikaiyakuhr2x27;
    }

    @Column(order = 246, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x28;

    public BizNumber getIwsMaitosikaiyakuhr2x28() {
        return iwsMaitosikaiyakuhr2x28;
    }

    public void setIwsMaitosikaiyakuhr2x28(BizNumber pIwsMaitosikaiyakuhr2x28) {
        iwsMaitosikaiyakuhr2x28 = pIwsMaitosikaiyakuhr2x28;
    }

    @Column(order = 247, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x29;

    public BizNumber getIwsMaitosikaiyakuhr2x29() {
        return iwsMaitosikaiyakuhr2x29;
    }

    public void setIwsMaitosikaiyakuhr2x29(BizNumber pIwsMaitosikaiyakuhr2x29) {
        iwsMaitosikaiyakuhr2x29 = pIwsMaitosikaiyakuhr2x29;
    }

    @Column(order = 248, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x30;

    public BizNumber getIwsMaitosikaiyakuhr2x30() {
        return iwsMaitosikaiyakuhr2x30;
    }

    public void setIwsMaitosikaiyakuhr2x30(BizNumber pIwsMaitosikaiyakuhr2x30) {
        iwsMaitosikaiyakuhr2x30 = pIwsMaitosikaiyakuhr2x30;
    }

    @Column(order = 249, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x31;

    public BizNumber getIwsMaitosikaiyakuhr2x31() {
        return iwsMaitosikaiyakuhr2x31;
    }

    public void setIwsMaitosikaiyakuhr2x31(BizNumber pIwsMaitosikaiyakuhr2x31) {
        iwsMaitosikaiyakuhr2x31 = pIwsMaitosikaiyakuhr2x31;
    }

    @Column(order = 250, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x32;

    public BizNumber getIwsMaitosikaiyakuhr2x32() {
        return iwsMaitosikaiyakuhr2x32;
    }

    public void setIwsMaitosikaiyakuhr2x32(BizNumber pIwsMaitosikaiyakuhr2x32) {
        iwsMaitosikaiyakuhr2x32 = pIwsMaitosikaiyakuhr2x32;
    }

    @Column(order = 251, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x33;

    public BizNumber getIwsMaitosikaiyakuhr2x33() {
        return iwsMaitosikaiyakuhr2x33;
    }

    public void setIwsMaitosikaiyakuhr2x33(BizNumber pIwsMaitosikaiyakuhr2x33) {
        iwsMaitosikaiyakuhr2x33 = pIwsMaitosikaiyakuhr2x33;
    }

    @Column(order = 252, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x34;

    public BizNumber getIwsMaitosikaiyakuhr2x34() {
        return iwsMaitosikaiyakuhr2x34;
    }

    public void setIwsMaitosikaiyakuhr2x34(BizNumber pIwsMaitosikaiyakuhr2x34) {
        iwsMaitosikaiyakuhr2x34 = pIwsMaitosikaiyakuhr2x34;
    }

    @Column(order = 253, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x35;

    public BizNumber getIwsMaitosikaiyakuhr2x35() {
        return iwsMaitosikaiyakuhr2x35;
    }

    public void setIwsMaitosikaiyakuhr2x35(BizNumber pIwsMaitosikaiyakuhr2x35) {
        iwsMaitosikaiyakuhr2x35 = pIwsMaitosikaiyakuhr2x35;
    }

    @Column(order = 254, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x36;

    public BizNumber getIwsMaitosikaiyakuhr2x36() {
        return iwsMaitosikaiyakuhr2x36;
    }

    public void setIwsMaitosikaiyakuhr2x36(BizNumber pIwsMaitosikaiyakuhr2x36) {
        iwsMaitosikaiyakuhr2x36 = pIwsMaitosikaiyakuhr2x36;
    }

    @Column(order = 255, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x37;

    public BizNumber getIwsMaitosikaiyakuhr2x37() {
        return iwsMaitosikaiyakuhr2x37;
    }

    public void setIwsMaitosikaiyakuhr2x37(BizNumber pIwsMaitosikaiyakuhr2x37) {
        iwsMaitosikaiyakuhr2x37 = pIwsMaitosikaiyakuhr2x37;
    }

    @Column(order = 256, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x38;

    public BizNumber getIwsMaitosikaiyakuhr2x38() {
        return iwsMaitosikaiyakuhr2x38;
    }

    public void setIwsMaitosikaiyakuhr2x38(BizNumber pIwsMaitosikaiyakuhr2x38) {
        iwsMaitosikaiyakuhr2x38 = pIwsMaitosikaiyakuhr2x38;
    }

    @Column(order = 257, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x39;

    public BizNumber getIwsMaitosikaiyakuhr2x39() {
        return iwsMaitosikaiyakuhr2x39;
    }

    public void setIwsMaitosikaiyakuhr2x39(BizNumber pIwsMaitosikaiyakuhr2x39) {
        iwsMaitosikaiyakuhr2x39 = pIwsMaitosikaiyakuhr2x39;
    }

    @Column(order = 258, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x40;

    public BizNumber getIwsMaitosikaiyakuhr2x40() {
        return iwsMaitosikaiyakuhr2x40;
    }

    public void setIwsMaitosikaiyakuhr2x40(BizNumber pIwsMaitosikaiyakuhr2x40) {
        iwsMaitosikaiyakuhr2x40 = pIwsMaitosikaiyakuhr2x40;
    }

    @Column(order = 259, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x41;

    public BizNumber getIwsMaitosikaiyakuhr2x41() {
        return iwsMaitosikaiyakuhr2x41;
    }

    public void setIwsMaitosikaiyakuhr2x41(BizNumber pIwsMaitosikaiyakuhr2x41) {
        iwsMaitosikaiyakuhr2x41 = pIwsMaitosikaiyakuhr2x41;
    }

    @Column(order = 260, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x42;

    public BizNumber getIwsMaitosikaiyakuhr2x42() {
        return iwsMaitosikaiyakuhr2x42;
    }

    public void setIwsMaitosikaiyakuhr2x42(BizNumber pIwsMaitosikaiyakuhr2x42) {
        iwsMaitosikaiyakuhr2x42 = pIwsMaitosikaiyakuhr2x42;
    }

    @Column(order = 261, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x43;

    public BizNumber getIwsMaitosikaiyakuhr2x43() {
        return iwsMaitosikaiyakuhr2x43;
    }

    public void setIwsMaitosikaiyakuhr2x43(BizNumber pIwsMaitosikaiyakuhr2x43) {
        iwsMaitosikaiyakuhr2x43 = pIwsMaitosikaiyakuhr2x43;
    }

    @Column(order = 262, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x44;

    public BizNumber getIwsMaitosikaiyakuhr2x44() {
        return iwsMaitosikaiyakuhr2x44;
    }

    public void setIwsMaitosikaiyakuhr2x44(BizNumber pIwsMaitosikaiyakuhr2x44) {
        iwsMaitosikaiyakuhr2x44 = pIwsMaitosikaiyakuhr2x44;
    }

    @Column(order = 263, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x45;

    public BizNumber getIwsMaitosikaiyakuhr2x45() {
        return iwsMaitosikaiyakuhr2x45;
    }

    public void setIwsMaitosikaiyakuhr2x45(BizNumber pIwsMaitosikaiyakuhr2x45) {
        iwsMaitosikaiyakuhr2x45 = pIwsMaitosikaiyakuhr2x45;
    }

    @Column(order = 264, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x46;

    public BizNumber getIwsMaitosikaiyakuhr2x46() {
        return iwsMaitosikaiyakuhr2x46;
    }

    public void setIwsMaitosikaiyakuhr2x46(BizNumber pIwsMaitosikaiyakuhr2x46) {
        iwsMaitosikaiyakuhr2x46 = pIwsMaitosikaiyakuhr2x46;
    }

    @Column(order = 265, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x47;

    public BizNumber getIwsMaitosikaiyakuhr2x47() {
        return iwsMaitosikaiyakuhr2x47;
    }

    public void setIwsMaitosikaiyakuhr2x47(BizNumber pIwsMaitosikaiyakuhr2x47) {
        iwsMaitosikaiyakuhr2x47 = pIwsMaitosikaiyakuhr2x47;
    }

    @Column(order = 266, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x48;

    public BizNumber getIwsMaitosikaiyakuhr2x48() {
        return iwsMaitosikaiyakuhr2x48;
    }

    public void setIwsMaitosikaiyakuhr2x48(BizNumber pIwsMaitosikaiyakuhr2x48) {
        iwsMaitosikaiyakuhr2x48 = pIwsMaitosikaiyakuhr2x48;
    }

    @Column(order = 267, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x49;

    public BizNumber getIwsMaitosikaiyakuhr2x49() {
        return iwsMaitosikaiyakuhr2x49;
    }

    public void setIwsMaitosikaiyakuhr2x49(BizNumber pIwsMaitosikaiyakuhr2x49) {
        iwsMaitosikaiyakuhr2x49 = pIwsMaitosikaiyakuhr2x49;
    }

    @Column(order = 268, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x50;

    public BizNumber getIwsMaitosikaiyakuhr2x50() {
        return iwsMaitosikaiyakuhr2x50;
    }

    public void setIwsMaitosikaiyakuhr2x50(BizNumber pIwsMaitosikaiyakuhr2x50) {
        iwsMaitosikaiyakuhr2x50 = pIwsMaitosikaiyakuhr2x50;
    }

    @Column(order = 269, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x51;

    public BizNumber getIwsMaitosikaiyakuhr2x51() {
        return iwsMaitosikaiyakuhr2x51;
    }

    public void setIwsMaitosikaiyakuhr2x51(BizNumber pIwsMaitosikaiyakuhr2x51) {
        iwsMaitosikaiyakuhr2x51 = pIwsMaitosikaiyakuhr2x51;
    }

    @Column(order = 270, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x52;

    public BizNumber getIwsMaitosikaiyakuhr2x52() {
        return iwsMaitosikaiyakuhr2x52;
    }

    public void setIwsMaitosikaiyakuhr2x52(BizNumber pIwsMaitosikaiyakuhr2x52) {
        iwsMaitosikaiyakuhr2x52 = pIwsMaitosikaiyakuhr2x52;
    }

    @Column(order = 271, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x53;

    public BizNumber getIwsMaitosikaiyakuhr2x53() {
        return iwsMaitosikaiyakuhr2x53;
    }

    public void setIwsMaitosikaiyakuhr2x53(BizNumber pIwsMaitosikaiyakuhr2x53) {
        iwsMaitosikaiyakuhr2x53 = pIwsMaitosikaiyakuhr2x53;
    }

    @Column(order = 272, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x54;

    public BizNumber getIwsMaitosikaiyakuhr2x54() {
        return iwsMaitosikaiyakuhr2x54;
    }

    public void setIwsMaitosikaiyakuhr2x54(BizNumber pIwsMaitosikaiyakuhr2x54) {
        iwsMaitosikaiyakuhr2x54 = pIwsMaitosikaiyakuhr2x54;
    }

    @Column(order = 273, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x55;

    public BizNumber getIwsMaitosikaiyakuhr2x55() {
        return iwsMaitosikaiyakuhr2x55;
    }

    public void setIwsMaitosikaiyakuhr2x55(BizNumber pIwsMaitosikaiyakuhr2x55) {
        iwsMaitosikaiyakuhr2x55 = pIwsMaitosikaiyakuhr2x55;
    }

    @Column(order = 274, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x56;

    public BizNumber getIwsMaitosikaiyakuhr2x56() {
        return iwsMaitosikaiyakuhr2x56;
    }

    public void setIwsMaitosikaiyakuhr2x56(BizNumber pIwsMaitosikaiyakuhr2x56) {
        iwsMaitosikaiyakuhr2x56 = pIwsMaitosikaiyakuhr2x56;
    }

    @Column(order = 275, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x57;

    public BizNumber getIwsMaitosikaiyakuhr2x57() {
        return iwsMaitosikaiyakuhr2x57;
    }

    public void setIwsMaitosikaiyakuhr2x57(BizNumber pIwsMaitosikaiyakuhr2x57) {
        iwsMaitosikaiyakuhr2x57 = pIwsMaitosikaiyakuhr2x57;
    }

    @Column(order = 276, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x58;

    public BizNumber getIwsMaitosikaiyakuhr2x58() {
        return iwsMaitosikaiyakuhr2x58;
    }

    public void setIwsMaitosikaiyakuhr2x58(BizNumber pIwsMaitosikaiyakuhr2x58) {
        iwsMaitosikaiyakuhr2x58 = pIwsMaitosikaiyakuhr2x58;
    }

    @Column(order = 277, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x59;

    public BizNumber getIwsMaitosikaiyakuhr2x59() {
        return iwsMaitosikaiyakuhr2x59;
    }

    public void setIwsMaitosikaiyakuhr2x59(BizNumber pIwsMaitosikaiyakuhr2x59) {
        iwsMaitosikaiyakuhr2x59 = pIwsMaitosikaiyakuhr2x59;
    }

    @Column(order = 278, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x60;

    public BizNumber getIwsMaitosikaiyakuhr2x60() {
        return iwsMaitosikaiyakuhr2x60;
    }

    public void setIwsMaitosikaiyakuhr2x60(BizNumber pIwsMaitosikaiyakuhr2x60) {
        iwsMaitosikaiyakuhr2x60 = pIwsMaitosikaiyakuhr2x60;
    }

    @Column(order = 279, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x61;

    public BizNumber getIwsMaitosikaiyakuhr2x61() {
        return iwsMaitosikaiyakuhr2x61;
    }

    public void setIwsMaitosikaiyakuhr2x61(BizNumber pIwsMaitosikaiyakuhr2x61) {
        iwsMaitosikaiyakuhr2x61 = pIwsMaitosikaiyakuhr2x61;
    }

    @Column(order = 280, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x62;

    public BizNumber getIwsMaitosikaiyakuhr2x62() {
        return iwsMaitosikaiyakuhr2x62;
    }

    public void setIwsMaitosikaiyakuhr2x62(BizNumber pIwsMaitosikaiyakuhr2x62) {
        iwsMaitosikaiyakuhr2x62 = pIwsMaitosikaiyakuhr2x62;
    }

    @Column(order = 281, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x63;

    public BizNumber getIwsMaitosikaiyakuhr2x63() {
        return iwsMaitosikaiyakuhr2x63;
    }

    public void setIwsMaitosikaiyakuhr2x63(BizNumber pIwsMaitosikaiyakuhr2x63) {
        iwsMaitosikaiyakuhr2x63 = pIwsMaitosikaiyakuhr2x63;
    }

    @Column(order = 282, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x64;

    public BizNumber getIwsMaitosikaiyakuhr2x64() {
        return iwsMaitosikaiyakuhr2x64;
    }

    public void setIwsMaitosikaiyakuhr2x64(BizNumber pIwsMaitosikaiyakuhr2x64) {
        iwsMaitosikaiyakuhr2x64 = pIwsMaitosikaiyakuhr2x64;
    }

    @Column(order = 283, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x65;

    public BizNumber getIwsMaitosikaiyakuhr2x65() {
        return iwsMaitosikaiyakuhr2x65;
    }

    public void setIwsMaitosikaiyakuhr2x65(BizNumber pIwsMaitosikaiyakuhr2x65) {
        iwsMaitosikaiyakuhr2x65 = pIwsMaitosikaiyakuhr2x65;
    }

    @Column(order = 284, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x1;

    public BizNumber getIwsMaitosikaiyakuhr3x1() {
        return iwsMaitosikaiyakuhr3x1;
    }

    public void setIwsMaitosikaiyakuhr3x1(BizNumber pIwsMaitosikaiyakuhr3x1) {
        iwsMaitosikaiyakuhr3x1 = pIwsMaitosikaiyakuhr3x1;
    }

    @Column(order = 285, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x2;

    public BizNumber getIwsMaitosikaiyakuhr3x2() {
        return iwsMaitosikaiyakuhr3x2;
    }

    public void setIwsMaitosikaiyakuhr3x2(BizNumber pIwsMaitosikaiyakuhr3x2) {
        iwsMaitosikaiyakuhr3x2 = pIwsMaitosikaiyakuhr3x2;
    }

    @Column(order = 286, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x3;

    public BizNumber getIwsMaitosikaiyakuhr3x3() {
        return iwsMaitosikaiyakuhr3x3;
    }

    public void setIwsMaitosikaiyakuhr3x3(BizNumber pIwsMaitosikaiyakuhr3x3) {
        iwsMaitosikaiyakuhr3x3 = pIwsMaitosikaiyakuhr3x3;
    }

    @Column(order = 287, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x4;

    public BizNumber getIwsMaitosikaiyakuhr3x4() {
        return iwsMaitosikaiyakuhr3x4;
    }

    public void setIwsMaitosikaiyakuhr3x4(BizNumber pIwsMaitosikaiyakuhr3x4) {
        iwsMaitosikaiyakuhr3x4 = pIwsMaitosikaiyakuhr3x4;
    }

    @Column(order = 288, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x5;

    public BizNumber getIwsMaitosikaiyakuhr3x5() {
        return iwsMaitosikaiyakuhr3x5;
    }

    public void setIwsMaitosikaiyakuhr3x5(BizNumber pIwsMaitosikaiyakuhr3x5) {
        iwsMaitosikaiyakuhr3x5 = pIwsMaitosikaiyakuhr3x5;
    }

    @Column(order = 289, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x6;

    public BizNumber getIwsMaitosikaiyakuhr3x6() {
        return iwsMaitosikaiyakuhr3x6;
    }

    public void setIwsMaitosikaiyakuhr3x6(BizNumber pIwsMaitosikaiyakuhr3x6) {
        iwsMaitosikaiyakuhr3x6 = pIwsMaitosikaiyakuhr3x6;
    }

    @Column(order = 290, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x7;

    public BizNumber getIwsMaitosikaiyakuhr3x7() {
        return iwsMaitosikaiyakuhr3x7;
    }

    public void setIwsMaitosikaiyakuhr3x7(BizNumber pIwsMaitosikaiyakuhr3x7) {
        iwsMaitosikaiyakuhr3x7 = pIwsMaitosikaiyakuhr3x7;
    }

    @Column(order = 291, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x8;

    public BizNumber getIwsMaitosikaiyakuhr3x8() {
        return iwsMaitosikaiyakuhr3x8;
    }

    public void setIwsMaitosikaiyakuhr3x8(BizNumber pIwsMaitosikaiyakuhr3x8) {
        iwsMaitosikaiyakuhr3x8 = pIwsMaitosikaiyakuhr3x8;
    }

    @Column(order = 292, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x9;

    public BizNumber getIwsMaitosikaiyakuhr3x9() {
        return iwsMaitosikaiyakuhr3x9;
    }

    public void setIwsMaitosikaiyakuhr3x9(BizNumber pIwsMaitosikaiyakuhr3x9) {
        iwsMaitosikaiyakuhr3x9 = pIwsMaitosikaiyakuhr3x9;
    }

    @Column(order = 293, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x10;

    public BizNumber getIwsMaitosikaiyakuhr3x10() {
        return iwsMaitosikaiyakuhr3x10;
    }

    public void setIwsMaitosikaiyakuhr3x10(BizNumber pIwsMaitosikaiyakuhr3x10) {
        iwsMaitosikaiyakuhr3x10 = pIwsMaitosikaiyakuhr3x10;
    }

    @Column(order = 294, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x11;

    public BizNumber getIwsMaitosikaiyakuhr3x11() {
        return iwsMaitosikaiyakuhr3x11;
    }

    public void setIwsMaitosikaiyakuhr3x11(BizNumber pIwsMaitosikaiyakuhr3x11) {
        iwsMaitosikaiyakuhr3x11 = pIwsMaitosikaiyakuhr3x11;
    }

    @Column(order = 295, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x12;

    public BizNumber getIwsMaitosikaiyakuhr3x12() {
        return iwsMaitosikaiyakuhr3x12;
    }

    public void setIwsMaitosikaiyakuhr3x12(BizNumber pIwsMaitosikaiyakuhr3x12) {
        iwsMaitosikaiyakuhr3x12 = pIwsMaitosikaiyakuhr3x12;
    }

    @Column(order = 296, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x13;

    public BizNumber getIwsMaitosikaiyakuhr3x13() {
        return iwsMaitosikaiyakuhr3x13;
    }

    public void setIwsMaitosikaiyakuhr3x13(BizNumber pIwsMaitosikaiyakuhr3x13) {
        iwsMaitosikaiyakuhr3x13 = pIwsMaitosikaiyakuhr3x13;
    }

    @Column(order = 297, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x14;

    public BizNumber getIwsMaitosikaiyakuhr3x14() {
        return iwsMaitosikaiyakuhr3x14;
    }

    public void setIwsMaitosikaiyakuhr3x14(BizNumber pIwsMaitosikaiyakuhr3x14) {
        iwsMaitosikaiyakuhr3x14 = pIwsMaitosikaiyakuhr3x14;
    }

    @Column(order = 298, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x15;

    public BizNumber getIwsMaitosikaiyakuhr3x15() {
        return iwsMaitosikaiyakuhr3x15;
    }

    public void setIwsMaitosikaiyakuhr3x15(BizNumber pIwsMaitosikaiyakuhr3x15) {
        iwsMaitosikaiyakuhr3x15 = pIwsMaitosikaiyakuhr3x15;
    }

    @Column(order = 299, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x16;

    public BizNumber getIwsMaitosikaiyakuhr3x16() {
        return iwsMaitosikaiyakuhr3x16;
    }

    public void setIwsMaitosikaiyakuhr3x16(BizNumber pIwsMaitosikaiyakuhr3x16) {
        iwsMaitosikaiyakuhr3x16 = pIwsMaitosikaiyakuhr3x16;
    }

    @Column(order = 300, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x17;

    public BizNumber getIwsMaitosikaiyakuhr3x17() {
        return iwsMaitosikaiyakuhr3x17;
    }

    public void setIwsMaitosikaiyakuhr3x17(BizNumber pIwsMaitosikaiyakuhr3x17) {
        iwsMaitosikaiyakuhr3x17 = pIwsMaitosikaiyakuhr3x17;
    }

    @Column(order = 301, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x18;

    public BizNumber getIwsMaitosikaiyakuhr3x18() {
        return iwsMaitosikaiyakuhr3x18;
    }

    public void setIwsMaitosikaiyakuhr3x18(BizNumber pIwsMaitosikaiyakuhr3x18) {
        iwsMaitosikaiyakuhr3x18 = pIwsMaitosikaiyakuhr3x18;
    }

    @Column(order = 302, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x19;

    public BizNumber getIwsMaitosikaiyakuhr3x19() {
        return iwsMaitosikaiyakuhr3x19;
    }

    public void setIwsMaitosikaiyakuhr3x19(BizNumber pIwsMaitosikaiyakuhr3x19) {
        iwsMaitosikaiyakuhr3x19 = pIwsMaitosikaiyakuhr3x19;
    }

    @Column(order = 303, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x20;

    public BizNumber getIwsMaitosikaiyakuhr3x20() {
        return iwsMaitosikaiyakuhr3x20;
    }

    public void setIwsMaitosikaiyakuhr3x20(BizNumber pIwsMaitosikaiyakuhr3x20) {
        iwsMaitosikaiyakuhr3x20 = pIwsMaitosikaiyakuhr3x20;
    }

    @Column(order = 304, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x21;

    public BizNumber getIwsMaitosikaiyakuhr3x21() {
        return iwsMaitosikaiyakuhr3x21;
    }

    public void setIwsMaitosikaiyakuhr3x21(BizNumber pIwsMaitosikaiyakuhr3x21) {
        iwsMaitosikaiyakuhr3x21 = pIwsMaitosikaiyakuhr3x21;
    }

    @Column(order = 305, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x22;

    public BizNumber getIwsMaitosikaiyakuhr3x22() {
        return iwsMaitosikaiyakuhr3x22;
    }

    public void setIwsMaitosikaiyakuhr3x22(BizNumber pIwsMaitosikaiyakuhr3x22) {
        iwsMaitosikaiyakuhr3x22 = pIwsMaitosikaiyakuhr3x22;
    }

    @Column(order = 306, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x23;

    public BizNumber getIwsMaitosikaiyakuhr3x23() {
        return iwsMaitosikaiyakuhr3x23;
    }

    public void setIwsMaitosikaiyakuhr3x23(BizNumber pIwsMaitosikaiyakuhr3x23) {
        iwsMaitosikaiyakuhr3x23 = pIwsMaitosikaiyakuhr3x23;
    }

    @Column(order = 307, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x24;

    public BizNumber getIwsMaitosikaiyakuhr3x24() {
        return iwsMaitosikaiyakuhr3x24;
    }

    public void setIwsMaitosikaiyakuhr3x24(BizNumber pIwsMaitosikaiyakuhr3x24) {
        iwsMaitosikaiyakuhr3x24 = pIwsMaitosikaiyakuhr3x24;
    }

    @Column(order = 308, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x25;

    public BizNumber getIwsMaitosikaiyakuhr3x25() {
        return iwsMaitosikaiyakuhr3x25;
    }

    public void setIwsMaitosikaiyakuhr3x25(BizNumber pIwsMaitosikaiyakuhr3x25) {
        iwsMaitosikaiyakuhr3x25 = pIwsMaitosikaiyakuhr3x25;
    }

    @Column(order = 309, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x26;

    public BizNumber getIwsMaitosikaiyakuhr3x26() {
        return iwsMaitosikaiyakuhr3x26;
    }

    public void setIwsMaitosikaiyakuhr3x26(BizNumber pIwsMaitosikaiyakuhr3x26) {
        iwsMaitosikaiyakuhr3x26 = pIwsMaitosikaiyakuhr3x26;
    }

    @Column(order = 310, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x27;

    public BizNumber getIwsMaitosikaiyakuhr3x27() {
        return iwsMaitosikaiyakuhr3x27;
    }

    public void setIwsMaitosikaiyakuhr3x27(BizNumber pIwsMaitosikaiyakuhr3x27) {
        iwsMaitosikaiyakuhr3x27 = pIwsMaitosikaiyakuhr3x27;
    }

    @Column(order = 311, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x28;

    public BizNumber getIwsMaitosikaiyakuhr3x28() {
        return iwsMaitosikaiyakuhr3x28;
    }

    public void setIwsMaitosikaiyakuhr3x28(BizNumber pIwsMaitosikaiyakuhr3x28) {
        iwsMaitosikaiyakuhr3x28 = pIwsMaitosikaiyakuhr3x28;
    }

    @Column(order = 312, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x29;

    public BizNumber getIwsMaitosikaiyakuhr3x29() {
        return iwsMaitosikaiyakuhr3x29;
    }

    public void setIwsMaitosikaiyakuhr3x29(BizNumber pIwsMaitosikaiyakuhr3x29) {
        iwsMaitosikaiyakuhr3x29 = pIwsMaitosikaiyakuhr3x29;
    }

    @Column(order = 313, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x30;

    public BizNumber getIwsMaitosikaiyakuhr3x30() {
        return iwsMaitosikaiyakuhr3x30;
    }

    public void setIwsMaitosikaiyakuhr3x30(BizNumber pIwsMaitosikaiyakuhr3x30) {
        iwsMaitosikaiyakuhr3x30 = pIwsMaitosikaiyakuhr3x30;
    }

    @Column(order = 314, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x31;

    public BizNumber getIwsMaitosikaiyakuhr3x31() {
        return iwsMaitosikaiyakuhr3x31;
    }

    public void setIwsMaitosikaiyakuhr3x31(BizNumber pIwsMaitosikaiyakuhr3x31) {
        iwsMaitosikaiyakuhr3x31 = pIwsMaitosikaiyakuhr3x31;
    }

    @Column(order = 315, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x32;

    public BizNumber getIwsMaitosikaiyakuhr3x32() {
        return iwsMaitosikaiyakuhr3x32;
    }

    public void setIwsMaitosikaiyakuhr3x32(BizNumber pIwsMaitosikaiyakuhr3x32) {
        iwsMaitosikaiyakuhr3x32 = pIwsMaitosikaiyakuhr3x32;
    }

    @Column(order = 316, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x33;

    public BizNumber getIwsMaitosikaiyakuhr3x33() {
        return iwsMaitosikaiyakuhr3x33;
    }

    public void setIwsMaitosikaiyakuhr3x33(BizNumber pIwsMaitosikaiyakuhr3x33) {
        iwsMaitosikaiyakuhr3x33 = pIwsMaitosikaiyakuhr3x33;
    }

    @Column(order = 317, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x34;

    public BizNumber getIwsMaitosikaiyakuhr3x34() {
        return iwsMaitosikaiyakuhr3x34;
    }

    public void setIwsMaitosikaiyakuhr3x34(BizNumber pIwsMaitosikaiyakuhr3x34) {
        iwsMaitosikaiyakuhr3x34 = pIwsMaitosikaiyakuhr3x34;
    }

    @Column(order = 318, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x35;

    public BizNumber getIwsMaitosikaiyakuhr3x35() {
        return iwsMaitosikaiyakuhr3x35;
    }

    public void setIwsMaitosikaiyakuhr3x35(BizNumber pIwsMaitosikaiyakuhr3x35) {
        iwsMaitosikaiyakuhr3x35 = pIwsMaitosikaiyakuhr3x35;
    }

    @Column(order = 319, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x36;

    public BizNumber getIwsMaitosikaiyakuhr3x36() {
        return iwsMaitosikaiyakuhr3x36;
    }

    public void setIwsMaitosikaiyakuhr3x36(BizNumber pIwsMaitosikaiyakuhr3x36) {
        iwsMaitosikaiyakuhr3x36 = pIwsMaitosikaiyakuhr3x36;
    }

    @Column(order = 320, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x37;

    public BizNumber getIwsMaitosikaiyakuhr3x37() {
        return iwsMaitosikaiyakuhr3x37;
    }

    public void setIwsMaitosikaiyakuhr3x37(BizNumber pIwsMaitosikaiyakuhr3x37) {
        iwsMaitosikaiyakuhr3x37 = pIwsMaitosikaiyakuhr3x37;
    }

    @Column(order = 321, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x38;

    public BizNumber getIwsMaitosikaiyakuhr3x38() {
        return iwsMaitosikaiyakuhr3x38;
    }

    public void setIwsMaitosikaiyakuhr3x38(BizNumber pIwsMaitosikaiyakuhr3x38) {
        iwsMaitosikaiyakuhr3x38 = pIwsMaitosikaiyakuhr3x38;
    }

    @Column(order = 322, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x39;

    public BizNumber getIwsMaitosikaiyakuhr3x39() {
        return iwsMaitosikaiyakuhr3x39;
    }

    public void setIwsMaitosikaiyakuhr3x39(BizNumber pIwsMaitosikaiyakuhr3x39) {
        iwsMaitosikaiyakuhr3x39 = pIwsMaitosikaiyakuhr3x39;
    }

    @Column(order = 323, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x40;

    public BizNumber getIwsMaitosikaiyakuhr3x40() {
        return iwsMaitosikaiyakuhr3x40;
    }

    public void setIwsMaitosikaiyakuhr3x40(BizNumber pIwsMaitosikaiyakuhr3x40) {
        iwsMaitosikaiyakuhr3x40 = pIwsMaitosikaiyakuhr3x40;
    }

    @Column(order = 324, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x41;

    public BizNumber getIwsMaitosikaiyakuhr3x41() {
        return iwsMaitosikaiyakuhr3x41;
    }

    public void setIwsMaitosikaiyakuhr3x41(BizNumber pIwsMaitosikaiyakuhr3x41) {
        iwsMaitosikaiyakuhr3x41 = pIwsMaitosikaiyakuhr3x41;
    }

    @Column(order = 325, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x42;

    public BizNumber getIwsMaitosikaiyakuhr3x42() {
        return iwsMaitosikaiyakuhr3x42;
    }

    public void setIwsMaitosikaiyakuhr3x42(BizNumber pIwsMaitosikaiyakuhr3x42) {
        iwsMaitosikaiyakuhr3x42 = pIwsMaitosikaiyakuhr3x42;
    }

    @Column(order = 326, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x43;

    public BizNumber getIwsMaitosikaiyakuhr3x43() {
        return iwsMaitosikaiyakuhr3x43;
    }

    public void setIwsMaitosikaiyakuhr3x43(BizNumber pIwsMaitosikaiyakuhr3x43) {
        iwsMaitosikaiyakuhr3x43 = pIwsMaitosikaiyakuhr3x43;
    }

    @Column(order = 327, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x44;

    public BizNumber getIwsMaitosikaiyakuhr3x44() {
        return iwsMaitosikaiyakuhr3x44;
    }

    public void setIwsMaitosikaiyakuhr3x44(BizNumber pIwsMaitosikaiyakuhr3x44) {
        iwsMaitosikaiyakuhr3x44 = pIwsMaitosikaiyakuhr3x44;
    }

    @Column(order = 328, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x45;

    public BizNumber getIwsMaitosikaiyakuhr3x45() {
        return iwsMaitosikaiyakuhr3x45;
    }

    public void setIwsMaitosikaiyakuhr3x45(BizNumber pIwsMaitosikaiyakuhr3x45) {
        iwsMaitosikaiyakuhr3x45 = pIwsMaitosikaiyakuhr3x45;
    }

    @Column(order = 329, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x46;

    public BizNumber getIwsMaitosikaiyakuhr3x46() {
        return iwsMaitosikaiyakuhr3x46;
    }

    public void setIwsMaitosikaiyakuhr3x46(BizNumber pIwsMaitosikaiyakuhr3x46) {
        iwsMaitosikaiyakuhr3x46 = pIwsMaitosikaiyakuhr3x46;
    }

    @Column(order = 330, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x47;

    public BizNumber getIwsMaitosikaiyakuhr3x47() {
        return iwsMaitosikaiyakuhr3x47;
    }

    public void setIwsMaitosikaiyakuhr3x47(BizNumber pIwsMaitosikaiyakuhr3x47) {
        iwsMaitosikaiyakuhr3x47 = pIwsMaitosikaiyakuhr3x47;
    }

    @Column(order = 331, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x48;

    public BizNumber getIwsMaitosikaiyakuhr3x48() {
        return iwsMaitosikaiyakuhr3x48;
    }

    public void setIwsMaitosikaiyakuhr3x48(BizNumber pIwsMaitosikaiyakuhr3x48) {
        iwsMaitosikaiyakuhr3x48 = pIwsMaitosikaiyakuhr3x48;
    }

    @Column(order = 332, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x49;

    public BizNumber getIwsMaitosikaiyakuhr3x49() {
        return iwsMaitosikaiyakuhr3x49;
    }

    public void setIwsMaitosikaiyakuhr3x49(BizNumber pIwsMaitosikaiyakuhr3x49) {
        iwsMaitosikaiyakuhr3x49 = pIwsMaitosikaiyakuhr3x49;
    }

    @Column(order = 333, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x50;

    public BizNumber getIwsMaitosikaiyakuhr3x50() {
        return iwsMaitosikaiyakuhr3x50;
    }

    public void setIwsMaitosikaiyakuhr3x50(BizNumber pIwsMaitosikaiyakuhr3x50) {
        iwsMaitosikaiyakuhr3x50 = pIwsMaitosikaiyakuhr3x50;
    }

    @Column(order = 334, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x51;

    public BizNumber getIwsMaitosikaiyakuhr3x51() {
        return iwsMaitosikaiyakuhr3x51;
    }

    public void setIwsMaitosikaiyakuhr3x51(BizNumber pIwsMaitosikaiyakuhr3x51) {
        iwsMaitosikaiyakuhr3x51 = pIwsMaitosikaiyakuhr3x51;
    }

    @Column(order = 335, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x52;

    public BizNumber getIwsMaitosikaiyakuhr3x52() {
        return iwsMaitosikaiyakuhr3x52;
    }

    public void setIwsMaitosikaiyakuhr3x52(BizNumber pIwsMaitosikaiyakuhr3x52) {
        iwsMaitosikaiyakuhr3x52 = pIwsMaitosikaiyakuhr3x52;
    }

    @Column(order = 336, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x53;

    public BizNumber getIwsMaitosikaiyakuhr3x53() {
        return iwsMaitosikaiyakuhr3x53;
    }

    public void setIwsMaitosikaiyakuhr3x53(BizNumber pIwsMaitosikaiyakuhr3x53) {
        iwsMaitosikaiyakuhr3x53 = pIwsMaitosikaiyakuhr3x53;
    }

    @Column(order = 337, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x54;

    public BizNumber getIwsMaitosikaiyakuhr3x54() {
        return iwsMaitosikaiyakuhr3x54;
    }

    public void setIwsMaitosikaiyakuhr3x54(BizNumber pIwsMaitosikaiyakuhr3x54) {
        iwsMaitosikaiyakuhr3x54 = pIwsMaitosikaiyakuhr3x54;
    }

    @Column(order = 338, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x55;

    public BizNumber getIwsMaitosikaiyakuhr3x55() {
        return iwsMaitosikaiyakuhr3x55;
    }

    public void setIwsMaitosikaiyakuhr3x55(BizNumber pIwsMaitosikaiyakuhr3x55) {
        iwsMaitosikaiyakuhr3x55 = pIwsMaitosikaiyakuhr3x55;
    }

    @Column(order = 339, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x56;

    public BizNumber getIwsMaitosikaiyakuhr3x56() {
        return iwsMaitosikaiyakuhr3x56;
    }

    public void setIwsMaitosikaiyakuhr3x56(BizNumber pIwsMaitosikaiyakuhr3x56) {
        iwsMaitosikaiyakuhr3x56 = pIwsMaitosikaiyakuhr3x56;
    }

    @Column(order = 340, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x57;

    public BizNumber getIwsMaitosikaiyakuhr3x57() {
        return iwsMaitosikaiyakuhr3x57;
    }

    public void setIwsMaitosikaiyakuhr3x57(BizNumber pIwsMaitosikaiyakuhr3x57) {
        iwsMaitosikaiyakuhr3x57 = pIwsMaitosikaiyakuhr3x57;
    }

    @Column(order = 341, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x58;

    public BizNumber getIwsMaitosikaiyakuhr3x58() {
        return iwsMaitosikaiyakuhr3x58;
    }

    public void setIwsMaitosikaiyakuhr3x58(BizNumber pIwsMaitosikaiyakuhr3x58) {
        iwsMaitosikaiyakuhr3x58 = pIwsMaitosikaiyakuhr3x58;
    }

    @Column(order = 342, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x59;

    public BizNumber getIwsMaitosikaiyakuhr3x59() {
        return iwsMaitosikaiyakuhr3x59;
    }

    public void setIwsMaitosikaiyakuhr3x59(BizNumber pIwsMaitosikaiyakuhr3x59) {
        iwsMaitosikaiyakuhr3x59 = pIwsMaitosikaiyakuhr3x59;
    }

    @Column(order = 343, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x60;

    public BizNumber getIwsMaitosikaiyakuhr3x60() {
        return iwsMaitosikaiyakuhr3x60;
    }

    public void setIwsMaitosikaiyakuhr3x60(BizNumber pIwsMaitosikaiyakuhr3x60) {
        iwsMaitosikaiyakuhr3x60 = pIwsMaitosikaiyakuhr3x60;
    }

    @Column(order = 344, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x61;

    public BizNumber getIwsMaitosikaiyakuhr3x61() {
        return iwsMaitosikaiyakuhr3x61;
    }

    public void setIwsMaitosikaiyakuhr3x61(BizNumber pIwsMaitosikaiyakuhr3x61) {
        iwsMaitosikaiyakuhr3x61 = pIwsMaitosikaiyakuhr3x61;
    }

    @Column(order = 345, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x62;

    public BizNumber getIwsMaitosikaiyakuhr3x62() {
        return iwsMaitosikaiyakuhr3x62;
    }

    public void setIwsMaitosikaiyakuhr3x62(BizNumber pIwsMaitosikaiyakuhr3x62) {
        iwsMaitosikaiyakuhr3x62 = pIwsMaitosikaiyakuhr3x62;
    }

    @Column(order = 346, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x63;

    public BizNumber getIwsMaitosikaiyakuhr3x63() {
        return iwsMaitosikaiyakuhr3x63;
    }

    public void setIwsMaitosikaiyakuhr3x63(BizNumber pIwsMaitosikaiyakuhr3x63) {
        iwsMaitosikaiyakuhr3x63 = pIwsMaitosikaiyakuhr3x63;
    }

    @Column(order = 347, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x64;

    public BizNumber getIwsMaitosikaiyakuhr3x64() {
        return iwsMaitosikaiyakuhr3x64;
    }

    public void setIwsMaitosikaiyakuhr3x64(BizNumber pIwsMaitosikaiyakuhr3x64) {
        iwsMaitosikaiyakuhr3x64 = pIwsMaitosikaiyakuhr3x64;
    }

    @Column(order = 348, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x65;

    public BizNumber getIwsMaitosikaiyakuhr3x65() {
        return iwsMaitosikaiyakuhr3x65;
    }

    public void setIwsMaitosikaiyakuhr3x65(BizNumber pIwsMaitosikaiyakuhr3x65) {
        iwsMaitosikaiyakuhr3x65 = pIwsMaitosikaiyakuhr3x65;
    }

    @Column(order = 349, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x1;

    public BizNumber getIwsMaitosisbkyhkn1x1() {
        return iwsMaitosisbkyhkn1x1;
    }

    public void setIwsMaitosisbkyhkn1x1(BizNumber pIwsMaitosisbkyhkn1x1) {
        iwsMaitosisbkyhkn1x1 = pIwsMaitosisbkyhkn1x1;
    }

    @Column(order = 350, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x2;

    public BizNumber getIwsMaitosisbkyhkn1x2() {
        return iwsMaitosisbkyhkn1x2;
    }

    public void setIwsMaitosisbkyhkn1x2(BizNumber pIwsMaitosisbkyhkn1x2) {
        iwsMaitosisbkyhkn1x2 = pIwsMaitosisbkyhkn1x2;
    }

    @Column(order = 351, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x3;

    public BizNumber getIwsMaitosisbkyhkn1x3() {
        return iwsMaitosisbkyhkn1x3;
    }

    public void setIwsMaitosisbkyhkn1x3(BizNumber pIwsMaitosisbkyhkn1x3) {
        iwsMaitosisbkyhkn1x3 = pIwsMaitosisbkyhkn1x3;
    }

    @Column(order = 352, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x4;

    public BizNumber getIwsMaitosisbkyhkn1x4() {
        return iwsMaitosisbkyhkn1x4;
    }

    public void setIwsMaitosisbkyhkn1x4(BizNumber pIwsMaitosisbkyhkn1x4) {
        iwsMaitosisbkyhkn1x4 = pIwsMaitosisbkyhkn1x4;
    }

    @Column(order = 353, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x5;

    public BizNumber getIwsMaitosisbkyhkn1x5() {
        return iwsMaitosisbkyhkn1x5;
    }

    public void setIwsMaitosisbkyhkn1x5(BizNumber pIwsMaitosisbkyhkn1x5) {
        iwsMaitosisbkyhkn1x5 = pIwsMaitosisbkyhkn1x5;
    }

    @Column(order = 354, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x6;

    public BizNumber getIwsMaitosisbkyhkn1x6() {
        return iwsMaitosisbkyhkn1x6;
    }

    public void setIwsMaitosisbkyhkn1x6(BizNumber pIwsMaitosisbkyhkn1x6) {
        iwsMaitosisbkyhkn1x6 = pIwsMaitosisbkyhkn1x6;
    }

    @Column(order = 355, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x7;

    public BizNumber getIwsMaitosisbkyhkn1x7() {
        return iwsMaitosisbkyhkn1x7;
    }

    public void setIwsMaitosisbkyhkn1x7(BizNumber pIwsMaitosisbkyhkn1x7) {
        iwsMaitosisbkyhkn1x7 = pIwsMaitosisbkyhkn1x7;
    }

    @Column(order = 356, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x8;

    public BizNumber getIwsMaitosisbkyhkn1x8() {
        return iwsMaitosisbkyhkn1x8;
    }

    public void setIwsMaitosisbkyhkn1x8(BizNumber pIwsMaitosisbkyhkn1x8) {
        iwsMaitosisbkyhkn1x8 = pIwsMaitosisbkyhkn1x8;
    }

    @Column(order = 357, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x9;

    public BizNumber getIwsMaitosisbkyhkn1x9() {
        return iwsMaitosisbkyhkn1x9;
    }

    public void setIwsMaitosisbkyhkn1x9(BizNumber pIwsMaitosisbkyhkn1x9) {
        iwsMaitosisbkyhkn1x9 = pIwsMaitosisbkyhkn1x9;
    }

    @Column(order = 358, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x10;

    public BizNumber getIwsMaitosisbkyhkn1x10() {
        return iwsMaitosisbkyhkn1x10;
    }

    public void setIwsMaitosisbkyhkn1x10(BizNumber pIwsMaitosisbkyhkn1x10) {
        iwsMaitosisbkyhkn1x10 = pIwsMaitosisbkyhkn1x10;
    }

    @Column(order = 359, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x11;

    public BizNumber getIwsMaitosisbkyhkn1x11() {
        return iwsMaitosisbkyhkn1x11;
    }

    public void setIwsMaitosisbkyhkn1x11(BizNumber pIwsMaitosisbkyhkn1x11) {
        iwsMaitosisbkyhkn1x11 = pIwsMaitosisbkyhkn1x11;
    }

    @Column(order = 360, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x12;

    public BizNumber getIwsMaitosisbkyhkn1x12() {
        return iwsMaitosisbkyhkn1x12;
    }

    public void setIwsMaitosisbkyhkn1x12(BizNumber pIwsMaitosisbkyhkn1x12) {
        iwsMaitosisbkyhkn1x12 = pIwsMaitosisbkyhkn1x12;
    }

    @Column(order = 361, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x13;

    public BizNumber getIwsMaitosisbkyhkn1x13() {
        return iwsMaitosisbkyhkn1x13;
    }

    public void setIwsMaitosisbkyhkn1x13(BizNumber pIwsMaitosisbkyhkn1x13) {
        iwsMaitosisbkyhkn1x13 = pIwsMaitosisbkyhkn1x13;
    }

    @Column(order = 362, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x14;

    public BizNumber getIwsMaitosisbkyhkn1x14() {
        return iwsMaitosisbkyhkn1x14;
    }

    public void setIwsMaitosisbkyhkn1x14(BizNumber pIwsMaitosisbkyhkn1x14) {
        iwsMaitosisbkyhkn1x14 = pIwsMaitosisbkyhkn1x14;
    }

    @Column(order = 363, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x15;

    public BizNumber getIwsMaitosisbkyhkn1x15() {
        return iwsMaitosisbkyhkn1x15;
    }

    public void setIwsMaitosisbkyhkn1x15(BizNumber pIwsMaitosisbkyhkn1x15) {
        iwsMaitosisbkyhkn1x15 = pIwsMaitosisbkyhkn1x15;
    }

    @Column(order = 364, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x16;

    public BizNumber getIwsMaitosisbkyhkn1x16() {
        return iwsMaitosisbkyhkn1x16;
    }

    public void setIwsMaitosisbkyhkn1x16(BizNumber pIwsMaitosisbkyhkn1x16) {
        iwsMaitosisbkyhkn1x16 = pIwsMaitosisbkyhkn1x16;
    }

    @Column(order = 365, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x17;

    public BizNumber getIwsMaitosisbkyhkn1x17() {
        return iwsMaitosisbkyhkn1x17;
    }

    public void setIwsMaitosisbkyhkn1x17(BizNumber pIwsMaitosisbkyhkn1x17) {
        iwsMaitosisbkyhkn1x17 = pIwsMaitosisbkyhkn1x17;
    }

    @Column(order = 366, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x18;

    public BizNumber getIwsMaitosisbkyhkn1x18() {
        return iwsMaitosisbkyhkn1x18;
    }

    public void setIwsMaitosisbkyhkn1x18(BizNumber pIwsMaitosisbkyhkn1x18) {
        iwsMaitosisbkyhkn1x18 = pIwsMaitosisbkyhkn1x18;
    }

    @Column(order = 367, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x19;

    public BizNumber getIwsMaitosisbkyhkn1x19() {
        return iwsMaitosisbkyhkn1x19;
    }

    public void setIwsMaitosisbkyhkn1x19(BizNumber pIwsMaitosisbkyhkn1x19) {
        iwsMaitosisbkyhkn1x19 = pIwsMaitosisbkyhkn1x19;
    }

    @Column(order = 368, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x20;

    public BizNumber getIwsMaitosisbkyhkn1x20() {
        return iwsMaitosisbkyhkn1x20;
    }

    public void setIwsMaitosisbkyhkn1x20(BizNumber pIwsMaitosisbkyhkn1x20) {
        iwsMaitosisbkyhkn1x20 = pIwsMaitosisbkyhkn1x20;
    }

    @Column(order = 369, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x21;

    public BizNumber getIwsMaitosisbkyhkn1x21() {
        return iwsMaitosisbkyhkn1x21;
    }

    public void setIwsMaitosisbkyhkn1x21(BizNumber pIwsMaitosisbkyhkn1x21) {
        iwsMaitosisbkyhkn1x21 = pIwsMaitosisbkyhkn1x21;
    }

    @Column(order = 370, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x22;

    public BizNumber getIwsMaitosisbkyhkn1x22() {
        return iwsMaitosisbkyhkn1x22;
    }

    public void setIwsMaitosisbkyhkn1x22(BizNumber pIwsMaitosisbkyhkn1x22) {
        iwsMaitosisbkyhkn1x22 = pIwsMaitosisbkyhkn1x22;
    }

    @Column(order = 371, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x23;

    public BizNumber getIwsMaitosisbkyhkn1x23() {
        return iwsMaitosisbkyhkn1x23;
    }

    public void setIwsMaitosisbkyhkn1x23(BizNumber pIwsMaitosisbkyhkn1x23) {
        iwsMaitosisbkyhkn1x23 = pIwsMaitosisbkyhkn1x23;
    }

    @Column(order = 372, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x24;

    public BizNumber getIwsMaitosisbkyhkn1x24() {
        return iwsMaitosisbkyhkn1x24;
    }

    public void setIwsMaitosisbkyhkn1x24(BizNumber pIwsMaitosisbkyhkn1x24) {
        iwsMaitosisbkyhkn1x24 = pIwsMaitosisbkyhkn1x24;
    }

    @Column(order = 373, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x25;

    public BizNumber getIwsMaitosisbkyhkn1x25() {
        return iwsMaitosisbkyhkn1x25;
    }

    public void setIwsMaitosisbkyhkn1x25(BizNumber pIwsMaitosisbkyhkn1x25) {
        iwsMaitosisbkyhkn1x25 = pIwsMaitosisbkyhkn1x25;
    }

    @Column(order = 374, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x26;

    public BizNumber getIwsMaitosisbkyhkn1x26() {
        return iwsMaitosisbkyhkn1x26;
    }

    public void setIwsMaitosisbkyhkn1x26(BizNumber pIwsMaitosisbkyhkn1x26) {
        iwsMaitosisbkyhkn1x26 = pIwsMaitosisbkyhkn1x26;
    }

    @Column(order = 375, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x27;

    public BizNumber getIwsMaitosisbkyhkn1x27() {
        return iwsMaitosisbkyhkn1x27;
    }

    public void setIwsMaitosisbkyhkn1x27(BizNumber pIwsMaitosisbkyhkn1x27) {
        iwsMaitosisbkyhkn1x27 = pIwsMaitosisbkyhkn1x27;
    }

    @Column(order = 376, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x28;

    public BizNumber getIwsMaitosisbkyhkn1x28() {
        return iwsMaitosisbkyhkn1x28;
    }

    public void setIwsMaitosisbkyhkn1x28(BizNumber pIwsMaitosisbkyhkn1x28) {
        iwsMaitosisbkyhkn1x28 = pIwsMaitosisbkyhkn1x28;
    }

    @Column(order = 377, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x29;

    public BizNumber getIwsMaitosisbkyhkn1x29() {
        return iwsMaitosisbkyhkn1x29;
    }

    public void setIwsMaitosisbkyhkn1x29(BizNumber pIwsMaitosisbkyhkn1x29) {
        iwsMaitosisbkyhkn1x29 = pIwsMaitosisbkyhkn1x29;
    }

    @Column(order = 378, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x30;

    public BizNumber getIwsMaitosisbkyhkn1x30() {
        return iwsMaitosisbkyhkn1x30;
    }

    public void setIwsMaitosisbkyhkn1x30(BizNumber pIwsMaitosisbkyhkn1x30) {
        iwsMaitosisbkyhkn1x30 = pIwsMaitosisbkyhkn1x30;
    }

    @Column(order = 379, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x31;

    public BizNumber getIwsMaitosisbkyhkn1x31() {
        return iwsMaitosisbkyhkn1x31;
    }

    public void setIwsMaitosisbkyhkn1x31(BizNumber pIwsMaitosisbkyhkn1x31) {
        iwsMaitosisbkyhkn1x31 = pIwsMaitosisbkyhkn1x31;
    }

    @Column(order = 380, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x32;

    public BizNumber getIwsMaitosisbkyhkn1x32() {
        return iwsMaitosisbkyhkn1x32;
    }

    public void setIwsMaitosisbkyhkn1x32(BizNumber pIwsMaitosisbkyhkn1x32) {
        iwsMaitosisbkyhkn1x32 = pIwsMaitosisbkyhkn1x32;
    }

    @Column(order = 381, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x33;

    public BizNumber getIwsMaitosisbkyhkn1x33() {
        return iwsMaitosisbkyhkn1x33;
    }

    public void setIwsMaitosisbkyhkn1x33(BizNumber pIwsMaitosisbkyhkn1x33) {
        iwsMaitosisbkyhkn1x33 = pIwsMaitosisbkyhkn1x33;
    }

    @Column(order = 382, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x34;

    public BizNumber getIwsMaitosisbkyhkn1x34() {
        return iwsMaitosisbkyhkn1x34;
    }

    public void setIwsMaitosisbkyhkn1x34(BizNumber pIwsMaitosisbkyhkn1x34) {
        iwsMaitosisbkyhkn1x34 = pIwsMaitosisbkyhkn1x34;
    }

    @Column(order = 383, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x35;

    public BizNumber getIwsMaitosisbkyhkn1x35() {
        return iwsMaitosisbkyhkn1x35;
    }

    public void setIwsMaitosisbkyhkn1x35(BizNumber pIwsMaitosisbkyhkn1x35) {
        iwsMaitosisbkyhkn1x35 = pIwsMaitosisbkyhkn1x35;
    }

    @Column(order = 384, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x36;

    public BizNumber getIwsMaitosisbkyhkn1x36() {
        return iwsMaitosisbkyhkn1x36;
    }

    public void setIwsMaitosisbkyhkn1x36(BizNumber pIwsMaitosisbkyhkn1x36) {
        iwsMaitosisbkyhkn1x36 = pIwsMaitosisbkyhkn1x36;
    }

    @Column(order = 385, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x37;

    public BizNumber getIwsMaitosisbkyhkn1x37() {
        return iwsMaitosisbkyhkn1x37;
    }

    public void setIwsMaitosisbkyhkn1x37(BizNumber pIwsMaitosisbkyhkn1x37) {
        iwsMaitosisbkyhkn1x37 = pIwsMaitosisbkyhkn1x37;
    }

    @Column(order = 386, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x38;

    public BizNumber getIwsMaitosisbkyhkn1x38() {
        return iwsMaitosisbkyhkn1x38;
    }

    public void setIwsMaitosisbkyhkn1x38(BizNumber pIwsMaitosisbkyhkn1x38) {
        iwsMaitosisbkyhkn1x38 = pIwsMaitosisbkyhkn1x38;
    }

    @Column(order = 387, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x39;

    public BizNumber getIwsMaitosisbkyhkn1x39() {
        return iwsMaitosisbkyhkn1x39;
    }

    public void setIwsMaitosisbkyhkn1x39(BizNumber pIwsMaitosisbkyhkn1x39) {
        iwsMaitosisbkyhkn1x39 = pIwsMaitosisbkyhkn1x39;
    }

    @Column(order = 388, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x40;

    public BizNumber getIwsMaitosisbkyhkn1x40() {
        return iwsMaitosisbkyhkn1x40;
    }

    public void setIwsMaitosisbkyhkn1x40(BizNumber pIwsMaitosisbkyhkn1x40) {
        iwsMaitosisbkyhkn1x40 = pIwsMaitosisbkyhkn1x40;
    }

    @Column(order = 389, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x41;

    public BizNumber getIwsMaitosisbkyhkn1x41() {
        return iwsMaitosisbkyhkn1x41;
    }

    public void setIwsMaitosisbkyhkn1x41(BizNumber pIwsMaitosisbkyhkn1x41) {
        iwsMaitosisbkyhkn1x41 = pIwsMaitosisbkyhkn1x41;
    }

    @Column(order = 390, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x42;

    public BizNumber getIwsMaitosisbkyhkn1x42() {
        return iwsMaitosisbkyhkn1x42;
    }

    public void setIwsMaitosisbkyhkn1x42(BizNumber pIwsMaitosisbkyhkn1x42) {
        iwsMaitosisbkyhkn1x42 = pIwsMaitosisbkyhkn1x42;
    }

    @Column(order = 391, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x43;

    public BizNumber getIwsMaitosisbkyhkn1x43() {
        return iwsMaitosisbkyhkn1x43;
    }

    public void setIwsMaitosisbkyhkn1x43(BizNumber pIwsMaitosisbkyhkn1x43) {
        iwsMaitosisbkyhkn1x43 = pIwsMaitosisbkyhkn1x43;
    }

    @Column(order = 392, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x44;

    public BizNumber getIwsMaitosisbkyhkn1x44() {
        return iwsMaitosisbkyhkn1x44;
    }

    public void setIwsMaitosisbkyhkn1x44(BizNumber pIwsMaitosisbkyhkn1x44) {
        iwsMaitosisbkyhkn1x44 = pIwsMaitosisbkyhkn1x44;
    }

    @Column(order = 393, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x45;

    public BizNumber getIwsMaitosisbkyhkn1x45() {
        return iwsMaitosisbkyhkn1x45;
    }

    public void setIwsMaitosisbkyhkn1x45(BizNumber pIwsMaitosisbkyhkn1x45) {
        iwsMaitosisbkyhkn1x45 = pIwsMaitosisbkyhkn1x45;
    }

    @Column(order = 394, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x46;

    public BizNumber getIwsMaitosisbkyhkn1x46() {
        return iwsMaitosisbkyhkn1x46;
    }

    public void setIwsMaitosisbkyhkn1x46(BizNumber pIwsMaitosisbkyhkn1x46) {
        iwsMaitosisbkyhkn1x46 = pIwsMaitosisbkyhkn1x46;
    }

    @Column(order = 395, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x47;

    public BizNumber getIwsMaitosisbkyhkn1x47() {
        return iwsMaitosisbkyhkn1x47;
    }

    public void setIwsMaitosisbkyhkn1x47(BizNumber pIwsMaitosisbkyhkn1x47) {
        iwsMaitosisbkyhkn1x47 = pIwsMaitosisbkyhkn1x47;
    }

    @Column(order = 396, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x48;

    public BizNumber getIwsMaitosisbkyhkn1x48() {
        return iwsMaitosisbkyhkn1x48;
    }

    public void setIwsMaitosisbkyhkn1x48(BizNumber pIwsMaitosisbkyhkn1x48) {
        iwsMaitosisbkyhkn1x48 = pIwsMaitosisbkyhkn1x48;
    }

    @Column(order = 397, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x49;

    public BizNumber getIwsMaitosisbkyhkn1x49() {
        return iwsMaitosisbkyhkn1x49;
    }

    public void setIwsMaitosisbkyhkn1x49(BizNumber pIwsMaitosisbkyhkn1x49) {
        iwsMaitosisbkyhkn1x49 = pIwsMaitosisbkyhkn1x49;
    }

    @Column(order = 398, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x50;

    public BizNumber getIwsMaitosisbkyhkn1x50() {
        return iwsMaitosisbkyhkn1x50;
    }

    public void setIwsMaitosisbkyhkn1x50(BizNumber pIwsMaitosisbkyhkn1x50) {
        iwsMaitosisbkyhkn1x50 = pIwsMaitosisbkyhkn1x50;
    }

    @Column(order = 399, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x51;

    public BizNumber getIwsMaitosisbkyhkn1x51() {
        return iwsMaitosisbkyhkn1x51;
    }

    public void setIwsMaitosisbkyhkn1x51(BizNumber pIwsMaitosisbkyhkn1x51) {
        iwsMaitosisbkyhkn1x51 = pIwsMaitosisbkyhkn1x51;
    }

    @Column(order = 400, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x52;

    public BizNumber getIwsMaitosisbkyhkn1x52() {
        return iwsMaitosisbkyhkn1x52;
    }

    public void setIwsMaitosisbkyhkn1x52(BizNumber pIwsMaitosisbkyhkn1x52) {
        iwsMaitosisbkyhkn1x52 = pIwsMaitosisbkyhkn1x52;
    }

    @Column(order = 401, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x53;

    public BizNumber getIwsMaitosisbkyhkn1x53() {
        return iwsMaitosisbkyhkn1x53;
    }

    public void setIwsMaitosisbkyhkn1x53(BizNumber pIwsMaitosisbkyhkn1x53) {
        iwsMaitosisbkyhkn1x53 = pIwsMaitosisbkyhkn1x53;
    }

    @Column(order = 402, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x54;

    public BizNumber getIwsMaitosisbkyhkn1x54() {
        return iwsMaitosisbkyhkn1x54;
    }

    public void setIwsMaitosisbkyhkn1x54(BizNumber pIwsMaitosisbkyhkn1x54) {
        iwsMaitosisbkyhkn1x54 = pIwsMaitosisbkyhkn1x54;
    }

    @Column(order = 403, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x55;

    public BizNumber getIwsMaitosisbkyhkn1x55() {
        return iwsMaitosisbkyhkn1x55;
    }

    public void setIwsMaitosisbkyhkn1x55(BizNumber pIwsMaitosisbkyhkn1x55) {
        iwsMaitosisbkyhkn1x55 = pIwsMaitosisbkyhkn1x55;
    }

    @Column(order = 404, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x56;

    public BizNumber getIwsMaitosisbkyhkn1x56() {
        return iwsMaitosisbkyhkn1x56;
    }

    public void setIwsMaitosisbkyhkn1x56(BizNumber pIwsMaitosisbkyhkn1x56) {
        iwsMaitosisbkyhkn1x56 = pIwsMaitosisbkyhkn1x56;
    }

    @Column(order = 405, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x57;

    public BizNumber getIwsMaitosisbkyhkn1x57() {
        return iwsMaitosisbkyhkn1x57;
    }

    public void setIwsMaitosisbkyhkn1x57(BizNumber pIwsMaitosisbkyhkn1x57) {
        iwsMaitosisbkyhkn1x57 = pIwsMaitosisbkyhkn1x57;
    }

    @Column(order = 406, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x58;

    public BizNumber getIwsMaitosisbkyhkn1x58() {
        return iwsMaitosisbkyhkn1x58;
    }

    public void setIwsMaitosisbkyhkn1x58(BizNumber pIwsMaitosisbkyhkn1x58) {
        iwsMaitosisbkyhkn1x58 = pIwsMaitosisbkyhkn1x58;
    }

    @Column(order = 407, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x59;

    public BizNumber getIwsMaitosisbkyhkn1x59() {
        return iwsMaitosisbkyhkn1x59;
    }

    public void setIwsMaitosisbkyhkn1x59(BizNumber pIwsMaitosisbkyhkn1x59) {
        iwsMaitosisbkyhkn1x59 = pIwsMaitosisbkyhkn1x59;
    }

    @Column(order = 408, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x60;

    public BizNumber getIwsMaitosisbkyhkn1x60() {
        return iwsMaitosisbkyhkn1x60;
    }

    public void setIwsMaitosisbkyhkn1x60(BizNumber pIwsMaitosisbkyhkn1x60) {
        iwsMaitosisbkyhkn1x60 = pIwsMaitosisbkyhkn1x60;
    }

    @Column(order = 409, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x61;

    public BizNumber getIwsMaitosisbkyhkn1x61() {
        return iwsMaitosisbkyhkn1x61;
    }

    public void setIwsMaitosisbkyhkn1x61(BizNumber pIwsMaitosisbkyhkn1x61) {
        iwsMaitosisbkyhkn1x61 = pIwsMaitosisbkyhkn1x61;
    }

    @Column(order = 410, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x62;

    public BizNumber getIwsMaitosisbkyhkn1x62() {
        return iwsMaitosisbkyhkn1x62;
    }

    public void setIwsMaitosisbkyhkn1x62(BizNumber pIwsMaitosisbkyhkn1x62) {
        iwsMaitosisbkyhkn1x62 = pIwsMaitosisbkyhkn1x62;
    }

    @Column(order = 411, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x63;

    public BizNumber getIwsMaitosisbkyhkn1x63() {
        return iwsMaitosisbkyhkn1x63;
    }

    public void setIwsMaitosisbkyhkn1x63(BizNumber pIwsMaitosisbkyhkn1x63) {
        iwsMaitosisbkyhkn1x63 = pIwsMaitosisbkyhkn1x63;
    }

    @Column(order = 412, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x64;

    public BizNumber getIwsMaitosisbkyhkn1x64() {
        return iwsMaitosisbkyhkn1x64;
    }

    public void setIwsMaitosisbkyhkn1x64(BizNumber pIwsMaitosisbkyhkn1x64) {
        iwsMaitosisbkyhkn1x64 = pIwsMaitosisbkyhkn1x64;
    }

    @Column(order = 413, length = 13)
    private BizNumber iwsMaitosisbkyhkn1x65;

    public BizNumber getIwsMaitosisbkyhkn1x65() {
        return iwsMaitosisbkyhkn1x65;
    }

    public void setIwsMaitosisbkyhkn1x65(BizNumber pIwsMaitosisbkyhkn1x65) {
        iwsMaitosisbkyhkn1x65 = pIwsMaitosisbkyhkn1x65;
    }

    @Column(order = 414, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x1;

    public BizNumber getIwsMaitosisbkyhkn2x1() {
        return iwsMaitosisbkyhkn2x1;
    }

    public void setIwsMaitosisbkyhkn2x1(BizNumber pIwsMaitosisbkyhkn2x1) {
        iwsMaitosisbkyhkn2x1 = pIwsMaitosisbkyhkn2x1;
    }

    @Column(order = 415, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x2;

    public BizNumber getIwsMaitosisbkyhkn2x2() {
        return iwsMaitosisbkyhkn2x2;
    }

    public void setIwsMaitosisbkyhkn2x2(BizNumber pIwsMaitosisbkyhkn2x2) {
        iwsMaitosisbkyhkn2x2 = pIwsMaitosisbkyhkn2x2;
    }

    @Column(order = 416, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x3;

    public BizNumber getIwsMaitosisbkyhkn2x3() {
        return iwsMaitosisbkyhkn2x3;
    }

    public void setIwsMaitosisbkyhkn2x3(BizNumber pIwsMaitosisbkyhkn2x3) {
        iwsMaitosisbkyhkn2x3 = pIwsMaitosisbkyhkn2x3;
    }

    @Column(order = 417, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x4;

    public BizNumber getIwsMaitosisbkyhkn2x4() {
        return iwsMaitosisbkyhkn2x4;
    }

    public void setIwsMaitosisbkyhkn2x4(BizNumber pIwsMaitosisbkyhkn2x4) {
        iwsMaitosisbkyhkn2x4 = pIwsMaitosisbkyhkn2x4;
    }

    @Column(order = 418, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x5;

    public BizNumber getIwsMaitosisbkyhkn2x5() {
        return iwsMaitosisbkyhkn2x5;
    }

    public void setIwsMaitosisbkyhkn2x5(BizNumber pIwsMaitosisbkyhkn2x5) {
        iwsMaitosisbkyhkn2x5 = pIwsMaitosisbkyhkn2x5;
    }

    @Column(order = 419, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x6;

    public BizNumber getIwsMaitosisbkyhkn2x6() {
        return iwsMaitosisbkyhkn2x6;
    }

    public void setIwsMaitosisbkyhkn2x6(BizNumber pIwsMaitosisbkyhkn2x6) {
        iwsMaitosisbkyhkn2x6 = pIwsMaitosisbkyhkn2x6;
    }

    @Column(order = 420, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x7;

    public BizNumber getIwsMaitosisbkyhkn2x7() {
        return iwsMaitosisbkyhkn2x7;
    }

    public void setIwsMaitosisbkyhkn2x7(BizNumber pIwsMaitosisbkyhkn2x7) {
        iwsMaitosisbkyhkn2x7 = pIwsMaitosisbkyhkn2x7;
    }

    @Column(order = 421, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x8;

    public BizNumber getIwsMaitosisbkyhkn2x8() {
        return iwsMaitosisbkyhkn2x8;
    }

    public void setIwsMaitosisbkyhkn2x8(BizNumber pIwsMaitosisbkyhkn2x8) {
        iwsMaitosisbkyhkn2x8 = pIwsMaitosisbkyhkn2x8;
    }

    @Column(order = 422, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x9;

    public BizNumber getIwsMaitosisbkyhkn2x9() {
        return iwsMaitosisbkyhkn2x9;
    }

    public void setIwsMaitosisbkyhkn2x9(BizNumber pIwsMaitosisbkyhkn2x9) {
        iwsMaitosisbkyhkn2x9 = pIwsMaitosisbkyhkn2x9;
    }

    @Column(order = 423, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x10;

    public BizNumber getIwsMaitosisbkyhkn2x10() {
        return iwsMaitosisbkyhkn2x10;
    }

    public void setIwsMaitosisbkyhkn2x10(BizNumber pIwsMaitosisbkyhkn2x10) {
        iwsMaitosisbkyhkn2x10 = pIwsMaitosisbkyhkn2x10;
    }

    @Column(order = 424, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x11;

    public BizNumber getIwsMaitosisbkyhkn2x11() {
        return iwsMaitosisbkyhkn2x11;
    }

    public void setIwsMaitosisbkyhkn2x11(BizNumber pIwsMaitosisbkyhkn2x11) {
        iwsMaitosisbkyhkn2x11 = pIwsMaitosisbkyhkn2x11;
    }

    @Column(order = 425, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x12;

    public BizNumber getIwsMaitosisbkyhkn2x12() {
        return iwsMaitosisbkyhkn2x12;
    }

    public void setIwsMaitosisbkyhkn2x12(BizNumber pIwsMaitosisbkyhkn2x12) {
        iwsMaitosisbkyhkn2x12 = pIwsMaitosisbkyhkn2x12;
    }

    @Column(order = 426, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x13;

    public BizNumber getIwsMaitosisbkyhkn2x13() {
        return iwsMaitosisbkyhkn2x13;
    }

    public void setIwsMaitosisbkyhkn2x13(BizNumber pIwsMaitosisbkyhkn2x13) {
        iwsMaitosisbkyhkn2x13 = pIwsMaitosisbkyhkn2x13;
    }

    @Column(order = 427, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x14;

    public BizNumber getIwsMaitosisbkyhkn2x14() {
        return iwsMaitosisbkyhkn2x14;
    }

    public void setIwsMaitosisbkyhkn2x14(BizNumber pIwsMaitosisbkyhkn2x14) {
        iwsMaitosisbkyhkn2x14 = pIwsMaitosisbkyhkn2x14;
    }

    @Column(order = 428, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x15;

    public BizNumber getIwsMaitosisbkyhkn2x15() {
        return iwsMaitosisbkyhkn2x15;
    }

    public void setIwsMaitosisbkyhkn2x15(BizNumber pIwsMaitosisbkyhkn2x15) {
        iwsMaitosisbkyhkn2x15 = pIwsMaitosisbkyhkn2x15;
    }

    @Column(order = 429, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x16;

    public BizNumber getIwsMaitosisbkyhkn2x16() {
        return iwsMaitosisbkyhkn2x16;
    }

    public void setIwsMaitosisbkyhkn2x16(BizNumber pIwsMaitosisbkyhkn2x16) {
        iwsMaitosisbkyhkn2x16 = pIwsMaitosisbkyhkn2x16;
    }

    @Column(order = 430, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x17;

    public BizNumber getIwsMaitosisbkyhkn2x17() {
        return iwsMaitosisbkyhkn2x17;
    }

    public void setIwsMaitosisbkyhkn2x17(BizNumber pIwsMaitosisbkyhkn2x17) {
        iwsMaitosisbkyhkn2x17 = pIwsMaitosisbkyhkn2x17;
    }

    @Column(order = 431, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x18;

    public BizNumber getIwsMaitosisbkyhkn2x18() {
        return iwsMaitosisbkyhkn2x18;
    }

    public void setIwsMaitosisbkyhkn2x18(BizNumber pIwsMaitosisbkyhkn2x18) {
        iwsMaitosisbkyhkn2x18 = pIwsMaitosisbkyhkn2x18;
    }

    @Column(order = 432, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x19;

    public BizNumber getIwsMaitosisbkyhkn2x19() {
        return iwsMaitosisbkyhkn2x19;
    }

    public void setIwsMaitosisbkyhkn2x19(BizNumber pIwsMaitosisbkyhkn2x19) {
        iwsMaitosisbkyhkn2x19 = pIwsMaitosisbkyhkn2x19;
    }

    @Column(order = 433, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x20;

    public BizNumber getIwsMaitosisbkyhkn2x20() {
        return iwsMaitosisbkyhkn2x20;
    }

    public void setIwsMaitosisbkyhkn2x20(BizNumber pIwsMaitosisbkyhkn2x20) {
        iwsMaitosisbkyhkn2x20 = pIwsMaitosisbkyhkn2x20;
    }

    @Column(order = 434, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x21;

    public BizNumber getIwsMaitosisbkyhkn2x21() {
        return iwsMaitosisbkyhkn2x21;
    }

    public void setIwsMaitosisbkyhkn2x21(BizNumber pIwsMaitosisbkyhkn2x21) {
        iwsMaitosisbkyhkn2x21 = pIwsMaitosisbkyhkn2x21;
    }

    @Column(order = 435, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x22;

    public BizNumber getIwsMaitosisbkyhkn2x22() {
        return iwsMaitosisbkyhkn2x22;
    }

    public void setIwsMaitosisbkyhkn2x22(BizNumber pIwsMaitosisbkyhkn2x22) {
        iwsMaitosisbkyhkn2x22 = pIwsMaitosisbkyhkn2x22;
    }

    @Column(order = 436, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x23;

    public BizNumber getIwsMaitosisbkyhkn2x23() {
        return iwsMaitosisbkyhkn2x23;
    }

    public void setIwsMaitosisbkyhkn2x23(BizNumber pIwsMaitosisbkyhkn2x23) {
        iwsMaitosisbkyhkn2x23 = pIwsMaitosisbkyhkn2x23;
    }

    @Column(order = 437, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x24;

    public BizNumber getIwsMaitosisbkyhkn2x24() {
        return iwsMaitosisbkyhkn2x24;
    }

    public void setIwsMaitosisbkyhkn2x24(BizNumber pIwsMaitosisbkyhkn2x24) {
        iwsMaitosisbkyhkn2x24 = pIwsMaitosisbkyhkn2x24;
    }

    @Column(order = 438, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x25;

    public BizNumber getIwsMaitosisbkyhkn2x25() {
        return iwsMaitosisbkyhkn2x25;
    }

    public void setIwsMaitosisbkyhkn2x25(BizNumber pIwsMaitosisbkyhkn2x25) {
        iwsMaitosisbkyhkn2x25 = pIwsMaitosisbkyhkn2x25;
    }

    @Column(order = 439, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x26;

    public BizNumber getIwsMaitosisbkyhkn2x26() {
        return iwsMaitosisbkyhkn2x26;
    }

    public void setIwsMaitosisbkyhkn2x26(BizNumber pIwsMaitosisbkyhkn2x26) {
        iwsMaitosisbkyhkn2x26 = pIwsMaitosisbkyhkn2x26;
    }

    @Column(order = 440, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x27;

    public BizNumber getIwsMaitosisbkyhkn2x27() {
        return iwsMaitosisbkyhkn2x27;
    }

    public void setIwsMaitosisbkyhkn2x27(BizNumber pIwsMaitosisbkyhkn2x27) {
        iwsMaitosisbkyhkn2x27 = pIwsMaitosisbkyhkn2x27;
    }

    @Column(order = 441, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x28;

    public BizNumber getIwsMaitosisbkyhkn2x28() {
        return iwsMaitosisbkyhkn2x28;
    }

    public void setIwsMaitosisbkyhkn2x28(BizNumber pIwsMaitosisbkyhkn2x28) {
        iwsMaitosisbkyhkn2x28 = pIwsMaitosisbkyhkn2x28;
    }

    @Column(order = 442, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x29;

    public BizNumber getIwsMaitosisbkyhkn2x29() {
        return iwsMaitosisbkyhkn2x29;
    }

    public void setIwsMaitosisbkyhkn2x29(BizNumber pIwsMaitosisbkyhkn2x29) {
        iwsMaitosisbkyhkn2x29 = pIwsMaitosisbkyhkn2x29;
    }

    @Column(order = 443, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x30;

    public BizNumber getIwsMaitosisbkyhkn2x30() {
        return iwsMaitosisbkyhkn2x30;
    }

    public void setIwsMaitosisbkyhkn2x30(BizNumber pIwsMaitosisbkyhkn2x30) {
        iwsMaitosisbkyhkn2x30 = pIwsMaitosisbkyhkn2x30;
    }

    @Column(order = 444, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x31;

    public BizNumber getIwsMaitosisbkyhkn2x31() {
        return iwsMaitosisbkyhkn2x31;
    }

    public void setIwsMaitosisbkyhkn2x31(BizNumber pIwsMaitosisbkyhkn2x31) {
        iwsMaitosisbkyhkn2x31 = pIwsMaitosisbkyhkn2x31;
    }

    @Column(order = 445, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x32;

    public BizNumber getIwsMaitosisbkyhkn2x32() {
        return iwsMaitosisbkyhkn2x32;
    }

    public void setIwsMaitosisbkyhkn2x32(BizNumber pIwsMaitosisbkyhkn2x32) {
        iwsMaitosisbkyhkn2x32 = pIwsMaitosisbkyhkn2x32;
    }

    @Column(order = 446, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x33;

    public BizNumber getIwsMaitosisbkyhkn2x33() {
        return iwsMaitosisbkyhkn2x33;
    }

    public void setIwsMaitosisbkyhkn2x33(BizNumber pIwsMaitosisbkyhkn2x33) {
        iwsMaitosisbkyhkn2x33 = pIwsMaitosisbkyhkn2x33;
    }

    @Column(order = 447, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x34;

    public BizNumber getIwsMaitosisbkyhkn2x34() {
        return iwsMaitosisbkyhkn2x34;
    }

    public void setIwsMaitosisbkyhkn2x34(BizNumber pIwsMaitosisbkyhkn2x34) {
        iwsMaitosisbkyhkn2x34 = pIwsMaitosisbkyhkn2x34;
    }

    @Column(order = 448, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x35;

    public BizNumber getIwsMaitosisbkyhkn2x35() {
        return iwsMaitosisbkyhkn2x35;
    }

    public void setIwsMaitosisbkyhkn2x35(BizNumber pIwsMaitosisbkyhkn2x35) {
        iwsMaitosisbkyhkn2x35 = pIwsMaitosisbkyhkn2x35;
    }

    @Column(order = 449, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x36;

    public BizNumber getIwsMaitosisbkyhkn2x36() {
        return iwsMaitosisbkyhkn2x36;
    }

    public void setIwsMaitosisbkyhkn2x36(BizNumber pIwsMaitosisbkyhkn2x36) {
        iwsMaitosisbkyhkn2x36 = pIwsMaitosisbkyhkn2x36;
    }

    @Column(order = 450, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x37;

    public BizNumber getIwsMaitosisbkyhkn2x37() {
        return iwsMaitosisbkyhkn2x37;
    }

    public void setIwsMaitosisbkyhkn2x37(BizNumber pIwsMaitosisbkyhkn2x37) {
        iwsMaitosisbkyhkn2x37 = pIwsMaitosisbkyhkn2x37;
    }

    @Column(order = 451, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x38;

    public BizNumber getIwsMaitosisbkyhkn2x38() {
        return iwsMaitosisbkyhkn2x38;
    }

    public void setIwsMaitosisbkyhkn2x38(BizNumber pIwsMaitosisbkyhkn2x38) {
        iwsMaitosisbkyhkn2x38 = pIwsMaitosisbkyhkn2x38;
    }

    @Column(order = 452, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x39;

    public BizNumber getIwsMaitosisbkyhkn2x39() {
        return iwsMaitosisbkyhkn2x39;
    }

    public void setIwsMaitosisbkyhkn2x39(BizNumber pIwsMaitosisbkyhkn2x39) {
        iwsMaitosisbkyhkn2x39 = pIwsMaitosisbkyhkn2x39;
    }

    @Column(order = 453, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x40;

    public BizNumber getIwsMaitosisbkyhkn2x40() {
        return iwsMaitosisbkyhkn2x40;
    }

    public void setIwsMaitosisbkyhkn2x40(BizNumber pIwsMaitosisbkyhkn2x40) {
        iwsMaitosisbkyhkn2x40 = pIwsMaitosisbkyhkn2x40;
    }

    @Column(order = 454, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x41;

    public BizNumber getIwsMaitosisbkyhkn2x41() {
        return iwsMaitosisbkyhkn2x41;
    }

    public void setIwsMaitosisbkyhkn2x41(BizNumber pIwsMaitosisbkyhkn2x41) {
        iwsMaitosisbkyhkn2x41 = pIwsMaitosisbkyhkn2x41;
    }

    @Column(order = 455, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x42;

    public BizNumber getIwsMaitosisbkyhkn2x42() {
        return iwsMaitosisbkyhkn2x42;
    }

    public void setIwsMaitosisbkyhkn2x42(BizNumber pIwsMaitosisbkyhkn2x42) {
        iwsMaitosisbkyhkn2x42 = pIwsMaitosisbkyhkn2x42;
    }

    @Column(order = 456, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x43;

    public BizNumber getIwsMaitosisbkyhkn2x43() {
        return iwsMaitosisbkyhkn2x43;
    }

    public void setIwsMaitosisbkyhkn2x43(BizNumber pIwsMaitosisbkyhkn2x43) {
        iwsMaitosisbkyhkn2x43 = pIwsMaitosisbkyhkn2x43;
    }

    @Column(order = 457, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x44;

    public BizNumber getIwsMaitosisbkyhkn2x44() {
        return iwsMaitosisbkyhkn2x44;
    }

    public void setIwsMaitosisbkyhkn2x44(BizNumber pIwsMaitosisbkyhkn2x44) {
        iwsMaitosisbkyhkn2x44 = pIwsMaitosisbkyhkn2x44;
    }

    @Column(order = 458, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x45;

    public BizNumber getIwsMaitosisbkyhkn2x45() {
        return iwsMaitosisbkyhkn2x45;
    }

    public void setIwsMaitosisbkyhkn2x45(BizNumber pIwsMaitosisbkyhkn2x45) {
        iwsMaitosisbkyhkn2x45 = pIwsMaitosisbkyhkn2x45;
    }

    @Column(order = 459, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x46;

    public BizNumber getIwsMaitosisbkyhkn2x46() {
        return iwsMaitosisbkyhkn2x46;
    }

    public void setIwsMaitosisbkyhkn2x46(BizNumber pIwsMaitosisbkyhkn2x46) {
        iwsMaitosisbkyhkn2x46 = pIwsMaitosisbkyhkn2x46;
    }

    @Column(order = 460, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x47;

    public BizNumber getIwsMaitosisbkyhkn2x47() {
        return iwsMaitosisbkyhkn2x47;
    }

    public void setIwsMaitosisbkyhkn2x47(BizNumber pIwsMaitosisbkyhkn2x47) {
        iwsMaitosisbkyhkn2x47 = pIwsMaitosisbkyhkn2x47;
    }

    @Column(order = 461, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x48;

    public BizNumber getIwsMaitosisbkyhkn2x48() {
        return iwsMaitosisbkyhkn2x48;
    }

    public void setIwsMaitosisbkyhkn2x48(BizNumber pIwsMaitosisbkyhkn2x48) {
        iwsMaitosisbkyhkn2x48 = pIwsMaitosisbkyhkn2x48;
    }

    @Column(order = 462, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x49;

    public BizNumber getIwsMaitosisbkyhkn2x49() {
        return iwsMaitosisbkyhkn2x49;
    }

    public void setIwsMaitosisbkyhkn2x49(BizNumber pIwsMaitosisbkyhkn2x49) {
        iwsMaitosisbkyhkn2x49 = pIwsMaitosisbkyhkn2x49;
    }

    @Column(order = 463, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x50;

    public BizNumber getIwsMaitosisbkyhkn2x50() {
        return iwsMaitosisbkyhkn2x50;
    }

    public void setIwsMaitosisbkyhkn2x50(BizNumber pIwsMaitosisbkyhkn2x50) {
        iwsMaitosisbkyhkn2x50 = pIwsMaitosisbkyhkn2x50;
    }

    @Column(order = 464, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x51;

    public BizNumber getIwsMaitosisbkyhkn2x51() {
        return iwsMaitosisbkyhkn2x51;
    }

    public void setIwsMaitosisbkyhkn2x51(BizNumber pIwsMaitosisbkyhkn2x51) {
        iwsMaitosisbkyhkn2x51 = pIwsMaitosisbkyhkn2x51;
    }

    @Column(order = 465, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x52;

    public BizNumber getIwsMaitosisbkyhkn2x52() {
        return iwsMaitosisbkyhkn2x52;
    }

    public void setIwsMaitosisbkyhkn2x52(BizNumber pIwsMaitosisbkyhkn2x52) {
        iwsMaitosisbkyhkn2x52 = pIwsMaitosisbkyhkn2x52;
    }

    @Column(order = 466, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x53;

    public BizNumber getIwsMaitosisbkyhkn2x53() {
        return iwsMaitosisbkyhkn2x53;
    }

    public void setIwsMaitosisbkyhkn2x53(BizNumber pIwsMaitosisbkyhkn2x53) {
        iwsMaitosisbkyhkn2x53 = pIwsMaitosisbkyhkn2x53;
    }

    @Column(order = 467, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x54;

    public BizNumber getIwsMaitosisbkyhkn2x54() {
        return iwsMaitosisbkyhkn2x54;
    }

    public void setIwsMaitosisbkyhkn2x54(BizNumber pIwsMaitosisbkyhkn2x54) {
        iwsMaitosisbkyhkn2x54 = pIwsMaitosisbkyhkn2x54;
    }

    @Column(order = 468, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x55;

    public BizNumber getIwsMaitosisbkyhkn2x55() {
        return iwsMaitosisbkyhkn2x55;
    }

    public void setIwsMaitosisbkyhkn2x55(BizNumber pIwsMaitosisbkyhkn2x55) {
        iwsMaitosisbkyhkn2x55 = pIwsMaitosisbkyhkn2x55;
    }

    @Column(order = 469, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x56;

    public BizNumber getIwsMaitosisbkyhkn2x56() {
        return iwsMaitosisbkyhkn2x56;
    }

    public void setIwsMaitosisbkyhkn2x56(BizNumber pIwsMaitosisbkyhkn2x56) {
        iwsMaitosisbkyhkn2x56 = pIwsMaitosisbkyhkn2x56;
    }

    @Column(order = 470, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x57;

    public BizNumber getIwsMaitosisbkyhkn2x57() {
        return iwsMaitosisbkyhkn2x57;
    }

    public void setIwsMaitosisbkyhkn2x57(BizNumber pIwsMaitosisbkyhkn2x57) {
        iwsMaitosisbkyhkn2x57 = pIwsMaitosisbkyhkn2x57;
    }

    @Column(order = 471, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x58;

    public BizNumber getIwsMaitosisbkyhkn2x58() {
        return iwsMaitosisbkyhkn2x58;
    }

    public void setIwsMaitosisbkyhkn2x58(BizNumber pIwsMaitosisbkyhkn2x58) {
        iwsMaitosisbkyhkn2x58 = pIwsMaitosisbkyhkn2x58;
    }

    @Column(order = 472, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x59;

    public BizNumber getIwsMaitosisbkyhkn2x59() {
        return iwsMaitosisbkyhkn2x59;
    }

    public void setIwsMaitosisbkyhkn2x59(BizNumber pIwsMaitosisbkyhkn2x59) {
        iwsMaitosisbkyhkn2x59 = pIwsMaitosisbkyhkn2x59;
    }

    @Column(order = 473, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x60;

    public BizNumber getIwsMaitosisbkyhkn2x60() {
        return iwsMaitosisbkyhkn2x60;
    }

    public void setIwsMaitosisbkyhkn2x60(BizNumber pIwsMaitosisbkyhkn2x60) {
        iwsMaitosisbkyhkn2x60 = pIwsMaitosisbkyhkn2x60;
    }

    @Column(order = 474, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x61;

    public BizNumber getIwsMaitosisbkyhkn2x61() {
        return iwsMaitosisbkyhkn2x61;
    }

    public void setIwsMaitosisbkyhkn2x61(BizNumber pIwsMaitosisbkyhkn2x61) {
        iwsMaitosisbkyhkn2x61 = pIwsMaitosisbkyhkn2x61;
    }

    @Column(order = 475, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x62;

    public BizNumber getIwsMaitosisbkyhkn2x62() {
        return iwsMaitosisbkyhkn2x62;
    }

    public void setIwsMaitosisbkyhkn2x62(BizNumber pIwsMaitosisbkyhkn2x62) {
        iwsMaitosisbkyhkn2x62 = pIwsMaitosisbkyhkn2x62;
    }

    @Column(order = 476, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x63;

    public BizNumber getIwsMaitosisbkyhkn2x63() {
        return iwsMaitosisbkyhkn2x63;
    }

    public void setIwsMaitosisbkyhkn2x63(BizNumber pIwsMaitosisbkyhkn2x63) {
        iwsMaitosisbkyhkn2x63 = pIwsMaitosisbkyhkn2x63;
    }

    @Column(order = 477, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x64;

    public BizNumber getIwsMaitosisbkyhkn2x64() {
        return iwsMaitosisbkyhkn2x64;
    }

    public void setIwsMaitosisbkyhkn2x64(BizNumber pIwsMaitosisbkyhkn2x64) {
        iwsMaitosisbkyhkn2x64 = pIwsMaitosisbkyhkn2x64;
    }

    @Column(order = 478, length = 13)
    private BizNumber iwsMaitosisbkyhkn2x65;

    public BizNumber getIwsMaitosisbkyhkn2x65() {
        return iwsMaitosisbkyhkn2x65;
    }

    public void setIwsMaitosisbkyhkn2x65(BizNumber pIwsMaitosisbkyhkn2x65) {
        iwsMaitosisbkyhkn2x65 = pIwsMaitosisbkyhkn2x65;
    }

    @Column(order = 479, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x1;

    public BizNumber getIwsMaitosisbkyhkn3x1() {
        return iwsMaitosisbkyhkn3x1;
    }

    public void setIwsMaitosisbkyhkn3x1(BizNumber pIwsMaitosisbkyhkn3x1) {
        iwsMaitosisbkyhkn3x1 = pIwsMaitosisbkyhkn3x1;
    }

    @Column(order = 480, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x2;

    public BizNumber getIwsMaitosisbkyhkn3x2() {
        return iwsMaitosisbkyhkn3x2;
    }

    public void setIwsMaitosisbkyhkn3x2(BizNumber pIwsMaitosisbkyhkn3x2) {
        iwsMaitosisbkyhkn3x2 = pIwsMaitosisbkyhkn3x2;
    }

    @Column(order = 481, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x3;

    public BizNumber getIwsMaitosisbkyhkn3x3() {
        return iwsMaitosisbkyhkn3x3;
    }

    public void setIwsMaitosisbkyhkn3x3(BizNumber pIwsMaitosisbkyhkn3x3) {
        iwsMaitosisbkyhkn3x3 = pIwsMaitosisbkyhkn3x3;
    }

    @Column(order = 482, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x4;

    public BizNumber getIwsMaitosisbkyhkn3x4() {
        return iwsMaitosisbkyhkn3x4;
    }

    public void setIwsMaitosisbkyhkn3x4(BizNumber pIwsMaitosisbkyhkn3x4) {
        iwsMaitosisbkyhkn3x4 = pIwsMaitosisbkyhkn3x4;
    }

    @Column(order = 483, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x5;

    public BizNumber getIwsMaitosisbkyhkn3x5() {
        return iwsMaitosisbkyhkn3x5;
    }

    public void setIwsMaitosisbkyhkn3x5(BizNumber pIwsMaitosisbkyhkn3x5) {
        iwsMaitosisbkyhkn3x5 = pIwsMaitosisbkyhkn3x5;
    }

    @Column(order = 484, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x6;

    public BizNumber getIwsMaitosisbkyhkn3x6() {
        return iwsMaitosisbkyhkn3x6;
    }

    public void setIwsMaitosisbkyhkn3x6(BizNumber pIwsMaitosisbkyhkn3x6) {
        iwsMaitosisbkyhkn3x6 = pIwsMaitosisbkyhkn3x6;
    }

    @Column(order = 485, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x7;

    public BizNumber getIwsMaitosisbkyhkn3x7() {
        return iwsMaitosisbkyhkn3x7;
    }

    public void setIwsMaitosisbkyhkn3x7(BizNumber pIwsMaitosisbkyhkn3x7) {
        iwsMaitosisbkyhkn3x7 = pIwsMaitosisbkyhkn3x7;
    }

    @Column(order = 486, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x8;

    public BizNumber getIwsMaitosisbkyhkn3x8() {
        return iwsMaitosisbkyhkn3x8;
    }

    public void setIwsMaitosisbkyhkn3x8(BizNumber pIwsMaitosisbkyhkn3x8) {
        iwsMaitosisbkyhkn3x8 = pIwsMaitosisbkyhkn3x8;
    }

    @Column(order = 487, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x9;

    public BizNumber getIwsMaitosisbkyhkn3x9() {
        return iwsMaitosisbkyhkn3x9;
    }

    public void setIwsMaitosisbkyhkn3x9(BizNumber pIwsMaitosisbkyhkn3x9) {
        iwsMaitosisbkyhkn3x9 = pIwsMaitosisbkyhkn3x9;
    }

    @Column(order = 488, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x10;

    public BizNumber getIwsMaitosisbkyhkn3x10() {
        return iwsMaitosisbkyhkn3x10;
    }

    public void setIwsMaitosisbkyhkn3x10(BizNumber pIwsMaitosisbkyhkn3x10) {
        iwsMaitosisbkyhkn3x10 = pIwsMaitosisbkyhkn3x10;
    }

    @Column(order = 489, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x11;

    public BizNumber getIwsMaitosisbkyhkn3x11() {
        return iwsMaitosisbkyhkn3x11;
    }

    public void setIwsMaitosisbkyhkn3x11(BizNumber pIwsMaitosisbkyhkn3x11) {
        iwsMaitosisbkyhkn3x11 = pIwsMaitosisbkyhkn3x11;
    }

    @Column(order = 490, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x12;

    public BizNumber getIwsMaitosisbkyhkn3x12() {
        return iwsMaitosisbkyhkn3x12;
    }

    public void setIwsMaitosisbkyhkn3x12(BizNumber pIwsMaitosisbkyhkn3x12) {
        iwsMaitosisbkyhkn3x12 = pIwsMaitosisbkyhkn3x12;
    }

    @Column(order = 491, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x13;

    public BizNumber getIwsMaitosisbkyhkn3x13() {
        return iwsMaitosisbkyhkn3x13;
    }

    public void setIwsMaitosisbkyhkn3x13(BizNumber pIwsMaitosisbkyhkn3x13) {
        iwsMaitosisbkyhkn3x13 = pIwsMaitosisbkyhkn3x13;
    }

    @Column(order = 492, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x14;

    public BizNumber getIwsMaitosisbkyhkn3x14() {
        return iwsMaitosisbkyhkn3x14;
    }

    public void setIwsMaitosisbkyhkn3x14(BizNumber pIwsMaitosisbkyhkn3x14) {
        iwsMaitosisbkyhkn3x14 = pIwsMaitosisbkyhkn3x14;
    }

    @Column(order = 493, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x15;

    public BizNumber getIwsMaitosisbkyhkn3x15() {
        return iwsMaitosisbkyhkn3x15;
    }

    public void setIwsMaitosisbkyhkn3x15(BizNumber pIwsMaitosisbkyhkn3x15) {
        iwsMaitosisbkyhkn3x15 = pIwsMaitosisbkyhkn3x15;
    }

    @Column(order = 494, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x16;

    public BizNumber getIwsMaitosisbkyhkn3x16() {
        return iwsMaitosisbkyhkn3x16;
    }

    public void setIwsMaitosisbkyhkn3x16(BizNumber pIwsMaitosisbkyhkn3x16) {
        iwsMaitosisbkyhkn3x16 = pIwsMaitosisbkyhkn3x16;
    }

    @Column(order = 495, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x17;

    public BizNumber getIwsMaitosisbkyhkn3x17() {
        return iwsMaitosisbkyhkn3x17;
    }

    public void setIwsMaitosisbkyhkn3x17(BizNumber pIwsMaitosisbkyhkn3x17) {
        iwsMaitosisbkyhkn3x17 = pIwsMaitosisbkyhkn3x17;
    }

    @Column(order = 496, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x18;

    public BizNumber getIwsMaitosisbkyhkn3x18() {
        return iwsMaitosisbkyhkn3x18;
    }

    public void setIwsMaitosisbkyhkn3x18(BizNumber pIwsMaitosisbkyhkn3x18) {
        iwsMaitosisbkyhkn3x18 = pIwsMaitosisbkyhkn3x18;
    }

    @Column(order = 497, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x19;

    public BizNumber getIwsMaitosisbkyhkn3x19() {
        return iwsMaitosisbkyhkn3x19;
    }

    public void setIwsMaitosisbkyhkn3x19(BizNumber pIwsMaitosisbkyhkn3x19) {
        iwsMaitosisbkyhkn3x19 = pIwsMaitosisbkyhkn3x19;
    }

    @Column(order = 498, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x20;

    public BizNumber getIwsMaitosisbkyhkn3x20() {
        return iwsMaitosisbkyhkn3x20;
    }

    public void setIwsMaitosisbkyhkn3x20(BizNumber pIwsMaitosisbkyhkn3x20) {
        iwsMaitosisbkyhkn3x20 = pIwsMaitosisbkyhkn3x20;
    }

    @Column(order = 499, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x21;

    public BizNumber getIwsMaitosisbkyhkn3x21() {
        return iwsMaitosisbkyhkn3x21;
    }

    public void setIwsMaitosisbkyhkn3x21(BizNumber pIwsMaitosisbkyhkn3x21) {
        iwsMaitosisbkyhkn3x21 = pIwsMaitosisbkyhkn3x21;
    }

    @Column(order = 500, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x22;

    public BizNumber getIwsMaitosisbkyhkn3x22() {
        return iwsMaitosisbkyhkn3x22;
    }

    public void setIwsMaitosisbkyhkn3x22(BizNumber pIwsMaitosisbkyhkn3x22) {
        iwsMaitosisbkyhkn3x22 = pIwsMaitosisbkyhkn3x22;
    }

    @Column(order = 501, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x23;

    public BizNumber getIwsMaitosisbkyhkn3x23() {
        return iwsMaitosisbkyhkn3x23;
    }

    public void setIwsMaitosisbkyhkn3x23(BizNumber pIwsMaitosisbkyhkn3x23) {
        iwsMaitosisbkyhkn3x23 = pIwsMaitosisbkyhkn3x23;
    }

    @Column(order = 502, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x24;

    public BizNumber getIwsMaitosisbkyhkn3x24() {
        return iwsMaitosisbkyhkn3x24;
    }

    public void setIwsMaitosisbkyhkn3x24(BizNumber pIwsMaitosisbkyhkn3x24) {
        iwsMaitosisbkyhkn3x24 = pIwsMaitosisbkyhkn3x24;
    }

    @Column(order = 503, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x25;

    public BizNumber getIwsMaitosisbkyhkn3x25() {
        return iwsMaitosisbkyhkn3x25;
    }

    public void setIwsMaitosisbkyhkn3x25(BizNumber pIwsMaitosisbkyhkn3x25) {
        iwsMaitosisbkyhkn3x25 = pIwsMaitosisbkyhkn3x25;
    }

    @Column(order = 504, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x26;

    public BizNumber getIwsMaitosisbkyhkn3x26() {
        return iwsMaitosisbkyhkn3x26;
    }

    public void setIwsMaitosisbkyhkn3x26(BizNumber pIwsMaitosisbkyhkn3x26) {
        iwsMaitosisbkyhkn3x26 = pIwsMaitosisbkyhkn3x26;
    }

    @Column(order = 505, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x27;

    public BizNumber getIwsMaitosisbkyhkn3x27() {
        return iwsMaitosisbkyhkn3x27;
    }

    public void setIwsMaitosisbkyhkn3x27(BizNumber pIwsMaitosisbkyhkn3x27) {
        iwsMaitosisbkyhkn3x27 = pIwsMaitosisbkyhkn3x27;
    }

    @Column(order = 506, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x28;

    public BizNumber getIwsMaitosisbkyhkn3x28() {
        return iwsMaitosisbkyhkn3x28;
    }

    public void setIwsMaitosisbkyhkn3x28(BizNumber pIwsMaitosisbkyhkn3x28) {
        iwsMaitosisbkyhkn3x28 = pIwsMaitosisbkyhkn3x28;
    }

    @Column(order = 507, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x29;

    public BizNumber getIwsMaitosisbkyhkn3x29() {
        return iwsMaitosisbkyhkn3x29;
    }

    public void setIwsMaitosisbkyhkn3x29(BizNumber pIwsMaitosisbkyhkn3x29) {
        iwsMaitosisbkyhkn3x29 = pIwsMaitosisbkyhkn3x29;
    }

    @Column(order = 508, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x30;

    public BizNumber getIwsMaitosisbkyhkn3x30() {
        return iwsMaitosisbkyhkn3x30;
    }

    public void setIwsMaitosisbkyhkn3x30(BizNumber pIwsMaitosisbkyhkn3x30) {
        iwsMaitosisbkyhkn3x30 = pIwsMaitosisbkyhkn3x30;
    }

    @Column(order = 509, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x31;

    public BizNumber getIwsMaitosisbkyhkn3x31() {
        return iwsMaitosisbkyhkn3x31;
    }

    public void setIwsMaitosisbkyhkn3x31(BizNumber pIwsMaitosisbkyhkn3x31) {
        iwsMaitosisbkyhkn3x31 = pIwsMaitosisbkyhkn3x31;
    }

    @Column(order = 510, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x32;

    public BizNumber getIwsMaitosisbkyhkn3x32() {
        return iwsMaitosisbkyhkn3x32;
    }

    public void setIwsMaitosisbkyhkn3x32(BizNumber pIwsMaitosisbkyhkn3x32) {
        iwsMaitosisbkyhkn3x32 = pIwsMaitosisbkyhkn3x32;
    }

    @Column(order = 511, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x33;

    public BizNumber getIwsMaitosisbkyhkn3x33() {
        return iwsMaitosisbkyhkn3x33;
    }

    public void setIwsMaitosisbkyhkn3x33(BizNumber pIwsMaitosisbkyhkn3x33) {
        iwsMaitosisbkyhkn3x33 = pIwsMaitosisbkyhkn3x33;
    }

    @Column(order = 512, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x34;

    public BizNumber getIwsMaitosisbkyhkn3x34() {
        return iwsMaitosisbkyhkn3x34;
    }

    public void setIwsMaitosisbkyhkn3x34(BizNumber pIwsMaitosisbkyhkn3x34) {
        iwsMaitosisbkyhkn3x34 = pIwsMaitosisbkyhkn3x34;
    }

    @Column(order = 513, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x35;

    public BizNumber getIwsMaitosisbkyhkn3x35() {
        return iwsMaitosisbkyhkn3x35;
    }

    public void setIwsMaitosisbkyhkn3x35(BizNumber pIwsMaitosisbkyhkn3x35) {
        iwsMaitosisbkyhkn3x35 = pIwsMaitosisbkyhkn3x35;
    }

    @Column(order = 514, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x36;

    public BizNumber getIwsMaitosisbkyhkn3x36() {
        return iwsMaitosisbkyhkn3x36;
    }

    public void setIwsMaitosisbkyhkn3x36(BizNumber pIwsMaitosisbkyhkn3x36) {
        iwsMaitosisbkyhkn3x36 = pIwsMaitosisbkyhkn3x36;
    }

    @Column(order = 515, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x37;

    public BizNumber getIwsMaitosisbkyhkn3x37() {
        return iwsMaitosisbkyhkn3x37;
    }

    public void setIwsMaitosisbkyhkn3x37(BizNumber pIwsMaitosisbkyhkn3x37) {
        iwsMaitosisbkyhkn3x37 = pIwsMaitosisbkyhkn3x37;
    }

    @Column(order = 516, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x38;

    public BizNumber getIwsMaitosisbkyhkn3x38() {
        return iwsMaitosisbkyhkn3x38;
    }

    public void setIwsMaitosisbkyhkn3x38(BizNumber pIwsMaitosisbkyhkn3x38) {
        iwsMaitosisbkyhkn3x38 = pIwsMaitosisbkyhkn3x38;
    }

    @Column(order = 517, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x39;

    public BizNumber getIwsMaitosisbkyhkn3x39() {
        return iwsMaitosisbkyhkn3x39;
    }

    public void setIwsMaitosisbkyhkn3x39(BizNumber pIwsMaitosisbkyhkn3x39) {
        iwsMaitosisbkyhkn3x39 = pIwsMaitosisbkyhkn3x39;
    }

    @Column(order = 518, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x40;

    public BizNumber getIwsMaitosisbkyhkn3x40() {
        return iwsMaitosisbkyhkn3x40;
    }

    public void setIwsMaitosisbkyhkn3x40(BizNumber pIwsMaitosisbkyhkn3x40) {
        iwsMaitosisbkyhkn3x40 = pIwsMaitosisbkyhkn3x40;
    }

    @Column(order = 519, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x41;

    public BizNumber getIwsMaitosisbkyhkn3x41() {
        return iwsMaitosisbkyhkn3x41;
    }

    public void setIwsMaitosisbkyhkn3x41(BizNumber pIwsMaitosisbkyhkn3x41) {
        iwsMaitosisbkyhkn3x41 = pIwsMaitosisbkyhkn3x41;
    }

    @Column(order = 520, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x42;

    public BizNumber getIwsMaitosisbkyhkn3x42() {
        return iwsMaitosisbkyhkn3x42;
    }

    public void setIwsMaitosisbkyhkn3x42(BizNumber pIwsMaitosisbkyhkn3x42) {
        iwsMaitosisbkyhkn3x42 = pIwsMaitosisbkyhkn3x42;
    }

    @Column(order = 521, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x43;

    public BizNumber getIwsMaitosisbkyhkn3x43() {
        return iwsMaitosisbkyhkn3x43;
    }

    public void setIwsMaitosisbkyhkn3x43(BizNumber pIwsMaitosisbkyhkn3x43) {
        iwsMaitosisbkyhkn3x43 = pIwsMaitosisbkyhkn3x43;
    }

    @Column(order = 522, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x44;

    public BizNumber getIwsMaitosisbkyhkn3x44() {
        return iwsMaitosisbkyhkn3x44;
    }

    public void setIwsMaitosisbkyhkn3x44(BizNumber pIwsMaitosisbkyhkn3x44) {
        iwsMaitosisbkyhkn3x44 = pIwsMaitosisbkyhkn3x44;
    }

    @Column(order = 523, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x45;

    public BizNumber getIwsMaitosisbkyhkn3x45() {
        return iwsMaitosisbkyhkn3x45;
    }

    public void setIwsMaitosisbkyhkn3x45(BizNumber pIwsMaitosisbkyhkn3x45) {
        iwsMaitosisbkyhkn3x45 = pIwsMaitosisbkyhkn3x45;
    }

    @Column(order = 524, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x46;

    public BizNumber getIwsMaitosisbkyhkn3x46() {
        return iwsMaitosisbkyhkn3x46;
    }

    public void setIwsMaitosisbkyhkn3x46(BizNumber pIwsMaitosisbkyhkn3x46) {
        iwsMaitosisbkyhkn3x46 = pIwsMaitosisbkyhkn3x46;
    }

    @Column(order = 525, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x47;

    public BizNumber getIwsMaitosisbkyhkn3x47() {
        return iwsMaitosisbkyhkn3x47;
    }

    public void setIwsMaitosisbkyhkn3x47(BizNumber pIwsMaitosisbkyhkn3x47) {
        iwsMaitosisbkyhkn3x47 = pIwsMaitosisbkyhkn3x47;
    }

    @Column(order = 526, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x48;

    public BizNumber getIwsMaitosisbkyhkn3x48() {
        return iwsMaitosisbkyhkn3x48;
    }

    public void setIwsMaitosisbkyhkn3x48(BizNumber pIwsMaitosisbkyhkn3x48) {
        iwsMaitosisbkyhkn3x48 = pIwsMaitosisbkyhkn3x48;
    }

    @Column(order = 527, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x49;

    public BizNumber getIwsMaitosisbkyhkn3x49() {
        return iwsMaitosisbkyhkn3x49;
    }

    public void setIwsMaitosisbkyhkn3x49(BizNumber pIwsMaitosisbkyhkn3x49) {
        iwsMaitosisbkyhkn3x49 = pIwsMaitosisbkyhkn3x49;
    }

    @Column(order = 528, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x50;

    public BizNumber getIwsMaitosisbkyhkn3x50() {
        return iwsMaitosisbkyhkn3x50;
    }

    public void setIwsMaitosisbkyhkn3x50(BizNumber pIwsMaitosisbkyhkn3x50) {
        iwsMaitosisbkyhkn3x50 = pIwsMaitosisbkyhkn3x50;
    }

    @Column(order = 529, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x51;

    public BizNumber getIwsMaitosisbkyhkn3x51() {
        return iwsMaitosisbkyhkn3x51;
    }

    public void setIwsMaitosisbkyhkn3x51(BizNumber pIwsMaitosisbkyhkn3x51) {
        iwsMaitosisbkyhkn3x51 = pIwsMaitosisbkyhkn3x51;
    }

    @Column(order = 530, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x52;

    public BizNumber getIwsMaitosisbkyhkn3x52() {
        return iwsMaitosisbkyhkn3x52;
    }

    public void setIwsMaitosisbkyhkn3x52(BizNumber pIwsMaitosisbkyhkn3x52) {
        iwsMaitosisbkyhkn3x52 = pIwsMaitosisbkyhkn3x52;
    }

    @Column(order = 531, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x53;

    public BizNumber getIwsMaitosisbkyhkn3x53() {
        return iwsMaitosisbkyhkn3x53;
    }

    public void setIwsMaitosisbkyhkn3x53(BizNumber pIwsMaitosisbkyhkn3x53) {
        iwsMaitosisbkyhkn3x53 = pIwsMaitosisbkyhkn3x53;
    }

    @Column(order = 532, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x54;

    public BizNumber getIwsMaitosisbkyhkn3x54() {
        return iwsMaitosisbkyhkn3x54;
    }

    public void setIwsMaitosisbkyhkn3x54(BizNumber pIwsMaitosisbkyhkn3x54) {
        iwsMaitosisbkyhkn3x54 = pIwsMaitosisbkyhkn3x54;
    }

    @Column(order = 533, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x55;

    public BizNumber getIwsMaitosisbkyhkn3x55() {
        return iwsMaitosisbkyhkn3x55;
    }

    public void setIwsMaitosisbkyhkn3x55(BizNumber pIwsMaitosisbkyhkn3x55) {
        iwsMaitosisbkyhkn3x55 = pIwsMaitosisbkyhkn3x55;
    }

    @Column(order = 534, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x56;

    public BizNumber getIwsMaitosisbkyhkn3x56() {
        return iwsMaitosisbkyhkn3x56;
    }

    public void setIwsMaitosisbkyhkn3x56(BizNumber pIwsMaitosisbkyhkn3x56) {
        iwsMaitosisbkyhkn3x56 = pIwsMaitosisbkyhkn3x56;
    }

    @Column(order = 535, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x57;

    public BizNumber getIwsMaitosisbkyhkn3x57() {
        return iwsMaitosisbkyhkn3x57;
    }

    public void setIwsMaitosisbkyhkn3x57(BizNumber pIwsMaitosisbkyhkn3x57) {
        iwsMaitosisbkyhkn3x57 = pIwsMaitosisbkyhkn3x57;
    }

    @Column(order = 536, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x58;

    public BizNumber getIwsMaitosisbkyhkn3x58() {
        return iwsMaitosisbkyhkn3x58;
    }

    public void setIwsMaitosisbkyhkn3x58(BizNumber pIwsMaitosisbkyhkn3x58) {
        iwsMaitosisbkyhkn3x58 = pIwsMaitosisbkyhkn3x58;
    }

    @Column(order = 537, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x59;

    public BizNumber getIwsMaitosisbkyhkn3x59() {
        return iwsMaitosisbkyhkn3x59;
    }

    public void setIwsMaitosisbkyhkn3x59(BizNumber pIwsMaitosisbkyhkn3x59) {
        iwsMaitosisbkyhkn3x59 = pIwsMaitosisbkyhkn3x59;
    }

    @Column(order = 538, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x60;

    public BizNumber getIwsMaitosisbkyhkn3x60() {
        return iwsMaitosisbkyhkn3x60;
    }

    public void setIwsMaitosisbkyhkn3x60(BizNumber pIwsMaitosisbkyhkn3x60) {
        iwsMaitosisbkyhkn3x60 = pIwsMaitosisbkyhkn3x60;
    }

    @Column(order = 539, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x61;

    public BizNumber getIwsMaitosisbkyhkn3x61() {
        return iwsMaitosisbkyhkn3x61;
    }

    public void setIwsMaitosisbkyhkn3x61(BizNumber pIwsMaitosisbkyhkn3x61) {
        iwsMaitosisbkyhkn3x61 = pIwsMaitosisbkyhkn3x61;
    }

    @Column(order = 540, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x62;

    public BizNumber getIwsMaitosisbkyhkn3x62() {
        return iwsMaitosisbkyhkn3x62;
    }

    public void setIwsMaitosisbkyhkn3x62(BizNumber pIwsMaitosisbkyhkn3x62) {
        iwsMaitosisbkyhkn3x62 = pIwsMaitosisbkyhkn3x62;
    }

    @Column(order = 541, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x63;

    public BizNumber getIwsMaitosisbkyhkn3x63() {
        return iwsMaitosisbkyhkn3x63;
    }

    public void setIwsMaitosisbkyhkn3x63(BizNumber pIwsMaitosisbkyhkn3x63) {
        iwsMaitosisbkyhkn3x63 = pIwsMaitosisbkyhkn3x63;
    }

    @Column(order = 542, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x64;

    public BizNumber getIwsMaitosisbkyhkn3x64() {
        return iwsMaitosisbkyhkn3x64;
    }

    public void setIwsMaitosisbkyhkn3x64(BizNumber pIwsMaitosisbkyhkn3x64) {
        iwsMaitosisbkyhkn3x64 = pIwsMaitosisbkyhkn3x64;
    }

    @Column(order = 543, length = 13)
    private BizNumber iwsMaitosisbkyhkn3x65;

    public BizNumber getIwsMaitosisbkyhkn3x65() {
        return iwsMaitosisbkyhkn3x65;
    }

    public void setIwsMaitosisbkyhkn3x65(BizNumber pIwsMaitosisbkyhkn3x65) {
        iwsMaitosisbkyhkn3x65 = pIwsMaitosisbkyhkn3x65;
    }

    @Column(order = 544, length = 10)
    private BizNumber iwsMaitosiznnzndk1x1;

    public BizNumber getIwsMaitosiznnzndk1x1() {
        return iwsMaitosiznnzndk1x1;
    }

    public void setIwsMaitosiznnzndk1x1(BizNumber pIwsMaitosiznnzndk1x1) {
        iwsMaitosiznnzndk1x1 = pIwsMaitosiznnzndk1x1;
    }

    @Column(order = 545, length = 10)
    private BizNumber iwsMaitosiznnzndk1x2;

    public BizNumber getIwsMaitosiznnzndk1x2() {
        return iwsMaitosiznnzndk1x2;
    }

    public void setIwsMaitosiznnzndk1x2(BizNumber pIwsMaitosiznnzndk1x2) {
        iwsMaitosiznnzndk1x2 = pIwsMaitosiznnzndk1x2;
    }

    @Column(order = 546, length = 10)
    private BizNumber iwsMaitosiznnzndk1x3;

    public BizNumber getIwsMaitosiznnzndk1x3() {
        return iwsMaitosiznnzndk1x3;
    }

    public void setIwsMaitosiznnzndk1x3(BizNumber pIwsMaitosiznnzndk1x3) {
        iwsMaitosiznnzndk1x3 = pIwsMaitosiznnzndk1x3;
    }

    @Column(order = 547, length = 10)
    private BizNumber iwsMaitosiznnzndk1x4;

    public BizNumber getIwsMaitosiznnzndk1x4() {
        return iwsMaitosiznnzndk1x4;
    }

    public void setIwsMaitosiznnzndk1x4(BizNumber pIwsMaitosiznnzndk1x4) {
        iwsMaitosiznnzndk1x4 = pIwsMaitosiznnzndk1x4;
    }

    @Column(order = 548, length = 10)
    private BizNumber iwsMaitosiznnzndk1x5;

    public BizNumber getIwsMaitosiznnzndk1x5() {
        return iwsMaitosiznnzndk1x5;
    }

    public void setIwsMaitosiznnzndk1x5(BizNumber pIwsMaitosiznnzndk1x5) {
        iwsMaitosiznnzndk1x5 = pIwsMaitosiznnzndk1x5;
    }

    @Column(order = 549, length = 10)
    private BizNumber iwsMaitosiznnzndk1x6;

    public BizNumber getIwsMaitosiznnzndk1x6() {
        return iwsMaitosiznnzndk1x6;
    }

    public void setIwsMaitosiznnzndk1x6(BizNumber pIwsMaitosiznnzndk1x6) {
        iwsMaitosiznnzndk1x6 = pIwsMaitosiznnzndk1x6;
    }

    @Column(order = 550, length = 10)
    private BizNumber iwsMaitosiznnzndk1x7;

    public BizNumber getIwsMaitosiznnzndk1x7() {
        return iwsMaitosiznnzndk1x7;
    }

    public void setIwsMaitosiznnzndk1x7(BizNumber pIwsMaitosiznnzndk1x7) {
        iwsMaitosiznnzndk1x7 = pIwsMaitosiznnzndk1x7;
    }

    @Column(order = 551, length = 10)
    private BizNumber iwsMaitosiznnzndk1x8;

    public BizNumber getIwsMaitosiznnzndk1x8() {
        return iwsMaitosiznnzndk1x8;
    }

    public void setIwsMaitosiznnzndk1x8(BizNumber pIwsMaitosiznnzndk1x8) {
        iwsMaitosiznnzndk1x8 = pIwsMaitosiznnzndk1x8;
    }

    @Column(order = 552, length = 10)
    private BizNumber iwsMaitosiznnzndk1x9;

    public BizNumber getIwsMaitosiznnzndk1x9() {
        return iwsMaitosiznnzndk1x9;
    }

    public void setIwsMaitosiznnzndk1x9(BizNumber pIwsMaitosiznnzndk1x9) {
        iwsMaitosiznnzndk1x9 = pIwsMaitosiznnzndk1x9;
    }

    @Column(order = 553, length = 10)
    private BizNumber iwsMaitosiznnzndk1x10;

    public BizNumber getIwsMaitosiznnzndk1x10() {
        return iwsMaitosiznnzndk1x10;
    }

    public void setIwsMaitosiznnzndk1x10(BizNumber pIwsMaitosiznnzndk1x10) {
        iwsMaitosiznnzndk1x10 = pIwsMaitosiznnzndk1x10;
    }

    @Column(order = 554, length = 10)
    private BizNumber iwsMaitosiznnzndk1x11;

    public BizNumber getIwsMaitosiznnzndk1x11() {
        return iwsMaitosiznnzndk1x11;
    }

    public void setIwsMaitosiznnzndk1x11(BizNumber pIwsMaitosiznnzndk1x11) {
        iwsMaitosiznnzndk1x11 = pIwsMaitosiznnzndk1x11;
    }

    @Column(order = 555, length = 10)
    private BizNumber iwsMaitosiznnzndk1x12;

    public BizNumber getIwsMaitosiznnzndk1x12() {
        return iwsMaitosiznnzndk1x12;
    }

    public void setIwsMaitosiznnzndk1x12(BizNumber pIwsMaitosiznnzndk1x12) {
        iwsMaitosiznnzndk1x12 = pIwsMaitosiznnzndk1x12;
    }

    @Column(order = 556, length = 10)
    private BizNumber iwsMaitosiznnzndk1x13;

    public BizNumber getIwsMaitosiznnzndk1x13() {
        return iwsMaitosiznnzndk1x13;
    }

    public void setIwsMaitosiznnzndk1x13(BizNumber pIwsMaitosiznnzndk1x13) {
        iwsMaitosiznnzndk1x13 = pIwsMaitosiznnzndk1x13;
    }

    @Column(order = 557, length = 10)
    private BizNumber iwsMaitosiznnzndk1x14;

    public BizNumber getIwsMaitosiznnzndk1x14() {
        return iwsMaitosiznnzndk1x14;
    }

    public void setIwsMaitosiznnzndk1x14(BizNumber pIwsMaitosiznnzndk1x14) {
        iwsMaitosiznnzndk1x14 = pIwsMaitosiznnzndk1x14;
    }

    @Column(order = 558, length = 10)
    private BizNumber iwsMaitosiznnzndk1x15;

    public BizNumber getIwsMaitosiznnzndk1x15() {
        return iwsMaitosiznnzndk1x15;
    }

    public void setIwsMaitosiznnzndk1x15(BizNumber pIwsMaitosiznnzndk1x15) {
        iwsMaitosiznnzndk1x15 = pIwsMaitosiznnzndk1x15;
    }

    @Column(order = 559, length = 10)
    private BizNumber iwsMaitosiznnzndk1x16;

    public BizNumber getIwsMaitosiznnzndk1x16() {
        return iwsMaitosiznnzndk1x16;
    }

    public void setIwsMaitosiznnzndk1x16(BizNumber pIwsMaitosiznnzndk1x16) {
        iwsMaitosiznnzndk1x16 = pIwsMaitosiznnzndk1x16;
    }

    @Column(order = 560, length = 10)
    private BizNumber iwsMaitosiznnzndk1x17;

    public BizNumber getIwsMaitosiznnzndk1x17() {
        return iwsMaitosiznnzndk1x17;
    }

    public void setIwsMaitosiznnzndk1x17(BizNumber pIwsMaitosiznnzndk1x17) {
        iwsMaitosiznnzndk1x17 = pIwsMaitosiznnzndk1x17;
    }

    @Column(order = 561, length = 10)
    private BizNumber iwsMaitosiznnzndk1x18;

    public BizNumber getIwsMaitosiznnzndk1x18() {
        return iwsMaitosiznnzndk1x18;
    }

    public void setIwsMaitosiznnzndk1x18(BizNumber pIwsMaitosiznnzndk1x18) {
        iwsMaitosiznnzndk1x18 = pIwsMaitosiznnzndk1x18;
    }

    @Column(order = 562, length = 10)
    private BizNumber iwsMaitosiznnzndk1x19;

    public BizNumber getIwsMaitosiznnzndk1x19() {
        return iwsMaitosiznnzndk1x19;
    }

    public void setIwsMaitosiznnzndk1x19(BizNumber pIwsMaitosiznnzndk1x19) {
        iwsMaitosiznnzndk1x19 = pIwsMaitosiznnzndk1x19;
    }

    @Column(order = 563, length = 10)
    private BizNumber iwsMaitosiznnzndk1x20;

    public BizNumber getIwsMaitosiznnzndk1x20() {
        return iwsMaitosiznnzndk1x20;
    }

    public void setIwsMaitosiznnzndk1x20(BizNumber pIwsMaitosiznnzndk1x20) {
        iwsMaitosiznnzndk1x20 = pIwsMaitosiznnzndk1x20;
    }

    @Column(order = 564, length = 10)
    private BizNumber iwsMaitosiznnzndk1x21;

    public BizNumber getIwsMaitosiznnzndk1x21() {
        return iwsMaitosiznnzndk1x21;
    }

    public void setIwsMaitosiznnzndk1x21(BizNumber pIwsMaitosiznnzndk1x21) {
        iwsMaitosiznnzndk1x21 = pIwsMaitosiznnzndk1x21;
    }

    @Column(order = 565, length = 10)
    private BizNumber iwsMaitosiznnzndk1x22;

    public BizNumber getIwsMaitosiznnzndk1x22() {
        return iwsMaitosiznnzndk1x22;
    }

    public void setIwsMaitosiznnzndk1x22(BizNumber pIwsMaitosiznnzndk1x22) {
        iwsMaitosiznnzndk1x22 = pIwsMaitosiznnzndk1x22;
    }

    @Column(order = 566, length = 10)
    private BizNumber iwsMaitosiznnzndk1x23;

    public BizNumber getIwsMaitosiznnzndk1x23() {
        return iwsMaitosiznnzndk1x23;
    }

    public void setIwsMaitosiznnzndk1x23(BizNumber pIwsMaitosiznnzndk1x23) {
        iwsMaitosiznnzndk1x23 = pIwsMaitosiznnzndk1x23;
    }

    @Column(order = 567, length = 10)
    private BizNumber iwsMaitosiznnzndk1x24;

    public BizNumber getIwsMaitosiznnzndk1x24() {
        return iwsMaitosiznnzndk1x24;
    }

    public void setIwsMaitosiznnzndk1x24(BizNumber pIwsMaitosiznnzndk1x24) {
        iwsMaitosiznnzndk1x24 = pIwsMaitosiznnzndk1x24;
    }

    @Column(order = 568, length = 10)
    private BizNumber iwsMaitosiznnzndk1x25;

    public BizNumber getIwsMaitosiznnzndk1x25() {
        return iwsMaitosiznnzndk1x25;
    }

    public void setIwsMaitosiznnzndk1x25(BizNumber pIwsMaitosiznnzndk1x25) {
        iwsMaitosiznnzndk1x25 = pIwsMaitosiznnzndk1x25;
    }

    @Column(order = 569, length = 10)
    private BizNumber iwsMaitosiznnzndk1x26;

    public BizNumber getIwsMaitosiznnzndk1x26() {
        return iwsMaitosiznnzndk1x26;
    }

    public void setIwsMaitosiznnzndk1x26(BizNumber pIwsMaitosiznnzndk1x26) {
        iwsMaitosiznnzndk1x26 = pIwsMaitosiznnzndk1x26;
    }

    @Column(order = 570, length = 10)
    private BizNumber iwsMaitosiznnzndk1x27;

    public BizNumber getIwsMaitosiznnzndk1x27() {
        return iwsMaitosiznnzndk1x27;
    }

    public void setIwsMaitosiznnzndk1x27(BizNumber pIwsMaitosiznnzndk1x27) {
        iwsMaitosiznnzndk1x27 = pIwsMaitosiznnzndk1x27;
    }

    @Column(order = 571, length = 10)
    private BizNumber iwsMaitosiznnzndk1x28;

    public BizNumber getIwsMaitosiznnzndk1x28() {
        return iwsMaitosiznnzndk1x28;
    }

    public void setIwsMaitosiznnzndk1x28(BizNumber pIwsMaitosiznnzndk1x28) {
        iwsMaitosiznnzndk1x28 = pIwsMaitosiznnzndk1x28;
    }

    @Column(order = 572, length = 10)
    private BizNumber iwsMaitosiznnzndk1x29;

    public BizNumber getIwsMaitosiznnzndk1x29() {
        return iwsMaitosiznnzndk1x29;
    }

    public void setIwsMaitosiznnzndk1x29(BizNumber pIwsMaitosiznnzndk1x29) {
        iwsMaitosiznnzndk1x29 = pIwsMaitosiznnzndk1x29;
    }

    @Column(order = 573, length = 10)
    private BizNumber iwsMaitosiznnzndk1x30;

    public BizNumber getIwsMaitosiznnzndk1x30() {
        return iwsMaitosiznnzndk1x30;
    }

    public void setIwsMaitosiznnzndk1x30(BizNumber pIwsMaitosiznnzndk1x30) {
        iwsMaitosiznnzndk1x30 = pIwsMaitosiznnzndk1x30;
    }

    @Column(order = 574, length = 10)
    private BizNumber iwsMaitosiznnzndk1x31;

    public BizNumber getIwsMaitosiznnzndk1x31() {
        return iwsMaitosiznnzndk1x31;
    }

    public void setIwsMaitosiznnzndk1x31(BizNumber pIwsMaitosiznnzndk1x31) {
        iwsMaitosiznnzndk1x31 = pIwsMaitosiznnzndk1x31;
    }

    @Column(order = 575, length = 10)
    private BizNumber iwsMaitosiznnzndk1x32;

    public BizNumber getIwsMaitosiznnzndk1x32() {
        return iwsMaitosiznnzndk1x32;
    }

    public void setIwsMaitosiznnzndk1x32(BizNumber pIwsMaitosiznnzndk1x32) {
        iwsMaitosiznnzndk1x32 = pIwsMaitosiznnzndk1x32;
    }

    @Column(order = 576, length = 10)
    private BizNumber iwsMaitosiznnzndk1x33;

    public BizNumber getIwsMaitosiznnzndk1x33() {
        return iwsMaitosiznnzndk1x33;
    }

    public void setIwsMaitosiznnzndk1x33(BizNumber pIwsMaitosiznnzndk1x33) {
        iwsMaitosiznnzndk1x33 = pIwsMaitosiznnzndk1x33;
    }

    @Column(order = 577, length = 10)
    private BizNumber iwsMaitosiznnzndk1x34;

    public BizNumber getIwsMaitosiznnzndk1x34() {
        return iwsMaitosiznnzndk1x34;
    }

    public void setIwsMaitosiznnzndk1x34(BizNumber pIwsMaitosiznnzndk1x34) {
        iwsMaitosiznnzndk1x34 = pIwsMaitosiznnzndk1x34;
    }

    @Column(order = 578, length = 10)
    private BizNumber iwsMaitosiznnzndk1x35;

    public BizNumber getIwsMaitosiznnzndk1x35() {
        return iwsMaitosiznnzndk1x35;
    }

    public void setIwsMaitosiznnzndk1x35(BizNumber pIwsMaitosiznnzndk1x35) {
        iwsMaitosiznnzndk1x35 = pIwsMaitosiznnzndk1x35;
    }

    @Column(order = 579, length = 10)
    private BizNumber iwsMaitosiznnzndk1x36;

    public BizNumber getIwsMaitosiznnzndk1x36() {
        return iwsMaitosiznnzndk1x36;
    }

    public void setIwsMaitosiznnzndk1x36(BizNumber pIwsMaitosiznnzndk1x36) {
        iwsMaitosiznnzndk1x36 = pIwsMaitosiznnzndk1x36;
    }

    @Column(order = 580, length = 10)
    private BizNumber iwsMaitosiznnzndk1x37;

    public BizNumber getIwsMaitosiznnzndk1x37() {
        return iwsMaitosiznnzndk1x37;
    }

    public void setIwsMaitosiznnzndk1x37(BizNumber pIwsMaitosiznnzndk1x37) {
        iwsMaitosiznnzndk1x37 = pIwsMaitosiznnzndk1x37;
    }

    @Column(order = 581, length = 10)
    private BizNumber iwsMaitosiznnzndk1x38;

    public BizNumber getIwsMaitosiznnzndk1x38() {
        return iwsMaitosiznnzndk1x38;
    }

    public void setIwsMaitosiznnzndk1x38(BizNumber pIwsMaitosiznnzndk1x38) {
        iwsMaitosiznnzndk1x38 = pIwsMaitosiznnzndk1x38;
    }

    @Column(order = 582, length = 10)
    private BizNumber iwsMaitosiznnzndk1x39;

    public BizNumber getIwsMaitosiznnzndk1x39() {
        return iwsMaitosiznnzndk1x39;
    }

    public void setIwsMaitosiznnzndk1x39(BizNumber pIwsMaitosiznnzndk1x39) {
        iwsMaitosiznnzndk1x39 = pIwsMaitosiznnzndk1x39;
    }

    @Column(order = 583, length = 10)
    private BizNumber iwsMaitosiznnzndk1x40;

    public BizNumber getIwsMaitosiznnzndk1x40() {
        return iwsMaitosiznnzndk1x40;
    }

    public void setIwsMaitosiznnzndk1x40(BizNumber pIwsMaitosiznnzndk1x40) {
        iwsMaitosiznnzndk1x40 = pIwsMaitosiznnzndk1x40;
    }

    @Column(order = 584, length = 10)
    private BizNumber iwsMaitosiznnzndk1x41;

    public BizNumber getIwsMaitosiznnzndk1x41() {
        return iwsMaitosiznnzndk1x41;
    }

    public void setIwsMaitosiznnzndk1x41(BizNumber pIwsMaitosiznnzndk1x41) {
        iwsMaitosiznnzndk1x41 = pIwsMaitosiznnzndk1x41;
    }

    @Column(order = 585, length = 10)
    private BizNumber iwsMaitosiznnzndk1x42;

    public BizNumber getIwsMaitosiznnzndk1x42() {
        return iwsMaitosiznnzndk1x42;
    }

    public void setIwsMaitosiznnzndk1x42(BizNumber pIwsMaitosiznnzndk1x42) {
        iwsMaitosiznnzndk1x42 = pIwsMaitosiznnzndk1x42;
    }

    @Column(order = 586, length = 10)
    private BizNumber iwsMaitosiznnzndk1x43;

    public BizNumber getIwsMaitosiznnzndk1x43() {
        return iwsMaitosiznnzndk1x43;
    }

    public void setIwsMaitosiznnzndk1x43(BizNumber pIwsMaitosiznnzndk1x43) {
        iwsMaitosiznnzndk1x43 = pIwsMaitosiznnzndk1x43;
    }

    @Column(order = 587, length = 10)
    private BizNumber iwsMaitosiznnzndk1x44;

    public BizNumber getIwsMaitosiznnzndk1x44() {
        return iwsMaitosiznnzndk1x44;
    }

    public void setIwsMaitosiznnzndk1x44(BizNumber pIwsMaitosiznnzndk1x44) {
        iwsMaitosiznnzndk1x44 = pIwsMaitosiznnzndk1x44;
    }

    @Column(order = 588, length = 10)
    private BizNumber iwsMaitosiznnzndk1x45;

    public BizNumber getIwsMaitosiznnzndk1x45() {
        return iwsMaitosiznnzndk1x45;
    }

    public void setIwsMaitosiznnzndk1x45(BizNumber pIwsMaitosiznnzndk1x45) {
        iwsMaitosiznnzndk1x45 = pIwsMaitosiznnzndk1x45;
    }

    @Column(order = 589, length = 10)
    private BizNumber iwsMaitosiznnzndk1x46;

    public BizNumber getIwsMaitosiznnzndk1x46() {
        return iwsMaitosiznnzndk1x46;
    }

    public void setIwsMaitosiznnzndk1x46(BizNumber pIwsMaitosiznnzndk1x46) {
        iwsMaitosiznnzndk1x46 = pIwsMaitosiznnzndk1x46;
    }

    @Column(order = 590, length = 10)
    private BizNumber iwsMaitosiznnzndk1x47;

    public BizNumber getIwsMaitosiznnzndk1x47() {
        return iwsMaitosiznnzndk1x47;
    }

    public void setIwsMaitosiznnzndk1x47(BizNumber pIwsMaitosiznnzndk1x47) {
        iwsMaitosiznnzndk1x47 = pIwsMaitosiznnzndk1x47;
    }

    @Column(order = 591, length = 10)
    private BizNumber iwsMaitosiznnzndk1x48;

    public BizNumber getIwsMaitosiznnzndk1x48() {
        return iwsMaitosiznnzndk1x48;
    }

    public void setIwsMaitosiznnzndk1x48(BizNumber pIwsMaitosiznnzndk1x48) {
        iwsMaitosiznnzndk1x48 = pIwsMaitosiznnzndk1x48;
    }

    @Column(order = 592, length = 10)
    private BizNumber iwsMaitosiznnzndk1x49;

    public BizNumber getIwsMaitosiznnzndk1x49() {
        return iwsMaitosiznnzndk1x49;
    }

    public void setIwsMaitosiznnzndk1x49(BizNumber pIwsMaitosiznnzndk1x49) {
        iwsMaitosiznnzndk1x49 = pIwsMaitosiznnzndk1x49;
    }

    @Column(order = 593, length = 10)
    private BizNumber iwsMaitosiznnzndk1x50;

    public BizNumber getIwsMaitosiznnzndk1x50() {
        return iwsMaitosiznnzndk1x50;
    }

    public void setIwsMaitosiznnzndk1x50(BizNumber pIwsMaitosiznnzndk1x50) {
        iwsMaitosiznnzndk1x50 = pIwsMaitosiznnzndk1x50;
    }

    @Column(order = 594, length = 13)
    private BizNumber iwsNkgns1;

    public BizNumber getIwsNkgns1() {
        return iwsNkgns1;
    }

    public void setIwsNkgns1(BizNumber pIwsNkgns1) {
        iwsNkgns1 = pIwsNkgns1;
    }

    @Column(order = 595, length = 13)
    private BizNumber iwsNkgns2;

    public BizNumber getIwsNkgns2() {
        return iwsNkgns2;
    }

    public void setIwsNkgns2(BizNumber pIwsNkgns2) {
        iwsNkgns2 = pIwsNkgns2;
    }

    @Column(order = 596, length = 13)
    private BizNumber iwsNkgns3;

    public BizNumber getIwsNkgns3() {
        return iwsNkgns3;
    }

    public void setIwsNkgns3(BizNumber pIwsNkgns3) {
        iwsNkgns3 = pIwsNkgns3;
    }

    @Column(order = 597, length = 13)
    private BizNumber iwsNkgns4;

    public BizNumber getIwsNkgns4() {
        return iwsNkgns4;
    }

    public void setIwsNkgns4(BizNumber pIwsNkgns4) {
        iwsNkgns4 = pIwsNkgns4;
    }

    @Column(order = 598, length = 13)
    private BizNumber iwsSyonendonenkingaku1;

    public BizNumber getIwsSyonendonenkingaku1() {
        return iwsSyonendonenkingaku1;
    }

    public void setIwsSyonendonenkingaku1(BizNumber pIwsSyonendonenkingaku1) {
        iwsSyonendonenkingaku1 = pIwsSyonendonenkingaku1;
    }

    @Column(order = 599, length = 13)
    private BizNumber iwsSyonendonenkingaku2;

    public BizNumber getIwsSyonendonenkingaku2() {
        return iwsSyonendonenkingaku2;
    }

    public void setIwsSyonendonenkingaku2(BizNumber pIwsSyonendonenkingaku2) {
        iwsSyonendonenkingaku2 = pIwsSyonendonenkingaku2;
    }

    @Column(order = 600, length = 13)
    private BizNumber iwsSyonendonenkingaku3;

    public BizNumber getIwsSyonendonenkingaku3() {
        return iwsSyonendonenkingaku3;
    }

    public void setIwsSyonendonenkingaku3(BizNumber pIwsSyonendonenkingaku3) {
        iwsSyonendonenkingaku3 = pIwsSyonendonenkingaku3;
    }

    @Column(order = 601, length = 13)
    private BizNumber iwsSyonendonenkingaku4;

    public BizNumber getIwsSyonendonenkingaku4() {
        return iwsSyonendonenkingaku4;
    }

    public void setIwsSyonendonenkingaku4(BizNumber pIwsSyonendonenkingaku4) {
        iwsSyonendonenkingaku4 = pIwsSyonendonenkingaku4;
    }

    @Column(order = 602, length = 13)
    private BizNumber iwsJinendoikounenkingaku1;

    public BizNumber getIwsJinendoikounenkingaku1() {
        return iwsJinendoikounenkingaku1;
    }

    public void setIwsJinendoikounenkingaku1(BizNumber pIwsJinendoikounenkingaku1) {
        iwsJinendoikounenkingaku1 = pIwsJinendoikounenkingaku1;
    }

    @Column(order = 603, length = 13)
    private BizNumber iwsJinendoikounenkingaku2;

    public BizNumber getIwsJinendoikounenkingaku2() {
        return iwsJinendoikounenkingaku2;
    }

    public void setIwsJinendoikounenkingaku2(BizNumber pIwsJinendoikounenkingaku2) {
        iwsJinendoikounenkingaku2 = pIwsJinendoikounenkingaku2;
    }

    @Column(order = 604, length = 13)
    private BizNumber iwsJinendoikounenkingaku3;

    public BizNumber getIwsJinendoikounenkingaku3() {
        return iwsJinendoikounenkingaku3;
    }

    public void setIwsJinendoikounenkingaku3(BizNumber pIwsJinendoikounenkingaku3) {
        iwsJinendoikounenkingaku3 = pIwsJinendoikounenkingaku3;
    }

    @Column(order = 605, length = 13)
    private BizNumber iwsJinendoikounenkingaku4;

    public BizNumber getIwsJinendoikounenkingaku4() {
        return iwsJinendoikounenkingaku4;
    }

    public void setIwsJinendoikounenkingaku4(BizNumber pIwsJinendoikounenkingaku4) {
        iwsJinendoikounenkingaku4 = pIwsJinendoikounenkingaku4;
    }

    @Column(order = 606, length = 13)
    private BizNumber iwsNkuktsgk1;

    public BizNumber getIwsNkuktsgk1() {
        return iwsNkuktsgk1;
    }

    public void setIwsNkuktsgk1(BizNumber pIwsNkuktsgk1) {
        iwsNkuktsgk1 = pIwsNkuktsgk1;
    }

    @Column(order = 607, length = 13)
    private BizNumber iwsNkuktsgk2;

    public BizNumber getIwsNkuktsgk2() {
        return iwsNkuktsgk2;
    }

    public void setIwsNkuktsgk2(BizNumber pIwsNkuktsgk2) {
        iwsNkuktsgk2 = pIwsNkuktsgk2;
    }

    @Column(order = 608, length = 13)
    private BizNumber iwsNkuktsgk3;

    public BizNumber getIwsNkuktsgk3() {
        return iwsNkuktsgk3;
    }

    public void setIwsNkuktsgk3(BizNumber pIwsNkuktsgk3) {
        iwsNkuktsgk3 = pIwsNkuktsgk3;
    }

    @Column(order = 609, length = 13)
    private BizNumber iwsNkuktsgk4;

    public BizNumber getIwsNkuktsgk4() {
        return iwsNkuktsgk4;
    }

    public void setIwsNkuktsgk4(BizNumber pIwsNkuktsgk4) {
        iwsNkuktsgk4 = pIwsNkuktsgk4;
    }

    @Column(order = 610, length = 2)
    private String iwsNenkinsiharaikikan1;

    public String getIwsNenkinsiharaikikan1() {
        return iwsNenkinsiharaikikan1;
    }

    public void setIwsNenkinsiharaikikan1(String pIwsNenkinsiharaikikan1) {
        iwsNenkinsiharaikikan1 = pIwsNenkinsiharaikikan1;
    }

    @Column(order = 611, length = 2)
    private String iwsNenkinsiharaikikan2;

    public String getIwsNenkinsiharaikikan2() {
        return iwsNenkinsiharaikikan2;
    }

    public void setIwsNenkinsiharaikikan2(String pIwsNenkinsiharaikikan2) {
        iwsNenkinsiharaikikan2 = pIwsNenkinsiharaikikan2;
    }

    @Column(order = 612, length = 2)
    private String iwsNenkinsiharaikikan3;

    public String getIwsNenkinsiharaikikan3() {
        return iwsNenkinsiharaikikan3;
    }

    public void setIwsNenkinsiharaikikan3(String pIwsNenkinsiharaikikan3) {
        iwsNenkinsiharaikikan3 = pIwsNenkinsiharaikikan3;
    }

    @Column(order = 613, length = 2)
    private String iwsNenkinsiharaikikan4;

    public String getIwsNenkinsiharaikikan4() {
        return iwsNenkinsiharaikikan4;
    }

    public void setIwsNenkinsiharaikikan4(String pIwsNenkinsiharaikikan4) {
        iwsNenkinsiharaikikan4 = pIwsNenkinsiharaikikan4;
    }

    @Column(order = 614, length = 13)
    private BizNumber iwsHrkkknmnryutykgw1;

    public BizNumber getIwsHrkkknmnryutykgw1() {
        return iwsHrkkknmnryutykgw1;
    }

    public void setIwsHrkkknmnryutykgw1(BizNumber pIwsHrkkknmnryutykgw1) {
        iwsHrkkknmnryutykgw1 = pIwsHrkkknmnryutykgw1;
    }

    @Column(order = 615, length = 13)
    private BizNumber iwsHrkkknmnryutykgw2;

    public BizNumber getIwsHrkkknmnryutykgw2() {
        return iwsHrkkknmnryutykgw2;
    }

    public void setIwsHrkkknmnryutykgw2(BizNumber pIwsHrkkknmnryutykgw2) {
        iwsHrkkknmnryutykgw2 = pIwsHrkkknmnryutykgw2;
    }

    @Column(order = 616, length = 13)
    private BizNumber iwsHrkkknmnryutykgw3;

    public BizNumber getIwsHrkkknmnryutykgw3() {
        return iwsHrkkknmnryutykgw3;
    }

    public void setIwsHrkkknmnryutykgw3(BizNumber pIwsHrkkknmnryutykgw3) {
        iwsHrkkknmnryutykgw3 = pIwsHrkkknmnryutykgw3;
    }

    @Column(order = 617, length = 13)
    private BizNumber iwsHrkkknmnryutykgs1;

    public BizNumber getIwsHrkkknmnryutykgs1() {
        return iwsHrkkknmnryutykgs1;
    }

    public void setIwsHrkkknmnryutykgs1(BizNumber pIwsHrkkknmnryutykgs1) {
        iwsHrkkknmnryutykgs1 = pIwsHrkkknmnryutykgs1;
    }

    @Column(order = 618, length = 13)
    private BizNumber iwsHrkkknmnryutykgs2;

    public BizNumber getIwsHrkkknmnryutykgs2() {
        return iwsHrkkknmnryutykgs2;
    }

    public void setIwsHrkkknmnryutykgs2(BizNumber pIwsHrkkknmnryutykgs2) {
        iwsHrkkknmnryutykgs2 = pIwsHrkkknmnryutykgs2;
    }

    @Column(order = 619, length = 13)
    private BizNumber iwsHrkkknmnryutykgs3;

    public BizNumber getIwsHrkkknmnryutykgs3() {
        return iwsHrkkknmnryutykgs3;
    }

    public void setIwsHrkkknmnryutykgs3(BizNumber pIwsHrkkknmnryutykgs3) {
        iwsHrkkknmnryutykgs3 = pIwsHrkkknmnryutykgs3;
    }

    @Column(order = 620, length = 325)
    private String iwsYobiv325;

    public String getIwsYobiv325() {
        return iwsYobiv325;
    }

    public void setIwsYobiv325(String pIwsYobiv325) {
        iwsYobiv325 = pIwsYobiv325;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
