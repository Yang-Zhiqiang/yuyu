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
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.id.PKBT_WariateHukaInfo;
import yuyu.def.db.meta.GenQBT_WariateHukaInfo;
import yuyu.def.db.meta.QBT_WariateHukaInfo;

/**
 * 割当不可情報テーブル テーブルのマッピング情報クラスで、 {@link BT_WariateHukaInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_WariateHukaInfo}</td><td colspan="3">割当不可情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKBT_WariateHukaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">{@link PKBT_WariateHukaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">{@link PKBT_WariateHukaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWrthukatskid wrthukatskid}</td><td>割当不可タスクID</td><td align="center">{@link PKBT_WariateHukaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">{@link PKBT_WariateHukaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWrthukakaijyotskid wrthukakaijyotskid}</td><td>割当不可解除用タスクID</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_WariateHukaInfo
 * @see     PKBT_WariateHukaInfo
 * @see     QBT_WariateHukaInfo
 * @see     GenQBT_WariateHukaInfo
 */
@MappedSuperclass
@Table(name=GenBT_WariateHukaInfo.TABLE_NAME)
@IdClass(value=PKBT_WariateHukaInfo.class)
public abstract class GenBT_WariateHukaInfo extends AbstractExDBEntity<BT_WariateHukaInfo, PKBT_WariateHukaInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_WariateHukaInfo";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String WRTHUKATSKID             = "wrthukatskid";
    public static final String USERID                   = "userId";
    public static final String WRTHUKAKAIJYOTSKID       = "wrthukakaijyotskid";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_WariateHukaInfo primaryKey;

    public GenBT_WariateHukaInfo() {
        primaryKey = new PKBT_WariateHukaInfo();
    }

    public GenBT_WariateHukaInfo(
        String pKouteikanriid,
        String pSubSystemId,
        String pJimutetuzukicd,
        String pWrthukatskid,
        String pUserId
    ) {
        primaryKey = new PKBT_WariateHukaInfo(
            pKouteikanriid,
            pSubSystemId,
            pJimutetuzukicd,
            pWrthukatskid,
            pUserId
        );
    }

    @Transient
    @Override
    public PKBT_WariateHukaInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_WariateHukaInfo> getMetaClass() {
        return QBT_WariateHukaInfo.class;
    }

    @Id
    @Column(name=GenBT_WariateHukaInfo.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    @Id
    @Column(name=GenBT_WariateHukaInfo.SUBSYSTEMID)
    public String getSubSystemId() {
        return getPrimaryKey().getSubSystemId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        getPrimaryKey().setSubSystemId(pSubSystemId);
    }

    @Id
    @Column(name=GenBT_WariateHukaInfo.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return getPrimaryKey().getJimutetuzukicd();
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        getPrimaryKey().setJimutetuzukicd(pJimutetuzukicd);
    }

    @Id
    @Column(name=GenBT_WariateHukaInfo.WRTHUKATSKID)
    public String getWrthukatskid() {
        return getPrimaryKey().getWrthukatskid();
    }

    public void setWrthukatskid(String pWrthukatskid) {
        getPrimaryKey().setWrthukatskid(pWrthukatskid);
    }

    @Id
    @Column(name=GenBT_WariateHukaInfo.USERID)
    @MaxLength(max=30)
    @AlphaDigit
    public String getUserId() {
        return getPrimaryKey().getUserId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        getPrimaryKey().setUserId(pUserId);
    }

    private String wrthukakaijyotskid;

    @Column(name=GenBT_WariateHukaInfo.WRTHUKAKAIJYOTSKID)
    public String getWrthukakaijyotskid() {
        return wrthukakaijyotskid;
    }

    public void setWrthukakaijyotskid(String pWrthukakaijyotskid) {
        wrthukakaijyotskid = pWrthukakaijyotskid;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_WariateHukaInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_WariateHukaInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_WariateHukaInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}