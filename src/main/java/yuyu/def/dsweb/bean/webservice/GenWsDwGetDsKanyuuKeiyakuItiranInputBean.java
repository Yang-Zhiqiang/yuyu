package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;

/**
 * （ＤＳＷｅｂ）ＤＳ加入契約一覧取得入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwGetDsKanyuuKeiyakuItiranInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwGetDsKanyuuKeiyakuItiranInputBean() {
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

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
