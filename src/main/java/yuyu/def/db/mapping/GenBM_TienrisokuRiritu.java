package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_TienrisokuRiritu;
import yuyu.def.db.id.PKBM_TienrisokuRiritu;
import yuyu.def.db.meta.GenQBM_TienrisokuRiritu;
import yuyu.def.db.meta.QBM_TienrisokuRiritu;

/**
 * 遅延利息利率マスタ テーブルのマッピング情報クラスで、 {@link BM_TienrisokuRiritu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_TienrisokuRiritu}</td><td colspan="3">遅延利息利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTekiyoukknfrom tekiyoukknfrom}</td><td>適用期間（自）</td><td align="center">{@link PKBM_TienrisokuRiritu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyoukknkto tekiyoukknkto}</td><td>適用期間（至）</td><td align="center">{@link PKBM_TienrisokuRiritu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTienrisokuriritu tienrisokuriritu}</td><td>遅延利息利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_TienrisokuRiritu
 * @see     PKBM_TienrisokuRiritu
 * @see     QBM_TienrisokuRiritu
 * @see     GenQBM_TienrisokuRiritu
 */
@MappedSuperclass
@Table(name=GenBM_TienrisokuRiritu.TABLE_NAME)
@IdClass(value=PKBM_TienrisokuRiritu.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_TienrisokuRiritu extends AbstractExDBEntity<BM_TienrisokuRiritu, PKBM_TienrisokuRiritu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_TienrisokuRiritu";
    public static final String TEKIYOUKKNFROM           = "tekiyoukknfrom";
    public static final String TEKIYOUKKNKTO            = "tekiyoukknkto";
    public static final String TIENRISOKURIRITU         = "tienrisokuriritu";

    private final PKBM_TienrisokuRiritu primaryKey;

    public GenBM_TienrisokuRiritu() {
        primaryKey = new PKBM_TienrisokuRiritu();
    }

    public GenBM_TienrisokuRiritu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        primaryKey = new PKBM_TienrisokuRiritu(pTekiyoukknfrom, pTekiyoukknkto);
    }

    @Transient
    @Override
    public PKBM_TienrisokuRiritu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_TienrisokuRiritu> getMetaClass() {
        return QBM_TienrisokuRiritu.class;
    }

    @Id
    @Column(name=GenBM_TienrisokuRiritu.TEKIYOUKKNFROM)
    @Length(length=8)
    @SingleByteStrings
    @Digit
    public String getTekiyoukknfrom() {
        return getPrimaryKey().getTekiyoukknfrom();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyoukknfrom(String pTekiyoukknfrom) {
        getPrimaryKey().setTekiyoukknfrom(pTekiyoukknfrom);
    }

    @Id
    @Column(name=GenBM_TienrisokuRiritu.TEKIYOUKKNKTO)
    @Length(length=8)
    @SingleByteStrings
    @Digit
    public String getTekiyoukknkto() {
        return getPrimaryKey().getTekiyoukknkto();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyoukknkto(String pTekiyoukknkto) {
        getPrimaryKey().setTekiyoukknkto(pTekiyoukknkto);
    }

    private BizNumber tienrisokuriritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_TienrisokuRiritu.TIENRISOKURIRITU)
    public BizNumber getTienrisokuriritu() {
        return tienrisokuriritu;
    }

    public void setTienrisokuriritu(BizNumber pTienrisokuriritu) {
        tienrisokuriritu = pTienrisokuriritu;
    }
}