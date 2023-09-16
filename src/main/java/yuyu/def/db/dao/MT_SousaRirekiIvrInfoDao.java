package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_SousaRirekiIvrInfo;
import java.util.List;

/**
 * 操作履歴ＩＶＲ情報テーブル(MT_SousaRirekiIvrInfoDao) アクセス用の DAO クラスです。<br />
 */
public class MT_SousaRirekiIvrInfoDao extends AbstractDao<MT_SousaRirekiIvrInfo> {

    public MT_SousaRirekiIvrInfoDao() {
        super(MT_SousaRirekiIvrInfo.class);
    }

    @Deprecated
    public MT_SousaRirekiIvrInfo getSousaRirekiIvrInfo(String pTtdksikibetuid) {
        MT_SousaRirekiIvrInfo mT_SousaRirekiIvrInfo =  new MT_SousaRirekiIvrInfo();
        mT_SousaRirekiIvrInfo.setTtdksikibetuid(pTtdksikibetuid);
        return this.selectOne(mT_SousaRirekiIvrInfo);
    }

    @Override
    @Deprecated
    public List<MT_SousaRirekiIvrInfo> selectAll() {
        return super.selectAll();
    }
}
