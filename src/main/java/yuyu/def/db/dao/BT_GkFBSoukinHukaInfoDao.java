package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_GkFBSoukinHukaInfo;
import java.util.List;

/**
 * 外貨ＦＢ送金付加情報データテーブル(BT_GkFBSoukinHukaInfoDao) アクセス用の DAO クラスです。<br />
 */
public class BT_GkFBSoukinHukaInfoDao extends AbstractDao<BT_GkFBSoukinHukaInfo> {

    public BT_GkFBSoukinHukaInfoDao() {
        super(BT_GkFBSoukinHukaInfo.class);
    }

    @Deprecated
    public BT_GkFBSoukinHukaInfo getGkFBSoukinHukaInfo(String pFbsoukindatasikibetukey) {
        BT_GkFBSoukinHukaInfo bT_GkFBSoukinHukaInfo =  new BT_GkFBSoukinHukaInfo();
        bT_GkFBSoukinHukaInfo.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        return this.selectOne(bT_GkFBSoukinHukaInfo);
    }

    @Override
    @Deprecated
    public List<BT_GkFBSoukinHukaInfo> selectAll() {
        return super.selectAll();
    }
}
