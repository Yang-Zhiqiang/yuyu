package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.db.meta.QJT_SiDenpyoData;

/**
 * 支払伝票データテーブル(JT_SiDenpyoDataDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiDenpyoDataDao extends AbstractDao<JT_SiDenpyoData> {

    public JT_SiDenpyoDataDao() {
        super(JT_SiDenpyoData.class);
    }

    public JT_SiDenpyoData getSiDenpyoData(String pDenrenno,
        Integer pEdano){
        JT_SiDenpyoData jT_SiDenpyoData =  new JT_SiDenpyoData();
        jT_SiDenpyoData.setDenrenno(pDenrenno);
        jT_SiDenpyoData.setEdano(pEdano);
        return this.selectOne(jT_SiDenpyoData);
    }

    public ExDBUpdatableResults<JT_SiDenpyoData> getSiDenpyoDatasByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QJT_SiDenpyoData qJT_SiDenpyoData = new QJT_SiDenpyoData();


        String strSql = $SELECT + qJT_SiDenpyoData +
            $FROM + qJT_SiDenpyoData.JT_SiDenpyoData() +
            $WHERE + qJT_SiDenpyoData.syoriYmd.eq(pSyoriYmd) +
            $ORDER_BY(qJT_SiDenpyoData.denrenno.asc(),
                qJT_SiDenpyoData.edano.asc());


        return em.createJPQL(strSql).bind(qJT_SiDenpyoData).getUpdatableResults();
    }

    public List<JT_SiDenpyoData> getSiDenpyoDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd,
        String pSyoricd) {


        QJT_SiDenpyoData qJT_SiDenpyoData = new QJT_SiDenpyoData();


        String strSql = $SELECT + qJT_SiDenpyoData +
            $FROM (qJT_SiDenpyoData) +
            $WHERE + qJT_SiDenpyoData.syono.eq(pSyono) +
            $AND + qJT_SiDenpyoData.syoriYmd.eq(pSyoriYmd) +
            $AND + qJT_SiDenpyoData.syoricd.ne(pSyoricd);


        return em.createJPQL(strSql).bind(qJT_SiDenpyoData).getResultList();
    }
}
