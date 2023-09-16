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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BV_HjybruikeigakuData;
import yuyu.def.db.id.PKBV_HjybruikeigakuData;
import yuyu.def.db.meta.GenQBV_HjybruikeigakuData;
import yuyu.def.db.meta.QBV_HjybruikeigakuData;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 補助簿累計額情報ビュー テーブルのマッピング情報クラスで、 {@link BV_HjybruikeigakuData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BV_HjybruikeigakuData}</td><td colspan="3">補助簿累計額情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHjybtantositucd hjybtantositucd}</td><td>補助簿統括担当室コード</td><td align="center">{@link PKBV_HjybruikeigakuData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">{@link PKBV_HjybruikeigakuData ○}</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getDenym denym}</td><td>伝票年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKasikataruigk kasikataruigk}</td><td>貸方年間累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKarikataruigk karikataruigk}</td><td>借方年間累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKasikatateiseigk kasikatateiseigk}</td><td>貸方訂正額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKarikatateiseigk karikatateiseigk}</td><td>借方訂正額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHjybruigkteiseiumukbn hjybruigkteiseiumukbn}</td><td>補助簿累計額訂正有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 * </table>
 * @see     BV_HjybruikeigakuData
 * @see     PKBV_HjybruikeigakuData
 * @see     QBV_HjybruikeigakuData
 * @see     GenQBV_HjybruikeigakuData
 */
@MappedSuperclass
@Table(name=GenBV_HjybruikeigakuData.TABLE_NAME)
@IdClass(value=PKBV_HjybruikeigakuData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenBV_HjybruikeigakuData extends AbstractExDBEntity<BV_HjybruikeigakuData, PKBV_HjybruikeigakuData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BV_HjybruikeigakuData";
    public static final String HJYBTANTOSITUCD          = "hjybtantositucd";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String DENYM                    = "denym";
    public static final String KASIKATARUIGK            = "kasikataruigk";
    public static final String KARIKATARUIGK            = "karikataruigk";
    public static final String KASIKATATEISEIGK         = "kasikatateiseigk";
    public static final String KARIKATATEISEIGK         = "karikatateiseigk";
    public static final String HJYBRUIGKTEISEIUMUKBN    = "hjybruigkteiseiumukbn";

    private final PKBV_HjybruikeigakuData primaryKey;

    public GenBV_HjybruikeigakuData() {
        primaryKey = new PKBV_HjybruikeigakuData();
    }

    public GenBV_HjybruikeigakuData(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {
        primaryKey = new PKBV_HjybruikeigakuData(pHjybtantositucd, pKanjyoukmkcd);
    }

    @Transient
    @Override
    public PKBV_HjybruikeigakuData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBV_HjybruikeigakuData> getMetaClass() {
        return QBV_HjybruikeigakuData.class;
    }

    @Id
    @Column(name=GenBV_HjybruikeigakuData.HJYBTANTOSITUCD)
    public String getHjybtantositucd() {
        return getPrimaryKey().getHjybtantositucd();
    }

    public void setHjybtantositucd(String pHjybtantositucd) {
        getPrimaryKey().setHjybtantositucd(pHjybtantositucd);
    }

    @Id
    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBV_HjybruikeigakuData.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return getPrimaryKey().getKanjyoukmkcd();
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        getPrimaryKey().setKanjyoukmkcd(pKanjyoukmkcd);
    }

    private BizDateYM denym;

    @Type(type="BizDateYMType")
    @Column(name=GenBV_HjybruikeigakuData.DENYM)
    public BizDateYM getDenym() {
        return denym;
    }

    public void setDenym(BizDateYM pDenym) {
        denym = pDenym;
    }

    private BizCurrency kasikataruigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKasikataruigk() {
        return kasikataruigk;
    }

    public void setKasikataruigk(BizCurrency pKasikataruigk) {
        kasikataruigk = pKasikataruigk;
        kasikataruigkValue = null;
        kasikataruigkType  = null;
    }

    transient private BigDecimal kasikataruigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KASIKATARUIGK, nullable=true)
    protected BigDecimal getKasikataruigkValue() {
        if (kasikataruigkValue == null && kasikataruigk != null) {
            if (kasikataruigk.isOptional()) return null;
            return kasikataruigk.absolute();
        }
        return kasikataruigkValue;
    }

    protected void setKasikataruigkValue(BigDecimal value) {
        kasikataruigkValue = value;
        kasikataruigk = Optional.fromNullable(toCurrencyType(kasikataruigkType))
            .transform(bizCurrencyTransformer(getKasikataruigkValue()))
            .orNull();
    }

    transient private String kasikataruigkType = null;

    @Column(name=KASIKATARUIGK + "$", nullable=true)
    protected String getKasikataruigkType() {
        if (kasikataruigkType == null && kasikataruigk != null) return kasikataruigk.getType().toString();
        if (kasikataruigkType == null && getKasikataruigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kasikataruigk$' should not be NULL."));
        }
        return kasikataruigkType;
    }

    protected void setKasikataruigkType(String type) {
        kasikataruigkType = type;
        kasikataruigk = Optional.fromNullable(toCurrencyType(kasikataruigkType))
            .transform(bizCurrencyTransformer(getKasikataruigkValue()))
            .orNull();
    }

    private BizCurrency karikataruigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKarikataruigk() {
        return karikataruigk;
    }

    public void setKarikataruigk(BizCurrency pKarikataruigk) {
        karikataruigk = pKarikataruigk;
        karikataruigkValue = null;
        karikataruigkType  = null;
    }

    transient private BigDecimal karikataruigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIKATARUIGK, nullable=true)
    protected BigDecimal getKarikataruigkValue() {
        if (karikataruigkValue == null && karikataruigk != null) {
            if (karikataruigk.isOptional()) return null;
            return karikataruigk.absolute();
        }
        return karikataruigkValue;
    }

    protected void setKarikataruigkValue(BigDecimal value) {
        karikataruigkValue = value;
        karikataruigk = Optional.fromNullable(toCurrencyType(karikataruigkType))
            .transform(bizCurrencyTransformer(getKarikataruigkValue()))
            .orNull();
    }

    transient private String karikataruigkType = null;

    @Column(name=KARIKATARUIGK + "$", nullable=true)
    protected String getKarikataruigkType() {
        if (karikataruigkType == null && karikataruigk != null) return karikataruigk.getType().toString();
        if (karikataruigkType == null && getKarikataruigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'karikataruigk$' should not be NULL."));
        }
        return karikataruigkType;
    }

    protected void setKarikataruigkType(String type) {
        karikataruigkType = type;
        karikataruigk = Optional.fromNullable(toCurrencyType(karikataruigkType))
            .transform(bizCurrencyTransformer(getKarikataruigkValue()))
            .orNull();
    }

    private BizCurrency kasikatateiseigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKasikatateiseigk() {
        return kasikatateiseigk;
    }

    public void setKasikatateiseigk(BizCurrency pKasikatateiseigk) {
        kasikatateiseigk = pKasikatateiseigk;
        kasikatateiseigkValue = null;
        kasikatateiseigkType  = null;
    }

    transient private BigDecimal kasikatateiseigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KASIKATATEISEIGK, nullable=true)
    protected BigDecimal getKasikatateiseigkValue() {
        if (kasikatateiseigkValue == null && kasikatateiseigk != null) {
            if (kasikatateiseigk.isOptional()) return null;
            return kasikatateiseigk.absolute();
        }
        return kasikatateiseigkValue;
    }

    protected void setKasikatateiseigkValue(BigDecimal value) {
        kasikatateiseigkValue = value;
        kasikatateiseigk = Optional.fromNullable(toCurrencyType(kasikatateiseigkType))
            .transform(bizCurrencyTransformer(getKasikatateiseigkValue()))
            .orNull();
    }

    transient private String kasikatateiseigkType = null;

    @Column(name=KASIKATATEISEIGK + "$", nullable=true)
    protected String getKasikatateiseigkType() {
        if (kasikatateiseigkType == null && kasikatateiseigk != null) return kasikatateiseigk.getType().toString();
        if (kasikatateiseigkType == null && getKasikatateiseigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kasikatateiseigk$' should not be NULL."));
        }
        return kasikatateiseigkType;
    }

    protected void setKasikatateiseigkType(String type) {
        kasikatateiseigkType = type;
        kasikatateiseigk = Optional.fromNullable(toCurrencyType(kasikatateiseigkType))
            .transform(bizCurrencyTransformer(getKasikatateiseigkValue()))
            .orNull();
    }

    private BizCurrency karikatateiseigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKarikatateiseigk() {
        return karikatateiseigk;
    }

    public void setKarikatateiseigk(BizCurrency pKarikatateiseigk) {
        karikatateiseigk = pKarikatateiseigk;
        karikatateiseigkValue = null;
        karikatateiseigkType  = null;
    }

    transient private BigDecimal karikatateiseigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIKATATEISEIGK, nullable=true)
    protected BigDecimal getKarikatateiseigkValue() {
        if (karikatateiseigkValue == null && karikatateiseigk != null) {
            if (karikatateiseigk.isOptional()) return null;
            return karikatateiseigk.absolute();
        }
        return karikatateiseigkValue;
    }

    protected void setKarikatateiseigkValue(BigDecimal value) {
        karikatateiseigkValue = value;
        karikatateiseigk = Optional.fromNullable(toCurrencyType(karikatateiseigkType))
            .transform(bizCurrencyTransformer(getKarikatateiseigkValue()))
            .orNull();
    }

    transient private String karikatateiseigkType = null;

    @Column(name=KARIKATATEISEIGK + "$", nullable=true)
    protected String getKarikatateiseigkType() {
        if (karikatateiseigkType == null && karikatateiseigk != null) return karikatateiseigk.getType().toString();
        if (karikatateiseigkType == null && getKarikatateiseigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'karikatateiseigk$' should not be NULL."));
        }
        return karikatateiseigkType;
    }

    protected void setKarikatateiseigkType(String type) {
        karikatateiseigkType = type;
        karikatateiseigk = Optional.fromNullable(toCurrencyType(karikatateiseigkType))
            .transform(bizCurrencyTransformer(getKarikatateiseigkValue()))
            .orNull();
    }

    private C_UmuKbn hjybruigkteiseiumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBV_HjybruikeigakuData.HJYBRUIGKTEISEIUMUKBN)
    public C_UmuKbn getHjybruigkteiseiumukbn() {
        return hjybruigkteiseiumukbn;
    }

    public void setHjybruigkteiseiumukbn(C_UmuKbn pHjybruigkteiseiumukbn) {
        hjybruigkteiseiumukbn = pHjybruigkteiseiumukbn;
    }
}