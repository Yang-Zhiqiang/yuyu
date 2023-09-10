package yuyu.def.siharai.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）代表選任届帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiDhysntdkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSiDhysntdkBean() {
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

    private String irSyono;

    public String getIrSyono() {
        return irSyono;
    }

    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
