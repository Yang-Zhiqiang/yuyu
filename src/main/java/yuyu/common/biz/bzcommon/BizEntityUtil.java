package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.util.ObjectUtil;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.entity.EntityListMatchingPredicate;

import com.google.common.collect.Iterables;


/**
 * エンティティユーティリティクラス
 */
public class BizEntityUtil {

    public static <E extends ExDBEntity<E, ?>> void merge(List<E> pTargetList, List<E> pSrcList){

        boolean existFlg;

        if (pTargetList != null && pSrcList != null ) {

            List<E> insertList = new ArrayList<E>();

            for (E srcEntity : pSrcList) {

                existFlg = false;

                Object oPK = srcEntity.getPrimaryKey();

                for (E targetEntity : pTargetList) {

                    if (targetEntity.getPrimaryKey().equals(oPK)) {
                        BeanUtil.copyProperties(targetEntity, srcEntity);
                        existFlg = true;
                        break;
                    }
                }

                if (!existFlg) {

                    insertList.add(srcEntity);
                }
            }

            pTargetList.addAll(insertList);
        }
    }

    public static <E extends ExDBEntity<E, ?>> void exchange(List<E> pTargetList, List<E> pSrcList){

        if (pTargetList != null && pSrcList != null) {

            if (pSrcList.isEmpty()) {

                pTargetList.clear();

            } else {

                Iterables.removeIf(pTargetList, new EntityListMatchingPredicate<E>(pSrcList, false));

                merge(pTargetList, pSrcList);
            }
        }
    }

    public static <T extends ExDBEntity<T, ?>> T copyEntity(T entity){
        return ObjectUtil.deepCopy(entity);
    }

}
