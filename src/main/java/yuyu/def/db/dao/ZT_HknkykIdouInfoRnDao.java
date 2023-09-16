package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HknkykIdouInfoRn;
import yuyu.def.db.meta.QZT_HknkykIdouInfoRn;

/**
 * 保険契約異動情報テーブル（連）(ZT_HknkykIdouInfoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HknkykIdouInfoRnDao extends AbstractDao<ZT_HknkykIdouInfoRn> {

    public ZT_HknkykIdouInfoRnDao() {
        super(ZT_HknkykIdouInfoRn.class);
    }

    public ZT_HknkykIdouInfoRn getHknkykIdouInfoRn(String pZrnkyktuukasyu, String pZrnidouymd, String pZrnidoujiyuukbnzfi, String pZrndatakanrino, String pZrnrenno, String pZrntumitatekinkbn) {
        ZT_HknkykIdouInfoRn zT_HknkykIdouInfoRn =  new ZT_HknkykIdouInfoRn();
        zT_HknkykIdouInfoRn.setZrnkyktuukasyu(pZrnkyktuukasyu);
        zT_HknkykIdouInfoRn.setZrnidouymd(pZrnidouymd);
        zT_HknkykIdouInfoRn.setZrnidoujiyuukbnzfi(pZrnidoujiyuukbnzfi);
        zT_HknkykIdouInfoRn.setZrndatakanrino(pZrndatakanrino);
        zT_HknkykIdouInfoRn.setZrnrenno(pZrnrenno);
        zT_HknkykIdouInfoRn.setZrntumitatekinkbn(pZrntumitatekinkbn);

        return this.selectOne(zT_HknkykIdouInfoRn);
    }

    public ExDBResults<ZT_HknkykIdouInfoRn> selectAllZT_HknkykIdouInfoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_HknkykIdouInfoRn qZT_HknkykIdouInfoRn =  new QZT_HknkykIdouInfoRn();
        jpql.append($SELECT);
        jpql.append(qZT_HknkykIdouInfoRn);
        jpql.append($FROM);
        jpql.append(qZT_HknkykIdouInfoRn.ZT_HknkykIdouInfoRn());
        jpql.append($ORDER_BY(qZT_HknkykIdouInfoRn.zrnkyktuukasyu.asc(), qZT_HknkykIdouInfoRn.zrnidouymd.asc(), qZT_HknkykIdouInfoRn.zrnidoujiyuukbnzfi.asc(), qZT_HknkykIdouInfoRn.zrndatakanrino.asc(), qZT_HknkykIdouInfoRn.zrnrenno.asc(), qZT_HknkykIdouInfoRn.zrntumitatekinkbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HknkykIdouInfoRn).getResults();
    }
}
