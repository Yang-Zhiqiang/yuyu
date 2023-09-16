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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.IT_BAK_KhTumitateDKanri;
import yuyu.def.db.id.PKIT_BAK_KhTumitateDKanri;
import yuyu.def.db.meta.GenQIT_BAK_KhTumitateDKanri;
import yuyu.def.db.meta.QIT_BAK_KhTumitateDKanri;
import yuyu.def.db.type.UserType_C_NaiteiKakuteiKbn;
import yuyu.def.db.type.UserType_C_TumitateDSakuseiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 積立Ｄ管理バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KhTumitateDKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhTumitateDKanri}</td><td colspan="3">積立Ｄ管理バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KhTumitateDKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KhTumitateDKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KhTumitateDKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTumitatedtumitateymd tumitatedtumitateymd}</td><td>積立Ｄ積立年月日</td><td align="center">{@link PKIT_BAK_KhTumitateDKanri ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_BAK_KhTumitateDKanri ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTumitatedskskbn tumitatedskskbn}</td><td>積立Ｄ作成区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TumitateDSakuseiKbn}</td></tr>
 *  <tr><td>{@link #getTumitated tumitated}</td><td>積立Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTumitatedshrkrkymd tumitatedshrkrkymd}</td><td>積立Ｄ支払効力日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNaiteikakuteikbn naiteikakuteikbn}</td><td>内定確定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KhTumitateDKanri
 * @see     PKIT_BAK_KhTumitateDKanri
 * @see     QIT_BAK_KhTumitateDKanri
 * @see     GenQIT_BAK_KhTumitateDKanri
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KhTumitateDKanri.TABLE_NAME)
@IdClass(value=PKIT_BAK_KhTumitateDKanri.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_NaiteiKakuteiKbn", typeClass=UserType_C_NaiteiKakuteiKbn.class),
    @TypeDef(name="UserType_C_TumitateDSakuseiKbn", typeClass=UserType_C_TumitateDSakuseiKbn.class)
})
public abstract class GenIT_BAK_KhTumitateDKanri extends AbstractExDBEntity<IT_BAK_KhTumitateDKanri, PKIT_BAK_KhTumitateDKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KhTumitateDKanri";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String TUMITATEDTUMITATEYMD     = "tumitatedtumitateymd";
    public static final String RENNO                    = "renno";
    public static final String TUMITATEDSKSKBN          = "tumitatedskskbn";
    public static final String TUMITATED                = "tumitated";
    public static final String TUMITATEDSHRKRKYMD       = "tumitatedshrkrkymd";
    public static final String NAITEIKAKUTEIKBN         = "naiteikakuteikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_KhTumitateDKanri primaryKey;

    public GenIT_BAK_KhTumitateDKanri() {
        primaryKey = new PKIT_BAK_KhTumitateDKanri();
    }

    public GenIT_BAK_KhTumitateDKanri(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        BizDate pTumitatedtumitateymd,
        Integer pRenno
    ) {
        primaryKey = new PKIT_BAK_KhTumitateDKanri(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pTumitatedtumitateymd,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KhTumitateDKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KhTumitateDKanri> getMetaClass() {
        return QIT_BAK_KhTumitateDKanri.class;
    }

    @Id
    @Column(name=GenIT_BAK_KhTumitateDKanri.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KhTumitateDKanri.SYONO)
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
    @Column(name=GenIT_BAK_KhTumitateDKanri.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhTumitateDKanri.TUMITATEDTUMITATEYMD)
    public BizDate getTumitatedtumitateymd() {
        return getPrimaryKey().getTumitatedtumitateymd();
    }

    public void setTumitatedtumitateymd(BizDate pTumitatedtumitateymd) {
        getPrimaryKey().setTumitatedtumitateymd(pTumitatedtumitateymd);
    }

    @Id
    @Column(name=GenIT_BAK_KhTumitateDKanri.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_TumitateDSakuseiKbn tumitatedskskbn;

    @Type(type="UserType_C_TumitateDSakuseiKbn")
    @Column(name=GenIT_BAK_KhTumitateDKanri.TUMITATEDSKSKBN)
    public C_TumitateDSakuseiKbn getTumitatedskskbn() {
        return tumitatedskskbn;
    }

    public void setTumitatedskskbn(C_TumitateDSakuseiKbn pTumitatedskskbn) {
        tumitatedskskbn = pTumitatedskskbn;
    }

    private BizCurrency tumitated;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTumitated() {
        return tumitated;
    }

    public void setTumitated(BizCurrency pTumitated) {
        tumitated = pTumitated;
        tumitatedValue = null;
        tumitatedType  = null;
    }

    transient private BigDecimal tumitatedValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUMITATED, nullable=true)
    protected BigDecimal getTumitatedValue() {
        if (tumitatedValue == null && tumitated != null) {
            if (tumitated.isOptional()) return null;
            return tumitated.absolute();
        }
        return tumitatedValue;
    }

    protected void setTumitatedValue(BigDecimal value) {
        tumitatedValue = value;
        tumitated = Optional.fromNullable(toCurrencyType(tumitatedType))
            .transform(bizCurrencyTransformer(getTumitatedValue()))
            .orNull();
    }

    transient private String tumitatedType = null;

    @Column(name=TUMITATED + "$", nullable=true)
    protected String getTumitatedType() {
        if (tumitatedType == null && tumitated != null) return tumitated.getType().toString();
        if (tumitatedType == null && getTumitatedValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tumitated$' should not be NULL."));
        }
        return tumitatedType;
    }

    protected void setTumitatedType(String type) {
        tumitatedType = type;
        tumitated = Optional.fromNullable(toCurrencyType(tumitatedType))
            .transform(bizCurrencyTransformer(getTumitatedValue()))
            .orNull();
    }

    private BizDate tumitatedshrkrkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhTumitateDKanri.TUMITATEDSHRKRKYMD)
    public BizDate getTumitatedshrkrkymd() {
        return tumitatedshrkrkymd;
    }

    public void setTumitatedshrkrkymd(BizDate pTumitatedshrkrkymd) {
        tumitatedshrkrkymd = pTumitatedshrkrkymd;
    }

    private C_NaiteiKakuteiKbn naiteikakuteikbn;

    @Type(type="UserType_C_NaiteiKakuteiKbn")
    @Column(name=GenIT_BAK_KhTumitateDKanri.NAITEIKAKUTEIKBN)
    public C_NaiteiKakuteiKbn getNaiteikakuteikbn() {
        return naiteikakuteikbn;
    }

    public void setNaiteikakuteikbn(C_NaiteiKakuteiKbn pNaiteikakuteikbn) {
        naiteikakuteikbn = pNaiteikakuteikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KhTumitateDKanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KhTumitateDKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KhTumitateDKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}