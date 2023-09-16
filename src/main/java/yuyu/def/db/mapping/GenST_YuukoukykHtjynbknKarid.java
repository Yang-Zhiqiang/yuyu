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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SrHaitoukinSyuukeiPtnKbn;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;
import yuyu.def.db.id.PKST_YuukoukykHtjynbknKarid;
import yuyu.def.db.meta.GenQST_YuukoukykHtjynbknKarid;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknKarid;
import yuyu.def.db.type.UserType_C_SrHaitoukinSyuukeiPtnKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 有効契約配当準備金（仮割当Ｄ）テーブル テーブルのマッピング情報クラスで、 {@link ST_YuukoukykHtjynbknKarid} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_YuukoukykHtjynbknKarid}</td><td colspan="3">有効契約配当準備金（仮割当Ｄ）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKST_YuukoukykHtjynbknKarid ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKakutyoujobcd kakutyoujobcd}</td><td>拡張ジョブコード</td><td align="center">{@link PKST_YuukoukykHtjynbknKarid ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKST_YuukoukykHtjynbknKarid ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyukigou hknsyukigou}</td><td>保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaraikomikaisukbn haraikomikaisukbn}</td><td>払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkeirokbn hrkkeirokbn}</td><td>払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAnnaihuyouriyuukbn annaihuyouriyuukbn}</td><td>案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZnnndkrkskrwratdruigk znnndkrkskrwratdruigk}</td><td>前年度繰越仮割当Ｄ累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTounendokariwariated tounendokariwariated}</td><td>当年度仮割当Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTndmatukrkskrwratdruigk tndmatukrkskrwratdruigk}</td><td>当年度末仮割当Ｄ累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKariwariatedrisoku kariwariatedrisoku}</td><td>仮割当Ｄ利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHsys hsys}</td><td>保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYobiv3 yobiv3}</td><td>予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSrutiwake srutiwake}</td><td>数理用内訳</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSrkijyunym srkijyunym}</td><td>数理用基準年月</td><td align="center">{@link PKST_YuukoukykHtjynbknKarid ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeiriyousegmentkbn kbnkeiriyousegmentkbn}</td><td>区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeiriyourgnbnskkbn kbnkeiriyourgnbnskkbn}</td><td>区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeisikiwariatenendohyj seisikiwariatenendohyj}</td><td>正式割当年度表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMankitouraiym mankitouraiym}</td><td>満期到来年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyukeiyakusyuruicd syukeiyakusyuruicd}</td><td>主契約種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknendo kyknendo}</td><td>契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaihyouyoteiriritu daihyouyoteiriritu}</td><td>代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHaraikatakbn haraikatakbn}</td><td>払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYobiv20 yobiv20}</td><td>予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSrhaitoukinsyuukeiptnkbn srhaitoukinsyuukeiptnkbn}</td><td>数理配当金集計パターン区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SrHaitoukinSyuukeiPtnKbn}</td></tr>
 * </table>
 * @see     ST_YuukoukykHtjynbknKarid
 * @see     PKST_YuukoukykHtjynbknKarid
 * @see     QST_YuukoukykHtjynbknKarid
 * @see     GenQST_YuukoukykHtjynbknKarid
 */
