package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）仮受金整備督促リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhKrkknSeibiTokusokuListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhKrkknSeibiTokusokuListBean() {
    }

    private String irSakuseiymd;

    public String getIrSakuseiymd() {
        return irSakuseiymd;
    }

    public void setIrSakuseiymd(String pIrSakuseiymd) {
        irSakuseiymd = pIrSakuseiymd;
    }

    private String irSakuseisosiki;

    public String getIrSakuseisosiki() {
        return irSakuseisosiki;
    }

    public void setIrSakuseisosiki(String pIrSakuseisosiki) {
        irSakuseisosiki = pIrSakuseisosiki;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
