package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_SkDenlistsksKbn;

/**
 * （共通）新契約本社用伝票リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSkHonsyaDenpyouListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSkHonsyaDenpyouListBean() {
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    private String irSuitouym;

    public String getIrSuitouym() {
        return irSuitouym;
    }

    public void setIrSuitouym(String pIrSuitouym) {
        irSuitouym = pIrSuitouym;
    }

    private C_SkDenlistsksKbn irDenlistskskbn;

    public C_SkDenlistsksKbn getIrDenlistskskbn() {
        return irDenlistskskbn;
    }

    public void setIrDenlistskskbn(C_SkDenlistsksKbn pIrDenlistskskbn) {
        irDenlistskskbn = pIrDenlistskskbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
