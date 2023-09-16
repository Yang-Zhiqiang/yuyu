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
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.id.PKAT_AccessLog;
import yuyu.def.db.meta.GenQAT_AccessLog;
import yuyu.def.db.meta.QAT_AccessLog;
import yuyu.def.db.type.UserType_C_AccessLogSyubetuKbn;

/**
 * アクセスログテーブル テーブルのマッピング情報クラスで、 {@link AT_AccessLog} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_AccessLog}</td><td colspan="3">アクセスログテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getLogId logId}</td><td>ログＩＤ</td><td align="center">{@link PKAT_AccessLog ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTimeStamp timeStamp}</td><td>アクセスログ出力時刻</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSyoriUserId syoriUserId}</td><td>処理ユーザーＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIpAddress ipAddress}</td><td>ＩＰアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSessionId sessionId}</td><td>セッションＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTransactionId transactionId}</td><td>トランザクションＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLogKindCd logKindCd}</td><td>ログ種別コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AccessLogSyubetuKbn}</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCategoryId categoryId}</td><td>カテゴリＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTanmatuType tanmatuType}</td><td>端末タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getButsuriSosikiCd butsuriSosikiCd}</td><td>物理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRonriSosikiCd ronriSosikiCd}</td><td>論理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTanmatuJyoutaiHyouji tanmatuJyoutaiHyouji}</td><td>端末状態表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLogData logData}</td><td>ログデータ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyousaiKensuu syousaiKensuu}</td><td>詳細ログ件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     AT_AccessLog
 * @see     PKAT_AccessLog
 * @see     QAT_AccessLog
 * @see     GenQAT_AccessLog
 */
@MappedSuperclass
@Table(name=GenAT_AccessLog.TABLE_NAME)
@IdClass(value=PKAT_AccessLog.class)
@TypeDefs({
    @TypeDef(name="UserType_C_AccessLogSyubetuKbn", typeClass=UserType_C_AccessLogSyubetuKbn.class)
})
public abstract class GenAT_AccessLog extends AbstractExDBEntity<AT_AccessLog, PKAT_AccessLog> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_AccessLog";
    public static final String LOGID                    = "logId";
    public static final String TIMESTAMP                = "timeStamp";
    public static final String SYORIUSERID              = "syoriUserId";
    public static final String IPADDRESS                = "ipAddress";
    public static final String SESSIONID                = "sessionId";
    public static final String TRANSACTIONID            = "transactionId";
    public static final String LOGKINDCD                = "logKindCd";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String CATEGORYID               = "categoryId";
    public static final String KINOUID                  = "kinouId";
    public static final String TANMATUTYPE              = "tanmatuType";
    public static final String BUTSURISOSIKICD          = "butsuriSosikiCd";
    public static final String RONRISOSIKICD            = "ronriSosikiCd";
    public static final String TANMATUJYOUTAIHYOUJI     = "tanmatuJyoutaiHyouji";
    public static final String LOGDATA                  = "logData";
    public static final String SYOUSAIKENSUU            = "syousaiKensuu";

    private final PKAT_AccessLog primaryKey;

    public GenAT_AccessLog() {
        primaryKey = new PKAT_AccessLog();
    }

    public GenAT_AccessLog(String pLogId) {
        primaryKey = new PKAT_AccessLog(pLogId);
    }

    @Transient
    @Override
    public PKAT_AccessLog getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_AccessLog> getMetaClass() {
        return QAT_AccessLog.class;
    }

    @Id
    @Column(name=GenAT_AccessLog.LOGID)
    public String getLogId() {
        return getPrimaryKey().getLogId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLogId(String pLogId) {
        getPrimaryKey().setLogId(pLogId);
    }

    private Long timeStamp;

    @Column(name=GenAT_AccessLog.TIMESTAMP)
    public Long getTimeStamp() {
        return timeStamp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTimeStamp(Long pTimeStamp) {
        timeStamp = pTimeStamp;
    }

    private String syoriUserId;

    @Column(name=GenAT_AccessLog.SYORIUSERID)
    public String getSyoriUserId() {
        return syoriUserId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriUserId(String pSyoriUserId) {
        syoriUserId = pSyoriUserId;
    }

    private String ipAddress;

    @Column(name=GenAT_AccessLog.IPADDRESS)
    public String getIpAddress() {
        return ipAddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIpAddress(String pIpAddress) {
        ipAddress = pIpAddress;
    }

    private String sessionId;

    @Column(name=GenAT_AccessLog.SESSIONID)
    public String getSessionId() {
        return sessionId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSessionId(String pSessionId) {
        sessionId = pSessionId;
    }

    private String transactionId;

    @Column(name=GenAT_AccessLog.TRANSACTIONID)
    public String getTransactionId() {
        return transactionId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTransactionId(String pTransactionId) {
        transactionId = pTransactionId;
    }

    private C_AccessLogSyubetuKbn logKindCd;

    @Type(type="UserType_C_AccessLogSyubetuKbn")
    @Column(name=GenAT_AccessLog.LOGKINDCD)
    public C_AccessLogSyubetuKbn getLogKindCd() {
        return logKindCd;
    }

    public void setLogKindCd(C_AccessLogSyubetuKbn pLogKindCd) {
        logKindCd = pLogKindCd;
    }

    private String subSystemId;

    @Column(name=GenAT_AccessLog.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private String categoryId;

    @Column(name=GenAT_AccessLog.CATEGORYID)
    public String getCategoryId() {
        return categoryId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCategoryId(String pCategoryId) {
        categoryId = pCategoryId;
    }

    private String kinouId;

    @Column(name=GenAT_AccessLog.KINOUID)
    public String getKinouId() {
        return kinouId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

    private String tanmatuType;

    @Column(name=GenAT_AccessLog.TANMATUTYPE)
    public String getTanmatuType() {
        return tanmatuType;
    }

    public void setTanmatuType(String pTanmatuType) {
        tanmatuType = pTanmatuType;
    }

    private String butsuriSosikiCd;

    @Column(name=GenAT_AccessLog.BUTSURISOSIKICD)
    public String getButsuriSosikiCd() {
        return butsuriSosikiCd;
    }

    public void setButsuriSosikiCd(String pButsuriSosikiCd) {
        butsuriSosikiCd = pButsuriSosikiCd;
    }

    private String ronriSosikiCd;

    @Column(name=GenAT_AccessLog.RONRISOSIKICD)
    public String getRonriSosikiCd() {
        return ronriSosikiCd;
    }

    public void setRonriSosikiCd(String pRonriSosikiCd) {
        ronriSosikiCd = pRonriSosikiCd;
    }

    private String tanmatuJyoutaiHyouji;

    @Column(name=GenAT_AccessLog.TANMATUJYOUTAIHYOUJI)
    public String getTanmatuJyoutaiHyouji() {
        return tanmatuJyoutaiHyouji;
    }

    public void setTanmatuJyoutaiHyouji(String pTanmatuJyoutaiHyouji) {
        tanmatuJyoutaiHyouji = pTanmatuJyoutaiHyouji;
    }

    private String logData;

    @Column(name=GenAT_AccessLog.LOGDATA)
    public String getLogData() {
        return logData;
    }

    @Trim("both")
    public void setLogData(String pLogData) {
        logData = pLogData;
    }

    private Long syousaiKensuu;

    @Column(name=GenAT_AccessLog.SYOUSAIKENSUU)
    public Long getSyousaiKensuu() {
        return syousaiKensuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyousaiKensuu(Long pSyousaiKensuu) {
        syousaiKensuu = pSyousaiKensuu;
    }
}
