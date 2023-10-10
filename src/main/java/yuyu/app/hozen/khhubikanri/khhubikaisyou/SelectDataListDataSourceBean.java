package yuyu.app.hozen.khhubikanri.khhubikaisyou;

/**
 * 契約保全不備解消 - selectDataList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SelectDataListDataSourceBean extends GenSelectDataListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public SelectDataListDataSourceBean() {
    }

    private String dispjimutetuzukicd;

    private String hubiSikibetuKey;

    private String taskId;

    public String getDispJimutetuzukicd() {
        return dispjimutetuzukicd;
    }

    public void setDispJimutetuzukicd(String pDispjimutetuzukicd) {
        dispjimutetuzukicd = pDispjimutetuzukicd;
    }

    public String getHubiSikibetuKey() {
        return hubiSikibetuKey;
    }

    public void setHubiSikibetuKey(String pHubiSikibetuKey) {
        hubiSikibetuKey = pHubiSikibetuKey;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String pTaskId) {
        taskId = pTaskId;
    }
}
