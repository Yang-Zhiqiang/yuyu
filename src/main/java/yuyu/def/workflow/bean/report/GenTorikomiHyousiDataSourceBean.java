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
import yuyu.infr.validation.constraints.NenkinSyousyoNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 取込表紙データソースBean データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenTorikomiHyousiDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenTorikomiHyousiDataSourceBean() {
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String sousasyanm;

    public String getSousasyanm() {
        return sousasyanm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSousasyanm(String pSousasyanm) {
        sousasyanm = pSousasyanm;
    }

    private String subSystemNm;

    public String getSubSystemNm() {
        return subSystemNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSubSystemNm(String pSubSystemNm) {
        subSystemNm = pSubSystemNm;
    }

    @InvalidCharacter
    @MaxLength(max=20)
    @MultiByteStrings
    private String jimutetuzukinm;

    public String getJimutetuzukinm() {
        return jimutetuzukinm;
    }

    @DataConvert("toMultiByte")
    public void setJimutetuzukinm(String pJimutetuzukinm) {
        jimutetuzukinm = pJimutetuzukinm;
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

    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    @NenkinSyousyoNo
    private String nksysyno;

    public String getNksysyno() {
        return nksysyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String syoruinm;

    public String getSyoruinm() {
        return syoruinm;
    }

    @Trim("both")
    public void setSyoruinm(String pSyoruinm) {
        syoruinm = pSyoruinm;
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

    private String rSakuseiYmd;

    public String getRSakuseiYmd() {
        return rSakuseiYmd;
    }

    public void setRSakuseiYmd(String pRSakuseiYmd) {
        rSakuseiYmd = pRSakuseiYmd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
