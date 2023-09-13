package yuyu.def.hozen.bean.report;

import java.io.Serializable;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）不備未解消リストヘッダー帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhHubimikaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhHubimikaiBean() {
    }

    private String irSubsystemnm;

    public String getIrSubsystemnm() {
        return irSubsystemnm;
    }

    public void setIrSubsystemnm(String pIrSubsystemnm) {
        irSubsystemnm = pIrSubsystemnm;
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

    private String irJimutetuzukinm;

    public String getIrJimutetuzukinm() {
        return irJimutetuzukinm;
    }

    public void setIrJimutetuzukinm(String pIrJimutetuzukinm) {
        irJimutetuzukinm = pIrJimutetuzukinm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
