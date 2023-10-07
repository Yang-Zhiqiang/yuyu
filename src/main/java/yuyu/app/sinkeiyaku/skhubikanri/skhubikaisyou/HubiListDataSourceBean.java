package yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou;

import yuyu.def.classification.C_KaisyoutaisyouKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約不備解消 - ●不備一覧 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class HubiListDataSourceBean extends GenHubiListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private Integer renno3keta;

    private C_UmuKbn tyoubunflg;

    public HubiListDataSourceBean() {
    }

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

    public C_UmuKbn getTyoubunflg() {
        return tyoubunflg;
    }

    public void setTyoubunflg(C_UmuKbn pTyoubunflg) {
        tyoubunflg = pTyoubunflg;
    }

    @Override
    public void setDispkaisyoutaisyou(Boolean pDispkaisyoutaisyou) {
        super.setDispkaisyoutaisyou(pDispkaisyoutaisyou);
        C_KaisyoutaisyouKbn kbn = pDispkaisyoutaisyou ? C_KaisyoutaisyouKbn.TAISYOU : C_KaisyoutaisyouKbn.TAISYOUGAI;
        super.setDispkaisyoutaisyoukbn(kbn);
    }

}
