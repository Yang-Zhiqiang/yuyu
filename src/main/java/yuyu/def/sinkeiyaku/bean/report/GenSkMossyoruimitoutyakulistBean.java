package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）申込書類未到着期間経過リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkMossyoruimitoutyakulistBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkMossyoruimitoutyakulistBean() {
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

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
