package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.meta.QJM_Byoumei;

/**
 * 病名マスタ(JM_ByoumeiDao) アクセス用の DAO クラスです。<br />
 */
public class JM_ByoumeiDao extends AbstractDao<JM_Byoumei> {

    public JM_ByoumeiDao() {
        super(JM_Byoumei.class);
    }

    public JM_Byoumei getByoumei(String pByoumeitourokuno){
        JM_Byoumei jM_Byoumei =  new JM_Byoumei();
        jM_Byoumei.setByoumeitourokuno(pByoumeitourokuno);
        return this.selectOne(jM_Byoumei);
    }

    public List<JM_Byoumei> getByoumeisByByoumeikjByoumeiknByoumeicd(String pByoumeikj, String pByoumeikn,
        String pByoumeicd) {


        QJM_Byoumei qJM_Byoumei = new QJM_Byoumei();


        String subquery1 = "";

        String subquery2 = "";

        String subquery3 = "";

        String subquery4 = "";

        int subqueryCnt = 0;


        if (!StringUtil.isNullOrBlank(pByoumeikj)) {
            subquery2 = qJM_Byoumei.byoumeikj.like("%" + pByoumeikj + "%");
            subqueryCnt++;
        }


        if (!StringUtil.isNullOrBlank(pByoumeikn)) {

            subquery3 = qJM_Byoumei.byoumeikn.like("%" + pByoumeikn + "%");
            if (subqueryCnt > 0) {
                subquery3 = $AND + subquery3;
            }
            subqueryCnt++;
        }


        if (!StringUtil.isNullOrBlank(pByoumeicd)) {

            subquery4 = qJM_Byoumei.byoumeicd.like(pByoumeicd + "%");
            if (subqueryCnt > 0) {
                subquery4 = $AND + subquery4;
            }
            subqueryCnt++;
        }

        if (subqueryCnt > 0) {
            subquery1 = $WHERE;
        }

        String mainQuery = $SELECT + qJM_Byoumei +
            $FROM + qJM_Byoumei.JM_Byoumei() +
            subquery1 +
            subquery2 +
            subquery3 +
            subquery4 +
            $ORDER_BY(qJM_Byoumei.byoumeicd.asc()+
                ","+qJM_Byoumei.byoumeikn.asc());

        return em.createJPQL(mainQuery).bind(qJM_Byoumei).getResultList();
    }
}
