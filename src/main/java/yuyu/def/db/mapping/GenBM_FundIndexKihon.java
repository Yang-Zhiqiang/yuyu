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
import yuyu.def.db.entity.BM_FundIndexKihon;
import yuyu.def.db.id.PKBM_FundIndexKihon;
import yuyu.def.db.meta.GenQBM_FundIndexKihon;
import yuyu.def.db.meta.QBM_FundIndexKihon;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ファンドインデックス基本マスタ テーブルのマッピング情報クラスで、 {@link BM_FundIndexKihon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FundIndexKihon}</td><td colspan="3">ファンドインデックス基本マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">{@link PKBM_FundIndexKihon ○}</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr><td>{@link #getFundhyoukaymd fundhyoukaymd}</td><td>ファンド評価年月日　　　　</td><td align="center">{@link PKBM_FundIndexKihon ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getFundkaisetuymd fundkaisetuymd}</td><td>ファンド開設年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getFundindex fundindex}</td><td>ファンドインデックス</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getFundindexkeisankbn fundindexkeisankbn}</td><td>ファンドインデックス計算区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUnyoustartjisisankagaku unyoustartjisisankagaku}</td><td>運用開始時資産価額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getUnyouendjisisankagaku unyouendjisisankagaku}</td><td>運用終了時資産価額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getCfkasangosisankagaku cfkasangosisankagaku}</td><td>ＣＦ加算後資産価額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getUnyoustartjicfgaku unyoustartjicfgaku}</td><td>運用開始時ＣＦ額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getUnyoujisonekigaku unyoujisonekigaku}</td><td>運用時損益額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getUnyougocfgaku unyougocfgaku}</td><td>運用後ＣＦ額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSaiteihosyounichigaku saiteihosyounichigaku}</td><td>最低保障コスト日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSaiteihosyougekkangaku saiteihosyougekkangaku}</td><td>最低保障コスト月間累積額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkunyoustartjisisankagaku gkunyoustartjisisankagaku}</td><td>（外貨）運用開始時ＣＦ額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkunyouendjisisankagaku gkunyouendjisisankagaku}</td><td>（外貨）運用終了時資産価額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkcfkasangosisankagaku gkcfkasangosisankagaku}</td><td>（外貨）ＣＦ加算後資産価額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkunyoustartjicfgaku gkunyoustartjicfgaku}</td><td>（外貨）運用開始時ＣＦ額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkunyoujisonekigaku gkunyoujisonekigaku}</td><td>（外貨）運用時損益額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkunyougocfgaku gkunyougocfgaku}</td><td>（外貨）運用後ＣＦ額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getStarttousiganrigoukei starttousiganrigoukei}</td><td>開始初期投資元利合計残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkstarttousiganrigoukei gkstarttousiganrigoukei}</td><td>（外貨）開始初期投資元利合計残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSaisinsyokitousisegymd saisinsyokitousisegymd}</td><td>最新初期投資ＳＥＧ評価年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUnyougocfmikakuteihyouji unyougocfmikakuteihyouji}</td><td>運用後ＣＦ未確定表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_FundIndexKihon
 * @see     PKBM_FundIndexKihon
 * @see     QBM_FundIndexKihon
 * @see     GenQBM_FundIndexKihon
 */
