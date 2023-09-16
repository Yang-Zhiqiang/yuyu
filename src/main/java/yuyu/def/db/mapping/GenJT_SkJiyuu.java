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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_KenpoTaisyouKbn;
import yuyu.def.classification.C_KnptsgetcKbn;
import yuyu.def.classification.C_KnptsgkkmsnKbn;
import yuyu.def.classification.C_KnptsgknmsnyKbn;
import yuyu.def.classification.C_KnptsgsnsnKbn;
import yuyu.def.classification.C_KnptsgtknKbn;
import yuyu.def.classification.C_LnSeikyuuKbn;
import yuyu.def.classification.C_NyuuinJyoukyou;
import yuyu.def.classification.C_PmenKbn;
import yuyu.def.classification.C_SaigaiGeninKbn;
import yuyu.def.classification.C_SibouBasyoKbn;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.id.PKJT_SkJiyuu;
import yuyu.def.db.meta.GenQJT_SkJiyuu;
import yuyu.def.db.meta.QJT_SkJiyuu;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_KenpoTaisyouKbn;
import yuyu.def.db.type.UserType_C_KnptsgetcKbn;
import yuyu.def.db.type.UserType_C_KnptsgkkmsnKbn;
import yuyu.def.db.type.UserType_C_KnptsgknmsnyKbn;
import yuyu.def.db.type.UserType_C_KnptsgsnsnKbn;
import yuyu.def.db.type.UserType_C_KnptsgtknKbn;
import yuyu.def.db.type.UserType_C_LnSeikyuuKbn;
import yuyu.def.db.type.UserType_C_NyuuinJyoukyou;
import yuyu.def.db.type.UserType_C_PmenKbn;
import yuyu.def.db.type.UserType_C_SaigaiGeninKbn;
import yuyu.def.db.type.UserType_C_SibouBasyoKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求事由テーブル テーブルのマッピング情報クラスで、 {@link JT_SkJiyuu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SkJiyuu}</td><td colspan="3">請求事由テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SkJiyuu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SkJiyuu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SkJiyuu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUketukeno uketukeno}</td><td>受付番号</td><td align="center">{@link PKJT_SkJiyuu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGeninkbn geninkbn}</td><td>原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GeninKbn}</td></tr>
 *  <tr><td>{@link #getJikosyosinymd jikosyosinymd}</td><td>事故（初診）日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoubyouhsymd syoubyouhsymd}</td><td>傷病発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSaigaigeninkbn saigaigeninkbn}</td><td>災害原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SaigaiGeninKbn}</td></tr>
 *  <tr><td>{@link #getGansindankakuteiymd gansindankakuteiymd}</td><td>がん診断確定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuuinjyoukyou nyuuinjyoukyou}</td><td>入院状況</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyuuinJyoukyou}</td></tr>
 *  <tr><td>{@link #getSyuyouzaisiyouyoteiym syuyouzaisiyouyoteiym}</td><td>腫瘍剤使用予定年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKenpotaisyoukbn kenpotaisyoukbn}</td><td>健保対象区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KenpoTaisyouKbn}</td></tr>
 *  <tr><td>{@link #getKnptsgairytikenkbn knptsgairytikenkbn}</td><td>健保対象外理由（治験）区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KnptsgtknKbn}</td></tr>
 *  <tr><td>{@link #getKnptsgairysensinkbn knptsgairysensinkbn}</td><td>健保対象外理由（先進医療）区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KnptsgsnsnKbn}</td></tr>
 *  <tr><td>{@link #getKnptsgairykknaimsynnyakukbn knptsgairykknaimsynnyakukbn}</td><td>健保対象外理由（国内未承認薬）区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KnptsgknmsnyKbn}</td></tr>
 *  <tr><td>{@link #getKnptsgairykyyhkkyhmsynnkbn knptsgairykyyhkkyhmsynnkbn}</td><td>健保対象外理由（効果用法未承認）区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KnptsgkkmsnKbn}</td></tr>
 *  <tr><td>{@link #getKnptsgairysonotakbn knptsgairysonotakbn}</td><td>健保対象外理由（その他）区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KnptsgetcKbn}</td></tr>
 *  <tr><td>{@link #getKnptsgairysonotanaiyou knptsgairysonotanaiyou}</td><td>健保対象外理由（その他内容）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSibouymd sibouymd}</td><td>死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSiboubasyokbn siboubasyokbn}</td><td>死亡場所区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SibouBasyoKbn}</td></tr>
 *  <tr><td>{@link #getSiboubasyo siboubasyo}</td><td>死亡場所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyougaikoteiymd syougaikoteiymd}</td><td>障害固定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPmenkbn pmenkbn}</td><td>Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PmenKbn}</td></tr>
 *  <tr><td>{@link #getPmenkoteiymd pmenkoteiymd}</td><td>Ｐ免固定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLnseikyuukbn lnseikyuukbn}</td><td>ＬＮ請求区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_LnSeikyuuKbn}</td></tr>
 *  <tr><td>{@link #getLnsiteihokenkngk lnsiteihokenkngk}</td><td>ＬＮ指定保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SkJiyuu
 * @see     PKJT_SkJiyuu
 * @see     QJT_SkJiyuu
 * @see     GenQJT_SkJiyuu
 */
@MappedSuperclass
@Table(name=GenJT_SkJiyuu.TABLE_NAME)
@IdClass(value=PKJT_SkJiyuu.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_GeninKbn", typeClass=UserType_C_GeninKbn.class),
    @TypeDef(name="UserType_C_KenpoTaisyouKbn", typeClass=UserType_C_KenpoTaisyouKbn.class),
    @TypeDef(name="UserType_C_KnptsgetcKbn", typeClass=UserType_C_KnptsgetcKbn.class),
    @TypeDef(name="UserType_C_KnptsgkkmsnKbn", typeClass=UserType_C_KnptsgkkmsnKbn.class),
    @TypeDef(name="UserType_C_KnptsgknmsnyKbn", typeClass=UserType_C_KnptsgknmsnyKbn.class),
    @TypeDef(name="UserType_C_KnptsgsnsnKbn", typeClass=UserType_C_KnptsgsnsnKbn.class),
    @TypeDef(name="UserType_C_KnptsgtknKbn", typeClass=UserType_C_KnptsgtknKbn.class),
    @TypeDef(name="UserType_C_LnSeikyuuKbn", typeClass=UserType_C_LnSeikyuuKbn.class),
    @TypeDef(name="UserType_C_NyuuinJyoukyou", typeClass=UserType_C_NyuuinJyoukyou.class),
    @TypeDef(name="UserType_C_PmenKbn", typeClass=UserType_C_PmenKbn.class),
    @TypeDef(name="UserType_C_SaigaiGeninKbn", typeClass=UserType_C_SaigaiGeninKbn.class),
    @TypeDef(name="UserType_C_SibouBasyoKbn", typeClass=UserType_C_SibouBasyoKbn.class)
})
public abstract class GenJT_SkJiyuu extends AbstractExDBEntity<JT_SkJiyuu, PKJT_SkJiyuu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SkJiyuu";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String UKETUKENO                = "uketukeno";
    public static final String GENINKBN                 = "geninkbn";
    public static final String JIKOSYOSINYMD            = "jikosyosinymd";
    public static final String SYOUBYOUHSYMD            = "syoubyouhsymd";
    public static final String SAIGAIGENINKBN           = "saigaigeninkbn";
    public static final String GANSINDANKAKUTEIYMD      = "gansindankakuteiymd";
    public static final String NYUUINJYOUKYOU           = "nyuuinjyoukyou";
    public static final String SYUYOUZAISIYOUYOTEIYM    = "syuyouzaisiyouyoteiym";
    public static final String KENPOTAISYOUKBN          = "kenpotaisyoukbn";
    public static final String KNPTSGAIRYTIKENKBN       = "knptsgairytikenkbn";
    public static final String KNPTSGAIRYSENSINKBN      = "knptsgairysensinkbn";
    public static final String KNPTSGAIRYKKNAIMSYNNYAKUKBN = "knptsgairykknaimsynnyakukbn";
    public static final String KNPTSGAIRYKYYHKKYHMSYNNKBN = "knptsgairykyyhkkyhmsynnkbn";
    public static final String KNPTSGAIRYSONOTAKBN      = "knptsgairysonotakbn";
    public static final String KNPTSGAIRYSONOTANAIYOU   = "knptsgairysonotanaiyou";
    public static final String SIBOUYMD                 = "sibouymd";
    public static final String SIBOUBASYOKBN            = "siboubasyokbn";
    public static final String SIBOUBASYO               = "siboubasyo";
    public static final String SYOUGAIKOTEIYMD          = "syougaikoteiymd";
    public static final String PMENKBN                  = "pmenkbn";
    public static final String PMENKOTEIYMD             = "pmenkoteiymd";
    public static final String LNSEIKYUUKBN             = "lnseikyuukbn";
    public static final String LNSITEIHOKENKNGK         = "lnsiteihokenkngk";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SkJiyuu primaryKey;

    public GenJT_SkJiyuu() {
        primaryKey = new PKJT_SkJiyuu();
    }

    public GenJT_SkJiyuu(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pUketukeno
    ) {
        primaryKey = new PKJT_SkJiyuu(
            pSkno,
            pSyono,
            pSeikyuurirekino,
            pUketukeno
        );
    }

    @Transient
    @Override
    public PKJT_SkJiyuu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SkJiyuu> getMetaClass() {
        return QJT_SkJiyuu.class;
    }

    @Id
    @Column(name=GenJT_SkJiyuu.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SkJiyuu.SYONO)
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
    @Column(name=GenJT_SkJiyuu.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    @Id
    @Column(name=GenJT_SkJiyuu.UKETUKENO)
    public Integer getUketukeno() {
        return getPrimaryKey().getUketukeno();
    }

    public void setUketukeno(Integer pUketukeno) {
        getPrimaryKey().setUketukeno(pUketukeno);
    }

    private C_GeninKbn geninkbn;

    @Type(type="UserType_C_GeninKbn")
    @Column(name=GenJT_SkJiyuu.GENINKBN)
    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    private BizDate jikosyosinymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SkJiyuu.JIKOSYOSINYMD)
    @ValidDate
    public BizDate getJikosyosinymd() {
        return jikosyosinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJikosyosinymd(BizDate pJikosyosinymd) {
        jikosyosinymd = pJikosyosinymd;
    }

    private BizDate syoubyouhsymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SkJiyuu.SYOUBYOUHSYMD)
    @ValidDate
    public BizDate getSyoubyouhsymd() {
        return syoubyouhsymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoubyouhsymd(BizDate pSyoubyouhsymd) {
        syoubyouhsymd = pSyoubyouhsymd;
    }

    private C_SaigaiGeninKbn saigaigeninkbn;

    @Type(type="UserType_C_SaigaiGeninKbn")
    @Column(name=GenJT_SkJiyuu.SAIGAIGENINKBN)
    public C_SaigaiGeninKbn getSaigaigeninkbn() {
        return saigaigeninkbn;
    }

    public void setSaigaigeninkbn(C_SaigaiGeninKbn pSaigaigeninkbn) {
        saigaigeninkbn = pSaigaigeninkbn;
    }

    private String gansindankakuteiymd;

    @Column(name=GenJT_SkJiyuu.GANSINDANKAKUTEIYMD)
    public String getGansindankakuteiymd() {
        return gansindankakuteiymd;
    }

    @DataConvert("toSingleByte")
    public void setGansindankakuteiymd(String pGansindankakuteiymd) {
        gansindankakuteiymd = pGansindankakuteiymd;
    }

    private C_NyuuinJyoukyou nyuuinjyoukyou;

    @Type(type="UserType_C_NyuuinJyoukyou")
    @Column(name=GenJT_SkJiyuu.NYUUINJYOUKYOU)
    public C_NyuuinJyoukyou getNyuuinjyoukyou() {
        return nyuuinjyoukyou;
    }

    public void setNyuuinjyoukyou(C_NyuuinJyoukyou pNyuuinjyoukyou) {
        nyuuinjyoukyou = pNyuuinjyoukyou;
    }

    private BizDateYM syuyouzaisiyouyoteiym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_SkJiyuu.SYUYOUZAISIYOUYOTEIYM)
    @ValidDateYm
    public BizDateYM getSyuyouzaisiyouyoteiym() {
        return syuyouzaisiyouyoteiym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyuyouzaisiyouyoteiym(BizDateYM pSyuyouzaisiyouyoteiym) {
        syuyouzaisiyouyoteiym = pSyuyouzaisiyouyoteiym;
    }

    private C_KenpoTaisyouKbn kenpotaisyoukbn;

    @Type(type="UserType_C_KenpoTaisyouKbn")
    @Column(name=GenJT_SkJiyuu.KENPOTAISYOUKBN)
    public C_KenpoTaisyouKbn getKenpotaisyoukbn() {
        return kenpotaisyoukbn;
    }

    public void setKenpotaisyoukbn(C_KenpoTaisyouKbn pKenpotaisyoukbn) {
        kenpotaisyoukbn = pKenpotaisyoukbn;
    }

    private C_KnptsgtknKbn knptsgairytikenkbn;

    @Type(type="UserType_C_KnptsgtknKbn")
    @Column(name=GenJT_SkJiyuu.KNPTSGAIRYTIKENKBN)
    public C_KnptsgtknKbn getKnptsgairytikenkbn() {
        return knptsgairytikenkbn;
    }

    public void setKnptsgairytikenkbn(C_KnptsgtknKbn pKnptsgairytikenkbn) {
        knptsgairytikenkbn = pKnptsgairytikenkbn;
    }

    private C_KnptsgsnsnKbn knptsgairysensinkbn;

    @Type(type="UserType_C_KnptsgsnsnKbn")
    @Column(name=GenJT_SkJiyuu.KNPTSGAIRYSENSINKBN)
    public C_KnptsgsnsnKbn getKnptsgairysensinkbn() {
        return knptsgairysensinkbn;
    }

    public void setKnptsgairysensinkbn(C_KnptsgsnsnKbn pKnptsgairysensinkbn) {
        knptsgairysensinkbn = pKnptsgairysensinkbn;
    }

    private C_KnptsgknmsnyKbn knptsgairykknaimsynnyakukbn;

    @Type(type="UserType_C_KnptsgknmsnyKbn")
    @Column(name=GenJT_SkJiyuu.KNPTSGAIRYKKNAIMSYNNYAKUKBN)
    public C_KnptsgknmsnyKbn getKnptsgairykknaimsynnyakukbn() {
        return knptsgairykknaimsynnyakukbn;
    }

    public void setKnptsgairykknaimsynnyakukbn(C_KnptsgknmsnyKbn pKnptsgairykknaimsynnyakukbn) {
        knptsgairykknaimsynnyakukbn = pKnptsgairykknaimsynnyakukbn;
    }

    private C_KnptsgkkmsnKbn knptsgairykyyhkkyhmsynnkbn;

    @Type(type="UserType_C_KnptsgkkmsnKbn")
    @Column(name=GenJT_SkJiyuu.KNPTSGAIRYKYYHKKYHMSYNNKBN)
    public C_KnptsgkkmsnKbn getKnptsgairykyyhkkyhmsynnkbn() {
        return knptsgairykyyhkkyhmsynnkbn;
    }

    public void setKnptsgairykyyhkkyhmsynnkbn(C_KnptsgkkmsnKbn pKnptsgairykyyhkkyhmsynnkbn) {
        knptsgairykyyhkkyhmsynnkbn = pKnptsgairykyyhkkyhmsynnkbn;
    }

    private C_KnptsgetcKbn knptsgairysonotakbn;

    @Type(type="UserType_C_KnptsgetcKbn")
    @Column(name=GenJT_SkJiyuu.KNPTSGAIRYSONOTAKBN)
    public C_KnptsgetcKbn getKnptsgairysonotakbn() {
        return knptsgairysonotakbn;
    }

    public void setKnptsgairysonotakbn(C_KnptsgetcKbn pKnptsgairysonotakbn) {
        knptsgairysonotakbn = pKnptsgairysonotakbn;
    }

    private String knptsgairysonotanaiyou;

    @Column(name=GenJT_SkJiyuu.KNPTSGAIRYSONOTANAIYOU)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getKnptsgairysonotanaiyou() {
        return knptsgairysonotanaiyou;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKnptsgairysonotanaiyou(String pKnptsgairysonotanaiyou) {
        knptsgairysonotanaiyou = pKnptsgairysonotanaiyou;
    }

    private BizDate sibouymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SkJiyuu.SIBOUYMD)
    @ValidDate
    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    private C_SibouBasyoKbn siboubasyokbn;

    @Type(type="UserType_C_SibouBasyoKbn")
    @Column(name=GenJT_SkJiyuu.SIBOUBASYOKBN)
    public C_SibouBasyoKbn getSiboubasyokbn() {
        return siboubasyokbn;
    }

    public void setSiboubasyokbn(C_SibouBasyoKbn pSiboubasyokbn) {
        siboubasyokbn = pSiboubasyokbn;
    }

    private String siboubasyo;

    @Column(name=GenJT_SkJiyuu.SIBOUBASYO)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getSiboubasyo() {
        return siboubasyo;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSiboubasyo(String pSiboubasyo) {
        siboubasyo = pSiboubasyo;
    }

    private BizDate syougaikoteiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SkJiyuu.SYOUGAIKOTEIYMD)
    @ValidDate
    public BizDate getSyougaikoteiymd() {
        return syougaikoteiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyougaikoteiymd(BizDate pSyougaikoteiymd) {
        syougaikoteiymd = pSyougaikoteiymd;
    }

    private C_PmenKbn pmenkbn;

    @Type(type="UserType_C_PmenKbn")
    @Column(name=GenJT_SkJiyuu.PMENKBN)
    public C_PmenKbn getPmenkbn() {
        return pmenkbn;
    }

    public void setPmenkbn(C_PmenKbn pPmenkbn) {
        pmenkbn = pPmenkbn;
    }

    private BizDate pmenkoteiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SkJiyuu.PMENKOTEIYMD)
    @ValidDate
    public BizDate getPmenkoteiymd() {
        return pmenkoteiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPmenkoteiymd(BizDate pPmenkoteiymd) {
        pmenkoteiymd = pPmenkoteiymd;
    }

    private C_LnSeikyuuKbn lnseikyuukbn;

    @Type(type="UserType_C_LnSeikyuuKbn")
    @Column(name=GenJT_SkJiyuu.LNSEIKYUUKBN)
    public C_LnSeikyuuKbn getLnseikyuukbn() {
        return lnseikyuukbn;
    }

    public void setLnseikyuukbn(C_LnSeikyuuKbn pLnseikyuukbn) {
        lnseikyuukbn = pLnseikyuukbn;
    }

    private BizCurrency lnsiteihokenkngk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=4)
    public BizCurrency getLnsiteihokenkngk() {
        return lnsiteihokenkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLnsiteihokenkngk(BizCurrency pLnsiteihokenkngk) {
        lnsiteihokenkngk = pLnsiteihokenkngk;
        lnsiteihokenkngkValue = null;
        lnsiteihokenkngkType  = null;
    }

    transient private BigDecimal lnsiteihokenkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=LNSITEIHOKENKNGK, nullable=true)
    protected BigDecimal getLnsiteihokenkngkValue() {
        if (lnsiteihokenkngkValue == null && lnsiteihokenkngk != null) {
            if (lnsiteihokenkngk.isOptional()) return null;
            return lnsiteihokenkngk.absolute();
        }
        return lnsiteihokenkngkValue;
    }

    protected void setLnsiteihokenkngkValue(BigDecimal value) {
        lnsiteihokenkngkValue = value;
        lnsiteihokenkngk = Optional.fromNullable(toCurrencyType(lnsiteihokenkngkType))
            .transform(bizCurrencyTransformer(getLnsiteihokenkngkValue()))
            .orNull();
    }

    transient private String lnsiteihokenkngkType = null;

    @Column(name=LNSITEIHOKENKNGK + "$", nullable=true)
    protected String getLnsiteihokenkngkType() {
        if (lnsiteihokenkngkType == null && lnsiteihokenkngk != null) return lnsiteihokenkngk.getType().toString();
        if (lnsiteihokenkngkType == null && getLnsiteihokenkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'lnsiteihokenkngk$' should not be NULL."));
        }
        return lnsiteihokenkngkType;
    }

    protected void setLnsiteihokenkngkType(String type) {
        lnsiteihokenkngkType = type;
        lnsiteihokenkngk = Optional.fromNullable(toCurrencyType(lnsiteihokenkngkType))
            .transform(bizCurrencyTransformer(getLnsiteihokenkngkValue()))
            .orNull();
    }

    private String kossyoricd;

    @Column(name=GenJT_SkJiyuu.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SkJiyuu.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SkJiyuu.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SkJiyuu.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}