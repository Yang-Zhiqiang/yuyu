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
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_AsBikinkanri;
import yuyu.def.db.id.PKIT_AsBikinkanri;
import yuyu.def.db.meta.GenQIT_AsBikinkanri;
import yuyu.def.db.meta.QIT_AsBikinkanri;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 案内収納備金管理テーブル テーブルのマッピング情報クラスで、 {@link IT_AsBikinkanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_AsBikinkanri}</td><td colspan="3">案内収納備金管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_AsBikinkanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKessankijyunymd kessankijyunymd}</td><td>決算基準日</td><td align="center">{@link PKIT_AsBikinkanri ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBkncdkbn bkncdkbn}</td><td>備金コード区分</td><td align="center">{@link PKIT_AsBikinkanri ○}</td><td align="center">V</td><td>{@link C_BkncdKbn}</td></tr>
 *  <tr><td>{@link #getBknkktymd bknkktymd}</td><td>備金確定日</td><td align="center">{@link PKIT_AsBikinkanri ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_AsBikinkanri ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getCalckijyunymd calckijyunymd}</td><td>計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSisyacd sisyacd}</td><td>支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBkngk bkngk}</td><td>備金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyoriumukbn syoriumukbn}</td><td>処理有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getBknjkukbn bknjkukbn}</td><td>備金時効区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknJkuKbn}</td></tr>
 *  <tr><td>{@link #getKaiyakuhrgaika kaiyakuhrgaika}</td><td>解約返戻金（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKwsratekjymd kwsratekjymd}</td><td>為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKawaserate kawaserate}</td><td>為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_AsBikinkanri
 * @see     PKIT_AsBikinkanri
 * @see     QIT_AsBikinkanri
 * @see     GenQIT_AsBikinkanri
 */
@MappedSuperclass
@Table(name=GenIT_AsBikinkanri.TABLE_NAME)
@IdClass(value=PKIT_AsBikinkanri.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_BknJkuKbn", typeClass=UserType_C_BknJkuKbn.class),
    @TypeDef(name="UserType_C_BkncdKbn", typeClass=UserType_C_BkncdKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_AsBikinkanri extends AbstractExDBEntity<IT_AsBikinkanri, PKIT_AsBikinkanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_AsBikinkanri";
    public static final String SYONO                    = "syono";
    public static final String KESSANKIJYUNYMD          = "kessankijyunymd";
    public static final String BKNCDKBN                 = "bkncdkbn";
    public static final String BKNKKTYMD                = "bknkktymd";
    public static final String RENNO                    = "renno";
    public static final String CALCKIJYUNYMD            = "calckijyunymd";
    public static final String SISYACD                  = "sisyacd";
    public static final String KBNKEIRISEGCD            = "kbnkeirisegcd";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String BKNGK                    = "bkngk";
    public static final String SYORIUMUKBN              = "syoriumukbn";
    public static final String BKNJKUKBN                = "bknjkukbn";
    public static final String KAIYAKUHRGAIKA           = "kaiyakuhrgaika";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String KWSRATEKJYMD             = "kwsratekjymd";
    public static final String KAWASERATE               = "kawaserate";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_AsBikinkanri primaryKey;

    public GenIT_AsBikinkanri() {
        primaryKey = new PKIT_AsBikinkanri();
    }

    public GenIT_AsBikinkanri(
        String pSyono,
        BizDate pKessankijyunymd,
        C_BkncdKbn pBkncdkbn,
        BizDate pBknkktymd,
        Integer pRenno
    ) {
        primaryKey = new PKIT_AsBikinkanri(
            pSyono,
            pKessankijyunymd,
            pBkncdkbn,
            pBknkktymd,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_AsBikinkanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_AsBikinkanri> getMetaClass() {
        return QIT_AsBikinkanri.class;
    }

    @Id
    @Column(name=GenIT_AsBikinkanri.SYONO)
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
    @Column(name=GenIT_AsBikinkanri.KESSANKIJYUNYMD)
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
    @Column(name=GenIT_AsBikinkanri.BKNCDKBN)
    public C_BkncdKbn getBkncdkbn() {
        return getPrimaryKey().getBkncdkbn();
    }

    public void setBkncdkbn(C_BkncdKbn pBkncdkbn) {
        getPrimaryKey().setBkncdkbn(pBkncdkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_AsBikinkanri.BKNKKTYMD)
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
    @Column(name=GenIT_AsBikinkanri.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate calckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AsBikinkanri.CALCKIJYUNYMD)
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

    @Column(name=GenIT_AsBikinkanri.SISYACD)
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
    @Column(name=GenIT_AsBikinkanri.KBNKEIRISEGCD)
    public C_Segcd getKbnkeirisegcd() {
        return kbnkeirisegcd;
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        kbnkeirisegcd = pKbnkeirisegcd;
    }

    private String syouhncd;

    @Column(name=GenIT_AsBikinkanri.SYOUHNCD)
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

    private C_UmuKbn syoriumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_AsBikinkanri.SYORIUMUKBN)
    public C_UmuKbn getSyoriumukbn() {
        return syoriumukbn;
    }

    public void setSyoriumukbn(C_UmuKbn pSyoriumukbn) {
        syoriumukbn = pSyoriumukbn;
    }

    private C_BknJkuKbn bknjkukbn;

    @Type(type="UserType_C_BknJkuKbn")
    @Column(name=GenIT_AsBikinkanri.BKNJKUKBN)
    public C_BknJkuKbn getBknjkukbn() {
        return bknjkukbn;
    }

    public void setBknjkukbn(C_BknJkuKbn pBknjkukbn) {
        bknjkukbn = pBknjkukbn;
    }

    private BizCurrency kaiyakuhrgaika;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhrgaika() {
        return kaiyakuhrgaika;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiyakuhrgaika(BizCurrency pKaiyakuhrgaika) {
        kaiyakuhrgaika = pKaiyakuhrgaika;
        kaiyakuhrgaikaValue = null;
        kaiyakuhrgaikaType  = null;
    }

    transient private BigDecimal kaiyakuhrgaikaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHRGAIKA, nullable=true)
    protected BigDecimal getKaiyakuhrgaikaValue() {
        if (kaiyakuhrgaikaValue == null && kaiyakuhrgaika != null) {
            if (kaiyakuhrgaika.isOptional()) return null;
            return kaiyakuhrgaika.absolute();
        }
        return kaiyakuhrgaikaValue;
    }

    protected void setKaiyakuhrgaikaValue(BigDecimal value) {
        kaiyakuhrgaikaValue = value;
        kaiyakuhrgaika = Optional.fromNullable(toCurrencyType(kaiyakuhrgaikaType))
            .transform(bizCurrencyTransformer(getKaiyakuhrgaikaValue()))
            .orNull();
    }

    transient private String kaiyakuhrgaikaType = null;

    @Column(name=KAIYAKUHRGAIKA + "$", nullable=true)
    protected String getKaiyakuhrgaikaType() {
        if (kaiyakuhrgaikaType == null && kaiyakuhrgaika != null) return kaiyakuhrgaika.getType().toString();
        if (kaiyakuhrgaikaType == null && getKaiyakuhrgaikaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhrgaika$' should not be NULL."));
        }
        return kaiyakuhrgaikaType;
    }

    protected void setKaiyakuhrgaikaType(String type) {
        kaiyakuhrgaikaType = type;
        kaiyakuhrgaika = Optional.fromNullable(toCurrencyType(kaiyakuhrgaikaType))
            .transform(bizCurrencyTransformer(getKaiyakuhrgaikaValue()))
            .orNull();
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_AsBikinkanri.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_AsBikinkanri.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizDate kwsratekjymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_AsBikinkanri.KWSRATEKJYMD)
    public BizDate getKwsratekjymd() {
        return kwsratekjymd;
    }

    public void setKwsratekjymd(BizDate pKwsratekjymd) {
        kwsratekjymd = pKwsratekjymd;
    }

    private BizNumber kawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_AsBikinkanri.KAWASERATE)
    public BizNumber getKawaserate() {
        return kawaserate;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKawaserate(BizNumber pKawaserate) {
        kawaserate = pKawaserate;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_AsBikinkanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_AsBikinkanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_AsBikinkanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}