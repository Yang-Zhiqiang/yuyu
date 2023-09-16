package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_SosikiRn;
import yuyu.def.db.id.PKZT_SosikiRn;
import yuyu.def.db.meta.GenQZT_SosikiRn;
import yuyu.def.db.meta.QZT_SosikiRn;

/**
 * 普保用組織ＰＲＴ用連動Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SosikiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SosikiRn}</td><td colspan="3">普保用組織ＰＲＴ用連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsosikicd zrnsosikicd}</td><td>（連携用）組織コード</td><td align="center">{@link PKZT_SosikiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikinmkbn zrnsosikinmkbn}</td><td>（連携用）組織名区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikinm20 zrnsosikinm20}</td><td>（連携用）組織名（２０文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjisosikinm20 zrnkanjisosikinm20}</td><td>（連携用）漢字組織名（２０文字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikihaisiy zrnsosikihaisiy}</td><td>（連携用）組織廃止年月年</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikihaisim zrnsosikihaisim}</td><td>（連携用）組織廃止年月月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikisinsetuy zrnsosikisinsetuy}</td><td>（連携用）組織新設年月年</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikisinsetum zrnsosikisinsetum}</td><td>（連携用）組織新設年月月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntougetukeisyousosikicd zrntougetukeisyousosikicd}</td><td>（連携用）当月継承組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntougetukeisyoueigyoubucd zrntougetukeisyoueigyoubucd}</td><td>（連携用）当月継承営業推進部コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzengetukeisyousosikicd zrnzengetukeisyousosikicd}</td><td>（連携用）前月継承組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzengetukeisyoueigyoubucd zrnzengetukeisyoueigyoubucd}</td><td>（連携用）前月継承営業推進部コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikikihontikucd zrnsosikikihontikucd}</td><td>（連携用）組織基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikikanjikaiadr30 zrnsosikikanjikaiadr30}</td><td>（連携用）組織漢字下位住所（３０文字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjibilunm15 zrnkanjibilunm15}</td><td>（連携用）漢字ビル名称（１５文字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikinyuukyokaisuu zrnsosikinyuukyokaisuu}</td><td>（連携用）組織入居階数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikidenwabangousigai zrnsosikidenwabangousigai}</td><td>（連携用）組織電話番号市外局番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikitdenwabangousinai zrnsosikitdenwabangousinai}</td><td>（連携用）組織電話番号市内局番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikidenwabangoubangou zrnsosikidenwabangoubangou}</td><td>（連携用）組織電話番号番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikifaxbangousigai zrnsosikifaxbangousigai}</td><td>（連携用）組織ＦＡＸ番号市外局番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikifaxbangousinai zrnsosikifaxbangousinai}</td><td>（連携用）組織ＦＡＸ番号市内局番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikifaxbangoubangou zrnsosikifaxbangoubangou}</td><td>（連携用）組織ＦＡＸ番号番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouryokukaisiy zrnkouryokukaisiy}</td><td>（連携用）効力開始年月年</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouryokukaisim zrnkouryokukaisim}</td><td>（連携用）効力開始年月月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouryokukaisid zrnkouryokukaisid}</td><td>（連携用）効力開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewsosikikihontikucd zrnnewsosikikihontikucd}</td><td>（連携用）(変更後)組織基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewkanjisosikikaiadr30 zrnnewkanjisosikikaiadr30}</td><td>（連携用）(変更後)漢字組織下位住所（３０文字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewkanjibilunm15 zrnnewkanjibilunm15}</td><td>（連携用）(変更後)漢字ビル名称（１５文字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewsosikinyuukyokaisuu zrnnewsosikinyuukyokaisuu}</td><td>（連携用）(変更後)組織入居階数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewsosikidenwasigai zrnnewsosikidenwasigai}</td><td>（連携用）(変更後)組織電話番号市外局番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewsosikidenwasinai zrnnewsosikidenwasinai}</td><td>（連携用）(変更後)組織電話番号市内局番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewsosikidenwabangou zrnnewsosikidenwabangou}</td><td>（連携用）(変更後)組織電話番号番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewsosikifaxsigai zrnnewsosikifaxsigai}</td><td>（連携用）(変更後)組織ＦＡＸ番号市外局番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewsosikifaxsinai zrnnewsosikifaxsinai}</td><td>（連携用）(変更後)組織ＦＡＸ番号市内局番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewsosikifaxbangou zrnnewsosikifaxbangou}</td><td>（連携用）(変更後)組織ＦＡＸ番号番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SosikiRn
 * @see     PKZT_SosikiRn
 * @see     QZT_SosikiRn
 * @see     GenQZT_SosikiRn
 */
