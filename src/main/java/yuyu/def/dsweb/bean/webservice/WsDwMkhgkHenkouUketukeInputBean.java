package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）ＤＳ目標額変更受付入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwMkhgkHenkouUketukeInputBean extends GenWsDwMkhgkHenkouUketukeInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwMkhgkHenkouUketukeInputBean() {
    }

    public boolean chkHissu() {

        if (BizUtil.isBlank(getIwsSyono())) {
            return false;
        }

        return true;
    }

    public boolean chkHissuMkhgkwari() {

        if (BizUtil.isBlank(getIwsHenkougomkhgkwari())) {
            return false;
        }

        return true;
    }
}
