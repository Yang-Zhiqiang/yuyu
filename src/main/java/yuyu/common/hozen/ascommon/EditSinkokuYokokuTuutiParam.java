package yuyu.common.hozen.ascommon;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TekiyouseidoKbn;

/**
 * 契約保全 案内収納共通 申告予告通知作成用パラメータ
 */
public class EditSinkokuYokokuTuutiParam {

    private String syoumeiNendo;

    private C_TekiyouseidoKbn tekiyouseidoKbn;

    private C_Hrkkaisuu hrkKaisuu;

    private BizDateYM pjyutoustartyoteiym;

    private BizDateYM pjyutouendyoteiym;

    private BizCurrency newippanykkp;

    private BizCurrency newippanykkhaitoukin;

    private BizCurrency newippanykksyoumeigk;

    private BizCurrency newiryouykkp;

    private BizCurrency newiryouykkhaitoukin;

    private BizCurrency newiryouykksyoumeigk;

    private BizCurrency newnenkinykkp;

    private BizCurrency newnenkinykkhaitoukin;

    private BizCurrency newnenkinykksyoumeigk;

    public EditSinkokuYokokuTuutiParam() {
        super();
    }

    public String getSyoumeiNendo() {
        return syoumeiNendo;
    }

    public void setSyoumeiNendo(String pSyoumeiNendo) {
        syoumeiNendo = pSyoumeiNendo;
    }

    public C_TekiyouseidoKbn getTekiyouseidokbn() {
        return tekiyouseidoKbn;
    }

    public void setTekiyouseidokbn(C_TekiyouseidoKbn pTekiyouseidokbn) {
        tekiyouseidoKbn = pTekiyouseidokbn;
    }

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkKaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkKaisuu = pHrkkaisuu;
    }

    public BizDateYM getPjyutoustartyoteiym() {
        return pjyutoustartyoteiym;
    }

    public void setPjyutoustartyoteiym(BizDateYM pPjyutoustartyoteiym) {
        pjyutoustartyoteiym = pPjyutoustartyoteiym;
    }

    public BizDateYM getPjyutouendyoteiym() {
        return pjyutouendyoteiym;
    }

    public void setPjyutouendyoteiym(BizDateYM pPjyutouendyoteiym) {
        pjyutouendyoteiym = pPjyutouendyoteiym;
    }

    public BizCurrency getNewippanykkp() {
        return newippanykkp;
    }

    public void setNewippanykkp(BizCurrency pNewippanykkp) {
        newippanykkp = pNewippanykkp;
    }

    public BizCurrency getNewippanykkhaitoukin() {
        return newippanykkhaitoukin;
    }

    public void setNewippanykkhaitoukin(BizCurrency pNewippanykkhaitoukin) {
        newippanykkhaitoukin = pNewippanykkhaitoukin;
    }
    public BizCurrency getNewippanykksyoumeigk() {
        return newippanykksyoumeigk;
    }

    public void setNewippanykksyoumeigk(BizCurrency pNewippanykksyoumeigk) {
        newippanykksyoumeigk = pNewippanykksyoumeigk;
    }

    public BizCurrency getNewiryouykkp() {
        return newiryouykkp;
    }

    public void setNewiryouykkp(BizCurrency pNewiryouykkp) {
        newiryouykkp = pNewiryouykkp;
    }

    public BizCurrency getNewiryouykkhaitoukin() {
        return newiryouykkhaitoukin;
    }

    public void setNewiryouykkhaitoukin(BizCurrency pNewiryouykkhaitoukin) {
        newiryouykkhaitoukin = pNewiryouykkhaitoukin;
    }

    public BizCurrency getNewiryouykksyoumeigk() {
        return newiryouykksyoumeigk;
    }

    public void setNewiryouykksyoumeigk(BizCurrency pNewiryouykksyoumeigk) {
        newiryouykksyoumeigk = pNewiryouykksyoumeigk;
    }
    public BizCurrency getNewnenkinykkp() {
        return newnenkinykkp;
    }

    public void setNewnenkinykkp(BizCurrency pNewnenkinykkp) {
        newnenkinykkp = pNewnenkinykkp;
    }
    public BizCurrency getNewnenkinykkhaitoukin() {
        return newnenkinykkhaitoukin;
    }

    public void setNewnenkinykkhaitoukin(BizCurrency pNewnenkinykkhaitoukin) {
        newnenkinykkhaitoukin = pNewnenkinykkhaitoukin;
    }
    public BizCurrency getNewnenkinykksyoumeigk() {
        return newnenkinykksyoumeigk;
    }

    public void setNewnenkinykksyoumeigk(BizCurrency pNewnenkinykksyoumeigk) {
        newnenkinykksyoumeigk = pNewnenkinykksyoumeigk;
    }
}
