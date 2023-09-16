package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.mapping.GenZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.meta.GenQZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.meta.QZT_TuutirirekiMeisaiFRn;

/**
 * 通知履歴明細ファイルテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TuutirirekiMeisaiFRn}</td><td colspan="3">通知履歴明細ファイルテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntuutirirekino zrntuutirirekino}</td><td>（連携用）通知履歴番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntuutisakuseiymd zrntuutisakuseiymd}</td><td>（連携用）通知作成年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntuutisakuseino zrntuutisakuseino}</td><td>（連携用）通知作成番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuutisyuruicd</td><td>（連携用）通知種類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhyoujiyoutuutisksymd</td><td>（連携用）表示用通知作成年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv11</td><td>（連携用）予備項目Ｖ１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TuutirirekiMeisaiFRn
 * @see     GenZT_TuutirirekiMeisaiFRn
 * @see     QZT_TuutirirekiMeisaiFRn
 * @see     GenQZT_TuutirirekiMeisaiFRn
 */
public class PKZT_TuutirirekiMeisaiFRn extends AbstractExDBPrimaryKey<ZT_TuutirirekiMeisaiFRn, PKZT_TuutirirekiMeisaiFRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_TuutirirekiMeisaiFRn() {
    }

    public PKZT_TuutirirekiMeisaiFRn(
        String pZrntuutirirekino,
        String pZrntuutisakuseiymd,
        String pZrntuutisakuseino
    ) {
        zrntuutirirekino = pZrntuutirirekino;
        zrntuutisakuseiymd = pZrntuutisakuseiymd;
        zrntuutisakuseino = pZrntuutisakuseino;
    }

    @Transient
    @Override
    public Class<ZT_TuutirirekiMeisaiFRn> getEntityClass() {
        return ZT_TuutirirekiMeisaiFRn.class;
    }

    private String zrntuutirirekino;

    public String getZrntuutirirekino() {
        return zrntuutirirekino;
    }

    public void setZrntuutirirekino(String pZrntuutirirekino) {
        zrntuutirirekino = pZrntuutirirekino;
    }
    private String zrntuutisakuseiymd;

    public String getZrntuutisakuseiymd() {
        return zrntuutisakuseiymd;
    }

    public void setZrntuutisakuseiymd(String pZrntuutisakuseiymd) {
        zrntuutisakuseiymd = pZrntuutisakuseiymd;
    }
    private String zrntuutisakuseino;

    public String getZrntuutisakuseino() {
        return zrntuutisakuseino;
    }

    public void setZrntuutisakuseino(String pZrntuutisakuseino) {
        zrntuutisakuseino = pZrntuutisakuseino;
    }

}