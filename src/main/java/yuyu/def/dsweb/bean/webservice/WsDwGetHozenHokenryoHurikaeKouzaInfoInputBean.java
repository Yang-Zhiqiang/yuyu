package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）保全保険料振替口座情報取得入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwGetHozenHokenryoHurikaeKouzaInfoInputBean extends GenWsDwGetHozenHokenryoHurikaeKouzaInfoInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwGetHozenHokenryoHurikaeKouzaInfoInputBean() {
    }

    public boolean chkInput() {

        if (BizUtil.isBlank(getIwsSyono())) {
            return false;
        }
        return true;
    }

}
