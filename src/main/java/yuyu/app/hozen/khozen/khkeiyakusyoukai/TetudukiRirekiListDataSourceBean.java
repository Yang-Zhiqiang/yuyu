package yuyu.app.hozen.khozen.khkeiyakusyoukai;

import yuyu.def.classification.C_UmuKbn;

/**
 * 契約内容照会 - tetudukiRirekiList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TetudukiRirekiListDataSourceBean extends GenTetudukiRirekiListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String henkouSikibetuKey;

    private C_UmuKbn henkouRrkUmu;

    private C_UmuKbn shrRrkUmu;

    public TetudukiRirekiListDataSourceBean() {
    }

    public String getHenkouSikibetuKey() {
        return henkouSikibetuKey;
    }

    public void setHenkouSikibetuKey(String pHenkouSikibetuKey) {
        this.henkouSikibetuKey = pHenkouSikibetuKey;
    }

    public C_UmuKbn getHenkouRrkUmu() {
        return henkouRrkUmu;
    }

    public void setHenkouRrkUmu(C_UmuKbn pHenkouRrkUmu) {
        this.henkouRrkUmu = pHenkouRrkUmu;
    }

    public C_UmuKbn getShrRrkUmu() {
        return shrRrkUmu;
    }

    public void setShrRrkUmu(C_UmuKbn pShrRrkUmu) {
        this.shrRrkUmu = pShrRrkUmu;
    }
}
