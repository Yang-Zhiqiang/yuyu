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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkKeiyakuTaniSaikouS;
import yuyu.def.db.id.PKBM_ChkKeiyakuTaniSaikouS;
import yuyu.def.db.meta.GenQBM_ChkKeiyakuTaniSaikouS;
import yuyu.def.db.meta.QBM_ChkKeiyakuTaniSaikouS;

/**
 * 契約単位最高Ｓチェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkKeiyakuTaniSaikouS} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKeiyakuTaniSaikouS}</td><td colspan="3">契約単位最高Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkKeiyakuTaniSaikouS ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkKeiyakuTaniSaikouS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkKeiyakuTaniSaikouS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSaikous1 saikous1}</td><td>最高Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSaikous2 saikous2}</td><td>最高Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSaikous3 saikous3}</td><td>最高Ｓ３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkKeiyakuTaniSaikouS
 * @see     PKBM_ChkKeiyakuTaniSaikouS
 * @see     QBM_ChkKeiyakuTaniSaikouS
 * @see     GenQBM_ChkKeiyakuTaniSaikouS
 */
@MappedSuperclass
@Table(name=GenBM_ChkKeiyakuTaniSaikouS.TABLE_NAME)
@IdClass(value=PKBM_ChkKeiyakuTaniSaikouS.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class)
})
public abstract class GenBM_ChkKeiyakuTaniSaikouS extends AbstractExDBEntity<BM_ChkKeiyakuTaniSaikouS, PKBM_ChkKeiyakuTaniSaikouS> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkKeiyakuTaniSaikouS";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String SAIKOUS1                 = "saikous1";
    public static final String SAIKOUS2                 = "saikous2";
    public static final String SAIKOUS3                 = "saikous3";

    private final PKBM_ChkKeiyakuTaniSaikouS primaryKey;

    public GenBM_ChkKeiyakuTaniSaikouS() {
        primaryKey = new PKBM_ChkKeiyakuTaniSaikouS();
    }

    public GenBM_ChkKeiyakuTaniSaikouS(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto
    ) {
        primaryKey = new PKBM_ChkKeiyakuTaniSaikouS(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto
        );
    }

    @Transient
    @Override
    public PKBM_ChkKeiyakuTaniSaikouS getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkKeiyakuTaniSaikouS> getMetaClass() {
        return QBM_ChkKeiyakuTaniSaikouS.class;
    }

    @Id
    @Column(name=GenBM_ChkKeiyakuTaniSaikouS.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenBM_ChkKeiyakuTaniSaikouS.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkKeiyakuTaniSaikouS.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    private BizCurrency saikous1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSaikous1() {
        return saikous1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSaikous1(BizCurrency pSaikous1) {
        saikous1 = pSaikous1;
        saikous1Value = null;
        saikous1Type  = null;
    }

    transient private BigDecimal saikous1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SAIKOUS1, nullable=true)
    protected BigDecimal getSaikous1Value() {
        if (saikous1Value == null && saikous1 != null) {
            if (saikous1.isOptional()) return null;
            return saikous1.absolute();
        }
        return saikous1Value;
    }

    protected void setSaikous1Value(BigDecimal value) {
        saikous1Value = value;
        saikous1 = Optional.fromNullable(toCurrencyType(saikous1Type))
            .transform(bizCurrencyTransformer(getSaikous1Value()))
            .orNull();
    }

    transient private String saikous1Type = null;

    @Column(name=SAIKOUS1 + "$", nullable=true)
    protected String getSaikous1Type() {
        if (saikous1Type == null && saikous1 != null) return saikous1.getType().toString();
        if (saikous1Type == null && getSaikous1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'saikous1$' should not be NULL."));
        }
        return saikous1Type;
    }

    protected void setSaikous1Type(String type) {
        saikous1Type = type;
        saikous1 = Optional.fromNullable(toCurrencyType(saikous1Type))
            .transform(bizCurrencyTransformer(getSaikous1Value()))
            .orNull();
    }

    private BizCurrency saikous2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSaikous2() {
        return saikous2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSaikous2(BizCurrency pSaikous2) {
        saikous2 = pSaikous2;
        saikous2Value = null;
        saikous2Type  = null;
    }

    transient private BigDecimal saikous2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SAIKOUS2, nullable=true)
    protected BigDecimal getSaikous2Value() {
        if (saikous2Value == null && saikous2 != null) {
            if (saikous2.isOptional()) return null;
            return saikous2.absolute();
        }
        return saikous2Value;
    }

    protected void setSaikous2Value(BigDecimal value) {
        saikous2Value = value;
        saikous2 = Optional.fromNullable(toCurrencyType(saikous2Type))
            .transform(bizCurrencyTransformer(getSaikous2Value()))
            .orNull();
    }

    transient private String saikous2Type = null;

    @Column(name=SAIKOUS2 + "$", nullable=true)
    protected String getSaikous2Type() {
        if (saikous2Type == null && saikous2 != null) return saikous2.getType().toString();
        if (saikous2Type == null && getSaikous2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'saikous2$' should not be NULL."));
        }
        return saikous2Type;
    }

    protected void setSaikous2Type(String type) {
        saikous2Type = type;
        saikous2 = Optional.fromNullable(toCurrencyType(saikous2Type))
            .transform(bizCurrencyTransformer(getSaikous2Value()))
            .orNull();
    }

    private BizCurrency saikous3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSaikous3() {
        return saikous3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSaikous3(BizCurrency pSaikous3) {
        saikous3 = pSaikous3;
        saikous3Value = null;
        saikous3Type  = null;
    }

    transient private BigDecimal saikous3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SAIKOUS3, nullable=true)
    protected BigDecimal getSaikous3Value() {
        if (saikous3Value == null && saikous3 != null) {
            if (saikous3.isOptional()) return null;
            return saikous3.absolute();
        }
        return saikous3Value;
    }

    protected void setSaikous3Value(BigDecimal value) {
        saikous3Value = value;
        saikous3 = Optional.fromNullable(toCurrencyType(saikous3Type))
            .transform(bizCurrencyTransformer(getSaikous3Value()))
            .orNull();
    }

    transient private String saikous3Type = null;

    @Column(name=SAIKOUS3 + "$", nullable=true)
    protected String getSaikous3Type() {
        if (saikous3Type == null && saikous3 != null) return saikous3.getType().toString();
        if (saikous3Type == null && getSaikous3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'saikous3$' should not be NULL."));
        }
        return saikous3Type;
    }

    protected void setSaikous3Type(String type) {
        saikous3Type = type;
        saikous3 = Optional.fromNullable(toCurrencyType(saikous3Type))
            .transform(bizCurrencyTransformer(getSaikous3Value()))
            .orNull();
    }
}
