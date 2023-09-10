package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_SkeijimuKbn;

/**
 * （新契約）返金通知書帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkHenkinTuutiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkHenkinTuutiBean() {
    }

    private String irHnkngk;

    public String getIrHnkngk() {
        return irHnkngk;
    }

    public void setIrHnkngk(String pIrHnkngk) {
        irHnkngk = pIrHnkngk;
    }

    private String irHnknymd;

    public String getIrHnknymd() {
        return irHnknymd;
    }

    public void setIrHnknymd(String pIrHnknymd) {
        irHnknymd = pIrHnknymd;
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

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
