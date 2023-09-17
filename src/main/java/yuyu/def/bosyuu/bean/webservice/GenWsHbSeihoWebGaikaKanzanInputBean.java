package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保険募集）生保Ｗｅｂ外貨換算入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebGaikaKanzanInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebGaikaKanzanInputBean() {
    }

    @Column(order = 1, length = 8)
    @ValidDate
    private BizDate iwsKijyunymd;

    public BizDate getIwsKijyunymd() {
        return iwsKijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsKijyunymd(BizDate pIwsKijyunymd) {
        iwsKijyunymd = pIwsKijyunymd;
    }

    @Column(order = 2, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHaraikomikaisuukbn;

    public String getIwsHaraikomikaisuukbn() {
        return iwsHaraikomikaisuukbn;
    }

    public void setIwsHaraikomikaisuukbn(String pIwsHaraikomikaisuukbn) {
        iwsHaraikomikaisuukbn = pIwsHaraikomikaisuukbn;
    }

    @Column(order = 3, length = 1)
    @Length(length=1)
    private String iwsZennouhyouji;

    public String getIwsZennouhyouji() {
        return iwsZennouhyouji;
    }

    public void setIwsZennouhyouji(String pIwsZennouhyouji) {
        iwsZennouhyouji = pIwsZennouhyouji;
    }

    @Column(order = 4, length = 1)
    @Length(length=1)
    private String iwsKinoukbn;

    public String getIwsKinoukbn() {
        return iwsKinoukbn;
    }

    public void setIwsKinoukbn(String pIwsKinoukbn) {
        iwsKinoukbn = pIwsKinoukbn;
    }

    @Column(order = 5, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHrktuukakbn;

    public String getIwsHrktuukakbn() {
        return iwsHrktuukakbn;
    }

    public void setIwsHrktuukakbn(String pIwsHrktuukakbn) {
        iwsHrktuukakbn = pIwsHrktuukakbn;
    }

    @Column(order = 6, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsKyktuukakbn;

    public String getIwsKyktuukakbn() {
        return iwsKyktuukakbn;
    }

    public void setIwsKyktuukakbn(String pIwsKyktuukakbn) {
        iwsKyktuukakbn = pIwsKyktuukakbn;
    }

    @Column(order = 7, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsKnsnmaeyenp;

    public BizNumber getIwsKnsnmaeyenp() {
        return iwsKnsnmaeyenp;
    }

    public void setIwsKnsnmaeyenp(BizNumber pIwsKnsnmaeyenp) {
        iwsKnsnmaeyenp = pIwsKnsnmaeyenp;
    }

    @Column(order = 8, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsKnsnmaegkp;

    public BizNumber getIwsKnsnmaegkp() {
        return iwsKnsnmaegkp;
    }

    public void setIwsKnsnmaegkp(BizNumber pIwsKnsnmaegkp) {
        iwsKnsnmaegkp = pIwsKnsnmaegkp;
    }

    @Column(order = 9, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsKnsnmaegkzennoup;

    public BizNumber getIwsKnsnmaegkzennoup() {
        return iwsKnsnmaegkzennoup;
    }

    public void setIwsKnsnmaegkzennoup(BizNumber pIwsKnsnmaegkzennoup) {
        iwsKnsnmaegkzennoup = pIwsKnsnmaegkzennoup;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
