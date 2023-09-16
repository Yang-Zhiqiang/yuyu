package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_DairitenSyougou;


/**
 * 代理店法人商号マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_DairitenSyougou} の JavaDoc を参照してください。<br />
 * @see     GenBM_DairitenSyougou<br />
 * @see     PKBM_DairitenSyougou<br />
 * @see     QBM_DairitenSyougou<br />
 * @see     GenQBM_DairitenSyougou<br />
 */
@Entity
public class BM_DairitenSyougou extends GenBM_DairitenSyougou {

    private static final long serialVersionUID = 1L;

    public BM_DairitenSyougou() {
    }

    public BM_DairitenSyougou(String pDrtencd) {
        super(pDrtencd);
    }



}

