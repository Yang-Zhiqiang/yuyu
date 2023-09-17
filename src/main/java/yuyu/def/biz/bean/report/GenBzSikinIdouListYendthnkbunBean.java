package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）資金移動リスト（円建変更分）帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSikinIdouListYendthnkbunBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSikinIdouListYendthnkbunBean() {
    }

    private String irSyoribiwareki;

    public String getIrSyoribiwareki() {
        return irSyoribiwareki;
    }

    public void setIrSyoribiwareki(String pIrSyoribiwareki) {
        irSyoribiwareki = pIrSyoribiwareki;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
