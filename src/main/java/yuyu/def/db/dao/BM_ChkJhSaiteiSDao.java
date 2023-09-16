package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkJhSaiteiS;
import yuyu.def.db.meta.QBM_ChkJhSaiteiS;

/**
 * 最低Ｓ事方書チェックマスタ(BM_ChkJhSaiteiSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkJhSaiteiSDao extends AbstractDao<BM_ChkJhSaiteiS> {

    public BM_ChkJhSaiteiSDao() {
        super(BM_ChkJhSaiteiS.class);
    }

    public BM_ChkJhSaiteiS getChkJhSaiteiS(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, Integer pDntsdnumufrom, Integer pDntsdnumuto, Integer pHrkkknsmnkbnfrom, Integer pHrkkknsmnkbnto, BizNumber pHknkknfrom, BizNumber pHknkknto, Integer pSaiteisknwtkumufrom, Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu) {
        BM_ChkJhSaiteiS bM_ChkJhSaiteiS =  new BM_ChkJhSaiteiS();
        bM_ChkJhSaiteiS.setSyouhncd(pSyouhncd);
        bM_ChkJhSaiteiS.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkJhSaiteiS.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkJhSaiteiS.setDntsdnumufrom(pDntsdnumufrom);
        bM_ChkJhSaiteiS.setDntsdnumuto(pDntsdnumuto);
        bM_ChkJhSaiteiS.setHrkkknsmnkbnfrom(pHrkkknsmnkbnfrom);
        bM_ChkJhSaiteiS.setHrkkknsmnkbnto(pHrkkknsmnkbnto);
        bM_ChkJhSaiteiS.setHknkknfrom(pHknkknfrom);
        bM_ChkJhSaiteiS.setHknkknto(pHknkknto);
        bM_ChkJhSaiteiS.setSaiteisknwtkumufrom(pSaiteisknwtkumufrom);
        bM_ChkJhSaiteiS.setSaiteisknwtkumuto(pSaiteisknwtkumuto);
        bM_ChkJhSaiteiS.setTuukasyu(pTuukasyu);
        return this.selectOne(bM_ChkJhSaiteiS);
    }

    public List<BM_ChkJhSaiteiS> getChkJhSaiteiSsBySyouhncdSyouhnsdnoItems(String pSyouhncd, Integer pSyouhnsdno, C_Hrkkeiro pHrkkeiro, Integer pSaiteisknwtkumu, C_Tuukasyu pTuukasyu) {


        QBM_ChkJhSaiteiS qBM_ChkJhSaiteiS = new QBM_ChkJhSaiteiS();


        String strWhere = qBM_ChkJhSaiteiS.syouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkJhSaiteiS.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkJhSaiteiS.syusyouhnsdnoto.ge(pSyouhnsdno);

        if (pHrkkeiro.eq(C_Hrkkeiro.DANTAI) || pHrkkeiro.eq(C_Hrkkeiro.SYUUDAN)) {

            strWhere += $AND;
            strWhere += qBM_ChkJhSaiteiS.dntsdnumufrom.le(Integer.parseInt(C_UmuKbn.ARI.getValue()));
            strWhere += $AND;
            strWhere += qBM_ChkJhSaiteiS.dntsdnumuto.ge(Integer.parseInt(C_UmuKbn.ARI.getValue()));
        } else {

            strWhere += $AND;
            strWhere += qBM_ChkJhSaiteiS.dntsdnumufrom.le(Integer.parseInt(C_UmuKbn.NONE.getValue()));
            strWhere += $AND;
            strWhere += qBM_ChkJhSaiteiS.dntsdnumuto.ge(Integer.parseInt(C_UmuKbn.NONE.getValue()));
        }

        strWhere += $AND;
        strWhere += qBM_ChkJhSaiteiS.saiteisknwtkumufrom.le(pSaiteisknwtkumu);
        strWhere += $AND;
        strWhere += qBM_ChkJhSaiteiS.saiteisknwtkumuto.ge(pSaiteisknwtkumu);
        strWhere += $AND;
        strWhere += qBM_ChkJhSaiteiS.tuukasyu.eq(pTuukasyu);


        String strMainSql = $SELECT + qBM_ChkJhSaiteiS +
            $FROM + qBM_ChkJhSaiteiS.BM_ChkJhSaiteiS() +
            $WHERE + strWhere;


        return em.createJPQL(strMainSql).bind(qBM_ChkJhSaiteiS).getResultList();
    }

    public List<BM_ChkJhSaiteiS> getChkJhSaiteiSsByPk(String pSyouhncd, Integer pSyouhnsdno, Integer pDntsdnumufrom,
        Integer pDntsdnumuto, Integer pHrkkknsmnkbn, BizNumber pHknkkn, Integer pSaiteisknwtkumufrom,
        Integer pSaiteisknwtkumuto, C_Tuukasyu pTuukasyu) {


        QBM_ChkJhSaiteiS qBM_ChkJhSaiteiS = new QBM_ChkJhSaiteiS();


        String sql = $SELECT + qBM_ChkJhSaiteiS +
            $FROM + qBM_ChkJhSaiteiS.BM_ChkJhSaiteiS() +
            $WHERE + qBM_ChkJhSaiteiS.syouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkJhSaiteiS.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkJhSaiteiS.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkJhSaiteiS.dntsdnumufrom.le(pDntsdnumufrom) +
            $AND + qBM_ChkJhSaiteiS.dntsdnumuto.ge(pDntsdnumuto) +
            $AND + qBM_ChkJhSaiteiS.hrkkknsmnkbnfrom.le(pHrkkknsmnkbn) +
            $AND + qBM_ChkJhSaiteiS.hrkkknsmnkbnto.ge(pHrkkknsmnkbn) +
            $AND + qBM_ChkJhSaiteiS.hknkknfrom.le(pHknkkn) +
            $AND + qBM_ChkJhSaiteiS.hknkknto.ge(pHknkkn) +
            $AND + qBM_ChkJhSaiteiS.saiteisknwtkumufrom.le(pSaiteisknwtkumufrom) +
            $AND + qBM_ChkJhSaiteiS.saiteisknwtkumuto.ge(pSaiteisknwtkumuto) +
            $AND + qBM_ChkJhSaiteiS.tuukasyu.eq(pTuukasyu);


        return em.createJPQL(sql).bind(qBM_ChkJhSaiteiS).getResultList();
    }
}
