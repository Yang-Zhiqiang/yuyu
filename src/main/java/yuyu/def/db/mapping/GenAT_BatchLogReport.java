package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.AT_BatchLogReport;
import yuyu.def.db.id.PKAT_BatchLogReport;
import yuyu.def.db.meta.GenQAT_BatchLogReport;
import yuyu.def.db.meta.QAT_BatchLogReport;

/**
 * バッチログレポートテーブル テーブルのマッピング情報クラスで、 {@link AT_BatchLogReport} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_BatchLogReport}</td><td colspan="3">バッチログレポートテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBatchJobId batchJobId}</td><td>バッチジョブＩＤ</td><td align="center">{@link PKAT_BatchLogReport ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getReportKey reportKey}</td><td>帳票キー</td><td align="center">{@link PKAT_BatchLogReport ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouJoinKey tyouhyouJoinKey}</td><td>帳票結合キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBatchSyoriYmd batchSyoriYmd}</td><td>バッチ処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     AT_BatchLogReport
 * @see     PKAT_BatchLogReport
 * @see     QAT_BatchLogReport
 * @see     GenQAT_BatchLogReport
 */
@MappedSuperclass
@Table(name=GenAT_BatchLogReport.TABLE_NAME)
@IdClass(value=PKAT_BatchLogReport.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenAT_BatchLogReport extends AbstractExDBEntity<AT_BatchLogReport, PKAT_BatchLogReport> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_BatchLogReport";
    public static final String BATCHJOBID               = "batchJobId";
    public static final String REPORTKEY                = "reportKey";
    public static final String TYOUHYOUJOINKEY          = "tyouhyouJoinKey";
    public static final String BATCHSYORIYMD            = "batchSyoriYmd";

    private final PKAT_BatchLogReport primaryKey;

    public GenAT_BatchLogReport() {
        primaryKey = new PKAT_BatchLogReport();
    }

    public GenAT_BatchLogReport(String pBatchJobId, String pReportKey) {
        primaryKey = new PKAT_BatchLogReport(pBatchJobId, pReportKey);
    }

    @Transient
    @Override
    public PKAT_BatchLogReport getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_BatchLogReport> getMetaClass() {
        return QAT_BatchLogReport.class;
    }

    @Id
    @Column(name=GenAT_BatchLogReport.BATCHJOBID)
    public String getBatchJobId() {
        return getPrimaryKey().getBatchJobId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchJobId(String pBatchJobId) {
        getPrimaryKey().setBatchJobId(pBatchJobId);
    }

    @Id
    @Column(name=GenAT_BatchLogReport.REPORTKEY)
    public String getReportKey() {
        return getPrimaryKey().getReportKey();
    }

    public void setReportKey(String pReportKey) {
        getPrimaryKey().setReportKey(pReportKey);
    }

    private String tyouhyouJoinKey;

    @Column(name=GenAT_BatchLogReport.TYOUHYOUJOINKEY)
    public String getTyouhyouJoinKey() {
        return tyouhyouJoinKey;
    }

    public void setTyouhyouJoinKey(String pTyouhyouJoinKey) {
        tyouhyouJoinKey = pTyouhyouJoinKey;
    }

    private BizDate batchSyoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenAT_BatchLogReport.BATCHSYORIYMD)
    @ValidDate
    public BizDate getBatchSyoriYmd() {
        return batchSyoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchSyoriYmd(BizDate pBatchSyoriYmd) {
        batchSyoriYmd = pBatchSyoriYmd;
    }
}
