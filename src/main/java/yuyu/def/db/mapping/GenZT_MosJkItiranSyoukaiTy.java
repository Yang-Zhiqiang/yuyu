package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.id.PKZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.meta.GenQZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.meta.QZT_MosJkItiranSyoukaiTy;

/**
 * 申込状況一覧照会用Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_MosJkItiranSyoukaiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_MosJkItiranSyoukaiTy}</td><td colspan="3">申込状況一覧照会用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtymosym ztymosym}</td><td>（中継用）申込月度</td><td align="center">{@link PKZT_MosJkItiranSyoukaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymoskbn ztymoskbn}</td><td>（中継用）申込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">{@link PKZT_MosJkItiranSyoukaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruinm ztyhknsyuruinm}</td><td>（中継用）保険種類名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusymd ztymusymd}</td><td>（中継用）申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosnyuuryokuymd ztymosnyuuryokuymd}</td><td>（中継用）申込入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkikbn ztykydatkikbn}</td><td>（中継用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">{@link PKZT_MosJkItiranSyoukaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtenkjnm ztybsydrtenkjnm}</td><td>（中継用）募集代理店漢字名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatukaikojincd ztyatukaikojincd}</td><td>（中継用）扱者個人コード</td><td align="center">{@link PKZT_MosJkItiranSyoukaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytansyukukjatukaisyanm ztytansyukukjatukaisyanm}</td><td>（中継用）短縮漢字扱者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkyknm10 ztykjkyknm10}</td><td>（中継用）漢字契約者名（１０文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytansyukukjhhknnm ztytansyukukjhhknnm}</td><td>（中継用）短縮漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2keta ztyhhknnen2keta}</td><td>（中継用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyoumetukbn ztymossyoumetukbn}</td><td>（中継用）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykurikosiriyuukbn ztykurikosiriyuukbn}</td><td>（中継用）繰越理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketjkkbn ztyketjkkbn}</td><td>（中継用）決定状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiktjyoutaikbn ztydakuhiktjyoutaikbn}</td><td>（中継用）諾否決定状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosketkekkakbn ztymosketkekkakbn}</td><td>（中継用）申込決定結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonhubi ztykihonhubi}</td><td>（中継用）基本不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykthhbhyouji ztykthhbhyouji}</td><td>（中継用）決定保留不備表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrhhbhyouji ztysrhhbhyouji}</td><td>（中継用）成立保留不備表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknzumihyouji ztynyknzumihyouji}</td><td>（中継用）入金済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinsazumihyouji ztysinsazumihyouji}</td><td>（中継用）診査済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuukatanikbn ztytuukatanikbn}</td><td>（中継用）通貨単位区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaihrkpmoji ztysyokaihrkpmoji}</td><td>（中継用）初回払込Ｐ（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjykktkbn ztyhjykktkbn}</td><td>（中継用）報状告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipryosyuymd ztysyokaipryosyuymd}</td><td>（中継用）初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykokutiymd ztykokutiymd}</td><td>（中継用）告知年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykariseirituymd ztykariseirituymd}</td><td>（中継用）仮成立年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstpnyknnaiyoukbn ztyfstpnyknnaiyoukbn}</td><td>（中継用）初回Ｐ入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseiymd ztysakuseiymd}</td><td>（中継用）作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyanniskcd ztyanniskcd}</td><td>（中継用）案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosakuseiymd ztysyosakuseiymd}</td><td>（中継用）証券作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtenkobetuinfo1 ztybsydrtenkobetuinfo1}</td><td>（中継用）募集代理店個別情報１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtenkobetuinfo2 ztybsydrtenkobetuinfo2}</td><td>（中継用）募集代理店個別情報２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtenkobetuinfo3 ztybsydrtenkobetuinfo3}</td><td>（中継用）募集代理店個別情報３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtenkobetuinfo4 ztybsydrtenkobetuinfo4}</td><td>（中継用）募集代理店個別情報４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtenkobetuinfo5 ztybsydrtenkobetuinfo5}</td><td>（中継用）募集代理店個別情報５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybankkouincd ztybankkouincd}</td><td>（中継用）銀行行員コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuutourokuno ztybosyuutourokuno}</td><td>（中継用）募集人登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosjkkbn ztymosjkkbn}</td><td>（中継用）申込状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinymd ztykousinymd}</td><td>（中継用）更新年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinsayoteiymd ztysinsayoteiymd}</td><td>（中継用）診査予定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnkykhyj ztyhjnkykhyj}</td><td>（中継用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjhjnnm ztykjhjnnm}</td><td>（中継用）漢字法人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv93 ztyyobiv93}</td><td>（中継用）予備項目Ｖ９３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_MosJkItiranSyoukaiTy
 * @see     PKZT_MosJkItiranSyoukaiTy
 * @see     QZT_MosJkItiranSyoukaiTy
 * @see     GenQZT_MosJkItiranSyoukaiTy
 */
