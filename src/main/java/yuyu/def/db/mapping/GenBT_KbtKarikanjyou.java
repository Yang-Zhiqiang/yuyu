package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.BT_KbtKarikanjyou;
import yuyu.def.db.id.PKBT_KbtKarikanjyou;
import yuyu.def.db.meta.GenQBT_KbtKarikanjyou;
import yuyu.def.db.meta.QBT_KbtKarikanjyou;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;

/**
 * 個別仮勘定テーブル テーブルのマッピング情報クラスで、 {@link BT_KbtKarikanjyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KbtKarikanjyou}</td><td colspan="3">個別仮勘定テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbtkarikanjyouskbtkey kbtkarikanjyouskbtkey}</td><td>個別仮勘定識別キー</td><td align="center">{@link PKBT_KbtKarikanjyou ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKeirisyono keirisyono}</td><td>経理用証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuukinkakusyouno nyuukinkakusyouno}</td><td>入金確証番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaedenskssyoriymd hurikaedenskssyoriymd}</td><td>振替伝票作成処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHuridenatesakicd huridenatesakicd}</td><td>振替伝票宛先部課コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getDenyenkagk denyenkagk}</td><td>伝票金額（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbtkarikanjyoukbn kbtkarikanjyoukbn}</td><td>個別仮勘定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKskmkanryouymd kskmkanryouymd}</td><td>消込完了年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BT_KbtKarikanjyou
 * @see     PKBT_KbtKarikanjyou
 * @see     QBT_KbtKarikanjyou
 * @see     GenQBT_KbtKarikanjyou
 */
