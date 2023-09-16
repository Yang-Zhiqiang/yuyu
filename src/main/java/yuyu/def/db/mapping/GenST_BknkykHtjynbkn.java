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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ST_BknkykHtjynbkn;
import yuyu.def.db.id.PKST_BknkykHtjynbkn;
import yuyu.def.db.meta.GenQST_BknkykHtjynbkn;
import yuyu.def.db.meta.QST_BknkykHtjynbkn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 備金契約配当準備金テーブル テーブルのマッピング情報クラスで、 {@link ST_BknkykHtjynbkn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_BknkykHtjynbkn}</td><td colspan="3">備金契約配当準備金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKST_BknkykHtjynbkn ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKakutyoujobcd kakutyoujobcd}</td><td>拡張ジョブコード</td><td align="center">{@link PKST_BknkykHtjynbkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKST_BknkykHtjynbkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyukigou hknsyukigou}</td><td>保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaraikomikaisukbn haraikomikaisukbn}</td><td>払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkeirokbn hrkkeirokbn}</td><td>払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAnnaihuyouriyuukbn annaihuyouriyuukbn}</td><td>案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikinkbn bikinkbn}</td><td>備金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikinnendokbn bikinnendokbn}</td><td>備金年度区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeisand seisand}</td><td>精算Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTumitaterisoku tumitaterisoku}</td><td>積立利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyuruicd1 syuruicd1}</td><td>種類コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyuruicd3 syuruicd3}</td><td>種類コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSrkijyunym srkijyunym}</td><td>数理用基準年月</td><td align="center">{@link PKST_BknkykHtjynbkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeiriyousegmentkbn kbnkeiriyousegmentkbn}</td><td>区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeiriyourgnbnskkbn kbnkeiriyourgnbnskkbn}</td><td>区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyuruicd2 syuruicd2}</td><td>種類コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKariwariatedganrikin kariwariatedganrikin}</td><td>仮割当Ｄ元利金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKariwariatedrisoku kariwariatedrisoku}</td><td>仮割当Ｄ利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukeiyakusyuruicd syukeiyakusyuruicd}</td><td>主契約種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknendo kyknendo}</td><td>契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaihyouyoteiriritu daihyouyoteiriritu}</td><td>代表予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHaraikatakbn haraikatakbn}</td><td>払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYobiv32 yobiv32}</td><td>予備項目Ｖ３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_BknkykHtjynbkn
 * @see     PKST_BknkykHtjynbkn
 * @see     QST_BknkykHtjynbkn
 * @see     GenQST_BknkykHtjynbkn
 */
