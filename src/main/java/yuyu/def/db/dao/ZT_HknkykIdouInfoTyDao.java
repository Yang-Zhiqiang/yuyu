package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HknkykIdouInfoTy;
import yuyu.def.db.meta.QZT_HknkykIdouInfoTy;

/**
 * 保険契約異動情報テーブル（中）(ZT_HknkykIdouInfoTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HknkykIdouInfoTyDao extends AbstractDao<ZT_HknkykIdouInfoTy> {

    public ZT_HknkykIdouInfoTyDao() {
        super(ZT_HknkykIdouInfoTy.class);
    }

    public ZT_HknkykIdouInfoTy getHknkykIdouInfoTy(String pZtykyktuukasyu, String pZtyidouymd, String pZtyidoujiyuukbnzfi, String pZtydatakanrino, String pZtyrenno, String pZtytumitatekinkbn) {
        ZT_HknkykIdouInfoTy zT_HknkykIdouInfoTy =  new ZT_HknkykIdouInfoTy();
        zT_HknkykIdouInfoTy.setZtykyktuukasyu(pZtykyktuukasyu);
        zT_HknkykIdouInfoTy.setZtyidouymd(pZtyidouymd);
        zT_HknkykIdouInfoTy.setZtyidoujiyuukbnzfi(pZtyidoujiyuukbnzfi);
        zT_HknkykIdouInfoTy.setZtydatakanrino(pZtydatakanrino);
        zT_HknkykIdouInfoTy.setZtyrenno(pZtyrenno);
        zT_HknkykIdouInfoTy.setZtytumitatekinkbn(pZtytumitatekinkbn);
        return this.selectOne(zT_HknkykIdouInfoTy);
    }

    public ExDBResults<ZT_HknkykIdouInfoTy> selectAllZT_HknkykIdouInfoTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_HknkykIdouInfoTy qZT_HknkykIdouInfoTy =  new QZT_HknkykIdouInfoTy();
        jpql.append($SELECT);
        jpql.append(qZT_HknkykIdouInfoTy);
        jpql.append($FROM);
        jpql.append(qZT_HknkykIdouInfoTy.ZT_HknkykIdouInfoTy());
        jpql.append($ORDER_BY(qZT_HknkykIdouInfoTy.ztykyktuukasyu.asc(), qZT_HknkykIdouInfoTy.ztyidouymd.asc(), qZT_HknkykIdouInfoTy.ztyidoujiyuukbnzfi.asc(), qZT_HknkykIdouInfoTy.ztydatakanrino.asc(), qZT_HknkykIdouInfoTy.ztyrenno.asc(), qZT_HknkykIdouInfoTy.ztytumitatekinkbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HknkykIdouInfoTy).getResults();
    }
}
