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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_DairitenMinyuKykMeisai;
import yuyu.def.db.id.PKIT_DairitenMinyuKykMeisai;
import yuyu.def.db.meta.GenQIT_DairitenMinyuKykMeisai;
import yuyu.def.db.meta.QIT_DairitenMinyuKykMeisai;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 代理店未入契約明細テーブル テーブルのマッピング情報クラスで、 {@link IT_DairitenMinyuKykMeisai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_DairitenMinyuKykMeisai}</td><td colspan="3">代理店未入契約明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_DairitenMinyuKykMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_DairitenMinyuKykMeisai ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_DairitenMinyuKykMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenrenno drtenrenno}</td><td>代理店連番</td><td align="center">{@link PKIT_DairitenMinyuKykMeisai ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd bosyuucd}</td><td>募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPjytym pjytym}</td><td>保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjidairitennm kanjidairitennm}</td><td>漢字代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyujytymd minyujytymd}</td><td>未入充当年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHassinka hassinka}</td><td>発信課</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKanjibosyuuninnm kanjibosyuuninnm}</td><td>漢字募集人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKydatkikbn kydatkikbn}</td><td>共同扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHurihunokbn hurihunokbn}</td><td>振替不能理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HurihunoKbn}</td></tr>
 *  <tr><td>{@link #getBosyuuningyouhaiymd bosyuuningyouhaiymd}</td><td>募集人業廃年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDntcd dntcd}</td><td>団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjdntnm kjdntnm}</td><td>漢字団体名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyuruinm hknsyuruinm}</td><td>保険種類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHjnkykhyj hjnkykhyj}</td><td>法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_DairitenMinyuKykMeisai
 * @see     PKIT_DairitenMinyuKykMeisai
 * @see     QIT_DairitenMinyuKykMeisai
 * @see     GenQIT_DairitenMinyuKykMeisai
 */
@MappedSuperclass
@Table(name=GenIT_DairitenMinyuKykMeisai.TABLE_NAME)
@IdClass(value=PKIT_DairitenMinyuKykMeisai.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_HurihunoKbn", typeClass=UserType_C_HurihunoKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_DairitenMinyuKykMeisai extends AbstractExDBEntity<IT_DairitenMinyuKykMeisai, PKIT_DairitenMinyuKykMeisai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_DairitenMinyuKykMeisai";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYONO                    = "syono";
    public static final String DRTENRENNO               = "drtenrenno";
    public static final String DRTENCD                  = "drtencd";
    public static final String BOSYUUCD                 = "bosyuucd";
    public static final String PJYTYM                   = "pjytym";
    public static final String KYKYMD                   = "kykymd";
    public static final String CIFCD                    = "cifcd";
    public static final String KANJIDAIRITENNM          = "kanjidairitennm";
    public static final String MINYUJYTYMD              = "minyujytymd";
    public static final String HASSINKA                 = "hassinka";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String KANJIBOSYUUNINNM         = "kanjibosyuuninnm";
    public static final String KYDATKIKBN               = "kydatkikbn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String HRKP                     = "hrkp";
    public static final String HURIHUNOKBN              = "hurihunokbn";
    public static final String BOSYUUNINGYOUHAIYMD      = "bosyuuningyouhaiymd";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String DNTCD                    = "dntcd";
    public static final String KJDNTNM                  = "kjdntnm";
    public static final String HKNSYURUINM              = "hknsyuruinm";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String HJNKYKHYJ                = "hjnkykhyj";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_DairitenMinyuKykMeisai primaryKey;

    public GenIT_DairitenMinyuKykMeisai() {
        primaryKey = new PKIT_DairitenMinyuKykMeisai();
    }

    public GenIT_DairitenMinyuKykMeisai(
        String pKbnkey,
        BizDate pSyoriYmd,
        String pSyono,
        Integer pDrtenrenno
    ) {
        primaryKey = new PKIT_DairitenMinyuKykMeisai(
            pKbnkey,
            pSyoriYmd,
            pSyono,
            pDrtenrenno
        );
    }

    @Transient
    @Override
    public PKIT_DairitenMinyuKykMeisai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_DairitenMinyuKykMeisai> getMetaClass() {
        return QIT_DairitenMinyuKykMeisai.class;
    }

    @Id
    @Column(name=GenIT_DairitenMinyuKykMeisai.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_DairitenMinyuKykMeisai.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Column(name=GenIT_DairitenMinyuKykMeisai.SYONO)
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
    @Column(name=GenIT_DairitenMinyuKykMeisai.DRTENRENNO)
    public Integer getDrtenrenno() {
        return getPrimaryKey().getDrtenrenno();
    }

    @DataConvert("toSingleByte")
    public void setDrtenrenno(Integer pDrtenrenno) {
        getPrimaryKey().setDrtenrenno(pDrtenrenno);
    }

    private String drtencd;

    @Column(name=GenIT_DairitenMinyuKykMeisai.DRTENCD)
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

    private String bosyuucd;

    @Column(name=GenIT_DairitenMinyuKykMeisai.BOSYUUCD)
    @MaxLength(max=6)
    @AlphaDigit
    public String getBosyuucd() {
        return bosyuucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd(String pBosyuucd) {
        bosyuucd = pBosyuucd;
    }

    private BizDateYM pjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_DairitenMinyuKykMeisai.PJYTYM)
    public BizDateYM getPjytym() {
        return pjytym;
    }

    public void setPjytym(BizDateYM pPjytym) {
        pjytym = pPjytym;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DairitenMinyuKykMeisai.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private String cifcd;

    @Column(name=GenIT_DairitenMinyuKykMeisai.CIFCD)
    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private String kanjidairitennm;

    @Column(name=GenIT_DairitenMinyuKykMeisai.KANJIDAIRITENNM)
    public String getKanjidairitennm() {
        return kanjidairitennm;
    }

    public void setKanjidairitennm(String pKanjidairitennm) {
        kanjidairitennm = pKanjidairitennm;
    }

    private BizDate minyujytymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DairitenMinyuKykMeisai.MINYUJYTYMD)
    public BizDate getMinyujytymd() {
        return minyujytymd;
    }

    public void setMinyujytymd(BizDate pMinyujytymd) {
        minyujytymd = pMinyujytymd;
    }

    private String hassinka;

    @Column(name=GenIT_DairitenMinyuKykMeisai.HASSINKA)
    public String getHassinka() {
        return hassinka;
    }

    public void setHassinka(String pHassinka) {
        hassinka = pHassinka;
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_DairitenMinyuKykMeisai.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private String kanjibosyuuninnm;

    @Column(name=GenIT_DairitenMinyuKykMeisai.KANJIBOSYUUNINNM)
    public String getKanjibosyuuninnm() {
        return kanjibosyuuninnm;
    }

    public void setKanjibosyuuninnm(String pKanjibosyuuninnm) {
        kanjibosyuuninnm = pKanjibosyuuninnm;
    }

    private String kydatkikbn;

    @Column(name=GenIT_DairitenMinyuKykMeisai.KYDATKIKBN)
    public String getKydatkikbn() {
        return kydatkikbn;
    }

    public void setKydatkikbn(String pKydatkikbn) {
        kydatkikbn = pKydatkikbn;
    }

    private String kyknmkj;

    @Column(name=GenIT_DairitenMinyuKykMeisai.KYKNMKJ)
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

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_DairitenMinyuKykMeisai.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_DairitenMinyuKykMeisai.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
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

    private C_HurihunoKbn hurihunokbn;

    @Type(type="UserType_C_HurihunoKbn")
    @Column(name=GenIT_DairitenMinyuKykMeisai.HURIHUNOKBN)
    public C_HurihunoKbn getHurihunokbn() {
        return hurihunokbn;
    }

    public void setHurihunokbn(C_HurihunoKbn pHurihunokbn) {
        hurihunokbn = pHurihunokbn;
    }

    private BizDate bosyuuningyouhaiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DairitenMinyuKykMeisai.BOSYUUNINGYOUHAIYMD)
    public BizDate getBosyuuningyouhaiymd() {
        return bosyuuningyouhaiymd;
    }

    public void setBosyuuningyouhaiymd(BizDate pBosyuuningyouhaiymd) {
        bosyuuningyouhaiymd = pBosyuuningyouhaiymd;
    }

    private String bankcd;

    @Column(name=GenIT_DairitenMinyuKykMeisai.BANKCD)
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

    @Column(name=GenIT_DairitenMinyuKykMeisai.SITENCD)
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
    @Column(name=GenIT_DairitenMinyuKykMeisai.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_DairitenMinyuKykMeisai.KOUZANO)
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

    private String dntcd;

    @Column(name=GenIT_DairitenMinyuKykMeisai.DNTCD)
    @MaxLength(max=8)
    @AlphaDigit
    public String getDntcd() {
        return dntcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDntcd(String pDntcd) {
        dntcd = pDntcd;
    }

    private String kjdntnm;

    @Column(name=GenIT_DairitenMinyuKykMeisai.KJDNTNM)
    public String getKjdntnm() {
        return kjdntnm;
    }

    public void setKjdntnm(String pKjdntnm) {
        kjdntnm = pKjdntnm;
    }

    private String hknsyuruinm;

    @Column(name=GenIT_DairitenMinyuKykMeisai.HKNSYURUINM)
    public String getHknsyuruinm() {
        return hknsyuruinm;
    }

    public void setHknsyuruinm(String pHknsyuruinm) {
        hknsyuruinm = pHknsyuruinm;
    }

    private String drtenkanrisosikicd;

    @Column(name=GenIT_DairitenMinyuKykMeisai.DRTENKANRISOSIKICD)
    @HostInvalidCharacter
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private String hjnkykhyj;

    @Column(name=GenIT_DairitenMinyuKykMeisai.HJNKYKHYJ)
    public String getHjnkykhyj() {
        return hjnkykhyj;
    }

    public void setHjnkykhyj(String pHjnkykhyj) {
        hjnkykhyj = pHjnkykhyj;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_DairitenMinyuKykMeisai.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_DairitenMinyuKykMeisai.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_DairitenMinyuKykMeisai.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}