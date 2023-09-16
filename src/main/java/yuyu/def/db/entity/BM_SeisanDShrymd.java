package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_SeisanDShrymd;
import yuyu.def.db.mapping.GenBM_SeisanDShrymd;
import yuyu.def.db.meta.GenQBM_SeisanDShrymd;
import yuyu.def.db.meta.QBM_SeisanDShrymd;
import jp.co.slcs.swak.date.BizDateY;

/**
 * 精算Ｄ支払年月日管理マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SeisanDShrymd} の JavaDoc を参照してください。
 * @see     GenBM_SeisanDShrymd
 * @see     PKBM_SeisanDShrymd
 * @see     QBM_SeisanDShrymd
 * @see     GenQBM_SeisanDShrymd
 */
@Entity
public class BM_SeisanDShrymd extends GenBM_SeisanDShrymd {

    private static final long serialVersionUID = 1L;

    public BM_SeisanDShrymd() {
    }

    public BM_SeisanDShrymd(BizDateY pSyorinendo) {
        super(pSyorinendo);
    }

}
