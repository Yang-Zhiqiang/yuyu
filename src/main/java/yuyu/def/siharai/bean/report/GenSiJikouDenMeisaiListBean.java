package yuyu.def.siharai.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）時効伝票明細リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiJikouDenMeisaiListBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiJikouDenMeisaiListBean() {
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
