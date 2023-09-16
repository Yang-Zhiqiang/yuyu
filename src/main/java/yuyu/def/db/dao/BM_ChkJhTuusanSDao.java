package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkJhTuusanS;
import yuyu.def.db.meta.QBM_ChkJhTuusanS;

/**
 * 通算限度Ｓ事方書チェックマスタ(BM_ChkJhTuusanSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkJhTuusanSDao extends AbstractDao<BM_ChkJhTuusanS> {

    public BM_ChkJhTuusanSDao() {
        super(BM_ChkJhTuusanS.class);
    }

    public BM_ChkJhTuusanS getChkJhTuusanS(BizNumber pHhknfromnen,
        BizNumber pHhkntonen){
        BM_ChkJhTuusanS bM_ChkJhTuusanS =  new BM_ChkJhTuusanS();
        bM_ChkJhTuusanS.setHhknfromnen(pHhknfromnen);
        bM_ChkJhTuusanS.setHhkntonen(pHhkntonen);
        return this.selectOne(bM_ChkJhTuusanS);
    }

    public List<BM_ChkJhTuusanS> getChkJhTuusanSsByPk(BizNumber pHhknnen) {


        QBM_ChkJhTuusanS qQBM_ChkJhTuusanS = new QBM_ChkJhTuusanS();


        String queryStr = $SELECT + qQBM_ChkJhTuusanS +
            $FROM + qQBM_ChkJhTuusanS.BM_ChkJhTuusanS() +
            $WHERE + qQBM_ChkJhTuusanS.hhknfromnen.le(pHhknnen) +
            $AND + qQBM_ChkJhTuusanS.hhkntonen.ge(pHhknnen);


        return em.createJPQL(queryStr).bind(qQBM_ChkJhTuusanS).getResultList();
    }
}
