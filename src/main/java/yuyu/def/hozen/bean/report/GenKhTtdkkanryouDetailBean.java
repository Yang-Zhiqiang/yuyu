package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）手続完了明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhTtdkkanryouDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhTtdkkanryouDetailBean() {
    }

    private String irTekiyou;

    public String getIrTekiyou() {
        return irTekiyou;
    }

    public void setIrTekiyou(String pIrTekiyou) {
        irTekiyou = pIrTekiyou;
    }

    private BizCurrency irShrgk;

    public BizCurrency getIrShrgk() {
        return irShrgk;
    }

    public void setIrShrgk(BizCurrency pIrShrgk) {
        irShrgk = pIrShrgk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
