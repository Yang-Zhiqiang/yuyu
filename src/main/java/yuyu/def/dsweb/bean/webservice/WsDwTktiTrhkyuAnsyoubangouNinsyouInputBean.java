package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）ＤＳ特定取引用暗証番号認証入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwTktiTrhkyuAnsyoubangouNinsyouInputBean extends GenWsDwTktiTrhkyuAnsyoubangouNinsyouInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwTktiTrhkyuAnsyoubangouNinsyouInputBean() {
    }

    public boolean chkInput() {

        if (BizUtil.isBlank(getIwsDskokno())) {
            return false;
        }

        if (BizUtil.isBlank(getIwsSyono())) {
            return false;
        }

        if (BizUtil.isBlank(getIwsTokuteitrhkansyono())) {
            return false;
        }

        return true;
    }

}
