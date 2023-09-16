package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.meta.QIT_Azukarikin;

/**
 * 預り金テーブル(IT_AzukarikinDao) アクセス用の DAO クラスです。<br />
 */
public class IT_AzukarikinDao extends AbstractDao<IT_Azukarikin> {

    public IT_AzukarikinDao() {
        super(IT_Azukarikin.class);
    }

    public IT_Azukarikin getAzukarikin(String pSyono, String pHenkousikibetukey, C_Tuukasyu pTuukasyu) {
        IT_Azukarikin iT_Azukarikin =  new IT_Azukarikin( pSyono,  pHenkousikibetukey,  pTuukasyu);
        return this.selectOne(iT_Azukarikin);
    }

    public List<IT_Azukarikin> getAzukarikinsBySyono(String pSyono) {


        QIT_Azukarikin qIT_Azukarikin = new QIT_Azukarikin("qIT_Azukarikin");


        String strSql = $SELECT + qIT_Azukarikin +
            $FROM (qIT_Azukarikin) +
            $WHERE + qIT_Azukarikin.syono .eq(pSyono) +
            $AND + qIT_Azukarikin.shrymd.isNull() +
            $ORDER_BY(qIT_Azukarikin.azukarikinhsiymd.asc());


        return em.createJPQL(strSql).bind(qIT_Azukarikin).getResultList();
    }

}
