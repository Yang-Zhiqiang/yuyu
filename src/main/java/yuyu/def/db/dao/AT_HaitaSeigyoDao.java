package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_HaitaSeigyo;

/**
 * 排他制御テーブル( AT_HaitaSeigyo ) に対するDB操作を提供する。
 */
public class AT_HaitaSeigyoDao extends AbstractDao<AT_HaitaSeigyo> {

    public AT_HaitaSeigyoDao() {
        super(AT_HaitaSeigyo.class);
    }

    public AT_HaitaSeigyo getAT_HaitaSeigyo(String pHaitaSyuruiCd, String pHaitaKey) {
        AT_HaitaSeigyo condEntity = new AT_HaitaSeigyo();
        condEntity.setHaitaSyuruiCd(pHaitaSyuruiCd);
        condEntity.setHaitaKey(pHaitaKey);
        return selectOne(condEntity);
    }

}