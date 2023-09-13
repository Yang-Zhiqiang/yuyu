package yuyu.def.dsweb.bean.webservice;

import java.util.List;

import net.arnx.jsonic.JSONHint;

/**
 * （ＤＳＷｅｂ）ＤＳ加入契約一覧取得出力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwGetDsKanyuuKeiyakuItiranOutputBean extends GenWsDwGetDsKanyuuKeiyakuItiranOutputBean {

    private static final long serialVersionUID = 1L;

    public WsDwGetDsKanyuuKeiyakuItiranOutputBean() {
    }

    private List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> wsDwGetDsKanyuuKeiyakuItiranKykInfoBeanLst;

    public List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList() {
        return wsDwGetDsKanyuuKeiyakuItiranKykInfoBeanLst;
    }

    public void setWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList(
        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> pWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList) {
        wsDwGetDsKanyuuKeiyakuItiranKykInfoBeanLst = pWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList;
    }

    private WsDwGetDsKanyuuKeiyakuItiranKykInfoBean wsDwGetDsKanyuuKeiyakuItiranKykInfoBean;

    @Override
    @Deprecated
    @JSONHint(ignore=true)
    public WsDwGetDsKanyuuKeiyakuItiranKykInfoBean getWsDwGetDsKanyuuKeiyakuItiranKykInfoBean() {
        return wsDwGetDsKanyuuKeiyakuItiranKykInfoBean;
    }

    @Override
    @Deprecated
    @JSONHint(ignore=true)
    public void setWsDwGetDsKanyuuKeiyakuItiranKykInfoBean(WsDwGetDsKanyuuKeiyakuItiranKykInfoBean pWsDwGetDsKanyuuKeiyakuItiranKykInfoBean) {
        wsDwGetDsKanyuuKeiyakuItiranKykInfoBean = pWsDwGetDsKanyuuKeiyakuItiranKykInfoBean;
    }

}
