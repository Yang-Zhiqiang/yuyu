package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhDshrTuki;
import yuyu.def.db.meta.QIT_BAK_KhDshrTuki;

/**
 * 契約保全Ｄ支払統計バックアップテーブル(IT_BAK_KhDshrTukiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhDshrTukiDao extends AbstractDao<IT_BAK_KhDshrTuki> {

    public IT_BAK_KhDshrTukiDao() {
        super(IT_BAK_KhDshrTuki.class);
    }

    public IT_BAK_KhDshrTuki getBAKKhDshrTuki(String pDshrtoukeisikibetukey, String pSyono, String pTrkssikibetukey) {
        IT_BAK_KhDshrTuki iT_BAK_KhDshrTuki =  new IT_BAK_KhDshrTuki();
        iT_BAK_KhDshrTuki.setDshrtoukeisikibetukey(pDshrtoukeisikibetukey);
        iT_BAK_KhDshrTuki.setSyono(pSyono);
        iT_BAK_KhDshrTuki.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_KhDshrTuki);
    }

    public List<IT_BAK_KhDshrTuki> getBAKKhDshrTukiBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        QIT_BAK_KhDshrTuki qQIT_BAK_KhDshrTuki = new QIT_BAK_KhDshrTuki("qQIT_BAK_KhDshrTuki");

        String queryStr = $SELECT + qQIT_BAK_KhDshrTuki +
            $FROM(qQIT_BAK_KhDshrTuki) +
            $WHERE + qQIT_BAK_KhDshrTuki.syono.eq(pSyono) +
            $AND + qQIT_BAK_KhDshrTuki.trkssikibetukey.eq(pTrkssikibetukey);

        return em.createJPQL(queryStr).bind(qQIT_BAK_KhDshrTuki).getResultList();
    }
}
