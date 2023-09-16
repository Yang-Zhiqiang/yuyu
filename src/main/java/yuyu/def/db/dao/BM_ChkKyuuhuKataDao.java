package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.entity.BM_ChkKyuuhuKata;
import yuyu.def.db.meta.QBM_ChkKyuuhuKata;

/**
 * 給付型チェックマスタ(BM_ChkKyuuhuKataDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkKyuuhuKataDao extends AbstractDao<BM_ChkKyuuhuKata> {

    public BM_ChkKyuuhuKataDao() {
        super(BM_ChkKyuuhuKata.class);
    }

    public BM_ChkKyuuhuKata getChkKyuuhuKata(String pSyouhncd,
            Integer pSyusyouhnsdnofrom,
            Integer pSyusyouhnsdnoto,
            C_KyhgndkataKbn pKyhkatakbn){
        BM_ChkKyuuhuKata bM_ChkKyuuhuKata =  new BM_ChkKyuuhuKata();
        bM_ChkKyuuhuKata.setSyouhncd(pSyouhncd);
        bM_ChkKyuuhuKata.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkKyuuhuKata.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkKyuuhuKata.setKyhkatakbn(pKyhkatakbn);
        return this.selectOne(bM_ChkKyuuhuKata);
    }

    public List<BM_ChkKyuuhuKata> getChkKyuuhuKatasByPk(String pSyouhncd, Integer pSyouhnsdno, C_KyhgndkataKbn pKyhkatakbn) {


        QBM_ChkKyuuhuKata qBM_ChkKyuuhuKata = new QBM_ChkKyuuhuKata();


        String querySql = $SELECT + qBM_ChkKyuuhuKata +
                $FROM + qBM_ChkKyuuhuKata.BM_ChkKyuuhuKata() +
                $WHERE + qBM_ChkKyuuhuKata.syouhncd.eq(pSyouhncd) +
                $AND + qBM_ChkKyuuhuKata.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkKyuuhuKata.syusyouhnsdnoto.ge(pSyouhnsdno) +
                $AND + qBM_ChkKyuuhuKata.kyhkatakbn.eq(pKyhkatakbn);


        return em.createJPQL(querySql).bind(qBM_ChkKyuuhuKata).getResultList();
    }
}
