package yuyu.def.biz.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （共通Web）社内用契約内容照会入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class IwssnSyanaiKykNaiyouSyoukaiInputBean extends GenIwssnSyanaiKykNaiyouSyoukaiInputBean {

    private static final long serialVersionUID = 1L;

    public IwssnSyanaiKykNaiyouSyoukaiInputBean() {
    }

    public boolean chkHissuMInput() {


        if (BizUtil.isBlank(getIwssnSyono())) {

            return false;

        }

        return true;
    }

}
