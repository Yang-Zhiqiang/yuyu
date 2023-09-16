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
import yuyu.def.db.entity.BM_ChkSaikouSSTani;
import yuyu.def.db.id.PKBM_ChkSaikouSSTani;
import yuyu.def.db.meta.GenQBM_ChkSaikouSSTani;
import yuyu.def.db.meta.QBM_ChkSaikouSSTani;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 最高ＳＳ単位チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkSaikouSSTani} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkSaikouSSTani}</td><td colspan="3">最高ＳＳ単位チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkSaikouSSTani ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkSaikouSSTani ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkSaikouSSTani ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkSaikouSSTani ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkSaikouSSTani ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getMoskbnfrom moskbnfrom}</td><td>申込区分自</td><td align="center">{@link PKBM_ChkSaikouSSTani ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMoskbnto moskbnto}</td><td>申込区分至</td><td align="center">{@link PKBM_ChkSaikouSSTani ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_ChkSaikouSSTani ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSaikous saikous}</td><td>最高Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getStani stani}</td><td>Ｓ単位</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getBairitu bairitu}</td><td>倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getBairitu2 bairitu2}</td><td>倍率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_ChkSaikouSSTani
 * @see     PKBM_ChkSaikouSSTani
 * @see     QBM_ChkSaikouSSTani
 * @see     GenQBM_ChkSaikouSSTani
 */
@MappedSuperclass
@Table(name=GenBM_ChkSaikouSSTani.TABLE_NAME)
@IdClass(value=PKBM_ChkSaikouSSTani.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_ChkSaikouSSTani extends AbstractExDBEntity<BM_ChkSaikouSSTani, PKBM_ChkSaikouSSTani> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkSaikouSSTani";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String MOSKBNFROM               = "moskbnfrom";
    public static final String MOSKBNTO                 = "moskbnto";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String SAIKOUS                  = "saikous";
    public static final String STANI                    = "stani";
    public static final String BAIRITU                  = "bairitu";
    public static final String BAIRITU2                 = "bairitu2";

    private final PKBM_ChkSaikouSSTani primaryKey;

    public GenBM_ChkSaikouSSTani() {
        primaryKey = new PKBM_ChkSaikouSSTani();
    }

    public GenBM_ChkSaikouSSTani(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        Integer pMoskbnfrom,
        Integer pMoskbnto,
        C_Tuukasyu pTuukasyu
    ) {
        primaryKey = new PKBM_ChkSaikouSSTani(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pHhknfromnen,
            pHhkntonen,
            pMoskbnfrom,
            pMoskbnto,
            pTuukasyu
        );
    }

    @Transient
    @Override
    public PKBM_ChkSaikouSSTani getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkSaikouSSTani> getMetaClass() {
        return QBM_ChkSaikouSSTani.class;
    }

    @Id
    @Column(name=GenBM_ChkSaikouSSTani.SYOUHNCD)
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
    @Column(name=GenBM_ChkSaikouSSTani.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkSaikouSSTani.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkSaikouSSTani.HHKNFROMNEN)
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
    @Column(name=GenBM_ChkSaikouSSTani.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return getPrimaryKey().getHhkntonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        getPrimaryKey().setHhkntonen(pHhkntonen);
    }

    @Id
    @Column(name=GenBM_ChkSaikouSSTani.MOSKBNFROM)
    public Integer getMoskbnfrom() {
        return getPrimaryKey().getMoskbnfrom();
    }

    public void setMoskbnfrom(Integer pMoskbnfrom) {
        getPrimaryKey().setMoskbnfrom(pMoskbnfrom);
    }

    @Id
    @Column(name=GenBM_ChkSaikouSSTani.MOSKBNTO)
    public Integer getMoskbnto() {
        return getPrimaryKey().getMoskbnto();
    }

    public void setMoskbnto(Integer pMoskbnto) {
        getPrimaryKey().setMoskbnto(pMoskbnto);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_ChkSaikouSSTani.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    private BizCurrency saikous;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSaikous() {
        return saikous;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSaikous(BizCurrency pSaikous) {
        saikous = pSaikous;
        saikousValue = null;
        saikousType  = null;
    }

    transient private BigDecimal saikousValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SAIKOUS, nullable=true)
    protected BigDecimal getSaikousValue() {
        if (saikousValue == null && saikous != null) {
            if (saikous.isOptional()) return null;
            return saikous.absolute();
        }
        return saikousValue;
    }

    protected void setSaikousValue(BigDecimal value) {
        saikousValue = value;
        saikous = Optional.fromNullable(toCurrencyType(saikousType))
            .transform(bizCurrencyTransformer(getSaikousValue()))
            .orNull();
    }

    transient private String saikousType = null;

    @Column(name=SAIKOUS + "$", nullable=true)
    protected String getSaikousType() {
        if (saikousType == null && saikous != null) return saikous.getType().toString();
        if (saikousType == null && getSaikousValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'saikous$' should not be NULL."));
        }
        return saikousType;
    }

    protected void setSaikousType(String type) {
        saikousType = type;
        saikous = Optional.fromNullable(toCurrencyType(saikousType))
            .transform(bizCurrencyTransformer(getSaikousValue()))
            .orNull();
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

    private BizNumber bairitu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkSaikouSSTani.BAIRITU)
    public BizNumber getBairitu() {
        return bairitu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBairitu(BizNumber pBairitu) {
        bairitu = pBairitu;
    }

    private BizNumber bairitu2;

    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkSaikouSSTani.BAIRITU2)
    public BizNumber getBairitu2() {
        return bairitu2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBairitu2(BizNumber pBairitu2) {
        bairitu2 = pBairitu2;
    }
}
