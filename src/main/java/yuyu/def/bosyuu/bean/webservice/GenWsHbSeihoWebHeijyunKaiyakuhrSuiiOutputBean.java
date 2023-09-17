package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保険募集）生保Ｗｅｂ平準払終身用解約返戻金推移表作成出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean() {
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
    private BizNumber iwsMaitosiphrkrkgk1;

    public BizNumber getIwsMaitosiphrkrkgk1() {
        return iwsMaitosiphrkrkgk1;
    }

    public void setIwsMaitosiphrkrkgk1(BizNumber pIwsMaitosiphrkrkgk1) {
        iwsMaitosiphrkrkgk1 = pIwsMaitosiphrkrkgk1;
    }

    @Column(order = 5, length = 13)
    private BizNumber iwsMaitosiphrkrkgk2;

    public BizNumber getIwsMaitosiphrkrkgk2() {
        return iwsMaitosiphrkrkgk2;
    }

    public void setIwsMaitosiphrkrkgk2(BizNumber pIwsMaitosiphrkrkgk2) {
        iwsMaitosiphrkrkgk2 = pIwsMaitosiphrkrkgk2;
    }

    @Column(order = 6, length = 13)
    private BizNumber iwsMaitosiphrkrkgk3;

    public BizNumber getIwsMaitosiphrkrkgk3() {
        return iwsMaitosiphrkrkgk3;
    }

    public void setIwsMaitosiphrkrkgk3(BizNumber pIwsMaitosiphrkrkgk3) {
        iwsMaitosiphrkrkgk3 = pIwsMaitosiphrkrkgk3;
    }

    @Column(order = 7, length = 13)
    private BizNumber iwsMaitosiphrkrkgk4;

    public BizNumber getIwsMaitosiphrkrkgk4() {
        return iwsMaitosiphrkrkgk4;
    }

    public void setIwsMaitosiphrkrkgk4(BizNumber pIwsMaitosiphrkrkgk4) {
        iwsMaitosiphrkrkgk4 = pIwsMaitosiphrkrkgk4;
    }

    @Column(order = 8, length = 13)
    private BizNumber iwsMaitosiphrkrkgk5;

    public BizNumber getIwsMaitosiphrkrkgk5() {
        return iwsMaitosiphrkrkgk5;
    }

    public void setIwsMaitosiphrkrkgk5(BizNumber pIwsMaitosiphrkrkgk5) {
        iwsMaitosiphrkrkgk5 = pIwsMaitosiphrkrkgk5;
    }

    @Column(order = 9, length = 13)
    private BizNumber iwsMaitosiphrkrkgk6;

    public BizNumber getIwsMaitosiphrkrkgk6() {
        return iwsMaitosiphrkrkgk6;
    }

    public void setIwsMaitosiphrkrkgk6(BizNumber pIwsMaitosiphrkrkgk6) {
        iwsMaitosiphrkrkgk6 = pIwsMaitosiphrkrkgk6;
    }

    @Column(order = 10, length = 13)
    private BizNumber iwsMaitosiphrkrkgk7;

    public BizNumber getIwsMaitosiphrkrkgk7() {
        return iwsMaitosiphrkrkgk7;
    }

    public void setIwsMaitosiphrkrkgk7(BizNumber pIwsMaitosiphrkrkgk7) {
        iwsMaitosiphrkrkgk7 = pIwsMaitosiphrkrkgk7;
    }

    @Column(order = 11, length = 13)
    private BizNumber iwsMaitosiphrkrkgk8;

    public BizNumber getIwsMaitosiphrkrkgk8() {
        return iwsMaitosiphrkrkgk8;
    }

    public void setIwsMaitosiphrkrkgk8(BizNumber pIwsMaitosiphrkrkgk8) {
        iwsMaitosiphrkrkgk8 = pIwsMaitosiphrkrkgk8;
    }

    @Column(order = 12, length = 13)
    private BizNumber iwsMaitosiphrkrkgk9;

    public BizNumber getIwsMaitosiphrkrkgk9() {
        return iwsMaitosiphrkrkgk9;
    }

    public void setIwsMaitosiphrkrkgk9(BizNumber pIwsMaitosiphrkrkgk9) {
        iwsMaitosiphrkrkgk9 = pIwsMaitosiphrkrkgk9;
    }

    @Column(order = 13, length = 13)
    private BizNumber iwsMaitosiphrkrkgk10;

    public BizNumber getIwsMaitosiphrkrkgk10() {
        return iwsMaitosiphrkrkgk10;
    }

    public void setIwsMaitosiphrkrkgk10(BizNumber pIwsMaitosiphrkrkgk10) {
        iwsMaitosiphrkrkgk10 = pIwsMaitosiphrkrkgk10;
    }

    @Column(order = 14, length = 13)
    private BizNumber iwsMaitosiphrkrkgk11;

    public BizNumber getIwsMaitosiphrkrkgk11() {
        return iwsMaitosiphrkrkgk11;
    }

    public void setIwsMaitosiphrkrkgk11(BizNumber pIwsMaitosiphrkrkgk11) {
        iwsMaitosiphrkrkgk11 = pIwsMaitosiphrkrkgk11;
    }

    @Column(order = 15, length = 13)
    private BizNumber iwsMaitosiphrkrkgk12;

    public BizNumber getIwsMaitosiphrkrkgk12() {
        return iwsMaitosiphrkrkgk12;
    }

    public void setIwsMaitosiphrkrkgk12(BizNumber pIwsMaitosiphrkrkgk12) {
        iwsMaitosiphrkrkgk12 = pIwsMaitosiphrkrkgk12;
    }

    @Column(order = 16, length = 13)
    private BizNumber iwsMaitosiphrkrkgk13;

    public BizNumber getIwsMaitosiphrkrkgk13() {
        return iwsMaitosiphrkrkgk13;
    }

    public void setIwsMaitosiphrkrkgk13(BizNumber pIwsMaitosiphrkrkgk13) {
        iwsMaitosiphrkrkgk13 = pIwsMaitosiphrkrkgk13;
    }

    @Column(order = 17, length = 13)
    private BizNumber iwsMaitosiphrkrkgk14;

    public BizNumber getIwsMaitosiphrkrkgk14() {
        return iwsMaitosiphrkrkgk14;
    }

    public void setIwsMaitosiphrkrkgk14(BizNumber pIwsMaitosiphrkrkgk14) {
        iwsMaitosiphrkrkgk14 = pIwsMaitosiphrkrkgk14;
    }

    @Column(order = 18, length = 13)
    private BizNumber iwsMaitosiphrkrkgk15;

    public BizNumber getIwsMaitosiphrkrkgk15() {
        return iwsMaitosiphrkrkgk15;
    }

    public void setIwsMaitosiphrkrkgk15(BizNumber pIwsMaitosiphrkrkgk15) {
        iwsMaitosiphrkrkgk15 = pIwsMaitosiphrkrkgk15;
    }

    @Column(order = 19, length = 13)
    private BizNumber iwsMaitosiphrkrkgk16;

    public BizNumber getIwsMaitosiphrkrkgk16() {
        return iwsMaitosiphrkrkgk16;
    }

    public void setIwsMaitosiphrkrkgk16(BizNumber pIwsMaitosiphrkrkgk16) {
        iwsMaitosiphrkrkgk16 = pIwsMaitosiphrkrkgk16;
    }

    @Column(order = 20, length = 13)
    private BizNumber iwsMaitosiphrkrkgk17;

    public BizNumber getIwsMaitosiphrkrkgk17() {
        return iwsMaitosiphrkrkgk17;
    }

    public void setIwsMaitosiphrkrkgk17(BizNumber pIwsMaitosiphrkrkgk17) {
        iwsMaitosiphrkrkgk17 = pIwsMaitosiphrkrkgk17;
    }

    @Column(order = 21, length = 13)
    private BizNumber iwsMaitosiphrkrkgk18;

    public BizNumber getIwsMaitosiphrkrkgk18() {
        return iwsMaitosiphrkrkgk18;
    }

    public void setIwsMaitosiphrkrkgk18(BizNumber pIwsMaitosiphrkrkgk18) {
        iwsMaitosiphrkrkgk18 = pIwsMaitosiphrkrkgk18;
    }

    @Column(order = 22, length = 13)
    private BizNumber iwsMaitosiphrkrkgk19;

    public BizNumber getIwsMaitosiphrkrkgk19() {
        return iwsMaitosiphrkrkgk19;
    }

    public void setIwsMaitosiphrkrkgk19(BizNumber pIwsMaitosiphrkrkgk19) {
        iwsMaitosiphrkrkgk19 = pIwsMaitosiphrkrkgk19;
    }

    @Column(order = 23, length = 13)
    private BizNumber iwsMaitosiphrkrkgk20;

    public BizNumber getIwsMaitosiphrkrkgk20() {
        return iwsMaitosiphrkrkgk20;
    }

    public void setIwsMaitosiphrkrkgk20(BizNumber pIwsMaitosiphrkrkgk20) {
        iwsMaitosiphrkrkgk20 = pIwsMaitosiphrkrkgk20;
    }

    @Column(order = 24, length = 13)
    private BizNumber iwsMaitosiphrkrkgk21;

    public BizNumber getIwsMaitosiphrkrkgk21() {
        return iwsMaitosiphrkrkgk21;
    }

    public void setIwsMaitosiphrkrkgk21(BizNumber pIwsMaitosiphrkrkgk21) {
        iwsMaitosiphrkrkgk21 = pIwsMaitosiphrkrkgk21;
    }

    @Column(order = 25, length = 13)
    private BizNumber iwsMaitosiphrkrkgk22;

    public BizNumber getIwsMaitosiphrkrkgk22() {
        return iwsMaitosiphrkrkgk22;
    }

    public void setIwsMaitosiphrkrkgk22(BizNumber pIwsMaitosiphrkrkgk22) {
        iwsMaitosiphrkrkgk22 = pIwsMaitosiphrkrkgk22;
    }

    @Column(order = 26, length = 13)
    private BizNumber iwsMaitosiphrkrkgk23;

    public BizNumber getIwsMaitosiphrkrkgk23() {
        return iwsMaitosiphrkrkgk23;
    }

    public void setIwsMaitosiphrkrkgk23(BizNumber pIwsMaitosiphrkrkgk23) {
        iwsMaitosiphrkrkgk23 = pIwsMaitosiphrkrkgk23;
    }

    @Column(order = 27, length = 13)
    private BizNumber iwsMaitosiphrkrkgk24;

    public BizNumber getIwsMaitosiphrkrkgk24() {
        return iwsMaitosiphrkrkgk24;
    }

    public void setIwsMaitosiphrkrkgk24(BizNumber pIwsMaitosiphrkrkgk24) {
        iwsMaitosiphrkrkgk24 = pIwsMaitosiphrkrkgk24;
    }

    @Column(order = 28, length = 13)
    private BizNumber iwsMaitosiphrkrkgk25;

    public BizNumber getIwsMaitosiphrkrkgk25() {
        return iwsMaitosiphrkrkgk25;
    }

    public void setIwsMaitosiphrkrkgk25(BizNumber pIwsMaitosiphrkrkgk25) {
        iwsMaitosiphrkrkgk25 = pIwsMaitosiphrkrkgk25;
    }

    @Column(order = 29, length = 13)
    private BizNumber iwsMaitosiphrkrkgk26;

    public BizNumber getIwsMaitosiphrkrkgk26() {
        return iwsMaitosiphrkrkgk26;
    }

    public void setIwsMaitosiphrkrkgk26(BizNumber pIwsMaitosiphrkrkgk26) {
        iwsMaitosiphrkrkgk26 = pIwsMaitosiphrkrkgk26;
    }

    @Column(order = 30, length = 13)
    private BizNumber iwsMaitosiphrkrkgk27;

    public BizNumber getIwsMaitosiphrkrkgk27() {
        return iwsMaitosiphrkrkgk27;
    }

    public void setIwsMaitosiphrkrkgk27(BizNumber pIwsMaitosiphrkrkgk27) {
        iwsMaitosiphrkrkgk27 = pIwsMaitosiphrkrkgk27;
    }

    @Column(order = 31, length = 13)
    private BizNumber iwsMaitosiphrkrkgk28;

    public BizNumber getIwsMaitosiphrkrkgk28() {
        return iwsMaitosiphrkrkgk28;
    }

    public void setIwsMaitosiphrkrkgk28(BizNumber pIwsMaitosiphrkrkgk28) {
        iwsMaitosiphrkrkgk28 = pIwsMaitosiphrkrkgk28;
    }

    @Column(order = 32, length = 13)
    private BizNumber iwsMaitosiphrkrkgk29;

    public BizNumber getIwsMaitosiphrkrkgk29() {
        return iwsMaitosiphrkrkgk29;
    }

    public void setIwsMaitosiphrkrkgk29(BizNumber pIwsMaitosiphrkrkgk29) {
        iwsMaitosiphrkrkgk29 = pIwsMaitosiphrkrkgk29;
    }

    @Column(order = 33, length = 13)
    private BizNumber iwsMaitosiphrkrkgk30;

    public BizNumber getIwsMaitosiphrkrkgk30() {
        return iwsMaitosiphrkrkgk30;
    }

    public void setIwsMaitosiphrkrkgk30(BizNumber pIwsMaitosiphrkrkgk30) {
        iwsMaitosiphrkrkgk30 = pIwsMaitosiphrkrkgk30;
    }

    @Column(order = 34, length = 13)
    private BizNumber iwsMaitosiphrkrkgk31;

    public BizNumber getIwsMaitosiphrkrkgk31() {
        return iwsMaitosiphrkrkgk31;
    }

    public void setIwsMaitosiphrkrkgk31(BizNumber pIwsMaitosiphrkrkgk31) {
        iwsMaitosiphrkrkgk31 = pIwsMaitosiphrkrkgk31;
    }

    @Column(order = 35, length = 13)
    private BizNumber iwsMaitosiphrkrkgk32;

    public BizNumber getIwsMaitosiphrkrkgk32() {
        return iwsMaitosiphrkrkgk32;
    }

    public void setIwsMaitosiphrkrkgk32(BizNumber pIwsMaitosiphrkrkgk32) {
        iwsMaitosiphrkrkgk32 = pIwsMaitosiphrkrkgk32;
    }

    @Column(order = 36, length = 13)
    private BizNumber iwsMaitosiphrkrkgk33;

    public BizNumber getIwsMaitosiphrkrkgk33() {
        return iwsMaitosiphrkrkgk33;
    }

    public void setIwsMaitosiphrkrkgk33(BizNumber pIwsMaitosiphrkrkgk33) {
        iwsMaitosiphrkrkgk33 = pIwsMaitosiphrkrkgk33;
    }

    @Column(order = 37, length = 13)
    private BizNumber iwsMaitosiphrkrkgk34;

    public BizNumber getIwsMaitosiphrkrkgk34() {
        return iwsMaitosiphrkrkgk34;
    }

    public void setIwsMaitosiphrkrkgk34(BizNumber pIwsMaitosiphrkrkgk34) {
        iwsMaitosiphrkrkgk34 = pIwsMaitosiphrkrkgk34;
    }

    @Column(order = 38, length = 13)
    private BizNumber iwsMaitosiphrkrkgk35;

    public BizNumber getIwsMaitosiphrkrkgk35() {
        return iwsMaitosiphrkrkgk35;
    }

    public void setIwsMaitosiphrkrkgk35(BizNumber pIwsMaitosiphrkrkgk35) {
        iwsMaitosiphrkrkgk35 = pIwsMaitosiphrkrkgk35;
    }

    @Column(order = 39, length = 13)
    private BizNumber iwsMaitosiphrkrkgk36;

    public BizNumber getIwsMaitosiphrkrkgk36() {
        return iwsMaitosiphrkrkgk36;
    }

    public void setIwsMaitosiphrkrkgk36(BizNumber pIwsMaitosiphrkrkgk36) {
        iwsMaitosiphrkrkgk36 = pIwsMaitosiphrkrkgk36;
    }

    @Column(order = 40, length = 13)
    private BizNumber iwsMaitosiphrkrkgk37;

    public BizNumber getIwsMaitosiphrkrkgk37() {
        return iwsMaitosiphrkrkgk37;
    }

    public void setIwsMaitosiphrkrkgk37(BizNumber pIwsMaitosiphrkrkgk37) {
        iwsMaitosiphrkrkgk37 = pIwsMaitosiphrkrkgk37;
    }

    @Column(order = 41, length = 13)
    private BizNumber iwsMaitosiphrkrkgk38;

    public BizNumber getIwsMaitosiphrkrkgk38() {
        return iwsMaitosiphrkrkgk38;
    }

    public void setIwsMaitosiphrkrkgk38(BizNumber pIwsMaitosiphrkrkgk38) {
        iwsMaitosiphrkrkgk38 = pIwsMaitosiphrkrkgk38;
    }

    @Column(order = 42, length = 13)
    private BizNumber iwsMaitosiphrkrkgk39;

    public BizNumber getIwsMaitosiphrkrkgk39() {
        return iwsMaitosiphrkrkgk39;
    }

    public void setIwsMaitosiphrkrkgk39(BizNumber pIwsMaitosiphrkrkgk39) {
        iwsMaitosiphrkrkgk39 = pIwsMaitosiphrkrkgk39;
    }

    @Column(order = 43, length = 13)
    private BizNumber iwsMaitosiphrkrkgk40;

    public BizNumber getIwsMaitosiphrkrkgk40() {
        return iwsMaitosiphrkrkgk40;
    }

    public void setIwsMaitosiphrkrkgk40(BizNumber pIwsMaitosiphrkrkgk40) {
        iwsMaitosiphrkrkgk40 = pIwsMaitosiphrkrkgk40;
    }

    @Column(order = 44, length = 13)
    private BizNumber iwsMaitosiphrkrkgk41;

    public BizNumber getIwsMaitosiphrkrkgk41() {
        return iwsMaitosiphrkrkgk41;
    }

    public void setIwsMaitosiphrkrkgk41(BizNumber pIwsMaitosiphrkrkgk41) {
        iwsMaitosiphrkrkgk41 = pIwsMaitosiphrkrkgk41;
    }

    @Column(order = 45, length = 13)
    private BizNumber iwsMaitosiphrkrkgk42;

    public BizNumber getIwsMaitosiphrkrkgk42() {
        return iwsMaitosiphrkrkgk42;
    }

    public void setIwsMaitosiphrkrkgk42(BizNumber pIwsMaitosiphrkrkgk42) {
        iwsMaitosiphrkrkgk42 = pIwsMaitosiphrkrkgk42;
    }

    @Column(order = 46, length = 13)
    private BizNumber iwsMaitosiphrkrkgk43;

    public BizNumber getIwsMaitosiphrkrkgk43() {
        return iwsMaitosiphrkrkgk43;
    }

    public void setIwsMaitosiphrkrkgk43(BizNumber pIwsMaitosiphrkrkgk43) {
        iwsMaitosiphrkrkgk43 = pIwsMaitosiphrkrkgk43;
    }

    @Column(order = 47, length = 13)
    private BizNumber iwsMaitosiphrkrkgk44;

    public BizNumber getIwsMaitosiphrkrkgk44() {
        return iwsMaitosiphrkrkgk44;
    }

    public void setIwsMaitosiphrkrkgk44(BizNumber pIwsMaitosiphrkrkgk44) {
        iwsMaitosiphrkrkgk44 = pIwsMaitosiphrkrkgk44;
    }

    @Column(order = 48, length = 13)
    private BizNumber iwsMaitosiphrkrkgk45;

    public BizNumber getIwsMaitosiphrkrkgk45() {
        return iwsMaitosiphrkrkgk45;
    }

    public void setIwsMaitosiphrkrkgk45(BizNumber pIwsMaitosiphrkrkgk45) {
        iwsMaitosiphrkrkgk45 = pIwsMaitosiphrkrkgk45;
    }

    @Column(order = 49, length = 13)
    private BizNumber iwsMaitosiphrkrkgk46;

    public BizNumber getIwsMaitosiphrkrkgk46() {
        return iwsMaitosiphrkrkgk46;
    }

    public void setIwsMaitosiphrkrkgk46(BizNumber pIwsMaitosiphrkrkgk46) {
        iwsMaitosiphrkrkgk46 = pIwsMaitosiphrkrkgk46;
    }

    @Column(order = 50, length = 13)
    private BizNumber iwsMaitosiphrkrkgk47;

    public BizNumber getIwsMaitosiphrkrkgk47() {
        return iwsMaitosiphrkrkgk47;
    }

    public void setIwsMaitosiphrkrkgk47(BizNumber pIwsMaitosiphrkrkgk47) {
        iwsMaitosiphrkrkgk47 = pIwsMaitosiphrkrkgk47;
    }

    @Column(order = 51, length = 13)
    private BizNumber iwsMaitosiphrkrkgk48;

    public BizNumber getIwsMaitosiphrkrkgk48() {
        return iwsMaitosiphrkrkgk48;
    }

    public void setIwsMaitosiphrkrkgk48(BizNumber pIwsMaitosiphrkrkgk48) {
        iwsMaitosiphrkrkgk48 = pIwsMaitosiphrkrkgk48;
    }

    @Column(order = 52, length = 13)
    private BizNumber iwsMaitosiphrkrkgk49;

    public BizNumber getIwsMaitosiphrkrkgk49() {
        return iwsMaitosiphrkrkgk49;
    }

    public void setIwsMaitosiphrkrkgk49(BizNumber pIwsMaitosiphrkrkgk49) {
        iwsMaitosiphrkrkgk49 = pIwsMaitosiphrkrkgk49;
    }

    @Column(order = 53, length = 13)
    private BizNumber iwsMaitosiphrkrkgk50;

    public BizNumber getIwsMaitosiphrkrkgk50() {
        return iwsMaitosiphrkrkgk50;
    }

    public void setIwsMaitosiphrkrkgk50(BizNumber pIwsMaitosiphrkrkgk50) {
        iwsMaitosiphrkrkgk50 = pIwsMaitosiphrkrkgk50;
    }

    @Column(order = 54, length = 13)
    private BizNumber iwsMaitosiphrkrkgk51;

    public BizNumber getIwsMaitosiphrkrkgk51() {
        return iwsMaitosiphrkrkgk51;
    }

    public void setIwsMaitosiphrkrkgk51(BizNumber pIwsMaitosiphrkrkgk51) {
        iwsMaitosiphrkrkgk51 = pIwsMaitosiphrkrkgk51;
    }

    @Column(order = 55, length = 13)
    private BizNumber iwsMaitosiphrkrkgk52;

    public BizNumber getIwsMaitosiphrkrkgk52() {
        return iwsMaitosiphrkrkgk52;
    }

    public void setIwsMaitosiphrkrkgk52(BizNumber pIwsMaitosiphrkrkgk52) {
        iwsMaitosiphrkrkgk52 = pIwsMaitosiphrkrkgk52;
    }

    @Column(order = 56, length = 13)
    private BizNumber iwsMaitosiphrkrkgk53;

    public BizNumber getIwsMaitosiphrkrkgk53() {
        return iwsMaitosiphrkrkgk53;
    }

    public void setIwsMaitosiphrkrkgk53(BizNumber pIwsMaitosiphrkrkgk53) {
        iwsMaitosiphrkrkgk53 = pIwsMaitosiphrkrkgk53;
    }

    @Column(order = 57, length = 13)
    private BizNumber iwsMaitosiphrkrkgk54;

    public BizNumber getIwsMaitosiphrkrkgk54() {
        return iwsMaitosiphrkrkgk54;
    }

    public void setIwsMaitosiphrkrkgk54(BizNumber pIwsMaitosiphrkrkgk54) {
        iwsMaitosiphrkrkgk54 = pIwsMaitosiphrkrkgk54;
    }

    @Column(order = 58, length = 13)
    private BizNumber iwsMaitosiphrkrkgk55;

    public BizNumber getIwsMaitosiphrkrkgk55() {
        return iwsMaitosiphrkrkgk55;
    }

    public void setIwsMaitosiphrkrkgk55(BizNumber pIwsMaitosiphrkrkgk55) {
        iwsMaitosiphrkrkgk55 = pIwsMaitosiphrkrkgk55;
    }

    @Column(order = 59, length = 13)
    private BizNumber iwsMaitosiphrkrkgk56;

    public BizNumber getIwsMaitosiphrkrkgk56() {
        return iwsMaitosiphrkrkgk56;
    }

    public void setIwsMaitosiphrkrkgk56(BizNumber pIwsMaitosiphrkrkgk56) {
        iwsMaitosiphrkrkgk56 = pIwsMaitosiphrkrkgk56;
    }

    @Column(order = 60, length = 13)
    private BizNumber iwsMaitosiphrkrkgk57;

    public BizNumber getIwsMaitosiphrkrkgk57() {
        return iwsMaitosiphrkrkgk57;
    }

    public void setIwsMaitosiphrkrkgk57(BizNumber pIwsMaitosiphrkrkgk57) {
        iwsMaitosiphrkrkgk57 = pIwsMaitosiphrkrkgk57;
    }

    @Column(order = 61, length = 13)
    private BizNumber iwsMaitosiphrkrkgk58;

    public BizNumber getIwsMaitosiphrkrkgk58() {
        return iwsMaitosiphrkrkgk58;
    }

    public void setIwsMaitosiphrkrkgk58(BizNumber pIwsMaitosiphrkrkgk58) {
        iwsMaitosiphrkrkgk58 = pIwsMaitosiphrkrkgk58;
    }

    @Column(order = 62, length = 13)
    private BizNumber iwsMaitosiphrkrkgk59;

    public BizNumber getIwsMaitosiphrkrkgk59() {
        return iwsMaitosiphrkrkgk59;
    }

    public void setIwsMaitosiphrkrkgk59(BizNumber pIwsMaitosiphrkrkgk59) {
        iwsMaitosiphrkrkgk59 = pIwsMaitosiphrkrkgk59;
    }

    @Column(order = 63, length = 13)
    private BizNumber iwsMaitosiphrkrkgk60;

    public BizNumber getIwsMaitosiphrkrkgk60() {
        return iwsMaitosiphrkrkgk60;
    }

    public void setIwsMaitosiphrkrkgk60(BizNumber pIwsMaitosiphrkrkgk60) {
        iwsMaitosiphrkrkgk60 = pIwsMaitosiphrkrkgk60;
    }

    @Column(order = 64, length = 13)
    private BizNumber iwsMaitosiphrkrkgk61;

    public BizNumber getIwsMaitosiphrkrkgk61() {
        return iwsMaitosiphrkrkgk61;
    }

    public void setIwsMaitosiphrkrkgk61(BizNumber pIwsMaitosiphrkrkgk61) {
        iwsMaitosiphrkrkgk61 = pIwsMaitosiphrkrkgk61;
    }

    @Column(order = 65, length = 13)
    private BizNumber iwsMaitosiphrkrkgk62;

    public BizNumber getIwsMaitosiphrkrkgk62() {
        return iwsMaitosiphrkrkgk62;
    }

    public void setIwsMaitosiphrkrkgk62(BizNumber pIwsMaitosiphrkrkgk62) {
        iwsMaitosiphrkrkgk62 = pIwsMaitosiphrkrkgk62;
    }

    @Column(order = 66, length = 13)
    private BizNumber iwsMaitosiphrkrkgk63;

    public BizNumber getIwsMaitosiphrkrkgk63() {
        return iwsMaitosiphrkrkgk63;
    }

    public void setIwsMaitosiphrkrkgk63(BizNumber pIwsMaitosiphrkrkgk63) {
        iwsMaitosiphrkrkgk63 = pIwsMaitosiphrkrkgk63;
    }

    @Column(order = 67, length = 13)
    private BizNumber iwsMaitosiphrkrkgk64;

    public BizNumber getIwsMaitosiphrkrkgk64() {
        return iwsMaitosiphrkrkgk64;
    }

    public void setIwsMaitosiphrkrkgk64(BizNumber pIwsMaitosiphrkrkgk64) {
        iwsMaitosiphrkrkgk64 = pIwsMaitosiphrkrkgk64;
    }

    @Column(order = 68, length = 13)
    private BizNumber iwsMaitosiphrkrkgk65;

    public BizNumber getIwsMaitosiphrkrkgk65() {
        return iwsMaitosiphrkrkgk65;
    }

    public void setIwsMaitosiphrkrkgk65(BizNumber pIwsMaitosiphrkrkgk65) {
        iwsMaitosiphrkrkgk65 = pIwsMaitosiphrkrkgk65;
    }

    @Column(order = 69, length = 13)
    private BizNumber iwsMaitosiphrkrkgk66;

    public BizNumber getIwsMaitosiphrkrkgk66() {
        return iwsMaitosiphrkrkgk66;
    }

    public void setIwsMaitosiphrkrkgk66(BizNumber pIwsMaitosiphrkrkgk66) {
        iwsMaitosiphrkrkgk66 = pIwsMaitosiphrkrkgk66;
    }

    @Column(order = 70, length = 13)
    private BizNumber iwsMaitosiphrkrkgk67;

    public BizNumber getIwsMaitosiphrkrkgk67() {
        return iwsMaitosiphrkrkgk67;
    }

    public void setIwsMaitosiphrkrkgk67(BizNumber pIwsMaitosiphrkrkgk67) {
        iwsMaitosiphrkrkgk67 = pIwsMaitosiphrkrkgk67;
    }

    @Column(order = 71, length = 13)
    private BizNumber iwsMaitosiphrkrkgk68;

    public BizNumber getIwsMaitosiphrkrkgk68() {
        return iwsMaitosiphrkrkgk68;
    }

    public void setIwsMaitosiphrkrkgk68(BizNumber pIwsMaitosiphrkrkgk68) {
        iwsMaitosiphrkrkgk68 = pIwsMaitosiphrkrkgk68;
    }

    @Column(order = 72, length = 13)
    private BizNumber iwsMaitosiphrkrkgk69;

    public BizNumber getIwsMaitosiphrkrkgk69() {
        return iwsMaitosiphrkrkgk69;
    }

    public void setIwsMaitosiphrkrkgk69(BizNumber pIwsMaitosiphrkrkgk69) {
        iwsMaitosiphrkrkgk69 = pIwsMaitosiphrkrkgk69;
    }

    @Column(order = 73, length = 13)
    private BizNumber iwsMaitosiphrkrkgk70;

    public BizNumber getIwsMaitosiphrkrkgk70() {
        return iwsMaitosiphrkrkgk70;
    }

    public void setIwsMaitosiphrkrkgk70(BizNumber pIwsMaitosiphrkrkgk70) {
        iwsMaitosiphrkrkgk70 = pIwsMaitosiphrkrkgk70;
    }

    @Column(order = 74, length = 13)
    private BizNumber iwsMaitosiphrkrkgk71;

    public BizNumber getIwsMaitosiphrkrkgk71() {
        return iwsMaitosiphrkrkgk71;
    }

    public void setIwsMaitosiphrkrkgk71(BizNumber pIwsMaitosiphrkrkgk71) {
        iwsMaitosiphrkrkgk71 = pIwsMaitosiphrkrkgk71;
    }

    @Column(order = 75, length = 13)
    private BizNumber iwsMaitosiphrkrkgk72;

    public BizNumber getIwsMaitosiphrkrkgk72() {
        return iwsMaitosiphrkrkgk72;
    }

    public void setIwsMaitosiphrkrkgk72(BizNumber pIwsMaitosiphrkrkgk72) {
        iwsMaitosiphrkrkgk72 = pIwsMaitosiphrkrkgk72;
    }

    @Column(order = 76, length = 13)
    private BizNumber iwsMaitosiphrkrkgk73;

    public BizNumber getIwsMaitosiphrkrkgk73() {
        return iwsMaitosiphrkrkgk73;
    }

    public void setIwsMaitosiphrkrkgk73(BizNumber pIwsMaitosiphrkrkgk73) {
        iwsMaitosiphrkrkgk73 = pIwsMaitosiphrkrkgk73;
    }

    @Column(order = 77, length = 13)
    private BizNumber iwsMaitosiphrkrkgk74;

    public BizNumber getIwsMaitosiphrkrkgk74() {
        return iwsMaitosiphrkrkgk74;
    }

    public void setIwsMaitosiphrkrkgk74(BizNumber pIwsMaitosiphrkrkgk74) {
        iwsMaitosiphrkrkgk74 = pIwsMaitosiphrkrkgk74;
    }

    @Column(order = 78, length = 13)
    private BizNumber iwsMaitosiphrkrkgk75;

    public BizNumber getIwsMaitosiphrkrkgk75() {
        return iwsMaitosiphrkrkgk75;
    }

    public void setIwsMaitosiphrkrkgk75(BizNumber pIwsMaitosiphrkrkgk75) {
        iwsMaitosiphrkrkgk75 = pIwsMaitosiphrkrkgk75;
    }

    @Column(order = 79, length = 13)
    private BizNumber iwsMaitosiphrkrkgk76;

    public BizNumber getIwsMaitosiphrkrkgk76() {
        return iwsMaitosiphrkrkgk76;
    }

    public void setIwsMaitosiphrkrkgk76(BizNumber pIwsMaitosiphrkrkgk76) {
        iwsMaitosiphrkrkgk76 = pIwsMaitosiphrkrkgk76;
    }

    @Column(order = 80, length = 13)
    private BizNumber iwsMaitosiphrkrkgk77;

    public BizNumber getIwsMaitosiphrkrkgk77() {
        return iwsMaitosiphrkrkgk77;
    }

    public void setIwsMaitosiphrkrkgk77(BizNumber pIwsMaitosiphrkrkgk77) {
        iwsMaitosiphrkrkgk77 = pIwsMaitosiphrkrkgk77;
    }

    @Column(order = 81, length = 13)
    private BizNumber iwsMaitosiphrkrkgk78;

    public BizNumber getIwsMaitosiphrkrkgk78() {
        return iwsMaitosiphrkrkgk78;
    }

    public void setIwsMaitosiphrkrkgk78(BizNumber pIwsMaitosiphrkrkgk78) {
        iwsMaitosiphrkrkgk78 = pIwsMaitosiphrkrkgk78;
    }

    @Column(order = 82, length = 13)
    private BizNumber iwsMaitosiphrkrkgk79;

    public BizNumber getIwsMaitosiphrkrkgk79() {
        return iwsMaitosiphrkrkgk79;
    }

    public void setIwsMaitosiphrkrkgk79(BizNumber pIwsMaitosiphrkrkgk79) {
        iwsMaitosiphrkrkgk79 = pIwsMaitosiphrkrkgk79;
    }

    @Column(order = 83, length = 13)
    private BizNumber iwsMaitosiphrkrkgk80;

    public BizNumber getIwsMaitosiphrkrkgk80() {
        return iwsMaitosiphrkrkgk80;
    }

    public void setIwsMaitosiphrkrkgk80(BizNumber pIwsMaitosiphrkrkgk80) {
        iwsMaitosiphrkrkgk80 = pIwsMaitosiphrkrkgk80;
    }

    @Column(order = 84, length = 13)
    private BizNumber iwsMaitosiphrkrkgk81;

    public BizNumber getIwsMaitosiphrkrkgk81() {
        return iwsMaitosiphrkrkgk81;
    }

    public void setIwsMaitosiphrkrkgk81(BizNumber pIwsMaitosiphrkrkgk81) {
        iwsMaitosiphrkrkgk81 = pIwsMaitosiphrkrkgk81;
    }

    @Column(order = 85, length = 13)
    private BizNumber iwsMaitosiphrkrkgk82;

    public BizNumber getIwsMaitosiphrkrkgk82() {
        return iwsMaitosiphrkrkgk82;
    }

    public void setIwsMaitosiphrkrkgk82(BizNumber pIwsMaitosiphrkrkgk82) {
        iwsMaitosiphrkrkgk82 = pIwsMaitosiphrkrkgk82;
    }

    @Column(order = 86, length = 13)
    private BizNumber iwsMaitosiphrkrkgk83;

    public BizNumber getIwsMaitosiphrkrkgk83() {
        return iwsMaitosiphrkrkgk83;
    }

    public void setIwsMaitosiphrkrkgk83(BizNumber pIwsMaitosiphrkrkgk83) {
        iwsMaitosiphrkrkgk83 = pIwsMaitosiphrkrkgk83;
    }

    @Column(order = 87, length = 13)
    private BizNumber iwsMaitosiphrkrkgk84;

    public BizNumber getIwsMaitosiphrkrkgk84() {
        return iwsMaitosiphrkrkgk84;
    }

    public void setIwsMaitosiphrkrkgk84(BizNumber pIwsMaitosiphrkrkgk84) {
        iwsMaitosiphrkrkgk84 = pIwsMaitosiphrkrkgk84;
    }

    @Column(order = 88, length = 13)
    private BizNumber iwsMaitosiphrkrkgk85;

    public BizNumber getIwsMaitosiphrkrkgk85() {
        return iwsMaitosiphrkrkgk85;
    }

    public void setIwsMaitosiphrkrkgk85(BizNumber pIwsMaitosiphrkrkgk85) {
        iwsMaitosiphrkrkgk85 = pIwsMaitosiphrkrkgk85;
    }

    @Column(order = 89, length = 13)
    private BizNumber iwsMaitosiphrkrkgk86;

    public BizNumber getIwsMaitosiphrkrkgk86() {
        return iwsMaitosiphrkrkgk86;
    }

    public void setIwsMaitosiphrkrkgk86(BizNumber pIwsMaitosiphrkrkgk86) {
        iwsMaitosiphrkrkgk86 = pIwsMaitosiphrkrkgk86;
    }

    @Column(order = 90, length = 13)
    private BizNumber iwsMaitosiphrkrkgk87;

    public BizNumber getIwsMaitosiphrkrkgk87() {
        return iwsMaitosiphrkrkgk87;
    }

    public void setIwsMaitosiphrkrkgk87(BizNumber pIwsMaitosiphrkrkgk87) {
        iwsMaitosiphrkrkgk87 = pIwsMaitosiphrkrkgk87;
    }

    @Column(order = 91, length = 13)
    private BizNumber iwsMaitosiphrkrkgk88;

    public BizNumber getIwsMaitosiphrkrkgk88() {
        return iwsMaitosiphrkrkgk88;
    }

    public void setIwsMaitosiphrkrkgk88(BizNumber pIwsMaitosiphrkrkgk88) {
        iwsMaitosiphrkrkgk88 = pIwsMaitosiphrkrkgk88;
    }

    @Column(order = 92, length = 13)
    private BizNumber iwsMaitosiphrkrkgk89;

    public BizNumber getIwsMaitosiphrkrkgk89() {
        return iwsMaitosiphrkrkgk89;
    }

    public void setIwsMaitosiphrkrkgk89(BizNumber pIwsMaitosiphrkrkgk89) {
        iwsMaitosiphrkrkgk89 = pIwsMaitosiphrkrkgk89;
    }

    @Column(order = 93, length = 13)
    private BizNumber iwsMaitosiphrkrkgk90;

    public BizNumber getIwsMaitosiphrkrkgk90() {
        return iwsMaitosiphrkrkgk90;
    }

    public void setIwsMaitosiphrkrkgk90(BizNumber pIwsMaitosiphrkrkgk90) {
        iwsMaitosiphrkrkgk90 = pIwsMaitosiphrkrkgk90;
    }

    @Column(order = 94, length = 13)
    private BizNumber iwsMaitosiphrkrkgk91;

    public BizNumber getIwsMaitosiphrkrkgk91() {
        return iwsMaitosiphrkrkgk91;
    }

    public void setIwsMaitosiphrkrkgk91(BizNumber pIwsMaitosiphrkrkgk91) {
        iwsMaitosiphrkrkgk91 = pIwsMaitosiphrkrkgk91;
    }

    @Column(order = 95, length = 13)
    private BizNumber iwsMaitosiphrkrkgk92;

    public BizNumber getIwsMaitosiphrkrkgk92() {
        return iwsMaitosiphrkrkgk92;
    }

    public void setIwsMaitosiphrkrkgk92(BizNumber pIwsMaitosiphrkrkgk92) {
        iwsMaitosiphrkrkgk92 = pIwsMaitosiphrkrkgk92;
    }

    @Column(order = 96, length = 13)
    private BizNumber iwsMaitosiphrkrkgk93;

    public BizNumber getIwsMaitosiphrkrkgk93() {
        return iwsMaitosiphrkrkgk93;
    }

    public void setIwsMaitosiphrkrkgk93(BizNumber pIwsMaitosiphrkrkgk93) {
        iwsMaitosiphrkrkgk93 = pIwsMaitosiphrkrkgk93;
    }

    @Column(order = 97, length = 13)
    private BizNumber iwsMaitosiphrkrkgk94;

    public BizNumber getIwsMaitosiphrkrkgk94() {
        return iwsMaitosiphrkrkgk94;
    }

    public void setIwsMaitosiphrkrkgk94(BizNumber pIwsMaitosiphrkrkgk94) {
        iwsMaitosiphrkrkgk94 = pIwsMaitosiphrkrkgk94;
    }

    @Column(order = 98, length = 13)
    private BizNumber iwsMaitosiphrkrkgk95;

    public BizNumber getIwsMaitosiphrkrkgk95() {
        return iwsMaitosiphrkrkgk95;
    }

    public void setIwsMaitosiphrkrkgk95(BizNumber pIwsMaitosiphrkrkgk95) {
        iwsMaitosiphrkrkgk95 = pIwsMaitosiphrkrkgk95;
    }

    @Column(order = 99, length = 13)
    private BizNumber iwsMaitosiphrkrkgk96;

    public BizNumber getIwsMaitosiphrkrkgk96() {
        return iwsMaitosiphrkrkgk96;
    }

    public void setIwsMaitosiphrkrkgk96(BizNumber pIwsMaitosiphrkrkgk96) {
        iwsMaitosiphrkrkgk96 = pIwsMaitosiphrkrkgk96;
    }

    @Column(order = 100, length = 13)
    private BizNumber iwsMaitosiphrkrkgk97;

    public BizNumber getIwsMaitosiphrkrkgk97() {
        return iwsMaitosiphrkrkgk97;
    }

    public void setIwsMaitosiphrkrkgk97(BizNumber pIwsMaitosiphrkrkgk97) {
        iwsMaitosiphrkrkgk97 = pIwsMaitosiphrkrkgk97;
    }

    @Column(order = 101, length = 13)
    private BizNumber iwsMaitosiphrkrkgk98;

    public BizNumber getIwsMaitosiphrkrkgk98() {
        return iwsMaitosiphrkrkgk98;
    }

    public void setIwsMaitosiphrkrkgk98(BizNumber pIwsMaitosiphrkrkgk98) {
        iwsMaitosiphrkrkgk98 = pIwsMaitosiphrkrkgk98;
    }

    @Column(order = 102, length = 13)
    private BizNumber iwsMaitosiphrkrkgk99;

    public BizNumber getIwsMaitosiphrkrkgk99() {
        return iwsMaitosiphrkrkgk99;
    }

    public void setIwsMaitosiphrkrkgk99(BizNumber pIwsMaitosiphrkrkgk99) {
        iwsMaitosiphrkrkgk99 = pIwsMaitosiphrkrkgk99;
    }

    @Column(order = 103, length = 13)
    private BizNumber iwsMaitosikaiyakuhr1;

    public BizNumber getIwsMaitosikaiyakuhr1() {
        return iwsMaitosikaiyakuhr1;
    }

    public void setIwsMaitosikaiyakuhr1(BizNumber pIwsMaitosikaiyakuhr1) {
        iwsMaitosikaiyakuhr1 = pIwsMaitosikaiyakuhr1;
    }

    @Column(order = 104, length = 13)
    private BizNumber iwsMaitosikaiyakuhr2;

    public BizNumber getIwsMaitosikaiyakuhr2() {
        return iwsMaitosikaiyakuhr2;
    }

    public void setIwsMaitosikaiyakuhr2(BizNumber pIwsMaitosikaiyakuhr2) {
        iwsMaitosikaiyakuhr2 = pIwsMaitosikaiyakuhr2;
    }

    @Column(order = 105, length = 13)
    private BizNumber iwsMaitosikaiyakuhr3;

    public BizNumber getIwsMaitosikaiyakuhr3() {
        return iwsMaitosikaiyakuhr3;
    }

    public void setIwsMaitosikaiyakuhr3(BizNumber pIwsMaitosikaiyakuhr3) {
        iwsMaitosikaiyakuhr3 = pIwsMaitosikaiyakuhr3;
    }

    @Column(order = 106, length = 13)
    private BizNumber iwsMaitosikaiyakuhr4;

    public BizNumber getIwsMaitosikaiyakuhr4() {
        return iwsMaitosikaiyakuhr4;
    }

    public void setIwsMaitosikaiyakuhr4(BizNumber pIwsMaitosikaiyakuhr4) {
        iwsMaitosikaiyakuhr4 = pIwsMaitosikaiyakuhr4;
    }

    @Column(order = 107, length = 13)
    private BizNumber iwsMaitosikaiyakuhr5;

    public BizNumber getIwsMaitosikaiyakuhr5() {
        return iwsMaitosikaiyakuhr5;
    }

    public void setIwsMaitosikaiyakuhr5(BizNumber pIwsMaitosikaiyakuhr5) {
        iwsMaitosikaiyakuhr5 = pIwsMaitosikaiyakuhr5;
    }

    @Column(order = 108, length = 13)
    private BizNumber iwsMaitosikaiyakuhr6;

    public BizNumber getIwsMaitosikaiyakuhr6() {
        return iwsMaitosikaiyakuhr6;
    }

    public void setIwsMaitosikaiyakuhr6(BizNumber pIwsMaitosikaiyakuhr6) {
        iwsMaitosikaiyakuhr6 = pIwsMaitosikaiyakuhr6;
    }

    @Column(order = 109, length = 13)
    private BizNumber iwsMaitosikaiyakuhr7;

    public BizNumber getIwsMaitosikaiyakuhr7() {
        return iwsMaitosikaiyakuhr7;
    }

    public void setIwsMaitosikaiyakuhr7(BizNumber pIwsMaitosikaiyakuhr7) {
        iwsMaitosikaiyakuhr7 = pIwsMaitosikaiyakuhr7;
    }

    @Column(order = 110, length = 13)
    private BizNumber iwsMaitosikaiyakuhr8;

    public BizNumber getIwsMaitosikaiyakuhr8() {
        return iwsMaitosikaiyakuhr8;
    }

    public void setIwsMaitosikaiyakuhr8(BizNumber pIwsMaitosikaiyakuhr8) {
        iwsMaitosikaiyakuhr8 = pIwsMaitosikaiyakuhr8;
    }

    @Column(order = 111, length = 13)
    private BizNumber iwsMaitosikaiyakuhr9;

    public BizNumber getIwsMaitosikaiyakuhr9() {
        return iwsMaitosikaiyakuhr9;
    }

    public void setIwsMaitosikaiyakuhr9(BizNumber pIwsMaitosikaiyakuhr9) {
        iwsMaitosikaiyakuhr9 = pIwsMaitosikaiyakuhr9;
    }

    @Column(order = 112, length = 13)
    private BizNumber iwsMaitosikaiyakuhr10;

    public BizNumber getIwsMaitosikaiyakuhr10() {
        return iwsMaitosikaiyakuhr10;
    }

    public void setIwsMaitosikaiyakuhr10(BizNumber pIwsMaitosikaiyakuhr10) {
        iwsMaitosikaiyakuhr10 = pIwsMaitosikaiyakuhr10;
    }

    @Column(order = 113, length = 13)
    private BizNumber iwsMaitosikaiyakuhr11;

    public BizNumber getIwsMaitosikaiyakuhr11() {
        return iwsMaitosikaiyakuhr11;
    }

    public void setIwsMaitosikaiyakuhr11(BizNumber pIwsMaitosikaiyakuhr11) {
        iwsMaitosikaiyakuhr11 = pIwsMaitosikaiyakuhr11;
    }

    @Column(order = 114, length = 13)
    private BizNumber iwsMaitosikaiyakuhr12;

    public BizNumber getIwsMaitosikaiyakuhr12() {
        return iwsMaitosikaiyakuhr12;
    }

    public void setIwsMaitosikaiyakuhr12(BizNumber pIwsMaitosikaiyakuhr12) {
        iwsMaitosikaiyakuhr12 = pIwsMaitosikaiyakuhr12;
    }

    @Column(order = 115, length = 13)
    private BizNumber iwsMaitosikaiyakuhr13;

    public BizNumber getIwsMaitosikaiyakuhr13() {
        return iwsMaitosikaiyakuhr13;
    }

    public void setIwsMaitosikaiyakuhr13(BizNumber pIwsMaitosikaiyakuhr13) {
        iwsMaitosikaiyakuhr13 = pIwsMaitosikaiyakuhr13;
    }

    @Column(order = 116, length = 13)
    private BizNumber iwsMaitosikaiyakuhr14;

    public BizNumber getIwsMaitosikaiyakuhr14() {
        return iwsMaitosikaiyakuhr14;
    }

    public void setIwsMaitosikaiyakuhr14(BizNumber pIwsMaitosikaiyakuhr14) {
        iwsMaitosikaiyakuhr14 = pIwsMaitosikaiyakuhr14;
    }

    @Column(order = 117, length = 13)
    private BizNumber iwsMaitosikaiyakuhr15;

    public BizNumber getIwsMaitosikaiyakuhr15() {
        return iwsMaitosikaiyakuhr15;
    }

    public void setIwsMaitosikaiyakuhr15(BizNumber pIwsMaitosikaiyakuhr15) {
        iwsMaitosikaiyakuhr15 = pIwsMaitosikaiyakuhr15;
    }

    @Column(order = 118, length = 13)
    private BizNumber iwsMaitosikaiyakuhr16;

    public BizNumber getIwsMaitosikaiyakuhr16() {
        return iwsMaitosikaiyakuhr16;
    }

    public void setIwsMaitosikaiyakuhr16(BizNumber pIwsMaitosikaiyakuhr16) {
        iwsMaitosikaiyakuhr16 = pIwsMaitosikaiyakuhr16;
    }

    @Column(order = 119, length = 13)
    private BizNumber iwsMaitosikaiyakuhr17;

    public BizNumber getIwsMaitosikaiyakuhr17() {
        return iwsMaitosikaiyakuhr17;
    }

    public void setIwsMaitosikaiyakuhr17(BizNumber pIwsMaitosikaiyakuhr17) {
        iwsMaitosikaiyakuhr17 = pIwsMaitosikaiyakuhr17;
    }

    @Column(order = 120, length = 13)
    private BizNumber iwsMaitosikaiyakuhr18;

    public BizNumber getIwsMaitosikaiyakuhr18() {
        return iwsMaitosikaiyakuhr18;
    }

    public void setIwsMaitosikaiyakuhr18(BizNumber pIwsMaitosikaiyakuhr18) {
        iwsMaitosikaiyakuhr18 = pIwsMaitosikaiyakuhr18;
    }

    @Column(order = 121, length = 13)
    private BizNumber iwsMaitosikaiyakuhr19;

    public BizNumber getIwsMaitosikaiyakuhr19() {
        return iwsMaitosikaiyakuhr19;
    }

    public void setIwsMaitosikaiyakuhr19(BizNumber pIwsMaitosikaiyakuhr19) {
        iwsMaitosikaiyakuhr19 = pIwsMaitosikaiyakuhr19;
    }

    @Column(order = 122, length = 13)
    private BizNumber iwsMaitosikaiyakuhr20;

    public BizNumber getIwsMaitosikaiyakuhr20() {
        return iwsMaitosikaiyakuhr20;
    }

    public void setIwsMaitosikaiyakuhr20(BizNumber pIwsMaitosikaiyakuhr20) {
        iwsMaitosikaiyakuhr20 = pIwsMaitosikaiyakuhr20;
    }

    @Column(order = 123, length = 13)
    private BizNumber iwsMaitosikaiyakuhr21;

    public BizNumber getIwsMaitosikaiyakuhr21() {
        return iwsMaitosikaiyakuhr21;
    }

    public void setIwsMaitosikaiyakuhr21(BizNumber pIwsMaitosikaiyakuhr21) {
        iwsMaitosikaiyakuhr21 = pIwsMaitosikaiyakuhr21;
    }

    @Column(order = 124, length = 13)
    private BizNumber iwsMaitosikaiyakuhr22;

    public BizNumber getIwsMaitosikaiyakuhr22() {
        return iwsMaitosikaiyakuhr22;
    }

    public void setIwsMaitosikaiyakuhr22(BizNumber pIwsMaitosikaiyakuhr22) {
        iwsMaitosikaiyakuhr22 = pIwsMaitosikaiyakuhr22;
    }

    @Column(order = 125, length = 13)
    private BizNumber iwsMaitosikaiyakuhr23;

    public BizNumber getIwsMaitosikaiyakuhr23() {
        return iwsMaitosikaiyakuhr23;
    }

    public void setIwsMaitosikaiyakuhr23(BizNumber pIwsMaitosikaiyakuhr23) {
        iwsMaitosikaiyakuhr23 = pIwsMaitosikaiyakuhr23;
    }

    @Column(order = 126, length = 13)
    private BizNumber iwsMaitosikaiyakuhr24;

    public BizNumber getIwsMaitosikaiyakuhr24() {
        return iwsMaitosikaiyakuhr24;
    }

    public void setIwsMaitosikaiyakuhr24(BizNumber pIwsMaitosikaiyakuhr24) {
        iwsMaitosikaiyakuhr24 = pIwsMaitosikaiyakuhr24;
    }

    @Column(order = 127, length = 13)
    private BizNumber iwsMaitosikaiyakuhr25;

    public BizNumber getIwsMaitosikaiyakuhr25() {
        return iwsMaitosikaiyakuhr25;
    }

    public void setIwsMaitosikaiyakuhr25(BizNumber pIwsMaitosikaiyakuhr25) {
        iwsMaitosikaiyakuhr25 = pIwsMaitosikaiyakuhr25;
    }

    @Column(order = 128, length = 13)
    private BizNumber iwsMaitosikaiyakuhr26;

    public BizNumber getIwsMaitosikaiyakuhr26() {
        return iwsMaitosikaiyakuhr26;
    }

    public void setIwsMaitosikaiyakuhr26(BizNumber pIwsMaitosikaiyakuhr26) {
        iwsMaitosikaiyakuhr26 = pIwsMaitosikaiyakuhr26;
    }

    @Column(order = 129, length = 13)
    private BizNumber iwsMaitosikaiyakuhr27;

    public BizNumber getIwsMaitosikaiyakuhr27() {
        return iwsMaitosikaiyakuhr27;
    }

    public void setIwsMaitosikaiyakuhr27(BizNumber pIwsMaitosikaiyakuhr27) {
        iwsMaitosikaiyakuhr27 = pIwsMaitosikaiyakuhr27;
    }

    @Column(order = 130, length = 13)
    private BizNumber iwsMaitosikaiyakuhr28;

    public BizNumber getIwsMaitosikaiyakuhr28() {
        return iwsMaitosikaiyakuhr28;
    }

    public void setIwsMaitosikaiyakuhr28(BizNumber pIwsMaitosikaiyakuhr28) {
        iwsMaitosikaiyakuhr28 = pIwsMaitosikaiyakuhr28;
    }

    @Column(order = 131, length = 13)
    private BizNumber iwsMaitosikaiyakuhr29;

    public BizNumber getIwsMaitosikaiyakuhr29() {
        return iwsMaitosikaiyakuhr29;
    }

    public void setIwsMaitosikaiyakuhr29(BizNumber pIwsMaitosikaiyakuhr29) {
        iwsMaitosikaiyakuhr29 = pIwsMaitosikaiyakuhr29;
    }

    @Column(order = 132, length = 13)
    private BizNumber iwsMaitosikaiyakuhr30;

    public BizNumber getIwsMaitosikaiyakuhr30() {
        return iwsMaitosikaiyakuhr30;
    }

    public void setIwsMaitosikaiyakuhr30(BizNumber pIwsMaitosikaiyakuhr30) {
        iwsMaitosikaiyakuhr30 = pIwsMaitosikaiyakuhr30;
    }

    @Column(order = 133, length = 13)
    private BizNumber iwsMaitosikaiyakuhr31;

    public BizNumber getIwsMaitosikaiyakuhr31() {
        return iwsMaitosikaiyakuhr31;
    }

    public void setIwsMaitosikaiyakuhr31(BizNumber pIwsMaitosikaiyakuhr31) {
        iwsMaitosikaiyakuhr31 = pIwsMaitosikaiyakuhr31;
    }

    @Column(order = 134, length = 13)
    private BizNumber iwsMaitosikaiyakuhr32;

    public BizNumber getIwsMaitosikaiyakuhr32() {
        return iwsMaitosikaiyakuhr32;
    }

    public void setIwsMaitosikaiyakuhr32(BizNumber pIwsMaitosikaiyakuhr32) {
        iwsMaitosikaiyakuhr32 = pIwsMaitosikaiyakuhr32;
    }

    @Column(order = 135, length = 13)
    private BizNumber iwsMaitosikaiyakuhr33;

    public BizNumber getIwsMaitosikaiyakuhr33() {
        return iwsMaitosikaiyakuhr33;
    }

    public void setIwsMaitosikaiyakuhr33(BizNumber pIwsMaitosikaiyakuhr33) {
        iwsMaitosikaiyakuhr33 = pIwsMaitosikaiyakuhr33;
    }

    @Column(order = 136, length = 13)
    private BizNumber iwsMaitosikaiyakuhr34;

    public BizNumber getIwsMaitosikaiyakuhr34() {
        return iwsMaitosikaiyakuhr34;
    }

    public void setIwsMaitosikaiyakuhr34(BizNumber pIwsMaitosikaiyakuhr34) {
        iwsMaitosikaiyakuhr34 = pIwsMaitosikaiyakuhr34;
    }

    @Column(order = 137, length = 13)
    private BizNumber iwsMaitosikaiyakuhr35;

    public BizNumber getIwsMaitosikaiyakuhr35() {
        return iwsMaitosikaiyakuhr35;
    }

    public void setIwsMaitosikaiyakuhr35(BizNumber pIwsMaitosikaiyakuhr35) {
        iwsMaitosikaiyakuhr35 = pIwsMaitosikaiyakuhr35;
    }

    @Column(order = 138, length = 13)
    private BizNumber iwsMaitosikaiyakuhr36;

    public BizNumber getIwsMaitosikaiyakuhr36() {
        return iwsMaitosikaiyakuhr36;
    }

    public void setIwsMaitosikaiyakuhr36(BizNumber pIwsMaitosikaiyakuhr36) {
        iwsMaitosikaiyakuhr36 = pIwsMaitosikaiyakuhr36;
    }

    @Column(order = 139, length = 13)
    private BizNumber iwsMaitosikaiyakuhr37;

    public BizNumber getIwsMaitosikaiyakuhr37() {
        return iwsMaitosikaiyakuhr37;
    }

    public void setIwsMaitosikaiyakuhr37(BizNumber pIwsMaitosikaiyakuhr37) {
        iwsMaitosikaiyakuhr37 = pIwsMaitosikaiyakuhr37;
    }

    @Column(order = 140, length = 13)
    private BizNumber iwsMaitosikaiyakuhr38;

    public BizNumber getIwsMaitosikaiyakuhr38() {
        return iwsMaitosikaiyakuhr38;
    }

    public void setIwsMaitosikaiyakuhr38(BizNumber pIwsMaitosikaiyakuhr38) {
        iwsMaitosikaiyakuhr38 = pIwsMaitosikaiyakuhr38;
    }

    @Column(order = 141, length = 13)
    private BizNumber iwsMaitosikaiyakuhr39;

    public BizNumber getIwsMaitosikaiyakuhr39() {
        return iwsMaitosikaiyakuhr39;
    }

    public void setIwsMaitosikaiyakuhr39(BizNumber pIwsMaitosikaiyakuhr39) {
        iwsMaitosikaiyakuhr39 = pIwsMaitosikaiyakuhr39;
    }

    @Column(order = 142, length = 13)
    private BizNumber iwsMaitosikaiyakuhr40;

    public BizNumber getIwsMaitosikaiyakuhr40() {
        return iwsMaitosikaiyakuhr40;
    }

    public void setIwsMaitosikaiyakuhr40(BizNumber pIwsMaitosikaiyakuhr40) {
        iwsMaitosikaiyakuhr40 = pIwsMaitosikaiyakuhr40;
    }

    @Column(order = 143, length = 13)
    private BizNumber iwsMaitosikaiyakuhr41;

    public BizNumber getIwsMaitosikaiyakuhr41() {
        return iwsMaitosikaiyakuhr41;
    }

    public void setIwsMaitosikaiyakuhr41(BizNumber pIwsMaitosikaiyakuhr41) {
        iwsMaitosikaiyakuhr41 = pIwsMaitosikaiyakuhr41;
    }

    @Column(order = 144, length = 13)
    private BizNumber iwsMaitosikaiyakuhr42;

    public BizNumber getIwsMaitosikaiyakuhr42() {
        return iwsMaitosikaiyakuhr42;
    }

    public void setIwsMaitosikaiyakuhr42(BizNumber pIwsMaitosikaiyakuhr42) {
        iwsMaitosikaiyakuhr42 = pIwsMaitosikaiyakuhr42;
    }

    @Column(order = 145, length = 13)
    private BizNumber iwsMaitosikaiyakuhr43;

    public BizNumber getIwsMaitosikaiyakuhr43() {
        return iwsMaitosikaiyakuhr43;
    }

    public void setIwsMaitosikaiyakuhr43(BizNumber pIwsMaitosikaiyakuhr43) {
        iwsMaitosikaiyakuhr43 = pIwsMaitosikaiyakuhr43;
    }

    @Column(order = 146, length = 13)
    private BizNumber iwsMaitosikaiyakuhr44;

    public BizNumber getIwsMaitosikaiyakuhr44() {
        return iwsMaitosikaiyakuhr44;
    }

    public void setIwsMaitosikaiyakuhr44(BizNumber pIwsMaitosikaiyakuhr44) {
        iwsMaitosikaiyakuhr44 = pIwsMaitosikaiyakuhr44;
    }

    @Column(order = 147, length = 13)
    private BizNumber iwsMaitosikaiyakuhr45;

    public BizNumber getIwsMaitosikaiyakuhr45() {
        return iwsMaitosikaiyakuhr45;
    }

    public void setIwsMaitosikaiyakuhr45(BizNumber pIwsMaitosikaiyakuhr45) {
        iwsMaitosikaiyakuhr45 = pIwsMaitosikaiyakuhr45;
    }

    @Column(order = 148, length = 13)
    private BizNumber iwsMaitosikaiyakuhr46;

    public BizNumber getIwsMaitosikaiyakuhr46() {
        return iwsMaitosikaiyakuhr46;
    }

    public void setIwsMaitosikaiyakuhr46(BizNumber pIwsMaitosikaiyakuhr46) {
        iwsMaitosikaiyakuhr46 = pIwsMaitosikaiyakuhr46;
    }

    @Column(order = 149, length = 13)
    private BizNumber iwsMaitosikaiyakuhr47;

    public BizNumber getIwsMaitosikaiyakuhr47() {
        return iwsMaitosikaiyakuhr47;
    }

    public void setIwsMaitosikaiyakuhr47(BizNumber pIwsMaitosikaiyakuhr47) {
        iwsMaitosikaiyakuhr47 = pIwsMaitosikaiyakuhr47;
    }

    @Column(order = 150, length = 13)
    private BizNumber iwsMaitosikaiyakuhr48;

    public BizNumber getIwsMaitosikaiyakuhr48() {
        return iwsMaitosikaiyakuhr48;
    }

    public void setIwsMaitosikaiyakuhr48(BizNumber pIwsMaitosikaiyakuhr48) {
        iwsMaitosikaiyakuhr48 = pIwsMaitosikaiyakuhr48;
    }

    @Column(order = 151, length = 13)
    private BizNumber iwsMaitosikaiyakuhr49;

    public BizNumber getIwsMaitosikaiyakuhr49() {
        return iwsMaitosikaiyakuhr49;
    }

    public void setIwsMaitosikaiyakuhr49(BizNumber pIwsMaitosikaiyakuhr49) {
        iwsMaitosikaiyakuhr49 = pIwsMaitosikaiyakuhr49;
    }

    @Column(order = 152, length = 13)
    private BizNumber iwsMaitosikaiyakuhr50;

    public BizNumber getIwsMaitosikaiyakuhr50() {
        return iwsMaitosikaiyakuhr50;
    }

    public void setIwsMaitosikaiyakuhr50(BizNumber pIwsMaitosikaiyakuhr50) {
        iwsMaitosikaiyakuhr50 = pIwsMaitosikaiyakuhr50;
    }

    @Column(order = 153, length = 13)
    private BizNumber iwsMaitosikaiyakuhr51;

    public BizNumber getIwsMaitosikaiyakuhr51() {
        return iwsMaitosikaiyakuhr51;
    }

    public void setIwsMaitosikaiyakuhr51(BizNumber pIwsMaitosikaiyakuhr51) {
        iwsMaitosikaiyakuhr51 = pIwsMaitosikaiyakuhr51;
    }

    @Column(order = 154, length = 13)
    private BizNumber iwsMaitosikaiyakuhr52;

    public BizNumber getIwsMaitosikaiyakuhr52() {
        return iwsMaitosikaiyakuhr52;
    }

    public void setIwsMaitosikaiyakuhr52(BizNumber pIwsMaitosikaiyakuhr52) {
        iwsMaitosikaiyakuhr52 = pIwsMaitosikaiyakuhr52;
    }

    @Column(order = 155, length = 13)
    private BizNumber iwsMaitosikaiyakuhr53;

    public BizNumber getIwsMaitosikaiyakuhr53() {
        return iwsMaitosikaiyakuhr53;
    }

    public void setIwsMaitosikaiyakuhr53(BizNumber pIwsMaitosikaiyakuhr53) {
        iwsMaitosikaiyakuhr53 = pIwsMaitosikaiyakuhr53;
    }

    @Column(order = 156, length = 13)
    private BizNumber iwsMaitosikaiyakuhr54;

    public BizNumber getIwsMaitosikaiyakuhr54() {
        return iwsMaitosikaiyakuhr54;
    }

    public void setIwsMaitosikaiyakuhr54(BizNumber pIwsMaitosikaiyakuhr54) {
        iwsMaitosikaiyakuhr54 = pIwsMaitosikaiyakuhr54;
    }

    @Column(order = 157, length = 13)
    private BizNumber iwsMaitosikaiyakuhr55;

    public BizNumber getIwsMaitosikaiyakuhr55() {
        return iwsMaitosikaiyakuhr55;
    }

    public void setIwsMaitosikaiyakuhr55(BizNumber pIwsMaitosikaiyakuhr55) {
        iwsMaitosikaiyakuhr55 = pIwsMaitosikaiyakuhr55;
    }

    @Column(order = 158, length = 13)
    private BizNumber iwsMaitosikaiyakuhr56;

    public BizNumber getIwsMaitosikaiyakuhr56() {
        return iwsMaitosikaiyakuhr56;
    }

    public void setIwsMaitosikaiyakuhr56(BizNumber pIwsMaitosikaiyakuhr56) {
        iwsMaitosikaiyakuhr56 = pIwsMaitosikaiyakuhr56;
    }

    @Column(order = 159, length = 13)
    private BizNumber iwsMaitosikaiyakuhr57;

    public BizNumber getIwsMaitosikaiyakuhr57() {
        return iwsMaitosikaiyakuhr57;
    }

    public void setIwsMaitosikaiyakuhr57(BizNumber pIwsMaitosikaiyakuhr57) {
        iwsMaitosikaiyakuhr57 = pIwsMaitosikaiyakuhr57;
    }

    @Column(order = 160, length = 13)
    private BizNumber iwsMaitosikaiyakuhr58;

    public BizNumber getIwsMaitosikaiyakuhr58() {
        return iwsMaitosikaiyakuhr58;
    }

    public void setIwsMaitosikaiyakuhr58(BizNumber pIwsMaitosikaiyakuhr58) {
        iwsMaitosikaiyakuhr58 = pIwsMaitosikaiyakuhr58;
    }

    @Column(order = 161, length = 13)
    private BizNumber iwsMaitosikaiyakuhr59;

    public BizNumber getIwsMaitosikaiyakuhr59() {
        return iwsMaitosikaiyakuhr59;
    }

    public void setIwsMaitosikaiyakuhr59(BizNumber pIwsMaitosikaiyakuhr59) {
        iwsMaitosikaiyakuhr59 = pIwsMaitosikaiyakuhr59;
    }

    @Column(order = 162, length = 13)
    private BizNumber iwsMaitosikaiyakuhr60;

    public BizNumber getIwsMaitosikaiyakuhr60() {
        return iwsMaitosikaiyakuhr60;
    }

    public void setIwsMaitosikaiyakuhr60(BizNumber pIwsMaitosikaiyakuhr60) {
        iwsMaitosikaiyakuhr60 = pIwsMaitosikaiyakuhr60;
    }

    @Column(order = 163, length = 13)
    private BizNumber iwsMaitosikaiyakuhr61;

    public BizNumber getIwsMaitosikaiyakuhr61() {
        return iwsMaitosikaiyakuhr61;
    }

    public void setIwsMaitosikaiyakuhr61(BizNumber pIwsMaitosikaiyakuhr61) {
        iwsMaitosikaiyakuhr61 = pIwsMaitosikaiyakuhr61;
    }

    @Column(order = 164, length = 13)
    private BizNumber iwsMaitosikaiyakuhr62;

    public BizNumber getIwsMaitosikaiyakuhr62() {
        return iwsMaitosikaiyakuhr62;
    }

    public void setIwsMaitosikaiyakuhr62(BizNumber pIwsMaitosikaiyakuhr62) {
        iwsMaitosikaiyakuhr62 = pIwsMaitosikaiyakuhr62;
    }

    @Column(order = 165, length = 13)
    private BizNumber iwsMaitosikaiyakuhr63;

    public BizNumber getIwsMaitosikaiyakuhr63() {
        return iwsMaitosikaiyakuhr63;
    }

    public void setIwsMaitosikaiyakuhr63(BizNumber pIwsMaitosikaiyakuhr63) {
        iwsMaitosikaiyakuhr63 = pIwsMaitosikaiyakuhr63;
    }

    @Column(order = 166, length = 13)
    private BizNumber iwsMaitosikaiyakuhr64;

    public BizNumber getIwsMaitosikaiyakuhr64() {
        return iwsMaitosikaiyakuhr64;
    }

    public void setIwsMaitosikaiyakuhr64(BizNumber pIwsMaitosikaiyakuhr64) {
        iwsMaitosikaiyakuhr64 = pIwsMaitosikaiyakuhr64;
    }

    @Column(order = 167, length = 13)
    private BizNumber iwsMaitosikaiyakuhr65;

    public BizNumber getIwsMaitosikaiyakuhr65() {
        return iwsMaitosikaiyakuhr65;
    }

    public void setIwsMaitosikaiyakuhr65(BizNumber pIwsMaitosikaiyakuhr65) {
        iwsMaitosikaiyakuhr65 = pIwsMaitosikaiyakuhr65;
    }

    @Column(order = 168, length = 13)
    private BizNumber iwsMaitosikaiyakuhr66;

    public BizNumber getIwsMaitosikaiyakuhr66() {
        return iwsMaitosikaiyakuhr66;
    }

    public void setIwsMaitosikaiyakuhr66(BizNumber pIwsMaitosikaiyakuhr66) {
        iwsMaitosikaiyakuhr66 = pIwsMaitosikaiyakuhr66;
    }

    @Column(order = 169, length = 13)
    private BizNumber iwsMaitosikaiyakuhr67;

    public BizNumber getIwsMaitosikaiyakuhr67() {
        return iwsMaitosikaiyakuhr67;
    }

    public void setIwsMaitosikaiyakuhr67(BizNumber pIwsMaitosikaiyakuhr67) {
        iwsMaitosikaiyakuhr67 = pIwsMaitosikaiyakuhr67;
    }

    @Column(order = 170, length = 13)
    private BizNumber iwsMaitosikaiyakuhr68;

    public BizNumber getIwsMaitosikaiyakuhr68() {
        return iwsMaitosikaiyakuhr68;
    }

    public void setIwsMaitosikaiyakuhr68(BizNumber pIwsMaitosikaiyakuhr68) {
        iwsMaitosikaiyakuhr68 = pIwsMaitosikaiyakuhr68;
    }

    @Column(order = 171, length = 13)
    private BizNumber iwsMaitosikaiyakuhr69;

    public BizNumber getIwsMaitosikaiyakuhr69() {
        return iwsMaitosikaiyakuhr69;
    }

    public void setIwsMaitosikaiyakuhr69(BizNumber pIwsMaitosikaiyakuhr69) {
        iwsMaitosikaiyakuhr69 = pIwsMaitosikaiyakuhr69;
    }

    @Column(order = 172, length = 13)
    private BizNumber iwsMaitosikaiyakuhr70;

    public BizNumber getIwsMaitosikaiyakuhr70() {
        return iwsMaitosikaiyakuhr70;
    }

    public void setIwsMaitosikaiyakuhr70(BizNumber pIwsMaitosikaiyakuhr70) {
        iwsMaitosikaiyakuhr70 = pIwsMaitosikaiyakuhr70;
    }

    @Column(order = 173, length = 13)
    private BizNumber iwsMaitosikaiyakuhr71;

    public BizNumber getIwsMaitosikaiyakuhr71() {
        return iwsMaitosikaiyakuhr71;
    }

    public void setIwsMaitosikaiyakuhr71(BizNumber pIwsMaitosikaiyakuhr71) {
        iwsMaitosikaiyakuhr71 = pIwsMaitosikaiyakuhr71;
    }

    @Column(order = 174, length = 13)
    private BizNumber iwsMaitosikaiyakuhr72;

    public BizNumber getIwsMaitosikaiyakuhr72() {
        return iwsMaitosikaiyakuhr72;
    }

    public void setIwsMaitosikaiyakuhr72(BizNumber pIwsMaitosikaiyakuhr72) {
        iwsMaitosikaiyakuhr72 = pIwsMaitosikaiyakuhr72;
    }

    @Column(order = 175, length = 13)
    private BizNumber iwsMaitosikaiyakuhr73;

    public BizNumber getIwsMaitosikaiyakuhr73() {
        return iwsMaitosikaiyakuhr73;
    }

    public void setIwsMaitosikaiyakuhr73(BizNumber pIwsMaitosikaiyakuhr73) {
        iwsMaitosikaiyakuhr73 = pIwsMaitosikaiyakuhr73;
    }

    @Column(order = 176, length = 13)
    private BizNumber iwsMaitosikaiyakuhr74;

    public BizNumber getIwsMaitosikaiyakuhr74() {
        return iwsMaitosikaiyakuhr74;
    }

    public void setIwsMaitosikaiyakuhr74(BizNumber pIwsMaitosikaiyakuhr74) {
        iwsMaitosikaiyakuhr74 = pIwsMaitosikaiyakuhr74;
    }

    @Column(order = 177, length = 13)
    private BizNumber iwsMaitosikaiyakuhr75;

    public BizNumber getIwsMaitosikaiyakuhr75() {
        return iwsMaitosikaiyakuhr75;
    }

    public void setIwsMaitosikaiyakuhr75(BizNumber pIwsMaitosikaiyakuhr75) {
        iwsMaitosikaiyakuhr75 = pIwsMaitosikaiyakuhr75;
    }

    @Column(order = 178, length = 13)
    private BizNumber iwsMaitosikaiyakuhr76;

    public BizNumber getIwsMaitosikaiyakuhr76() {
        return iwsMaitosikaiyakuhr76;
    }

    public void setIwsMaitosikaiyakuhr76(BizNumber pIwsMaitosikaiyakuhr76) {
        iwsMaitosikaiyakuhr76 = pIwsMaitosikaiyakuhr76;
    }

    @Column(order = 179, length = 13)
    private BizNumber iwsMaitosikaiyakuhr77;

    public BizNumber getIwsMaitosikaiyakuhr77() {
        return iwsMaitosikaiyakuhr77;
    }

    public void setIwsMaitosikaiyakuhr77(BizNumber pIwsMaitosikaiyakuhr77) {
        iwsMaitosikaiyakuhr77 = pIwsMaitosikaiyakuhr77;
    }

    @Column(order = 180, length = 13)
    private BizNumber iwsMaitosikaiyakuhr78;

    public BizNumber getIwsMaitosikaiyakuhr78() {
        return iwsMaitosikaiyakuhr78;
    }

    public void setIwsMaitosikaiyakuhr78(BizNumber pIwsMaitosikaiyakuhr78) {
        iwsMaitosikaiyakuhr78 = pIwsMaitosikaiyakuhr78;
    }

    @Column(order = 181, length = 13)
    private BizNumber iwsMaitosikaiyakuhr79;

    public BizNumber getIwsMaitosikaiyakuhr79() {
        return iwsMaitosikaiyakuhr79;
    }

    public void setIwsMaitosikaiyakuhr79(BizNumber pIwsMaitosikaiyakuhr79) {
        iwsMaitosikaiyakuhr79 = pIwsMaitosikaiyakuhr79;
    }

    @Column(order = 182, length = 13)
    private BizNumber iwsMaitosikaiyakuhr80;

    public BizNumber getIwsMaitosikaiyakuhr80() {
        return iwsMaitosikaiyakuhr80;
    }

    public void setIwsMaitosikaiyakuhr80(BizNumber pIwsMaitosikaiyakuhr80) {
        iwsMaitosikaiyakuhr80 = pIwsMaitosikaiyakuhr80;
    }

    @Column(order = 183, length = 13)
    private BizNumber iwsMaitosikaiyakuhr81;

    public BizNumber getIwsMaitosikaiyakuhr81() {
        return iwsMaitosikaiyakuhr81;
    }

    public void setIwsMaitosikaiyakuhr81(BizNumber pIwsMaitosikaiyakuhr81) {
        iwsMaitosikaiyakuhr81 = pIwsMaitosikaiyakuhr81;
    }

    @Column(order = 184, length = 13)
    private BizNumber iwsMaitosikaiyakuhr82;

    public BizNumber getIwsMaitosikaiyakuhr82() {
        return iwsMaitosikaiyakuhr82;
    }

    public void setIwsMaitosikaiyakuhr82(BizNumber pIwsMaitosikaiyakuhr82) {
        iwsMaitosikaiyakuhr82 = pIwsMaitosikaiyakuhr82;
    }

    @Column(order = 185, length = 13)
    private BizNumber iwsMaitosikaiyakuhr83;

    public BizNumber getIwsMaitosikaiyakuhr83() {
        return iwsMaitosikaiyakuhr83;
    }

    public void setIwsMaitosikaiyakuhr83(BizNumber pIwsMaitosikaiyakuhr83) {
        iwsMaitosikaiyakuhr83 = pIwsMaitosikaiyakuhr83;
    }

    @Column(order = 186, length = 13)
    private BizNumber iwsMaitosikaiyakuhr84;

    public BizNumber getIwsMaitosikaiyakuhr84() {
        return iwsMaitosikaiyakuhr84;
    }

    public void setIwsMaitosikaiyakuhr84(BizNumber pIwsMaitosikaiyakuhr84) {
        iwsMaitosikaiyakuhr84 = pIwsMaitosikaiyakuhr84;
    }

    @Column(order = 187, length = 13)
    private BizNumber iwsMaitosikaiyakuhr85;

    public BizNumber getIwsMaitosikaiyakuhr85() {
        return iwsMaitosikaiyakuhr85;
    }

    public void setIwsMaitosikaiyakuhr85(BizNumber pIwsMaitosikaiyakuhr85) {
        iwsMaitosikaiyakuhr85 = pIwsMaitosikaiyakuhr85;
    }

    @Column(order = 188, length = 13)
    private BizNumber iwsMaitosikaiyakuhr86;

    public BizNumber getIwsMaitosikaiyakuhr86() {
        return iwsMaitosikaiyakuhr86;
    }

    public void setIwsMaitosikaiyakuhr86(BizNumber pIwsMaitosikaiyakuhr86) {
        iwsMaitosikaiyakuhr86 = pIwsMaitosikaiyakuhr86;
    }

    @Column(order = 189, length = 13)
    private BizNumber iwsMaitosikaiyakuhr87;

    public BizNumber getIwsMaitosikaiyakuhr87() {
        return iwsMaitosikaiyakuhr87;
    }

    public void setIwsMaitosikaiyakuhr87(BizNumber pIwsMaitosikaiyakuhr87) {
        iwsMaitosikaiyakuhr87 = pIwsMaitosikaiyakuhr87;
    }

    @Column(order = 190, length = 13)
    private BizNumber iwsMaitosikaiyakuhr88;

    public BizNumber getIwsMaitosikaiyakuhr88() {
        return iwsMaitosikaiyakuhr88;
    }

    public void setIwsMaitosikaiyakuhr88(BizNumber pIwsMaitosikaiyakuhr88) {
        iwsMaitosikaiyakuhr88 = pIwsMaitosikaiyakuhr88;
    }

    @Column(order = 191, length = 13)
    private BizNumber iwsMaitosikaiyakuhr89;

    public BizNumber getIwsMaitosikaiyakuhr89() {
        return iwsMaitosikaiyakuhr89;
    }

    public void setIwsMaitosikaiyakuhr89(BizNumber pIwsMaitosikaiyakuhr89) {
        iwsMaitosikaiyakuhr89 = pIwsMaitosikaiyakuhr89;
    }

    @Column(order = 192, length = 13)
    private BizNumber iwsMaitosikaiyakuhr90;

    public BizNumber getIwsMaitosikaiyakuhr90() {
        return iwsMaitosikaiyakuhr90;
    }

    public void setIwsMaitosikaiyakuhr90(BizNumber pIwsMaitosikaiyakuhr90) {
        iwsMaitosikaiyakuhr90 = pIwsMaitosikaiyakuhr90;
    }

    @Column(order = 193, length = 13)
    private BizNumber iwsMaitosikaiyakuhr91;

    public BizNumber getIwsMaitosikaiyakuhr91() {
        return iwsMaitosikaiyakuhr91;
    }

    public void setIwsMaitosikaiyakuhr91(BizNumber pIwsMaitosikaiyakuhr91) {
        iwsMaitosikaiyakuhr91 = pIwsMaitosikaiyakuhr91;
    }

    @Column(order = 194, length = 13)
    private BizNumber iwsMaitosikaiyakuhr92;

    public BizNumber getIwsMaitosikaiyakuhr92() {
        return iwsMaitosikaiyakuhr92;
    }

    public void setIwsMaitosikaiyakuhr92(BizNumber pIwsMaitosikaiyakuhr92) {
        iwsMaitosikaiyakuhr92 = pIwsMaitosikaiyakuhr92;
    }

    @Column(order = 195, length = 13)
    private BizNumber iwsMaitosikaiyakuhr93;

    public BizNumber getIwsMaitosikaiyakuhr93() {
        return iwsMaitosikaiyakuhr93;
    }

    public void setIwsMaitosikaiyakuhr93(BizNumber pIwsMaitosikaiyakuhr93) {
        iwsMaitosikaiyakuhr93 = pIwsMaitosikaiyakuhr93;
    }

    @Column(order = 196, length = 13)
    private BizNumber iwsMaitosikaiyakuhr94;

    public BizNumber getIwsMaitosikaiyakuhr94() {
        return iwsMaitosikaiyakuhr94;
    }

    public void setIwsMaitosikaiyakuhr94(BizNumber pIwsMaitosikaiyakuhr94) {
        iwsMaitosikaiyakuhr94 = pIwsMaitosikaiyakuhr94;
    }

    @Column(order = 197, length = 13)
    private BizNumber iwsMaitosikaiyakuhr95;

    public BizNumber getIwsMaitosikaiyakuhr95() {
        return iwsMaitosikaiyakuhr95;
    }

    public void setIwsMaitosikaiyakuhr95(BizNumber pIwsMaitosikaiyakuhr95) {
        iwsMaitosikaiyakuhr95 = pIwsMaitosikaiyakuhr95;
    }

    @Column(order = 198, length = 13)
    private BizNumber iwsMaitosikaiyakuhr96;

    public BizNumber getIwsMaitosikaiyakuhr96() {
        return iwsMaitosikaiyakuhr96;
    }

    public void setIwsMaitosikaiyakuhr96(BizNumber pIwsMaitosikaiyakuhr96) {
        iwsMaitosikaiyakuhr96 = pIwsMaitosikaiyakuhr96;
    }

    @Column(order = 199, length = 13)
    private BizNumber iwsMaitosikaiyakuhr97;

    public BizNumber getIwsMaitosikaiyakuhr97() {
        return iwsMaitosikaiyakuhr97;
    }

    public void setIwsMaitosikaiyakuhr97(BizNumber pIwsMaitosikaiyakuhr97) {
        iwsMaitosikaiyakuhr97 = pIwsMaitosikaiyakuhr97;
    }

    @Column(order = 200, length = 13)
    private BizNumber iwsMaitosikaiyakuhr98;

    public BizNumber getIwsMaitosikaiyakuhr98() {
        return iwsMaitosikaiyakuhr98;
    }

    public void setIwsMaitosikaiyakuhr98(BizNumber pIwsMaitosikaiyakuhr98) {
        iwsMaitosikaiyakuhr98 = pIwsMaitosikaiyakuhr98;
    }

    @Column(order = 201, length = 13)
    private BizNumber iwsMaitosikaiyakuhr99;

    public BizNumber getIwsMaitosikaiyakuhr99() {
        return iwsMaitosikaiyakuhr99;
    }

    public void setIwsMaitosikaiyakuhr99(BizNumber pIwsMaitosikaiyakuhr99) {
        iwsMaitosikaiyakuhr99 = pIwsMaitosikaiyakuhr99;
    }

    @Column(order = 202, length = 13)
    private BizNumber iwsMaitosisbs1;

    public BizNumber getIwsMaitosisbs1() {
        return iwsMaitosisbs1;
    }

    public void setIwsMaitosisbs1(BizNumber pIwsMaitosisbs1) {
        iwsMaitosisbs1 = pIwsMaitosisbs1;
    }

    @Column(order = 203, length = 13)
    private BizNumber iwsMaitosisbs2;

    public BizNumber getIwsMaitosisbs2() {
        return iwsMaitosisbs2;
    }

    public void setIwsMaitosisbs2(BizNumber pIwsMaitosisbs2) {
        iwsMaitosisbs2 = pIwsMaitosisbs2;
    }

    @Column(order = 204, length = 13)
    private BizNumber iwsMaitosisbs3;

    public BizNumber getIwsMaitosisbs3() {
        return iwsMaitosisbs3;
    }

    public void setIwsMaitosisbs3(BizNumber pIwsMaitosisbs3) {
        iwsMaitosisbs3 = pIwsMaitosisbs3;
    }

    @Column(order = 205, length = 13)
    private BizNumber iwsMaitosisbs4;

    public BizNumber getIwsMaitosisbs4() {
        return iwsMaitosisbs4;
    }

    public void setIwsMaitosisbs4(BizNumber pIwsMaitosisbs4) {
        iwsMaitosisbs4 = pIwsMaitosisbs4;
    }

    @Column(order = 206, length = 13)
    private BizNumber iwsMaitosisbs5;

    public BizNumber getIwsMaitosisbs5() {
        return iwsMaitosisbs5;
    }

    public void setIwsMaitosisbs5(BizNumber pIwsMaitosisbs5) {
        iwsMaitosisbs5 = pIwsMaitosisbs5;
    }

    @Column(order = 207, length = 13)
    private BizNumber iwsMaitosisbs6;

    public BizNumber getIwsMaitosisbs6() {
        return iwsMaitosisbs6;
    }

    public void setIwsMaitosisbs6(BizNumber pIwsMaitosisbs6) {
        iwsMaitosisbs6 = pIwsMaitosisbs6;
    }

    @Column(order = 208, length = 13)
    private BizNumber iwsMaitosisbs7;

    public BizNumber getIwsMaitosisbs7() {
        return iwsMaitosisbs7;
    }

    public void setIwsMaitosisbs7(BizNumber pIwsMaitosisbs7) {
        iwsMaitosisbs7 = pIwsMaitosisbs7;
    }

    @Column(order = 209, length = 13)
    private BizNumber iwsMaitosisbs8;

    public BizNumber getIwsMaitosisbs8() {
        return iwsMaitosisbs8;
    }

    public void setIwsMaitosisbs8(BizNumber pIwsMaitosisbs8) {
        iwsMaitosisbs8 = pIwsMaitosisbs8;
    }

    @Column(order = 210, length = 13)
    private BizNumber iwsMaitosisbs9;

    public BizNumber getIwsMaitosisbs9() {
        return iwsMaitosisbs9;
    }

    public void setIwsMaitosisbs9(BizNumber pIwsMaitosisbs9) {
        iwsMaitosisbs9 = pIwsMaitosisbs9;
    }

    @Column(order = 211, length = 13)
    private BizNumber iwsMaitosisbs10;

    public BizNumber getIwsMaitosisbs10() {
        return iwsMaitosisbs10;
    }

    public void setIwsMaitosisbs10(BizNumber pIwsMaitosisbs10) {
        iwsMaitosisbs10 = pIwsMaitosisbs10;
    }

    @Column(order = 212, length = 13)
    private BizNumber iwsMaitosisbs11;

    public BizNumber getIwsMaitosisbs11() {
        return iwsMaitosisbs11;
    }

    public void setIwsMaitosisbs11(BizNumber pIwsMaitosisbs11) {
        iwsMaitosisbs11 = pIwsMaitosisbs11;
    }

    @Column(order = 213, length = 13)
    private BizNumber iwsMaitosisbs12;

    public BizNumber getIwsMaitosisbs12() {
        return iwsMaitosisbs12;
    }

    public void setIwsMaitosisbs12(BizNumber pIwsMaitosisbs12) {
        iwsMaitosisbs12 = pIwsMaitosisbs12;
    }

    @Column(order = 214, length = 13)
    private BizNumber iwsMaitosisbs13;

    public BizNumber getIwsMaitosisbs13() {
        return iwsMaitosisbs13;
    }

    public void setIwsMaitosisbs13(BizNumber pIwsMaitosisbs13) {
        iwsMaitosisbs13 = pIwsMaitosisbs13;
    }

    @Column(order = 215, length = 13)
    private BizNumber iwsMaitosisbs14;

    public BizNumber getIwsMaitosisbs14() {
        return iwsMaitosisbs14;
    }

    public void setIwsMaitosisbs14(BizNumber pIwsMaitosisbs14) {
        iwsMaitosisbs14 = pIwsMaitosisbs14;
    }

    @Column(order = 216, length = 13)
    private BizNumber iwsMaitosisbs15;

    public BizNumber getIwsMaitosisbs15() {
        return iwsMaitosisbs15;
    }

    public void setIwsMaitosisbs15(BizNumber pIwsMaitosisbs15) {
        iwsMaitosisbs15 = pIwsMaitosisbs15;
    }

    @Column(order = 217, length = 13)
    private BizNumber iwsMaitosisbs16;

    public BizNumber getIwsMaitosisbs16() {
        return iwsMaitosisbs16;
    }

    public void setIwsMaitosisbs16(BizNumber pIwsMaitosisbs16) {
        iwsMaitosisbs16 = pIwsMaitosisbs16;
    }

    @Column(order = 218, length = 13)
    private BizNumber iwsMaitosisbs17;

    public BizNumber getIwsMaitosisbs17() {
        return iwsMaitosisbs17;
    }

    public void setIwsMaitosisbs17(BizNumber pIwsMaitosisbs17) {
        iwsMaitosisbs17 = pIwsMaitosisbs17;
    }

    @Column(order = 219, length = 13)
    private BizNumber iwsMaitosisbs18;

    public BizNumber getIwsMaitosisbs18() {
        return iwsMaitosisbs18;
    }

    public void setIwsMaitosisbs18(BizNumber pIwsMaitosisbs18) {
        iwsMaitosisbs18 = pIwsMaitosisbs18;
    }

    @Column(order = 220, length = 13)
    private BizNumber iwsMaitosisbs19;

    public BizNumber getIwsMaitosisbs19() {
        return iwsMaitosisbs19;
    }

    public void setIwsMaitosisbs19(BizNumber pIwsMaitosisbs19) {
        iwsMaitosisbs19 = pIwsMaitosisbs19;
    }

    @Column(order = 221, length = 13)
    private BizNumber iwsMaitosisbs20;

    public BizNumber getIwsMaitosisbs20() {
        return iwsMaitosisbs20;
    }

    public void setIwsMaitosisbs20(BizNumber pIwsMaitosisbs20) {
        iwsMaitosisbs20 = pIwsMaitosisbs20;
    }

    @Column(order = 222, length = 13)
    private BizNumber iwsMaitosisbs21;

    public BizNumber getIwsMaitosisbs21() {
        return iwsMaitosisbs21;
    }

    public void setIwsMaitosisbs21(BizNumber pIwsMaitosisbs21) {
        iwsMaitosisbs21 = pIwsMaitosisbs21;
    }

    @Column(order = 223, length = 13)
    private BizNumber iwsMaitosisbs22;

    public BizNumber getIwsMaitosisbs22() {
        return iwsMaitosisbs22;
    }

    public void setIwsMaitosisbs22(BizNumber pIwsMaitosisbs22) {
        iwsMaitosisbs22 = pIwsMaitosisbs22;
    }

    @Column(order = 224, length = 13)
    private BizNumber iwsMaitosisbs23;

    public BizNumber getIwsMaitosisbs23() {
        return iwsMaitosisbs23;
    }

    public void setIwsMaitosisbs23(BizNumber pIwsMaitosisbs23) {
        iwsMaitosisbs23 = pIwsMaitosisbs23;
    }

    @Column(order = 225, length = 13)
    private BizNumber iwsMaitosisbs24;

    public BizNumber getIwsMaitosisbs24() {
        return iwsMaitosisbs24;
    }

    public void setIwsMaitosisbs24(BizNumber pIwsMaitosisbs24) {
        iwsMaitosisbs24 = pIwsMaitosisbs24;
    }

    @Column(order = 226, length = 13)
    private BizNumber iwsMaitosisbs25;

    public BizNumber getIwsMaitosisbs25() {
        return iwsMaitosisbs25;
    }

    public void setIwsMaitosisbs25(BizNumber pIwsMaitosisbs25) {
        iwsMaitosisbs25 = pIwsMaitosisbs25;
    }

    @Column(order = 227, length = 13)
    private BizNumber iwsMaitosisbs26;

    public BizNumber getIwsMaitosisbs26() {
        return iwsMaitosisbs26;
    }

    public void setIwsMaitosisbs26(BizNumber pIwsMaitosisbs26) {
        iwsMaitosisbs26 = pIwsMaitosisbs26;
    }

    @Column(order = 228, length = 13)
    private BizNumber iwsMaitosisbs27;

    public BizNumber getIwsMaitosisbs27() {
        return iwsMaitosisbs27;
    }

    public void setIwsMaitosisbs27(BizNumber pIwsMaitosisbs27) {
        iwsMaitosisbs27 = pIwsMaitosisbs27;
    }

    @Column(order = 229, length = 13)
    private BizNumber iwsMaitosisbs28;

    public BizNumber getIwsMaitosisbs28() {
        return iwsMaitosisbs28;
    }

    public void setIwsMaitosisbs28(BizNumber pIwsMaitosisbs28) {
        iwsMaitosisbs28 = pIwsMaitosisbs28;
    }

    @Column(order = 230, length = 13)
    private BizNumber iwsMaitosisbs29;

    public BizNumber getIwsMaitosisbs29() {
        return iwsMaitosisbs29;
    }

    public void setIwsMaitosisbs29(BizNumber pIwsMaitosisbs29) {
        iwsMaitosisbs29 = pIwsMaitosisbs29;
    }

    @Column(order = 231, length = 13)
    private BizNumber iwsMaitosisbs30;

    public BizNumber getIwsMaitosisbs30() {
        return iwsMaitosisbs30;
    }

    public void setIwsMaitosisbs30(BizNumber pIwsMaitosisbs30) {
        iwsMaitosisbs30 = pIwsMaitosisbs30;
    }

    @Column(order = 232, length = 13)
    private BizNumber iwsMaitosisbs31;

    public BizNumber getIwsMaitosisbs31() {
        return iwsMaitosisbs31;
    }

    public void setIwsMaitosisbs31(BizNumber pIwsMaitosisbs31) {
        iwsMaitosisbs31 = pIwsMaitosisbs31;
    }

    @Column(order = 233, length = 13)
    private BizNumber iwsMaitosisbs32;

    public BizNumber getIwsMaitosisbs32() {
        return iwsMaitosisbs32;
    }

    public void setIwsMaitosisbs32(BizNumber pIwsMaitosisbs32) {
        iwsMaitosisbs32 = pIwsMaitosisbs32;
    }

    @Column(order = 234, length = 13)
    private BizNumber iwsMaitosisbs33;

    public BizNumber getIwsMaitosisbs33() {
        return iwsMaitosisbs33;
    }

    public void setIwsMaitosisbs33(BizNumber pIwsMaitosisbs33) {
        iwsMaitosisbs33 = pIwsMaitosisbs33;
    }

    @Column(order = 235, length = 13)
    private BizNumber iwsMaitosisbs34;

    public BizNumber getIwsMaitosisbs34() {
        return iwsMaitosisbs34;
    }

    public void setIwsMaitosisbs34(BizNumber pIwsMaitosisbs34) {
        iwsMaitosisbs34 = pIwsMaitosisbs34;
    }

    @Column(order = 236, length = 13)
    private BizNumber iwsMaitosisbs35;

    public BizNumber getIwsMaitosisbs35() {
        return iwsMaitosisbs35;
    }

    public void setIwsMaitosisbs35(BizNumber pIwsMaitosisbs35) {
        iwsMaitosisbs35 = pIwsMaitosisbs35;
    }

    @Column(order = 237, length = 13)
    private BizNumber iwsMaitosisbs36;

    public BizNumber getIwsMaitosisbs36() {
        return iwsMaitosisbs36;
    }

    public void setIwsMaitosisbs36(BizNumber pIwsMaitosisbs36) {
        iwsMaitosisbs36 = pIwsMaitosisbs36;
    }

    @Column(order = 238, length = 13)
    private BizNumber iwsMaitosisbs37;

    public BizNumber getIwsMaitosisbs37() {
        return iwsMaitosisbs37;
    }

    public void setIwsMaitosisbs37(BizNumber pIwsMaitosisbs37) {
        iwsMaitosisbs37 = pIwsMaitosisbs37;
    }

    @Column(order = 239, length = 13)
    private BizNumber iwsMaitosisbs38;

    public BizNumber getIwsMaitosisbs38() {
        return iwsMaitosisbs38;
    }

    public void setIwsMaitosisbs38(BizNumber pIwsMaitosisbs38) {
        iwsMaitosisbs38 = pIwsMaitosisbs38;
    }

    @Column(order = 240, length = 13)
    private BizNumber iwsMaitosisbs39;

    public BizNumber getIwsMaitosisbs39() {
        return iwsMaitosisbs39;
    }

    public void setIwsMaitosisbs39(BizNumber pIwsMaitosisbs39) {
        iwsMaitosisbs39 = pIwsMaitosisbs39;
    }

    @Column(order = 241, length = 13)
    private BizNumber iwsMaitosisbs40;

    public BizNumber getIwsMaitosisbs40() {
        return iwsMaitosisbs40;
    }

    public void setIwsMaitosisbs40(BizNumber pIwsMaitosisbs40) {
        iwsMaitosisbs40 = pIwsMaitosisbs40;
    }

    @Column(order = 242, length = 13)
    private BizNumber iwsMaitosisbs41;

    public BizNumber getIwsMaitosisbs41() {
        return iwsMaitosisbs41;
    }

    public void setIwsMaitosisbs41(BizNumber pIwsMaitosisbs41) {
        iwsMaitosisbs41 = pIwsMaitosisbs41;
    }

    @Column(order = 243, length = 13)
    private BizNumber iwsMaitosisbs42;

    public BizNumber getIwsMaitosisbs42() {
        return iwsMaitosisbs42;
    }

    public void setIwsMaitosisbs42(BizNumber pIwsMaitosisbs42) {
        iwsMaitosisbs42 = pIwsMaitosisbs42;
    }

    @Column(order = 244, length = 13)
    private BizNumber iwsMaitosisbs43;

    public BizNumber getIwsMaitosisbs43() {
        return iwsMaitosisbs43;
    }

    public void setIwsMaitosisbs43(BizNumber pIwsMaitosisbs43) {
        iwsMaitosisbs43 = pIwsMaitosisbs43;
    }

    @Column(order = 245, length = 13)
    private BizNumber iwsMaitosisbs44;

    public BizNumber getIwsMaitosisbs44() {
        return iwsMaitosisbs44;
    }

    public void setIwsMaitosisbs44(BizNumber pIwsMaitosisbs44) {
        iwsMaitosisbs44 = pIwsMaitosisbs44;
    }

    @Column(order = 246, length = 13)
    private BizNumber iwsMaitosisbs45;

    public BizNumber getIwsMaitosisbs45() {
        return iwsMaitosisbs45;
    }

    public void setIwsMaitosisbs45(BizNumber pIwsMaitosisbs45) {
        iwsMaitosisbs45 = pIwsMaitosisbs45;
    }

    @Column(order = 247, length = 13)
    private BizNumber iwsMaitosisbs46;

    public BizNumber getIwsMaitosisbs46() {
        return iwsMaitosisbs46;
    }

    public void setIwsMaitosisbs46(BizNumber pIwsMaitosisbs46) {
        iwsMaitosisbs46 = pIwsMaitosisbs46;
    }

    @Column(order = 248, length = 13)
    private BizNumber iwsMaitosisbs47;

    public BizNumber getIwsMaitosisbs47() {
        return iwsMaitosisbs47;
    }

    public void setIwsMaitosisbs47(BizNumber pIwsMaitosisbs47) {
        iwsMaitosisbs47 = pIwsMaitosisbs47;
    }

    @Column(order = 249, length = 13)
    private BizNumber iwsMaitosisbs48;

    public BizNumber getIwsMaitosisbs48() {
        return iwsMaitosisbs48;
    }

    public void setIwsMaitosisbs48(BizNumber pIwsMaitosisbs48) {
        iwsMaitosisbs48 = pIwsMaitosisbs48;
    }

    @Column(order = 250, length = 13)
    private BizNumber iwsMaitosisbs49;

    public BizNumber getIwsMaitosisbs49() {
        return iwsMaitosisbs49;
    }

    public void setIwsMaitosisbs49(BizNumber pIwsMaitosisbs49) {
        iwsMaitosisbs49 = pIwsMaitosisbs49;
    }

    @Column(order = 251, length = 13)
    private BizNumber iwsMaitosisbs50;

    public BizNumber getIwsMaitosisbs50() {
        return iwsMaitosisbs50;
    }

    public void setIwsMaitosisbs50(BizNumber pIwsMaitosisbs50) {
        iwsMaitosisbs50 = pIwsMaitosisbs50;
    }

    @Column(order = 252, length = 13)
    private BizNumber iwsMaitosisbs51;

    public BizNumber getIwsMaitosisbs51() {
        return iwsMaitosisbs51;
    }

    public void setIwsMaitosisbs51(BizNumber pIwsMaitosisbs51) {
        iwsMaitosisbs51 = pIwsMaitosisbs51;
    }

    @Column(order = 253, length = 13)
    private BizNumber iwsMaitosisbs52;

    public BizNumber getIwsMaitosisbs52() {
        return iwsMaitosisbs52;
    }

    public void setIwsMaitosisbs52(BizNumber pIwsMaitosisbs52) {
        iwsMaitosisbs52 = pIwsMaitosisbs52;
    }

    @Column(order = 254, length = 13)
    private BizNumber iwsMaitosisbs53;

    public BizNumber getIwsMaitosisbs53() {
        return iwsMaitosisbs53;
    }

    public void setIwsMaitosisbs53(BizNumber pIwsMaitosisbs53) {
        iwsMaitosisbs53 = pIwsMaitosisbs53;
    }

    @Column(order = 255, length = 13)
    private BizNumber iwsMaitosisbs54;

    public BizNumber getIwsMaitosisbs54() {
        return iwsMaitosisbs54;
    }

    public void setIwsMaitosisbs54(BizNumber pIwsMaitosisbs54) {
        iwsMaitosisbs54 = pIwsMaitosisbs54;
    }

    @Column(order = 256, length = 13)
    private BizNumber iwsMaitosisbs55;

    public BizNumber getIwsMaitosisbs55() {
        return iwsMaitosisbs55;
    }

    public void setIwsMaitosisbs55(BizNumber pIwsMaitosisbs55) {
        iwsMaitosisbs55 = pIwsMaitosisbs55;
    }

    @Column(order = 257, length = 13)
    private BizNumber iwsMaitosisbs56;

    public BizNumber getIwsMaitosisbs56() {
        return iwsMaitosisbs56;
    }

    public void setIwsMaitosisbs56(BizNumber pIwsMaitosisbs56) {
        iwsMaitosisbs56 = pIwsMaitosisbs56;
    }

    @Column(order = 258, length = 13)
    private BizNumber iwsMaitosisbs57;

    public BizNumber getIwsMaitosisbs57() {
        return iwsMaitosisbs57;
    }

    public void setIwsMaitosisbs57(BizNumber pIwsMaitosisbs57) {
        iwsMaitosisbs57 = pIwsMaitosisbs57;
    }

    @Column(order = 259, length = 13)
    private BizNumber iwsMaitosisbs58;

    public BizNumber getIwsMaitosisbs58() {
        return iwsMaitosisbs58;
    }

    public void setIwsMaitosisbs58(BizNumber pIwsMaitosisbs58) {
        iwsMaitosisbs58 = pIwsMaitosisbs58;
    }

    @Column(order = 260, length = 13)
    private BizNumber iwsMaitosisbs59;

    public BizNumber getIwsMaitosisbs59() {
        return iwsMaitosisbs59;
    }

    public void setIwsMaitosisbs59(BizNumber pIwsMaitosisbs59) {
        iwsMaitosisbs59 = pIwsMaitosisbs59;
    }

    @Column(order = 261, length = 13)
    private BizNumber iwsMaitosisbs60;

    public BizNumber getIwsMaitosisbs60() {
        return iwsMaitosisbs60;
    }

    public void setIwsMaitosisbs60(BizNumber pIwsMaitosisbs60) {
        iwsMaitosisbs60 = pIwsMaitosisbs60;
    }

    @Column(order = 262, length = 13)
    private BizNumber iwsMaitosisbs61;

    public BizNumber getIwsMaitosisbs61() {
        return iwsMaitosisbs61;
    }

    public void setIwsMaitosisbs61(BizNumber pIwsMaitosisbs61) {
        iwsMaitosisbs61 = pIwsMaitosisbs61;
    }

    @Column(order = 263, length = 13)
    private BizNumber iwsMaitosisbs62;

    public BizNumber getIwsMaitosisbs62() {
        return iwsMaitosisbs62;
    }

    public void setIwsMaitosisbs62(BizNumber pIwsMaitosisbs62) {
        iwsMaitosisbs62 = pIwsMaitosisbs62;
    }

    @Column(order = 264, length = 13)
    private BizNumber iwsMaitosisbs63;

    public BizNumber getIwsMaitosisbs63() {
        return iwsMaitosisbs63;
    }

    public void setIwsMaitosisbs63(BizNumber pIwsMaitosisbs63) {
        iwsMaitosisbs63 = pIwsMaitosisbs63;
    }

    @Column(order = 265, length = 13)
    private BizNumber iwsMaitosisbs64;

    public BizNumber getIwsMaitosisbs64() {
        return iwsMaitosisbs64;
    }

    public void setIwsMaitosisbs64(BizNumber pIwsMaitosisbs64) {
        iwsMaitosisbs64 = pIwsMaitosisbs64;
    }

    @Column(order = 266, length = 13)
    private BizNumber iwsMaitosisbs65;

    public BizNumber getIwsMaitosisbs65() {
        return iwsMaitosisbs65;
    }

    public void setIwsMaitosisbs65(BizNumber pIwsMaitosisbs65) {
        iwsMaitosisbs65 = pIwsMaitosisbs65;
    }

    @Column(order = 267, length = 13)
    private BizNumber iwsMaitosisbs66;

    public BizNumber getIwsMaitosisbs66() {
        return iwsMaitosisbs66;
    }

    public void setIwsMaitosisbs66(BizNumber pIwsMaitosisbs66) {
        iwsMaitosisbs66 = pIwsMaitosisbs66;
    }

    @Column(order = 268, length = 13)
    private BizNumber iwsMaitosisbs67;

    public BizNumber getIwsMaitosisbs67() {
        return iwsMaitosisbs67;
    }

    public void setIwsMaitosisbs67(BizNumber pIwsMaitosisbs67) {
        iwsMaitosisbs67 = pIwsMaitosisbs67;
    }

    @Column(order = 269, length = 13)
    private BizNumber iwsMaitosisbs68;

    public BizNumber getIwsMaitosisbs68() {
        return iwsMaitosisbs68;
    }

    public void setIwsMaitosisbs68(BizNumber pIwsMaitosisbs68) {
        iwsMaitosisbs68 = pIwsMaitosisbs68;
    }

    @Column(order = 270, length = 13)
    private BizNumber iwsMaitosisbs69;

    public BizNumber getIwsMaitosisbs69() {
        return iwsMaitosisbs69;
    }

    public void setIwsMaitosisbs69(BizNumber pIwsMaitosisbs69) {
        iwsMaitosisbs69 = pIwsMaitosisbs69;
    }

    @Column(order = 271, length = 13)
    private BizNumber iwsMaitosisbs70;

    public BizNumber getIwsMaitosisbs70() {
        return iwsMaitosisbs70;
    }

    public void setIwsMaitosisbs70(BizNumber pIwsMaitosisbs70) {
        iwsMaitosisbs70 = pIwsMaitosisbs70;
    }

    @Column(order = 272, length = 13)
    private BizNumber iwsMaitosisbs71;

    public BizNumber getIwsMaitosisbs71() {
        return iwsMaitosisbs71;
    }

    public void setIwsMaitosisbs71(BizNumber pIwsMaitosisbs71) {
        iwsMaitosisbs71 = pIwsMaitosisbs71;
    }

    @Column(order = 273, length = 13)
    private BizNumber iwsMaitosisbs72;

    public BizNumber getIwsMaitosisbs72() {
        return iwsMaitosisbs72;
    }

    public void setIwsMaitosisbs72(BizNumber pIwsMaitosisbs72) {
        iwsMaitosisbs72 = pIwsMaitosisbs72;
    }

    @Column(order = 274, length = 13)
    private BizNumber iwsMaitosisbs73;

    public BizNumber getIwsMaitosisbs73() {
        return iwsMaitosisbs73;
    }

    public void setIwsMaitosisbs73(BizNumber pIwsMaitosisbs73) {
        iwsMaitosisbs73 = pIwsMaitosisbs73;
    }

    @Column(order = 275, length = 13)
    private BizNumber iwsMaitosisbs74;

    public BizNumber getIwsMaitosisbs74() {
        return iwsMaitosisbs74;
    }

    public void setIwsMaitosisbs74(BizNumber pIwsMaitosisbs74) {
        iwsMaitosisbs74 = pIwsMaitosisbs74;
    }

    @Column(order = 276, length = 13)
    private BizNumber iwsMaitosisbs75;

    public BizNumber getIwsMaitosisbs75() {
        return iwsMaitosisbs75;
    }

    public void setIwsMaitosisbs75(BizNumber pIwsMaitosisbs75) {
        iwsMaitosisbs75 = pIwsMaitosisbs75;
    }

    @Column(order = 277, length = 13)
    private BizNumber iwsMaitosisbs76;

    public BizNumber getIwsMaitosisbs76() {
        return iwsMaitosisbs76;
    }

    public void setIwsMaitosisbs76(BizNumber pIwsMaitosisbs76) {
        iwsMaitosisbs76 = pIwsMaitosisbs76;
    }

    @Column(order = 278, length = 13)
    private BizNumber iwsMaitosisbs77;

    public BizNumber getIwsMaitosisbs77() {
        return iwsMaitosisbs77;
    }

    public void setIwsMaitosisbs77(BizNumber pIwsMaitosisbs77) {
        iwsMaitosisbs77 = pIwsMaitosisbs77;
    }

    @Column(order = 279, length = 13)
    private BizNumber iwsMaitosisbs78;

    public BizNumber getIwsMaitosisbs78() {
        return iwsMaitosisbs78;
    }

    public void setIwsMaitosisbs78(BizNumber pIwsMaitosisbs78) {
        iwsMaitosisbs78 = pIwsMaitosisbs78;
    }

    @Column(order = 280, length = 13)
    private BizNumber iwsMaitosisbs79;

    public BizNumber getIwsMaitosisbs79() {
        return iwsMaitosisbs79;
    }

    public void setIwsMaitosisbs79(BizNumber pIwsMaitosisbs79) {
        iwsMaitosisbs79 = pIwsMaitosisbs79;
    }

    @Column(order = 281, length = 13)
    private BizNumber iwsMaitosisbs80;

    public BizNumber getIwsMaitosisbs80() {
        return iwsMaitosisbs80;
    }

    public void setIwsMaitosisbs80(BizNumber pIwsMaitosisbs80) {
        iwsMaitosisbs80 = pIwsMaitosisbs80;
    }

    @Column(order = 282, length = 13)
    private BizNumber iwsMaitosisbs81;

    public BizNumber getIwsMaitosisbs81() {
        return iwsMaitosisbs81;
    }

    public void setIwsMaitosisbs81(BizNumber pIwsMaitosisbs81) {
        iwsMaitosisbs81 = pIwsMaitosisbs81;
    }

    @Column(order = 283, length = 13)
    private BizNumber iwsMaitosisbs82;

    public BizNumber getIwsMaitosisbs82() {
        return iwsMaitosisbs82;
    }

    public void setIwsMaitosisbs82(BizNumber pIwsMaitosisbs82) {
        iwsMaitosisbs82 = pIwsMaitosisbs82;
    }

    @Column(order = 284, length = 13)
    private BizNumber iwsMaitosisbs83;

    public BizNumber getIwsMaitosisbs83() {
        return iwsMaitosisbs83;
    }

    public void setIwsMaitosisbs83(BizNumber pIwsMaitosisbs83) {
        iwsMaitosisbs83 = pIwsMaitosisbs83;
    }

    @Column(order = 285, length = 13)
    private BizNumber iwsMaitosisbs84;

    public BizNumber getIwsMaitosisbs84() {
        return iwsMaitosisbs84;
    }

    public void setIwsMaitosisbs84(BizNumber pIwsMaitosisbs84) {
        iwsMaitosisbs84 = pIwsMaitosisbs84;
    }

    @Column(order = 286, length = 13)
    private BizNumber iwsMaitosisbs85;

    public BizNumber getIwsMaitosisbs85() {
        return iwsMaitosisbs85;
    }

    public void setIwsMaitosisbs85(BizNumber pIwsMaitosisbs85) {
        iwsMaitosisbs85 = pIwsMaitosisbs85;
    }

    @Column(order = 287, length = 13)
    private BizNumber iwsMaitosisbs86;

    public BizNumber getIwsMaitosisbs86() {
        return iwsMaitosisbs86;
    }

    public void setIwsMaitosisbs86(BizNumber pIwsMaitosisbs86) {
        iwsMaitosisbs86 = pIwsMaitosisbs86;
    }

    @Column(order = 288, length = 13)
    private BizNumber iwsMaitosisbs87;

    public BizNumber getIwsMaitosisbs87() {
        return iwsMaitosisbs87;
    }

    public void setIwsMaitosisbs87(BizNumber pIwsMaitosisbs87) {
        iwsMaitosisbs87 = pIwsMaitosisbs87;
    }

    @Column(order = 289, length = 13)
    private BizNumber iwsMaitosisbs88;

    public BizNumber getIwsMaitosisbs88() {
        return iwsMaitosisbs88;
    }

    public void setIwsMaitosisbs88(BizNumber pIwsMaitosisbs88) {
        iwsMaitosisbs88 = pIwsMaitosisbs88;
    }

    @Column(order = 290, length = 13)
    private BizNumber iwsMaitosisbs89;

    public BizNumber getIwsMaitosisbs89() {
        return iwsMaitosisbs89;
    }

    public void setIwsMaitosisbs89(BizNumber pIwsMaitosisbs89) {
        iwsMaitosisbs89 = pIwsMaitosisbs89;
    }

    @Column(order = 291, length = 13)
    private BizNumber iwsMaitosisbs90;

    public BizNumber getIwsMaitosisbs90() {
        return iwsMaitosisbs90;
    }

    public void setIwsMaitosisbs90(BizNumber pIwsMaitosisbs90) {
        iwsMaitosisbs90 = pIwsMaitosisbs90;
    }

    @Column(order = 292, length = 13)
    private BizNumber iwsMaitosisbs91;

    public BizNumber getIwsMaitosisbs91() {
        return iwsMaitosisbs91;
    }

    public void setIwsMaitosisbs91(BizNumber pIwsMaitosisbs91) {
        iwsMaitosisbs91 = pIwsMaitosisbs91;
    }

    @Column(order = 293, length = 13)
    private BizNumber iwsMaitosisbs92;

    public BizNumber getIwsMaitosisbs92() {
        return iwsMaitosisbs92;
    }

    public void setIwsMaitosisbs92(BizNumber pIwsMaitosisbs92) {
        iwsMaitosisbs92 = pIwsMaitosisbs92;
    }

    @Column(order = 294, length = 13)
    private BizNumber iwsMaitosisbs93;

    public BizNumber getIwsMaitosisbs93() {
        return iwsMaitosisbs93;
    }

    public void setIwsMaitosisbs93(BizNumber pIwsMaitosisbs93) {
        iwsMaitosisbs93 = pIwsMaitosisbs93;
    }

    @Column(order = 295, length = 13)
    private BizNumber iwsMaitosisbs94;

    public BizNumber getIwsMaitosisbs94() {
        return iwsMaitosisbs94;
    }

    public void setIwsMaitosisbs94(BizNumber pIwsMaitosisbs94) {
        iwsMaitosisbs94 = pIwsMaitosisbs94;
    }

    @Column(order = 296, length = 13)
    private BizNumber iwsMaitosisbs95;

    public BizNumber getIwsMaitosisbs95() {
        return iwsMaitosisbs95;
    }

    public void setIwsMaitosisbs95(BizNumber pIwsMaitosisbs95) {
        iwsMaitosisbs95 = pIwsMaitosisbs95;
    }

    @Column(order = 297, length = 13)
    private BizNumber iwsMaitosisbs96;

    public BizNumber getIwsMaitosisbs96() {
        return iwsMaitosisbs96;
    }

    public void setIwsMaitosisbs96(BizNumber pIwsMaitosisbs96) {
        iwsMaitosisbs96 = pIwsMaitosisbs96;
    }

    @Column(order = 298, length = 13)
    private BizNumber iwsMaitosisbs97;

    public BizNumber getIwsMaitosisbs97() {
        return iwsMaitosisbs97;
    }

    public void setIwsMaitosisbs97(BizNumber pIwsMaitosisbs97) {
        iwsMaitosisbs97 = pIwsMaitosisbs97;
    }

    @Column(order = 299, length = 13)
    private BizNumber iwsMaitosisbs98;

    public BizNumber getIwsMaitosisbs98() {
        return iwsMaitosisbs98;
    }

    public void setIwsMaitosisbs98(BizNumber pIwsMaitosisbs98) {
        iwsMaitosisbs98 = pIwsMaitosisbs98;
    }

    @Column(order = 300, length = 13)
    private BizNumber iwsMaitosisbs99;

    public BizNumber getIwsMaitosisbs99() {
        return iwsMaitosisbs99;
    }

    public void setIwsMaitosisbs99(BizNumber pIwsMaitosisbs99) {
        iwsMaitosisbs99 = pIwsMaitosisbs99;
    }

    @Column(order = 301, length = 13)
    private BizNumber iwsMaitosiznnzndk1;

    public BizNumber getIwsMaitosiznnzndk1() {
        return iwsMaitosiznnzndk1;
    }

    public void setIwsMaitosiznnzndk1(BizNumber pIwsMaitosiznnzndk1) {
        iwsMaitosiznnzndk1 = pIwsMaitosiznnzndk1;
    }

    @Column(order = 302, length = 13)
    private BizNumber iwsMaitosiznnzndk2;

    public BizNumber getIwsMaitosiznnzndk2() {
        return iwsMaitosiznnzndk2;
    }

    public void setIwsMaitosiznnzndk2(BizNumber pIwsMaitosiznnzndk2) {
        iwsMaitosiznnzndk2 = pIwsMaitosiznnzndk2;
    }

    @Column(order = 303, length = 13)
    private BizNumber iwsMaitosiznnzndk3;

    public BizNumber getIwsMaitosiznnzndk3() {
        return iwsMaitosiznnzndk3;
    }

    public void setIwsMaitosiznnzndk3(BizNumber pIwsMaitosiznnzndk3) {
        iwsMaitosiznnzndk3 = pIwsMaitosiznnzndk3;
    }

    @Column(order = 304, length = 13)
    private BizNumber iwsMaitosiznnzndk4;

    public BizNumber getIwsMaitosiznnzndk4() {
        return iwsMaitosiznnzndk4;
    }

    public void setIwsMaitosiznnzndk4(BizNumber pIwsMaitosiznnzndk4) {
        iwsMaitosiznnzndk4 = pIwsMaitosiznnzndk4;
    }

    @Column(order = 305, length = 13)
    private BizNumber iwsMaitosiznnzndk5;

    public BizNumber getIwsMaitosiznnzndk5() {
        return iwsMaitosiznnzndk5;
    }

    public void setIwsMaitosiznnzndk5(BizNumber pIwsMaitosiznnzndk5) {
        iwsMaitosiznnzndk5 = pIwsMaitosiznnzndk5;
    }

    @Column(order = 306, length = 13)
    private BizNumber iwsMaitosiznnzndk6;

    public BizNumber getIwsMaitosiznnzndk6() {
        return iwsMaitosiznnzndk6;
    }

    public void setIwsMaitosiznnzndk6(BizNumber pIwsMaitosiznnzndk6) {
        iwsMaitosiznnzndk6 = pIwsMaitosiznnzndk6;
    }

    @Column(order = 307, length = 13)
    private BizNumber iwsMaitosiznnzndk7;

    public BizNumber getIwsMaitosiznnzndk7() {
        return iwsMaitosiznnzndk7;
    }

    public void setIwsMaitosiznnzndk7(BizNumber pIwsMaitosiznnzndk7) {
        iwsMaitosiznnzndk7 = pIwsMaitosiznnzndk7;
    }

    @Column(order = 308, length = 13)
    private BizNumber iwsMaitosiznnzndk8;

    public BizNumber getIwsMaitosiznnzndk8() {
        return iwsMaitosiznnzndk8;
    }

    public void setIwsMaitosiznnzndk8(BizNumber pIwsMaitosiznnzndk8) {
        iwsMaitosiznnzndk8 = pIwsMaitosiznnzndk8;
    }

    @Column(order = 309, length = 13)
    private BizNumber iwsMaitosiznnzndk9;

    public BizNumber getIwsMaitosiznnzndk9() {
        return iwsMaitosiznnzndk9;
    }

    public void setIwsMaitosiznnzndk9(BizNumber pIwsMaitosiznnzndk9) {
        iwsMaitosiznnzndk9 = pIwsMaitosiznnzndk9;
    }

    @Column(order = 310, length = 13)
    private BizNumber iwsMaitosiznnzndk10;

    public BizNumber getIwsMaitosiznnzndk10() {
        return iwsMaitosiznnzndk10;
    }

    public void setIwsMaitosiznnzndk10(BizNumber pIwsMaitosiznnzndk10) {
        iwsMaitosiznnzndk10 = pIwsMaitosiznnzndk10;
    }

    @Column(order = 311, length = 13)
    private BizNumber iwsMaitosiznnzndk11;

    public BizNumber getIwsMaitosiznnzndk11() {
        return iwsMaitosiznnzndk11;
    }

    public void setIwsMaitosiznnzndk11(BizNumber pIwsMaitosiznnzndk11) {
        iwsMaitosiznnzndk11 = pIwsMaitosiznnzndk11;
    }

    @Column(order = 312, length = 13)
    private BizNumber iwsMaitosiznnzndk12;

    public BizNumber getIwsMaitosiznnzndk12() {
        return iwsMaitosiznnzndk12;
    }

    public void setIwsMaitosiznnzndk12(BizNumber pIwsMaitosiznnzndk12) {
        iwsMaitosiznnzndk12 = pIwsMaitosiznnzndk12;
    }

    @Column(order = 313, length = 13)
    private BizNumber iwsMaitosiznnzndk13;

    public BizNumber getIwsMaitosiznnzndk13() {
        return iwsMaitosiznnzndk13;
    }

    public void setIwsMaitosiznnzndk13(BizNumber pIwsMaitosiznnzndk13) {
        iwsMaitosiznnzndk13 = pIwsMaitosiznnzndk13;
    }

    @Column(order = 314, length = 13)
    private BizNumber iwsMaitosiznnzndk14;

    public BizNumber getIwsMaitosiznnzndk14() {
        return iwsMaitosiznnzndk14;
    }

    public void setIwsMaitosiznnzndk14(BizNumber pIwsMaitosiznnzndk14) {
        iwsMaitosiznnzndk14 = pIwsMaitosiznnzndk14;
    }

    @Column(order = 315, length = 13)
    private BizNumber iwsMaitosiznnzndk15;

    public BizNumber getIwsMaitosiznnzndk15() {
        return iwsMaitosiznnzndk15;
    }

    public void setIwsMaitosiznnzndk15(BizNumber pIwsMaitosiznnzndk15) {
        iwsMaitosiznnzndk15 = pIwsMaitosiznnzndk15;
    }

    @Column(order = 316, length = 13)
    private BizNumber iwsMaitosiznnzndk16;

    public BizNumber getIwsMaitosiznnzndk16() {
        return iwsMaitosiznnzndk16;
    }

    public void setIwsMaitosiznnzndk16(BizNumber pIwsMaitosiznnzndk16) {
        iwsMaitosiznnzndk16 = pIwsMaitosiznnzndk16;
    }

    @Column(order = 317, length = 13)
    private BizNumber iwsMaitosiznnzndk17;

    public BizNumber getIwsMaitosiznnzndk17() {
        return iwsMaitosiznnzndk17;
    }

    public void setIwsMaitosiznnzndk17(BizNumber pIwsMaitosiznnzndk17) {
        iwsMaitosiznnzndk17 = pIwsMaitosiznnzndk17;
    }

    @Column(order = 318, length = 13)
    private BizNumber iwsMaitosiznnzndk18;

    public BizNumber getIwsMaitosiznnzndk18() {
        return iwsMaitosiznnzndk18;
    }

    public void setIwsMaitosiznnzndk18(BizNumber pIwsMaitosiznnzndk18) {
        iwsMaitosiznnzndk18 = pIwsMaitosiznnzndk18;
    }

    @Column(order = 319, length = 13)
    private BizNumber iwsMaitosiznnzndk19;

    public BizNumber getIwsMaitosiznnzndk19() {
        return iwsMaitosiznnzndk19;
    }

    public void setIwsMaitosiznnzndk19(BizNumber pIwsMaitosiznnzndk19) {
        iwsMaitosiznnzndk19 = pIwsMaitosiznnzndk19;
    }

    @Column(order = 320, length = 13)
    private BizNumber iwsMaitosiznnzndk20;

    public BizNumber getIwsMaitosiznnzndk20() {
        return iwsMaitosiznnzndk20;
    }

    public void setIwsMaitosiznnzndk20(BizNumber pIwsMaitosiznnzndk20) {
        iwsMaitosiznnzndk20 = pIwsMaitosiznnzndk20;
    }

    @Column(order = 321, length = 13)
    private BizNumber iwsMaitosiznnzndk21;

    public BizNumber getIwsMaitosiznnzndk21() {
        return iwsMaitosiznnzndk21;
    }

    public void setIwsMaitosiznnzndk21(BizNumber pIwsMaitosiznnzndk21) {
        iwsMaitosiznnzndk21 = pIwsMaitosiznnzndk21;
    }

    @Column(order = 322, length = 13)
    private BizNumber iwsMaitosiznnzndk22;

    public BizNumber getIwsMaitosiznnzndk22() {
        return iwsMaitosiznnzndk22;
    }

    public void setIwsMaitosiznnzndk22(BizNumber pIwsMaitosiznnzndk22) {
        iwsMaitosiznnzndk22 = pIwsMaitosiznnzndk22;
    }

    @Column(order = 323, length = 13)
    private BizNumber iwsMaitosiznnzndk23;

    public BizNumber getIwsMaitosiznnzndk23() {
        return iwsMaitosiznnzndk23;
    }

    public void setIwsMaitosiznnzndk23(BizNumber pIwsMaitosiznnzndk23) {
        iwsMaitosiznnzndk23 = pIwsMaitosiznnzndk23;
    }

    @Column(order = 324, length = 13)
    private BizNumber iwsMaitosiznnzndk24;

    public BizNumber getIwsMaitosiznnzndk24() {
        return iwsMaitosiznnzndk24;
    }

    public void setIwsMaitosiznnzndk24(BizNumber pIwsMaitosiznnzndk24) {
        iwsMaitosiznnzndk24 = pIwsMaitosiznnzndk24;
    }

    @Column(order = 325, length = 13)
    private BizNumber iwsMaitosiznnzndk25;

    public BizNumber getIwsMaitosiznnzndk25() {
        return iwsMaitosiznnzndk25;
    }

    public void setIwsMaitosiznnzndk25(BizNumber pIwsMaitosiznnzndk25) {
        iwsMaitosiznnzndk25 = pIwsMaitosiznnzndk25;
    }

    @Column(order = 326, length = 13)
    private BizNumber iwsMaitosiznnzndk26;

    public BizNumber getIwsMaitosiznnzndk26() {
        return iwsMaitosiznnzndk26;
    }

    public void setIwsMaitosiznnzndk26(BizNumber pIwsMaitosiznnzndk26) {
        iwsMaitosiznnzndk26 = pIwsMaitosiznnzndk26;
    }

    @Column(order = 327, length = 13)
    private BizNumber iwsMaitosiznnzndk27;

    public BizNumber getIwsMaitosiznnzndk27() {
        return iwsMaitosiznnzndk27;
    }

    public void setIwsMaitosiznnzndk27(BizNumber pIwsMaitosiznnzndk27) {
        iwsMaitosiznnzndk27 = pIwsMaitosiznnzndk27;
    }

    @Column(order = 328, length = 13)
    private BizNumber iwsMaitosiznnzndk28;

    public BizNumber getIwsMaitosiznnzndk28() {
        return iwsMaitosiznnzndk28;
    }

    public void setIwsMaitosiznnzndk28(BizNumber pIwsMaitosiznnzndk28) {
        iwsMaitosiznnzndk28 = pIwsMaitosiznnzndk28;
    }

    @Column(order = 329, length = 13)
    private BizNumber iwsMaitosiznnzndk29;

    public BizNumber getIwsMaitosiznnzndk29() {
        return iwsMaitosiznnzndk29;
    }

    public void setIwsMaitosiznnzndk29(BizNumber pIwsMaitosiznnzndk29) {
        iwsMaitosiznnzndk29 = pIwsMaitosiznnzndk29;
    }

    @Column(order = 330, length = 13)
    private BizNumber iwsMaitosiznnzndk30;

    public BizNumber getIwsMaitosiznnzndk30() {
        return iwsMaitosiznnzndk30;
    }

    public void setIwsMaitosiznnzndk30(BizNumber pIwsMaitosiznnzndk30) {
        iwsMaitosiznnzndk30 = pIwsMaitosiznnzndk30;
    }

    @Column(order = 331, length = 13)
    private BizNumber iwsMaitosiznnzndk31;

    public BizNumber getIwsMaitosiznnzndk31() {
        return iwsMaitosiznnzndk31;
    }

    public void setIwsMaitosiznnzndk31(BizNumber pIwsMaitosiznnzndk31) {
        iwsMaitosiznnzndk31 = pIwsMaitosiznnzndk31;
    }

    @Column(order = 332, length = 13)
    private BizNumber iwsMaitosiznnzndk32;

    public BizNumber getIwsMaitosiznnzndk32() {
        return iwsMaitosiznnzndk32;
    }

    public void setIwsMaitosiznnzndk32(BizNumber pIwsMaitosiznnzndk32) {
        iwsMaitosiznnzndk32 = pIwsMaitosiznnzndk32;
    }

    @Column(order = 333, length = 13)
    private BizNumber iwsMaitosiznnzndk33;

    public BizNumber getIwsMaitosiznnzndk33() {
        return iwsMaitosiznnzndk33;
    }

    public void setIwsMaitosiznnzndk33(BizNumber pIwsMaitosiznnzndk33) {
        iwsMaitosiznnzndk33 = pIwsMaitosiznnzndk33;
    }

    @Column(order = 334, length = 13)
    private BizNumber iwsMaitosiznnzndk34;

    public BizNumber getIwsMaitosiznnzndk34() {
        return iwsMaitosiznnzndk34;
    }

    public void setIwsMaitosiznnzndk34(BizNumber pIwsMaitosiznnzndk34) {
        iwsMaitosiznnzndk34 = pIwsMaitosiznnzndk34;
    }

    @Column(order = 335, length = 13)
    private BizNumber iwsMaitosiznnzndk35;

    public BizNumber getIwsMaitosiznnzndk35() {
        return iwsMaitosiznnzndk35;
    }

    public void setIwsMaitosiznnzndk35(BizNumber pIwsMaitosiznnzndk35) {
        iwsMaitosiznnzndk35 = pIwsMaitosiznnzndk35;
    }

    @Column(order = 336, length = 13)
    private BizNumber iwsMaitosiznnzndk36;

    public BizNumber getIwsMaitosiznnzndk36() {
        return iwsMaitosiznnzndk36;
    }

    public void setIwsMaitosiznnzndk36(BizNumber pIwsMaitosiznnzndk36) {
        iwsMaitosiznnzndk36 = pIwsMaitosiznnzndk36;
    }

    @Column(order = 337, length = 13)
    private BizNumber iwsMaitosiznnzndk37;

    public BizNumber getIwsMaitosiznnzndk37() {
        return iwsMaitosiznnzndk37;
    }

    public void setIwsMaitosiznnzndk37(BizNumber pIwsMaitosiznnzndk37) {
        iwsMaitosiznnzndk37 = pIwsMaitosiznnzndk37;
    }

    @Column(order = 338, length = 13)
    private BizNumber iwsMaitosiznnzndk38;

    public BizNumber getIwsMaitosiznnzndk38() {
        return iwsMaitosiznnzndk38;
    }

    public void setIwsMaitosiznnzndk38(BizNumber pIwsMaitosiznnzndk38) {
        iwsMaitosiznnzndk38 = pIwsMaitosiznnzndk38;
    }

    @Column(order = 339, length = 13)
    private BizNumber iwsMaitosiznnzndk39;

    public BizNumber getIwsMaitosiznnzndk39() {
        return iwsMaitosiznnzndk39;
    }

    public void setIwsMaitosiznnzndk39(BizNumber pIwsMaitosiznnzndk39) {
        iwsMaitosiznnzndk39 = pIwsMaitosiznnzndk39;
    }

    @Column(order = 340, length = 13)
    private BizNumber iwsMaitosiznnzndk40;

    public BizNumber getIwsMaitosiznnzndk40() {
        return iwsMaitosiznnzndk40;
    }

    public void setIwsMaitosiznnzndk40(BizNumber pIwsMaitosiznnzndk40) {
        iwsMaitosiznnzndk40 = pIwsMaitosiznnzndk40;
    }

    @Column(order = 341, length = 13)
    private BizNumber iwsMaitosiznnzndk41;

    public BizNumber getIwsMaitosiznnzndk41() {
        return iwsMaitosiznnzndk41;
    }

    public void setIwsMaitosiznnzndk41(BizNumber pIwsMaitosiznnzndk41) {
        iwsMaitosiznnzndk41 = pIwsMaitosiznnzndk41;
    }

    @Column(order = 342, length = 13)
    private BizNumber iwsMaitosiznnzndk42;

    public BizNumber getIwsMaitosiznnzndk42() {
        return iwsMaitosiznnzndk42;
    }

    public void setIwsMaitosiznnzndk42(BizNumber pIwsMaitosiznnzndk42) {
        iwsMaitosiznnzndk42 = pIwsMaitosiznnzndk42;
    }

    @Column(order = 343, length = 13)
    private BizNumber iwsMaitosiznnzndk43;

    public BizNumber getIwsMaitosiznnzndk43() {
        return iwsMaitosiznnzndk43;
    }

    public void setIwsMaitosiznnzndk43(BizNumber pIwsMaitosiznnzndk43) {
        iwsMaitosiznnzndk43 = pIwsMaitosiznnzndk43;
    }

    @Column(order = 344, length = 13)
    private BizNumber iwsMaitosiznnzndk44;

    public BizNumber getIwsMaitosiznnzndk44() {
        return iwsMaitosiznnzndk44;
    }

    public void setIwsMaitosiznnzndk44(BizNumber pIwsMaitosiznnzndk44) {
        iwsMaitosiznnzndk44 = pIwsMaitosiznnzndk44;
    }

    @Column(order = 345, length = 13)
    private BizNumber iwsMaitosiznnzndk45;

    public BizNumber getIwsMaitosiznnzndk45() {
        return iwsMaitosiznnzndk45;
    }

    public void setIwsMaitosiznnzndk45(BizNumber pIwsMaitosiznnzndk45) {
        iwsMaitosiznnzndk45 = pIwsMaitosiznnzndk45;
    }

    @Column(order = 346, length = 13)
    private BizNumber iwsMaitosiznnzndk46;

    public BizNumber getIwsMaitosiznnzndk46() {
        return iwsMaitosiznnzndk46;
    }

    public void setIwsMaitosiznnzndk46(BizNumber pIwsMaitosiznnzndk46) {
        iwsMaitosiznnzndk46 = pIwsMaitosiznnzndk46;
    }

    @Column(order = 347, length = 13)
    private BizNumber iwsMaitosiznnzndk47;

    public BizNumber getIwsMaitosiznnzndk47() {
        return iwsMaitosiznnzndk47;
    }

    public void setIwsMaitosiznnzndk47(BizNumber pIwsMaitosiznnzndk47) {
        iwsMaitosiznnzndk47 = pIwsMaitosiznnzndk47;
    }

    @Column(order = 348, length = 13)
    private BizNumber iwsMaitosiznnzndk48;

    public BizNumber getIwsMaitosiznnzndk48() {
        return iwsMaitosiznnzndk48;
    }

    public void setIwsMaitosiznnzndk48(BizNumber pIwsMaitosiznnzndk48) {
        iwsMaitosiznnzndk48 = pIwsMaitosiznnzndk48;
    }

    @Column(order = 349, length = 13)
    private BizNumber iwsMaitosiznnzndk49;

    public BizNumber getIwsMaitosiznnzndk49() {
        return iwsMaitosiznnzndk49;
    }

    public void setIwsMaitosiznnzndk49(BizNumber pIwsMaitosiznnzndk49) {
        iwsMaitosiznnzndk49 = pIwsMaitosiznnzndk49;
    }

    @Column(order = 350, length = 13)
    private BizNumber iwsMaitosiznnzndk50;

    public BizNumber getIwsMaitosiznnzndk50() {
        return iwsMaitosiznnzndk50;
    }

    public void setIwsMaitosiznnzndk50(BizNumber pIwsMaitosiznnzndk50) {
        iwsMaitosiznnzndk50 = pIwsMaitosiznnzndk50;
    }

    @Column(order = 351, length = 13)
    private BizNumber iwsMaitosiznnzndk51;

    public BizNumber getIwsMaitosiznnzndk51() {
        return iwsMaitosiznnzndk51;
    }

    public void setIwsMaitosiznnzndk51(BizNumber pIwsMaitosiznnzndk51) {
        iwsMaitosiznnzndk51 = pIwsMaitosiznnzndk51;
    }

    @Column(order = 352, length = 13)
    private BizNumber iwsMaitosiznnzndk52;

    public BizNumber getIwsMaitosiznnzndk52() {
        return iwsMaitosiznnzndk52;
    }

    public void setIwsMaitosiznnzndk52(BizNumber pIwsMaitosiznnzndk52) {
        iwsMaitosiznnzndk52 = pIwsMaitosiznnzndk52;
    }

    @Column(order = 353, length = 13)
    private BizNumber iwsMaitosiznnzndk53;

    public BizNumber getIwsMaitosiznnzndk53() {
        return iwsMaitosiznnzndk53;
    }

    public void setIwsMaitosiznnzndk53(BizNumber pIwsMaitosiznnzndk53) {
        iwsMaitosiznnzndk53 = pIwsMaitosiznnzndk53;
    }

    @Column(order = 354, length = 13)
    private BizNumber iwsMaitosiznnzndk54;

    public BizNumber getIwsMaitosiznnzndk54() {
        return iwsMaitosiznnzndk54;
    }

    public void setIwsMaitosiznnzndk54(BizNumber pIwsMaitosiznnzndk54) {
        iwsMaitosiznnzndk54 = pIwsMaitosiznnzndk54;
    }

    @Column(order = 355, length = 13)
    private BizNumber iwsMaitosiznnzndk55;

    public BizNumber getIwsMaitosiznnzndk55() {
        return iwsMaitosiznnzndk55;
    }

    public void setIwsMaitosiznnzndk55(BizNumber pIwsMaitosiznnzndk55) {
        iwsMaitosiznnzndk55 = pIwsMaitosiznnzndk55;
    }

    @Column(order = 356, length = 13)
    private BizNumber iwsMaitosiznnzndk56;

    public BizNumber getIwsMaitosiznnzndk56() {
        return iwsMaitosiznnzndk56;
    }

    public void setIwsMaitosiznnzndk56(BizNumber pIwsMaitosiznnzndk56) {
        iwsMaitosiznnzndk56 = pIwsMaitosiznnzndk56;
    }

    @Column(order = 357, length = 13)
    private BizNumber iwsMaitosiznnzndk57;

    public BizNumber getIwsMaitosiznnzndk57() {
        return iwsMaitosiznnzndk57;
    }

    public void setIwsMaitosiznnzndk57(BizNumber pIwsMaitosiznnzndk57) {
        iwsMaitosiznnzndk57 = pIwsMaitosiznnzndk57;
    }

    @Column(order = 358, length = 13)
    private BizNumber iwsMaitosiznnzndk58;

    public BizNumber getIwsMaitosiznnzndk58() {
        return iwsMaitosiznnzndk58;
    }

    public void setIwsMaitosiznnzndk58(BizNumber pIwsMaitosiznnzndk58) {
        iwsMaitosiznnzndk58 = pIwsMaitosiznnzndk58;
    }

    @Column(order = 359, length = 13)
    private BizNumber iwsMaitosiznnzndk59;

    public BizNumber getIwsMaitosiznnzndk59() {
        return iwsMaitosiznnzndk59;
    }

    public void setIwsMaitosiznnzndk59(BizNumber pIwsMaitosiznnzndk59) {
        iwsMaitosiznnzndk59 = pIwsMaitosiznnzndk59;
    }

    @Column(order = 360, length = 13)
    private BizNumber iwsMaitosiznnzndk60;

    public BizNumber getIwsMaitosiznnzndk60() {
        return iwsMaitosiznnzndk60;
    }

    public void setIwsMaitosiznnzndk60(BizNumber pIwsMaitosiznnzndk60) {
        iwsMaitosiznnzndk60 = pIwsMaitosiznnzndk60;
    }

    @Column(order = 361, length = 13)
    private BizNumber iwsMaitosiznnzndk61;

    public BizNumber getIwsMaitosiznnzndk61() {
        return iwsMaitosiznnzndk61;
    }

    public void setIwsMaitosiznnzndk61(BizNumber pIwsMaitosiznnzndk61) {
        iwsMaitosiznnzndk61 = pIwsMaitosiznnzndk61;
    }

    @Column(order = 362, length = 13)
    private BizNumber iwsMaitosiznnzndk62;

    public BizNumber getIwsMaitosiznnzndk62() {
        return iwsMaitosiznnzndk62;
    }

    public void setIwsMaitosiznnzndk62(BizNumber pIwsMaitosiznnzndk62) {
        iwsMaitosiznnzndk62 = pIwsMaitosiznnzndk62;
    }

    @Column(order = 363, length = 13)
    private BizNumber iwsMaitosiznnzndk63;

    public BizNumber getIwsMaitosiznnzndk63() {
        return iwsMaitosiznnzndk63;
    }

    public void setIwsMaitosiznnzndk63(BizNumber pIwsMaitosiznnzndk63) {
        iwsMaitosiznnzndk63 = pIwsMaitosiznnzndk63;
    }

    @Column(order = 364, length = 13)
    private BizNumber iwsMaitosiznnzndk64;

    public BizNumber getIwsMaitosiznnzndk64() {
        return iwsMaitosiznnzndk64;
    }

    public void setIwsMaitosiznnzndk64(BizNumber pIwsMaitosiznnzndk64) {
        iwsMaitosiznnzndk64 = pIwsMaitosiznnzndk64;
    }

    @Column(order = 365, length = 13)
    private BizNumber iwsMaitosiznnzndk65;

    public BizNumber getIwsMaitosiznnzndk65() {
        return iwsMaitosiznnzndk65;
    }

    public void setIwsMaitosiznnzndk65(BizNumber pIwsMaitosiznnzndk65) {
        iwsMaitosiznnzndk65 = pIwsMaitosiznnzndk65;
    }

    @Column(order = 366, length = 13)
    private BizNumber iwsMaitosiznnzndk66;

    public BizNumber getIwsMaitosiznnzndk66() {
        return iwsMaitosiznnzndk66;
    }

    public void setIwsMaitosiznnzndk66(BizNumber pIwsMaitosiznnzndk66) {
        iwsMaitosiznnzndk66 = pIwsMaitosiznnzndk66;
    }

    @Column(order = 367, length = 13)
    private BizNumber iwsMaitosiznnzndk67;

    public BizNumber getIwsMaitosiznnzndk67() {
        return iwsMaitosiznnzndk67;
    }

    public void setIwsMaitosiznnzndk67(BizNumber pIwsMaitosiznnzndk67) {
        iwsMaitosiznnzndk67 = pIwsMaitosiznnzndk67;
    }

    @Column(order = 368, length = 13)
    private BizNumber iwsMaitosiznnzndk68;

    public BizNumber getIwsMaitosiznnzndk68() {
        return iwsMaitosiznnzndk68;
    }

    public void setIwsMaitosiznnzndk68(BizNumber pIwsMaitosiznnzndk68) {
        iwsMaitosiznnzndk68 = pIwsMaitosiznnzndk68;
    }

    @Column(order = 369, length = 13)
    private BizNumber iwsMaitosiznnzndk69;

    public BizNumber getIwsMaitosiznnzndk69() {
        return iwsMaitosiznnzndk69;
    }

    public void setIwsMaitosiznnzndk69(BizNumber pIwsMaitosiznnzndk69) {
        iwsMaitosiznnzndk69 = pIwsMaitosiznnzndk69;
    }

    @Column(order = 370, length = 13)
    private BizNumber iwsMaitosiznnzndk70;

    public BizNumber getIwsMaitosiznnzndk70() {
        return iwsMaitosiznnzndk70;
    }

    public void setIwsMaitosiznnzndk70(BizNumber pIwsMaitosiznnzndk70) {
        iwsMaitosiznnzndk70 = pIwsMaitosiznnzndk70;
    }

    @Column(order = 371, length = 13)
    private BizNumber iwsMaitosiznnzndk71;

    public BizNumber getIwsMaitosiznnzndk71() {
        return iwsMaitosiznnzndk71;
    }

    public void setIwsMaitosiznnzndk71(BizNumber pIwsMaitosiznnzndk71) {
        iwsMaitosiznnzndk71 = pIwsMaitosiznnzndk71;
    }

    @Column(order = 372, length = 13)
    private BizNumber iwsMaitosiznnzndk72;

    public BizNumber getIwsMaitosiznnzndk72() {
        return iwsMaitosiznnzndk72;
    }

    public void setIwsMaitosiznnzndk72(BizNumber pIwsMaitosiznnzndk72) {
        iwsMaitosiznnzndk72 = pIwsMaitosiznnzndk72;
    }

    @Column(order = 373, length = 13)
    private BizNumber iwsMaitosiznnzndk73;

    public BizNumber getIwsMaitosiznnzndk73() {
        return iwsMaitosiznnzndk73;
    }

    public void setIwsMaitosiznnzndk73(BizNumber pIwsMaitosiznnzndk73) {
        iwsMaitosiznnzndk73 = pIwsMaitosiznnzndk73;
    }

    @Column(order = 374, length = 13)
    private BizNumber iwsMaitosiznnzndk74;

    public BizNumber getIwsMaitosiznnzndk74() {
        return iwsMaitosiznnzndk74;
    }

    public void setIwsMaitosiznnzndk74(BizNumber pIwsMaitosiznnzndk74) {
        iwsMaitosiznnzndk74 = pIwsMaitosiznnzndk74;
    }

    @Column(order = 375, length = 13)
    private BizNumber iwsMaitosiznnzndk75;

    public BizNumber getIwsMaitosiznnzndk75() {
        return iwsMaitosiznnzndk75;
    }

    public void setIwsMaitosiznnzndk75(BizNumber pIwsMaitosiznnzndk75) {
        iwsMaitosiznnzndk75 = pIwsMaitosiznnzndk75;
    }

    @Column(order = 376, length = 13)
    private BizNumber iwsMaitosiznnzndk76;

    public BizNumber getIwsMaitosiznnzndk76() {
        return iwsMaitosiznnzndk76;
    }

    public void setIwsMaitosiznnzndk76(BizNumber pIwsMaitosiznnzndk76) {
        iwsMaitosiznnzndk76 = pIwsMaitosiznnzndk76;
    }

    @Column(order = 377, length = 13)
    private BizNumber iwsMaitosiznnzndk77;

    public BizNumber getIwsMaitosiznnzndk77() {
        return iwsMaitosiznnzndk77;
    }

    public void setIwsMaitosiznnzndk77(BizNumber pIwsMaitosiznnzndk77) {
        iwsMaitosiznnzndk77 = pIwsMaitosiznnzndk77;
    }

    @Column(order = 378, length = 13)
    private BizNumber iwsMaitosiznnzndk78;

    public BizNumber getIwsMaitosiznnzndk78() {
        return iwsMaitosiznnzndk78;
    }

    public void setIwsMaitosiznnzndk78(BizNumber pIwsMaitosiznnzndk78) {
        iwsMaitosiznnzndk78 = pIwsMaitosiznnzndk78;
    }

    @Column(order = 379, length = 13)
    private BizNumber iwsMaitosiznnzndk79;

    public BizNumber getIwsMaitosiznnzndk79() {
        return iwsMaitosiznnzndk79;
    }

    public void setIwsMaitosiznnzndk79(BizNumber pIwsMaitosiznnzndk79) {
        iwsMaitosiznnzndk79 = pIwsMaitosiznnzndk79;
    }

    @Column(order = 380, length = 13)
    private BizNumber iwsMaitosiznnzndk80;

    public BizNumber getIwsMaitosiznnzndk80() {
        return iwsMaitosiznnzndk80;
    }

    public void setIwsMaitosiznnzndk80(BizNumber pIwsMaitosiznnzndk80) {
        iwsMaitosiznnzndk80 = pIwsMaitosiznnzndk80;
    }

    @Column(order = 381, length = 13)
    private BizNumber iwsMaitosiznnzndk81;

    public BizNumber getIwsMaitosiznnzndk81() {
        return iwsMaitosiznnzndk81;
    }

    public void setIwsMaitosiznnzndk81(BizNumber pIwsMaitosiznnzndk81) {
        iwsMaitosiznnzndk81 = pIwsMaitosiznnzndk81;
    }

    @Column(order = 382, length = 13)
    private BizNumber iwsMaitosiznnzndk82;

    public BizNumber getIwsMaitosiznnzndk82() {
        return iwsMaitosiznnzndk82;
    }

    public void setIwsMaitosiznnzndk82(BizNumber pIwsMaitosiznnzndk82) {
        iwsMaitosiznnzndk82 = pIwsMaitosiznnzndk82;
    }

    @Column(order = 383, length = 13)
    private BizNumber iwsMaitosiznnzndk83;

    public BizNumber getIwsMaitosiznnzndk83() {
        return iwsMaitosiznnzndk83;
    }

    public void setIwsMaitosiznnzndk83(BizNumber pIwsMaitosiznnzndk83) {
        iwsMaitosiznnzndk83 = pIwsMaitosiznnzndk83;
    }

    @Column(order = 384, length = 13)
    private BizNumber iwsMaitosiznnzndk84;

    public BizNumber getIwsMaitosiznnzndk84() {
        return iwsMaitosiznnzndk84;
    }

    public void setIwsMaitosiznnzndk84(BizNumber pIwsMaitosiznnzndk84) {
        iwsMaitosiznnzndk84 = pIwsMaitosiznnzndk84;
    }

    @Column(order = 385, length = 13)
    private BizNumber iwsMaitosiznnzndk85;

    public BizNumber getIwsMaitosiznnzndk85() {
        return iwsMaitosiznnzndk85;
    }

    public void setIwsMaitosiznnzndk85(BizNumber pIwsMaitosiznnzndk85) {
        iwsMaitosiznnzndk85 = pIwsMaitosiznnzndk85;
    }

    @Column(order = 386, length = 13)
    private BizNumber iwsMaitosiznnzndk86;

    public BizNumber getIwsMaitosiznnzndk86() {
        return iwsMaitosiznnzndk86;
    }

    public void setIwsMaitosiznnzndk86(BizNumber pIwsMaitosiznnzndk86) {
        iwsMaitosiznnzndk86 = pIwsMaitosiznnzndk86;
    }

    @Column(order = 387, length = 13)
    private BizNumber iwsMaitosiznnzndk87;

    public BizNumber getIwsMaitosiznnzndk87() {
        return iwsMaitosiznnzndk87;
    }

    public void setIwsMaitosiznnzndk87(BizNumber pIwsMaitosiznnzndk87) {
        iwsMaitosiznnzndk87 = pIwsMaitosiznnzndk87;
    }

    @Column(order = 388, length = 13)
    private BizNumber iwsMaitosiznnzndk88;

    public BizNumber getIwsMaitosiznnzndk88() {
        return iwsMaitosiznnzndk88;
    }

    public void setIwsMaitosiznnzndk88(BizNumber pIwsMaitosiznnzndk88) {
        iwsMaitosiznnzndk88 = pIwsMaitosiznnzndk88;
    }

    @Column(order = 389, length = 13)
    private BizNumber iwsMaitosiznnzndk89;

    public BizNumber getIwsMaitosiznnzndk89() {
        return iwsMaitosiznnzndk89;
    }

    public void setIwsMaitosiznnzndk89(BizNumber pIwsMaitosiznnzndk89) {
        iwsMaitosiznnzndk89 = pIwsMaitosiznnzndk89;
    }

    @Column(order = 390, length = 13)
    private BizNumber iwsMaitosiznnzndk90;

    public BizNumber getIwsMaitosiznnzndk90() {
        return iwsMaitosiznnzndk90;
    }

    public void setIwsMaitosiznnzndk90(BizNumber pIwsMaitosiznnzndk90) {
        iwsMaitosiznnzndk90 = pIwsMaitosiznnzndk90;
    }

    @Column(order = 391, length = 13)
    private BizNumber iwsMaitosiznnzndk91;

    public BizNumber getIwsMaitosiznnzndk91() {
        return iwsMaitosiznnzndk91;
    }

    public void setIwsMaitosiznnzndk91(BizNumber pIwsMaitosiznnzndk91) {
        iwsMaitosiznnzndk91 = pIwsMaitosiznnzndk91;
    }

    @Column(order = 392, length = 13)
    private BizNumber iwsMaitosiznnzndk92;

    public BizNumber getIwsMaitosiznnzndk92() {
        return iwsMaitosiznnzndk92;
    }

    public void setIwsMaitosiznnzndk92(BizNumber pIwsMaitosiznnzndk92) {
        iwsMaitosiznnzndk92 = pIwsMaitosiznnzndk92;
    }

    @Column(order = 393, length = 13)
    private BizNumber iwsMaitosiznnzndk93;

    public BizNumber getIwsMaitosiznnzndk93() {
        return iwsMaitosiznnzndk93;
    }

    public void setIwsMaitosiznnzndk93(BizNumber pIwsMaitosiznnzndk93) {
        iwsMaitosiznnzndk93 = pIwsMaitosiznnzndk93;
    }

    @Column(order = 394, length = 13)
    private BizNumber iwsMaitosiznnzndk94;

    public BizNumber getIwsMaitosiznnzndk94() {
        return iwsMaitosiznnzndk94;
    }

    public void setIwsMaitosiznnzndk94(BizNumber pIwsMaitosiznnzndk94) {
        iwsMaitosiznnzndk94 = pIwsMaitosiznnzndk94;
    }

    @Column(order = 395, length = 13)
    private BizNumber iwsMaitosiznnzndk95;

    public BizNumber getIwsMaitosiznnzndk95() {
        return iwsMaitosiznnzndk95;
    }

    public void setIwsMaitosiznnzndk95(BizNumber pIwsMaitosiznnzndk95) {
        iwsMaitosiznnzndk95 = pIwsMaitosiznnzndk95;
    }

    @Column(order = 396, length = 13)
    private BizNumber iwsMaitosiznnzndk96;

    public BizNumber getIwsMaitosiznnzndk96() {
        return iwsMaitosiznnzndk96;
    }

    public void setIwsMaitosiznnzndk96(BizNumber pIwsMaitosiznnzndk96) {
        iwsMaitosiznnzndk96 = pIwsMaitosiznnzndk96;
    }

    @Column(order = 397, length = 13)
    private BizNumber iwsMaitosiznnzndk97;

    public BizNumber getIwsMaitosiznnzndk97() {
        return iwsMaitosiznnzndk97;
    }

    public void setIwsMaitosiznnzndk97(BizNumber pIwsMaitosiznnzndk97) {
        iwsMaitosiznnzndk97 = pIwsMaitosiznnzndk97;
    }

    @Column(order = 398, length = 13)
    private BizNumber iwsMaitosiznnzndk98;

    public BizNumber getIwsMaitosiznnzndk98() {
        return iwsMaitosiznnzndk98;
    }

    public void setIwsMaitosiznnzndk98(BizNumber pIwsMaitosiznnzndk98) {
        iwsMaitosiznnzndk98 = pIwsMaitosiznnzndk98;
    }

    @Column(order = 399, length = 13)
    private BizNumber iwsMaitosiznnzndk99;

    public BizNumber getIwsMaitosiznnzndk99() {
        return iwsMaitosiznnzndk99;
    }

    public void setIwsMaitosiznnzndk99(BizNumber pIwsMaitosiznnzndk99) {
        iwsMaitosiznnzndk99 = pIwsMaitosiznnzndk99;
    }

    @Column(order = 400, length = 13)
    private BizNumber iwsHrkkknmnryutykgw;

    public BizNumber getIwsHrkkknmnryutykgw() {
        return iwsHrkkknmnryutykgw;
    }

    public void setIwsHrkkknmnryutykgw(BizNumber pIwsHrkkknmnryutykgw) {
        iwsHrkkknmnryutykgw = pIwsHrkkknmnryutykgw;
    }

    @Column(order = 401, length = 5)
    private BizNumber iwsKaiyakukoujyoritu1;

    public BizNumber getIwsKaiyakukoujyoritu1() {
        return iwsKaiyakukoujyoritu1;
    }

    public void setIwsKaiyakukoujyoritu1(BizNumber pIwsKaiyakukoujyoritu1) {
        iwsKaiyakukoujyoritu1 = pIwsKaiyakukoujyoritu1;
    }

    @Column(order = 402, length = 5)
    private BizNumber iwsKaiyakukoujyoritu2;

    public BizNumber getIwsKaiyakukoujyoritu2() {
        return iwsKaiyakukoujyoritu2;
    }

    public void setIwsKaiyakukoujyoritu2(BizNumber pIwsKaiyakukoujyoritu2) {
        iwsKaiyakukoujyoritu2 = pIwsKaiyakukoujyoritu2;
    }

    @Column(order = 403, length = 5)
    private BizNumber iwsKaiyakukoujyoritu3;

    public BizNumber getIwsKaiyakukoujyoritu3() {
        return iwsKaiyakukoujyoritu3;
    }

    public void setIwsKaiyakukoujyoritu3(BizNumber pIwsKaiyakukoujyoritu3) {
        iwsKaiyakukoujyoritu3 = pIwsKaiyakukoujyoritu3;
    }

    @Column(order = 404, length = 5)
    private BizNumber iwsKaiyakukoujyoritu4;

    public BizNumber getIwsKaiyakukoujyoritu4() {
        return iwsKaiyakukoujyoritu4;
    }

    public void setIwsKaiyakukoujyoritu4(BizNumber pIwsKaiyakukoujyoritu4) {
        iwsKaiyakukoujyoritu4 = pIwsKaiyakukoujyoritu4;
    }

    @Column(order = 405, length = 5)
    private BizNumber iwsKaiyakukoujyoritu5;

    public BizNumber getIwsKaiyakukoujyoritu5() {
        return iwsKaiyakukoujyoritu5;
    }

    public void setIwsKaiyakukoujyoritu5(BizNumber pIwsKaiyakukoujyoritu5) {
        iwsKaiyakukoujyoritu5 = pIwsKaiyakukoujyoritu5;
    }

    @Column(order = 406, length = 5)
    private BizNumber iwsKaiyakukoujyoritu6;

    public BizNumber getIwsKaiyakukoujyoritu6() {
        return iwsKaiyakukoujyoritu6;
    }

    public void setIwsKaiyakukoujyoritu6(BizNumber pIwsKaiyakukoujyoritu6) {
        iwsKaiyakukoujyoritu6 = pIwsKaiyakukoujyoritu6;
    }

    @Column(order = 407, length = 5)
    private BizNumber iwsKaiyakukoujyoritu7;

    public BizNumber getIwsKaiyakukoujyoritu7() {
        return iwsKaiyakukoujyoritu7;
    }

    public void setIwsKaiyakukoujyoritu7(BizNumber pIwsKaiyakukoujyoritu7) {
        iwsKaiyakukoujyoritu7 = pIwsKaiyakukoujyoritu7;
    }

    @Column(order = 408, length = 5)
    private BizNumber iwsKaiyakukoujyoritu8;

    public BizNumber getIwsKaiyakukoujyoritu8() {
        return iwsKaiyakukoujyoritu8;
    }

    public void setIwsKaiyakukoujyoritu8(BizNumber pIwsKaiyakukoujyoritu8) {
        iwsKaiyakukoujyoritu8 = pIwsKaiyakukoujyoritu8;
    }

    @Column(order = 409, length = 5)
    private BizNumber iwsKaiyakukoujyoritu9;

    public BizNumber getIwsKaiyakukoujyoritu9() {
        return iwsKaiyakukoujyoritu9;
    }

    public void setIwsKaiyakukoujyoritu9(BizNumber pIwsKaiyakukoujyoritu9) {
        iwsKaiyakukoujyoritu9 = pIwsKaiyakukoujyoritu9;
    }

    @Column(order = 410, length = 5)
    private BizNumber iwsKaiyakukoujyoritu10;

    public BizNumber getIwsKaiyakukoujyoritu10() {
        return iwsKaiyakukoujyoritu10;
    }

    public void setIwsKaiyakukoujyoritu10(BizNumber pIwsKaiyakukoujyoritu10) {
        iwsKaiyakukoujyoritu10 = pIwsKaiyakukoujyoritu10;
    }

    @Column(order = 411, length = 13)
    private BizNumber iwsKaiyakukjgk1;

    public BizNumber getIwsKaiyakukjgk1() {
        return iwsKaiyakukjgk1;
    }

    public void setIwsKaiyakukjgk1(BizNumber pIwsKaiyakukjgk1) {
        iwsKaiyakukjgk1 = pIwsKaiyakukjgk1;
    }

    @Column(order = 412, length = 13)
    private BizNumber iwsKaiyakukjgk2;

    public BizNumber getIwsKaiyakukjgk2() {
        return iwsKaiyakukjgk2;
    }

    public void setIwsKaiyakukjgk2(BizNumber pIwsKaiyakukjgk2) {
        iwsKaiyakukjgk2 = pIwsKaiyakukjgk2;
    }

    @Column(order = 413, length = 13)
    private BizNumber iwsKaiyakukjgk3;

    public BizNumber getIwsKaiyakukjgk3() {
        return iwsKaiyakukjgk3;
    }

    public void setIwsKaiyakukjgk3(BizNumber pIwsKaiyakukjgk3) {
        iwsKaiyakukjgk3 = pIwsKaiyakukjgk3;
    }

    @Column(order = 414, length = 13)
    private BizNumber iwsKaiyakukjgk4;

    public BizNumber getIwsKaiyakukjgk4() {
        return iwsKaiyakukjgk4;
    }

    public void setIwsKaiyakukjgk4(BizNumber pIwsKaiyakukjgk4) {
        iwsKaiyakukjgk4 = pIwsKaiyakukjgk4;
    }

    @Column(order = 415, length = 13)
    private BizNumber iwsKaiyakukjgk5;

    public BizNumber getIwsKaiyakukjgk5() {
        return iwsKaiyakukjgk5;
    }

    public void setIwsKaiyakukjgk5(BizNumber pIwsKaiyakukjgk5) {
        iwsKaiyakukjgk5 = pIwsKaiyakukjgk5;
    }

    @Column(order = 416, length = 13)
    private BizNumber iwsKaiyakukjgk6;

    public BizNumber getIwsKaiyakukjgk6() {
        return iwsKaiyakukjgk6;
    }

    public void setIwsKaiyakukjgk6(BizNumber pIwsKaiyakukjgk6) {
        iwsKaiyakukjgk6 = pIwsKaiyakukjgk6;
    }

    @Column(order = 417, length = 13)
    private BizNumber iwsKaiyakukjgk7;

    public BizNumber getIwsKaiyakukjgk7() {
        return iwsKaiyakukjgk7;
    }

    public void setIwsKaiyakukjgk7(BizNumber pIwsKaiyakukjgk7) {
        iwsKaiyakukjgk7 = pIwsKaiyakukjgk7;
    }

    @Column(order = 418, length = 13)
    private BizNumber iwsKaiyakukjgk8;

    public BizNumber getIwsKaiyakukjgk8() {
        return iwsKaiyakukjgk8;
    }

    public void setIwsKaiyakukjgk8(BizNumber pIwsKaiyakukjgk8) {
        iwsKaiyakukjgk8 = pIwsKaiyakukjgk8;
    }

    @Column(order = 419, length = 13)
    private BizNumber iwsKaiyakukjgk9;

    public BizNumber getIwsKaiyakukjgk9() {
        return iwsKaiyakukjgk9;
    }

    public void setIwsKaiyakukjgk9(BizNumber pIwsKaiyakukjgk9) {
        iwsKaiyakukjgk9 = pIwsKaiyakukjgk9;
    }

    @Column(order = 420, length = 13)
    private BizNumber iwsKaiyakukjgk10;

    public BizNumber getIwsKaiyakukjgk10() {
        return iwsKaiyakukjgk10;
    }

    public void setIwsKaiyakukjgk10(BizNumber pIwsKaiyakukjgk10) {
        iwsKaiyakukjgk10 = pIwsKaiyakukjgk10;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
