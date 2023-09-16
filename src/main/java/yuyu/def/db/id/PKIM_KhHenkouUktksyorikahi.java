package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.IM_KhHenkouUktksyorikahi;
import yuyu.def.db.mapping.GenIM_KhHenkouUktksyorikahi;
import yuyu.def.db.meta.GenQIM_KhHenkouUktksyorikahi;
import yuyu.def.db.meta.QIM_KhHenkouUktksyorikahi;

/**
 * 契約保全変更受付中処理可否マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhHenkouUktksyorikahi}</td><td colspan="3">契約保全変更受付中処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUktksyorikbn uktksyorikbn}</td><td>受付処理区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UktkSyoriKbn}</td></tr>
 *  <tr><td>yuukoujyotaikahikbn</td><td>有効状態処理可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuukoujyotaikahiKbn C_YuukoujyotaikahiKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhHenkouUktksyorikahi
 * @see     GenIM_KhHenkouUktksyorikahi
 * @see     QIM_KhHenkouUktksyorikahi
 * @see     GenQIM_KhHenkouUktksyorikahi
 */
public class PKIM_KhHenkouUktksyorikahi extends AbstractExDBPrimaryKey<IM_KhHenkouUktksyorikahi, PKIM_KhHenkouUktksyorikahi> {

    private static final long serialVersionUID = 1L;

    public PKIM_KhHenkouUktksyorikahi() {
    }

    public PKIM_KhHenkouUktksyorikahi(String pKinouId, C_UktkSyoriKbn pUktksyorikbn) {
        kinouId = pKinouId;
        uktksyorikbn = pUktksyorikbn;
    }

    @Transient
    @Override
    public Class<IM_KhHenkouUktksyorikahi> getEntityClass() {
        return IM_KhHenkouUktksyorikahi.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }
    private C_UktkSyoriKbn uktksyorikbn;

    @org.hibernate.annotations.Type(type="UserType_C_UktkSyoriKbn")
    public C_UktkSyoriKbn getUktksyorikbn() {
        return uktksyorikbn;
    }

    public void setUktksyorikbn(C_UktkSyoriKbn pUktksyorikbn) {
        uktksyorikbn = pUktksyorikbn;
    }

}