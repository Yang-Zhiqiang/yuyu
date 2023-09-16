package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SisuuRendouRn;

/**
 * 指数連動Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SisuuRendouRn extends AbstractExDBTable<ZT_SisuuRendouRn> {

    public GenQZT_SisuuRendouRn() {
        this("ZT_SisuuRendouRn");
    }

    public GenQZT_SisuuRendouRn(String pAlias) {
        super("ZT_SisuuRendouRn", ZT_SisuuRendouRn.class, pAlias);
    }

    public String ZT_SisuuRendouRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SisuuRendouRn, String> zrntorikomiyousisuukbn = new ExDBFieldString<>("zrntorikomiyousisuukbn", this);

    public final ExDBFieldString<ZT_SisuuRendouRn, String> zrnsisuukouhyouymd = new ExDBFieldString<>("zrnsisuukouhyouymd", this);

    public final ExDBFieldNumber<ZT_SisuuRendouRn, Double> zrntorikomiyousisuu = new ExDBFieldNumber<>("zrntorikomiyousisuu", this);

    public final ExDBFieldString<ZT_SisuuRendouRn, String> zrnsisuucalckijyunymd = new ExDBFieldString<>("zrnsisuucalckijyunymd", this);

    public final ExDBFieldNumber<ZT_SisuuRendouRn, Double> zrnyobin11x40 = new ExDBFieldNumber<>("zrnyobin11x40", this);

    public final ExDBFieldString<ZT_SisuuRendouRn, String> zrnyobiv71 = new ExDBFieldString<>("zrnyobiv71", this);
}
