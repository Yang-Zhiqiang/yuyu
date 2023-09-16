package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoukaiKanouHyj;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.id.PKBW_IdCardWk;
import yuyu.def.db.meta.GenQBW_IdCardWk;
import yuyu.def.db.meta.QBW_IdCardWk;
import yuyu.def.db.type.UserType_C_SyoukaiKanouHyj;

/**
 * ＩＤカードマスタワークテーブル テーブルのマッピング情報クラスで、 {@link BW_IdCardWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BW_IdCardWk}</td><td colspan="3">ＩＤカードマスタワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIdkbn idkbn}</td><td>ＩＤ区分</td><td align="center">{@link PKBW_IdCardWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdcd idcd}</td><td>ＩＤコード</td><td align="center">{@link PKBW_IdCardWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTanmatusiyoukbn tanmatusiyoukbn}</td><td>端末使用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAccesskbn accesskbn}</td><td>アクセス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdnyuuryokusyanm idnyuuryokusyanm}</td><td>ＩＤ入力者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjiidnyuuryokusyanm kanjiidnyuuryokusyanm}</td><td>漢字ＩＤ入力者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdnyuuryokusyaseiymd idnyuuryokusyaseiymd}</td><td>ＩＤ入力者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getIdnyuuryokusyanyuusyaymd idnyuuryokusyanyuusyaymd}</td><td>ＩＤ入力者入社年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyozokusosikicd syozokusosikicd}</td><td>所属組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyozokusisyacd syozokusisyacd}</td><td>所属支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyozokusibucd syozokusibucd}</td><td>所属支部コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdnyuuryokusyasikakucd idnyuuryokusyasikakucd}</td><td>ＩＤ入力者資格コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdsdpsouhuhyouji idsdpsouhuhyouji}</td><td>ＩＤＳＤＰ送付表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdcardsaisyuukousinymd idcardsaisyuukousinymd}</td><td>ＩＤカード最終更新年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getIdcardmukouymd idcardmukouymd}</td><td>ＩＤカード無効年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKaikeitantousyakbn kaikeitantousyakbn}</td><td>会計担当者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyanaiyokintantousyakbn syanaiyokintantousyakbn}</td><td>社内預金担当者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJinjimynosyoukaihyj jinjimynosyoukaihyj}</td><td>人事・マイナンバー照会可能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukaiKanouHyj}</td></tr>
 *  <tr><td>{@link #getEisyokumynosyoukaihyj eisyokumynosyoukaihyj}</td><td>営職・マイナンバー照会可能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukaiKanouHyj}</td></tr>
 *  <tr><td>{@link #getHudousanmynosyoukaihyj hudousanmynosyoukaihyj}</td><td>不動産・マイナンバー照会可能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukaiKanouHyj}</td></tr>
 *  <tr><td>{@link #getKohomynosyoukaihyj kohomynosyoukaihyj}</td><td>個保・マイナンバー照会可能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukaiKanouHyj}</td></tr>
 *  <tr><td>{@link #getKihomynosyoukaihyj kihomynosyoukaihyj}</td><td>企保・マイナンバー照会可能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukaiKanouHyj}</td></tr>
 *  <tr><td>{@link #getKikantantoukbn kikantantoukbn}</td><td>機関担当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BW_IdCardWk
 * @see     PKBW_IdCardWk
 * @see     QBW_IdCardWk
 * @see     GenQBW_IdCardWk
 */
