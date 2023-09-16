package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.id.PKZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.meta.GenQZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.meta.QZT_SkKouhuriUkTrkkekkaTr;

/**
 * 新契約口振受付登録結果テーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_SkKouhuriUkTrkkekkaTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkKouhuriUkTrkkekkaTr}</td><td colspan="3">新契約口振受付登録結果テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrsyukkncd ztrsyukkncd}</td><td>（取込用）収納機関コード</td><td align="center">{@link PKZT_SkKouhuriUkTrkkekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkinyuukikancd8keta ztrkinyuukikancd8keta}</td><td>（取込用）金融機関コード（８桁）</td><td align="center">{@link PKZT_SkKouhuriUkTrkkekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrecordkbn ztrrecordkbn}</td><td>（取込用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkinyuukkntratkiymd ztrkinyuukkntratkiymd}</td><td>（取込用）金融機関取扱年月日</td><td align="center">{@link PKZT_SkKouhuriUkTrkkekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkinyuukkntratkitime ztrkinyuukkntratkitime}</td><td>（取込用）金融機関取扱時刻</td><td align="center">{@link PKZT_SkKouhuriUkTrkkekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkinyuukkntratkino ztrkinyuukkntratkino}</td><td>（取込用）金融機関取扱番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkouhuriukchannelkbn ztrkouhuriukchannelkbn}</td><td>（取込用）口振受付チャネル区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkouhuriokyakusamano ztrkouhuriokyakusamano}</td><td>（取込用）口振お客様番号</td><td align="center">{@link PKZT_SkKouhuriUkTrkkekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkouhuribankcd ztrkouhuribankcd}</td><td>（取込用）口振銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkouhurisitencd5keta ztrkouhurisitencd5keta}</td><td>（取込用）口振支店コード（５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkzhurikaeyokinkbn ztrkzhurikaeyokinkbn}</td><td>（取込用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkzhurikaekouzano8keta ztrkzhurikaekouzano8keta}</td><td>（取込用）口座振替口座番号（８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkzmeiginmei ztrkzmeiginmei}</td><td>（取込用）口座名義人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtritakusyacd ztritakusyacd}</td><td>（取込用）委託者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyukkntratkiymd ztrsyukkntratkiymd}</td><td>（取込用）収納機関取扱年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyukkntratkitime ztrsyukkntratkitime}</td><td>（取込用）収納機関取扱時刻</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyukkntratkino ztrsyukkntratkino}</td><td>（取込用）収納機関取扱番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkouhuristatuskbn ztrkouhuristatuskbn}</td><td>（取込用）口振ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkouhurikekkacd ztrkouhurikekkacd}</td><td>（取込用）口振処理結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkouhurihonninkakkekka ztrkouhurihonninkakkekka}</td><td>（取込用）口振本人確認結果</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv207 ztryobiv207}</td><td>（取込用）予備項目Ｖ２０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkKouhuriUkTrkkekkaTr
 * @see     PKZT_SkKouhuriUkTrkkekkaTr
 * @see     QZT_SkKouhuriUkTrkkekkaTr
 * @see     GenQZT_SkKouhuriUkTrkkekkaTr
 */
