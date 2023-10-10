package yuyu.app.base.system.tokuteibikadoutimetouroku;

import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;

/**
 * 特定日稼働時間登録 - tokuteibiKadouTimeSelectList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TokuteibiKadouTimeSelectListDataSourceBean extends GenTokuteibiKadouTimeSelectListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public TokuteibiKadouTimeSelectListDataSourceBean() {
    }

    private C_KadouTimeSiteiKbn kadouTimeSiteiKbn;

    public C_KadouTimeSiteiKbn getKadouTimeSiteiKbn() {
        return kadouTimeSiteiKbn;
    }

    public void setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn pKadouTimeSiteiKbn) {
        kadouTimeSiteiKbn = pKadouTimeSiteiKbn;
    }

    private String kadouTimeFrom1;

    public String getKadouTimeFrom1() {
        return kadouTimeFrom1;
    }

    public void setKadouTimeFrom1(String pKadouTimeFrom1) {
        kadouTimeFrom1 = pKadouTimeFrom1;
    }

    private String kadouTimeTo1;

    public String getKadouTimeTo1() {
        return kadouTimeTo1;
    }

    public void setKadouTimeTo1(String pKadouTimeTo1) {
        kadouTimeTo1 = pKadouTimeTo1;
    }

    private String kadouTimeFrom2;

    public String getKadouTimeFrom2() {
        return kadouTimeFrom2;
    }

    public void setKadouTimeFrom2(String pKadouTimeFrom2) {
        kadouTimeFrom2 = pKadouTimeFrom2;
    }

    private String kadouTimeTo2;

    public String getKadouTimeTo2() {
        return kadouTimeTo2;
    }

    public void setKadouTimeTo2(String pKadouTimeTo2) {
        kadouTimeTo2 = pKadouTimeTo2;
    }

    private String kadouTimeFrom3;

    public String getKadouTimeFrom3() {
        return kadouTimeFrom3;
    }

    public void setKadouTimeFrom3(String pKadouTimeFrom3) {
        kadouTimeFrom3 = pKadouTimeFrom3;
    }

    private String kadouTimeTo3;

    public String getKadouTimeTo3() {
        return kadouTimeTo3;
    }

    public void setKadouTimeTo3(String pKadouTimeTo3) {
        kadouTimeTo3 = pKadouTimeTo3;
    }

    private String kadouTimeFrom4;

    public String getKadouTimeFrom4() {
        return kadouTimeFrom4;
    }

    public void setKadouTimeFrom4(String pKadouTimeFrom4) {
        kadouTimeFrom4 = pKadouTimeFrom4;
    }

    private String kadouTimeTo4;

    public String getKadouTimeTo4() {
        return kadouTimeTo4;
    }

    public void setKadouTimeTo4(String pKadouTimeTo4) {
        kadouTimeTo4 = pKadouTimeTo4;
    }

    private String kadouTimeFrom5;

    public String getKadouTimeFrom5() {
        return kadouTimeFrom5;
    }

    public void setKadouTimeFrom5(String pKadouTimeFrom5) {
        kadouTimeFrom5 = pKadouTimeFrom5;
    }

    private String kadouTimeTo5;

    public String getKadouTimeTo5() {
        return kadouTimeTo5;
    }

    public void setKadouTimeTo5(String pKadouTimeTo5) {
        kadouTimeTo5 = pKadouTimeTo5;
    }

    void setKadouTime(AT_TokuteibiKadouTime pKadouTime,int pIdx){

        switch(pIdx){
            case 1: setKadouTimeFrom1(pKadouTime.getKadouTimeFrom1()); setKadouTimeTo1(pKadouTime.getKadouTimeTo1()); break;
            case 2: setKadouTimeFrom2(pKadouTime.getKadouTimeFrom2()); setKadouTimeTo2(pKadouTime.getKadouTimeTo2()); break;
            case 3: setKadouTimeFrom3(pKadouTime.getKadouTimeFrom3()); setKadouTimeTo3(pKadouTime.getKadouTimeTo3()); break;
            case 4: setKadouTimeFrom4(pKadouTime.getKadouTimeFrom4()); setKadouTimeTo4(pKadouTime.getKadouTimeTo4()); break;
            case 5: setKadouTimeFrom5(pKadouTime.getKadouTimeFrom5()); setKadouTimeTo5(pKadouTime.getKadouTimeTo5()); break;
            default :
        }
    }

    String getTimeFrom(int pIdx){
        switch(pIdx){
            case 1:   return getKadouTimeFrom1();
            case 2:   return getKadouTimeFrom2();
            case 3:   return getKadouTimeFrom3();
            case 4:   return getKadouTimeFrom4();
            case 5:   return getKadouTimeFrom5();
            default : return null;
        }
    }

    String getTimeTo(int pIdx){
        switch(pIdx){
            case 1:   return getKadouTimeTo1();
            case 2:   return getKadouTimeTo2();
            case 3:   return getKadouTimeTo3();
            case 4:   return getKadouTimeTo4();
            case 5:   return getKadouTimeTo5();
            default : return null;

        }
    }

}
