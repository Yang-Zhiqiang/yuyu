package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AT_FileKengen;

/**
 * ファイル権限テーブル(AT_FileKengenDao) アクセス用の DAO クラスです。<br />
 */
public class AT_FileKengenDao extends AbstractDao<AT_FileKengen> {

    public AT_FileKengenDao() {
        super(AT_FileKengen.class);
    }

    @Deprecated
    public AT_FileKengen getFileKengen(String pRoleCd,
        C_FileSyuruiCdKbn pFileSyuruiCd){
        AT_FileKengen aT_FileKengen =  new AT_FileKengen();
        aT_FileKengen.setRoleCd(pRoleCd);
        aT_FileKengen.setFileSyuruiCd(pFileSyuruiCd);
        return this.selectOne(aT_FileKengen);
    }

    @Override
    @Deprecated
    public List<AT_FileKengen> selectAll() {
        return super.selectAll();
    }
}
