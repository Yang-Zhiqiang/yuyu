package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;

/**
 * （保全）生命保険料口座振替依頼書帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhPkzhrikeIraisyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhPkzhrikeIraisyoBean() {
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private C_Hrkkaisuu irHrkkaisuu;

    public C_Hrkkaisuu getIrHrkkaisuu() {
        return irHrkkaisuu;
    }

    public void setIrHrkkaisuu(C_Hrkkaisuu pIrHrkkaisuu) {
        irHrkkaisuu = pIrHrkkaisuu;
    }

    private C_TkiktbrisyuruiKbn irTikiktbrisyuruikbn;

    public C_TkiktbrisyuruiKbn getIrTikiktbrisyuruikbn() {
        return irTikiktbrisyuruikbn;
    }

    public void setIrTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pIrTikiktbrisyuruikbn) {
        irTikiktbrisyuruikbn = pIrTikiktbrisyuruikbn;
    }

    private C_TaisyouKbn irTikiktbriTaisyoukbn;

    public C_TaisyouKbn getIrTikiktbriTaisyoukbn() {
        return irTikiktbriTaisyoukbn;
    }

    public void setIrTikiktbriTaisyoukbn(C_TaisyouKbn pIrTikiktbriTaisyoukbn) {
        irTikiktbriTaisyoukbn = pIrTikiktbriTaisyoukbn;
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
