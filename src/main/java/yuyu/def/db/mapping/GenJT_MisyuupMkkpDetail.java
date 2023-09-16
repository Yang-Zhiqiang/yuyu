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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_MisyuupMkkpDetail;
import yuyu.def.db.id.PKJT_MisyuupMkkpDetail;
import yuyu.def.db.meta.GenQJT_MisyuupMkkpDetail;
import yuyu.def.db.meta.QJT_MisyuupMkkpDetail;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 未収Ｐ未経過Ｐ明細テーブル テーブルのマッピング情報クラスで、 {@link JT_MisyuupMkkpDetail} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_MisyuupMkkpDetail}</td><td colspan="3">未収Ｐ未経過Ｐ明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_MisyuupMkkpDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_MisyuupMkkpDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_MisyuupMkkpDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">{@link PKJT_MisyuupMkkpDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDtlmisyuup dtlmisyuup}</td><td>明細未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDtlmisyuupgaika dtlmisyuupgaika}</td><td>明細未収保険料（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDtlmisyuupgaikayenknsnkngk dtlmisyuupgaikayenknsnkngk}</td><td>明細未収保険料（外貨）円換算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDtlmisyuupiktnkumu dtlmisyuupiktnkumu}</td><td>明細未収保険料一括入金有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDtlmisyuuphrkkaisuu dtlmisyuuphrkkaisuu}</td><td>明細未収保険料払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getDtlmisyuupjtkaisuuy dtlmisyuupjtkaisuuy}</td><td>明細未収保険料充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDtlmisyuupjtkaisuum dtlmisyuupjtkaisuum}</td><td>明細未収保険料充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDtlmisyuupjytym dtlmisyuupjytym}</td><td>明細未収保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getDtlmikeikap dtlmikeikap}</td><td>明細未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDtlmikeikapgaika dtlmikeikapgaika}</td><td>明細未経過保険料（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDtlmikeikapnykdenymd dtlmikeikapnykdenymd}</td><td>明細未経過保険料入金伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDtlmikeikaphrkkaisuu dtlmikeikaphrkkaisuu}</td><td>明細未経過保険料払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getDtlmikeikapjtkaisuuy dtlmikeikapjtkaisuuy}</td><td>明細未経過保険料充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDtlmikeikapjtkaisuum dtlmikeikapjtkaisuum}</td><td>明細未経過保険料充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDtlmikeikapjytym dtlmikeikapjytym}</td><td>明細未経過保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_MisyuupMkkpDetail
 * @see     PKJT_MisyuupMkkpDetail
 * @see     QJT_MisyuupMkkpDetail
 * @see     GenQJT_MisyuupMkkpDetail
 */
