package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.mapping.GenZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.meta.GenQZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.meta.QZT_SkKouhuriUkTrkkekkaTr;

/**
 * 新契約口振受付登録結果テーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkKouhuriUkTrkkekkaTr}</td><td colspan="3">新契約口振受付登録結果テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsyukkncd ztrsyukkncd}</td><td>（取込用）収納機関コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrkinyuukikancd8keta ztrkinyuukikancd8keta}</td><td>（取込用）金融機関コード（８桁）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrrecordkbn</td><td>（取込用）レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrkinyuukkntratkiymd ztrkinyuukkntratkiymd}</td><td>（取込用）金融機関取扱年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrkinyuukkntratkitime ztrkinyuukkntratkitime}</td><td>（取込用）金融機関取扱時刻</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkinyuukkntratkino</td><td>（取込用）金融機関取扱番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkouhuriukchannelkbn</td><td>（取込用）口振受付チャネル区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrkouhuriokyakusamano ztrkouhuriokyakusamano}</td><td>（取込用）口振お客様番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkouhuribankcd</td><td>（取込用）口振銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkouhurisitencd5keta</td><td>（取込用）口振支店コード（５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkzhurikaeyokinkbn</td><td>（取込用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkzhurikaekouzano8keta</td><td>（取込用）口座振替口座番号（８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkzmeiginmei</td><td>（取込用）口座名義人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztritakusyacd</td><td>（取込用）委託者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyukkntratkiymd</td><td>（取込用）収納機関取扱年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyukkntratkitime</td><td>（取込用）収納機関取扱時刻</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyukkntratkino</td><td>（取込用）収納機関取扱番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkouhuristatuskbn</td><td>（取込用）口振ステータス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkouhurikekkacd</td><td>（取込用）口振処理結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkouhurihonninkakkekka</td><td>（取込用）口振本人確認結果</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv207</td><td>（取込用）予備項目Ｖ２０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkKouhuriUkTrkkekkaTr
 * @see     GenZT_SkKouhuriUkTrkkekkaTr
 * @see     QZT_SkKouhuriUkTrkkekkaTr
 * @see     GenQZT_SkKouhuriUkTrkkekkaTr
 */
public class PKZT_SkKouhuriUkTrkkekkaTr extends AbstractExDBPrimaryKey<ZT_SkKouhuriUkTrkkekkaTr, PKZT_SkKouhuriUkTrkkekkaTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_SkKouhuriUkTrkkekkaTr() {
    }

    public PKZT_SkKouhuriUkTrkkekkaTr(
        String pZtrsyukkncd,
        String pZtrkinyuukikancd8keta,
        String pZtrkinyuukkntratkiymd,
        String pZtrkinyuukkntratkitime,
        String pZtrkouhuriokyakusamano
    ) {
        ztrsyukkncd = pZtrsyukkncd;
        ztrkinyuukikancd8keta = pZtrkinyuukikancd8keta;
        ztrkinyuukkntratkiymd = pZtrkinyuukkntratkiymd;
        ztrkinyuukkntratkitime = pZtrkinyuukkntratkitime;
        ztrkouhuriokyakusamano = pZtrkouhuriokyakusamano;
    }

    @Transient
    @Override
    public Class<ZT_SkKouhuriUkTrkkekkaTr> getEntityClass() {
        return ZT_SkKouhuriUkTrkkekkaTr.class;
    }

    private String ztrsyukkncd;

    public String getZtrsyukkncd() {
        return ztrsyukkncd;
    }

    public void setZtrsyukkncd(String pZtrsyukkncd) {
        ztrsyukkncd = pZtrsyukkncd;
    }
    private String ztrkinyuukikancd8keta;

    public String getZtrkinyuukikancd8keta() {
        return ztrkinyuukikancd8keta;
    }

    public void setZtrkinyuukikancd8keta(String pZtrkinyuukikancd8keta) {
        ztrkinyuukikancd8keta = pZtrkinyuukikancd8keta;
    }
    private String ztrkinyuukkntratkiymd;

    public String getZtrkinyuukkntratkiymd() {
        return ztrkinyuukkntratkiymd;
    }

    public void setZtrkinyuukkntratkiymd(String pZtrkinyuukkntratkiymd) {
        ztrkinyuukkntratkiymd = pZtrkinyuukkntratkiymd;
    }
    private String ztrkinyuukkntratkitime;

    public String getZtrkinyuukkntratkitime() {
        return ztrkinyuukkntratkitime;
    }

    public void setZtrkinyuukkntratkitime(String pZtrkinyuukkntratkitime) {
        ztrkinyuukkntratkitime = pZtrkinyuukkntratkitime;
    }
    private String ztrkouhuriokyakusamano;

    public String getZtrkouhuriokyakusamano() {
        return ztrkouhuriokyakusamano;
    }

    public void setZtrkouhuriokyakusamano(String pZtrkouhuriokyakusamano) {
        ztrkouhuriokyakusamano = pZtrkouhuriokyakusamano;
    }

}