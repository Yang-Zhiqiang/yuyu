package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.mapping.GenZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.meta.GenQZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.meta.QZT_SkKouhuriUkTrkkekkaRn;

/**
 * 新契約口振受付登録結果テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkKouhuriUkTrkkekkaRn}</td><td colspan="3">新契約口振受付登録結果テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyukkncd zrnsyukkncd}</td><td>（連携用）収納機関コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkinyuukikancd8keta zrnkinyuukikancd8keta}</td><td>（連携用）金融機関コード（８桁）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrecordkbn</td><td>（連携用）レコード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkinyuukkntratkiymd zrnkinyuukkntratkiymd}</td><td>（連携用）金融機関取扱年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkinyuukkntratkitime zrnkinyuukkntratkitime}</td><td>（連携用）金融機関取扱時刻</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkinyuukkntratkino</td><td>（連携用）金融機関取扱番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouhuriukchannelkbn</td><td>（連携用）口振受付チャネル区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkouhuriokyakusamano zrnkouhuriokyakusamano}</td><td>（連携用）口振お客様番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouhuribankcd</td><td>（連携用）口振銀行コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouhurisitencd5keta</td><td>（連携用）口振支店コード（５桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeyokinkbn</td><td>（連携用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaekouzano8keta</td><td>（連携用）口座振替口座番号（８桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzmeiginmei</td><td>（連携用）口座名義人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitakusyacd</td><td>（連携用）委託者コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukkntratkiymd</td><td>（連携用）収納機関取扱年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukkntratkitime</td><td>（連携用）収納機関取扱時刻</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukkntratkino</td><td>（連携用）収納機関取扱番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouhuristatuskbn</td><td>（連携用）口振ステータス区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouhurikekkacd</td><td>（連携用）口振処理結果コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouhurihonninkakkekka</td><td>（連携用）口振本人確認結果</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv207</td><td>（連携用）予備項目Ｖ２０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkKouhuriUkTrkkekkaRn
 * @see     GenZT_SkKouhuriUkTrkkekkaRn
 * @see     QZT_SkKouhuriUkTrkkekkaRn
 * @see     GenQZT_SkKouhuriUkTrkkekkaRn
 */
public class PKZT_SkKouhuriUkTrkkekkaRn extends AbstractExDBPrimaryKey<ZT_SkKouhuriUkTrkkekkaRn, PKZT_SkKouhuriUkTrkkekkaRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SkKouhuriUkTrkkekkaRn() {
    }

    public PKZT_SkKouhuriUkTrkkekkaRn(
        String pZrnsyukkncd,
        String pZrnkinyuukikancd8keta,
        String pZrnkinyuukkntratkiymd,
        String pZrnkinyuukkntratkitime,
        String pZrnkouhuriokyakusamano
    ) {
        zrnsyukkncd = pZrnsyukkncd;
        zrnkinyuukikancd8keta = pZrnkinyuukikancd8keta;
        zrnkinyuukkntratkiymd = pZrnkinyuukkntratkiymd;
        zrnkinyuukkntratkitime = pZrnkinyuukkntratkitime;
        zrnkouhuriokyakusamano = pZrnkouhuriokyakusamano;
    }

    @Transient
    @Override
    public Class<ZT_SkKouhuriUkTrkkekkaRn> getEntityClass() {
        return ZT_SkKouhuriUkTrkkekkaRn.class;
    }

    private String zrnsyukkncd;

    public String getZrnsyukkncd() {
        return zrnsyukkncd;
    }

    public void setZrnsyukkncd(String pZrnsyukkncd) {
        zrnsyukkncd = pZrnsyukkncd;
    }
    private String zrnkinyuukikancd8keta;

    public String getZrnkinyuukikancd8keta() {
        return zrnkinyuukikancd8keta;
    }

    public void setZrnkinyuukikancd8keta(String pZrnkinyuukikancd8keta) {
        zrnkinyuukikancd8keta = pZrnkinyuukikancd8keta;
    }
    private String zrnkinyuukkntratkiymd;

    public String getZrnkinyuukkntratkiymd() {
        return zrnkinyuukkntratkiymd;
    }

    public void setZrnkinyuukkntratkiymd(String pZrnkinyuukkntratkiymd) {
        zrnkinyuukkntratkiymd = pZrnkinyuukkntratkiymd;
    }
    private String zrnkinyuukkntratkitime;

    public String getZrnkinyuukkntratkitime() {
        return zrnkinyuukkntratkitime;
    }

    public void setZrnkinyuukkntratkitime(String pZrnkinyuukkntratkitime) {
        zrnkinyuukkntratkitime = pZrnkinyuukkntratkitime;
    }
    private String zrnkouhuriokyakusamano;

    public String getZrnkouhuriokyakusamano() {
        return zrnkouhuriokyakusamano;
    }

    public void setZrnkouhuriokyakusamano(String pZrnkouhuriokyakusamano) {
        zrnkouhuriokyakusamano = pZrnkouhuriokyakusamano;
    }

}