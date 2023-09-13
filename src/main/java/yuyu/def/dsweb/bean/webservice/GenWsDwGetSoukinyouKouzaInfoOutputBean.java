package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;

/**
 * （ＤＳＷｅｂ）ＤＳ送金用口座情報取得出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwGetSoukinyouKouzaInfoOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwGetSoukinyouKouzaInfoOutputBean() {
    }

    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    private String iwsBankcd;

    public String getIwsBankcd() {
        return iwsBankcd;
    }

    public void setIwsBankcd(String pIwsBankcd) {
        iwsBankcd = pIwsBankcd;
    }

    private String iwsSitencd;

    public String getIwsSitencd() {
        return iwsSitencd;
    }

    public void setIwsSitencd(String pIwsSitencd) {
        iwsSitencd = pIwsSitencd;
    }

    private String iwsBanknmkj;

    public String getIwsBanknmkj() {
        return iwsBanknmkj;
    }

    public void setIwsBanknmkj(String pIwsBanknmkj) {
        iwsBanknmkj = pIwsBanknmkj;
    }

    private String iwsSitennmkj;

    public String getIwsSitennmkj() {
        return iwsSitennmkj;
    }

    public void setIwsSitennmkj(String pIwsSitennmkj) {
        iwsSitennmkj = pIwsSitennmkj;
    }

    private String iwsYokinsyumoku;

    public String getIwsYokinsyumoku() {
        return iwsYokinsyumoku;
    }

    public void setIwsYokinsyumoku(String pIwsYokinsyumoku) {
        iwsYokinsyumoku = pIwsYokinsyumoku;
    }

    private String iwsKouzano;

    public String getIwsKouzano() {
        return iwsKouzano;
    }

    public void setIwsKouzano(String pIwsKouzano) {
        iwsKouzano = pIwsKouzano;
    }

    private String iwsKzdoukbn;

    public String getIwsKzdoukbn() {
        return iwsKzdoukbn;
    }

    public void setIwsKzdoukbn(String pIwsKzdoukbn) {
        iwsKzdoukbn = pIwsKzdoukbn;
    }

    private String iwsKzmeiginmkn;

    public String getIwsKzmeiginmkn() {
        return iwsKzmeiginmkn;
    }

    public void setIwsKzmeiginmkn(String pIwsKzmeiginmkn) {
        iwsKzmeiginmkn = pIwsKzmeiginmkn;
    }

    @SingleByteStrings
    @Digit
    private String iwsVersion;

    public String getIwsVersion() {
        return iwsVersion;
    }

    public void setIwsVersion(String pIwsVersion) {
        iwsVersion = pIwsVersion;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
