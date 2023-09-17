package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;

/**
 * （共通）ＦＢ送金集計リスト明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbsoukinsyuukeilistDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFbsoukinsyuukeilistDetailBean() {
    }

    private String irDensyskbnval;

    public String getIrDensyskbnval() {
        return irDensyskbnval;
    }

    public void setIrDensyskbnval(String pIrDensyskbnval) {
        irDensyskbnval = pIrDensyskbnval;
    }

    private String irDensyorikbnval;

    public String getIrDensyorikbnval() {
        return irDensyorikbnval;
    }

    public void setIrDensyorikbnval(String pIrDensyorikbnval) {
        irDensyorikbnval = pIrDensyorikbnval;
    }

    private Integer irKensusyoukei;

    public Integer getIrKensusyoukei() {
        return irKensusyoukei;
    }

    public void setIrKensusyoukei(Integer pIrKensusyoukei) {
        irKensusyoukei = pIrKensusyoukei;
    }

    private BizCurrency irKgsyoukei;

    public BizCurrency getIrKgsyoukei() {
        return irKgsyoukei;
    }

    public void setIrKgsyoukei(BizCurrency pIrKgsyoukei) {
        irKgsyoukei = pIrKgsyoukei;
    }

    private C_DensysKbn irDensyskbn;

    public C_DensysKbn getIrDensyskbn() {
        return irDensyskbn;
    }

    public void setIrDensyskbn(C_DensysKbn pIrDensyskbn) {
        irDensyskbn = pIrDensyskbn;
    }

    private C_DensyoriKbn irDensyorikbn;

    public C_DensyoriKbn getIrDensyorikbn() {
        return irDensyorikbn;
    }

    public void setIrDensyorikbn(C_DensyoriKbn pIrDensyorikbn) {
        irDensyorikbn = pIrDensyorikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
