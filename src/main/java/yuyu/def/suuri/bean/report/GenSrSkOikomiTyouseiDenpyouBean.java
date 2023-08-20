package yuyu.def.suuri.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （数理）新契約追込調整伝票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrSkOikomiTyouseiDenpyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSrSkOikomiTyouseiDenpyouBean() {
    }

    private String irKessannnd;

    public String getIrKessannnd() {
        return irKessannnd;
    }

    public void setIrKessannnd(String pIrKessannnd) {
        irKessannnd = pIrKessannnd;
    }

    private String irKessanki;

    public String getIrKessanki() {
        return irKessanki;
    }

    public void setIrKessanki(String pIrKessanki) {
        irKessanki = pIrKessanki;
    }

    private String irSakuseiymdwareki;

    public String getIrSakuseiymdwareki() {
        return irSakuseiymdwareki;
    }

    public void setIrSakuseiymdwareki(String pIrSakuseiymdwareki) {
        irSakuseiymdwareki = pIrSakuseiymdwareki;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
