package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.meta.QIT_KykUkt;

/**
 * 契約受取人テーブル(IT_KykUktDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KykUktDao extends AbstractDao<IT_KykUkt> {

    public IT_KykUktDao() {
        super(IT_KykUkt.class);
    }

    @Deprecated
    public IT_KykUkt getKykUkt(String pSyono,
        C_UktsyuKbn pUktsyukbn,
        Integer pUktsyurenno){
        IT_KykUkt iT_KykUkt =  new IT_KykUkt();
        iT_KykUkt.setSyono(pSyono);
        iT_KykUkt.setUktsyukbn(pUktsyukbn);
        iT_KykUkt.setUktsyurenno(pUktsyurenno);
        return this.selectOne(iT_KykUkt);
    }

    @Override
    @Deprecated
    public List<IT_KykUkt> selectAll() {
        return super.selectAll();
    }

    public IT_KykUkt getKykUktMaxUktsyurennoBySyonoUktsyukbn(String pSyono, C_UktsyuKbn pUktsyukbn) {


        QIT_KykUkt qIT_KykUkt = new QIT_KykUkt();


        String subQuerry = $SELECT + $MAX(qIT_KykUkt.uktsyurenno) +
            $FROM + qIT_KykUkt.IT_KykUkt() +
            $WHERE + qIT_KykUkt.syono.eq(pSyono) +
            $AND + qIT_KykUkt.uktsyukbn.eq(pUktsyukbn) ;

        String mainQuerry = $SELECT + qIT_KykUkt +
            $FROM + qIT_KykUkt.IT_KykUkt() +
            $WHERE + qIT_KykUkt.syono.eq(pSyono) +
            $AND + qIT_KykUkt.uktsyukbn.eq(pUktsyukbn)+
            $AND + qIT_KykUkt.uktsyurenno + $EQ + $(subQuerry);

        return em.createJPQL(mainQuerry).bind(qIT_KykUkt).getSingleResult();
    }
}