@MappedSuperclass
@Table(name=GenZT_SkKouhuriUkTrkkekkaTr.TABLE_NAME)
@IdClass(value=PKZT_SkKouhuriUkTrkkekkaTr.class)
public abstract class GenZT_SkKouhuriUkTrkkekkaTr extends AbstractExDBEntity<ZT_SkKouhuriUkTrkkekkaTr, PKZT_SkKouhuriUkTrkkekkaTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkKouhuriUkTrkkekkaTr";
    public static final String ZTRSYUKKNCD              = "ztrsyukkncd";
    public static final String ZTRKINYUUKIKANCD8KETA    = "ztrkinyuukikancd8keta";
    public static final String ZTRRECORDKBN             = "ztrrecordkbn";
    public static final String ZTRKINYUUKKNTRATKIYMD    = "ztrkinyuukkntratkiymd";
    public static final String ZTRKINYUUKKNTRATKITIME   = "ztrkinyuukkntratkitime";
    public static final String ZTRKINYUUKKNTRATKINO     = "ztrkinyuukkntratkino";
    public static final String ZTRKOUHURIUKCHANNELKBN   = "ztrkouhuriukchannelkbn";
    public static final String ZTRKOUHURIOKYAKUSAMANO   = "ztrkouhuriokyakusamano";
    public static final String ZTRKOUHURIBANKCD         = "ztrkouhuribankcd";
    public static final String ZTRKOUHURISITENCD5KETA   = "ztrkouhurisitencd5keta";
    public static final String ZTRKZHURIKAEYOKINKBN     = "ztrkzhurikaeyokinkbn";
    public static final String ZTRKZHURIKAEKOUZANO8KETA = "ztrkzhurikaekouzano8keta";
    public static final String ZTRKZMEIGINMEI           = "ztrkzmeiginmei";
    public static final String ZTRITAKUSYACD            = "ztritakusyacd";
    public static final String ZTRSYUKKNTRATKIYMD       = "ztrsyukkntratkiymd";
    public static final String ZTRSYUKKNTRATKITIME      = "ztrsyukkntratkitime";
    public static final String ZTRSYUKKNTRATKINO        = "ztrsyukkntratkino";
    public static final String ZTRKOUHURISTATUSKBN      = "ztrkouhuristatuskbn";
    public static final String ZTRKOUHURIKEKKACD        = "ztrkouhurikekkacd";
    public static final String ZTRKOUHURIHONNINKAKKEKKA = "ztrkouhurihonninkakkekka";
    public static final String ZTRYOBIV207              = "ztryobiv207";

    private final PKZT_SkKouhuriUkTrkkekkaTr primaryKey;

    public GenZT_SkKouhuriUkTrkkekkaTr() {
        primaryKey = new PKZT_SkKouhuriUkTrkkekkaTr();
    }

    public GenZT_SkKouhuriUkTrkkekkaTr(
        String pZtrsyukkncd,
        String pZtrkinyuukikancd8keta,
        String pZtrkinyuukkntratkiymd,
        String pZtrkinyuukkntratkitime,
        String pZtrkouhuriokyakusamano
    ) {
        primaryKey = new PKZT_SkKouhuriUkTrkkekkaTr(
            pZtrsyukkncd,
            pZtrkinyuukikancd8keta,
            pZtrkinyuukkntratkiymd,
            pZtrkinyuukkntratkitime,
            pZtrkouhuriokyakusamano
        );
    }

    @Transient
    @Override
    public PKZT_SkKouhuriUkTrkkekkaTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkKouhuriUkTrkkekkaTr> getMetaClass() {
        return QZT_SkKouhuriUkTrkkekkaTr.class;
    }

    @Id
    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRSYUKKNCD)
    public String getZtrsyukkncd() {
        return getPrimaryKey().getZtrsyukkncd();
    }

    public void setZtrsyukkncd(String pZtrsyukkncd) {
        getPrimaryKey().setZtrsyukkncd(pZtrsyukkncd);
    }

    @Id
    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKINYUUKIKANCD8KETA)
    public String getZtrkinyuukikancd8keta() {
        return getPrimaryKey().getZtrkinyuukikancd8keta();
    }

    public void setZtrkinyuukikancd8keta(String pZtrkinyuukikancd8keta) {
        getPrimaryKey().setZtrkinyuukikancd8keta(pZtrkinyuukikancd8keta);
    }

    private String ztrrecordkbn;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRRECORDKBN)
    public String getZtrrecordkbn() {
        return ztrrecordkbn;
    }

    @DataConvert("toSingleByte")
    public void setZtrrecordkbn(String pZtrrecordkbn) {
        ztrrecordkbn = pZtrrecordkbn;
    }

    @Id
    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKINYUUKKNTRATKIYMD)
    public String getZtrkinyuukkntratkiymd() {
        return getPrimaryKey().getZtrkinyuukkntratkiymd();
    }

    public void setZtrkinyuukkntratkiymd(String pZtrkinyuukkntratkiymd) {
        getPrimaryKey().setZtrkinyuukkntratkiymd(pZtrkinyuukkntratkiymd);
    }

    @Id
    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKINYUUKKNTRATKITIME)
    public String getZtrkinyuukkntratkitime() {
        return getPrimaryKey().getZtrkinyuukkntratkitime();
    }

    public void setZtrkinyuukkntratkitime(String pZtrkinyuukkntratkitime) {
        getPrimaryKey().setZtrkinyuukkntratkitime(pZtrkinyuukkntratkitime);
    }

    private String ztrkinyuukkntratkino;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKINYUUKKNTRATKINO)
    public String getZtrkinyuukkntratkino() {
        return ztrkinyuukkntratkino;
    }

    public void setZtrkinyuukkntratkino(String pZtrkinyuukkntratkino) {
        ztrkinyuukkntratkino = pZtrkinyuukkntratkino;
    }

    private String ztrkouhuriukchannelkbn;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKOUHURIUKCHANNELKBN)
    public String getZtrkouhuriukchannelkbn() {
        return ztrkouhuriukchannelkbn;
    }

    public void setZtrkouhuriukchannelkbn(String pZtrkouhuriukchannelkbn) {
        ztrkouhuriukchannelkbn = pZtrkouhuriukchannelkbn;
    }

    @Id
    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKOUHURIOKYAKUSAMANO)
    public String getZtrkouhuriokyakusamano() {
        return getPrimaryKey().getZtrkouhuriokyakusamano();
    }

    public void setZtrkouhuriokyakusamano(String pZtrkouhuriokyakusamano) {
        getPrimaryKey().setZtrkouhuriokyakusamano(pZtrkouhuriokyakusamano);
    }

    private String ztrkouhuribankcd;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKOUHURIBANKCD)
    public String getZtrkouhuribankcd() {
        return ztrkouhuribankcd;
    }

    public void setZtrkouhuribankcd(String pZtrkouhuribankcd) {
        ztrkouhuribankcd = pZtrkouhuribankcd;
    }

    private String ztrkouhurisitencd5keta;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKOUHURISITENCD5KETA)
    public String getZtrkouhurisitencd5keta() {
        return ztrkouhurisitencd5keta;
    }

    public void setZtrkouhurisitencd5keta(String pZtrkouhurisitencd5keta) {
        ztrkouhurisitencd5keta = pZtrkouhurisitencd5keta;
    }

    private String ztrkzhurikaeyokinkbn;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKZHURIKAEYOKINKBN)
    public String getZtrkzhurikaeyokinkbn() {
        return ztrkzhurikaeyokinkbn;
    }

    public void setZtrkzhurikaeyokinkbn(String pZtrkzhurikaeyokinkbn) {
        ztrkzhurikaeyokinkbn = pZtrkzhurikaeyokinkbn;
    }

    private String ztrkzhurikaekouzano8keta;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKZHURIKAEKOUZANO8KETA)
    public String getZtrkzhurikaekouzano8keta() {
        return ztrkzhurikaekouzano8keta;
    }

    public void setZtrkzhurikaekouzano8keta(String pZtrkzhurikaekouzano8keta) {
        ztrkzhurikaekouzano8keta = pZtrkzhurikaekouzano8keta;
    }

    private String ztrkzmeiginmei;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKZMEIGINMEI)
    public String getZtrkzmeiginmei() {
        return ztrkzmeiginmei;
    }

    public void setZtrkzmeiginmei(String pZtrkzmeiginmei) {
        ztrkzmeiginmei = pZtrkzmeiginmei;
    }

    private String ztritakusyacd;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRITAKUSYACD)
    public String getZtritakusyacd() {
        return ztritakusyacd;
    }

    public void setZtritakusyacd(String pZtritakusyacd) {
        ztritakusyacd = pZtritakusyacd;
    }

    private String ztrsyukkntratkiymd;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRSYUKKNTRATKIYMD)
    public String getZtrsyukkntratkiymd() {
        return ztrsyukkntratkiymd;
    }

    public void setZtrsyukkntratkiymd(String pZtrsyukkntratkiymd) {
        ztrsyukkntratkiymd = pZtrsyukkntratkiymd;
    }

    private String ztrsyukkntratkitime;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRSYUKKNTRATKITIME)
    public String getZtrsyukkntratkitime() {
        return ztrsyukkntratkitime;
    }

    public void setZtrsyukkntratkitime(String pZtrsyukkntratkitime) {
        ztrsyukkntratkitime = pZtrsyukkntratkitime;
    }

    private String ztrsyukkntratkino;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRSYUKKNTRATKINO)
    public String getZtrsyukkntratkino() {
        return ztrsyukkntratkino;
    }

    public void setZtrsyukkntratkino(String pZtrsyukkntratkino) {
        ztrsyukkntratkino = pZtrsyukkntratkino;
    }

    private String ztrkouhuristatuskbn;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKOUHURISTATUSKBN)
    public String getZtrkouhuristatuskbn() {
        return ztrkouhuristatuskbn;
    }

    public void setZtrkouhuristatuskbn(String pZtrkouhuristatuskbn) {
        ztrkouhuristatuskbn = pZtrkouhuristatuskbn;
    }

    private String ztrkouhurikekkacd;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKOUHURIKEKKACD)
    public String getZtrkouhurikekkacd() {
        return ztrkouhurikekkacd;
    }

    public void setZtrkouhurikekkacd(String pZtrkouhurikekkacd) {
        ztrkouhurikekkacd = pZtrkouhurikekkacd;
    }

    private String ztrkouhurihonninkakkekka;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRKOUHURIHONNINKAKKEKKA)
    public String getZtrkouhurihonninkakkekka() {
        return ztrkouhurihonninkakkekka;
    }

    public void setZtrkouhurihonninkakkekka(String pZtrkouhurihonninkakkekka) {
        ztrkouhurihonninkakkekka = pZtrkouhurihonninkakkekka;
    }

    private String ztryobiv207;

    @Column(name=GenZT_SkKouhuriUkTrkkekkaTr.ZTRYOBIV207)
    public String getZtryobiv207() {
        return ztryobiv207;
    }

    public void setZtryobiv207(String pZtryobiv207) {
        ztryobiv207 = pZtryobiv207;
    }
}