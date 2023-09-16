package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_BAK_KhAuthoriData;

/**
 * オーソリデータバックアップテーブル(IT_BAK_KhAuthoriDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhAuthoriDataDao extends AbstractDao<IT_BAK_KhAuthoriData> {

    public IT_BAK_KhAuthoriDataDao() {
        super(IT_BAK_KhAuthoriData.class);
    }

    public IT_BAK_KhAuthoriData getBAKKhAuthoriData(C_AnsyuusysKbn pAnsyuusyskbn,
         String pTrkssikibetukey,
         BizDate pSyoriYmd,
         String pSyono,
         Integer pAuthorikaisuu){
        IT_BAK_KhAuthoriData iT_BAK_KhAuthoriData =  new IT_BAK_KhAuthoriData();
        iT_BAK_KhAuthoriData.setAnsyuusyskbn(pAnsyuusyskbn);
        iT_BAK_KhAuthoriData.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KhAuthoriData.setSyoriYmd(pSyoriYmd);
        iT_BAK_KhAuthoriData.setSyono(pSyono);
        iT_BAK_KhAuthoriData.setAuthorikaisuu(pAuthorikaisuu);
        return this.selectOne(iT_BAK_KhAuthoriData);
    }
}
