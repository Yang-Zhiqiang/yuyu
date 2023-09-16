package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.db.entity.BM_Syoubyou;
import yuyu.def.db.meta.QBM_Syoubyou;

/**
 * 傷病マスタ(BM_SyoubyouDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SyoubyouDao extends AbstractDao<BM_Syoubyou> {

    public BM_SyoubyouDao() {
        super(BM_Syoubyou.class);
    }

    public BM_Syoubyou getSyoubyou(String pSyoubyoucd){
        BM_Syoubyou bM_Syoubyou =  new BM_Syoubyou();
        bM_Syoubyou.setSyoubyoucd(pSyoubyoucd);
        return this.selectOne(bM_Syoubyou);
    }

    public List<BM_Syoubyou> getSyoubyousBySyoubyoucdSyoubyounm(String pSyoubyoucd, String pSyoubyounm) {

        QBM_Syoubyou qbm_syoubyou = new QBM_Syoubyou();


        String subquery1 = "";

        String subquery2 = "";

        String subquery3 = "";

        int subqueryCnt = 0;


        if (!BizUtil.isBlank(pSyoubyoucd)) {

            subquery2 = qbm_syoubyou.syoubyoucd.like(pSyoubyoucd + "%");
            subqueryCnt++;

        }


        if (!BizUtil.isBlank(pSyoubyounm)) {

            if (subqueryCnt > 0) {
                subquery3 = $AND +qbm_syoubyou.syoubyounm.like( "%" + pSyoubyounm + "%") ;
            }else{
                subquery3 = qbm_syoubyou.syoubyounm.like( "%" + pSyoubyounm + "%") ;
            }
            subqueryCnt++;

        }

        if (subqueryCnt > 0) {
            subquery1 = $WHERE;
        }

        String queryStr = $SELECT + qbm_syoubyou +
            $FROM + qbm_syoubyou.BM_Syoubyou() +
            subquery1 +
            subquery2 +
            subquery3 +
            $ORDER_BY(qbm_syoubyou.syoubyoucd.asc());

        return em.createJPQL(queryStr).bind(qbm_syoubyou).getResultList();
    }
}
