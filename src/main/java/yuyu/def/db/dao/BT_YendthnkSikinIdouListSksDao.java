package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.db.entity.BT_YendthnkSikinIdouListSks;

/**
 * 円建変更資金移動リスト作成用テーブル(BT_YendthnkSikinIdouListSksDao) アクセス用の DAO クラスです。<br />
 */
public class BT_YendthnkSikinIdouListSksDao extends AbstractDao<BT_YendthnkSikinIdouListSks> {

    public BT_YendthnkSikinIdouListSksDao() {
        super(BT_YendthnkSikinIdouListSks.class);
    }

    public BT_YendthnkSikinIdouListSks getYendthnkSikinIdouListSks(String pSyono, C_KeiriyendthnkKbn pKeiriyendthnkkbn, BizDate pSyoriYmd) {
        BT_YendthnkSikinIdouListSks bT_YendthnkSikinIdouListSks =  new BT_YendthnkSikinIdouListSks();
        bT_YendthnkSikinIdouListSks.setSyono(pSyono);
        bT_YendthnkSikinIdouListSks.setKeiriyendthnkkbn(pKeiriyendthnkkbn);
        bT_YendthnkSikinIdouListSks.setSyoriYmd(pSyoriYmd);
        return this.selectOne(bT_YendthnkSikinIdouListSks);
    }

}
