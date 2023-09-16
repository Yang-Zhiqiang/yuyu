package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_HrsyuruiKbn;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.meta.QIT_KhHenreikin;

/**
 * 契約保全返戻金テーブル(IT_KhHenreikinDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhHenreikinDao extends AbstractDao<IT_KhHenreikin> {

    public IT_KhHenreikinDao() {
        super(IT_KhHenreikin.class);
    }

    @Deprecated
    public IT_KhHenreikin getKhHenreikin(String pSyono, String pHenkousikibetukey) {
        IT_KhHenreikin iT_KhHenreikin =  new IT_KhHenreikin();
        iT_KhHenreikin.setSyono(pSyono);
        iT_KhHenreikin.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_KhHenreikin);
    }

    @Override
    @Deprecated
    public List<IT_KhHenreikin> selectAll() {
        return super.selectAll();
    }

    public Long getKhHenreikinYendtMbrCountBySyono(String pSyono) {


        QIT_KhHenreikin qIT_KhHenreikin = new QIT_KhHenreikin("qIT_KhHenreikin");

        String mainStry = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_KhHenreikin) +
            $WHERE + qIT_KhHenreikin.syono.eq(pSyono) +
            $AND + qIT_KhHenreikin.hrsyuruikbn.eq(C_HrsyuruiKbn.YENDTHNKHENREI) +
            $AND + qIT_KhHenreikin.hrsiharaijyoutaikbn.eq(C_Siharaijyoutaikbn.MBR);

        return em.createJPQL(mainStry).bind(qIT_KhHenreikin).getSingleResult();
    }

    public List<IT_KhHenreikin> getKhHenreikinYendtMbrsBySyono(String pSyono) {


        QIT_KhHenreikin qIT_KhHenreikin = new QIT_KhHenreikin("qIT_KhHenreikin");

        String mainStry = $SELECT + qIT_KhHenreikin +
            $FROM(qIT_KhHenreikin) +
            $WHERE + qIT_KhHenreikin.syono.eq(pSyono) +
            $AND + qIT_KhHenreikin.hrsyuruikbn.eq(C_HrsyuruiKbn.YENDTHNKHENREI) +
            $AND + qIT_KhHenreikin.hrsiharaijyoutaikbn.eq(C_Siharaijyoutaikbn.MBR);

        return em.createJPQL(mainStry).bind(qIT_KhHenreikin).getResultList();
    }
}
