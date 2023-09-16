package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.id.PKZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.meta.GenQZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.meta.QZT_SkKouhuriUkTrkkekkaRn;

/**
 * 新契約口振受付登録結果テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SkKouhuriUkTrkkekkaRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkKouhuriUkTrkkekkaRn}</td><td colspan="3">新契約口振受付登録結果テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyukkncd zrnsyukkncd}</td><td>（連携用）収納機関コード</td><td align="center">{@link PKZT_SkKouhuriUkTrkkekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkinyuukikancd8keta zrnkinyuukikancd8keta}</td><td>（連携用）金融機関コード（８桁）</td><td align="center">{@link PKZT_SkKouhuriUkTrkkekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordkbn zrnrecordkbn}</td><td>（連携用）レコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkinyuukkntratkiymd zrnkinyuukkntratkiymd}</td><td>（連携用）金融機関取扱年月日</td><td align="center">{@link PKZT_SkKouhuriUkTrkkekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkinyuukkntratkitime zrnkinyuukkntratkitime}</td><td>（連携用）金融機関取扱時刻</td><td align="center">{@link PKZT_SkKouhuriUkTrkkekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkinyuukkntratkino zrnkinyuukkntratkino}</td><td>（連携用）金融機関取扱番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouhuriukchannelkbn zrnkouhuriukchannelkbn}</td><td>（連携用）口振受付チャネル区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouhuriokyakusamano zrnkouhuriokyakusamano}</td><td>（連携用）口振お客様番号</td><td align="center">{@link PKZT_SkKouhuriUkTrkkekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouhuribankcd zrnkouhuribankcd}</td><td>（連携用）口振銀行コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouhurisitencd5keta zrnkouhurisitencd5keta}</td><td>（連携用）口振支店コード（５桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeyokinkbn zrnkzhurikaeyokinkbn}</td><td>（連携用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaekouzano8keta zrnkzhurikaekouzano8keta}</td><td>（連携用）口座振替口座番号（８桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzmeiginmei zrnkzmeiginmei}</td><td>（連携用）口座名義人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitakusyacd zrnitakusyacd}</td><td>（連携用）委託者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukkntratkiymd zrnsyukkntratkiymd}</td><td>（連携用）収納機関取扱年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukkntratkitime zrnsyukkntratkitime}</td><td>（連携用）収納機関取扱時刻</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukkntratkino zrnsyukkntratkino}</td><td>（連携用）収納機関取扱番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouhuristatuskbn zrnkouhuristatuskbn}</td><td>（連携用）口振ステータス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouhurikekkacd zrnkouhurikekkacd}</td><td>（連携用）口振処理結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouhurihonninkakkekka zrnkouhurihonninkakkekka}</td><td>（連携用）口振本人確認結果</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv207 zrnyobiv207}</td><td>（連携用）予備項目Ｖ２０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkKouhuriUkTrkkekkaRn
 * @see     PKZT_SkKouhuriUkTrkkekkaRn
 * @see     QZT_SkKouhuriUkTrkkekkaRn
 * @see     GenQZT_SkKouhuriUkTrkkekkaRn
 */
