package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_Outai;
import yuyu.def.db.meta.QJT_Outai;

/**
 * 応対テーブル(JT_OutaiDao) アクセス用の DAO クラスです。<br />
 */
public class JT_OutaiDao extends AbstractDao<JT_Outai> {

    public JT_OutaiDao() {
        super(JT_Outai.class);
    }

    public JT_Outai getOutai(String pSyono,
        Integer pRenno){
        JT_Outai jT_Outai =  new JT_Outai();
        jT_Outai.setSyono(pSyono);
        jT_Outai.setRenno(pRenno);
        return this.selectOne(jT_Outai);
    }

    public Integer getOutaiMaxRennoBySyono(String pSyono) {


        QJT_Outai qJT_Outai = new QJT_Outai();


        String strSql = $SELECT + $MAX(qJT_Outai.renno) +
            $FROM + qJT_Outai.JT_Outai() +
            $WHERE + qJT_Outai.syono.eq(pSyono);


        return em.createJPQL(strSql).bind(qJT_Outai).getSingleResult();
    }
}
