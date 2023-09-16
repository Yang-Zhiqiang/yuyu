package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.DT_WfSentakujyotaiHozon;

/**
 * ワークフロー選択状態保存テーブル(DT_WfSentakujyotaiHozonDao) アクセス用の DAO クラスです。<br />
 */
public class DT_WfSentakujyotaiHozonDao extends AbstractDao<DT_WfSentakujyotaiHozon> {

    public DT_WfSentakujyotaiHozonDao() {
        super(DT_WfSentakujyotaiHozon.class);
    }

    public DT_WfSentakujyotaiHozon getWfSentakujyotaiHozon(String pUserId,
         String pSubSystemId){
        DT_WfSentakujyotaiHozon dT_WfSentakujyotaiHozon =  new DT_WfSentakujyotaiHozon();
        dT_WfSentakujyotaiHozon.setUserId(pUserId);
        dT_WfSentakujyotaiHozon.setSubSystemId(pSubSystemId);
        return this.selectOne(dT_WfSentakujyotaiHozon);
    }
}
