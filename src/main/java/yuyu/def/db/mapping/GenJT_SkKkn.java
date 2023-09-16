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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_3daiSippeiHknShrRiyuuKbn;
import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.classification.C_SensinItijikinShrUmuKbn;
import yuyu.def.classification.C_SyujyutuHousiki;
import yuyu.def.db.entity.JT_SkKkn;
import yuyu.def.db.id.PKJT_SkKkn;
import yuyu.def.db.meta.GenQJT_SkKkn;
import yuyu.def.db.meta.QJT_SkKkn;
import yuyu.def.db.type.UserType_C_3daiSippeiHknShrRiyuuKbn;
import yuyu.def.db.type.UserType_C_KyuuhuKbn;
import yuyu.def.db.type.UserType_C_SensinItijikinShrUmuKbn;
import yuyu.def.db.type.UserType_C_SyujyutuHousiki;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求期間テーブル テーブルのマッピング情報クラスで、 {@link JT_SkKkn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SkKkn}</td><td colspan="3">請求期間テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SkKkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SkKkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SkKkn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUketukeno uketukeno}</td><td>受付番号</td><td align="center">{@link PKJT_SkKkn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyuuhukbn kyuuhukbn}</td><td>給付区分</td><td align="center">{@link PKJT_SkKkn ○}</td><td align="center">V</td><td>{@link C_KyuuhuKbn}</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKJT_SkKkn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKikanfrom kikanfrom}</td><td>期間自</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKikanto kikanto}</td><td>期間至</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyujyututourokuno syujyututourokuno}</td><td>手術登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjcd1 kjcd1}</td><td>Ｋ・Ｊコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjcd2 kjcd2}</td><td>Ｋ・Ｊコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjcd3 kjcd3}</td><td>Ｋ・Ｊコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyutunmkn syujyutunmkn}</td><td>手術名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyutunmkj syujyutunmkj}</td><td>手術名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJyouken jyouken}</td><td>条件</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyutubunruicd syujyutubunruicd}</td><td>手術分類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyutuhousiki syujyutuhousiki}</td><td>手術方式</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyujyutuHousiki}</td></tr>
 *  <tr><td>{@link #getSensingijuturyou sensingijuturyou}</td><td>先進医療技術料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSensinitijikinshrumukbn sensinitijikinshrumukbn}</td><td>先進医療一時金支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SensinItijikinShrUmuKbn}</td></tr>
 *  <tr><td>{@link #getSandaisippeihknshrriyuukbn sandaisippeihknshrriyuukbn}</td><td>３大疾病保険金支払理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_3daiSippeiHknShrRiyuuKbn}</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SkKkn
 * @see     PKJT_SkKkn
 * @see     QJT_SkKkn
 * @see     GenQJT_SkKkn
 */
@MappedSuperclass
@Table(name=GenJT_SkKkn.TABLE_NAME)
@IdClass(value=PKJT_SkKkn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_3daiSippeiHknShrRiyuuKbn", typeClass=UserType_C_3daiSippeiHknShrRiyuuKbn.class),
    @TypeDef(name="UserType_C_KyuuhuKbn", typeClass=UserType_C_KyuuhuKbn.class),
    @TypeDef(name="UserType_C_SensinItijikinShrUmuKbn", typeClass=UserType_C_SensinItijikinShrUmuKbn.class),
    @TypeDef(name="UserType_C_SyujyutuHousiki", typeClass=UserType_C_SyujyutuHousiki.class)
})
public abstract class GenJT_SkKkn extends AbstractExDBEntity<JT_SkKkn, PKJT_SkKkn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SkKkn";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String UKETUKENO                = "uketukeno";
    public static final String KYUUHUKBN                = "kyuuhukbn";
    public static final String RENNO                    = "renno";
    public static final String KIKANFROM                = "kikanfrom";
    public static final String KIKANTO                  = "kikanto";
    public static final String SYUJYUTUTOUROKUNO        = "syujyututourokuno";
    public static final String KJCD1                    = "kjcd1";
    public static final String KJCD2                    = "kjcd2";
    public static final String KJCD3                    = "kjcd3";
    public static final String SYUJYUTUNMKN             = "syujyutunmkn";
    public static final String SYUJYUTUNMKJ             = "syujyutunmkj";
    public static final String JYOUKEN                  = "jyouken";
    public static final String SYUJYUTUBUNRUICD         = "syujyutubunruicd";
    public static final String SYUJYUTUHOUSIKI          = "syujyutuhousiki";
    public static final String SENSINGIJUTURYOU         = "sensingijuturyou";
    public static final String SENSINITIJIKINSHRUMUKBN  = "sensinitijikinshrumukbn";
    public static final String SANDAISIPPEIHKNSHRRIYUUKBN = "sandaisippeihknshrriyuukbn";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SkKkn primaryKey;

    public GenJT_SkKkn() {
        primaryKey = new PKJT_SkKkn();
    }

    public GenJT_SkKkn(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pUketukeno,
        C_KyuuhuKbn pKyuuhukbn,
        Integer pRenno
    ) {
        primaryKey = new PKJT_SkKkn(
            pSkno,
            pSyono,
            pSeikyuurirekino,
            pUketukeno,
            pKyuuhukbn,
            pRenno
        );
    }

    @Transient
    @Override
    public PKJT_SkKkn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SkKkn> getMetaClass() {
        return QJT_SkKkn.class;
    }

    @Id
    @Column(name=GenJT_SkKkn.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SkKkn.SYONO)
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
    @Column(name=GenJT_SkKkn.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    @Id
    @Column(name=GenJT_SkKkn.UKETUKENO)
    public Integer getUketukeno() {
        return getPrimaryKey().getUketukeno();
    }

    public void setUketukeno(Integer pUketukeno) {
        getPrimaryKey().setUketukeno(pUketukeno);
    }

    @Id
    @Type(type="UserType_C_KyuuhuKbn")
    @Column(name=GenJT_SkKkn.KYUUHUKBN)
    public C_KyuuhuKbn getKyuuhukbn() {
        return getPrimaryKey().getKyuuhukbn();
    }

    public void setKyuuhukbn(C_KyuuhuKbn pKyuuhukbn) {
        getPrimaryKey().setKyuuhukbn(pKyuuhukbn);
    }

    @Id
    @Column(name=GenJT_SkKkn.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate kikanfrom;

    @Type(type="BizDateType")
    @Column(name=GenJT_SkKkn.KIKANFROM)
    public BizDate getKikanfrom() {
        return kikanfrom;
    }

    public void setKikanfrom(BizDate pKikanfrom) {
        kikanfrom = pKikanfrom;
    }

    private BizDate kikanto;

    @Type(type="BizDateType")
    @Column(name=GenJT_SkKkn.KIKANTO)
    public BizDate getKikanto() {
        return kikanto;
    }

    public void setKikanto(BizDate pKikanto) {
        kikanto = pKikanto;
    }

    private String syujyututourokuno;

    @Column(name=GenJT_SkKkn.SYUJYUTUTOUROKUNO)
    public String getSyujyututourokuno() {
        return syujyututourokuno;
    }

    public void setSyujyututourokuno(String pSyujyututourokuno) {
        syujyututourokuno = pSyujyututourokuno;
    }

    private String kjcd1;

    @Column(name=GenJT_SkKkn.KJCD1)
    public String getKjcd1() {
        return kjcd1;
    }

    public void setKjcd1(String pKjcd1) {
        kjcd1 = pKjcd1;
    }

    private String kjcd2;

    @Column(name=GenJT_SkKkn.KJCD2)
    public String getKjcd2() {
        return kjcd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKjcd2(String pKjcd2) {
        kjcd2 = pKjcd2;
    }

    private String kjcd3;

    @Column(name=GenJT_SkKkn.KJCD3)
    public String getKjcd3() {
        return kjcd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKjcd3(String pKjcd3) {
        kjcd3 = pKjcd3;
    }

    private String syujyutunmkn;

    @Column(name=GenJT_SkKkn.SYUJYUTUNMKN)
    public String getSyujyutunmkn() {
        return syujyutunmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyujyutunmkn(String pSyujyutunmkn) {
        syujyutunmkn = pSyujyutunmkn;
    }

    private String syujyutunmkj;

    @Column(name=GenJT_SkKkn.SYUJYUTUNMKJ)
    public String getSyujyutunmkj() {
        return syujyutunmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyujyutunmkj(String pSyujyutunmkj) {
        syujyutunmkj = pSyujyutunmkj;
    }

    private String jyouken;

    @Column(name=GenJT_SkKkn.JYOUKEN)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getJyouken() {
        return jyouken;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setJyouken(String pJyouken) {
        jyouken = pJyouken;
    }

    private String syujyutubunruicd;

    @Column(name=GenJT_SkKkn.SYUJYUTUBUNRUICD)
    @MaxLength(max=3)
    @AlphaDigit
    @SingleByteStrings
    public String getSyujyutubunruicd() {
        return syujyutubunruicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyujyutubunruicd(String pSyujyutubunruicd) {
        syujyutubunruicd = pSyujyutubunruicd;
    }

    private C_SyujyutuHousiki syujyutuhousiki;

    @Type(type="UserType_C_SyujyutuHousiki")
    @Column(name=GenJT_SkKkn.SYUJYUTUHOUSIKI)
    public C_SyujyutuHousiki getSyujyutuhousiki() {
        return syujyutuhousiki;
    }

    public void setSyujyutuhousiki(C_SyujyutuHousiki pSyujyutuhousiki) {
        syujyutuhousiki = pSyujyutuhousiki;
    }

    private BizCurrency sensingijuturyou;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=11)
    @PositiveNumberBizCalcble
    public BizCurrency getSensingijuturyou() {
        return sensingijuturyou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSensingijuturyou(BizCurrency pSensingijuturyou) {
        sensingijuturyou = pSensingijuturyou;
        sensingijuturyouValue = null;
        sensingijuturyouType  = null;
    }

    transient private BigDecimal sensingijuturyouValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SENSINGIJUTURYOU, nullable=true)
    protected BigDecimal getSensingijuturyouValue() {
        if (sensingijuturyouValue == null && sensingijuturyou != null) {
            if (sensingijuturyou.isOptional()) return null;
            return sensingijuturyou.absolute();
        }
        return sensingijuturyouValue;
    }

    protected void setSensingijuturyouValue(BigDecimal value) {
        sensingijuturyouValue = value;
        sensingijuturyou = Optional.fromNullable(toCurrencyType(sensingijuturyouType))
            .transform(bizCurrencyTransformer(getSensingijuturyouValue()))
            .orNull();
    }

    transient private String sensingijuturyouType = null;

    @Column(name=SENSINGIJUTURYOU + "$", nullable=true)
    protected String getSensingijuturyouType() {
        if (sensingijuturyouType == null && sensingijuturyou != null) return sensingijuturyou.getType().toString();
        if (sensingijuturyouType == null && getSensingijuturyouValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sensingijuturyou$' should not be NULL."));
        }
        return sensingijuturyouType;
    }

    protected void setSensingijuturyouType(String type) {
        sensingijuturyouType = type;
        sensingijuturyou = Optional.fromNullable(toCurrencyType(sensingijuturyouType))
            .transform(bizCurrencyTransformer(getSensingijuturyouValue()))
            .orNull();
    }

    private C_SensinItijikinShrUmuKbn sensinitijikinshrumukbn;

    @Type(type="UserType_C_SensinItijikinShrUmuKbn")
    @Column(name=GenJT_SkKkn.SENSINITIJIKINSHRUMUKBN)
    public C_SensinItijikinShrUmuKbn getSensinitijikinshrumukbn() {
        return sensinitijikinshrumukbn;
    }

    public void setSensinitijikinshrumukbn(C_SensinItijikinShrUmuKbn pSensinitijikinshrumukbn) {
        sensinitijikinshrumukbn = pSensinitijikinshrumukbn;
    }

    private C_3daiSippeiHknShrRiyuuKbn sandaisippeihknshrriyuukbn;

    @Type(type="UserType_C_3daiSippeiHknShrRiyuuKbn")
    @Column(name=GenJT_SkKkn.SANDAISIPPEIHKNSHRRIYUUKBN)
    public C_3daiSippeiHknShrRiyuuKbn getSandaisippeihknshrriyuukbn() {
        return sandaisippeihknshrriyuukbn;
    }

    public void setSandaisippeihknshrriyuukbn(C_3daiSippeiHknShrRiyuuKbn pSandaisippeihknshrriyuukbn) {
        sandaisippeihknshrriyuukbn = pSandaisippeihknshrriyuukbn;
    }

    private String kossyoricd;

    @Column(name=GenJT_SkKkn.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SkKkn.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SkKkn.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SkKkn.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}