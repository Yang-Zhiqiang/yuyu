package yuyu.def.suuri.bean.report;

import java.util.List;

/**
 * （数理）配当金明細リスト帳票DSBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SrHaitoukinMeisaiListDataSourceBean extends GenSrHaitoukinMeisaiListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinmeisailistsubdatasourcebeanList;

    public List<SrHaitoukinMeisaiListSubDataSourceBean> getSrHaitoukinmeisailistsubdatasourcebeanList(){
        return srHaitoukinmeisailistsubdatasourcebeanList;
    }

    public void setSrHaitoukinmeisailistsubdatasourcebeanList(List<SrHaitoukinMeisaiListSubDataSourceBean> pSrHaitoukinmeisailistsubdatasourcebeanList) {
        srHaitoukinmeisailistsubdatasourcebeanList = pSrHaitoukinmeisailistsubdatasourcebeanList;
    }

    public SrHaitoukinMeisaiListDataSourceBean() {
    }

}
