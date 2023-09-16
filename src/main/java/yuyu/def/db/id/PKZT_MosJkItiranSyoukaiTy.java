package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.mapping.GenZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.meta.GenQZT_MosJkItiranSyoukaiTy;
import yuyu.def.db.meta.QZT_MosJkItiranSyoukaiTy;

/**
 * 申込状況一覧照会用Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_MosJkItiranSyoukaiTy}</td><td colspan="3">申込状況一覧照会用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtymosym ztymosym}</td><td>（中継用）申込月度</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymoskbn</td><td>（中継用）申込区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruinm</td><td>（中継用）保険種類名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymusymd</td><td>（中継用）申込年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosnyuuryokuymd</td><td>（中継用）申込入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydatkikbn</td><td>（中継用）共同扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsudirtnatkikeitaikbn</td><td>（中継用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtenkjnm</td><td>（中継用）募集代理店漢字名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyatukaikojincd ztyatukaikojincd}</td><td>（中継用）扱者個人コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytansyukukjatukaisyanm</td><td>（中継用）短縮漢字扱者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycifcd</td><td>（中継用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkyknm10</td><td>（中継用）漢字契約者名（１０文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytansyukukjhhknnm</td><td>（中継用）短縮漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen2keta</td><td>（中継用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymossyoumetukbn</td><td>（中継用）申込消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykurikosiriyuukbn</td><td>（中継用）繰越理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketjkkbn</td><td>（中継用）決定状況区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiktjyoutaikbn</td><td>（中継用）諾否決定状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosketkekkakbn</td><td>（中継用）申込決定結果区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihonhubi</td><td>（中継用）基本不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykthhbhyouji</td><td>（中継用）決定保留不備表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysrhhbhyouji</td><td>（中継用）成立保留不備表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknzumihyouji</td><td>（中継用）入金済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinsazumihyouji</td><td>（中継用）診査済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuukatanikbn</td><td>（中継用）通貨単位区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaihrkpmoji</td><td>（中継用）初回払込Ｐ（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjykktkbn</td><td>（中継用）報状告知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaipryosyuymd</td><td>（中継用）初回Ｐ領収年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykokutiymd</td><td>（中継用）告知年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykariseirituymd</td><td>（中継用）仮成立年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstpnyknnaiyoukbn</td><td>（中継用）初回Ｐ入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseiymd</td><td>（中継用）作成日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyanniskcd</td><td>（中継用）案内先コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyosakuseiymd</td><td>（中継用）証券作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtenkobetuinfo1</td><td>（中継用）募集代理店個別情報１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtenkobetuinfo2</td><td>（中継用）募集代理店個別情報２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtenkobetuinfo3</td><td>（中継用）募集代理店個別情報３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtenkobetuinfo4</td><td>（中継用）募集代理店個別情報４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtenkobetuinfo5</td><td>（中継用）募集代理店個別情報５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybankkouincd</td><td>（中継用）銀行行員コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuutourokuno</td><td>（中継用）募集人登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosjkkbn</td><td>（中継用）申込状況区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykousinymd</td><td>（中継用）更新年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinsayoteiymd</td><td>（中継用）診査予定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjnkykhyj</td><td>（中継用）法人契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjhjnnm</td><td>（中継用）漢字法人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv93</td><td>（中継用）予備項目Ｖ９３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_MosJkItiranSyoukaiTy
 * @see     GenZT_MosJkItiranSyoukaiTy
 * @see     QZT_MosJkItiranSyoukaiTy
 * @see     GenQZT_MosJkItiranSyoukaiTy
 */
public class PKZT_MosJkItiranSyoukaiTy extends AbstractExDBPrimaryKey<ZT_MosJkItiranSyoukaiTy, PKZT_MosJkItiranSyoukaiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_MosJkItiranSyoukaiTy() {
    }

    public PKZT_MosJkItiranSyoukaiTy(
        String pZtymosym,
        String pZtymosno,
        String pZtybsydrtencd,
        String pZtyatukaikojincd
    ) {
        ztymosym = pZtymosym;
        ztymosno = pZtymosno;
        ztybsydrtencd = pZtybsydrtencd;
        ztyatukaikojincd = pZtyatukaikojincd;
    }

    @Transient
    @Override
    public Class<ZT_MosJkItiranSyoukaiTy> getEntityClass() {
        return ZT_MosJkItiranSyoukaiTy.class;
    }

    private String ztymosym;

    public String getZtymosym() {
        return ztymosym;
    }

    public void setZtymosym(String pZtymosym) {
        ztymosym = pZtymosym;
    }
    private String ztymosno;

    public String getZtymosno() {
        return ztymosno;
    }

    public void setZtymosno(String pZtymosno) {
        ztymosno = pZtymosno;
    }
    private String ztybsydrtencd;

    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }
    private String ztyatukaikojincd;

    public String getZtyatukaikojincd() {
        return ztyatukaikojincd;
    }

    public void setZtyatukaikojincd(String pZtyatukaikojincd) {
        ztyatukaikojincd = pZtyatukaikojincd;
    }

}