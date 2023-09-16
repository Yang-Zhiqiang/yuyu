package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_IdouTyousyoTy;
import yuyu.def.db.id.PKZT_IdouTyousyoTy;
import yuyu.def.db.meta.GenQZT_IdouTyousyoTy;
import yuyu.def.db.meta.QZT_IdouTyousyoTy;

/**
 * 異動調書テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_IdouTyousyoTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IdouTyousyoTy}</td><td colspan="3">異動調書テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysubsystemid ztysubsystemid}</td><td>（中継用）サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_IdouTyousyoTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykacd ztykacd}</td><td>（中継用）課コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantocd ztytantocd}</td><td>（中継用）担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorisosikicd ztysyorisosikicd}</td><td>（中継用）処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtysysyuruicd ztyshrtysysyuruicd}</td><td>（中継用）支払調書種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoritaisyoukbn ztysyoritaisyoukbn}</td><td>（中継用）処理対象区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybaitaiskshunoriyuukbn1 ztybaitaiskshunoriyuukbn1}</td><td>（中継用）媒体作成不能理由区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybaitaiskshunoriyuukbn2 ztybaitaiskshunoriyuukbn2}</td><td>（中継用）媒体作成不能理由区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybaitaiskshunoriyuukbn3 ztybaitaiskshunoriyuukbn3}</td><td>（中継用）媒体作成不能理由区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybaitaiskshunoriyuukbn4 ztybaitaiskshunoriyuukbn4}</td><td>（中継用）媒体作成不能理由区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybaitaiskshunoriyuukbn5 ztybaitaiskshunoriyuukbn5}</td><td>（中継用）媒体作成不能理由区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtysyjyuusyocd ztyshrtysyjyuusyocd}</td><td>（中継用）支払調書住所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtysyjyuusyo ztyshrtysyjyuusyo}</td><td>（中継用）支払調書住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj35 ztykyknmkj35}</td><td>（中継用）契約者名（漢字）（３５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3 ztyyobiv3}</td><td>（中継用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv25 ztyyobiv25}</td><td>（中継用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyoldkykadrcd ztyoldkykadrcd}</td><td>（中継用）旧契約者住所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjoldkykadr ztykjoldkykadr}</td><td>（中継用）漢字旧契約者住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjoldkyknm35 ztykjoldkyknm35}</td><td>（中継用）漢字旧契約者名（３５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3x2 ztyyobiv3x2}</td><td>（中継用）予備項目Ｖ３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv25x1 ztyyobiv25x1}</td><td>（中継用）予備項目Ｖ２５＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3x3 ztyyobiv3x3}</td><td>（中継用）予備項目Ｖ３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv17 ztyyobiv17}</td><td>（中継用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksibouymd ztykyksibouymd}</td><td>（中継用）契約者死亡年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouryokuhasseiymd ztykouryokuhasseiymd}</td><td>（中継用）効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksiboumeihensyoriymd ztykyksiboumeihensyoriymd}</td><td>（中継用）契約者死亡名義変更処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8 ztyyobiv8}</td><td>（中継用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x2 ztyyobiv8x2}</td><td>（中継用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x3 ztyyobiv8x3}</td><td>（中継用）予備項目Ｖ８＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x4 ztyyobiv8x4}</td><td>（中継用）予備項目Ｖ８＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksibouhyoukagk ztykyksibouhyoukagk}</td><td>（中継用）契約者死亡評価額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykihrkmp ztykihrkmp}</td><td>（中継用）既払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyoldkykkihrkmpyouhyj ztyoldkykkihrkmpyouhyj}</td><td>（中継用）旧契約者既払込保険料要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyoldkykkihrkmp ztyoldkykkihrkmp}</td><td>（中継用）旧契約者既払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysakuseiymd ztysakuseiymd}</td><td>（中継用）作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhuho2kykdisp ztyhuho2kykdisp}</td><td>（中継用）普保Ⅱ契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtysyhknsyukbn ztyshrtysyhknsyukbn}</td><td>（中継用）支払調書保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9 ztyyobiv9}</td><td>（中継用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyouranhensyuukbn1 ztytekiyouranhensyuukbn1}</td><td>（中継用）摘要欄編集区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyouranhensyuukbn2 ztytekiyouranhensyuukbn2}</td><td>（中継用）摘要欄編集区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyouranhensyuukbn3 ztytekiyouranhensyuukbn3}</td><td>（中継用）摘要欄編集区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyouranhensyuukbn4 ztytekiyouranhensyuukbn4}</td><td>（中継用）摘要欄編集区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyouranhensyuukbn5 ztytekiyouranhensyuukbn5}</td><td>（中継用）摘要欄編集区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv116 ztyyobiv116}</td><td>（中継用）予備項目Ｖ１１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_IdouTyousyoTy
 * @see     PKZT_IdouTyousyoTy
 * @see     QZT_IdouTyousyoTy
 * @see     GenQZT_IdouTyousyoTy
 */
