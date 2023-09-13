package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）ＤＳ解約受付出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwDsKaiyakuUktkOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwDsKaiyakuUktkOutputBean() {
    }

    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    private String iwsShrgkkeiyen;

    public String getIwsShrgkkeiyen() {
        return iwsShrgkkeiyen;
    }

    public void setIwsShrgkkeiyen(String pIwsShrgkkeiyen) {
        iwsShrgkkeiyen = pIwsShrgkkeiyen;
    }

    private String iwsKaiyakuhryen;

    public String getIwsKaiyakuhryen() {
        return iwsKaiyakuhryen;
    }

    public void setIwsKaiyakuhryen(String pIwsKaiyakuhryen) {
        iwsKaiyakuhryen = pIwsKaiyakuhryen;
    }

    private String iwsYendthnkhr;

    public String getIwsYendthnkhr() {
        return iwsYendthnkhr;
    }

    public void setIwsYendthnkhr(String pIwsYendthnkhr) {
        iwsYendthnkhr = pIwsYendthnkhr;
    }

    private String iwsGstszeigkyen;

    public String getIwsGstszeigkyen() {
        return iwsGstszeigkyen;
    }

    public void setIwsGstszeigkyen(String pIwsGstszeigkyen) {
        iwsGstszeigkyen = pIwsGstszeigkyen;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
