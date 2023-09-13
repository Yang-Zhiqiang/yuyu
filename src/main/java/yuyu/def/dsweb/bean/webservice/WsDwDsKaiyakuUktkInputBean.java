package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）ＤＳ解約受付入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwDsKaiyakuUktkInputBean extends GenWsDwDsKaiyakuUktkInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwDsKaiyakuUktkInputBean() {
    }

    public boolean chkHissuInput() {

        if (BizUtil.isBlank(getIwsSyono())) {
            return false;
        }

        if (BizUtil.isBlank(getIwsDskokno())) {
            return false;
        }

        if (BizUtil.isBlank(getIwsDssyouhnbunruikbn())) {
            return false;
        }

        if (BizUtil.isBlank(getIwsShrtuukasyu())) {
            return false;
        }

        if (BizUtil.isBlank(getIwsVersion())) {
            return false;
        }

        return true;
    }
}
