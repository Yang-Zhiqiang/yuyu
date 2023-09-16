package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_SyainMeiboRn;
import yuyu.def.db.id.PKZT_SyainMeiboRn;
import yuyu.def.db.meta.GenQZT_SyainMeiboRn;
import yuyu.def.db.meta.QZT_SyainMeiboRn;

/**
 * 社員名簿Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SyainMeiboRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyainMeiboRn}</td><td colspan="3">社員名簿Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhokenkbn zrnhokenkbn}</td><td>（連携用）保険区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyainmeibokbn zrnsyainmeibokbn}</td><td>（連携用）社員名簿用区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaskinmeino zrnkyksyaskinmeino}</td><td>（連携用）契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyainnm zrnsyainnm}</td><td>（連携用）社員名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjisyainnm zrnkanjisyainnm}</td><td>（連携用）漢字社員名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyainseiymd zrnsyainseiymd}</td><td>（連携用）社員生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinkihontikucd zrntsinkihontikucd}</td><td>（連携用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjitsinkaiadr zrnkanjitsinkaiadr}</td><td>（連携用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SyainMeiboRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksyuannaikykkbn zrntksyuannaikykkbn}</td><td>（連携用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsouhuhunoukbn zrnsouhuhunoukbn}</td><td>（連携用）送付不能区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyainmeibos zrnsyainmeibos}</td><td>（連携用）社員名簿用Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyainmeibop zrnsyainmeibop}</td><td>（連携用）社員名簿用Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyainmeibosyouyop zrnsyainmeibosyouyop}</td><td>（連携用）社員名簿用賞与払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyofuritysytzumihyouji zrnyofuritysytzumihyouji}</td><td>（連携用）預振抽出済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnayosekihontikucd zrnnayosekihontikucd}</td><td>（連携用）名寄せ用基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10 zrnyobiv10}</td><td>（連携用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyainMeiboRn
 * @see     PKZT_SyainMeiboRn
 * @see     QZT_SyainMeiboRn
 * @see     GenQZT_SyainMeiboRn
 */
