package yuyu.def.db.meta;

/**
 * 取込管理テーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QWT_TorikomiKanri extends GenQWT_TorikomiKanri {

    public QWT_TorikomiKanri() {
    }

    public QWT_TorikomiKanri(String pAlias) {
        super(pAlias);
    }

    public String WT_TorikomiRelation(){
        return this.getAlias() + ".torikomiRelation";
    }

    //    public String WT_Page(){
    //        return this.getAlias() + ".pages";
    //    }


}
