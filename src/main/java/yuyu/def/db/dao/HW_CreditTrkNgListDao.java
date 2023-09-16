package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HW_CreditTrkNgList;

/**
 * クレジットカード会員登録ＮＧリストワークテーブル(HW_CreditTrkNgListDao) アクセス用の DAO クラスです。<br />
 */
public class HW_CreditTrkNgListDao extends AbstractDao<HW_CreditTrkNgList> {

    public HW_CreditTrkNgListDao() {
        super(HW_CreditTrkNgList.class);
    }

    public HW_CreditTrkNgList getCreditTrkNgList(BizDate pTyouhyouymd, Integer pDatarenno) {
        HW_CreditTrkNgList hW_CreditTrkNgList =  new HW_CreditTrkNgList();
        hW_CreditTrkNgList.setTyouhyouymd(pTyouhyouymd);
        hW_CreditTrkNgList.setDatarenno(pDatarenno);
        return this.selectOne(hW_CreditTrkNgList);
    }
}
