package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BM_Syoubyou;
import yuyu.def.db.mapping.GenBM_Syoubyou;
import yuyu.def.db.meta.GenQBM_Syoubyou;
import yuyu.def.db.meta.QBM_Syoubyou;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * 傷病マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Syoubyou}</td><td colspan="3">傷病マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoubyoucd syoubyoucd}</td><td>傷病コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoubyounm</td><td>傷病名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoubyoucdtyuubunruikbn</td><td>傷病コード中分類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoubyouCdTyuubunruiKbn C_SyoubyouCdTyuubunruiKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Syoubyou
 * @see     GenBM_Syoubyou
 * @see     QBM_Syoubyou
 * @see     GenQBM_Syoubyou
 */
public class PKBM_Syoubyou extends AbstractExDBPrimaryKey<BM_Syoubyou, PKBM_Syoubyou> {

    private static final long serialVersionUID = 1L;

    public PKBM_Syoubyou() {
    }

    public PKBM_Syoubyou(String pSyoubyoucd) {
        syoubyoucd = pSyoubyoucd;
    }

    @Transient
    @Override
    public Class<BM_Syoubyou> getEntityClass() {
        return BM_Syoubyou.class;
    }

    private String syoubyoucd;

    public String getSyoubyoucd() {
        return syoubyoucd;
    }

    public void setSyoubyoucd(String pSyoubyoucd) {
        syoubyoucd = pSyoubyoucd;
    }

}