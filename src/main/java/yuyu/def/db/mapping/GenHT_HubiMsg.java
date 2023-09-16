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
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.id.PKHT_HubiMsg;
import yuyu.def.db.meta.GenQHT_HubiMsg;
import yuyu.def.db.meta.QHT_HubiMsg;
import yuyu.def.db.type.UserType_C_HubisyubetuKbn;
import yuyu.def.db.type.UserType_C_HubisyubetusyousaiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 不備メッセージテーブル テーブルのマッピング情報クラスで、 {@link HT_HubiMsg} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_HubiMsg}</td><td colspan="3">不備メッセージテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_HubiMsg ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_HubiMsg ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMessageId messageId}</td><td>メッセージＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubimsg hubimsg}</td><td>不備メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubisyubetukbn hubisyubetukbn}</td><td>不備種別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HubisyubetuKbn}</td></tr>
 *  <tr><td>{@link #getHubisyubetusyousaikbn hubisyubetusyousaikbn}</td><td>不備種別詳細区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HubisyubetusyousaiKbn}</td></tr>
 *  <tr><td>{@link #getHituyousyoruicd hituyousyoruicd}</td><td>必要書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_HubiMsg
 * @see     PKHT_HubiMsg
 * @see     QHT_HubiMsg
 * @see     GenQHT_HubiMsg
 */
@MappedSuperclass
@Table(name=GenHT_HubiMsg.TABLE_NAME)
@IdClass(value=PKHT_HubiMsg.class)
@TypeDefs({
    @TypeDef(name="UserType_C_HubisyubetuKbn", typeClass=UserType_C_HubisyubetuKbn.class),
    @TypeDef(name="UserType_C_HubisyubetusyousaiKbn", typeClass=UserType_C_HubisyubetusyousaiKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenHT_HubiMsg extends AbstractExDBEntity<HT_HubiMsg, PKHT_HubiMsg> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_HubiMsg";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO                    = "renno";
    public static final String MESSAGEID                = "messageId";
    public static final String HUBIMSG                  = "hubimsg";
    public static final String HUBISYUBETUKBN           = "hubisyubetukbn";
    public static final String HUBISYUBETUSYOUSAIKBN    = "hubisyubetusyousaikbn";
    public static final String HITUYOUSYORUICD          = "hituyousyoruicd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_HubiMsg primaryKey;

    public GenHT_HubiMsg() {
        primaryKey = new PKHT_HubiMsg();
    }

    public GenHT_HubiMsg(String pMosno, Integer pRenno) {
        primaryKey = new PKHT_HubiMsg(pMosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_HubiMsg getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_HubiMsg> getMetaClass() {
        return QHT_HubiMsg.class;
    }

    @Id
    @Column(name=GenHT_HubiMsg.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Column(name=GenHT_HubiMsg.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String messageId;

    @Column(name=GenHT_HubiMsg.MESSAGEID)
    public String getMessageId() {
        return messageId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMessageId(String pMessageId) {
        messageId = pMessageId;
    }

    private String hubimsg;

    @Column(name=GenHT_HubiMsg.HUBIMSG)
    public String getHubimsg() {
        return hubimsg;
    }

    public void setHubimsg(String pHubimsg) {
        hubimsg = pHubimsg;
    }

    private C_HubisyubetuKbn hubisyubetukbn;

    @Type(type="UserType_C_HubisyubetuKbn")
    @Column(name=GenHT_HubiMsg.HUBISYUBETUKBN)
    public C_HubisyubetuKbn getHubisyubetukbn() {
        return hubisyubetukbn;
    }

    public void setHubisyubetukbn(C_HubisyubetuKbn pHubisyubetukbn) {
        hubisyubetukbn = pHubisyubetukbn;
    }

    private C_HubisyubetusyousaiKbn hubisyubetusyousaikbn;

    @Type(type="UserType_C_HubisyubetusyousaiKbn")
    @Column(name=GenHT_HubiMsg.HUBISYUBETUSYOUSAIKBN)
    public C_HubisyubetusyousaiKbn getHubisyubetusyousaikbn() {
        return hubisyubetusyousaikbn;
    }

    public void setHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn pHubisyubetusyousaikbn) {
        hubisyubetusyousaikbn = pHubisyubetusyousaikbn;
    }

    private C_SyoruiCdKbn hituyousyoruicd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenHT_HubiMsg.HITUYOUSYORUICD)
    public C_SyoruiCdKbn getHituyousyoruicd() {
        return hituyousyoruicd;
    }

    public void setHituyousyoruicd(C_SyoruiCdKbn pHituyousyoruicd) {
        hituyousyoruicd = pHituyousyoruicd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_HubiMsg.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_HubiMsg.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}