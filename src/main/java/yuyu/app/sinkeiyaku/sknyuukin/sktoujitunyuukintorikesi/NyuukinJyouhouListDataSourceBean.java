package yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi;

/**
 * 当日入金取消 - ●入金情報 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class NyuukinJyouhouListDataSourceBean extends GenNyuukinJyouhouListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private Integer renno;

    private String denrenno;

    public NyuukinJyouhouListDataSourceBean() {
    }

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }
}
