package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.id.PKWT_GyoumuKey;
import yuyu.def.db.meta.GenQWT_GyoumuKey;
import yuyu.def.db.meta.QWT_GyoumuKey;

/**
 * 業務キーテーブル テーブルのマッピング情報クラスで、 {@link WT_GyoumuKey} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_GyoumuKey}</td><td colspan="3">業務キーテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">{@link PKWT_GyoumuKey ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKey gyoumuKey}</td><td>業務キー</td><td align="center">{@link PKWT_GyoumuKey ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTokenId tokenId}</td><td>トークンＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreateTime createTime}</td><td>作成日時</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_GyoumuKey
 * @see     PKWT_GyoumuKey
 * @see     QWT_GyoumuKey
 * @see     GenQWT_GyoumuKey
 */
@MappedSuperclass
@Table(name=GenWT_GyoumuKey.TABLE_NAME)
@IdClass(value=PKWT_GyoumuKey.class)
public abstract class GenWT_GyoumuKey extends AbstractExDBEntity<WT_GyoumuKey, PKWT_GyoumuKey> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_GyoumuKey";
    public static final String FLOWID                   = "flowId";
    public static final String GYOUMUKEY                = "gyoumuKey";
    public static final String TOKENID                  = "tokenId";
    public static final String CREATETIME               = "createTime";

    private final PKWT_GyoumuKey primaryKey;

    public GenWT_GyoumuKey() {
        primaryKey = new PKWT_GyoumuKey();
    }

    public GenWT_GyoumuKey(String pFlowId, String pGyoumuKey) {
        primaryKey = new PKWT_GyoumuKey(pFlowId, pGyoumuKey);
    }

    @Transient
    @Override
    public PKWT_GyoumuKey getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_GyoumuKey> getMetaClass() {
        return QWT_GyoumuKey.class;
    }

    @Id
    @Column(name=GenWT_GyoumuKey.FLOWID)
    public String getFlowId() {
        return getPrimaryKey().getFlowId();
    }

    public void setFlowId(String pFlowId) {
        getPrimaryKey().setFlowId(pFlowId);
    }

    @Id
    @Column(name=GenWT_GyoumuKey.GYOUMUKEY)
    public String getGyoumuKey() {
        return getPrimaryKey().getGyoumuKey();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setGyoumuKey(String pGyoumuKey) {
        getPrimaryKey().setGyoumuKey(pGyoumuKey);
    }

    private String tokenId;

    @Column(name=GenWT_GyoumuKey.TOKENID)
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String pTokenId) {
        tokenId = pTokenId;
    }

    private String createTime;

    @Column(name=GenWT_GyoumuKey.CREATETIME)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String pCreateTime) {
        createTime = pCreateTime;
    }
}