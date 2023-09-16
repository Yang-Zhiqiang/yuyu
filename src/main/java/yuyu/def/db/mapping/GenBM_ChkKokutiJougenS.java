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
import yuyu.def.db.entity.BM_ChkKokutiJougenS;
import yuyu.def.db.id.PKBM_ChkKokutiJougenS;
import yuyu.def.db.meta.GenQBM_ChkKokutiJougenS;
import yuyu.def.db.meta.QBM_ChkKokutiJougenS;

/**
 * 告知上限Ｓチェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkKokutiJougenS} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKokutiJougenS}</td><td colspan="3">告知上限Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkKokutiJougenS ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkKokutiJougenS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkKokutiJougenS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkKokutiJougenS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkKokutiJougenS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getMoskbnfrom moskbnfrom}</td><td>申込区分自</td><td align="center">{@link PKBM_ChkKokutiJougenS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMoskbnto moskbnto}</td><td>申込区分至</td><td align="center">{@link PKBM_ChkKokutiJougenS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSaikous saikous}</td><td>最高Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkKokutiJougenS
 * @see     PKBM_ChkKokutiJougenS
 * @see     QBM_ChkKokutiJougenS
 * @see     GenQBM_ChkKokutiJougenS
 */
@MappedSuperclass
@Table(name=GenBM_ChkKokutiJougenS.TABLE_NAME)
@IdClass(value=PKBM_ChkKokutiJougenS.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_ChkKokutiJougenS extends AbstractExDBEntity<BM_ChkKokutiJougenS, PKBM_ChkKokutiJougenS> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkKokutiJougenS";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String MOSKBNFROM               = "moskbnfrom";
    public static final String MOSKBNTO                 = "moskbnto";
    public static final String SAIKOUS                  = "saikous";

    private final PKBM_ChkKokutiJougenS primaryKey;

    public GenBM_ChkKokutiJougenS() {
        primaryKey = new PKBM_ChkKokutiJougenS();
    }

    public GenBM_ChkKokutiJougenS(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        Integer pMoskbnfrom,
        Integer pMoskbnto
    ) {
        primaryKey = new PKBM_ChkKokutiJougenS(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pHhknfromnen,
            pHhkntonen,
            pMoskbnfrom,
            pMoskbnto
        );
    }

    @Transient
    @Override
    public PKBM_ChkKokutiJougenS getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkKokutiJougenS> getMetaClass() {
        return QBM_ChkKokutiJougenS.class;
    }

    @Id
    @Column(name=GenBM_ChkKokutiJougenS.SYOUHNCD)
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
    @Column(name=GenBM_ChkKokutiJougenS.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkKokutiJougenS.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkKokutiJougenS.HHKNFROMNEN)
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
    @Column(name=GenBM_ChkKokutiJougenS.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return getPrimaryKey().getHhkntonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        getPrimaryKey().setHhkntonen(pHhkntonen);
    }

    @Id
    @Column(name=GenBM_ChkKokutiJougenS.MOSKBNFROM)
    public Integer getMoskbnfrom() {
        return getPrimaryKey().getMoskbnfrom();
    }

    public void setMoskbnfrom(Integer pMoskbnfrom) {
        getPrimaryKey().setMoskbnfrom(pMoskbnfrom);
    }

    @Id
    @Column(name=GenBM_ChkKokutiJougenS.MOSKBNTO)
    public Integer getMoskbnto() {
        return getPrimaryKey().getMoskbnto();
    }

    public void setMoskbnto(Integer pMoskbnto) {
        getPrimaryKey().setMoskbnto(pMoskbnto);
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
}
