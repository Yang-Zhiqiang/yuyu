package yuyu.def.biz.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）通算判定用為替レート確認書帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzTuusanKawaseRateKakuninBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzTuusanKawaseRateKakuninBean() {
    }

    private BizDate irSyoribi;

    public BizDate getIrSyoribi() {
        return irSyoribi;
    }

    public void setIrSyoribi(BizDate pIrSyoribi) {
        irSyoribi = pIrSyoribi;
    }

    private BizDate irNendoymd;

    public BizDate getIrNendoymd() {
        return irNendoymd;
    }

    public void setIrNendoymd(BizDate pIrNendoymd) {
        irNendoymd = pIrNendoymd;
    }

    private BizNumber irTsnhntiyukawaserate1;

    public BizNumber getIrTsnhntiyukawaserate1() {
        return irTsnhntiyukawaserate1;
    }

    public void setIrTsnhntiyukawaserate1(BizNumber pIrTsnhntiyukawaserate1) {
        irTsnhntiyukawaserate1 = pIrTsnhntiyukawaserate1;
    }

    private BizNumber irTsnhntiyukawaserate2;

    public BizNumber getIrTsnhntiyukawaserate2() {
        return irTsnhntiyukawaserate2;
    }

    public void setIrTsnhntiyukawaserate2(BizNumber pIrTsnhntiyukawaserate2) {
        irTsnhntiyukawaserate2 = pIrTsnhntiyukawaserate2;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
