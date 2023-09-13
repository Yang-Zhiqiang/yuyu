package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）保全契約詳細取得（円建一時払年金）入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwGetHozenKykEnItijiNnknInputBean extends GenWsDwGetHozenKykEnItijiNnknInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwGetHozenKykEnItijiNnknInputBean() {
    }
    public boolean chkInput() {

        if (BizUtil.isBlank(getIwsSyono())) {
            return false;
        }

        return true;
    }

}
