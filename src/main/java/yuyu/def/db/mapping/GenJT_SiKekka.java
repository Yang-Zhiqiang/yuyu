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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.id.PKJT_SiKekka;
import yuyu.def.db.meta.GenQJT_SiKekka;
import yuyu.def.db.meta.QJT_SiKekka;
import yuyu.def.db.type.UserType_C_HushrGeninKbn;
import yuyu.def.db.type.UserType_C_MisyuumikeikaKbn;
import yuyu.def.db.type.UserType_C_ShiharaikekkadataKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払処理結果テーブル テーブルのマッピング情報クラスで、 {@link JT_SiKekka} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiKekka}</td><td colspan="3">支払処理結果テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getShiharaikekkadatakbn shiharaikekkadatakbn}</td><td>支払結果データ区分</td><td align="center">{@link PKJT_SiKekka ○}</td><td align="center">V</td><td>{@link C_ShiharaikekkadataKbn}</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SiKekka ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKJT_SiKekka ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKJT_SiKekka ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">{@link PKJT_SiKekka ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">{@link PKJT_SiKekka ○}</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getNexthrkym nexthrkym}</td><td>次回払込年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoumetujiyuu syoumetujiyuu}</td><td>消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syoumetujiyuu}</td></tr>
 *  <tr><td>{@link #getGansindankakuteiymd gansindankakuteiymd}</td><td>がん診断確定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKrkgk krkgk}</td><td>仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMisyuumikeikakbn misyuumikeikakbn}</td><td>未収未経過区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MisyuumikeikaKbn}</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSeisanpgoukei seisanpgoukei}</td><td>精算保険料合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHushrgeninkbn hushrgeninkbn}</td><td>不支払原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HushrGeninKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennouseisankgk zennouseisankgk}</td><td>前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennouseisankgkshrtk zennouseisankgkshrtk}</td><td>前納精算金額（支払通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZitkazukarikingksiteituuka zitkazukarikingksiteituuka}</td><td>税適預り金額（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZitkazukarikingkyen zitkazukarikingkyen}</td><td>税適預り金額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrkwsratekjnymd shrkwsratekjnymd}</td><td>支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrkwsrate shrkwsrate}</td><td>支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZeimukwsrate zeimukwsrate}</td><td>税務用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiKekka
 * @see     PKJT_SiKekka
 * @see     QJT_SiKekka
 * @see     GenQJT_SiKekka
 */
@MappedSuperclass
@Table(name=GenJT_SiKekka.TABLE_NAME)
@IdClass(value=PKJT_SiKekka.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HushrGeninKbn", typeClass=UserType_C_HushrGeninKbn.class),
    @TypeDef(name="UserType_C_MisyuumikeikaKbn", typeClass=UserType_C_MisyuumikeikaKbn.class),
    @TypeDef(name="UserType_C_ShiharaikekkadataKbn", typeClass=UserType_C_ShiharaikekkadataKbn.class),
    @TypeDef(name="UserType_C_Syoumetujiyuu", typeClass=UserType_C_Syoumetujiyuu.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenJT_SiKekka extends AbstractExDBEntity<JT_SiKekka, PKJT_SiKekka> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiKekka";
    public static final String SHIHARAIKEKKADATAKBN     = "shiharaikekkadatakbn";
    public static final String SYONO                    = "syono";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKSYOUHNRENNO           = "kyksyouhnrenno";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String NEXTHRKYM                = "nexthrkym";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String SYOUMETUJIYUU            = "syoumetujiyuu";
    public static final String GANSINDANKAKUTEIYMD      = "gansindankakuteiymd";
    public static final String KRKGK                    = "krkgk";
    public static final String DENYMD                   = "denymd";
    public static final String MISYUUMIKEIKAKBN         = "misyuumikeikakbn";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String SEISANPGOUKEI            = "seisanpgoukei";
    public static final String HUSHRGENINKBN            = "hushrgeninkbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String ZENNOUSEISANKGK          = "zennouseisankgk";
    public static final String ZENNOUSEISANKGKSHRTK     = "zennouseisankgkshrtk";
    public static final String ZITKAZUKARIKINGKSITEITUUKA = "zitkazukarikingksiteituuka";
    public static final String ZITKAZUKARIKINGKYEN      = "zitkazukarikingkyen";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRKWSRATEKJNYMD         = "shrkwsratekjnymd";
    public static final String SHRKWSRATE               = "shrkwsrate";
    public static final String ZEIMUKWSRATE             = "zeimukwsrate";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiKekka primaryKey;

    public GenJT_SiKekka() {
        primaryKey = new PKJT_SiKekka();
    }

    public GenJT_SiKekka(
        C_ShiharaikekkadataKbn pShiharaikekkadatakbn,
        String pSyono,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno,
        C_SyutkKbn pSyutkkbn
    ) {
        primaryKey = new PKJT_SiKekka(
            pShiharaikekkadatakbn,
            pSyono,
            pSyouhncd,
            pSyouhnsdno,
            pKyksyouhnrenno,
            pSyutkkbn
        );
    }

    @Transient
    @Override
    public PKJT_SiKekka getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiKekka> getMetaClass() {
        return QJT_SiKekka.class;
    }

    @Id
    @Type(type="UserType_C_ShiharaikekkadataKbn")
    @Column(name=GenJT_SiKekka.SHIHARAIKEKKADATAKBN)
    public C_ShiharaikekkadataKbn getShiharaikekkadatakbn() {
        return getPrimaryKey().getShiharaikekkadatakbn();
    }

    public void setShiharaikekkadatakbn(C_ShiharaikekkadataKbn pShiharaikekkadatakbn) {
        getPrimaryKey().setShiharaikekkadatakbn(pShiharaikekkadatakbn);
    }

    @Id
    @Column(name=GenJT_SiKekka.SYONO)
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
    @Column(name=GenJT_SiKekka.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenJT_SiKekka.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Column(name=GenJT_SiKekka.KYKSYOUHNRENNO)
    public Integer getKyksyouhnrenno() {
        return getPrimaryKey().getKyksyouhnrenno();
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        getPrimaryKey().setKyksyouhnrenno(pKyksyouhnrenno);
    }

    @Id
    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenJT_SiKekka.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return getPrimaryKey().getSyutkkbn();
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        getPrimaryKey().setSyutkkbn(pSyutkkbn);
    }

    private BizDateYM nexthrkym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_SiKekka.NEXTHRKYM)
    public BizDateYM getNexthrkym() {
        return nexthrkym;
    }

    public void setNexthrkym(BizDateYM pNexthrkym) {
        nexthrkym = pNexthrkym;
    }

    private BizDate kouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKekka.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private C_Syoumetujiyuu syoumetujiyuu;

    @Type(type="UserType_C_Syoumetujiyuu")
    @Column(name=GenJT_SiKekka.SYOUMETUJIYUU)
    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    private String gansindankakuteiymd;

    @Column(name=GenJT_SiKekka.GANSINDANKAKUTEIYMD)
    public String getGansindankakuteiymd() {
        return gansindankakuteiymd;
    }

    @DataConvert("toSingleByte")
    public void setGansindankakuteiymd(String pGansindankakuteiymd) {
        gansindankakuteiymd = pGansindankakuteiymd;
    }

    private BizCurrency krkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKrkgk() {
        return krkgk;
    }

    public void setKrkgk(BizCurrency pKrkgk) {
        krkgk = pKrkgk;
        krkgkValue = null;
        krkgkType  = null;
    }

    transient private BigDecimal krkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KRKGK, nullable=true)
    protected BigDecimal getKrkgkValue() {
        if (krkgkValue == null && krkgk != null) {
            if (krkgk.isOptional()) return null;
            return krkgk.absolute();
        }
        return krkgkValue;
    }

    protected void setKrkgkValue(BigDecimal value) {
        krkgkValue = value;
        krkgk = Optional.fromNullable(toCurrencyType(krkgkType))
            .transform(bizCurrencyTransformer(getKrkgkValue()))
            .orNull();
    }

    transient private String krkgkType = null;

    @Column(name=KRKGK + "$", nullable=true)
    protected String getKrkgkType() {
        if (krkgkType == null && krkgk != null) return krkgk.getType().toString();
        if (krkgkType == null && getKrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'krkgk$' should not be NULL."));
        }
        return krkgkType;
    }

    protected void setKrkgkType(String type) {
        krkgkType = type;
        krkgk = Optional.fromNullable(toCurrencyType(krkgkType))
            .transform(bizCurrencyTransformer(getKrkgkValue()))
            .orNull();
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKekka.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private C_MisyuumikeikaKbn misyuumikeikakbn;

    @Type(type="UserType_C_MisyuumikeikaKbn")
    @Column(name=GenJT_SiKekka.MISYUUMIKEIKAKBN)
    public C_MisyuumikeikaKbn getMisyuumikeikakbn() {
        return misyuumikeikakbn;
    }

    public void setMisyuumikeikakbn(C_MisyuumikeikaKbn pMisyuumikeikakbn) {
        misyuumikeikakbn = pMisyuumikeikakbn;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_SiKekka.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenJT_SiKekka.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenJT_SiKekka.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private BizCurrency seisanpgoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeisanpgoukei() {
        return seisanpgoukei;
    }

    public void setSeisanpgoukei(BizCurrency pSeisanpgoukei) {
        seisanpgoukei = pSeisanpgoukei;
        seisanpgoukeiValue = null;
        seisanpgoukeiType  = null;
    }

    transient private BigDecimal seisanpgoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEISANPGOUKEI, nullable=true)
    protected BigDecimal getSeisanpgoukeiValue() {
        if (seisanpgoukeiValue == null && seisanpgoukei != null) {
            if (seisanpgoukei.isOptional()) return null;
            return seisanpgoukei.absolute();
        }
        return seisanpgoukeiValue;
    }

    protected void setSeisanpgoukeiValue(BigDecimal value) {
        seisanpgoukeiValue = value;
        seisanpgoukei = Optional.fromNullable(toCurrencyType(seisanpgoukeiType))
            .transform(bizCurrencyTransformer(getSeisanpgoukeiValue()))
            .orNull();
    }

    transient private String seisanpgoukeiType = null;

    @Column(name=SEISANPGOUKEI + "$", nullable=true)
    protected String getSeisanpgoukeiType() {
        if (seisanpgoukeiType == null && seisanpgoukei != null) return seisanpgoukei.getType().toString();
        if (seisanpgoukeiType == null && getSeisanpgoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seisanpgoukei$' should not be NULL."));
        }
        return seisanpgoukeiType;
    }

    protected void setSeisanpgoukeiType(String type) {
        seisanpgoukeiType = type;
        seisanpgoukei = Optional.fromNullable(toCurrencyType(seisanpgoukeiType))
            .transform(bizCurrencyTransformer(getSeisanpgoukeiValue()))
            .orNull();
    }

    private C_HushrGeninKbn hushrgeninkbn;

    @Type(type="UserType_C_HushrGeninKbn")
    @Column(name=GenJT_SiKekka.HUSHRGENINKBN)
    public C_HushrGeninKbn getHushrgeninkbn() {
        return hushrgeninkbn;
    }

    public void setHushrgeninkbn(C_HushrGeninKbn pHushrgeninkbn) {
        hushrgeninkbn = pHushrgeninkbn;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKekka.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
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

    private BizCurrency zennouseisankgkshrtk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennouseisankgkshrtk() {
        return zennouseisankgkshrtk;
    }

    public void setZennouseisankgkshrtk(BizCurrency pZennouseisankgkshrtk) {
        zennouseisankgkshrtk = pZennouseisankgkshrtk;
        zennouseisankgkshrtkValue = null;
        zennouseisankgkshrtkType  = null;
    }

    transient private BigDecimal zennouseisankgkshrtkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUSEISANKGKSHRTK, nullable=true)
    protected BigDecimal getZennouseisankgkshrtkValue() {
        if (zennouseisankgkshrtkValue == null && zennouseisankgkshrtk != null) {
            if (zennouseisankgkshrtk.isOptional()) return null;
            return zennouseisankgkshrtk.absolute();
        }
        return zennouseisankgkshrtkValue;
    }

    protected void setZennouseisankgkshrtkValue(BigDecimal value) {
        zennouseisankgkshrtkValue = value;
        zennouseisankgkshrtk = Optional.fromNullable(toCurrencyType(zennouseisankgkshrtkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkshrtkValue()))
            .orNull();
    }

    transient private String zennouseisankgkshrtkType = null;

    @Column(name=ZENNOUSEISANKGKSHRTK + "$", nullable=true)
    protected String getZennouseisankgkshrtkType() {
        if (zennouseisankgkshrtkType == null && zennouseisankgkshrtk != null) return zennouseisankgkshrtk.getType().toString();
        if (zennouseisankgkshrtkType == null && getZennouseisankgkshrtkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennouseisankgkshrtk$' should not be NULL."));
        }
        return zennouseisankgkshrtkType;
    }

    protected void setZennouseisankgkshrtkType(String type) {
        zennouseisankgkshrtkType = type;
        zennouseisankgkshrtk = Optional.fromNullable(toCurrencyType(zennouseisankgkshrtkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkshrtkValue()))
            .orNull();
    }

    private BizCurrency zitkazukarikingksiteituuka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZitkazukarikingksiteituuka() {
        return zitkazukarikingksiteituuka;
    }

    public void setZitkazukarikingksiteituuka(BizCurrency pZitkazukarikingksiteituuka) {
        zitkazukarikingksiteituuka = pZitkazukarikingksiteituuka;
        zitkazukarikingksiteituukaValue = null;
        zitkazukarikingksiteituukaType  = null;
    }

    transient private BigDecimal zitkazukarikingksiteituukaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZITKAZUKARIKINGKSITEITUUKA, nullable=true)
    protected BigDecimal getZitkazukarikingksiteituukaValue() {
        if (zitkazukarikingksiteituukaValue == null && zitkazukarikingksiteituuka != null) {
            if (zitkazukarikingksiteituuka.isOptional()) return null;
            return zitkazukarikingksiteituuka.absolute();
        }
        return zitkazukarikingksiteituukaValue;
    }

    protected void setZitkazukarikingksiteituukaValue(BigDecimal value) {
        zitkazukarikingksiteituukaValue = value;
        zitkazukarikingksiteituuka = Optional.fromNullable(toCurrencyType(zitkazukarikingksiteituukaType))
            .transform(bizCurrencyTransformer(getZitkazukarikingksiteituukaValue()))
            .orNull();
    }

    transient private String zitkazukarikingksiteituukaType = null;

    @Column(name=ZITKAZUKARIKINGKSITEITUUKA + "$", nullable=true)
    protected String getZitkazukarikingksiteituukaType() {
        if (zitkazukarikingksiteituukaType == null && zitkazukarikingksiteituuka != null) return zitkazukarikingksiteituuka.getType().toString();
        if (zitkazukarikingksiteituukaType == null && getZitkazukarikingksiteituukaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zitkazukarikingksiteituuka$' should not be NULL."));
        }
        return zitkazukarikingksiteituukaType;
    }

    protected void setZitkazukarikingksiteituukaType(String type) {
        zitkazukarikingksiteituukaType = type;
        zitkazukarikingksiteituuka = Optional.fromNullable(toCurrencyType(zitkazukarikingksiteituukaType))
            .transform(bizCurrencyTransformer(getZitkazukarikingksiteituukaValue()))
            .orNull();
    }

    private BizCurrency zitkazukarikingkyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZitkazukarikingkyen() {
        return zitkazukarikingkyen;
    }

    public void setZitkazukarikingkyen(BizCurrency pZitkazukarikingkyen) {
        zitkazukarikingkyen = pZitkazukarikingkyen;
        zitkazukarikingkyenValue = null;
        zitkazukarikingkyenType  = null;
    }

    transient private BigDecimal zitkazukarikingkyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZITKAZUKARIKINGKYEN, nullable=true)
    protected BigDecimal getZitkazukarikingkyenValue() {
        if (zitkazukarikingkyenValue == null && zitkazukarikingkyen != null) {
            if (zitkazukarikingkyen.isOptional()) return null;
            return zitkazukarikingkyen.absolute();
        }
        return zitkazukarikingkyenValue;
    }

    protected void setZitkazukarikingkyenValue(BigDecimal value) {
        zitkazukarikingkyenValue = value;
        zitkazukarikingkyen = Optional.fromNullable(toCurrencyType(zitkazukarikingkyenType))
            .transform(bizCurrencyTransformer(getZitkazukarikingkyenValue()))
            .orNull();
    }

    transient private String zitkazukarikingkyenType = null;

    @Column(name=ZITKAZUKARIKINGKYEN + "$", nullable=true)
    protected String getZitkazukarikingkyenType() {
        if (zitkazukarikingkyenType == null && zitkazukarikingkyen != null) return zitkazukarikingkyen.getType().toString();
        if (zitkazukarikingkyenType == null && getZitkazukarikingkyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zitkazukarikingkyen$' should not be NULL."));
        }
        return zitkazukarikingkyenType;
    }

    protected void setZitkazukarikingkyenType(String type) {
        zitkazukarikingkyenType = type;
        zitkazukarikingkyen = Optional.fromNullable(toCurrencyType(zitkazukarikingkyenType))
            .transform(bizCurrencyTransformer(getZitkazukarikingkyenValue()))
            .orNull();
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenJT_SiKekka.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizDate shrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiKekka.SHRKWSRATEKJNYMD)
    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    private BizNumber shrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiKekka.SHRKWSRATE)
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private BizNumber zeimukwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiKekka.ZEIMUKWSRATE)
    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        zeimukwsrate = pZeimukwsrate;
    }

    private String kossyoricd;

    @Column(name=GenJT_SiKekka.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SiKekka.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiKekka.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiKekka.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}