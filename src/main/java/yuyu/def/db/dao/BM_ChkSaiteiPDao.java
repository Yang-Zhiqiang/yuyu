package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSaiteiP;
import yuyu.def.db.meta.QBM_ChkSaiteiP;

/**
 * 最低Ｐチェックマスタ(BM_ChkSaiteiPDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkSaiteiPDao extends AbstractDao<BM_ChkSaiteiP> {

    public BM_ChkSaiteiPDao() {
        super(BM_ChkSaiteiP.class);
    }

    public BM_ChkSaiteiP getChkSaiteiP(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, BizNumber pHrkkknfrom, BizNumber pHrkkknto, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {
        BM_ChkSaiteiP bM_ChkSaiteiP =  new BM_ChkSaiteiP();
        bM_ChkSaiteiP.setSyouhncd(pSyouhncd);
        bM_ChkSaiteiP.setHrkkaisuu(pHrkkaisuu);
        bM_ChkSaiteiP.setHrkkknfrom(pHrkkknfrom);
        bM_ChkSaiteiP.setHrkkknto(pHrkkknto);
        bM_ChkSaiteiP.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkSaiteiP.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkSaiteiP.setChannelcd(pChannelcd);
        bM_ChkSaiteiP.setTuukasyu(pTuukasyu);
        bM_ChkSaiteiP.setSyouhinbetukey1(pSyouhinbetukey1);
        return this.selectOne(bM_ChkSaiteiP);
    }

    public List<BM_ChkSaiteiP> getChkSaiteiPsByPk(String pSyouhncd, C_Channelcd pChannelcd, C_Hrkkaisuu pHrkkaisuu,
        Integer pHrkkkny, Integer pSyouhnsdno, C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {


        QBM_ChkSaiteiP qBM_ChkSaiteiP = new QBM_ChkSaiteiP();


        String strSql = $SELECT + qBM_ChkSaiteiP +
            $FROM + qBM_ChkSaiteiP.BM_ChkSaiteiP() +
            $WHERE + qBM_ChkSaiteiP.syouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkSaiteiP.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkSaiteiP.hrkkaisuu.eq(pHrkkaisuu) +
            $AND + qBM_ChkSaiteiP.hrkkknfrom.le(BizNumber.valueOf(pHrkkkny)) +
            $AND + qBM_ChkSaiteiP.hrkkknto.ge(BizNumber.valueOf(pHrkkkny)) +
            $AND + qBM_ChkSaiteiP.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkSaiteiP.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkSaiteiP.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_ChkSaiteiP.syouhinbetukey1.eq(pSyouhinbetukey1);


        return em.createJPQL(strSql).bind(qBM_ChkSaiteiP).getResultList();
    }
}
