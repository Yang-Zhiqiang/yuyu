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
import jp.co.slcs.swak.validation.constraints.Range;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_IkkatuKeisuu;
import yuyu.def.db.id.PKBM_IkkatuKeisuu;
import yuyu.def.db.meta.GenQBM_IkkatuKeisuu;
import yuyu.def.db.meta.QBM_IkkatuKeisuu;

/**
 * 一括払係数マスタ テーブルのマッピング情報クラスで、 {@link BM_IkkatuKeisuu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_IkkatuKeisuu}</td><td colspan="3">一括払係数マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIkttekiyouno ikttekiyouno}</td><td>一括払適用番号</td><td align="center">{@link PKBM_IkkatuKeisuu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNen1nen2baraihyouji nen1nen2baraihyouji}</td><td>年１回年２回払表示</td><td align="center">{@link PKBM_IkkatuKeisuu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKeikatukisuu keikatukisuu}</td><td>経過月数（２桁）</td><td align="center">{@link PKBM_IkkatuKeisuu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getIktkeisuu iktkeisuu}</td><td>一括払係数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_IkkatuKeisuu
 * @see     PKBM_IkkatuKeisuu
 * @see     QBM_IkkatuKeisuu
 * @see     GenQBM_IkkatuKeisuu
 */
@MappedSuperclass
@Table(name=GenBM_IkkatuKeisuu.TABLE_NAME)
@IdClass(value=PKBM_IkkatuKeisuu.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_IkkatuKeisuu extends AbstractExDBEntity<BM_IkkatuKeisuu, PKBM_IkkatuKeisuu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_IkkatuKeisuu";
    public static final String IKTTEKIYOUNO             = "ikttekiyouno";
    public static final String NEN1NEN2BARAIHYOUJI      = "nen1nen2baraihyouji";
    public static final String KEIKATUKISUU             = "keikatukisuu";
    public static final String IKTKEISUU                = "iktkeisuu";

    private final PKBM_IkkatuKeisuu primaryKey;

    public GenBM_IkkatuKeisuu() {
        primaryKey = new PKBM_IkkatuKeisuu();
    }

    public GenBM_IkkatuKeisuu(
        Integer pIkttekiyouno,
        Integer pNen1nen2baraihyouji,
        Integer pKeikatukisuu
    ) {
        primaryKey = new PKBM_IkkatuKeisuu(
            pIkttekiyouno,
            pNen1nen2baraihyouji,
            pKeikatukisuu
        );
    }

    @Transient
    @Override
    public PKBM_IkkatuKeisuu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_IkkatuKeisuu> getMetaClass() {
        return QBM_IkkatuKeisuu.class;
    }

    @Id
    @Column(name=GenBM_IkkatuKeisuu.IKTTEKIYOUNO)
    public Integer getIkttekiyouno() {
        return getPrimaryKey().getIkttekiyouno();
    }

    public void setIkttekiyouno(Integer pIkttekiyouno) {
        getPrimaryKey().setIkttekiyouno(pIkttekiyouno);
    }

    @Id
    @Column(name=GenBM_IkkatuKeisuu.NEN1NEN2BARAIHYOUJI)
    public Integer getNen1nen2baraihyouji() {
        return getPrimaryKey().getNen1nen2baraihyouji();
    }

    public void setNen1nen2baraihyouji(Integer pNen1nen2baraihyouji) {
        getPrimaryKey().setNen1nen2baraihyouji(pNen1nen2baraihyouji);
    }

    @Id
    @Column(name=GenBM_IkkatuKeisuu.KEIKATUKISUU)
    @Range(min="0", max="12")
    public Integer getKeikatukisuu() {
        return getPrimaryKey().getKeikatukisuu();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKeikatukisuu(Integer pKeikatukisuu) {
        getPrimaryKey().setKeikatukisuu(pKeikatukisuu);
    }

    private BizNumber iktkeisuu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_IkkatuKeisuu.IKTKEISUU)
    public BizNumber getIktkeisuu() {
        return iktkeisuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIktkeisuu(BizNumber pIktkeisuu) {
        iktkeisuu = pIktkeisuu;
    }
}