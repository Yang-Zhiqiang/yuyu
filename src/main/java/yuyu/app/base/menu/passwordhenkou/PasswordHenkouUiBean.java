package yuyu.app.base.menu.passwordhenkou;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * パスワード変更 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class PasswordHenkouUiBean extends GenPasswordHenkouUiBean {

    private static final long serialVersionUID = 1L;

    public PasswordHenkouUiBean() {
    }

    private boolean passwordHenkouKyokaFlg;

    public boolean getPasswordHenkouKyokaFlg() {
        return passwordHenkouKyokaFlg;
    }

    public void setPasswordHenkouKyokaFlg(boolean pPasswordHenkouKyokaFlg) {
        passwordHenkouKyokaFlg = pPasswordHenkouKyokaFlg;
    }
}
