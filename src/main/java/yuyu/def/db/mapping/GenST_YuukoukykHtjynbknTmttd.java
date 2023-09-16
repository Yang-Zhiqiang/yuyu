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
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.id.PKST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.meta.GenQST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.type.UserType_C_SrHaitoukinSyuukeiPtnKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 有効契約配当準備金（積立Ｄ）テーブル テーブルのマッピング情報クラスで、 {@link ST_YuukoukykHtjynbknTmttd} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_YuukoukykHtjynbknTmttd}</td><td colspan="3">有効契約配当準備金（積立Ｄ）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKST_YuukoukykHtjynbknTmttd ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKakutyoujobcd kakutyoujobcd}</td><td>拡張ジョブコード</td><td align="center">{@link PKST_YuukoukykHtjynbknTmttd ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKST_YuukoukykHtjynbknTmttd ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyukigou hknsyukigou}</td><td>保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaraikomikaisukbn haraikomikaisukbn}</td><td>払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkeirokbn hrkkeirokbn}</td><td>払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAnnaihuyouriyuukbn annaihuyouriyuukbn}</td><td>案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennendkurikosid zennendkurikosid}</td><td>前年度繰越Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTounendod tounendod}</td><td>当年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTndmatutumitated tndmatutumitated}</td><td>当年度末積立Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTumitaterisoku tumitaterisoku}</td><td>積立利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHsys hsys}</td><td>保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyuruicd1 syuruicd1}</td><td>種類コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyuruicd3 syuruicd3}</td><td>種類コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSrutiwake srutiwake}</td><td>数理用内訳</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSrkijyunym srkijyunym}</td><td>数理用基準年月</td><td align="center">{@link PKST_YuukoukykHtjynbknTmttd ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeiriyousegmentkbn kbnkeiriyousegmentkbn}</td><td>区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeiriyourgnbnskkbn kbnkeiriyourgnbnskkbn}</td><td>区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyuruicd2 syuruicd2}</td><td>種類コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMankitouraiym mankitouraiym}</td><td>満期到来年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyukeiyakusyuruicd syukeiyakusyuruicd}</td><td>主契約種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknendo kyknendo}</td><td>契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaihyouyoteiriritu daihyouyoteiriritu}</td><td>代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHaraikatakbn haraikatakbn}</td><td>払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYobiv20 yobiv20}</td><td>予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSrhaitoukinsyuukeiptnkbn srhaitoukinsyuukeiptnkbn}</td><td>数理配当金集計パターン区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SrHaitoukinSyuukeiPtnKbn}</td></tr>
 * </table>
 * @see     ST_YuukoukykHtjynbknTmttd
 * @see     PKST_YuukoukykHtjynbknTmttd
 * @see     QST_YuukoukykHtjynbknTmttd
 * @see     GenQST_YuukoukykHtjynbknTmttd
 */
