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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BosyuuKbn;
import yuyu.def.classification.C_BsKahiKbn;
import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.def.db.id.PKBM_Bosyuunin;
import yuyu.def.db.meta.GenQBM_Bosyuunin;
import yuyu.def.db.meta.QBM_Bosyuunin;
import yuyu.def.db.type.UserType_C_BosyuuKbn;
import yuyu.def.db.type.UserType_C_BsKahiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * 募集人マスタ テーブルのマッピング情報クラスで、 {@link BM_Bosyuunin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Bosyuunin}</td><td colspan="3">募集人マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBosyuucd bosyuucd}</td><td>募集人コード</td><td align="center">{@link PKBM_Bosyuunin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuunm bosyuunm}</td><td>募集人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjibosyuuninnm kanjibosyuuninnm}</td><td>漢字募集人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getItakuymd itakuymd}</td><td>委託年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDairiten1cd dairiten1cd}</td><td>代理店コード（１）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairiten2cd dairiten2cd}</td><td>代理店コード（２）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairiten3cd dairiten3cd}</td><td>代理店コード（３）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitenkanrisosikicd1 dairitenkanrisosikicd1}</td><td>代理店管理組織コード（１）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitenkanrisosikicd2 dairitenkanrisosikicd2}</td><td>代理店管理組織コード（２）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitenkanrisosikicd3 dairitenkanrisosikicd3}</td><td>代理店管理組織コード（３）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuukbn bosyuukbn}</td><td>募集人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BosyuuKbn}</td></tr>
 *  <tr><td>{@link #getBosyuunintourokuymd bosyuunintourokuymd}</td><td>募集人登録年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBosyuukahikbn bosyuukahikbn}</td><td>募集可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BsKahiKbn}</td></tr>
 *  <tr><td>{@link #getBosyuuningyouhaiymd bosyuuningyouhaiymd}</td><td>募集人業廃年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHngkhknskktrkymd hngkhknskktrkymd}</td><td>変額保険資格登録年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHngkhknskktrkmsuymd hngkhknskktrkmsuymd}</td><td>変額保険資格登録抹消年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBosyuuseiymd bosyuuseiymd}</td><td>募集人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getItakukaiyakuymd itakukaiyakuymd}</td><td>委託解約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDaibosyuucd daibosyuucd}</td><td>代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuutrkno bosyuutrkno}</td><td>募集人登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Bosyuunin
 * @see     PKBM_Bosyuunin
 * @see     QBM_Bosyuunin
 * @see     GenQBM_Bosyuunin
 */
@MappedSuperclass
@Table(name=GenBM_Bosyuunin.TABLE_NAME)
@IdClass(value=PKBM_Bosyuunin.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_BosyuuKbn", typeClass=UserType_C_BosyuuKbn.class),
    @TypeDef(name="UserType_C_BsKahiKbn", typeClass=UserType_C_BsKahiKbn.class)
})
public abstract class GenBM_Bosyuunin extends AbstractExDBEntity<BM_Bosyuunin, PKBM_Bosyuunin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Bosyuunin";
    public static final String BOSYUUCD                 = "bosyuucd";
    public static final String BOSYUUNM                 = "bosyuunm";
    public static final String KANJIBOSYUUNINNM         = "kanjibosyuuninnm";
    public static final String ITAKUYMD                 = "itakuymd";
    public static final String DAIRITEN1CD              = "dairiten1cd";
    public static final String DAIRITEN2CD              = "dairiten2cd";
    public static final String DAIRITEN3CD              = "dairiten3cd";
    public static final String DAIRITENKANRISOSIKICD1   = "dairitenkanrisosikicd1";
    public static final String DAIRITENKANRISOSIKICD2   = "dairitenkanrisosikicd2";
    public static final String DAIRITENKANRISOSIKICD3   = "dairitenkanrisosikicd3";
    public static final String BOSYUUKBN                = "bosyuukbn";
    public static final String BOSYUUNINTOUROKUYMD      = "bosyuunintourokuymd";
    public static final String BOSYUUKAHIKBN            = "bosyuukahikbn";
    public static final String BOSYUUNINGYOUHAIYMD      = "bosyuuningyouhaiymd";
    public static final String HNGKHKNSKKTRKYMD         = "hngkhknskktrkymd";
    public static final String HNGKHKNSKKTRKMSUYMD      = "hngkhknskktrkmsuymd";
    public static final String BOSYUUSEIYMD             = "bosyuuseiymd";
    public static final String ITAKUKAIYAKUYMD          = "itakukaiyakuymd";
    public static final String DAIBOSYUUCD              = "daibosyuucd";
    public static final String BOSYUUTRKNO              = "bosyuutrkno";

    private final PKBM_Bosyuunin primaryKey;

    public GenBM_Bosyuunin() {
        primaryKey = new PKBM_Bosyuunin();
    }

    public GenBM_Bosyuunin(String pBosyuucd) {
        primaryKey = new PKBM_Bosyuunin(pBosyuucd);
    }

    @Transient
    @Override
    public PKBM_Bosyuunin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Bosyuunin> getMetaClass() {
        return QBM_Bosyuunin.class;
    }

    @Id
    @Column(name=GenBM_Bosyuunin.BOSYUUCD)
    @MaxLength(max=6)
    @AlphaDigit
    public String getBosyuucd() {
        return getPrimaryKey().getBosyuucd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd(String pBosyuucd) {
        getPrimaryKey().setBosyuucd(pBosyuucd);
    }

    private String bosyuunm;

    @Column(name=GenBM_Bosyuunin.BOSYUUNM)
    public String getBosyuunm() {
        return bosyuunm;
    }

    public void setBosyuunm(String pBosyuunm) {
        bosyuunm = pBosyuunm;
    }

    private String kanjibosyuuninnm;

    @Column(name=GenBM_Bosyuunin.KANJIBOSYUUNINNM)
    public String getKanjibosyuuninnm() {
        return kanjibosyuuninnm;
    }

    public void setKanjibosyuuninnm(String pKanjibosyuuninnm) {
        kanjibosyuuninnm = pKanjibosyuuninnm;
    }

    private BizDate itakuymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Bosyuunin.ITAKUYMD)
    public BizDate getItakuymd() {
        return itakuymd;
    }

    public void setItakuymd(BizDate pItakuymd) {
        itakuymd = pItakuymd;
    }

    private String dairiten1cd;

    @Column(name=GenBM_Bosyuunin.DAIRITEN1CD)
    public String getDairiten1cd() {
        return dairiten1cd;
    }

    public void setDairiten1cd(String pDairiten1cd) {
        dairiten1cd = pDairiten1cd;
    }

    private String dairiten2cd;

    @Column(name=GenBM_Bosyuunin.DAIRITEN2CD)
    public String getDairiten2cd() {
        return dairiten2cd;
    }

    public void setDairiten2cd(String pDairiten2cd) {
        dairiten2cd = pDairiten2cd;
    }

    private String dairiten3cd;

    @Column(name=GenBM_Bosyuunin.DAIRITEN3CD)
    public String getDairiten3cd() {
        return dairiten3cd;
    }

    public void setDairiten3cd(String pDairiten3cd) {
        dairiten3cd = pDairiten3cd;
    }

    private String dairitenkanrisosikicd1;

    @Column(name=GenBM_Bosyuunin.DAIRITENKANRISOSIKICD1)
    public String getDairitenkanrisosikicd1() {
        return dairitenkanrisosikicd1;
    }

    public void setDairitenkanrisosikicd1(String pDairitenkanrisosikicd1) {
        dairitenkanrisosikicd1 = pDairitenkanrisosikicd1;
    }

    private String dairitenkanrisosikicd2;

    @Column(name=GenBM_Bosyuunin.DAIRITENKANRISOSIKICD2)
    public String getDairitenkanrisosikicd2() {
        return dairitenkanrisosikicd2;
    }

    public void setDairitenkanrisosikicd2(String pDairitenkanrisosikicd2) {
        dairitenkanrisosikicd2 = pDairitenkanrisosikicd2;
    }

    private String dairitenkanrisosikicd3;

    @Column(name=GenBM_Bosyuunin.DAIRITENKANRISOSIKICD3)
    public String getDairitenkanrisosikicd3() {
        return dairitenkanrisosikicd3;
    }

    public void setDairitenkanrisosikicd3(String pDairitenkanrisosikicd3) {
        dairitenkanrisosikicd3 = pDairitenkanrisosikicd3;
    }

    private C_BosyuuKbn bosyuukbn;

    @Type(type="UserType_C_BosyuuKbn")
    @Column(name=GenBM_Bosyuunin.BOSYUUKBN)
    public C_BosyuuKbn getBosyuukbn() {
        return bosyuukbn;
    }

    public void setBosyuukbn(C_BosyuuKbn pBosyuukbn) {
        bosyuukbn = pBosyuukbn;
    }

    private BizDate bosyuunintourokuymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Bosyuunin.BOSYUUNINTOUROKUYMD)
    public BizDate getBosyuunintourokuymd() {
        return bosyuunintourokuymd;
    }

    public void setBosyuunintourokuymd(BizDate pBosyuunintourokuymd) {
        bosyuunintourokuymd = pBosyuunintourokuymd;
    }

    private C_BsKahiKbn bosyuukahikbn;

    @Type(type="UserType_C_BsKahiKbn")
    @Column(name=GenBM_Bosyuunin.BOSYUUKAHIKBN)
    public C_BsKahiKbn getBosyuukahikbn() {
        return bosyuukahikbn;
    }

    public void setBosyuukahikbn(C_BsKahiKbn pBosyuukahikbn) {
        bosyuukahikbn = pBosyuukahikbn;
    }

    private BizDate bosyuuningyouhaiymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Bosyuunin.BOSYUUNINGYOUHAIYMD)
    public BizDate getBosyuuningyouhaiymd() {
        return bosyuuningyouhaiymd;
    }

    public void setBosyuuningyouhaiymd(BizDate pBosyuuningyouhaiymd) {
        bosyuuningyouhaiymd = pBosyuuningyouhaiymd;
    }

    private BizDate hngkhknskktrkymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Bosyuunin.HNGKHKNSKKTRKYMD)
    public BizDate getHngkhknskktrkymd() {
        return hngkhknskktrkymd;
    }

    public void setHngkhknskktrkymd(BizDate pHngkhknskktrkymd) {
        hngkhknskktrkymd = pHngkhknskktrkymd;
    }

    private BizDate hngkhknskktrkmsuymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Bosyuunin.HNGKHKNSKKTRKMSUYMD)
    public BizDate getHngkhknskktrkmsuymd() {
        return hngkhknskktrkmsuymd;
    }

    public void setHngkhknskktrkmsuymd(BizDate pHngkhknskktrkmsuymd) {
        hngkhknskktrkmsuymd = pHngkhknskktrkmsuymd;
    }

    private BizDate bosyuuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Bosyuunin.BOSYUUSEIYMD)
    @ValidDate
    public BizDate getBosyuuseiymd() {
        return bosyuuseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuseiymd(BizDate pBosyuuseiymd) {
        bosyuuseiymd = pBosyuuseiymd;
    }

    private BizDate itakukaiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Bosyuunin.ITAKUKAIYAKUYMD)
    public BizDate getItakukaiyakuymd() {
        return itakukaiyakuymd;
    }

    public void setItakukaiyakuymd(BizDate pItakukaiyakuymd) {
        itakukaiyakuymd = pItakukaiyakuymd;
    }

    private String daibosyuucd;

    @Column(name=GenBM_Bosyuunin.DAIBOSYUUCD)
    @HostInvalidCharacter
    public String getDaibosyuucd() {
        return daibosyuucd;
    }

    public void setDaibosyuucd(String pDaibosyuucd) {
        daibosyuucd = pDaibosyuucd;
    }

    private String bosyuutrkno;

    @Column(name=GenBM_Bosyuunin.BOSYUUTRKNO)
    public String getBosyuutrkno() {
        return bosyuutrkno;
    }

    public void setBosyuutrkno(String pBosyuutrkno) {
        bosyuutrkno = pBosyuutrkno;
    }
}