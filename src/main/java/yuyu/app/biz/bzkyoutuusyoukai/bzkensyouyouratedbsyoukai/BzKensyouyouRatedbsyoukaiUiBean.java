package yuyu.app.biz.bzkyoutuusyoukai.bzkensyouyouratedbsyoukai;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 検証用レートＤＢ照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class BzKensyouyouRatedbsyoukaiUiBean extends GenBzKensyouyouRatedbsyoukaiUiBean {

    private static final long serialVersionUID = 1L;

    private String tyouhyouKey;

    public BzKensyouyouRatedbsyoukaiUiBean() {
    }

    public String getTyouhyouKey() {
        return tyouhyouKey;
    }

    public void setTyouhyouKey(String pTyouhyouKey) {
        tyouhyouKey = pTyouhyouKey;
    }

}
