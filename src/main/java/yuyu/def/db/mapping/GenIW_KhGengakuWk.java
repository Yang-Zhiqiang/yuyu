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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KykhnkKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IW_KhGengakuWk;
import yuyu.def.db.id.PKIW_KhGengakuWk;
import yuyu.def.db.meta.GenQIW_KhGengakuWk;
import yuyu.def.db.meta.QIW_KhGengakuWk;
import yuyu.def.db.type.UserType_C_GengkhouKbn;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_KykhnkKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_SoukinsakiKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 減額ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhGengakuWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhGengakuWk}</td><td colspan="3">減額ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhGengakuWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkssakuseiymd skssakuseiymd}</td><td>請求書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykhnkkbn kykhnkkbn}</td><td>契約変更区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykhnkKbn}</td></tr>
 *  <tr><td>{@link #getGengkhoukbn gengkhoukbn}</td><td>減額方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GengkhouKbn}</td></tr>
 *  <tr><td>{@link #getNewkihonhknkngaku newkihonhknkngaku}</td><td>新基本保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewhrkp newhrkp}</td><td>新払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenshrtkhkumu yenshrtkhkumu}</td><td>円支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInputshrhousiteikbn inputshrhousiteikbn}</td><td>入力用支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzdoukbn kzdoukbn}</td><td>口座名義人同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kzdou}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykmnmeigibangou kykmnmeigibangou}</td><td>契約者ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakikbn soukinsakikbn}</td><td>送金先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SoukinsakiKbn}</td></tr>
 * </table>
 * @see     IW_KhGengakuWk
 * @see     PKIW_KhGengakuWk
 * @see     QIW_KhGengakuWk
 * @see     GenQIW_KhGengakuWk
 */
@MappedSuperclass
@Table(name=GenIW_KhGengakuWk.TABLE_NAME)
@IdClass(value=PKIW_KhGengakuWk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_GengkhouKbn", typeClass=UserType_C_GengkhouKbn.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_InputShrhousiteiKbn", typeClass=UserType_C_InputShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_KykhnkKbn", typeClass=UserType_C_KykhnkKbn.class),
    @TypeDef(name="UserType_C_Kzdou", typeClass=UserType_C_Kzdou.class),
    @TypeDef(name="UserType_C_SoukinsakiKbn", typeClass=UserType_C_SoukinsakiKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIW_KhGengakuWk extends AbstractExDBEntity<IW_KhGengakuWk, PKIW_KhGengakuWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhGengakuWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SKSSAKUSEIYMD            = "skssakuseiymd";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String KYKHNKKBN                = "kykhnkkbn";
    public static final String GENGKHOUKBN              = "gengkhoukbn";
    public static final String NEWKIHONHKNKNGAKU        = "newkihonhknkngaku";
    public static final String NEWHRKP                  = "newhrkp";
    public static final String YENSHRTKHKUMU            = "yenshrtkhkumu";
    public static final String INPUTSHRHOUSITEIKBN      = "inputshrhousiteikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZDOUKBN                 = "kzdoukbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String KYKMNMEIGIBANGOU         = "kykmnmeigibangou";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SOUKINSAKIKBN            = "soukinsakikbn";

    private final PKIW_KhGengakuWk primaryKey;

    public GenIW_KhGengakuWk() {
        primaryKey = new PKIW_KhGengakuWk();
    }

    public GenIW_KhGengakuWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhGengakuWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhGengakuWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhGengakuWk> getMetaClass() {
        return QIW_KhGengakuWk.class;
    }

    @Id
    @Column(name=GenIW_KhGengakuWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhGengakuWk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private BizDate skssakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhGengakuWk.SKSSAKUSEIYMD)
    public BizDate getSkssakuseiymd() {
        return skssakuseiymd;
    }

    public void setSkssakuseiymd(BizDate pSkssakuseiymd) {
        skssakuseiymd = pSkssakuseiymd;
    }

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhGengakuWk.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private C_KykhnkKbn kykhnkkbn;

    @Type(type="UserType_C_KykhnkKbn")
    @Column(name=GenIW_KhGengakuWk.KYKHNKKBN)
    public C_KykhnkKbn getKykhnkkbn() {
        return kykhnkkbn;
    }

    public void setKykhnkkbn(C_KykhnkKbn pKykhnkkbn) {
        kykhnkkbn = pKykhnkkbn;
    }

    private C_GengkhouKbn gengkhoukbn;

    @Type(type="UserType_C_GengkhouKbn")
    @Column(name=GenIW_KhGengakuWk.GENGKHOUKBN)
    public C_GengkhouKbn getGengkhoukbn() {
        return gengkhoukbn;
    }

    public void setGengkhoukbn(C_GengkhouKbn pGengkhoukbn) {
        gengkhoukbn = pGengkhoukbn;
    }

    private BizCurrency newkihonhknkngaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewkihonhknkngaku() {
        return newkihonhknkngaku;
    }

    public void setNewkihonhknkngaku(BizCurrency pNewkihonhknkngaku) {
        newkihonhknkngaku = pNewkihonhknkngaku;
        newkihonhknkngakuValue = null;
        newkihonhknkngakuType  = null;
    }

    transient private BigDecimal newkihonhknkngakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWKIHONHKNKNGAKU, nullable=true)
    protected BigDecimal getNewkihonhknkngakuValue() {
        if (newkihonhknkngakuValue == null && newkihonhknkngaku != null) {
            if (newkihonhknkngaku.isOptional()) return null;
            return newkihonhknkngaku.absolute();
        }
        return newkihonhknkngakuValue;
    }

    protected void setNewkihonhknkngakuValue(BigDecimal value) {
        newkihonhknkngakuValue = value;
        newkihonhknkngaku = Optional.fromNullable(toCurrencyType(newkihonhknkngakuType))
            .transform(bizCurrencyTransformer(getNewkihonhknkngakuValue()))
            .orNull();
    }

    transient private String newkihonhknkngakuType = null;

    @Column(name=NEWKIHONHKNKNGAKU + "$", nullable=true)
    protected String getNewkihonhknkngakuType() {
        if (newkihonhknkngakuType == null && newkihonhknkngaku != null) return newkihonhknkngaku.getType().toString();
        if (newkihonhknkngakuType == null && getNewkihonhknkngakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newkihonhknkngaku$' should not be NULL."));
        }
        return newkihonhknkngakuType;
    }

    protected void setNewkihonhknkngakuType(String type) {
        newkihonhknkngakuType = type;
        newkihonhknkngaku = Optional.fromNullable(toCurrencyType(newkihonhknkngakuType))
            .transform(bizCurrencyTransformer(getNewkihonhknkngakuValue()))
            .orNull();
    }

    private BizCurrency newhrkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewhrkp() {
        return newhrkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewhrkp(BizCurrency pNewhrkp) {
        newhrkp = pNewhrkp;
        newhrkpValue = null;
        newhrkpType  = null;
    }

    transient private BigDecimal newhrkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWHRKP, nullable=true)
    protected BigDecimal getNewhrkpValue() {
        if (newhrkpValue == null && newhrkp != null) {
            if (newhrkp.isOptional()) return null;
            return newhrkp.absolute();
        }
        return newhrkpValue;
    }

    protected void setNewhrkpValue(BigDecimal value) {
        newhrkpValue = value;
        newhrkp = Optional.fromNullable(toCurrencyType(newhrkpType))
            .transform(bizCurrencyTransformer(getNewhrkpValue()))
            .orNull();
    }

    transient private String newhrkpType = null;

    @Column(name=NEWHRKP + "$", nullable=true)
    protected String getNewhrkpType() {
        if (newhrkpType == null && newhrkp != null) return newhrkp.getType().toString();
        if (newhrkpType == null && getNewhrkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newhrkp$' should not be NULL."));
        }
        return newhrkpType;
    }

    protected void setNewhrkpType(String type) {
        newhrkpType = type;
        newhrkp = Optional.fromNullable(toCurrencyType(newhrkpType))
            .transform(bizCurrencyTransformer(getNewhrkpValue()))
            .orNull();
    }

    private C_UmuKbn yenshrtkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIW_KhGengakuWk.YENSHRTKHKUMU)
    public C_UmuKbn getYenshrtkhkumu() {
        return yenshrtkhkumu;
    }

    public void setYenshrtkhkumu(C_UmuKbn pYenshrtkhkumu) {
        yenshrtkhkumu = pYenshrtkhkumu;
    }

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    @Type(type="UserType_C_InputShrhousiteiKbn")
    @Column(name=GenIW_KhGengakuWk.INPUTSHRHOUSITEIKBN)
    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    private String bankcd;

    @Column(name=GenIW_KhGengakuWk.BANKCD)
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

    @Column(name=GenIW_KhGengakuWk.SITENCD)
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
    @Column(name=GenIW_KhGengakuWk.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIW_KhGengakuWk.KOUZANO)
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

    private C_Kzdou kzdoukbn;

    @Type(type="UserType_C_Kzdou")
    @Column(name=GenIW_KhGengakuWk.KZDOUKBN)
    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenIW_KhGengakuWk.KZMEIGINMKN)
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

    private String kykmnmeigibangou;

    @Column(name=GenIW_KhGengakuWk.KYKMNMEIGIBANGOU)
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

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIW_KhGengakuWk.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIW_KhGengakuWk.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhGengakuWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhGengakuWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhGengakuWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhGengakuWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_SoukinsakiKbn soukinsakikbn;

    @Type(type="UserType_C_SoukinsakiKbn")
    @Column(name=GenIW_KhGengakuWk.SOUKINSAKIKBN)
    public C_SoukinsakiKbn getSoukinsakikbn() {
        return soukinsakikbn;
    }

    public void setSoukinsakikbn(C_SoukinsakiKbn pSoukinsakikbn) {
        soukinsakikbn = pSoukinsakikbn;
    }
}