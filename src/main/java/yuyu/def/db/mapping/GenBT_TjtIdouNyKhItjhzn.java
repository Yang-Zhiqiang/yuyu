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
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BT_TjtIdouNyKhItjhzn;
import yuyu.def.db.id.PKBT_TjtIdouNyKhItjhzn;
import yuyu.def.db.meta.GenQBT_TjtIdouNyKhItjhzn;
import yuyu.def.db.meta.QBT_TjtIdouNyKhItjhzn;
import yuyu.def.db.type.UserType_C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_TrhkjiKakKbn;
import yuyu.def.db.type.UserType_C_TtdktyuuiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 当日異動内容契約保全一時保存テーブル テーブルのマッピング情報クラスで、 {@link BT_TjtIdouNyKhItjhzn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_TjtIdouNyKhItjhzn}</td><td colspan="3">当日異動内容契約保全一時保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKBT_TjtIdouNyKhItjhzn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKBT_TjtIdouNyKhItjhzn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRecordsakujyohyouji recordsakujyohyouji}</td><td>レコード削除表示</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYoukyuuno youkyuuno}</td><td>要求通番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykjyoutai kykjyoutai}</td><td>契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykjyoutai}</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYuukousyoumetukbn yuukousyoumetukbn}</td><td>有効消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukousyoumetuKbn}</td></tr>
 *  <tr><td>{@link #getSyoumetujiyuu syoumetujiyuu}</td><td>消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syoumetujiyuu}</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTsntuukasyu tsntuukasyu}</td><td>通算用通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTsnyousibous tsnyousibous}</td><td>通算用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnyouitijip tsnyouitijip}</td><td>通算用一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnyounkgns tsnyounkgns}</td><td>通算用年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkkkn hrkkkn}</td><td>払込期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSntkhoukbn sntkhoukbn}</td><td>選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkhouKbn}</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKykhhkndouhyouji kykhhkndouhyouji}</td><td>契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn1 ttdktyuuikbn1}</td><td>手続注意区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn2 ttdktyuuikbn2}</td><td>手続注意区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn3 ttdktyuuikbn3}</td><td>手続注意区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn4 ttdktyuuikbn4}</td><td>手続注意区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn5 ttdktyuuikbn5}</td><td>手続注意区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrtkykumukbn kaigomaehrtkykumukbn}</td><td>介護前払特約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getPyennykntkykumukbn pyennykntkykumukbn}</td><td>保険料円入金特約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTsnyennyknkgk tsnyennyknkgk}</td><td>通算用円入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSkjmosno skjmosno}</td><td>新契約時申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHouteityotkseisyouhnhyj houteityotkseisyouhnhyj}</td><td>法定貯蓄性商品表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HouteiTyotkseiSyouhnHyjKbn}</td></tr>
 *  <tr><td>{@link #getSeiritujitrhkjikakkbn seiritujitrhkjikakkbn}</td><td>成立時取引時確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TrhkjiKakKbn}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_TjtIdouNyKhItjhzn
 * @see     PKBT_TjtIdouNyKhItjhzn
 * @see     QBT_TjtIdouNyKhItjhzn
 * @see     GenQBT_TjtIdouNyKhItjhzn
 */
@MappedSuperclass
@Table(name=GenBT_TjtIdouNyKhItjhzn.TABLE_NAME)
@IdClass(value=PKBT_TjtIdouNyKhItjhzn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_HouteiTyotkseiSyouhnHyjKbn", typeClass=UserType_C_HouteiTyotkseiSyouhnHyjKbn.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_Kykjyoutai", typeClass=UserType_C_Kykjyoutai.class),
    @TypeDef(name="UserType_C_SntkhouKbn", typeClass=UserType_C_SntkhouKbn.class),
    @TypeDef(name="UserType_C_Syoumetujiyuu", typeClass=UserType_C_Syoumetujiyuu.class),
    @TypeDef(name="UserType_C_TrhkjiKakKbn", typeClass=UserType_C_TrhkjiKakKbn.class),
    @TypeDef(name="UserType_C_TtdktyuuiKbn", typeClass=UserType_C_TtdktyuuiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YuukousyoumetuKbn", typeClass=UserType_C_YuukousyoumetuKbn.class)
})
public abstract class GenBT_TjtIdouNyKhItjhzn extends AbstractExDBEntity<BT_TjtIdouNyKhItjhzn, PKBT_TjtIdouNyKhItjhzn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_TjtIdouNyKhItjhzn";
    public static final String SYONO                    = "syono";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String RECORDSAKUJYOHYOUJI      = "recordsakujyohyouji";
    public static final String YOUKYUUNO                = "youkyuuno";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String KYKJYOUTAI               = "kykjyoutai";
    public static final String KYKYMD                   = "kykymd";
    public static final String YUUKOUSYOUMETUKBN        = "yuukousyoumetukbn";
    public static final String SYOUMETUJIYUU            = "syoumetujiyuu";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String TSNTUUKASYU              = "tsntuukasyu";
    public static final String TSNYOUSIBOUS             = "tsnyousibous";
    public static final String TSNYOUITIJIP             = "tsnyouitijip";
    public static final String TSNYOUNKGNS              = "tsnyounkgns";
    public static final String HRKKKN                   = "hrkkkn";
    public static final String SNTKHOUKBN               = "sntkhoukbn";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String KYKHHKNDOUHYOUJI         = "kykhhkndouhyouji";
    public static final String TTDKTYUUIKBN1            = "ttdktyuuikbn1";
    public static final String TTDKTYUUIKBN2            = "ttdktyuuikbn2";
    public static final String TTDKTYUUIKBN3            = "ttdktyuuikbn3";
    public static final String TTDKTYUUIKBN4            = "ttdktyuuikbn4";
    public static final String TTDKTYUUIKBN5            = "ttdktyuuikbn5";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KAIGOMAEHRTKYKUMUKBN     = "kaigomaehrtkykumukbn";
    public static final String PYENNYKNTKYKUMUKBN       = "pyennykntkykumukbn";
    public static final String TSNYENNYKNKGK            = "tsnyennyknkgk";
    public static final String SKJMOSNO                 = "skjmosno";
    public static final String HOUTEITYOTKSEISYOUHNHYJ  = "houteityotkseisyouhnhyj";
    public static final String SEIRITUJITRHKJIKAKKBN    = "seiritujitrhkjikakkbn";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_TjtIdouNyKhItjhzn primaryKey;

    public GenBT_TjtIdouNyKhItjhzn() {
        primaryKey = new PKBT_TjtIdouNyKhItjhzn();
    }

    public GenBT_TjtIdouNyKhItjhzn(String pSyono, Integer pRenno3keta) {
        primaryKey = new PKBT_TjtIdouNyKhItjhzn(pSyono, pRenno3keta);
    }

    @Transient
    @Override
    public PKBT_TjtIdouNyKhItjhzn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_TjtIdouNyKhItjhzn> getMetaClass() {
        return QBT_TjtIdouNyKhItjhzn.class;
    }

    @Id
    @Column(name=GenBT_TjtIdouNyKhItjhzn.SYONO)
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
    @Column(name=GenBT_TjtIdouNyKhItjhzn.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private Integer recordsakujyohyouji;

    @Column(name=GenBT_TjtIdouNyKhItjhzn.RECORDSAKUJYOHYOUJI)
    public Integer getRecordsakujyohyouji() {
        return recordsakujyohyouji;
    }

    public void setRecordsakujyohyouji(Integer pRecordsakujyohyouji) {
        recordsakujyohyouji = pRecordsakujyohyouji;
    }

    private String youkyuuno;

    @Column(name=GenBT_TjtIdouNyKhItjhzn.YOUKYUUNO)
    public String getYoukyuuno() {
        return youkyuuno;
    }

    public void setYoukyuuno(String pYoukyuuno) {
        youkyuuno = pYoukyuuno;
    }

    private String syouhncd;

    @Column(name=GenBT_TjtIdouNyKhItjhzn.SYOUHNCD)
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

    private C_Kykjyoutai kykjyoutai;

    @Type(type="UserType_C_Kykjyoutai")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.KYKJYOUTAI)
    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        kykjyoutai = pKykjyoutai;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Type(type="UserType_C_YuukousyoumetuKbn")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.YUUKOUSYOUMETUKBN)
    public C_YuukousyoumetuKbn getYuukousyoumetukbn() {
        return yuukousyoumetukbn;
    }

    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn) {
        yuukousyoumetukbn = pYuukousyoumetukbn;
    }

    private C_Syoumetujiyuu syoumetujiyuu;

    @Type(type="UserType_C_Syoumetujiyuu")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.SYOUMETUJIYUU)
    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu tsntuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.TSNTUUKASYU)
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

    @Column(name=GenBT_TjtIdouNyKhItjhzn.HRKKKN)
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
    @Column(name=GenBT_TjtIdouNyKhItjhzn.SNTKHOUKBN)
    public C_SntkhouKbn getSntkhoukbn() {
        return sntkhoukbn;
    }

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn) {
        sntkhoukbn = pSntkhoukbn;
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.BOSYUUYM)
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

    @Column(name=GenBT_TjtIdouNyKhItjhzn.KYKHHKNDOUHYOUJI)
    public Integer getKykhhkndouhyouji() {
        return kykhhkndouhyouji;
    }

    public void setKykhhkndouhyouji(Integer pKykhhkndouhyouji) {
        kykhhkndouhyouji = pKykhhkndouhyouji;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn1;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.TTDKTYUUIKBN1)
    public C_TtdktyuuiKbn getTtdktyuuikbn1() {
        return ttdktyuuikbn1;
    }

    public void setTtdktyuuikbn1(C_TtdktyuuiKbn pTtdktyuuikbn1) {
        ttdktyuuikbn1 = pTtdktyuuikbn1;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn2;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.TTDKTYUUIKBN2)
    public C_TtdktyuuiKbn getTtdktyuuikbn2() {
        return ttdktyuuikbn2;
    }

    public void setTtdktyuuikbn2(C_TtdktyuuiKbn pTtdktyuuikbn2) {
        ttdktyuuikbn2 = pTtdktyuuikbn2;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn3;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.TTDKTYUUIKBN3)
    public C_TtdktyuuiKbn getTtdktyuuikbn3() {
        return ttdktyuuikbn3;
    }

    public void setTtdktyuuikbn3(C_TtdktyuuiKbn pTtdktyuuikbn3) {
        ttdktyuuikbn3 = pTtdktyuuikbn3;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn4;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.TTDKTYUUIKBN4)
    public C_TtdktyuuiKbn getTtdktyuuikbn4() {
        return ttdktyuuikbn4;
    }

    public void setTtdktyuuikbn4(C_TtdktyuuiKbn pTtdktyuuikbn4) {
        ttdktyuuikbn4 = pTtdktyuuikbn4;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn5;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.TTDKTYUUIKBN5)
    public C_TtdktyuuiKbn getTtdktyuuikbn5() {
        return ttdktyuuikbn5;
    }

    public void setTtdktyuuikbn5(C_TtdktyuuiKbn pTtdktyuuikbn5) {
        ttdktyuuikbn5 = pTtdktyuuikbn5;
    }

    private Integer syouhnsdno;

    @Column(name=GenBT_TjtIdouNyKhItjhzn.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private C_UmuKbn kaigomaehrtkykumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.KAIGOMAEHRTKYKUMUKBN)
    public C_UmuKbn getKaigomaehrtkykumukbn() {
        return kaigomaehrtkykumukbn;
    }

    public void setKaigomaehrtkykumukbn(C_UmuKbn pKaigomaehrtkykumukbn) {
        kaigomaehrtkykumukbn = pKaigomaehrtkykumukbn;
    }

    private C_UmuKbn pyennykntkykumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.PYENNYKNTKYKUMUKBN)
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

    private String skjmosno;

    @Column(name=GenBT_TjtIdouNyKhItjhzn.SKJMOSNO)
    public String getSkjmosno() {
        return skjmosno;
    }

    public void setSkjmosno(String pSkjmosno) {
        skjmosno = pSkjmosno;
    }

    private C_HouteiTyotkseiSyouhnHyjKbn houteityotkseisyouhnhyj;

    @Type(type="UserType_C_HouteiTyotkseiSyouhnHyjKbn")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.HOUTEITYOTKSEISYOUHNHYJ)
    public C_HouteiTyotkseiSyouhnHyjKbn getHouteityotkseisyouhnhyj() {
        return houteityotkseisyouhnhyj;
    }

    public void setHouteityotkseisyouhnhyj(C_HouteiTyotkseiSyouhnHyjKbn pHouteityotkseisyouhnhyj) {
        houteityotkseisyouhnhyj = pHouteityotkseisyouhnhyj;
    }

    private C_TrhkjiKakKbn seiritujitrhkjikakkbn;

    @Type(type="UserType_C_TrhkjiKakKbn")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.SEIRITUJITRHKJIKAKKBN)
    public C_TrhkjiKakKbn getSeiritujitrhkjikakkbn() {
        return seiritujitrhkjikakkbn;
    }

    public void setSeiritujitrhkjikakkbn(C_TrhkjiKakKbn pSeiritujitrhkjikakkbn) {
        seiritujitrhkjikakkbn = pSeiritujitrhkjikakkbn;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenBT_TjtIdouNyKhItjhzn.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_TjtIdouNyKhItjhzn.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_TjtIdouNyKhItjhzn.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_TjtIdouNyKhItjhzn.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}