package yuyu.app.workflow.processkanri.wariatekaijyo;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 担当者割当解除 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class WariateKaijyoUiBean extends GenWariateKaijyoUiBean {

    private static final long serialVersionUID = 1L;

    public WariateKaijyoUiBean() {
    }

    private String gyoumukeylbl;

    public String getGyoumukeylbl() {
        return gyoumukeylbl;
    }

    public void setGyoumukeylbl(String pGyoumukeylbl) {
        gyoumukeylbl = pGyoumukeylbl;
    }


    public boolean tantoFlg = true;

    public boolean isTantoFlg() {
        return tantoFlg;
    }

    public void setTantoFlg(boolean tantoFlg) {
        this.tantoFlg = tantoFlg;
    }


    public String searchSubsystemId = "";

    public String getSearchSubsystemId() {
        return searchSubsystemId;
    }

    public void setSearchSubsystemId(String searchSubsystemId) {
        this.searchSubsystemId = searchSubsystemId;
    }

    public String searchJimutetuzukicd = "";

    public String getSearchJimutetuzukicd() {
        return searchJimutetuzukicd;
    }

    public void setSearchJimutetuzukicd(String searchJimutetuzukicd) {
        this.searchJimutetuzukicd = searchJimutetuzukicd;
    }


    public String searchWorkflowTskNm = "";

    public String getSearchWorkflowTskNm() {
        return searchWorkflowTskNm;
    }

    public void setSearchWorkflowTskNm(String searchWorkflowTskNm) {
        this.searchWorkflowTskNm = searchWorkflowTskNm;
    }

    public String searchTantid = "";

    public String getSearchTantid() {
        return searchTantid;
    }

    public void setSearchTantid(String searchTantid) {
        this.searchTantid = searchTantid;
    }

}
