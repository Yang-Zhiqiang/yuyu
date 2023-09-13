package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）ＤＳ加入契約一覧取得入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwGetDsKanyuuKeiyakuItiranInputBean extends GenWsDwGetDsKanyuuKeiyakuItiranInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwGetDsKanyuuKeiyakuItiranInputBean() {
    }

    public boolean chkHissuInput() {

        if (BizUtil.isBlank(getIwsDskokno())) {
            return false;

        }
        return true;
    }

}
