package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;

/**
 * （ＤＳＷｅｂ）パスワード変更入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwPasswordHenkouInputBean extends GenWsDwPasswordHenkouInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwPasswordHenkouInputBean() {
    }

    public boolean hissuCheck(){

        if(BizUtil.isBlank(super.getIwsDskokno())){
            return false;
        }

        if(BizUtil.isBlank(super.getIwsSclakatopassword())){
            return false;
        }

        return true;
    }
}
