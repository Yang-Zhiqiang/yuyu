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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_ZennouSyoriKbn;
import yuyu.def.db.entity.IT_ZennouTtdkKanryouTuuti;
import yuyu.def.db.id.PKIT_ZennouTtdkKanryouTuuti;
import yuyu.def.db.meta.GenQIT_ZennouTtdkKanryouTuuti;
import yuyu.def.db.meta.QIT_ZennouTtdkKanryouTuuti;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_ZennouSyoriKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 前納手続完了通知書テーブル テーブルのマッピング情報クラスで、 {@link IT_ZennouTtdkKanryouTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_ZennouTtdkKanryouTuuti}</td><td colspan="3">前納手続完了通知書テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_ZennouTtdkKanryouTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_ZennouTtdkKanryouTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_ZennouTtdkKanryouTuuti ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennoustartym zennoustartym}</td><td>前納開始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getZennousyorikbn zennousyorikbn}</td><td>前納処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZennouSyoriKbn}</td></tr>
 *  <tr><td>{@link #getZennounyuukinsyoriymd zennounyuukinsyoriymd}</td><td>前納入金処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennounyuukindenymd zennounyuukindenymd}</td><td>前納入金伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennoukikan zennoukikan}</td><td>前納期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennounyuukinkgk zennounyuukinkgk}</td><td>前納入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getAnnaisaikaiym annaisaikaiym}</td><td>案内再開年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_ZennouTtdkKanryouTuuti
 * @see     PKIT_ZennouTtdkKanryouTuuti
 * @see     QIT_ZennouTtdkKanryouTuuti
 * @see     GenQIT_ZennouTtdkKanryouTuuti
 */
@MappedSuperclass
@Table(name=GenIT_ZennouTtdkKanryouTuuti.TABLE_NAME)
@IdClass(value=PKIT_ZennouTtdkKanryouTuuti.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_ZennouSyoriKbn", typeClass=UserType_C_ZennouSyoriKbn.class)
})
public abstract class GenIT_ZennouTtdkKanryouTuuti extends AbstractExDBEntity<IT_ZennouTtdkKanryouTuuti, PKIT_ZennouTtdkKanryouTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_ZennouTtdkKanryouTuuti";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String ZENNOUSTARTYM            = "zennoustartym";
    public static final String ZENNOUSYORIKBN           = "zennousyorikbn";
    public static final String ZENNOUNYUUKINSYORIYMD    = "zennounyuukinsyoriymd";
    public static final String ZENNOUNYUUKINDENYMD      = "zennounyuukindenymd";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String ZENNOUKIKAN              = "zennoukikan";
    public static final String ZENNOUNYUUKINKGK         = "zennounyuukinkgk";
    public static final String ANNAISAIKAIYM            = "annaisaikaiym";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_ZennouTtdkKanryouTuuti primaryKey;

    public GenIT_ZennouTtdkKanryouTuuti() {
        primaryKey = new PKIT_ZennouTtdkKanryouTuuti();
    }

    public GenIT_ZennouTtdkKanryouTuuti(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        primaryKey = new PKIT_ZennouTtdkKanryouTuuti(
            pKbnkey,
            pSyono,
            pTyouhyouymd
        );
    }

    @Transient
    @Override
    public PKIT_ZennouTtdkKanryouTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_ZennouTtdkKanryouTuuti> getMetaClass() {
        return QIT_ZennouTtdkKanryouTuuti.class;
    }

    @Id
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.SYONO)
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
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    private BizDateYM zennoustartym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.ZENNOUSTARTYM)
    public BizDateYM getZennoustartym() {
        return zennoustartym;
    }

    public void setZennoustartym(BizDateYM pZennoustartym) {
        zennoustartym = pZennoustartym;
    }

    private C_ZennouSyoriKbn zennousyorikbn;

    @Type(type="UserType_C_ZennouSyoriKbn")
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.ZENNOUSYORIKBN)
    public C_ZennouSyoriKbn getZennousyorikbn() {
        return zennousyorikbn;
    }

    public void setZennousyorikbn(C_ZennouSyoriKbn pZennousyorikbn) {
        zennousyorikbn = pZennousyorikbn;
    }

    private BizDate zennounyuukinsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.ZENNOUNYUUKINSYORIYMD)
    public BizDate getZennounyuukinsyoriymd() {
        return zennounyuukinsyoriymd;
    }

    public void setZennounyuukinsyoriymd(BizDate pZennounyuukinsyoriymd) {
        zennounyuukinsyoriymd = pZennounyuukinsyoriymd;
    }

    private BizDate zennounyuukindenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.ZENNOUNYUUKINDENYMD)
    public BizDate getZennounyuukindenymd() {
        return zennounyuukindenymd;
    }

    public void setZennounyuukindenymd(BizDate pZennounyuukindenymd) {
        zennounyuukindenymd = pZennounyuukindenymd;
    }

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private String zennoukikan;

    @Column(name=GenIT_ZennouTtdkKanryouTuuti.ZENNOUKIKAN)
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

    private BizDateYM annaisaikaiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.ANNAISAIKAIYM)
    public BizDateYM getAnnaisaikaiym() {
        return annaisaikaiym;
    }

    public void setAnnaisaikaiym(BizDateYM pAnnaisaikaiym) {
        annaisaikaiym = pAnnaisaikaiym;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private String kyknmkj;

    @Column(name=GenIT_ZennouTtdkKanryouTuuti.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private String tsinyno;

    @Column(name=GenIT_ZennouTtdkKanryouTuuti.TSINYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    private String tsinadr1kj;

    @Column(name=GenIT_ZennouTtdkKanryouTuuti.TSINADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    private String tsinadr2kj;

    @Column(name=GenIT_ZennouTtdkKanryouTuuti.TSINADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    private String tsinadr3kj;

    @Column(name=GenIT_ZennouTtdkKanryouTuuti.TSINADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    private String hhknnmkj;

    @Column(name=GenIT_ZennouTtdkKanryouTuuti.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ZennouTtdkKanryouTuuti.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_ZennouTtdkKanryouTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_ZennouTtdkKanryouTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_ZennouTtdkKanryouTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}