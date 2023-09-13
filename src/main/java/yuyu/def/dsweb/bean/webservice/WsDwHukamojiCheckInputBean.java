package yuyu.def.dsweb.bean.webservice;

import java.util.List;

/**
 * （ＤＳＷｅｂ）不可文字チェック入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwHukamojiCheckInputBean extends GenWsDwHukamojiCheckInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwHukamojiCheckInputBean() {
    }

    private List<String> iwsCheckObjLst;

    public List<String> getIwsCheckObjLst() {
        return iwsCheckObjLst;
    }

    public void setIwsCheckObjLst(List<String> pIwsCheckObjLst) {
        this.iwsCheckObjLst = pIwsCheckObjLst;
    }

    @Override
    public String getIwsCheckmojiretu() {
        return iwsCheckObjLst.toString();
    }

}
