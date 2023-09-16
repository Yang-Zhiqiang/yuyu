package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.meta.QZT_TuutirirekiMeisaiFRn;

/**
 * 通知履歴明細ファイルテーブル（連）(ZT_TuutirirekiMeisaiFRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TuutirirekiMeisaiFRnDao extends AbstractDao<ZT_TuutirirekiMeisaiFRn> {

    public ZT_TuutirirekiMeisaiFRnDao() {
        super(ZT_TuutirirekiMeisaiFRn.class);
    }

    public ZT_TuutirirekiMeisaiFRn getTuutirirekiMeisaiFRn(String pZrntuutirirekino, String pZrntuutisakuseiymd, String pZrntuutisakuseino) {
        ZT_TuutirirekiMeisaiFRn zT_TuutirirekiMeisaiFRn =  new ZT_TuutirirekiMeisaiFRn();
        zT_TuutirirekiMeisaiFRn.setZrntuutirirekino(pZrntuutirirekino);
        zT_TuutirirekiMeisaiFRn.setZrntuutisakuseiymd(pZrntuutisakuseiymd);
        zT_TuutirirekiMeisaiFRn.setZrntuutisakuseino(pZrntuutisakuseino);
        return this.selectOne(zT_TuutirirekiMeisaiFRn);
    }

    public ExDBResults<ZT_TuutirirekiMeisaiFRn> selectAllZT_TuutirirekiMeisaiFRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TuutirirekiMeisaiFRn qZT_TuutirirekiMeisaiFRn =  new QZT_TuutirirekiMeisaiFRn();
        jpql.append($SELECT);
        jpql.append(qZT_TuutirirekiMeisaiFRn);
        jpql.append($FROM);
        jpql.append(qZT_TuutirirekiMeisaiFRn.ZT_TuutirirekiMeisaiFRn());
        jpql.append($ORDER_BY(qZT_TuutirirekiMeisaiFRn.zrntuutirirekino.asc(), qZT_TuutirirekiMeisaiFRn.zrntuutisakuseiymd.asc(), qZT_TuutirirekiMeisaiFRn.zrntuutisakuseino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TuutirirekiMeisaiFRn).getResults();
    }
}
