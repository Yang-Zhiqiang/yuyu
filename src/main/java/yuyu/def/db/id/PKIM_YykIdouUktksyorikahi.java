package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IM_YykIdouUktksyorikahi;
import yuyu.def.db.mapping.GenIM_YykIdouUktksyorikahi;
import yuyu.def.db.meta.GenQIM_YykIdouUktksyorikahi;
import yuyu.def.db.meta.QIM_YykIdouUktksyorikahi;

/**
 * 予約異動受付中処理可否マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_YykIdouUktksyorikahi}</td><td colspan="3">予約異動受付中処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYykuktkkinouid yykuktkkinouid}</td><td>予約受付中機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yuukoujyotaikahikbn</td><td>有効状態処理可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuukoujyotaikahiKbn C_YuukoujyotaikahiKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_YykIdouUktksyorikahi
 * @see     GenIM_YykIdouUktksyorikahi
 * @see     QIM_YykIdouUktksyorikahi
 * @see     GenQIM_YykIdouUktksyorikahi
 */
public class PKIM_YykIdouUktksyorikahi extends AbstractExDBPrimaryKey<IM_YykIdouUktksyorikahi, PKIM_YykIdouUktksyorikahi> {

    private static final long serialVersionUID = 1L;

    public PKIM_YykIdouUktksyorikahi() {
    }

    public PKIM_YykIdouUktksyorikahi(String pKinouId, String pYykuktkkinouid) {
        kinouId = pKinouId;
        yykuktkkinouid = pYykuktkkinouid;
    }

    @Transient
    @Override
    public Class<IM_YykIdouUktksyorikahi> getEntityClass() {
        return IM_YykIdouUktksyorikahi.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }
    private String yykuktkkinouid;

    public String getYykuktkkinouid() {
        return yykuktkkinouid;
    }

    public void setYykuktkkinouid(String pYykuktkkinouid) {
        yykuktkkinouid = pYykuktkkinouid;
    }

}