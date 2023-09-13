package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）ログイン認証入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwLoginInputBean extends GenWsDwLoginInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwLoginInputBean() {
    }

    public boolean chkHissuInput() {

        if (BizUtil.isBlank(getIwsSyono())) {
            return false;

        }
        if (BizUtil.isBlank(getIwsPassword())) {
            return false;

        }
        return true;

    }


}
