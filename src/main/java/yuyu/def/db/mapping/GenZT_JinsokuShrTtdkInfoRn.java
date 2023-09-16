package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.id.PKZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.meta.GenQZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.meta.QZT_JinsokuShrTtdkInfoRn;

/**
 * 迅速支払手続情報テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_JinsokuShrTtdkInfoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_JinsokuShrTtdkInfoRn}</td><td colspan="3">迅速支払手続情報テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyorisosikicd zrnsyorisosikicd}</td><td>（連携用）処理組織コード</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknknshrsntkno zrnhknknshrsntkno}</td><td>（連携用）保険金支払処理選択番号</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoruiukeymd zrnsyoruiukeymd}</td><td>（連携用）書類受付日</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndenymd zrndenymd}</td><td>（連携用）伝票日付</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoruikeikaeigyoubisuu zrnsyoruikeikaeigyoubisuu}</td><td>（連携用）書類受付経過営業日数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorikeikaeigyoubisuu zrnsyorikeikaeigyoubisuu}</td><td>（連携用）処理経過営業日数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoritugisosikicd zrntoritugisosikicd}</td><td>（連携用）取次組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntanmatusyuruikbn zrntanmatusyuruikbn}</td><td>（連携用）端末種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_JinsokuShrTtdkInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuymd zrnkeiyakuymd}</td><td>（連携用）契約日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_JinsokuShrTtdkInfoRn
 * @see     PKZT_JinsokuShrTtdkInfoRn
 * @see     QZT_JinsokuShrTtdkInfoRn
 * @see     GenQZT_JinsokuShrTtdkInfoRn
 */
@MappedSuperclass
@Table(name=GenZT_JinsokuShrTtdkInfoRn.TABLE_NAME)
@IdClass(value=PKZT_JinsokuShrTtdkInfoRn.class)
public abstract class GenZT_JinsokuShrTtdkInfoRn extends AbstractExDBEntityForZDB<ZT_JinsokuShrTtdkInfoRn, PKZT_JinsokuShrTtdkInfoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_JinsokuShrTtdkInfoRn";
    public static final String ZRNSYORISOSIKICD         = "zrnsyorisosikicd";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNHKNKNSHRSNTKNO        = "zrnhknknshrsntkno";
    public static final String ZRNSYORUIUKEYMD          = "zrnsyoruiukeymd";
    public static final String ZRNSYORIYMD              = "zrnsyoriymd";
    public static final String ZRNDENYMD                = "zrndenymd";
    public static final String ZRNSYORUIKEIKAEIGYOUBISUU = "zrnsyoruikeikaeigyoubisuu";
    public static final String ZRNSYORIKEIKAEIGYOUBISUU = "zrnsyorikeikaeigyoubisuu";
    public static final String ZRNTORITUGISOSIKICD      = "zrntoritugisosikicd";
    public static final String ZRNTANMATUSYURUIKBN      = "zrntanmatusyuruikbn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNKEIYAKUYMD            = "zrnkeiyakuymd";

    private final PKZT_JinsokuShrTtdkInfoRn primaryKey;

    public GenZT_JinsokuShrTtdkInfoRn() {
        primaryKey = new PKZT_JinsokuShrTtdkInfoRn();
    }

    public GenZT_JinsokuShrTtdkInfoRn(
        String pZrnsyorisosikicd,
        String pZrnsyoricd,
        String pZrnhknknshrsntkno,
        String pZrnsyoruiukeymd,
        String pZrnsyoriymd,
        String pZrndenymd,
        String pZrnsyono
    ) {
        primaryKey = new PKZT_JinsokuShrTtdkInfoRn(
            pZrnsyorisosikicd,
            pZrnsyoricd,
            pZrnhknknshrsntkno,
            pZrnsyoruiukeymd,
            pZrnsyoriymd,
            pZrndenymd,
            pZrnsyono
        );
    }

    @Transient
    @Override
    public PKZT_JinsokuShrTtdkInfoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_JinsokuShrTtdkInfoRn> getMetaClass() {
        return QZT_JinsokuShrTtdkInfoRn.class;
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNSYORISOSIKICD)
    public String getZrnsyorisosikicd() {
        return getPrimaryKey().getZrnsyorisosikicd();
    }

    public void setZrnsyorisosikicd(String pZrnsyorisosikicd) {
        getPrimaryKey().setZrnsyorisosikicd(pZrnsyorisosikicd);
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return getPrimaryKey().getZrnsyoricd();
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        getPrimaryKey().setZrnsyoricd(pZrnsyoricd);
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNHKNKNSHRSNTKNO)
    public String getZrnhknknshrsntkno() {
        return getPrimaryKey().getZrnhknknshrsntkno();
    }

    public void setZrnhknknshrsntkno(String pZrnhknknshrsntkno) {
        getPrimaryKey().setZrnhknknshrsntkno(pZrnhknknshrsntkno);
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNSYORUIUKEYMD)
    public String getZrnsyoruiukeymd() {
        return getPrimaryKey().getZrnsyoruiukeymd();
    }

    public void setZrnsyoruiukeymd(String pZrnsyoruiukeymd) {
        getPrimaryKey().setZrnsyoruiukeymd(pZrnsyoruiukeymd);
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNSYORIYMD)
    public String getZrnsyoriymd() {
        return getPrimaryKey().getZrnsyoriymd();
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        getPrimaryKey().setZrnsyoriymd(pZrnsyoriymd);
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNDENYMD)
    public String getZrndenymd() {
        return getPrimaryKey().getZrndenymd();
    }

    public void setZrndenymd(String pZrndenymd) {
        getPrimaryKey().setZrndenymd(pZrndenymd);
    }

    private String zrnsyoruikeikaeigyoubisuu;

    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNSYORUIKEIKAEIGYOUBISUU)
    public String getZrnsyoruikeikaeigyoubisuu() {
        return zrnsyoruikeikaeigyoubisuu;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyoruikeikaeigyoubisuu(String pZrnsyoruikeikaeigyoubisuu) {
        zrnsyoruikeikaeigyoubisuu = pZrnsyoruikeikaeigyoubisuu;
    }

    private String zrnsyorikeikaeigyoubisuu;

    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNSYORIKEIKAEIGYOUBISUU)
    public String getZrnsyorikeikaeigyoubisuu() {
        return zrnsyorikeikaeigyoubisuu;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyorikeikaeigyoubisuu(String pZrnsyorikeikaeigyoubisuu) {
        zrnsyorikeikaeigyoubisuu = pZrnsyorikeikaeigyoubisuu;
    }

    private String zrntoritugisosikicd;

    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNTORITUGISOSIKICD)
    public String getZrntoritugisosikicd() {
        return zrntoritugisosikicd;
    }

    public void setZrntoritugisosikicd(String pZrntoritugisosikicd) {
        zrntoritugisosikicd = pZrntoritugisosikicd;
    }

    private String zrntanmatusyuruikbn;

    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNTANMATUSYURUIKBN)
    public String getZrntanmatusyuruikbn() {
        return zrntanmatusyuruikbn;
    }

    public void setZrntanmatusyuruikbn(String pZrntanmatusyuruikbn) {
        zrntanmatusyuruikbn = pZrntanmatusyuruikbn;
    }

    @Id
    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnkeiyakuymd;

    @Column(name=GenZT_JinsokuShrTtdkInfoRn.ZRNKEIYAKUYMD)
    public String getZrnkeiyakuymd() {
        return zrnkeiyakuymd;
    }

    public void setZrnkeiyakuymd(String pZrnkeiyakuymd) {
        zrnkeiyakuymd = pZrnkeiyakuymd;
    }
}