@MappedSuperclass
@Table(name=GenZT_SosikiRn.TABLE_NAME)
@IdClass(value=PKZT_SosikiRn.class)
public abstract class GenZT_SosikiRn extends AbstractExDBEntityForZDB<ZT_SosikiRn, PKZT_SosikiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SosikiRn";
    public static final String ZRNSOSIKICD              = "zrnsosikicd";
    public static final String ZRNSOSIKINMKBN           = "zrnsosikinmkbn";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNSOSIKINM20            = "zrnsosikinm20";
    public static final String ZRNKANJISOSIKINM20       = "zrnkanjisosikinm20";
    public static final String ZRNSOSIKIHAISIY          = "zrnsosikihaisiy";
    public static final String ZRNSOSIKIHAISIM          = "zrnsosikihaisim";
    public static final String ZRNSOSIKISINSETUY        = "zrnsosikisinsetuy";
    public static final String ZRNSOSIKISINSETUM        = "zrnsosikisinsetum";
    public static final String ZRNTOUGETUKEISYOUSOSIKICD = "zrntougetukeisyousosikicd";
    public static final String ZRNTOUGETUKEISYOUEIGYOUBUCD = "zrntougetukeisyoueigyoubucd";
    public static final String ZRNZENGETUKEISYOUSOSIKICD = "zrnzengetukeisyousosikicd";
    public static final String ZRNZENGETUKEISYOUEIGYOUBUCD = "zrnzengetukeisyoueigyoubucd";
    public static final String ZRNSOSIKIKIHONTIKUCD     = "zrnsosikikihontikucd";
    public static final String ZRNSOSIKIKANJIKAIADR30   = "zrnsosikikanjikaiadr30";
    public static final String ZRNKANJIBILUNM15         = "zrnkanjibilunm15";
    public static final String ZRNSOSIKINYUUKYOKAISUU   = "zrnsosikinyuukyokaisuu";
    public static final String ZRNSOSIKIDENWABANGOUSIGAI = "zrnsosikidenwabangousigai";
    public static final String ZRNSOSIKITDENWABANGOUSINAI = "zrnsosikitdenwabangousinai";
    public static final String ZRNSOSIKIDENWABANGOUBANGOU = "zrnsosikidenwabangoubangou";
    public static final String ZRNSOSIKIFAXBANGOUSIGAI  = "zrnsosikifaxbangousigai";
    public static final String ZRNSOSIKIFAXBANGOUSINAI  = "zrnsosikifaxbangousinai";
    public static final String ZRNSOSIKIFAXBANGOUBANGOU = "zrnsosikifaxbangoubangou";
    public static final String ZRNKOURYOKUKAISIY        = "zrnkouryokukaisiy";
    public static final String ZRNKOURYOKUKAISIM        = "zrnkouryokukaisim";
    public static final String ZRNKOURYOKUKAISID        = "zrnkouryokukaisid";
    public static final String ZRNNEWSOSIKIKIHONTIKUCD  = "zrnnewsosikikihontikucd";
    public static final String ZRNNEWKANJISOSIKIKAIADR30 = "zrnnewkanjisosikikaiadr30";
    public static final String ZRNNEWKANJIBILUNM15      = "zrnnewkanjibilunm15";
    public static final String ZRNNEWSOSIKINYUUKYOKAISUU = "zrnnewsosikinyuukyokaisuu";
    public static final String ZRNNEWSOSIKIDENWASIGAI   = "zrnnewsosikidenwasigai";
    public static final String ZRNNEWSOSIKIDENWASINAI   = "zrnnewsosikidenwasinai";
    public static final String ZRNNEWSOSIKIDENWABANGOU  = "zrnnewsosikidenwabangou";
    public static final String ZRNNEWSOSIKIFAXSIGAI     = "zrnnewsosikifaxsigai";
    public static final String ZRNNEWSOSIKIFAXSINAI     = "zrnnewsosikifaxsinai";
    public static final String ZRNNEWSOSIKIFAXBANGOU    = "zrnnewsosikifaxbangou";

    private final PKZT_SosikiRn primaryKey;

    public GenZT_SosikiRn() {
        primaryKey = new PKZT_SosikiRn();
    }

    public GenZT_SosikiRn(String pZrnsosikicd) {
        primaryKey = new PKZT_SosikiRn(pZrnsosikicd);
    }

    @Transient
    @Override
    public PKZT_SosikiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SosikiRn> getMetaClass() {
        return QZT_SosikiRn.class;
    }

    @Id
    @Column(name=GenZT_SosikiRn.ZRNSOSIKICD)
    public String getZrnsosikicd() {
        return getPrimaryKey().getZrnsosikicd();
    }

    public void setZrnsosikicd(String pZrnsosikicd) {
        getPrimaryKey().setZrnsosikicd(pZrnsosikicd);
    }

    private String zrnsosikinmkbn;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKINMKBN)
    public String getZrnsosikinmkbn() {
        return zrnsosikinmkbn;
    }

    public void setZrnsosikinmkbn(String pZrnsosikinmkbn) {
        zrnsosikinmkbn = pZrnsosikinmkbn;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_SosikiRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private String zrnsosikinm20;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKINM20)
    public String getZrnsosikinm20() {
        return zrnsosikinm20;
    }

    public void setZrnsosikinm20(String pZrnsosikinm20) {
        zrnsosikinm20 = pZrnsosikinm20;
    }

    private String zrnkanjisosikinm20;

    @Column(name=GenZT_SosikiRn.ZRNKANJISOSIKINM20)
    public String getZrnkanjisosikinm20() {
        return zrnkanjisosikinm20;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjisosikinm20(String pZrnkanjisosikinm20) {
        zrnkanjisosikinm20 = pZrnkanjisosikinm20;
    }

    private String zrnsosikihaisiy;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKIHAISIY)
    public String getZrnsosikihaisiy() {
        return zrnsosikihaisiy;
    }

    public void setZrnsosikihaisiy(String pZrnsosikihaisiy) {
        zrnsosikihaisiy = pZrnsosikihaisiy;
    }

    private String zrnsosikihaisim;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKIHAISIM)
    public String getZrnsosikihaisim() {
        return zrnsosikihaisim;
    }

    public void setZrnsosikihaisim(String pZrnsosikihaisim) {
        zrnsosikihaisim = pZrnsosikihaisim;
    }

    private String zrnsosikisinsetuy;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKISINSETUY)
    public String getZrnsosikisinsetuy() {
        return zrnsosikisinsetuy;
    }

    public void setZrnsosikisinsetuy(String pZrnsosikisinsetuy) {
        zrnsosikisinsetuy = pZrnsosikisinsetuy;
    }

    private String zrnsosikisinsetum;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKISINSETUM)
    public String getZrnsosikisinsetum() {
        return zrnsosikisinsetum;
    }

    public void setZrnsosikisinsetum(String pZrnsosikisinsetum) {
        zrnsosikisinsetum = pZrnsosikisinsetum;
    }

    private String zrntougetukeisyousosikicd;

    @Column(name=GenZT_SosikiRn.ZRNTOUGETUKEISYOUSOSIKICD)
    public String getZrntougetukeisyousosikicd() {
        return zrntougetukeisyousosikicd;
    }

    public void setZrntougetukeisyousosikicd(String pZrntougetukeisyousosikicd) {
        zrntougetukeisyousosikicd = pZrntougetukeisyousosikicd;
    }

    private String zrntougetukeisyoueigyoubucd;

    @Column(name=GenZT_SosikiRn.ZRNTOUGETUKEISYOUEIGYOUBUCD)
    public String getZrntougetukeisyoueigyoubucd() {
        return zrntougetukeisyoueigyoubucd;
    }

    public void setZrntougetukeisyoueigyoubucd(String pZrntougetukeisyoueigyoubucd) {
        zrntougetukeisyoueigyoubucd = pZrntougetukeisyoueigyoubucd;
    }

    private String zrnzengetukeisyousosikicd;

    @Column(name=GenZT_SosikiRn.ZRNZENGETUKEISYOUSOSIKICD)
    public String getZrnzengetukeisyousosikicd() {
        return zrnzengetukeisyousosikicd;
    }

    public void setZrnzengetukeisyousosikicd(String pZrnzengetukeisyousosikicd) {
        zrnzengetukeisyousosikicd = pZrnzengetukeisyousosikicd;
    }

    private String zrnzengetukeisyoueigyoubucd;

    @Column(name=GenZT_SosikiRn.ZRNZENGETUKEISYOUEIGYOUBUCD)
    public String getZrnzengetukeisyoueigyoubucd() {
        return zrnzengetukeisyoueigyoubucd;
    }

    public void setZrnzengetukeisyoueigyoubucd(String pZrnzengetukeisyoueigyoubucd) {
        zrnzengetukeisyoueigyoubucd = pZrnzengetukeisyoueigyoubucd;
    }

    private String zrnsosikikihontikucd;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKIKIHONTIKUCD)
    public String getZrnsosikikihontikucd() {
        return zrnsosikikihontikucd;
    }

    public void setZrnsosikikihontikucd(String pZrnsosikikihontikucd) {
        zrnsosikikihontikucd = pZrnsosikikihontikucd;
    }

    private String zrnsosikikanjikaiadr30;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKIKANJIKAIADR30)
    public String getZrnsosikikanjikaiadr30() {
        return zrnsosikikanjikaiadr30;
    }

    @DataConvert("toMultiByte")
    public void setZrnsosikikanjikaiadr30(String pZrnsosikikanjikaiadr30) {
        zrnsosikikanjikaiadr30 = pZrnsosikikanjikaiadr30;
    }

    private String zrnkanjibilunm15;

    @Column(name=GenZT_SosikiRn.ZRNKANJIBILUNM15)
    public String getZrnkanjibilunm15() {
        return zrnkanjibilunm15;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjibilunm15(String pZrnkanjibilunm15) {
        zrnkanjibilunm15 = pZrnkanjibilunm15;
    }

    private String zrnsosikinyuukyokaisuu;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKINYUUKYOKAISUU)
    public String getZrnsosikinyuukyokaisuu() {
        return zrnsosikinyuukyokaisuu;
    }

    public void setZrnsosikinyuukyokaisuu(String pZrnsosikinyuukyokaisuu) {
        zrnsosikinyuukyokaisuu = pZrnsosikinyuukyokaisuu;
    }

    private String zrnsosikidenwabangousigai;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKIDENWABANGOUSIGAI)
    public String getZrnsosikidenwabangousigai() {
        return zrnsosikidenwabangousigai;
    }

    public void setZrnsosikidenwabangousigai(String pZrnsosikidenwabangousigai) {
        zrnsosikidenwabangousigai = pZrnsosikidenwabangousigai;
    }

    private String zrnsosikitdenwabangousinai;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKITDENWABANGOUSINAI)
    public String getZrnsosikitdenwabangousinai() {
        return zrnsosikitdenwabangousinai;
    }

    public void setZrnsosikitdenwabangousinai(String pZrnsosikitdenwabangousinai) {
        zrnsosikitdenwabangousinai = pZrnsosikitdenwabangousinai;
    }

    private String zrnsosikidenwabangoubangou;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKIDENWABANGOUBANGOU)
    public String getZrnsosikidenwabangoubangou() {
        return zrnsosikidenwabangoubangou;
    }

    public void setZrnsosikidenwabangoubangou(String pZrnsosikidenwabangoubangou) {
        zrnsosikidenwabangoubangou = pZrnsosikidenwabangoubangou;
    }

    private String zrnsosikifaxbangousigai;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKIFAXBANGOUSIGAI)
    public String getZrnsosikifaxbangousigai() {
        return zrnsosikifaxbangousigai;
    }

    public void setZrnsosikifaxbangousigai(String pZrnsosikifaxbangousigai) {
        zrnsosikifaxbangousigai = pZrnsosikifaxbangousigai;
    }

    private String zrnsosikifaxbangousinai;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKIFAXBANGOUSINAI)
    public String getZrnsosikifaxbangousinai() {
        return zrnsosikifaxbangousinai;
    }

    public void setZrnsosikifaxbangousinai(String pZrnsosikifaxbangousinai) {
        zrnsosikifaxbangousinai = pZrnsosikifaxbangousinai;
    }

    private String zrnsosikifaxbangoubangou;

    @Column(name=GenZT_SosikiRn.ZRNSOSIKIFAXBANGOUBANGOU)
    public String getZrnsosikifaxbangoubangou() {
        return zrnsosikifaxbangoubangou;
    }

    public void setZrnsosikifaxbangoubangou(String pZrnsosikifaxbangoubangou) {
        zrnsosikifaxbangoubangou = pZrnsosikifaxbangoubangou;
    }

    private String zrnkouryokukaisiy;

    @Column(name=GenZT_SosikiRn.ZRNKOURYOKUKAISIY)
    public String getZrnkouryokukaisiy() {
        return zrnkouryokukaisiy;
    }

    public void setZrnkouryokukaisiy(String pZrnkouryokukaisiy) {
        zrnkouryokukaisiy = pZrnkouryokukaisiy;
    }

    private String zrnkouryokukaisim;

    @Column(name=GenZT_SosikiRn.ZRNKOURYOKUKAISIM)
    public String getZrnkouryokukaisim() {
        return zrnkouryokukaisim;
    }

    public void setZrnkouryokukaisim(String pZrnkouryokukaisim) {
        zrnkouryokukaisim = pZrnkouryokukaisim;
    }

    private String zrnkouryokukaisid;

    @Column(name=GenZT_SosikiRn.ZRNKOURYOKUKAISID)
    public String getZrnkouryokukaisid() {
        return zrnkouryokukaisid;
    }

    public void setZrnkouryokukaisid(String pZrnkouryokukaisid) {
        zrnkouryokukaisid = pZrnkouryokukaisid;
    }

    private String zrnnewsosikikihontikucd;

    @Column(name=GenZT_SosikiRn.ZRNNEWSOSIKIKIHONTIKUCD)
    public String getZrnnewsosikikihontikucd() {
        return zrnnewsosikikihontikucd;
    }

    public void setZrnnewsosikikihontikucd(String pZrnnewsosikikihontikucd) {
        zrnnewsosikikihontikucd = pZrnnewsosikikihontikucd;
    }

    private String zrnnewkanjisosikikaiadr30;

    @Column(name=GenZT_SosikiRn.ZRNNEWKANJISOSIKIKAIADR30)
    public String getZrnnewkanjisosikikaiadr30() {
        return zrnnewkanjisosikikaiadr30;
    }

    @DataConvert("toMultiByte")
    public void setZrnnewkanjisosikikaiadr30(String pZrnnewkanjisosikikaiadr30) {
        zrnnewkanjisosikikaiadr30 = pZrnnewkanjisosikikaiadr30;
    }

    private String zrnnewkanjibilunm15;

    @Column(name=GenZT_SosikiRn.ZRNNEWKANJIBILUNM15)
    public String getZrnnewkanjibilunm15() {
        return zrnnewkanjibilunm15;
    }

    @DataConvert("toMultiByte")
    public void setZrnnewkanjibilunm15(String pZrnnewkanjibilunm15) {
        zrnnewkanjibilunm15 = pZrnnewkanjibilunm15;
    }

    private String zrnnewsosikinyuukyokaisuu;

    @Column(name=GenZT_SosikiRn.ZRNNEWSOSIKINYUUKYOKAISUU)
    public String getZrnnewsosikinyuukyokaisuu() {
        return zrnnewsosikinyuukyokaisuu;
    }

    public void setZrnnewsosikinyuukyokaisuu(String pZrnnewsosikinyuukyokaisuu) {
        zrnnewsosikinyuukyokaisuu = pZrnnewsosikinyuukyokaisuu;
    }

    private String zrnnewsosikidenwasigai;

    @Column(name=GenZT_SosikiRn.ZRNNEWSOSIKIDENWASIGAI)
    public String getZrnnewsosikidenwasigai() {
        return zrnnewsosikidenwasigai;
    }

    public void setZrnnewsosikidenwasigai(String pZrnnewsosikidenwasigai) {
        zrnnewsosikidenwasigai = pZrnnewsosikidenwasigai;
    }

    private String zrnnewsosikidenwasinai;

    @Column(name=GenZT_SosikiRn.ZRNNEWSOSIKIDENWASINAI)
    public String getZrnnewsosikidenwasinai() {
        return zrnnewsosikidenwasinai;
    }

    public void setZrnnewsosikidenwasinai(String pZrnnewsosikidenwasinai) {
        zrnnewsosikidenwasinai = pZrnnewsosikidenwasinai;
    }

    private String zrnnewsosikidenwabangou;

    @Column(name=GenZT_SosikiRn.ZRNNEWSOSIKIDENWABANGOU)
    public String getZrnnewsosikidenwabangou() {
        return zrnnewsosikidenwabangou;
    }

    public void setZrnnewsosikidenwabangou(String pZrnnewsosikidenwabangou) {
        zrnnewsosikidenwabangou = pZrnnewsosikidenwabangou;
    }

    private String zrnnewsosikifaxsigai;

    @Column(name=GenZT_SosikiRn.ZRNNEWSOSIKIFAXSIGAI)
    public String getZrnnewsosikifaxsigai() {
        return zrnnewsosikifaxsigai;
    }

    public void setZrnnewsosikifaxsigai(String pZrnnewsosikifaxsigai) {
        zrnnewsosikifaxsigai = pZrnnewsosikifaxsigai;
    }

    private String zrnnewsosikifaxsinai;

    @Column(name=GenZT_SosikiRn.ZRNNEWSOSIKIFAXSINAI)
    public String getZrnnewsosikifaxsinai() {
        return zrnnewsosikifaxsinai;
    }

    public void setZrnnewsosikifaxsinai(String pZrnnewsosikifaxsinai) {
        zrnnewsosikifaxsinai = pZrnnewsosikifaxsinai;
    }

    private String zrnnewsosikifaxbangou;

    @Column(name=GenZT_SosikiRn.ZRNNEWSOSIKIFAXBANGOU)
    public String getZrnnewsosikifaxbangou() {
        return zrnnewsosikifaxbangou;
    }

    public void setZrnnewsosikifaxbangou(String pZrnnewsosikifaxbangou) {
        zrnnewsosikifaxbangou = pZrnnewsosikifaxbangou;
    }
}