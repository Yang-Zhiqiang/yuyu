package yuyu.common.biz.syoruiitiran.syoruiitiranutil;

import java.util.ArrayList;
import java.util.List;

/**
 * 【書類情報一覧】書類情報一覧取得 の処理結果クラスです。<br />
 */
public class GetSyoruiJohoItiranListResultBean extends SyoruiListResultBean{

    public GetSyoruiJohoItiranListResultBean() {
    }

    private List<SyoruiJohoItiranBean> syoruiJohoItiranBeanList = new ArrayList<SyoruiJohoItiranBean>();

    public List<SyoruiJohoItiranBean> getSyoruiJohoItiranBeanList() {
        return syoruiJohoItiranBeanList;
    }

    public void setSyoruiJohoItiranBeanList(List<SyoruiJohoItiranBean> pSyoruiJohoItiranBeanList) {
        syoruiJohoItiranBeanList = pSyoruiJohoItiranBeanList;
    }
}
