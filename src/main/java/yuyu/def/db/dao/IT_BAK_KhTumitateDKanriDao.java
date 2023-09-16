package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_BAK_KhTumitateDKanri;
import yuyu.def.db.meta.QIT_BAK_KhTumitateDKanri;

/**
 * 積立Ｄ管理バックアップテーブル(IT_BAK_KhTumitateDKanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhTumitateDKanriDao extends AbstractDao<IT_BAK_KhTumitateDKanri> {

    public IT_BAK_KhTumitateDKanriDao() {
        super(IT_BAK_KhTumitateDKanri.class);
    }

    public IT_BAK_KhTumitateDKanri getBAKKhTumitateDKanri(String pSyono, String pTrkssikibetukey, BizDate pTumitatedtumitateymd, Integer pRenno) {
        IT_BAK_KhTumitateDKanri iT_BAK_KhTumitateDKanri =  new IT_BAK_KhTumitateDKanri( pSyono,  pTrkssikibetukey,  pTumitatedtumitateymd,  pRenno);
        return this.selectOne(iT_BAK_KhTumitateDKanri);
    }

    public List<IT_BAK_KhTumitateDKanri> getBAKKhTumitateDKanriBySyonoTrkssikibetukey(String pSyono,
        String pTrkssikibetukey) {


        QIT_BAK_KhTumitateDKanri qIT_BAK_KhTumitateDKanri = new QIT_BAK_KhTumitateDKanri("qIT_BAK_KhTumitateDKanri");

        String queryStr = $SELECT + qIT_BAK_KhTumitateDKanri +
            $FROM(qIT_BAK_KhTumitateDKanri) +
            $WHERE + qIT_BAK_KhTumitateDKanri.syono.eq(pSyono) +
            $AND + qIT_BAK_KhTumitateDKanri.trkssikibetukey.eq(pTrkssikibetukey);

        return em.createJPQL(queryStr).bind(qIT_BAK_KhTumitateDKanri).getResultList();
    }

}
