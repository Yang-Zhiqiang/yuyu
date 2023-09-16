package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.meta.QZT_SkKouhuriUkTrkkekkaTr;

/**
 * 新契約口振受付登録結果テーブル（取）(ZT_SkKouhuriUkTrkkekkaTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKouhuriUkTrkkekkaTrDao extends AbstractDao<ZT_SkKouhuriUkTrkkekkaTr> {

    public ZT_SkKouhuriUkTrkkekkaTrDao() {
        super(ZT_SkKouhuriUkTrkkekkaTr.class);
    }

    public ZT_SkKouhuriUkTrkkekkaTr getSkKouhuriUkTrkkekkaTr(String pZtrsyukkncd, String pZtrkinyuukikancd8keta, String pZtrkinyuukkntratkiymd, String pZtrkinyuukkntratkitime, String pZtrkouhuriokyakusamano) {
        ZT_SkKouhuriUkTrkkekkaTr zT_SkKouhuriUkTrkkekkaTr =  new ZT_SkKouhuriUkTrkkekkaTr();
        zT_SkKouhuriUkTrkkekkaTr.setZtrsyukkncd(pZtrsyukkncd);
        zT_SkKouhuriUkTrkkekkaTr.setZtrkinyuukikancd8keta(pZtrkinyuukikancd8keta);
        zT_SkKouhuriUkTrkkekkaTr.setZtrkinyuukkntratkiymd(pZtrkinyuukkntratkiymd);
        zT_SkKouhuriUkTrkkekkaTr.setZtrkinyuukkntratkitime(pZtrkinyuukkntratkitime);
        zT_SkKouhuriUkTrkkekkaTr.setZtrkouhuriokyakusamano(pZtrkouhuriokyakusamano);
        return this.selectOne(zT_SkKouhuriUkTrkkekkaTr);
    }

    public ExDBResults<ZT_SkKouhuriUkTrkkekkaTr> selectAllZT_SkKouhuriUkTrkkekkaTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKouhuriUkTrkkekkaTr qZT_SkKouhuriUkTrkkekkaTr =  new QZT_SkKouhuriUkTrkkekkaTr();
        jpql.append($SELECT);
        jpql.append(qZT_SkKouhuriUkTrkkekkaTr);
        jpql.append($FROM);
        jpql.append(qZT_SkKouhuriUkTrkkekkaTr.ZT_SkKouhuriUkTrkkekkaTr());
        jpql.append($ORDER_BY(qZT_SkKouhuriUkTrkkekkaTr.ztrsyukkncd.asc(), qZT_SkKouhuriUkTrkkekkaTr.ztrkinyuukikancd8keta.asc(), qZT_SkKouhuriUkTrkkekkaTr.ztrkinyuukkntratkiymd.asc(), qZT_SkKouhuriUkTrkkekkaTr.ztrkinyuukkntratkitime.asc(), qZT_SkKouhuriUkTrkkekkaTr.ztrkouhuriokyakusamano.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKouhuriUkTrkkekkaTr).getResults();
    }
}
