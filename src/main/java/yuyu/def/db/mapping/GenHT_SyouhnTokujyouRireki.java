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
import yuyu.def.classification.C_KohtnpKbn;
import yuyu.def.classification.C_TknzkKbn;
import yuyu.def.classification.C_TumahtnpKbn;
import yuyu.def.db.entity.HT_SyouhnTokujyouRireki;
import yuyu.def.db.id.PKHT_SyouhnTokujyouRireki;
import yuyu.def.db.meta.GenQHT_SyouhnTokujyouRireki;
import yuyu.def.db.meta.QHT_SyouhnTokujyouRireki;
import yuyu.def.db.type.UserType_C_KohtnpKbn;
import yuyu.def.db.type.UserType_C_TknzkKbn;
import yuyu.def.db.type.UserType_C_TumahtnpKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 商品別特条条件付履歴テーブル テーブルのマッピング情報クラスで、 {@link HT_SyouhnTokujyouRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SyouhnTokujyouRireki}</td><td colspan="3">商品別特条条件付履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SyouhnTokujyouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDakuhiktrenno dakuhiktrenno}</td><td>諾否決定連番</td><td align="center">{@link PKHT_SyouhnTokujyouRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKHT_SyouhnTokujyouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTknzkkbn tknzkkbn}</td><td>特約除き区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TknzkKbn}</td></tr>
 *  <tr><td>{@link #getTumahtnpkbn tumahtnpkbn}</td><td>妻不担保区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TumahtnpKbn}</td></tr>
 *  <tr><td>{@link #getKohtnpkbn kohtnpkbn}</td><td>子不担保区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KohtnpKbn}</td></tr>
 *  <tr><td>{@link #getSeigens seigens}</td><td>制限Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SyouhnTokujyouRireki
 * @see     PKHT_SyouhnTokujyouRireki
 * @see     QHT_SyouhnTokujyouRireki
 * @see     GenQHT_SyouhnTokujyouRireki
 */
@MappedSuperclass
@Table(name=GenHT_SyouhnTokujyouRireki.TABLE_NAME)
@IdClass(value=PKHT_SyouhnTokujyouRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="UserType_C_KohtnpKbn", typeClass=UserType_C_KohtnpKbn.class),
    @TypeDef(name="UserType_C_TknzkKbn", typeClass=UserType_C_TknzkKbn.class),
    @TypeDef(name="UserType_C_TumahtnpKbn", typeClass=UserType_C_TumahtnpKbn.class)
})
public abstract class GenHT_SyouhnTokujyouRireki extends AbstractExDBEntity<HT_SyouhnTokujyouRireki, PKHT_SyouhnTokujyouRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SyouhnTokujyouRireki";
    public static final String MOSNO                    = "mosno";
    public static final String DAKUHIKTRENNO            = "dakuhiktrenno";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String TKNZKKBN                 = "tknzkkbn";
    public static final String TUMAHTNPKBN              = "tumahtnpkbn";
    public static final String KOHTNPKBN                = "kohtnpkbn";
    public static final String SEIGENS                  = "seigens";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SyouhnTokujyouRireki primaryKey;

    public GenHT_SyouhnTokujyouRireki() {
        primaryKey = new PKHT_SyouhnTokujyouRireki();
    }

    public GenHT_SyouhnTokujyouRireki(
        String pMosno,
        Integer pDakuhiktrenno,
        String pSyouhncd
    ) {
        primaryKey = new PKHT_SyouhnTokujyouRireki(
            pMosno,
            pDakuhiktrenno,
            pSyouhncd
        );
    }

    @Transient
    @Override
    public PKHT_SyouhnTokujyouRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SyouhnTokujyouRireki> getMetaClass() {
        return QHT_SyouhnTokujyouRireki.class;
    }

    @Id
    @Column(name=GenHT_SyouhnTokujyouRireki.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Column(name=GenHT_SyouhnTokujyouRireki.DAKUHIKTRENNO)
    public Integer getDakuhiktrenno() {
        return getPrimaryKey().getDakuhiktrenno();
    }

    public void setDakuhiktrenno(Integer pDakuhiktrenno) {
        getPrimaryKey().setDakuhiktrenno(pDakuhiktrenno);
    }

    @Id
    @Column(name=GenHT_SyouhnTokujyouRireki.SYOUHNCD)
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

    private Integer syouhnsdno;

    @Column(name=GenHT_SyouhnTokujyouRireki.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private C_TknzkKbn tknzkkbn;

    @Type(type="UserType_C_TknzkKbn")
    @Column(name=GenHT_SyouhnTokujyouRireki.TKNZKKBN)
    public C_TknzkKbn getTknzkkbn() {
        return tknzkkbn;
    }

    public void setTknzkkbn(C_TknzkKbn pTknzkkbn) {
        tknzkkbn = pTknzkkbn;
    }

    private C_TumahtnpKbn tumahtnpkbn;

    @Type(type="UserType_C_TumahtnpKbn")
    @Column(name=GenHT_SyouhnTokujyouRireki.TUMAHTNPKBN)
    public C_TumahtnpKbn getTumahtnpkbn() {
        return tumahtnpkbn;
    }

    public void setTumahtnpkbn(C_TumahtnpKbn pTumahtnpkbn) {
        tumahtnpkbn = pTumahtnpkbn;
    }

    private C_KohtnpKbn kohtnpkbn;

    @Type(type="UserType_C_KohtnpKbn")
    @Column(name=GenHT_SyouhnTokujyouRireki.KOHTNPKBN)
    public C_KohtnpKbn getKohtnpkbn() {
        return kohtnpkbn;
    }

    public void setKohtnpkbn(C_KohtnpKbn pKohtnpkbn) {
        kohtnpkbn = pKohtnpkbn;
    }

    private BizCurrency seigens;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeigens() {
        return seigens;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSeigens(BizCurrency pSeigens) {
        seigens = pSeigens;
        seigensValue = null;
        seigensType  = null;
    }

    transient private BigDecimal seigensValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEIGENS, nullable=true)
    protected BigDecimal getSeigensValue() {
        if (seigensValue == null && seigens != null) {
            if (seigens.isOptional()) return null;
            return seigens.absolute();
        }
        return seigensValue;
    }

    protected void setSeigensValue(BigDecimal value) {
        seigensValue = value;
        seigens = Optional.fromNullable(toCurrencyType(seigensType))
            .transform(bizCurrencyTransformer(getSeigensValue()))
            .orNull();
    }

    transient private String seigensType = null;

    @Column(name=SEIGENS + "$", nullable=true)
    protected String getSeigensType() {
        if (seigensType == null && seigens != null) return seigens.getType().toString();
        if (seigensType == null && getSeigensValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seigens$' should not be NULL."));
        }
        return seigensType;
    }

    protected void setSeigensType(String type) {
        seigensType = type;
        seigens = Optional.fromNullable(toCurrencyType(seigensType))
            .transform(bizCurrencyTransformer(getSeigensValue()))
            .orNull();
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SyouhnTokujyouRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SyouhnTokujyouRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}