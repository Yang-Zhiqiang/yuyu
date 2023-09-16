package yuyu.def.db.meta;

/**
 * 新契約追込調整伝票データテーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QST_SkOikmTyouseiDenpyou extends GenQST_SkOikmTyouseiDenpyou {

    public QST_SkOikmTyouseiDenpyou() {
    }

    public QST_SkOikmTyouseiDenpyou(String pAlias) {
        super(pAlias);
    }

    public String BM_KanjyouKamoku(){
        return this.getAlias() + ".kanjyouKamoku";
    }
    public String BM_Segment(){
        return this.getAlias() + ".segment";
    }
    public String BM_TantouCd(){
        return this.getAlias() + ".tantouCd";
    }
}
