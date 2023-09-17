package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;

/**
 * （保険募集）生保Ｗｅｂ前納保険料計算出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebZennouKeisanOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebZennouKeisanOutputBean() {
    }

    @Column(order = 1, length = 1)
    private String iwsErrkbn;

    public String getIwsErrkbn() {
        return iwsErrkbn;
    }

    public void setIwsErrkbn(String pIwsErrkbn) {
        iwsErrkbn = pIwsErrkbn;
    }

    @Column(order = 2, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsYenznnpnotinc;

    public BizNumber getIwsYenznnpnotinc() {
        return iwsYenznnpnotinc;
    }

    public void setIwsYenznnpnotinc(BizNumber pIwsYenznnpnotinc) {
        iwsYenznnpnotinc = pIwsYenznnpnotinc;
    }

    @Column(order = 3, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsYenznnpinclude;

    public BizNumber getIwsYenznnpinclude() {
        return iwsYenznnpinclude;
    }

    public void setIwsYenznnpinclude(BizNumber pIwsYenznnpinclude) {
        iwsYenznnpinclude = pIwsYenznnpinclude;
    }

    @Column(order = 4, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikaznnpnotinc;

    public BizNumber getIwsGaikaznnpnotinc() {
        return iwsGaikaznnpnotinc;
    }

    public void setIwsGaikaznnpnotinc(BizNumber pIwsGaikaznnpnotinc) {
        iwsGaikaznnpnotinc = pIwsGaikaznnpnotinc;
    }

    @Column(order = 5, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikaznnpinclude;

    public BizNumber getIwsGaikaznnpinclude() {
        return iwsGaikaznnpinclude;
    }

    public void setIwsGaikaznnpinclude(BizNumber pIwsGaikaznnpinclude) {
        iwsGaikaznnpinclude = pIwsGaikaznnpinclude;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
