package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HW_CreditTrkHaneierrList;

/**
 * クレジットカード登録反映エラーリストワークテーブル(HW_CreditTrkHaneierrListDao) アクセス用の DAO クラスです。<br />
 */
public class HW_CreditTrkHaneierrListDao extends AbstractDao<HW_CreditTrkHaneierrList> {

    public HW_CreditTrkHaneierrListDao() {
        super(HW_CreditTrkHaneierrList.class);
    }

    public HW_CreditTrkHaneierrList getCreditTrkHaneierrList(BizDate pTyouhyouymd, Integer pDatarenno) {
        HW_CreditTrkHaneierrList hW_CreditTrkHaneierrList =  new HW_CreditTrkHaneierrList();
        hW_CreditTrkHaneierrList.setTyouhyouymd(pTyouhyouymd);
        hW_CreditTrkHaneierrList.setDatarenno(pDatarenno);
        return this.selectOne(hW_CreditTrkHaneierrList);
    }
}
