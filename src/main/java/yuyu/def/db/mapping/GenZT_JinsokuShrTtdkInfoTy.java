package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.id.PKZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.meta.GenQZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.meta.QZT_JinsokuShrTtdkInfoTy;

/**
 * 迅速支払手続情報テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_JinsokuShrTtdkInfoTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_JinsokuShrTtdkInfoTy}</td><td colspan="3">迅速支払手続情報テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyorisosikicd ztysyorisosikicd}</td><td>（中継用）処理組織コード</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknknshrsntkno ztyhknknshrsntkno}</td><td>（中継用）保険金支払処理選択番号</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoruiukeymd ztysyoruiukeymd}</td><td>（中継用）書類受付日</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoriymd ztysyoriymd}</td><td>（中継用）処理年月日</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydenymd ztydenymd}</td><td>（中継用）伝票日付</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoruikeikaeigyoubisuu ztysyoruikeikaeigyoubisuu}</td><td>（中継用）書類受付経過営業日数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorikeikaeigyoubisuu ztysyorikeikaeigyoubisuu}</td><td>（中継用）処理経過営業日数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoritugisosikicd ztytoritugisosikicd}</td><td>（中継用）取次組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytanmatusyuruikbn ztytanmatusyuruikbn}</td><td>（中継用）端末種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuymd ztykeiyakuymd}</td><td>（中継用）契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_JinsokuShrTtdkInfoTy
 * @see     PKZT_JinsokuShrTtdkInfoTy
 * @see     QZT_JinsokuShrTtdkInfoTy
 * @see     GenQZT_JinsokuShrTtdkInfoTy
 */
