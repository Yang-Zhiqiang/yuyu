package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保険募集）入金用為替レート照会出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbNyknkwsrateOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbNyknkwsrateOutputBean() {
    }

    @Column(order = 1, length = 1)
    private String iwsErrkbn;

    public String getIwsErrkbn() {
        return iwsErrkbn;
    }

    public void setIwsErrkbn(String pIwsErrkbn) {
        iwsErrkbn = pIwsErrkbn;
    }

    @Column(order = 2, length = 8)
    private BizDate iwsKwsratetekiymdusdjpy1;

    public BizDate getIwsKwsratetekiymdusdjpy1() {
        return iwsKwsratetekiymdusdjpy1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdusdjpy1(BizDate pIwsKwsratetekiymdusdjpy1) {
        iwsKwsratetekiymdusdjpy1 = pIwsKwsratetekiymdusdjpy1;
    }

    @Column(order = 3, length = 8)
    private BizDate iwsKwsratetekiymdusdjpy2;

    public BizDate getIwsKwsratetekiymdusdjpy2() {
        return iwsKwsratetekiymdusdjpy2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdusdjpy2(BizDate pIwsKwsratetekiymdusdjpy2) {
        iwsKwsratetekiymdusdjpy2 = pIwsKwsratetekiymdusdjpy2;
    }

    @Column(order = 4, length = 8)
    private BizDate iwsKwsratetekiymdusdjpy3;

    public BizDate getIwsKwsratetekiymdusdjpy3() {
        return iwsKwsratetekiymdusdjpy3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdusdjpy3(BizDate pIwsKwsratetekiymdusdjpy3) {
        iwsKwsratetekiymdusdjpy3 = pIwsKwsratetekiymdusdjpy3;
    }

    @Column(order = 5, length = 8)
    private BizDate iwsKwsratetekiymdusdjpy4;

    public BizDate getIwsKwsratetekiymdusdjpy4() {
        return iwsKwsratetekiymdusdjpy4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdusdjpy4(BizDate pIwsKwsratetekiymdusdjpy4) {
        iwsKwsratetekiymdusdjpy4 = pIwsKwsratetekiymdusdjpy4;
    }

    @Column(order = 6, length = 8)
    private BizDate iwsKwsratetekiymdusdjpy5;

    public BizDate getIwsKwsratetekiymdusdjpy5() {
        return iwsKwsratetekiymdusdjpy5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdusdjpy5(BizDate pIwsKwsratetekiymdusdjpy5) {
        iwsKwsratetekiymdusdjpy5 = pIwsKwsratetekiymdusdjpy5;
    }

    @Column(order = 7, length = 5)
    private BizNumber iwsKwsrateusdjpy1;

    public BizNumber getIwsKwsrateusdjpy1() {
        return iwsKwsrateusdjpy1;
    }

    public void setIwsKwsrateusdjpy1(BizNumber pIwsKwsrateusdjpy1) {
        iwsKwsrateusdjpy1 = pIwsKwsrateusdjpy1;
    }

    @Column(order = 8, length = 5)
    private BizNumber iwsKwsrateusdjpy2;

    public BizNumber getIwsKwsrateusdjpy2() {
        return iwsKwsrateusdjpy2;
    }

    public void setIwsKwsrateusdjpy2(BizNumber pIwsKwsrateusdjpy2) {
        iwsKwsrateusdjpy2 = pIwsKwsrateusdjpy2;
    }

    @Column(order = 9, length = 5)
    private BizNumber iwsKwsrateusdjpy3;

    public BizNumber getIwsKwsrateusdjpy3() {
        return iwsKwsrateusdjpy3;
    }

    public void setIwsKwsrateusdjpy3(BizNumber pIwsKwsrateusdjpy3) {
        iwsKwsrateusdjpy3 = pIwsKwsrateusdjpy3;
    }

    @Column(order = 10, length = 5)
    private BizNumber iwsKwsrateusdjpy4;

    public BizNumber getIwsKwsrateusdjpy4() {
        return iwsKwsrateusdjpy4;
    }

    public void setIwsKwsrateusdjpy4(BizNumber pIwsKwsrateusdjpy4) {
        iwsKwsrateusdjpy4 = pIwsKwsrateusdjpy4;
    }

    @Column(order = 11, length = 5)
    private BizNumber iwsKwsrateusdjpy5;

    public BizNumber getIwsKwsrateusdjpy5() {
        return iwsKwsrateusdjpy5;
    }

    public void setIwsKwsrateusdjpy5(BizNumber pIwsKwsrateusdjpy5) {
        iwsKwsrateusdjpy5 = pIwsKwsrateusdjpy5;
    }

    @Column(order = 12, length = 8)
    private BizDate iwsKwsratetekiymdeurjpy1;

    public BizDate getIwsKwsratetekiymdeurjpy1() {
        return iwsKwsratetekiymdeurjpy1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeurjpy1(BizDate pIwsKwsratetekiymdeurjpy1) {
        iwsKwsratetekiymdeurjpy1 = pIwsKwsratetekiymdeurjpy1;
    }

    @Column(order = 13, length = 8)
    private BizDate iwsKwsratetekiymdeurjpy2;

    public BizDate getIwsKwsratetekiymdeurjpy2() {
        return iwsKwsratetekiymdeurjpy2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeurjpy2(BizDate pIwsKwsratetekiymdeurjpy2) {
        iwsKwsratetekiymdeurjpy2 = pIwsKwsratetekiymdeurjpy2;
    }

    @Column(order = 14, length = 8)
    private BizDate iwsKwsratetekiymdeurjpy3;

    public BizDate getIwsKwsratetekiymdeurjpy3() {
        return iwsKwsratetekiymdeurjpy3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeurjpy3(BizDate pIwsKwsratetekiymdeurjpy3) {
        iwsKwsratetekiymdeurjpy3 = pIwsKwsratetekiymdeurjpy3;
    }

    @Column(order = 15, length = 8)
    private BizDate iwsKwsratetekiymdeurjpy4;

    public BizDate getIwsKwsratetekiymdeurjpy4() {
        return iwsKwsratetekiymdeurjpy4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeurjpy4(BizDate pIwsKwsratetekiymdeurjpy4) {
        iwsKwsratetekiymdeurjpy4 = pIwsKwsratetekiymdeurjpy4;
    }

    @Column(order = 16, length = 8)
    private BizDate iwsKwsratetekiymdeurjpy5;

    public BizDate getIwsKwsratetekiymdeurjpy5() {
        return iwsKwsratetekiymdeurjpy5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeurjpy5(BizDate pIwsKwsratetekiymdeurjpy5) {
        iwsKwsratetekiymdeurjpy5 = pIwsKwsratetekiymdeurjpy5;
    }

    @Column(order = 17, length = 5)
    private BizNumber iwsKwsrateeurjpy1;

    public BizNumber getIwsKwsrateeurjpy1() {
        return iwsKwsrateeurjpy1;
    }

    public void setIwsKwsrateeurjpy1(BizNumber pIwsKwsrateeurjpy1) {
        iwsKwsrateeurjpy1 = pIwsKwsrateeurjpy1;
    }

    @Column(order = 18, length = 5)
    private BizNumber iwsKwsrateeurjpy2;

    public BizNumber getIwsKwsrateeurjpy2() {
        return iwsKwsrateeurjpy2;
    }

    public void setIwsKwsrateeurjpy2(BizNumber pIwsKwsrateeurjpy2) {
        iwsKwsrateeurjpy2 = pIwsKwsrateeurjpy2;
    }

    @Column(order = 19, length = 5)
    private BizNumber iwsKwsrateeurjpy3;

    public BizNumber getIwsKwsrateeurjpy3() {
        return iwsKwsrateeurjpy3;
    }

    public void setIwsKwsrateeurjpy3(BizNumber pIwsKwsrateeurjpy3) {
        iwsKwsrateeurjpy3 = pIwsKwsrateeurjpy3;
    }

    @Column(order = 20, length = 5)
    private BizNumber iwsKwsrateeurjpy4;

    public BizNumber getIwsKwsrateeurjpy4() {
        return iwsKwsrateeurjpy4;
    }

    public void setIwsKwsrateeurjpy4(BizNumber pIwsKwsrateeurjpy4) {
        iwsKwsrateeurjpy4 = pIwsKwsrateeurjpy4;
    }

    @Column(order = 21, length = 5)
    private BizNumber iwsKwsrateeurjpy5;

    public BizNumber getIwsKwsrateeurjpy5() {
        return iwsKwsrateeurjpy5;
    }

    public void setIwsKwsrateeurjpy5(BizNumber pIwsKwsrateeurjpy5) {
        iwsKwsrateeurjpy5 = pIwsKwsrateeurjpy5;
    }

    @Column(order = 22, length = 8)
    private BizDate iwsKwsratetekiymdaudjpy1;

    public BizDate getIwsKwsratetekiymdaudjpy1() {
        return iwsKwsratetekiymdaudjpy1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdaudjpy1(BizDate pIwsKwsratetekiymdaudjpy1) {
        iwsKwsratetekiymdaudjpy1 = pIwsKwsratetekiymdaudjpy1;
    }

    @Column(order = 23, length = 8)
    private BizDate iwsKwsratetekiymdaudjpy2;

    public BizDate getIwsKwsratetekiymdaudjpy2() {
        return iwsKwsratetekiymdaudjpy2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdaudjpy2(BizDate pIwsKwsratetekiymdaudjpy2) {
        iwsKwsratetekiymdaudjpy2 = pIwsKwsratetekiymdaudjpy2;
    }

    @Column(order = 24, length = 8)
    private BizDate iwsKwsratetekiymdaudjpy3;

    public BizDate getIwsKwsratetekiymdaudjpy3() {
        return iwsKwsratetekiymdaudjpy3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdaudjpy3(BizDate pIwsKwsratetekiymdaudjpy3) {
        iwsKwsratetekiymdaudjpy3 = pIwsKwsratetekiymdaudjpy3;
    }

    @Column(order = 25, length = 8)
    private BizDate iwsKwsratetekiymdaudjpy4;

    public BizDate getIwsKwsratetekiymdaudjpy4() {
        return iwsKwsratetekiymdaudjpy4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdaudjpy4(BizDate pIwsKwsratetekiymdaudjpy4) {
        iwsKwsratetekiymdaudjpy4 = pIwsKwsratetekiymdaudjpy4;
    }

    @Column(order = 26, length = 8)
    private BizDate iwsKwsratetekiymdaudjpy5;

    public BizDate getIwsKwsratetekiymdaudjpy5() {
        return iwsKwsratetekiymdaudjpy5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdaudjpy5(BizDate pIwsKwsratetekiymdaudjpy5) {
        iwsKwsratetekiymdaudjpy5 = pIwsKwsratetekiymdaudjpy5;
    }

    @Column(order = 27, length = 5)
    private BizNumber iwsKwsrateaudjpy1;

    public BizNumber getIwsKwsrateaudjpy1() {
        return iwsKwsrateaudjpy1;
    }

    public void setIwsKwsrateaudjpy1(BizNumber pIwsKwsrateaudjpy1) {
        iwsKwsrateaudjpy1 = pIwsKwsrateaudjpy1;
    }

    @Column(order = 28, length = 5)
    private BizNumber iwsKwsrateaudjpy2;

    public BizNumber getIwsKwsrateaudjpy2() {
        return iwsKwsrateaudjpy2;
    }

    public void setIwsKwsrateaudjpy2(BizNumber pIwsKwsrateaudjpy2) {
        iwsKwsrateaudjpy2 = pIwsKwsrateaudjpy2;
    }

    @Column(order = 29, length = 5)
    private BizNumber iwsKwsrateaudjpy3;

    public BizNumber getIwsKwsrateaudjpy3() {
        return iwsKwsrateaudjpy3;
    }

    public void setIwsKwsrateaudjpy3(BizNumber pIwsKwsrateaudjpy3) {
        iwsKwsrateaudjpy3 = pIwsKwsrateaudjpy3;
    }

    @Column(order = 30, length = 5)
    private BizNumber iwsKwsrateaudjpy4;

    public BizNumber getIwsKwsrateaudjpy4() {
        return iwsKwsrateaudjpy4;
    }

    public void setIwsKwsrateaudjpy4(BizNumber pIwsKwsrateaudjpy4) {
        iwsKwsrateaudjpy4 = pIwsKwsrateaudjpy4;
    }

    @Column(order = 31, length = 5)
    private BizNumber iwsKwsrateaudjpy5;

    public BizNumber getIwsKwsrateaudjpy5() {
        return iwsKwsrateaudjpy5;
    }

    public void setIwsKwsrateaudjpy5(BizNumber pIwsKwsrateaudjpy5) {
        iwsKwsrateaudjpy5 = pIwsKwsrateaudjpy5;
    }

    @Column(order = 32, length = 8)
    private BizDate iwsKwsratetekiymdeurusd1;

    public BizDate getIwsKwsratetekiymdeurusd1() {
        return iwsKwsratetekiymdeurusd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeurusd1(BizDate pIwsKwsratetekiymdeurusd1) {
        iwsKwsratetekiymdeurusd1 = pIwsKwsratetekiymdeurusd1;
    }

    @Column(order = 33, length = 8)
    private BizDate iwsKwsratetekiymdeurusd2;

    public BizDate getIwsKwsratetekiymdeurusd2() {
        return iwsKwsratetekiymdeurusd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeurusd2(BizDate pIwsKwsratetekiymdeurusd2) {
        iwsKwsratetekiymdeurusd2 = pIwsKwsratetekiymdeurusd2;
    }

    @Column(order = 34, length = 8)
    private BizDate iwsKwsratetekiymdeurusd3;

    public BizDate getIwsKwsratetekiymdeurusd3() {
        return iwsKwsratetekiymdeurusd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeurusd3(BizDate pIwsKwsratetekiymdeurusd3) {
        iwsKwsratetekiymdeurusd3 = pIwsKwsratetekiymdeurusd3;
    }

    @Column(order = 35, length = 8)
    private BizDate iwsKwsratetekiymdeurusd4;

    public BizDate getIwsKwsratetekiymdeurusd4() {
        return iwsKwsratetekiymdeurusd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeurusd4(BizDate pIwsKwsratetekiymdeurusd4) {
        iwsKwsratetekiymdeurusd4 = pIwsKwsratetekiymdeurusd4;
    }

    @Column(order = 36, length = 8)
    private BizDate iwsKwsratetekiymdeurusd5;

    public BizDate getIwsKwsratetekiymdeurusd5() {
        return iwsKwsratetekiymdeurusd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeurusd5(BizDate pIwsKwsratetekiymdeurusd5) {
        iwsKwsratetekiymdeurusd5 = pIwsKwsratetekiymdeurusd5;
    }

    @Column(order = 37, length = 5)
    private BizNumber iwsKwsrateeurusd1;

    public BizNumber getIwsKwsrateeurusd1() {
        return iwsKwsrateeurusd1;
    }

    public void setIwsKwsrateeurusd1(BizNumber pIwsKwsrateeurusd1) {
        iwsKwsrateeurusd1 = pIwsKwsrateeurusd1;
    }

    @Column(order = 38, length = 5)
    private BizNumber iwsKwsrateeurusd2;

    public BizNumber getIwsKwsrateeurusd2() {
        return iwsKwsrateeurusd2;
    }

    public void setIwsKwsrateeurusd2(BizNumber pIwsKwsrateeurusd2) {
        iwsKwsrateeurusd2 = pIwsKwsrateeurusd2;
    }

    @Column(order = 39, length = 5)
    private BizNumber iwsKwsrateeurusd3;

    public BizNumber getIwsKwsrateeurusd3() {
        return iwsKwsrateeurusd3;
    }

    public void setIwsKwsrateeurusd3(BizNumber pIwsKwsrateeurusd3) {
        iwsKwsrateeurusd3 = pIwsKwsrateeurusd3;
    }

    @Column(order = 40, length = 5)
    private BizNumber iwsKwsrateeurusd4;

    public BizNumber getIwsKwsrateeurusd4() {
        return iwsKwsrateeurusd4;
    }

    public void setIwsKwsrateeurusd4(BizNumber pIwsKwsrateeurusd4) {
        iwsKwsrateeurusd4 = pIwsKwsrateeurusd4;
    }

    @Column(order = 41, length = 5)
    private BizNumber iwsKwsrateeurusd5;

    public BizNumber getIwsKwsrateeurusd5() {
        return iwsKwsrateeurusd5;
    }

    public void setIwsKwsrateeurusd5(BizNumber pIwsKwsrateeurusd5) {
        iwsKwsrateeurusd5 = pIwsKwsrateeurusd5;
    }

    @Column(order = 42, length = 8)
    private BizDate iwsKwsratetekiymdeuraud1;

    public BizDate getIwsKwsratetekiymdeuraud1() {
        return iwsKwsratetekiymdeuraud1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeuraud1(BizDate pIwsKwsratetekiymdeuraud1) {
        iwsKwsratetekiymdeuraud1 = pIwsKwsratetekiymdeuraud1;
    }

    @Column(order = 43, length = 8)
    private BizDate iwsKwsratetekiymdeuraud2;

    public BizDate getIwsKwsratetekiymdeuraud2() {
        return iwsKwsratetekiymdeuraud2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeuraud2(BizDate pIwsKwsratetekiymdeuraud2) {
        iwsKwsratetekiymdeuraud2 = pIwsKwsratetekiymdeuraud2;
    }

    @Column(order = 44, length = 8)
    private BizDate iwsKwsratetekiymdeuraud3;

    public BizDate getIwsKwsratetekiymdeuraud3() {
        return iwsKwsratetekiymdeuraud3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeuraud3(BizDate pIwsKwsratetekiymdeuraud3) {
        iwsKwsratetekiymdeuraud3 = pIwsKwsratetekiymdeuraud3;
    }

    @Column(order = 45, length = 8)
    private BizDate iwsKwsratetekiymdeuraud4;

    public BizDate getIwsKwsratetekiymdeuraud4() {
        return iwsKwsratetekiymdeuraud4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeuraud4(BizDate pIwsKwsratetekiymdeuraud4) {
        iwsKwsratetekiymdeuraud4 = pIwsKwsratetekiymdeuraud4;
    }

    @Column(order = 46, length = 8)
    private BizDate iwsKwsratetekiymdeuraud5;

    public BizDate getIwsKwsratetekiymdeuraud5() {
        return iwsKwsratetekiymdeuraud5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdeuraud5(BizDate pIwsKwsratetekiymdeuraud5) {
        iwsKwsratetekiymdeuraud5 = pIwsKwsratetekiymdeuraud5;
    }

    @Column(order = 47, length = 5)
    private BizNumber iwsKwsrateeuraud1;

    public BizNumber getIwsKwsrateeuraud1() {
        return iwsKwsrateeuraud1;
    }

    public void setIwsKwsrateeuraud1(BizNumber pIwsKwsrateeuraud1) {
        iwsKwsrateeuraud1 = pIwsKwsrateeuraud1;
    }

    @Column(order = 48, length = 5)
    private BizNumber iwsKwsrateeuraud2;

    public BizNumber getIwsKwsrateeuraud2() {
        return iwsKwsrateeuraud2;
    }

    public void setIwsKwsrateeuraud2(BizNumber pIwsKwsrateeuraud2) {
        iwsKwsrateeuraud2 = pIwsKwsrateeuraud2;
    }

    @Column(order = 49, length = 5)
    private BizNumber iwsKwsrateeuraud3;

    public BizNumber getIwsKwsrateeuraud3() {
        return iwsKwsrateeuraud3;
    }

    public void setIwsKwsrateeuraud3(BizNumber pIwsKwsrateeuraud3) {
        iwsKwsrateeuraud3 = pIwsKwsrateeuraud3;
    }

    @Column(order = 50, length = 5)
    private BizNumber iwsKwsrateeuraud4;

    public BizNumber getIwsKwsrateeuraud4() {
        return iwsKwsrateeuraud4;
    }

    public void setIwsKwsrateeuraud4(BizNumber pIwsKwsrateeuraud4) {
        iwsKwsrateeuraud4 = pIwsKwsrateeuraud4;
    }

    @Column(order = 51, length = 5)
    private BizNumber iwsKwsrateeuraud5;

    public BizNumber getIwsKwsrateeuraud5() {
        return iwsKwsrateeuraud5;
    }

    public void setIwsKwsrateeuraud5(BizNumber pIwsKwsrateeuraud5) {
        iwsKwsrateeuraud5 = pIwsKwsrateeuraud5;
    }

    @Column(order = 52, length = 8)
    private BizDate iwsKwsratetekiymdaudusd1;

    public BizDate getIwsKwsratetekiymdaudusd1() {
        return iwsKwsratetekiymdaudusd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdaudusd1(BizDate pIwsKwsratetekiymdaudusd1) {
        iwsKwsratetekiymdaudusd1 = pIwsKwsratetekiymdaudusd1;
    }

    @Column(order = 53, length = 8)
    private BizDate iwsKwsratetekiymdaudusd2;

    public BizDate getIwsKwsratetekiymdaudusd2() {
        return iwsKwsratetekiymdaudusd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdaudusd2(BizDate pIwsKwsratetekiymdaudusd2) {
        iwsKwsratetekiymdaudusd2 = pIwsKwsratetekiymdaudusd2;
    }

    @Column(order = 54, length = 8)
    private BizDate iwsKwsratetekiymdaudusd3;

    public BizDate getIwsKwsratetekiymdaudusd3() {
        return iwsKwsratetekiymdaudusd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdaudusd3(BizDate pIwsKwsratetekiymdaudusd3) {
        iwsKwsratetekiymdaudusd3 = pIwsKwsratetekiymdaudusd3;
    }

    @Column(order = 55, length = 8)
    private BizDate iwsKwsratetekiymdaudusd4;

    public BizDate getIwsKwsratetekiymdaudusd4() {
        return iwsKwsratetekiymdaudusd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdaudusd4(BizDate pIwsKwsratetekiymdaudusd4) {
        iwsKwsratetekiymdaudusd4 = pIwsKwsratetekiymdaudusd4;
    }

    @Column(order = 56, length = 8)
    private BizDate iwsKwsratetekiymdaudusd5;

    public BizDate getIwsKwsratetekiymdaudusd5() {
        return iwsKwsratetekiymdaudusd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdaudusd5(BizDate pIwsKwsratetekiymdaudusd5) {
        iwsKwsratetekiymdaudusd5 = pIwsKwsratetekiymdaudusd5;
    }

    @Column(order = 57, length = 5)
    private BizNumber iwsKwsrateaudusd1;

    public BizNumber getIwsKwsrateaudusd1() {
        return iwsKwsrateaudusd1;
    }

    public void setIwsKwsrateaudusd1(BizNumber pIwsKwsrateaudusd1) {
        iwsKwsrateaudusd1 = pIwsKwsrateaudusd1;
    }

    @Column(order = 58, length = 5)
    private BizNumber iwsKwsrateaudusd2;

    public BizNumber getIwsKwsrateaudusd2() {
        return iwsKwsrateaudusd2;
    }

    public void setIwsKwsrateaudusd2(BizNumber pIwsKwsrateaudusd2) {
        iwsKwsrateaudusd2 = pIwsKwsrateaudusd2;
    }

    @Column(order = 59, length = 5)
    private BizNumber iwsKwsrateaudusd3;

    public BizNumber getIwsKwsrateaudusd3() {
        return iwsKwsrateaudusd3;
    }

    public void setIwsKwsrateaudusd3(BizNumber pIwsKwsrateaudusd3) {
        iwsKwsrateaudusd3 = pIwsKwsrateaudusd3;
    }

    @Column(order = 60, length = 5)
    private BizNumber iwsKwsrateaudusd4;

    public BizNumber getIwsKwsrateaudusd4() {
        return iwsKwsrateaudusd4;
    }

    public void setIwsKwsrateaudusd4(BizNumber pIwsKwsrateaudusd4) {
        iwsKwsrateaudusd4 = pIwsKwsrateaudusd4;
    }

    @Column(order = 61, length = 5)
    private BizNumber iwsKwsrateaudusd5;

    public BizNumber getIwsKwsrateaudusd5() {
        return iwsKwsrateaudusd5;
    }

    public void setIwsKwsrateaudusd5(BizNumber pIwsKwsrateaudusd5) {
        iwsKwsrateaudusd5 = pIwsKwsrateaudusd5;
    }

    @Column(order = 62, length = 8)
    private BizDate iwsKwsratetekiymdusdaud1;

    public BizDate getIwsKwsratetekiymdusdaud1() {
        return iwsKwsratetekiymdusdaud1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdusdaud1(BizDate pIwsKwsratetekiymdusdaud1) {
        iwsKwsratetekiymdusdaud1 = pIwsKwsratetekiymdusdaud1;
    }

    @Column(order = 63, length = 8)
    private BizDate iwsKwsratetekiymdusdaud2;

    public BizDate getIwsKwsratetekiymdusdaud2() {
        return iwsKwsratetekiymdusdaud2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdusdaud2(BizDate pIwsKwsratetekiymdusdaud2) {
        iwsKwsratetekiymdusdaud2 = pIwsKwsratetekiymdusdaud2;
    }

    @Column(order = 64, length = 8)
    private BizDate iwsKwsratetekiymdusdaud3;

    public BizDate getIwsKwsratetekiymdusdaud3() {
        return iwsKwsratetekiymdusdaud3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdusdaud3(BizDate pIwsKwsratetekiymdusdaud3) {
        iwsKwsratetekiymdusdaud3 = pIwsKwsratetekiymdusdaud3;
    }

    @Column(order = 65, length = 8)
    private BizDate iwsKwsratetekiymdusdaud4;

    public BizDate getIwsKwsratetekiymdusdaud4() {
        return iwsKwsratetekiymdusdaud4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdusdaud4(BizDate pIwsKwsratetekiymdusdaud4) {
        iwsKwsratetekiymdusdaud4 = pIwsKwsratetekiymdusdaud4;
    }

    @Column(order = 66, length = 8)
    private BizDate iwsKwsratetekiymdusdaud5;

    public BizDate getIwsKwsratetekiymdusdaud5() {
        return iwsKwsratetekiymdusdaud5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKwsratetekiymdusdaud5(BizDate pIwsKwsratetekiymdusdaud5) {
        iwsKwsratetekiymdusdaud5 = pIwsKwsratetekiymdusdaud5;
    }

    @Column(order = 67, length = 5)
    private BizNumber iwsKwsrateusdaud1;

    public BizNumber getIwsKwsrateusdaud1() {
        return iwsKwsrateusdaud1;
    }

    public void setIwsKwsrateusdaud1(BizNumber pIwsKwsrateusdaud1) {
        iwsKwsrateusdaud1 = pIwsKwsrateusdaud1;
    }

    @Column(order = 68, length = 5)
    private BizNumber iwsKwsrateusdaud2;

    public BizNumber getIwsKwsrateusdaud2() {
        return iwsKwsrateusdaud2;
    }

    public void setIwsKwsrateusdaud2(BizNumber pIwsKwsrateusdaud2) {
        iwsKwsrateusdaud2 = pIwsKwsrateusdaud2;
    }

    @Column(order = 69, length = 5)
    private BizNumber iwsKwsrateusdaud3;

    public BizNumber getIwsKwsrateusdaud3() {
        return iwsKwsrateusdaud3;
    }

    public void setIwsKwsrateusdaud3(BizNumber pIwsKwsrateusdaud3) {
        iwsKwsrateusdaud3 = pIwsKwsrateusdaud3;
    }

    @Column(order = 70, length = 5)
    private BizNumber iwsKwsrateusdaud4;

    public BizNumber getIwsKwsrateusdaud4() {
        return iwsKwsrateusdaud4;
    }

    public void setIwsKwsrateusdaud4(BizNumber pIwsKwsrateusdaud4) {
        iwsKwsrateusdaud4 = pIwsKwsrateusdaud4;
    }

    @Column(order = 71, length = 5)
    private BizNumber iwsKwsrateusdaud5;

    public BizNumber getIwsKwsrateusdaud5() {
        return iwsKwsrateusdaud5;
    }

    public void setIwsKwsrateusdaud5(BizNumber pIwsKwsrateusdaud5) {
        iwsKwsrateusdaud5 = pIwsKwsrateusdaud5;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
