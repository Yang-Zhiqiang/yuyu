package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;

/**
 * （保険募集）生保Ｗｅｂ外貨換算出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebGaikaKanzanOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebGaikaKanzanOutputBean() {
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
    private BizDate iwsKnsnkwsratetekiymd;

    public BizDate getIwsKnsnkwsratetekiymd() {
        return iwsKnsnkwsratetekiymd;
    }

    public void setIwsKnsnkwsratetekiymd(BizDate pIwsKnsnkwsratetekiymd) {
        iwsKnsnkwsratetekiymd = pIwsKnsnkwsratetekiymd;
    }

    @Column(order = 3, length = 5)
    private BizNumber iwsKnsnkawaserate;

    public BizNumber getIwsKnsnkawaserate() {
        return iwsKnsnkawaserate;
    }

    public void setIwsKnsnkawaserate(BizNumber pIwsKnsnkawaserate) {
        iwsKnsnkawaserate = pIwsKnsnkawaserate;
    }

    @Column(order = 4, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsKnsngoyenp;

    public BizNumber getIwsKnsngoyenp() {
        return iwsKnsngoyenp;
    }

    public void setIwsKnsngoyenp(BizNumber pIwsKnsngoyenp) {
        iwsKnsngoyenp = pIwsKnsngoyenp;
    }

    @Column(order = 5, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsKnsngogkp;

    public BizNumber getIwsKnsngogkp() {
        return iwsKnsngogkp;
    }

    public void setIwsKnsngogkp(BizNumber pIwsKnsngogkp) {
        iwsKnsngogkp = pIwsKnsngogkp;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
