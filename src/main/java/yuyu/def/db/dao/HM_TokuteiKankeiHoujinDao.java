package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.def.db.meta.QHM_TokuteiKankeiHoujin;
/**
 * 特定関係法人マスタ(HM_TokuteiKankeiHoujinDao) アクセス用の DAO クラスです。<br />
 */
public class HM_TokuteiKankeiHoujinDao extends AbstractDao<HM_TokuteiKankeiHoujin> {

    public HM_TokuteiKankeiHoujinDao() {
        super(HM_TokuteiKankeiHoujin.class);
    }

    public HM_TokuteiKankeiHoujin getTokuteiKankeiHoujin(String pTkhjnkinyuucd,
        BizNumber pMeisaino){
        HM_TokuteiKankeiHoujin hM_TokuteiKankeiHoujin =  new HM_TokuteiKankeiHoujin();
        hM_TokuteiKankeiHoujin.setTkhjnkinyuucd(pTkhjnkinyuucd);
        hM_TokuteiKankeiHoujin.setMeisaino(pMeisaino);
        return this.selectOne(hM_TokuteiKankeiHoujin);
    }

    public List<HM_TokuteiKankeiHoujin> getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj(
        String pTkhjnkinyuucd, String pTkhjnkjdrtennm, String pTkhjnnmkj) {


        QHM_TokuteiKankeiHoujin qHM_TokuteiKankeiHoujin = new QHM_TokuteiKankeiHoujin();


        String subquery1 = "";

        String subquery2 = "";

        String subquery3 = "";

        String subquery4 = "";

        int subqueryCnt = 0;


        if (!StringUtil.isNullOrBlank(pTkhjnkinyuucd)) {

            subquery2 = qHM_TokuteiKankeiHoujin.tkhjnkinyuucd.like(pTkhjnkinyuucd + "%");
            subqueryCnt++;
        }


        if (!StringUtil.isNullOrBlank(pTkhjnkjdrtennm)) {
            subquery3 = qHM_TokuteiKankeiHoujin.tkhjnkjdrtennm.like("%" + pTkhjnkjdrtennm + "%");
            if (subqueryCnt > 0) {
                subquery3 = $AND + subquery3;
            }
            subqueryCnt++;
        }


        if (!StringUtil.isNullOrBlank(pTkhjnnmkj)) {

            subquery4 = qHM_TokuteiKankeiHoujin.tkhjnnmkj.like("%" + pTkhjnnmkj + "%");
            if (subqueryCnt > 0) {
                subquery4 = $AND + subquery4;
            }
            subqueryCnt++;
        }


        if (subqueryCnt > 0) {
            subquery1 = $WHERE;
        }

        String mainQuery = $SELECT + qHM_TokuteiKankeiHoujin +
            $FROM + qHM_TokuteiKankeiHoujin.HM_TokuteiKankeiHoujin() +
            subquery1 +
            subquery2 +
            subquery3 +
            subquery4 +
            $ORDER_BY(qHM_TokuteiKankeiHoujin.tkhjnkinyuucd.asc());

        return em.createJPQL(mainQuery).bind(qHM_TokuteiKankeiHoujin).getResultList();
    }

    public ExDBResults<HM_TokuteiKankeiHoujin> getTokuteiKankeiHoujins() {


        QHM_TokuteiKankeiHoujin qHM_TokuteiKankeiHoujin = new QHM_TokuteiKankeiHoujin();


        String strSql = $SELECT + qHM_TokuteiKankeiHoujin +
            $FROM + qHM_TokuteiKankeiHoujin.HM_TokuteiKankeiHoujin() +
            $ORDER_BY(qHM_TokuteiKankeiHoujin.tkhjnkinyuucd.asc(),
                qHM_TokuteiKankeiHoujin.meisaino.asc());


        return em.createJPQL(strSql).bind(qHM_TokuteiKankeiHoujin).getResults();
    }

}
