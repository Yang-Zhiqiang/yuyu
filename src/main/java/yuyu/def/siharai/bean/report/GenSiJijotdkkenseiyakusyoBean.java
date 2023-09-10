package yuyu.def.siharai.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）事情届兼誓約書帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiJijotdkkenseiyakusyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSiJijotdkkenseiyakusyoBean() {
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irHknknuktnm;

    public String getIrHknknuktnm() {
        return irHknknuktnm;
    }

    public void setIrHknknuktnm(String pIrHknknuktnm) {
        irHknknuktnm = pIrHknknuktnm;
    }

    private String irDrsknm;

    public String getIrDrsknm() {
        return irDrsknm;
    }

    public void setIrDrsknm(String pIrDrsknm) {
        irDrsknm = pIrDrsknm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
