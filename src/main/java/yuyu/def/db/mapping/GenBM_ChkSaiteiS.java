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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSaiteiS;
import yuyu.def.db.id.PKBM_ChkSaiteiS;
import yuyu.def.db.meta.GenQBM_ChkSaiteiS;
import yuyu.def.db.meta.QBM_ChkSaiteiS;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 最低Ｓチェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkSaiteiS} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkSaiteiS}</td><td colspan="3">最低Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDntsdnumufrom dntsdnumufrom}</td><td>団体集団有無自</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDntsdnumuto dntsdnumuto}</td><td>団体集団有無至</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbnfrom hrkkknsmnkbnfrom}</td><td>払込期間歳満期区分自</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbnto hrkkknsmnkbnto}</td><td>払込期間歳満期区分至</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkknfrom hknkknfrom}</td><td>保険期間自</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHknkknto hknkknto}</td><td>保険期間至</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSaiteisknwtkumufrom saiteisknwtkumufrom}</td><td>最低Ｓ緩和特約有無自</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSaiteisknwtkumuto saiteisknwtkumuto}</td><td>最低Ｓ緩和特約有無至</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_ChkSaiteiS ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSaiteis saiteis}</td><td>最低Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkSaiteiS
 * @see     PKBM_ChkSaiteiS
 * @see     QBM_ChkSaiteiS
 * @see     GenQBM_ChkSaiteiS
 */
