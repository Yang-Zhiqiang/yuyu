package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SeirituInfoRn;
import yuyu.def.db.mapping.GenZT_SeirituInfoRn;
import yuyu.def.db.meta.GenQZT_SeirituInfoRn;
import yuyu.def.db.meta.QZT_SeirituInfoRn;

/**
 * 成立情報Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeirituInfoRn}</td><td colspan="3">成立情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkijyunym zrnkijyunym}</td><td>（連携用）基準年月</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseisekiym</td><td>（連携用）成績計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhanbainm</td><td>（連携用）販売名称</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatkisisya</td><td>（連携用）扱支社</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsdpdkbn</td><td>（連携用）Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsinkykryouritukbn</td><td>（連携用）新契約用料率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnduketorihouhoukbn</td><td>（連携用）Ｄ受取方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihons9</td><td>（連携用）基本Ｓ（９桁）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhsys</td><td>（連携用）保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkbriknsnhrkp</td><td>（連携用）月払換算払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseikbn</td><td>（連携用）契約者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen2keta</td><td>（連携用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyanen</td><td>（連携用）契約者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykgycd</td><td>（連携用）職業コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyakikykarihyj</td><td>（連携用）契約者既契約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaipnyuukinhouhoukbn</td><td>（連携用）初回Ｐ入金方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukeiyousinsakbn</td><td>（連携用）統計用診査区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknsynensyuukbn</td><td>（連携用）被保険者年収区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukeiyakup</td><td>（連携用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbsudirtnatkikeitaikbn</td><td>（連携用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdairiseikyuutkykarihyj</td><td>（連携用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmannenreihyj</td><td>（連携用）満年令表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikbn1</td><td>（連携用）年金種類区分（１文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnstkarihyj</td><td>（連携用）年金支払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatkioybsydrtencd</td><td>（連携用）Ａ扱者親募集代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbatkioybsydrtencd</td><td>（連携用）Ｂ扱者親募集代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsinkeiyakujiyoteiriritu</td><td>（連携用）新契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsiteituukakihons</td><td>（連携用）指定通貨建基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnhrktuukakbn</td><td>（連携用）払込通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiteituukakbn</td><td>（連携用）指定通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrktuukatukiknznhrkp</td><td>（連携用）払込通貨建月換算払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsiteituukatukiknznhrkp</td><td>（連携用）指定通貨建月換算払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyennyknrate</td><td>（連携用）円入金レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrngaikanyknrate</td><td>（連携用）外貨入金レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnjyudkaigomehrtkarihyj</td><td>（連携用）重度介護前払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyksbyensitihsyutkykrate</td><td>（連携用）初期死亡時円換算最低保証特約用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsjkkktyouseiriritu</td><td>（連携用）市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntargettkmkht</td><td>（連携用）ターゲット特約目標値</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnteirituhaibunwari</td><td>（連携用）定率部分配分割合</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzenkizennouhyouji</td><td>（連携用）全期前納表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpwaribikikbn</td><td>（連携用）Ｐ割引区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpwaribikihanteigk</td><td>（連携用）Ｐ割引判定金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrndai1hknkkn</td><td>（連携用）第１保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdrtkykarihyj</td><td>（連携用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktrkservicetrkninzuu</td><td>（連携用）ご家族登録サービス登録人数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikisiharaiarihyj</td><td>（連携用）定期支払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv6</td><td>（連携用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeirituInfoRn
 * @see     GenZT_SeirituInfoRn
 * @see     QZT_SeirituInfoRn
 * @see     GenQZT_SeirituInfoRn
 */
public class PKZT_SeirituInfoRn extends AbstractExDBPrimaryKey<ZT_SeirituInfoRn, PKZT_SeirituInfoRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SeirituInfoRn() {
    }

    public PKZT_SeirituInfoRn(String pZrnkijyunym, String pZrnsyono) {
        zrnkijyunym = pZrnkijyunym;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_SeirituInfoRn> getEntityClass() {
        return ZT_SeirituInfoRn.class;
    }

    private String zrnkijyunym;

    public String getZrnkijyunym() {
        return zrnkijyunym;
    }

    public void setZrnkijyunym(String pZrnkijyunym) {
        zrnkijyunym = pZrnkijyunym;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}