@MappedSuperclass
@Table(name=GenST_BknkykHtjynbkn.TABLE_NAME)
@IdClass(value=PKST_BknkykHtjynbkn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenST_BknkykHtjynbkn extends AbstractExDBEntity<ST_BknkykHtjynbkn, PKST_BknkykHtjynbkn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ST_BknkykHtjynbkn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String KAKUTYOUJOBCD            = "kakutyoujobcd";
    public static final String SYONO                    = "syono";
    public static final String HKNSYUKIGOU              = "hknsyukigou";
    public static final String HARAIKOMIKAISUKBN        = "haraikomikaisukbn";
    public static final String HRKKEIROKBN              = "hrkkeirokbn";
    public static final String ANNAIHUYOURIYUUKBN       = "annaihuyouriyuukbn";
    public static final String BIKINKBN                 = "bikinkbn";
    public static final String BIKINNENDOKBN            = "bikinnendokbn";
    public static final String SEISAND                  = "seisand";
    public static final String TUMITATERISOKU           = "tumitaterisoku";
    public static final String SYURUICD1                = "syuruicd1";
    public static final String SYURUICD3                = "syuruicd3";
    public static final String SRKIJYUNYM               = "srkijyunym";
    public static final String KBNKEIRIYOUSEGMENTKBN    = "kbnkeiriyousegmentkbn";
    public static final String KBNKEIRIYOURGNBNSKKBN    = "kbnkeiriyourgnbnskkbn";
    public static final String SYURUICD2                = "syuruicd2";
    public static final String KARIWARIATEDGANRIKIN     = "kariwariatedganrikin";
    public static final String KARIWARIATEDRISOKU       = "kariwariatedrisoku";
    public static final String SYUKEIYAKUSYURUICD       = "syukeiyakusyuruicd";
    public static final String KYKNENDO                 = "kyknendo";
    public static final String DAIHYOUYOTEIRIRITU       = "daihyouyoteiriritu";
    public static final String HARAIKATAKBN             = "haraikatakbn";
    public static final String YOBIV32                  = "yobiv32";

    private final PKST_BknkykHtjynbkn primaryKey;

    public GenST_BknkykHtjynbkn() {
        primaryKey = new PKST_BknkykHtjynbkn();
    }

    public GenST_BknkykHtjynbkn(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pSrkijyunym
    ) {
        primaryKey = new PKST_BknkykHtjynbkn(
            pSyoriYmd,
            pKakutyoujobcd,
            pSyono,
            pSrkijyunym
        );
    }

    @Transient
    @Override
    public PKST_BknkykHtjynbkn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QST_BknkykHtjynbkn> getMetaClass() {
        return QST_BknkykHtjynbkn.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenST_BknkykHtjynbkn.SYORIYMD)
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
    @Column(name=GenST_BknkykHtjynbkn.KAKUTYOUJOBCD)
    public String getKakutyoujobcd() {
        return getPrimaryKey().getKakutyoujobcd();
    }

    public void setKakutyoujobcd(String pKakutyoujobcd) {
        getPrimaryKey().setKakutyoujobcd(pKakutyoujobcd);
    }

    @Id
    @Column(name=GenST_BknkykHtjynbkn.SYONO)
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

    @Column(name=GenST_BknkykHtjynbkn.HKNSYUKIGOU)
    public String getHknsyukigou() {
        return hknsyukigou;
    }

    public void setHknsyukigou(String pHknsyukigou) {
        hknsyukigou = pHknsyukigou;
    }

    private String haraikomikaisukbn;

    @Column(name=GenST_BknkykHtjynbkn.HARAIKOMIKAISUKBN)
    public String getHaraikomikaisukbn() {
        return haraikomikaisukbn;
    }

    public void setHaraikomikaisukbn(String pHaraikomikaisukbn) {
        haraikomikaisukbn = pHaraikomikaisukbn;
    }

    private String hrkkeirokbn;

    @Column(name=GenST_BknkykHtjynbkn.HRKKEIROKBN)
    public String getHrkkeirokbn() {
        return hrkkeirokbn;
    }

    public void setHrkkeirokbn(String pHrkkeirokbn) {
        hrkkeirokbn = pHrkkeirokbn;
    }

    private String annaihuyouriyuukbn;

    @Column(name=GenST_BknkykHtjynbkn.ANNAIHUYOURIYUUKBN)
    public String getAnnaihuyouriyuukbn() {
        return annaihuyouriyuukbn;
    }

    public void setAnnaihuyouriyuukbn(String pAnnaihuyouriyuukbn) {
        annaihuyouriyuukbn = pAnnaihuyouriyuukbn;
    }

    private String bikinkbn;

    @Column(name=GenST_BknkykHtjynbkn.BIKINKBN)
    public String getBikinkbn() {
        return bikinkbn;
    }

    public void setBikinkbn(String pBikinkbn) {
        bikinkbn = pBikinkbn;
    }

    private String bikinnendokbn;

    @Column(name=GenST_BknkykHtjynbkn.BIKINNENDOKBN)
    public String getBikinnendokbn() {
        return bikinnendokbn;
    }

    public void setBikinnendokbn(String pBikinnendokbn) {
        bikinnendokbn = pBikinnendokbn;
    }

    private BizCurrency seisand;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeisand() {
        return seisand;
    }

    public void setSeisand(BizCurrency pSeisand) {
        seisand = pSeisand;
        seisandValue = null;
        seisandType  = null;
    }

    transient private BigDecimal seisandValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEISAND, nullable=true)
    protected BigDecimal getSeisandValue() {
        if (seisandValue == null && seisand != null) {
            if (seisand.isOptional()) return null;
            return seisand.absolute();
        }
        return seisandValue;
    }

    protected void setSeisandValue(BigDecimal value) {
        seisandValue = value;
        seisand = Optional.fromNullable(toCurrencyType(seisandType))
            .transform(bizCurrencyTransformer(getSeisandValue()))
            .orNull();
    }

    transient private String seisandType = null;

    @Column(name=SEISAND + "$", nullable=true)
    protected String getSeisandType() {
        if (seisandType == null && seisand != null) return seisand.getType().toString();
        if (seisandType == null && getSeisandValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seisand$' should not be NULL."));
        }
        return seisandType;
    }

    protected void setSeisandType(String type) {
        seisandType = type;
        seisand = Optional.fromNullable(toCurrencyType(seisandType))
            .transform(bizCurrencyTransformer(getSeisandValue()))
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

    private String syuruicd1;

    @Column(name=GenST_BknkykHtjynbkn.SYURUICD1)
    public String getSyuruicd1() {
        return syuruicd1;
    }

    public void setSyuruicd1(String pSyuruicd1) {
        syuruicd1 = pSyuruicd1;
    }

    private String syuruicd3;

    @Column(name=GenST_BknkykHtjynbkn.SYURUICD3)
    public String getSyuruicd3() {
        return syuruicd3;
    }

    public void setSyuruicd3(String pSyuruicd3) {
        syuruicd3 = pSyuruicd3;
    }

    @Id
    @Column(name=GenST_BknkykHtjynbkn.SRKIJYUNYM)
    public String getSrkijyunym() {
        return getPrimaryKey().getSrkijyunym();
    }

    public void setSrkijyunym(String pSrkijyunym) {
        getPrimaryKey().setSrkijyunym(pSrkijyunym);
    }

    private String kbnkeiriyousegmentkbn;

    @Column(name=GenST_BknkykHtjynbkn.KBNKEIRIYOUSEGMENTKBN)
    public String getKbnkeiriyousegmentkbn() {
        return kbnkeiriyousegmentkbn;
    }

    public void setKbnkeiriyousegmentkbn(String pKbnkeiriyousegmentkbn) {
        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
    }

    private String kbnkeiriyourgnbnskkbn;

    @Column(name=GenST_BknkykHtjynbkn.KBNKEIRIYOURGNBNSKKBN)
    public String getKbnkeiriyourgnbnskkbn() {
        return kbnkeiriyourgnbnskkbn;
    }

    public void setKbnkeiriyourgnbnskkbn(String pKbnkeiriyourgnbnskkbn) {
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
    }

    private String syuruicd2;

    @Column(name=GenST_BknkykHtjynbkn.SYURUICD2)
    public String getSyuruicd2() {
        return syuruicd2;
    }

    public void setSyuruicd2(String pSyuruicd2) {
        syuruicd2 = pSyuruicd2;
    }

    private BizCurrency kariwariatedganrikin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKariwariatedganrikin() {
        return kariwariatedganrikin;
    }

    public void setKariwariatedganrikin(BizCurrency pKariwariatedganrikin) {
        kariwariatedganrikin = pKariwariatedganrikin;
        kariwariatedganrikinValue = null;
        kariwariatedganrikinType  = null;
    }

    transient private BigDecimal kariwariatedganrikinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KARIWARIATEDGANRIKIN, nullable=true)
    protected BigDecimal getKariwariatedganrikinValue() {
        if (kariwariatedganrikinValue == null && kariwariatedganrikin != null) {
            if (kariwariatedganrikin.isOptional()) return null;
            return kariwariatedganrikin.absolute();
        }
        return kariwariatedganrikinValue;
    }

    protected void setKariwariatedganrikinValue(BigDecimal value) {
        kariwariatedganrikinValue = value;
        kariwariatedganrikin = Optional.fromNullable(toCurrencyType(kariwariatedganrikinType))
            .transform(bizCurrencyTransformer(getKariwariatedganrikinValue()))
            .orNull();
    }

    transient private String kariwariatedganrikinType = null;

    @Column(name=KARIWARIATEDGANRIKIN + "$", nullable=true)
    protected String getKariwariatedganrikinType() {
        if (kariwariatedganrikinType == null && kariwariatedganrikin != null) return kariwariatedganrikin.getType().toString();
        if (kariwariatedganrikinType == null && getKariwariatedganrikinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kariwariatedganrikin$' should not be NULL."));
        }
        return kariwariatedganrikinType;
    }

    protected void setKariwariatedganrikinType(String type) {
        kariwariatedganrikinType = type;
        kariwariatedganrikin = Optional.fromNullable(toCurrencyType(kariwariatedganrikinType))
            .transform(bizCurrencyTransformer(getKariwariatedganrikinValue()))
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

    private String syukeiyakusyuruicd;

    @Column(name=GenST_BknkykHtjynbkn.SYUKEIYAKUSYURUICD)
    public String getSyukeiyakusyuruicd() {
        return syukeiyakusyuruicd;
    }

    public void setSyukeiyakusyuruicd(String pSyukeiyakusyuruicd) {
        syukeiyakusyuruicd = pSyukeiyakusyuruicd;
    }

    private String kyknendo;

    @Column(name=GenST_BknkykHtjynbkn.KYKNENDO)
    public String getKyknendo() {
        return kyknendo;
    }

    public void setKyknendo(String pKyknendo) {
        kyknendo = pKyknendo;
    }

    private BizNumber daihyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_BknkykHtjynbkn.DAIHYOUYOTEIRIRITU)
    public BizNumber getDaihyouyoteiriritu() {
        return daihyouyoteiriritu;
    }

    public void setDaihyouyoteiriritu(BizNumber pDaihyouyoteiriritu) {
        daihyouyoteiriritu = pDaihyouyoteiriritu;
    }

    private String haraikatakbn;

    @Column(name=GenST_BknkykHtjynbkn.HARAIKATAKBN)
    public String getHaraikatakbn() {
        return haraikatakbn;
    }

    public void setHaraikatakbn(String pHaraikatakbn) {
        haraikatakbn = pHaraikatakbn;
    }

    private String yobiv32;

    @Column(name=GenST_BknkykHtjynbkn.YOBIV32)
    public String getYobiv32() {
        return yobiv32;
    }

    public void setYobiv32(String pYobiv32) {
        yobiv32 = pYobiv32;
    }
}