package yuyu.infr.entity;

import java.util.List;
import java.util.Set;

import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBPrimaryKey;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

/**
 * 同一のエンティティ型を持つ２つのリストを比較し、一致、または不一致の要素を抽出します。
 */
public class EntityListMatchingPredicate<E extends ExDBEntity<E, ?>> implements Predicate<E> {

    private Set<ExDBPrimaryKey<E, ?>> compSet = Sets.newHashSet();

    private boolean resultFlg = true;

    public EntityListMatchingPredicate(List<E> pCompList){

        this(pCompList, true);
    }

    public EntityListMatchingPredicate(List<E> pCompList, boolean pFlg){

        for(E entity : pCompList){
            compSet.add(entity.getPrimaryKey());
            resultFlg = pFlg;
        }
    }

    @Override
    public boolean apply(E entity) {

        return compSet.contains(entity.getPrimaryKey()) == resultFlg;
    }
}
