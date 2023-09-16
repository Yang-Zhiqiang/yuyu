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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.id.PKBT_TjtIdouNyNk;
import yuyu.def.db.meta.GenQBT_TjtIdouNyNk;
import yuyu.def.db.meta.QBT_TjtIdouNyNk;
import yuyu.def.db.type.UserType_C_NkSyoumetuCd;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;

/**
 * 当日異動内容年金支払テーブル テーブルのマッピング情報クラスで、 {@link BT_TjtIdouNyNk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_TjtIdouNyNk}</td><td colspan="3">当日異動内容年金支払テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getNksysyno nksysyno}</td><td>年金証書番号</td><td align="center">{@link PKBT_TjtIdouNyNk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKBT_TjtIdouNyNk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRecordsakujyohyouji recordsakujyohyouji}</td><td>レコード削除表示</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYoukyuuno youkyuuno}</td><td>要求通番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkshrstartymd nkshrstartymd}</td><td>年金支払開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNksyoumetucd nksyoumetucd}</td><td>年金消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkSyoumetuCd}</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTeinksyu teinksyu}</td><td>定額年金年金種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsnyounkgns tsnyounkgns}</td><td>通算用年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNkukthhkndouhyouji nkukthhkndouhyouji}</td><td>年金受取人被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_TjtIdouNyNk
 * @see     PKBT_TjtIdouNyNk
 * @see     QBT_TjtIdouNyNk
 * @see     GenQBT_TjtIdouNyNk
 */
@MappedSuperclass
@Table(name=GenBT_TjtIdouNyNk.TABLE_NAME)
@IdClass(value=PKBT_TjtIdouNyNk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_NkSyoumetuCd", typeClass=UserType_C_NkSyoumetuCd.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBT_TjtIdouNyNk extends AbstractExDBEntity<BT_TjtIdouNyNk, PKBT_TjtIdouNyNk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_TjtIdouNyNk";
    public static final String NKSYSYNO                 = "nksysyno";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String RECORDSAKUJYOHYOUJI      = "recordsakujyohyouji";
    public static final String YOUKYUUNO                = "youkyuuno";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String NKSHRSTARTYMD            = "nkshrstartymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String NKSYOUMETUCD             = "nksyoumetucd";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String TEINKSYU                 = "teinksyu";
    public static final String TSNYOUNKGNS              = "tsnyounkgns";
    public static final String NKUKTHHKNDOUHYOUJI       = "nkukthhkndouhyouji";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_TjtIdouNyNk primaryKey;

    public GenBT_TjtIdouNyNk() {
        primaryKey = new PKBT_TjtIdouNyNk();
    }

    public GenBT_TjtIdouNyNk(String pNksysyno, Integer pRenno3keta) {
        primaryKey = new PKBT_TjtIdouNyNk(pNksysyno, pRenno3keta);
    }

    @Transient
    @Override
    public PKBT_TjtIdouNyNk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_TjtIdouNyNk> getMetaClass() {
        return QBT_TjtIdouNyNk.class;
    }

    @Id
    @Column(name=GenBT_TjtIdouNyNk.NKSYSYNO)
    @NenkinSyousyoNo
    public String getNksysyno() {
        return getPrimaryKey().getNksysyno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNksysyno(String pNksysyno) {
        getPrimaryKey().setNksysyno(pNksysyno);
    }

    @Id
    @Column(name=GenBT_TjtIdouNyNk.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private Integer recordsakujyohyouji;

    @Column(name=GenBT_TjtIdouNyNk.RECORDSAKUJYOHYOUJI)
    public Integer getRecordsakujyohyouji() {
        return recordsakujyohyouji;
    }

    public void setRecordsakujyohyouji(Integer pRecordsakujyohyouji) {
        recordsakujyohyouji = pRecordsakujyohyouji;
    }

    private String youkyuuno;

    @Column(name=GenBT_TjtIdouNyNk.YOUKYUUNO)
    public String getYoukyuuno() {
        return youkyuuno;
    }

    public void setYoukyuuno(String pYoukyuuno) {
        youkyuuno = pYoukyuuno;
    }

    private String syouhncd;

    @Column(name=GenBT_TjtIdouNyNk.SYOUHNCD)
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

    private BizDate nkshrstartymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_TjtIdouNyNk.NKSHRSTARTYMD)
    public BizDate getNkshrstartymd() {
        return nkshrstartymd;
    }

    @Trim("both")
    public void setNkshrstartymd(BizDate pNkshrstartymd) {
        nkshrstartymd = pNkshrstartymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_TjtIdouNyNk.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_NkSyoumetuCd nksyoumetucd;

    @Type(type="UserType_C_NkSyoumetuCd")
    @Column(name=GenBT_TjtIdouNyNk.NKSYOUMETUCD)
    public C_NkSyoumetuCd getNksyoumetucd() {
        return nksyoumetucd;
    }

    public void setNksyoumetucd(C_NkSyoumetuCd pNksyoumetucd) {
        nksyoumetucd = pNksyoumetucd;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_TjtIdouNyNk.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_TjtIdouNyNk.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private String teinksyu;

    @Column(name=GenBT_TjtIdouNyNk.TEINKSYU)
    public String getTeinksyu() {
        return teinksyu;
    }

    public void setTeinksyu(String pTeinksyu) {
        teinksyu = pTeinksyu;
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

    private Integer nkukthhkndouhyouji;

    @Column(name=GenBT_TjtIdouNyNk.NKUKTHHKNDOUHYOUJI)
    public Integer getNkukthhkndouhyouji() {
        return nkukthhkndouhyouji;
    }

    public void setNkukthhkndouhyouji(Integer pNkukthhkndouhyouji) {
        nkukthhkndouhyouji = pNkukthhkndouhyouji;
    }

    private Integer syouhnsdno;

    @Column(name=GenBT_TjtIdouNyNk.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_TjtIdouNyNk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_TjtIdouNyNk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_TjtIdouNyNk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}