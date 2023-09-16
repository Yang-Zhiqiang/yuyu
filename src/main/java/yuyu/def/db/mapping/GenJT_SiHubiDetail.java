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
import yuyu.def.db.entity.JT_SiHubiDetail;
import yuyu.def.db.id.PKJT_SiHubiDetail;
import yuyu.def.db.meta.GenQJT_SiHubiDetail;
import yuyu.def.db.meta.QJT_SiHubiDetail;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 支払不備詳細テーブル テーブルのマッピング情報クラスで、 {@link JT_SiHubiDetail} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiHubiDetail}</td><td colspan="3">支払不備詳細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHubisikibetukey hubisikibetukey}</td><td>不備識別キー</td><td align="center">{@link PKJT_SiHubiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKJT_SiHubiDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHubisyoruicd hubisyoruicd}</td><td>不備書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHubisyoruinm hubisyoruinm}</td><td>不備書類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubinaiyoucd hubinaiyoucd}</td><td>不備内容コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubinaiyoumsg hubinaiyoumsg}</td><td>不備内容メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGenponhnkykumu genponhnkykumu}</td><td>原本返却有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTrkymd trkymd}</td><td>登録日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHasinymd hasinymd}</td><td>発信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKaisyouymd kaisyouymd}</td><td>解消日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHassinsakikbn hassinsakikbn}</td><td>発信先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassinsakiKbn}</td></tr>
 *  <tr><td>{@link #getHubitourokuktntid hubitourokuktntid}</td><td>不備登録担当者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubisyouninktntid hubisyouninktntid}</td><td>不備承認担当者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiHubiDetail
 * @see     PKJT_SiHubiDetail
 * @see     QJT_SiHubiDetail
 * @see     GenQJT_SiHubiDetail
 */
@MappedSuperclass
@Table(name=GenJT_SiHubiDetail.TABLE_NAME)
@IdClass(value=PKJT_SiHubiDetail.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassinsakiKbn", typeClass=UserType_C_HassinsakiKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_SiHubiDetail extends AbstractExDBEntity<JT_SiHubiDetail, PKJT_SiHubiDetail> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiHubiDetail";
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
    public static final String HUBITOUROKUKTNTID        = "hubitourokuktntid";
    public static final String HUBISYOUNINKTNTID        = "hubisyouninktntid";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiHubiDetail primaryKey;

    public GenJT_SiHubiDetail() {
        primaryKey = new PKJT_SiHubiDetail();
    }

    public GenJT_SiHubiDetail(String pHubisikibetukey, Integer pRenno3keta) {
        primaryKey = new PKJT_SiHubiDetail(pHubisikibetukey, pRenno3keta);
    }

    @Transient
    @Override
    public PKJT_SiHubiDetail getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiHubiDetail> getMetaClass() {
        return QJT_SiHubiDetail.class;
    }

    @Id
    @Column(name=GenJT_SiHubiDetail.HUBISIKIBETUKEY)
    public String getHubisikibetukey() {
        return getPrimaryKey().getHubisikibetukey();
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        getPrimaryKey().setHubisikibetukey(pHubisikibetukey);
    }

    @Id
    @Column(name=GenJT_SiHubiDetail.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private C_SyoruiCdKbn hubisyoruicd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenJT_SiHubiDetail.HUBISYORUICD)
    public C_SyoruiCdKbn getHubisyoruicd() {
        return hubisyoruicd;
    }

    public void setHubisyoruicd(C_SyoruiCdKbn pHubisyoruicd) {
        hubisyoruicd = pHubisyoruicd;
    }

    private String hubisyoruinm;

    @Column(name=GenJT_SiHubiDetail.HUBISYORUINM)
    public String getHubisyoruinm() {
        return hubisyoruinm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHubisyoruinm(String pHubisyoruinm) {
        hubisyoruinm = pHubisyoruinm;
    }

    private String hubinaiyoucd;

    @Column(name=GenJT_SiHubiDetail.HUBINAIYOUCD)
    public String getHubinaiyoucd() {
        return hubinaiyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubinaiyoucd(String pHubinaiyoucd) {
        hubinaiyoucd = pHubinaiyoucd;
    }

    private String hubinaiyoumsg;

    @Column(name=GenJT_SiHubiDetail.HUBINAIYOUMSG)
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
    @Column(name=GenJT_SiHubiDetail.GENPONHNKYKUMU)
    public C_UmuKbn getGenponhnkykumu() {
        return genponhnkykumu;
    }

    public void setGenponhnkykumu(C_UmuKbn pGenponhnkykumu) {
        genponhnkykumu = pGenponhnkykumu;
    }

    private BizDate trkymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiHubiDetail.TRKYMD)
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
    @Column(name=GenJT_SiHubiDetail.HASINYMD)
    public BizDate getHasinymd() {
        return hasinymd;
    }

    @Trim("both")
    public void setHasinymd(BizDate pHasinymd) {
        hasinymd = pHasinymd;
    }

    private BizDate kaisyouymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiHubiDetail.KAISYOUYMD)
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
    @Column(name=GenJT_SiHubiDetail.HASSINSAKIKBN)
    public C_HassinsakiKbn getHassinsakikbn() {
        return hassinsakikbn;
    }

    public void setHassinsakikbn(C_HassinsakiKbn pHassinsakikbn) {
        hassinsakikbn = pHassinsakikbn;
    }

    private String hubitourokuktntid;

    @Column(name=GenJT_SiHubiDetail.HUBITOUROKUKTNTID)
    public String getHubitourokuktntid() {
        return hubitourokuktntid;
    }

    public void setHubitourokuktntid(String pHubitourokuktntid) {
        hubitourokuktntid = pHubitourokuktntid;
    }

    private String hubisyouninktntid;

    @Column(name=GenJT_SiHubiDetail.HUBISYOUNINKTNTID)
    public String getHubisyouninktntid() {
        return hubisyouninktntid;
    }

    public void setHubisyouninktntid(String pHubisyouninktntid) {
        hubisyouninktntid = pHubisyouninktntid;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiHubiDetail.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiHubiDetail.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}