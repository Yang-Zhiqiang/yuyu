package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza;
import yuyu.def.db.mapping.GenHM_SyouhnTaniHonkouza;
import yuyu.def.db.meta.GenQHM_SyouhnTaniHonkouza;
import yuyu.def.db.meta.QHM_SyouhnTaniHonkouza;

/**
 * 商品単位本口座マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SyouhnTaniHonkouza}</td><td colspan="3">商品単位本口座マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>honkouzacd</td><td>本口座コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_SyouhnTaniHonkouza
 * @see     GenHM_SyouhnTaniHonkouza
 * @see     QHM_SyouhnTaniHonkouza
 * @see     GenQHM_SyouhnTaniHonkouza
 */
public class PKHM_SyouhnTaniHonkouza extends AbstractExDBPrimaryKey<HM_SyouhnTaniHonkouza, PKHM_SyouhnTaniHonkouza> {

    private static final long serialVersionUID = 1L;

    public PKHM_SyouhnTaniHonkouza() {
    }

    public PKHM_SyouhnTaniHonkouza(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    @Transient
    @Override
    public Class<HM_SyouhnTaniHonkouza> getEntityClass() {
        return HM_SyouhnTaniHonkouza.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

}