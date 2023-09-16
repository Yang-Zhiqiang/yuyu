package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_UserKengenHaneiSskInfo;
import yuyu.def.db.mapping.GenBT_UserKengenHaneiSskInfo;
import yuyu.def.db.meta.GenQBT_UserKengenHaneiSskInfo;
import yuyu.def.db.meta.QBT_UserKengenHaneiSskInfo;

/**
 * ユーザー権限自動反映組織情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_UserKengenHaneiSskInfo} の JavaDoc を参照してください。
 * @see     GenBT_UserKengenHaneiSskInfo
 * @see     PKBT_UserKengenHaneiSskInfo
 * @see     QBT_UserKengenHaneiSskInfo
 * @see     GenQBT_UserKengenHaneiSskInfo
 */
@Entity
public class BT_UserKengenHaneiSskInfo extends GenBT_UserKengenHaneiSskInfo {

    private static final long serialVersionUID = 1L;

    public BT_UserKengenHaneiSskInfo() {
    }

    public BT_UserKengenHaneiSskInfo(String pSosikicdkami3) {
        super(pSosikicdkami3);
    }

}
