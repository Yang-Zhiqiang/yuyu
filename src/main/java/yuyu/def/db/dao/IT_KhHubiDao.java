package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KhHubi;
import yuyu.def.db.meta.QIT_KhHubi;
import yuyu.def.db.meta.QIT_KhHubiDetail;

/**
 * 契約保全不備テーブル(IT_KhHubiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhHubiDao extends AbstractDao<IT_KhHubi> {

    public IT_KhHubiDao() {
        super(IT_KhHubi.class);
    }

    public IT_KhHubi getKhHubi(String pHubisikibetukey){
        IT_KhHubi iT_KhHubi =  new IT_KhHubi();
        iT_KhHubi.setHubisikibetukey(pHubisikibetukey);
        return this.selectOne(iT_KhHubi);
    }

    public List<IT_KhHubi> getKhHubisBySyono(String pSyono) {

        IT_KhHubi iT_KhHubi = new IT_KhHubi();
        iT_KhHubi.setSyono(pSyono);
        return this.select(iT_KhHubi);
    }

    public List<IT_KhHubi> getKhHubisBySyonoHubisikibetukeys(String pSyono, String[] pHubisikibetukey) {


        QIT_KhHubi qIT_KhHubi = new QIT_KhHubi();

        QIT_KhHubiDetail qIT_KhHubiDetail = new QIT_KhHubiDetail();


        String queryStr = $SELECT_DISTINCT + qIT_KhHubi +
            $FROM + qIT_KhHubi.IT_KhHubi() + "," +
            qIT_KhHubiDetail.IT_KhHubiDetail() +
            $WHERE + qIT_KhHubi.syono.eq(pSyono) +
            $AND + qIT_KhHubi.hubisikibetukey.in(pHubisikibetukey) +
            $AND + qIT_KhHubi.hubisikibetukey.eq(qIT_KhHubiDetail.hubisikibetukey) +
            $AND + qIT_KhHubiDetail.kaisyouymd.isNull() +
            $AND + qIT_KhHubiDetail.hasinymd.isNotNull() +
            $ORDER_BY(qIT_KhHubi.sksreadymd.asc());


        return em.createJPQL(queryStr).bind(qIT_KhHubi, qIT_KhHubiDetail).getResultList();
    }
}
