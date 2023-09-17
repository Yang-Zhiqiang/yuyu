package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 商品属性マスタ(BM_SyouhnZokusei) デタッチャークラスです。<br />
 */
public class BM_SyouhnZokuseiDetacher {

    public static BM_SyouhnZokusei detachSyouhnZokuseitouched(BM_SyouhnZokusei pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
