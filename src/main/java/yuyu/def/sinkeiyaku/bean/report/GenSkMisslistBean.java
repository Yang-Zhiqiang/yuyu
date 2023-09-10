package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）ミスリスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkMisslistBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkMisslistBean() {
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


    private String irKinounm;


    public String getIrKinounm() {
        return irKinounm;
    }


    public void setIrKinounm(String pIrKinounm) {
        irKinounm = pIrKinounm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
