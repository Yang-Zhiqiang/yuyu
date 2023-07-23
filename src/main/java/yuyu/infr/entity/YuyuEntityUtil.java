package yuyu.infr.entity;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.db.typesafe.ExDBEntity;

import org.slf4j.Logger;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Entityリストの各種操作を提供するユーティリティです。
 */
public class YuyuEntityUtil {

    @Inject
    private static final Logger logger = LoggerFactory.getLogger(YuyuEntityUtil.class);

    public static <E extends ExDBEntity<E, ?>> void entityReplace(List<E> pSrcList, List<E> pFilterList){

        traceLogging("ソースリスト", pSrcList);
        traceLogging("フィルタリスト", pFilterList);

        List<E> backupList = Lists.newArrayList(pFilterList);

        Iterables.removeIf(pFilterList, new EntityListMatchingPredicate<E>(pSrcList));

        Iterables.removeIf(pSrcList, new EntityListMatchingPredicate<E>(backupList, false));

        pSrcList.addAll(pFilterList);

        traceLogging("結果リスト", pSrcList);
    }

    private static <E extends ExDBEntity<E, ?>> void traceLogging(String logPrefix, List<E> pList){

        logger.trace("◇ " + logPrefix);

        for(E entity : pList){
            logger.trace("｜ " + entity.getPrimaryKey().toString());
        }

        logger.trace("◇ 終了");
    }
}
