package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.meta.QHT_MostenkenRireki;

/**
 * 申込点検履歴テーブル(HT_MostenkenRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MostenkenRirekiDao extends AbstractDao<HT_MostenkenRireki> {

    public HT_MostenkenRirekiDao() {
        super(HT_MostenkenRireki.class);
    }

    @Deprecated
    public HT_MostenkenRireki getMostenkenRireki(String pMosno,
        Integer pRenno){
        HT_MostenkenRireki hT_MostenkenRireki =  new HT_MostenkenRireki();
        hT_MostenkenRireki.setMosno(pMosno);
        hT_MostenkenRireki.setRenno(pRenno);
        return this.selectOne(hT_MostenkenRireki);
    }

    @Override
    @Deprecated
    public List<HT_MostenkenRireki> selectAll() {
        return super.selectAll();
    }

    public HT_MostenkenRireki getMostenkenRirekiByMosnoMaxRenno(String pMosno) {


        QHT_MostenkenRireki mostenkenRireki = new QHT_MostenkenRireki();


        String subQuery = $SELECT + $MAX(mostenkenRireki.renno) +
            $FROM + mostenkenRireki.HT_MostenkenRireki() +
            $WHERE + mostenkenRireki.mosno.eq(pMosno);


        String querySql = $SELECT + mostenkenRireki +
            $FROM + mostenkenRireki.HT_MostenkenRireki() +
            $WHERE + mostenkenRireki.mosno.eq(pMosno) +
            $AND + mostenkenRireki.renno + $EQ + $(subQuery);

        return em.createJPQL(querySql).bind(mostenkenRireki).getSingleResult();
    }

    public Long getMostenkenRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd) {


        QHT_MostenkenRireki qHT_MostenkenRireki = new QHT_MostenkenRireki();

        String quertSql = $SELECT + $COUNT +"(*)"+
            $FROM + qHT_MostenkenRireki.HT_MostenkenRireki() +
            $WHERE + qHT_MostenkenRireki.ketsyacd.eq(pKetsyacd) +
            $OR + qHT_MostenkenRireki.tnsketsyacd.eq(pKetsyacd);

        return em.createJPQL(quertSql).bind(qHT_MostenkenRireki).getSingleResult();
    }

    public BizDate getMostenkenRirekiMinSyoriYmdByMosnoMostenkenkekkakbn(String pMosno) {


        QHT_MostenkenRireki qHT_MostenkenRireki = new QHT_MostenkenRireki();


        String strSql = $SELECT + $MIN(qHT_MostenkenRireki.syoriYmd) +
            $FROM + qHT_MostenkenRireki.HT_MostenkenRireki() +
            $WHERE + qHT_MostenkenRireki.mosno.eq(pMosno) +
            $AND + qHT_MostenkenRireki.mostenkenkekkakbn.eq(C_SyorikekkaKbn.KANRYOU) +
            $GROUP_BY + qHT_MostenkenRireki.mosno;


        return em.createJPQL(strSql).bind(qHT_MostenkenRireki).getSingleResult();
    }

    public HT_MostenkenRireki getMostenkenRirekiByMosnoKanryouMaxRenno(String pMosno) {



        QHT_MostenkenRireki qHT_MostenkenRireki = new QHT_MostenkenRireki();


        String subQuery = $SELECT + $MAX(qHT_MostenkenRireki.renno) +
            $FROM(qHT_MostenkenRireki) +
            $WHERE + qHT_MostenkenRireki.mosno.eq(pMosno) +
            $AND + qHT_MostenkenRireki.mostenkenkekkakbn.eq(C_SyorikekkaKbn.KANRYOU);



        String strSql = $SELECT + qHT_MostenkenRireki +
            $FROM(qHT_MostenkenRireki) +
            $WHERE + qHT_MostenkenRireki.mosno.eq(pMosno) +
            $AND + qHT_MostenkenRireki.renno + $EQ + $(subQuery);


        return em.createJPQL(strSql).bind(qHT_MostenkenRireki).getSingleResult();
    }
}
