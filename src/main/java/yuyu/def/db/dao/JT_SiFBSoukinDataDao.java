package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.def.db.meta.QJT_SiFBSoukinData;

/**
 * 支払ＦＢ送金データテーブル(JT_SiFBSoukinDataDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiFBSoukinDataDao extends AbstractDao<JT_SiFBSoukinData> {

    public JT_SiFBSoukinDataDao() {
        super(JT_SiFBSoukinData.class);
    }

    public JT_SiFBSoukinData getSiFBSoukinData(String pFbsoukindatasikibetukey){
        JT_SiFBSoukinData jT_SiFBSoukinData =  new JT_SiFBSoukinData();
        jT_SiFBSoukinData.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        return this.selectOne(jT_SiFBSoukinData);
    }

    public ExDBResults<JT_SiFBSoukinData> getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QJT_SiFBSoukinData qJT_SiFBSoukinData = new QJT_SiFBSoukinData();


        String  strSql = $SELECT + qJT_SiFBSoukinData +
            $FROM + qJT_SiFBSoukinData.JT_SiFBSoukinData() +
            $WHERE + qJT_SiFBSoukinData.syoriYmd.eq(pSyoriYmd);


        return em.createJPQL(strSql).bind(qJT_SiFBSoukinData).getResults();
    }

    public List<JT_SiFBSoukinData> getSiFBSoukinDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd,
        String pSyoricd) {

        QJT_SiFBSoukinData qJT_SiFBSoukinData = new QJT_SiFBSoukinData();


        String strSql = $SELECT + qJT_SiFBSoukinData +
            $FROM (qJT_SiFBSoukinData) +
            $WHERE + qJT_SiFBSoukinData.syono.eq(pSyono) +
            $AND + qJT_SiFBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qJT_SiFBSoukinData.syoricd.ne(pSyoricd);


        return em.createJPQL(strSql).bind(qJT_SiFBSoukinData).getResultList();
    }
}
