package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HW_NyuukinJyouhouHuittiWk;

/**
 * 入金情報不一致ワークテーブル(HW_NyuukinJyouhouHuittiWkDao) アクセス用の DAO クラスです。<br />
 */
public class HW_NyuukinJyouhouHuittiWkDao extends AbstractDao<HW_NyuukinJyouhouHuittiWk> {

    public HW_NyuukinJyouhouHuittiWkDao() {
        super(HW_NyuukinJyouhouHuittiWk.class);
    }

    public HW_NyuukinJyouhouHuittiWk getNyuukinJyouhouHuittiWk(BizDate pNyksyoriymd,
        String pItirenno){
        HW_NyuukinJyouhouHuittiWk hW_NyuukinJyouhouHuittiWk =  new HW_NyuukinJyouhouHuittiWk();
        hW_NyuukinJyouhouHuittiWk.setNyksyoriymd(pNyksyoriymd);
        hW_NyuukinJyouhouHuittiWk.setItirenno(pItirenno);
        return this.selectOne(hW_NyuukinJyouhouHuittiWk);
    }
}
