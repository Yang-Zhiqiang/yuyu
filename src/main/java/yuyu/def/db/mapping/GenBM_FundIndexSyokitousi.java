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
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexSyokitousi;
import yuyu.def.db.id.PKBM_FundIndexSyokitousi;
import yuyu.def.db.meta.GenQBM_FundIndexSyokitousi;
import yuyu.def.db.meta.QBM_FundIndexSyokitousi;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ファンドインデックス初期投資マスタ テーブルのマッピング情報クラスで、 {@link BM_FundIndexSyokitousi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FundIndexSyokitousi}</td><td colspan="3">ファンドインデックス初期投資マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">{@link PKBM_FundIndexSyokitousi ○}</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr><td>{@link #getFundhyoukaymd fundhyoukaymd}</td><td>ファンド評価年月日　　　　</td><td align="center">{@link PKBM_FundIndexSyokitousi ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSegkey segkey}</td><td>ＳＥＧＫＥＹ　　　　　　　　</td><td align="center">{@link PKBM_FundIndexSyokitousi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyokisegsakuseijiyuu syokisegsakuseijiyuu}</td><td>初期投資ＳＥＧ作成事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyokitousisetteigaku syokitousisetteigaku}</td><td>初期投資設定額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyokigoukeihensaigaku syokigoukeihensaigaku}</td><td>初期投資合計返済額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyokirisokuhensaigaku syokirisokuhensaigaku}</td><td>初期投資利息返済額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyokigankinhensaigaku syokigankinhensaigaku}</td><td>初期投資元金返済額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyokitousirisoku syokitousirisoku}</td><td>初期投資利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyokigankinkuriiregaku syokigankinkuriiregaku}</td><td>初期投資元金繰入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGksyokitousisetteigaku gksyokitousisetteigaku}</td><td>（外貨）初期投資設定額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGksyokigoukeihensaigaku gksyokigoukeihensaigaku}</td><td>（外貨）初期投資合計返済額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGksyokirisokuhensaigaku gksyokirisokuhensaigaku}</td><td>（外貨）初期投資利息返済額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGksyokigankinhensaigaku gksyokigankinhensaigaku}</td><td>（外貨）初期投資元金返済額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGksyokitousirisoku gksyokitousirisoku}</td><td>（外貨）初期投資利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGksyokigankinkuriiregaku gksyokigankinkuriiregaku}</td><td>（外貨）初期投資元金繰入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyokitousigankinkrirkbn syokitousigankinkrirkbn}</td><td>初期投資元金繰入区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenkaistsegsakuseiymd zenkaistsegsakuseiymd}</td><td>前回初期投資ＳＥＧ作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BM_FundIndexSyokitousi
 * @see     PKBM_FundIndexSyokitousi
 * @see     QBM_FundIndexSyokitousi
 * @see     GenQBM_FundIndexSyokitousi
 */
