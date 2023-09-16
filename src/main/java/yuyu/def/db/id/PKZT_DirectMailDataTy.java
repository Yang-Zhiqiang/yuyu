package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DirectMailDataTy;
import yuyu.def.db.mapping.GenZT_DirectMailDataTy;
import yuyu.def.db.meta.GenQZT_DirectMailDataTy;
import yuyu.def.db.meta.QZT_DirectMailDataTy;

/**
 * ダイレクトメールデータテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DirectMailDataTy}</td><td colspan="3">ダイレクトメールデータテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztyhokenkbnnys</td><td>（中継用）保険区分（名寄せ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuinmeinonys</td><td>（中継用）索引名番号（名寄せ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyainnm</td><td>（中継用）社員名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyainseiymd</td><td>（中継用）社員生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjisyainnm</td><td>（中継用）漢字社員名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsinkihontikucd</td><td>（中継用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaimitureigaihyj</td><td>（中継用）内密例外表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydrtenhyj</td><td>（中継用）代理店表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjitsinkaiadr</td><td>（中継用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysouhuhunoukbn</td><td>（中継用）送付不能区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknnm</td><td>（中継用）保険名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenhousiki</td><td>（中継用）年齢方式</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktrkarihyj</td><td>（中継用）ご家族登録有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatkioybsydrtencd</td><td>（中継用）Ａ扱者親募集代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybatkioybsydrtencd</td><td>（中継用）Ｂ扱者親募集代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x1</td><td>（中継用）予備項目Ｖ２５０＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x2</td><td>（中継用）予備項目Ｖ２５０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x3</td><td>（中継用）予備項目Ｖ２５０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x4</td><td>（中継用）予備項目Ｖ２５０＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x5</td><td>（中継用）予備項目Ｖ２５０＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x6</td><td>（中継用）予備項目Ｖ２５０＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x7</td><td>（中継用）予備項目Ｖ２５０＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x8</td><td>（中継用）予備項目Ｖ２５０＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x9</td><td>（中継用）予備項目Ｖ２５０＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x10</td><td>（中継用）予備項目Ｖ２５０＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x11</td><td>（中継用）予備項目Ｖ２５０＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x12</td><td>（中継用）予備項目Ｖ２５０＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x13</td><td>（中継用）予備項目Ｖ２５０＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x14</td><td>（中継用）予備項目Ｖ２５０＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv122</td><td>（中継用）予備項目Ｖ１２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DirectMailDataTy
 * @see     GenZT_DirectMailDataTy
 * @see     QZT_DirectMailDataTy
 * @see     GenQZT_DirectMailDataTy
 */
public class PKZT_DirectMailDataTy extends AbstractExDBPrimaryKey<ZT_DirectMailDataTy, PKZT_DirectMailDataTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DirectMailDataTy() {
    }

    public PKZT_DirectMailDataTy(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_DirectMailDataTy> getEntityClass() {
        return ZT_DirectMailDataTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}