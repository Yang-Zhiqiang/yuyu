package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_HonyakuYouKouinRn;
import yuyu.def.db.id.PKZT_HonyakuYouKouinRn;
import yuyu.def.db.meta.GenQZT_HonyakuYouKouinRn;
import yuyu.def.db.meta.QZT_HonyakuYouKouinRn;

/**
 * 翻訳用行員Ｆ用連動Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_HonyakuYouKouinRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HonyakuYouKouinRn}</td><td colspan="3">翻訳用行員Ｆ用連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkinyuukikancd zrnkinyuukikancd}</td><td>（連携用）金融機関コード</td><td align="center">{@link PKZT_HonyakuYouKouinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouincd zrnkouincd}</td><td>（連携用）行員コード</td><td align="center">{@link PKZT_HonyakuYouKouinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunincd zrnbosyuunincd}</td><td>（連携用）募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_HonyakuYouKouinRn
 * @see     PKZT_HonyakuYouKouinRn
 * @see     QZT_HonyakuYouKouinRn
 * @see     GenQZT_HonyakuYouKouinRn
 */
@MappedSuperclass
@Table(name=GenZT_HonyakuYouKouinRn.TABLE_NAME)
@IdClass(value=PKZT_HonyakuYouKouinRn.class)
public abstract class GenZT_HonyakuYouKouinRn extends AbstractExDBEntityForZDB<ZT_HonyakuYouKouinRn, PKZT_HonyakuYouKouinRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_HonyakuYouKouinRn";
    public static final String ZRNKINYUUKIKANCD         = "zrnkinyuukikancd";
    public static final String ZRNKOUINCD               = "zrnkouincd";
    public static final String ZRNBOSYUUNINCD           = "zrnbosyuunincd";

    private final PKZT_HonyakuYouKouinRn primaryKey;

    public GenZT_HonyakuYouKouinRn() {
        primaryKey = new PKZT_HonyakuYouKouinRn();
    }

    public GenZT_HonyakuYouKouinRn(String pZrnkinyuukikancd, String pZrnkouincd) {
        primaryKey = new PKZT_HonyakuYouKouinRn(pZrnkinyuukikancd, pZrnkouincd);
    }

    @Transient
    @Override
    public PKZT_HonyakuYouKouinRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_HonyakuYouKouinRn> getMetaClass() {
        return QZT_HonyakuYouKouinRn.class;
    }

    @Id
    @Column(name=GenZT_HonyakuYouKouinRn.ZRNKINYUUKIKANCD)
    public String getZrnkinyuukikancd() {
        return getPrimaryKey().getZrnkinyuukikancd();
    }

    public void setZrnkinyuukikancd(String pZrnkinyuukikancd) {
        getPrimaryKey().setZrnkinyuukikancd(pZrnkinyuukikancd);
    }

    @Id
    @Column(name=GenZT_HonyakuYouKouinRn.ZRNKOUINCD)
    public String getZrnkouincd() {
        return getPrimaryKey().getZrnkouincd();
    }

    public void setZrnkouincd(String pZrnkouincd) {
        getPrimaryKey().setZrnkouincd(pZrnkouincd);
    }

    private String zrnbosyuunincd;

    @Column(name=GenZT_HonyakuYouKouinRn.ZRNBOSYUUNINCD)
    public String getZrnbosyuunincd() {
        return zrnbosyuunincd;
    }

    public void setZrnbosyuunincd(String pZrnbosyuunincd) {
        zrnbosyuunincd = pZrnbosyuunincd;
    }
}