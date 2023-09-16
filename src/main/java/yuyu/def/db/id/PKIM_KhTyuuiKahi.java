package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IM_KhTyuuiKahi;
import yuyu.def.db.mapping.GenIM_KhTyuuiKahi;
import yuyu.def.db.meta.GenQIM_KhTyuuiKahi;
import yuyu.def.db.meta.QIM_KhTyuuiKahi;

/**
 * 契約保全注意取扱処理可否マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhTyuuiKahi}</td><td colspan="3">契約保全注意取扱処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorikahikbn</td><td>処理可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikahiKbn C_SyorikahiKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhTyuuiKahi
 * @see     GenIM_KhTyuuiKahi
 * @see     QIM_KhTyuuiKahi
 * @see     GenQIM_KhTyuuiKahi
 */
public class PKIM_KhTyuuiKahi extends AbstractExDBPrimaryKey<IM_KhTyuuiKahi, PKIM_KhTyuuiKahi> {

    private static final long serialVersionUID = 1L;

    public PKIM_KhTyuuiKahi() {
    }

    public PKIM_KhTyuuiKahi(String pKinouId) {
        kinouId = pKinouId;
    }

    @Transient
    @Override
    public Class<IM_KhTyuuiKahi> getEntityClass() {
        return IM_KhTyuuiKahi.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

}