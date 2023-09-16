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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_TuutiKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_HurikomiIraiTuuti;
import yuyu.def.db.id.PKIT_HurikomiIraiTuuti;
import yuyu.def.db.meta.GenQIT_HurikomiIraiTuuti;
import yuyu.def.db.meta.QIT_HurikomiIraiTuuti;
import yuyu.def.db.type.UserType_C_TuutiKbn;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 振込依頼通知テーブル テーブルのマッピング情報クラスで、 {@link IT_HurikomiIraiTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HurikomiIraiTuuti}</td><td colspan="3">振込依頼通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_HurikomiIraiTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_HurikomiIraiTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_HurikomiIraiTuuti ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr4kj tsinadr4kj}</td><td>通信先住所４（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYykknmnryymd yykknmnryymd}</td><td>猶予期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRyosyugk ryosyugk}</td><td>領収金額（１０桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkkigenymd hrkkigenymd}</td><td>払込期限日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNipyykknmnryymd nipyykknmnryymd}</td><td>第２回保険料猶予期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBanknmkj banknmkj}</td><td>銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitennmkj sitennmkj}</td><td>支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInjiptnkbn injiptnkbn}</td><td>印字パターン区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTuutikbn tuutikbn}</td><td>通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TuutiKbn}</td></tr>
 *  <tr><td>{@link #getHurikomisyono hurikomisyono}</td><td>振込用証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtennmkj drtennmkj}</td><td>代理店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRtratkicd rtratkicd}</td><td>（帳票用）取扱コード</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRtyouhyoucd rtyouhyoucd}</td><td>（帳票用）帳票コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyhyrenrakusikibetukbn tyhyrenrakusikibetukbn}</td><td>帳票連絡先識別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TyhyrenrakusikibetuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HurikomiIraiTuuti
 * @see     PKIT_HurikomiIraiTuuti
 * @see     QIT_HurikomiIraiTuuti
 * @see     GenQIT_HurikomiIraiTuuti
 */
@MappedSuperclass
@Table(name=GenIT_HurikomiIraiTuuti.TABLE_NAME)
@IdClass(value=PKIT_HurikomiIraiTuuti.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_TuutiKbn", typeClass=UserType_C_TuutiKbn.class),
    @TypeDef(name="UserType_C_TyhyrenrakusikibetuKbn", typeClass=UserType_C_TyhyrenrakusikibetuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_HurikomiIraiTuuti extends AbstractExDBEntity<IT_HurikomiIraiTuuti, PKIT_HurikomiIraiTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_HurikomiIraiTuuti";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINADR4KJ               = "tsinadr4kj";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String YYKKNMNRYYMD             = "yykknmnryymd";
    public static final String RYOSYUGK                 = "ryosyugk";
    public static final String HRKKIGENYMD              = "hrkkigenymd";
    public static final String NIPYYKKNMNRYYMD          = "nipyykknmnryymd";
    public static final String BANKNMKJ                 = "banknmkj";
    public static final String SITENNMKJ                = "sitennmkj";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String INJIPTNKBN               = "injiptnkbn";
    public static final String TUUTIKBN                 = "tuutikbn";
    public static final String HURIKOMISYONO            = "hurikomisyono";
    public static final String DRTENCD                  = "drtencd";
    public static final String DRTENNMKJ                = "drtennmkj";
    public static final String RTRATKICD                = "rtratkicd";
    public static final String RTYOUHYOUCD              = "rtyouhyoucd";
    public static final String TYHYRENRAKUSIKIBETUKBN   = "tyhyrenrakusikibetukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_HurikomiIraiTuuti primaryKey;

    public GenIT_HurikomiIraiTuuti() {
        primaryKey = new PKIT_HurikomiIraiTuuti();
    }

    public GenIT_HurikomiIraiTuuti(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        primaryKey = new PKIT_HurikomiIraiTuuti(
            pKbnkey,
            pSyono,
            pTyouhyouymd
        );
    }

    @Transient
    @Override
    public PKIT_HurikomiIraiTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_HurikomiIraiTuuti> getMetaClass() {
        return QIT_HurikomiIraiTuuti.class;
    }

    @Id
    @Column(name=GenIT_HurikomiIraiTuuti.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_HurikomiIraiTuuti.SYONO)
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
    @Column(name=GenIT_HurikomiIraiTuuti.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    private String tsinyno;

    @Column(name=GenIT_HurikomiIraiTuuti.TSINYNO)
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

    @Column(name=GenIT_HurikomiIraiTuuti.TSINADR1KJ)
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

    @Column(name=GenIT_HurikomiIraiTuuti.TSINADR2KJ)
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

    @Column(name=GenIT_HurikomiIraiTuuti.TSINADR3KJ)
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

    private String tsinadr4kj;

    @Column(name=GenIT_HurikomiIraiTuuti.TSINADR4KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr4kj() {
        return tsinadr4kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr4kj(String pTsinadr4kj) {
        tsinadr4kj = pTsinadr4kj;
    }

    private String kyknmkj;

    @Column(name=GenIT_HurikomiIraiTuuti.KYKNMKJ)
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

    private String kyknmkn;

    @Column(name=GenIT_HurikomiIraiTuuti.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String hhknnmkj;

    @Column(name=GenIT_HurikomiIraiTuuti.HHKNNMKJ)
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

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_HurikomiIraiTuuti.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_HurikomiIraiTuuti.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_HurikomiIraiTuuti.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private BizDate yykknmnryymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HurikomiIraiTuuti.YYKKNMNRYYMD)
    public BizDate getYykknmnryymd() {
        return yykknmnryymd;
    }

    @Trim("both")
    public void setYykknmnryymd(BizDate pYykknmnryymd) {
        yykknmnryymd = pYykknmnryymd;
    }

    private BizCurrency ryosyugk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=10)
    @PositiveNumberBizCalcble
    public BizCurrency getRyosyugk() {
        return ryosyugk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyugk(BizCurrency pRyosyugk) {
        ryosyugk = pRyosyugk;
        ryosyugkValue = null;
        ryosyugkType  = null;
    }

    transient private BigDecimal ryosyugkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RYOSYUGK, nullable=true)
    protected BigDecimal getRyosyugkValue() {
        if (ryosyugkValue == null && ryosyugk != null) {
            if (ryosyugk.isOptional()) return null;
            return ryosyugk.absolute();
        }
        return ryosyugkValue;
    }

    protected void setRyosyugkValue(BigDecimal value) {
        ryosyugkValue = value;
        ryosyugk = Optional.fromNullable(toCurrencyType(ryosyugkType))
            .transform(bizCurrencyTransformer(getRyosyugkValue()))
            .orNull();
    }

    transient private String ryosyugkType = null;

    @Column(name=RYOSYUGK + "$", nullable=true)
    protected String getRyosyugkType() {
        if (ryosyugkType == null && ryosyugk != null) return ryosyugk.getType().toString();
        if (ryosyugkType == null && getRyosyugkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'ryosyugk$' should not be NULL."));
        }
        return ryosyugkType;
    }

    protected void setRyosyugkType(String type) {
        ryosyugkType = type;
        ryosyugk = Optional.fromNullable(toCurrencyType(ryosyugkType))
            .transform(bizCurrencyTransformer(getRyosyugkValue()))
            .orNull();
    }

    private BizDate hrkkigenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HurikomiIraiTuuti.HRKKIGENYMD)
    @ValidDate
    public BizDate getHrkkigenymd() {
        return hrkkigenymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkigenymd(BizDate pHrkkigenymd) {
        hrkkigenymd = pHrkkigenymd;
    }

    private BizDate nipyykknmnryymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HurikomiIraiTuuti.NIPYYKKNMNRYYMD)
    public BizDate getNipyykknmnryymd() {
        return nipyykknmnryymd;
    }

    public void setNipyykknmnryymd(BizDate pNipyykknmnryymd) {
        nipyykknmnryymd = pNipyykknmnryymd;
    }

    private String banknmkj;

    @Column(name=GenIT_HurikomiIraiTuuti.BANKNMKJ)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getBanknmkj() {
        return banknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBanknmkj(String pBanknmkj) {
        banknmkj = pBanknmkj;
    }

    private String sitennmkj;

    @Column(name=GenIT_HurikomiIraiTuuti.SITENNMKJ)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getSitennmkj() {
        return sitennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSitennmkj(String pSitennmkj) {
        sitennmkj = pSitennmkj;
    }

    private String bankcd;

    @Column(name=GenIT_HurikomiIraiTuuti.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String sitencd;

    @Column(name=GenIT_HurikomiIraiTuuti.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenIT_HurikomiIraiTuuti.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_HurikomiIraiTuuti.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private Integer injiptnkbn;

    @Column(name=GenIT_HurikomiIraiTuuti.INJIPTNKBN)
    public Integer getInjiptnkbn() {
        return injiptnkbn;
    }

    public void setInjiptnkbn(Integer pInjiptnkbn) {
        injiptnkbn = pInjiptnkbn;
    }

    private C_TuutiKbn tuutikbn;

    @Type(type="UserType_C_TuutiKbn")
    @Column(name=GenIT_HurikomiIraiTuuti.TUUTIKBN)
    public C_TuutiKbn getTuutikbn() {
        return tuutikbn;
    }

    public void setTuutikbn(C_TuutiKbn pTuutikbn) {
        tuutikbn = pTuutikbn;
    }

    private String hurikomisyono;

    @Column(name=GenIT_HurikomiIraiTuuti.HURIKOMISYONO)
    public String getHurikomisyono() {
        return hurikomisyono;
    }

    public void setHurikomisyono(String pHurikomisyono) {
        hurikomisyono = pHurikomisyono;
    }

    private String drtencd;

    @Column(name=GenIT_HurikomiIraiTuuti.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return drtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

    private String drtennmkj;

    @Column(name=GenIT_HurikomiIraiTuuti.DRTENNMKJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getDrtennmkj() {
        return drtennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDrtennmkj(String pDrtennmkj) {
        drtennmkj = pDrtennmkj;
    }

    private Integer rtratkicd;

    @Column(name=GenIT_HurikomiIraiTuuti.RTRATKICD)
    public Integer getRtratkicd() {
        return rtratkicd;
    }

    public void setRtratkicd(Integer pRtratkicd) {
        rtratkicd = pRtratkicd;
    }

    private String rtyouhyoucd;

    @Column(name=GenIT_HurikomiIraiTuuti.RTYOUHYOUCD)
    public String getRtyouhyoucd() {
        return rtyouhyoucd;
    }

    public void setRtyouhyoucd(String pRtyouhyoucd) {
        rtyouhyoucd = pRtyouhyoucd;
    }

    private C_TyhyrenrakusikibetuKbn tyhyrenrakusikibetukbn;

    @Type(type="UserType_C_TyhyrenrakusikibetuKbn")
    @Column(name=GenIT_HurikomiIraiTuuti.TYHYRENRAKUSIKIBETUKBN)
    public C_TyhyrenrakusikibetuKbn getTyhyrenrakusikibetukbn() {
        return tyhyrenrakusikibetukbn;
    }

    public void setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn) {
        tyhyrenrakusikibetukbn = pTyhyrenrakusikibetukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_HurikomiIraiTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_HurikomiIraiTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_HurikomiIraiTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}