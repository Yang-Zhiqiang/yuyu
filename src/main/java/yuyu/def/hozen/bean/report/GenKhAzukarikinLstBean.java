package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_AzukarikinBknkessanKbn;

/**
 * （保全）預り金リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhAzukarikinLstBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhAzukarikinLstBean() {
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    private String irKessannnd;

    public String getIrKessannnd() {
        return irKessannnd;
    }

    public void setIrKessannnd(String pIrKessannnd) {
        irKessannnd = pIrKessannnd;
    }

    private C_AzukarikinBknkessanKbn irAzukarikinbknkessankbn;

    public C_AzukarikinBknkessanKbn getIrAzukarikinbknkessankbn() {
        return irAzukarikinbknkessankbn;
    }

    public void setIrAzukarikinbknkessankbn(C_AzukarikinBknkessanKbn pIrAzukarikinbknkessankbn) {
        irAzukarikinbknkessankbn = pIrAzukarikinbknkessankbn;
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
