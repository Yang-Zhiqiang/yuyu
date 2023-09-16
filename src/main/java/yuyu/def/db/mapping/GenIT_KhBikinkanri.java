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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_BknsyutkKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.id.PKIT_KhBikinkanri;
import yuyu.def.db.meta.GenQIT_KhBikinkanri;
import yuyu.def.db.meta.QIT_KhBikinkanri;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_BknrigiKbn;
import yuyu.def.db.type.UserType_C_BknsyutkKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全備金管理テーブル テーブルのマッピング情報クラスで、 {@link IT_KhBikinkanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhBikinkanri}</td><td colspan="3">契約保全備金管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhBikinkanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKessankijyunymd kessankijyunymd}</td><td>決算基準日</td><td align="center">{@link PKIT_KhBikinkanri ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBkncdkbn bkncdkbn}</td><td>備金コード区分</td><td align="center">{@link PKIT_KhBikinkanri ○}</td><td align="center">V</td><td>{@link C_BkncdKbn}</td></tr>
 *  <tr><td>{@link #getBknkktymd bknkktymd}</td><td>備金確定日</td><td align="center">{@link PKIT_KhBikinkanri ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_KhBikinkanri ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getBknrigikbn bknrigikbn}</td><td>備金例外区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknrigiKbn}</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCalckijyunymd calckijyunymd}</td><td>計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSisyacd sisyacd}</td><td>支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBknsyutkkbn bknsyutkkbn}</td><td>備金主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknsyutkKbn}</td></tr>
 *  <tr><td>{@link #getBkngk bkngk}</td><td>備金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons kihons}</td><td>基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGngkkiykumukbn gngkkiykumukbn}</td><td>減額特約解約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getShrumu shrumu}</td><td>支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSinsaumukbn sinsaumukbn}</td><td>診査有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getBknjkukbn bknjkukbn}</td><td>備金時効区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknJkuKbn}</td></tr>
 *  <tr><td>{@link #getShrsyoriymd shrsyoriymd}</td><td>支払処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTyakkinymd tyakkinymd}</td><td>着金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrgk shrgk}</td><td>支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrkwsratekjnymd shrkwsratekjnymd}</td><td>支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrkwsrate shrkwsrate}</td><td>支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGaikashrkwsratekjnymd gaikashrkwsratekjnymd}</td><td>外貨支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGaikashrkwsrate gaikashrkwsrate}</td><td>外貨支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenkazennouseisankgk yenkazennouseisankgk}</td><td>円貨前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGaikazennouseisankgk gaikazennouseisankgk}</td><td>外貨前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennouseisankgk zennouseisankgk}</td><td>前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkamikeikap yenkamikeikap}</td><td>円貨未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGaikamikeikap gaikamikeikap}</td><td>外貨未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMikeikap mikeikap}</td><td>未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_KhBikinkanri
 * @see     PKIT_KhBikinkanri
 * @see     QIT_KhBikinkanri
 * @see     GenQIT_KhBikinkanri
 */
@MappedSuperclass
@Table(name=GenIT_KhBikinkanri.TABLE_NAME)
@IdClass(value=PKIT_KhBikinkanri.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_BknJkuKbn", typeClass=UserType_C_BknJkuKbn.class),
    @TypeDef(name="UserType_C_BkncdKbn", typeClass=UserType_C_BkncdKbn.class),
    @TypeDef(name="UserType_C_BknrigiKbn", typeClass=UserType_C_BknrigiKbn.class),
    @TypeDef(name="UserType_C_BknsyutkKbn", typeClass=UserType_C_BknsyutkKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_KhBikinkanri extends AbstractExDBEntity<IT_KhBikinkanri, PKIT_KhBikinkanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhBikinkanri";
    public static final String SYONO                    = "syono";
    public static final String KESSANKIJYUNYMD          = "kessankijyunymd";
    public static final String BKNCDKBN                 = "bkncdkbn";
    public static final String BKNKKTYMD                = "bknkktymd";
    public static final String RENNO                    = "renno";
    public static final String BKNRIGIKBN               = "bknrigikbn";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String CALCKIJYUNYMD            = "calckijyunymd";
    public static final String SISYACD                  = "sisyacd";
    public static final String KBNKEIRISEGCD            = "kbnkeirisegcd";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String BKNSYUTKKBN              = "bknsyutkkbn";
    public static final String BKNGK                    = "bkngk";
    public static final String KIHONS                   = "kihons";
    public static final String GNGKKIYKUMUKBN           = "gngkkiykumukbn";
    public static final String SHRUMU                   = "shrumu";
    public static final String SINSAUMUKBN              = "sinsaumukbn";
    public static final String BKNJKUKBN                = "bknjkukbn";
    public static final String SHRSYORIYMD              = "shrsyoriymd";
    public static final String TYAKKINYMD               = "tyakkinymd";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRGK                    = "shrgk";
    public static final String SHRKWSRATEKJNYMD         = "shrkwsratekjnymd";
    public static final String SHRKWSRATE               = "shrkwsrate";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String GAIKASHRKWSRATEKJNYMD    = "gaikashrkwsratekjnymd";
    public static final String GAIKASHRKWSRATE          = "gaikashrkwsrate";
    public static final String YENKAZENNOUSEISANKGK     = "yenkazennouseisankgk";
    public static final String GAIKAZENNOUSEISANKGK     = "gaikazennouseisankgk";
    public static final String ZENNOUSEISANKGK          = "zennouseisankgk";
    public static final String YENKAMIKEIKAP            = "yenkamikeikap";
    public static final String GAIKAMIKEIKAP            = "gaikamikeikap";
    public static final String MIKEIKAP                 = "mikeikap";

    private final PKIT_KhBikinkanri primaryKey;

    public GenIT_KhBikinkanri() {
        primaryKey = new PKIT_KhBikinkanri();
    }

    public GenIT_KhBikinkanri(
        String pSyono,
        BizDate pKessankijyunymd,
        C_BkncdKbn pBkncdkbn,
        BizDate pBknkktymd,
        Integer pRenno
    ) {
        primaryKey = new PKIT_KhBikinkanri(
            pSyono,
            pKessankijyunymd,
            pBkncdkbn,
            pBknkktymd,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_KhBikinkanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhBikinkanri> getMetaClass() {
        return QIT_KhBikinkanri.class;
    }

    @Id
    @Column(name=GenIT_KhBikinkanri.SYONO)
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
    @Column(name=GenIT_KhBikinkanri.KESSANKIJYUNYMD)
    @ValidDate
    public BizDate getKessankijyunymd() {
        return getPrimaryKey().getKessankijyunymd();
    }

    @Trim("both")
    public void setKessankijyunymd(BizDate pKessankijyunymd) {
        getPrimaryKey().setKessankijyunymd(pKessankijyunymd);
    }

    @Id
    @Type(type="UserType_C_BkncdKbn")
    @Column(name=GenIT_KhBikinkanri.BKNCDKBN)
    public C_BkncdKbn getBkncdkbn() {
        return getPrimaryKey().getBkncdkbn();
    }

    public void setBkncdkbn(C_BkncdKbn pBkncdkbn) {
        getPrimaryKey().setBkncdkbn(pBkncdkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_KhBikinkanri.BKNKKTYMD)
    @ValidDate
    public BizDate getBknkktymd() {
        return getPrimaryKey().getBknkktymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBknkktymd(BizDate pBknkktymd) {
        getPrimaryKey().setBknkktymd(pBknkktymd);
    }

    @Id
    @Column(name=GenIT_KhBikinkanri.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_BknrigiKbn bknrigikbn;

    @Type(type="UserType_C_BknrigiKbn")
    @Column(name=GenIT_KhBikinkanri.BKNRIGIKBN)
    public C_BknrigiKbn getBknrigikbn() {
        return bknrigikbn;
    }

    public void setBknrigikbn(C_BknrigiKbn pBknrigikbn) {
        bknrigikbn = pBknrigikbn;
    }

    private String henkousikibetukey;

    @Column(name=GenIT_KhBikinkanri.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private BizDate calckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhBikinkanri.CALCKIJYUNYMD)
    @ValidDate
    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        calckijyunymd = pCalckijyunymd;
    }

    private String sisyacd;

    @Column(name=GenIT_KhBikinkanri.SISYACD)
    @Length(length=3)
    @SingleByteStrings
    public String getSisyacd() {
        return sisyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSisyacd(String pSisyacd) {
        sisyacd = pSisyacd;
    }

    private C_Segcd kbnkeirisegcd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenIT_KhBikinkanri.KBNKEIRISEGCD)
    public C_Segcd getKbnkeirisegcd() {
        return kbnkeirisegcd;
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        kbnkeirisegcd = pKbnkeirisegcd;
    }

    private String syouhncd;

    @Column(name=GenIT_KhBikinkanri.SYOUHNCD)
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

    private C_BknsyutkKbn bknsyutkkbn;

    @Type(type="UserType_C_BknsyutkKbn")
    @Column(name=GenIT_KhBikinkanri.BKNSYUTKKBN)
    public C_BknsyutkKbn getBknsyutkkbn() {
        return bknsyutkkbn;
    }

    public void setBknsyutkkbn(C_BknsyutkKbn pBknsyutkkbn) {
        bknsyutkkbn = pBknsyutkkbn;
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

    private C_UmuKbn gngkkiykumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KhBikinkanri.GNGKKIYKUMUKBN)
    public C_UmuKbn getGngkkiykumukbn() {
        return gngkkiykumukbn;
    }

    public void setGngkkiykumukbn(C_UmuKbn pGngkkiykumukbn) {
        gngkkiykumukbn = pGngkkiykumukbn;
    }

    private C_UmuKbn shrumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KhBikinkanri.SHRUMU)
    public C_UmuKbn getShrumu() {
        return shrumu;
    }

    public void setShrumu(C_UmuKbn pShrumu) {
        shrumu = pShrumu;
    }

    private C_UmuKbn sinsaumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KhBikinkanri.SINSAUMUKBN)
    public C_UmuKbn getSinsaumukbn() {
        return sinsaumukbn;
    }

    public void setSinsaumukbn(C_UmuKbn pSinsaumukbn) {
        sinsaumukbn = pSinsaumukbn;
    }

    private C_BknJkuKbn bknjkukbn;

    @Type(type="UserType_C_BknJkuKbn")
    @Column(name=GenIT_KhBikinkanri.BKNJKUKBN)
    public C_BknJkuKbn getBknjkukbn() {
        return bknjkukbn;
    }

    public void setBknjkukbn(C_BknJkuKbn pBknjkukbn) {
        bknjkukbn = pBknjkukbn;
    }

    private BizDate shrsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhBikinkanri.SHRSYORIYMD)
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
    @Column(name=GenIT_KhBikinkanri.TYAKKINYMD)
    @ValidDate
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_KhBikinkanri.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_KhBikinkanri.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizCurrency shrgk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getShrgk() {
        return shrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrgk(BizCurrency pShrgk) {
        shrgk = pShrgk;
        shrgkValue = null;
        shrgkType  = null;
    }

    transient private BigDecimal shrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRGK, nullable=true)
    protected BigDecimal getShrgkValue() {
        if (shrgkValue == null && shrgk != null) {
            if (shrgk.isOptional()) return null;
            return shrgk.absolute();
        }
        return shrgkValue;
    }

    protected void setShrgkValue(BigDecimal value) {
        shrgkValue = value;
        shrgk = Optional.fromNullable(toCurrencyType(shrgkType))
            .transform(bizCurrencyTransformer(getShrgkValue()))
            .orNull();
    }

    transient private String shrgkType = null;

    @Column(name=SHRGK + "$", nullable=true)
    protected String getShrgkType() {
        if (shrgkType == null && shrgk != null) return shrgk.getType().toString();
        if (shrgkType == null && getShrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrgk$' should not be NULL."));
        }
        return shrgkType;
    }

    protected void setShrgkType(String type) {
        shrgkType = type;
        shrgk = Optional.fromNullable(toCurrencyType(shrgkType))
            .transform(bizCurrencyTransformer(getShrgkValue()))
            .orNull();
    }

    private BizDate shrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhBikinkanri.SHRKWSRATEKJNYMD)
    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    private BizNumber shrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KhBikinkanri.SHRKWSRATE)
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhBikinkanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhBikinkanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhBikinkanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizDate gaikashrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhBikinkanri.GAIKASHRKWSRATEKJNYMD)
    public BizDate getGaikashrkwsratekjnymd() {
        return gaikashrkwsratekjnymd;
    }

    public void setGaikashrkwsratekjnymd(BizDate pGaikashrkwsratekjnymd) {
        gaikashrkwsratekjnymd = pGaikashrkwsratekjnymd;
    }

    private BizNumber gaikashrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KhBikinkanri.GAIKASHRKWSRATE)
    public BizNumber getGaikashrkwsrate() {
        return gaikashrkwsrate;
    }

    public void setGaikashrkwsrate(BizNumber pGaikashrkwsrate) {
        gaikashrkwsrate = pGaikashrkwsrate;
    }

    private BizCurrency yenkazennouseisankgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkazennouseisankgk() {
        return yenkazennouseisankgk;
    }

    public void setYenkazennouseisankgk(BizCurrency pYenkazennouseisankgk) {
        yenkazennouseisankgk = pYenkazennouseisankgk;
        yenkazennouseisankgkValue = null;
        yenkazennouseisankgkType  = null;
    }

    transient private BigDecimal yenkazennouseisankgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAZENNOUSEISANKGK, nullable=true)
    protected BigDecimal getYenkazennouseisankgkValue() {
        if (yenkazennouseisankgkValue == null && yenkazennouseisankgk != null) {
            if (yenkazennouseisankgk.isOptional()) return null;
            return yenkazennouseisankgk.absolute();
        }
        return yenkazennouseisankgkValue;
    }

    protected void setYenkazennouseisankgkValue(BigDecimal value) {
        yenkazennouseisankgkValue = value;
        yenkazennouseisankgk = Optional.fromNullable(toCurrencyType(yenkazennouseisankgkType))
            .transform(bizCurrencyTransformer(getYenkazennouseisankgkValue()))
            .orNull();
    }

    transient private String yenkazennouseisankgkType = null;

    @Column(name=YENKAZENNOUSEISANKGK + "$", nullable=true)
    protected String getYenkazennouseisankgkType() {
        if (yenkazennouseisankgkType == null && yenkazennouseisankgk != null) return yenkazennouseisankgk.getType().toString();
        if (yenkazennouseisankgkType == null && getYenkazennouseisankgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkazennouseisankgk$' should not be NULL."));
        }
        return yenkazennouseisankgkType;
    }

    protected void setYenkazennouseisankgkType(String type) {
        yenkazennouseisankgkType = type;
        yenkazennouseisankgk = Optional.fromNullable(toCurrencyType(yenkazennouseisankgkType))
            .transform(bizCurrencyTransformer(getYenkazennouseisankgkValue()))
            .orNull();
    }

    private BizCurrency gaikazennouseisankgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikazennouseisankgk() {
        return gaikazennouseisankgk;
    }

    public void setGaikazennouseisankgk(BizCurrency pGaikazennouseisankgk) {
        gaikazennouseisankgk = pGaikazennouseisankgk;
        gaikazennouseisankgkValue = null;
        gaikazennouseisankgkType  = null;
    }

    transient private BigDecimal gaikazennouseisankgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKAZENNOUSEISANKGK, nullable=true)
    protected BigDecimal getGaikazennouseisankgkValue() {
        if (gaikazennouseisankgkValue == null && gaikazennouseisankgk != null) {
            if (gaikazennouseisankgk.isOptional()) return null;
            return gaikazennouseisankgk.absolute();
        }
        return gaikazennouseisankgkValue;
    }

    protected void setGaikazennouseisankgkValue(BigDecimal value) {
        gaikazennouseisankgkValue = value;
        gaikazennouseisankgk = Optional.fromNullable(toCurrencyType(gaikazennouseisankgkType))
            .transform(bizCurrencyTransformer(getGaikazennouseisankgkValue()))
            .orNull();
    }

    transient private String gaikazennouseisankgkType = null;

    @Column(name=GAIKAZENNOUSEISANKGK + "$", nullable=true)
    protected String getGaikazennouseisankgkType() {
        if (gaikazennouseisankgkType == null && gaikazennouseisankgk != null) return gaikazennouseisankgk.getType().toString();
        if (gaikazennouseisankgkType == null && getGaikazennouseisankgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikazennouseisankgk$' should not be NULL."));
        }
        return gaikazennouseisankgkType;
    }

    protected void setGaikazennouseisankgkType(String type) {
        gaikazennouseisankgkType = type;
        gaikazennouseisankgk = Optional.fromNullable(toCurrencyType(gaikazennouseisankgkType))
            .transform(bizCurrencyTransformer(getGaikazennouseisankgkValue()))
            .orNull();
    }

    private BizCurrency zennouseisankgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    public void setZennouseisankgk(BizCurrency pZennouseisankgk) {
        zennouseisankgk = pZennouseisankgk;
        zennouseisankgkValue = null;
        zennouseisankgkType  = null;
    }

    transient private BigDecimal zennouseisankgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUSEISANKGK, nullable=true)
    protected BigDecimal getZennouseisankgkValue() {
        if (zennouseisankgkValue == null && zennouseisankgk != null) {
            if (zennouseisankgk.isOptional()) return null;
            return zennouseisankgk.absolute();
        }
        return zennouseisankgkValue;
    }

    protected void setZennouseisankgkValue(BigDecimal value) {
        zennouseisankgkValue = value;
        zennouseisankgk = Optional.fromNullable(toCurrencyType(zennouseisankgkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkValue()))
            .orNull();
    }

    transient private String zennouseisankgkType = null;

    @Column(name=ZENNOUSEISANKGK + "$", nullable=true)
    protected String getZennouseisankgkType() {
        if (zennouseisankgkType == null && zennouseisankgk != null) return zennouseisankgk.getType().toString();
        if (zennouseisankgkType == null && getZennouseisankgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennouseisankgk$' should not be NULL."));
        }
        return zennouseisankgkType;
    }

    protected void setZennouseisankgkType(String type) {
        zennouseisankgkType = type;
        zennouseisankgk = Optional.fromNullable(toCurrencyType(zennouseisankgkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkValue()))
            .orNull();
    }

    private BizCurrency yenkamikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkamikeikap() {
        return yenkamikeikap;
    }

    public void setYenkamikeikap(BizCurrency pYenkamikeikap) {
        yenkamikeikap = pYenkamikeikap;
        yenkamikeikapValue = null;
        yenkamikeikapType  = null;
    }

    transient private BigDecimal yenkamikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAMIKEIKAP, nullable=true)
    protected BigDecimal getYenkamikeikapValue() {
        if (yenkamikeikapValue == null && yenkamikeikap != null) {
            if (yenkamikeikap.isOptional()) return null;
            return yenkamikeikap.absolute();
        }
        return yenkamikeikapValue;
    }

    protected void setYenkamikeikapValue(BigDecimal value) {
        yenkamikeikapValue = value;
        yenkamikeikap = Optional.fromNullable(toCurrencyType(yenkamikeikapType))
            .transform(bizCurrencyTransformer(getYenkamikeikapValue()))
            .orNull();
    }

    transient private String yenkamikeikapType = null;

    @Column(name=YENKAMIKEIKAP + "$", nullable=true)
    protected String getYenkamikeikapType() {
        if (yenkamikeikapType == null && yenkamikeikap != null) return yenkamikeikap.getType().toString();
        if (yenkamikeikapType == null && getYenkamikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkamikeikap$' should not be NULL."));
        }
        return yenkamikeikapType;
    }

    protected void setYenkamikeikapType(String type) {
        yenkamikeikapType = type;
        yenkamikeikap = Optional.fromNullable(toCurrencyType(yenkamikeikapType))
            .transform(bizCurrencyTransformer(getYenkamikeikapValue()))
            .orNull();
    }

    private BizCurrency gaikamikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikamikeikap() {
        return gaikamikeikap;
    }

    public void setGaikamikeikap(BizCurrency pGaikamikeikap) {
        gaikamikeikap = pGaikamikeikap;
        gaikamikeikapValue = null;
        gaikamikeikapType  = null;
    }

    transient private BigDecimal gaikamikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKAMIKEIKAP, nullable=true)
    protected BigDecimal getGaikamikeikapValue() {
        if (gaikamikeikapValue == null && gaikamikeikap != null) {
            if (gaikamikeikap.isOptional()) return null;
            return gaikamikeikap.absolute();
        }
        return gaikamikeikapValue;
    }

    protected void setGaikamikeikapValue(BigDecimal value) {
        gaikamikeikapValue = value;
        gaikamikeikap = Optional.fromNullable(toCurrencyType(gaikamikeikapType))
            .transform(bizCurrencyTransformer(getGaikamikeikapValue()))
            .orNull();
    }

    transient private String gaikamikeikapType = null;

    @Column(name=GAIKAMIKEIKAP + "$", nullable=true)
    protected String getGaikamikeikapType() {
        if (gaikamikeikapType == null && gaikamikeikap != null) return gaikamikeikap.getType().toString();
        if (gaikamikeikapType == null && getGaikamikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikamikeikap$' should not be NULL."));
        }
        return gaikamikeikapType;
    }

    protected void setGaikamikeikapType(String type) {
        gaikamikeikapType = type;
        gaikamikeikap = Optional.fromNullable(toCurrencyType(gaikamikeikapType))
            .transform(bizCurrencyTransformer(getGaikamikeikapValue()))
            .orNull();
    }

    private BizCurrency mikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
        mikeikapValue = null;
        mikeikapType  = null;
    }

    transient private BigDecimal mikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MIKEIKAP, nullable=true)
    protected BigDecimal getMikeikapValue() {
        if (mikeikapValue == null && mikeikap != null) {
            if (mikeikap.isOptional()) return null;
            return mikeikap.absolute();
        }
        return mikeikapValue;
    }

    protected void setMikeikapValue(BigDecimal value) {
        mikeikapValue = value;
        mikeikap = Optional.fromNullable(toCurrencyType(mikeikapType))
            .transform(bizCurrencyTransformer(getMikeikapValue()))
            .orNull();
    }

    transient private String mikeikapType = null;

    @Column(name=MIKEIKAP + "$", nullable=true)
    protected String getMikeikapType() {
        if (mikeikapType == null && mikeikap != null) return mikeikap.getType().toString();
        if (mikeikapType == null && getMikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mikeikap$' should not be NULL."));
        }
        return mikeikapType;
    }

    protected void setMikeikapType(String type) {
        mikeikapType = type;
        mikeikap = Optional.fromNullable(toCurrencyType(mikeikapType))
            .transform(bizCurrencyTransformer(getMikeikapValue()))
            .orNull();
    }
}