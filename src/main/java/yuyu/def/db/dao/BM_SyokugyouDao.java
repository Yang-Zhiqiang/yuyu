package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.db.entity.BM_Syokugyou;
import yuyu.def.db.meta.QBM_Syokugyou;

/**
 * 職業マスタ(BM_SyokugyouDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SyokugyouDao extends AbstractDao<BM_Syokugyou> {

    public BM_SyokugyouDao() {
        super(BM_Syokugyou.class);
    }

    public BM_Syokugyou getSyokugyou(String pSyokugyoucd){
        BM_Syokugyou bM_Syokugyou =  new BM_Syokugyou();
        bM_Syokugyou.setSyokugyoucd(pSyokugyoucd);
        return this.selectOne(bM_Syokugyou);
    }

    public List<BM_Syokugyou> getSyokugyousBySyokugyoucdSyokugyounm(String pSyokugyoucd, String pSyokugyounm) {
        QBM_Syokugyou qbm_syokugyou = new QBM_Syokugyou();


        String subquery1 = "";

        String subquery2 = "";

        String subquery3 = "";

        int subqueryCnt = 0;


        if (!BizUtil.isBlank(pSyokugyoucd)) {

            subquery2 = qbm_syokugyou.syokugyoucd.like(pSyokugyoucd + "%");
            subqueryCnt++;

        }


        if (!BizUtil.isBlank(pSyokugyounm)) {

            if (subqueryCnt > 0) {
                subquery3 = $AND +qbm_syokugyou.syokugyounm.like( "%" + pSyokugyounm + "%") ;
            }else{
                subquery3 = qbm_syokugyou.syokugyounm.like( "%" + pSyokugyounm + "%") ;
            }
            subqueryCnt++;

        }

        if (subqueryCnt > 0) {
            subquery1 = $WHERE;
        }

        String queryStr = $SELECT + qbm_syokugyou +
            $FROM + qbm_syokugyou.BM_Syokugyou() +
            subquery1 +
            subquery2 +
            subquery3 +
            $ORDER_BY(qbm_syokugyou.syokugyoucd.asc());

        return em.createJPQL(queryStr).bind(qbm_syokugyou).getResultList();
    }
}
