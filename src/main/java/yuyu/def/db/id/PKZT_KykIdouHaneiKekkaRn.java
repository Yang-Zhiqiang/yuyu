package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.mapping.GenZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.meta.GenQZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.meta.QZT_KykIdouHaneiKekkaRn;

/**
 * 普保Ⅱ契約異動反映結果テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KykIdouHaneiKekkaRn}</td><td colspan="3">普保Ⅱ契約異動反映結果テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhuho2kyknokbn zrnhuho2kyknokbn}</td><td>（連携用）普保Ⅱ契約番号区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhuho2kykno zrnhuho2kykno}</td><td>（連携用）普保Ⅱ契約番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknaiyouhaneierrkbn</td><td>（連携用）契約内容反映エラー区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsnkijyuntyoukahyj</td><td>（連携用）通算基準超過表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnayosehumeihyj</td><td>（連携用）被保険者名寄せ不明表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknayosehumeihyj</td><td>（連携用）契約者名寄せ不明表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkuktnayosehumeihyj</td><td>（連携用）年金受取人名寄せ不明表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntjtidouhaneikekkayobi01</td><td>（連携用）当日異動内容反映結果予備０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KykIdouHaneiKekkaRn
 * @see     GenZT_KykIdouHaneiKekkaRn
 * @see     QZT_KykIdouHaneiKekkaRn
 * @see     GenQZT_KykIdouHaneiKekkaRn
 */
public class PKZT_KykIdouHaneiKekkaRn extends AbstractExDBPrimaryKey<ZT_KykIdouHaneiKekkaRn, PKZT_KykIdouHaneiKekkaRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KykIdouHaneiKekkaRn() {
    }

    public PKZT_KykIdouHaneiKekkaRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {
        zrnhuho2kyknokbn = pZrnhuho2kyknokbn;
        zrnhuho2kykno = pZrnhuho2kykno;
    }

    @Transient
    @Override
    public Class<ZT_KykIdouHaneiKekkaRn> getEntityClass() {
        return ZT_KykIdouHaneiKekkaRn.class;
    }

    private String zrnhuho2kyknokbn;

    public String getZrnhuho2kyknokbn() {
        return zrnhuho2kyknokbn;
    }

    public void setZrnhuho2kyknokbn(String pZrnhuho2kyknokbn) {
        zrnhuho2kyknokbn = pZrnhuho2kyknokbn;
    }
    private String zrnhuho2kykno;

    public String getZrnhuho2kykno() {
        return zrnhuho2kykno;
    }

    public void setZrnhuho2kykno(String pZrnhuho2kykno) {
        zrnhuho2kykno = pZrnhuho2kykno;
    }

}