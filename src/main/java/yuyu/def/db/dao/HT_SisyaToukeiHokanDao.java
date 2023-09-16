package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_SisyaToukeiHokan;

/**
 * 支社統計保管テーブル(HT_SisyaToukeiHokanDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SisyaToukeiHokanDao extends AbstractDao<HT_SisyaToukeiHokan> {

    public HT_SisyaToukeiHokanDao() {
        super(HT_SisyaToukeiHokan.class);
    }

    public HT_SisyaToukeiHokan getSisyaToukeiHokan(String pSstmosno, Integer pRenno) {
        HT_SisyaToukeiHokan hT_SisyaToukeiHokan =  new HT_SisyaToukeiHokan();
        hT_SisyaToukeiHokan.setSstmosno(pSstmosno);
        hT_SisyaToukeiHokan.setRenno(pRenno);
        return this.selectOne(hT_SisyaToukeiHokan);
    }

    public List<HT_SisyaToukeiHokan> getSisyaToukeiHokansBySstmosno(String pSstmosno) {
        HT_SisyaToukeiHokan hT_SisyaToukeiHokan =  new HT_SisyaToukeiHokan();
        hT_SisyaToukeiHokan.setSstmosno(pSstmosno);
        return this.select(hT_SisyaToukeiHokan);
    }
}
