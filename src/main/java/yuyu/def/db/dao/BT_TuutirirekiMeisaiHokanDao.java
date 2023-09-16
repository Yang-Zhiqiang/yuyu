package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.meta.QBT_TuutirirekiMeisaiHokan;

/**
 * 通知履歴明細保管テーブル(BT_TuutirirekiMeisaiHokanDao) アクセス用の DAO クラスです。<br />
 */
public class BT_TuutirirekiMeisaiHokanDao extends AbstractDao<BT_TuutirirekiMeisaiHokan> {

    public BT_TuutirirekiMeisaiHokanDao() {
        super(BT_TuutirirekiMeisaiHokan.class);
    }

    public BT_TuutirirekiMeisaiHokan getTuutirirekiMeisaiHokan(String pTuutirirekirenno) {
        BT_TuutirirekiMeisaiHokan bT_TuutirirekiMeisaiHokan =  new BT_TuutirirekiMeisaiHokan();
        bT_TuutirirekiMeisaiHokan.setTuutirirekirenno(pTuutirirekirenno);
        return this.selectOne(bT_TuutirirekiMeisaiHokan);
    }

    public ExDBUpdatableResults<BT_TuutirirekiMeisaiHokan> getTuutirirekiMeisaiHokansByTuutisakuseiymd2(BizDateYM pTuutisakuseiym) {


        QBT_TuutirirekiMeisaiHokan qBT_TuutirirekiMeisaiHokan = new QBT_TuutirirekiMeisaiHokan();


        String queryStr = $SELECT + qBT_TuutirirekiMeisaiHokan +
            $FROM (qBT_TuutirirekiMeisaiHokan) +
            $WHERE + qBT_TuutirirekiMeisaiHokan.tuutisakuseiymd.substring(1, 6).ge(pTuutisakuseiym.toString())+
            $ORDER_BY(qBT_TuutirirekiMeisaiHokan.tuutirirekino.desc(),
                qBT_TuutirirekiMeisaiHokan.tuutisakuseiymd.desc(),
                qBT_TuutirirekiMeisaiHokan.tuutisakuseino.desc());


        return em.createJPQL(queryStr).bind(qBT_TuutirirekiMeisaiHokan).getUpdatableResults();
    }
}
