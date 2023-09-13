package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）マイナス売上契約明細リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhMinusUriageKykDtlListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhMinusUriageKykDtlListBean() {
    }

    private String irTantousitunm;

    public String getIrTantousitunm() {
        return irTantousitunm;
    }

    public void setIrTantousitunm(String pIrTantousitunm) {
        irTantousitunm = pIrTantousitunm;
    }

    private BizDate irSyoribi;

    public BizDate getIrSyoribi() {
        return irSyoribi;
    }

    public void setIrSyoribi(BizDate pIrSyoribi) {
        irSyoribi = pIrSyoribi;
    }

    private Integer irKensuu;

    public Integer getIrKensuu() {
        return irKensuu;
    }

    public void setIrKensuu(Integer pIrKensuu) {
        irKensuu = pIrKensuu;
    }

    private BizCurrency irGoukeikingk;

    public BizCurrency getIrGoukeikingk() {
        return irGoukeikingk;
    }

    public void setIrGoukeikingk(BizCurrency pIrGoukeikingk) {
        irGoukeikingk = pIrGoukeikingk;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
