package yuyu.app.hozen.khozen.khkeiyakuhenkou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SetkykKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 契約変更 - 　＜別契約＞ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBetukeiyakuListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SetkykKbn dispsetkykkbn;

    public C_SetkykKbn getDispsetkykkbn() {
        return dispsetkykkbn;
    }

    public void setDispsetkykkbn(C_SetkykKbn pDispsetkykkbn) {
        dispsetkykkbn = pDispsetkykkbn;
    }


    private String dispbtkyksyono;

    public String getDispbtkyksyono() {
        return dispbtkyksyono;
    }

    public void setDispbtkyksyono(String pDispbtkyksyono) {
        dispbtkyksyono = pDispbtkyksyono;
    }


    private C_YuukousyoumetuKbn dispbtkykyuukousyoumetukbn;

    public C_YuukousyoumetuKbn getDispbtkykyuukousyoumetukbn() {
        return dispbtkykyuukousyoumetukbn;
    }

    public void setDispbtkykyuukousyoumetukbn(C_YuukousyoumetuKbn pDispbtkykyuukousyoumetukbn) {
        dispbtkykyuukousyoumetukbn = pDispbtkykyuukousyoumetukbn;
    }


    private C_Kykjyoutai dispbtkykkykjyoutai;

    public C_Kykjyoutai getDispbtkykkykjyoutai() {
        return dispbtkykkykjyoutai;
    }

    public void setDispbtkykkykjyoutai(C_Kykjyoutai pDispbtkykkykjyoutai) {
        dispbtkykkykjyoutai = pDispbtkykkykjyoutai;
    }


    private BizDate dispbtkykkykymd;

    public BizDate getDispbtkykkykymd() {
        return dispbtkykkykymd;
    }

    public void setDispbtkykkykymd(BizDate pDispbtkykkykymd) {
        dispbtkykkykymd = pDispbtkykkykymd;
    }


    private C_Syoumetujiyuu dispbtkyksyoumetujiyuu;

    public C_Syoumetujiyuu getDispbtkyksyoumetujiyuu() {
        return dispbtkyksyoumetujiyuu;
    }

    public void setDispbtkyksyoumetujiyuu(C_Syoumetujiyuu pDispbtkyksyoumetujiyuu) {
        dispbtkyksyoumetujiyuu = pDispbtkyksyoumetujiyuu;
    }


    private BizDate dispbtkyksyoumetuymd;

    public BizDate getDispbtkyksyoumetuymd() {
        return dispbtkyksyoumetuymd;
    }

    public void setDispbtkyksyoumetuymd(BizDate pDispbtkyksyoumetuymd) {
        dispbtkyksyoumetuymd = pDispbtkyksyoumetuymd;
    }


    private String dispbtkyksyouhnnm;

    public String getDispbtkyksyouhnnm() {
        return dispbtkyksyouhnnm;
    }

    public void setDispbtkyksyouhnnm(String pDispbtkyksyouhnnm) {
        dispbtkyksyouhnnm = pDispbtkyksyouhnnm;
    }

}
