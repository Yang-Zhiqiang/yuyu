package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.db.entity.AT_RoleSiyouKanouSosiki;
import yuyu.def.db.meta.QAT_RoleSiyouKanouSosiki;

/**
 * ロール使用可能組織テーブル(AT_RoleSiyouKanouSosikiDao) アクセス用の DAO クラスです。<br />
 */
public class AT_RoleSiyouKanouSosikiDao extends AbstractDao<AT_RoleSiyouKanouSosiki> {

    public AT_RoleSiyouKanouSosikiDao() {
        super(AT_RoleSiyouKanouSosiki.class);
    }

    public AT_RoleSiyouKanouSosiki getRoleSiyouKanouSosiki(String pSyozokusosikicd,
        String pRoleCd){
        AT_RoleSiyouKanouSosiki aT_RoleSiyouKanouSosiki =  new AT_RoleSiyouKanouSosiki();
        aT_RoleSiyouKanouSosiki.setSyozokusosikicd(pSyozokusosikicd);
        aT_RoleSiyouKanouSosiki.setRoleCd(pRoleCd);
        return this.selectOne(aT_RoleSiyouKanouSosiki);
    }

    public List<AT_RoleSiyouKanouSosiki> getRoleSiyouKanouSosikisBySyozokusosikicd(String pSyozokusosikicd) {


        QAT_RoleSiyouKanouSosiki qAT_RoleSiyouKanouSosiki =  new QAT_RoleSiyouKanouSosiki();


        String subQuerry ="";
        if (!StringUtil.isNullOrBlank(pSyozokusosikicd)) {

            subQuerry = $WHERE + qAT_RoleSiyouKanouSosiki.syozokusosikicd.like(pSyozokusosikicd + "%");
        }


        String querySql = $SELECT + qAT_RoleSiyouKanouSosiki +
            $FROM + qAT_RoleSiyouKanouSosiki.AT_RoleSiyouKanouSosiki() +
            subQuerry +
            $ORDER_BY(qAT_RoleSiyouKanouSosiki.roleCd.asc());

        return em.createJPQL(querySql).bind(qAT_RoleSiyouKanouSosiki).getResultList();
    }
}
