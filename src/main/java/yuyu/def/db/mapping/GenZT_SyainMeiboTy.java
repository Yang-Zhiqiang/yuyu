package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SyainMeiboTy;
import yuyu.def.db.id.PKZT_SyainMeiboTy;
import yuyu.def.db.meta.GenQZT_SyainMeiboTy;
import yuyu.def.db.meta.QZT_SyainMeiboTy;

/**
 * 社員名簿Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SyainMeiboTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyainMeiboTy}</td><td colspan="3">社員名簿Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyhokenkbn ztyhokenkbn}</td><td>（中継用）保険区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyainmeibokbn ztysyainmeibokbn}</td><td>（中継用）社員名簿用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaskinmeino ztykyksyaskinmeino}</td><td>（中継用）契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyainnm ztysyainnm}</td><td>（中継用）社員名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjisyainnm ztykanjisyainnm}</td><td>（中継用）漢字社員名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyainseiymd ztysyainseiymd}</td><td>（中継用）社員生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinkihontikucd ztytsinkihontikucd}</td><td>（中継用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjitsinkaiadr ztykanjitsinkaiadr}</td><td>（中継用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SyainMeiboTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksyuannaikykkbn ztytksyuannaikykkbn}</td><td>（中継用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysouhuhunoukbn ztysouhuhunoukbn}</td><td>（中継用）送付不能区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyainmeibos ztysyainmeibos}</td><td>（中継用）社員名簿用Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyainmeibop ztysyainmeibop}</td><td>（中継用）社員名簿用Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyainmeibosyouyop ztysyainmeibosyouyop}</td><td>（中継用）社員名簿用賞与払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyofuritysytzumihyouji ztyyofuritysytzumihyouji}</td><td>（中継用）預振抽出済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynayosekihontikucd ztynayosekihontikucd}</td><td>（中継用）名寄せ用基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10 ztyyobiv10}</td><td>（中継用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyainMeiboTy
 * @see     PKZT_SyainMeiboTy
 * @see     QZT_SyainMeiboTy
 * @see     GenQZT_SyainMeiboTy
 */
