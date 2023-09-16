package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.def.db.mapping.GenBW_UserIdKanrenWk;
import yuyu.def.db.meta.GenQBW_UserIdKanrenWk;
import yuyu.def.db.meta.QBW_UserIdKanrenWk;

/**
 * ユーザーＩＤ関連ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BW_UserIdKanrenWk}</td><td colspan="3">ユーザーＩＤ関連ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getIdkbn idkbn}</td><td>ＩＤ区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIdcd idcd}</td><td>ＩＤコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>userId</td><td>ユーザーＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BW_UserIdKanrenWk
 * @see     GenBW_UserIdKanrenWk
 * @see     QBW_UserIdKanrenWk
 * @see     GenQBW_UserIdKanrenWk
 */
public class PKBW_UserIdKanrenWk extends AbstractExDBPrimaryKey<BW_UserIdKanrenWk, PKBW_UserIdKanrenWk> {

    private static final long serialVersionUID = 1L;

    public PKBW_UserIdKanrenWk() {
    }

    public PKBW_UserIdKanrenWk(String pIdkbn, String pIdcd) {
        idkbn = pIdkbn;
        idcd = pIdcd;
    }

    @Transient
    @Override
    public Class<BW_UserIdKanrenWk> getEntityClass() {
        return BW_UserIdKanrenWk.class;
    }

    private String idkbn;

    public String getIdkbn() {
        return idkbn;
    }

    public void setIdkbn(String pIdkbn) {
        idkbn = pIdkbn;
    }
    private String idcd;

    public String getIdcd() {
        return idcd;
    }

    public void setIdcd(String pIdcd) {
        idcd = pIdcd;
    }

}