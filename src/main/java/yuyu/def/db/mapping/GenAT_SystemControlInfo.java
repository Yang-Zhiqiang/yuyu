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
import yuyu.def.db.entity.AT_SystemControlInfo;
import yuyu.def.db.id.PKAT_SystemControlInfo;
import yuyu.def.db.meta.GenQAT_SystemControlInfo;
import yuyu.def.db.meta.QAT_SystemControlInfo;
import yuyu.def.db.type.UserType_C_MqEmgcyStopStatusKbn;

/**
 * システム制御情報テーブル テーブルのマッピング情報クラスで、 {@link AT_SystemControlInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_SystemControlInfo}</td><td colspan="3">システム制御情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSystemCtrlInfo systemCtrlInfo}</td><td>システム制御情報</td><td align="center">{@link PKAT_SystemControlInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMqEmgcyStopStatus mqEmgcyStopStatus}</td><td>ＭＱ緊急停止状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MqEmgcyStopStatusKbn}</td></tr>
 *  <tr><td>{@link #getOnlineStatus onlineStatus}</td><td>オンライン状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_SystemControlInfo
 * @see     PKAT_SystemControlInfo
 * @see     QAT_SystemControlInfo
 * @see     GenQAT_SystemControlInfo
 */
@MappedSuperclass
@Table(name=GenAT_SystemControlInfo.TABLE_NAME)
@IdClass(value=PKAT_SystemControlInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_MqEmgcyStopStatusKbn", typeClass=UserType_C_MqEmgcyStopStatusKbn.class)
})
public abstract class GenAT_SystemControlInfo extends AbstractExDBEntity<AT_SystemControlInfo, PKAT_SystemControlInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_SystemControlInfo";
    public static final String SYSTEMCTRLINFO           = "systemCtrlInfo";
    public static final String MQEMGCYSTOPSTATUS        = "mqEmgcyStopStatus";
    public static final String ONLINESTATUS             = "onlineStatus";

    private final PKAT_SystemControlInfo primaryKey;

    public GenAT_SystemControlInfo() {
        primaryKey = new PKAT_SystemControlInfo();
    }

    public GenAT_SystemControlInfo(String pSystemCtrlInfo) {
        primaryKey = new PKAT_SystemControlInfo(pSystemCtrlInfo);
    }

    @Transient
    @Override
    public PKAT_SystemControlInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_SystemControlInfo> getMetaClass() {
        return QAT_SystemControlInfo.class;
    }

    @Id
    @Column(name=GenAT_SystemControlInfo.SYSTEMCTRLINFO)
    public String getSystemCtrlInfo() {
        return getPrimaryKey().getSystemCtrlInfo();
    }

    public void setSystemCtrlInfo(String pSystemCtrlInfo) {
        getPrimaryKey().setSystemCtrlInfo(pSystemCtrlInfo);
    }

    private C_MqEmgcyStopStatusKbn mqEmgcyStopStatus;

    @Type(type="UserType_C_MqEmgcyStopStatusKbn")
    @Column(name=GenAT_SystemControlInfo.MQEMGCYSTOPSTATUS)
    public C_MqEmgcyStopStatusKbn getMqEmgcyStopStatus() {
        return mqEmgcyStopStatus;
    }

    public void setMqEmgcyStopStatus(C_MqEmgcyStopStatusKbn pMqEmgcyStopStatus) {
        mqEmgcyStopStatus = pMqEmgcyStopStatus;
    }

    private String onlineStatus;

    @Column(name=GenAT_SystemControlInfo.ONLINESTATUS)
    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String pOnlineStatus) {
        onlineStatus = pOnlineStatus;
    }
}
