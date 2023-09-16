package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza2;
import yuyu.def.db.id.PKHM_SyouhnTaniHonkouza2;
import yuyu.def.db.meta.GenQHM_SyouhnTaniHonkouza2;
import yuyu.def.db.meta.QHM_SyouhnTaniHonkouza2;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 商品単位本口座マスタ２ テーブルのマッピング情報クラスで、 {@link HM_SyouhnTaniHonkouza2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SyouhnTaniHonkouza2}</td><td colspan="3">商品単位本口座マスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKHM_SyouhnTaniHonkouza2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">{@link PKHM_SyouhnTaniHonkouza2 ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHonkouzacd honkouzacd}</td><td>本口座コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_SyouhnTaniHonkouza2
 * @see     PKHM_SyouhnTaniHonkouza2
 * @see     QHM_SyouhnTaniHonkouza2
 * @see     GenQHM_SyouhnTaniHonkouza2
 */
@MappedSuperclass
@Table(name=GenHM_SyouhnTaniHonkouza2.TABLE_NAME)
@IdClass(value=PKHM_SyouhnTaniHonkouza2.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenHM_SyouhnTaniHonkouza2 extends AbstractExDBEntity<HM_SyouhnTaniHonkouza2, PKHM_SyouhnTaniHonkouza2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_SyouhnTaniHonkouza2";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String HONKOUZACD               = "honkouzacd";

    private final PKHM_SyouhnTaniHonkouza2 primaryKey;

    public GenHM_SyouhnTaniHonkouza2() {
        primaryKey = new PKHM_SyouhnTaniHonkouza2();
    }

    public GenHM_SyouhnTaniHonkouza2(String pSyouhncd, C_Tuukasyu pKyktuukasyu) {
        primaryKey = new PKHM_SyouhnTaniHonkouza2(pSyouhncd, pKyktuukasyu);
    }

    @Transient
    @Override
    public PKHM_SyouhnTaniHonkouza2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_SyouhnTaniHonkouza2> getMetaClass() {
        return QHM_SyouhnTaniHonkouza2.class;
    }

    @Id
    @Column(name=GenHM_SyouhnTaniHonkouza2.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHM_SyouhnTaniHonkouza2.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return getPrimaryKey().getKyktuukasyu();
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        getPrimaryKey().setKyktuukasyu(pKyktuukasyu);
    }

    private String honkouzacd;

    @Column(name=GenHM_SyouhnTaniHonkouza2.HONKOUZACD)
    public String getHonkouzacd() {
        return honkouzacd;
    }

    public void setHonkouzacd(String pHonkouzacd) {
        honkouzacd = pHonkouzacd;
    }
}