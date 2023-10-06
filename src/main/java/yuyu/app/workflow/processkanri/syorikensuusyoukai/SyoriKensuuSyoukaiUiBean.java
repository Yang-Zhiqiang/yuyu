package yuyu.app.workflow.processkanri.syorikensuusyoukai;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 処理件数照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SyoriKensuuSyoukaiUiBean extends GenSyoriKensuuSyoukaiUiBean {

    private static final long serialVersionUID = 1L;

    public SyoriKensuuSyoukaiUiBean() {
    }

    public String searchSubSystemId = "";

    public String getSearchSubsystemId() {
        return searchSubSystemId;
    }

    public void setSearchSubsystemId(String pSearchSubsystemId) {
        searchSubSystemId = pSearchSubsystemId;
    }

    public String jimutetuzukiCd = "";

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pjimutetuzukiCd) {
        jimutetuzukiCd = pjimutetuzukiCd;
    }

}