@MappedSuperclass
@Table(name=GenJT_MisyuupMkkpDetail.TABLE_NAME)
@IdClass(value=PKJT_MisyuupMkkpDetail.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_MisyuupMkkpDetail extends AbstractExDBEntity<JT_MisyuupMkkpDetail, PKJT_MisyuupMkkpDetail> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_MisyuupMkkpDetail";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String DATARENNO                = "datarenno";
    public static final String DTLMISYUUP               = "dtlmisyuup";
    public static final String DTLMISYUUPGAIKA          = "dtlmisyuupgaika";
    public static final String DTLMISYUUPGAIKAYENKNSNKNGK = "dtlmisyuupgaikayenknsnkngk";
    public static final String DTLMISYUUPIKTNKUMU       = "dtlmisyuupiktnkumu";
    public static final String DTLMISYUUPHRKKAISUU      = "dtlmisyuuphrkkaisuu";
    public static final String DTLMISYUUPJTKAISUUY      = "dtlmisyuupjtkaisuuy";
    public static final String DTLMISYUUPJTKAISUUM      = "dtlmisyuupjtkaisuum";
    public static final String DTLMISYUUPJYTYM          = "dtlmisyuupjytym";
    public static final String DTLMIKEIKAP              = "dtlmikeikap";
    public static final String DTLMIKEIKAPGAIKA         = "dtlmikeikapgaika";
    public static final String DTLMIKEIKAPNYKDENYMD     = "dtlmikeikapnykdenymd";
    public static final String DTLMIKEIKAPHRKKAISUU     = "dtlmikeikaphrkkaisuu";
    public static final String DTLMIKEIKAPJTKAISUUY     = "dtlmikeikapjtkaisuuy";
    public static final String DTLMIKEIKAPJTKAISUUM     = "dtlmikeikapjtkaisuum";
    public static final String DTLMIKEIKAPJYTYM         = "dtlmikeikapjytym";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_MisyuupMkkpDetail primaryKey;

    public GenJT_MisyuupMkkpDetail() {
        primaryKey = new PKJT_MisyuupMkkpDetail();
    }

    public GenJT_MisyuupMkkpDetail(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pDatarenno
    ) {
        primaryKey = new PKJT_MisyuupMkkpDetail(
            pSkno,
            pSyono,
            pSeikyuurirekino,
            pDatarenno
        );
    }

    @Transient
    @Override
    public PKJT_MisyuupMkkpDetail getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_MisyuupMkkpDetail> getMetaClass() {
        return QJT_MisyuupMkkpDetail.class;
    }

    @Id
    @Column(name=GenJT_MisyuupMkkpDetail.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_MisyuupMkkpDetail.SYONO)
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
    @Column(name=GenJT_MisyuupMkkpDetail.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    @Id
    @Column(name=GenJT_MisyuupMkkpDetail.DATARENNO)
    public Integer getDatarenno() {
        return getPrimaryKey().getDatarenno();
    }

    public void setDatarenno(Integer pDatarenno) {
        getPrimaryKey().setDatarenno(pDatarenno);
    }

    private BizCurrency dtlmisyuup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDtlmisyuup() {
        return dtlmisyuup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDtlmisyuup(BizCurrency pDtlmisyuup) {
        dtlmisyuup = pDtlmisyuup;
        dtlmisyuupValue = null;
        dtlmisyuupType  = null;
    }

    transient private BigDecimal dtlmisyuupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DTLMISYUUP, nullable=true)
    protected BigDecimal getDtlmisyuupValue() {
        if (dtlmisyuupValue == null && dtlmisyuup != null) {
            if (dtlmisyuup.isOptional()) return null;
            return dtlmisyuup.absolute();
        }
        return dtlmisyuupValue;
    }

    protected void setDtlmisyuupValue(BigDecimal value) {
        dtlmisyuupValue = value;
        dtlmisyuup = Optional.fromNullable(toCurrencyType(dtlmisyuupType))
            .transform(bizCurrencyTransformer(getDtlmisyuupValue()))
            .orNull();
    }

    transient private String dtlmisyuupType = null;

    @Column(name=DTLMISYUUP + "$", nullable=true)
    protected String getDtlmisyuupType() {
        if (dtlmisyuupType == null && dtlmisyuup != null) return dtlmisyuup.getType().toString();
        if (dtlmisyuupType == null && getDtlmisyuupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dtlmisyuup$' should not be NULL."));
        }
        return dtlmisyuupType;
    }

    protected void setDtlmisyuupType(String type) {
        dtlmisyuupType = type;
        dtlmisyuup = Optional.fromNullable(toCurrencyType(dtlmisyuupType))
            .transform(bizCurrencyTransformer(getDtlmisyuupValue()))
            .orNull();
    }

    private BizCurrency dtlmisyuupgaika;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDtlmisyuupgaika() {
        return dtlmisyuupgaika;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDtlmisyuupgaika(BizCurrency pDtlmisyuupgaika) {
        dtlmisyuupgaika = pDtlmisyuupgaika;
        dtlmisyuupgaikaValue = null;
        dtlmisyuupgaikaType  = null;
    }

    transient private BigDecimal dtlmisyuupgaikaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DTLMISYUUPGAIKA, nullable=true)
    protected BigDecimal getDtlmisyuupgaikaValue() {
        if (dtlmisyuupgaikaValue == null && dtlmisyuupgaika != null) {
            if (dtlmisyuupgaika.isOptional()) return null;
            return dtlmisyuupgaika.absolute();
        }
        return dtlmisyuupgaikaValue;
    }

    protected void setDtlmisyuupgaikaValue(BigDecimal value) {
        dtlmisyuupgaikaValue = value;
        dtlmisyuupgaika = Optional.fromNullable(toCurrencyType(dtlmisyuupgaikaType))
            .transform(bizCurrencyTransformer(getDtlmisyuupgaikaValue()))
            .orNull();
    }

    transient private String dtlmisyuupgaikaType = null;

    @Column(name=DTLMISYUUPGAIKA + "$", nullable=true)
    protected String getDtlmisyuupgaikaType() {
        if (dtlmisyuupgaikaType == null && dtlmisyuupgaika != null) return dtlmisyuupgaika.getType().toString();
        if (dtlmisyuupgaikaType == null && getDtlmisyuupgaikaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dtlmisyuupgaika$' should not be NULL."));
        }
        return dtlmisyuupgaikaType;
    }

    protected void setDtlmisyuupgaikaType(String type) {
        dtlmisyuupgaikaType = type;
        dtlmisyuupgaika = Optional.fromNullable(toCurrencyType(dtlmisyuupgaikaType))
            .transform(bizCurrencyTransformer(getDtlmisyuupgaikaValue()))
            .orNull();
    }

    private BizCurrency dtlmisyuupgaikayenknsnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDtlmisyuupgaikayenknsnkngk() {
        return dtlmisyuupgaikayenknsnkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDtlmisyuupgaikayenknsnkngk(BizCurrency pDtlmisyuupgaikayenknsnkngk) {
        dtlmisyuupgaikayenknsnkngk = pDtlmisyuupgaikayenknsnkngk;
        dtlmisyuupgaikayenknsnkngkValue = null;
        dtlmisyuupgaikayenknsnkngkType  = null;
    }

    transient private BigDecimal dtlmisyuupgaikayenknsnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DTLMISYUUPGAIKAYENKNSNKNGK, nullable=true)
    protected BigDecimal getDtlmisyuupgaikayenknsnkngkValue() {
        if (dtlmisyuupgaikayenknsnkngkValue == null && dtlmisyuupgaikayenknsnkngk != null) {
            if (dtlmisyuupgaikayenknsnkngk.isOptional()) return null;
            return dtlmisyuupgaikayenknsnkngk.absolute();
        }
        return dtlmisyuupgaikayenknsnkngkValue;
    }

    protected void setDtlmisyuupgaikayenknsnkngkValue(BigDecimal value) {
        dtlmisyuupgaikayenknsnkngkValue = value;
        dtlmisyuupgaikayenknsnkngk = Optional.fromNullable(toCurrencyType(dtlmisyuupgaikayenknsnkngkType))
            .transform(bizCurrencyTransformer(getDtlmisyuupgaikayenknsnkngkValue()))
            .orNull();
    }

    transient private String dtlmisyuupgaikayenknsnkngkType = null;

    @Column(name=DTLMISYUUPGAIKAYENKNSNKNGK + "$", nullable=true)
    protected String getDtlmisyuupgaikayenknsnkngkType() {
        if (dtlmisyuupgaikayenknsnkngkType == null && dtlmisyuupgaikayenknsnkngk != null) return dtlmisyuupgaikayenknsnkngk.getType().toString();
        if (dtlmisyuupgaikayenknsnkngkType == null && getDtlmisyuupgaikayenknsnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dtlmisyuupgaikayenknsnkngk$' should not be NULL."));
        }
        return dtlmisyuupgaikayenknsnkngkType;
    }

    protected void setDtlmisyuupgaikayenknsnkngkType(String type) {
        dtlmisyuupgaikayenknsnkngkType = type;
        dtlmisyuupgaikayenknsnkngk = Optional.fromNullable(toCurrencyType(dtlmisyuupgaikayenknsnkngkType))
            .transform(bizCurrencyTransformer(getDtlmisyuupgaikayenknsnkngkValue()))
            .orNull();
    }

    private C_UmuKbn dtlmisyuupiktnkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_MisyuupMkkpDetail.DTLMISYUUPIKTNKUMU)
    public C_UmuKbn getDtlmisyuupiktnkumu() {
        return dtlmisyuupiktnkumu;
    }

    public void setDtlmisyuupiktnkumu(C_UmuKbn pDtlmisyuupiktnkumu) {
        dtlmisyuupiktnkumu = pDtlmisyuupiktnkumu;
    }

    private C_Hrkkaisuu dtlmisyuuphrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenJT_MisyuupMkkpDetail.DTLMISYUUPHRKKAISUU)
    public C_Hrkkaisuu getDtlmisyuuphrkkaisuu() {
        return dtlmisyuuphrkkaisuu;
    }

    public void setDtlmisyuuphrkkaisuu(C_Hrkkaisuu pDtlmisyuuphrkkaisuu) {
        dtlmisyuuphrkkaisuu = pDtlmisyuuphrkkaisuu;
    }

    private Integer dtlmisyuupjtkaisuuy;

    @Column(name=GenJT_MisyuupMkkpDetail.DTLMISYUUPJTKAISUUY)
    public Integer getDtlmisyuupjtkaisuuy() {
        return dtlmisyuupjtkaisuuy;
    }

    public void setDtlmisyuupjtkaisuuy(Integer pDtlmisyuupjtkaisuuy) {
        dtlmisyuupjtkaisuuy = pDtlmisyuupjtkaisuuy;
    }

    private Integer dtlmisyuupjtkaisuum;

    @Column(name=GenJT_MisyuupMkkpDetail.DTLMISYUUPJTKAISUUM)
    public Integer getDtlmisyuupjtkaisuum() {
        return dtlmisyuupjtkaisuum;
    }

    public void setDtlmisyuupjtkaisuum(Integer pDtlmisyuupjtkaisuum) {
        dtlmisyuupjtkaisuum = pDtlmisyuupjtkaisuum;
    }

    private BizDateYM dtlmisyuupjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_MisyuupMkkpDetail.DTLMISYUUPJYTYM)
    public BizDateYM getDtlmisyuupjytym() {
        return dtlmisyuupjytym;
    }

    public void setDtlmisyuupjytym(BizDateYM pDtlmisyuupjytym) {
        dtlmisyuupjytym = pDtlmisyuupjytym;
    }

    private BizCurrency dtlmikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDtlmikeikap() {
        return dtlmikeikap;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDtlmikeikap(BizCurrency pDtlmikeikap) {
        dtlmikeikap = pDtlmikeikap;
        dtlmikeikapValue = null;
        dtlmikeikapType  = null;
    }

    transient private BigDecimal dtlmikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DTLMIKEIKAP, nullable=true)
    protected BigDecimal getDtlmikeikapValue() {
        if (dtlmikeikapValue == null && dtlmikeikap != null) {
            if (dtlmikeikap.isOptional()) return null;
            return dtlmikeikap.absolute();
        }
        return dtlmikeikapValue;
    }

    protected void setDtlmikeikapValue(BigDecimal value) {
        dtlmikeikapValue = value;
        dtlmikeikap = Optional.fromNullable(toCurrencyType(dtlmikeikapType))
            .transform(bizCurrencyTransformer(getDtlmikeikapValue()))
            .orNull();
    }

    transient private String dtlmikeikapType = null;

    @Column(name=DTLMIKEIKAP + "$", nullable=true)
    protected String getDtlmikeikapType() {
        if (dtlmikeikapType == null && dtlmikeikap != null) return dtlmikeikap.getType().toString();
        if (dtlmikeikapType == null && getDtlmikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dtlmikeikap$' should not be NULL."));
        }
        return dtlmikeikapType;
    }

    protected void setDtlmikeikapType(String type) {
        dtlmikeikapType = type;
        dtlmikeikap = Optional.fromNullable(toCurrencyType(dtlmikeikapType))
            .transform(bizCurrencyTransformer(getDtlmikeikapValue()))
            .orNull();
    }

    private BizCurrency dtlmikeikapgaika;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDtlmikeikapgaika() {
        return dtlmikeikapgaika;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDtlmikeikapgaika(BizCurrency pDtlmikeikapgaika) {
        dtlmikeikapgaika = pDtlmikeikapgaika;
        dtlmikeikapgaikaValue = null;
        dtlmikeikapgaikaType  = null;
    }

    transient private BigDecimal dtlmikeikapgaikaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DTLMIKEIKAPGAIKA, nullable=true)
    protected BigDecimal getDtlmikeikapgaikaValue() {
        if (dtlmikeikapgaikaValue == null && dtlmikeikapgaika != null) {
            if (dtlmikeikapgaika.isOptional()) return null;
            return dtlmikeikapgaika.absolute();
        }
        return dtlmikeikapgaikaValue;
    }

    protected void setDtlmikeikapgaikaValue(BigDecimal value) {
        dtlmikeikapgaikaValue = value;
        dtlmikeikapgaika = Optional.fromNullable(toCurrencyType(dtlmikeikapgaikaType))
            .transform(bizCurrencyTransformer(getDtlmikeikapgaikaValue()))
            .orNull();
    }

    transient private String dtlmikeikapgaikaType = null;

    @Column(name=DTLMIKEIKAPGAIKA + "$", nullable=true)
    protected String getDtlmikeikapgaikaType() {
        if (dtlmikeikapgaikaType == null && dtlmikeikapgaika != null) return dtlmikeikapgaika.getType().toString();
        if (dtlmikeikapgaikaType == null && getDtlmikeikapgaikaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dtlmikeikapgaika$' should not be NULL."));
        }
        return dtlmikeikapgaikaType;
    }

    protected void setDtlmikeikapgaikaType(String type) {
        dtlmikeikapgaikaType = type;
        dtlmikeikapgaika = Optional.fromNullable(toCurrencyType(dtlmikeikapgaikaType))
            .transform(bizCurrencyTransformer(getDtlmikeikapgaikaValue()))
            .orNull();
    }

    private BizDate dtlmikeikapnykdenymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_MisyuupMkkpDetail.DTLMIKEIKAPNYKDENYMD)
    public BizDate getDtlmikeikapnykdenymd() {
        return dtlmikeikapnykdenymd;
    }

    public void setDtlmikeikapnykdenymd(BizDate pDtlmikeikapnykdenymd) {
        dtlmikeikapnykdenymd = pDtlmikeikapnykdenymd;
    }

    private C_Hrkkaisuu dtlmikeikaphrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenJT_MisyuupMkkpDetail.DTLMIKEIKAPHRKKAISUU)
    public C_Hrkkaisuu getDtlmikeikaphrkkaisuu() {
        return dtlmikeikaphrkkaisuu;
    }

    public void setDtlmikeikaphrkkaisuu(C_Hrkkaisuu pDtlmikeikaphrkkaisuu) {
        dtlmikeikaphrkkaisuu = pDtlmikeikaphrkkaisuu;
    }

    private Integer dtlmikeikapjtkaisuuy;

    @Column(name=GenJT_MisyuupMkkpDetail.DTLMIKEIKAPJTKAISUUY)
    public Integer getDtlmikeikapjtkaisuuy() {
        return dtlmikeikapjtkaisuuy;
    }

    public void setDtlmikeikapjtkaisuuy(Integer pDtlmikeikapjtkaisuuy) {
        dtlmikeikapjtkaisuuy = pDtlmikeikapjtkaisuuy;
    }

    private Integer dtlmikeikapjtkaisuum;

    @Column(name=GenJT_MisyuupMkkpDetail.DTLMIKEIKAPJTKAISUUM)
    public Integer getDtlmikeikapjtkaisuum() {
        return dtlmikeikapjtkaisuum;
    }

    public void setDtlmikeikapjtkaisuum(Integer pDtlmikeikapjtkaisuum) {
        dtlmikeikapjtkaisuum = pDtlmikeikapjtkaisuum;
    }

    private BizDateYM dtlmikeikapjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_MisyuupMkkpDetail.DTLMIKEIKAPJYTYM)
    public BizDateYM getDtlmikeikapjytym() {
        return dtlmikeikapjytym;
    }

    public void setDtlmikeikapjytym(BizDateYM pDtlmikeikapjytym) {
        dtlmikeikapjytym = pDtlmikeikapjytym;
    }

    private String kossyoricd;

    @Column(name=GenJT_MisyuupMkkpDetail.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_MisyuupMkkpDetail.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_MisyuupMkkpDetail.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_MisyuupMkkpDetail.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}