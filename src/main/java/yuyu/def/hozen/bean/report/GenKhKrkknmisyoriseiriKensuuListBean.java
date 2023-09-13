package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）仮受金整理未処理件数リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKrkknmisyoriseiriKensuuListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhKrkknmisyoriseiriKensuuListBean() {
    }

    private String irSakuseiymd;

    public String getIrSakuseiymd() {
        return irSakuseiymd;
    }

    public void setIrSakuseiymd(String pIrSakuseiymd) {
        irSakuseiymd = pIrSakuseiymd;
    }

    private String irAtesakisosiki;

    public String getIrAtesakisosiki() {
        return irAtesakisosiki;
    }

    public void setIrAtesakisosiki(String pIrAtesakisosiki) {
        irAtesakisosiki = pIrAtesakisosiki;
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
