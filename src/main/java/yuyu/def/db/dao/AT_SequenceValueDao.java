package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_SequenceValue;

/**
 * 連番値管理テーブル( AT_SequenceValue ) に対するDB操作を提供する。
 */
public class AT_SequenceValueDao extends AbstractDao<AT_SequenceValue> {

    protected AT_SequenceValueDao() {
        super(AT_SequenceValue.class);
    }

    public AT_SequenceValue getSequenceValueByIdKeys(String pId, String pKeys) {

        AT_SequenceValue aT_SequenceValue = new AT_SequenceValue();
        aT_SequenceValue.setId(pId);
        aT_SequenceValue.setKeys(pKeys);

        return selectOne(aT_SequenceValue);
    }

}
