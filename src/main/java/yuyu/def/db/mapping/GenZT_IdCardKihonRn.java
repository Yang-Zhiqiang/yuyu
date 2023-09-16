package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_IdCardKihonRn;
import yuyu.def.db.id.PKZT_IdCardKihonRn;
import yuyu.def.db.meta.GenQZT_IdCardKihonRn;
import yuyu.def.db.meta.QZT_IdCardKihonRn;

/**
 * ＩＤカードＦ基本テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_IdCardKihonRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IdCardKihonRn}</td><td colspan="3">ＩＤカードＦ基本テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnidkbn zrnidkbn}</td><td>（連携用）ＩＤ区分</td><td align="center">{@link PKZT_IdCardKihonRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidcd zrnidcd}</td><td>（連携用）ＩＤコード</td><td align="center">{@link PKZT_IdCardKihonRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10 zrnyobiv10}</td><td>（連携用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntanmatusiyoukbn zrntanmatusiyoukbn}</td><td>（連携用）端末使用区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaccesskbn zrnaccesskbn}</td><td>（連携用）アクセス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidnyuuryokusyanm zrnidnyuuryokusyanm}</td><td>（連携用）ＩＤ入力者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjiidnyuuryokusyanm zrnkanjiidnyuuryokusyanm}</td><td>（連携用）漢字ＩＤ入力者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidnyuuryokusyaseiymd zrnidnyuuryokusyaseiymd}</td><td>（連携用）ＩＤ入力者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidnyuuryokusyanyuusyaymd zrnidnyuuryokusyanyuusyaymd}</td><td>（連携用）ＩＤ入力者入社年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyozokusosikicd zrnsyozokusosikicd}</td><td>（連携用）所属組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyozokusisyacd zrnsyozokusisyacd}</td><td>（連携用）所属支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyozokusibucd zrnsyozokusibucd}</td><td>（連携用）所属支部コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidnyuuryokusyasikakucd zrnidnyuuryokusyasikakucd}</td><td>（連携用）ＩＤ入力者資格コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2 zrnyobiv2}</td><td>（連携用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidsdpsouhuhyouji zrnidsdpsouhuhyouji}</td><td>（連携用）ＩＤＳＤＰ送付表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x2 zrnyobiv1x2}</td><td>（連携用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x3 zrnyobiv1x3}</td><td>（連携用）予備項目Ｖ１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x2 zrnyobiv2x2}</td><td>（連携用）予備項目Ｖ２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x3 zrnyobiv2x3}</td><td>（連携用）予備項目Ｖ２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv26 zrnyobiv26}</td><td>（連携用）予備項目Ｖ２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x2 zrnyobiv8x2}</td><td>（連携用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidcardsaisyuukousinymd zrnidcardsaisyuukousinymd}</td><td>（連携用）ＩＤカード最終更新年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidcardmukouymd zrnidcardmukouymd}</td><td>（連携用）ＩＤカード無効年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaikeitantousyakbn zrnkaikeitantousyakbn}</td><td>（連携用）会計担当者区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyanaiyokintantousyakbn zrnsyanaiyokintantousyakbn}</td><td>（連携用）社内預金担当者区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjinjimynosyoukaihyj zrnjinjimynosyoukaihyj}</td><td>（連携用）人事・マイナンバー照会可能表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrneisyokumynosyoukaihyj zrneisyokumynosyoukaihyj}</td><td>（連携用）営職・マイナンバー照会可能表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhudousanmynosyoukaihyj zrnhudousanmynosyoukaihyj}</td><td>（連携用）不動産・マイナンバー照会可能表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkohomynosyoukaihyj zrnkohomynosyoukaihyj}</td><td>（連携用）個保・マイナンバー照会可能表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihomynosyoukaihyj zrnkihomynosyoukaihyj}</td><td>（連携用）企保・マイナンバー照会可能表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkikantantoukbn zrnkikantantoukbn}</td><td>（連携用）機関担当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv32 zrnyobiv32}</td><td>（連携用）予備項目Ｖ３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_IdCardKihonRn
 * @see     PKZT_IdCardKihonRn
 * @see     QZT_IdCardKihonRn
 * @see     GenQZT_IdCardKihonRn
 */
