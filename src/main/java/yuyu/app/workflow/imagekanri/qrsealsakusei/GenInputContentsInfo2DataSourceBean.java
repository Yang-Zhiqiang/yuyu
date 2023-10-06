package yuyu.app.workflow.imagekanri.qrsealsakusei;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * QRシール用紙作成 - inputContentsInfo2 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenInputContentsInfo2DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @MousikomiNo
    private String mosno1;

    public String getMosno1() {
        return mosno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno1(String pMosno1) {
        mosno1 = pMosno1;
    }


    @MousikomiNo
    private String mosno2;

    public String getMosno2() {
        return mosno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno2(String pMosno2) {
        mosno2 = pMosno2;
    }


    @MousikomiNo
    private String mosno3;

    public String getMosno3() {
        return mosno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno3(String pMosno3) {
        mosno3 = pMosno3;
    }

}
