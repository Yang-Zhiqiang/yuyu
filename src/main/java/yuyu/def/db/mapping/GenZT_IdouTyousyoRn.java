package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_IdouTyousyoRn;
import yuyu.def.db.id.PKZT_IdouTyousyoRn;
import yuyu.def.db.meta.GenQZT_IdouTyousyoRn;
import yuyu.def.db.meta.QZT_IdouTyousyoRn;

/**
 * 異動調書テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_IdouTyousyoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IdouTyousyoRn}</td><td colspan="3">異動調書テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsubsystemid zrnsubsystemid}</td><td>（連携用）サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_IdouTyousyoRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkacd zrnkacd}</td><td>（連携用）課コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantocd zrntantocd}</td><td>（連携用）担当コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorisosikicd zrnsyorisosikicd}</td><td>（連携用）処理組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtysysyuruicd zrnshrtysysyuruicd}</td><td>（連携用）支払調書種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoritaisyoukbn zrnsyoritaisyoukbn}</td><td>（連携用）処理対象区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbaitaiskshunoriyuukbn1 zrnbaitaiskshunoriyuukbn1}</td><td>（連携用）媒体作成不能理由区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbaitaiskshunoriyuukbn2 zrnbaitaiskshunoriyuukbn2}</td><td>（連携用）媒体作成不能理由区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbaitaiskshunoriyuukbn3 zrnbaitaiskshunoriyuukbn3}</td><td>（連携用）媒体作成不能理由区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbaitaiskshunoriyuukbn4 zrnbaitaiskshunoriyuukbn4}</td><td>（連携用）媒体作成不能理由区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbaitaiskshunoriyuukbn5 zrnbaitaiskshunoriyuukbn5}</td><td>（連携用）媒体作成不能理由区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtysyjyuusyocd zrnshrtysyjyuusyocd}</td><td>（連携用）支払調書住所コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtysyjyuusyo zrnshrtysyjyuusyo}</td><td>（連携用）支払調書住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj35 zrnkyknmkj35}</td><td>（連携用）契約者名（漢字）（３５桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3 zrnyobiv3}</td><td>（連携用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv25 zrnyobiv25}</td><td>（連携用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnoldkykadrcd zrnoldkykadrcd}</td><td>（連携用）旧契約者住所コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjoldkykadr zrnkjoldkykadr}</td><td>（連携用）漢字旧契約者住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjoldkyknm35 zrnkjoldkyknm35}</td><td>（連携用）漢字旧契約者名（３５桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3x2 zrnyobiv3x2}</td><td>（連携用）予備項目Ｖ３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv25x1 zrnyobiv25x1}</td><td>（連携用）予備項目Ｖ２５＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3x3 zrnyobiv3x3}</td><td>（連携用）予備項目Ｖ３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv17 zrnyobiv17}</td><td>（連携用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksibouymd zrnkyksibouymd}</td><td>（連携用）契約者死亡年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouryokuhasseiymd zrnkouryokuhasseiymd}</td><td>（連携用）効力発生日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksiboumeihensyoriymd zrnkyksiboumeihensyoriymd}</td><td>（連携用）契約者死亡名義変更処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x2 zrnyobiv8x2}</td><td>（連携用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x3 zrnyobiv8x3}</td><td>（連携用）予備項目Ｖ８＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x4 zrnyobiv8x4}</td><td>（連携用）予備項目Ｖ８＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksibouhyoukagk zrnkyksibouhyoukagk}</td><td>（連携用）契約者死亡評価額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkihrkmp zrnkihrkmp}</td><td>（連携用）既払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnoldkykkihrkmpyouhyj zrnoldkykkihrkmpyouhyj}</td><td>（連携用）旧契約者既払込保険料要表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnoldkykkihrkmp zrnoldkykkihrkmp}</td><td>（連携用）旧契約者既払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsakuseiymd zrnsakuseiymd}</td><td>（連携用）作成日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhuho2kykdisp zrnhuho2kykdisp}</td><td>（連携用）普保Ⅱ契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtysyhknsyukbn zrnshrtysyhknsyukbn}</td><td>（連携用）支払調書保険種類区分</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9 zrnyobiv9}</td><td>（連携用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyouranhensyuukbn1 zrntekiyouranhensyuukbn1}</td><td>（連携用）摘要欄編集区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyouranhensyuukbn2 zrntekiyouranhensyuukbn2}</td><td>（連携用）摘要欄編集区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyouranhensyuukbn3 zrntekiyouranhensyuukbn3}</td><td>（連携用）摘要欄編集区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyouranhensyuukbn4 zrntekiyouranhensyuukbn4}</td><td>（連携用）摘要欄編集区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyouranhensyuukbn5 zrntekiyouranhensyuukbn5}</td><td>（連携用）摘要欄編集区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv116 zrnyobiv116}</td><td>（連携用）予備項目Ｖ１１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_IdouTyousyoRn
 * @see     PKZT_IdouTyousyoRn
 * @see     QZT_IdouTyousyoRn
 * @see     GenQZT_IdouTyousyoRn
 */
