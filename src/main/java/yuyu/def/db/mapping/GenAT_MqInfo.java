package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_MqEmgcyStopStatusKbn;
import yuyu.def.classification.C_MqOnlineStatusKbn;
import yuyu.def.db.entity.AT_MqInfo;
import yuyu.def.db.id.PKAT_MqInfo;
import yuyu.def.db.meta.GenQAT_MqInfo;
import yuyu.def.db.meta.QAT_MqInfo;
import yuyu.def.db.type.UserType_C_MqEmgcyStopStatusKbn;
import yuyu.def.db.type.UserType_C_MqOnlineStatusKbn;

/**
 * ＭＱ情報テーブル テーブルのマッピング情報クラスで、 {@link AT_MqInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_MqInfo}</td><td colspan="3">ＭＱ情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getServerType serverType}</td><td>サーバ種別</td><td align="center">{@link PKAT_MqInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMqOnlineStatus mqOnlineStatus}</td><td>ＭＱオンライン状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MqOnlineStatusKbn}</td></tr>
 *  <tr><td>{@link #getMqEmgcyStopStatus mqEmgcyStopStatus}</td><td>ＭＱ緊急停止状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MqEmgcyStopStatusKbn}</td></tr>
 *  <tr><td>{@link #getRkmAtesaki rkmAtesaki}</td><td>連携元宛先</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getContextPath contextPath}</td><td>コンテキストパス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_MqInfo
 * @see     PKAT_MqInfo
 * @see     QAT_MqInfo
 * @see     GenQAT_MqInfo
 */
@MappedSuperclass
@Table(name=GenAT_MqInfo.TABLE_NAME)
@IdClass(value=PKAT_MqInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_MqEmgcyStopStatusKbn", typeClass=UserType_C_MqEmgcyStopStatusKbn.class),
    @TypeDef(name="UserType_C_MqOnlineStatusKbn", typeClass=UserType_C_MqOnlineStatusKbn.class)
})
public abstract class GenAT_MqInfo extends AbstractExDBEntity<AT_MqInfo, PKAT_MqInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_MqInfo";
    public static final String SERVERTYPE               = "serverType";
    public static final String MQONLINESTATUS           = "mqOnlineStatus";
    public static final String MQEMGCYSTOPSTATUS        = "mqEmgcyStopStatus";
    public static final String RKMATESAKI               = "rkmAtesaki";
    public static final String CONTEXTPATH              = "contextPath";

    private final PKAT_MqInfo primaryKey;

    public GenAT_MqInfo() {
        primaryKey = new PKAT_MqInfo();
    }

    public GenAT_MqInfo(String pServerType) {
        primaryKey = new PKAT_MqInfo(pServerType);
    }

    @Transient
    @Override
    public PKAT_MqInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_MqInfo> getMetaClass() {
        return QAT_MqInfo.class;
    }

    @Id
    @Column(name=GenAT_MqInfo.SERVERTYPE)
    public String getServerType() {
        return getPrimaryKey().getServerType();
    }

    public void setServerType(String pServerType) {
        getPrimaryKey().setServerType(pServerType);
    }

    private C_MqOnlineStatusKbn mqOnlineStatus;

    @Type(type="UserType_C_MqOnlineStatusKbn")
    @Column(name=GenAT_MqInfo.MQONLINESTATUS)
    public C_MqOnlineStatusKbn getMqOnlineStatus() {
        return mqOnlineStatus;
    }

    public void setMqOnlineStatus(C_MqOnlineStatusKbn pMqOnlineStatus) {
        mqOnlineStatus = pMqOnlineStatus;
    }

    private C_MqEmgcyStopStatusKbn mqEmgcyStopStatus;

    @Type(type="UserType_C_MqEmgcyStopStatusKbn")
    @Column(name=GenAT_MqInfo.MQEMGCYSTOPSTATUS)
    public C_MqEmgcyStopStatusKbn getMqEmgcyStopStatus() {
        return mqEmgcyStopStatus;
    }

    public void setMqEmgcyStopStatus(C_MqEmgcyStopStatusKbn pMqEmgcyStopStatus) {
        mqEmgcyStopStatus = pMqEmgcyStopStatus;
    }

    private String rkmAtesaki;

    @Column(name=GenAT_MqInfo.RKMATESAKI)
    public String getRkmAtesaki() {
        return rkmAtesaki;
    }

    public void setRkmAtesaki(String pRkmAtesaki) {
        rkmAtesaki = pRkmAtesaki;
    }

    private String contextPath;

    @Column(name=GenAT_MqInfo.CONTEXTPATH)
    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String pContextPath) {
        contextPath = pContextPath;
    }
}
