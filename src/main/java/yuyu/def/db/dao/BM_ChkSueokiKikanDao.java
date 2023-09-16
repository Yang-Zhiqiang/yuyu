package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_SueokikknsmnKbn;
import yuyu.def.db.entity.BM_ChkSueokiKikan;
import yuyu.def.db.meta.QBM_ChkSueokiKikan;

/**
 * 据置期間チェックマスタ(BM_ChkSueokiKikanDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkSueokiKikanDao extends AbstractDao<BM_ChkSueokiKikan> {

    public BM_ChkSueokiKikanDao() {
        super(BM_ChkSueokiKikan.class);
    }

    public BM_ChkSueokiKikan getChkSueokiKikan(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, C_Channelcd pChannelcd, Integer pSueokikkn, C_SueokikknsmnKbn pSueokikknsmnkbn) {
        BM_ChkSueokiKikan bM_ChkSueokiKikan =  new BM_ChkSueokiKikan();
        bM_ChkSueokiKikan.setSyouhncd(pSyouhncd);
        bM_ChkSueokiKikan.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkSueokiKikan.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkSueokiKikan.setChannelcd(pChannelcd);
        bM_ChkSueokiKikan.setSueokikkn(pSueokikkn);
        bM_ChkSueokiKikan.setSueokikknsmnkbn(pSueokikknsmnkbn);
        return this.selectOne(bM_ChkSueokiKikan);
    }

    public List<BM_ChkSueokiKikan> getChkSueokiKikansByPk(String pSyouhncd, Integer pSyouhnsdno, C_Channelcd pChannelcd, Integer pSueokikkn, C_SueokikknsmnKbn pSueokikknsmnkbn) {


        QBM_ChkSueokiKikan qBM_ChkSueokiKikan = new QBM_ChkSueokiKikan("qBM_ChkSueokiKikan");


        String strSql = $SELECT + qBM_ChkSueokiKikan +
            $FROM(qBM_ChkSueokiKikan) +
            $WHERE + qBM_ChkSueokiKikan.syouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkSueokiKikan.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkSueokiKikan.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkSueokiKikan.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkSueokiKikan.sueokikkn.eq(pSueokikkn) +
            $AND + qBM_ChkSueokiKikan.sueokikknsmnkbn.eq(pSueokikknsmnkbn);


        return em.createJPQL(strSql).bind(qBM_ChkSueokiKikan).getResultList();
    }
}
