package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_ChkYukokekkaData;

/**
 * 有効性確認結果データテーブル(IT_ChkYukokekkaDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_ChkYukokekkaDataDao extends AbstractDao<IT_ChkYukokekkaData> {

    public IT_ChkYukokekkaDataDao() {
        super(IT_ChkYukokekkaData.class);
    }

    public IT_ChkYukokekkaData getChkYukokekkaData(C_AnsyuusysKbn pAnsyuusyskbn,
         String pYuukoukekkarenno){
        IT_ChkYukokekkaData iT_ChkYukokekkaData =  new IT_ChkYukokekkaData();
        iT_ChkYukokekkaData.setAnsyuusyskbn(pAnsyuusyskbn);
        iT_ChkYukokekkaData.setYuukoukekkarenno(pYuukoukekkarenno);
        return this.selectOne(iT_ChkYukokekkaData);
    }
}
