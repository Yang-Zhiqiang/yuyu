package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.db.entity.BT_YendthnkSikinIdouData;

/**
 * 円建変更資金移動データテーブル(BT_YendthnkSikinIdouDataDao) アクセス用の DAO クラスです。<br />
 */
public class BT_YendthnkSikinIdouDataDao extends AbstractDao<BT_YendthnkSikinIdouData> {

    public BT_YendthnkSikinIdouDataDao() {
        super(BT_YendthnkSikinIdouData.class);
    }

    public BT_YendthnkSikinIdouData getYendthnkSikinIdouData(String pSyono, C_KeiriyendthnkKbn pKeiriyendthnkkbn, BizDate pSyoriYmd) {
        BT_YendthnkSikinIdouData bT_YendthnkSikinIdouData =  new BT_YendthnkSikinIdouData();
        bT_YendthnkSikinIdouData.setSyono(pSyono);
        bT_YendthnkSikinIdouData.setKeiriyendthnkkbn(pKeiriyendthnkkbn);
        bT_YendthnkSikinIdouData.setSyoriYmd(pSyoriYmd);
        return this.selectOne(bT_YendthnkSikinIdouData);
    }

}
