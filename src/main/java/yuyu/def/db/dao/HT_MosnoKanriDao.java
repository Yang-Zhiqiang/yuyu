package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.meta.QHT_MosnoKanri;

/**
 * 申込番号管理テーブル(HT_MosnoKanriDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MosnoKanriDao extends AbstractDao<HT_MosnoKanri> {

    public HT_MosnoKanriDao() {
        super(HT_MosnoKanri.class);
    }

    public HT_MosnoKanri getMosnoKanri(String pMosno8keta){
        HT_MosnoKanri hT_MosnoKanri =  new HT_MosnoKanri();
        hT_MosnoKanri.setMosno8keta(pMosno8keta);
        return this.selectOne(hT_MosnoKanri);
    }

    public String getMosnoKanriMinMosno8ketaByMosno8ketaSaibankahikbn(String pMosnoFrom, String pMosnoTo, C_KahiKbn pSaibankahikbn) {



















        QHT_MosnoKanri qHT_MosnoKanri = new QHT_MosnoKanri();
        String mainQuery = $SELECT + qHT_MosnoKanri.mosno8keta +
            $FROM(qHT_MosnoKanri) +
            $WHERE + qHT_MosnoKanri.mosno8keta.ge(pMosnoFrom) +
            $AND + qHT_MosnoKanri.mosno8keta.le(pMosnoTo) +
            $AND + qHT_MosnoKanri.saibankahikbn.eq(pSaibankahikbn) +
            $ORDER_BY(qHT_MosnoKanri.saibanymd.asc() + "," +
                qHT_MosnoKanri.mosno8keta.asc());

        return em.createJPQL(mainQuery).bind(qHT_MosnoKanri).setFirstResult(0).setMaxResults(1).getSingleResult();
    }

    public ExDBUpdatableResults<HT_MosnoKanri> getMosnoKanrisByKakutyoujobcdMossykykyoteiymd(BizDate pMossykykyoteiymd) {


        QHT_MosnoKanri qHT_MosnoKanri = new QHT_MosnoKanri();

        String subQuerry = $SELECT + qHT_MosnoKanri +
            $FROM + qHT_MosnoKanri.HT_MosnoKanri() +
            $WHERE + qHT_MosnoKanri.mossykykyoteiymd.le(pMossykykyoteiymd) +
            $AND + qHT_MosnoKanri.saibankahikbn.eq(C_KahiKbn.HUKA) +
            $ORDER_BY (qHT_MosnoKanri.mosno8keta.asc());

        return em.createJPQL(subQuerry).bind(qHT_MosnoKanri).getUpdatableResults();
    }
}
