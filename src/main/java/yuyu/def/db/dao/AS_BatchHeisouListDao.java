package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AS_BatchHeisouList;

/**
 * バッチ並走リスト基幹テーブル(AS_BatchHeisouList) テーブルアクセス用の DAO クラスです。
 *
 */
public class AS_BatchHeisouListDao extends AbstractDao<AS_BatchHeisouList> {

    public AS_BatchHeisouListDao() {
        super(AS_BatchHeisouList.class);
    }

    public List<AS_BatchHeisouList> getBatchHeisouListBySelfKinouId(String pSelfKinouId) {
        AS_BatchHeisouList batchHeisouList = new AS_BatchHeisouList();
        batchHeisouList.setSelfKinouId(pSelfKinouId);

        return select(batchHeisouList);
    }

    public AS_BatchHeisouList getBatchHeisouListBySelfKinouIdTargetKinouId(
        String pSelfKinouId,
        String pTargetKinouId){
        return selectOne(new AS_BatchHeisouList(pSelfKinouId, pTargetKinouId));
    }
}
