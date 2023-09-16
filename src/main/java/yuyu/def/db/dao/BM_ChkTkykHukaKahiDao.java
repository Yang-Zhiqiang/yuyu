package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkTkykHukaKahi;
import yuyu.def.db.meta.QBM_ChkTkykHukaKahi;

/**
 * 特約付加可否倍率チェックマスタ(BM_ChkTkykHukaKahiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkTkykHukaKahiDao extends AbstractDao<BM_ChkTkykHukaKahi> {

    public BM_ChkTkykHukaKahiDao() {
        super(BM_ChkTkykHukaKahi.class);
    }

    public BM_ChkTkykHukaKahi getChkTkykHukaKahi(String pTksyouhncd,
            String pSyusyouhncd,
            Integer pSyusyouhnsdnofrom,
            Integer pSyusyouhnsdnoto,
            C_Channelcd pChannelcd){
        BM_ChkTkykHukaKahi bM_ChkTkykHukaKahi =  new BM_ChkTkykHukaKahi();
        bM_ChkTkykHukaKahi.setTksyouhncd(pTksyouhncd);
        bM_ChkTkykHukaKahi.setSyusyouhncd(pSyusyouhncd);
        bM_ChkTkykHukaKahi.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkTkykHukaKahi.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkTkykHukaKahi.setChannelcd(pChannelcd);
        return this.selectOne(bM_ChkTkykHukaKahi);
    }

    public List<BM_ChkTkykHukaKahi> getChkTkykHukaKahisByPk(String pTksyouhncd, String pSyusyouhncd,
            Integer pSyouhnsdno, C_Channelcd pChannelcd) {


        QBM_ChkTkykHukaKahi qBM_ChkTkykHukaKahi = new QBM_ChkTkykHukaKahi();


        String querySql = $SELECT + qBM_ChkTkykHukaKahi +
                $FROM + qBM_ChkTkykHukaKahi.BM_ChkTkykHukaKahi() +
                $WHERE + qBM_ChkTkykHukaKahi.tksyouhncd.eq(pTksyouhncd) +
                $AND + qBM_ChkTkykHukaKahi.syusyouhncd.eq(pSyusyouhncd) +
                $AND + qBM_ChkTkykHukaKahi.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkTkykHukaKahi.syusyouhnsdnoto.ge(pSyouhnsdno) +
                $AND + qBM_ChkTkykHukaKahi.channelcd.eq(pChannelcd);


        return em.createJPQL(querySql).bind(qBM_ChkTkykHukaKahi).getResultList();
    }

    public List<BM_ChkTkykHukaKahi> getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu(
            String pSyusyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, C_UmuKbn pTkhukahissuumu) {


        QBM_ChkTkykHukaKahi qBM_ChkTkykHukaKahi = new QBM_ChkTkykHukaKahi();


        String strSql = $SELECT + qBM_ChkTkykHukaKahi +
                $FROM + qBM_ChkTkykHukaKahi.BM_ChkTkykHukaKahi() +
                $WHERE + qBM_ChkTkykHukaKahi.syusyouhncd.eq(pSyusyouhncd) +
                $AND + qBM_ChkTkykHukaKahi.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkTkykHukaKahi.syusyouhnsdnoto.ge(pSyouhnsdno) +
                $AND + qBM_ChkTkykHukaKahi.channelcd.eq(pChannelcd) +
                $AND + qBM_ChkTkykHukaKahi.tkhukahissuumu.eq(pTkhukahissuumu) +
                $ORDER_BY(qBM_ChkTkykHukaKahi.tksyouhncd);


        return em.createJPQL(strSql).bind(qBM_ChkTkykHukaKahi).getResultList();
    }
}
