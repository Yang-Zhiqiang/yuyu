package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）仮受（普保Ｐ過金）１ヵ月超経過リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkKariukeHuhopkakinBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSkKariukeHuhopkakinBean() {
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

    private String irSyuukeiym;

    public String getIrSyuukeiym() {
        return irSyuukeiym;
    }

    public void setIrSyuukeiym(String pIrSyuukeiym) {
        irSyuukeiym = pIrSyuukeiym;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
