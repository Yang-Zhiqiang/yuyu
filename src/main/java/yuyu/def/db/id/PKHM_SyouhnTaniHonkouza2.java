package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza2;
import yuyu.def.db.mapping.GenHM_SyouhnTaniHonkouza2;
import yuyu.def.db.meta.GenQHM_SyouhnTaniHonkouza2;
import yuyu.def.db.meta.QHM_SyouhnTaniHonkouza2;

/**
 * 商品単位本口座マスタ２ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SyouhnTaniHonkouza2}</td><td colspan="3">商品単位本口座マスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>honkouzacd</td><td>本口座コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_SyouhnTaniHonkouza2
 * @see     GenHM_SyouhnTaniHonkouza2
 * @see     QHM_SyouhnTaniHonkouza2
 * @see     GenQHM_SyouhnTaniHonkouza2
 */
public class PKHM_SyouhnTaniHonkouza2 extends AbstractExDBPrimaryKey<HM_SyouhnTaniHonkouza2, PKHM_SyouhnTaniHonkouza2> {

    private static final long serialVersionUID = 1L;

    public PKHM_SyouhnTaniHonkouza2() {
    }

    public PKHM_SyouhnTaniHonkouza2(String pSyouhncd, C_Tuukasyu pKyktuukasyu) {
        syouhncd = pSyouhncd;
        kyktuukasyu = pKyktuukasyu;
    }

    @Transient
    @Override
    public Class<HM_SyouhnTaniHonkouza2> getEntityClass() {
        return HM_SyouhnTaniHonkouza2.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private C_Tuukasyu kyktuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

}