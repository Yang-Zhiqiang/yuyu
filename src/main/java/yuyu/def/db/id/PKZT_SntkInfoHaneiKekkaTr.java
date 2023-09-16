package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.mapping.GenZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.meta.GenQZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.meta.QZT_SntkInfoHaneiKekkaTr;

/**
 * 普保Ⅱ選択情報反映結果テーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SntkInfoHaneiKekkaTr}</td><td colspan="3">普保Ⅱ選択情報反映結果テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsntkinfono ztrsntkinfono}</td><td>（取込用）選択情報番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrrenno ztrrenno}</td><td>（取込用）連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsntkinfotourokusyskbn ztrsntkinfotourokusyskbn}</td><td>（取込用）選択情報登録システム区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhuho2kyknokbn</td><td>（取込用）普保Ⅱ契約番号区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhuho2kykno</td><td>（取込用）普保Ⅱ契約番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsntkinfofsegkbn</td><td>（取込用）選択情報ＦＳＥＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsntkinfofkojinkbn</td><td>（取込用）選択情報Ｆ個人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdakuhiketnaiyouarihyj</td><td>（取込用）諾否決定内容有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkktnaiyouarihyj</td><td>（取込用）告知内容有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkijinaiyouarihyj</td><td>（取込用）記事内容有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrmrarihyj</td><td>（取込用）ＭＲ有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkoudosyougaiarihyj</td><td>（取込用）高度障害有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtorikaijoarihyj</td><td>（取込用）取消解除有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsntkinjotourokuerrkbn</td><td>（取込用）選択情報登録エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrnayosehumeihyj</td><td>（取込用）名寄せ不明表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsntkinjohaneikekkayobi01</td><td>（取込用）選択情報反映結果予備０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SntkInfoHaneiKekkaTr
 * @see     GenZT_SntkInfoHaneiKekkaTr
 * @see     QZT_SntkInfoHaneiKekkaTr
 * @see     GenQZT_SntkInfoHaneiKekkaTr
 */
public class PKZT_SntkInfoHaneiKekkaTr extends AbstractExDBPrimaryKey<ZT_SntkInfoHaneiKekkaTr, PKZT_SntkInfoHaneiKekkaTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_SntkInfoHaneiKekkaTr() {
    }

    public PKZT_SntkInfoHaneiKekkaTr(
        String pZtrsntkinfono,
        Integer pZtrrenno,
        String pZtrsntkinfotourokusyskbn
    ) {
        ztrsntkinfono = pZtrsntkinfono;
        ztrrenno = pZtrrenno;
        ztrsntkinfotourokusyskbn = pZtrsntkinfotourokusyskbn;
    }

    @Transient
    @Override
    public Class<ZT_SntkInfoHaneiKekkaTr> getEntityClass() {
        return ZT_SntkInfoHaneiKekkaTr.class;
    }

    private String ztrsntkinfono;

    public String getZtrsntkinfono() {
        return ztrsntkinfono;
    }

    public void setZtrsntkinfono(String pZtrsntkinfono) {
        ztrsntkinfono = pZtrsntkinfono;
    }
    private Integer ztrrenno;

    public Integer getZtrrenno() {
        return ztrrenno;
    }

    public void setZtrrenno(Integer pZtrrenno) {
        ztrrenno = pZtrrenno;
    }
    private String ztrsntkinfotourokusyskbn;

    public String getZtrsntkinfotourokusyskbn() {
        return ztrsntkinfotourokusyskbn;
    }

    public void setZtrsntkinfotourokusyskbn(String pZtrsntkinfotourokusyskbn) {
        ztrsntkinfotourokusyskbn = pZtrsntkinfotourokusyskbn;
    }

}