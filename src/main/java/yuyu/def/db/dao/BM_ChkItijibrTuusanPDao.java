package yuyu.def.db.dao;

import java.util.List;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkItijibrTuusanP;
import yuyu.def.db.meta.QBM_ChkItijibrTuusanP;

/**
 * 一時払通算限度Ｐチェックマスタ(BM_ChkItijibrTuusanPDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkItijibrTuusanPDao extends AbstractDao<BM_ChkItijibrTuusanP> {

    public BM_ChkItijibrTuusanPDao() {
        super(BM_ChkItijibrTuusanP.class);
    }

    public BM_ChkItijibrTuusanP getChkItijibrTuusanP(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        BM_ChkItijibrTuusanP bM_ChkItijibrTuusanP =  new BM_ChkItijibrTuusanP();
        bM_ChkItijibrTuusanP.setHhknfromnen(pHhknfromnen);
        bM_ChkItijibrTuusanP.setHhkntonen(pHhkntonen);
        return this.selectOne(bM_ChkItijibrTuusanP);
    }

    public List<BM_ChkItijibrTuusanP> getChkItijibrTuusanPsByPK(BizNumber pHhknnen) {


        QBM_ChkItijibrTuusanP qBM_ChkItijibrTuusanP = new QBM_ChkItijibrTuusanP();


        String strSql = $SELECT + qBM_ChkItijibrTuusanP +
            $FROM + qBM_ChkItijibrTuusanP.BM_ChkItijibrTuusanP() +
            $WHERE + qBM_ChkItijibrTuusanP.hhknfromnen.le(pHhknnen) +
            $AND + qBM_ChkItijibrTuusanP.hhkntonen.ge(pHhknnen);


        return em.createJPQL(strSql).bind(qBM_ChkItijibrTuusanP).getResultList();
    }
}
