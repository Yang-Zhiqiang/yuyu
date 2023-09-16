package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.BM_ChkTargetTkMokuhyouti;
import yuyu.def.db.meta.QBM_ChkTargetTkMokuhyouti;

/**
 * ターゲット特約目標値チェックマスタ(BM_ChkTargetTkMokuhyoutiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkTargetTkMokuhyoutiDao extends AbstractDao<BM_ChkTargetTkMokuhyouti> {

    public BM_ChkTargetTkMokuhyoutiDao() {
        super(BM_ChkTargetTkMokuhyouti.class);
    }

    public BM_ChkTargetTkMokuhyouti getChkTargetTkMokuhyouti(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, Integer pTargettkmokuhyouti) {
        BM_ChkTargetTkMokuhyouti bM_ChkTargetTkMokuhyouti =  new BM_ChkTargetTkMokuhyouti();
        bM_ChkTargetTkMokuhyouti.setSyouhncd(pSyouhncd);
        bM_ChkTargetTkMokuhyouti.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkTargetTkMokuhyouti.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkTargetTkMokuhyouti.setChannelcd(pChannelcd);
        bM_ChkTargetTkMokuhyouti.setTargettkmokuhyouti(pTargettkmokuhyouti);
        return this.selectOne(bM_ChkTargetTkMokuhyouti);
    }

    public List<BM_ChkTargetTkMokuhyouti> getChkTargetTkMokuhyoutisByPk(String pSyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, Integer pTargettkmokuhyouti) {


        QBM_ChkTargetTkMokuhyouti qbM_ChkTargetTkMokuhyouti = new QBM_ChkTargetTkMokuhyouti();


        String strSql = $SELECT + qbM_ChkTargetTkMokuhyouti +
            $FROM + qbM_ChkTargetTkMokuhyouti.BM_ChkTargetTkMokuhyouti() +
            $WHERE + qbM_ChkTargetTkMokuhyouti.syouhncd.eq(pSyouhncd) +
            $AND + qbM_ChkTargetTkMokuhyouti.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qbM_ChkTargetTkMokuhyouti.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qbM_ChkTargetTkMokuhyouti.channelcd.eq(pChannelcd) +
            $AND + qbM_ChkTargetTkMokuhyouti.targettkmokuhyouti.eq(pTargettkmokuhyouti);


        return em.createJPQL(strSql).bind(qbM_ChkTargetTkMokuhyouti).getResultList();
    }
}
