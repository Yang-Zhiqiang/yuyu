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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.number.BizCurrency;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_HjybruikeigakuTeisei;
import yuyu.def.db.id.PKBT_HjybruikeigakuTeisei;
import yuyu.def.db.meta.GenQBT_HjybruikeigakuTeisei;
import yuyu.def.db.meta.QBT_HjybruikeigakuTeisei;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;

/**
 * 補助簿累計額訂正テーブル テーブルのマッピング情報クラスで、 {@link BT_HjybruikeigakuTeisei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HjybruikeigakuTeisei}</td><td colspan="3">補助簿累計額訂正テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHjybruigkteiseitantositucd hjybruigkteiseitantositucd}</td><td>補助簿累計額訂正担当室コード</td><td align="center">{@link PKBT_HjybruikeigakuTeisei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">{@link PKBT_HjybruikeigakuTeisei ○}</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKasikatateiseigk kasikatateiseigk}</td><td>貸方訂正額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKarikatateiseigk karikatateiseigk}</td><td>借方訂正額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_HjybruikeigakuTeisei
 * @see     PKBT_HjybruikeigakuTeisei
 * @see     QBT_HjybruikeigakuTeisei
 * @see     GenQBT_HjybruikeigakuTeisei
 */
@MappedSuperclass
@Table(name=GenBT_HjybruikeigakuTeisei.TABLE_NAME)
@IdClass(value=PKBT_HjybruikeigakuTeisei.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class)
})
public abstract class GenBT_HjybruikeigakuTeisei extends AbstractExDBEntity<BT_HjybruikeigakuTeisei, PKBT_HjybruikeigakuTeisei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_HjybruikeigakuTeisei";
    public static final String HJYBRUIGKTEISEITANTOSITUCD = "hjybruigkteiseitantositucd";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String KASIKATATEISEIGK         = "kasikatateiseigk";
    public static final String KARIKATATEISEIGK         = "karikatateiseigk";

    private final PKBT_HjybruikeigakuTeisei primaryKey;

    public GenBT_HjybruikeigakuTeisei() {
        primaryKey = new PKBT_HjybruikeigakuTeisei();
    }

    public GenBT_HjybruikeigakuTeisei(String pHjybruigkteiseitantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {
        primaryKey = new PKBT_HjybruikeigakuTeisei(pHjybruigkteiseitantositucd, pKanjyoukmkcd);
    }

    @Transient
    @Override
    public PKBT_HjybruikeigakuTeisei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_HjybruikeigakuTeisei> getMetaClass() {
        return QBT_HjybruikeigakuTeisei.class;
    }

    @Id
    @Column(name=GenBT_HjybruikeigakuTeisei.HJYBRUIGKTEISEITANTOSITUCD)
    public String getHjybruigkteiseitantositucd() {
        return getPrimaryKey().getHjybruigkteiseitantositucd();
    }

    public void setHjybruigkteiseitantositucd(String pHjybruigkteiseitantositucd) {
        getPrimaryKey().setHjybruigkteiseitantositucd(pHjybruigkteiseitantositucd);
    }

    @Id
    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_HjybruikeigakuTeisei.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return getPrimaryKey().getKanjyoukmkcd();
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        getPrimaryKey().setKanjyoukmkcd(pKanjyoukmkcd);
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
}