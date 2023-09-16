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
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_SikkouTuuti;
import yuyu.def.db.id.PKIT_SikkouTuuti;
import yuyu.def.db.meta.GenQIT_SikkouTuuti;
import yuyu.def.db.meta.QIT_SikkouTuuti;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 失効通知テーブル テーブルのマッピング情報クラスで、 {@link IT_SikkouTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SikkouTuuti}</td><td colspan="3">失効通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_SikkouTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_SikkouTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_SikkouTuuti ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtentsinyno drtentsinyno}</td><td>代理店通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtennmkj drtennmkj}</td><td>代理店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtennmkj oyadrtennmkj}</td><td>親代理店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai2tsintelno dai2tsintelno}</td><td>第２通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm syouhnnm}</td><td>商品名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSikkouymd sikkouymd}</td><td>失効日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getFukkatukigenymd fukkatukigenymd}</td><td>復活期限日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBanknmkj banknmkj}</td><td>銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitennmkj sitennmkj}</td><td>支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRcreditcardno rcreditcardno}</td><td>（帳票用）クレジットカード番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SikkouTuuti
 * @see     PKIT_SikkouTuuti
 * @see     QIT_SikkouTuuti
 * @see     GenQIT_SikkouTuuti
 */
@MappedSuperclass
@Table(name=GenIT_SikkouTuuti.TABLE_NAME)
@IdClass(value=PKIT_SikkouTuuti.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_SikkouTuuti extends AbstractExDBEntity<IT_SikkouTuuti, PKIT_SikkouTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_SikkouTuuti";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String DRTENCD                  = "drtencd";
    public static final String DRTENTSINYNO             = "drtentsinyno";
    public static final String DRTENNMKJ                = "drtennmkj";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String OYADRTENNMKJ             = "oyadrtennmkj";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String DAI2TSINTELNO            = "dai2tsintelno";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String SYOUHNNM                 = "syouhnnm";
    public static final String KYKYMD                   = "kykymd";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String HRKP                     = "hrkp";
    public static final String SIKKOUYMD                = "sikkouymd";
    public static final String FUKKATUKIGENYMD          = "fukkatukigenymd";
    public static final String BANKCD                   = "bankcd";
    public static final String BANKNMKJ                 = "banknmkj";
    public static final String SITENCD                  = "sitencd";
    public static final String SITENNMKJ                = "sitennmkj";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String RCREDITCARDNO            = "rcreditcardno";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_SikkouTuuti primaryKey;

    public GenIT_SikkouTuuti() {
        primaryKey = new PKIT_SikkouTuuti();
    }

    public GenIT_SikkouTuuti(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        primaryKey = new PKIT_SikkouTuuti(
            pKbnkey,
            pSyono,
            pTyouhyouymd
        );
    }

    @Transient
    @Override
    public PKIT_SikkouTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_SikkouTuuti> getMetaClass() {
        return QIT_SikkouTuuti.class;
    }

    @Id
    @Column(name=GenIT_SikkouTuuti.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_SikkouTuuti.SYONO)
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
    @Column(name=GenIT_SikkouTuuti.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    private String drtencd;

    @Column(name=GenIT_SikkouTuuti.DRTENCD)
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

    private String drtentsinyno;

    @Column(name=GenIT_SikkouTuuti.DRTENTSINYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getDrtentsinyno() {
        return drtentsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtentsinyno(String pDrtentsinyno) {
        drtentsinyno = pDrtentsinyno;
    }

    private String drtennmkj;

    @Column(name=GenIT_SikkouTuuti.DRTENNMKJ)
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

    private String oyadrtencd;

    @Column(name=GenIT_SikkouTuuti.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return oyadrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    private String oyadrtennmkj;

    @Column(name=GenIT_SikkouTuuti.OYADRTENNMKJ)
    public String getOyadrtennmkj() {
        return oyadrtennmkj;
    }

    public void setOyadrtennmkj(String pOyadrtennmkj) {
        oyadrtennmkj = pOyadrtennmkj;
    }

    private String tsinyno;

    @Column(name=GenIT_SikkouTuuti.TSINYNO)
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

    @Column(name=GenIT_SikkouTuuti.TSINADR1KJ)
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

    @Column(name=GenIT_SikkouTuuti.TSINADR2KJ)
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

    @Column(name=GenIT_SikkouTuuti.TSINADR3KJ)
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

    private String tsintelno;

    @Column(name=GenIT_SikkouTuuti.TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTsintelno() {
        return tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    private String dai2tsintelno;

    @Column(name=GenIT_SikkouTuuti.DAI2TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getDai2tsintelno() {
        return dai2tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai2tsintelno(String pDai2tsintelno) {
        dai2tsintelno = pDai2tsintelno;
    }

    private String kyknmkj;

    @Column(name=GenIT_SikkouTuuti.KYKNMKJ)
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

    private String hhknnmkj;

    @Column(name=GenIT_SikkouTuuti.HHKNNMKJ)
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

    private String syouhnnm;

    @Column(name=GenIT_SikkouTuuti.SYOUHNNM)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyouhnnm() {
        return syouhnnm;
    }

    @Trim("right")
    public void setSyouhnnm(String pSyouhnnm) {
        syouhnnm = pSyouhnnm;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SikkouTuuti.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_SikkouTuuti.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_SikkouTuuti.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_SikkouTuuti.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private BizCurrency hrkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
        hrkpValue = null;
        hrkpType  = null;
    }

    transient private BigDecimal hrkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKP, nullable=true)
    protected BigDecimal getHrkpValue() {
        if (hrkpValue == null && hrkp != null) {
            if (hrkp.isOptional()) return null;
            return hrkp.absolute();
        }
        return hrkpValue;
    }

    protected void setHrkpValue(BigDecimal value) {
        hrkpValue = value;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    transient private String hrkpType = null;

    @Column(name=HRKP + "$", nullable=true)
    protected String getHrkpType() {
        if (hrkpType == null && hrkp != null) return hrkp.getType().toString();
        if (hrkpType == null && getHrkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkp$' should not be NULL."));
        }
        return hrkpType;
    }

    protected void setHrkpType(String type) {
        hrkpType = type;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    private BizDate sikkouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SikkouTuuti.SIKKOUYMD)
    public BizDate getSikkouymd() {
        return sikkouymd;
    }

    public void setSikkouymd(BizDate pSikkouymd) {
        sikkouymd = pSikkouymd;
    }

    private BizDate fukkatukigenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SikkouTuuti.FUKKATUKIGENYMD)
    public BizDate getFukkatukigenymd() {
        return fukkatukigenymd;
    }

    public void setFukkatukigenymd(BizDate pFukkatukigenymd) {
        fukkatukigenymd = pFukkatukigenymd;
    }

    private String bankcd;

    @Column(name=GenIT_SikkouTuuti.BANKCD)
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

    private String banknmkj;

    @Column(name=GenIT_SikkouTuuti.BANKNMKJ)
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

    private String sitencd;

    @Column(name=GenIT_SikkouTuuti.SITENCD)
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

    private String sitennmkj;

    @Column(name=GenIT_SikkouTuuti.SITENNMKJ)
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

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenIT_SikkouTuuti.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_SikkouTuuti.KOUZANO)
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

    private String kzmeiginmkn;

    @Column(name=GenIT_SikkouTuuti.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private String rcreditcardno;

    @Column(name=GenIT_SikkouTuuti.RCREDITCARDNO)
    public String getRcreditcardno() {
        return rcreditcardno;
    }

    public void setRcreditcardno(String pRcreditcardno) {
        rcreditcardno = pRcreditcardno;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_SikkouTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_SikkouTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_SikkouTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}