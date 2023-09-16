package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouTy;

/**
 * 税適預り金数理連動Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_ZitkAzukarikinSrRendouTy extends AbstractExDBTable<ZT_ZitkAzukarikinSrRendouTy> {

    public GenQZT_ZitkAzukarikinSrRendouTy() {
        this("ZT_ZitkAzukarikinSrRendouTy");
    }

    public GenQZT_ZitkAzukarikinSrRendouTy(String pAlias) {
        super("ZT_ZitkAzukarikinSrRendouTy", ZT_ZitkAzukarikinSrRendouTy.class, pAlias);
    }

    public String ZT_ZitkAzukarikinSrRendouTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouTy, String> ztyjynbknkbn = new ExDBFieldString<>("ztyjynbknkbn", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouTy, String> ztykbnkeiriyousegmentcd = new ExDBFieldString<>("ztykbnkeiriyousegmentcd", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouTy, Long> ztytndmatuzndk = new ExDBFieldNumber<>("ztytndmatuzndk", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouTy, Long> ztyyoteirisoku = new ExDBFieldNumber<>("ztyyoteirisoku", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouTy, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouTy, String> ztysuuriyouyobin4 = new ExDBFieldString<>("ztysuuriyouyobin4", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouTy, String> ztysuuriyouyobin8 = new ExDBFieldString<>("ztysuuriyouyobin8", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouTy, String> ztyyobiv93 = new ExDBFieldString<>("ztyyobiv93", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldNumber<ZT_ZitkAzukarikinSrRendouTy, Long> ztytndmatuzndkgaika = new ExDBFieldNumber<>("ztytndmatuzndkgaika", this);

    public final ExDBFieldString<ZT_ZitkAzukarikinSrRendouTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);
}
