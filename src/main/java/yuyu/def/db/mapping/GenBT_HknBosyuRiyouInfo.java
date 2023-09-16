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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_GwriyouKbn;
import yuyu.def.classification.C_GwtsryKbn;
import yuyu.def.classification.C_HitmbosyuuKbn;
import yuyu.def.classification.C_HokenbossysriyouKbn;
import yuyu.def.classification.C_InternetstzkriyouKbn;
import yuyu.def.classification.C_IssriyouKbn;
import yuyu.def.classification.C_LphteikeitiginKbn;
import yuyu.def.classification.C_TmbosyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.BT_HknBosyuRiyouInfo;
import yuyu.def.db.id.PKBT_HknBosyuRiyouInfo;
import yuyu.def.db.meta.GenQBT_HknBosyuRiyouInfo;
import yuyu.def.db.meta.QBT_HknBosyuRiyouInfo;
import yuyu.def.db.type.UserType_C_GwriyouKbn;
import yuyu.def.db.type.UserType_C_GwtsryKbn;
import yuyu.def.db.type.UserType_C_HitmbosyuuKbn;
import yuyu.def.db.type.UserType_C_HokenbossysriyouKbn;
import yuyu.def.db.type.UserType_C_InternetstzkriyouKbn;
import yuyu.def.db.type.UserType_C_IssriyouKbn;
import yuyu.def.db.type.UserType_C_LphteikeitiginKbn;
import yuyu.def.db.type.UserType_C_TmbosyuuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YouhiblnkKbn;

/**
 * 保険募集システム利用情報テーブル テーブルのマッピング情報クラスで、 {@link BT_HknBosyuRiyouInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HknBosyuRiyouInfo}</td><td colspan="3">保険募集システム利用情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">{@link PKBT_HknBosyuRiyouInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwriyoukbn gwriyoukbn}</td><td>ＧＷ利用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GwriyouKbn}</td></tr>
 *  <tr><td>{@link #getGwkykrendouumukbn gwkykrendouumukbn}</td><td>ＧＷ契約データ連動有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGwtsryrendouumukbn gwtsryrendouumukbn}</td><td>ＧＷ手数料データ連動有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGwmisyuurendouumukbn gwmisyuurendouumukbn}</td><td>ＧＷ未収データ連動有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getIssriyoukbn issriyoukbn}</td><td>ＩＳＳ利用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IssriyouKbn}</td></tr>
 *  <tr><td>{@link #getGwtkyyoteiymd gwtkyyoteiymd}</td><td>ＧＷ適用予定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGwsousinsikibetusi gwsousinsikibetusi}</td><td>ＧＷ送信識別子</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwtsrykbn gwtsrykbn}</td><td>ＧＷ手数料区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GwtsryKbn}</td></tr>
 *  <tr><td>{@link #getInternetstzkriyoukbn internetstzkriyoukbn}</td><td>インターネット接続利用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InternetstzkriyouKbn}</td></tr>
 *  <tr><td>{@link #getHokenbossysriyoukbn hokenbossysriyoukbn}</td><td>保険募集システム利用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HokenbossysriyouKbn}</td></tr>
 *  <tr><td>{@link #getLphteikeitiginkbn lphteikeitiginkbn}</td><td>ＬＰＨ提携地銀区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_LphteikeitiginKbn}</td></tr>
 *  <tr><td>{@link #getTmbosyuukbn tmbosyuukbn}</td><td>対面募集区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TmbosyuuKbn}</td></tr>
 *  <tr><td>{@link #getHitmbosyuukbn hitmbosyuukbn}</td><td>非対面募集区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HitmbosyuuKbn}</td></tr>
 *  <tr><td>{@link #getKansyoutuutisakuseiyhkbn kansyoutuutisakuseiyhkbn}</td><td>代理店勧奨通知作成要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiblnkKbn}</td></tr>
 *  <tr><td>{@link #getFatcakakuninyhkbn fatcakakuninyhkbn}</td><td>FATCA確認要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiblnkKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_HknBosyuRiyouInfo
 * @see     PKBT_HknBosyuRiyouInfo
 * @see     QBT_HknBosyuRiyouInfo
 * @see     GenQBT_HknBosyuRiyouInfo
 */
