package yuyu.app.workflow.processkanri.kouteikaisitouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.LengthRange;

/**
 * 工程開始登録 - torokuInfo1 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTorokuInfo1DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer dispno;

    public Integer getDispno() {
        return dispno;
    }

    public void setDispno(Integer pDispno) {
        dispno = pDispno;
    }


    @LengthRange(min=21, max=22)
    @AlphaDigit
    private String workflowDocumentId;

    public String getWorkflowDocumentId() {
        return workflowDocumentId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setWorkflowDocumentId(String pWorkflowDocumentId) {
        workflowDocumentId = pWorkflowDocumentId;
    }

}
