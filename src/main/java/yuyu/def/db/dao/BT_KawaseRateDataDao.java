package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.db.entity.BT_KawaseRateData;

/**
 * 為替レートデータテーブル(BT_KawaseRateDataDao) アクセス用の DAO クラスです。<br />
 */
public class BT_KawaseRateDataDao extends AbstractDao<BT_KawaseRateData> {

    public BT_KawaseRateDataDao() {
        super(BT_KawaseRateData.class);
    }

    public BT_KawaseRateData getKawaseRateData(BizDate pKwsratekjymd, C_KwsrendouKbn pKwsrendoukbn) {
        BT_KawaseRateData bT_KawaseRateData =  new BT_KawaseRateData();
        bT_KawaseRateData.setKwsratekjymd(pKwsratekjymd);
        bT_KawaseRateData.setKwsrendoukbn(pKwsrendoukbn);
        return this.selectOne(bT_KawaseRateData);
    }
}
