package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Bknkessankbn;
import yuyu.def.classification.C_TantouCdKbn;

/**
 * （保全）備金時効リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKaiyakuBikinjikouListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhKaiyakuBikinjikouListBean() {
    }

    private String irTantsitunmkj;

    public String getIrTantsitunmkj() {
        return irTantsitunmkj;
    }

    public void setIrTantsitunmkj(String pIrTantsitunmkj) {
        irTantsitunmkj = pIrTantsitunmkj;
    }

    private C_TantouCdKbn irTantocd;

    public C_TantouCdKbn getIrTantocd() {
        return irTantocd;
    }

    public void setIrTantocd(C_TantouCdKbn pIrTantocd) {
        irTantocd = pIrTantocd;
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
