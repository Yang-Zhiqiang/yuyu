package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.mapping.GenAM_Role;
import yuyu.def.db.meta.GenQAM_Role;
import yuyu.def.db.meta.QAM_Role;

/**
 * ロールマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_Role}</td><td colspan="3">ロールマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>roleNm</td><td>ロール名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>roleSetumei</td><td>ロール説明</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sysSiyouKbn</td><td>システム使用区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SysSiyouKbn C_SysSiyouKbn}</td></tr>
 * </table>
 * @see     AM_Role
 * @see     GenAM_Role
 * @see     QAM_Role
 * @see     GenQAM_Role
 */
public class PKAM_Role extends AbstractExDBPrimaryKey<AM_Role, PKAM_Role> {

    private static final long serialVersionUID = 1L;

    public PKAM_Role() {
    }

    public PKAM_Role(String pRoleCd) {
        roleCd = pRoleCd;
    }

    @Transient
    @Override
    public Class<AM_Role> getEntityClass() {
        return AM_Role.class;
    }

    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }

}