package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BM_HutanpoBui;
import yuyu.def.db.mapping.GenBM_HutanpoBui;
import yuyu.def.db.meta.GenQBM_HutanpoBui;
import yuyu.def.db.meta.QBM_HutanpoBui;

/**
 * 不担保部位マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_HutanpoBui}</td><td colspan="3">不担保部位マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHtnpbuicd htnpbuicd}</td><td>不担保部位コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpbuinm</td><td>不担保部位名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_HutanpoBui
 * @see     GenBM_HutanpoBui
 * @see     QBM_HutanpoBui
 * @see     GenQBM_HutanpoBui
 */
public class PKBM_HutanpoBui extends AbstractExDBPrimaryKey<BM_HutanpoBui, PKBM_HutanpoBui> {

    private static final long serialVersionUID = 1L;

    public PKBM_HutanpoBui() {
    }

    public PKBM_HutanpoBui(String pHtnpbuicd) {
        htnpbuicd = pHtnpbuicd;
    }

    @Transient
    @Override
    public Class<BM_HutanpoBui> getEntityClass() {
        return BM_HutanpoBui.class;
    }

    private String htnpbuicd;

    public String getHtnpbuicd() {
        return htnpbuicd;
    }

    public void setHtnpbuicd(String pHtnpbuicd) {
        htnpbuicd = pHtnpbuicd;
    }

}