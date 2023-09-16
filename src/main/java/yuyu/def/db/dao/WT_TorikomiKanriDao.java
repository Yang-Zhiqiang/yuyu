package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;

import org.apache.commons.lang.ArrayUtils;

import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.id.PKWT_TorikomiKanri;
import yuyu.def.db.meta.QWT_TorikomiKanri;

/**
 * 取込管理テーブル(WT_TorikomiKanri) テーブルアクセス用の DAO クラスです。<br />
 *
 */
public class WT_TorikomiKanriDao extends AbstractDao<WT_TorikomiKanri> {

    public WT_TorikomiKanriDao() {

        super(WT_TorikomiKanri.class);
    }

    public WT_TorikomiKanri getTorikomiKanri(String pImageId) {

        return selectPk(new PKWT_TorikomiKanri(pImageId));
    }

    public List<WT_TorikomiKanri> getAllTorikomiKanri() {

        return selectAll();
    }

    public List<WT_TorikomiKanri> getTorikomiKanris(String pImageId) {

        WT_TorikomiKanri condition = new WT_TorikomiKanri();

        condition.setIwfImageId(pImageId);

        return getTorikomiKanris(condition);
    }

    public List<WT_TorikomiKanri> getTorikomiKanrisBySyoruiCd(String pTorikomiSyoruiCd) {

        WT_TorikomiKanri condition = new WT_TorikomiKanri();

        condition.setTorikomiSyoruiCd(pTorikomiSyoruiCd);

        return getTorikomiKanris(condition);
    }

    public List<WT_TorikomiKanri> getTorikomiKanrisBySyoruiCds(String[] pTorikomiSyoruiCds) {

        QWT_TorikomiKanri torikomiKanri = new QWT_TorikomiKanri("torikomiKanri");

        StringBuilder mainQuery = new StringBuilder();
        mainQuery.append($SELECT + torikomiKanri);
        mainQuery.append($FROM + torikomiKanri.WT_TorikomiKanri());


        if (null != pTorikomiSyoruiCds && !ArrayUtils.isEmpty(pTorikomiSyoruiCds)) {
            mainQuery.append($WHERE);
            mainQuery.append(torikomiKanri.torikomiSyoruiCd.in(pTorikomiSyoruiCds));
        }

        return em.createJPQL(mainQuery.toString()).bind(torikomiKanri).getResultList();
    }

    public List<WT_TorikomiKanri> getTorikomiKanrisByImageIds(String[] pImageIds) {

        QWT_TorikomiKanri torikomiKanri = new QWT_TorikomiKanri("torikomiKanri");

        StringBuilder mainQuery = new StringBuilder();
        mainQuery.append($SELECT + torikomiKanri);
        mainQuery.append($FROM + torikomiKanri.WT_TorikomiKanri());


        if (null != pImageIds && !ArrayUtils.isEmpty(pImageIds)) {
            mainQuery.append($WHERE + torikomiKanri.iwfImageId.in(pImageIds));
        }

        return em.createJPQL(mainQuery.toString()).bind(torikomiKanri).getResultList();
    }

    public List<WT_TorikomiKanri> getTorikomiKanris(WT_TorikomiKanri pWT_TorikomiKanri) {

        return new LinkedList<>(new LinkedHashSet<>(select(pWT_TorikomiKanri)));
    }
}