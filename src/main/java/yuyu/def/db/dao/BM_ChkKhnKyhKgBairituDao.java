package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.db.entity.BM_ChkKhnKyhKgBairitu;
import yuyu.def.db.meta.QBM_ChkKhnKyhKgBairitu;

/**
 * 基本給付金額倍率チェックマスタ(BM_ChkKhnKyhKgBairituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkKhnKyhKgBairituDao extends AbstractDao<BM_ChkKhnKyhKgBairitu> {

    public BM_ChkKhnKyhKgBairituDao() {
        super(BM_ChkKhnKyhKgBairitu.class);
    }

    public BM_ChkKhnKyhKgBairitu getChkKhnKyhKgBairitu(String pSyouhncd,
            Integer pSyusyouhnsdnofrom,
            Integer pSyusyouhnsdnoto,
            C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn){
        BM_ChkKhnKyhKgBairitu bM_ChkKhnKyhKgBairitu =  new BM_ChkKhnKyhKgBairitu();
        bM_ChkKhnKyhKgBairitu.setSyouhncd(pSyouhncd);
        bM_ChkKhnKyhKgBairitu.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkKhnKyhKgBairitu.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkKhnKyhKgBairitu.setKhnkyhkgbairitukbn(pKhnkyhkgbairitukbn);
        return this.selectOne(bM_ChkKhnKyhKgBairitu);
    }

    public List<BM_ChkKhnKyhKgBairitu> getChkKhnKyhKgBairitusByPk(String pSyouhncd, Integer pSyouhnsdno,
            C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {


        QBM_ChkKhnKyhKgBairitu qBM_ChkKhnKyhKgBairitu = new QBM_ChkKhnKyhKgBairitu();


        String querySql = $SELECT + qBM_ChkKhnKyhKgBairitu +
                $FROM + qBM_ChkKhnKyhKgBairitu.BM_ChkKhnKyhKgBairitu() +
                $WHERE + qBM_ChkKhnKyhKgBairitu.syouhncd.eq(pSyouhncd) +
                $AND + qBM_ChkKhnKyhKgBairitu.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkKhnKyhKgBairitu.syusyouhnsdnoto.ge(pSyouhnsdno) +
                $AND + qBM_ChkKhnKyhKgBairitu.khnkyhkgbairitukbn.eq(pKhnkyhkgbairitukbn);


        return em.createJPQL(querySql).bind(qBM_ChkKhnKyhKgBairitu).getResultList();
    }
}