@MappedSuperclass
@Table(name=GenZT_SkKouhuriUkTrkkekkaRn.TABLE_NAME)
@IdClass(value=PKZT_SkKouhuriUkTrkkekkaRn.class)
public abstract class GenZT_SkKouhuriUkTrkkekkaRn extends AbstractExDBEntityForZDB<ZT_SkKouhuriUkTrkkekkaRn, PKZT_SkKouhuriUkTrkkekkaRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkKouhuriUkTrkkekkaRn";
    public static final String ZRNSYUKKNCD              = "zrnsyukkncd";
    public static final String ZRNKINYUUKIKANCD8KETA    = "zrnkinyuukikancd8keta";
    public static final String ZRNRECORDKBN             = "zrnrecordkbn";
    public static final String ZRNKINYUUKKNTRATKIYMD    = "zrnkinyuukkntratkiymd";
    public static final String ZRNKINYUUKKNTRATKITIME   = "zrnkinyuukkntratkitime";
    public static final String ZRNKINYUUKKNTRATKINO     = "zrnkinyuukkntratkino";
    public static final String ZRNKOUHURIUKCHANNELKBN   = "zrnkouhuriukchannelkbn";
    public static final String ZRNKOUHURIOKYAKUSAMANO   = "zrnkouhuriokyakusamano";
    public static final String ZRNKOUHURIBANKCD         = "zrnkouhuribankcd";
    public static final String ZRNKOUHURISITENCD5KETA   = "zrnkouhurisitencd5keta";
    public static final String ZRNKZHURIKAEYOKINKBN     = "zrnkzhurikaeyokinkbn";
    public static final String ZRNKZHURIKAEKOUZANO8KETA = "zrnkzhurikaekouzano8keta";
    public static final String ZRNKZMEIGINMEI           = "zrnkzmeiginmei";
    public static final String ZRNITAKUSYACD            = "zrnitakusyacd";
    public static final String ZRNSYUKKNTRATKIYMD       = "zrnsyukkntratkiymd";
    public static final String ZRNSYUKKNTRATKITIME      = "zrnsyukkntratkitime";
    public static final String ZRNSYUKKNTRATKINO        = "zrnsyukkntratkino";
    public static final String ZRNKOUHURISTATUSKBN      = "zrnkouhuristatuskbn";
    public static final String ZRNKOUHURIKEKKACD        = "zrnkouhurikekkacd";
    public static final String ZRNKOUHURIHONNINKAKKEKKA = "zrnkouhurihonninkakkekka";
    public static final String ZRNYOBIV207              = "zrnyobiv207";

    private final PKZT_SkKouhuriUkTrkkekkaRn primaryKey;

    public GenZT_SkKouhuriUkTrkkekkaRn() {
        primaryKey = new PKZT_SkKouhuriUkTrkkekkaRn();
    }

    public GenZT_SkKouhuriUkTrkkekkaRn(
        String pZrnsyukkncd,
        String pZrnkinyuukikancd8keta,
        String pZrnkinyuukkntratkiymd,
        String pZrnkinyuukkntratkitime,
        String pZrnkouhuriokyakusamano
    ) {
        primaryKey = new PKZT_SkKouhuriUkTrkkekkaRn(
            pZrnsyukkncd,
            pZrnkinyuukikancd8keta,
            pZrnkinyuukkntratkiymd,
            pZrnkinyuukkntratkitime,
            pZrnkouhuriokyakusamano
        );
    }

    @Transient
    @Override
    public PKZT_SkKouhuriUkTrkkekkaRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkKouhuriUkTrkkekkaRn> getMetaClass() {
        return QZT_SkKouhuriUkTrkkekkaRn.class;
    }

    @Id
    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNSYUKKNCD)
    public String getZrnsyukkncd() {
        return getPrimaryKey().getZrnsyukkncd();
    }

    public void setZrnsyukkncd(String pZrnsyukkncd) {
        getPrimaryKey().setZrnsyukkncd(pZrnsyukkncd);
    }

    @Id
    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKINYUUKIKANCD8KETA)
    public String getZrnkinyuukikancd8keta() {
        return getPrimaryKey().getZrnkinyuukikancd8keta();
    }

    public void setZrnkinyuukikancd8keta(String pZrnkinyuukikancd8keta) {
        getPrimaryKey().setZrnkinyuukikancd8keta(pZrnkinyuukikancd8keta);
    }

    private String zrnrecordkbn;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNRECORDKBN)
    public String getZrnrecordkbn() {
        return zrnrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrecordkbn(String pZrnrecordkbn) {
        zrnrecordkbn = pZrnrecordkbn;
    }

    @Id
    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKINYUUKKNTRATKIYMD)
    public String getZrnkinyuukkntratkiymd() {
        return getPrimaryKey().getZrnkinyuukkntratkiymd();
    }

    public void setZrnkinyuukkntratkiymd(String pZrnkinyuukkntratkiymd) {
        getPrimaryKey().setZrnkinyuukkntratkiymd(pZrnkinyuukkntratkiymd);
    }

    @Id
    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKINYUUKKNTRATKITIME)
    public String getZrnkinyuukkntratkitime() {
        return getPrimaryKey().getZrnkinyuukkntratkitime();
    }

    public void setZrnkinyuukkntratkitime(String pZrnkinyuukkntratkitime) {
        getPrimaryKey().setZrnkinyuukkntratkitime(pZrnkinyuukkntratkitime);
    }

    private String zrnkinyuukkntratkino;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKINYUUKKNTRATKINO)
    public String getZrnkinyuukkntratkino() {
        return zrnkinyuukkntratkino;
    }

    public void setZrnkinyuukkntratkino(String pZrnkinyuukkntratkino) {
        zrnkinyuukkntratkino = pZrnkinyuukkntratkino;
    }

    private String zrnkouhuriukchannelkbn;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKOUHURIUKCHANNELKBN)
    public String getZrnkouhuriukchannelkbn() {
        return zrnkouhuriukchannelkbn;
    }

    public void setZrnkouhuriukchannelkbn(String pZrnkouhuriukchannelkbn) {
        zrnkouhuriukchannelkbn = pZrnkouhuriukchannelkbn;
    }

    @Id
    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKOUHURIOKYAKUSAMANO)
    public String getZrnkouhuriokyakusamano() {
        return getPrimaryKey().getZrnkouhuriokyakusamano();
    }

    public void setZrnkouhuriokyakusamano(String pZrnkouhuriokyakusamano) {
        getPrimaryKey().setZrnkouhuriokyakusamano(pZrnkouhuriokyakusamano);
    }

    private String zrnkouhuribankcd;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKOUHURIBANKCD)
    public String getZrnkouhuribankcd() {
        return zrnkouhuribankcd;
    }

    public void setZrnkouhuribankcd(String pZrnkouhuribankcd) {
        zrnkouhuribankcd = pZrnkouhuribankcd;
    }

    private String zrnkouhurisitencd5keta;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKOUHURISITENCD5KETA)
    public String getZrnkouhurisitencd5keta() {
        return zrnkouhurisitencd5keta;
    }

    public void setZrnkouhurisitencd5keta(String pZrnkouhurisitencd5keta) {
        zrnkouhurisitencd5keta = pZrnkouhurisitencd5keta;
    }

    private String zrnkzhurikaeyokinkbn;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKZHURIKAEYOKINKBN)
    public String getZrnkzhurikaeyokinkbn() {
        return zrnkzhurikaeyokinkbn;
    }

    public void setZrnkzhurikaeyokinkbn(String pZrnkzhurikaeyokinkbn) {
        zrnkzhurikaeyokinkbn = pZrnkzhurikaeyokinkbn;
    }

    private String zrnkzhurikaekouzano8keta;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKZHURIKAEKOUZANO8KETA)
    public String getZrnkzhurikaekouzano8keta() {
        return zrnkzhurikaekouzano8keta;
    }

    public void setZrnkzhurikaekouzano8keta(String pZrnkzhurikaekouzano8keta) {
        zrnkzhurikaekouzano8keta = pZrnkzhurikaekouzano8keta;
    }

    private String zrnkzmeiginmei;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKZMEIGINMEI)
    public String getZrnkzmeiginmei() {
        return zrnkzmeiginmei;
    }

    @DataConvert("toSingleByte")
    public void setZrnkzmeiginmei(String pZrnkzmeiginmei) {
        zrnkzmeiginmei = pZrnkzmeiginmei;
    }

    private String zrnitakusyacd;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNITAKUSYACD)
    public String getZrnitakusyacd() {
        return zrnitakusyacd;
    }

    public void setZrnitakusyacd(String pZrnitakusyacd) {
        zrnitakusyacd = pZrnitakusyacd;
    }

    private String zrnsyukkntratkiymd;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNSYUKKNTRATKIYMD)
    public String getZrnsyukkntratkiymd() {
        return zrnsyukkntratkiymd;
    }

    public void setZrnsyukkntratkiymd(String pZrnsyukkntratkiymd) {
        zrnsyukkntratkiymd = pZrnsyukkntratkiymd;
    }

    private String zrnsyukkntratkitime;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNSYUKKNTRATKITIME)
    public String getZrnsyukkntratkitime() {
        return zrnsyukkntratkitime;
    }

    public void setZrnsyukkntratkitime(String pZrnsyukkntratkitime) {
        zrnsyukkntratkitime = pZrnsyukkntratkitime;
    }

    private String zrnsyukkntratkino;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNSYUKKNTRATKINO)
    public String getZrnsyukkntratkino() {
        return zrnsyukkntratkino;
    }

    public void setZrnsyukkntratkino(String pZrnsyukkntratkino) {
        zrnsyukkntratkino = pZrnsyukkntratkino;
    }

    private String zrnkouhuristatuskbn;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKOUHURISTATUSKBN)
    public String getZrnkouhuristatuskbn() {
        return zrnkouhuristatuskbn;
    }

    public void setZrnkouhuristatuskbn(String pZrnkouhuristatuskbn) {
        zrnkouhuristatuskbn = pZrnkouhuristatuskbn;
    }

    private String zrnkouhurikekkacd;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKOUHURIKEKKACD)
    public String getZrnkouhurikekkacd() {
        return zrnkouhurikekkacd;
    }

    public void setZrnkouhurikekkacd(String pZrnkouhurikekkacd) {
        zrnkouhurikekkacd = pZrnkouhurikekkacd;
    }

    private String zrnkouhurihonninkakkekka;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNKOUHURIHONNINKAKKEKKA)
    public String getZrnkouhurihonninkakkekka() {
        return zrnkouhurihonninkakkekka;
    }

    public void setZrnkouhurihonninkakkekka(String pZrnkouhurihonninkakkekka) {
        zrnkouhurihonninkakkekka = pZrnkouhurihonninkakkekka;
    }

    private String zrnyobiv207;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaRn.ZRNYOBIV207)
    public String getZrnyobiv207() {
        return zrnyobiv207;
    }

    public void setZrnyobiv207(String pZrnyobiv207) {
        zrnyobiv207 = pZrnyobiv207;
    }
}