package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.IM_KhTtdkTyuuikahi;
import yuyu.def.db.mapping.GenIM_KhTtdkTyuuikahi;
import yuyu.def.db.meta.GenQIM_KhTtdkTyuuikahi;
import yuyu.def.db.meta.QIM_KhTtdkTyuuikahi;

/**
 * 契約保全手続注意処理可否マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhTtdkTyuuikahi}</td><td colspan="3">契約保全手続注意処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTtdktyuuikbn ttdktyuuikbn}</td><td>手続注意区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>syorikahikbn</td><td>処理可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikahiKbn C_SyorikahiKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhTtdkTyuuikahi
 * @see     GenIM_KhTtdkTyuuikahi
 * @see     QIM_KhTtdkTyuuikahi
 * @see     GenQIM_KhTtdkTyuuikahi
 */
public class PKIM_KhTtdkTyuuikahi extends AbstractExDBPrimaryKey<IM_KhTtdkTyuuikahi, PKIM_KhTtdkTyuuikahi> {

    private static final long serialVersionUID = 1L;

    public PKIM_KhTtdkTyuuikahi() {
    }

    public PKIM_KhTtdkTyuuikahi(String pKinouId, C_TtdktyuuiKbn pTtdktyuuikbn) {
        kinouId = pKinouId;
        ttdktyuuikbn = pTtdktyuuikbn;
    }

    @Transient
    @Override
    public Class<IM_KhTtdkTyuuikahi> getEntityClass() {
        return IM_KhTtdkTyuuikahi.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }
    private C_TtdktyuuiKbn ttdktyuuikbn;

    @org.hibernate.annotations.Type(type="UserType_C_TtdktyuuiKbn")
    public C_TtdktyuuiKbn getTtdktyuuikbn() {
        return ttdktyuuikbn;
    }

    public void setTtdktyuuikbn(C_TtdktyuuiKbn pTtdktyuuikbn) {
        ttdktyuuikbn = pTtdktyuuikbn;
    }

}