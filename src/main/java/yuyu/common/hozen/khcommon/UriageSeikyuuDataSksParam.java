package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;

/**
 * 契約保全 契約保全共通 売上請求データ作成パラメータ
 */
public class UriageSeikyuuDataSksParam {

    public UriageSeikyuuDataSksParam(){
        super();
    }

    private String kessaiyouno ;

    private BizDate uriagenengappi;

    private BizDate  syoriYmd;

    private BizCurrency  uriagegk;

    private C_NyknaiyouKbn nyknaiyoukbn;

    private BizDateYM jyuutouym;

    private IT_AnsyuRireki ansyuRirekiTblentity;

    private IT_AnsyuKihon ansyuKihonTblentity;

    public String getKessaiyouno() {
        return kessaiyouno;
    }
    public void setKessaiyouno(String pKessaiyouno) {
        this.kessaiyouno = pKessaiyouno;
    }

    public BizDate getUriagenengappi() {
        return uriagenengappi;
    }

    public void setUriagenengappi(BizDate pUriagenengappi) {
        this.uriagenengappi = pUriagenengappi;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        this.syoriYmd = pSyoriYmd;
    }

    public BizCurrency getUriagegk() {
        return uriagegk;
    }

    public void setUriagegk(BizCurrency pUriagegk) {
        this.uriagegk = pUriagegk;
    }

    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        this.nyknaiyoukbn = pNyknaiyoukbn;
    }

    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    public void setJyuutouym(BizDateYM pJyuutouym) {
        this.jyuutouym = pJyuutouym;
    }

    public IT_AnsyuRireki getAnsyuRirekiTblentity() {
        return ansyuRirekiTblentity;
    }

    public void setAnsyuRirekiTblentity(IT_AnsyuRireki pAnsyuRirekiTblentity) {
        this.ansyuRirekiTblentity = pAnsyuRirekiTblentity;
    }

    public IT_AnsyuKihon getAnsyuKihonTblentity() {
        return ansyuKihonTblentity;
    }

    public void setAnsyuKihonTblentity(IT_AnsyuKihon pAnsyuKihonTblentity) {
        this.ansyuKihonTblentity = pAnsyuKihonTblentity;
    }


}
