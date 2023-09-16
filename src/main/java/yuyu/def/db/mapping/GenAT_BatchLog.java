package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_LogLevelKbn;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.def.db.id.PKAT_BatchLog;
import yuyu.def.db.meta.GenQAT_BatchLog;
import yuyu.def.db.meta.QAT_BatchLog;
import yuyu.def.db.type.UserType_C_LogLevelKbn;

/**
 * バッチログテーブル テーブルのマッピング情報クラスで、 {@link AT_BatchLog} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_BatchLog}</td><td colspan="3">バッチログテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBatchJobId batchJobId}</td><td>バッチジョブＩＤ</td><td align="center">{@link PKAT_BatchLog ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBatchLogEdaNo batchLogEdaNo}</td><td>バッチログ枝番</td><td align="center">{@link PKAT_BatchLog ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLogOutputTime logOutputTime}</td><td>ログ出力時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLogLevelKbn logLevelKbn}</td><td>ログレベル区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_LogLevelKbn}</td></tr>
 *  <tr><td>{@link #getLogNaiyou logNaiyou}</td><td>ログ内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_BatchLog
 * @see     PKAT_BatchLog
 * @see     QAT_BatchLog
 * @see     GenQAT_BatchLog
 */
@MappedSuperclass
@Table(name=GenAT_BatchLog.TABLE_NAME)
@IdClass(value=PKAT_BatchLog.class)
@TypeDefs({
    @TypeDef(name="UserType_C_LogLevelKbn", typeClass=UserType_C_LogLevelKbn.class)
})
public abstract class GenAT_BatchLog extends AbstractExDBEntity<AT_BatchLog, PKAT_BatchLog> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_BatchLog";
    public static final String BATCHJOBID               = "batchJobId";
    public static final String BATCHLOGEDANO            = "batchLogEdaNo";
    public static final String LOGOUTPUTTIME            = "logOutputTime";
    public static final String LOGLEVELKBN              = "logLevelKbn";
    public static final String LOGNAIYOU                = "logNaiyou";

    private final PKAT_BatchLog primaryKey;

    public GenAT_BatchLog() {
        primaryKey = new PKAT_BatchLog();
    }

    public GenAT_BatchLog(String pBatchJobId, Integer pBatchLogEdaNo) {
        primaryKey = new PKAT_BatchLog(pBatchJobId, pBatchLogEdaNo);
    }

    @Transient
    @Override
    public PKAT_BatchLog getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_BatchLog> getMetaClass() {
        return QAT_BatchLog.class;
    }

    @Id
    @Column(name=GenAT_BatchLog.BATCHJOBID)
    public String getBatchJobId() {
        return getPrimaryKey().getBatchJobId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchJobId(String pBatchJobId) {
        getPrimaryKey().setBatchJobId(pBatchJobId);
    }

    @Id
    @Column(name=GenAT_BatchLog.BATCHLOGEDANO)
    public Integer getBatchLogEdaNo() {
        return getPrimaryKey().getBatchLogEdaNo();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchLogEdaNo(Integer pBatchLogEdaNo) {
        getPrimaryKey().setBatchLogEdaNo(pBatchLogEdaNo);
    }

    private String logOutputTime;

    @Column(name=GenAT_BatchLog.LOGOUTPUTTIME)
    public String getLogOutputTime() {
        return logOutputTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLogOutputTime(String pLogOutputTime) {
        logOutputTime = pLogOutputTime;
    }

    private C_LogLevelKbn logLevelKbn;

    @Type(type="UserType_C_LogLevelKbn")
    @Column(name=GenAT_BatchLog.LOGLEVELKBN)
    public C_LogLevelKbn getLogLevelKbn() {
        return logLevelKbn;
    }

    public void setLogLevelKbn(C_LogLevelKbn pLogLevelKbn) {
        logLevelKbn = pLogLevelKbn;
    }

    private String logNaiyou;

    @Column(name=GenAT_BatchLog.LOGNAIYOU)
    public String getLogNaiyou() {
        return logNaiyou;
    }

    @Trim("both")
    public void setLogNaiyou(String pLogNaiyou) {
        logNaiyou = pLogNaiyou;
    }
}
