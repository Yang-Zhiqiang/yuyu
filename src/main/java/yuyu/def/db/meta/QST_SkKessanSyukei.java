package yuyu.def.db.meta;

/**
 * 新契約決算用集計元データテーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QST_SkKessanSyukei extends GenQST_SkKessanSyukei {

    public QST_SkKessanSyukei() {
    }

    public QST_SkKessanSyukei(String pAlias) {
        super(pAlias);
    }
    public String BM_KanjyouKamoku(){
        return this.getAlias() + ".kanjyouKamoku";
    }
    public String BM_TantouCd(){
        return this.getAlias() + ".tantouCd";
    }

}
