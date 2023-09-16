package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.meta.QIT_KhHaitouKanri;

/**
 * 配当管理テーブル(IT_KhHaitouKanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhHaitouKanriDao extends AbstractDao<IT_KhHaitouKanri> {

    public IT_KhHaitouKanriDao() {
        super(IT_KhHaitouKanri.class);
    }

    @Deprecated
    public IT_KhHaitouKanri getKhHaitouKanri(String pSyono, BizDateY pHaitounendo, Integer pRenno, C_HaitoukinsksKbn pHaitoukinskskbn, C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        IT_KhHaitouKanri iT_KhHaitouKanri =  new IT_KhHaitouKanri( pSyono,  pHaitounendo,  pRenno,  pHaitoukinskskbn,  pHaitoumeisaikbn);
        return this.selectOne(iT_KhHaitouKanri);
    }

    @Override
    @Deprecated
    public List<IT_KhHaitouKanri> selectAll() {
        return super.selectAll();
    }

    public List<IT_KhHaitouKanri> getKhHaitouKanriBySyono(String pSyono) {


        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri("qIT_KhHaitouKanri");

        String queryStr = $SELECT + qIT_KhHaitouKanri +
            $FROM(qIT_KhHaitouKanri) +
            $WHERE + qIT_KhHaitouKanri.syono.eq(pSyono) +
            $ORDER_BY(qIT_KhHaitouKanri.haitounendo.asc(),
                qIT_KhHaitouKanri.renno.asc(),
                qIT_KhHaitouKanri.haitoukinskskbn.asc(),
                qIT_KhHaitouKanri.haitoumeisaikbn.asc());

        return em.createJPQL(queryStr).bind(qIT_KhHaitouKanri).getResultList();
    }
}
