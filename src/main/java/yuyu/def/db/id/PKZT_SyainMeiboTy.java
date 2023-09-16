package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SyainMeiboTy;
import yuyu.def.db.mapping.GenZT_SyainMeiboTy;
import yuyu.def.db.meta.GenQZT_SyainMeiboTy;
import yuyu.def.db.meta.QZT_SyainMeiboTy;

/**
 * 社員名簿Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyainMeiboTy}</td><td colspan="3">社員名簿Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztyhokenkbn</td><td>（中継用）保険区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyainmeibokbn</td><td>（中継用）社員名簿用区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaskinmeino</td><td>（中継用）契約者索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyainnm</td><td>（中継用）社員名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjisyainnm</td><td>（中継用）漢字社員名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyainseiymd</td><td>（中継用）社員生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsinkihontikucd</td><td>（中継用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjitsinkaiadr</td><td>（中継用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksyuannaikykkbn</td><td>（中継用）特殊案内契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysouhuhunoukbn</td><td>（中継用）送付不能区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyainmeibos</td><td>（中継用）社員名簿用Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyainmeibop</td><td>（中継用）社員名簿用Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyainmeibosyouyop</td><td>（中継用）社員名簿用賞与払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyofuritysytzumihyouji</td><td>（中継用）預振抽出済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynayosekihontikucd</td><td>（中継用）名寄せ用基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10</td><td>（中継用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyainMeiboTy
 * @see     GenZT_SyainMeiboTy
 * @see     QZT_SyainMeiboTy
 * @see     GenQZT_SyainMeiboTy
 */
public class PKZT_SyainMeiboTy extends AbstractExDBPrimaryKey<ZT_SyainMeiboTy, PKZT_SyainMeiboTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SyainMeiboTy() {
    }

    public PKZT_SyainMeiboTy(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_SyainMeiboTy> getEntityClass() {
        return ZT_SyainMeiboTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}