@MappedSuperclass
@Table(name=GenZT_MosJkItiranSyoukaiTy.TABLE_NAME)
@IdClass(value=PKZT_MosJkItiranSyoukaiTy.class)
public abstract class GenZT_MosJkItiranSyoukaiTy extends AbstractExDBEntity<ZT_MosJkItiranSyoukaiTy, PKZT_MosJkItiranSyoukaiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_MosJkItiranSyoukaiTy";
    public static final String ZTYMOSYM                 = "ztymosym";
    public static final String ZTYMOSKBN                = "ztymoskbn";
    public static final String ZTYMOSNO                 = "ztymosno";
    public static final String ZTYHKNSYURUINM           = "ztyhknsyuruinm";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYMUSYMD                = "ztymusymd";
    public static final String ZTYMOSNYUURYOKUYMD       = "ztymosnyuuryokuymd";
    public static final String ZTYKYDATKIKBN            = "ztykydatkikbn";
    public static final String ZTYBSUDIRTNATKIKEITAIKBN = "ztybsudirtnatkikeitaikbn";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYBSYDRTENKJNM          = "ztybsydrtenkjnm";
    public static final String ZTYATUKAIKOJINCD         = "ztyatukaikojincd";
    public static final String ZTYTANSYUKUKJATUKAISYANM = "ztytansyukukjatukaisyanm";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYKJKYKNM10             = "ztykjkyknm10";
    public static final String ZTYTANSYUKUKJHHKNNM      = "ztytansyukukjhhknnm";
    public static final String ZTYHHKNNEN2KETA          = "ztyhhknnen2keta";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYMOSSYOUMETUKBN        = "ztymossyoumetukbn";
    public static final String ZTYKURIKOSIRIYUUKBN      = "ztykurikosiriyuukbn";
    public static final String ZTYKETJKKBN              = "ztyketjkkbn";
    public static final String ZTYDAKUHIKTJYOUTAIKBN    = "ztydakuhiktjyoutaikbn";
    public static final String ZTYMOSKETKEKKAKBN        = "ztymosketkekkakbn";
    public static final String ZTYKIHONHUBI             = "ztykihonhubi";
    public static final String ZTYKTHHBHYOUJI           = "ztykthhbhyouji";
    public static final String ZTYSRHHBHYOUJI           = "ztysrhhbhyouji";
    public static final String ZTYNYKNZUMIHYOUJI        = "ztynyknzumihyouji";
    public static final String ZTYSINSAZUMIHYOUJI       = "ztysinsazumihyouji";
    public static final String ZTYTUUKATANIKBN          = "ztytuukatanikbn";
    public static final String ZTYSYOKAIHRKPMOJI        = "ztysyokaihrkpmoji";
    public static final String ZTYHJYKKTKBN             = "ztyhjykktkbn";
    public static final String ZTYSYOKAIPRYOSYUYMD      = "ztysyokaipryosyuymd";
    public static final String ZTYKOKUTIYMD             = "ztykokutiymd";
    public static final String ZTYKARISEIRITUYMD        = "ztykariseirituymd";
    public static final String ZTYFSTPNYKNNAIYOUKBN     = "ztyfstpnyknnaiyoukbn";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYSAKUSEIYMD            = "ztysakuseiymd";
    public static final String ZTYANNISKCD              = "ztyanniskcd";
    public static final String ZTYSYOSAKUSEIYMD         = "ztysyosakuseiymd";
    public static final String ZTYBSYDRTENKOBETUINFO1   = "ztybsydrtenkobetuinfo1";
    public static final String ZTYBSYDRTENKOBETUINFO2   = "ztybsydrtenkobetuinfo2";
    public static final String ZTYBSYDRTENKOBETUINFO3   = "ztybsydrtenkobetuinfo3";
    public static final String ZTYBSYDRTENKOBETUINFO4   = "ztybsydrtenkobetuinfo4";
    public static final String ZTYBSYDRTENKOBETUINFO5   = "ztybsydrtenkobetuinfo5";
    public static final String ZTYBANKKOUINCD           = "ztybankkouincd";
    public static final String ZTYBOSYUUTOUROKUNO       = "ztybosyuutourokuno";
    public static final String ZTYMOSJKKBN              = "ztymosjkkbn";
    public static final String ZTYKOUSINYMD             = "ztykousinymd";
    public static final String ZTYSINSAYOTEIYMD         = "ztysinsayoteiymd";
    public static final String ZTYHJNKYKHYJ             = "ztyhjnkykhyj";
    public static final String ZTYKJHJNNM               = "ztykjhjnnm";
    public static final String ZTYYOBIV93               = "ztyyobiv93";

    private final PKZT_MosJkItiranSyoukaiTy primaryKey;

    public GenZT_MosJkItiranSyoukaiTy() {
        primaryKey = new PKZT_MosJkItiranSyoukaiTy();
    }

    public GenZT_MosJkItiranSyoukaiTy(
        String pZtymosym,
        String pZtymosno,
        String pZtybsydrtencd,
        String pZtyatukaikojincd
    ) {
        primaryKey = new PKZT_MosJkItiranSyoukaiTy(
            pZtymosym,
            pZtymosno,
            pZtybsydrtencd,
            pZtyatukaikojincd
        );
    }

    @Transient
    @Override
    public PKZT_MosJkItiranSyoukaiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_MosJkItiranSyoukaiTy> getMetaClass() {
        return QZT_MosJkItiranSyoukaiTy.class;
    }

    @Id
    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYMOSYM)
    public String getZtymosym() {
        return getPrimaryKey().getZtymosym();
    }

    public void setZtymosym(String pZtymosym) {
        getPrimaryKey().setZtymosym(pZtymosym);
    }

    private String ztymoskbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYMOSKBN)
    public String getZtymoskbn() {
        return ztymoskbn;
    }

    public void setZtymoskbn(String pZtymoskbn) {
        ztymoskbn = pZtymoskbn;
    }

    @Id
    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYMOSNO)
    public String getZtymosno() {
        return getPrimaryKey().getZtymosno();
    }

    public void setZtymosno(String pZtymosno) {
        getPrimaryKey().setZtymosno(pZtymosno);
    }

    private String ztyhknsyuruinm;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYHKNSYURUINM)
    public String getZtyhknsyuruinm() {
        return ztyhknsyuruinm;
    }

    public void setZtyhknsyuruinm(String pZtyhknsyuruinm) {
        ztyhknsyuruinm = pZtyhknsyuruinm;
    }

    private String ztykykymd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztymusymd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYMUSYMD)
    public String getZtymusymd() {
        return ztymusymd;
    }

    public void setZtymusymd(String pZtymusymd) {
        ztymusymd = pZtymusymd;
    }

    private String ztymosnyuuryokuymd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYMOSNYUURYOKUYMD)
    public String getZtymosnyuuryokuymd() {
        return ztymosnyuuryokuymd;
    }

    public void setZtymosnyuuryokuymd(String pZtymosnyuuryokuymd) {
        ztymosnyuuryokuymd = pZtymosnyuuryokuymd;
    }

    private String ztykydatkikbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYKYDATKIKBN)
    public String getZtykydatkikbn() {
        return ztykydatkikbn;
    }

    public void setZtykydatkikbn(String pZtykydatkikbn) {
        ztykydatkikbn = pZtykydatkikbn;
    }

    private String ztybsudirtnatkikeitaikbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYBSUDIRTNATKIKEITAIKBN)
    public String getZtybsudirtnatkikeitaikbn() {
        return ztybsudirtnatkikeitaikbn;
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
    }

    @Id
    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return getPrimaryKey().getZtybsydrtencd();
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        getPrimaryKey().setZtybsydrtencd(pZtybsydrtencd);
    }

    private String ztybsydrtenkjnm;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYBSYDRTENKJNM)
    public String getZtybsydrtenkjnm() {
        return ztybsydrtenkjnm;
    }

    public void setZtybsydrtenkjnm(String pZtybsydrtenkjnm) {
        ztybsydrtenkjnm = pZtybsydrtenkjnm;
    }

    @Id
    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYATUKAIKOJINCD)
    public String getZtyatukaikojincd() {
        return getPrimaryKey().getZtyatukaikojincd();
    }

    public void setZtyatukaikojincd(String pZtyatukaikojincd) {
        getPrimaryKey().setZtyatukaikojincd(pZtyatukaikojincd);
    }

    private String ztytansyukukjatukaisyanm;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYTANSYUKUKJATUKAISYANM)
    public String getZtytansyukukjatukaisyanm() {
        return ztytansyukukjatukaisyanm;
    }

    public void setZtytansyukukjatukaisyanm(String pZtytansyukukjatukaisyanm) {
        ztytansyukukjatukaisyanm = pZtytansyukukjatukaisyanm;
    }

    private String ztycifcd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztykjkyknm10;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYKJKYKNM10)
    public String getZtykjkyknm10() {
        return ztykjkyknm10;
    }

    public void setZtykjkyknm10(String pZtykjkyknm10) {
        ztykjkyknm10 = pZtykjkyknm10;
    }

    private String ztytansyukukjhhknnm;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYTANSYUKUKJHHKNNM)
    public String getZtytansyukukjhhknnm() {
        return ztytansyukukjhhknnm;
    }

    public void setZtytansyukukjhhknnm(String pZtytansyukukjhhknnm) {
        ztytansyukukjhhknnm = pZtytansyukukjhhknnm;
    }

    private String ztyhhknnen2keta;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYHHKNNEN2KETA)
    public String getZtyhhknnen2keta() {
        return ztyhhknnen2keta;
    }

    public void setZtyhhknnen2keta(String pZtyhhknnen2keta) {
        ztyhhknnen2keta = pZtyhhknnen2keta;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztymossyoumetukbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYMOSSYOUMETUKBN)
    public String getZtymossyoumetukbn() {
        return ztymossyoumetukbn;
    }

    public void setZtymossyoumetukbn(String pZtymossyoumetukbn) {
        ztymossyoumetukbn = pZtymossyoumetukbn;
    }

    private String ztykurikosiriyuukbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYKURIKOSIRIYUUKBN)
    public String getZtykurikosiriyuukbn() {
        return ztykurikosiriyuukbn;
    }

    public void setZtykurikosiriyuukbn(String pZtykurikosiriyuukbn) {
        ztykurikosiriyuukbn = pZtykurikosiriyuukbn;
    }

    private String ztyketjkkbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYKETJKKBN)
    public String getZtyketjkkbn() {
        return ztyketjkkbn;
    }

    public void setZtyketjkkbn(String pZtyketjkkbn) {
        ztyketjkkbn = pZtyketjkkbn;
    }

    private String ztydakuhiktjyoutaikbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYDAKUHIKTJYOUTAIKBN)
    public String getZtydakuhiktjyoutaikbn() {
        return ztydakuhiktjyoutaikbn;
    }

    public void setZtydakuhiktjyoutaikbn(String pZtydakuhiktjyoutaikbn) {
        ztydakuhiktjyoutaikbn = pZtydakuhiktjyoutaikbn;
    }

    private String ztymosketkekkakbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYMOSKETKEKKAKBN)
    public String getZtymosketkekkakbn() {
        return ztymosketkekkakbn;
    }

    public void setZtymosketkekkakbn(String pZtymosketkekkakbn) {
        ztymosketkekkakbn = pZtymosketkekkakbn;
    }

    private String ztykihonhubi;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYKIHONHUBI)
    public String getZtykihonhubi() {
        return ztykihonhubi;
    }

    public void setZtykihonhubi(String pZtykihonhubi) {
        ztykihonhubi = pZtykihonhubi;
    }

    private String ztykthhbhyouji;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYKTHHBHYOUJI)
    public String getZtykthhbhyouji() {
        return ztykthhbhyouji;
    }

    public void setZtykthhbhyouji(String pZtykthhbhyouji) {
        ztykthhbhyouji = pZtykthhbhyouji;
    }

    private String ztysrhhbhyouji;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYSRHHBHYOUJI)
    public String getZtysrhhbhyouji() {
        return ztysrhhbhyouji;
    }

    public void setZtysrhhbhyouji(String pZtysrhhbhyouji) {
        ztysrhhbhyouji = pZtysrhhbhyouji;
    }

    private String ztynyknzumihyouji;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYNYKNZUMIHYOUJI)
    public String getZtynyknzumihyouji() {
        return ztynyknzumihyouji;
    }

    public void setZtynyknzumihyouji(String pZtynyknzumihyouji) {
        ztynyknzumihyouji = pZtynyknzumihyouji;
    }

    private String ztysinsazumihyouji;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYSINSAZUMIHYOUJI)
    public String getZtysinsazumihyouji() {
        return ztysinsazumihyouji;
    }

    public void setZtysinsazumihyouji(String pZtysinsazumihyouji) {
        ztysinsazumihyouji = pZtysinsazumihyouji;
    }

    private String ztytuukatanikbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYTUUKATANIKBN)
    public String getZtytuukatanikbn() {
        return ztytuukatanikbn;
    }

    public void setZtytuukatanikbn(String pZtytuukatanikbn) {
        ztytuukatanikbn = pZtytuukatanikbn;
    }

    private String ztysyokaihrkpmoji;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYSYOKAIHRKPMOJI)
    public String getZtysyokaihrkpmoji() {
        return ztysyokaihrkpmoji;
    }

    public void setZtysyokaihrkpmoji(String pZtysyokaihrkpmoji) {
        ztysyokaihrkpmoji = pZtysyokaihrkpmoji;
    }

    private String ztyhjykktkbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYHJYKKTKBN)
    public String getZtyhjykktkbn() {
        return ztyhjykktkbn;
    }

    public void setZtyhjykktkbn(String pZtyhjykktkbn) {
        ztyhjykktkbn = pZtyhjykktkbn;
    }

    private String ztysyokaipryosyuymd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYSYOKAIPRYOSYUYMD)
    public String getZtysyokaipryosyuymd() {
        return ztysyokaipryosyuymd;
    }

    public void setZtysyokaipryosyuymd(String pZtysyokaipryosyuymd) {
        ztysyokaipryosyuymd = pZtysyokaipryosyuymd;
    }

    private String ztykokutiymd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYKOKUTIYMD)
    public String getZtykokutiymd() {
        return ztykokutiymd;
    }

    public void setZtykokutiymd(String pZtykokutiymd) {
        ztykokutiymd = pZtykokutiymd;
    }

    private String ztykariseirituymd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYKARISEIRITUYMD)
    public String getZtykariseirituymd() {
        return ztykariseirituymd;
    }

    public void setZtykariseirituymd(String pZtykariseirituymd) {
        ztykariseirituymd = pZtykariseirituymd;
    }

    private String ztyfstpnyknnaiyoukbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYFSTPNYKNNAIYOUKBN)
    public String getZtyfstpnyknnaiyoukbn() {
        return ztyfstpnyknnaiyoukbn;
    }

    public void setZtyfstpnyknnaiyoukbn(String pZtyfstpnyknnaiyoukbn) {
        ztyfstpnyknnaiyoukbn = pZtyfstpnyknnaiyoukbn;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztysakuseiymd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYSAKUSEIYMD)
    public String getZtysakuseiymd() {
        return ztysakuseiymd;
    }

    public void setZtysakuseiymd(String pZtysakuseiymd) {
        ztysakuseiymd = pZtysakuseiymd;
    }

    private String ztyanniskcd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYANNISKCD)
    public String getZtyanniskcd() {
        return ztyanniskcd;
    }

    public void setZtyanniskcd(String pZtyanniskcd) {
        ztyanniskcd = pZtyanniskcd;
    }

    private String ztysyosakuseiymd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYSYOSAKUSEIYMD)
    public String getZtysyosakuseiymd() {
        return ztysyosakuseiymd;
    }

    public void setZtysyosakuseiymd(String pZtysyosakuseiymd) {
        ztysyosakuseiymd = pZtysyosakuseiymd;
    }

    private String ztybsydrtenkobetuinfo1;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYBSYDRTENKOBETUINFO1)
    public String getZtybsydrtenkobetuinfo1() {
        return ztybsydrtenkobetuinfo1;
    }

    public void setZtybsydrtenkobetuinfo1(String pZtybsydrtenkobetuinfo1) {
        ztybsydrtenkobetuinfo1 = pZtybsydrtenkobetuinfo1;
    }

    private String ztybsydrtenkobetuinfo2;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYBSYDRTENKOBETUINFO2)
    public String getZtybsydrtenkobetuinfo2() {
        return ztybsydrtenkobetuinfo2;
    }

    public void setZtybsydrtenkobetuinfo2(String pZtybsydrtenkobetuinfo2) {
        ztybsydrtenkobetuinfo2 = pZtybsydrtenkobetuinfo2;
    }

    private String ztybsydrtenkobetuinfo3;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYBSYDRTENKOBETUINFO3)
    public String getZtybsydrtenkobetuinfo3() {
        return ztybsydrtenkobetuinfo3;
    }

    public void setZtybsydrtenkobetuinfo3(String pZtybsydrtenkobetuinfo3) {
        ztybsydrtenkobetuinfo3 = pZtybsydrtenkobetuinfo3;
    }

    private String ztybsydrtenkobetuinfo4;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYBSYDRTENKOBETUINFO4)
    public String getZtybsydrtenkobetuinfo4() {
        return ztybsydrtenkobetuinfo4;
    }

    public void setZtybsydrtenkobetuinfo4(String pZtybsydrtenkobetuinfo4) {
        ztybsydrtenkobetuinfo4 = pZtybsydrtenkobetuinfo4;
    }

    private String ztybsydrtenkobetuinfo5;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYBSYDRTENKOBETUINFO5)
    public String getZtybsydrtenkobetuinfo5() {
        return ztybsydrtenkobetuinfo5;
    }

    public void setZtybsydrtenkobetuinfo5(String pZtybsydrtenkobetuinfo5) {
        ztybsydrtenkobetuinfo5 = pZtybsydrtenkobetuinfo5;
    }

    private String ztybankkouincd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYBANKKOUINCD)
    public String getZtybankkouincd() {
        return ztybankkouincd;
    }

    public void setZtybankkouincd(String pZtybankkouincd) {
        ztybankkouincd = pZtybankkouincd;
    }

    private String ztybosyuutourokuno;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYBOSYUUTOUROKUNO)
    public String getZtybosyuutourokuno() {
        return ztybosyuutourokuno;
    }

    public void setZtybosyuutourokuno(String pZtybosyuutourokuno) {
        ztybosyuutourokuno = pZtybosyuutourokuno;
    }

    private String ztymosjkkbn;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYMOSJKKBN)
    public String getZtymosjkkbn() {
        return ztymosjkkbn;
    }

    public void setZtymosjkkbn(String pZtymosjkkbn) {
        ztymosjkkbn = pZtymosjkkbn;
    }

    private String ztykousinymd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYKOUSINYMD)
    public String getZtykousinymd() {
        return ztykousinymd;
    }

    public void setZtykousinymd(String pZtykousinymd) {
        ztykousinymd = pZtykousinymd;
    }

    private String ztysinsayoteiymd;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYSINSAYOTEIYMD)
    public String getZtysinsayoteiymd() {
        return ztysinsayoteiymd;
    }

    public void setZtysinsayoteiymd(String pZtysinsayoteiymd) {
        ztysinsayoteiymd = pZtysinsayoteiymd;
    }

    private String ztyhjnkykhyj;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYHJNKYKHYJ)
    public String getZtyhjnkykhyj() {
        return ztyhjnkykhyj;
    }

    public void setZtyhjnkykhyj(String pZtyhjnkykhyj) {
        ztyhjnkykhyj = pZtyhjnkykhyj;
    }

    private String ztykjhjnnm;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYKJHJNNM)
    public String getZtykjhjnnm() {
        return ztykjhjnnm;
    }

    public void setZtykjhjnnm(String pZtykjhjnnm) {
        ztykjhjnnm = pZtykjhjnnm;
    }

    private String ztyyobiv93;

    @Column(name=GenZT_MosJkItiranSyoukaiTy.ZTYYOBIV93)
    public String getZtyyobiv93() {
        return ztyyobiv93;
    }

    public void setZtyyobiv93(String pZtyyobiv93) {
        ztyyobiv93 = pZtyyobiv93;
    }
}