@MappedSuperclass
@Table(name=GenZT_IdouTyousyoRn.TABLE_NAME)
@IdClass(value=PKZT_IdouTyousyoRn.class)
public abstract class GenZT_IdouTyousyoRn extends AbstractExDBEntityForZDB<ZT_IdouTyousyoRn, PKZT_IdouTyousyoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_IdouTyousyoRn";
    public static final String ZRNSUBSYSTEMID           = "zrnsubsystemid";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNKACD                  = "zrnkacd";
    public static final String ZRNTANTOCD               = "zrntantocd";
    public static final String ZRNSYORISOSIKICD         = "zrnsyorisosikicd";
    public static final String ZRNSHRTYSYSYURUICD       = "zrnshrtysysyuruicd";
    public static final String ZRNSYORITAISYOUKBN       = "zrnsyoritaisyoukbn";
    public static final String ZRNBAITAISKSHUNORIYUUKBN1 = "zrnbaitaiskshunoriyuukbn1";
    public static final String ZRNBAITAISKSHUNORIYUUKBN2 = "zrnbaitaiskshunoriyuukbn2";
    public static final String ZRNBAITAISKSHUNORIYUUKBN3 = "zrnbaitaiskshunoriyuukbn3";
    public static final String ZRNBAITAISKSHUNORIYUUKBN4 = "zrnbaitaiskshunoriyuukbn4";
    public static final String ZRNBAITAISKSHUNORIYUUKBN5 = "zrnbaitaiskshunoriyuukbn5";
    public static final String ZRNSHRTYSYJYUUSYOCD      = "zrnshrtysyjyuusyocd";
    public static final String ZRNSHRTYSYJYUUSYO        = "zrnshrtysyjyuusyo";
    public static final String ZRNKYKNMKJ35             = "zrnkyknmkj35";
    public static final String ZRNYOBIV3                = "zrnyobiv3";
    public static final String ZRNYOBIV25               = "zrnyobiv25";
    public static final String ZRNOLDKYKADRCD           = "zrnoldkykadrcd";
    public static final String ZRNKJOLDKYKADR           = "zrnkjoldkykadr";
    public static final String ZRNKJOLDKYKNM35          = "zrnkjoldkyknm35";
    public static final String ZRNYOBIV3X2              = "zrnyobiv3x2";
    public static final String ZRNYOBIV25X1             = "zrnyobiv25x1";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNYOBIV3X3              = "zrnyobiv3x3";
    public static final String ZRNYOBIV17               = "zrnyobiv17";
    public static final String ZRNKYKSIBOUYMD           = "zrnkyksibouymd";
    public static final String ZRNKOURYOKUHASSEIYMD     = "zrnkouryokuhasseiymd";
    public static final String ZRNKYKSIBOUMEIHENSYORIYMD = "zrnkyksiboumeihensyoriymd";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNYOBIV8X2              = "zrnyobiv8x2";
    public static final String ZRNYOBIV8X3              = "zrnyobiv8x3";
    public static final String ZRNYOBIV8X4              = "zrnyobiv8x4";
    public static final String ZRNKYKSIBOUHYOUKAGK      = "zrnkyksibouhyoukagk";
    public static final String ZRNKIHRKMP               = "zrnkihrkmp";
    public static final String ZRNOLDKYKKIHRKMPYOUHYJ   = "zrnoldkykkihrkmpyouhyj";
    public static final String ZRNOLDKYKKIHRKMP         = "zrnoldkykkihrkmp";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNSAKUSEIYMD            = "zrnsakuseiymd";
    public static final String ZRNHUHO2KYKDISP          = "zrnhuho2kykdisp";
    public static final String ZRNSHRTYSYHKNSYUKBN      = "zrnshrtysyhknsyukbn";
    public static final String ZRNYOBIV9                = "zrnyobiv9";
    public static final String ZRNTEKIYOURANHENSYUUKBN1 = "zrntekiyouranhensyuukbn1";
    public static final String ZRNTEKIYOURANHENSYUUKBN2 = "zrntekiyouranhensyuukbn2";
    public static final String ZRNTEKIYOURANHENSYUUKBN3 = "zrntekiyouranhensyuukbn3";
    public static final String ZRNTEKIYOURANHENSYUUKBN4 = "zrntekiyouranhensyuukbn4";
    public static final String ZRNTEKIYOURANHENSYUUKBN5 = "zrntekiyouranhensyuukbn5";
    public static final String ZRNYOBIV116              = "zrnyobiv116";

    private final PKZT_IdouTyousyoRn primaryKey;

    public GenZT_IdouTyousyoRn() {
        primaryKey = new PKZT_IdouTyousyoRn();
    }

    public GenZT_IdouTyousyoRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_IdouTyousyoRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_IdouTyousyoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_IdouTyousyoRn> getMetaClass() {
        return QZT_IdouTyousyoRn.class;
    }

    private String zrnsubsystemid;

    @Column(name=GenZT_IdouTyousyoRn.ZRNSUBSYSTEMID)
    public String getZrnsubsystemid() {
        return zrnsubsystemid;
    }

    public void setZrnsubsystemid(String pZrnsubsystemid) {
        zrnsubsystemid = pZrnsubsystemid;
    }

    @Id
    @Column(name=GenZT_IdouTyousyoRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnsyono;

    @Column(name=GenZT_IdouTyousyoRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_IdouTyousyoRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnkacd;

    @Column(name=GenZT_IdouTyousyoRn.ZRNKACD)
    public String getZrnkacd() {
        return zrnkacd;
    }

    public void setZrnkacd(String pZrnkacd) {
        zrnkacd = pZrnkacd;
    }

    private String zrntantocd;

    @Column(name=GenZT_IdouTyousyoRn.ZRNTANTOCD)
    public String getZrntantocd() {
        return zrntantocd;
    }

    public void setZrntantocd(String pZrntantocd) {
        zrntantocd = pZrntantocd;
    }

    private String zrnsyorisosikicd;

    @Column(name=GenZT_IdouTyousyoRn.ZRNSYORISOSIKICD)
    public String getZrnsyorisosikicd() {
        return zrnsyorisosikicd;
    }

    public void setZrnsyorisosikicd(String pZrnsyorisosikicd) {
        zrnsyorisosikicd = pZrnsyorisosikicd;
    }

    private String zrnshrtysysyuruicd;

    @Column(name=GenZT_IdouTyousyoRn.ZRNSHRTYSYSYURUICD)
    public String getZrnshrtysysyuruicd() {
        return zrnshrtysysyuruicd;
    }

    public void setZrnshrtysysyuruicd(String pZrnshrtysysyuruicd) {
        zrnshrtysysyuruicd = pZrnshrtysysyuruicd;
    }

    private String zrnsyoritaisyoukbn;

    @Column(name=GenZT_IdouTyousyoRn.ZRNSYORITAISYOUKBN)
    public String getZrnsyoritaisyoukbn() {
        return zrnsyoritaisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyoritaisyoukbn(String pZrnsyoritaisyoukbn) {
        zrnsyoritaisyoukbn = pZrnsyoritaisyoukbn;
    }

    private String zrnbaitaiskshunoriyuukbn1;

    @Column(name=GenZT_IdouTyousyoRn.ZRNBAITAISKSHUNORIYUUKBN1)
    public String getZrnbaitaiskshunoriyuukbn1() {
        return zrnbaitaiskshunoriyuukbn1;
    }

    public void setZrnbaitaiskshunoriyuukbn1(String pZrnbaitaiskshunoriyuukbn1) {
        zrnbaitaiskshunoriyuukbn1 = pZrnbaitaiskshunoriyuukbn1;
    }

    private String zrnbaitaiskshunoriyuukbn2;

    @Column(name=GenZT_IdouTyousyoRn.ZRNBAITAISKSHUNORIYUUKBN2)
    public String getZrnbaitaiskshunoriyuukbn2() {
        return zrnbaitaiskshunoriyuukbn2;
    }

    public void setZrnbaitaiskshunoriyuukbn2(String pZrnbaitaiskshunoriyuukbn2) {
        zrnbaitaiskshunoriyuukbn2 = pZrnbaitaiskshunoriyuukbn2;
    }

    private String zrnbaitaiskshunoriyuukbn3;

    @Column(name=GenZT_IdouTyousyoRn.ZRNBAITAISKSHUNORIYUUKBN3)
    public String getZrnbaitaiskshunoriyuukbn3() {
        return zrnbaitaiskshunoriyuukbn3;
    }

    public void setZrnbaitaiskshunoriyuukbn3(String pZrnbaitaiskshunoriyuukbn3) {
        zrnbaitaiskshunoriyuukbn3 = pZrnbaitaiskshunoriyuukbn3;
    }

    private String zrnbaitaiskshunoriyuukbn4;

    @Column(name=GenZT_IdouTyousyoRn.ZRNBAITAISKSHUNORIYUUKBN4)
    public String getZrnbaitaiskshunoriyuukbn4() {
        return zrnbaitaiskshunoriyuukbn4;
    }

    public void setZrnbaitaiskshunoriyuukbn4(String pZrnbaitaiskshunoriyuukbn4) {
        zrnbaitaiskshunoriyuukbn4 = pZrnbaitaiskshunoriyuukbn4;
    }

    private String zrnbaitaiskshunoriyuukbn5;

    @Column(name=GenZT_IdouTyousyoRn.ZRNBAITAISKSHUNORIYUUKBN5)
    public String getZrnbaitaiskshunoriyuukbn5() {
        return zrnbaitaiskshunoriyuukbn5;
    }

    public void setZrnbaitaiskshunoriyuukbn5(String pZrnbaitaiskshunoriyuukbn5) {
        zrnbaitaiskshunoriyuukbn5 = pZrnbaitaiskshunoriyuukbn5;
    }

    private String zrnshrtysyjyuusyocd;

    @Column(name=GenZT_IdouTyousyoRn.ZRNSHRTYSYJYUUSYOCD)
    public String getZrnshrtysyjyuusyocd() {
        return zrnshrtysyjyuusyocd;
    }

    public void setZrnshrtysyjyuusyocd(String pZrnshrtysyjyuusyocd) {
        zrnshrtysyjyuusyocd = pZrnshrtysyjyuusyocd;
    }

    private String zrnshrtysyjyuusyo;

    @Column(name=GenZT_IdouTyousyoRn.ZRNSHRTYSYJYUUSYO)
    public String getZrnshrtysyjyuusyo() {
        return zrnshrtysyjyuusyo;
    }

    @DataConvert("toMultiByte")
    public void setZrnshrtysyjyuusyo(String pZrnshrtysyjyuusyo) {
        zrnshrtysyjyuusyo = pZrnshrtysyjyuusyo;
    }

    private String zrnkyknmkj35;

    @Column(name=GenZT_IdouTyousyoRn.ZRNKYKNMKJ35)
    public String getZrnkyknmkj35() {
        return zrnkyknmkj35;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj35(String pZrnkyknmkj35) {
        zrnkyknmkj35 = pZrnkyknmkj35;
    }

    private String zrnyobiv3;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV3)
    public String getZrnyobiv3() {
        return zrnyobiv3;
    }

    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }

    private String zrnyobiv25;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV25)
    public String getZrnyobiv25() {
        return zrnyobiv25;
    }

    public void setZrnyobiv25(String pZrnyobiv25) {
        zrnyobiv25 = pZrnyobiv25;
    }

    private String zrnoldkykadrcd;

    @Column(name=GenZT_IdouTyousyoRn.ZRNOLDKYKADRCD)
    public String getZrnoldkykadrcd() {
        return zrnoldkykadrcd;
    }

    public void setZrnoldkykadrcd(String pZrnoldkykadrcd) {
        zrnoldkykadrcd = pZrnoldkykadrcd;
    }

    private String zrnkjoldkykadr;

    @Column(name=GenZT_IdouTyousyoRn.ZRNKJOLDKYKADR)
    public String getZrnkjoldkykadr() {
        return zrnkjoldkykadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjoldkykadr(String pZrnkjoldkykadr) {
        zrnkjoldkykadr = pZrnkjoldkykadr;
    }

    private String zrnkjoldkyknm35;

    @Column(name=GenZT_IdouTyousyoRn.ZRNKJOLDKYKNM35)
    public String getZrnkjoldkyknm35() {
        return zrnkjoldkyknm35;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjoldkyknm35(String pZrnkjoldkyknm35) {
        zrnkjoldkyknm35 = pZrnkjoldkyknm35;
    }

    private String zrnyobiv3x2;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV3X2)
    public String getZrnyobiv3x2() {
        return zrnyobiv3x2;
    }

    public void setZrnyobiv3x2(String pZrnyobiv3x2) {
        zrnyobiv3x2 = pZrnyobiv3x2;
    }

    private String zrnyobiv25x1;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV25X1)
    public String getZrnyobiv25x1() {
        return zrnyobiv25x1;
    }

    public void setZrnyobiv25x1(String pZrnyobiv25x1) {
        zrnyobiv25x1 = pZrnyobiv25x1;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_IdouTyousyoRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnyobiv3x3;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV3X3)
    public String getZrnyobiv3x3() {
        return zrnyobiv3x3;
    }

    public void setZrnyobiv3x3(String pZrnyobiv3x3) {
        zrnyobiv3x3 = pZrnyobiv3x3;
    }

    private String zrnyobiv17;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV17)
    public String getZrnyobiv17() {
        return zrnyobiv17;
    }

    public void setZrnyobiv17(String pZrnyobiv17) {
        zrnyobiv17 = pZrnyobiv17;
    }

    private String zrnkyksibouymd;

    @Column(name=GenZT_IdouTyousyoRn.ZRNKYKSIBOUYMD)
    public String getZrnkyksibouymd() {
        return zrnkyksibouymd;
    }

    public void setZrnkyksibouymd(String pZrnkyksibouymd) {
        zrnkyksibouymd = pZrnkyksibouymd;
    }

    private String zrnkouryokuhasseiymd;

    @Column(name=GenZT_IdouTyousyoRn.ZRNKOURYOKUHASSEIYMD)
    public String getZrnkouryokuhasseiymd() {
        return zrnkouryokuhasseiymd;
    }

    public void setZrnkouryokuhasseiymd(String pZrnkouryokuhasseiymd) {
        zrnkouryokuhasseiymd = pZrnkouryokuhasseiymd;
    }

    private String zrnkyksiboumeihensyoriymd;

    @Column(name=GenZT_IdouTyousyoRn.ZRNKYKSIBOUMEIHENSYORIYMD)
    public String getZrnkyksiboumeihensyoriymd() {
        return zrnkyksiboumeihensyoriymd;
    }

    public void setZrnkyksiboumeihensyoriymd(String pZrnkyksiboumeihensyoriymd) {
        zrnkyksiboumeihensyoriymd = pZrnkyksiboumeihensyoriymd;
    }

    private String zrnyobiv8;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    private String zrnyobiv8x2;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV8X2)
    public String getZrnyobiv8x2() {
        return zrnyobiv8x2;
    }

    public void setZrnyobiv8x2(String pZrnyobiv8x2) {
        zrnyobiv8x2 = pZrnyobiv8x2;
    }

    private String zrnyobiv8x3;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV8X3)
    public String getZrnyobiv8x3() {
        return zrnyobiv8x3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnyobiv8x3(String pZrnyobiv8x3) {
        zrnyobiv8x3 = pZrnyobiv8x3;
    }

    private String zrnyobiv8x4;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV8X4)
    public String getZrnyobiv8x4() {
        return zrnyobiv8x4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnyobiv8x4(String pZrnyobiv8x4) {
        zrnyobiv8x4 = pZrnyobiv8x4;
    }

    private Long zrnkyksibouhyoukagk;

    @Column(name=GenZT_IdouTyousyoRn.ZRNKYKSIBOUHYOUKAGK)
    public Long getZrnkyksibouhyoukagk() {
        return zrnkyksibouhyoukagk;
    }

    public void setZrnkyksibouhyoukagk(Long pZrnkyksibouhyoukagk) {
        zrnkyksibouhyoukagk = pZrnkyksibouhyoukagk;
    }

    private Long zrnkihrkmp;

    @Column(name=GenZT_IdouTyousyoRn.ZRNKIHRKMP)
    public Long getZrnkihrkmp() {
        return zrnkihrkmp;
    }

    public void setZrnkihrkmp(Long pZrnkihrkmp) {
        zrnkihrkmp = pZrnkihrkmp;
    }

    private String zrnoldkykkihrkmpyouhyj;

    @Column(name=GenZT_IdouTyousyoRn.ZRNOLDKYKKIHRKMPYOUHYJ)
    public String getZrnoldkykkihrkmpyouhyj() {
        return zrnoldkykkihrkmpyouhyj;
    }

    public void setZrnoldkykkihrkmpyouhyj(String pZrnoldkykkihrkmpyouhyj) {
        zrnoldkykkihrkmpyouhyj = pZrnoldkykkihrkmpyouhyj;
    }

    private Long zrnoldkykkihrkmp;

    @Column(name=GenZT_IdouTyousyoRn.ZRNOLDKYKKIHRKMP)
    public Long getZrnoldkykkihrkmp() {
        return zrnoldkykkihrkmp;
    }

    public void setZrnoldkykkihrkmp(Long pZrnoldkykkihrkmp) {
        zrnoldkykkihrkmp = pZrnoldkykkihrkmp;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private String zrnsakuseiymd;

    @Column(name=GenZT_IdouTyousyoRn.ZRNSAKUSEIYMD)
    public String getZrnsakuseiymd() {
        return zrnsakuseiymd;
    }

    public void setZrnsakuseiymd(String pZrnsakuseiymd) {
        zrnsakuseiymd = pZrnsakuseiymd;
    }

    private String zrnhuho2kykdisp;

    @Column(name=GenZT_IdouTyousyoRn.ZRNHUHO2KYKDISP)
    public String getZrnhuho2kykdisp() {
        return zrnhuho2kykdisp;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhuho2kykdisp(String pZrnhuho2kykdisp) {
        zrnhuho2kykdisp = pZrnhuho2kykdisp;
    }

    private String zrnshrtysyhknsyukbn;

    @Column(name=GenZT_IdouTyousyoRn.ZRNSHRTYSYHKNSYUKBN)
    public String getZrnshrtysyhknsyukbn() {
        return zrnshrtysyhknsyukbn;
    }

    @DataConvert("toMultiByte")
    public void setZrnshrtysyhknsyukbn(String pZrnshrtysyhknsyukbn) {
        zrnshrtysyhknsyukbn = pZrnshrtysyhknsyukbn;
    }

    private String zrnyobiv9;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private String zrntekiyouranhensyuukbn1;

    @Column(name=GenZT_IdouTyousyoRn.ZRNTEKIYOURANHENSYUUKBN1)
    public String getZrntekiyouranhensyuukbn1() {
        return zrntekiyouranhensyuukbn1;
    }

    public void setZrntekiyouranhensyuukbn1(String pZrntekiyouranhensyuukbn1) {
        zrntekiyouranhensyuukbn1 = pZrntekiyouranhensyuukbn1;
    }

    private String zrntekiyouranhensyuukbn2;

    @Column(name=GenZT_IdouTyousyoRn.ZRNTEKIYOURANHENSYUUKBN2)
    public String getZrntekiyouranhensyuukbn2() {
        return zrntekiyouranhensyuukbn2;
    }

    public void setZrntekiyouranhensyuukbn2(String pZrntekiyouranhensyuukbn2) {
        zrntekiyouranhensyuukbn2 = pZrntekiyouranhensyuukbn2;
    }

    private String zrntekiyouranhensyuukbn3;

    @Column(name=GenZT_IdouTyousyoRn.ZRNTEKIYOURANHENSYUUKBN3)
    public String getZrntekiyouranhensyuukbn3() {
        return zrntekiyouranhensyuukbn3;
    }

    public void setZrntekiyouranhensyuukbn3(String pZrntekiyouranhensyuukbn3) {
        zrntekiyouranhensyuukbn3 = pZrntekiyouranhensyuukbn3;
    }

    private String zrntekiyouranhensyuukbn4;

    @Column(name=GenZT_IdouTyousyoRn.ZRNTEKIYOURANHENSYUUKBN4)
    public String getZrntekiyouranhensyuukbn4() {
        return zrntekiyouranhensyuukbn4;
    }

    public void setZrntekiyouranhensyuukbn4(String pZrntekiyouranhensyuukbn4) {
        zrntekiyouranhensyuukbn4 = pZrntekiyouranhensyuukbn4;
    }

    private String zrntekiyouranhensyuukbn5;

    @Column(name=GenZT_IdouTyousyoRn.ZRNTEKIYOURANHENSYUUKBN5)
    public String getZrntekiyouranhensyuukbn5() {
        return zrntekiyouranhensyuukbn5;
    }

    public void setZrntekiyouranhensyuukbn5(String pZrntekiyouranhensyuukbn5) {
        zrntekiyouranhensyuukbn5 = pZrntekiyouranhensyuukbn5;
    }

    private String zrnyobiv116;

    @Column(name=GenZT_IdouTyousyoRn.ZRNYOBIV116)
    public String getZrnyobiv116() {
        return zrnyobiv116;
    }

    public void setZrnyobiv116(String pZrnyobiv116) {
        zrnyobiv116 = pZrnyobiv116;
    }
}