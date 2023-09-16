package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkTuusanS;
import yuyu.def.db.meta.QBM_ChkTuusanS;

/**
 * 通算限度Ｓチェックマスタ(BM_ChkTuusanSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkTuusanSDao extends AbstractDao<BM_ChkTuusanS> {

    public BM_ChkTuusanSDao() {
        super(BM_ChkTuusanS.class);
    }

    public BM_ChkTuusanS getChkTuusanS(BizNumber pHhknfromnen,
        BizNumber pHhkntonen){
        BM_ChkTuusanS bM_ChkTuusanS =  new BM_ChkTuusanS();
        bM_ChkTuusanS.setHhknfromnen(pHhknfromnen);
        bM_ChkTuusanS.setHhkntonen(pHhkntonen);
        return this.selectOne(bM_ChkTuusanS);
    }

    public List<BM_ChkTuusanS> getChkTuusanSsByPk(BizNumber pHhknnen) {


        QBM_ChkTuusanS qBM_ChkTuusanS = new QBM_ChkTuusanS();


        String queryStr = $SELECT + qBM_ChkTuusanS +
            $FROM + qBM_ChkTuusanS.BM_ChkTuusanS() +
            $WHERE + qBM_ChkTuusanS.hhknfromnen.le(pHhknnen) +
            $AND + qBM_ChkTuusanS.hhkntonen.ge(pHhknnen);


        return em.createJPQL(queryStr).bind(qBM_ChkTuusanS).getResultList();
    }
}
