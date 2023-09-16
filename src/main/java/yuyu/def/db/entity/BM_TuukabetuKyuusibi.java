package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenBM_TuukabetuKyuusibi;


/**
 * 通貨別取扱休止日マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_TuukabetuKyuusibi} の JavaDoc を参照してください。<br />
 * @see     GenBM_TuukabetuKyuusibi<br />
 * @see     PKBM_TuukabetuKyuusibi<br />
 * @see     QBM_TuukabetuKyuusibi<br />
 * @see     GenQBM_TuukabetuKyuusibi<br />
 */
@Entity
public class BM_TuukabetuKyuusibi extends GenBM_TuukabetuKyuusibi {

    private static final long serialVersionUID = 1L;

    public BM_TuukabetuKyuusibi() {
    }

    public BM_TuukabetuKyuusibi(BizDate pTuukatoriatukaiymd) {
        super(pTuukatoriatukaiymd);
    }



}

