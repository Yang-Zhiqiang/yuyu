package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.db.entity.IT_BAK_KhHaitouKanri;
import yuyu.def.db.meta.QIT_BAK_KhHaitouKanri;

/**
 * 配当管理バックアップテーブル(IT_BAK_KhHaitouKanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhHaitouKanriDao extends AbstractDao<IT_BAK_KhHaitouKanri> {

    public IT_BAK_KhHaitouKanriDao() {
        super(IT_BAK_KhHaitouKanri.class);
    }

    public IT_BAK_KhHaitouKanri getBAKKhHaitouKanri(String pSyono, String pTrkssikibetukey, BizDateY pHaitounendo, Integer pRenno, C_HaitoukinsksKbn pHaitoukinskskbn, C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        IT_BAK_KhHaitouKanri iT_BAK_KhHaitouKanri =  new IT_BAK_KhHaitouKanri( pSyono,  pTrkssikibetukey,  pHaitounendo,  pRenno,  pHaitoukinskskbn,  pHaitoumeisaikbn);
        return this.selectOne(iT_BAK_KhHaitouKanri);
    }

    public List<IT_BAK_KhHaitouKanri> getBAKKhHaitouKanriBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {


        QIT_BAK_KhHaitouKanri qIT_BAK_KhHaitouKanri = new QIT_BAK_KhHaitouKanri("qIT_BAK_KhHaitouKanri");

        String queryStr = $SELECT + qIT_BAK_KhHaitouKanri +
            $FROM(qIT_BAK_KhHaitouKanri) +
            $WHERE + qIT_BAK_KhHaitouKanri.syono.eq(pSyono) +
            $AND + qIT_BAK_KhHaitouKanri.trkssikibetukey.eq(pTrkssikibetukey);

        return em.createJPQL(queryStr).bind(qIT_BAK_KhHaitouKanri).getResultList();
    }

}
