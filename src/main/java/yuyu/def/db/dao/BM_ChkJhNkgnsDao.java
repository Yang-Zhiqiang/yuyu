package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkJhNkgns;
import yuyu.def.db.meta.QBM_ChkJhNkgns;

/**
 * 年金原資限度事方書チェックマスタ(BM_ChkJhNkgnsDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkJhNkgnsDao extends AbstractDao<BM_ChkJhNkgns> {

    public BM_ChkJhNkgnsDao() {
        super(BM_ChkJhNkgns.class);
    }

    public BM_ChkJhNkgns getChkJhNkgns(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        BM_ChkJhNkgns bM_ChkJhNkgns =  new BM_ChkJhNkgns();
        bM_ChkJhNkgns.setHhknfromnen(pHhknfromnen);
        bM_ChkJhNkgns.setHhkntonen(pHhkntonen);
        return this.selectOne(bM_ChkJhNkgns);
    }

    public List<BM_ChkJhNkgns> getChkJhNkgnssByPK(BizNumber pHhknnen) {


        QBM_ChkJhNkgns qBM_ChkJhNkgns = new QBM_ChkJhNkgns();


        String strSql = $SELECT + qBM_ChkJhNkgns +
            $FROM + qBM_ChkJhNkgns.BM_ChkJhNkgns() +
            $WHERE + qBM_ChkJhNkgns.hhknfromnen.le(pHhknnen) +
            $AND + qBM_ChkJhNkgns.hhkntonen.ge(pHhknnen);


        return em.createJPQL(strSql).bind(qBM_ChkJhNkgns).getResultList();
    }
}
