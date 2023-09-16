package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AT_AccessLogSyousai;
import yuyu.def.db.id.PKAT_AccessLogSyousai;
import yuyu.def.db.meta.GenQAT_AccessLogSyousai;
import yuyu.def.db.meta.QAT_AccessLogSyousai;

/**
 * アクセスログ詳細テーブル テーブルのマッピング情報クラスで、 {@link AT_AccessLogSyousai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_AccessLogSyousai}</td><td colspan="3">アクセスログ詳細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getLogId logId}</td><td>ログＩＤ</td><td align="center">{@link PKAT_AccessLogSyousai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyousaiEdaNo syousaiEdaNo}</td><td>詳細ログ枝番号</td><td align="center">{@link PKAT_AccessLogSyousai ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getLogSyousaiData logSyousaiData}</td><td>ログ詳細データ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_AccessLogSyousai
 * @see     PKAT_AccessLogSyousai
 * @see     QAT_AccessLogSyousai
 * @see     GenQAT_AccessLogSyousai
 */
@MappedSuperclass
@Table(name=GenAT_AccessLogSyousai.TABLE_NAME)
@IdClass(value=PKAT_AccessLogSyousai.class)
public abstract class GenAT_AccessLogSyousai extends AbstractExDBEntity<AT_AccessLogSyousai, PKAT_AccessLogSyousai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_AccessLogSyousai";
    public static final String LOGID                    = "logId";
    public static final String SYOUSAIEDANO             = "syousaiEdaNo";
    public static final String LOGSYOUSAIDATA           = "logSyousaiData";

    private final PKAT_AccessLogSyousai primaryKey;

    public GenAT_AccessLogSyousai() {
        primaryKey = new PKAT_AccessLogSyousai();
    }

    public GenAT_AccessLogSyousai(String pLogId, Long pSyousaiEdaNo) {
        primaryKey = new PKAT_AccessLogSyousai(pLogId, pSyousaiEdaNo);
    }

    @Transient
    @Override
    public PKAT_AccessLogSyousai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_AccessLogSyousai> getMetaClass() {
        return QAT_AccessLogSyousai.class;
    }

    @Id
    @Column(name=GenAT_AccessLogSyousai.LOGID)
    public String getLogId() {
        return getPrimaryKey().getLogId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLogId(String pLogId) {
        getPrimaryKey().setLogId(pLogId);
    }

    @Id
    @Column(name=GenAT_AccessLogSyousai.SYOUSAIEDANO)
    public Long getSyousaiEdaNo() {
        return getPrimaryKey().getSyousaiEdaNo();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyousaiEdaNo(Long pSyousaiEdaNo) {
        getPrimaryKey().setSyousaiEdaNo(pSyousaiEdaNo);
    }

    private String logSyousaiData;

    @Column(name=GenAT_AccessLogSyousai.LOGSYOUSAIDATA)
    public String getLogSyousaiData() {
        return logSyousaiData;
    }

    @Trim("both")
    public void setLogSyousaiData(String pLogSyousaiData) {
        logSyousaiData = pLogSyousaiData;
    }
}
