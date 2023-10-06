package yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai;

import java.io.Serializable;

/**
 * 入力差異照会 機能間遷移用Beanクラスです。<br />
 */
public class SkNyuuryokuSaiSyoukaiRenkeiInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String mosno;

    private String aitemosno;

    private String[] nrksouikm;

    private String[] itijinrk;

    private String[] nijinrk;

    public SkNyuuryokuSaiSyoukaiRenkeiInfo() {
    }

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    public String getAitemosno() {
        return aitemosno;
    }

    public void setAitemosno(String pAitemosno) {
        aitemosno = pAitemosno;
    }

    public String[] getNrksouikm() {
        return nrksouikm;
    }

    public void setNrksouikm(String[] pNrksouikm) {
        nrksouikm = pNrksouikm;
    }

    public String[] getItijinrk() {
        return itijinrk;
    }

    public void setItijinrk(String[] pItijinrk) {
        itijinrk = pItijinrk;
    }

    public String[] getNijinrk() {
        return nijinrk;
    }

    public void setNijinrk(String[] pNijinrk) {
        nijinrk = pNijinrk;
    }
}
