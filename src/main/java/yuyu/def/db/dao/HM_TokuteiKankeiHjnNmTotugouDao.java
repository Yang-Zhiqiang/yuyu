package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.HM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.meta.QHM_TokuteiKankeiHjnNmTotugou;

/**
 * 特定関係法人名突合マスタ(HM_TokuteiKankeiHjnNmTotugouDao) アクセス用の DAO クラスです。<br />
 */
public class HM_TokuteiKankeiHjnNmTotugouDao extends AbstractDao<HM_TokuteiKankeiHjnNmTotugou> {

    public HM_TokuteiKankeiHjnNmTotugouDao() {
        super(HM_TokuteiKankeiHjnNmTotugou.class);
    }

    public HM_TokuteiKankeiHjnNmTotugou getTokuteiKankeiHjnNmTotugou(String pTkhjnkinyuucd, BizNumber pMeisaino, Integer pRenno) {
        HM_TokuteiKankeiHjnNmTotugou hM_TokuteiKankeiHjnNmTotugou =  new HM_TokuteiKankeiHjnNmTotugou();
        hM_TokuteiKankeiHjnNmTotugou.setTkhjnkinyuucd(pTkhjnkinyuucd);
        hM_TokuteiKankeiHjnNmTotugou.setMeisaino(pMeisaino);
        hM_TokuteiKankeiHjnNmTotugou.setRenno(pRenno);
        return this.selectOne(hM_TokuteiKankeiHjnNmTotugou);
    }

    public List<String> getTotugoutkhjnnmkjsByTkhjnkinyuucd(String pTkhjnkinyuucd) {


        QHM_TokuteiKankeiHjnNmTotugou qHM_TokuteiKankeiHjnNmTotugou = new QHM_TokuteiKankeiHjnNmTotugou();


        String strSql = $SELECT + qHM_TokuteiKankeiHjnNmTotugou.totugoutkhjnnmkj +
            $FROM + qHM_TokuteiKankeiHjnNmTotugou.HM_TokuteiKankeiHjnNmTotugou() +
            $WHERE + qHM_TokuteiKankeiHjnNmTotugou.tkhjnkinyuucd.eq(pTkhjnkinyuucd);


        return em.createJPQL(strSql).bind(qHM_TokuteiKankeiHjnNmTotugou).getResultList();
    }
}
