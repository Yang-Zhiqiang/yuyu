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
import yuyu.def.db.entity.BM_ChkSyouhnKokutiJougenS;
import yuyu.def.db.id.PKBM_ChkSyouhnKokutiJougenS;
import yuyu.def.db.meta.GenQBM_ChkSyouhnKokutiJougenS;
import yuyu.def.db.meta.QBM_ChkSyouhnKokutiJougenS;

/**
 * 商品単位告知上限Ｓチェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkSyouhnKokutiJougenS} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkSyouhnKokutiJougenS}</td><td colspan="3">商品単位告知上限Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkSyouhnKokutiJougenS ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkSyouhnKokutiJougenS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkSyouhnKokutiJougenS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkSyouhnKokutiJougenS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkSyouhnKokutiJougenS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getMoskbnfrom moskbnfrom}</td><td>申込区分自</td><td align="center">{@link PKBM_ChkSyouhnKokutiJougenS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMoskbnto moskbnto}</td><td>申込区分至</td><td align="center">{@link PKBM_ChkSyouhnKokutiJougenS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSaikous saikous}</td><td>最高Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getBairitu bairitu}</td><td>倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_ChkSyouhnKokutiJougenS
 * @see     PKBM_ChkSyouhnKokutiJougenS
 * @see     QBM_ChkSyouhnKokutiJougenS
 * @see     GenQBM_ChkSyouhnKokutiJougenS
 */
@MappedSuperclass
@Table(name=GenBM_ChkSyouhnKokutiJougenS.TABLE_NAME)
@IdClass(value=PKBM_ChkSyouhnKokutiJougenS.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_ChkSyouhnKokutiJougenS extends AbstractExDBEntity<BM_ChkSyouhnKokutiJougenS, PKBM_ChkSyouhnKokutiJougenS> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkSyouhnKokutiJougenS";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String MOSKBNFROM               = "moskbnfrom";
    public static final String MOSKBNTO                 = "moskbnto";
    public static final String SAIKOUS                  = "saikous";
    public static final String BAIRITU                  = "bairitu";

    private final PKBM_ChkSyouhnKokutiJougenS primaryKey;

    public GenBM_ChkSyouhnKokutiJougenS() {
        primaryKey = new PKBM_ChkSyouhnKokutiJougenS();
    }

    public GenBM_ChkSyouhnKokutiJougenS(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        Integer pMoskbnfrom,
        Integer pMoskbnto
    ) {
        primaryKey = new PKBM_ChkSyouhnKokutiJougenS(
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
    public PKBM_ChkSyouhnKokutiJougenS getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkSyouhnKokutiJougenS> getMetaClass() {
        return QBM_ChkSyouhnKokutiJougenS.class;
    }

    @Id
    @Column(name=GenBM_ChkSyouhnKokutiJougenS.SYOUHNCD)
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
    @Column(name=GenBM_ChkSyouhnKokutiJougenS.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkSyouhnKokutiJougenS.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkSyouhnKokutiJougenS.HHKNFROMNEN)
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
    @Column(name=GenBM_ChkSyouhnKokutiJougenS.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return getPrimaryKey().getHhkntonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        getPrimaryKey().setHhkntonen(pHhkntonen);
    }

    @Id
    @Column(name=GenBM_ChkSyouhnKokutiJougenS.MOSKBNFROM)
    public Integer getMoskbnfrom() {
        return getPrimaryKey().getMoskbnfrom();
    }

    public void setMoskbnfrom(Integer pMoskbnfrom) {
        getPrimaryKey().setMoskbnfrom(pMoskbnfrom);
    }

    @Id
    @Column(name=GenBM_ChkSyouhnKokutiJougenS.MOSKBNTO)
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

    private BizNumber bairitu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkSyouhnKokutiJougenS.BAIRITU)
    public BizNumber getBairitu() {
        return bairitu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBairitu(BizNumber pBairitu) {
        bairitu = pBairitu;
    }
}
