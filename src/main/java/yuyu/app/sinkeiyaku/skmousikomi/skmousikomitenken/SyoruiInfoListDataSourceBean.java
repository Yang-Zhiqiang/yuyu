package yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken;

import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;

/**
 * 申込点検 - ●書類情報一覧 の 行データBean クラスです。<br />
 */
public class SyoruiInfoListDataSourceBean extends GenSyoruiInfoListDataSourceBean implements
SyoruiInfoItiranDataSourceBeanCommonParam {

    private static final long serialVersionUID = 1L;

    private String torikomiSyoruiCd;

    public SyoruiInfoListDataSourceBean() {
    }

    @Override
    public String getTorikomiSyoruiCd() {
        return torikomiSyoruiCd;
    }

    @Override
    public void setTorikomiSyoruiCd(String pTorikomiSyoruiCd) {
        torikomiSyoruiCd = pTorikomiSyoruiCd;
    }

}
