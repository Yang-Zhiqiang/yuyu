package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.meta.QZT_DsHanyouKokyakuTuutiRn;

/**
 * ＤＳ汎用顧客宛通知テーブル（連）(ZT_DsHanyouKokyakuTuutiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DsHanyouKokyakuTuutiRnDao extends AbstractDao<ZT_DsHanyouKokyakuTuutiRn> {

    public ZT_DsHanyouKokyakuTuutiRnDao() {
        super(ZT_DsHanyouKokyakuTuutiRn.class);
    }

    public ZT_DsHanyouKokyakuTuutiRn getDsHanyouKokyakuTuutiRn(String pZrndshanyoukokatetuutikey, String pZrndskokno, String pZrndstuutikbn) {
        ZT_DsHanyouKokyakuTuutiRn zT_DsHanyouKokyakuTuutiRn =  new ZT_DsHanyouKokyakuTuutiRn();
        zT_DsHanyouKokyakuTuutiRn.setZrndshanyoukokatetuutikey(pZrndshanyoukokatetuutikey);
        zT_DsHanyouKokyakuTuutiRn.setZrndskokno(pZrndskokno);
        zT_DsHanyouKokyakuTuutiRn.setZrndstuutikbn(pZrndstuutikbn);
        return this.selectOne(zT_DsHanyouKokyakuTuutiRn);
    }

    public ExDBResults<ZT_DsHanyouKokyakuTuutiRn> selectAllZT_DsHanyouKokyakuTuutiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DsHanyouKokyakuTuutiRn qZT_DsHanyouKokyakuTuutiRn =  new QZT_DsHanyouKokyakuTuutiRn();
        jpql.append($SELECT);
        jpql.append(qZT_DsHanyouKokyakuTuutiRn);
        jpql.append($FROM);
        jpql.append(qZT_DsHanyouKokyakuTuutiRn.ZT_DsHanyouKokyakuTuutiRn());
        jpql.append($ORDER_BY(qZT_DsHanyouKokyakuTuutiRn.zrndshanyoukokatetuutikey.asc(), qZT_DsHanyouKokyakuTuutiRn.zrndskokno.asc(), qZT_DsHanyouKokyakuTuutiRn.zrndstuutikbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DsHanyouKokyakuTuutiRn).getResults();
    }
}
