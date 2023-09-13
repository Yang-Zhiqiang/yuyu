package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （ＤＳＷｅｂ）リアルタイムメール送信入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwRealTimeMailSousinInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwRealTimeMailSousinInputBean() {
    }

    @NotNull
    private String iwsDssousinmailsyubetukbn;

    public String getIwsDssousinmailsyubetukbn() {
        return iwsDssousinmailsyubetukbn;
    }

    public void setIwsDssousinmailsyubetukbn(String pIwsDssousinmailsyubetukbn) {
        iwsDssousinmailsyubetukbn = pIwsDssousinmailsyubetukbn;
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

    @MaxLength(max=100)
    @SingleByteStrings
    @Pattern(message="{pattern.MailAddress.message}", regex="^[\\w!#$%&'*+/=?^_{}\\\\|~-][\\w!#$%&'*+/=?^_{}\\\\|~\\.-]{0,63}@([\\w][\\w-]*\\.)+[\\w][\\w-]*$")
    private String iwsDsmailaddress;

    public String getIwsDsmailaddress() {
        return iwsDsmailaddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIwsDsmailaddress(String pIwsDsmailaddress) {
        iwsDsmailaddress = pIwsDsmailaddress;
    }

    private String iwsDssousinno;

    public String getIwsDssousinno() {
        return iwsDssousinno;
    }

    public void setIwsDssousinno(String pIwsDssousinno) {
        iwsDssousinno = pIwsDssousinno;
    }

    @SyoukenNo
    private String iwsSyono;

    public String getIwsSyono() {
        return iwsSyono;
    }

    public void setIwsSyono(String pIwsSyono) {
        iwsSyono = pIwsSyono;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
