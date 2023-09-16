package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.meta.QAS_Kinou;
import yuyu.def.db.meta.QAS_KinouMode;
import yuyu.def.db.meta.QHT_KmTsRireki;
import yuyu.def.sinkeiyaku.result.bean.KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean;

/**
 * 項目訂正履歴テーブル(HT_KmTsRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_KmTsRirekiDao extends AbstractDao<HT_KmTsRireki> {

    public HT_KmTsRirekiDao() {
        super(HT_KmTsRireki.class);
    }

    @Deprecated
    public HT_KmTsRireki getKmTsRireki(String pMosno,
        String pSyoriTime,
        Integer pRenno3keta){
        HT_KmTsRireki hT_KmTsRireki =  new HT_KmTsRireki();
        hT_KmTsRireki.setMosno(pMosno);
        hT_KmTsRireki.setSyoriTime(pSyoriTime);
        hT_KmTsRireki.setRenno3keta(pRenno3keta);
        return this.selectOne(hT_KmTsRireki);
    }

    @Override
    @Deprecated
    public List<HT_KmTsRireki> selectAll() {
        return super.selectAll();
    }

    public List<KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean> getKoumokuTeiseiRirekiInfoByMosnoSubSystemId(String pMosno, String pSubSystemId) {


        QHT_KmTsRireki qHT_KmTsRireki = new QHT_KmTsRireki();


        QAS_KinouMode qAS_KinouMode = new QAS_KinouMode();


        QAS_Kinou qAS_Kinou = new QAS_Kinou();

        String querySql = $SELECT + $NEW(KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean.class,
            qHT_KmTsRireki.syoriTime,
            qAS_KinouMode.kinouModeId,
            qAS_KinouMode.kinouModeNm,
            qHT_KmTsRireki.tskmnm,
            qHT_KmTsRireki.tsmaenaiyou,
            qHT_KmTsRireki.tsgonaiyou,
            qAS_Kinou.kinouNm,
            qHT_KmTsRireki.tantid) +
            $FROM + qHT_KmTsRireki.HT_KmTsRireki() + "," +
            qAS_KinouMode.AS_KinouMode() + "," +
            qAS_Kinou.AS_Kinou() +
            $WHERE + qHT_KmTsRireki.mosno.eq(pMosno) +
            $AND + qAS_Kinou.subSystemId.eq(pSubSystemId) +
            $AND + qHT_KmTsRireki.kinouId.eq(qAS_KinouMode.kinouId) +
            $AND + qAS_Kinou.kinouId.eq(qAS_KinouMode.kinouId) +
            $AND + qHT_KmTsRireki.kinouModeId.eq(qAS_KinouMode.kinouModeId) +
            $ORDER_BY(qHT_KmTsRireki.syoriTime.desc(),
                qHT_KmTsRireki.renno3keta.asc());

        return em.createJPQL(querySql, KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean.class).bind(qHT_KmTsRireki, qAS_KinouMode, qAS_Kinou).getResultList();
    }

    public ExDBResults<HT_KmTsRireki> getKmtsrirekisBySyoriTime(String pSyoriTimeFrom, String pSyoriTimeTo) {


        QHT_KmTsRireki qHT_KmTsRireki = new QHT_KmTsRireki("qHT_KmTsRireki");


        String querySql = $SELECT + qHT_KmTsRireki  +
            $FROM + qHT_KmTsRireki.HT_KmTsRireki() +
            $WHERE + qHT_KmTsRireki.syoriTime.ge(pSyoriTimeFrom) +
            $AND + qHT_KmTsRireki.syoriTime.le(pSyoriTimeTo) +
            $ORDER_BY(qHT_KmTsRireki.mosno.asc(),
                qHT_KmTsRireki.syoriTime.asc(),
                qHT_KmTsRireki.renno3keta.asc()) ;

        return em.createJPQL(querySql).bind(qHT_KmTsRireki).getResults();
    }

    public Long getKmTsRirekiDistinctSyoriTimeCountByMosno(String pMosno) {


        QHT_KmTsRireki qHT_KmTsRireki = new QHT_KmTsRireki();


        String strSql = $SELECT + $COUNT_DISTINCT(qHT_KmTsRireki.syoriTime) +
            $FROM + qHT_KmTsRireki.HT_KmTsRireki() +
            $WHERE + qHT_KmTsRireki.mosno.eq(pMosno);


        return em.createJPQL(strSql).bind(qHT_KmTsRireki).getSingleResult();
    }
}
