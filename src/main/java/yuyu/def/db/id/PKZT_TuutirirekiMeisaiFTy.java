package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFTy;
import yuyu.def.db.mapping.GenZT_TuutirirekiMeisaiFTy;
import yuyu.def.db.meta.GenQZT_TuutirirekiMeisaiFTy;
import yuyu.def.db.meta.QZT_TuutirirekiMeisaiFTy;

/**
 * 通知履歴明細ファイルテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TuutirirekiMeisaiFTy}</td><td colspan="3">通知履歴明細ファイルテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytuutirirekino ztytuutirirekino}</td><td>（中継用）通知履歴番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytuutisakuseiymd ztytuutisakuseiymd}</td><td>（中継用）通知作成年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytuutisakuseino ztytuutisakuseino}</td><td>（中継用）通知作成番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuutisyuruicd</td><td>（中継用）通知種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhyoujiyoutuutisksymd</td><td>（中継用）表示用通知作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv11</td><td>（中継用）予備項目Ｖ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TuutirirekiMeisaiFTy
 * @see     GenZT_TuutirirekiMeisaiFTy
 * @see     QZT_TuutirirekiMeisaiFTy
 * @see     GenQZT_TuutirirekiMeisaiFTy
 */
public class PKZT_TuutirirekiMeisaiFTy extends AbstractExDBPrimaryKey<ZT_TuutirirekiMeisaiFTy, PKZT_TuutirirekiMeisaiFTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_TuutirirekiMeisaiFTy() {
    }

    public PKZT_TuutirirekiMeisaiFTy(
        String pZtytuutirirekino,
        String pZtytuutisakuseiymd,
        String pZtytuutisakuseino
    ) {
        ztytuutirirekino = pZtytuutirirekino;
        ztytuutisakuseiymd = pZtytuutisakuseiymd;
        ztytuutisakuseino = pZtytuutisakuseino;
    }

    @Transient
    @Override
    public Class<ZT_TuutirirekiMeisaiFTy> getEntityClass() {
        return ZT_TuutirirekiMeisaiFTy.class;
    }

    private String ztytuutirirekino;

    public String getZtytuutirirekino() {
        return ztytuutirirekino;
    }

    public void setZtytuutirirekino(String pZtytuutirirekino) {
        ztytuutirirekino = pZtytuutirirekino;
    }
    private String ztytuutisakuseiymd;

    public String getZtytuutisakuseiymd() {
        return ztytuutisakuseiymd;
    }

    public void setZtytuutisakuseiymd(String pZtytuutisakuseiymd) {
        ztytuutisakuseiymd = pZtytuutisakuseiymd;
    }
    private String ztytuutisakuseino;

    public String getZtytuutisakuseino() {
        return ztytuutisakuseino;
    }

    public void setZtytuutisakuseino(String pZtytuutisakuseino) {
        ztytuutisakuseino = pZtytuutisakuseino;
    }

}