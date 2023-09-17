package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_HugouKbn;

/**
 * （保険募集）生保Ｗｅｂ外貨ＩＮＤＥＸ年金用解約返戻金推移表作成出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean() {
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
    private BizNumber iwsMaitositumitatekin1x1;

    public BizNumber getIwsMaitositumitatekin1x1() {
        return iwsMaitositumitatekin1x1;
    }

    public void setIwsMaitositumitatekin1x1(BizNumber pIwsMaitositumitatekin1x1) {
        iwsMaitositumitatekin1x1 = pIwsMaitositumitatekin1x1;
    }

    @Column(order = 5, length = 13)
    private BizNumber iwsMaitositumitatekin1x2;

    public BizNumber getIwsMaitositumitatekin1x2() {
        return iwsMaitositumitatekin1x2;
    }

    public void setIwsMaitositumitatekin1x2(BizNumber pIwsMaitositumitatekin1x2) {
        iwsMaitositumitatekin1x2 = pIwsMaitositumitatekin1x2;
    }

    @Column(order = 6, length = 13)
    private BizNumber iwsMaitositumitatekin1x3;

    public BizNumber getIwsMaitositumitatekin1x3() {
        return iwsMaitositumitatekin1x3;
    }

    public void setIwsMaitositumitatekin1x3(BizNumber pIwsMaitositumitatekin1x3) {
        iwsMaitositumitatekin1x3 = pIwsMaitositumitatekin1x3;
    }

    @Column(order = 7, length = 13)
    private BizNumber iwsMaitositumitatekin1x4;

    public BizNumber getIwsMaitositumitatekin1x4() {
        return iwsMaitositumitatekin1x4;
    }

    public void setIwsMaitositumitatekin1x4(BizNumber pIwsMaitositumitatekin1x4) {
        iwsMaitositumitatekin1x4 = pIwsMaitositumitatekin1x4;
    }

    @Column(order = 8, length = 13)
    private BizNumber iwsMaitositumitatekin1x5;

    public BizNumber getIwsMaitositumitatekin1x5() {
        return iwsMaitositumitatekin1x5;
    }

    public void setIwsMaitositumitatekin1x5(BizNumber pIwsMaitositumitatekin1x5) {
        iwsMaitositumitatekin1x5 = pIwsMaitositumitatekin1x5;
    }

    @Column(order = 9, length = 13)
    private BizNumber iwsMaitositumitatekin1x6;

    public BizNumber getIwsMaitositumitatekin1x6() {
        return iwsMaitositumitatekin1x6;
    }

    public void setIwsMaitositumitatekin1x6(BizNumber pIwsMaitositumitatekin1x6) {
        iwsMaitositumitatekin1x6 = pIwsMaitositumitatekin1x6;
    }

    @Column(order = 10, length = 13)
    private BizNumber iwsMaitositumitatekin1x7;

    public BizNumber getIwsMaitositumitatekin1x7() {
        return iwsMaitositumitatekin1x7;
    }

    public void setIwsMaitositumitatekin1x7(BizNumber pIwsMaitositumitatekin1x7) {
        iwsMaitositumitatekin1x7 = pIwsMaitositumitatekin1x7;
    }

    @Column(order = 11, length = 13)
    private BizNumber iwsMaitositumitatekin1x8;

    public BizNumber getIwsMaitositumitatekin1x8() {
        return iwsMaitositumitatekin1x8;
    }

    public void setIwsMaitositumitatekin1x8(BizNumber pIwsMaitositumitatekin1x8) {
        iwsMaitositumitatekin1x8 = pIwsMaitositumitatekin1x8;
    }

    @Column(order = 12, length = 13)
    private BizNumber iwsMaitositumitatekin1x9;

    public BizNumber getIwsMaitositumitatekin1x9() {
        return iwsMaitositumitatekin1x9;
    }

    public void setIwsMaitositumitatekin1x9(BizNumber pIwsMaitositumitatekin1x9) {
        iwsMaitositumitatekin1x9 = pIwsMaitositumitatekin1x9;
    }

    @Column(order = 13, length = 13)
    private BizNumber iwsMaitositumitatekin1x10;

    public BizNumber getIwsMaitositumitatekin1x10() {
        return iwsMaitositumitatekin1x10;
    }

    public void setIwsMaitositumitatekin1x10(BizNumber pIwsMaitositumitatekin1x10) {
        iwsMaitositumitatekin1x10 = pIwsMaitositumitatekin1x10;
    }

    @Column(order = 14, length = 13)
    private BizNumber iwsMaitositumitatekin1x11;

    public BizNumber getIwsMaitositumitatekin1x11() {
        return iwsMaitositumitatekin1x11;
    }

    public void setIwsMaitositumitatekin1x11(BizNumber pIwsMaitositumitatekin1x11) {
        iwsMaitositumitatekin1x11 = pIwsMaitositumitatekin1x11;
    }

    @Column(order = 15, length = 13)
    private BizNumber iwsMaitositumitatekin1x12;

    public BizNumber getIwsMaitositumitatekin1x12() {
        return iwsMaitositumitatekin1x12;
    }

    public void setIwsMaitositumitatekin1x12(BizNumber pIwsMaitositumitatekin1x12) {
        iwsMaitositumitatekin1x12 = pIwsMaitositumitatekin1x12;
    }

    @Column(order = 16, length = 13)
    private BizNumber iwsMaitositumitatekin1x13;

    public BizNumber getIwsMaitositumitatekin1x13() {
        return iwsMaitositumitatekin1x13;
    }

    public void setIwsMaitositumitatekin1x13(BizNumber pIwsMaitositumitatekin1x13) {
        iwsMaitositumitatekin1x13 = pIwsMaitositumitatekin1x13;
    }

    @Column(order = 17, length = 13)
    private BizNumber iwsMaitositumitatekin1x14;

    public BizNumber getIwsMaitositumitatekin1x14() {
        return iwsMaitositumitatekin1x14;
    }

    public void setIwsMaitositumitatekin1x14(BizNumber pIwsMaitositumitatekin1x14) {
        iwsMaitositumitatekin1x14 = pIwsMaitositumitatekin1x14;
    }

    @Column(order = 18, length = 13)
    private BizNumber iwsMaitositumitatekin1x15;

    public BizNumber getIwsMaitositumitatekin1x15() {
        return iwsMaitositumitatekin1x15;
    }

    public void setIwsMaitositumitatekin1x15(BizNumber pIwsMaitositumitatekin1x15) {
        iwsMaitositumitatekin1x15 = pIwsMaitositumitatekin1x15;
    }

    @Column(order = 19, length = 13)
    private BizNumber iwsMaitositumitatekin1x16;

    public BizNumber getIwsMaitositumitatekin1x16() {
        return iwsMaitositumitatekin1x16;
    }

    public void setIwsMaitositumitatekin1x16(BizNumber pIwsMaitositumitatekin1x16) {
        iwsMaitositumitatekin1x16 = pIwsMaitositumitatekin1x16;
    }

    @Column(order = 20, length = 13)
    private BizNumber iwsMaitositumitatekin1x17;

    public BizNumber getIwsMaitositumitatekin1x17() {
        return iwsMaitositumitatekin1x17;
    }

    public void setIwsMaitositumitatekin1x17(BizNumber pIwsMaitositumitatekin1x17) {
        iwsMaitositumitatekin1x17 = pIwsMaitositumitatekin1x17;
    }

    @Column(order = 21, length = 13)
    private BizNumber iwsMaitositumitatekin1x18;

    public BizNumber getIwsMaitositumitatekin1x18() {
        return iwsMaitositumitatekin1x18;
    }

    public void setIwsMaitositumitatekin1x18(BizNumber pIwsMaitositumitatekin1x18) {
        iwsMaitositumitatekin1x18 = pIwsMaitositumitatekin1x18;
    }

    @Column(order = 22, length = 13)
    private BizNumber iwsMaitositumitatekin1x19;

    public BizNumber getIwsMaitositumitatekin1x19() {
        return iwsMaitositumitatekin1x19;
    }

    public void setIwsMaitositumitatekin1x19(BizNumber pIwsMaitositumitatekin1x19) {
        iwsMaitositumitatekin1x19 = pIwsMaitositumitatekin1x19;
    }

    @Column(order = 23, length = 13)
    private BizNumber iwsMaitositumitatekin1x20;

    public BizNumber getIwsMaitositumitatekin1x20() {
        return iwsMaitositumitatekin1x20;
    }

    public void setIwsMaitositumitatekin1x20(BizNumber pIwsMaitositumitatekin1x20) {
        iwsMaitositumitatekin1x20 = pIwsMaitositumitatekin1x20;
    }

    @Column(order = 24, length = 13)
    private BizNumber iwsMaitositumitatekin2x1;

    public BizNumber getIwsMaitositumitatekin2x1() {
        return iwsMaitositumitatekin2x1;
    }

    public void setIwsMaitositumitatekin2x1(BizNumber pIwsMaitositumitatekin2x1) {
        iwsMaitositumitatekin2x1 = pIwsMaitositumitatekin2x1;
    }

    @Column(order = 25, length = 13)
    private BizNumber iwsMaitositumitatekin2x2;

    public BizNumber getIwsMaitositumitatekin2x2() {
        return iwsMaitositumitatekin2x2;
    }

    public void setIwsMaitositumitatekin2x2(BizNumber pIwsMaitositumitatekin2x2) {
        iwsMaitositumitatekin2x2 = pIwsMaitositumitatekin2x2;
    }

    @Column(order = 26, length = 13)
    private BizNumber iwsMaitositumitatekin2x3;

    public BizNumber getIwsMaitositumitatekin2x3() {
        return iwsMaitositumitatekin2x3;
    }

    public void setIwsMaitositumitatekin2x3(BizNumber pIwsMaitositumitatekin2x3) {
        iwsMaitositumitatekin2x3 = pIwsMaitositumitatekin2x3;
    }

    @Column(order = 27, length = 13)
    private BizNumber iwsMaitositumitatekin2x4;

    public BizNumber getIwsMaitositumitatekin2x4() {
        return iwsMaitositumitatekin2x4;
    }

    public void setIwsMaitositumitatekin2x4(BizNumber pIwsMaitositumitatekin2x4) {
        iwsMaitositumitatekin2x4 = pIwsMaitositumitatekin2x4;
    }

    @Column(order = 28, length = 13)
    private BizNumber iwsMaitositumitatekin2x5;

    public BizNumber getIwsMaitositumitatekin2x5() {
        return iwsMaitositumitatekin2x5;
    }

    public void setIwsMaitositumitatekin2x5(BizNumber pIwsMaitositumitatekin2x5) {
        iwsMaitositumitatekin2x5 = pIwsMaitositumitatekin2x5;
    }

    @Column(order = 29, length = 13)
    private BizNumber iwsMaitositumitatekin2x6;

    public BizNumber getIwsMaitositumitatekin2x6() {
        return iwsMaitositumitatekin2x6;
    }

    public void setIwsMaitositumitatekin2x6(BizNumber pIwsMaitositumitatekin2x6) {
        iwsMaitositumitatekin2x6 = pIwsMaitositumitatekin2x6;
    }

    @Column(order = 30, length = 13)
    private BizNumber iwsMaitositumitatekin2x7;

    public BizNumber getIwsMaitositumitatekin2x7() {
        return iwsMaitositumitatekin2x7;
    }

    public void setIwsMaitositumitatekin2x7(BizNumber pIwsMaitositumitatekin2x7) {
        iwsMaitositumitatekin2x7 = pIwsMaitositumitatekin2x7;
    }

    @Column(order = 31, length = 13)
    private BizNumber iwsMaitositumitatekin2x8;

    public BizNumber getIwsMaitositumitatekin2x8() {
        return iwsMaitositumitatekin2x8;
    }

    public void setIwsMaitositumitatekin2x8(BizNumber pIwsMaitositumitatekin2x8) {
        iwsMaitositumitatekin2x8 = pIwsMaitositumitatekin2x8;
    }

    @Column(order = 32, length = 13)
    private BizNumber iwsMaitositumitatekin2x9;

    public BizNumber getIwsMaitositumitatekin2x9() {
        return iwsMaitositumitatekin2x9;
    }

    public void setIwsMaitositumitatekin2x9(BizNumber pIwsMaitositumitatekin2x9) {
        iwsMaitositumitatekin2x9 = pIwsMaitositumitatekin2x9;
    }

    @Column(order = 33, length = 13)
    private BizNumber iwsMaitositumitatekin2x10;

    public BizNumber getIwsMaitositumitatekin2x10() {
        return iwsMaitositumitatekin2x10;
    }

    public void setIwsMaitositumitatekin2x10(BizNumber pIwsMaitositumitatekin2x10) {
        iwsMaitositumitatekin2x10 = pIwsMaitositumitatekin2x10;
    }

    @Column(order = 34, length = 13)
    private BizNumber iwsMaitositumitatekin2x11;

    public BizNumber getIwsMaitositumitatekin2x11() {
        return iwsMaitositumitatekin2x11;
    }

    public void setIwsMaitositumitatekin2x11(BizNumber pIwsMaitositumitatekin2x11) {
        iwsMaitositumitatekin2x11 = pIwsMaitositumitatekin2x11;
    }

    @Column(order = 35, length = 13)
    private BizNumber iwsMaitositumitatekin2x12;

    public BizNumber getIwsMaitositumitatekin2x12() {
        return iwsMaitositumitatekin2x12;
    }

    public void setIwsMaitositumitatekin2x12(BizNumber pIwsMaitositumitatekin2x12) {
        iwsMaitositumitatekin2x12 = pIwsMaitositumitatekin2x12;
    }

    @Column(order = 36, length = 13)
    private BizNumber iwsMaitositumitatekin2x13;

    public BizNumber getIwsMaitositumitatekin2x13() {
        return iwsMaitositumitatekin2x13;
    }

    public void setIwsMaitositumitatekin2x13(BizNumber pIwsMaitositumitatekin2x13) {
        iwsMaitositumitatekin2x13 = pIwsMaitositumitatekin2x13;
    }

    @Column(order = 37, length = 13)
    private BizNumber iwsMaitositumitatekin2x14;

    public BizNumber getIwsMaitositumitatekin2x14() {
        return iwsMaitositumitatekin2x14;
    }

    public void setIwsMaitositumitatekin2x14(BizNumber pIwsMaitositumitatekin2x14) {
        iwsMaitositumitatekin2x14 = pIwsMaitositumitatekin2x14;
    }

    @Column(order = 38, length = 13)
    private BizNumber iwsMaitositumitatekin2x15;

    public BizNumber getIwsMaitositumitatekin2x15() {
        return iwsMaitositumitatekin2x15;
    }

    public void setIwsMaitositumitatekin2x15(BizNumber pIwsMaitositumitatekin2x15) {
        iwsMaitositumitatekin2x15 = pIwsMaitositumitatekin2x15;
    }

    @Column(order = 39, length = 13)
    private BizNumber iwsMaitositumitatekin2x16;

    public BizNumber getIwsMaitositumitatekin2x16() {
        return iwsMaitositumitatekin2x16;
    }

    public void setIwsMaitositumitatekin2x16(BizNumber pIwsMaitositumitatekin2x16) {
        iwsMaitositumitatekin2x16 = pIwsMaitositumitatekin2x16;
    }

    @Column(order = 40, length = 13)
    private BizNumber iwsMaitositumitatekin2x17;

    public BizNumber getIwsMaitositumitatekin2x17() {
        return iwsMaitositumitatekin2x17;
    }

    public void setIwsMaitositumitatekin2x17(BizNumber pIwsMaitositumitatekin2x17) {
        iwsMaitositumitatekin2x17 = pIwsMaitositumitatekin2x17;
    }

    @Column(order = 41, length = 13)
    private BizNumber iwsMaitositumitatekin2x18;

    public BizNumber getIwsMaitositumitatekin2x18() {
        return iwsMaitositumitatekin2x18;
    }

    public void setIwsMaitositumitatekin2x18(BizNumber pIwsMaitositumitatekin2x18) {
        iwsMaitositumitatekin2x18 = pIwsMaitositumitatekin2x18;
    }

    @Column(order = 42, length = 13)
    private BizNumber iwsMaitositumitatekin2x19;

    public BizNumber getIwsMaitositumitatekin2x19() {
        return iwsMaitositumitatekin2x19;
    }

    public void setIwsMaitositumitatekin2x19(BizNumber pIwsMaitositumitatekin2x19) {
        iwsMaitositumitatekin2x19 = pIwsMaitositumitatekin2x19;
    }

    @Column(order = 43, length = 13)
    private BizNumber iwsMaitositumitatekin2x20;

    public BizNumber getIwsMaitositumitatekin2x20() {
        return iwsMaitositumitatekin2x20;
    }

    public void setIwsMaitositumitatekin2x20(BizNumber pIwsMaitositumitatekin2x20) {
        iwsMaitositumitatekin2x20 = pIwsMaitositumitatekin2x20;
    }

    @Column(order = 44, length = 13)
    private BizNumber iwsMaitositumitatekin3x1;

    public BizNumber getIwsMaitositumitatekin3x1() {
        return iwsMaitositumitatekin3x1;
    }

    public void setIwsMaitositumitatekin3x1(BizNumber pIwsMaitositumitatekin3x1) {
        iwsMaitositumitatekin3x1 = pIwsMaitositumitatekin3x1;
    }

    @Column(order = 45, length = 13)
    private BizNumber iwsMaitositumitatekin3x2;

    public BizNumber getIwsMaitositumitatekin3x2() {
        return iwsMaitositumitatekin3x2;
    }

    public void setIwsMaitositumitatekin3x2(BizNumber pIwsMaitositumitatekin3x2) {
        iwsMaitositumitatekin3x2 = pIwsMaitositumitatekin3x2;
    }

    @Column(order = 46, length = 13)
    private BizNumber iwsMaitositumitatekin3x3;

    public BizNumber getIwsMaitositumitatekin3x3() {
        return iwsMaitositumitatekin3x3;
    }

    public void setIwsMaitositumitatekin3x3(BizNumber pIwsMaitositumitatekin3x3) {
        iwsMaitositumitatekin3x3 = pIwsMaitositumitatekin3x3;
    }

    @Column(order = 47, length = 13)
    private BizNumber iwsMaitositumitatekin3x4;

    public BizNumber getIwsMaitositumitatekin3x4() {
        return iwsMaitositumitatekin3x4;
    }

    public void setIwsMaitositumitatekin3x4(BizNumber pIwsMaitositumitatekin3x4) {
        iwsMaitositumitatekin3x4 = pIwsMaitositumitatekin3x4;
    }

    @Column(order = 48, length = 13)
    private BizNumber iwsMaitositumitatekin3x5;

    public BizNumber getIwsMaitositumitatekin3x5() {
        return iwsMaitositumitatekin3x5;
    }

    public void setIwsMaitositumitatekin3x5(BizNumber pIwsMaitositumitatekin3x5) {
        iwsMaitositumitatekin3x5 = pIwsMaitositumitatekin3x5;
    }

    @Column(order = 49, length = 13)
    private BizNumber iwsMaitositumitatekin3x6;

    public BizNumber getIwsMaitositumitatekin3x6() {
        return iwsMaitositumitatekin3x6;
    }

    public void setIwsMaitositumitatekin3x6(BizNumber pIwsMaitositumitatekin3x6) {
        iwsMaitositumitatekin3x6 = pIwsMaitositumitatekin3x6;
    }

    @Column(order = 50, length = 13)
    private BizNumber iwsMaitositumitatekin3x7;

    public BizNumber getIwsMaitositumitatekin3x7() {
        return iwsMaitositumitatekin3x7;
    }

    public void setIwsMaitositumitatekin3x7(BizNumber pIwsMaitositumitatekin3x7) {
        iwsMaitositumitatekin3x7 = pIwsMaitositumitatekin3x7;
    }

    @Column(order = 51, length = 13)
    private BizNumber iwsMaitositumitatekin3x8;

    public BizNumber getIwsMaitositumitatekin3x8() {
        return iwsMaitositumitatekin3x8;
    }

    public void setIwsMaitositumitatekin3x8(BizNumber pIwsMaitositumitatekin3x8) {
        iwsMaitositumitatekin3x8 = pIwsMaitositumitatekin3x8;
    }

    @Column(order = 52, length = 13)
    private BizNumber iwsMaitositumitatekin3x9;

    public BizNumber getIwsMaitositumitatekin3x9() {
        return iwsMaitositumitatekin3x9;
    }

    public void setIwsMaitositumitatekin3x9(BizNumber pIwsMaitositumitatekin3x9) {
        iwsMaitositumitatekin3x9 = pIwsMaitositumitatekin3x9;
    }

    @Column(order = 53, length = 13)
    private BizNumber iwsMaitositumitatekin3x10;

    public BizNumber getIwsMaitositumitatekin3x10() {
        return iwsMaitositumitatekin3x10;
    }

    public void setIwsMaitositumitatekin3x10(BizNumber pIwsMaitositumitatekin3x10) {
        iwsMaitositumitatekin3x10 = pIwsMaitositumitatekin3x10;
    }

    @Column(order = 54, length = 13)
    private BizNumber iwsMaitositumitatekin3x11;

    public BizNumber getIwsMaitositumitatekin3x11() {
        return iwsMaitositumitatekin3x11;
    }

    public void setIwsMaitositumitatekin3x11(BizNumber pIwsMaitositumitatekin3x11) {
        iwsMaitositumitatekin3x11 = pIwsMaitositumitatekin3x11;
    }

    @Column(order = 55, length = 13)
    private BizNumber iwsMaitositumitatekin3x12;

    public BizNumber getIwsMaitositumitatekin3x12() {
        return iwsMaitositumitatekin3x12;
    }

    public void setIwsMaitositumitatekin3x12(BizNumber pIwsMaitositumitatekin3x12) {
        iwsMaitositumitatekin3x12 = pIwsMaitositumitatekin3x12;
    }

    @Column(order = 56, length = 13)
    private BizNumber iwsMaitositumitatekin3x13;

    public BizNumber getIwsMaitositumitatekin3x13() {
        return iwsMaitositumitatekin3x13;
    }

    public void setIwsMaitositumitatekin3x13(BizNumber pIwsMaitositumitatekin3x13) {
        iwsMaitositumitatekin3x13 = pIwsMaitositumitatekin3x13;
    }

    @Column(order = 57, length = 13)
    private BizNumber iwsMaitositumitatekin3x14;

    public BizNumber getIwsMaitositumitatekin3x14() {
        return iwsMaitositumitatekin3x14;
    }

    public void setIwsMaitositumitatekin3x14(BizNumber pIwsMaitositumitatekin3x14) {
        iwsMaitositumitatekin3x14 = pIwsMaitositumitatekin3x14;
    }

    @Column(order = 58, length = 13)
    private BizNumber iwsMaitositumitatekin3x15;

    public BizNumber getIwsMaitositumitatekin3x15() {
        return iwsMaitositumitatekin3x15;
    }

    public void setIwsMaitositumitatekin3x15(BizNumber pIwsMaitositumitatekin3x15) {
        iwsMaitositumitatekin3x15 = pIwsMaitositumitatekin3x15;
    }

    @Column(order = 59, length = 13)
    private BizNumber iwsMaitositumitatekin3x16;

    public BizNumber getIwsMaitositumitatekin3x16() {
        return iwsMaitositumitatekin3x16;
    }

    public void setIwsMaitositumitatekin3x16(BizNumber pIwsMaitositumitatekin3x16) {
        iwsMaitositumitatekin3x16 = pIwsMaitositumitatekin3x16;
    }

    @Column(order = 60, length = 13)
    private BizNumber iwsMaitositumitatekin3x17;

    public BizNumber getIwsMaitositumitatekin3x17() {
        return iwsMaitositumitatekin3x17;
    }

    public void setIwsMaitositumitatekin3x17(BizNumber pIwsMaitositumitatekin3x17) {
        iwsMaitositumitatekin3x17 = pIwsMaitositumitatekin3x17;
    }

    @Column(order = 61, length = 13)
    private BizNumber iwsMaitositumitatekin3x18;

    public BizNumber getIwsMaitositumitatekin3x18() {
        return iwsMaitositumitatekin3x18;
    }

    public void setIwsMaitositumitatekin3x18(BizNumber pIwsMaitositumitatekin3x18) {
        iwsMaitositumitatekin3x18 = pIwsMaitositumitatekin3x18;
    }

    @Column(order = 62, length = 13)
    private BizNumber iwsMaitositumitatekin3x19;

    public BizNumber getIwsMaitositumitatekin3x19() {
        return iwsMaitositumitatekin3x19;
    }

    public void setIwsMaitositumitatekin3x19(BizNumber pIwsMaitositumitatekin3x19) {
        iwsMaitositumitatekin3x19 = pIwsMaitositumitatekin3x19;
    }

    @Column(order = 63, length = 13)
    private BizNumber iwsMaitositumitatekin3x20;

    public BizNumber getIwsMaitositumitatekin3x20() {
        return iwsMaitositumitatekin3x20;
    }

    public void setIwsMaitositumitatekin3x20(BizNumber pIwsMaitositumitatekin3x20) {
        iwsMaitositumitatekin3x20 = pIwsMaitositumitatekin3x20;
    }

    @Column(order = 64, length = 13)
    private BizNumber iwsMaitositumitatekin4x1;

    public BizNumber getIwsMaitositumitatekin4x1() {
        return iwsMaitositumitatekin4x1;
    }

    public void setIwsMaitositumitatekin4x1(BizNumber pIwsMaitositumitatekin4x1) {
        iwsMaitositumitatekin4x1 = pIwsMaitositumitatekin4x1;
    }

    @Column(order = 65, length = 13)
    private BizNumber iwsMaitositumitatekin4x2;

    public BizNumber getIwsMaitositumitatekin4x2() {
        return iwsMaitositumitatekin4x2;
    }

    public void setIwsMaitositumitatekin4x2(BizNumber pIwsMaitositumitatekin4x2) {
        iwsMaitositumitatekin4x2 = pIwsMaitositumitatekin4x2;
    }

    @Column(order = 66, length = 13)
    private BizNumber iwsMaitositumitatekin4x3;

    public BizNumber getIwsMaitositumitatekin4x3() {
        return iwsMaitositumitatekin4x3;
    }

    public void setIwsMaitositumitatekin4x3(BizNumber pIwsMaitositumitatekin4x3) {
        iwsMaitositumitatekin4x3 = pIwsMaitositumitatekin4x3;
    }

    @Column(order = 67, length = 13)
    private BizNumber iwsMaitositumitatekin4x4;

    public BizNumber getIwsMaitositumitatekin4x4() {
        return iwsMaitositumitatekin4x4;
    }

    public void setIwsMaitositumitatekin4x4(BizNumber pIwsMaitositumitatekin4x4) {
        iwsMaitositumitatekin4x4 = pIwsMaitositumitatekin4x4;
    }

    @Column(order = 68, length = 13)
    private BizNumber iwsMaitositumitatekin4x5;

    public BizNumber getIwsMaitositumitatekin4x5() {
        return iwsMaitositumitatekin4x5;
    }

    public void setIwsMaitositumitatekin4x5(BizNumber pIwsMaitositumitatekin4x5) {
        iwsMaitositumitatekin4x5 = pIwsMaitositumitatekin4x5;
    }

    @Column(order = 69, length = 13)
    private BizNumber iwsMaitositumitatekin4x6;

    public BizNumber getIwsMaitositumitatekin4x6() {
        return iwsMaitositumitatekin4x6;
    }

    public void setIwsMaitositumitatekin4x6(BizNumber pIwsMaitositumitatekin4x6) {
        iwsMaitositumitatekin4x6 = pIwsMaitositumitatekin4x6;
    }

    @Column(order = 70, length = 13)
    private BizNumber iwsMaitositumitatekin4x7;

    public BizNumber getIwsMaitositumitatekin4x7() {
        return iwsMaitositumitatekin4x7;
    }

    public void setIwsMaitositumitatekin4x7(BizNumber pIwsMaitositumitatekin4x7) {
        iwsMaitositumitatekin4x7 = pIwsMaitositumitatekin4x7;
    }

    @Column(order = 71, length = 13)
    private BizNumber iwsMaitositumitatekin4x8;

    public BizNumber getIwsMaitositumitatekin4x8() {
        return iwsMaitositumitatekin4x8;
    }

    public void setIwsMaitositumitatekin4x8(BizNumber pIwsMaitositumitatekin4x8) {
        iwsMaitositumitatekin4x8 = pIwsMaitositumitatekin4x8;
    }

    @Column(order = 72, length = 13)
    private BizNumber iwsMaitositumitatekin4x9;

    public BizNumber getIwsMaitositumitatekin4x9() {
        return iwsMaitositumitatekin4x9;
    }

    public void setIwsMaitositumitatekin4x9(BizNumber pIwsMaitositumitatekin4x9) {
        iwsMaitositumitatekin4x9 = pIwsMaitositumitatekin4x9;
    }

    @Column(order = 73, length = 13)
    private BizNumber iwsMaitositumitatekin4x10;

    public BizNumber getIwsMaitositumitatekin4x10() {
        return iwsMaitositumitatekin4x10;
    }

    public void setIwsMaitositumitatekin4x10(BizNumber pIwsMaitositumitatekin4x10) {
        iwsMaitositumitatekin4x10 = pIwsMaitositumitatekin4x10;
    }

    @Column(order = 74, length = 13)
    private BizNumber iwsMaitositumitatekin4x11;

    public BizNumber getIwsMaitositumitatekin4x11() {
        return iwsMaitositumitatekin4x11;
    }

    public void setIwsMaitositumitatekin4x11(BizNumber pIwsMaitositumitatekin4x11) {
        iwsMaitositumitatekin4x11 = pIwsMaitositumitatekin4x11;
    }

    @Column(order = 75, length = 13)
    private BizNumber iwsMaitositumitatekin4x12;

    public BizNumber getIwsMaitositumitatekin4x12() {
        return iwsMaitositumitatekin4x12;
    }

    public void setIwsMaitositumitatekin4x12(BizNumber pIwsMaitositumitatekin4x12) {
        iwsMaitositumitatekin4x12 = pIwsMaitositumitatekin4x12;
    }

    @Column(order = 76, length = 13)
    private BizNumber iwsMaitositumitatekin4x13;

    public BizNumber getIwsMaitositumitatekin4x13() {
        return iwsMaitositumitatekin4x13;
    }

    public void setIwsMaitositumitatekin4x13(BizNumber pIwsMaitositumitatekin4x13) {
        iwsMaitositumitatekin4x13 = pIwsMaitositumitatekin4x13;
    }

    @Column(order = 77, length = 13)
    private BizNumber iwsMaitositumitatekin4x14;

    public BizNumber getIwsMaitositumitatekin4x14() {
        return iwsMaitositumitatekin4x14;
    }

    public void setIwsMaitositumitatekin4x14(BizNumber pIwsMaitositumitatekin4x14) {
        iwsMaitositumitatekin4x14 = pIwsMaitositumitatekin4x14;
    }

    @Column(order = 78, length = 13)
    private BizNumber iwsMaitositumitatekin4x15;

    public BizNumber getIwsMaitositumitatekin4x15() {
        return iwsMaitositumitatekin4x15;
    }

    public void setIwsMaitositumitatekin4x15(BizNumber pIwsMaitositumitatekin4x15) {
        iwsMaitositumitatekin4x15 = pIwsMaitositumitatekin4x15;
    }

    @Column(order = 79, length = 13)
    private BizNumber iwsMaitositumitatekin4x16;

    public BizNumber getIwsMaitositumitatekin4x16() {
        return iwsMaitositumitatekin4x16;
    }

    public void setIwsMaitositumitatekin4x16(BizNumber pIwsMaitositumitatekin4x16) {
        iwsMaitositumitatekin4x16 = pIwsMaitositumitatekin4x16;
    }

    @Column(order = 80, length = 13)
    private BizNumber iwsMaitositumitatekin4x17;

    public BizNumber getIwsMaitositumitatekin4x17() {
        return iwsMaitositumitatekin4x17;
    }

    public void setIwsMaitositumitatekin4x17(BizNumber pIwsMaitositumitatekin4x17) {
        iwsMaitositumitatekin4x17 = pIwsMaitositumitatekin4x17;
    }

    @Column(order = 81, length = 13)
    private BizNumber iwsMaitositumitatekin4x18;

    public BizNumber getIwsMaitositumitatekin4x18() {
        return iwsMaitositumitatekin4x18;
    }

    public void setIwsMaitositumitatekin4x18(BizNumber pIwsMaitositumitatekin4x18) {
        iwsMaitositumitatekin4x18 = pIwsMaitositumitatekin4x18;
    }

    @Column(order = 82, length = 13)
    private BizNumber iwsMaitositumitatekin4x19;

    public BizNumber getIwsMaitositumitatekin4x19() {
        return iwsMaitositumitatekin4x19;
    }

    public void setIwsMaitositumitatekin4x19(BizNumber pIwsMaitositumitatekin4x19) {
        iwsMaitositumitatekin4x19 = pIwsMaitositumitatekin4x19;
    }

    @Column(order = 83, length = 13)
    private BizNumber iwsMaitositumitatekin4x20;

    public BizNumber getIwsMaitositumitatekin4x20() {
        return iwsMaitositumitatekin4x20;
    }

    public void setIwsMaitositumitatekin4x20(BizNumber pIwsMaitositumitatekin4x20) {
        iwsMaitositumitatekin4x20 = pIwsMaitositumitatekin4x20;
    }

    @Column(order = 84, length = 13)
    private BizNumber iwsMaitositumitatekin5x1;

    public BizNumber getIwsMaitositumitatekin5x1() {
        return iwsMaitositumitatekin5x1;
    }

    public void setIwsMaitositumitatekin5x1(BizNumber pIwsMaitositumitatekin5x1) {
        iwsMaitositumitatekin5x1 = pIwsMaitositumitatekin5x1;
    }

    @Column(order = 85, length = 13)
    private BizNumber iwsMaitositumitatekin5x2;

    public BizNumber getIwsMaitositumitatekin5x2() {
        return iwsMaitositumitatekin5x2;
    }

    public void setIwsMaitositumitatekin5x2(BizNumber pIwsMaitositumitatekin5x2) {
        iwsMaitositumitatekin5x2 = pIwsMaitositumitatekin5x2;
    }

    @Column(order = 86, length = 13)
    private BizNumber iwsMaitositumitatekin5x3;

    public BizNumber getIwsMaitositumitatekin5x3() {
        return iwsMaitositumitatekin5x3;
    }

    public void setIwsMaitositumitatekin5x3(BizNumber pIwsMaitositumitatekin5x3) {
        iwsMaitositumitatekin5x3 = pIwsMaitositumitatekin5x3;
    }

    @Column(order = 87, length = 13)
    private BizNumber iwsMaitositumitatekin5x4;

    public BizNumber getIwsMaitositumitatekin5x4() {
        return iwsMaitositumitatekin5x4;
    }

    public void setIwsMaitositumitatekin5x4(BizNumber pIwsMaitositumitatekin5x4) {
        iwsMaitositumitatekin5x4 = pIwsMaitositumitatekin5x4;
    }

    @Column(order = 88, length = 13)
    private BizNumber iwsMaitositumitatekin5x5;

    public BizNumber getIwsMaitositumitatekin5x5() {
        return iwsMaitositumitatekin5x5;
    }

    public void setIwsMaitositumitatekin5x5(BizNumber pIwsMaitositumitatekin5x5) {
        iwsMaitositumitatekin5x5 = pIwsMaitositumitatekin5x5;
    }

    @Column(order = 89, length = 13)
    private BizNumber iwsMaitositumitatekin5x6;

    public BizNumber getIwsMaitositumitatekin5x6() {
        return iwsMaitositumitatekin5x6;
    }

    public void setIwsMaitositumitatekin5x6(BizNumber pIwsMaitositumitatekin5x6) {
        iwsMaitositumitatekin5x6 = pIwsMaitositumitatekin5x6;
    }

    @Column(order = 90, length = 13)
    private BizNumber iwsMaitositumitatekin5x7;

    public BizNumber getIwsMaitositumitatekin5x7() {
        return iwsMaitositumitatekin5x7;
    }

    public void setIwsMaitositumitatekin5x7(BizNumber pIwsMaitositumitatekin5x7) {
        iwsMaitositumitatekin5x7 = pIwsMaitositumitatekin5x7;
    }

    @Column(order = 91, length = 13)
    private BizNumber iwsMaitositumitatekin5x8;

    public BizNumber getIwsMaitositumitatekin5x8() {
        return iwsMaitositumitatekin5x8;
    }

    public void setIwsMaitositumitatekin5x8(BizNumber pIwsMaitositumitatekin5x8) {
        iwsMaitositumitatekin5x8 = pIwsMaitositumitatekin5x8;
    }

    @Column(order = 92, length = 13)
    private BizNumber iwsMaitositumitatekin5x9;

    public BizNumber getIwsMaitositumitatekin5x9() {
        return iwsMaitositumitatekin5x9;
    }

    public void setIwsMaitositumitatekin5x9(BizNumber pIwsMaitositumitatekin5x9) {
        iwsMaitositumitatekin5x9 = pIwsMaitositumitatekin5x9;
    }

    @Column(order = 93, length = 13)
    private BizNumber iwsMaitositumitatekin5x10;

    public BizNumber getIwsMaitositumitatekin5x10() {
        return iwsMaitositumitatekin5x10;
    }

    public void setIwsMaitositumitatekin5x10(BizNumber pIwsMaitositumitatekin5x10) {
        iwsMaitositumitatekin5x10 = pIwsMaitositumitatekin5x10;
    }

    @Column(order = 94, length = 13)
    private BizNumber iwsMaitositumitatekin5x11;

    public BizNumber getIwsMaitositumitatekin5x11() {
        return iwsMaitositumitatekin5x11;
    }

    public void setIwsMaitositumitatekin5x11(BizNumber pIwsMaitositumitatekin5x11) {
        iwsMaitositumitatekin5x11 = pIwsMaitositumitatekin5x11;
    }

    @Column(order = 95, length = 13)
    private BizNumber iwsMaitositumitatekin5x12;

    public BizNumber getIwsMaitositumitatekin5x12() {
        return iwsMaitositumitatekin5x12;
    }

    public void setIwsMaitositumitatekin5x12(BizNumber pIwsMaitositumitatekin5x12) {
        iwsMaitositumitatekin5x12 = pIwsMaitositumitatekin5x12;
    }

    @Column(order = 96, length = 13)
    private BizNumber iwsMaitositumitatekin5x13;

    public BizNumber getIwsMaitositumitatekin5x13() {
        return iwsMaitositumitatekin5x13;
    }

    public void setIwsMaitositumitatekin5x13(BizNumber pIwsMaitositumitatekin5x13) {
        iwsMaitositumitatekin5x13 = pIwsMaitositumitatekin5x13;
    }

    @Column(order = 97, length = 13)
    private BizNumber iwsMaitositumitatekin5x14;

    public BizNumber getIwsMaitositumitatekin5x14() {
        return iwsMaitositumitatekin5x14;
    }

    public void setIwsMaitositumitatekin5x14(BizNumber pIwsMaitositumitatekin5x14) {
        iwsMaitositumitatekin5x14 = pIwsMaitositumitatekin5x14;
    }

    @Column(order = 98, length = 13)
    private BizNumber iwsMaitositumitatekin5x15;

    public BizNumber getIwsMaitositumitatekin5x15() {
        return iwsMaitositumitatekin5x15;
    }

    public void setIwsMaitositumitatekin5x15(BizNumber pIwsMaitositumitatekin5x15) {
        iwsMaitositumitatekin5x15 = pIwsMaitositumitatekin5x15;
    }

    @Column(order = 99, length = 13)
    private BizNumber iwsMaitositumitatekin5x16;

    public BizNumber getIwsMaitositumitatekin5x16() {
        return iwsMaitositumitatekin5x16;
    }

    public void setIwsMaitositumitatekin5x16(BizNumber pIwsMaitositumitatekin5x16) {
        iwsMaitositumitatekin5x16 = pIwsMaitositumitatekin5x16;
    }

    @Column(order = 100, length = 13)
    private BizNumber iwsMaitositumitatekin5x17;

    public BizNumber getIwsMaitositumitatekin5x17() {
        return iwsMaitositumitatekin5x17;
    }

    public void setIwsMaitositumitatekin5x17(BizNumber pIwsMaitositumitatekin5x17) {
        iwsMaitositumitatekin5x17 = pIwsMaitositumitatekin5x17;
    }

    @Column(order = 101, length = 13)
    private BizNumber iwsMaitositumitatekin5x18;

    public BizNumber getIwsMaitositumitatekin5x18() {
        return iwsMaitositumitatekin5x18;
    }

    public void setIwsMaitositumitatekin5x18(BizNumber pIwsMaitositumitatekin5x18) {
        iwsMaitositumitatekin5x18 = pIwsMaitositumitatekin5x18;
    }

    @Column(order = 102, length = 13)
    private BizNumber iwsMaitositumitatekin5x19;

    public BizNumber getIwsMaitositumitatekin5x19() {
        return iwsMaitositumitatekin5x19;
    }

    public void setIwsMaitositumitatekin5x19(BizNumber pIwsMaitositumitatekin5x19) {
        iwsMaitositumitatekin5x19 = pIwsMaitositumitatekin5x19;
    }

    @Column(order = 103, length = 13)
    private BizNumber iwsMaitositumitatekin5x20;

    public BizNumber getIwsMaitositumitatekin5x20() {
        return iwsMaitositumitatekin5x20;
    }

    public void setIwsMaitositumitatekin5x20(BizNumber pIwsMaitositumitatekin5x20) {
        iwsMaitositumitatekin5x20 = pIwsMaitositumitatekin5x20;
    }

    @Column(order = 104, length = 13)
    private BizNumber iwsMaitositumitatekin6x1;

    public BizNumber getIwsMaitositumitatekin6x1() {
        return iwsMaitositumitatekin6x1;
    }

    public void setIwsMaitositumitatekin6x1(BizNumber pIwsMaitositumitatekin6x1) {
        iwsMaitositumitatekin6x1 = pIwsMaitositumitatekin6x1;
    }

    @Column(order = 105, length = 13)
    private BizNumber iwsMaitositumitatekin6x2;

    public BizNumber getIwsMaitositumitatekin6x2() {
        return iwsMaitositumitatekin6x2;
    }

    public void setIwsMaitositumitatekin6x2(BizNumber pIwsMaitositumitatekin6x2) {
        iwsMaitositumitatekin6x2 = pIwsMaitositumitatekin6x2;
    }

    @Column(order = 106, length = 13)
    private BizNumber iwsMaitositumitatekin6x3;

    public BizNumber getIwsMaitositumitatekin6x3() {
        return iwsMaitositumitatekin6x3;
    }

    public void setIwsMaitositumitatekin6x3(BizNumber pIwsMaitositumitatekin6x3) {
        iwsMaitositumitatekin6x3 = pIwsMaitositumitatekin6x3;
    }

    @Column(order = 107, length = 13)
    private BizNumber iwsMaitositumitatekin6x4;

    public BizNumber getIwsMaitositumitatekin6x4() {
        return iwsMaitositumitatekin6x4;
    }

    public void setIwsMaitositumitatekin6x4(BizNumber pIwsMaitositumitatekin6x4) {
        iwsMaitositumitatekin6x4 = pIwsMaitositumitatekin6x4;
    }

    @Column(order = 108, length = 13)
    private BizNumber iwsMaitositumitatekin6x5;

    public BizNumber getIwsMaitositumitatekin6x5() {
        return iwsMaitositumitatekin6x5;
    }

    public void setIwsMaitositumitatekin6x5(BizNumber pIwsMaitositumitatekin6x5) {
        iwsMaitositumitatekin6x5 = pIwsMaitositumitatekin6x5;
    }

    @Column(order = 109, length = 13)
    private BizNumber iwsMaitositumitatekin6x6;

    public BizNumber getIwsMaitositumitatekin6x6() {
        return iwsMaitositumitatekin6x6;
    }

    public void setIwsMaitositumitatekin6x6(BizNumber pIwsMaitositumitatekin6x6) {
        iwsMaitositumitatekin6x6 = pIwsMaitositumitatekin6x6;
    }

    @Column(order = 110, length = 13)
    private BizNumber iwsMaitositumitatekin6x7;

    public BizNumber getIwsMaitositumitatekin6x7() {
        return iwsMaitositumitatekin6x7;
    }

    public void setIwsMaitositumitatekin6x7(BizNumber pIwsMaitositumitatekin6x7) {
        iwsMaitositumitatekin6x7 = pIwsMaitositumitatekin6x7;
    }

    @Column(order = 111, length = 13)
    private BizNumber iwsMaitositumitatekin6x8;

    public BizNumber getIwsMaitositumitatekin6x8() {
        return iwsMaitositumitatekin6x8;
    }

    public void setIwsMaitositumitatekin6x8(BizNumber pIwsMaitositumitatekin6x8) {
        iwsMaitositumitatekin6x8 = pIwsMaitositumitatekin6x8;
    }

    @Column(order = 112, length = 13)
    private BizNumber iwsMaitositumitatekin6x9;

    public BizNumber getIwsMaitositumitatekin6x9() {
        return iwsMaitositumitatekin6x9;
    }

    public void setIwsMaitositumitatekin6x9(BizNumber pIwsMaitositumitatekin6x9) {
        iwsMaitositumitatekin6x9 = pIwsMaitositumitatekin6x9;
    }

    @Column(order = 113, length = 13)
    private BizNumber iwsMaitositumitatekin6x10;

    public BizNumber getIwsMaitositumitatekin6x10() {
        return iwsMaitositumitatekin6x10;
    }

    public void setIwsMaitositumitatekin6x10(BizNumber pIwsMaitositumitatekin6x10) {
        iwsMaitositumitatekin6x10 = pIwsMaitositumitatekin6x10;
    }

    @Column(order = 114, length = 13)
    private BizNumber iwsMaitositumitatekin6x11;

    public BizNumber getIwsMaitositumitatekin6x11() {
        return iwsMaitositumitatekin6x11;
    }

    public void setIwsMaitositumitatekin6x11(BizNumber pIwsMaitositumitatekin6x11) {
        iwsMaitositumitatekin6x11 = pIwsMaitositumitatekin6x11;
    }

    @Column(order = 115, length = 13)
    private BizNumber iwsMaitositumitatekin6x12;

    public BizNumber getIwsMaitositumitatekin6x12() {
        return iwsMaitositumitatekin6x12;
    }

    public void setIwsMaitositumitatekin6x12(BizNumber pIwsMaitositumitatekin6x12) {
        iwsMaitositumitatekin6x12 = pIwsMaitositumitatekin6x12;
    }

    @Column(order = 116, length = 13)
    private BizNumber iwsMaitositumitatekin6x13;

    public BizNumber getIwsMaitositumitatekin6x13() {
        return iwsMaitositumitatekin6x13;
    }

    public void setIwsMaitositumitatekin6x13(BizNumber pIwsMaitositumitatekin6x13) {
        iwsMaitositumitatekin6x13 = pIwsMaitositumitatekin6x13;
    }

    @Column(order = 117, length = 13)
    private BizNumber iwsMaitositumitatekin6x14;

    public BizNumber getIwsMaitositumitatekin6x14() {
        return iwsMaitositumitatekin6x14;
    }

    public void setIwsMaitositumitatekin6x14(BizNumber pIwsMaitositumitatekin6x14) {
        iwsMaitositumitatekin6x14 = pIwsMaitositumitatekin6x14;
    }

    @Column(order = 118, length = 13)
    private BizNumber iwsMaitositumitatekin6x15;

    public BizNumber getIwsMaitositumitatekin6x15() {
        return iwsMaitositumitatekin6x15;
    }

    public void setIwsMaitositumitatekin6x15(BizNumber pIwsMaitositumitatekin6x15) {
        iwsMaitositumitatekin6x15 = pIwsMaitositumitatekin6x15;
    }

    @Column(order = 119, length = 13)
    private BizNumber iwsMaitositumitatekin6x16;

    public BizNumber getIwsMaitositumitatekin6x16() {
        return iwsMaitositumitatekin6x16;
    }

    public void setIwsMaitositumitatekin6x16(BizNumber pIwsMaitositumitatekin6x16) {
        iwsMaitositumitatekin6x16 = pIwsMaitositumitatekin6x16;
    }

    @Column(order = 120, length = 13)
    private BizNumber iwsMaitositumitatekin6x17;

    public BizNumber getIwsMaitositumitatekin6x17() {
        return iwsMaitositumitatekin6x17;
    }

    public void setIwsMaitositumitatekin6x17(BizNumber pIwsMaitositumitatekin6x17) {
        iwsMaitositumitatekin6x17 = pIwsMaitositumitatekin6x17;
    }

    @Column(order = 121, length = 13)
    private BizNumber iwsMaitositumitatekin6x18;

    public BizNumber getIwsMaitositumitatekin6x18() {
        return iwsMaitositumitatekin6x18;
    }

    public void setIwsMaitositumitatekin6x18(BizNumber pIwsMaitositumitatekin6x18) {
        iwsMaitositumitatekin6x18 = pIwsMaitositumitatekin6x18;
    }

    @Column(order = 122, length = 13)
    private BizNumber iwsMaitositumitatekin6x19;

    public BizNumber getIwsMaitositumitatekin6x19() {
        return iwsMaitositumitatekin6x19;
    }

    public void setIwsMaitositumitatekin6x19(BizNumber pIwsMaitositumitatekin6x19) {
        iwsMaitositumitatekin6x19 = pIwsMaitositumitatekin6x19;
    }

    @Column(order = 123, length = 13)
    private BizNumber iwsMaitositumitatekin6x20;

    public BizNumber getIwsMaitositumitatekin6x20() {
        return iwsMaitositumitatekin6x20;
    }

    public void setIwsMaitositumitatekin6x20(BizNumber pIwsMaitositumitatekin6x20) {
        iwsMaitositumitatekin6x20 = pIwsMaitositumitatekin6x20;
    }

    @Column(order = 124, length = 13)
    private BizNumber iwsMaitositumitatekin7x1;

    public BizNumber getIwsMaitositumitatekin7x1() {
        return iwsMaitositumitatekin7x1;
    }

    public void setIwsMaitositumitatekin7x1(BizNumber pIwsMaitositumitatekin7x1) {
        iwsMaitositumitatekin7x1 = pIwsMaitositumitatekin7x1;
    }

    @Column(order = 125, length = 13)
    private BizNumber iwsMaitositumitatekin7x2;

    public BizNumber getIwsMaitositumitatekin7x2() {
        return iwsMaitositumitatekin7x2;
    }

    public void setIwsMaitositumitatekin7x2(BizNumber pIwsMaitositumitatekin7x2) {
        iwsMaitositumitatekin7x2 = pIwsMaitositumitatekin7x2;
    }

    @Column(order = 126, length = 13)
    private BizNumber iwsMaitositumitatekin7x3;

    public BizNumber getIwsMaitositumitatekin7x3() {
        return iwsMaitositumitatekin7x3;
    }

    public void setIwsMaitositumitatekin7x3(BizNumber pIwsMaitositumitatekin7x3) {
        iwsMaitositumitatekin7x3 = pIwsMaitositumitatekin7x3;
    }

    @Column(order = 127, length = 13)
    private BizNumber iwsMaitositumitatekin7x4;

    public BizNumber getIwsMaitositumitatekin7x4() {
        return iwsMaitositumitatekin7x4;
    }

    public void setIwsMaitositumitatekin7x4(BizNumber pIwsMaitositumitatekin7x4) {
        iwsMaitositumitatekin7x4 = pIwsMaitositumitatekin7x4;
    }

    @Column(order = 128, length = 13)
    private BizNumber iwsMaitositumitatekin7x5;

    public BizNumber getIwsMaitositumitatekin7x5() {
        return iwsMaitositumitatekin7x5;
    }

    public void setIwsMaitositumitatekin7x5(BizNumber pIwsMaitositumitatekin7x5) {
        iwsMaitositumitatekin7x5 = pIwsMaitositumitatekin7x5;
    }

    @Column(order = 129, length = 13)
    private BizNumber iwsMaitositumitatekin7x6;

    public BizNumber getIwsMaitositumitatekin7x6() {
        return iwsMaitositumitatekin7x6;
    }

    public void setIwsMaitositumitatekin7x6(BizNumber pIwsMaitositumitatekin7x6) {
        iwsMaitositumitatekin7x6 = pIwsMaitositumitatekin7x6;
    }

    @Column(order = 130, length = 13)
    private BizNumber iwsMaitositumitatekin7x7;

    public BizNumber getIwsMaitositumitatekin7x7() {
        return iwsMaitositumitatekin7x7;
    }

    public void setIwsMaitositumitatekin7x7(BizNumber pIwsMaitositumitatekin7x7) {
        iwsMaitositumitatekin7x7 = pIwsMaitositumitatekin7x7;
    }

    @Column(order = 131, length = 13)
    private BizNumber iwsMaitositumitatekin7x8;

    public BizNumber getIwsMaitositumitatekin7x8() {
        return iwsMaitositumitatekin7x8;
    }

    public void setIwsMaitositumitatekin7x8(BizNumber pIwsMaitositumitatekin7x8) {
        iwsMaitositumitatekin7x8 = pIwsMaitositumitatekin7x8;
    }

    @Column(order = 132, length = 13)
    private BizNumber iwsMaitositumitatekin7x9;

    public BizNumber getIwsMaitositumitatekin7x9() {
        return iwsMaitositumitatekin7x9;
    }

    public void setIwsMaitositumitatekin7x9(BizNumber pIwsMaitositumitatekin7x9) {
        iwsMaitositumitatekin7x9 = pIwsMaitositumitatekin7x9;
    }

    @Column(order = 133, length = 13)
    private BizNumber iwsMaitositumitatekin7x10;

    public BizNumber getIwsMaitositumitatekin7x10() {
        return iwsMaitositumitatekin7x10;
    }

    public void setIwsMaitositumitatekin7x10(BizNumber pIwsMaitositumitatekin7x10) {
        iwsMaitositumitatekin7x10 = pIwsMaitositumitatekin7x10;
    }

    @Column(order = 134, length = 13)
    private BizNumber iwsMaitositumitatekin7x11;

    public BizNumber getIwsMaitositumitatekin7x11() {
        return iwsMaitositumitatekin7x11;
    }

    public void setIwsMaitositumitatekin7x11(BizNumber pIwsMaitositumitatekin7x11) {
        iwsMaitositumitatekin7x11 = pIwsMaitositumitatekin7x11;
    }

    @Column(order = 135, length = 13)
    private BizNumber iwsMaitositumitatekin7x12;

    public BizNumber getIwsMaitositumitatekin7x12() {
        return iwsMaitositumitatekin7x12;
    }

    public void setIwsMaitositumitatekin7x12(BizNumber pIwsMaitositumitatekin7x12) {
        iwsMaitositumitatekin7x12 = pIwsMaitositumitatekin7x12;
    }

    @Column(order = 136, length = 13)
    private BizNumber iwsMaitositumitatekin7x13;

    public BizNumber getIwsMaitositumitatekin7x13() {
        return iwsMaitositumitatekin7x13;
    }

    public void setIwsMaitositumitatekin7x13(BizNumber pIwsMaitositumitatekin7x13) {
        iwsMaitositumitatekin7x13 = pIwsMaitositumitatekin7x13;
    }

    @Column(order = 137, length = 13)
    private BizNumber iwsMaitositumitatekin7x14;

    public BizNumber getIwsMaitositumitatekin7x14() {
        return iwsMaitositumitatekin7x14;
    }

    public void setIwsMaitositumitatekin7x14(BizNumber pIwsMaitositumitatekin7x14) {
        iwsMaitositumitatekin7x14 = pIwsMaitositumitatekin7x14;
    }

    @Column(order = 138, length = 13)
    private BizNumber iwsMaitositumitatekin7x15;

    public BizNumber getIwsMaitositumitatekin7x15() {
        return iwsMaitositumitatekin7x15;
    }

    public void setIwsMaitositumitatekin7x15(BizNumber pIwsMaitositumitatekin7x15) {
        iwsMaitositumitatekin7x15 = pIwsMaitositumitatekin7x15;
    }

    @Column(order = 139, length = 13)
    private BizNumber iwsMaitositumitatekin7x16;

    public BizNumber getIwsMaitositumitatekin7x16() {
        return iwsMaitositumitatekin7x16;
    }

    public void setIwsMaitositumitatekin7x16(BizNumber pIwsMaitositumitatekin7x16) {
        iwsMaitositumitatekin7x16 = pIwsMaitositumitatekin7x16;
    }

    @Column(order = 140, length = 13)
    private BizNumber iwsMaitositumitatekin7x17;

    public BizNumber getIwsMaitositumitatekin7x17() {
        return iwsMaitositumitatekin7x17;
    }

    public void setIwsMaitositumitatekin7x17(BizNumber pIwsMaitositumitatekin7x17) {
        iwsMaitositumitatekin7x17 = pIwsMaitositumitatekin7x17;
    }

    @Column(order = 141, length = 13)
    private BizNumber iwsMaitositumitatekin7x18;

    public BizNumber getIwsMaitositumitatekin7x18() {
        return iwsMaitositumitatekin7x18;
    }

    public void setIwsMaitositumitatekin7x18(BizNumber pIwsMaitositumitatekin7x18) {
        iwsMaitositumitatekin7x18 = pIwsMaitositumitatekin7x18;
    }

    @Column(order = 142, length = 13)
    private BizNumber iwsMaitositumitatekin7x19;

    public BizNumber getIwsMaitositumitatekin7x19() {
        return iwsMaitositumitatekin7x19;
    }

    public void setIwsMaitositumitatekin7x19(BizNumber pIwsMaitositumitatekin7x19) {
        iwsMaitositumitatekin7x19 = pIwsMaitositumitatekin7x19;
    }

    @Column(order = 143, length = 13)
    private BizNumber iwsMaitositumitatekin7x20;

    public BizNumber getIwsMaitositumitatekin7x20() {
        return iwsMaitositumitatekin7x20;
    }

    public void setIwsMaitositumitatekin7x20(BizNumber pIwsMaitositumitatekin7x20) {
        iwsMaitositumitatekin7x20 = pIwsMaitositumitatekin7x20;
    }

    @Column(order = 144, length = 13)
    private BizNumber iwsMaitositumitatekin8x1;

    public BizNumber getIwsMaitositumitatekin8x1() {
        return iwsMaitositumitatekin8x1;
    }

    public void setIwsMaitositumitatekin8x1(BizNumber pIwsMaitositumitatekin8x1) {
        iwsMaitositumitatekin8x1 = pIwsMaitositumitatekin8x1;
    }

    @Column(order = 145, length = 13)
    private BizNumber iwsMaitositumitatekin8x2;

    public BizNumber getIwsMaitositumitatekin8x2() {
        return iwsMaitositumitatekin8x2;
    }

    public void setIwsMaitositumitatekin8x2(BizNumber pIwsMaitositumitatekin8x2) {
        iwsMaitositumitatekin8x2 = pIwsMaitositumitatekin8x2;
    }

    @Column(order = 146, length = 13)
    private BizNumber iwsMaitositumitatekin8x3;

    public BizNumber getIwsMaitositumitatekin8x3() {
        return iwsMaitositumitatekin8x3;
    }

    public void setIwsMaitositumitatekin8x3(BizNumber pIwsMaitositumitatekin8x3) {
        iwsMaitositumitatekin8x3 = pIwsMaitositumitatekin8x3;
    }

    @Column(order = 147, length = 13)
    private BizNumber iwsMaitositumitatekin8x4;

    public BizNumber getIwsMaitositumitatekin8x4() {
        return iwsMaitositumitatekin8x4;
    }

    public void setIwsMaitositumitatekin8x4(BizNumber pIwsMaitositumitatekin8x4) {
        iwsMaitositumitatekin8x4 = pIwsMaitositumitatekin8x4;
    }

    @Column(order = 148, length = 13)
    private BizNumber iwsMaitositumitatekin8x5;

    public BizNumber getIwsMaitositumitatekin8x5() {
        return iwsMaitositumitatekin8x5;
    }

    public void setIwsMaitositumitatekin8x5(BizNumber pIwsMaitositumitatekin8x5) {
        iwsMaitositumitatekin8x5 = pIwsMaitositumitatekin8x5;
    }

    @Column(order = 149, length = 13)
    private BizNumber iwsMaitositumitatekin8x6;

    public BizNumber getIwsMaitositumitatekin8x6() {
        return iwsMaitositumitatekin8x6;
    }

    public void setIwsMaitositumitatekin8x6(BizNumber pIwsMaitositumitatekin8x6) {
        iwsMaitositumitatekin8x6 = pIwsMaitositumitatekin8x6;
    }

    @Column(order = 150, length = 13)
    private BizNumber iwsMaitositumitatekin8x7;

    public BizNumber getIwsMaitositumitatekin8x7() {
        return iwsMaitositumitatekin8x7;
    }

    public void setIwsMaitositumitatekin8x7(BizNumber pIwsMaitositumitatekin8x7) {
        iwsMaitositumitatekin8x7 = pIwsMaitositumitatekin8x7;
    }

    @Column(order = 151, length = 13)
    private BizNumber iwsMaitositumitatekin8x8;

    public BizNumber getIwsMaitositumitatekin8x8() {
        return iwsMaitositumitatekin8x8;
    }

    public void setIwsMaitositumitatekin8x8(BizNumber pIwsMaitositumitatekin8x8) {
        iwsMaitositumitatekin8x8 = pIwsMaitositumitatekin8x8;
    }

    @Column(order = 152, length = 13)
    private BizNumber iwsMaitositumitatekin8x9;

    public BizNumber getIwsMaitositumitatekin8x9() {
        return iwsMaitositumitatekin8x9;
    }

    public void setIwsMaitositumitatekin8x9(BizNumber pIwsMaitositumitatekin8x9) {
        iwsMaitositumitatekin8x9 = pIwsMaitositumitatekin8x9;
    }

    @Column(order = 153, length = 13)
    private BizNumber iwsMaitositumitatekin8x10;

    public BizNumber getIwsMaitositumitatekin8x10() {
        return iwsMaitositumitatekin8x10;
    }

    public void setIwsMaitositumitatekin8x10(BizNumber pIwsMaitositumitatekin8x10) {
        iwsMaitositumitatekin8x10 = pIwsMaitositumitatekin8x10;
    }

    @Column(order = 154, length = 13)
    private BizNumber iwsMaitositumitatekin8x11;

    public BizNumber getIwsMaitositumitatekin8x11() {
        return iwsMaitositumitatekin8x11;
    }

    public void setIwsMaitositumitatekin8x11(BizNumber pIwsMaitositumitatekin8x11) {
        iwsMaitositumitatekin8x11 = pIwsMaitositumitatekin8x11;
    }

    @Column(order = 155, length = 13)
    private BizNumber iwsMaitositumitatekin8x12;

    public BizNumber getIwsMaitositumitatekin8x12() {
        return iwsMaitositumitatekin8x12;
    }

    public void setIwsMaitositumitatekin8x12(BizNumber pIwsMaitositumitatekin8x12) {
        iwsMaitositumitatekin8x12 = pIwsMaitositumitatekin8x12;
    }

    @Column(order = 156, length = 13)
    private BizNumber iwsMaitositumitatekin8x13;

    public BizNumber getIwsMaitositumitatekin8x13() {
        return iwsMaitositumitatekin8x13;
    }

    public void setIwsMaitositumitatekin8x13(BizNumber pIwsMaitositumitatekin8x13) {
        iwsMaitositumitatekin8x13 = pIwsMaitositumitatekin8x13;
    }

    @Column(order = 157, length = 13)
    private BizNumber iwsMaitositumitatekin8x14;

    public BizNumber getIwsMaitositumitatekin8x14() {
        return iwsMaitositumitatekin8x14;
    }

    public void setIwsMaitositumitatekin8x14(BizNumber pIwsMaitositumitatekin8x14) {
        iwsMaitositumitatekin8x14 = pIwsMaitositumitatekin8x14;
    }

    @Column(order = 158, length = 13)
    private BizNumber iwsMaitositumitatekin8x15;

    public BizNumber getIwsMaitositumitatekin8x15() {
        return iwsMaitositumitatekin8x15;
    }

    public void setIwsMaitositumitatekin8x15(BizNumber pIwsMaitositumitatekin8x15) {
        iwsMaitositumitatekin8x15 = pIwsMaitositumitatekin8x15;
    }

    @Column(order = 159, length = 13)
    private BizNumber iwsMaitositumitatekin8x16;

    public BizNumber getIwsMaitositumitatekin8x16() {
        return iwsMaitositumitatekin8x16;
    }

    public void setIwsMaitositumitatekin8x16(BizNumber pIwsMaitositumitatekin8x16) {
        iwsMaitositumitatekin8x16 = pIwsMaitositumitatekin8x16;
    }

    @Column(order = 160, length = 13)
    private BizNumber iwsMaitositumitatekin8x17;

    public BizNumber getIwsMaitositumitatekin8x17() {
        return iwsMaitositumitatekin8x17;
    }

    public void setIwsMaitositumitatekin8x17(BizNumber pIwsMaitositumitatekin8x17) {
        iwsMaitositumitatekin8x17 = pIwsMaitositumitatekin8x17;
    }

    @Column(order = 161, length = 13)
    private BizNumber iwsMaitositumitatekin8x18;

    public BizNumber getIwsMaitositumitatekin8x18() {
        return iwsMaitositumitatekin8x18;
    }

    public void setIwsMaitositumitatekin8x18(BizNumber pIwsMaitositumitatekin8x18) {
        iwsMaitositumitatekin8x18 = pIwsMaitositumitatekin8x18;
    }

    @Column(order = 162, length = 13)
    private BizNumber iwsMaitositumitatekin8x19;

    public BizNumber getIwsMaitositumitatekin8x19() {
        return iwsMaitositumitatekin8x19;
    }

    public void setIwsMaitositumitatekin8x19(BizNumber pIwsMaitositumitatekin8x19) {
        iwsMaitositumitatekin8x19 = pIwsMaitositumitatekin8x19;
    }

    @Column(order = 163, length = 13)
    private BizNumber iwsMaitositumitatekin8x20;

    public BizNumber getIwsMaitositumitatekin8x20() {
        return iwsMaitositumitatekin8x20;
    }

    public void setIwsMaitositumitatekin8x20(BizNumber pIwsMaitositumitatekin8x20) {
        iwsMaitositumitatekin8x20 = pIwsMaitositumitatekin8x20;
    }

    @Column(order = 164, length = 13)
    private BizNumber iwsMaitositumitatekin9x1;

    public BizNumber getIwsMaitositumitatekin9x1() {
        return iwsMaitositumitatekin9x1;
    }

    public void setIwsMaitositumitatekin9x1(BizNumber pIwsMaitositumitatekin9x1) {
        iwsMaitositumitatekin9x1 = pIwsMaitositumitatekin9x1;
    }

    @Column(order = 165, length = 13)
    private BizNumber iwsMaitositumitatekin9x2;

    public BizNumber getIwsMaitositumitatekin9x2() {
        return iwsMaitositumitatekin9x2;
    }

    public void setIwsMaitositumitatekin9x2(BizNumber pIwsMaitositumitatekin9x2) {
        iwsMaitositumitatekin9x2 = pIwsMaitositumitatekin9x2;
    }

    @Column(order = 166, length = 13)
    private BizNumber iwsMaitositumitatekin9x3;

    public BizNumber getIwsMaitositumitatekin9x3() {
        return iwsMaitositumitatekin9x3;
    }

    public void setIwsMaitositumitatekin9x3(BizNumber pIwsMaitositumitatekin9x3) {
        iwsMaitositumitatekin9x3 = pIwsMaitositumitatekin9x3;
    }

    @Column(order = 167, length = 13)
    private BizNumber iwsMaitositumitatekin9x4;

    public BizNumber getIwsMaitositumitatekin9x4() {
        return iwsMaitositumitatekin9x4;
    }

    public void setIwsMaitositumitatekin9x4(BizNumber pIwsMaitositumitatekin9x4) {
        iwsMaitositumitatekin9x4 = pIwsMaitositumitatekin9x4;
    }

    @Column(order = 168, length = 13)
    private BizNumber iwsMaitositumitatekin9x5;

    public BizNumber getIwsMaitositumitatekin9x5() {
        return iwsMaitositumitatekin9x5;
    }

    public void setIwsMaitositumitatekin9x5(BizNumber pIwsMaitositumitatekin9x5) {
        iwsMaitositumitatekin9x5 = pIwsMaitositumitatekin9x5;
    }

    @Column(order = 169, length = 13)
    private BizNumber iwsMaitositumitatekin9x6;

    public BizNumber getIwsMaitositumitatekin9x6() {
        return iwsMaitositumitatekin9x6;
    }

    public void setIwsMaitositumitatekin9x6(BizNumber pIwsMaitositumitatekin9x6) {
        iwsMaitositumitatekin9x6 = pIwsMaitositumitatekin9x6;
    }

    @Column(order = 170, length = 13)
    private BizNumber iwsMaitositumitatekin9x7;

    public BizNumber getIwsMaitositumitatekin9x7() {
        return iwsMaitositumitatekin9x7;
    }

    public void setIwsMaitositumitatekin9x7(BizNumber pIwsMaitositumitatekin9x7) {
        iwsMaitositumitatekin9x7 = pIwsMaitositumitatekin9x7;
    }

    @Column(order = 171, length = 13)
    private BizNumber iwsMaitositumitatekin9x8;

    public BizNumber getIwsMaitositumitatekin9x8() {
        return iwsMaitositumitatekin9x8;
    }

    public void setIwsMaitositumitatekin9x8(BizNumber pIwsMaitositumitatekin9x8) {
        iwsMaitositumitatekin9x8 = pIwsMaitositumitatekin9x8;
    }

    @Column(order = 172, length = 13)
    private BizNumber iwsMaitositumitatekin9x9;

    public BizNumber getIwsMaitositumitatekin9x9() {
        return iwsMaitositumitatekin9x9;
    }

    public void setIwsMaitositumitatekin9x9(BizNumber pIwsMaitositumitatekin9x9) {
        iwsMaitositumitatekin9x9 = pIwsMaitositumitatekin9x9;
    }

    @Column(order = 173, length = 13)
    private BizNumber iwsMaitositumitatekin9x10;

    public BizNumber getIwsMaitositumitatekin9x10() {
        return iwsMaitositumitatekin9x10;
    }

    public void setIwsMaitositumitatekin9x10(BizNumber pIwsMaitositumitatekin9x10) {
        iwsMaitositumitatekin9x10 = pIwsMaitositumitatekin9x10;
    }

    @Column(order = 174, length = 13)
    private BizNumber iwsMaitositumitatekin9x11;

    public BizNumber getIwsMaitositumitatekin9x11() {
        return iwsMaitositumitatekin9x11;
    }

    public void setIwsMaitositumitatekin9x11(BizNumber pIwsMaitositumitatekin9x11) {
        iwsMaitositumitatekin9x11 = pIwsMaitositumitatekin9x11;
    }

    @Column(order = 175, length = 13)
    private BizNumber iwsMaitositumitatekin9x12;

    public BizNumber getIwsMaitositumitatekin9x12() {
        return iwsMaitositumitatekin9x12;
    }

    public void setIwsMaitositumitatekin9x12(BizNumber pIwsMaitositumitatekin9x12) {
        iwsMaitositumitatekin9x12 = pIwsMaitositumitatekin9x12;
    }

    @Column(order = 176, length = 13)
    private BizNumber iwsMaitositumitatekin9x13;

    public BizNumber getIwsMaitositumitatekin9x13() {
        return iwsMaitositumitatekin9x13;
    }

    public void setIwsMaitositumitatekin9x13(BizNumber pIwsMaitositumitatekin9x13) {
        iwsMaitositumitatekin9x13 = pIwsMaitositumitatekin9x13;
    }

    @Column(order = 177, length = 13)
    private BizNumber iwsMaitositumitatekin9x14;

    public BizNumber getIwsMaitositumitatekin9x14() {
        return iwsMaitositumitatekin9x14;
    }

    public void setIwsMaitositumitatekin9x14(BizNumber pIwsMaitositumitatekin9x14) {
        iwsMaitositumitatekin9x14 = pIwsMaitositumitatekin9x14;
    }

    @Column(order = 178, length = 13)
    private BizNumber iwsMaitositumitatekin9x15;

    public BizNumber getIwsMaitositumitatekin9x15() {
        return iwsMaitositumitatekin9x15;
    }

    public void setIwsMaitositumitatekin9x15(BizNumber pIwsMaitositumitatekin9x15) {
        iwsMaitositumitatekin9x15 = pIwsMaitositumitatekin9x15;
    }

    @Column(order = 179, length = 13)
    private BizNumber iwsMaitositumitatekin9x16;

    public BizNumber getIwsMaitositumitatekin9x16() {
        return iwsMaitositumitatekin9x16;
    }

    public void setIwsMaitositumitatekin9x16(BizNumber pIwsMaitositumitatekin9x16) {
        iwsMaitositumitatekin9x16 = pIwsMaitositumitatekin9x16;
    }

    @Column(order = 180, length = 13)
    private BizNumber iwsMaitositumitatekin9x17;

    public BizNumber getIwsMaitositumitatekin9x17() {
        return iwsMaitositumitatekin9x17;
    }

    public void setIwsMaitositumitatekin9x17(BizNumber pIwsMaitositumitatekin9x17) {
        iwsMaitositumitatekin9x17 = pIwsMaitositumitatekin9x17;
    }

    @Column(order = 181, length = 13)
    private BizNumber iwsMaitositumitatekin9x18;

    public BizNumber getIwsMaitositumitatekin9x18() {
        return iwsMaitositumitatekin9x18;
    }

    public void setIwsMaitositumitatekin9x18(BizNumber pIwsMaitositumitatekin9x18) {
        iwsMaitositumitatekin9x18 = pIwsMaitositumitatekin9x18;
    }

    @Column(order = 182, length = 13)
    private BizNumber iwsMaitositumitatekin9x19;

    public BizNumber getIwsMaitositumitatekin9x19() {
        return iwsMaitositumitatekin9x19;
    }

    public void setIwsMaitositumitatekin9x19(BizNumber pIwsMaitositumitatekin9x19) {
        iwsMaitositumitatekin9x19 = pIwsMaitositumitatekin9x19;
    }

    @Column(order = 183, length = 13)
    private BizNumber iwsMaitositumitatekin9x20;

    public BizNumber getIwsMaitositumitatekin9x20() {
        return iwsMaitositumitatekin9x20;
    }

    public void setIwsMaitositumitatekin9x20(BizNumber pIwsMaitositumitatekin9x20) {
        iwsMaitositumitatekin9x20 = pIwsMaitositumitatekin9x20;
    }

    @Column(order = 184, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x1;

    public BizNumber getIwsMaitosimvagotmttkn1x1() {
        return iwsMaitosimvagotmttkn1x1;
    }

    public void setIwsMaitosimvagotmttkn1x1(BizNumber pIwsMaitosimvagotmttkn1x1) {
        iwsMaitosimvagotmttkn1x1 = pIwsMaitosimvagotmttkn1x1;
    }

    @Column(order = 185, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x2;

    public BizNumber getIwsMaitosimvagotmttkn1x2() {
        return iwsMaitosimvagotmttkn1x2;
    }

    public void setIwsMaitosimvagotmttkn1x2(BizNumber pIwsMaitosimvagotmttkn1x2) {
        iwsMaitosimvagotmttkn1x2 = pIwsMaitosimvagotmttkn1x2;
    }

    @Column(order = 186, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x3;

    public BizNumber getIwsMaitosimvagotmttkn1x3() {
        return iwsMaitosimvagotmttkn1x3;
    }

    public void setIwsMaitosimvagotmttkn1x3(BizNumber pIwsMaitosimvagotmttkn1x3) {
        iwsMaitosimvagotmttkn1x3 = pIwsMaitosimvagotmttkn1x3;
    }

    @Column(order = 187, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x4;

    public BizNumber getIwsMaitosimvagotmttkn1x4() {
        return iwsMaitosimvagotmttkn1x4;
    }

    public void setIwsMaitosimvagotmttkn1x4(BizNumber pIwsMaitosimvagotmttkn1x4) {
        iwsMaitosimvagotmttkn1x4 = pIwsMaitosimvagotmttkn1x4;
    }

    @Column(order = 188, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x5;

    public BizNumber getIwsMaitosimvagotmttkn1x5() {
        return iwsMaitosimvagotmttkn1x5;
    }

    public void setIwsMaitosimvagotmttkn1x5(BizNumber pIwsMaitosimvagotmttkn1x5) {
        iwsMaitosimvagotmttkn1x5 = pIwsMaitosimvagotmttkn1x5;
    }

    @Column(order = 189, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x6;

    public BizNumber getIwsMaitosimvagotmttkn1x6() {
        return iwsMaitosimvagotmttkn1x6;
    }

    public void setIwsMaitosimvagotmttkn1x6(BizNumber pIwsMaitosimvagotmttkn1x6) {
        iwsMaitosimvagotmttkn1x6 = pIwsMaitosimvagotmttkn1x6;
    }

    @Column(order = 190, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x7;

    public BizNumber getIwsMaitosimvagotmttkn1x7() {
        return iwsMaitosimvagotmttkn1x7;
    }

    public void setIwsMaitosimvagotmttkn1x7(BizNumber pIwsMaitosimvagotmttkn1x7) {
        iwsMaitosimvagotmttkn1x7 = pIwsMaitosimvagotmttkn1x7;
    }

    @Column(order = 191, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x8;

    public BizNumber getIwsMaitosimvagotmttkn1x8() {
        return iwsMaitosimvagotmttkn1x8;
    }

    public void setIwsMaitosimvagotmttkn1x8(BizNumber pIwsMaitosimvagotmttkn1x8) {
        iwsMaitosimvagotmttkn1x8 = pIwsMaitosimvagotmttkn1x8;
    }

    @Column(order = 192, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x9;

    public BizNumber getIwsMaitosimvagotmttkn1x9() {
        return iwsMaitosimvagotmttkn1x9;
    }

    public void setIwsMaitosimvagotmttkn1x9(BizNumber pIwsMaitosimvagotmttkn1x9) {
        iwsMaitosimvagotmttkn1x9 = pIwsMaitosimvagotmttkn1x9;
    }

    @Column(order = 193, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x10;

    public BizNumber getIwsMaitosimvagotmttkn1x10() {
        return iwsMaitosimvagotmttkn1x10;
    }

    public void setIwsMaitosimvagotmttkn1x10(BizNumber pIwsMaitosimvagotmttkn1x10) {
        iwsMaitosimvagotmttkn1x10 = pIwsMaitosimvagotmttkn1x10;
    }

    @Column(order = 194, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x11;

    public BizNumber getIwsMaitosimvagotmttkn1x11() {
        return iwsMaitosimvagotmttkn1x11;
    }

    public void setIwsMaitosimvagotmttkn1x11(BizNumber pIwsMaitosimvagotmttkn1x11) {
        iwsMaitosimvagotmttkn1x11 = pIwsMaitosimvagotmttkn1x11;
    }

    @Column(order = 195, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x12;

    public BizNumber getIwsMaitosimvagotmttkn1x12() {
        return iwsMaitosimvagotmttkn1x12;
    }

    public void setIwsMaitosimvagotmttkn1x12(BizNumber pIwsMaitosimvagotmttkn1x12) {
        iwsMaitosimvagotmttkn1x12 = pIwsMaitosimvagotmttkn1x12;
    }

    @Column(order = 196, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x13;

    public BizNumber getIwsMaitosimvagotmttkn1x13() {
        return iwsMaitosimvagotmttkn1x13;
    }

    public void setIwsMaitosimvagotmttkn1x13(BizNumber pIwsMaitosimvagotmttkn1x13) {
        iwsMaitosimvagotmttkn1x13 = pIwsMaitosimvagotmttkn1x13;
    }

    @Column(order = 197, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x14;

    public BizNumber getIwsMaitosimvagotmttkn1x14() {
        return iwsMaitosimvagotmttkn1x14;
    }

    public void setIwsMaitosimvagotmttkn1x14(BizNumber pIwsMaitosimvagotmttkn1x14) {
        iwsMaitosimvagotmttkn1x14 = pIwsMaitosimvagotmttkn1x14;
    }

    @Column(order = 198, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x15;

    public BizNumber getIwsMaitosimvagotmttkn1x15() {
        return iwsMaitosimvagotmttkn1x15;
    }

    public void setIwsMaitosimvagotmttkn1x15(BizNumber pIwsMaitosimvagotmttkn1x15) {
        iwsMaitosimvagotmttkn1x15 = pIwsMaitosimvagotmttkn1x15;
    }

    @Column(order = 199, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x16;

    public BizNumber getIwsMaitosimvagotmttkn1x16() {
        return iwsMaitosimvagotmttkn1x16;
    }

    public void setIwsMaitosimvagotmttkn1x16(BizNumber pIwsMaitosimvagotmttkn1x16) {
        iwsMaitosimvagotmttkn1x16 = pIwsMaitosimvagotmttkn1x16;
    }

    @Column(order = 200, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x17;

    public BizNumber getIwsMaitosimvagotmttkn1x17() {
        return iwsMaitosimvagotmttkn1x17;
    }

    public void setIwsMaitosimvagotmttkn1x17(BizNumber pIwsMaitosimvagotmttkn1x17) {
        iwsMaitosimvagotmttkn1x17 = pIwsMaitosimvagotmttkn1x17;
    }

    @Column(order = 201, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x18;

    public BizNumber getIwsMaitosimvagotmttkn1x18() {
        return iwsMaitosimvagotmttkn1x18;
    }

    public void setIwsMaitosimvagotmttkn1x18(BizNumber pIwsMaitosimvagotmttkn1x18) {
        iwsMaitosimvagotmttkn1x18 = pIwsMaitosimvagotmttkn1x18;
    }

    @Column(order = 202, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x19;

    public BizNumber getIwsMaitosimvagotmttkn1x19() {
        return iwsMaitosimvagotmttkn1x19;
    }

    public void setIwsMaitosimvagotmttkn1x19(BizNumber pIwsMaitosimvagotmttkn1x19) {
        iwsMaitosimvagotmttkn1x19 = pIwsMaitosimvagotmttkn1x19;
    }

    @Column(order = 203, length = 13)
    private BizNumber iwsMaitosimvagotmttkn1x20;

    public BizNumber getIwsMaitosimvagotmttkn1x20() {
        return iwsMaitosimvagotmttkn1x20;
    }

    public void setIwsMaitosimvagotmttkn1x20(BizNumber pIwsMaitosimvagotmttkn1x20) {
        iwsMaitosimvagotmttkn1x20 = pIwsMaitosimvagotmttkn1x20;
    }

    @Column(order = 204, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x1;

    public BizNumber getIwsMaitosimvagotmttkn2x1() {
        return iwsMaitosimvagotmttkn2x1;
    }

    public void setIwsMaitosimvagotmttkn2x1(BizNumber pIwsMaitosimvagotmttkn2x1) {
        iwsMaitosimvagotmttkn2x1 = pIwsMaitosimvagotmttkn2x1;
    }

    @Column(order = 205, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x2;

    public BizNumber getIwsMaitosimvagotmttkn2x2() {
        return iwsMaitosimvagotmttkn2x2;
    }

    public void setIwsMaitosimvagotmttkn2x2(BizNumber pIwsMaitosimvagotmttkn2x2) {
        iwsMaitosimvagotmttkn2x2 = pIwsMaitosimvagotmttkn2x2;
    }

    @Column(order = 206, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x3;

    public BizNumber getIwsMaitosimvagotmttkn2x3() {
        return iwsMaitosimvagotmttkn2x3;
    }

    public void setIwsMaitosimvagotmttkn2x3(BizNumber pIwsMaitosimvagotmttkn2x3) {
        iwsMaitosimvagotmttkn2x3 = pIwsMaitosimvagotmttkn2x3;
    }

    @Column(order = 207, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x4;

    public BizNumber getIwsMaitosimvagotmttkn2x4() {
        return iwsMaitosimvagotmttkn2x4;
    }

    public void setIwsMaitosimvagotmttkn2x4(BizNumber pIwsMaitosimvagotmttkn2x4) {
        iwsMaitosimvagotmttkn2x4 = pIwsMaitosimvagotmttkn2x4;
    }

    @Column(order = 208, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x5;

    public BizNumber getIwsMaitosimvagotmttkn2x5() {
        return iwsMaitosimvagotmttkn2x5;
    }

    public void setIwsMaitosimvagotmttkn2x5(BizNumber pIwsMaitosimvagotmttkn2x5) {
        iwsMaitosimvagotmttkn2x5 = pIwsMaitosimvagotmttkn2x5;
    }

    @Column(order = 209, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x6;

    public BizNumber getIwsMaitosimvagotmttkn2x6() {
        return iwsMaitosimvagotmttkn2x6;
    }

    public void setIwsMaitosimvagotmttkn2x6(BizNumber pIwsMaitosimvagotmttkn2x6) {
        iwsMaitosimvagotmttkn2x6 = pIwsMaitosimvagotmttkn2x6;
    }

    @Column(order = 210, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x7;

    public BizNumber getIwsMaitosimvagotmttkn2x7() {
        return iwsMaitosimvagotmttkn2x7;
    }

    public void setIwsMaitosimvagotmttkn2x7(BizNumber pIwsMaitosimvagotmttkn2x7) {
        iwsMaitosimvagotmttkn2x7 = pIwsMaitosimvagotmttkn2x7;
    }

    @Column(order = 211, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x8;

    public BizNumber getIwsMaitosimvagotmttkn2x8() {
        return iwsMaitosimvagotmttkn2x8;
    }

    public void setIwsMaitosimvagotmttkn2x8(BizNumber pIwsMaitosimvagotmttkn2x8) {
        iwsMaitosimvagotmttkn2x8 = pIwsMaitosimvagotmttkn2x8;
    }

    @Column(order = 212, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x9;

    public BizNumber getIwsMaitosimvagotmttkn2x9() {
        return iwsMaitosimvagotmttkn2x9;
    }

    public void setIwsMaitosimvagotmttkn2x9(BizNumber pIwsMaitosimvagotmttkn2x9) {
        iwsMaitosimvagotmttkn2x9 = pIwsMaitosimvagotmttkn2x9;
    }

    @Column(order = 213, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x10;

    public BizNumber getIwsMaitosimvagotmttkn2x10() {
        return iwsMaitosimvagotmttkn2x10;
    }

    public void setIwsMaitosimvagotmttkn2x10(BizNumber pIwsMaitosimvagotmttkn2x10) {
        iwsMaitosimvagotmttkn2x10 = pIwsMaitosimvagotmttkn2x10;
    }

    @Column(order = 214, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x11;

    public BizNumber getIwsMaitosimvagotmttkn2x11() {
        return iwsMaitosimvagotmttkn2x11;
    }

    public void setIwsMaitosimvagotmttkn2x11(BizNumber pIwsMaitosimvagotmttkn2x11) {
        iwsMaitosimvagotmttkn2x11 = pIwsMaitosimvagotmttkn2x11;
    }

    @Column(order = 215, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x12;

    public BizNumber getIwsMaitosimvagotmttkn2x12() {
        return iwsMaitosimvagotmttkn2x12;
    }

    public void setIwsMaitosimvagotmttkn2x12(BizNumber pIwsMaitosimvagotmttkn2x12) {
        iwsMaitosimvagotmttkn2x12 = pIwsMaitosimvagotmttkn2x12;
    }

    @Column(order = 216, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x13;

    public BizNumber getIwsMaitosimvagotmttkn2x13() {
        return iwsMaitosimvagotmttkn2x13;
    }

    public void setIwsMaitosimvagotmttkn2x13(BizNumber pIwsMaitosimvagotmttkn2x13) {
        iwsMaitosimvagotmttkn2x13 = pIwsMaitosimvagotmttkn2x13;
    }

    @Column(order = 217, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x14;

    public BizNumber getIwsMaitosimvagotmttkn2x14() {
        return iwsMaitosimvagotmttkn2x14;
    }

    public void setIwsMaitosimvagotmttkn2x14(BizNumber pIwsMaitosimvagotmttkn2x14) {
        iwsMaitosimvagotmttkn2x14 = pIwsMaitosimvagotmttkn2x14;
    }

    @Column(order = 218, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x15;

    public BizNumber getIwsMaitosimvagotmttkn2x15() {
        return iwsMaitosimvagotmttkn2x15;
    }

    public void setIwsMaitosimvagotmttkn2x15(BizNumber pIwsMaitosimvagotmttkn2x15) {
        iwsMaitosimvagotmttkn2x15 = pIwsMaitosimvagotmttkn2x15;
    }

    @Column(order = 219, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x16;

    public BizNumber getIwsMaitosimvagotmttkn2x16() {
        return iwsMaitosimvagotmttkn2x16;
    }

    public void setIwsMaitosimvagotmttkn2x16(BizNumber pIwsMaitosimvagotmttkn2x16) {
        iwsMaitosimvagotmttkn2x16 = pIwsMaitosimvagotmttkn2x16;
    }

    @Column(order = 220, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x17;

    public BizNumber getIwsMaitosimvagotmttkn2x17() {
        return iwsMaitosimvagotmttkn2x17;
    }

    public void setIwsMaitosimvagotmttkn2x17(BizNumber pIwsMaitosimvagotmttkn2x17) {
        iwsMaitosimvagotmttkn2x17 = pIwsMaitosimvagotmttkn2x17;
    }

    @Column(order = 221, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x18;

    public BizNumber getIwsMaitosimvagotmttkn2x18() {
        return iwsMaitosimvagotmttkn2x18;
    }

    public void setIwsMaitosimvagotmttkn2x18(BizNumber pIwsMaitosimvagotmttkn2x18) {
        iwsMaitosimvagotmttkn2x18 = pIwsMaitosimvagotmttkn2x18;
    }

    @Column(order = 222, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x19;

    public BizNumber getIwsMaitosimvagotmttkn2x19() {
        return iwsMaitosimvagotmttkn2x19;
    }

    public void setIwsMaitosimvagotmttkn2x19(BizNumber pIwsMaitosimvagotmttkn2x19) {
        iwsMaitosimvagotmttkn2x19 = pIwsMaitosimvagotmttkn2x19;
    }

    @Column(order = 223, length = 13)
    private BizNumber iwsMaitosimvagotmttkn2x20;

    public BizNumber getIwsMaitosimvagotmttkn2x20() {
        return iwsMaitosimvagotmttkn2x20;
    }

    public void setIwsMaitosimvagotmttkn2x20(BizNumber pIwsMaitosimvagotmttkn2x20) {
        iwsMaitosimvagotmttkn2x20 = pIwsMaitosimvagotmttkn2x20;
    }

    @Column(order = 224, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x1;

    public BizNumber getIwsMaitosimvagotmttkn3x1() {
        return iwsMaitosimvagotmttkn3x1;
    }

    public void setIwsMaitosimvagotmttkn3x1(BizNumber pIwsMaitosimvagotmttkn3x1) {
        iwsMaitosimvagotmttkn3x1 = pIwsMaitosimvagotmttkn3x1;
    }

    @Column(order = 225, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x2;

    public BizNumber getIwsMaitosimvagotmttkn3x2() {
        return iwsMaitosimvagotmttkn3x2;
    }

    public void setIwsMaitosimvagotmttkn3x2(BizNumber pIwsMaitosimvagotmttkn3x2) {
        iwsMaitosimvagotmttkn3x2 = pIwsMaitosimvagotmttkn3x2;
    }

    @Column(order = 226, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x3;

    public BizNumber getIwsMaitosimvagotmttkn3x3() {
        return iwsMaitosimvagotmttkn3x3;
    }

    public void setIwsMaitosimvagotmttkn3x3(BizNumber pIwsMaitosimvagotmttkn3x3) {
        iwsMaitosimvagotmttkn3x3 = pIwsMaitosimvagotmttkn3x3;
    }

    @Column(order = 227, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x4;

    public BizNumber getIwsMaitosimvagotmttkn3x4() {
        return iwsMaitosimvagotmttkn3x4;
    }

    public void setIwsMaitosimvagotmttkn3x4(BizNumber pIwsMaitosimvagotmttkn3x4) {
        iwsMaitosimvagotmttkn3x4 = pIwsMaitosimvagotmttkn3x4;
    }

    @Column(order = 228, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x5;

    public BizNumber getIwsMaitosimvagotmttkn3x5() {
        return iwsMaitosimvagotmttkn3x5;
    }

    public void setIwsMaitosimvagotmttkn3x5(BizNumber pIwsMaitosimvagotmttkn3x5) {
        iwsMaitosimvagotmttkn3x5 = pIwsMaitosimvagotmttkn3x5;
    }

    @Column(order = 229, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x6;

    public BizNumber getIwsMaitosimvagotmttkn3x6() {
        return iwsMaitosimvagotmttkn3x6;
    }

    public void setIwsMaitosimvagotmttkn3x6(BizNumber pIwsMaitosimvagotmttkn3x6) {
        iwsMaitosimvagotmttkn3x6 = pIwsMaitosimvagotmttkn3x6;
    }

    @Column(order = 230, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x7;

    public BizNumber getIwsMaitosimvagotmttkn3x7() {
        return iwsMaitosimvagotmttkn3x7;
    }

    public void setIwsMaitosimvagotmttkn3x7(BizNumber pIwsMaitosimvagotmttkn3x7) {
        iwsMaitosimvagotmttkn3x7 = pIwsMaitosimvagotmttkn3x7;
    }

    @Column(order = 231, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x8;

    public BizNumber getIwsMaitosimvagotmttkn3x8() {
        return iwsMaitosimvagotmttkn3x8;
    }

    public void setIwsMaitosimvagotmttkn3x8(BizNumber pIwsMaitosimvagotmttkn3x8) {
        iwsMaitosimvagotmttkn3x8 = pIwsMaitosimvagotmttkn3x8;
    }

    @Column(order = 232, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x9;

    public BizNumber getIwsMaitosimvagotmttkn3x9() {
        return iwsMaitosimvagotmttkn3x9;
    }

    public void setIwsMaitosimvagotmttkn3x9(BizNumber pIwsMaitosimvagotmttkn3x9) {
        iwsMaitosimvagotmttkn3x9 = pIwsMaitosimvagotmttkn3x9;
    }

    @Column(order = 233, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x10;

    public BizNumber getIwsMaitosimvagotmttkn3x10() {
        return iwsMaitosimvagotmttkn3x10;
    }

    public void setIwsMaitosimvagotmttkn3x10(BizNumber pIwsMaitosimvagotmttkn3x10) {
        iwsMaitosimvagotmttkn3x10 = pIwsMaitosimvagotmttkn3x10;
    }

    @Column(order = 234, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x11;

    public BizNumber getIwsMaitosimvagotmttkn3x11() {
        return iwsMaitosimvagotmttkn3x11;
    }

    public void setIwsMaitosimvagotmttkn3x11(BizNumber pIwsMaitosimvagotmttkn3x11) {
        iwsMaitosimvagotmttkn3x11 = pIwsMaitosimvagotmttkn3x11;
    }

    @Column(order = 235, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x12;

    public BizNumber getIwsMaitosimvagotmttkn3x12() {
        return iwsMaitosimvagotmttkn3x12;
    }

    public void setIwsMaitosimvagotmttkn3x12(BizNumber pIwsMaitosimvagotmttkn3x12) {
        iwsMaitosimvagotmttkn3x12 = pIwsMaitosimvagotmttkn3x12;
    }

    @Column(order = 236, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x13;

    public BizNumber getIwsMaitosimvagotmttkn3x13() {
        return iwsMaitosimvagotmttkn3x13;
    }

    public void setIwsMaitosimvagotmttkn3x13(BizNumber pIwsMaitosimvagotmttkn3x13) {
        iwsMaitosimvagotmttkn3x13 = pIwsMaitosimvagotmttkn3x13;
    }

    @Column(order = 237, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x14;

    public BizNumber getIwsMaitosimvagotmttkn3x14() {
        return iwsMaitosimvagotmttkn3x14;
    }

    public void setIwsMaitosimvagotmttkn3x14(BizNumber pIwsMaitosimvagotmttkn3x14) {
        iwsMaitosimvagotmttkn3x14 = pIwsMaitosimvagotmttkn3x14;
    }

    @Column(order = 238, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x15;

    public BizNumber getIwsMaitosimvagotmttkn3x15() {
        return iwsMaitosimvagotmttkn3x15;
    }

    public void setIwsMaitosimvagotmttkn3x15(BizNumber pIwsMaitosimvagotmttkn3x15) {
        iwsMaitosimvagotmttkn3x15 = pIwsMaitosimvagotmttkn3x15;
    }

    @Column(order = 239, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x16;

    public BizNumber getIwsMaitosimvagotmttkn3x16() {
        return iwsMaitosimvagotmttkn3x16;
    }

    public void setIwsMaitosimvagotmttkn3x16(BizNumber pIwsMaitosimvagotmttkn3x16) {
        iwsMaitosimvagotmttkn3x16 = pIwsMaitosimvagotmttkn3x16;
    }

    @Column(order = 240, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x17;

    public BizNumber getIwsMaitosimvagotmttkn3x17() {
        return iwsMaitosimvagotmttkn3x17;
    }

    public void setIwsMaitosimvagotmttkn3x17(BizNumber pIwsMaitosimvagotmttkn3x17) {
        iwsMaitosimvagotmttkn3x17 = pIwsMaitosimvagotmttkn3x17;
    }

    @Column(order = 241, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x18;

    public BizNumber getIwsMaitosimvagotmttkn3x18() {
        return iwsMaitosimvagotmttkn3x18;
    }

    public void setIwsMaitosimvagotmttkn3x18(BizNumber pIwsMaitosimvagotmttkn3x18) {
        iwsMaitosimvagotmttkn3x18 = pIwsMaitosimvagotmttkn3x18;
    }

    @Column(order = 242, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x19;

    public BizNumber getIwsMaitosimvagotmttkn3x19() {
        return iwsMaitosimvagotmttkn3x19;
    }

    public void setIwsMaitosimvagotmttkn3x19(BizNumber pIwsMaitosimvagotmttkn3x19) {
        iwsMaitosimvagotmttkn3x19 = pIwsMaitosimvagotmttkn3x19;
    }

    @Column(order = 243, length = 13)
    private BizNumber iwsMaitosimvagotmttkn3x20;

    public BizNumber getIwsMaitosimvagotmttkn3x20() {
        return iwsMaitosimvagotmttkn3x20;
    }

    public void setIwsMaitosimvagotmttkn3x20(BizNumber pIwsMaitosimvagotmttkn3x20) {
        iwsMaitosimvagotmttkn3x20 = pIwsMaitosimvagotmttkn3x20;
    }

    @Column(order = 244, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x1;

    public BizNumber getIwsMaitosimvagotmttkn4x1() {
        return iwsMaitosimvagotmttkn4x1;
    }

    public void setIwsMaitosimvagotmttkn4x1(BizNumber pIwsMaitosimvagotmttkn4x1) {
        iwsMaitosimvagotmttkn4x1 = pIwsMaitosimvagotmttkn4x1;
    }

    @Column(order = 245, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x2;

    public BizNumber getIwsMaitosimvagotmttkn4x2() {
        return iwsMaitosimvagotmttkn4x2;
    }

    public void setIwsMaitosimvagotmttkn4x2(BizNumber pIwsMaitosimvagotmttkn4x2) {
        iwsMaitosimvagotmttkn4x2 = pIwsMaitosimvagotmttkn4x2;
    }

    @Column(order = 246, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x3;

    public BizNumber getIwsMaitosimvagotmttkn4x3() {
        return iwsMaitosimvagotmttkn4x3;
    }

    public void setIwsMaitosimvagotmttkn4x3(BizNumber pIwsMaitosimvagotmttkn4x3) {
        iwsMaitosimvagotmttkn4x3 = pIwsMaitosimvagotmttkn4x3;
    }

    @Column(order = 247, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x4;

    public BizNumber getIwsMaitosimvagotmttkn4x4() {
        return iwsMaitosimvagotmttkn4x4;
    }

    public void setIwsMaitosimvagotmttkn4x4(BizNumber pIwsMaitosimvagotmttkn4x4) {
        iwsMaitosimvagotmttkn4x4 = pIwsMaitosimvagotmttkn4x4;
    }

    @Column(order = 248, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x5;

    public BizNumber getIwsMaitosimvagotmttkn4x5() {
        return iwsMaitosimvagotmttkn4x5;
    }

    public void setIwsMaitosimvagotmttkn4x5(BizNumber pIwsMaitosimvagotmttkn4x5) {
        iwsMaitosimvagotmttkn4x5 = pIwsMaitosimvagotmttkn4x5;
    }

    @Column(order = 249, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x6;

    public BizNumber getIwsMaitosimvagotmttkn4x6() {
        return iwsMaitosimvagotmttkn4x6;
    }

    public void setIwsMaitosimvagotmttkn4x6(BizNumber pIwsMaitosimvagotmttkn4x6) {
        iwsMaitosimvagotmttkn4x6 = pIwsMaitosimvagotmttkn4x6;
    }

    @Column(order = 250, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x7;

    public BizNumber getIwsMaitosimvagotmttkn4x7() {
        return iwsMaitosimvagotmttkn4x7;
    }

    public void setIwsMaitosimvagotmttkn4x7(BizNumber pIwsMaitosimvagotmttkn4x7) {
        iwsMaitosimvagotmttkn4x7 = pIwsMaitosimvagotmttkn4x7;
    }

    @Column(order = 251, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x8;

    public BizNumber getIwsMaitosimvagotmttkn4x8() {
        return iwsMaitosimvagotmttkn4x8;
    }

    public void setIwsMaitosimvagotmttkn4x8(BizNumber pIwsMaitosimvagotmttkn4x8) {
        iwsMaitosimvagotmttkn4x8 = pIwsMaitosimvagotmttkn4x8;
    }

    @Column(order = 252, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x9;

    public BizNumber getIwsMaitosimvagotmttkn4x9() {
        return iwsMaitosimvagotmttkn4x9;
    }

    public void setIwsMaitosimvagotmttkn4x9(BizNumber pIwsMaitosimvagotmttkn4x9) {
        iwsMaitosimvagotmttkn4x9 = pIwsMaitosimvagotmttkn4x9;
    }

    @Column(order = 253, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x10;

    public BizNumber getIwsMaitosimvagotmttkn4x10() {
        return iwsMaitosimvagotmttkn4x10;
    }

    public void setIwsMaitosimvagotmttkn4x10(BizNumber pIwsMaitosimvagotmttkn4x10) {
        iwsMaitosimvagotmttkn4x10 = pIwsMaitosimvagotmttkn4x10;
    }

    @Column(order = 254, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x11;

    public BizNumber getIwsMaitosimvagotmttkn4x11() {
        return iwsMaitosimvagotmttkn4x11;
    }

    public void setIwsMaitosimvagotmttkn4x11(BizNumber pIwsMaitosimvagotmttkn4x11) {
        iwsMaitosimvagotmttkn4x11 = pIwsMaitosimvagotmttkn4x11;
    }

    @Column(order = 255, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x12;

    public BizNumber getIwsMaitosimvagotmttkn4x12() {
        return iwsMaitosimvagotmttkn4x12;
    }

    public void setIwsMaitosimvagotmttkn4x12(BizNumber pIwsMaitosimvagotmttkn4x12) {
        iwsMaitosimvagotmttkn4x12 = pIwsMaitosimvagotmttkn4x12;
    }

    @Column(order = 256, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x13;

    public BizNumber getIwsMaitosimvagotmttkn4x13() {
        return iwsMaitosimvagotmttkn4x13;
    }

    public void setIwsMaitosimvagotmttkn4x13(BizNumber pIwsMaitosimvagotmttkn4x13) {
        iwsMaitosimvagotmttkn4x13 = pIwsMaitosimvagotmttkn4x13;
    }

    @Column(order = 257, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x14;

    public BizNumber getIwsMaitosimvagotmttkn4x14() {
        return iwsMaitosimvagotmttkn4x14;
    }

    public void setIwsMaitosimvagotmttkn4x14(BizNumber pIwsMaitosimvagotmttkn4x14) {
        iwsMaitosimvagotmttkn4x14 = pIwsMaitosimvagotmttkn4x14;
    }

    @Column(order = 258, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x15;

    public BizNumber getIwsMaitosimvagotmttkn4x15() {
        return iwsMaitosimvagotmttkn4x15;
    }

    public void setIwsMaitosimvagotmttkn4x15(BizNumber pIwsMaitosimvagotmttkn4x15) {
        iwsMaitosimvagotmttkn4x15 = pIwsMaitosimvagotmttkn4x15;
    }

    @Column(order = 259, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x16;

    public BizNumber getIwsMaitosimvagotmttkn4x16() {
        return iwsMaitosimvagotmttkn4x16;
    }

    public void setIwsMaitosimvagotmttkn4x16(BizNumber pIwsMaitosimvagotmttkn4x16) {
        iwsMaitosimvagotmttkn4x16 = pIwsMaitosimvagotmttkn4x16;
    }

    @Column(order = 260, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x17;

    public BizNumber getIwsMaitosimvagotmttkn4x17() {
        return iwsMaitosimvagotmttkn4x17;
    }

    public void setIwsMaitosimvagotmttkn4x17(BizNumber pIwsMaitosimvagotmttkn4x17) {
        iwsMaitosimvagotmttkn4x17 = pIwsMaitosimvagotmttkn4x17;
    }

    @Column(order = 261, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x18;

    public BizNumber getIwsMaitosimvagotmttkn4x18() {
        return iwsMaitosimvagotmttkn4x18;
    }

    public void setIwsMaitosimvagotmttkn4x18(BizNumber pIwsMaitosimvagotmttkn4x18) {
        iwsMaitosimvagotmttkn4x18 = pIwsMaitosimvagotmttkn4x18;
    }

    @Column(order = 262, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x19;

    public BizNumber getIwsMaitosimvagotmttkn4x19() {
        return iwsMaitosimvagotmttkn4x19;
    }

    public void setIwsMaitosimvagotmttkn4x19(BizNumber pIwsMaitosimvagotmttkn4x19) {
        iwsMaitosimvagotmttkn4x19 = pIwsMaitosimvagotmttkn4x19;
    }

    @Column(order = 263, length = 13)
    private BizNumber iwsMaitosimvagotmttkn4x20;

    public BizNumber getIwsMaitosimvagotmttkn4x20() {
        return iwsMaitosimvagotmttkn4x20;
    }

    public void setIwsMaitosimvagotmttkn4x20(BizNumber pIwsMaitosimvagotmttkn4x20) {
        iwsMaitosimvagotmttkn4x20 = pIwsMaitosimvagotmttkn4x20;
    }

    @Column(order = 264, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x1;

    public BizNumber getIwsMaitosimvagotmttkn5x1() {
        return iwsMaitosimvagotmttkn5x1;
    }

    public void setIwsMaitosimvagotmttkn5x1(BizNumber pIwsMaitosimvagotmttkn5x1) {
        iwsMaitosimvagotmttkn5x1 = pIwsMaitosimvagotmttkn5x1;
    }

    @Column(order = 265, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x2;

    public BizNumber getIwsMaitosimvagotmttkn5x2() {
        return iwsMaitosimvagotmttkn5x2;
    }

    public void setIwsMaitosimvagotmttkn5x2(BizNumber pIwsMaitosimvagotmttkn5x2) {
        iwsMaitosimvagotmttkn5x2 = pIwsMaitosimvagotmttkn5x2;
    }

    @Column(order = 266, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x3;

    public BizNumber getIwsMaitosimvagotmttkn5x3() {
        return iwsMaitosimvagotmttkn5x3;
    }

    public void setIwsMaitosimvagotmttkn5x3(BizNumber pIwsMaitosimvagotmttkn5x3) {
        iwsMaitosimvagotmttkn5x3 = pIwsMaitosimvagotmttkn5x3;
    }

    @Column(order = 267, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x4;

    public BizNumber getIwsMaitosimvagotmttkn5x4() {
        return iwsMaitosimvagotmttkn5x4;
    }

    public void setIwsMaitosimvagotmttkn5x4(BizNumber pIwsMaitosimvagotmttkn5x4) {
        iwsMaitosimvagotmttkn5x4 = pIwsMaitosimvagotmttkn5x4;
    }

    @Column(order = 268, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x5;

    public BizNumber getIwsMaitosimvagotmttkn5x5() {
        return iwsMaitosimvagotmttkn5x5;
    }

    public void setIwsMaitosimvagotmttkn5x5(BizNumber pIwsMaitosimvagotmttkn5x5) {
        iwsMaitosimvagotmttkn5x5 = pIwsMaitosimvagotmttkn5x5;
    }

    @Column(order = 269, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x6;

    public BizNumber getIwsMaitosimvagotmttkn5x6() {
        return iwsMaitosimvagotmttkn5x6;
    }

    public void setIwsMaitosimvagotmttkn5x6(BizNumber pIwsMaitosimvagotmttkn5x6) {
        iwsMaitosimvagotmttkn5x6 = pIwsMaitosimvagotmttkn5x6;
    }

    @Column(order = 270, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x7;

    public BizNumber getIwsMaitosimvagotmttkn5x7() {
        return iwsMaitosimvagotmttkn5x7;
    }

    public void setIwsMaitosimvagotmttkn5x7(BizNumber pIwsMaitosimvagotmttkn5x7) {
        iwsMaitosimvagotmttkn5x7 = pIwsMaitosimvagotmttkn5x7;
    }

    @Column(order = 271, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x8;

    public BizNumber getIwsMaitosimvagotmttkn5x8() {
        return iwsMaitosimvagotmttkn5x8;
    }

    public void setIwsMaitosimvagotmttkn5x8(BizNumber pIwsMaitosimvagotmttkn5x8) {
        iwsMaitosimvagotmttkn5x8 = pIwsMaitosimvagotmttkn5x8;
    }

    @Column(order = 272, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x9;

    public BizNumber getIwsMaitosimvagotmttkn5x9() {
        return iwsMaitosimvagotmttkn5x9;
    }

    public void setIwsMaitosimvagotmttkn5x9(BizNumber pIwsMaitosimvagotmttkn5x9) {
        iwsMaitosimvagotmttkn5x9 = pIwsMaitosimvagotmttkn5x9;
    }

    @Column(order = 273, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x10;

    public BizNumber getIwsMaitosimvagotmttkn5x10() {
        return iwsMaitosimvagotmttkn5x10;
    }

    public void setIwsMaitosimvagotmttkn5x10(BizNumber pIwsMaitosimvagotmttkn5x10) {
        iwsMaitosimvagotmttkn5x10 = pIwsMaitosimvagotmttkn5x10;
    }

    @Column(order = 274, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x11;

    public BizNumber getIwsMaitosimvagotmttkn5x11() {
        return iwsMaitosimvagotmttkn5x11;
    }

    public void setIwsMaitosimvagotmttkn5x11(BizNumber pIwsMaitosimvagotmttkn5x11) {
        iwsMaitosimvagotmttkn5x11 = pIwsMaitosimvagotmttkn5x11;
    }

    @Column(order = 275, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x12;

    public BizNumber getIwsMaitosimvagotmttkn5x12() {
        return iwsMaitosimvagotmttkn5x12;
    }

    public void setIwsMaitosimvagotmttkn5x12(BizNumber pIwsMaitosimvagotmttkn5x12) {
        iwsMaitosimvagotmttkn5x12 = pIwsMaitosimvagotmttkn5x12;
    }

    @Column(order = 276, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x13;

    public BizNumber getIwsMaitosimvagotmttkn5x13() {
        return iwsMaitosimvagotmttkn5x13;
    }

    public void setIwsMaitosimvagotmttkn5x13(BizNumber pIwsMaitosimvagotmttkn5x13) {
        iwsMaitosimvagotmttkn5x13 = pIwsMaitosimvagotmttkn5x13;
    }

    @Column(order = 277, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x14;

    public BizNumber getIwsMaitosimvagotmttkn5x14() {
        return iwsMaitosimvagotmttkn5x14;
    }

    public void setIwsMaitosimvagotmttkn5x14(BizNumber pIwsMaitosimvagotmttkn5x14) {
        iwsMaitosimvagotmttkn5x14 = pIwsMaitosimvagotmttkn5x14;
    }

    @Column(order = 278, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x15;

    public BizNumber getIwsMaitosimvagotmttkn5x15() {
        return iwsMaitosimvagotmttkn5x15;
    }

    public void setIwsMaitosimvagotmttkn5x15(BizNumber pIwsMaitosimvagotmttkn5x15) {
        iwsMaitosimvagotmttkn5x15 = pIwsMaitosimvagotmttkn5x15;
    }

    @Column(order = 279, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x16;

    public BizNumber getIwsMaitosimvagotmttkn5x16() {
        return iwsMaitosimvagotmttkn5x16;
    }

    public void setIwsMaitosimvagotmttkn5x16(BizNumber pIwsMaitosimvagotmttkn5x16) {
        iwsMaitosimvagotmttkn5x16 = pIwsMaitosimvagotmttkn5x16;
    }

    @Column(order = 280, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x17;

    public BizNumber getIwsMaitosimvagotmttkn5x17() {
        return iwsMaitosimvagotmttkn5x17;
    }

    public void setIwsMaitosimvagotmttkn5x17(BizNumber pIwsMaitosimvagotmttkn5x17) {
        iwsMaitosimvagotmttkn5x17 = pIwsMaitosimvagotmttkn5x17;
    }

    @Column(order = 281, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x18;

    public BizNumber getIwsMaitosimvagotmttkn5x18() {
        return iwsMaitosimvagotmttkn5x18;
    }

    public void setIwsMaitosimvagotmttkn5x18(BizNumber pIwsMaitosimvagotmttkn5x18) {
        iwsMaitosimvagotmttkn5x18 = pIwsMaitosimvagotmttkn5x18;
    }

    @Column(order = 282, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x19;

    public BizNumber getIwsMaitosimvagotmttkn5x19() {
        return iwsMaitosimvagotmttkn5x19;
    }

    public void setIwsMaitosimvagotmttkn5x19(BizNumber pIwsMaitosimvagotmttkn5x19) {
        iwsMaitosimvagotmttkn5x19 = pIwsMaitosimvagotmttkn5x19;
    }

    @Column(order = 283, length = 13)
    private BizNumber iwsMaitosimvagotmttkn5x20;

    public BizNumber getIwsMaitosimvagotmttkn5x20() {
        return iwsMaitosimvagotmttkn5x20;
    }

    public void setIwsMaitosimvagotmttkn5x20(BizNumber pIwsMaitosimvagotmttkn5x20) {
        iwsMaitosimvagotmttkn5x20 = pIwsMaitosimvagotmttkn5x20;
    }

    @Column(order = 284, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x1;

    public BizNumber getIwsMaitosimvagotmttkn6x1() {
        return iwsMaitosimvagotmttkn6x1;
    }

    public void setIwsMaitosimvagotmttkn6x1(BizNumber pIwsMaitosimvagotmttkn6x1) {
        iwsMaitosimvagotmttkn6x1 = pIwsMaitosimvagotmttkn6x1;
    }

    @Column(order = 285, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x2;

    public BizNumber getIwsMaitosimvagotmttkn6x2() {
        return iwsMaitosimvagotmttkn6x2;
    }

    public void setIwsMaitosimvagotmttkn6x2(BizNumber pIwsMaitosimvagotmttkn6x2) {
        iwsMaitosimvagotmttkn6x2 = pIwsMaitosimvagotmttkn6x2;
    }

    @Column(order = 286, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x3;

    public BizNumber getIwsMaitosimvagotmttkn6x3() {
        return iwsMaitosimvagotmttkn6x3;
    }

    public void setIwsMaitosimvagotmttkn6x3(BizNumber pIwsMaitosimvagotmttkn6x3) {
        iwsMaitosimvagotmttkn6x3 = pIwsMaitosimvagotmttkn6x3;
    }

    @Column(order = 287, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x4;

    public BizNumber getIwsMaitosimvagotmttkn6x4() {
        return iwsMaitosimvagotmttkn6x4;
    }

    public void setIwsMaitosimvagotmttkn6x4(BizNumber pIwsMaitosimvagotmttkn6x4) {
        iwsMaitosimvagotmttkn6x4 = pIwsMaitosimvagotmttkn6x4;
    }

    @Column(order = 288, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x5;

    public BizNumber getIwsMaitosimvagotmttkn6x5() {
        return iwsMaitosimvagotmttkn6x5;
    }

    public void setIwsMaitosimvagotmttkn6x5(BizNumber pIwsMaitosimvagotmttkn6x5) {
        iwsMaitosimvagotmttkn6x5 = pIwsMaitosimvagotmttkn6x5;
    }

    @Column(order = 289, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x6;

    public BizNumber getIwsMaitosimvagotmttkn6x6() {
        return iwsMaitosimvagotmttkn6x6;
    }

    public void setIwsMaitosimvagotmttkn6x6(BizNumber pIwsMaitosimvagotmttkn6x6) {
        iwsMaitosimvagotmttkn6x6 = pIwsMaitosimvagotmttkn6x6;
    }

    @Column(order = 290, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x7;

    public BizNumber getIwsMaitosimvagotmttkn6x7() {
        return iwsMaitosimvagotmttkn6x7;
    }

    public void setIwsMaitosimvagotmttkn6x7(BizNumber pIwsMaitosimvagotmttkn6x7) {
        iwsMaitosimvagotmttkn6x7 = pIwsMaitosimvagotmttkn6x7;
    }

    @Column(order = 291, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x8;

    public BizNumber getIwsMaitosimvagotmttkn6x8() {
        return iwsMaitosimvagotmttkn6x8;
    }

    public void setIwsMaitosimvagotmttkn6x8(BizNumber pIwsMaitosimvagotmttkn6x8) {
        iwsMaitosimvagotmttkn6x8 = pIwsMaitosimvagotmttkn6x8;
    }

    @Column(order = 292, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x9;

    public BizNumber getIwsMaitosimvagotmttkn6x9() {
        return iwsMaitosimvagotmttkn6x9;
    }

    public void setIwsMaitosimvagotmttkn6x9(BizNumber pIwsMaitosimvagotmttkn6x9) {
        iwsMaitosimvagotmttkn6x9 = pIwsMaitosimvagotmttkn6x9;
    }

    @Column(order = 293, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x10;

    public BizNumber getIwsMaitosimvagotmttkn6x10() {
        return iwsMaitosimvagotmttkn6x10;
    }

    public void setIwsMaitosimvagotmttkn6x10(BizNumber pIwsMaitosimvagotmttkn6x10) {
        iwsMaitosimvagotmttkn6x10 = pIwsMaitosimvagotmttkn6x10;
    }

    @Column(order = 294, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x11;

    public BizNumber getIwsMaitosimvagotmttkn6x11() {
        return iwsMaitosimvagotmttkn6x11;
    }

    public void setIwsMaitosimvagotmttkn6x11(BizNumber pIwsMaitosimvagotmttkn6x11) {
        iwsMaitosimvagotmttkn6x11 = pIwsMaitosimvagotmttkn6x11;
    }

    @Column(order = 295, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x12;

    public BizNumber getIwsMaitosimvagotmttkn6x12() {
        return iwsMaitosimvagotmttkn6x12;
    }

    public void setIwsMaitosimvagotmttkn6x12(BizNumber pIwsMaitosimvagotmttkn6x12) {
        iwsMaitosimvagotmttkn6x12 = pIwsMaitosimvagotmttkn6x12;
    }

    @Column(order = 296, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x13;

    public BizNumber getIwsMaitosimvagotmttkn6x13() {
        return iwsMaitosimvagotmttkn6x13;
    }

    public void setIwsMaitosimvagotmttkn6x13(BizNumber pIwsMaitosimvagotmttkn6x13) {
        iwsMaitosimvagotmttkn6x13 = pIwsMaitosimvagotmttkn6x13;
    }

    @Column(order = 297, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x14;

    public BizNumber getIwsMaitosimvagotmttkn6x14() {
        return iwsMaitosimvagotmttkn6x14;
    }

    public void setIwsMaitosimvagotmttkn6x14(BizNumber pIwsMaitosimvagotmttkn6x14) {
        iwsMaitosimvagotmttkn6x14 = pIwsMaitosimvagotmttkn6x14;
    }

    @Column(order = 298, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x15;

    public BizNumber getIwsMaitosimvagotmttkn6x15() {
        return iwsMaitosimvagotmttkn6x15;
    }

    public void setIwsMaitosimvagotmttkn6x15(BizNumber pIwsMaitosimvagotmttkn6x15) {
        iwsMaitosimvagotmttkn6x15 = pIwsMaitosimvagotmttkn6x15;
    }

    @Column(order = 299, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x16;

    public BizNumber getIwsMaitosimvagotmttkn6x16() {
        return iwsMaitosimvagotmttkn6x16;
    }

    public void setIwsMaitosimvagotmttkn6x16(BizNumber pIwsMaitosimvagotmttkn6x16) {
        iwsMaitosimvagotmttkn6x16 = pIwsMaitosimvagotmttkn6x16;
    }

    @Column(order = 300, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x17;

    public BizNumber getIwsMaitosimvagotmttkn6x17() {
        return iwsMaitosimvagotmttkn6x17;
    }

    public void setIwsMaitosimvagotmttkn6x17(BizNumber pIwsMaitosimvagotmttkn6x17) {
        iwsMaitosimvagotmttkn6x17 = pIwsMaitosimvagotmttkn6x17;
    }

    @Column(order = 301, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x18;

    public BizNumber getIwsMaitosimvagotmttkn6x18() {
        return iwsMaitosimvagotmttkn6x18;
    }

    public void setIwsMaitosimvagotmttkn6x18(BizNumber pIwsMaitosimvagotmttkn6x18) {
        iwsMaitosimvagotmttkn6x18 = pIwsMaitosimvagotmttkn6x18;
    }

    @Column(order = 302, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x19;

    public BizNumber getIwsMaitosimvagotmttkn6x19() {
        return iwsMaitosimvagotmttkn6x19;
    }

    public void setIwsMaitosimvagotmttkn6x19(BizNumber pIwsMaitosimvagotmttkn6x19) {
        iwsMaitosimvagotmttkn6x19 = pIwsMaitosimvagotmttkn6x19;
    }

    @Column(order = 303, length = 13)
    private BizNumber iwsMaitosimvagotmttkn6x20;

    public BizNumber getIwsMaitosimvagotmttkn6x20() {
        return iwsMaitosimvagotmttkn6x20;
    }

    public void setIwsMaitosimvagotmttkn6x20(BizNumber pIwsMaitosimvagotmttkn6x20) {
        iwsMaitosimvagotmttkn6x20 = pIwsMaitosimvagotmttkn6x20;
    }

    @Column(order = 304, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x1;

    public BizNumber getIwsMaitosimvagotmttkn7x1() {
        return iwsMaitosimvagotmttkn7x1;
    }

    public void setIwsMaitosimvagotmttkn7x1(BizNumber pIwsMaitosimvagotmttkn7x1) {
        iwsMaitosimvagotmttkn7x1 = pIwsMaitosimvagotmttkn7x1;
    }

    @Column(order = 305, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x2;

    public BizNumber getIwsMaitosimvagotmttkn7x2() {
        return iwsMaitosimvagotmttkn7x2;
    }

    public void setIwsMaitosimvagotmttkn7x2(BizNumber pIwsMaitosimvagotmttkn7x2) {
        iwsMaitosimvagotmttkn7x2 = pIwsMaitosimvagotmttkn7x2;
    }

    @Column(order = 306, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x3;

    public BizNumber getIwsMaitosimvagotmttkn7x3() {
        return iwsMaitosimvagotmttkn7x3;
    }

    public void setIwsMaitosimvagotmttkn7x3(BizNumber pIwsMaitosimvagotmttkn7x3) {
        iwsMaitosimvagotmttkn7x3 = pIwsMaitosimvagotmttkn7x3;
    }

    @Column(order = 307, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x4;

    public BizNumber getIwsMaitosimvagotmttkn7x4() {
        return iwsMaitosimvagotmttkn7x4;
    }

    public void setIwsMaitosimvagotmttkn7x4(BizNumber pIwsMaitosimvagotmttkn7x4) {
        iwsMaitosimvagotmttkn7x4 = pIwsMaitosimvagotmttkn7x4;
    }

    @Column(order = 308, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x5;

    public BizNumber getIwsMaitosimvagotmttkn7x5() {
        return iwsMaitosimvagotmttkn7x5;
    }

    public void setIwsMaitosimvagotmttkn7x5(BizNumber pIwsMaitosimvagotmttkn7x5) {
        iwsMaitosimvagotmttkn7x5 = pIwsMaitosimvagotmttkn7x5;
    }

    @Column(order = 309, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x6;

    public BizNumber getIwsMaitosimvagotmttkn7x6() {
        return iwsMaitosimvagotmttkn7x6;
    }

    public void setIwsMaitosimvagotmttkn7x6(BizNumber pIwsMaitosimvagotmttkn7x6) {
        iwsMaitosimvagotmttkn7x6 = pIwsMaitosimvagotmttkn7x6;
    }

    @Column(order = 310, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x7;

    public BizNumber getIwsMaitosimvagotmttkn7x7() {
        return iwsMaitosimvagotmttkn7x7;
    }

    public void setIwsMaitosimvagotmttkn7x7(BizNumber pIwsMaitosimvagotmttkn7x7) {
        iwsMaitosimvagotmttkn7x7 = pIwsMaitosimvagotmttkn7x7;
    }

    @Column(order = 311, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x8;

    public BizNumber getIwsMaitosimvagotmttkn7x8() {
        return iwsMaitosimvagotmttkn7x8;
    }

    public void setIwsMaitosimvagotmttkn7x8(BizNumber pIwsMaitosimvagotmttkn7x8) {
        iwsMaitosimvagotmttkn7x8 = pIwsMaitosimvagotmttkn7x8;
    }

    @Column(order = 312, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x9;

    public BizNumber getIwsMaitosimvagotmttkn7x9() {
        return iwsMaitosimvagotmttkn7x9;
    }

    public void setIwsMaitosimvagotmttkn7x9(BizNumber pIwsMaitosimvagotmttkn7x9) {
        iwsMaitosimvagotmttkn7x9 = pIwsMaitosimvagotmttkn7x9;
    }

    @Column(order = 313, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x10;

    public BizNumber getIwsMaitosimvagotmttkn7x10() {
        return iwsMaitosimvagotmttkn7x10;
    }

    public void setIwsMaitosimvagotmttkn7x10(BizNumber pIwsMaitosimvagotmttkn7x10) {
        iwsMaitosimvagotmttkn7x10 = pIwsMaitosimvagotmttkn7x10;
    }

    @Column(order = 314, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x11;

    public BizNumber getIwsMaitosimvagotmttkn7x11() {
        return iwsMaitosimvagotmttkn7x11;
    }

    public void setIwsMaitosimvagotmttkn7x11(BizNumber pIwsMaitosimvagotmttkn7x11) {
        iwsMaitosimvagotmttkn7x11 = pIwsMaitosimvagotmttkn7x11;
    }

    @Column(order = 315, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x12;

    public BizNumber getIwsMaitosimvagotmttkn7x12() {
        return iwsMaitosimvagotmttkn7x12;
    }

    public void setIwsMaitosimvagotmttkn7x12(BizNumber pIwsMaitosimvagotmttkn7x12) {
        iwsMaitosimvagotmttkn7x12 = pIwsMaitosimvagotmttkn7x12;
    }

    @Column(order = 316, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x13;

    public BizNumber getIwsMaitosimvagotmttkn7x13() {
        return iwsMaitosimvagotmttkn7x13;
    }

    public void setIwsMaitosimvagotmttkn7x13(BizNumber pIwsMaitosimvagotmttkn7x13) {
        iwsMaitosimvagotmttkn7x13 = pIwsMaitosimvagotmttkn7x13;
    }

    @Column(order = 317, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x14;

    public BizNumber getIwsMaitosimvagotmttkn7x14() {
        return iwsMaitosimvagotmttkn7x14;
    }

    public void setIwsMaitosimvagotmttkn7x14(BizNumber pIwsMaitosimvagotmttkn7x14) {
        iwsMaitosimvagotmttkn7x14 = pIwsMaitosimvagotmttkn7x14;
    }

    @Column(order = 318, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x15;

    public BizNumber getIwsMaitosimvagotmttkn7x15() {
        return iwsMaitosimvagotmttkn7x15;
    }

    public void setIwsMaitosimvagotmttkn7x15(BizNumber pIwsMaitosimvagotmttkn7x15) {
        iwsMaitosimvagotmttkn7x15 = pIwsMaitosimvagotmttkn7x15;
    }

    @Column(order = 319, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x16;

    public BizNumber getIwsMaitosimvagotmttkn7x16() {
        return iwsMaitosimvagotmttkn7x16;
    }

    public void setIwsMaitosimvagotmttkn7x16(BizNumber pIwsMaitosimvagotmttkn7x16) {
        iwsMaitosimvagotmttkn7x16 = pIwsMaitosimvagotmttkn7x16;
    }

    @Column(order = 320, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x17;

    public BizNumber getIwsMaitosimvagotmttkn7x17() {
        return iwsMaitosimvagotmttkn7x17;
    }

    public void setIwsMaitosimvagotmttkn7x17(BizNumber pIwsMaitosimvagotmttkn7x17) {
        iwsMaitosimvagotmttkn7x17 = pIwsMaitosimvagotmttkn7x17;
    }

    @Column(order = 321, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x18;

    public BizNumber getIwsMaitosimvagotmttkn7x18() {
        return iwsMaitosimvagotmttkn7x18;
    }

    public void setIwsMaitosimvagotmttkn7x18(BizNumber pIwsMaitosimvagotmttkn7x18) {
        iwsMaitosimvagotmttkn7x18 = pIwsMaitosimvagotmttkn7x18;
    }

    @Column(order = 322, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x19;

    public BizNumber getIwsMaitosimvagotmttkn7x19() {
        return iwsMaitosimvagotmttkn7x19;
    }

    public void setIwsMaitosimvagotmttkn7x19(BizNumber pIwsMaitosimvagotmttkn7x19) {
        iwsMaitosimvagotmttkn7x19 = pIwsMaitosimvagotmttkn7x19;
    }

    @Column(order = 323, length = 13)
    private BizNumber iwsMaitosimvagotmttkn7x20;

    public BizNumber getIwsMaitosimvagotmttkn7x20() {
        return iwsMaitosimvagotmttkn7x20;
    }

    public void setIwsMaitosimvagotmttkn7x20(BizNumber pIwsMaitosimvagotmttkn7x20) {
        iwsMaitosimvagotmttkn7x20 = pIwsMaitosimvagotmttkn7x20;
    }

    @Column(order = 324, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x1;

    public BizNumber getIwsMaitosimvagotmttkn8x1() {
        return iwsMaitosimvagotmttkn8x1;
    }

    public void setIwsMaitosimvagotmttkn8x1(BizNumber pIwsMaitosimvagotmttkn8x1) {
        iwsMaitosimvagotmttkn8x1 = pIwsMaitosimvagotmttkn8x1;
    }

    @Column(order = 325, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x2;

    public BizNumber getIwsMaitosimvagotmttkn8x2() {
        return iwsMaitosimvagotmttkn8x2;
    }

    public void setIwsMaitosimvagotmttkn8x2(BizNumber pIwsMaitosimvagotmttkn8x2) {
        iwsMaitosimvagotmttkn8x2 = pIwsMaitosimvagotmttkn8x2;
    }

    @Column(order = 326, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x3;

    public BizNumber getIwsMaitosimvagotmttkn8x3() {
        return iwsMaitosimvagotmttkn8x3;
    }

    public void setIwsMaitosimvagotmttkn8x3(BizNumber pIwsMaitosimvagotmttkn8x3) {
        iwsMaitosimvagotmttkn8x3 = pIwsMaitosimvagotmttkn8x3;
    }

    @Column(order = 327, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x4;

    public BizNumber getIwsMaitosimvagotmttkn8x4() {
        return iwsMaitosimvagotmttkn8x4;
    }

    public void setIwsMaitosimvagotmttkn8x4(BizNumber pIwsMaitosimvagotmttkn8x4) {
        iwsMaitosimvagotmttkn8x4 = pIwsMaitosimvagotmttkn8x4;
    }

    @Column(order = 328, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x5;

    public BizNumber getIwsMaitosimvagotmttkn8x5() {
        return iwsMaitosimvagotmttkn8x5;
    }

    public void setIwsMaitosimvagotmttkn8x5(BizNumber pIwsMaitosimvagotmttkn8x5) {
        iwsMaitosimvagotmttkn8x5 = pIwsMaitosimvagotmttkn8x5;
    }

    @Column(order = 329, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x6;

    public BizNumber getIwsMaitosimvagotmttkn8x6() {
        return iwsMaitosimvagotmttkn8x6;
    }

    public void setIwsMaitosimvagotmttkn8x6(BizNumber pIwsMaitosimvagotmttkn8x6) {
        iwsMaitosimvagotmttkn8x6 = pIwsMaitosimvagotmttkn8x6;
    }

    @Column(order = 330, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x7;

    public BizNumber getIwsMaitosimvagotmttkn8x7() {
        return iwsMaitosimvagotmttkn8x7;
    }

    public void setIwsMaitosimvagotmttkn8x7(BizNumber pIwsMaitosimvagotmttkn8x7) {
        iwsMaitosimvagotmttkn8x7 = pIwsMaitosimvagotmttkn8x7;
    }

    @Column(order = 331, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x8;

    public BizNumber getIwsMaitosimvagotmttkn8x8() {
        return iwsMaitosimvagotmttkn8x8;
    }

    public void setIwsMaitosimvagotmttkn8x8(BizNumber pIwsMaitosimvagotmttkn8x8) {
        iwsMaitosimvagotmttkn8x8 = pIwsMaitosimvagotmttkn8x8;
    }

    @Column(order = 332, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x9;

    public BizNumber getIwsMaitosimvagotmttkn8x9() {
        return iwsMaitosimvagotmttkn8x9;
    }

    public void setIwsMaitosimvagotmttkn8x9(BizNumber pIwsMaitosimvagotmttkn8x9) {
        iwsMaitosimvagotmttkn8x9 = pIwsMaitosimvagotmttkn8x9;
    }

    @Column(order = 333, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x10;

    public BizNumber getIwsMaitosimvagotmttkn8x10() {
        return iwsMaitosimvagotmttkn8x10;
    }

    public void setIwsMaitosimvagotmttkn8x10(BizNumber pIwsMaitosimvagotmttkn8x10) {
        iwsMaitosimvagotmttkn8x10 = pIwsMaitosimvagotmttkn8x10;
    }

    @Column(order = 334, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x11;

    public BizNumber getIwsMaitosimvagotmttkn8x11() {
        return iwsMaitosimvagotmttkn8x11;
    }

    public void setIwsMaitosimvagotmttkn8x11(BizNumber pIwsMaitosimvagotmttkn8x11) {
        iwsMaitosimvagotmttkn8x11 = pIwsMaitosimvagotmttkn8x11;
    }

    @Column(order = 335, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x12;

    public BizNumber getIwsMaitosimvagotmttkn8x12() {
        return iwsMaitosimvagotmttkn8x12;
    }

    public void setIwsMaitosimvagotmttkn8x12(BizNumber pIwsMaitosimvagotmttkn8x12) {
        iwsMaitosimvagotmttkn8x12 = pIwsMaitosimvagotmttkn8x12;
    }

    @Column(order = 336, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x13;

    public BizNumber getIwsMaitosimvagotmttkn8x13() {
        return iwsMaitosimvagotmttkn8x13;
    }

    public void setIwsMaitosimvagotmttkn8x13(BizNumber pIwsMaitosimvagotmttkn8x13) {
        iwsMaitosimvagotmttkn8x13 = pIwsMaitosimvagotmttkn8x13;
    }

    @Column(order = 337, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x14;

    public BizNumber getIwsMaitosimvagotmttkn8x14() {
        return iwsMaitosimvagotmttkn8x14;
    }

    public void setIwsMaitosimvagotmttkn8x14(BizNumber pIwsMaitosimvagotmttkn8x14) {
        iwsMaitosimvagotmttkn8x14 = pIwsMaitosimvagotmttkn8x14;
    }

    @Column(order = 338, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x15;

    public BizNumber getIwsMaitosimvagotmttkn8x15() {
        return iwsMaitosimvagotmttkn8x15;
    }

    public void setIwsMaitosimvagotmttkn8x15(BizNumber pIwsMaitosimvagotmttkn8x15) {
        iwsMaitosimvagotmttkn8x15 = pIwsMaitosimvagotmttkn8x15;
    }

    @Column(order = 339, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x16;

    public BizNumber getIwsMaitosimvagotmttkn8x16() {
        return iwsMaitosimvagotmttkn8x16;
    }

    public void setIwsMaitosimvagotmttkn8x16(BizNumber pIwsMaitosimvagotmttkn8x16) {
        iwsMaitosimvagotmttkn8x16 = pIwsMaitosimvagotmttkn8x16;
    }

    @Column(order = 340, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x17;

    public BizNumber getIwsMaitosimvagotmttkn8x17() {
        return iwsMaitosimvagotmttkn8x17;
    }

    public void setIwsMaitosimvagotmttkn8x17(BizNumber pIwsMaitosimvagotmttkn8x17) {
        iwsMaitosimvagotmttkn8x17 = pIwsMaitosimvagotmttkn8x17;
    }

    @Column(order = 341, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x18;

    public BizNumber getIwsMaitosimvagotmttkn8x18() {
        return iwsMaitosimvagotmttkn8x18;
    }

    public void setIwsMaitosimvagotmttkn8x18(BizNumber pIwsMaitosimvagotmttkn8x18) {
        iwsMaitosimvagotmttkn8x18 = pIwsMaitosimvagotmttkn8x18;
    }

    @Column(order = 342, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x19;

    public BizNumber getIwsMaitosimvagotmttkn8x19() {
        return iwsMaitosimvagotmttkn8x19;
    }

    public void setIwsMaitosimvagotmttkn8x19(BizNumber pIwsMaitosimvagotmttkn8x19) {
        iwsMaitosimvagotmttkn8x19 = pIwsMaitosimvagotmttkn8x19;
    }

    @Column(order = 343, length = 13)
    private BizNumber iwsMaitosimvagotmttkn8x20;

    public BizNumber getIwsMaitosimvagotmttkn8x20() {
        return iwsMaitosimvagotmttkn8x20;
    }

    public void setIwsMaitosimvagotmttkn8x20(BizNumber pIwsMaitosimvagotmttkn8x20) {
        iwsMaitosimvagotmttkn8x20 = pIwsMaitosimvagotmttkn8x20;
    }

    @Column(order = 344, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x1;

    public BizNumber getIwsMaitosimvagotmttkn9x1() {
        return iwsMaitosimvagotmttkn9x1;
    }

    public void setIwsMaitosimvagotmttkn9x1(BizNumber pIwsMaitosimvagotmttkn9x1) {
        iwsMaitosimvagotmttkn9x1 = pIwsMaitosimvagotmttkn9x1;
    }

    @Column(order = 345, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x2;

    public BizNumber getIwsMaitosimvagotmttkn9x2() {
        return iwsMaitosimvagotmttkn9x2;
    }

    public void setIwsMaitosimvagotmttkn9x2(BizNumber pIwsMaitosimvagotmttkn9x2) {
        iwsMaitosimvagotmttkn9x2 = pIwsMaitosimvagotmttkn9x2;
    }

    @Column(order = 346, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x3;

    public BizNumber getIwsMaitosimvagotmttkn9x3() {
        return iwsMaitosimvagotmttkn9x3;
    }

    public void setIwsMaitosimvagotmttkn9x3(BizNumber pIwsMaitosimvagotmttkn9x3) {
        iwsMaitosimvagotmttkn9x3 = pIwsMaitosimvagotmttkn9x3;
    }

    @Column(order = 347, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x4;

    public BizNumber getIwsMaitosimvagotmttkn9x4() {
        return iwsMaitosimvagotmttkn9x4;
    }

    public void setIwsMaitosimvagotmttkn9x4(BizNumber pIwsMaitosimvagotmttkn9x4) {
        iwsMaitosimvagotmttkn9x4 = pIwsMaitosimvagotmttkn9x4;
    }

    @Column(order = 348, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x5;

    public BizNumber getIwsMaitosimvagotmttkn9x5() {
        return iwsMaitosimvagotmttkn9x5;
    }

    public void setIwsMaitosimvagotmttkn9x5(BizNumber pIwsMaitosimvagotmttkn9x5) {
        iwsMaitosimvagotmttkn9x5 = pIwsMaitosimvagotmttkn9x5;
    }

    @Column(order = 349, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x6;

    public BizNumber getIwsMaitosimvagotmttkn9x6() {
        return iwsMaitosimvagotmttkn9x6;
    }

    public void setIwsMaitosimvagotmttkn9x6(BizNumber pIwsMaitosimvagotmttkn9x6) {
        iwsMaitosimvagotmttkn9x6 = pIwsMaitosimvagotmttkn9x6;
    }

    @Column(order = 350, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x7;

    public BizNumber getIwsMaitosimvagotmttkn9x7() {
        return iwsMaitosimvagotmttkn9x7;
    }

    public void setIwsMaitosimvagotmttkn9x7(BizNumber pIwsMaitosimvagotmttkn9x7) {
        iwsMaitosimvagotmttkn9x7 = pIwsMaitosimvagotmttkn9x7;
    }

    @Column(order = 351, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x8;

    public BizNumber getIwsMaitosimvagotmttkn9x8() {
        return iwsMaitosimvagotmttkn9x8;
    }

    public void setIwsMaitosimvagotmttkn9x8(BizNumber pIwsMaitosimvagotmttkn9x8) {
        iwsMaitosimvagotmttkn9x8 = pIwsMaitosimvagotmttkn9x8;
    }

    @Column(order = 352, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x9;

    public BizNumber getIwsMaitosimvagotmttkn9x9() {
        return iwsMaitosimvagotmttkn9x9;
    }

    public void setIwsMaitosimvagotmttkn9x9(BizNumber pIwsMaitosimvagotmttkn9x9) {
        iwsMaitosimvagotmttkn9x9 = pIwsMaitosimvagotmttkn9x9;
    }

    @Column(order = 353, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x10;

    public BizNumber getIwsMaitosimvagotmttkn9x10() {
        return iwsMaitosimvagotmttkn9x10;
    }

    public void setIwsMaitosimvagotmttkn9x10(BizNumber pIwsMaitosimvagotmttkn9x10) {
        iwsMaitosimvagotmttkn9x10 = pIwsMaitosimvagotmttkn9x10;
    }

    @Column(order = 354, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x11;

    public BizNumber getIwsMaitosimvagotmttkn9x11() {
        return iwsMaitosimvagotmttkn9x11;
    }

    public void setIwsMaitosimvagotmttkn9x11(BizNumber pIwsMaitosimvagotmttkn9x11) {
        iwsMaitosimvagotmttkn9x11 = pIwsMaitosimvagotmttkn9x11;
    }

    @Column(order = 355, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x12;

    public BizNumber getIwsMaitosimvagotmttkn9x12() {
        return iwsMaitosimvagotmttkn9x12;
    }

    public void setIwsMaitosimvagotmttkn9x12(BizNumber pIwsMaitosimvagotmttkn9x12) {
        iwsMaitosimvagotmttkn9x12 = pIwsMaitosimvagotmttkn9x12;
    }

    @Column(order = 356, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x13;

    public BizNumber getIwsMaitosimvagotmttkn9x13() {
        return iwsMaitosimvagotmttkn9x13;
    }

    public void setIwsMaitosimvagotmttkn9x13(BizNumber pIwsMaitosimvagotmttkn9x13) {
        iwsMaitosimvagotmttkn9x13 = pIwsMaitosimvagotmttkn9x13;
    }

    @Column(order = 357, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x14;

    public BizNumber getIwsMaitosimvagotmttkn9x14() {
        return iwsMaitosimvagotmttkn9x14;
    }

    public void setIwsMaitosimvagotmttkn9x14(BizNumber pIwsMaitosimvagotmttkn9x14) {
        iwsMaitosimvagotmttkn9x14 = pIwsMaitosimvagotmttkn9x14;
    }

    @Column(order = 358, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x15;

    public BizNumber getIwsMaitosimvagotmttkn9x15() {
        return iwsMaitosimvagotmttkn9x15;
    }

    public void setIwsMaitosimvagotmttkn9x15(BizNumber pIwsMaitosimvagotmttkn9x15) {
        iwsMaitosimvagotmttkn9x15 = pIwsMaitosimvagotmttkn9x15;
    }

    @Column(order = 359, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x16;

    public BizNumber getIwsMaitosimvagotmttkn9x16() {
        return iwsMaitosimvagotmttkn9x16;
    }

    public void setIwsMaitosimvagotmttkn9x16(BizNumber pIwsMaitosimvagotmttkn9x16) {
        iwsMaitosimvagotmttkn9x16 = pIwsMaitosimvagotmttkn9x16;
    }

    @Column(order = 360, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x17;

    public BizNumber getIwsMaitosimvagotmttkn9x17() {
        return iwsMaitosimvagotmttkn9x17;
    }

    public void setIwsMaitosimvagotmttkn9x17(BizNumber pIwsMaitosimvagotmttkn9x17) {
        iwsMaitosimvagotmttkn9x17 = pIwsMaitosimvagotmttkn9x17;
    }

    @Column(order = 361, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x18;

    public BizNumber getIwsMaitosimvagotmttkn9x18() {
        return iwsMaitosimvagotmttkn9x18;
    }

    public void setIwsMaitosimvagotmttkn9x18(BizNumber pIwsMaitosimvagotmttkn9x18) {
        iwsMaitosimvagotmttkn9x18 = pIwsMaitosimvagotmttkn9x18;
    }

    @Column(order = 362, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x19;

    public BizNumber getIwsMaitosimvagotmttkn9x19() {
        return iwsMaitosimvagotmttkn9x19;
    }

    public void setIwsMaitosimvagotmttkn9x19(BizNumber pIwsMaitosimvagotmttkn9x19) {
        iwsMaitosimvagotmttkn9x19 = pIwsMaitosimvagotmttkn9x19;
    }

    @Column(order = 363, length = 13)
    private BizNumber iwsMaitosimvagotmttkn9x20;

    public BizNumber getIwsMaitosimvagotmttkn9x20() {
        return iwsMaitosimvagotmttkn9x20;
    }

    public void setIwsMaitosimvagotmttkn9x20(BizNumber pIwsMaitosimvagotmttkn9x20) {
        iwsMaitosimvagotmttkn9x20 = pIwsMaitosimvagotmttkn9x20;
    }

    @Column(order = 364, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x1;

    public BizNumber getIwsMaitosikaiyakuhr1x1() {
        return iwsMaitosikaiyakuhr1x1;
    }

    public void setIwsMaitosikaiyakuhr1x1(BizNumber pIwsMaitosikaiyakuhr1x1) {
        iwsMaitosikaiyakuhr1x1 = pIwsMaitosikaiyakuhr1x1;
    }

    @Column(order = 365, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x2;

    public BizNumber getIwsMaitosikaiyakuhr1x2() {
        return iwsMaitosikaiyakuhr1x2;
    }

    public void setIwsMaitosikaiyakuhr1x2(BizNumber pIwsMaitosikaiyakuhr1x2) {
        iwsMaitosikaiyakuhr1x2 = pIwsMaitosikaiyakuhr1x2;
    }

    @Column(order = 366, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x3;

    public BizNumber getIwsMaitosikaiyakuhr1x3() {
        return iwsMaitosikaiyakuhr1x3;
    }

    public void setIwsMaitosikaiyakuhr1x3(BizNumber pIwsMaitosikaiyakuhr1x3) {
        iwsMaitosikaiyakuhr1x3 = pIwsMaitosikaiyakuhr1x3;
    }

    @Column(order = 367, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x4;

    public BizNumber getIwsMaitosikaiyakuhr1x4() {
        return iwsMaitosikaiyakuhr1x4;
    }

    public void setIwsMaitosikaiyakuhr1x4(BizNumber pIwsMaitosikaiyakuhr1x4) {
        iwsMaitosikaiyakuhr1x4 = pIwsMaitosikaiyakuhr1x4;
    }

    @Column(order = 368, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x5;

    public BizNumber getIwsMaitosikaiyakuhr1x5() {
        return iwsMaitosikaiyakuhr1x5;
    }

    public void setIwsMaitosikaiyakuhr1x5(BizNumber pIwsMaitosikaiyakuhr1x5) {
        iwsMaitosikaiyakuhr1x5 = pIwsMaitosikaiyakuhr1x5;
    }

    @Column(order = 369, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x6;

    public BizNumber getIwsMaitosikaiyakuhr1x6() {
        return iwsMaitosikaiyakuhr1x6;
    }

    public void setIwsMaitosikaiyakuhr1x6(BizNumber pIwsMaitosikaiyakuhr1x6) {
        iwsMaitosikaiyakuhr1x6 = pIwsMaitosikaiyakuhr1x6;
    }

    @Column(order = 370, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x7;

    public BizNumber getIwsMaitosikaiyakuhr1x7() {
        return iwsMaitosikaiyakuhr1x7;
    }

    public void setIwsMaitosikaiyakuhr1x7(BizNumber pIwsMaitosikaiyakuhr1x7) {
        iwsMaitosikaiyakuhr1x7 = pIwsMaitosikaiyakuhr1x7;
    }

    @Column(order = 371, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x8;

    public BizNumber getIwsMaitosikaiyakuhr1x8() {
        return iwsMaitosikaiyakuhr1x8;
    }

    public void setIwsMaitosikaiyakuhr1x8(BizNumber pIwsMaitosikaiyakuhr1x8) {
        iwsMaitosikaiyakuhr1x8 = pIwsMaitosikaiyakuhr1x8;
    }

    @Column(order = 372, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x9;

    public BizNumber getIwsMaitosikaiyakuhr1x9() {
        return iwsMaitosikaiyakuhr1x9;
    }

    public void setIwsMaitosikaiyakuhr1x9(BizNumber pIwsMaitosikaiyakuhr1x9) {
        iwsMaitosikaiyakuhr1x9 = pIwsMaitosikaiyakuhr1x9;
    }

    @Column(order = 373, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x10;

    public BizNumber getIwsMaitosikaiyakuhr1x10() {
        return iwsMaitosikaiyakuhr1x10;
    }

    public void setIwsMaitosikaiyakuhr1x10(BizNumber pIwsMaitosikaiyakuhr1x10) {
        iwsMaitosikaiyakuhr1x10 = pIwsMaitosikaiyakuhr1x10;
    }

    @Column(order = 374, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x11;

    public BizNumber getIwsMaitosikaiyakuhr1x11() {
        return iwsMaitosikaiyakuhr1x11;
    }

    public void setIwsMaitosikaiyakuhr1x11(BizNumber pIwsMaitosikaiyakuhr1x11) {
        iwsMaitosikaiyakuhr1x11 = pIwsMaitosikaiyakuhr1x11;
    }

    @Column(order = 375, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x12;

    public BizNumber getIwsMaitosikaiyakuhr1x12() {
        return iwsMaitosikaiyakuhr1x12;
    }

    public void setIwsMaitosikaiyakuhr1x12(BizNumber pIwsMaitosikaiyakuhr1x12) {
        iwsMaitosikaiyakuhr1x12 = pIwsMaitosikaiyakuhr1x12;
    }

    @Column(order = 376, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x13;

    public BizNumber getIwsMaitosikaiyakuhr1x13() {
        return iwsMaitosikaiyakuhr1x13;
    }

    public void setIwsMaitosikaiyakuhr1x13(BizNumber pIwsMaitosikaiyakuhr1x13) {
        iwsMaitosikaiyakuhr1x13 = pIwsMaitosikaiyakuhr1x13;
    }

    @Column(order = 377, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x14;

    public BizNumber getIwsMaitosikaiyakuhr1x14() {
        return iwsMaitosikaiyakuhr1x14;
    }

    public void setIwsMaitosikaiyakuhr1x14(BizNumber pIwsMaitosikaiyakuhr1x14) {
        iwsMaitosikaiyakuhr1x14 = pIwsMaitosikaiyakuhr1x14;
    }

    @Column(order = 378, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x15;

    public BizNumber getIwsMaitosikaiyakuhr1x15() {
        return iwsMaitosikaiyakuhr1x15;
    }

    public void setIwsMaitosikaiyakuhr1x15(BizNumber pIwsMaitosikaiyakuhr1x15) {
        iwsMaitosikaiyakuhr1x15 = pIwsMaitosikaiyakuhr1x15;
    }

    @Column(order = 379, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x16;

    public BizNumber getIwsMaitosikaiyakuhr1x16() {
        return iwsMaitosikaiyakuhr1x16;
    }

    public void setIwsMaitosikaiyakuhr1x16(BizNumber pIwsMaitosikaiyakuhr1x16) {
        iwsMaitosikaiyakuhr1x16 = pIwsMaitosikaiyakuhr1x16;
    }

    @Column(order = 380, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x17;

    public BizNumber getIwsMaitosikaiyakuhr1x17() {
        return iwsMaitosikaiyakuhr1x17;
    }

    public void setIwsMaitosikaiyakuhr1x17(BizNumber pIwsMaitosikaiyakuhr1x17) {
        iwsMaitosikaiyakuhr1x17 = pIwsMaitosikaiyakuhr1x17;
    }

    @Column(order = 381, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x18;

    public BizNumber getIwsMaitosikaiyakuhr1x18() {
        return iwsMaitosikaiyakuhr1x18;
    }

    public void setIwsMaitosikaiyakuhr1x18(BizNumber pIwsMaitosikaiyakuhr1x18) {
        iwsMaitosikaiyakuhr1x18 = pIwsMaitosikaiyakuhr1x18;
    }

    @Column(order = 382, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x19;

    public BizNumber getIwsMaitosikaiyakuhr1x19() {
        return iwsMaitosikaiyakuhr1x19;
    }

    public void setIwsMaitosikaiyakuhr1x19(BizNumber pIwsMaitosikaiyakuhr1x19) {
        iwsMaitosikaiyakuhr1x19 = pIwsMaitosikaiyakuhr1x19;
    }

    @Column(order = 383, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1x20;

    public BizNumber getIwsMaitosikaiyakuhr1x20() {
        return iwsMaitosikaiyakuhr1x20;
    }

    public void setIwsMaitosikaiyakuhr1x20(BizNumber pIwsMaitosikaiyakuhr1x20) {
        iwsMaitosikaiyakuhr1x20 = pIwsMaitosikaiyakuhr1x20;
    }

    @Column(order = 384, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x1;

    public BizNumber getIwsMaitosikaiyakuhr2x1() {
        return iwsMaitosikaiyakuhr2x1;
    }

    public void setIwsMaitosikaiyakuhr2x1(BizNumber pIwsMaitosikaiyakuhr2x1) {
        iwsMaitosikaiyakuhr2x1 = pIwsMaitosikaiyakuhr2x1;
    }

    @Column(order = 385, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x2;

    public BizNumber getIwsMaitosikaiyakuhr2x2() {
        return iwsMaitosikaiyakuhr2x2;
    }

    public void setIwsMaitosikaiyakuhr2x2(BizNumber pIwsMaitosikaiyakuhr2x2) {
        iwsMaitosikaiyakuhr2x2 = pIwsMaitosikaiyakuhr2x2;
    }

    @Column(order = 386, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x3;

    public BizNumber getIwsMaitosikaiyakuhr2x3() {
        return iwsMaitosikaiyakuhr2x3;
    }

    public void setIwsMaitosikaiyakuhr2x3(BizNumber pIwsMaitosikaiyakuhr2x3) {
        iwsMaitosikaiyakuhr2x3 = pIwsMaitosikaiyakuhr2x3;
    }

    @Column(order = 387, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x4;

    public BizNumber getIwsMaitosikaiyakuhr2x4() {
        return iwsMaitosikaiyakuhr2x4;
    }

    public void setIwsMaitosikaiyakuhr2x4(BizNumber pIwsMaitosikaiyakuhr2x4) {
        iwsMaitosikaiyakuhr2x4 = pIwsMaitosikaiyakuhr2x4;
    }

    @Column(order = 388, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x5;

    public BizNumber getIwsMaitosikaiyakuhr2x5() {
        return iwsMaitosikaiyakuhr2x5;
    }

    public void setIwsMaitosikaiyakuhr2x5(BizNumber pIwsMaitosikaiyakuhr2x5) {
        iwsMaitosikaiyakuhr2x5 = pIwsMaitosikaiyakuhr2x5;
    }

    @Column(order = 389, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x6;

    public BizNumber getIwsMaitosikaiyakuhr2x6() {
        return iwsMaitosikaiyakuhr2x6;
    }

    public void setIwsMaitosikaiyakuhr2x6(BizNumber pIwsMaitosikaiyakuhr2x6) {
        iwsMaitosikaiyakuhr2x6 = pIwsMaitosikaiyakuhr2x6;
    }

    @Column(order = 390, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x7;

    public BizNumber getIwsMaitosikaiyakuhr2x7() {
        return iwsMaitosikaiyakuhr2x7;
    }

    public void setIwsMaitosikaiyakuhr2x7(BizNumber pIwsMaitosikaiyakuhr2x7) {
        iwsMaitosikaiyakuhr2x7 = pIwsMaitosikaiyakuhr2x7;
    }

    @Column(order = 391, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x8;

    public BizNumber getIwsMaitosikaiyakuhr2x8() {
        return iwsMaitosikaiyakuhr2x8;
    }

    public void setIwsMaitosikaiyakuhr2x8(BizNumber pIwsMaitosikaiyakuhr2x8) {
        iwsMaitosikaiyakuhr2x8 = pIwsMaitosikaiyakuhr2x8;
    }

    @Column(order = 392, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x9;

    public BizNumber getIwsMaitosikaiyakuhr2x9() {
        return iwsMaitosikaiyakuhr2x9;
    }

    public void setIwsMaitosikaiyakuhr2x9(BizNumber pIwsMaitosikaiyakuhr2x9) {
        iwsMaitosikaiyakuhr2x9 = pIwsMaitosikaiyakuhr2x9;
    }

    @Column(order = 393, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x10;

    public BizNumber getIwsMaitosikaiyakuhr2x10() {
        return iwsMaitosikaiyakuhr2x10;
    }

    public void setIwsMaitosikaiyakuhr2x10(BizNumber pIwsMaitosikaiyakuhr2x10) {
        iwsMaitosikaiyakuhr2x10 = pIwsMaitosikaiyakuhr2x10;
    }

    @Column(order = 394, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x11;

    public BizNumber getIwsMaitosikaiyakuhr2x11() {
        return iwsMaitosikaiyakuhr2x11;
    }

    public void setIwsMaitosikaiyakuhr2x11(BizNumber pIwsMaitosikaiyakuhr2x11) {
        iwsMaitosikaiyakuhr2x11 = pIwsMaitosikaiyakuhr2x11;
    }

    @Column(order = 395, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x12;

    public BizNumber getIwsMaitosikaiyakuhr2x12() {
        return iwsMaitosikaiyakuhr2x12;
    }

    public void setIwsMaitosikaiyakuhr2x12(BizNumber pIwsMaitosikaiyakuhr2x12) {
        iwsMaitosikaiyakuhr2x12 = pIwsMaitosikaiyakuhr2x12;
    }

    @Column(order = 396, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x13;

    public BizNumber getIwsMaitosikaiyakuhr2x13() {
        return iwsMaitosikaiyakuhr2x13;
    }

    public void setIwsMaitosikaiyakuhr2x13(BizNumber pIwsMaitosikaiyakuhr2x13) {
        iwsMaitosikaiyakuhr2x13 = pIwsMaitosikaiyakuhr2x13;
    }

    @Column(order = 397, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x14;

    public BizNumber getIwsMaitosikaiyakuhr2x14() {
        return iwsMaitosikaiyakuhr2x14;
    }

    public void setIwsMaitosikaiyakuhr2x14(BizNumber pIwsMaitosikaiyakuhr2x14) {
        iwsMaitosikaiyakuhr2x14 = pIwsMaitosikaiyakuhr2x14;
    }

    @Column(order = 398, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x15;

    public BizNumber getIwsMaitosikaiyakuhr2x15() {
        return iwsMaitosikaiyakuhr2x15;
    }

    public void setIwsMaitosikaiyakuhr2x15(BizNumber pIwsMaitosikaiyakuhr2x15) {
        iwsMaitosikaiyakuhr2x15 = pIwsMaitosikaiyakuhr2x15;
    }

    @Column(order = 399, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x16;

    public BizNumber getIwsMaitosikaiyakuhr2x16() {
        return iwsMaitosikaiyakuhr2x16;
    }

    public void setIwsMaitosikaiyakuhr2x16(BizNumber pIwsMaitosikaiyakuhr2x16) {
        iwsMaitosikaiyakuhr2x16 = pIwsMaitosikaiyakuhr2x16;
    }

    @Column(order = 400, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x17;

    public BizNumber getIwsMaitosikaiyakuhr2x17() {
        return iwsMaitosikaiyakuhr2x17;
    }

    public void setIwsMaitosikaiyakuhr2x17(BizNumber pIwsMaitosikaiyakuhr2x17) {
        iwsMaitosikaiyakuhr2x17 = pIwsMaitosikaiyakuhr2x17;
    }

    @Column(order = 401, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x18;

    public BizNumber getIwsMaitosikaiyakuhr2x18() {
        return iwsMaitosikaiyakuhr2x18;
    }

    public void setIwsMaitosikaiyakuhr2x18(BizNumber pIwsMaitosikaiyakuhr2x18) {
        iwsMaitosikaiyakuhr2x18 = pIwsMaitosikaiyakuhr2x18;
    }

    @Column(order = 402, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x19;

    public BizNumber getIwsMaitosikaiyakuhr2x19() {
        return iwsMaitosikaiyakuhr2x19;
    }

    public void setIwsMaitosikaiyakuhr2x19(BizNumber pIwsMaitosikaiyakuhr2x19) {
        iwsMaitosikaiyakuhr2x19 = pIwsMaitosikaiyakuhr2x19;
    }

    @Column(order = 403, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2x20;

    public BizNumber getIwsMaitosikaiyakuhr2x20() {
        return iwsMaitosikaiyakuhr2x20;
    }

    public void setIwsMaitosikaiyakuhr2x20(BizNumber pIwsMaitosikaiyakuhr2x20) {
        iwsMaitosikaiyakuhr2x20 = pIwsMaitosikaiyakuhr2x20;
    }

    @Column(order = 404, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x1;

    public BizNumber getIwsMaitosikaiyakuhr3x1() {
        return iwsMaitosikaiyakuhr3x1;
    }

    public void setIwsMaitosikaiyakuhr3x1(BizNumber pIwsMaitosikaiyakuhr3x1) {
        iwsMaitosikaiyakuhr3x1 = pIwsMaitosikaiyakuhr3x1;
    }

    @Column(order = 405, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x2;

    public BizNumber getIwsMaitosikaiyakuhr3x2() {
        return iwsMaitosikaiyakuhr3x2;
    }

    public void setIwsMaitosikaiyakuhr3x2(BizNumber pIwsMaitosikaiyakuhr3x2) {
        iwsMaitosikaiyakuhr3x2 = pIwsMaitosikaiyakuhr3x2;
    }

    @Column(order = 406, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x3;

    public BizNumber getIwsMaitosikaiyakuhr3x3() {
        return iwsMaitosikaiyakuhr3x3;
    }

    public void setIwsMaitosikaiyakuhr3x3(BizNumber pIwsMaitosikaiyakuhr3x3) {
        iwsMaitosikaiyakuhr3x3 = pIwsMaitosikaiyakuhr3x3;
    }

    @Column(order = 407, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x4;

    public BizNumber getIwsMaitosikaiyakuhr3x4() {
        return iwsMaitosikaiyakuhr3x4;
    }

    public void setIwsMaitosikaiyakuhr3x4(BizNumber pIwsMaitosikaiyakuhr3x4) {
        iwsMaitosikaiyakuhr3x4 = pIwsMaitosikaiyakuhr3x4;
    }

    @Column(order = 408, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x5;

    public BizNumber getIwsMaitosikaiyakuhr3x5() {
        return iwsMaitosikaiyakuhr3x5;
    }

    public void setIwsMaitosikaiyakuhr3x5(BizNumber pIwsMaitosikaiyakuhr3x5) {
        iwsMaitosikaiyakuhr3x5 = pIwsMaitosikaiyakuhr3x5;
    }

    @Column(order = 409, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x6;

    public BizNumber getIwsMaitosikaiyakuhr3x6() {
        return iwsMaitosikaiyakuhr3x6;
    }

    public void setIwsMaitosikaiyakuhr3x6(BizNumber pIwsMaitosikaiyakuhr3x6) {
        iwsMaitosikaiyakuhr3x6 = pIwsMaitosikaiyakuhr3x6;
    }

    @Column(order = 410, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x7;

    public BizNumber getIwsMaitosikaiyakuhr3x7() {
        return iwsMaitosikaiyakuhr3x7;
    }

    public void setIwsMaitosikaiyakuhr3x7(BizNumber pIwsMaitosikaiyakuhr3x7) {
        iwsMaitosikaiyakuhr3x7 = pIwsMaitosikaiyakuhr3x7;
    }

    @Column(order = 411, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x8;

    public BizNumber getIwsMaitosikaiyakuhr3x8() {
        return iwsMaitosikaiyakuhr3x8;
    }

    public void setIwsMaitosikaiyakuhr3x8(BizNumber pIwsMaitosikaiyakuhr3x8) {
        iwsMaitosikaiyakuhr3x8 = pIwsMaitosikaiyakuhr3x8;
    }

    @Column(order = 412, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x9;

    public BizNumber getIwsMaitosikaiyakuhr3x9() {
        return iwsMaitosikaiyakuhr3x9;
    }

    public void setIwsMaitosikaiyakuhr3x9(BizNumber pIwsMaitosikaiyakuhr3x9) {
        iwsMaitosikaiyakuhr3x9 = pIwsMaitosikaiyakuhr3x9;
    }

    @Column(order = 413, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x10;

    public BizNumber getIwsMaitosikaiyakuhr3x10() {
        return iwsMaitosikaiyakuhr3x10;
    }

    public void setIwsMaitosikaiyakuhr3x10(BizNumber pIwsMaitosikaiyakuhr3x10) {
        iwsMaitosikaiyakuhr3x10 = pIwsMaitosikaiyakuhr3x10;
    }

    @Column(order = 414, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x11;

    public BizNumber getIwsMaitosikaiyakuhr3x11() {
        return iwsMaitosikaiyakuhr3x11;
    }

    public void setIwsMaitosikaiyakuhr3x11(BizNumber pIwsMaitosikaiyakuhr3x11) {
        iwsMaitosikaiyakuhr3x11 = pIwsMaitosikaiyakuhr3x11;
    }

    @Column(order = 415, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x12;

    public BizNumber getIwsMaitosikaiyakuhr3x12() {
        return iwsMaitosikaiyakuhr3x12;
    }

    public void setIwsMaitosikaiyakuhr3x12(BizNumber pIwsMaitosikaiyakuhr3x12) {
        iwsMaitosikaiyakuhr3x12 = pIwsMaitosikaiyakuhr3x12;
    }

    @Column(order = 416, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x13;

    public BizNumber getIwsMaitosikaiyakuhr3x13() {
        return iwsMaitosikaiyakuhr3x13;
    }

    public void setIwsMaitosikaiyakuhr3x13(BizNumber pIwsMaitosikaiyakuhr3x13) {
        iwsMaitosikaiyakuhr3x13 = pIwsMaitosikaiyakuhr3x13;
    }

    @Column(order = 417, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x14;

    public BizNumber getIwsMaitosikaiyakuhr3x14() {
        return iwsMaitosikaiyakuhr3x14;
    }

    public void setIwsMaitosikaiyakuhr3x14(BizNumber pIwsMaitosikaiyakuhr3x14) {
        iwsMaitosikaiyakuhr3x14 = pIwsMaitosikaiyakuhr3x14;
    }

    @Column(order = 418, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x15;

    public BizNumber getIwsMaitosikaiyakuhr3x15() {
        return iwsMaitosikaiyakuhr3x15;
    }

    public void setIwsMaitosikaiyakuhr3x15(BizNumber pIwsMaitosikaiyakuhr3x15) {
        iwsMaitosikaiyakuhr3x15 = pIwsMaitosikaiyakuhr3x15;
    }

    @Column(order = 419, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x16;

    public BizNumber getIwsMaitosikaiyakuhr3x16() {
        return iwsMaitosikaiyakuhr3x16;
    }

    public void setIwsMaitosikaiyakuhr3x16(BizNumber pIwsMaitosikaiyakuhr3x16) {
        iwsMaitosikaiyakuhr3x16 = pIwsMaitosikaiyakuhr3x16;
    }

    @Column(order = 420, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x17;

    public BizNumber getIwsMaitosikaiyakuhr3x17() {
        return iwsMaitosikaiyakuhr3x17;
    }

    public void setIwsMaitosikaiyakuhr3x17(BizNumber pIwsMaitosikaiyakuhr3x17) {
        iwsMaitosikaiyakuhr3x17 = pIwsMaitosikaiyakuhr3x17;
    }

    @Column(order = 421, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x18;

    public BizNumber getIwsMaitosikaiyakuhr3x18() {
        return iwsMaitosikaiyakuhr3x18;
    }

    public void setIwsMaitosikaiyakuhr3x18(BizNumber pIwsMaitosikaiyakuhr3x18) {
        iwsMaitosikaiyakuhr3x18 = pIwsMaitosikaiyakuhr3x18;
    }

    @Column(order = 422, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x19;

    public BizNumber getIwsMaitosikaiyakuhr3x19() {
        return iwsMaitosikaiyakuhr3x19;
    }

    public void setIwsMaitosikaiyakuhr3x19(BizNumber pIwsMaitosikaiyakuhr3x19) {
        iwsMaitosikaiyakuhr3x19 = pIwsMaitosikaiyakuhr3x19;
    }

    @Column(order = 423, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3x20;

    public BizNumber getIwsMaitosikaiyakuhr3x20() {
        return iwsMaitosikaiyakuhr3x20;
    }

    public void setIwsMaitosikaiyakuhr3x20(BizNumber pIwsMaitosikaiyakuhr3x20) {
        iwsMaitosikaiyakuhr3x20 = pIwsMaitosikaiyakuhr3x20;
    }

    @Column(order = 424, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x1;

    public BizNumber getIwsMaitosikaiyakuhr4x1() {
        return iwsMaitosikaiyakuhr4x1;
    }

    public void setIwsMaitosikaiyakuhr4x1(BizNumber pIwsMaitosikaiyakuhr4x1) {
        iwsMaitosikaiyakuhr4x1 = pIwsMaitosikaiyakuhr4x1;
    }

    @Column(order = 425, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x2;

    public BizNumber getIwsMaitosikaiyakuhr4x2() {
        return iwsMaitosikaiyakuhr4x2;
    }

    public void setIwsMaitosikaiyakuhr4x2(BizNumber pIwsMaitosikaiyakuhr4x2) {
        iwsMaitosikaiyakuhr4x2 = pIwsMaitosikaiyakuhr4x2;
    }

    @Column(order = 426, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x3;

    public BizNumber getIwsMaitosikaiyakuhr4x3() {
        return iwsMaitosikaiyakuhr4x3;
    }

    public void setIwsMaitosikaiyakuhr4x3(BizNumber pIwsMaitosikaiyakuhr4x3) {
        iwsMaitosikaiyakuhr4x3 = pIwsMaitosikaiyakuhr4x3;
    }

    @Column(order = 427, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x4;

    public BizNumber getIwsMaitosikaiyakuhr4x4() {
        return iwsMaitosikaiyakuhr4x4;
    }

    public void setIwsMaitosikaiyakuhr4x4(BizNumber pIwsMaitosikaiyakuhr4x4) {
        iwsMaitosikaiyakuhr4x4 = pIwsMaitosikaiyakuhr4x4;
    }

    @Column(order = 428, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x5;

    public BizNumber getIwsMaitosikaiyakuhr4x5() {
        return iwsMaitosikaiyakuhr4x5;
    }

    public void setIwsMaitosikaiyakuhr4x5(BizNumber pIwsMaitosikaiyakuhr4x5) {
        iwsMaitosikaiyakuhr4x5 = pIwsMaitosikaiyakuhr4x5;
    }

    @Column(order = 429, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x6;

    public BizNumber getIwsMaitosikaiyakuhr4x6() {
        return iwsMaitosikaiyakuhr4x6;
    }

    public void setIwsMaitosikaiyakuhr4x6(BizNumber pIwsMaitosikaiyakuhr4x6) {
        iwsMaitosikaiyakuhr4x6 = pIwsMaitosikaiyakuhr4x6;
    }

    @Column(order = 430, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x7;

    public BizNumber getIwsMaitosikaiyakuhr4x7() {
        return iwsMaitosikaiyakuhr4x7;
    }

    public void setIwsMaitosikaiyakuhr4x7(BizNumber pIwsMaitosikaiyakuhr4x7) {
        iwsMaitosikaiyakuhr4x7 = pIwsMaitosikaiyakuhr4x7;
    }

    @Column(order = 431, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x8;

    public BizNumber getIwsMaitosikaiyakuhr4x8() {
        return iwsMaitosikaiyakuhr4x8;
    }

    public void setIwsMaitosikaiyakuhr4x8(BizNumber pIwsMaitosikaiyakuhr4x8) {
        iwsMaitosikaiyakuhr4x8 = pIwsMaitosikaiyakuhr4x8;
    }

    @Column(order = 432, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x9;

    public BizNumber getIwsMaitosikaiyakuhr4x9() {
        return iwsMaitosikaiyakuhr4x9;
    }

    public void setIwsMaitosikaiyakuhr4x9(BizNumber pIwsMaitosikaiyakuhr4x9) {
        iwsMaitosikaiyakuhr4x9 = pIwsMaitosikaiyakuhr4x9;
    }

    @Column(order = 433, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x10;

    public BizNumber getIwsMaitosikaiyakuhr4x10() {
        return iwsMaitosikaiyakuhr4x10;
    }

    public void setIwsMaitosikaiyakuhr4x10(BizNumber pIwsMaitosikaiyakuhr4x10) {
        iwsMaitosikaiyakuhr4x10 = pIwsMaitosikaiyakuhr4x10;
    }

    @Column(order = 434, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x11;

    public BizNumber getIwsMaitosikaiyakuhr4x11() {
        return iwsMaitosikaiyakuhr4x11;
    }

    public void setIwsMaitosikaiyakuhr4x11(BizNumber pIwsMaitosikaiyakuhr4x11) {
        iwsMaitosikaiyakuhr4x11 = pIwsMaitosikaiyakuhr4x11;
    }

    @Column(order = 435, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x12;

    public BizNumber getIwsMaitosikaiyakuhr4x12() {
        return iwsMaitosikaiyakuhr4x12;
    }

    public void setIwsMaitosikaiyakuhr4x12(BizNumber pIwsMaitosikaiyakuhr4x12) {
        iwsMaitosikaiyakuhr4x12 = pIwsMaitosikaiyakuhr4x12;
    }

    @Column(order = 436, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x13;

    public BizNumber getIwsMaitosikaiyakuhr4x13() {
        return iwsMaitosikaiyakuhr4x13;
    }

    public void setIwsMaitosikaiyakuhr4x13(BizNumber pIwsMaitosikaiyakuhr4x13) {
        iwsMaitosikaiyakuhr4x13 = pIwsMaitosikaiyakuhr4x13;
    }

    @Column(order = 437, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x14;

    public BizNumber getIwsMaitosikaiyakuhr4x14() {
        return iwsMaitosikaiyakuhr4x14;
    }

    public void setIwsMaitosikaiyakuhr4x14(BizNumber pIwsMaitosikaiyakuhr4x14) {
        iwsMaitosikaiyakuhr4x14 = pIwsMaitosikaiyakuhr4x14;
    }

    @Column(order = 438, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x15;

    public BizNumber getIwsMaitosikaiyakuhr4x15() {
        return iwsMaitosikaiyakuhr4x15;
    }

    public void setIwsMaitosikaiyakuhr4x15(BizNumber pIwsMaitosikaiyakuhr4x15) {
        iwsMaitosikaiyakuhr4x15 = pIwsMaitosikaiyakuhr4x15;
    }

    @Column(order = 439, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x16;

    public BizNumber getIwsMaitosikaiyakuhr4x16() {
        return iwsMaitosikaiyakuhr4x16;
    }

    public void setIwsMaitosikaiyakuhr4x16(BizNumber pIwsMaitosikaiyakuhr4x16) {
        iwsMaitosikaiyakuhr4x16 = pIwsMaitosikaiyakuhr4x16;
    }

    @Column(order = 440, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x17;

    public BizNumber getIwsMaitosikaiyakuhr4x17() {
        return iwsMaitosikaiyakuhr4x17;
    }

    public void setIwsMaitosikaiyakuhr4x17(BizNumber pIwsMaitosikaiyakuhr4x17) {
        iwsMaitosikaiyakuhr4x17 = pIwsMaitosikaiyakuhr4x17;
    }

    @Column(order = 441, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x18;

    public BizNumber getIwsMaitosikaiyakuhr4x18() {
        return iwsMaitosikaiyakuhr4x18;
    }

    public void setIwsMaitosikaiyakuhr4x18(BizNumber pIwsMaitosikaiyakuhr4x18) {
        iwsMaitosikaiyakuhr4x18 = pIwsMaitosikaiyakuhr4x18;
    }

    @Column(order = 442, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x19;

    public BizNumber getIwsMaitosikaiyakuhr4x19() {
        return iwsMaitosikaiyakuhr4x19;
    }

    public void setIwsMaitosikaiyakuhr4x19(BizNumber pIwsMaitosikaiyakuhr4x19) {
        iwsMaitosikaiyakuhr4x19 = pIwsMaitosikaiyakuhr4x19;
    }

    @Column(order = 443, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4x20;

    public BizNumber getIwsMaitosikaiyakuhr4x20() {
        return iwsMaitosikaiyakuhr4x20;
    }

    public void setIwsMaitosikaiyakuhr4x20(BizNumber pIwsMaitosikaiyakuhr4x20) {
        iwsMaitosikaiyakuhr4x20 = pIwsMaitosikaiyakuhr4x20;
    }

    @Column(order = 444, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x1;

    public BizNumber getIwsMaitosikaiyakuhr5x1() {
        return iwsMaitosikaiyakuhr5x1;
    }

    public void setIwsMaitosikaiyakuhr5x1(BizNumber pIwsMaitosikaiyakuhr5x1) {
        iwsMaitosikaiyakuhr5x1 = pIwsMaitosikaiyakuhr5x1;
    }

    @Column(order = 445, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x2;

    public BizNumber getIwsMaitosikaiyakuhr5x2() {
        return iwsMaitosikaiyakuhr5x2;
    }

    public void setIwsMaitosikaiyakuhr5x2(BizNumber pIwsMaitosikaiyakuhr5x2) {
        iwsMaitosikaiyakuhr5x2 = pIwsMaitosikaiyakuhr5x2;
    }

    @Column(order = 446, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x3;

    public BizNumber getIwsMaitosikaiyakuhr5x3() {
        return iwsMaitosikaiyakuhr5x3;
    }

    public void setIwsMaitosikaiyakuhr5x3(BizNumber pIwsMaitosikaiyakuhr5x3) {
        iwsMaitosikaiyakuhr5x3 = pIwsMaitosikaiyakuhr5x3;
    }

    @Column(order = 447, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x4;

    public BizNumber getIwsMaitosikaiyakuhr5x4() {
        return iwsMaitosikaiyakuhr5x4;
    }

    public void setIwsMaitosikaiyakuhr5x4(BizNumber pIwsMaitosikaiyakuhr5x4) {
        iwsMaitosikaiyakuhr5x4 = pIwsMaitosikaiyakuhr5x4;
    }

    @Column(order = 448, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x5;

    public BizNumber getIwsMaitosikaiyakuhr5x5() {
        return iwsMaitosikaiyakuhr5x5;
    }

    public void setIwsMaitosikaiyakuhr5x5(BizNumber pIwsMaitosikaiyakuhr5x5) {
        iwsMaitosikaiyakuhr5x5 = pIwsMaitosikaiyakuhr5x5;
    }

    @Column(order = 449, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x6;

    public BizNumber getIwsMaitosikaiyakuhr5x6() {
        return iwsMaitosikaiyakuhr5x6;
    }

    public void setIwsMaitosikaiyakuhr5x6(BizNumber pIwsMaitosikaiyakuhr5x6) {
        iwsMaitosikaiyakuhr5x6 = pIwsMaitosikaiyakuhr5x6;
    }

    @Column(order = 450, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x7;

    public BizNumber getIwsMaitosikaiyakuhr5x7() {
        return iwsMaitosikaiyakuhr5x7;
    }

    public void setIwsMaitosikaiyakuhr5x7(BizNumber pIwsMaitosikaiyakuhr5x7) {
        iwsMaitosikaiyakuhr5x7 = pIwsMaitosikaiyakuhr5x7;
    }

    @Column(order = 451, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x8;

    public BizNumber getIwsMaitosikaiyakuhr5x8() {
        return iwsMaitosikaiyakuhr5x8;
    }

    public void setIwsMaitosikaiyakuhr5x8(BizNumber pIwsMaitosikaiyakuhr5x8) {
        iwsMaitosikaiyakuhr5x8 = pIwsMaitosikaiyakuhr5x8;
    }

    @Column(order = 452, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x9;

    public BizNumber getIwsMaitosikaiyakuhr5x9() {
        return iwsMaitosikaiyakuhr5x9;
    }

    public void setIwsMaitosikaiyakuhr5x9(BizNumber pIwsMaitosikaiyakuhr5x9) {
        iwsMaitosikaiyakuhr5x9 = pIwsMaitosikaiyakuhr5x9;
    }

    @Column(order = 453, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x10;

    public BizNumber getIwsMaitosikaiyakuhr5x10() {
        return iwsMaitosikaiyakuhr5x10;
    }

    public void setIwsMaitosikaiyakuhr5x10(BizNumber pIwsMaitosikaiyakuhr5x10) {
        iwsMaitosikaiyakuhr5x10 = pIwsMaitosikaiyakuhr5x10;
    }

    @Column(order = 454, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x11;

    public BizNumber getIwsMaitosikaiyakuhr5x11() {
        return iwsMaitosikaiyakuhr5x11;
    }

    public void setIwsMaitosikaiyakuhr5x11(BizNumber pIwsMaitosikaiyakuhr5x11) {
        iwsMaitosikaiyakuhr5x11 = pIwsMaitosikaiyakuhr5x11;
    }

    @Column(order = 455, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x12;

    public BizNumber getIwsMaitosikaiyakuhr5x12() {
        return iwsMaitosikaiyakuhr5x12;
    }

    public void setIwsMaitosikaiyakuhr5x12(BizNumber pIwsMaitosikaiyakuhr5x12) {
        iwsMaitosikaiyakuhr5x12 = pIwsMaitosikaiyakuhr5x12;
    }

    @Column(order = 456, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x13;

    public BizNumber getIwsMaitosikaiyakuhr5x13() {
        return iwsMaitosikaiyakuhr5x13;
    }

    public void setIwsMaitosikaiyakuhr5x13(BizNumber pIwsMaitosikaiyakuhr5x13) {
        iwsMaitosikaiyakuhr5x13 = pIwsMaitosikaiyakuhr5x13;
    }

    @Column(order = 457, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x14;

    public BizNumber getIwsMaitosikaiyakuhr5x14() {
        return iwsMaitosikaiyakuhr5x14;
    }

    public void setIwsMaitosikaiyakuhr5x14(BizNumber pIwsMaitosikaiyakuhr5x14) {
        iwsMaitosikaiyakuhr5x14 = pIwsMaitosikaiyakuhr5x14;
    }

    @Column(order = 458, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x15;

    public BizNumber getIwsMaitosikaiyakuhr5x15() {
        return iwsMaitosikaiyakuhr5x15;
    }

    public void setIwsMaitosikaiyakuhr5x15(BizNumber pIwsMaitosikaiyakuhr5x15) {
        iwsMaitosikaiyakuhr5x15 = pIwsMaitosikaiyakuhr5x15;
    }

    @Column(order = 459, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x16;

    public BizNumber getIwsMaitosikaiyakuhr5x16() {
        return iwsMaitosikaiyakuhr5x16;
    }

    public void setIwsMaitosikaiyakuhr5x16(BizNumber pIwsMaitosikaiyakuhr5x16) {
        iwsMaitosikaiyakuhr5x16 = pIwsMaitosikaiyakuhr5x16;
    }

    @Column(order = 460, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x17;

    public BizNumber getIwsMaitosikaiyakuhr5x17() {
        return iwsMaitosikaiyakuhr5x17;
    }

    public void setIwsMaitosikaiyakuhr5x17(BizNumber pIwsMaitosikaiyakuhr5x17) {
        iwsMaitosikaiyakuhr5x17 = pIwsMaitosikaiyakuhr5x17;
    }

    @Column(order = 461, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x18;

    public BizNumber getIwsMaitosikaiyakuhr5x18() {
        return iwsMaitosikaiyakuhr5x18;
    }

    public void setIwsMaitosikaiyakuhr5x18(BizNumber pIwsMaitosikaiyakuhr5x18) {
        iwsMaitosikaiyakuhr5x18 = pIwsMaitosikaiyakuhr5x18;
    }

    @Column(order = 462, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x19;

    public BizNumber getIwsMaitosikaiyakuhr5x19() {
        return iwsMaitosikaiyakuhr5x19;
    }

    public void setIwsMaitosikaiyakuhr5x19(BizNumber pIwsMaitosikaiyakuhr5x19) {
        iwsMaitosikaiyakuhr5x19 = pIwsMaitosikaiyakuhr5x19;
    }

    @Column(order = 463, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5x20;

    public BizNumber getIwsMaitosikaiyakuhr5x20() {
        return iwsMaitosikaiyakuhr5x20;
    }

    public void setIwsMaitosikaiyakuhr5x20(BizNumber pIwsMaitosikaiyakuhr5x20) {
        iwsMaitosikaiyakuhr5x20 = pIwsMaitosikaiyakuhr5x20;
    }

    @Column(order = 464, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x1;

    public BizNumber getIwsMaitosikaiyakuhr6x1() {
        return iwsMaitosikaiyakuhr6x1;
    }

    public void setIwsMaitosikaiyakuhr6x1(BizNumber pIwsMaitosikaiyakuhr6x1) {
        iwsMaitosikaiyakuhr6x1 = pIwsMaitosikaiyakuhr6x1;
    }

    @Column(order = 465, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x2;

    public BizNumber getIwsMaitosikaiyakuhr6x2() {
        return iwsMaitosikaiyakuhr6x2;
    }

    public void setIwsMaitosikaiyakuhr6x2(BizNumber pIwsMaitosikaiyakuhr6x2) {
        iwsMaitosikaiyakuhr6x2 = pIwsMaitosikaiyakuhr6x2;
    }

    @Column(order = 466, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x3;

    public BizNumber getIwsMaitosikaiyakuhr6x3() {
        return iwsMaitosikaiyakuhr6x3;
    }

    public void setIwsMaitosikaiyakuhr6x3(BizNumber pIwsMaitosikaiyakuhr6x3) {
        iwsMaitosikaiyakuhr6x3 = pIwsMaitosikaiyakuhr6x3;
    }

    @Column(order = 467, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x4;

    public BizNumber getIwsMaitosikaiyakuhr6x4() {
        return iwsMaitosikaiyakuhr6x4;
    }

    public void setIwsMaitosikaiyakuhr6x4(BizNumber pIwsMaitosikaiyakuhr6x4) {
        iwsMaitosikaiyakuhr6x4 = pIwsMaitosikaiyakuhr6x4;
    }

    @Column(order = 468, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x5;

    public BizNumber getIwsMaitosikaiyakuhr6x5() {
        return iwsMaitosikaiyakuhr6x5;
    }

    public void setIwsMaitosikaiyakuhr6x5(BizNumber pIwsMaitosikaiyakuhr6x5) {
        iwsMaitosikaiyakuhr6x5 = pIwsMaitosikaiyakuhr6x5;
    }

    @Column(order = 469, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x6;

    public BizNumber getIwsMaitosikaiyakuhr6x6() {
        return iwsMaitosikaiyakuhr6x6;
    }

    public void setIwsMaitosikaiyakuhr6x6(BizNumber pIwsMaitosikaiyakuhr6x6) {
        iwsMaitosikaiyakuhr6x6 = pIwsMaitosikaiyakuhr6x6;
    }

    @Column(order = 470, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x7;

    public BizNumber getIwsMaitosikaiyakuhr6x7() {
        return iwsMaitosikaiyakuhr6x7;
    }

    public void setIwsMaitosikaiyakuhr6x7(BizNumber pIwsMaitosikaiyakuhr6x7) {
        iwsMaitosikaiyakuhr6x7 = pIwsMaitosikaiyakuhr6x7;
    }

    @Column(order = 471, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x8;

    public BizNumber getIwsMaitosikaiyakuhr6x8() {
        return iwsMaitosikaiyakuhr6x8;
    }

    public void setIwsMaitosikaiyakuhr6x8(BizNumber pIwsMaitosikaiyakuhr6x8) {
        iwsMaitosikaiyakuhr6x8 = pIwsMaitosikaiyakuhr6x8;
    }

    @Column(order = 472, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x9;

    public BizNumber getIwsMaitosikaiyakuhr6x9() {
        return iwsMaitosikaiyakuhr6x9;
    }

    public void setIwsMaitosikaiyakuhr6x9(BizNumber pIwsMaitosikaiyakuhr6x9) {
        iwsMaitosikaiyakuhr6x9 = pIwsMaitosikaiyakuhr6x9;
    }

    @Column(order = 473, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x10;

    public BizNumber getIwsMaitosikaiyakuhr6x10() {
        return iwsMaitosikaiyakuhr6x10;
    }

    public void setIwsMaitosikaiyakuhr6x10(BizNumber pIwsMaitosikaiyakuhr6x10) {
        iwsMaitosikaiyakuhr6x10 = pIwsMaitosikaiyakuhr6x10;
    }

    @Column(order = 474, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x11;

    public BizNumber getIwsMaitosikaiyakuhr6x11() {
        return iwsMaitosikaiyakuhr6x11;
    }

    public void setIwsMaitosikaiyakuhr6x11(BizNumber pIwsMaitosikaiyakuhr6x11) {
        iwsMaitosikaiyakuhr6x11 = pIwsMaitosikaiyakuhr6x11;
    }

    @Column(order = 475, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x12;

    public BizNumber getIwsMaitosikaiyakuhr6x12() {
        return iwsMaitosikaiyakuhr6x12;
    }

    public void setIwsMaitosikaiyakuhr6x12(BizNumber pIwsMaitosikaiyakuhr6x12) {
        iwsMaitosikaiyakuhr6x12 = pIwsMaitosikaiyakuhr6x12;
    }

    @Column(order = 476, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x13;

    public BizNumber getIwsMaitosikaiyakuhr6x13() {
        return iwsMaitosikaiyakuhr6x13;
    }

    public void setIwsMaitosikaiyakuhr6x13(BizNumber pIwsMaitosikaiyakuhr6x13) {
        iwsMaitosikaiyakuhr6x13 = pIwsMaitosikaiyakuhr6x13;
    }

    @Column(order = 477, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x14;

    public BizNumber getIwsMaitosikaiyakuhr6x14() {
        return iwsMaitosikaiyakuhr6x14;
    }

    public void setIwsMaitosikaiyakuhr6x14(BizNumber pIwsMaitosikaiyakuhr6x14) {
        iwsMaitosikaiyakuhr6x14 = pIwsMaitosikaiyakuhr6x14;
    }

    @Column(order = 478, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x15;

    public BizNumber getIwsMaitosikaiyakuhr6x15() {
        return iwsMaitosikaiyakuhr6x15;
    }

    public void setIwsMaitosikaiyakuhr6x15(BizNumber pIwsMaitosikaiyakuhr6x15) {
        iwsMaitosikaiyakuhr6x15 = pIwsMaitosikaiyakuhr6x15;
    }

    @Column(order = 479, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x16;

    public BizNumber getIwsMaitosikaiyakuhr6x16() {
        return iwsMaitosikaiyakuhr6x16;
    }

    public void setIwsMaitosikaiyakuhr6x16(BizNumber pIwsMaitosikaiyakuhr6x16) {
        iwsMaitosikaiyakuhr6x16 = pIwsMaitosikaiyakuhr6x16;
    }

    @Column(order = 480, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x17;

    public BizNumber getIwsMaitosikaiyakuhr6x17() {
        return iwsMaitosikaiyakuhr6x17;
    }

    public void setIwsMaitosikaiyakuhr6x17(BizNumber pIwsMaitosikaiyakuhr6x17) {
        iwsMaitosikaiyakuhr6x17 = pIwsMaitosikaiyakuhr6x17;
    }

    @Column(order = 481, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x18;

    public BizNumber getIwsMaitosikaiyakuhr6x18() {
        return iwsMaitosikaiyakuhr6x18;
    }

    public void setIwsMaitosikaiyakuhr6x18(BizNumber pIwsMaitosikaiyakuhr6x18) {
        iwsMaitosikaiyakuhr6x18 = pIwsMaitosikaiyakuhr6x18;
    }

    @Column(order = 482, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x19;

    public BizNumber getIwsMaitosikaiyakuhr6x19() {
        return iwsMaitosikaiyakuhr6x19;
    }

    public void setIwsMaitosikaiyakuhr6x19(BizNumber pIwsMaitosikaiyakuhr6x19) {
        iwsMaitosikaiyakuhr6x19 = pIwsMaitosikaiyakuhr6x19;
    }

    @Column(order = 483, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6x20;

    public BizNumber getIwsMaitosikaiyakuhr6x20() {
        return iwsMaitosikaiyakuhr6x20;
    }

    public void setIwsMaitosikaiyakuhr6x20(BizNumber pIwsMaitosikaiyakuhr6x20) {
        iwsMaitosikaiyakuhr6x20 = pIwsMaitosikaiyakuhr6x20;
    }

    @Column(order = 484, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x1;

    public BizNumber getIwsMaitosikaiyakuhr7x1() {
        return iwsMaitosikaiyakuhr7x1;
    }

    public void setIwsMaitosikaiyakuhr7x1(BizNumber pIwsMaitosikaiyakuhr7x1) {
        iwsMaitosikaiyakuhr7x1 = pIwsMaitosikaiyakuhr7x1;
    }

    @Column(order = 485, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x2;

    public BizNumber getIwsMaitosikaiyakuhr7x2() {
        return iwsMaitosikaiyakuhr7x2;
    }

    public void setIwsMaitosikaiyakuhr7x2(BizNumber pIwsMaitosikaiyakuhr7x2) {
        iwsMaitosikaiyakuhr7x2 = pIwsMaitosikaiyakuhr7x2;
    }

    @Column(order = 486, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x3;

    public BizNumber getIwsMaitosikaiyakuhr7x3() {
        return iwsMaitosikaiyakuhr7x3;
    }

    public void setIwsMaitosikaiyakuhr7x3(BizNumber pIwsMaitosikaiyakuhr7x3) {
        iwsMaitosikaiyakuhr7x3 = pIwsMaitosikaiyakuhr7x3;
    }

    @Column(order = 487, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x4;

    public BizNumber getIwsMaitosikaiyakuhr7x4() {
        return iwsMaitosikaiyakuhr7x4;
    }

    public void setIwsMaitosikaiyakuhr7x4(BizNumber pIwsMaitosikaiyakuhr7x4) {
        iwsMaitosikaiyakuhr7x4 = pIwsMaitosikaiyakuhr7x4;
    }

    @Column(order = 488, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x5;

    public BizNumber getIwsMaitosikaiyakuhr7x5() {
        return iwsMaitosikaiyakuhr7x5;
    }

    public void setIwsMaitosikaiyakuhr7x5(BizNumber pIwsMaitosikaiyakuhr7x5) {
        iwsMaitosikaiyakuhr7x5 = pIwsMaitosikaiyakuhr7x5;
    }

    @Column(order = 489, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x6;

    public BizNumber getIwsMaitosikaiyakuhr7x6() {
        return iwsMaitosikaiyakuhr7x6;
    }

    public void setIwsMaitosikaiyakuhr7x6(BizNumber pIwsMaitosikaiyakuhr7x6) {
        iwsMaitosikaiyakuhr7x6 = pIwsMaitosikaiyakuhr7x6;
    }

    @Column(order = 490, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x7;

    public BizNumber getIwsMaitosikaiyakuhr7x7() {
        return iwsMaitosikaiyakuhr7x7;
    }

    public void setIwsMaitosikaiyakuhr7x7(BizNumber pIwsMaitosikaiyakuhr7x7) {
        iwsMaitosikaiyakuhr7x7 = pIwsMaitosikaiyakuhr7x7;
    }

    @Column(order = 491, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x8;

    public BizNumber getIwsMaitosikaiyakuhr7x8() {
        return iwsMaitosikaiyakuhr7x8;
    }

    public void setIwsMaitosikaiyakuhr7x8(BizNumber pIwsMaitosikaiyakuhr7x8) {
        iwsMaitosikaiyakuhr7x8 = pIwsMaitosikaiyakuhr7x8;
    }

    @Column(order = 492, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x9;

    public BizNumber getIwsMaitosikaiyakuhr7x9() {
        return iwsMaitosikaiyakuhr7x9;
    }

    public void setIwsMaitosikaiyakuhr7x9(BizNumber pIwsMaitosikaiyakuhr7x9) {
        iwsMaitosikaiyakuhr7x9 = pIwsMaitosikaiyakuhr7x9;
    }

    @Column(order = 493, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x10;

    public BizNumber getIwsMaitosikaiyakuhr7x10() {
        return iwsMaitosikaiyakuhr7x10;
    }

    public void setIwsMaitosikaiyakuhr7x10(BizNumber pIwsMaitosikaiyakuhr7x10) {
        iwsMaitosikaiyakuhr7x10 = pIwsMaitosikaiyakuhr7x10;
    }

    @Column(order = 494, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x11;

    public BizNumber getIwsMaitosikaiyakuhr7x11() {
        return iwsMaitosikaiyakuhr7x11;
    }

    public void setIwsMaitosikaiyakuhr7x11(BizNumber pIwsMaitosikaiyakuhr7x11) {
        iwsMaitosikaiyakuhr7x11 = pIwsMaitosikaiyakuhr7x11;
    }

    @Column(order = 495, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x12;

    public BizNumber getIwsMaitosikaiyakuhr7x12() {
        return iwsMaitosikaiyakuhr7x12;
    }

    public void setIwsMaitosikaiyakuhr7x12(BizNumber pIwsMaitosikaiyakuhr7x12) {
        iwsMaitosikaiyakuhr7x12 = pIwsMaitosikaiyakuhr7x12;
    }

    @Column(order = 496, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x13;

    public BizNumber getIwsMaitosikaiyakuhr7x13() {
        return iwsMaitosikaiyakuhr7x13;
    }

    public void setIwsMaitosikaiyakuhr7x13(BizNumber pIwsMaitosikaiyakuhr7x13) {
        iwsMaitosikaiyakuhr7x13 = pIwsMaitosikaiyakuhr7x13;
    }

    @Column(order = 497, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x14;

    public BizNumber getIwsMaitosikaiyakuhr7x14() {
        return iwsMaitosikaiyakuhr7x14;
    }

    public void setIwsMaitosikaiyakuhr7x14(BizNumber pIwsMaitosikaiyakuhr7x14) {
        iwsMaitosikaiyakuhr7x14 = pIwsMaitosikaiyakuhr7x14;
    }

    @Column(order = 498, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x15;

    public BizNumber getIwsMaitosikaiyakuhr7x15() {
        return iwsMaitosikaiyakuhr7x15;
    }

    public void setIwsMaitosikaiyakuhr7x15(BizNumber pIwsMaitosikaiyakuhr7x15) {
        iwsMaitosikaiyakuhr7x15 = pIwsMaitosikaiyakuhr7x15;
    }

    @Column(order = 499, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x16;

    public BizNumber getIwsMaitosikaiyakuhr7x16() {
        return iwsMaitosikaiyakuhr7x16;
    }

    public void setIwsMaitosikaiyakuhr7x16(BizNumber pIwsMaitosikaiyakuhr7x16) {
        iwsMaitosikaiyakuhr7x16 = pIwsMaitosikaiyakuhr7x16;
    }

    @Column(order = 500, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x17;

    public BizNumber getIwsMaitosikaiyakuhr7x17() {
        return iwsMaitosikaiyakuhr7x17;
    }

    public void setIwsMaitosikaiyakuhr7x17(BizNumber pIwsMaitosikaiyakuhr7x17) {
        iwsMaitosikaiyakuhr7x17 = pIwsMaitosikaiyakuhr7x17;
    }

    @Column(order = 501, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x18;

    public BizNumber getIwsMaitosikaiyakuhr7x18() {
        return iwsMaitosikaiyakuhr7x18;
    }

    public void setIwsMaitosikaiyakuhr7x18(BizNumber pIwsMaitosikaiyakuhr7x18) {
        iwsMaitosikaiyakuhr7x18 = pIwsMaitosikaiyakuhr7x18;
    }

    @Column(order = 502, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x19;

    public BizNumber getIwsMaitosikaiyakuhr7x19() {
        return iwsMaitosikaiyakuhr7x19;
    }

    public void setIwsMaitosikaiyakuhr7x19(BizNumber pIwsMaitosikaiyakuhr7x19) {
        iwsMaitosikaiyakuhr7x19 = pIwsMaitosikaiyakuhr7x19;
    }

    @Column(order = 503, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7x20;

    public BizNumber getIwsMaitosikaiyakuhr7x20() {
        return iwsMaitosikaiyakuhr7x20;
    }

    public void setIwsMaitosikaiyakuhr7x20(BizNumber pIwsMaitosikaiyakuhr7x20) {
        iwsMaitosikaiyakuhr7x20 = pIwsMaitosikaiyakuhr7x20;
    }

    @Column(order = 504, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x1;

    public BizNumber getIwsMaitosikaiyakuhr8x1() {
        return iwsMaitosikaiyakuhr8x1;
    }

    public void setIwsMaitosikaiyakuhr8x1(BizNumber pIwsMaitosikaiyakuhr8x1) {
        iwsMaitosikaiyakuhr8x1 = pIwsMaitosikaiyakuhr8x1;
    }

    @Column(order = 505, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x2;

    public BizNumber getIwsMaitosikaiyakuhr8x2() {
        return iwsMaitosikaiyakuhr8x2;
    }

    public void setIwsMaitosikaiyakuhr8x2(BizNumber pIwsMaitosikaiyakuhr8x2) {
        iwsMaitosikaiyakuhr8x2 = pIwsMaitosikaiyakuhr8x2;
    }

    @Column(order = 506, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x3;

    public BizNumber getIwsMaitosikaiyakuhr8x3() {
        return iwsMaitosikaiyakuhr8x3;
    }

    public void setIwsMaitosikaiyakuhr8x3(BizNumber pIwsMaitosikaiyakuhr8x3) {
        iwsMaitosikaiyakuhr8x3 = pIwsMaitosikaiyakuhr8x3;
    }

    @Column(order = 507, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x4;

    public BizNumber getIwsMaitosikaiyakuhr8x4() {
        return iwsMaitosikaiyakuhr8x4;
    }

    public void setIwsMaitosikaiyakuhr8x4(BizNumber pIwsMaitosikaiyakuhr8x4) {
        iwsMaitosikaiyakuhr8x4 = pIwsMaitosikaiyakuhr8x4;
    }

    @Column(order = 508, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x5;

    public BizNumber getIwsMaitosikaiyakuhr8x5() {
        return iwsMaitosikaiyakuhr8x5;
    }

    public void setIwsMaitosikaiyakuhr8x5(BizNumber pIwsMaitosikaiyakuhr8x5) {
        iwsMaitosikaiyakuhr8x5 = pIwsMaitosikaiyakuhr8x5;
    }

    @Column(order = 509, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x6;

    public BizNumber getIwsMaitosikaiyakuhr8x6() {
        return iwsMaitosikaiyakuhr8x6;
    }

    public void setIwsMaitosikaiyakuhr8x6(BizNumber pIwsMaitosikaiyakuhr8x6) {
        iwsMaitosikaiyakuhr8x6 = pIwsMaitosikaiyakuhr8x6;
    }

    @Column(order = 510, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x7;

    public BizNumber getIwsMaitosikaiyakuhr8x7() {
        return iwsMaitosikaiyakuhr8x7;
    }

    public void setIwsMaitosikaiyakuhr8x7(BizNumber pIwsMaitosikaiyakuhr8x7) {
        iwsMaitosikaiyakuhr8x7 = pIwsMaitosikaiyakuhr8x7;
    }

    @Column(order = 511, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x8;

    public BizNumber getIwsMaitosikaiyakuhr8x8() {
        return iwsMaitosikaiyakuhr8x8;
    }

    public void setIwsMaitosikaiyakuhr8x8(BizNumber pIwsMaitosikaiyakuhr8x8) {
        iwsMaitosikaiyakuhr8x8 = pIwsMaitosikaiyakuhr8x8;
    }

    @Column(order = 512, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x9;

    public BizNumber getIwsMaitosikaiyakuhr8x9() {
        return iwsMaitosikaiyakuhr8x9;
    }

    public void setIwsMaitosikaiyakuhr8x9(BizNumber pIwsMaitosikaiyakuhr8x9) {
        iwsMaitosikaiyakuhr8x9 = pIwsMaitosikaiyakuhr8x9;
    }

    @Column(order = 513, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x10;

    public BizNumber getIwsMaitosikaiyakuhr8x10() {
        return iwsMaitosikaiyakuhr8x10;
    }

    public void setIwsMaitosikaiyakuhr8x10(BizNumber pIwsMaitosikaiyakuhr8x10) {
        iwsMaitosikaiyakuhr8x10 = pIwsMaitosikaiyakuhr8x10;
    }

    @Column(order = 514, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x11;

    public BizNumber getIwsMaitosikaiyakuhr8x11() {
        return iwsMaitosikaiyakuhr8x11;
    }

    public void setIwsMaitosikaiyakuhr8x11(BizNumber pIwsMaitosikaiyakuhr8x11) {
        iwsMaitosikaiyakuhr8x11 = pIwsMaitosikaiyakuhr8x11;
    }

    @Column(order = 515, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x12;

    public BizNumber getIwsMaitosikaiyakuhr8x12() {
        return iwsMaitosikaiyakuhr8x12;
    }

    public void setIwsMaitosikaiyakuhr8x12(BizNumber pIwsMaitosikaiyakuhr8x12) {
        iwsMaitosikaiyakuhr8x12 = pIwsMaitosikaiyakuhr8x12;
    }

    @Column(order = 516, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x13;

    public BizNumber getIwsMaitosikaiyakuhr8x13() {
        return iwsMaitosikaiyakuhr8x13;
    }

    public void setIwsMaitosikaiyakuhr8x13(BizNumber pIwsMaitosikaiyakuhr8x13) {
        iwsMaitosikaiyakuhr8x13 = pIwsMaitosikaiyakuhr8x13;
    }

    @Column(order = 517, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x14;

    public BizNumber getIwsMaitosikaiyakuhr8x14() {
        return iwsMaitosikaiyakuhr8x14;
    }

    public void setIwsMaitosikaiyakuhr8x14(BizNumber pIwsMaitosikaiyakuhr8x14) {
        iwsMaitosikaiyakuhr8x14 = pIwsMaitosikaiyakuhr8x14;
    }

    @Column(order = 518, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x15;

    public BizNumber getIwsMaitosikaiyakuhr8x15() {
        return iwsMaitosikaiyakuhr8x15;
    }

    public void setIwsMaitosikaiyakuhr8x15(BizNumber pIwsMaitosikaiyakuhr8x15) {
        iwsMaitosikaiyakuhr8x15 = pIwsMaitosikaiyakuhr8x15;
    }

    @Column(order = 519, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x16;

    public BizNumber getIwsMaitosikaiyakuhr8x16() {
        return iwsMaitosikaiyakuhr8x16;
    }

    public void setIwsMaitosikaiyakuhr8x16(BizNumber pIwsMaitosikaiyakuhr8x16) {
        iwsMaitosikaiyakuhr8x16 = pIwsMaitosikaiyakuhr8x16;
    }

    @Column(order = 520, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x17;

    public BizNumber getIwsMaitosikaiyakuhr8x17() {
        return iwsMaitosikaiyakuhr8x17;
    }

    public void setIwsMaitosikaiyakuhr8x17(BizNumber pIwsMaitosikaiyakuhr8x17) {
        iwsMaitosikaiyakuhr8x17 = pIwsMaitosikaiyakuhr8x17;
    }

    @Column(order = 521, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x18;

    public BizNumber getIwsMaitosikaiyakuhr8x18() {
        return iwsMaitosikaiyakuhr8x18;
    }

    public void setIwsMaitosikaiyakuhr8x18(BizNumber pIwsMaitosikaiyakuhr8x18) {
        iwsMaitosikaiyakuhr8x18 = pIwsMaitosikaiyakuhr8x18;
    }

    @Column(order = 522, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x19;

    public BizNumber getIwsMaitosikaiyakuhr8x19() {
        return iwsMaitosikaiyakuhr8x19;
    }

    public void setIwsMaitosikaiyakuhr8x19(BizNumber pIwsMaitosikaiyakuhr8x19) {
        iwsMaitosikaiyakuhr8x19 = pIwsMaitosikaiyakuhr8x19;
    }

    @Column(order = 523, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8x20;

    public BizNumber getIwsMaitosikaiyakuhr8x20() {
        return iwsMaitosikaiyakuhr8x20;
    }

    public void setIwsMaitosikaiyakuhr8x20(BizNumber pIwsMaitosikaiyakuhr8x20) {
        iwsMaitosikaiyakuhr8x20 = pIwsMaitosikaiyakuhr8x20;
    }

    @Column(order = 524, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x1;

    public BizNumber getIwsMaitosikaiyakuhr9x1() {
        return iwsMaitosikaiyakuhr9x1;
    }

    public void setIwsMaitosikaiyakuhr9x1(BizNumber pIwsMaitosikaiyakuhr9x1) {
        iwsMaitosikaiyakuhr9x1 = pIwsMaitosikaiyakuhr9x1;
    }

    @Column(order = 525, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x2;

    public BizNumber getIwsMaitosikaiyakuhr9x2() {
        return iwsMaitosikaiyakuhr9x2;
    }

    public void setIwsMaitosikaiyakuhr9x2(BizNumber pIwsMaitosikaiyakuhr9x2) {
        iwsMaitosikaiyakuhr9x2 = pIwsMaitosikaiyakuhr9x2;
    }

    @Column(order = 526, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x3;

    public BizNumber getIwsMaitosikaiyakuhr9x3() {
        return iwsMaitosikaiyakuhr9x3;
    }

    public void setIwsMaitosikaiyakuhr9x3(BizNumber pIwsMaitosikaiyakuhr9x3) {
        iwsMaitosikaiyakuhr9x3 = pIwsMaitosikaiyakuhr9x3;
    }

    @Column(order = 527, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x4;

    public BizNumber getIwsMaitosikaiyakuhr9x4() {
        return iwsMaitosikaiyakuhr9x4;
    }

    public void setIwsMaitosikaiyakuhr9x4(BizNumber pIwsMaitosikaiyakuhr9x4) {
        iwsMaitosikaiyakuhr9x4 = pIwsMaitosikaiyakuhr9x4;
    }

    @Column(order = 528, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x5;

    public BizNumber getIwsMaitosikaiyakuhr9x5() {
        return iwsMaitosikaiyakuhr9x5;
    }

    public void setIwsMaitosikaiyakuhr9x5(BizNumber pIwsMaitosikaiyakuhr9x5) {
        iwsMaitosikaiyakuhr9x5 = pIwsMaitosikaiyakuhr9x5;
    }

    @Column(order = 529, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x6;

    public BizNumber getIwsMaitosikaiyakuhr9x6() {
        return iwsMaitosikaiyakuhr9x6;
    }

    public void setIwsMaitosikaiyakuhr9x6(BizNumber pIwsMaitosikaiyakuhr9x6) {
        iwsMaitosikaiyakuhr9x6 = pIwsMaitosikaiyakuhr9x6;
    }

    @Column(order = 530, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x7;

    public BizNumber getIwsMaitosikaiyakuhr9x7() {
        return iwsMaitosikaiyakuhr9x7;
    }

    public void setIwsMaitosikaiyakuhr9x7(BizNumber pIwsMaitosikaiyakuhr9x7) {
        iwsMaitosikaiyakuhr9x7 = pIwsMaitosikaiyakuhr9x7;
    }

    @Column(order = 531, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x8;

    public BizNumber getIwsMaitosikaiyakuhr9x8() {
        return iwsMaitosikaiyakuhr9x8;
    }

    public void setIwsMaitosikaiyakuhr9x8(BizNumber pIwsMaitosikaiyakuhr9x8) {
        iwsMaitosikaiyakuhr9x8 = pIwsMaitosikaiyakuhr9x8;
    }

    @Column(order = 532, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x9;

    public BizNumber getIwsMaitosikaiyakuhr9x9() {
        return iwsMaitosikaiyakuhr9x9;
    }

    public void setIwsMaitosikaiyakuhr9x9(BizNumber pIwsMaitosikaiyakuhr9x9) {
        iwsMaitosikaiyakuhr9x9 = pIwsMaitosikaiyakuhr9x9;
    }

    @Column(order = 533, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x10;

    public BizNumber getIwsMaitosikaiyakuhr9x10() {
        return iwsMaitosikaiyakuhr9x10;
    }

    public void setIwsMaitosikaiyakuhr9x10(BizNumber pIwsMaitosikaiyakuhr9x10) {
        iwsMaitosikaiyakuhr9x10 = pIwsMaitosikaiyakuhr9x10;
    }

    @Column(order = 534, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x11;

    public BizNumber getIwsMaitosikaiyakuhr9x11() {
        return iwsMaitosikaiyakuhr9x11;
    }

    public void setIwsMaitosikaiyakuhr9x11(BizNumber pIwsMaitosikaiyakuhr9x11) {
        iwsMaitosikaiyakuhr9x11 = pIwsMaitosikaiyakuhr9x11;
    }

    @Column(order = 535, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x12;

    public BizNumber getIwsMaitosikaiyakuhr9x12() {
        return iwsMaitosikaiyakuhr9x12;
    }

    public void setIwsMaitosikaiyakuhr9x12(BizNumber pIwsMaitosikaiyakuhr9x12) {
        iwsMaitosikaiyakuhr9x12 = pIwsMaitosikaiyakuhr9x12;
    }

    @Column(order = 536, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x13;

    public BizNumber getIwsMaitosikaiyakuhr9x13() {
        return iwsMaitosikaiyakuhr9x13;
    }

    public void setIwsMaitosikaiyakuhr9x13(BizNumber pIwsMaitosikaiyakuhr9x13) {
        iwsMaitosikaiyakuhr9x13 = pIwsMaitosikaiyakuhr9x13;
    }

    @Column(order = 537, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x14;

    public BizNumber getIwsMaitosikaiyakuhr9x14() {
        return iwsMaitosikaiyakuhr9x14;
    }

    public void setIwsMaitosikaiyakuhr9x14(BizNumber pIwsMaitosikaiyakuhr9x14) {
        iwsMaitosikaiyakuhr9x14 = pIwsMaitosikaiyakuhr9x14;
    }

    @Column(order = 538, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x15;

    public BizNumber getIwsMaitosikaiyakuhr9x15() {
        return iwsMaitosikaiyakuhr9x15;
    }

    public void setIwsMaitosikaiyakuhr9x15(BizNumber pIwsMaitosikaiyakuhr9x15) {
        iwsMaitosikaiyakuhr9x15 = pIwsMaitosikaiyakuhr9x15;
    }

    @Column(order = 539, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x16;

    public BizNumber getIwsMaitosikaiyakuhr9x16() {
        return iwsMaitosikaiyakuhr9x16;
    }

    public void setIwsMaitosikaiyakuhr9x16(BizNumber pIwsMaitosikaiyakuhr9x16) {
        iwsMaitosikaiyakuhr9x16 = pIwsMaitosikaiyakuhr9x16;
    }

    @Column(order = 540, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x17;

    public BizNumber getIwsMaitosikaiyakuhr9x17() {
        return iwsMaitosikaiyakuhr9x17;
    }

    public void setIwsMaitosikaiyakuhr9x17(BizNumber pIwsMaitosikaiyakuhr9x17) {
        iwsMaitosikaiyakuhr9x17 = pIwsMaitosikaiyakuhr9x17;
    }

    @Column(order = 541, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x18;

    public BizNumber getIwsMaitosikaiyakuhr9x18() {
        return iwsMaitosikaiyakuhr9x18;
    }

    public void setIwsMaitosikaiyakuhr9x18(BizNumber pIwsMaitosikaiyakuhr9x18) {
        iwsMaitosikaiyakuhr9x18 = pIwsMaitosikaiyakuhr9x18;
    }

    @Column(order = 542, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x19;

    public BizNumber getIwsMaitosikaiyakuhr9x19() {
        return iwsMaitosikaiyakuhr9x19;
    }

    public void setIwsMaitosikaiyakuhr9x19(BizNumber pIwsMaitosikaiyakuhr9x19) {
        iwsMaitosikaiyakuhr9x19 = pIwsMaitosikaiyakuhr9x19;
    }

    @Column(order = 543, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9x20;

    public BizNumber getIwsMaitosikaiyakuhr9x20() {
        return iwsMaitosikaiyakuhr9x20;
    }

    public void setIwsMaitosikaiyakuhr9x20(BizNumber pIwsMaitosikaiyakuhr9x20) {
        iwsMaitosikaiyakuhr9x20 = pIwsMaitosikaiyakuhr9x20;
    }

    @Column(order = 544, length = 13)
    private BizNumber iwsNkgns1;

    public BizNumber getIwsNkgns1() {
        return iwsNkgns1;
    }

    public void setIwsNkgns1(BizNumber pIwsNkgns1) {
        iwsNkgns1 = pIwsNkgns1;
    }

    @Column(order = 545, length = 13)
    private BizNumber iwsNkgns2;

    public BizNumber getIwsNkgns2() {
        return iwsNkgns2;
    }

    public void setIwsNkgns2(BizNumber pIwsNkgns2) {
        iwsNkgns2 = pIwsNkgns2;
    }

    @Column(order = 546, length = 13)
    private BizNumber iwsNkgns3;

    public BizNumber getIwsNkgns3() {
        return iwsNkgns3;
    }

    public void setIwsNkgns3(BizNumber pIwsNkgns3) {
        iwsNkgns3 = pIwsNkgns3;
    }

    @Column(order = 547, length = 13)
    private BizNumber iwsNkgns4;

    public BizNumber getIwsNkgns4() {
        return iwsNkgns4;
    }

    public void setIwsNkgns4(BizNumber pIwsNkgns4) {
        iwsNkgns4 = pIwsNkgns4;
    }

    @Column(order = 548, length = 13)
    private BizNumber iwsNknengk1;

    public BizNumber getIwsNknengk1() {
        return iwsNknengk1;
    }

    public void setIwsNknengk1(BizNumber pIwsNknengk1) {
        iwsNknengk1 = pIwsNknengk1;
    }

    @Column(order = 549, length = 13)
    private BizNumber iwsNknengk2;

    public BizNumber getIwsNknengk2() {
        return iwsNknengk2;
    }

    public void setIwsNknengk2(BizNumber pIwsNknengk2) {
        iwsNknengk2 = pIwsNknengk2;
    }

    @Column(order = 550, length = 13)
    private BizNumber iwsNknengk3;

    public BizNumber getIwsNknengk3() {
        return iwsNknengk3;
    }

    public void setIwsNknengk3(BizNumber pIwsNknengk3) {
        iwsNknengk3 = pIwsNknengk3;
    }

    @Column(order = 551, length = 13)
    private BizNumber iwsNknengk4;

    public BizNumber getIwsNknengk4() {
        return iwsNknengk4;
    }

    public void setIwsNknengk4(BizNumber pIwsNknengk4) {
        iwsNknengk4 = pIwsNknengk4;
    }

    @Column(order = 552, length = 13)
    private BizNumber iwsNkuktsgk1;

    public BizNumber getIwsNkuktsgk1() {
        return iwsNkuktsgk1;
    }

    public void setIwsNkuktsgk1(BizNumber pIwsNkuktsgk1) {
        iwsNkuktsgk1 = pIwsNkuktsgk1;
    }

    @Column(order = 553, length = 13)
    private BizNumber iwsNkuktsgk2;

    public BizNumber getIwsNkuktsgk2() {
        return iwsNkuktsgk2;
    }

    public void setIwsNkuktsgk2(BizNumber pIwsNkuktsgk2) {
        iwsNkuktsgk2 = pIwsNkuktsgk2;
    }

    @Column(order = 554, length = 13)
    private BizNumber iwsNkuktsgk3;

    public BizNumber getIwsNkuktsgk3() {
        return iwsNkuktsgk3;
    }

    public void setIwsNkuktsgk3(BizNumber pIwsNkuktsgk3) {
        iwsNkuktsgk3 = pIwsNkuktsgk3;
    }

    @Column(order = 555, length = 13)
    private BizNumber iwsNkuktsgk4;

    public BizNumber getIwsNkuktsgk4() {
        return iwsNkuktsgk4;
    }

    public void setIwsNkuktsgk4(BizNumber pIwsNkuktsgk4) {
        iwsNkuktsgk4 = pIwsNkuktsgk4;
    }

    @Column(order = 556, length = 1)
    private C_HugouKbn iwsKykjsjkkktyusirrtfgukbn1;

    public C_HugouKbn getIwsKykjsjkkktyusirrtfgukbn1() {
        return iwsKykjsjkkktyusirrtfgukbn1;
    }

    public void setIwsKykjsjkkktyusirrtfgukbn1(C_HugouKbn pIwsKykjsjkkktyusirrtfgukbn1) {
        iwsKykjsjkkktyusirrtfgukbn1 = pIwsKykjsjkkktyusirrtfgukbn1;
    }

    @Column(order = 557, length = 4)
    private BizNumber iwsKykjsjkkktyusirrt1;

    public BizNumber getIwsKykjsjkkktyusirrt1() {
        return iwsKykjsjkkktyusirrt1;
    }

    public void setIwsKykjsjkkktyusirrt1(BizNumber pIwsKykjsjkkktyusirrt1) {
        iwsKykjsjkkktyusirrt1 = pIwsKykjsjkkktyusirrt1;
    }

    @Column(order = 558, length = 1)
    private C_HugouKbn iwsKykjsjkkktyusirrtfgukbn2;

    public C_HugouKbn getIwsKykjsjkkktyusirrtfgukbn2() {
        return iwsKykjsjkkktyusirrtfgukbn2;
    }

    public void setIwsKykjsjkkktyusirrtfgukbn2(C_HugouKbn pIwsKykjsjkkktyusirrtfgukbn2) {
        iwsKykjsjkkktyusirrtfgukbn2 = pIwsKykjsjkkktyusirrtfgukbn2;
    }

    @Column(order = 559, length = 4)
    private BizNumber iwsKykjsjkkktyusirrt2;

    public BizNumber getIwsKykjsjkkktyusirrt2() {
        return iwsKykjsjkkktyusirrt2;
    }

    public void setIwsKykjsjkkktyusirrt2(BizNumber pIwsKykjsjkkktyusirrt2) {
        iwsKykjsjkkktyusirrt2 = pIwsKykjsjkkktyusirrt2;
    }

    @Column(order = 560, length = 1)
    private C_HugouKbn iwsKykjsjkkktyusirrtfgukbn3;

    public C_HugouKbn getIwsKykjsjkkktyusirrtfgukbn3() {
        return iwsKykjsjkkktyusirrtfgukbn3;
    }

    public void setIwsKykjsjkkktyusirrtfgukbn3(C_HugouKbn pIwsKykjsjkkktyusirrtfgukbn3) {
        iwsKykjsjkkktyusirrtfgukbn3 = pIwsKykjsjkkktyusirrtfgukbn3;
    }

    @Column(order = 561, length = 4)
    private BizNumber iwsKykjsjkkktyusirrt3;

    public BizNumber getIwsKykjsjkkktyusirrt3() {
        return iwsKykjsjkkktyusirrt3;
    }

    public void setIwsKykjsjkkktyusirrt3(BizNumber pIwsKykjsjkkktyusirrt3) {
        iwsKykjsjkkktyusirrt3 = pIwsKykjsjkkktyusirrt3;
    }

    @Column(order = 562, length = 2)
    private String iwsNenkinsiharaikikan1;

    public String getIwsNenkinsiharaikikan1() {
        return iwsNenkinsiharaikikan1;
    }

    public void setIwsNenkinsiharaikikan1(String pIwsNenkinsiharaikikan1) {
        iwsNenkinsiharaikikan1 = pIwsNenkinsiharaikikan1;
    }

    @Column(order = 563, length = 2)
    private String iwsNenkinsiharaikikan2;

    public String getIwsNenkinsiharaikikan2() {
        return iwsNenkinsiharaikikan2;
    }

    public void setIwsNenkinsiharaikikan2(String pIwsNenkinsiharaikikan2) {
        iwsNenkinsiharaikikan2 = pIwsNenkinsiharaikikan2;
    }

    @Column(order = 564, length = 2)
    private String iwsNenkinsiharaikikan3;

    public String getIwsNenkinsiharaikikan3() {
        return iwsNenkinsiharaikikan3;
    }

    public void setIwsNenkinsiharaikikan3(String pIwsNenkinsiharaikikan3) {
        iwsNenkinsiharaikikan3 = pIwsNenkinsiharaikikan3;
    }

    @Column(order = 565, length = 2)
    private String iwsNenkinsiharaikikan4;

    public String getIwsNenkinsiharaikikan4() {
        return iwsNenkinsiharaikikan4;
    }

    public void setIwsNenkinsiharaikikan4(String pIwsNenkinsiharaikikan4) {
        iwsNenkinsiharaikikan4 = pIwsNenkinsiharaikikan4;
    }

    @Column(order = 566, length = 5)
    private BizNumber iwsKaiyakukoujyoritu1;

    public BizNumber getIwsKaiyakukoujyoritu1() {
        return iwsKaiyakukoujyoritu1;
    }

    public void setIwsKaiyakukoujyoritu1(BizNumber pIwsKaiyakukoujyoritu1) {
        iwsKaiyakukoujyoritu1 = pIwsKaiyakukoujyoritu1;
    }

    @Column(order = 567, length = 5)
    private BizNumber iwsKaiyakukoujyoritu2;

    public BizNumber getIwsKaiyakukoujyoritu2() {
        return iwsKaiyakukoujyoritu2;
    }

    public void setIwsKaiyakukoujyoritu2(BizNumber pIwsKaiyakukoujyoritu2) {
        iwsKaiyakukoujyoritu2 = pIwsKaiyakukoujyoritu2;
    }

    @Column(order = 568, length = 5)
    private BizNumber iwsKaiyakukoujyoritu3;

    public BizNumber getIwsKaiyakukoujyoritu3() {
        return iwsKaiyakukoujyoritu3;
    }

    public void setIwsKaiyakukoujyoritu3(BizNumber pIwsKaiyakukoujyoritu3) {
        iwsKaiyakukoujyoritu3 = pIwsKaiyakukoujyoritu3;
    }

    @Column(order = 569, length = 5)
    private BizNumber iwsKaiyakukoujyoritu4;

    public BizNumber getIwsKaiyakukoujyoritu4() {
        return iwsKaiyakukoujyoritu4;
    }

    public void setIwsKaiyakukoujyoritu4(BizNumber pIwsKaiyakukoujyoritu4) {
        iwsKaiyakukoujyoritu4 = pIwsKaiyakukoujyoritu4;
    }

    @Column(order = 570, length = 5)
    private BizNumber iwsKaiyakukoujyoritu5;

    public BizNumber getIwsKaiyakukoujyoritu5() {
        return iwsKaiyakukoujyoritu5;
    }

    public void setIwsKaiyakukoujyoritu5(BizNumber pIwsKaiyakukoujyoritu5) {
        iwsKaiyakukoujyoritu5 = pIwsKaiyakukoujyoritu5;
    }

    @Column(order = 571, length = 5)
    private BizNumber iwsKaiyakukoujyoritu6;

    public BizNumber getIwsKaiyakukoujyoritu6() {
        return iwsKaiyakukoujyoritu6;
    }

    public void setIwsKaiyakukoujyoritu6(BizNumber pIwsKaiyakukoujyoritu6) {
        iwsKaiyakukoujyoritu6 = pIwsKaiyakukoujyoritu6;
    }

    @Column(order = 572, length = 5)
    private BizNumber iwsKaiyakukoujyoritu7;

    public BizNumber getIwsKaiyakukoujyoritu7() {
        return iwsKaiyakukoujyoritu7;
    }

    public void setIwsKaiyakukoujyoritu7(BizNumber pIwsKaiyakukoujyoritu7) {
        iwsKaiyakukoujyoritu7 = pIwsKaiyakukoujyoritu7;
    }

    @Column(order = 573, length = 5)
    private BizNumber iwsKaiyakukoujyoritu8;

    public BizNumber getIwsKaiyakukoujyoritu8() {
        return iwsKaiyakukoujyoritu8;
    }

    public void setIwsKaiyakukoujyoritu8(BizNumber pIwsKaiyakukoujyoritu8) {
        iwsKaiyakukoujyoritu8 = pIwsKaiyakukoujyoritu8;
    }

    @Column(order = 574, length = 5)
    private BizNumber iwsKaiyakukoujyoritu9;

    public BizNumber getIwsKaiyakukoujyoritu9() {
        return iwsKaiyakukoujyoritu9;
    }

    public void setIwsKaiyakukoujyoritu9(BizNumber pIwsKaiyakukoujyoritu9) {
        iwsKaiyakukoujyoritu9 = pIwsKaiyakukoujyoritu9;
    }

    @Column(order = 575, length = 5)
    private BizNumber iwsKaiyakukoujyoritu10;

    public BizNumber getIwsKaiyakukoujyoritu10() {
        return iwsKaiyakukoujyoritu10;
    }

    public void setIwsKaiyakukoujyoritu10(BizNumber pIwsKaiyakukoujyoritu10) {
        iwsKaiyakukoujyoritu10 = pIwsKaiyakukoujyoritu10;
    }

    @Column(order = 576, length = 13)
    private BizNumber iwsKaiyakukjgk1;

    public BizNumber getIwsKaiyakukjgk1() {
        return iwsKaiyakukjgk1;
    }

    public void setIwsKaiyakukjgk1(BizNumber pIwsKaiyakukjgk1) {
        iwsKaiyakukjgk1 = pIwsKaiyakukjgk1;
    }

    @Column(order = 577, length = 13)
    private BizNumber iwsKaiyakukjgk2;

    public BizNumber getIwsKaiyakukjgk2() {
        return iwsKaiyakukjgk2;
    }

    public void setIwsKaiyakukjgk2(BizNumber pIwsKaiyakukjgk2) {
        iwsKaiyakukjgk2 = pIwsKaiyakukjgk2;
    }

    @Column(order = 578, length = 13)
    private BizNumber iwsKaiyakukjgk3;

    public BizNumber getIwsKaiyakukjgk3() {
        return iwsKaiyakukjgk3;
    }

    public void setIwsKaiyakukjgk3(BizNumber pIwsKaiyakukjgk3) {
        iwsKaiyakukjgk3 = pIwsKaiyakukjgk3;
    }

    @Column(order = 579, length = 13)
    private BizNumber iwsKaiyakukjgk4;

    public BizNumber getIwsKaiyakukjgk4() {
        return iwsKaiyakukjgk4;
    }

    public void setIwsKaiyakukjgk4(BizNumber pIwsKaiyakukjgk4) {
        iwsKaiyakukjgk4 = pIwsKaiyakukjgk4;
    }

    @Column(order = 580, length = 13)
    private BizNumber iwsKaiyakukjgk5;

    public BizNumber getIwsKaiyakukjgk5() {
        return iwsKaiyakukjgk5;
    }

    public void setIwsKaiyakukjgk5(BizNumber pIwsKaiyakukjgk5) {
        iwsKaiyakukjgk5 = pIwsKaiyakukjgk5;
    }

    @Column(order = 581, length = 13)
    private BizNumber iwsKaiyakukjgk6;

    public BizNumber getIwsKaiyakukjgk6() {
        return iwsKaiyakukjgk6;
    }

    public void setIwsKaiyakukjgk6(BizNumber pIwsKaiyakukjgk6) {
        iwsKaiyakukjgk6 = pIwsKaiyakukjgk6;
    }

    @Column(order = 582, length = 13)
    private BizNumber iwsKaiyakukjgk7;

    public BizNumber getIwsKaiyakukjgk7() {
        return iwsKaiyakukjgk7;
    }

    public void setIwsKaiyakukjgk7(BizNumber pIwsKaiyakukjgk7) {
        iwsKaiyakukjgk7 = pIwsKaiyakukjgk7;
    }

    @Column(order = 583, length = 13)
    private BizNumber iwsKaiyakukjgk8;

    public BizNumber getIwsKaiyakukjgk8() {
        return iwsKaiyakukjgk8;
    }

    public void setIwsKaiyakukjgk8(BizNumber pIwsKaiyakukjgk8) {
        iwsKaiyakukjgk8 = pIwsKaiyakukjgk8;
    }

    @Column(order = 584, length = 13)
    private BizNumber iwsKaiyakukjgk9;

    public BizNumber getIwsKaiyakukjgk9() {
        return iwsKaiyakukjgk9;
    }

    public void setIwsKaiyakukjgk9(BizNumber pIwsKaiyakukjgk9) {
        iwsKaiyakukjgk9 = pIwsKaiyakukjgk9;
    }

    @Column(order = 585, length = 13)
    private BizNumber iwsKaiyakukjgk10;

    public BizNumber getIwsKaiyakukjgk10() {
        return iwsKaiyakukjgk10;
    }

    public void setIwsKaiyakukjgk10(BizNumber pIwsKaiyakukjgk10) {
        iwsKaiyakukjgk10 = pIwsKaiyakukjgk10;
    }

    @Column(order = 586, length = 460)
    private String iwsYobiv460;

    public String getIwsYobiv460() {
        return iwsYobiv460;
    }

    public void setIwsYobiv460(String pIwsYobiv460) {
        iwsYobiv460 = pIwsYobiv460;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
