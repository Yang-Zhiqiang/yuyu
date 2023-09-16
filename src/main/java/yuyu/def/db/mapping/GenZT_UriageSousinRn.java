package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_UriageSousinRn;
import yuyu.def.db.id.PKZT_UriageSousinRn;
import yuyu.def.db.meta.GenQZT_UriageSousinRn;
import yuyu.def.db.meta.QZT_UriageSousinRn;

/**
 * 売上送信Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_UriageSousinRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_UriageSousinRn}</td><td colspan="3">売上送信Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrncreditkessaiyouno zrncreditkessaiyouno}</td><td>（連携用）クレジットカード決済用番号</td><td align="center">{@link PKZT_UriageSousinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnauthorikbn zrnauthorikbn}</td><td>（連携用）オーソリ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuriageseikyuuymd zrnuriageseikyuuymd}</td><td>（連携用）売上請求年月日</td><td align="center">{@link PKZT_UriageSousinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrsgaku zrnrsgaku}</td><td>（連携用）領収金額</td><td align="center">{@link PKZT_UriageSousinRn ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnfukusuukameitennokey zrnfukusuukameitennokey}</td><td>（連携用）複数加盟店番号設定キー情報</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_UriageSousinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordno zrnrecordno}</td><td>（連携用）レコード番号</td><td align="center">{@link PKZT_UriageSousinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuriagetaisyouym zrnuriagetaisyouym}</td><td>（連携用）売上対象年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv33 zrnyobiv33}</td><td>（連携用）予備項目Ｖ３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_UriageSousinRn
 * @see     PKZT_UriageSousinRn
 * @see     QZT_UriageSousinRn
 * @see     GenQZT_UriageSousinRn
 */
@MappedSuperclass
@Table(name=GenZT_UriageSousinRn.TABLE_NAME)
@IdClass(value=PKZT_UriageSousinRn.class)
public abstract class GenZT_UriageSousinRn extends AbstractExDBEntityForZDB<ZT_UriageSousinRn, PKZT_UriageSousinRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_UriageSousinRn";
    public static final String ZRNCREDITKESSAIYOUNO     = "zrncreditkessaiyouno";
    public static final String ZRNAUTHORIKBN            = "zrnauthorikbn";
    public static final String ZRNURIAGESEIKYUUYMD      = "zrnuriageseikyuuymd";
    public static final String ZRNRSGAKU                = "zrnrsgaku";
    public static final String ZRNFUKUSUUKAMEITENNOKEY  = "zrnfukusuukameitennokey";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNRECORDNO              = "zrnrecordno";
    public static final String ZRNURIAGETAISYOUYM       = "zrnuriagetaisyouym";
    public static final String ZRNYOBIV33               = "zrnyobiv33";

    private final PKZT_UriageSousinRn primaryKey;

    public GenZT_UriageSousinRn() {
        primaryKey = new PKZT_UriageSousinRn();
    }

    public GenZT_UriageSousinRn(
        String pZrncreditkessaiyouno,
        String pZrnsyono,
        String pZrnuriageseikyuuymd,
        Long pZrnrsgaku,
        String pZrnrecordno
    ) {
        primaryKey = new PKZT_UriageSousinRn(
            pZrncreditkessaiyouno,
            pZrnsyono,
            pZrnuriageseikyuuymd,
            pZrnrsgaku,
            pZrnrecordno
        );
    }

    @Transient
    @Override
    public PKZT_UriageSousinRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_UriageSousinRn> getMetaClass() {
        return QZT_UriageSousinRn.class;
    }

    @Id
    @Column(name=GenZT_UriageSousinRn.ZRNCREDITKESSAIYOUNO)
    public String getZrncreditkessaiyouno() {
        return getPrimaryKey().getZrncreditkessaiyouno();
    }

    public void setZrncreditkessaiyouno(String pZrncreditkessaiyouno) {
        getPrimaryKey().setZrncreditkessaiyouno(pZrncreditkessaiyouno);
    }

    private String zrnauthorikbn;

    @Column(name=GenZT_UriageSousinRn.ZRNAUTHORIKBN)
    public String getZrnauthorikbn() {
        return zrnauthorikbn;
    }

    public void setZrnauthorikbn(String pZrnauthorikbn) {
        zrnauthorikbn = pZrnauthorikbn;
    }

    @Id
    @Column(name=GenZT_UriageSousinRn.ZRNURIAGESEIKYUUYMD)
    public String getZrnuriageseikyuuymd() {
        return getPrimaryKey().getZrnuriageseikyuuymd();
    }

    public void setZrnuriageseikyuuymd(String pZrnuriageseikyuuymd) {
        getPrimaryKey().setZrnuriageseikyuuymd(pZrnuriageseikyuuymd);
    }

    @Id
    @Column(name=GenZT_UriageSousinRn.ZRNRSGAKU)
    public Long getZrnrsgaku() {
        return getPrimaryKey().getZrnrsgaku();
    }

    public void setZrnrsgaku(Long pZrnrsgaku) {
        getPrimaryKey().setZrnrsgaku(pZrnrsgaku);
    }

    private String zrnfukusuukameitennokey;

    @Column(name=GenZT_UriageSousinRn.ZRNFUKUSUUKAMEITENNOKEY)
    public String getZrnfukusuukameitennokey() {
        return zrnfukusuukameitennokey;
    }

    public void setZrnfukusuukameitennokey(String pZrnfukusuukameitennokey) {
        zrnfukusuukameitennokey = pZrnfukusuukameitennokey;
    }

    @Id
    @Column(name=GenZT_UriageSousinRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    @Id
    @Column(name=GenZT_UriageSousinRn.ZRNRECORDNO)
    public String getZrnrecordno() {
        return getPrimaryKey().getZrnrecordno();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnrecordno(String pZrnrecordno) {
        getPrimaryKey().setZrnrecordno(pZrnrecordno);
    }

    private String zrnuriagetaisyouym;

    @Column(name=GenZT_UriageSousinRn.ZRNURIAGETAISYOUYM)
    public String getZrnuriagetaisyouym() {
        return zrnuriagetaisyouym;
    }

    public void setZrnuriagetaisyouym(String pZrnuriagetaisyouym) {
        zrnuriagetaisyouym = pZrnuriagetaisyouym;
    }

    private String zrnyobiv33;

    @Column(name=GenZT_UriageSousinRn.ZRNYOBIV33)
    public String getZrnyobiv33() {
        return zrnyobiv33;
    }

    public void setZrnyobiv33(String pZrnyobiv33) {
        zrnyobiv33 = pZrnyobiv33;
    }
}