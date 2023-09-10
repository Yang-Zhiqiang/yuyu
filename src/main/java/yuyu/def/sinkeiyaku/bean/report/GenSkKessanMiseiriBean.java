package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_TaisyouKbn;

/**
 * （新契約）決算未整理帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkKessanMiseiriBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkKessanMiseiriBean() {
    }


    private String irAtesaki;


    public String getIrAtesaki() {
        return irAtesaki;
    }


    public void setIrAtesaki(String pIrAtesaki) {
        irAtesaki = pIrAtesaki;
    }


    private String irTyouhyousakuseiymd;


    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }


    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }


    private String irNendo;


    public String getIrNendo() {
        return irNendo;
    }


    public void setIrNendo(String pIrNendo) {
        irNendo = pIrNendo;
    }


    private String irShnknm;


    public String getIrShnknm() {
        return irShnknm;
    }


    public void setIrShnknm(String pIrShnknm) {
        irShnknm = pIrShnknm;
    }


    private String irTyouhyoutitle;


    public String getIrTyouhyoutitle() {
        return irTyouhyoutitle;
    }


    public void setIrTyouhyoutitle(String pIrTyouhyoutitle) {
        irTyouhyoutitle = pIrTyouhyoutitle;
    }


    private C_TaisyouKbn irSyoruihubitandokuflg;


    public C_TaisyouKbn getIrSyoruihubitandokuflg() {
        return irSyoruihubitandokuflg;
    }


    public void setIrSyoruihubitandokuflg(C_TaisyouKbn pIrSyoruihubitandokuflg) {
        irSyoruihubitandokuflg = pIrSyoruihubitandokuflg;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
