package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.id.PKZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.meta.GenQZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.meta.QZT_TuutirirekiMeisaiFRn;

/**
 * 通知履歴明細ファイルテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_TuutirirekiMeisaiFRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TuutirirekiMeisaiFRn}</td><td colspan="3">通知履歴明細ファイルテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrntuutirirekino zrntuutirirekino}</td><td>（連携用）通知履歴番号</td><td align="center">{@link PKZT_TuutirirekiMeisaiFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuutisakuseiymd zrntuutisakuseiymd}</td><td>（連携用）通知作成年月日</td><td align="center">{@link PKZT_TuutirirekiMeisaiFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuutisakuseino zrntuutisakuseino}</td><td>（連携用）通知作成番号</td><td align="center">{@link PKZT_TuutirirekiMeisaiFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuutisyuruicd zrntuutisyuruicd}</td><td>（連携用）通知種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiyoutuutisksymd zrnhyoujiyoutuutisksymd}</td><td>（連携用）表示用通知作成年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv11 zrnyobiv11}</td><td>（連携用）予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TuutirirekiMeisaiFRn
 * @see     PKZT_TuutirirekiMeisaiFRn
 * @see     QZT_TuutirirekiMeisaiFRn
 * @see     GenQZT_TuutirirekiMeisaiFRn
 */
@MappedSuperclass
@Table(name=GenZT_TuutirirekiMeisaiFRn.TABLE_NAME)
@IdClass(value=PKZT_TuutirirekiMeisaiFRn.class)
public abstract class GenZT_TuutirirekiMeisaiFRn extends AbstractExDBEntityForZDB<ZT_TuutirirekiMeisaiFRn, PKZT_TuutirirekiMeisaiFRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TuutirirekiMeisaiFRn";
    public static final String ZRNTUUTIRIREKINO         = "zrntuutirirekino";
    public static final String ZRNTUUTISAKUSEIYMD       = "zrntuutisakuseiymd";
    public static final String ZRNTUUTISAKUSEINO        = "zrntuutisakuseino";
    public static final String ZRNTUUTISYURUICD         = "zrntuutisyuruicd";
    public static final String ZRNHYOUJIYOUTUUTISKSYMD  = "zrnhyoujiyoutuutisksymd";
    public static final String ZRNYOBIV11               = "zrnyobiv11";

    private final PKZT_TuutirirekiMeisaiFRn primaryKey;

    public GenZT_TuutirirekiMeisaiFRn() {
        primaryKey = new PKZT_TuutirirekiMeisaiFRn();
    }

    public GenZT_TuutirirekiMeisaiFRn(
        String pZrntuutirirekino,
        String pZrntuutisakuseiymd,
        String pZrntuutisakuseino
    ) {
        primaryKey = new PKZT_TuutirirekiMeisaiFRn(
            pZrntuutirirekino,
            pZrntuutisakuseiymd,
            pZrntuutisakuseino
        );
    }

    @Transient
    @Override
    public PKZT_TuutirirekiMeisaiFRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TuutirirekiMeisaiFRn> getMetaClass() {
        return QZT_TuutirirekiMeisaiFRn.class;
    }

    @Id
    @Column(name=GenZT_TuutirirekiMeisaiFRn.ZRNTUUTIRIREKINO)
    public String getZrntuutirirekino() {
        return getPrimaryKey().getZrntuutirirekino();
    }

    public void setZrntuutirirekino(String pZrntuutirirekino) {
        getPrimaryKey().setZrntuutirirekino(pZrntuutirirekino);
    }

    @Id
    @Column(name=GenZT_TuutirirekiMeisaiFRn.ZRNTUUTISAKUSEIYMD)
    public String getZrntuutisakuseiymd() {
        return getPrimaryKey().getZrntuutisakuseiymd();
    }

    public void setZrntuutisakuseiymd(String pZrntuutisakuseiymd) {
        getPrimaryKey().setZrntuutisakuseiymd(pZrntuutisakuseiymd);
    }

    @Id
    @Column(name=GenZT_TuutirirekiMeisaiFRn.ZRNTUUTISAKUSEINO)
    public String getZrntuutisakuseino() {
        return getPrimaryKey().getZrntuutisakuseino();
    }

    public void setZrntuutisakuseino(String pZrntuutisakuseino) {
        getPrimaryKey().setZrntuutisakuseino(pZrntuutisakuseino);
    }

    private String zrntuutisyuruicd;

    @Column(name=GenZT_TuutirirekiMeisaiFRn.ZRNTUUTISYURUICD)
    public String getZrntuutisyuruicd() {
        return zrntuutisyuruicd;
    }

    public void setZrntuutisyuruicd(String pZrntuutisyuruicd) {
        zrntuutisyuruicd = pZrntuutisyuruicd;
    }

    private String zrnhyoujiyoutuutisksymd;

    @Column(name=GenZT_TuutirirekiMeisaiFRn.ZRNHYOUJIYOUTUUTISKSYMD)
    public String getZrnhyoujiyoutuutisksymd() {
        return zrnhyoujiyoutuutisksymd;
    }

    public void setZrnhyoujiyoutuutisksymd(String pZrnhyoujiyoutuutisksymd) {
        zrnhyoujiyoutuutisksymd = pZrnhyoujiyoutuutisksymd;
    }

    private String zrnyobiv11;

    @Column(name=GenZT_TuutirirekiMeisaiFRn.ZRNYOBIV11)
    public String getZrnyobiv11() {
        return zrnyobiv11;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnyobiv11(String pZrnyobiv11) {
        zrnyobiv11 = pZrnyobiv11;
    }
}