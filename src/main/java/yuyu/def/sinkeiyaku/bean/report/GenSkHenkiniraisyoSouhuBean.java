package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_UmuKbn;

/**
 * （新契約）返金依頼書(送付案内)帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkHenkiniraisyoSouhuBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkHenkiniraisyoSouhuBean() {
    }


    private String irMosno;


    public String getIrMosno() {
        return irMosno;
    }


    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }


    private String irKyknmkj;


    public String getIrKyknmkj() {
        return irKyknmkj;
    }


    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }


    private BizDate irSyokairsymd;


    public BizDate getIrSyokairsymd() {
        return irSyokairsymd;
    }


    public void setIrSyokairsymd(BizDate pIrSyokairsymd) {
        irSyokairsymd = pIrSyokairsymd;
    }


    private BizCurrency irRsgaku;


    public BizCurrency getIrRsgaku() {
        return irRsgaku;
    }


    public void setIrRsgaku(BizCurrency pIrRsgaku) {
        irRsgaku = pIrRsgaku;
    }


    private BizCurrency irDai1kaip;


    public BizCurrency getIrDai1kaip() {
        return irDai1kaip;
    }


    public void setIrDai1kaip(BizCurrency pIrDai1kaip) {
        irDai1kaip = pIrDai1kaip;
    }


    private BizCurrency irKajyoup;


    public BizCurrency getIrKajyoup() {
        return irKajyoup;
    }


    public void setIrKajyoup(BizCurrency pIrKajyoup) {
        irKajyoup = pIrKajyoup;
    }


    private C_UmuKbn irKajyoupumu;


    public C_UmuKbn getIrKajyoupumu() {
        return irKajyoupumu;
    }


    public void setIrKajyoupumu(C_UmuKbn pIrKajyoupumu) {
        irKajyoupumu = pIrKajyoupumu;
    }


    private C_UmuKbn irNyknnrkumu;


    public C_UmuKbn getIrNyknnrkumu() {
        return irNyknnrkumu;
    }


    public void setIrNyknnrkumu(C_UmuKbn pIrNyknnrkumu) {
        irNyknnrkumu = pIrNyknnrkumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
