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
import yuyu.def.db.entity.BM_FundIndexGetumatuCf;
import yuyu.def.db.id.PKBM_FundIndexGetumatuCf;
import yuyu.def.db.meta.GenQBM_FundIndexGetumatuCf;
import yuyu.def.db.meta.QBM_FundIndexGetumatuCf;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ファンドインデックス月末ＣＦマスタ テーブルのマッピング情報クラスで、 {@link BM_FundIndexGetumatuCf} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FundIndexGetumatuCf}</td><td colspan="3">ファンドインデックス月末ＣＦマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">{@link PKBM_FundIndexGetumatuCf ○}</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr><td>{@link #getFundhyoukaymd fundhyoukaymd}</td><td>ファンド評価年月日　　　　</td><td align="center">{@link PKBM_FundIndexGetumatuCf ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSegkey segkey}</td><td>ＳＥＧＫＥＹ　　　　　　　　</td><td align="center">{@link PKBM_FundIndexGetumatuCf ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGmcfhknknkigahurikaegaku gmcfhknknkigahurikaegaku}</td><td>月末ＣＦ保険関係ＧＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkgmcfhknknkigahurikaegaku gkgmcfhknknkigahurikaegaku}</td><td>（外貨）月末ＣＦ保険関係ＧＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGmcfsakanrihigahurikaegaku gmcfsakanrihigahurikaegaku}</td><td>月末ＣＦＳＡ管理費ＧＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGmsthscstgahurikaegaku gmsthscstgahurikaegaku}</td><td>月末最低保障コストＧＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGmroanfundgahurikaegaku gmroanfundgahurikaegaku}</td><td>月末ローンファンドＧＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGmcfhkkksahurikaegaku gmcfhkkksahurikaegaku}</td><td>月末ＣＦ保険関係ＳＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkgmcfhkkksahurikaegaku gkgmcfhkkksahurikaegaku}</td><td>（外貨）月末ＣＦ保険関係ＳＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGmroanfundsahurikaegaku gmroanfundsahurikaegaku}</td><td>月末ローンファンドＳＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGmhokencvgoukeigaku gmhokencvgoukeigaku}</td><td>月末保険ＣＶ合計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkgmhokencvgoukeigaku gkgmhokencvgoukeigaku}</td><td>（外貨）月末保険ＣＶ合計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGmsktsganrigoukeizandaka gmsktsganrigoukeizandaka}</td><td>月末初期投資元利合計残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkgmsktsganrigoukeizandaka gkgmsktsganrigoukeizandaka}</td><td>（外貨）月末初期投資元利合計残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGmmihurikaesousatugaku gmmihurikaesousatugaku}</td><td>月末未振替相殺額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkgmmihurikaesousatugaku gkgmmihurikaesousatugaku}</td><td>（外貨）月末未振替相殺額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_FundIndexGetumatuCf
 * @see     PKBM_FundIndexGetumatuCf
 * @see     QBM_FundIndexGetumatuCf
 * @see     GenQBM_FundIndexGetumatuCf
 */
