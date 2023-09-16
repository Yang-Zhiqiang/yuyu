package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SosikiRn;
import yuyu.def.db.mapping.GenZT_SosikiRn;
import yuyu.def.db.meta.GenQZT_SosikiRn;
import yuyu.def.db.meta.QZT_SosikiRn;

/**
 * 普保用組織ＰＲＴ用連動Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SosikiRn}</td><td colspan="3">普保用組織ＰＲＴ用連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsosikicd zrnsosikicd}</td><td>（連携用）組織コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikinmkbn</td><td>（連携用）組織名区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikinm20</td><td>（連携用）組織名（２０文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjisosikinm20</td><td>（連携用）漢字組織名（２０文字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsosikihaisiy</td><td>（連携用）組織廃止年月年</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikihaisim</td><td>（連携用）組織廃止年月月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikisinsetuy</td><td>（連携用）組織新設年月年</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikisinsetum</td><td>（連携用）組織新設年月月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntougetukeisyousosikicd</td><td>（連携用）当月継承組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntougetukeisyoueigyoubucd</td><td>（連携用）当月継承営業推進部コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzengetukeisyousosikicd</td><td>（連携用）前月継承組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzengetukeisyoueigyoubucd</td><td>（連携用）前月継承営業推進部コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikikihontikucd</td><td>（連携用）組織基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikikanjikaiadr30</td><td>（連携用）組織漢字下位住所（３０文字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkanjibilunm15</td><td>（連携用）漢字ビル名称（１５文字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsosikinyuukyokaisuu</td><td>（連携用）組織入居階数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikidenwabangousigai</td><td>（連携用）組織電話番号市外局番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikitdenwabangousinai</td><td>（連携用）組織電話番号市内局番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikidenwabangoubangou</td><td>（連携用）組織電話番号番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikifaxbangousigai</td><td>（連携用）組織ＦＡＸ番号市外局番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikifaxbangousinai</td><td>（連携用）組織ＦＡＸ番号市内局番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikifaxbangoubangou</td><td>（連携用）組織ＦＡＸ番号番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouryokukaisiy</td><td>（連携用）効力開始年月年</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouryokukaisim</td><td>（連携用）効力開始年月月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouryokukaisid</td><td>（連携用）効力開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnewsosikikihontikucd</td><td>（連携用）(変更後)組織基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnewkanjisosikikaiadr30</td><td>（連携用）(変更後)漢字組織下位住所（３０文字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnewkanjibilunm15</td><td>（連携用）(変更後)漢字ビル名称（１５文字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnewsosikinyuukyokaisuu</td><td>（連携用）(変更後)組織入居階数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnewsosikidenwasigai</td><td>（連携用）(変更後)組織電話番号市外局番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnewsosikidenwasinai</td><td>（連携用）(変更後)組織電話番号市内局番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnewsosikidenwabangou</td><td>（連携用）(変更後)組織電話番号番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnewsosikifaxsigai</td><td>（連携用）(変更後)組織ＦＡＸ番号市外局番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnewsosikifaxsinai</td><td>（連携用）(変更後)組織ＦＡＸ番号市内局番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnewsosikifaxbangou</td><td>（連携用）(変更後)組織ＦＡＸ番号番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SosikiRn
 * @see     GenZT_SosikiRn
 * @see     QZT_SosikiRn
 * @see     GenQZT_SosikiRn
 */
public class PKZT_SosikiRn extends AbstractExDBPrimaryKey<ZT_SosikiRn, PKZT_SosikiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SosikiRn() {
    }

    public PKZT_SosikiRn(String pZrnsosikicd) {
        zrnsosikicd = pZrnsosikicd;
    }

    @Transient
    @Override
    public Class<ZT_SosikiRn> getEntityClass() {
        return ZT_SosikiRn.class;
    }

    private String zrnsosikicd;

    public String getZrnsosikicd() {
        return zrnsosikicd;
    }

    public void setZrnsosikicd(String pZrnsosikicd) {
        zrnsosikicd = pZrnsosikicd;
    }

}