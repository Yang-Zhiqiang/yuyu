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
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.number.BizCurrency;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_Hjyblist;
import yuyu.def.db.id.PKBT_Hjyblist;
import yuyu.def.db.meta.GenQBT_Hjyblist;
import yuyu.def.db.meta.QBT_Hjyblist;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;

/**
 * 補助簿リスト用テーブル テーブルのマッピング情報クラスで、 {@link BT_Hjyblist} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_Hjyblist}</td><td colspan="3">補助簿リスト用テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHjybtantositucd hjybtantositucd}</td><td>補助簿統括担当室コード</td><td align="center">{@link PKBT_Hjyblist ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">{@link PKBT_Hjyblist ○}</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getSyorisyokantantcd syorisyokantantcd}</td><td>処理所管担当室コード</td><td align="center">{@link PKBT_Hjyblist ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">{@link PKBT_Hjyblist ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKarikatagk karikatagk}</td><td>借方金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKasikatagk kasikatagk}</td><td>貸方金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_Hjyblist
 * @see     PKBT_Hjyblist
 * @see     QBT_Hjyblist
 * @see     GenQBT_Hjyblist
 */
@MappedSuperclass
@Table(name=GenBT_Hjyblist.TABLE_NAME)
@IdClass(value=PKBT_Hjyblist.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class)
})
public abstract class GenBT_Hjyblist extends AbstractExDBEntity<BT_Hjyblist, PKBT_Hjyblist> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_Hjyblist";
    public static final String HJYBTANTOSITUCD          = "hjybtantositucd";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String SYORISYOKANTANTCD        = "syorisyokantantcd";
    public static final String DENYMD                   = "denymd";
    public static final String KARIKATAGK               = "karikatagk";
    public static final String KASIKATAGK               = "kasikatagk";

    private final PKBT_Hjyblist primaryKey;

    public GenBT_Hjyblist() {
        primaryKey = new PKBT_Hjyblist();
    }

    public GenBT_Hjyblist(
        String pHjybtantositucd,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        String pSyorisyokantantcd,
        BizDate pDenymd
    ) {
        primaryKey = new PKBT_Hjyblist(
            pHjybtantositucd,
            pKanjyoukmkcd,
            pSyorisyokantantcd,
            pDenymd
        );
    }

    @Transient
    @Override
    public PKBT_Hjyblist getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_Hjyblist> getMetaClass() {
        return QBT_Hjyblist.class;
    }

    @Id
    @Column(name=GenBT_Hjyblist.HJYBTANTOSITUCD)
    public String getHjybtantositucd() {
        return getPrimaryKey().getHjybtantositucd();
    }

    public void setHjybtantositucd(String pHjybtantositucd) {
        getPrimaryKey().setHjybtantositucd(pHjybtantositucd);
    }

    @Id
    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_Hjyblist.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return getPrimaryKey().getKanjyoukmkcd();
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        getPrimaryKey().setKanjyoukmkcd(pKanjyoukmkcd);
    }

    @Id
    @Column(name=GenBT_Hjyblist.SYORISYOKANTANTCD)
    public String getSyorisyokantantcd() {
        return getPrimaryKey().getSyorisyokantantcd();
    }

    public void setSyorisyokantantcd(String pSyorisyokantantcd) {
        getPrimaryKey().setSyorisyokantantcd(pSyorisyokantantcd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_Hjyblist.DENYMD)
    public BizDate getDenymd() {
        return getPrimaryKey().getDenymd();
    }

    public void setDenymd(BizDate pDenymd) {
        getPrimaryKey().setDenymd(pDenymd);
    }

    private BizCurrency karikatagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKarikatagk() {
        return karikatagk;
    }

    public void setKarikatagk(BizCurrency pKarikatagk) {
        karikatagk = pKarikatagk;
        karikatagkValue = null;
        karikatagkType  = null;
    }

    transient private BigDecimal karikatagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIKATAGK, nullable=true)
    protected BigDecimal getKarikatagkValue() {
        if (karikatagkValue == null && karikatagk != null) {
            if (karikatagk.isOptional()) return null;
            return karikatagk.absolute();
        }
        return karikatagkValue;
    }

    protected void setKarikatagkValue(BigDecimal value) {
        karikatagkValue = value;
        karikatagk = Optional.fromNullable(toCurrencyType(karikatagkType))
            .transform(bizCurrencyTransformer(getKarikatagkValue()))
            .orNull();
    }

    transient private String karikatagkType = null;

    @Column(name=KARIKATAGK + "$", nullable=true)
    protected String getKarikatagkType() {
        if (karikatagkType == null && karikatagk != null) return karikatagk.getType().toString();
        if (karikatagkType == null && getKarikatagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'karikatagk$' should not be NULL."));
        }
        return karikatagkType;
    }

    protected void setKarikatagkType(String type) {
        karikatagkType = type;
        karikatagk = Optional.fromNullable(toCurrencyType(karikatagkType))
            .transform(bizCurrencyTransformer(getKarikatagkValue()))
            .orNull();
    }

    private BizCurrency kasikatagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKasikatagk() {
        return kasikatagk;
    }

    public void setKasikatagk(BizCurrency pKasikatagk) {
        kasikatagk = pKasikatagk;
        kasikatagkValue = null;
        kasikatagkType  = null;
    }

    transient private BigDecimal kasikatagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KASIKATAGK, nullable=true)
    protected BigDecimal getKasikatagkValue() {
        if (kasikatagkValue == null && kasikatagk != null) {
            if (kasikatagk.isOptional()) return null;
            return kasikatagk.absolute();
        }
        return kasikatagkValue;
    }

    protected void setKasikatagkValue(BigDecimal value) {
        kasikatagkValue = value;
        kasikatagk = Optional.fromNullable(toCurrencyType(kasikatagkType))
            .transform(bizCurrencyTransformer(getKasikatagkValue()))
            .orNull();
    }

    transient private String kasikatagkType = null;

    @Column(name=KASIKATAGK + "$", nullable=true)
    protected String getKasikatagkType() {
        if (kasikatagkType == null && kasikatagk != null) return kasikatagk.getType().toString();
        if (kasikatagkType == null && getKasikatagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kasikatagk$' should not be NULL."));
        }
        return kasikatagkType;
    }

    protected void setKasikatagkType(String type) {
        kasikatagkType = type;
        kasikatagk = Optional.fromNullable(toCurrencyType(kasikatagkType))
            .transform(bizCurrencyTransformer(getKasikatagkValue()))
            .orNull();
    }
}