package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）社内リスト共通ヘッダー帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkSyanailistheaderBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkSyanailistheaderBean() {
    }


    private String irAtesakisosiki;


    public String getIrAtesakisosiki() {
        return irAtesakisosiki;
    }


    public void setIrAtesakisosiki(String pIrAtesakisosiki) {
        irAtesakisosiki = pIrAtesakisosiki;
    }


    private String irTyouhyousakuseiymd;


    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }


    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
