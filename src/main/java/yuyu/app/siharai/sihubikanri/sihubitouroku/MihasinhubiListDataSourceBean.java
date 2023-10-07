package yuyu.app.siharai.sihubikanri.sihubitouroku;

/**
 * 保険金給付金不備登録 - ●未発信不備一覧 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class MihasinhubiListDataSourceBean extends GenMihasinhubiListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String dispHubiTourokuTantouId;

    private String dispHubiSyouninnTantouId;

    private String dispHubiTourokuTantouId2;

    private String dispNyuryokuTantouNm2;

    public MihasinhubiListDataSourceBean() {
    }

    public String getDispHubiTourokuTantouId() {
        return dispHubiTourokuTantouId;
    }

    public void setDispHubiTourokuTantouId(String pDispHubiTourokuTantouId) {
        this.dispHubiTourokuTantouId = pDispHubiTourokuTantouId;
    }

    public String getDispHubiSyouninnTantouId() {
        return dispHubiSyouninnTantouId;
    }

    public void setDispHubiSyouninnTantouId(String pDispHubiSyouninnTantouId) {
        this.dispHubiSyouninnTantouId = pDispHubiSyouninnTantouId;
    }

    public String getDispHubiTourokuTantouId2() {
        return dispHubiTourokuTantouId2;
    }

    public void setDispHubiTourokuTantouId2(String pDispHubiTourokuTantouId2) {
        this.dispHubiTourokuTantouId2 = pDispHubiTourokuTantouId2;
    }

    public String getDispnyuryokutantounm2() {
        return dispNyuryokuTantouNm2;
    }

    public void setDispnyuryokutantounm2(String pDispNyuryokuTantouNm2) {
        this.dispNyuryokuTantouNm2 = pDispNyuryokuTantouNm2;
    }
}
