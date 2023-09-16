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
import yuyu.def.db.entity.BT_Hjybruikeigaku;
import yuyu.def.db.id.PKBT_Hjybruikeigaku;
import yuyu.def.db.meta.GenQBT_Hjybruikeigaku;
import yuyu.def.db.meta.QBT_Hjybruikeigaku;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;

/**
 * 補助簿累計額テーブル テーブルのマッピング情報クラスで、 {@link BT_Hjybruikeigaku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_Hjybruikeigaku}</td><td colspan="3">補助簿累計額テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHjybtantositucd hjybtantositucd}</td><td>補助簿統括担当室コード</td><td align="center">{@link PKBT_Hjybruikeigaku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">{@link PKBT_Hjybruikeigaku ○}</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getDenym denym}</td><td>伝票年月</td><td align="center">{@link PKBT_Hjybruikeigaku ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKarikatakmkkeigk karikatakmkkeigk}</td><td>借方科目合計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKasikatakmkkeigk kasikatakmkkeigk}</td><td>貸方科目合計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKarikataruigk karikataruigk}</td><td>借方年間累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKasikataruigk kasikataruigk}</td><td>貸方年間累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_Hjybruikeigaku
 * @see     PKBT_Hjybruikeigaku
 * @see     QBT_Hjybruikeigaku
 * @see     GenQBT_Hjybruikeigaku
 */
@MappedSuperclass
@Table(name=GenBT_Hjybruikeigaku.TABLE_NAME)
@IdClass(value=PKBT_Hjybruikeigaku.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class)
})
public abstract class GenBT_Hjybruikeigaku extends AbstractExDBEntity<BT_Hjybruikeigaku, PKBT_Hjybruikeigaku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_Hjybruikeigaku";
    public static final String HJYBTANTOSITUCD          = "hjybtantositucd";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String DENYM                    = "denym";
    public static final String KARIKATAKMKKEIGK         = "karikatakmkkeigk";
    public static final String KASIKATAKMKKEIGK         = "kasikatakmkkeigk";
    public static final String KARIKATARUIGK            = "karikataruigk";
    public static final String KASIKATARUIGK            = "kasikataruigk";

    private final PKBT_Hjybruikeigaku primaryKey;

    public GenBT_Hjybruikeigaku() {
        primaryKey = new PKBT_Hjybruikeigaku();
    }

    public GenBT_Hjybruikeigaku(
        String pHjybtantositucd,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        BizDateYM pDenym
    ) {
        primaryKey = new PKBT_Hjybruikeigaku(
            pHjybtantositucd,
            pKanjyoukmkcd,
            pDenym
        );
    }

    @Transient
    @Override
    public PKBT_Hjybruikeigaku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_Hjybruikeigaku> getMetaClass() {
        return QBT_Hjybruikeigaku.class;
    }

    @Id
    @Column(name=GenBT_Hjybruikeigaku.HJYBTANTOSITUCD)
    public String getHjybtantositucd() {
        return getPrimaryKey().getHjybtantositucd();
    }

    public void setHjybtantositucd(String pHjybtantositucd) {
        getPrimaryKey().setHjybtantositucd(pHjybtantositucd);
    }

    @Id
    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_Hjybruikeigaku.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return getPrimaryKey().getKanjyoukmkcd();
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        getPrimaryKey().setKanjyoukmkcd(pKanjyoukmkcd);
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenBT_Hjybruikeigaku.DENYM)
    public BizDateYM getDenym() {
        return getPrimaryKey().getDenym();
    }

    public void setDenym(BizDateYM pDenym) {
        getPrimaryKey().setDenym(pDenym);
    }

    private BizCurrency karikatakmkkeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKarikatakmkkeigk() {
        return karikatakmkkeigk;
    }

    public void setKarikatakmkkeigk(BizCurrency pKarikatakmkkeigk) {
        karikatakmkkeigk = pKarikatakmkkeigk;
        karikatakmkkeigkValue = null;
        karikatakmkkeigkType  = null;
    }

    transient private BigDecimal karikatakmkkeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIKATAKMKKEIGK, nullable=true)
    protected BigDecimal getKarikatakmkkeigkValue() {
        if (karikatakmkkeigkValue == null && karikatakmkkeigk != null) {
            if (karikatakmkkeigk.isOptional()) return null;
            return karikatakmkkeigk.absolute();
        }
        return karikatakmkkeigkValue;
    }

    protected void setKarikatakmkkeigkValue(BigDecimal value) {
        karikatakmkkeigkValue = value;
        karikatakmkkeigk = Optional.fromNullable(toCurrencyType(karikatakmkkeigkType))
            .transform(bizCurrencyTransformer(getKarikatakmkkeigkValue()))
            .orNull();
    }

    transient private String karikatakmkkeigkType = null;

    @Column(name=KARIKATAKMKKEIGK + "$", nullable=true)
    protected String getKarikatakmkkeigkType() {
        if (karikatakmkkeigkType == null && karikatakmkkeigk != null) return karikatakmkkeigk.getType().toString();
        if (karikatakmkkeigkType == null && getKarikatakmkkeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'karikatakmkkeigk$' should not be NULL."));
        }
        return karikatakmkkeigkType;
    }

    protected void setKarikatakmkkeigkType(String type) {
        karikatakmkkeigkType = type;
        karikatakmkkeigk = Optional.fromNullable(toCurrencyType(karikatakmkkeigkType))
            .transform(bizCurrencyTransformer(getKarikatakmkkeigkValue()))
            .orNull();
    }

    private BizCurrency kasikatakmkkeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKasikatakmkkeigk() {
        return kasikatakmkkeigk;
    }

    public void setKasikatakmkkeigk(BizCurrency pKasikatakmkkeigk) {
        kasikatakmkkeigk = pKasikatakmkkeigk;
        kasikatakmkkeigkValue = null;
        kasikatakmkkeigkType  = null;
    }

    transient private BigDecimal kasikatakmkkeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KASIKATAKMKKEIGK, nullable=true)
    protected BigDecimal getKasikatakmkkeigkValue() {
        if (kasikatakmkkeigkValue == null && kasikatakmkkeigk != null) {
            if (kasikatakmkkeigk.isOptional()) return null;
            return kasikatakmkkeigk.absolute();
        }
        return kasikatakmkkeigkValue;
    }

    protected void setKasikatakmkkeigkValue(BigDecimal value) {
        kasikatakmkkeigkValue = value;
        kasikatakmkkeigk = Optional.fromNullable(toCurrencyType(kasikatakmkkeigkType))
            .transform(bizCurrencyTransformer(getKasikatakmkkeigkValue()))
            .orNull();
    }

    transient private String kasikatakmkkeigkType = null;

    @Column(name=KASIKATAKMKKEIGK + "$", nullable=true)
    protected String getKasikatakmkkeigkType() {
        if (kasikatakmkkeigkType == null && kasikatakmkkeigk != null) return kasikatakmkkeigk.getType().toString();
        if (kasikatakmkkeigkType == null && getKasikatakmkkeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kasikatakmkkeigk$' should not be NULL."));
        }
        return kasikatakmkkeigkType;
    }

    protected void setKasikatakmkkeigkType(String type) {
        kasikatakmkkeigkType = type;
        kasikatakmkkeigk = Optional.fromNullable(toCurrencyType(kasikatakmkkeigkType))
            .transform(bizCurrencyTransformer(getKasikatakmkkeigkValue()))
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
}