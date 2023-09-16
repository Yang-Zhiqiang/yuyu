package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.JT_SiSentakuInfoTouroku;
import yuyu.def.db.meta.QJT_SiSentakuInfoTouroku;

/**
 * 保険金給付金選択情報登録テーブル(JT_SiSentakuInfoTourokuDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiSentakuInfoTourokuDao extends AbstractDao<JT_SiSentakuInfoTouroku> {

    public JT_SiSentakuInfoTourokuDao() {
        super(JT_SiSentakuInfoTouroku.class);
    }

    public JT_SiSentakuInfoTouroku getSiSentakuInfoTouroku(String pSyono,
        Integer pRenno){
        JT_SiSentakuInfoTouroku jT_SiSentakuInfoTouroku =  new JT_SiSentakuInfoTouroku();
        jT_SiSentakuInfoTouroku.setSyono(pSyono);
        jT_SiSentakuInfoTouroku.setRenno(pRenno);
        return this.selectOne(jT_SiSentakuInfoTouroku);
    }

    public ExDBUpdatableResults<JT_SiSentakuInfoTouroku> getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(
        C_Syorizumiflg pSyorizumiflg) {


        QJT_SiSentakuInfoTouroku qJT_SiSentakuInfoTouroku = new QJT_SiSentakuInfoTouroku();


        String strSql = $SELECT + qJT_SiSentakuInfoTouroku +
            $FROM (qJT_SiSentakuInfoTouroku) +
            $WHERE + qJT_SiSentakuInfoTouroku.syorizumiflg.eq(pSyorizumiflg);


        return em.createJPQL(strSql).bind(qJT_SiSentakuInfoTouroku).getUpdatableResults();
    }
}
