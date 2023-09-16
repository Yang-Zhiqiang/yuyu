package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KinyuuKikanInfoRn;
import yuyu.def.db.mapping.GenZT_KinyuuKikanInfoRn;
import yuyu.def.db.meta.GenQZT_KinyuuKikanInfoRn;
import yuyu.def.db.meta.QZT_KinyuuKikanInfoRn;

/**
 * 金融機関情報連動ファイルテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KinyuuKikanInfoRn}</td><td colspan="3">金融機関情報連動ファイルテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkinyuukikancd zrnkinyuukikancd}</td><td>（連携用）金融機関コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsitencd zrnsitencd}</td><td>（連携用）支店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenpokbn</td><td>（連携用）店舗区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkousinymd</td><td>（連携用）更新年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsinsetuymd</td><td>（連携用）新設年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhaisiymd</td><td>（連携用）廃止年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanakinyuukikannm</td><td>（連携用）カナ金融機関名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanasitennm</td><td>（連携用）カナ支店名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjikinyuukikannm</td><td>（連携用）漢字金融機関名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkanjisitennm</td><td>（連携用）漢字支店名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrneijikinyuukikannm</td><td>（連携用）英字金融機関名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrneijisitennm</td><td>（連携用）英字支店名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncsskyouteikaisiymd</td><td>（連携用）ＣＳＳ協定開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncsskyouteikaijyoymd</td><td>（連携用）ＣＳＳ協定解除年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkokunaikawasehyouji</td><td>（連携用）内国為替制度加盟表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhurikomikanousitenhyouji</td><td>（連携用）振込可能支店表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngyoutaikbn</td><td>（連携用）業態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyofurikyouteikaisiymd</td><td>（連携用）預振協定開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyofurikyouteikaijyoymd</td><td>（連携用）預振協定解除年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitakusyakinyuucd</td><td>（連携用）委託者金融機関コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitakusyasitencd</td><td>（連携用）委託者支店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitakusyayokinkbn</td><td>（連携用）委託者預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitakusyakouzano</td><td>（連携用）委託者口座番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsrkeisanhoukbn</td><td>（連携用）手数料計算方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkinyuutesuuryou</td><td>（連携用）手数料</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnitakusyacd</td><td>（連携用）委託者コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntapekoukankbn1</td><td>（連携用）テープ交換区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmdsisyacd</td><td>（連携用）窓口支社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzzkkyouteikaisiymd</td><td>（連携用）全税共協定開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzzkkyouteikaijyoymd</td><td>（連携用）全税共協定解除年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhuhoyofuriinfokousinymd</td><td>（連携用）普保預振情報更新年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv17</td><td>（連携用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KinyuuKikanInfoRn
 * @see     GenZT_KinyuuKikanInfoRn
 * @see     QZT_KinyuuKikanInfoRn
 * @see     GenQZT_KinyuuKikanInfoRn
 */
public class PKZT_KinyuuKikanInfoRn extends AbstractExDBPrimaryKey<ZT_KinyuuKikanInfoRn, PKZT_KinyuuKikanInfoRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KinyuuKikanInfoRn() {
    }

    public PKZT_KinyuuKikanInfoRn(String pZrnkinyuukikancd, String pZrnsitencd) {
        zrnkinyuukikancd = pZrnkinyuukikancd;
        zrnsitencd = pZrnsitencd;
    }

    @Transient
    @Override
    public Class<ZT_KinyuuKikanInfoRn> getEntityClass() {
        return ZT_KinyuuKikanInfoRn.class;
    }

    private String zrnkinyuukikancd;

    public String getZrnkinyuukikancd() {
        return zrnkinyuukikancd;
    }

    public void setZrnkinyuukikancd(String pZrnkinyuukikancd) {
        zrnkinyuukikancd = pZrnkinyuukikancd;
    }
    private String zrnsitencd;

    public String getZrnsitencd() {
        return zrnsitencd;
    }

    public void setZrnsitencd(String pZrnsitencd) {
        zrnsitencd = pZrnsitencd;
    }

}