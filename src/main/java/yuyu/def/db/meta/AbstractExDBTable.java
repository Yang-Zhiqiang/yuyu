package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.db.typesafe.ExDBTable;

/**
 * DBテーブルの固定項目メタデータを表す抽象親クラスです。
 * @param <E> エンティティーの型
 */
public abstract class AbstractExDBTable<E extends ExDBEntity<E, ?>> extends ExDBTable<E> {

    public AbstractExDBTable(String pTable, Class<E> pEntityClass) {
        super(pTable, pEntityClass);
    }

    public AbstractExDBTable(String pTable, Class<E> pEntityClass, String pAlias){
        super(pTable, pEntityClass, pAlias);
    }

    public final ExDBFieldString<E, String> kousinsyaId = new ExDBFieldString<E, String>("kousinsyaId", this);

    public final ExDBFieldString<E, String> kousinTime  = new ExDBFieldString<E, String>("kousinTime", this);

    public final ExDBFieldString<E, String> kousinKinou = new ExDBFieldString<E, String>("kousinKinou", this);

    public final ExDBFieldString<E, Long> version     = new ExDBFieldString<E, Long>("version", this);
}
