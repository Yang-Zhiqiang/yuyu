package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_FileHozonKikan;

/**
 * ファイル保存期間基幹テーブル(AS_FileHozonKikanDao) アクセス用の DAO クラスです。<br />
 */
public class AS_FileHozonKikanDao extends AbstractDao<AS_FileHozonKikan> {

    public AS_FileHozonKikanDao() {
        super(AS_FileHozonKikan.class);
    }

    @Deprecated
    public AS_FileHozonKikan getFileHozonKikan(C_FileSyuruiCdKbn pFileSyuruiCd){
        AS_FileHozonKikan aS_FileHozonKikan =  new AS_FileHozonKikan();
        aS_FileHozonKikan.setFileSyuruiCd(pFileSyuruiCd);
        return this.selectOne(aS_FileHozonKikan);
    }

    @Override
    @Deprecated
    public List<AS_FileHozonKikan> selectAll() {
        return super.selectAll();
    }
}
