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
import yuyu.def.db.entity.BM_ChkSTani;
import yuyu.def.db.id.PKBM_ChkSTani;
import yuyu.def.db.meta.GenQBM_ChkSTani;
import yuyu.def.db.meta.QBM_ChkSTani;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * Ｓ単位チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkSTani} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkSTani}</td><td colspan="3">Ｓ単位チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkSTani ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkSTani ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkSTani ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkSTani ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkSTani ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_ChkSTani ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getStani stani}</td><td>Ｓ単位</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkSTani
 * @see     PKBM_ChkSTani
 * @see     QBM_ChkSTani
 * @see     GenQBM_ChkSTani
 */
@MappedSuperclass
@Table(name=GenBM_ChkSTani.TABLE_NAME)
@IdClass(value=PKBM_ChkSTani.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_ChkSTani extends AbstractExDBEntity<BM_ChkSTani, PKBM_ChkSTani> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkSTani";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String STANI                    = "stani";

    private final PKBM_ChkSTani primaryKey;

    public GenBM_ChkSTani() {
        primaryKey = new PKBM_ChkSTani();
    }

    public GenBM_ChkSTani(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        C_Tuukasyu pTuukasyu
    ) {
        primaryKey = new PKBM_ChkSTani(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pHhknfromnen,
            pHhkntonen,
            pTuukasyu
        );
    }

    @Transient
    @Override
    public PKBM_ChkSTani getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkSTani> getMetaClass() {
        return QBM_ChkSTani.class;
    }

    @Id
    @Column(name=GenBM_ChkSTani.SYOUHNCD)
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
    @Column(name=GenBM_ChkSTani.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkSTani.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkSTani.HHKNFROMNEN)
    public BizNumber getHhknfromnen() {
        return getPrimaryKey().getHhknfromnen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknfromnen(BizNumber pHhknfromnen) {
        getPrimaryKey().setHhknfromnen(pHhknfromnen);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkSTani.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return getPrimaryKey().getHhkntonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        getPrimaryKey().setHhkntonen(pHhkntonen);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_ChkSTani.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    private BizCurrency stani;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getStani() {
        return stani;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setStani(BizCurrency pStani) {
        stani = pStani;
        staniValue = null;
        staniType  = null;
    }

    transient private BigDecimal staniValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=STANI, nullable=true)
    protected BigDecimal getStaniValue() {
        if (staniValue == null && stani != null) {
            if (stani.isOptional()) return null;
            return stani.absolute();
        }
        return staniValue;
    }

    protected void setStaniValue(BigDecimal value) {
        staniValue = value;
        stani = Optional.fromNullable(toCurrencyType(staniType))
            .transform(bizCurrencyTransformer(getStaniValue()))
            .orNull();
    }

    transient private String staniType = null;

    @Column(name=STANI + "$", nullable=true)
    protected String getStaniType() {
        if (staniType == null && stani != null) return stani.getType().toString();
        if (staniType == null && getStaniValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'stani$' should not be NULL."));
        }
        return staniType;
    }

    protected void setStaniType(String type) {
        staniType = type;
        stani = Optional.fromNullable(toCurrencyType(staniType))
            .transform(bizCurrencyTransformer(getStaniValue()))
            .orNull();
    }
}