@MappedSuperclass
@Table(name=GenST_YuukoukykHtjynbknTmttd.TABLE_NAME)
@IdClass(value=PKST_YuukoukykHtjynbknTmttd.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_SrHaitoukinSyuukeiPtnKbn", typeClass=UserType_C_SrHaitoukinSyuukeiPtnKbn.class)
})
public abstract class GenST_YuukoukykHtjynbknTmttd extends AbstractExDBEntity<ST_YuukoukykHtjynbknTmttd, PKST_YuukoukykHtjynbknTmttd> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ST_YuukoukykHtjynbknTmttd";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String KAKUTYOUJOBCD            = "kakutyoujobcd";
    public static final String SYONO                    = "syono";
    public static final String HKNSYUKIGOU              = "hknsyukigou";
    public static final String HARAIKOMIKAISUKBN        = "haraikomikaisukbn";
    public static final String HRKKEIROKBN              = "hrkkeirokbn";
    public static final String ANNAIHUYOURIYUUKBN       = "annaihuyouriyuukbn";
    public static final String ZENNENDKURIKOSID         = "zennendkurikosid";
    public static final String TOUNENDOD                = "tounendod";
    public static final String TNDMATUTUMITATED         = "tndmatutumitated";
    public static final String TUMITATERISOKU           = "tumitaterisoku";
    public static final String HSYS                     = "hsys";
    public static final String SYURUICD1                = "syuruicd1";
    public static final String SYURUICD3                = "syuruicd3";
    public static final String SRUTIWAKE                = "srutiwake";
    public static final String SRKIJYUNYM               = "srkijyunym";
    public static final String KBNKEIRIYOUSEGMENTKBN    = "kbnkeiriyousegmentkbn";
    public static final String KBNKEIRIYOURGNBNSKKBN    = "kbnkeiriyourgnbnskkbn";
    public static final String SYURUICD2                = "syuruicd2";
    public static final String MANKITOURAIYM            = "mankitouraiym";
    public static final String SYUKEIYAKUSYURUICD       = "syukeiyakusyuruicd";
    public static final String KYKNENDO                 = "kyknendo";
    public static final String DAIHYOUYOTEIRIRITU       = "daihyouyoteiriritu";
    public static final String HARAIKATAKBN             = "haraikatakbn";
    public static final String YOBIV20                  = "yobiv20";
    public static final String SRHAITOUKINSYUUKEIPTNKBN = "srhaitoukinsyuukeiptnkbn";

    private final PKST_YuukoukykHtjynbknTmttd primaryKey;

    public GenST_YuukoukykHtjynbknTmttd() {
        primaryKey = new PKST_YuukoukykHtjynbknTmttd();
    }

    public GenST_YuukoukykHtjynbknTmttd(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pSrkijyunym
    ) {
        primaryKey = new PKST_YuukoukykHtjynbknTmttd(
            pSyoriYmd,
            pKakutyoujobcd,
            pSyono,
            pSrkijyunym
        );
    }

    @Transient
    @Override
    public PKST_YuukoukykHtjynbknTmttd getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QST_YuukoukykHtjynbknTmttd> getMetaClass() {
        return QST_YuukoukykHtjynbknTmttd.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenST_YuukoukykHtjynbknTmttd.SYORIYMD)
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
    @Column(name=GenST_YuukoukykHtjynbknTmttd.KAKUTYOUJOBCD)
    public String getKakutyoujobcd() {
        return getPrimaryKey().getKakutyoujobcd();
    }

    public void setKakutyoujobcd(String pKakutyoujobcd) {
        getPrimaryKey().setKakutyoujobcd(pKakutyoujobcd);
    }

    @Id
    @Column(name=GenST_YuukoukykHtjynbknTmttd.SYONO)
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

    @Column(name=GenST_YuukoukykHtjynbknTmttd.HKNSYUKIGOU)
    public String getHknsyukigou() {
        return hknsyukigou;
    }

    public void setHknsyukigou(String pHknsyukigou) {
        hknsyukigou = pHknsyukigou;
    }

    private String haraikomikaisukbn;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.HARAIKOMIKAISUKBN)
    public String getHaraikomikaisukbn() {
        return haraikomikaisukbn;
    }

    public void setHaraikomikaisukbn(String pHaraikomikaisukbn) {
        haraikomikaisukbn = pHaraikomikaisukbn;
    }

    private String hrkkeirokbn;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.HRKKEIROKBN)
    public String getHrkkeirokbn() {
        return hrkkeirokbn;
    }

    public void setHrkkeirokbn(String pHrkkeirokbn) {
        hrkkeirokbn = pHrkkeirokbn;
    }

    private String annaihuyouriyuukbn;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.ANNAIHUYOURIYUUKBN)
    public String getAnnaihuyouriyuukbn() {
        return annaihuyouriyuukbn;
    }

    public void setAnnaihuyouriyuukbn(String pAnnaihuyouriyuukbn) {
        annaihuyouriyuukbn = pAnnaihuyouriyuukbn;
    }

    private BizCurrency zennendkurikosid;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennendkurikosid() {
        return zennendkurikosid;
    }

    public void setZennendkurikosid(BizCurrency pZennendkurikosid) {
        zennendkurikosid = pZennendkurikosid;
        zennendkurikosidValue = null;
        zennendkurikosidType  = null;
    }

    transient private BigDecimal zennendkurikosidValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNENDKURIKOSID, nullable=true)
    protected BigDecimal getZennendkurikosidValue() {
        if (zennendkurikosidValue == null && zennendkurikosid != null) {
            if (zennendkurikosid.isOptional()) return null;
            return zennendkurikosid.absolute();
        }
        return zennendkurikosidValue;
    }

    protected void setZennendkurikosidValue(BigDecimal value) {
        zennendkurikosidValue = value;
        zennendkurikosid = Optional.fromNullable(toCurrencyType(zennendkurikosidType))
            .transform(bizCurrencyTransformer(getZennendkurikosidValue()))
            .orNull();
    }

    transient private String zennendkurikosidType = null;

    @Column(name=ZENNENDKURIKOSID + "$", nullable=true)
    protected String getZennendkurikosidType() {
        if (zennendkurikosidType == null && zennendkurikosid != null) return zennendkurikosid.getType().toString();
        if (zennendkurikosidType == null && getZennendkurikosidValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennendkurikosid$' should not be NULL."));
        }
        return zennendkurikosidType;
    }

    protected void setZennendkurikosidType(String type) {
        zennendkurikosidType = type;
        zennendkurikosid = Optional.fromNullable(toCurrencyType(zennendkurikosidType))
            .transform(bizCurrencyTransformer(getZennendkurikosidValue()))
            .orNull();
    }

    private BizCurrency tounendod;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTounendod() {
        return tounendod;
    }

    public void setTounendod(BizCurrency pTounendod) {
        tounendod = pTounendod;
        tounendodValue = null;
        tounendodType  = null;
    }

    transient private BigDecimal tounendodValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TOUNENDOD, nullable=true)
    protected BigDecimal getTounendodValue() {
        if (tounendodValue == null && tounendod != null) {
            if (tounendod.isOptional()) return null;
            return tounendod.absolute();
        }
        return tounendodValue;
    }

    protected void setTounendodValue(BigDecimal value) {
        tounendodValue = value;
        tounendod = Optional.fromNullable(toCurrencyType(tounendodType))
            .transform(bizCurrencyTransformer(getTounendodValue()))
            .orNull();
    }

    transient private String tounendodType = null;

    @Column(name=TOUNENDOD + "$", nullable=true)
    protected String getTounendodType() {
        if (tounendodType == null && tounendod != null) return tounendod.getType().toString();
        if (tounendodType == null && getTounendodValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tounendod$' should not be NULL."));
        }
        return tounendodType;
    }

    protected void setTounendodType(String type) {
        tounendodType = type;
        tounendod = Optional.fromNullable(toCurrencyType(tounendodType))
            .transform(bizCurrencyTransformer(getTounendodValue()))
            .orNull();
    }

    private BizCurrency tndmatutumitated;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTndmatutumitated() {
        return tndmatutumitated;
    }

    public void setTndmatutumitated(BizCurrency pTndmatutumitated) {
        tndmatutumitated = pTndmatutumitated;
        tndmatutumitatedValue = null;
        tndmatutumitatedType  = null;
    }

    transient private BigDecimal tndmatutumitatedValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TNDMATUTUMITATED, nullable=true)
    protected BigDecimal getTndmatutumitatedValue() {
        if (tndmatutumitatedValue == null && tndmatutumitated != null) {
            if (tndmatutumitated.isOptional()) return null;
            return tndmatutumitated.absolute();
        }
        return tndmatutumitatedValue;
    }

    protected void setTndmatutumitatedValue(BigDecimal value) {
        tndmatutumitatedValue = value;
        tndmatutumitated = Optional.fromNullable(toCurrencyType(tndmatutumitatedType))
            .transform(bizCurrencyTransformer(getTndmatutumitatedValue()))
            .orNull();
    }

    transient private String tndmatutumitatedType = null;

    @Column(name=TNDMATUTUMITATED + "$", nullable=true)
    protected String getTndmatutumitatedType() {
        if (tndmatutumitatedType == null && tndmatutumitated != null) return tndmatutumitated.getType().toString();
        if (tndmatutumitatedType == null && getTndmatutumitatedValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tndmatutumitated$' should not be NULL."));
        }
        return tndmatutumitatedType;
    }

    protected void setTndmatutumitatedType(String type) {
        tndmatutumitatedType = type;
        tndmatutumitated = Optional.fromNullable(toCurrencyType(tndmatutumitatedType))
            .transform(bizCurrencyTransformer(getTndmatutumitatedValue()))
            .orNull();
    }

    private BizCurrency tumitaterisoku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTumitaterisoku() {
        return tumitaterisoku;
    }

    public void setTumitaterisoku(BizCurrency pTumitaterisoku) {
        tumitaterisoku = pTumitaterisoku;
        tumitaterisokuValue = null;
        tumitaterisokuType  = null;
    }

    transient private BigDecimal tumitaterisokuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUMITATERISOKU, nullable=true)
    protected BigDecimal getTumitaterisokuValue() {
        if (tumitaterisokuValue == null && tumitaterisoku != null) {
            if (tumitaterisoku.isOptional()) return null;
            return tumitaterisoku.absolute();
        }
        return tumitaterisokuValue;
    }

    protected void setTumitaterisokuValue(BigDecimal value) {
        tumitaterisokuValue = value;
        tumitaterisoku = Optional.fromNullable(toCurrencyType(tumitaterisokuType))
            .transform(bizCurrencyTransformer(getTumitaterisokuValue()))
            .orNull();
    }

    transient private String tumitaterisokuType = null;

    @Column(name=TUMITATERISOKU + "$", nullable=true)
    protected String getTumitaterisokuType() {
        if (tumitaterisokuType == null && tumitaterisoku != null) return tumitaterisoku.getType().toString();
        if (tumitaterisokuType == null && getTumitaterisokuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tumitaterisoku$' should not be NULL."));
        }
        return tumitaterisokuType;
    }

    protected void setTumitaterisokuType(String type) {
        tumitaterisokuType = type;
        tumitaterisoku = Optional.fromNullable(toCurrencyType(tumitaterisokuType))
            .transform(bizCurrencyTransformer(getTumitaterisokuValue()))
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

    private String syuruicd1;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.SYURUICD1)
    public String getSyuruicd1() {
        return syuruicd1;
    }

    public void setSyuruicd1(String pSyuruicd1) {
        syuruicd1 = pSyuruicd1;
    }

    private String syuruicd3;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.SYURUICD3)
    public String getSyuruicd3() {
        return syuruicd3;
    }

    public void setSyuruicd3(String pSyuruicd3) {
        syuruicd3 = pSyuruicd3;
    }

    private String srutiwake;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.SRUTIWAKE)
    public String getSrutiwake() {
        return srutiwake;
    }

    public void setSrutiwake(String pSrutiwake) {
        srutiwake = pSrutiwake;
    }

    @Id
    @Column(name=GenST_YuukoukykHtjynbknTmttd.SRKIJYUNYM)
    public String getSrkijyunym() {
        return getPrimaryKey().getSrkijyunym();
    }

    public void setSrkijyunym(String pSrkijyunym) {
        getPrimaryKey().setSrkijyunym(pSrkijyunym);
    }

    private String kbnkeiriyousegmentkbn;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.KBNKEIRIYOUSEGMENTKBN)
    public String getKbnkeiriyousegmentkbn() {
        return kbnkeiriyousegmentkbn;
    }

    public void setKbnkeiriyousegmentkbn(String pKbnkeiriyousegmentkbn) {
        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
    }

    private String kbnkeiriyourgnbnskkbn;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.KBNKEIRIYOURGNBNSKKBN)
    public String getKbnkeiriyourgnbnskkbn() {
        return kbnkeiriyourgnbnskkbn;
    }

    public void setKbnkeiriyourgnbnskkbn(String pKbnkeiriyourgnbnskkbn) {
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
    }

    private String syuruicd2;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.SYURUICD2)
    public String getSyuruicd2() {
        return syuruicd2;
    }

    public void setSyuruicd2(String pSyuruicd2) {
        syuruicd2 = pSyuruicd2;
    }

    private BizDateYM mankitouraiym;

    @Type(type="BizDateYMType")
    @Column(name=GenST_YuukoukykHtjynbknTmttd.MANKITOURAIYM)
    public BizDateYM getMankitouraiym() {
        return mankitouraiym;
    }

    public void setMankitouraiym(BizDateYM pMankitouraiym) {
        mankitouraiym = pMankitouraiym;
    }

    private String syukeiyakusyuruicd;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.SYUKEIYAKUSYURUICD)
    public String getSyukeiyakusyuruicd() {
        return syukeiyakusyuruicd;
    }

    public void setSyukeiyakusyuruicd(String pSyukeiyakusyuruicd) {
        syukeiyakusyuruicd = pSyukeiyakusyuruicd;
    }

    private String kyknendo;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.KYKNENDO)
    public String getKyknendo() {
        return kyknendo;
    }

    public void setKyknendo(String pKyknendo) {
        kyknendo = pKyknendo;
    }

    private BizNumber daihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_YuukoukykHtjynbknTmttd.DAIHYOUYOTEIRIRITU)
    public BizNumber getDaihyouyoteiriritu() {
        return daihyouyoteiriritu;
    }

    public void setDaihyouyoteiriritu(BizNumber pDaihyouyoteiriritu) {
        daihyouyoteiriritu = pDaihyouyoteiriritu;
    }

    private String haraikatakbn;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.HARAIKATAKBN)
    public String getHaraikatakbn() {
        return haraikatakbn;
    }

    public void setHaraikatakbn(String pHaraikatakbn) {
        haraikatakbn = pHaraikatakbn;
    }

    private String yobiv20;

    @Column(name=GenST_YuukoukykHtjynbknTmttd.YOBIV20)
    public String getYobiv20() {
        return yobiv20;
    }

    public void setYobiv20(String pYobiv20) {
        yobiv20 = pYobiv20;
    }

    private C_SrHaitoukinSyuukeiPtnKbn srhaitoukinsyuukeiptnkbn;

    @Type(type="UserType_C_SrHaitoukinSyuukeiPtnKbn")
    @Column(name=GenST_YuukoukykHtjynbknTmttd.SRHAITOUKINSYUUKEIPTNKBN)
    public C_SrHaitoukinSyuukeiPtnKbn getSrhaitoukinsyuukeiptnkbn() {
        return srhaitoukinsyuukeiptnkbn;
    }

    public void setSrhaitoukinsyuukeiptnkbn(C_SrHaitoukinSyuukeiPtnKbn pSrhaitoukinsyuukeiptnkbn) {
        srhaitoukinsyuukeiptnkbn = pSrhaitoukinsyuukeiptnkbn;
    }
}