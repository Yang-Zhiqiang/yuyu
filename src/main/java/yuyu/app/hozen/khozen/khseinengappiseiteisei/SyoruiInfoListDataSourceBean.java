package yuyu.app.hozen.khozen.khseinengappiseiteisei;

import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;

/**
 * 被保険者生年月日・性訂正 - ●書類情報一覧 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
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
