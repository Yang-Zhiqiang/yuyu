package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）約款送付案内帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhYakkanSouhuannaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhYakkanSouhuannaiBean() {
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    private String irTsinyno;

    public String getIrTsinyno() {
        return irTsinyno;
    }

    public void setIrTsinyno(String pIrTsinyno) {
        irTsinyno = pIrTsinyno;
    }

    private String irTsinadr1kj;

    public String getIrTsinadr1kj() {
        return irTsinadr1kj;
    }

    public void setIrTsinadr1kj(String pIrTsinadr1kj) {
        irTsinadr1kj = pIrTsinadr1kj;
    }

    private String irTsinadr2kj;

    public String getIrTsinadr2kj() {
        return irTsinadr2kj;
    }

    public void setIrTsinadr2kj(String pIrTsinadr2kj) {
        irTsinadr2kj = pIrTsinadr2kj;
    }

    private String irTsinadr3kj;

    public String getIrTsinadr3kj() {
        return irTsinadr3kj;
    }

    public void setIrTsinadr3kj(String pIrTsinadr3kj) {
        irTsinadr3kj = pIrTsinadr3kj;
    }

    private String irCctelno;

    public String getIrCctelno() {
        return irCctelno;
    }

    public void setIrCctelno(String pIrCctelno) {
        irCctelno = pIrCctelno;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irSyouhnnm;

    public String getIrSyouhnnm() {
        return irSyouhnnm;
    }

    public void setIrSyouhnnm(String pIrSyouhnnm) {
        irSyouhnnm = pIrSyouhnnm;
    }

    private String irKyknmkj;

    public String getIrKyknmkj() {
        return irKyknmkj;
    }

    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }

    private String irHhknnmkj;

    public String getIrHhknnmkj() {
        return irHhknnmkj;
    }

    public void setIrHhknnmkj(String pIrHhknnmkj) {
        irHhknnmkj = pIrHhknnmkj;
    }

    private String irCcimagepath;

    public String getIrCcimagepath() {
        return irCcimagepath;
    }

    public void setIrCcimagepath(String pIrCcimagepath) {
        irCcimagepath = pIrCcimagepath;
    }

    private String irItemcd;

    public String getIrItemcd() {
        return irItemcd;
    }

    public void setIrItemcd(String pIrItemcd) {
        irItemcd = pIrItemcd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
