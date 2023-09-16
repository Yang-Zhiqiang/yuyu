package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HM_Honkouza;
import yuyu.def.db.mapping.GenHM_Honkouza;
import yuyu.def.db.meta.GenQHM_Honkouza;
import yuyu.def.db.meta.QHM_Honkouza;

/**
 * 本口座マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_Honkouza}</td><td colspan="3">本口座マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHonkouzacd honkouzacd}</td><td>本口座コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sikinidousakibankcd</td><td>資金移動先銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sikinidousakisitencd</td><td>資金移動先支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sikinidousakikouzano</td><td>資金移動先口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tuukasyu</td><td>通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>hyoujijyun</td><td>表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     HM_Honkouza
 * @see     GenHM_Honkouza
 * @see     QHM_Honkouza
 * @see     GenQHM_Honkouza
 */
public class PKHM_Honkouza extends AbstractExDBPrimaryKey<HM_Honkouza, PKHM_Honkouza> {

    private static final long serialVersionUID = 1L;

    public PKHM_Honkouza() {
    }

    public PKHM_Honkouza(String pHonkouzacd) {
        honkouzacd = pHonkouzacd;
    }

    @Transient
    @Override
    public Class<HM_Honkouza> getEntityClass() {
        return HM_Honkouza.class;
    }

    private String honkouzacd;

    public String getHonkouzacd() {
        return honkouzacd;
    }

    public void setHonkouzacd(String pHonkouzacd) {
        honkouzacd = pHonkouzacd;
    }

}