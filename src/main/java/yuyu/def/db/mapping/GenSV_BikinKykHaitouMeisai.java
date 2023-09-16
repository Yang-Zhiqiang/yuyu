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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_BikinKykHaitouMeisai;
import yuyu.def.db.id.PKSV_BikinKykHaitouMeisai;
import yuyu.def.db.meta.GenQSV_BikinKykHaitouMeisai;
import yuyu.def.db.meta.QSV_BikinKykHaitouMeisai;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_BknrigiKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 備金契約配当明細情報ビュー テーブルのマッピング情報クラスで、 {@link SV_BikinKykHaitouMeisai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_BikinKykHaitouMeisai}</td><td colspan="3">備金契約配当明細情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKSV_BikinKykHaitouMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKessankijyunymd kessankijyunymd}</td><td>決算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBkncdkbn bkncdkbn}</td><td>備金コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BkncdKbn}</td></tr>
 *  <tr><td>{@link #getBknkktymd bknkktymd}</td><td>備金確定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBknrigikbn bknrigikbn}</td><td>備金例外区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknrigiKbn}</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCalckijyunymd calckijyunymd}</td><td>計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getBkngk bkngk}</td><td>備金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons kihons}</td><td>基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyoriumukbn syoriumukbn}</td><td>処理有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getBknjkukbn bknjkukbn}</td><td>備金時効区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknJkuKbn}</td></tr>
 *  <tr><td>{@link #getShrsyoriymd shrsyoriymd}</td><td>支払処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTyakkinymd tyakkinymd}</td><td>着金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrkwsratekjnymd shrkwsratekjnymd}</td><td>支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrkwsrate shrkwsrate}</td><td>支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSitihsyutkyumaeyenhknkngk sitihsyutkyumaeyenhknkngk}</td><td>最低保証適用前円換算保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrkekkakbn shrkekkakbn}</td><td>支払結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrKekkaKbn}</td></tr>
 *  <tr><td>{@link #getSiinkbn siinkbn}</td><td>死因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SiinKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">{@link PKSV_BikinKykHaitouMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">{@link PKSV_BikinKykHaitouMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 * </table>
 * @see     SV_BikinKykHaitouMeisai
 * @see     PKSV_BikinKykHaitouMeisai
 * @see     QSV_BikinKykHaitouMeisai
 * @see     GenQSV_BikinKykHaitouMeisai
 */
@MappedSuperclass
@Table(name=GenSV_BikinKykHaitouMeisai.TABLE_NAME)
@IdClass(value=PKSV_BikinKykHaitouMeisai.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_BknJkuKbn", typeClass=UserType_C_BknJkuKbn.class),
    @TypeDef(name="UserType_C_BkncdKbn", typeClass=UserType_C_BkncdKbn.class),
    @TypeDef(name="UserType_C_BknrigiKbn", typeClass=UserType_C_BknrigiKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_ShrKekkaKbn", typeClass=UserType_C_ShrKekkaKbn.class),
    @TypeDef(name="UserType_C_SiinKbn", typeClass=UserType_C_SiinKbn.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenSV_BikinKykHaitouMeisai extends AbstractExDBEntity<SV_BikinKykHaitouMeisai, PKSV_BikinKykHaitouMeisai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_BikinKykHaitouMeisai";
    public static final String SYONO                    = "syono";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String KESSANKIJYUNYMD          = "kessankijyunymd";
    public static final String BKNCDKBN                 = "bkncdkbn";
    public static final String BKNKKTYMD                = "bknkktymd";
    public static final String RENNO                    = "renno";
    public static final String KYUUHUCD                 = "kyuuhucd";
    public static final String BKNRIGIKBN               = "bknrigikbn";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SKNO                     = "skno";
    public static final String CALCKIJYUNYMD            = "calckijyunymd";
    public static final String KBNKEIRISEGCD            = "kbnkeirisegcd";
    public static final String BKNGK                    = "bkngk";
    public static final String KIHONS                   = "kihons";
    public static final String SYORIUMUKBN              = "syoriumukbn";
    public static final String BKNJKUKBN                = "bknjkukbn";
    public static final String SHRSYORIYMD              = "shrsyoriymd";
    public static final String TYAKKINYMD               = "tyakkinymd";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRKWSRATEKJNYMD         = "shrkwsratekjnymd";
    public static final String SHRKWSRATE               = "shrkwsrate";
    public static final String SITIHSYUTKYUMAEYENHKNKNGK = "sitihsyutkyumaeyenhknkngk";
    public static final String SHRKEKKAKBN              = "shrkekkakbn";
    public static final String SIINKBN                  = "siinkbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String JKIPJYTYM                = "jkipjytym";

    private final PKSV_BikinKykHaitouMeisai primaryKey;

    public GenSV_BikinKykHaitouMeisai() {
        primaryKey = new PKSV_BikinKykHaitouMeisai();
    }

    public GenSV_BikinKykHaitouMeisai(
        String pSyono,
        String pGyoumuKousinKinou,
        String pGyoumuKousinTime
    ) {
        primaryKey = new PKSV_BikinKykHaitouMeisai(
            pSyono,
            pGyoumuKousinKinou,
            pGyoumuKousinTime
        );
    }

    @Transient
    @Override
    public PKSV_BikinKykHaitouMeisai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_BikinKykHaitouMeisai> getMetaClass() {
        return QSV_BikinKykHaitouMeisai.class;
    }

    @Id
    @Column(name=GenSV_BikinKykHaitouMeisai.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenSV_BikinKykHaitouMeisai.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenSV_BikinKykHaitouMeisai.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenSV_BikinKykHaitouMeisai.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private BizDate kessankijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinKykHaitouMeisai.KESSANKIJYUNYMD)
    @ValidDate
    public BizDate getKessankijyunymd() {
        return kessankijyunymd;
    }

    @Trim("both")
    public void setKessankijyunymd(BizDate pKessankijyunymd) {
        kessankijyunymd = pKessankijyunymd;
    }

    private C_BkncdKbn bkncdkbn;

    @Type(type="UserType_C_BkncdKbn")
    @Column(name=GenSV_BikinKykHaitouMeisai.BKNCDKBN)
    public C_BkncdKbn getBkncdkbn() {
        return bkncdkbn;
    }

    public void setBkncdkbn(C_BkncdKbn pBkncdkbn) {
        bkncdkbn = pBkncdkbn;
    }

    private BizDate bknkktymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinKykHaitouMeisai.BKNKKTYMD)
    @ValidDate
    public BizDate getBknkktymd() {
        return bknkktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBknkktymd(BizDate pBknkktymd) {
        bknkktymd = pBknkktymd;
    }

    private Integer renno;

    @Column(name=GenSV_BikinKykHaitouMeisai.RENNO)
    public Integer getRenno() {
        return renno;
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    private String kyuuhucd;

    @Column(name=GenSV_BikinKykHaitouMeisai.KYUUHUCD)
    public String getKyuuhucd() {
        return kyuuhucd;
    }

    public void setKyuuhucd(String pKyuuhucd) {
        kyuuhucd = pKyuuhucd;
    }

    private C_BknrigiKbn bknrigikbn;

    @Type(type="UserType_C_BknrigiKbn")
    @Column(name=GenSV_BikinKykHaitouMeisai.BKNRIGIKBN)
    public C_BknrigiKbn getBknrigikbn() {
        return bknrigikbn;
    }

    public void setBknrigikbn(C_BknrigiKbn pBknrigikbn) {
        bknrigikbn = pBknrigikbn;
    }

    private String henkousikibetukey;

    @Column(name=GenSV_BikinKykHaitouMeisai.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private String skno;

    @Column(name=GenSV_BikinKykHaitouMeisai.SKNO)
    public String getSkno() {
        return skno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    private BizDate calckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinKykHaitouMeisai.CALCKIJYUNYMD)
    @ValidDate
    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        calckijyunymd = pCalckijyunymd;
    }

    private C_Segcd kbnkeirisegcd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenSV_BikinKykHaitouMeisai.KBNKEIRISEGCD)
    public C_Segcd getKbnkeirisegcd() {
        return kbnkeirisegcd;
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        kbnkeirisegcd = pKbnkeirisegcd;
    }

    private BizCurrency bkngk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getBkngk() {
        return bkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBkngk(BizCurrency pBkngk) {
        bkngk = pBkngk;
        bkngkValue = null;
        bkngkType  = null;
    }

    transient private BigDecimal bkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=BKNGK, nullable=true)
    protected BigDecimal getBkngkValue() {
        if (bkngkValue == null && bkngk != null) {
            if (bkngk.isOptional()) return null;
            return bkngk.absolute();
        }
        return bkngkValue;
    }

    protected void setBkngkValue(BigDecimal value) {
        bkngkValue = value;
        bkngk = Optional.fromNullable(toCurrencyType(bkngkType))
            .transform(bizCurrencyTransformer(getBkngkValue()))
            .orNull();
    }

    transient private String bkngkType = null;

    @Column(name=BKNGK + "$", nullable=true)
    protected String getBkngkType() {
        if (bkngkType == null && bkngk != null) return bkngk.getType().toString();
        if (bkngkType == null && getBkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'bkngk$' should not be NULL."));
        }
        return bkngkType;
    }

    protected void setBkngkType(String type) {
        bkngkType = type;
        bkngk = Optional.fromNullable(toCurrencyType(bkngkType))
            .transform(bizCurrencyTransformer(getBkngkValue()))
            .orNull();
    }

    private BizCurrency kihons;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getKihons() {
        return kihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons(BizCurrency pKihons) {
        kihons = pKihons;
        kihonsValue = null;
        kihonsType  = null;
    }

    transient private BigDecimal kihonsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS, nullable=true)
    protected BigDecimal getKihonsValue() {
        if (kihonsValue == null && kihons != null) {
            if (kihons.isOptional()) return null;
            return kihons.absolute();
        }
        return kihonsValue;
    }

    protected void setKihonsValue(BigDecimal value) {
        kihonsValue = value;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    transient private String kihonsType = null;

    @Column(name=KIHONS + "$", nullable=true)
    protected String getKihonsType() {
        if (kihonsType == null && kihons != null) return kihons.getType().toString();
        if (kihonsType == null && getKihonsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons$' should not be NULL."));
        }
        return kihonsType;
    }

    protected void setKihonsType(String type) {
        kihonsType = type;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    private C_UmuKbn syoriumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_BikinKykHaitouMeisai.SYORIUMUKBN)
    public C_UmuKbn getSyoriumukbn() {
        return syoriumukbn;
    }

    public void setSyoriumukbn(C_UmuKbn pSyoriumukbn) {
        syoriumukbn = pSyoriumukbn;
    }

    private C_BknJkuKbn bknjkukbn;

    @Type(type="UserType_C_BknJkuKbn")
    @Column(name=GenSV_BikinKykHaitouMeisai.BKNJKUKBN)
    public C_BknJkuKbn getBknjkukbn() {
        return bknjkukbn;
    }

    public void setBknjkukbn(C_BknJkuKbn pBknjkukbn) {
        bknjkukbn = pBknjkukbn;
    }

    private BizDate shrsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinKykHaitouMeisai.SHRSYORIYMD)
    @ValidDate
    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrsyoriymd(BizDate pShrsyoriymd) {
        shrsyoriymd = pShrsyoriymd;
    }

    private BizDate tyakkinymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinKykHaitouMeisai.TYAKKINYMD)
    @ValidDate
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenSV_BikinKykHaitouMeisai.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizDate shrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_BikinKykHaitouMeisai.SHRKWSRATEKJNYMD)
    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    private BizNumber shrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenSV_BikinKykHaitouMeisai.SHRKWSRATE)
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private BizCurrency sitihsyutkyumaeyenhknkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSitihsyutkyumaeyenhknkngk() {
        return sitihsyutkyumaeyenhknkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitihsyutkyumaeyenhknkngk(BizCurrency pSitihsyutkyumaeyenhknkngk) {
        sitihsyutkyumaeyenhknkngk = pSitihsyutkyumaeyenhknkngk;
        sitihsyutkyumaeyenhknkngkValue = null;
        sitihsyutkyumaeyenhknkngkType  = null;
    }

    transient private BigDecimal sitihsyutkyumaeyenhknkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SITIHSYUTKYUMAEYENHKNKNGK, nullable=true)
    protected BigDecimal getSitihsyutkyumaeyenhknkngkValue() {
        if (sitihsyutkyumaeyenhknkngkValue == null && sitihsyutkyumaeyenhknkngk != null) {
            if (sitihsyutkyumaeyenhknkngk.isOptional()) return null;
            return sitihsyutkyumaeyenhknkngk.absolute();
        }
        return sitihsyutkyumaeyenhknkngkValue;
    }

    protected void setSitihsyutkyumaeyenhknkngkValue(BigDecimal value) {
        sitihsyutkyumaeyenhknkngkValue = value;
        sitihsyutkyumaeyenhknkngk = Optional.fromNullable(toCurrencyType(sitihsyutkyumaeyenhknkngkType))
            .transform(bizCurrencyTransformer(getSitihsyutkyumaeyenhknkngkValue()))
            .orNull();
    }

    transient private String sitihsyutkyumaeyenhknkngkType = null;

    @Column(name=SITIHSYUTKYUMAEYENHKNKNGK + "$", nullable=true)
    protected String getSitihsyutkyumaeyenhknkngkType() {
        if (sitihsyutkyumaeyenhknkngkType == null && sitihsyutkyumaeyenhknkngk != null) return sitihsyutkyumaeyenhknkngk.getType().toString();
        if (sitihsyutkyumaeyenhknkngkType == null && getSitihsyutkyumaeyenhknkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sitihsyutkyumaeyenhknkngk$' should not be NULL."));
        }
        return sitihsyutkyumaeyenhknkngkType;
    }

    protected void setSitihsyutkyumaeyenhknkngkType(String type) {
        sitihsyutkyumaeyenhknkngkType = type;
        sitihsyutkyumaeyenhknkngk = Optional.fromNullable(toCurrencyType(sitihsyutkyumaeyenhknkngkType))
            .transform(bizCurrencyTransformer(getSitihsyutkyumaeyenhknkngkValue()))
            .orNull();
    }

    private C_ShrKekkaKbn shrkekkakbn;

    @Type(type="UserType_C_ShrKekkaKbn")
    @Column(name=GenSV_BikinKykHaitouMeisai.SHRKEKKAKBN)
    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn pShrkekkakbn) {
        shrkekkakbn = pShrkekkakbn;
    }

    private C_SiinKbn siinkbn;

    @Type(type="UserType_C_SiinKbn")
    @Column(name=GenSV_BikinKykHaitouMeisai.SIINKBN)
    public C_SiinKbn getSiinkbn() {
        return siinkbn;
    }

    public void setSiinkbn(C_SiinKbn pSiinkbn) {
        siinkbn = pSiinkbn;
    }

    @Id
    @Column(name=GenSV_BikinKykHaitouMeisai.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return getPrimaryKey().getGyoumuKousinKinou();
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        getPrimaryKey().setGyoumuKousinKinou(pGyoumuKousinKinou);
    }

    @Id
    @Column(name=GenSV_BikinKykHaitouMeisai.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return getPrimaryKey().getGyoumuKousinTime();
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        getPrimaryKey().setGyoumuKousinTime(pGyoumuKousinTime);
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_BikinKykHaitouMeisai.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }
}