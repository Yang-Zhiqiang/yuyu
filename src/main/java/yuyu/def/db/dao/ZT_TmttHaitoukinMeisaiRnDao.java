package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TmttHaitoukinMeisaiRn;
import yuyu.def.db.meta.QZT_TmttHaitoukinMeisaiRn;

/**
 * 積立配当金明細Ｆテーブル（連）(ZT_TmttHaitoukinMeisaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TmttHaitoukinMeisaiRnDao extends AbstractDao<ZT_TmttHaitoukinMeisaiRn> {

    public ZT_TmttHaitoukinMeisaiRnDao() {
        super(ZT_TmttHaitoukinMeisaiRn.class);
    }

    public ZT_TmttHaitoukinMeisaiRn getTmttHaitoukinMeisaiRn(Integer pZrnsequenceno) {
        ZT_TmttHaitoukinMeisaiRn zT_TmttHaitoukinMeisaiRn =  new ZT_TmttHaitoukinMeisaiRn();
        zT_TmttHaitoukinMeisaiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_TmttHaitoukinMeisaiRn);
    }

    public ExDBResults<ZT_TmttHaitoukinMeisaiRn> selectAllZT_TmttHaitoukinMeisaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TmttHaitoukinMeisaiRn qZT_TmttHaitoukinMeisaiRn =  new QZT_TmttHaitoukinMeisaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_TmttHaitoukinMeisaiRn);
        jpql.append($FROM);
        jpql.append(qZT_TmttHaitoukinMeisaiRn.ZT_TmttHaitoukinMeisaiRn());
        jpql.append($ORDER_BY(qZT_TmttHaitoukinMeisaiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TmttHaitoukinMeisaiRn).getResults();
    }
}
