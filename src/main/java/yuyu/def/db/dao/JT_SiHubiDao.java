package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.meta.QJT_SiHubi;
import yuyu.def.db.meta.QJT_SiHubiDetail;
import yuyu.def.siharai.result.bean.HubiTourokuInfosByHasinymdBean;
import yuyu.def.siharai.result.bean.SiHubisSiHubiDetailsBySyonoBean;

/**
 * 支払不備テーブル(JT_SiHubiDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiHubiDao extends AbstractDao<JT_SiHubi> {

    public JT_SiHubiDao() {
        super(JT_SiHubi.class);
    }

    public JT_SiHubi getSiHubi(String pHubisikibetukey){
        JT_SiHubi jT_SiHubi =  new JT_SiHubi();
        jT_SiHubi.setHubisikibetukey(pHubisikibetukey);
        return this.selectOne(jT_SiHubi);
    }

    public List<SiHubisSiHubiDetailsBySyonoBean> getSiHubisSiHubiDetailsBySyono(String pSyono) {


        QJT_SiHubi qJT_SiHubi = new QJT_SiHubi();


        QJT_SiHubiDetail qJT_SiHubiDetail = new QJT_SiHubiDetail();

        String queryStr = $SELECT + $NEW(SiHubisSiHubiDetailsBySyonoBean.class,
            qJT_SiHubi,
            qJT_SiHubiDetail) +
            $FROM + qJT_SiHubi.JT_SiHubi() + "," +
            qJT_SiHubiDetail.JT_SiHubiDetail() +
            $WHERE + qJT_SiHubi.hubisikibetukey.eq(qJT_SiHubiDetail.hubisikibetukey) +
            $AND + qJT_SiHubi.syono.eq(pSyono) +
            $ORDER_BY(qJT_SiHubiDetail.trkymd.asc(),
                qJT_SiHubiDetail.hubisikibetukey.asc());

        return em.createJPQL(queryStr).bind(qJT_SiHubi, qJT_SiHubiDetail).getResultList();
    }

    public ExDBResults<HubiTourokuInfosByHasinymdBean> getHubiTourokuInfosByHasinymd(BizDate pHasinymd) {


        QJT_SiHubi qJT_SiHubi = new QJT_SiHubi();


        QJT_SiHubiDetail qJT_SiHubiDetail = new QJT_SiHubiDetail();

        String mainStry = $SELECT_DISTINCT + qJT_SiHubi + "," +
            qJT_SiHubiDetail.hubisikibetukey + "," +
            qJT_SiHubiDetail.hasinymd + "," +
            qJT_SiHubiDetail.hassinsakikbn +
            $FROM + qJT_SiHubi.JT_SiHubi() + "," +
            qJT_SiHubiDetail.JT_SiHubiDetail() +
            $WHERE + qJT_SiHubiDetail.hubisikibetukey.eq(qJT_SiHubi.hubisikibetukey) +
            $AND + qJT_SiHubiDetail.hasinymd.eq(pHasinymd) +
            $AND + qJT_SiHubiDetail.kaisyouymd.isNull() +
            $ORDER_BY(qJT_SiHubi.syono,
                qJT_SiHubiDetail.hubisikibetukey,
                qJT_SiHubiDetail.hassinsakikbn);

        return em.createJPQL(mainStry).bind(qJT_SiHubi, qJT_SiHubiDetail).getResults(HubiTourokuInfosByHasinymdBean.class);
    }

    public List<JT_SiHubi> getSiHubisBySyono(String pSyono) {

        JT_SiHubi jT_SiHubi = new JT_SiHubi();
        jT_SiHubi.setSyono(pSyono);
        return this.select(jT_SiHubi);
    }

    public JT_SiHubi getSiHubiByHubisikibetukeyHasinymd(String pHubisikibetukey, BizDate pHasinymd){


        QJT_SiHubi qJT_SiHubi = new QJT_SiHubi();

        QJT_SiHubiDetail qJT_SiHubiDetail = new QJT_SiHubiDetail();


        String strSql = $SELECT + qJT_SiHubi +
            $FROM + qJT_SiHubi.JT_SiHubi() + "," +
            qJT_SiHubiDetail.JT_SiHubiDetail() +
            $WHERE + qJT_SiHubi.hubisikibetukey.eq(pHubisikibetukey) +
            $AND + qJT_SiHubi.hubisikibetukey.eq(qJT_SiHubiDetail.hubisikibetukey) +
            $AND + qJT_SiHubiDetail.hasinymd.eq(pHasinymd);


        return em.createJPQL(strSql).bind(qJT_SiHubi, qJT_SiHubiDetail).getSingleResult();
    }
}
