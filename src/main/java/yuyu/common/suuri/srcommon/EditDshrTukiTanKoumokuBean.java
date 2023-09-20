package yuyu.common.suuri.srcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;

/**
 * 数理 数理共通 Ｄ支払統計単項目編集用Bean
 */
public class EditDshrTukiTanKoumokuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer renno;

    private String skno;

    private String syono;

    private Integer seikyuurirekiNo;

    private String henkousikibetuKey;

    private BizDate syoriYmd;

    private C_SyoriKbn  syoriKbn;

    private C_Hrkkeiro hrkkeiro;

    private String syouhnCd;

    private Integer syouhnsdNo;

    private C_Kykjyoutai  kykjyoutai;

    private C_Syoumetujiyuu syoumetujiyuu;

    private BizDate kykymd;

    private BizDate yendthnkymd;

    private BizCurrency kihons;

    private BizNumber yoteiriritu;

    private BizDate denymd;

    private BizCurrency siharaid;

    private IT_KhHaitouKanri khHaitouKanri;

    private IT_KhTumitateDKanri khTumitateDKanri;

    private String gyoumuKousinsyaId;

    private String gyoumuKousinKinou;

    public EditDshrTukiTanKoumokuBean() {
        super();
    }

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public Integer getSeikyuurirekiNo() {
        return seikyuurirekiNo;
    }

    public void setSeikyuurirekiNo(Integer pSeikyuurirekiNo) {
        seikyuurirekiNo = pSeikyuurirekiNo;
    }

    public String getHenkousikibetuKey() {
        return henkousikibetuKey;
    }

    public void setHenkousikibetuKey(String pHenkousikibetuKey) {
        henkousikibetuKey = pHenkousikibetuKey;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public C_SyoriKbn  getSyoriKbn() {
        return syoriKbn;
    }

    public void setSyoriKbn(C_SyoriKbn  pSyoriKbn) {
        syoriKbn = pSyoriKbn;
    }

    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    public String getSyouhnCd() {
        return syouhnCd;
    }

    public void setSyouhnCd(String pSyouhnCd) {
        syouhnCd = pSyouhnCd;
    }

    public Integer getSyouhnsdNo() {
        return syouhnsdNo;
    }

    public void setSyouhnsdNo(Integer pSyouhnsdNo) {
        syouhnsdNo = pSyouhnsdNo;
    }

    public C_Kykjyoutai  getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai  pKykjyoutai) {
        kykjyoutai = pKykjyoutai;
    }

    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    public BizDate getKykymd() {
        return kykymd;
    }

    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkYmd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }

    public BizCurrency getKihons() {
        return kihons;
    }

    public void setKihons(BizCurrency pKihons) {
        kihons = pKihons;
    }

    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }

    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    public BizCurrency getSiharaid() {
        return siharaid;
    }

    public void setSiharaid(BizCurrency pSiharaid) {
        siharaid = pSiharaid;
    }

    public IT_KhHaitouKanri getKhHaitouKanri() {
        return khHaitouKanri;
    }

    public void setKhHaitouKanri(IT_KhHaitouKanri pKhHaitouKanri) {
        khHaitouKanri = pKhHaitouKanri;
    }

    public IT_KhTumitateDKanri getKhTumitateDKanri() {
        return khTumitateDKanri;
    }

    public void setKhTumitateDKanri(IT_KhTumitateDKanri pKhTumitateDKanri) {
        khTumitateDKanri = pKhTumitateDKanri;
    }

    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

}
