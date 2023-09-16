package yuyu.def.db.meta;

/**
 * 取込関連テーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QWT_TorikomiRelation extends GenQWT_TorikomiRelation {

    public QWT_TorikomiRelation() {
    }

    public QWT_TorikomiRelation(String pAlias) {
        super(pAlias);
    }

    public String WT_KouteiSummary(){
        return this.getAlias() + ".kouteiSummary";
    }
}
