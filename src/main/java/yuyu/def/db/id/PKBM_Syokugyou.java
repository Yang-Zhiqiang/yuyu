package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BM_Syokugyou;
import yuyu.def.db.mapping.GenBM_Syokugyou;
import yuyu.def.db.meta.GenQBM_Syokugyou;
import yuyu.def.db.meta.QBM_Syokugyou;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * 職業マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Syokugyou}</td><td colspan="3">職業マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyokugyoucd syokugyoucd}</td><td>職業コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syokugyounm</td><td>職業名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Syokugyou
 * @see     GenBM_Syokugyou
 * @see     QBM_Syokugyou
 * @see     GenQBM_Syokugyou
 */
public class PKBM_Syokugyou extends AbstractExDBPrimaryKey<BM_Syokugyou, PKBM_Syokugyou> {

    private static final long serialVersionUID = 1L;

    public PKBM_Syokugyou() {
    }

    public PKBM_Syokugyou(String pSyokugyoucd) {
        syokugyoucd = pSyokugyoucd;
    }

    @Transient
    @Override
    public Class<BM_Syokugyou> getEntityClass() {
        return BM_Syokugyou.class;
    }

    private String syokugyoucd;

    public String getSyokugyoucd() {
        return syokugyoucd;
    }

    public void setSyokugyoucd(String pSyokugyoucd) {
        syokugyoucd = pSyokugyoucd;
    }

}