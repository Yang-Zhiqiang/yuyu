package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.db.id.PKIW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.db.meta.GenQIW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.db.meta.QIW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_SoukinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoriKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 被保険者生年月日・性訂正ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhSeinengappiSeiTeiseiWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhSeinengappiSeiTeiseiWk}</td><td colspan="3">被保険者生年月日・性訂正ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhSeinengappiSeiTeiseiWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkssakuseiymd skssakuseiymd}</td><td>請求書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNewhhknseiymd newhhknseiymd}</td><td>変更後被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNewhhknsei newhhknsei}</td><td>変更後被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getYenshrtkhkumu yenshrtkhkumu}</td><td>円支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInputshrhousiteikbn inputshrhousiteikbn}</td><td>入力用支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getSoukinsakikbn soukinsakikbn}</td><td>送金先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SoukinsakiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzdoukbn kzdoukbn}</td><td>口座名義人同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kzdou}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorikbn syorikbn}</td><td>処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoriKbn}</td></tr>
 * </table>
 * @see     IW_KhSeinengappiSeiTeiseiWk
 * @see     PKIW_KhSeinengappiSeiTeiseiWk
 * @see     QIW_KhSeinengappiSeiTeiseiWk
 * @see     GenQIW_KhSeinengappiSeiTeiseiWk
 */
@MappedSuperclass
@Table(name=GenIW_KhSeinengappiSeiTeiseiWk.TABLE_NAME)
@IdClass(value=PKIW_KhSeinengappiSeiTeiseiWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_InputShrhousiteiKbn", typeClass=UserType_C_InputShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_Kzdou", typeClass=UserType_C_Kzdou.class),
    @TypeDef(name="UserType_C_SoukinsakiKbn", typeClass=UserType_C_SoukinsakiKbn.class),
    @TypeDef(name="UserType_C_SyoriKbn", typeClass=UserType_C_SyoriKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIW_KhSeinengappiSeiTeiseiWk extends AbstractExDBEntity<IW_KhSeinengappiSeiTeiseiWk, PKIW_KhSeinengappiSeiTeiseiWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhSeinengappiSeiTeiseiWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SKSSAKUSEIYMD            = "skssakuseiymd";
    public static final String NEWHHKNSEIYMD            = "newhhknseiymd";
    public static final String NEWHHKNSEI               = "newhhknsei";
    public static final String YENSHRTKHKUMU            = "yenshrtkhkumu";
    public static final String INPUTSHRHOUSITEIKBN      = "inputshrhousiteikbn";
    public static final String SOUKINSAKIKBN            = "soukinsakikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZDOUKBN                 = "kzdoukbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SYORIKBN                 = "syorikbn";

    private final PKIW_KhSeinengappiSeiTeiseiWk primaryKey;

    public GenIW_KhSeinengappiSeiTeiseiWk() {
        primaryKey = new PKIW_KhSeinengappiSeiTeiseiWk();
    }

    public GenIW_KhSeinengappiSeiTeiseiWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhSeinengappiSeiTeiseiWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhSeinengappiSeiTeiseiWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhSeinengappiSeiTeiseiWk> getMetaClass() {
        return QIW_KhSeinengappiSeiTeiseiWk.class;
    }

    @Id
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.SYONO)
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
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.SKSSAKUSEIYMD)
    public BizDate getSkssakuseiymd() {
        return skssakuseiymd;
    }

    public void setSkssakuseiymd(BizDate pSkssakuseiymd) {
        skssakuseiymd = pSkssakuseiymd;
    }

    private BizDate newhhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.NEWHHKNSEIYMD)
    @ValidDate
    public BizDate getNewhhknseiymd() {
        return newhhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewhhknseiymd(BizDate pNewhhknseiymd) {
        newhhknseiymd = pNewhhknseiymd;
    }

    private C_Hhknsei newhhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.NEWHHKNSEI)
    public C_Hhknsei getNewhhknsei() {
        return newhhknsei;
    }

    public void setNewhhknsei(C_Hhknsei pNewhhknsei) {
        newhhknsei = pNewhhknsei;
    }

    private C_UmuKbn yenshrtkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.YENSHRTKHKUMU)
    public C_UmuKbn getYenshrtkhkumu() {
        return yenshrtkhkumu;
    }

    public void setYenshrtkhkumu(C_UmuKbn pYenshrtkhkumu) {
        yenshrtkhkumu = pYenshrtkhkumu;
    }

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    @Type(type="UserType_C_InputShrhousiteiKbn")
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.INPUTSHRHOUSITEIKBN)
    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    private C_SoukinsakiKbn soukinsakikbn;

    @Type(type="UserType_C_SoukinsakiKbn")
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.SOUKINSAKIKBN)
    public C_SoukinsakiKbn getSoukinsakikbn() {
        return soukinsakikbn;
    }

    public void setSoukinsakikbn(C_SoukinsakiKbn pSoukinsakikbn) {
        soukinsakikbn = pSoukinsakikbn;
    }

    private String bankcd;

    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.BANKCD)
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

    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.SITENCD)
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
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.KOUZANO)
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
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.KZDOUKBN)
    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.KZMEIGINMKN)
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

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_SyoriKbn syorikbn;

    @Type(type="UserType_C_SyoriKbn")
    @Column(name=GenIW_KhSeinengappiSeiTeiseiWk.SYORIKBN)
    public C_SyoriKbn getSyorikbn() {
        return syorikbn;
    }

    public void setSyorikbn(C_SyoriKbn pSyorikbn) {
        syorikbn = pSyorikbn;
    }
}