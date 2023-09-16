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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinIdouKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_SikinIdouListSks;
import yuyu.def.db.id.PKBT_SikinIdouListSks;
import yuyu.def.db.meta.GenQBT_SikinIdouListSks;
import yuyu.def.db.meta.QBT_SikinIdouListSks;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SikinIdouKbn;
import yuyu.def.db.type.UserType_C_SikinidougroupKbn;
import yuyu.def.db.type.UserType_C_SikinidoumeisaiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 資金移動リスト作成用テーブル テーブルのマッピング情報クラスで、 {@link BT_SikinIdouListSks} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_SikinIdouListSks}</td><td colspan="3">資金移動リスト作成用テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">{@link PKBT_SikinIdouListSks ○}</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">{@link PKBT_SikinIdouListSks ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">{@link PKBT_SikinIdouListSks ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTyakkinymd tyakkinymd}</td><td>着金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKeiyakutuukagk keiyakutuukagk}</td><td>契約通貨金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSiharaituukagk siharaituukagk}</td><td>支払通貨金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSikinidoukbn sikinidoukbn}</td><td>資金移動区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinIdouKbn}</td></tr>
 *  <tr><td>{@link #getSikinidougroupkbn sikinidougroupkbn}</td><td>資金移動グループ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinidougroupKbn}</td></tr>
 *  <tr><td>{@link #getSikinidoumeisaikbn sikinidoumeisaikbn}</td><td>資金移動明細区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinidoumeisaiKbn}</td></tr>
 * </table>
 * @see     BT_SikinIdouListSks
 * @see     PKBT_SikinIdouListSks
 * @see     QBT_SikinIdouListSks
 * @see     GenQBT_SikinIdouListSks
 */
@MappedSuperclass
@Table(name=GenBT_SikinIdouListSks.TABLE_NAME)
@IdClass(value=PKBT_SikinIdouListSks.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DensysKbn", typeClass=UserType_C_DensysKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_SikinIdouKbn", typeClass=UserType_C_SikinIdouKbn.class),
    @TypeDef(name="UserType_C_SikinidougroupKbn", typeClass=UserType_C_SikinidougroupKbn.class),
    @TypeDef(name="UserType_C_SikinidoumeisaiKbn", typeClass=UserType_C_SikinidoumeisaiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBT_SikinIdouListSks extends AbstractExDBEntity<BT_SikinIdouListSks, PKBT_SikinIdouListSks> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_SikinIdouListSks";
    public static final String DENSYSKBN                = "densyskbn";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String TYAKKINYMD               = "tyakkinymd";
    public static final String SEG1CD                   = "seg1cd";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String KEIYAKUTUUKAGK           = "keiyakutuukagk";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SIHARAITUUKAGK           = "siharaituukagk";
    public static final String SIKINIDOUKBN             = "sikinidoukbn";
    public static final String SIKINIDOUGROUPKBN        = "sikinidougroupkbn";
    public static final String SIKINIDOUMEISAIKBN       = "sikinidoumeisaikbn";

    private final PKBT_SikinIdouListSks primaryKey;

    public GenBT_SikinIdouListSks() {
        primaryKey = new PKBT_SikinIdouListSks();
    }

    public GenBT_SikinIdouListSks(
        C_DensysKbn pDensyskbn,
        String pDenrenno,
        Integer pEdano
    ) {
        primaryKey = new PKBT_SikinIdouListSks(
            pDensyskbn,
            pDenrenno,
            pEdano
        );
    }

    @Transient
    @Override
    public PKBT_SikinIdouListSks getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_SikinIdouListSks> getMetaClass() {
        return QBT_SikinIdouListSks.class;
    }

    @Id
    @Type(type="UserType_C_DensysKbn")
    @Column(name=GenBT_SikinIdouListSks.DENSYSKBN)
    public C_DensysKbn getDensyskbn() {
        return getPrimaryKey().getDensyskbn();
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        getPrimaryKey().setDensyskbn(pDensyskbn);
    }

    @Id
    @Column(name=GenBT_SikinIdouListSks.DENRENNO)
    public String getDenrenno() {
        return getPrimaryKey().getDenrenno();
    }

    public void setDenrenno(String pDenrenno) {
        getPrimaryKey().setDenrenno(pDenrenno);
    }

    @Id
    @Column(name=GenBT_SikinIdouListSks.EDANO)
    public Integer getEdano() {
        return getPrimaryKey().getEdano();
    }

    public void setEdano(Integer pEdano) {
        getPrimaryKey().setEdano(pEdano);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenBT_SikinIdouListSks.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private BizDate tyakkinymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_SikinIdouListSks.TYAKKINYMD)
    @ValidDate
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenBT_SikinIdouListSks.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_SikinIdouListSks.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizCurrency keiyakutuukagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKeiyakutuukagk() {
        return keiyakutuukagk;
    }

    public void setKeiyakutuukagk(BizCurrency pKeiyakutuukagk) {
        keiyakutuukagk = pKeiyakutuukagk;
        keiyakutuukagkValue = null;
        keiyakutuukagkType  = null;
    }

    transient private BigDecimal keiyakutuukagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KEIYAKUTUUKAGK, nullable=true)
    protected BigDecimal getKeiyakutuukagkValue() {
        if (keiyakutuukagkValue == null && keiyakutuukagk != null) {
            if (keiyakutuukagk.isOptional()) return null;
            return keiyakutuukagk.absolute();
        }
        return keiyakutuukagkValue;
    }

    protected void setKeiyakutuukagkValue(BigDecimal value) {
        keiyakutuukagkValue = value;
        keiyakutuukagk = Optional.fromNullable(toCurrencyType(keiyakutuukagkType))
            .transform(bizCurrencyTransformer(getKeiyakutuukagkValue()))
            .orNull();
    }

    transient private String keiyakutuukagkType = null;

    @Column(name=KEIYAKUTUUKAGK + "$", nullable=true)
    protected String getKeiyakutuukagkType() {
        if (keiyakutuukagkType == null && keiyakutuukagk != null) return keiyakutuukagk.getType().toString();
        if (keiyakutuukagkType == null && getKeiyakutuukagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'keiyakutuukagk$' should not be NULL."));
        }
        return keiyakutuukagkType;
    }

    protected void setKeiyakutuukagkType(String type) {
        keiyakutuukagkType = type;
        keiyakutuukagk = Optional.fromNullable(toCurrencyType(keiyakutuukagkType))
            .transform(bizCurrencyTransformer(getKeiyakutuukagkValue()))
            .orNull();
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_SikinIdouListSks.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizCurrency siharaituukagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSiharaituukagk() {
        return siharaituukagk;
    }

    public void setSiharaituukagk(BizCurrency pSiharaituukagk) {
        siharaituukagk = pSiharaituukagk;
        siharaituukagkValue = null;
        siharaituukagkType  = null;
    }

    transient private BigDecimal siharaituukagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SIHARAITUUKAGK, nullable=true)
    protected BigDecimal getSiharaituukagkValue() {
        if (siharaituukagkValue == null && siharaituukagk != null) {
            if (siharaituukagk.isOptional()) return null;
            return siharaituukagk.absolute();
        }
        return siharaituukagkValue;
    }

    protected void setSiharaituukagkValue(BigDecimal value) {
        siharaituukagkValue = value;
        siharaituukagk = Optional.fromNullable(toCurrencyType(siharaituukagkType))
            .transform(bizCurrencyTransformer(getSiharaituukagkValue()))
            .orNull();
    }

    transient private String siharaituukagkType = null;

    @Column(name=SIHARAITUUKAGK + "$", nullable=true)
    protected String getSiharaituukagkType() {
        if (siharaituukagkType == null && siharaituukagk != null) return siharaituukagk.getType().toString();
        if (siharaituukagkType == null && getSiharaituukagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'siharaituukagk$' should not be NULL."));
        }
        return siharaituukagkType;
    }

    protected void setSiharaituukagkType(String type) {
        siharaituukagkType = type;
        siharaituukagk = Optional.fromNullable(toCurrencyType(siharaituukagkType))
            .transform(bizCurrencyTransformer(getSiharaituukagkValue()))
            .orNull();
    }

    private C_SikinIdouKbn sikinidoukbn;

    @Type(type="UserType_C_SikinIdouKbn")
    @Column(name=GenBT_SikinIdouListSks.SIKINIDOUKBN)
    public C_SikinIdouKbn getSikinidoukbn() {
        return sikinidoukbn;
    }

    public void setSikinidoukbn(C_SikinIdouKbn pSikinidoukbn) {
        sikinidoukbn = pSikinidoukbn;
    }

    private C_SikinidougroupKbn sikinidougroupkbn;

    @Type(type="UserType_C_SikinidougroupKbn")
    @Column(name=GenBT_SikinIdouListSks.SIKINIDOUGROUPKBN)
    public C_SikinidougroupKbn getSikinidougroupkbn() {
        return sikinidougroupkbn;
    }

    public void setSikinidougroupkbn(C_SikinidougroupKbn pSikinidougroupkbn) {
        sikinidougroupkbn = pSikinidougroupkbn;
    }

    private C_SikinidoumeisaiKbn sikinidoumeisaikbn;

    @Type(type="UserType_C_SikinidoumeisaiKbn")
    @Column(name=GenBT_SikinIdouListSks.SIKINIDOUMEISAIKBN)
    public C_SikinidoumeisaiKbn getSikinidoumeisaikbn() {
        return sikinidoumeisaikbn;
    }

    public void setSikinidoumeisaikbn(C_SikinidoumeisaiKbn pSikinidoumeisaikbn) {
        sikinidoumeisaikbn = pSikinidoumeisaikbn;
    }
}