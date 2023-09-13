package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）クレカ登録件数リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhCreditTourokuKensuuListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhCreditTourokuKensuuListBean() {
    }

    private String irAtesakisosiki;

    public String getIrAtesakisosiki() {
        return irAtesakisosiki;
    }

    public void setIrAtesakisosiki(String pIrAtesakisosiki) {
        irAtesakisosiki = pIrAtesakisosiki;
    }

    private String irSakuseiymd;

    public String getIrSakuseiymd() {
        return irSakuseiymd;
    }

    public void setIrSakuseiymd(String pIrSakuseiymd) {
        irSakuseiymd = pIrSakuseiymd;
    }

    private Integer irCredittourokukensuubpo;

    public Integer getIrCredittourokukensuubpo() {
        return irCredittourokukensuubpo;
    }

    public void setIrCredittourokukensuubpo(Integer pIrCredittourokukensuubpo) {
        irCredittourokukensuubpo = pIrCredittourokukensuubpo;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
