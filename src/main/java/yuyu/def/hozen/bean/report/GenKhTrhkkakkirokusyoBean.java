package yuyu.def.hozen.bean.report;

import java.io.Serializable;
import yuyu.def.classification.C_Meigihnkjiyuu;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）取引時確認記録書帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhTrhkkakkirokusyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhTrhkkakkirokusyoBean() {
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irDocumentid;

    public String getIrDocumentid() {
        return irDocumentid;
    }

    public void setIrDocumentid(String pIrDocumentid) {
        irDocumentid = pIrDocumentid;
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    private C_Meigihnkjiyuu irMeigihnkjiyuu;

    public C_Meigihnkjiyuu getIrMeigihnkjiyuu() {
        return irMeigihnkjiyuu;
    }

    public void setIrMeigihnkjiyuu(C_Meigihnkjiyuu pIrMeigihnkjiyuu) {
        irMeigihnkjiyuu = pIrMeigihnkjiyuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
