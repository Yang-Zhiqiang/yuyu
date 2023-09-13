package yuyu.def.hozen.detacher;

import yuyu.def.db.entity.IT_AnsyuKihon;

/**
 * 案内収納基本テーブルテーブル(IT_AnsyuKihon) デタッチャークラスです。<br />
 */
public class IT_AnsyuKihonDetacher {

    public static IT_AnsyuKihon detachZennoustouched(IT_AnsyuKihon pEntity) {

        if (pEntity != null) {

            pEntity.getZennous().size();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }


}