@MappedSuperclass
@Table(name=GenBW_IdCardWk.TABLE_NAME)
@IdClass(value=PKBW_IdCardWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_SyoukaiKanouHyj", typeClass=UserType_C_SyoukaiKanouHyj.class)
})
public abstract class GenBW_IdCardWk extends AbstractExDBEntity<BW_IdCardWk, PKBW_IdCardWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BW_IdCardWk";
    public static final String IDKBN                    = "idkbn";
    public static final String IDCD                     = "idcd";
    public static final String TANMATUSIYOUKBN          = "tanmatusiyoukbn";
    public static final String ACCESSKBN                = "accesskbn";
    public static final String IDNYUURYOKUSYANM         = "idnyuuryokusyanm";
    public static final String KANJIIDNYUURYOKUSYANM    = "kanjiidnyuuryokusyanm";
    public static final String IDNYUURYOKUSYASEIYMD     = "idnyuuryokusyaseiymd";
    public static final String IDNYUURYOKUSYANYUUSYAYMD = "idnyuuryokusyanyuusyaymd";
    public static final String SYOZOKUSOSIKICD          = "syozokusosikicd";
    public static final String SYOZOKUSISYACD           = "syozokusisyacd";
    public static final String SYOZOKUSIBUCD            = "syozokusibucd";
    public static final String IDNYUURYOKUSYASIKAKUCD   = "idnyuuryokusyasikakucd";
    public static final String IDSDPSOUHUHYOUJI         = "idsdpsouhuhyouji";
    public static final String IDCARDSAISYUUKOUSINYMD   = "idcardsaisyuukousinymd";
    public static final String IDCARDMUKOUYMD           = "idcardmukouymd";
    public static final String KAIKEITANTOUSYAKBN       = "kaikeitantousyakbn";
    public static final String SYANAIYOKINTANTOUSYAKBN  = "syanaiyokintantousyakbn";
    public static final String JINJIMYNOSYOUKAIHYJ      = "jinjimynosyoukaihyj";
    public static final String EISYOKUMYNOSYOUKAIHYJ    = "eisyokumynosyoukaihyj";
    public static final String HUDOUSANMYNOSYOUKAIHYJ   = "hudousanmynosyoukaihyj";
    public static final String KOHOMYNOSYOUKAIHYJ       = "kohomynosyoukaihyj";
    public static final String KIHOMYNOSYOUKAIHYJ       = "kihomynosyoukaihyj";
    public static final String KIKANTANTOUKBN           = "kikantantoukbn";

    private final PKBW_IdCardWk primaryKey;

    public GenBW_IdCardWk() {
        primaryKey = new PKBW_IdCardWk();
    }

    public GenBW_IdCardWk(String pIdkbn, String pIdcd) {
        primaryKey = new PKBW_IdCardWk(pIdkbn, pIdcd);
    }

    @Transient
    @Override
    public PKBW_IdCardWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBW_IdCardWk> getMetaClass() {
        return QBW_IdCardWk.class;
    }

    @Id
    @Column(name=GenBW_IdCardWk.IDKBN)
    public String getIdkbn() {
        return getPrimaryKey().getIdkbn();
    }

    public void setIdkbn(String pIdkbn) {
        getPrimaryKey().setIdkbn(pIdkbn);
    }

    @Id
    @Column(name=GenBW_IdCardWk.IDCD)
    public String getIdcd() {
        return getPrimaryKey().getIdcd();
    }

    public void setIdcd(String pIdcd) {
        getPrimaryKey().setIdcd(pIdcd);
    }

    private String tanmatusiyoukbn;

    @Column(name=GenBW_IdCardWk.TANMATUSIYOUKBN)
    public String getTanmatusiyoukbn() {
        return tanmatusiyoukbn;
    }

    public void setTanmatusiyoukbn(String pTanmatusiyoukbn) {
        tanmatusiyoukbn = pTanmatusiyoukbn;
    }

    private String accesskbn;

    @Column(name=GenBW_IdCardWk.ACCESSKBN)
    public String getAccesskbn() {
        return accesskbn;
    }

    public void setAccesskbn(String pAccesskbn) {
        accesskbn = pAccesskbn;
    }

    private String idnyuuryokusyanm;

    @Column(name=GenBW_IdCardWk.IDNYUURYOKUSYANM)
    public String getIdnyuuryokusyanm() {
        return idnyuuryokusyanm;
    }

    public void setIdnyuuryokusyanm(String pIdnyuuryokusyanm) {
        idnyuuryokusyanm = pIdnyuuryokusyanm;
    }

    private String kanjiidnyuuryokusyanm;

    @Column(name=GenBW_IdCardWk.KANJIIDNYUURYOKUSYANM)
    public String getKanjiidnyuuryokusyanm() {
        return kanjiidnyuuryokusyanm;
    }

    public void setKanjiidnyuuryokusyanm(String pKanjiidnyuuryokusyanm) {
        kanjiidnyuuryokusyanm = pKanjiidnyuuryokusyanm;
    }

    private BizDate idnyuuryokusyaseiymd;

    @Type(type="BizDateType")
    @Column(name=GenBW_IdCardWk.IDNYUURYOKUSYASEIYMD)
    public BizDate getIdnyuuryokusyaseiymd() {
        return idnyuuryokusyaseiymd;
    }

    public void setIdnyuuryokusyaseiymd(BizDate pIdnyuuryokusyaseiymd) {
        idnyuuryokusyaseiymd = pIdnyuuryokusyaseiymd;
    }

    private BizDate idnyuuryokusyanyuusyaymd;

    @Type(type="BizDateType")
    @Column(name=GenBW_IdCardWk.IDNYUURYOKUSYANYUUSYAYMD)
    public BizDate getIdnyuuryokusyanyuusyaymd() {
        return idnyuuryokusyanyuusyaymd;
    }

    public void setIdnyuuryokusyanyuusyaymd(BizDate pIdnyuuryokusyanyuusyaymd) {
        idnyuuryokusyanyuusyaymd = pIdnyuuryokusyanyuusyaymd;
    }

    private String syozokusosikicd;

    @Column(name=GenBW_IdCardWk.SYOZOKUSOSIKICD)
    public String getSyozokusosikicd() {
        return syozokusosikicd;
    }

    public void setSyozokusosikicd(String pSyozokusosikicd) {
        syozokusosikicd = pSyozokusosikicd;
    }

    private String syozokusisyacd;

    @Column(name=GenBW_IdCardWk.SYOZOKUSISYACD)
    public String getSyozokusisyacd() {
        return syozokusisyacd;
    }

    public void setSyozokusisyacd(String pSyozokusisyacd) {
        syozokusisyacd = pSyozokusisyacd;
    }

    private String syozokusibucd;

    @Column(name=GenBW_IdCardWk.SYOZOKUSIBUCD)
    public String getSyozokusibucd() {
        return syozokusibucd;
    }

    public void setSyozokusibucd(String pSyozokusibucd) {
        syozokusibucd = pSyozokusibucd;
    }

    private String idnyuuryokusyasikakucd;

    @Column(name=GenBW_IdCardWk.IDNYUURYOKUSYASIKAKUCD)
    public String getIdnyuuryokusyasikakucd() {
        return idnyuuryokusyasikakucd;
    }

    public void setIdnyuuryokusyasikakucd(String pIdnyuuryokusyasikakucd) {
        idnyuuryokusyasikakucd = pIdnyuuryokusyasikakucd;
    }

    private String idsdpsouhuhyouji;

    @Column(name=GenBW_IdCardWk.IDSDPSOUHUHYOUJI)
    public String getIdsdpsouhuhyouji() {
        return idsdpsouhuhyouji;
    }

    public void setIdsdpsouhuhyouji(String pIdsdpsouhuhyouji) {
        idsdpsouhuhyouji = pIdsdpsouhuhyouji;
    }

    private BizDate idcardsaisyuukousinymd;

    @Type(type="BizDateType")
    @Column(name=GenBW_IdCardWk.IDCARDSAISYUUKOUSINYMD)
    public BizDate getIdcardsaisyuukousinymd() {
        return idcardsaisyuukousinymd;
    }

    public void setIdcardsaisyuukousinymd(BizDate pIdcardsaisyuukousinymd) {
        idcardsaisyuukousinymd = pIdcardsaisyuukousinymd;
    }

    private BizDate idcardmukouymd;

    @Type(type="BizDateType")
    @Column(name=GenBW_IdCardWk.IDCARDMUKOUYMD)
    public BizDate getIdcardmukouymd() {
        return idcardmukouymd;
    }

    public void setIdcardmukouymd(BizDate pIdcardmukouymd) {
        idcardmukouymd = pIdcardmukouymd;
    }

    private String kaikeitantousyakbn;

    @Column(name=GenBW_IdCardWk.KAIKEITANTOUSYAKBN)
    public String getKaikeitantousyakbn() {
        return kaikeitantousyakbn;
    }

    public void setKaikeitantousyakbn(String pKaikeitantousyakbn) {
        kaikeitantousyakbn = pKaikeitantousyakbn;
    }

    private String syanaiyokintantousyakbn;

    @Column(name=GenBW_IdCardWk.SYANAIYOKINTANTOUSYAKBN)
    public String getSyanaiyokintantousyakbn() {
        return syanaiyokintantousyakbn;
    }

    public void setSyanaiyokintantousyakbn(String pSyanaiyokintantousyakbn) {
        syanaiyokintantousyakbn = pSyanaiyokintantousyakbn;
    }

    private C_SyoukaiKanouHyj jinjimynosyoukaihyj;

    @Type(type="UserType_C_SyoukaiKanouHyj")
    @Column(name=GenBW_IdCardWk.JINJIMYNOSYOUKAIHYJ)
    public C_SyoukaiKanouHyj getJinjimynosyoukaihyj() {
        return jinjimynosyoukaihyj;
    }

    public void setJinjimynosyoukaihyj(C_SyoukaiKanouHyj pJinjimynosyoukaihyj) {
        jinjimynosyoukaihyj = pJinjimynosyoukaihyj;
    }

    private C_SyoukaiKanouHyj eisyokumynosyoukaihyj;

    @Type(type="UserType_C_SyoukaiKanouHyj")
    @Column(name=GenBW_IdCardWk.EISYOKUMYNOSYOUKAIHYJ)
    public C_SyoukaiKanouHyj getEisyokumynosyoukaihyj() {
        return eisyokumynosyoukaihyj;
    }

    public void setEisyokumynosyoukaihyj(C_SyoukaiKanouHyj pEisyokumynosyoukaihyj) {
        eisyokumynosyoukaihyj = pEisyokumynosyoukaihyj;
    }

    private C_SyoukaiKanouHyj hudousanmynosyoukaihyj;

    @Type(type="UserType_C_SyoukaiKanouHyj")
    @Column(name=GenBW_IdCardWk.HUDOUSANMYNOSYOUKAIHYJ)
    public C_SyoukaiKanouHyj getHudousanmynosyoukaihyj() {
        return hudousanmynosyoukaihyj;
    }

    public void setHudousanmynosyoukaihyj(C_SyoukaiKanouHyj pHudousanmynosyoukaihyj) {
        hudousanmynosyoukaihyj = pHudousanmynosyoukaihyj;
    }

    private C_SyoukaiKanouHyj kohomynosyoukaihyj;

    @Type(type="UserType_C_SyoukaiKanouHyj")
    @Column(name=GenBW_IdCardWk.KOHOMYNOSYOUKAIHYJ)
    public C_SyoukaiKanouHyj getKohomynosyoukaihyj() {
        return kohomynosyoukaihyj;
    }

    public void setKohomynosyoukaihyj(C_SyoukaiKanouHyj pKohomynosyoukaihyj) {
        kohomynosyoukaihyj = pKohomynosyoukaihyj;
    }

    private C_SyoukaiKanouHyj kihomynosyoukaihyj;

    @Type(type="UserType_C_SyoukaiKanouHyj")
    @Column(name=GenBW_IdCardWk.KIHOMYNOSYOUKAIHYJ)
    public C_SyoukaiKanouHyj getKihomynosyoukaihyj() {
        return kihomynosyoukaihyj;
    }

    public void setKihomynosyoukaihyj(C_SyoukaiKanouHyj pKihomynosyoukaihyj) {
        kihomynosyoukaihyj = pKihomynosyoukaihyj;
    }

    private String kikantantoukbn;

    @Column(name=GenBW_IdCardWk.KIKANTANTOUKBN)
    public String getKikantantoukbn() {
        return kikantantoukbn;
    }

    public void setKikantantoukbn(String pKikantantoukbn) {
        kikantantoukbn = pKikantantoukbn;
    }
}