package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_JigyouIkkatu;

/**
 * 事業一括テーブル(HT_JigyouIkkatuDao) アクセス用の DAO クラスです。<br />
 */
public class HT_JigyouIkkatuDao extends AbstractDao<HT_JigyouIkkatu> {

    public HT_JigyouIkkatuDao() {
        super(HT_JigyouIkkatu.class);
    }

    public HT_JigyouIkkatu getJigyouIkkatu(String pDaimosno){
        HT_JigyouIkkatu hT_JigyouIkkatu =  new HT_JigyouIkkatu();
        hT_JigyouIkkatu.setDaimosno(pDaimosno);
        return this.selectOne(hT_JigyouIkkatu);
    }
}
