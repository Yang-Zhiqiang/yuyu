package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AS_Sequence;

/**
 * 連番管理基幹テーブル( AS_Sequence ) に対するDB操作を提供する。
 */
public class AS_SequenceDao extends AbstractDao<AS_Sequence> {

    public AS_SequenceDao() {
        super(AS_Sequence.class);
    }

    public AS_Sequence getAS_Sequence(String pId) {
        AS_Sequence condEntity = new AS_Sequence();
        condEntity.setId(pId);
        return selectOne(condEntity);
    }

}