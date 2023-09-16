package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataRn;

/**
 * 代理店未収・失効情報連動データＦテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenMisyuSkInfoDataRn extends AbstractExDBTable<ZT_DrtenMisyuSkInfoDataRn> {

    public GenQZT_DrtenMisyuSkInfoDataRn() {
        this("ZT_DrtenMisyuSkInfoDataRn");
    }

    public GenQZT_DrtenMisyuSkInfoDataRn(String pAlias) {
        super("ZT_DrtenMisyuSkInfoDataRn", ZT_DrtenMisyuSkInfoDataRn.class, pAlias);
    }

    public String ZT_DrtenMisyuSkInfoDataRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnhnsyugknjkyksynm = new ExDBFieldString<>("zrnhnsyugknjkyksynm", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnknjhhknmei = new ExDBFieldString<>("zrnknjhhknmei", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnkykjyutikbn = new ExDBFieldString<>("zrnkykjyutikbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrntsinkihontikucd = new ExDBFieldString<>("zrntsinkihontikucd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnkanjitsinkaiadr = new ExDBFieldString<>("zrnkanjitsinkaiadr", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrntsintelno = new ExDBFieldString<>("zrntsintelno", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrndai2tsintelno = new ExDBFieldString<>("zrndai2tsintelno", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnkzhurikaebankcd = new ExDBFieldString<>("zrnkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnkzhurikaesitencd = new ExDBFieldString<>("zrnkzhurikaesitencd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnkzhurikaeyokinkbn = new ExDBFieldString<>("zrnkzhurikaeyokinkbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnkzhurikaekouzano = new ExDBFieldString<>("zrnkzhurikaekouzano", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnkzhurikaemeiginm = new ExDBFieldString<>("zrnkzhurikaemeiginm", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnyobiv6x5 = new ExDBFieldString<>("zrnyobiv6x5", this);

    public final ExDBFieldNumber<ZT_DrtenMisyuSkInfoDataRn, Long> zrn1kaip = new ExDBFieldNumber<>("zrn1kaip", this);

    public final ExDBFieldNumber<ZT_DrtenMisyuSkInfoDataRn, Long> zrnnexthurikaeyoteigk = new ExDBFieldNumber<>("zrnnexthurikaeyoteigk", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnhrkyykknmnryymd = new ExDBFieldString<>("zrnhrkyykknmnryymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnskymd = new ExDBFieldString<>("zrnskymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnjhurikstkkahikbn = new ExDBFieldString<>("zrnjhurikstkkahikbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnhukkatumoskahikbn = new ExDBFieldString<>("zrnhukkatumoskahikbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnttdkkigenymd = new ExDBFieldString<>("zrnttdkkigenymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnhukkatukanoukknmnryymd = new ExDBFieldString<>("zrnhukkatukanoukknmnryymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnkeikatukisuu3keta = new ExDBFieldString<>("zrnkeikatukisuu3keta", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnmisyuuhasseiym = new ExDBFieldString<>("zrnmisyuuhasseiym", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnmisyuujiyuu = new ExDBFieldString<>("zrnmisyuujiyuu", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnhanteiymd = new ExDBFieldString<>("zrnhanteiymd", this);

    public final ExDBFieldNumber<ZT_DrtenMisyuSkInfoDataRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_DrtenMisyuSkInfoDataRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnnexthurikaeymd = new ExDBFieldString<>("zrnnexthurikaeymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnyobiv8x3 = new ExDBFieldString<>("zrnyobiv8x3", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnikkatubaraikbn = new ExDBFieldString<>("zrnikkatubaraikbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnikkatubaraikaisuu = new ExDBFieldString<>("zrnikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataRn, String> zrnyobiv55 = new ExDBFieldString<>("zrnyobiv55", this);
}
