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
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyouhnBunruiTmttkinyskKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IW_TmttkinYskWk;
import yuyu.def.db.id.PKIW_TmttkinYskWk;
import yuyu.def.db.meta.GenQIW_TmttkinYskWk;
import yuyu.def.db.meta.QIW_TmttkinYskWk;
import yuyu.def.db.type.UserType_C_SyouhnBunruiTmttkinyskKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 積立金予測ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_TmttkinYskWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_TmttkinYskWk}</td><td colspan="3">積立金予測ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIW_TmttkinYskWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnbunruitmttkinyskkbn syouhnbunruitmttkinyskkbn}</td><td>商品分類積立金予測区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyouhnBunruiTmttkinyskKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyksjkkktyouseiriritu kyksjkkktyouseiriritu}</td><td>契約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTargettkhkumu targettkhkumu}</td><td>ターゲット特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTargettkmokuhyouti targettkmokuhyouti}</td><td>ターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyktuukap kyktuukap}</td><td>契約通貨建保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyktuukatmttkngk kyktuukatmttkngk}</td><td>契約通貨建積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyktuukakaiyakuhrgk kyktuukakaiyakuhrgk}</td><td>契約通貨建解約返戻金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_TmttkinYskWk
 * @see     PKIW_TmttkinYskWk
 * @see     QIW_TmttkinYskWk
 * @see     GenQIW_TmttkinYskWk
 */
