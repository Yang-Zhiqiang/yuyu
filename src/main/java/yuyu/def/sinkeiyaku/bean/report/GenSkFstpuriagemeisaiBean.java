package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）初回保険料クレジットカード扱売上請求明細票帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkFstpuriagemeisaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkFstpuriagemeisaiBean() {
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

    private String irCardkaisya;

    public String getIrCardkaisya() {
        return irCardkaisya;
    }

    public void setIrCardkaisya(String pIrCardkaisya) {
        irCardkaisya = pIrCardkaisya;
    }

    private String irSyuukeicomment;

    public String getIrSyuukeicomment() {
        return irSyuukeicomment;
    }

    public void setIrSyuukeicomment(String pIrSyuukeicomment) {
        irSyuukeicomment = pIrSyuukeicomment;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
