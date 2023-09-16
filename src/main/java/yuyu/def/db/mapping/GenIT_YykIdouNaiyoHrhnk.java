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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_HaraikatahnkuktknaiyouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_YykIdouNaiyoHrhnk;
import yuyu.def.db.id.PKIT_YykIdouNaiyoHrhnk;
import yuyu.def.db.meta.GenQIT_YykIdouNaiyoHrhnk;
import yuyu.def.db.meta.QIT_YykIdouNaiyoHrhnk;
import yuyu.def.db.type.UserType_C_CardBrandKbn;
import yuyu.def.db.type.UserType_C_HaraikatahnkuktknaiyouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_SinkeizkKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 予約異動受付内容（払方変更）テーブル テーブルのマッピング情報クラスで、 {@link IT_YykIdouNaiyoHrhnk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_YykIdouNaiyoHrhnk}</td><td colspan="3">予約異動受付内容（払方変更）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_YykIdouNaiyoHrhnk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_YykIdouNaiyoHrhnk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_YykIdouNaiyoHrhnk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNewhrkkeiro newhrkkeiro}</td><td>（変更後）払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getNewhrkkaisuu newhrkkaisuu}</td><td>（変更後）払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getNewtikiktbrisyuruikbn newtikiktbrisyuruikbn}</td><td>（変更後）定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getHrkkeirohnkumu hrkkeirohnkumu}</td><td>払込経路変更有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHrkkaisuuhnkumu hrkkaisuuhnkumu}</td><td>払込回数変更有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruihnkumu tikiktbrisyuruihnkumu}</td><td>定期一括払種類変更有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHaraikatahnkumu haraikatahnkumu}</td><td>払方変更有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHaraikatahnkuktknaiyoukbn haraikatahnkuktknaiyoukbn}</td><td>払方変更受付内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaraikatahnkuktknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSinkeizkkbn sinkeizkkbn}</td><td>新規継続区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinkeizkKbn}</td></tr>
 *  <tr><td>{@link #getSyuudaikocd syuudaikocd}</td><td>収納代行社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syuudaikocd}</td></tr>
 *  <tr><td>{@link #getCardkaisyacd cardkaisyacd}</td><td>カード会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardykkigen creditcardykkigen}</td><td>クレジットカード有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditmeiginmkn creditmeiginmkn}</td><td>クレジットカード名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkykdoukbn kzkykdoukbn}</td><td>口座名義契約者同一人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KzkykdouKbn}</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardbrandkbn cardbrandkbn}</td><td>カードブランド区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CardBrandKbn}</td></tr>
 *  <tr><td>{@link #getCreditkaiinnosimo4keta creditkaiinnosimo4keta}</td><td>クレジット会員番号（下４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_YykIdouNaiyoHrhnk
 * @see     PKIT_YykIdouNaiyoHrhnk
 * @see     QIT_YykIdouNaiyoHrhnk
 * @see     GenQIT_YykIdouNaiyoHrhnk
 */
@MappedSuperclass
@Table(name=GenIT_YykIdouNaiyoHrhnk.TABLE_NAME)
@IdClass(value=PKIT_YykIdouNaiyoHrhnk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_CardBrandKbn", typeClass=UserType_C_CardBrandKbn.class),
    @TypeDef(name="UserType_C_HaraikatahnkuktknaiyouKbn", typeClass=UserType_C_HaraikatahnkuktknaiyouKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_KzkykdouKbn", typeClass=UserType_C_KzkykdouKbn.class),
    @TypeDef(name="UserType_C_SinkeizkKbn", typeClass=UserType_C_SinkeizkKbn.class),
    @TypeDef(name="UserType_C_Syuudaikocd", typeClass=UserType_C_Syuudaikocd.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_YykIdouNaiyoHrhnk extends AbstractExDBEntity<IT_YykIdouNaiyoHrhnk, PKIT_YykIdouNaiyoHrhnk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_YykIdouNaiyoHrhnk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String NEWHRKKEIRO              = "newhrkkeiro";
    public static final String NEWHRKKAISUU             = "newhrkkaisuu";
    public static final String NEWTIKIKTBRISYURUIKBN    = "newtikiktbrisyuruikbn";
    public static final String HRKKEIROHNKUMU           = "hrkkeirohnkumu";
    public static final String HRKKAISUUHNKUMU          = "hrkkaisuuhnkumu";
    public static final String TIKIKTBRISYURUIHNKUMU    = "tikiktbrisyuruihnkumu";
    public static final String HARAIKATAHNKUMU          = "haraikatahnkumu";
    public static final String HARAIKATAHNKUKTKNAIYOUKBN = "haraikatahnkuktknaiyoukbn";
    public static final String HRKP                     = "hrkp";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String SINKEIZKKBN              = "sinkeizkkbn";
    public static final String SYUUDAIKOCD              = "syuudaikocd";
    public static final String CARDKAISYACD             = "cardkaisyacd";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String CREDITCARDYKKIGEN        = "creditcardykkigen";
    public static final String CREDITMEIGINMKN          = "creditmeiginmkn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String KZKYKDOUKBN              = "kzkykdoukbn";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String CARDBRANDKBN             = "cardbrandkbn";
    public static final String CREDITKAIINNOSIMO4KETA   = "creditkaiinnosimo4keta";

    private final PKIT_YykIdouNaiyoHrhnk primaryKey;

    public GenIT_YykIdouNaiyoHrhnk() {
        primaryKey = new PKIT_YykIdouNaiyoHrhnk();
    }

    public GenIT_YykIdouNaiyoHrhnk(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_YykIdouNaiyoHrhnk(
            pKbnkey,
            pSyono,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_YykIdouNaiyoHrhnk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_YykIdouNaiyoHrhnk> getMetaClass() {
        return QIT_YykIdouNaiyoHrhnk.class;
    }

    @Id
    @Column(name=GenIT_YykIdouNaiyoHrhnk.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_YykIdouNaiyoHrhnk.SYONO)
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
    @Column(name=GenIT_YykIdouNaiyoHrhnk.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private BizDate kouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private C_Hrkkeiro newhrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.NEWHRKKEIRO)
    public C_Hrkkeiro getNewhrkkeiro() {
        return newhrkkeiro;
    }

    public void setNewhrkkeiro(C_Hrkkeiro pNewhrkkeiro) {
        newhrkkeiro = pNewhrkkeiro;
    }

    private C_Hrkkaisuu newhrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.NEWHRKKAISUU)
    public C_Hrkkaisuu getNewhrkkaisuu() {
        return newhrkkaisuu;
    }

    public void setNewhrkkaisuu(C_Hrkkaisuu pNewhrkkaisuu) {
        newhrkkaisuu = pNewhrkkaisuu;
    }

    private C_TkiktbrisyuruiKbn newtikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.NEWTIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getNewtikiktbrisyuruikbn() {
        return newtikiktbrisyuruikbn;
    }

    public void setNewtikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pNewtikiktbrisyuruikbn) {
        newtikiktbrisyuruikbn = pNewtikiktbrisyuruikbn;
    }

    private C_UmuKbn hrkkeirohnkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.HRKKEIROHNKUMU)
    public C_UmuKbn getHrkkeirohnkumu() {
        return hrkkeirohnkumu;
    }

    public void setHrkkeirohnkumu(C_UmuKbn pHrkkeirohnkumu) {
        hrkkeirohnkumu = pHrkkeirohnkumu;
    }

    private C_UmuKbn hrkkaisuuhnkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.HRKKAISUUHNKUMU)
    public C_UmuKbn getHrkkaisuuhnkumu() {
        return hrkkaisuuhnkumu;
    }

    public void setHrkkaisuuhnkumu(C_UmuKbn pHrkkaisuuhnkumu) {
        hrkkaisuuhnkumu = pHrkkaisuuhnkumu;
    }

    private C_UmuKbn tikiktbrisyuruihnkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.TIKIKTBRISYURUIHNKUMU)
    public C_UmuKbn getTikiktbrisyuruihnkumu() {
        return tikiktbrisyuruihnkumu;
    }

    public void setTikiktbrisyuruihnkumu(C_UmuKbn pTikiktbrisyuruihnkumu) {
        tikiktbrisyuruihnkumu = pTikiktbrisyuruihnkumu;
    }

    private C_UmuKbn haraikatahnkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.HARAIKATAHNKUMU)
    public C_UmuKbn getHaraikatahnkumu() {
        return haraikatahnkumu;
    }

    public void setHaraikatahnkumu(C_UmuKbn pHaraikatahnkumu) {
        haraikatahnkumu = pHaraikatahnkumu;
    }

    private C_HaraikatahnkuktknaiyouKbn haraikatahnkuktknaiyoukbn;

    @Type(type="UserType_C_HaraikatahnkuktknaiyouKbn")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.HARAIKATAHNKUKTKNAIYOUKBN)
    public C_HaraikatahnkuktknaiyouKbn getHaraikatahnkuktknaiyoukbn() {
        return haraikatahnkuktknaiyoukbn;
    }

    public void setHaraikatahnkuktknaiyoukbn(C_HaraikatahnkuktknaiyouKbn pHaraikatahnkuktknaiyoukbn) {
        haraikatahnkuktknaiyoukbn = pHaraikatahnkuktknaiyoukbn;
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

    private String bankcd;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.BANKCD)
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

    @Column(name=GenIT_YykIdouNaiyoHrhnk.SITENCD)
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
    @Column(name=GenIT_YykIdouNaiyoHrhnk.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.KOUZANO)
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

    private String kzmeiginmkn;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private C_SinkeizkKbn sinkeizkkbn;

    @Type(type="UserType_C_SinkeizkKbn")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.SINKEIZKKBN)
    public C_SinkeizkKbn getSinkeizkkbn() {
        return sinkeizkkbn;
    }

    public void setSinkeizkkbn(C_SinkeizkKbn pSinkeizkkbn) {
        sinkeizkkbn = pSinkeizkkbn;
    }

    private C_Syuudaikocd syuudaikocd;

    @Type(type="UserType_C_Syuudaikocd")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.SYUUDAIKOCD)
    public C_Syuudaikocd getSyuudaikocd() {
        return syuudaikocd;
    }

    public void setSyuudaikocd(C_Syuudaikocd pSyuudaikocd) {
        syuudaikocd = pSyuudaikocd;
    }

    private String cardkaisyacd;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.CARDKAISYACD)
    public String getCardkaisyacd() {
        return cardkaisyacd;
    }

    public void setCardkaisyacd(String pCardkaisyacd) {
        cardkaisyacd = pCardkaisyacd;
    }

    private String creditcardno1;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private String creditcardykkigen;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.CREDITCARDYKKIGEN)
    public String getCreditcardykkigen() {
        return creditcardykkigen;
    }

    public void setCreditcardykkigen(String pCreditcardykkigen) {
        creditcardykkigen = pCreditcardykkigen;
    }

    private String creditmeiginmkn;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.CREDITMEIGINMKN)
    public String getCreditmeiginmkn() {
        return creditmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setCreditmeiginmkn(String pCreditmeiginmkn) {
        creditmeiginmkn = pCreditmeiginmkn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_KzkykdouKbn kzkykdoukbn;

    @Type(type="UserType_C_KzkykdouKbn")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.KZKYKDOUKBN)
    public C_KzkykdouKbn getKzkykdoukbn() {
        return kzkykdoukbn;
    }

    public void setKzkykdoukbn(C_KzkykdouKbn pKzkykdoukbn) {
        kzkykdoukbn = pKzkykdoukbn;
    }

    private String creditkessaiyouno;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    private C_CardBrandKbn cardbrandkbn;

    @Type(type="UserType_C_CardBrandKbn")
    @Column(name=GenIT_YykIdouNaiyoHrhnk.CARDBRANDKBN)
    public C_CardBrandKbn getCardbrandkbn() {
        return cardbrandkbn;
    }

    public void setCardbrandkbn(C_CardBrandKbn pCardbrandkbn) {
        cardbrandkbn = pCardbrandkbn;
    }

    private String creditkaiinnosimo4keta;

    @Column(name=GenIT_YykIdouNaiyoHrhnk.CREDITKAIINNOSIMO4KETA)
    public String getCreditkaiinnosimo4keta() {
        return creditkaiinnosimo4keta;
    }

    public void setCreditkaiinnosimo4keta(String pCreditkaiinnosimo4keta) {
        creditkaiinnosimo4keta = pCreditkaiinnosimo4keta;
    }
}