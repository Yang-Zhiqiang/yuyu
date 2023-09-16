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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.id.PKHT_SkHubiDetail;
import yuyu.def.db.meta.GenQHT_SkHubiDetail;
import yuyu.def.db.meta.QHT_SkHubiDetail;
import yuyu.def.db.type.UserType_C_HasinkyokaKbn;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約不備詳細テーブル テーブルのマッピング情報クラスで、 {@link HT_SkHubiDetail} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkHubiDetail}</td><td colspan="3">新契約不備詳細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SkHubiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubisikibetukey hubisikibetukey}</td><td>不備識別キー</td><td align="center">{@link PKHT_SkHubiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKHT_SkHubiDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getSkhubikoumokucd skhubikoumokucd}</td><td>新契約不備項目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkhubinaiyoucd skhubinaiyoucd}</td><td>新契約不備内容コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkseibisijinaiyoucd skseibisijinaiyoucd}</td><td>新契約整備指示内容コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyoubunflg tyoubunflg}</td><td>長文フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSkrenrakujikou skrenrakujikou}</td><td>新契約連絡事項</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkymd trkymd}</td><td>登録日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHasinymd hasinymd}</td><td>発信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKaisyouymd kaisyouymd}</td><td>解消日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHassinsakikbn hassinsakikbn}</td><td>発信先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassinsakiKbn}</td></tr>
 *  <tr><td>{@link #getHasinkyokakbn hasinkyokakbn}</td><td>発信許可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HasinkyokaKbn}</td></tr>
 *  <tr><td>{@link #getHubiitiransksymd hubiitiransksymd}</td><td>不備一覧作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkHubiDetail
 * @see     PKHT_SkHubiDetail
 * @see     QHT_SkHubiDetail
 * @see     GenQHT_SkHubiDetail
 */
@MappedSuperclass
@Table(name=GenHT_SkHubiDetail.TABLE_NAME)
@IdClass(value=PKHT_SkHubiDetail.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HasinkyokaKbn", typeClass=UserType_C_HasinkyokaKbn.class),
    @TypeDef(name="UserType_C_HassinsakiKbn", typeClass=UserType_C_HassinsakiKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenHT_SkHubiDetail extends AbstractExDBEntity<HT_SkHubiDetail, PKHT_SkHubiDetail> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkHubiDetail";
    public static final String MOSNO                    = "mosno";
    public static final String HUBISIKIBETUKEY          = "hubisikibetukey";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String SKHUBIKOUMOKUCD          = "skhubikoumokucd";
    public static final String SKHUBINAIYOUCD           = "skhubinaiyoucd";
    public static final String SKSEIBISIJINAIYOUCD      = "skseibisijinaiyoucd";
    public static final String TYOUBUNFLG               = "tyoubunflg";
    public static final String SKRENRAKUJIKOU           = "skrenrakujikou";
    public static final String TRKYMD                   = "trkymd";
    public static final String HASINYMD                 = "hasinymd";
    public static final String KAISYOUYMD               = "kaisyouymd";
    public static final String HASSINSAKIKBN            = "hassinsakikbn";
    public static final String HASINKYOKAKBN            = "hasinkyokakbn";
    public static final String HUBIITIRANSKSYMD         = "hubiitiransksymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SkHubiDetail primaryKey;

    public GenHT_SkHubiDetail() {
        primaryKey = new PKHT_SkHubiDetail();
    }

    public GenHT_SkHubiDetail(
        String pMosno,
        String pHubisikibetukey,
        Integer pRenno3keta
    ) {
        primaryKey = new PKHT_SkHubiDetail(
            pMosno,
            pHubisikibetukey,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKHT_SkHubiDetail getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkHubiDetail> getMetaClass() {
        return QHT_SkHubiDetail.class;
    }

    @Id
    @Column(name=GenHT_SkHubiDetail.MOSNO)
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
    @Column(name=GenHT_SkHubiDetail.HUBISIKIBETUKEY)
    public String getHubisikibetukey() {
        return getPrimaryKey().getHubisikibetukey();
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        getPrimaryKey().setHubisikibetukey(pHubisikibetukey);
    }

    @Id
    @Column(name=GenHT_SkHubiDetail.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenHT_SkHubiDetail.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private String skhubikoumokucd;

    @Column(name=GenHT_SkHubiDetail.SKHUBIKOUMOKUCD)
    public String getSkhubikoumokucd() {
        return skhubikoumokucd;
    }

    public void setSkhubikoumokucd(String pSkhubikoumokucd) {
        skhubikoumokucd = pSkhubikoumokucd;
    }

    private String skhubinaiyoucd;

    @Column(name=GenHT_SkHubiDetail.SKHUBINAIYOUCD)
    public String getSkhubinaiyoucd() {
        return skhubinaiyoucd;
    }

    public void setSkhubinaiyoucd(String pSkhubinaiyoucd) {
        skhubinaiyoucd = pSkhubinaiyoucd;
    }

    private String skseibisijinaiyoucd;

    @Column(name=GenHT_SkHubiDetail.SKSEIBISIJINAIYOUCD)
    public String getSkseibisijinaiyoucd() {
        return skseibisijinaiyoucd;
    }

    public void setSkseibisijinaiyoucd(String pSkseibisijinaiyoucd) {
        skseibisijinaiyoucd = pSkseibisijinaiyoucd;
    }

    private C_UmuKbn tyoubunflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SkHubiDetail.TYOUBUNFLG)
    public C_UmuKbn getTyoubunflg() {
        return tyoubunflg;
    }

    public void setTyoubunflg(C_UmuKbn pTyoubunflg) {
        tyoubunflg = pTyoubunflg;
    }

    private String skrenrakujikou;

    @Column(name=GenHT_SkHubiDetail.SKRENRAKUJIKOU)
    public String getSkrenrakujikou() {
        return skrenrakujikou;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSkrenrakujikou(String pSkrenrakujikou) {
        skrenrakujikou = pSkrenrakujikou;
    }

    private BizDate trkymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkHubiDetail.TRKYMD)
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
    @Column(name=GenHT_SkHubiDetail.HASINYMD)
    public BizDate getHasinymd() {
        return hasinymd;
    }

    @Trim("both")
    public void setHasinymd(BizDate pHasinymd) {
        hasinymd = pHasinymd;
    }

    private BizDate kaisyouymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkHubiDetail.KAISYOUYMD)
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
    @Column(name=GenHT_SkHubiDetail.HASSINSAKIKBN)
    public C_HassinsakiKbn getHassinsakikbn() {
        return hassinsakikbn;
    }

    public void setHassinsakikbn(C_HassinsakiKbn pHassinsakikbn) {
        hassinsakikbn = pHassinsakikbn;
    }

    private C_HasinkyokaKbn hasinkyokakbn;

    @Type(type="UserType_C_HasinkyokaKbn")
    @Column(name=GenHT_SkHubiDetail.HASINKYOKAKBN)
    public C_HasinkyokaKbn getHasinkyokakbn() {
        return hasinkyokakbn;
    }

    public void setHasinkyokakbn(C_HasinkyokaKbn pHasinkyokakbn) {
        hasinkyokakbn = pHasinkyokakbn;
    }

    private BizDate hubiitiransksymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkHubiDetail.HUBIITIRANSKSYMD)
    @ValidDate
    public BizDate getHubiitiransksymd() {
        return hubiitiransksymd;
    }

    @Trim("both")
    public void setHubiitiransksymd(BizDate pHubiitiransksymd) {
        hubiitiransksymd = pHubiitiransksymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkHubiDetail.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkHubiDetail.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}