package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）補助簿リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHojyobolistBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzHojyobolistBean() {
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
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
