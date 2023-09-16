package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.id.PKBM_Address;
import yuyu.def.db.meta.GenQBM_Address;
import yuyu.def.db.meta.QBM_Address;
import yuyu.def.db.type.UserType_C_KihontikucdSyoumetuKbn;
import yuyu.def.db.type.UserType_C_TodouhukenKbn;

/**
 * 住所マスタ テーブルのマッピング情報クラスで、 {@link BM_Address} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Address}</td><td colspan="3">住所マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getPostalCd postalCd}</td><td>郵便番号</td><td align="center">{@link PKBM_Address ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihontikucdsimo1 kihontikucdsimo1}</td><td>基本地区コード下１桁</td><td align="center">{@link PKBM_Address ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihontikucdsyoumetukbn kihontikucdsyoumetukbn}</td><td>基本地区コード消滅理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihontikucdSyoumetuKbn}</td></tr>
 *  <tr><td>{@link #getKjadrkyoutotuusyounmari kjadrkyoutotuusyounmari}</td><td>漢字住所（京都市内通称町名あり）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjtodouhukennmketasuu kjtodouhukennmketasuu}</td><td>漢字都道府県名桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKjsikugunnmketasuu kjsikugunnmketasuu}</td><td>漢字市区郡名桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKjsikutyousonnmketasuu kjsikutyousonnmketasuu}</td><td>漢字市区町村名桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKjtyousonnmketasuu kjtyousonnmketasuu}</td><td>漢字町村名桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKjkyoutotuusyounmketasuu kjkyoutotuusyounmketasuu}</td><td>漢字京都市内通称町名桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKjadrketasuu kjadrketasuu}</td><td>漢字住所桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKnadrkyoutotuusyounmari knadrkyoutotuusyounmari}</td><td>カナ住所（京都市内通称町名あり）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKntodouhukennmketasuu kntodouhukennmketasuu}</td><td>カナ都道府県名桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKnsikugunnmketasuu knsikugunnmketasuu}</td><td>カナ市区郡名桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKnsikutyousonnmketasuu knsikutyousonnmketasuu}</td><td>カナ市区町村名桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKntyousonnmketasuu kntyousonnmketasuu}</td><td>カナ町村名桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKnkyoutotuusyounmketasuu knkyoutotuusyounmketasuu}</td><td>カナ京都市内通称町名桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKnadrketasuu knadrketasuu}</td><td>カナ住所桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTodouhukencd todouhukencd}</td><td>都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TodouhukenKbn}</td></tr>
 *  <tr><td>{@link #getGyouseikukakucd gyouseikukakucd}</td><td>行政区画コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIkoumaekihontikucd ikoumaekihontikucd}</td><td>移行前基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNewynohyouji newynohyouji}</td><td>新郵便番号表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAdrkj adrkj}</td><td>住所（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAdrkn adrkn}</td><td>住所（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAdrknblankari adrknblankari}</td><td>住所（カナ）（空白あり）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Address
 * @see     PKBM_Address
 * @see     QBM_Address
 * @see     GenQBM_Address
 */
