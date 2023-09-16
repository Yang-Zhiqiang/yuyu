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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.db.id.PKWT_KouteiRireki;
import yuyu.def.db.meta.GenQWT_KouteiRireki;
import yuyu.def.db.meta.QWT_KouteiRireki;
import yuyu.def.db.type.UserType_C_IwfSyoriKbn;
import yuyu.def.db.type.UserType_C_RirekiKbn;

/**
 * 工程履歴テーブル テーブルのマッピング情報クラスで、 {@link WT_KouteiRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_KouteiRireki}</td><td colspan="3">工程履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTokenId tokenId}</td><td>トークンＩＤ</td><td align="center">{@link PKWT_KouteiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKey gyoumuKey}</td><td>業務キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRirekiKbn rirekiKbn}</td><td>履歴区分</td><td align="center">{@link PKWT_KouteiRireki ○}</td><td align="center">V</td><td>{@link C_RirekiKbn}</td></tr>
 *  <tr><td>{@link #getSyoriTime syoriTime}</td><td>処理時間</td><td align="center">{@link PKWT_KouteiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNodeId nodeId}</td><td>ノードＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNodeNm nodeNm}</td><td>ノード名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIwfSyoriKbn iwfSyoriKbn}</td><td>IWF処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IwfSyoriKbn}</td></tr>
 *  <tr><td>{@link #getRrkMsg rrkMsg}</td><td>履歴メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtInfo extInfo}</td><td>付加情報</td><td align="center">&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 * </table>
 * @see     WT_KouteiRireki
 * @see     PKWT_KouteiRireki
 * @see     QWT_KouteiRireki
 * @see     GenQWT_KouteiRireki
 */
@MappedSuperclass
@Table(name=GenWT_KouteiRireki.TABLE_NAME)
@IdClass(value=PKWT_KouteiRireki.class)
@TypeDefs({
    @TypeDef(name="UserType_C_IwfSyoriKbn", typeClass=UserType_C_IwfSyoriKbn.class),
    @TypeDef(name="UserType_C_RirekiKbn", typeClass=UserType_C_RirekiKbn.class)
})
public abstract class GenWT_KouteiRireki extends AbstractExDBEntity<WT_KouteiRireki, PKWT_KouteiRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_KouteiRireki";
    public static final String TOKENID                  = "tokenId";
    public static final String GYOUMUKEY                = "gyoumuKey";
    public static final String RIREKIKBN                = "rirekiKbn";
    public static final String SYORITIME                = "syoriTime";
    public static final String FLOWID                   = "flowId";
    public static final String NODEID                   = "nodeId";
    public static final String NODENM                   = "nodeNm";
    public static final String USERID                   = "userId";
    public static final String IWFSYORIKBN              = "iwfSyoriKbn";
    public static final String RRKMSG                   = "rrkMsg";
    public static final String EXTINFO                  = "extInfo";

    private final PKWT_KouteiRireki primaryKey;

    public GenWT_KouteiRireki() {
        primaryKey = new PKWT_KouteiRireki();
    }

    public GenWT_KouteiRireki(
        String pTokenId,
        C_RirekiKbn pRirekiKbn,
        String pSyoriTime
    ) {
        primaryKey = new PKWT_KouteiRireki(
            pTokenId,
            pRirekiKbn,
            pSyoriTime
        );
    }

    @Transient
    @Override
    public PKWT_KouteiRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_KouteiRireki> getMetaClass() {
        return QWT_KouteiRireki.class;
    }

    @Id
    @Column(name=GenWT_KouteiRireki.TOKENID)
    public String getTokenId() {
        return getPrimaryKey().getTokenId();
    }

    public void setTokenId(String pTokenId) {
        getPrimaryKey().setTokenId(pTokenId);
    }

    private String gyoumuKey;

    @Column(name=GenWT_KouteiRireki.GYOUMUKEY)
    public String getGyoumuKey() {
        return gyoumuKey;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setGyoumuKey(String pGyoumuKey) {
        gyoumuKey = pGyoumuKey;
    }

    @Id
    @Type(type="UserType_C_RirekiKbn")
    @Column(name=GenWT_KouteiRireki.RIREKIKBN)
    public C_RirekiKbn getRirekiKbn() {
        return getPrimaryKey().getRirekiKbn();
    }

    public void setRirekiKbn(C_RirekiKbn pRirekiKbn) {
        getPrimaryKey().setRirekiKbn(pRirekiKbn);
    }

    @Id
    @Column(name=GenWT_KouteiRireki.SYORITIME)
    public String getSyoriTime() {
        return getPrimaryKey().getSyoriTime();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriTime(String pSyoriTime) {
        getPrimaryKey().setSyoriTime(pSyoriTime);
    }

    private String flowId;

    @Column(name=GenWT_KouteiRireki.FLOWID)
    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String pFlowId) {
        flowId = pFlowId;
    }

    private String nodeId;

    @Column(name=GenWT_KouteiRireki.NODEID)
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String pNodeId) {
        nodeId = pNodeId;
    }

    private String nodeNm;

    @Column(name=GenWT_KouteiRireki.NODENM)
    public String getNodeNm() {
        return nodeNm;
    }

    public void setNodeNm(String pNodeNm) {
        nodeNm = pNodeNm;
    }

    private String userId;

    @Column(name=GenWT_KouteiRireki.USERID)
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

    private C_IwfSyoriKbn iwfSyoriKbn;

    @Type(type="UserType_C_IwfSyoriKbn")
    @Column(name=GenWT_KouteiRireki.IWFSYORIKBN)
    public C_IwfSyoriKbn getIwfSyoriKbn() {
        return iwfSyoriKbn;
    }

    public void setIwfSyoriKbn(C_IwfSyoriKbn pIwfSyoriKbn) {
        iwfSyoriKbn = pIwfSyoriKbn;
    }

    private String rrkMsg;

    @Column(name=GenWT_KouteiRireki.RRKMSG)
    public String getRrkMsg() {
        return rrkMsg;
    }

    public void setRrkMsg(String pRrkMsg) {
        rrkMsg = pRrkMsg;
    }

    private byte[] extInfo;

    @Column(name=GenWT_KouteiRireki.EXTINFO)
    public byte[] getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(byte[] pExtInfo) {
        extInfo = pExtInfo;
    }
}