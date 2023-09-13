package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）代表選任届帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhDaihyousennintodokeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhDaihyousennintodokeBean() {
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irKyknmkj;

    public String getIrKyknmkj() {
        return irKyknmkj;
    }

    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
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

    private String irKinouid;

    public String getIrKinouid() {
        return irKinouid;
    }

    public void setIrKinouid(String pIrKinouid) {
        irKinouid = pIrKinouid;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