@MappedSuperclass
@Table(name=GenZT_IdCardKihonRn.TABLE_NAME)
@IdClass(value=PKZT_IdCardKihonRn.class)
public abstract class GenZT_IdCardKihonRn extends AbstractExDBEntityForZDB<ZT_IdCardKihonRn, PKZT_IdCardKihonRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_IdCardKihonRn";
    public static final String ZRNIDKBN                 = "zrnidkbn";
    public static final String ZRNIDCD                  = "zrnidcd";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNYOBIV10               = "zrnyobiv10";
    public static final String ZRNTANMATUSIYOUKBN       = "zrntanmatusiyoukbn";
    public static final String ZRNACCESSKBN             = "zrnaccesskbn";
    public static final String ZRNIDNYUURYOKUSYANM      = "zrnidnyuuryokusyanm";
    public static final String ZRNKANJIIDNYUURYOKUSYANM = "zrnkanjiidnyuuryokusyanm";
    public static final String ZRNIDNYUURYOKUSYASEIYMD  = "zrnidnyuuryokusyaseiymd";
    public static final String ZRNIDNYUURYOKUSYANYUUSYAYMD = "zrnidnyuuryokusyanyuusyaymd";
    public static final String ZRNSYOZOKUSOSIKICD       = "zrnsyozokusosikicd";
    public static final String ZRNSYOZOKUSISYACD        = "zrnsyozokusisyacd";
    public static final String ZRNSYOZOKUSIBUCD         = "zrnsyozokusibucd";
    public static final String ZRNIDNYUURYOKUSYASIKAKUCD = "zrnidnyuuryokusyasikakucd";
    public static final String ZRNYOBIV2                = "zrnyobiv2";
    public static final String ZRNIDSDPSOUHUHYOUJI      = "zrnidsdpsouhuhyouji";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNYOBIV1X2              = "zrnyobiv1x2";
    public static final String ZRNYOBIV1X3              = "zrnyobiv1x3";
    public static final String ZRNYOBIV2X2              = "zrnyobiv2x2";
    public static final String ZRNYOBIV2X3              = "zrnyobiv2x3";
    public static final String ZRNYOBIV26               = "zrnyobiv26";
    public static final String ZRNYOBIV8X2              = "zrnyobiv8x2";
    public static final String ZRNIDCARDSAISYUUKOUSINYMD = "zrnidcardsaisyuukousinymd";
    public static final String ZRNIDCARDMUKOUYMD        = "zrnidcardmukouymd";
    public static final String ZRNKAIKEITANTOUSYAKBN    = "zrnkaikeitantousyakbn";
    public static final String ZRNSYANAIYOKINTANTOUSYAKBN = "zrnsyanaiyokintantousyakbn";
    public static final String ZRNJINJIMYNOSYOUKAIHYJ   = "zrnjinjimynosyoukaihyj";
    public static final String ZRNEISYOKUMYNOSYOUKAIHYJ = "zrneisyokumynosyoukaihyj";
    public static final String ZRNHUDOUSANMYNOSYOUKAIHYJ = "zrnhudousanmynosyoukaihyj";
    public static final String ZRNKOHOMYNOSYOUKAIHYJ    = "zrnkohomynosyoukaihyj";
    public static final String ZRNKIHOMYNOSYOUKAIHYJ    = "zrnkihomynosyoukaihyj";
    public static final String ZRNKIKANTANTOUKBN        = "zrnkikantantoukbn";
    public static final String ZRNYOBIV32               = "zrnyobiv32";

    private final PKZT_IdCardKihonRn primaryKey;

    public GenZT_IdCardKihonRn() {
        primaryKey = new PKZT_IdCardKihonRn();
    }

    public GenZT_IdCardKihonRn(String pZrnidkbn, String pZrnidcd) {
        primaryKey = new PKZT_IdCardKihonRn(pZrnidkbn, pZrnidcd);
    }

    @Transient
    @Override
    public PKZT_IdCardKihonRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_IdCardKihonRn> getMetaClass() {
        return QZT_IdCardKihonRn.class;
    }

    @Id
    @Column(name=GenZT_IdCardKihonRn.ZRNIDKBN)
    public String getZrnidkbn() {
        return getPrimaryKey().getZrnidkbn();
    }

    public void setZrnidkbn(String pZrnidkbn) {
        getPrimaryKey().setZrnidkbn(pZrnidkbn);
    }

    @Id
    @Column(name=GenZT_IdCardKihonRn.ZRNIDCD)
    public String getZrnidcd() {
        return getPrimaryKey().getZrnidcd();
    }

    public void setZrnidcd(String pZrnidcd) {
        getPrimaryKey().setZrnidcd(pZrnidcd);
    }

    private String zrnyobiv8;

    @Column(name=GenZT_IdCardKihonRn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    private String zrnyobiv10;

    @Column(name=GenZT_IdCardKihonRn.ZRNYOBIV10)
    public String getZrnyobiv10() {
        return zrnyobiv10;
    }

    public void setZrnyobiv10(String pZrnyobiv10) {
        zrnyobiv10 = pZrnyobiv10;
    }

    private String zrntanmatusiyoukbn;

    @Column(name=GenZT_IdCardKihonRn.ZRNTANMATUSIYOUKBN)
    public String getZrntanmatusiyoukbn() {
        return zrntanmatusiyoukbn;
    }

    public void setZrntanmatusiyoukbn(String pZrntanmatusiyoukbn) {
        zrntanmatusiyoukbn = pZrntanmatusiyoukbn;
    }

    private String zrnaccesskbn;

    @Column(name=GenZT_IdCardKihonRn.ZRNACCESSKBN)
    public String getZrnaccesskbn() {
        return zrnaccesskbn;
    }

    public void setZrnaccesskbn(String pZrnaccesskbn) {
        zrnaccesskbn = pZrnaccesskbn;
    }

    private String zrnidnyuuryokusyanm;

    @Column(name=GenZT_IdCardKihonRn.ZRNIDNYUURYOKUSYANM)
    public String getZrnidnyuuryokusyanm() {
        return zrnidnyuuryokusyanm;
    }

    public void setZrnidnyuuryokusyanm(String pZrnidnyuuryokusyanm) {
        zrnidnyuuryokusyanm = pZrnidnyuuryokusyanm;
    }

    private String zrnkanjiidnyuuryokusyanm;

    @Column(name=GenZT_IdCardKihonRn.ZRNKANJIIDNYUURYOKUSYANM)
    public String getZrnkanjiidnyuuryokusyanm() {
        return zrnkanjiidnyuuryokusyanm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjiidnyuuryokusyanm(String pZrnkanjiidnyuuryokusyanm) {
        zrnkanjiidnyuuryokusyanm = pZrnkanjiidnyuuryokusyanm;
    }

    private String zrnidnyuuryokusyaseiymd;

    @Column(name=GenZT_IdCardKihonRn.ZRNIDNYUURYOKUSYASEIYMD)
    public String getZrnidnyuuryokusyaseiymd() {
        return zrnidnyuuryokusyaseiymd;
    }

    public void setZrnidnyuuryokusyaseiymd(String pZrnidnyuuryokusyaseiymd) {
        zrnidnyuuryokusyaseiymd = pZrnidnyuuryokusyaseiymd;
    }

    private String zrnidnyuuryokusyanyuusyaymd;

    @Column(name=GenZT_IdCardKihonRn.ZRNIDNYUURYOKUSYANYUUSYAYMD)
    public String getZrnidnyuuryokusyanyuusyaymd() {
        return zrnidnyuuryokusyanyuusyaymd;
    }

    public void setZrnidnyuuryokusyanyuusyaymd(String pZrnidnyuuryokusyanyuusyaymd) {
        zrnidnyuuryokusyanyuusyaymd = pZrnidnyuuryokusyanyuusyaymd;
    }

    private String zrnsyozokusosikicd;

    @Column(name=GenZT_IdCardKihonRn.ZRNSYOZOKUSOSIKICD)
    public String getZrnsyozokusosikicd() {
        return zrnsyozokusosikicd;
    }

    public void setZrnsyozokusosikicd(String pZrnsyozokusosikicd) {
        zrnsyozokusosikicd = pZrnsyozokusosikicd;
    }

    private String zrnsyozokusisyacd;

    @Column(name=GenZT_IdCardKihonRn.ZRNSYOZOKUSISYACD)
    public String getZrnsyozokusisyacd() {
        return zrnsyozokusisyacd;
    }

    public void setZrnsyozokusisyacd(String pZrnsyozokusisyacd) {
        zrnsyozokusisyacd = pZrnsyozokusisyacd;
    }

    private String zrnsyozokusibucd;

    @Column(name=GenZT_IdCardKihonRn.ZRNSYOZOKUSIBUCD)
    public String getZrnsyozokusibucd() {
        return zrnsyozokusibucd;
    }

    public void setZrnsyozokusibucd(String pZrnsyozokusibucd) {
        zrnsyozokusibucd = pZrnsyozokusibucd;
    }

    private String zrnidnyuuryokusyasikakucd;

    @Column(name=GenZT_IdCardKihonRn.ZRNIDNYUURYOKUSYASIKAKUCD)
    public String getZrnidnyuuryokusyasikakucd() {
        return zrnidnyuuryokusyasikakucd;
    }

    public void setZrnidnyuuryokusyasikakucd(String pZrnidnyuuryokusyasikakucd) {
        zrnidnyuuryokusyasikakucd = pZrnidnyuuryokusyasikakucd;
    }

    private String zrnyobiv2;

    @Column(name=GenZT_IdCardKihonRn.ZRNYOBIV2)
    public String getZrnyobiv2() {
        return zrnyobiv2;
    }

    public void setZrnyobiv2(String pZrnyobiv2) {
        zrnyobiv2 = pZrnyobiv2;
    }

    private String zrnidsdpsouhuhyouji;

    @Column(name=GenZT_IdCardKihonRn.ZRNIDSDPSOUHUHYOUJI)
    public String getZrnidsdpsouhuhyouji() {
        return zrnidsdpsouhuhyouji;
    }

    public void setZrnidsdpsouhuhyouji(String pZrnidsdpsouhuhyouji) {
        zrnidsdpsouhuhyouji = pZrnidsdpsouhuhyouji;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_IdCardKihonRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private String zrnyobiv1x2;

    @Column(name=GenZT_IdCardKihonRn.ZRNYOBIV1X2)
    public String getZrnyobiv1x2() {
        return zrnyobiv1x2;
    }

    public void setZrnyobiv1x2(String pZrnyobiv1x2) {
        zrnyobiv1x2 = pZrnyobiv1x2;
    }

    private String zrnyobiv1x3;

    @Column(name=GenZT_IdCardKihonRn.ZRNYOBIV1X3)
    public String getZrnyobiv1x3() {
        return zrnyobiv1x3;
    }

    public void setZrnyobiv1x3(String pZrnyobiv1x3) {
        zrnyobiv1x3 = pZrnyobiv1x3;
    }

    private String zrnyobiv2x2;

    @Column(name=GenZT_IdCardKihonRn.ZRNYOBIV2X2)
    public String getZrnyobiv2x2() {
        return zrnyobiv2x2;
    }

    public void setZrnyobiv2x2(String pZrnyobiv2x2) {
        zrnyobiv2x2 = pZrnyobiv2x2;
    }

    private String zrnyobiv2x3;

    @Column(name=GenZT_IdCardKihonRn.ZRNYOBIV2X3)
    public String getZrnyobiv2x3() {
        return zrnyobiv2x3;
    }

    public void setZrnyobiv2x3(String pZrnyobiv2x3) {
        zrnyobiv2x3 = pZrnyobiv2x3;
    }

    private String zrnyobiv26;

    @Column(name=GenZT_IdCardKihonRn.ZRNYOBIV26)
    public String getZrnyobiv26() {
        return zrnyobiv26;
    }

    public void setZrnyobiv26(String pZrnyobiv26) {
        zrnyobiv26 = pZrnyobiv26;
    }

    private String zrnyobiv8x2;

    @Column(name=GenZT_IdCardKihonRn.ZRNYOBIV8X2)
    public String getZrnyobiv8x2() {
        return zrnyobiv8x2;
    }

    public void setZrnyobiv8x2(String pZrnyobiv8x2) {
        zrnyobiv8x2 = pZrnyobiv8x2;
    }

    private String zrnidcardsaisyuukousinymd;

    @Column(name=GenZT_IdCardKihonRn.ZRNIDCARDSAISYUUKOUSINYMD)
    public String getZrnidcardsaisyuukousinymd() {
        return zrnidcardsaisyuukousinymd;
    }

    public void setZrnidcardsaisyuukousinymd(String pZrnidcardsaisyuukousinymd) {
        zrnidcardsaisyuukousinymd = pZrnidcardsaisyuukousinymd;
    }

    private String zrnidcardmukouymd;

    @Column(name=GenZT_IdCardKihonRn.ZRNIDCARDMUKOUYMD)
    public String getZrnidcardmukouymd() {
        return zrnidcardmukouymd;
    }

    public void setZrnidcardmukouymd(String pZrnidcardmukouymd) {
        zrnidcardmukouymd = pZrnidcardmukouymd;
    }

    private String zrnkaikeitantousyakbn;

    @Column(name=GenZT_IdCardKihonRn.ZRNKAIKEITANTOUSYAKBN)
    public String getZrnkaikeitantousyakbn() {
        return zrnkaikeitantousyakbn;
    }

    public void setZrnkaikeitantousyakbn(String pZrnkaikeitantousyakbn) {
        zrnkaikeitantousyakbn = pZrnkaikeitantousyakbn;
    }

    private String zrnsyanaiyokintantousyakbn;

    @Column(name=GenZT_IdCardKihonRn.ZRNSYANAIYOKINTANTOUSYAKBN)
    public String getZrnsyanaiyokintantousyakbn() {
        return zrnsyanaiyokintantousyakbn;
    }

    public void setZrnsyanaiyokintantousyakbn(String pZrnsyanaiyokintantousyakbn) {
        zrnsyanaiyokintantousyakbn = pZrnsyanaiyokintantousyakbn;
    }

    private String zrnjinjimynosyoukaihyj;

    @Column(name=GenZT_IdCardKihonRn.ZRNJINJIMYNOSYOUKAIHYJ)
    public String getZrnjinjimynosyoukaihyj() {
        return zrnjinjimynosyoukaihyj;
    }

    public void setZrnjinjimynosyoukaihyj(String pZrnjinjimynosyoukaihyj) {
        zrnjinjimynosyoukaihyj = pZrnjinjimynosyoukaihyj;
    }

    private String zrneisyokumynosyoukaihyj;

    @Column(name=GenZT_IdCardKihonRn.ZRNEISYOKUMYNOSYOUKAIHYJ)
    public String getZrneisyokumynosyoukaihyj() {
        return zrneisyokumynosyoukaihyj;
    }

    public void setZrneisyokumynosyoukaihyj(String pZrneisyokumynosyoukaihyj) {
        zrneisyokumynosyoukaihyj = pZrneisyokumynosyoukaihyj;
    }

    private String zrnhudousanmynosyoukaihyj;

    @Column(name=GenZT_IdCardKihonRn.ZRNHUDOUSANMYNOSYOUKAIHYJ)
    public String getZrnhudousanmynosyoukaihyj() {
        return zrnhudousanmynosyoukaihyj;
    }

    public void setZrnhudousanmynosyoukaihyj(String pZrnhudousanmynosyoukaihyj) {
        zrnhudousanmynosyoukaihyj = pZrnhudousanmynosyoukaihyj;
    }

    private String zrnkohomynosyoukaihyj;

    @Column(name=GenZT_IdCardKihonRn.ZRNKOHOMYNOSYOUKAIHYJ)
    public String getZrnkohomynosyoukaihyj() {
        return zrnkohomynosyoukaihyj;
    }

    public void setZrnkohomynosyoukaihyj(String pZrnkohomynosyoukaihyj) {
        zrnkohomynosyoukaihyj = pZrnkohomynosyoukaihyj;
    }

    private String zrnkihomynosyoukaihyj;

    @Column(name=GenZT_IdCardKihonRn.ZRNKIHOMYNOSYOUKAIHYJ)
    public String getZrnkihomynosyoukaihyj() {
        return zrnkihomynosyoukaihyj;
    }

    public void setZrnkihomynosyoukaihyj(String pZrnkihomynosyoukaihyj) {
        zrnkihomynosyoukaihyj = pZrnkihomynosyoukaihyj;
    }

    private String zrnkikantantoukbn;

    @Column(name=GenZT_IdCardKihonRn.ZRNKIKANTANTOUKBN)
    public String getZrnkikantantoukbn() {
        return zrnkikantantoukbn;
    }

    public void setZrnkikantantoukbn(String pZrnkikantantoukbn) {
        zrnkikantantoukbn = pZrnkikantantoukbn;
    }

    private String zrnyobiv32;

    @Column(name=GenZT_IdCardKihonRn.ZRNYOBIV32)
    public String getZrnyobiv32() {
        return zrnyobiv32;
    }

    public void setZrnyobiv32(String pZrnyobiv32) {
        zrnyobiv32 = pZrnyobiv32;
    }
}