package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HW_JidouNyknTaisyougaiWk;

/**
 * 自動入金対象外ワークテーブル(HW_JidouNyknTaisyougaiWkDao) アクセス用の DAO クラスです。<br />
 */
public class HW_JidouNyknTaisyougaiWkDao extends AbstractDao<HW_JidouNyknTaisyougaiWk> {

    public HW_JidouNyknTaisyougaiWkDao() {
        super(HW_JidouNyknTaisyougaiWk.class);
    }

    public HW_JidouNyknTaisyougaiWk getJidouNyknTaisyougaiWk(BizDate pNyksyoriymd,
        String pItirenno){
        HW_JidouNyknTaisyougaiWk hW_JidouNyknTaisyougaiWk =  new HW_JidouNyknTaisyougaiWk();
        hW_JidouNyknTaisyougaiWk.setNyksyoriymd(pNyksyoriymd);
        hW_JidouNyknTaisyougaiWk.setItirenno(pItirenno);
        return this.selectOne(hW_JidouNyknTaisyougaiWk);
    }
}
