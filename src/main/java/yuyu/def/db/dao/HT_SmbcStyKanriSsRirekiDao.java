package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Kanryouflg;
import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.def.db.meta.QHT_SmbcStyKanriSsRireki;

/**
 * ＳＭＢＣ進捗管理作成履歴テーブル(HT_SmbcStyKanriSsRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SmbcStyKanriSsRirekiDao extends AbstractDao<HT_SmbcStyKanriSsRireki> {

    public HT_SmbcStyKanriSsRirekiDao() {
        super(HT_SmbcStyKanriSsRireki.class);
    }

    public HT_SmbcStyKanriSsRireki getSmbcStyKanriSsRireki(String pSyono){
        HT_SmbcStyKanriSsRireki hT_SmbcStyKanriSsRireki =  new HT_SmbcStyKanriSsRireki();
        hT_SmbcStyKanriSsRireki.setSyono(pSyono);
        return this.selectOne(hT_SmbcStyKanriSsRireki);
    }

    public HT_SmbcStyKanriSsRireki getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime(String pSyono, String pSyrctrltblkostime) {


        QHT_SmbcStyKanriSsRireki qHT_SmbcStyKanriSsRireki = new QHT_SmbcStyKanriSsRireki();

        String querySql = $SELECT + qHT_SmbcStyKanriSsRireki +
                $FROM + qHT_SmbcStyKanriSsRireki.HT_SmbcStyKanriSsRireki() +
                $WHERE + qHT_SmbcStyKanriSsRireki.syono.eq(pSyono) +
                $AND + qHT_SmbcStyKanriSsRireki.syrctrltblkostime.lt(pSyrctrltblkostime) +
                $AND + qHT_SmbcStyKanriSsRireki.renkanryoflg.ne(Integer.valueOf(C_Kanryouflg.KANRYOU.getValue()));

        return em.createJPQL(querySql).bind(qHT_SmbcStyKanriSsRireki).getSingleResult();
    }

    public List<HT_SmbcStyKanriSsRireki> getSmbcStyKanriSsRirekisByMosno(String pMosno) {
        HT_SmbcStyKanriSsRireki hT_SmbcStyKanriSsRireki =  new HT_SmbcStyKanriSsRireki();
        hT_SmbcStyKanriSsRireki.setMosno(pMosno);
        return this.select(hT_SmbcStyKanriSsRireki);
    }
}
