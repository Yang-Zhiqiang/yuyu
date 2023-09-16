package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenJM_Kyuuhu;


/**
 * 給付マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_Kyuuhu} の JavaDoc を参照してください。<br />
 * @see     GenJM_Kyuuhu<br />
 * @see     PKJM_Kyuuhu<br />
 * @see     QJM_Kyuuhu<br />
 * @see     GenQJM_Kyuuhu<br />
 */
@Entity
public class JM_Kyuuhu extends GenJM_Kyuuhu {

    private static final long serialVersionUID = 1L;

    public JM_Kyuuhu() {
    }

    public JM_Kyuuhu(String pKyuuhucd) {
        super(pKyuuhucd);
    }



}

