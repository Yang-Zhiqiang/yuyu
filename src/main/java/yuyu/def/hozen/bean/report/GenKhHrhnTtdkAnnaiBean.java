package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Hrkkeiro;

/**
 * （保全）払変手続案内帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhHrhnTtdkAnnaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhHrhnTtdkAnnaiBean() {
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irKyknmkj;

    public String getIrKyknmkj() {
        return irKyknmkj;
    }

    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }

    private String irTeisyutusyorui;

    public String getIrTeisyutusyorui() {
        return irTeisyutusyorui;
    }

    public void setIrTeisyutusyorui(String pIrTeisyutusyorui) {
        irTeisyutusyorui = pIrTeisyutusyorui;
    }

    private C_Hrkkeiro irHrkkeiro;

    public C_Hrkkeiro getIrHrkkeiro() {
        return irHrkkeiro;
    }

    public void setIrHrkkeiro(C_Hrkkeiro pIrHrkkeiro) {
        irHrkkeiro = pIrHrkkeiro;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
