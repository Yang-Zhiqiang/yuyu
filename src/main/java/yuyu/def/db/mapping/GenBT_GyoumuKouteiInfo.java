package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.id.PKBT_GyoumuKouteiInfo;
import yuyu.def.db.meta.GenQBT_GyoumuKouteiInfo;
import yuyu.def.db.meta.QBT_GyoumuKouteiInfo;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 業務用工程情報テーブル テーブルのマッピング情報クラスで、 {@link BT_GyoumuKouteiInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_GyoumuKouteiInfo}</td><td colspan="3">業務用工程情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKBT_GyoumuKouteiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNksysyno nksysyno}</td><td>年金証書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukouteikanriid syukouteikanriid}</td><td>主工程管理ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukouteijimutetuzukicd syukouteijimutetuzukicd}</td><td>主工程事務手続コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_GyoumuKouteiInfo
 * @see     PKBT_GyoumuKouteiInfo
 * @see     QBT_GyoumuKouteiInfo
 * @see     GenQBT_GyoumuKouteiInfo
 */
@MappedSuperclass
@Table(name=GenBT_GyoumuKouteiInfo.TABLE_NAME)
@IdClass(value=PKBT_GyoumuKouteiInfo.class)
public abstract class GenBT_GyoumuKouteiInfo extends AbstractExDBEntity<BT_GyoumuKouteiInfo, PKBT_GyoumuKouteiInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_GyoumuKouteiInfo";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String MOSNO                    = "mosno";
    public static final String SYONO                    = "syono";
    public static final String SKNO                     = "skno";
    public static final String NKSYSYNO                 = "nksysyno";
    public static final String SYUKOUTEIKANRIID         = "syukouteikanriid";
    public static final String SYUKOUTEIJIMUTETUZUKICD  = "syukouteijimutetuzukicd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_GyoumuKouteiInfo primaryKey;

    public GenBT_GyoumuKouteiInfo() {
        primaryKey = new PKBT_GyoumuKouteiInfo();
    }

    public GenBT_GyoumuKouteiInfo(String pKouteikanriid) {
        primaryKey = new PKBT_GyoumuKouteiInfo(pKouteikanriid);
    }

    @Transient
    @Override
    public PKBT_GyoumuKouteiInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_GyoumuKouteiInfo> getMetaClass() {
        return QBT_GyoumuKouteiInfo.class;
    }

    @Id
    @Column(name=GenBT_GyoumuKouteiInfo.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String subSystemId;

    @Column(name=GenBT_GyoumuKouteiInfo.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private String jimutetuzukicd;

    @Column(name=GenBT_GyoumuKouteiInfo.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }

    private String mosno;

    @Column(name=GenBT_GyoumuKouteiInfo.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private String syono;

    @Column(name=GenBT_GyoumuKouteiInfo.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String skno;

    @Column(name=GenBT_GyoumuKouteiInfo.SKNO)
    public String getSkno() {
        return skno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    private String nksysyno;

    @Column(name=GenBT_GyoumuKouteiInfo.NKSYSYNO)
    @NenkinSyousyoNo
    public String getNksysyno() {
        return nksysyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }

    private String syukouteikanriid;

    @Column(name=GenBT_GyoumuKouteiInfo.SYUKOUTEIKANRIID)
    public String getSyukouteikanriid() {
        return syukouteikanriid;
    }

    public void setSyukouteikanriid(String pSyukouteikanriid) {
        syukouteikanriid = pSyukouteikanriid;
    }

    private String syukouteijimutetuzukicd;

    @Column(name=GenBT_GyoumuKouteiInfo.SYUKOUTEIJIMUTETUZUKICD)
    public String getSyukouteijimutetuzukicd() {
        return syukouteijimutetuzukicd;
    }

    public void setSyukouteijimutetuzukicd(String pSyukouteijimutetuzukicd) {
        syukouteijimutetuzukicd = pSyukouteijimutetuzukicd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_GyoumuKouteiInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_GyoumuKouteiInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_GyoumuKouteiInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}