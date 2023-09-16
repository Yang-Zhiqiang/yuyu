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
import yuyu.def.db.entity.AM_IdCard;
import yuyu.def.db.id.PKAM_IdCard;
import yuyu.def.db.meta.GenQAM_IdCard;
import yuyu.def.db.meta.QAM_IdCard;
import yuyu.def.db.type.UserType_C_SyoukaiKanouHyj;

/**
 * ＩＤカードマスタ テーブルのマッピング情報クラスで、 {@link AM_IdCard} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_IdCard}</td><td colspan="3">ＩＤカードマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIdkbn idkbn}</td><td>ＩＤ区分</td><td align="center">{@link PKAM_IdCard ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdcd idcd}</td><td>ＩＤコード</td><td align="center">{@link PKAM_IdCard ○}</td><td align="center">V</td><td>String</td></tr>
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
 * @see     AM_IdCard
 * @see     PKAM_IdCard
 * @see     QAM_IdCard
 * @see     GenQAM_IdCard
 */
@MappedSuperclass
@Table(name=GenAM_IdCard.TABLE_NAME)
@IdClass(value=PKAM_IdCard.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_SyoukaiKanouHyj", typeClass=UserType_C_SyoukaiKanouHyj.class)
})
public abstract class GenAM_IdCard extends AbstractExDBEntity<AM_IdCard, PKAM_IdCard> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_IdCard";
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

    private final PKAM_IdCard primaryKey;

    public GenAM_IdCard() {
        primaryKey = new PKAM_IdCard();
    }

    public GenAM_IdCard(String pIdkbn, String pIdcd) {
        primaryKey = new PKAM_IdCard(pIdkbn, pIdcd);
    }

    @Transient
    @Override
    public PKAM_IdCard getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_IdCard> getMetaClass() {
        return QAM_IdCard.class;
    }

    @Id
    @Column(name=GenAM_IdCard.IDKBN)
    public String getIdkbn() {
        return getPrimaryKey().getIdkbn();
    }

    public void setIdkbn(String pIdkbn) {
        getPrimaryKey().setIdkbn(pIdkbn);
    }

    @Id
    @Column(name=GenAM_IdCard.IDCD)
    public String getIdcd() {
        return getPrimaryKey().getIdcd();
    }

    public void setIdcd(String pIdcd) {
        getPrimaryKey().setIdcd(pIdcd);
    }

    private String tanmatusiyoukbn;

    @Column(name=GenAM_IdCard.TANMATUSIYOUKBN)
    public String getTanmatusiyoukbn() {
        return tanmatusiyoukbn;
    }

    public void setTanmatusiyoukbn(String pTanmatusiyoukbn) {
        tanmatusiyoukbn = pTanmatusiyoukbn;
    }

    private String accesskbn;

    @Column(name=GenAM_IdCard.ACCESSKBN)
    public String getAccesskbn() {
        return accesskbn;
    }

    public void setAccesskbn(String pAccesskbn) {
        accesskbn = pAccesskbn;
    }

    private String idnyuuryokusyanm;

    @Column(name=GenAM_IdCard.IDNYUURYOKUSYANM)
    public String getIdnyuuryokusyanm() {
        return idnyuuryokusyanm;
    }

    public void setIdnyuuryokusyanm(String pIdnyuuryokusyanm) {
        idnyuuryokusyanm = pIdnyuuryokusyanm;
    }

    private String kanjiidnyuuryokusyanm;

    @Column(name=GenAM_IdCard.KANJIIDNYUURYOKUSYANM)
    public String getKanjiidnyuuryokusyanm() {
        return kanjiidnyuuryokusyanm;
    }

    public void setKanjiidnyuuryokusyanm(String pKanjiidnyuuryokusyanm) {
        kanjiidnyuuryokusyanm = pKanjiidnyuuryokusyanm;
    }

    private BizDate idnyuuryokusyaseiymd;

    @Type(type="BizDateType")
    @Column(name=GenAM_IdCard.IDNYUURYOKUSYASEIYMD)
    public BizDate getIdnyuuryokusyaseiymd() {
        return idnyuuryokusyaseiymd;
    }

    public void setIdnyuuryokusyaseiymd(BizDate pIdnyuuryokusyaseiymd) {
        idnyuuryokusyaseiymd = pIdnyuuryokusyaseiymd;
    }

    private BizDate idnyuuryokusyanyuusyaymd;

    @Type(type="BizDateType")
    @Column(name=GenAM_IdCard.IDNYUURYOKUSYANYUUSYAYMD)
    public BizDate getIdnyuuryokusyanyuusyaymd() {
        return idnyuuryokusyanyuusyaymd;
    }

    public void setIdnyuuryokusyanyuusyaymd(BizDate pIdnyuuryokusyanyuusyaymd) {
        idnyuuryokusyanyuusyaymd = pIdnyuuryokusyanyuusyaymd;
    }

    private String syozokusosikicd;

    @Column(name=GenAM_IdCard.SYOZOKUSOSIKICD)
    public String getSyozokusosikicd() {
        return syozokusosikicd;
    }

    public void setSyozokusosikicd(String pSyozokusosikicd) {
        syozokusosikicd = pSyozokusosikicd;
    }

    private String syozokusisyacd;

    @Column(name=GenAM_IdCard.SYOZOKUSISYACD)
    public String getSyozokusisyacd() {
        return syozokusisyacd;
    }

    public void setSyozokusisyacd(String pSyozokusisyacd) {
        syozokusisyacd = pSyozokusisyacd;
    }

    private String syozokusibucd;

    @Column(name=GenAM_IdCard.SYOZOKUSIBUCD)
    public String getSyozokusibucd() {
        return syozokusibucd;
    }

    public void setSyozokusibucd(String pSyozokusibucd) {
        syozokusibucd = pSyozokusibucd;
    }

    private String idnyuuryokusyasikakucd;

    @Column(name=GenAM_IdCard.IDNYUURYOKUSYASIKAKUCD)
    public String getIdnyuuryokusyasikakucd() {
        return idnyuuryokusyasikakucd;
    }

    public void setIdnyuuryokusyasikakucd(String pIdnyuuryokusyasikakucd) {
        idnyuuryokusyasikakucd = pIdnyuuryokusyasikakucd;
    }

    private String idsdpsouhuhyouji;

    @Column(name=GenAM_IdCard.IDSDPSOUHUHYOUJI)
    public String getIdsdpsouhuhyouji() {
        return idsdpsouhuhyouji;
    }

    public void setIdsdpsouhuhyouji(String pIdsdpsouhuhyouji) {
        idsdpsouhuhyouji = pIdsdpsouhuhyouji;
    }

    private BizDate idcardsaisyuukousinymd;

    @Type(type="BizDateType")
    @Column(name=GenAM_IdCard.IDCARDSAISYUUKOUSINYMD)
    public BizDate getIdcardsaisyuukousinymd() {
        return idcardsaisyuukousinymd;
    }

    public void setIdcardsaisyuukousinymd(BizDate pIdcardsaisyuukousinymd) {
        idcardsaisyuukousinymd = pIdcardsaisyuukousinymd;
    }

    private BizDate idcardmukouymd;

    @Type(type="BizDateType")
    @Column(name=GenAM_IdCard.IDCARDMUKOUYMD)
    public BizDate getIdcardmukouymd() {
        return idcardmukouymd;
    }

    public void setIdcardmukouymd(BizDate pIdcardmukouymd) {
        idcardmukouymd = pIdcardmukouymd;
    }

    private String kaikeitantousyakbn;

    @Column(name=GenAM_IdCard.KAIKEITANTOUSYAKBN)
    public String getKaikeitantousyakbn() {
        return kaikeitantousyakbn;
    }

    public void setKaikeitantousyakbn(String pKaikeitantousyakbn) {
        kaikeitantousyakbn = pKaikeitantousyakbn;
    }

    private String syanaiyokintantousyakbn;

    @Column(name=GenAM_IdCard.SYANAIYOKINTANTOUSYAKBN)
    public String getSyanaiyokintantousyakbn() {
        return syanaiyokintantousyakbn;
    }

    public void setSyanaiyokintantousyakbn(String pSyanaiyokintantousyakbn) {
        syanaiyokintantousyakbn = pSyanaiyokintantousyakbn;
    }

    private C_SyoukaiKanouHyj jinjimynosyoukaihyj;

    @Type(type="UserType_C_SyoukaiKanouHyj")
    @Column(name=GenAM_IdCard.JINJIMYNOSYOUKAIHYJ)
    public C_SyoukaiKanouHyj getJinjimynosyoukaihyj() {
        return jinjimynosyoukaihyj;
    }

    public void setJinjimynosyoukaihyj(C_SyoukaiKanouHyj pJinjimynosyoukaihyj) {
        jinjimynosyoukaihyj = pJinjimynosyoukaihyj;
    }

    private C_SyoukaiKanouHyj eisyokumynosyoukaihyj;

    @Type(type="UserType_C_SyoukaiKanouHyj")
    @Column(name=GenAM_IdCard.EISYOKUMYNOSYOUKAIHYJ)
    public C_SyoukaiKanouHyj getEisyokumynosyoukaihyj() {
        return eisyokumynosyoukaihyj;
    }

    public void setEisyokumynosyoukaihyj(C_SyoukaiKanouHyj pEisyokumynosyoukaihyj) {
        eisyokumynosyoukaihyj = pEisyokumynosyoukaihyj;
    }

    private C_SyoukaiKanouHyj hudousanmynosyoukaihyj;

    @Type(type="UserType_C_SyoukaiKanouHyj")
    @Column(name=GenAM_IdCard.HUDOUSANMYNOSYOUKAIHYJ)
    public C_SyoukaiKanouHyj getHudousanmynosyoukaihyj() {
        return hudousanmynosyoukaihyj;
    }

    public void setHudousanmynosyoukaihyj(C_SyoukaiKanouHyj pHudousanmynosyoukaihyj) {
        hudousanmynosyoukaihyj = pHudousanmynosyoukaihyj;
    }

    private C_SyoukaiKanouHyj kohomynosyoukaihyj;

    @Type(type="UserType_C_SyoukaiKanouHyj")
    @Column(name=GenAM_IdCard.KOHOMYNOSYOUKAIHYJ)
    public C_SyoukaiKanouHyj getKohomynosyoukaihyj() {
        return kohomynosyoukaihyj;
    }

    public void setKohomynosyoukaihyj(C_SyoukaiKanouHyj pKohomynosyoukaihyj) {
        kohomynosyoukaihyj = pKohomynosyoukaihyj;
    }

    private C_SyoukaiKanouHyj kihomynosyoukaihyj;

    @Type(type="UserType_C_SyoukaiKanouHyj")
    @Column(name=GenAM_IdCard.KIHOMYNOSYOUKAIHYJ)
    public C_SyoukaiKanouHyj getKihomynosyoukaihyj() {
        return kihomynosyoukaihyj;
    }

    public void setKihomynosyoukaihyj(C_SyoukaiKanouHyj pKihomynosyoukaihyj) {
        kihomynosyoukaihyj = pKihomynosyoukaihyj;
    }

    private String kikantantoukbn;

    @Column(name=GenAM_IdCard.KIKANTANTOUKBN)
    public String getKikantantoukbn() {
        return kikantantoukbn;
    }

    public void setKikantantoukbn(String pKikantantoukbn) {
        kikantantoukbn = pKikantantoukbn;
    }
}