package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）請求書会社使用欄帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSksKaisyasiyouranBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSksKaisyasiyouranBean() {
    }

    private String irToritsugisyasyozokunm;

    public String getIrToritsugisyasyozokunm() {
        return irToritsugisyasyozokunm;
    }

    public void setIrToritsugisyasyozokunm(String pIrToritsugisyasyozokunm) {
        irToritsugisyasyozokunm = pIrToritsugisyasyozokunm;
    }

    private String irToritsugisyakjncd;

    public String getIrToritsugisyakjncd() {
        return irToritsugisyakjncd;
    }

    public void setIrToritsugisyakjncd(String pIrToritsugisyakjncd) {
        irToritsugisyakjncd = pIrToritsugisyakjncd;
    }

    private String irToritsugisyanm;

    public String getIrToritsugisyanm() {
        return irToritsugisyanm;
    }

    public void setIrToritsugisyanm(String pIrToritsugisyanm) {
        irToritsugisyanm = pIrToritsugisyanm;
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
