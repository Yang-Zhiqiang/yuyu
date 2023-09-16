package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DrtenKykIdouDetailRn;
import yuyu.def.db.mapping.GenZT_DrtenKykIdouDetailRn;
import yuyu.def.db.meta.GenQZT_DrtenKykIdouDetailRn;
import yuyu.def.db.meta.QZT_DrtenKykIdouDetailRn;

/**
 * 代理店契約異動明細テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenKykIdouDetailRn}</td><td colspan="3">代理店契約異動明細テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnkinyuukikancd</td><td>（連携用）金融機関コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkinyuukikansitencd</td><td>（連携用）金融機関支店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncifcd</td><td>（連携用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbosyuunincd zrnbosyuunincd}</td><td>（連携用）募集人コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnidouhasseiymd zrnidouhasseiymd}</td><td>（連携用）異動発生年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfksnctrlkh</td><td>（連携用）契約ＭＦ更新ＣＴＲ（保全）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyoricd</td><td>（連携用）処理コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnidoukbn zrnidoukbn}</td><td>（連携用）異動区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkydatkikbn</td><td>（連携用）共同扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjikaipjyuutouym</td><td>（連携用）次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnanniskcd</td><td>（連携用）案内先コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndntcd</td><td>（連携用）団体コ－ド</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnharaikomip</td><td>（連携用）払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkjsyagaihknnm</td><td>（連携用）漢字社外向け保険名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntelno</td><td>（連携用）電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhensyuubosyuudrtennm</td><td>（連携用）編集後漢字募集代理店名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkjdirtnkykido</td><td>（連携用）契約者名（漢字）（代理店契約異動明細）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjdntnm</td><td>（連携用）漢字団体名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaebankcd</td><td>（連携用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaesitencd</td><td>（連携用）口座振替支店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeyokinkbn</td><td>（連携用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaekouzano</td><td>（連携用）口座振替口座番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnoyabosyuudairitencd</td><td>（連携用）親募集代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsydrtenkanrisosikicd</td><td>（連携用）募集代理店管理組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuudairitengyousyukbn</td><td>（連携用）募集代理店業種区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuudrtennmkj</td><td>（連携用）募集代理店名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndoujitusyoricount</td><td>（連携用）同日処理回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjnkykhyj</td><td>（連携用）法人契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjnnmkj</td><td>（連携用）法人名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyuhrkkaisuukbn</td><td>（連携用）表示用主契約払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikbn</td><td>（連携用）一括払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikaisuu</td><td>（連携用）一括払回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv103</td><td>（連携用）予備項目Ｖ１０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenKykIdouDetailRn
 * @see     GenZT_DrtenKykIdouDetailRn
 * @see     QZT_DrtenKykIdouDetailRn
 * @see     GenQZT_DrtenKykIdouDetailRn
 */
public class PKZT_DrtenKykIdouDetailRn extends AbstractExDBPrimaryKey<ZT_DrtenKykIdouDetailRn, PKZT_DrtenKykIdouDetailRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DrtenKykIdouDetailRn() {
    }

    public PKZT_DrtenKykIdouDetailRn(
        String pZrnbsydrtencd,
        String pZrnbosyuunincd,
        String pZrnsyono,
        String pZrnidouhasseiymd,
        String pZrnidoukbn
    ) {
        zrnbsydrtencd = pZrnbsydrtencd;
        zrnbosyuunincd = pZrnbosyuunincd;
        zrnsyono = pZrnsyono;
        zrnidouhasseiymd = pZrnidouhasseiymd;
        zrnidoukbn = pZrnidoukbn;
    }

    @Transient
    @Override
    public Class<ZT_DrtenKykIdouDetailRn> getEntityClass() {
        return ZT_DrtenKykIdouDetailRn.class;
    }

    private String zrnbsydrtencd;

    public String getZrnbsydrtencd() {
        return zrnbsydrtencd;
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        zrnbsydrtencd = pZrnbsydrtencd;
    }
    private String zrnbosyuunincd;

    public String getZrnbosyuunincd() {
        return zrnbosyuunincd;
    }

    public void setZrnbosyuunincd(String pZrnbosyuunincd) {
        zrnbosyuunincd = pZrnbosyuunincd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnidouhasseiymd;

    public String getZrnidouhasseiymd() {
        return zrnidouhasseiymd;
    }

    public void setZrnidouhasseiymd(String pZrnidouhasseiymd) {
        zrnidouhasseiymd = pZrnidouhasseiymd;
    }
    private String zrnidoukbn;

    public String getZrnidoukbn() {
        return zrnidoukbn;
    }

    public void setZrnidoukbn(String pZrnidoukbn) {
        zrnidoukbn = pZrnidoukbn;
    }

}