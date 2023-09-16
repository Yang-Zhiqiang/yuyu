package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_SeisanDShrymd;
import yuyu.def.db.id.PKBM_SeisanDShrymd;
import yuyu.def.db.meta.GenQBM_SeisanDShrymd;
import yuyu.def.db.meta.QBM_SeisanDShrymd;

/**
 * 精算Ｄ支払年月日管理マスタ テーブルのマッピング情報クラスで、 {@link BM_SeisanDShrymd} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SeisanDShrymd}</td><td colspan="3">精算Ｄ支払年月日管理マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyorinendo syorinendo}</td><td>処理年度</td><td align="center">{@link PKBM_SeisanDShrymd ○}</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getSeisandshrymd seisandshrymd}</td><td>精算Ｄ支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BM_SeisanDShrymd
 * @see     PKBM_SeisanDShrymd
 * @see     QBM_SeisanDShrymd
 * @see     GenQBM_SeisanDShrymd
 */
@MappedSuperclass
@Table(name=GenBM_SeisanDShrymd.TABLE_NAME)
@IdClass(value=PKBM_SeisanDShrymd.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class)
})
public abstract class GenBM_SeisanDShrymd extends AbstractExDBEntity<BM_SeisanDShrymd, PKBM_SeisanDShrymd> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SeisanDShrymd";
    public static final String SYORINENDO               = "syorinendo";
    public static final String SEISANDSHRYMD            = "seisandshrymd";

    private final PKBM_SeisanDShrymd primaryKey;

    public GenBM_SeisanDShrymd() {
        primaryKey = new PKBM_SeisanDShrymd();
    }

    public GenBM_SeisanDShrymd(BizDateY pSyorinendo) {
        primaryKey = new PKBM_SeisanDShrymd(pSyorinendo);
    }

    @Transient
    @Override
    public PKBM_SeisanDShrymd getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SeisanDShrymd> getMetaClass() {
        return QBM_SeisanDShrymd.class;
    }

    @Id
    @Type(type="BizDateYType")
    @Column(name=GenBM_SeisanDShrymd.SYORINENDO)
    public BizDateY getSyorinendo() {
        return getPrimaryKey().getSyorinendo();
    }

    public void setSyorinendo(BizDateY pSyorinendo) {
        getPrimaryKey().setSyorinendo(pSyorinendo);
    }

    private BizDate seisandshrymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_SeisanDShrymd.SEISANDSHRYMD)
    public BizDate getSeisandshrymd() {
        return seisandshrymd;
    }

    public void setSeisandshrymd(BizDate pSeisandshrymd) {
        seisandshrymd = pSeisandshrymd;
    }
}