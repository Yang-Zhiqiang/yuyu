package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.classification.C_ImusateirankKbn;
import yuyu.def.classification.C_KnksateirankKbn;
import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.meta.QHM_KetteiSya;

/**
 * 決定者マスタ(HM_KetteiSyaDao) アクセス用の DAO クラスです。<br />
 */
public class HM_KetteiSyaDao extends AbstractDao<HM_KetteiSya> {

    public HM_KetteiSyaDao() {
        super(HM_KetteiSya.class);
    }

    public HM_KetteiSya getKetteiSya(String pKetsyacd){
        HM_KetteiSya hM_KetteiSya =  new HM_KetteiSya();
        hM_KetteiSya.setKetsyacd(pKetsyacd);
        return this.selectOne(hM_KetteiSya);
    }

    public List<HM_KetteiSya> getKetteiSyasByKetsyacdKetsyanm(String pKetsyacd, String pKetsyanm) {


        QHM_KetteiSya ketteiSya = new QHM_KetteiSya();

        String subquerySql1 = "";

        String subquerySql2 = "";

        if (!StringUtil.isNullOrBlank(pKetsyacd)) {

            subquerySql1 = $WHERE + ketteiSya.ketsyacd.like(pKetsyacd + "%");
        }

        if (!StringUtil.isNullOrBlank(subquerySql1) && !StringUtil.isNullOrBlank(pKetsyanm)) {

            subquerySql2 = $AND + ketteiSya.ketsyanm.like("%" + pKetsyanm + "%");

        }

        if (StringUtil.isNullOrBlank(subquerySql1) && !StringUtil.isNullOrBlank(pKetsyanm)) {

            subquerySql2 = $WHERE + ketteiSya.ketsyanm.like("%" + pKetsyanm + "%");

        }

        String querySql = $SELECT + ketteiSya +
            $FROM + ketteiSya.HM_KetteiSya() +
            subquerySql1 +
            subquerySql2 +
            $ORDER_BY(ketteiSya.ketsyacd.asc());

        return em.createJPQL(querySql).bind(ketteiSya).getResultList();
    }

    public List<HM_KetteiSya> getKetteiSyasByKetsyacdMostenkenrankkbns(String pKetsyacd,
        C_MostenkenRankKbn... pMostenkenrankkbn) {


        QHM_KetteiSya ketteiSya = new QHM_KetteiSya();

        String querySql = $SELECT + ketteiSya +
            $FROM + ketteiSya.HM_KetteiSya() +
            $WHERE + ketteiSya.ketsyacd.ne(pKetsyacd) +
            $AND + ketteiSya.mostenkenrankkbn.in(pMostenkenrankkbn) +
            $ORDER_BY(ketteiSya.ketsyacd);

        return em.createJPQL(querySql).bind(ketteiSya).getResultList();
    }

    public List<HM_KetteiSya> getKetteiSyasByKetsyacdKnksateirankkbns(String pKetsyacd, C_KnksateirankKbn... pKnksateirankkbn) {


        QHM_KetteiSya ketteiSya = new QHM_KetteiSya();

        String querySql = $SELECT + ketteiSya +
            $FROM + ketteiSya.HM_KetteiSya() +
            $WHERE + ketteiSya.ketsyacd.ne(pKetsyacd) +
            $AND + ketteiSya.knksateirankkbn.in(pKnksateirankkbn) +
            $ORDER_BY(ketteiSya.ketsyacd);

        return em.createJPQL(querySql).bind(ketteiSya).getResultList();
    }

    public List<HM_KetteiSya> getKetteiSyasByKetsyacdImusateirankkbns(String pKetsyacd,
        C_ImusateirankKbn... pImusateirankkbn) {


        QHM_KetteiSya ketteiSya = new QHM_KetteiSya();

        String querySql = $SELECT + ketteiSya +
            $FROM + ketteiSya.HM_KetteiSya() +
            $WHERE + ketteiSya.ketsyacd.ne(pKetsyacd) +
            $AND + ketteiSya.imusateirankkbn.in(pImusateirankkbn) +
            $ORDER_BY(ketteiSya.ketsyacd.asc());

        return em.createJPQL(querySql).bind(ketteiSya).getResultList();
    }
}