@MappedSuperclass
@Table(name=GenST_YuukoukykHtjynbknKarid.TABLE_NAME)
@IdClass(value=PKST_YuukoukykHtjynbknKarid.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_SrHaitoukinSyuukeiPtnKbn", typeClass=UserType_C_SrHaitoukinSyuukeiPtnKbn.class)
})
public abstract class GenST_YuukoukykHtjynbknKarid extends AbstractExDBEntity<ST_YuukoukykHtjynbknKarid, PKST_YuukoukykHtjynbknKarid> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ST_YuukoukykHtjynbknKarid";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String KAKUTYOUJOBCD            = "kakutyoujobcd";
    public static final String SYONO                    = "syono";
    public static final String HKNSYUKIGOU              = "hknsyukigou";
    public static final String HARAIKOMIKAISUKBN        = "haraikomikaisukbn";
    public static final String HRKKEIROKBN              = "hrkkeirokbn";
    public static final String ANNAIHUYOURIYUUKBN       = "annaihuyouriyuukbn";
    public static final String ZNNNDKRKSKRWRATDRUIGK    = "znnndkrkskrwratdruigk";
    public static final String TOUNENDOKARIWARIATED     = "tounendokariwariated";
    public static final String TNDMATUKRKSKRWRATDRUIGK  = "tndmatukrkskrwratdruigk";
    public static final String KARIWARIATEDRISOKU       = "kariwariatedrisoku";
    public static final String HSYS                     = "hsys";
    public static final String YOBIV3                   = "yobiv3";
    public static final String SRUTIWAKE                = "srutiwake";
    public static final String SRKIJYUNYM               = "srkijyunym";
    public static final String KBNKEIRIYOUSEGMENTKBN    = "kbnkeiriyousegmentkbn";
    public static final String KBNKEIRIYOURGNBNSKKBN    = "kbnkeiriyourgnbnskkbn";
    public static final String SEISIKIWARIATENENDOHYJ   = "seisikiwariatenendohyj";
    public static final String MANKITOURAIYM            = "mankitouraiym";
    public static final String SYUKEIYAKUSYURUICD       = "syukeiyakusyuruicd";
    public static final String KYKNENDO                 = "kyknendo";
    public static final String DAIHYOUYOTEIRIRITU       = "daihyouyoteiriritu";
    public static final String HARAIKATAKBN             = "haraikatakbn";
    public static final String YOBIV20                  = "yobiv20";
    public static final String SRHAITOUKINSYUUKEIPTNKBN = "srhaitoukinsyuukeiptnkbn";

    private final PKST_YuukoukykHtjynbknKarid primaryKey;

    public GenST_YuukoukykHtjynbknKarid() {
        primaryKey = new PKST_YuukoukykHtjynbknKarid();
    }

    public GenST_YuukoukykHtjynbknKarid(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pSrkijyunym
    ) {
        primaryKey = new PKST_YuukoukykHtjynbknKarid(
            pSyoriYmd,
            pKakutyoujobcd,
            pSyono,
            pSrkijyunym
        );
    }

    @Transient
    @Override
    public PKST_YuukoukykHtjynbknKarid getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QST_YuukoukykHtjynbknKarid> getMetaClass() {
        return QST_YuukoukykHtjynbknKarid.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenST_YuukoukykHtjynbknKarid.SYORIYMD)
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
    @Column(name=GenST_YuukoukykHtjynbknKarid.KAKUTYOUJOBCD)
    public String getKakutyoujobcd() {
        return getPrimaryKey().getKakutyoujobcd();
    }

    public void setKakutyoujobcd(String pKakutyoujobcd) {
        getPrimaryKey().setKakutyoujobcd(pKakutyoujobcd);
    }

    @Id
    @Column(name=GenST_YuukoukykHtjynbknKarid.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String hknsyukigou;

    @Column(name=GenST_YuukoukykHtjynbknKarid.HKNSYUKIGOU)
    public String getHknsyukigou() {
        return hknsyukigou;
    }

    public void setHknsyukigou(String pHknsyukigou) {
        hknsyukigou = pHknsyukigou;
    }

    private String haraikomikaisukbn;

    @Column(name=GenST_YuukoukykHtjynbknKarid.HARAIKOMIKAISUKBN)
    public String getHaraikomikaisukbn() {
        return haraikomikaisukbn;
    }

    public void setHaraikomikaisukbn(String pHaraikomikaisukbn) {
        haraikomikaisukbn = pHaraikomikaisukbn;
    }

    private String hrkkeirokbn;

    @Column(name=GenST_YuukoukykHtjynbknKarid.HRKKEIROKBN)
    public String getHrkkeirokbn() {
        return hrkkeirokbn;
    }

    public void setHrkkeirokbn(String pHrkkeirokbn) {
        hrkkeirokbn = pHrkkeirokbn;
    }

    private String annaihuyouriyuukbn;

    @Column(name=GenST_YuukoukykHtjynbknKarid.ANNAIHUYOURIYUUKBN)
    public String getAnnaihuyouriyuukbn() {
        return annaihuyouriyuukbn;
    }

    public void setAnnaihuyouriyuukbn(String pAnnaihuyouriyuukbn) {
        annaihuyouriyuukbn = pAnnaihuyouriyuukbn;
    }

    private BizCurrency znnndkrkskrwratdruigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZnnndkrkskrwratdruigk() {
        return znnndkrkskrwratdruigk;
    }

    public void setZnnndkrkskrwratdruigk(BizCurrency pZnnndkrkskrwratdruigk) {
        znnndkrkskrwratdruigk = pZnnndkrkskrwratdruigk;
        znnndkrkskrwratdruigkValue = null;
        znnndkrkskrwratdruigkType  = null;
    }

    transient private BigDecimal znnndkrkskrwratdruigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZNNNDKRKSKRWRATDRUIGK, nullable=true)
    protected BigDecimal getZnnndkrkskrwratdruigkValue() {
        if (znnndkrkskrwratdruigkValue == null && znnndkrkskrwratdruigk != null) {
            if (znnndkrkskrwratdruigk.isOptional()) return null;
            return znnndkrkskrwratdruigk.absolute();
        }
        return znnndkrkskrwratdruigkValue;
    }

    protected void setZnnndkrkskrwratdruigkValue(BigDecimal value) {
        znnndkrkskrwratdruigkValue = value;
        znnndkrkskrwratdruigk = Optional.fromNullable(toCurrencyType(znnndkrkskrwratdruigkType))
            .transform(bizCurrencyTransformer(getZnnndkrkskrwratdruigkValue()))
            .orNull();
    }

    transient private String znnndkrkskrwratdruigkType = null;

    @Column(name=ZNNNDKRKSKRWRATDRUIGK + "$", nullable=true)
    protected String getZnnndkrkskrwratdruigkType() {
        if (znnndkrkskrwratdruigkType == null && znnndkrkskrwratdruigk != null) return znnndkrkskrwratdruigk.getType().toString();
        if (znnndkrkskrwratdruigkType == null && getZnnndkrkskrwratdruigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'znnndkrkskrwratdruigk$' should not be NULL."));
        }
        return znnndkrkskrwratdruigkType;
    }

    protected void setZnnndkrkskrwratdruigkType(String type) {
        znnndkrkskrwratdruigkType = type;
        znnndkrkskrwratdruigk = Optional.fromNullable(toCurrencyType(znnndkrkskrwratdruigkType))
            .transform(bizCurrencyTransformer(getZnnndkrkskrwratdruigkValue()))
            .orNull();
    }

    private BizCurrency tounendokariwariated;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTounendokariwariated() {
        return tounendokariwariated;
    }

    public void setTounendokariwariated(BizCurrency pTounendokariwariated) {
        tounendokariwariated = pTounendokariwariated;
        tounendokariwariatedValue = null;
        tounendokariwariatedType  = null;
    }

    transient private BigDecimal tounendokariwariatedValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUNENDOKARIWARIATED, nullable=true)
    protected BigDecimal getTounendokariwariatedValue() {
        if (tounendokariwariatedValue == null && tounendokariwariated != null) {
            if (tounendokariwariated.isOptional()) return null;
            return tounendokariwariated.absolute();
        }
        return tounendokariwariatedValue;
    }

    protected void setTounendokariwariatedValue(BigDecimal value) {
        tounendokariwariatedValue = value;
        tounendokariwariated = Optional.fromNullable(toCurrencyType(tounendokariwariatedType))
            .transform(bizCurrencyTransformer(getTounendokariwariatedValue()))
            .orNull();
    }

    transient private String tounendokariwariatedType = null;

    @Column(name=TOUNENDOKARIWARIATED + "$", nullable=true)
    protected String getTounendokariwariatedType() {
        if (tounendokariwariatedType == null && tounendokariwariated != null) return tounendokariwariated.getType().toString();
        if (tounendokariwariatedType == null && getTounendokariwariatedValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tounendokariwariated$' should not be NULL."));
        }
        return tounendokariwariatedType;
    }

    protected void setTounendokariwariatedType(String type) {
        tounendokariwariatedType = type;
        tounendokariwariated = Optional.fromNullable(toCurrencyType(tounendokariwariatedType))
            .transform(bizCurrencyTransformer(getTounendokariwariatedValue()))
            .orNull();
    }

    private BizCurrency tndmatukrkskrwratdruigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTndmatukrkskrwratdruigk() {
        return tndmatukrkskrwratdruigk;
    }

    public void setTndmatukrkskrwratdruigk(BizCurrency pTndmatukrkskrwratdruigk) {
        tndmatukrkskrwratdruigk = pTndmatukrkskrwratdruigk;
        tndmatukrkskrwratdruigkValue = null;
        tndmatukrkskrwratdruigkType  = null;
    }

    transient private BigDecimal tndmatukrkskrwratdruigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TNDMATUKRKSKRWRATDRUIGK, nullable=true)
    protected BigDecimal getTndmatukrkskrwratdruigkValue() {
        if (tndmatukrkskrwratdruigkValue == null && tndmatukrkskrwratdruigk != null) {
            if (tndmatukrkskrwratdruigk.isOptional()) return null;
            return tndmatukrkskrwratdruigk.absolute();
        }
        return tndmatukrkskrwratdruigkValue;
    }

    protected void setTndmatukrkskrwratdruigkValue(BigDecimal value) {
        tndmatukrkskrwratdruigkValue = value;
        tndmatukrkskrwratdruigk = Optional.fromNullable(toCurrencyType(tndmatukrkskrwratdruigkType))
            .transform(bizCurrencyTransformer(getTndmatukrkskrwratdruigkValue()))
            .orNull();
    }

    transient private String tndmatukrkskrwratdruigkType = null;

    @Column(name=TNDMATUKRKSKRWRATDRUIGK + "$", nullable=true)
    protected String getTndmatukrkskrwratdruigkType() {
        if (tndmatukrkskrwratdruigkType == null && tndmatukrkskrwratdruigk != null) return tndmatukrkskrwratdruigk.getType().toString();
        if (tndmatukrkskrwratdruigkType == null && getTndmatukrkskrwratdruigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tndmatukrkskrwratdruigk$' should not be NULL."));
        }
        return tndmatukrkskrwratdruigkType;
    }

    protected void setTndmatukrkskrwratdruigkType(String type) {
        tndmatukrkskrwratdruigkType = type;
        tndmatukrkskrwratdruigk = Optional.fromNullable(toCurrencyType(tndmatukrkskrwratdruigkType))
            .transform(bizCurrencyTransformer(getTndmatukrkskrwratdruigkValue()))
            .orNull();
    }

    private BizCurrency kariwariatedrisoku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedrisoku() {
        return kariwariatedrisoku;
    }

    public void setKariwariatedrisoku(BizCurrency pKariwariatedrisoku) {
        kariwariatedrisoku = pKariwariatedrisoku;
        kariwariatedrisokuValue = null;
        kariwariatedrisokuType  = null;
    }

    transient private BigDecimal kariwariatedrisokuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDRISOKU, nullable=true)
    protected BigDecimal getKariwariatedrisokuValue() {
        if (kariwariatedrisokuValue == null && kariwariatedrisoku != null) {
            if (kariwariatedrisoku.isOptional()) return null;
            return kariwariatedrisoku.absolute();
        }
        return kariwariatedrisokuValue;
    }

    protected void setKariwariatedrisokuValue(BigDecimal value) {
        kariwariatedrisokuValue = value;
        kariwariatedrisoku = Optional.fromNullable(toCurrencyType(kariwariatedrisokuType))
            .transform(bizCurrencyTransformer(getKariwariatedrisokuValue()))
            .orNull();
    }

    transient private String kariwariatedrisokuType = null;

    @Column(name=KARIWARIATEDRISOKU + "$", nullable=true)
    protected String getKariwariatedrisokuType() {
        if (kariwariatedrisokuType == null && kariwariatedrisoku != null) return kariwariatedrisoku.getType().toString();
        if (kariwariatedrisokuType == null && getKariwariatedrisokuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedrisoku$' should not be NULL."));
        }
        return kariwariatedrisokuType;
    }

    protected void setKariwariatedrisokuType(String type) {
        kariwariatedrisokuType = type;
        kariwariatedrisoku = Optional.fromNullable(toCurrencyType(kariwariatedrisokuType))
            .transform(bizCurrencyTransformer(getKariwariatedrisokuValue()))
            .orNull();
    }

    private BizCurrency hsys;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHsys() {
        return hsys;
    }

    public void setHsys(BizCurrency pHsys) {
        hsys = pHsys;
        hsysValue = null;
        hsysType  = null;
    }

    transient private BigDecimal hsysValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HSYS, nullable=true)
    protected BigDecimal getHsysValue() {
        if (hsysValue == null && hsys != null) {
            if (hsys.isOptional()) return null;
            return hsys.absolute();
        }
        return hsysValue;
    }

    protected void setHsysValue(BigDecimal value) {
        hsysValue = value;
        hsys = Optional.fromNullable(toCurrencyType(hsysType))
            .transform(bizCurrencyTransformer(getHsysValue()))
            .orNull();
    }

    transient private String hsysType = null;

    @Column(name=HSYS + "$", nullable=true)
    protected String getHsysType() {
        if (hsysType == null && hsys != null) return hsys.getType().toString();
        if (hsysType == null && getHsysValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hsys$' should not be NULL."));
        }
        return hsysType;
    }

    protected void setHsysType(String type) {
        hsysType = type;
        hsys = Optional.fromNullable(toCurrencyType(hsysType))
            .transform(bizCurrencyTransformer(getHsysValue()))
            .orNull();
    }

    private String yobiv3;

    @Column(name=GenST_YuukoukykHtjynbknKarid.YOBIV3)
    public String getYobiv3() {
        return yobiv3;
    }

    public void setYobiv3(String pYobiv3) {
        yobiv3 = pYobiv3;
    }

    private String srutiwake;

    @Column(name=GenST_YuukoukykHtjynbknKarid.SRUTIWAKE)
    public String getSrutiwake() {
        return srutiwake;
    }

    public void setSrutiwake(String pSrutiwake) {
        srutiwake = pSrutiwake;
    }

    @Id
    @Column(name=GenST_YuukoukykHtjynbknKarid.SRKIJYUNYM)
    public String getSrkijyunym() {
        return getPrimaryKey().getSrkijyunym();
    }

    public void setSrkijyunym(String pSrkijyunym) {
        getPrimaryKey().setSrkijyunym(pSrkijyunym);
    }

    private String kbnkeiriyousegmentkbn;

    @Column(name=GenST_YuukoukykHtjynbknKarid.KBNKEIRIYOUSEGMENTKBN)
    public String getKbnkeiriyousegmentkbn() {
        return kbnkeiriyousegmentkbn;
    }

    public void setKbnkeiriyousegmentkbn(String pKbnkeiriyousegmentkbn) {
        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
    }

    private String kbnkeiriyourgnbnskkbn;

    @Column(name=GenST_YuukoukykHtjynbknKarid.KBNKEIRIYOURGNBNSKKBN)
    public String getKbnkeiriyourgnbnskkbn() {
        return kbnkeiriyourgnbnskkbn;
    }

    public void setKbnkeiriyourgnbnskkbn(String pKbnkeiriyourgnbnskkbn) {
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
    }

    private String seisikiwariatenendohyj;

    @Column(name=GenST_YuukoukykHtjynbknKarid.SEISIKIWARIATENENDOHYJ)
    public String getSeisikiwariatenendohyj() {
        return seisikiwariatenendohyj;
    }

    public void setSeisikiwariatenendohyj(String pSeisikiwariatenendohyj) {
        seisikiwariatenendohyj = pSeisikiwariatenendohyj;
    }

    private BizDateYM mankitouraiym;

    @Type(type="BizDateYMType")
    @Column(name=GenST_YuukoukykHtjynbknKarid.MANKITOURAIYM)
    public BizDateYM getMankitouraiym() {
        return mankitouraiym;
    }

    public void setMankitouraiym(BizDateYM pMankitouraiym) {
        mankitouraiym = pMankitouraiym;
    }

    private String syukeiyakusyuruicd;

    @Column(name=GenST_YuukoukykHtjynbknKarid.SYUKEIYAKUSYURUICD)
    public String getSyukeiyakusyuruicd() {
        return syukeiyakusyuruicd;
    }

    public void setSyukeiyakusyuruicd(String pSyukeiyakusyuruicd) {
        syukeiyakusyuruicd = pSyukeiyakusyuruicd;
    }

    private String kyknendo;

    @Column(name=GenST_YuukoukykHtjynbknKarid.KYKNENDO)
    public String getKyknendo() {
        return kyknendo;
    }

    public void setKyknendo(String pKyknendo) {
        kyknendo = pKyknendo;
    }

    private BizNumber daihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_YuukoukykHtjynbknKarid.DAIHYOUYOTEIRIRITU)
    public BizNumber getDaihyouyoteiriritu() {
        return daihyouyoteiriritu;
    }

    public void setDaihyouyoteiriritu(BizNumber pDaihyouyoteiriritu) {
        daihyouyoteiriritu = pDaihyouyoteiriritu;
    }

    private String haraikatakbn;

    @Column(name=GenST_YuukoukykHtjynbknKarid.HARAIKATAKBN)
    public String getHaraikatakbn() {
        return haraikatakbn;
    }

    public void setHaraikatakbn(String pHaraikatakbn) {
        haraikatakbn = pHaraikatakbn;
    }

    private String yobiv20;

    @Column(name=GenST_YuukoukykHtjynbknKarid.YOBIV20)
    public String getYobiv20() {
        return yobiv20;
    }

    public void setYobiv20(String pYobiv20) {
        yobiv20 = pYobiv20;
    }

    private C_SrHaitoukinSyuukeiPtnKbn srhaitoukinsyuukeiptnkbn;

    @Type(type="UserType_C_SrHaitoukinSyuukeiPtnKbn")
    @Column(name=GenST_YuukoukykHtjynbknKarid.SRHAITOUKINSYUUKEIPTNKBN)
    public C_SrHaitoukinSyuukeiPtnKbn getSrhaitoukinsyuukeiptnkbn() {
        return srhaitoukinsyuukeiptnkbn;
    }

    public void setSrhaitoukinsyuukeiptnkbn(C_SrHaitoukinSyuukeiPtnKbn pSrhaitoukinsyuukeiptnkbn) {
        srhaitoukinsyuukeiptnkbn = pSrhaitoukinsyuukeiptnkbn;
    }
}