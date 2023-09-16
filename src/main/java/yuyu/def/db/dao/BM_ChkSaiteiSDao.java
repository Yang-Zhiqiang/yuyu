package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkSaiteiS;
import yuyu.def.db.meta.QBM_ChkSaiteiS;

/**
 * 最低Ｓチェックマスタ(BM_ChkSaiteiSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkSaiteiSDao extends AbstractDao<BM_ChkSaiteiS> {

    public BM_ChkSaiteiSDao() {
        super(BM_ChkSaiteiS.class);
    }

    public BM_ChkSaiteiS getChkSaiteiS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pDntsdnumufrom, Integer pDntsdnumuto, Integer pHrkkknsmnkbnfrom, Integer pHrkkknsmnkbnto, BizNumber pHknkknfrom, BizNumber pHknkknto, Integer pSaiteisknwtkumufrom, Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu) {
        BM_ChkSaiteiS bM_ChkSaiteiS =  new BM_ChkSaiteiS();
        bM_ChkSaiteiS.setSyouhncd(pSyouhncd);
        bM_ChkSaiteiS.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkSaiteiS.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkSaiteiS.setDntsdnumufrom(pDntsdnumufrom);
        bM_ChkSaiteiS.setDntsdnumuto(pDntsdnumuto);
        bM_ChkSaiteiS.setHrkkknsmnkbnfrom(pHrkkknsmnkbnfrom);
        bM_ChkSaiteiS.setHrkkknsmnkbnto(pHrkkknsmnkbnto);
        bM_ChkSaiteiS.setHknkknfrom(pHknkknfrom);
        bM_ChkSaiteiS.setHknkknto(pHknkknto);
        bM_ChkSaiteiS.setSaiteisknwtkumufrom(pSaiteisknwtkumufrom);
        bM_ChkSaiteiS.setSaiteisknwtkumuto(pSaiteisknwtkumuto);
        bM_ChkSaiteiS.setTuukasyu(pTuukasyu);
        return this.selectOne(bM_ChkSaiteiS);
    }

    public List<BM_ChkSaiteiS> getChkSaiteiSsBySyouhncdSyouhnsdnoItems(String pSyouhncd, Integer pSyouhnsdno, C_Hrkkeiro pHrkkeiro, Integer pSaiteisknwtkumu, C_Tuukasyu pTuukasyu) {


        QBM_ChkSaiteiS qBM_ChkSaiteiS = new QBM_ChkSaiteiS();


        String strWhere = "";


        if(pHrkkeiro.eq(C_Hrkkeiro.DANTAI) || pHrkkeiro.eq(C_Hrkkeiro.SYUUDAN)){

            strWhere += qBM_ChkSaiteiS.dntsdnumufrom.le(Integer.parseInt(C_UmuKbn.ARI.getValue())) +
                    $AND + qBM_ChkSaiteiS.dntsdnumuto.ge(Integer.parseInt(C_UmuKbn.ARI.getValue()));
        }


        else{

            strWhere += qBM_ChkSaiteiS.dntsdnumufrom.le(Integer.parseInt(C_UmuKbn.NONE.getValue())) +
                    $AND + qBM_ChkSaiteiS.dntsdnumuto.ge(Integer.parseInt(C_UmuKbn.NONE.getValue()));
        }
        strWhere += $AND + qBM_ChkSaiteiS.saiteisknwtkumufrom.le(pSaiteisknwtkumu) +
                $AND + qBM_ChkSaiteiS.saiteisknwtkumuto.ge(pSaiteisknwtkumu) +
                $AND + qBM_ChkSaiteiS.tuukasyu.eq(pTuukasyu);


        String strSql = $SELECT + qBM_ChkSaiteiS +
                $FROM + qBM_ChkSaiteiS.BM_ChkSaiteiS() +
                $WHERE + qBM_ChkSaiteiS.syouhncd.eq(pSyouhncd) +
                $AND + qBM_ChkSaiteiS.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkSaiteiS.syusyouhnsdnoto.ge(pSyouhnsdno) +
                $AND + strWhere;


        return em.createJPQL(strSql).bind(qBM_ChkSaiteiS).getResultList();
    }
}
