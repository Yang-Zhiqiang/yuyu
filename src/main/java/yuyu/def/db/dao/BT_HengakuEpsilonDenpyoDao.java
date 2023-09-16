package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DenpyouKbn;
import yuyu.def.classification.C_HengakuSyuruiKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TkbtKanjyouUnitFundKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BT_HengakuEpsilonDenpyo;

/**
 * 変額イプシロン伝票テーブル(BT_HengakuEpsilonDenpyoDao) アクセス用の DAO クラスです。<br />
 */
public class BT_HengakuEpsilonDenpyoDao extends AbstractDao<BT_HengakuEpsilonDenpyo> {

    public BT_HengakuEpsilonDenpyoDao() {
        super(BT_HengakuEpsilonDenpyo.class);
    }

    public BT_HengakuEpsilonDenpyo getHengakuEpsilonDenpyo(C_HengakuSyuruiKbn pHengakusyuruikbn,
         C_UnitFundKbn pUnitfundkbn,
         C_TkbtKanjyouUnitFundKbn pTkbtkanjyouunitfundkbn,
         String pKacd,
         BizDate pDenymd,
         C_DenpyouKbn pDenpyoukbn,
         C_TaisyakuKbn pTaisyakukbn,
         String pKamokucd,
         BizDate pSyoriYmd){
        BT_HengakuEpsilonDenpyo bT_HengakuEpsilonDenpyo =  new BT_HengakuEpsilonDenpyo();
        bT_HengakuEpsilonDenpyo.setHengakusyuruikbn(pHengakusyuruikbn);
        bT_HengakuEpsilonDenpyo.setUnitfundkbn(pUnitfundkbn);
        bT_HengakuEpsilonDenpyo.setTkbtkanjyouunitfundkbn(pTkbtkanjyouunitfundkbn);
        bT_HengakuEpsilonDenpyo.setKacd(pKacd);
        bT_HengakuEpsilonDenpyo.setDenymd(pDenymd);
        bT_HengakuEpsilonDenpyo.setDenpyoukbn(pDenpyoukbn);
        bT_HengakuEpsilonDenpyo.setTaisyakukbn(pTaisyakukbn);
        bT_HengakuEpsilonDenpyo.setKamokucd(pKamokucd);
        bT_HengakuEpsilonDenpyo.setSyoriYmd(pSyoriYmd);
        return this.selectOne(bT_HengakuEpsilonDenpyo);
    }
}
