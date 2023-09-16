package yuyu.def.db.meta;

/**
 * 請求基本テーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QJT_SkKihon extends GenQJT_SkKihon {

    public QJT_SkKihon() {
    }

    public QJT_SkKihon(String pAlias) {
        super(pAlias);
    }

    public String JT_TtdkRireki(){
        return this.getAlias() + ".ttdkRirekis";
    }

    public String JT_Sk(){
        return this.getAlias() + ".sks";
    }

}
