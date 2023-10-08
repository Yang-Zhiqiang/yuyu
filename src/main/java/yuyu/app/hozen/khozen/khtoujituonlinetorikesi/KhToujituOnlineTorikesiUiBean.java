package yuyu.app.hozen.khozen.khtoujituonlinetorikesi;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全当日オンライン取消 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhToujituOnlineTorikesiUiBean extends GenKhToujituOnlineTorikesiUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private IT_KykKihon kykKihon;

    private String henkousikibetukey;

    private String youkyuuno;

    public KhToujituOnlineTorikesiUiBean() {
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    public String getYoukyuuno() {
        return youkyuuno;
    }

    public void setYoukyuuno(String pYoukyuuno) {
        youkyuuno = pYoukyuuno;
    }

}
