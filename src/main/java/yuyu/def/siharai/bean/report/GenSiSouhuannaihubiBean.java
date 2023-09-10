package yuyu.def.siharai.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）不備訂正書の送付案内帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiSouhuannaihubiBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiSouhuannaihubiBean() {
    }


    private String irMsg1;


    public String getIrMsg1() {
        return irMsg1;
    }


    public void setIrMsg1(String pIrMsg1) {
        irMsg1 = pIrMsg1;
    }


    private String irMsg2;


    public String getIrMsg2() {
        return irMsg2;
    }


    public void setIrMsg2(String pIrMsg2) {
        irMsg2 = pIrMsg2;
    }


    private String irMsg3;


    public String getIrMsg3() {
        return irMsg3;
    }


    public void setIrMsg3(String pIrMsg3) {
        irMsg3 = pIrMsg3;
    }


    private String irMsg4;


    public String getIrMsg4() {
        return irMsg4;
    }


    public void setIrMsg4(String pIrMsg4) {
        irMsg4 = pIrMsg4;
    }


    private String irMsg5;


    public String getIrMsg5() {
        return irMsg5;
    }


    public void setIrMsg5(String pIrMsg5) {
        irMsg5 = pIrMsg5;
    }


    private String irMsg6;


    public String getIrMsg6() {
        return irMsg6;
    }


    public void setIrMsg6(String pIrMsg6) {
        irMsg6 = pIrMsg6;
    }


    private String irMsg7;


    public String getIrMsg7() {
        return irMsg7;
    }


    public void setIrMsg7(String pIrMsg7) {
        irMsg7 = pIrMsg7;
    }


    private String irSyono;


    public String getIrSyono() {
        return irSyono;
    }


    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }


    private String irHhknnmkj;


    public String getIrHhknnmkj() {
        return irHhknnmkj;
    }


    public void setIrHhknnmkj(String pIrHhknnmkj) {
        irHhknnmkj = pIrHhknnmkj;
    }


    private String irHubirenrakuran;


    public String getIrHubirenrakuran() {
        return irHubirenrakuran;
    }


    public void setIrHubirenrakuran(String pIrHubirenrakuran) {
        irHubirenrakuran = pIrHubirenrakuran;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
