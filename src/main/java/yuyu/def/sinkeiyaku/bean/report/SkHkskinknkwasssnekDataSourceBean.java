package yuyu.def.sinkeiyaku.bean.report;

/**
 * （新契約）複数回入金為替差損益明細リスト帳票DSBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SkHkskinknkwasssnekDataSourceBean extends GenSkHkskinknkwasssnekDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String hnknTitleHyoujiFlg;

    public String getHnknTitleHyoujiFlg() {
        return hnknTitleHyoujiFlg;
    }

    public void setHnknTitleHyoujiFlg(String pHnknTitleHyoujiFlg) {
        hnknTitleHyoujiFlg = pHnknTitleHyoujiFlg;
    }

    private Integer over10LineKaipageFlg;

    public Integer getOver10LineKaipageFlg() {
        return over10LineKaipageFlg;
    }

    public void setOver10LineKaipageFlg(Integer pOver10LineKaipageFlg) {
        over10LineKaipageFlg = pOver10LineKaipageFlg;
    }

    private String nyknGukiTitle;

    public String getNyknGukiTitle() {
        return nyknGukiTitle;
    }

    public void setNyknGukiTitle(String pNyknGukiTitle) {
        nyknGukiTitle = pNyknGukiTitle;
    }

    public SkHkskinknkwasssnekDataSourceBean() {
    }

}
