package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）案内合計票帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzAnnaiGoukeihyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzAnnaiGoukeihyouBean() {
    }

    private String irSyunodaikonm;

    public String getIrSyunodaikonm() {
        return irSyunodaikonm;
    }

    public void setIrSyunodaikonm(String pIrSyunodaikonm) {
        irSyunodaikonm = pIrSyunodaikonm;
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    private String irHknkisyadr1kj;

    public String getIrHknkisyadr1kj() {
        return irHknkisyadr1kj;
    }

    public void setIrHknkisyadr1kj(String pIrHknkisyadr1kj) {
        irHknkisyadr1kj = pIrHknkisyadr1kj;
    }

    private String irHknkisyadr2kj;

    public String getIrHknkisyadr2kj() {
        return irHknkisyadr2kj;
    }

    public void setIrHknkisyadr2kj(String pIrHknkisyadr2kj) {
        irHknkisyadr2kj = pIrHknkisyadr2kj;
    }

    private String irHknkisyadr3kj;

    public String getIrHknkisyadr3kj() {
        return irHknkisyadr3kj;
    }

    public void setIrHknkisyadr3kj(String pIrHknkisyadr3kj) {
        irHknkisyadr3kj = pIrHknkisyadr3kj;
    }

    private String irHurikaeymd;

    public String getIrHurikaeymd() {
        return irHurikaeymd;
    }

    public void setIrHurikaeymd(String pIrHurikaeymd) {
        irHurikaeymd = pIrHurikaeymd;
    }

    private String irAnnaikensuu;

    public String getIrAnnaikensuu() {
        return irAnnaikensuu;
    }

    public void setIrAnnaikensuu(String pIrAnnaikensuu) {
        irAnnaikensuu = pIrAnnaikensuu;
    }

    private String irAnnaigkkei;

    public String getIrAnnaigkkei() {
        return irAnnaigkkei;
    }

    public void setIrAnnaigkkei(String pIrAnnaigkkei) {
        irAnnaigkkei = pIrAnnaigkkei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