@MappedSuperclass
@Table(name=GenBM_FundIndexSyokitousi.TABLE_NAME)
@IdClass(value=PKBM_FundIndexSyokitousi.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_UnitFundKbn", typeClass=UserType_C_UnitFundKbn.class)
})
public abstract class GenBM_FundIndexSyokitousi extends AbstractExDBEntity<BM_FundIndexSyokitousi, PKBM_FundIndexSyokitousi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_FundIndexSyokitousi";
    public static final String UNITFUNDKBN              = "unitfundkbn";
    public static final String FUNDHYOUKAYMD            = "fundhyoukaymd";
    public static final String SEGKEY                   = "segkey";
    public static final String SYOKISEGSAKUSEIJIYUU     = "syokisegsakuseijiyuu";
    public static final String SYOKITOUSISETTEIGAKU     = "syokitousisetteigaku";
    public static final String SYOKIGOUKEIHENSAIGAKU    = "syokigoukeihensaigaku";
    public static final String SYOKIRISOKUHENSAIGAKU    = "syokirisokuhensaigaku";
    public static final String SYOKIGANKINHENSAIGAKU    = "syokigankinhensaigaku";
    public static final String SYOKITOUSIRISOKU         = "syokitousirisoku";
    public static final String SYOKIGANKINKURIIREGAKU   = "syokigankinkuriiregaku";
    public static final String GKSYOKITOUSISETTEIGAKU   = "gksyokitousisetteigaku";
    public static final String GKSYOKIGOUKEIHENSAIGAKU  = "gksyokigoukeihensaigaku";
    public static final String GKSYOKIRISOKUHENSAIGAKU  = "gksyokirisokuhensaigaku";
    public static final String GKSYOKIGANKINHENSAIGAKU  = "gksyokigankinhensaigaku";
    public static final String GKSYOKITOUSIRISOKU       = "gksyokitousirisoku";
    public static final String GKSYOKIGANKINKURIIREGAKU = "gksyokigankinkuriiregaku";
    public static final String SYOKITOUSIGANKINKRIRKBN  = "syokitousigankinkrirkbn";
    public static final String ZENKAISTSEGSAKUSEIYMD    = "zenkaistsegsakuseiymd";

    private final PKBM_FundIndexSyokitousi primaryKey;

    public GenBM_FundIndexSyokitousi() {
        primaryKey = new PKBM_FundIndexSyokitousi();
    }

    public GenBM_FundIndexSyokitousi(
        C_UnitFundKbn pUnitfundkbn,
        BizDate pFundhyoukaymd,
        String pSegkey
    ) {
        primaryKey = new PKBM_FundIndexSyokitousi(
            pUnitfundkbn,
            pFundhyoukaymd,
            pSegkey
        );
    }

    @Transient
    @Override
    public PKBM_FundIndexSyokitousi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_FundIndexSyokitousi> getMetaClass() {
        return QBM_FundIndexSyokitousi.class;
    }

    @Id
    @Type(type="UserType_C_UnitFundKbn")
    @Column(name=GenBM_FundIndexSyokitousi.UNITFUNDKBN)
    public C_UnitFundKbn getUnitfundkbn() {
        return getPrimaryKey().getUnitfundkbn();
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        getPrimaryKey().setUnitfundkbn(pUnitfundkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_FundIndexSyokitousi.FUNDHYOUKAYMD)
    public BizDate getFundhyoukaymd() {
        return getPrimaryKey().getFundhyoukaymd();
    }

    public void setFundhyoukaymd(BizDate pFundhyoukaymd) {
        getPrimaryKey().setFundhyoukaymd(pFundhyoukaymd);
    }

    @Id
    @Column(name=GenBM_FundIndexSyokitousi.SEGKEY)
    public String getSegkey() {
        return getPrimaryKey().getSegkey();
    }

    public void setSegkey(String pSegkey) {
        getPrimaryKey().setSegkey(pSegkey);
    }

    private String syokisegsakuseijiyuu;

    @Column(name=GenBM_FundIndexSyokitousi.SYOKISEGSAKUSEIJIYUU)
    public String getSyokisegsakuseijiyuu() {
        return syokisegsakuseijiyuu;
    }

    public void setSyokisegsakuseijiyuu(String pSyokisegsakuseijiyuu) {
        syokisegsakuseijiyuu = pSyokisegsakuseijiyuu;
    }

    private BizCurrency syokitousisetteigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyokitousisetteigaku() {
        return syokitousisetteigaku;
    }

    public void setSyokitousisetteigaku(BizCurrency pSyokitousisetteigaku) {
        syokitousisetteigaku = pSyokitousisetteigaku;
        syokitousisetteigakuValue = null;
        syokitousisetteigakuType  = null;
    }

    transient private BigDecimal syokitousisetteigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYOKITOUSISETTEIGAKU, nullable=true)
    protected BigDecimal getSyokitousisetteigakuValue() {
        if (syokitousisetteigakuValue == null && syokitousisetteigaku != null) {
            if (syokitousisetteigaku.isOptional()) return null;
            return syokitousisetteigaku.absolute();
        }
        return syokitousisetteigakuValue;
    }

    protected void setSyokitousisetteigakuValue(BigDecimal value) {
        syokitousisetteigakuValue = value;
        syokitousisetteigaku = Optional.fromNullable(toCurrencyType(syokitousisetteigakuType))
            .transform(bizCurrencyTransformer(getSyokitousisetteigakuValue()))
            .orNull();
    }

    transient private String syokitousisetteigakuType = null;

    @Column(name=SYOKITOUSISETTEIGAKU + "$", nullable=true)
    protected String getSyokitousisetteigakuType() {
        if (syokitousisetteigakuType == null && syokitousisetteigaku != null) return syokitousisetteigaku.getType().toString();
        if (syokitousisetteigakuType == null && getSyokitousisetteigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syokitousisetteigaku$' should not be NULL."));
        }
        return syokitousisetteigakuType;
    }

    protected void setSyokitousisetteigakuType(String type) {
        syokitousisetteigakuType = type;
        syokitousisetteigaku = Optional.fromNullable(toCurrencyType(syokitousisetteigakuType))
            .transform(bizCurrencyTransformer(getSyokitousisetteigakuValue()))
            .orNull();
    }

    private BizCurrency syokigoukeihensaigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyokigoukeihensaigaku() {
        return syokigoukeihensaigaku;
    }

    public void setSyokigoukeihensaigaku(BizCurrency pSyokigoukeihensaigaku) {
        syokigoukeihensaigaku = pSyokigoukeihensaigaku;
        syokigoukeihensaigakuValue = null;
        syokigoukeihensaigakuType  = null;
    }

    transient private BigDecimal syokigoukeihensaigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYOKIGOUKEIHENSAIGAKU, nullable=true)
    protected BigDecimal getSyokigoukeihensaigakuValue() {
        if (syokigoukeihensaigakuValue == null && syokigoukeihensaigaku != null) {
            if (syokigoukeihensaigaku.isOptional()) return null;
            return syokigoukeihensaigaku.absolute();
        }
        return syokigoukeihensaigakuValue;
    }

    protected void setSyokigoukeihensaigakuValue(BigDecimal value) {
        syokigoukeihensaigakuValue = value;
        syokigoukeihensaigaku = Optional.fromNullable(toCurrencyType(syokigoukeihensaigakuType))
            .transform(bizCurrencyTransformer(getSyokigoukeihensaigakuValue()))
            .orNull();
    }

    transient private String syokigoukeihensaigakuType = null;

    @Column(name=SYOKIGOUKEIHENSAIGAKU + "$", nullable=true)
    protected String getSyokigoukeihensaigakuType() {
        if (syokigoukeihensaigakuType == null && syokigoukeihensaigaku != null) return syokigoukeihensaigaku.getType().toString();
        if (syokigoukeihensaigakuType == null && getSyokigoukeihensaigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syokigoukeihensaigaku$' should not be NULL."));
        }
        return syokigoukeihensaigakuType;
    }

    protected void setSyokigoukeihensaigakuType(String type) {
        syokigoukeihensaigakuType = type;
        syokigoukeihensaigaku = Optional.fromNullable(toCurrencyType(syokigoukeihensaigakuType))
            .transform(bizCurrencyTransformer(getSyokigoukeihensaigakuValue()))
            .orNull();
    }

    private BizCurrency syokirisokuhensaigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyokirisokuhensaigaku() {
        return syokirisokuhensaigaku;
    }

    public void setSyokirisokuhensaigaku(BizCurrency pSyokirisokuhensaigaku) {
        syokirisokuhensaigaku = pSyokirisokuhensaigaku;
        syokirisokuhensaigakuValue = null;
        syokirisokuhensaigakuType  = null;
    }

    transient private BigDecimal syokirisokuhensaigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYOKIRISOKUHENSAIGAKU, nullable=true)
    protected BigDecimal getSyokirisokuhensaigakuValue() {
        if (syokirisokuhensaigakuValue == null && syokirisokuhensaigaku != null) {
            if (syokirisokuhensaigaku.isOptional()) return null;
            return syokirisokuhensaigaku.absolute();
        }
        return syokirisokuhensaigakuValue;
    }

    protected void setSyokirisokuhensaigakuValue(BigDecimal value) {
        syokirisokuhensaigakuValue = value;
        syokirisokuhensaigaku = Optional.fromNullable(toCurrencyType(syokirisokuhensaigakuType))
            .transform(bizCurrencyTransformer(getSyokirisokuhensaigakuValue()))
            .orNull();
    }

    transient private String syokirisokuhensaigakuType = null;

    @Column(name=SYOKIRISOKUHENSAIGAKU + "$", nullable=true)
    protected String getSyokirisokuhensaigakuType() {
        if (syokirisokuhensaigakuType == null && syokirisokuhensaigaku != null) return syokirisokuhensaigaku.getType().toString();
        if (syokirisokuhensaigakuType == null && getSyokirisokuhensaigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syokirisokuhensaigaku$' should not be NULL."));
        }
        return syokirisokuhensaigakuType;
    }

    protected void setSyokirisokuhensaigakuType(String type) {
        syokirisokuhensaigakuType = type;
        syokirisokuhensaigaku = Optional.fromNullable(toCurrencyType(syokirisokuhensaigakuType))
            .transform(bizCurrencyTransformer(getSyokirisokuhensaigakuValue()))
            .orNull();
    }

    private BizCurrency syokigankinhensaigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyokigankinhensaigaku() {
        return syokigankinhensaigaku;
    }

    public void setSyokigankinhensaigaku(BizCurrency pSyokigankinhensaigaku) {
        syokigankinhensaigaku = pSyokigankinhensaigaku;
        syokigankinhensaigakuValue = null;
        syokigankinhensaigakuType  = null;
    }

    transient private BigDecimal syokigankinhensaigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYOKIGANKINHENSAIGAKU, nullable=true)
    protected BigDecimal getSyokigankinhensaigakuValue() {
        if (syokigankinhensaigakuValue == null && syokigankinhensaigaku != null) {
            if (syokigankinhensaigaku.isOptional()) return null;
            return syokigankinhensaigaku.absolute();
        }
        return syokigankinhensaigakuValue;
    }

    protected void setSyokigankinhensaigakuValue(BigDecimal value) {
        syokigankinhensaigakuValue = value;
        syokigankinhensaigaku = Optional.fromNullable(toCurrencyType(syokigankinhensaigakuType))
            .transform(bizCurrencyTransformer(getSyokigankinhensaigakuValue()))
            .orNull();
    }

    transient private String syokigankinhensaigakuType = null;

    @Column(name=SYOKIGANKINHENSAIGAKU + "$", nullable=true)
    protected String getSyokigankinhensaigakuType() {
        if (syokigankinhensaigakuType == null && syokigankinhensaigaku != null) return syokigankinhensaigaku.getType().toString();
        if (syokigankinhensaigakuType == null && getSyokigankinhensaigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syokigankinhensaigaku$' should not be NULL."));
        }
        return syokigankinhensaigakuType;
    }

    protected void setSyokigankinhensaigakuType(String type) {
        syokigankinhensaigakuType = type;
        syokigankinhensaigaku = Optional.fromNullable(toCurrencyType(syokigankinhensaigakuType))
            .transform(bizCurrencyTransformer(getSyokigankinhensaigakuValue()))
            .orNull();
    }

    private BizCurrency syokitousirisoku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyokitousirisoku() {
        return syokitousirisoku;
    }

    public void setSyokitousirisoku(BizCurrency pSyokitousirisoku) {
        syokitousirisoku = pSyokitousirisoku;
        syokitousirisokuValue = null;
        syokitousirisokuType  = null;
    }

    transient private BigDecimal syokitousirisokuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYOKITOUSIRISOKU, nullable=true)
    protected BigDecimal getSyokitousirisokuValue() {
        if (syokitousirisokuValue == null && syokitousirisoku != null) {
            if (syokitousirisoku.isOptional()) return null;
            return syokitousirisoku.absolute();
        }
        return syokitousirisokuValue;
    }

    protected void setSyokitousirisokuValue(BigDecimal value) {
        syokitousirisokuValue = value;
        syokitousirisoku = Optional.fromNullable(toCurrencyType(syokitousirisokuType))
            .transform(bizCurrencyTransformer(getSyokitousirisokuValue()))
            .orNull();
    }

    transient private String syokitousirisokuType = null;

    @Column(name=SYOKITOUSIRISOKU + "$", nullable=true)
    protected String getSyokitousirisokuType() {
        if (syokitousirisokuType == null && syokitousirisoku != null) return syokitousirisoku.getType().toString();
        if (syokitousirisokuType == null && getSyokitousirisokuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syokitousirisoku$' should not be NULL."));
        }
        return syokitousirisokuType;
    }

    protected void setSyokitousirisokuType(String type) {
        syokitousirisokuType = type;
        syokitousirisoku = Optional.fromNullable(toCurrencyType(syokitousirisokuType))
            .transform(bizCurrencyTransformer(getSyokitousirisokuValue()))
            .orNull();
    }

    private BizCurrency syokigankinkuriiregaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyokigankinkuriiregaku() {
        return syokigankinkuriiregaku;
    }

    public void setSyokigankinkuriiregaku(BizCurrency pSyokigankinkuriiregaku) {
        syokigankinkuriiregaku = pSyokigankinkuriiregaku;
        syokigankinkuriiregakuValue = null;
        syokigankinkuriiregakuType  = null;
    }

    transient private BigDecimal syokigankinkuriiregakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYOKIGANKINKURIIREGAKU, nullable=true)
    protected BigDecimal getSyokigankinkuriiregakuValue() {
        if (syokigankinkuriiregakuValue == null && syokigankinkuriiregaku != null) {
            if (syokigankinkuriiregaku.isOptional()) return null;
            return syokigankinkuriiregaku.absolute();
        }
        return syokigankinkuriiregakuValue;
    }

    protected void setSyokigankinkuriiregakuValue(BigDecimal value) {
        syokigankinkuriiregakuValue = value;
        syokigankinkuriiregaku = Optional.fromNullable(toCurrencyType(syokigankinkuriiregakuType))
            .transform(bizCurrencyTransformer(getSyokigankinkuriiregakuValue()))
            .orNull();
    }

    transient private String syokigankinkuriiregakuType = null;

    @Column(name=SYOKIGANKINKURIIREGAKU + "$", nullable=true)
    protected String getSyokigankinkuriiregakuType() {
        if (syokigankinkuriiregakuType == null && syokigankinkuriiregaku != null) return syokigankinkuriiregaku.getType().toString();
        if (syokigankinkuriiregakuType == null && getSyokigankinkuriiregakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syokigankinkuriiregaku$' should not be NULL."));
        }
        return syokigankinkuriiregakuType;
    }

    protected void setSyokigankinkuriiregakuType(String type) {
        syokigankinkuriiregakuType = type;
        syokigankinkuriiregaku = Optional.fromNullable(toCurrencyType(syokigankinkuriiregakuType))
            .transform(bizCurrencyTransformer(getSyokigankinkuriiregakuValue()))
            .orNull();
    }

    private BizCurrency gksyokitousisetteigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGksyokitousisetteigaku() {
        return gksyokitousisetteigaku;
    }

    public void setGksyokitousisetteigaku(BizCurrency pGksyokitousisetteigaku) {
        gksyokitousisetteigaku = pGksyokitousisetteigaku;
        gksyokitousisetteigakuValue = null;
        gksyokitousisetteigakuType  = null;
    }

    transient private BigDecimal gksyokitousisetteigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKSYOKITOUSISETTEIGAKU, nullable=true)
    protected BigDecimal getGksyokitousisetteigakuValue() {
        if (gksyokitousisetteigakuValue == null && gksyokitousisetteigaku != null) {
            if (gksyokitousisetteigaku.isOptional()) return null;
            return gksyokitousisetteigaku.absolute();
        }
        return gksyokitousisetteigakuValue;
    }

    protected void setGksyokitousisetteigakuValue(BigDecimal value) {
        gksyokitousisetteigakuValue = value;
        gksyokitousisetteigaku = Optional.fromNullable(toCurrencyType(gksyokitousisetteigakuType))
            .transform(bizCurrencyTransformer(getGksyokitousisetteigakuValue()))
            .orNull();
    }

    transient private String gksyokitousisetteigakuType = null;

    @Column(name=GKSYOKITOUSISETTEIGAKU + "$", nullable=true)
    protected String getGksyokitousisetteigakuType() {
        if (gksyokitousisetteigakuType == null && gksyokitousisetteigaku != null) return gksyokitousisetteigaku.getType().toString();
        if (gksyokitousisetteigakuType == null && getGksyokitousisetteigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gksyokitousisetteigaku$' should not be NULL."));
        }
        return gksyokitousisetteigakuType;
    }

    protected void setGksyokitousisetteigakuType(String type) {
        gksyokitousisetteigakuType = type;
        gksyokitousisetteigaku = Optional.fromNullable(toCurrencyType(gksyokitousisetteigakuType))
            .transform(bizCurrencyTransformer(getGksyokitousisetteigakuValue()))
            .orNull();
    }

    private BizCurrency gksyokigoukeihensaigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGksyokigoukeihensaigaku() {
        return gksyokigoukeihensaigaku;
    }

    public void setGksyokigoukeihensaigaku(BizCurrency pGksyokigoukeihensaigaku) {
        gksyokigoukeihensaigaku = pGksyokigoukeihensaigaku;
        gksyokigoukeihensaigakuValue = null;
        gksyokigoukeihensaigakuType  = null;
    }

    transient private BigDecimal gksyokigoukeihensaigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKSYOKIGOUKEIHENSAIGAKU, nullable=true)
    protected BigDecimal getGksyokigoukeihensaigakuValue() {
        if (gksyokigoukeihensaigakuValue == null && gksyokigoukeihensaigaku != null) {
            if (gksyokigoukeihensaigaku.isOptional()) return null;
            return gksyokigoukeihensaigaku.absolute();
        }
        return gksyokigoukeihensaigakuValue;
    }

    protected void setGksyokigoukeihensaigakuValue(BigDecimal value) {
        gksyokigoukeihensaigakuValue = value;
        gksyokigoukeihensaigaku = Optional.fromNullable(toCurrencyType(gksyokigoukeihensaigakuType))
            .transform(bizCurrencyTransformer(getGksyokigoukeihensaigakuValue()))
            .orNull();
    }

    transient private String gksyokigoukeihensaigakuType = null;

    @Column(name=GKSYOKIGOUKEIHENSAIGAKU + "$", nullable=true)
    protected String getGksyokigoukeihensaigakuType() {
        if (gksyokigoukeihensaigakuType == null && gksyokigoukeihensaigaku != null) return gksyokigoukeihensaigaku.getType().toString();
        if (gksyokigoukeihensaigakuType == null && getGksyokigoukeihensaigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gksyokigoukeihensaigaku$' should not be NULL."));
        }
        return gksyokigoukeihensaigakuType;
    }

    protected void setGksyokigoukeihensaigakuType(String type) {
        gksyokigoukeihensaigakuType = type;
        gksyokigoukeihensaigaku = Optional.fromNullable(toCurrencyType(gksyokigoukeihensaigakuType))
            .transform(bizCurrencyTransformer(getGksyokigoukeihensaigakuValue()))
            .orNull();
    }

    private BizCurrency gksyokirisokuhensaigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGksyokirisokuhensaigaku() {
        return gksyokirisokuhensaigaku;
    }

    public void setGksyokirisokuhensaigaku(BizCurrency pGksyokirisokuhensaigaku) {
        gksyokirisokuhensaigaku = pGksyokirisokuhensaigaku;
        gksyokirisokuhensaigakuValue = null;
        gksyokirisokuhensaigakuType  = null;
    }

    transient private BigDecimal gksyokirisokuhensaigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKSYOKIRISOKUHENSAIGAKU, nullable=true)
    protected BigDecimal getGksyokirisokuhensaigakuValue() {
        if (gksyokirisokuhensaigakuValue == null && gksyokirisokuhensaigaku != null) {
            if (gksyokirisokuhensaigaku.isOptional()) return null;
            return gksyokirisokuhensaigaku.absolute();
        }
        return gksyokirisokuhensaigakuValue;
    }

    protected void setGksyokirisokuhensaigakuValue(BigDecimal value) {
        gksyokirisokuhensaigakuValue = value;
        gksyokirisokuhensaigaku = Optional.fromNullable(toCurrencyType(gksyokirisokuhensaigakuType))
            .transform(bizCurrencyTransformer(getGksyokirisokuhensaigakuValue()))
            .orNull();
    }

    transient private String gksyokirisokuhensaigakuType = null;

    @Column(name=GKSYOKIRISOKUHENSAIGAKU + "$", nullable=true)
    protected String getGksyokirisokuhensaigakuType() {
        if (gksyokirisokuhensaigakuType == null && gksyokirisokuhensaigaku != null) return gksyokirisokuhensaigaku.getType().toString();
        if (gksyokirisokuhensaigakuType == null && getGksyokirisokuhensaigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gksyokirisokuhensaigaku$' should not be NULL."));
        }
        return gksyokirisokuhensaigakuType;
    }

    protected void setGksyokirisokuhensaigakuType(String type) {
        gksyokirisokuhensaigakuType = type;
        gksyokirisokuhensaigaku = Optional.fromNullable(toCurrencyType(gksyokirisokuhensaigakuType))
            .transform(bizCurrencyTransformer(getGksyokirisokuhensaigakuValue()))
            .orNull();
    }

    private BizCurrency gksyokigankinhensaigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGksyokigankinhensaigaku() {
        return gksyokigankinhensaigaku;
    }

    public void setGksyokigankinhensaigaku(BizCurrency pGksyokigankinhensaigaku) {
        gksyokigankinhensaigaku = pGksyokigankinhensaigaku;
        gksyokigankinhensaigakuValue = null;
        gksyokigankinhensaigakuType  = null;
    }

    transient private BigDecimal gksyokigankinhensaigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKSYOKIGANKINHENSAIGAKU, nullable=true)
    protected BigDecimal getGksyokigankinhensaigakuValue() {
        if (gksyokigankinhensaigakuValue == null && gksyokigankinhensaigaku != null) {
            if (gksyokigankinhensaigaku.isOptional()) return null;
            return gksyokigankinhensaigaku.absolute();
        }
        return gksyokigankinhensaigakuValue;
    }

    protected void setGksyokigankinhensaigakuValue(BigDecimal value) {
        gksyokigankinhensaigakuValue = value;
        gksyokigankinhensaigaku = Optional.fromNullable(toCurrencyType(gksyokigankinhensaigakuType))
            .transform(bizCurrencyTransformer(getGksyokigankinhensaigakuValue()))
            .orNull();
    }

    transient private String gksyokigankinhensaigakuType = null;

    @Column(name=GKSYOKIGANKINHENSAIGAKU + "$", nullable=true)
    protected String getGksyokigankinhensaigakuType() {
        if (gksyokigankinhensaigakuType == null && gksyokigankinhensaigaku != null) return gksyokigankinhensaigaku.getType().toString();
        if (gksyokigankinhensaigakuType == null && getGksyokigankinhensaigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gksyokigankinhensaigaku$' should not be NULL."));
        }
        return gksyokigankinhensaigakuType;
    }

    protected void setGksyokigankinhensaigakuType(String type) {
        gksyokigankinhensaigakuType = type;
        gksyokigankinhensaigaku = Optional.fromNullable(toCurrencyType(gksyokigankinhensaigakuType))
            .transform(bizCurrencyTransformer(getGksyokigankinhensaigakuValue()))
            .orNull();
    }

    private BizCurrency gksyokitousirisoku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGksyokitousirisoku() {
        return gksyokitousirisoku;
    }

    public void setGksyokitousirisoku(BizCurrency pGksyokitousirisoku) {
        gksyokitousirisoku = pGksyokitousirisoku;
        gksyokitousirisokuValue = null;
        gksyokitousirisokuType  = null;
    }

    transient private BigDecimal gksyokitousirisokuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKSYOKITOUSIRISOKU, nullable=true)
    protected BigDecimal getGksyokitousirisokuValue() {
        if (gksyokitousirisokuValue == null && gksyokitousirisoku != null) {
            if (gksyokitousirisoku.isOptional()) return null;
            return gksyokitousirisoku.absolute();
        }
        return gksyokitousirisokuValue;
    }

    protected void setGksyokitousirisokuValue(BigDecimal value) {
        gksyokitousirisokuValue = value;
        gksyokitousirisoku = Optional.fromNullable(toCurrencyType(gksyokitousirisokuType))
            .transform(bizCurrencyTransformer(getGksyokitousirisokuValue()))
            .orNull();
    }

    transient private String gksyokitousirisokuType = null;

    @Column(name=GKSYOKITOUSIRISOKU + "$", nullable=true)
    protected String getGksyokitousirisokuType() {
        if (gksyokitousirisokuType == null && gksyokitousirisoku != null) return gksyokitousirisoku.getType().toString();
        if (gksyokitousirisokuType == null && getGksyokitousirisokuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gksyokitousirisoku$' should not be NULL."));
        }
        return gksyokitousirisokuType;
    }

    protected void setGksyokitousirisokuType(String type) {
        gksyokitousirisokuType = type;
        gksyokitousirisoku = Optional.fromNullable(toCurrencyType(gksyokitousirisokuType))
            .transform(bizCurrencyTransformer(getGksyokitousirisokuValue()))
            .orNull();
    }

    private BizCurrency gksyokigankinkuriiregaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGksyokigankinkuriiregaku() {
        return gksyokigankinkuriiregaku;
    }

    public void setGksyokigankinkuriiregaku(BizCurrency pGksyokigankinkuriiregaku) {
        gksyokigankinkuriiregaku = pGksyokigankinkuriiregaku;
        gksyokigankinkuriiregakuValue = null;
        gksyokigankinkuriiregakuType  = null;
    }

    transient private BigDecimal gksyokigankinkuriiregakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKSYOKIGANKINKURIIREGAKU, nullable=true)
    protected BigDecimal getGksyokigankinkuriiregakuValue() {
        if (gksyokigankinkuriiregakuValue == null && gksyokigankinkuriiregaku != null) {
            if (gksyokigankinkuriiregaku.isOptional()) return null;
            return gksyokigankinkuriiregaku.absolute();
        }
        return gksyokigankinkuriiregakuValue;
    }

    protected void setGksyokigankinkuriiregakuValue(BigDecimal value) {
        gksyokigankinkuriiregakuValue = value;
        gksyokigankinkuriiregaku = Optional.fromNullable(toCurrencyType(gksyokigankinkuriiregakuType))
            .transform(bizCurrencyTransformer(getGksyokigankinkuriiregakuValue()))
            .orNull();
    }

    transient private String gksyokigankinkuriiregakuType = null;

    @Column(name=GKSYOKIGANKINKURIIREGAKU + "$", nullable=true)
    protected String getGksyokigankinkuriiregakuType() {
        if (gksyokigankinkuriiregakuType == null && gksyokigankinkuriiregaku != null) return gksyokigankinkuriiregaku.getType().toString();
        if (gksyokigankinkuriiregakuType == null && getGksyokigankinkuriiregakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gksyokigankinkuriiregaku$' should not be NULL."));
        }
        return gksyokigankinkuriiregakuType;
    }

    protected void setGksyokigankinkuriiregakuType(String type) {
        gksyokigankinkuriiregakuType = type;
        gksyokigankinkuriiregaku = Optional.fromNullable(toCurrencyType(gksyokigankinkuriiregakuType))
            .transform(bizCurrencyTransformer(getGksyokigankinkuriiregakuValue()))
            .orNull();
    }

    private String syokitousigankinkrirkbn;

    @Column(name=GenBM_FundIndexSyokitousi.SYOKITOUSIGANKINKRIRKBN)
    public String getSyokitousigankinkrirkbn() {
        return syokitousigankinkrirkbn;
    }

    public void setSyokitousigankinkrirkbn(String pSyokitousigankinkrirkbn) {
        syokitousigankinkrirkbn = pSyokitousigankinkrirkbn;
    }

    private BizDate zenkaistsegsakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_FundIndexSyokitousi.ZENKAISTSEGSAKUSEIYMD)
    public BizDate getZenkaistsegsakuseiymd() {
        return zenkaistsegsakuseiymd;
    }

    public void setZenkaistsegsakuseiymd(BizDate pZenkaistsegsakuseiymd) {
        zenkaistsegsakuseiymd = pZenkaistsegsakuseiymd;
    }
}
