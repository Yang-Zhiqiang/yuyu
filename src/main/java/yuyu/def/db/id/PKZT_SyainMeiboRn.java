package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SyainMeiboRn;
import yuyu.def.db.mapping.GenZT_SyainMeiboRn;
import yuyu.def.db.meta.GenQZT_SyainMeiboRn;
import yuyu.def.db.meta.QZT_SyainMeiboRn;

/**
 * 社員名簿Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyainMeiboRn}</td><td colspan="3">社員名簿Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnhokenkbn</td><td>（連携用）保険区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyainmeibokbn</td><td>（連携用）社員名簿用区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaskinmeino</td><td>（連携用）契約者索引名番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyainnm</td><td>（連携用）社員名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjisyainnm</td><td>（連携用）漢字社員名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyainseiymd</td><td>（連携用）社員生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsinkihontikucd</td><td>（連携用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjitsinkaiadr</td><td>（連携用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntksyuannaikykkbn</td><td>（連携用）特殊案内契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsouhuhunoukbn</td><td>（連携用）送付不能区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyainmeibos</td><td>（連携用）社員名簿用Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyainmeibop</td><td>（連携用）社員名簿用Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyainmeibosyouyop</td><td>（連携用）社員名簿用賞与払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyofuritysytzumihyouji</td><td>（連携用）預振抽出済表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnayosekihontikucd</td><td>（連携用）名寄せ用基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10</td><td>（連携用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyainMeiboRn
 * @see     GenZT_SyainMeiboRn
 * @see     QZT_SyainMeiboRn
 * @see     GenQZT_SyainMeiboRn
 */
public class PKZT_SyainMeiboRn extends AbstractExDBPrimaryKey<ZT_SyainMeiboRn, PKZT_SyainMeiboRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SyainMeiboRn() {
    }

    public PKZT_SyainMeiboRn(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_SyainMeiboRn> getEntityClass() {
        return ZT_SyainMeiboRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}