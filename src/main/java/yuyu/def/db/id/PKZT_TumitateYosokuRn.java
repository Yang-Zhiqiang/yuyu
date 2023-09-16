package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TumitateYosokuRn;
import yuyu.def.db.mapping.GenZT_TumitateYosokuRn;
import yuyu.def.db.meta.GenQZT_TumitateYosokuRn;
import yuyu.def.db.meta.QZT_TumitateYosokuRn;

/**
 * 積立金額予測ファイルテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TumitateYosokuRn}</td><td colspan="3">積立金額予測ファイルテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkeiyakuymd zrnkeiyakuymd}</td><td>（連携用）契約日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntysytymd zrntysytymd}</td><td>（連携用）抽出日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkyktuukasyu zrnkyktuukasyu}</td><td>（連携用）契約通貨種類</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntmttknsyuruikbn zrntmttknsyuruikbn}</td><td>（連携用）積立金種類区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsisuukbn zrnsisuukbn}</td><td>（連携用）指数区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknysktaisyoukensuu</td><td>（連携用）積立金予測対象件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnkyktuukakyktmttkngk</td><td>（連携用）契約通貨建契約時積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkyktuukakisitmttkngk</td><td>（連携用）契約通貨建期始積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkyktuukaysktmttkngk</td><td>（連携用）契約通貨建予測積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     ZT_TumitateYosokuRn
 * @see     GenZT_TumitateYosokuRn
 * @see     QZT_TumitateYosokuRn
 * @see     GenQZT_TumitateYosokuRn
 */
public class PKZT_TumitateYosokuRn extends AbstractExDBPrimaryKey<ZT_TumitateYosokuRn, PKZT_TumitateYosokuRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_TumitateYosokuRn() {
    }

    public PKZT_TumitateYosokuRn(
        String pZrnhknsyukigou,
        String pZrnkeiyakuymd,
        String pZrntysytymd,
        String pZrnkyktuukasyu,
        String pZrnhknkkn,
        String pZrntmttknsyuruikbn,
        String pZrnsisuukbn
    ) {
        zrnhknsyukigou = pZrnhknsyukigou;
        zrnkeiyakuymd = pZrnkeiyakuymd;
        zrntysytymd = pZrntysytymd;
        zrnkyktuukasyu = pZrnkyktuukasyu;
        zrnhknkkn = pZrnhknkkn;
        zrntmttknsyuruikbn = pZrntmttknsyuruikbn;
        zrnsisuukbn = pZrnsisuukbn;
    }

    @Transient
    @Override
    public Class<ZT_TumitateYosokuRn> getEntityClass() {
        return ZT_TumitateYosokuRn.class;
    }

    private String zrnhknsyukigou;

    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }
    private String zrnkeiyakuymd;

    public String getZrnkeiyakuymd() {
        return zrnkeiyakuymd;
    }

    public void setZrnkeiyakuymd(String pZrnkeiyakuymd) {
        zrnkeiyakuymd = pZrnkeiyakuymd;
    }
    private String zrntysytymd;

    public String getZrntysytymd() {
        return zrntysytymd;
    }

    public void setZrntysytymd(String pZrntysytymd) {
        zrntysytymd = pZrntysytymd;
    }
    private String zrnkyktuukasyu;

    public String getZrnkyktuukasyu() {
        return zrnkyktuukasyu;
    }

    public void setZrnkyktuukasyu(String pZrnkyktuukasyu) {
        zrnkyktuukasyu = pZrnkyktuukasyu;
    }
    private String zrnhknkkn;

    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }
    private String zrntmttknsyuruikbn;

    public String getZrntmttknsyuruikbn() {
        return zrntmttknsyuruikbn;
    }

    public void setZrntmttknsyuruikbn(String pZrntmttknsyuruikbn) {
        zrntmttknsyuruikbn = pZrntmttknsyuruikbn;
    }
    private String zrnsisuukbn;

    public String getZrnsisuukbn() {
        return zrnsisuukbn;
    }

    public void setZrnsisuukbn(String pZrnsisuukbn) {
        zrnsisuukbn = pZrnsisuukbn;
    }

}