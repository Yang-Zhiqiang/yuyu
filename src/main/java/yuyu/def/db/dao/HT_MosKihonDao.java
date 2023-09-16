package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 申込基本テーブル(HT_MosKihonDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MosKihonDao extends AbstractDao<HT_MosKihon> {

    public HT_MosKihonDao() {
        super(HT_MosKihon.class);
    }

    @Deprecated
    public HT_MosKihon getMosKihon(String pMosno){
        HT_MosKihon hT_MosKihon =  new HT_MosKihon();
        hT_MosKihon.setMosno(pMosno);
        return this.selectOne(hT_MosKihon);
    }

    @Override
    @Deprecated
    public List<HT_MosKihon> selectAll() {
        return super.selectAll();
    }

    public List<HT_MosKihon> getMosKihonsByUktkid(String pUktkid){


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();

        String mainQuerry = $SELECT + qHT_MosKihon +
            $FROM + qHT_MosKihon.HT_MosKihon() + "," +
            qHT_SyoriCTL.HT_SyoriCTL() +
            $WHERE + qHT_MosKihon.uktkid.eq(pUktkid) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno);

        return em.createJPQL(mainQuerry).bind(qHT_MosKihon, qHT_SyoriCTL).getResultList();
    }

    public List<HT_MosKihon> getMosKihonsByUktkidMosnoNe(String pUktkid, String pMosno) {


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");

        String mainQuerry = $SELECT + qHT_MosKihon +
                $FROM(qHT_MosKihon) +
                $WHERE + qHT_MosKihon.uktkid.eq(pUktkid) +
                $AND + qHT_MosKihon.mosno.ne(pMosno);

        return em.createJPQL(mainQuerry).bind(qHT_MosKihon).getResultList();
    }
}
