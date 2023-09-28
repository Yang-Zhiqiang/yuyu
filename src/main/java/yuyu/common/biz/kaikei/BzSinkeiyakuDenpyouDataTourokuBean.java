package yuyu.common.biz.kaikei;

import java.util.List;

import javax.validation.constraints.NotNull;

import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * （共通）新契約伝票データ情報登録BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class BzSinkeiyakuDenpyouDataTourokuBean extends GenBzSinkeiyakuDenpyouDataTourokuBean {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String ibMosno;

    @NotNull
    private C_Tuukasyu ibKyktuukasyu;

    private List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList;

    private C_ShrhousiteiKbn ibShrhousiteiKbn;

    private Integer ibSyouhnsdno;

    public BzSinkeiyakuDenpyouDataTourokuBean() {
    }

    public String getIbMosno() {
        return ibMosno;
    }

    public void setIbMosno(String pIbMosno) {
        ibMosno = pIbMosno;
    }

    public C_Tuukasyu getIbKyktuukasyu() {
        return ibKyktuukasyu;
    }

    public void setIbKyktuukasyu(C_Tuukasyu pIbKyktuukasyu) {
        ibKyktuukasyu = pIbKyktuukasyu;
    }

    public List<BzSiwakeMeisaiBean> getBzSiwakeMeisaiBeanList() {
        return bzSiwakeMeisaiBeanList;
    }

    public void setBzSiwakeMeisaiBeanList(List<BzSiwakeMeisaiBean> pBzSiwakemeisaiBeanList) {

        bzSiwakeMeisaiBeanList = pBzSiwakemeisaiBeanList;
    }

    public C_ShrhousiteiKbn getIbShrhousiteiKbn() {
        return ibShrhousiteiKbn;
    }

    public void setIbShrhousiteiKbn(C_ShrhousiteiKbn pIbShrhousiteiKbn) {
        ibShrhousiteiKbn = pIbShrhousiteiKbn;
    }

    public Integer getIbSyouhnsdno() {
        return ibSyouhnsdno;
    }

    public void setIbSyouhnsdno(Integer pIbSyouhnsdno) {
        ibSyouhnsdno = pIbSyouhnsdno;
    }

}