@MappedSuperclass
@Table(name=GenZT_SyainMeiboRn.TABLE_NAME)
@IdClass(value=PKZT_SyainMeiboRn.class)
public abstract class GenZT_SyainMeiboRn extends AbstractExDBEntityForZDB<ZT_SyainMeiboRn, PKZT_SyainMeiboRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyainMeiboRn";
    public static final String ZRNHOKENKBN              = "zrnhokenkbn";
    public static final String ZRNSYAINMEIBOKBN         = "zrnsyainmeibokbn";
    public static final String ZRNKYKSYASKINMEINO       = "zrnkyksyaskinmeino";
    public static final String ZRNSYAINNM               = "zrnsyainnm";
    public static final String ZRNKANJISYAINNM          = "zrnkanjisyainnm";
    public static final String ZRNSYAINSEIYMD           = "zrnsyainseiymd";
    public static final String ZRNTSINKIHONTIKUCD       = "zrntsinkihontikucd";
    public static final String ZRNKANJITSINKAIADR       = "zrnkanjitsinkaiadr";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNTKSYUANNAIKYKKBN      = "zrntksyuannaikykkbn";
    public static final String ZRNSOUHUHUNOUKBN         = "zrnsouhuhunoukbn";
    public static final String ZRNSYAINMEIBOS           = "zrnsyainmeibos";
    public static final String ZRNSYAINMEIBOP           = "zrnsyainmeibop";
    public static final String ZRNSYAINMEIBOSYOUYOP     = "zrnsyainmeibosyouyop";
    public static final String ZRNYOFURITYSYTZUMIHYOUJI = "zrnyofuritysytzumihyouji";
    public static final String ZRNNAYOSEKIHONTIKUCD     = "zrnnayosekihontikucd";
    public static final String ZRNYOBIV10               = "zrnyobiv10";

    private final PKZT_SyainMeiboRn primaryKey;

    public GenZT_SyainMeiboRn() {
        primaryKey = new PKZT_SyainMeiboRn();
    }

    public GenZT_SyainMeiboRn(String pZrnsyono) {
        primaryKey = new PKZT_SyainMeiboRn(pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_SyainMeiboRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyainMeiboRn> getMetaClass() {
        return QZT_SyainMeiboRn.class;
    }

    private String zrnhokenkbn;

    @Column(name=GenZT_SyainMeiboRn.ZRNHOKENKBN)
    public String getZrnhokenkbn() {
        return zrnhokenkbn;
    }

    public void setZrnhokenkbn(String pZrnhokenkbn) {
        zrnhokenkbn = pZrnhokenkbn;
    }

    private String zrnsyainmeibokbn;

    @Column(name=GenZT_SyainMeiboRn.ZRNSYAINMEIBOKBN)
    public String getZrnsyainmeibokbn() {
        return zrnsyainmeibokbn;
    }

    public void setZrnsyainmeibokbn(String pZrnsyainmeibokbn) {
        zrnsyainmeibokbn = pZrnsyainmeibokbn;
    }

    private String zrnkyksyaskinmeino;

    @Column(name=GenZT_SyainMeiboRn.ZRNKYKSYASKINMEINO)
    public String getZrnkyksyaskinmeino() {
        return zrnkyksyaskinmeino;
    }

    public void setZrnkyksyaskinmeino(String pZrnkyksyaskinmeino) {
        zrnkyksyaskinmeino = pZrnkyksyaskinmeino;
    }

    private String zrnsyainnm;

    @Column(name=GenZT_SyainMeiboRn.ZRNSYAINNM)
    public String getZrnsyainnm() {
        return zrnsyainnm;
    }

    public void setZrnsyainnm(String pZrnsyainnm) {
        zrnsyainnm = pZrnsyainnm;
    }

    private String zrnkanjisyainnm;

    @Column(name=GenZT_SyainMeiboRn.ZRNKANJISYAINNM)
    public String getZrnkanjisyainnm() {
        return zrnkanjisyainnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjisyainnm(String pZrnkanjisyainnm) {
        zrnkanjisyainnm = pZrnkanjisyainnm;
    }

    private String zrnsyainseiymd;

    @Column(name=GenZT_SyainMeiboRn.ZRNSYAINSEIYMD)
    public String getZrnsyainseiymd() {
        return zrnsyainseiymd;
    }

    public void setZrnsyainseiymd(String pZrnsyainseiymd) {
        zrnsyainseiymd = pZrnsyainseiymd;
    }

    private String zrntsinkihontikucd;

    @Column(name=GenZT_SyainMeiboRn.ZRNTSINKIHONTIKUCD)
    public String getZrntsinkihontikucd() {
        return zrntsinkihontikucd;
    }

    public void setZrntsinkihontikucd(String pZrntsinkihontikucd) {
        zrntsinkihontikucd = pZrntsinkihontikucd;
    }

    private String zrnkanjitsinkaiadr;

    @Column(name=GenZT_SyainMeiboRn.ZRNKANJITSINKAIADR)
    public String getZrnkanjitsinkaiadr() {
        return zrnkanjitsinkaiadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjitsinkaiadr(String pZrnkanjitsinkaiadr) {
        zrnkanjitsinkaiadr = pZrnkanjitsinkaiadr;
    }

    @Id
    @Column(name=GenZT_SyainMeiboRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_SyainMeiboRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_SyainMeiboRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_SyainMeiboRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_SyainMeiboRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrntksyuannaikykkbn;

    @Column(name=GenZT_SyainMeiboRn.ZRNTKSYUANNAIKYKKBN)
    public String getZrntksyuannaikykkbn() {
        return zrntksyuannaikykkbn;
    }

    public void setZrntksyuannaikykkbn(String pZrntksyuannaikykkbn) {
        zrntksyuannaikykkbn = pZrntksyuannaikykkbn;
    }

    private String zrnsouhuhunoukbn;

    @Column(name=GenZT_SyainMeiboRn.ZRNSOUHUHUNOUKBN)
    public String getZrnsouhuhunoukbn() {
        return zrnsouhuhunoukbn;
    }

    public void setZrnsouhuhunoukbn(String pZrnsouhuhunoukbn) {
        zrnsouhuhunoukbn = pZrnsouhuhunoukbn;
    }

    private Long zrnsyainmeibos;

    @Column(name=GenZT_SyainMeiboRn.ZRNSYAINMEIBOS)
    public Long getZrnsyainmeibos() {
        return zrnsyainmeibos;
    }

    public void setZrnsyainmeibos(Long pZrnsyainmeibos) {
        zrnsyainmeibos = pZrnsyainmeibos;
    }

    private Long zrnsyainmeibop;

    @Column(name=GenZT_SyainMeiboRn.ZRNSYAINMEIBOP)
    public Long getZrnsyainmeibop() {
        return zrnsyainmeibop;
    }

    public void setZrnsyainmeibop(Long pZrnsyainmeibop) {
        zrnsyainmeibop = pZrnsyainmeibop;
    }

    private Long zrnsyainmeibosyouyop;

    @Column(name=GenZT_SyainMeiboRn.ZRNSYAINMEIBOSYOUYOP)
    public Long getZrnsyainmeibosyouyop() {
        return zrnsyainmeibosyouyop;
    }

    public void setZrnsyainmeibosyouyop(Long pZrnsyainmeibosyouyop) {
        zrnsyainmeibosyouyop = pZrnsyainmeibosyouyop;
    }

    private String zrnyofuritysytzumihyouji;

    @Column(name=GenZT_SyainMeiboRn.ZRNYOFURITYSYTZUMIHYOUJI)
    public String getZrnyofuritysytzumihyouji() {
        return zrnyofuritysytzumihyouji;
    }

    public void setZrnyofuritysytzumihyouji(String pZrnyofuritysytzumihyouji) {
        zrnyofuritysytzumihyouji = pZrnyofuritysytzumihyouji;
    }

    private String zrnnayosekihontikucd;

    @Column(name=GenZT_SyainMeiboRn.ZRNNAYOSEKIHONTIKUCD)
    public String getZrnnayosekihontikucd() {
        return zrnnayosekihontikucd;
    }

    public void setZrnnayosekihontikucd(String pZrnnayosekihontikucd) {
        zrnnayosekihontikucd = pZrnnayosekihontikucd;
    }

    private String zrnyobiv10;

    @Column(name=GenZT_SyainMeiboRn.ZRNYOBIV10)
    public String getZrnyobiv10() {
        return zrnyobiv10;
    }

    public void setZrnyobiv10(String pZrnyobiv10) {
        zrnyobiv10 = pZrnyobiv10;
    }
}