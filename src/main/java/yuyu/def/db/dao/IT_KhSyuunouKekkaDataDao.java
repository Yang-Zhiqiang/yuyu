package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_KhSyuunouKekkaData;

/**
 * 収納結果データテーブル(IT_KhSyuunouKekkaDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhSyuunouKekkaDataDao extends AbstractDao<IT_KhSyuunouKekkaData> {

    public IT_KhSyuunouKekkaDataDao() {
        super(IT_KhSyuunouKekkaData.class);
    }

    public IT_KhSyuunouKekkaData getKhSyuunouKekkaData(C_AnsyuusysKbn pAnsyuusyskbn,
         BizDate pSyoriYmd,
         String pSyono,
         BizDateYM pJyuutouym){
        IT_KhSyuunouKekkaData iT_KhSyuunouKekkaData =  new IT_KhSyuunouKekkaData();
        iT_KhSyuunouKekkaData.setAnsyuusyskbn(pAnsyuusyskbn);
        iT_KhSyuunouKekkaData.setSyoriYmd(pSyoriYmd);
        iT_KhSyuunouKekkaData.setSyono(pSyono);
        iT_KhSyuunouKekkaData.setJyuutouym(pJyuutouym);
        return this.selectOne(iT_KhSyuunouKekkaData);
    }
}
