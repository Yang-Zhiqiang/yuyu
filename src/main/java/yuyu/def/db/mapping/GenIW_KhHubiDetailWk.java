package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IW_KhHubiDetailWk;
import yuyu.def.db.id.PKIW_KhHubiDetailWk;
import yuyu.def.db.meta.GenQIW_KhHubiDetailWk;
import yuyu.def.db.meta.QIW_KhHubiDetailWk;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 契約保全不備詳細ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhHubiDetailWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhHubiDetailWk}</td><td colspan="3">契約保全不備詳細ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhHubiDetailWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKIW_KhHubiDetailWk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHubisyoruicd hubisyoruicd}</td><td>不備書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHubisyoruinm hubisyoruinm}</td><td>不備書類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubinaiyoucd hubinaiyoucd}</td><td>不備内容コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubinaiyoumsg hubinaiyoumsg}</td><td>不備内容メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGenponhnkykumu genponhnkykumu}</td><td>原本返却有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHassinsakikbn hassinsakikbn}</td><td>発信先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassinsakiKbn}</td></tr>
 *  <tr><td>{@link #getHubitourokuktntid hubitourokuktntid}</td><td>不備登録担当者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkymd trkymd}</td><td>登録日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     IW_KhHubiDetailWk
 * @see     PKIW_KhHubiDetailWk
 * @see     QIW_KhHubiDetailWk
 * @see     GenQIW_KhHubiDetailWk
 */
@MappedSuperclass
@Table(name=GenIW_KhHubiDetailWk.TABLE_NAME)
@IdClass(value=PKIW_KhHubiDetailWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassinsakiKbn", typeClass=UserType_C_HassinsakiKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIW_KhHubiDetailWk extends AbstractExDBEntity<IW_KhHubiDetailWk, PKIW_KhHubiDetailWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhHubiDetailWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String HUBISYORUICD             = "hubisyoruicd";
    public static final String HUBISYORUINM             = "hubisyoruinm";
    public static final String HUBINAIYOUCD             = "hubinaiyoucd";
    public static final String HUBINAIYOUMSG            = "hubinaiyoumsg";
    public static final String GENPONHNKYKUMU           = "genponhnkykumu";
    public static final String HASSINSAKIKBN            = "hassinsakikbn";
    public static final String HUBITOUROKUKTNTID        = "hubitourokuktntid";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String TRKYMD                   = "trkymd";

    private final PKIW_KhHubiDetailWk primaryKey;

    public GenIW_KhHubiDetailWk() {
        primaryKey = new PKIW_KhHubiDetailWk();
    }

    public GenIW_KhHubiDetailWk(String pKouteikanriid, Integer pRenno3keta) {
        primaryKey = new PKIW_KhHubiDetailWk(pKouteikanriid, pRenno3keta);
    }

    @Transient
    @Override
    public PKIW_KhHubiDetailWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhHubiDetailWk> getMetaClass() {
        return QIW_KhHubiDetailWk.class;
    }

    @Id
    @Column(name=GenIW_KhHubiDetailWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    @Id
    @Column(name=GenIW_KhHubiDetailWk.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private C_SyoruiCdKbn hubisyoruicd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIW_KhHubiDetailWk.HUBISYORUICD)
    public C_SyoruiCdKbn getHubisyoruicd() {
        return hubisyoruicd;
    }

    public void setHubisyoruicd(C_SyoruiCdKbn pHubisyoruicd) {
        hubisyoruicd = pHubisyoruicd;
    }

    private String hubisyoruinm;

    @Column(name=GenIW_KhHubiDetailWk.HUBISYORUINM)
    public String getHubisyoruinm() {
        return hubisyoruinm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHubisyoruinm(String pHubisyoruinm) {
        hubisyoruinm = pHubisyoruinm;
    }

    private String hubinaiyoucd;

    @Column(name=GenIW_KhHubiDetailWk.HUBINAIYOUCD)
    public String getHubinaiyoucd() {
        return hubinaiyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubinaiyoucd(String pHubinaiyoucd) {
        hubinaiyoucd = pHubinaiyoucd;
    }

    private String hubinaiyoumsg;

    @Column(name=GenIW_KhHubiDetailWk.HUBINAIYOUMSG)
    @ValidTextArea(length=30, rows=5)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getHubinaiyoumsg() {
        return hubinaiyoumsg;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHubinaiyoumsg(String pHubinaiyoumsg) {
        hubinaiyoumsg = pHubinaiyoumsg;
    }

    private C_UmuKbn genponhnkykumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIW_KhHubiDetailWk.GENPONHNKYKUMU)
    public C_UmuKbn getGenponhnkykumu() {
        return genponhnkykumu;
    }

    public void setGenponhnkykumu(C_UmuKbn pGenponhnkykumu) {
        genponhnkykumu = pGenponhnkykumu;
    }

    private C_HassinsakiKbn hassinsakikbn;

    @Type(type="UserType_C_HassinsakiKbn")
    @Column(name=GenIW_KhHubiDetailWk.HASSINSAKIKBN)
    public C_HassinsakiKbn getHassinsakikbn() {
        return hassinsakikbn;
    }

    public void setHassinsakikbn(C_HassinsakiKbn pHassinsakikbn) {
        hassinsakikbn = pHassinsakikbn;
    }

    private String hubitourokuktntid;

    @Column(name=GenIW_KhHubiDetailWk.HUBITOUROKUKTNTID)
    public String getHubitourokuktntid() {
        return hubitourokuktntid;
    }

    public void setHubitourokuktntid(String pHubitourokuktntid) {
        hubitourokuktntid = pHubitourokuktntid;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhHubiDetailWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhHubiDetailWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhHubiDetailWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizDate trkymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhHubiDetailWk.TRKYMD)
    @ValidDate
    public BizDate getTrkymd() {
        return trkymd;
    }

    @Trim("both")
    public void setTrkymd(BizDate pTrkymd) {
        trkymd = pTrkymd;
    }
}