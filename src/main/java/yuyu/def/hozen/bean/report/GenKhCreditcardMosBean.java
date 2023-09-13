package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）クレジットカード扱い申込書帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhCreditcardMosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhCreditcardMosBean() {
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irCreditkessaiyouno;

    public String getIrCreditkessaiyouno() {
        return irCreditkessaiyouno;
    }

    public void setIrCreditkessaiyouno(String pIrCreditkessaiyouno) {
        irCreditkessaiyouno = pIrCreditkessaiyouno;
    }

    private String irKyksyanmkn;

    public String getIrKyksyanmkn() {
        return irKyksyanmkn;
    }

    public void setIrKyksyanmkn(String pIrKyksyanmkn) {
        irKyksyanmkn = pIrKyksyanmkn;
    }

    private String irKyksyatel;

    public String getIrKyksyatel() {
        return irKyksyatel;
    }

    public void setIrKyksyatel(String pIrKyksyatel) {
        irKyksyatel = pIrKyksyatel;
    }

    private String irToritsugisyasyozokunm;

    public String getIrToritsugisyasyozokunm() {
        return irToritsugisyasyozokunm;
    }

    public void setIrToritsugisyasyozokunm(String pIrToritsugisyasyozokunm) {
        irToritsugisyasyozokunm = pIrToritsugisyasyozokunm;
    }

    private String irToritsugisyakjncd;

    public String getIrToritsugisyakjncd() {
        return irToritsugisyakjncd;
    }

    public void setIrToritsugisyakjncd(String pIrToritsugisyakjncd) {
        irToritsugisyakjncd = pIrToritsugisyakjncd;
    }

    private String irToritsugisyanm;

    public String getIrToritsugisyanm() {
        return irToritsugisyanm;
    }

    public void setIrToritsugisyanm(String pIrToritsugisyanm) {
        irToritsugisyanm = pIrToritsugisyanm;
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    private String irHozonkkn;

    public String getIrHozonkkn() {
        return irHozonkkn;
    }

    public void setIrHozonkkn(String pIrHozonkkn) {
        irHozonkkn = pIrHozonkkn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