@MappedSuperclass
@Table(name=GenBM_FundIndexGetumatuCf.TABLE_NAME)
@IdClass(value=PKBM_FundIndexGetumatuCf.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_UnitFundKbn", typeClass=UserType_C_UnitFundKbn.class)
})
public abstract class GenBM_FundIndexGetumatuCf extends AbstractExDBEntity<BM_FundIndexGetumatuCf, PKBM_FundIndexGetumatuCf> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_FundIndexGetumatuCf";
    public static final String UNITFUNDKBN              = "unitfundkbn";
    public static final String FUNDHYOUKAYMD            = "fundhyoukaymd";
    public static final String SEGKEY                   = "segkey";
    public static final String GMCFHKNKNKIGAHURIKAEGAKU = "gmcfhknknkigahurikaegaku";
    public static final String GKGMCFHKNKNKIGAHURIKAEGAKU = "gkgmcfhknknkigahurikaegaku";
    public static final String GMCFSAKANRIHIGAHURIKAEGAKU = "gmcfsakanrihigahurikaegaku";
    public static final String GMSTHSCSTGAHURIKAEGAKU   = "gmsthscstgahurikaegaku";
    public static final String GMROANFUNDGAHURIKAEGAKU  = "gmroanfundgahurikaegaku";
    public static final String GMCFHKKKSAHURIKAEGAKU    = "gmcfhkkksahurikaegaku";
    public static final String GKGMCFHKKKSAHURIKAEGAKU  = "gkgmcfhkkksahurikaegaku";
    public static final String GMROANFUNDSAHURIKAEGAKU  = "gmroanfundsahurikaegaku";
    public static final String GMHOKENCVGOUKEIGAKU      = "gmhokencvgoukeigaku";
    public static final String GKGMHOKENCVGOUKEIGAKU    = "gkgmhokencvgoukeigaku";
    public static final String GMSKTSGANRIGOUKEIZANDAKA = "gmsktsganrigoukeizandaka";
    public static final String GKGMSKTSGANRIGOUKEIZANDAKA = "gkgmsktsganrigoukeizandaka";
    public static final String GMMIHURIKAESOUSATUGAKU   = "gmmihurikaesousatugaku";
    public static final String GKGMMIHURIKAESOUSATUGAKU = "gkgmmihurikaesousatugaku";

    private final PKBM_FundIndexGetumatuCf primaryKey;

    public GenBM_FundIndexGetumatuCf() {
        primaryKey = new PKBM_FundIndexGetumatuCf();
    }

    public GenBM_FundIndexGetumatuCf(
        C_UnitFundKbn pUnitfundkbn,
        BizDate pFundhyoukaymd,
        String pSegkey
    ) {
        primaryKey = new PKBM_FundIndexGetumatuCf(
            pUnitfundkbn,
            pFundhyoukaymd,
            pSegkey
        );
    }

    @Transient
    @Override
    public PKBM_FundIndexGetumatuCf getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_FundIndexGetumatuCf> getMetaClass() {
        return QBM_FundIndexGetumatuCf.class;
    }

    @Id
    @Type(type="UserType_C_UnitFundKbn")
    @Column(name=GenBM_FundIndexGetumatuCf.UNITFUNDKBN)
    public C_UnitFundKbn getUnitfundkbn() {
        return getPrimaryKey().getUnitfundkbn();
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        getPrimaryKey().setUnitfundkbn(pUnitfundkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_FundIndexGetumatuCf.FUNDHYOUKAYMD)
    public BizDate getFundhyoukaymd() {
        return getPrimaryKey().getFundhyoukaymd();
    }

    public void setFundhyoukaymd(BizDate pFundhyoukaymd) {
        getPrimaryKey().setFundhyoukaymd(pFundhyoukaymd);
    }

    @Id
    @Column(name=GenBM_FundIndexGetumatuCf.SEGKEY)
    public String getSegkey() {
        return getPrimaryKey().getSegkey();
    }

    public void setSegkey(String pSegkey) {
        getPrimaryKey().setSegkey(pSegkey);
    }

    private BizCurrency gmcfhknknkigahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGmcfhknknkigahurikaegaku() {
        return gmcfhknknkigahurikaegaku;
    }

    public void setGmcfhknknkigahurikaegaku(BizCurrency pGmcfhknknkigahurikaegaku) {
        gmcfhknknkigahurikaegaku = pGmcfhknknkigahurikaegaku;
        gmcfhknknkigahurikaegakuValue = null;
        gmcfhknknkigahurikaegakuType  = null;
    }

    transient private BigDecimal gmcfhknknkigahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GMCFHKNKNKIGAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGmcfhknknkigahurikaegakuValue() {
        if (gmcfhknknkigahurikaegakuValue == null && gmcfhknknkigahurikaegaku != null) {
            if (gmcfhknknkigahurikaegaku.isOptional()) return null;
            return gmcfhknknkigahurikaegaku.absolute();
        }
        return gmcfhknknkigahurikaegakuValue;
    }

    protected void setGmcfhknknkigahurikaegakuValue(BigDecimal value) {
        gmcfhknknkigahurikaegakuValue = value;
        gmcfhknknkigahurikaegaku = Optional.fromNullable(toCurrencyType(gmcfhknknkigahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmcfhknknkigahurikaegakuValue()))
            .orNull();
    }

    transient private String gmcfhknknkigahurikaegakuType = null;

    @Column(name=GMCFHKNKNKIGAHURIKAEGAKU + "$", nullable=true)
    protected String getGmcfhknknkigahurikaegakuType() {
        if (gmcfhknknkigahurikaegakuType == null && gmcfhknknkigahurikaegaku != null) return gmcfhknknkigahurikaegaku.getType().toString();
        if (gmcfhknknkigahurikaegakuType == null && getGmcfhknknkigahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gmcfhknknkigahurikaegaku$' should not be NULL."));
        }
        return gmcfhknknkigahurikaegakuType;
    }

    protected void setGmcfhknknkigahurikaegakuType(String type) {
        gmcfhknknkigahurikaegakuType = type;
        gmcfhknknkigahurikaegaku = Optional.fromNullable(toCurrencyType(gmcfhknknkigahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmcfhknknkigahurikaegakuValue()))
            .orNull();
    }

    private BizCurrency gkgmcfhknknkigahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkgmcfhknknkigahurikaegaku() {
        return gkgmcfhknknkigahurikaegaku;
    }

    public void setGkgmcfhknknkigahurikaegaku(BizCurrency pGkgmcfhknknkigahurikaegaku) {
        gkgmcfhknknkigahurikaegaku = pGkgmcfhknknkigahurikaegaku;
        gkgmcfhknknkigahurikaegakuValue = null;
        gkgmcfhknknkigahurikaegakuType  = null;
    }

    transient private BigDecimal gkgmcfhknknkigahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKGMCFHKNKNKIGAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGkgmcfhknknkigahurikaegakuValue() {
        if (gkgmcfhknknkigahurikaegakuValue == null && gkgmcfhknknkigahurikaegaku != null) {
            if (gkgmcfhknknkigahurikaegaku.isOptional()) return null;
            return gkgmcfhknknkigahurikaegaku.absolute();
        }
        return gkgmcfhknknkigahurikaegakuValue;
    }

    protected void setGkgmcfhknknkigahurikaegakuValue(BigDecimal value) {
        gkgmcfhknknkigahurikaegakuValue = value;
        gkgmcfhknknkigahurikaegaku = Optional.fromNullable(toCurrencyType(gkgmcfhknknkigahurikaegakuType))
            .transform(bizCurrencyTransformer(getGkgmcfhknknkigahurikaegakuValue()))
            .orNull();
    }

    transient private String gkgmcfhknknkigahurikaegakuType = null;

    @Column(name=GKGMCFHKNKNKIGAHURIKAEGAKU + "$", nullable=true)
    protected String getGkgmcfhknknkigahurikaegakuType() {
        if (gkgmcfhknknkigahurikaegakuType == null && gkgmcfhknknkigahurikaegaku != null) return gkgmcfhknknkigahurikaegaku.getType().toString();
        if (gkgmcfhknknkigahurikaegakuType == null && getGkgmcfhknknkigahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkgmcfhknknkigahurikaegaku$' should not be NULL."));
        }
        return gkgmcfhknknkigahurikaegakuType;
    }

    protected void setGkgmcfhknknkigahurikaegakuType(String type) {
        gkgmcfhknknkigahurikaegakuType = type;
        gkgmcfhknknkigahurikaegaku = Optional.fromNullable(toCurrencyType(gkgmcfhknknkigahurikaegakuType))
            .transform(bizCurrencyTransformer(getGkgmcfhknknkigahurikaegakuValue()))
            .orNull();
    }

    private BizCurrency gmcfsakanrihigahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGmcfsakanrihigahurikaegaku() {
        return gmcfsakanrihigahurikaegaku;
    }

    public void setGmcfsakanrihigahurikaegaku(BizCurrency pGmcfsakanrihigahurikaegaku) {
        gmcfsakanrihigahurikaegaku = pGmcfsakanrihigahurikaegaku;
        gmcfsakanrihigahurikaegakuValue = null;
        gmcfsakanrihigahurikaegakuType  = null;
    }

    transient private BigDecimal gmcfsakanrihigahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GMCFSAKANRIHIGAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGmcfsakanrihigahurikaegakuValue() {
        if (gmcfsakanrihigahurikaegakuValue == null && gmcfsakanrihigahurikaegaku != null) {
            if (gmcfsakanrihigahurikaegaku.isOptional()) return null;
            return gmcfsakanrihigahurikaegaku.absolute();
        }
        return gmcfsakanrihigahurikaegakuValue;
    }

    protected void setGmcfsakanrihigahurikaegakuValue(BigDecimal value) {
        gmcfsakanrihigahurikaegakuValue = value;
        gmcfsakanrihigahurikaegaku = Optional.fromNullable(toCurrencyType(gmcfsakanrihigahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmcfsakanrihigahurikaegakuValue()))
            .orNull();
    }

    transient private String gmcfsakanrihigahurikaegakuType = null;

    @Column(name=GMCFSAKANRIHIGAHURIKAEGAKU + "$", nullable=true)
    protected String getGmcfsakanrihigahurikaegakuType() {
        if (gmcfsakanrihigahurikaegakuType == null && gmcfsakanrihigahurikaegaku != null) return gmcfsakanrihigahurikaegaku.getType().toString();
        if (gmcfsakanrihigahurikaegakuType == null && getGmcfsakanrihigahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gmcfsakanrihigahurikaegaku$' should not be NULL."));
        }
        return gmcfsakanrihigahurikaegakuType;
    }

    protected void setGmcfsakanrihigahurikaegakuType(String type) {
        gmcfsakanrihigahurikaegakuType = type;
        gmcfsakanrihigahurikaegaku = Optional.fromNullable(toCurrencyType(gmcfsakanrihigahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmcfsakanrihigahurikaegakuValue()))
            .orNull();
    }

    private BizCurrency gmsthscstgahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGmsthscstgahurikaegaku() {
        return gmsthscstgahurikaegaku;
    }

    public void setGmsthscstgahurikaegaku(BizCurrency pGmsthscstgahurikaegaku) {
        gmsthscstgahurikaegaku = pGmsthscstgahurikaegaku;
        gmsthscstgahurikaegakuValue = null;
        gmsthscstgahurikaegakuType  = null;
    }

    transient private BigDecimal gmsthscstgahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GMSTHSCSTGAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGmsthscstgahurikaegakuValue() {
        if (gmsthscstgahurikaegakuValue == null && gmsthscstgahurikaegaku != null) {
            if (gmsthscstgahurikaegaku.isOptional()) return null;
            return gmsthscstgahurikaegaku.absolute();
        }
        return gmsthscstgahurikaegakuValue;
    }

    protected void setGmsthscstgahurikaegakuValue(BigDecimal value) {
        gmsthscstgahurikaegakuValue = value;
        gmsthscstgahurikaegaku = Optional.fromNullable(toCurrencyType(gmsthscstgahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmsthscstgahurikaegakuValue()))
            .orNull();
    }

    transient private String gmsthscstgahurikaegakuType = null;

    @Column(name=GMSTHSCSTGAHURIKAEGAKU + "$", nullable=true)
    protected String getGmsthscstgahurikaegakuType() {
        if (gmsthscstgahurikaegakuType == null && gmsthscstgahurikaegaku != null) return gmsthscstgahurikaegaku.getType().toString();
        if (gmsthscstgahurikaegakuType == null && getGmsthscstgahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gmsthscstgahurikaegaku$' should not be NULL."));
        }
        return gmsthscstgahurikaegakuType;
    }

    protected void setGmsthscstgahurikaegakuType(String type) {
        gmsthscstgahurikaegakuType = type;
        gmsthscstgahurikaegaku = Optional.fromNullable(toCurrencyType(gmsthscstgahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmsthscstgahurikaegakuValue()))
            .orNull();
    }

    private BizCurrency gmroanfundgahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGmroanfundgahurikaegaku() {
        return gmroanfundgahurikaegaku;
    }

    public void setGmroanfundgahurikaegaku(BizCurrency pGmroanfundgahurikaegaku) {
        gmroanfundgahurikaegaku = pGmroanfundgahurikaegaku;
        gmroanfundgahurikaegakuValue = null;
        gmroanfundgahurikaegakuType  = null;
    }

    transient private BigDecimal gmroanfundgahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GMROANFUNDGAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGmroanfundgahurikaegakuValue() {
        if (gmroanfundgahurikaegakuValue == null && gmroanfundgahurikaegaku != null) {
            if (gmroanfundgahurikaegaku.isOptional()) return null;
            return gmroanfundgahurikaegaku.absolute();
        }
        return gmroanfundgahurikaegakuValue;
    }

    protected void setGmroanfundgahurikaegakuValue(BigDecimal value) {
        gmroanfundgahurikaegakuValue = value;
        gmroanfundgahurikaegaku = Optional.fromNullable(toCurrencyType(gmroanfundgahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmroanfundgahurikaegakuValue()))
            .orNull();
    }

    transient private String gmroanfundgahurikaegakuType = null;

    @Column(name=GMROANFUNDGAHURIKAEGAKU + "$", nullable=true)
    protected String getGmroanfundgahurikaegakuType() {
        if (gmroanfundgahurikaegakuType == null && gmroanfundgahurikaegaku != null) return gmroanfundgahurikaegaku.getType().toString();
        if (gmroanfundgahurikaegakuType == null && getGmroanfundgahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gmroanfundgahurikaegaku$' should not be NULL."));
        }
        return gmroanfundgahurikaegakuType;
    }

    protected void setGmroanfundgahurikaegakuType(String type) {
        gmroanfundgahurikaegakuType = type;
        gmroanfundgahurikaegaku = Optional.fromNullable(toCurrencyType(gmroanfundgahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmroanfundgahurikaegakuValue()))
            .orNull();
    }

    private BizCurrency gmcfhkkksahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGmcfhkkksahurikaegaku() {
        return gmcfhkkksahurikaegaku;
    }

    public void setGmcfhkkksahurikaegaku(BizCurrency pGmcfhkkksahurikaegaku) {
        gmcfhkkksahurikaegaku = pGmcfhkkksahurikaegaku;
        gmcfhkkksahurikaegakuValue = null;
        gmcfhkkksahurikaegakuType  = null;
    }

    transient private BigDecimal gmcfhkkksahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GMCFHKKKSAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGmcfhkkksahurikaegakuValue() {
        if (gmcfhkkksahurikaegakuValue == null && gmcfhkkksahurikaegaku != null) {
            if (gmcfhkkksahurikaegaku.isOptional()) return null;
            return gmcfhkkksahurikaegaku.absolute();
        }
        return gmcfhkkksahurikaegakuValue;
    }

    protected void setGmcfhkkksahurikaegakuValue(BigDecimal value) {
        gmcfhkkksahurikaegakuValue = value;
        gmcfhkkksahurikaegaku = Optional.fromNullable(toCurrencyType(gmcfhkkksahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmcfhkkksahurikaegakuValue()))
            .orNull();
    }

    transient private String gmcfhkkksahurikaegakuType = null;

    @Column(name=GMCFHKKKSAHURIKAEGAKU + "$", nullable=true)
    protected String getGmcfhkkksahurikaegakuType() {
        if (gmcfhkkksahurikaegakuType == null && gmcfhkkksahurikaegaku != null) return gmcfhkkksahurikaegaku.getType().toString();
        if (gmcfhkkksahurikaegakuType == null && getGmcfhkkksahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gmcfhkkksahurikaegaku$' should not be NULL."));
        }
        return gmcfhkkksahurikaegakuType;
    }

    protected void setGmcfhkkksahurikaegakuType(String type) {
        gmcfhkkksahurikaegakuType = type;
        gmcfhkkksahurikaegaku = Optional.fromNullable(toCurrencyType(gmcfhkkksahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmcfhkkksahurikaegakuValue()))
            .orNull();
    }

    private BizCurrency gkgmcfhkkksahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkgmcfhkkksahurikaegaku() {
        return gkgmcfhkkksahurikaegaku;
    }

    public void setGkgmcfhkkksahurikaegaku(BizCurrency pGkgmcfhkkksahurikaegaku) {
        gkgmcfhkkksahurikaegaku = pGkgmcfhkkksahurikaegaku;
        gkgmcfhkkksahurikaegakuValue = null;
        gkgmcfhkkksahurikaegakuType  = null;
    }

    transient private BigDecimal gkgmcfhkkksahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKGMCFHKKKSAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGkgmcfhkkksahurikaegakuValue() {
        if (gkgmcfhkkksahurikaegakuValue == null && gkgmcfhkkksahurikaegaku != null) {
            if (gkgmcfhkkksahurikaegaku.isOptional()) return null;
            return gkgmcfhkkksahurikaegaku.absolute();
        }
        return gkgmcfhkkksahurikaegakuValue;
    }

    protected void setGkgmcfhkkksahurikaegakuValue(BigDecimal value) {
        gkgmcfhkkksahurikaegakuValue = value;
        gkgmcfhkkksahurikaegaku = Optional.fromNullable(toCurrencyType(gkgmcfhkkksahurikaegakuType))
            .transform(bizCurrencyTransformer(getGkgmcfhkkksahurikaegakuValue()))
            .orNull();
    }

    transient private String gkgmcfhkkksahurikaegakuType = null;

    @Column(name=GKGMCFHKKKSAHURIKAEGAKU + "$", nullable=true)
    protected String getGkgmcfhkkksahurikaegakuType() {
        if (gkgmcfhkkksahurikaegakuType == null && gkgmcfhkkksahurikaegaku != null) return gkgmcfhkkksahurikaegaku.getType().toString();
        if (gkgmcfhkkksahurikaegakuType == null && getGkgmcfhkkksahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkgmcfhkkksahurikaegaku$' should not be NULL."));
        }
        return gkgmcfhkkksahurikaegakuType;
    }

    protected void setGkgmcfhkkksahurikaegakuType(String type) {
        gkgmcfhkkksahurikaegakuType = type;
        gkgmcfhkkksahurikaegaku = Optional.fromNullable(toCurrencyType(gkgmcfhkkksahurikaegakuType))
            .transform(bizCurrencyTransformer(getGkgmcfhkkksahurikaegakuValue()))
            .orNull();
    }

    private BizCurrency gmroanfundsahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGmroanfundsahurikaegaku() {
        return gmroanfundsahurikaegaku;
    }

    public void setGmroanfundsahurikaegaku(BizCurrency pGmroanfundsahurikaegaku) {
        gmroanfundsahurikaegaku = pGmroanfundsahurikaegaku;
        gmroanfundsahurikaegakuValue = null;
        gmroanfundsahurikaegakuType  = null;
    }

    transient private BigDecimal gmroanfundsahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GMROANFUNDSAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGmroanfundsahurikaegakuValue() {
        if (gmroanfundsahurikaegakuValue == null && gmroanfundsahurikaegaku != null) {
            if (gmroanfundsahurikaegaku.isOptional()) return null;
            return gmroanfundsahurikaegaku.absolute();
        }
        return gmroanfundsahurikaegakuValue;
    }

    protected void setGmroanfundsahurikaegakuValue(BigDecimal value) {
        gmroanfundsahurikaegakuValue = value;
        gmroanfundsahurikaegaku = Optional.fromNullable(toCurrencyType(gmroanfundsahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmroanfundsahurikaegakuValue()))
            .orNull();
    }

    transient private String gmroanfundsahurikaegakuType = null;

    @Column(name=GMROANFUNDSAHURIKAEGAKU + "$", nullable=true)
    protected String getGmroanfundsahurikaegakuType() {
        if (gmroanfundsahurikaegakuType == null && gmroanfundsahurikaegaku != null) return gmroanfundsahurikaegaku.getType().toString();
        if (gmroanfundsahurikaegakuType == null && getGmroanfundsahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gmroanfundsahurikaegaku$' should not be NULL."));
        }
        return gmroanfundsahurikaegakuType;
    }

    protected void setGmroanfundsahurikaegakuType(String type) {
        gmroanfundsahurikaegakuType = type;
        gmroanfundsahurikaegaku = Optional.fromNullable(toCurrencyType(gmroanfundsahurikaegakuType))
            .transform(bizCurrencyTransformer(getGmroanfundsahurikaegakuValue()))
            .orNull();
    }

    private BizCurrency gmhokencvgoukeigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGmhokencvgoukeigaku() {
        return gmhokencvgoukeigaku;
    }

    public void setGmhokencvgoukeigaku(BizCurrency pGmhokencvgoukeigaku) {
        gmhokencvgoukeigaku = pGmhokencvgoukeigaku;
        gmhokencvgoukeigakuValue = null;
        gmhokencvgoukeigakuType  = null;
    }

    transient private BigDecimal gmhokencvgoukeigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GMHOKENCVGOUKEIGAKU, nullable=true)
    protected BigDecimal getGmhokencvgoukeigakuValue() {
        if (gmhokencvgoukeigakuValue == null && gmhokencvgoukeigaku != null) {
            if (gmhokencvgoukeigaku.isOptional()) return null;
            return gmhokencvgoukeigaku.absolute();
        }
        return gmhokencvgoukeigakuValue;
    }

    protected void setGmhokencvgoukeigakuValue(BigDecimal value) {
        gmhokencvgoukeigakuValue = value;
        gmhokencvgoukeigaku = Optional.fromNullable(toCurrencyType(gmhokencvgoukeigakuType))
            .transform(bizCurrencyTransformer(getGmhokencvgoukeigakuValue()))
            .orNull();
    }

    transient private String gmhokencvgoukeigakuType = null;

    @Column(name=GMHOKENCVGOUKEIGAKU + "$", nullable=true)
    protected String getGmhokencvgoukeigakuType() {
        if (gmhokencvgoukeigakuType == null && gmhokencvgoukeigaku != null) return gmhokencvgoukeigaku.getType().toString();
        if (gmhokencvgoukeigakuType == null && getGmhokencvgoukeigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gmhokencvgoukeigaku$' should not be NULL."));
        }
        return gmhokencvgoukeigakuType;
    }

    protected void setGmhokencvgoukeigakuType(String type) {
        gmhokencvgoukeigakuType = type;
        gmhokencvgoukeigaku = Optional.fromNullable(toCurrencyType(gmhokencvgoukeigakuType))
            .transform(bizCurrencyTransformer(getGmhokencvgoukeigakuValue()))
            .orNull();
    }

    private BizCurrency gkgmhokencvgoukeigaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkgmhokencvgoukeigaku() {
        return gkgmhokencvgoukeigaku;
    }

    public void setGkgmhokencvgoukeigaku(BizCurrency pGkgmhokencvgoukeigaku) {
        gkgmhokencvgoukeigaku = pGkgmhokencvgoukeigaku;
        gkgmhokencvgoukeigakuValue = null;
        gkgmhokencvgoukeigakuType  = null;
    }

    transient private BigDecimal gkgmhokencvgoukeigakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKGMHOKENCVGOUKEIGAKU, nullable=true)
    protected BigDecimal getGkgmhokencvgoukeigakuValue() {
        if (gkgmhokencvgoukeigakuValue == null && gkgmhokencvgoukeigaku != null) {
            if (gkgmhokencvgoukeigaku.isOptional()) return null;
            return gkgmhokencvgoukeigaku.absolute();
        }
        return gkgmhokencvgoukeigakuValue;
    }

    protected void setGkgmhokencvgoukeigakuValue(BigDecimal value) {
        gkgmhokencvgoukeigakuValue = value;
        gkgmhokencvgoukeigaku = Optional.fromNullable(toCurrencyType(gkgmhokencvgoukeigakuType))
            .transform(bizCurrencyTransformer(getGkgmhokencvgoukeigakuValue()))
            .orNull();
    }

    transient private String gkgmhokencvgoukeigakuType = null;

    @Column(name=GKGMHOKENCVGOUKEIGAKU + "$", nullable=true)
    protected String getGkgmhokencvgoukeigakuType() {
        if (gkgmhokencvgoukeigakuType == null && gkgmhokencvgoukeigaku != null) return gkgmhokencvgoukeigaku.getType().toString();
        if (gkgmhokencvgoukeigakuType == null && getGkgmhokencvgoukeigakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkgmhokencvgoukeigaku$' should not be NULL."));
        }
        return gkgmhokencvgoukeigakuType;
    }

    protected void setGkgmhokencvgoukeigakuType(String type) {
        gkgmhokencvgoukeigakuType = type;
        gkgmhokencvgoukeigaku = Optional.fromNullable(toCurrencyType(gkgmhokencvgoukeigakuType))
            .transform(bizCurrencyTransformer(getGkgmhokencvgoukeigakuValue()))
            .orNull();
    }

    private BizCurrency gmsktsganrigoukeizandaka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGmsktsganrigoukeizandaka() {
        return gmsktsganrigoukeizandaka;
    }

    public void setGmsktsganrigoukeizandaka(BizCurrency pGmsktsganrigoukeizandaka) {
        gmsktsganrigoukeizandaka = pGmsktsganrigoukeizandaka;
        gmsktsganrigoukeizandakaValue = null;
        gmsktsganrigoukeizandakaType  = null;
    }

    transient private BigDecimal gmsktsganrigoukeizandakaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GMSKTSGANRIGOUKEIZANDAKA, nullable=true)
    protected BigDecimal getGmsktsganrigoukeizandakaValue() {
        if (gmsktsganrigoukeizandakaValue == null && gmsktsganrigoukeizandaka != null) {
            if (gmsktsganrigoukeizandaka.isOptional()) return null;
            return gmsktsganrigoukeizandaka.absolute();
        }
        return gmsktsganrigoukeizandakaValue;
    }

    protected void setGmsktsganrigoukeizandakaValue(BigDecimal value) {
        gmsktsganrigoukeizandakaValue = value;
        gmsktsganrigoukeizandaka = Optional.fromNullable(toCurrencyType(gmsktsganrigoukeizandakaType))
            .transform(bizCurrencyTransformer(getGmsktsganrigoukeizandakaValue()))
            .orNull();
    }

    transient private String gmsktsganrigoukeizandakaType = null;

    @Column(name=GMSKTSGANRIGOUKEIZANDAKA + "$", nullable=true)
    protected String getGmsktsganrigoukeizandakaType() {
        if (gmsktsganrigoukeizandakaType == null && gmsktsganrigoukeizandaka != null) return gmsktsganrigoukeizandaka.getType().toString();
        if (gmsktsganrigoukeizandakaType == null && getGmsktsganrigoukeizandakaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gmsktsganrigoukeizandaka$' should not be NULL."));
        }
        return gmsktsganrigoukeizandakaType;
    }

    protected void setGmsktsganrigoukeizandakaType(String type) {
        gmsktsganrigoukeizandakaType = type;
        gmsktsganrigoukeizandaka = Optional.fromNullable(toCurrencyType(gmsktsganrigoukeizandakaType))
            .transform(bizCurrencyTransformer(getGmsktsganrigoukeizandakaValue()))
            .orNull();
    }

    private BizCurrency gkgmsktsganrigoukeizandaka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkgmsktsganrigoukeizandaka() {
        return gkgmsktsganrigoukeizandaka;
    }

    public void setGkgmsktsganrigoukeizandaka(BizCurrency pGkgmsktsganrigoukeizandaka) {
        gkgmsktsganrigoukeizandaka = pGkgmsktsganrigoukeizandaka;
        gkgmsktsganrigoukeizandakaValue = null;
        gkgmsktsganrigoukeizandakaType  = null;
    }

    transient private BigDecimal gkgmsktsganrigoukeizandakaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKGMSKTSGANRIGOUKEIZANDAKA, nullable=true)
    protected BigDecimal getGkgmsktsganrigoukeizandakaValue() {
        if (gkgmsktsganrigoukeizandakaValue == null && gkgmsktsganrigoukeizandaka != null) {
            if (gkgmsktsganrigoukeizandaka.isOptional()) return null;
            return gkgmsktsganrigoukeizandaka.absolute();
        }
        return gkgmsktsganrigoukeizandakaValue;
    }

    protected void setGkgmsktsganrigoukeizandakaValue(BigDecimal value) {
        gkgmsktsganrigoukeizandakaValue = value;
        gkgmsktsganrigoukeizandaka = Optional.fromNullable(toCurrencyType(gkgmsktsganrigoukeizandakaType))
            .transform(bizCurrencyTransformer(getGkgmsktsganrigoukeizandakaValue()))
            .orNull();
    }

    transient private String gkgmsktsganrigoukeizandakaType = null;

    @Column(name=GKGMSKTSGANRIGOUKEIZANDAKA + "$", nullable=true)
    protected String getGkgmsktsganrigoukeizandakaType() {
        if (gkgmsktsganrigoukeizandakaType == null && gkgmsktsganrigoukeizandaka != null) return gkgmsktsganrigoukeizandaka.getType().toString();
        if (gkgmsktsganrigoukeizandakaType == null && getGkgmsktsganrigoukeizandakaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkgmsktsganrigoukeizandaka$' should not be NULL."));
        }
        return gkgmsktsganrigoukeizandakaType;
    }

    protected void setGkgmsktsganrigoukeizandakaType(String type) {
        gkgmsktsganrigoukeizandakaType = type;
        gkgmsktsganrigoukeizandaka = Optional.fromNullable(toCurrencyType(gkgmsktsganrigoukeizandakaType))
            .transform(bizCurrencyTransformer(getGkgmsktsganrigoukeizandakaValue()))
            .orNull();
    }

    private BizCurrency gmmihurikaesousatugaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGmmihurikaesousatugaku() {
        return gmmihurikaesousatugaku;
    }

    public void setGmmihurikaesousatugaku(BizCurrency pGmmihurikaesousatugaku) {
        gmmihurikaesousatugaku = pGmmihurikaesousatugaku;
        gmmihurikaesousatugakuValue = null;
        gmmihurikaesousatugakuType  = null;
    }

    transient private BigDecimal gmmihurikaesousatugakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GMMIHURIKAESOUSATUGAKU, nullable=true)
    protected BigDecimal getGmmihurikaesousatugakuValue() {
        if (gmmihurikaesousatugakuValue == null && gmmihurikaesousatugaku != null) {
            if (gmmihurikaesousatugaku.isOptional()) return null;
            return gmmihurikaesousatugaku.absolute();
        }
        return gmmihurikaesousatugakuValue;
    }

    protected void setGmmihurikaesousatugakuValue(BigDecimal value) {
        gmmihurikaesousatugakuValue = value;
        gmmihurikaesousatugaku = Optional.fromNullable(toCurrencyType(gmmihurikaesousatugakuType))
            .transform(bizCurrencyTransformer(getGmmihurikaesousatugakuValue()))
            .orNull();
    }

    transient private String gmmihurikaesousatugakuType = null;

    @Column(name=GMMIHURIKAESOUSATUGAKU + "$", nullable=true)
    protected String getGmmihurikaesousatugakuType() {
        if (gmmihurikaesousatugakuType == null && gmmihurikaesousatugaku != null) return gmmihurikaesousatugaku.getType().toString();
        if (gmmihurikaesousatugakuType == null && getGmmihurikaesousatugakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gmmihurikaesousatugaku$' should not be NULL."));
        }
        return gmmihurikaesousatugakuType;
    }

    protected void setGmmihurikaesousatugakuType(String type) {
        gmmihurikaesousatugakuType = type;
        gmmihurikaesousatugaku = Optional.fromNullable(toCurrencyType(gmmihurikaesousatugakuType))
            .transform(bizCurrencyTransformer(getGmmihurikaesousatugakuValue()))
            .orNull();
    }

    private BizCurrency gkgmmihurikaesousatugaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkgmmihurikaesousatugaku() {
        return gkgmmihurikaesousatugaku;
    }

    public void setGkgmmihurikaesousatugaku(BizCurrency pGkgmmihurikaesousatugaku) {
        gkgmmihurikaesousatugaku = pGkgmmihurikaesousatugaku;
        gkgmmihurikaesousatugakuValue = null;
        gkgmmihurikaesousatugakuType  = null;
    }

    transient private BigDecimal gkgmmihurikaesousatugakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKGMMIHURIKAESOUSATUGAKU, nullable=true)
    protected BigDecimal getGkgmmihurikaesousatugakuValue() {
        if (gkgmmihurikaesousatugakuValue == null && gkgmmihurikaesousatugaku != null) {
            if (gkgmmihurikaesousatugaku.isOptional()) return null;
            return gkgmmihurikaesousatugaku.absolute();
        }
        return gkgmmihurikaesousatugakuValue;
    }

    protected void setGkgmmihurikaesousatugakuValue(BigDecimal value) {
        gkgmmihurikaesousatugakuValue = value;
        gkgmmihurikaesousatugaku = Optional.fromNullable(toCurrencyType(gkgmmihurikaesousatugakuType))
            .transform(bizCurrencyTransformer(getGkgmmihurikaesousatugakuValue()))
            .orNull();
    }

    transient private String gkgmmihurikaesousatugakuType = null;

    @Column(name=GKGMMIHURIKAESOUSATUGAKU + "$", nullable=true)
    protected String getGkgmmihurikaesousatugakuType() {
        if (gkgmmihurikaesousatugakuType == null && gkgmmihurikaesousatugaku != null) return gkgmmihurikaesousatugaku.getType().toString();
        if (gkgmmihurikaesousatugakuType == null && getGkgmmihurikaesousatugakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkgmmihurikaesousatugaku$' should not be NULL."));
        }
        return gkgmmihurikaesousatugakuType;
    }

    protected void setGkgmmihurikaesousatugakuType(String type) {
        gkgmmihurikaesousatugakuType = type;
        gkgmmihurikaesousatugaku = Optional.fromNullable(toCurrencyType(gkgmmihurikaesousatugakuType))
            .transform(bizCurrencyTransformer(getGkgmmihurikaesousatugakuValue()))
            .orNull();
    }
}
