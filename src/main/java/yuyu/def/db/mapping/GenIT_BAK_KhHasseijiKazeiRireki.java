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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HasseijikazeisyoriKbn;
import yuyu.def.classification.C_HasseijikngksyuruiKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.IT_BAK_KhHasseijiKazeiRireki;
import yuyu.def.db.id.PKIT_BAK_KhHasseijiKazeiRireki;
import yuyu.def.db.meta.GenQIT_BAK_KhHasseijiKazeiRireki;
import yuyu.def.db.meta.QIT_BAK_KhHasseijiKazeiRireki;
import yuyu.def.db.type.UserType_C_HasseijikazeisyoriKbn;
import yuyu.def.db.type.UserType_C_HasseijikngksyuruiKbn;
import yuyu.def.db.type.UserType_C_HtsiryosyuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全発生時課税履歴バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KhHasseijiKazeiRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhHasseijiKazeiRireki}</td><td colspan="3">契約保全発生時課税履歴バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KhHasseijiKazeiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KhHasseijiKazeiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KhHasseijiKazeiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_BAK_KhHasseijiKazeiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHasseijikazeisyorikbn hasseijikazeisyorikbn}</td><td>発生時課税処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HasseijikazeisyoriKbn}</td></tr>
 *  <tr><td>{@link #getTorikesiflg torikesiflg}</td><td>取消フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTorikesiymd torikesiymd}</td><td>取消日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZeitratkikbn zeitratkikbn}</td><td>税取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZeitratkiKbn}</td></tr>
 *  <tr><td>{@link #getGsbunritaisyou gsbunritaisyou}</td><td>源泉分離課税対象</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHasseijikngksyuruikbn hasseijikngksyuruikbn}</td><td>発生時金額種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HasseijikngksyuruiKbn}</td></tr>
 *  <tr><td>{@link #getHasseijikngk hasseijikngk}</td><td>発生時金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHasseijigstszeigk hasseijigstszeigk}</td><td>発生時源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansangkgoukei yenkansangkgoukei}</td><td>円換算額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansansyukngkgoukei yenkansansyukngkgoukei}</td><td>円換算主たる金額小計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYengstszeigk yengstszeigk}</td><td>円換算源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYengstszeigknationaltax yengstszeigknationaltax}</td><td>円換算源泉徴収税額（国税）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYengstszeigklocaltax yengstszeigklocaltax}</td><td>円換算源泉徴収税額（地方税）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNztodouhukencd nztodouhukencd}</td><td>納税先都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtykeihi htykeihi}</td><td>必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKztgk kztgk}</td><td>課税対象額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenhtykeihi yenhtykeihi}</td><td>円換算必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkztgk yenkztgk}</td><td>円換算課税対象額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZeimukwsratekjnymd zeimukwsratekjnymd}</td><td>税務用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZeimukwsrate zeimukwsrate}</td><td>税務用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykyno kykyno}</td><td>契約者郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykadr1kj kykadr1kj}</td><td>契約者住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykadr2kj kykadr2kj}</td><td>契約者住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykadr3kj kykadr3kj}</td><td>契約者住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykmnmeigibangou kykmnmeigibangou}</td><td>契約者ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktmnmeigibangou uktmnmeigibangou}</td><td>受取人ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrtysysyuruikbn shrtysysyuruikbn}</td><td>支払調書種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HtsiryosyuKbn}</td></tr>
 *  <tr><td>{@link #getYenshrkykhtykeihi yenshrkykhtykeihi}</td><td>円換算支払時契約者必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKykhnkkaisuu kykhnkkaisuu}</td><td>契約者変更回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KhHasseijiKazeiRireki
 * @see     PKIT_BAK_KhHasseijiKazeiRireki
 * @see     QIT_BAK_KhHasseijiKazeiRireki
 * @see     GenQIT_BAK_KhHasseijiKazeiRireki
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KhHasseijiKazeiRireki.TABLE_NAME)
@IdClass(value=PKIT_BAK_KhHasseijiKazeiRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HasseijikazeisyoriKbn", typeClass=UserType_C_HasseijikazeisyoriKbn.class),
    @TypeDef(name="UserType_C_HasseijikngksyuruiKbn", typeClass=UserType_C_HasseijikngksyuruiKbn.class),
    @TypeDef(name="UserType_C_HtsiryosyuKbn", typeClass=UserType_C_HtsiryosyuKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_ZeitratkiKbn", typeClass=UserType_C_ZeitratkiKbn.class)
})
public abstract class GenIT_BAK_KhHasseijiKazeiRireki extends AbstractExDBEntity<IT_BAK_KhHasseijiKazeiRireki, PKIT_BAK_KhHasseijiKazeiRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KhHasseijiKazeiRireki";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String HASSEIJIKAZEISYORIKBN    = "hasseijikazeisyorikbn";
    public static final String TORIKESIFLG              = "torikesiflg";
    public static final String TORIKESIYMD              = "torikesiymd";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String ZEITRATKIKBN             = "zeitratkikbn";
    public static final String GSBUNRITAISYOU           = "gsbunritaisyou";
    public static final String HASSEIJIKNGKSYURUIKBN    = "hasseijikngksyuruikbn";
    public static final String HASSEIJIKNGK             = "hasseijikngk";
    public static final String HASSEIJIGSTSZEIGK        = "hasseijigstszeigk";
    public static final String YENKANSANGKGOUKEI        = "yenkansangkgoukei";
    public static final String YENKANSANSYUKNGKGOUKEI   = "yenkansansyukngkgoukei";
    public static final String YENGSTSZEIGK             = "yengstszeigk";
    public static final String YENGSTSZEIGKNATIONALTAX  = "yengstszeigknationaltax";
    public static final String YENGSTSZEIGKLOCALTAX     = "yengstszeigklocaltax";
    public static final String NZTODOUHUKENCD           = "nztodouhukencd";
    public static final String HTYKEIHI                 = "htykeihi";
    public static final String KZTGK                    = "kztgk";
    public static final String YENHTYKEIHI              = "yenhtykeihi";
    public static final String YENKZTGK                 = "yenkztgk";
    public static final String ZEIMUKWSRATEKJNYMD       = "zeimukwsratekjnymd";
    public static final String ZEIMUKWSRATE             = "zeimukwsrate";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKYNO                   = "kykyno";
    public static final String KYKADR1KJ                = "kykadr1kj";
    public static final String KYKADR2KJ                = "kykadr2kj";
    public static final String KYKADR3KJ                = "kykadr3kj";
    public static final String KYKMNMEIGIBANGOU         = "kykmnmeigibangou";
    public static final String UKTMNMEIGIBANGOU         = "uktmnmeigibangou";
    public static final String SHRTYSYSYURUIKBN         = "shrtysysyuruikbn";
    public static final String YENSHRKYKHTYKEIHI        = "yenshrkykhtykeihi";
    public static final String KYKHNKKAISUU             = "kykhnkkaisuu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_KhHasseijiKazeiRireki primaryKey;

    public GenIT_BAK_KhHasseijiKazeiRireki() {
        primaryKey = new PKIT_BAK_KhHasseijiKazeiRireki();
    }

    public GenIT_BAK_KhHasseijiKazeiRireki(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_BAK_KhHasseijiKazeiRireki(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KhHasseijiKazeiRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KhHasseijiKazeiRireki> getMetaClass() {
        return QIT_BAK_KhHasseijiKazeiRireki.class;
    }

    @Id
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.SYONO)
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
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_HasseijikazeisyoriKbn hasseijikazeisyorikbn;

    @Type(type="UserType_C_HasseijikazeisyoriKbn")
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.HASSEIJIKAZEISYORIKBN)
    public C_HasseijikazeisyoriKbn getHasseijikazeisyorikbn() {
        return hasseijikazeisyorikbn;
    }

    public void setHasseijikazeisyorikbn(C_HasseijikazeisyoriKbn pHasseijikazeisyorikbn) {
        hasseijikazeisyorikbn = pHasseijikazeisyorikbn;
    }

    private C_UmuKbn torikesiflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.TORIKESIFLG)
    public C_UmuKbn getTorikesiflg() {
        return torikesiflg;
    }

    public void setTorikesiflg(C_UmuKbn pTorikesiflg) {
        torikesiflg = pTorikesiflg;
    }

    private BizDate torikesiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.TORIKESIYMD)
    public BizDate getTorikesiymd() {
        return torikesiymd;
    }

    @Trim("both")
    public void setTorikesiymd(BizDate pTorikesiymd) {
        torikesiymd = pTorikesiymd;
    }

    private BizDate kouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private C_ZeitratkiKbn zeitratkikbn;

    @Type(type="UserType_C_ZeitratkiKbn")
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.ZEITRATKIKBN)
    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn) {
        zeitratkikbn = pZeitratkikbn;
    }

    private C_UmuKbn gsbunritaisyou;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.GSBUNRITAISYOU)
    public C_UmuKbn getGsbunritaisyou() {
        return gsbunritaisyou;
    }

    public void setGsbunritaisyou(C_UmuKbn pGsbunritaisyou) {
        gsbunritaisyou = pGsbunritaisyou;
    }

    private C_HasseijikngksyuruiKbn hasseijikngksyuruikbn;

    @Type(type="UserType_C_HasseijikngksyuruiKbn")
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.HASSEIJIKNGKSYURUIKBN)
    public C_HasseijikngksyuruiKbn getHasseijikngksyuruikbn() {
        return hasseijikngksyuruikbn;
    }

    public void setHasseijikngksyuruikbn(C_HasseijikngksyuruiKbn pHasseijikngksyuruikbn) {
        hasseijikngksyuruikbn = pHasseijikngksyuruikbn;
    }

    private BizCurrency hasseijikngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHasseijikngk() {
        return hasseijikngk;
    }

    public void setHasseijikngk(BizCurrency pHasseijikngk) {
        hasseijikngk = pHasseijikngk;
        hasseijikngkValue = null;
        hasseijikngkType  = null;
    }

    transient private BigDecimal hasseijikngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HASSEIJIKNGK, nullable=true)
    protected BigDecimal getHasseijikngkValue() {
        if (hasseijikngkValue == null && hasseijikngk != null) {
            if (hasseijikngk.isOptional()) return null;
            return hasseijikngk.absolute();
        }
        return hasseijikngkValue;
    }

    protected void setHasseijikngkValue(BigDecimal value) {
        hasseijikngkValue = value;
        hasseijikngk = Optional.fromNullable(toCurrencyType(hasseijikngkType))
            .transform(bizCurrencyTransformer(getHasseijikngkValue()))
            .orNull();
    }

    transient private String hasseijikngkType = null;

    @Column(name=HASSEIJIKNGK + "$", nullable=true)
    protected String getHasseijikngkType() {
        if (hasseijikngkType == null && hasseijikngk != null) return hasseijikngk.getType().toString();
        if (hasseijikngkType == null && getHasseijikngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hasseijikngk$' should not be NULL."));
        }
        return hasseijikngkType;
    }

    protected void setHasseijikngkType(String type) {
        hasseijikngkType = type;
        hasseijikngk = Optional.fromNullable(toCurrencyType(hasseijikngkType))
            .transform(bizCurrencyTransformer(getHasseijikngkValue()))
            .orNull();
    }

    private BizCurrency hasseijigstszeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHasseijigstszeigk() {
        return hasseijigstszeigk;
    }

    public void setHasseijigstszeigk(BizCurrency pHasseijigstszeigk) {
        hasseijigstszeigk = pHasseijigstszeigk;
        hasseijigstszeigkValue = null;
        hasseijigstszeigkType  = null;
    }

    transient private BigDecimal hasseijigstszeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HASSEIJIGSTSZEIGK, nullable=true)
    protected BigDecimal getHasseijigstszeigkValue() {
        if (hasseijigstszeigkValue == null && hasseijigstszeigk != null) {
            if (hasseijigstszeigk.isOptional()) return null;
            return hasseijigstszeigk.absolute();
        }
        return hasseijigstszeigkValue;
    }

    protected void setHasseijigstszeigkValue(BigDecimal value) {
        hasseijigstszeigkValue = value;
        hasseijigstszeigk = Optional.fromNullable(toCurrencyType(hasseijigstszeigkType))
            .transform(bizCurrencyTransformer(getHasseijigstszeigkValue()))
            .orNull();
    }

    transient private String hasseijigstszeigkType = null;

    @Column(name=HASSEIJIGSTSZEIGK + "$", nullable=true)
    protected String getHasseijigstszeigkType() {
        if (hasseijigstszeigkType == null && hasseijigstszeigk != null) return hasseijigstszeigk.getType().toString();
        if (hasseijigstszeigkType == null && getHasseijigstszeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hasseijigstszeigk$' should not be NULL."));
        }
        return hasseijigstszeigkType;
    }

    protected void setHasseijigstszeigkType(String type) {
        hasseijigstszeigkType = type;
        hasseijigstszeigk = Optional.fromNullable(toCurrencyType(hasseijigstszeigkType))
            .transform(bizCurrencyTransformer(getHasseijigstszeigkValue()))
            .orNull();
    }

    private BizCurrency yenkansangkgoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkansangkgoukei() {
        return yenkansangkgoukei;
    }

    public void setYenkansangkgoukei(BizCurrency pYenkansangkgoukei) {
        yenkansangkgoukei = pYenkansangkgoukei;
        yenkansangkgoukeiValue = null;
        yenkansangkgoukeiType  = null;
    }

    transient private BigDecimal yenkansangkgoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKANSANGKGOUKEI, nullable=true)
    protected BigDecimal getYenkansangkgoukeiValue() {
        if (yenkansangkgoukeiValue == null && yenkansangkgoukei != null) {
            if (yenkansangkgoukei.isOptional()) return null;
            return yenkansangkgoukei.absolute();
        }
        return yenkansangkgoukeiValue;
    }

    protected void setYenkansangkgoukeiValue(BigDecimal value) {
        yenkansangkgoukeiValue = value;
        yenkansangkgoukei = Optional.fromNullable(toCurrencyType(yenkansangkgoukeiType))
            .transform(bizCurrencyTransformer(getYenkansangkgoukeiValue()))
            .orNull();
    }

    transient private String yenkansangkgoukeiType = null;

    @Column(name=YENKANSANGKGOUKEI + "$", nullable=true)
    protected String getYenkansangkgoukeiType() {
        if (yenkansangkgoukeiType == null && yenkansangkgoukei != null) return yenkansangkgoukei.getType().toString();
        if (yenkansangkgoukeiType == null && getYenkansangkgoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkansangkgoukei$' should not be NULL."));
        }
        return yenkansangkgoukeiType;
    }

    protected void setYenkansangkgoukeiType(String type) {
        yenkansangkgoukeiType = type;
        yenkansangkgoukei = Optional.fromNullable(toCurrencyType(yenkansangkgoukeiType))
            .transform(bizCurrencyTransformer(getYenkansangkgoukeiValue()))
            .orNull();
    }

    private BizCurrency yenkansansyukngkgoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkansansyukngkgoukei() {
        return yenkansansyukngkgoukei;
    }

    public void setYenkansansyukngkgoukei(BizCurrency pYenkansansyukngkgoukei) {
        yenkansansyukngkgoukei = pYenkansansyukngkgoukei;
        yenkansansyukngkgoukeiValue = null;
        yenkansansyukngkgoukeiType  = null;
    }

    transient private BigDecimal yenkansansyukngkgoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKANSANSYUKNGKGOUKEI, nullable=true)
    protected BigDecimal getYenkansansyukngkgoukeiValue() {
        if (yenkansansyukngkgoukeiValue == null && yenkansansyukngkgoukei != null) {
            if (yenkansansyukngkgoukei.isOptional()) return null;
            return yenkansansyukngkgoukei.absolute();
        }
        return yenkansansyukngkgoukeiValue;
    }

    protected void setYenkansansyukngkgoukeiValue(BigDecimal value) {
        yenkansansyukngkgoukeiValue = value;
        yenkansansyukngkgoukei = Optional.fromNullable(toCurrencyType(yenkansansyukngkgoukeiType))
            .transform(bizCurrencyTransformer(getYenkansansyukngkgoukeiValue()))
            .orNull();
    }

    transient private String yenkansansyukngkgoukeiType = null;

    @Column(name=YENKANSANSYUKNGKGOUKEI + "$", nullable=true)
    protected String getYenkansansyukngkgoukeiType() {
        if (yenkansansyukngkgoukeiType == null && yenkansansyukngkgoukei != null) return yenkansansyukngkgoukei.getType().toString();
        if (yenkansansyukngkgoukeiType == null && getYenkansansyukngkgoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkansansyukngkgoukei$' should not be NULL."));
        }
        return yenkansansyukngkgoukeiType;
    }

    protected void setYenkansansyukngkgoukeiType(String type) {
        yenkansansyukngkgoukeiType = type;
        yenkansansyukngkgoukei = Optional.fromNullable(toCurrencyType(yenkansansyukngkgoukeiType))
            .transform(bizCurrencyTransformer(getYenkansansyukngkgoukeiValue()))
            .orNull();
    }

    private BizCurrency yengstszeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYengstszeigk() {
        return yengstszeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYengstszeigk(BizCurrency pYengstszeigk) {
        yengstszeigk = pYengstszeigk;
        yengstszeigkValue = null;
        yengstszeigkType  = null;
    }

    transient private BigDecimal yengstszeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENGSTSZEIGK, nullable=true)
    protected BigDecimal getYengstszeigkValue() {
        if (yengstszeigkValue == null && yengstszeigk != null) {
            if (yengstszeigk.isOptional()) return null;
            return yengstszeigk.absolute();
        }
        return yengstszeigkValue;
    }

    protected void setYengstszeigkValue(BigDecimal value) {
        yengstszeigkValue = value;
        yengstszeigk = Optional.fromNullable(toCurrencyType(yengstszeigkType))
            .transform(bizCurrencyTransformer(getYengstszeigkValue()))
            .orNull();
    }

    transient private String yengstszeigkType = null;

    @Column(name=YENGSTSZEIGK + "$", nullable=true)
    protected String getYengstszeigkType() {
        if (yengstszeigkType == null && yengstszeigk != null) return yengstszeigk.getType().toString();
        if (yengstszeigkType == null && getYengstszeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yengstszeigk$' should not be NULL."));
        }
        return yengstszeigkType;
    }

    protected void setYengstszeigkType(String type) {
        yengstszeigkType = type;
        yengstszeigk = Optional.fromNullable(toCurrencyType(yengstszeigkType))
            .transform(bizCurrencyTransformer(getYengstszeigkValue()))
            .orNull();
    }

    private BizCurrency yengstszeigknationaltax;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYengstszeigknationaltax() {
        return yengstszeigknationaltax;
    }

    public void setYengstszeigknationaltax(BizCurrency pYengstszeigknationaltax) {
        yengstszeigknationaltax = pYengstszeigknationaltax;
        yengstszeigknationaltaxValue = null;
        yengstszeigknationaltaxType  = null;
    }

    transient private BigDecimal yengstszeigknationaltaxValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENGSTSZEIGKNATIONALTAX, nullable=true)
    protected BigDecimal getYengstszeigknationaltaxValue() {
        if (yengstszeigknationaltaxValue == null && yengstszeigknationaltax != null) {
            if (yengstszeigknationaltax.isOptional()) return null;
            return yengstszeigknationaltax.absolute();
        }
        return yengstszeigknationaltaxValue;
    }

    protected void setYengstszeigknationaltaxValue(BigDecimal value) {
        yengstszeigknationaltaxValue = value;
        yengstszeigknationaltax = Optional.fromNullable(toCurrencyType(yengstszeigknationaltaxType))
            .transform(bizCurrencyTransformer(getYengstszeigknationaltaxValue()))
            .orNull();
    }

    transient private String yengstszeigknationaltaxType = null;

    @Column(name=YENGSTSZEIGKNATIONALTAX + "$", nullable=true)
    protected String getYengstszeigknationaltaxType() {
        if (yengstszeigknationaltaxType == null && yengstszeigknationaltax != null) return yengstszeigknationaltax.getType().toString();
        if (yengstszeigknationaltaxType == null && getYengstszeigknationaltaxValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yengstszeigknationaltax$' should not be NULL."));
        }
        return yengstszeigknationaltaxType;
    }

    protected void setYengstszeigknationaltaxType(String type) {
        yengstszeigknationaltaxType = type;
        yengstszeigknationaltax = Optional.fromNullable(toCurrencyType(yengstszeigknationaltaxType))
            .transform(bizCurrencyTransformer(getYengstszeigknationaltaxValue()))
            .orNull();
    }

    private BizCurrency yengstszeigklocaltax;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYengstszeigklocaltax() {
        return yengstszeigklocaltax;
    }

    public void setYengstszeigklocaltax(BizCurrency pYengstszeigklocaltax) {
        yengstszeigklocaltax = pYengstszeigklocaltax;
        yengstszeigklocaltaxValue = null;
        yengstszeigklocaltaxType  = null;
    }

    transient private BigDecimal yengstszeigklocaltaxValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENGSTSZEIGKLOCALTAX, nullable=true)
    protected BigDecimal getYengstszeigklocaltaxValue() {
        if (yengstszeigklocaltaxValue == null && yengstszeigklocaltax != null) {
            if (yengstszeigklocaltax.isOptional()) return null;
            return yengstszeigklocaltax.absolute();
        }
        return yengstszeigklocaltaxValue;
    }

    protected void setYengstszeigklocaltaxValue(BigDecimal value) {
        yengstszeigklocaltaxValue = value;
        yengstszeigklocaltax = Optional.fromNullable(toCurrencyType(yengstszeigklocaltaxType))
            .transform(bizCurrencyTransformer(getYengstszeigklocaltaxValue()))
            .orNull();
    }

    transient private String yengstszeigklocaltaxType = null;

    @Column(name=YENGSTSZEIGKLOCALTAX + "$", nullable=true)
    protected String getYengstszeigklocaltaxType() {
        if (yengstszeigklocaltaxType == null && yengstszeigklocaltax != null) return yengstszeigklocaltax.getType().toString();
        if (yengstszeigklocaltaxType == null && getYengstszeigklocaltaxValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yengstszeigklocaltax$' should not be NULL."));
        }
        return yengstszeigklocaltaxType;
    }

    protected void setYengstszeigklocaltaxType(String type) {
        yengstszeigklocaltaxType = type;
        yengstszeigklocaltax = Optional.fromNullable(toCurrencyType(yengstszeigklocaltaxType))
            .transform(bizCurrencyTransformer(getYengstszeigklocaltaxValue()))
            .orNull();
    }

    private String nztodouhukencd;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.NZTODOUHUKENCD)
    public String getNztodouhukencd() {
        return nztodouhukencd;
    }

    public void setNztodouhukencd(String pNztodouhukencd) {
        nztodouhukencd = pNztodouhukencd;
    }

    private BizCurrency htykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtykeihi(BizCurrency pHtykeihi) {
        htykeihi = pHtykeihi;
        htykeihiValue = null;
        htykeihiType  = null;
    }

    transient private BigDecimal htykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HTYKEIHI, nullable=true)
    protected BigDecimal getHtykeihiValue() {
        if (htykeihiValue == null && htykeihi != null) {
            if (htykeihi.isOptional()) return null;
            return htykeihi.absolute();
        }
        return htykeihiValue;
    }

    protected void setHtykeihiValue(BigDecimal value) {
        htykeihiValue = value;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    transient private String htykeihiType = null;

    @Column(name=HTYKEIHI + "$", nullable=true)
    protected String getHtykeihiType() {
        if (htykeihiType == null && htykeihi != null) return htykeihi.getType().toString();
        if (htykeihiType == null && getHtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'htykeihi$' should not be NULL."));
        }
        return htykeihiType;
    }

    protected void setHtykeihiType(String type) {
        htykeihiType = type;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    private BizCurrency kztgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKztgk() {
        return kztgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKztgk(BizCurrency pKztgk) {
        kztgk = pKztgk;
        kztgkValue = null;
        kztgkType  = null;
    }

    transient private BigDecimal kztgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KZTGK, nullable=true)
    protected BigDecimal getKztgkValue() {
        if (kztgkValue == null && kztgk != null) {
            if (kztgk.isOptional()) return null;
            return kztgk.absolute();
        }
        return kztgkValue;
    }

    protected void setKztgkValue(BigDecimal value) {
        kztgkValue = value;
        kztgk = Optional.fromNullable(toCurrencyType(kztgkType))
            .transform(bizCurrencyTransformer(getKztgkValue()))
            .orNull();
    }

    transient private String kztgkType = null;

    @Column(name=KZTGK + "$", nullable=true)
    protected String getKztgkType() {
        if (kztgkType == null && kztgk != null) return kztgk.getType().toString();
        if (kztgkType == null && getKztgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kztgk$' should not be NULL."));
        }
        return kztgkType;
    }

    protected void setKztgkType(String type) {
        kztgkType = type;
        kztgk = Optional.fromNullable(toCurrencyType(kztgkType))
            .transform(bizCurrencyTransformer(getKztgkValue()))
            .orNull();
    }

    private BizCurrency yenhtykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenhtykeihi() {
        return yenhtykeihi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhtykeihi(BizCurrency pYenhtykeihi) {
        yenhtykeihi = pYenhtykeihi;
        yenhtykeihiValue = null;
        yenhtykeihiType  = null;
    }

    transient private BigDecimal yenhtykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENHTYKEIHI, nullable=true)
    protected BigDecimal getYenhtykeihiValue() {
        if (yenhtykeihiValue == null && yenhtykeihi != null) {
            if (yenhtykeihi.isOptional()) return null;
            return yenhtykeihi.absolute();
        }
        return yenhtykeihiValue;
    }

    protected void setYenhtykeihiValue(BigDecimal value) {
        yenhtykeihiValue = value;
        yenhtykeihi = Optional.fromNullable(toCurrencyType(yenhtykeihiType))
            .transform(bizCurrencyTransformer(getYenhtykeihiValue()))
            .orNull();
    }

    transient private String yenhtykeihiType = null;

    @Column(name=YENHTYKEIHI + "$", nullable=true)
    protected String getYenhtykeihiType() {
        if (yenhtykeihiType == null && yenhtykeihi != null) return yenhtykeihi.getType().toString();
        if (yenhtykeihiType == null && getYenhtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenhtykeihi$' should not be NULL."));
        }
        return yenhtykeihiType;
    }

    protected void setYenhtykeihiType(String type) {
        yenhtykeihiType = type;
        yenhtykeihi = Optional.fromNullable(toCurrencyType(yenhtykeihiType))
            .transform(bizCurrencyTransformer(getYenhtykeihiValue()))
            .orNull();
    }

    private BizCurrency yenkztgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkztgk() {
        return yenkztgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkztgk(BizCurrency pYenkztgk) {
        yenkztgk = pYenkztgk;
        yenkztgkValue = null;
        yenkztgkType  = null;
    }

    transient private BigDecimal yenkztgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKZTGK, nullable=true)
    protected BigDecimal getYenkztgkValue() {
        if (yenkztgkValue == null && yenkztgk != null) {
            if (yenkztgk.isOptional()) return null;
            return yenkztgk.absolute();
        }
        return yenkztgkValue;
    }

    protected void setYenkztgkValue(BigDecimal value) {
        yenkztgkValue = value;
        yenkztgk = Optional.fromNullable(toCurrencyType(yenkztgkType))
            .transform(bizCurrencyTransformer(getYenkztgkValue()))
            .orNull();
    }

    transient private String yenkztgkType = null;

    @Column(name=YENKZTGK + "$", nullable=true)
    protected String getYenkztgkType() {
        if (yenkztgkType == null && yenkztgk != null) return yenkztgk.getType().toString();
        if (yenkztgkType == null && getYenkztgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkztgk$' should not be NULL."));
        }
        return yenkztgkType;
    }

    protected void setYenkztgkType(String type) {
        yenkztgkType = type;
        yenkztgk = Optional.fromNullable(toCurrencyType(yenkztgkType))
            .transform(bizCurrencyTransformer(getYenkztgkValue()))
            .orNull();
    }

    private BizDate zeimukwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.ZEIMUKWSRATEKJNYMD)
    public BizDate getZeimukwsratekjnymd() {
        return zeimukwsratekjnymd;
    }

    public void setZeimukwsratekjnymd(BizDate pZeimukwsratekjnymd) {
        zeimukwsratekjnymd = pZeimukwsratekjnymd;
    }

    private BizNumber zeimukwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.ZEIMUKWSRATE)
    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        zeimukwsrate = pZeimukwsrate;
    }

    private String kyknmkn;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String kyknmkj;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.KYKNMKJ)
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

    private String kykyno;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.KYKYNO)
    public String getKykyno() {
        return kykyno;
    }

    public void setKykyno(String pKykyno) {
        kykyno = pKykyno;
    }

    private String kykadr1kj;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.KYKADR1KJ)
    @MaxLength(max=62)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykadr1kj() {
        return kykadr1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykadr1kj(String pKykadr1kj) {
        kykadr1kj = pKykadr1kj;
    }

    private String kykadr2kj;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.KYKADR2KJ)
    @MaxLength(max=62)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykadr2kj() {
        return kykadr2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykadr2kj(String pKykadr2kj) {
        kykadr2kj = pKykadr2kj;
    }

    private String kykadr3kj;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.KYKADR3KJ)
    @MaxLength(max=62)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykadr3kj() {
        return kykadr3kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykadr3kj(String pKykadr3kj) {
        kykadr3kj = pKykadr3kj;
    }

    private String kykmnmeigibangou;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.KYKMNMEIGIBANGOU)
    @Length(length=3)
    @Digit
    public String getKykmnmeigibangou() {
        return kykmnmeigibangou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykmnmeigibangou(String pKykmnmeigibangou) {
        kykmnmeigibangou = pKykmnmeigibangou;
    }

    private String uktmnmeigibangou;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.UKTMNMEIGIBANGOU)
    @Length(length=3)
    @Digit
    public String getUktmnmeigibangou() {
        return uktmnmeigibangou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktmnmeigibangou(String pUktmnmeigibangou) {
        uktmnmeigibangou = pUktmnmeigibangou;
    }

    private C_HtsiryosyuKbn shrtysysyuruikbn;

    @Type(type="UserType_C_HtsiryosyuKbn")
    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.SHRTYSYSYURUIKBN)
    public C_HtsiryosyuKbn getShrtysysyuruikbn() {
        return shrtysysyuruikbn;
    }

    public void setShrtysysyuruikbn(C_HtsiryosyuKbn pShrtysysyuruikbn) {
        shrtysysyuruikbn = pShrtysysyuruikbn;
    }

    private BizCurrency yenshrkykhtykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenshrkykhtykeihi() {
        return yenshrkykhtykeihi;
    }

    public void setYenshrkykhtykeihi(BizCurrency pYenshrkykhtykeihi) {
        yenshrkykhtykeihi = pYenshrkykhtykeihi;
        yenshrkykhtykeihiValue = null;
        yenshrkykhtykeihiType  = null;
    }

    transient private BigDecimal yenshrkykhtykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENSHRKYKHTYKEIHI, nullable=true)
    protected BigDecimal getYenshrkykhtykeihiValue() {
        if (yenshrkykhtykeihiValue == null && yenshrkykhtykeihi != null) {
            if (yenshrkykhtykeihi.isOptional()) return null;
            return yenshrkykhtykeihi.absolute();
        }
        return yenshrkykhtykeihiValue;
    }

    protected void setYenshrkykhtykeihiValue(BigDecimal value) {
        yenshrkykhtykeihiValue = value;
        yenshrkykhtykeihi = Optional.fromNullable(toCurrencyType(yenshrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getYenshrkykhtykeihiValue()))
            .orNull();
    }

    transient private String yenshrkykhtykeihiType = null;

    @Column(name=YENSHRKYKHTYKEIHI + "$", nullable=true)
    protected String getYenshrkykhtykeihiType() {
        if (yenshrkykhtykeihiType == null && yenshrkykhtykeihi != null) return yenshrkykhtykeihi.getType().toString();
        if (yenshrkykhtykeihiType == null && getYenshrkykhtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenshrkykhtykeihi$' should not be NULL."));
        }
        return yenshrkykhtykeihiType;
    }

    protected void setYenshrkykhtykeihiType(String type) {
        yenshrkykhtykeihiType = type;
        yenshrkykhtykeihi = Optional.fromNullable(toCurrencyType(yenshrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getYenshrkykhtykeihiValue()))
            .orNull();
    }

    private Integer kykhnkkaisuu;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.KYKHNKKAISUU)
    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KhHasseijiKazeiRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}