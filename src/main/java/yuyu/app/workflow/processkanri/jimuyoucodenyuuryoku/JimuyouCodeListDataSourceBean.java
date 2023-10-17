package yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku;

/**
 * 事務用コード入力 - jimuyouCodeList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class JimuyouCodeListDataSourceBean extends GenJimuyouCodeListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public JimuyouCodeListDataSourceBean() {
    }

    private int lineNum;

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int pLineNum) {
        this.lineNum = pLineNum;
    }


}
