package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkJhSaiteiP;
import yuyu.def.db.meta.QBM_ChkJhSaiteiP;

/**
 * 最低Ｐ事方書チェックマスタ(BM_ChkJhSaiteiPDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkJhSaiteiPDao extends AbstractDao<BM_ChkJhSaiteiP> {

    public BM_ChkJhSaiteiPDao() {
        super(BM_ChkJhSaiteiP.class);
    }

    public BM_ChkJhSaiteiP getChkJhSaiteiP(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, BizNumber pHrkkknfrom, BizNumber pHrkkknto, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {
        BM_ChkJhSaiteiP bM_ChkJhSaiteiP =  new BM_ChkJhSaiteiP();
        bM_ChkJhSaiteiP.setSyouhncd(pSyouhncd);
        bM_ChkJhSaiteiP.setHrkkaisuu(pHrkkaisuu);
        bM_ChkJhSaiteiP.setHrkkknfrom(pHrkkknfrom);
        bM_ChkJhSaiteiP.setHrkkknto(pHrkkknto);
        bM_ChkJhSaiteiP.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkJhSaiteiP.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkJhSaiteiP.setChannelcd(pChannelcd);
        bM_ChkJhSaiteiP.setTuukasyu(pTuukasyu);
        bM_ChkJhSaiteiP.setSyouhinbetukey1(pSyouhinbetukey1);
        return this.selectOne(bM_ChkJhSaiteiP);
    }

    public List<BM_ChkJhSaiteiP> getChkJhSaiteiPsByPk(String pSyouhncd, C_Channelcd pChannelcd,
        C_Hrkkaisuu pHrkkaisuu, Integer pHrkkkny, Integer pSyouhnsdno,
        C_Tuukasyu pTuukasyu, String pSyouhinbetukey1) {


        QBM_ChkJhSaiteiP qBM_ChkJhSaiteiP = new QBM_ChkJhSaiteiP();


        String strSql = $SELECT + qBM_ChkJhSaiteiP +
            $FROM + qBM_ChkJhSaiteiP.BM_ChkJhSaiteiP() +
            $WHERE + qBM_ChkJhSaiteiP.syouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkJhSaiteiP.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkJhSaiteiP.hrkkaisuu.eq(pHrkkaisuu) +
            $AND + qBM_ChkJhSaiteiP.hrkkknfrom.le(BizNumber.valueOf(pHrkkkny)) +
            $AND + qBM_ChkJhSaiteiP.hrkkknto.ge(BizNumber.valueOf(pHrkkkny)) +
            $AND + qBM_ChkJhSaiteiP.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkJhSaiteiP.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkJhSaiteiP.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_ChkJhSaiteiP.syouhinbetukey1.eq(pSyouhinbetukey1);


        return em.createJPQL(strSql).bind(qBM_ChkJhSaiteiP).getResultList();
    }
}
