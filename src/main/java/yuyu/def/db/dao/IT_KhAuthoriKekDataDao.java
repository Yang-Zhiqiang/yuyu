package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_KhAuthoriKekData;

/**
 * オーソリ結果データテーブル(IT_KhAuthoriKekDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhAuthoriKekDataDao extends AbstractDao<IT_KhAuthoriKekData> {

    public IT_KhAuthoriKekDataDao() {
        super(IT_KhAuthoriKekData.class);
    }

    public IT_KhAuthoriKekData getKhAuthoriKekData(C_AnsyuusysKbn pAnsyuusyskbn,
         String pAuthorikkdatarenno){
        IT_KhAuthoriKekData iT_KhAuthoriKekData =  new IT_KhAuthoriKekData();
        iT_KhAuthoriKekData.setAnsyuusyskbn(pAnsyuusyskbn);
        iT_KhAuthoriKekData.setAuthorikkdatarenno(pAuthorikkdatarenno);
        return this.selectOne(iT_KhAuthoriKekData);
    }
}
