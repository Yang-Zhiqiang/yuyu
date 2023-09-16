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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_BAK_SyuunouHenknRireki;
import yuyu.def.db.id.PKIT_BAK_SyuunouHenknRireki;
import yuyu.def.db.meta.GenQIT_BAK_SyuunouHenknRireki;
import yuyu.def.db.meta.QIT_BAK_SyuunouHenknRireki;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_ShrriyuuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 収納返金履歴バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_SyuunouHenknRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_SyuunouHenknRireki}</td><td colspan="3">収納返金履歴バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_SyuunouHenknRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_SyuunouHenknRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_SyuunouHenknRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">{@link PKIT_BAK_SyuunouHenknRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">{@link PKIT_BAK_SyuunouHenknRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDenkihyouymd denkihyouymd}</td><td>伝票起票日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrymd shrymd}</td><td>支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getHnkngk hnkngk}</td><td>返金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrriyuukbn shrriyuukbn}</td><td>支払理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrriyuuKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_SyuunouHenknRireki
 * @see     PKIT_BAK_SyuunouHenknRireki
 * @see     QIT_BAK_SyuunouHenknRireki
 * @see     GenQIT_BAK_SyuunouHenknRireki
 */
@MappedSuperclass
@Table(name=GenIT_BAK_SyuunouHenknRireki.TABLE_NAME)
@IdClass(value=PKIT_BAK_SyuunouHenknRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_ShrriyuuKbn", typeClass=UserType_C_ShrriyuuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_BAK_SyuunouHenknRireki extends AbstractExDBEntity<IT_BAK_SyuunouHenknRireki, PKIT_BAK_SyuunouHenknRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_SyuunouHenknRireki";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String DENKIHYOUYMD             = "denkihyouymd";
    public static final String SHRYMD                   = "shrymd";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String HNKNGK                   = "hnkngk";
    public static final String SHRRIYUUKBN              = "shrriyuukbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";

    private final PKIT_BAK_SyuunouHenknRireki primaryKey;

    public GenIT_BAK_SyuunouHenknRireki() {
        primaryKey = new PKIT_BAK_SyuunouHenknRireki();
    }

    public GenIT_BAK_SyuunouHenknRireki(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pDenrenno,
        Integer pEdano
    ) {
        primaryKey = new PKIT_BAK_SyuunouHenknRireki(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pDenrenno,
            pEdano
        );
    }

    @Transient
    @Override
    public PKIT_BAK_SyuunouHenknRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_SyuunouHenknRireki> getMetaClass() {
        return QIT_BAK_SyuunouHenknRireki.class;
    }

    @Id
    @Column(name=GenIT_BAK_SyuunouHenknRireki.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_SyuunouHenknRireki.SYONO)
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
    @Column(name=GenIT_BAK_SyuunouHenknRireki.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_SyuunouHenknRireki.DENRENNO)
    public String getDenrenno() {
        return getPrimaryKey().getDenrenno();
    }

    public void setDenrenno(String pDenrenno) {
        getPrimaryKey().setDenrenno(pDenrenno);
    }

    @Id
    @Column(name=GenIT_BAK_SyuunouHenknRireki.EDANO)
    public Integer getEdano() {
        return getPrimaryKey().getEdano();
    }

    public void setEdano(Integer pEdano) {
        getPrimaryKey().setEdano(pEdano);
    }

    private BizDate denkihyouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_SyuunouHenknRireki.DENKIHYOUYMD)
    public BizDate getDenkihyouymd() {
        return denkihyouymd;
    }

    public void setDenkihyouymd(BizDate pDenkihyouymd) {
        denkihyouymd = pDenkihyouymd;
    }

    private BizDate shrymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_SyuunouHenknRireki.SHRYMD)
    @ValidDate
    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenIT_BAK_SyuunouHenknRireki.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    private BizCurrency hnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getHnkngk() {
        return hnkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHnkngk(BizCurrency pHnkngk) {
        hnkngk = pHnkngk;
        hnkngkValue = null;
        hnkngkType  = null;
    }

    transient private BigDecimal hnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HNKNGK, nullable=true)
    protected BigDecimal getHnkngkValue() {
        if (hnkngkValue == null && hnkngk != null) {
            if (hnkngk.isOptional()) return null;
            return hnkngk.absolute();
        }
        return hnkngkValue;
    }

    protected void setHnkngkValue(BigDecimal value) {
        hnkngkValue = value;
        hnkngk = Optional.fromNullable(toCurrencyType(hnkngkType))
            .transform(bizCurrencyTransformer(getHnkngkValue()))
            .orNull();
    }

    transient private String hnkngkType = null;

    @Column(name=HNKNGK + "$", nullable=true)
    protected String getHnkngkType() {
        if (hnkngkType == null && hnkngk != null) return hnkngk.getType().toString();
        if (hnkngkType == null && getHnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hnkngk$' should not be NULL."));
        }
        return hnkngkType;
    }

    protected void setHnkngkType(String type) {
        hnkngkType = type;
        hnkngk = Optional.fromNullable(toCurrencyType(hnkngkType))
            .transform(bizCurrencyTransformer(getHnkngkValue()))
            .orNull();
    }

    private C_ShrriyuuKbn shrriyuukbn;

    @Type(type="UserType_C_ShrriyuuKbn")
    @Column(name=GenIT_BAK_SyuunouHenknRireki.SHRRIYUUKBN)
    public C_ShrriyuuKbn getShrriyuukbn() {
        return shrriyuukbn;
    }

    public void setShrriyuukbn(C_ShrriyuuKbn pShrriyuukbn) {
        shrriyuukbn = pShrriyuukbn;
    }

    private String bankcd;

    @Column(name=GenIT_BAK_SyuunouHenknRireki.BANKCD)
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

    @Column(name=GenIT_BAK_SyuunouHenknRireki.SITENCD)
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
    @Column(name=GenIT_BAK_SyuunouHenknRireki.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_BAK_SyuunouHenknRireki.KOUZANO)
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

    @Column(name=GenIT_BAK_SyuunouHenknRireki.KZMEIGINMKN)
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

    private String creditcardno1;

    @Column(name=GenIT_BAK_SyuunouHenknRireki.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIT_BAK_SyuunouHenknRireki.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIT_BAK_SyuunouHenknRireki.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIT_BAK_SyuunouHenknRireki.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_SyuunouHenknRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_SyuunouHenknRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_SyuunouHenknRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String creditkessaiyouno;

    @Column(name=GenIT_BAK_SyuunouHenknRireki.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }
}