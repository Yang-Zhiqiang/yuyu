package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）ＤＳ加入契約一覧取得出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwGetDsKanyuuKeiyakuItiranOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwGetDsKanyuuKeiyakuItiranOutputBean() {
    }

    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    private WsDwGetDsKanyuuKeiyakuItiranKykInfoBean wsDwGetDsKanyuuKeiyakuItiranKykInfoBean;

    public WsDwGetDsKanyuuKeiyakuItiranKykInfoBean getWsDwGetDsKanyuuKeiyakuItiranKykInfoBean() {
        return wsDwGetDsKanyuuKeiyakuItiranKykInfoBean;
    }

    public void setWsDwGetDsKanyuuKeiyakuItiranKykInfoBean(WsDwGetDsKanyuuKeiyakuItiranKykInfoBean pWsDwGetDsKanyuuKeiyakuItiranKykInfoBean) {
        wsDwGetDsKanyuuKeiyakuItiranKykInfoBean = pWsDwGetDsKanyuuKeiyakuItiranKykInfoBean;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
