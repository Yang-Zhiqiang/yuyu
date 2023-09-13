package yuyu.def.hozen.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）有効確認エラーリスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhYuukouKakuninErrorListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhYuukouKakuninErrorListBean() {
    }

    private String irSakuseisosiki;

    public String getIrSakuseisosiki() {
        return irSakuseisosiki;
    }

    public void setIrSakuseisosiki(String pIrSakuseisosiki) {
        irSakuseisosiki = pIrSakuseisosiki;
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    private Integer irKensuu;

    public Integer getIrKensuu() {
        return irKensuu;
    }

    public void setIrKensuu(Integer pIrKensuu) {
        irKensuu = pIrKensuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
