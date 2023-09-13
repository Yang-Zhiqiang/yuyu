package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （ＤＳＷｅｂ）ＤＳ目標額変更受付出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwMkhgkHenkouUketukeOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwMkhgkHenkouUketukeOutputBean() {
    }

    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    @SyoukenNo
    private String iwsSyono;

    public String getIwsSyono() {
        return iwsSyono;
    }

    public void setIwsSyono(String pIwsSyono) {
        iwsSyono = pIwsSyono;
    }

    private String iwsMkhgkhnkkahikbn;

    public String getIwsMkhgkhnkkahikbn() {
        return iwsMkhgkhnkkahikbn;
    }

    public void setIwsMkhgkhnkkahikbn(String pIwsMkhgkhnkkahikbn) {
        iwsMkhgkhnkkahikbn = pIwsMkhgkhnkkahikbn;
    }

    private String iwsTtdktyuumkhgkwari;

    public String getIwsTtdktyuumkhgkwari() {
        return iwsTtdktyuumkhgkwari;
    }

    public void setIwsTtdktyuumkhgkwari(String pIwsTtdktyuumkhgkwari) {
        iwsTtdktyuumkhgkwari = pIwsTtdktyuumkhgkwari;
    }

    private String iwsMkhgkwarihnkkanouhani;

    public String getIwsMkhgkwarihnkkanouhani() {
        return iwsMkhgkwarihnkkanouhani;
    }

    public void setIwsMkhgkwarihnkkanouhani(String pIwsMkhgkwarihnkkanouhani) {
        iwsMkhgkwarihnkkanouhani = pIwsMkhgkwarihnkkanouhani;
    }

    private String iwsDispmkhgkwari;

    public String getIwsDispmkhgkwari() {
        return iwsDispmkhgkwari;
    }

    public void setIwsDispmkhgkwari(String pIwsDispmkhgkwari) {
        iwsDispmkhgkwari = pIwsDispmkhgkwari;
    }

    private String iwsDispttdktyuumkhgkwari;

    public String getIwsDispttdktyuumkhgkwari() {
        return iwsDispttdktyuumkhgkwari;
    }

    public void setIwsDispttdktyuumkhgkwari(String pIwsDispttdktyuumkhgkwari) {
        iwsDispttdktyuumkhgkwari = pIwsDispttdktyuumkhgkwari;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
