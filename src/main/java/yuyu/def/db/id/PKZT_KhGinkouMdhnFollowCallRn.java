package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.db.mapping.GenZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.db.meta.GenQZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.db.meta.QZT_KhGinkouMdhnFollowCallRn;

/**
 * 銀行窓販フォローコール対象テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KhGinkouMdhnFollowCallRn}</td><td colspan="3">銀行窓販フォローコール対象テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyorikbn</td><td>（連携用）処理区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaip</td><td>（連携用）案内保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv8</td><td>（連携用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnminyuuym zrnminyuuym}</td><td>（連携用）未入年月</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskymd</td><td>（連携用）失効年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskhr</td><td>（連携用）失効時返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnttkekin</td><td>（連携用）今期立替金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnttkeganri</td><td>（連携用）立替元利金合計</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnttkersk</td><td>（連携用）立替利息</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnttkeriritu</td><td>（連携用）立替利率</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttkejyuutouym</td><td>（連携用）立替充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttkejyuutounen</td><td>（連携用）立替充当年数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttkejyuutoutuki</td><td>（連携用）立替充当月数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv8x2</td><td>（連携用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv29</td><td>（連携用）予備項目Ｖ２９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaskinmeino</td><td>（連携用）契約者索引名番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseiymd</td><td>（連携用）契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmhnykkbn</td><td>（連携用）契約者名翻訳結果区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkyknm35keta</td><td>（連携用）漢字契約者名（３５桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnknkyksyamei</td><td>（連携用）カナ契約者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmhnykkbn</td><td>（連携用）被保険者名翻訳結果区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjhhknmei</td><td>（連携用）漢字被保険者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnknhhknmei</td><td>（連携用）カナ被保険者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseiymd</td><td>（連携用）被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihontikucd</td><td>（連携用）基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaadr</td><td>（連携用）契約者住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntsintelno</td><td>（連携用）通信先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjikaipjyuutouym</td><td>（連携用）次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnanniskcd</td><td>（連携用）案内先コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknmeisyou15keta</td><td>（連携用）保険名称（１５桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbsyujdrtencd1</td><td>（連携用）募集時代理店コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyujbosyuucd1</td><td>（連携用）募集時募集人コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyujdrtencd2</td><td>（連携用）募集時代理店コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyujbosyuucd2</td><td>（連携用）募集時募集人コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyujdrtencd3</td><td>（連携用）募集時代理店コード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyujbosyuucd3</td><td>（連携用）募集時募集人コード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyujdrtencd4</td><td>（連携用）募集時代理店コード４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyujbosyuucd4</td><td>（連携用）募集時募集人コード４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyujdrtencd5</td><td>（連携用）募集時代理店コード５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyujbosyuucd5</td><td>（連携用）募集時募集人コード５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaisindrtencd</td><td>（連携用）最新代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaisinbosyuucd</td><td>（連携用）最新募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaebankcd</td><td>（連携用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaesitencd</td><td>（連携用）口座振替支店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeyokinkbn</td><td>（連携用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaekouzano</td><td>（連携用）口座振替口座番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhnsyugkhmignnmei</td><td>（連携用）編集後口座振替名義人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv39</td><td>（連携用）予備項目Ｖ３９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KhGinkouMdhnFollowCallRn
 * @see     GenZT_KhGinkouMdhnFollowCallRn
 * @see     QZT_KhGinkouMdhnFollowCallRn
 * @see     GenQZT_KhGinkouMdhnFollowCallRn
 */
public class PKZT_KhGinkouMdhnFollowCallRn extends AbstractExDBPrimaryKey<ZT_KhGinkouMdhnFollowCallRn, PKZT_KhGinkouMdhnFollowCallRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KhGinkouMdhnFollowCallRn() {
    }

    public PKZT_KhGinkouMdhnFollowCallRn(String pZrnsyono, String pZrnminyuuym) {
        zrnsyono = pZrnsyono;
        zrnminyuuym = pZrnminyuuym;
    }

    @Transient
    @Override
    public Class<ZT_KhGinkouMdhnFollowCallRn> getEntityClass() {
        return ZT_KhGinkouMdhnFollowCallRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnminyuuym;

    public String getZrnminyuuym() {
        return zrnminyuuym;
    }

    public void setZrnminyuuym(String pZrnminyuuym) {
        zrnminyuuym = pZrnminyuuym;
    }

}