package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AM_HaitaSyurui;

/**
 * 排他種類マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_HaitaSyurui extends AbstractExDBTable<AM_HaitaSyurui> {

    public GenQAM_HaitaSyurui() {
        this("AM_HaitaSyurui");
    }

    public GenQAM_HaitaSyurui(String pAlias) {
        super("AM_HaitaSyurui", AM_HaitaSyurui.class, pAlias);
    }

    public String AM_HaitaSyurui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_HaitaSyurui, String> haitaSyuruiCd = new ExDBFieldString<>("haitaSyuruiCd", this);

    public final ExDBFieldString<AM_HaitaSyurui, String> haitaSyuruiNm = new ExDBFieldString<>("haitaSyuruiNm", this);

    public final ExDBFieldString<AM_HaitaSyurui, String> haitaKeyKousei = new ExDBFieldString<>("haitaKeyKousei", this);
}