@MappedSuperclass
@Table(name=GenBT_HknBosyuRiyouInfo.TABLE_NAME)
@IdClass(value=PKBT_HknBosyuRiyouInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_GwriyouKbn", typeClass=UserType_C_GwriyouKbn.class),
    @TypeDef(name="UserType_C_GwtsryKbn", typeClass=UserType_C_GwtsryKbn.class),
    @TypeDef(name="UserType_C_HitmbosyuuKbn", typeClass=UserType_C_HitmbosyuuKbn.class),
    @TypeDef(name="UserType_C_HokenbossysriyouKbn", typeClass=UserType_C_HokenbossysriyouKbn.class),
    @TypeDef(name="UserType_C_InternetstzkriyouKbn", typeClass=UserType_C_InternetstzkriyouKbn.class),
    @TypeDef(name="UserType_C_IssriyouKbn", typeClass=UserType_C_IssriyouKbn.class),
    @TypeDef(name="UserType_C_LphteikeitiginKbn", typeClass=UserType_C_LphteikeitiginKbn.class),
    @TypeDef(name="UserType_C_TmbosyuuKbn", typeClass=UserType_C_TmbosyuuKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YouhiblnkKbn", typeClass=UserType_C_YouhiblnkKbn.class)
})
public abstract class GenBT_HknBosyuRiyouInfo extends AbstractExDBEntity<BT_HknBosyuRiyouInfo, PKBT_HknBosyuRiyouInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_HknBosyuRiyouInfo";
    public static final String DRTENCD                  = "drtencd";
    public static final String GWRIYOUKBN               = "gwriyoukbn";
    public static final String GWKYKRENDOUUMUKBN        = "gwkykrendouumukbn";
    public static final String GWTSRYRENDOUUMUKBN       = "gwtsryrendouumukbn";
    public static final String GWMISYUURENDOUUMUKBN     = "gwmisyuurendouumukbn";
    public static final String ISSRIYOUKBN              = "issriyoukbn";
    public static final String GWTKYYOTEIYMD            = "gwtkyyoteiymd";
    public static final String GWSOUSINSIKIBETUSI       = "gwsousinsikibetusi";
    public static final String GWTSRYKBN                = "gwtsrykbn";
    public static final String INTERNETSTZKRIYOUKBN     = "internetstzkriyoukbn";
    public static final String HOKENBOSSYSRIYOUKBN      = "hokenbossysriyoukbn";
    public static final String LPHTEIKEITIGINKBN        = "lphteikeitiginkbn";
    public static final String TMBOSYUUKBN              = "tmbosyuukbn";
    public static final String HITMBOSYUUKBN            = "hitmbosyuukbn";
    public static final String KANSYOUTUUTISAKUSEIYHKBN = "kansyoutuutisakuseiyhkbn";
    public static final String FATCAKAKUNINYHKBN        = "fatcakakuninyhkbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_HknBosyuRiyouInfo primaryKey;

    public GenBT_HknBosyuRiyouInfo() {
        primaryKey = new PKBT_HknBosyuRiyouInfo();
    }

    public GenBT_HknBosyuRiyouInfo(String pDrtencd) {
        primaryKey = new PKBT_HknBosyuRiyouInfo(pDrtencd);
    }

    @Transient
    @Override
    public PKBT_HknBosyuRiyouInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_HknBosyuRiyouInfo> getMetaClass() {
        return QBT_HknBosyuRiyouInfo.class;
    }

    @Id
    @Column(name=GenBT_HknBosyuRiyouInfo.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return getPrimaryKey().getDrtencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        getPrimaryKey().setDrtencd(pDrtencd);
    }

    private C_GwriyouKbn gwriyoukbn;

    @Type(type="UserType_C_GwriyouKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.GWRIYOUKBN)
    public C_GwriyouKbn getGwriyoukbn() {
        return gwriyoukbn;
    }

    public void setGwriyoukbn(C_GwriyouKbn pGwriyoukbn) {
        gwriyoukbn = pGwriyoukbn;
    }

    private C_UmuKbn gwkykrendouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.GWKYKRENDOUUMUKBN)
    public C_UmuKbn getGwkykrendouumukbn() {
        return gwkykrendouumukbn;
    }

    public void setGwkykrendouumukbn(C_UmuKbn pGwkykrendouumukbn) {
        gwkykrendouumukbn = pGwkykrendouumukbn;
    }

    private C_UmuKbn gwtsryrendouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.GWTSRYRENDOUUMUKBN)
    public C_UmuKbn getGwtsryrendouumukbn() {
        return gwtsryrendouumukbn;
    }

    public void setGwtsryrendouumukbn(C_UmuKbn pGwtsryrendouumukbn) {
        gwtsryrendouumukbn = pGwtsryrendouumukbn;
    }

    private C_UmuKbn gwmisyuurendouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.GWMISYUURENDOUUMUKBN)
    public C_UmuKbn getGwmisyuurendouumukbn() {
        return gwmisyuurendouumukbn;
    }

    public void setGwmisyuurendouumukbn(C_UmuKbn pGwmisyuurendouumukbn) {
        gwmisyuurendouumukbn = pGwmisyuurendouumukbn;
    }

    private C_IssriyouKbn issriyoukbn;

    @Type(type="UserType_C_IssriyouKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.ISSRIYOUKBN)
    public C_IssriyouKbn getIssriyoukbn() {
        return issriyoukbn;
    }

    public void setIssriyoukbn(C_IssriyouKbn pIssriyoukbn) {
        issriyoukbn = pIssriyoukbn;
    }

    private BizDate gwtkyyoteiymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_HknBosyuRiyouInfo.GWTKYYOTEIYMD)
    @ValidDate
    public BizDate getGwtkyyoteiymd() {
        return gwtkyyoteiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGwtkyyoteiymd(BizDate pGwtkyyoteiymd) {
        gwtkyyoteiymd = pGwtkyyoteiymd;
    }

    private String gwsousinsikibetusi;

    @Column(name=GenBT_HknBosyuRiyouInfo.GWSOUSINSIKIBETUSI)
    @MaxLength(max=21)
    @SingleByteStrings
    public String getGwsousinsikibetusi() {
        return gwsousinsikibetusi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGwsousinsikibetusi(String pGwsousinsikibetusi) {
        gwsousinsikibetusi = pGwsousinsikibetusi;
    }

    private C_GwtsryKbn gwtsrykbn;

    @Type(type="UserType_C_GwtsryKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.GWTSRYKBN)
    public C_GwtsryKbn getGwtsrykbn() {
        return gwtsrykbn;
    }

    public void setGwtsrykbn(C_GwtsryKbn pGwtsrykbn) {
        gwtsrykbn = pGwtsrykbn;
    }

    private C_InternetstzkriyouKbn internetstzkriyoukbn;

    @Type(type="UserType_C_InternetstzkriyouKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.INTERNETSTZKRIYOUKBN)
    public C_InternetstzkriyouKbn getInternetstzkriyoukbn() {
        return internetstzkriyoukbn;
    }

    public void setInternetstzkriyoukbn(C_InternetstzkriyouKbn pInternetstzkriyoukbn) {
        internetstzkriyoukbn = pInternetstzkriyoukbn;
    }

    private C_HokenbossysriyouKbn hokenbossysriyoukbn;

    @Type(type="UserType_C_HokenbossysriyouKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.HOKENBOSSYSRIYOUKBN)
    public C_HokenbossysriyouKbn getHokenbossysriyoukbn() {
        return hokenbossysriyoukbn;
    }

    public void setHokenbossysriyoukbn(C_HokenbossysriyouKbn pHokenbossysriyoukbn) {
        hokenbossysriyoukbn = pHokenbossysriyoukbn;
    }

    private C_LphteikeitiginKbn lphteikeitiginkbn;

    @Type(type="UserType_C_LphteikeitiginKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.LPHTEIKEITIGINKBN)
    public C_LphteikeitiginKbn getLphteikeitiginkbn() {
        return lphteikeitiginkbn;
    }

    public void setLphteikeitiginkbn(C_LphteikeitiginKbn pLphteikeitiginkbn) {
        lphteikeitiginkbn = pLphteikeitiginkbn;
    }

    private C_TmbosyuuKbn tmbosyuukbn;

    @Type(type="UserType_C_TmbosyuuKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.TMBOSYUUKBN)
    public C_TmbosyuuKbn getTmbosyuukbn() {
        return tmbosyuukbn;
    }

    public void setTmbosyuukbn(C_TmbosyuuKbn pTmbosyuukbn) {
        tmbosyuukbn = pTmbosyuukbn;
    }

    private C_HitmbosyuuKbn hitmbosyuukbn;

    @Type(type="UserType_C_HitmbosyuuKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.HITMBOSYUUKBN)
    public C_HitmbosyuuKbn getHitmbosyuukbn() {
        return hitmbosyuukbn;
    }

    public void setHitmbosyuukbn(C_HitmbosyuuKbn pHitmbosyuukbn) {
        hitmbosyuukbn = pHitmbosyuukbn;
    }

    private C_YouhiblnkKbn kansyoutuutisakuseiyhkbn;

    @Type(type="UserType_C_YouhiblnkKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.KANSYOUTUUTISAKUSEIYHKBN)
    public C_YouhiblnkKbn getKansyoutuutisakuseiyhkbn() {
        return kansyoutuutisakuseiyhkbn;
    }

    public void setKansyoutuutisakuseiyhkbn(C_YouhiblnkKbn pKansyoutuutisakuseiyhkbn) {
        kansyoutuutisakuseiyhkbn = pKansyoutuutisakuseiyhkbn;
    }

    private C_YouhiblnkKbn fatcakakuninyhkbn;

    @Type(type="UserType_C_YouhiblnkKbn")
    @Column(name=GenBT_HknBosyuRiyouInfo.FATCAKAKUNINYHKBN)
    public C_YouhiblnkKbn getFatcakakuninyhkbn() {
        return fatcakakuninyhkbn;
    }

    public void setFatcakakuninyhkbn(C_YouhiblnkKbn pFatcakakuninyhkbn) {
        fatcakakuninyhkbn = pFatcakakuninyhkbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_HknBosyuRiyouInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_HknBosyuRiyouInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_HknBosyuRiyouInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
