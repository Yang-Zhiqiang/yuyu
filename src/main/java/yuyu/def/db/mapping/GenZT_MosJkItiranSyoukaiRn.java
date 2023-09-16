package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_MosJkItiranSyoukaiRn;
import yuyu.def.db.id.PKZT_MosJkItiranSyoukaiRn;
import yuyu.def.db.meta.GenQZT_MosJkItiranSyoukaiRn;
import yuyu.def.db.meta.QZT_MosJkItiranSyoukaiRn;

/**
 * 申込状況一覧照会用Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_MosJkItiranSyoukaiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_MosJkItiranSyoukaiRn}</td><td colspan="3">申込状況一覧照会用Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnmosym zrnmosym}</td><td>（連携用）申込月度</td><td align="center">{@link PKZT_MosJkItiranSyoukaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmoskbn zrnmoskbn}</td><td>（連携用）申込区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">{@link PKZT_MosJkItiranSyoukaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruinm zrnhknsyuruinm}</td><td>（連携用）保険種類名称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusymd zrnmusymd}</td><td>（連携用）申込年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosnyuuryokuymd zrnmosnyuuryokuymd}</td><td>（連携用）申込入力年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydatkikbn zrnkydatkikbn}</td><td>（連携用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">{@link PKZT_MosJkItiranSyoukaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtenkjnm zrnbsydrtenkjnm}</td><td>（連携用）募集代理店漢字名称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatukaikojincd zrnatukaikojincd}</td><td>（連携用）扱者個人コード</td><td align="center">{@link PKZT_MosJkItiranSyoukaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntansyukukjatukaisyanm zrntansyukukjatukaisyanm}</td><td>（連携用）短縮漢字扱者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyknm10 zrnkjkyknm10}</td><td>（連携用）漢字契約者名（１０文字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntansyukukjhhknnm zrntansyukukjhhknnm}</td><td>（連携用）短縮漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2keta zrnhhknnen2keta}</td><td>（連携用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyoumetukbn zrnmossyoumetukbn}</td><td>（連携用）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkurikosiriyuukbn zrnkurikosiriyuukbn}</td><td>（連携用）繰越理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketjkkbn zrnketjkkbn}</td><td>（連携用）決定状況区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiktjyoutaikbn zrndakuhiktjyoutaikbn}</td><td>（連携用）諾否決定状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosketkekkakbn zrnmosketkekkakbn}</td><td>（連携用）申込決定結果区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonhubi zrnkihonhubi}</td><td>（連携用）基本不備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkthhbhyouji zrnkthhbhyouji}</td><td>（連携用）決定保留不備表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrhhbhyouji zrnsrhhbhyouji}</td><td>（連携用）成立保留不備表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknzumihyouji zrnnyknzumihyouji}</td><td>（連携用）入金済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsazumihyouji zrnsinsazumihyouji}</td><td>（連携用）診査済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukatanikbn zrntuukatanikbn}</td><td>（連携用）通貨単位区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaihrkpmoji zrnsyokaihrkpmoji}</td><td>（連携用）初回払込Ｐ（文字列）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjykktkbn zrnhjykktkbn}</td><td>（連携用）報状告知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipryosyuymd zrnsyokaipryosyuymd}</td><td>（連携用）初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkokutiymd zrnkokutiymd}</td><td>（連携用）告知年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkariseirituymd zrnkariseirituymd}</td><td>（連携用）仮成立年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstpnyknnaiyoukbn zrnfstpnyknnaiyoukbn}</td><td>（連携用）初回Ｐ入金内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseiymd zrnsakuseiymd}</td><td>（連携用）作成日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnanniskcd zrnanniskcd}</td><td>（連携用）案内先コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosakuseiymd zrnsyosakuseiymd}</td><td>（連携用）証券作成年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtenkobetuinfo1 zrnbsydrtenkobetuinfo1}</td><td>（連携用）募集代理店個別情報１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtenkobetuinfo2 zrnbsydrtenkobetuinfo2}</td><td>（連携用）募集代理店個別情報２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtenkobetuinfo3 zrnbsydrtenkobetuinfo3}</td><td>（連携用）募集代理店個別情報３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtenkobetuinfo4 zrnbsydrtenkobetuinfo4}</td><td>（連携用）募集代理店個別情報４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtenkobetuinfo5 zrnbsydrtenkobetuinfo5}</td><td>（連携用）募集代理店個別情報５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbankkouincd zrnbankkouincd}</td><td>（連携用）銀行行員コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuutourokuno zrnbosyuutourokuno}</td><td>（連携用）募集人登録番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosjkkbn zrnmosjkkbn}</td><td>（連携用）申込状況区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinymd zrnkousinymd}</td><td>（連携用）更新年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsayoteiymd zrnsinsayoteiymd}</td><td>（連携用）診査予定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnkykhyj zrnhjnkykhyj}</td><td>（連携用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjhjnnm zrnkjhjnnm}</td><td>（連携用）漢字法人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv93 zrnyobiv93}</td><td>（連携用）予備項目Ｖ９３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_MosJkItiranSyoukaiRn
 * @see     PKZT_MosJkItiranSyoukaiRn
 * @see     QZT_MosJkItiranSyoukaiRn
 * @see     GenQZT_MosJkItiranSyoukaiRn
 */
