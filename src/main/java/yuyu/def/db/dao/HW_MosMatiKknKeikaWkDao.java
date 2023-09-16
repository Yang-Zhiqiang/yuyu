package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HW_MosMatiKknKeikaWk;

/**
 * 申込書入力待期間経過ワークテーブル(HW_MosMatiKknKeikaWkDao) アクセス用の DAO クラスです。<br />
 */
public class HW_MosMatiKknKeikaWkDao extends AbstractDao<HW_MosMatiKknKeikaWk> {

    public HW_MosMatiKknKeikaWkDao() {
        super(HW_MosMatiKknKeikaWk.class);
    }

    public HW_MosMatiKknKeikaWk getMosMatiKknKeikaWk(BizDate pNyksyoriymd,
        String pItirenno){
        HW_MosMatiKknKeikaWk hW_MosMatiKknKeikaWk =  new HW_MosMatiKknKeikaWk();
        hW_MosMatiKknKeikaWk.setNyksyoriymd(pNyksyoriymd);
        hW_MosMatiKknKeikaWk.setItirenno(pItirenno);
        return this.selectOne(hW_MosMatiKknKeikaWk);
    }
}
