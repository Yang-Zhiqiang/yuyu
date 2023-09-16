package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.meta.QIT_KhDshrTuki;

/**
 * 契約保全Ｄ支払統計テーブル(IT_KhDshrTukiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhDshrTukiDao extends AbstractDao<IT_KhDshrTuki> {

    public IT_KhDshrTukiDao() {
        super(IT_KhDshrTuki.class);
    }

    public IT_KhDshrTuki getKhDshrTuki(String pDshrtoukeisikibetukey, String pSyono) {
        IT_KhDshrTuki iT_KhDshrTuki =  new IT_KhDshrTuki();
        iT_KhDshrTuki.setDshrtoukeisikibetukey(pDshrtoukeisikibetukey);
        iT_KhDshrTuki.setSyono(pSyono);
        return this.selectOne(iT_KhDshrTuki);
    }

    public List<IT_KhDshrTuki> getKhDshrTukiBySyono(String pSyono) {

        QIT_KhDshrTuki qIT_KhDshrTuki = new QIT_KhDshrTuki("qIT_KhDshrTuki");

        String queryStr = $SELECT + qIT_KhDshrTuki +
            $FROM(qIT_KhDshrTuki) +
            $WHERE + qIT_KhDshrTuki.syono.eq(pSyono);

        return em.createJPQL(queryStr).bind(qIT_KhDshrTuki).getResultList();
    }
}
