package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;

/**
 * （ＤＳＷｅｂ）パスワード変更入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwPasswordHenkouInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwPasswordHenkouInputBean() {
    }

    @Column(order = 1, length = 10)
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

    @Column(order = 2, length = 128)
    private String iwsSclakatopassword;

    public String getIwsSclakatopassword() {
        return iwsSclakatopassword;
    }

    public void setIwsSclakatopassword(String pIwsSclakatopassword) {
        iwsSclakatopassword = pIwsSclakatopassword;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
