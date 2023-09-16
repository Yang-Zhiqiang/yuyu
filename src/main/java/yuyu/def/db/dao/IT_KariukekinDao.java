package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.meta.QIT_Kariukekin;

/**
 * 仮受金テーブル(IT_KariukekinDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KariukekinDao extends AbstractDao<IT_Kariukekin> {

    public IT_KariukekinDao() {
        super(IT_Kariukekin.class);
    }

    @Deprecated
    public IT_Kariukekin getKariukekin(String pSyono,
        Integer pKrkno){
        IT_Kariukekin iT_Kariukekin =  new IT_Kariukekin();
        iT_Kariukekin.setSyono(pSyono);
        iT_Kariukekin.setKrkno(pKrkno);
        return this.selectOne(iT_Kariukekin);
    }

    @Override
    @Deprecated
    public List<IT_Kariukekin> selectAll() {
        return super.selectAll();
    }

    public List<IT_Kariukekin> getKariukekinsBySyono(String pSyono) {

        QIT_Kariukekin qIT_Kariukekin = new QIT_Kariukekin("qIT_Kariukekin");


        String mainStry = $SELECT + qIT_Kariukekin +
            $FROM(qIT_Kariukekin)  +
            $WHERE + qIT_Kariukekin.syono.eq(pSyono) +
            $AND + qIT_Kariukekin.krkseisanzumiflg.eq(C_Krkseisanzumiflg.BLNK) +
            $ORDER_BY (qIT_Kariukekin.krkno.desc());


        return em.createJPQL(mainStry).bind(qIT_Kariukekin).getResultList();
    }
}
