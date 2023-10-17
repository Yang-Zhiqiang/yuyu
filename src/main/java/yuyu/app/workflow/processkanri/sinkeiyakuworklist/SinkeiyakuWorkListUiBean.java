package yuyu.app.workflow.processkanri.sinkeiyakuworklist;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.classification.C_TaskKbn;

/**
 * 新契約工程ワークリスト の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SinkeiyakuWorkListUiBean extends GenSinkeiyakuWorkListUiBean {

    private static final long serialVersionUID = 1L;

    public SinkeiyakuWorkListUiBean() {
    }

    private C_TaskKbn tasksentakujoutai;

    public C_TaskKbn getTasksentakujoutai() {
        return tasksentakujoutai;
    }

    public void setTasksentakujoutai(C_TaskKbn pTasksentakujoutai) {
        tasksentakujoutai = pTasksentakujoutai;
    }

    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
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
