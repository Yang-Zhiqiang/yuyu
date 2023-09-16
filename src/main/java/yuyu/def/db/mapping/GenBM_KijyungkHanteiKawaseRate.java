package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;
import yuyu.def.db.id.PKBM_KijyungkHanteiKawaseRate;
import yuyu.def.db.meta.GenQBM_KijyungkHanteiKawaseRate;
import yuyu.def.db.meta.QBM_KijyungkHanteiKawaseRate;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 基準額判定用為替レートマスタ テーブルのマッピング情報クラスで、 {@link BM_KijyungkHanteiKawaseRate} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KijyungkHanteiKawaseRate}</td><td colspan="3">基準額判定用為替レートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKijunnendo kijunnendo}</td><td>基準年度</td><td align="center">{@link PKBM_KijyungkHanteiKawaseRate ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">{@link PKBM_KijyungkHanteiKawaseRate ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKjngkhntiyukawaserate kjngkhntiyukawaserate}</td><td>基準額判定用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_KijyungkHanteiKawaseRate
 * @see     PKBM_KijyungkHanteiKawaseRate
 * @see     QBM_KijyungkHanteiKawaseRate
 * @see     GenQBM_KijyungkHanteiKawaseRate
 */
@MappedSuperclass
@Table(name=GenBM_KijyungkHanteiKawaseRate.TABLE_NAME)
@IdClass(value=PKBM_KijyungkHanteiKawaseRate.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_KijyungkHanteiKawaseRate extends AbstractExDBEntity<BM_KijyungkHanteiKawaseRate, PKBM_KijyungkHanteiKawaseRate> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_KijyungkHanteiKawaseRate";
    public static final String KIJUNNENDO               = "kijunnendo";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String KJNGKHNTIYUKAWASERATE    = "kjngkhntiyukawaserate";

    private final PKBM_KijyungkHanteiKawaseRate primaryKey;

    public GenBM_KijyungkHanteiKawaseRate() {
        primaryKey = new PKBM_KijyungkHanteiKawaseRate();
    }

    public GenBM_KijyungkHanteiKawaseRate(String pKijunnendo, C_Tuukasyu pKyktuukasyu) {
        primaryKey = new PKBM_KijyungkHanteiKawaseRate(pKijunnendo, pKyktuukasyu);
    }

    @Transient
    @Override
    public PKBM_KijyungkHanteiKawaseRate getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_KijyungkHanteiKawaseRate> getMetaClass() {
        return QBM_KijyungkHanteiKawaseRate.class;
    }

    @Id
    @Column(name=GenBM_KijyungkHanteiKawaseRate.KIJUNNENDO)
    public String getKijunnendo() {
        return getPrimaryKey().getKijunnendo();
    }

    public void setKijunnendo(String pKijunnendo) {
        getPrimaryKey().setKijunnendo(pKijunnendo);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_KijyungkHanteiKawaseRate.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return getPrimaryKey().getKyktuukasyu();
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        getPrimaryKey().setKyktuukasyu(pKyktuukasyu);
    }

    private BizNumber kjngkhntiyukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenBM_KijyungkHanteiKawaseRate.KJNGKHNTIYUKAWASERATE)
    public BizNumber getKjngkhntiyukawaserate() {
        return kjngkhntiyukawaserate;
    }

    public void setKjngkhntiyukawaserate(BizNumber pKjngkhntiyukawaserate) {
        kjngkhntiyukawaserate = pKjngkhntiyukawaserate;
    }
}
