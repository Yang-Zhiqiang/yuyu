package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;
import yuyu.def.db.meta.QJT_SiGaikaFBSoukinData;

/**
 * 支払外貨ＦＢ送金データテーブル(JT_SiGaikaFBSoukinDataDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiGaikaFBSoukinDataDao extends AbstractDao<JT_SiGaikaFBSoukinData> {

    public JT_SiGaikaFBSoukinDataDao() {
        super(JT_SiGaikaFBSoukinData.class);
    }

    public JT_SiGaikaFBSoukinData getSiGaikaFBSoukinData(String pFbsoukindatasikibetukey){
        JT_SiGaikaFBSoukinData jT_SiGaikaFBSoukinData =  new JT_SiGaikaFBSoukinData();
        jT_SiGaikaFBSoukinData.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        return this.selectOne(jT_SiGaikaFBSoukinData);
    }

    public ExDBResults<JT_SiGaikaFBSoukinData> getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QJT_SiGaikaFBSoukinData qJT_SiGaikaFBSoukinData = new QJT_SiGaikaFBSoukinData();


        String  strSql = $SELECT + qJT_SiGaikaFBSoukinData +
            $FROM + qJT_SiGaikaFBSoukinData.JT_SiGaikaFBSoukinData() +
            $WHERE + qJT_SiGaikaFBSoukinData.syoriYmd.eq(pSyoriYmd);


        return em.createJPQL(strSql).bind(qJT_SiGaikaFBSoukinData).getResults();
    }

    public List<JT_SiGaikaFBSoukinData> getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd,
        String pSyoricd) {

        QJT_SiGaikaFBSoukinData qJT_SiGaikaFBSoukinData = new QJT_SiGaikaFBSoukinData();


        String  strSql = $SELECT + qJT_SiGaikaFBSoukinData +
            $FROM (qJT_SiGaikaFBSoukinData) +
            $WHERE + qJT_SiGaikaFBSoukinData.syono.eq(pSyono) +
            $AND + qJT_SiGaikaFBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qJT_SiGaikaFBSoukinData.syoricd.ne(pSyoricd);


        return em.createJPQL(strSql).bind(qJT_SiGaikaFBSoukinData).getResultList();
    }
}
