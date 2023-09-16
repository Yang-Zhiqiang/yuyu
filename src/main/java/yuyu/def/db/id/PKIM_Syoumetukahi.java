package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.db.entity.IM_Syoumetukahi;
import yuyu.def.db.mapping.GenIM_Syoumetukahi;
import yuyu.def.db.meta.GenQIM_Syoumetukahi;
import yuyu.def.db.meta.QIM_Syoumetukahi;

/**
 * 消滅状態処理可否マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_Syoumetukahi}</td><td colspan="3">消滅状態処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoumetujiyuu syoumetujiyuu}</td><td>消滅事由</td><td align="center">○</td><td align="center">V</td><td>{@link C_Syoumetujiyuu}</td></tr>
 *  <tr><td>yuukoujyotaikahikbn</td><td>有効状態処理可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuukoujyotaikahiKbn C_YuukoujyotaikahiKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_Syoumetukahi
 * @see     GenIM_Syoumetukahi
 * @see     QIM_Syoumetukahi
 * @see     GenQIM_Syoumetukahi
 */
public class PKIM_Syoumetukahi extends AbstractExDBPrimaryKey<IM_Syoumetukahi, PKIM_Syoumetukahi> {

    private static final long serialVersionUID = 1L;

    public PKIM_Syoumetukahi() {
    }

    public PKIM_Syoumetukahi(String pKinouId, C_Syoumetujiyuu pSyoumetujiyuu) {
        kinouId = pKinouId;
        syoumetujiyuu = pSyoumetujiyuu;
    }

    @Transient
    @Override
    public Class<IM_Syoumetukahi> getEntityClass() {
        return IM_Syoumetukahi.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }
    private C_Syoumetujiyuu syoumetujiyuu;

    @org.hibernate.annotations.Type(type="UserType_C_Syoumetujiyuu")
    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

}