package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_KhUriageKekkaData;

/**
 * 売上結果データテーブル(IT_KhUriageKekkaDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhUriageKekkaDataDao extends AbstractDao<IT_KhUriageKekkaData> {

    public IT_KhUriageKekkaDataDao() {
        super(IT_KhUriageKekkaData.class);
    }

    public IT_KhUriageKekkaData getKhUriageKekkaData(C_AnsyuusysKbn pAnsyuusyskbn,
         String pUriagekekkadatarenno){
        IT_KhUriageKekkaData iT_KhUriageKekkaData =  new IT_KhUriageKekkaData();
        iT_KhUriageKekkaData.setAnsyuusyskbn(pAnsyuusyskbn);
        iT_KhUriageKekkaData.setUriagekekkadatarenno(pUriagekekkadatarenno);
        return this.selectOne(iT_KhUriageKekkaData);
    }
}
