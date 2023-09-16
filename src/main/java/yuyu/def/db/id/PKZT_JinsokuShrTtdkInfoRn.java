package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.mapping.GenZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.meta.GenQZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.meta.QZT_JinsokuShrTtdkInfoRn;

/**
 * 迅速支払手続情報テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_JinsokuShrTtdkInfoRn}</td><td colspan="3">迅速支払手続情報テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyorisosikicd zrnsyorisosikicd}</td><td>（連携用）処理組織コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknknshrsntkno zrnhknknshrsntkno}</td><td>（連携用）保険金支払処理選択番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyoruiukeymd zrnsyoruiukeymd}</td><td>（連携用）書類受付日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndenymd zrndenymd}</td><td>（連携用）伝票日付</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoruikeikaeigyoubisuu</td><td>（連携用）書類受付経過営業日数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyorikeikaeigyoubisuu</td><td>（連携用）処理経過営業日数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoritugisosikicd</td><td>（連携用）取次組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntanmatusyuruikbn</td><td>（連携用）端末種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuymd</td><td>（連携用）契約日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_JinsokuShrTtdkInfoRn
 * @see     GenZT_JinsokuShrTtdkInfoRn
 * @see     QZT_JinsokuShrTtdkInfoRn
 * @see     GenQZT_JinsokuShrTtdkInfoRn
 */
public class PKZT_JinsokuShrTtdkInfoRn extends AbstractExDBPrimaryKey<ZT_JinsokuShrTtdkInfoRn, PKZT_JinsokuShrTtdkInfoRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_JinsokuShrTtdkInfoRn() {
    }

    public PKZT_JinsokuShrTtdkInfoRn(
        String pZrnsyorisosikicd,
        String pZrnsyoricd,
        String pZrnhknknshrsntkno,
        String pZrnsyoruiukeymd,
        String pZrnsyoriymd,
        String pZrndenymd,
        String pZrnsyono
    ) {
        zrnsyorisosikicd = pZrnsyorisosikicd;
        zrnsyoricd = pZrnsyoricd;
        zrnhknknshrsntkno = pZrnhknknshrsntkno;
        zrnsyoruiukeymd = pZrnsyoruiukeymd;
        zrnsyoriymd = pZrnsyoriymd;
        zrndenymd = pZrndenymd;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_JinsokuShrTtdkInfoRn> getEntityClass() {
        return ZT_JinsokuShrTtdkInfoRn.class;
    }

    private String zrnsyorisosikicd;

    public String getZrnsyorisosikicd() {
        return zrnsyorisosikicd;
    }

    public void setZrnsyorisosikicd(String pZrnsyorisosikicd) {
        zrnsyorisosikicd = pZrnsyorisosikicd;
    }
    private String zrnsyoricd;

    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }
    private String zrnhknknshrsntkno;

    public String getZrnhknknshrsntkno() {
        return zrnhknknshrsntkno;
    }

    public void setZrnhknknshrsntkno(String pZrnhknknshrsntkno) {
        zrnhknknshrsntkno = pZrnhknknshrsntkno;
    }
    private String zrnsyoruiukeymd;

    public String getZrnsyoruiukeymd() {
        return zrnsyoruiukeymd;
    }

    public void setZrnsyoruiukeymd(String pZrnsyoruiukeymd) {
        zrnsyoruiukeymd = pZrnsyoruiukeymd;
    }
    private String zrnsyoriymd;

    public String getZrnsyoriymd() {
        return zrnsyoriymd;
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        zrnsyoriymd = pZrnsyoriymd;
    }
    private String zrndenymd;

    public String getZrndenymd() {
        return zrndenymd;
    }

    public void setZrndenymd(String pZrndenymd) {
        zrndenymd = pZrndenymd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}