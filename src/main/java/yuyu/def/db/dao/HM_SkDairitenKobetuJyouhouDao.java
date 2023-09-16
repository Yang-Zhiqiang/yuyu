package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_DrtenRnrkhouKbn;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.meta.QHM_SkDairitenKobetuJyouhou;

/**
 * 代理店個別情報マスタ(HM_SkDairitenKobetuJyouhouDao) アクセス用の DAO クラスです。<br />
 */
public class HM_SkDairitenKobetuJyouhouDao extends AbstractDao<HM_SkDairitenKobetuJyouhou> {

    public HM_SkDairitenKobetuJyouhouDao() {
        super(HM_SkDairitenKobetuJyouhou.class);
    }

    public HM_SkDairitenKobetuJyouhou getSkDairitenKobetuJyouhou(String pOyadrtencd){
        HM_SkDairitenKobetuJyouhou hM_SkDairitenKobetuJyouhou =  new HM_SkDairitenKobetuJyouhou();
        hM_SkDairitenKobetuJyouhou.setOyadrtencd(pOyadrtencd);
        return this.selectOne(hM_SkDairitenKobetuJyouhou);
    }

    public List<HM_SkDairitenKobetuJyouhou> getSkDairitenKobetuJyouhouByDrtenRnrkhouKbn(C_DrtenRnrkhouKbn pDrtenRnrkhouKbn) {


        QHM_SkDairitenKobetuJyouhou qHM_SkDairitenKobetuJyouhou = new QHM_SkDairitenKobetuJyouhou("qHM_SkDairitenKobetuJyouhou");


        String strSpl = $SELECT + qHM_SkDairitenKobetuJyouhou +
            $FROM(qHM_SkDairitenKobetuJyouhou) +
            $WHERE + qHM_SkDairitenKobetuJyouhou.drtenRnrkhouKbn.eq(pDrtenRnrkhouKbn);


        return em.createJPQL(strSpl).bind(qHM_SkDairitenKobetuJyouhou).getResultList();
    }

}
