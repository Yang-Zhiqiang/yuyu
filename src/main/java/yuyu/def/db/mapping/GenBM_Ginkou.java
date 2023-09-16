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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HrkmKanouihyj;
import yuyu.def.classification.C_Kokunaikwskameihyj;
import yuyu.def.db.entity.BM_Ginkou;
import yuyu.def.db.id.PKBM_Ginkou;
import yuyu.def.db.meta.GenQBM_Ginkou;
import yuyu.def.db.meta.QBM_Ginkou;
import yuyu.def.db.type.UserType_C_HrkmKanouihyj;
import yuyu.def.db.type.UserType_C_Kokunaikwskameihyj;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 銀行マスタ テーブルのマッピング情報クラスで、 {@link BM_Ginkou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Ginkou}</td><td colspan="3">銀行マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">{@link PKBM_Ginkou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">{@link PKBM_Ginkou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKousinymd kousinymd}</td><td>更新年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSinsetuymd sinsetuymd}</td><td>新設年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHaisiymd haisiymd}</td><td>廃止年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBanknmkn banknmkn}</td><td>銀行名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitennmkn sitennmkn}</td><td>支店名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBanknmkj banknmkj}</td><td>銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitennmkj sitennmkj}</td><td>支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBanknmej banknmej}</td><td>銀行名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitennmej sitennmej}</td><td>支店名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCsskyouteikaisiymd csskyouteikaisiymd}</td><td>ＣＳＳ協定開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCsskyouteikaijyoymd csskyouteikaijyoymd}</td><td>ＣＳＳ協定解除年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKokunaikwskameihyj kokunaikwskameihyj}</td><td>内国為替制度加盟表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kokunaikwskameihyj}</td></tr>
 *  <tr><td>{@link #getHrkmKanouihyj hrkmKanouihyj}</td><td>振込可能支店表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkmKanouihyj}</td></tr>
 * </table>
 * @see     BM_Ginkou
 * @see     PKBM_Ginkou
 * @see     QBM_Ginkou
 * @see     GenQBM_Ginkou
 */
@MappedSuperclass
@Table(name=GenBM_Ginkou.TABLE_NAME)
@IdClass(value=PKBM_Ginkou.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HrkmKanouihyj", typeClass=UserType_C_HrkmKanouihyj.class),
    @TypeDef(name="UserType_C_Kokunaikwskameihyj", typeClass=UserType_C_Kokunaikwskameihyj.class)
})
public abstract class GenBM_Ginkou extends AbstractExDBEntity<BM_Ginkou, PKBM_Ginkou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Ginkou";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String KOUSINYMD                = "kousinymd";
    public static final String SINSETUYMD               = "sinsetuymd";
    public static final String HAISIYMD                 = "haisiymd";
    public static final String BANKNMKN                 = "banknmkn";
    public static final String SITENNMKN                = "sitennmkn";
    public static final String BANKNMKJ                 = "banknmkj";
    public static final String SITENNMKJ                = "sitennmkj";
    public static final String BANKNMEJ                 = "banknmej";
    public static final String SITENNMEJ                = "sitennmej";
    public static final String CSSKYOUTEIKAISIYMD       = "csskyouteikaisiymd";
    public static final String CSSKYOUTEIKAIJYOYMD      = "csskyouteikaijyoymd";
    public static final String KOKUNAIKWSKAMEIHYJ       = "kokunaikwskameihyj";
    public static final String HRKMKANOUIHYJ            = "hrkmKanouihyj";

    private final PKBM_Ginkou primaryKey;

    public GenBM_Ginkou() {
        primaryKey = new PKBM_Ginkou();
    }

    public GenBM_Ginkou(String pBankcd, String pSitencd) {
        primaryKey = new PKBM_Ginkou(pBankcd, pSitencd);
    }

    @Transient
    @Override
    public PKBM_Ginkou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Ginkou> getMetaClass() {
        return QBM_Ginkou.class;
    }

    @Id
    @Column(name=GenBM_Ginkou.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return getPrimaryKey().getBankcd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        getPrimaryKey().setBankcd(pBankcd);
    }

    @Id
    @Column(name=GenBM_Ginkou.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return getPrimaryKey().getSitencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        getPrimaryKey().setSitencd(pSitencd);
    }

    private BizDate kousinymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Ginkou.KOUSINYMD)
    public BizDate getKousinymd() {
        return kousinymd;
    }

    public void setKousinymd(BizDate pKousinymd) {
        kousinymd = pKousinymd;
    }

    private BizDate sinsetuymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Ginkou.SINSETUYMD)
    public BizDate getSinsetuymd() {
        return sinsetuymd;
    }

    public void setSinsetuymd(BizDate pSinsetuymd) {
        sinsetuymd = pSinsetuymd;
    }

    private BizDate haisiymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Ginkou.HAISIYMD)
    public BizDate getHaisiymd() {
        return haisiymd;
    }

    public void setHaisiymd(BizDate pHaisiymd) {
        haisiymd = pHaisiymd;
    }

    private String banknmkn;

    @Column(name=GenBM_Ginkou.BANKNMKN)
    @MaxLength(max=25)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getBanknmkn() {
        return banknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBanknmkn(String pBanknmkn) {
        banknmkn = pBanknmkn;
    }

    private String sitennmkn;

    @Column(name=GenBM_Ginkou.SITENNMKN)
    @MaxLength(max=25)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSitennmkn() {
        return sitennmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSitennmkn(String pSitennmkn) {
        sitennmkn = pSitennmkn;
    }

    private String banknmkj;

    @Column(name=GenBM_Ginkou.BANKNMKJ)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getBanknmkj() {
        return banknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBanknmkj(String pBanknmkj) {
        banknmkj = pBanknmkj;
    }

    private String sitennmkj;

    @Column(name=GenBM_Ginkou.SITENNMKJ)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getSitennmkj() {
        return sitennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSitennmkj(String pSitennmkj) {
        sitennmkj = pSitennmkj;
    }

    private String banknmej;

    @Column(name=GenBM_Ginkou.BANKNMEJ)
    public String getBanknmej() {
        return banknmej;
    }

    public void setBanknmej(String pBanknmej) {
        banknmej = pBanknmej;
    }

    private String sitennmej;

    @Column(name=GenBM_Ginkou.SITENNMEJ)
    public String getSitennmej() {
        return sitennmej;
    }

    public void setSitennmej(String pSitennmej) {
        sitennmej = pSitennmej;
    }

    private BizDate csskyouteikaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Ginkou.CSSKYOUTEIKAISIYMD)
    public BizDate getCsskyouteikaisiymd() {
        return csskyouteikaisiymd;
    }

    public void setCsskyouteikaisiymd(BizDate pCsskyouteikaisiymd) {
        csskyouteikaisiymd = pCsskyouteikaisiymd;
    }

    private BizDate csskyouteikaijyoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Ginkou.CSSKYOUTEIKAIJYOYMD)
    public BizDate getCsskyouteikaijyoymd() {
        return csskyouteikaijyoymd;
    }

    public void setCsskyouteikaijyoymd(BizDate pCsskyouteikaijyoymd) {
        csskyouteikaijyoymd = pCsskyouteikaijyoymd;
    }

    private C_Kokunaikwskameihyj kokunaikwskameihyj;

    @Type(type="UserType_C_Kokunaikwskameihyj")
    @Column(name=GenBM_Ginkou.KOKUNAIKWSKAMEIHYJ)
    public C_Kokunaikwskameihyj getKokunaikwskameihyj() {
        return kokunaikwskameihyj;
    }

    public void setKokunaikwskameihyj(C_Kokunaikwskameihyj pKokunaikwskameihyj) {
        kokunaikwskameihyj = pKokunaikwskameihyj;
    }

    private C_HrkmKanouihyj hrkmKanouihyj;

    @Type(type="UserType_C_HrkmKanouihyj")
    @Column(name=GenBM_Ginkou.HRKMKANOUIHYJ)
    public C_HrkmKanouihyj getHrkmKanouihyj() {
        return hrkmKanouihyj;
    }

    public void setHrkmKanouihyj(C_HrkmKanouihyj pHrkmKanouihyj) {
        hrkmKanouihyj = pHrkmKanouihyj;
    }
}