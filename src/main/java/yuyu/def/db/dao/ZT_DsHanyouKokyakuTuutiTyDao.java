package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.meta.QZT_DsHanyouKokyakuTuutiTy;

/**
 * ＤＳ汎用顧客宛通知テーブル（中）(ZT_DsHanyouKokyakuTuutiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DsHanyouKokyakuTuutiTyDao extends AbstractDao<ZT_DsHanyouKokyakuTuutiTy> {

    public ZT_DsHanyouKokyakuTuutiTyDao() {
        super(ZT_DsHanyouKokyakuTuutiTy.class);
    }

    public ZT_DsHanyouKokyakuTuutiTy getDsHanyouKokyakuTuutiTy(String pZtydshanyoukokatetuutikey, String pZtydskokno, String pZtydstuutikbn) {
        ZT_DsHanyouKokyakuTuutiTy zT_DsHanyouKokyakuTuutiTy =  new ZT_DsHanyouKokyakuTuutiTy();
        zT_DsHanyouKokyakuTuutiTy.setZtydshanyoukokatetuutikey(pZtydshanyoukokatetuutikey);
        zT_DsHanyouKokyakuTuutiTy.setZtydskokno(pZtydskokno);
        zT_DsHanyouKokyakuTuutiTy.setZtydstuutikbn(pZtydstuutikbn);
        return this.selectOne(zT_DsHanyouKokyakuTuutiTy);
    }

    public ExDBResults<ZT_DsHanyouKokyakuTuutiTy> selectAllZT_DsHanyouKokyakuTuutiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DsHanyouKokyakuTuutiTy qZT_DsHanyouKokyakuTuutiTy =  new QZT_DsHanyouKokyakuTuutiTy();
        jpql.append($SELECT);
        jpql.append(qZT_DsHanyouKokyakuTuutiTy);
        jpql.append($FROM);
        jpql.append(qZT_DsHanyouKokyakuTuutiTy.ZT_DsHanyouKokyakuTuutiTy());
        jpql.append($ORDER_BY(qZT_DsHanyouKokyakuTuutiTy.ztydshanyoukokatetuutikey.asc(), qZT_DsHanyouKokyakuTuutiTy.ztydskokno.asc(), qZT_DsHanyouKokyakuTuutiTy.ztydstuutikbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DsHanyouKokyakuTuutiTy).getResults();
    }
}
