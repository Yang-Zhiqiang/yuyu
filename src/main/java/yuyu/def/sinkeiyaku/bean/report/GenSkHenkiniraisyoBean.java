package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * （新契約）返金依頼書帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkHenkiniraisyoBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkHenkiniraisyoBean() {
    }


    private String irMosno;


    public String getIrMosno() {
        return irMosno;
    }


    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }


    private C_Ketkekkacd irKetkekkacd;


    public C_Ketkekkacd getIrKetkekkacd() {
        return irKetkekkacd;
    }


    public void setIrKetkekkacd(C_Ketkekkacd pIrKetkekkacd) {
        irKetkekkacd = pIrKetkekkacd;
    }


    private C_SkeijimuKbn irSkeijimukbn;


    public C_SkeijimuKbn getIrSkeijimukbn() {
        return irSkeijimukbn;
    }


    public void setIrSkeijimukbn(C_SkeijimuKbn pIrSkeijimukbn) {
        irSkeijimukbn = pIrSkeijimukbn;
    }


    private C_KouzasyuruiKbn irKouzasyuruikbn;


    public C_KouzasyuruiKbn getIrKouzasyuruikbn() {
        return irKouzasyuruikbn;
    }


    public void setIrKouzasyuruikbn(C_KouzasyuruiKbn pIrKouzasyuruikbn) {
        irKouzasyuruikbn = pIrKouzasyuruikbn;
    }


    private C_UmuKbn irKznrkumu;


    public C_UmuKbn getIrKznrkumu() {
        return irKznrkumu;
    }


    public void setIrKznrkumu(C_UmuKbn pIrKznrkumu) {
        irKznrkumu = pIrKznrkumu;
    }


    private String irBanknmkj;


    public String getIrBanknmkj() {
        return irBanknmkj;
    }


    public void setIrBanknmkj(String pIrBanknmkj) {
        irBanknmkj = pIrBanknmkj;
    }


    private String irSitennmkj;


    public String getIrSitennmkj() {
        return irSitennmkj;
    }


    public void setIrSitennmkj(String pIrSitennmkj) {
        irSitennmkj = pIrSitennmkj;
    }


    private String irKzmeiginmkn;


    public String getIrKzmeiginmkn() {
        return irKzmeiginmkn;
    }


    public void setIrKzmeiginmkn(String pIrKzmeiginmkn) {
        irKzmeiginmkn = pIrKzmeiginmkn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
