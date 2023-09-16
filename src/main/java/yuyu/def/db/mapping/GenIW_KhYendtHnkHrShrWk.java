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
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_Khskssakuseijiyuu;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IW_KhYendtHnkHrShrWk;
import yuyu.def.db.id.PKIW_KhYendtHnkHrShrWk;
import yuyu.def.db.meta.GenQIW_KhYendtHnkHrShrWk;
import yuyu.def.db.meta.QIW_KhYendtHnkHrShrWk;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Khhrshrjiyuu;
import yuyu.def.db.type.UserType_C_Khskssakuseijiyuu;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 円建変更時返戻金支払ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhYendtHnkHrShrWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhYendtHnkHrShrWk}</td><td colspan="3">円建変更時返戻金支払ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhYendtHnkHrShrWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkssakuseiymd skssakuseiymd}</td><td>請求書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKhhrshrjiyuu khhrshrjiyuu}</td><td>契約保全返戻金支払事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Khhrshrjiyuu}</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShnmkj shnmkj}</td><td>送付先氏名（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShskyno shskyno}</td><td>送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr1kj shsadr1kj}</td><td>送付先住所１（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr2kj shsadr2kj}</td><td>送付先住所２（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr3kj shsadr3kj}</td><td>送付先住所３（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhskssakuseijiyuu khskssakuseijiyuu}</td><td>契約保全請求書作成事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Khskssakuseijiyuu}</td></tr>
 *  <tr><td>{@link #getKyksyaszknmkn kyksyaszknmkn}</td><td>契約者相続人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszknmkj kyksyaszknmkj}</td><td>契約者相続人氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkyno kyksyaszkyno}</td><td>契約者相続人郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkadr1kj kyksyaszkadr1kj}</td><td>契約者相続人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkadr2kj kyksyaszkadr2kj}</td><td>契約者相続人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkadr3kj kyksyaszkadr3kj}</td><td>契約者相続人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInputshrhousiteikbn inputshrhousiteikbn}</td><td>入力用支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzdoukbn kzdoukbn}</td><td>口座名義人同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kzdou}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykmnmeigibangou kykmnmeigibangou}</td><td>契約者ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktmnmeigibangou uktmnmeigibangou}</td><td>受取人ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhYendtHnkHrShrWk
 * @see     PKIW_KhYendtHnkHrShrWk
 * @see     QIW_KhYendtHnkHrShrWk
 * @see     GenQIW_KhYendtHnkHrShrWk
 */
@MappedSuperclass
@Table(name=GenIW_KhYendtHnkHrShrWk.TABLE_NAME)
@IdClass(value=PKIW_KhYendtHnkHrShrWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_InputShrhousiteiKbn", typeClass=UserType_C_InputShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_Khhrshrjiyuu", typeClass=UserType_C_Khhrshrjiyuu.class),
    @TypeDef(name="UserType_C_Khskssakuseijiyuu", typeClass=UserType_C_Khskssakuseijiyuu.class),
    @TypeDef(name="UserType_C_Kzdou", typeClass=UserType_C_Kzdou.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIW_KhYendtHnkHrShrWk extends AbstractExDBEntity<IW_KhYendtHnkHrShrWk, PKIW_KhYendtHnkHrShrWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhYendtHnkHrShrWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SKSSAKUSEIYMD            = "skssakuseiymd";
    public static final String KHHRSHRJIYUU             = "khhrshrjiyuu";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String SHNMKJ                   = "shnmkj";
    public static final String SHSKYNO                  = "shskyno";
    public static final String SHSADR1KJ                = "shsadr1kj";
    public static final String SHSADR2KJ                = "shsadr2kj";
    public static final String SHSADR3KJ                = "shsadr3kj";
    public static final String KHSKSSAKUSEIJIYUU        = "khskssakuseijiyuu";
    public static final String KYKSYASZKNMKN            = "kyksyaszknmkn";
    public static final String KYKSYASZKNMKJ            = "kyksyaszknmkj";
    public static final String KYKSYASZKYNO             = "kyksyaszkyno";
    public static final String KYKSYASZKADR1KJ          = "kyksyaszkadr1kj";
    public static final String KYKSYASZKADR2KJ          = "kyksyaszkadr2kj";
    public static final String KYKSYASZKADR3KJ          = "kyksyaszkadr3kj";
    public static final String INPUTSHRHOUSITEIKBN      = "inputshrhousiteikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZDOUKBN                 = "kzdoukbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String KYKMNMEIGIBANGOU         = "kykmnmeigibangou";
    public static final String UKTMNMEIGIBANGOU         = "uktmnmeigibangou";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIW_KhYendtHnkHrShrWk primaryKey;

    public GenIW_KhYendtHnkHrShrWk() {
        primaryKey = new PKIW_KhYendtHnkHrShrWk();
    }

    public GenIW_KhYendtHnkHrShrWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhYendtHnkHrShrWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhYendtHnkHrShrWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhYendtHnkHrShrWk> getMetaClass() {
        return QIW_KhYendtHnkHrShrWk.class;
    }

    @Id
    @Column(name=GenIW_KhYendtHnkHrShrWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhYendtHnkHrShrWk.SYONO)
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
    @Column(name=GenIW_KhYendtHnkHrShrWk.SKSSAKUSEIYMD)
    public BizDate getSkssakuseiymd() {
        return skssakuseiymd;
    }

    public void setSkssakuseiymd(BizDate pSkssakuseiymd) {
        skssakuseiymd = pSkssakuseiymd;
    }

    private C_Khhrshrjiyuu khhrshrjiyuu;

    @Type(type="UserType_C_Khhrshrjiyuu")
    @Column(name=GenIW_KhYendtHnkHrShrWk.KHHRSHRJIYUU)
    public C_Khhrshrjiyuu getKhhrshrjiyuu() {
        return khhrshrjiyuu;
    }

    public void setKhhrshrjiyuu(C_Khhrshrjiyuu pKhhrshrjiyuu) {
        khhrshrjiyuu = pKhhrshrjiyuu;
    }

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhYendtHnkHrShrWk.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private String shnmkj;

    @Column(name=GenIW_KhYendtHnkHrShrWk.SHNMKJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShnmkj() {
        return shnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShnmkj(String pShnmkj) {
        shnmkj = pShnmkj;
    }

    private String shskyno;

    @Column(name=GenIW_KhYendtHnkHrShrWk.SHSKYNO)
    @Length(length=7)
    @Digit
    public String getShskyno() {
        return shskyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShskyno(String pShskyno) {
        shskyno = pShskyno;
    }

    private String shsadr1kj;

    @Column(name=GenIW_KhYendtHnkHrShrWk.SHSADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr1kj() {
        return shsadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr1kj(String pShsadr1kj) {
        shsadr1kj = pShsadr1kj;
    }

    private String shsadr2kj;

    @Column(name=GenIW_KhYendtHnkHrShrWk.SHSADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr2kj() {
        return shsadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr2kj(String pShsadr2kj) {
        shsadr2kj = pShsadr2kj;
    }

    private String shsadr3kj;

    @Column(name=GenIW_KhYendtHnkHrShrWk.SHSADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr3kj() {
        return shsadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr3kj(String pShsadr3kj) {
        shsadr3kj = pShsadr3kj;
    }

    private C_Khskssakuseijiyuu khskssakuseijiyuu;

    @Type(type="UserType_C_Khskssakuseijiyuu")
    @Column(name=GenIW_KhYendtHnkHrShrWk.KHSKSSAKUSEIJIYUU)
    public C_Khskssakuseijiyuu getKhskssakuseijiyuu() {
        return khskssakuseijiyuu;
    }

    public void setKhskssakuseijiyuu(C_Khskssakuseijiyuu pKhskssakuseijiyuu) {
        khskssakuseijiyuu = pKhskssakuseijiyuu;
    }

    private String kyksyaszknmkn;

    @Column(name=GenIW_KhYendtHnkHrShrWk.KYKSYASZKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyksyaszknmkn() {
        return kyksyaszknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszknmkn(String pKyksyaszknmkn) {
        kyksyaszknmkn = pKyksyaszknmkn;
    }

    private String kyksyaszknmkj;

    @Column(name=GenIW_KhYendtHnkHrShrWk.KYKSYASZKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszknmkj() {
        return kyksyaszknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszknmkj(String pKyksyaszknmkj) {
        kyksyaszknmkj = pKyksyaszknmkj;
    }

    private String kyksyaszkyno;

    @Column(name=GenIW_KhYendtHnkHrShrWk.KYKSYASZKYNO)
    @Digit
    @Length(length=7)
    public String getKyksyaszkyno() {
        return kyksyaszkyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKyksyaszkyno(String pKyksyaszkyno) {
        kyksyaszkyno = pKyksyaszkyno;
    }

    private String kyksyaszkadr1kj;

    @Column(name=GenIW_KhYendtHnkHrShrWk.KYKSYASZKADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszkadr1kj() {
        return kyksyaszkadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszkadr1kj(String pKyksyaszkadr1kj) {
        kyksyaszkadr1kj = pKyksyaszkadr1kj;
    }

    private String kyksyaszkadr2kj;

    @Column(name=GenIW_KhYendtHnkHrShrWk.KYKSYASZKADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszkadr2kj() {
        return kyksyaszkadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszkadr2kj(String pKyksyaszkadr2kj) {
        kyksyaszkadr2kj = pKyksyaszkadr2kj;
    }

    private String kyksyaszkadr3kj;

    @Column(name=GenIW_KhYendtHnkHrShrWk.KYKSYASZKADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszkadr3kj() {
        return kyksyaszkadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszkadr3kj(String pKyksyaszkadr3kj) {
        kyksyaszkadr3kj = pKyksyaszkadr3kj;
    }

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    @Type(type="UserType_C_InputShrhousiteiKbn")
    @Column(name=GenIW_KhYendtHnkHrShrWk.INPUTSHRHOUSITEIKBN)
    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    private String bankcd;

    @Column(name=GenIW_KhYendtHnkHrShrWk.BANKCD)
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

    @Column(name=GenIW_KhYendtHnkHrShrWk.SITENCD)
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
    @Column(name=GenIW_KhYendtHnkHrShrWk.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIW_KhYendtHnkHrShrWk.KOUZANO)
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
    @Column(name=GenIW_KhYendtHnkHrShrWk.KZDOUKBN)
    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenIW_KhYendtHnkHrShrWk.KZMEIGINMKN)
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

    @Column(name=GenIW_KhYendtHnkHrShrWk.KYKMNMEIGIBANGOU)
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

    @Column(name=GenIW_KhYendtHnkHrShrWk.UKTMNMEIGIBANGOU)
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

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIW_KhYendtHnkHrShrWk.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIW_KhYendtHnkHrShrWk.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhYendtHnkHrShrWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhYendtHnkHrShrWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhYendtHnkHrShrWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhYendtHnkHrShrWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}