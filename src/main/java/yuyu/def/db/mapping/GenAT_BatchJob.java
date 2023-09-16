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
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.id.PKAT_BatchJob;
import yuyu.def.db.meta.GenQAT_BatchJob;
import yuyu.def.db.meta.QAT_BatchJob;
import yuyu.def.db.type.UserType_C_BatchJyoutaiKbn;
import yuyu.def.db.type.UserType_C_BatchKidouKbn;
import yuyu.def.db.type.UserType_C_BatchResultKbn;

/**
 * バッチジョブテーブル テーブルのマッピング情報クラスで、 {@link AT_BatchJob} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_BatchJob}</td><td colspan="3">バッチジョブテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBatchJobId batchJobId}</td><td>バッチジョブＩＤ</td><td align="center">{@link PKAT_BatchJob ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBatchId batchId}</td><td>バッチＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBatchKidouKbn batchKidouKbn}</td><td>バッチ起動区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BatchKidouKbn}</td></tr>
 *  <tr><td>{@link #getBatchJyoutaiKbn batchJyoutaiKbn}</td><td>バッチ状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BatchJyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getBatchResultKbn batchResultKbn}</td><td>バッチ結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BatchResultKbn}</td></tr>
 *  <tr><td>{@link #getBatchSyoriYmd batchSyoriYmd}</td><td>バッチ処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBatchStartTime batchStartTime}</td><td>バッチ開始時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBatchEndTime batchEndTime}</td><td>バッチ終了時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getElapsedTime elapsedTime}</td><td>経過時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getElapsedSeconds elapsedSeconds}</td><td>経過秒数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     AT_BatchJob
 * @see     PKAT_BatchJob
 * @see     QAT_BatchJob
 * @see     GenQAT_BatchJob
 */
@MappedSuperclass
@Table(name=GenAT_BatchJob.TABLE_NAME)
@IdClass(value=PKAT_BatchJob.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_BatchJyoutaiKbn", typeClass=UserType_C_BatchJyoutaiKbn.class),
    @TypeDef(name="UserType_C_BatchKidouKbn", typeClass=UserType_C_BatchKidouKbn.class),
    @TypeDef(name="UserType_C_BatchResultKbn", typeClass=UserType_C_BatchResultKbn.class)
})
public abstract class GenAT_BatchJob extends AbstractExDBEntity<AT_BatchJob, PKAT_BatchJob> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_BatchJob";
    public static final String BATCHJOBID               = "batchJobId";
    public static final String BATCHID                  = "batchId";
    public static final String BATCHKIDOUKBN            = "batchKidouKbn";
    public static final String BATCHJYOUTAIKBN          = "batchJyoutaiKbn";
    public static final String BATCHRESULTKBN           = "batchResultKbn";
    public static final String BATCHSYORIYMD            = "batchSyoriYmd";
    public static final String BATCHSTARTTIME           = "batchStartTime";
    public static final String BATCHENDTIME             = "batchEndTime";
    public static final String ELAPSEDTIME              = "elapsedTime";
    public static final String ELAPSEDSECONDS           = "elapsedSeconds";

    private final PKAT_BatchJob primaryKey;

    public GenAT_BatchJob() {
        primaryKey = new PKAT_BatchJob();
    }

    public GenAT_BatchJob(String pBatchJobId) {
        primaryKey = new PKAT_BatchJob(pBatchJobId);
    }

    @Transient
    @Override
    public PKAT_BatchJob getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_BatchJob> getMetaClass() {
        return QAT_BatchJob.class;
    }

    @Id
    @Column(name=GenAT_BatchJob.BATCHJOBID)
    public String getBatchJobId() {
        return getPrimaryKey().getBatchJobId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchJobId(String pBatchJobId) {
        getPrimaryKey().setBatchJobId(pBatchJobId);
    }

    private String batchId;

    @Column(name=GenAT_BatchJob.BATCHID)
    public String getBatchId() {
        return batchId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchId(String pBatchId) {
        batchId = pBatchId;
    }

    private C_BatchKidouKbn batchKidouKbn;

    @Type(type="UserType_C_BatchKidouKbn")
    @Column(name=GenAT_BatchJob.BATCHKIDOUKBN)
    public C_BatchKidouKbn getBatchKidouKbn() {
        return batchKidouKbn;
    }

    public void setBatchKidouKbn(C_BatchKidouKbn pBatchKidouKbn) {
        batchKidouKbn = pBatchKidouKbn;
    }

    private C_BatchJyoutaiKbn batchJyoutaiKbn;

    @Type(type="UserType_C_BatchJyoutaiKbn")
    @Column(name=GenAT_BatchJob.BATCHJYOUTAIKBN)
    public C_BatchJyoutaiKbn getBatchJyoutaiKbn() {
        return batchJyoutaiKbn;
    }

    public void setBatchJyoutaiKbn(C_BatchJyoutaiKbn pBatchJyoutaiKbn) {
        batchJyoutaiKbn = pBatchJyoutaiKbn;
    }

    private C_BatchResultKbn batchResultKbn;

    @Type(type="UserType_C_BatchResultKbn")
    @Column(name=GenAT_BatchJob.BATCHRESULTKBN)
    public C_BatchResultKbn getBatchResultKbn() {
        return batchResultKbn;
    }

    public void setBatchResultKbn(C_BatchResultKbn pBatchResultKbn) {
        batchResultKbn = pBatchResultKbn;
    }

    private BizDate batchSyoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenAT_BatchJob.BATCHSYORIYMD)
    @ValidDate
    public BizDate getBatchSyoriYmd() {
        return batchSyoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchSyoriYmd(BizDate pBatchSyoriYmd) {
        batchSyoriYmd = pBatchSyoriYmd;
    }

    private String batchStartTime;

    @Column(name=GenAT_BatchJob.BATCHSTARTTIME)
    public String getBatchStartTime() {
        return batchStartTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchStartTime(String pBatchStartTime) {
        batchStartTime = pBatchStartTime;
    }

    private String batchEndTime;

    @Column(name=GenAT_BatchJob.BATCHENDTIME)
    public String getBatchEndTime() {
        return batchEndTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchEndTime(String pBatchEndTime) {
        batchEndTime = pBatchEndTime;
    }

    private String elapsedTime;

    @Column(name=GenAT_BatchJob.ELAPSEDTIME)
    public String getElapsedTime() {
        return elapsedTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setElapsedTime(String pElapsedTime) {
        elapsedTime = pElapsedTime;
    }

    private Long elapsedSeconds;

    @Column(name=GenAT_BatchJob.ELAPSEDSECONDS)
    public Long getElapsedSeconds() {
        return elapsedSeconds;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setElapsedSeconds(Long pElapsedSeconds) {
        elapsedSeconds = pElapsedSeconds;
    }
}
