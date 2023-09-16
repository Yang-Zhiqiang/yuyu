package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.base.result.bean.FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_FileSyuruiKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.meta.QAS_FileSyurui;
import yuyu.def.db.meta.QAT_FileKengen;

/**
 * ファイル種類基幹テーブル( AS_FileSyurui ) に対するDB操作を提供する。
 */
public class AS_FileSyuruiDao extends AbstractDao<AS_FileSyurui> {

    protected AS_FileSyuruiDao() {
        super(AS_FileSyurui.class);
    }

    public AS_FileSyurui getAS_FileSyurui(C_FileSyuruiCdKbn pFileSyuruiCd) {
        AS_FileSyurui condEntity = new AS_FileSyurui();
        condEntity.setFileSyuruiCd(pFileSyuruiCd);
        return selectOne(condEntity);
    }

    public List<AS_FileSyurui> getFileSyuruiByFileSyuruiKbn(C_FileSyuruiKbn pSyuruiKbn) {

        QAS_FileSyurui qFileSyurui = new QAS_FileSyurui();


        String query =
            $SELECT + qFileSyurui +
            $FROM + qFileSyurui.AS_FileSyurui() +
            $WHERE + qFileSyurui.fileSyuruiKbn.eq(pSyuruiKbn) +
            $ORDER_BY(qFileSyurui.fileSyuruiCd.asc());


        return select(query, qFileSyurui);
    }

    public List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(
        String[] pUserRoleCd, String[] pTanmatusettisosikiRoleCd) {


        QAS_FileSyurui qAS_FileSyurui = new QAS_FileSyurui();

        QAT_FileKengen qAT_FileKengen = new QAT_FileKengen();


        String subQuerry1 = $SELECT +  qAT_FileKengen.fileSyuruiCd +
            $FROM + qAT_FileKengen.AT_FileKengen() +
            $WHERE + qAT_FileKengen.roleCd.in(pUserRoleCd) +
            $AND + qAS_FileSyurui.fileSyuruiCd.eq(qAT_FileKengen.fileSyuruiCd);


        String subQuerry2 = $SELECT + qAT_FileKengen.fileSyuruiCd +
            $FROM + qAT_FileKengen.AT_FileKengen() +
            $WHERE + qAT_FileKengen.roleCd.in(pTanmatusettisosikiRoleCd) +
            $AND + qAS_FileSyurui.fileSyuruiCd.eq(qAT_FileKengen.fileSyuruiCd);


        String querryStr = $SELECT_DISTINCT + $NEW(FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean.class,
            qAS_FileSyurui.fileSyuruiCd,
            qAS_FileSyurui.fileSyuruiNm) +
            $FROM + qAS_FileSyurui.AS_FileSyurui() +
            $WHERE + $EXISTS(subQuerry1) +
            $AND + $EXISTS(subQuerry2) +
            $ORDER_BY(qAS_FileSyurui.fileSyuruiCd.asc());

        return em.createJPQL(querryStr, FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean.class).bind(qAS_FileSyurui, qAT_FileKengen).getResultList();
    }

}