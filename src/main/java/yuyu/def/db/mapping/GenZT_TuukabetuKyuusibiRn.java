package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_TuukabetuKyuusibiRn;
import yuyu.def.db.id.PKZT_TuukabetuKyuusibiRn;
import yuyu.def.db.meta.GenQZT_TuukabetuKyuusibiRn;
import yuyu.def.db.meta.QZT_TuukabetuKyuusibiRn;

/**
 * 通貨別休止日取扱休止日Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_TuukabetuKyuusibiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TuukabetuKyuusibiRn}</td><td colspan="3">通貨別休止日取扱休止日Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrntekiyouymd zrntekiyouymd}</td><td>（連携用）適用年月日</td><td align="center">{@link PKZT_TuukabetuKyuusibiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnenkyuusibikbn zrnenkyuusibikbn}</td><td>（連携用）円休止日区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbeidorukyuusibikbn zrnbeidorukyuusibikbn}</td><td>（連携用）米ドル休止日区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrneurkyuusibikbn zrneurkyuusibikbn}</td><td>（連携用）ユーロ休止日区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoudorukyuusibikbn zrngoudorukyuusibikbn}</td><td>（連携用）豪ドル休止日区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TuukabetuKyuusibiRn
 * @see     PKZT_TuukabetuKyuusibiRn
 * @see     QZT_TuukabetuKyuusibiRn
 * @see     GenQZT_TuukabetuKyuusibiRn
 */
@MappedSuperclass
@Table(name=GenZT_TuukabetuKyuusibiRn.TABLE_NAME)
@IdClass(value=PKZT_TuukabetuKyuusibiRn.class)
public abstract class GenZT_TuukabetuKyuusibiRn extends AbstractExDBEntityForZDB<ZT_TuukabetuKyuusibiRn, PKZT_TuukabetuKyuusibiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TuukabetuKyuusibiRn";
    public static final String ZRNTEKIYOUYMD            = "zrntekiyouymd";
    public static final String ZRNENKYUUSIBIKBN         = "zrnenkyuusibikbn";
    public static final String ZRNBEIDORUKYUUSIBIKBN    = "zrnbeidorukyuusibikbn";
    public static final String ZRNEURKYUUSIBIKBN        = "zrneurkyuusibikbn";
    public static final String ZRNGOUDORUKYUUSIBIKBN    = "zrngoudorukyuusibikbn";

    private final PKZT_TuukabetuKyuusibiRn primaryKey;

    public GenZT_TuukabetuKyuusibiRn() {
        primaryKey = new PKZT_TuukabetuKyuusibiRn();
    }

    public GenZT_TuukabetuKyuusibiRn(String pZrntekiyouymd) {
        primaryKey = new PKZT_TuukabetuKyuusibiRn(pZrntekiyouymd);
    }

    @Transient
    @Override
    public PKZT_TuukabetuKyuusibiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TuukabetuKyuusibiRn> getMetaClass() {
        return QZT_TuukabetuKyuusibiRn.class;
    }

    @Id
    @Column(name=GenZT_TuukabetuKyuusibiRn.ZRNTEKIYOUYMD)
    public String getZrntekiyouymd() {
        return getPrimaryKey().getZrntekiyouymd();
    }

    public void setZrntekiyouymd(String pZrntekiyouymd) {
        getPrimaryKey().setZrntekiyouymd(pZrntekiyouymd);
    }

    private String zrnenkyuusibikbn;

    @Column(name=GenZT_TuukabetuKyuusibiRn.ZRNENKYUUSIBIKBN)
    public String getZrnenkyuusibikbn() {
        return zrnenkyuusibikbn;
    }

    public void setZrnenkyuusibikbn(String pZrnenkyuusibikbn) {
        zrnenkyuusibikbn = pZrnenkyuusibikbn;
    }

    private String zrnbeidorukyuusibikbn;

    @Column(name=GenZT_TuukabetuKyuusibiRn.ZRNBEIDORUKYUUSIBIKBN)
    public String getZrnbeidorukyuusibikbn() {
        return zrnbeidorukyuusibikbn;
    }

    public void setZrnbeidorukyuusibikbn(String pZrnbeidorukyuusibikbn) {
        zrnbeidorukyuusibikbn = pZrnbeidorukyuusibikbn;
    }

    private String zrneurkyuusibikbn;

    @Column(name=GenZT_TuukabetuKyuusibiRn.ZRNEURKYUUSIBIKBN)
    public String getZrneurkyuusibikbn() {
        return zrneurkyuusibikbn;
    }

    public void setZrneurkyuusibikbn(String pZrneurkyuusibikbn) {
        zrneurkyuusibikbn = pZrneurkyuusibikbn;
    }

    private String zrngoudorukyuusibikbn;

    @Column(name=GenZT_TuukabetuKyuusibiRn.ZRNGOUDORUKYUUSIBIKBN)
    public String getZrngoudorukyuusibikbn() {
        return zrngoudorukyuusibikbn;
    }

    public void setZrngoudorukyuusibikbn(String pZrngoudorukyuusibikbn) {
        zrngoudorukyuusibikbn = pZrngoudorukyuusibikbn;
    }
}