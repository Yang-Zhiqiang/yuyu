package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_FileSansyoKaisu;

/**
 * ファイル参照回数テーブル(AT_FileSansyoKaisuDao) アクセス用の DAO クラスです。<br />
 */
public class AT_FileSansyoKaisuDao extends AbstractDao<AT_FileSansyoKaisu> {

    public AT_FileSansyoKaisuDao() {
        super(AT_FileSansyoKaisu.class);
    }

    @Deprecated
    public AT_FileSansyoKaisu getFileSansyoKaisu(String pUniqueId){
        AT_FileSansyoKaisu aT_FileSansyoKaisu =  new AT_FileSansyoKaisu();
        aT_FileSansyoKaisu.setUniqueId(pUniqueId);
        return this.selectOne(aT_FileSansyoKaisu);
    }

    @Override
    @Deprecated
    public List<AT_FileSansyoKaisu> selectAll() {
        return super.selectAll();
    }
}
