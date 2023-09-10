package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）第１回保険料一致リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkDai1kaihokenryouittilistBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkDai1kaihokenryouittilistBean() {
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
