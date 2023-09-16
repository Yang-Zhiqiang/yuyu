package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBT_KinouHukaInfo;


/**
 * 機能付加情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_KinouHukaInfo} の JavaDoc を参照してください。<br />
 * @see     GenBT_KinouHukaInfo<br />
 * @see     PKBT_KinouHukaInfo<br />
 * @see     QBT_KinouHukaInfo<br />
 * @see     GenQBT_KinouHukaInfo<br />
 */
@Entity
public class BT_KinouHukaInfo extends GenBT_KinouHukaInfo {

    private static final long serialVersionUID = 1L;

    public BT_KinouHukaInfo() {
    }

    public BT_KinouHukaInfo(String pKinouId) {
        super(pKinouId);
    }



}

