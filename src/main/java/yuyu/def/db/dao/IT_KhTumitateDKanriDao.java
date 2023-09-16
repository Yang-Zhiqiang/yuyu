package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.meta.QIT_KhTumitateDKanri;

/**
 * 積立Ｄ管理テーブル(IT_KhTumitateDKanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhTumitateDKanriDao extends AbstractDao<IT_KhTumitateDKanri> {

    public IT_KhTumitateDKanriDao() {
        super(IT_KhTumitateDKanri.class);
    }

    public IT_KhTumitateDKanri getKhTumitateDKanri(String pSyono, BizDate pTumitatedtumitateymd, Integer pRenno) {
        IT_KhTumitateDKanri iT_KhTumitateDKanri =  new IT_KhTumitateDKanri( pSyono,  pTumitatedtumitateymd,  pRenno);
        return this.selectOne(iT_KhTumitateDKanri);
    }

    public List<IT_KhTumitateDKanri> getKhTumitateDKanriBySyono(String pSyono) {


        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri("qIT_KhTumitateDKanri");

        String queryStr = $SELECT + qIT_KhTumitateDKanri +
            $FROM(qIT_KhTumitateDKanri) +
            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono) +
            $ORDER_BY(qIT_KhTumitateDKanri.tumitatedtumitateymd.asc(),
                qIT_KhTumitateDKanri.renno.asc());

        return em.createJPQL(queryStr).bind(qIT_KhTumitateDKanri).getResultList();
    }

}
