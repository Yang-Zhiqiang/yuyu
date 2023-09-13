package yuyu.def.hozen.bean.report;

import java.io.Serializable;
import yuyu.def.classification.C_Bknkessankbn;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）Ｐ未入消滅時返戻金備金リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhPmnySymtjHnrknBknListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhPmnySymtjHnrknBknListBean() {
    }

    private String irTantsitunmkj;

    public String getIrTantsitunmkj() {
        return irTantsitunmkj;
    }

    public void setIrTantsitunmkj(String pIrTantsitunmkj) {
        irTantsitunmkj = pIrTantsitunmkj;
    }

    private String irKessannnd;

    public String getIrKessannnd() {
        return irKessannnd;
    }

    public void setIrKessannnd(String pIrKessannnd) {
        irKessannnd = pIrKessannnd;
    }

    private C_Bknkessankbn irBknkessankbn;

    public C_Bknkessankbn getIrBknkessankbn() {
        return irBknkessankbn;
    }

    public void setIrBknkessankbn(C_Bknkessankbn pIrBknkessankbn) {
        irBknkessankbn = pIrBknkessankbn;
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
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
