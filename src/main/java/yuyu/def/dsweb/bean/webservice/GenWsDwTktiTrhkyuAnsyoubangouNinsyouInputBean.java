package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （ＤＳＷｅｂ）ＤＳ特定取引用暗証番号認証入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwTktiTrhkyuAnsyoubangouNinsyouInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwTktiTrhkyuAnsyoubangouNinsyouInputBean() {
    }

    @SingleByteStrings
    @Digit
    @Length(length=10)
    private String iwsDskokno;

    public String getIwsDskokno() {
        return iwsDskokno;
    }

    public void setIwsDskokno(String pIwsDskokno) {
        iwsDskokno = pIwsDskokno;
    }

    @SyoukenNo
    private String iwsSyono;

    public String getIwsSyono() {
        return iwsSyono;
    }

    public void setIwsSyono(String pIwsSyono) {
        iwsSyono = pIwsSyono;
    }

    private String iwsTokuteitrhkansyono;

    public String getIwsTokuteitrhkansyono() {
        return iwsTokuteitrhkansyono;
    }

    public void setIwsTokuteitrhkansyono(String pIwsTokuteitrhkansyono) {
        iwsTokuteitrhkansyono = pIwsTokuteitrhkansyono;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
