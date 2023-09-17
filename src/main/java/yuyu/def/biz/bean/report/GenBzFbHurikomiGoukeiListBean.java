package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＦＢ振込合計リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbHurikomiGoukeiListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFbHurikomiGoukeiListBean() {
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
