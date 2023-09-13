package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）ＤＳ送金用口座情報取得入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwGetSoukinyouKouzaInfoInputBean extends GenWsDwGetSoukinyouKouzaInfoInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwGetSoukinyouKouzaInfoInputBean() {
    }

    public boolean chkHissuInput() {

        if (BizUtil.isBlank(getIwsDskokno())) {
            return false;
        }

        if (BizUtil.isBlank(getIwsSyono())) {
            return false;
        }

        return true;
    }
}
