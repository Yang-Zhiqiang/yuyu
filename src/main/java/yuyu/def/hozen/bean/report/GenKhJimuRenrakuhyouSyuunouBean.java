package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）事務連絡票（収納）帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhJimuRenrakuhyouSyuunouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhJimuRenrakuhyouSyuunouBean() {
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irKinounm;

    public String getIrKinounm() {
        return irKinounm;
    }

    public void setIrKinounm(String pIrKinounm) {
        irKinounm = pIrKinounm;
    }

    private String irTantcd;

    public String getIrTantcd() {
        return irTantcd;
    }

    public void setIrTantcd(String pIrTantcd) {
        irTantcd = pIrTantcd;
    }

    private String irTantnm;

    public String getIrTantnm() {
        return irTantnm;
    }

    public void setIrTantnm(String pIrTantnm) {
        irTantnm = pIrTantnm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