@MappedSuperclass
@Table(name=GenZT_MosJkItiranSyoukaiRn.TABLE_NAME)
@IdClass(value=PKZT_MosJkItiranSyoukaiRn.class)
public abstract class GenZT_MosJkItiranSyoukaiRn extends AbstractExDBEntityForZDB<ZT_MosJkItiranSyoukaiRn, PKZT_MosJkItiranSyoukaiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_MosJkItiranSyoukaiRn";
    public static final String ZRNMOSYM                 = "zrnmosym";
    public static final String ZRNMOSKBN                = "zrnmoskbn";
    public static final String ZRNMOSNO                 = "zrnmosno";
    public static final String ZRNHKNSYURUINM           = "zrnhknsyuruinm";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNMUSYMD                = "zrnmusymd";
    public static final String ZRNMOSNYUURYOKUYMD       = "zrnmosnyuuryokuymd";
    public static final String ZRNKYDATKIKBN            = "zrnkydatkikbn";
    public static final String ZRNBSUDIRTNATKIKEITAIKBN = "zrnbsudirtnatkikeitaikbn";
    public static final String ZRNBSYDRTENCD            = "zrnbsydrtencd";
    public static final String ZRNBSYDRTENKJNM          = "zrnbsydrtenkjnm";
    public static final String ZRNATUKAIKOJINCD         = "zrnatukaikojincd";
    public static final String ZRNTANSYUKUKJATUKAISYANM = "zrntansyukukjatukaisyanm";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNKJKYKNM10             = "zrnkjkyknm10";
    public static final String ZRNTANSYUKUKJHHKNNM      = "zrntansyukukjhhknnm";
    public static final String ZRNHHKNNEN2KETA          = "zrnhhknnen2keta";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNMOSSYOUMETUKBN        = "zrnmossyoumetukbn";
    public static final String ZRNKURIKOSIRIYUUKBN      = "zrnkurikosiriyuukbn";
    public static final String ZRNKETJKKBN              = "zrnketjkkbn";
    public static final String ZRNDAKUHIKTJYOUTAIKBN    = "zrndakuhiktjyoutaikbn";
    public static final String ZRNMOSKETKEKKAKBN        = "zrnmosketkekkakbn";
    public static final String ZRNKIHONHUBI             = "zrnkihonhubi";
    public static final String ZRNKTHHBHYOUJI           = "zrnkthhbhyouji";
    public static final String ZRNSRHHBHYOUJI           = "zrnsrhhbhyouji";
    public static final String ZRNNYKNZUMIHYOUJI        = "zrnnyknzumihyouji";
    public static final String ZRNSINSAZUMIHYOUJI       = "zrnsinsazumihyouji";
    public static final String ZRNTUUKATANIKBN          = "zrntuukatanikbn";
    public static final String ZRNSYOKAIHRKPMOJI        = "zrnsyokaihrkpmoji";
    public static final String ZRNHJYKKTKBN             = "zrnhjykktkbn";
    public static final String ZRNSYOKAIPRYOSYUYMD      = "zrnsyokaipryosyuymd";
    public static final String ZRNKOKUTIYMD             = "zrnkokutiymd";
    public static final String ZRNKARISEIRITUYMD        = "zrnkariseirituymd";
    public static final String ZRNFSTPNYKNNAIYOUKBN     = "zrnfstpnyknnaiyoukbn";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNSAKUSEIYMD            = "zrnsakuseiymd";
    public static final String ZRNANNISKCD              = "zrnanniskcd";
    public static final String ZRNSYOSAKUSEIYMD         = "zrnsyosakuseiymd";
    public static final String ZRNBSYDRTENKOBETUINFO1   = "zrnbsydrtenkobetuinfo1";
    public static final String ZRNBSYDRTENKOBETUINFO2   = "zrnbsydrtenkobetuinfo2";
    public static final String ZRNBSYDRTENKOBETUINFO3   = "zrnbsydrtenkobetuinfo3";
    public static final String ZRNBSYDRTENKOBETUINFO4   = "zrnbsydrtenkobetuinfo4";
    public static final String ZRNBSYDRTENKOBETUINFO5   = "zrnbsydrtenkobetuinfo5";
    public static final String ZRNBANKKOUINCD           = "zrnbankkouincd";
    public static final String ZRNBOSYUUTOUROKUNO       = "zrnbosyuutourokuno";
    public static final String ZRNMOSJKKBN              = "zrnmosjkkbn";
    public static final String ZRNKOUSINYMD             = "zrnkousinymd";
    public static final String ZRNSINSAYOTEIYMD         = "zrnsinsayoteiymd";
    public static final String ZRNHJNKYKHYJ             = "zrnhjnkykhyj";
    public static final String ZRNKJHJNNM               = "zrnkjhjnnm";
    public static final String ZRNYOBIV93               = "zrnyobiv93";

    private final PKZT_MosJkItiranSyoukaiRn primaryKey;

    public GenZT_MosJkItiranSyoukaiRn() {
        primaryKey = new PKZT_MosJkItiranSyoukaiRn();
    }

    public GenZT_MosJkItiranSyoukaiRn(
        String pZrnmosym,
        String pZrnmosno,
        String pZrnbsydrtencd,
        String pZrnatukaikojincd
    ) {
        primaryKey = new PKZT_MosJkItiranSyoukaiRn(
            pZrnmosym,
            pZrnmosno,
            pZrnbsydrtencd,
            pZrnatukaikojincd
        );
    }

    @Transient
    @Override
    public PKZT_MosJkItiranSyoukaiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_MosJkItiranSyoukaiRn> getMetaClass() {
        return QZT_MosJkItiranSyoukaiRn.class;
    }

    @Id
    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNMOSYM)
    public String getZrnmosym() {
        return getPrimaryKey().getZrnmosym();
    }

    public void setZrnmosym(String pZrnmosym) {
        getPrimaryKey().setZrnmosym(pZrnmosym);
    }

    private String zrnmoskbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNMOSKBN)
    public String getZrnmoskbn() {
        return zrnmoskbn;
    }

    public void setZrnmoskbn(String pZrnmoskbn) {
        zrnmoskbn = pZrnmoskbn;
    }

    @Id
    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNMOSNO)
    public String getZrnmosno() {
        return getPrimaryKey().getZrnmosno();
    }

    public void setZrnmosno(String pZrnmosno) {
        getPrimaryKey().setZrnmosno(pZrnmosno);
    }

    private String zrnhknsyuruinm;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNHKNSYURUINM)
    public String getZrnhknsyuruinm() {
        return zrnhknsyuruinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnhknsyuruinm(String pZrnhknsyuruinm) {
        zrnhknsyuruinm = pZrnhknsyuruinm;
    }

    private String zrnkykymd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnmusymd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNMUSYMD)
    public String getZrnmusymd() {
        return zrnmusymd;
    }

    public void setZrnmusymd(String pZrnmusymd) {
        zrnmusymd = pZrnmusymd;
    }

    private String zrnmosnyuuryokuymd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNMOSNYUURYOKUYMD)
    public String getZrnmosnyuuryokuymd() {
        return zrnmosnyuuryokuymd;
    }

    public void setZrnmosnyuuryokuymd(String pZrnmosnyuuryokuymd) {
        zrnmosnyuuryokuymd = pZrnmosnyuuryokuymd;
    }

    private String zrnkydatkikbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNKYDATKIKBN)
    public String getZrnkydatkikbn() {
        return zrnkydatkikbn;
    }

    public void setZrnkydatkikbn(String pZrnkydatkikbn) {
        zrnkydatkikbn = pZrnkydatkikbn;
    }

    private String zrnbsudirtnatkikeitaikbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNBSUDIRTNATKIKEITAIKBN)
    public String getZrnbsudirtnatkikeitaikbn() {
        return zrnbsudirtnatkikeitaikbn;
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
    }

    @Id
    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNBSYDRTENCD)
    public String getZrnbsydrtencd() {
        return getPrimaryKey().getZrnbsydrtencd();
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        getPrimaryKey().setZrnbsydrtencd(pZrnbsydrtencd);
    }

    private String zrnbsydrtenkjnm;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNBSYDRTENKJNM)
    public String getZrnbsydrtenkjnm() {
        return zrnbsydrtenkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnbsydrtenkjnm(String pZrnbsydrtenkjnm) {
        zrnbsydrtenkjnm = pZrnbsydrtenkjnm;
    }

    @Id
    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNATUKAIKOJINCD)
    public String getZrnatukaikojincd() {
        return getPrimaryKey().getZrnatukaikojincd();
    }

    public void setZrnatukaikojincd(String pZrnatukaikojincd) {
        getPrimaryKey().setZrnatukaikojincd(pZrnatukaikojincd);
    }

    private String zrntansyukukjatukaisyanm;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNTANSYUKUKJATUKAISYANM)
    public String getZrntansyukukjatukaisyanm() {
        return zrntansyukukjatukaisyanm;
    }

    @DataConvert("toMultiByte")
    public void setZrntansyukukjatukaisyanm(String pZrntansyukukjatukaisyanm) {
        zrntansyukukjatukaisyanm = pZrntansyukukjatukaisyanm;
    }

    private String zrncifcd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    private String zrnkjkyknm10;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNKJKYKNM10)
    public String getZrnkjkyknm10() {
        return zrnkjkyknm10;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm10(String pZrnkjkyknm10) {
        zrnkjkyknm10 = pZrnkjkyknm10;
    }

    private String zrntansyukukjhhknnm;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNTANSYUKUKJHHKNNM)
    public String getZrntansyukukjhhknnm() {
        return zrntansyukukjhhknnm;
    }

    @DataConvert("toMultiByte")
    public void setZrntansyukukjhhknnm(String pZrntansyukukjhhknnm) {
        zrntansyukukjhhknnm = pZrntansyukukjhhknnm;
    }

    private String zrnhhknnen2keta;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNHHKNNEN2KETA)
    public String getZrnhhknnen2keta() {
        return zrnhhknnen2keta;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2keta(String pZrnhhknnen2keta) {
        zrnhhknnen2keta = pZrnhhknnen2keta;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnmossyoumetukbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNMOSSYOUMETUKBN)
    public String getZrnmossyoumetukbn() {
        return zrnmossyoumetukbn;
    }

    public void setZrnmossyoumetukbn(String pZrnmossyoumetukbn) {
        zrnmossyoumetukbn = pZrnmossyoumetukbn;
    }

    private String zrnkurikosiriyuukbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNKURIKOSIRIYUUKBN)
    public String getZrnkurikosiriyuukbn() {
        return zrnkurikosiriyuukbn;
    }

    public void setZrnkurikosiriyuukbn(String pZrnkurikosiriyuukbn) {
        zrnkurikosiriyuukbn = pZrnkurikosiriyuukbn;
    }

    private String zrnketjkkbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNKETJKKBN)
    public String getZrnketjkkbn() {
        return zrnketjkkbn;
    }

    public void setZrnketjkkbn(String pZrnketjkkbn) {
        zrnketjkkbn = pZrnketjkkbn;
    }

    private String zrndakuhiktjyoutaikbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNDAKUHIKTJYOUTAIKBN)
    public String getZrndakuhiktjyoutaikbn() {
        return zrndakuhiktjyoutaikbn;
    }

    public void setZrndakuhiktjyoutaikbn(String pZrndakuhiktjyoutaikbn) {
        zrndakuhiktjyoutaikbn = pZrndakuhiktjyoutaikbn;
    }

    private String zrnmosketkekkakbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNMOSKETKEKKAKBN)
    public String getZrnmosketkekkakbn() {
        return zrnmosketkekkakbn;
    }

    public void setZrnmosketkekkakbn(String pZrnmosketkekkakbn) {
        zrnmosketkekkakbn = pZrnmosketkekkakbn;
    }

    private String zrnkihonhubi;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNKIHONHUBI)
    public String getZrnkihonhubi() {
        return zrnkihonhubi;
    }

    public void setZrnkihonhubi(String pZrnkihonhubi) {
        zrnkihonhubi = pZrnkihonhubi;
    }

    private String zrnkthhbhyouji;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNKTHHBHYOUJI)
    public String getZrnkthhbhyouji() {
        return zrnkthhbhyouji;
    }

    public void setZrnkthhbhyouji(String pZrnkthhbhyouji) {
        zrnkthhbhyouji = pZrnkthhbhyouji;
    }

    private String zrnsrhhbhyouji;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNSRHHBHYOUJI)
    public String getZrnsrhhbhyouji() {
        return zrnsrhhbhyouji;
    }

    public void setZrnsrhhbhyouji(String pZrnsrhhbhyouji) {
        zrnsrhhbhyouji = pZrnsrhhbhyouji;
    }

    private String zrnnyknzumihyouji;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNNYKNZUMIHYOUJI)
    public String getZrnnyknzumihyouji() {
        return zrnnyknzumihyouji;
    }

    public void setZrnnyknzumihyouji(String pZrnnyknzumihyouji) {
        zrnnyknzumihyouji = pZrnnyknzumihyouji;
    }

    private String zrnsinsazumihyouji;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNSINSAZUMIHYOUJI)
    public String getZrnsinsazumihyouji() {
        return zrnsinsazumihyouji;
    }

    public void setZrnsinsazumihyouji(String pZrnsinsazumihyouji) {
        zrnsinsazumihyouji = pZrnsinsazumihyouji;
    }

    private String zrntuukatanikbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNTUUKATANIKBN)
    public String getZrntuukatanikbn() {
        return zrntuukatanikbn;
    }

    public void setZrntuukatanikbn(String pZrntuukatanikbn) {
        zrntuukatanikbn = pZrntuukatanikbn;
    }

    private String zrnsyokaihrkpmoji;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNSYOKAIHRKPMOJI)
    public String getZrnsyokaihrkpmoji() {
        return zrnsyokaihrkpmoji;
    }

    public void setZrnsyokaihrkpmoji(String pZrnsyokaihrkpmoji) {
        zrnsyokaihrkpmoji = pZrnsyokaihrkpmoji;
    }

    private String zrnhjykktkbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNHJYKKTKBN)
    public String getZrnhjykktkbn() {
        return zrnhjykktkbn;
    }

    public void setZrnhjykktkbn(String pZrnhjykktkbn) {
        zrnhjykktkbn = pZrnhjykktkbn;
    }

    private String zrnsyokaipryosyuymd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNSYOKAIPRYOSYUYMD)
    public String getZrnsyokaipryosyuymd() {
        return zrnsyokaipryosyuymd;
    }

    public void setZrnsyokaipryosyuymd(String pZrnsyokaipryosyuymd) {
        zrnsyokaipryosyuymd = pZrnsyokaipryosyuymd;
    }

    private String zrnkokutiymd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNKOKUTIYMD)
    public String getZrnkokutiymd() {
        return zrnkokutiymd;
    }

    public void setZrnkokutiymd(String pZrnkokutiymd) {
        zrnkokutiymd = pZrnkokutiymd;
    }

    private String zrnkariseirituymd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNKARISEIRITUYMD)
    public String getZrnkariseirituymd() {
        return zrnkariseirituymd;
    }

    public void setZrnkariseirituymd(String pZrnkariseirituymd) {
        zrnkariseirituymd = pZrnkariseirituymd;
    }

    private String zrnfstpnyknnaiyoukbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNFSTPNYKNNAIYOUKBN)
    public String getZrnfstpnyknnaiyoukbn() {
        return zrnfstpnyknnaiyoukbn;
    }

    public void setZrnfstpnyknnaiyoukbn(String pZrnfstpnyknnaiyoukbn) {
        zrnfstpnyknnaiyoukbn = pZrnfstpnyknnaiyoukbn;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnsakuseiymd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNSAKUSEIYMD)
    public String getZrnsakuseiymd() {
        return zrnsakuseiymd;
    }

    public void setZrnsakuseiymd(String pZrnsakuseiymd) {
        zrnsakuseiymd = pZrnsakuseiymd;
    }

    private String zrnanniskcd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNANNISKCD)
    public String getZrnanniskcd() {
        return zrnanniskcd;
    }

    public void setZrnanniskcd(String pZrnanniskcd) {
        zrnanniskcd = pZrnanniskcd;
    }

    private String zrnsyosakuseiymd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNSYOSAKUSEIYMD)
    public String getZrnsyosakuseiymd() {
        return zrnsyosakuseiymd;
    }

    public void setZrnsyosakuseiymd(String pZrnsyosakuseiymd) {
        zrnsyosakuseiymd = pZrnsyosakuseiymd;
    }

    private String zrnbsydrtenkobetuinfo1;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNBSYDRTENKOBETUINFO1)
    public String getZrnbsydrtenkobetuinfo1() {
        return zrnbsydrtenkobetuinfo1;
    }

    public void setZrnbsydrtenkobetuinfo1(String pZrnbsydrtenkobetuinfo1) {
        zrnbsydrtenkobetuinfo1 = pZrnbsydrtenkobetuinfo1;
    }

    private String zrnbsydrtenkobetuinfo2;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNBSYDRTENKOBETUINFO2)
    public String getZrnbsydrtenkobetuinfo2() {
        return zrnbsydrtenkobetuinfo2;
    }

    public void setZrnbsydrtenkobetuinfo2(String pZrnbsydrtenkobetuinfo2) {
        zrnbsydrtenkobetuinfo2 = pZrnbsydrtenkobetuinfo2;
    }

    private String zrnbsydrtenkobetuinfo3;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNBSYDRTENKOBETUINFO3)
    public String getZrnbsydrtenkobetuinfo3() {
        return zrnbsydrtenkobetuinfo3;
    }

    public void setZrnbsydrtenkobetuinfo3(String pZrnbsydrtenkobetuinfo3) {
        zrnbsydrtenkobetuinfo3 = pZrnbsydrtenkobetuinfo3;
    }

    private String zrnbsydrtenkobetuinfo4;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNBSYDRTENKOBETUINFO4)
    public String getZrnbsydrtenkobetuinfo4() {
        return zrnbsydrtenkobetuinfo4;
    }

    public void setZrnbsydrtenkobetuinfo4(String pZrnbsydrtenkobetuinfo4) {
        zrnbsydrtenkobetuinfo4 = pZrnbsydrtenkobetuinfo4;
    }

    private String zrnbsydrtenkobetuinfo5;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNBSYDRTENKOBETUINFO5)
    public String getZrnbsydrtenkobetuinfo5() {
        return zrnbsydrtenkobetuinfo5;
    }

    public void setZrnbsydrtenkobetuinfo5(String pZrnbsydrtenkobetuinfo5) {
        zrnbsydrtenkobetuinfo5 = pZrnbsydrtenkobetuinfo5;
    }

    private String zrnbankkouincd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNBANKKOUINCD)
    public String getZrnbankkouincd() {
        return zrnbankkouincd;
    }

    public void setZrnbankkouincd(String pZrnbankkouincd) {
        zrnbankkouincd = pZrnbankkouincd;
    }

    private String zrnbosyuutourokuno;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNBOSYUUTOUROKUNO)
    public String getZrnbosyuutourokuno() {
        return zrnbosyuutourokuno;
    }

    public void setZrnbosyuutourokuno(String pZrnbosyuutourokuno) {
        zrnbosyuutourokuno = pZrnbosyuutourokuno;
    }

    private String zrnmosjkkbn;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNMOSJKKBN)
    public String getZrnmosjkkbn() {
        return zrnmosjkkbn;
    }

    public void setZrnmosjkkbn(String pZrnmosjkkbn) {
        zrnmosjkkbn = pZrnmosjkkbn;
    }

    private String zrnkousinymd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNKOUSINYMD)
    public String getZrnkousinymd() {
        return zrnkousinymd;
    }

    public void setZrnkousinymd(String pZrnkousinymd) {
        zrnkousinymd = pZrnkousinymd;
    }

    private String zrnsinsayoteiymd;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNSINSAYOTEIYMD)
    public String getZrnsinsayoteiymd() {
        return zrnsinsayoteiymd;
    }

    public void setZrnsinsayoteiymd(String pZrnsinsayoteiymd) {
        zrnsinsayoteiymd = pZrnsinsayoteiymd;
    }

    private String zrnhjnkykhyj;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNHJNKYKHYJ)
    public String getZrnhjnkykhyj() {
        return zrnhjnkykhyj;
    }

    public void setZrnhjnkykhyj(String pZrnhjnkykhyj) {
        zrnhjnkykhyj = pZrnhjnkykhyj;
    }

    private String zrnkjhjnnm;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNKJHJNNM)
    public String getZrnkjhjnnm() {
        return zrnkjhjnnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjhjnnm(String pZrnkjhjnnm) {
        zrnkjhjnnm = pZrnkjhjnnm;
    }

    private String zrnyobiv93;

    @Column(name=GenZT_MosJkItiranSyoukaiRn.ZRNYOBIV93)
    public String getZrnyobiv93() {
        return zrnyobiv93;
    }

    public void setZrnyobiv93(String pZrnyobiv93) {
        zrnyobiv93 = pZrnyobiv93;
    }
}