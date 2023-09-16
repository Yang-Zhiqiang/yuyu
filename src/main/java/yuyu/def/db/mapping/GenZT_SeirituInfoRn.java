package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SeirituInfoRn;
import yuyu.def.db.id.PKZT_SeirituInfoRn;
import yuyu.def.db.meta.GenQZT_SeirituInfoRn;
import yuyu.def.db.meta.QZT_SeirituInfoRn;

/**
 * 成立情報Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SeirituInfoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeirituInfoRn}</td><td colspan="3">成立情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkijyunym zrnkijyunym}</td><td>（連携用）基準年月</td><td align="center">{@link PKZT_SeirituInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisekiym zrnseisekiym}</td><td>（連携用）成績計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SeirituInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhanbainm zrnhanbainm}</td><td>（連携用）販売名称</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatkisisya zrnatkisisya}</td><td>（連携用）扱支社</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsdpdkbn zrnsdpdkbn}</td><td>（連携用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinkykryouritukbn zrnsinkykryouritukbn}</td><td>（連携用）新契約用料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduketorihouhoukbn zrnduketorihouhoukbn}</td><td>（連携用）Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihons9 zrnkihons9}</td><td>（連携用）基本Ｓ（９桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhsys zrnhsys}</td><td>（連携用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkbriknsnhrkp zrntkbriknsnhrkp}</td><td>（連携用）月払換算払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseikbn zrnkyksyaseikbn}</td><td>（連携用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2keta zrnhhknnen2keta}</td><td>（連携用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyanen zrnkyksyanen}</td><td>（連携用）契約者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyakikykarihyj zrnkyksyakikykarihyj}</td><td>（連携用）契約者既契約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipnyuukinhouhoukbn zrnsyokaipnyuukinhouhoukbn}</td><td>（連携用）初回Ｐ入金方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeiyousinsakbn zrntoukeiyousinsakbn}</td><td>（連携用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsynensyuukbn zrnhhknsynensyuukbn}</td><td>（連携用）被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakup zrnsyukeiyakup}</td><td>（連携用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdairiseikyuutkykarihyj zrnstdairiseikyuutkykarihyj}</td><td>（連携用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmannenreihyj zrnmannenreihyj}</td><td>（連携用）満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikbn1 zrnnksyuruikbn1}</td><td>（連携用）年金種類区分（１文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnstkarihyj zrnnstkarihyj}</td><td>（連携用）年金支払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatkioybsydrtencd zrnaatkioybsydrtencd}</td><td>（連携用）Ａ扱者親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatkioybsydrtencd zrnbatkioybsydrtencd}</td><td>（連携用）Ｂ扱者親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinkeiyakujiyoteiriritu zrnsinkeiyakujiyoteiriritu}</td><td>（連携用）新契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsiteituukakihons zrnsiteituukakihons}</td><td>（連携用）指定通貨建基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnhrktuukakbn zrnhrktuukakbn}</td><td>（連携用）払込通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteituukakbn zrnsiteituukakbn}</td><td>（連携用）指定通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrktuukatukiknznhrkp zrnhrktuukatukiknznhrkp}</td><td>（連携用）払込通貨建月換算払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsiteituukatukiknznhrkp zrnsiteituukatukiknznhrkp}</td><td>（連携用）指定通貨建月換算払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyennyknrate zrnyennyknrate}</td><td>（連携用）円入金レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrngaikanyknrate zrngaikanyknrate}</td><td>（連携用）外貨入金レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnjyudkaigomehrtkarihyj zrnjyudkaigomehrtkarihyj}</td><td>（連携用）重度介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyksbyensitihsyutkykrate zrnsyksbyensitihsyutkykrate}</td><td>（連携用）初期死亡時円換算最低保証特約用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsjkkktyouseiriritu zrnsjkkktyouseiriritu}</td><td>（連携用）市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntargettkmkht zrntargettkmkht}</td><td>（連携用）ターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnteirituhaibunwari zrnteirituhaibunwari}</td><td>（連携用）定率部分配分割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzenkizennouhyouji zrnzenkizennouhyouji}</td><td>（連携用）全期前納表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwaribikikbn zrnpwaribikikbn}</td><td>（連携用）Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwaribikihanteigk zrnpwaribikihanteigk}</td><td>（連携用）Ｐ割引判定金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrtkykarihyj zrnkykdrtkykarihyj}</td><td>（連携用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktrkservicetrkninzuu zrnkzktrkservicetrkninzuu}</td><td>（連携用）ご家族登録サービス登録人数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikisiharaiarihyj zrnteikisiharaiarihyj}</td><td>（連携用）定期支払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeirituInfoRn
 * @see     PKZT_SeirituInfoRn
 * @see     QZT_SeirituInfoRn
 * @see     GenQZT_SeirituInfoRn
 */
