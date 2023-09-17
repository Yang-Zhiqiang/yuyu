package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;

/**
 * （保険募集）生保Ｗｅｂ前納保険料計算入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebZennouKeisanInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebZennouKeisanInputBean() {
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

    @Column(order = 2, length = 2)
    @MaxLength(max=2)
    private String iwsZennoukkn;

    public String getIwsZennoukkn() {
        return iwsZennoukkn;
    }

    public void setIwsZennoukkn(String pIwsZennoukkn) {
        iwsZennoukkn = pIwsZennoukkn;
    }

    @Column(order = 3, length = 1)
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsKyktuukakbn;

    public String getIwsKyktuukakbn() {
        return iwsKyktuukakbn;
    }

    public void setIwsKyktuukakbn(String pIwsKyktuukakbn) {
        iwsKyktuukakbn = pIwsKyktuukakbn;
    }

    @Column(order = 4, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsYenfstp;

    public BizNumber getIwsYenfstp() {
        return iwsYenfstp;
    }

    public void setIwsYenfstp(BizNumber pIwsYenfstp) {
        iwsYenfstp = pIwsYenfstp;
    }

    @Column(order = 5, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikafstp;

    public BizNumber getIwsGaikafstp() {
        return iwsGaikafstp;
    }

    public void setIwsGaikafstp(BizNumber pIwsGaikafstp) {
        iwsGaikafstp = pIwsGaikafstp;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
