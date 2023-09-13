package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）源泉徴収リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhGensenListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhGensenListBean() {
    }

    private String irTantsitunmkj;

    public String getIrTantsitunmkj() {
        return irTantsitunmkj;
    }

    public void setIrTantsitunmkj(String pIrTantsitunmkj) {
        irTantsitunmkj = pIrTantsitunmkj;
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    private String irGstsym;

    public String getIrGstsym() {
        return irGstsym;
    }

    public void setIrGstsym(String pIrGstsym) {
        irGstsym = pIrGstsym;
    }

    private Integer irKensuu;

    public Integer getIrKensuu() {
        return irKensuu;
    }

    public void setIrKensuu(Integer pIrKensuu) {
        irKensuu = pIrKensuu;
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
