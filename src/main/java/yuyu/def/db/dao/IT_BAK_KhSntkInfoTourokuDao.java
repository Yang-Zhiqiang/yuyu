package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhSntkInfoTouroku;

/**
 * 契約保全選択情報登録バックアップテーブル(IT_BAK_KhSntkInfoTourokuDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhSntkInfoTourokuDao extends AbstractDao<IT_BAK_KhSntkInfoTouroku> {

    public IT_BAK_KhSntkInfoTourokuDao() {
        super(IT_BAK_KhSntkInfoTouroku.class);
    }

    public IT_BAK_KhSntkInfoTouroku getBAKKhSntkInfoTouroku(String pSyono,
         String pTrkssikibetukey,
         Integer pRenno){
        IT_BAK_KhSntkInfoTouroku iT_BAK_KhSntkInfoTouroku =  new IT_BAK_KhSntkInfoTouroku();
        iT_BAK_KhSntkInfoTouroku.setSyono(pSyono);
        iT_BAK_KhSntkInfoTouroku.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KhSntkInfoTouroku.setRenno(pRenno);
        return this.selectOne(iT_BAK_KhSntkInfoTouroku);
    }
}
