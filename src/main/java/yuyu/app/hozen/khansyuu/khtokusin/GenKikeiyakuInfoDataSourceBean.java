package yuyu.app.hozen.khansyuu.khtokusin;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 特伸処理 - ●別契約（既契約） の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKikeiyakuInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vbtkkdispbtkyksyono;

    public String getVbtkkdispbtkyksyono() {
        return vbtkkdispbtkyksyono;
    }

    public void setVbtkkdispbtkyksyono(String pVbtkkdispbtkyksyono) {
        vbtkkdispbtkyksyono = pVbtkkdispbtkyksyono;
    }


    private C_YuukousyoumetuKbn vbtkkdispbtkykyuuksumtkbn;

    public C_YuukousyoumetuKbn getVbtkkdispbtkykyuuksumtkbn() {
        return vbtkkdispbtkykyuuksumtkbn;
    }

    public void setVbtkkdispbtkykyuuksumtkbn(C_YuukousyoumetuKbn pVbtkkdispbtkykyuuksumtkbn) {
        vbtkkdispbtkykyuuksumtkbn = pVbtkkdispbtkykyuuksumtkbn;
    }


    private C_Kykjyoutai vbtkkdispbtkykkykjyoutai;

    public C_Kykjyoutai getVbtkkdispbtkykkykjyoutai() {
        return vbtkkdispbtkykkykjyoutai;
    }

    public void setVbtkkdispbtkykkykjyoutai(C_Kykjyoutai pVbtkkdispbtkykkykjyoutai) {
        vbtkkdispbtkykkykjyoutai = pVbtkkdispbtkykkykjyoutai;
    }


    private BizDate vbtkkdispbtkykkykymd;

    public BizDate getVbtkkdispbtkykkykymd() {
        return vbtkkdispbtkykkykymd;
    }

    public void setVbtkkdispbtkykkykymd(BizDate pVbtkkdispbtkykkykymd) {
        vbtkkdispbtkykkykymd = pVbtkkdispbtkykkykymd;
    }


    private C_Syoumetujiyuu vbtkkdispbtkyksumetujiyuu;

    public C_Syoumetujiyuu getVbtkkdispbtkyksumetujiyuu() {
        return vbtkkdispbtkyksumetujiyuu;
    }

    public void setVbtkkdispbtkyksumetujiyuu(C_Syoumetujiyuu pVbtkkdispbtkyksumetujiyuu) {
        vbtkkdispbtkyksumetujiyuu = pVbtkkdispbtkyksumetujiyuu;
    }


    private BizDate vbtkkdispbtkyksyoumetuymd;

    public BizDate getVbtkkdispbtkyksyoumetuymd() {
        return vbtkkdispbtkyksyoumetuymd;
    }

    public void setVbtkkdispbtkyksyoumetuymd(BizDate pVbtkkdispbtkyksyoumetuymd) {
        vbtkkdispbtkyksyoumetuymd = pVbtkkdispbtkyksyoumetuymd;
    }


    private String vbtkkdispbtkyksyouhnnm;

    public String getVbtkkdispbtkyksyouhnnm() {
        return vbtkkdispbtkyksyouhnnm;
    }

    public void setVbtkkdispbtkyksyouhnnm(String pVbtkkdispbtkyksyouhnnm) {
        vbtkkdispbtkyksyouhnnm = pVbtkkdispbtkyksyouhnnm;
    }

}
