package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.mapping.GenZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.meta.GenQZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.meta.QZT_SntkInfoHaneiKekkaRn;

/**
 * 普保Ⅱ選択情報反映結果テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SntkInfoHaneiKekkaRn}</td><td colspan="3">普保Ⅱ選択情報反映結果テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsntkinfono zrnsntkinfono}</td><td>（連携用）選択情報番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrenno zrnrenno}</td><td>（連携用）連番</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsntkinfotourokusyskbn zrnsntkinfotourokusyskbn}</td><td>（連携用）選択情報登録システム区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhuho2kyknokbn</td><td>（連携用）普保Ⅱ契約番号区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhuho2kykno</td><td>（連携用）普保Ⅱ契約番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfofsegkbn</td><td>（連携用）選択情報ＦＳＥＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinfofkojinkbn</td><td>（連携用）選択情報Ｆ個人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketnaiyouarihyj</td><td>（連携用）諾否決定内容有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkktnaiyouarihyj</td><td>（連携用）告知内容有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkijinaiyouarihyj</td><td>（連携用）記事内容有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrarihyj</td><td>（連携用）ＭＲ有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkoudosyougaiarihyj</td><td>（連携用）高度障害有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntorikaijoarihyj</td><td>（連携用）取消解除有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinjotourokuerrkbn</td><td>（連携用）選択情報登録エラー区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnayosehumeihyj</td><td>（連携用）名寄せ不明表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntkinjohaneikekkayobi01</td><td>（連携用）選択情報反映結果予備０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SntkInfoHaneiKekkaRn
 * @see     GenZT_SntkInfoHaneiKekkaRn
 * @see     QZT_SntkInfoHaneiKekkaRn
 * @see     GenQZT_SntkInfoHaneiKekkaRn
 */
public class PKZT_SntkInfoHaneiKekkaRn extends AbstractExDBPrimaryKey<ZT_SntkInfoHaneiKekkaRn, PKZT_SntkInfoHaneiKekkaRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SntkInfoHaneiKekkaRn() {
    }

    public PKZT_SntkInfoHaneiKekkaRn(
        String pZrnsntkinfono,
        String pZrnrenno,
        String pZrnsntkinfotourokusyskbn
    ) {
        zrnsntkinfono = pZrnsntkinfono;
        zrnrenno = pZrnrenno;
        zrnsntkinfotourokusyskbn = pZrnsntkinfotourokusyskbn;
    }

    @Transient
    @Override
    public Class<ZT_SntkInfoHaneiKekkaRn> getEntityClass() {
        return ZT_SntkInfoHaneiKekkaRn.class;
    }

    private String zrnsntkinfono;

    public String getZrnsntkinfono() {
        return zrnsntkinfono;
    }

    public void setZrnsntkinfono(String pZrnsntkinfono) {
        zrnsntkinfono = pZrnsntkinfono;
    }
    private String zrnrenno;

    public String getZrnrenno() {
        return zrnrenno;
    }

    public void setZrnrenno(String pZrnrenno) {
        zrnrenno = pZrnrenno;
    }
    private String zrnsntkinfotourokusyskbn;

    public String getZrnsntkinfotourokusyskbn() {
        return zrnsntkinfotourokusyskbn;
    }

    public void setZrnsntkinfotourokusyskbn(String pZrnsntkinfotourokusyskbn) {
        zrnsntkinfotourokusyskbn = pZrnsntkinfotourokusyskbn;
    }

}