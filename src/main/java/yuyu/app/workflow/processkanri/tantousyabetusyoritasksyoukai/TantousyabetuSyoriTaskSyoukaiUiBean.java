package yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 担当者別処理タスク照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class TantousyabetuSyoriTaskSyoukaiUiBean extends GenTantousyabetuSyoriTaskSyoukaiUiBean {

    private static final long serialVersionUID = 1L;

    public TantousyabetuSyoriTaskSyoukaiUiBean() {
    }

    private String gyoumukeylbl;

    public String getGyoumukeylbl() {
        return gyoumukeylbl;
    }

    public void setGyoumukeylbl(String pGyoumukeylbl) {
        gyoumukeylbl = pGyoumukeylbl;
    }
}
