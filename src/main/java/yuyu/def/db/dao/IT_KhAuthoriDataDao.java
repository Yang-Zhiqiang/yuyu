package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_KhAuthoriData;

/**
 * オーソリデータテーブル(IT_KhAuthoriDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhAuthoriDataDao extends AbstractDao<IT_KhAuthoriData> {

    public IT_KhAuthoriDataDao() {
        super(IT_KhAuthoriData.class);
    }

    public IT_KhAuthoriData getKhAuthoriData(C_AnsyuusysKbn pAnsyuusyskbn,
         BizDate pSyoriYmd,
         String pSyono,
         Integer pAuthorikaisuu){
        IT_KhAuthoriData iT_KhAuthoriData =  new IT_KhAuthoriData();
        iT_KhAuthoriData.setAnsyuusyskbn(pAnsyuusyskbn);
        iT_KhAuthoriData.setSyoriYmd(pSyoriYmd);
        iT_KhAuthoriData.setSyono(pSyono);
        iT_KhAuthoriData.setAuthorikaisuu(pAuthorikaisuu);
        return this.selectOne(iT_KhAuthoriData);
    }
}
