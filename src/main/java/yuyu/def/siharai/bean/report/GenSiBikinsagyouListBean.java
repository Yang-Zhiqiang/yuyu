package yuyu.def.siharai.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Bknkessankbn;

/**
 * （支払）備金作業リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiBikinsagyouListBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiBikinsagyouListBean() {
    }


    private String irAtesaki;


    public String getIrAtesaki() {
        return irAtesaki;
    }


    public void setIrAtesaki(String pIrAtesaki) {
        irAtesaki = pIrAtesaki;
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
