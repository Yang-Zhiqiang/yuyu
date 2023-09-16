package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkHrkPTani;
import yuyu.def.db.meta.QBM_ChkHrkPTani;

/**
 * 払込Ｐ単位チェックマスタ(BM_ChkHrkPTaniDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkHrkPTaniDao extends AbstractDao<BM_ChkHrkPTani> {

    public BM_ChkHrkPTaniDao() {
        super(BM_ChkHrkPTani.class);
    }

    public BM_ChkHrkPTani getChkHrkPTani(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, C_Tuukasyu pHrktuukasyu) {
        BM_ChkHrkPTani bM_ChkHrkPTani =  new BM_ChkHrkPTani();
        bM_ChkHrkPTani.setSyouhncd(pSyouhncd);
        bM_ChkHrkPTani.setHrkkaisuu(pHrkkaisuu);
        bM_ChkHrkPTani.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkHrkPTani.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkHrkPTani.setChannelcd(pChannelcd);
        bM_ChkHrkPTani.setHrktuukasyu(pHrktuukasyu);
        return this.selectOne(bM_ChkHrkPTani);
    }


    public List<BM_ChkHrkPTani> getChkHrkPTanisByPK(String pSyouhncd, C_Hrkkaisuu pHrkkaisuu, Integer pSyouhnsdno,
        C_Channelcd pChannelcd, C_Tuukasyu pHrktuukasyu) {

        QBM_ChkHrkPTani qBM_ChkHrkPTani = new QBM_ChkHrkPTani();


        String strSql = $SELECT + qBM_ChkHrkPTani +
            $FROM + qBM_ChkHrkPTani.BM_ChkHrkPTani() +
            $WHERE + qBM_ChkHrkPTani.syouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkHrkPTani.hrkkaisuu.eq(pHrkkaisuu) +
            $AND + qBM_ChkHrkPTani.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkHrkPTani.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkHrkPTani.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkHrkPTani.hrktuukasyu.eq(pHrktuukasyu);


        return em.createJPQL(strSql).bind(qBM_ChkHrkPTani).getResultList();
    }
}
