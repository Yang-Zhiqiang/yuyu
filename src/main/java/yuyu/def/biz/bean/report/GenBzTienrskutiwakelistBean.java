package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）支払遅延利息内訳リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzTienrskutiwakelistBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzTienrskutiwakelistBean() {
    }

    private String irSyoribiwareki;

    public String getIrSyoribiwareki() {
        return irSyoribiwareki;
    }

    public void setIrSyoribiwareki(String pIrSyoribiwareki) {
        irSyoribiwareki = pIrSyoribiwareki;
    }

    private String irDenym;

    public String getIrDenym() {
        return irDenym;
    }

    public void setIrDenym(String pIrDenym) {
        irDenym = pIrDenym;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