@MappedSuperclass
@Table(name=GenIW_TmttkinYskWk.TABLE_NAME)
@IdClass(value=PKIW_TmttkinYskWk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_SyouhnBunruiTmttkinyskKbn", typeClass=UserType_C_SyouhnBunruiTmttkinyskKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIW_TmttkinYskWk extends AbstractExDBEntity<IW_TmttkinYskWk, PKIW_TmttkinYskWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_TmttkinYskWk";
    public static final String SYONO                    = "syono";
    public static final String SYOUHNBUNRUITMTTKINYSKKBN = "syouhnbunruitmttkinyskkbn";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String KYKYMD                   = "kykymd";
    public static final String KYKSJKKKTYOUSEIRIRITU    = "kyksjkkktyouseiriritu";
    public static final String TARGETTKHKUMU            = "targettkhkumu";
    public static final String TARGETTKMOKUHYOUTI       = "targettkmokuhyouti";
    public static final String KYKTUUKAP                = "kyktuukap";
    public static final String KYKTUUKATMTTKNGK         = "kyktuukatmttkngk";
    public static final String KYKTUUKAKAIYAKUHRGK      = "kyktuukakaiyakuhrgk";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIW_TmttkinYskWk primaryKey;

    public GenIW_TmttkinYskWk() {
        primaryKey = new PKIW_TmttkinYskWk();
    }

    public GenIW_TmttkinYskWk(String pSyono) {
        primaryKey = new PKIW_TmttkinYskWk(pSyono);
    }

    @Transient
    @Override
    public PKIW_TmttkinYskWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_TmttkinYskWk> getMetaClass() {
        return QIW_TmttkinYskWk.class;
    }

    @Id
    @Column(name=GenIW_TmttkinYskWk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_SyouhnBunruiTmttkinyskKbn syouhnbunruitmttkinyskkbn;

    @Type(type="UserType_C_SyouhnBunruiTmttkinyskKbn")
    @Column(name=GenIW_TmttkinYskWk.SYOUHNBUNRUITMTTKINYSKKBN)
    public C_SyouhnBunruiTmttkinyskKbn getSyouhnbunruitmttkinyskkbn() {
        return syouhnbunruitmttkinyskkbn;
    }

    public void setSyouhnbunruitmttkinyskkbn(C_SyouhnBunruiTmttkinyskKbn pSyouhnbunruitmttkinyskkbn) {
        syouhnbunruitmttkinyskkbn = pSyouhnbunruitmttkinyskkbn;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIW_TmttkinYskWk.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_TmttkinYskWk.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizNumber kyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIW_TmttkinYskWk.KYKSJKKKTYOUSEIRIRITU)
    public BizNumber getKyksjkkktyouseiriritu() {
        return kyksjkkktyouseiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKyksjkkktyouseiriritu(BizNumber pKyksjkkktyouseiriritu) {
        kyksjkkktyouseiriritu = pKyksjkkktyouseiriritu;
    }

    private C_UmuKbn targettkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIW_TmttkinYskWk.TARGETTKHKUMU)
    public C_UmuKbn getTargettkhkumu() {
        return targettkhkumu;
    }

    public void setTargettkhkumu(C_UmuKbn pTargettkhkumu) {
        targettkhkumu = pTargettkhkumu;
    }

    private Integer targettkmokuhyouti;

    @Column(name=GenIW_TmttkinYskWk.TARGETTKMOKUHYOUTI)
    public Integer getTargettkmokuhyouti() {
        return targettkmokuhyouti;
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

    private BizCurrency kyktuukap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKyktuukap() {
        return kyktuukap;
    }

    public void setKyktuukap(BizCurrency pKyktuukap) {
        kyktuukap = pKyktuukap;
        kyktuukapValue = null;
        kyktuukapType  = null;
    }

    transient private BigDecimal kyktuukapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYKTUUKAP, nullable=true)
    protected BigDecimal getKyktuukapValue() {
        if (kyktuukapValue == null && kyktuukap != null) {
            if (kyktuukap.isOptional()) return null;
            return kyktuukap.absolute();
        }
        return kyktuukapValue;
    }

    protected void setKyktuukapValue(BigDecimal value) {
        kyktuukapValue = value;
        kyktuukap = Optional.fromNullable(toCurrencyType(kyktuukapType))
            .transform(bizCurrencyTransformer(getKyktuukapValue()))
            .orNull();
    }

    transient private String kyktuukapType = null;

    @Column(name=KYKTUUKAP + "$", nullable=true)
    protected String getKyktuukapType() {
        if (kyktuukapType == null && kyktuukap != null) return kyktuukap.getType().toString();
        if (kyktuukapType == null && getKyktuukapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kyktuukap$' should not be NULL."));
        }
        return kyktuukapType;
    }

    protected void setKyktuukapType(String type) {
        kyktuukapType = type;
        kyktuukap = Optional.fromNullable(toCurrencyType(kyktuukapType))
            .transform(bizCurrencyTransformer(getKyktuukapValue()))
            .orNull();
    }

    private BizCurrency kyktuukatmttkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKyktuukatmttkngk() {
        return kyktuukatmttkngk;
    }

    public void setKyktuukatmttkngk(BizCurrency pKyktuukatmttkngk) {
        kyktuukatmttkngk = pKyktuukatmttkngk;
        kyktuukatmttkngkValue = null;
        kyktuukatmttkngkType  = null;
    }

    transient private BigDecimal kyktuukatmttkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYKTUUKATMTTKNGK, nullable=true)
    protected BigDecimal getKyktuukatmttkngkValue() {
        if (kyktuukatmttkngkValue == null && kyktuukatmttkngk != null) {
            if (kyktuukatmttkngk.isOptional()) return null;
            return kyktuukatmttkngk.absolute();
        }
        return kyktuukatmttkngkValue;
    }

    protected void setKyktuukatmttkngkValue(BigDecimal value) {
        kyktuukatmttkngkValue = value;
        kyktuukatmttkngk = Optional.fromNullable(toCurrencyType(kyktuukatmttkngkType))
            .transform(bizCurrencyTransformer(getKyktuukatmttkngkValue()))
            .orNull();
    }

    transient private String kyktuukatmttkngkType = null;

    @Column(name=KYKTUUKATMTTKNGK + "$", nullable=true)
    protected String getKyktuukatmttkngkType() {
        if (kyktuukatmttkngkType == null && kyktuukatmttkngk != null) return kyktuukatmttkngk.getType().toString();
        if (kyktuukatmttkngkType == null && getKyktuukatmttkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kyktuukatmttkngk$' should not be NULL."));
        }
        return kyktuukatmttkngkType;
    }

    protected void setKyktuukatmttkngkType(String type) {
        kyktuukatmttkngkType = type;
        kyktuukatmttkngk = Optional.fromNullable(toCurrencyType(kyktuukatmttkngkType))
            .transform(bizCurrencyTransformer(getKyktuukatmttkngkValue()))
            .orNull();
    }

    private BizCurrency kyktuukakaiyakuhrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKyktuukakaiyakuhrgk() {
        return kyktuukakaiyakuhrgk;
    }

    public void setKyktuukakaiyakuhrgk(BizCurrency pKyktuukakaiyakuhrgk) {
        kyktuukakaiyakuhrgk = pKyktuukakaiyakuhrgk;
        kyktuukakaiyakuhrgkValue = null;
        kyktuukakaiyakuhrgkType  = null;
    }

    transient private BigDecimal kyktuukakaiyakuhrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYKTUUKAKAIYAKUHRGK, nullable=true)
    protected BigDecimal getKyktuukakaiyakuhrgkValue() {
        if (kyktuukakaiyakuhrgkValue == null && kyktuukakaiyakuhrgk != null) {
            if (kyktuukakaiyakuhrgk.isOptional()) return null;
            return kyktuukakaiyakuhrgk.absolute();
        }
        return kyktuukakaiyakuhrgkValue;
    }

    protected void setKyktuukakaiyakuhrgkValue(BigDecimal value) {
        kyktuukakaiyakuhrgkValue = value;
        kyktuukakaiyakuhrgk = Optional.fromNullable(toCurrencyType(kyktuukakaiyakuhrgkType))
            .transform(bizCurrencyTransformer(getKyktuukakaiyakuhrgkValue()))
            .orNull();
    }

    transient private String kyktuukakaiyakuhrgkType = null;

    @Column(name=KYKTUUKAKAIYAKUHRGK + "$", nullable=true)
    protected String getKyktuukakaiyakuhrgkType() {
        if (kyktuukakaiyakuhrgkType == null && kyktuukakaiyakuhrgk != null) return kyktuukakaiyakuhrgk.getType().toString();
        if (kyktuukakaiyakuhrgkType == null && getKyktuukakaiyakuhrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kyktuukakaiyakuhrgk$' should not be NULL."));
        }
        return kyktuukakaiyakuhrgkType;
    }

    protected void setKyktuukakaiyakuhrgkType(String type) {
        kyktuukakaiyakuhrgkType = type;
        kyktuukakaiyakuhrgk = Optional.fromNullable(toCurrencyType(kyktuukakaiyakuhrgkType))
            .transform(bizCurrencyTransformer(getKyktuukakaiyakuhrgkValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_TmttkinYskWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_TmttkinYskWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_TmttkinYskWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}