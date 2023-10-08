package yuyu.app.hozen.khozen.khsyouraikaiyakuhenreikin;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_UmuKbn;

/**
 * 将来解約返戻金照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhSyouraiKaiyakuhenreikinUiBean extends GenKhSyouraiKaiyakuhenreikinUiBean implements CheckYuukouJyoutaiExecUiBeanParam {

    private static final long serialVersionUID = 2L;

    private String syusyouhncd;

    private String[] arrMonth;

    private int syouhnsdno;

    private C_HknkknsmnKbn hknkknsmnkbn;

    private C_HrkkknsmnKbn hrkkknsmnKbn;

    private String ryouritusdno;

    private BizNumber yoteiriritu;

    private C_Hrkkaisuu hrkkaisuu;

    private BizDate kouryokuhasseiymd;

    private BizDate kwsratekjymd;

    private int sisanbiIndexY;

    private int sisanbiIndexM;

    private String [] monthStr;

    private String tyouhyoukey;

    private BizNumber kyksjkkktyouseiriritu;

    private Boolean warnFlag;

    private BizNumber tumitateRiritu;

    private int syohinHanteiKbn;

    private C_Kykjyoutai kykjyoutai;

    private BizNumber yoteirrthendohosyurrt;

    private C_UmuKbn itijibrumu;

    private C_UmuKbn syuusinhknumu;

    private C_UmuKbn heijyunbaraiumu;

    private BizDateYM tmttkntaisyouymkingk;

    private BizCurrency ptmttkngk;

    private BizCurrency kihrkmpstgk;

    private BizDate fstprsymd;

    private BizCurrency pharaikomisougaku;

    private Integer dai1hknkkn;

    public String[] getMonthStr() {
        return monthStr;
    }
    public void setMonthStr(String[] pMonthStr) {
        this.monthStr = pMonthStr;
    }
    public BizDate getKwsratekjymd() {
        return kwsratekjymd;
    }
    public void setKwsratekjymd(BizDate pKwsratekjymd) {
        this.kwsratekjymd = pKwsratekjymd;
    }
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }
    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        this.kouryokuhasseiymd = pKouryokuhasseiymd;
    }
    public int getSyouhnsdno() {
        return syouhnsdno;
    }
    public void setSyouhnsdno(int pSyouhnsdno) {
        this.syouhnsdno = pSyouhnsdno;
    }
    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }
    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        this.hknkknsmnkbn = pHknkknsmnkbn;
    }
    public C_HrkkknsmnKbn getHrkkknsmnKbn() {
        return hrkkknsmnKbn;
    }
    public void setHrkkknsmnKbn(C_HrkkknsmnKbn pHrkkknsmnKbn) {
        this.hrkkknsmnKbn = pHrkkknsmnKbn;
    }
    public String getRyouritusdno() {
        return ryouritusdno;
    }
    public void setRyouritusdno(String pRyouritusdno) {
        this.ryouritusdno = pRyouritusdno;
    }
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        this.yoteiriritu = pYoteiriritu;
    }
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }
    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        this.hrkkaisuu = pHrkkaisuu;
    }


    public KhSyouraiKaiyakuhenreikinUiBean() {
    }

    public String getSyusyouhncd() {
        return syusyouhncd;
    }

    public void setSyusyouhncd(String pSyusyouhncd) {
        this.syusyouhncd = pSyusyouhncd;
    }

    public String[] getArrMonth() {
        return arrMonth;
    }

    public void setArrMonth(String[] pArrMonth) {
        this.arrMonth = pArrMonth;
    }


    public int getSisanbiIndexY() {
        return sisanbiIndexY;
    }

    public void setSisanbiIndexY(int pSisanbiIndexY) {
        sisanbiIndexY = pSisanbiIndexY;
    }

    public int getSisanbiIndexM() {
        return sisanbiIndexM;
    }

    public void setSisanbiIndexM(int pSisanbiIndexM) {
        sisanbiIndexM = pSisanbiIndexM;
    }

    public String getTyouhyoukey() {
        return tyouhyoukey;
    }

    public void setTyouhyoukey(String pTyouhyoukey) {
        tyouhyoukey = pTyouhyoukey;
    }

    public BizNumber getKyksjkkktyouseiriritu() {
        return kyksjkkktyouseiriritu;
    }

    public void setKyksjkkktyouseiriritu(BizNumber pKyksjkkktyouseiriritu) {
        kyksjkkktyouseiriritu = pKyksjkkktyouseiriritu;
    }

    public Boolean getWarnFlag() {
        return warnFlag;
    }

    public void setWarnFlag(Boolean pWarnFlag) {
        warnFlag = pWarnFlag;
    }

    public BizNumber getTumitateRiritu() {
        return tumitateRiritu;
    }

    public void setTumitateRiritu(BizNumber pTumitateRiritu) {
        tumitateRiritu = pTumitateRiritu;
    }

    public int getSyohinHanteiKbn() {
        return syohinHanteiKbn;
    }

    public void setSyohinHanteiKbn(int pSyohinHanteiKbn) {
        syohinHanteiKbn = pSyohinHanteiKbn;
    }

    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        this.kykjyoutai = pKykjyoutai;
    }

    public BizNumber getYoteirrthendohosyurrt() {
        return yoteirrthendohosyurrt;
    }

    public void setYoteirrthendohosyurrt(BizNumber pYoteirrthendohosyurrt) {
        this.yoteirrthendohosyurrt = pYoteirrthendohosyurrt;
    }

    public C_UmuKbn getItijibrumu() {
        return itijibrumu;
    }

    public void setItijibrumu(C_UmuKbn pItijibrumu) {
        this.itijibrumu = pItijibrumu;
    }

    public C_UmuKbn getSyuusinhknumu() {
        return syuusinhknumu;
    }

    public void setSyuusinhknumu(C_UmuKbn pSyuusinhknumu) {
        this.syuusinhknumu = pSyuusinhknumu;
    }

    public C_UmuKbn getHeijyunbaraiumu() {
        return heijyunbaraiumu;
    }

    public void setHeijyunbaraiumu(C_UmuKbn pHeijyunbaraiumu) {
        this.heijyunbaraiumu = pHeijyunbaraiumu;
    }

    public BizDateYM getTmttkntaisyouymkingk() {
        return tmttkntaisyouymkingk;
    }

    public void setTmttkntaisyouymkingk(BizDateYM pTmttkntaisyouymkingk) {
        this.tmttkntaisyouymkingk = pTmttkntaisyouymkingk;
    }

    public BizCurrency getPtmttkngk() {
        return ptmttkngk;
    }

    public void setPtmttkngk(BizCurrency pPtmttkngk) {
        this.ptmttkngk = pPtmttkngk;
    }

    public BizCurrency getKihrkmpstgk() {
        return kihrkmpstgk;
    }

    public void setKihrkmpstgk(BizCurrency pKihrkmpstgk) {
        this.kihrkmpstgk = pKihrkmpstgk;
    }

    public BizDate getFstprsymd() {
        return fstprsymd;
    }

    public void setFstprsymd(BizDate pFstprsymd) {
        this.fstprsymd = pFstprsymd;
    }

    public BizCurrency getPharaikomisougaku() {
        return pharaikomisougaku;
    }

    public void setPharaikomisougaku(BizCurrency pPharaikomisougaku) {
        this.pharaikomisougaku = pPharaikomisougaku;
    }

    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }
}
