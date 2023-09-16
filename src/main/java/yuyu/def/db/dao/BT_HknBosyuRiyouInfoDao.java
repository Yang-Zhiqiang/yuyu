package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_HknBosyuRiyouInfo;

/**
 * 保険募集システム利用情報テーブル(BT_HknBosyuRiyouInfoDao) アクセス用の DAO クラスです。<br />
 */
public class BT_HknBosyuRiyouInfoDao extends AbstractDao<BT_HknBosyuRiyouInfo> {

    public BT_HknBosyuRiyouInfoDao() {
        super(BT_HknBosyuRiyouInfo.class);
    }

    public BT_HknBosyuRiyouInfo getHknBosyuRiyouInfo(String pDrtencd){
        BT_HknBosyuRiyouInfo bT_HknBosyuRiyouInfo =  new BT_HknBosyuRiyouInfo();
        bT_HknBosyuRiyouInfo.setDrtencd(pDrtencd);
        return this.selectOne(bT_HknBosyuRiyouInfo);
    }
}
