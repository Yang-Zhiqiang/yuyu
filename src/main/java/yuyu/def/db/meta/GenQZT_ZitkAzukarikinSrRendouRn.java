package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouRn;

/**
 * 税適預り金数理連動Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_ZitkAzukarikinSrRendouRn extends AbstractExDBTable<ZT_ZitkAzukarikinSrRendouRn> {

    public GenQZT_ZitkAzukarikinSrRendouRn() {
        this("ZT_ZitkAzukarikinSrRendouRn");
    }

    public GenQZT_ZitkAzukarikinSrRendouRn(String pAlias) {
        super("ZT_ZitkAzukarikinSrRendouRn", ZT_ZitkAzukarikinSrRendouRn.class, pAlias);
    }

    public String ZT_ZitkAzukarikinSrRendouRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouRn, String> zrnjynbknkbn = new ExDBFieldString<>("zrnjynbknkbn", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouRn, String> zrnkbnkeiriyousegmentcd = new ExDBFieldString<>("zrnkbnkeiriyousegmentcd", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouRn, Long> zrntndmatuzndk = new ExDBFieldNumber<>("zrntndmatuzndk", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouRn, Long> zrnyoteirisoku = new ExDBFieldNumber<>("zrnyoteirisoku", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouRn, String> zrnkeiyakunendo = new ExDBFieldString<>("zrnkeiyakunendo", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouRn, String> zrnsuuriyouyobin4 = new ExDBFieldString<>("zrnsuuriyouyobin4", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouRn, String> zrnsuuriyouyobin8 = new ExDBFieldString<>("zrnsuuriyouyobin8", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouRn, String> zrnyobiv93 = new ExDBFieldString<>("zrnyobiv93", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouRn, Long> zrntndmatuzndkgaika = new ExDBFieldNumber<>("zrntndmatuzndkgaika", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);
}
