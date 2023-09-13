package yuyu.def.hozen.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）汎用送付案内帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhHanyouSouhuannaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhHanyouSouhuannaiBean() {
    }

    private String irTyouhyousakuseiymd;

    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }

    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }

    private String irHanyoushannaityouhyounm;

    public String getIrHanyoushannaityouhyounm() {
        return irHanyoushannaityouhyounm;
    }

    public void setIrHanyoushannaityouhyounm(String pIrHanyoushannaityouhyounm) {
        irHanyoushannaityouhyounm = pIrHanyoushannaityouhyounm;
    }

    private String irHanyoushannaiinjinaiyou;

    public String getIrHanyoushannaiinjinaiyou() {
        return irHanyoushannaiinjinaiyou;
    }

    public void setIrHanyoushannaiinjinaiyou(String pIrHanyoushannaiinjinaiyou) {
        irHanyoushannaiinjinaiyou = pIrHanyoushannaiinjinaiyou;
    }

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    private String irHknkisynm;

    public String getIrHknkisynm() {
        return irHknkisynm;
    }

    public void setIrHknkisynm(String pIrHknkisynm) {
        irHknkisynm = pIrHknkisynm;
    }

    private String irCctelno;

    public String getIrCctelno() {
        return irCctelno;
    }

    public void setIrCctelno(String pIrCctelno) {
        irCctelno = pIrCctelno;
    }

    private String irCcimagepath;

    public String getIrCcimagepath() {
        return irCcimagepath;
    }

    public void setIrCcimagepath(String pIrCcimagepath) {
        irCcimagepath = pIrCcimagepath;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
