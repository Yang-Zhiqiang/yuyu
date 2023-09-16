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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.id.PKIT_Zennou;
import yuyu.def.db.meta.GenQIT_Zennou;
import yuyu.def.db.meta.QIT_Zennou;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_ZennouSeisanKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 前納テーブル テーブルのマッピング情報クラスで、 {@link IT_Zennou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_Zennou}</td><td colspan="3">前納テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_Zennou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_Zennou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennoukaisiymd zennoukaisiymd}</td><td>前納開始年月日</td><td align="center">{@link PKIT_Zennou ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_Zennou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZennounyuukinsyoriymd zennounyuukinsyoriymd}</td><td>前納入金処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennounyuukindenno zennounyuukindenno}</td><td>前納入金伝票番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennounyuukindenymd zennounyuukindenymd}</td><td>前納入金伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTyakkinymd tyakkinymd}</td><td>着金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennoukikan zennoukikan}</td><td>前納期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennounyuukinkgk zennounyuukinkgk}</td><td>前納入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennounyuukinkgkrstk zennounyuukinkgkrstk}</td><td>前納入金額（領収通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennoujihrkp zennoujihrkp}</td><td>前納時払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRstuukasyu rstuukasyu}</td><td>領収通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getRyosyukwsratekjymd ryosyukwsratekjymd}</td><td>領収為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRyosyukwsrate ryosyukwsrate}</td><td>領収為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZennouseisankbn zennouseisankbn}</td><td>前納精算区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZennouSeisanKbn}</td></tr>
 *  <tr><td>{@link #getZennouseisansyoriymd zennouseisansyoriymd}</td><td>前納精算処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennouseisankgk zennouseisankgk}</td><td>前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennouseisankgkshrtk zennouseisankgkshrtk}</td><td>前納精算金額（支払通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrkwsratekjnymd shrkwsratekjnymd}</td><td>支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrkwsrate shrkwsrate}</td><td>支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZennouseisankijyunymd zennouseisankijyunymd}</td><td>前納精算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennouseisandenymd zennouseisandenymd}</td><td>前納精算伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAnnaisaikaiym annaisaikaiym}</td><td>案内再開年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getYenkansannyknkingk yenkansannyknkingk}</td><td>円換算入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansantkykwsrateymd yenkansantkykwsrateymd}</td><td>円換算適用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYenkansantkykwsrate yenkansantkykwsrate}</td><td>円換算適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKjsmyouzennoukaisiymd kjsmyouzennoukaisiymd}</td><td>控除証明用前納開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKjsmyouzennoukikanm kjsmyouzennoukikanm}</td><td>控除証明用前納期間（月）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjsmyouzennounyuukinkgk kjsmyouzennounyuukinkgk}</td><td>控除証明用前納入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKjsmyouyenkansanrateymd kjsmyouyenkansanrateymd}</td><td>控除証明用円換算レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKjsmyouyenkansankwsrate kjsmyouyenkansankwsrate}</td><td>控除証明用円換算為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_Zennou
 * @see     PKIT_Zennou
 * @see     QIT_Zennou
 * @see     GenQIT_Zennou
 */
@MappedSuperclass
@Table(name=GenIT_Zennou.TABLE_NAME)
@IdClass(value=PKIT_Zennou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_ZennouSeisanKbn", typeClass=UserType_C_ZennouSeisanKbn.class)
})
public abstract class GenIT_Zennou extends AbstractExDBEntity<IT_Zennou, PKIT_Zennou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_Zennou";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String ZENNOUKAISIYMD           = "zennoukaisiymd";
    public static final String RENNO                    = "renno";
    public static final String ZENNOUNYUUKINSYORIYMD    = "zennounyuukinsyoriymd";
    public static final String ZENNOUNYUUKINDENNO       = "zennounyuukindenno";
    public static final String ZENNOUNYUUKINDENYMD      = "zennounyuukindenymd";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String TYAKKINYMD               = "tyakkinymd";
    public static final String ZENNOUKIKAN              = "zennoukikan";
    public static final String ZENNOUNYUUKINKGK         = "zennounyuukinkgk";
    public static final String ZENNOUNYUUKINKGKRSTK     = "zennounyuukinkgkrstk";
    public static final String ZENNOUJIHRKP             = "zennoujihrkp";
    public static final String RSTUUKASYU               = "rstuukasyu";
    public static final String RYOSYUKWSRATEKJYMD       = "ryosyukwsratekjymd";
    public static final String RYOSYUKWSRATE            = "ryosyukwsrate";
    public static final String ZENNOUSEISANKBN          = "zennouseisankbn";
    public static final String ZENNOUSEISANSYORIYMD     = "zennouseisansyoriymd";
    public static final String ZENNOUSEISANKGK          = "zennouseisankgk";
    public static final String ZENNOUSEISANKGKSHRTK     = "zennouseisankgkshrtk";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRKWSRATEKJNYMD         = "shrkwsratekjnymd";
    public static final String SHRKWSRATE               = "shrkwsrate";
    public static final String ZENNOUSEISANKIJYUNYMD    = "zennouseisankijyunymd";
    public static final String ZENNOUSEISANDENYMD       = "zennouseisandenymd";
    public static final String ANNAISAIKAIYM            = "annaisaikaiym";
    public static final String YENKANSANNYKNKINGK       = "yenkansannyknkingk";
    public static final String YENKANSANTKYKWSRATEYMD   = "yenkansantkykwsrateymd";
    public static final String YENKANSANTKYKWSRATE      = "yenkansantkykwsrate";
    public static final String KJSMYOUZENNOUKAISIYMD    = "kjsmyouzennoukaisiymd";
    public static final String KJSMYOUZENNOUKIKANM      = "kjsmyouzennoukikanm";
    public static final String KJSMYOUZENNOUNYUUKINKGK  = "kjsmyouzennounyuukinkgk";
    public static final String KJSMYOUYENKANSANRATEYMD  = "kjsmyouyenkansanrateymd";
    public static final String KJSMYOUYENKANSANKWSRATE  = "kjsmyouyenkansankwsrate";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_Zennou primaryKey;

    public GenIT_Zennou() {
        primaryKey = new PKIT_Zennou();
    }

    public GenIT_Zennou(
        String pKbnkey,
        String pSyono,
        BizDate pZennoukaisiymd,
        Integer pRenno
    ) {
        primaryKey = new PKIT_Zennou(
            pKbnkey,
            pSyono,
            pZennoukaisiymd,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_Zennou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_Zennou> getMetaClass() {
        return QIT_Zennou.class;
    }

    @Id
    @Column(name=GenIT_Zennou.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_Zennou.SYONO)
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
    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.ZENNOUKAISIYMD)
    public BizDate getZennoukaisiymd() {
        return getPrimaryKey().getZennoukaisiymd();
    }

    public void setZennoukaisiymd(BizDate pZennoukaisiymd) {
        getPrimaryKey().setZennoukaisiymd(pZennoukaisiymd);
    }

    @Id
    @Column(name=GenIT_Zennou.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate zennounyuukinsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.ZENNOUNYUUKINSYORIYMD)
    public BizDate getZennounyuukinsyoriymd() {
        return zennounyuukinsyoriymd;
    }

    public void setZennounyuukinsyoriymd(BizDate pZennounyuukinsyoriymd) {
        zennounyuukinsyoriymd = pZennounyuukinsyoriymd;
    }

    private String zennounyuukindenno;

    @Column(name=GenIT_Zennou.ZENNOUNYUUKINDENNO)
    public String getZennounyuukindenno() {
        return zennounyuukindenno;
    }

    public void setZennounyuukindenno(String pZennounyuukindenno) {
        zennounyuukindenno = pZennounyuukindenno;
    }

    private BizDate zennounyuukindenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.ZENNOUNYUUKINDENYMD)
    public BizDate getZennounyuukindenymd() {
        return zennounyuukindenymd;
    }

    public void setZennounyuukindenymd(BizDate pZennounyuukindenymd) {
        zennounyuukindenymd = pZennounyuukindenymd;
    }

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private BizDate tyakkinymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.TYAKKINYMD)
    @ValidDate
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private String zennoukikan;

    @Column(name=GenIT_Zennou.ZENNOUKIKAN)
    public String getZennoukikan() {
        return zennoukikan;
    }

    public void setZennoukikan(String pZennoukikan) {
        zennoukikan = pZennoukikan;
    }

    private BizCurrency zennounyuukinkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennounyuukinkgk() {
        return zennounyuukinkgk;
    }

    public void setZennounyuukinkgk(BizCurrency pZennounyuukinkgk) {
        zennounyuukinkgk = pZennounyuukinkgk;
        zennounyuukinkgkValue = null;
        zennounyuukinkgkType  = null;
    }

    transient private BigDecimal zennounyuukinkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUNYUUKINKGK, nullable=true)
    protected BigDecimal getZennounyuukinkgkValue() {
        if (zennounyuukinkgkValue == null && zennounyuukinkgk != null) {
            if (zennounyuukinkgk.isOptional()) return null;
            return zennounyuukinkgk.absolute();
        }
        return zennounyuukinkgkValue;
    }

    protected void setZennounyuukinkgkValue(BigDecimal value) {
        zennounyuukinkgkValue = value;
        zennounyuukinkgk = Optional.fromNullable(toCurrencyType(zennounyuukinkgkType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgkValue()))
            .orNull();
    }

    transient private String zennounyuukinkgkType = null;

    @Column(name=ZENNOUNYUUKINKGK + "$", nullable=true)
    protected String getZennounyuukinkgkType() {
        if (zennounyuukinkgkType == null && zennounyuukinkgk != null) return zennounyuukinkgk.getType().toString();
        if (zennounyuukinkgkType == null && getZennounyuukinkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennounyuukinkgk$' should not be NULL."));
        }
        return zennounyuukinkgkType;
    }

    protected void setZennounyuukinkgkType(String type) {
        zennounyuukinkgkType = type;
        zennounyuukinkgk = Optional.fromNullable(toCurrencyType(zennounyuukinkgkType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgkValue()))
            .orNull();
    }

    private BizCurrency zennounyuukinkgkrstk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennounyuukinkgkrstk() {
        return zennounyuukinkgkrstk;
    }

    public void setZennounyuukinkgkrstk(BizCurrency pZennounyuukinkgkrstk) {
        zennounyuukinkgkrstk = pZennounyuukinkgkrstk;
        zennounyuukinkgkrstkValue = null;
        zennounyuukinkgkrstkType  = null;
    }

    transient private BigDecimal zennounyuukinkgkrstkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUNYUUKINKGKRSTK, nullable=true)
    protected BigDecimal getZennounyuukinkgkrstkValue() {
        if (zennounyuukinkgkrstkValue == null && zennounyuukinkgkrstk != null) {
            if (zennounyuukinkgkrstk.isOptional()) return null;
            return zennounyuukinkgkrstk.absolute();
        }
        return zennounyuukinkgkrstkValue;
    }

    protected void setZennounyuukinkgkrstkValue(BigDecimal value) {
        zennounyuukinkgkrstkValue = value;
        zennounyuukinkgkrstk = Optional.fromNullable(toCurrencyType(zennounyuukinkgkrstkType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgkrstkValue()))
            .orNull();
    }

    transient private String zennounyuukinkgkrstkType = null;

    @Column(name=ZENNOUNYUUKINKGKRSTK + "$", nullable=true)
    protected String getZennounyuukinkgkrstkType() {
        if (zennounyuukinkgkrstkType == null && zennounyuukinkgkrstk != null) return zennounyuukinkgkrstk.getType().toString();
        if (zennounyuukinkgkrstkType == null && getZennounyuukinkgkrstkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennounyuukinkgkrstk$' should not be NULL."));
        }
        return zennounyuukinkgkrstkType;
    }

    protected void setZennounyuukinkgkrstkType(String type) {
        zennounyuukinkgkrstkType = type;
        zennounyuukinkgkrstk = Optional.fromNullable(toCurrencyType(zennounyuukinkgkrstkType))
            .transform(bizCurrencyTransformer(getZennounyuukinkgkrstkValue()))
            .orNull();
    }

    private BizCurrency zennoujihrkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennoujihrkp() {
        return zennoujihrkp;
    }

    public void setZennoujihrkp(BizCurrency pZennoujihrkp) {
        zennoujihrkp = pZennoujihrkp;
        zennoujihrkpValue = null;
        zennoujihrkpType  = null;
    }

    transient private BigDecimal zennoujihrkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUJIHRKP, nullable=true)
    protected BigDecimal getZennoujihrkpValue() {
        if (zennoujihrkpValue == null && zennoujihrkp != null) {
            if (zennoujihrkp.isOptional()) return null;
            return zennoujihrkp.absolute();
        }
        return zennoujihrkpValue;
    }

    protected void setZennoujihrkpValue(BigDecimal value) {
        zennoujihrkpValue = value;
        zennoujihrkp = Optional.fromNullable(toCurrencyType(zennoujihrkpType))
            .transform(bizCurrencyTransformer(getZennoujihrkpValue()))
            .orNull();
    }

    transient private String zennoujihrkpType = null;

    @Column(name=ZENNOUJIHRKP + "$", nullable=true)
    protected String getZennoujihrkpType() {
        if (zennoujihrkpType == null && zennoujihrkp != null) return zennoujihrkp.getType().toString();
        if (zennoujihrkpType == null && getZennoujihrkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennoujihrkp$' should not be NULL."));
        }
        return zennoujihrkpType;
    }

    protected void setZennoujihrkpType(String type) {
        zennoujihrkpType = type;
        zennoujihrkp = Optional.fromNullable(toCurrencyType(zennoujihrkpType))
            .transform(bizCurrencyTransformer(getZennoujihrkpValue()))
            .orNull();
    }

    private C_Tuukasyu rstuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_Zennou.RSTUUKASYU)
    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    private BizDate ryosyukwsratekjymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.RYOSYUKWSRATEKJYMD)
    public BizDate getRyosyukwsratekjymd() {
        return ryosyukwsratekjymd;
    }

    public void setRyosyukwsratekjymd(BizDate pRyosyukwsratekjymd) {
        ryosyukwsratekjymd = pRyosyukwsratekjymd;
    }

    private BizNumber ryosyukwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Zennou.RYOSYUKWSRATE)
    public BizNumber getRyosyukwsrate() {
        return ryosyukwsrate;
    }

    public void setRyosyukwsrate(BizNumber pRyosyukwsrate) {
        ryosyukwsrate = pRyosyukwsrate;
    }

    private C_ZennouSeisanKbn zennouseisankbn;

    @Type(type="UserType_C_ZennouSeisanKbn")
    @Column(name=GenIT_Zennou.ZENNOUSEISANKBN)
    public C_ZennouSeisanKbn getZennouseisankbn() {
        return zennouseisankbn;
    }

    public void setZennouseisankbn(C_ZennouSeisanKbn pZennouseisankbn) {
        zennouseisankbn = pZennouseisankbn;
    }

    private BizDate zennouseisansyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.ZENNOUSEISANSYORIYMD)
    public BizDate getZennouseisansyoriymd() {
        return zennouseisansyoriymd;
    }

    public void setZennouseisansyoriymd(BizDate pZennouseisansyoriymd) {
        zennouseisansyoriymd = pZennouseisansyoriymd;
    }

    private BizCurrency zennouseisankgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    public void setZennouseisankgk(BizCurrency pZennouseisankgk) {
        zennouseisankgk = pZennouseisankgk;
        zennouseisankgkValue = null;
        zennouseisankgkType  = null;
    }

    transient private BigDecimal zennouseisankgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUSEISANKGK, nullable=true)
    protected BigDecimal getZennouseisankgkValue() {
        if (zennouseisankgkValue == null && zennouseisankgk != null) {
            if (zennouseisankgk.isOptional()) return null;
            return zennouseisankgk.absolute();
        }
        return zennouseisankgkValue;
    }

    protected void setZennouseisankgkValue(BigDecimal value) {
        zennouseisankgkValue = value;
        zennouseisankgk = Optional.fromNullable(toCurrencyType(zennouseisankgkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkValue()))
            .orNull();
    }

    transient private String zennouseisankgkType = null;

    @Column(name=ZENNOUSEISANKGK + "$", nullable=true)
    protected String getZennouseisankgkType() {
        if (zennouseisankgkType == null && zennouseisankgk != null) return zennouseisankgk.getType().toString();
        if (zennouseisankgkType == null && getZennouseisankgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennouseisankgk$' should not be NULL."));
        }
        return zennouseisankgkType;
    }

    protected void setZennouseisankgkType(String type) {
        zennouseisankgkType = type;
        zennouseisankgk = Optional.fromNullable(toCurrencyType(zennouseisankgkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkValue()))
            .orNull();
    }

    private BizCurrency zennouseisankgkshrtk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennouseisankgkshrtk() {
        return zennouseisankgkshrtk;
    }

    public void setZennouseisankgkshrtk(BizCurrency pZennouseisankgkshrtk) {
        zennouseisankgkshrtk = pZennouseisankgkshrtk;
        zennouseisankgkshrtkValue = null;
        zennouseisankgkshrtkType  = null;
    }

    transient private BigDecimal zennouseisankgkshrtkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUSEISANKGKSHRTK, nullable=true)
    protected BigDecimal getZennouseisankgkshrtkValue() {
        if (zennouseisankgkshrtkValue == null && zennouseisankgkshrtk != null) {
            if (zennouseisankgkshrtk.isOptional()) return null;
            return zennouseisankgkshrtk.absolute();
        }
        return zennouseisankgkshrtkValue;
    }

    protected void setZennouseisankgkshrtkValue(BigDecimal value) {
        zennouseisankgkshrtkValue = value;
        zennouseisankgkshrtk = Optional.fromNullable(toCurrencyType(zennouseisankgkshrtkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkshrtkValue()))
            .orNull();
    }

    transient private String zennouseisankgkshrtkType = null;

    @Column(name=ZENNOUSEISANKGKSHRTK + "$", nullable=true)
    protected String getZennouseisankgkshrtkType() {
        if (zennouseisankgkshrtkType == null && zennouseisankgkshrtk != null) return zennouseisankgkshrtk.getType().toString();
        if (zennouseisankgkshrtkType == null && getZennouseisankgkshrtkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennouseisankgkshrtk$' should not be NULL."));
        }
        return zennouseisankgkshrtkType;
    }

    protected void setZennouseisankgkshrtkType(String type) {
        zennouseisankgkshrtkType = type;
        zennouseisankgkshrtk = Optional.fromNullable(toCurrencyType(zennouseisankgkshrtkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkshrtkValue()))
            .orNull();
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_Zennou.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizDate shrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.SHRKWSRATEKJNYMD)
    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    private BizNumber shrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Zennou.SHRKWSRATE)
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private BizDate zennouseisankijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.ZENNOUSEISANKIJYUNYMD)
    public BizDate getZennouseisankijyunymd() {
        return zennouseisankijyunymd;
    }

    public void setZennouseisankijyunymd(BizDate pZennouseisankijyunymd) {
        zennouseisankijyunymd = pZennouseisankijyunymd;
    }

    private BizDate zennouseisandenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.ZENNOUSEISANDENYMD)
    public BizDate getZennouseisandenymd() {
        return zennouseisandenymd;
    }

    public void setZennouseisandenymd(BizDate pZennouseisandenymd) {
        zennouseisandenymd = pZennouseisandenymd;
    }

    private BizDateYM annaisaikaiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_Zennou.ANNAISAIKAIYM)
    public BizDateYM getAnnaisaikaiym() {
        return annaisaikaiym;
    }

    public void setAnnaisaikaiym(BizDateYM pAnnaisaikaiym) {
        annaisaikaiym = pAnnaisaikaiym;
    }

    private BizCurrency yenkansannyknkingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkansannyknkingk() {
        return yenkansannyknkingk;
    }

    public void setYenkansannyknkingk(BizCurrency pYenkansannyknkingk) {
        yenkansannyknkingk = pYenkansannyknkingk;
        yenkansannyknkingkValue = null;
        yenkansannyknkingkType  = null;
    }

    transient private BigDecimal yenkansannyknkingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKANSANNYKNKINGK, nullable=true)
    protected BigDecimal getYenkansannyknkingkValue() {
        if (yenkansannyknkingkValue == null && yenkansannyknkingk != null) {
            if (yenkansannyknkingk.isOptional()) return null;
            return yenkansannyknkingk.absolute();
        }
        return yenkansannyknkingkValue;
    }

    protected void setYenkansannyknkingkValue(BigDecimal value) {
        yenkansannyknkingkValue = value;
        yenkansannyknkingk = Optional.fromNullable(toCurrencyType(yenkansannyknkingkType))
            .transform(bizCurrencyTransformer(getYenkansannyknkingkValue()))
            .orNull();
    }

    transient private String yenkansannyknkingkType = null;

    @Column(name=YENKANSANNYKNKINGK + "$", nullable=true)
    protected String getYenkansannyknkingkType() {
        if (yenkansannyknkingkType == null && yenkansannyknkingk != null) return yenkansannyknkingk.getType().toString();
        if (yenkansannyknkingkType == null && getYenkansannyknkingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkansannyknkingk$' should not be NULL."));
        }
        return yenkansannyknkingkType;
    }

    protected void setYenkansannyknkingkType(String type) {
        yenkansannyknkingkType = type;
        yenkansannyknkingk = Optional.fromNullable(toCurrencyType(yenkansannyknkingkType))
            .transform(bizCurrencyTransformer(getYenkansannyknkingkValue()))
            .orNull();
    }

    private BizDate yenkansantkykwsrateymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.YENKANSANTKYKWSRATEYMD)
    public BizDate getYenkansantkykwsrateymd() {
        return yenkansantkykwsrateymd;
    }

    public void setYenkansantkykwsrateymd(BizDate pYenkansantkykwsrateymd) {
        yenkansantkykwsrateymd = pYenkansantkykwsrateymd;
    }

    private BizNumber yenkansantkykwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Zennou.YENKANSANTKYKWSRATE)
    public BizNumber getYenkansantkykwsrate() {
        return yenkansantkykwsrate;
    }

    public void setYenkansantkykwsrate(BizNumber pYenkansantkykwsrate) {
        yenkansantkykwsrate = pYenkansantkykwsrate;
    }

    private BizDate kjsmyouzennoukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.KJSMYOUZENNOUKAISIYMD)
    public BizDate getKjsmyouzennoukaisiymd() {
        return kjsmyouzennoukaisiymd;
    }

    public void setKjsmyouzennoukaisiymd(BizDate pKjsmyouzennoukaisiymd) {
        kjsmyouzennoukaisiymd = pKjsmyouzennoukaisiymd;
    }

    private String kjsmyouzennoukikanm;

    @Column(name=GenIT_Zennou.KJSMYOUZENNOUKIKANM)
    public String getKjsmyouzennoukikanm() {
        return kjsmyouzennoukikanm;
    }

    public void setKjsmyouzennoukikanm(String pKjsmyouzennoukikanm) {
        kjsmyouzennoukikanm = pKjsmyouzennoukikanm;
    }

    private BizCurrency kjsmyouzennounyuukinkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKjsmyouzennounyuukinkgk() {
        return kjsmyouzennounyuukinkgk;
    }

    public void setKjsmyouzennounyuukinkgk(BizCurrency pKjsmyouzennounyuukinkgk) {
        kjsmyouzennounyuukinkgk = pKjsmyouzennounyuukinkgk;
        kjsmyouzennounyuukinkgkValue = null;
        kjsmyouzennounyuukinkgkType  = null;
    }

    transient private BigDecimal kjsmyouzennounyuukinkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KJSMYOUZENNOUNYUUKINKGK, nullable=true)
    protected BigDecimal getKjsmyouzennounyuukinkgkValue() {
        if (kjsmyouzennounyuukinkgkValue == null && kjsmyouzennounyuukinkgk != null) {
            if (kjsmyouzennounyuukinkgk.isOptional()) return null;
            return kjsmyouzennounyuukinkgk.absolute();
        }
        return kjsmyouzennounyuukinkgkValue;
    }

    protected void setKjsmyouzennounyuukinkgkValue(BigDecimal value) {
        kjsmyouzennounyuukinkgkValue = value;
        kjsmyouzennounyuukinkgk = Optional.fromNullable(toCurrencyType(kjsmyouzennounyuukinkgkType))
            .transform(bizCurrencyTransformer(getKjsmyouzennounyuukinkgkValue()))
            .orNull();
    }

    transient private String kjsmyouzennounyuukinkgkType = null;

    @Column(name=KJSMYOUZENNOUNYUUKINKGK + "$", nullable=true)
    protected String getKjsmyouzennounyuukinkgkType() {
        if (kjsmyouzennounyuukinkgkType == null && kjsmyouzennounyuukinkgk != null) return kjsmyouzennounyuukinkgk.getType().toString();
        if (kjsmyouzennounyuukinkgkType == null && getKjsmyouzennounyuukinkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kjsmyouzennounyuukinkgk$' should not be NULL."));
        }
        return kjsmyouzennounyuukinkgkType;
    }

    protected void setKjsmyouzennounyuukinkgkType(String type) {
        kjsmyouzennounyuukinkgkType = type;
        kjsmyouzennounyuukinkgk = Optional.fromNullable(toCurrencyType(kjsmyouzennounyuukinkgkType))
            .transform(bizCurrencyTransformer(getKjsmyouzennounyuukinkgkValue()))
            .orNull();
    }

    private BizDate kjsmyouyenkansanrateymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Zennou.KJSMYOUYENKANSANRATEYMD)
    public BizDate getKjsmyouyenkansanrateymd() {
        return kjsmyouyenkansanrateymd;
    }

    public void setKjsmyouyenkansanrateymd(BizDate pKjsmyouyenkansanrateymd) {
        kjsmyouyenkansanrateymd = pKjsmyouyenkansanrateymd;
    }

    private BizNumber kjsmyouyenkansankwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Zennou.KJSMYOUYENKANSANKWSRATE)
    public BizNumber getKjsmyouyenkansankwsrate() {
        return kjsmyouyenkansankwsrate;
    }

    public void setKjsmyouyenkansankwsrate(BizNumber pKjsmyouyenkansankwsrate) {
        kjsmyouyenkansankwsrate = pKjsmyouyenkansankwsrate;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_Zennou.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_Zennou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_Zennou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}