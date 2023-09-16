package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_DensimeNenkanSchedule;
import yuyu.def.db.id.PKBM_DensimeNenkanSchedule;
import yuyu.def.db.meta.GenQBM_DensimeNenkanSchedule;
import yuyu.def.db.meta.QBM_DensimeNenkanSchedule;

/**
 * 伝票締切日年間スケジュールマスタ テーブルのマッピング情報クラスで、 {@link BM_DensimeNenkanSchedule} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_DensimeNenkanSchedule}</td><td colspan="3">伝票締切日年間スケジュールマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriym syoriym}</td><td>処理年月</td><td align="center">{@link PKBM_DensimeNenkanSchedule ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getZengetudensimeymd zengetudensimeymd}</td><td>前月伝票締切日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BM_DensimeNenkanSchedule
 * @see     PKBM_DensimeNenkanSchedule
 * @see     QBM_DensimeNenkanSchedule
 * @see     GenQBM_DensimeNenkanSchedule
 */
@MappedSuperclass
@Table(name=GenBM_DensimeNenkanSchedule.TABLE_NAME)
@IdClass(value=PKBM_DensimeNenkanSchedule.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class)
})
public abstract class GenBM_DensimeNenkanSchedule extends AbstractExDBEntity<BM_DensimeNenkanSchedule, PKBM_DensimeNenkanSchedule> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_DensimeNenkanSchedule";
    public static final String SYORIYM                  = "syoriym";
    public static final String ZENGETUDENSIMEYMD        = "zengetudensimeymd";

    private final PKBM_DensimeNenkanSchedule primaryKey;

    public GenBM_DensimeNenkanSchedule() {
        primaryKey = new PKBM_DensimeNenkanSchedule();
    }

    public GenBM_DensimeNenkanSchedule(BizDateYM pSyoriym) {
        primaryKey = new PKBM_DensimeNenkanSchedule(pSyoriym);
    }

    @Transient
    @Override
    public PKBM_DensimeNenkanSchedule getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_DensimeNenkanSchedule> getMetaClass() {
        return QBM_DensimeNenkanSchedule.class;
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenBM_DensimeNenkanSchedule.SYORIYM)
    public BizDateYM getSyoriym() {
        return getPrimaryKey().getSyoriym();
    }

    public void setSyoriym(BizDateYM pSyoriym) {
        getPrimaryKey().setSyoriym(pSyoriym);
    }

    private BizDate zengetudensimeymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_DensimeNenkanSchedule.ZENGETUDENSIMEYMD)
    @ValidDate
    public BizDate getZengetudensimeymd() {
        return zengetudensimeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZengetudensimeymd(BizDate pZengetudensimeymd) {
        zengetudensimeymd = pZengetudensimeymd;
    }
}
