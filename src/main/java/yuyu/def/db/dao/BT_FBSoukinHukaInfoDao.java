package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_FBSoukinHukaInfo;
import java.util.List;

/**
 * ＦＢ送金付加情報データテーブル(BT_FBSoukinHukaInfoDao) アクセス用の DAO クラスです。<br />
 */
public class BT_FBSoukinHukaInfoDao extends AbstractDao<BT_FBSoukinHukaInfo> {

    public BT_FBSoukinHukaInfoDao() {
        super(BT_FBSoukinHukaInfo.class);
    }

    public BT_FBSoukinHukaInfo getFBSoukinHukaInfo(String pFbsoukindatasikibetukey) {
        BT_FBSoukinHukaInfo bT_FBSoukinHukaInfo =  new BT_FBSoukinHukaInfo();
        bT_FBSoukinHukaInfo.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        return this.selectOne(bT_FBSoukinHukaInfo);
    }
}
