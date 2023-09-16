package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IM_Syorijtkahi;
import yuyu.def.db.mapping.GenIM_Syorijtkahi;
import yuyu.def.db.meta.GenQIM_Syorijtkahi;
import yuyu.def.db.meta.QIM_Syorijtkahi;

/**
 * 処理状態処理可否マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_Syorijtkahi}</td><td colspan="3">処理状態処理可否マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyorijimuttdkcd syorijimuttdkcd}</td><td>処理中事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoritaskid syoritaskid}</td><td>処理中タスクＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yuukoujyotaikahikbn</td><td>有効状態処理可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuukoujyotaikahiKbn C_YuukoujyotaikahiKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_Syorijtkahi
 * @see     GenIM_Syorijtkahi
 * @see     QIM_Syorijtkahi
 * @see     GenQIM_Syorijtkahi
 */
public class PKIM_Syorijtkahi extends AbstractExDBPrimaryKey<IM_Syorijtkahi, PKIM_Syorijtkahi> {

    private static final long serialVersionUID = 1L;

    public PKIM_Syorijtkahi() {
    }

    public PKIM_Syorijtkahi(
        String pKinouId,
        String pSyorijimuttdkcd,
        String pSyoritaskid
    ) {
        kinouId = pKinouId;
        syorijimuttdkcd = pSyorijimuttdkcd;
        syoritaskid = pSyoritaskid;
    }

    @Transient
    @Override
    public Class<IM_Syorijtkahi> getEntityClass() {
        return IM_Syorijtkahi.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }
    private String syorijimuttdkcd;

    public String getSyorijimuttdkcd() {
        return syorijimuttdkcd;
    }

    public void setSyorijimuttdkcd(String pSyorijimuttdkcd) {
        syorijimuttdkcd = pSyorijimuttdkcd;
    }
    private String syoritaskid;

    public String getSyoritaskid() {
        return syoritaskid;
    }

    public void setSyoritaskid(String pSyoritaskid) {
        syoritaskid = pSyoritaskid;
    }

}