@MappedSuperclass
@Table(name=GenBT_KbtKarikanjyou.TABLE_NAME)
@IdClass(value=PKBT_KbtKarikanjyou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_DensysKbn", typeClass=UserType_C_DensysKbn.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_TaisyakuKbn", typeClass=UserType_C_TaisyakuKbn.class)
})
public abstract class GenBT_KbtKarikanjyou extends AbstractExDBEntity<BT_KbtKarikanjyou, PKBT_KbtKarikanjyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_KbtKarikanjyou";
    public static final String KBTKARIKANJYOUSKBTKEY    = "kbtkarikanjyouskbtkey";
    public static final String DENSYSKBN                = "densyskbn";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String KEIRISYONO               = "keirisyono";
    public static final String NYUUKINKAKUSYOUNO        = "nyuukinkakusyouno";
    public static final String HURIKAEDENSKSSYORIYMD    = "hurikaedenskssyoriymd";
    public static final String DENYMD                   = "denymd";
    public static final String HURIDENATESAKICD         = "huridenatesakicd";
    public static final String TAISYAKUKBN              = "taisyakukbn";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String DENYENKAGK               = "denyenkagk";
    public static final String SYORICD                  = "syoricd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String KBTKARIKANJYOUKBN        = "kbtkarikanjyoukbn";
    public static final String KSKMKANRYOUYMD           = "kskmkanryouymd";
    public static final String SEG1CD                   = "seg1cd";
    public static final String SYORIYMD                 = "syoriYmd";

    private final PKBT_KbtKarikanjyou primaryKey;

    public GenBT_KbtKarikanjyou() {
        primaryKey = new PKBT_KbtKarikanjyou();
    }

    public GenBT_KbtKarikanjyou(BizNumber pKbtkarikanjyouskbtkey) {
        primaryKey = new PKBT_KbtKarikanjyou(pKbtkarikanjyouskbtkey);
    }

    @Transient
    @Override
    public PKBT_KbtKarikanjyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_KbtKarikanjyou> getMetaClass() {
        return QBT_KbtKarikanjyou.class;
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBT_KbtKarikanjyou.KBTKARIKANJYOUSKBTKEY)
    public BizNumber getKbtkarikanjyouskbtkey() {
        return getPrimaryKey().getKbtkarikanjyouskbtkey();
    }

    public void setKbtkarikanjyouskbtkey(BizNumber pKbtkarikanjyouskbtkey) {
        getPrimaryKey().setKbtkarikanjyouskbtkey(pKbtkarikanjyouskbtkey);
    }

    private C_DensysKbn densyskbn;

    @Type(type="UserType_C_DensysKbn")
    @Column(name=GenBT_KbtKarikanjyou.DENSYSKBN)
    public C_DensysKbn getDensyskbn() {
        return densyskbn;
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        densyskbn = pDensyskbn;
    }

    private String denrenno;

    @Column(name=GenBT_KbtKarikanjyou.DENRENNO)
    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    private Integer edano;

    @Column(name=GenBT_KbtKarikanjyou.EDANO)
    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

    private String keirisyono;

    @Column(name=GenBT_KbtKarikanjyou.KEIRISYONO)
    public String getKeirisyono() {
        return keirisyono;
    }

    public void setKeirisyono(String pKeirisyono) {
        keirisyono = pKeirisyono;
    }

    private String nyuukinkakusyouno;

    @Column(name=GenBT_KbtKarikanjyou.NYUUKINKAKUSYOUNO)
    public String getNyuukinkakusyouno() {
        return nyuukinkakusyouno;
    }

    public void setNyuukinkakusyouno(String pNyuukinkakusyouno) {
        nyuukinkakusyouno = pNyuukinkakusyouno;
    }

    private BizDate hurikaedenskssyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_KbtKarikanjyou.HURIKAEDENSKSSYORIYMD)
    public BizDate getHurikaedenskssyoriymd() {
        return hurikaedenskssyoriymd;
    }

    public void setHurikaedenskssyoriymd(BizDate pHurikaedenskssyoriymd) {
        hurikaedenskssyoriymd = pHurikaedenskssyoriymd;
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_KbtKarikanjyou.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private String huridenatesakicd;

    @Column(name=GenBT_KbtKarikanjyou.HURIDENATESAKICD)
    public String getHuridenatesakicd() {
        return huridenatesakicd;
    }

    public void setHuridenatesakicd(String pHuridenatesakicd) {
        huridenatesakicd = pHuridenatesakicd;
    }

    private C_TaisyakuKbn taisyakukbn;

    @Type(type="UserType_C_TaisyakuKbn")
    @Column(name=GenBT_KbtKarikanjyou.TAISYAKUKBN)
    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakukbn;
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakukbn = pTaisyakukbn;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KbtKarikanjyou.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    private BizCurrency denyenkagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDenyenkagk() {
        return denyenkagk;
    }

    public void setDenyenkagk(BizCurrency pDenyenkagk) {
        denyenkagk = pDenyenkagk;
        denyenkagkValue = null;
        denyenkagkType  = null;
    }

    transient private BigDecimal denyenkagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DENYENKAGK, nullable=true)
    protected BigDecimal getDenyenkagkValue() {
        if (denyenkagkValue == null && denyenkagk != null) {
            if (denyenkagk.isOptional()) return null;
            return denyenkagk.absolute();
        }
        return denyenkagkValue;
    }

    protected void setDenyenkagkValue(BigDecimal value) {
        denyenkagkValue = value;
        denyenkagk = Optional.fromNullable(toCurrencyType(denyenkagkType))
            .transform(bizCurrencyTransformer(getDenyenkagkValue()))
            .orNull();
    }

    transient private String denyenkagkType = null;

    @Column(name=DENYENKAGK + "$", nullable=true)
    protected String getDenyenkagkType() {
        if (denyenkagkType == null && denyenkagk != null) return denyenkagk.getType().toString();
        if (denyenkagkType == null && getDenyenkagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'denyenkagk$' should not be NULL."));
        }
        return denyenkagkType;
    }

    protected void setDenyenkagkType(String type) {
        denyenkagkType = type;
        denyenkagk = Optional.fromNullable(toCurrencyType(denyenkagkType))
            .transform(bizCurrencyTransformer(getDenyenkagkValue()))
            .orNull();
    }

    private String syoricd;

    @Column(name=GenBT_KbtKarikanjyou.SYORICD)
    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }

    private String syorisosikicd;

    @Column(name=GenBT_KbtKarikanjyou.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private String kbtkarikanjyoukbn;

    @Column(name=GenBT_KbtKarikanjyou.KBTKARIKANJYOUKBN)
    public String getKbtkarikanjyoukbn() {
        return kbtkarikanjyoukbn;
    }

    public void setKbtkarikanjyoukbn(String pKbtkarikanjyoukbn) {
        kbtkarikanjyoukbn = pKbtkarikanjyoukbn;
    }

    private BizDate kskmkanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_KbtKarikanjyou.KSKMKANRYOUYMD)
    public BizDate getKskmkanryouymd() {
        return kskmkanryouymd;
    }

    public void setKskmkanryouymd(BizDate pKskmkanryouymd) {
        kskmkanryouymd = pKskmkanryouymd;
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenBT_KbtKarikanjyou.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenBT_KbtKarikanjyou.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
}