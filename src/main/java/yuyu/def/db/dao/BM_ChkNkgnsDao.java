package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkNkgns;
import yuyu.def.db.meta.QBM_ChkNkgns;

/**
 * 年金原資限度チェックマスタ(BM_ChkNkgnsDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkNkgnsDao extends AbstractDao<BM_ChkNkgns> {

    public BM_ChkNkgnsDao() {
        super(BM_ChkNkgns.class);
    }

    public BM_ChkNkgns getChkNkgns(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        BM_ChkNkgns bM_ChkNkgns =  new BM_ChkNkgns();
        bM_ChkNkgns.setHhknfromnen(pHhknfromnen);
        bM_ChkNkgns.setHhkntonen(pHhkntonen);
        return this.selectOne(bM_ChkNkgns);
    }

    public List<BM_ChkNkgns> getChkNkgnssByPK(BizNumber pHhknnen) {


        QBM_ChkNkgns qBM_ChkNkgns = new QBM_ChkNkgns();


        String strSql = $SELECT + qBM_ChkNkgns +
            $FROM + qBM_ChkNkgns.BM_ChkNkgns() +
            $WHERE + qBM_ChkNkgns.hhknfromnen.le(pHhknnen) +
            $AND + qBM_ChkNkgns.hhkntonen.ge(pHhknnen);


        return em.createJPQL(strSql).bind(qBM_ChkNkgns).getResultList();
    }
}
