package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）本人確認処理入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwHonninKakuninInputBean extends GenWsDwHonninKakuninInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwHonninKakuninInputBean() {
    }

    public boolean chkHissuInput() {

        if (BizUtil.isBlank(getIwsSyono())) {
            return false;
        }
        if (BizUtil.isBlank(getIwsDskokno())) {
            return false;
        }
        if (BizUtil.isBlank(getIwsNmkn())) {
            return false;
        }
        if (BizUtil.isBlank(getIwsSeiymd())) {
            return false;
        }
        if (BizUtil.isBlank(getIwsTelnosimo4())) {
            return false;
        }

        return true;
    }
}
