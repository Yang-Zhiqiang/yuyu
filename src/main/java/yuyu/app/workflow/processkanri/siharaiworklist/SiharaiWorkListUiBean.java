package yuyu.app.workflow.processkanri.siharaiworklist;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.classification.C_TaskKbn;

/**
 * 保険金給付金支払工程ワークリスト の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiharaiWorkListUiBean extends GenSiharaiWorkListUiBean {

    private static final long serialVersionUID = 1L;

    public SiharaiWorkListUiBean() {
    }

    private C_TaskKbn tasksentakujoutai;

    public C_TaskKbn getTasksentakujoutai() {
        return tasksentakujoutai;
    }

    public void setTasksentakujoutai(C_TaskKbn pTasksentakujoutai) {
        tasksentakujoutai = pTasksentakujoutai;
    }

    private String itiranJimutetuzukicd;

    public String getItiranJimutetuzukicd() {
        return itiranJimutetuzukicd;
    }

    public void setItiranJimutetuzukicd(String pItiranJimutetuzukicd) {
        itiranJimutetuzukicd = pItiranJimutetuzukicd;
    }

    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String pTaskId) {
        taskId = pTaskId;
    }

    private String dispTaskName;

    public String getDispTaskName() {
        return dispTaskName;
    }

    public void setDispTaskName(String pDispTaskName) {
        dispTaskName = pDispTaskName;
    }

}
