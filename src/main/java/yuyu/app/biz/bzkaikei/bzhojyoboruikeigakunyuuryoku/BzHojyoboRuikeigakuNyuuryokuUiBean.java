package yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 補助簿累計額入力 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class BzHojyoboRuikeigakuNyuuryokuUiBean extends GenBzHojyoboRuikeigakuNyuuryokuUiBean {

    private static final long serialVersionUID = 1L;

    private boolean updateKanouFlg;

    private String inputGamenMod;

    private boolean sakujyoBtnDispFlg;

    private boolean deleteFlg;

    private String updateKanjyoukmkCd;

    public BzHojyoboRuikeigakuNyuuryokuUiBean() {
    }

    public boolean getUpdateKanouFlg() {
        return updateKanouFlg;
    }

    public void setUpdateKanouFlg(boolean pUpdateKanouFlg) {
        updateKanouFlg = pUpdateKanouFlg;
    }

    public String getInputGamenMod() {
        return inputGamenMod;
    }

    public void setInputGamenMod(String pInputGamenMod) {
        inputGamenMod = pInputGamenMod;
    }

    public boolean getSakujyoBtnDispFlg() {
        return sakujyoBtnDispFlg;
    }

    public void setSakujyoBtnDispFlg(boolean pSakujyoBtnDispFlg) {
        sakujyoBtnDispFlg = pSakujyoBtnDispFlg;
    }

    public boolean getDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(boolean pDeleteFlg) {
        deleteFlg = pDeleteFlg;
    }

    public String getUpdateKanjyoukmkCd() {
        return updateKanjyoukmkCd;
    }

    public void setUpdateKanjyoukmkCd(String pUpdateKanjyoukmkCd) {
        updateKanjyoukmkCd = pUpdateKanjyoukmkCd;
    }
}
