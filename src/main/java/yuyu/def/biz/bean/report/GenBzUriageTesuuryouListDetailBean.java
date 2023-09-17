package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）クレジットカード売上手数料リスト明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzUriageTesuuryouListDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzUriageTesuuryouListDetailBean() {
    }

    private String irAnsyuusyskbnvalue;

    public String getIrAnsyuusyskbnvalue() {
        return irAnsyuusyskbnvalue;
    }

    public void setIrAnsyuusyskbnvalue(String pIrAnsyuusyskbnvalue) {
        irAnsyuusyskbnvalue = pIrAnsyuusyskbnvalue;
    }

    private String irCardkaisyanmryk;

    public String getIrCardkaisyanmryk() {
        return irCardkaisyanmryk;
    }

    public void setIrCardkaisyanmryk(String pIrCardkaisyanmryk) {
        irCardkaisyanmryk = pIrCardkaisyanmryk;
    }

    private BizCurrency irUriagegkgoukei;

    public BizCurrency getIrUriagegkgoukei() {
        return irUriagegkgoukei;
    }

    public void setIrUriagegkgoukei(BizCurrency pIrUriagegkgoukei) {
        irUriagegkgoukei = pIrUriagegkgoukei;
    }

    private BizNumber irTesuuryouryouritu;

    public BizNumber getIrTesuuryouryouritu() {
        return irTesuuryouryouritu;
    }

    public void setIrTesuuryouryouritu(BizNumber pIrTesuuryouryouritu) {
        irTesuuryouryouritu = pIrTesuuryouryouritu;
    }

    private BizCurrency irTsrygk;

    public BizCurrency getIrTsrygk() {
        return irTsrygk;
    }

    public void setIrTsrygk(BizCurrency pIrTsrygk) {
        irTsrygk = pIrTsrygk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
