package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）完了通知事後作業リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKanryouTuutiJigoSgyListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhKanryouTuutiJigoSgyListBean() {
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
