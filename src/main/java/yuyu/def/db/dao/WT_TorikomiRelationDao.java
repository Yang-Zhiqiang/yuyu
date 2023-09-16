package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;

import org.apache.commons.lang.ArrayUtils;

import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.db.id.PKWT_TorikomiRelation;
import yuyu.def.db.meta.QWT_TorikomiRelation;

/**
 * 取込関連テーブル(WT_TorikomiRelation) テーブルアクセス用の DAO クラスです。<br />
 *
 */
public class WT_TorikomiRelationDao extends AbstractDao<WT_TorikomiRelation> {

    public WT_TorikomiRelationDao() {

        super(WT_TorikomiRelation.class);
    }

    public WT_TorikomiRelation getTorikomiRelation(String pImageId, String pGyoumuKey) {

        return selectPk(new PKWT_TorikomiRelation(pGyoumuKey, pImageId));
    }

    public List<WT_TorikomiRelation> getAllTorikomiRelation() {

        return selectAll();
    }

    public List<WT_TorikomiRelation> getTorikomiRelations(String pGyoumuKey) {

        WT_TorikomiRelation condition = new WT_TorikomiRelation();

        condition.setGyoumuKey(pGyoumuKey);

        return getTorikomiRelation(condition);
    }

    public List<WT_TorikomiRelation> getTorikomiRelationsByImageId(String pImageId) {

        WT_TorikomiRelation condition = new WT_TorikomiRelation();

        condition.setIwfImageId(pImageId);

        return getTorikomiRelation(condition);
    }

    public List<WT_TorikomiRelation> getTorikomiRelations(String[] pImageIds) {

        QWT_TorikomiRelation torikomiRelation = new QWT_TorikomiRelation("torikomiRelation");

        StringBuilder mainQuery = new StringBuilder();
        mainQuery.append($SELECT + torikomiRelation);
        mainQuery.append($FROM + torikomiRelation.WT_TorikomiRelation());


        if (null != pImageIds && !ArrayUtils.isEmpty(pImageIds)) {
            mainQuery.append($WHERE + torikomiRelation.iwfImageId.in(pImageIds));
        }

        return em.createJPQL(mainQuery.toString()).bind(torikomiRelation).getResultList();
    }

    private List<WT_TorikomiRelation> getTorikomiRelation(WT_TorikomiRelation pWT_TorikomiRelation) {

        return new LinkedList<>(new LinkedHashSet<>(select(pWT_TorikomiRelation)));
    }
}