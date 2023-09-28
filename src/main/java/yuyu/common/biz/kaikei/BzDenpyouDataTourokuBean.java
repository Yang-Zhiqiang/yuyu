package yuyu.common.biz.kaikei;

import java.util.List;

import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * （共通）伝票データ情報登録BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class BzDenpyouDataTourokuBean extends GenBzDenpyouDataTourokuBean {

    private static final long serialVersionUID = 1L;

    private C_Tuukasyu ibKyktuukasyu;

    private C_ShrhousiteiKbn ibShrhousiteiKbn;

    private String ibSyusyouhncd;

    private Integer ibSyouhnsdno;

    private List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList;

    public BzDenpyouDataTourokuBean() {

        super.setIbDensyorisyousaikbn(C_DenSyorisyousaiKbn.BLNK);
    }

    public C_Tuukasyu getIbKyktuukasyu() {
        return ibKyktuukasyu;
    }

    public void setIbKyktuukasyu(C_Tuukasyu pIbKyktuukasyu) {
        ibKyktuukasyu = pIbKyktuukasyu;
    }

    public C_ShrhousiteiKbn getIbShrhousiteiKbn() {
        return ibShrhousiteiKbn;
    }

    public void setIbShrhousiteiKbn(C_ShrhousiteiKbn pIbShrhousiteiKbn) {
        ibShrhousiteiKbn = pIbShrhousiteiKbn;
    }

    public String getIbSyouhncd() {
        return ibSyusyouhncd;
    }

    public void setIbSyouhncd(String pIbSyusyouhncd) {
        ibSyusyouhncd = pIbSyusyouhncd;
    }

    public Integer getIbSyouhnsdno() {
        return ibSyouhnsdno;
    }

    public void setIbSyouhnsdno(Integer pIbSyouhnsdno) {
        ibSyouhnsdno = pIbSyouhnsdno;
    }

    public List<BzSiwakeMeisaiBean> getBzSiwakeMeisaiBeanList() {
        return bzSiwakeMeisaiBeanList;
    }

    public void setBzSiwakeMeisaiBeanList(List<BzSiwakeMeisaiBean> pBzSiwakemeisaiBeanList) {

        bzSiwakeMeisaiBeanList = pBzSiwakemeisaiBeanList;
    }

}
