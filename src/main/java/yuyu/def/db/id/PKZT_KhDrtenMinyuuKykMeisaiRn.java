package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.db.mapping.GenZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.db.meta.GenQZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.db.meta.QZT_KhDrtenMinyuuKykMeisaiRn;

/**
 * 代理店未入契約明細テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KhDrtenMinyuuKykMeisaiRn}</td><td colspan="3">代理店未入契約明細テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunincd</td><td>（連携用）募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpjyuutouyymmwareki4keta</td><td>（連携用）保険料充当年月（和暦）（４桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncifcd</td><td>（連携用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuudrtennmkj</td><td>（連携用）募集代理店名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuujyutuymd</td><td>（連携用）未入充当年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassinka</td><td>（連携用）発信課</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtnbsyunnmisyou</td><td>（連携用）代理店募集人名称（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkydatkikbn</td><td>（連携用）共同扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkj35</td><td>（連携用）契約者名（漢字）（３５桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkgk</td><td>（連携用）払込額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnknkimnyuuryu</td><td>（連携用）今回未入理由</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuuningyouhaiymd</td><td>（連携用）募集人業廃年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaebankcd</td><td>（連携用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaesitencd</td><td>（連携用）口座振替支店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeyokinkbn</td><td>（連携用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaekouzano</td><td>（連携用）口座振替口座番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknyukknmei</td><td>（連携用）金融機関名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknyykknstnmei</td><td>（連携用）金融機関支店名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndantaicd</td><td>（連携用）団体コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjdntnm</td><td>（連携用）漢字団体名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruimei</td><td>（連携用）保険種類名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbkofccd</td><td>（連携用）バックオフィスコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjnkykhyj</td><td>（連携用）法人契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KhDrtenMinyuuKykMeisaiRn
 * @see     GenZT_KhDrtenMinyuuKykMeisaiRn
 * @see     QZT_KhDrtenMinyuuKykMeisaiRn
 * @see     GenQZT_KhDrtenMinyuuKykMeisaiRn
 */
public class PKZT_KhDrtenMinyuuKykMeisaiRn extends AbstractExDBPrimaryKey<ZT_KhDrtenMinyuuKykMeisaiRn, PKZT_KhDrtenMinyuuKykMeisaiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KhDrtenMinyuuKykMeisaiRn() {
    }

    public PKZT_KhDrtenMinyuuKykMeisaiRn(
        String pZrnsyoriymd,
        String pZrnbsydrtencd,
        String pZrnsyono
    ) {
        zrnsyoriymd = pZrnsyoriymd;
        zrnbsydrtencd = pZrnbsydrtencd;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_KhDrtenMinyuuKykMeisaiRn> getEntityClass() {
        return ZT_KhDrtenMinyuuKykMeisaiRn.class;
    }

    private String zrnsyoriymd;

    public String getZrnsyoriymd() {
        return zrnsyoriymd;
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        zrnsyoriymd = pZrnsyoriymd;
    }
    private String zrnbsydrtencd;

    public String getZrnbsydrtencd() {
        return zrnbsydrtencd;
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        zrnbsydrtencd = pZrnbsydrtencd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}