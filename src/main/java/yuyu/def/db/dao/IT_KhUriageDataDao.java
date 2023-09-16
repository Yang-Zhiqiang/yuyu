package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_KhUriageData;

/**
 * 売上データテーブル(IT_KhUriageDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhUriageDataDao extends AbstractDao<IT_KhUriageData> {

    public IT_KhUriageDataDao() {
        super(IT_KhUriageData.class);
    }

    public IT_KhUriageData getKhUriageData(C_AnsyuusysKbn pAnsyuusyskbn,
         BizDate pSyoriYmd,
         String pSyono,
         Integer pAuthorikaisuu){
        IT_KhUriageData iT_KhUriageData =  new IT_KhUriageData();
        iT_KhUriageData.setAnsyuusyskbn(pAnsyuusyskbn);
        iT_KhUriageData.setSyoriYmd(pSyoriYmd);
        iT_KhUriageData.setSyono(pSyono);
        iT_KhUriageData.setAuthorikaisuu(pAuthorikaisuu);
        return this.selectOne(iT_KhUriageData);
    }
}
