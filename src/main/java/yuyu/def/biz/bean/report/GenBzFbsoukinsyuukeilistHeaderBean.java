package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＦＢ送金集計リストヘッダー帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbsoukinsyuukeilistHeaderBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFbsoukinsyuukeilistHeaderBean() {
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    private String irSousinymd;

    public String getIrSousinymd() {
        return irSousinymd;
    }

    public void setIrSousinymd(String pIrSousinymd) {
        irSousinymd = pIrSousinymd;
    }

    private String irShrymd;

    public String getIrShrymd() {
        return irShrymd;
    }

    public void setIrShrymd(String pIrShrymd) {
        irShrymd = pIrShrymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
