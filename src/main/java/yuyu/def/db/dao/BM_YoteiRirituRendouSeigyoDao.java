package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_YoteiRirituRendouSeigyo;
import yuyu.def.db.meta.QBM_YoteiRirituRendouSeigyo;

/**
 * 予定利率連動制御マスタ(BM_YoteiRirituRendouSeigyo) アクセス用の DAO クラスです。<br />
 */
public class BM_YoteiRirituRendouSeigyoDao extends AbstractDao<BM_YoteiRirituRendouSeigyo> {

    public BM_YoteiRirituRendouSeigyoDao() {
        super(BM_YoteiRirituRendouSeigyo.class);
    }

    public BM_YoteiRirituRendouSeigyo getYoteiRirituRendouSeigyo(String pYoteirirituhanteidfrom, String pYoteirirituhanteidto, String pSyouhncd) {
        BM_YoteiRirituRendouSeigyo bM_YoteiRirituRendouSeigyo =  new BM_YoteiRirituRendouSeigyo();
        bM_YoteiRirituRendouSeigyo.setYoteirirituhanteidfrom(pYoteirirituhanteidfrom);
        bM_YoteiRirituRendouSeigyo.setYoteirirituhanteidto(pYoteirirituhanteidto);
        bM_YoteiRirituRendouSeigyo.setSyouhncd(pSyouhncd);
        return this.selectOne(bM_YoteiRirituRendouSeigyo);
    }

    @Override
    @Deprecated
    public List<BM_YoteiRirituRendouSeigyo> selectAll() {
        return super.selectAll();
    }

    public List<BM_YoteiRirituRendouSeigyo> getYoteiRirituRendouSeigyosByYoteirirituhanteid(String pYoteirirituhanteid) {


        QBM_YoteiRirituRendouSeigyo qBM_YoteiRirituRendouSeigyo = new QBM_YoteiRirituRendouSeigyo();


        String strsql = $SELECT + qBM_YoteiRirituRendouSeigyo +
                $FROM + qBM_YoteiRirituRendouSeigyo.BM_YoteiRirituRendouSeigyo() +
                $WHERE + qBM_YoteiRirituRendouSeigyo.yoteirirituhanteidfrom.le(pYoteirirituhanteid) +
                $AND + qBM_YoteiRirituRendouSeigyo.yoteirirituhanteidto.ge(pYoteirirituhanteid) +
                $ORDER_BY(qBM_YoteiRirituRendouSeigyo.syouhncd.asc());


        return em.createJPQL(strsql).bind(qBM_YoteiRirituRendouSeigyo).getResultList();
    }
}
