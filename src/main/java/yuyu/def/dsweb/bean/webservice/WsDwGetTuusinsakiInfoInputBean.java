package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）顧客通信先情報取得入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwGetTuusinsakiInfoInputBean extends GenWsDwGetTuusinsakiInfoInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwGetTuusinsakiInfoInputBean() {
    }

    public boolean chkInput() {

        if (BizUtil.isBlank(getIwsSyono())) {
            return false;
        }

        return true;
    }
}
