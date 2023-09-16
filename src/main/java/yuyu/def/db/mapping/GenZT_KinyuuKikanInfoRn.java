package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_KinyuuKikanInfoRn;
import yuyu.def.db.id.PKZT_KinyuuKikanInfoRn;
import yuyu.def.db.meta.GenQZT_KinyuuKikanInfoRn;
import yuyu.def.db.meta.QZT_KinyuuKikanInfoRn;

/**
 * 金融機関情報連動ファイルテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KinyuuKikanInfoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KinyuuKikanInfoRn}</td><td colspan="3">金融機関情報連動ファイルテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkinyuukikancd zrnkinyuukikancd}</td><td>（連携用）金融機関コード</td><td align="center">{@link PKZT_KinyuuKikanInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsitencd zrnsitencd}</td><td>（連携用）支店コード</td><td align="center">{@link PKZT_KinyuuKikanInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenpokbn zrntenpokbn}</td><td>（連携用）店舗区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinymd zrnkousinymd}</td><td>（連携用）更新年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsetuymd zrnsinsetuymd}</td><td>（連携用）新設年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaisiymd zrnhaisiymd}</td><td>（連携用）廃止年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanakinyuukikannm zrnkanakinyuukikannm}</td><td>（連携用）カナ金融機関名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanasitennm zrnkanasitennm}</td><td>（連携用）カナ支店名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjikinyuukikannm zrnkanjikinyuukikannm}</td><td>（連携用）漢字金融機関名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjisitennm zrnkanjisitennm}</td><td>（連携用）漢字支店名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrneijikinyuukikannm zrneijikinyuukikannm}</td><td>（連携用）英字金融機関名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrneijisitennm zrneijisitennm}</td><td>（連携用）英字支店名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncsskyouteikaisiymd zrncsskyouteikaisiymd}</td><td>（連携用）ＣＳＳ協定開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncsskyouteikaijyoymd zrncsskyouteikaijyoymd}</td><td>（連携用）ＣＳＳ協定解除年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkokunaikawasehyouji zrnkokunaikawasehyouji}</td><td>（連携用）内国為替制度加盟表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikomikanousitenhyouji zrnhurikomikanousitenhyouji}</td><td>（連携用）振込可能支店表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngyoutaikbn zrngyoutaikbn}</td><td>（連携用）業態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyofurikyouteikaisiymd zrnyofurikyouteikaisiymd}</td><td>（連携用）預振協定開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyofurikyouteikaijyoymd zrnyofurikyouteikaijyoymd}</td><td>（連携用）預振協定解除年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitakusyakinyuucd zrnitakusyakinyuucd}</td><td>（連携用）委託者金融機関コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitakusyasitencd zrnitakusyasitencd}</td><td>（連携用）委託者支店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitakusyayokinkbn zrnitakusyayokinkbn}</td><td>（連携用）委託者預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitakusyakouzano zrnitakusyakouzano}</td><td>（連携用）委託者口座番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsrkeisanhoukbn zrntsrkeisanhoukbn}</td><td>（連携用）手数料計算方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkinyuutesuuryou zrnkinyuutesuuryou}</td><td>（連携用）手数料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnitakusyacd zrnitakusyacd}</td><td>（連携用）委託者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntapekoukankbn1 zrntapekoukankbn1}</td><td>（連携用）テープ交換区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmdsisyacd zrnmdsisyacd}</td><td>（連携用）窓口支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzzkkyouteikaisiymd zrnzzkkyouteikaisiymd}</td><td>（連携用）全税共協定開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzzkkyouteikaijyoymd zrnzzkkyouteikaijyoymd}</td><td>（連携用）全税共協定解除年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhuhoyofuriinfokousinymd zrnhuhoyofuriinfokousinymd}</td><td>（連携用）普保預振情報更新年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv17 zrnyobiv17}</td><td>（連携用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KinyuuKikanInfoRn
 * @see     PKZT_KinyuuKikanInfoRn
 * @see     QZT_KinyuuKikanInfoRn
 * @see     GenQZT_KinyuuKikanInfoRn
 */