@MappedSuperclass
@Table(name=GenBM_FundIndexKihon.TABLE_NAME)
@IdClass(value=PKBM_FundIndexKihon.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_UnitFundKbn", typeClass=UserType_C_UnitFundKbn.class)
})
public abstract class GenBM_FundIndexKihon extends AbstractExDBEntity<BM_FundIndexKihon, PKBM_FundIndexKihon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_FundIndexKihon";
    public static final String UNITFUNDKBN              = "unitfundkbn";
    public static final String FUNDHYOUKAYMD            = "fundhyoukaymd";
    public static final String FUNDKAISETUYMD           = "fundkaisetuymd";
    public static final String FUNDINDEX                = "fundindex";
    public static final String FUNDINDEXKEISANKBN       = "fundindexkeisankbn";
    public static final String UNYOUSTARTJISISANKAGAKU  = "unyoustartjisisankagaku";
    public static final String UNYOUENDJISISANKAGAKU    = "unyouendjisisankagaku";
    public static final String CFKASANGOSISANKAGAKU     = "cfkasangosisankagaku";
    public static final String UNYOUSTARTJICFGAKU       = "unyoustartjicfgaku";
    public static final String UNYOUJISONEKIGAKU        = "unyoujisonekigaku";
    public static final String UNYOUGOCFGAKU            = "unyougocfgaku";
    public static final String SAITEIHOSYOUNICHIGAKU    = "saiteihosyounichigaku";
    public static final String SAITEIHOSYOUGEKKANGAKU   = "saiteihosyougekkangaku";
    public static final String GKUNYOUSTARTJISISANKAGAKU = "gkunyoustartjisisankagaku";
    public static final String GKUNYOUENDJISISANKAGAKU  = "gkunyouendjisisankagaku";
    public static final String GKCFKASANGOSISANKAGAKU   = "gkcfkasangosisankagaku";
    public static final String GKUNYOUSTARTJICFGAKU     = "gkunyoustartjicfgaku";
    public static final String GKUNYOUJISONEKIGAKU      = "gkunyoujisonekigaku";
    public static final String GKUNYOUGOCFGAKU          = "gkunyougocfgaku";
    public static final String STARTTOUSIGANRIGOUKEI    = "starttousiganrigoukei";
    public static final String GKSTARTTOUSIGANRIGOUKEI  = "gkstarttousiganrigoukei";
    public static final String SAISINSYOKITOUSISEGYMD   = "saisinsyokitousisegymd";
    public static final String UNYOUGOCFMIKAKUTEIHYOUJI = "unyougocfmikakuteihyouji";

    private final PKBM_FundIndexKihon primaryKey;

    public GenBM_FundIndexKihon() {
        primaryKey = new PKBM_FundIndexKihon();
    }

    public GenBM_FundIndexKihon(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd) {
        primaryKey = new PKBM_FundIndexKihon(pUnitfundkbn, pFundhyoukaymd);
    }

    @Transient
    @Override
    public PKBM_FundIndexKihon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_FundIndexKihon> getMetaClass() {
        return QBM_FundIndexKihon.class;
    }

    @Id
    @Type(type="UserType_C_UnitFundKbn")
    @Column(name=GenBM_FundIndexKihon.UNITFUNDKBN)
    public C_UnitFundKbn getUnitfundkbn() {
        return getPrimaryKey().getUnitfundkbn();
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        getPrimaryKey().setUnitfundkbn(pUnitfundkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_FundIndexKihon.FUNDHYOUKAYMD)
    public BizDate getFundhyoukaymd() {
        return getPrimaryKey().getFundhyoukaymd();
    }

    public void setFundhyoukaymd(BizDate pFundhyoukaymd) {
        getPrimaryKey().setFundhyoukaymd(pFundhyoukaymd);
    }

    private BizDate fundkaisetuymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_FundIndexKihon.FUNDKAISETUYMD)
    public BizDate getFundkaisetuymd() {
        return fundkaisetuymd;
    }

    public void setFundkaisetuymd(BizDate pFundkaisetuymd) {
        fundkaisetuymd = pFundkaisetuymd;
    }

    private Double fundindex;

    @Column(name=GenBM_FundIndexKihon.FUNDINDEX)
    public Double getFundindex() {
        return fundindex;
    }

    public void setFundindex(Double pFundindex) {
        fundindex = pFundindex;
    }

    private String fundindexkeisankbn;

    @Column(name=GenBM_FundIndexKihon.FUNDINDEXKEISANKBN)
    public String getFundindexkeisankbn() {
        return fundindexkeisankbn;
    }

    public void setFundindexkeisankbn(String pFundindexkeisankbn) {
        fundindexkeisankbn = pFundindexkeisankbn;
    }

    private BizCurrency unyoustartjisisankagaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getUnyoustartjisisankagaku() {
        return unyoustartjisisankagaku;
    }

    public void setUnyoustartjisisankagaku(BizCurrency pUnyoustartjisisankagaku) {
        unyoustartjisisankagaku = pUnyoustartjisisankagaku;
        unyoustartjisisankagakuValue = null;
        unyoustartjisisankagakuType  = null;
    }

    transient private BigDecimal unyoustartjisisankagakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=UNYOUSTARTJISISANKAGAKU, nullable=true)
    protected BigDecimal getUnyoustartjisisankagakuValue() {
        if (unyoustartjisisankagakuValue == null && unyoustartjisisankagaku != null) {
            if (unyoustartjisisankagaku.isOptional()) return null;
            return unyoustartjisisankagaku.absolute();
        }
        return unyoustartjisisankagakuValue;
    }

    protected void setUnyoustartjisisankagakuValue(BigDecimal value) {
        unyoustartjisisankagakuValue = value;
        unyoustartjisisankagaku = Optional.fromNullable(toCurrencyType(unyoustartjisisankagakuType))
            .transform(bizCurrencyTransformer(getUnyoustartjisisankagakuValue()))
            .orNull();
    }

    transient private String unyoustartjisisankagakuType = null;

    @Column(name=UNYOUSTARTJISISANKAGAKU + "$", nullable=true)
    protected String getUnyoustartjisisankagakuType() {
        if (unyoustartjisisankagakuType == null && unyoustartjisisankagaku != null) return unyoustartjisisankagaku.getType().toString();
        if (unyoustartjisisankagakuType == null && getUnyoustartjisisankagakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'unyoustartjisisankagaku$' should not be NULL."));
        }
        return unyoustartjisisankagakuType;
    }

    protected void setUnyoustartjisisankagakuType(String type) {
        unyoustartjisisankagakuType = type;
        unyoustartjisisankagaku = Optional.fromNullable(toCurrencyType(unyoustartjisisankagakuType))
            .transform(bizCurrencyTransformer(getUnyoustartjisisankagakuValue()))
            .orNull();
    }

    private BizCurrency unyouendjisisankagaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getUnyouendjisisankagaku() {
        return unyouendjisisankagaku;
    }

    public void setUnyouendjisisankagaku(BizCurrency pUnyouendjisisankagaku) {
        unyouendjisisankagaku = pUnyouendjisisankagaku;
        unyouendjisisankagakuValue = null;
        unyouendjisisankagakuType  = null;
    }

    transient private BigDecimal unyouendjisisankagakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=UNYOUENDJISISANKAGAKU, nullable=true)
    protected BigDecimal getUnyouendjisisankagakuValue() {
        if (unyouendjisisankagakuValue == null && unyouendjisisankagaku != null) {
            if (unyouendjisisankagaku.isOptional()) return null;
            return unyouendjisisankagaku.absolute();
        }
        return unyouendjisisankagakuValue;
    }

    protected void setUnyouendjisisankagakuValue(BigDecimal value) {
        unyouendjisisankagakuValue = value;
        unyouendjisisankagaku = Optional.fromNullable(toCurrencyType(unyouendjisisankagakuType))
            .transform(bizCurrencyTransformer(getUnyouendjisisankagakuValue()))
            .orNull();
    }

    transient private String unyouendjisisankagakuType = null;

    @Column(name=UNYOUENDJISISANKAGAKU + "$", nullable=true)
    protected String getUnyouendjisisankagakuType() {
        if (unyouendjisisankagakuType == null && unyouendjisisankagaku != null) return unyouendjisisankagaku.getType().toString();
        if (unyouendjisisankagakuType == null && getUnyouendjisisankagakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'unyouendjisisankagaku$' should not be NULL."));
        }
        return unyouendjisisankagakuType;
    }

    protected void setUnyouendjisisankagakuType(String type) {
        unyouendjisisankagakuType = type;
        unyouendjisisankagaku = Optional.fromNullable(toCurrencyType(unyouendjisisankagakuType))
            .transform(bizCurrencyTransformer(getUnyouendjisisankagakuValue()))
            .orNull();
    }

    private BizCurrency cfkasangosisankagaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getCfkasangosisankagaku() {
        return cfkasangosisankagaku;
    }

    public void setCfkasangosisankagaku(BizCurrency pCfkasangosisankagaku) {
        cfkasangosisankagaku = pCfkasangosisankagaku;
        cfkasangosisankagakuValue = null;
        cfkasangosisankagakuType  = null;
    }

    transient private BigDecimal cfkasangosisankagakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=CFKASANGOSISANKAGAKU, nullable=true)
    protected BigDecimal getCfkasangosisankagakuValue() {
        if (cfkasangosisankagakuValue == null && cfkasangosisankagaku != null) {
            if (cfkasangosisankagaku.isOptional()) return null;
            return cfkasangosisankagaku.absolute();
        }
        return cfkasangosisankagakuValue;
    }

    protected void setCfkasangosisankagakuValue(BigDecimal value) {
        cfkasangosisankagakuValue = value;
        cfkasangosisankagaku = Optional.fromNullable(toCurrencyType(cfkasangosisankagakuType))
            .transform(bizCurrencyTransformer(getCfkasangosisankagakuValue()))
            .orNull();
    }

    transient private String cfkasangosisankagakuType = null;

    @Column(name=CFKASANGOSISANKAGAKU + "$", nullable=true)
    protected String getCfkasangosisankagakuType() {
        if (cfkasangosisankagakuType == null && cfkasangosisankagaku != null) return cfkasangosisankagaku.getType().toString();
        if (cfkasangosisankagakuType == null && getCfkasangosisankagakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'cfkasangosisankagaku$' should not be NULL."));
        }
        return cfkasangosisankagakuType;
    }

    protected void setCfkasangosisankagakuType(String type) {
        cfkasangosisankagakuType = type;
        cfkasangosisankagaku = Optional.fromNullable(toCurrencyType(cfkasangosisankagakuType))
            .transform(bizCurrencyTransformer(getCfkasangosisankagakuValue()))
            .orNull();
    }

    private BizCurrency unyoustartjicfgaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getUnyoustartjicfgaku() {
        return unyoustartjicfgaku;
    }

    public void setUnyoustartjicfgaku(BizCurrency pUnyoustartjicfgaku) {
        unyoustartjicfgaku = pUnyoustartjicfgaku;
        unyoustartjicfgakuValue = null;
        unyoustartjicfgakuType  = null;
    }

    transient private BigDecimal unyoustartjicfgakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=UNYOUSTARTJICFGAKU, nullable=true)
    protected BigDecimal getUnyoustartjicfgakuValue() {
        if (unyoustartjicfgakuValue == null && unyoustartjicfgaku != null) {
            if (unyoustartjicfgaku.isOptional()) return null;
            return unyoustartjicfgaku.absolute();
        }
        return unyoustartjicfgakuValue;
    }

    protected void setUnyoustartjicfgakuValue(BigDecimal value) {
        unyoustartjicfgakuValue = value;
        unyoustartjicfgaku = Optional.fromNullable(toCurrencyType(unyoustartjicfgakuType))
            .transform(bizCurrencyTransformer(getUnyoustartjicfgakuValue()))
            .orNull();
    }

    transient private String unyoustartjicfgakuType = null;

    @Column(name=UNYOUSTARTJICFGAKU + "$", nullable=true)
    protected String getUnyoustartjicfgakuType() {
        if (unyoustartjicfgakuType == null && unyoustartjicfgaku != null) return unyoustartjicfgaku.getType().toString();
        if (unyoustartjicfgakuType == null && getUnyoustartjicfgakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'unyoustartjicfgaku$' should not be NULL."));
        }
        return unyoustartjicfgakuType;
    }

    protected void setUnyoustartjicfgakuType(String type) {
        unyoustartjicfgakuType = type;
        unyoustartjicfgaku = Optional.fromNullable(toCurrencyType(unyoustartjicfgakuType))
            .transform(bizCurrencyTransformer(getUnyoustartjicfgakuValue()))
            .orNull();
    }

    private BizCurrency unyoujisonekigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getUnyoujisonekigaku() {
        return unyoujisonekigaku;
    }

    public void setUnyoujisonekigaku(BizCurrency pUnyoujisonekigaku) {
        unyoujisonekigaku = pUnyoujisonekigaku;
        unyoujisonekigakuValue = null;
        unyoujisonekigakuType  = null;
    }

    transient private BigDecimal unyoujisonekigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=UNYOUJISONEKIGAKU, nullable=true)
    protected BigDecimal getUnyoujisonekigakuValue() {
        if (unyoujisonekigakuValue == null && unyoujisonekigaku != null) {
            if (unyoujisonekigaku.isOptional()) return null;
            return unyoujisonekigaku.absolute();
        }
        return unyoujisonekigakuValue;
    }

    protected void setUnyoujisonekigakuValue(BigDecimal value) {
        unyoujisonekigakuValue = value;
        unyoujisonekigaku = Optional.fromNullable(toCurrencyType(unyoujisonekigakuType))
            .transform(bizCurrencyTransformer(getUnyoujisonekigakuValue()))
            .orNull();
    }

    transient private String unyoujisonekigakuType = null;

    @Column(name=UNYOUJISONEKIGAKU + "$", nullable=true)
    protected String getUnyoujisonekigakuType() {
        if (unyoujisonekigakuType == null && unyoujisonekigaku != null) return unyoujisonekigaku.getType().toString();
        if (unyoujisonekigakuType == null && getUnyoujisonekigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'unyoujisonekigaku$' should not be NULL."));
        }
        return unyoujisonekigakuType;
    }

    protected void setUnyoujisonekigakuType(String type) {
        unyoujisonekigakuType = type;
        unyoujisonekigaku = Optional.fromNullable(toCurrencyType(unyoujisonekigakuType))
            .transform(bizCurrencyTransformer(getUnyoujisonekigakuValue()))
            .orNull();
    }

    private BizCurrency unyougocfgaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getUnyougocfgaku() {
        return unyougocfgaku;
    }

    public void setUnyougocfgaku(BizCurrency pUnyougocfgaku) {
        unyougocfgaku = pUnyougocfgaku;
        unyougocfgakuValue = null;
        unyougocfgakuType  = null;
    }

    transient private BigDecimal unyougocfgakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=UNYOUGOCFGAKU, nullable=true)
    protected BigDecimal getUnyougocfgakuValue() {
        if (unyougocfgakuValue == null && unyougocfgaku != null) {
            if (unyougocfgaku.isOptional()) return null;
            return unyougocfgaku.absolute();
        }
        return unyougocfgakuValue;
    }

    protected void setUnyougocfgakuValue(BigDecimal value) {
        unyougocfgakuValue = value;
        unyougocfgaku = Optional.fromNullable(toCurrencyType(unyougocfgakuType))
            .transform(bizCurrencyTransformer(getUnyougocfgakuValue()))
            .orNull();
    }

    transient private String unyougocfgakuType = null;

    @Column(name=UNYOUGOCFGAKU + "$", nullable=true)
    protected String getUnyougocfgakuType() {
        if (unyougocfgakuType == null && unyougocfgaku != null) return unyougocfgaku.getType().toString();
        if (unyougocfgakuType == null && getUnyougocfgakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'unyougocfgaku$' should not be NULL."));
        }
        return unyougocfgakuType;
    }

    protected void setUnyougocfgakuType(String type) {
        unyougocfgakuType = type;
        unyougocfgaku = Optional.fromNullable(toCurrencyType(unyougocfgakuType))
            .transform(bizCurrencyTransformer(getUnyougocfgakuValue()))
            .orNull();
    }

    private BizCurrency saiteihosyounichigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSaiteihosyounichigaku() {
        return saiteihosyounichigaku;
    }

    public void setSaiteihosyounichigaku(BizCurrency pSaiteihosyounichigaku) {
        saiteihosyounichigaku = pSaiteihosyounichigaku;
        saiteihosyounichigakuValue = null;
        saiteihosyounichigakuType  = null;
    }

    transient private BigDecimal saiteihosyounichigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SAITEIHOSYOUNICHIGAKU, nullable=true)
    protected BigDecimal getSaiteihosyounichigakuValue() {
        if (saiteihosyounichigakuValue == null && saiteihosyounichigaku != null) {
            if (saiteihosyounichigaku.isOptional()) return null;
            return saiteihosyounichigaku.absolute();
        }
        return saiteihosyounichigakuValue;
    }

    protected void setSaiteihosyounichigakuValue(BigDecimal value) {
        saiteihosyounichigakuValue = value;
        saiteihosyounichigaku = Optional.fromNullable(toCurrencyType(saiteihosyounichigakuType))
            .transform(bizCurrencyTransformer(getSaiteihosyounichigakuValue()))
            .orNull();
    }

    transient private String saiteihosyounichigakuType = null;

    @Column(name=SAITEIHOSYOUNICHIGAKU + "$", nullable=true)
    protected String getSaiteihosyounichigakuType() {
        if (saiteihosyounichigakuType == null && saiteihosyounichigaku != null) return saiteihosyounichigaku.getType().toString();
        if (saiteihosyounichigakuType == null && getSaiteihosyounichigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'saiteihosyounichigaku$' should not be NULL."));
        }
        return saiteihosyounichigakuType;
    }

    protected void setSaiteihosyounichigakuType(String type) {
        saiteihosyounichigakuType = type;
        saiteihosyounichigaku = Optional.fromNullable(toCurrencyType(saiteihosyounichigakuType))
            .transform(bizCurrencyTransformer(getSaiteihosyounichigakuValue()))
            .orNull();
    }

    private BizCurrency saiteihosyougekkangaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSaiteihosyougekkangaku() {
        return saiteihosyougekkangaku;
    }

    public void setSaiteihosyougekkangaku(BizCurrency pSaiteihosyougekkangaku) {
        saiteihosyougekkangaku = pSaiteihosyougekkangaku;
        saiteihosyougekkangakuValue = null;
        saiteihosyougekkangakuType  = null;
    }

    transient private BigDecimal saiteihosyougekkangakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SAITEIHOSYOUGEKKANGAKU, nullable=true)
    protected BigDecimal getSaiteihosyougekkangakuValue() {
        if (saiteihosyougekkangakuValue == null && saiteihosyougekkangaku != null) {
            if (saiteihosyougekkangaku.isOptional()) return null;
            return saiteihosyougekkangaku.absolute();
        }
        return saiteihosyougekkangakuValue;
    }

    protected void setSaiteihosyougekkangakuValue(BigDecimal value) {
        saiteihosyougekkangakuValue = value;
        saiteihosyougekkangaku = Optional.fromNullable(toCurrencyType(saiteihosyougekkangakuType))
            .transform(bizCurrencyTransformer(getSaiteihosyougekkangakuValue()))
            .orNull();
    }

    transient private String saiteihosyougekkangakuType = null;

    @Column(name=SAITEIHOSYOUGEKKANGAKU + "$", nullable=true)
    protected String getSaiteihosyougekkangakuType() {
        if (saiteihosyougekkangakuType == null && saiteihosyougekkangaku != null) return saiteihosyougekkangaku.getType().toString();
        if (saiteihosyougekkangakuType == null && getSaiteihosyougekkangakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'saiteihosyougekkangaku$' should not be NULL."));
        }
        return saiteihosyougekkangakuType;
    }

    protected void setSaiteihosyougekkangakuType(String type) {
        saiteihosyougekkangakuType = type;
        saiteihosyougekkangaku = Optional.fromNullable(toCurrencyType(saiteihosyougekkangakuType))
            .transform(bizCurrencyTransformer(getSaiteihosyougekkangakuValue()))
            .orNull();
    }

    private BizCurrency gkunyoustartjisisankagaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkunyoustartjisisankagaku() {
        return gkunyoustartjisisankagaku;
    }

    public void setGkunyoustartjisisankagaku(BizCurrency pGkunyoustartjisisankagaku) {
        gkunyoustartjisisankagaku = pGkunyoustartjisisankagaku;
        gkunyoustartjisisankagakuValue = null;
        gkunyoustartjisisankagakuType  = null;
    }

    transient private BigDecimal gkunyoustartjisisankagakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKUNYOUSTARTJISISANKAGAKU, nullable=true)
    protected BigDecimal getGkunyoustartjisisankagakuValue() {
        if (gkunyoustartjisisankagakuValue == null && gkunyoustartjisisankagaku != null) {
            if (gkunyoustartjisisankagaku.isOptional()) return null;
            return gkunyoustartjisisankagaku.absolute();
        }
        return gkunyoustartjisisankagakuValue;
    }

    protected void setGkunyoustartjisisankagakuValue(BigDecimal value) {
        gkunyoustartjisisankagakuValue = value;
        gkunyoustartjisisankagaku = Optional.fromNullable(toCurrencyType(gkunyoustartjisisankagakuType))
            .transform(bizCurrencyTransformer(getGkunyoustartjisisankagakuValue()))
            .orNull();
    }

    transient private String gkunyoustartjisisankagakuType = null;

    @Column(name=GKUNYOUSTARTJISISANKAGAKU + "$", nullable=true)
    protected String getGkunyoustartjisisankagakuType() {
        if (gkunyoustartjisisankagakuType == null && gkunyoustartjisisankagaku != null) return gkunyoustartjisisankagaku.getType().toString();
        if (gkunyoustartjisisankagakuType == null && getGkunyoustartjisisankagakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkunyoustartjisisankagaku$' should not be NULL."));
        }
        return gkunyoustartjisisankagakuType;
    }

    protected void setGkunyoustartjisisankagakuType(String type) {
        gkunyoustartjisisankagakuType = type;
        gkunyoustartjisisankagaku = Optional.fromNullable(toCurrencyType(gkunyoustartjisisankagakuType))
            .transform(bizCurrencyTransformer(getGkunyoustartjisisankagakuValue()))
            .orNull();
    }

    private BizCurrency gkunyouendjisisankagaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkunyouendjisisankagaku() {
        return gkunyouendjisisankagaku;
    }

    public void setGkunyouendjisisankagaku(BizCurrency pGkunyouendjisisankagaku) {
        gkunyouendjisisankagaku = pGkunyouendjisisankagaku;
        gkunyouendjisisankagakuValue = null;
        gkunyouendjisisankagakuType  = null;
    }

    transient private BigDecimal gkunyouendjisisankagakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKUNYOUENDJISISANKAGAKU, nullable=true)
    protected BigDecimal getGkunyouendjisisankagakuValue() {
        if (gkunyouendjisisankagakuValue == null && gkunyouendjisisankagaku != null) {
            if (gkunyouendjisisankagaku.isOptional()) return null;
            return gkunyouendjisisankagaku.absolute();
        }
        return gkunyouendjisisankagakuValue;
    }

    protected void setGkunyouendjisisankagakuValue(BigDecimal value) {
        gkunyouendjisisankagakuValue = value;
        gkunyouendjisisankagaku = Optional.fromNullable(toCurrencyType(gkunyouendjisisankagakuType))
            .transform(bizCurrencyTransformer(getGkunyouendjisisankagakuValue()))
            .orNull();
    }

    transient private String gkunyouendjisisankagakuType = null;

    @Column(name=GKUNYOUENDJISISANKAGAKU + "$", nullable=true)
    protected String getGkunyouendjisisankagakuType() {
        if (gkunyouendjisisankagakuType == null && gkunyouendjisisankagaku != null) return gkunyouendjisisankagaku.getType().toString();
        if (gkunyouendjisisankagakuType == null && getGkunyouendjisisankagakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkunyouendjisisankagaku$' should not be NULL."));
        }
        return gkunyouendjisisankagakuType;
    }

    protected void setGkunyouendjisisankagakuType(String type) {
        gkunyouendjisisankagakuType = type;
        gkunyouendjisisankagaku = Optional.fromNullable(toCurrencyType(gkunyouendjisisankagakuType))
            .transform(bizCurrencyTransformer(getGkunyouendjisisankagakuValue()))
            .orNull();
    }

    private BizCurrency gkcfkasangosisankagaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkcfkasangosisankagaku() {
        return gkcfkasangosisankagaku;
    }

    public void setGkcfkasangosisankagaku(BizCurrency pGkcfkasangosisankagaku) {
        gkcfkasangosisankagaku = pGkcfkasangosisankagaku;
        gkcfkasangosisankagakuValue = null;
        gkcfkasangosisankagakuType  = null;
    }

    transient private BigDecimal gkcfkasangosisankagakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKCFKASANGOSISANKAGAKU, nullable=true)
    protected BigDecimal getGkcfkasangosisankagakuValue() {
        if (gkcfkasangosisankagakuValue == null && gkcfkasangosisankagaku != null) {
            if (gkcfkasangosisankagaku.isOptional()) return null;
            return gkcfkasangosisankagaku.absolute();
        }
        return gkcfkasangosisankagakuValue;
    }

    protected void setGkcfkasangosisankagakuValue(BigDecimal value) {
        gkcfkasangosisankagakuValue = value;
        gkcfkasangosisankagaku = Optional.fromNullable(toCurrencyType(gkcfkasangosisankagakuType))
            .transform(bizCurrencyTransformer(getGkcfkasangosisankagakuValue()))
            .orNull();
    }

    transient private String gkcfkasangosisankagakuType = null;

    @Column(name=GKCFKASANGOSISANKAGAKU + "$", nullable=true)
    protected String getGkcfkasangosisankagakuType() {
        if (gkcfkasangosisankagakuType == null && gkcfkasangosisankagaku != null) return gkcfkasangosisankagaku.getType().toString();
        if (gkcfkasangosisankagakuType == null && getGkcfkasangosisankagakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkcfkasangosisankagaku$' should not be NULL."));
        }
        return gkcfkasangosisankagakuType;
    }

    protected void setGkcfkasangosisankagakuType(String type) {
        gkcfkasangosisankagakuType = type;
        gkcfkasangosisankagaku = Optional.fromNullable(toCurrencyType(gkcfkasangosisankagakuType))
            .transform(bizCurrencyTransformer(getGkcfkasangosisankagakuValue()))
            .orNull();
    }

    private BizCurrency gkunyoustartjicfgaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkunyoustartjicfgaku() {
        return gkunyoustartjicfgaku;
    }

    public void setGkunyoustartjicfgaku(BizCurrency pGkunyoustartjicfgaku) {
        gkunyoustartjicfgaku = pGkunyoustartjicfgaku;
        gkunyoustartjicfgakuValue = null;
        gkunyoustartjicfgakuType  = null;
    }

    transient private BigDecimal gkunyoustartjicfgakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKUNYOUSTARTJICFGAKU, nullable=true)
    protected BigDecimal getGkunyoustartjicfgakuValue() {
        if (gkunyoustartjicfgakuValue == null && gkunyoustartjicfgaku != null) {
            if (gkunyoustartjicfgaku.isOptional()) return null;
            return gkunyoustartjicfgaku.absolute();
        }
        return gkunyoustartjicfgakuValue;
    }

    protected void setGkunyoustartjicfgakuValue(BigDecimal value) {
        gkunyoustartjicfgakuValue = value;
        gkunyoustartjicfgaku = Optional.fromNullable(toCurrencyType(gkunyoustartjicfgakuType))
            .transform(bizCurrencyTransformer(getGkunyoustartjicfgakuValue()))
            .orNull();
    }

    transient private String gkunyoustartjicfgakuType = null;

    @Column(name=GKUNYOUSTARTJICFGAKU + "$", nullable=true)
    protected String getGkunyoustartjicfgakuType() {
        if (gkunyoustartjicfgakuType == null && gkunyoustartjicfgaku != null) return gkunyoustartjicfgaku.getType().toString();
        if (gkunyoustartjicfgakuType == null && getGkunyoustartjicfgakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkunyoustartjicfgaku$' should not be NULL."));
        }
        return gkunyoustartjicfgakuType;
    }

    protected void setGkunyoustartjicfgakuType(String type) {
        gkunyoustartjicfgakuType = type;
        gkunyoustartjicfgaku = Optional.fromNullable(toCurrencyType(gkunyoustartjicfgakuType))
            .transform(bizCurrencyTransformer(getGkunyoustartjicfgakuValue()))
            .orNull();
    }

    private BizCurrency gkunyoujisonekigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkunyoujisonekigaku() {
        return gkunyoujisonekigaku;
    }

    public void setGkunyoujisonekigaku(BizCurrency pGkunyoujisonekigaku) {
        gkunyoujisonekigaku = pGkunyoujisonekigaku;
        gkunyoujisonekigakuValue = null;
        gkunyoujisonekigakuType  = null;
    }

    transient private BigDecimal gkunyoujisonekigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKUNYOUJISONEKIGAKU, nullable=true)
    protected BigDecimal getGkunyoujisonekigakuValue() {
        if (gkunyoujisonekigakuValue == null && gkunyoujisonekigaku != null) {
            if (gkunyoujisonekigaku.isOptional()) return null;
            return gkunyoujisonekigaku.absolute();
        }
        return gkunyoujisonekigakuValue;
    }

    protected void setGkunyoujisonekigakuValue(BigDecimal value) {
        gkunyoujisonekigakuValue = value;
        gkunyoujisonekigaku = Optional.fromNullable(toCurrencyType(gkunyoujisonekigakuType))
            .transform(bizCurrencyTransformer(getGkunyoujisonekigakuValue()))
            .orNull();
    }

    transient private String gkunyoujisonekigakuType = null;

    @Column(name=GKUNYOUJISONEKIGAKU + "$", nullable=true)
    protected String getGkunyoujisonekigakuType() {
        if (gkunyoujisonekigakuType == null && gkunyoujisonekigaku != null) return gkunyoujisonekigaku.getType().toString();
        if (gkunyoujisonekigakuType == null && getGkunyoujisonekigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkunyoujisonekigaku$' should not be NULL."));
        }
        return gkunyoujisonekigakuType;
    }

    protected void setGkunyoujisonekigakuType(String type) {
        gkunyoujisonekigakuType = type;
        gkunyoujisonekigaku = Optional.fromNullable(toCurrencyType(gkunyoujisonekigakuType))
            .transform(bizCurrencyTransformer(getGkunyoujisonekigakuValue()))
            .orNull();
    }

    private BizCurrency gkunyougocfgaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkunyougocfgaku() {
        return gkunyougocfgaku;
    }

    public void setGkunyougocfgaku(BizCurrency pGkunyougocfgaku) {
        gkunyougocfgaku = pGkunyougocfgaku;
        gkunyougocfgakuValue = null;
        gkunyougocfgakuType  = null;
    }

    transient private BigDecimal gkunyougocfgakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKUNYOUGOCFGAKU, nullable=true)
    protected BigDecimal getGkunyougocfgakuValue() {
        if (gkunyougocfgakuValue == null && gkunyougocfgaku != null) {
            if (gkunyougocfgaku.isOptional()) return null;
            return gkunyougocfgaku.absolute();
        }
        return gkunyougocfgakuValue;
    }

    protected void setGkunyougocfgakuValue(BigDecimal value) {
        gkunyougocfgakuValue = value;
        gkunyougocfgaku = Optional.fromNullable(toCurrencyType(gkunyougocfgakuType))
            .transform(bizCurrencyTransformer(getGkunyougocfgakuValue()))
            .orNull();
    }

    transient private String gkunyougocfgakuType = null;

    @Column(name=GKUNYOUGOCFGAKU + "$", nullable=true)
    protected String getGkunyougocfgakuType() {
        if (gkunyougocfgakuType == null && gkunyougocfgaku != null) return gkunyougocfgaku.getType().toString();
        if (gkunyougocfgakuType == null && getGkunyougocfgakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkunyougocfgaku$' should not be NULL."));
        }
        return gkunyougocfgakuType;
    }

    protected void setGkunyougocfgakuType(String type) {
        gkunyougocfgakuType = type;
        gkunyougocfgaku = Optional.fromNullable(toCurrencyType(gkunyougocfgakuType))
            .transform(bizCurrencyTransformer(getGkunyougocfgakuValue()))
            .orNull();
    }

    private BizCurrency starttousiganrigoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getStarttousiganrigoukei() {
        return starttousiganrigoukei;
    }

    public void setStarttousiganrigoukei(BizCurrency pStarttousiganrigoukei) {
        starttousiganrigoukei = pStarttousiganrigoukei;
        starttousiganrigoukeiValue = null;
        starttousiganrigoukeiType  = null;
    }

    transient private BigDecimal starttousiganrigoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=STARTTOUSIGANRIGOUKEI, nullable=true)
    protected BigDecimal getStarttousiganrigoukeiValue() {
        if (starttousiganrigoukeiValue == null && starttousiganrigoukei != null) {
            if (starttousiganrigoukei.isOptional()) return null;
            return starttousiganrigoukei.absolute();
        }
        return starttousiganrigoukeiValue;
    }

    protected void setStarttousiganrigoukeiValue(BigDecimal value) {
        starttousiganrigoukeiValue = value;
        starttousiganrigoukei = Optional.fromNullable(toCurrencyType(starttousiganrigoukeiType))
            .transform(bizCurrencyTransformer(getStarttousiganrigoukeiValue()))
            .orNull();
    }

    transient private String starttousiganrigoukeiType = null;

    @Column(name=STARTTOUSIGANRIGOUKEI + "$", nullable=true)
    protected String getStarttousiganrigoukeiType() {
        if (starttousiganrigoukeiType == null && starttousiganrigoukei != null) return starttousiganrigoukei.getType().toString();
        if (starttousiganrigoukeiType == null && getStarttousiganrigoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'starttousiganrigoukei$' should not be NULL."));
        }
        return starttousiganrigoukeiType;
    }

    protected void setStarttousiganrigoukeiType(String type) {
        starttousiganrigoukeiType = type;
        starttousiganrigoukei = Optional.fromNullable(toCurrencyType(starttousiganrigoukeiType))
            .transform(bizCurrencyTransformer(getStarttousiganrigoukeiValue()))
            .orNull();
    }

    private BizCurrency gkstarttousiganrigoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkstarttousiganrigoukei() {
        return gkstarttousiganrigoukei;
    }

    public void setGkstarttousiganrigoukei(BizCurrency pGkstarttousiganrigoukei) {
        gkstarttousiganrigoukei = pGkstarttousiganrigoukei;
        gkstarttousiganrigoukeiValue = null;
        gkstarttousiganrigoukeiType  = null;
    }

    transient private BigDecimal gkstarttousiganrigoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKSTARTTOUSIGANRIGOUKEI, nullable=true)
    protected BigDecimal getGkstarttousiganrigoukeiValue() {
        if (gkstarttousiganrigoukeiValue == null && gkstarttousiganrigoukei != null) {
            if (gkstarttousiganrigoukei.isOptional()) return null;
            return gkstarttousiganrigoukei.absolute();
        }
        return gkstarttousiganrigoukeiValue;
    }

    protected void setGkstarttousiganrigoukeiValue(BigDecimal value) {
        gkstarttousiganrigoukeiValue = value;
        gkstarttousiganrigoukei = Optional.fromNullable(toCurrencyType(gkstarttousiganrigoukeiType))
            .transform(bizCurrencyTransformer(getGkstarttousiganrigoukeiValue()))
            .orNull();
    }

    transient private String gkstarttousiganrigoukeiType = null;

    @Column(name=GKSTARTTOUSIGANRIGOUKEI + "$", nullable=true)
    protected String getGkstarttousiganrigoukeiType() {
        if (gkstarttousiganrigoukeiType == null && gkstarttousiganrigoukei != null) return gkstarttousiganrigoukei.getType().toString();
        if (gkstarttousiganrigoukeiType == null && getGkstarttousiganrigoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkstarttousiganrigoukei$' should not be NULL."));
        }
        return gkstarttousiganrigoukeiType;
    }

    protected void setGkstarttousiganrigoukeiType(String type) {
        gkstarttousiganrigoukeiType = type;
        gkstarttousiganrigoukei = Optional.fromNullable(toCurrencyType(gkstarttousiganrigoukeiType))
            .transform(bizCurrencyTransformer(getGkstarttousiganrigoukeiValue()))
            .orNull();
    }

    private BizDate saisinsyokitousisegymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_FundIndexKihon.SAISINSYOKITOUSISEGYMD)
    public BizDate getSaisinsyokitousisegymd() {
        return saisinsyokitousisegymd;
    }

    public void setSaisinsyokitousisegymd(BizDate pSaisinsyokitousisegymd) {
        saisinsyokitousisegymd = pSaisinsyokitousisegymd;
    }

    private String unyougocfmikakuteihyouji;

    @Column(name=GenBM_FundIndexKihon.UNYOUGOCFMIKAKUTEIHYOUJI)
    public String getUnyougocfmikakuteihyouji() {
        return unyougocfmikakuteihyouji;
    }

    public void setUnyougocfmikakuteihyouji(String pUnyougocfmikakuteihyouji) {
        unyougocfmikakuteihyouji = pUnyougocfmikakuteihyouji;
    }
}
