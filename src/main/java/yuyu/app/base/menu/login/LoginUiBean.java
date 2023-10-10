package yuyu.app.base.menu.login;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * ログイン の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class LoginUiBean extends GenLoginUiBean {

    private static final long serialVersionUID = 3L;

    public LoginUiBean() {
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String syono) {
        this.syono = syono;
    }

}
