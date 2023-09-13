package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）メール変更入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwMailaddressHenkouInputBean extends GenWsDwMailaddressHenkouInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwMailaddressHenkouInputBean() {
    }

    public boolean chkHissuInput() {

        if (BizUtil.isBlank(getIwsDskokno())) {

            return false;
        }

        return true;
    }

}
