package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_TRGinkouTouhaigou;

/**
 * 銀行統廃合ＴＲテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_TRGinkouTouhaigou extends AbstractExDBTable<IT_TRGinkouTouhaigou> {

    public GenQIT_TRGinkouTouhaigou() {
        this("IT_TRGinkouTouhaigou");
    }

    public GenQIT_TRGinkouTouhaigou(String pAlias) {
        super("IT_TRGinkouTouhaigou", IT_TRGinkouTouhaigou.class, pAlias);
    }

    public String IT_TRGinkouTouhaigou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_TRGinkouTouhaigou, String> bfrikkatuseibibankcd = new ExDBFieldString<>("bfrikkatuseibibankcd", this);

    public final ExDBFieldString<IT_TRGinkouTouhaigou, String> bfrikkatuseibisitencd = new ExDBFieldString<>("bfrikkatuseibisitencd", this);

    public final ExDBFieldString<IT_TRGinkouTouhaigou, String> newikkatuseibibankcd = new ExDBFieldString<>("newikkatuseibibankcd", this);

    public final ExDBFieldString<IT_TRGinkouTouhaigou, String> newikkatuseibisitencd = new ExDBFieldString<>("newikkatuseibisitencd", this);
}
