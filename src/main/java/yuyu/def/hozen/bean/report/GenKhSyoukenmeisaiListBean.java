package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）証券作成契約明細リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSyoukenmeisaiListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSyoukenmeisaiListBean() {
    }

    private String irTantsitunmkj;

    public String getIrTantsitunmkj() {
        return irTantsitunmkj;
    }

    public void setIrTantsitunmkj(String pIrTantsitunmkj) {
        irTantsitunmkj = pIrTantsitunmkj;
    }

    private String irTyouhyousakuseiymdwareki;

    public String getIrTyouhyousakuseiymdwareki() {
        return irTyouhyousakuseiymdwareki;
    }

    public void setIrTyouhyousakuseiymdwareki(String pIrTyouhyousakuseiymdwareki) {
        irTyouhyousakuseiymdwareki = pIrTyouhyousakuseiymdwareki;
    }

    private String irHozonkkn;

    public String getIrHozonkkn() {
        return irHozonkkn;
    }

    public void setIrHozonkkn(String pIrHozonkkn) {
        irHozonkkn = pIrHozonkkn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