@MappedSuperclass
@Table(name=GenBM_Address.TABLE_NAME)
@IdClass(value=PKBM_Address.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KihontikucdSyoumetuKbn", typeClass=UserType_C_KihontikucdSyoumetuKbn.class),
    @TypeDef(name="UserType_C_TodouhukenKbn", typeClass=UserType_C_TodouhukenKbn.class)
})
public abstract class GenBM_Address extends AbstractExDBEntity<BM_Address, PKBM_Address> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Address";
    public static final String POSTALCD                 = "postalCd";
    public static final String KIHONTIKUCDSIMO1         = "kihontikucdsimo1";
    public static final String KIHONTIKUCDSYOUMETUKBN   = "kihontikucdsyoumetukbn";
    public static final String KJADRKYOUTOTUUSYOUNMARI  = "kjadrkyoutotuusyounmari";
    public static final String KJTODOUHUKENNMKETASUU    = "kjtodouhukennmketasuu";
    public static final String KJSIKUGUNNMKETASUU       = "kjsikugunnmketasuu";
    public static final String KJSIKUTYOUSONNMKETASUU   = "kjsikutyousonnmketasuu";
    public static final String KJTYOUSONNMKETASUU       = "kjtyousonnmketasuu";
    public static final String KJKYOUTOTUUSYOUNMKETASUU = "kjkyoutotuusyounmketasuu";
    public static final String KJADRKETASUU             = "kjadrketasuu";
    public static final String KNADRKYOUTOTUUSYOUNMARI  = "knadrkyoutotuusyounmari";
    public static final String KNTODOUHUKENNMKETASUU    = "kntodouhukennmketasuu";
    public static final String KNSIKUGUNNMKETASUU       = "knsikugunnmketasuu";
    public static final String KNSIKUTYOUSONNMKETASUU   = "knsikutyousonnmketasuu";
    public static final String KNTYOUSONNMKETASUU       = "kntyousonnmketasuu";
    public static final String KNKYOUTOTUUSYOUNMKETASUU = "knkyoutotuusyounmketasuu";
    public static final String KNADRKETASUU             = "knadrketasuu";
    public static final String TODOUHUKENCD             = "todouhukencd";
    public static final String GYOUSEIKUKAKUCD          = "gyouseikukakucd";
    public static final String IKOUMAEKIHONTIKUCD       = "ikoumaekihontikucd";
    public static final String NEWYNOHYOUJI             = "newynohyouji";
    public static final String ADRKJ                    = "adrkj";
    public static final String ADRKN                    = "adrkn";
    public static final String ADRKNBLANKARI            = "adrknblankari";

    private final PKBM_Address primaryKey;

    public GenBM_Address() {
        primaryKey = new PKBM_Address();
    }

    public GenBM_Address(String pPostalCd, String pKihontikucdsimo1) {
        primaryKey = new PKBM_Address(pPostalCd, pKihontikucdsimo1);
    }

    @Transient
    @Override
    public PKBM_Address getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Address> getMetaClass() {
        return QBM_Address.class;
    }

    @Id
    @Column(name=GenBM_Address.POSTALCD)
    @Length(length=7)
    @Digit
    public String getPostalCd() {
        return getPrimaryKey().getPostalCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPostalCd(String pPostalCd) {
        getPrimaryKey().setPostalCd(pPostalCd);
    }

    @Id
    @Column(name=GenBM_Address.KIHONTIKUCDSIMO1)
    public String getKihontikucdsimo1() {
        return getPrimaryKey().getKihontikucdsimo1();
    }

    public void setKihontikucdsimo1(String pKihontikucdsimo1) {
        getPrimaryKey().setKihontikucdsimo1(pKihontikucdsimo1);
    }

    private C_KihontikucdSyoumetuKbn kihontikucdsyoumetukbn;

    @Type(type="UserType_C_KihontikucdSyoumetuKbn")
    @Column(name=GenBM_Address.KIHONTIKUCDSYOUMETUKBN)
    public C_KihontikucdSyoumetuKbn getKihontikucdsyoumetukbn() {
        return kihontikucdsyoumetukbn;
    }

    public void setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn) {
        kihontikucdsyoumetukbn = pKihontikucdsyoumetukbn;
    }

    private String kjadrkyoutotuusyounmari;

    @Column(name=GenBM_Address.KJADRKYOUTOTUUSYOUNMARI)
    public String getKjadrkyoutotuusyounmari() {
        return kjadrkyoutotuusyounmari;
    }

    public void setKjadrkyoutotuusyounmari(String pKjadrkyoutotuusyounmari) {
        kjadrkyoutotuusyounmari = pKjadrkyoutotuusyounmari;
    }

    private Integer kjtodouhukennmketasuu;

    @Column(name=GenBM_Address.KJTODOUHUKENNMKETASUU)
    public Integer getKjtodouhukennmketasuu() {
        return kjtodouhukennmketasuu;
    }

    public void setKjtodouhukennmketasuu(Integer pKjtodouhukennmketasuu) {
        kjtodouhukennmketasuu = pKjtodouhukennmketasuu;
    }

    private Integer kjsikugunnmketasuu;

    @Column(name=GenBM_Address.KJSIKUGUNNMKETASUU)
    public Integer getKjsikugunnmketasuu() {
        return kjsikugunnmketasuu;
    }

    public void setKjsikugunnmketasuu(Integer pKjsikugunnmketasuu) {
        kjsikugunnmketasuu = pKjsikugunnmketasuu;
    }

    private Integer kjsikutyousonnmketasuu;

    @Column(name=GenBM_Address.KJSIKUTYOUSONNMKETASUU)
    public Integer getKjsikutyousonnmketasuu() {
        return kjsikutyousonnmketasuu;
    }

    public void setKjsikutyousonnmketasuu(Integer pKjsikutyousonnmketasuu) {
        kjsikutyousonnmketasuu = pKjsikutyousonnmketasuu;
    }

    private Integer kjtyousonnmketasuu;

    @Column(name=GenBM_Address.KJTYOUSONNMKETASUU)
    public Integer getKjtyousonnmketasuu() {
        return kjtyousonnmketasuu;
    }

    public void setKjtyousonnmketasuu(Integer pKjtyousonnmketasuu) {
        kjtyousonnmketasuu = pKjtyousonnmketasuu;
    }

    private Integer kjkyoutotuusyounmketasuu;

    @Column(name=GenBM_Address.KJKYOUTOTUUSYOUNMKETASUU)
    public Integer getKjkyoutotuusyounmketasuu() {
        return kjkyoutotuusyounmketasuu;
    }

    public void setKjkyoutotuusyounmketasuu(Integer pKjkyoutotuusyounmketasuu) {
        kjkyoutotuusyounmketasuu = pKjkyoutotuusyounmketasuu;
    }

    private Integer kjadrketasuu;

    @Column(name=GenBM_Address.KJADRKETASUU)
    public Integer getKjadrketasuu() {
        return kjadrketasuu;
    }

    public void setKjadrketasuu(Integer pKjadrketasuu) {
        kjadrketasuu = pKjadrketasuu;
    }

    private String knadrkyoutotuusyounmari;

    @Column(name=GenBM_Address.KNADRKYOUTOTUUSYOUNMARI)
    public String getKnadrkyoutotuusyounmari() {
        return knadrkyoutotuusyounmari;
    }

    public void setKnadrkyoutotuusyounmari(String pKnadrkyoutotuusyounmari) {
        knadrkyoutotuusyounmari = pKnadrkyoutotuusyounmari;
    }

    private Integer kntodouhukennmketasuu;

    @Column(name=GenBM_Address.KNTODOUHUKENNMKETASUU)
    public Integer getKntodouhukennmketasuu() {
        return kntodouhukennmketasuu;
    }

    public void setKntodouhukennmketasuu(Integer pKntodouhukennmketasuu) {
        kntodouhukennmketasuu = pKntodouhukennmketasuu;
    }

    private Integer knsikugunnmketasuu;

    @Column(name=GenBM_Address.KNSIKUGUNNMKETASUU)
    public Integer getKnsikugunnmketasuu() {
        return knsikugunnmketasuu;
    }

    public void setKnsikugunnmketasuu(Integer pKnsikugunnmketasuu) {
        knsikugunnmketasuu = pKnsikugunnmketasuu;
    }

    private Integer knsikutyousonnmketasuu;

    @Column(name=GenBM_Address.KNSIKUTYOUSONNMKETASUU)
    public Integer getKnsikutyousonnmketasuu() {
        return knsikutyousonnmketasuu;
    }

    public void setKnsikutyousonnmketasuu(Integer pKnsikutyousonnmketasuu) {
        knsikutyousonnmketasuu = pKnsikutyousonnmketasuu;
    }

    private Integer kntyousonnmketasuu;

    @Column(name=GenBM_Address.KNTYOUSONNMKETASUU)
    public Integer getKntyousonnmketasuu() {
        return kntyousonnmketasuu;
    }

    public void setKntyousonnmketasuu(Integer pKntyousonnmketasuu) {
        kntyousonnmketasuu = pKntyousonnmketasuu;
    }

    private Integer knkyoutotuusyounmketasuu;

    @Column(name=GenBM_Address.KNKYOUTOTUUSYOUNMKETASUU)
    public Integer getKnkyoutotuusyounmketasuu() {
        return knkyoutotuusyounmketasuu;
    }

    public void setKnkyoutotuusyounmketasuu(Integer pKnkyoutotuusyounmketasuu) {
        knkyoutotuusyounmketasuu = pKnkyoutotuusyounmketasuu;
    }

    private Integer knadrketasuu;

    @Column(name=GenBM_Address.KNADRKETASUU)
    public Integer getKnadrketasuu() {
        return knadrketasuu;
    }

    public void setKnadrketasuu(Integer pKnadrketasuu) {
        knadrketasuu = pKnadrketasuu;
    }

    private C_TodouhukenKbn todouhukencd;

    @Type(type="UserType_C_TodouhukenKbn")
    @Column(name=GenBM_Address.TODOUHUKENCD)
    public C_TodouhukenKbn getTodouhukencd() {
        return todouhukencd;
    }

    public void setTodouhukencd(C_TodouhukenKbn pTodouhukencd) {
        todouhukencd = pTodouhukencd;
    }

    private String gyouseikukakucd;

    @Column(name=GenBM_Address.GYOUSEIKUKAKUCD)
    public String getGyouseikukakucd() {
        return gyouseikukakucd;
    }

    public void setGyouseikukakucd(String pGyouseikukakucd) {
        gyouseikukakucd = pGyouseikukakucd;
    }

    private String ikoumaekihontikucd;

    @Column(name=GenBM_Address.IKOUMAEKIHONTIKUCD)
    public String getIkoumaekihontikucd() {
        return ikoumaekihontikucd;
    }

    public void setIkoumaekihontikucd(String pIkoumaekihontikucd) {
        ikoumaekihontikucd = pIkoumaekihontikucd;
    }

    private String newynohyouji;

    @Column(name=GenBM_Address.NEWYNOHYOUJI)
    public String getNewynohyouji() {
        return newynohyouji;
    }

    public void setNewynohyouji(String pNewynohyouji) {
        newynohyouji = pNewynohyouji;
    }

    private String adrkj;

    @Column(name=GenBM_Address.ADRKJ)
    public String getAdrkj() {
        return adrkj;
    }

    public void setAdrkj(String pAdrkj) {
        adrkj = pAdrkj;
    }

    private String adrkn;

    @Column(name=GenBM_Address.ADRKN)
    public String getAdrkn() {
        return adrkn;
    }

    public void setAdrkn(String pAdrkn) {
        adrkn = pAdrkn;
    }

    private String adrknblankari;

    @Column(name=GenBM_Address.ADRKNBLANKARI)
    public String getAdrknblankari() {
        return adrknblankari;
    }

    public void setAdrknblankari(String pAdrknblankari) {
        adrknblankari = pAdrknblankari;
    }
}