@MappedSuperclass
@Table(name=GenBM_ChkSaiteiS.TABLE_NAME)
@IdClass(value=PKBM_ChkSaiteiS.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_ChkSaiteiS extends AbstractExDBEntity<BM_ChkSaiteiS, PKBM_ChkSaiteiS> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkSaiteiS";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String DNTSDNUMUFROM            = "dntsdnumufrom";
    public static final String DNTSDNUMUTO              = "dntsdnumuto";
    public static final String HRKKKNSMNKBNFROM         = "hrkkknsmnkbnfrom";
    public static final String HRKKKNSMNKBNTO           = "hrkkknsmnkbnto";
    public static final String HKNKKNFROM               = "hknkknfrom";
    public static final String HKNKKNTO                 = "hknkknto";
    public static final String SAITEISKNWTKUMUFROM      = "saiteisknwtkumufrom";
    public static final String SAITEISKNWTKUMUTO        = "saiteisknwtkumuto";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String SAITEIS                  = "saiteis";

    private final PKBM_ChkSaiteiS primaryKey;

    public GenBM_ChkSaiteiS() {
        primaryKey = new PKBM_ChkSaiteiS();
    }

    public GenBM_ChkSaiteiS(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        Integer pDntsdnumufrom,
        Integer pDntsdnumuto,
        Integer pHrkkknsmnkbnfrom,
        Integer pHrkkknsmnkbnto,
        BizNumber pHknkknfrom,
        BizNumber pHknkknto,
        Integer pSaiteisknwtkumufrom,
        Integer pSaiteisknwtkumuto,
        C_Tuukasyu pTuukasyu
    ) {
        primaryKey = new PKBM_ChkSaiteiS(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pDntsdnumufrom,
            pDntsdnumuto,
            pHrkkknsmnkbnfrom,
            pHrkkknsmnkbnto,
            pHknkknfrom,
            pHknkknto,
            pSaiteisknwtkumufrom,
            pSaiteisknwtkumuto,
            pTuukasyu
        );
    }

    @Transient
    @Override
    public PKBM_ChkSaiteiS getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkSaiteiS> getMetaClass() {
        return QBM_ChkSaiteiS.class;
    }

    @Id
    @Column(name=GenBM_ChkSaiteiS.SYOUHNCD)
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
    @Column(name=GenBM_ChkSaiteiS.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkSaiteiS.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Column(name=GenBM_ChkSaiteiS.DNTSDNUMUFROM)
    public Integer getDntsdnumufrom() {
        return getPrimaryKey().getDntsdnumufrom();
    }

    public void setDntsdnumufrom(Integer pDntsdnumufrom) {
        getPrimaryKey().setDntsdnumufrom(pDntsdnumufrom);
    }

    @Id
    @Column(name=GenBM_ChkSaiteiS.DNTSDNUMUTO)
    public Integer getDntsdnumuto() {
        return getPrimaryKey().getDntsdnumuto();
    }

    public void setDntsdnumuto(Integer pDntsdnumuto) {
        getPrimaryKey().setDntsdnumuto(pDntsdnumuto);
    }

    @Id
    @Column(name=GenBM_ChkSaiteiS.HRKKKNSMNKBNFROM)
    public Integer getHrkkknsmnkbnfrom() {
        return getPrimaryKey().getHrkkknsmnkbnfrom();
    }

    public void setHrkkknsmnkbnfrom(Integer pHrkkknsmnkbnfrom) {
        getPrimaryKey().setHrkkknsmnkbnfrom(pHrkkknsmnkbnfrom);
    }

    @Id
    @Column(name=GenBM_ChkSaiteiS.HRKKKNSMNKBNTO)
    public Integer getHrkkknsmnkbnto() {
        return getPrimaryKey().getHrkkknsmnkbnto();
    }

    public void setHrkkknsmnkbnto(Integer pHrkkknsmnkbnto) {
        getPrimaryKey().setHrkkknsmnkbnto(pHrkkknsmnkbnto);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkSaiteiS.HKNKKNFROM)
    public BizNumber getHknkknfrom() {
        return getPrimaryKey().getHknkknfrom();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkknfrom(BizNumber pHknkknfrom) {
        getPrimaryKey().setHknkknfrom(pHknkknfrom);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkSaiteiS.HKNKKNTO)
    public BizNumber getHknkknto() {
        return getPrimaryKey().getHknkknto();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkknto(BizNumber pHknkknto) {
        getPrimaryKey().setHknkknto(pHknkknto);
    }

    @Id
    @Column(name=GenBM_ChkSaiteiS.SAITEISKNWTKUMUFROM)
    public Integer getSaiteisknwtkumufrom() {
        return getPrimaryKey().getSaiteisknwtkumufrom();
    }

    public void setSaiteisknwtkumufrom(Integer pSaiteisknwtkumufrom) {
        getPrimaryKey().setSaiteisknwtkumufrom(pSaiteisknwtkumufrom);
    }

    @Id
    @Column(name=GenBM_ChkSaiteiS.SAITEISKNWTKUMUTO)
    public Integer getSaiteisknwtkumuto() {
        return getPrimaryKey().getSaiteisknwtkumuto();
    }

    public void setSaiteisknwtkumuto(Integer pSaiteisknwtkumuto) {
        getPrimaryKey().setSaiteisknwtkumuto(pSaiteisknwtkumuto);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_ChkSaiteiS.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    private BizCurrency saiteis;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSaiteis() {
        return saiteis;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSaiteis(BizCurrency pSaiteis) {
        saiteis = pSaiteis;
        saiteisValue = null;
        saiteisType  = null;
    }

    transient private BigDecimal saiteisValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SAITEIS, nullable=true)
    protected BigDecimal getSaiteisValue() {
        if (saiteisValue == null && saiteis != null) {
            if (saiteis.isOptional()) return null;
            return saiteis.absolute();
        }
        return saiteisValue;
    }

    protected void setSaiteisValue(BigDecimal value) {
        saiteisValue = value;
        saiteis = Optional.fromNullable(toCurrencyType(saiteisType))
            .transform(bizCurrencyTransformer(getSaiteisValue()))
            .orNull();
    }

    transient private String saiteisType = null;

    @Column(name=SAITEIS + "$", nullable=true)
    protected String getSaiteisType() {
        if (saiteisType == null && saiteis != null) return saiteis.getType().toString();
        if (saiteisType == null && getSaiteisValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'saiteis$' should not be NULL."));
        }
        return saiteisType;
    }

    protected void setSaiteisType(String type) {
        saiteisType = type;
        saiteis = Optional.fromNullable(toCurrencyType(saiteisType))
            .transform(bizCurrencyTransformer(getSaiteisValue()))
            .orNull();
    }
}
