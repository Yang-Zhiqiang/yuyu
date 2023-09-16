package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.mapping.GenZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.meta.GenQZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.meta.QZT_JinsokuShrTtdkInfoTy;

/**
 * 迅速支払手続情報テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_JinsokuShrTtdkInfoTy}</td><td colspan="3">迅速支払手続情報テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyorisosikicd ztysyorisosikicd}</td><td>（中継用）処理組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhknknshrsntkno ztyhknknshrsntkno}</td><td>（中継用）保険金支払処理選択番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyoruiukeymd ztysyoruiukeymd}</td><td>（中継用）書類受付日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyoriymd ztysyoriymd}</td><td>（中継用）処理年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydenymd ztydenymd}</td><td>（中継用）伝票日付</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoruikeikaeigyoubisuu</td><td>（中継用）書類受付経過営業日数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorikeikaeigyoubisuu</td><td>（中継用）処理経過営業日数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoritugisosikicd</td><td>（中継用）取次組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytanmatusyuruikbn</td><td>（中継用）端末種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuymd</td><td>（中継用）契約日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_JinsokuShrTtdkInfoTy
 * @see     GenZT_JinsokuShrTtdkInfoTy
 * @see     QZT_JinsokuShrTtdkInfoTy
 * @see     GenQZT_JinsokuShrTtdkInfoTy
 */
public class PKZT_JinsokuShrTtdkInfoTy extends AbstractExDBPrimaryKey<ZT_JinsokuShrTtdkInfoTy, PKZT_JinsokuShrTtdkInfoTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_JinsokuShrTtdkInfoTy() {
    }

    public PKZT_JinsokuShrTtdkInfoTy(
        String pZtysyorisosikicd,
        String pZtysyoricd,
        String pZtyhknknshrsntkno,
        String pZtysyoruiukeymd,
        String pZtysyoriymd,
        String pZtydenymd,
        String pZtysyono
    ) {
        ztysyorisosikicd = pZtysyorisosikicd;
        ztysyoricd = pZtysyoricd;
        ztyhknknshrsntkno = pZtyhknknshrsntkno;
        ztysyoruiukeymd = pZtysyoruiukeymd;
        ztysyoriymd = pZtysyoriymd;
        ztydenymd = pZtydenymd;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_JinsokuShrTtdkInfoTy> getEntityClass() {
        return ZT_JinsokuShrTtdkInfoTy.class;
    }

    private String ztysyorisosikicd;

    public String getZtysyorisosikicd() {
        return ztysyorisosikicd;
    }

    public void setZtysyorisosikicd(String pZtysyorisosikicd) {
        ztysyorisosikicd = pZtysyorisosikicd;
    }
    private String ztysyoricd;

    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }
    private String ztyhknknshrsntkno;

    public String getZtyhknknshrsntkno() {
        return ztyhknknshrsntkno;
    }

    public void setZtyhknknshrsntkno(String pZtyhknknshrsntkno) {
        ztyhknknshrsntkno = pZtyhknknshrsntkno;
    }
    private String ztysyoruiukeymd;

    public String getZtysyoruiukeymd() {
        return ztysyoruiukeymd;
    }

    public void setZtysyoruiukeymd(String pZtysyoruiukeymd) {
        ztysyoruiukeymd = pZtysyoruiukeymd;
    }
    private String ztysyoriymd;

    public String getZtysyoriymd() {
        return ztysyoriymd;
    }

    public void setZtysyoriymd(String pZtysyoriymd) {
        ztysyoriymd = pZtysyoriymd;
    }
    private String ztydenymd;

    public String getZtydenymd() {
        return ztydenymd;
    }

    public void setZtydenymd(String pZtydenymd) {
        ztydenymd = pZtydenymd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}