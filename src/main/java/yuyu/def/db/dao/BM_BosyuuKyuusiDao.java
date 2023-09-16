package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_BosyuuKyuusi;
import yuyu.def.db.meta.QBM_BosyuuKyuusi;

/**
 * 募集休止マスタ(BM_BosyuuKyuusiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_BosyuuKyuusiDao extends AbstractDao<BM_BosyuuKyuusi> {

    public BM_BosyuuKyuusiDao() {
        super(BM_BosyuuKyuusi.class);
    }

    public BM_BosyuuKyuusi getBosyuuKyuusi(C_SysKbn pSksyskbn, String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, C_SkeijimuKbn pSkeijimukbn, Integer pHanteiyuusendo) {
        BM_BosyuuKyuusi bM_BosyuuKyuusi =  new BM_BosyuuKyuusi();
        bM_BosyuuKyuusi.setSksyskbn(pSksyskbn);
        bM_BosyuuKyuusi.setSyouhncd(pSyouhncd);
        bM_BosyuuKyuusi.setYoteiriritutkybr1(pYoteiriritutkybr1);
        bM_BosyuuKyuusi.setYoteiriritutkybr2(pYoteiriritutkybr2);
        bM_BosyuuKyuusi.setSkeijimukbn(pSkeijimukbn);
        bM_BosyuuKyuusi.setHanteiyuusendo(pHanteiyuusendo);
        return this.selectOne(bM_BosyuuKyuusi);
    }

    public List<BM_BosyuuKyuusi> getBosyuuKyuusiBySyouhncdSkeijimukbn(C_SysKbn pSksyskbn, String pSyouhncd, String pYoteiriritutkybr1, String pYoteiriritutkybr2, C_SkeijimuKbn pSkeijimukbn
        , C_BoskyuusiRiyuuKbn pBoskyuusiriyuukbn) {


        QBM_BosyuuKyuusi qBM_BosyuuKyuusi = new QBM_BosyuuKyuusi("qBM_BosyuuKyuusi");


        String joukenhensuu = "";

        if (!C_BoskyuusiRiyuuKbn.BLNK.eq(pBoskyuusiriyuukbn)) {
            joukenhensuu = joukenhensuu +
                $AND + qBM_BosyuuKyuusi.boskyuusiriyuukbn.eq(pBoskyuusiriyuukbn);
        }


        String strSql = $SELECT + qBM_BosyuuKyuusi +
            $FROM(qBM_BosyuuKyuusi) +
            $WHERE + qBM_BosyuuKyuusi.sksyskbn.eq(pSksyskbn) +
            $AND + qBM_BosyuuKyuusi.syouhncd.eq(pSyouhncd) +
            $AND + qBM_BosyuuKyuusi.yoteiriritutkybr1.eq(pYoteiriritutkybr1) +
            $AND + qBM_BosyuuKyuusi.yoteiriritutkybr2.eq(pYoteiriritutkybr2) +
            $AND + qBM_BosyuuKyuusi.skeijimukbn.eq(pSkeijimukbn) +
            joukenhensuu;
        $ORDER_BY(qBM_BosyuuKyuusi.hanteiyuusendo.asc());


        return em.createJPQL(strSql).bind(qBM_BosyuuKyuusi).getResultList();
    }
}
