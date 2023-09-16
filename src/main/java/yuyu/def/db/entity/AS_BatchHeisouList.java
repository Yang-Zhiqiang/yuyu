package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAS_BatchHeisouList;
import yuyu.def.db.mapping.GenAS_BatchHeisouList;
import yuyu.def.db.meta.GenQAS_BatchHeisouList;
import yuyu.def.db.meta.QAS_BatchHeisouList;

/**
 * バッチ並走リスト基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_BatchHeisouList} の JavaDoc を参照してください。
 * @see     GenAS_BatchHeisouList
 * @see     PKAS_BatchHeisouList
 * @see     QAS_BatchHeisouList
 * @see     GenQAS_BatchHeisouList
 */
@Entity
public class AS_BatchHeisouList extends GenAS_BatchHeisouList {

    private static final long serialVersionUID = 1L;

    public AS_BatchHeisouList() {
    }

    public AS_BatchHeisouList(String pSelfKinouId, String pTargetKinouId) {
        super(pSelfKinouId, pTargetKinouId);
    }

}
