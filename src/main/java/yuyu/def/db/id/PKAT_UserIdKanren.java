package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_UserIdKanren;
import yuyu.def.db.mapping.GenAT_UserIdKanren;
import yuyu.def.db.meta.GenQAT_UserIdKanren;
import yuyu.def.db.meta.QAT_UserIdKanren;

/**
 * ユーザーＩＤ関連テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_UserIdKanren}</td><td colspan="3">ユーザーＩＤ関連テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getIdkbn idkbn}</td><td>ＩＤ区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIdcd idcd}</td><td>ＩＤコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>userId</td><td>ユーザーＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_UserIdKanren
 * @see     GenAT_UserIdKanren
 * @see     QAT_UserIdKanren
 * @see     GenQAT_UserIdKanren
 */
public class PKAT_UserIdKanren extends AbstractExDBPrimaryKey<AT_UserIdKanren, PKAT_UserIdKanren> {

    private static final long serialVersionUID = 1L;

    public PKAT_UserIdKanren() {
    }

    public PKAT_UserIdKanren(String pIdkbn, String pIdcd) {
        idkbn = pIdkbn;
        idcd = pIdcd;
    }

    @Transient
    @Override
    public Class<AT_UserIdKanren> getEntityClass() {
        return AT_UserIdKanren.class;
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