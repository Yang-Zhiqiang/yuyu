package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhFBSoukinData;

/**
 * 契約保全ＦＢ送金データバックアップテーブル(IT_BAK_KhFBSoukinDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhFBSoukinDataDao extends AbstractDao<IT_BAK_KhFBSoukinData> {

    public IT_BAK_KhFBSoukinDataDao() {
        super(IT_BAK_KhFBSoukinData.class);
    }

    public IT_BAK_KhFBSoukinData getBAKKhFBSoukinData(String pFbsoukindatasikibetukey,
        String pTrkssikibetukey){
        IT_BAK_KhFBSoukinData iT_BAK_KhFBSoukinData =  new IT_BAK_KhFBSoukinData();
        iT_BAK_KhFBSoukinData.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        iT_BAK_KhFBSoukinData.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_KhFBSoukinData);
    }

    public List<IT_BAK_KhFBSoukinData> getBAKKhFBSoukinDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        IT_BAK_KhFBSoukinData iT_BAK_KhFBSoukinData = new IT_BAK_KhFBSoukinData();
        iT_BAK_KhFBSoukinData.setSyono(pSyono);
        iT_BAK_KhFBSoukinData.setTrkssikibetukey(pTrkssikibetukey);
        return this.select(iT_BAK_KhFBSoukinData);
    }
}