@MappedSuperclass
@Table(name=GenZT_SyainMeiboTy.TABLE_NAME)
@IdClass(value=PKZT_SyainMeiboTy.class)
public abstract class GenZT_SyainMeiboTy extends AbstractExDBEntity<ZT_SyainMeiboTy, PKZT_SyainMeiboTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyainMeiboTy";
    public static final String ZTYHOKENKBN              = "ztyhokenkbn";
    public static final String ZTYSYAINMEIBOKBN         = "ztysyainmeibokbn";
    public static final String ZTYKYKSYASKINMEINO       = "ztykyksyaskinmeino";
    public static final String ZTYSYAINNM               = "ztysyainnm";
    public static final String ZTYKANJISYAINNM          = "ztykanjisyainnm";
    public static final String ZTYSYAINSEIYMD           = "ztysyainseiymd";
    public static final String ZTYTSINKIHONTIKUCD       = "ztytsinkihontikucd";
    public static final String ZTYKANJITSINKAIADR       = "ztykanjitsinkaiadr";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYTKSYUANNAIKYKKBN      = "ztytksyuannaikykkbn";
    public static final String ZTYSOUHUHUNOUKBN         = "ztysouhuhunoukbn";
    public static final String ZTYSYAINMEIBOS           = "ztysyainmeibos";
    public static final String ZTYSYAINMEIBOP           = "ztysyainmeibop";
    public static final String ZTYSYAINMEIBOSYOUYOP     = "ztysyainmeibosyouyop";
    public static final String ZTYYOFURITYSYTZUMIHYOUJI = "ztyyofuritysytzumihyouji";
    public static final String ZTYNAYOSEKIHONTIKUCD     = "ztynayosekihontikucd";
    public static final String ZTYYOBIV10               = "ztyyobiv10";

    private final PKZT_SyainMeiboTy primaryKey;

    public GenZT_SyainMeiboTy() {
        primaryKey = new PKZT_SyainMeiboTy();
    }

    public GenZT_SyainMeiboTy(String pZtysyono) {
        primaryKey = new PKZT_SyainMeiboTy(pZtysyono);
    }

    @Transient
    @Override
    public PKZT_SyainMeiboTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyainMeiboTy> getMetaClass() {
        return QZT_SyainMeiboTy.class;
    }

    private String ztyhokenkbn;

    @Column(name=GenZT_SyainMeiboTy.ZTYHOKENKBN)
    public String getZtyhokenkbn() {
        return ztyhokenkbn;
    }

    public void setZtyhokenkbn(String pZtyhokenkbn) {
        ztyhokenkbn = pZtyhokenkbn;
    }

    private String ztysyainmeibokbn;

    @Column(name=GenZT_SyainMeiboTy.ZTYSYAINMEIBOKBN)
    public String getZtysyainmeibokbn() {
        return ztysyainmeibokbn;
    }

    public void setZtysyainmeibokbn(String pZtysyainmeibokbn) {
        ztysyainmeibokbn = pZtysyainmeibokbn;
    }

    private String ztykyksyaskinmeino;

    @Column(name=GenZT_SyainMeiboTy.ZTYKYKSYASKINMEINO)
    public String getZtykyksyaskinmeino() {
        return ztykyksyaskinmeino;
    }

    public void setZtykyksyaskinmeino(String pZtykyksyaskinmeino) {
        ztykyksyaskinmeino = pZtykyksyaskinmeino;
    }

    private String ztysyainnm;

    @Column(name=GenZT_SyainMeiboTy.ZTYSYAINNM)
    public String getZtysyainnm() {
        return ztysyainnm;
    }

    public void setZtysyainnm(String pZtysyainnm) {
        ztysyainnm = pZtysyainnm;
    }

    private String ztykanjisyainnm;

    @Column(name=GenZT_SyainMeiboTy.ZTYKANJISYAINNM)
    public String getZtykanjisyainnm() {
        return ztykanjisyainnm;
    }

    public void setZtykanjisyainnm(String pZtykanjisyainnm) {
        ztykanjisyainnm = pZtykanjisyainnm;
    }

    private String ztysyainseiymd;

    @Column(name=GenZT_SyainMeiboTy.ZTYSYAINSEIYMD)
    public String getZtysyainseiymd() {
        return ztysyainseiymd;
    }

    public void setZtysyainseiymd(String pZtysyainseiymd) {
        ztysyainseiymd = pZtysyainseiymd;
    }

    private String ztytsinkihontikucd;

    @Column(name=GenZT_SyainMeiboTy.ZTYTSINKIHONTIKUCD)
    public String getZtytsinkihontikucd() {
        return ztytsinkihontikucd;
    }

    public void setZtytsinkihontikucd(String pZtytsinkihontikucd) {
        ztytsinkihontikucd = pZtytsinkihontikucd;
    }

    private String ztykanjitsinkaiadr;

    @Column(name=GenZT_SyainMeiboTy.ZTYKANJITSINKAIADR)
    public String getZtykanjitsinkaiadr() {
        return ztykanjitsinkaiadr;
    }

    public void setZtykanjitsinkaiadr(String pZtykanjitsinkaiadr) {
        ztykanjitsinkaiadr = pZtykanjitsinkaiadr;
    }

    @Id
    @Column(name=GenZT_SyainMeiboTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_SyainMeiboTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_SyainMeiboTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_SyainMeiboTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_SyainMeiboTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztytksyuannaikykkbn;

    @Column(name=GenZT_SyainMeiboTy.ZTYTKSYUANNAIKYKKBN)
    public String getZtytksyuannaikykkbn() {
        return ztytksyuannaikykkbn;
    }

    public void setZtytksyuannaikykkbn(String pZtytksyuannaikykkbn) {
        ztytksyuannaikykkbn = pZtytksyuannaikykkbn;
    }

    private String ztysouhuhunoukbn;

    @Column(name=GenZT_SyainMeiboTy.ZTYSOUHUHUNOUKBN)
    public String getZtysouhuhunoukbn() {
        return ztysouhuhunoukbn;
    }

    public void setZtysouhuhunoukbn(String pZtysouhuhunoukbn) {
        ztysouhuhunoukbn = pZtysouhuhunoukbn;
    }

    private Long ztysyainmeibos;

    @Column(name=GenZT_SyainMeiboTy.ZTYSYAINMEIBOS)
    public Long getZtysyainmeibos() {
        return ztysyainmeibos;
    }

    public void setZtysyainmeibos(Long pZtysyainmeibos) {
        ztysyainmeibos = pZtysyainmeibos;
    }

    private Long ztysyainmeibop;

    @Column(name=GenZT_SyainMeiboTy.ZTYSYAINMEIBOP)
    public Long getZtysyainmeibop() {
        return ztysyainmeibop;
    }

    public void setZtysyainmeibop(Long pZtysyainmeibop) {
        ztysyainmeibop = pZtysyainmeibop;
    }

    private Long ztysyainmeibosyouyop;

    @Column(name=GenZT_SyainMeiboTy.ZTYSYAINMEIBOSYOUYOP)
    public Long getZtysyainmeibosyouyop() {
        return ztysyainmeibosyouyop;
    }

    public void setZtysyainmeibosyouyop(Long pZtysyainmeibosyouyop) {
        ztysyainmeibosyouyop = pZtysyainmeibosyouyop;
    }

    private String ztyyofuritysytzumihyouji;

    @Column(name=GenZT_SyainMeiboTy.ZTYYOFURITYSYTZUMIHYOUJI)
    public String getZtyyofuritysytzumihyouji() {
        return ztyyofuritysytzumihyouji;
    }

    public void setZtyyofuritysytzumihyouji(String pZtyyofuritysytzumihyouji) {
        ztyyofuritysytzumihyouji = pZtyyofuritysytzumihyouji;
    }

    private String ztynayosekihontikucd;

    @Column(name=GenZT_SyainMeiboTy.ZTYNAYOSEKIHONTIKUCD)
    public String getZtynayosekihontikucd() {
        return ztynayosekihontikucd;
    }

    public void setZtynayosekihontikucd(String pZtynayosekihontikucd) {
        ztynayosekihontikucd = pZtynayosekihontikucd;
    }

    private String ztyyobiv10;

    @Column(name=GenZT_SyainMeiboTy.ZTYYOBIV10)
    public String getZtyyobiv10() {
        return ztyyobiv10;
    }

    public void setZtyyobiv10(String pZtyyobiv10) {
        ztyyobiv10 = pZtyyobiv10;
    }
}
