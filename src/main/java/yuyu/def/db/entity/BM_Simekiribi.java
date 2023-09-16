package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.mapping.GenBM_Simekiribi;


/**
 * 締切日マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Simekiribi} の JavaDoc を参照してください。<br />
 * @see     GenBM_Simekiribi<br />
 * @see     PKBM_Simekiribi<br />
 * @see     QBM_Simekiribi<br />
 * @see     GenQBM_Simekiribi<br />
 */
@Entity
public class BM_Simekiribi extends GenBM_Simekiribi {

    private static final long serialVersionUID = 1L;

    public BM_Simekiribi() {
    }

    public BM_Simekiribi(BizDateYM pBosyuuym) {
        super(pBosyuuym);
    }



}

