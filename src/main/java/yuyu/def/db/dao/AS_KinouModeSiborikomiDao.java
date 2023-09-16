package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.def.db.meta.QAS_KinouModeSiborikomi;

/**
 * 機能モード絞込み DAO クラス<br/>
 * 機能モード絞込み基幹TBLのDB操作を行う。
 */
public class AS_KinouModeSiborikomiDao extends AbstractDao<AS_KinouModeSiborikomi> {

    protected AS_KinouModeSiborikomiDao() {
        super(AS_KinouModeSiborikomi.class);
    }

    public AS_KinouModeSiborikomi getAS_KinouModeSiborikomi(
        String kinouId, String kinouModeId, String siborikomiId) {

        AS_KinouModeSiborikomi condEntity = new AS_KinouModeSiborikomi();
        condEntity.setKinouId(kinouId);
        condEntity.setKinouModeId(kinouModeId);
        condEntity.setSiborikomiId(siborikomiId);

        return selectOne(condEntity);
    }

    public List<AS_KinouModeSiborikomi> getKinouModeSiborikomi(
        String pKinouId, String pKinouModeId) {


        QAS_KinouModeSiborikomi qSiborikomi = new QAS_KinouModeSiborikomi();


        StringBuilder sbWhere = new StringBuilder();


        sbWhere.append($SELECT_DISTINCT);
        sbWhere.append(qSiborikomi);
        sbWhere.append($FROM);
        sbWhere.append(qSiborikomi.AS_KinouModeSiborikomi());


        sbWhere.append($WHERE);

        sbWhere.append(qSiborikomi.kinouId.eq(pKinouId));
        sbWhere.append($AND);


        sbWhere.append(qSiborikomi.kinouModeId.eq(pKinouModeId));


        sbWhere.append($ORDER_BY(qSiborikomi.siborikomiId.asc()));

        return select(sbWhere.toString(), qSiborikomi);
    }

}