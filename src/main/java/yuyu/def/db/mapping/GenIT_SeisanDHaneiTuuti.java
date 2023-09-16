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
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.number.BizCurrency;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_SeisanDHaneiTuuti;
import yuyu.def.db.id.PKIT_SeisanDHaneiTuuti;
import yuyu.def.db.meta.GenQIT_SeisanDHaneiTuuti;
import yuyu.def.db.meta.QIT_SeisanDHaneiTuuti;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 精算Ｄ反映通知テーブル テーブルのマッピング情報クラスで、 {@link IT_SeisanDHaneiTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SeisanDHaneiTuuti}</td><td colspan="3">精算Ｄ反映通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_SeisanDHaneiTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_SeisanDHaneiTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">{@link PKIT_SeisanDHaneiTuuti ○}</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getKakuteitounendod kakuteitounendod}</td><td>確定当年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNaiteitounendod naiteitounendod}</td><td>内定当年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSeisandkgk seisandkgk}</td><td>精算Ｄ金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SeisanDHaneiTuuti
 * @see     PKIT_SeisanDHaneiTuuti
 * @see     QIT_SeisanDHaneiTuuti
 * @see     GenQIT_SeisanDHaneiTuuti
 */
@MappedSuperclass
@Table(name=GenIT_SeisanDHaneiTuuti.TABLE_NAME)
@IdClass(value=PKIT_SeisanDHaneiTuuti.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class)
})
public abstract class GenIT_SeisanDHaneiTuuti extends AbstractExDBEntity<IT_SeisanDHaneiTuuti, PKIT_SeisanDHaneiTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_SeisanDHaneiTuuti";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HAITOUNENDO              = "haitounendo";
    public static final String KAKUTEITOUNENDOD         = "kakuteitounendod";
    public static final String NAITEITOUNENDOD          = "naiteitounendod";
    public static final String SEISANDKGK               = "seisandkgk";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_SeisanDHaneiTuuti primaryKey;

    public GenIT_SeisanDHaneiTuuti() {
        primaryKey = new PKIT_SeisanDHaneiTuuti();
    }

    public GenIT_SeisanDHaneiTuuti(
        String pKbnkey,
        String pSyono,
        BizDateY pHaitounendo
    ) {
        primaryKey = new PKIT_SeisanDHaneiTuuti(
            pKbnkey,
            pSyono,
            pHaitounendo
        );
    }

    @Transient
    @Override
    public PKIT_SeisanDHaneiTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_SeisanDHaneiTuuti> getMetaClass() {
        return QIT_SeisanDHaneiTuuti.class;
    }

    @Id
    @Column(name=GenIT_SeisanDHaneiTuuti.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_SeisanDHaneiTuuti.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Type(type="BizDateYType")
    @Column(name=GenIT_SeisanDHaneiTuuti.HAITOUNENDO)
    public BizDateY getHaitounendo() {
        return getPrimaryKey().getHaitounendo();
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        getPrimaryKey().setHaitounendo(pHaitounendo);
    }

    private BizCurrency kakuteitounendod;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKakuteitounendod() {
        return kakuteitounendod;
    }

    public void setKakuteitounendod(BizCurrency pKakuteitounendod) {
        kakuteitounendod = pKakuteitounendod;
        kakuteitounendodValue = null;
        kakuteitounendodType  = null;
    }

    transient private BigDecimal kakuteitounendodValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAKUTEITOUNENDOD, nullable=true)
    protected BigDecimal getKakuteitounendodValue() {
        if (kakuteitounendodValue == null && kakuteitounendod != null) {
            if (kakuteitounendod.isOptional()) return null;
            return kakuteitounendod.absolute();
        }
        return kakuteitounendodValue;
    }

    protected void setKakuteitounendodValue(BigDecimal value) {
        kakuteitounendodValue = value;
        kakuteitounendod = Optional.fromNullable(toCurrencyType(kakuteitounendodType))
            .transform(bizCurrencyTransformer(getKakuteitounendodValue()))
            .orNull();
    }

    transient private String kakuteitounendodType = null;

    @Column(name=KAKUTEITOUNENDOD + "$", nullable=true)
    protected String getKakuteitounendodType() {
        if (kakuteitounendodType == null && kakuteitounendod != null) return kakuteitounendod.getType().toString();
        if (kakuteitounendodType == null && getKakuteitounendodValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kakuteitounendod$' should not be NULL."));
        }
        return kakuteitounendodType;
    }

    protected void setKakuteitounendodType(String type) {
        kakuteitounendodType = type;
        kakuteitounendod = Optional.fromNullable(toCurrencyType(kakuteitounendodType))
            .transform(bizCurrencyTransformer(getKakuteitounendodValue()))
            .orNull();
    }

    private BizCurrency naiteitounendod;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNaiteitounendod() {
        return naiteitounendod;
    }

    public void setNaiteitounendod(BizCurrency pNaiteitounendod) {
        naiteitounendod = pNaiteitounendod;
        naiteitounendodValue = null;
        naiteitounendodType  = null;
    }

    transient private BigDecimal naiteitounendodValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NAITEITOUNENDOD, nullable=true)
    protected BigDecimal getNaiteitounendodValue() {
        if (naiteitounendodValue == null && naiteitounendod != null) {
            if (naiteitounendod.isOptional()) return null;
            return naiteitounendod.absolute();
        }
        return naiteitounendodValue;
    }

    protected void setNaiteitounendodValue(BigDecimal value) {
        naiteitounendodValue = value;
        naiteitounendod = Optional.fromNullable(toCurrencyType(naiteitounendodType))
            .transform(bizCurrencyTransformer(getNaiteitounendodValue()))
            .orNull();
    }

    transient private String naiteitounendodType = null;

    @Column(name=NAITEITOUNENDOD + "$", nullable=true)
    protected String getNaiteitounendodType() {
        if (naiteitounendodType == null && naiteitounendod != null) return naiteitounendod.getType().toString();
        if (naiteitounendodType == null && getNaiteitounendodValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'naiteitounendod$' should not be NULL."));
        }
        return naiteitounendodType;
    }

    protected void setNaiteitounendodType(String type) {
        naiteitounendodType = type;
        naiteitounendod = Optional.fromNullable(toCurrencyType(naiteitounendodType))
            .transform(bizCurrencyTransformer(getNaiteitounendodValue()))
            .orNull();
    }

    private BizCurrency seisandkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeisandkgk() {
        return seisandkgk;
    }

    public void setSeisandkgk(BizCurrency pSeisandkgk) {
        seisandkgk = pSeisandkgk;
        seisandkgkValue = null;
        seisandkgkType  = null;
    }

    transient private BigDecimal seisandkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEISANDKGK, nullable=true)
    protected BigDecimal getSeisandkgkValue() {
        if (seisandkgkValue == null && seisandkgk != null) {
            if (seisandkgk.isOptional()) return null;
            return seisandkgk.absolute();
        }
        return seisandkgkValue;
    }

    protected void setSeisandkgkValue(BigDecimal value) {
        seisandkgkValue = value;
        seisandkgk = Optional.fromNullable(toCurrencyType(seisandkgkType))
            .transform(bizCurrencyTransformer(getSeisandkgkValue()))
            .orNull();
    }

    transient private String seisandkgkType = null;

    @Column(name=SEISANDKGK + "$", nullable=true)
    protected String getSeisandkgkType() {
        if (seisandkgkType == null && seisandkgk != null) return seisandkgk.getType().toString();
        if (seisandkgkType == null && getSeisandkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seisandkgk$' should not be NULL."));
        }
        return seisandkgkType;
    }

    protected void setSeisandkgkType(String type) {
        seisandkgkType = type;
        seisandkgk = Optional.fromNullable(toCurrencyType(seisandkgkType))
            .transform(bizCurrencyTransformer(getSeisandkgkValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_SeisanDHaneiTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_SeisanDHaneiTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_SeisanDHaneiTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}