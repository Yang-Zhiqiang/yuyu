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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.def.db.id.PKBM_KawaseRate;
import yuyu.def.db.meta.GenQBM_KawaseRate;
import yuyu.def.db.meta.QBM_KawaseRate;
import yuyu.def.db.type.UserType_C_KawasetekiyoKbn;
import yuyu.def.db.type.UserType_C_KawasetsryKbn;
import yuyu.def.db.type.UserType_C_KwsrendouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 為替レートマスタ テーブルのマッピング情報クラスで、 {@link BM_KawaseRate} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KawaseRate}</td><td colspan="3">為替レートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKwsratekjymd kwsratekjymd}</td><td>為替レート基準日</td><td align="center">{@link PKBM_KawaseRate ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKwsrendoukbn kwsrendoukbn}</td><td>為替レート連動区分</td><td align="center">{@link PKBM_KawaseRate ○}</td><td align="center">V</td><td>{@link C_KwsrendouKbn}</td></tr>
 *  <tr><td>{@link #getMototuuka mototuuka}</td><td>元通貨</td><td align="center">{@link PKBM_KawaseRate ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKanzantuuka kanzantuuka}</td><td>換算通貨</td><td align="center">{@link PKBM_KawaseRate ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKawasetekiyokbn kawasetekiyokbn}</td><td>為替適用区分</td><td align="center">{@link PKBM_KawaseRate ○}</td><td align="center">V</td><td>{@link C_KawasetekiyoKbn}</td></tr>
 *  <tr><td>{@link #getKawasetsrykbn kawasetsrykbn}</td><td>為替手数料区分</td><td align="center">{@link PKBM_KawaseRate ○}</td><td align="center">V</td><td>{@link C_KawasetsryKbn}</td></tr>
 *  <tr><td>{@link #getKawaserate kawaserate}</td><td>為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_KawaseRate
 * @see     PKBM_KawaseRate
 * @see     QBM_KawaseRate
 * @see     GenQBM_KawaseRate
 */
@MappedSuperclass
@Table(name=GenBM_KawaseRate.TABLE_NAME)
@IdClass(value=PKBM_KawaseRate.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_KawasetekiyoKbn", typeClass=UserType_C_KawasetekiyoKbn.class),
    @TypeDef(name="UserType_C_KawasetsryKbn", typeClass=UserType_C_KawasetsryKbn.class),
    @TypeDef(name="UserType_C_KwsrendouKbn", typeClass=UserType_C_KwsrendouKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_KawaseRate extends AbstractExDBEntity<BM_KawaseRate, PKBM_KawaseRate> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_KawaseRate";
    public static final String KWSRATEKJYMD             = "kwsratekjymd";
    public static final String KWSRENDOUKBN             = "kwsrendoukbn";
    public static final String MOTOTUUKA                = "mototuuka";
    public static final String KANZANTUUKA              = "kanzantuuka";
    public static final String KAWASETEKIYOKBN          = "kawasetekiyokbn";
    public static final String KAWASETSRYKBN            = "kawasetsrykbn";
    public static final String KAWASERATE               = "kawaserate";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_KawaseRate primaryKey;

    public GenBM_KawaseRate() {
        primaryKey = new PKBM_KawaseRate();
    }

    public GenBM_KawaseRate(
        BizDate pKwsratekjymd,
        C_KwsrendouKbn pKwsrendoukbn,
        C_Tuukasyu pMototuuka,
        C_Tuukasyu pKanzantuuka,
        C_KawasetekiyoKbn pKawasetekiyokbn,
        C_KawasetsryKbn pKawasetsrykbn
    ) {
        primaryKey = new PKBM_KawaseRate(
            pKwsratekjymd,
            pKwsrendoukbn,
            pMototuuka,
            pKanzantuuka,
            pKawasetekiyokbn,
            pKawasetsrykbn
        );
    }

    @Transient
    @Override
    public PKBM_KawaseRate getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_KawaseRate> getMetaClass() {
        return QBM_KawaseRate.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_KawaseRate.KWSRATEKJYMD)
    public BizDate getKwsratekjymd() {
        return getPrimaryKey().getKwsratekjymd();
    }

    public void setKwsratekjymd(BizDate pKwsratekjymd) {
        getPrimaryKey().setKwsratekjymd(pKwsratekjymd);
    }

    @Id
    @Type(type="UserType_C_KwsrendouKbn")
    @Column(name=GenBM_KawaseRate.KWSRENDOUKBN)
    public C_KwsrendouKbn getKwsrendoukbn() {
        return getPrimaryKey().getKwsrendoukbn();
    }

    public void setKwsrendoukbn(C_KwsrendouKbn pKwsrendoukbn) {
        getPrimaryKey().setKwsrendoukbn(pKwsrendoukbn);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_KawaseRate.MOTOTUUKA)
    public C_Tuukasyu getMototuuka() {
        return getPrimaryKey().getMototuuka();
    }

    public void setMototuuka(C_Tuukasyu pMototuuka) {
        getPrimaryKey().setMototuuka(pMototuuka);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_KawaseRate.KANZANTUUKA)
    public C_Tuukasyu getKanzantuuka() {
        return getPrimaryKey().getKanzantuuka();
    }

    public void setKanzantuuka(C_Tuukasyu pKanzantuuka) {
        getPrimaryKey().setKanzantuuka(pKanzantuuka);
    }

    @Id
    @Type(type="UserType_C_KawasetekiyoKbn")
    @Column(name=GenBM_KawaseRate.KAWASETEKIYOKBN)
    public C_KawasetekiyoKbn getKawasetekiyokbn() {
        return getPrimaryKey().getKawasetekiyokbn();
    }

    public void setKawasetekiyokbn(C_KawasetekiyoKbn pKawasetekiyokbn) {
        getPrimaryKey().setKawasetekiyokbn(pKawasetekiyokbn);
    }

    @Id
    @Type(type="UserType_C_KawasetsryKbn")
    @Column(name=GenBM_KawaseRate.KAWASETSRYKBN)
    public C_KawasetsryKbn getKawasetsrykbn() {
        return getPrimaryKey().getKawasetsrykbn();
    }

    public void setKawasetsrykbn(C_KawasetsryKbn pKawasetsrykbn) {
        getPrimaryKey().setKawasetsrykbn(pKawasetsrykbn);
    }

    private BizNumber kawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenBM_KawaseRate.KAWASERATE)
    public BizNumber getKawaserate() {
        return kawaserate;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKawaserate(BizNumber pKawaserate) {
        kawaserate = pKawaserate;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBM_KawaseRate.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_KawaseRate.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_KawaseRate.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
