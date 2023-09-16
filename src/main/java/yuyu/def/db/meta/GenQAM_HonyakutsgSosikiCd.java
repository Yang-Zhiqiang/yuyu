package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AM_HonyakutsgSosikiCd;

/**
 * 翻訳対象外組織コードマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_HonyakutsgSosikiCd extends AbstractExDBTable<AM_HonyakutsgSosikiCd> {

    public GenQAM_HonyakutsgSosikiCd() {
        this("AM_HonyakutsgSosikiCd");
    }

    public GenQAM_HonyakutsgSosikiCd(String pAlias) {
        super("AM_HonyakutsgSosikiCd", AM_HonyakutsgSosikiCd.class, pAlias);
    }

    public String AM_HonyakutsgSosikiCd() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_HonyakutsgSosikiCd, String> sosikicd = new ExDBFieldString<>("sosikicd", this);
}
