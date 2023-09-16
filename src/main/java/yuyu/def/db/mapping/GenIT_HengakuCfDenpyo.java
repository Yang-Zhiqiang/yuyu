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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_HengakuCfDenpyo;
import yuyu.def.db.id.PKIT_HengakuCfDenpyo;
import yuyu.def.db.meta.GenQIT_HengakuCfDenpyo;
import yuyu.def.db.meta.QIT_HengakuCfDenpyo;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * 変額ＣＦ伝票テーブル テーブルのマッピング情報クラスで、 {@link IT_HengakuCfDenpyo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HengakuCfDenpyo}</td><td colspan="3">変額ＣＦ伝票テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">{@link PKIT_HengakuCfDenpyo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">{@link PKIT_HengakuCfDenpyo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDengaikagk dengaikagk}</td><td>伝票金額（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDenyenkagk denyenkagk}</td><td>伝票金額（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_HengakuCfDenpyo
 * @see     PKIT_HengakuCfDenpyo
 * @see     QIT_HengakuCfDenpyo
 * @see     GenQIT_HengakuCfDenpyo
 */
@MappedSuperclass
@Table(name=GenIT_HengakuCfDenpyo.TABLE_NAME)
@IdClass(value=PKIT_HengakuCfDenpyo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_TaisyakuKbn", typeClass=UserType_C_TaisyakuKbn.class),
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UnitFundKbn", typeClass=UserType_C_UnitFundKbn.class)
})
public abstract class GenIT_HengakuCfDenpyo extends AbstractExDBEntity<IT_HengakuCfDenpyo, PKIT_HengakuCfDenpyo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_HengakuCfDenpyo";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String UNITFUNDKBN              = "unitfundkbn";
    public static final String TANTOCD                  = "tantocd";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String DENYMD                   = "denymd";
    public static final String TAISYAKUKBN              = "taisyakukbn";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String DENGAIKAGK               = "dengaikagk";
    public static final String DENYENKAGK               = "denyenkagk";

    private final PKIT_HengakuCfDenpyo primaryKey;

    public GenIT_HengakuCfDenpyo() {
        primaryKey = new PKIT_HengakuCfDenpyo();
    }

    public GenIT_HengakuCfDenpyo(String pDenrenno, Integer pEdano) {
        primaryKey = new PKIT_HengakuCfDenpyo(pDenrenno, pEdano);
    }

    @Transient
    @Override
    public PKIT_HengakuCfDenpyo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_HengakuCfDenpyo> getMetaClass() {
        return QIT_HengakuCfDenpyo.class;
    }

    @Id
    @Column(name=GenIT_HengakuCfDenpyo.DENRENNO)
    public String getDenrenno() {
        return getPrimaryKey().getDenrenno();
    }

    public void setDenrenno(String pDenrenno) {
        getPrimaryKey().setDenrenno(pDenrenno);
    }

    @Id
    @Column(name=GenIT_HengakuCfDenpyo.EDANO)
    public Integer getEdano() {
        return getPrimaryKey().getEdano();
    }

    public void setEdano(Integer pEdano) {
        getPrimaryKey().setEdano(pEdano);
    }

    private C_UnitFundKbn unitfundkbn;

    @Type(type="UserType_C_UnitFundKbn")
    @Column(name=GenIT_HengakuCfDenpyo.UNITFUNDKBN)
    public C_UnitFundKbn getUnitfundkbn() {
        return unitfundkbn;
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        unitfundkbn = pUnitfundkbn;
    }

    private C_TantouCdKbn tantocd;

    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenIT_HengakuCfDenpyo.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HengakuCfDenpyo.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HengakuCfDenpyo.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private C_TaisyakuKbn taisyakukbn;

    @Type(type="UserType_C_TaisyakuKbn")
    @Column(name=GenIT_HengakuCfDenpyo.TAISYAKUKBN)
    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakukbn;
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakukbn = pTaisyakukbn;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenIT_HengakuCfDenpyo.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    private C_Tuukasyu tuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_HengakuCfDenpyo.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    private BizCurrency dengaikagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDengaikagk() {
        return dengaikagk;
    }

    public void setDengaikagk(BizCurrency pDengaikagk) {
        dengaikagk = pDengaikagk;
        dengaikagkValue = null;
        dengaikagkType  = null;
    }

    transient private BigDecimal dengaikagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DENGAIKAGK, nullable=true)
    protected BigDecimal getDengaikagkValue() {
        if (dengaikagkValue == null && dengaikagk != null) {
            if (dengaikagk.isOptional()) return null;
            return dengaikagk.absolute();
        }
        return dengaikagkValue;
    }

    protected void setDengaikagkValue(BigDecimal value) {
        dengaikagkValue = value;
        dengaikagk = Optional.fromNullable(toCurrencyType(dengaikagkType))
            .transform(bizCurrencyTransformer(getDengaikagkValue()))
            .orNull();
    }

    transient private String dengaikagkType = null;

    @Column(name=DENGAIKAGK + "$", nullable=true)
    protected String getDengaikagkType() {
        if (dengaikagkType == null && dengaikagk != null) return dengaikagk.getType().toString();
        if (dengaikagkType == null && getDengaikagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dengaikagk$' should not be NULL."));
        }
        return dengaikagkType;
    }

    protected void setDengaikagkType(String type) {
        dengaikagkType = type;
        dengaikagk = Optional.fromNullable(toCurrencyType(dengaikagkType))
            .transform(bizCurrencyTransformer(getDengaikagkValue()))
            .orNull();
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
}