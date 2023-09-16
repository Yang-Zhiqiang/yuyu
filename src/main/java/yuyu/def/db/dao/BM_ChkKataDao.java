package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkKata;
import yuyu.def.db.meta.QBM_ChkKata;

/**
 * 型区分チェックマスタ(BM_ChkKataDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkKataDao extends AbstractDao<BM_ChkKata> {

    public BM_ChkKataDao() {
        super(BM_ChkKata.class);
    }

    public BM_ChkKata getChkKata(String pSyouhncd,
            Integer pSyusyouhnsdnofrom,
            Integer pSyusyouhnsdnoto,
            C_UmuKbn pTktanbrumu,
            C_KataKbn pKatakbn){
        BM_ChkKata bM_ChkKata =  new BM_ChkKata();
        bM_ChkKata.setSyouhncd(pSyouhncd);
        bM_ChkKata.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkKata.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkKata.setTktanbrumu(pTktanbrumu);
        bM_ChkKata.setKatakbn(pKatakbn);
        return this.selectOne(bM_ChkKata);
    }

    public List<BM_ChkKata> getChkKatasByPk(String pSyouhncd, Integer pSyouhnsdno, C_UmuKbn pTktanbrumu,
            C_KataKbn pKatakbn) {


        QBM_ChkKata qBM_ChkKata = new QBM_ChkKata();


        String querySql = $SELECT + qBM_ChkKata +
                $FROM + qBM_ChkKata.BM_ChkKata() +
                $WHERE + qBM_ChkKata.syouhncd.eq(pSyouhncd) +
                $AND + qBM_ChkKata.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkKata.syusyouhnsdnoto.ge(pSyouhnsdno) +
                $AND + qBM_ChkKata.tktanbrumu.eq(pTktanbrumu) +
                $AND + qBM_ChkKata.katakbn.eq(pKatakbn);


        return em.createJPQL(querySql).bind(qBM_ChkKata).getResultList();
    }
}