@MappedSuperclass
@Table(name=GenZT_IdouTyousyoTy.TABLE_NAME)
@IdClass(value=PKZT_IdouTyousyoTy.class)
public abstract class GenZT_IdouTyousyoTy extends AbstractExDBEntity<ZT_IdouTyousyoTy, PKZT_IdouTyousyoTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_IdouTyousyoTy";
    public static final String ZTYSUBSYSTEMID           = "ztysubsystemid";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYKACD                  = "ztykacd";
    public static final String ZTYTANTOCD               = "ztytantocd";
    public static final String ZTYSYORISOSIKICD         = "ztysyorisosikicd";
    public static final String ZTYSHRTYSYSYURUICD       = "ztyshrtysysyuruicd";
    public static final String ZTYSYORITAISYOUKBN       = "ztysyoritaisyoukbn";
    public static final String ZTYBAITAISKSHUNORIYUUKBN1 = "ztybaitaiskshunoriyuukbn1";
    public static final String ZTYBAITAISKSHUNORIYUUKBN2 = "ztybaitaiskshunoriyuukbn2";
    public static final String ZTYBAITAISKSHUNORIYUUKBN3 = "ztybaitaiskshunoriyuukbn3";
    public static final String ZTYBAITAISKSHUNORIYUUKBN4 = "ztybaitaiskshunoriyuukbn4";
    public static final String ZTYBAITAISKSHUNORIYUUKBN5 = "ztybaitaiskshunoriyuukbn5";
    public static final String ZTYSHRTYSYJYUUSYOCD      = "ztyshrtysyjyuusyocd";
    public static final String ZTYSHRTYSYJYUUSYO        = "ztyshrtysyjyuusyo";
    public static final String ZTYKYKNMKJ35             = "ztykyknmkj35";
    public static final String ZTYYOBIV3                = "ztyyobiv3";
    public static final String ZTYYOBIV25               = "ztyyobiv25";
    public static final String ZTYOLDKYKADRCD           = "ztyoldkykadrcd";
    public static final String ZTYKJOLDKYKADR           = "ztykjoldkykadr";
    public static final String ZTYKJOLDKYKNM35          = "ztykjoldkyknm35";
    public static final String ZTYYOBIV3X2              = "ztyyobiv3x2";
    public static final String ZTYYOBIV25X1             = "ztyyobiv25x1";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYYOBIV3X3              = "ztyyobiv3x3";
    public static final String ZTYYOBIV17               = "ztyyobiv17";
    public static final String ZTYKYKSIBOUYMD           = "ztykyksibouymd";
    public static final String ZTYKOURYOKUHASSEIYMD     = "ztykouryokuhasseiymd";
    public static final String ZTYKYKSIBOUMEIHENSYORIYMD = "ztykyksiboumeihensyoriymd";
    public static final String ZTYYOBIV8                = "ztyyobiv8";
    public static final String ZTYYOBIV8X2              = "ztyyobiv8x2";
    public static final String ZTYYOBIV8X3              = "ztyyobiv8x3";
    public static final String ZTYYOBIV8X4              = "ztyyobiv8x4";
    public static final String ZTYKYKSIBOUHYOUKAGK      = "ztykyksibouhyoukagk";
    public static final String ZTYKIHRKMP               = "ztykihrkmp";
    public static final String ZTYOLDKYKKIHRKMPYOUHYJ   = "ztyoldkykkihrkmpyouhyj";
    public static final String ZTYOLDKYKKIHRKMP         = "ztyoldkykkihrkmp";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYSAKUSEIYMD            = "ztysakuseiymd";
    public static final String ZTYHUHO2KYKDISP          = "ztyhuho2kykdisp";
    public static final String ZTYSHRTYSYHKNSYUKBN      = "ztyshrtysyhknsyukbn";
    public static final String ZTYYOBIV9                = "ztyyobiv9";
    public static final String ZTYTEKIYOURANHENSYUUKBN1 = "ztytekiyouranhensyuukbn1";
    public static final String ZTYTEKIYOURANHENSYUUKBN2 = "ztytekiyouranhensyuukbn2";
    public static final String ZTYTEKIYOURANHENSYUUKBN3 = "ztytekiyouranhensyuukbn3";
    public static final String ZTYTEKIYOURANHENSYUUKBN4 = "ztytekiyouranhensyuukbn4";
    public static final String ZTYTEKIYOURANHENSYUUKBN5 = "ztytekiyouranhensyuukbn5";
    public static final String ZTYYOBIV116              = "ztyyobiv116";

    private final PKZT_IdouTyousyoTy primaryKey;

    public GenZT_IdouTyousyoTy() {
        primaryKey = new PKZT_IdouTyousyoTy();
    }

    public GenZT_IdouTyousyoTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_IdouTyousyoTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_IdouTyousyoTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_IdouTyousyoTy> getMetaClass() {
        return QZT_IdouTyousyoTy.class;
    }

    private String ztysubsystemid;

    @Column(name=GenZT_IdouTyousyoTy.ZTYSUBSYSTEMID)
    public String getZtysubsystemid() {
        return ztysubsystemid;
    }

    public void setZtysubsystemid(String pZtysubsystemid) {
        ztysubsystemid = pZtysubsystemid;
    }

    @Id
    @Column(name=GenZT_IdouTyousyoTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztysyono;

    @Column(name=GenZT_IdouTyousyoTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_IdouTyousyoTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztykacd;

    @Column(name=GenZT_IdouTyousyoTy.ZTYKACD)
    public String getZtykacd() {
        return ztykacd;
    }

    public void setZtykacd(String pZtykacd) {
        ztykacd = pZtykacd;
    }

    private String ztytantocd;

    @Column(name=GenZT_IdouTyousyoTy.ZTYTANTOCD)
    public String getZtytantocd() {
        return ztytantocd;
    }

    public void setZtytantocd(String pZtytantocd) {
        ztytantocd = pZtytantocd;
    }

    private String ztysyorisosikicd;

    @Column(name=GenZT_IdouTyousyoTy.ZTYSYORISOSIKICD)
    public String getZtysyorisosikicd() {
        return ztysyorisosikicd;
    }

    public void setZtysyorisosikicd(String pZtysyorisosikicd) {
        ztysyorisosikicd = pZtysyorisosikicd;
    }

    private String ztyshrtysysyuruicd;

    @Column(name=GenZT_IdouTyousyoTy.ZTYSHRTYSYSYURUICD)
    public String getZtyshrtysysyuruicd() {
        return ztyshrtysysyuruicd;
    }

    public void setZtyshrtysysyuruicd(String pZtyshrtysysyuruicd) {
        ztyshrtysysyuruicd = pZtyshrtysysyuruicd;
    }

    private String ztysyoritaisyoukbn;

    @Column(name=GenZT_IdouTyousyoTy.ZTYSYORITAISYOUKBN)
    public String getZtysyoritaisyoukbn() {
        return ztysyoritaisyoukbn;
    }

    public void setZtysyoritaisyoukbn(String pZtysyoritaisyoukbn) {
        ztysyoritaisyoukbn = pZtysyoritaisyoukbn;
    }

    private String ztybaitaiskshunoriyuukbn1;

    @Column(name=GenZT_IdouTyousyoTy.ZTYBAITAISKSHUNORIYUUKBN1)
    public String getZtybaitaiskshunoriyuukbn1() {
        return ztybaitaiskshunoriyuukbn1;
    }

    public void setZtybaitaiskshunoriyuukbn1(String pZtybaitaiskshunoriyuukbn1) {
        ztybaitaiskshunoriyuukbn1 = pZtybaitaiskshunoriyuukbn1;
    }

    private String ztybaitaiskshunoriyuukbn2;

    @Column(name=GenZT_IdouTyousyoTy.ZTYBAITAISKSHUNORIYUUKBN2)
    public String getZtybaitaiskshunoriyuukbn2() {
        return ztybaitaiskshunoriyuukbn2;
    }

    public void setZtybaitaiskshunoriyuukbn2(String pZtybaitaiskshunoriyuukbn2) {
        ztybaitaiskshunoriyuukbn2 = pZtybaitaiskshunoriyuukbn2;
    }

    private String ztybaitaiskshunoriyuukbn3;

    @Column(name=GenZT_IdouTyousyoTy.ZTYBAITAISKSHUNORIYUUKBN3)
    public String getZtybaitaiskshunoriyuukbn3() {
        return ztybaitaiskshunoriyuukbn3;
    }

    public void setZtybaitaiskshunoriyuukbn3(String pZtybaitaiskshunoriyuukbn3) {
        ztybaitaiskshunoriyuukbn3 = pZtybaitaiskshunoriyuukbn3;
    }

    private String ztybaitaiskshunoriyuukbn4;

    @Column(name=GenZT_IdouTyousyoTy.ZTYBAITAISKSHUNORIYUUKBN4)
    public String getZtybaitaiskshunoriyuukbn4() {
        return ztybaitaiskshunoriyuukbn4;
    }

    public void setZtybaitaiskshunoriyuukbn4(String pZtybaitaiskshunoriyuukbn4) {
        ztybaitaiskshunoriyuukbn4 = pZtybaitaiskshunoriyuukbn4;
    }

    private String ztybaitaiskshunoriyuukbn5;

    @Column(name=GenZT_IdouTyousyoTy.ZTYBAITAISKSHUNORIYUUKBN5)
    public String getZtybaitaiskshunoriyuukbn5() {
        return ztybaitaiskshunoriyuukbn5;
    }

    public void setZtybaitaiskshunoriyuukbn5(String pZtybaitaiskshunoriyuukbn5) {
        ztybaitaiskshunoriyuukbn5 = pZtybaitaiskshunoriyuukbn5;
    }

    private String ztyshrtysyjyuusyocd;

    @Column(name=GenZT_IdouTyousyoTy.ZTYSHRTYSYJYUUSYOCD)
    public String getZtyshrtysyjyuusyocd() {
        return ztyshrtysyjyuusyocd;
    }

    public void setZtyshrtysyjyuusyocd(String pZtyshrtysyjyuusyocd) {
        ztyshrtysyjyuusyocd = pZtyshrtysyjyuusyocd;
    }

    private String ztyshrtysyjyuusyo;

    @Column(name=GenZT_IdouTyousyoTy.ZTYSHRTYSYJYUUSYO)
    public String getZtyshrtysyjyuusyo() {
        return ztyshrtysyjyuusyo;
    }

    public void setZtyshrtysyjyuusyo(String pZtyshrtysyjyuusyo) {
        ztyshrtysyjyuusyo = pZtyshrtysyjyuusyo;
    }

    private String ztykyknmkj35;

    @Column(name=GenZT_IdouTyousyoTy.ZTYKYKNMKJ35)
    public String getZtykyknmkj35() {
        return ztykyknmkj35;
    }

    @DataConvert("toMultiByte")
    public void setZtykyknmkj35(String pZtykyknmkj35) {
        ztykyknmkj35 = pZtykyknmkj35;
    }

    private String ztyyobiv3;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }

    private String ztyyobiv25;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV25)
    public String getZtyyobiv25() {
        return ztyyobiv25;
    }

    public void setZtyyobiv25(String pZtyyobiv25) {
        ztyyobiv25 = pZtyyobiv25;
    }

    private String ztyoldkykadrcd;

    @Column(name=GenZT_IdouTyousyoTy.ZTYOLDKYKADRCD)
    public String getZtyoldkykadrcd() {
        return ztyoldkykadrcd;
    }

    public void setZtyoldkykadrcd(String pZtyoldkykadrcd) {
        ztyoldkykadrcd = pZtyoldkykadrcd;
    }

    private String ztykjoldkykadr;

    @Column(name=GenZT_IdouTyousyoTy.ZTYKJOLDKYKADR)
    public String getZtykjoldkykadr() {
        return ztykjoldkykadr;
    }

    public void setZtykjoldkykadr(String pZtykjoldkykadr) {
        ztykjoldkykadr = pZtykjoldkykadr;
    }

    private String ztykjoldkyknm35;

    @Column(name=GenZT_IdouTyousyoTy.ZTYKJOLDKYKNM35)
    public String getZtykjoldkyknm35() {
        return ztykjoldkyknm35;
    }

    public void setZtykjoldkyknm35(String pZtykjoldkyknm35) {
        ztykjoldkyknm35 = pZtykjoldkyknm35;
    }

    private String ztyyobiv3x2;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV3X2)
    public String getZtyyobiv3x2() {
        return ztyyobiv3x2;
    }

    public void setZtyyobiv3x2(String pZtyyobiv3x2) {
        ztyyobiv3x2 = pZtyyobiv3x2;
    }

    private String ztyyobiv25x1;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV25X1)
    public String getZtyyobiv25x1() {
        return ztyyobiv25x1;
    }

    public void setZtyyobiv25x1(String pZtyyobiv25x1) {
        ztyyobiv25x1 = pZtyyobiv25x1;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_IdouTyousyoTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztyyobiv3x3;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV3X3)
    public String getZtyyobiv3x3() {
        return ztyyobiv3x3;
    }

    public void setZtyyobiv3x3(String pZtyyobiv3x3) {
        ztyyobiv3x3 = pZtyyobiv3x3;
    }

    private String ztyyobiv17;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV17)
    public String getZtyyobiv17() {
        return ztyyobiv17;
    }

    public void setZtyyobiv17(String pZtyyobiv17) {
        ztyyobiv17 = pZtyyobiv17;
    }

    private String ztykyksibouymd;

    @Column(name=GenZT_IdouTyousyoTy.ZTYKYKSIBOUYMD)
    public String getZtykyksibouymd() {
        return ztykyksibouymd;
    }

    public void setZtykyksibouymd(String pZtykyksibouymd) {
        ztykyksibouymd = pZtykyksibouymd;
    }

    private String ztykouryokuhasseiymd;

    @Column(name=GenZT_IdouTyousyoTy.ZTYKOURYOKUHASSEIYMD)
    public String getZtykouryokuhasseiymd() {
        return ztykouryokuhasseiymd;
    }

    public void setZtykouryokuhasseiymd(String pZtykouryokuhasseiymd) {
        ztykouryokuhasseiymd = pZtykouryokuhasseiymd;
    }

    private String ztykyksiboumeihensyoriymd;

    @Column(name=GenZT_IdouTyousyoTy.ZTYKYKSIBOUMEIHENSYORIYMD)
    public String getZtykyksiboumeihensyoriymd() {
        return ztykyksiboumeihensyoriymd;
    }

    public void setZtykyksiboumeihensyoriymd(String pZtykyksiboumeihensyoriymd) {
        ztykyksiboumeihensyoriymd = pZtykyksiboumeihensyoriymd;
    }

    private String ztyyobiv8;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV8)
    public String getZtyyobiv8() {
        return ztyyobiv8;
    }

    public void setZtyyobiv8(String pZtyyobiv8) {
        ztyyobiv8 = pZtyyobiv8;
    }

    private String ztyyobiv8x2;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV8X2)
    public String getZtyyobiv8x2() {
        return ztyyobiv8x2;
    }

    public void setZtyyobiv8x2(String pZtyyobiv8x2) {
        ztyyobiv8x2 = pZtyyobiv8x2;
    }

    private String ztyyobiv8x3;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV8X3)
    public String getZtyyobiv8x3() {
        return ztyyobiv8x3;
    }

    public void setZtyyobiv8x3(String pZtyyobiv8x3) {
        ztyyobiv8x3 = pZtyyobiv8x3;
    }

    private String ztyyobiv8x4;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV8X4)
    public String getZtyyobiv8x4() {
        return ztyyobiv8x4;
    }

    public void setZtyyobiv8x4(String pZtyyobiv8x4) {
        ztyyobiv8x4 = pZtyyobiv8x4;
    }

    private Long ztykyksibouhyoukagk;

    @Column(name=GenZT_IdouTyousyoTy.ZTYKYKSIBOUHYOUKAGK)
    public Long getZtykyksibouhyoukagk() {
        return ztykyksibouhyoukagk;
    }

    public void setZtykyksibouhyoukagk(Long pZtykyksibouhyoukagk) {
        ztykyksibouhyoukagk = pZtykyksibouhyoukagk;
    }

    private Long ztykihrkmp;

    @Column(name=GenZT_IdouTyousyoTy.ZTYKIHRKMP)
    public Long getZtykihrkmp() {
        return ztykihrkmp;
    }

    public void setZtykihrkmp(Long pZtykihrkmp) {
        ztykihrkmp = pZtykihrkmp;
    }

    private String ztyoldkykkihrkmpyouhyj;

    @Column(name=GenZT_IdouTyousyoTy.ZTYOLDKYKKIHRKMPYOUHYJ)
    public String getZtyoldkykkihrkmpyouhyj() {
        return ztyoldkykkihrkmpyouhyj;
    }

    public void setZtyoldkykkihrkmpyouhyj(String pZtyoldkykkihrkmpyouhyj) {
        ztyoldkykkihrkmpyouhyj = pZtyoldkykkihrkmpyouhyj;
    }

    private Long ztyoldkykkihrkmp;

    @Column(name=GenZT_IdouTyousyoTy.ZTYOLDKYKKIHRKMP)
    public Long getZtyoldkykkihrkmp() {
        return ztyoldkykkihrkmp;
    }

    public void setZtyoldkykkihrkmp(Long pZtyoldkykkihrkmp) {
        ztyoldkykkihrkmp = pZtyoldkykkihrkmp;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private String ztysakuseiymd;

    @Column(name=GenZT_IdouTyousyoTy.ZTYSAKUSEIYMD)
    public String getZtysakuseiymd() {
        return ztysakuseiymd;
    }

    public void setZtysakuseiymd(String pZtysakuseiymd) {
        ztysakuseiymd = pZtysakuseiymd;
    }

    private String ztyhuho2kykdisp;

    @Column(name=GenZT_IdouTyousyoTy.ZTYHUHO2KYKDISP)
    public String getZtyhuho2kykdisp() {
        return ztyhuho2kykdisp;
    }

    public void setZtyhuho2kykdisp(String pZtyhuho2kykdisp) {
        ztyhuho2kykdisp = pZtyhuho2kykdisp;
    }

    private String ztyshrtysyhknsyukbn;

    @Column(name=GenZT_IdouTyousyoTy.ZTYSHRTYSYHKNSYUKBN)
    public String getZtyshrtysyhknsyukbn() {
        return ztyshrtysyhknsyukbn;
    }

    public void setZtyshrtysyhknsyukbn(String pZtyshrtysyhknsyukbn) {
        ztyshrtysyhknsyukbn = pZtyshrtysyhknsyukbn;
    }

    private String ztyyobiv9;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private String ztytekiyouranhensyuukbn1;

    @Column(name=GenZT_IdouTyousyoTy.ZTYTEKIYOURANHENSYUUKBN1)
    public String getZtytekiyouranhensyuukbn1() {
        return ztytekiyouranhensyuukbn1;
    }

    public void setZtytekiyouranhensyuukbn1(String pZtytekiyouranhensyuukbn1) {
        ztytekiyouranhensyuukbn1 = pZtytekiyouranhensyuukbn1;
    }

    private String ztytekiyouranhensyuukbn2;

    @Column(name=GenZT_IdouTyousyoTy.ZTYTEKIYOURANHENSYUUKBN2)
    public String getZtytekiyouranhensyuukbn2() {
        return ztytekiyouranhensyuukbn2;
    }

    public void setZtytekiyouranhensyuukbn2(String pZtytekiyouranhensyuukbn2) {
        ztytekiyouranhensyuukbn2 = pZtytekiyouranhensyuukbn2;
    }

    private String ztytekiyouranhensyuukbn3;

    @Column(name=GenZT_IdouTyousyoTy.ZTYTEKIYOURANHENSYUUKBN3)
    public String getZtytekiyouranhensyuukbn3() {
        return ztytekiyouranhensyuukbn3;
    }

    public void setZtytekiyouranhensyuukbn3(String pZtytekiyouranhensyuukbn3) {
        ztytekiyouranhensyuukbn3 = pZtytekiyouranhensyuukbn3;
    }

    private String ztytekiyouranhensyuukbn4;

    @Column(name=GenZT_IdouTyousyoTy.ZTYTEKIYOURANHENSYUUKBN4)
    public String getZtytekiyouranhensyuukbn4() {
        return ztytekiyouranhensyuukbn4;
    }

    public void setZtytekiyouranhensyuukbn4(String pZtytekiyouranhensyuukbn4) {
        ztytekiyouranhensyuukbn4 = pZtytekiyouranhensyuukbn4;
    }

    private String ztytekiyouranhensyuukbn5;

    @Column(name=GenZT_IdouTyousyoTy.ZTYTEKIYOURANHENSYUUKBN5)
    public String getZtytekiyouranhensyuukbn5() {
        return ztytekiyouranhensyuukbn5;
    }

    public void setZtytekiyouranhensyuukbn5(String pZtytekiyouranhensyuukbn5) {
        ztytekiyouranhensyuukbn5 = pZtytekiyouranhensyuukbn5;
    }

    private String ztyyobiv116;

    @Column(name=GenZT_IdouTyousyoTy.ZTYYOBIV116)
    public String getZtyyobiv116() {
        return ztyyobiv116;
    }

    public void setZtyyobiv116(String pZtyyobiv116) {
        ztyyobiv116 = pZtyyobiv116;
    }
}