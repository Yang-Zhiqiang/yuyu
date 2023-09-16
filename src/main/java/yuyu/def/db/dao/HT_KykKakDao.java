package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.meta.QHT_KykKak;

/**
 * 契約確認テーブル(HT_KykKakDao) アクセス用の DAO クラスです。<br />
 */
public class HT_KykKakDao extends AbstractDao<HT_KykKak> {

    public HT_KykKakDao() {
        super(HT_KykKak.class);
    }

    @Deprecated
    public HT_KykKak getKykKak(String pMosno,
        Integer pRenno){
        HT_KykKak hT_KykKak =  new HT_KykKak();
        hT_KykKak.setMosno(pMosno);
        hT_KykKak.setRenno(pRenno);
        return this.selectOne(hT_KykKak);
    }

    @Override
    @Deprecated
    public List<HT_KykKak> selectAll() {
        return super.selectAll();
    }

    public HT_KykKak getKykKakByMosnoMaxRenno(String pMosno) {


        QHT_KykKak qHT_KykKak = new QHT_KykKak();


        String subQuerry = $SELECT + $MAX(qHT_KykKak.renno) +
            $FROM + qHT_KykKak.HT_KykKak() +
            $WHERE + qHT_KykKak.mosno.eq(pMosno);


        String mainQuerry = $SELECT + qHT_KykKak +
            $FROM + qHT_KykKak.HT_KykKak() +
            $WHERE + qHT_KykKak.mosno.eq(pMosno) +
            $AND + qHT_KykKak.renno + $EQ + $(subQuerry);

        return em.createJPQL(mainQuerry).bind(qHT_KykKak).getSingleResult();
    }

    public Integer getKykKakMaxRennoByMosno(String pMosno) {


        QHT_KykKak qHT_KykKak = new QHT_KykKak();

        String strSql = $SELECT + $MAX(qHT_KykKak.renno) +
            $FROM + qHT_KykKak.HT_KykKak() +
            $WHERE + qHT_KykKak.mosno.eq(pMosno);

        return em.createJPQL(strSql).bind(qHT_KykKak).getSingleResult();

    }
}
