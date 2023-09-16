package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.mapping.GenZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.meta.GenQZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.meta.QZT_KykIdouHaneiKekkaTr;

/**
 * 普保Ⅱ契約異動反映結果テーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KykIdouHaneiKekkaTr}</td><td colspan="3">普保Ⅱ契約異動反映結果テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrhuho2kyknokbn ztrhuho2kyknokbn}</td><td>（取込用）普保Ⅱ契約番号区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrhuho2kykno ztrhuho2kykno}</td><td>（取込用）普保Ⅱ契約番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkyknaiyouhaneierrkbn</td><td>（取込用）契約内容反映エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtsnkijyuntyoukahyj</td><td>（取込用）通算基準超過表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhhknnayosehumeihyj</td><td>（取込用）被保険者名寄せ不明表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkyknayosehumeihyj</td><td>（取込用）契約者名寄せ不明表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrnkuktnayosehumeihyj</td><td>（取込用）年金受取人名寄せ不明表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtjtidouhaneikekkayobi01</td><td>（取込用）当日異動内容反映結果予備０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KykIdouHaneiKekkaTr
 * @see     GenZT_KykIdouHaneiKekkaTr
 * @see     QZT_KykIdouHaneiKekkaTr
 * @see     GenQZT_KykIdouHaneiKekkaTr
 */
public class PKZT_KykIdouHaneiKekkaTr extends AbstractExDBPrimaryKey<ZT_KykIdouHaneiKekkaTr, PKZT_KykIdouHaneiKekkaTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_KykIdouHaneiKekkaTr() {
    }

    public PKZT_KykIdouHaneiKekkaTr(String pZtrhuho2kyknokbn, String pZtrhuho2kykno) {
        ztrhuho2kyknokbn = pZtrhuho2kyknokbn;
        ztrhuho2kykno = pZtrhuho2kykno;
    }

    @Transient
    @Override
    public Class<ZT_KykIdouHaneiKekkaTr> getEntityClass() {
        return ZT_KykIdouHaneiKekkaTr.class;
    }

    private String ztrhuho2kyknokbn;

    public String getZtrhuho2kyknokbn() {
        return ztrhuho2kyknokbn;
    }

    public void setZtrhuho2kyknokbn(String pZtrhuho2kyknokbn) {
        ztrhuho2kyknokbn = pZtrhuho2kyknokbn;
    }
    private String ztrhuho2kykno;

    public String getZtrhuho2kykno() {
        return ztrhuho2kykno;
    }

    public void setZtrhuho2kykno(String pZtrhuho2kykno) {
        ztrhuho2kykno = pZtrhuho2kykno;
    }

}