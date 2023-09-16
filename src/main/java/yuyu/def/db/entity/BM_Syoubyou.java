package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_Syoubyou;


/**
 * 傷病マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Syoubyou} の JavaDoc を参照してください。<br />
 * @see     GenBM_Syoubyou<br />
 * @see     PKBM_Syoubyou<br />
 * @see     QBM_Syoubyou<br />
 * @see     GenQBM_Syoubyou<br />
 */
@Entity
public class BM_Syoubyou extends GenBM_Syoubyou {

    private static final long serialVersionUID = 1L;

    public BM_Syoubyou() {
    }

    public BM_Syoubyou(String pSyoubyoucd) {
        super(pSyoubyoucd);
    }



}

