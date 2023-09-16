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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.id.PKHM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.meta.GenQHM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.meta.QHM_TokuteiKankeiHjnNmTotugou;

/**
 * 特定関係法人名突合マスタ テーブルのマッピング情報クラスで、 {@link HM_TokuteiKankeiHjnNmTotugou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_TokuteiKankeiHjnNmTotugou}</td><td colspan="3">特定関係法人名突合マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTkhjnkinyuucd tkhjnkinyuucd}</td><td>特定関係法人金融機関コード</td><td align="center">{@link PKHM_TokuteiKankeiHjnNmTotugou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMeisaino meisaino}</td><td>明細番号</td><td align="center">{@link PKHM_TokuteiKankeiHjnNmTotugou ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHM_TokuteiKankeiHjnNmTotugou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTotugoutkhjnnmkj totugoutkhjnnmkj}</td><td>突合用特定関係法人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_TokuteiKankeiHjnNmTotugou
 * @see     PKHM_TokuteiKankeiHjnNmTotugou
 * @see     QHM_TokuteiKankeiHjnNmTotugou
 * @see     GenQHM_TokuteiKankeiHjnNmTotugou
 */
@MappedSuperclass
@Table(name=GenHM_TokuteiKankeiHjnNmTotugou.TABLE_NAME)
@IdClass(value=PKHM_TokuteiKankeiHjnNmTotugou.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenHM_TokuteiKankeiHjnNmTotugou extends AbstractExDBEntity<HM_TokuteiKankeiHjnNmTotugou, PKHM_TokuteiKankeiHjnNmTotugou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_TokuteiKankeiHjnNmTotugou";
    public static final String TKHJNKINYUUCD            = "tkhjnkinyuucd";
    public static final String MEISAINO                 = "meisaino";
    public static final String RENNO                    = "renno";
    public static final String TOTUGOUTKHJNNMKJ         = "totugoutkhjnnmkj";

    private final PKHM_TokuteiKankeiHjnNmTotugou primaryKey;

    public GenHM_TokuteiKankeiHjnNmTotugou() {
        primaryKey = new PKHM_TokuteiKankeiHjnNmTotugou();
    }

    public GenHM_TokuteiKankeiHjnNmTotugou(
        String pTkhjnkinyuucd,
        BizNumber pMeisaino,
        Integer pRenno
    ) {
        primaryKey = new PKHM_TokuteiKankeiHjnNmTotugou(
            pTkhjnkinyuucd,
            pMeisaino,
            pRenno
        );
    }

    @Transient
    @Override
    public PKHM_TokuteiKankeiHjnNmTotugou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_TokuteiKankeiHjnNmTotugou> getMetaClass() {
        return QHM_TokuteiKankeiHjnNmTotugou.class;
    }

    @Id
    @Column(name=GenHM_TokuteiKankeiHjnNmTotugou.TKHJNKINYUUCD)
    @AlphaDigit
    @MaxLength(max=4)
    public String getTkhjnkinyuucd() {
        return getPrimaryKey().getTkhjnkinyuucd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTkhjnkinyuucd(String pTkhjnkinyuucd) {
        getPrimaryKey().setTkhjnkinyuucd(pTkhjnkinyuucd);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenHM_TokuteiKankeiHjnNmTotugou.MEISAINO)
    public BizNumber getMeisaino() {
        return getPrimaryKey().getMeisaino();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMeisaino(BizNumber pMeisaino) {
        getPrimaryKey().setMeisaino(pMeisaino);
    }

    @Id
    @Column(name=GenHM_TokuteiKankeiHjnNmTotugou.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String totugoutkhjnnmkj;

    @Column(name=GenHM_TokuteiKankeiHjnNmTotugou.TOTUGOUTKHJNNMKJ)
    public String getTotugoutkhjnnmkj() {
        return totugoutkhjnnmkj;
    }

    @DataConvert("toMultiByte")
    public void setTotugoutkhjnnmkj(String pTotugoutkhjnnmkj) {
        totugoutkhjnnmkj = pTotugoutkhjnnmkj;
    }
}