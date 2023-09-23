package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HnskariyuuKbn;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TyokusouhtkekKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 保険証券作成用パラメータ
 */
public class EditHokenSyoukenParam {

    private C_SyoukensaihkKbn syoukensaihkKbn = C_SyoukensaihkKbn.BLNK;

    private C_InsizeiShryouhiKbn insizeiShryouhiKbn = C_InsizeiShryouhiKbn.YOU;

    private C_StdrsktkyhnkKbn stdrsktkyhnkKbn = C_StdrsktkyhnkKbn.BLNK;

    private C_UmuKbn kariukeUmu = C_UmuKbn.NONE;

    private C_UmuKbn hukusuuUmu = C_UmuKbn.NONE;

    private BizDate calcKijyunYmd;

    private C_HnskariyuuKbn hnskaRiyuu1 = C_HnskariyuuKbn.BLNK;

    private C_HnskariyuuKbn hnskaRiyuu2 = C_HnskariyuuKbn.BLNK;

    private C_TantouCdKbn tantouCd = C_TantouCdKbn.DAIRITENJIMUKANRI;

    private C_TyokusouhtkekKbn trkkzk1thkk = C_TyokusouhtkekKbn.BLNK;

    private C_TyokusouhtkekKbn trkkzk2thkk = C_TyokusouhtkekKbn.BLNK;

    private C_TyokusouhtkekKbn kykdairithkk = C_TyokusouhtkekKbn.BLNK;

    private C_TyokusouhtkekKbn stdrskthkk = C_TyokusouhtkekKbn.BLNK;

    public EditHokenSyoukenParam() {
        super();
    }

    public C_SyoukensaihkKbn getSyoukenSaihk() {
        return syoukensaihkKbn;
    }

    public void setSyoukenSaihk(C_SyoukensaihkKbn pSyoukensaihkKbn) {
        syoukensaihkKbn = pSyoukensaihkKbn;
    }

    public C_InsizeiShryouhiKbn getInsizeiShryouhi() {
        return insizeiShryouhiKbn;
    }

    public void setInsizeiShryouhi(C_InsizeiShryouhiKbn pInsizeiShryouhiKbn) {
        insizeiShryouhiKbn = pInsizeiShryouhiKbn;
    }

    public C_StdrsktkyhnkKbn getStdrsktkyhnkKbn() {
        return stdrsktkyhnkKbn;
    }

    public void setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn pStdrsktkyhnkKbn) {
        stdrsktkyhnkKbn = pStdrsktkyhnkKbn;
    }

    public C_UmuKbn getKariukeUmu() {
        return kariukeUmu;
    }

    public void setKariukeUmu(C_UmuKbn pKariukeUmu) {
        kariukeUmu = pKariukeUmu;
    }

    public C_UmuKbn getHukusuuUmu() {
        return hukusuuUmu;
    }

    public void setHukusuuUmu(C_UmuKbn pHukusuuUmu) {
        hukusuuUmu = pHukusuuUmu;
    }

    public BizDate getCalckijyunYMD() {
        return calcKijyunYmd;
    }

    public void setCalckijyunYMD(BizDate pCalcKijyunYmd) {
        calcKijyunYmd = pCalcKijyunYmd;
    }

    public C_HnskariyuuKbn getHnskariyuu1() {
        return hnskaRiyuu1;
    }

    public void setHnskariyuu1(C_HnskariyuuKbn pHnskariyuu1) {
        hnskaRiyuu1 = pHnskariyuu1;
    }

    public C_HnskariyuuKbn getHnskariyuu2() {
        return hnskaRiyuu2;
    }

    public void setHnskariyuu2(C_HnskariyuuKbn pHnskariyuu2) {
        hnskaRiyuu2 = pHnskariyuu2;
    }

    public C_TantouCdKbn getTantoucd() {
        return tantouCd;
    }

    public void setTantoucd(C_TantouCdKbn pTantoucd) {
        tantouCd = pTantoucd;
    }

    public C_TyokusouhtkekKbn getTrkkzk1thkk() {
        return trkkzk1thkk;
    }

    public void setTrkkzk1thkk(C_TyokusouhtkekKbn trkkzk1thkk) {
        this.trkkzk1thkk = trkkzk1thkk;
    }

    public C_TyokusouhtkekKbn getTrkkzk2thkk() {
        return trkkzk2thkk;
    }

    public void setTrkkzk2thkk(C_TyokusouhtkekKbn trkkzk2thkk) {
        this.trkkzk2thkk = trkkzk2thkk;
    }

    public C_TyokusouhtkekKbn getKykdairithkk() {
        return kykdairithkk;
    }

    public void setKykdairithkk(C_TyokusouhtkekKbn kykdairithkk) {
        this.kykdairithkk = kykdairithkk;
    }

    public C_TyokusouhtkekKbn getStdrskthkk() {
        return stdrskthkk;
    }

    public void setStdrskthkk(C_TyokusouhtkekKbn stdrskthkk) {
        this.stdrskthkk = stdrskthkk;
    }
}
