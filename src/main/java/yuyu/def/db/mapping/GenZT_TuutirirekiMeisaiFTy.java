package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFTy;
import yuyu.def.db.id.PKZT_TuutirirekiMeisaiFTy;
import yuyu.def.db.meta.GenQZT_TuutirirekiMeisaiFTy;
import yuyu.def.db.meta.QZT_TuutirirekiMeisaiFTy;

/**
 * 通知履歴明細ファイルテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_TuutirirekiMeisaiFTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TuutirirekiMeisaiFTy}</td><td colspan="3">通知履歴明細ファイルテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtytuutirirekino ztytuutirirekino}</td><td>（中継用）通知履歴番号</td><td align="center">{@link PKZT_TuutirirekiMeisaiFTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuutisakuseiymd ztytuutisakuseiymd}</td><td>（中継用）通知作成年月日</td><td align="center">{@link PKZT_TuutirirekiMeisaiFTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuutisakuseino ztytuutisakuseino}</td><td>（中継用）通知作成番号</td><td align="center">{@link PKZT_TuutirirekiMeisaiFTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuutisyuruicd ztytuutisyuruicd}</td><td>（中継用）通知種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiyoutuutisksymd ztyhyoujiyoutuutisksymd}</td><td>（中継用）表示用通知作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv11 ztyyobiv11}</td><td>（中継用）予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TuutirirekiMeisaiFTy
 * @see     PKZT_TuutirirekiMeisaiFTy
 * @see     QZT_TuutirirekiMeisaiFTy
 * @see     GenQZT_TuutirirekiMeisaiFTy
 */
@MappedSuperclass
@Table(name=GenZT_TuutirirekiMeisaiFTy.TABLE_NAME)
@IdClass(value=PKZT_TuutirirekiMeisaiFTy.class)
public abstract class GenZT_TuutirirekiMeisaiFTy extends AbstractExDBEntity<ZT_TuutirirekiMeisaiFTy, PKZT_TuutirirekiMeisaiFTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TuutirirekiMeisaiFTy";
    public static final String ZTYTUUTIRIREKINO         = "ztytuutirirekino";
    public static final String ZTYTUUTISAKUSEIYMD       = "ztytuutisakuseiymd";
    public static final String ZTYTUUTISAKUSEINO        = "ztytuutisakuseino";
    public static final String ZTYTUUTISYURUICD         = "ztytuutisyuruicd";
    public static final String ZTYHYOUJIYOUTUUTISKSYMD  = "ztyhyoujiyoutuutisksymd";
    public static final String ZTYYOBIV11               = "ztyyobiv11";

    private final PKZT_TuutirirekiMeisaiFTy primaryKey;

    public GenZT_TuutirirekiMeisaiFTy() {
        primaryKey = new PKZT_TuutirirekiMeisaiFTy();
    }

    public GenZT_TuutirirekiMeisaiFTy(
        String pZtytuutirirekino,
        String pZtytuutisakuseiymd,
        String pZtytuutisakuseino
    ) {
        primaryKey = new PKZT_TuutirirekiMeisaiFTy(
            pZtytuutirirekino,
            pZtytuutisakuseiymd,
            pZtytuutisakuseino
        );
    }

    @Transient
    @Override
    public PKZT_TuutirirekiMeisaiFTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TuutirirekiMeisaiFTy> getMetaClass() {
        return QZT_TuutirirekiMeisaiFTy.class;
    }

    @Id
    @Column(name=GenZT_TuutirirekiMeisaiFTy.ZTYTUUTIRIREKINO)
    public String getZtytuutirirekino() {
        return getPrimaryKey().getZtytuutirirekino();
    }

    public void setZtytuutirirekino(String pZtytuutirirekino) {
        getPrimaryKey().setZtytuutirirekino(pZtytuutirirekino);
    }

    @Id
    @Column(name=GenZT_TuutirirekiMeisaiFTy.ZTYTUUTISAKUSEIYMD)
    public String getZtytuutisakuseiymd() {
        return getPrimaryKey().getZtytuutisakuseiymd();
    }

    public void setZtytuutisakuseiymd(String pZtytuutisakuseiymd) {
        getPrimaryKey().setZtytuutisakuseiymd(pZtytuutisakuseiymd);
    }

    @Id
    @Column(name=GenZT_TuutirirekiMeisaiFTy.ZTYTUUTISAKUSEINO)
    public String getZtytuutisakuseino() {
        return getPrimaryKey().getZtytuutisakuseino();
    }

    public void setZtytuutisakuseino(String pZtytuutisakuseino) {
        getPrimaryKey().setZtytuutisakuseino(pZtytuutisakuseino);
    }

    private String ztytuutisyuruicd;

    @Column(name=GenZT_TuutirirekiMeisaiFTy.ZTYTUUTISYURUICD)
    public String getZtytuutisyuruicd() {
        return ztytuutisyuruicd;
    }

    public void setZtytuutisyuruicd(String pZtytuutisyuruicd) {
        ztytuutisyuruicd = pZtytuutisyuruicd;
    }

    private String ztyhyoujiyoutuutisksymd;

    @Column(name=GenZT_TuutirirekiMeisaiFTy.ZTYHYOUJIYOUTUUTISKSYMD)
    public String getZtyhyoujiyoutuutisksymd() {
        return ztyhyoujiyoutuutisksymd;
    }

    public void setZtyhyoujiyoutuutisksymd(String pZtyhyoujiyoutuutisksymd) {
        ztyhyoujiyoutuutisksymd = pZtyhyoujiyoutuutisksymd;
    }

    private String ztyyobiv11;

    @Column(name=GenZT_TuutirirekiMeisaiFTy.ZTYYOBIV11)
    public String getZtyyobiv11() {
        return ztyyobiv11;
    }

    public void setZtyyobiv11(String pZtyyobiv11) {
        ztyyobiv11 = pZtyyobiv11;
    }
}