package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * （新契約）仮受金（Ｐ過金）明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkKariukekinpkakinBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkKariukekinpkakinBean() {
    }


    private String irAtesaki;


    public String getIrAtesaki() {
        return irAtesaki;
    }


    public void setIrAtesaki(String pIrAtesaki) {
        irAtesaki = pIrAtesaki;
    }


    private String irTyouhyousakuseiymd;


    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }


    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }


    private String irTyouhyoutitle;


    public String getIrTyouhyoutitle() {
        return irTyouhyoutitle;
    }


    public void setIrTyouhyoutitle(String pIrTyouhyoutitle) {
        irTyouhyoutitle = pIrTyouhyoutitle;
    }


    private C_SyoruiCdKbn irSyoruicd;


    public C_SyoruiCdKbn getIrSyoruicd() {
        return irSyoruicd;
    }


    public void setIrSyoruicd(C_SyoruiCdKbn pIrSyoruicd) {
        irSyoruicd = pIrSyoruicd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
