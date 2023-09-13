package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （ＤＳＷｅｂ）ＤＳ目標額変更受付入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwMkhgkHenkouUketukeInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwMkhgkHenkouUketukeInputBean() {
    }

    @SyoukenNo
    private String iwsSyono;

    public String getIwsSyono() {
        return iwsSyono;
    }

    public void setIwsSyono(String pIwsSyono) {
        iwsSyono = pIwsSyono;
    }

    @SingleByteStrings
    @Digit
    @MaxLength(max=3)
    private String iwsHenkougomkhgkwari;

    public String getIwsHenkougomkhgkwari() {
        return iwsHenkougomkhgkwari;
    }

    public void setIwsHenkougomkhgkwari(String pIwsHenkougomkhgkwari) {
        iwsHenkougomkhgkwari = pIwsHenkougomkhgkwari;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
