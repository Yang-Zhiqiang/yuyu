package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.entity.HT_NayoseKekka;

/**
 * 名寄せ結果テーブル(HT_NayoseKekkaDao) アクセス用の DAO クラスです。<br />
 */
public class HT_NayoseKekkaDao extends AbstractDao<HT_NayoseKekka> {

    public HT_NayoseKekkaDao() {
        super(HT_NayoseKekka.class);
    }

    @Deprecated
    public HT_NayoseKekka getNayoseKekka(String pMosno,
         C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn,
         Integer pEdano){
        HT_NayoseKekka hT_NayoseKekka =  new HT_NayoseKekka();
        hT_NayoseKekka.setMosno(pMosno);
        hT_NayoseKekka.setSntkinfotaisyousyakbn(pSntkinfotaisyousyakbn);
        hT_NayoseKekka.setEdano(pEdano);
        return this.selectOne(hT_NayoseKekka);
    }

    @Override
    @Deprecated
    public List<HT_NayoseKekka> selectAll() {
        return super.selectAll();
    }
}
