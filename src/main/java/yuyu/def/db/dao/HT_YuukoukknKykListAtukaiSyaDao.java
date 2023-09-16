package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.db.entity.HT_YuukoukknKykListAtukaiSya;
import yuyu.def.db.meta.QHT_YuukoukknKykListAtukaiSya;
/**
 * 有効期間経過契約リスト扱者テーブル(HT_YuukoukknKykListAtukaiSyaDao) アクセス用の DAO クラスです。<br />
 */
public class HT_YuukoukknKykListAtukaiSyaDao extends AbstractDao<HT_YuukoukknKykListAtukaiSya> {

    public HT_YuukoukknKykListAtukaiSyaDao() {
        super(HT_YuukoukknKykListAtukaiSya.class);
    }

    @Deprecated
    public HT_YuukoukknKykListAtukaiSya getYuukoukknKykListAtukaiSya(String pMosno,
        BizDate pTyouhyouymd,
        C_KeikaKbn pKeikakbn,
        Integer pRenno){
        HT_YuukoukknKykListAtukaiSya hT_YuukoukknKykListAtukaiSya =  new HT_YuukoukknKykListAtukaiSya();
        hT_YuukoukknKykListAtukaiSya.setMosno(pMosno);
        hT_YuukoukknKykListAtukaiSya.setTyouhyouymd(pTyouhyouymd);
        hT_YuukoukknKykListAtukaiSya.setKeikakbn(pKeikakbn);
        hT_YuukoukknKykListAtukaiSya.setRenno(pRenno);
        return this.selectOne(hT_YuukoukknKykListAtukaiSya);
    }

    @Override
    @Deprecated
    public List<HT_YuukoukknKykListAtukaiSya> selectAll() {
        return super.selectAll();
    }

    public List<HT_YuukoukknKykListAtukaiSya> getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn (
        BizDate pTyouhyouymd, C_KeikaKbn pKeikakbn) {


        QHT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya1 = new QHT_YuukoukknKykListAtukaiSya("t1");

        QHT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya2 = new QHT_YuukoukknKykListAtukaiSya("t2");

        String subStr = $SELECT + $MAX(yuukoukknKykListAtukaiSya2.mosno) +
            $FROM + yuukoukknKykListAtukaiSya2.HT_YuukoukknKykListAtukaiSya() +
            $WHERE + yuukoukknKykListAtukaiSya2.tyouhyouymd.eq(pTyouhyouymd) +
            $AND   + yuukoukknKykListAtukaiSya2.keikakbn.eq(pKeikakbn) +
            $AND   + yuukoukknKykListAtukaiSya2.renno.eq(1) +
            $AND    + yuukoukknKykListAtukaiSya2.tyouhyouymd.eq(yuukoukknKykListAtukaiSya1.tyouhyouymd) +
            $AND    + yuukoukknKykListAtukaiSya2.keikakbn.eq(yuukoukknKykListAtukaiSya1.keikakbn) +
            $AND    + yuukoukknKykListAtukaiSya2.renno.eq(yuukoukknKykListAtukaiSya1.renno)+
            $GROUP_BY + yuukoukknKykListAtukaiSya2.oyadrtencd + "," +
            yuukoukknKykListAtukaiSya2.oyadrtennm +
            $HAVING + $MAX(yuukoukknKykListAtukaiSya2.mosno) +
            $EQ     + yuukoukknKykListAtukaiSya1.mosno ;

        String queryStr = $SELECT + yuukoukknKykListAtukaiSya1 +
            $FROM + yuukoukknKykListAtukaiSya1.HT_YuukoukknKykListAtukaiSya() +
            $WHERE + $EXISTS (subStr) +
            $ORDER_BY(yuukoukknKykListAtukaiSya1.oyadrtencd.asc());

        return em.createJPQL(queryStr).bind(yuukoukknKykListAtukaiSya1, yuukoukknKykListAtukaiSya2).getResultList();
    }

    public ExDBResults<HT_YuukoukknKykListAtukaiSya> getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbnOyadrtencd(
        BizDate pTyouhyouymd, C_KeikaKbn pKeikakbn, String pOyadrtencd) {


        QHT_YuukoukknKykListAtukaiSya qHT_YuukoukknKykListAtukaiSya= new QHT_YuukoukknKykListAtukaiSya();

        String strSql = $SELECT + qHT_YuukoukknKykListAtukaiSya +
            $FROM + qHT_YuukoukknKykListAtukaiSya.HT_YuukoukknKykListAtukaiSya() +
            $WHERE + qHT_YuukoukknKykListAtukaiSya.renno.eq(1) +
            $AND + qHT_YuukoukknKykListAtukaiSya.tyouhyouymd.eq(pTyouhyouymd) +
            $AND + qHT_YuukoukknKykListAtukaiSya.keikakbn.eq(pKeikakbn) +
            $AND + qHT_YuukoukknKykListAtukaiSya.oyadrtencd.eq(pOyadrtencd) +
            $ORDER_BY(qHT_YuukoukknKykListAtukaiSya.tratkiagcd.asc(),
                qHT_YuukoukknKykListAtukaiSya.mosno.asc());

        return em.createJPQL(strSql).bind(qHT_YuukoukknKykListAtukaiSya).getResults();
    }
}
