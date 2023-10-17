package yuyu.app.workflow.imagekanri.qrsealsakusei;

/**
 * QRシール用紙作成 - inputContentsInfo3 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class InputContentsInfo3DataSourceBean extends GenInputContentsInfo3DataSourceBean {

    private static final long serialVersionUID = 1L;

    public InputContentsInfo3DataSourceBean() {
    }

    private int lineNum;

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int pLineNum) {
        this.lineNum = pLineNum;
    }

    private int groupNum;

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int pGroupNum) {
        this.groupNum = pGroupNum;
    }

    private String rykSyNm;

    public String getRykSyNm() {
        return rykSyNm;
    }

    public void setRykSyNm(String pRykSyNm) {
        this.rykSyNm = pRykSyNm;
    }

}
