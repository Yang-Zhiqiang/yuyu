package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HT_YuukoukknKykList;

/**
 * 有効期間経過契約リストテーブル(HT_YuukoukknKykListDao) アクセス用の DAO クラスです。<br />
 */
public class HT_YuukoukknKykListDao extends AbstractDao<HT_YuukoukknKykList> {

    public HT_YuukoukknKykListDao() {
        super(HT_YuukoukknKykList.class);
    }

    public HT_YuukoukknKykList getYuukoukknKykList(String pMosno,
            BizDate pTyouhyouymd){
        HT_YuukoukknKykList hT_YuukoukknKykList =  new HT_YuukoukknKykList();
        hT_YuukoukknKykList.setMosno(pMosno);
        hT_YuukoukknKykList.setTyouhyouymd(pTyouhyouymd);
        return this.selectOne(hT_YuukoukknKykList);
    }

    public List<HT_YuukoukknKykList> getYuukoukknKykListsByMosno(String pMosno) {

        HT_YuukoukknKykList hT_YuukoukknKykList =  new HT_YuukoukknKykList();
        hT_YuukoukknKykList.setMosno(pMosno);
        return this.select(hT_YuukoukknKykList);
    }
}
