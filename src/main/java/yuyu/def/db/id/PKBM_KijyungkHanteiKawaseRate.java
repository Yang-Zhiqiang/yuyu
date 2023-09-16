package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;
import yuyu.def.db.mapping.GenBM_KijyungkHanteiKawaseRate;
import yuyu.def.db.meta.GenQBM_KijyungkHanteiKawaseRate;
import yuyu.def.db.meta.QBM_KijyungkHanteiKawaseRate;

/**
 * 基準額判定用為替レートマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KijyungkHanteiKawaseRate}</td><td colspan="3">基準額判定用為替レートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKijunnendo kijunnendo}</td><td>基準年度</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>kjngkhntiyukawaserate</td><td>基準額判定用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_KijyungkHanteiKawaseRate
 * @see     GenBM_KijyungkHanteiKawaseRate
 * @see     QBM_KijyungkHanteiKawaseRate
 * @see     GenQBM_KijyungkHanteiKawaseRate
 */
public class PKBM_KijyungkHanteiKawaseRate extends AbstractExDBPrimaryKey<BM_KijyungkHanteiKawaseRate, PKBM_KijyungkHanteiKawaseRate> {

    private static final long serialVersionUID = 1L;

    public PKBM_KijyungkHanteiKawaseRate() {
    }

    public PKBM_KijyungkHanteiKawaseRate(String pKijunnendo, C_Tuukasyu pKyktuukasyu) {
        kijunnendo = pKijunnendo;
        kyktuukasyu = pKyktuukasyu;
    }

    @Transient
    @Override
    public Class<BM_KijyungkHanteiKawaseRate> getEntityClass() {
        return BM_KijyungkHanteiKawaseRate.class;
    }

    private String kijunnendo;

    public String getKijunnendo() {
        return kijunnendo;
    }

    public void setKijunnendo(String pKijunnendo) {
        kijunnendo = pKijunnendo;
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