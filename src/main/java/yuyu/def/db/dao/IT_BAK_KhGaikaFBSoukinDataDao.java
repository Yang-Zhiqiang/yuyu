package yuyu.def.db.dao;
import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhGaikaFBSoukinData;

/**
 * 契約保全外貨ＦＢ送金データバックアップテーブル(IT_BAK_KhGaikaFBSoukinDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhGaikaFBSoukinDataDao extends AbstractDao<IT_BAK_KhGaikaFBSoukinData> {

    public IT_BAK_KhGaikaFBSoukinDataDao() {
        super(IT_BAK_KhGaikaFBSoukinData.class);
    }

    public IT_BAK_KhGaikaFBSoukinData getBAKKhGaikaFBSoukinData(String pFbsoukindatasikibetukey,
        String pTrkssikibetukey){
        IT_BAK_KhGaikaFBSoukinData iT_BAK_KhGaikaFBSoukinData =  new IT_BAK_KhGaikaFBSoukinData();
        iT_BAK_KhGaikaFBSoukinData.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        iT_BAK_KhGaikaFBSoukinData.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_KhGaikaFBSoukinData);
    }

    public List<IT_BAK_KhGaikaFBSoukinData> getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        IT_BAK_KhGaikaFBSoukinData iT_BAK_KhGaikaFBSoukinData =  new IT_BAK_KhGaikaFBSoukinData();
        iT_BAK_KhGaikaFBSoukinData.setSyono(pSyono);
        iT_BAK_KhGaikaFBSoukinData.setTrkssikibetukey(pTrkssikibetukey);
        return this.select(iT_BAK_KhGaikaFBSoukinData);
    }
}
