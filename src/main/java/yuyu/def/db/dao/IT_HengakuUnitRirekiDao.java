package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_HengakuUnitRireki;
import yuyu.def.db.meta.QIT_HengakuUnitRireki;

/**
 * 変額ユニット履歴テーブル(IT_HengakuUnitRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HengakuUnitRirekiDao extends AbstractDao<IT_HengakuUnitRireki> {

    public IT_HengakuUnitRirekiDao() {
        super(IT_HengakuUnitRireki.class);
    }

    @Deprecated
    public IT_HengakuUnitRireki getHengakuUnitRireki(String pSyono,
        C_UnitFundKbn pUnitfundkbn,
        String pHenkousikibetukey){
        IT_HengakuUnitRireki iT_HengakuUnitRireki =  new IT_HengakuUnitRireki();
        iT_HengakuUnitRireki.setSyono(pSyono);
        iT_HengakuUnitRireki.setUnitfundkbn(pUnitfundkbn);
        iT_HengakuUnitRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_HengakuUnitRireki);
    }

    @Override
    @Deprecated
    public List<IT_HengakuUnitRireki> selectAll() {
        return super.selectAll();
    }

    public List<IT_HengakuUnitRireki> getHengakuUnitRirekisBySyonoUnitfundkbnCalckijyunymd(String pSyono,
        C_UnitFundKbn pUnitfundkbn, BizDate pCalckijyunymd) {


        QIT_HengakuUnitRireki qIT_HengakuUnitRireki = new QIT_HengakuUnitRireki();

        String strSql = $SELECT + qIT_HengakuUnitRireki +
            $FROM + qIT_HengakuUnitRireki.IT_HengakuUnitRireki() +
            $WHERE + qIT_HengakuUnitRireki.syono.eq(pSyono) +
            $AND + qIT_HengakuUnitRireki.unitfundkbn.eq(pUnitfundkbn) +
            $AND + qIT_HengakuUnitRireki.unitkouryokuhasseiymd.le(pCalckijyunymd) +
            $AND + qIT_HengakuUnitRireki.unitkouryokuendymd.ge(pCalckijyunymd);

        return em.createJPQL(strSql).bind(qIT_HengakuUnitRireki).getResultList();
    }
}
