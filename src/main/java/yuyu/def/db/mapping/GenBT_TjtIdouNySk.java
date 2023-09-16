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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.id.PKBT_TjtIdouNySk;
import yuyu.def.db.meta.GenQBT_TjtIdouNySk;
import yuyu.def.db.meta.QBT_TjtIdouNySk;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Mfrenflg;
import yuyu.def.db.type.UserType_C_MossyoumetuKbn;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 当日異動内容新契約テーブル テーブルのマッピング情報クラスで、 {@link BT_TjtIdouNySk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_TjtIdouNySk}</td><td colspan="3">当日異動内容新契約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKBT_TjtIdouNySk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKBT_TjtIdouNySk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRecordsakujyohyouji recordsakujyohyouji}</td><td>レコード削除表示</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYoukyuuno youkyuuno}</td><td>要求通番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosymd mosymd}</td><td>申込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeiritukbn seiritukbn}</td><td>成立区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeirituKbn}</td></tr>
 *  <tr><td>{@link #getSrsyoriymd srsyoriymd}</td><td>成立処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMfrenflg mfrenflg}</td><td>ＭＦ連動済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Mfrenflg}</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTsntuukasyu tsntuukasyu}</td><td>通算用通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTsnyousibous tsnyousibous}</td><td>通算用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnyouitijip tsnyouitijip}</td><td>通算用一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnyounkgns tsnyounkgns}</td><td>通算用年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkkkn hrkkkn}</td><td>払込期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSntkhoukbn sntkhoukbn}</td><td>選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkhouKbn}</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKykhhkndouhyouji kykhhkndouhyouji}</td><td>契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMossyoumetukbn mossyoumetukbn}</td><td>申込消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MossyoumetuKbn}</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrtkykumukbn kaigomaehrtkykumukbn}</td><td>介護前払特約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getPyennykntkykumukbn pyennykntkykumukbn}</td><td>保険料円入金特約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTsnyennyknkgk tsnyennyknkgk}</td><td>通算用円入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_TjtIdouNySk
 * @see     PKBT_TjtIdouNySk
 * @see     QBT_TjtIdouNySk
 * @see     GenQBT_TjtIdouNySk
 */
@MappedSuperclass
@Table(name=GenBT_TjtIdouNySk.TABLE_NAME)
@IdClass(value=PKBT_TjtIdouNySk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_Mfrenflg", typeClass=UserType_C_Mfrenflg.class),
    @TypeDef(name="UserType_C_MossyoumetuKbn", typeClass=UserType_C_MossyoumetuKbn.class),
    @TypeDef(name="UserType_C_SeirituKbn", typeClass=UserType_C_SeirituKbn.class),
    @TypeDef(name="UserType_C_SntkhouKbn", typeClass=UserType_C_SntkhouKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenBT_TjtIdouNySk extends AbstractExDBEntity<BT_TjtIdouNySk, PKBT_TjtIdouNySk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_TjtIdouNySk";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String RECORDSAKUJYOHYOUJI      = "recordsakujyohyouji";
    public static final String YOUKYUUNO                = "youkyuuno";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String MOSYMD                   = "mosymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String SEIRITUKBN               = "seiritukbn";
    public static final String SRSYORIYMD               = "srsyoriymd";
    public static final String MFRENFLG                 = "mfrenflg";
    public static final String SYONO                    = "syono";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String TSNTUUKASYU              = "tsntuukasyu";
    public static final String TSNYOUSIBOUS             = "tsnyousibous";
    public static final String TSNYOUITIJIP             = "tsnyouitijip";
    public static final String TSNYOUNKGNS              = "tsnyounkgns";
    public static final String HRKKKN                   = "hrkkkn";
    public static final String SNTKHOUKBN               = "sntkhoukbn";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String KYKHHKNDOUHYOUJI         = "kykhhkndouhyouji";
    public static final String MOSSYOUMETUKBN           = "mossyoumetukbn";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KAIGOMAEHRTKYKUMUKBN     = "kaigomaehrtkykumukbn";
    public static final String PYENNYKNTKYKUMUKBN       = "pyennykntkykumukbn";
    public static final String TSNYENNYKNKGK            = "tsnyennyknkgk";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_TjtIdouNySk primaryKey;

    public GenBT_TjtIdouNySk() {
        primaryKey = new PKBT_TjtIdouNySk();
    }

    public GenBT_TjtIdouNySk(String pMosno, Integer pRenno3keta) {
        primaryKey = new PKBT_TjtIdouNySk(pMosno, pRenno3keta);
    }

    @Transient
    @Override
    public PKBT_TjtIdouNySk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_TjtIdouNySk> getMetaClass() {
        return QBT_TjtIdouNySk.class;
    }

    @Id
    @Column(name=GenBT_TjtIdouNySk.MOSNO)
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
    @Column(name=GenBT_TjtIdouNySk.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private Integer recordsakujyohyouji;

    @Column(name=GenBT_TjtIdouNySk.RECORDSAKUJYOHYOUJI)
    public Integer getRecordsakujyohyouji() {
        return recordsakujyohyouji;
    }

    public void setRecordsakujyohyouji(Integer pRecordsakujyohyouji) {
        recordsakujyohyouji = pRecordsakujyohyouji;
    }

    private String youkyuuno;

    @Column(name=GenBT_TjtIdouNySk.YOUKYUUNO)
    public String getYoukyuuno() {
        return youkyuuno;
    }

    public void setYoukyuuno(String pYoukyuuno) {
        youkyuuno = pYoukyuuno;
    }

    private String syouhncd;

    @Column(name=GenBT_TjtIdouNySk.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    private BizDate mosymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_TjtIdouNySk.MOSYMD)
    @ValidDate
    public BizDate getMosymd() {
        return mosymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_TjtIdouNySk.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate sknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_TjtIdouNySk.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private C_SeirituKbn seiritukbn;

    @Type(type="UserType_C_SeirituKbn")
    @Column(name=GenBT_TjtIdouNySk.SEIRITUKBN)
    public C_SeirituKbn getSeiritukbn() {
        return seiritukbn;
    }

    public void setSeiritukbn(C_SeirituKbn pSeiritukbn) {
        seiritukbn = pSeiritukbn;
    }

    private BizDate srsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_TjtIdouNySk.SRSYORIYMD)
    public BizDate getSrsyoriymd() {
        return srsyoriymd;
    }

    public void setSrsyoriymd(BizDate pSrsyoriymd) {
        srsyoriymd = pSrsyoriymd;
    }

    private C_Mfrenflg mfrenflg;

    @Type(type="UserType_C_Mfrenflg")
    @Column(name=GenBT_TjtIdouNySk.MFRENFLG)
    public C_Mfrenflg getMfrenflg() {
        return mfrenflg;
    }

    public void setMfrenflg(C_Mfrenflg pMfrenflg) {
        mfrenflg = pMfrenflg;
    }

    private String syono;

    @Column(name=GenBT_TjtIdouNySk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_TjtIdouNySk.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu tsntuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_TjtIdouNySk.TSNTUUKASYU)
    public C_Tuukasyu getTsntuukasyu() {
        return tsntuukasyu;
    }

    public void setTsntuukasyu(C_Tuukasyu pTsntuukasyu) {
        tsntuukasyu = pTsntuukasyu;
    }

    private BizCurrency tsnyousibous;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnyousibous() {
        return tsnyousibous;
    }

    public void setTsnyousibous(BizCurrency pTsnyousibous) {
        tsnyousibous = pTsnyousibous;
        tsnyousibousValue = null;
        tsnyousibousType  = null;
    }

    transient private BigDecimal tsnyousibousValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNYOUSIBOUS, nullable=true)
    protected BigDecimal getTsnyousibousValue() {
        if (tsnyousibousValue == null && tsnyousibous != null) {
            if (tsnyousibous.isOptional()) return null;
            return tsnyousibous.absolute();
        }
        return tsnyousibousValue;
    }

    protected void setTsnyousibousValue(BigDecimal value) {
        tsnyousibousValue = value;
        tsnyousibous = Optional.fromNullable(toCurrencyType(tsnyousibousType))
            .transform(bizCurrencyTransformer(getTsnyousibousValue()))
            .orNull();
    }

    transient private String tsnyousibousType = null;

    @Column(name=TSNYOUSIBOUS + "$", nullable=true)
    protected String getTsnyousibousType() {
        if (tsnyousibousType == null && tsnyousibous != null) return tsnyousibous.getType().toString();
        if (tsnyousibousType == null && getTsnyousibousValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnyousibous$' should not be NULL."));
        }
        return tsnyousibousType;
    }

    protected void setTsnyousibousType(String type) {
        tsnyousibousType = type;
        tsnyousibous = Optional.fromNullable(toCurrencyType(tsnyousibousType))
            .transform(bizCurrencyTransformer(getTsnyousibousValue()))
            .orNull();
    }

    private BizCurrency tsnyouitijip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnyouitijip() {
        return tsnyouitijip;
    }

    public void setTsnyouitijip(BizCurrency pTsnyouitijip) {
        tsnyouitijip = pTsnyouitijip;
        tsnyouitijipValue = null;
        tsnyouitijipType  = null;
    }

    transient private BigDecimal tsnyouitijipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNYOUITIJIP, nullable=true)
    protected BigDecimal getTsnyouitijipValue() {
        if (tsnyouitijipValue == null && tsnyouitijip != null) {
            if (tsnyouitijip.isOptional()) return null;
            return tsnyouitijip.absolute();
        }
        return tsnyouitijipValue;
    }

    protected void setTsnyouitijipValue(BigDecimal value) {
        tsnyouitijipValue = value;
        tsnyouitijip = Optional.fromNullable(toCurrencyType(tsnyouitijipType))
            .transform(bizCurrencyTransformer(getTsnyouitijipValue()))
            .orNull();
    }

    transient private String tsnyouitijipType = null;

    @Column(name=TSNYOUITIJIP + "$", nullable=true)
    protected String getTsnyouitijipType() {
        if (tsnyouitijipType == null && tsnyouitijip != null) return tsnyouitijip.getType().toString();
        if (tsnyouitijipType == null && getTsnyouitijipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnyouitijip$' should not be NULL."));
        }
        return tsnyouitijipType;
    }

    protected void setTsnyouitijipType(String type) {
        tsnyouitijipType = type;
        tsnyouitijip = Optional.fromNullable(toCurrencyType(tsnyouitijipType))
            .transform(bizCurrencyTransformer(getTsnyouitijipValue()))
            .orNull();
    }

    private BizCurrency tsnyounkgns;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnyounkgns() {
        return tsnyounkgns;
    }

    public void setTsnyounkgns(BizCurrency pTsnyounkgns) {
        tsnyounkgns = pTsnyounkgns;
        tsnyounkgnsValue = null;
        tsnyounkgnsType  = null;
    }

    transient private BigDecimal tsnyounkgnsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNYOUNKGNS, nullable=true)
    protected BigDecimal getTsnyounkgnsValue() {
        if (tsnyounkgnsValue == null && tsnyounkgns != null) {
            if (tsnyounkgns.isOptional()) return null;
            return tsnyounkgns.absolute();
        }
        return tsnyounkgnsValue;
    }

    protected void setTsnyounkgnsValue(BigDecimal value) {
        tsnyounkgnsValue = value;
        tsnyounkgns = Optional.fromNullable(toCurrencyType(tsnyounkgnsType))
            .transform(bizCurrencyTransformer(getTsnyounkgnsValue()))
            .orNull();
    }

    transient private String tsnyounkgnsType = null;

    @Column(name=TSNYOUNKGNS + "$", nullable=true)
    protected String getTsnyounkgnsType() {
        if (tsnyounkgnsType == null && tsnyounkgns != null) return tsnyounkgns.getType().toString();
        if (tsnyounkgnsType == null && getTsnyounkgnsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnyounkgns$' should not be NULL."));
        }
        return tsnyounkgnsType;
    }

    protected void setTsnyounkgnsType(String type) {
        tsnyounkgnsType = type;
        tsnyounkgns = Optional.fromNullable(toCurrencyType(tsnyounkgnsType))
            .transform(bizCurrencyTransformer(getTsnyounkgnsValue()))
            .orNull();
    }

    private Integer hrkkkn;

    @Column(name=GenBT_TjtIdouNySk.HRKKKN)
    @Range(min="0", max="99")
    public Integer getHrkkkn() {
        return hrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkkn(Integer pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    private C_SntkhouKbn sntkhoukbn;

    @Type(type="UserType_C_SntkhouKbn")
    @Column(name=GenBT_TjtIdouNySk.SNTKHOUKBN)
    public C_SntkhouKbn getSntkhoukbn() {
        return sntkhoukbn;
    }

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn) {
        sntkhoukbn = pSntkhoukbn;
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenBT_TjtIdouNySk.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private Integer kykhhkndouhyouji;

    @Column(name=GenBT_TjtIdouNySk.KYKHHKNDOUHYOUJI)
    public Integer getKykhhkndouhyouji() {
        return kykhhkndouhyouji;
    }

    public void setKykhhkndouhyouji(Integer pKykhhkndouhyouji) {
        kykhhkndouhyouji = pKykhhkndouhyouji;
    }

    private C_MossyoumetuKbn mossyoumetukbn;

    @Type(type="UserType_C_MossyoumetuKbn")
    @Column(name=GenBT_TjtIdouNySk.MOSSYOUMETUKBN)
    public C_MossyoumetuKbn getMossyoumetukbn() {
        return mossyoumetukbn;
    }

    public void setMossyoumetukbn(C_MossyoumetuKbn pMossyoumetukbn) {
        mossyoumetukbn = pMossyoumetukbn;
    }

    private Integer syouhnsdno;

    @Column(name=GenBT_TjtIdouNySk.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private C_UmuKbn kaigomaehrtkykumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_TjtIdouNySk.KAIGOMAEHRTKYKUMUKBN)
    public C_UmuKbn getKaigomaehrtkykumukbn() {
        return kaigomaehrtkykumukbn;
    }

    public void setKaigomaehrtkykumukbn(C_UmuKbn pKaigomaehrtkykumukbn) {
        kaigomaehrtkykumukbn = pKaigomaehrtkykumukbn;
    }

    private C_UmuKbn pyennykntkykumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_TjtIdouNySk.PYENNYKNTKYKUMUKBN)
    public C_UmuKbn getPyennykntkykumukbn() {
        return pyennykntkykumukbn;
    }

    public void setPyennykntkykumukbn(C_UmuKbn pPyennykntkykumukbn) {
        pyennykntkykumukbn = pPyennykntkykumukbn;
    }

    private BizCurrency tsnyennyknkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnyennyknkgk() {
        return tsnyennyknkgk;
    }

    public void setTsnyennyknkgk(BizCurrency pTsnyennyknkgk) {
        tsnyennyknkgk = pTsnyennyknkgk;
        tsnyennyknkgkValue = null;
        tsnyennyknkgkType  = null;
    }

    transient private BigDecimal tsnyennyknkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNYENNYKNKGK, nullable=true)
    protected BigDecimal getTsnyennyknkgkValue() {
        if (tsnyennyknkgkValue == null && tsnyennyknkgk != null) {
            if (tsnyennyknkgk.isOptional()) return null;
            return tsnyennyknkgk.absolute();
        }
        return tsnyennyknkgkValue;
    }

    protected void setTsnyennyknkgkValue(BigDecimal value) {
        tsnyennyknkgkValue = value;
        tsnyennyknkgk = Optional.fromNullable(toCurrencyType(tsnyennyknkgkType))
            .transform(bizCurrencyTransformer(getTsnyennyknkgkValue()))
            .orNull();
    }

    transient private String tsnyennyknkgkType = null;

    @Column(name=TSNYENNYKNKGK + "$", nullable=true)
    protected String getTsnyennyknkgkType() {
        if (tsnyennyknkgkType == null && tsnyennyknkgk != null) return tsnyennyknkgk.getType().toString();
        if (tsnyennyknkgkType == null && getTsnyennyknkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnyennyknkgk$' should not be NULL."));
        }
        return tsnyennyknkgkType;
    }

    protected void setTsnyennyknkgkType(String type) {
        tsnyennyknkgkType = type;
        tsnyennyknkgk = Optional.fromNullable(toCurrencyType(tsnyennyknkgkType))
            .transform(bizCurrencyTransformer(getTsnyennyknkgkValue()))
            .orNull();
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenBT_TjtIdouNySk.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_TjtIdouNySk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_TjtIdouNySk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_TjtIdouNySk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}