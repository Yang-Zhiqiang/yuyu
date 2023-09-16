package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_RoleSiyouKanouSosiki;
import yuyu.def.db.mapping.GenAT_RoleSiyouKanouSosiki;
import yuyu.def.db.meta.GenQAT_RoleSiyouKanouSosiki;
import yuyu.def.db.meta.QAT_RoleSiyouKanouSosiki;

/**
 * ロール使用可能組織テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_RoleSiyouKanouSosiki}</td><td colspan="3">ロール使用可能組織テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyozokusosikicd syozokusosikicd}</td><td>所属組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_RoleSiyouKanouSosiki
 * @see     GenAT_RoleSiyouKanouSosiki
 * @see     QAT_RoleSiyouKanouSosiki
 * @see     GenQAT_RoleSiyouKanouSosiki
 */
public class PKAT_RoleSiyouKanouSosiki extends AbstractExDBPrimaryKey<AT_RoleSiyouKanouSosiki, PKAT_RoleSiyouKanouSosiki> {

    private static final long serialVersionUID = 1L;

    public PKAT_RoleSiyouKanouSosiki() {
    }

    public PKAT_RoleSiyouKanouSosiki(String pSyozokusosikicd, String pRoleCd) {
        syozokusosikicd = pSyozokusosikicd;
        roleCd = pRoleCd;
    }

    @Transient
    @Override
    public Class<AT_RoleSiyouKanouSosiki> getEntityClass() {
        return AT_RoleSiyouKanouSosiki.class;
    }

    private String syozokusosikicd;

    public String getSyozokusosikicd() {
        return syozokusosikicd;
    }

    public void setSyozokusosikicd(String pSyozokusosikicd) {
        syozokusosikicd = pSyozokusosikicd;
    }
    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }

}