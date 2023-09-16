package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_UserKengenHaneiSskInfo;

/**
 * ユーザー権限自動反映組織情報テーブル(BT_UserKengenHaneiSskInfoDao) アクセス用の DAO クラスです。<br />
 */
public class BT_UserKengenHaneiSskInfoDao extends AbstractDao<BT_UserKengenHaneiSskInfo> {

    public BT_UserKengenHaneiSskInfoDao() {
        super(BT_UserKengenHaneiSskInfo.class);
    }

    public BT_UserKengenHaneiSskInfo getUserKengenHaneiSskInfo(String pSosikicdkami3) {
        BT_UserKengenHaneiSskInfo bT_UserKengenHaneiSskInfo =  new BT_UserKengenHaneiSskInfo();
        bT_UserKengenHaneiSskInfo.setSosikicdkami3(pSosikicdkami3);
        return this.selectOne(bT_UserKengenHaneiSskInfo);
    }
}
