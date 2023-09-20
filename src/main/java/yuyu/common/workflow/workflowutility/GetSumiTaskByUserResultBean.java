package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;


/**
 * ユーザー別工程履歴取得 の処理結果クラスです。<br />
 */
public class GetSumiTaskByUserResultBean extends WorkListResultBean{


    private static final long serialVersionUID = 1L;

    public GetSumiTaskByUserResultBean() {
    }

    private List<GetSumiTaskByUserResultBean> processHistoryByUserBeanList = new ArrayList<GetSumiTaskByUserResultBean>();

    public List<GetSumiTaskByUserResultBean> getSumiTaskBeanList() {
        return processHistoryByUserBeanList;
    }

    public void setProcessHistoryBeanList(List<GetSumiTaskByUserResultBean> sumiTaskBeanList) {
        processHistoryByUserBeanList = sumiTaskBeanList;
    }

    private String jimutetuzukinm;

    public String getJimutetuzukinm() {
        return jimutetuzukinm;
    }

    public void setJimutetuzukinm(String pJimutetuzukinm) {
        jimutetuzukinm = pJimutetuzukinm;
    }


    private String GyoumuKey;

    public String getGyoumuKey() {
        return GyoumuKey;
    }

    public void setGyoumuKey(String pGyoumuKey) {
        GyoumuKey = pGyoumuKey;
    }


    private String syoritime;

    public String getSyoritime() {
        return syoritime;
    }

    public void setSyoritime(String pSyoritime) {
        syoritime = pSyoritime;
    }


    private String tasknm;

    public String getTasknm() {
        return tasknm;
    }

    public void setTasknm(String pTasknm) {
        tasknm = pTasknm;
    }

    private String hknsyuruiworklist;

    public String getHknsyuruiworklist() {
        return hknsyuruiworklist;
    }

    public void setHknsyuruiworklist(String pHknsyuruiworklist) {
        hknsyuruiworklist = pHknsyuruiworklist;
    }

    private String tratkiagnm1;

    public String getTratkiagnm1() {
        return tratkiagnm1;
    }

    public void setTratkiagnm1(String pTratkiagnm1) {
        tratkiagnm1 = pTratkiagnm1;
    }


    private String kyknmkn;

    public String getKyknmkn() {
        return kyknmkn;
    }

    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }


    private String kyknmkj;

    public String getKyknmkj() {
        return kyknmkj;
    }

    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }
}
