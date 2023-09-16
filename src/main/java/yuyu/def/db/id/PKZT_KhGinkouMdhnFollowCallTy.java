package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.db.mapping.GenZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.db.meta.GenQZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.db.meta.QZT_KhGinkouMdhnFollowCallTy;

/**
 * 銀行窓販フォローコール対象テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KhGinkouMdhnFollowCallTy}</td><td colspan="3">銀行窓販フォローコール対象テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorikbn</td><td>（中継用）処理区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaip</td><td>（中継用）案内保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv8</td><td>（中継用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyminyuuym ztyminyuuym}</td><td>（中継用）未入年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskymd</td><td>（中継用）失効年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskhr</td><td>（中継用）失効時返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyttkekin</td><td>（中継用）今期立替金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyttkeganri</td><td>（中継用）立替元利金合計</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyttkersk</td><td>（中継用）立替利息</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyttkeriritu</td><td>（中継用）立替利率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttkejyuutouym</td><td>（中継用）立替充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttkejyuutounen</td><td>（中継用）立替充当年数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttkejyuutoutuki</td><td>（中継用）立替充当月数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv8x2</td><td>（中継用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv29</td><td>（中継用）予備項目Ｖ２９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaskinmeino</td><td>（中継用）契約者索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseiymd</td><td>（中継用）契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmhnykkbn</td><td>（中継用）契約者名翻訳結果区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkyknm35keta</td><td>（中継用）漢字契約者名（３５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkyksyamei</td><td>（中継用）カナ契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmhnykkbn</td><td>（中継用）被保険者名翻訳結果区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknjhhknmei</td><td>（中継用）漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknhhknmei</td><td>（中継用）カナ被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseiymd</td><td>（中継用）被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihontikucd</td><td>（中継用）基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaadr</td><td>（中継用）契約者住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsintelno</td><td>（中継用）通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikaipjyuutouym</td><td>（中継用）次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyanniskcd</td><td>（中継用）案内先コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknmeisyou15keta</td><td>（中継用）保険名称（１５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyujdrtencd1</td><td>（中継用）募集時代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyujbosyuucd1</td><td>（中継用）募集時募集人コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyujdrtencd2</td><td>（中継用）募集時代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyujbosyuucd2</td><td>（中継用）募集時募集人コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyujdrtencd3</td><td>（中継用）募集時代理店コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyujbosyuucd3</td><td>（中継用）募集時募集人コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyujdrtencd4</td><td>（中継用）募集時代理店コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyujbosyuucd4</td><td>（中継用）募集時募集人コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyujdrtencd5</td><td>（中継用）募集時代理店コード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyujbosyuucd5</td><td>（中継用）募集時募集人コード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaisindrtencd</td><td>（中継用）最新代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaisinbosyuucd</td><td>（中継用）最新募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaebankcd</td><td>（中継用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaesitencd</td><td>（中継用）口座振替支店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeyokinkbn</td><td>（中継用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaekouzano</td><td>（中継用）口座振替口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnsyugkhmignnmei</td><td>（中継用）編集後口座振替名義人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv39</td><td>（中継用）予備項目Ｖ３９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KhGinkouMdhnFollowCallTy
 * @see     GenZT_KhGinkouMdhnFollowCallTy
 * @see     QZT_KhGinkouMdhnFollowCallTy
 * @see     GenQZT_KhGinkouMdhnFollowCallTy
 */
public class PKZT_KhGinkouMdhnFollowCallTy extends AbstractExDBPrimaryKey<ZT_KhGinkouMdhnFollowCallTy, PKZT_KhGinkouMdhnFollowCallTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KhGinkouMdhnFollowCallTy() {
    }

    public PKZT_KhGinkouMdhnFollowCallTy(String pZtysyono, String pZtyminyuuym) {
        ztysyono = pZtysyono;
        ztyminyuuym = pZtyminyuuym;
    }

    @Transient
    @Override
    public Class<ZT_KhGinkouMdhnFollowCallTy> getEntityClass() {
        return ZT_KhGinkouMdhnFollowCallTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztyminyuuym;

    public String getZtyminyuuym() {
        return ztyminyuuym;
    }

    public void setZtyminyuuym(String pZtyminyuuym) {
        ztyminyuuym = pZtyminyuuym;
    }

}