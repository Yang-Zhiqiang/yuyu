package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkItijibrTuusanS;
import yuyu.def.db.meta.QBM_ChkItijibrTuusanS;

/**
 * 一時払通算限度Ｓチェックマスタ(BM_ChkItijibrTuusanSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkItijibrTuusanSDao extends AbstractDao<BM_ChkItijibrTuusanS> {

    public BM_ChkItijibrTuusanSDao() {
        super(BM_ChkItijibrTuusanS.class);
    }

    public BM_ChkItijibrTuusanS getChkItijibrTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        BM_ChkItijibrTuusanS bM_ChkItijibrTuusanS =  new BM_ChkItijibrTuusanS();
        bM_ChkItijibrTuusanS.setHhknfromnen(pHhknfromnen);
        bM_ChkItijibrTuusanS.setHhkntonen(pHhkntonen);
        return this.selectOne(bM_ChkItijibrTuusanS);
    }

    public List<BM_ChkItijibrTuusanS> getChkItijibrTuusanSsByPK(BizNumber pHhknnen) {


        QBM_ChkItijibrTuusanS qBM_ChkItijibrTuusanS = new QBM_ChkItijibrTuusanS();


        String strSql = $SELECT + qBM_ChkItijibrTuusanS +
            $FROM + qBM_ChkItijibrTuusanS.BM_ChkItijibrTuusanS() +
            $WHERE + qBM_ChkItijibrTuusanS.hhknfromnen.le(pHhknnen) +
            $AND + qBM_ChkItijibrTuusanS.hhkntonen.ge(pHhknnen);


        return em.createJPQL(strSql).bind(qBM_ChkItijibrTuusanS).getResultList();
    }
}
