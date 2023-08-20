package yuyu.def.workflow.bean.report;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.LengthRange;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * QRシール用紙データソースBean データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenQRSealDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenQRSealDataSourceBean() {
    }

    private byte[] qrcodedata;

    public byte[] getQrcodedata() {
        return qrcodedata;
    }

    public void setQrcodedata(byte[] pQrcodedata) {
        qrcodedata = pQrcodedata;
    }

    @MaxLength(max=10)
    @MultiByteStrings
    @InvalidCharacter
    private String syoruinmryaku;

    public String getSyoruinmryaku() {
        return syoruinmryaku;
    }

    public void setSyoruinmryaku(String pSyoruinmryaku) {
        syoruinmryaku = pSyoruinmryaku;
    }

    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
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

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
