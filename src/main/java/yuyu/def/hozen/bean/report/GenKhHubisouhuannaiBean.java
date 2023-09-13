package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_UmuKbn;

/**
 * （保全）不備送付案内帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhHubisouhuannaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhHubisouhuannaiBean() {
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
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

    private String irRenrakuarea;

    public String getIrRenrakuarea() {
        return irRenrakuarea;
    }

    public void setIrRenrakuarea(String pIrRenrakuarea) {
        irRenrakuarea = pIrRenrakuarea;
    }

    private String irHubianswerkjt;

    public String getIrHubianswerkjt() {
        return irHubianswerkjt;
    }

    public void setIrHubianswerkjt(String pIrHubianswerkjt) {
        irHubianswerkjt = pIrHubianswerkjt;
    }

    private C_UmuKbn irDrtenshumu;

    public C_UmuKbn getIrDrtenshumu() {
        return irDrtenshumu;
    }

    public void setIrDrtenshumu(C_UmuKbn pIrDrtenshumu) {
        irDrtenshumu = pIrDrtenshumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
