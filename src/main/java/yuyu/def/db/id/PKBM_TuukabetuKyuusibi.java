package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_TuukabetuKyuusibi;
import yuyu.def.db.mapping.GenBM_TuukabetuKyuusibi;
import yuyu.def.db.meta.GenQBM_TuukabetuKyuusibi;
import yuyu.def.db.meta.QBM_TuukabetuKyuusibi;

/**
 * 通貨別取扱休止日マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_TuukabetuKyuusibi}</td><td colspan="3">通貨別取扱休止日マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukatoriatukaiymd tuukatoriatukaiymd}</td><td>通貨取扱年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyuusijpykbn</td><td>円休止区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ToriatukaibiKbn C_ToriatukaibiKbn}</td></tr>
 *  <tr><td>kyuusiusdkbn</td><td>米ドル休止区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ToriatukaibiKbn C_ToriatukaibiKbn}</td></tr>
 *  <tr><td>kyuusieurkbn</td><td>ユーロ休止区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ToriatukaibiKbn C_ToriatukaibiKbn}</td></tr>
 *  <tr><td>kyuusiaudkbn</td><td>豪ドル休止区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ToriatukaibiKbn C_ToriatukaibiKbn}</td></tr>
 * </table>
 * @see     BM_TuukabetuKyuusibi
 * @see     GenBM_TuukabetuKyuusibi
 * @see     QBM_TuukabetuKyuusibi
 * @see     GenQBM_TuukabetuKyuusibi
 */
public class PKBM_TuukabetuKyuusibi extends AbstractExDBPrimaryKey<BM_TuukabetuKyuusibi, PKBM_TuukabetuKyuusibi> {

    private static final long serialVersionUID = 1L;

    public PKBM_TuukabetuKyuusibi() {
    }

    public PKBM_TuukabetuKyuusibi(BizDate pTuukatoriatukaiymd) {
        tuukatoriatukaiymd = pTuukatoriatukaiymd;
    }

    @Transient
    @Override
    public Class<BM_TuukabetuKyuusibi> getEntityClass() {
        return BM_TuukabetuKyuusibi.class;
    }

    private BizDate tuukatoriatukaiymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTuukatoriatukaiymd() {
        return tuukatoriatukaiymd;
    }

    public void setTuukatoriatukaiymd(BizDate pTuukatoriatukaiymd) {
        tuukatoriatukaiymd = pTuukatoriatukaiymd;
    }

}