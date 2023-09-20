package yuyu.common.workflow.workflowutility;

/**
 * 処理残件数保管_過去実績サマリ分 の処理結果クラスです。<br />
 */
public class MakeCountOfKakoJissekiTaskSummaryResultBean extends WorkListResultBean {

    private static final long serialVersionUID = 1L;

    public MakeCountOfKakoJissekiTaskSummaryResultBean() {
    }

    private String errHasseiSyoriNm;

    public String getErrHasseiSyoriNm() {
        return errHasseiSyoriNm;
    }

    public void setErrHasseiSyoriNm(String pErrHasseiSyoriNm) {
        errHasseiSyoriNm = pErrHasseiSyoriNm;
    }

    private String kensuuOfSyoriKensuuHokanJimu;

    public String getKensuuOfSyoriKensuuHokanJimu() {
        return kensuuOfSyoriKensuuHokanJimu;
    }

    public void setKensuuOfSyoriKensuuHokanJimu(String pKensuuOfSyoriKensuuHokanJimu) {
        kensuuOfSyoriKensuuHokanJimu = pKensuuOfSyoriKensuuHokanJimu;
    }

    private String kensuuOfSyoriKensuuHokanTask;

    public String getKensuuOfSyoriKensuuHokanTask() {
        return kensuuOfSyoriKensuuHokanTask;
    }

    public void setKensuuOfSyoriKensuuHokanTask(String pKensuuOfSyoriKensuuHokanTask) {
        kensuuOfSyoriKensuuHokanTask = pKensuuOfSyoriKensuuHokanTask;
    }

    private String kensuuOfJimutetuzukiRireki;

    public String getKensuuOfJimutetuzukiRireki() {
        return kensuuOfJimutetuzukiRireki;
    }

    public void setKensuuOfJimutetuzukiRireki(String pKensuuOfJimutetuzukiRireki) {
        kensuuOfJimutetuzukiRireki = pKensuuOfJimutetuzukiRireki;
    }

    private String kensuuOfJimutetuzukiTaskRireki;

    public String getKensuuOfJimutetuzukiTaskRireki() {
        return kensuuOfJimutetuzukiTaskRireki;
    }

    public void setKensuuOfJimutetuzukiTaskRireki(String pKensuuOfJimutetuzukiTaskRireki) {
        kensuuOfJimutetuzukiTaskRireki = pKensuuOfJimutetuzukiTaskRireki;
    }
}
