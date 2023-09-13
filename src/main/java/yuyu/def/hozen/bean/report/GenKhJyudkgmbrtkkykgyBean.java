package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）重度介護前払特約契約概要帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhJyudkgmbrtkkykgyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhJyudkgmbrtkkykgyBean() {
    }

    private String irKyknm;

    public String getIrKyknm() {
        return irKyknm;
    }

    public void setIrKyknm(String pIrKyknm) {
        irKyknm = pIrKyknm;
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

    private String irToritsugisyasyozokunm;

    public String getIrToritsugisyasyozokunm() {
        return irToritsugisyasyozokunm;
    }

    public void setIrToritsugisyasyozokunm(String pIrToritsugisyasyozokunm) {
        irToritsugisyasyozokunm = pIrToritsugisyasyozokunm;
    }

    private String irToritsugisyanm;

    public String getIrToritsugisyanm() {
        return irToritsugisyanm;
    }

    public void setIrToritsugisyanm(String pIrToritsugisyanm) {
        irToritsugisyanm = pIrToritsugisyanm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
