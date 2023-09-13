package yuyu.def.dsweb.bean.webservice;

import java.util.List;

import net.arnx.jsonic.JSONHint;

/**
 * （ＤＳＷｅｂ）不可文字チェック出力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwHukamojiCheckOutputBean extends GenWsDwHukamojiCheckOutputBean {

    private static final long serialVersionUID = 1L;

    public WsDwHukamojiCheckOutputBean() {
    }

    private List<String> iwsCheckKekkaLst;

    private String iwsCheckkekka;

    public List<String> getIwsCheckKekkaLst() {
        return iwsCheckKekkaLst;
    }

    public void setIwsCheckKekkaLst(List<String> pIwsCheckKekkaLst) {
        this.iwsCheckKekkaLst = pIwsCheckKekkaLst;
    }

    @Override
    @Deprecated
    @JSONHint(ignore=true)
    public String getIwsCheckkekka() {
        return iwsCheckkekka;
    }

    @Override
    @Deprecated
    @JSONHint(ignore=true)
    public void setIwsCheckkekka(String pIwsCheckkekka) {
        this.iwsCheckkekka = pIwsCheckkekka;
    }
}
