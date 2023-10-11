package yuyu.app.siharai.sisyoukai.sishrrirekisyoukai;

import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
/**
 * 支払履歴照会 - ●書類情報 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SyoruiInfoListDataSourceBean extends GenSyoruiInfoListDataSourceBean implements SyoruiInfoItiranDataSourceBeanCommonParam{

    private String torikomiSyoruiCd;

    private static final long serialVersionUID = 1L;

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