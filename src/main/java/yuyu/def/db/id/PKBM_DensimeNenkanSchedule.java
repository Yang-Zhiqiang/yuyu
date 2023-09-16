package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_DensimeNenkanSchedule;
import yuyu.def.db.mapping.GenBM_DensimeNenkanSchedule;
import yuyu.def.db.meta.GenQBM_DensimeNenkanSchedule;
import yuyu.def.db.meta.QBM_DensimeNenkanSchedule;

/**
 * 伝票締切日年間スケジュールマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_DensimeNenkanSchedule}</td><td colspan="3">伝票締切日年間スケジュールマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriym syoriym}</td><td>処理年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>zengetudensimeymd</td><td>前月伝票締切日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BM_DensimeNenkanSchedule
 * @see     GenBM_DensimeNenkanSchedule
 * @see     QBM_DensimeNenkanSchedule
 * @see     GenQBM_DensimeNenkanSchedule
 */
public class PKBM_DensimeNenkanSchedule extends AbstractExDBPrimaryKey<BM_DensimeNenkanSchedule, PKBM_DensimeNenkanSchedule> {

    private static final long serialVersionUID = 1L;

    public PKBM_DensimeNenkanSchedule() {
    }

    public PKBM_DensimeNenkanSchedule(BizDateYM pSyoriym) {
        syoriym = pSyoriym;
    }

    @Transient
    @Override
    public Class<BM_DensimeNenkanSchedule> getEntityClass() {
        return BM_DensimeNenkanSchedule.class;
    }

    private BizDateYM syoriym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getSyoriym() {
        return syoriym;
    }

    public void setSyoriym(BizDateYM pSyoriym) {
        syoriym = pSyoriym;
    }

}