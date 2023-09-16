package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_HenteiRireki;
import yuyu.def.db.meta.QHT_HenteiRireki;

/**
 * 変更訂正履歴テーブル(HT_HenteiRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_HenteiRirekiDao extends AbstractDao<HT_HenteiRireki> {

    public HT_HenteiRirekiDao() {
        super(HT_HenteiRireki.class);
    }

    @Deprecated
    public HT_HenteiRireki getHenteiRireki(String pMosno,
        Integer pRenno){
        HT_HenteiRireki hT_HenteiRireki =  new HT_HenteiRireki();
        hT_HenteiRireki.setMosno(pMosno);
        hT_HenteiRireki.setRenno(pRenno);
        return this.selectOne(hT_HenteiRireki);
    }

    @Override
    @Deprecated
    public List<HT_HenteiRireki> selectAll() {
        return super.selectAll();
    }

    public Integer getHenteiRirekiMaxRennoByMosno(String pMosno) {


        QHT_HenteiRireki qHT_HenteiRireki = new QHT_HenteiRireki();


        String quertSql = $SELECT + $MAX(qHT_HenteiRireki.renno) +
            $FROM + qHT_HenteiRireki.HT_HenteiRireki() +
            $WHERE + qHT_HenteiRireki.mosno.eq(pMosno) ;

        return em.createJPQL(quertSql).bind(qHT_HenteiRireki).getSingleResult();
    }
}
