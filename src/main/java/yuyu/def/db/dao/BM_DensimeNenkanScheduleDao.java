package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.BM_DensimeNenkanSchedule;

/**
 * 伝票締切日年間スケジュールマスタ(BM_DensimeNenkanScheduleDao) アクセス用の DAO クラスです。<br />
 */
public class BM_DensimeNenkanScheduleDao extends AbstractDao<BM_DensimeNenkanSchedule> {

    public BM_DensimeNenkanScheduleDao() {
        super(BM_DensimeNenkanSchedule.class);
    }

    public BM_DensimeNenkanSchedule getDensimeNenkanSchedule(BizDateYM pSyoriym){
        BM_DensimeNenkanSchedule bM_DensimeNenkanSchedule =  new BM_DensimeNenkanSchedule();
        bM_DensimeNenkanSchedule.setSyoriym(pSyoriym);
        return this.selectOne(bM_DensimeNenkanSchedule);
    }
}
