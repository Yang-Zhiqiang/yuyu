package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （ＤＳＷｅｂ）ＤＳ積立金移転受付入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwTumitatekinItenUketukeInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwTumitatekinItenUketukeInputBean() {
    }

    @SyoukenNo
    private String iwsSyono;

    public String getIwsSyono() {
        return iwsSyono;
    }

    public void setIwsSyono(String pIwsSyono) {
        iwsSyono = pIwsSyono;
    }

    private String iwsTumitatekinitenyoteibi;

    public String getIwsTumitatekinitenyoteibi() {
        return iwsTumitatekinitenyoteibi;
    }

    public void setIwsTumitatekinitenyoteibi(String pIwsTumitatekinitenyoteibi) {
        iwsTumitatekinitenyoteibi = pIwsTumitatekinitenyoteibi;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
