package yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku;

import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約不備登録 - hubiList2 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class HubiList2DataSourceBean extends GenHubiList2DataSourceBean {

    private static final long serialVersionUID = 1L;

    public HubiList2DataSourceBean() {
    }

    private C_UmuKbn tyoubunflg;

    public C_UmuKbn getTyoubunflg() {
        return tyoubunflg;
    }

    public void setTyoubunflg(Boolean pTyoubunflg) {

        if (pTyoubunflg) {
            tyoubunflg = C_UmuKbn.ARI;
        }
        else {
            tyoubunflg = C_UmuKbn.NONE;
        }
    }

    public void setTyoubunflg(C_UmuKbn pTyoubunflg) {
        tyoubunflg = pTyoubunflg;
    }

    public void setDispinputtyoubunflg(C_UmuKbn pDispinputtyoubunflg) {

        if (C_UmuKbn.ARI.eq(pDispinputtyoubunflg)) {
            super.setDispinputtyoubunflg(true);

        }
        else {
            super.setDispinputtyoubunflg(false);
        }
    }

    @Override
    public void setDispinputtyoubunflg(Boolean pDispinputtyoubunflg) {
        super.setDispinputtyoubunflg(pDispinputtyoubunflg);
        C_UmuKbn kbn = pDispinputtyoubunflg ? C_UmuKbn.ARI : C_UmuKbn.NONE;
        setTyoubunflg(kbn);
    }

}
