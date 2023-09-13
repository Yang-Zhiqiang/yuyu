package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.Tel;

/**
 * （ＤＳＷｅｂ）顧客通信先情報取得出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwGetTuusinsakiInfoOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwGetTuusinsakiInfoOutputBean() {
    }

    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    private String iwsTsinkokyno;

    public String getIwsTsinkokyno() {
        return iwsTsinkokyno;
    }

    public void setIwsTsinkokyno(String pIwsTsinkokyno) {
        iwsTsinkokyno = pIwsTsinkokyno;
    }

    private String iwsTsinadr1kj;

    public String getIwsTsinadr1kj() {
        return iwsTsinadr1kj;
    }

    public void setIwsTsinadr1kj(String pIwsTsinadr1kj) {
        iwsTsinadr1kj = pIwsTsinadr1kj;
    }

    private String iwsTsinadr2kj;

    public String getIwsTsinadr2kj() {
        return iwsTsinadr2kj;
    }

    public void setIwsTsinadr2kj(String pIwsTsinadr2kj) {
        iwsTsinadr2kj = pIwsTsinadr2kj;
    }

    private String iwsTsinadr3kj;

    public String getIwsTsinadr3kj() {
        return iwsTsinadr3kj;
    }

    public void setIwsTsinadr3kj(String pIwsTsinadr3kj) {
        iwsTsinadr3kj = pIwsTsinadr3kj;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String iwsTsintelno;

    public String getIwsTsintelno() {
        return iwsTsintelno;
    }

    public void setIwsTsintelno(String pIwsTsintelno) {
        iwsTsintelno = pIwsTsintelno;
    }

    private String iwsDai2tsintelno;

    public String getIwsDai2tsintelno() {
        return iwsDai2tsintelno;
    }

    public void setIwsDai2tsintelno(String pIwsDai2tsintelno) {
        iwsDai2tsintelno = pIwsDai2tsintelno;
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

    private String iwsDsmailsousintisrykbn;

    public String getIwsDsmailsousintisrykbn() {
        return iwsDsmailsousintisrykbn;
    }

    public void setIwsDsmailsousintisrykbn(String pIwsDsmailsousintisrykbn) {
        iwsDsmailsousintisrykbn = pIwsDsmailsousintisrykbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
