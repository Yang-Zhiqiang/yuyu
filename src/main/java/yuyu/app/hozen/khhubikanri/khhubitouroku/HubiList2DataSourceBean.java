package yuyu.app.hozen.khhubikanri.khhubitouroku;

import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全不備登録 - hubiList2 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class HubiList2DataSourceBean extends GenHubiList2DataSourceBean {

    private static final long serialVersionUID = 1L;

    private String nyuryokutantouid;

    private String syounintantouid;

    private String inputRenno3keta;

    private String disphubinaiyoucd;

    public HubiList2DataSourceBean() {
    }

    @Override
    public String getDisphubinaiyoucd() {
        return disphubinaiyoucd;
    }

    @Override
    public void setDisphubinaiyoucd(String pDisphubinaiyoucd) {
        disphubinaiyoucd = pDisphubinaiyoucd;
    }

    public String getNyuryokutantouid() {
        return nyuryokutantouid;
    }

    public void setNyuryokutantouid(String pHyuryokutantouid) {
        this.nyuryokutantouid = pHyuryokutantouid;
    }

    public String getSyounintantouid() {
        return syounintantouid;
    }

    public void setSyounintantouid(String pSyounintantouid) {
        this.syounintantouid = pSyounintantouid;
    }

    public String getInputRenno3keta() {
        return inputRenno3keta;
    }

    public void setInputRenno3keta(String pInputRenno3keta) {
        inputRenno3keta = pInputRenno3keta;
    }

    @Override
    public void setDispgenponhnkykumuchkbox(Boolean pDispgenponhnkykumuchkbox) {

        super.setDispgenponhnkykumuchkbox(pDispgenponhnkykumuchkbox);
        C_UmuKbn kbn;
        if (pDispgenponhnkykumuchkbox) {
            kbn = C_UmuKbn.ARI;
        }
        else {
            kbn = C_UmuKbn.NONE;
        }
        super.setDispgenponhnkykumu(kbn);
    }

    @Override
    public void setDispgenponhnkykumu(C_UmuKbn pDispgenponhnkykumu) {
        super.setDispgenponhnkykumu(pDispgenponhnkykumu);
        if (C_UmuKbn.ARI.eq(pDispgenponhnkykumu)) {
            super.setDispgenponhnkykumuchkbox(true);
        } else {
            super.setDispgenponhnkykumuchkbox(false);
        }
    }
}
