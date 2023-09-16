package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_KinouKengen;
import yuyu.def.db.mapping.GenAT_KinouKengen;
import yuyu.def.db.meta.GenQAT_KinouKengen;
import yuyu.def.db.meta.QAT_KinouKengen;

/**
 * 機能権限テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_KinouKengen}</td><td colspan="3">機能権限テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouModeId kinouModeId}</td><td>機能モードＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siborikomiId</td><td>絞込みＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_KinouKengen
 * @see     GenAT_KinouKengen
 * @see     QAT_KinouKengen
 * @see     GenQAT_KinouKengen
 */
public class PKAT_KinouKengen extends AbstractExDBPrimaryKey<AT_KinouKengen, PKAT_KinouKengen> {

    private static final long serialVersionUID = 1L;

    public PKAT_KinouKengen() {
    }

    public PKAT_KinouKengen(
        String pKinouId,
        String pKinouModeId,
        String pRoleCd
    ) {
        kinouId = pKinouId;
        kinouModeId = pKinouModeId;
        roleCd = pRoleCd;
    }

    @Transient
    @Override
    public Class<AT_KinouKengen> getEntityClass() {
        return AT_KinouKengen.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }
    private String kinouModeId;

    public String getKinouModeId() {
        return kinouModeId;
    }

    public void setKinouModeId(String pKinouModeId) {
        kinouModeId = pKinouModeId;
    }
    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
    }

}