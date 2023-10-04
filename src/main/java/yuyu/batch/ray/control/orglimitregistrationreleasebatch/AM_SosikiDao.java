package yuyu.batch.ray.control.orglimitregistrationreleasebatch;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.meta.QAM_Sosiki;

/**
 * 組織マスタテーブル(AM_SosikiDao) アクセス用の DAO クラスです。<br />
 */
public class AM_SosikiDao extends AbstractDao<AM_Sosiki> {

    public AM_SosikiDao() {
        super(AM_Sosiki.class);
    }

    public ExDBResults<AM_Sosiki>  getAllLargeSosiki() {

        QAM_Sosiki meta = new QAM_Sosiki();

        String sQuery = $SELECT + meta + $FROM  + meta.AM_Sosiki();

        return em.createJPQL(sQuery).bind(meta).getResults();

    }
}
