package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.entity.HT_SentakuJyouhou;

/**
 * 選択情報テーブル(HT_SentakuJyouhouDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SentakuJyouhouDao extends AbstractDao<HT_SentakuJyouhou> {

    public HT_SentakuJyouhouDao() {
        super(HT_SentakuJyouhou.class);
    }

    @Deprecated
    public HT_SentakuJyouhou getSentakuJyouhou(String pMosno,
         C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn,
         Integer pEdano,
         String pSntkinfono){
        HT_SentakuJyouhou hT_SentakuJyouhou =  new HT_SentakuJyouhou();
        hT_SentakuJyouhou.setMosno(pMosno);
        hT_SentakuJyouhou.setSntkinfotaisyousyakbn(pSntkinfotaisyousyakbn);
        hT_SentakuJyouhou.setEdano(pEdano);
        hT_SentakuJyouhou.setSntkinfono(pSntkinfono);
        return this.selectOne(hT_SentakuJyouhou);
    }

    @Override
    @Deprecated
    public List<HT_SentakuJyouhou> selectAll() {
        return super.selectAll();
    }
}
