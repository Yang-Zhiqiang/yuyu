package yuyu.app.base.system.kadoutimetouroku;

import jp.co.slcs.swak.validation.constraints.TimeHM;
import yuyu.def.db.entity.AT_KadouTime;

/**
 * 稼働時間登録 - ●営業日 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class EigyoubiKadouTimeInfoDataSourceBean extends GenEigyoubiKadouTimeInfoDataSourceBean implements KadouTimeInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    public EigyoubiKadouTimeInfoDataSourceBean() {
    }

    private String kadouTimeFrom1;

    @Override
    public String getKadouTimeFrom1() {
        return kadouTimeFrom1;
    }

    public void setKadouTimeFrom1(String pKadouTimeFrom1) {
        kadouTimeFrom1 = pKadouTimeFrom1;
    }

    private String kadouTimeTo1;

    @Override
    public String getKadouTimeTo1() {
        return kadouTimeTo1;
    }

    public void setKadouTimeTo1(String pKadouTimeTo1) {
        kadouTimeTo1 = pKadouTimeTo1;
    }

    private String kadouTimeFrom2;

    @Override
    public String getKadouTimeFrom2() {
        return kadouTimeFrom2;
    }

    public void setKadouTimeFrom2(String pKadouTimeFrom2) {
        kadouTimeFrom2 = pKadouTimeFrom2;
    }

    private String kadouTimeTo2;

    @Override
    public String getKadouTimeTo2() {
        return kadouTimeTo2;
    }

    public void setKadouTimeTo2(String pKadouTimeTo2) {
        kadouTimeTo2 = pKadouTimeTo2;
    }

    @TimeHM
    private String kadouTimeFrom3;

    @Override
    public String getKadouTimeFrom3() {
        return kadouTimeFrom3;
    }

    public void setKadouTimeFrom3(String pKadouTimeFrom3) {
        kadouTimeFrom3 = pKadouTimeFrom3;
    }

    private String kadouTimeTo3;

    @Override
    public String getKadouTimeTo3() {
        return kadouTimeTo3;
    }

    public void setKadouTimeTo3(String pKadouTimeTo3) {
        kadouTimeTo3 = pKadouTimeTo3;
    }

    private String kadouTimeFrom4;

    @Override
    public String getKadouTimeFrom4() {
        return kadouTimeFrom4;
    }

    public void setKadouTimeFrom4(String pKadouTimeFrom4) {
        kadouTimeFrom4 = pKadouTimeFrom4;
    }

    private String kadouTimeTo4;

    @Override
    public String getKadouTimeTo4() {
        return kadouTimeTo4;
    }

    public void setKadouTimeTo4(String pKadouTimeTo4) {
        kadouTimeTo4 = pKadouTimeTo4;
    }

    private String kadouTimeFrom5;

    @Override
    public String getKadouTimeFrom5() {
        return kadouTimeFrom5;
    }

    public void setKadouTimeFrom5(String pKadouTimeFrom5) {
        kadouTimeFrom5 = pKadouTimeFrom5;
    }

    private String kadouTimeTo5;

    @Override
    public String getKadouTimeTo5() {
        return kadouTimeTo5;
    }

    public void setKadouTimeTo5(String pKadouTimeTo5) {
        kadouTimeTo5 = pKadouTimeTo5;
    }

    @Override
    public void setKadouTime(AT_KadouTime pAt_KadouTime, int pIdx){
        switch (pIdx){
            case 1 : setKadouTimeFrom1(pAt_KadouTime.getKadouTimeFrom1()); setKadouTimeTo1(pAt_KadouTime.getKadouTimeTo1()); break;
            case 2 : setKadouTimeFrom2(pAt_KadouTime.getKadouTimeFrom2()); setKadouTimeTo2(pAt_KadouTime.getKadouTimeTo2()); break;
            case 3 : setKadouTimeFrom3(pAt_KadouTime.getKadouTimeFrom3()); setKadouTimeTo3(pAt_KadouTime.getKadouTimeTo3()); break;
            case 4 : setKadouTimeFrom4(pAt_KadouTime.getKadouTimeFrom4()); setKadouTimeTo4(pAt_KadouTime.getKadouTimeTo4()); break;
            case 5 : setKadouTimeFrom5(pAt_KadouTime.getKadouTimeFrom5()); setKadouTimeTo5(pAt_KadouTime.getKadouTimeTo5()); break;
            default :
        }
    }
}
