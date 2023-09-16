package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.WT_KouteiLock;
import yuyu.def.db.id.PKWT_KouteiLock;
import yuyu.def.db.meta.GenQWT_KouteiLock;
import yuyu.def.db.meta.QWT_KouteiLock;

/**
 * 工程ロック情報テーブル テーブルのマッピング情報クラスで、 {@link WT_KouteiLock} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_KouteiLock}</td><td colspan="3">工程ロック情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getLockTime lockTime}</td><td>ロック時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLockKey lockKey}</td><td>ロックキー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKey gyoumuKey}</td><td>業務キー</td><td align="center">{@link PKWT_KouteiLock ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">{@link PKWT_KouteiLock ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNodeNm nodeNm}</td><td>ノード名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_KouteiLock
 * @see     PKWT_KouteiLock
 * @see     QWT_KouteiLock
 * @see     GenQWT_KouteiLock
 */
@MappedSuperclass
@Table(name=GenWT_KouteiLock.TABLE_NAME)
@IdClass(value=PKWT_KouteiLock.class)
public abstract class GenWT_KouteiLock extends AbstractExDBEntity<WT_KouteiLock, PKWT_KouteiLock> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_KouteiLock";
    public static final String LOCKTIME                 = "lockTime";
    public static final String LOCKKEY                  = "lockKey";
    public static final String GYOUMUKEY                = "gyoumuKey";
    public static final String FLOWID                   = "flowId";
    public static final String USERID                   = "userId";
    public static final String NODENM                   = "nodeNm";

    private final PKWT_KouteiLock primaryKey;

    public GenWT_KouteiLock() {
        primaryKey = new PKWT_KouteiLock();
    }

    public GenWT_KouteiLock(String pFlowId, String pGyoumuKey) {
        primaryKey = new PKWT_KouteiLock(pFlowId, pGyoumuKey);
    }

    @Transient
    @Override
    public PKWT_KouteiLock getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_KouteiLock> getMetaClass() {
        return QWT_KouteiLock.class;
    }

    private String lockTime;

    @Column(name=GenWT_KouteiLock.LOCKTIME)
    public String getLockTime() {
        return lockTime;
    }

    public void setLockTime(String pLockTime) {
        lockTime = pLockTime;
    }

    private String lockKey;

    @Column(name=GenWT_KouteiLock.LOCKKEY)
    public String getLockKey() {
        return lockKey;
    }

    public void setLockKey(String pLockKey) {
        lockKey = pLockKey;
    }

    @Id
    @Column(name=GenWT_KouteiLock.GYOUMUKEY)
    public String getGyoumuKey() {
        return getPrimaryKey().getGyoumuKey();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setGyoumuKey(String pGyoumuKey) {
        getPrimaryKey().setGyoumuKey(pGyoumuKey);
    }

    @Id
    @Column(name=GenWT_KouteiLock.FLOWID)
    public String getFlowId() {
        return getPrimaryKey().getFlowId();
    }

    public void setFlowId(String pFlowId) {
        getPrimaryKey().setFlowId(pFlowId);
    }

    private String userId;

    @Column(name=GenWT_KouteiLock.USERID)
    @MaxLength(max=30)
    @AlphaDigit
    public String getUserId() {
        return userId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    private String nodeNm;

    @Column(name=GenWT_KouteiLock.NODENM)
    public String getNodeNm() {
        return nodeNm;
    }

    public void setNodeNm(String pNodeNm) {
        nodeNm = pNodeNm;
    }
}