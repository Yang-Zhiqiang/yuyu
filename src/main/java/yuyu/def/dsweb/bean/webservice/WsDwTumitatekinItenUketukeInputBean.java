package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）ＤＳ積立金移転受付入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwTumitatekinItenUketukeInputBean extends GenWsDwTumitatekinItenUketukeInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwTumitatekinItenUketukeInputBean() {
    }

    public boolean chkHissuInput() {

        if (BizUtil.isBlank(getIwsSyono())) {
            return false;
        }

        if (BizUtil.isBlank(getIwsTumitatekinitenyoteibi())) {
            return false;
        }

        return true;
    }
}