@MappedSuperclass
@Table(name=GenZT_JinsokuShrTtdkInfoTy.TABLE_NAME)
@IdClass(value=PKZT_JinsokuShrTtdkInfoTy.class)
public abstract class GenZT_JinsokuShrTtdkInfoTy extends AbstractExDBEntity<ZT_JinsokuShrTtdkInfoTy, PKZT_JinsokuShrTtdkInfoTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_JinsokuShrTtdkInfoTy";
    public static final String ZTYSYORISOSIKICD         = "ztysyorisosikicd";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYHKNKNSHRSNTKNO        = "ztyhknknshrsntkno";
    public static final String ZTYSYORUIUKEYMD          = "ztysyoruiukeymd";
    public static final String ZTYSYORIYMD              = "ztysyoriymd";
    public static final String ZTYDENYMD                = "ztydenymd";
    public static final String ZTYSYORUIKEIKAEIGYOUBISUU = "ztysyoruikeikaeigyoubisuu";
    public static final String ZTYSYORIKEIKAEIGYOUBISUU = "ztysyorikeikaeigyoubisuu";
    public static final String ZTYTORITUGISOSIKICD      = "ztytoritugisosikicd";
    public static final String ZTYTANMATUSYURUIKBN      = "ztytanmatusyuruikbn";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYKEIYAKUYMD            = "ztykeiyakuymd";

    private final PKZT_JinsokuShrTtdkInfoTy primaryKey;

    public GenZT_JinsokuShrTtdkInfoTy() {
        primaryKey = new PKZT_JinsokuShrTtdkInfoTy();
    }

    public GenZT_JinsokuShrTtdkInfoTy(
        String pZtysyorisosikicd,
        String pZtysyoricd,
        String pZtyhknknshrsntkno,
        String pZtysyoruiukeymd,
        String pZtysyoriymd,
        String pZtydenymd,
        String pZtysyono
    ) {
        primaryKey = new PKZT_JinsokuShrTtdkInfoTy(
            pZtysyorisosikicd,
            pZtysyoricd,
            pZtyhknknshrsntkno,
            pZtysyoruiukeymd,
            pZtysyoriymd,
            pZtydenymd,
            pZtysyono
        );
    }

    @Transient
    @Override
    public PKZT_JinsokuShrTtdkInfoTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_JinsokuShrTtdkInfoTy> getMetaClass() {
        return QZT_JinsokuShrTtdkInfoTy.class;
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYSYORISOSIKICD)
    public String getZtysyorisosikicd() {
        return getPrimaryKey().getZtysyorisosikicd();
    }

    public void setZtysyorisosikicd(String pZtysyorisosikicd) {
        getPrimaryKey().setZtysyorisosikicd(pZtysyorisosikicd);
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return getPrimaryKey().getZtysyoricd();
    }

    public void setZtysyoricd(String pZtysyoricd) {
        getPrimaryKey().setZtysyoricd(pZtysyoricd);
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYHKNKNSHRSNTKNO)
    public String getZtyhknknshrsntkno() {
        return getPrimaryKey().getZtyhknknshrsntkno();
    }

    public void setZtyhknknshrsntkno(String pZtyhknknshrsntkno) {
        getPrimaryKey().setZtyhknknshrsntkno(pZtyhknknshrsntkno);
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYSYORUIUKEYMD)
    public String getZtysyoruiukeymd() {
        return getPrimaryKey().getZtysyoruiukeymd();
    }

    public void setZtysyoruiukeymd(String pZtysyoruiukeymd) {
        getPrimaryKey().setZtysyoruiukeymd(pZtysyoruiukeymd);
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYSYORIYMD)
    public String getZtysyoriymd() {
        return getPrimaryKey().getZtysyoriymd();
    }

    public void setZtysyoriymd(String pZtysyoriymd) {
        getPrimaryKey().setZtysyoriymd(pZtysyoriymd);
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYDENYMD)
    public String getZtydenymd() {
        return getPrimaryKey().getZtydenymd();
    }

    public void setZtydenymd(String pZtydenymd) {
        getPrimaryKey().setZtydenymd(pZtydenymd);
    }

    private String ztysyoruikeikaeigyoubisuu;

    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYSYORUIKEIKAEIGYOUBISUU)
    public String getZtysyoruikeikaeigyoubisuu() {
        return ztysyoruikeikaeigyoubisuu;
    }

    public void setZtysyoruikeikaeigyoubisuu(String pZtysyoruikeikaeigyoubisuu) {
        ztysyoruikeikaeigyoubisuu = pZtysyoruikeikaeigyoubisuu;
    }

    private String ztysyorikeikaeigyoubisuu;

    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYSYORIKEIKAEIGYOUBISUU)
    public String getZtysyorikeikaeigyoubisuu() {
        return ztysyorikeikaeigyoubisuu;
    }

    public void setZtysyorikeikaeigyoubisuu(String pZtysyorikeikaeigyoubisuu) {
        ztysyorikeikaeigyoubisuu = pZtysyorikeikaeigyoubisuu;
    }

    private String ztytoritugisosikicd;

    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYTORITUGISOSIKICD)
    public String getZtytoritugisosikicd() {
        return ztytoritugisosikicd;
    }

    public void setZtytoritugisosikicd(String pZtytoritugisosikicd) {
        ztytoritugisosikicd = pZtytoritugisosikicd;
    }

    private String ztytanmatusyuruikbn;

    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYTANMATUSYURUIKBN)
    public String getZtytanmatusyuruikbn() {
        return ztytanmatusyuruikbn;
    }

    public void setZtytanmatusyuruikbn(String pZtytanmatusyuruikbn) {
        ztytanmatusyuruikbn = pZtytanmatusyuruikbn;
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztykeiyakuymd;

    @Column(name=GenZT_JinsokuShrTtdkInfoTy.ZTYKEIYAKUYMD)
    public String getZtykeiyakuymd() {
        return ztykeiyakuymd;
    }

    public void setZtykeiyakuymd(String pZtykeiyakuymd) {
        ztykeiyakuymd = pZtykeiyakuymd;
    }
}
