package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SeihoWebIdouListRn;
import yuyu.def.db.meta.QZT_SeihoWebIdouListRn;

/**
 * 生保Ｗｅｂ異動一覧抽出テーブル（連）(ZT_SeihoWebIdouListRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SeihoWebIdouListRnDao extends AbstractDao<ZT_SeihoWebIdouListRn> {

    public ZT_SeihoWebIdouListRnDao() {
        super(ZT_SeihoWebIdouListRn.class);
    }

    public ZT_SeihoWebIdouListRn getSeihoWebIdouListRn(Long pZrnsakuseiymd7keta, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono, String pZrnhasseiymd, String pZrnidoukbn1, String pZrnkydatkikbnkj, String pZrnkykyymm, String pZrncifcd) {
        ZT_SeihoWebIdouListRn zT_SeihoWebIdouListRn =  new ZT_SeihoWebIdouListRn();
        zT_SeihoWebIdouListRn.setZrnsakuseiymd7keta(pZrnsakuseiymd7keta);
        zT_SeihoWebIdouListRn.setZrnbsydrtencd(pZrnbsydrtencd);
        zT_SeihoWebIdouListRn.setZrntntusycd(pZrntntusycd);
        zT_SeihoWebIdouListRn.setZrnsyono(pZrnsyono);
        zT_SeihoWebIdouListRn.setZrnhasseiymd(pZrnhasseiymd);
        zT_SeihoWebIdouListRn.setZrnidoukbn1(pZrnidoukbn1);
        zT_SeihoWebIdouListRn.setZrnkydatkikbnkj(pZrnkydatkikbnkj);
        zT_SeihoWebIdouListRn.setZrnkykyymm(pZrnkykyymm);
        zT_SeihoWebIdouListRn.setZrncifcd(pZrncifcd);
        return this.selectOne(zT_SeihoWebIdouListRn);
    }

    public ExDBResults<ZT_SeihoWebIdouListRn> selectAllZT_SeihoWebIdouListRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SeihoWebIdouListRn qZT_SeihoWebIdouListRn =  new QZT_SeihoWebIdouListRn();
        jpql.append($SELECT);
        jpql.append(qZT_SeihoWebIdouListRn);
        jpql.append($FROM);
        jpql.append(qZT_SeihoWebIdouListRn.ZT_SeihoWebIdouListRn());
        jpql.append($ORDER_BY(qZT_SeihoWebIdouListRn.zrnsakuseiymd7keta.asc(), qZT_SeihoWebIdouListRn.zrnbsydrtencd.asc(), qZT_SeihoWebIdouListRn.zrntntusycd.asc(), qZT_SeihoWebIdouListRn.zrnsyono.asc(), qZT_SeihoWebIdouListRn.zrnhasseiymd.asc(), qZT_SeihoWebIdouListRn.zrnidoukbn1.asc(), qZT_SeihoWebIdouListRn.zrnkydatkikbnkj.asc(), qZT_SeihoWebIdouListRn.zrnkykyymm.asc(), qZT_SeihoWebIdouListRn.zrncifcd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SeihoWebIdouListRn).getResults();
    }
}
