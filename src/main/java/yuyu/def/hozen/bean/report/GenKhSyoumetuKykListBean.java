package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）消滅契約リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSyoumetuKykListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSyoumetuKykListBean() {
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    private Integer irKensuu;

    public Integer getIrKensuu() {
        return irKensuu;
    }

    public void setIrKensuu(Integer pIrKensuu) {
        irKensuu = pIrKensuu;
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