@MappedSuperclass
@Table(name=GenZT_KinyuuKikanInfoRn.TABLE_NAME)
@IdClass(value=PKZT_KinyuuKikanInfoRn.class)
public abstract class GenZT_KinyuuKikanInfoRn extends AbstractExDBEntityForZDB<ZT_KinyuuKikanInfoRn, PKZT_KinyuuKikanInfoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KinyuuKikanInfoRn";
    public static final String ZRNKINYUUKIKANCD         = "zrnkinyuukikancd";
    public static final String ZRNSITENCD               = "zrnsitencd";
    public static final String ZRNTENPOKBN              = "zrntenpokbn";
    public static final String ZRNKOUSINYMD             = "zrnkousinymd";
    public static final String ZRNSINSETUYMD            = "zrnsinsetuymd";
    public static final String ZRNHAISIYMD              = "zrnhaisiymd";
    public static final String ZRNKANAKINYUUKIKANNM     = "zrnkanakinyuukikannm";
    public static final String ZRNKANASITENNM           = "zrnkanasitennm";
    public static final String ZRNKANJIKINYUUKIKANNM    = "zrnkanjikinyuukikannm";
    public static final String ZRNKANJISITENNM          = "zrnkanjisitennm";
    public static final String ZRNEIJIKINYUUKIKANNM     = "zrneijikinyuukikannm";
    public static final String ZRNEIJISITENNM           = "zrneijisitennm";
    public static final String ZRNCSSKYOUTEIKAISIYMD    = "zrncsskyouteikaisiymd";
    public static final String ZRNCSSKYOUTEIKAIJYOYMD   = "zrncsskyouteikaijyoymd";
    public static final String ZRNKOKUNAIKAWASEHYOUJI   = "zrnkokunaikawasehyouji";
    public static final String ZRNHURIKOMIKANOUSITENHYOUJI = "zrnhurikomikanousitenhyouji";
    public static final String ZRNGYOUTAIKBN            = "zrngyoutaikbn";
    public static final String ZRNYOFURIKYOUTEIKAISIYMD = "zrnyofurikyouteikaisiymd";
    public static final String ZRNYOFURIKYOUTEIKAIJYOYMD = "zrnyofurikyouteikaijyoymd";
    public static final String ZRNITAKUSYAKINYUUCD      = "zrnitakusyakinyuucd";
    public static final String ZRNITAKUSYASITENCD       = "zrnitakusyasitencd";
    public static final String ZRNITAKUSYAYOKINKBN      = "zrnitakusyayokinkbn";
    public static final String ZRNITAKUSYAKOUZANO       = "zrnitakusyakouzano";
    public static final String ZRNTSRKEISANHOUKBN       = "zrntsrkeisanhoukbn";
    public static final String ZRNKINYUUTESUURYOU       = "zrnkinyuutesuuryou";
    public static final String ZRNITAKUSYACD            = "zrnitakusyacd";
    public static final String ZRNTAPEKOUKANKBN1        = "zrntapekoukankbn1";
    public static final String ZRNMDSISYACD             = "zrnmdsisyacd";
    public static final String ZRNZZKKYOUTEIKAISIYMD    = "zrnzzkkyouteikaisiymd";
    public static final String ZRNZZKKYOUTEIKAIJYOYMD   = "zrnzzkkyouteikaijyoymd";
    public static final String ZRNHUHOYOFURIINFOKOUSINYMD = "zrnhuhoyofuriinfokousinymd";
    public static final String ZRNYOBIV17               = "zrnyobiv17";

    private final PKZT_KinyuuKikanInfoRn primaryKey;

    public GenZT_KinyuuKikanInfoRn() {
        primaryKey = new PKZT_KinyuuKikanInfoRn();
    }

    public GenZT_KinyuuKikanInfoRn(String pZrnkinyuukikancd, String pZrnsitencd) {
        primaryKey = new PKZT_KinyuuKikanInfoRn(pZrnkinyuukikancd, pZrnsitencd);
    }

    @Transient
    @Override
    public PKZT_KinyuuKikanInfoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KinyuuKikanInfoRn> getMetaClass() {
        return QZT_KinyuuKikanInfoRn.class;
    }

    @Id
    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNKINYUUKIKANCD)
    public String getZrnkinyuukikancd() {
        return getPrimaryKey().getZrnkinyuukikancd();
    }

    public void setZrnkinyuukikancd(String pZrnkinyuukikancd) {
        getPrimaryKey().setZrnkinyuukikancd(pZrnkinyuukikancd);
    }

    @Id
    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNSITENCD)
    public String getZrnsitencd() {
        return getPrimaryKey().getZrnsitencd();
    }

    public void setZrnsitencd(String pZrnsitencd) {
        getPrimaryKey().setZrnsitencd(pZrnsitencd);
    }

    private String zrntenpokbn;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNTENPOKBN)
    public String getZrntenpokbn() {
        return zrntenpokbn;
    }

    public void setZrntenpokbn(String pZrntenpokbn) {
        zrntenpokbn = pZrntenpokbn;
    }

    private String zrnkousinymd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNKOUSINYMD)
    public String getZrnkousinymd() {
        return zrnkousinymd;
    }

    public void setZrnkousinymd(String pZrnkousinymd) {
        zrnkousinymd = pZrnkousinymd;
    }

    private String zrnsinsetuymd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNSINSETUYMD)
    public String getZrnsinsetuymd() {
        return zrnsinsetuymd;
    }

    public void setZrnsinsetuymd(String pZrnsinsetuymd) {
        zrnsinsetuymd = pZrnsinsetuymd;
    }

    private String zrnhaisiymd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNHAISIYMD)
    public String getZrnhaisiymd() {
        return zrnhaisiymd;
    }

    public void setZrnhaisiymd(String pZrnhaisiymd) {
        zrnhaisiymd = pZrnhaisiymd;
    }

    private String zrnkanakinyuukikannm;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNKANAKINYUUKIKANNM)
    public String getZrnkanakinyuukikannm() {
        return zrnkanakinyuukikannm;
    }

    public void setZrnkanakinyuukikannm(String pZrnkanakinyuukikannm) {
        zrnkanakinyuukikannm = pZrnkanakinyuukikannm;
    }

    private String zrnkanasitennm;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNKANASITENNM)
    public String getZrnkanasitennm() {
        return zrnkanasitennm;
    }

    public void setZrnkanasitennm(String pZrnkanasitennm) {
        zrnkanasitennm = pZrnkanasitennm;
    }

    private String zrnkanjikinyuukikannm;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNKANJIKINYUUKIKANNM)
    public String getZrnkanjikinyuukikannm() {
        return zrnkanjikinyuukikannm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjikinyuukikannm(String pZrnkanjikinyuukikannm) {
        zrnkanjikinyuukikannm = pZrnkanjikinyuukikannm;
    }

    private String zrnkanjisitennm;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNKANJISITENNM)
    public String getZrnkanjisitennm() {
        return zrnkanjisitennm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjisitennm(String pZrnkanjisitennm) {
        zrnkanjisitennm = pZrnkanjisitennm;
    }

    private String zrneijikinyuukikannm;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNEIJIKINYUUKIKANNM)
    public String getZrneijikinyuukikannm() {
        return zrneijikinyuukikannm;
    }

    public void setZrneijikinyuukikannm(String pZrneijikinyuukikannm) {
        zrneijikinyuukikannm = pZrneijikinyuukikannm;
    }

    private String zrneijisitennm;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNEIJISITENNM)
    public String getZrneijisitennm() {
        return zrneijisitennm;
    }

    public void setZrneijisitennm(String pZrneijisitennm) {
        zrneijisitennm = pZrneijisitennm;
    }

    private String zrncsskyouteikaisiymd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNCSSKYOUTEIKAISIYMD)
    public String getZrncsskyouteikaisiymd() {
        return zrncsskyouteikaisiymd;
    }

    public void setZrncsskyouteikaisiymd(String pZrncsskyouteikaisiymd) {
        zrncsskyouteikaisiymd = pZrncsskyouteikaisiymd;
    }

    private String zrncsskyouteikaijyoymd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNCSSKYOUTEIKAIJYOYMD)
    public String getZrncsskyouteikaijyoymd() {
        return zrncsskyouteikaijyoymd;
    }

    public void setZrncsskyouteikaijyoymd(String pZrncsskyouteikaijyoymd) {
        zrncsskyouteikaijyoymd = pZrncsskyouteikaijyoymd;
    }

    private String zrnkokunaikawasehyouji;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNKOKUNAIKAWASEHYOUJI)
    public String getZrnkokunaikawasehyouji() {
        return zrnkokunaikawasehyouji;
    }

    public void setZrnkokunaikawasehyouji(String pZrnkokunaikawasehyouji) {
        zrnkokunaikawasehyouji = pZrnkokunaikawasehyouji;
    }

    private String zrnhurikomikanousitenhyouji;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNHURIKOMIKANOUSITENHYOUJI)
    public String getZrnhurikomikanousitenhyouji() {
        return zrnhurikomikanousitenhyouji;
    }

    public void setZrnhurikomikanousitenhyouji(String pZrnhurikomikanousitenhyouji) {
        zrnhurikomikanousitenhyouji = pZrnhurikomikanousitenhyouji;
    }

    private String zrngyoutaikbn;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNGYOUTAIKBN)
    public String getZrngyoutaikbn() {
        return zrngyoutaikbn;
    }

    public void setZrngyoutaikbn(String pZrngyoutaikbn) {
        zrngyoutaikbn = pZrngyoutaikbn;
    }

    private String zrnyofurikyouteikaisiymd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNYOFURIKYOUTEIKAISIYMD)
    public String getZrnyofurikyouteikaisiymd() {
        return zrnyofurikyouteikaisiymd;
    }

    public void setZrnyofurikyouteikaisiymd(String pZrnyofurikyouteikaisiymd) {
        zrnyofurikyouteikaisiymd = pZrnyofurikyouteikaisiymd;
    }

    private String zrnyofurikyouteikaijyoymd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNYOFURIKYOUTEIKAIJYOYMD)
    public String getZrnyofurikyouteikaijyoymd() {
        return zrnyofurikyouteikaijyoymd;
    }

    public void setZrnyofurikyouteikaijyoymd(String pZrnyofurikyouteikaijyoymd) {
        zrnyofurikyouteikaijyoymd = pZrnyofurikyouteikaijyoymd;
    }

    private String zrnitakusyakinyuucd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNITAKUSYAKINYUUCD)
    public String getZrnitakusyakinyuucd() {
        return zrnitakusyakinyuucd;
    }

    public void setZrnitakusyakinyuucd(String pZrnitakusyakinyuucd) {
        zrnitakusyakinyuucd = pZrnitakusyakinyuucd;
    }

    private String zrnitakusyasitencd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNITAKUSYASITENCD)
    public String getZrnitakusyasitencd() {
        return zrnitakusyasitencd;
    }

    public void setZrnitakusyasitencd(String pZrnitakusyasitencd) {
        zrnitakusyasitencd = pZrnitakusyasitencd;
    }

    private String zrnitakusyayokinkbn;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNITAKUSYAYOKINKBN)
    public String getZrnitakusyayokinkbn() {
        return zrnitakusyayokinkbn;
    }

    public void setZrnitakusyayokinkbn(String pZrnitakusyayokinkbn) {
        zrnitakusyayokinkbn = pZrnitakusyayokinkbn;
    }

    private String zrnitakusyakouzano;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNITAKUSYAKOUZANO)
    public String getZrnitakusyakouzano() {
        return zrnitakusyakouzano;
    }

    public void setZrnitakusyakouzano(String pZrnitakusyakouzano) {
        zrnitakusyakouzano = pZrnitakusyakouzano;
    }

    private String zrntsrkeisanhoukbn;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNTSRKEISANHOUKBN)
    public String getZrntsrkeisanhoukbn() {
        return zrntsrkeisanhoukbn;
    }

    public void setZrntsrkeisanhoukbn(String pZrntsrkeisanhoukbn) {
        zrntsrkeisanhoukbn = pZrntsrkeisanhoukbn;
    }

    private Integer zrnkinyuutesuuryou;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNKINYUUTESUURYOU)
    public Integer getZrnkinyuutesuuryou() {
        return zrnkinyuutesuuryou;
    }

    public void setZrnkinyuutesuuryou(Integer pZrnkinyuutesuuryou) {
        zrnkinyuutesuuryou = pZrnkinyuutesuuryou;
    }

    private String zrnitakusyacd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNITAKUSYACD)
    public String getZrnitakusyacd() {
        return zrnitakusyacd;
    }

    public void setZrnitakusyacd(String pZrnitakusyacd) {
        zrnitakusyacd = pZrnitakusyacd;
    }

    private String zrntapekoukankbn1;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNTAPEKOUKANKBN1)
    public String getZrntapekoukankbn1() {
        return zrntapekoukankbn1;
    }

    public void setZrntapekoukankbn1(String pZrntapekoukankbn1) {
        zrntapekoukankbn1 = pZrntapekoukankbn1;
    }

    private String zrnmdsisyacd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNMDSISYACD)
    public String getZrnmdsisyacd() {
        return zrnmdsisyacd;
    }

    public void setZrnmdsisyacd(String pZrnmdsisyacd) {
        zrnmdsisyacd = pZrnmdsisyacd;
    }

    private String zrnzzkkyouteikaisiymd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNZZKKYOUTEIKAISIYMD)
    public String getZrnzzkkyouteikaisiymd() {
        return zrnzzkkyouteikaisiymd;
    }

    public void setZrnzzkkyouteikaisiymd(String pZrnzzkkyouteikaisiymd) {
        zrnzzkkyouteikaisiymd = pZrnzzkkyouteikaisiymd;
    }

    private String zrnzzkkyouteikaijyoymd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNZZKKYOUTEIKAIJYOYMD)
    public String getZrnzzkkyouteikaijyoymd() {
        return zrnzzkkyouteikaijyoymd;
    }

    public void setZrnzzkkyouteikaijyoymd(String pZrnzzkkyouteikaijyoymd) {
        zrnzzkkyouteikaijyoymd = pZrnzzkkyouteikaijyoymd;
    }

    private String zrnhuhoyofuriinfokousinymd;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNHUHOYOFURIINFOKOUSINYMD)
    public String getZrnhuhoyofuriinfokousinymd() {
        return zrnhuhoyofuriinfokousinymd;
    }

    public void setZrnhuhoyofuriinfokousinymd(String pZrnhuhoyofuriinfokousinymd) {
        zrnhuhoyofuriinfokousinymd = pZrnhuhoyofuriinfokousinymd;
    }

    private String zrnyobiv17;

    @Column(name=GenZT_KinyuuKikanInfoRn.ZRNYOBIV17)
    public String getZrnyobiv17() {
        return zrnyobiv17;
    }

    public void setZrnyobiv17(String pZrnyobiv17) {
        zrnyobiv17 = pZrnyobiv17;
    }
}