@MappedSuperclass
@Table(name=GenZT_SeirituInfoRn.TABLE_NAME)
@IdClass(value=PKZT_SeirituInfoRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SeirituInfoRn extends AbstractExDBEntityForZDB<ZT_SeirituInfoRn, PKZT_SeirituInfoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SeirituInfoRn";
    public static final String ZRNKIJYUNYM              = "zrnkijyunym";
    public static final String ZRNSEISEKIYM             = "zrnseisekiym";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHANBAINM              = "zrnhanbainm";
    public static final String ZRNATKISISYA             = "zrnatkisisya";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSDPDKBN               = "zrnsdpdkbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNSINKYKRYOURITUKBN     = "zrnsinkykryouritukbn";
    public static final String ZRNDUKETORIHOUHOUKBN     = "zrnduketorihouhoukbn";
    public static final String ZRNKIHONS9               = "zrnkihons9";
    public static final String ZRNHSYS                  = "zrnhsys";
    public static final String ZRNTKBRIKNSNHRKP         = "zrntkbriknsnhrkp";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNKYKSYASEIKBN          = "zrnkyksyaseikbn";
    public static final String ZRNHHKNNEN2KETA          = "zrnhhknnen2keta";
    public static final String ZRNKYKSYANEN             = "zrnkyksyanen";
    public static final String ZRNSYKGYCD               = "zrnsykgycd";
    public static final String ZRNKYKSYAKIKYKARIHYJ     = "zrnkyksyakikykarihyj";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNSYOKAIPNYUUKINHOUHOUKBN = "zrnsyokaipnyuukinhouhoukbn";
    public static final String ZRNTOUKEIYOUSINSAKBN     = "zrntoukeiyousinsakbn";
    public static final String ZRNHHKNSYNENSYUUKBN      = "zrnhhknsynensyuukbn";
    public static final String ZRNSYUKEIYAKUP           = "zrnsyukeiyakup";
    public static final String ZRNBSUDIRTNATKIKEITAIKBN = "zrnbsudirtnatkikeitaikbn";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNSTDAIRISEIKYUUTKYKARIHYJ = "zrnstdairiseikyuutkykarihyj";
    public static final String ZRNMANNENREIHYJ          = "zrnmannenreihyj";
    public static final String ZRNNKSYURUIKBN1          = "zrnnksyuruikbn1";
    public static final String ZRNNSTKARIHYJ            = "zrnnstkarihyj";
    public static final String ZRNAATKIOYBSYDRTENCD     = "zrnaatkioybsydrtencd";
    public static final String ZRNBATKIOYBSYDRTENCD     = "zrnbatkioybsydrtencd";
    public static final String ZRNSINKEIYAKUJIYOTEIRIRITU = "zrnsinkeiyakujiyoteiriritu";
    public static final String ZRNSITEITUUKAKIHONS      = "zrnsiteituukakihons";
    public static final String ZRNHRKTUUKAKBN           = "zrnhrktuukakbn";
    public static final String ZRNSITEITUUKAKBN         = "zrnsiteituukakbn";
    public static final String ZRNHRKTUUKATUKIKNZNHRKP  = "zrnhrktuukatukiknznhrkp";
    public static final String ZRNSITEITUUKATUKIKNZNHRKP = "zrnsiteituukatukiknznhrkp";
    public static final String ZRNYENNYKNRATE           = "zrnyennyknrate";
    public static final String ZRNGAIKANYKNRATE         = "zrngaikanyknrate";
    public static final String ZRNJYUDKAIGOMEHRTKARIHYJ = "zrnjyudkaigomehrtkarihyj";
    public static final String ZRNSYKSBYENSITIHSYUTKYKRATE = "zrnsyksbyensitihsyutkykrate";
    public static final String ZRNSJKKKTYOUSEIRIRITU    = "zrnsjkkktyouseiriritu";
    public static final String ZRNTARGETTKMKHT          = "zrntargettkmkht";
    public static final String ZRNTEIRITUHAIBUNWARI     = "zrnteirituhaibunwari";
    public static final String ZRNZENKIZENNOUHYOUJI     = "zrnzenkizennouhyouji";
    public static final String ZRNPWARIBIKIKBN          = "zrnpwaribikikbn";
    public static final String ZRNPWARIBIKIHANTEIGK     = "zrnpwaribikihanteigk";
    public static final String ZRNDAI1HKNKKN            = "zrndai1hknkkn";
    public static final String ZRNKYKDRTKYKARIHYJ       = "zrnkykdrtkykarihyj";
    public static final String ZRNKZKTRKSERVICETRKNINZUU = "zrnkzktrkservicetrkninzuu";
    public static final String ZRNTEIKISIHARAIARIHYJ    = "zrnteikisiharaiarihyj";
    public static final String ZRNYOBIV6                = "zrnyobiv6";

    private final PKZT_SeirituInfoRn primaryKey;

    public GenZT_SeirituInfoRn() {
        primaryKey = new PKZT_SeirituInfoRn();
    }

    public GenZT_SeirituInfoRn(String pZrnkijyunym, String pZrnsyono) {
        primaryKey = new PKZT_SeirituInfoRn(pZrnkijyunym, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_SeirituInfoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SeirituInfoRn> getMetaClass() {
        return QZT_SeirituInfoRn.class;
    }

    @Id
    @Column(name=GenZT_SeirituInfoRn.ZRNKIJYUNYM)
    public String getZrnkijyunym() {
        return getPrimaryKey().getZrnkijyunym();
    }

    public void setZrnkijyunym(String pZrnkijyunym) {
        getPrimaryKey().setZrnkijyunym(pZrnkijyunym);
    }

    private String zrnseisekiym;

    @Column(name=GenZT_SeirituInfoRn.ZRNSEISEKIYM)
    public String getZrnseisekiym() {
        return zrnseisekiym;
    }

    public void setZrnseisekiym(String pZrnseisekiym) {
        zrnseisekiym = pZrnseisekiym;
    }

    @Id
    @Column(name=GenZT_SeirituInfoRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhanbainm;

    @Column(name=GenZT_SeirituInfoRn.ZRNHANBAINM)
    public String getZrnhanbainm() {
        return zrnhanbainm;
    }

    public void setZrnhanbainm(String pZrnhanbainm) {
        zrnhanbainm = pZrnhanbainm;
    }

    private String zrnatkisisya;

    @Column(name=GenZT_SeirituInfoRn.ZRNATKISISYA)
    public String getZrnatkisisya() {
        return zrnatkisisya;
    }

    public void setZrnatkisisya(String pZrnatkisisya) {
        zrnatkisisya = pZrnatkisisya;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_SeirituInfoRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_SeirituInfoRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsdpdkbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNSDPDKBN)
    public String getZrnsdpdkbn() {
        return zrnsdpdkbn;
    }

    public void setZrnsdpdkbn(String pZrnsdpdkbn) {
        zrnsdpdkbn = pZrnsdpdkbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnsinkykryouritukbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNSINKYKRYOURITUKBN)
    public String getZrnsinkykryouritukbn() {
        return zrnsinkykryouritukbn;
    }

    public void setZrnsinkykryouritukbn(String pZrnsinkykryouritukbn) {
        zrnsinkykryouritukbn = pZrnsinkykryouritukbn;
    }

    private String zrnduketorihouhoukbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNDUKETORIHOUHOUKBN)
    public String getZrnduketorihouhoukbn() {
        return zrnduketorihouhoukbn;
    }

    public void setZrnduketorihouhoukbn(String pZrnduketorihouhoukbn) {
        zrnduketorihouhoukbn = pZrnduketorihouhoukbn;
    }

    private Long zrnkihons9;

    @Column(name=GenZT_SeirituInfoRn.ZRNKIHONS9)
    public Long getZrnkihons9() {
        return zrnkihons9;
    }

    public void setZrnkihons9(Long pZrnkihons9) {
        zrnkihons9 = pZrnkihons9;
    }

    private Long zrnhsys;

    @Column(name=GenZT_SeirituInfoRn.ZRNHSYS)
    public Long getZrnhsys() {
        return zrnhsys;
    }

    public void setZrnhsys(Long pZrnhsys) {
        zrnhsys = pZrnhsys;
    }

    private Long zrntkbriknsnhrkp;

    @Column(name=GenZT_SeirituInfoRn.ZRNTKBRIKNSNHRKP)
    public Long getZrntkbriknsnhrkp() {
        return zrntkbriknsnhrkp;
    }

    public void setZrntkbriknsnhrkp(Long pZrntkbriknsnhrkp) {
        zrntkbriknsnhrkp = pZrntkbriknsnhrkp;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnkyksyaseikbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNKYKSYASEIKBN)
    public String getZrnkyksyaseikbn() {
        return zrnkyksyaseikbn;
    }

    public void setZrnkyksyaseikbn(String pZrnkyksyaseikbn) {
        zrnkyksyaseikbn = pZrnkyksyaseikbn;
    }

    private String zrnhhknnen2keta;

    @Column(name=GenZT_SeirituInfoRn.ZRNHHKNNEN2KETA)
    public String getZrnhhknnen2keta() {
        return zrnhhknnen2keta;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2keta(String pZrnhhknnen2keta) {
        zrnhhknnen2keta = pZrnhhknnen2keta;
    }

    private String zrnkyksyanen;

    @Column(name=GenZT_SeirituInfoRn.ZRNKYKSYANEN)
    public String getZrnkyksyanen() {
        return zrnkyksyanen;
    }

    public void setZrnkyksyanen(String pZrnkyksyanen) {
        zrnkyksyanen = pZrnkyksyanen;
    }

    private String zrnsykgycd;

    @Column(name=GenZT_SeirituInfoRn.ZRNSYKGYCD)
    public String getZrnsykgycd() {
        return zrnsykgycd;
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        zrnsykgycd = pZrnsykgycd;
    }

    private String zrnkyksyakikykarihyj;

    @Column(name=GenZT_SeirituInfoRn.ZRNKYKSYAKIKYKARIHYJ)
    public String getZrnkyksyakikykarihyj() {
        return zrnkyksyakikykarihyj;
    }

    public void setZrnkyksyakikykarihyj(String pZrnkyksyakikykarihyj) {
        zrnkyksyakikykarihyj = pZrnkyksyakikykarihyj;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_SeirituInfoRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnsyokaipnyuukinhouhoukbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNSYOKAIPNYUUKINHOUHOUKBN)
    public String getZrnsyokaipnyuukinhouhoukbn() {
        return zrnsyokaipnyuukinhouhoukbn;
    }

    public void setZrnsyokaipnyuukinhouhoukbn(String pZrnsyokaipnyuukinhouhoukbn) {
        zrnsyokaipnyuukinhouhoukbn = pZrnsyokaipnyuukinhouhoukbn;
    }

    private String zrntoukeiyousinsakbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNTOUKEIYOUSINSAKBN)
    public String getZrntoukeiyousinsakbn() {
        return zrntoukeiyousinsakbn;
    }

    public void setZrntoukeiyousinsakbn(String pZrntoukeiyousinsakbn) {
        zrntoukeiyousinsakbn = pZrntoukeiyousinsakbn;
    }

    private String zrnhhknsynensyuukbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNHHKNSYNENSYUUKBN)
    public String getZrnhhknsynensyuukbn() {
        return zrnhhknsynensyuukbn;
    }

    public void setZrnhhknsynensyuukbn(String pZrnhhknsynensyuukbn) {
        zrnhhknsynensyuukbn = pZrnhhknsynensyuukbn;
    }

    private Long zrnsyukeiyakup;

    @Column(name=GenZT_SeirituInfoRn.ZRNSYUKEIYAKUP)
    public Long getZrnsyukeiyakup() {
        return zrnsyukeiyakup;
    }

    public void setZrnsyukeiyakup(Long pZrnsyukeiyakup) {
        zrnsyukeiyakup = pZrnsyukeiyakup;
    }

    private String zrnbsudirtnatkikeitaikbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNBSUDIRTNATKIKEITAIKBN)
    public String getZrnbsudirtnatkikeitaikbn() {
        return zrnbsudirtnatkikeitaikbn;
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
    }

    private String zrnkykymd;

    @Column(name=GenZT_SeirituInfoRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnstdairiseikyuutkykarihyj;

    @Column(name=GenZT_SeirituInfoRn.ZRNSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZrnstdairiseikyuutkykarihyj() {
        return zrnstdairiseikyuutkykarihyj;
    }

    public void setZrnstdairiseikyuutkykarihyj(String pZrnstdairiseikyuutkykarihyj) {
        zrnstdairiseikyuutkykarihyj = pZrnstdairiseikyuutkykarihyj;
    }

    private String zrnmannenreihyj;

    @Column(name=GenZT_SeirituInfoRn.ZRNMANNENREIHYJ)
    public String getZrnmannenreihyj() {
        return zrnmannenreihyj;
    }

    public void setZrnmannenreihyj(String pZrnmannenreihyj) {
        zrnmannenreihyj = pZrnmannenreihyj;
    }

    private String zrnnksyuruikbn1;

    @Column(name=GenZT_SeirituInfoRn.ZRNNKSYURUIKBN1)
    public String getZrnnksyuruikbn1() {
        return zrnnksyuruikbn1;
    }

    public void setZrnnksyuruikbn1(String pZrnnksyuruikbn1) {
        zrnnksyuruikbn1 = pZrnnksyuruikbn1;
    }

    private String zrnnstkarihyj;

    @Column(name=GenZT_SeirituInfoRn.ZRNNSTKARIHYJ)
    public String getZrnnstkarihyj() {
        return zrnnstkarihyj;
    }

    public void setZrnnstkarihyj(String pZrnnstkarihyj) {
        zrnnstkarihyj = pZrnnstkarihyj;
    }

    private String zrnaatkioybsydrtencd;

    @Column(name=GenZT_SeirituInfoRn.ZRNAATKIOYBSYDRTENCD)
    public String getZrnaatkioybsydrtencd() {
        return zrnaatkioybsydrtencd;
    }

    public void setZrnaatkioybsydrtencd(String pZrnaatkioybsydrtencd) {
        zrnaatkioybsydrtencd = pZrnaatkioybsydrtencd;
    }

    private String zrnbatkioybsydrtencd;

    @Column(name=GenZT_SeirituInfoRn.ZRNBATKIOYBSYDRTENCD)
    public String getZrnbatkioybsydrtencd() {
        return zrnbatkioybsydrtencd;
    }

    public void setZrnbatkioybsydrtencd(String pZrnbatkioybsydrtencd) {
        zrnbatkioybsydrtencd = pZrnbatkioybsydrtencd;
    }

    private BizNumber zrnsinkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoRn.ZRNSINKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnsinkeiyakujiyoteiriritu() {
        return zrnsinkeiyakujiyoteiriritu;
    }

    public void setZrnsinkeiyakujiyoteiriritu(BizNumber pZrnsinkeiyakujiyoteiriritu) {
        zrnsinkeiyakujiyoteiriritu = pZrnsinkeiyakujiyoteiriritu;
    }

    private BizNumber zrnsiteituukakihons;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoRn.ZRNSITEITUUKAKIHONS)
    public BizNumber getZrnsiteituukakihons() {
        return zrnsiteituukakihons;
    }

    public void setZrnsiteituukakihons(BizNumber pZrnsiteituukakihons) {
        zrnsiteituukakihons = pZrnsiteituukakihons;
    }

    private String zrnhrktuukakbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNHRKTUUKAKBN)
    public String getZrnhrktuukakbn() {
        return zrnhrktuukakbn;
    }

    public void setZrnhrktuukakbn(String pZrnhrktuukakbn) {
        zrnhrktuukakbn = pZrnhrktuukakbn;
    }

    private String zrnsiteituukakbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNSITEITUUKAKBN)
    public String getZrnsiteituukakbn() {
        return zrnsiteituukakbn;
    }

    public void setZrnsiteituukakbn(String pZrnsiteituukakbn) {
        zrnsiteituukakbn = pZrnsiteituukakbn;
    }

    private BizNumber zrnhrktuukatukiknznhrkp;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoRn.ZRNHRKTUUKATUKIKNZNHRKP)
    public BizNumber getZrnhrktuukatukiknznhrkp() {
        return zrnhrktuukatukiknznhrkp;
    }

    public void setZrnhrktuukatukiknznhrkp(BizNumber pZrnhrktuukatukiknznhrkp) {
        zrnhrktuukatukiknznhrkp = pZrnhrktuukatukiknznhrkp;
    }

    private BizNumber zrnsiteituukatukiknznhrkp;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoRn.ZRNSITEITUUKATUKIKNZNHRKP)
    public BizNumber getZrnsiteituukatukiknznhrkp() {
        return zrnsiteituukatukiknznhrkp;
    }

    public void setZrnsiteituukatukiknznhrkp(BizNumber pZrnsiteituukatukiknznhrkp) {
        zrnsiteituukatukiknznhrkp = pZrnsiteituukatukiknznhrkp;
    }

    private BizNumber zrnyennyknrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoRn.ZRNYENNYKNRATE)
    public BizNumber getZrnyennyknrate() {
        return zrnyennyknrate;
    }

    public void setZrnyennyknrate(BizNumber pZrnyennyknrate) {
        zrnyennyknrate = pZrnyennyknrate;
    }

    private BizNumber zrngaikanyknrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoRn.ZRNGAIKANYKNRATE)
    public BizNumber getZrngaikanyknrate() {
        return zrngaikanyknrate;
    }

    public void setZrngaikanyknrate(BizNumber pZrngaikanyknrate) {
        zrngaikanyknrate = pZrngaikanyknrate;
    }

    private String zrnjyudkaigomehrtkarihyj;

    @Column(name=GenZT_SeirituInfoRn.ZRNJYUDKAIGOMEHRTKARIHYJ)
    public String getZrnjyudkaigomehrtkarihyj() {
        return zrnjyudkaigomehrtkarihyj;
    }

    public void setZrnjyudkaigomehrtkarihyj(String pZrnjyudkaigomehrtkarihyj) {
        zrnjyudkaigomehrtkarihyj = pZrnjyudkaigomehrtkarihyj;
    }

    private BizNumber zrnsyksbyensitihsyutkykrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoRn.ZRNSYKSBYENSITIHSYUTKYKRATE)
    public BizNumber getZrnsyksbyensitihsyutkykrate() {
        return zrnsyksbyensitihsyutkykrate;
    }

    public void setZrnsyksbyensitihsyutkykrate(BizNumber pZrnsyksbyensitihsyutkykrate) {
        zrnsyksbyensitihsyutkykrate = pZrnsyksbyensitihsyutkykrate;
    }

    private BizNumber zrnsjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoRn.ZRNSJKKKTYOUSEIRIRITU)
    public BizNumber getZrnsjkkktyouseiriritu() {
        return zrnsjkkktyouseiriritu;
    }

    public void setZrnsjkkktyouseiriritu(BizNumber pZrnsjkkktyouseiriritu) {
        zrnsjkkktyouseiriritu = pZrnsjkkktyouseiriritu;
    }

    private Integer zrntargettkmkht;

    @Column(name=GenZT_SeirituInfoRn.ZRNTARGETTKMKHT)
    public Integer getZrntargettkmkht() {
        return zrntargettkmkht;
    }

    public void setZrntargettkmkht(Integer pZrntargettkmkht) {
        zrntargettkmkht = pZrntargettkmkht;
    }

    private String zrnteirituhaibunwari;

    @Column(name=GenZT_SeirituInfoRn.ZRNTEIRITUHAIBUNWARI)
    public String getZrnteirituhaibunwari() {
        return zrnteirituhaibunwari;
    }

    public void setZrnteirituhaibunwari(String pZrnteirituhaibunwari) {
        zrnteirituhaibunwari = pZrnteirituhaibunwari;
    }

    private String zrnzenkizennouhyouji;

    @Column(name=GenZT_SeirituInfoRn.ZRNZENKIZENNOUHYOUJI)
    public String getZrnzenkizennouhyouji() {
        return zrnzenkizennouhyouji;
    }

    public void setZrnzenkizennouhyouji(String pZrnzenkizennouhyouji) {
        zrnzenkizennouhyouji = pZrnzenkizennouhyouji;
    }

    private String zrnpwaribikikbn;

    @Column(name=GenZT_SeirituInfoRn.ZRNPWARIBIKIKBN)
    public String getZrnpwaribikikbn() {
        return zrnpwaribikikbn;
    }

    public void setZrnpwaribikikbn(String pZrnpwaribikikbn) {
        zrnpwaribikikbn = pZrnpwaribikikbn;
    }

    private BizNumber zrnpwaribikihanteigk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoRn.ZRNPWARIBIKIHANTEIGK)
    public BizNumber getZrnpwaribikihanteigk() {
        return zrnpwaribikihanteigk;
    }

    public void setZrnpwaribikihanteigk(BizNumber pZrnpwaribikihanteigk) {
        zrnpwaribikihanteigk = pZrnpwaribikihanteigk;
    }

    private String zrndai1hknkkn;

    @Column(name=GenZT_SeirituInfoRn.ZRNDAI1HKNKKN)
    public String getZrndai1hknkkn() {
        return zrndai1hknkkn;
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        zrndai1hknkkn = pZrndai1hknkkn;
    }

    private String zrnkykdrtkykarihyj;

    @Column(name=GenZT_SeirituInfoRn.ZRNKYKDRTKYKARIHYJ)
    public String getZrnkykdrtkykarihyj() {
        return zrnkykdrtkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykdrtkykarihyj(String pZrnkykdrtkykarihyj) {
        zrnkykdrtkykarihyj = pZrnkykdrtkykarihyj;
    }

    private String zrnkzktrkservicetrkninzuu;

    @Column(name=GenZT_SeirituInfoRn.ZRNKZKTRKSERVICETRKNINZUU)
    public String getZrnkzktrkservicetrkninzuu() {
        return zrnkzktrkservicetrkninzuu;
    }

    public void setZrnkzktrkservicetrkninzuu(String pZrnkzktrkservicetrkninzuu) {
        zrnkzktrkservicetrkninzuu = pZrnkzktrkservicetrkninzuu;
    }

    private String zrnteikisiharaiarihyj;

    @Column(name=GenZT_SeirituInfoRn.ZRNTEIKISIHARAIARIHYJ)
    public String getZrnteikisiharaiarihyj() {
        return zrnteikisiharaiarihyj;
    }

    public void setZrnteikisiharaiarihyj(String pZrnteikisiharaiarihyj) {
        zrnteikisiharaiarihyj = pZrnteikisiharaiarihyj;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_SeirituInfoRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }
}