package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.id.PKWT_GyoumuKey;
import yuyu.def.db.meta.QWT_GyoumuKey;

/**
 * 業務キーテーブル(WT_GyoumuKey) テーブルアクセス用の DAO クラスです。<br />
 *
 */
public class WT_GyoumuKeyDao extends AbstractDao<WT_GyoumuKey> {

    public WT_GyoumuKeyDao() {

        super(WT_GyoumuKey.class);
    }

    public WT_GyoumuKey getGyoumuKey(String pFlowId, String pGyoumuKey) {
        return selectPk(new PKWT_GyoumuKey(pFlowId, pGyoumuKey));
    }

    public List<WT_GyoumuKey> getAllGyoumuKey() {

        return selectAll();
    }

    public List<WT_GyoumuKey> getGyoumuKeys(String pGyoumuKey) {

        WT_GyoumuKey condition = new WT_GyoumuKey();

        condition.setGyoumuKey(pGyoumuKey);

        return getGyoumuKeys(condition);
    }

    public List<WT_GyoumuKey> getGyoumuKeysByTokenId(String pTokenId) {

        WT_GyoumuKey condition = new WT_GyoumuKey();

        condition.setTokenId(pTokenId);

        return getGyoumuKeys(condition);
    }

    public List<WT_GyoumuKey> getGyoumuKeysByFlowIdTokenId(String pFlowId, String pTokenId) {

        WT_GyoumuKey condition = new WT_GyoumuKey();

        condition.setTokenId(pTokenId);
        condition.setFlowId(pFlowId);

        return getGyoumuKeys(condition);
    }

    public List<WT_GyoumuKey> getGyoumuKeys(String pFlowId, String pTokenId) {

        WT_GyoumuKey condition = new WT_GyoumuKey();

        condition.setTokenId(pTokenId);
        condition.setFlowId(pFlowId);

        return getGyoumuKeys(condition);
    }

    public List<String> getGyoumuKeysDistinctGyoumuKey() {

        QWT_GyoumuKey gyoumuKey = new QWT_GyoumuKey("gyoumuKey");

        String mainQuery = $SELECT_DISTINCT + gyoumuKey.gyoumuKey
                + $FROM + gyoumuKey.WT_GyoumuKey();

        return em.createJPQL(mainQuery).bind(gyoumuKey).getResultList();
    }

    private List<WT_GyoumuKey> getGyoumuKeys(WT_GyoumuKey pWT_GyoumuKey) {

        return select(pWT_GyoumuKey);
    }
}