package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＦＢ送金明細リストヘッダー帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFbsoukinmeslistHeaderBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFbsoukinmeslistHeaderBean() {
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    private Integer irTuujyouyokutyakkinkbn;

    public Integer getIrTuujyouyokutyakkinkbn() {
        return irTuujyouyokutyakkinkbn;
    }

    public void setIrTuujyouyokutyakkinkbn(Integer pIrTuujyouyokutyakkinkbn) {
        irTuujyouyokutyakkinkbn = pIrTuujyouyokutyakkinkbn;
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
