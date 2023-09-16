package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.db.meta.QAT_FileHozonInfo;
import yuyu.def.db.meta.QAT_FileSansyoKaisu;

/**
 * ファイル保存情報テーブル(AT_FileHozonInfo) テーブルアクセス用の DAO クラスです。
 *
 */
public class AT_FileHozonInfoExDao extends AbstractDao<AT_FileHozonInfo> {

    protected AT_FileHozonInfoExDao() {
        super(AT_FileHozonInfo.class);
    }

    public List<AT_FileHozonInfo> getFileHozonInfosByFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {


        QAT_FileHozonInfo qAT_FileHozonInfo = new QAT_FileHozonInfo("qAT_FileHozonInfo");


        QAT_FileSansyoKaisu qAT_FileSansyoKaisu = new QAT_FileSansyoKaisu("qAT_FileSansyoKaisu");


        String queryStr = $SELECT + qAT_FileHozonInfo +
            $FROM + qAT_FileHozonInfo.AT_FileHozonInfo() +
            $LEFT_OUTER_JOIN + qAT_FileHozonInfo.AT_FileSansyoKaisu() +
            $AS + qAT_FileSansyoKaisu +
            $WHERE + qAT_FileHozonInfo.fileSyuruiCd.eq(pFileSyuruiCd);

        return em.createJPQL(queryStr).bind(qAT_FileHozonInfo, qAT_FileSansyoKaisu).getResultList();

    }
}
