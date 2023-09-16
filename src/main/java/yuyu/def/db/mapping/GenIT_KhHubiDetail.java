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
import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHubiDetail;
import yuyu.def.db.id.PKIT_KhHubiDetail;
import yuyu.def.db.meta.GenQIT_KhHubiDetail;
import yuyu.def.db.meta.QIT_KhHubiDetail;
import yuyu.def.db.type.UserType_C_HasinkyokaKbn;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 契約保全不備詳細テーブル テーブルのマッピング情報クラスで、 {@link IT_KhHubiDetail} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHubiDetail}</td><td colspan="3">契約保全不備詳細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHubisikibetukey hubisikibetukey}</td><td>不備識別キー</td><td align="center">{@link PKIT_KhHubiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKIT_KhHubiDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHubisyoruicd hubisyoruicd}</td><td>不備書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHubisyoruinm hubisyoruinm}</td><td>不備書類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubinaiyoucd hubinaiyoucd}</td><td>不備内容コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubinaiyoumsg hubinaiyoumsg}</td><td>不備内容メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGenponhnkykumu genponhnkykumu}</td><td>原本返却有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTrkymd trkymd}</td><td>登録日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHasinymd hasinymd}</td><td>発信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKaisyouymd kaisyouymd}</td><td>解消日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHassinsakikbn hassinsakikbn}</td><td>発信先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassinsakiKbn}</td></tr>
 *  <tr><td>{@link #getHasinkyokakbn hasinkyokakbn}</td><td>発信許可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HasinkyokaKbn}</td></tr>
 *  <tr><td>{@link #getHubitourokuktntid hubitourokuktntid}</td><td>不備登録担当者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubisyouninktntid hubisyouninktntid}</td><td>不備承認担当者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhHubiDetail
 * @see     PKIT_KhHubiDetail
 * @see     QIT_KhHubiDetail
 * @see     GenQIT_KhHubiDetail
 */
@MappedSuperclass
@Table(name=GenIT_KhHubiDetail.TABLE_NAME)
@IdClass(value=PKIT_KhHubiDetail.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HasinkyokaKbn", typeClass=UserType_C_HasinkyokaKbn.class),
    @TypeDef(name="UserType_C_HassinsakiKbn", typeClass=UserType_C_HassinsakiKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_KhHubiDetail extends AbstractExDBEntity<IT_KhHubiDetail, PKIT_KhHubiDetail> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhHubiDetail";
    public static final String HUBISIKIBETUKEY          = "hubisikibetukey";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String HUBISYORUICD             = "hubisyoruicd";
    public static final String HUBISYORUINM             = "hubisyoruinm";
    public static final String HUBINAIYOUCD             = "hubinaiyoucd";
    public static final String HUBINAIYOUMSG            = "hubinaiyoumsg";
    public static final String GENPONHNKYKUMU           = "genponhnkykumu";
    public static final String TRKYMD                   = "trkymd";
    public static final String HASINYMD                 = "hasinymd";
    public static final String KAISYOUYMD               = "kaisyouymd";
    public static final String HASSINSAKIKBN            = "hassinsakikbn";
    public static final String HASINKYOKAKBN            = "hasinkyokakbn";
    public static final String HUBITOUROKUKTNTID        = "hubitourokuktntid";
    public static final String HUBISYOUNINKTNTID        = "hubisyouninktntid";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhHubiDetail primaryKey;

    public GenIT_KhHubiDetail() {
        primaryKey = new PKIT_KhHubiDetail();
    }

    public GenIT_KhHubiDetail(String pHubisikibetukey, Integer pRenno3keta) {
        primaryKey = new PKIT_KhHubiDetail(pHubisikibetukey, pRenno3keta);
    }

    @Transient
    @Override
    public PKIT_KhHubiDetail getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhHubiDetail> getMetaClass() {
        return QIT_KhHubiDetail.class;
    }

    @Id
    @Column(name=GenIT_KhHubiDetail.HUBISIKIBETUKEY)
    public String getHubisikibetukey() {
        return getPrimaryKey().getHubisikibetukey();
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        getPrimaryKey().setHubisikibetukey(pHubisikibetukey);
    }

    @Id
    @Column(name=GenIT_KhHubiDetail.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private C_SyoruiCdKbn hubisyoruicd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_KhHubiDetail.HUBISYORUICD)
    public C_SyoruiCdKbn getHubisyoruicd() {
        return hubisyoruicd;
    }

    public void setHubisyoruicd(C_SyoruiCdKbn pHubisyoruicd) {
        hubisyoruicd = pHubisyoruicd;
    }

    private String hubisyoruinm;

    @Column(name=GenIT_KhHubiDetail.HUBISYORUINM)
    public String getHubisyoruinm() {
        return hubisyoruinm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHubisyoruinm(String pHubisyoruinm) {
        hubisyoruinm = pHubisyoruinm;
    }

    private String hubinaiyoucd;

    @Column(name=GenIT_KhHubiDetail.HUBINAIYOUCD)
    public String getHubinaiyoucd() {
        return hubinaiyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubinaiyoucd(String pHubinaiyoucd) {
        hubinaiyoucd = pHubinaiyoucd;
    }

    private String hubinaiyoumsg;

    @Column(name=GenIT_KhHubiDetail.HUBINAIYOUMSG)
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
    @Column(name=GenIT_KhHubiDetail.GENPONHNKYKUMU)
    public C_UmuKbn getGenponhnkykumu() {
        return genponhnkykumu;
    }

    public void setGenponhnkykumu(C_UmuKbn pGenponhnkykumu) {
        genponhnkykumu = pGenponhnkykumu;
    }

    private BizDate trkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHubiDetail.TRKYMD)
    @ValidDate
    public BizDate getTrkymd() {
        return trkymd;
    }

    @Trim("both")
    public void setTrkymd(BizDate pTrkymd) {
        trkymd = pTrkymd;
    }

    private BizDate hasinymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHubiDetail.HASINYMD)
    public BizDate getHasinymd() {
        return hasinymd;
    }

    @Trim("both")
    public void setHasinymd(BizDate pHasinymd) {
        hasinymd = pHasinymd;
    }

    private BizDate kaisyouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHubiDetail.KAISYOUYMD)
    @ValidDate
    public BizDate getKaisyouymd() {
        return kaisyouymd;
    }

    @Trim("both")
    public void setKaisyouymd(BizDate pKaisyouymd) {
        kaisyouymd = pKaisyouymd;
    }

    private C_HassinsakiKbn hassinsakikbn;

    @Type(type="UserType_C_HassinsakiKbn")
    @Column(name=GenIT_KhHubiDetail.HASSINSAKIKBN)
    public C_HassinsakiKbn getHassinsakikbn() {
        return hassinsakikbn;
    }

    public void setHassinsakikbn(C_HassinsakiKbn pHassinsakikbn) {
        hassinsakikbn = pHassinsakikbn;
    }

    private C_HasinkyokaKbn hasinkyokakbn;

    @Type(type="UserType_C_HasinkyokaKbn")
    @Column(name=GenIT_KhHubiDetail.HASINKYOKAKBN)
    public C_HasinkyokaKbn getHasinkyokakbn() {
        return hasinkyokakbn;
    }

    public void setHasinkyokakbn(C_HasinkyokaKbn pHasinkyokakbn) {
        hasinkyokakbn = pHasinkyokakbn;
    }

    private String hubitourokuktntid;

    @Column(name=GenIT_KhHubiDetail.HUBITOUROKUKTNTID)
    public String getHubitourokuktntid() {
        return hubitourokuktntid;
    }

    public void setHubitourokuktntid(String pHubitourokuktntid) {
        hubitourokuktntid = pHubitourokuktntid;
    }

    private String hubisyouninktntid;

    @Column(name=GenIT_KhHubiDetail.HUBISYOUNINKTNTID)
    public String getHubisyouninktntid() {
        return hubisyouninktntid;
    }

    public void setHubisyouninktntid(String pHubisyouninktntid) {
        hubisyouninktntid = pHubisyouninktntid;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhHubiDetail.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhHubiDetail.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}