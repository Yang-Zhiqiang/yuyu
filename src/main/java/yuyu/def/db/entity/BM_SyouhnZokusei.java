package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_SyouhnZokusei;
import yuyu.def.db.mapping.GenBM_SyouhnZokusei;
import yuyu.def.db.meta.GenQBM_SyouhnZokusei;
import yuyu.def.db.meta.QBM_SyouhnZokusei;

/**
 * 商品属性マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SyouhnZokusei} の JavaDoc を参照してください。
 * @see     GenBM_SyouhnZokusei
 * @see     PKBM_SyouhnZokusei
 * @see     QBM_SyouhnZokusei
 * @see     GenQBM_SyouhnZokusei
 */
@Entity
public class BM_SyouhnZokusei extends GenBM_SyouhnZokusei {

    private static final long serialVersionUID = 1L;

    public BM_SyouhnZokusei() {
    }

    public BM_SyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {
        super(pSyouhncd, pSyouhnsdno);
    }

}
