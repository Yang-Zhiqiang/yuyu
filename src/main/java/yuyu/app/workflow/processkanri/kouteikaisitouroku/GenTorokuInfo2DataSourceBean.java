package yuyu.app.workflow.processkanri.kouteikaisitouroku;

import java.io.Serializable;

/**
 * 工程開始登録 - torokuInfo2 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTorokuInfo2DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer dispno;

    public Integer getDispno() {
        return dispno;
    }

    public void setDispno(Integer pDispno) {
        dispno = pDispno;
    }


    private String workflowDispDocumentId;

    public String getWorkflowDispDocumentId() {
        return workflowDispDocumentId;
    }

    public void setWorkflowDispDocumentId(String pWorkflowDispDocumentId) {
        workflowDispDocumentId = pWorkflowDispDocumentId;
    }


    private String dispsyoruinmryaku;

    public String getDispsyoruinmryaku() {
        return dispsyoruinmryaku;
    }

    public void setDispsyoruinmryaku(String pDispsyoruinmryaku) {
        dispsyoruinmryaku = pDispsyoruinmryaku;
    }

}
