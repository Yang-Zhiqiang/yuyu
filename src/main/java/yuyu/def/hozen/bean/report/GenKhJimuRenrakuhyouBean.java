package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）事務連絡票帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhJimuRenrakuhyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhJimuRenrakuhyouBean() {
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

    private String irSosikicd;

    public String getIrSosikicd() {
        return irSosikicd;
    }

    public void setIrSosikicd(String pIrSosikicd) {
        irSosikicd = pIrSosikicd;
    }

    private String irSosikinm;

    public String getIrSosikinm() {
        return irSosikinm;
    }

    public void setIrSosikinm(String pIrSosikinm) {
        irSosikinm = pIrSosikinm;
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

    private String irHozonkkn;

    public String getIrHozonkkn() {
        return irHozonkkn;
    }

    public void setIrHozonkkn(String pIrHozonkkn) {
        irHozonkkn = pIrHozonkkn;
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
