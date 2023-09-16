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
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_BAK_KihrkmpSeisanRireki;
import yuyu.def.db.id.PKIT_BAK_KihrkmpSeisanRireki;
import yuyu.def.db.meta.GenQIT_BAK_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_BAK_KihrkmpSeisanRireki;
import yuyu.def.db.type.UserType_C_KiharaiPseisanNaiyouKbn;
import yuyu.def.db.type.UserType_C_MisyuumikeikaKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 既払込Ｐ精算履歴バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KihrkmpSeisanRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KihrkmpSeisanRireki}</td><td colspan="3">既払込Ｐ精算履歴バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KihrkmpSeisanRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KihrkmpSeisanRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KihrkmpSeisanRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_BAK_KihrkmpSeisanRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKihrkpssnaiyoukbn kihrkpssnaiyoukbn}</td><td>既払込Ｐ精算内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KiharaiPseisanNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSeijyutoukaisuum seijyutoukaisuum}</td><td>精算充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSeijyutoukaisuuy seijyutoukaisuuy}</td><td>精算充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMisyuumikeikakbn misyuumikeikakbn}</td><td>未収未経過区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MisyuumikeikaKbn}</td></tr>
 *  <tr><td>{@link #getRstuukasyu rstuukasyu}</td><td>領収通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSeisanpgoukei seisanpgoukei}</td><td>精算保険料合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansansspgoukei yenkansansspgoukei}</td><td>円換算精算保険料合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansantkykwsrateymd yenkansantkykwsrateymd}</td><td>円換算適用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYenkansantkykwsrate yenkansantkykwsrate}</td><td>円換算適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHenkank henkank}</td><td>返還金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansanhenkankin yenkansanhenkankin}</td><td>円換算返還金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTuityouk tuityouk}</td><td>追徴金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansantuityoukin yenkansantuityoukin}</td><td>円換算追徴金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZeimukwsratekjnymd zeimukwsratekjnymd}</td><td>税務用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZeimukwsrate zeimukwsrate}</td><td>税務用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHituyoukeihiitijisytktysgk hituyoukeihiitijisytktysgk}</td><td>必要経費一時所得調整額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_BAK_KihrkmpSeisanRireki
 * @see     PKIT_BAK_KihrkmpSeisanRireki
 * @see     QIT_BAK_KihrkmpSeisanRireki
 * @see     GenQIT_BAK_KihrkmpSeisanRireki
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KihrkmpSeisanRireki.TABLE_NAME)
@IdClass(value=PKIT_BAK_KihrkmpSeisanRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_KiharaiPseisanNaiyouKbn", typeClass=UserType_C_KiharaiPseisanNaiyouKbn.class),
    @TypeDef(name="UserType_C_MisyuumikeikaKbn", typeClass=UserType_C_MisyuumikeikaKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenIT_BAK_KihrkmpSeisanRireki extends AbstractExDBEntity<IT_BAK_KihrkmpSeisanRireki, PKIT_BAK_KihrkmpSeisanRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KihrkmpSeisanRireki";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String RENNO                    = "renno";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String KIHRKPSSNAIYOUKBN        = "kihrkpssnaiyoukbn";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String SEIJYUTOUKAISUUM         = "seijyutoukaisuum";
    public static final String SEIJYUTOUKAISUUY         = "seijyutoukaisuuy";
    public static final String MISYUUMIKEIKAKBN         = "misyuumikeikakbn";
    public static final String RSTUUKASYU               = "rstuukasyu";
    public static final String SEISANPGOUKEI            = "seisanpgoukei";
    public static final String YENKANSANSSPGOUKEI       = "yenkansansspgoukei";
    public static final String YENKANSANTKYKWSRATEYMD   = "yenkansantkykwsrateymd";
    public static final String YENKANSANTKYKWSRATE      = "yenkansantkykwsrate";
    public static final String HENKANK                  = "henkank";
    public static final String YENKANSANHENKANKIN       = "yenkansanhenkankin";
    public static final String TUITYOUK                 = "tuityouk";
    public static final String YENKANSANTUITYOUKIN      = "yenkansantuityoukin";
    public static final String ZEIMUKWSRATEKJNYMD       = "zeimukwsratekjnymd";
    public static final String ZEIMUKWSRATE             = "zeimukwsrate";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String HITUYOUKEIHIITIJISYTKTYSGK = "hituyoukeihiitijisytktysgk";

    private final PKIT_BAK_KihrkmpSeisanRireki primaryKey;

    public GenIT_BAK_KihrkmpSeisanRireki() {
        primaryKey = new PKIT_BAK_KihrkmpSeisanRireki();
    }

    public GenIT_BAK_KihrkmpSeisanRireki(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        Integer pRenno
    ) {
        primaryKey = new PKIT_BAK_KihrkmpSeisanRireki(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KihrkmpSeisanRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KihrkmpSeisanRireki> getMetaClass() {
        return QIT_BAK_KihrkmpSeisanRireki.class;
    }

    @Id
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.SYONO)
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
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String henkousikibetukey;

    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private BizDate kouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private C_KiharaiPseisanNaiyouKbn kihrkpssnaiyoukbn;

    @Type(type="UserType_C_KiharaiPseisanNaiyouKbn")
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.KIHRKPSSNAIYOUKBN)
    public C_KiharaiPseisanNaiyouKbn getKihrkpssnaiyoukbn() {
        return kihrkpssnaiyoukbn;
    }

    public void setKihrkpssnaiyoukbn(C_KiharaiPseisanNaiyouKbn pKihrkpssnaiyoukbn) {
        kihrkpssnaiyoukbn = pKihrkpssnaiyoukbn;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer seijyutoukaisuum;

    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.SEIJYUTOUKAISUUM)
    public Integer getSeijyutoukaisuum() {
        return seijyutoukaisuum;
    }

    public void setSeijyutoukaisuum(Integer pSeijyutoukaisuum) {
        seijyutoukaisuum = pSeijyutoukaisuum;
    }

    private Integer seijyutoukaisuuy;

    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.SEIJYUTOUKAISUUY)
    public Integer getSeijyutoukaisuuy() {
        return seijyutoukaisuuy;
    }

    public void setSeijyutoukaisuuy(Integer pSeijyutoukaisuuy) {
        seijyutoukaisuuy = pSeijyutoukaisuuy;
    }

    private C_MisyuumikeikaKbn misyuumikeikakbn;

    @Type(type="UserType_C_MisyuumikeikaKbn")
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.MISYUUMIKEIKAKBN)
    public C_MisyuumikeikaKbn getMisyuumikeikakbn() {
        return misyuumikeikakbn;
    }

    public void setMisyuumikeikakbn(C_MisyuumikeikaKbn pMisyuumikeikakbn) {
        misyuumikeikakbn = pMisyuumikeikakbn;
    }

    private C_Tuukasyu rstuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.RSTUUKASYU)
    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
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

    private BizCurrency yenkansansspgoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkansansspgoukei() {
        return yenkansansspgoukei;
    }

    public void setYenkansansspgoukei(BizCurrency pYenkansansspgoukei) {
        yenkansansspgoukei = pYenkansansspgoukei;
        yenkansansspgoukeiValue = null;
        yenkansansspgoukeiType  = null;
    }

    transient private BigDecimal yenkansansspgoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKANSANSSPGOUKEI, nullable=true)
    protected BigDecimal getYenkansansspgoukeiValue() {
        if (yenkansansspgoukeiValue == null && yenkansansspgoukei != null) {
            if (yenkansansspgoukei.isOptional()) return null;
            return yenkansansspgoukei.absolute();
        }
        return yenkansansspgoukeiValue;
    }

    protected void setYenkansansspgoukeiValue(BigDecimal value) {
        yenkansansspgoukeiValue = value;
        yenkansansspgoukei = Optional.fromNullable(toCurrencyType(yenkansansspgoukeiType))
            .transform(bizCurrencyTransformer(getYenkansansspgoukeiValue()))
            .orNull();
    }

    transient private String yenkansansspgoukeiType = null;

    @Column(name=YENKANSANSSPGOUKEI + "$", nullable=true)
    protected String getYenkansansspgoukeiType() {
        if (yenkansansspgoukeiType == null && yenkansansspgoukei != null) return yenkansansspgoukei.getType().toString();
        if (yenkansansspgoukeiType == null && getYenkansansspgoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkansansspgoukei$' should not be NULL."));
        }
        return yenkansansspgoukeiType;
    }

    protected void setYenkansansspgoukeiType(String type) {
        yenkansansspgoukeiType = type;
        yenkansansspgoukei = Optional.fromNullable(toCurrencyType(yenkansansspgoukeiType))
            .transform(bizCurrencyTransformer(getYenkansansspgoukeiValue()))
            .orNull();
    }

    private BizDate yenkansantkykwsrateymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.YENKANSANTKYKWSRATEYMD)
    public BizDate getYenkansantkykwsrateymd() {
        return yenkansantkykwsrateymd;
    }

    public void setYenkansantkykwsrateymd(BizDate pYenkansantkykwsrateymd) {
        yenkansantkykwsrateymd = pYenkansantkykwsrateymd;
    }

    private BizNumber yenkansantkykwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.YENKANSANTKYKWSRATE)
    public BizNumber getYenkansantkykwsrate() {
        return yenkansantkykwsrate;
    }

    public void setYenkansantkykwsrate(BizNumber pYenkansantkykwsrate) {
        yenkansantkykwsrate = pYenkansantkykwsrate;
    }

    private BizCurrency henkank;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHenkank() {
        return henkank;
    }

    public void setHenkank(BizCurrency pHenkank) {
        henkank = pHenkank;
        henkankValue = null;
        henkankType  = null;
    }

    transient private BigDecimal henkankValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HENKANK, nullable=true)
    protected BigDecimal getHenkankValue() {
        if (henkankValue == null && henkank != null) {
            if (henkank.isOptional()) return null;
            return henkank.absolute();
        }
        return henkankValue;
    }

    protected void setHenkankValue(BigDecimal value) {
        henkankValue = value;
        henkank = Optional.fromNullable(toCurrencyType(henkankType))
            .transform(bizCurrencyTransformer(getHenkankValue()))
            .orNull();
    }

    transient private String henkankType = null;

    @Column(name=HENKANK + "$", nullable=true)
    protected String getHenkankType() {
        if (henkankType == null && henkank != null) return henkank.getType().toString();
        if (henkankType == null && getHenkankValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'henkank$' should not be NULL."));
        }
        return henkankType;
    }

    protected void setHenkankType(String type) {
        henkankType = type;
        henkank = Optional.fromNullable(toCurrencyType(henkankType))
            .transform(bizCurrencyTransformer(getHenkankValue()))
            .orNull();
    }

    private BizCurrency yenkansanhenkankin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkansanhenkankin() {
        return yenkansanhenkankin;
    }

    public void setYenkansanhenkankin(BizCurrency pYenkansanhenkankin) {
        yenkansanhenkankin = pYenkansanhenkankin;
        yenkansanhenkankinValue = null;
        yenkansanhenkankinType  = null;
    }

    transient private BigDecimal yenkansanhenkankinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKANSANHENKANKIN, nullable=true)
    protected BigDecimal getYenkansanhenkankinValue() {
        if (yenkansanhenkankinValue == null && yenkansanhenkankin != null) {
            if (yenkansanhenkankin.isOptional()) return null;
            return yenkansanhenkankin.absolute();
        }
        return yenkansanhenkankinValue;
    }

    protected void setYenkansanhenkankinValue(BigDecimal value) {
        yenkansanhenkankinValue = value;
        yenkansanhenkankin = Optional.fromNullable(toCurrencyType(yenkansanhenkankinType))
            .transform(bizCurrencyTransformer(getYenkansanhenkankinValue()))
            .orNull();
    }

    transient private String yenkansanhenkankinType = null;

    @Column(name=YENKANSANHENKANKIN + "$", nullable=true)
    protected String getYenkansanhenkankinType() {
        if (yenkansanhenkankinType == null && yenkansanhenkankin != null) return yenkansanhenkankin.getType().toString();
        if (yenkansanhenkankinType == null && getYenkansanhenkankinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkansanhenkankin$' should not be NULL."));
        }
        return yenkansanhenkankinType;
    }

    protected void setYenkansanhenkankinType(String type) {
        yenkansanhenkankinType = type;
        yenkansanhenkankin = Optional.fromNullable(toCurrencyType(yenkansanhenkankinType))
            .transform(bizCurrencyTransformer(getYenkansanhenkankinValue()))
            .orNull();
    }

    private BizCurrency tuityouk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTuityouk() {
        return tuityouk;
    }

    public void setTuityouk(BizCurrency pTuityouk) {
        tuityouk = pTuityouk;
        tuityoukValue = null;
        tuityoukType  = null;
    }

    transient private BigDecimal tuityoukValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUITYOUK, nullable=true)
    protected BigDecimal getTuityoukValue() {
        if (tuityoukValue == null && tuityouk != null) {
            if (tuityouk.isOptional()) return null;
            return tuityouk.absolute();
        }
        return tuityoukValue;
    }

    protected void setTuityoukValue(BigDecimal value) {
        tuityoukValue = value;
        tuityouk = Optional.fromNullable(toCurrencyType(tuityoukType))
            .transform(bizCurrencyTransformer(getTuityoukValue()))
            .orNull();
    }

    transient private String tuityoukType = null;

    @Column(name=TUITYOUK + "$", nullable=true)
    protected String getTuityoukType() {
        if (tuityoukType == null && tuityouk != null) return tuityouk.getType().toString();
        if (tuityoukType == null && getTuityoukValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tuityouk$' should not be NULL."));
        }
        return tuityoukType;
    }

    protected void setTuityoukType(String type) {
        tuityoukType = type;
        tuityouk = Optional.fromNullable(toCurrencyType(tuityoukType))
            .transform(bizCurrencyTransformer(getTuityoukValue()))
            .orNull();
    }

    private BizCurrency yenkansantuityoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkansantuityoukin() {
        return yenkansantuityoukin;
    }

    public void setYenkansantuityoukin(BizCurrency pYenkansantuityoukin) {
        yenkansantuityoukin = pYenkansantuityoukin;
        yenkansantuityoukinValue = null;
        yenkansantuityoukinType  = null;
    }

    transient private BigDecimal yenkansantuityoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKANSANTUITYOUKIN, nullable=true)
    protected BigDecimal getYenkansantuityoukinValue() {
        if (yenkansantuityoukinValue == null && yenkansantuityoukin != null) {
            if (yenkansantuityoukin.isOptional()) return null;
            return yenkansantuityoukin.absolute();
        }
        return yenkansantuityoukinValue;
    }

    protected void setYenkansantuityoukinValue(BigDecimal value) {
        yenkansantuityoukinValue = value;
        yenkansantuityoukin = Optional.fromNullable(toCurrencyType(yenkansantuityoukinType))
            .transform(bizCurrencyTransformer(getYenkansantuityoukinValue()))
            .orNull();
    }

    transient private String yenkansantuityoukinType = null;

    @Column(name=YENKANSANTUITYOUKIN + "$", nullable=true)
    protected String getYenkansantuityoukinType() {
        if (yenkansantuityoukinType == null && yenkansantuityoukin != null) return yenkansantuityoukin.getType().toString();
        if (yenkansantuityoukinType == null && getYenkansantuityoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkansantuityoukin$' should not be NULL."));
        }
        return yenkansantuityoukinType;
    }

    protected void setYenkansantuityoukinType(String type) {
        yenkansantuityoukinType = type;
        yenkansantuityoukin = Optional.fromNullable(toCurrencyType(yenkansantuityoukinType))
            .transform(bizCurrencyTransformer(getYenkansantuityoukinValue()))
            .orNull();
    }

    private BizDate zeimukwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.ZEIMUKWSRATEKJNYMD)
    public BizDate getZeimukwsratekjnymd() {
        return zeimukwsratekjnymd;
    }

    public void setZeimukwsratekjnymd(BizDate pZeimukwsratekjnymd) {
        zeimukwsratekjnymd = pZeimukwsratekjnymd;
    }

    private BizNumber zeimukwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.ZEIMUKWSRATE)
    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        zeimukwsrate = pZeimukwsrate;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KihrkmpSeisanRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizCurrency hituyoukeihiitijisytktysgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHituyoukeihiitijisytktysgk() {
        return hituyoukeihiitijisytktysgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHituyoukeihiitijisytktysgk(BizCurrency pHituyoukeihiitijisytktysgk) {
        hituyoukeihiitijisytktysgk = pHituyoukeihiitijisytktysgk;
        hituyoukeihiitijisytktysgkValue = null;
        hituyoukeihiitijisytktysgkType  = null;
    }

    transient private BigDecimal hituyoukeihiitijisytktysgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HITUYOUKEIHIITIJISYTKTYSGK, nullable=true)
    protected BigDecimal getHituyoukeihiitijisytktysgkValue() {
        if (hituyoukeihiitijisytktysgkValue == null && hituyoukeihiitijisytktysgk != null) {
            if (hituyoukeihiitijisytktysgk.isOptional()) return null;
            return hituyoukeihiitijisytktysgk.absolute();
        }
        return hituyoukeihiitijisytktysgkValue;
    }

    protected void setHituyoukeihiitijisytktysgkValue(BigDecimal value) {
        hituyoukeihiitijisytktysgkValue = value;
        hituyoukeihiitijisytktysgk = Optional.fromNullable(toCurrencyType(hituyoukeihiitijisytktysgkType))
            .transform(bizCurrencyTransformer(getHituyoukeihiitijisytktysgkValue()))
            .orNull();
    }

    transient private String hituyoukeihiitijisytktysgkType = null;

    @Column(name=HITUYOUKEIHIITIJISYTKTYSGK + "$", nullable=true)
    protected String getHituyoukeihiitijisytktysgkType() {
        if (hituyoukeihiitijisytktysgkType == null && hituyoukeihiitijisytktysgk != null) return hituyoukeihiitijisytktysgk.getType().toString();
        if (hituyoukeihiitijisytktysgkType == null && getHituyoukeihiitijisytktysgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hituyoukeihiitijisytktysgk$' should not be NULL."));
        }
        return hituyoukeihiitijisytktysgkType;
    }

    protected void setHituyoukeihiitijisytktysgkType(String type) {
        hituyoukeihiitijisytktysgkType = type;
        hituyoukeihiitijisytktysgk = Optional.fromNullable(toCurrencyType(hituyoukeihiitijisytktysgkType))
            .transform(bizCurrencyTransformer(getHituyoukeihiitijisytktysgkValue()))
            .orNull();
    }
}