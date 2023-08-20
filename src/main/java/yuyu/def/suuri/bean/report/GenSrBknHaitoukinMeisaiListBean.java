package yuyu.def.suuri.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （数理）備金配当金明細リスト帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrBknHaitoukinMeisaiListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenSrBknHaitoukinMeisaiListBean() {
    }

    private String irAtesakibukanm;

    public String getIrAtesakibukanm() {
        return irAtesakibukanm;
    }

    public void setIrAtesakibukanm(String pIrAtesakibukanm) {
        irAtesakibukanm = pIrAtesakibukanm;
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    private String irHozonkkn;

    public String getIrHozonkkn() {
        return irHozonkkn;
    }

    public void setIrHozonkkn(String pIrHozonkkn) {
        irHozonkkn = pIrHozonkkn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
