package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約 新契約共通 制御用商品属性取得入力Bean
 */
public class GetSyouhnZokuseiCtrlInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_HknsyuruiNo hknsyuruino;

    private Integer hknsyuruinosd;

    private String inputctrlSyouhnCd;

    private Integer inputctrlSyouhnSdNo;

    private C_UmuKbn mos2hyoujiumuKbn;

    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    public void setHknsyuruino(C_HknsyuruiNo pHksyuruino) {
        this.hknsyuruino = pHksyuruino;
    }

    public Integer getHknsyuruinosd() {
        return hknsyuruinosd;
    }

    public void setHknsyuruinosd(Integer pHknsyuruinosd) {
        this.hknsyuruinosd = pHknsyuruinosd;
    }

    public String getInputctrlSyouhnCd() {
        return inputctrlSyouhnCd;
    }

    public void setInputctrlSyouhnCd(String pInputctrlSyouhnCd) {
        this.inputctrlSyouhnCd = pInputctrlSyouhnCd;
    }

    public Integer getInputctrlSyouhnSdNo() {
        return inputctrlSyouhnSdNo;
    }

    public void setInputctrlSyouhnSdNo(Integer pInputctrlSyouhnSdNo) {
        this.inputctrlSyouhnSdNo = pInputctrlSyouhnSdNo;
    }

    public C_UmuKbn  getMos2hyoujiumuKbn() {
        return mos2hyoujiumuKbn;
    }

    public void setMos2hyoujiumuKbn(C_UmuKbn  pMos2hyoujiumuKbn) {
        mos2hyoujiumuKbn = pMos2hyoujiumuKbn;
    }
}